package com.tencent.mm.plugin.mall.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.f.a.te;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.appbrand.api.WeAppOpenDeclarePromptBundle;
import com.tencent.mm.plugin.appbrand.service.s;
import com.tencent.mm.plugin.wallet_core.model.ai;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.l;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.h.e;
import com.tencent.mm.ui.f.r;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.g;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public abstract class MallIndexBaseUI
  extends WalletBaseUI
  implements u.a, l
{
  private static final String EQv = "https://" + WeChatHosts.domainString(a.i.host_kf_qq_com) + "/touch/scene_product.html?scene_id=kf1";
  private String EOD = null;
  ArrayList<MallFunction> EOE = null;
  protected int EOJ;
  protected ImageView EQA;
  protected TextView EQB = null;
  protected TextView EQC;
  private int EQD = 0;
  private boolean EQE = true;
  protected int EQF;
  protected View EQG;
  private boolean EQH = false;
  private TextView EQw = null;
  protected ListView EQx = null;
  private b EQy = null;
  protected ImageView EQz = null;
  private String Eyn = null;
  protected String uuid;
  protected View zRq;
  
  private void eQD()
  {
    boolean bool = getIntent().getBooleanExtra("key_wallet_has_red", false);
    if (this.EQx.getChildCount() == 0) {}
    label404:
    for (;;)
    {
      return;
      int i = this.EQx.getFirstVisiblePosition();
      int j = this.EQx.getChildAt(0).getTop();
      Log.i("MicroMsg.MallIndexBaseUI", "initCheckNew %s fpos %s top %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j) });
      if ((i == 0) && (j == 0) && (bool) && (!this.EQH) && (this.EOE != null))
      {
        this.EQH = true;
        int k = this.EQx.getHeaderViewsCount() + this.EQy.getCount();
        List localList = this.EQy.EPu;
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
                if ((localc != null) && (localc.EPY != null) && (b.a(localc.EPY)))
                {
                  i = this.EQx.getFirstVisiblePosition();
                  j = this.EQx.getLastVisiblePosition();
                  Log.i("MicroMsg.MallIndexBaseUI", "get listview show top %s bottom %s redPos: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
                  if ((k >= i) && (k <= j)) {
                    break;
                  }
                  int m = a.eQu();
                  j = a.eQt() + a.eQs() * (k + 1) + m;
                  i = j;
                  if (k > 2) {
                    i = j + m;
                  }
                  j = i;
                  if (k > 3) {
                    j = i + m;
                  }
                  m = a.eQs() / 3;
                  int n = this.EQx.getScrollY();
                  k = ar.au(this).y;
                  i = k;
                  if (ar.av(this)) {
                    i = k - ar.aB(this);
                  }
                  k = i;
                  if (getSupportActionBar() != null) {
                    k = i - getSupportActionBar().getHeight();
                  }
                  this.EQx.smoothScrollBy(j + m - n - k, 1000);
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
  
  private void eQE()
  {
    setResult(0);
    finish();
  }
  
  private void eQI()
  {
    if (z.bdq())
    {
      com.tencent.mm.wallet_core.a.b(getContext(), "PayURemittanceProcess", null);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("pay_channel", 1);
    com.tencent.mm.wallet_core.a.b(getContext(), "RemittanceProcess", localBundle);
  }
  
  private void eQK()
  {
    if (this.EQw != null) {
      this.EQw.setVisibility(8);
    }
  }
  
  private MallFunction fU(List<MallFunction> paramList)
  {
    Object localObject;
    if ((paramList == null) || (paramList.size() == 0) || (TextUtils.isEmpty(this.EOD)))
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
        if (this.EOD.equals(localMallFunction.nBK)) {
          break;
        }
      }
      i += 1;
    }
    label81:
    return null;
  }
  
  private MallFunction fV(List<MallFunction> paramList)
  {
    Object localObject;
    if ((paramList == null) || (paramList.size() == 0) || (TextUtils.isEmpty(this.Eyn)))
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
        if (this.Eyn.equals(localMallFunction.gbn)) {
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
    Object localObject1;
    int i;
    String str;
    if ((paramMallFunction != null) && (paramInt >= 0))
    {
      localObject2 = "";
      localObject1 = localObject2;
      if (paramMallFunction.OUr != null)
      {
        localObject1 = localObject2;
        if (!Util.isNullOrNil(paramMallFunction.OUr.oym)) {
          localObject1 = paramMallFunction.OUr.oym;
        }
      }
      if (this.EOE != null) {
        break label261;
      }
      i = 0;
      boolean bool = b.a(paramMallFunction);
      localObject2 = com.tencent.mm.plugin.report.service.h.IzE;
      str = paramMallFunction.nBK;
      if (!bool) {
        break label272;
      }
    }
    label261:
    label272:
    for (int j = 2;; j = 1)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject2).a(10881, new Object[] { str, Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(paramInt), localObject1, Integer.valueOf(j), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
      if ((paramMallFunction == null) || (Util.isNullOrNil(paramMallFunction.gbn)) || (!((s)com.tencent.mm.kernel.h.ae(s.class)).s(paramMallFunction.gbn, null))) {
        break label278;
      }
      Log.i("MicroMsg.MallIndexBaseUI", "handleFunction, intercept by AppBrandNativeLink, nativeUrl = %s", new Object[] { paramMallFunction.gbn });
      com.tencent.mm.plugin.wallet_core.model.mall.c.gKL().bhe(paramMallFunction.nBK);
      com.tencent.mm.plugin.wallet_core.model.mall.d.gKP().bhe(paramMallFunction.nBK);
      if (paramMallFunction.OUr != null)
      {
        com.tencent.mm.plugin.wallet_core.model.mall.c.gKL();
        com.tencent.mm.plugin.wallet_core.model.mall.c.i(paramMallFunction);
      }
      return;
      i = this.EOE.size();
      break;
    }
    label278:
    paramInt = d.f(paramMallFunction);
    Log.i("MicroMsg.MallIndexBaseUI", "functionType : ".concat(String.valueOf(paramInt)));
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
      com.tencent.mm.by.c.b(this, "recharge", ".ui.PhoneRechargeUI", (Intent)localObject1);
      ab.ny(15, 0);
      return;
    case 4: 
      com.tencent.mm.plugin.report.service.h.IzE.a(11701, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
      paramMallFunction = new Intent();
      paramMallFunction.putExtra("pay_channel", 1);
      com.tencent.mm.by.c.b(this, "luckymoney", ".ui.LuckyMoneyIndexUI", paramMallFunction);
      ab.ny(13, 0);
      com.tencent.mm.plugin.report.service.h.IzE.a(11850, new Object[] { Integer.valueOf(4), Integer.valueOf(0) });
      return;
    case 7: 
      localObject1 = new Intent();
      if (isTransparent()) {
        ((Intent)localObject1).putExtra("key_is_hide_progress", true);
      }
      ((Intent)localObject1).putExtra("key_func_info", paramMallFunction);
      com.tencent.mm.by.c.b(this, "recharge", ".ui.RechargeUI", (Intent)localObject1);
      return;
    case 1: 
      com.tencent.mm.kernel.h.aHH();
      this.EOJ = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VlG, Integer.valueOf(0))).intValue();
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("rawUrl", paramMallFunction.h5Url);
      ((Intent)localObject1).putExtra("geta8key_username", z.bcZ());
      ((Intent)localObject1).putExtra("pay_channel", 1);
      ((Intent)localObject1).putExtra("KPublisherId", "pay_wallet");
      ((Intent)localObject1).putExtra("key_download_restrict", paramMallFunction.OUt);
      ((Intent)localObject1).putExtra("key_wallet_region", this.EOJ);
      ((Intent)localObject1).putExtra("key_function_id", paramMallFunction.nBK);
      ((Intent)localObject1).putExtra(f.r.VSX, true);
      ((Intent)localObject1).putExtra("geta8key_scene", 46);
      g.aJ(getContext(), (Intent)localObject1);
      return;
    case 2: 
      Log.w("MicroMsg.MallIndexBaseUI", "doSelectFunction no jump");
      return;
    case 3: 
      Log.w("MicroMsg.MallIndexBaseUI", "doSelectFunction do nothing");
      com.tencent.mm.ui.base.w.makeText(this, "fuction list error", 1).show();
      return;
    case 5: 
      com.tencent.mm.plugin.report.service.h.IzE.a(11458, new Object[] { Integer.valueOf(1) });
      if (z.bdq())
      {
        paramMallFunction = new LinkedList();
        localObject1 = new LinkedList();
        paramMallFunction.add(getString(a.i.remittance_title));
        ((List)localObject1).add(Integer.valueOf(0));
        paramMallFunction.add(getString(a.i.collect_title));
        ((List)localObject1).add(Integer.valueOf(1));
        com.tencent.mm.ui.base.h.b(this, getString(a.i.remittance_collect_title), paramMallFunction, (List)localObject1, null, new h.e()
        {
          public final void cS(int paramAnonymousInt1, int paramAnonymousInt2)
          {
            AppMethodBeat.i(66066);
            switch (paramAnonymousInt2)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(66066);
              return;
              com.tencent.mm.plugin.report.service.h.IzE.a(11458, new Object[] { Integer.valueOf(2) });
              if (z.bdq())
              {
                com.tencent.mm.wallet_core.a.b(MallIndexBaseUI.this.getContext(), "PayURemittanceProcess", null);
                AppMethodBeat.o(66066);
                return;
              }
              com.tencent.mm.wallet_core.a.b(MallIndexBaseUI.this.getContext(), "RemittanceProcess", null);
              AppMethodBeat.o(66066);
              return;
              com.tencent.mm.plugin.report.service.h.IzE.a(11458, new Object[] { Integer.valueOf(3) });
              com.tencent.mm.pluginsdk.wallet.f.aV(MallIndexBaseUI.this, 2);
            }
          }
        });
      }
      for (;;)
      {
        ab.ny(14, 0);
        com.tencent.mm.plugin.report.service.h.IzE.a(11850, new Object[] { Integer.valueOf(3), Integer.valueOf(0) });
        return;
        com.tencent.mm.kernel.h.aHH();
        if (!((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VhE, Boolean.FALSE)).booleanValue())
        {
          com.tencent.mm.kernel.h.aHH();
          com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VhE, Boolean.TRUE);
          com.tencent.mm.ui.base.h.d(this, getString(a.i.wallet_index_ui_ftf_notice), "", new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(66067);
              MallIndexBaseUI.a(MallIndexBaseUI.this);
              AppMethodBeat.o(66067);
            }
          });
        }
        else
        {
          eQI();
        }
      }
    case 6: 
      paramMallFunction = new Intent();
      paramMallFunction.putExtra("key_from_scene", 1);
      com.tencent.mm.by.c.b(getContext(), "offline", ".ui.WalletOfflineEntranceUI", paramMallFunction);
      ab.ny(9, 0);
      com.tencent.mm.plugin.report.service.h.IzE.a(11850, new Object[] { Integer.valueOf(5), Integer.valueOf(0) });
      return;
    case 8: 
      paramMallFunction = new Intent();
      paramMallFunction.putExtra("BaseScanUI_select_scan_mode", 1);
      com.tencent.mm.by.c.b(getContext(), "scanner", ".ui.BaseScanUI", paramMallFunction);
      return;
    }
    com.tencent.mm.by.c.ad(getContext(), "luckymoney", ".f2f.ui.LuckyMoneyF2FQRCodeUI");
  }
  
  public boolean checkProcLife()
  {
    return false;
  }
  
  protected abstract void eHM();
  
  protected abstract void eQA();
  
  protected abstract boolean eQB();
  
  protected abstract void eQC();
  
  protected abstract void eQF();
  
  protected abstract void eQG();
  
  protected abstract void eQH();
  
  protected abstract void eQJ();
  
  protected abstract void eQL();
  
  protected abstract void eQy();
  
  protected abstract void eQz();
  
  public void finish()
  {
    super.finish();
  }
  
  protected abstract void fo(View paramView);
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return a.g.mall_index_ui;
  }
  
  public final void i(int paramInt, Object[] paramArrayOfObject)
  {
    if ((paramInt == 12) && (this.EQB != null)) {
      eQH();
    }
  }
  
  protected abstract void initHeaderView();
  
  public void initView()
  {
    Log.d("MicroMsg.MallIndexBaseUI", "index initView");
    setBackBtn(new MallIndexBaseUI.1(this));
    this.EQx = ((ListView)findViewById(a.f.mall_index_function_list));
    initHeaderView();
    eQF();
    this.EQy = new b(this, this.EOJ);
    this.EQx.setAdapter(this.EQy);
    this.EQy.EPv = new b.d()
    {
      public final void a(final int paramAnonymousInt, final MallFunction paramAnonymousMallFunction)
      {
        AppMethodBeat.i(66065);
        if (paramAnonymousMallFunction != null)
        {
          int i;
          Object localObject2;
          Object localObject1;
          Object localObject3;
          if ((!com.tencent.mm.plugin.wallet_core.model.mall.b.a.bhb(paramAnonymousMallFunction.nBK)) && (!Util.isNullOrNil(paramAnonymousMallFunction.OUs)))
          {
            i = 1;
            if (i == 0) {
              break label635;
            }
            Log.i("MicroMsg.MallIndexBaseUI", "onFunctionItemClick show disclaimer funcId=%s", new Object[] { paramAnonymousMallFunction.nBK });
            String str1 = MallIndexBaseUI.this.getString(a.i.mall_third_party_disclaimer_title);
            String str2 = MallIndexBaseUI.this.getString(a.i.app_i_know);
            localObject2 = new WeAppOpenDeclarePromptBundle((byte)0);
            ((WeAppOpenDeclarePromptBundle)localObject2).hDp = 2;
            ((WeAppOpenDeclarePromptBundle)localObject2).nBL = str1;
            ((WeAppOpenDeclarePromptBundle)localObject2).nBM = paramAnonymousMallFunction.OUs;
            ((WeAppOpenDeclarePromptBundle)localObject2).nBN = str2;
            ((WeAppOpenDeclarePromptBundle)localObject2).bxO = false;
            ((WeAppOpenDeclarePromptBundle)localObject2).nBK = paramAnonymousMallFunction.nBK;
            localObject1 = new Bundle();
            ((Bundle)localObject1).putParcelable("weapp_open_declare_prompt_key", (Parcelable)localObject2);
            localObject3 = MallIndexBaseUI.this;
            if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vFd, 1) != 1) {
              break label352;
            }
            i = 1;
            label178:
            if (i != 0) {
              break label357;
            }
            Log.i("MicroMsg.MallIndexBaseUI", "handleFunctionByAppBrand clicfg_appbrand_dialog_optimize_switch close");
            label189:
            i = 0;
            if (i == 0)
            {
              localObject1 = new d.a(MallIndexBaseUI.this.getContext());
              ((d.a)localObject1).bBc(str1);
              ((d.a)localObject1).bBd(paramAnonymousMallFunction.OUs);
              ((d.a)localObject1).bBj(str2).c(new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(66064);
                  Log.i("MicroMsg.MallIndexBaseUI", "onFunctionItemClick: onClick");
                  com.tencent.mm.plugin.wallet_core.model.mall.b.a.bha(paramAnonymousMallFunction.nBK);
                  MallIndexBaseUI.this.a(paramAnonymousMallFunction, paramAnonymousInt);
                  AppMethodBeat.o(66064);
                }
              });
              ((d.a)localObject1).HG(true);
              ((d.a)localObject1).f(new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(186632);
                  Log.i("MicroMsg.MallIndexBaseUI", "onFunctionItemClick: onCancel");
                  com.tencent.mm.plugin.wallet_core.model.mall.b.a.bha(paramAnonymousMallFunction.nBK);
                  AppMethodBeat.o(186632);
                }
              });
              ((d.a)localObject1).icu().show();
            }
          }
          for (;;)
          {
            Log.d("MicroMsg.MallIndexBaseUI", "type: %s", new Object[] { Integer.valueOf(paramAnonymousMallFunction.type) });
            com.tencent.mm.plugin.report.service.h.IzE.a(14419, new Object[] { MallIndexBaseUI.this.uuid, Integer.valueOf(4), Integer.valueOf(paramAnonymousMallFunction.type) });
            AppMethodBeat.o(66065);
            return;
            i = 0;
            break;
            label352:
            i = 0;
            break label178;
            label357:
            if ((paramAnonymousMallFunction == null) || (Util.isNullOrNil(paramAnonymousMallFunction.gbn)) || (!((s)com.tencent.mm.kernel.h.ae(s.class)).s(paramAnonymousMallFunction.gbn, (Bundle)localObject1))) {
              break label189;
            }
            Log.i("MicroMsg.MallIndexBaseUI", "handleFunctionByAppBrand, intercept by AppBrandNativeLink, nativeUrl = %s", new Object[] { paramAnonymousMallFunction.gbn });
            com.tencent.mm.plugin.wallet_core.model.mall.c.gKL().bhe(paramAnonymousMallFunction.nBK);
            com.tencent.mm.plugin.wallet_core.model.mall.d.gKP().bhe(paramAnonymousMallFunction.nBK);
            if (paramAnonymousMallFunction.OUr != null)
            {
              com.tencent.mm.plugin.wallet_core.model.mall.c.gKL();
              com.tencent.mm.plugin.wallet_core.model.mall.c.i(paramAnonymousMallFunction);
            }
            if (paramAnonymousInt >= 0)
            {
              localObject2 = "";
              localObject1 = localObject2;
              if (paramAnonymousMallFunction.OUr != null)
              {
                localObject1 = localObject2;
                if (!Util.isNullOrNil(paramAnonymousMallFunction.OUr.oym)) {
                  localObject1 = paramAnonymousMallFunction.OUr.oym;
                }
              }
              if (((MallIndexBaseUI)localObject3).EOE != null) {
                break label617;
              }
              i = 0;
              label503:
              boolean bool = b.a(paramAnonymousMallFunction);
              localObject2 = com.tencent.mm.plugin.report.service.h.IzE;
              localObject3 = paramAnonymousMallFunction.nBK;
              if (!bool) {
                break label629;
              }
            }
            label617:
            label629:
            for (int j = 2;; j = 1)
            {
              ((com.tencent.mm.plugin.report.service.h)localObject2).a(10881, new Object[] { localObject3, Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(paramAnonymousInt), localObject1, Integer.valueOf(j), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
              i = 1;
              break;
              i = ((MallIndexBaseUI)localObject3).EOE.size();
              break label503;
            }
            label635:
            MallIndexBaseUI.this.a(paramAnonymousMallFunction, paramAnonymousInt);
          }
        }
        Log.w("MicroMsg.MallIndexBaseUI", "onFunctionItemClick functionItem null; pos=%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(66065);
      }
    };
    fo(this.zRq);
    this.EQC = ((TextView)findViewById(a.f.banner_tips));
    eQG();
  }
  
  public boolean isTransparent()
  {
    return (!Util.isNullOrNil(this.EOD)) || (!Util.isNullOrNil(this.Eyn));
  }
  
  public final void k(String paramString, Bitmap paramBitmap) {}
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1)
    {
      com.tencent.mm.kernel.h.aHH();
      this.EOJ = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VlG, Integer.valueOf(0))).intValue();
      if (paramInt2 == -1)
      {
        if (!z.bdr()) {
          break label51;
        }
        finish();
      }
    }
    return;
    label51:
    finish();
    paramIntent = new te();
    paramIntent.fSz.context = getContext();
    EventCenter.instance.publish(paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Log.i("MicroMsg.MallIndexBaseUI", "onCreate");
    super.onCreate(paramBundle);
    if (!com.tencent.mm.kernel.h.aHB())
    {
      Log.v("MicroMsg.MallIndexBaseUI", "MMCore is not ready");
      finish();
    }
    com.tencent.mm.kernel.h.aHH();
    int i = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VlG, Integer.valueOf(0))).intValue();
    this.EOJ = getIntent().getIntExtra("key_wallet_region", i);
    this.uuid = getIntent().getStringExtra("key_uuid");
    if (Util.isNullOrNil(this.uuid)) {
      this.uuid = UUID.randomUUID().toString();
    }
    addSceneEndListener(495);
    u.gJv();
    ai.a(this);
    this.EOD = getIntent().getStringExtra("key_func_id");
    Log.i("MicroMsg.MallIndexBaseUI", "mFuncId:" + this.EOD + " wallet_region: " + this.EOJ + " walletType: " + z.bdg() + " default_region: " + i);
    this.Eyn = getIntent().getStringExtra("key_native_url");
    Log.i("MicroMsg.MallIndexBaseUI", "mNativeUrl:" + this.Eyn);
    if (isTransparent()) {
      return;
    }
    eHM();
    setContentViewVisibility(0);
    Log.i("MicroMsg.MallIndexBaseUI", "index Oncreate");
    eQy();
    initView();
    com.tencent.mm.plugin.wallet_core.model.mall.c.gKO();
    eQz();
    Log.i("MicroMsg.MallIndexBaseUI", "hy: use default controller for MallIndexUI");
    eQA();
    if (z.bdq()) {
      Log.e("MicroMsg.MallIndexBaseUI", "it is payu account ,not initFingerPrint");
    }
    for (;;)
    {
      ab.ny(1, 0);
      com.tencent.mm.plugin.report.service.h.IzE.a(11850, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
      return;
      paramBundle = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.fingerprint.d.a.class);
      if (paramBundle != null)
      {
        Log.i("MicroMsg.MallIndexBaseUI", "IFingerPrintMgr is not null, do showFingerPrintEntrance()");
        paramBundle.eom();
      }
      else
      {
        Log.e("MicroMsg.MallIndexBaseUI", "IFingerPrintMgr is not null");
      }
    }
  }
  
  public void onDestroy()
  {
    removeSceneEndListener(495);
    u.gJv();
    ai.b(this);
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
    com.tencent.mm.pluginsdk.wallet.h.setPayChannel(1);
    Log.i("MicroMsg.MallIndexBaseUI", "index onResume");
    if (!com.tencent.mm.kernel.h.aHB())
    {
      Log.v("MicroMsg.MallIndexBaseUI", "MMCore is not ready");
      finish();
    }
    if (isTransparent())
    {
      this.EOE = com.tencent.mm.plugin.mall.a.k.eQr().Wq(this.EOJ);
      if ((this.EOE == null) || (this.EOE.size() <= 0))
      {
        Log.i("MicroMsg.MallIndexBaseUI", "mFunctionList == null");
        try
        {
          if ((getIntent().getIntExtra("key_scene", 0) == 1) || (!Util.isNullOrNil(this.Eyn)))
          {
            doSceneForceProgress(new com.tencent.mm.plugin.mall.a.f(this.EOJ, com.tencent.mm.plugin.wallet_core.model.mall.b.gKD(), 0));
            return;
          }
          localObject3 = getIntent().getStringExtra("key_url");
          Object localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = "";
          }
          doSceneForceProgress(new com.tencent.mm.plugin.mall.a.f(this.EOJ, com.tencent.mm.plugin.wallet_core.model.mall.b.gKD(), getIntent().getStringExtra("key_app_id"), this.EOD, (String)localObject1));
          return;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          Log.printErrStackTrace("MicroMsg.MallIndexBaseUI", localUnsupportedEncodingException, "", new Object[0]);
          eQE();
          return;
        }
      }
      Object localObject3 = fU(this.EOE);
      Object localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = fV(this.EOE);
      }
      a((MallFunction)localObject2, -1);
      finish();
      return;
    }
    eQB();
    Log.d("MicroMsg.MallIndexBaseUI", "initFunctionList");
    if (com.tencent.mm.plugin.mall.a.k.eQr().Wq(this.EOJ) == null)
    {
      doSceneProgress(new com.tencent.mm.plugin.mall.a.f(this.EOJ, com.tencent.mm.plugin.wallet_core.model.mall.b.gKD(), 0), true);
      Log.e("MicroMsg.MallIndexBaseUI", "funcitonlist invalid");
      i = 0;
    }
    while (i != 0)
    {
      Log.i("MicroMsg.MallIndexBaseUI", "has data");
      updateView();
      return;
      doSceneProgress(new com.tencent.mm.plugin.mall.a.f(this.EOJ, com.tencent.mm.plugin.wallet_core.model.mall.b.gKD(), 1), false);
      this.EOE = com.tencent.mm.plugin.mall.a.k.eQr().Wq(this.EOJ);
    }
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    Log.d("MicroMsg.MallIndexBaseUI", "onOtherSceneEnd");
    if ((paramq instanceof com.tencent.mm.plugin.wallet_core.c.b.a))
    {
      Log.d("MicroMsg.MallIndexBaseUI", "hy: query bound scene end");
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (this.EQE)
        {
          this.EQE = false;
          if (u.gJj().gKZ().gJS())
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
    switch (paramq.getType())
    {
    default: 
      return false;
    }
    paramString = (com.tencent.mm.plugin.mall.a.f)paramq;
    if (paramString.EOJ != this.EOJ) {
      Log.i("MicroMsg.MallIndexBaseUI", "pass wallet local: %d cgi: %d", new Object[] { Integer.valueOf(this.EOJ), Integer.valueOf(paramString.EOJ) });
    }
    if (isTransparent())
    {
      Log.d("MicroMsg.MallIndexBaseUI", "errorType:%d | errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if ((paramInt1 == 0) && (paramInt2 == 0) && (paramString.EOE != null)) {
        if (getIntent().getIntExtra("key_scene", 0) == 1)
        {
          paramString = fU(paramString.EOE);
          if (paramString != null) {
            a(paramString, -1);
          }
          setResult(-1);
          finish();
        }
      }
    }
    for (;;)
    {
      return true;
      if (!Util.isNullOrNil(this.Eyn))
      {
        Log.d("MicroMsg.MallIndexBaseUI", "NativeUrl: %s", new Object[] { this.Eyn });
        paramString = fV(paramString.EOE);
        if (paramString != null)
        {
          a(paramString, -1);
          break;
        }
        eQE();
        return true;
      }
      if ((paramString.EOE != null) && (paramString.EOE.size() > 0))
      {
        Log.i("MicroMsg.MallIndexBaseUI", "functionScene.mFunctionList != null");
        a(fU(paramString.EOE), -1);
        break;
      }
      if ((com.tencent.mm.plugin.mall.a.k.eQr().Wq(this.EOJ) != null) && (com.tencent.mm.plugin.mall.a.k.eQr().Wq(this.EOJ).size() > 0))
      {
        Log.i("MicroMsg.MallIndexBaseUI", "SubCoreMall.getCore().getFunctionList() != null");
        a(fU(com.tencent.mm.plugin.mall.a.k.eQr().Wq(this.EOJ)), -1);
        break;
      }
      Log.e("MicroMsg.MallIndexBaseUI", "SubCoreMall.getCore().getFunctionList() == null");
      break;
      eQE();
      continue;
      if ((paramInt1 == 0) && (paramInt2 == 0) && (com.tencent.mm.plugin.mall.a.k.eQr().Wq(this.EOJ) != null) && (paramString.EOE != null))
      {
        this.EOE = com.tencent.mm.plugin.mall.a.k.eQr().Wq(this.EOJ);
        Log.i("MicroMsg.MallIndexBaseUI", "get from server now! " + this.EOJ + " " + this.EOE.size());
        com.tencent.mm.plugin.wallet_core.model.mall.c.gKL().bk(this.EOE);
        if (!Util.isNullOrNil(this.EOE))
        {
          paramString = new LinkedList();
          paramq = this.EOE.iterator();
          while (paramq.hasNext())
          {
            MallFunction localMallFunction = (MallFunction)paramq.next();
            if (!Util.isNullOrNil(localMallFunction.gbn)) {
              paramString.add(localMallFunction.gbn);
            }
          }
          if (!Util.isNullOrNil(paramString))
          {
            paramq = (com.tencent.mm.plugin.appbrand.service.w)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.w.class);
            if (paramq != null) {
              paramq.be(paramString);
            }
          }
        }
      }
      updateView();
      eQD();
      eQF();
    }
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
    this.EQy.aE(this.EOE);
    eQJ();
    eQK();
    eQL();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexBaseUI
 * JD-Core Version:    0.7.0.1
 */