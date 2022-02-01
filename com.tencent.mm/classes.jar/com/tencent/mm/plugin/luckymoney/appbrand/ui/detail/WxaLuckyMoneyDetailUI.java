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
import com.tencent.mm.protocal.protobuf.bir;
import com.tencent.mm.protocal.protobuf.cbo;
import com.tencent.mm.protocal.protobuf.cku;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.wallet_core.ui.e;
import java.util.List;

public class WxaLuckyMoneyDetailUI
  extends WxaLuckyMoneyBaseUI
  implements b
{
  private View aew;
  private TextView lLe;
  private TextView lgw;
  private TextView tEq;
  private p tipDialog;
  private TextView uhh;
  private final a uhn;
  private Intent uho;
  private ListView uhp;
  private ImageView uhq;
  private TextView uhr;
  private ImageView uhs;
  private View uht;
  private View uhu;
  private c uhv;
  private AbsListView.OnScrollListener uhw;
  
  public WxaLuckyMoneyDetailUI()
  {
    AppMethodBeat.i(64916);
    this.uhn = new d();
    this.tipDialog = null;
    this.uho = null;
    this.uhw = new AbsListView.OnScrollListener()
    {
      private boolean uhx = false;
      private boolean uhy;
      
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        boolean bool = true;
        AppMethodBeat.i(64913);
        if ((paramAnonymousInt3 == 0) || (!this.uhx))
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
          if (this.uhy != bool)
          {
            if (bool)
            {
              WxaLuckyMoneyDetailUI.a(WxaLuckyMoneyDetailUI.this, WxaLuckyMoneyDetailUI.this.getResources().getDrawable(2131232950));
              this.uhy = bool;
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
            WxaLuckyMoneyDetailUI.a(WxaLuckyMoneyDetailUI.this).HE(paramAnonymousAbsListView.getCount());
          }
          this.uhx = false;
          AppMethodBeat.o(64912);
          return;
          this.uhx = true;
        }
      }
    };
    AppMethodBeat.o(64916);
  }
  
  private void a(i parami)
  {
    AppMethodBeat.i(64926);
    AppCompatActivity localAppCompatActivity = getContext();
    z.b(this.uhq, parami.ugE, parami.username);
    z.a(localAppCompatActivity, this.uhr, parami.nickname);
    z.a(localAppCompatActivity, this.tEq, parami.ugH);
    if (parami.ugG == 1)
    {
      this.uhs.setVisibility(0);
      this.uhs.setImageResource(2131233028);
      if (parami.ugF != 2) {
        break label201;
      }
      this.uhh.setText(e.C(parami.dBN / 100.0D));
      this.uhv.uhd = false;
      this.uht.setVisibility(0);
      label117:
      if (bs.isNullOrNil(parami.ugI)) {
        break label213;
      }
      this.uhu.setVisibility(0);
      this.lLe.setText(parami.ugI);
      this.lLe.setTextColor(getResources().getColor(2131100598));
    }
    for (;;)
    {
      if (bs.isNullOrNil(parami.ugJ)) {
        break label225;
      }
      this.lgw.setText(parami.ugJ);
      AppMethodBeat.o(64926);
      return;
      this.uhs.setVisibility(8);
      break;
      label201:
      this.uht.setVisibility(8);
      break label117;
      label213:
      this.uhu.setVisibility(8);
    }
    label225:
    this.lgw.setText(null);
    AppMethodBeat.o(64926);
  }
  
  public final void a(cbo paramcbo)
  {
    AppMethodBeat.i(64923);
    if (paramcbo == null)
    {
      locali = null;
      a(locali);
      ee(paramcbo.FpB);
      AppMethodBeat.o(64923);
      return;
    }
    i locali = new i();
    locali.username = paramcbo.FpC;
    locali.ugE = paramcbo.FpE;
    locali.nickname = paramcbo.FpD;
    locali.dBN = paramcbo.dBN;
    locali.ugI = paramcbo.ugI;
    locali.ugJ = paramcbo.ugJ;
    if (paramcbo.FpG == 0) {}
    for (boolean bool = false;; bool = true)
    {
      locali.ugK = bool;
      locali.ugG = paramcbo.ugG;
      locali.ugF = paramcbo.ugF;
      locali.ugH = paramcbo.ugH;
      break;
    }
  }
  
  public final void a(cku paramcku)
  {
    AppMethodBeat.i(64924);
    if (paramcku == null)
    {
      locali = null;
      a(locali);
      ee(paramcku.FpB);
      AppMethodBeat.o(64924);
      return;
    }
    i locali = new i();
    locali.username = paramcku.FpC;
    locali.ugE = paramcku.FpE;
    locali.nickname = paramcku.FpD;
    locali.dBN = paramcku.dBN;
    locali.ugI = paramcku.ugI;
    locali.ugJ = paramcku.ugJ;
    if (paramcku.FpG == 0) {}
    for (boolean bool = false;; bool = true)
    {
      locali.ugK = bool;
      locali.ugG = paramcku.ugG;
      locali.ugF = paramcku.ugF;
      locali.ugH = paramcku.ugH;
      break;
    }
  }
  
  public final void as(Intent paramIntent)
  {
    this.uho = paramIntent;
  }
  
  public final MMActivity cYC()
  {
    return this;
  }
  
  public final void cYD()
  {
    AppMethodBeat.i(64918);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    AppMethodBeat.o(64918);
  }
  
  public final void ee(List<bir> paramList)
  {
    AppMethodBeat.i(64925);
    this.uhv.ef(paramList);
    AppMethodBeat.o(64925);
  }
  
  public final void error(String paramString)
  {
    AppMethodBeat.i(64917);
    h.cg(this, paramString);
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
    this.uhp = ((ListView)findViewById(2131301770));
    this.uhv = new c(getContext());
    this.aew = LayoutInflater.from(this).inflate(2131494634, null);
    this.uhp.addHeaderView(this.aew);
    this.uhp.setAdapter(this.uhv);
    this.uhv.uhd = false;
    this.uhp.setOnScrollListener(this.uhw);
    this.uhq = ((ImageView)this.aew.findViewById(2131301774));
    this.uhr = ((TextView)this.aew.findViewById(2131301789));
    this.uhs = ((ImageView)this.aew.findViewById(2131301757));
    this.tEq = ((TextView)this.aew.findViewById(2131301792));
    this.uht = this.aew.findViewById(2131301742);
    this.uhh = ((TextView)this.aew.findViewById(2131301741));
    this.uhu = this.aew.findViewById(2131301759);
    this.lLe = ((TextView)this.aew.findViewById(2131301785));
    this.lgw = ((TextView)this.aew.findViewById(2131301748));
    this.tipDialog = h.b(getContext(), getString(2131760709), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(64915);
        WxaLuckyMoneyDetailUI.this.cYD();
        if ((WxaLuckyMoneyDetailUI.d(WxaLuckyMoneyDetailUI.this).getVisibility() == 8) || (WxaLuckyMoneyDetailUI.e(WxaLuckyMoneyDetailUI.this).getVisibility() == 4))
        {
          ac.i("MicroMsg.WxaLuckyMoneyDetailUI", "user cancel & finish");
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
    if (this.uho != null) {
      setResult(0, this.uho);
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
    this.uhn.d(this, getIntent());
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