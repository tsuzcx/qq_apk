package com.tencent.mm.msgsubscription.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.plugin.comm.c.e;
import com.tencent.mm.plugin.comm.c.f;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.SelectPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.g;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

public class AppBrandAuthorizeSubscribeMsgDetailUI
  extends MMPreference
{
  private boolean moD;
  private f mrf;
  private SubscribeMsgTmpItem mrg;
  private SelectPreference mrh;
  private SelectPreference mri;
  private SelectPreference mrj;
  private SelectPreference mrk;
  private SelectPreference mrl;
  final AtomicLong mrm;
  
  public AppBrandAuthorizeSubscribeMsgDetailUI()
  {
    AppMethodBeat.i(188657);
    this.mrg = null;
    this.mrk = null;
    this.mrl = null;
    this.mrm = new AtomicLong(0L);
    AppMethodBeat.o(188657);
  }
  
  private void bsz()
  {
    AppMethodBeat.i(188669);
    if ((this.mrl != null) && (this.mrl != this.mrk))
    {
      Log.i("MicroMsg.AppBrandAuthorizeDetailUI", "setResData, has changed, state:%s", new Object[] { this.mrl.mKey });
      Object localObject = this.mrl.mKey;
      int i;
      switch (((String)localObject).hashCode())
      {
      default: 
        i = -1;
        label94:
        switch (i)
        {
        }
        break;
      }
      for (;;)
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("key_data", this.mrg);
        ((Intent)localObject).putExtra("key_status_subscribed", this.moD);
        setResult(-1, (Intent)localObject);
        AppMethodBeat.o(188669);
        return;
        if (!((String)localObject).equals("preference_key_no_accept")) {
          break;
        }
        i = 0;
        break label94;
        if (!((String)localObject).equals("preference_key_accept")) {
          break;
        }
        i = 1;
        break label94;
        if (!((String)localObject).equals("preference_key_accept_allow_play_voice")) {
          break;
        }
        i = 2;
        break label94;
        this.mrg.mnH = false;
        this.moD = false;
        continue;
        this.mrg.mnH = false;
        this.moD = true;
        continue;
        this.mrg.mnH = true;
        this.moD = true;
      }
    }
    setResult(0, null);
    AppMethodBeat.o(188669);
  }
  
  public int getResourceId()
  {
    return -1;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(188664);
    bsz();
    super.onBackPressed();
    AppMethodBeat.o(188664);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(188662);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(196728);
        AppBrandAuthorizeSubscribeMsgDetailUI.a(AppBrandAuthorizeSubscribeMsgDetailUI.this);
        AppBrandAuthorizeSubscribeMsgDetailUI.this.finish();
        AppMethodBeat.o(196728);
        return false;
      }
    });
    paramBundle = getIntent().getParcelableExtra("key_data");
    this.moD = getIntent().getBooleanExtra("key_status_subscribed", false);
    if (!(paramBundle instanceof SubscribeMsgTmpItem))
    {
      finish();
      this.mrf = getPreferenceScreen();
      this.mrf.removeAll();
      this.mrh = new SelectPreference(this);
      this.mrh.setKey("preference_key_no_accept");
      this.mrh.setTitle(c.h.biz_subscribe_msg_voice_template_no_accept);
      this.mrf.b(this.mrh);
      this.mri = new SelectPreference(this);
      this.mri.setKey("preference_key_accept");
      this.mri.setTitle(c.h.biz_subscribe_msg_voice_template_accept);
      this.mrf.b(this.mri);
      this.mrj = null;
      if (this.mrg.mok)
      {
        this.mrj = new SelectPreference(this);
        this.mrj.setKey("preference_key_accept_allow_play_voice");
        this.mrj.setTitle(c.h.biz_subscribe_msg_voice_template_accept_play_voice);
        this.mrf.b(this.mrj);
      }
      if (this.mrg.moe.size() > 0) {
        this.mrf.b(new AppBrandAuthorizeSubscribeMsgDetailUI.a(this, this, new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(194566);
            Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/msgsubscription/ui/AppBrandAuthorizeSubscribeMsgDetailUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
            paramAnonymousView = LayoutInflater.from(AppBrandAuthorizeSubscribeMsgDetailUI.this).inflate(c.f.show_sample_layout, null);
            localObject1 = (LinearLayout)paramAnonymousView.findViewById(c.e.container);
            Object localObject2 = com.tencent.mm.msgsubscription.util.b.mtx;
            ((LinearLayout)localObject1).addView(com.tencent.mm.msgsubscription.util.b.a(AppBrandAuthorizeSubscribeMsgDetailUI.this, AppBrandAuthorizeSubscribeMsgDetailUI.b(AppBrandAuthorizeSubscribeMsgDetailUI.this).moe, 0));
            localObject2 = (TextView)paramAnonymousView.findViewById(c.e.sample_view_title);
            localObject1 = paramAnonymousView.findViewById(c.e.sample_close);
            ((TextView)localObject2).setText(AppBrandAuthorizeSubscribeMsgDetailUI.b(AppBrandAuthorizeSubscribeMsgDetailUI.this).title);
            localObject2 = new g(AppBrandAuthorizeSubscribeMsgDetailUI.this);
            ((g)localObject2).setCustomView(paramAnonymousView);
            ((g)localObject2).eik();
            ((View)localObject1).setOnClickListener(new AppBrandAuthorizeSubscribeMsgDetailUI.2.1(this, (g)localObject2));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/msgsubscription/ui/AppBrandAuthorizeSubscribeMsgDetailUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(194566);
          }
        }));
      }
      if (!this.moD) {
        break label401;
      }
      if ((!this.mrg.mok) || (!this.mrg.mnH)) {
        break label382;
      }
      if (this.mrj != null)
      {
        this.mrj.isSelected = true;
        this.mrk = this.mrj;
      }
    }
    for (;;)
    {
      this.mrf.notifyDataSetChanged();
      AppMethodBeat.o(188662);
      return;
      this.mrg = ((SubscribeMsgTmpItem)paramBundle);
      if ((getIntent() != null) && (!Util.isNullOrNil(this.mrg.title)))
      {
        setMMTitle(this.mrg.title);
        break;
      }
      setMMTitle(c.h.actionbar_setting);
      break;
      label382:
      this.mri.isSelected = true;
      this.mrk = this.mri;
      continue;
      label401:
      this.mrh.isSelected = true;
      this.mrk = this.mrh;
    }
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(188672);
    Log.i("MicroMsg.AppBrandAuthorizeDetailUI", "onPreferenceTreeClick, key:%s", new Object[] { paramPreference.mKey });
    if (paramPreference.mKey.equalsIgnoreCase("preference_key_accept_allow_play_voice"))
    {
      this.mrh.isSelected = false;
      this.mri.isSelected = false;
      if (!this.mrj.isSelected)
      {
        this.mrj.isSelected = true;
        this.mrl = this.mrj;
        if (this.mrg.mol.isEmpty()) {
          break label181;
        }
        paramf = new d(this);
        paramf.setTitle(c.h.biz_subscribe_msg_voice_template_open_alert_title);
        paramf.axZ(c.h.biz_subscribe_msg_voice_template_open_alert_msg);
        paramf.b(c.h.biz_subscribe_msg_voice_template_open_alert_left_btn_wording, new AppBrandAuthorizeSubscribeMsgDetailUI.3(this, paramf));
        paramf.a(getString(c.h.biz_subscribe_msg_voice_template_open_alert_right_btn_wording), true, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(187831);
            paramAnonymousDialogInterface = AppBrandAuthorizeSubscribeMsgDetailUI.this.mrm;
            com.tencent.mm.msgsubscription.voice.a locala = com.tencent.mm.msgsubscription.voice.a.mtE;
            paramAnonymousDialogInterface.set(com.tencent.mm.msgsubscription.voice.a.Zk(AppBrandAuthorizeSubscribeMsgDetailUI.b(AppBrandAuthorizeSubscribeMsgDetailUI.this).mol));
            AppMethodBeat.o(187831);
          }
        });
        paramf.iOnDialogDismissListener = new c()
        {
          public final void onDialogDismiss(Dialog paramAnonymousDialog) {}
        };
        paramf.show();
      }
    }
    for (;;)
    {
      this.mrf.notifyDataSetChanged();
      AppMethodBeat.o(188672);
      return false;
      label181:
      Log.i("MicroMsg.AppBrandAuthorizeDetailUI", "audioTemplateUrl is null, do not show audio sample dialog");
      continue;
      if (paramPreference.mKey.equalsIgnoreCase("preference_key_accept"))
      {
        this.mrh.isSelected = false;
        this.mri.isSelected = true;
        if (this.mrj != null) {
          this.mrj.isSelected = false;
        }
        this.mrl = this.mri;
      }
      else if (paramPreference.mKey.equalsIgnoreCase("preference_key_no_accept"))
      {
        this.mrh.isSelected = true;
        this.mri.isSelected = false;
        if (this.mrj != null) {
          this.mrj.isSelected = false;
        }
        this.mrl = this.mrh;
      }
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(188675);
    super.onStop();
    com.tencent.mm.msgsubscription.voice.a locala = com.tencent.mm.msgsubscription.voice.a.mtE;
    com.tencent.mm.msgsubscription.voice.a.GY(this.mrm.get());
    this.mrm.set(0L);
    AppMethodBeat.o(188675);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.AppBrandAuthorizeSubscribeMsgDetailUI
 * JD-Core Version:    0.7.0.1
 */