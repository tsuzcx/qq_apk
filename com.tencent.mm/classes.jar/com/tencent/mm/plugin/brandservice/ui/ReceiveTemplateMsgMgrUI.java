package com.tencent.mm.plugin.brandservice.ui;

import android.app.Activity;
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
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b.o;
import com.tencent.mm.protocal.protobuf.cla;
import com.tencent.mm.protocal.protobuf.clc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.Iterator;
import java.util.LinkedList;

public class ReceiveTemplateMsgMgrUI
  extends MMPreference
  implements i
{
  private static LinkedList<cla> ppS;
  private ProgressDialog gtM;
  protected f nRm;
  private String ppR;
  private boolean ppT = false;
  
  private void iH(boolean paramBoolean)
  {
    AppMethodBeat.i(5768);
    View localView1 = findViewById(2131306608);
    View localView2 = findViewById(2131306609);
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
    return 2131496042;
  }
  
  public int getLayoutId()
  {
    return 2131496043;
  }
  
  public int getResourceId()
  {
    return 2132017249;
  }
  
  public void initView()
  {
    AppMethodBeat.i(5765);
    setMMTitle(2131758024);
    this.nRm = getPreferenceScreen();
    this.ppR = getIntent().getStringExtra("enterprise_biz_name");
    if (Util.isNullOrNil(this.ppR))
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
    final com.tencent.mm.plugin.brandservice.b.h localh = new com.tencent.mm.plugin.brandservice.b.h(this.ppR);
    g.azz().a(localh, 0);
    getString(2131755998);
    this.gtM = com.tencent.mm.ui.base.h.a(this, getString(2131764235), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(5760);
        g.azz().a(localh);
        AppMethodBeat.o(5760);
      }
    });
    AppMethodBeat.o(5765);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(5762);
    super.onCreate(paramBundle);
    g.azz().a(1031, this);
    g.azz().a(1030, this);
    initView();
    AppMethodBeat.o(5762);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(5764);
    g.azz().b(1031, this);
    g.azz().b(1030, this);
    super.onDestroy();
    AppMethodBeat.o(5764);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(5763);
    if (this.ppT)
    {
      Log.d("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "onPause option change");
      this.ppT = false;
      o localo = new o(this.ppR, ppS);
      g.azz().a(localo, 0);
    }
    super.onPause();
    AppMethodBeat.o(5763);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(5766);
    if (ppS == null)
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
    Iterator localIterator = ppS.iterator();
    cla localcla;
    while (localIterator.hasNext())
    {
      localcla = (cla)localIterator.next();
      if (paramf.equals(Util.nullAsNil(localcla.Mqy)))
      {
        this.ppT = true;
        if (!((CheckBoxPreference)paramPreference).isChecked()) {
          break label153;
        }
      }
    }
    label153:
    for (localcla.KHa = 0;; localcla.KHa = 1)
    {
      if (this.ppT)
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
              o localo = new o(ReceiveTemplateMsgMgrUI.c(ReceiveTemplateMsgMgrUI.this), ReceiveTemplateMsgMgrUI.cmg());
              g.azz().a(localo, 0);
            }
            AppMethodBeat.o(5761);
          }
        }, 4000L);
      }
      AppMethodBeat.o(5766);
      return false;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(5767);
    if (paramq == null)
    {
      Log.e("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "onSceneEnd: [%d], [%d], [%s], scene is null", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      AppMethodBeat.o(5767);
      return;
    }
    Log.i("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "onSceneEnd: [%d], [%d], [%s], sceneType[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramq.getType()) });
    if (paramq.getType() == 1031)
    {
      if ((this.gtM != null) && (this.gtM.isShowing()))
      {
        this.gtM.dismiss();
        this.gtM = null;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(2131764232), 1).show();
        iH(true);
        AppMethodBeat.o(5767);
        return;
      }
      paramString = (com.tencent.mm.plugin.brandservice.b.h)paramq;
      if ((paramString.rr != null) && (paramString.rr.iLL.iLR != null)) {}
      for (paramString = (clc)paramString.rr.iLL.iLR;; paramString = null)
      {
        ppS = paramString.Mqz;
        paramString = ppS;
        this.nRm.removeAll();
        if ((paramString != null) && (paramString.size() > 0)) {
          break;
        }
        Log.e("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "recvOption is empty");
        iH(true);
        AppMethodBeat.o(5767);
        return;
      }
      iH(false);
      Log.d("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "initBody options.size = %d", new Object[] { Integer.valueOf(paramString.size()) });
      paramString = paramString.iterator();
      if (paramString.hasNext())
      {
        paramq = (cla)paramString.next();
        CheckBoxPreference localCheckBoxPreference = new CheckBoxPreference(this);
        localCheckBoxPreference.OZw = false;
        localCheckBoxPreference.setKey(paramq.Mqy);
        localCheckBoxPreference.setTitle(paramq.Title);
        if (paramq.KHa == 0) {}
        for (boolean bool = true;; bool = false)
        {
          localCheckBoxPreference.setChecked(bool);
          this.nRm.c(localCheckBoxPreference);
          break;
        }
      }
      this.nRm.notifyDataSetChanged();
      Log.d("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "initBodyView finish");
      AppMethodBeat.o(5767);
      return;
    }
    if ((paramq.getType() == 1030) && ((paramInt1 != 0) || (paramInt2 != 0)))
    {
      Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(2131764233), 0).show();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.ReceiveTemplateMsgMgrUI
 * JD-Core Version:    0.7.0.1
 */