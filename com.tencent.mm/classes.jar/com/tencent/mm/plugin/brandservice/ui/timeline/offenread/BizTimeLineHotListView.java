package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.v;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.an;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.bug;
import com.tencent.mm.protocal.protobuf.buj;
import com.tencent.mm.protocal.protobuf.dkj;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.u;
import d.g.b.k;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BizTimeLineHotListView
  extends MRecyclerView
{
  private List<b> lEL;
  private Context mContext;
  private int mScreenWidth;
  private float mlO;
  private int mlP;
  private g nbt;
  private a nbu;
  private boolean nbv;
  private f nbw;
  public c<an> nbx;
  
  public BizTimeLineHotListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(6081);
    this.lEL = new ArrayList();
    this.mlO = 0.0F;
    this.mScreenWidth = 0;
    this.mlP = 0;
    this.nbv = false;
    this.nbx = new c() {};
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(6081);
  }
  
  public BizTimeLineHotListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(6082);
    this.lEL = new ArrayList();
    this.mlO = 0.0F;
    this.mScreenWidth = 0;
    this.mlP = 0;
    this.nbv = false;
    this.nbx = new c() {};
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(6082);
  }
  
  private void bH(List<b> paramList)
  {
    AppMethodBeat.i(6093);
    if (this.lEL == null)
    {
      AppMethodBeat.o(6093);
      return;
    }
    b localb = new b(2);
    localb.CAc = "__BizTimeLine.CustomItem__";
    paramList.add(0, localb);
    cm(paramList);
    AppMethodBeat.o(6093);
  }
  
  private void cm(List<b> paramList)
  {
    AppMethodBeat.i(175433);
    if (paramList == null)
    {
      AppMethodBeat.o(175433);
      return;
    }
    if (com.tencent.mm.plugin.brandservice.b.d.bCf())
    {
      ad.i("MicroMsg.BizTimeLineHotListView", "alvinluo addCustomItems timeline top bar entry is open");
      d locald = new d();
      dkj localdkj = com.tencent.mm.plugin.brandservice.b.d.bCh();
      if (localdkj != null)
      {
        locald.CAc = "__BizTimeLine.VideoChannelEntry__";
        locald.title = localdkj.title;
        locald.appId = localdkj.dlB;
        locald.gGR = localdkj.gGR;
        locald.aAS = localdkj.version;
        locald.dcu = localdkj.EAa;
        locald.nbP = xU(localdkj.EAa);
        paramList.add(1, locald);
        locald.position = 1;
        this.nbv = true;
      }
    }
    AppMethodBeat.o(175433);
  }
  
  private void g(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(6087);
    ad.d("MicroMsg.BizTimeLineHotListView", "alvinluo updateAlpha pos: %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramv != null)
    {
      float f = paramv.arI.getX();
      if (f >= this.mScreenWidth - getItemWidth() / 2)
      {
        paramv.arI.setAlpha(0.3F);
        AppMethodBeat.o(6087);
        return;
      }
      if ((f < this.mScreenWidth - getItemWidth() / 2) && (f >= this.mlO))
      {
        f = 1.0F - (f - this.mlO) / this.mlP * 0.7F;
        ad.d("MicroMsg.BizTimeLineHotListView", "alvinluo updateAlpha %f", new Object[] { Float.valueOf(f) });
        paramv.arI.setAlpha(f);
        AppMethodBeat.o(6087);
        return;
      }
      paramv.arI.setAlpha(1.0F);
    }
    AppMethodBeat.o(6087);
  }
  
  private int getItemPadding()
  {
    AppMethodBeat.i(6089);
    int i = a.dQ(getContext());
    AppMethodBeat.o(6089);
    return i;
  }
  
  private void init()
  {
    AppMethodBeat.i(175432);
    ad.v("MicroMsg.BizTimeLineHotListView", "alvinluo init");
    this.nbx.alive();
    AppMethodBeat.o(175432);
  }
  
  private static boolean xU(int paramInt)
  {
    AppMethodBeat.i(192998);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(192998);
      return false;
    }
    int i = ax.aFD("MicroMsg.BizTimeLineHotListView").decodeInt("VideoChannelTopBarVersion", 0);
    ad.i("MicroMsg.BizTimeLineHotListView", "getVideoChannelUnReadState, version: %d, lastVersion: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    if (paramInt > i)
    {
      AppMethodBeat.o(192998);
      return true;
    }
    AppMethodBeat.o(192998);
    return false;
  }
  
  public final void a(Context paramContext, List<b> paramList, f paramf)
  {
    AppMethodBeat.i(6086);
    this.nbw = paramf;
    this.lEL.addAll(paramList);
    bH(this.lEL);
    this.nbu = new a(paramContext);
    paramList = new LinearLayoutManager()
    {
      public final boolean jC()
      {
        return false;
      }
    };
    paramList.setOrientation(0);
    setLayoutManager(paramList);
    setAdapter(this.nbu);
    this.nbt = new g(getCustomItemCount());
    paramList = this.nbt;
    int i = a.getCompletelyCountPerPage();
    paramList.mContext = paramContext;
    paramList.nbU = this;
    paramList.mmg = i;
    paramList.nbU.b(paramList);
    paramList.nbU.a(paramList);
    paramList.mmj = ((LinearLayoutManager)paramList.nbU.getLayoutManager());
    paramList.aqy = new g.1(paramList, paramList.nbU.getContext());
    paramList.mmf = new g.2(paramList, paramList.nbU.getContext());
    setOnScrollPageListener(new g.a()
    {
      public final void iz(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(175431);
        if (!paramAnonymousBoolean)
        {
          int i = (int)(System.currentTimeMillis() / 1000L);
          h.vKh.f(15721, new Object[] { "", Integer.valueOf(0), Integer.valueOf(10), Integer.valueOf(i), Integer.valueOf(u.getSessionId()) });
        }
        BizTimeLineHotListView.this.bDc();
        AppMethodBeat.o(175431);
      }
      
      public final void xV(int paramAnonymousInt)
      {
        AppMethodBeat.i(175430);
        ad.d("MicroMsg.BizTimeLineHotListView", "alvinluo ScrollPageListener onScrolled offsetOfCurPage: %d, , currentPage: %d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(BizTimeLineHotListView.this.getCurrentPage()) });
        BizTimeLineHotListView.f(BizTimeLineHotListView.this);
        AppMethodBeat.o(175430);
      }
    });
    setOnItemClickListener(new MRecyclerView.a()
    {
      public final void S(View paramAnonymousView, int paramAnonymousInt)
      {
        int i = 0;
        AppMethodBeat.i(175429);
        paramAnonymousView = (b)BizTimeLineHotListView.a(BizTimeLineHotListView.this).get(paramAnonymousInt);
        if (paramAnonymousView == null)
        {
          AppMethodBeat.o(175429);
          return;
        }
        Object localObject1 = BizTimeLineHotListView.d(BizTimeLineHotListView.this);
        Object localObject2;
        if (paramAnonymousView != null)
        {
          localObject2 = ((f)localObject1).nbS.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            bug localbug = (bug)((Iterator)localObject2).next();
            if (bt.kU(localbug.CJL, paramAnonymousView.CAc))
            {
              localbug.DRB = ((int)(System.currentTimeMillis() / 1000L));
              paramAnonymousInt = i;
              if (paramAnonymousView.nbP) {
                paramAnonymousInt = 1;
              }
              localbug.DRA = paramAnonymousInt;
            }
          }
        }
        while (paramAnonymousView.type == 1)
        {
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("Chat_User", paramAnonymousView.CAc);
          ((Intent)localObject1).putExtra("finish_direct", true);
          ((Intent)localObject1).putExtra("KOpenArticleSceneFromScene", 91);
          ((Intent)localObject1).putExtra("specific_chat_from_scene", 8);
          ((Intent)localObject1).putExtra("preChatTYPE", 12);
          com.tencent.mm.bs.d.e(BizTimeLineHotListView.e(BizTimeLineHotListView.this), ".ui.chatting.ChattingUI", (Intent)localObject1);
          AppMethodBeat.o(175429);
          return;
          if (paramAnonymousView.type == 1)
          {
            localObject2 = new bug();
            ((bug)localObject2).CJL = paramAnonymousView.CAc;
            ((bug)localObject2).rXS = (paramAnonymousView.position - 1);
            ((bug)localObject2).DRB = ((int)(System.currentTimeMillis() / 1000L));
            if (paramAnonymousView.nbP) {}
            for (paramAnonymousInt = 1;; paramAnonymousInt = 0)
            {
              ((bug)localObject2).DRA = paramAnonymousInt;
              ((bug)localObject2).type = 0;
              ((f)localObject1).nbS.add(localObject2);
              break;
            }
          }
          if (paramAnonymousView.type == 3)
          {
            localObject2 = new bug();
            ((bug)localObject2).rXS = (paramAnonymousView.position - 1);
            ((bug)localObject2).DRB = ((int)(System.currentTimeMillis() / 1000L));
            ((bug)localObject2).type = 1;
            ((f)localObject1).nbS.add(localObject2);
          }
        }
        if (paramAnonymousView.type == 3)
        {
          ad.i("MicroMsg.BizTimeLineHotListView", "alvinluo onClick jump to video channel");
          if ((paramAnonymousView instanceof d)) {
            BizTimeLineHotListView.a(BizTimeLineHotListView.this, (d)paramAnonymousView);
          }
        }
        AppMethodBeat.o(175429);
      }
    });
    AppMethodBeat.o(6086);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(192997);
    if (paramb == null)
    {
      AppMethodBeat.o(192997);
      return;
    }
    b localb = (b)cj(paramb.position);
    if (localb == null)
    {
      AppMethodBeat.o(192997);
      return;
    }
    if (paramb.nbP)
    {
      localb.nbz.setVisibility(0);
      AppMethodBeat.o(192997);
      return;
    }
    localb.nbz.setVisibility(8);
    AppMethodBeat.o(192997);
  }
  
  public final boolean ai(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(6088);
    g localg = this.nbt;
    localg.O(localg.vv(localg.mOffsetX + paramInt1), false);
    boolean bool = super.ai(paramInt1, paramInt2);
    AppMethodBeat.o(6088);
    return bool;
  }
  
  public final void bDc()
  {
    AppMethodBeat.i(6085);
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.lEL);
    int m = getCurrentPage();
    int j = g.vy(m);
    int k = g.vz(m);
    int i = j;
    if (m == 0) {
      i = j + 1;
    }
    if ((i <= k) && (i < localArrayList.size()))
    {
      b localb = (b)localArrayList.get(i);
      f localf;
      buj localbuj;
      if (localb != null)
      {
        localf = this.nbw;
        if (localb != null)
        {
          if (localb.type != 1) {
            break label300;
          }
          localbuj = (buj)localf.nbR.get(localb.CAc);
          if (localbuj != null) {
            break label233;
          }
          localbuj = new buj();
          localbuj.CJL = localb.CAc;
          if (!localb.nbP) {
            break label228;
          }
          j = 1;
          label162:
          localbuj.DRA = j;
          localbuj.DRB = ((int)(System.currentTimeMillis() / 1000L));
          localbuj.rXS = (localb.position - 1);
          localbuj.nqd = 1;
          localbuj.type = 0;
          localf.nbR.put(localb.CAc, localbuj);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label228:
        j = 0;
        break label162;
        label233:
        if (localb.nbP) {}
        for (j = 1;; j = 0)
        {
          localbuj.DRA = j;
          localbuj.DRB = ((int)(System.currentTimeMillis() / 1000L));
          localbuj.rXS = (localb.position - 1);
          localbuj.type = 0;
          localbuj.nqd += 1;
          break;
        }
        label300:
        if (localb.type == 3)
        {
          localbuj = (buj)localf.nbR.get(localb.CAc);
          if (localbuj == null)
          {
            localbuj = new buj();
            localbuj.DRB = ((int)(System.currentTimeMillis() / 1000L));
            localbuj.rXS = (localb.position - 1);
            localbuj.nqd = 1;
            localbuj.type = 1;
            localf.nbR.put(localb.CAc, localbuj);
          }
          else
          {
            localbuj.DRB = ((int)(System.currentTimeMillis() / 1000L));
            localbuj.rXS = (localb.position - 1);
            localbuj.nqd += 1;
            localbuj.type = 1;
          }
        }
      }
    }
    AppMethodBeat.o(6085);
  }
  
  public final boolean buJ()
  {
    return false;
  }
  
  public final void cc(List<b> paramList)
  {
    AppMethodBeat.i(6084);
    this.lEL.clear();
    this.lEL.addAll(paramList);
    bH(this.lEL);
    this.nbu.aql.notifyChanged();
    AppMethodBeat.o(6084);
  }
  
  public a getAdapter()
  {
    return this.nbu;
  }
  
  public int getCurrentPage()
  {
    if (this.nbt != null) {
      return this.nbt.mfK;
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
    int i = this.lEL.size();
    AppMethodBeat.o(6090);
    return i;
  }
  
  public int getItemWidth()
  {
    AppMethodBeat.i(6092);
    int i = a.dP(this.mContext);
    AppMethodBeat.o(6092);
    return i;
  }
  
  public int getShowCount()
  {
    if (this.nbv) {
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
    if (this.nbt != null) {
      this.nbt.nbW = parama;
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
      paramb.arI.getLayoutParams().width = i;
      paramb.arI.setScaleX(1.0F);
      paramb.arI.setScaleY(1.0F);
      paramb.titleTv.setText("pos:".concat(String.valueOf(paramInt)));
      ad.d("MicroMsg.BizTimeLineHotListView", "alvinluo onBindCustomViewHolder postion: %d, width: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      Object localObject1;
      if ((paramb1 != null) && (paramb1.type == 1))
      {
        a.b.d(paramb.kXS, paramb1.CAc);
        localObject1 = v.sh(paramb1.CAc);
        paramb.titleTv.setText((CharSequence)localObject1);
        if (paramb1.nbP) {
          paramb.nbz.setVisibility(0);
        }
      }
      for (;;)
      {
        BizTimeLineHotListView.a(BizTimeLineHotListView.this, paramb, paramb1, paramInt);
        AppMethodBeat.o(6077);
        return;
        paramb.nbz.setVisibility(8);
        continue;
        if ((paramb1 != null) && (paramb1.type == 3))
        {
          if ((paramb1 instanceof d))
          {
            localObject1 = (d)paramb1;
            if (bt.isNullOrNil(((d)localObject1).gGR)) {
              break label555;
            }
            com.tencent.mm.modelappbrand.a.b localb = com.tencent.mm.modelappbrand.a.b.aub();
            ImageView localImageView = paramb.kXS;
            String str = ((d)localObject1).gGR;
            Object localObject2 = com.tencent.mm.plugin.brandservice.b.a.mSy;
            if (((com.tencent.mm.plugin.brandservice.b.a)localObject2).gRP != null)
            {
              localObject3 = ((com.tencent.mm.plugin.brandservice.b.a)localObject2).gRP;
              if (localObject3 == null) {
                k.fvU();
              }
              if (((WeakReference)localObject3).get() != null)
              {
                localObject3 = ((com.tencent.mm.plugin.brandservice.b.a)localObject2).gRP;
                if (localObject3 == null) {
                  k.fvU();
                }
                localObject3 = (Bitmap)((WeakReference)localObject3).get();
                if ((localObject3 == null) || (((Bitmap)localObject3).isRecycled() != true)) {
                  break label449;
                }
              }
            }
            ((com.tencent.mm.plugin.brandservice.b.a)localObject2).gRP = new WeakReference(com.tencent.mm.compatible.e.a.decodeResource(aj.getResources(), 2131231875));
            label449:
            Object localObject3 = aj.getResources();
            localObject2 = ((com.tencent.mm.plugin.brandservice.b.a)localObject2).gRP;
            if (localObject2 == null) {
              k.fvU();
            }
            localObject2 = android.support.v4.graphics.drawable.d.a((Resources)localObject3, (Bitmap)((WeakReference)localObject2).get());
            k.g(localObject2, "RoundedBitmapDrawableFac…(), sDefaultIcon!!.get())");
            ((android.support.v4.graphics.drawable.b)localObject2).dX();
            localb.a(localImageView, str, (Drawable)localObject2, com.tencent.mm.modelappbrand.a.g.gSK);
            label514:
            if (bt.isNullOrNil(((d)localObject1).title)) {
              break label567;
            }
            paramb.titleTv.setText(((d)localObject1).title);
          }
          for (;;)
          {
            if (!paramb1.nbP) {
              break label590;
            }
            paramb.nbz.setVisibility(0);
            break;
            label555:
            paramb.kXS.setImageResource(2131231875);
            break label514;
            label567:
            paramb.titleTv.setText(BizTimeLineHotListView.this.getContext().getString(2131756647));
          }
          label590:
          paramb.nbz.setVisibility(8);
        }
      }
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(6075);
      if (bt.gL(BizTimeLineHotListView.a(BizTimeLineHotListView.this)))
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
    extends RecyclerView.v
  {
    public View arI;
    public ImageView kXS;
    public ImageView lVy;
    public FrameLayout lVz;
    public ImageView nbz;
    public TextView titleTv;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(6080);
      this.arI = paramView;
      paramView.getLayoutParams().width = (BizTimeLineHotListView.this.getResources().getDisplayMetrics().widthPixels / 4);
      this.kXS = ((ImageView)paramView.findViewById(2131297336));
      this.lVy = ((ImageView)paramView.findViewById(2131297337));
      this.lVz = ((FrameLayout)paramView.findViewById(2131297338));
      this.titleTv = ((TextView)paramView.findViewById(2131297339));
      this.nbz = ((ImageView)paramView.findViewById(2131297340));
      AppMethodBeat.o(6080);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotListView
 * JD-Core Version:    0.7.0.1
 */