package com.tencent.mm.plugin.luckymoney.appbrand.ui.detail;

import android.app.Activity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.appbrand.a.i;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.model.x;
import com.tencent.mm.protocal.protobuf.aty;
import com.tencent.mm.protocal.protobuf.bji;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.wallet_core.ui.e;
import java.util.List;

public class WxaLuckyMoneyDetailUI
  extends WxaLuckyMoneyBaseUI
  implements b
{
  private View Ww;
  private TextView kPB;
  private TextView kRB;
  private TextView nIU;
  private TextView ojg;
  private final a ojm;
  private Intent ojn;
  private ListView ojo;
  private ImageView ojp;
  private TextView ojq;
  private ImageView ojr;
  private View ojs;
  private View ojt;
  private c oju;
  private AbsListView.OnScrollListener ojv;
  private p tipDialog;
  
  public WxaLuckyMoneyDetailUI()
  {
    AppMethodBeat.i(42027);
    this.ojm = new d();
    this.tipDialog = null;
    this.ojn = null;
    this.ojv = new WxaLuckyMoneyDetailUI.1(this);
    AppMethodBeat.o(42027);
  }
  
  private void a(i parami)
  {
    AppMethodBeat.i(42037);
    AppCompatActivity localAppCompatActivity = getContext();
    x.b(this.ojp, parami.oiD, parami.username);
    x.a(localAppCompatActivity, this.ojq, parami.nickname);
    x.a(localAppCompatActivity, this.nIU, parami.oiG);
    if (parami.oiF == 1)
    {
      this.ojr.setVisibility(0);
      this.ojr.setImageResource(2130839415);
      if (parami.oiE != 2) {
        break label201;
      }
      this.ojg.setText(e.E(parami.cNd / 100.0D));
      this.oju.ojc = false;
      this.ojs.setVisibility(0);
      label117:
      if (bo.isNullOrNil(parami.oiH)) {
        break label213;
      }
      this.ojt.setVisibility(0);
      this.kRB.setText(parami.oiH);
      this.kRB.setTextColor(getResources().getColor(2131690258));
    }
    for (;;)
    {
      if (bo.isNullOrNil(parami.oiI)) {
        break label225;
      }
      this.kPB.setText(parami.oiI);
      AppMethodBeat.o(42037);
      return;
      this.ojr.setVisibility(8);
      break;
      label201:
      this.ojs.setVisibility(8);
      break label117;
      label213:
      this.ojt.setVisibility(8);
    }
    label225:
    this.kPB.setText(null);
    AppMethodBeat.o(42037);
  }
  
  public final void Sp(String paramString)
  {
    AppMethodBeat.i(42028);
    h.bO(this, paramString);
    AppMethodBeat.o(42028);
  }
  
  public final void a(bji parambji)
  {
    AppMethodBeat.i(42034);
    if (parambji == null)
    {
      locali = null;
      a(locali);
      ch(parambji.xxI);
      AppMethodBeat.o(42034);
      return;
    }
    i locali = new i();
    locali.username = parambji.xxJ;
    locali.oiD = parambji.xxL;
    locali.nickname = parambji.xxK;
    locali.cNd = parambji.cNd;
    locali.oiH = parambji.oiH;
    locali.oiI = parambji.oiI;
    if (parambji.xxN == 0) {}
    for (boolean bool = false;; bool = true)
    {
      locali.oiJ = bool;
      locali.oiF = parambji.oiF;
      locali.oiE = parambji.oiE;
      locali.oiG = parambji.oiG;
      break;
    }
  }
  
  public final void a(bqs parambqs)
  {
    AppMethodBeat.i(42035);
    if (parambqs == null)
    {
      locali = null;
      a(locali);
      ch(parambqs.xxI);
      AppMethodBeat.o(42035);
      return;
    }
    i locali = new i();
    locali.username = parambqs.xxJ;
    locali.oiD = parambqs.xxL;
    locali.nickname = parambqs.xxK;
    locali.cNd = parambqs.cNd;
    locali.oiH = parambqs.oiH;
    locali.oiI = parambqs.oiI;
    if (parambqs.xxN == 0) {}
    for (boolean bool = false;; bool = true)
    {
      locali.oiJ = bool;
      locali.oiF = parambqs.oiF;
      locali.oiE = parambqs.oiE;
      locali.oiG = parambqs.oiG;
      break;
    }
  }
  
  public final void ad(Intent paramIntent)
  {
    this.ojn = paramIntent;
  }
  
  public final MMActivity bMN()
  {
    return this;
  }
  
  public final void bMO()
  {
    AppMethodBeat.i(42029);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    AppMethodBeat.o(42029);
  }
  
  public final void ch(List<aty> paramList)
  {
    AppMethodBeat.i(42036);
    this.oju.ci(paramList);
    AppMethodBeat.o(42036);
  }
  
  public int getLayoutId()
  {
    return 2130970025;
  }
  
  public void initView()
  {
    AppMethodBeat.i(42033);
    setMMTitle(2131301210);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(42025);
        if (WxaLuckyMoneyDetailUI.c(WxaLuckyMoneyDetailUI.this) != null) {
          WxaLuckyMoneyDetailUI.this.setResult(0, WxaLuckyMoneyDetailUI.c(WxaLuckyMoneyDetailUI.this));
        }
        for (;;)
        {
          WxaLuckyMoneyDetailUI.this.finish();
          AppMethodBeat.o(42025);
          return true;
          WxaLuckyMoneyDetailUI.this.setResult(-1, null);
        }
      }
    });
    this.ojo = ((ListView)findViewById(2131825658));
    this.oju = new c(getContext());
    this.Ww = LayoutInflater.from(this).inflate(2130970022, null);
    this.ojo.addHeaderView(this.Ww);
    this.ojo.setAdapter(this.oju);
    this.oju.ojc = false;
    this.ojo.setOnScrollListener(this.ojv);
    this.ojp = ((ImageView)this.Ww.findViewById(2131825606));
    this.ojq = ((TextView)this.Ww.findViewById(2131825608));
    this.ojr = ((ImageView)this.Ww.findViewById(2131825609));
    this.nIU = ((TextView)this.Ww.findViewById(2131825610));
    this.ojs = this.Ww.findViewById(2131825611);
    this.ojg = ((TextView)this.Ww.findViewById(2131825612));
    this.ojt = this.Ww.findViewById(2131825614);
    this.kRB = ((TextView)this.Ww.findViewById(2131825616));
    this.kPB = ((TextView)this.Ww.findViewById(2131825628));
    this.tipDialog = h.b(getContext(), getString(2131301086), true, new WxaLuckyMoneyDetailUI.3(this));
    this.tipDialog.show();
    AppMethodBeat.o(42033);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(42032);
    if (this.ojn != null) {
      setResult(0, this.ojn);
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(42032);
      return;
      setResult(-1, null);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(42030);
    super.onCreate(paramBundle);
    initView();
    this.ojm.a(this, getIntent());
    AppMethodBeat.o(42030);
  }
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    AppMethodBeat.i(42031);
    boolean bool = super.onCreatePanelMenu(paramInt, paramMenu);
    paramMenu = (TextView)findViewById(2131820974);
    if (paramMenu != null) {
      paramMenu.setTextColor(getResources().getColor(2131690237));
    }
    AppMethodBeat.o(42031);
    return bool;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(42038);
    super.onDestroy();
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    AppMethodBeat.o(42038);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.WxaLuckyMoneyDetailUI
 * JD-Core Version:    0.7.0.1
 */