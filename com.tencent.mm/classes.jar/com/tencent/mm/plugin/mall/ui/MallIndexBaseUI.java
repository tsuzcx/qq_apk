package com.tencent.mm.plugin.mall.ui;

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
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.ut;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.appbrand.api.WeAppOpenDeclarePromptBundle;
import com.tencent.mm.plugin.appbrand.service.y;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.plugin.wallet_core.model.l;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wallet_core.model.mall.b.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.f.s;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.wallet_core.model.ac;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.i;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public abstract class MallIndexBaseUI
  extends WalletBaseUI
  implements r.a, l
{
  private static final String KKT = "https://" + WeChatHosts.domainString(a.i.host_kf_qq_com) + "/touch/scene_product.html?scene_id=kf1";
  protected View Fag;
  private String KJc = null;
  ArrayList<MallFunction> KJd = null;
  protected int KJh;
  private TextView KKU = null;
  protected ListView KKV = null;
  private b KKW = null;
  protected ImageView KKX = null;
  protected ImageView KKY;
  protected TextView KKZ = null;
  protected TextView KLa;
  private int KLb = 0;
  private boolean KLc = true;
  protected int KLd;
  protected View KLe;
  private boolean KLf = false;
  private String Kra = null;
  protected String uuid;
  
  private void fZn()
  {
    boolean bool = getIntent().getBooleanExtra("key_wallet_has_red", false);
    if (this.KKV.getChildCount() == 0) {}
    label404:
    for (;;)
    {
      return;
      int i = this.KKV.getFirstVisiblePosition();
      int j = this.KKV.getChildAt(0).getTop();
      Log.i("MicroMsg.MallIndexBaseUI", "initCheckNew %s fpos %s top %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j) });
      if ((i == 0) && (j == 0) && (bool) && (!this.KLf) && (this.KJd != null))
      {
        this.KLf = true;
        int k = this.KKV.getHeaderViewsCount() + this.KKW.getCount();
        List localList = this.KKW.KJR;
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
                if ((localc != null) && (localc.KKv != null) && (b.a(localc.KKv)))
                {
                  i = this.KKV.getFirstVisiblePosition();
                  j = this.KKV.getLastVisiblePosition();
                  Log.i("MicroMsg.MallIndexBaseUI", "get listview show top %s bottom %s redPos: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
                  if ((k >= i) && (k <= j)) {
                    break;
                  }
                  int m = a.fZe();
                  j = a.fZd() + a.fZc() * (k + 1) + m;
                  i = j;
                  if (k > 2) {
                    i = j + m;
                  }
                  j = i;
                  if (k > 3) {
                    j = i + m;
                  }
                  m = a.fZc() / 3;
                  int n = this.KKV.getScrollY();
                  k = aw.bf(this).y;
                  i = k;
                  if (aw.bg(this)) {
                    i = k - aw.bk(this);
                  }
                  k = i;
                  if (getSupportActionBar() != null) {
                    k = i - getSupportActionBar().getHeight();
                  }
                  this.KKV.smoothScrollBy(j + m - n - k, 1000);
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
  
  private void fZo()
  {
    setResult(0);
    finish();
  }
  
  private void fZs()
  {
    if (z.bBi())
    {
      com.tencent.mm.wallet_core.a.b(getContext(), "PayURemittanceProcess", null);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("pay_channel", 1);
    com.tencent.mm.wallet_core.a.b(getContext(), "RemittanceProcess", localBundle);
  }
  
  private void fZu()
  {
    if (this.KKU != null) {
      this.KKU.setVisibility(8);
    }
  }
  
  private MallFunction iS(List<MallFunction> paramList)
  {
    Object localObject;
    if ((paramList == null) || (paramList.size() == 0) || (TextUtils.isEmpty(this.KJc)))
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
        if (this.KJc.equals(localMallFunction.qBb)) {
          break;
        }
      }
      i += 1;
    }
    label81:
    return null;
  }
  
  private MallFunction iT(List<MallFunction> paramList)
  {
    Object localObject;
    if ((paramList == null) || (paramList.size() == 0) || (TextUtils.isEmpty(this.Kra)))
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
        if (this.Kra.equals(localMallFunction.ihx)) {
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
      if (paramMallFunction.VKI != null)
      {
        localObject1 = localObject2;
        if (!Util.isNullOrNil(paramMallFunction.VKI.rBJ)) {
          localObject1 = paramMallFunction.VKI.rBJ;
        }
      }
      if (this.KJd != null) {
        break label261;
      }
      i = 0;
      boolean bool = b.a(paramMallFunction);
      localObject2 = com.tencent.mm.plugin.report.service.h.OAn;
      str = paramMallFunction.qBb;
      if (!bool) {
        break label272;
      }
    }
    label261:
    label272:
    for (int j = 2;; j = 1)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject2).b(10881, new Object[] { str, Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(paramInt), localObject1, Integer.valueOf(j), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
      if ((paramMallFunction == null) || (Util.isNullOrNil(paramMallFunction.ihx)) || (!((com.tencent.mm.plugin.appbrand.service.u)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.u.class)).s(paramMallFunction.ihx, null))) {
        break label278;
      }
      Log.i("MicroMsg.MallIndexBaseUI", "handleFunction, intercept by AppBrandNativeLink, nativeUrl = %s", new Object[] { paramMallFunction.ihx });
      com.tencent.mm.plugin.wallet_core.model.mall.c.ikd().bgO(paramMallFunction.qBb);
      com.tencent.mm.plugin.wallet_core.model.mall.d.ikh().bgO(paramMallFunction.qBb);
      if (paramMallFunction.VKI != null)
      {
        com.tencent.mm.plugin.wallet_core.model.mall.c.ikd();
        com.tencent.mm.plugin.wallet_core.model.mall.c.i(paramMallFunction);
      }
      return;
      i = this.KJd.size();
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
      ac.pu(15, 0);
      return;
    case 4: 
      com.tencent.mm.plugin.report.service.h.OAn.b(11701, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
      paramMallFunction = new Intent();
      paramMallFunction.putExtra("pay_channel", 1);
      com.tencent.mm.br.c.b(this, "luckymoney", ".ui.LuckyMoneyIndexUI", paramMallFunction);
      ac.pu(13, 0);
      com.tencent.mm.plugin.report.service.h.OAn.b(11850, new Object[] { Integer.valueOf(4), Integer.valueOf(0) });
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
      com.tencent.mm.kernel.h.baF();
      this.KJh = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acNa, Integer.valueOf(0))).intValue();
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("rawUrl", paramMallFunction.h5Url);
      ((Intent)localObject1).putExtra("geta8key_username", z.bAM());
      ((Intent)localObject1).putExtra("pay_channel", 1);
      ((Intent)localObject1).putExtra("KPublisherId", "pay_wallet");
      ((Intent)localObject1).putExtra("key_download_restrict", paramMallFunction.VKK);
      ((Intent)localObject1).putExtra("key_wallet_region", this.KJh);
      ((Intent)localObject1).putExtra("key_function_id", paramMallFunction.qBb);
      ((Intent)localObject1).putExtra(f.s.adxf, true);
      ((Intent)localObject1).putExtra("geta8key_scene", 46);
      i.aS(getContext(), (Intent)localObject1);
      return;
    case 2: 
      Log.w("MicroMsg.MallIndexBaseUI", "doSelectFunction no jump");
      return;
    case 3: 
      Log.w("MicroMsg.MallIndexBaseUI", "doSelectFunction do nothing");
      aa.makeText(this, "fuction list error", 1).show();
      return;
    case 5: 
      com.tencent.mm.plugin.report.service.h.OAn.b(11458, new Object[] { Integer.valueOf(1) });
      if (z.bBi())
      {
        paramMallFunction = new LinkedList();
        localObject1 = new LinkedList();
        paramMallFunction.add(getString(a.i.remittance_title));
        ((List)localObject1).add(Integer.valueOf(0));
        paramMallFunction.add(getString(a.i.collect_title));
        ((List)localObject1).add(Integer.valueOf(1));
        com.tencent.mm.ui.base.k.b(this, getString(a.i.remittance_collect_title), paramMallFunction, (List)localObject1, null, new MallIndexBaseUI.3(this));
      }
      for (;;)
      {
        ac.pu(14, 0);
        com.tencent.mm.plugin.report.service.h.OAn.b(11850, new Object[] { Integer.valueOf(3), Integer.valueOf(0) });
        return;
        com.tencent.mm.kernel.h.baF();
        if (!((Boolean)com.tencent.mm.kernel.h.baE().ban().get(at.a.acIY, Boolean.FALSE)).booleanValue())
        {
          com.tencent.mm.kernel.h.baF();
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acIY, Boolean.TRUE);
          com.tencent.mm.ui.base.k.d(this, getString(a.i.wallet_index_ui_ftf_notice), "", new MallIndexBaseUI.4(this));
        }
        else
        {
          fZs();
        }
      }
    case 6: 
      paramMallFunction = new Intent();
      paramMallFunction.putExtra("key_from_scene", 1);
      com.tencent.mm.br.c.b(getContext(), "offline", ".ui.WalletOfflineEntranceUI", paramMallFunction);
      ac.pu(9, 0);
      com.tencent.mm.plugin.report.service.h.OAn.b(11850, new Object[] { Integer.valueOf(5), Integer.valueOf(0) });
      return;
    case 8: 
      paramMallFunction = new Intent();
      paramMallFunction.putExtra("BaseScanUI_select_scan_mode", 1);
      paramMallFunction.putExtra("key_scan_report_enter_scene", 3);
      com.tencent.mm.br.c.b(getContext(), "scanner", ".ui.BaseScanUI", paramMallFunction);
      return;
    }
    com.tencent.mm.br.c.ai(getContext(), "luckymoney", ".f2f.ui.LuckyMoneyF2FQRCodeUI");
  }
  
  public boolean checkProcLife()
  {
    return false;
  }
  
  protected abstract void fPx();
  
  protected abstract void fZi();
  
  protected abstract void fZj();
  
  protected abstract void fZk();
  
  protected abstract boolean fZl();
  
  protected abstract void fZm();
  
  protected abstract void fZp();
  
  protected abstract void fZq();
  
  protected abstract void fZr();
  
  protected abstract void fZt();
  
  protected abstract void fZv();
  
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
    return a.g.mall_index_ui;
  }
  
  protected abstract void ib(View paramView);
  
  protected abstract void initHeaderView();
  
  public void initView()
  {
    Log.d("MicroMsg.MallIndexBaseUI", "index initView");
    setBackBtn(new MallIndexBaseUI.1(this));
    this.KKV = ((ListView)findViewById(a.f.mall_index_function_list));
    initHeaderView();
    fZp();
    this.KKW = new b(this, this.KJh);
    this.KKV.setAdapter(this.KKW);
    this.KKW.KJS = new b.d()
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
          if ((!b.a.bgL(paramAnonymousMallFunction.qBb)) && (!Util.isNullOrNil(paramAnonymousMallFunction.VKJ)))
          {
            i = 1;
            if (i == 0) {
              break label635;
            }
            Log.i("MicroMsg.MallIndexBaseUI", "onFunctionItemClick show disclaimer funcId=%s", new Object[] { paramAnonymousMallFunction.qBb });
            String str1 = MallIndexBaseUI.this.getString(a.i.mall_third_party_disclaimer_title);
            String str2 = MallIndexBaseUI.this.getString(a.i.app_i_know);
            localObject2 = new WeAppOpenDeclarePromptBundle((byte)0);
            ((WeAppOpenDeclarePromptBundle)localObject2).hyY = 2;
            ((WeAppOpenDeclarePromptBundle)localObject2).qBc = str1;
            ((WeAppOpenDeclarePromptBundle)localObject2).qBd = paramAnonymousMallFunction.VKJ;
            ((WeAppOpenDeclarePromptBundle)localObject2).qBe = str2;
            ((WeAppOpenDeclarePromptBundle)localObject2).dqR = false;
            ((WeAppOpenDeclarePromptBundle)localObject2).qBb = paramAnonymousMallFunction.qBb;
            localObject1 = new Bundle();
            ((Bundle)localObject1).putParcelable("weapp_open_declare_prompt_key", (Parcelable)localObject2);
            localObject3 = MallIndexBaseUI.this;
            if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yUB, 1) != 1) {
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
              localObject1 = new e.a(MallIndexBaseUI.this.getContext());
              ((e.a)localObject1).bDv(str1);
              ((e.a)localObject1).bDw(paramAnonymousMallFunction.VKJ);
              ((e.a)localObject1).bDC(str2).c(new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(66064);
                  Log.i("MicroMsg.MallIndexBaseUI", "onFunctionItemClick: onClick");
                  b.a.bgK(paramAnonymousMallFunction.qBb);
                  MallIndexBaseUI.this.a(paramAnonymousMallFunction, paramAnonymousInt);
                  AppMethodBeat.o(66064);
                }
              });
              ((e.a)localObject1).NC(true);
              ((e.a)localObject1).e(new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(262390);
                  Log.i("MicroMsg.MallIndexBaseUI", "onFunctionItemClick: onCancel");
                  b.a.bgK(paramAnonymousMallFunction.qBb);
                  AppMethodBeat.o(262390);
                }
              });
              ((e.a)localObject1).jHH().show();
            }
          }
          for (;;)
          {
            Log.d("MicroMsg.MallIndexBaseUI", "type: %s", new Object[] { Integer.valueOf(paramAnonymousMallFunction.type) });
            com.tencent.mm.plugin.report.service.h.OAn.b(14419, new Object[] { MallIndexBaseUI.this.uuid, Integer.valueOf(4), Integer.valueOf(paramAnonymousMallFunction.type) });
            AppMethodBeat.o(66065);
            return;
            i = 0;
            break;
            label352:
            i = 0;
            break label178;
            label357:
            if ((paramAnonymousMallFunction == null) || (Util.isNullOrNil(paramAnonymousMallFunction.ihx)) || (!((com.tencent.mm.plugin.appbrand.service.u)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.u.class)).s(paramAnonymousMallFunction.ihx, (Bundle)localObject1))) {
              break label189;
            }
            Log.i("MicroMsg.MallIndexBaseUI", "handleFunctionByAppBrand, intercept by AppBrandNativeLink, nativeUrl = %s", new Object[] { paramAnonymousMallFunction.ihx });
            com.tencent.mm.plugin.wallet_core.model.mall.c.ikd().bgO(paramAnonymousMallFunction.qBb);
            com.tencent.mm.plugin.wallet_core.model.mall.d.ikh().bgO(paramAnonymousMallFunction.qBb);
            if (paramAnonymousMallFunction.VKI != null)
            {
              com.tencent.mm.plugin.wallet_core.model.mall.c.ikd();
              com.tencent.mm.plugin.wallet_core.model.mall.c.i(paramAnonymousMallFunction);
            }
            if (paramAnonymousInt >= 0)
            {
              localObject2 = "";
              localObject1 = localObject2;
              if (paramAnonymousMallFunction.VKI != null)
              {
                localObject1 = localObject2;
                if (!Util.isNullOrNil(paramAnonymousMallFunction.VKI.rBJ)) {
                  localObject1 = paramAnonymousMallFunction.VKI.rBJ;
                }
              }
              if (((MallIndexBaseUI)localObject3).KJd != null) {
                break label617;
              }
              i = 0;
              label503:
              boolean bool = b.a(paramAnonymousMallFunction);
              localObject2 = com.tencent.mm.plugin.report.service.h.OAn;
              localObject3 = paramAnonymousMallFunction.qBb;
              if (!bool) {
                break label629;
              }
            }
            label617:
            label629:
            for (int j = 2;; j = 1)
            {
              ((com.tencent.mm.plugin.report.service.h)localObject2).b(10881, new Object[] { localObject3, Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(paramAnonymousInt), localObject1, Integer.valueOf(j), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
              i = 1;
              break;
              i = ((MallIndexBaseUI)localObject3).KJd.size();
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
    ib(this.Fag);
    this.KLa = ((TextView)findViewById(a.f.banner_tips));
    fZq();
  }
  
  public boolean isTransparent()
  {
    return (!Util.isNullOrNil(this.KJc)) || (!Util.isNullOrNil(this.Kra));
  }
  
  public final void j(int paramInt, Object[] paramArrayOfObject)
  {
    if ((paramInt == 12) && (this.KKZ != null)) {
      fZr();
    }
  }
  
  public final void k(String paramString, Bitmap paramBitmap) {}
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1)
    {
      com.tencent.mm.kernel.h.baF();
      this.KJh = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acNa, Integer.valueOf(0))).intValue();
      if (paramInt2 == -1)
      {
        if (!z.bBj()) {
          break label51;
        }
        finish();
      }
    }
    return;
    label51:
    finish();
    paramIntent = new ut();
    paramIntent.hYw.context = getContext();
    paramIntent.publish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Log.i("MicroMsg.MallIndexBaseUI", "onCreate");
    super.onCreate(paramBundle);
    if (!com.tencent.mm.kernel.h.baz())
    {
      Log.v("MicroMsg.MallIndexBaseUI", "MMCore is not ready");
      finish();
    }
    com.tencent.mm.kernel.h.baF();
    int i = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acNa, Integer.valueOf(0))).intValue();
    this.KJh = getIntent().getIntExtra("key_wallet_region", i);
    this.uuid = getIntent().getStringExtra("key_uuid");
    if (Util.isNullOrNil(this.uuid)) {
      this.uuid = UUID.randomUUID().toString();
    }
    addSceneEndListener(495);
    com.tencent.mm.plugin.wallet_core.model.u.iiJ();
    ag.a(this);
    this.KJc = getIntent().getStringExtra("key_func_id");
    Log.i("MicroMsg.MallIndexBaseUI", "mFuncId:" + this.KJc + " wallet_region: " + this.KJh + " walletType: " + z.bAV() + " default_region: " + i);
    this.Kra = getIntent().getStringExtra("key_native_url");
    Log.i("MicroMsg.MallIndexBaseUI", "mNativeUrl:" + this.Kra);
    if (isTransparent()) {
      return;
    }
    fPx();
    setContentViewVisibility(0);
    Log.i("MicroMsg.MallIndexBaseUI", "index Oncreate");
    fZi();
    initView();
    com.tencent.mm.plugin.wallet_core.model.mall.c.ikg();
    fZj();
    Log.i("MicroMsg.MallIndexBaseUI", "hy: use default controller for MallIndexUI");
    fZk();
    if (z.bBi()) {
      Log.e("MicroMsg.MallIndexBaseUI", "it is payu account ,not initFingerPrint");
    }
    for (;;)
    {
      ac.pu(1, 0);
      com.tencent.mm.plugin.report.service.h.OAn.b(11850, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
      return;
      paramBundle = (com.tencent.mm.plugin.fingerprint.c.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.fingerprint.c.a.class);
      if (paramBundle != null)
      {
        Log.i("MicroMsg.MallIndexBaseUI", "IFingerPrintMgr is not null, do showFingerPrintEntrance()");
        paramBundle.ftp();
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
    com.tencent.mm.plugin.wallet_core.model.u.iiJ();
    ag.b(this);
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
    if (!com.tencent.mm.kernel.h.baz())
    {
      Log.v("MicroMsg.MallIndexBaseUI", "MMCore is not ready");
      finish();
    }
    if (isTransparent())
    {
      this.KJd = com.tencent.mm.plugin.mall.a.k.fZb().aam(this.KJh);
      if ((this.KJd == null) || (this.KJd.size() <= 0))
      {
        Log.i("MicroMsg.MallIndexBaseUI", "mFunctionList == null");
        try
        {
          if ((getIntent().getIntExtra("key_scene", 0) == 1) || (!Util.isNullOrNil(this.Kra)))
          {
            doSceneForceProgress(new com.tencent.mm.plugin.mall.a.f(this.KJh, com.tencent.mm.plugin.wallet_core.model.mall.b.ijV(), 0));
            return;
          }
          localObject3 = getIntent().getStringExtra("key_url");
          Object localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = "";
          }
          doSceneForceProgress(new com.tencent.mm.plugin.mall.a.f(this.KJh, com.tencent.mm.plugin.wallet_core.model.mall.b.ijV(), getIntent().getStringExtra("key_app_id"), this.KJc, (String)localObject1));
          return;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          Log.printErrStackTrace("MicroMsg.MallIndexBaseUI", localUnsupportedEncodingException, "", new Object[0]);
          fZo();
          return;
        }
      }
      Object localObject3 = iS(this.KJd);
      Object localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = iT(this.KJd);
      }
      a((MallFunction)localObject2, -1);
      finish();
      return;
    }
    fZl();
    Log.d("MicroMsg.MallIndexBaseUI", "initFunctionList");
    if (com.tencent.mm.plugin.mall.a.k.fZb().aam(this.KJh) == null)
    {
      doSceneProgress(new com.tencent.mm.plugin.mall.a.f(this.KJh, com.tencent.mm.plugin.wallet_core.model.mall.b.ijV(), 0), true);
      Log.e("MicroMsg.MallIndexBaseUI", "funcitonlist invalid");
      i = 0;
    }
    while (i != 0)
    {
      Log.i("MicroMsg.MallIndexBaseUI", "has data");
      updateView();
      return;
      doSceneProgress(new com.tencent.mm.plugin.mall.a.f(this.KJh, com.tencent.mm.plugin.wallet_core.model.mall.b.ijV(), 1), false);
      this.KJd = com.tencent.mm.plugin.mall.a.k.fZb().aam(this.KJh);
    }
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    Log.d("MicroMsg.MallIndexBaseUI", "onOtherSceneEnd");
    if ((paramp instanceof com.tencent.mm.plugin.wallet_core.c.b.a))
    {
      Log.d("MicroMsg.MallIndexBaseUI", "hy: query bound scene end");
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (this.KLc)
        {
          this.KLc = false;
          if (com.tencent.mm.plugin.wallet_core.model.u.iix().ijK().ijh())
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
    switch (paramp.getType())
    {
    default: 
      return false;
    }
    paramString = (com.tencent.mm.plugin.mall.a.f)paramp;
    if (paramString.KJh != this.KJh) {
      Log.i("MicroMsg.MallIndexBaseUI", "pass wallet local: %d cgi: %d", new Object[] { Integer.valueOf(this.KJh), Integer.valueOf(paramString.KJh) });
    }
    if (isTransparent())
    {
      Log.d("MicroMsg.MallIndexBaseUI", "errorType:%d | errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if ((paramInt1 == 0) && (paramInt2 == 0) && (paramString.KJd != null)) {
        if (getIntent().getIntExtra("key_scene", 0) == 1)
        {
          paramString = iS(paramString.KJd);
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
      if (!Util.isNullOrNil(this.Kra))
      {
        Log.d("MicroMsg.MallIndexBaseUI", "NativeUrl: %s", new Object[] { this.Kra });
        paramString = iT(paramString.KJd);
        if (paramString != null)
        {
          a(paramString, -1);
          break;
        }
        fZo();
        return true;
      }
      if ((paramString.KJd != null) && (paramString.KJd.size() > 0))
      {
        Log.i("MicroMsg.MallIndexBaseUI", "functionScene.mFunctionList != null");
        a(iS(paramString.KJd), -1);
        break;
      }
      if ((com.tencent.mm.plugin.mall.a.k.fZb().aam(this.KJh) != null) && (com.tencent.mm.plugin.mall.a.k.fZb().aam(this.KJh).size() > 0))
      {
        Log.i("MicroMsg.MallIndexBaseUI", "SubCoreMall.getCore().getFunctionList() != null");
        a(iS(com.tencent.mm.plugin.mall.a.k.fZb().aam(this.KJh)), -1);
        break;
      }
      Log.e("MicroMsg.MallIndexBaseUI", "SubCoreMall.getCore().getFunctionList() == null");
      break;
      fZo();
      continue;
      if ((paramInt1 == 0) && (paramInt2 == 0) && (com.tencent.mm.plugin.mall.a.k.fZb().aam(this.KJh) != null) && (paramString.KJd != null))
      {
        this.KJd = com.tencent.mm.plugin.mall.a.k.fZb().aam(this.KJh);
        Log.i("MicroMsg.MallIndexBaseUI", "get from server now! " + this.KJh + " " + this.KJd.size());
        com.tencent.mm.plugin.wallet_core.model.mall.c.ikd().bL(this.KJd);
        if (!Util.isNullOrNil(this.KJd))
        {
          paramString = new LinkedList();
          paramp = this.KJd.iterator();
          while (paramp.hasNext())
          {
            MallFunction localMallFunction = (MallFunction)paramp.next();
            if (!Util.isNullOrNil(localMallFunction.ihx)) {
              paramString.add(localMallFunction.ihx);
            }
          }
          if (!Util.isNullOrNil(paramString))
          {
            paramp = (y)com.tencent.mm.kernel.h.ax(y.class);
            if (paramp != null) {
              paramp.cM(paramString);
            }
          }
        }
      }
      updateView();
      fZn();
      fZp();
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
    this.KKW.aX(this.KJd);
    fZt();
    fZu();
    fZv();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexBaseUI
 * JD-Core Version:    0.7.0.1
 */