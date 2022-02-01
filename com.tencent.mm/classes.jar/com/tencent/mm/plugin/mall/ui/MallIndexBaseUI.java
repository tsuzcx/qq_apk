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
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.rg;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.appbrand.api.WeAppOpenDeclarePromptBundle;
import com.tencent.mm.plugin.appbrand.service.p;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.wallet_core.model.ah;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.l;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.e.m;
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
  protected View rXv;
  protected String uuid;
  private String vDf = null;
  ArrayList<MallFunction> vDg = null;
  protected int vDk;
  private TextView vEW = null;
  protected ListView vEX = null;
  private b vEY = null;
  protected ImageView vEZ = null;
  protected ImageView vFa;
  protected TextView vFb = null;
  protected TextView vFc;
  private int vFd = 0;
  private boolean vFe = true;
  protected int vFf;
  protected View vFg;
  private boolean vFh = false;
  private String vvi = null;
  
  private void dkm()
  {
    boolean bool = getIntent().getBooleanExtra("key_wallet_has_red", false);
    if (this.vEX.getChildCount() == 0) {}
    label404:
    for (;;)
    {
      return;
      int i = this.vEX.getFirstVisiblePosition();
      int j = this.vEX.getChildAt(0).getTop();
      ad.i("MicroMsg.MallIndexBaseUI", "initCheckNew %s fpos %s top %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j) });
      if ((i == 0) && (j == 0) && (bool) && (!this.vFh) && (this.vDg != null))
      {
        this.vFh = true;
        int k = this.vEX.getHeaderViewsCount() + this.vEY.getCount();
        List localList = this.vEY.vDW;
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
                if ((localc != null) && (localc.vEA != null) && (b.a(localc.vEA)))
                {
                  i = this.vEX.getFirstVisiblePosition();
                  j = this.vEX.getLastVisiblePosition();
                  ad.i("MicroMsg.MallIndexBaseUI", "get listview show top %s bottom %s redPos: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
                  if ((k >= i) && (k <= j)) {
                    break;
                  }
                  int m = a.dkd();
                  j = a.dkc() + a.dkb() * (k + 1) + m;
                  i = j;
                  if (k > 2) {
                    i = j + m;
                  }
                  j = i;
                  if (k > 3) {
                    j = i + m;
                  }
                  m = a.dkb() / 3;
                  int n = this.vEX.getScrollY();
                  k = al.ci(this).y;
                  i = k;
                  if (al.jR(this)) {
                    i = k - al.ej(this);
                  }
                  k = i;
                  if (getSupportActionBar() != null) {
                    k = i - getSupportActionBar().getHeight();
                  }
                  this.vEX.smoothScrollBy(j + m - n - k, 1000);
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
  
  private void dkn()
  {
    setResult(0);
    finish();
  }
  
  private void dkr()
  {
    if (u.aAB())
    {
      com.tencent.mm.wallet_core.a.b(getContext(), "PayURemittanceProcess", null);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("pay_channel", 1);
    com.tencent.mm.wallet_core.a.b(getContext(), "RemittanceProcess", localBundle);
  }
  
  private void dkt()
  {
    if (this.vEW != null) {
      this.vEW.setVisibility(8);
    }
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
      if (paramMallFunction.Dbp != null)
      {
        localObject1 = localObject2;
        if (!bt.isNullOrNil(paramMallFunction.Dbp.Bhd)) {
          localObject1 = paramMallFunction.Dbp.Bhd;
        }
      }
      if (this.vDg != null) {
        break label261;
      }
      i = 0;
      boolean bool = b.a(paramMallFunction);
      localObject2 = com.tencent.mm.plugin.report.service.g.yhR;
      str = paramMallFunction.jDb;
      if (!bool) {
        break label272;
      }
    }
    label261:
    label272:
    for (int j = 2;; j = 1)
    {
      ((com.tencent.mm.plugin.report.service.g)localObject2).f(10881, new Object[] { str, Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(paramInt), localObject1, Integer.valueOf(j), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
      if ((paramMallFunction == null) || (bt.isNullOrNil(paramMallFunction.dNL)) || (!((p)com.tencent.mm.kernel.g.ab(p.class)).n(paramMallFunction.dNL, null))) {
        break label278;
      }
      ad.i("MicroMsg.MallIndexBaseUI", "handleFunction, intercept by AppBrandNativeLink, nativeUrl = %s", new Object[] { paramMallFunction.dNL });
      c.eGT().aEC(paramMallFunction.jDb);
      com.tencent.mm.plugin.wallet_core.model.mall.d.eGX().aEC(paramMallFunction.jDb);
      if (paramMallFunction.Dbp != null)
      {
        c.eGT();
        c.i(paramMallFunction);
      }
      return;
      i = this.vDg.size();
      break;
    }
    label278:
    paramInt = d.f(paramMallFunction);
    ad.i("MicroMsg.MallIndexBaseUI", "functionType : ".concat(String.valueOf(paramInt)));
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
      com.tencent.mm.bs.d.b(this, "recharge", ".ui.PhoneRechargeUI", (Intent)localObject1);
      ab.kB(15, 0);
      return;
    case 4: 
      com.tencent.mm.plugin.report.service.g.yhR.f(11701, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
      paramMallFunction = new Intent();
      paramMallFunction.putExtra("pay_channel", 1);
      com.tencent.mm.bs.d.b(this, "luckymoney", ".ui.LuckyMoneyIndexUI", paramMallFunction);
      ab.kB(13, 0);
      com.tencent.mm.plugin.report.service.g.yhR.f(11850, new Object[] { Integer.valueOf(4), Integer.valueOf(0) });
      return;
    case 7: 
      localObject1 = new Intent();
      if (isTransparent()) {
        ((Intent)localObject1).putExtra("key_is_hide_progress", true);
      }
      ((Intent)localObject1).putExtra("key_func_info", paramMallFunction);
      com.tencent.mm.bs.d.b(this, "recharge", ".ui.RechargeUI", (Intent)localObject1);
      return;
    case 1: 
      com.tencent.mm.kernel.g.ajD();
      this.vDk = ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Ivh, Integer.valueOf(0))).intValue();
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("rawUrl", paramMallFunction.usV);
      ((Intent)localObject1).putExtra("geta8key_username", u.aAm());
      ((Intent)localObject1).putExtra("pay_channel", 1);
      ((Intent)localObject1).putExtra("KPublisherId", "pay_wallet");
      ((Intent)localObject1).putExtra("key_download_restrict", paramMallFunction.Dbr);
      ((Intent)localObject1).putExtra("key_wallet_region", this.vDk);
      ((Intent)localObject1).putExtra("key_function_id", paramMallFunction.jDb);
      ((Intent)localObject1).putExtra(e.m.IVa, true);
      ((Intent)localObject1).putExtra("geta8key_scene", 46);
      com.tencent.mm.wallet_core.ui.e.an(getContext(), (Intent)localObject1);
      return;
    case 2: 
      ad.w("MicroMsg.MallIndexBaseUI", "doSelectFunction no jump");
      return;
    case 3: 
      ad.w("MicroMsg.MallIndexBaseUI", "doSelectFunction do nothing");
      com.tencent.mm.ui.base.t.makeText(this, "fuction list error", 1).show();
      return;
    case 5: 
      com.tencent.mm.plugin.report.service.g.yhR.f(11458, new Object[] { Integer.valueOf(1) });
      if (u.aAB())
      {
        paramMallFunction = new LinkedList();
        localObject1 = new LinkedList();
        paramMallFunction.add(getString(2131762535));
        ((List)localObject1).add(Integer.valueOf(0));
        paramMallFunction.add(getString(2131757496));
        ((List)localObject1).add(Integer.valueOf(1));
        com.tencent.mm.ui.base.h.b(this, getString(2131762442), paramMallFunction, (List)localObject1, null, new h.d()
        {
          public final void cv(int paramAnonymousInt1, int paramAnonymousInt2)
          {
            AppMethodBeat.i(66066);
            switch (paramAnonymousInt2)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(66066);
              return;
              com.tencent.mm.plugin.report.service.g.yhR.f(11458, new Object[] { Integer.valueOf(2) });
              if (u.aAB())
              {
                com.tencent.mm.wallet_core.a.b(MallIndexBaseUI.this.getContext(), "PayURemittanceProcess", null);
                AppMethodBeat.o(66066);
                return;
              }
              com.tencent.mm.wallet_core.a.b(MallIndexBaseUI.this.getContext(), "RemittanceProcess", null);
              AppMethodBeat.o(66066);
              return;
              com.tencent.mm.plugin.report.service.g.yhR.f(11458, new Object[] { Integer.valueOf(3) });
              com.tencent.mm.pluginsdk.wallet.f.au(MallIndexBaseUI.this, 2);
            }
          }
        });
      }
      for (;;)
      {
        ab.kB(14, 0);
        com.tencent.mm.plugin.report.service.g.yhR.f(11850, new Object[] { Integer.valueOf(3), Integer.valueOf(0) });
        return;
        com.tencent.mm.kernel.g.ajD();
        if (!((Boolean)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Irg, Boolean.FALSE)).booleanValue())
        {
          com.tencent.mm.kernel.g.ajD();
          com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Irg, Boolean.TRUE);
          com.tencent.mm.ui.base.h.d(this, getString(2131765307), "", new DialogInterface.OnClickListener()
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
          dkr();
        }
      }
    case 6: 
      paramMallFunction = new Intent();
      paramMallFunction.putExtra("key_from_scene", 1);
      com.tencent.mm.bs.d.b(getContext(), "offline", ".ui.WalletOfflineEntranceUI", paramMallFunction);
      ab.kB(9, 0);
      com.tencent.mm.plugin.report.service.g.yhR.f(11850, new Object[] { Integer.valueOf(5), Integer.valueOf(0) });
      return;
    case 8: 
      paramMallFunction = new Intent();
      paramMallFunction.putExtra("BaseScanUI_select_scan_mode", 1);
      com.tencent.mm.bs.d.b(getContext(), "scanner", ".ui.BaseScanUI", paramMallFunction);
      return;
    }
    com.tencent.mm.bs.d.Q(getContext(), "luckymoney", ".f2f.ui.LuckyMoneyF2FQRCodeUI");
  }
  
  public boolean checkProcLife()
  {
    return false;
  }
  
  protected abstract void dcd();
  
  protected abstract void dkh();
  
  protected abstract void dki();
  
  protected abstract void dkj();
  
  protected abstract boolean dkk();
  
  protected abstract void dkl();
  
  protected abstract void dko();
  
  protected abstract void dkp();
  
  protected abstract void dkq();
  
  protected abstract void dks();
  
  protected abstract void dku();
  
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
    ad.d("MicroMsg.MallIndexBaseUI", "index initView");
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(66063);
        paramAnonymousMenuItem = new Intent();
        paramAnonymousMenuItem.addFlags(67108864);
        paramAnonymousMenuItem.putExtra("preferred_tab", 3);
        com.tencent.mm.bs.d.f(MallIndexBaseUI.this, "com.tencent.mm.ui.LauncherUI", paramAnonymousMenuItem);
        MallIndexBaseUI.this.finish();
        if (!com.tencent.mm.pluginsdk.wallet.e.ffA())
        {
          com.tencent.mm.plugin.report.service.g.yhR.f(14954, new Object[] { com.tencent.mm.pluginsdk.wallet.e.ffB(), "open_wcpay_specific_view:ok" });
          com.tencent.mm.pluginsdk.wallet.e.ffC();
        }
        com.tencent.mm.plugin.report.service.g.yhR.f(14419, new Object[] { MallIndexBaseUI.this.uuid, Integer.valueOf(6) });
        ad.i("MicroMsg.MallIndexBaseUI", "set BackBtn");
        AppMethodBeat.o(66063);
        return true;
      }
    });
    this.vEX = ((ListView)findViewById(2131302018));
    initHeaderView();
    dko();
    this.vEY = new b(this, this.vDk);
    this.vEX.setAdapter(this.vEY);
    this.vEY.vDX = new b.d()
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
          if ((!com.tencent.mm.plugin.wallet_core.model.mall.b.a.aEz(paramAnonymousMallFunction.jDb)) && (!bt.isNullOrNil(paramAnonymousMallFunction.Dbq)))
          {
            i = 1;
            if (i == 0) {
              break label633;
            }
            ad.i("MicroMsg.MallIndexBaseUI", "onFunctionItemClick show disclaimer funcId=%s", new Object[] { paramAnonymousMallFunction.jDb });
            String str1 = MallIndexBaseUI.this.getString(2131761167);
            String str2 = MallIndexBaseUI.this.getString(2131755792);
            localObject2 = new WeAppOpenDeclarePromptBundle((byte)0);
            ((WeAppOpenDeclarePromptBundle)localObject2).ePC = 2;
            ((WeAppOpenDeclarePromptBundle)localObject2).jDc = str1;
            ((WeAppOpenDeclarePromptBundle)localObject2).jDd = paramAnonymousMallFunction.Dbq;
            ((WeAppOpenDeclarePromptBundle)localObject2).jDe = str2;
            ((WeAppOpenDeclarePromptBundle)localObject2).ov = false;
            ((WeAppOpenDeclarePromptBundle)localObject2).jDb = paramAnonymousMallFunction.jDb;
            localObject1 = new Bundle();
            ((Bundle)localObject1).putParcelable("weapp_open_declare_prompt_key", (Parcelable)localObject2);
            localObject3 = MallIndexBaseUI.this;
            if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qxU, 1) != 1) {
              break label350;
            }
            i = 1;
            label176:
            if (i != 0) {
              break label355;
            }
            ad.i("MicroMsg.MallIndexBaseUI", "handleFunctionByAppBrand clicfg_appbrand_dialog_optimize_switch close");
            label187:
            i = 0;
            if (i == 0)
            {
              localObject1 = new d.a(MallIndexBaseUI.this.getContext());
              ((d.a)localObject1).aXF(str1);
              ((d.a)localObject1).aXG(paramAnonymousMallFunction.Dbq);
              ((d.a)localObject1).aXM(str2).c(new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(66064);
                  ad.i("MicroMsg.MallIndexBaseUI", "onFunctionItemClick: onClick");
                  com.tencent.mm.plugin.wallet_core.model.mall.b.a.aEy(paramAnonymousMallFunction.jDb);
                  MallIndexBaseUI.this.a(paramAnonymousMallFunction, paramAnonymousInt);
                  AppMethodBeat.o(66064);
                }
              });
              ((d.a)localObject1).yR(true);
              ((d.a)localObject1).e(new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(199041);
                  ad.i("MicroMsg.MallIndexBaseUI", "onFunctionItemClick: onCancel");
                  com.tencent.mm.plugin.wallet_core.model.mall.b.a.aEy(paramAnonymousMallFunction.jDb);
                  AppMethodBeat.o(199041);
                }
              });
              ((d.a)localObject1).fMb().show();
            }
          }
          for (;;)
          {
            ad.d("MicroMsg.MallIndexBaseUI", "type: %s", new Object[] { Integer.valueOf(paramAnonymousMallFunction.type) });
            com.tencent.mm.plugin.report.service.g.yhR.f(14419, new Object[] { MallIndexBaseUI.this.uuid, Integer.valueOf(4), Integer.valueOf(paramAnonymousMallFunction.type) });
            AppMethodBeat.o(66065);
            return;
            i = 0;
            break;
            label350:
            i = 0;
            break label176;
            label355:
            if ((paramAnonymousMallFunction == null) || (bt.isNullOrNil(paramAnonymousMallFunction.dNL)) || (!((p)com.tencent.mm.kernel.g.ab(p.class)).n(paramAnonymousMallFunction.dNL, (Bundle)localObject1))) {
              break label187;
            }
            ad.i("MicroMsg.MallIndexBaseUI", "handleFunctionByAppBrand, intercept by AppBrandNativeLink, nativeUrl = %s", new Object[] { paramAnonymousMallFunction.dNL });
            c.eGT().aEC(paramAnonymousMallFunction.jDb);
            com.tencent.mm.plugin.wallet_core.model.mall.d.eGX().aEC(paramAnonymousMallFunction.jDb);
            if (paramAnonymousMallFunction.Dbp != null)
            {
              c.eGT();
              c.i(paramAnonymousMallFunction);
            }
            if (paramAnonymousInt >= 0)
            {
              localObject2 = "";
              localObject1 = localObject2;
              if (paramAnonymousMallFunction.Dbp != null)
              {
                localObject1 = localObject2;
                if (!bt.isNullOrNil(paramAnonymousMallFunction.Dbp.Bhd)) {
                  localObject1 = paramAnonymousMallFunction.Dbp.Bhd;
                }
              }
              if (((MallIndexBaseUI)localObject3).vDg != null) {
                break label615;
              }
              i = 0;
              label501:
              boolean bool = b.a(paramAnonymousMallFunction);
              localObject2 = com.tencent.mm.plugin.report.service.g.yhR;
              localObject3 = paramAnonymousMallFunction.jDb;
              if (!bool) {
                break label627;
              }
            }
            label615:
            label627:
            for (int j = 2;; j = 1)
            {
              ((com.tencent.mm.plugin.report.service.g)localObject2).f(10881, new Object[] { localObject3, Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(paramAnonymousInt), localObject1, Integer.valueOf(j), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
              i = 1;
              break;
              i = ((MallIndexBaseUI)localObject3).vDg.size();
              break label501;
            }
            label633:
            MallIndexBaseUI.this.a(paramAnonymousMallFunction, paramAnonymousInt);
          }
        }
        ad.w("MicroMsg.MallIndexBaseUI", "onFunctionItemClick functionItem null; pos=%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(66065);
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
    ad.i("MicroMsg.MallIndexBaseUI", "onCreate");
    super.onCreate(paramBundle);
    if (!com.tencent.mm.kernel.g.ajx())
    {
      ad.v("MicroMsg.MallIndexBaseUI", "MMCore is not ready");
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
    com.tencent.mm.plugin.wallet_core.model.t.eFF();
    ah.a(this);
    this.vDf = getIntent().getStringExtra("key_func_id");
    ad.i("MicroMsg.MallIndexBaseUI", "mFuncId:" + this.vDf + " wallet_region: " + this.vDk + " walletType: " + u.aAt() + " default_region: " + i);
    this.vvi = getIntent().getStringExtra("key_native_url");
    ad.i("MicroMsg.MallIndexBaseUI", "mNativeUrl:" + this.vvi);
    if (isTransparent()) {
      return;
    }
    dcd();
    setContentViewVisibility(0);
    ad.i("MicroMsg.MallIndexBaseUI", "index Oncreate");
    dkh();
    initView();
    c.eGW();
    dki();
    ad.i("MicroMsg.MallIndexBaseUI", "hy: use default controller for MallIndexUI");
    dkj();
    if (u.aAB()) {
      ad.e("MicroMsg.MallIndexBaseUI", "it is payu account ,not initFingerPrint");
    }
    for (;;)
    {
      ab.kB(1, 0);
      com.tencent.mm.plugin.report.service.g.yhR.f(11850, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
      return;
      paramBundle = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
      if (paramBundle != null)
      {
        ad.i("MicroMsg.MallIndexBaseUI", "IFingerPrintMgr is not null, do showFingerPrintEntrance()");
        paramBundle.cPn();
      }
      else
      {
        ad.e("MicroMsg.MallIndexBaseUI", "IFingerPrintMgr is not null");
      }
    }
  }
  
  public void onDestroy()
  {
    removeSceneEndListener(495);
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
    com.tencent.mm.pluginsdk.wallet.h.Zx(1);
    ad.i("MicroMsg.MallIndexBaseUI", "index onResume");
    if (!com.tencent.mm.kernel.g.ajx())
    {
      ad.v("MicroMsg.MallIndexBaseUI", "MMCore is not ready");
      finish();
    }
    if (isTransparent())
    {
      this.vDg = com.tencent.mm.plugin.mall.a.k.dka().JD(this.vDk);
      if ((this.vDg == null) || (this.vDg.size() <= 0))
      {
        ad.i("MicroMsg.MallIndexBaseUI", "mFunctionList == null");
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
          ad.printErrStackTrace("MicroMsg.MallIndexBaseUI", localUnsupportedEncodingException, "", new Object[0]);
          dkn();
          return;
        }
      }
      Object localObject3 = eu(this.vDg);
      Object localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = ev(this.vDg);
      }
      a((MallFunction)localObject2, -1);
      finish();
      return;
    }
    dkk();
    ad.d("MicroMsg.MallIndexBaseUI", "initFunctionList");
    if (com.tencent.mm.plugin.mall.a.k.dka().JD(this.vDk) == null)
    {
      doSceneProgress(new com.tencent.mm.plugin.mall.a.f(this.vDk, com.tencent.mm.plugin.wallet_core.model.mall.b.eGM(), 0), true);
      ad.e("MicroMsg.MallIndexBaseUI", "funcitonlist invalid");
      i = 0;
    }
    while (i != 0)
    {
      ad.i("MicroMsg.MallIndexBaseUI", "has data");
      updateView();
      return;
      doSceneProgress(new com.tencent.mm.plugin.mall.a.f(this.vDk, com.tencent.mm.plugin.wallet_core.model.mall.b.eGM(), 1), false);
      this.vDg = com.tencent.mm.plugin.mall.a.k.dka().JD(this.vDk);
    }
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    ad.d("MicroMsg.MallIndexBaseUI", "onOtherSceneEnd");
    if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.b.a))
    {
      ad.d("MicroMsg.MallIndexBaseUI", "hy: query bound scene end");
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (this.vFe)
        {
          this.vFe = false;
          if (com.tencent.mm.plugin.wallet_core.model.t.eFt().eHg().eGc())
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
    switch (paramn.getType())
    {
    default: 
      return false;
    }
    paramString = (com.tencent.mm.plugin.mall.a.f)paramn;
    if (paramString.vDk != this.vDk) {
      ad.i("MicroMsg.MallIndexBaseUI", "pass wallet local: %d cgi: %d", new Object[] { Integer.valueOf(this.vDk), Integer.valueOf(paramString.vDk) });
    }
    if (isTransparent())
    {
      ad.d("MicroMsg.MallIndexBaseUI", "errorType:%d | errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if ((paramInt1 == 0) && (paramInt2 == 0) && (paramString.vDg != null)) {
        if (getIntent().getIntExtra("key_scene", 0) == 1)
        {
          paramString = eu(paramString.vDg);
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
      if (!bt.isNullOrNil(this.vvi))
      {
        ad.d("MicroMsg.MallIndexBaseUI", "NativeUrl: %s", new Object[] { this.vvi });
        paramString = ev(paramString.vDg);
        if (paramString != null)
        {
          a(paramString, -1);
          break;
        }
        dkn();
        return true;
      }
      if ((paramString.vDg != null) && (paramString.vDg.size() > 0))
      {
        ad.i("MicroMsg.MallIndexBaseUI", "functionScene.mFunctionList != null");
        a(eu(paramString.vDg), -1);
        break;
      }
      if ((com.tencent.mm.plugin.mall.a.k.dka().JD(this.vDk) != null) && (com.tencent.mm.plugin.mall.a.k.dka().JD(this.vDk).size() > 0))
      {
        ad.i("MicroMsg.MallIndexBaseUI", "SubCoreMall.getCore().getFunctionList() != null");
        a(eu(com.tencent.mm.plugin.mall.a.k.dka().JD(this.vDk)), -1);
        break;
      }
      ad.e("MicroMsg.MallIndexBaseUI", "SubCoreMall.getCore().getFunctionList() == null");
      break;
      dkn();
      continue;
      if ((paramInt1 == 0) && (paramInt2 == 0) && (com.tencent.mm.plugin.mall.a.k.dka().JD(this.vDk) != null) && (paramString.vDg != null))
      {
        this.vDg = com.tencent.mm.plugin.mall.a.k.dka().JD(this.vDk);
        ad.i("MicroMsg.MallIndexBaseUI", "get from server now! " + this.vDk + " " + this.vDg.size());
        c.eGT().aD(this.vDg);
        if (!bt.hj(this.vDg))
        {
          paramString = new LinkedList();
          paramn = this.vDg.iterator();
          while (paramn.hasNext())
          {
            MallFunction localMallFunction = (MallFunction)paramn.next();
            if (!bt.isNullOrNil(localMallFunction.dNL)) {
              paramString.add(localMallFunction.dNL);
            }
          }
          if (!bt.hj(paramString))
          {
            paramn = (r)com.tencent.mm.kernel.g.ab(r.class);
            if (paramn != null) {
              paramn.aW(paramString);
            }
          }
        }
      }
      updateView();
      dkm();
      dko();
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
    this.vEY.aj(this.vDg);
    dks();
    dkt();
    dku();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexBaseUI
 * JD-Core Version:    0.7.0.1
 */