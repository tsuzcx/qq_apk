package com.tencent.mm.plugin.mall.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ah.m;
import com.tencent.mm.h.a.nu;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.plugin.mall.a.f;
import com.tencent.mm.plugin.wallet_core.model.aa;
import com.tencent.mm.plugin.wallet_core.model.af;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.pluginsdk.wallet.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ak;
import com.tencent.mm.wallet_core.c.w;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public abstract class MallIndexBaseUI
  extends WalletBaseUI
  implements x.a, com.tencent.mm.plugin.wallet_core.model.j
{
  protected String dCX;
  private String lUA = null;
  private String lYi = null;
  private ArrayList<MallFunction> lYj = null;
  protected int lYn;
  private boolean lZA = true;
  private int lZB = 0;
  protected View lZC;
  private boolean lZD = false;
  private TextView lZs = null;
  protected ListView lZt = null;
  private b lZu = null;
  protected ImageView lZv = null;
  protected ImageView lZw;
  protected TextView lZx = null;
  protected TextView lZy;
  private int lZz = 0;
  
  private MallFunction bN(List<MallFunction> paramList)
  {
    Object localObject;
    if ((paramList == null) || (paramList.size() == 0) || (TextUtils.isEmpty(this.lYi)))
    {
      localObject = null;
      return localObject;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramList.size()) {
        break label81;
      }
      MallFunction localMallFunction = (MallFunction)paramList.get(i);
      if (localMallFunction != null)
      {
        localObject = localMallFunction;
        if (this.lYi.equals(localMallFunction.npy)) {
          break;
        }
      }
      i += 1;
    }
    label81:
    return null;
  }
  
  private MallFunction bO(List<MallFunction> paramList)
  {
    Object localObject;
    if ((paramList == null) || (paramList.size() == 0) || (TextUtils.isEmpty(this.lUA)))
    {
      localObject = null;
      return localObject;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramList.size()) {
        break label81;
      }
      MallFunction localMallFunction = (MallFunction)paramList.get(i);
      if (localMallFunction != null)
      {
        localObject = localMallFunction;
        if (this.lUA.equals(localMallFunction.ceb)) {
          break;
        }
      }
      i += 1;
    }
    label81:
    return null;
  }
  
  private void bgJ()
  {
    boolean bool = getIntent().getBooleanExtra("key_wallet_has_red", false);
    if (this.lZt.getChildCount() == 0) {}
    label404:
    for (;;)
    {
      return;
      int i = this.lZt.getFirstVisiblePosition();
      int j = this.lZt.getChildAt(0).getTop();
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MallIndexBaseUI", "initCheckNew %s fpos %s top %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j) });
      if ((i == 0) && (j == 0) && (bool) && (!this.lZD) && (this.lYj != null))
      {
        this.lZD = true;
        int k = this.lZt.getHeaderViewsCount() + this.lZu.getCount();
        List localList = this.lZu.lYN;
        if (localList != null)
        {
          i = localList.size() - 1;
          for (;;)
          {
            if (i <= 0) {
              break label404;
            }
            Iterator localIterator = ((ArrayList)localList.get(i)).iterator();
            for (;;)
            {
              if (localIterator.hasNext())
              {
                b.c localc = (b.c)localIterator.next();
                if ((localc != null) && (localc.lZq != null) && (b.a(localc.lZq)))
                {
                  i = this.lZt.getFirstVisiblePosition();
                  j = this.lZt.getLastVisiblePosition();
                  com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MallIndexBaseUI", "get listview show top %s bottom %s redPos: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
                  if ((k >= i) && (k <= j)) {
                    break;
                  }
                  int m = a.bgC();
                  j = a.bgB() + a.bgA() * (k + 1) + m;
                  i = j;
                  if (k > 2) {
                    i = j + m;
                  }
                  j = i;
                  if (k > 3) {
                    j = i + m;
                  }
                  m = a.bgA() / 3;
                  int n = this.lZt.getScrollY();
                  k = ak.gx(this).y;
                  i = k;
                  if (ak.gw(this)) {
                    i = k - ak.gv(this);
                  }
                  k = i;
                  if (getSupportActionBar() != null) {
                    k = i - getSupportActionBar().getHeight();
                  }
                  this.lZt.smoothScrollBy(j + m - n - k, 1000);
                  return;
                }
              }
            }
            k -= 1;
            i -= 1;
          }
        }
      }
    }
  }
  
  private void bgL()
  {
    setResult(0);
    finish();
  }
  
  private void bgO()
  {
    if (q.Gw())
    {
      com.tencent.mm.wallet_core.a.b(this.mController.uMN, "PayURemittanceProcess", null);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("pay_channel", 1);
    com.tencent.mm.wallet_core.a.b(this.mController.uMN, "RemittanceProcess", localBundle);
  }
  
  public void a(MallFunction paramMallFunction, int paramInt)
  {
    Object localObject2;
    int i;
    String str;
    if ((paramMallFunction != null) && (paramInt >= 0))
    {
      localObject2 = "";
      localObject1 = localObject2;
      if (paramMallFunction.qzx != null)
      {
        localObject1 = localObject2;
        if (!bk.bl(paramMallFunction.qzx.pva)) {
          localObject1 = paramMallFunction.qzx.pva;
        }
      }
      if (this.lYj != null) {
        break label228;
      }
      i = 0;
      boolean bool = b.a(paramMallFunction);
      localObject2 = com.tencent.mm.plugin.report.service.h.nFQ;
      str = paramMallFunction.npy;
      if (!bool) {
        break label239;
      }
    }
    label228:
    label239:
    for (int j = 2;; j = 1)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject2).f(10881, new Object[] { str, Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(paramInt), localObject1, Integer.valueOf(j) });
      if ((paramMallFunction == null) || (bk.bl(paramMallFunction.ceb)) || (!((com.tencent.mm.plugin.appbrand.r.e)g.r(com.tencent.mm.plugin.appbrand.r.e.class)).uW(paramMallFunction.ceb))) {
        break label245;
      }
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MallIndexBaseUI", "handleFunction, intercept by AppBrandNativeLink, nativeUrl = %s", new Object[] { paramMallFunction.ceb });
      com.tencent.mm.plugin.wallet_core.model.mall.c.bWg().Qx(paramMallFunction.npy);
      com.tencent.mm.plugin.wallet_core.model.mall.d.bWk().Qx(paramMallFunction.npy);
      if (paramMallFunction.qzx != null)
      {
        com.tencent.mm.plugin.wallet_core.model.mall.c.bWg();
        com.tencent.mm.plugin.wallet_core.model.mall.c.c(paramMallFunction);
      }
      return;
      i = this.lYj.size();
      break;
    }
    label245:
    if (paramMallFunction != null)
    {
      com.tencent.mm.plugin.wallet_core.model.mall.c.bWg().Qx(paramMallFunction.npy);
      com.tencent.mm.plugin.wallet_core.model.mall.d.bWk().Qx(paramMallFunction.npy);
      if (paramMallFunction.qzx != null)
      {
        com.tencent.mm.plugin.wallet_core.model.mall.c.bWg();
        com.tencent.mm.plugin.wallet_core.model.mall.c.c(paramMallFunction);
      }
      if ("wxpay://bizmall/mobile_recharge".equals(paramMallFunction.ceb)) {
        paramInt = 0;
      }
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MallIndexBaseUI", "functionType : " + paramInt);
      switch (paramInt)
      {
      default: 
        return;
      case 0: 
        localObject1 = new Intent();
        if (aSk()) {
          ((Intent)localObject1).putExtra("key_is_hide_progress", true);
        }
        ((Intent)localObject1).putExtra("key_func_info", paramMallFunction);
        com.tencent.mm.br.d.b(this, "recharge", ".ui.PhoneRechargeUI", (Intent)localObject1);
        w.fT(15, 0);
        return;
        if ("wxpay://bizmall/weixin_hongbao".equals(paramMallFunction.ceb))
        {
          paramInt = 4;
        }
        else if ("wxpay://bizmall/weixin_scan_qrcode".equals(paramMallFunction.ceb))
        {
          paramInt = 8;
        }
        else if ("wxpay://bizmall/weixin_transfer".equals(paramMallFunction.ceb))
        {
          paramInt = 5;
        }
        else if ("wxpay://bizmall/weixin_offline_pay".equals(paramMallFunction.ceb))
        {
          paramInt = 6;
        }
        else if ("wxpay://bizmall/old_mobile_recharge".equals(paramMallFunction.ceb))
        {
          paramInt = 7;
        }
        else if (!bk.bl(paramMallFunction.lfj))
        {
          paramInt = 1;
        }
        else if ("wxpay://bizmall/f2f_hongbao".equals(paramMallFunction.ceb))
        {
          paramInt = 9;
        }
        else
        {
          com.tencent.mm.sdk.platformtools.y.w("MicroMsg.MallIndexUIHelper", "doSelectFunction no jump");
          paramInt = 2;
          continue;
          paramInt = 3;
        }
        break;
      }
    }
    com.tencent.mm.plugin.report.service.h.nFQ.f(11701, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
    paramMallFunction = new Intent();
    paramMallFunction.putExtra("pay_channel", 1);
    com.tencent.mm.br.d.b(this, "luckymoney", ".ui.LuckyMoneyIndexUI", paramMallFunction);
    w.fT(13, 0);
    com.tencent.mm.plugin.report.service.h.nFQ.f(11850, new Object[] { Integer.valueOf(4), Integer.valueOf(0) });
    return;
    Object localObject1 = new Intent();
    if (aSk()) {
      ((Intent)localObject1).putExtra("key_is_hide_progress", true);
    }
    ((Intent)localObject1).putExtra("key_func_info", paramMallFunction);
    com.tencent.mm.br.d.b(this, "recharge", ".ui.RechargeUI", (Intent)localObject1);
    return;
    g.DQ();
    this.lYn = ((Integer)g.DP().Dz().get(ac.a.usE, Integer.valueOf(0))).intValue();
    localObject1 = new Intent();
    ((Intent)localObject1).putExtra("rawUrl", paramMallFunction.lfj);
    ((Intent)localObject1).putExtra("geta8key_username", q.Gj());
    ((Intent)localObject1).putExtra("pay_channel", 1);
    ((Intent)localObject1).putExtra("KPublisherId", "pay_wallet");
    ((Intent)localObject1).putExtra("key_download_restrict", paramMallFunction.qzz);
    ((Intent)localObject1).putExtra("key_wallet_region", this.lYn);
    ((Intent)localObject1).putExtra("key_function_id", paramMallFunction.npy);
    ((Intent)localObject1).putExtra("geta8key_scene", 46);
    com.tencent.mm.br.d.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", (Intent)localObject1);
    return;
    com.tencent.mm.sdk.platformtools.y.w("MicroMsg.MallIndexBaseUI", "doSelectFunction no jump");
    return;
    com.tencent.mm.sdk.platformtools.y.w("MicroMsg.MallIndexBaseUI", "doSelectFunction do nothing");
    com.tencent.mm.ui.base.s.makeText(this, "fuction list error", 1).show();
    return;
    com.tencent.mm.plugin.report.service.h.nFQ.f(11458, new Object[] { Integer.valueOf(1) });
    if (q.Gw())
    {
      paramMallFunction = new LinkedList();
      localObject1 = new LinkedList();
      paramMallFunction.add(getString(a.i.remittance_title));
      ((List)localObject1).add(Integer.valueOf(0));
      paramMallFunction.add(getString(a.i.collect_title));
      ((List)localObject1).add(Integer.valueOf(1));
      com.tencent.mm.ui.base.h.a(this, getString(a.i.remittance_collect_title), paramMallFunction, (List)localObject1, null, true, new MallIndexBaseUI.4(this));
    }
    for (;;)
    {
      w.fT(14, 0);
      com.tencent.mm.plugin.report.service.h.nFQ.f(11850, new Object[] { Integer.valueOf(3), Integer.valueOf(0) });
      return;
      g.DQ();
      if (!((Boolean)g.DP().Dz().get(ac.a.uoI, Boolean.valueOf(false))).booleanValue())
      {
        g.DQ();
        g.DP().Dz().c(ac.a.uoI, Boolean.valueOf(true));
        com.tencent.mm.ui.base.h.a(this, getString(a.i.wallet_index_ui_ftf_notice), "", new MallIndexBaseUI.5(this));
      }
      else
      {
        bgO();
      }
    }
    paramMallFunction = new Intent();
    paramMallFunction.putExtra("key_from_scene", 1);
    com.tencent.mm.br.d.b(this.mController.uMN, "offline", ".ui.WalletOfflineEntranceUI", paramMallFunction);
    w.fT(9, 0);
    com.tencent.mm.plugin.report.service.h.nFQ.f(11850, new Object[] { Integer.valueOf(5), Integer.valueOf(0) });
    return;
    paramMallFunction = new Intent();
    paramMallFunction.putExtra("BaseScanUI_select_scan_mode", 1);
    com.tencent.mm.br.d.b(this.mController.uMN, "scanner", ".ui.BaseScanUI", paramMallFunction);
    return;
    com.tencent.mm.br.d.x(this.mController.uMN, "luckymoney", ".f2f.ui.LuckyMoneyF2FQRCodeUI");
  }
  
  protected final void aFd() {}
  
  public final boolean aSk()
  {
    return (!bk.bl(this.lYi)) || (!bk.bl(this.lUA));
  }
  
  protected final boolean aSl()
  {
    if (!aSk()) {
      aZ();
    }
    return true;
  }
  
  public final void aZ()
  {
    showOptionMenu(true);
    b localb = this.lZu;
    Object localObject = this.lYj;
    localb.lYN.clear();
    if (localObject != null)
    {
      int i = 0;
      ArrayList localArrayList;
      while (i < ((ArrayList)localObject).size())
      {
        localArrayList = new ArrayList();
        int j = 0;
        while ((j < 3) && (i + j < ((ArrayList)localObject).size()))
        {
          if (j > 0)
          {
            int k = i + j - 1;
            if ((k >= 0) && (((MallFunction)((ArrayList)localObject).get(k)).type != ((MallFunction)((ArrayList)localObject).get(i + j)).type)) {
              break;
            }
          }
          b.c localc = new b.c(localb);
          localc.lZr = (i + j);
          localc.lZq = ((MallFunction)((ArrayList)localObject).get(i + j));
          localArrayList.add(localc);
          j += 1;
        }
        if (localArrayList.size() > 0) {
          localb.lYN.add(localArrayList);
        }
        i += j;
      }
      localb.lYQ = 0;
      localb.lYR = 0;
      localObject = localb.lYN.iterator();
      i = -1;
      if (((Iterator)localObject).hasNext())
      {
        localArrayList = (ArrayList)((Iterator)localObject).next();
        if (localArrayList.size() <= 0) {
          break label417;
        }
        if ((i == -1) || (i == ((b.c)localArrayList.get(0)).lZq.type))
        {
          localb.lYQ += localArrayList.size();
          localb.lYR += 1;
          i = ((b.c)localArrayList.get(0)).lZq.type;
        }
      }
    }
    label417:
    for (;;)
    {
      break;
      localb.lYR -= 1;
      localb.lYm = f.bgz().tx(localb.lYn).lYm;
      localb.lYS = localb.bgD();
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.FunctionListAdapter", "hasMoreNewAtFirstSectionBottom: %s", new Object[] { Boolean.valueOf(localb.lYS) });
      localb.notifyDataSetChanged();
      bgN();
      bgP();
      if (this.lZs != null) {
        this.lZs.setVisibility(8);
      }
      bgQ();
      return;
    }
  }
  
  protected abstract void bgE();
  
  protected abstract void bgF();
  
  protected abstract void bgG();
  
  protected final void bgH()
  {
    if (this.lZy.getVisibility() == 0)
    {
      a.b(this, true);
      AbsListView.LayoutParams localLayoutParams2 = (AbsListView.LayoutParams)this.lZC.getLayoutParams();
      AbsListView.LayoutParams localLayoutParams1 = localLayoutParams2;
      if (localLayoutParams2 == null) {
        localLayoutParams1 = new AbsListView.LayoutParams(-1, -2);
      }
      localLayoutParams1.height = a.bgB();
      this.lZC.setLayoutParams(localLayoutParams1);
    }
  }
  
  protected abstract boolean bgI();
  
  public final boolean bgK()
  {
    return false;
  }
  
  protected abstract void bgM();
  
  protected abstract void bgN();
  
  protected abstract void bgP();
  
  protected abstract void bgQ();
  
  public boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.MallIndexBaseUI", "onOtherSceneEnd");
    if ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.b.a))
    {
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.MallIndexBaseUI", "hy: query bound scene end");
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (this.lZA)
        {
          this.lZA = false;
          if (o.bVo().bWq().bVK())
          {
            com.tencent.mm.wallet_core.a.b(this, "PayUOpenProcess", null);
            return true;
          }
        }
      }
      else
      {
        finish();
        return true;
      }
    }
    switch (paramm.getType())
    {
    default: 
      return false;
    }
    paramString = (com.tencent.mm.plugin.mall.a.c)paramm;
    if (paramString.lYn != this.lYn) {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MallIndexBaseUI", "pass wallet local: %d cgi: %d", new Object[] { Integer.valueOf(this.lYn), Integer.valueOf(paramString.lYn) });
    }
    if (aSk())
    {
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.MallIndexBaseUI", "errorType:%d | errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if ((paramInt1 == 0) && (paramInt2 == 0) && (paramString.lYj != null) && (paramString.lYj.size() > 0))
      {
        if (getIntent().getIntExtra("key_scene", 0) == 1)
        {
          paramString = bN(paramString.lYj);
          if (paramString != null) {
            a(paramString, -1);
          }
        }
        for (;;)
        {
          setResult(-1);
          finish();
          return true;
          if (!bk.bl(this.lUA))
          {
            com.tencent.mm.sdk.platformtools.y.d("MicroMsg.MallIndexBaseUI", "NativeUrl: %s", new Object[] { this.lUA });
            paramString = bO(paramString.lYj);
            if (paramString != null)
            {
              a(paramString, -1);
            }
            else
            {
              bgL();
              return true;
            }
          }
          else if ((paramString.lYj != null) && (paramString.lYj.size() > 0))
          {
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MallIndexBaseUI", "functionScene.mFunctionList != null");
            a(bN(paramString.lYj), -1);
          }
          else if ((f.bgz().ty(this.lYn) != null) && (f.bgz().ty(this.lYn).size() > 0))
          {
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MallIndexBaseUI", "SubCoreMall.getCore().getFunctionList() != null");
            a(bN(f.bgz().ty(this.lYn)), -1);
          }
          else
          {
            com.tencent.mm.sdk.platformtools.y.e("MicroMsg.MallIndexBaseUI", "SubCoreMall.getCore().getFunctionList() == null");
          }
        }
      }
      bgL();
      return true;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0) && (f.bgz().ty(this.lYn) != null) && (paramString.lYj != null) && (paramString.lYj.size() > 0))
    {
      this.lYj = f.bgz().ty(this.lYn);
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MallIndexBaseUI", "get from server now! " + this.lYn + " " + this.lYj.size());
      com.tencent.mm.plugin.wallet_core.model.mall.c.bWg().S(this.lYj);
    }
    aZ();
    bgJ();
    return true;
  }
  
  protected abstract void cG(View paramView);
  
  public void finish()
  {
    super.finish();
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return a.g.mall_index_ui;
  }
  
  public final void initView()
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.MallIndexBaseUI", "index initView");
    setBackBtn(new MallIndexBaseUI.1(this));
    a.b(this, false);
    this.lZt = ((ListView)findViewById(a.f.mall_index_function_list));
    this.lZC = com.tencent.mm.ui.y.gt(this).inflate(a.g.mall_index_stub_with_bankcard, null);
    this.lZt.addHeaderView(this.lZC);
    AbsListView.LayoutParams localLayoutParams2 = (AbsListView.LayoutParams)this.lZC.getLayoutParams();
    AbsListView.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = new AbsListView.LayoutParams(-1, -2);
    }
    localLayoutParams1.height = a.bgB();
    this.lZC.setLayoutParams(localLayoutParams1);
    this.lZu = new b(this, this.lYn);
    this.lZt.setAdapter(this.lZu);
    this.lZu.lYO = new MallIndexBaseUI.2(this);
    cG(this.lZC);
    this.lZy = ((TextView)findViewById(a.f.banner_tips));
    bgM();
    this.lZt.setOnScrollListener(new MallIndexBaseUI.3(this));
  }
  
  public final void l(String paramString, Bitmap paramBitmap) {}
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1)
    {
      g.DQ();
      this.lYn = ((Integer)g.DP().Dz().get(ac.a.usE, Integer.valueOf(0))).intValue();
      if (paramInt2 == -1)
      {
        if (!q.Gx()) {
          break label51;
        }
        finish();
      }
    }
    return;
    label51:
    finish();
    paramIntent = new nu();
    paramIntent.bXx.context = this.mController.uMN;
    com.tencent.mm.sdk.b.a.udP.m(paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MallIndexBaseUI", "onCreate");
    super.onCreate(paramBundle);
    if (!g.DK())
    {
      com.tencent.mm.sdk.platformtools.y.v("MicroMsg.MallIndexBaseUI", "MMCore is not ready");
      finish();
    }
    g.DQ();
    int i = ((Integer)g.DP().Dz().get(ac.a.usE, Integer.valueOf(0))).intValue();
    this.lYn = getIntent().getIntExtra("key_wallet_region", i);
    this.dCX = getIntent().getStringExtra("key_uuid");
    if (!bk.bl(this.dCX)) {
      this.dCX = UUID.randomUUID().toString();
    }
    kh(495);
    o.bVz();
    aa.a(this);
    this.lYi = getIntent().getStringExtra("key_func_id");
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MallIndexBaseUI", "mFuncId:" + this.lYi + " wallet_region: " + this.lYn + " walletType: " + q.Gq() + " default_region: " + i);
    this.lUA = getIntent().getStringExtra("key_native_url");
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MallIndexBaseUI", "mNativeUrl:" + this.lUA);
    if (aSk()) {
      return;
    }
    if (getSupportActionBar() != null) {
      getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(a.c.mall_index_topbar_color));
    }
    if (com.tencent.mm.compatible.util.d.gF(21)) {
      getWindow().setStatusBarColor(getResources().getColor(a.c.wallet_mall_index_status_bar_color));
    }
    com.tencent.mm.ui.s.czy();
    vN(0);
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MallIndexBaseUI", "index Oncreate");
    bgE();
    initView();
    com.tencent.mm.plugin.wallet_core.model.mall.c.bWj();
    bgF();
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MallIndexBaseUI", "hy: use default controller for MallIndexUI");
    bgG();
    if (q.Gw()) {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.MallIndexBaseUI", "it is payu account ,not initFingerPrint");
    }
    for (;;)
    {
      w.fT(1, 0);
      com.tencent.mm.plugin.report.service.h.nFQ.f(11850, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
      if (Build.VERSION.SDK_INT >= 16) {
        getWindow().getDecorView().setSystemUiVisibility(1280);
      }
      ta(this.mController.uMN.getResources().getColor(a.c.transparent));
      return;
      paramBundle = (k)g.r(k.class);
      if (paramBundle != null)
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MallIndexBaseUI", "IFingerPrintMgr is not null, do showFingerPrintEntrance()");
        paramBundle.dg(this);
      }
      else
      {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.MallIndexBaseUI", "IFingerPrintMgr is not null");
      }
    }
  }
  
  public void onDestroy()
  {
    ki(495);
    o.bVz();
    aa.b(this);
    super.onDestroy();
  }
  
  public void onResume()
  {
    int i = 1;
    super.onResume();
    i.Ez(1);
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MallIndexBaseUI", "index onResume");
    if (!g.DK())
    {
      com.tencent.mm.sdk.platformtools.y.v("MicroMsg.MallIndexBaseUI", "MMCore is not ready");
      finish();
    }
    if (aSk())
    {
      this.lYj = f.bgz().ty(this.lYn);
      if ((this.lYj == null) || (this.lYj.size() <= 0))
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MallIndexBaseUI", "mFunctionList == null");
        try
        {
          if ((getIntent().getIntExtra("key_scene", 0) == 1) || (!bk.bl(this.lUA)))
          {
            a(new com.tencent.mm.plugin.mall.a.c(this.lYn, com.tencent.mm.plugin.wallet_core.model.mall.b.bWf()), true, false);
            return;
          }
          localObject3 = getIntent().getStringExtra("key_url");
          Object localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = "";
          }
          a(new com.tencent.mm.plugin.mall.a.c(this.lYn, com.tencent.mm.plugin.wallet_core.model.mall.b.bWf(), getIntent().getStringExtra("key_app_id"), this.lYi, (String)localObject1), true, false);
          return;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.MallIndexBaseUI", localUnsupportedEncodingException, "", new Object[0]);
          bgL();
          return;
        }
      }
      Object localObject3 = bN(this.lYj);
      Object localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = bO(this.lYj);
      }
      a((MallFunction)localObject2, -1);
      finish();
      return;
    }
    bgI();
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.MallIndexBaseUI", "initFunctionList");
    if (f.bgz().ty(this.lYn) == null)
    {
      a(new com.tencent.mm.plugin.mall.a.c(this.lYn, com.tencent.mm.plugin.wallet_core.model.mall.b.bWf()), true, false);
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.MallIndexBaseUI", "funcitonlist invalid");
      i = 0;
    }
    while (i != 0)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MallIndexBaseUI", "has data");
      aZ();
      return;
      a(new com.tencent.mm.plugin.mall.a.c(this.lYn, com.tencent.mm.plugin.wallet_core.model.mall.b.bWf()), false, false);
      this.lYj = f.bgz().ty(this.lYn);
    }
  }
  
  public void onStop()
  {
    super.onStop();
  }
  
  public final void tz(int paramInt)
  {
    if ((paramInt == 12) && (this.lZx != null)) {
      bgN();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexBaseUI
 * JD-Core Version:    0.7.0.1
 */