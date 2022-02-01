package com.tencent.mm.plugin.mall.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.qm;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.plugin.mall.a.f;
import com.tencent.mm.plugin.mall.a.j;
import com.tencent.mm.plugin.wallet_core.d.k;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.plugin.wallet_core.model.l;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.e.m;
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
  protected View qwn;
  private String tkm = null;
  private String tsj = null;
  private ArrayList<MallFunction> tsk = null;
  protected int tso;
  private TextView ttQ = null;
  protected ListView ttR = null;
  private b ttS = null;
  protected ImageView ttT = null;
  protected ImageView ttU;
  protected TextView ttV = null;
  protected TextView ttW;
  private int ttX = 0;
  private boolean ttY = true;
  protected int ttZ;
  protected View tua;
  private boolean tub = false;
  protected String uuid;
  
  private void cNq()
  {
    boolean bool = getIntent().getBooleanExtra("key_wallet_has_red", false);
    if (this.ttR.getChildCount() == 0) {}
    label404:
    for (;;)
    {
      return;
      int i = this.ttR.getFirstVisiblePosition();
      int j = this.ttR.getChildAt(0).getTop();
      ad.i("MicroMsg.MallIndexBaseUI", "initCheckNew %s fpos %s top %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j) });
      if ((i == 0) && (j == 0) && (bool) && (!this.tub) && (this.tsk != null))
      {
        this.tub = true;
        int k = this.ttR.getHeaderViewsCount() + this.ttS.getCount();
        List localList = this.ttS.tsW;
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
                if ((localc != null) && (localc.ttA != null) && (b.a(localc.ttA)))
                {
                  i = this.ttR.getFirstVisiblePosition();
                  j = this.ttR.getLastVisiblePosition();
                  ad.i("MicroMsg.MallIndexBaseUI", "get listview show top %s bottom %s redPos: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
                  if ((k >= i) && (k <= j)) {
                    break;
                  }
                  int m = a.cNj();
                  j = a.cNi() + a.cNh() * (k + 1) + m;
                  i = j;
                  if (k > 2) {
                    i = j + m;
                  }
                  j = i;
                  if (k > 3) {
                    j = i + m;
                  }
                  m = a.cNh() / 3;
                  int n = this.ttR.getScrollY();
                  k = ai.cf(this).y;
                  i = k;
                  if (ai.ju(this)) {
                    i = k - ai.eb(this);
                  }
                  k = i;
                  if (getSupportActionBar() != null) {
                    k = i - getSupportActionBar().getHeight();
                  }
                  this.ttR.smoothScrollBy(j + m - n - k, 1000);
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
  
  private void cNr()
  {
    setResult(0);
    finish();
  }
  
  private void cNv()
  {
    if (u.aqV())
    {
      com.tencent.mm.wallet_core.a.b(getContext(), "PayURemittanceProcess", null);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("pay_channel", 1);
    com.tencent.mm.wallet_core.a.b(getContext(), "RemittanceProcess", localBundle);
  }
  
  private void cNx()
  {
    if (this.ttQ != null) {
      this.ttQ.setVisibility(8);
    }
  }
  
  private MallFunction ed(List<MallFunction> paramList)
  {
    Object localObject;
    if ((paramList == null) || (paramList.size() == 0) || (TextUtils.isEmpty(this.tsj)))
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
        if (this.tsj.equals(localMallFunction.uWF)) {
          break;
        }
      }
      i += 1;
    }
    label81:
    return null;
  }
  
  private MallFunction ee(List<MallFunction> paramList)
  {
    Object localObject;
    if ((paramList == null) || (paramList.size() == 0) || (TextUtils.isEmpty(this.tkm)))
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
        if (this.tkm.equals(localMallFunction.dDM)) {
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
      if (paramMallFunction.AiC != null)
      {
        localObject1 = localObject2;
        if (!bt.isNullOrNil(paramMallFunction.AiC.yCo)) {
          localObject1 = paramMallFunction.AiC.yCo;
        }
      }
      if (this.tsk != null) {
        break label228;
      }
      i = 0;
      boolean bool = b.a(paramMallFunction);
      localObject2 = com.tencent.mm.plugin.report.service.h.vKh;
      str = paramMallFunction.uWF;
      if (!bool) {
        break label239;
      }
    }
    label228:
    label239:
    for (int j = 2;; j = 1)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject2).f(10881, new Object[] { str, Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(paramInt), localObject1, Integer.valueOf(j) });
      if ((paramMallFunction == null) || (bt.isNullOrNil(paramMallFunction.dDM)) || (!((o)g.ab(o.class)).Kr(paramMallFunction.dDM))) {
        break label245;
      }
      ad.i("MicroMsg.MallIndexBaseUI", "handleFunction, intercept by AppBrandNativeLink, nativeUrl = %s", new Object[] { paramMallFunction.dDM });
      c.eds().aua(paramMallFunction.uWF);
      com.tencent.mm.plugin.wallet_core.model.mall.d.edw().aua(paramMallFunction.uWF);
      if (paramMallFunction.AiC != null)
      {
        c.eds();
        c.e(paramMallFunction);
      }
      return;
      i = this.tsk.size();
      break;
    }
    label245:
    if (paramMallFunction != null)
    {
      c.eds().aua(paramMallFunction.uWF);
      com.tencent.mm.plugin.wallet_core.model.mall.d.edw().aua(paramMallFunction.uWF);
      if (paramMallFunction.AiC != null)
      {
        c.eds();
        c.e(paramMallFunction);
      }
      if ("wxpay://bizmall/mobile_recharge".equals(paramMallFunction.dDM)) {
        paramInt = 0;
      }
    }
    for (;;)
    {
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
        com.tencent.mm.wallet_core.c.ab.jZ(15, 0);
        return;
        if ("wxpay://bizmall/weixin_hongbao".equals(paramMallFunction.dDM))
        {
          paramInt = 4;
        }
        else if ("wxpay://bizmall/weixin_scan_qrcode".equals(paramMallFunction.dDM))
        {
          paramInt = 8;
        }
        else if ("wxpay://bizmall/weixin_transfer".equals(paramMallFunction.dDM))
        {
          paramInt = 5;
        }
        else if ("wxpay://bizmall/weixin_offline_pay".equals(paramMallFunction.dDM))
        {
          paramInt = 6;
        }
        else if ("wxpay://bizmall/old_mobile_recharge".equals(paramMallFunction.dDM))
        {
          paramInt = 7;
        }
        else if (!bt.isNullOrNil(paramMallFunction.smD))
        {
          paramInt = 1;
        }
        else if ("wxpay://bizmall/f2f_hongbao".equals(paramMallFunction.dDM))
        {
          paramInt = 9;
        }
        else
        {
          ad.w("MicroMsg.MallIndexUIHelper", "doSelectFunction no jump");
          paramInt = 2;
          continue;
          paramInt = 3;
        }
        break;
      }
    }
    com.tencent.mm.plugin.report.service.h.vKh.f(11701, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
    paramMallFunction = new Intent();
    paramMallFunction.putExtra("pay_channel", 1);
    com.tencent.mm.bs.d.b(this, "luckymoney", ".ui.LuckyMoneyIndexUI", paramMallFunction);
    com.tencent.mm.wallet_core.c.ab.jZ(13, 0);
    com.tencent.mm.plugin.report.service.h.vKh.f(11850, new Object[] { Integer.valueOf(4), Integer.valueOf(0) });
    return;
    Object localObject1 = new Intent();
    if (isTransparent()) {
      ((Intent)localObject1).putExtra("key_is_hide_progress", true);
    }
    ((Intent)localObject1).putExtra("key_func_info", paramMallFunction);
    com.tencent.mm.bs.d.b(this, "recharge", ".ui.RechargeUI", (Intent)localObject1);
    return;
    g.afC();
    this.tso = ((Integer)g.afB().afk().get(ae.a.Fla, Integer.valueOf(0))).intValue();
    localObject1 = new Intent();
    ((Intent)localObject1).putExtra("rawUrl", paramMallFunction.smD);
    ((Intent)localObject1).putExtra("geta8key_username", u.aqG());
    ((Intent)localObject1).putExtra("pay_channel", 1);
    ((Intent)localObject1).putExtra("KPublisherId", "pay_wallet");
    ((Intent)localObject1).putExtra("key_download_restrict", paramMallFunction.AiE);
    ((Intent)localObject1).putExtra("key_wallet_region", this.tso);
    ((Intent)localObject1).putExtra("key_function_id", paramMallFunction.uWF);
    ((Intent)localObject1).putExtra(e.m.FIC, true);
    ((Intent)localObject1).putExtra("geta8key_scene", 46);
    com.tencent.mm.wallet_core.ui.e.X(getContext(), (Intent)localObject1);
    return;
    ad.w("MicroMsg.MallIndexBaseUI", "doSelectFunction no jump");
    return;
    ad.w("MicroMsg.MallIndexBaseUI", "doSelectFunction do nothing");
    t.makeText(this, "fuction list error", 1).show();
    return;
    com.tencent.mm.plugin.report.service.h.vKh.f(11458, new Object[] { Integer.valueOf(1) });
    if (u.aqV())
    {
      paramMallFunction = new LinkedList();
      localObject1 = new LinkedList();
      paramMallFunction.add(getString(2131762535));
      ((List)localObject1).add(Integer.valueOf(0));
      paramMallFunction.add(getString(2131757496));
      ((List)localObject1).add(Integer.valueOf(1));
      com.tencent.mm.ui.base.h.b(this, getString(2131762442), paramMallFunction, (List)localObject1, null, new MallIndexBaseUI.3(this));
    }
    for (;;)
    {
      com.tencent.mm.wallet_core.c.ab.jZ(14, 0);
      com.tencent.mm.plugin.report.service.h.vKh.f(11850, new Object[] { Integer.valueOf(3), Integer.valueOf(0) });
      return;
      g.afC();
      if (!((Boolean)g.afB().afk().get(ae.a.FgZ, Boolean.FALSE)).booleanValue())
      {
        g.afC();
        g.afB().afk().set(ae.a.FgZ, Boolean.TRUE);
        com.tencent.mm.ui.base.h.d(this, getString(2131765307), "", new MallIndexBaseUI.4(this));
      }
      else
      {
        cNv();
      }
    }
    paramMallFunction = new Intent();
    paramMallFunction.putExtra("key_from_scene", 1);
    com.tencent.mm.bs.d.b(getContext(), "offline", ".ui.WalletOfflineEntranceUI", paramMallFunction);
    com.tencent.mm.wallet_core.c.ab.jZ(9, 0);
    com.tencent.mm.plugin.report.service.h.vKh.f(11850, new Object[] { Integer.valueOf(5), Integer.valueOf(0) });
    return;
    paramMallFunction = new Intent();
    paramMallFunction.putExtra("BaseScanUI_select_scan_mode", 1);
    com.tencent.mm.bs.d.b(getContext(), "scanner", ".ui.BaseScanUI", paramMallFunction);
    return;
    com.tencent.mm.bs.d.O(getContext(), "luckymoney", ".f2f.ui.LuckyMoneyF2FQRCodeUI");
  }
  
  public final void cE()
  {
    showOptionMenu(true);
    this.ttS.Z(this.tsk);
    cNw();
    cNx();
    cNy();
  }
  
  protected abstract void cFM();
  
  protected abstract void cNl();
  
  protected abstract void cNm();
  
  protected abstract void cNn();
  
  protected abstract boolean cNo();
  
  protected abstract void cNp();
  
  protected abstract void cNs();
  
  protected abstract void cNt();
  
  protected abstract void cNu();
  
  protected abstract void cNw();
  
  protected abstract void cNy();
  
  public boolean checkProcLife()
  {
    return false;
  }
  
  protected abstract void eb(View paramView);
  
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
    if ((paramInt == 12) && (this.ttV != null)) {
      cNu();
    }
  }
  
  protected abstract void initHeaderView();
  
  public void initView()
  {
    ad.d("MicroMsg.MallIndexBaseUI", "index initView");
    setBackBtn(new MallIndexBaseUI.1(this));
    this.ttR = ((ListView)findViewById(2131302018));
    initHeaderView();
    cNs();
    this.ttS = new b(this, this.tso);
    this.ttR.setAdapter(this.ttS);
    this.ttS.tsX = new b.d()
    {
      public final void a(final int paramAnonymousInt, final MallFunction paramAnonymousMallFunction)
      {
        AppMethodBeat.i(66065);
        String str;
        int i;
        if (paramAnonymousMallFunction != null)
        {
          str = paramAnonymousMallFunction.uWF;
          if (bt.isNullOrNil(str)) {
            i = 1;
          }
        }
        for (;;)
        {
          if ((i == 0) && (!bt.isNullOrNil(paramAnonymousMallFunction.AiD)))
          {
            ad.i("MicroMsg.MallIndexBaseUI", "onFunctionItemClick show disclaimer funcId=%s", new Object[] { paramAnonymousMallFunction.uWF });
            com.tencent.mm.ui.base.h.a(MallIndexBaseUI.this.getContext(), paramAnonymousMallFunction.AiD, MallIndexBaseUI.this.getString(2131761167), MallIndexBaseUI.this.getString(2131762497), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                int j = 0;
                AppMethodBeat.i(66064);
                String str1 = paramAnonymousMallFunction.uWF;
                String str2;
                if (!bt.isNullOrNil(str1))
                {
                  g.afC();
                  str2 = (String)g.afB().afk().get(ae.a.FjL, null);
                  if (!bt.isNullOrNil(str2)) {
                    break label99;
                  }
                }
                for (paramAnonymous2DialogInterface = str1;; paramAnonymous2DialogInterface = str1)
                {
                  g.afC();
                  g.afB().afk().set(ae.a.FjL, paramAnonymous2DialogInterface);
                  MallIndexBaseUI.this.a(paramAnonymousMallFunction, paramAnonymousInt);
                  AppMethodBeat.o(66064);
                  return;
                  label99:
                  paramAnonymous2DialogInterface = str2.split(",");
                  if ((paramAnonymous2DialogInterface != null) && (paramAnonymous2DialogInterface.length != 0)) {
                    break;
                  }
                }
                paramAnonymous2Int = 0;
                for (;;)
                {
                  int i = j;
                  if (paramAnonymous2Int < paramAnonymous2DialogInterface.length)
                  {
                    if (paramAnonymous2DialogInterface[paramAnonymous2Int].equals(str1)) {
                      i = 1;
                    }
                  }
                  else
                  {
                    paramAnonymous2DialogInterface = str2;
                    if (i != 0) {
                      break;
                    }
                    paramAnonymous2DialogInterface = str2 + "," + str1;
                    break;
                  }
                  paramAnonymous2Int += 1;
                }
              }
            });
          }
          for (;;)
          {
            ad.d("MicroMsg.MallIndexBaseUI", "type: %s", new Object[] { Integer.valueOf(paramAnonymousMallFunction.type) });
            com.tencent.mm.plugin.report.service.h.vKh.f(14419, new Object[] { MallIndexBaseUI.this.uuid, Integer.valueOf(4), Integer.valueOf(paramAnonymousMallFunction.type) });
            AppMethodBeat.o(66065);
            return;
            g.afC();
            Object localObject = (String)g.afB().afk().get(ae.a.FjL, null);
            if (bt.isNullOrNil((String)localObject))
            {
              i = 0;
              break;
            }
            localObject = ((String)localObject).split(",");
            if ((localObject == null) || (localObject.length == 0))
            {
              i = 0;
              break;
            }
            i = 0;
            for (;;)
            {
              if (i >= localObject.length) {
                break label296;
              }
              if (localObject[i].equals(str))
              {
                i = 1;
                break;
              }
              i += 1;
            }
            MallIndexBaseUI.this.a(paramAnonymousMallFunction, paramAnonymousInt);
          }
          ad.w("MicroMsg.MallIndexBaseUI", "onFunctionItemClick functionItem null; pos=%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          AppMethodBeat.o(66065);
          return;
          label296:
          i = 0;
        }
      }
    };
    eb(this.qwn);
    this.ttW = ((TextView)findViewById(2131297186));
    cNt();
  }
  
  public boolean isTransparent()
  {
    return (!bt.isNullOrNil(this.tsj)) || (!bt.isNullOrNil(this.tkm));
  }
  
  public final void l(String paramString, Bitmap paramBitmap) {}
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1)
    {
      g.afC();
      this.tso = ((Integer)g.afB().afk().get(ae.a.Fla, Integer.valueOf(0))).intValue();
      if (paramInt2 == -1)
      {
        if (!u.aqW()) {
          break label51;
        }
        finish();
      }
    }
    return;
    label51:
    finish();
    paramIntent = new qm();
    paramIntent.dwd.context = getContext();
    com.tencent.mm.sdk.b.a.ESL.l(paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    ad.i("MicroMsg.MallIndexBaseUI", "onCreate");
    super.onCreate(paramBundle);
    if (!g.afw())
    {
      ad.v("MicroMsg.MallIndexBaseUI", "MMCore is not ready");
      finish();
    }
    g.afC();
    int i = ((Integer)g.afB().afk().get(ae.a.Fla, Integer.valueOf(0))).intValue();
    this.tso = getIntent().getIntExtra("key_wallet_region", i);
    this.uuid = getIntent().getStringExtra("key_uuid");
    if (!bt.isNullOrNil(this.uuid)) {
      this.uuid = UUID.randomUUID().toString();
    }
    addSceneEndListener(495);
    s.ecj();
    ag.a(this);
    this.tsj = getIntent().getStringExtra("key_func_id");
    ad.i("MicroMsg.MallIndexBaseUI", "mFuncId:" + this.tsj + " wallet_region: " + this.tso + " walletType: " + u.aqN() + " default_region: " + i);
    this.tkm = getIntent().getStringExtra("key_native_url");
    ad.i("MicroMsg.MallIndexBaseUI", "mNativeUrl:" + this.tkm);
    if (isTransparent()) {
      return;
    }
    cFM();
    setContentViewVisibility(0);
    ad.i("MicroMsg.MallIndexBaseUI", "index Oncreate");
    cNl();
    initView();
    c.edv();
    cNm();
    ad.i("MicroMsg.MallIndexBaseUI", "hy: use default controller for MallIndexUI");
    cNn();
    if (u.aqV()) {
      ad.e("MicroMsg.MallIndexBaseUI", "it is payu account ,not initFingerPrint");
    }
    for (;;)
    {
      com.tencent.mm.wallet_core.c.ab.jZ(1, 0);
      com.tencent.mm.plugin.report.service.h.vKh.f(11850, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
      return;
      paramBundle = (com.tencent.mm.plugin.fingerprint.d.a)g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
      if (paramBundle != null)
      {
        ad.i("MicroMsg.MallIndexBaseUI", "IFingerPrintMgr is not null, do showFingerPrintEntrance()");
        paramBundle.ctM();
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
    s.ecj();
    ag.b(this);
    super.onDestroy();
  }
  
  public boolean onProgressFinish()
  {
    if (!isTransparent()) {
      cE();
    }
    return true;
  }
  
  public void onResume()
  {
    int i = 1;
    super.onResume();
    com.tencent.mm.pluginsdk.wallet.h.Vs(1);
    ad.i("MicroMsg.MallIndexBaseUI", "index onResume");
    if (!g.afw())
    {
      ad.v("MicroMsg.MallIndexBaseUI", "MMCore is not ready");
      finish();
    }
    if (isTransparent())
    {
      this.tsk = j.cNg().Gl(this.tso);
      if ((this.tsk == null) || (this.tsk.size() <= 0))
      {
        ad.i("MicroMsg.MallIndexBaseUI", "mFunctionList == null");
        try
        {
          if ((getIntent().getIntExtra("key_scene", 0) == 1) || (!bt.isNullOrNil(this.tkm)))
          {
            doSceneForceProgress(new f(this.tso, com.tencent.mm.plugin.wallet_core.model.mall.b.edr(), 0));
            return;
          }
          localObject3 = getIntent().getStringExtra("key_url");
          Object localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = "";
          }
          doSceneForceProgress(new f(this.tso, com.tencent.mm.plugin.wallet_core.model.mall.b.edr(), getIntent().getStringExtra("key_app_id"), this.tsj, (String)localObject1));
          return;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          ad.printErrStackTrace("MicroMsg.MallIndexBaseUI", localUnsupportedEncodingException, "", new Object[0]);
          cNr();
          return;
        }
      }
      Object localObject3 = ed(this.tsk);
      Object localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = ee(this.tsk);
      }
      a((MallFunction)localObject2, -1);
      finish();
      return;
    }
    cNo();
    ad.d("MicroMsg.MallIndexBaseUI", "initFunctionList");
    if (j.cNg().Gl(this.tso) == null)
    {
      doSceneProgress(new f(this.tso, com.tencent.mm.plugin.wallet_core.model.mall.b.edr(), 0), true);
      ad.e("MicroMsg.MallIndexBaseUI", "funcitonlist invalid");
      i = 0;
    }
    while (i != 0)
    {
      ad.i("MicroMsg.MallIndexBaseUI", "has data");
      cE();
      return;
      doSceneProgress(new f(this.tso, com.tencent.mm.plugin.wallet_core.model.mall.b.edr(), 1), false);
      this.tsk = j.cNg().Gl(this.tso);
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
        if (this.ttY)
        {
          this.ttY = false;
          if (s.ebX().edF().ecH())
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
    paramString = (f)paramn;
    if (paramString.tso != this.tso) {
      ad.i("MicroMsg.MallIndexBaseUI", "pass wallet local: %d cgi: %d", new Object[] { Integer.valueOf(this.tso), Integer.valueOf(paramString.tso) });
    }
    if (isTransparent())
    {
      ad.d("MicroMsg.MallIndexBaseUI", "errorType:%d | errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if ((paramInt1 == 0) && (paramInt2 == 0) && (paramString.tsk != null)) {
        if (getIntent().getIntExtra("key_scene", 0) == 1)
        {
          paramString = ed(paramString.tsk);
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
      if (!bt.isNullOrNil(this.tkm))
      {
        ad.d("MicroMsg.MallIndexBaseUI", "NativeUrl: %s", new Object[] { this.tkm });
        paramString = ee(paramString.tsk);
        if (paramString != null)
        {
          a(paramString, -1);
          break;
        }
        cNr();
        return true;
      }
      if ((paramString.tsk != null) && (paramString.tsk.size() > 0))
      {
        ad.i("MicroMsg.MallIndexBaseUI", "functionScene.mFunctionList != null");
        a(ed(paramString.tsk), -1);
        break;
      }
      if ((j.cNg().Gl(this.tso) != null) && (j.cNg().Gl(this.tso).size() > 0))
      {
        ad.i("MicroMsg.MallIndexBaseUI", "SubCoreMall.getCore().getFunctionList() != null");
        a(ed(j.cNg().Gl(this.tso)), -1);
        break;
      }
      ad.e("MicroMsg.MallIndexBaseUI", "SubCoreMall.getCore().getFunctionList() == null");
      break;
      cNr();
      continue;
      if ((paramInt1 == 0) && (paramInt2 == 0) && (j.cNg().Gl(this.tso) != null) && (paramString.tsk != null))
      {
        this.tsk = j.cNg().Gl(this.tso);
        ad.i("MicroMsg.MallIndexBaseUI", "get from server now! " + this.tso + " " + this.tsk.size());
        c.eds().av(this.tsk);
        if (!bt.gL(this.tsk))
        {
          paramString = new LinkedList();
          paramn = this.tsk.iterator();
          while (paramn.hasNext())
          {
            MallFunction localMallFunction = (MallFunction)paramn.next();
            if (!bt.isNullOrNil(localMallFunction.dDM)) {
              paramString.add(localMallFunction.dDM);
            }
          }
          if (!bt.gL(paramString))
          {
            paramn = (q)g.ab(q.class);
            if (paramn != null) {
              paramn.aX(paramString);
            }
          }
        }
      }
      cE();
      cNq();
      cNs();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexBaseUI
 * JD-Core Version:    0.7.0.1
 */