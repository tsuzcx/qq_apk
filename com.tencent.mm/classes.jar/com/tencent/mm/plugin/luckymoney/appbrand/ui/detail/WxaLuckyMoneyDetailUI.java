package com.tencent.mm.plugin.luckymoney.appbrand.ui.detail;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.appbrand.a.i;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.model.z;
import com.tencent.mm.protocal.protobuf.bnr;
import com.tencent.mm.protocal.protobuf.cgz;
import com.tencent.mm.protocal.protobuf.cqo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.wallet_core.ui.f;
import java.util.List;

public class WxaLuckyMoneyDetailUI
  extends WxaLuckyMoneyBaseUI
  implements b
{
  private View agn;
  private TextView lHT;
  private TextView mpP;
  private p tipDialog;
  private TextView uSM;
  private TextView vvW;
  private final a vwc;
  private Intent vwd;
  private ListView vwe;
  private ImageView vwf;
  private TextView vwg;
  private ImageView vwh;
  private View vwi;
  private View vwj;
  private c vwk;
  private AbsListView.OnScrollListener vwl;
  
  public WxaLuckyMoneyDetailUI()
  {
    AppMethodBeat.i(64916);
    this.vwc = new d();
    this.tipDialog = null;
    this.vwd = null;
    this.vwl = new AbsListView.OnScrollListener()
    {
      private boolean vwm = false;
      private boolean vwn;
      
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        boolean bool = true;
        AppMethodBeat.i(64913);
        if ((paramAnonymousInt3 == 0) || (!this.vwm))
        {
          AppMethodBeat.o(64913);
          return;
        }
        if (paramAnonymousInt1 > 0) {}
        label63:
        label114:
        label117:
        for (;;)
        {
          if (this.vwn != bool)
          {
            if (bool)
            {
              WxaLuckyMoneyDetailUI.a(WxaLuckyMoneyDetailUI.this, WxaLuckyMoneyDetailUI.this.getResources().getDrawable(2131232950));
              this.vwn = bool;
            }
          }
          else
          {
            AppMethodBeat.o(64913);
            return;
            paramAnonymousAbsListView = paramAnonymousAbsListView.getChildAt(paramAnonymousInt1);
            if (paramAnonymousAbsListView == null) {
              break label114;
            }
          }
          for (paramAnonymousInt1 = 0 - paramAnonymousAbsListView.getTop();; paramAnonymousInt1 = 0)
          {
            if (paramAnonymousInt1 > 100) {
              break label117;
            }
            bool = false;
            break;
            WxaLuckyMoneyDetailUI.b(WxaLuckyMoneyDetailUI.this);
            break label63;
          }
        }
      }
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(64912);
        if (paramAnonymousAbsListView.getCount() == 0)
        {
          AppMethodBeat.o(64912);
          return;
        }
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(64912);
          return;
          if (paramAnonymousAbsListView.getLastVisiblePosition() == paramAnonymousAbsListView.getCount() - 1) {
            WxaLuckyMoneyDetailUI.a(WxaLuckyMoneyDetailUI.this).Jz(paramAnonymousAbsListView.getCount());
          }
          this.vwm = false;
          AppMethodBeat.o(64912);
          return;
          this.vwm = true;
        }
      }
    };
    AppMethodBeat.o(64916);
  }
  
  private void a(i parami)
  {
    AppMethodBeat.i(64926);
    AppCompatActivity localAppCompatActivity = getContext();
    z.b(this.vwf, parami.vvt, parami.username);
    z.a(localAppCompatActivity, this.vwg, parami.nickname);
    z.a(localAppCompatActivity, this.uSM, parami.vvw);
    if (parami.vvv == 1)
    {
      this.vwh.setVisibility(0);
      this.vwh.setImageResource(2131233028);
      if (parami.vvu != 2) {
        break label201;
      }
      this.vvW.setText(f.C(parami.dPq / 100.0D));
      this.vwk.vvS = false;
      this.vwi.setVisibility(0);
      label117:
      if (bu.isNullOrNil(parami.vvx)) {
        break label213;
      }
      this.vwj.setVisibility(0);
      this.mpP.setText(parami.vvx);
      this.mpP.setTextColor(getResources().getColor(2131100598));
    }
    for (;;)
    {
      if (bu.isNullOrNil(parami.vvy)) {
        break label225;
      }
      this.lHT.setText(parami.vvy);
      AppMethodBeat.o(64926);
      return;
      this.vwh.setVisibility(8);
      break;
      label201:
      this.vwi.setVisibility(8);
      break label117;
      label213:
      this.vwj.setVisibility(8);
    }
    label225:
    this.lHT.setText(null);
    AppMethodBeat.o(64926);
  }
  
  public final void a(cgz paramcgz)
  {
    AppMethodBeat.i(64923);
    if (paramcgz == null)
    {
      locali = null;
      a(locali);
      ev(paramcgz.HsM);
      AppMethodBeat.o(64923);
      return;
    }
    i locali = new i();
    locali.username = paramcgz.HsN;
    locali.vvt = paramcgz.HsP;
    locali.nickname = paramcgz.HsO;
    locali.dPq = paramcgz.dPq;
    locali.vvx = paramcgz.vvx;
    locali.vvy = paramcgz.vvy;
    if (paramcgz.HsR == 0) {}
    for (boolean bool = false;; bool = true)
    {
      locali.vvz = bool;
      locali.vvv = paramcgz.vvv;
      locali.vvu = paramcgz.vvu;
      locali.vvw = paramcgz.vvw;
      break;
    }
  }
  
  public final void a(cqo paramcqo)
  {
    AppMethodBeat.i(64924);
    if (paramcqo == null)
    {
      locali = null;
      a(locali);
      ev(paramcqo.HsM);
      AppMethodBeat.o(64924);
      return;
    }
    i locali = new i();
    locali.username = paramcqo.HsN;
    locali.vvt = paramcqo.HsP;
    locali.nickname = paramcqo.HsO;
    locali.dPq = paramcqo.dPq;
    locali.vvx = paramcqo.vvx;
    locali.vvy = paramcqo.vvy;
    if (paramcqo.HsR == 0) {}
    for (boolean bool = false;; bool = true)
    {
      locali.vvz = bool;
      locali.vvv = paramcqo.vvv;
      locali.vvu = paramcqo.vvu;
      locali.vvw = paramcqo.vvw;
      break;
    }
  }
  
  public final void ay(Intent paramIntent)
  {
    this.vwd = paramIntent;
  }
  
  public final MMActivity dkN()
  {
    return this;
  }
  
  public final void dkO()
  {
    AppMethodBeat.i(64918);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    AppMethodBeat.o(64918);
  }
  
  public final void error(String paramString)
  {
    AppMethodBeat.i(64917);
    h.cm(this, paramString);
    AppMethodBeat.o(64917);
  }
  
  public final void ev(List<bnr> paramList)
  {
    AppMethodBeat.i(64925);
    this.vwk.ew(paramList);
    AppMethodBeat.o(64925);
  }
  
  public int getLayoutId()
  {
    return 2131494639;
  }
  
  public void initView()
  {
    AppMethodBeat.i(64922);
    setMMTitle(2131760845);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(64914);
        if (WxaLuckyMoneyDetailUI.c(WxaLuckyMoneyDetailUI.this) != null) {
          WxaLuckyMoneyDetailUI.this.setResult(0, WxaLuckyMoneyDetailUI.c(WxaLuckyMoneyDetailUI.this));
        }
        for (;;)
        {
          WxaLuckyMoneyDetailUI.this.finish();
          AppMethodBeat.o(64914);
          return true;
          WxaLuckyMoneyDetailUI.this.setResult(-1, null);
        }
      }
    });
    this.vwe = ((ListView)findViewById(2131301770));
    this.vwk = new c(getContext());
    this.agn = LayoutInflater.from(this).inflate(2131494634, null);
    this.vwe.addHeaderView(this.agn);
    this.vwe.setAdapter(this.vwk);
    this.vwk.vvS = false;
    this.vwe.setOnScrollListener(this.vwl);
    this.vwf = ((ImageView)this.agn.findViewById(2131301774));
    this.vwg = ((TextView)this.agn.findViewById(2131301789));
    this.vwh = ((ImageView)this.agn.findViewById(2131301757));
    this.uSM = ((TextView)this.agn.findViewById(2131301792));
    this.vwi = this.agn.findViewById(2131301742);
    this.vvW = ((TextView)this.agn.findViewById(2131301741));
    this.vwj = this.agn.findViewById(2131301759);
    this.mpP = ((TextView)this.agn.findViewById(2131301785));
    this.lHT = ((TextView)this.agn.findViewById(2131301748));
    this.tipDialog = h.b(getContext(), getString(2131760709), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(64915);
        WxaLuckyMoneyDetailUI.this.dkO();
        if ((WxaLuckyMoneyDetailUI.d(WxaLuckyMoneyDetailUI.this).getVisibility() == 8) || (WxaLuckyMoneyDetailUI.e(WxaLuckyMoneyDetailUI.this).getVisibility() == 4))
        {
          ae.i("MicroMsg.WxaLuckyMoneyDetailUI", "user cancel & finish");
          WxaLuckyMoneyDetailUI.this.f(-1, null);
        }
        AppMethodBeat.o(64915);
      }
    });
    this.tipDialog.show();
    AppMethodBeat.o(64922);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(64921);
    if (this.vwd != null) {
      setResult(0, this.vwd);
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(64921);
      return;
      setResult(-1, null);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64919);
    super.onCreate(paramBundle);
    initView();
    this.vwc.d(this, getIntent());
    AppMethodBeat.o(64919);
  }
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    AppMethodBeat.i(64920);
    boolean bool = super.onCreatePanelMenu(paramInt, paramMenu);
    paramMenu = (TextView)findViewById(2131296377);
    if (paramMenu != null) {
      paramMenu.setTextColor(getResources().getColor(2131100576));
    }
    AppMethodBeat.o(64920);
    return bool;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64927);
    super.onDestroy();
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    AppMethodBeat.o(64927);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.WxaLuckyMoneyDetailUI
 * JD-Core Version:    0.7.0.1
 */