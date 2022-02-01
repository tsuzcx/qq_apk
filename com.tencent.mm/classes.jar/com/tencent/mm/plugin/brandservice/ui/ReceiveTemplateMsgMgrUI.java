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
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b.o;
import com.tencent.mm.protocal.protobuf.bwo;
import com.tencent.mm.protocal.protobuf.bwq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.Iterator;
import java.util.LinkedList;

public class ReceiveTemplateMsgMgrUI
  extends MMPreference
  implements com.tencent.mm.al.f
{
  private static LinkedList<bwo> nZl;
  private ProgressDialog fMu;
  protected com.tencent.mm.ui.base.preference.f mzx;
  private String nZk;
  private boolean nZm = false;
  
  private void hD(boolean paramBoolean)
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
    this.mzx = getPreferenceScreen();
    this.nZk = getIntent().getStringExtra("enterprise_biz_name");
    if (bt.isNullOrNil(this.nZk))
    {
      ad.e("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "bizName is null");
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
    final com.tencent.mm.plugin.brandservice.b.h localh = new com.tencent.mm.plugin.brandservice.b.h(this.nZk);
    g.aiU().a(localh, 0);
    getString(2131755906);
    this.fMu = com.tencent.mm.ui.base.h.b(this, getString(2131762213), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(5760);
        g.aiU().a(localh);
        AppMethodBeat.o(5760);
      }
    });
    AppMethodBeat.o(5765);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(5762);
    super.onCreate(paramBundle);
    g.aiU().a(1031, this);
    g.aiU().a(1030, this);
    initView();
    AppMethodBeat.o(5762);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(5764);
    g.aiU().b(1031, this);
    g.aiU().b(1030, this);
    super.onDestroy();
    AppMethodBeat.o(5764);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(5763);
    if (this.nZm)
    {
      ad.d("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "onPause option change");
      this.nZm = false;
      o localo = new o(this.nZk, nZl);
      g.aiU().a(localo, 0);
    }
    super.onPause();
    AppMethodBeat.o(5763);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(5766);
    if (nZl == null)
    {
      ad.w("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "mRecvOptions == null");
      AppMethodBeat.o(5766);
      return false;
    }
    paramf = paramPreference.mKey;
    if (bt.isNullOrNil(paramf))
    {
      ad.e("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "key is null");
      AppMethodBeat.o(5766);
      return false;
    }
    Iterator localIterator = nZl.iterator();
    bwo localbwo;
    while (localIterator.hasNext())
    {
      localbwo = (bwo)localIterator.next();
      if (paramf.equals(bt.nullAsNil(localbwo.GQJ)))
      {
        this.nZm = true;
        if (!((CheckBoxPreference)paramPreference).isChecked()) {
          break label153;
        }
      }
    }
    label153:
    for (localbwo.FuX = 0;; localbwo.FuX = 1)
    {
      if (this.nZm)
      {
        ad.d("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "option change, do scene");
        aq.o(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(5761);
            if (ReceiveTemplateMsgMgrUI.a(ReceiveTemplateMsgMgrUI.this))
            {
              ReceiveTemplateMsgMgrUI.b(ReceiveTemplateMsgMgrUI.this);
              o localo = new o(ReceiveTemplateMsgMgrUI.c(ReceiveTemplateMsgMgrUI.this), ReceiveTemplateMsgMgrUI.bOd());
              g.aiU().a(localo, 0);
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
      ad.e("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "onSceneEnd: [%d], [%d], [%s], scene is null", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      AppMethodBeat.o(5767);
      return;
    }
    ad.i("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "onSceneEnd: [%d], [%d], [%s], sceneType[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramn.getType()) });
    if (paramn.getType() == 1031)
    {
      if ((this.fMu != null) && (this.fMu.isShowing()))
      {
        this.fMu.dismiss();
        this.fMu = null;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Toast.makeText(aj.getContext(), aj.getContext().getString(2131762210), 1).show();
        hD(true);
        AppMethodBeat.o(5767);
        return;
      }
      paramString = (com.tencent.mm.plugin.brandservice.b.h)paramn;
      if ((paramString.rr != null) && (paramString.rr.hNL.hNQ != null)) {}
      for (paramString = (bwq)paramString.rr.hNL.hNQ;; paramString = null)
      {
        nZl = paramString.GQK;
        paramString = nZl;
        this.mzx.removeAll();
        if ((paramString != null) && (paramString.size() > 0)) {
          break;
        }
        ad.e("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "recvOption is empty");
        hD(true);
        AppMethodBeat.o(5767);
        return;
      }
      hD(false);
      ad.d("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "initBody options.size = %d", new Object[] { Integer.valueOf(paramString.size()) });
      paramString = paramString.iterator();
      if (paramString.hasNext())
      {
        paramn = (bwo)paramString.next();
        CheckBoxPreference localCheckBoxPreference = new CheckBoxPreference(this);
        localCheckBoxPreference.JtB = false;
        localCheckBoxPreference.setKey(paramn.GQJ);
        localCheckBoxPreference.setTitle(paramn.Title);
        if (paramn.FuX == 0) {}
        for (boolean bool = true;; bool = false)
        {
          localCheckBoxPreference.oB = bool;
          this.mzx.b(localCheckBoxPreference);
          break;
        }
      }
      this.mzx.notifyDataSetChanged();
      ad.d("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "initBodyView finish");
      AppMethodBeat.o(5767);
      return;
    }
    if ((paramn.getType() == 1030) && ((paramInt1 != 0) || (paramInt2 != 0)))
    {
      Toast.makeText(aj.getContext(), aj.getContext().getString(2131762211), 0).show();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.ReceiveTemplateMsgMgrUI
 * JD-Core Version:    0.7.0.1
 */