package com.tencent.mm.plugin.luckymoney.appbrand.ui.detail;

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
import com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.model.ah;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.cyk;
import com.tencent.mm.protocal.protobuf.dyx;
import com.tencent.mm.protocal.protobuf.ela;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import java.util.List;

public class WxaLuckyMoneyDetailUI
  extends WxaLuckyMoneyBaseUI
  implements b
{
  private TextView JCr;
  private TextView KmQ;
  private final a KmW;
  private Intent KmX;
  private ListView KmY;
  private ImageView KmZ;
  private TextView Kna;
  private ImageView Knb;
  private View Knc;
  private View Knd;
  private c Kne;
  private AbsListView.OnScrollListener Knf;
  private View nJ;
  private TextView pJi;
  private TextView tHK;
  private w tipDialog;
  
  public WxaLuckyMoneyDetailUI()
  {
    AppMethodBeat.i(64916);
    this.KmW = new d();
    this.tipDialog = null;
    this.KmX = null;
    this.Knf = new AbsListView.OnScrollListener()
    {
      private boolean Kng = false;
      private boolean Knh;
      
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        boolean bool = true;
        AppMethodBeat.i(64913);
        if ((paramAnonymousInt3 == 0) || (!this.Kng))
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
          if (this.Knh != bool)
          {
            if (bool)
            {
              WxaLuckyMoneyDetailUI.a(WxaLuckyMoneyDetailUI.this, WxaLuckyMoneyDetailUI.this.getResources().getDrawable(a.e.lucky_money_actionbar_bg));
              this.Knh = bool;
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
            WxaLuckyMoneyDetailUI.a(WxaLuckyMoneyDetailUI.this).ZG(paramAnonymousAbsListView.getCount());
          }
          this.Kng = false;
          AppMethodBeat.o(64912);
          return;
          this.Kng = true;
        }
      }
    };
    AppMethodBeat.o(64916);
  }
  
  private void a(com.tencent.mm.plugin.luckymoney.appbrand.a.i parami)
  {
    AppMethodBeat.i(64926);
    AppCompatActivity localAppCompatActivity = getContext();
    ah.a(this.KmZ, parami.Kmn, parami.username);
    ah.a(localAppCompatActivity, this.Kna, parami.nickname);
    ah.a(localAppCompatActivity, this.JCr, parami.Kmq);
    if (parami.Kmp == 1)
    {
      this.Knb.setVisibility(0);
      this.Knb.setImageResource(a.e.lucky_money_group_icon);
      if (parami.Kmo != 2) {
        break label203;
      }
      this.KmQ.setText(com.tencent.mm.wallet_core.ui.i.formatMoney2f(parami.ihV / 100.0D));
      this.Kne.KmM = false;
      this.Knc.setVisibility(0);
      label118:
      if (Util.isNullOrNil(parami.Kmr)) {
        break label215;
      }
      this.Knd.setVisibility(0);
      this.tHK.setText(parami.Kmr);
      this.tHK.setTextColor(getResources().getColor(a.c.lucky_money_operation_text_normal_color));
    }
    for (;;)
    {
      if (Util.isNullOrNil(parami.Kms)) {
        break label227;
      }
      this.pJi.setText(parami.Kms);
      AppMethodBeat.o(64926);
      return;
      this.Knb.setVisibility(8);
      break;
      label203:
      this.Knc.setVisibility(8);
      break label118;
      label215:
      this.Knd.setVisibility(8);
    }
    label227:
    this.pJi.setText(null);
    AppMethodBeat.o(64926);
  }
  
  public final void a(dyx paramdyx)
  {
    AppMethodBeat.i(64923);
    if (paramdyx == null)
    {
      locali = null;
      a(locali);
      iP(paramdyx.abdH);
      AppMethodBeat.o(64923);
      return;
    }
    com.tencent.mm.plugin.luckymoney.appbrand.a.i locali = new com.tencent.mm.plugin.luckymoney.appbrand.a.i();
    locali.username = paramdyx.abdI;
    locali.Kmn = paramdyx.abdK;
    locali.nickname = paramdyx.abdJ;
    locali.ihV = paramdyx.ihV;
    locali.Kmr = paramdyx.Kmr;
    locali.Kms = paramdyx.Kms;
    if (paramdyx.abdM == 0) {}
    for (boolean bool = false;; bool = true)
    {
      locali.Kmt = bool;
      locali.Kmp = paramdyx.Kmp;
      locali.Kmo = paramdyx.Kmo;
      locali.Kmq = paramdyx.Kmq;
      break;
    }
  }
  
  public final void a(ela paramela)
  {
    AppMethodBeat.i(64924);
    if (paramela == null)
    {
      locali = null;
      a(locali);
      iP(paramela.abdH);
      AppMethodBeat.o(64924);
      return;
    }
    com.tencent.mm.plugin.luckymoney.appbrand.a.i locali = new com.tencent.mm.plugin.luckymoney.appbrand.a.i();
    locali.username = paramela.abdI;
    locali.Kmn = paramela.abdK;
    locali.nickname = paramela.abdJ;
    locali.ihV = paramela.ihV;
    locali.Kmr = paramela.Kmr;
    locali.Kms = paramela.Kms;
    if (paramela.abdM == 0) {}
    for (boolean bool = false;; bool = true)
    {
      locali.Kmt = bool;
      locali.Kmp = paramela.Kmp;
      locali.Kmo = paramela.Kmo;
      locali.Kmq = paramela.Kmq;
      break;
    }
  }
  
  public final void aY(Intent paramIntent)
  {
    this.KmX = paramIntent;
  }
  
  public final void error(String paramString)
  {
    AppMethodBeat.i(64917);
    k.cZ(this, paramString);
    AppMethodBeat.o(64917);
  }
  
  public final MMActivity fWt()
  {
    return this;
  }
  
  public final void fWu()
  {
    AppMethodBeat.i(64918);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    AppMethodBeat.o(64918);
  }
  
  public int getLayoutId()
  {
    return a.g.lucky_money_detail_ui;
  }
  
  public final void iP(List<cyk> paramList)
  {
    AppMethodBeat.i(64925);
    this.Kne.iQ(paramList);
    AppMethodBeat.o(64925);
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
    this.KmY = ((ListView)findViewById(a.f.lucky_money_detail_record_list));
    this.Kne = new c(getContext());
    this.nJ = LayoutInflater.from(this).inflate(a.g.lucky_money_detail_header, null);
    this.KmY.addHeaderView(this.nJ);
    this.KmY.setAdapter(this.Kne);
    this.Kne.KmM = false;
    this.KmY.setOnScrollListener(this.Knf);
    this.KmZ = ((ImageView)this.nJ.findViewById(a.f.lucky_money_detail_sender_avatar));
    this.Kna = ((TextView)this.nJ.findViewById(a.f.lucky_money_detail_whose));
    this.Knb = ((ImageView)this.nJ.findViewById(a.f.lucky_money_detail_group_icon));
    this.JCr = ((TextView)this.nJ.findViewById(a.f.lucky_money_detail_wishing));
    this.Knc = this.nJ.findViewById(a.f.lucky_money_detail_amount_area);
    this.KmQ = ((TextView)this.nJ.findViewById(a.f.lucky_money_detail_amount));
    this.Knd = this.nJ.findViewById(a.f.lucky_money_detail_layout);
    this.tHK = ((TextView)this.nJ.findViewById(a.f.lucky_money_detail_tips));
    this.pJi = ((TextView)this.nJ.findViewById(a.f.lucky_money_detail_desc));
    this.tipDialog = k.a(getContext(), getString(a.i.loading_tips), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(64915);
        WxaLuckyMoneyDetailUI.this.fWu();
        if ((WxaLuckyMoneyDetailUI.d(WxaLuckyMoneyDetailUI.this).getVisibility() == 8) || (WxaLuckyMoneyDetailUI.e(WxaLuckyMoneyDetailUI.this).getVisibility() == 4))
        {
          Log.i("MicroMsg.WxaLuckyMoneyDetailUI", "user cancel & finish");
          WxaLuckyMoneyDetailUI.this.i(-1, null);
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
    if (this.KmX != null) {
      setResult(0, this.KmX);
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
    this.KmW.d(this, getIntent());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.WxaLuckyMoneyDetailUI
 * JD-Core Version:    0.7.0.1
 */