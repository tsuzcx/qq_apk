package com.tencent.mm.msgsubscription.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.voice.a;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.SelectPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.e;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

public class AppBrandAuthorizeSubscribeMsgDetailUI
  extends MMPreference
{
  private boolean piu;
  private f pkD;
  private SubscribeMsgTmpItem pkE;
  private SelectPreference pkF;
  private SelectPreference pkG;
  private SelectPreference pkH;
  private SelectPreference pkI;
  private SelectPreference pkJ;
  private SelectPreference pkK;
  final AtomicLong pkL;
  
  public AppBrandAuthorizeSubscribeMsgDetailUI()
  {
    AppMethodBeat.i(236632);
    this.pkE = null;
    this.pkJ = null;
    this.pkK = null;
    this.pkL = new AtomicLong(0L);
    AppMethodBeat.o(236632);
  }
  
  private void bQf()
  {
    AppMethodBeat.i(236645);
    if ((this.pkK != null) && (this.pkK != this.pkJ))
    {
      Log.i("MicroMsg.AppBrandAuthorizeDetailUI", "setResData, has changed, state:%s", new Object[] { this.pkK.mKey });
      Object localObject = this.pkK.mKey;
      int i;
      switch (((String)localObject).hashCode())
      {
      default: 
        i = -1;
        label102:
        switch (i)
        {
        }
        break;
      }
      for (;;)
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("key_data", this.pkE);
        ((Intent)localObject).putExtra("key_status_subscribed", this.piu);
        setResult(-1, (Intent)localObject);
        AppMethodBeat.o(236645);
        return;
        if (!((String)localObject).equals("preference_key_no_accept")) {
          break;
        }
        i = 0;
        break label102;
        if (!((String)localObject).equals("preference_key_accept")) {
          break;
        }
        i = 1;
        break label102;
        if (!((String)localObject).equals("preference_key_accept_allow_play_voice")) {
          break;
        }
        i = 2;
        break label102;
        if (!((String)localObject).equals("preference_key_accept_allow_force_notify")) {
          break;
        }
        i = 3;
        break label102;
        this.pkE.phu = false;
        this.pkE.pib = false;
        this.piu = false;
        continue;
        this.pkE.phu = false;
        this.pkE.pib = false;
        this.piu = true;
        continue;
        this.pkE.phu = true;
        this.piu = true;
        continue;
        this.pkE.pib = true;
        this.piu = true;
      }
    }
    setResult(0, null);
    AppMethodBeat.o(236645);
  }
  
  public int getResourceId()
  {
    return -1;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(236683);
    bQf();
    super.onBackPressed();
    AppMethodBeat.o(236683);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(236678);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(236618);
        AppBrandAuthorizeSubscribeMsgDetailUI.a(AppBrandAuthorizeSubscribeMsgDetailUI.this);
        AppBrandAuthorizeSubscribeMsgDetailUI.this.finish();
        AppMethodBeat.o(236618);
        return false;
      }
    });
    paramBundle = getIntent().getParcelableExtra("key_data");
    this.piu = getIntent().getBooleanExtra("key_status_subscribed", false);
    if (!(paramBundle instanceof SubscribeMsgTmpItem))
    {
      finish();
      this.pkD = getPreferenceScreen();
      this.pkD.removeAll();
      this.pkF = new SelectPreference(this);
      this.pkF.setKey("preference_key_no_accept");
      this.pkF.setTitle(c.h.biz_subscribe_msg_voice_template_no_accept);
      this.pkD.c(this.pkF);
      this.pkG = new SelectPreference(this);
      this.pkG.setKey("preference_key_accept");
      this.pkG.setTitle(c.h.biz_subscribe_msg_voice_template_accept);
      this.pkD.c(this.pkG);
      this.pkH = null;
      if (!this.pkE.phY) {
        break label382;
      }
      this.pkH = new SelectPreference(this);
      this.pkH.setKey("preference_key_accept_allow_play_voice");
      this.pkH.setTitle(c.h.biz_subscribe_msg_voice_template_accept_play_voice);
      this.pkD.c(this.pkH);
      label226:
      if (this.pkE.phS.size() > 0) {
        this.pkD.c(new AppBrandAuthorizeSubscribeMsgDetailUI.a(this, this, new AppBrandAuthorizeSubscribeMsgDetailUI.2(this)));
      }
      if (!this.piu) {
        break label528;
      }
      if ((!this.pkE.phY) || (!this.pkE.phu)) {
        break label463;
      }
      if (this.pkH != null)
      {
        this.pkH.isSelected = true;
        this.pkJ = this.pkH;
      }
    }
    label528:
    for (;;)
    {
      this.pkD.notifyDataSetChanged();
      AppMethodBeat.o(236678);
      return;
      this.pkE = ((SubscribeMsgTmpItem)paramBundle);
      if ((getIntent() != null) && (!Util.isNullOrNil(this.pkE.title)))
      {
        setMMTitle(this.pkE.title);
        break;
      }
      setMMTitle(c.h.actionbar_setting);
      break;
      label382:
      if (!this.pkE.pia) {
        break label226;
      }
      this.pkI = new SelectPreference(this);
      this.pkI.setKey("preference_key_accept_allow_force_notify");
      this.pkI.setTitle(c.h.biz_subscribe_msg_accept_and_force_notify);
      paramBundle = this.pkI;
      int i = c.h.biz_subscribe_msg_accept_and_force_notify_desc;
      paramBundle.bAn(paramBundle.mContext.getResources().getString(i));
      this.pkD.c(this.pkI);
      break label226;
      label463:
      if ((this.pkE.pia) && (this.pkE.pib))
      {
        if (this.pkI != null)
        {
          this.pkI.isSelected = true;
          this.pkJ = this.pkI;
        }
      }
      else
      {
        this.pkG.isSelected = true;
        this.pkJ = this.pkG;
        continue;
        this.pkF.isSelected = true;
        this.pkJ = this.pkF;
      }
    }
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(236691);
    Log.i("MicroMsg.AppBrandAuthorizeDetailUI", "onPreferenceTreeClick, key:%s", new Object[] { paramPreference.mKey });
    if (paramPreference.mKey.equalsIgnoreCase("preference_key_accept_allow_play_voice"))
    {
      this.pkF.isSelected = false;
      this.pkG.isSelected = false;
      if (!this.pkH.isSelected)
      {
        this.pkH.isSelected = true;
        this.pkK = this.pkH;
        if (this.pkE.phZ.isEmpty()) {
          break label184;
        }
        paramf = new e(this);
        paramf.setTitle(c.h.biz_subscribe_msg_voice_template_open_alert_title);
        paramf.aEH(c.h.biz_subscribe_msg_voice_template_open_alert_msg);
        paramf.b(c.h.biz_subscribe_msg_voice_template_open_alert_left_btn_wording, new AppBrandAuthorizeSubscribeMsgDetailUI.3(this, paramf));
        paramf.a(getString(c.h.biz_subscribe_msg_voice_template_open_alert_right_btn_wording), true, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(236655);
            paramAnonymousDialogInterface = AppBrandAuthorizeSubscribeMsgDetailUI.this.pkL;
            a locala = a.pmY;
            paramAnonymousDialogInterface.set(a.Ro(AppBrandAuthorizeSubscribeMsgDetailUI.b(AppBrandAuthorizeSubscribeMsgDetailUI.this).phZ));
            AppMethodBeat.o(236655);
          }
        });
        paramf.iOnDialogDismissListener = new d()
        {
          public final void onDialogDismiss(Dialog paramAnonymousDialog) {}
        };
        paramf.show();
      }
    }
    for (;;)
    {
      this.pkD.notifyDataSetChanged();
      AppMethodBeat.o(236691);
      return false;
      label184:
      Log.i("MicroMsg.AppBrandAuthorizeDetailUI", "audioTemplateUrl is null, do not show audio sample dialog");
      continue;
      if (paramPreference.mKey.equalsIgnoreCase("preference_key_accept_allow_force_notify"))
      {
        this.pkI.isSelected = true;
        this.pkF.isSelected = false;
        this.pkG.isSelected = false;
        this.pkK = this.pkI;
      }
      else if (paramPreference.mKey.equalsIgnoreCase("preference_key_accept"))
      {
        this.pkF.isSelected = false;
        this.pkG.isSelected = true;
        if (this.pkH != null) {
          this.pkH.isSelected = false;
        }
        if (this.pkI != null) {
          this.pkI.isSelected = false;
        }
        this.pkK = this.pkG;
      }
      else if (paramPreference.mKey.equalsIgnoreCase("preference_key_no_accept"))
      {
        this.pkF.isSelected = true;
        this.pkG.isSelected = false;
        if (this.pkH != null) {
          this.pkH.isSelected = false;
        }
        if (this.pkI != null) {
          this.pkI.isSelected = false;
        }
        this.pkK = this.pkF;
      }
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(236692);
    super.onStop();
    a locala = a.pmY;
    a.jj(this.pkL.get());
    this.pkL.set(0L);
    AppMethodBeat.o(236692);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.AppBrandAuthorizeSubscribeMsgDetailUI
 * JD-Core Version:    0.7.0.1
 */