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
import com.tencent.mm.protocal.protobuf.bez;
import com.tencent.mm.protocal.protobuf.bwu;
import com.tencent.mm.protocal.protobuf.cfr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.wallet_core.ui.e;
import java.util.List;

public class WxaLuckyMoneyDetailUI
  extends WxaLuckyMoneyBaseUI
  implements b
{
  private View adC;
  private TextView kFd;
  private TextView lln;
  private TextView sYT;
  private final a sYZ;
  private Intent sZa;
  private ListView sZb;
  private ImageView sZc;
  private TextView sZd;
  private ImageView sZe;
  private View sZf;
  private View sZg;
  private c sZh;
  private AbsListView.OnScrollListener sZi;
  private TextView swB;
  private p tipDialog;
  
  public WxaLuckyMoneyDetailUI()
  {
    AppMethodBeat.i(64916);
    this.sYZ = new d();
    this.tipDialog = null;
    this.sZa = null;
    this.sZi = new AbsListView.OnScrollListener()
    {
      private boolean sZj = false;
      private boolean sZk;
      
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        boolean bool = true;
        AppMethodBeat.i(64913);
        if ((paramAnonymousInt3 == 0) || (!this.sZj))
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
          if (this.sZk != bool)
          {
            if (bool)
            {
              WxaLuckyMoneyDetailUI.a(WxaLuckyMoneyDetailUI.this, WxaLuckyMoneyDetailUI.this.getResources().getDrawable(2131232950));
              this.sZk = bool;
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
            WxaLuckyMoneyDetailUI.a(WxaLuckyMoneyDetailUI.this).FJ(paramAnonymousAbsListView.getCount());
          }
          this.sZj = false;
          AppMethodBeat.o(64912);
          return;
          this.sZj = true;
        }
      }
    };
    AppMethodBeat.o(64916);
  }
  
  private void a(i parami)
  {
    AppMethodBeat.i(64926);
    AppCompatActivity localAppCompatActivity = getContext();
    z.b(this.sZc, parami.sYq, parami.username);
    z.a(localAppCompatActivity, this.sZd, parami.nickname);
    z.a(localAppCompatActivity, this.swB, parami.sYt);
    if (parami.sYs == 1)
    {
      this.sZe.setVisibility(0);
      this.sZe.setImageResource(2131233028);
      if (parami.sYr != 2) {
        break label201;
      }
      this.sYT.setText(e.D(parami.dEb / 100.0D));
      this.sZh.sYP = false;
      this.sZf.setVisibility(0);
      label117:
      if (bt.isNullOrNil(parami.sYu)) {
        break label213;
      }
      this.sZg.setVisibility(0);
      this.lln.setText(parami.sYu);
      this.lln.setTextColor(getResources().getColor(2131100598));
    }
    for (;;)
    {
      if (bt.isNullOrNil(parami.sYv)) {
        break label225;
      }
      this.kFd.setText(parami.sYv);
      AppMethodBeat.o(64926);
      return;
      this.sZe.setVisibility(8);
      break;
      label201:
      this.sZf.setVisibility(8);
      break label117;
      label213:
      this.sZg.setVisibility(8);
    }
    label225:
    this.kFd.setText(null);
    AppMethodBeat.o(64926);
  }
  
  public final void a(bwu parambwu)
  {
    AppMethodBeat.i(64923);
    if (parambwu == null)
    {
      locali = null;
      a(locali);
      ea(parambwu.DTf);
      AppMethodBeat.o(64923);
      return;
    }
    i locali = new i();
    locali.username = parambwu.DTg;
    locali.sYq = parambwu.DTi;
    locali.nickname = parambwu.DTh;
    locali.dEb = parambwu.dEb;
    locali.sYu = parambwu.sYu;
    locali.sYv = parambwu.sYv;
    if (parambwu.DTk == 0) {}
    for (boolean bool = false;; bool = true)
    {
      locali.sYw = bool;
      locali.sYs = parambwu.sYs;
      locali.sYr = parambwu.sYr;
      locali.sYt = parambwu.sYt;
      break;
    }
  }
  
  public final void a(cfr paramcfr)
  {
    AppMethodBeat.i(64924);
    if (paramcfr == null)
    {
      locali = null;
      a(locali);
      ea(paramcfr.DTf);
      AppMethodBeat.o(64924);
      return;
    }
    i locali = new i();
    locali.username = paramcfr.DTg;
    locali.sYq = paramcfr.DTi;
    locali.nickname = paramcfr.DTh;
    locali.dEb = paramcfr.dEb;
    locali.sYu = paramcfr.sYu;
    locali.sYv = paramcfr.sYv;
    if (paramcfr.DTk == 0) {}
    for (boolean bool = false;; bool = true)
    {
      locali.sYw = bool;
      locali.sYs = paramcfr.sYs;
      locali.sYr = paramcfr.sYr;
      locali.sYt = paramcfr.sYt;
      break;
    }
  }
  
  public final void ar(Intent paramIntent)
  {
    this.sZa = paramIntent;
  }
  
  public final MMActivity cKW()
  {
    return this;
  }
  
  public final void cKX()
  {
    AppMethodBeat.i(64918);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    AppMethodBeat.o(64918);
  }
  
  public final void ea(List<bez> paramList)
  {
    AppMethodBeat.i(64925);
    this.sZh.eb(paramList);
    AppMethodBeat.o(64925);
  }
  
  public final void error(String paramString)
  {
    AppMethodBeat.i(64917);
    h.cf(this, paramString);
    AppMethodBeat.o(64917);
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
    this.sZb = ((ListView)findViewById(2131301770));
    this.sZh = new c(getContext());
    this.adC = LayoutInflater.from(this).inflate(2131494634, null);
    this.sZb.addHeaderView(this.adC);
    this.sZb.setAdapter(this.sZh);
    this.sZh.sYP = false;
    this.sZb.setOnScrollListener(this.sZi);
    this.sZc = ((ImageView)this.adC.findViewById(2131301774));
    this.sZd = ((TextView)this.adC.findViewById(2131301789));
    this.sZe = ((ImageView)this.adC.findViewById(2131301757));
    this.swB = ((TextView)this.adC.findViewById(2131301792));
    this.sZf = this.adC.findViewById(2131301742);
    this.sYT = ((TextView)this.adC.findViewById(2131301741));
    this.sZg = this.adC.findViewById(2131301759);
    this.lln = ((TextView)this.adC.findViewById(2131301785));
    this.kFd = ((TextView)this.adC.findViewById(2131301748));
    this.tipDialog = h.b(getContext(), getString(2131760709), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(64915);
        WxaLuckyMoneyDetailUI.this.cKX();
        if ((WxaLuckyMoneyDetailUI.d(WxaLuckyMoneyDetailUI.this).getVisibility() == 8) || (WxaLuckyMoneyDetailUI.e(WxaLuckyMoneyDetailUI.this).getVisibility() == 4))
        {
          ad.i("MicroMsg.WxaLuckyMoneyDetailUI", "user cancel & finish");
          WxaLuckyMoneyDetailUI.this.e(-1, null);
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
    if (this.sZa != null) {
      setResult(0, this.sZa);
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
    this.sYZ.d(this, getIntent());
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