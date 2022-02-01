package com.tencent.mm.plugin.mall.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.f.a.te;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.appbrand.api.WeAppOpenDeclarePromptBundle;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.appbrand.service.s;
import com.tencent.mm.plugin.mall.a.k;
import com.tencent.mm.plugin.wallet_core.model.ai;
import com.tencent.mm.plugin.wallet_core.model.l;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.bmw;
import com.tencent.mm.protocal.protobuf.fhm;
import com.tencent.mm.protocal.protobuf.fho;
import com.tencent.mm.protocal.protobuf.fhp;
import com.tencent.mm.protocal.protobuf.fia;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.f.r;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public abstract class MallIndexBaseUIv2
  extends WalletBaseUI
  implements u.a, l
{
  private String EOD = null;
  private ArrayList<MallFunction> EOE = null;
  protected int EOJ;
  protected ImageView EQA;
  protected TextView EQB = null;
  protected TextView EQC;
  private int EQD = 0;
  protected View EQG;
  private boolean EQH = false;
  private c EQM = null;
  private ArrayList<bmw> EQN = null;
  private TextView EQw = null;
  protected ListView EQx = null;
  private String Eyn = null;
  private RelativeLayout kDt;
  protected String uuid;
  protected View zRq;
  
  private void c(MallFunction paramMallFunction)
  {
    if ((paramMallFunction != null) && (!Util.isNullOrNil(paramMallFunction.gbn)) && (((s)com.tencent.mm.kernel.h.ae(s.class)).s(paramMallFunction.gbn, null)))
    {
      Log.i("MicorMsg.MallIndexBaseUIv2", "handleFunction, intercept by AppBrandNativeLink, nativeUrl = %s", new Object[] { paramMallFunction.gbn });
      com.tencent.mm.plugin.wallet_core.model.mall.c.gKL().bhe(paramMallFunction.nBK);
      com.tencent.mm.plugin.wallet_core.model.mall.d.gKP().bhe(paramMallFunction.nBK);
      if (paramMallFunction.OUr != null)
      {
        com.tencent.mm.plugin.wallet_core.model.mall.c.gKL();
        com.tencent.mm.plugin.wallet_core.model.mall.c.i(paramMallFunction);
      }
      return;
    }
    int i = d.f(paramMallFunction);
    Log.i("MicorMsg.MallIndexBaseUIv2", "functionType : ".concat(String.valueOf(i)));
    switch (i)
    {
    default: 
      return;
    case 0: 
      d(paramMallFunction);
      ab.ny(15, 0);
      return;
    case 1: 
      e(paramMallFunction);
      return;
    case 2: 
      eQQ();
      return;
    }
    eQP();
  }
  
  private void d(MallFunction paramMallFunction)
  {
    Intent localIntent = new Intent();
    if (isTransparent()) {
      localIntent.putExtra("key_is_hide_progress", true);
    }
    localIntent.putExtra("key_func_info", paramMallFunction);
    com.tencent.mm.by.c.b(this, "recharge", ".ui.PhoneRechargeUI", localIntent);
  }
  
  private void e(MallFunction paramMallFunction)
  {
    com.tencent.mm.kernel.h.aHH();
    this.EOJ = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VlG, Integer.valueOf(0))).intValue();
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramMallFunction.h5Url);
    localIntent.putExtra("geta8key_username", com.tencent.mm.model.z.bcZ());
    localIntent.putExtra("pay_channel", 1);
    localIntent.putExtra("KPublisherId", "pay_wallet");
    localIntent.putExtra("key_download_restrict", paramMallFunction.OUt);
    localIntent.putExtra("key_wallet_region", this.EOJ);
    localIntent.putExtra("key_function_id", paramMallFunction.nBK);
    localIntent.putExtra(f.r.VSX, true);
    localIntent.putExtra("geta8key_scene", 46);
    com.tencent.mm.wallet_core.ui.g.aJ(getContext(), localIntent);
  }
  
  private void eQD()
  {
    boolean bool = getIntent().getBooleanExtra("key_wallet_has_red", false);
    if (this.EQx.getChildCount() == 0) {}
    for (;;)
    {
      return;
      int i = this.EQx.getFirstVisiblePosition();
      int j = this.EQx.getChildAt(0).getTop();
      Log.i("MicorMsg.MallIndexBaseUIv2", "initCheckNew %s fpos %s top %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j) });
      if ((i == 0) && (j == 0) && (bool) && (!this.EQH) && (this.EQN != null))
      {
        this.EQH = true;
        j = this.EQx.getHeaderViewsCount() + this.EQM.getCount();
        Log.i("MicorMsg.MallIndexBaseUIv2", "mFunctionsGv.getHeaderViewsCount()： %s mFunctionAdapter.getCount(): %s", new Object[] { Integer.valueOf(this.EQx.getHeaderViewsCount()), Integer.valueOf(this.EQM.getCount()) });
        List localList = this.EQM.EPu;
        if (localList != null)
        {
          i = localList.size() - 1;
          while (i > 0)
          {
            Iterator localIterator = ((ArrayList)localList.get(i)).iterator();
            while (localIterator.hasNext())
            {
              c.c localc = (c.c)localIterator.next();
              if ((localc != null) && (localc.EQf != null) && (c.a(localc.EQf)))
              {
                i = this.EQx.getFirstVisiblePosition();
                int k = this.EQx.getLastVisiblePosition();
                Log.i("MicorMsg.MallIndexBaseUIv2", "get listview show top %s bottom %s redPos: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j) });
                if ((j >= i) && (j <= k))
                {
                  Log.i("MicorMsg.MallIndexBaseUIv2", "the last redDot item is visible");
                  return;
                }
                int m = com.tencent.mm.ci.a.fromDPToPix(getContext(), 48);
                int n = com.tencent.mm.ci.a.fromDPToPix(getContext(), 8);
                int i1 = ((Integer)com.tencent.mm.plugin.wallet_core.model.mall.b.gKG().get(localc.EQf.SXM)).intValue();
                int i2 = eQN();
                int i3 = a.eQs();
                k = ar.au(this).y;
                i = k;
                if (ar.av(this)) {
                  i = k - ar.aB(this);
                }
                k = i;
                if (getSupportActionBar() != null) {
                  k = i - getSupportActionBar().getHeight();
                }
                i = this.EQx.getScrollY();
                int i4 = a.eQs() / 3;
                this.EQx.smoothScrollBy((j + 1) * i3 + i2 + i1 * (m + n) - k - i + i4, 1000);
                Log.i("MicorMsg.MallIndexBaseUIv2", "offset function is %s, groupName is %s", new Object[] { localc.EQf.SXF.CMP, Integer.valueOf(localc.EQf.SXM) });
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
  
  private void eQE()
  {
    setResult(0);
    finish();
  }
  
  private void eQK()
  {
    if (this.EQw != null) {
      this.EQw.setVisibility(8);
    }
  }
  
  private void eQO()
  {
    if ((this.EQN != null) && (this.EQN.size() > 0))
    {
      Iterator localIterator = this.EQN.iterator();
      while (localIterator.hasNext())
      {
        bmw localbmw = (bmw)localIterator.next();
        if ((localbmw.SXH != null) && (localbmw.SXH.type == 2)) {
          ((com.tencent.mm.plugin.appbrand.service.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.f.class)).b(com.tencent.mm.plugin.appbrand.service.z.qPl);
        }
      }
    }
  }
  
  private void eQP()
  {
    Log.w("MicorMsg.MallIndexBaseUIv2", "doSelectFunction do nothing");
    com.tencent.mm.ui.base.w.makeText(this, "fuction list error", 1).show();
  }
  
  private static void eQQ()
  {
    Log.w("MicorMsg.MallIndexBaseUIv2", "doSelectFunction no jump");
  }
  
  private void eQR()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    int i = this.EQx.getLastVisiblePosition();
    if (i <= this.EQx.getHeaderViewsCount()) {}
    label178:
    do
    {
      return;
      if (i <= this.EQx.getHeaderViewsCount() + this.EQM.getCount())
      {
        i -= this.EQx.getHeaderViewsCount();
        localObject = this.EQM.EPu;
        j = 0;
      }
      for (;;)
      {
        if (j >= i) {
          break label178;
        }
        Iterator localIterator = ((ArrayList)((List)localObject).get(j)).iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            c.c localc = (c.c)localIterator.next();
            if (localc != null)
            {
              localStringBuilder1.append(Long.toString(localc.EQf.SXF.UHA & 0xFFFFFFFF));
              localStringBuilder1.append(";");
              continue;
              i = this.EQM.getCount();
              break;
            }
          }
        }
        j += 1;
      }
    } while (i - 1 < 0);
    Object localObject = (c.c)((ArrayList)((List)localObject).get(i - 1)).get(0);
    int j = ((Integer)com.tencent.mm.plugin.wallet_core.model.mall.b.gKG().get(((c.c)localObject).EQf.SXM)).intValue();
    localObject = com.tencent.mm.plugin.wallet_core.model.mall.b.gKH();
    i = 0;
    while (i < j)
    {
      localStringBuilder2.append(((ArrayList)localObject).get(i));
      localStringBuilder2.append(";");
      i += 1;
    }
    Log.i("MicorMsg.MallIndexBaseUIv2", "exposure report productID：%s、groupId：%s", new Object[] { localStringBuilder1, localStringBuilder2 });
    com.tencent.mm.plugin.report.service.h.IzE.a(20548, new Object[] { localStringBuilder1, localStringBuilder2 });
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
  
  private static void fW(List<bmw> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    LinkedList localLinkedList;
    do
    {
      return;
      localLinkedList = new LinkedList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        bmw localbmw = (bmw)paramList.next();
        if ((localbmw.SXH != null) && (localbmw.SXH.type == 2) && (localbmw.SXH.UHz != null) && (!TextUtils.isEmpty(localbmw.SXH.UHz.username))) {
          localLinkedList.add(localbmw.SXH.UHz.username);
        }
      }
    } while (localLinkedList.isEmpty());
    ((com.tencent.mm.plugin.appbrand.service.w)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.w.class)).bf(localLinkedList);
  }
  
  public final boolean a(bmw parambmw, int paramInt)
  {
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vFd, 1) == 1) {}
    for (int i = 1; i == 0; i = 0)
    {
      Log.i("MicorMsg.MallIndexBaseUIv2", "handleFunctionByAppBrand clicfg_appbrand_dialog_optimize_switch close");
      return false;
    }
    if ((parambmw.SXH == null) && (parambmw.SXH.type != 2))
    {
      Log.i("MicorMsg.MallIndexBaseUIv2", "functionItem.Entrance == null");
      return false;
    }
    if ((parambmw != null) && (paramInt >= 0)) {
      if ((parambmw.SXG == null) || (Util.isNullOrNil(parambmw.SXG.UHt))) {
        break label858;
      }
    }
    label187:
    label840:
    label853:
    label858:
    for (Object localObject1 = Long.toString(parambmw.SXG.UHt & 0xFFFFFFFF);; localObject1 = "")
    {
      int j;
      boolean bool;
      Object localObject2;
      long l;
      int m;
      Object localObject3;
      if (this.EQN == null)
      {
        j = 0;
        bool = c.a(parambmw);
        localObject2 = com.tencent.mm.plugin.wallet_core.model.mall.b.gKJ();
        if (((SparseArray)localObject2).size() != 0)
        {
          l = parambmw.SXM;
          localObject2 = (ArrayList)((SparseArray)localObject2).get(parambmw.SXM);
          m = ((ArrayList)localObject2).size();
          i = 0;
          if (i >= ((ArrayList)localObject2).size()) {
            break label853;
          }
          localObject3 = (Integer)((ArrayList)localObject2).get(i);
          if ((localObject3 == null) || (((Integer)localObject3).compareTo(Integer.valueOf(parambmw.SXF.UHA)) != 0)) {
            break label840;
          }
        }
      }
      for (;;)
      {
        Log.i("MicorMsg.MallIndexBaseUIv2", "click report activityId:%s,FunctionID：%s", new Object[] { localObject1, Long.toString(parambmw.SXF.UHA & 0xFFFFFFFF) });
        localObject2 = com.tencent.mm.plugin.report.service.h.IzE;
        localObject3 = Long.toString(parambmw.SXF.UHA & 0xFFFFFFFF);
        if (bool) {}
        for (int k = 2;; k = 1)
        {
          ((com.tencent.mm.plugin.report.service.h)localObject2).a(10881, new Object[] { localObject3, Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(paramInt), localObject1, Integer.valueOf(k), Integer.valueOf(2), Long.valueOf(l), Integer.valueOf(m), Integer.valueOf(i) });
          com.tencent.mm.plugin.wallet_core.model.mall.c.gKL().bhe(parambmw.SXF.UHA);
          com.tencent.mm.plugin.wallet_core.model.mall.d.gKP().bhe(parambmw.SXF.UHA);
          if (parambmw.SXG != null)
          {
            localObject1 = new MallFunction();
            ((MallFunction)localObject1).nBK = parambmw.SXF.UHA;
            ((MallFunction)localObject1).fXz = parambmw.SXF.CMP;
            ((MallFunction)localObject1).OUr = new MallNews(((MallFunction)localObject1).nBK);
            ((MallFunction)localObject1).OUr.oym = parambmw.SXG.UHt;
            com.tencent.mm.plugin.wallet_core.model.mall.c.gKL();
            com.tencent.mm.plugin.wallet_core.model.mall.c.i((MallFunction)localObject1);
          }
          Log.i("MicorMsg.MallIndexBaseUIv2", "handleFunctionNew id：%s，name：%s，type：%s", new Object[] { Integer.valueOf(parambmw.SXF.UHA), parambmw.SXF.CMP, Integer.valueOf(parambmw.SXH.type) });
          Log.i("MicorMsg.MallIndexBaseUIv2", "handleFunctionNew functionItem.Entrance.URLWeApp.username：%s,functionItem.Entrance.URLWeApp.pagepath:%s,functionItem.Entrance.URLWeApp.version:%s", new Object[] { parambmw.SXH.UHz.username, parambmw.SXH.UHz.InB, Integer.valueOf(parambmw.SXH.UHz.version) });
          localObject1 = new com.tencent.mm.plugin.appbrand.api.g();
          ((com.tencent.mm.plugin.appbrand.api.g)localObject1).username = parambmw.SXH.UHz.username;
          ((com.tencent.mm.plugin.appbrand.api.g)localObject1).version = parambmw.SXH.UHz.version;
          ((com.tencent.mm.plugin.appbrand.api.g)localObject1).nBq = parambmw.SXH.UHz.InB;
          ((com.tencent.mm.plugin.appbrand.api.g)localObject1).cBU = 0;
          ((com.tencent.mm.plugin.appbrand.api.g)localObject1).scene = 1019;
          localObject2 = getString(a.i.mall_third_party_disclaimer_title);
          localObject3 = getString(a.i.app_i_know);
          WeAppOpenDeclarePromptBundle localWeAppOpenDeclarePromptBundle = new WeAppOpenDeclarePromptBundle((byte)0);
          localWeAppOpenDeclarePromptBundle.hDp = 2;
          localWeAppOpenDeclarePromptBundle.nBL = ((String)localObject2);
          localWeAppOpenDeclarePromptBundle.nBM = parambmw.SXK;
          localWeAppOpenDeclarePromptBundle.nBN = ((String)localObject3);
          localWeAppOpenDeclarePromptBundle.bxO = false;
          localWeAppOpenDeclarePromptBundle.nBK = parambmw.SXF.UHA;
          ((com.tencent.mm.plugin.appbrand.api.g)localObject1).nBC = localWeAppOpenDeclarePromptBundle;
          ((r)com.tencent.mm.kernel.h.ae(r.class)).a(getContext(), (com.tencent.mm.plugin.appbrand.api.g)localObject1);
          return true;
          j = this.EQN.size();
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
  
  protected abstract void eHM();
  
  protected abstract boolean eQB();
  
  protected abstract void eQF();
  
  protected abstract void eQG();
  
  protected abstract void eQH();
  
  protected abstract void eQJ();
  
  protected abstract void eQL();
  
  protected abstract void eQM();
  
  protected abstract int eQN();
  
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
    Log.d("MicorMsg.MallIndexBaseUIv2", "index initView");
    setBackBtn(new MallIndexBaseUIv2.2(this));
    this.kDt = ((RelativeLayout)findViewById(a.f.root_layout));
    this.EQx = ((ListView)findViewById(a.f.mall_index_function_list));
    initHeaderView();
    eQF();
    this.EQM = new c(this);
    this.EQx.setAdapter(this.EQM);
    this.EQM.EQa = new c.d()
    {
      public final void a(final int paramAnonymousInt, final bmw paramAnonymousbmw)
      {
        AppMethodBeat.i(204760);
        if (paramAnonymousbmw != null)
        {
          int i;
          if ((!com.tencent.mm.plugin.wallet_core.model.mall.b.a.bhb(paramAnonymousbmw.SXF.UHA)) && (!Util.isNullOrNil(paramAnonymousbmw.SXK)))
          {
            i = 1;
            if (i == 0) {
              break label278;
            }
            Log.i("MicorMsg.MallIndexBaseUIv2", "onFunctionItemClick show disclaimer funcId=%s", new Object[] { paramAnonymousbmw.SXF.UHA });
            if (!MallIndexBaseUIv2.this.a(paramAnonymousbmw, paramAnonymousInt))
            {
              d.a locala = new d.a(MallIndexBaseUIv2.this.getContext());
              String str1 = MallIndexBaseUIv2.this.getString(a.i.mall_third_party_disclaimer_title);
              String str2 = MallIndexBaseUIv2.this.getString(a.i.app_i_know);
              locala.bBc(str1);
              locala.bBd(paramAnonymousbmw.SXK);
              locala.bBj(str2).c(new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(273768);
                  Log.i("MicorMsg.MallIndexBaseUIv2", "onFunctionItemClick: onClick");
                  com.tencent.mm.plugin.wallet_core.model.mall.b.a.bha(paramAnonymousbmw.SXF.UHA);
                  MallIndexBaseUIv2.a(MallIndexBaseUIv2.this, paramAnonymousbmw, paramAnonymousInt);
                  AppMethodBeat.o(273768);
                }
              });
              locala.HG(true);
              locala.f(new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(268098);
                  Log.i("MicorMsg.MallIndexBaseUIv2", "onFunctionItemClick: onCancel");
                  com.tencent.mm.plugin.wallet_core.model.mall.b.a.bha(paramAnonymousbmw.SXF.UHA);
                  AppMethodBeat.o(268098);
                }
              });
              locala.icu().show();
            }
          }
          for (;;)
          {
            Log.d("MicorMsg.MallIndexBaseUIv2", "type: %s", new Object[] { Integer.valueOf(paramAnonymousbmw.SXM) });
            com.tencent.mm.plugin.report.service.h.IzE.a(14419, new Object[] { MallIndexBaseUIv2.this.uuid, Integer.valueOf(4), Integer.valueOf(paramAnonymousbmw.SXM) });
            AppMethodBeat.o(204760);
            return;
            i = 0;
            break;
            label278:
            MallIndexBaseUIv2.a(MallIndexBaseUIv2.this, paramAnonymousbmw, paramAnonymousInt);
          }
        }
        Log.w("MicorMsg.MallIndexBaseUIv2", "onFunctionItemClick functionItem null; pos=%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(204760);
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
        if (!com.tencent.mm.model.z.bdr()) {
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
    Log.i("MicorMsg.MallIndexBaseUIv2", "onCreate");
    super.onCreate(paramBundle);
    if (!com.tencent.mm.kernel.h.aHB())
    {
      Log.v("MicorMsg.MallIndexBaseUIv2", "MMCore is not ready");
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
    addSceneEndListener(4362);
    u.gJv();
    ai.a(this);
    this.EOD = getIntent().getStringExtra("key_func_id");
    Log.i("MicorMsg.MallIndexBaseUIv2", "mFuncId:" + this.EOD + " wallet_region: " + this.EOJ + " walletType: " + com.tencent.mm.model.z.bdg() + " default_region: " + i);
    this.Eyn = getIntent().getStringExtra("key_native_url");
    Log.i("MicorMsg.MallIndexBaseUIv2", "mNativeUrl:" + this.Eyn);
    if (isTransparent())
    {
      Log.i("MicorMsg.MallIndexBaseUIv2", "Oncreate：isTransparent()");
      return;
    }
    eHM();
    setContentViewVisibility(0);
    eQy();
    initView();
    com.tencent.mm.plugin.wallet_core.model.mall.c.gKO();
    eQz();
    if (com.tencent.mm.model.z.bdq()) {
      Log.e("MicorMsg.MallIndexBaseUIv2", "it is payu account ,not initFingerPrint");
    }
    for (;;)
    {
      ab.ny(1, 0);
      com.tencent.mm.plugin.report.service.h.IzE.a(11850, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
      return;
      paramBundle = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.fingerprint.d.a.class);
      if (paramBundle != null)
      {
        Log.i("MicorMsg.MallIndexBaseUIv2", "IFingerPrintMgr is not null, do showFingerPrintEntrance()");
        paramBundle.eom();
      }
      else
      {
        Log.e("MicorMsg.MallIndexBaseUIv2", "IFingerPrintMgr is not null");
      }
    }
  }
  
  public void onDestroy()
  {
    removeSceneEndListener(495);
    removeSceneEndListener(4362);
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
    Log.i("MicorMsg.MallIndexBaseUIv2", "onResume");
    if (!com.tencent.mm.kernel.h.aHB())
    {
      Log.v("MicorMsg.MallIndexBaseUIv2", "MMCore is not ready");
      finish();
    }
    if ((!isTransparent()) && (this.kDt != null)) {
      this.kDt.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(228991);
          a.k(MallIndexBaseUIv2.this);
          MallIndexBaseUIv2.this.updateView();
          AppMethodBeat.o(228991);
        }
      });
    }
    if (isTransparent())
    {
      this.EOE = k.eQr().Wq(this.EOJ);
      if ((this.EOE == null) || (this.EOE.size() <= 0))
      {
        Log.i("MicorMsg.MallIndexBaseUIv2", "mFunctionList == null");
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
          Log.printErrStackTrace("MicorMsg.MallIndexBaseUIv2", localUnsupportedEncodingException, "", new Object[0]);
          eQE();
          return;
        }
      }
      Object localObject3 = fU(this.EOE);
      Object localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = fV(this.EOE);
      }
      c((MallFunction)localObject2);
      finish();
      return;
    }
    eQB();
    Log.d("MicorMsg.MallIndexBaseUIv2", "initFunctionList");
    if (com.tencent.mm.plugin.wallet_core.model.mall.b.gKI().size() == 0)
    {
      Log.e("MicorMsg.MallIndexBaseUIv2", "funcitonlist invalid");
      doSceneProgress(new com.tencent.mm.plugin.mall.a.g(this.EOJ), true);
      i = 0;
    }
    while (i != 0)
    {
      Log.i("MicorMsg.MallIndexBaseUIv2", "has data");
      updateView();
      eQR();
      return;
      Log.i("MicorMsg.MallIndexBaseUIv2", "funcitonlist has cache");
      doSceneProgress(new com.tencent.mm.plugin.mall.a.g(this.EOJ), false);
      this.EQN = com.tencent.mm.plugin.wallet_core.model.mall.b.gKI();
    }
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    Log.d("MicorMsg.MallIndexBaseUIv2", "onSceneEnd :%s", new Object[] { Integer.valueOf(paramq.getType()) });
    if (paramq.getType() == 4362)
    {
      paramString = (com.tencent.mm.plugin.mall.a.g)paramq;
      if (paramString.EOJ != this.EOJ) {
        Log.i("MicorMsg.MallIndexBaseUIv2", "pass wallet local: %d cgi: %d", new Object[] { Integer.valueOf(this.EOJ), Integer.valueOf(paramString.EOJ) });
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.EQN = com.tencent.mm.plugin.wallet_core.model.mall.b.gKI();
        Log.i("MicorMsg.MallIndexBaseUIv2", "get from server now! " + this.EOJ + " " + this.EQN.size());
        com.tencent.mm.plugin.wallet_core.model.mall.c.gKL().bl(this.EQN);
        fW(this.EQN);
      }
      updateView();
      eQD();
      eQF();
      eQR();
      eQO();
    }
    do
    {
      return true;
      if (paramq.getType() != 495) {
        break;
      }
      paramString = (com.tencent.mm.plugin.mall.a.f)paramq;
      if (paramString.EOJ != this.EOJ) {
        Log.i("MicorMsg.MallIndexBaseUIv2", "pass wallet local: %d cgi: %d", new Object[] { Integer.valueOf(this.EOJ), Integer.valueOf(paramString.EOJ) });
      }
    } while (!isTransparent());
    Log.d("MicorMsg.MallIndexBaseUIv2", "errorType:%d | errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramString.EOE != null))
    {
      if (getIntent().getIntExtra("key_scene", 0) == 1)
      {
        paramString = fU(paramString.EOE);
        if (paramString != null) {
          c(paramString);
        }
      }
      for (;;)
      {
        setResult(-1);
        finish();
        return true;
        if (!Util.isNullOrNil(this.Eyn))
        {
          Log.d("MicorMsg.MallIndexBaseUIv2", "NativeUrl: %s", new Object[] { this.Eyn });
          paramString = fV(paramString.EOE);
          if (paramString != null)
          {
            c(paramString);
          }
          else
          {
            eQE();
            return true;
          }
        }
        else if ((paramString.EOE != null) && (paramString.EOE.size() > 0))
        {
          Log.i("MicorMsg.MallIndexBaseUIv2", "functionScene.mFunctionList != null");
          c(fU(paramString.EOE));
        }
        else if ((k.eQr().Wq(this.EOJ) != null) && (k.eQr().Wq(this.EOJ).size() > 0))
        {
          Log.i("MicorMsg.MallIndexBaseUIv2", "SubCoreMall.getCore().getFunctionList() != null");
          c(fU(k.eQr().Wq(this.EOJ)));
        }
        else
        {
          Log.e("MicorMsg.MallIndexBaseUIv2", "SubCoreMall.getCore().getFunctionList() == null");
        }
      }
    }
    eQE();
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
    if (this.EQM != null) {
      this.EQM.aE(this.EQN);
    }
    eQJ();
    eQM();
    eQK();
    eQL();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexBaseUIv2
 * JD-Core Version:    0.7.0.1
 */