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
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.cei;
import com.tencent.mm.protocal.protobuf.cel;
import com.tencent.mm.protocal.protobuf.dwn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class BizTimeLineHotListView
  extends MRecyclerView
{
  public static int omu;
  private Context mContext;
  private List<b> mMj;
  private int mScreenWidth;
  private float ntw;
  private int ntx;
  g omm;
  private a omn;
  boolean omo;
  private f omp;
  private i omq;
  private float omr;
  private float oms;
  private float omt;
  public com.tencent.mm.sdk.b.c<ao> omv;
  
  public BizTimeLineHotListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(6081);
    this.mMj = new ArrayList();
    this.ntw = 0.0F;
    this.mScreenWidth = 0;
    this.ntx = 0;
    this.omo = false;
    this.omr = 0.0F;
    this.oms = 0.0F;
    this.omt = 0.0F;
    this.omv = new com.tencent.mm.sdk.b.c() {};
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(6081);
  }
  
  public BizTimeLineHotListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(6082);
    this.mMj = new ArrayList();
    this.ntw = 0.0F;
    this.mScreenWidth = 0;
    this.ntx = 0;
    this.omo = false;
    this.omr = 0.0F;
    this.oms = 0.0F;
    this.omt = 0.0F;
    this.omv = new com.tencent.mm.sdk.b.c() {};
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(6082);
  }
  
  private static void a(d paramd, dwn paramdwn)
  {
    AppMethodBeat.i(208496);
    if ((paramd != null) && (paramdwn != null))
    {
      paramd.title = paramdwn.title;
      paramd.iZX = paramdwn.IbP;
      paramd.appId = paramdwn.dwb;
      paramd.hCp = paramdwn.hCp;
      paramd.ona = paramdwn.IbJ;
      paramd.aDD = paramdwn.version;
      paramd.omY = paramdwn.IbI;
      paramd.omZ = paramdwn.IbM;
      paramd.omV = zE(paramdwn.IbI);
    }
    AppMethodBeat.o(208496);
  }
  
  private void bK(List<b> paramList)
  {
    AppMethodBeat.i(6093);
    if (this.mMj == null)
    {
      AppMethodBeat.o(6093);
      return;
    }
    b localb = new b(2);
    localb.FQp = "__BizTimeLine.CustomItem__";
    paramList.add(0, localb);
    cq(paramList);
    AppMethodBeat.o(6093);
  }
  
  private void cq(List<b> paramList)
  {
    AppMethodBeat.i(175433);
    if (paramList == null)
    {
      AppMethodBeat.o(175433);
      return;
    }
    if (com.tencent.mm.plugin.brandservice.b.c.bOt())
    {
      ae.i("MicroMsg.BizTimeLineHotListView", "alvinluo addCustomItems timeline top bar entry is open");
      d locald = new d();
      dwn localdwn = com.tencent.mm.plugin.brandservice.b.c.bOv();
      if (localdwn != null)
      {
        locald.FQp = "__BizTimeLine.VideoChannelEntry__";
        a(locald, localdwn);
        paramList.add(1, locald);
        locald.position = 1;
        this.omo = true;
      }
    }
    AppMethodBeat.o(175433);
  }
  
  private void g(RecyclerView.w paramw, int paramInt)
  {
    AppMethodBeat.i(6087);
    ae.d("MicroMsg.BizTimeLineHotListView", "alvinluo updateAlpha pos: %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramw != null)
    {
      float f = paramw.auu.getX();
      if (f >= this.mScreenWidth - getItemWidth() / 2)
      {
        paramw.auu.setAlpha(0.3F);
        AppMethodBeat.o(6087);
        return;
      }
      if ((f < this.mScreenWidth - getItemWidth() / 2) && (f >= this.ntw))
      {
        f = 1.0F - (f - this.ntw) / this.ntx * 0.7F;
        ae.d("MicroMsg.BizTimeLineHotListView", "alvinluo updateAlpha %f", new Object[] { Float.valueOf(f) });
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
    ae.v("MicroMsg.BizTimeLineHotListView", "alvinluo init");
    omu = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 16);
    this.omv.alive();
    AppMethodBeat.o(175432);
  }
  
  private static boolean zE(int paramInt)
  {
    AppMethodBeat.i(208495);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(208495);
      return false;
    }
    int i = ay.aRX("MicroMsg.BizTimeLineHotListView").decodeInt("VideoChannelTopBarVersion", 0);
    ae.i("MicroMsg.BizTimeLineHotListView", "getVideoChannelUnReadState, version: %d, lastVersion: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    if (paramInt > i)
    {
      AppMethodBeat.o(208495);
      return true;
    }
    AppMethodBeat.o(208495);
    return false;
  }
  
  public final void a(Context paramContext, List<b> paramList, f paramf, i parami)
  {
    AppMethodBeat.i(208494);
    this.omp = paramf;
    this.omq = parami;
    this.mMj.addAll(paramList);
    bK(this.mMj);
    this.omn = new a(paramContext);
    paramList = new LinearLayoutManager()
    {
      public final boolean ka()
      {
        return false;
      }
    };
    paramList.setOrientation(0);
    setLayoutManager(paramList);
    setAdapter(this.omn);
    this.omm = new g(getCustomItemCount());
    paramList = this.omm;
    int i = a.getCompletelyCountPerPage();
    paramList.mContext = paramContext;
    paramList.ong = this;
    paramList.ntO = i;
    paramList.ong.b(paramList);
    paramList.ong.a(paramList);
    paramList.ntR = ((LinearLayoutManager)paramList.ong.getLayoutManager());
    paramList.atl = new g.1(paramList, paramList.ong.getContext());
    paramList.ntN = new g.2(paramList, paramList.ong.getContext());
    setOnScrollPageListener(new g.a()
    {
      public final void N(int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(208491);
        if (!paramAnonymousBoolean)
        {
          int i = (int)(System.currentTimeMillis() / 1000L);
          com.tencent.mm.plugin.report.service.g.yxI.f(15721, new Object[] { "", Integer.valueOf(0), Integer.valueOf(10), Integer.valueOf(i), Integer.valueOf(y.getSessionId()) });
        }
        BizTimeLineHotListView.a(BizTimeLineHotListView.this, paramAnonymousInt);
        BizTimeLineHotListView.this.bPL();
        AppMethodBeat.o(208491);
      }
      
      public final void zF(int paramAnonymousInt)
      {
        AppMethodBeat.i(208490);
        int i = BizTimeLineHotListView.this.getCurrentPage();
        ae.d("MicroMsg.BizTimeLineHotListView", "alvinluo ScrollPageListener onScrolled offsetOfCurPage: %d, , currentPage: %d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i) });
        BizTimeLineHotListView.a(BizTimeLineHotListView.this, paramAnonymousInt, i);
        BizTimeLineHotListView.f(BizTimeLineHotListView.this);
        AppMethodBeat.o(208490);
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
        cei localcei;
        if (localb != null)
        {
          if (localb.type != 1) {
            break label226;
          }
          localcei = new cei();
          localcei.GaH = localb.FQp;
          localcei.uoI = (localb.position - 1);
          localcei.Hrc = ((int)(System.currentTimeMillis() / 1000L));
          if (!localb.omV) {
            break label221;
          }
          paramAnonymousInt = 1;
          localcei.Hrb = paramAnonymousInt;
          localcei.type = 0;
          localf.ond.add(localcei);
        }
        label398:
        for (;;)
        {
          label300:
          if (localb.type == 1)
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("Chat_User", localb.FQp);
            paramAnonymousView.putExtra("finish_direct", true);
            paramAnonymousView.putExtra("KOpenArticleSceneFromScene", 91);
            paramAnonymousView.putExtra("specific_chat_from_scene", 8);
            paramAnonymousView.putExtra("preChatTYPE", 12);
            com.tencent.mm.br.d.f(BizTimeLineHotListView.e(BizTimeLineHotListView.this), ".ui.chatting.ChattingUI", paramAnonymousView);
            localb.omV = false;
            BizTimeLineHotListView.this.a(localb);
            AppMethodBeat.o(175429);
            return;
            label221:
            paramAnonymousInt = 0;
            break;
            label226:
            if (localb.type == 3)
            {
              localcei = new cei();
              localcei.uoI = (localb.position - 1);
              localcei.Hrc = ((int)(System.currentTimeMillis() / 1000L));
              localcei.type = 1;
              com.tencent.mm.plugin.brandservice.b.c localc = com.tencent.mm.plugin.brandservice.b.c.och;
              localcei.hCp = com.tencent.mm.plugin.brandservice.b.c.jk(false);
              localc = com.tencent.mm.plugin.brandservice.b.c.och;
              if (com.tencent.mm.plugin.brandservice.b.c.bOB())
              {
                paramAnonymousInt = 1;
                localcei.Hre = paramAnonymousInt;
                localc = com.tencent.mm.plugin.brandservice.b.c.och;
                localcei.Hrd = com.tencent.mm.plugin.brandservice.b.c.bOC();
                localc = com.tencent.mm.plugin.brandservice.b.c.och;
                if (!com.tencent.mm.plugin.brandservice.b.c.bOA()) {
                  break label398;
                }
              }
              for (paramAnonymousInt = 1;; paramAnonymousInt = 0)
              {
                localcei.Hrf = paramAnonymousInt;
                localcei.Hrg = System.currentTimeMillis();
                ae.d("MicroMsg.BizTimeLineOftenReadReport", "onClick is_default_icon %d, is_icon_cache %d", new Object[] { Integer.valueOf(localcei.Hrf), Integer.valueOf(localcei.Hre) });
                localf.ond.add(localcei);
                break;
                paramAnonymousInt = 0;
                break label300;
              }
            }
          }
        }
        if (localb.type == 3)
        {
          ae.i("MicroMsg.BizTimeLineHotListView", "alvinluo onClick jump to video channel");
          if ((localb instanceof d)) {
            BizTimeLineHotListView.a(BizTimeLineHotListView.this, (d)localb, paramAnonymousView);
          }
        }
        AppMethodBeat.o(175429);
      }
    });
    AppMethodBeat.o(208494);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(208493);
    if (paramb == null)
    {
      AppMethodBeat.o(208493);
      return;
    }
    b localb = (b)ci(paramb.position);
    if (localb == null)
    {
      ae.e("MicroMsg.BizTimeLineHotListView", "refreshUnread %s", new Object[] { paramb.FQp });
      AppMethodBeat.o(208493);
      return;
    }
    if (paramb.omV)
    {
      localb.omC.setVisibility(0);
      AppMethodBeat.o(208493);
      return;
    }
    localb.omC.setVisibility(8);
    AppMethodBeat.o(208493);
  }
  
  public final boolean aj(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(6088);
    g localg = this.omm;
    localg.P(localg.wW(localg.mOffsetX + paramInt1), false);
    boolean bool = super.aj(paramInt1, paramInt2);
    AppMethodBeat.o(6088);
    return bool;
  }
  
  public final boolean bGD()
  {
    return false;
  }
  
  public final void bPL()
  {
    AppMethodBeat.i(6085);
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.mMj);
    int m = getCurrentPage();
    int j = g.wZ(m);
    int k = g.xa(m);
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
        localf = this.omp;
        if (localb != null)
        {
          if (localb.type != 1) {
            break label300;
          }
          localcel = (cel)localf.onc.get(localb.FQp);
          if (localcel != null) {
            break label233;
          }
          localcel = new cel();
          localcel.GaH = localb.FQp;
          if (!localb.omV) {
            break label228;
          }
          j = 1;
          localcel.Hrb = j;
          localcel.Hrc = ((int)(System.currentTimeMillis() / 1000L));
          localcel.uoI = (localb.position - 1);
          localcel.oDa = 1;
          localcel.type = 0;
          localf.onc.put(localb.FQp, localcel);
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
        if (localb.omV) {}
        for (j = 1;; j = 0)
        {
          localcel.Hrb = j;
          localcel.Hrc = ((int)(System.currentTimeMillis() / 1000L));
          localcel.uoI = (localb.position - 1);
          localcel.type = 0;
          localcel.oDa += 1;
          break;
        }
      }
      label300:
      cel localcel = new cel();
      localcel.Hrc = ((int)(System.currentTimeMillis() / 1000L));
      localcel.uoI = (localb.position - 1);
      localcel.oDa = 1;
      localcel.type = 1;
      com.tencent.mm.plugin.brandservice.b.c localc = com.tencent.mm.plugin.brandservice.b.c.och;
      localcel.hCp = com.tencent.mm.plugin.brandservice.b.c.jk(false);
      localc = com.tencent.mm.plugin.brandservice.b.c.och;
      if (com.tencent.mm.plugin.brandservice.b.c.bOB())
      {
        j = 1;
        label382:
        localcel.Hre = j;
        localc = com.tencent.mm.plugin.brandservice.b.c.och;
        localcel.Hrd = com.tencent.mm.plugin.brandservice.b.c.bOC();
        localc = com.tencent.mm.plugin.brandservice.b.c.och;
        if (!com.tencent.mm.plugin.brandservice.b.c.bOA()) {
          break label468;
        }
      }
      label468:
      for (j = 1;; j = 0)
      {
        localcel.Hrf = j;
        j = f.one;
        f.one = j + 1;
        localcel.Hrk = j;
        localcel.Hrg = System.currentTimeMillis();
        localf.onc.put(localb.FQp, localcel);
        break;
        j = 0;
        break label382;
      }
    }
    AppMethodBeat.o(6085);
  }
  
  public final void cg(List<b> paramList)
  {
    AppMethodBeat.i(6084);
    this.mMj.clear();
    this.mMj.addAll(paramList);
    bK(this.mMj);
    this.omn.asY.notifyChanged();
    AppMethodBeat.o(6084);
  }
  
  public a getAdapter()
  {
    return this.omn;
  }
  
  public int getCurrentPage()
  {
    if (this.omm != null) {
      return this.omm.nnp;
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
    int i = this.mMj.size();
    AppMethodBeat.o(6090);
    return i;
  }
  
  public int getItemPadding()
  {
    AppMethodBeat.i(6089);
    int i = a.ec(getContext());
    AppMethodBeat.o(6089);
    return i;
  }
  
  public int getItemWidth()
  {
    AppMethodBeat.i(6092);
    int i = a.eb(this.mContext);
    AppMethodBeat.o(6092);
    return i;
  }
  
  public int getShowCount()
  {
    if (this.omo) {
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
    if (this.omm != null) {
      this.omm.oni = parama;
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
        ae.i("MicroMsg.BizTimeLineHotListView", "alvinluo lastPosition %d set width %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      }
      paramb.auu.getLayoutParams().width = i;
      paramb.auu.setScaleX(1.0F);
      paramb.auu.setScaleY(1.0F);
      paramb.titleTv.setText("pos:".concat(String.valueOf(paramInt)));
      ae.d("MicroMsg.BizTimeLineHotListView", "alvinluo onBindCustomViewHolder postion: %d, width: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      Object localObject;
      if ((paramb1 != null) && (paramb1.type == 1))
      {
        a.b.d(paramb.mdt, paramb1.FQp);
        localObject = w.zP(paramb1.FQp);
        paramb.titleTv.setText((CharSequence)localObject);
        if (paramb1.omV)
        {
          paramb.omC.setVisibility(0);
          paramb.omD.setVisibility(8);
        }
      }
      for (;;)
      {
        BizTimeLineHotListView.a(BizTimeLineHotListView.this, paramb, paramb1, paramInt);
        AppMethodBeat.o(6077);
        return;
        paramb.omC.setVisibility(8);
        break;
        if ((paramb1 != null) && (paramb1.type == 3))
        {
          if ((paramb1 instanceof d))
          {
            localObject = (d)paramb1;
            com.tencent.mm.plugin.brandservice.b.c localc = com.tencent.mm.plugin.brandservice.b.c.och;
            if (!com.tencent.mm.plugin.brandservice.b.c.e(paramb.mdt)) {
              paramb.mdt.setImageResource(2131231342);
            }
            BizTimeLineHotListView.a(BizTimeLineHotListView.this, (d)localObject, paramb.titleTv);
          }
          if (paramb1.omV) {
            paramb.omC.setVisibility(0);
          }
          for (;;)
          {
            paramb.omD.setVisibility(0);
            break;
            paramb.omC.setVisibility(8);
          }
        }
        paramb.omD.setVisibility(8);
      }
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(6075);
      if (bu.ht(BizTimeLineHotListView.a(BizTimeLineHotListView.this)))
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
    public ImageView mdt;
    public ImageView ndo;
    public FrameLayout omB;
    public ImageView omC;
    public ImageView omD;
    public TextView titleTv;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(6080);
      this.auu = paramView;
      paramView.getLayoutParams().width = (BizTimeLineHotListView.this.getResources().getDisplayMetrics().widthPixels / 4);
      this.mdt = ((ImageView)paramView.findViewById(2131297336));
      this.ndo = ((ImageView)paramView.findViewById(2131297337));
      this.omB = ((FrameLayout)paramView.findViewById(2131297338));
      this.titleTv = ((TextView)paramView.findViewById(2131297339));
      this.omC = ((ImageView)paramView.findViewById(2131297340));
      this.omD = ((ImageView)paramView.findViewById(2131307281));
      AppMethodBeat.o(6080);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotListView
 * JD-Core Version:    0.7.0.1
 */