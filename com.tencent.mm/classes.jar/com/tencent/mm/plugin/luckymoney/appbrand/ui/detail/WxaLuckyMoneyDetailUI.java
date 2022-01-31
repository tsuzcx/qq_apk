package com.tencent.mm.plugin.luckymoney.appbrand.ui.detail;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.plugin.luckymoney.appbrand.a.i;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.b.o;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.aog;
import com.tencent.mm.protocal.c.bcf;
import com.tencent.mm.protocal.c.bic;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.ui.e;
import java.util.LinkedList;
import java.util.List;

public class WxaLuckyMoneyDetailUI
  extends WxaLuckyMoneyBaseUI
  implements b
{
  private View VH;
  private TextView iIV;
  private TextView iKV;
  private TextView lLM;
  private final a lLS = new d();
  private Intent lLT = null;
  private ListView lLU;
  private ImageView lLV;
  private TextView lLW;
  private ImageView lLX;
  private View lLY;
  private View lLZ;
  private c lMa;
  private AbsListView.OnScrollListener lMb = new WxaLuckyMoneyDetailUI.1(this);
  private TextView lly;
  private p tipDialog = null;
  
  private void a(i parami)
  {
    AppCompatActivity localAppCompatActivity = this.mController.uMN;
    o.a(this.lLV, parami.lLj, parami.username);
    o.a(localAppCompatActivity, this.lLW, parami.nickname);
    o.a(localAppCompatActivity, this.lly, parami.lLm);
    if (parami.lLl == 1)
    {
      this.lLX.setVisibility(0);
      this.lLX.setImageResource(a.e.lucky_money_group_icon);
      if (parami.lLk != 2) {
        break label196;
      }
      this.lLM.setText(e.A(parami.ceq / 100.0D));
      this.lMa.lLI = false;
      this.lLY.setVisibility(0);
      label116:
      if (bk.bl(parami.lLn)) {
        break label208;
      }
      this.lLZ.setVisibility(0);
      this.iKV.setText(parami.lLn);
      this.iKV.setTextColor(getResources().getColor(a.c.lucky_money_operation_text_normal_color));
    }
    for (;;)
    {
      if (bk.bl(parami.lLo)) {
        break label220;
      }
      this.iIV.setText(parami.lLo);
      return;
      this.lLX.setVisibility(8);
      break;
      label196:
      this.lLY.setVisibility(8);
      break label116;
      label208:
      this.lLZ.setVisibility(8);
    }
    label220:
    this.iIV.setText(null);
  }
  
  public final void K(Intent paramIntent)
  {
    this.lLT = paramIntent;
  }
  
  public final void a(bcf parambcf)
  {
    if (parambcf == null)
    {
      localObject = null;
      a((i)localObject);
      int i = parambcf.txH;
      localObject = parambcf.txC;
      bK(parambcf.txC);
      return;
    }
    Object localObject = new i();
    ((i)localObject).username = parambcf.txD;
    ((i)localObject).lLj = parambcf.txF;
    ((i)localObject).nickname = parambcf.txE;
    ((i)localObject).ceq = parambcf.ceq;
    ((i)localObject).lLn = parambcf.lLn;
    ((i)localObject).lLo = parambcf.lLo;
    if (parambcf.txH == 0) {}
    for (boolean bool = false;; bool = true)
    {
      ((i)localObject).lLp = bool;
      ((i)localObject).lLl = parambcf.lLl;
      ((i)localObject).lLk = parambcf.lLk;
      ((i)localObject).lLm = parambcf.lLm;
      break;
    }
  }
  
  public final void a(bic parambic)
  {
    if (parambic == null)
    {
      localObject = null;
      a((i)localObject);
      int i = parambic.txH;
      localObject = parambic.txC;
      bK(parambic.txC);
      return;
    }
    Object localObject = new i();
    ((i)localObject).username = parambic.txD;
    ((i)localObject).lLj = parambic.txF;
    ((i)localObject).nickname = parambic.txE;
    ((i)localObject).ceq = parambic.ceq;
    ((i)localObject).lLn = parambic.lLn;
    ((i)localObject).lLo = parambic.lLo;
    if (parambic.txH == 0) {}
    for (boolean bool = false;; bool = true)
    {
      ((i)localObject).lLp = bool;
      ((i)localObject).lLl = parambic.lLl;
      ((i)localObject).lLk = parambic.lLk;
      ((i)localObject).lLm = parambic.lLm;
      break;
    }
  }
  
  public final void bK(List<aog> paramList)
  {
    c localc = this.lMa;
    if (paramList == null) {}
    for (localc.lLG = new LinkedList();; localc.lLG = paramList)
    {
      localc.notifyDataSetChanged();
      return;
    }
  }
  
  public final MMActivity bfn()
  {
    return this;
  }
  
  public final void bfo()
  {
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
  }
  
  public final void error(String paramString)
  {
    h.bC(this, paramString);
  }
  
  protected final int getLayoutId()
  {
    return a.g.lucky_money_detail_ui;
  }
  
  protected final void initView()
  {
    setMMTitle(a.i.lucky_money_detail);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        if (WxaLuckyMoneyDetailUI.c(WxaLuckyMoneyDetailUI.this) != null) {
          WxaLuckyMoneyDetailUI.this.setResult(0, WxaLuckyMoneyDetailUI.c(WxaLuckyMoneyDetailUI.this));
        }
        for (;;)
        {
          WxaLuckyMoneyDetailUI.this.finish();
          return true;
          WxaLuckyMoneyDetailUI.this.setResult(-1, null);
        }
      }
    });
    this.lLU = ((ListView)findViewById(a.f.lucky_money_detail_record_list));
    this.lMa = new c(this.mController.uMN);
    this.VH = LayoutInflater.from(this).inflate(a.g.lucky_money_detail_header, null);
    this.lLU.addHeaderView(this.VH);
    this.lLU.setAdapter(this.lMa);
    this.lMa.lLI = false;
    this.lLU.setOnScrollListener(this.lMb);
    this.lLV = ((ImageView)this.VH.findViewById(a.f.lucky_money_detail_sender_avatar));
    this.lLW = ((TextView)this.VH.findViewById(a.f.lucky_money_detail_whose));
    this.lLX = ((ImageView)this.VH.findViewById(a.f.lucky_money_detail_group_icon));
    this.lly = ((TextView)this.VH.findViewById(a.f.lucky_money_detail_wishing));
    this.lLY = this.VH.findViewById(a.f.lucky_money_detail_amount_area);
    this.lLM = ((TextView)this.VH.findViewById(a.f.lucky_money_detail_amount));
    this.lLZ = this.VH.findViewById(a.f.lucky_money_detail_layout);
    this.iKV = ((TextView)this.VH.findViewById(a.f.lucky_money_detail_tips));
    this.iIV = ((TextView)this.VH.findViewById(a.f.lucky_money_detail_desc));
    this.tipDialog = h.b(this.mController.uMN, getString(a.i.loading_tips), true, new WxaLuckyMoneyDetailUI.3(this));
    this.tipDialog.show();
  }
  
  public void onBackPressed()
  {
    if (this.lLT != null) {
      setResult(0, this.lLT);
    }
    for (;;)
    {
      finish();
      return;
      setResult(-1, null);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
    this.lLS.a(this, getIntent());
  }
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    boolean bool = super.onCreatePanelMenu(paramInt, paramMenu);
    paramMenu = (TextView)findViewById(a.f.action_option_text);
    if (paramMenu != null) {
      paramMenu.setTextColor(getResources().getColor(a.c.lucky_money_goldstyle_envelop_primary_text_color));
    }
    return bool;
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.WxaLuckyMoneyDetailUI
 * JD-Core Version:    0.7.0.1
 */