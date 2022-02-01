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
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.plugin.brandservice.b.p;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.brandservice.d.i;
import com.tencent.mm.plugin.brandservice.d.j;
import com.tencent.mm.protocal.protobuf.ctt;
import com.tencent.mm.protocal.protobuf.ctv;
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
  implements com.tencent.mm.an.i
{
  private static LinkedList<ctt> syR;
  private ProgressDialog iXX;
  protected f mrf;
  private String syQ;
  private boolean syS = false;
  
  private void jD(boolean paramBoolean)
  {
    AppMethodBeat.i(5768);
    View localView1 = findViewById(d.e.ssJ);
    View localView2 = findViewById(d.e.ssK);
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
    return d.f.suv;
  }
  
  public int getLayoutId()
  {
    return d.f.suw;
  }
  
  public int getResourceId()
  {
    return d.j.svs;
  }
  
  public void initView()
  {
    AppMethodBeat.i(5765);
    setMMTitle(d.i.sve);
    this.mrf = getPreferenceScreen();
    this.syQ = getIntent().getStringExtra("enterprise_biz_name");
    if (Util.isNullOrNil(this.syQ))
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
    final com.tencent.mm.plugin.brandservice.b.i locali = new com.tencent.mm.plugin.brandservice.b.i(this.syQ);
    com.tencent.mm.kernel.h.aGY().a(locali, 0);
    getString(d.i.app_tip);
    this.iXX = com.tencent.mm.ui.base.h.a(this, getString(d.i.svr), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(5760);
        com.tencent.mm.kernel.h.aGY().a(locali);
        AppMethodBeat.o(5760);
      }
    });
    AppMethodBeat.o(5765);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(5762);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.h.aGY().a(1031, this);
    com.tencent.mm.kernel.h.aGY().a(1030, this);
    initView();
    AppMethodBeat.o(5762);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(5764);
    com.tencent.mm.kernel.h.aGY().b(1031, this);
    com.tencent.mm.kernel.h.aGY().b(1030, this);
    super.onDestroy();
    AppMethodBeat.o(5764);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(5763);
    if (this.syS)
    {
      Log.d("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "onPause option change");
      this.syS = false;
      p localp = new p(this.syQ, syR);
      com.tencent.mm.kernel.h.aGY().a(localp, 0);
    }
    super.onPause();
    AppMethodBeat.o(5763);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(5766);
    if (syR == null)
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
    Iterator localIterator = syR.iterator();
    ctt localctt;
    while (localIterator.hasNext())
    {
      localctt = (ctt)localIterator.next();
      if (paramf.equals(Util.nullAsNil(localctt.TBB)))
      {
        this.syS = true;
        if (!((CheckBoxPreference)paramPreference).isChecked()) {
          break label154;
        }
      }
    }
    label154:
    for (localctt.RIs = 0;; localctt.RIs = 1)
    {
      if (this.syS)
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
              p localp = new p(ReceiveTemplateMsgMgrUI.c(ReceiveTemplateMsgMgrUI.this), ReceiveTemplateMsgMgrUI.czK());
              com.tencent.mm.kernel.h.aGY().a(localp, 0);
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
      if ((this.iXX != null) && (this.iXX.isShowing()))
      {
        this.iXX.dismiss();
        this.iXX = null;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(d.i.svp), 1).show();
        jD(true);
        AppMethodBeat.o(5767);
        return;
      }
      paramString = (com.tencent.mm.plugin.brandservice.b.i)paramq;
      if ((paramString.rr != null) && (d.c.b(paramString.rr.lBS) != null)) {}
      for (paramString = (ctv)d.c.b(paramString.rr.lBS);; paramString = null)
      {
        syR = paramString.TBC;
        paramString = syR;
        this.mrf.removeAll();
        if ((paramString != null) && (paramString.size() > 0)) {
          break;
        }
        Log.e("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "recvOption is empty");
        jD(true);
        AppMethodBeat.o(5767);
        return;
      }
      jD(false);
      Log.d("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "initBody options.size = %d", new Object[] { Integer.valueOf(paramString.size()) });
      paramString = paramString.iterator();
      if (paramString.hasNext())
      {
        paramq = (ctt)paramString.next();
        CheckBoxPreference localCheckBoxPreference = new CheckBoxPreference(this);
        localCheckBoxPreference.WsF = false;
        localCheckBoxPreference.setKey(paramq.TBB);
        localCheckBoxPreference.setTitle(paramq.fwr);
        if (paramq.RIs == 0) {}
        for (boolean bool = true;; bool = false)
        {
          localCheckBoxPreference.setChecked(bool);
          this.mrf.b(localCheckBoxPreference);
          break;
        }
      }
      this.mrf.notifyDataSetChanged();
      Log.d("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "initBodyView finish");
      AppMethodBeat.o(5767);
      return;
    }
    if ((paramq.getType() == 1030) && ((paramInt1 != 0) || (paramInt2 != 0)))
    {
      Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(d.i.svq), 0).show();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.ReceiveTemplateMsgMgrUI
 * JD-Core Version:    0.7.0.1
 */