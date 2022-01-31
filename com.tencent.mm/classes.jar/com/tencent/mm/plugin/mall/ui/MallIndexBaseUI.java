package com.tencent.mm.plugin.mall.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.view.View;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.ou;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.plugin.appbrand.service.k;
import com.tencent.mm.plugin.mall.a.f;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.plugin.wallet_core.model.n;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.ui.af;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public abstract class MallIndexBaseUI
  extends WalletBaseUI
  implements x.a, n
{
  protected String eAx;
  private String orJ = null;
  private String oxJ = null;
  private ArrayList<MallFunction> oxK = null;
  protected int oxO;
  protected View ozA;
  private boolean ozB = false;
  private TextView ozp = null;
  protected ListView ozq = null;
  private b ozr = null;
  protected ImageView ozs = null;
  protected ImageView ozt;
  protected TextView ozu = null;
  protected TextView ozv;
  private int ozw = 0;
  private boolean ozx = true;
  protected int ozy;
  protected View ozz;
  
  private void bOC()
  {
    boolean bool = getIntent().getBooleanExtra("key_wallet_has_red", false);
    if (this.ozq.getChildCount() == 0) {}
    label404:
    for (;;)
    {
      return;
      int i = this.ozq.getFirstVisiblePosition();
      int j = this.ozq.getChildAt(0).getTop();
      ab.i("MicroMsg.MallIndexBaseUI", "initCheckNew %s fpos %s top %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j) });
      if ((i == 0) && (j == 0) && (bool) && (!this.ozB) && (this.oxK != null))
      {
        this.ozB = true;
        int k = this.ozq.getHeaderViewsCount() + this.ozr.getCount();
        List localList = this.ozr.oyv;
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
                if ((localc != null) && (localc.oyZ != null) && (b.a(localc.oyZ)))
                {
                  i = this.ozq.getFirstVisiblePosition();
                  j = this.ozq.getLastVisiblePosition();
                  ab.i("MicroMsg.MallIndexBaseUI", "get listview show top %s bottom %s redPos: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
                  if ((k >= i) && (k <= j)) {
                    break;
                  }
                  int m = a.bOv();
                  j = a.bOu() + a.bOt() * (k + 1) + m;
                  i = j;
                  if (k > 2) {
                    i = j + m;
                  }
                  j = i;
                  if (k > 3) {
                    j = i + m;
                  }
                  m = a.bOt() / 3;
                  int n = this.ozq.getScrollY();
                  k = af.hQ(this).y;
                  i = k;
                  if (af.hO(this)) {
                    i = k - af.fx(this);
                  }
                  k = i;
                  if (getSupportActionBar() != null) {
                    k = i - getSupportActionBar().getHeight();
                  }
                  this.ozq.smoothScrollBy(j + m - n - k, 1000);
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
  
  private void bOD()
  {
    setResult(0);
    finish();
  }
  
  private void bOH()
  {
    if (r.ZB())
    {
      com.tencent.mm.wallet_core.a.b(getContext(), "PayURemittanceProcess", null);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("pay_channel", 1);
    com.tencent.mm.wallet_core.a.b(getContext(), "RemittanceProcess", localBundle);
  }
  
  private void bOJ()
  {
    if (this.ozp != null) {
      this.ozp.setVisibility(8);
    }
  }
  
  private MallFunction ck(List<MallFunction> paramList)
  {
    Object localObject;
    if ((paramList == null) || (paramList.size() == 0) || (TextUtils.isEmpty(this.oxJ)))
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
        if (this.oxJ.equals(localMallFunction.pUM)) {
          break;
        }
      }
      i += 1;
    }
    label81:
    return null;
  }
  
  private MallFunction cl(List<MallFunction> paramList)
  {
    Object localObject;
    if ((paramList == null) || (paramList.size() == 0) || (TextUtils.isEmpty(this.orJ)))
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
        if (this.orJ.equals(localMallFunction.cMO)) {
          break;
        }
      }
      i += 1;
    }
    label81:
    return null;
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
      if (paramMallFunction.umh != null)
      {
        localObject1 = localObject2;
        if (!bo.isNullOrNil(paramMallFunction.umh.sWB)) {
          localObject1 = paramMallFunction.umh.sWB;
        }
      }
      if (this.oxK != null) {
        break label228;
      }
      i = 0;
      boolean bool = b.a(paramMallFunction);
      localObject2 = com.tencent.mm.plugin.report.service.h.qsU;
      str = paramMallFunction.pUM;
      if (!bool) {
        break label239;
      }
    }
    label228:
    label239:
    for (int j = 2;; j = 1)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject2).e(10881, new Object[] { str, Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(paramInt), localObject1, Integer.valueOf(j) });
      if ((paramMallFunction == null) || (bo.isNullOrNil(paramMallFunction.cMO)) || (!((k)g.E(k.class)).Dp(paramMallFunction.cMO))) {
        break label245;
      }
      ab.i("MicroMsg.MallIndexBaseUI", "handleFunction, intercept by AppBrandNativeLink, nativeUrl = %s", new Object[] { paramMallFunction.cMO });
      c.cUX().afr(paramMallFunction.pUM);
      com.tencent.mm.plugin.wallet_core.model.mall.d.cVb().afr(paramMallFunction.pUM);
      if (paramMallFunction.umh != null)
      {
        c.cUX();
        c.e(paramMallFunction);
      }
      return;
      i = this.oxK.size();
      break;
    }
    label245:
    if (paramMallFunction != null)
    {
      c.cUX().afr(paramMallFunction.pUM);
      com.tencent.mm.plugin.wallet_core.model.mall.d.cVb().afr(paramMallFunction.pUM);
      if (paramMallFunction.umh != null)
      {
        c.cUX();
        c.e(paramMallFunction);
      }
      if ("wxpay://bizmall/mobile_recharge".equals(paramMallFunction.cMO)) {
        paramInt = 0;
      }
    }
    for (;;)
    {
      ab.i("MicroMsg.MallIndexBaseUI", "functionType : ".concat(String.valueOf(paramInt)));
      switch (paramInt)
      {
      default: 
        return;
      case 0: 
        localObject1 = new Intent();
        if (isTransparent()) {
          ((Intent)localObject1).putExtra("key_is_hide_progress", true);
        }
        ((Intent)localObject1).putExtra("key_func_info", paramMallFunction);
        com.tencent.mm.bq.d.b(this, "recharge", ".ui.PhoneRechargeUI", (Intent)localObject1);
        com.tencent.mm.wallet_core.c.z.id(15, 0);
        return;
        if ("wxpay://bizmall/weixin_hongbao".equals(paramMallFunction.cMO))
        {
          paramInt = 4;
        }
        else if ("wxpay://bizmall/weixin_scan_qrcode".equals(paramMallFunction.cMO))
        {
          paramInt = 8;
        }
        else if ("wxpay://bizmall/weixin_transfer".equals(paramMallFunction.cMO))
        {
          paramInt = 5;
        }
        else if ("wxpay://bizmall/weixin_offline_pay".equals(paramMallFunction.cMO))
        {
          paramInt = 6;
        }
        else if ("wxpay://bizmall/old_mobile_recharge".equals(paramMallFunction.cMO))
        {
          paramInt = 7;
        }
        else if (!bo.isNullOrNil(paramMallFunction.nDe))
        {
          paramInt = 1;
        }
        else if ("wxpay://bizmall/f2f_hongbao".equals(paramMallFunction.cMO))
        {
          paramInt = 9;
        }
        else
        {
          ab.w("MicroMsg.MallIndexUIHelper", "doSelectFunction no jump");
          paramInt = 2;
          continue;
          paramInt = 3;
        }
        break;
      }
    }
    com.tencent.mm.plugin.report.service.h.qsU.e(11701, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
    paramMallFunction = new Intent();
    paramMallFunction.putExtra("pay_channel", 1);
    com.tencent.mm.bq.d.b(this, "luckymoney", ".ui.LuckyMoneyIndexUI", paramMallFunction);
    com.tencent.mm.wallet_core.c.z.id(13, 0);
    com.tencent.mm.plugin.report.service.h.qsU.e(11850, new Object[] { Integer.valueOf(4), Integer.valueOf(0) });
    return;
    Object localObject1 = new Intent();
    if (isTransparent()) {
      ((Intent)localObject1).putExtra("key_is_hide_progress", true);
    }
    ((Intent)localObject1).putExtra("key_func_info", paramMallFunction);
    com.tencent.mm.bq.d.b(this, "recharge", ".ui.RechargeUI", (Intent)localObject1);
    return;
    g.RM();
    this.oxO = ((Integer)g.RL().Ru().get(ac.a.yCE, Integer.valueOf(0))).intValue();
    localObject1 = new Intent();
    ((Intent)localObject1).putExtra("rawUrl", paramMallFunction.nDe);
    ((Intent)localObject1).putExtra("geta8key_username", r.Zn());
    ((Intent)localObject1).putExtra("pay_channel", 1);
    ((Intent)localObject1).putExtra("KPublisherId", "pay_wallet");
    ((Intent)localObject1).putExtra("key_download_restrict", paramMallFunction.umj);
    ((Intent)localObject1).putExtra("key_wallet_region", this.oxO);
    ((Intent)localObject1).putExtra("key_function_id", paramMallFunction.pUM);
    ((Intent)localObject1).putExtra("geta8key_scene", 46);
    com.tencent.mm.bq.d.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", (Intent)localObject1);
    return;
    ab.w("MicroMsg.MallIndexBaseUI", "doSelectFunction no jump");
    return;
    ab.w("MicroMsg.MallIndexBaseUI", "doSelectFunction do nothing");
    com.tencent.mm.ui.base.t.makeText(this, "fuction list error", 1).show();
    return;
    com.tencent.mm.plugin.report.service.h.qsU.e(11458, new Object[] { Integer.valueOf(1) });
    if (r.ZB())
    {
      paramMallFunction = new LinkedList();
      localObject1 = new LinkedList();
      paramMallFunction.add(getString(2131302629));
      ((List)localObject1).add(Integer.valueOf(0));
      paramMallFunction.add(getString(2131298484));
      ((List)localObject1).add(Integer.valueOf(1));
      com.tencent.mm.ui.base.h.a(this, getString(2131302538), paramMallFunction, (List)localObject1, null, true, new MallIndexBaseUI.3(this));
    }
    for (;;)
    {
      com.tencent.mm.wallet_core.c.z.id(14, 0);
      com.tencent.mm.plugin.report.service.h.qsU.e(11850, new Object[] { Integer.valueOf(3), Integer.valueOf(0) });
      return;
      g.RM();
      if (!((Boolean)g.RL().Ru().get(ac.a.yyE, Boolean.FALSE)).booleanValue())
      {
        g.RM();
        g.RL().Ru().set(ac.a.yyE, Boolean.TRUE);
        com.tencent.mm.ui.base.h.a(this, getString(2131305115), "", new MallIndexBaseUI.4(this));
      }
      else
      {
        bOH();
      }
    }
    paramMallFunction = new Intent();
    paramMallFunction.putExtra("key_from_scene", 1);
    com.tencent.mm.bq.d.b(getContext(), "offline", ".ui.WalletOfflineEntranceUI", paramMallFunction);
    com.tencent.mm.wallet_core.c.z.id(9, 0);
    com.tencent.mm.plugin.report.service.h.qsU.e(11850, new Object[] { Integer.valueOf(5), Integer.valueOf(0) });
    return;
    paramMallFunction = new Intent();
    paramMallFunction.putExtra("BaseScanUI_select_scan_mode", 1);
    com.tencent.mm.bq.d.b(getContext(), "scanner", ".ui.BaseScanUI", paramMallFunction);
    return;
    com.tencent.mm.bq.d.H(getContext(), "luckymoney", ".f2f.ui.LuckyMoneyF2FQRCodeUI");
  }
  
  protected abstract void bHV();
  
  public final void bJ()
  {
    showOptionMenu(true);
    this.ozr.I(this.oxK);
    bOG();
    bOI();
    bOJ();
    bOK();
  }
  
  protected final void bOA()
  {
    if (this.ozv.getVisibility() == 0)
    {
      a.a(this, true, false);
      AbsListView.LayoutParams localLayoutParams2 = (AbsListView.LayoutParams)this.ozz.getLayoutParams();
      AbsListView.LayoutParams localLayoutParams1 = localLayoutParams2;
      if (localLayoutParams2 == null) {
        localLayoutParams1 = new AbsListView.LayoutParams(-1, -2);
      }
      localLayoutParams1.height = a.bOu();
      this.ozz.setLayoutParams(localLayoutParams1);
    }
  }
  
  protected abstract boolean bOB();
  
  protected abstract void bOE();
  
  protected abstract void bOF();
  
  protected abstract void bOG();
  
  protected abstract void bOI();
  
  protected abstract void bOK();
  
  protected abstract void bOx();
  
  protected abstract void bOy();
  
  protected abstract void bOz();
  
  public boolean checkProcLife()
  {
    return false;
  }
  
  protected abstract void dt(View paramView);
  
  public void finish()
  {
    super.finish();
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130970087;
  }
  
  protected abstract void initHeaderView();
  
  public void initView()
  {
    ab.d("MicroMsg.MallIndexBaseUI", "index initView");
    setBackBtn(new MallIndexBaseUI.1(this));
    this.ozq = ((ListView)findViewById(2131825963));
    initHeaderView();
    bOE();
    this.ozr = new b(this, this.oxO);
    this.ozq.setAdapter(this.ozr);
    this.ozr.oyw = new MallIndexBaseUI.2(this);
    dt(this.ozz);
    this.ozv = ((TextView)findViewById(2131821672));
    bOF();
  }
  
  public boolean isTransparent()
  {
    return (!bo.isNullOrNil(this.oxJ)) || (!bo.isNullOrNil(this.orJ));
  }
  
  public final void m(String paramString, Bitmap paramBitmap) {}
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1)
    {
      g.RM();
      this.oxO = ((Integer)g.RL().Ru().get(ac.a.yCE, Integer.valueOf(0))).intValue();
      if (paramInt2 == -1)
      {
        if (!r.ZC()) {
          break label51;
        }
        finish();
      }
    }
    return;
    label51:
    finish();
    paramIntent = new ou();
    paramIntent.cFt.context = getContext();
    com.tencent.mm.sdk.b.a.ymk.l(paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    ab.i("MicroMsg.MallIndexBaseUI", "onCreate");
    super.onCreate(paramBundle);
    if (!g.RG())
    {
      ab.v("MicroMsg.MallIndexBaseUI", "MMCore is not ready");
      finish();
    }
    g.RM();
    int i = ((Integer)g.RL().Ru().get(ac.a.yCE, Integer.valueOf(0))).intValue();
    this.oxO = getIntent().getIntExtra("key_wallet_region", i);
    this.eAx = getIntent().getStringExtra("key_uuid");
    if (!bo.isNullOrNil(this.eAx)) {
      this.eAx = UUID.randomUUID().toString();
    }
    addSceneEndListener(495);
    com.tencent.mm.plugin.wallet_core.model.t.cTU();
    ag.a(this);
    this.oxJ = getIntent().getStringExtra("key_func_id");
    ab.i("MicroMsg.MallIndexBaseUI", "mFuncId:" + this.oxJ + " wallet_region: " + this.oxO + " walletType: " + r.Zu() + " default_region: " + i);
    this.orJ = getIntent().getStringExtra("key_native_url");
    ab.i("MicroMsg.MallIndexBaseUI", "mNativeUrl:" + this.orJ);
    if (isTransparent()) {
      return;
    }
    bHV();
    setContentViewVisibility(0);
    ab.i("MicroMsg.MallIndexBaseUI", "index Oncreate");
    bOx();
    initView();
    c.cVa();
    bOy();
    ab.i("MicroMsg.MallIndexBaseUI", "hy: use default controller for MallIndexUI");
    bOz();
    if (r.ZB()) {
      ab.e("MicroMsg.MallIndexBaseUI", "it is payu account ,not initFingerPrint");
    }
    for (;;)
    {
      com.tencent.mm.wallet_core.c.z.id(1, 0);
      com.tencent.mm.plugin.report.service.h.qsU.e(11850, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
      return;
      paramBundle = (l)g.E(l.class);
      if (paramBundle != null)
      {
        ab.i("MicroMsg.MallIndexBaseUI", "IFingerPrintMgr is not null, do showFingerPrintEntrance()");
        paramBundle.byR();
      }
      else
      {
        ab.e("MicroMsg.MallIndexBaseUI", "IFingerPrintMgr is not null");
      }
    }
  }
  
  public void onDestroy()
  {
    removeSceneEndListener(495);
    com.tencent.mm.plugin.wallet_core.model.t.cTU();
    ag.b(this);
    super.onDestroy();
  }
  
  public boolean onProgressFinish()
  {
    if (!isTransparent()) {
      bJ();
    }
    return true;
  }
  
  public void onResume()
  {
    int i = 1;
    super.onResume();
    com.tencent.mm.pluginsdk.wallet.j.Mx(1);
    ab.i("MicroMsg.MallIndexBaseUI", "index onResume");
    if (!g.RG())
    {
      ab.v("MicroMsg.MallIndexBaseUI", "MMCore is not ready");
      finish();
    }
    if (isTransparent())
    {
      this.oxK = com.tencent.mm.plugin.mall.a.j.bOs().yK(this.oxO);
      if ((this.oxK == null) || (this.oxK.size() <= 0))
      {
        ab.i("MicroMsg.MallIndexBaseUI", "mFunctionList == null");
        try
        {
          if ((getIntent().getIntExtra("key_scene", 0) == 1) || (!bo.isNullOrNil(this.orJ)))
          {
            doSceneForceProgress(new f(this.oxO, com.tencent.mm.plugin.wallet_core.model.mall.b.cUW(), 0));
            return;
          }
          localObject3 = getIntent().getStringExtra("key_url");
          Object localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = "";
          }
          doSceneForceProgress(new f(this.oxO, com.tencent.mm.plugin.wallet_core.model.mall.b.cUW(), getIntent().getStringExtra("key_app_id"), this.oxJ, (String)localObject1));
          return;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          ab.printErrStackTrace("MicroMsg.MallIndexBaseUI", localUnsupportedEncodingException, "", new Object[0]);
          bOD();
          return;
        }
      }
      Object localObject3 = ck(this.oxK);
      Object localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = cl(this.oxK);
      }
      a((MallFunction)localObject2, -1);
      finish();
      return;
    }
    bOB();
    ab.d("MicroMsg.MallIndexBaseUI", "initFunctionList");
    if (com.tencent.mm.plugin.mall.a.j.bOs().yK(this.oxO) == null)
    {
      doSceneProgress(new f(this.oxO, com.tencent.mm.plugin.wallet_core.model.mall.b.cUW(), 0), true);
      ab.e("MicroMsg.MallIndexBaseUI", "funcitonlist invalid");
      i = 0;
    }
    while (i != 0)
    {
      ab.i("MicroMsg.MallIndexBaseUI", "has data");
      bJ();
      return;
      doSceneProgress(new f(this.oxO, com.tencent.mm.plugin.wallet_core.model.mall.b.cUW(), 1), false);
      this.oxK = com.tencent.mm.plugin.mall.a.j.bOs().yK(this.oxO);
    }
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    ab.d("MicroMsg.MallIndexBaseUI", "onOtherSceneEnd");
    if ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.b.a))
    {
      ab.d("MicroMsg.MallIndexBaseUI", "hy: query bound scene end");
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (this.ozx)
        {
          this.ozx = false;
          if (com.tencent.mm.plugin.wallet_core.model.t.cTJ().cVl().cUn())
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
    paramString = (f)paramm;
    if (paramString.oxO != this.oxO) {
      ab.i("MicroMsg.MallIndexBaseUI", "pass wallet local: %d cgi: %d", new Object[] { Integer.valueOf(this.oxO), Integer.valueOf(paramString.oxO) });
    }
    if (isTransparent())
    {
      ab.d("MicroMsg.MallIndexBaseUI", "errorType:%d | errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if ((paramInt1 == 0) && (paramInt2 == 0) && (paramString.oxK != null))
      {
        if (getIntent().getIntExtra("key_scene", 0) == 1)
        {
          paramString = ck(paramString.oxK);
          if (paramString != null) {
            a(paramString, -1);
          }
        }
        for (;;)
        {
          setResult(-1);
          finish();
          return true;
          if (!bo.isNullOrNil(this.orJ))
          {
            ab.d("MicroMsg.MallIndexBaseUI", "NativeUrl: %s", new Object[] { this.orJ });
            paramString = cl(paramString.oxK);
            if (paramString != null)
            {
              a(paramString, -1);
            }
            else
            {
              bOD();
              return true;
            }
          }
          else if ((paramString.oxK != null) && (paramString.oxK.size() > 0))
          {
            ab.i("MicroMsg.MallIndexBaseUI", "functionScene.mFunctionList != null");
            a(ck(paramString.oxK), -1);
          }
          else if ((com.tencent.mm.plugin.mall.a.j.bOs().yK(this.oxO) != null) && (com.tencent.mm.plugin.mall.a.j.bOs().yK(this.oxO).size() > 0))
          {
            ab.i("MicroMsg.MallIndexBaseUI", "SubCoreMall.getCore().getFunctionList() != null");
            a(ck(com.tencent.mm.plugin.mall.a.j.bOs().yK(this.oxO)), -1);
          }
          else
          {
            ab.e("MicroMsg.MallIndexBaseUI", "SubCoreMall.getCore().getFunctionList() == null");
          }
        }
      }
      bOD();
      return true;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0) && (com.tencent.mm.plugin.mall.a.j.bOs().yK(this.oxO) != null) && (paramString.oxK != null))
    {
      this.oxK = com.tencent.mm.plugin.mall.a.j.bOs().yK(this.oxO);
      ab.i("MicroMsg.MallIndexBaseUI", "get from server now! " + this.oxO + " " + this.oxK.size());
      c.cUX().X(this.oxK);
    }
    bJ();
    bOC();
    bOE();
    return true;
  }
  
  public void onStop()
  {
    super.onStop();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void setStatusColor() {}
  
  public void shouldFixStatusBar() {}
  
  public final void yO(int paramInt)
  {
    if ((paramInt == 12) && (this.ozu != null)) {
      bOG();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexBaseUI
 * JD-Core Version:    0.7.0.1
 */