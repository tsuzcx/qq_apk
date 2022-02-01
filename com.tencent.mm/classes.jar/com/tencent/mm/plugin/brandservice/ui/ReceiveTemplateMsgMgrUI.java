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
import com.tencent.mm.plugin.brandservice.b.i;
import com.tencent.mm.plugin.brandservice.b.p;
import com.tencent.mm.protocal.protobuf.bnl;
import com.tencent.mm.protocal.protobuf.bnn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.Iterator;
import java.util.LinkedList;

public class ReceiveTemplateMsgMgrUI
  extends MMPreference
  implements com.tencent.mm.al.g
{
  private static LinkedList<bnl> mVn;
  private ProgressDialog fpP;
  protected f lxI;
  private String mVm;
  private boolean mVo = false;
  
  private void gZ(boolean paramBoolean)
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
    this.lxI = getPreferenceScreen();
    this.mVm = getIntent().getStringExtra("enterprise_biz_name");
    if (bt.isNullOrNil(this.mVm))
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
    final i locali = new i(this.mVm);
    com.tencent.mm.kernel.g.aeS().a(locali, 0);
    getString(2131755906);
    this.fpP = h.b(this, getString(2131762213), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(5760);
        com.tencent.mm.kernel.g.aeS().a(locali);
        AppMethodBeat.o(5760);
      }
    });
    AppMethodBeat.o(5765);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(5762);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.aeS().a(1031, this);
    com.tencent.mm.kernel.g.aeS().a(1030, this);
    initView();
    AppMethodBeat.o(5762);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(5764);
    com.tencent.mm.kernel.g.aeS().b(1031, this);
    com.tencent.mm.kernel.g.aeS().b(1030, this);
    super.onDestroy();
    AppMethodBeat.o(5764);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(5763);
    if (this.mVo)
    {
      ad.d("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "onPause option change");
      this.mVo = false;
      p localp = new p(this.mVm, mVn);
      com.tencent.mm.kernel.g.aeS().a(localp, 0);
    }
    super.onPause();
    AppMethodBeat.o(5763);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(5766);
    if (mVn == null)
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
    Iterator localIterator = mVn.iterator();
    bnl localbnl;
    while (localIterator.hasNext())
    {
      localbnl = (bnl)localIterator.next();
      if (paramf.equals(bt.nullAsNil(localbnl.DKS)))
      {
        this.mVo = true;
        if (!((CheckBoxPreference)paramPreference).isChecked()) {
          break label153;
        }
      }
    }
    label153:
    for (localbnl.Cxm = 0;; localbnl.Cxm = 1)
    {
      if (this.mVo)
      {
        ad.d("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "option change, do scene");
        aq.n(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(5761);
            if (ReceiveTemplateMsgMgrUI.a(ReceiveTemplateMsgMgrUI.this))
            {
              ReceiveTemplateMsgMgrUI.b(ReceiveTemplateMsgMgrUI.this);
              p localp = new p(ReceiveTemplateMsgMgrUI.c(ReceiveTemplateMsgMgrUI.this), ReceiveTemplateMsgMgrUI.bCC());
              com.tencent.mm.kernel.g.aeS().a(localp, 0);
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
      if ((this.fpP != null) && (this.fpP.isShowing()))
      {
        this.fpP.dismiss();
        this.fpP = null;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Toast.makeText(aj.getContext(), aj.getContext().getString(2131762210), 1).show();
        gZ(true);
        AppMethodBeat.o(5767);
        return;
      }
      paramString = (i)paramn;
      if ((paramString.rr != null) && (paramString.rr.gUT.gUX != null)) {}
      for (paramString = (bnn)paramString.rr.gUT.gUX;; paramString = null)
      {
        mVn = paramString.DKT;
        paramString = mVn;
        this.lxI.removeAll();
        if ((paramString != null) && (paramString.size() > 0)) {
          break;
        }
        ad.e("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "recvOption is empty");
        gZ(true);
        AppMethodBeat.o(5767);
        return;
      }
      gZ(false);
      ad.d("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "initBody options.size = %d", new Object[] { Integer.valueOf(paramString.size()) });
      paramString = paramString.iterator();
      if (paramString.hasNext())
      {
        paramn = (bnl)paramString.next();
        CheckBoxPreference localCheckBoxPreference = new CheckBoxPreference(this);
        localCheckBoxPreference.GfV = false;
        localCheckBoxPreference.setKey(paramn.DKS);
        localCheckBoxPreference.setTitle(paramn.Title);
        if (paramn.Cxm == 0) {}
        for (boolean bool = true;; bool = false)
        {
          localCheckBoxPreference.lG = bool;
          this.lxI.b(localCheckBoxPreference);
          break;
        }
      }
      this.lxI.notifyDataSetChanged();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.ReceiveTemplateMsgMgrUI
 * JD-Core Version:    0.7.0.1
 */