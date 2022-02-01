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
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.protocal.protobuf.cai;
import com.tencent.mm.protocal.protobuf.cxg;
import com.tencent.mm.protocal.protobuf.din;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.wallet_core.ui.f;
import java.util.List;

public class WxaLuckyMoneyDetailUI
  extends WxaLuckyMoneyBaseUI
  implements b
{
  private View agA;
  private TextView jVn;
  private TextView nAB;
  private q tipDialog;
  private TextView yQk;
  private final a yQq;
  private Intent yQr;
  private ListView yQs;
  private ImageView yQt;
  private TextView yQu;
  private ImageView yQv;
  private View yQw;
  private View yQx;
  private c yQy;
  private AbsListView.OnScrollListener yQz;
  private TextView yln;
  
  public WxaLuckyMoneyDetailUI()
  {
    AppMethodBeat.i(64916);
    this.yQq = new d();
    this.tipDialog = null;
    this.yQr = null;
    this.yQz = new AbsListView.OnScrollListener()
    {
      private boolean yQA = false;
      private boolean yQB;
      
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        boolean bool = true;
        AppMethodBeat.i(64913);
        if ((paramAnonymousInt3 == 0) || (!this.yQA))
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
          if (this.yQB != bool)
          {
            if (bool)
            {
              WxaLuckyMoneyDetailUI.a(WxaLuckyMoneyDetailUI.this, WxaLuckyMoneyDetailUI.this.getResources().getDrawable(2131233600));
              this.yQB = bool;
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
            WxaLuckyMoneyDetailUI.a(WxaLuckyMoneyDetailUI.this).PB(paramAnonymousAbsListView.getCount());
          }
          this.yQA = false;
          AppMethodBeat.o(64912);
          return;
          this.yQA = true;
        }
      }
    };
    AppMethodBeat.o(64916);
  }
  
  private void a(i parami)
  {
    AppMethodBeat.i(64926);
    AppCompatActivity localAppCompatActivity = getContext();
    af.a(this.yQt, parami.yPH, parami.username);
    af.a(localAppCompatActivity, this.yQu, parami.nickname);
    af.a(localAppCompatActivity, this.yln, parami.yPK);
    if (parami.yPJ == 1)
    {
      this.yQv.setVisibility(0);
      this.yQv.setImageResource(2131233681);
      if (parami.yPI != 2) {
        break label201;
      }
      this.yQk.setText(f.formatMoney2f(parami.eht / 100.0D));
      this.yQy.yQg = false;
      this.yQw.setVisibility(0);
      label117:
      if (Util.isNullOrNil(parami.yPL)) {
        break label213;
      }
      this.yQx.setVisibility(0);
      this.nAB.setText(parami.yPL);
      this.nAB.setTextColor(getResources().getColor(2131100766));
    }
    for (;;)
    {
      if (Util.isNullOrNil(parami.yPM)) {
        break label225;
      }
      this.jVn.setText(parami.yPM);
      AppMethodBeat.o(64926);
      return;
      this.yQv.setVisibility(8);
      break;
      label201:
      this.yQw.setVisibility(8);
      break label117;
      label213:
      this.yQx.setVisibility(8);
    }
    label225:
    this.jVn.setText(null);
    AppMethodBeat.o(64926);
  }
  
  public final void a(cxg paramcxg)
  {
    AppMethodBeat.i(64923);
    if (paramcxg == null)
    {
      locali = null;
      a(locali);
      fp(paramcxg.MBI);
      AppMethodBeat.o(64923);
      return;
    }
    i locali = new i();
    locali.username = paramcxg.MBJ;
    locali.yPH = paramcxg.MBL;
    locali.nickname = paramcxg.MBK;
    locali.eht = paramcxg.eht;
    locali.yPL = paramcxg.yPL;
    locali.yPM = paramcxg.yPM;
    if (paramcxg.MBN == 0) {}
    for (boolean bool = false;; bool = true)
    {
      locali.yPN = bool;
      locali.yPJ = paramcxg.yPJ;
      locali.yPI = paramcxg.yPI;
      locali.yPK = paramcxg.yPK;
      break;
    }
  }
  
  public final void a(din paramdin)
  {
    AppMethodBeat.i(64924);
    if (paramdin == null)
    {
      locali = null;
      a(locali);
      fp(paramdin.MBI);
      AppMethodBeat.o(64924);
      return;
    }
    i locali = new i();
    locali.username = paramdin.MBJ;
    locali.yPH = paramdin.MBL;
    locali.nickname = paramdin.MBK;
    locali.eht = paramdin.eht;
    locali.yPL = paramdin.yPL;
    locali.yPM = paramdin.yPM;
    if (paramdin.MBN == 0) {}
    for (boolean bool = false;; bool = true)
    {
      locali.yPN = bool;
      locali.yPJ = paramdin.yPJ;
      locali.yPI = paramdin.yPI;
      locali.yPK = paramdin.yPK;
      break;
    }
  }
  
  public final void aF(Intent paramIntent)
  {
    this.yQr = paramIntent;
  }
  
  public final MMActivity eeF()
  {
    return this;
  }
  
  public final void eeG()
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
    h.cD(this, paramString);
    AppMethodBeat.o(64917);
  }
  
  public final void fp(List<cai> paramList)
  {
    AppMethodBeat.i(64925);
    this.yQy.fq(paramList);
    AppMethodBeat.o(64925);
  }
  
  public int getLayoutId()
  {
    return 2131495361;
  }
  
  public void initView()
  {
    AppMethodBeat.i(64922);
    setMMTitle(2131762602);
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
    this.yQs = ((ListView)findViewById(2131304073));
    this.yQy = new c(getContext());
    this.agA = LayoutInflater.from(this).inflate(2131495356, null);
    this.yQs.addHeaderView(this.agA);
    this.yQs.setAdapter(this.yQy);
    this.yQy.yQg = false;
    this.yQs.setOnScrollListener(this.yQz);
    this.yQt = ((ImageView)this.agA.findViewById(2131304077));
    this.yQu = ((TextView)this.agA.findViewById(2131304094));
    this.yQv = ((ImageView)this.agA.findViewById(2131304060));
    this.yln = ((TextView)this.agA.findViewById(2131304097));
    this.yQw = this.agA.findViewById(2131304045);
    this.yQk = ((TextView)this.agA.findViewById(2131304044));
    this.yQx = this.agA.findViewById(2131304062);
    this.nAB = ((TextView)this.agA.findViewById(2131304090));
    this.jVn = ((TextView)this.agA.findViewById(2131304051));
    this.tipDialog = h.a(getContext(), getString(2131762446), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(64915);
        WxaLuckyMoneyDetailUI.this.eeG();
        if ((WxaLuckyMoneyDetailUI.d(WxaLuckyMoneyDetailUI.this).getVisibility() == 8) || (WxaLuckyMoneyDetailUI.e(WxaLuckyMoneyDetailUI.this).getVisibility() == 4))
        {
          Log.i("MicroMsg.WxaLuckyMoneyDetailUI", "user cancel & finish");
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
    if (this.yQr != null) {
      setResult(0, this.yQr);
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
    this.yQq.d(this, getIntent());
    AppMethodBeat.o(64919);
  }
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    AppMethodBeat.i(64920);
    boolean bool = super.onCreatePanelMenu(paramInt, paramMenu);
    paramMenu = (TextView)findViewById(2131296402);
    if (paramMenu != null) {
      paramMenu.setTextColor(getResources().getColor(2131100744));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.WxaLuckyMoneyDetailUI
 * JD-Core Version:    0.7.0.1
 */