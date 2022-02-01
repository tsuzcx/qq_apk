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
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.rh;
import com.tencent.mm.model.v;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.appbrand.api.WeAppOpenDeclarePromptBundle;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.plugin.appbrand.service.s;
import com.tencent.mm.plugin.wallet_core.model.ah;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.l;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
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
  protected View sgg;
  protected String uuid;
  private String vHm = null;
  private String vPj = null;
  ArrayList<MallFunction> vPk = null;
  protected int vPo;
  private TextView vRa = null;
  protected ListView vRb = null;
  private b vRc = null;
  protected ImageView vRd = null;
  protected ImageView vRe;
  protected TextView vRf = null;
  protected TextView vRg;
  private int vRh = 0;
  private boolean vRi = true;
  protected int vRj;
  protected View vRk;
  private boolean vRl = false;
  
  private void dnl()
  {
    boolean bool = getIntent().getBooleanExtra("key_wallet_has_red", false);
    if (this.vRb.getChildCount() == 0) {}
    label404:
    for (;;)
    {
      return;
      int i = this.vRb.getFirstVisiblePosition();
      int j = this.vRb.getChildAt(0).getTop();
      ae.i("MicroMsg.MallIndexBaseUI", "initCheckNew %s fpos %s top %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j) });
      if ((i == 0) && (j == 0) && (bool) && (!this.vRl) && (this.vPk != null))
      {
        this.vRl = true;
        int k = this.vRb.getHeaderViewsCount() + this.vRc.getCount();
        List localList = this.vRc.vQa;
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
                if ((localc != null) && (localc.vQE != null) && (b.a(localc.vQE)))
                {
                  i = this.vRb.getFirstVisiblePosition();
                  j = this.vRb.getLastVisiblePosition();
                  ae.i("MicroMsg.MallIndexBaseUI", "get listview show top %s bottom %s redPos: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
                  if ((k >= i) && (k <= j)) {
                    break;
                  }
                  int m = a.dnc();
                  j = a.dnb() + a.dna() * (k + 1) + m;
                  i = j;
                  if (k > 2) {
                    i = j + m;
                  }
                  j = i;
                  if (k > 3) {
                    j = i + m;
                  }
                  m = a.dna() / 3;
                  int n = this.vRb.getScrollY();
                  k = al.ck(this).y;
                  i = k;
                  if (al.jY(this)) {
                    i = k - al.en(this);
                  }
                  k = i;
                  if (getSupportActionBar() != null) {
                    k = i - getSupportActionBar().getHeight();
                  }
                  this.vRb.smoothScrollBy(j + m - n - k, 1000);
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
  
  private void dnm()
  {
    setResult(0);
    finish();
  }
  
  private void dnq()
  {
    if (v.aAR())
    {
      com.tencent.mm.wallet_core.a.b(getContext(), "PayURemittanceProcess", null);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("pay_channel", 1);
    com.tencent.mm.wallet_core.a.b(getContext(), "RemittanceProcess", localBundle);
  }
  
  private void dns()
  {
    if (this.vRa != null) {
      this.vRa.setVisibility(8);
    }
  }
  
  private MallFunction ey(List<MallFunction> paramList)
  {
    Object localObject;
    if ((paramList == null) || (paramList.size() == 0) || (TextUtils.isEmpty(this.vPj)))
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
        if (this.vPj.equals(localMallFunction.jFZ)) {
          break;
        }
      }
      i += 1;
    }
    label81:
    return null;
  }
  
  private MallFunction ez(List<MallFunction> paramList)
  {
    Object localObject;
    if ((paramList == null) || (paramList.size() == 0) || (TextUtils.isEmpty(this.vHm)))
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
        if (this.vHm.equals(localMallFunction.dPb)) {
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
      if (paramMallFunction.DsT != null)
      {
        localObject1 = localObject2;
        if (!bu.isNullOrNil(paramMallFunction.DsT.ByB)) {
          localObject1 = paramMallFunction.DsT.ByB;
        }
      }
      if (this.vPk != null) {
        break label261;
      }
      i = 0;
      boolean bool = b.a(paramMallFunction);
      localObject2 = com.tencent.mm.plugin.report.service.g.yxI;
      str = paramMallFunction.jFZ;
      if (!bool) {
        break label272;
      }
    }
    label261:
    label272:
    for (int j = 2;; j = 1)
    {
      ((com.tencent.mm.plugin.report.service.g)localObject2).f(10881, new Object[] { str, Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(paramInt), localObject1, Integer.valueOf(j), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
      if ((paramMallFunction == null) || (bu.isNullOrNil(paramMallFunction.dPb)) || (!((q)com.tencent.mm.kernel.g.ab(q.class)).n(paramMallFunction.dPb, null))) {
        break label278;
      }
      ae.i("MicroMsg.MallIndexBaseUI", "handleFunction, intercept by AppBrandNativeLink, nativeUrl = %s", new Object[] { paramMallFunction.dPb });
      c.eKB().aFW(paramMallFunction.jFZ);
      com.tencent.mm.plugin.wallet_core.model.mall.d.eKF().aFW(paramMallFunction.jFZ);
      if (paramMallFunction.DsT != null)
      {
        c.eKB();
        c.i(paramMallFunction);
      }
      return;
      i = this.vPk.size();
      break;
    }
    label278:
    paramInt = d.f(paramMallFunction);
    ae.i("MicroMsg.MallIndexBaseUI", "functionType : ".concat(String.valueOf(paramInt)));
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
      com.tencent.mm.br.d.b(this, "recharge", ".ui.PhoneRechargeUI", (Intent)localObject1);
      ab.kI(15, 0);
      return;
    case 4: 
      com.tencent.mm.plugin.report.service.g.yxI.f(11701, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
      paramMallFunction = new Intent();
      paramMallFunction.putExtra("pay_channel", 1);
      com.tencent.mm.br.d.b(this, "luckymoney", ".ui.LuckyMoneyIndexUI", paramMallFunction);
      ab.kI(13, 0);
      com.tencent.mm.plugin.report.service.g.yxI.f(11850, new Object[] { Integer.valueOf(4), Integer.valueOf(0) });
      return;
    case 7: 
      localObject1 = new Intent();
      if (isTransparent()) {
        ((Intent)localObject1).putExtra("key_is_hide_progress", true);
      }
      ((Intent)localObject1).putExtra("key_func_info", paramMallFunction);
      com.tencent.mm.br.d.b(this, "recharge", ".ui.RechargeUI", (Intent)localObject1);
      return;
    case 1: 
      com.tencent.mm.kernel.g.ajS();
      this.vPo = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IPF, Integer.valueOf(0))).intValue();
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("rawUrl", paramMallFunction.uEo);
      ((Intent)localObject1).putExtra("geta8key_username", v.aAC());
      ((Intent)localObject1).putExtra("pay_channel", 1);
      ((Intent)localObject1).putExtra("KPublisherId", "pay_wallet");
      ((Intent)localObject1).putExtra("key_download_restrict", paramMallFunction.DsV);
      ((Intent)localObject1).putExtra("key_wallet_region", this.vPo);
      ((Intent)localObject1).putExtra("key_function_id", paramMallFunction.jFZ);
      ((Intent)localObject1).putExtra(e.m.JpI, true);
      ((Intent)localObject1).putExtra("geta8key_scene", 46);
      com.tencent.mm.wallet_core.ui.f.an(getContext(), (Intent)localObject1);
      return;
    case 2: 
      ae.w("MicroMsg.MallIndexBaseUI", "doSelectFunction no jump");
      return;
    case 3: 
      ae.w("MicroMsg.MallIndexBaseUI", "doSelectFunction do nothing");
      com.tencent.mm.ui.base.t.makeText(this, "fuction list error", 1).show();
      return;
    case 5: 
      com.tencent.mm.plugin.report.service.g.yxI.f(11458, new Object[] { Integer.valueOf(1) });
      if (v.aAR())
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
              com.tencent.mm.plugin.report.service.g.yxI.f(11458, new Object[] { Integer.valueOf(2) });
              if (v.aAR())
              {
                com.tencent.mm.wallet_core.a.b(MallIndexBaseUI.this.getContext(), "PayURemittanceProcess", null);
                AppMethodBeat.o(66066);
                return;
              }
              com.tencent.mm.wallet_core.a.b(MallIndexBaseUI.this.getContext(), "RemittanceProcess", null);
              AppMethodBeat.o(66066);
              return;
              com.tencent.mm.plugin.report.service.g.yxI.f(11458, new Object[] { Integer.valueOf(3) });
              com.tencent.mm.pluginsdk.wallet.f.au(MallIndexBaseUI.this, 2);
            }
          }
        });
      }
      for (;;)
      {
        ab.kI(14, 0);
        com.tencent.mm.plugin.report.service.g.yxI.f(11850, new Object[] { Integer.valueOf(3), Integer.valueOf(0) });
        return;
        com.tencent.mm.kernel.g.ajS();
        if (!((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.ILC, Boolean.FALSE)).booleanValue())
        {
          com.tencent.mm.kernel.g.ajS();
          com.tencent.mm.kernel.g.ajR().ajA().set(am.a.ILC, Boolean.TRUE);
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
          dnq();
        }
      }
    case 6: 
      paramMallFunction = new Intent();
      paramMallFunction.putExtra("key_from_scene", 1);
      com.tencent.mm.br.d.b(getContext(), "offline", ".ui.WalletOfflineEntranceUI", paramMallFunction);
      ab.kI(9, 0);
      com.tencent.mm.plugin.report.service.g.yxI.f(11850, new Object[] { Integer.valueOf(5), Integer.valueOf(0) });
      return;
    case 8: 
      paramMallFunction = new Intent();
      paramMallFunction.putExtra("BaseScanUI_select_scan_mode", 1);
      com.tencent.mm.br.d.b(getContext(), "scanner", ".ui.BaseScanUI", paramMallFunction);
      return;
    }
    com.tencent.mm.br.d.Q(getContext(), "luckymoney", ".f2f.ui.LuckyMoneyF2FQRCodeUI");
  }
  
  public boolean checkProcLife()
  {
    return false;
  }
  
  protected abstract void deV();
  
  protected abstract void dng();
  
  protected abstract void dnh();
  
  protected abstract void dni();
  
  protected abstract boolean dnj();
  
  protected abstract void dnk();
  
  protected abstract void dnn();
  
  protected abstract void dno();
  
  protected abstract void dnp();
  
  protected abstract void dnr();
  
  protected abstract void dnt();
  
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
    if ((paramInt == 12) && (this.vRf != null)) {
      dnp();
    }
  }
  
  protected abstract void initHeaderView();
  
  public void initView()
  {
    ae.d("MicroMsg.MallIndexBaseUI", "index initView");
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(66063);
        paramAnonymousMenuItem = new Intent();
        paramAnonymousMenuItem.addFlags(67108864);
        paramAnonymousMenuItem.putExtra("preferred_tab", 3);
        com.tencent.mm.br.d.f(MallIndexBaseUI.this, "com.tencent.mm.ui.LauncherUI", paramAnonymousMenuItem);
        MallIndexBaseUI.this.finish();
        if (!com.tencent.mm.pluginsdk.wallet.e.fjq())
        {
          com.tencent.mm.plugin.report.service.g.yxI.f(14954, new Object[] { com.tencent.mm.pluginsdk.wallet.e.fjr(), "open_wcpay_specific_view:ok" });
          com.tencent.mm.pluginsdk.wallet.e.fjs();
        }
        com.tencent.mm.plugin.report.service.g.yxI.f(14419, new Object[] { MallIndexBaseUI.this.uuid, Integer.valueOf(6) });
        ae.i("MicroMsg.MallIndexBaseUI", "set BackBtn");
        AppMethodBeat.o(66063);
        return true;
      }
    });
    this.vRb = ((ListView)findViewById(2131302018));
    initHeaderView();
    dnn();
    this.vRc = new b(this, this.vPo);
    this.vRb.setAdapter(this.vRc);
    this.vRc.vQb = new b.d()
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
          if ((!com.tencent.mm.plugin.wallet_core.model.mall.b.a.aFT(paramAnonymousMallFunction.jFZ)) && (!bu.isNullOrNil(paramAnonymousMallFunction.DsU)))
          {
            i = 1;
            if (i == 0) {
              break label633;
            }
            ae.i("MicroMsg.MallIndexBaseUI", "onFunctionItemClick show disclaimer funcId=%s", new Object[] { paramAnonymousMallFunction.jFZ });
            String str1 = MallIndexBaseUI.this.getString(2131761167);
            String str2 = MallIndexBaseUI.this.getString(2131755792);
            localObject2 = new WeAppOpenDeclarePromptBundle((byte)0);
            ((WeAppOpenDeclarePromptBundle)localObject2).eRn = 2;
            ((WeAppOpenDeclarePromptBundle)localObject2).jGa = str1;
            ((WeAppOpenDeclarePromptBundle)localObject2).jGb = paramAnonymousMallFunction.DsU;
            ((WeAppOpenDeclarePromptBundle)localObject2).jGc = str2;
            ((WeAppOpenDeclarePromptBundle)localObject2).ov = false;
            ((WeAppOpenDeclarePromptBundle)localObject2).jFZ = paramAnonymousMallFunction.jFZ;
            localObject1 = new Bundle();
            ((Bundle)localObject1).putParcelable("weapp_open_declare_prompt_key", (Parcelable)localObject2);
            localObject3 = MallIndexBaseUI.this;
            if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qFa, 1) != 1) {
              break label350;
            }
            i = 1;
            label176:
            if (i != 0) {
              break label355;
            }
            ae.i("MicroMsg.MallIndexBaseUI", "handleFunctionByAppBrand clicfg_appbrand_dialog_optimize_switch close");
            label187:
            i = 0;
            if (i == 0)
            {
              localObject1 = new d.a(MallIndexBaseUI.this.getContext());
              ((d.a)localObject1).aZh(str1);
              ((d.a)localObject1).aZi(paramAnonymousMallFunction.DsU);
              ((d.a)localObject1).aZo(str2).c(new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(66064);
                  ae.i("MicroMsg.MallIndexBaseUI", "onFunctionItemClick: onClick");
                  com.tencent.mm.plugin.wallet_core.model.mall.b.a.aFS(paramAnonymousMallFunction.jFZ);
                  MallIndexBaseUI.this.a(paramAnonymousMallFunction, paramAnonymousInt);
                  AppMethodBeat.o(66064);
                }
              });
              ((d.a)localObject1).zf(true);
              ((d.a)localObject1).e(new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(189876);
                  ae.i("MicroMsg.MallIndexBaseUI", "onFunctionItemClick: onCancel");
                  com.tencent.mm.plugin.wallet_core.model.mall.b.a.aFS(paramAnonymousMallFunction.jFZ);
                  AppMethodBeat.o(189876);
                }
              });
              ((d.a)localObject1).fQv().show();
            }
          }
          for (;;)
          {
            ae.d("MicroMsg.MallIndexBaseUI", "type: %s", new Object[] { Integer.valueOf(paramAnonymousMallFunction.type) });
            com.tencent.mm.plugin.report.service.g.yxI.f(14419, new Object[] { MallIndexBaseUI.this.uuid, Integer.valueOf(4), Integer.valueOf(paramAnonymousMallFunction.type) });
            AppMethodBeat.o(66065);
            return;
            i = 0;
            break;
            label350:
            i = 0;
            break label176;
            label355:
            if ((paramAnonymousMallFunction == null) || (bu.isNullOrNil(paramAnonymousMallFunction.dPb)) || (!((q)com.tencent.mm.kernel.g.ab(q.class)).n(paramAnonymousMallFunction.dPb, (Bundle)localObject1))) {
              break label187;
            }
            ae.i("MicroMsg.MallIndexBaseUI", "handleFunctionByAppBrand, intercept by AppBrandNativeLink, nativeUrl = %s", new Object[] { paramAnonymousMallFunction.dPb });
            c.eKB().aFW(paramAnonymousMallFunction.jFZ);
            com.tencent.mm.plugin.wallet_core.model.mall.d.eKF().aFW(paramAnonymousMallFunction.jFZ);
            if (paramAnonymousMallFunction.DsT != null)
            {
              c.eKB();
              c.i(paramAnonymousMallFunction);
            }
            if (paramAnonymousInt >= 0)
            {
              localObject2 = "";
              localObject1 = localObject2;
              if (paramAnonymousMallFunction.DsT != null)
              {
                localObject1 = localObject2;
                if (!bu.isNullOrNil(paramAnonymousMallFunction.DsT.ByB)) {
                  localObject1 = paramAnonymousMallFunction.DsT.ByB;
                }
              }
              if (((MallIndexBaseUI)localObject3).vPk != null) {
                break label615;
              }
              i = 0;
              label501:
              boolean bool = b.a(paramAnonymousMallFunction);
              localObject2 = com.tencent.mm.plugin.report.service.g.yxI;
              localObject3 = paramAnonymousMallFunction.jFZ;
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
              i = ((MallIndexBaseUI)localObject3).vPk.size();
              break label501;
            }
            label633:
            MallIndexBaseUI.this.a(paramAnonymousMallFunction, paramAnonymousInt);
          }
        }
        ae.w("MicroMsg.MallIndexBaseUI", "onFunctionItemClick functionItem null; pos=%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(66065);
      }
    };
    es(this.sgg);
    this.vRg = ((TextView)findViewById(2131297186));
    dno();
  }
  
  public boolean isTransparent()
  {
    return (!bu.isNullOrNil(this.vPj)) || (!bu.isNullOrNil(this.vHm));
  }
  
  public final void k(String paramString, Bitmap paramBitmap) {}
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1)
    {
      com.tencent.mm.kernel.g.ajS();
      this.vPo = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IPF, Integer.valueOf(0))).intValue();
      if (paramInt2 == -1)
      {
        if (!v.aAS()) {
          break label51;
        }
        finish();
      }
    }
    return;
    label51:
    finish();
    paramIntent = new rh();
    paramIntent.dGV.context = getContext();
    com.tencent.mm.sdk.b.a.IvT.l(paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    ae.i("MicroMsg.MallIndexBaseUI", "onCreate");
    super.onCreate(paramBundle);
    if (!com.tencent.mm.kernel.g.ajM())
    {
      ae.v("MicroMsg.MallIndexBaseUI", "MMCore is not ready");
      finish();
    }
    com.tencent.mm.kernel.g.ajS();
    int i = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IPF, Integer.valueOf(0))).intValue();
    this.vPo = getIntent().getIntExtra("key_wallet_region", i);
    this.uuid = getIntent().getStringExtra("key_uuid");
    if (bu.isNullOrNil(this.uuid)) {
      this.uuid = UUID.randomUUID().toString();
    }
    addSceneEndListener(495);
    com.tencent.mm.plugin.wallet_core.model.t.eJm();
    ah.a(this);
    this.vPj = getIntent().getStringExtra("key_func_id");
    ae.i("MicroMsg.MallIndexBaseUI", "mFuncId:" + this.vPj + " wallet_region: " + this.vPo + " walletType: " + v.aAJ() + " default_region: " + i);
    this.vHm = getIntent().getStringExtra("key_native_url");
    ae.i("MicroMsg.MallIndexBaseUI", "mNativeUrl:" + this.vHm);
    if (isTransparent()) {
      return;
    }
    deV();
    setContentViewVisibility(0);
    ae.i("MicroMsg.MallIndexBaseUI", "index Oncreate");
    dng();
    initView();
    c.eKE();
    dnh();
    ae.i("MicroMsg.MallIndexBaseUI", "hy: use default controller for MallIndexUI");
    dni();
    if (v.aAR()) {
      ae.e("MicroMsg.MallIndexBaseUI", "it is payu account ,not initFingerPrint");
    }
    for (;;)
    {
      ab.kI(1, 0);
      com.tencent.mm.plugin.report.service.g.yxI.f(11850, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
      return;
      paramBundle = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
      if (paramBundle != null)
      {
        ae.i("MicroMsg.MallIndexBaseUI", "IFingerPrintMgr is not null, do showFingerPrintEntrance()");
        paramBundle.cRS();
      }
      else
      {
        ae.e("MicroMsg.MallIndexBaseUI", "IFingerPrintMgr is not null");
      }
    }
  }
  
  public void onDestroy()
  {
    removeSceneEndListener(495);
    com.tencent.mm.plugin.wallet_core.model.t.eJm();
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
    com.tencent.mm.pluginsdk.wallet.h.aad(1);
    ae.i("MicroMsg.MallIndexBaseUI", "index onResume");
    if (!com.tencent.mm.kernel.g.ajM())
    {
      ae.v("MicroMsg.MallIndexBaseUI", "MMCore is not ready");
      finish();
    }
    if (isTransparent())
    {
      this.vPk = com.tencent.mm.plugin.mall.a.k.dmZ().Kc(this.vPo);
      if ((this.vPk == null) || (this.vPk.size() <= 0))
      {
        ae.i("MicroMsg.MallIndexBaseUI", "mFunctionList == null");
        try
        {
          if ((getIntent().getIntExtra("key_scene", 0) == 1) || (!bu.isNullOrNil(this.vHm)))
          {
            doSceneForceProgress(new com.tencent.mm.plugin.mall.a.f(this.vPo, com.tencent.mm.plugin.wallet_core.model.mall.b.eKt(), 0));
            return;
          }
          localObject3 = getIntent().getStringExtra("key_url");
          Object localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = "";
          }
          doSceneForceProgress(new com.tencent.mm.plugin.mall.a.f(this.vPo, com.tencent.mm.plugin.wallet_core.model.mall.b.eKt(), getIntent().getStringExtra("key_app_id"), this.vPj, (String)localObject1));
          return;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          ae.printErrStackTrace("MicroMsg.MallIndexBaseUI", localUnsupportedEncodingException, "", new Object[0]);
          dnm();
          return;
        }
      }
      Object localObject3 = ey(this.vPk);
      Object localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = ez(this.vPk);
      }
      a((MallFunction)localObject2, -1);
      finish();
      return;
    }
    dnj();
    ae.d("MicroMsg.MallIndexBaseUI", "initFunctionList");
    if (com.tencent.mm.plugin.mall.a.k.dmZ().Kc(this.vPo) == null)
    {
      doSceneProgress(new com.tencent.mm.plugin.mall.a.f(this.vPo, com.tencent.mm.plugin.wallet_core.model.mall.b.eKt(), 0), true);
      ae.e("MicroMsg.MallIndexBaseUI", "funcitonlist invalid");
      i = 0;
    }
    while (i != 0)
    {
      ae.i("MicroMsg.MallIndexBaseUI", "has data");
      updateView();
      return;
      doSceneProgress(new com.tencent.mm.plugin.mall.a.f(this.vPo, com.tencent.mm.plugin.wallet_core.model.mall.b.eKt(), 1), false);
      this.vPk = com.tencent.mm.plugin.mall.a.k.dmZ().Kc(this.vPo);
    }
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    ae.d("MicroMsg.MallIndexBaseUI", "onOtherSceneEnd");
    if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.b.a))
    {
      ae.d("MicroMsg.MallIndexBaseUI", "hy: query bound scene end");
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (this.vRi)
        {
          this.vRi = false;
          if (com.tencent.mm.plugin.wallet_core.model.t.eJa().eKO().eJJ())
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
    if (paramString.vPo != this.vPo) {
      ae.i("MicroMsg.MallIndexBaseUI", "pass wallet local: %d cgi: %d", new Object[] { Integer.valueOf(this.vPo), Integer.valueOf(paramString.vPo) });
    }
    if (isTransparent())
    {
      ae.d("MicroMsg.MallIndexBaseUI", "errorType:%d | errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if ((paramInt1 == 0) && (paramInt2 == 0) && (paramString.vPk != null)) {
        if (getIntent().getIntExtra("key_scene", 0) == 1)
        {
          paramString = ey(paramString.vPk);
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
      if (!bu.isNullOrNil(this.vHm))
      {
        ae.d("MicroMsg.MallIndexBaseUI", "NativeUrl: %s", new Object[] { this.vHm });
        paramString = ez(paramString.vPk);
        if (paramString != null)
        {
          a(paramString, -1);
          break;
        }
        dnm();
        return true;
      }
      if ((paramString.vPk != null) && (paramString.vPk.size() > 0))
      {
        ae.i("MicroMsg.MallIndexBaseUI", "functionScene.mFunctionList != null");
        a(ey(paramString.vPk), -1);
        break;
      }
      if ((com.tencent.mm.plugin.mall.a.k.dmZ().Kc(this.vPo) != null) && (com.tencent.mm.plugin.mall.a.k.dmZ().Kc(this.vPo).size() > 0))
      {
        ae.i("MicroMsg.MallIndexBaseUI", "SubCoreMall.getCore().getFunctionList() != null");
        a(ey(com.tencent.mm.plugin.mall.a.k.dmZ().Kc(this.vPo)), -1);
        break;
      }
      ae.e("MicroMsg.MallIndexBaseUI", "SubCoreMall.getCore().getFunctionList() == null");
      break;
      dnm();
      continue;
      if ((paramInt1 == 0) && (paramInt2 == 0) && (com.tencent.mm.plugin.mall.a.k.dmZ().Kc(this.vPo) != null) && (paramString.vPk != null))
      {
        this.vPk = com.tencent.mm.plugin.mall.a.k.dmZ().Kc(this.vPo);
        ae.i("MicroMsg.MallIndexBaseUI", "get from server now! " + this.vPo + " " + this.vPk.size());
        c.eKB().aE(this.vPk);
        if (!bu.ht(this.vPk))
        {
          paramString = new LinkedList();
          paramn = this.vPk.iterator();
          while (paramn.hasNext())
          {
            MallFunction localMallFunction = (MallFunction)paramn.next();
            if (!bu.isNullOrNil(localMallFunction.dPb)) {
              paramString.add(localMallFunction.dPb);
            }
          }
          if (!bu.ht(paramString))
          {
            paramn = (s)com.tencent.mm.kernel.g.ab(s.class);
            if (paramn != null) {
              paramn.aW(paramString);
            }
          }
        }
      }
      updateView();
      dnl();
      dnn();
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
    this.vRc.aj(this.vPk);
    dnr();
    dns();
    dnt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexBaseUI
 * JD-Core Version:    0.7.0.1
 */