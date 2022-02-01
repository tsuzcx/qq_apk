package com.tencent.mm.plugin.brandservice.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.s;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.brandservice.d.i;
import com.tencent.mm.plugin.brandservice.d.j;
import com.tencent.mm.plugin.brandservice.model.i;
import com.tencent.mm.protocal.protobuf.dkv;
import com.tencent.mm.protocal.protobuf.dkx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.Iterator;
import java.util.LinkedList;

public class ReceiveTemplateMsgMgrUI
  extends MMPreference
  implements com.tencent.mm.am.h
{
  private static LinkedList<dkv> vEy;
  private ProgressDialog lzP;
  protected f pkD;
  private String vEx;
  private boolean vEz = false;
  
  private void mQ(boolean paramBoolean)
  {
    AppMethodBeat.i(5768);
    View localView1 = findViewById(d.e.receive_template_msg_empty_tips);
    View localView2 = findViewById(d.e.receive_template_msg_header_ll);
    if (localView1 != null) {
      if (paramBoolean)
      {
        ((TextView)localView1).setVisibility(0);
        if (localView2 != null)
        {
          localView2.setVisibility(8);
          AppMethodBeat.o(5768);
        }
      }
      else
      {
        ((TextView)localView1).setVisibility(8);
        if (localView2 != null) {
          localView2.setVisibility(0);
        }
      }
    }
    AppMethodBeat.o(5768);
  }
  
  public int getHeaderResourceId()
  {
    return d.f.receive_template_msg_header;
  }
  
  public int getLayoutId()
  {
    return d.f.receive_template_msg_mgr;
  }
  
  public int getResourceId()
  {
    return d.j.receive_template_msg;
  }
  
  public void initView()
  {
    AppMethodBeat.i(5765);
    setMMTitle(d.i.contact_info_receive_tmp_msg_title);
    this.pkD = getPreferenceScreen();
    this.vEx = getIntent().getStringExtra("enterprise_biz_name");
    if (Util.isNullOrNil(this.vEx))
    {
      Log.e("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "bizName is null");
      finish();
      AppMethodBeat.o(5765);
      return;
    }
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(5759);
        ReceiveTemplateMsgMgrUI.this.finish();
        AppMethodBeat.o(5759);
        return true;
      }
    });
    final i locali = new i(this.vEx);
    com.tencent.mm.kernel.h.aZW().a(locali, 0);
    getString(d.i.app_tip);
    this.lzP = k.a(this, getString(d.i.receive_template_msg_ui_waiting_get_options), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(5760);
        com.tencent.mm.kernel.h.aZW().a(locali);
        AppMethodBeat.o(5760);
      }
    });
    AppMethodBeat.o(5765);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(5762);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.h.aZW().a(1031, this);
    com.tencent.mm.kernel.h.aZW().a(1030, this);
    initView();
    AppMethodBeat.o(5762);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(5764);
    com.tencent.mm.kernel.h.aZW().b(1031, this);
    com.tencent.mm.kernel.h.aZW().b(1030, this);
    super.onDestroy();
    AppMethodBeat.o(5764);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(5763);
    if (this.vEz)
    {
      Log.d("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "onPause option change");
      this.vEz = false;
      com.tencent.mm.plugin.brandservice.model.p localp = new com.tencent.mm.plugin.brandservice.model.p(this.vEx, vEy);
      com.tencent.mm.kernel.h.aZW().a(localp, 0);
    }
    super.onPause();
    AppMethodBeat.o(5763);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(5766);
    if (vEy == null)
    {
      Log.w("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "mRecvOptions == null");
      AppMethodBeat.o(5766);
      return false;
    }
    paramf = paramPreference.mKey;
    if (Util.isNullOrNil(paramf))
    {
      Log.e("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "key is null");
      AppMethodBeat.o(5766);
      return false;
    }
    Iterator localIterator = vEy.iterator();
    dkv localdkv;
    while (localIterator.hasNext())
    {
      localdkv = (dkv)localIterator.next();
      if (paramf.equals(Util.nullAsNil(localdkv.aaQP)))
      {
        this.vEz = true;
        if (!((CheckBoxPreference)paramPreference).isChecked()) {
          break label154;
        }
      }
    }
    label154:
    for (localdkv.YFu = 0;; localdkv.YFu = 1)
    {
      if (this.vEz)
      {
        Log.d("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "option change, do scene");
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(5761);
            if (ReceiveTemplateMsgMgrUI.a(ReceiveTemplateMsgMgrUI.this))
            {
              ReceiveTemplateMsgMgrUI.b(ReceiveTemplateMsgMgrUI.this);
              com.tencent.mm.plugin.brandservice.model.p localp = new com.tencent.mm.plugin.brandservice.model.p(ReceiveTemplateMsgMgrUI.c(ReceiveTemplateMsgMgrUI.this), ReceiveTemplateMsgMgrUI.dcC());
              com.tencent.mm.kernel.h.aZW().a(localp, 0);
            }
            AppMethodBeat.o(5761);
          }
        }, 4000L);
      }
      AppMethodBeat.o(5766);
      return false;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(5767);
    if (paramp == null)
    {
      Log.e("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "onSceneEnd: [%d], [%d], [%s], scene is null", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      AppMethodBeat.o(5767);
      return;
    }
    Log.i("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "onSceneEnd: [%d], [%d], [%s], sceneType[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramp.getType()) });
    if (paramp.getType() == 1031)
    {
      if ((this.lzP != null) && (this.lzP.isShowing()))
      {
        this.lzP.dismiss();
        this.lzP = null;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(d.i.receive_template_msg_ui_fail_get_options), 1).show();
        mQ(true);
        AppMethodBeat.o(5767);
        return;
      }
      paramString = (i)paramp;
      if ((paramString.rr != null) && (c.c.b(paramString.rr.otC) != null)) {}
      for (paramString = (dkx)c.c.b(paramString.rr.otC);; paramString = null)
      {
        vEy = paramString.aaQQ;
        paramString = vEy;
        this.pkD.removeAll();
        if ((paramString != null) && (paramString.size() > 0)) {
          break;
        }
        Log.e("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "recvOption is empty");
        mQ(true);
        AppMethodBeat.o(5767);
        return;
      }
      mQ(false);
      Log.d("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "initBody options.size = %d", new Object[] { Integer.valueOf(paramString.size()) });
      paramString = paramString.iterator();
      if (paramString.hasNext())
      {
        paramp = (dkv)paramString.next();
        CheckBoxPreference localCheckBoxPreference = new CheckBoxPreference(this);
        localCheckBoxPreference.adZV = false;
        localCheckBoxPreference.setKey(paramp.aaQP);
        localCheckBoxPreference.setTitle(paramp.hAP);
        if (paramp.YFu == 0) {}
        for (boolean bool = true;; bool = false)
        {
          localCheckBoxPreference.setChecked(bool);
          this.pkD.c(localCheckBoxPreference);
          break;
        }
      }
      this.pkD.notifyDataSetChanged();
      Log.d("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "initBodyView finish");
      AppMethodBeat.o(5767);
      return;
    }
    if ((paramp.getType() == 1030) && ((paramInt1 != 0) || (paramInt2 != 0)))
    {
      Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(d.i.receive_template_msg_ui_fail_set_options), 0).show();
      AppMethodBeat.o(5767);
      return;
    }
    AppMethodBeat.o(5767);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.ReceiveTemplateMsgMgrUI
 * JD-Core Version:    0.7.0.1
 */