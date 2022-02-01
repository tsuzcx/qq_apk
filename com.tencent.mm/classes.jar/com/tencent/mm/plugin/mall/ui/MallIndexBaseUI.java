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
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.qv;
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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.e.m;
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
  protected View rjd;
  private String uAC = null;
  private ArrayList<MallFunction> uAD = null;
  protected int uAH;
  private TextView uCj = null;
  protected ListView uCk = null;
  private b uCl = null;
  protected ImageView uCm = null;
  protected ImageView uCn;
  protected TextView uCo = null;
  protected TextView uCp;
  private int uCq = 0;
  private boolean uCr = true;
  protected int uCs;
  protected View uCt;
  private boolean uCu = false;
  private String usF = null;
  protected String uuid;
  
  private void daX()
  {
    boolean bool = getIntent().getBooleanExtra("key_wallet_has_red", false);
    if (this.uCk.getChildCount() == 0) {}
    label404:
    for (;;)
    {
      return;
      int i = this.uCk.getFirstVisiblePosition();
      int j = this.uCk.getChildAt(0).getTop();
      ac.i("MicroMsg.MallIndexBaseUI", "initCheckNew %s fpos %s top %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j) });
      if ((i == 0) && (j == 0) && (bool) && (!this.uCu) && (this.uAD != null))
      {
        this.uCu = true;
        int k = this.uCk.getHeaderViewsCount() + this.uCl.getCount();
        List localList = this.uCl.uBp;
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
                if ((localc != null) && (localc.uBT != null) && (b.a(localc.uBT)))
                {
                  i = this.uCk.getFirstVisiblePosition();
                  j = this.uCk.getLastVisiblePosition();
                  ac.i("MicroMsg.MallIndexBaseUI", "get listview show top %s bottom %s redPos: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
                  if ((k >= i) && (k <= j)) {
                    break;
                  }
                  int m = a.daQ();
                  j = a.daP() + a.daO() * (k + 1) + m;
                  i = j;
                  if (k > 2) {
                    i = j + m;
                  }
                  j = i;
                  if (k > 3) {
                    j = i + m;
                  }
                  m = a.daO() / 3;
                  int n = this.uCk.getScrollY();
                  k = aj.cl(this).y;
                  i = k;
                  if (aj.jF(this)) {
                    i = k - aj.ej(this);
                  }
                  k = i;
                  if (getSupportActionBar() != null) {
                    k = i - getSupportActionBar().getHeight();
                  }
                  this.uCk.smoothScrollBy(j + m - n - k, 1000);
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
  
  private void daY()
  {
    setResult(0);
    finish();
  }
  
  private void dbc()
  {
    if (u.axL())
    {
      com.tencent.mm.wallet_core.a.b(getContext(), "PayURemittanceProcess", null);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("pay_channel", 1);
    com.tencent.mm.wallet_core.a.b(getContext(), "RemittanceProcess", localBundle);
  }
  
  private void dbe()
  {
    if (this.uCj != null) {
      this.uCj.setVisibility(8);
    }
  }
  
  private MallFunction eh(List<MallFunction> paramList)
  {
    Object localObject;
    if ((paramList == null) || (paramList.size() == 0) || (TextUtils.isEmpty(this.uAC)))
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
        if (this.uAC.equals(localMallFunction.wfu)) {
          break;
        }
      }
      i += 1;
    }
    label81:
    return null;
  }
  
  private MallFunction ei(List<MallFunction> paramList)
  {
    Object localObject;
    if ((paramList == null) || (paramList.size() == 0) || (TextUtils.isEmpty(this.usF)))
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
        if (this.usF.equals(localMallFunction.dBy)) {
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
      if (paramMallFunction.BAX != null)
      {
        localObject1 = localObject2;
        if (!bs.isNullOrNil(paramMallFunction.BAX.zPC)) {
          localObject1 = paramMallFunction.BAX.zPC;
        }
      }
      if (this.uAD != null) {
        break label228;
      }
      i = 0;
      boolean bool = b.a(paramMallFunction);
      localObject2 = com.tencent.mm.plugin.report.service.h.wUl;
      str = paramMallFunction.wfu;
      if (!bool) {
        break label239;
      }
    }
    label228:
    label239:
    for (int j = 2;; j = 1)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject2).f(10881, new Object[] { str, Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(paramInt), localObject1, Integer.valueOf(j) });
      if ((paramMallFunction == null) || (bs.isNullOrNil(paramMallFunction.dBy)) || (!((o)g.ab(o.class)).Oy(paramMallFunction.dBy))) {
        break label245;
      }
      ac.i("MicroMsg.MallIndexBaseUI", "handleFunction, intercept by AppBrandNativeLink, nativeUrl = %s", new Object[] { paramMallFunction.dBy });
      c.esN().azs(paramMallFunction.wfu);
      com.tencent.mm.plugin.wallet_core.model.mall.d.esR().azs(paramMallFunction.wfu);
      if (paramMallFunction.BAX != null)
      {
        c.esN();
        c.e(paramMallFunction);
      }
      return;
      i = this.uAD.size();
      break;
    }
    label245:
    if (paramMallFunction != null)
    {
      c.esN().azs(paramMallFunction.wfu);
      com.tencent.mm.plugin.wallet_core.model.mall.d.esR().azs(paramMallFunction.wfu);
      if (paramMallFunction.BAX != null)
      {
        c.esN();
        c.e(paramMallFunction);
      }
      if ("wxpay://bizmall/mobile_recharge".equals(paramMallFunction.dBy)) {
        paramInt = 0;
      }
    }
    for (;;)
    {
      ac.i("MicroMsg.MallIndexBaseUI", "functionType : ".concat(String.valueOf(paramInt)));
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
        ab.km(15, 0);
        return;
        if ("wxpay://bizmall/weixin_hongbao".equals(paramMallFunction.dBy))
        {
          paramInt = 4;
        }
        else if ("wxpay://bizmall/weixin_scan_qrcode".equals(paramMallFunction.dBy))
        {
          paramInt = 8;
        }
        else if ("wxpay://bizmall/weixin_transfer".equals(paramMallFunction.dBy))
        {
          paramInt = 5;
        }
        else if ("wxpay://bizmall/weixin_offline_pay".equals(paramMallFunction.dBy))
        {
          paramInt = 6;
        }
        else if ("wxpay://bizmall/old_mobile_recharge".equals(paramMallFunction.dBy))
        {
          paramInt = 7;
        }
        else if (!bs.isNullOrNil(paramMallFunction.tuw))
        {
          paramInt = 1;
        }
        else if ("wxpay://bizmall/f2f_hongbao".equals(paramMallFunction.dBy))
        {
          paramInt = 9;
        }
        else
        {
          ac.w("MicroMsg.MallIndexUIHelper", "doSelectFunction no jump");
          paramInt = 2;
          continue;
          paramInt = 3;
        }
        break;
      }
    }
    com.tencent.mm.plugin.report.service.h.wUl.f(11701, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
    paramMallFunction = new Intent();
    paramMallFunction.putExtra("pay_channel", 1);
    com.tencent.mm.br.d.b(this, "luckymoney", ".ui.LuckyMoneyIndexUI", paramMallFunction);
    ab.km(13, 0);
    com.tencent.mm.plugin.report.service.h.wUl.f(11850, new Object[] { Integer.valueOf(4), Integer.valueOf(0) });
    return;
    Object localObject1 = new Intent();
    if (isTransparent()) {
      ((Intent)localObject1).putExtra("key_is_hide_progress", true);
    }
    ((Intent)localObject1).putExtra("key_func_info", paramMallFunction);
    com.tencent.mm.br.d.b(this, "recharge", ".ui.RechargeUI", (Intent)localObject1);
    return;
    g.agS();
    this.uAH = ((Integer)g.agR().agA().get(ah.a.GIP, Integer.valueOf(0))).intValue();
    localObject1 = new Intent();
    ((Intent)localObject1).putExtra("rawUrl", paramMallFunction.tuw);
    ((Intent)localObject1).putExtra("geta8key_username", u.axw());
    ((Intent)localObject1).putExtra("pay_channel", 1);
    ((Intent)localObject1).putExtra("KPublisherId", "pay_wallet");
    ((Intent)localObject1).putExtra("key_download_restrict", paramMallFunction.BAZ);
    ((Intent)localObject1).putExtra("key_wallet_region", this.uAH);
    ((Intent)localObject1).putExtra("key_function_id", paramMallFunction.wfu);
    ((Intent)localObject1).putExtra(e.m.HhK, true);
    ((Intent)localObject1).putExtra("geta8key_scene", 46);
    com.tencent.mm.wallet_core.ui.e.al(getContext(), (Intent)localObject1);
    return;
    ac.w("MicroMsg.MallIndexBaseUI", "doSelectFunction no jump");
    return;
    ac.w("MicroMsg.MallIndexBaseUI", "doSelectFunction do nothing");
    t.makeText(this, "fuction list error", 1).show();
    return;
    com.tencent.mm.plugin.report.service.h.wUl.f(11458, new Object[] { Integer.valueOf(1) });
    if (u.axL())
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
      ab.km(14, 0);
      com.tencent.mm.plugin.report.service.h.wUl.f(11850, new Object[] { Integer.valueOf(3), Integer.valueOf(0) });
      return;
      g.agS();
      if (!((Boolean)g.agR().agA().get(ah.a.GEN, Boolean.FALSE)).booleanValue())
      {
        g.agS();
        g.agR().agA().set(ah.a.GEN, Boolean.TRUE);
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
        dbc();
      }
    }
    paramMallFunction = new Intent();
    paramMallFunction.putExtra("key_from_scene", 1);
    com.tencent.mm.br.d.b(getContext(), "offline", ".ui.WalletOfflineEntranceUI", paramMallFunction);
    ab.km(9, 0);
    com.tencent.mm.plugin.report.service.h.wUl.f(11850, new Object[] { Integer.valueOf(5), Integer.valueOf(0) });
    return;
    paramMallFunction = new Intent();
    paramMallFunction.putExtra("BaseScanUI_select_scan_mode", 1);
    com.tencent.mm.br.d.b(getContext(), "scanner", ".ui.BaseScanUI", paramMallFunction);
    return;
    com.tencent.mm.br.d.N(getContext(), "luckymoney", ".f2f.ui.LuckyMoneyF2FQRCodeUI");
  }
  
  public final void cL()
  {
    showOptionMenu(true);
    this.uCl.ak(this.uAD);
    dbd();
    dbe();
    dbf();
  }
  
  protected abstract void cSW();
  
  public boolean checkProcLife()
  {
    return false;
  }
  
  protected abstract void daS();
  
  protected abstract void daT();
  
  protected abstract void daU();
  
  protected abstract boolean daV();
  
  protected abstract void daW();
  
  protected abstract void daZ();
  
  protected abstract void dba();
  
  protected abstract void dbb();
  
  protected abstract void dbd();
  
  protected abstract void dbf();
  
  protected abstract void ek(View paramView);
  
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
    if ((paramInt == 12) && (this.uCo != null)) {
      dbb();
    }
  }
  
  protected abstract void initHeaderView();
  
  public void initView()
  {
    ac.d("MicroMsg.MallIndexBaseUI", "index initView");
    setBackBtn(new MallIndexBaseUI.1(this));
    this.uCk = ((ListView)findViewById(2131302018));
    initHeaderView();
    daZ();
    this.uCl = new b(this, this.uAH);
    this.uCk.setAdapter(this.uCl);
    this.uCl.uBq = new b.d()
    {
      public final void a(final int paramAnonymousInt, final MallFunction paramAnonymousMallFunction)
      {
        AppMethodBeat.i(66065);
        String str;
        int i;
        if (paramAnonymousMallFunction != null)
        {
          str = paramAnonymousMallFunction.wfu;
          if (bs.isNullOrNil(str)) {
            i = 1;
          }
        }
        for (;;)
        {
          if ((i == 0) && (!bs.isNullOrNil(paramAnonymousMallFunction.BAY)))
          {
            ac.i("MicroMsg.MallIndexBaseUI", "onFunctionItemClick show disclaimer funcId=%s", new Object[] { paramAnonymousMallFunction.wfu });
            com.tencent.mm.ui.base.h.a(MallIndexBaseUI.this.getContext(), paramAnonymousMallFunction.BAY, MallIndexBaseUI.this.getString(2131761167), MallIndexBaseUI.this.getString(2131762497), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                int j = 0;
                AppMethodBeat.i(66064);
                String str1 = paramAnonymousMallFunction.wfu;
                String str2;
                if (!bs.isNullOrNil(str1))
                {
                  g.agS();
                  str2 = (String)g.agR().agA().get(ah.a.GHA, null);
                  if (!bs.isNullOrNil(str2)) {
                    break label99;
                  }
                }
                for (paramAnonymous2DialogInterface = str1;; paramAnonymous2DialogInterface = str1)
                {
                  g.agS();
                  g.agR().agA().set(ah.a.GHA, paramAnonymous2DialogInterface);
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
            ac.d("MicroMsg.MallIndexBaseUI", "type: %s", new Object[] { Integer.valueOf(paramAnonymousMallFunction.type) });
            com.tencent.mm.plugin.report.service.h.wUl.f(14419, new Object[] { MallIndexBaseUI.this.uuid, Integer.valueOf(4), Integer.valueOf(paramAnonymousMallFunction.type) });
            AppMethodBeat.o(66065);
            return;
            g.agS();
            Object localObject = (String)g.agR().agA().get(ah.a.GHA, null);
            if (bs.isNullOrNil((String)localObject))
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
          ac.w("MicroMsg.MallIndexBaseUI", "onFunctionItemClick functionItem null; pos=%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          AppMethodBeat.o(66065);
          return;
          label296:
          i = 0;
        }
      }
    };
    ek(this.rjd);
    this.uCp = ((TextView)findViewById(2131297186));
    dba();
  }
  
  public boolean isTransparent()
  {
    return (!bs.isNullOrNil(this.uAC)) || (!bs.isNullOrNil(this.usF));
  }
  
  public final void k(String paramString, Bitmap paramBitmap) {}
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1)
    {
      g.agS();
      this.uAH = ((Integer)g.agR().agA().get(ah.a.GIP, Integer.valueOf(0))).intValue();
      if (paramInt2 == -1)
      {
        if (!u.axM()) {
          break label51;
        }
        finish();
      }
    }
    return;
    label51:
    finish();
    paramIntent = new qv();
    paramIntent.dtQ.context = getContext();
    com.tencent.mm.sdk.b.a.GpY.l(paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    ac.i("MicroMsg.MallIndexBaseUI", "onCreate");
    super.onCreate(paramBundle);
    if (!g.agM())
    {
      ac.v("MicroMsg.MallIndexBaseUI", "MMCore is not ready");
      finish();
    }
    g.agS();
    int i = ((Integer)g.agR().agA().get(ah.a.GIP, Integer.valueOf(0))).intValue();
    this.uAH = getIntent().getIntExtra("key_wallet_region", i);
    this.uuid = getIntent().getStringExtra("key_uuid");
    if (!bs.isNullOrNil(this.uuid)) {
      this.uuid = UUID.randomUUID().toString();
    }
    addSceneEndListener(495);
    s.erF();
    ag.a(this);
    this.uAC = getIntent().getStringExtra("key_func_id");
    ac.i("MicroMsg.MallIndexBaseUI", "mFuncId:" + this.uAC + " wallet_region: " + this.uAH + " walletType: " + u.axD() + " default_region: " + i);
    this.usF = getIntent().getStringExtra("key_native_url");
    ac.i("MicroMsg.MallIndexBaseUI", "mNativeUrl:" + this.usF);
    if (isTransparent()) {
      return;
    }
    cSW();
    setContentViewVisibility(0);
    ac.i("MicroMsg.MallIndexBaseUI", "index Oncreate");
    daS();
    initView();
    c.esQ();
    daT();
    ac.i("MicroMsg.MallIndexBaseUI", "hy: use default controller for MallIndexUI");
    daU();
    if (u.axL()) {
      ac.e("MicroMsg.MallIndexBaseUI", "it is payu account ,not initFingerPrint");
    }
    for (;;)
    {
      ab.km(1, 0);
      com.tencent.mm.plugin.report.service.h.wUl.f(11850, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
      return;
      paramBundle = (com.tencent.mm.plugin.fingerprint.d.a)g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
      if (paramBundle != null)
      {
        ac.i("MicroMsg.MallIndexBaseUI", "IFingerPrintMgr is not null, do showFingerPrintEntrance()");
        paramBundle.cGY();
      }
      else
      {
        ac.e("MicroMsg.MallIndexBaseUI", "IFingerPrintMgr is not null");
      }
    }
  }
  
  public void onDestroy()
  {
    removeSceneEndListener(495);
    s.erF();
    ag.b(this);
    super.onDestroy();
  }
  
  public boolean onProgressFinish()
  {
    if (!isTransparent()) {
      cL();
    }
    return true;
  }
  
  public void onResume()
  {
    int i = 1;
    super.onResume();
    com.tencent.mm.pluginsdk.wallet.h.XB(1);
    ac.i("MicroMsg.MallIndexBaseUI", "index onResume");
    if (!g.agM())
    {
      ac.v("MicroMsg.MallIndexBaseUI", "MMCore is not ready");
      finish();
    }
    if (isTransparent())
    {
      this.uAD = j.daN().Ih(this.uAH);
      if ((this.uAD == null) || (this.uAD.size() <= 0))
      {
        ac.i("MicroMsg.MallIndexBaseUI", "mFunctionList == null");
        try
        {
          if ((getIntent().getIntExtra("key_scene", 0) == 1) || (!bs.isNullOrNil(this.usF)))
          {
            doSceneForceProgress(new f(this.uAH, com.tencent.mm.plugin.wallet_core.model.mall.b.esM(), 0));
            return;
          }
          localObject3 = getIntent().getStringExtra("key_url");
          Object localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = "";
          }
          doSceneForceProgress(new f(this.uAH, com.tencent.mm.plugin.wallet_core.model.mall.b.esM(), getIntent().getStringExtra("key_app_id"), this.uAC, (String)localObject1));
          return;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          ac.printErrStackTrace("MicroMsg.MallIndexBaseUI", localUnsupportedEncodingException, "", new Object[0]);
          daY();
          return;
        }
      }
      Object localObject3 = eh(this.uAD);
      Object localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = ei(this.uAD);
      }
      a((MallFunction)localObject2, -1);
      finish();
      return;
    }
    daV();
    ac.d("MicroMsg.MallIndexBaseUI", "initFunctionList");
    if (j.daN().Ih(this.uAH) == null)
    {
      doSceneProgress(new f(this.uAH, com.tencent.mm.plugin.wallet_core.model.mall.b.esM(), 0), true);
      ac.e("MicroMsg.MallIndexBaseUI", "funcitonlist invalid");
      i = 0;
    }
    while (i != 0)
    {
      ac.i("MicroMsg.MallIndexBaseUI", "has data");
      cL();
      return;
      doSceneProgress(new f(this.uAH, com.tencent.mm.plugin.wallet_core.model.mall.b.esM(), 1), false);
      this.uAD = j.daN().Ih(this.uAH);
    }
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    ac.d("MicroMsg.MallIndexBaseUI", "onOtherSceneEnd");
    if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.b.a))
    {
      ac.d("MicroMsg.MallIndexBaseUI", "hy: query bound scene end");
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (this.uCr)
        {
          this.uCr = false;
          if (s.ert().eta().esc())
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
    if (paramString.uAH != this.uAH) {
      ac.i("MicroMsg.MallIndexBaseUI", "pass wallet local: %d cgi: %d", new Object[] { Integer.valueOf(this.uAH), Integer.valueOf(paramString.uAH) });
    }
    if (isTransparent())
    {
      ac.d("MicroMsg.MallIndexBaseUI", "errorType:%d | errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if ((paramInt1 == 0) && (paramInt2 == 0) && (paramString.uAD != null)) {
        if (getIntent().getIntExtra("key_scene", 0) == 1)
        {
          paramString = eh(paramString.uAD);
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
      if (!bs.isNullOrNil(this.usF))
      {
        ac.d("MicroMsg.MallIndexBaseUI", "NativeUrl: %s", new Object[] { this.usF });
        paramString = ei(paramString.uAD);
        if (paramString != null)
        {
          a(paramString, -1);
          break;
        }
        daY();
        return true;
      }
      if ((paramString.uAD != null) && (paramString.uAD.size() > 0))
      {
        ac.i("MicroMsg.MallIndexBaseUI", "functionScene.mFunctionList != null");
        a(eh(paramString.uAD), -1);
        break;
      }
      if ((j.daN().Ih(this.uAH) != null) && (j.daN().Ih(this.uAH).size() > 0))
      {
        ac.i("MicroMsg.MallIndexBaseUI", "SubCoreMall.getCore().getFunctionList() != null");
        a(eh(j.daN().Ih(this.uAH)), -1);
        break;
      }
      ac.e("MicroMsg.MallIndexBaseUI", "SubCoreMall.getCore().getFunctionList() == null");
      break;
      daY();
      continue;
      if ((paramInt1 == 0) && (paramInt2 == 0) && (j.daN().Ih(this.uAH) != null) && (paramString.uAD != null))
      {
        this.uAD = j.daN().Ih(this.uAH);
        ac.i("MicroMsg.MallIndexBaseUI", "get from server now! " + this.uAH + " " + this.uAD.size());
        c.esN().aH(this.uAD);
        if (!bs.gY(this.uAD))
        {
          paramString = new LinkedList();
          paramn = this.uAD.iterator();
          while (paramn.hasNext())
          {
            MallFunction localMallFunction = (MallFunction)paramn.next();
            if (!bs.isNullOrNil(localMallFunction.dBy)) {
              paramString.add(localMallFunction.dBy);
            }
          }
          if (!bs.gY(paramString))
          {
            paramn = (q)g.ab(q.class);
            if (paramn != null) {
              paramn.aV(paramString);
            }
          }
        }
      }
      cL();
      daX();
      daZ();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexBaseUI
 * JD-Core Version:    0.7.0.1
 */