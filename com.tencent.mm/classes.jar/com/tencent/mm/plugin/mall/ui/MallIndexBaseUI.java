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
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.sd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.appbrand.api.WeAppOpenDeclarePromptBundle;
import com.tencent.mm.plugin.appbrand.service.s;
import com.tencent.mm.plugin.appbrand.service.w;
import com.tencent.mm.plugin.wallet_core.model.ah;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.l;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.h.e;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.e.p;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
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
  private static final String zlf = "https://" + WeChatHosts.domainString(2131761715) + "/touch/scene_product.html?scene_id=kf1";
  protected String uuid;
  protected View vbj;
  private String yUq = null;
  private String zjn = null;
  ArrayList<MallFunction> zjo = null;
  protected int zjs;
  private TextView zlg = null;
  protected ListView zlh = null;
  private b zli = null;
  protected ImageView zlj = null;
  protected ImageView zlk;
  protected TextView zll = null;
  protected TextView zlm;
  private int zln = 0;
  private boolean zlo = true;
  protected int zlp;
  protected View zlq;
  private boolean zlr = false;
  
  private void egX()
  {
    boolean bool = getIntent().getBooleanExtra("key_wallet_has_red", false);
    if (this.zlh.getChildCount() == 0) {}
    label404:
    for (;;)
    {
      return;
      int i = this.zlh.getFirstVisiblePosition();
      int j = this.zlh.getChildAt(0).getTop();
      Log.i("MicroMsg.MallIndexBaseUI", "initCheckNew %s fpos %s top %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j) });
      if ((i == 0) && (j == 0) && (bool) && (!this.zlr) && (this.zjo != null))
      {
        this.zlr = true;
        int k = this.zlh.getHeaderViewsCount() + this.zli.getCount();
        List localList = this.zli.zke;
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
                if ((localc != null) && (localc.zkI != null) && (b.a(localc.zkI)))
                {
                  i = this.zlh.getFirstVisiblePosition();
                  j = this.zlh.getLastVisiblePosition();
                  Log.i("MicroMsg.MallIndexBaseUI", "get listview show top %s bottom %s redPos: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
                  if ((k >= i) && (k <= j)) {
                    break;
                  }
                  int m = a.egO();
                  j = a.egN() + a.egM() * (k + 1) + m;
                  i = j;
                  if (k > 2) {
                    i = j + m;
                  }
                  j = i;
                  if (k > 3) {
                    j = i + m;
                  }
                  m = a.egM() / 3;
                  int n = this.zlh.getScrollY();
                  k = com.tencent.mm.ui.ao.az(this).y;
                  i = k;
                  if (com.tencent.mm.ui.ao.aA(this)) {
                    i = k - com.tencent.mm.ui.ao.aD(this);
                  }
                  k = i;
                  if (getSupportActionBar() != null) {
                    k = i - getSupportActionBar().getHeight();
                  }
                  this.zlh.smoothScrollBy(j + m - n - k, 1000);
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
  
  private void egY()
  {
    setResult(0);
    finish();
  }
  
  private void ehc()
  {
    if (z.aUo())
    {
      com.tencent.mm.wallet_core.a.b(getContext(), "PayURemittanceProcess", null);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("pay_channel", 1);
    com.tencent.mm.wallet_core.a.b(getContext(), "RemittanceProcess", localBundle);
  }
  
  private void ehe()
  {
    if (this.zlg != null) {
      this.zlg.setVisibility(8);
    }
  }
  
  private MallFunction fs(List<MallFunction> paramList)
  {
    Object localObject;
    if ((paramList == null) || (paramList.size() == 0) || (TextUtils.isEmpty(this.zjn)))
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
        if (this.zjn.equals(localMallFunction.kHR)) {
          break;
        }
      }
      i += 1;
    }
    label81:
    return null;
  }
  
  private MallFunction ft(List<MallFunction> paramList)
  {
    Object localObject;
    if ((paramList == null) || (paramList.size() == 0) || (TextUtils.isEmpty(this.yUq)))
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
        if (this.yUq.equals(localMallFunction.egX)) {
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
      if (paramMallFunction.Icf != null)
      {
        localObject1 = localObject2;
        if (!Util.isNullOrNil(paramMallFunction.Icf.FJm)) {
          localObject1 = paramMallFunction.Icf.FJm;
        }
      }
      if (this.zjo != null) {
        break label261;
      }
      i = 0;
      boolean bool = b.a(paramMallFunction);
      localObject2 = com.tencent.mm.plugin.report.service.h.CyF;
      str = paramMallFunction.kHR;
      if (!bool) {
        break label272;
      }
    }
    label261:
    label272:
    for (int j = 2;; j = 1)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject2).a(10881, new Object[] { str, Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(paramInt), localObject1, Integer.valueOf(j), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
      if ((paramMallFunction == null) || (Util.isNullOrNil(paramMallFunction.egX)) || (!((s)g.af(s.class)).n(paramMallFunction.egX, null))) {
        break label278;
      }
      Log.i("MicroMsg.MallIndexBaseUI", "handleFunction, intercept by AppBrandNativeLink, nativeUrl = %s", new Object[] { paramMallFunction.egX });
      com.tencent.mm.plugin.wallet_core.model.mall.c.fSg().aVv(paramMallFunction.kHR);
      com.tencent.mm.plugin.wallet_core.model.mall.d.fSk().aVv(paramMallFunction.kHR);
      if (paramMallFunction.Icf != null)
      {
        com.tencent.mm.plugin.wallet_core.model.mall.c.fSg();
        com.tencent.mm.plugin.wallet_core.model.mall.c.i(paramMallFunction);
      }
      return;
      i = this.zjo.size();
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
      com.tencent.mm.br.c.b(this, "recharge", ".ui.PhoneRechargeUI", (Intent)localObject1);
      ab.mg(15, 0);
      return;
    case 4: 
      com.tencent.mm.plugin.report.service.h.CyF.a(11701, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
      paramMallFunction = new Intent();
      paramMallFunction.putExtra("pay_channel", 1);
      com.tencent.mm.br.c.b(this, "luckymoney", ".ui.LuckyMoneyIndexUI", paramMallFunction);
      ab.mg(13, 0);
      com.tencent.mm.plugin.report.service.h.CyF.a(11850, new Object[] { Integer.valueOf(4), Integer.valueOf(0) });
      return;
    case 7: 
      localObject1 = new Intent();
      if (isTransparent()) {
        ((Intent)localObject1).putExtra("key_is_hide_progress", true);
      }
      ((Intent)localObject1).putExtra("key_func_info", paramMallFunction);
      com.tencent.mm.br.c.b(this, "recharge", ".ui.RechargeUI", (Intent)localObject1);
      return;
    case 1: 
      g.aAi();
      this.zjs = ((Integer)g.aAh().azQ().get(ar.a.NXG, Integer.valueOf(0))).intValue();
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("rawUrl", paramMallFunction.h5Url);
      ((Intent)localObject1).putExtra("geta8key_username", z.aTY());
      ((Intent)localObject1).putExtra("pay_channel", 1);
      ((Intent)localObject1).putExtra("KPublisherId", "pay_wallet");
      ((Intent)localObject1).putExtra("key_download_restrict", paramMallFunction.Ich);
      ((Intent)localObject1).putExtra("key_wallet_region", this.zjs);
      ((Intent)localObject1).putExtra("key_function_id", paramMallFunction.kHR);
      ((Intent)localObject1).putExtra(e.p.OzJ, true);
      ((Intent)localObject1).putExtra("geta8key_scene", 46);
      com.tencent.mm.wallet_core.ui.f.aA(getContext(), (Intent)localObject1);
      return;
    case 2: 
      Log.w("MicroMsg.MallIndexBaseUI", "doSelectFunction no jump");
      return;
    case 3: 
      Log.w("MicroMsg.MallIndexBaseUI", "doSelectFunction do nothing");
      u.makeText(this, "fuction list error", 1).show();
      return;
    case 5: 
      com.tencent.mm.plugin.report.service.h.CyF.a(11458, new Object[] { Integer.valueOf(1) });
      if (z.aUo())
      {
        paramMallFunction = new LinkedList();
        localObject1 = new LinkedList();
        paramMallFunction.add(getString(2131764602));
        ((List)localObject1).add(Integer.valueOf(0));
        paramMallFunction.add(getString(2131757716));
        ((List)localObject1).add(Integer.valueOf(1));
        com.tencent.mm.ui.base.h.b(this, getString(2131764508), paramMallFunction, (List)localObject1, null, new h.e()
        {
          public final void cy(int paramAnonymousInt1, int paramAnonymousInt2)
          {
            AppMethodBeat.i(66066);
            switch (paramAnonymousInt2)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(66066);
              return;
              com.tencent.mm.plugin.report.service.h.CyF.a(11458, new Object[] { Integer.valueOf(2) });
              if (z.aUo())
              {
                com.tencent.mm.wallet_core.a.b(MallIndexBaseUI.this.getContext(), "PayURemittanceProcess", null);
                AppMethodBeat.o(66066);
                return;
              }
              com.tencent.mm.wallet_core.a.b(MallIndexBaseUI.this.getContext(), "RemittanceProcess", null);
              AppMethodBeat.o(66066);
              return;
              com.tencent.mm.plugin.report.service.h.CyF.a(11458, new Object[] { Integer.valueOf(3) });
              com.tencent.mm.pluginsdk.wallet.f.aD(MallIndexBaseUI.this, 2);
            }
          }
        });
      }
      for (;;)
      {
        ab.mg(14, 0);
        com.tencent.mm.plugin.report.service.h.CyF.a(11850, new Object[] { Integer.valueOf(3), Integer.valueOf(0) });
        return;
        g.aAi();
        if (!((Boolean)g.aAh().azQ().get(ar.a.NTE, Boolean.FALSE)).booleanValue())
        {
          g.aAi();
          g.aAh().azQ().set(ar.a.NTE, Boolean.TRUE);
          com.tencent.mm.ui.base.h.d(this, getString(2131767750), "", new DialogInterface.OnClickListener()
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
          ehc();
        }
      }
    case 6: 
      paramMallFunction = new Intent();
      paramMallFunction.putExtra("key_from_scene", 1);
      com.tencent.mm.br.c.b(getContext(), "offline", ".ui.WalletOfflineEntranceUI", paramMallFunction);
      ab.mg(9, 0);
      com.tencent.mm.plugin.report.service.h.CyF.a(11850, new Object[] { Integer.valueOf(5), Integer.valueOf(0) });
      return;
    case 8: 
      paramMallFunction = new Intent();
      paramMallFunction.putExtra("BaseScanUI_select_scan_mode", 1);
      com.tencent.mm.br.c.b(getContext(), "scanner", ".ui.BaseScanUI", paramMallFunction);
      return;
    }
    com.tencent.mm.br.c.V(getContext(), "luckymoney", ".f2f.ui.LuckyMoneyF2FQRCodeUI");
  }
  
  public boolean checkProcLife()
  {
    return false;
  }
  
  protected abstract void dYP();
  
  protected abstract void egS();
  
  protected abstract void egT();
  
  protected abstract void egU();
  
  protected abstract boolean egV();
  
  protected abstract void egW();
  
  protected abstract void egZ();
  
  protected abstract void eha();
  
  protected abstract void ehb();
  
  protected abstract void ehd();
  
  protected abstract void ehf();
  
  protected abstract void eq(View paramView);
  
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
    return 2131495430;
  }
  
  protected abstract void initHeaderView();
  
  public void initView()
  {
    Log.d("MicroMsg.MallIndexBaseUI", "index initView");
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(66063);
        paramAnonymousMenuItem = new Intent();
        paramAnonymousMenuItem.addFlags(67108864);
        paramAnonymousMenuItem.putExtra("preferred_tab", 3);
        com.tencent.mm.br.c.f(MallIndexBaseUI.this, "com.tencent.mm.ui.LauncherUI", paramAnonymousMenuItem);
        MallIndexBaseUI.this.finish();
        if (!com.tencent.mm.pluginsdk.wallet.e.gsQ())
        {
          com.tencent.mm.plugin.report.service.h.CyF.a(14954, new Object[] { com.tencent.mm.pluginsdk.wallet.e.gsR(), "open_wcpay_specific_view:ok" });
          com.tencent.mm.pluginsdk.wallet.e.gsS();
        }
        com.tencent.mm.plugin.report.service.h.CyF.a(14419, new Object[] { MallIndexBaseUI.this.uuid, Integer.valueOf(6) });
        Log.i("MicroMsg.MallIndexBaseUI", "set BackBtn");
        AppMethodBeat.o(66063);
        return true;
      }
    });
    this.zlh = ((ListView)findViewById(2131304357));
    initHeaderView();
    egZ();
    this.zli = new b(this, this.zjs);
    this.zlh.setAdapter(this.zli);
    this.zli.zkf = new b.d()
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
          if ((!com.tencent.mm.plugin.wallet_core.model.mall.b.a.aVs(paramAnonymousMallFunction.kHR)) && (!Util.isNullOrNil(paramAnonymousMallFunction.Icg)))
          {
            i = 1;
            if (i == 0) {
              break label633;
            }
            Log.i("MicroMsg.MallIndexBaseUI", "onFunctionItemClick show disclaimer funcId=%s", new Object[] { paramAnonymousMallFunction.kHR });
            String str1 = MallIndexBaseUI.this.getString(2131762954);
            String str2 = MallIndexBaseUI.this.getString(2131755873);
            localObject2 = new WeAppOpenDeclarePromptBundle((byte)0);
            ((WeAppOpenDeclarePromptBundle)localObject2).fuQ = 2;
            ((WeAppOpenDeclarePromptBundle)localObject2).kHS = str1;
            ((WeAppOpenDeclarePromptBundle)localObject2).kHT = paramAnonymousMallFunction.Icg;
            ((WeAppOpenDeclarePromptBundle)localObject2).kHU = str2;
            ((WeAppOpenDeclarePromptBundle)localObject2).ox = false;
            ((WeAppOpenDeclarePromptBundle)localObject2).kHR = paramAnonymousMallFunction.kHR;
            localObject1 = new Bundle();
            ((Bundle)localObject1).putParcelable("weapp_open_declare_prompt_key", (Parcelable)localObject2);
            localObject3 = MallIndexBaseUI.this;
            if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.rYk, 1) != 1) {
              break label350;
            }
            i = 1;
            label176:
            if (i != 0) {
              break label355;
            }
            Log.i("MicroMsg.MallIndexBaseUI", "handleFunctionByAppBrand clicfg_appbrand_dialog_optimize_switch close");
            label187:
            i = 0;
            if (i == 0)
            {
              localObject1 = new d.a(MallIndexBaseUI.this.getContext());
              ((d.a)localObject1).bon(str1);
              ((d.a)localObject1).boo(paramAnonymousMallFunction.Icg);
              ((d.a)localObject1).bou(str2).c(new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(66064);
                  Log.i("MicroMsg.MallIndexBaseUI", "onFunctionItemClick: onClick");
                  com.tencent.mm.plugin.wallet_core.model.mall.b.a.aVr(paramAnonymousMallFunction.kHR);
                  MallIndexBaseUI.this.a(paramAnonymousMallFunction, paramAnonymousInt);
                  AppMethodBeat.o(66064);
                }
              });
              ((d.a)localObject1).Dk(true);
              ((d.a)localObject1).f(new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(213553);
                  Log.i("MicroMsg.MallIndexBaseUI", "onFunctionItemClick: onCancel");
                  com.tencent.mm.plugin.wallet_core.model.mall.b.a.aVr(paramAnonymousMallFunction.kHR);
                  AppMethodBeat.o(213553);
                }
              });
              ((d.a)localObject1).hbn().show();
            }
          }
          for (;;)
          {
            Log.d("MicroMsg.MallIndexBaseUI", "type: %s", new Object[] { Integer.valueOf(paramAnonymousMallFunction.type) });
            com.tencent.mm.plugin.report.service.h.CyF.a(14419, new Object[] { MallIndexBaseUI.this.uuid, Integer.valueOf(4), Integer.valueOf(paramAnonymousMallFunction.type) });
            AppMethodBeat.o(66065);
            return;
            i = 0;
            break;
            label350:
            i = 0;
            break label176;
            label355:
            if ((paramAnonymousMallFunction == null) || (Util.isNullOrNil(paramAnonymousMallFunction.egX)) || (!((s)g.af(s.class)).n(paramAnonymousMallFunction.egX, (Bundle)localObject1))) {
              break label187;
            }
            Log.i("MicroMsg.MallIndexBaseUI", "handleFunctionByAppBrand, intercept by AppBrandNativeLink, nativeUrl = %s", new Object[] { paramAnonymousMallFunction.egX });
            com.tencent.mm.plugin.wallet_core.model.mall.c.fSg().aVv(paramAnonymousMallFunction.kHR);
            com.tencent.mm.plugin.wallet_core.model.mall.d.fSk().aVv(paramAnonymousMallFunction.kHR);
            if (paramAnonymousMallFunction.Icf != null)
            {
              com.tencent.mm.plugin.wallet_core.model.mall.c.fSg();
              com.tencent.mm.plugin.wallet_core.model.mall.c.i(paramAnonymousMallFunction);
            }
            if (paramAnonymousInt >= 0)
            {
              localObject2 = "";
              localObject1 = localObject2;
              if (paramAnonymousMallFunction.Icf != null)
              {
                localObject1 = localObject2;
                if (!Util.isNullOrNil(paramAnonymousMallFunction.Icf.FJm)) {
                  localObject1 = paramAnonymousMallFunction.Icf.FJm;
                }
              }
              if (((MallIndexBaseUI)localObject3).zjo != null) {
                break label615;
              }
              i = 0;
              label501:
              boolean bool = b.a(paramAnonymousMallFunction);
              localObject2 = com.tencent.mm.plugin.report.service.h.CyF;
              localObject3 = paramAnonymousMallFunction.kHR;
              if (!bool) {
                break label627;
              }
            }
            label615:
            label627:
            for (int j = 2;; j = 1)
            {
              ((com.tencent.mm.plugin.report.service.h)localObject2).a(10881, new Object[] { localObject3, Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(paramAnonymousInt), localObject1, Integer.valueOf(j), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
              i = 1;
              break;
              i = ((MallIndexBaseUI)localObject3).zjo.size();
              break label501;
            }
            label633:
            MallIndexBaseUI.this.a(paramAnonymousMallFunction, paramAnonymousInt);
          }
        }
        Log.w("MicroMsg.MallIndexBaseUI", "onFunctionItemClick functionItem null; pos=%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(66065);
      }
    };
    eq(this.vbj);
    this.zlm = ((TextView)findViewById(2131297330));
    eha();
  }
  
  public boolean isTransparent()
  {
    return (!Util.isNullOrNil(this.zjn)) || (!Util.isNullOrNil(this.yUq));
  }
  
  public final void j(int paramInt, Object[] paramArrayOfObject)
  {
    if ((paramInt == 12) && (this.zll != null)) {
      ehb();
    }
  }
  
  public final void k(String paramString, Bitmap paramBitmap) {}
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1)
    {
      g.aAi();
      this.zjs = ((Integer)g.aAh().azQ().get(ar.a.NXG, Integer.valueOf(0))).intValue();
      if (paramInt2 == -1)
      {
        if (!z.aUp()) {
          break label51;
        }
        finish();
      }
    }
    return;
    label51:
    finish();
    paramIntent = new sd();
    paramIntent.dYH.context = getContext();
    EventCenter.instance.publish(paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Log.i("MicroMsg.MallIndexBaseUI", "onCreate");
    super.onCreate(paramBundle);
    if (!g.aAc())
    {
      Log.v("MicroMsg.MallIndexBaseUI", "MMCore is not ready");
      finish();
    }
    g.aAi();
    int i = ((Integer)g.aAh().azQ().get(ar.a.NXG, Integer.valueOf(0))).intValue();
    this.zjs = getIntent().getIntExtra("key_wallet_region", i);
    this.uuid = getIntent().getStringExtra("key_uuid");
    if (Util.isNullOrNil(this.uuid)) {
      this.uuid = UUID.randomUUID().toString();
    }
    addSceneEndListener(495);
    t.fQP();
    ah.a(this);
    this.zjn = getIntent().getStringExtra("key_func_id");
    Log.i("MicroMsg.MallIndexBaseUI", "mFuncId:" + this.zjn + " wallet_region: " + this.zjs + " walletType: " + z.aUf() + " default_region: " + i);
    this.yUq = getIntent().getStringExtra("key_native_url");
    Log.i("MicroMsg.MallIndexBaseUI", "mNativeUrl:" + this.yUq);
    if (isTransparent()) {
      return;
    }
    dYP();
    setContentViewVisibility(0);
    Log.i("MicroMsg.MallIndexBaseUI", "index Oncreate");
    egS();
    initView();
    com.tencent.mm.plugin.wallet_core.model.mall.c.fSj();
    egT();
    Log.i("MicroMsg.MallIndexBaseUI", "hy: use default controller for MallIndexUI");
    egU();
    if (z.aUo()) {
      Log.e("MicroMsg.MallIndexBaseUI", "it is payu account ,not initFingerPrint");
    }
    for (;;)
    {
      ab.mg(1, 0);
      com.tencent.mm.plugin.report.service.h.CyF.a(11850, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
      return;
      paramBundle = (com.tencent.mm.plugin.fingerprint.d.a)g.af(com.tencent.mm.plugin.fingerprint.d.a.class);
      if (paramBundle != null)
      {
        Log.i("MicroMsg.MallIndexBaseUI", "IFingerPrintMgr is not null, do showFingerPrintEntrance()");
        paramBundle.dJN();
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
    t.fQP();
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
    com.tencent.mm.pluginsdk.wallet.h.setPayChannel(1);
    Log.i("MicroMsg.MallIndexBaseUI", "index onResume");
    if (!g.aAc())
    {
      Log.v("MicroMsg.MallIndexBaseUI", "MMCore is not ready");
      finish();
    }
    if (isTransparent())
    {
      this.zjo = com.tencent.mm.plugin.mall.a.k.egL().Qe(this.zjs);
      if ((this.zjo == null) || (this.zjo.size() <= 0))
      {
        Log.i("MicroMsg.MallIndexBaseUI", "mFunctionList == null");
        try
        {
          if ((getIntent().getIntExtra("key_scene", 0) == 1) || (!Util.isNullOrNil(this.yUq)))
          {
            doSceneForceProgress(new com.tencent.mm.plugin.mall.a.f(this.zjs, com.tencent.mm.plugin.wallet_core.model.mall.b.fRY(), 0));
            return;
          }
          localObject3 = getIntent().getStringExtra("key_url");
          Object localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = "";
          }
          doSceneForceProgress(new com.tencent.mm.plugin.mall.a.f(this.zjs, com.tencent.mm.plugin.wallet_core.model.mall.b.fRY(), getIntent().getStringExtra("key_app_id"), this.zjn, (String)localObject1));
          return;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          Log.printErrStackTrace("MicroMsg.MallIndexBaseUI", localUnsupportedEncodingException, "", new Object[0]);
          egY();
          return;
        }
      }
      Object localObject3 = fs(this.zjo);
      Object localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = ft(this.zjo);
      }
      a((MallFunction)localObject2, -1);
      finish();
      return;
    }
    egV();
    Log.d("MicroMsg.MallIndexBaseUI", "initFunctionList");
    if (com.tencent.mm.plugin.mall.a.k.egL().Qe(this.zjs) == null)
    {
      doSceneProgress(new com.tencent.mm.plugin.mall.a.f(this.zjs, com.tencent.mm.plugin.wallet_core.model.mall.b.fRY(), 0), true);
      Log.e("MicroMsg.MallIndexBaseUI", "funcitonlist invalid");
      i = 0;
    }
    while (i != 0)
    {
      Log.i("MicroMsg.MallIndexBaseUI", "has data");
      updateView();
      return;
      doSceneProgress(new com.tencent.mm.plugin.mall.a.f(this.zjs, com.tencent.mm.plugin.wallet_core.model.mall.b.fRY(), 1), false);
      this.zjo = com.tencent.mm.plugin.mall.a.k.egL().Qe(this.zjs);
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
        if (this.zlo)
        {
          this.zlo = false;
          if (t.fQD().fRN().fRm())
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
    if (paramString.zjs != this.zjs) {
      Log.i("MicroMsg.MallIndexBaseUI", "pass wallet local: %d cgi: %d", new Object[] { Integer.valueOf(this.zjs), Integer.valueOf(paramString.zjs) });
    }
    if (isTransparent())
    {
      Log.d("MicroMsg.MallIndexBaseUI", "errorType:%d | errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if ((paramInt1 == 0) && (paramInt2 == 0) && (paramString.zjo != null)) {
        if (getIntent().getIntExtra("key_scene", 0) == 1)
        {
          paramString = fs(paramString.zjo);
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
      if (!Util.isNullOrNil(this.yUq))
      {
        Log.d("MicroMsg.MallIndexBaseUI", "NativeUrl: %s", new Object[] { this.yUq });
        paramString = ft(paramString.zjo);
        if (paramString != null)
        {
          a(paramString, -1);
          break;
        }
        egY();
        return true;
      }
      if ((paramString.zjo != null) && (paramString.zjo.size() > 0))
      {
        Log.i("MicroMsg.MallIndexBaseUI", "functionScene.mFunctionList != null");
        a(fs(paramString.zjo), -1);
        break;
      }
      if ((com.tencent.mm.plugin.mall.a.k.egL().Qe(this.zjs) != null) && (com.tencent.mm.plugin.mall.a.k.egL().Qe(this.zjs).size() > 0))
      {
        Log.i("MicroMsg.MallIndexBaseUI", "SubCoreMall.getCore().getFunctionList() != null");
        a(fs(com.tencent.mm.plugin.mall.a.k.egL().Qe(this.zjs)), -1);
        break;
      }
      Log.e("MicroMsg.MallIndexBaseUI", "SubCoreMall.getCore().getFunctionList() == null");
      break;
      egY();
      continue;
      if ((paramInt1 == 0) && (paramInt2 == 0) && (com.tencent.mm.plugin.mall.a.k.egL().Qe(this.zjs) != null) && (paramString.zjo != null))
      {
        this.zjo = com.tencent.mm.plugin.mall.a.k.egL().Qe(this.zjs);
        Log.i("MicroMsg.MallIndexBaseUI", "get from server now! " + this.zjs + " " + this.zjo.size());
        com.tencent.mm.plugin.wallet_core.model.mall.c.fSg().aW(this.zjo);
        if (!Util.isNullOrNil(this.zjo))
        {
          paramString = new LinkedList();
          paramq = this.zjo.iterator();
          while (paramq.hasNext())
          {
            MallFunction localMallFunction = (MallFunction)paramq.next();
            if (!Util.isNullOrNil(localMallFunction.egX)) {
              paramString.add(localMallFunction.egX);
            }
          }
          if (!Util.isNullOrNil(paramString))
          {
            paramq = (w)g.af(w.class);
            if (paramq != null) {
              paramq.bg(paramString);
            }
          }
        }
      }
      updateView();
      egX();
      egZ();
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
    this.zli.ax(this.zjo);
    ehd();
    ehe();
    ehf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexBaseUI
 * JD-Core Version:    0.7.0.1
 */