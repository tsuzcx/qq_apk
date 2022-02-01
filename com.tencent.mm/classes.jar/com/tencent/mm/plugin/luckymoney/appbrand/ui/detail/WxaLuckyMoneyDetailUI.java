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
import com.tencent.mm.protocal.protobuf.bmz;
import com.tencent.mm.protocal.protobuf.cgf;
import com.tencent.mm.protocal.protobuf.cpu;
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
  private View agn;
  private TextView lDu;
  private TextView mkS;
  private p tipDialog;
  private TextView uGZ;
  private TextView vjR;
  private final a vjX;
  private Intent vjY;
  private ListView vjZ;
  private ImageView vka;
  private TextView vkb;
  private ImageView vkc;
  private View vkd;
  private View vke;
  private c vkf;
  private AbsListView.OnScrollListener vkg;
  
  public WxaLuckyMoneyDetailUI()
  {
    AppMethodBeat.i(64916);
    this.vjX = new d();
    this.tipDialog = null;
    this.vjY = null;
    this.vkg = new AbsListView.OnScrollListener()
    {
      private boolean vkh = false;
      private boolean vki;
      
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        boolean bool = true;
        AppMethodBeat.i(64913);
        if ((paramAnonymousInt3 == 0) || (!this.vkh))
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
          if (this.vki != bool)
          {
            if (bool)
            {
              WxaLuckyMoneyDetailUI.a(WxaLuckyMoneyDetailUI.this, WxaLuckyMoneyDetailUI.this.getResources().getDrawable(2131232950));
              this.vki = bool;
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
            WxaLuckyMoneyDetailUI.a(WxaLuckyMoneyDetailUI.this).Ja(paramAnonymousAbsListView.getCount());
          }
          this.vkh = false;
          AppMethodBeat.o(64912);
          return;
          this.vkh = true;
        }
      }
    };
    AppMethodBeat.o(64916);
  }
  
  private void a(i parami)
  {
    AppMethodBeat.i(64926);
    AppCompatActivity localAppCompatActivity = getContext();
    z.b(this.vka, parami.vjo, parami.username);
    z.a(localAppCompatActivity, this.vkb, parami.nickname);
    z.a(localAppCompatActivity, this.uGZ, parami.vjr);
    if (parami.vjq == 1)
    {
      this.vkc.setVisibility(0);
      this.vkc.setImageResource(2131233028);
      if (parami.vjp != 2) {
        break label201;
      }
      this.vjR.setText(e.C(parami.dOa / 100.0D));
      this.vkf.vjN = false;
      this.vkd.setVisibility(0);
      label117:
      if (bt.isNullOrNil(parami.vjs)) {
        break label213;
      }
      this.vke.setVisibility(0);
      this.mkS.setText(parami.vjs);
      this.mkS.setTextColor(getResources().getColor(2131100598));
    }
    for (;;)
    {
      if (bt.isNullOrNil(parami.vjt)) {
        break label225;
      }
      this.lDu.setText(parami.vjt);
      AppMethodBeat.o(64926);
      return;
      this.vkc.setVisibility(8);
      break;
      label201:
      this.vkd.setVisibility(8);
      break label117;
      label213:
      this.vke.setVisibility(8);
    }
    label225:
    this.lDu.setText(null);
    AppMethodBeat.o(64926);
  }
  
  public final void a(cgf paramcgf)
  {
    AppMethodBeat.i(64923);
    if (paramcgf == null)
    {
      locali = null;
      a(locali);
      er(paramcgf.GZl);
      AppMethodBeat.o(64923);
      return;
    }
    i locali = new i();
    locali.username = paramcgf.GZm;
    locali.vjo = paramcgf.GZo;
    locali.nickname = paramcgf.GZn;
    locali.dOa = paramcgf.dOa;
    locali.vjs = paramcgf.vjs;
    locali.vjt = paramcgf.vjt;
    if (paramcgf.GZq == 0) {}
    for (boolean bool = false;; bool = true)
    {
      locali.vju = bool;
      locali.vjq = paramcgf.vjq;
      locali.vjp = paramcgf.vjp;
      locali.vjr = paramcgf.vjr;
      break;
    }
  }
  
  public final void a(cpu paramcpu)
  {
    AppMethodBeat.i(64924);
    if (paramcpu == null)
    {
      locali = null;
      a(locali);
      er(paramcpu.GZl);
      AppMethodBeat.o(64924);
      return;
    }
    i locali = new i();
    locali.username = paramcpu.GZm;
    locali.vjo = paramcpu.GZo;
    locali.nickname = paramcpu.GZn;
    locali.dOa = paramcpu.dOa;
    locali.vjs = paramcpu.vjs;
    locali.vjt = paramcpu.vjt;
    if (paramcpu.GZq == 0) {}
    for (boolean bool = false;; bool = true)
    {
      locali.vju = bool;
      locali.vjq = paramcpu.vjq;
      locali.vjp = paramcpu.vjp;
      locali.vjr = paramcpu.vjr;
      break;
    }
  }
  
  public final void ax(Intent paramIntent)
  {
    this.vjY = paramIntent;
  }
  
  public final MMActivity dhO()
  {
    return this;
  }
  
  public final void dhP()
  {
    AppMethodBeat.i(64918);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    AppMethodBeat.o(64918);
  }
  
  public final void er(List<bmz> paramList)
  {
    AppMethodBeat.i(64925);
    this.vkf.es(paramList);
    AppMethodBeat.o(64925);
  }
  
  public final void error(String paramString)
  {
    AppMethodBeat.i(64917);
    h.cl(this, paramString);
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
    this.vjZ = ((ListView)findViewById(2131301770));
    this.vkf = new c(getContext());
    this.agn = LayoutInflater.from(this).inflate(2131494634, null);
    this.vjZ.addHeaderView(this.agn);
    this.vjZ.setAdapter(this.vkf);
    this.vkf.vjN = false;
    this.vjZ.setOnScrollListener(this.vkg);
    this.vka = ((ImageView)this.agn.findViewById(2131301774));
    this.vkb = ((TextView)this.agn.findViewById(2131301789));
    this.vkc = ((ImageView)this.agn.findViewById(2131301757));
    this.uGZ = ((TextView)this.agn.findViewById(2131301792));
    this.vkd = this.agn.findViewById(2131301742);
    this.vjR = ((TextView)this.agn.findViewById(2131301741));
    this.vke = this.agn.findViewById(2131301759);
    this.mkS = ((TextView)this.agn.findViewById(2131301785));
    this.lDu = ((TextView)this.agn.findViewById(2131301748));
    this.tipDialog = h.b(getContext(), getString(2131760709), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(64915);
        WxaLuckyMoneyDetailUI.this.dhP();
        if ((WxaLuckyMoneyDetailUI.d(WxaLuckyMoneyDetailUI.this).getVisibility() == 8) || (WxaLuckyMoneyDetailUI.e(WxaLuckyMoneyDetailUI.this).getVisibility() == 4))
        {
          ad.i("MicroMsg.WxaLuckyMoneyDetailUI", "user cancel & finish");
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
    if (this.vjY != null) {
      setResult(0, this.vjY);
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
    this.vjX.d(this, getIntent());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.WxaLuckyMoneyDetailUI
 * JD-Core Version:    0.7.0.1
 */