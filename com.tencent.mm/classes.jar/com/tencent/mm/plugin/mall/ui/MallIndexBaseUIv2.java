package com.tencent.mm.plugin.mall.ui;

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
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.ut;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.appbrand.api.WeAppOpenDeclarePromptBundle;
import com.tencent.mm.plugin.appbrand.service.ab;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.appbrand.service.y;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.mall.a.k;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.l;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wallet_core.model.mall.b;
import com.tencent.mm.plugin.wallet_core.model.mall.b.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.caq;
import com.tencent.mm.protocal.protobuf.gdy;
import com.tencent.mm.protocal.protobuf.gea;
import com.tencent.mm.protocal.protobuf.geb;
import com.tencent.mm.protocal.protobuf.gem;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.f.s;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.wallet_core.model.ac;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.WcPayBannerView;
import com.tencent.mm.wallet_core.ui.i;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public abstract class MallIndexBaseUIv2
  extends WalletBaseUI
  implements r.a, l
{
  protected View Fag;
  private String KJc = null;
  private ArrayList<MallFunction> KJd = null;
  protected int KJh;
  private TextView KKU = null;
  protected ListView KKV = null;
  protected ImageView KKY;
  protected TextView KKZ = null;
  protected TextView KLa;
  private int KLb = 0;
  protected View KLe;
  private boolean KLf = false;
  private c KLk = null;
  private ArrayList<caq> KLl = null;
  private String Kra = null;
  private RelativeLayout ngJ;
  protected WcPayBannerView pLM;
  protected String uuid;
  
  private void c(MallFunction paramMallFunction)
  {
    if ((paramMallFunction != null) && (!Util.isNullOrNil(paramMallFunction.ihx)) && (((com.tencent.mm.plugin.appbrand.service.u)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.u.class)).s(paramMallFunction.ihx, null)))
    {
      Log.i("MicorMsg.MallIndexBaseUIv2", "handleFunction, intercept by AppBrandNativeLink, nativeUrl = %s", new Object[] { paramMallFunction.ihx });
      com.tencent.mm.plugin.wallet_core.model.mall.c.ikd().bgO(paramMallFunction.qBb);
      com.tencent.mm.plugin.wallet_core.model.mall.d.ikh().bgO(paramMallFunction.qBb);
      if (paramMallFunction.VKI != null)
      {
        com.tencent.mm.plugin.wallet_core.model.mall.c.ikd();
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
      ac.pu(15, 0);
      return;
    case 1: 
      e(paramMallFunction);
      return;
    case 2: 
      fZA();
      return;
    }
    fZz();
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
    com.tencent.mm.kernel.h.baF();
    this.KJh = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acNa, Integer.valueOf(0))).intValue();
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramMallFunction.h5Url);
    localIntent.putExtra("geta8key_username", z.bAM());
    localIntent.putExtra("pay_channel", 1);
    localIntent.putExtra("KPublisherId", "pay_wallet");
    localIntent.putExtra("key_download_restrict", paramMallFunction.VKK);
    localIntent.putExtra("key_wallet_region", this.KJh);
    localIntent.putExtra("key_function_id", paramMallFunction.qBb);
    localIntent.putExtra(f.s.adxf, true);
    localIntent.putExtra("geta8key_scene", 46);
    i.aS(getContext(), localIntent);
  }
  
  private static void fZA()
  {
    Log.w("MicorMsg.MallIndexBaseUIv2", "doSelectFunction no jump");
  }
  
  private void fZB()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    int i = this.KKV.getLastVisiblePosition();
    if (i <= this.KKV.getHeaderViewsCount()) {}
    label178:
    do
    {
      return;
      if (i <= this.KKV.getHeaderViewsCount() + this.KLk.getCount())
      {
        i -= this.KKV.getHeaderViewsCount();
        localObject = this.KLk.KJR;
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
              localStringBuilder1.append(Long.toString(localc.KKC.aajz.acbJ & 0xFFFFFFFF));
              localStringBuilder1.append(";");
              continue;
              i = this.KLk.getCount();
              break;
            }
          }
        }
        j += 1;
      }
    } while (i - 1 < 0);
    Object localObject = (c.c)((ArrayList)((List)localObject).get(i - 1)).get(0);
    int j = ((Integer)b.ijY().get(((c.c)localObject).KKC.aajG)).intValue();
    localObject = b.ijZ();
    i = 0;
    while (i < j)
    {
      localStringBuilder2.append(((ArrayList)localObject).get(i));
      localStringBuilder2.append(";");
      i += 1;
    }
    Log.i("MicorMsg.MallIndexBaseUIv2", "exposure report productID：%s、groupId：%s", new Object[] { localStringBuilder1, localStringBuilder2 });
    com.tencent.mm.plugin.report.service.h.OAn.b(20548, new Object[] { localStringBuilder1, localStringBuilder2 });
  }
  
  private void fZn()
  {
    boolean bool = getIntent().getBooleanExtra("key_wallet_has_red", false);
    if (this.KKV.getChildCount() == 0) {}
    for (;;)
    {
      return;
      int i = this.KKV.getFirstVisiblePosition();
      int j = this.KKV.getChildAt(0).getTop();
      Log.i("MicorMsg.MallIndexBaseUIv2", "initCheckNew %s fpos %s top %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j) });
      if ((i == 0) && (j == 0) && (bool) && (!this.KLf) && (this.KLl != null))
      {
        this.KLf = true;
        j = this.KKV.getHeaderViewsCount() + this.KLk.getCount();
        Log.i("MicorMsg.MallIndexBaseUIv2", "mFunctionsGv.getHeaderViewsCount()： %s mFunctionAdapter.getCount(): %s", new Object[] { Integer.valueOf(this.KKV.getHeaderViewsCount()), Integer.valueOf(this.KLk.getCount()) });
        List localList = this.KLk.KJR;
        if (localList != null)
        {
          i = localList.size() - 1;
          while (i > 0)
          {
            Iterator localIterator = ((ArrayList)localList.get(i)).iterator();
            while (localIterator.hasNext())
            {
              c.c localc = (c.c)localIterator.next();
              if ((localc != null) && (localc.KKC != null) && (c.a(localc.KKC)))
              {
                i = this.KKV.getFirstVisiblePosition();
                int k = this.KKV.getLastVisiblePosition();
                Log.i("MicorMsg.MallIndexBaseUIv2", "get listview show top %s bottom %s redPos: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j) });
                if ((j >= i) && (j <= k))
                {
                  Log.i("MicorMsg.MallIndexBaseUIv2", "the last redDot item is visible");
                  return;
                }
                int m = com.tencent.mm.cd.a.fromDPToPix(getContext(), 48);
                int n = com.tencent.mm.cd.a.fromDPToPix(getContext(), 8);
                int i1 = ((Integer)b.ijY().get(localc.KKC.aajG)).intValue();
                int i2 = fZx();
                int i3 = a.fZc();
                k = aw.bf(this).y;
                i = k;
                if (aw.bg(this)) {
                  i = k - aw.bk(this);
                }
                k = i;
                if (getSupportActionBar() != null) {
                  k = i - getSupportActionBar().getHeight();
                }
                i = this.KKV.getScrollY();
                int i4 = a.fZc() / 3;
                this.KKV.smoothScrollBy((j + 1) * i3 + i2 + i1 * (m + n) - k - i + i4, 1000);
                Log.i("MicorMsg.MallIndexBaseUIv2", "offset function is %s, groupName is %s", new Object[] { localc.KKC.aajz.IGU, Integer.valueOf(localc.KKC.aajG) });
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
  
  private void fZo()
  {
    setResult(0);
    finish();
  }
  
  private void fZu()
  {
    if (this.KKU != null) {
      this.KKU.setVisibility(8);
    }
  }
  
  private void fZy()
  {
    Object localObject1;
    Object localObject2;
    if ((this.KLl != null) && (this.KLl.size() > 0))
    {
      localObject1 = this.KLl.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (caq)((Iterator)localObject1).next();
        if ((((caq)localObject2).aajB != null) && (((caq)localObject2).aajB.type == 2)) {
          ((com.tencent.mm.plugin.appbrand.service.g)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.g.class)).b(ab.tUc);
        }
      }
    }
    do
    {
      do
      {
        return;
        localObject2 = this.KLl;
      } while ((localObject2 == null) || (((List)localObject2).isEmpty()));
      localObject1 = new LinkedList();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        caq localcaq = (caq)((Iterator)localObject2).next();
        if ((localcaq.aajB != null) && (localcaq.aajB.type == 2) && (localcaq.aajB.acbI != null) && (!TextUtils.isEmpty(localcaq.aajB.acbI.username))) {
          ((List)localObject1).add(localcaq.aajB.acbI.username);
        }
      }
    } while (((List)localObject1).isEmpty());
    ((y)com.tencent.mm.kernel.h.ax(y.class)).cN((List)localObject1);
  }
  
  private void fZz()
  {
    Log.w("MicorMsg.MallIndexBaseUIv2", "doSelectFunction do nothing");
    aa.makeText(this, "fuction list error", 1).show();
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
  
  public final boolean a(caq paramcaq, int paramInt)
  {
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yUB, 1) == 1) {}
    for (int i = 1; i == 0; i = 0)
    {
      Log.i("MicorMsg.MallIndexBaseUIv2", "handleFunctionByAppBrand clicfg_appbrand_dialog_optimize_switch close");
      return false;
    }
    if ((paramcaq.aajB == null) && (paramcaq.aajB.type != 2))
    {
      Log.i("MicorMsg.MallIndexBaseUIv2", "functionItem.Entrance == null");
      return false;
    }
    if ((paramcaq != null) && (paramInt >= 0)) {
      if ((paramcaq.aajA == null) || (Util.isNullOrNil(paramcaq.aajA.acbD))) {
        break label858;
      }
    }
    label187:
    label840:
    label853:
    label858:
    for (Object localObject1 = Long.toString(paramcaq.aajA.acbD & 0xFFFFFFFF);; localObject1 = "")
    {
      int j;
      boolean bool;
      Object localObject2;
      long l;
      int m;
      Object localObject3;
      if (this.KLl == null)
      {
        j = 0;
        bool = c.a(paramcaq);
        localObject2 = b.ikb();
        if (((SparseArray)localObject2).size() != 0)
        {
          l = paramcaq.aajG;
          localObject2 = (ArrayList)((SparseArray)localObject2).get(paramcaq.aajG);
          m = ((ArrayList)localObject2).size();
          i = 0;
          if (i >= ((ArrayList)localObject2).size()) {
            break label853;
          }
          localObject3 = (Integer)((ArrayList)localObject2).get(i);
          if ((localObject3 == null) || (((Integer)localObject3).compareTo(Integer.valueOf(paramcaq.aajz.acbJ)) != 0)) {
            break label840;
          }
        }
      }
      for (;;)
      {
        Log.i("MicorMsg.MallIndexBaseUIv2", "click report activityId:%s,FunctionID：%s", new Object[] { localObject1, Long.toString(paramcaq.aajz.acbJ & 0xFFFFFFFF) });
        localObject2 = com.tencent.mm.plugin.report.service.h.OAn;
        localObject3 = Long.toString(paramcaq.aajz.acbJ & 0xFFFFFFFF);
        if (bool) {}
        for (int k = 2;; k = 1)
        {
          ((com.tencent.mm.plugin.report.service.h)localObject2).b(10881, new Object[] { localObject3, Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(paramInt), localObject1, Integer.valueOf(k), Integer.valueOf(2), Long.valueOf(l), Integer.valueOf(m), Integer.valueOf(i) });
          com.tencent.mm.plugin.wallet_core.model.mall.c.ikd().bgO(paramcaq.aajz.acbJ);
          com.tencent.mm.plugin.wallet_core.model.mall.d.ikh().bgO(paramcaq.aajz.acbJ);
          if (paramcaq.aajA != null)
          {
            localObject1 = new MallFunction();
            ((MallFunction)localObject1).qBb = paramcaq.aajz.acbJ;
            ((MallFunction)localObject1).idA = paramcaq.aajz.IGU;
            ((MallFunction)localObject1).VKI = new MallNews(((MallFunction)localObject1).qBb);
            ((MallFunction)localObject1).VKI.rBJ = paramcaq.aajA.acbD;
            com.tencent.mm.plugin.wallet_core.model.mall.c.ikd();
            com.tencent.mm.plugin.wallet_core.model.mall.c.i((MallFunction)localObject1);
          }
          Log.i("MicorMsg.MallIndexBaseUIv2", "handleFunctionNew id：%s，name：%s，type：%s", new Object[] { Integer.valueOf(paramcaq.aajz.acbJ), paramcaq.aajz.IGU, Integer.valueOf(paramcaq.aajB.type) });
          Log.i("MicorMsg.MallIndexBaseUIv2", "handleFunctionNew functionItem.Entrance.URLWeApp.username：%s,functionItem.Entrance.URLWeApp.pagepath:%s,functionItem.Entrance.URLWeApp.version:%s", new Object[] { paramcaq.aajB.acbI.username, paramcaq.aajB.acbI.OkP, Integer.valueOf(paramcaq.aajB.acbI.version) });
          localObject1 = new com.tencent.mm.plugin.appbrand.api.g();
          ((com.tencent.mm.plugin.appbrand.api.g)localObject1).username = paramcaq.aajB.acbI.username;
          ((com.tencent.mm.plugin.appbrand.api.g)localObject1).version = paramcaq.aajB.acbI.version;
          ((com.tencent.mm.plugin.appbrand.api.g)localObject1).qAF = paramcaq.aajB.acbI.OkP;
          ((com.tencent.mm.plugin.appbrand.api.g)localObject1).euz = 0;
          ((com.tencent.mm.plugin.appbrand.api.g)localObject1).scene = 1019;
          localObject2 = getString(a.i.mall_third_party_disclaimer_title);
          localObject3 = getString(a.i.app_i_know);
          WeAppOpenDeclarePromptBundle localWeAppOpenDeclarePromptBundle = new WeAppOpenDeclarePromptBundle((byte)0);
          localWeAppOpenDeclarePromptBundle.hyY = 2;
          localWeAppOpenDeclarePromptBundle.qBc = ((String)localObject2);
          localWeAppOpenDeclarePromptBundle.qBd = paramcaq.aajE;
          localWeAppOpenDeclarePromptBundle.qBe = ((String)localObject3);
          localWeAppOpenDeclarePromptBundle.dqR = false;
          localWeAppOpenDeclarePromptBundle.qBb = paramcaq.aajz.acbJ;
          ((com.tencent.mm.plugin.appbrand.api.g)localObject1).qAR = localWeAppOpenDeclarePromptBundle;
          ((t)com.tencent.mm.kernel.h.ax(t.class)).a(getContext(), (com.tencent.mm.plugin.appbrand.api.g)localObject1);
          return true;
          j = this.KLl.size();
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
  
  protected abstract void fPx();
  
  protected abstract void fZi();
  
  protected abstract void fZj();
  
  protected abstract boolean fZl();
  
  protected abstract void fZp();
  
  protected abstract void fZq();
  
  protected abstract void fZr();
  
  protected abstract void fZt();
  
  protected abstract void fZv();
  
  protected abstract void fZw();
  
  protected abstract int fZx();
  
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
    Log.d("MicorMsg.MallIndexBaseUIv2", "index initView");
    setBackBtn(new MallIndexBaseUIv2.2(this));
    this.ngJ = ((RelativeLayout)findViewById(a.f.root_layout));
    this.KKV = ((ListView)findViewById(a.f.mall_index_function_list));
    initHeaderView();
    fZp();
    this.KLk = new c(this);
    this.KKV.setAdapter(this.KLk);
    this.KLk.KKx = new c.d()
    {
      public final void a(final int paramAnonymousInt, final caq paramAnonymouscaq)
      {
        AppMethodBeat.i(262455);
        if (paramAnonymouscaq != null)
        {
          int i;
          if ((!b.a.bgL(paramAnonymouscaq.aajz.acbJ)) && (!Util.isNullOrNil(paramAnonymouscaq.aajE)))
          {
            i = 1;
            if (i == 0) {
              break label278;
            }
            Log.i("MicorMsg.MallIndexBaseUIv2", "onFunctionItemClick show disclaimer funcId=%s", new Object[] { paramAnonymouscaq.aajz.acbJ });
            if (!MallIndexBaseUIv2.this.a(paramAnonymouscaq, paramAnonymousInt))
            {
              e.a locala = new e.a(MallIndexBaseUIv2.this.getContext());
              String str1 = MallIndexBaseUIv2.this.getString(a.i.mall_third_party_disclaimer_title);
              String str2 = MallIndexBaseUIv2.this.getString(a.i.app_i_know);
              locala.bDv(str1);
              locala.bDw(paramAnonymouscaq.aajE);
              locala.bDC(str2).c(new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(262431);
                  Log.i("MicorMsg.MallIndexBaseUIv2", "onFunctionItemClick: onClick");
                  b.a.bgK(paramAnonymouscaq.aajz.acbJ);
                  MallIndexBaseUIv2.a(MallIndexBaseUIv2.this, paramAnonymouscaq, paramAnonymousInt);
                  AppMethodBeat.o(262431);
                }
              });
              locala.NC(true);
              locala.e(new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(262432);
                  Log.i("MicorMsg.MallIndexBaseUIv2", "onFunctionItemClick: onCancel");
                  b.a.bgK(paramAnonymouscaq.aajz.acbJ);
                  AppMethodBeat.o(262432);
                }
              });
              locala.jHH().show();
            }
          }
          for (;;)
          {
            Log.d("MicorMsg.MallIndexBaseUIv2", "type: %s", new Object[] { Integer.valueOf(paramAnonymouscaq.aajG) });
            com.tencent.mm.plugin.report.service.h.OAn.b(14419, new Object[] { MallIndexBaseUIv2.this.uuid, Integer.valueOf(4), Integer.valueOf(paramAnonymouscaq.aajG) });
            AppMethodBeat.o(262455);
            return;
            i = 0;
            break;
            label278:
            MallIndexBaseUIv2.a(MallIndexBaseUIv2.this, paramAnonymouscaq, paramAnonymousInt);
          }
        }
        Log.w("MicorMsg.MallIndexBaseUIv2", "onFunctionItemClick functionItem null; pos=%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(262455);
      }
    };
    ib(this.Fag);
    this.KLa = ((TextView)findViewById(a.f.banner_tips));
    this.pLM = ((WcPayBannerView)findViewById(a.f.wc_pay_banner_layout));
    this.pLM.jPz();
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
    Log.i("MicorMsg.MallIndexBaseUIv2", "onCreate");
    super.onCreate(paramBundle);
    if (!com.tencent.mm.kernel.h.baz())
    {
      Log.v("MicorMsg.MallIndexBaseUIv2", "MMCore is not ready");
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
    addSceneEndListener(4362);
    com.tencent.mm.plugin.wallet_core.model.u.iiJ();
    ag.a(this);
    this.KJc = getIntent().getStringExtra("key_func_id");
    Log.i("MicorMsg.MallIndexBaseUIv2", "mFuncId:" + this.KJc + " wallet_region: " + this.KJh + " walletType: " + z.bAV() + " default_region: " + i);
    this.Kra = getIntent().getStringExtra("key_native_url");
    Log.i("MicorMsg.MallIndexBaseUIv2", "mNativeUrl:" + this.Kra);
    if (isTransparent())
    {
      Log.i("MicorMsg.MallIndexBaseUIv2", "Oncreate：isTransparent()");
      return;
    }
    fPx();
    setContentViewVisibility(0);
    fZi();
    initView();
    com.tencent.mm.plugin.wallet_core.model.mall.c.ikg();
    fZj();
    if (z.bBi()) {
      Log.e("MicorMsg.MallIndexBaseUIv2", "it is payu account ,not initFingerPrint");
    }
    for (;;)
    {
      ac.pu(1, 0);
      com.tencent.mm.plugin.report.service.h.OAn.b(11850, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
      return;
      paramBundle = (com.tencent.mm.plugin.fingerprint.c.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.fingerprint.c.a.class);
      if (paramBundle != null)
      {
        Log.i("MicorMsg.MallIndexBaseUIv2", "IFingerPrintMgr is not null, do showFingerPrintEntrance()");
        paramBundle.ftp();
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
    Log.i("MicorMsg.MallIndexBaseUIv2", "onResume");
    if (!com.tencent.mm.kernel.h.baz())
    {
      Log.v("MicorMsg.MallIndexBaseUIv2", "MMCore is not ready");
      finish();
    }
    if ((!isTransparent()) && (this.ngJ != null)) {
      this.ngJ.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(262456);
          a.n(MallIndexBaseUIv2.this);
          MallIndexBaseUIv2.this.updateView();
          AppMethodBeat.o(262456);
        }
      });
    }
    if (isTransparent())
    {
      this.KJd = k.fZb().aam(this.KJh);
      if ((this.KJd == null) || (this.KJd.size() <= 0))
      {
        Log.i("MicorMsg.MallIndexBaseUIv2", "mFunctionList == null");
        try
        {
          if ((getIntent().getIntExtra("key_scene", 0) == 1) || (!Util.isNullOrNil(this.Kra)))
          {
            doSceneForceProgress(new com.tencent.mm.plugin.mall.a.f(this.KJh, b.ijV(), 0));
            return;
          }
          localObject3 = getIntent().getStringExtra("key_url");
          Object localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = "";
          }
          doSceneForceProgress(new com.tencent.mm.plugin.mall.a.f(this.KJh, b.ijV(), getIntent().getStringExtra("key_app_id"), this.KJc, (String)localObject1));
          return;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          Log.printErrStackTrace("MicorMsg.MallIndexBaseUIv2", localUnsupportedEncodingException, "", new Object[0]);
          fZo();
          return;
        }
      }
      Object localObject3 = iS(this.KJd);
      Object localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = iT(this.KJd);
      }
      c((MallFunction)localObject2);
      finish();
      return;
    }
    fZl();
    Log.d("MicorMsg.MallIndexBaseUIv2", "initFunctionList");
    if (b.ika().size() == 0)
    {
      Log.e("MicorMsg.MallIndexBaseUIv2", "funcitonlist invalid");
      doSceneProgress(new com.tencent.mm.plugin.mall.a.g(this.KJh), true);
      i = 0;
    }
    while (i != 0)
    {
      Log.i("MicorMsg.MallIndexBaseUIv2", "has data");
      updateView();
      fZB();
      return;
      Log.i("MicorMsg.MallIndexBaseUIv2", "funcitonlist has cache");
      doSceneProgress(new com.tencent.mm.plugin.mall.a.g(this.KJh), false);
      this.KLl = b.ika();
    }
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    Log.d("MicorMsg.MallIndexBaseUIv2", "onSceneEnd :%s", new Object[] { Integer.valueOf(paramp.getType()) });
    if (paramp.getType() == 4362)
    {
      paramString = (com.tencent.mm.plugin.mall.a.g)paramp;
      if (paramString.KJh != this.KJh) {
        Log.i("MicorMsg.MallIndexBaseUIv2", "pass wallet local: %d cgi: %d", new Object[] { Integer.valueOf(this.KJh), Integer.valueOf(paramString.KJh) });
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.KLl = b.ika();
        Log.i("MicorMsg.MallIndexBaseUIv2", "get from server now! " + this.KJh + " " + this.KLl.size());
        com.tencent.mm.plugin.wallet_core.model.mall.c.ikd().bM(this.KLl);
      }
      updateView();
      fZn();
      fZp();
      fZB();
      fZy();
    }
    do
    {
      return true;
      if (paramp.getType() != 495) {
        break;
      }
      paramString = (com.tencent.mm.plugin.mall.a.f)paramp;
      if (paramString.KJh != this.KJh) {
        Log.i("MicorMsg.MallIndexBaseUIv2", "pass wallet local: %d cgi: %d", new Object[] { Integer.valueOf(this.KJh), Integer.valueOf(paramString.KJh) });
      }
    } while (!isTransparent());
    Log.d("MicorMsg.MallIndexBaseUIv2", "errorType:%d | errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramString.KJd != null))
    {
      if (getIntent().getIntExtra("key_scene", 0) == 1)
      {
        paramString = iS(paramString.KJd);
        if (paramString != null) {
          c(paramString);
        }
      }
      for (;;)
      {
        setResult(-1);
        finish();
        return true;
        if (!Util.isNullOrNil(this.Kra))
        {
          Log.d("MicorMsg.MallIndexBaseUIv2", "NativeUrl: %s", new Object[] { this.Kra });
          paramString = iT(paramString.KJd);
          if (paramString != null)
          {
            c(paramString);
          }
          else
          {
            fZo();
            return true;
          }
        }
        else if ((paramString.KJd != null) && (paramString.KJd.size() > 0))
        {
          Log.i("MicorMsg.MallIndexBaseUIv2", "functionScene.mFunctionList != null");
          c(iS(paramString.KJd));
        }
        else if ((k.fZb().aam(this.KJh) != null) && (k.fZb().aam(this.KJh).size() > 0))
        {
          Log.i("MicorMsg.MallIndexBaseUIv2", "SubCoreMall.getCore().getFunctionList() != null");
          c(iS(k.fZb().aam(this.KJh)));
        }
        else
        {
          Log.e("MicorMsg.MallIndexBaseUIv2", "SubCoreMall.getCore().getFunctionList() == null");
        }
      }
    }
    fZo();
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
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.plugin.mall.b.a.class);
  }
  
  public final void updateView()
  {
    showOptionMenu(true);
    if (this.KLk != null) {
      this.KLk.aX(this.KLl);
    }
    fZt();
    fZw();
    fZu();
    fZv();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexBaseUIv2
 * JD-Core Version:    0.7.0.1
 */