package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.v;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.d;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.ah;
import com.tencent.mm.plugin.appbrand.appusage.ai;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.tools.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class BaseAppBrandRecentView
  extends AppBrandRecentView
  implements k.a
{
  protected int aNI = 0;
  private float avt;
  private float avu;
  protected AppBrandRecentView.f lWN;
  List<a> lWb = new ArrayList();
  private Context mContext;
  private ap mlA = null;
  private ConcurrentLinkedQueue<c> mlB = new ConcurrentLinkedQueue();
  private AppBrandRecentView.c mlC = new AppBrandRecentView.c()
  {
    public final List<LocalUsageInfo> uK(int paramAnonymousInt)
    {
      AppMethodBeat.i(49965);
      List localList = ((ai)com.tencent.mm.kernel.g.ab(ai.class)).qL(paramAnonymousInt);
      AppMethodBeat.o(49965);
      return localList;
    }
  };
  private float mlD = 1.0F;
  private boolean mlE = false;
  protected float mlq;
  private AppBrandRecentView.b mlr;
  public List<a> mls = new ArrayList();
  private c mlt;
  private a mlu;
  public e mlv = null;
  boolean mlw = false;
  private AppBrandRecentView.d mlx = null;
  private final Object mly = new Object();
  private boolean mlz = false;
  
  public BaseAppBrandRecentView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public BaseAppBrandRecentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  private static String NY(String paramString)
  {
    if (paramString != null) {
      try
      {
        if (f.aLJ(paramString) <= 11) {
          return paramString;
        }
        Object localObject = paramString.toCharArray();
        int m = localObject.length;
        int j = 0;
        int i = 0;
        int k = 0;
        while (j < m)
        {
          k += f.aLJ(String.valueOf(localObject[j]));
          if (k >= 11)
          {
            localObject = paramString.substring(0, i) + '…';
            return localObject;
          }
          j += 1;
          i += 1;
        }
        return paramString;
      }
      catch (Exception localException) {}
    }
  }
  
  public void a(b paramb, a parama, int paramInt)
  {
    int j = getItemWidth();
    float f = getShowCountPerPage();
    int i = j;
    if (j <= 0) {
      i = (int)(getWidth() / f);
    }
    j = i;
    if (i <= 0) {
      j = (int)(getResources().getDisplayMetrics().widthPixels / f);
    }
    i = j;
    if (paramInt == this.mlu.getItemCount() - 1)
    {
      double d = j;
      i = (int)((1.0D - (Math.ceil(f) - f)) * d);
      ad.i("MicroMsg.BaseAppBrandRecentView", "alvinluo lastPosition %d set width %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    }
    paramb.arI.getLayoutParams().width = i;
    paramb.arI.setScaleX(1.0F);
    paramb.arI.setScaleY(1.0F);
    ad.d("MicroMsg.BaseAppBrandRecentView", "alvinluo onBindCustomViewHolder postion: %d, width: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    if ((parama != null) && (parama.type == 1) && (parama.lVq != null))
    {
      if (bt.isNullOrNil(parama.lVq.cfp)) {
        break label282;
      }
      paramb.titleTv.setText(NY(parama.lVq.cfp));
      paramb.titleTv.setVisibility(0);
    }
    for (;;)
    {
      paramb.lVy.setVisibility(0);
      if (bt.isNullOrNil(parama.lVq.iVP)) {
        break;
      }
      com.tencent.mm.modelappbrand.a.b.aub().a(paramb.kXS, parama.lVq.iVP, com.tencent.mm.modelappbrand.a.a.aua(), com.tencent.mm.modelappbrand.a.g.gSK);
      return;
      label282:
      if (!bt.isNullOrNil(parama.lVq.nickname))
      {
        String str = NY(parama.lVq.nickname);
        paramb.titleTv.setText(str);
        paramb.titleTv.setVisibility(0);
      }
      else if (!bt.isNullOrNil(parama.lVq.username))
      {
        paramb.titleTv.setText(parama.lVq.username);
        paramb.titleTv.setVisibility(0);
      }
      else
      {
        ad.w("MicroMsg.BaseAppBrandRecentView", "[onBindCustomViewHolder] nickname is null! username:%s appId:%s", new Object[] { parama.lVq.username, parama.lVq.appId });
        paramb.titleTv.setText("");
        paramb.titleTv.setVisibility(4);
      }
    }
    paramb.kXS.setImageDrawable(com.tencent.mm.modelappbrand.a.a.aua());
  }
  
  public void a(String paramString, m paramm)
  {
    ad.i("MicroMsg.BaseAppBrandRecentView", "[onNotifyChange] process:%s eventId:%s, mType: %s", new Object[] { ((h)com.tencent.mm.kernel.g.afy().aeZ()).toString(), Integer.valueOf(paramm.jqR), this.lWN });
    if ((paramm.jqR == 5) && (buE()))
    {
      ad.i("MicroMsg.BaseAppBrandRecentView", "[onNotifyChange] Ignore!!!");
      return;
    }
    refresh();
  }
  
  public final boolean ai(int paramInt1, int paramInt2)
  {
    e locale = this.mlv;
    locale.O(locale.vv(locale.mOffsetX + paramInt1), false);
    return super.ai(paramInt1, paramInt2);
  }
  
  public void bH(List<a> paramList) {}
  
  protected boolean buE()
  {
    return false;
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    return true;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.avt = paramMotionEvent.getRawX();
      this.avu = paramMotionEvent.getRawY();
    }
    while ((paramMotionEvent.getAction() != 2) || (!this.mlE))
    {
      if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)) {
        this.mlE = false;
      }
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    return true;
  }
  
  public RecyclerView.a getAdapter()
  {
    return this.mlu;
  }
  
  protected int getCompletelyCountPerPage()
  {
    return 4;
  }
  
  public int getCount()
  {
    return this.mls.size();
  }
  
  public int getCurrentPage()
  {
    if (this.mlv != null) {
      return this.mlv.mfK;
    }
    return 0;
  }
  
  public int getCustomItemCount()
  {
    return 0;
  }
  
  public int getDataCount()
  {
    if (this.mls != null) {
      return this.mls.size();
    }
    return 0;
  }
  
  public int getItemWidth()
  {
    return 0;
  }
  
  public abstract int getLayoutId();
  
  protected abstract int getLoadCount();
  
  protected AppBrandRecentView.d getOnDataChangedListener()
  {
    return this.mlx;
  }
  
  public AppBrandRecentView.b getOnItemClickListener()
  {
    return this.mlr;
  }
  
  public List<a> getPreviewItemList()
  {
    if (this.mls == null) {
      this.mls = new ArrayList();
    }
    return this.mls;
  }
  
  protected abstract int getShowCount();
  
  protected float getShowCountPerPage()
  {
    return 4.0F;
  }
  
  protected abstract String getType();
  
  protected void init(Context paramContext)
  {
    this.mContext = paramContext;
    this.mlq = paramContext.getResources().getDimension(2131165258);
    paramContext = new LinearLayoutManager()
    {
      public final boolean jC()
      {
        return false;
      }
    };
    paramContext.setOrientation(0);
    setLayoutManager(paramContext);
    setHasFixedSize(true);
    paramContext = new a((byte)0);
    this.mlu = paramContext;
    setAdapter(paramContext);
    this.mlv = new e(getCustomItemCount());
    paramContext = this.mlv;
    Context localContext = getContext();
    int i = getCompletelyCountPerPage();
    paramContext.mContext = localContext;
    paramContext.mmc = this;
    paramContext.mmg = i;
    paramContext.mmc.b(paramContext);
    paramContext.mmc.a(paramContext);
    paramContext.mmj = ((LinearLayoutManager)paramContext.mmc.getLayoutManager());
    paramContext.aqy = new e.1(paramContext, paramContext.mmc.getContext());
    paramContext.mmf = new e.2(paramContext, paramContext.mmc.getContext());
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.aNI = getMeasuredWidth();
    ad.d("MicroMsg.BaseAppBrandRecentView", "alvinluo onMeasure mViewWidth %d", new Object[] { Integer.valueOf(this.aNI) });
  }
  
  public final void refresh()
  {
    if (this.mlA == null) {
      this.mlA = new ap("UpdateAppBrandList_" + this.lWN);
    }
    synchronized (this.mly)
    {
      if (this.mlz)
      {
        ad.i("MicroMsg.BaseAppBrandRecentView", "alvinluo refresh is running and delay mType: %s", new Object[] { this.lWN });
        if (this.mlB.size() <= 0)
        {
          ad.i("MicroMsg.BaseAppBrandRecentView", "alvinluo refresh add updateTask");
          this.mlB.add(new c());
        }
        return;
      }
      this.mlz = true;
      this.mlA.postToWorker(new c());
    }
  }
  
  public final void release()
  {
    if (this.lWN == AppBrandRecentView.f.mkx) {
      if (com.tencent.mm.kernel.g.ab(ah.class) != null) {
        ((ah)com.tencent.mm.kernel.g.ab(ah.class)).remove(this);
      }
    }
    for (;;)
    {
      if (this.mlt != null) {
        this.mlt.cancel();
      }
      this.mls.clear();
      if (this.mlA != null) {
        this.mlA.quit();
      }
      return;
      if ((this.lWN == AppBrandRecentView.f.mkw) && (com.tencent.mm.kernel.g.ab(ai.class) != null)) {
        ((ai)com.tencent.mm.kernel.g.ab(ai.class)).remove(this);
      }
    }
  }
  
  public void setDataQuery(AppBrandRecentView.c paramc)
  {
    this.mlC = paramc;
  }
  
  public void setEnableDataCache(boolean paramBoolean)
  {
    this.mlw = paramBoolean;
  }
  
  public void setOnDataChangedListener(AppBrandRecentView.d paramd)
  {
    this.mlx = paramd;
  }
  
  public void setOnItemClickListener(AppBrandRecentView.b paramb)
  {
    this.mlr = paramb;
  }
  
  public void setOnScrollPageListener(e.a parama)
  {
    if (this.mlv != null) {
      this.mlv.mml = parama;
    }
  }
  
  public void setType(AppBrandRecentView.f paramf)
  {
    this.lWN = paramf;
    if (this.lWN == AppBrandRecentView.f.mkx) {
      if (com.tencent.mm.kernel.g.ab(ah.class) != null) {
        ((ah)com.tencent.mm.kernel.g.ab(ah.class)).add(this);
      }
    }
    while ((this.lWN != AppBrandRecentView.f.mkw) || (com.tencent.mm.kernel.g.ab(ai.class) == null)) {
      return;
    }
    ((ai)com.tencent.mm.kernel.g.ab(ai.class)).add(this);
  }
  
  protected void vt(int paramInt)
  {
    if ((this.mlw) && (paramInt - 1 < this.lWb.size())) {
      this.lWb.remove(paramInt - 1);
    }
  }
  
  protected final class a
    extends RecyclerView.a<BaseAppBrandRecentView.b>
  {
    c.a mlG;
    
    private a()
    {
      AppMethodBeat.i(49966);
      this.mlG = new c.a();
      this.mlG.hkf = 2131690013;
      AppMethodBeat.o(49966);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(49967);
      int j = BaseAppBrandRecentView.b(BaseAppBrandRecentView.this).size();
      int k = BaseAppBrandRecentView.this.getCompletelyCountPerPage();
      int i = j;
      if (BaseAppBrandRecentView.this.getCustomItemCount() == 1) {
        i = j - 1;
      }
      j = i;
      if (i > BaseAppBrandRecentView.this.getShowCount()) {
        j = BaseAppBrandRecentView.this.getShowCount();
      }
      if (BaseAppBrandRecentView.this.getCustomItemCount() == 1)
      {
        if (j % k == 0) {}
        for (i = j + 1;; i = j + (k + 1 - j % k))
        {
          j = BaseAppBrandRecentView.this.getCustomItemCount();
          AppMethodBeat.o(49967);
          return i + j;
        }
      }
      i = j;
      if (j % k != 0) {
        i = j + (k - j % k);
      }
      AppMethodBeat.o(49967);
      return i;
    }
  }
  
  public final class b
    extends RecyclerView.v
  {
    public View arI;
    public ImageView kXS;
    public TextView lVA;
    public ImageView lVy;
    public FrameLayout lVz;
    public TextView titleTv;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(49972);
      this.arI = paramView;
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(49970);
          a locala = (a)paramAnonymousView.getTag();
          locala.position = BaseAppBrandRecentView.b.this.ln();
          if (BaseAppBrandRecentView.this.getOnItemClickListener() != null) {
            BaseAppBrandRecentView.this.getOnItemClickListener().a(paramAnonymousView, locala, BaseAppBrandRecentView.c(BaseAppBrandRecentView.this), BaseAppBrandRecentView.d(BaseAppBrandRecentView.this));
          }
          AppMethodBeat.o(49970);
        }
      });
      paramView.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(49971);
          a locala = (a)paramAnonymousView.getTag();
          locala.position = BaseAppBrandRecentView.b.this.ln();
          if (BaseAppBrandRecentView.this.getOnItemClickListener() != null) {
            BaseAppBrandRecentView.this.getOnItemClickListener().b(paramAnonymousView, locala, BaseAppBrandRecentView.c(BaseAppBrandRecentView.this), BaseAppBrandRecentView.d(BaseAppBrandRecentView.this));
          }
          BaseAppBrandRecentView.e(BaseAppBrandRecentView.this);
          AppMethodBeat.o(49971);
          return true;
        }
      });
      paramView.getLayoutParams().width = (BaseAppBrandRecentView.this.getResources().getDisplayMetrics().widthPixels / 4);
      this.kXS = ((ImageView)paramView.findViewById(2131300874));
      this.lVy = ((ImageView)paramView.findViewById(2131300884));
      this.lVz = ((FrameLayout)paramView.findViewById(2131300892));
      this.titleTv = ((TextView)paramView.findViewById(2131305902));
      this.lVA = ((TextView)paramView.findViewById(2131305706));
      AppMethodBeat.o(49972);
    }
  }
  
  final class c
    extends com.tencent.e.i.b
  {
    List<a> lEL;
    List<a> mlJ;
    boolean mlK;
    
    public c()
    {
      AppMethodBeat.i(49974);
      this.mlK = true;
      this.mlK = true;
      this.lEL = new ArrayList();
      this.mlJ = new ArrayList();
      AppMethodBeat.o(49974);
    }
    
    public final String getKey()
    {
      return "MicroMsg.BaseAppBrandRecentView";
    }
    
    public final void run()
    {
      AppMethodBeat.i(49975);
      for (;;)
      {
        synchronized (BaseAppBrandRecentView.f(BaseAppBrandRecentView.this))
        {
          BaseAppBrandRecentView.a(BaseAppBrandRecentView.this, true);
          ??? = null;
          if (BaseAppBrandRecentView.g(BaseAppBrandRecentView.this) != null) {
            ??? = BaseAppBrandRecentView.g(BaseAppBrandRecentView.this).uK(BaseAppBrandRecentView.this.getLoadCount());
          }
          this.lEL.clear();
          this.mlJ.clear();
          if (??? == null) {
            break;
          }
          if (BaseAppBrandRecentView.this.getSceneFactory() != null)
          {
            LocalUsageInfo localLocalUsageInfo1 = BaseAppBrandRecentView.this.getSceneFactory().bkg();
            ??? = ((List)???).iterator();
            if (!((Iterator)???).hasNext()) {
              break;
            }
            LocalUsageInfo localLocalUsageInfo2 = (LocalUsageInfo)((Iterator)???).next();
            if ((localLocalUsageInfo1 != null) && (localLocalUsageInfo2.username.equals(localLocalUsageInfo1.username)) && (localLocalUsageInfo2.gXn == localLocalUsageInfo1.gXn)) {
              continue;
            }
            if (this.lEL.size() < BaseAppBrandRecentView.this.getShowCount()) {
              this.lEL.add(new a(localLocalUsageInfo2));
            }
            if (BaseAppBrandRecentView.h(BaseAppBrandRecentView.this)) {
              this.mlJ.add(new a(localLocalUsageInfo2));
            }
            ad.d("MicroMsg.BaseAppBrandRecentView", "alvinluo info %s, %s, %s, %s, %s, %d, mType: %s", new Object[] { localLocalUsageInfo2.username, localLocalUsageInfo2.nickname, localLocalUsageInfo2.cfp, localLocalUsageInfo2.iVP, localLocalUsageInfo2.appId, Integer.valueOf(localLocalUsageInfo2.gXn), BaseAppBrandRecentView.this.lWN });
          }
        }
        Object localObject3 = null;
      }
      BaseAppBrandRecentView.this.bH(this.lEL);
      ad.i("MicroMsg.BaseAppBrandRecentView", "[UpdateAppBrandRecentDataTask] type:%s preview size:%s, data size: %d, mType: %s", new Object[] { BaseAppBrandRecentView.this.getType(), Integer.valueOf(BaseAppBrandRecentView.b(BaseAppBrandRecentView.this).size()), Integer.valueOf(BaseAppBrandRecentView.i(BaseAppBrandRecentView.this).size()), BaseAppBrandRecentView.this.lWN });
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(49973);
          BaseAppBrandRecentView.b(BaseAppBrandRecentView.this).clear();
          BaseAppBrandRecentView.i(BaseAppBrandRecentView.this).clear();
          BaseAppBrandRecentView.b(BaseAppBrandRecentView.this).addAll(BaseAppBrandRecentView.c.this.lEL);
          BaseAppBrandRecentView.i(BaseAppBrandRecentView.this).addAll(BaseAppBrandRecentView.c.this.mlJ);
          BaseAppBrandRecentView.c.this.lEL.clear();
          BaseAppBrandRecentView.c.this.mlJ.clear();
          if ((BaseAppBrandRecentView.this.getRefreshListener() != null) && (BaseAppBrandRecentView.c.this.mlK)) {
            BaseAppBrandRecentView.this.getRefreshListener().tu(BaseAppBrandRecentView.b(BaseAppBrandRecentView.this).size());
          }
          if (BaseAppBrandRecentView.c.this.mlK)
          {
            ad.i("MicroMsg.BaseAppBrandRecentView", "alvinluo refresh done dispatch diffResult, mType: %s", new Object[] { BaseAppBrandRecentView.this.lWN });
            ??? = AppBrandRecentView.f.mkw;
            BaseAppBrandRecentView.this.getAdapter().aql.notifyChanged();
          }
          synchronized (BaseAppBrandRecentView.f(BaseAppBrandRecentView.this))
          {
            BaseAppBrandRecentView.a(BaseAppBrandRecentView.this, false);
            BaseAppBrandRecentView.j(BaseAppBrandRecentView.this);
            AppMethodBeat.o(49973);
            return;
          }
        }
      });
      AppMethodBeat.o(49975);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView
 * JD-Core Version:    0.7.0.1
 */