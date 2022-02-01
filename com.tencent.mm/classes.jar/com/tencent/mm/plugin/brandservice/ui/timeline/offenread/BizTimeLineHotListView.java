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
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.byx;
import com.tencent.mm.protocal.protobuf.bza;
import com.tencent.mm.protocal.protobuf.dpz;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BizTimeLineHotListView
  extends MRecyclerView
{
  public static int nzi;
  private Context mContext;
  private float mNP;
  private int mNQ;
  private int mScreenWidth;
  private List<b> mgF;
  g nDR;
  private a nDS;
  boolean nDT;
  private f nDU;
  private i nDV;
  private float nDW;
  private float nDX;
  private float nDY;
  public com.tencent.mm.sdk.b.c<ao> nDZ;
  
  public BizTimeLineHotListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(6081);
    this.mgF = new ArrayList();
    this.mNP = 0.0F;
    this.mScreenWidth = 0;
    this.mNQ = 0;
    this.nDT = false;
    this.nDW = 0.0F;
    this.nDX = 0.0F;
    this.nDY = 0.0F;
    this.nDZ = new com.tencent.mm.sdk.b.c() {};
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(6081);
  }
  
  public BizTimeLineHotListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(6082);
    this.mgF = new ArrayList();
    this.mNP = 0.0F;
    this.mScreenWidth = 0;
    this.mNQ = 0;
    this.nDT = false;
    this.nDW = 0.0F;
    this.nDX = 0.0F;
    this.nDY = 0.0F;
    this.nDZ = new com.tencent.mm.sdk.b.c() {};
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(6082);
  }
  
  private static void a(d paramd, dpz paramdpz)
  {
    AppMethodBeat.i(198727);
    if ((paramd != null) && (paramdpz != null))
    {
      paramd.title = paramdpz.title;
      paramd.iDU = paramdpz.FXm;
      paramd.appId = paramdpz.djj;
      paramd.hhs = paramdpz.hhs;
      paramd.nEz = paramdpz.FXg;
      paramd.aBM = paramdpz.version;
      paramd.nEx = paramdpz.FXf;
      paramd.nEy = paramdpz.FXj;
      paramd.nEw = yL(paramdpz.FXf);
    }
    AppMethodBeat.o(198727);
  }
  
  private void bH(List<b> paramList)
  {
    AppMethodBeat.i(6093);
    if (this.mgF == null)
    {
      AppMethodBeat.o(6093);
      return;
    }
    b localb = new b(2);
    localb.DSy = "__BizTimeLine.CustomItem__";
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
    if (com.tencent.mm.plugin.brandservice.b.c.bJd())
    {
      ac.i("MicroMsg.BizTimeLineHotListView", "alvinluo addCustomItems timeline top bar entry is open");
      d locald = new d();
      dpz localdpz = com.tencent.mm.plugin.brandservice.b.c.bJf();
      if (localdpz != null)
      {
        locald.DSy = "__BizTimeLine.VideoChannelEntry__";
        a(locald, localdpz);
        paramList.add(1, locald);
        locald.position = 1;
        this.nDT = true;
      }
    }
    AppMethodBeat.o(175433);
  }
  
  private void g(RecyclerView.w paramw, int paramInt)
  {
    AppMethodBeat.i(6087);
    ac.d("MicroMsg.BizTimeLineHotListView", "alvinluo updateAlpha pos: %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramw != null)
    {
      float f = paramw.asD.getX();
      if (f >= this.mScreenWidth - getItemWidth() / 2)
      {
        paramw.asD.setAlpha(0.3F);
        AppMethodBeat.o(6087);
        return;
      }
      if ((f < this.mScreenWidth - getItemWidth() / 2) && (f >= this.mNP))
      {
        f = 1.0F - (f - this.mNP) / this.mNQ * 0.7F;
        ac.d("MicroMsg.BizTimeLineHotListView", "alvinluo updateAlpha %f", new Object[] { Float.valueOf(f) });
        paramw.asD.setAlpha(f);
        AppMethodBeat.o(6087);
        return;
      }
      paramw.asD.setAlpha(1.0F);
    }
    AppMethodBeat.o(6087);
  }
  
  private void init()
  {
    AppMethodBeat.i(175432);
    ac.v("MicroMsg.BizTimeLineHotListView", "alvinluo init");
    nzi = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 8);
    this.nDZ.alive();
    AppMethodBeat.o(175432);
  }
  
  private static boolean yL(int paramInt)
  {
    AppMethodBeat.i(198726);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(198726);
      return false;
    }
    int i = aw.aKU("MicroMsg.BizTimeLineHotListView").decodeInt("VideoChannelTopBarVersion", 0);
    ac.i("MicroMsg.BizTimeLineHotListView", "getVideoChannelUnReadState, version: %d, lastVersion: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    if (paramInt > i)
    {
      AppMethodBeat.o(198726);
      return true;
    }
    AppMethodBeat.o(198726);
    return false;
  }
  
  public final void a(Context paramContext, List<b> paramList, f paramf, i parami)
  {
    AppMethodBeat.i(198725);
    this.nDU = paramf;
    this.nDV = parami;
    this.mgF.addAll(paramList);
    bH(this.mgF);
    this.nDS = new a(paramContext);
    paramList = new LinearLayoutManager()
    {
      public final boolean jK()
      {
        return false;
      }
    };
    paramList.setOrientation(0);
    setLayoutManager(paramList);
    setAdapter(this.nDS);
    this.nDR = new g(getCustomItemCount());
    paramList = this.nDR;
    int i = a.getCompletelyCountPerPage();
    paramList.mContext = paramContext;
    paramList.nEE = this;
    paramList.mOh = i;
    paramList.nEE.b(paramList);
    paramList.nEE.a(paramList);
    paramList.mOk = ((LinearLayoutManager)paramList.nEE.getLayoutManager());
    paramList.aru = new g.1(paramList, paramList.nEE.getContext());
    paramList.mOg = new g.2(paramList, paramList.nEE.getContext());
    setOnScrollPageListener(new g.a()
    {
      public final void M(int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(198722);
        if (!paramAnonymousBoolean)
        {
          int i = (int)(System.currentTimeMillis() / 1000L);
          h.wUl.f(15721, new Object[] { "", Integer.valueOf(0), Integer.valueOf(10), Integer.valueOf(i), Integer.valueOf(com.tencent.mm.storage.v.getSessionId()) });
        }
        BizTimeLineHotListView.a(BizTimeLineHotListView.this, paramAnonymousInt);
        BizTimeLineHotListView.this.bKm();
        AppMethodBeat.o(198722);
      }
      
      public final void yM(int paramAnonymousInt)
      {
        AppMethodBeat.i(198721);
        int i = BizTimeLineHotListView.this.getCurrentPage();
        ac.d("MicroMsg.BizTimeLineHotListView", "alvinluo ScrollPageListener onScrolled offsetOfCurPage: %d, , currentPage: %d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i) });
        BizTimeLineHotListView.a(BizTimeLineHotListView.this, paramAnonymousInt, i);
        BizTimeLineHotListView.f(BizTimeLineHotListView.this);
        AppMethodBeat.o(198721);
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
        Object localObject1;
        Object localObject2;
        if (localb != null)
        {
          localObject1 = localf.nEC.iterator();
          for (;;)
          {
            if (((Iterator)localObject1).hasNext())
            {
              localObject2 = (byx)((Iterator)localObject1).next();
              if (bs.lr(((byx)localObject2).Ecn, localb.DSy))
              {
                ((byx)localObject2).FnT = ((int)(System.currentTimeMillis() / 1000L));
                if (localb.nEw)
                {
                  paramAnonymousInt = 1;
                  ((byx)localObject2).FnS = paramAnonymousInt;
                }
              }
            }
          }
        }
        for (;;)
        {
          if (localb.type == 1)
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("Chat_User", localb.DSy);
            paramAnonymousView.putExtra("finish_direct", true);
            paramAnonymousView.putExtra("KOpenArticleSceneFromScene", 91);
            paramAnonymousView.putExtra("specific_chat_from_scene", 8);
            paramAnonymousView.putExtra("preChatTYPE", 12);
            com.tencent.mm.br.d.e(BizTimeLineHotListView.e(BizTimeLineHotListView.this), ".ui.chatting.ChattingUI", paramAnonymousView);
            localb.nEw = false;
            BizTimeLineHotListView.this.a(localb);
            AppMethodBeat.o(175429);
            return;
            paramAnonymousInt = 0;
            break;
            if (localb.type == 1)
            {
              localObject1 = new byx();
              ((byx)localObject1).Ecn = localb.DSy;
              ((byx)localObject1).tfK = (localb.position - 1);
              ((byx)localObject1).FnT = ((int)(System.currentTimeMillis() / 1000L));
              if (localb.nEw) {}
              for (paramAnonymousInt = 1;; paramAnonymousInt = 0)
              {
                ((byx)localObject1).FnS = paramAnonymousInt;
                ((byx)localObject1).type = 0;
                localf.nEC.add(localObject1);
                break;
              }
            }
            if (localb.type == 3)
            {
              localObject1 = new byx();
              ((byx)localObject1).tfK = (localb.position - 1);
              ((byx)localObject1).FnT = ((int)(System.currentTimeMillis() / 1000L));
              ((byx)localObject1).type = 1;
              localObject2 = com.tencent.mm.plugin.brandservice.b.c.nva;
              ((byx)localObject1).hhs = com.tencent.mm.plugin.brandservice.b.c.ja(false);
              localObject2 = com.tencent.mm.plugin.brandservice.b.c.nva;
              if (com.tencent.mm.plugin.brandservice.b.c.bJk()) {}
              for (paramAnonymousInt = 1;; paramAnonymousInt = 0)
              {
                ((byx)localObject1).FnV = paramAnonymousInt;
                localObject2 = com.tencent.mm.plugin.brandservice.b.c.nva;
                ((byx)localObject1).FnU = com.tencent.mm.plugin.brandservice.b.c.bJl();
                localf.nEC.add(localObject1);
                break;
              }
            }
          }
        }
        if (localb.type == 3)
        {
          ac.i("MicroMsg.BizTimeLineHotListView", "alvinluo onClick jump to video channel");
          if ((localb instanceof d)) {
            BizTimeLineHotListView.a(BizTimeLineHotListView.this, (d)localb, paramAnonymousView);
          }
        }
        AppMethodBeat.o(175429);
      }
    });
    AppMethodBeat.o(198725);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(198724);
    if (paramb == null)
    {
      AppMethodBeat.o(198724);
      return;
    }
    b localb = (b)ci(paramb.position);
    if (localb == null)
    {
      ac.e("MicroMsg.BizTimeLineHotListView", "refreshUnread %s", new Object[] { paramb.DSy });
      AppMethodBeat.o(198724);
      return;
    }
    if (paramb.nEw)
    {
      localb.nEd.setVisibility(0);
      AppMethodBeat.o(198724);
      return;
    }
    localb.nEd.setVisibility(8);
    AppMethodBeat.o(198724);
  }
  
  public final boolean ai(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(6088);
    g localg = this.nDR;
    localg.O(localg.wm(localg.mOffsetX + paramInt1), false);
    boolean bool = super.ai(paramInt1, paramInt2);
    AppMethodBeat.o(6088);
    return bool;
  }
  
  public final boolean bBG()
  {
    return false;
  }
  
  public final void bKm()
  {
    AppMethodBeat.i(6085);
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.mgF);
    int m = getCurrentPage();
    int j = g.wp(m);
    int k = g.wq(m);
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
        localf = this.nDU;
        if (localb != null)
        {
          if (localb.type != 1) {
            break label300;
          }
          localbza = (bza)localf.nEB.get(localb.DSy);
          if (localbza != null) {
            break label233;
          }
          localbza = new bza();
          localbza.Ecn = localb.DSy;
          if (!localb.nEw) {
            break label228;
          }
          j = 1;
          localbza.FnS = j;
          localbza.FnT = ((int)(System.currentTimeMillis() / 1000L));
          localbza.tfK = (localb.position - 1);
          localbza.nTd = 1;
          localbza.type = 0;
          localf.nEB.put(localb.DSy, localbza);
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
        if (localb.nEw) {}
        for (j = 1;; j = 0)
        {
          localbza.FnS = j;
          localbza.FnT = ((int)(System.currentTimeMillis() / 1000L));
          localbza.tfK = (localb.position - 1);
          localbza.type = 0;
          localbza.nTd += 1;
          break;
        }
      }
      label300:
      bza localbza = new bza();
      localbza.FnT = ((int)(System.currentTimeMillis() / 1000L));
      localbza.tfK = (localb.position - 1);
      localbza.nTd = 1;
      localbza.type = 1;
      com.tencent.mm.plugin.brandservice.b.c localc = com.tencent.mm.plugin.brandservice.b.c.nva;
      localbza.hhs = com.tencent.mm.plugin.brandservice.b.c.ja(false);
      localc = com.tencent.mm.plugin.brandservice.b.c.nva;
      if (com.tencent.mm.plugin.brandservice.b.c.bJk()) {}
      for (j = 1;; j = 0)
      {
        localbza.FnV = j;
        localc = com.tencent.mm.plugin.brandservice.b.c.nva;
        localbza.FnU = com.tencent.mm.plugin.brandservice.b.c.bJl();
        localf.nEB.put(localb.DSy, localbza);
        break;
      }
    }
    AppMethodBeat.o(6085);
  }
  
  public final void cd(List<b> paramList)
  {
    AppMethodBeat.i(6084);
    this.mgF.clear();
    this.mgF.addAll(paramList);
    bH(this.mgF);
    this.nDS.arg.notifyChanged();
    AppMethodBeat.o(6084);
  }
  
  public a getAdapter()
  {
    return this.nDS;
  }
  
  public int getCurrentPage()
  {
    if (this.nDR != null) {
      return this.nDR.mHJ;
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
    int i = this.mgF.size();
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
    if (this.nDT) {
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
    if (this.nDR != null) {
      this.nDR.nEG = parama;
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
        ac.i("MicroMsg.BizTimeLineHotListView", "alvinluo lastPosition %d set width %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      }
      paramb.asD.getLayoutParams().width = i;
      paramb.asD.setScaleX(1.0F);
      paramb.asD.setScaleY(1.0F);
      paramb.titleTv.setText("pos:".concat(String.valueOf(paramInt)));
      ac.d("MicroMsg.BizTimeLineHotListView", "alvinluo onBindCustomViewHolder postion: %d, width: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      Object localObject;
      if ((paramb1 != null) && (paramb1.type == 1))
      {
        a.b.d(paramb.lzC, paramb1.DSy);
        localObject = com.tencent.mm.model.v.wk(paramb1.DSy);
        paramb.titleTv.setText((CharSequence)localObject);
        if (paramb1.nEw)
        {
          paramb.nEd.setVisibility(0);
          paramb.nEe.setVisibility(8);
        }
      }
      for (;;)
      {
        BizTimeLineHotListView.a(BizTimeLineHotListView.this, paramb, paramb1, paramInt);
        AppMethodBeat.o(6077);
        return;
        paramb.nEd.setVisibility(8);
        break;
        if ((paramb1 != null) && (paramb1.type == 3))
        {
          if ((paramb1 instanceof d))
          {
            localObject = (d)paramb1;
            com.tencent.mm.plugin.brandservice.b.c localc = com.tencent.mm.plugin.brandservice.b.c.nva;
            if (!com.tencent.mm.plugin.brandservice.b.c.e(paramb.lzC)) {
              paramb.lzC.setImageResource(2131231342);
            }
            if ((bs.isNullOrNil(((d)localObject).title)) && (bs.isNullOrNil(((d)localObject).iDU))) {
              break label455;
            }
            localc = com.tencent.mm.plugin.brandservice.b.c.nva;
            if ((com.tencent.mm.plugin.brandservice.b.c.bJj()) && (!bs.isNullOrNil(((d)localObject).iDU))) {
              paramb.titleTv.setText(((d)localObject).iDU);
            }
          }
          else
          {
            label414:
            if (!paramb1.nEw) {
              break label477;
            }
            paramb.nEd.setVisibility(0);
          }
          for (;;)
          {
            paramb.nEe.setVisibility(0);
            break;
            paramb.titleTv.setText(((d)localObject).title);
            break label414;
            label455:
            paramb.titleTv.setText(BizTimeLineHotListView.this.getContext().getString(2131756647));
            break label414;
            label477:
            paramb.nEd.setVisibility(8);
          }
        }
        paramb.nEe.setVisibility(8);
      }
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(6075);
      if (bs.gY(BizTimeLineHotListView.a(BizTimeLineHotListView.this)))
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
    public View asD;
    public ImageView lzC;
    public ImageView mxA;
    public FrameLayout mxB;
    public ImageView nEd;
    public ImageView nEe;
    public TextView titleTv;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(6080);
      this.asD = paramView;
      paramView.getLayoutParams().width = (BizTimeLineHotListView.this.getResources().getDisplayMetrics().widthPixels / 4);
      this.lzC = ((ImageView)paramView.findViewById(2131297336));
      this.mxA = ((ImageView)paramView.findViewById(2131297337));
      this.mxB = ((FrameLayout)paramView.findViewById(2131297338));
      this.titleTv = ((TextView)paramView.findViewById(2131297339));
      this.nEd = ((ImageView)paramView.findViewById(2131297340));
      this.nEe = ((ImageView)paramView.findViewById(2131307281));
      AppMethodBeat.o(6080);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotListView
 * JD-Core Version:    0.7.0.1
 */