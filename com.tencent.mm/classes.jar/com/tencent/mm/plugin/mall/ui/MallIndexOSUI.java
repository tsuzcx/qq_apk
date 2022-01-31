package com.tencent.mm.plugin.mall.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.br.d;
import com.tencent.mm.m.g;
import com.tencent.mm.model.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.d.i;
import com.tencent.mm.plugin.wallet_core.model.ac;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.c.chx;
import com.tencent.mm.protocal.c.chy;
import com.tencent.mm.protocal.c.chz;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.LinkedList;

public class MallIndexOSUI
  extends MallIndexBaseUI
{
  private boolean gxZ = false;
  private View igy = null;
  private MallIndexOSUI.a[] lZN = new MallIndexOSUI.a[4];
  private ac lZO = new ac();
  private TextView lZP = null;
  private boolean lZQ = false;
  private long lZR = 0L;
  private boolean lZS = false;
  private boolean lZT = false;
  private String lZU = "";
  private c lZV = new MallIndexOSUI.1(this);
  private c lZW = new MallIndexOSUI.2(this);
  private long lastUpdateTime = 0L;
  
  public final void a(MallFunction paramMallFunction, int paramInt)
  {
    super.a(paramMallFunction, paramInt);
    h.nFQ.f(13720, new Object[] { paramMallFunction.lfj, Long.valueOf(bk.ZS(paramMallFunction.npy)) });
  }
  
  protected final void bgE()
  {
    String str1 = this.lZO.qyU;
    String str2 = this.lZO.qyV;
    setMMTitle(str1);
    setMMSubTitle(str2);
  }
  
  protected final void bgF() {}
  
  protected final void bgG() {}
  
  protected final boolean bgI()
  {
    chx localchx = this.lZO.qyR;
    int i = 0;
    while (i < this.lZN.length)
    {
      this.lZN[i].view.setVisibility(8);
      this.lZN[i].lYC.setImageBitmap(null);
      i += 1;
    }
    i = 0;
    while ((i < localchx.taW.size()) && (i < this.lZN.length))
    {
      chy localchy = (chy)localchx.taW.get(i);
      this.lZN[i].view.setVisibility(0);
      this.lZN[i].lYC.setUrl(aa.a(localchy.tWx));
      this.lZN[i].lYC.setVisibility(0);
      this.lZN[i].dqa.setText(aa.a(localchy.tWw));
      y.i("MicroMsg.MallIndexOSUI", "item %d url %s", new Object[] { Integer.valueOf(i), aa.a(localchy.tWx) });
      this.lZN[i].mae.setVisibility(8);
      String str = aa.a(localchy.tWz);
      if (!bk.bl(str))
      {
        this.lZN[i].mae.setText(str);
        this.lZN[i].mae.setVisibility(0);
      }
      this.lZN[i].view.setOnClickListener(new MallIndexOSUI.3(this, localchy));
      i += 1;
    }
    if ((this.lZt != null) && (this.igy != null) && (!this.lZQ))
    {
      this.lZt.addFooterView(this.igy);
      this.lZQ = true;
    }
    if (!bk.bl(this.lZO.qyX))
    {
      this.lZP.setText(this.lZO.qyX);
      this.lZP.setVisibility(0);
    }
    return true;
  }
  
  protected final void bgM()
  {
    com.tencent.mm.wallet_core.ui.e.a(this.lZy, "1", this.lZO.qyW, this.lZO.lRp);
    bgH();
  }
  
  protected final void bgN() {}
  
  protected final void bgP()
  {
    this.mController.removeAllOptionMenu();
    addIconOptionMenu(0, a.e.mm_title_btn_menu, new MallIndexOSUI.4(this));
  }
  
  protected final void bgQ() {}
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    super.c(paramInt1, paramInt2, paramString, paramm);
    if (paramm.getType() == 1577)
    {
      paramm = (com.tencent.mm.plugin.mall.a.e)paramm;
      if (paramm.lYq != null) {
        break label63;
      }
      paramInt1 = 0;
    }
    while ((paramInt1 == 1) && (!bk.bl(paramm.bgy()))) {
      if (this.gxZ)
      {
        return true;
        label63:
        paramInt1 = paramm.lYq.tWA;
      }
      else if (System.currentTimeMillis() - this.lZR > 500L)
      {
        this.lZR = System.currentTimeMillis();
        this.lZV.cqo();
        this.lZW.cqo();
        paramString = new Bundle();
        this.lZU = paramm.bgy();
        paramm = new Intent();
        y.i("MicroMsg.MallIndexOSUI", "startWebViewUI %s", new Object[] { this.lZU });
        paramString.putString("KoriginUrl", this.lZU);
        paramString.putBoolean("KIsHKAgreeUrl", true);
        paramm.putExtra("rawUrl", this.lZU);
        paramm.putExtra("jsapiargs", paramString);
        paramm.putExtra("geta8key_username", q.Gj());
        paramm.putExtra("pay_channel", 1);
        d.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramm, 4);
      }
    }
    this.lZO = o.bVy().AR(this.lYn);
    bgM();
    bgI();
    bgE();
    return true;
  }
  
  protected final void cG(View paramView)
  {
    this.lZN[0] = new MallIndexOSUI.a(this);
    this.lZN[0].view = paramView.findViewById(a.f.offline_area);
    this.lZN[0].lYC = ((CdnImageView)paramView.findViewById(a.f.offline_pic));
    this.lZN[0].dqa = ((TextView)paramView.findViewById(a.f.offline_wording));
    this.lZN[0].mae = ((TextView)paramView.findViewById(a.f.extra_wording_first));
    this.lZN[0].lYC.setVisibility(4);
    this.lZN[1] = new MallIndexOSUI.a(this);
    this.lZN[1].view = paramView.findViewById(a.f.balance_area);
    this.lZN[1].lYC = ((CdnImageView)paramView.findViewById(a.f.balance_pic));
    this.lZN[1].dqa = ((TextView)paramView.findViewById(a.f.balance_wording));
    this.lZN[1].mae = ((TextView)paramView.findViewById(a.f.balance_num));
    this.lZN[1].lYC.setVisibility(4);
    this.lZN[2] = new MallIndexOSUI.a(this);
    this.lZN[2].view = paramView.findViewById(a.f.bankcard_area);
    this.lZN[2].lYC = ((CdnImageView)paramView.findViewById(a.f.bankcard_pic));
    this.lZN[2].dqa = ((TextView)paramView.findViewById(a.f.bankcard_tv));
    this.lZN[2].mae = ((TextView)paramView.findViewById(a.f.extra_wording_three));
    this.lZN[2].lYC.setVisibility(4);
    this.lZN[3] = new MallIndexOSUI.a(this);
    this.lZN[3].view = paramView.findViewById(a.f.lqt_area);
    this.lZN[3].lYC = ((CdnImageView)paramView.findViewById(a.f.lqt_pic));
    this.lZN[3].dqa = ((TextView)paramView.findViewById(a.f.lqt_wording));
    this.lZN[3].lYC.setVisibility(4);
    this.lZN[3].view.setVisibility(8);
  }
  
  public void finish()
  {
    this.gxZ = true;
    super.finish();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    y.i("MicroMsg.MallIndexOSUI", "onActivityResult requestCode %s resultCode %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.igy = View.inflate(this, a.g.mall_index_foot, null);
    this.igy.setClickable(false);
    this.igy.setEnabled(false);
    this.lZP = ((TextView)this.igy.findViewById(a.f.wallet_region_desc));
    this.lZO = o.bVy().AR(this.lYn);
    kh(1577);
    y.i("MicroMsg.MallIndexOSUI", "walletMallIndexOsUI ");
    paramBundle = new com.tencent.mm.plugin.mall.a.e();
    if (this.lZO != null)
    {
      ac localac = this.lZO;
      if ((localac.qyR != null) && (localac.qyR.taW != null) && (localac.qyR.taW.size() != 0)) {
        break label143;
      }
    }
    label143:
    for (int i = 1; i != 0; i = 0)
    {
      a(paramBundle, true, false);
      return;
    }
    a(paramBundle, false, false);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ki(1577);
    this.lZV.dead();
    this.lZW.dead();
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    int i = g.AA().getInt("OverseaPayWalletInfoRefreshInternal", 15) * 1000;
    long l = System.currentTimeMillis();
    y.d("MicroMsg.MallIndexOSUI", "checkUpdate svrTime: %d lastUpdateTime : %d  curTime %d", new Object[] { Integer.valueOf(i), Long.valueOf(this.lastUpdateTime), Long.valueOf(l) });
    if (l - this.lastUpdateTime >= i)
    {
      this.lastUpdateTime = System.currentTimeMillis();
      a(new com.tencent.mm.plugin.mall.a.e(), false, false);
    }
    bgE();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexOSUI
 * JD-Core Version:    0.7.0.1
 */