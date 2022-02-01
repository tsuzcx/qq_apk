package com.tencent.mm.plugin.mall.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.rg;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.appbrand.api.WeAppOpenDeclarePromptBundle;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.plugin.appbrand.service.p;
import com.tencent.mm.plugin.mall.a.k;
import com.tencent.mm.plugin.wallet_core.model.ah;
import com.tencent.mm.plugin.wallet_core.model.l;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.protocal.protobuf.atw;
import com.tencent.mm.protocal.protobuf.eba;
import com.tencent.mm.protocal.protobuf.ebc;
import com.tencent.mm.protocal.protobuf.ebd;
import com.tencent.mm.protocal.protobuf.ebo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.e.m;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public abstract class MallIndexBaseUIv2
  extends WalletBaseUI
  implements u.a, l
{
  protected View rXv;
  protected String uuid;
  private String vDf = null;
  private ArrayList<MallFunction> vDg = null;
  protected int vDk;
  private TextView vEW = null;
  protected ListView vEX = null;
  protected ImageView vFa;
  protected TextView vFb = null;
  protected TextView vFc;
  private int vFd = 0;
  protected View vFg;
  private boolean vFh = false;
  private c vFm = null;
  private ArrayList<atw> vFn = null;
  private String vvi = null;
  
  private void c(MallFunction paramMallFunction)
  {
    if ((paramMallFunction != null) && (!bt.isNullOrNil(paramMallFunction.dNL)) && (((p)com.tencent.mm.kernel.g.ab(p.class)).n(paramMallFunction.dNL, null)))
    {
      ad.i("MallIndexBaseUIv2", "handleFunction, intercept by AppBrandNativeLink, nativeUrl = %s", new Object[] { paramMallFunction.dNL });
      com.tencent.mm.plugin.wallet_core.model.mall.c.eGT().aEC(paramMallFunction.jDb);
      com.tencent.mm.plugin.wallet_core.model.mall.d.eGX().aEC(paramMallFunction.jDb);
      if (paramMallFunction.Dbp != null)
      {
        com.tencent.mm.plugin.wallet_core.model.mall.c.eGT();
        com.tencent.mm.plugin.wallet_core.model.mall.c.i(paramMallFunction);
      }
      return;
    }
    int i = d.f(paramMallFunction);
    ad.i("MallIndexBaseUIv2", "functionType : ".concat(String.valueOf(i)));
    switch (i)
    {
    default: 
      return;
    case 0: 
      d(paramMallFunction);
      ab.kB(15, 0);
      return;
    case 1: 
      e(paramMallFunction);
      return;
    case 2: 
      dky();
      return;
    }
    dkx();
  }
  
  private void d(MallFunction paramMallFunction)
  {
    Intent localIntent = new Intent();
    if (isTransparent()) {
      localIntent.putExtra("key_is_hide_progress", true);
    }
    localIntent.putExtra("key_func_info", paramMallFunction);
    com.tencent.mm.bs.d.b(this, "recharge", ".ui.PhoneRechargeUI", localIntent);
  }
  
  private void dkm()
  {
    boolean bool = getIntent().getBooleanExtra("key_wallet_has_red", false);
    if (this.vEX.getChildCount() == 0) {}
    for (;;)
    {
      return;
      int i = this.vEX.getFirstVisiblePosition();
      int j = this.vEX.getChildAt(0).getTop();
      ad.i("MallIndexBaseUIv2", "initCheckNew %s fpos %s top %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j) });
      if ((i == 0) && (j == 0) && (bool) && (!this.vFh) && (this.vFn != null))
      {
        this.vFh = true;
        j = this.vEX.getHeaderViewsCount() + this.vFm.getCount();
        ad.i("MallIndexBaseUIv2", "mFunctionsGv.getHeaderViewsCount()： %s mFunctionAdapter.getCount(): %s", new Object[] { Integer.valueOf(this.vEX.getHeaderViewsCount()), Integer.valueOf(this.vFm.getCount()) });
        List localList = this.vFm.vDW;
        if (localList != null)
        {
          i = localList.size() - 1;
          while (i > 0)
          {
            Iterator localIterator = ((ArrayList)localList.get(i)).iterator();
            while (localIterator.hasNext())
            {
              c.c localc = (c.c)localIterator.next();
              if ((localc != null) && (localc.vEH != null) && (c.a(localc.vEH)))
              {
                i = this.vEX.getFirstVisiblePosition();
                int k = this.vEX.getLastVisiblePosition();
                ad.i("MallIndexBaseUIv2", "get listview show top %s bottom %s redPos: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j) });
                if ((j >= i) && (j <= k))
                {
                  ad.i("MallIndexBaseUIv2", "the last redDot item is visible");
                  return;
                }
                int m = com.tencent.mm.cc.a.fromDPToPix(getContext(), 48);
                int n = com.tencent.mm.cc.a.fromDPToPix(getContext(), 8);
                int i1 = ((Integer)com.tencent.mm.plugin.wallet_core.model.mall.b.eGP().get(localc.vEH.GrW)).intValue();
                int i2 = dkw();
                int i3 = a.dkb();
                k = al.ci(this).y;
                i = k;
                if (al.jR(this)) {
                  i = k - al.ej(this);
                }
                k = i;
                if (getSupportActionBar() != null) {
                  k = i - getSupportActionBar().getHeight();
                }
                i = this.vEX.getScrollY();
                int i4 = a.dkb() / 3;
                this.vEX.smoothScrollBy(j * i3 + i2 + i1 * (m + n) - k - i + i4, 1000);
                ad.i("MallIndexBaseUIv2", "offset function is %s, groupName is %s", new Object[] { localc.vEH.GrP.Name, Integer.valueOf(localc.vEH.GrW) });
                return;
              }
            }
            j -= 1;
            i -= 1;
          }
        }
      }
    }
  }
  
  private void dkn()
  {
    setResult(0);
    finish();
  }
  
  private void dkt()
  {
    if (this.vEW != null) {
      this.vEW.setVisibility(8);
    }
  }
  
  private void dkx()
  {
    ad.w("MallIndexBaseUIv2", "doSelectFunction do nothing");
    com.tencent.mm.ui.base.t.makeText(this, "fuction list error", 1).show();
  }
  
  private static void dky()
  {
    ad.w("MallIndexBaseUIv2", "doSelectFunction no jump");
  }
  
  private void e(MallFunction paramMallFunction)
  {
    com.tencent.mm.kernel.g.ajD();
    this.vDk = ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Ivh, Integer.valueOf(0))).intValue();
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramMallFunction.usV);
    localIntent.putExtra("geta8key_username", u.aAm());
    localIntent.putExtra("pay_channel", 1);
    localIntent.putExtra("KPublisherId", "pay_wallet");
    localIntent.putExtra("key_download_restrict", paramMallFunction.Dbr);
    localIntent.putExtra("key_wallet_region", this.vDk);
    localIntent.putExtra("key_function_id", paramMallFunction.jDb);
    localIntent.putExtra(e.m.IVa, true);
    localIntent.putExtra("geta8key_scene", 46);
    com.tencent.mm.wallet_core.ui.e.an(getContext(), localIntent);
  }
  
  private MallFunction eu(List<MallFunction> paramList)
  {
    Object localObject;
    if ((paramList == null) || (paramList.size() == 0) || (TextUtils.isEmpty(this.vDf)))
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
        if (this.vDf.equals(localMallFunction.jDb)) {
          break;
        }
      }
      i += 1;
    }
    label81:
    return null;
  }
  
  private MallFunction ev(List<MallFunction> paramList)
  {
    Object localObject;
    if ((paramList == null) || (paramList.size() == 0) || (TextUtils.isEmpty(this.vvi)))
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
        if (this.vvi.equals(localMallFunction.dNL)) {
          break;
        }
      }
      i += 1;
    }
    label81:
    return null;
  }
  
  public final boolean a(atw paramatw, int paramInt)
  {
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qxU, 1) == 1) {}
    for (int i = 1; i == 0; i = 0)
    {
      ad.i("MallIndexBaseUIv2", "handleFunctionByAppBrand clicfg_appbrand_dialog_optimize_switch close");
      return false;
    }
    if ((paramatw.GrR == null) && (paramatw.GrR.type != 2))
    {
      ad.i("MallIndexBaseUIv2", "functionItem.Entrance == null");
      return false;
    }
    if ((paramatw != null) && (paramInt >= 0)) {
      if ((paramatw.GrQ == null) || (bt.isNullOrNil(paramatw.GrQ.HNH))) {
        break label858;
      }
    }
    label187:
    label840:
    label853:
    label858:
    for (Object localObject1 = Long.toString(paramatw.GrQ.HNH & 0xFFFFFFFF);; localObject1 = "")
    {
      int j;
      boolean bool;
      Object localObject2;
      long l;
      int m;
      Object localObject3;
      if (this.vFn == null)
      {
        j = 0;
        bool = c.a(paramatw);
        localObject2 = com.tencent.mm.plugin.wallet_core.model.mall.b.eGR();
        if (((SparseArray)localObject2).size() != 0)
        {
          l = paramatw.GrW;
          localObject2 = (ArrayList)((SparseArray)localObject2).get(paramatw.GrW);
          m = ((ArrayList)localObject2).size();
          i = 0;
          if (i >= ((ArrayList)localObject2).size()) {
            break label853;
          }
          localObject3 = (Integer)((ArrayList)localObject2).get(i);
          if ((localObject3 == null) || (((Integer)localObject3).compareTo(Integer.valueOf(paramatw.GrP.HNO)) != 0)) {
            break label840;
          }
        }
      }
      for (;;)
      {
        ad.i("MallIndexBaseUIv2", "click report activityId:%s,FunctionID：%s", new Object[] { localObject1, Long.toString(paramatw.GrP.HNO & 0xFFFFFFFF) });
        localObject2 = com.tencent.mm.plugin.report.service.g.yhR;
        localObject3 = Long.toString(paramatw.GrP.HNO & 0xFFFFFFFF);
        if (bool) {}
        for (int k = 2;; k = 1)
        {
          ((com.tencent.mm.plugin.report.service.g)localObject2).f(10881, new Object[] { localObject3, Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(paramInt), localObject1, Integer.valueOf(k), Integer.valueOf(2), Long.valueOf(l), Integer.valueOf(m), Integer.valueOf(i) });
          com.tencent.mm.plugin.wallet_core.model.mall.c.eGT().aEC(paramatw.GrP.HNO);
          com.tencent.mm.plugin.wallet_core.model.mall.d.eGX().aEC(paramatw.GrP.HNO);
          if (paramatw.GrQ != null)
          {
            localObject1 = new MallFunction();
            ((MallFunction)localObject1).jDb = paramatw.GrP.HNO;
            ((MallFunction)localObject1).dKm = paramatw.GrP.Name;
            ((MallFunction)localObject1).Dbp = new MallNews(((MallFunction)localObject1).jDb);
            ((MallFunction)localObject1).Dbp.Bhd = paramatw.GrQ.HNH;
            com.tencent.mm.plugin.wallet_core.model.mall.c.eGT();
            com.tencent.mm.plugin.wallet_core.model.mall.c.i((MallFunction)localObject1);
          }
          ad.i("MallIndexBaseUIv2", "handleFunctionNew id：%s，name：%s，type：%s", new Object[] { Integer.valueOf(paramatw.GrP.HNO), paramatw.GrP.Name, Integer.valueOf(paramatw.GrR.type) });
          ad.i("MallIndexBaseUIv2", "handleFunctionNew functionItem.Entrance.URLWeApp.username：%s,functionItem.Entrance.URLWeApp.pagepath:%s,functionItem.Entrance.URLWeApp.version:%s", new Object[] { paramatw.GrR.HNN.username, paramatw.GrR.HNN.xZB, Integer.valueOf(paramatw.GrR.HNN.version) });
          localObject1 = new com.tencent.mm.plugin.appbrand.api.f();
          ((com.tencent.mm.plugin.appbrand.api.f)localObject1).username = paramatw.GrR.HNN.username;
          ((com.tencent.mm.plugin.appbrand.api.f)localObject1).version = paramatw.GrR.HNN.version;
          ((com.tencent.mm.plugin.appbrand.api.f)localObject1).jCN = paramatw.GrR.HNN.xZB;
          ((com.tencent.mm.plugin.appbrand.api.f)localObject1).hQh = 0;
          ((com.tencent.mm.plugin.appbrand.api.f)localObject1).scene = 1019;
          localObject2 = getString(2131761167);
          localObject3 = getString(2131755792);
          WeAppOpenDeclarePromptBundle localWeAppOpenDeclarePromptBundle = new WeAppOpenDeclarePromptBundle((byte)0);
          localWeAppOpenDeclarePromptBundle.ePC = 2;
          localWeAppOpenDeclarePromptBundle.jDc = ((String)localObject2);
          localWeAppOpenDeclarePromptBundle.jDd = paramatw.GrU;
          localWeAppOpenDeclarePromptBundle.jDe = ((String)localObject3);
          localWeAppOpenDeclarePromptBundle.ov = false;
          localWeAppOpenDeclarePromptBundle.jDb = paramatw.GrP.HNO;
          ((com.tencent.mm.plugin.appbrand.api.f)localObject1).jDa = localWeAppOpenDeclarePromptBundle;
          ((o)com.tencent.mm.kernel.g.ab(o.class)).a(getContext(), (com.tencent.mm.plugin.appbrand.api.f)localObject1);
          return true;
          j = this.vFn.size();
          break;
          i += 1;
          break label187;
        }
        i = 0;
      }
    }
  }
  
  public boolean checkProcLife()
  {
    return false;
  }
  
  protected abstract void dcd();
  
  protected abstract void dkh();
  
  protected abstract void dki();
  
  protected abstract boolean dkk();
  
  protected abstract void dko();
  
  protected abstract void dkp();
  
  protected abstract void dkq();
  
  protected abstract void dks();
  
  protected abstract void dku();
  
  protected abstract void dkv();
  
  protected abstract int dkw();
  
  protected abstract void es(View paramView);
  
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
    return 2131494701;
  }
  
  public final void i(int paramInt, Object[] paramArrayOfObject)
  {
    if ((paramInt == 12) && (this.vFb != null)) {
      dkq();
    }
  }
  
  protected abstract void initHeaderView();
  
  public void initView()
  {
    ad.d("MallIndexBaseUIv2", "index initView");
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(199042);
        paramAnonymousMenuItem = new Intent();
        paramAnonymousMenuItem.addFlags(67108864);
        paramAnonymousMenuItem.putExtra("preferred_tab", 3);
        com.tencent.mm.bs.d.f(MallIndexBaseUIv2.this, "com.tencent.mm.ui.LauncherUI", paramAnonymousMenuItem);
        MallIndexBaseUIv2.this.finish();
        if (!com.tencent.mm.pluginsdk.wallet.e.ffA())
        {
          com.tencent.mm.plugin.report.service.g.yhR.f(14954, new Object[] { com.tencent.mm.pluginsdk.wallet.e.ffB(), "open_wcpay_specific_view:ok" });
          com.tencent.mm.pluginsdk.wallet.e.ffC();
        }
        com.tencent.mm.plugin.report.service.g.yhR.f(14419, new Object[] { MallIndexBaseUIv2.this.uuid, Integer.valueOf(6) });
        ad.i("MallIndexBaseUIv2", "set BackBtn");
        AppMethodBeat.o(199042);
        return true;
      }
    });
    this.vEX = ((ListView)findViewById(2131302018));
    initHeaderView();
    dko();
    this.vFm = new c(this);
    this.vEX.setAdapter(this.vFm);
    this.vFm.vEC = new c.d()
    {
      public final void a(final int paramAnonymousInt, final atw paramAnonymousatw)
      {
        AppMethodBeat.i(199045);
        if (paramAnonymousatw != null)
        {
          int i;
          if ((!com.tencent.mm.plugin.wallet_core.model.mall.b.a.aEz(paramAnonymousatw.GrP.HNO)) && (!bt.isNullOrNil(paramAnonymousatw.GrU)))
          {
            i = 1;
            if (i == 0) {
              break label276;
            }
            ad.i("MallIndexBaseUIv2", "onFunctionItemClick show disclaimer funcId=%s", new Object[] { paramAnonymousatw.GrP.HNO });
            if (!MallIndexBaseUIv2.this.a(paramAnonymousatw, paramAnonymousInt))
            {
              d.a locala = new d.a(MallIndexBaseUIv2.this.getContext());
              String str1 = MallIndexBaseUIv2.this.getString(2131761167);
              String str2 = MallIndexBaseUIv2.this.getString(2131755792);
              locala.aXF(str1);
              locala.aXG(paramAnonymousatw.GrU);
              locala.aXM(str2).c(new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(199043);
                  ad.i("MallIndexBaseUIv2", "onFunctionItemClick: onClick");
                  com.tencent.mm.plugin.wallet_core.model.mall.b.a.aEy(paramAnonymousatw.GrP.HNO);
                  MallIndexBaseUIv2.a(MallIndexBaseUIv2.this, paramAnonymousatw, paramAnonymousInt);
                  AppMethodBeat.o(199043);
                }
              });
              locala.yR(true);
              locala.e(new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(199044);
                  ad.i("MallIndexBaseUIv2", "onFunctionItemClick: onCancel");
                  com.tencent.mm.plugin.wallet_core.model.mall.b.a.aEy(paramAnonymousatw.GrP.HNO);
                  AppMethodBeat.o(199044);
                }
              });
              locala.fMb().show();
            }
          }
          for (;;)
          {
            ad.d("MallIndexBaseUIv2", "type: %s", new Object[] { Integer.valueOf(paramAnonymousatw.GrW) });
            com.tencent.mm.plugin.report.service.g.yhR.f(14419, new Object[] { MallIndexBaseUIv2.this.uuid, Integer.valueOf(4), Integer.valueOf(paramAnonymousatw.GrW) });
            AppMethodBeat.o(199045);
            return;
            i = 0;
            break;
            label276:
            MallIndexBaseUIv2.a(MallIndexBaseUIv2.this, paramAnonymousatw, paramAnonymousInt);
          }
        }
        ad.w("MallIndexBaseUIv2", "onFunctionItemClick functionItem null; pos=%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(199045);
      }
    };
    es(this.rXv);
    this.vFc = ((TextView)findViewById(2131297186));
    dkp();
  }
  
  public boolean isTransparent()
  {
    return (!bt.isNullOrNil(this.vDf)) || (!bt.isNullOrNil(this.vvi));
  }
  
  public final void k(String paramString, Bitmap paramBitmap) {}
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1)
    {
      com.tencent.mm.kernel.g.ajD();
      this.vDk = ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Ivh, Integer.valueOf(0))).intValue();
      if (paramInt2 == -1)
      {
        if (!u.aAC()) {
          break label51;
        }
        finish();
      }
    }
    return;
    label51:
    finish();
    paramIntent = new rg();
    paramIntent.dFQ.context = getContext();
    com.tencent.mm.sdk.b.a.IbL.l(paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    ad.i("MallIndexBaseUIv2", "onCreate");
    super.onCreate(paramBundle);
    if (!com.tencent.mm.kernel.g.ajx())
    {
      ad.v("MallIndexBaseUIv2", "MMCore is not ready");
      finish();
    }
    com.tencent.mm.kernel.g.ajD();
    int i = ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Ivh, Integer.valueOf(0))).intValue();
    this.vDk = getIntent().getIntExtra("key_wallet_region", i);
    this.uuid = getIntent().getStringExtra("key_uuid");
    if (bt.isNullOrNil(this.uuid)) {
      this.uuid = UUID.randomUUID().toString();
    }
    addSceneEndListener(495);
    addSceneEndListener(4362);
    com.tencent.mm.plugin.wallet_core.model.t.eFF();
    ah.a(this);
    this.vDf = getIntent().getStringExtra("key_func_id");
    ad.i("MallIndexBaseUIv2", "mFuncId:" + this.vDf + " wallet_region: " + this.vDk + " walletType: " + u.aAt() + " default_region: " + i);
    this.vvi = getIntent().getStringExtra("key_native_url");
    ad.i("MallIndexBaseUIv2", "mNativeUrl:" + this.vvi);
    if (isTransparent())
    {
      ad.i("MallIndexBaseUIv2", "Oncreate：isTransparent()");
      return;
    }
    dcd();
    setContentViewVisibility(0);
    dkh();
    initView();
    com.tencent.mm.plugin.wallet_core.model.mall.c.eGW();
    dki();
    if (u.aAB()) {
      ad.e("MallIndexBaseUIv2", "it is payu account ,not initFingerPrint");
    }
    for (;;)
    {
      ab.kB(1, 0);
      com.tencent.mm.plugin.report.service.g.yhR.f(11850, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
      return;
      paramBundle = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
      if (paramBundle != null)
      {
        ad.i("MallIndexBaseUIv2", "IFingerPrintMgr is not null, do showFingerPrintEntrance()");
        paramBundle.cPn();
      }
      else
      {
        ad.e("MallIndexBaseUIv2", "IFingerPrintMgr is not null");
      }
    }
  }
  
  public void onDestroy()
  {
    removeSceneEndListener(495);
    removeSceneEndListener(4362);
    com.tencent.mm.plugin.wallet_core.model.t.eFF();
    ah.b(this);
    super.onDestroy();
  }
  
  public boolean onProgressFinish()
  {
    if (!isTransparent()) {
      updateView();
    }
    return true;
  }
  
  public void onResume()
  {
    int i = 1;
    super.onResume();
    h.Zx(1);
    ad.i("MallIndexBaseUIv2", "onResume");
    if (!com.tencent.mm.kernel.g.ajx())
    {
      ad.v("MallIndexBaseUIv2", "MMCore is not ready");
      finish();
    }
    if (isTransparent())
    {
      this.vDg = k.dka().JD(this.vDk);
      if ((this.vDg == null) || (this.vDg.size() <= 0))
      {
        ad.i("MallIndexBaseUIv2", "mFunctionList == null");
        try
        {
          if ((getIntent().getIntExtra("key_scene", 0) == 1) || (!bt.isNullOrNil(this.vvi)))
          {
            doSceneForceProgress(new com.tencent.mm.plugin.mall.a.f(this.vDk, com.tencent.mm.plugin.wallet_core.model.mall.b.eGM(), 0));
            return;
          }
          localObject3 = getIntent().getStringExtra("key_url");
          Object localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = "";
          }
          doSceneForceProgress(new com.tencent.mm.plugin.mall.a.f(this.vDk, com.tencent.mm.plugin.wallet_core.model.mall.b.eGM(), getIntent().getStringExtra("key_app_id"), this.vDf, (String)localObject1));
          return;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          ad.printErrStackTrace("MallIndexBaseUIv2", localUnsupportedEncodingException, "", new Object[0]);
          dkn();
          return;
        }
      }
      Object localObject3 = eu(this.vDg);
      Object localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = ev(this.vDg);
      }
      c((MallFunction)localObject2);
      finish();
      return;
    }
    dkk();
    ad.d("MallIndexBaseUIv2", "initFunctionList");
    if (com.tencent.mm.plugin.wallet_core.model.mall.b.eGQ().size() == 0)
    {
      ad.e("MallIndexBaseUIv2", "funcitonlist invalid");
      doSceneProgress(new com.tencent.mm.plugin.mall.a.g(this.vDk), true);
      i = 0;
    }
    while (i != 0)
    {
      ad.i("MallIndexBaseUIv2", "has data");
      updateView();
      return;
      ad.i("MallIndexBaseUIv2", "funcitonlist has cache");
      doSceneProgress(new com.tencent.mm.plugin.mall.a.g(this.vDk), false);
      this.vFn = com.tencent.mm.plugin.wallet_core.model.mall.b.eGQ();
    }
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    ad.d("MallIndexBaseUIv2", "onSceneEnd :%s", new Object[] { Integer.valueOf(paramn.getType()) });
    if (paramn.getType() == 4362)
    {
      paramString = (com.tencent.mm.plugin.mall.a.g)paramn;
      if (paramString.vDk != this.vDk) {
        ad.i("MallIndexBaseUIv2", "pass wallet local: %d cgi: %d", new Object[] { Integer.valueOf(this.vDk), Integer.valueOf(paramString.vDk) });
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.vFn = com.tencent.mm.plugin.wallet_core.model.mall.b.eGQ();
        ad.i("MallIndexBaseUIv2", "get from server now! " + this.vDk + " " + this.vFn.size());
        com.tencent.mm.plugin.wallet_core.model.mall.c.eGT().aE(this.vFn);
      }
      updateView();
      dkm();
      dko();
    }
    do
    {
      return true;
      if (paramn.getType() != 495) {
        break;
      }
      paramString = (com.tencent.mm.plugin.mall.a.f)paramn;
      if (paramString.vDk != this.vDk) {
        ad.i("MallIndexBaseUIv2", "pass wallet local: %d cgi: %d", new Object[] { Integer.valueOf(this.vDk), Integer.valueOf(paramString.vDk) });
      }
    } while (!isTransparent());
    ad.d("MallIndexBaseUIv2", "errorType:%d | errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramString.vDg != null))
    {
      if (getIntent().getIntExtra("key_scene", 0) == 1)
      {
        paramString = eu(paramString.vDg);
        if (paramString != null) {
          c(paramString);
        }
      }
      for (;;)
      {
        setResult(-1);
        finish();
        return true;
        if (!bt.isNullOrNil(this.vvi))
        {
          ad.d("MallIndexBaseUIv2", "NativeUrl: %s", new Object[] { this.vvi });
          paramString = ev(paramString.vDg);
          if (paramString != null)
          {
            c(paramString);
          }
          else
          {
            dkn();
            return true;
          }
        }
        else if ((paramString.vDg != null) && (paramString.vDg.size() > 0))
        {
          ad.i("MallIndexBaseUIv2", "functionScene.mFunctionList != null");
          c(eu(paramString.vDg));
        }
        else if ((k.dka().JD(this.vDk) != null) && (k.dka().JD(this.vDk).size() > 0))
        {
          ad.i("MallIndexBaseUIv2", "SubCoreMall.getCore().getFunctionList() != null");
          c(eu(k.dka().JD(this.vDk)));
        }
        else
        {
          ad.e("MallIndexBaseUIv2", "SubCoreMall.getCore().getFunctionList() == null");
        }
      }
    }
    dkn();
    return true;
    return false;
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
  
  public final void updateView()
  {
    showOptionMenu(true);
    this.vFm.aj(this.vFn);
    dks();
    dkv();
    dkt();
    dku();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexBaseUIv2
 * JD-Core Version:    0.7.0.1
 */