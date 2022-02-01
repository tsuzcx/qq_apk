package com.tencent.mm.plugin.luckymoney.appbrand.ui.detail;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
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
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.appbrand.a.i;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.model.ag;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.cih;
import com.tencent.mm.protocal.protobuf.dgq;
import com.tencent.mm.protocal.protobuf.dsf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.wallet_core.ui.g;
import java.util.List;

public class WxaLuckyMoneyDetailUI
  extends WxaLuckyMoneyBaseUI
  implements b
{
  private TextView DLp;
  private TextView Euj;
  private final a Eup;
  private Intent Euq;
  private ListView Eur;
  private ImageView Eus;
  private TextView Eut;
  private ImageView Euu;
  private View Euv;
  private View Euw;
  private c Eux;
  private AbsListView.OnScrollListener Euy;
  private View mL;
  private TextView mMA;
  private TextView qCM;
  private s tipDialog;
  
  public WxaLuckyMoneyDetailUI()
  {
    AppMethodBeat.i(64916);
    this.Eup = new d();
    this.tipDialog = null;
    this.Euq = null;
    this.Euy = new AbsListView.OnScrollListener()
    {
      private boolean EuA;
      private boolean Euz = false;
      
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        boolean bool = true;
        AppMethodBeat.i(64913);
        if ((paramAnonymousInt3 == 0) || (!this.Euz))
        {
          AppMethodBeat.o(64913);
          return;
        }
        if (paramAnonymousInt1 > 0) {}
        label64:
        label115:
        label118:
        for (;;)
        {
          if (this.EuA != bool)
          {
            if (bool)
            {
              WxaLuckyMoneyDetailUI.a(WxaLuckyMoneyDetailUI.this, WxaLuckyMoneyDetailUI.this.getResources().getDrawable(a.e.lucky_money_actionbar_bg));
              this.EuA = bool;
            }
          }
          else
          {
            AppMethodBeat.o(64913);
            return;
            paramAnonymousAbsListView = paramAnonymousAbsListView.getChildAt(paramAnonymousInt1);
            if (paramAnonymousAbsListView == null) {
              break label115;
            }
          }
          for (paramAnonymousInt1 = 0 - paramAnonymousAbsListView.getTop();; paramAnonymousInt1 = 0)
          {
            if (paramAnonymousInt1 > 100) {
              break label118;
            }
            bool = false;
            break;
            WxaLuckyMoneyDetailUI.b(WxaLuckyMoneyDetailUI.this);
            break label64;
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
            WxaLuckyMoneyDetailUI.a(WxaLuckyMoneyDetailUI.this).VK(paramAnonymousAbsListView.getCount());
          }
          this.Euz = false;
          AppMethodBeat.o(64912);
          return;
          this.Euz = true;
        }
      }
    };
    AppMethodBeat.o(64916);
  }
  
  private void a(i parami)
  {
    AppMethodBeat.i(64926);
    AppCompatActivity localAppCompatActivity = getContext();
    ag.a(this.Eus, parami.EtG, parami.username);
    ag.a(localAppCompatActivity, this.Eut, parami.nickname);
    ag.a(localAppCompatActivity, this.DLp, parami.EtJ);
    if (parami.EtI == 1)
    {
      this.Euu.setVisibility(0);
      this.Euu.setImageResource(a.e.lucky_money_group_icon);
      if (parami.EtH != 2) {
        break label203;
      }
      this.Euj.setText(g.formatMoney2f(parami.gbJ / 100.0D));
      this.Eux.Euf = false;
      this.Euv.setVisibility(0);
      label118:
      if (Util.isNullOrNil(parami.EtK)) {
        break label215;
      }
      this.Euw.setVisibility(0);
      this.qCM.setText(parami.EtK);
      this.qCM.setTextColor(getResources().getColor(a.c.lucky_money_operation_text_normal_color));
    }
    for (;;)
    {
      if (Util.isNullOrNil(parami.EtL)) {
        break label227;
      }
      this.mMA.setText(parami.EtL);
      AppMethodBeat.o(64926);
      return;
      this.Euu.setVisibility(8);
      break;
      label203:
      this.Euv.setVisibility(8);
      break label118;
      label215:
      this.Euw.setVisibility(8);
    }
    label227:
    this.mMA.setText(null);
    AppMethodBeat.o(64926);
  }
  
  public final void a(dgq paramdgq)
  {
    AppMethodBeat.i(64923);
    if (paramdgq == null)
    {
      locali = null;
      a(locali);
      fR(paramdgq.TNo);
      AppMethodBeat.o(64923);
      return;
    }
    i locali = new i();
    locali.username = paramdgq.TNp;
    locali.EtG = paramdgq.TNr;
    locali.nickname = paramdgq.TNq;
    locali.gbJ = paramdgq.gbJ;
    locali.EtK = paramdgq.EtK;
    locali.EtL = paramdgq.EtL;
    if (paramdgq.TNt == 0) {}
    for (boolean bool = false;; bool = true)
    {
      locali.EtM = bool;
      locali.EtI = paramdgq.EtI;
      locali.EtH = paramdgq.EtH;
      locali.EtJ = paramdgq.EtJ;
      break;
    }
  }
  
  public final void a(dsf paramdsf)
  {
    AppMethodBeat.i(64924);
    if (paramdsf == null)
    {
      locali = null;
      a(locali);
      fR(paramdsf.TNo);
      AppMethodBeat.o(64924);
      return;
    }
    i locali = new i();
    locali.username = paramdsf.TNp;
    locali.EtG = paramdsf.TNr;
    locali.nickname = paramdsf.TNq;
    locali.gbJ = paramdsf.gbJ;
    locali.EtK = paramdsf.EtK;
    locali.EtL = paramdsf.EtL;
    if (paramdsf.TNt == 0) {}
    for (boolean bool = false;; bool = true)
    {
      locali.EtM = bool;
      locali.EtI = paramdsf.EtI;
      locali.EtH = paramdsf.EtH;
      locali.EtJ = paramdsf.EtJ;
      break;
    }
  }
  
  public final void aD(Intent paramIntent)
  {
    this.Euq = paramIntent;
  }
  
  public final MMActivity eOa()
  {
    return this;
  }
  
  public final void eOb()
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
    h.cO(this, paramString);
    AppMethodBeat.o(64917);
  }
  
  public final void fR(List<cih> paramList)
  {
    AppMethodBeat.i(64925);
    this.Eux.fS(paramList);
    AppMethodBeat.o(64925);
  }
  
  public int getLayoutId()
  {
    return a.g.lucky_money_detail_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(64922);
    setMMTitle(a.i.lucky_money_detail);
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
    this.Eur = ((ListView)findViewById(a.f.lucky_money_detail_record_list));
    this.Eux = new c(getContext());
    this.mL = LayoutInflater.from(this).inflate(a.g.lucky_money_detail_header, null);
    this.Eur.addHeaderView(this.mL);
    this.Eur.setAdapter(this.Eux);
    this.Eux.Euf = false;
    this.Eur.setOnScrollListener(this.Euy);
    this.Eus = ((ImageView)this.mL.findViewById(a.f.lucky_money_detail_sender_avatar));
    this.Eut = ((TextView)this.mL.findViewById(a.f.lucky_money_detail_whose));
    this.Euu = ((ImageView)this.mL.findViewById(a.f.lucky_money_detail_group_icon));
    this.DLp = ((TextView)this.mL.findViewById(a.f.lucky_money_detail_wishing));
    this.Euv = this.mL.findViewById(a.f.lucky_money_detail_amount_area);
    this.Euj = ((TextView)this.mL.findViewById(a.f.lucky_money_detail_amount));
    this.Euw = this.mL.findViewById(a.f.lucky_money_detail_layout);
    this.qCM = ((TextView)this.mL.findViewById(a.f.lucky_money_detail_tips));
    this.mMA = ((TextView)this.mL.findViewById(a.f.lucky_money_detail_desc));
    this.tipDialog = h.a(getContext(), getString(a.i.loading_tips), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(64915);
        WxaLuckyMoneyDetailUI.this.eOb();
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
    if (this.Euq != null) {
      setResult(0, this.Euq);
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
    this.Eup.d(this, getIntent());
    AppMethodBeat.o(64919);
  }
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    AppMethodBeat.i(64920);
    boolean bool = super.onCreatePanelMenu(paramInt, paramMenu);
    paramMenu = (TextView)findViewById(a.f.action_option_text);
    if (paramMenu != null) {
      paramMenu.setTextColor(getResources().getColor(a.c.lucky_money_goldstyle_envelop_primary_text_color));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.WxaLuckyMoneyDetailUI
 * JD-Core Version:    0.7.0.1
 */