package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.w;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ao;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.cdo;
import com.tencent.mm.protocal.protobuf.cdr;
import com.tencent.mm.protocal.protobuf.dvq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class BizTimeLineHotListView
  extends MRecyclerView
{
  public static int ogv;
  private Context mContext;
  private List<b> mHf;
  private int mScreenWidth;
  private float nom;
  private int non;
  g ogn;
  private a ogo;
  boolean ogp;
  private f ogq;
  private i ogr;
  private float ogs;
  private float ogt;
  private float ogu;
  public com.tencent.mm.sdk.b.c<ao> ogw;
  
  public BizTimeLineHotListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(6081);
    this.mHf = new ArrayList();
    this.nom = 0.0F;
    this.mScreenWidth = 0;
    this.non = 0;
    this.ogp = false;
    this.ogs = 0.0F;
    this.ogt = 0.0F;
    this.ogu = 0.0F;
    this.ogw = new com.tencent.mm.sdk.b.c() {};
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(6081);
  }
  
  public BizTimeLineHotListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(6082);
    this.mHf = new ArrayList();
    this.nom = 0.0F;
    this.mScreenWidth = 0;
    this.non = 0;
    this.ogp = false;
    this.ogs = 0.0F;
    this.ogt = 0.0F;
    this.ogu = 0.0F;
    this.ogw = new com.tencent.mm.sdk.b.c() {};
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(6082);
  }
  
  private static void a(d paramd, dvq paramdvq)
  {
    AppMethodBeat.i(209540);
    if ((paramd != null) && (paramdvq != null))
    {
      paramd.title = paramdvq.title;
      paramd.iXe = paramdvq.HIc;
      paramd.appId = paramdvq.duW;
      paramd.hzB = paramdvq.hzB;
      paramd.ohb = paramdvq.HHW;
      paramd.aDD = paramdvq.version;
      paramd.ogZ = paramdvq.HHV;
      paramd.oha = paramdvq.HHZ;
      paramd.ogW = zv(paramdvq.HHV);
    }
    AppMethodBeat.o(209540);
  }
  
  private void bI(List<b> paramList)
  {
    AppMethodBeat.i(6093);
    if (this.mHf == null)
    {
      AppMethodBeat.o(6093);
      return;
    }
    b localb = new b(2);
    localb.FxR = "__BizTimeLine.CustomItem__";
    paramList.add(0, localb);
    co(paramList);
    AppMethodBeat.o(6093);
  }
  
  private void co(List<b> paramList)
  {
    AppMethodBeat.i(175433);
    if (paramList == null)
    {
      AppMethodBeat.o(175433);
      return;
    }
    if (com.tencent.mm.plugin.brandservice.b.c.bNv())
    {
      ad.i("MicroMsg.BizTimeLineHotListView", "alvinluo addCustomItems timeline top bar entry is open");
      d locald = new d();
      dvq localdvq = com.tencent.mm.plugin.brandservice.b.c.bNx();
      if (localdvq != null)
      {
        locald.FxR = "__BizTimeLine.VideoChannelEntry__";
        a(locald, localdvq);
        paramList.add(1, locald);
        locald.position = 1;
        this.ogp = true;
      }
    }
    AppMethodBeat.o(175433);
  }
  
  private void g(RecyclerView.w paramw, int paramInt)
  {
    AppMethodBeat.i(6087);
    ad.d("MicroMsg.BizTimeLineHotListView", "alvinluo updateAlpha pos: %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramw != null)
    {
      float f = paramw.auu.getX();
      if (f >= this.mScreenWidth - getItemWidth() / 2)
      {
        paramw.auu.setAlpha(0.3F);
        AppMethodBeat.o(6087);
        return;
      }
      if ((f < this.mScreenWidth - getItemWidth() / 2) && (f >= this.nom))
      {
        f = 1.0F - (f - this.nom) / this.non * 0.7F;
        ad.d("MicroMsg.BizTimeLineHotListView", "alvinluo updateAlpha %f", new Object[] { Float.valueOf(f) });
        paramw.auu.setAlpha(f);
        AppMethodBeat.o(6087);
        return;
      }
      paramw.auu.setAlpha(1.0F);
    }
    AppMethodBeat.o(6087);
  }
  
  private void init()
  {
    AppMethodBeat.i(175432);
    ad.v("MicroMsg.BizTimeLineHotListView", "alvinluo init");
    ogv = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 16);
    this.ogw.alive();
    AppMethodBeat.o(175432);
  }
  
  private static boolean zv(int paramInt)
  {
    AppMethodBeat.i(209539);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(209539);
      return false;
    }
    int i = ax.aQA("MicroMsg.BizTimeLineHotListView").decodeInt("VideoChannelTopBarVersion", 0);
    ad.i("MicroMsg.BizTimeLineHotListView", "getVideoChannelUnReadState, version: %d, lastVersion: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    if (paramInt > i)
    {
      AppMethodBeat.o(209539);
      return true;
    }
    AppMethodBeat.o(209539);
    return false;
  }
  
  public final void a(Context paramContext, List<b> paramList, f paramf, i parami)
  {
    AppMethodBeat.i(209538);
    this.ogq = paramf;
    this.ogr = parami;
    this.mHf.addAll(paramList);
    bI(this.mHf);
    this.ogo = new a(paramContext);
    paramList = new LinearLayoutManager()
    {
      public final boolean ka()
      {
        return false;
      }
    };
    paramList.setOrientation(0);
    setLayoutManager(paramList);
    setAdapter(this.ogo);
    this.ogn = new g(getCustomItemCount());
    paramList = this.ogn;
    int i = a.getCompletelyCountPerPage();
    paramList.mContext = paramContext;
    paramList.ohh = this;
    paramList.noE = i;
    paramList.ohh.b(paramList);
    paramList.ohh.a(paramList);
    paramList.noH = ((LinearLayoutManager)paramList.ohh.getLayoutManager());
    paramList.atl = new g.1(paramList, paramList.ohh.getContext());
    paramList.noD = new g.2(paramList, paramList.ohh.getContext());
    setOnScrollPageListener(new g.a()
    {
      public final void M(int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(209535);
        if (!paramAnonymousBoolean)
        {
          int i = (int)(System.currentTimeMillis() / 1000L);
          com.tencent.mm.plugin.report.service.g.yhR.f(15721, new Object[] { "", Integer.valueOf(0), Integer.valueOf(10), Integer.valueOf(i), Integer.valueOf(y.getSessionId()) });
        }
        BizTimeLineHotListView.a(BizTimeLineHotListView.this, paramAnonymousInt);
        BizTimeLineHotListView.this.bON();
        AppMethodBeat.o(209535);
      }
      
      public final void zw(int paramAnonymousInt)
      {
        AppMethodBeat.i(209534);
        int i = BizTimeLineHotListView.this.getCurrentPage();
        ad.d("MicroMsg.BizTimeLineHotListView", "alvinluo ScrollPageListener onScrolled offsetOfCurPage: %d, , currentPage: %d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i) });
        BizTimeLineHotListView.a(BizTimeLineHotListView.this, paramAnonymousInt, i);
        BizTimeLineHotListView.f(BizTimeLineHotListView.this);
        AppMethodBeat.o(209534);
      }
    });
    setOnItemClickListener(new MRecyclerView.a()
    {
      public final void T(View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(175429);
        b localb = (b)BizTimeLineHotListView.a(BizTimeLineHotListView.this).get(paramAnonymousInt);
        if (localb == null)
        {
          AppMethodBeat.o(175429);
          return;
        }
        f localf = BizTimeLineHotListView.d(BizTimeLineHotListView.this);
        cdo localcdo;
        if (localb != null)
        {
          if (localb.type != 1) {
            break label226;
          }
          localcdo = new cdo();
          localcdo.FIk = localb.FxR;
          localcdo.udA = (localb.position - 1);
          localcdo.GXC = ((int)(System.currentTimeMillis() / 1000L));
          if (!localb.ogW) {
            break label221;
          }
          paramAnonymousInt = 1;
          localcdo.GXB = paramAnonymousInt;
          localcdo.type = 0;
          localf.ohe.add(localcdo);
        }
        label398:
        for (;;)
        {
          label300:
          if (localb.type == 1)
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("Chat_User", localb.FxR);
            paramAnonymousView.putExtra("finish_direct", true);
            paramAnonymousView.putExtra("KOpenArticleSceneFromScene", 91);
            paramAnonymousView.putExtra("specific_chat_from_scene", 8);
            paramAnonymousView.putExtra("preChatTYPE", 12);
            com.tencent.mm.bs.d.f(BizTimeLineHotListView.e(BizTimeLineHotListView.this), ".ui.chatting.ChattingUI", paramAnonymousView);
            localb.ogW = false;
            BizTimeLineHotListView.this.a(localb);
            AppMethodBeat.o(175429);
            return;
            label221:
            paramAnonymousInt = 0;
            break;
            label226:
            if (localb.type == 3)
            {
              localcdo = new cdo();
              localcdo.udA = (localb.position - 1);
              localcdo.GXC = ((int)(System.currentTimeMillis() / 1000L));
              localcdo.type = 1;
              com.tencent.mm.plugin.brandservice.b.c localc = com.tencent.mm.plugin.brandservice.b.c.nWy;
              localcdo.hzB = com.tencent.mm.plugin.brandservice.b.c.jl(false);
              localc = com.tencent.mm.plugin.brandservice.b.c.nWy;
              if (com.tencent.mm.plugin.brandservice.b.c.bND())
              {
                paramAnonymousInt = 1;
                localcdo.GXE = paramAnonymousInt;
                localc = com.tencent.mm.plugin.brandservice.b.c.nWy;
                localcdo.GXD = com.tencent.mm.plugin.brandservice.b.c.bNE();
                localc = com.tencent.mm.plugin.brandservice.b.c.nWy;
                if (!com.tencent.mm.plugin.brandservice.b.c.bNC()) {
                  break label398;
                }
              }
              for (paramAnonymousInt = 1;; paramAnonymousInt = 0)
              {
                localcdo.GXF = paramAnonymousInt;
                localcdo.GXG = System.currentTimeMillis();
                ad.d("MicroMsg.BizTimeLineOftenReadReport", "onClick is_default_icon %d, is_icon_cache %d", new Object[] { Integer.valueOf(localcdo.GXF), Integer.valueOf(localcdo.GXE) });
                localf.ohe.add(localcdo);
                break;
                paramAnonymousInt = 0;
                break label300;
              }
            }
          }
        }
        if (localb.type == 3)
        {
          ad.i("MicroMsg.BizTimeLineHotListView", "alvinluo onClick jump to video channel");
          if ((localb instanceof d)) {
            BizTimeLineHotListView.a(BizTimeLineHotListView.this, (d)localb, paramAnonymousView);
          }
        }
        AppMethodBeat.o(175429);
      }
    });
    AppMethodBeat.o(209538);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(209537);
    if (paramb == null)
    {
      AppMethodBeat.o(209537);
      return;
    }
    b localb = (b)ci(paramb.position);
    if (localb == null)
    {
      ad.e("MicroMsg.BizTimeLineHotListView", "refreshUnread %s", new Object[] { paramb.FxR });
      AppMethodBeat.o(209537);
      return;
    }
    if (paramb.ogW)
    {
      localb.ogD.setVisibility(0);
      AppMethodBeat.o(209537);
      return;
    }
    localb.ogD.setVisibility(8);
    AppMethodBeat.o(209537);
  }
  
  public final boolean aj(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(6088);
    g localg = this.ogn;
    localg.O(localg.wR(localg.mOffsetX + paramInt1), false);
    boolean bool = super.aj(paramInt1, paramInt2);
    AppMethodBeat.o(6088);
    return bool;
  }
  
  public final boolean bFI()
  {
    return false;
  }
  
  public final void bON()
  {
    AppMethodBeat.i(6085);
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.mHf);
    int m = getCurrentPage();
    int j = g.wU(m);
    int k = g.wV(m);
    int i = j;
    if (m == 0) {
      i = j + 1;
    }
    if ((i <= k) && (i < localArrayList.size()))
    {
      b localb = (b)localArrayList.get(i);
      f localf;
      if (localb != null)
      {
        localf = this.ogq;
        if (localb != null)
        {
          if (localb.type != 1) {
            break label300;
          }
          localcdr = (cdr)localf.ohd.get(localb.FxR);
          if (localcdr != null) {
            break label233;
          }
          localcdr = new cdr();
          localcdr.FIk = localb.FxR;
          if (!localb.ogW) {
            break label228;
          }
          j = 1;
          localcdr.GXB = j;
          localcdr.GXC = ((int)(System.currentTimeMillis() / 1000L));
          localcdr.udA = (localb.position - 1);
          localcdr.owy = 1;
          localcdr.type = 0;
          localf.ohd.put(localb.FxR, localcdr);
        }
      }
      label228:
      label233:
      while (localb.type != 3)
      {
        for (;;)
        {
          i += 1;
          break;
          j = 0;
        }
        if (localb.ogW) {}
        for (j = 1;; j = 0)
        {
          localcdr.GXB = j;
          localcdr.GXC = ((int)(System.currentTimeMillis() / 1000L));
          localcdr.udA = (localb.position - 1);
          localcdr.type = 0;
          localcdr.owy += 1;
          break;
        }
      }
      label300:
      cdr localcdr = new cdr();
      localcdr.GXC = ((int)(System.currentTimeMillis() / 1000L));
      localcdr.udA = (localb.position - 1);
      localcdr.owy = 1;
      localcdr.type = 1;
      com.tencent.mm.plugin.brandservice.b.c localc = com.tencent.mm.plugin.brandservice.b.c.nWy;
      localcdr.hzB = com.tencent.mm.plugin.brandservice.b.c.jl(false);
      localc = com.tencent.mm.plugin.brandservice.b.c.nWy;
      if (com.tencent.mm.plugin.brandservice.b.c.bND())
      {
        j = 1;
        label382:
        localcdr.GXE = j;
        localc = com.tencent.mm.plugin.brandservice.b.c.nWy;
        localcdr.GXD = com.tencent.mm.plugin.brandservice.b.c.bNE();
        localc = com.tencent.mm.plugin.brandservice.b.c.nWy;
        if (!com.tencent.mm.plugin.brandservice.b.c.bNC()) {
          break label468;
        }
      }
      label468:
      for (j = 1;; j = 0)
      {
        localcdr.GXF = j;
        j = f.ohf;
        f.ohf = j + 1;
        localcdr.GXK = j;
        localcdr.GXG = System.currentTimeMillis();
        localf.ohd.put(localb.FxR, localcdr);
        break;
        j = 0;
        break label382;
      }
    }
    AppMethodBeat.o(6085);
  }
  
  public final void ce(List<b> paramList)
  {
    AppMethodBeat.i(6084);
    this.mHf.clear();
    this.mHf.addAll(paramList);
    bI(this.mHf);
    this.ogo.asY.notifyChanged();
    AppMethodBeat.o(6084);
  }
  
  public a getAdapter()
  {
    return this.ogo;
  }
  
  public int getCurrentPage()
  {
    if (this.ogn != null) {
      return this.ogn.nih;
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
    int i = this.mHf.size();
    AppMethodBeat.o(6090);
    return i;
  }
  
  public int getItemPadding()
  {
    AppMethodBeat.i(6089);
    int i = a.dY(getContext());
    AppMethodBeat.o(6089);
    return i;
  }
  
  public int getItemWidth()
  {
    AppMethodBeat.i(6092);
    int i = a.dX(this.mContext);
    AppMethodBeat.o(6092);
    return i;
  }
  
  public int getShowCount()
  {
    if (this.ogp) {
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
  
  public void setOnScrollPageListener(g.a parama)
  {
    if (this.ogn != null) {
      this.ogn.ohj = parama;
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
    
    private void a(BizTimeLineHotListView.b paramb, b paramb1, int paramInt)
    {
      AppMethodBeat.i(6077);
      int j = BizTimeLineHotListView.this.getItemWidth();
      float f = BizTimeLineHotListView.this.getShowCountPerPage();
      int i = j;
      if (j <= 0) {
        i = (int)(BizTimeLineHotListView.this.getWidth() / f);
      }
      j = i;
      if (i <= 0) {
        j = (int)(BizTimeLineHotListView.this.getResources().getDisplayMetrics().widthPixels / f);
      }
      i = j;
      if (paramInt == BizTimeLineHotListView.c(BizTimeLineHotListView.this).getItemCount() - 1)
      {
        double d = j;
        i = (int)((1.0D - (Math.ceil(f) - f)) * d);
        ad.i("MicroMsg.BizTimeLineHotListView", "alvinluo lastPosition %d set width %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      }
      paramb.auu.getLayoutParams().width = i;
      paramb.auu.setScaleX(1.0F);
      paramb.auu.setScaleY(1.0F);
      paramb.titleTv.setText("pos:".concat(String.valueOf(paramInt)));
      ad.d("MicroMsg.BizTimeLineHotListView", "alvinluo onBindCustomViewHolder postion: %d, width: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      Object localObject;
      if ((paramb1 != null) && (paramb1.type == 1))
      {
        a.b.d(paramb.lZa, paramb1.FxR);
        localObject = v.zf(paramb1.FxR);
        paramb.titleTv.setText((CharSequence)localObject);
        if (paramb1.ogW)
        {
          paramb.ogD.setVisibility(0);
          paramb.ogE.setVisibility(8);
        }
      }
      for (;;)
      {
        BizTimeLineHotListView.a(BizTimeLineHotListView.this, paramb, paramb1, paramInt);
        AppMethodBeat.o(6077);
        return;
        paramb.ogD.setVisibility(8);
        break;
        if ((paramb1 != null) && (paramb1.type == 3))
        {
          if ((paramb1 instanceof d))
          {
            localObject = (d)paramb1;
            com.tencent.mm.plugin.brandservice.b.c localc = com.tencent.mm.plugin.brandservice.b.c.nWy;
            if (!com.tencent.mm.plugin.brandservice.b.c.e(paramb.lZa)) {
              paramb.lZa.setImageResource(2131231342);
            }
            BizTimeLineHotListView.a(BizTimeLineHotListView.this, (d)localObject, paramb.titleTv);
          }
          if (paramb1.ogW) {
            paramb.ogD.setVisibility(0);
          }
          for (;;)
          {
            paramb.ogE.setVisibility(0);
            break;
            paramb.ogD.setVisibility(8);
          }
        }
        paramb.ogE.setVisibility(8);
      }
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(6075);
      if (bt.hj(BizTimeLineHotListView.a(BizTimeLineHotListView.this)))
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
      paramInt = super.getItemViewType(paramInt);
      AppMethodBeat.o(6076);
      return paramInt;
    }
  }
  
  public final class b
    extends RecyclerView.w
  {
    public View auu;
    public ImageView lZa;
    public ImageView mYh;
    public FrameLayout ogC;
    public ImageView ogD;
    public ImageView ogE;
    public TextView titleTv;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(6080);
      this.auu = paramView;
      paramView.getLayoutParams().width = (BizTimeLineHotListView.this.getResources().getDisplayMetrics().widthPixels / 4);
      this.lZa = ((ImageView)paramView.findViewById(2131297336));
      this.mYh = ((ImageView)paramView.findViewById(2131297337));
      this.ogC = ((FrameLayout)paramView.findViewById(2131297338));
      this.titleTv = ((TextView)paramView.findViewById(2131297339));
      this.ogD = ((ImageView)paramView.findViewById(2131297340));
      this.ogE = ((ImageView)paramView.findViewById(2131307281));
      AppMethodBeat.o(6080);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotListView
 * JD-Core Version:    0.7.0.1
 */