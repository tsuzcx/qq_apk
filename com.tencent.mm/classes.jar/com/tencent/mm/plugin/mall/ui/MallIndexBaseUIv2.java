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
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.rh;
import com.tencent.mm.model.v;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.appbrand.api.WeAppOpenDeclarePromptBundle;
import com.tencent.mm.plugin.appbrand.service.p;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.plugin.mall.a.k;
import com.tencent.mm.plugin.wallet_core.model.ah;
import com.tencent.mm.plugin.wallet_core.model.l;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.protocal.protobuf.aum;
import com.tencent.mm.protocal.protobuf.ecr;
import com.tencent.mm.protocal.protobuf.ect;
import com.tencent.mm.protocal.protobuf.ecu;
import com.tencent.mm.protocal.protobuf.edf;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.e.m;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public abstract class MallIndexBaseUIv2
  extends WalletBaseUI
  implements u.a, l
{
  protected View sgg;
  protected String uuid;
  private String vHm = null;
  private String vPj = null;
  private ArrayList<MallFunction> vPk = null;
  protected int vPo;
  private TextView vRa = null;
  protected ListView vRb = null;
  protected ImageView vRe;
  protected TextView vRf = null;
  protected TextView vRg;
  private int vRh = 0;
  protected View vRk;
  private boolean vRl = false;
  private c vRq = null;
  private ArrayList<aum> vRr = null;
  
  private void c(MallFunction paramMallFunction)
  {
    if ((paramMallFunction != null) && (!bu.isNullOrNil(paramMallFunction.dPb)) && (((q)com.tencent.mm.kernel.g.ab(q.class)).n(paramMallFunction.dPb, null)))
    {
      ae.i("MallIndexBaseUIv2", "handleFunction, intercept by AppBrandNativeLink, nativeUrl = %s", new Object[] { paramMallFunction.dPb });
      com.tencent.mm.plugin.wallet_core.model.mall.c.eKB().aFW(paramMallFunction.jFZ);
      com.tencent.mm.plugin.wallet_core.model.mall.d.eKF().aFW(paramMallFunction.jFZ);
      if (paramMallFunction.DsT != null)
      {
        com.tencent.mm.plugin.wallet_core.model.mall.c.eKB();
        com.tencent.mm.plugin.wallet_core.model.mall.c.i(paramMallFunction);
      }
      return;
    }
    int i = d.f(paramMallFunction);
    ae.i("MallIndexBaseUIv2", "functionType : ".concat(String.valueOf(i)));
    switch (i)
    {
    default: 
      return;
    case 0: 
      d(paramMallFunction);
      ab.kI(15, 0);
      return;
    case 1: 
      e(paramMallFunction);
      return;
    case 2: 
      dnx();
      return;
    }
    dnw();
  }
  
  private void d(MallFunction paramMallFunction)
  {
    Intent localIntent = new Intent();
    if (isTransparent()) {
      localIntent.putExtra("key_is_hide_progress", true);
    }
    localIntent.putExtra("key_func_info", paramMallFunction);
    com.tencent.mm.br.d.b(this, "recharge", ".ui.PhoneRechargeUI", localIntent);
  }
  
  private void dnl()
  {
    boolean bool = getIntent().getBooleanExtra("key_wallet_has_red", false);
    if (this.vRb.getChildCount() == 0) {}
    for (;;)
    {
      return;
      int i = this.vRb.getFirstVisiblePosition();
      int j = this.vRb.getChildAt(0).getTop();
      ae.i("MallIndexBaseUIv2", "initCheckNew %s fpos %s top %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j) });
      if ((i == 0) && (j == 0) && (bool) && (!this.vRl) && (this.vRr != null))
      {
        this.vRl = true;
        j = this.vRb.getHeaderViewsCount() + this.vRq.getCount();
        ae.i("MallIndexBaseUIv2", "mFunctionsGv.getHeaderViewsCount()： %s mFunctionAdapter.getCount(): %s", new Object[] { Integer.valueOf(this.vRb.getHeaderViewsCount()), Integer.valueOf(this.vRq.getCount()) });
        List localList = this.vRq.vQa;
        if (localList != null)
        {
          i = localList.size() - 1;
          while (i > 0)
          {
            Iterator localIterator = ((ArrayList)localList.get(i)).iterator();
            while (localIterator.hasNext())
            {
              c.c localc = (c.c)localIterator.next();
              if ((localc != null) && (localc.vQL != null) && (c.a(localc.vQL)))
              {
                i = this.vRb.getFirstVisiblePosition();
                int k = this.vRb.getLastVisiblePosition();
                ae.i("MallIndexBaseUIv2", "get listview show top %s bottom %s redPos: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j) });
                if ((j >= i) && (j <= k))
                {
                  ae.i("MallIndexBaseUIv2", "the last redDot item is visible");
                  return;
                }
                int m = com.tencent.mm.cb.a.fromDPToPix(getContext(), 48);
                int n = com.tencent.mm.cb.a.fromDPToPix(getContext(), 8);
                int i1 = ((Integer)com.tencent.mm.plugin.wallet_core.model.mall.b.eKw().get(localc.vQL.GLu)).intValue();
                int i2 = dnv();
                int i3 = a.dna();
                k = al.ck(this).y;
                i = k;
                if (al.jY(this)) {
                  i = k - al.en(this);
                }
                k = i;
                if (getSupportActionBar() != null) {
                  k = i - getSupportActionBar().getHeight();
                }
                i = this.vRb.getScrollY();
                int i4 = a.dna() / 3;
                this.vRb.smoothScrollBy((j + 1) * i3 + i2 + i1 * (m + n) - k - i + i4, 1000);
                ae.i("MallIndexBaseUIv2", "offset function is %s, groupName is %s", new Object[] { localc.vQL.GLn.Name, Integer.valueOf(localc.vQL.GLu) });
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
  
  private void dnm()
  {
    setResult(0);
    finish();
  }
  
  private void dns()
  {
    if (this.vRa != null) {
      this.vRa.setVisibility(8);
    }
  }
  
  private void dnw()
  {
    ae.w("MallIndexBaseUIv2", "doSelectFunction do nothing");
    com.tencent.mm.ui.base.t.makeText(this, "fuction list error", 1).show();
  }
  
  private static void dnx()
  {
    ae.w("MallIndexBaseUIv2", "doSelectFunction no jump");
  }
  
  private void dny()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    int i = this.vRb.getLastVisiblePosition();
    if (i <= this.vRb.getHeaderViewsCount()) {}
    label178:
    do
    {
      return;
      if (i <= this.vRb.getHeaderViewsCount() + this.vRq.getCount())
      {
        i -= this.vRb.getHeaderViewsCount();
        localObject = this.vRq.vQa;
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
              localStringBuilder1.append(Long.toString(localc.vQL.GLn.IhV & 0xFFFFFFFF));
              localStringBuilder1.append(";");
              continue;
              i = this.vRq.getCount();
              break;
            }
          }
        }
        j += 1;
      }
    } while (i - 1 < 0);
    Object localObject = (c.c)((ArrayList)((List)localObject).get(i - 1)).get(0);
    int j = ((Integer)com.tencent.mm.plugin.wallet_core.model.mall.b.eKw().get(((c.c)localObject).vQL.GLu)).intValue();
    localObject = com.tencent.mm.plugin.wallet_core.model.mall.b.eKx();
    i = 0;
    while (i < j)
    {
      localStringBuilder2.append(((ArrayList)localObject).get(i));
      localStringBuilder2.append(";");
      i += 1;
    }
    ae.i("MallIndexBaseUIv2", "exposure report productID：%s、groupId：%s", new Object[] { localStringBuilder1, localStringBuilder2 });
    com.tencent.mm.plugin.report.service.g.yxI.f(20548, new Object[] { localStringBuilder1, localStringBuilder2 });
  }
  
  private void e(MallFunction paramMallFunction)
  {
    com.tencent.mm.kernel.g.ajS();
    this.vPo = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IPF, Integer.valueOf(0))).intValue();
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramMallFunction.uEo);
    localIntent.putExtra("geta8key_username", v.aAC());
    localIntent.putExtra("pay_channel", 1);
    localIntent.putExtra("KPublisherId", "pay_wallet");
    localIntent.putExtra("key_download_restrict", paramMallFunction.DsV);
    localIntent.putExtra("key_wallet_region", this.vPo);
    localIntent.putExtra("key_function_id", paramMallFunction.jFZ);
    localIntent.putExtra(e.m.JpI, true);
    localIntent.putExtra("geta8key_scene", 46);
    com.tencent.mm.wallet_core.ui.f.an(getContext(), localIntent);
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
  
  public final boolean a(aum paramaum, int paramInt)
  {
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qFa, 1) == 1) {}
    for (int i = 1; i == 0; i = 0)
    {
      ae.i("MallIndexBaseUIv2", "handleFunctionByAppBrand clicfg_appbrand_dialog_optimize_switch close");
      return false;
    }
    if ((paramaum.GLp == null) && (paramaum.GLp.type != 2))
    {
      ae.i("MallIndexBaseUIv2", "functionItem.Entrance == null");
      return false;
    }
    if ((paramaum != null) && (paramInt >= 0)) {
      if ((paramaum.GLo == null) || (bu.isNullOrNil(paramaum.GLo.IhO))) {
        break label858;
      }
    }
    label187:
    label840:
    label853:
    label858:
    for (Object localObject1 = Long.toString(paramaum.GLo.IhO & 0xFFFFFFFF);; localObject1 = "")
    {
      int j;
      boolean bool;
      Object localObject2;
      long l;
      int m;
      Object localObject3;
      if (this.vRr == null)
      {
        j = 0;
        bool = c.a(paramaum);
        localObject2 = com.tencent.mm.plugin.wallet_core.model.mall.b.eKz();
        if (((SparseArray)localObject2).size() != 0)
        {
          l = paramaum.GLu;
          localObject2 = (ArrayList)((SparseArray)localObject2).get(paramaum.GLu);
          m = ((ArrayList)localObject2).size();
          i = 0;
          if (i >= ((ArrayList)localObject2).size()) {
            break label853;
          }
          localObject3 = (Integer)((ArrayList)localObject2).get(i);
          if ((localObject3 == null) || (((Integer)localObject3).compareTo(Integer.valueOf(paramaum.GLn.IhV)) != 0)) {
            break label840;
          }
        }
      }
      for (;;)
      {
        ae.i("MallIndexBaseUIv2", "click report activityId:%s,FunctionID：%s", new Object[] { localObject1, Long.toString(paramaum.GLn.IhV & 0xFFFFFFFF) });
        localObject2 = com.tencent.mm.plugin.report.service.g.yxI;
        localObject3 = Long.toString(paramaum.GLn.IhV & 0xFFFFFFFF);
        if (bool) {}
        for (int k = 2;; k = 1)
        {
          ((com.tencent.mm.plugin.report.service.g)localObject2).f(10881, new Object[] { localObject3, Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(paramInt), localObject1, Integer.valueOf(k), Integer.valueOf(2), Long.valueOf(l), Integer.valueOf(m), Integer.valueOf(i) });
          com.tencent.mm.plugin.wallet_core.model.mall.c.eKB().aFW(paramaum.GLn.IhV);
          com.tencent.mm.plugin.wallet_core.model.mall.d.eKF().aFW(paramaum.GLn.IhV);
          if (paramaum.GLo != null)
          {
            localObject1 = new MallFunction();
            ((MallFunction)localObject1).jFZ = paramaum.GLn.IhV;
            ((MallFunction)localObject1).dLB = paramaum.GLn.Name;
            ((MallFunction)localObject1).DsT = new MallNews(((MallFunction)localObject1).jFZ);
            ((MallFunction)localObject1).DsT.ByB = paramaum.GLo.IhO;
            com.tencent.mm.plugin.wallet_core.model.mall.c.eKB();
            com.tencent.mm.plugin.wallet_core.model.mall.c.i((MallFunction)localObject1);
          }
          ae.i("MallIndexBaseUIv2", "handleFunctionNew id：%s，name：%s，type：%s", new Object[] { Integer.valueOf(paramaum.GLn.IhV), paramaum.GLn.Name, Integer.valueOf(paramaum.GLp.type) });
          ae.i("MallIndexBaseUIv2", "handleFunctionNew functionItem.Entrance.URLWeApp.username：%s,functionItem.Entrance.URLWeApp.pagepath:%s,functionItem.Entrance.URLWeApp.version:%s", new Object[] { paramaum.GLp.IhU.username, paramaum.GLp.IhU.ypt, Integer.valueOf(paramaum.GLp.IhU.version) });
          localObject1 = new com.tencent.mm.plugin.appbrand.api.f();
          ((com.tencent.mm.plugin.appbrand.api.f)localObject1).username = paramaum.GLp.IhU.username;
          ((com.tencent.mm.plugin.appbrand.api.f)localObject1).version = paramaum.GLp.IhU.version;
          ((com.tencent.mm.plugin.appbrand.api.f)localObject1).jFL = paramaum.GLp.IhU.ypt;
          ((com.tencent.mm.plugin.appbrand.api.f)localObject1).hSZ = 0;
          ((com.tencent.mm.plugin.appbrand.api.f)localObject1).scene = 1019;
          localObject2 = getString(2131761167);
          localObject3 = getString(2131755792);
          WeAppOpenDeclarePromptBundle localWeAppOpenDeclarePromptBundle = new WeAppOpenDeclarePromptBundle((byte)0);
          localWeAppOpenDeclarePromptBundle.eRn = 2;
          localWeAppOpenDeclarePromptBundle.jGa = ((String)localObject2);
          localWeAppOpenDeclarePromptBundle.jGb = paramaum.GLs;
          localWeAppOpenDeclarePromptBundle.jGc = ((String)localObject3);
          localWeAppOpenDeclarePromptBundle.ov = false;
          localWeAppOpenDeclarePromptBundle.jFZ = paramaum.GLn.IhV;
          ((com.tencent.mm.plugin.appbrand.api.f)localObject1).jFY = localWeAppOpenDeclarePromptBundle;
          ((p)com.tencent.mm.kernel.g.ab(p.class)).a(getContext(), (com.tencent.mm.plugin.appbrand.api.f)localObject1);
          return true;
          j = this.vRr.size();
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
  
  protected abstract void deV();
  
  protected abstract void dng();
  
  protected abstract void dnh();
  
  protected abstract boolean dnj();
  
  protected abstract void dnn();
  
  protected abstract void dno();
  
  protected abstract void dnp();
  
  protected abstract void dnr();
  
  protected abstract void dnt();
  
  protected abstract void dnu();
  
  protected abstract int dnv();
  
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
    ae.d("MallIndexBaseUIv2", "index initView");
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(189877);
        paramAnonymousMenuItem = new Intent();
        paramAnonymousMenuItem.addFlags(67108864);
        paramAnonymousMenuItem.putExtra("preferred_tab", 3);
        com.tencent.mm.br.d.f(MallIndexBaseUIv2.this, "com.tencent.mm.ui.LauncherUI", paramAnonymousMenuItem);
        MallIndexBaseUIv2.this.finish();
        if (!com.tencent.mm.pluginsdk.wallet.e.fjq())
        {
          com.tencent.mm.plugin.report.service.g.yxI.f(14954, new Object[] { com.tencent.mm.pluginsdk.wallet.e.fjr(), "open_wcpay_specific_view:ok" });
          com.tencent.mm.pluginsdk.wallet.e.fjs();
        }
        com.tencent.mm.plugin.report.service.g.yxI.f(14419, new Object[] { MallIndexBaseUIv2.this.uuid, Integer.valueOf(6) });
        ae.i("MallIndexBaseUIv2", "set BackBtn");
        AppMethodBeat.o(189877);
        return true;
      }
    });
    this.vRb = ((ListView)findViewById(2131302018));
    initHeaderView();
    dnn();
    this.vRq = new c(this);
    this.vRb.setAdapter(this.vRq);
    this.vRq.vQG = new c.d()
    {
      public final void a(final int paramAnonymousInt, final aum paramAnonymousaum)
      {
        AppMethodBeat.i(189880);
        if (paramAnonymousaum != null)
        {
          int i;
          if ((!com.tencent.mm.plugin.wallet_core.model.mall.b.a.aFT(paramAnonymousaum.GLn.IhV)) && (!bu.isNullOrNil(paramAnonymousaum.GLs)))
          {
            i = 1;
            if (i == 0) {
              break label276;
            }
            ae.i("MallIndexBaseUIv2", "onFunctionItemClick show disclaimer funcId=%s", new Object[] { paramAnonymousaum.GLn.IhV });
            if (!MallIndexBaseUIv2.this.a(paramAnonymousaum, paramAnonymousInt))
            {
              d.a locala = new d.a(MallIndexBaseUIv2.this.getContext());
              String str1 = MallIndexBaseUIv2.this.getString(2131761167);
              String str2 = MallIndexBaseUIv2.this.getString(2131755792);
              locala.aZh(str1);
              locala.aZi(paramAnonymousaum.GLs);
              locala.aZo(str2).c(new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(189878);
                  ae.i("MallIndexBaseUIv2", "onFunctionItemClick: onClick");
                  com.tencent.mm.plugin.wallet_core.model.mall.b.a.aFS(paramAnonymousaum.GLn.IhV);
                  MallIndexBaseUIv2.a(MallIndexBaseUIv2.this, paramAnonymousaum, paramAnonymousInt);
                  AppMethodBeat.o(189878);
                }
              });
              locala.zf(true);
              locala.e(new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(189879);
                  ae.i("MallIndexBaseUIv2", "onFunctionItemClick: onCancel");
                  com.tencent.mm.plugin.wallet_core.model.mall.b.a.aFS(paramAnonymousaum.GLn.IhV);
                  AppMethodBeat.o(189879);
                }
              });
              locala.fQv().show();
            }
          }
          for (;;)
          {
            ae.d("MallIndexBaseUIv2", "type: %s", new Object[] { Integer.valueOf(paramAnonymousaum.GLu) });
            com.tencent.mm.plugin.report.service.g.yxI.f(14419, new Object[] { MallIndexBaseUIv2.this.uuid, Integer.valueOf(4), Integer.valueOf(paramAnonymousaum.GLu) });
            AppMethodBeat.o(189880);
            return;
            i = 0;
            break;
            label276:
            MallIndexBaseUIv2.a(MallIndexBaseUIv2.this, paramAnonymousaum, paramAnonymousInt);
          }
        }
        ae.w("MallIndexBaseUIv2", "onFunctionItemClick functionItem null; pos=%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(189880);
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
    ae.i("MallIndexBaseUIv2", "onCreate");
    super.onCreate(paramBundle);
    if (!com.tencent.mm.kernel.g.ajM())
    {
      ae.v("MallIndexBaseUIv2", "MMCore is not ready");
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
    addSceneEndListener(4362);
    com.tencent.mm.plugin.wallet_core.model.t.eJm();
    ah.a(this);
    this.vPj = getIntent().getStringExtra("key_func_id");
    ae.i("MallIndexBaseUIv2", "mFuncId:" + this.vPj + " wallet_region: " + this.vPo + " walletType: " + v.aAJ() + " default_region: " + i);
    this.vHm = getIntent().getStringExtra("key_native_url");
    ae.i("MallIndexBaseUIv2", "mNativeUrl:" + this.vHm);
    if (isTransparent())
    {
      ae.i("MallIndexBaseUIv2", "Oncreate：isTransparent()");
      return;
    }
    deV();
    setContentViewVisibility(0);
    dng();
    initView();
    com.tencent.mm.plugin.wallet_core.model.mall.c.eKE();
    dnh();
    if (v.aAR()) {
      ae.e("MallIndexBaseUIv2", "it is payu account ,not initFingerPrint");
    }
    for (;;)
    {
      ab.kI(1, 0);
      com.tencent.mm.plugin.report.service.g.yxI.f(11850, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
      return;
      paramBundle = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
      if (paramBundle != null)
      {
        ae.i("MallIndexBaseUIv2", "IFingerPrintMgr is not null, do showFingerPrintEntrance()");
        paramBundle.cRS();
      }
      else
      {
        ae.e("MallIndexBaseUIv2", "IFingerPrintMgr is not null");
      }
    }
  }
  
  public void onDestroy()
  {
    removeSceneEndListener(495);
    removeSceneEndListener(4362);
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
    h.aad(1);
    ae.i("MallIndexBaseUIv2", "onResume");
    if (!com.tencent.mm.kernel.g.ajM())
    {
      ae.v("MallIndexBaseUIv2", "MMCore is not ready");
      finish();
    }
    if (isTransparent())
    {
      this.vPk = k.dmZ().Kc(this.vPo);
      if ((this.vPk == null) || (this.vPk.size() <= 0))
      {
        ae.i("MallIndexBaseUIv2", "mFunctionList == null");
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
          ae.printErrStackTrace("MallIndexBaseUIv2", localUnsupportedEncodingException, "", new Object[0]);
          dnm();
          return;
        }
      }
      Object localObject3 = ey(this.vPk);
      Object localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = ez(this.vPk);
      }
      c((MallFunction)localObject2);
      finish();
      return;
    }
    dnj();
    ae.d("MallIndexBaseUIv2", "initFunctionList");
    if (com.tencent.mm.plugin.wallet_core.model.mall.b.eKy().size() == 0)
    {
      ae.e("MallIndexBaseUIv2", "funcitonlist invalid");
      doSceneProgress(new com.tencent.mm.plugin.mall.a.g(this.vPo), true);
      i = 0;
    }
    while (i != 0)
    {
      ae.i("MallIndexBaseUIv2", "has data");
      updateView();
      dny();
      return;
      ae.i("MallIndexBaseUIv2", "funcitonlist has cache");
      doSceneProgress(new com.tencent.mm.plugin.mall.a.g(this.vPo), false);
      this.vRr = com.tencent.mm.plugin.wallet_core.model.mall.b.eKy();
    }
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    ae.d("MallIndexBaseUIv2", "onSceneEnd :%s", new Object[] { Integer.valueOf(paramn.getType()) });
    if (paramn.getType() == 4362)
    {
      paramString = (com.tencent.mm.plugin.mall.a.g)paramn;
      if (paramString.vPo != this.vPo) {
        ae.i("MallIndexBaseUIv2", "pass wallet local: %d cgi: %d", new Object[] { Integer.valueOf(this.vPo), Integer.valueOf(paramString.vPo) });
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.vRr = com.tencent.mm.plugin.wallet_core.model.mall.b.eKy();
        ae.i("MallIndexBaseUIv2", "get from server now! " + this.vPo + " " + this.vRr.size());
        com.tencent.mm.plugin.wallet_core.model.mall.c.eKB().aF(this.vRr);
      }
      updateView();
      dnl();
      dnn();
      dny();
    }
    do
    {
      return true;
      if (paramn.getType() != 495) {
        break;
      }
      paramString = (com.tencent.mm.plugin.mall.a.f)paramn;
      if (paramString.vPo != this.vPo) {
        ae.i("MallIndexBaseUIv2", "pass wallet local: %d cgi: %d", new Object[] { Integer.valueOf(this.vPo), Integer.valueOf(paramString.vPo) });
      }
    } while (!isTransparent());
    ae.d("MallIndexBaseUIv2", "errorType:%d | errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramString.vPk != null))
    {
      if (getIntent().getIntExtra("key_scene", 0) == 1)
      {
        paramString = ey(paramString.vPk);
        if (paramString != null) {
          c(paramString);
        }
      }
      for (;;)
      {
        setResult(-1);
        finish();
        return true;
        if (!bu.isNullOrNil(this.vHm))
        {
          ae.d("MallIndexBaseUIv2", "NativeUrl: %s", new Object[] { this.vHm });
          paramString = ez(paramString.vPk);
          if (paramString != null)
          {
            c(paramString);
          }
          else
          {
            dnm();
            return true;
          }
        }
        else if ((paramString.vPk != null) && (paramString.vPk.size() > 0))
        {
          ae.i("MallIndexBaseUIv2", "functionScene.mFunctionList != null");
          c(ey(paramString.vPk));
        }
        else if ((k.dmZ().Kc(this.vPo) != null) && (k.dmZ().Kc(this.vPo).size() > 0))
        {
          ae.i("MallIndexBaseUIv2", "SubCoreMall.getCore().getFunctionList() != null");
          c(ey(k.dmZ().Kc(this.vPo)));
        }
        else
        {
          ae.e("MallIndexBaseUIv2", "SubCoreMall.getCore().getFunctionList() == null");
        }
      }
    }
    dnm();
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
    this.vRq.aj(this.vRr);
    dnr();
    dnu();
    dns();
    dnt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexBaseUIv2
 * JD-Core Version:    0.7.0.1
 */