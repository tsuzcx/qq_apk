package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.h.c.a;
import android.support.v7.h.c.b;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.aq;
import com.tencent.mm.model.aa;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.BizTLRecCardCanvasView;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.tools.z;
import com.tencent.mm.protocal.protobuf.cup;
import com.tencent.mm.protocal.protobuf.cus;
import com.tencent.mm.protocal.protobuf.eqs;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ab;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class BizTimeLineHotListView
  extends MRecyclerView
{
  public static int pze;
  private Context mContext;
  private int mScreenWidth;
  private List<c> nZr;
  private float oDy;
  private int oDz;
  h pyW;
  private a pyX;
  boolean pyY;
  private g pyZ;
  private j pza;
  private float pzb;
  private float pzc;
  private float pzd;
  public IListener<aq> pzf;
  
  public BizTimeLineHotListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(6081);
    this.nZr = new ArrayList();
    this.oDy = 0.0F;
    this.mScreenWidth = 0;
    this.oDz = 0;
    this.pyY = false;
    this.pzb = 0.0F;
    this.pzc = 0.0F;
    this.pzd = 0.0F;
    this.pzf = new IListener() {};
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(6081);
  }
  
  public BizTimeLineHotListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(6082);
    this.nZr = new ArrayList();
    this.oDy = 0.0F;
    this.mScreenWidth = 0;
    this.oDz = 0;
    this.pyY = false;
    this.pzb = 0.0F;
    this.pzc = 0.0F;
    this.pzd = 0.0F;
    this.pzf = new IListener() {};
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(6082);
  }
  
  private static boolean Dj(int paramInt)
  {
    AppMethodBeat.i(194985);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(194985);
      return false;
    }
    int i = MultiProcessMMKV.getSingleMMKV("MicroMsg.BizTimeLineHotListView").decodeInt("VideoChannelTopBarVersion", 0);
    Log.i("MicroMsg.BizTimeLineHotListView", "getVideoChannelUnReadState, version: %d, lastVersion: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    if (paramInt > i)
    {
      AppMethodBeat.o(194985);
      return true;
    }
    AppMethodBeat.o(194985);
    return false;
  }
  
  private static void a(b paramb)
  {
    AppMethodBeat.i(194987);
    paramb.oDp.setVisibility(0);
    paramb.pzj.setVisibility(0);
    if (paramb.pvr != null) {
      paramb.pvr.setVisibility(8);
    }
    AppMethodBeat.o(194987);
  }
  
  private static void a(e parame, eqs parameqs)
  {
    AppMethodBeat.i(194986);
    if ((parame != null) && (parameqs != null))
    {
      parame.title = parameqs.title;
      parame.jXM = parameqs.Noh;
      parame.appId = parameqs.dNI;
      parame.iwv = parameqs.iwv;
      parame.pzQ = parameqs.Nob;
      parame.appVersion = parameqs.version;
      parame.pzO = parameqs.Noa;
      parame.pzP = parameqs.Noe;
      parame.pzL = Dj(parameqs.Noa);
    }
    AppMethodBeat.o(194986);
  }
  
  private void bX(List<c> paramList)
  {
    AppMethodBeat.i(6093);
    if (paramList == null)
    {
      AppMethodBeat.o(6093);
      return;
    }
    c localc = new c(2);
    localc.KJV = "__BizTimeLine.CustomItem__";
    paramList.add(0, localc);
    cE(paramList);
    AppMethodBeat.o(6093);
  }
  
  private void cE(List<c> paramList)
  {
    AppMethodBeat.i(175433);
    if (paramList == null)
    {
      AppMethodBeat.o(175433);
      return;
    }
    if (com.tencent.mm.plugin.brandservice.b.c.clu())
    {
      Log.i("MicroMsg.BizTimeLineHotListView", "alvinluo addCustomItems timeline top bar entry is open");
      e locale = new e();
      eqs localeqs = com.tencent.mm.plugin.brandservice.b.c.clw();
      if (localeqs != null)
      {
        locale.KJV = "__BizTimeLine.VideoChannelEntry__";
        a(locale, localeqs);
        paramList.add(1, locale);
        locale.position = 1;
        this.pyY = true;
      }
    }
    AppMethodBeat.o(175433);
  }
  
  private void g(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(6087);
    Log.d("MicroMsg.BizTimeLineHotListView", "alvinluo updateAlpha pos: %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramv != null)
    {
      float f = paramv.aus.getX();
      if (f >= this.mScreenWidth - getItemWidth() / 2)
      {
        paramv.aus.setAlpha(0.3F);
        AppMethodBeat.o(6087);
        return;
      }
      if ((f < this.mScreenWidth - getItemWidth() / 2) && (f >= this.oDy))
      {
        f = 1.0F - (f - this.oDy) / this.oDz * 0.7F;
        Log.d("MicroMsg.BizTimeLineHotListView", "alvinluo updateAlpha %f", new Object[] { Float.valueOf(f) });
        paramv.aus.setAlpha(f);
        AppMethodBeat.o(6087);
        return;
      }
      paramv.aus.setAlpha(1.0F);
    }
    AppMethodBeat.o(6087);
  }
  
  private void init()
  {
    AppMethodBeat.i(175432);
    Log.v("MicroMsg.BizTimeLineHotListView", "alvinluo init");
    pze = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 16);
    this.pzf.alive();
    setItemAnimator(null);
    AppMethodBeat.o(175432);
  }
  
  public final void a(Context paramContext, List<c> paramList, g paramg, j paramj)
  {
    AppMethodBeat.i(194984);
    this.pyZ = paramg;
    this.pza = paramj;
    this.nZr.addAll(paramList);
    bX(this.nZr);
    this.pyX = new a(paramContext);
    paramList = new LinearLayoutManager()
    {
      public final boolean supportsPredictiveItemAnimations()
      {
        return false;
      }
    };
    paramList.setOrientation(0);
    setLayoutManager(paramList);
    setAdapter(this.pyX);
    this.pyW = new h(getCustomItemCount());
    paramList = this.pyW;
    int i = a.getCompletelyCountPerPage();
    paramList.mContext = paramContext;
    paramList.pzW = this;
    paramList.oDS = i;
    paramList.pzW.b(paramList);
    paramList.pzW.a(paramList);
    paramList.oDV = ((LinearLayoutManager)paramList.pzW.getLayoutManager());
    paramList.mSmoothScroller = new h.1(paramList, paramList.pzW.getContext());
    paramList.oDR = new h.2(paramList, paramList.pzW.getContext());
    setOnScrollPageListener(new h.a()
    {
      public final void Dk(int paramAnonymousInt)
      {
        AppMethodBeat.i(194979);
        int i = BizTimeLineHotListView.this.getCurrentPage();
        Log.d("MicroMsg.BizTimeLineHotListView", "alvinluo ScrollPageListener onScrolled offsetOfCurPage: %d, , currentPage: %d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i) });
        BizTimeLineHotListView.a(BizTimeLineHotListView.this, paramAnonymousInt, i);
        BizTimeLineHotListView.f(BizTimeLineHotListView.this);
        AppMethodBeat.o(194979);
      }
      
      public final void V(int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(194980);
        if (!paramAnonymousBoolean)
        {
          int i = (int)(System.currentTimeMillis() / 1000L);
          com.tencent.mm.plugin.report.service.h.CyF.a(15721, new Object[] { "", Integer.valueOf(0), Integer.valueOf(10), Integer.valueOf(i), Integer.valueOf(ab.getSessionId()) });
        }
        BizTimeLineHotListView.a(BizTimeLineHotListView.this, paramAnonymousInt);
        BizTimeLineHotListView.this.cnm();
        AppMethodBeat.o(194980);
      }
    });
    setOnItemClickListener(new MRecyclerView.a()
    {
      public final void S(View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(175429);
        c localc = (c)BizTimeLineHotListView.a(BizTimeLineHotListView.this).get(paramAnonymousInt);
        if (localc == null)
        {
          AppMethodBeat.o(175429);
          return;
        }
        Object localObject = BizTimeLineHotListView.d(BizTimeLineHotListView.this);
        cup localcup;
        if (localc != null)
        {
          if (localc.type != 1) {
            break label237;
          }
          localcup = new cup();
          localcup.KUC = localc.KJV;
          localcup.xHb = (localc.position - 1);
          localcup.MzR = ((int)(System.currentTimeMillis() / 1000L));
          if (!localc.pzL) {
            break label232;
          }
          paramAnonymousInt = 1;
          localcup.MzQ = paramAnonymousInt;
          localcup.type = 0;
          ((g)localObject).pzT.add(localcup);
        }
        label295:
        label324:
        label354:
        label483:
        for (;;)
        {
          label232:
          label488:
          if (localc.type == 1)
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("Chat_User", localc.KJV);
            paramAnonymousView.putExtra("finish_direct", true);
            paramAnonymousView.putExtra("KOpenArticleSceneFromScene", 91);
            paramAnonymousView.putExtra("specific_chat_from_scene", 8);
            paramAnonymousView.putExtra("preChatTYPE", 12);
            com.tencent.mm.br.c.f(BizTimeLineHotListView.e(BizTimeLineHotListView.this), ".ui.chatting.ChattingUI", paramAnonymousView);
            localc.pzL = false;
            BizTimeLineHotListView.this.a(localc);
            AppMethodBeat.o(175429);
            return;
            paramAnonymousInt = 0;
            break;
            label237:
            if (localc.type == 3)
            {
              localcup = new cup();
              long l = System.currentTimeMillis();
              localcup.xHb = (localc.position - 1);
              localcup.MzR = ((int)(l / 1000L));
              com.tencent.mm.plugin.brandservice.b.c localc1 = com.tencent.mm.plugin.brandservice.b.c.pne;
              if (com.tencent.mm.plugin.brandservice.b.c.clF())
              {
                paramAnonymousInt = 2;
                localcup.type = paramAnonymousInt;
                localcup.iwv = com.tencent.mm.plugin.brandservice.b.c.pne.kj(false);
                if (!com.tencent.mm.plugin.brandservice.b.c.pne.clC()) {
                  break label483;
                }
                paramAnonymousInt = 1;
                localcup.MzT = paramAnonymousInt;
                localc1 = com.tencent.mm.plugin.brandservice.b.c.pne;
                localcup.MzS = com.tencent.mm.plugin.brandservice.b.c.clD();
                if (!com.tencent.mm.plugin.brandservice.b.c.pne.clB()) {
                  break label488;
                }
                paramAnonymousInt = 1;
                localcup.MzU = paramAnonymousInt;
                localcup.MzV = l;
                Log.d("MicroMsg.BizTimeLineOftenReadReport", "onClick is_default_icon %d, is_icon_cache %d", new Object[] { Integer.valueOf(localcup.MzU), Integer.valueOf(localcup.MzT) });
                ((g)localObject).pzT.add(localcup);
                localObject = com.tencent.mm.plugin.brandservice.b.c.pne;
                if (!com.tencent.mm.plugin.brandservice.b.c.clF()) {
                  break label493;
                }
              }
              label493:
              for (paramAnonymousInt = 1;; paramAnonymousInt = 0)
              {
                com.tencent.mm.plugin.report.service.h.CyF.a(21258, new Object[] { Integer.valueOf(2), Long.valueOf(l), Integer.valueOf(0), z.bfG(localcup.iwv), Integer.valueOf(paramAnonymousInt) });
                break;
                paramAnonymousInt = 1;
                break label295;
                paramAnonymousInt = 0;
                break label324;
                paramAnonymousInt = 0;
                break label354;
              }
            }
          }
        }
        if (localc.type == 3)
        {
          Log.i("MicroMsg.BizTimeLineHotListView", "alvinluo onClick jump to video channel");
          if ((localc instanceof e)) {
            BizTimeLineHotListView.a(BizTimeLineHotListView.this, (e)localc, paramAnonymousView);
          }
        }
        AppMethodBeat.o(175429);
      }
    });
    AppMethodBeat.o(194984);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(194983);
    if (paramc == null)
    {
      AppMethodBeat.o(194983);
      return;
    }
    b localb = (b)ch(paramc.position);
    if (localb == null)
    {
      Log.e("MicroMsg.BizTimeLineHotListView", "refreshUnread %s", new Object[] { paramc.KJV });
      AppMethodBeat.o(194983);
      return;
    }
    if (paramc.pzL)
    {
      localb.pzk.setVisibility(0);
      AppMethodBeat.o(194983);
      return;
    }
    localb.pzk.setVisibility(8);
    AppMethodBeat.o(194983);
  }
  
  public final boolean ak(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(6088);
    h localh = this.pyW;
    localh.W(localh.AE(localh.mOffsetX + paramInt1), false);
    boolean bool = super.ak(paramInt1, paramInt2);
    AppMethodBeat.o(6088);
    return bool;
  }
  
  public final void c(List<c> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(194982);
    paramList = new ArrayList(paramList);
    bX(paramList);
    Log.i("MicroMsg.BizTimeLineHotListView", "alvinluo refreshData new list: %d, old list: %d, configurationChanged: %b", new Object[] { Integer.valueOf(paramList.size()), Integer.valueOf(this.nZr.size()), Boolean.valueOf(paramBoolean) });
    Object localObject = new b(this.nZr, paramList);
    if (paramBoolean) {
      ((b)localObject).pzK = true;
    }
    localObject = android.support.v7.h.c.a((c.a)localObject, true);
    this.nZr.clear();
    this.nZr.addAll(paramList);
    ((c.b)localObject).a(this.pyX);
    AppMethodBeat.o(194982);
  }
  
  public final boolean cdc()
  {
    return false;
  }
  
  public final void cnm()
  {
    AppMethodBeat.i(6085);
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.nZr);
    int m = getCurrentPage();
    int j = h.AH(m);
    int k = h.Dl(m);
    int i = j;
    if (m == 0) {
      i = j + 1;
    }
    if ((i <= k) && (i < localArrayList.size()))
    {
      Object localObject = (c)localArrayList.get(i);
      g localg;
      if (localObject != null)
      {
        localg = this.pyZ;
        if (localObject != null)
        {
          if (((c)localObject).type != 1) {
            break label300;
          }
          localcus = (cus)localg.pzS.get(((c)localObject).KJV);
          if (localcus != null) {
            break label233;
          }
          localcus = new cus();
          localcus.KUC = ((c)localObject).KJV;
          if (!((c)localObject).pzL) {
            break label228;
          }
          j = 1;
          localcus.MzQ = j;
          localcus.MzR = ((int)(System.currentTimeMillis() / 1000L));
          localcus.xHb = (((c)localObject).position - 1);
          localcus.pQJ = 1;
          localcus.type = 0;
          localg.pzS.put(((c)localObject).KJV, localcus);
        }
      }
      label228:
      label233:
      while (((c)localObject).type != 3)
      {
        for (;;)
        {
          i += 1;
          break;
          j = 0;
        }
        if (((c)localObject).pzL) {}
        for (j = 1;; j = 0)
        {
          localcus.MzQ = j;
          localcus.MzR = ((int)(System.currentTimeMillis() / 1000L));
          localcus.xHb = (((c)localObject).position - 1);
          localcus.type = 0;
          localcus.pQJ += 1;
          break;
        }
      }
      label300:
      cus localcus = new cus();
      long l = System.currentTimeMillis();
      localcus.MzR = ((int)(l / 1000L));
      localcus.xHb = (((c)localObject).position - 1);
      localcus.pQJ = 1;
      com.tencent.mm.plugin.brandservice.b.c localc = com.tencent.mm.plugin.brandservice.b.c.pne;
      if (com.tencent.mm.plugin.brandservice.b.c.clF())
      {
        j = 2;
        label366:
        localcus.type = j;
        localcus.iwv = com.tencent.mm.plugin.brandservice.b.c.pne.kj(false);
        if (!com.tencent.mm.plugin.brandservice.b.c.pne.clC()) {
          break label544;
        }
        j = 1;
        label395:
        localcus.MzT = j;
        localc = com.tencent.mm.plugin.brandservice.b.c.pne;
        localcus.MzS = com.tencent.mm.plugin.brandservice.b.c.clD();
        if (!com.tencent.mm.plugin.brandservice.b.c.pne.clB()) {
          break label549;
        }
        j = 1;
        label425:
        localcus.MzU = j;
        j = g.pzU;
        g.pzU = j + 1;
        localcus.MzZ = j;
        localcus.MzV = l;
        localg.pzS.put(((c)localObject).KJV, localcus);
        localObject = com.tencent.mm.plugin.brandservice.b.c.pne;
        if (!com.tencent.mm.plugin.brandservice.b.c.clF()) {
          break label554;
        }
      }
      label544:
      label549:
      label554:
      for (j = 1;; j = 0)
      {
        com.tencent.mm.plugin.report.service.h.CyF.a(21258, new Object[] { Integer.valueOf(1), Long.valueOf(l), Integer.valueOf(0), z.bfG(localcus.iwv), Integer.valueOf(j) });
        break;
        j = 1;
        break label366;
        j = 0;
        break label395;
        j = 0;
        break label425;
      }
    }
    AppMethodBeat.o(6085);
  }
  
  public a getAdapter()
  {
    return this.pyX;
  }
  
  public int getCurrentPage()
  {
    if (this.pyW != null) {
      return this.pyW.owW;
    }
    return 0;
  }
  
  public int getCustomItemCount()
  {
    return 1;
  }
  
  public int getDataCount()
  {
    AppMethodBeat.i(6090);
    int i = this.nZr.size();
    AppMethodBeat.o(6090);
    return i;
  }
  
  public int getItemPadding()
  {
    AppMethodBeat.i(6089);
    int i = a.ew(getContext());
    AppMethodBeat.o(6089);
    return i;
  }
  
  public int getItemWidth()
  {
    AppMethodBeat.i(6092);
    int i = a.ev(this.mContext);
    AppMethodBeat.o(6092);
    return i;
  }
  
  public int getShowCount()
  {
    if (this.pyY) {
      return 13;
    }
    return 12;
  }
  
  protected float getShowCountPerPage()
  {
    AppMethodBeat.i(6091);
    float f = a.getShowCountPerPage();
    AppMethodBeat.o(6091);
    return f;
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(6083);
    super.onDetachedFromWindow();
    AppMethodBeat.o(6083);
  }
  
  public void setOnScrollPageListener(h.a parama)
  {
    if (this.pyW != null) {
      this.pyW.pzY = parama;
    }
  }
  
  public final class a
    extends RecyclerView.a<BizTimeLineHotListView.b>
  {
    private Context mContext;
    
    public a(Context paramContext)
    {
      this.mContext = paramContext;
    }
    
    private void a(BizTimeLineHotListView.b paramb, c paramc, int paramInt)
    {
      AppMethodBeat.i(6077);
      int j = BizTimeLineHotListView.this.getItemWidth();
      float f = BizTimeLineHotListView.this.getShowCountPerPage();
      int i = j;
      if (paramInt == BizTimeLineHotListView.c(BizTimeLineHotListView.this).getItemCount() - 1)
      {
        double d = j;
        i = (int)((1.0D - (Math.ceil(f) - f)) * d);
        Log.i("MicroMsg.BizTimeLineHotListView", "alvinluo lastPosition %d set width %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      }
      j = i;
      if (paramc != null)
      {
        j = i;
        if (paramc.type == 3) {
          j = a.eN(this.mContext);
        }
      }
      paramb.aus.getLayoutParams().width = j;
      paramb.aus.setScaleX(1.0F);
      paramb.aus.setScaleY(1.0F);
      Log.d("MicroMsg.BizTimeLineHotListView", "alvinluo onBindCustomViewHolder postion: %d, width: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(j) });
      Object localObject;
      boolean bool;
      if ((paramc != null) && (paramc.type == 1))
      {
        BizTimeLineHotListView.b(paramb);
        a.b.d(paramb.nnL, paramc.KJV);
        localObject = aa.getDisplayName(paramc.KJV);
        paramb.titleTv.setText((CharSequence)localObject);
        paramb.titleTv.setTextSize(0, com.tencent.mm.cb.a.aH(this.mContext, 2131165594) * com.tencent.mm.cb.a.ji(BizTimeLineHotListView.this.getContext()));
        paramb.titleTv.setTextColor(this.mContext.getResources().getColor(2131100584));
        if (paramc.pzL)
        {
          paramb.pzk.setVisibility(0);
          paramb.pzl.setVisibility(8);
          paramb.pzp.setVisibility(8);
          paramb.pzo.setVisibility(8);
          paramb.pzn.setVisibility(8);
          bool = true;
        }
      }
      for (;;)
      {
        BizTimeLineHotListView.a(BizTimeLineHotListView.this, paramb, paramc, paramInt, bool);
        AppMethodBeat.o(6077);
        return;
        paramb.pzk.setVisibility(8);
        break;
        if ((paramc != null) && (paramc.type == 3) && ((paramc instanceof e)))
        {
          localObject = com.tencent.mm.plugin.brandservice.b.c.pne;
          if (com.tencent.mm.plugin.brandservice.b.c.clF())
          {
            paramb.oDp.setVisibility(8);
            paramb.pzj.setVisibility(8);
            if (paramb.pzm == null)
            {
              paramb.pzm = ((ViewStub)paramb.aus.findViewById(2131309900)).inflate();
              paramb.pvr = ((BizTLRecCardCanvasView)paramb.pzm.findViewById(2131309731));
            }
            localObject = paramb.pvr;
            ((BizTLRecCardCanvasView)localObject).setVisibility(0);
            com.tencent.mm.plugin.brandservice.b.c localc = com.tencent.mm.plugin.brandservice.b.c.pne;
            ((BizTLRecCardCanvasView)localObject).a(0L, "__biz_video_channel_canvas_id__", "vc", "");
            bool = false;
          }
          else
          {
            localObject = (e)paramc;
            BizTimeLineHotListView.a(BizTimeLineHotListView.this, paramb, (e)localObject);
          }
        }
        else
        {
          bool = true;
        }
      }
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(6075);
      if (Util.isNullOrNil(BizTimeLineHotListView.a(BizTimeLineHotListView.this)))
      {
        AppMethodBeat.o(6075);
        return 0;
      }
      int j = BizTimeLineHotListView.a(BizTimeLineHotListView.this).size();
      int k = a.getCompletelyCountPerPage();
      int i = j;
      if (BizTimeLineHotListView.this.getCustomItemCount() == 1) {
        i = j - 1;
      }
      j = i;
      if (i > BizTimeLineHotListView.this.getShowCount()) {
        j = BizTimeLineHotListView.this.getShowCount();
      }
      if (BizTimeLineHotListView.this.getCustomItemCount() == 1)
      {
        if (j % k == 0) {}
        for (i = j + 1;; i = j + (k + 1 - j % k))
        {
          j = BizTimeLineHotListView.this.getCustomItemCount();
          AppMethodBeat.o(6075);
          return i + j;
        }
      }
      i = j;
      if (j % k != 0) {
        i = j + (k - j % k);
      }
      AppMethodBeat.o(6075);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(6076);
      if ((paramInt < BizTimeLineHotListView.a(BizTimeLineHotListView.this).size()) && (paramInt - BizTimeLineHotListView.this.getCustomItemCount() <= BizTimeLineHotListView.this.getShowCount()))
      {
        c localc = (c)BizTimeLineHotListView.a(BizTimeLineHotListView.this).get(paramInt);
        if ((localc != null) && (localc.type == 3) && ((localc instanceof e)))
        {
          AppMethodBeat.o(6076);
          return 1;
        }
      }
      AppMethodBeat.o(6076);
      return 0;
    }
  }
  
  public final class b
    extends RecyclerView.v
  {
    public View aus;
    public ImageView nnL;
    public RelativeLayout oDp;
    public ImageView ooB;
    public BizTLRecCardCanvasView pvr;
    public View pzj;
    public ImageView pzk;
    public ImageView pzl;
    public View pzm;
    public TextView pzn;
    public ImageView pzo;
    public ImageView pzp;
    public TextView titleTv;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(6080);
      this.pzm = null;
      this.pzn = null;
      this.pzo = null;
      this.pzp = null;
      this.aus = paramView;
      paramView.getLayoutParams().width = (BizTimeLineHotListView.this.getResources().getDisplayMetrics().widthPixels / 4);
      this.nnL = ((ImageView)paramView.findViewById(2131297542));
      this.ooB = ((ImageView)paramView.findViewById(2131297543));
      this.oDp = ((RelativeLayout)paramView.findViewById(2131297544));
      this.pzj = paramView.findViewById(2131297549);
      this.titleTv = ((TextView)paramView.findViewById(2131297548));
      this.pzk = ((ImageView)paramView.findViewById(2131297550));
      this.pzl = ((ImageView)paramView.findViewById(2131297545));
      this.pzn = ((TextView)paramView.findViewById(2131297541));
      this.pzo = ((ImageView)paramView.findViewById(2131297546));
      this.pzp = ((ImageView)paramView.findViewById(2131297547));
      AppMethodBeat.o(6080);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotListView
 * JD-Core Version:    0.7.0.1
 */