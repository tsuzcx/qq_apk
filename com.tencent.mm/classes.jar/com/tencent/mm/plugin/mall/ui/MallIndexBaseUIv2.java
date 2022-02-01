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
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.sd;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.appbrand.api.WeAppOpenDeclarePromptBundle;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.appbrand.service.s;
import com.tencent.mm.plugin.appbrand.service.w;
import com.tencent.mm.plugin.mall.a.k;
import com.tencent.mm.plugin.wallet_core.model.ah;
import com.tencent.mm.plugin.wallet_core.model.l;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.protocal.protobuf.bfv;
import com.tencent.mm.protocal.protobuf.ewz;
import com.tencent.mm.protocal.protobuf.exb;
import com.tencent.mm.protocal.protobuf.exc;
import com.tencent.mm.protocal.protobuf.exn;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
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

public abstract class MallIndexBaseUIv2
  extends WalletBaseUI
  implements u.a, l
{
  private RelativeLayout hOX;
  protected String uuid;
  protected View vbj;
  private String yUq = null;
  private String zjn = null;
  private ArrayList<MallFunction> zjo = null;
  protected int zjs;
  private TextView zlg = null;
  protected ListView zlh = null;
  protected ImageView zlk;
  protected TextView zll = null;
  protected TextView zlm;
  private int zln = 0;
  protected View zlq;
  private boolean zlr = false;
  private c zlw = null;
  private ArrayList<bfv> zlx = null;
  
  private void c(MallFunction paramMallFunction)
  {
    if ((paramMallFunction != null) && (!Util.isNullOrNil(paramMallFunction.egX)) && (((s)com.tencent.mm.kernel.g.af(s.class)).n(paramMallFunction.egX, null)))
    {
      Log.i("MicorMsg.MallIndexBaseUIv2", "handleFunction, intercept by AppBrandNativeLink, nativeUrl = %s", new Object[] { paramMallFunction.egX });
      com.tencent.mm.plugin.wallet_core.model.mall.c.fSg().aVv(paramMallFunction.kHR);
      com.tencent.mm.plugin.wallet_core.model.mall.d.fSk().aVv(paramMallFunction.kHR);
      if (paramMallFunction.Icf != null)
      {
        com.tencent.mm.plugin.wallet_core.model.mall.c.fSg();
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
      ab.mg(15, 0);
      return;
    case 1: 
      e(paramMallFunction);
      return;
    case 2: 
      ehj();
      return;
    }
    ehi();
  }
  
  private void d(MallFunction paramMallFunction)
  {
    Intent localIntent = new Intent();
    if (isTransparent()) {
      localIntent.putExtra("key_is_hide_progress", true);
    }
    localIntent.putExtra("key_func_info", paramMallFunction);
    com.tencent.mm.br.c.b(this, "recharge", ".ui.PhoneRechargeUI", localIntent);
  }
  
  private void e(MallFunction paramMallFunction)
  {
    com.tencent.mm.kernel.g.aAi();
    this.zjs = ((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NXG, Integer.valueOf(0))).intValue();
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramMallFunction.h5Url);
    localIntent.putExtra("geta8key_username", z.aTY());
    localIntent.putExtra("pay_channel", 1);
    localIntent.putExtra("KPublisherId", "pay_wallet");
    localIntent.putExtra("key_download_restrict", paramMallFunction.Ich);
    localIntent.putExtra("key_wallet_region", this.zjs);
    localIntent.putExtra("key_function_id", paramMallFunction.kHR);
    localIntent.putExtra(e.p.OzJ, true);
    localIntent.putExtra("geta8key_scene", 46);
    com.tencent.mm.wallet_core.ui.f.aA(getContext(), localIntent);
  }
  
  private void egX()
  {
    boolean bool = getIntent().getBooleanExtra("key_wallet_has_red", false);
    if (this.zlh.getChildCount() == 0) {}
    for (;;)
    {
      return;
      int i = this.zlh.getFirstVisiblePosition();
      int j = this.zlh.getChildAt(0).getTop();
      Log.i("MicorMsg.MallIndexBaseUIv2", "initCheckNew %s fpos %s top %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j) });
      if ((i == 0) && (j == 0) && (bool) && (!this.zlr) && (this.zlx != null))
      {
        this.zlr = true;
        j = this.zlh.getHeaderViewsCount() + this.zlw.getCount();
        Log.i("MicorMsg.MallIndexBaseUIv2", "mFunctionsGv.getHeaderViewsCount()： %s mFunctionAdapter.getCount(): %s", new Object[] { Integer.valueOf(this.zlh.getHeaderViewsCount()), Integer.valueOf(this.zlw.getCount()) });
        List localList = this.zlw.zke;
        if (localList != null)
        {
          i = localList.size() - 1;
          while (i > 0)
          {
            Iterator localIterator = ((ArrayList)localList.get(i)).iterator();
            while (localIterator.hasNext())
            {
              c.c localc = (c.c)localIterator.next();
              if ((localc != null) && (localc.zkP != null) && (c.a(localc.zkP)))
              {
                i = this.zlh.getFirstVisiblePosition();
                int k = this.zlh.getLastVisiblePosition();
                Log.i("MicorMsg.MallIndexBaseUIv2", "get listview show top %s bottom %s redPos: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j) });
                if ((j >= i) && (j <= k))
                {
                  Log.i("MicorMsg.MallIndexBaseUIv2", "the last redDot item is visible");
                  return;
                }
                int m = com.tencent.mm.cb.a.fromDPToPix(getContext(), 48);
                int n = com.tencent.mm.cb.a.fromDPToPix(getContext(), 8);
                int i1 = ((Integer)com.tencent.mm.plugin.wallet_core.model.mall.b.fSb().get(localc.zkP.LPy)).intValue();
                int i2 = ehh();
                int i3 = a.egM();
                k = com.tencent.mm.ui.ao.az(this).y;
                i = k;
                if (com.tencent.mm.ui.ao.aA(this)) {
                  i = k - com.tencent.mm.ui.ao.aD(this);
                }
                k = i;
                if (getSupportActionBar() != null) {
                  k = i - getSupportActionBar().getHeight();
                }
                i = this.zlh.getScrollY();
                int i4 = a.egM() / 3;
                this.zlh.smoothScrollBy((j + 1) * i3 + i2 + i1 * (m + n) - k - i + i4, 1000);
                Log.i("MicorMsg.MallIndexBaseUIv2", "offset function is %s, groupName is %s", new Object[] { localc.zkP.LPr.Name, Integer.valueOf(localc.zkP.LPy) });
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
  
  private void egY()
  {
    setResult(0);
    finish();
  }
  
  private void ehe()
  {
    if (this.zlg != null) {
      this.zlg.setVisibility(8);
    }
  }
  
  private void ehi()
  {
    Log.w("MicorMsg.MallIndexBaseUIv2", "doSelectFunction do nothing");
    u.makeText(this, "fuction list error", 1).show();
  }
  
  private static void ehj()
  {
    Log.w("MicorMsg.MallIndexBaseUIv2", "doSelectFunction no jump");
  }
  
  private void ehk()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    int i = this.zlh.getLastVisiblePosition();
    if (i <= this.zlh.getHeaderViewsCount()) {}
    label178:
    do
    {
      return;
      if (i <= this.zlh.getHeaderViewsCount() + this.zlw.getCount())
      {
        i -= this.zlh.getHeaderViewsCount();
        localObject = this.zlw.zke;
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
              localStringBuilder1.append(Long.toString(localc.zkP.LPr.Nuz & 0xFFFFFFFF));
              localStringBuilder1.append(";");
              continue;
              i = this.zlw.getCount();
              break;
            }
          }
        }
        j += 1;
      }
    } while (i - 1 < 0);
    Object localObject = (c.c)((ArrayList)((List)localObject).get(i - 1)).get(0);
    int j = ((Integer)com.tencent.mm.plugin.wallet_core.model.mall.b.fSb().get(((c.c)localObject).zkP.LPy)).intValue();
    localObject = com.tencent.mm.plugin.wallet_core.model.mall.b.fSc();
    i = 0;
    while (i < j)
    {
      localStringBuilder2.append(((ArrayList)localObject).get(i));
      localStringBuilder2.append(";");
      i += 1;
    }
    Log.i("MicorMsg.MallIndexBaseUIv2", "exposure report productID：%s、groupId：%s", new Object[] { localStringBuilder1, localStringBuilder2 });
    com.tencent.mm.plugin.report.service.h.CyF.a(20548, new Object[] { localStringBuilder1, localStringBuilder2 });
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
  
  private static void fu(List<bfv> paramList)
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
        bfv localbfv = (bfv)paramList.next();
        if ((localbfv.LPt != null) && (localbfv.LPt.type == 2) && (localbfv.LPt.Nuy != null) && (!TextUtils.isEmpty(localbfv.LPt.Nuy.username))) {
          localLinkedList.add(localbfv.LPt.Nuy.username);
        }
      }
    } while (localLinkedList.isEmpty());
    ((w)com.tencent.mm.kernel.g.af(w.class)).bh(localLinkedList);
  }
  
  public final boolean a(bfv parambfv, int paramInt)
  {
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.rYk, 1) == 1) {}
    for (int i = 1; i == 0; i = 0)
    {
      Log.i("MicorMsg.MallIndexBaseUIv2", "handleFunctionByAppBrand clicfg_appbrand_dialog_optimize_switch close");
      return false;
    }
    if ((parambfv.LPt == null) && (parambfv.LPt.type != 2))
    {
      Log.i("MicorMsg.MallIndexBaseUIv2", "functionItem.Entrance == null");
      return false;
    }
    if ((parambfv != null) && (paramInt >= 0)) {
      if ((parambfv.LPs == null) || (Util.isNullOrNil(parambfv.LPs.Nus))) {
        break label858;
      }
    }
    label187:
    label840:
    label853:
    label858:
    for (Object localObject1 = Long.toString(parambfv.LPs.Nus & 0xFFFFFFFF);; localObject1 = "")
    {
      int j;
      boolean bool;
      Object localObject2;
      long l;
      int m;
      Object localObject3;
      if (this.zlx == null)
      {
        j = 0;
        bool = c.a(parambfv);
        localObject2 = com.tencent.mm.plugin.wallet_core.model.mall.b.fSe();
        if (((SparseArray)localObject2).size() != 0)
        {
          l = parambfv.LPy;
          localObject2 = (ArrayList)((SparseArray)localObject2).get(parambfv.LPy);
          m = ((ArrayList)localObject2).size();
          i = 0;
          if (i >= ((ArrayList)localObject2).size()) {
            break label853;
          }
          localObject3 = (Integer)((ArrayList)localObject2).get(i);
          if ((localObject3 == null) || (((Integer)localObject3).compareTo(Integer.valueOf(parambfv.LPr.Nuz)) != 0)) {
            break label840;
          }
        }
      }
      for (;;)
      {
        Log.i("MicorMsg.MallIndexBaseUIv2", "click report activityId:%s,FunctionID：%s", new Object[] { localObject1, Long.toString(parambfv.LPr.Nuz & 0xFFFFFFFF) });
        localObject2 = com.tencent.mm.plugin.report.service.h.CyF;
        localObject3 = Long.toString(parambfv.LPr.Nuz & 0xFFFFFFFF);
        if (bool) {}
        for (int k = 2;; k = 1)
        {
          ((com.tencent.mm.plugin.report.service.h)localObject2).a(10881, new Object[] { localObject3, Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(paramInt), localObject1, Integer.valueOf(k), Integer.valueOf(2), Long.valueOf(l), Integer.valueOf(m), Integer.valueOf(i) });
          com.tencent.mm.plugin.wallet_core.model.mall.c.fSg().aVv(parambfv.LPr.Nuz);
          com.tencent.mm.plugin.wallet_core.model.mall.d.fSk().aVv(parambfv.LPr.Nuz);
          if (parambfv.LPs != null)
          {
            localObject1 = new MallFunction();
            ((MallFunction)localObject1).kHR = parambfv.LPr.Nuz;
            ((MallFunction)localObject1).edq = parambfv.LPr.Name;
            ((MallFunction)localObject1).Icf = new MallNews(((MallFunction)localObject1).kHR);
            ((MallFunction)localObject1).Icf.FJm = parambfv.LPs.Nus;
            com.tencent.mm.plugin.wallet_core.model.mall.c.fSg();
            com.tencent.mm.plugin.wallet_core.model.mall.c.i((MallFunction)localObject1);
          }
          Log.i("MicorMsg.MallIndexBaseUIv2", "handleFunctionNew id：%s，name：%s，type：%s", new Object[] { Integer.valueOf(parambfv.LPr.Nuz), parambfv.LPr.Name, Integer.valueOf(parambfv.LPt.type) });
          Log.i("MicorMsg.MallIndexBaseUIv2", "handleFunctionNew functionItem.Entrance.URLWeApp.username：%s,functionItem.Entrance.URLWeApp.pagepath:%s,functionItem.Entrance.URLWeApp.version:%s", new Object[] { parambfv.LPt.Nuy.username, parambfv.LPt.Nuy.Cqk, Integer.valueOf(parambfv.LPt.Nuy.version) });
          localObject1 = new com.tencent.mm.plugin.appbrand.api.g();
          ((com.tencent.mm.plugin.appbrand.api.g)localObject1).username = parambfv.LPt.Nuy.username;
          ((com.tencent.mm.plugin.appbrand.api.g)localObject1).version = parambfv.LPt.Nuy.version;
          ((com.tencent.mm.plugin.appbrand.api.g)localObject1).kHw = parambfv.LPt.Nuy.Cqk;
          ((com.tencent.mm.plugin.appbrand.api.g)localObject1).iOo = 0;
          ((com.tencent.mm.plugin.appbrand.api.g)localObject1).scene = 1019;
          localObject2 = getString(2131762954);
          localObject3 = getString(2131755873);
          WeAppOpenDeclarePromptBundle localWeAppOpenDeclarePromptBundle = new WeAppOpenDeclarePromptBundle((byte)0);
          localWeAppOpenDeclarePromptBundle.fuQ = 2;
          localWeAppOpenDeclarePromptBundle.kHS = ((String)localObject2);
          localWeAppOpenDeclarePromptBundle.kHT = parambfv.LPw;
          localWeAppOpenDeclarePromptBundle.kHU = ((String)localObject3);
          localWeAppOpenDeclarePromptBundle.ox = false;
          localWeAppOpenDeclarePromptBundle.kHR = parambfv.LPr.Nuz;
          ((com.tencent.mm.plugin.appbrand.api.g)localObject1).kHJ = localWeAppOpenDeclarePromptBundle;
          ((r)com.tencent.mm.kernel.g.af(r.class)).a(getContext(), (com.tencent.mm.plugin.appbrand.api.g)localObject1);
          return true;
          j = this.zlx.size();
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
  
  protected abstract void dYP();
  
  protected abstract void egS();
  
  protected abstract void egT();
  
  protected abstract boolean egV();
  
  protected abstract void egZ();
  
  protected abstract void eha();
  
  protected abstract void ehb();
  
  protected abstract void ehd();
  
  protected abstract void ehf();
  
  protected abstract void ehg();
  
  protected abstract int ehh();
  
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
    Log.d("MicorMsg.MallIndexBaseUIv2", "index initView");
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(213555);
        paramAnonymousMenuItem = new Intent();
        paramAnonymousMenuItem.addFlags(67108864);
        paramAnonymousMenuItem.putExtra("preferred_tab", 3);
        com.tencent.mm.br.c.f(MallIndexBaseUIv2.this, "com.tencent.mm.ui.LauncherUI", paramAnonymousMenuItem);
        MallIndexBaseUIv2.this.finish();
        if (!com.tencent.mm.pluginsdk.wallet.e.gsQ())
        {
          com.tencent.mm.plugin.report.service.h.CyF.a(14954, new Object[] { com.tencent.mm.pluginsdk.wallet.e.gsR(), "open_wcpay_specific_view:ok" });
          com.tencent.mm.pluginsdk.wallet.e.gsS();
        }
        com.tencent.mm.plugin.report.service.h.CyF.a(14419, new Object[] { MallIndexBaseUIv2.this.uuid, Integer.valueOf(6) });
        Log.i("MicorMsg.MallIndexBaseUIv2", "set BackBtn");
        AppMethodBeat.o(213555);
        return true;
      }
    });
    this.hOX = ((RelativeLayout)findViewById(2131307165));
    this.zlh = ((ListView)findViewById(2131304357));
    initHeaderView();
    egZ();
    this.zlw = new c(this);
    this.zlh.setAdapter(this.zlw);
    this.zlw.zkK = new c.d()
    {
      public final void a(final int paramAnonymousInt, final bfv paramAnonymousbfv)
      {
        AppMethodBeat.i(213558);
        if (paramAnonymousbfv != null)
        {
          int i;
          if ((!com.tencent.mm.plugin.wallet_core.model.mall.b.a.aVs(paramAnonymousbfv.LPr.Nuz)) && (!Util.isNullOrNil(paramAnonymousbfv.LPw)))
          {
            i = 1;
            if (i == 0) {
              break label276;
            }
            Log.i("MicorMsg.MallIndexBaseUIv2", "onFunctionItemClick show disclaimer funcId=%s", new Object[] { paramAnonymousbfv.LPr.Nuz });
            if (!MallIndexBaseUIv2.this.a(paramAnonymousbfv, paramAnonymousInt))
            {
              d.a locala = new d.a(MallIndexBaseUIv2.this.getContext());
              String str1 = MallIndexBaseUIv2.this.getString(2131762954);
              String str2 = MallIndexBaseUIv2.this.getString(2131755873);
              locala.bon(str1);
              locala.boo(paramAnonymousbfv.LPw);
              locala.bou(str2).c(new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(213556);
                  Log.i("MicorMsg.MallIndexBaseUIv2", "onFunctionItemClick: onClick");
                  com.tencent.mm.plugin.wallet_core.model.mall.b.a.aVr(paramAnonymousbfv.LPr.Nuz);
                  MallIndexBaseUIv2.a(MallIndexBaseUIv2.this, paramAnonymousbfv, paramAnonymousInt);
                  AppMethodBeat.o(213556);
                }
              });
              locala.Dk(true);
              locala.f(new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(213557);
                  Log.i("MicorMsg.MallIndexBaseUIv2", "onFunctionItemClick: onCancel");
                  com.tencent.mm.plugin.wallet_core.model.mall.b.a.aVr(paramAnonymousbfv.LPr.Nuz);
                  AppMethodBeat.o(213557);
                }
              });
              locala.hbn().show();
            }
          }
          for (;;)
          {
            Log.d("MicorMsg.MallIndexBaseUIv2", "type: %s", new Object[] { Integer.valueOf(paramAnonymousbfv.LPy) });
            com.tencent.mm.plugin.report.service.h.CyF.a(14419, new Object[] { MallIndexBaseUIv2.this.uuid, Integer.valueOf(4), Integer.valueOf(paramAnonymousbfv.LPy) });
            AppMethodBeat.o(213558);
            return;
            i = 0;
            break;
            label276:
            MallIndexBaseUIv2.a(MallIndexBaseUIv2.this, paramAnonymousbfv, paramAnonymousInt);
          }
        }
        Log.w("MicorMsg.MallIndexBaseUIv2", "onFunctionItemClick functionItem null; pos=%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(213558);
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
      com.tencent.mm.kernel.g.aAi();
      this.zjs = ((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NXG, Integer.valueOf(0))).intValue();
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
    Log.i("MicorMsg.MallIndexBaseUIv2", "onCreate");
    super.onCreate(paramBundle);
    if (!com.tencent.mm.kernel.g.aAc())
    {
      Log.v("MicorMsg.MallIndexBaseUIv2", "MMCore is not ready");
      finish();
    }
    com.tencent.mm.kernel.g.aAi();
    int i = ((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NXG, Integer.valueOf(0))).intValue();
    this.zjs = getIntent().getIntExtra("key_wallet_region", i);
    this.uuid = getIntent().getStringExtra("key_uuid");
    if (Util.isNullOrNil(this.uuid)) {
      this.uuid = UUID.randomUUID().toString();
    }
    addSceneEndListener(495);
    addSceneEndListener(4362);
    t.fQP();
    ah.a(this);
    this.zjn = getIntent().getStringExtra("key_func_id");
    Log.i("MicorMsg.MallIndexBaseUIv2", "mFuncId:" + this.zjn + " wallet_region: " + this.zjs + " walletType: " + z.aUf() + " default_region: " + i);
    this.yUq = getIntent().getStringExtra("key_native_url");
    Log.i("MicorMsg.MallIndexBaseUIv2", "mNativeUrl:" + this.yUq);
    if (isTransparent())
    {
      Log.i("MicorMsg.MallIndexBaseUIv2", "Oncreate：isTransparent()");
      return;
    }
    dYP();
    setContentViewVisibility(0);
    egS();
    initView();
    com.tencent.mm.plugin.wallet_core.model.mall.c.fSj();
    egT();
    if (z.aUo()) {
      Log.e("MicorMsg.MallIndexBaseUIv2", "it is payu account ,not initFingerPrint");
    }
    for (;;)
    {
      ab.mg(1, 0);
      com.tencent.mm.plugin.report.service.h.CyF.a(11850, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
      return;
      paramBundle = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.fingerprint.d.a.class);
      if (paramBundle != null)
      {
        Log.i("MicorMsg.MallIndexBaseUIv2", "IFingerPrintMgr is not null, do showFingerPrintEntrance()");
        paramBundle.dJN();
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
    Log.i("MicorMsg.MallIndexBaseUIv2", "onResume");
    if (!com.tencent.mm.kernel.g.aAc())
    {
      Log.v("MicorMsg.MallIndexBaseUIv2", "MMCore is not ready");
      finish();
    }
    if ((!isTransparent()) && (this.hOX != null)) {
      this.hOX.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(213554);
          a.j(MallIndexBaseUIv2.this);
          MallIndexBaseUIv2.this.updateView();
          AppMethodBeat.o(213554);
        }
      });
    }
    if (isTransparent())
    {
      this.zjo = k.egL().Qe(this.zjs);
      if ((this.zjo == null) || (this.zjo.size() <= 0))
      {
        Log.i("MicorMsg.MallIndexBaseUIv2", "mFunctionList == null");
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
          Log.printErrStackTrace("MicorMsg.MallIndexBaseUIv2", localUnsupportedEncodingException, "", new Object[0]);
          egY();
          return;
        }
      }
      Object localObject3 = fs(this.zjo);
      Object localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = ft(this.zjo);
      }
      c((MallFunction)localObject2);
      finish();
      return;
    }
    egV();
    Log.d("MicorMsg.MallIndexBaseUIv2", "initFunctionList");
    if (com.tencent.mm.plugin.wallet_core.model.mall.b.fSd().size() == 0)
    {
      Log.e("MicorMsg.MallIndexBaseUIv2", "funcitonlist invalid");
      doSceneProgress(new com.tencent.mm.plugin.mall.a.g(this.zjs), true);
      i = 0;
    }
    while (i != 0)
    {
      Log.i("MicorMsg.MallIndexBaseUIv2", "has data");
      updateView();
      ehk();
      return;
      Log.i("MicorMsg.MallIndexBaseUIv2", "funcitonlist has cache");
      doSceneProgress(new com.tencent.mm.plugin.mall.a.g(this.zjs), false);
      this.zlx = com.tencent.mm.plugin.wallet_core.model.mall.b.fSd();
    }
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    Log.d("MicorMsg.MallIndexBaseUIv2", "onSceneEnd :%s", new Object[] { Integer.valueOf(paramq.getType()) });
    if (paramq.getType() == 4362)
    {
      paramString = (com.tencent.mm.plugin.mall.a.g)paramq;
      if (paramString.zjs != this.zjs) {
        Log.i("MicorMsg.MallIndexBaseUIv2", "pass wallet local: %d cgi: %d", new Object[] { Integer.valueOf(this.zjs), Integer.valueOf(paramString.zjs) });
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.zlx = com.tencent.mm.plugin.wallet_core.model.mall.b.fSd();
        Log.i("MicorMsg.MallIndexBaseUIv2", "get from server now! " + this.zjs + " " + this.zlx.size());
        com.tencent.mm.plugin.wallet_core.model.mall.c.fSg().aX(this.zlx);
        fu(this.zlx);
      }
      updateView();
      egX();
      egZ();
      ehk();
    }
    do
    {
      return true;
      if (paramq.getType() != 495) {
        break;
      }
      paramString = (com.tencent.mm.plugin.mall.a.f)paramq;
      if (paramString.zjs != this.zjs) {
        Log.i("MicorMsg.MallIndexBaseUIv2", "pass wallet local: %d cgi: %d", new Object[] { Integer.valueOf(this.zjs), Integer.valueOf(paramString.zjs) });
      }
    } while (!isTransparent());
    Log.d("MicorMsg.MallIndexBaseUIv2", "errorType:%d | errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramString.zjo != null))
    {
      if (getIntent().getIntExtra("key_scene", 0) == 1)
      {
        paramString = fs(paramString.zjo);
        if (paramString != null) {
          c(paramString);
        }
      }
      for (;;)
      {
        setResult(-1);
        finish();
        return true;
        if (!Util.isNullOrNil(this.yUq))
        {
          Log.d("MicorMsg.MallIndexBaseUIv2", "NativeUrl: %s", new Object[] { this.yUq });
          paramString = ft(paramString.zjo);
          if (paramString != null)
          {
            c(paramString);
          }
          else
          {
            egY();
            return true;
          }
        }
        else if ((paramString.zjo != null) && (paramString.zjo.size() > 0))
        {
          Log.i("MicorMsg.MallIndexBaseUIv2", "functionScene.mFunctionList != null");
          c(fs(paramString.zjo));
        }
        else if ((k.egL().Qe(this.zjs) != null) && (k.egL().Qe(this.zjs).size() > 0))
        {
          Log.i("MicorMsg.MallIndexBaseUIv2", "SubCoreMall.getCore().getFunctionList() != null");
          c(fs(k.egL().Qe(this.zjs)));
        }
        else
        {
          Log.e("MicorMsg.MallIndexBaseUIv2", "SubCoreMall.getCore().getFunctionList() == null");
        }
      }
    }
    egY();
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
    if (this.zlw != null) {
      this.zlw.ax(this.zlx);
    }
    ehd();
    ehg();
    ehe();
    ehf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexBaseUIv2
 * JD-Core Version:    0.7.0.1
 */