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
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.brandservice.b.o;
import com.tencent.mm.protocal.protobuf.bsb;
import com.tencent.mm.protocal.protobuf.bsd;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.Iterator;
import java.util.LinkedList;

public class ReceiveTemplateMsgMgrUI
  extends MMPreference
  implements com.tencent.mm.ak.g
{
  private static LinkedList<bsb> nxN;
  private ProgressDialog fts;
  protected f lZC;
  private String nxM;
  private boolean nxO = false;
  
  private void hw(boolean paramBoolean)
  {
    AppMethodBeat.i(5768);
    View localView1 = findViewById(2131303805);
    View localView2 = findViewById(2131303806);
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
    return 2131495199;
  }
  
  public int getLayoutId()
  {
    return 2131495200;
  }
  
  public int getResourceId()
  {
    return 2131951704;
  }
  
  public void initView()
  {
    AppMethodBeat.i(5765);
    setMMTitle(2131757784);
    this.lZC = getPreferenceScreen();
    this.nxM = getIntent().getStringExtra("enterprise_biz_name");
    if (bs.isNullOrNil(this.nxM))
    {
      ac.e("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "bizName is null");
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
    final com.tencent.mm.plugin.brandservice.b.h localh = new com.tencent.mm.plugin.brandservice.b.h(this.nxM);
    com.tencent.mm.kernel.g.agi().a(localh, 0);
    getString(2131755906);
    this.fts = com.tencent.mm.ui.base.h.b(this, getString(2131762213), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(5760);
        com.tencent.mm.kernel.g.agi().a(localh);
        AppMethodBeat.o(5760);
      }
    });
    AppMethodBeat.o(5765);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(5762);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.agi().a(1031, this);
    com.tencent.mm.kernel.g.agi().a(1030, this);
    initView();
    AppMethodBeat.o(5762);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(5764);
    com.tencent.mm.kernel.g.agi().b(1031, this);
    com.tencent.mm.kernel.g.agi().b(1030, this);
    super.onDestroy();
    AppMethodBeat.o(5764);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(5763);
    if (this.nxO)
    {
      ac.d("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "onPause option change");
      this.nxO = false;
      o localo = new o(this.nxM, nxN);
      com.tencent.mm.kernel.g.agi().a(localo, 0);
    }
    super.onPause();
    AppMethodBeat.o(5763);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(5766);
    if (nxN == null)
    {
      ac.w("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "mRecvOptions == null");
      AppMethodBeat.o(5766);
      return false;
    }
    paramf = paramPreference.mKey;
    if (bs.isNullOrNil(paramf))
    {
      ac.e("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "key is null");
      AppMethodBeat.o(5766);
      return false;
    }
    Iterator localIterator = nxN.iterator();
    bsb localbsb;
    while (localIterator.hasNext())
    {
      localbsb = (bsb)localIterator.next();
      if (paramf.equals(bs.nullAsNil(localbsb.Fhh)))
      {
        this.nxO = true;
        if (!((CheckBoxPreference)paramPreference).isChecked()) {
          break label153;
        }
      }
    }
    label153:
    for (localbsb.DPI = 0;; localbsb.DPI = 1)
    {
      if (this.nxO)
      {
        ac.d("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "option change, do scene");
        ap.n(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(5761);
            if (ReceiveTemplateMsgMgrUI.a(ReceiveTemplateMsgMgrUI.this))
            {
              ReceiveTemplateMsgMgrUI.b(ReceiveTemplateMsgMgrUI.this);
              o localo = new o(ReceiveTemplateMsgMgrUI.c(ReceiveTemplateMsgMgrUI.this), ReceiveTemplateMsgMgrUI.bJK());
              com.tencent.mm.kernel.g.agi().a(localo, 0);
            }
            AppMethodBeat.o(5761);
          }
        }, 4000L);
      }
      AppMethodBeat.o(5766);
      return false;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(5767);
    if (paramn == null)
    {
      ac.e("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "onSceneEnd: [%d], [%d], [%s], scene is null", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      AppMethodBeat.o(5767);
      return;
    }
    ac.i("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "onSceneEnd: [%d], [%d], [%s], sceneType[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramn.getType()) });
    if (paramn.getType() == 1031)
    {
      if ((this.fts != null) && (this.fts.isShowing()))
      {
        this.fts.dismiss();
        this.fts = null;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Toast.makeText(ai.getContext(), ai.getContext().getString(2131762210), 1).show();
        hw(true);
        AppMethodBeat.o(5767);
        return;
      }
      paramString = (com.tencent.mm.plugin.brandservice.b.h)paramn;
      if ((paramString.rr != null) && (paramString.rr.hvs.hvw != null)) {}
      for (paramString = (bsd)paramString.rr.hvs.hvw;; paramString = null)
      {
        nxN = paramString.Fhi;
        paramString = nxN;
        this.lZC.removeAll();
        if ((paramString != null) && (paramString.size() > 0)) {
          break;
        }
        ac.e("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "recvOption is empty");
        hw(true);
        AppMethodBeat.o(5767);
        return;
      }
      hw(false);
      ac.d("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "initBody options.size = %d", new Object[] { Integer.valueOf(paramString.size()) });
      paramString = paramString.iterator();
      if (paramString.hasNext())
      {
        paramn = (bsb)paramString.next();
        CheckBoxPreference localCheckBoxPreference = new CheckBoxPreference(this);
        localCheckBoxPreference.HFK = false;
        localCheckBoxPreference.setKey(paramn.Fhh);
        localCheckBoxPreference.setTitle(paramn.Title);
        if (paramn.DPI == 0) {}
        for (boolean bool = true;; bool = false)
        {
          localCheckBoxPreference.mF = bool;
          this.lZC.b(localCheckBoxPreference);
          break;
        }
      }
      this.lZC.notifyDataSetChanged();
      ac.d("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "initBodyView finish");
      AppMethodBeat.o(5767);
      return;
    }
    if ((paramn.getType() == 1030) && ((paramInt1 != 0) || (paramInt2 != 0)))
    {
      Toast.makeText(ai.getContext(), ai.getContext().getString(2131762211), 0).show();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.ReceiveTemplateMsgMgrUI
 * JD-Core Version:    0.7.0.1
 */