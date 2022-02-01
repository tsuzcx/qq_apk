package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.w;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
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
  protected int aYS = 0;
  private float ayf;
  private float ayg;
  private Context mContext;
  List<a> mYL = new ArrayList();
  protected AppBrandRecentView.f mZx;
  protected float nnN;
  private AppBrandRecentView.b nnO;
  public List<a> nnP = new ArrayList();
  private c nnQ;
  private a nnR;
  public e nnS = null;
  boolean nnT = false;
  private AppBrandRecentView.d nnU = null;
  private final Object nnV = new Object();
  private boolean nnW = false;
  private ap nnX = null;
  private ConcurrentLinkedQueue<c> nnY = new ConcurrentLinkedQueue();
  private AppBrandRecentView.c nnZ = new AppBrandRecentView.c()
  {
    public final List<LocalUsageInfo> wh(int paramAnonymousInt)
    {
      AppMethodBeat.i(49965);
      List localList = ((ai)com.tencent.mm.kernel.g.ab(ai.class)).rY(paramAnonymousInt);
      AppMethodBeat.o(49965);
      return localList;
    }
  };
  private float noa = 1.0F;
  private boolean nob = false;
  
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
  
  private static String VE(String paramString)
  {
    if (paramString != null) {
      try
      {
        if (f.aXj(paramString) <= 11) {
          return paramString;
        }
        Object localObject = paramString.toCharArray();
        int m = localObject.length;
        int j = 0;
        int i = 0;
        int k = 0;
        while (j < m)
        {
          k += f.aXj(String.valueOf(localObject[j]));
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
    if (paramInt == this.nnR.getItemCount() - 1)
    {
      double d = j;
      i = (int)((1.0D - (Math.ceil(f) - f)) * d);
      ad.i("MicroMsg.BaseAppBrandRecentView", "alvinluo lastPosition %d set width %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    }
    paramb.auu.getLayoutParams().width = i;
    paramb.auu.setScaleX(1.0F);
    paramb.auu.setScaleY(1.0F);
    ad.d("MicroMsg.BaseAppBrandRecentView", "alvinluo onBindCustomViewHolder postion: %d, width: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    if ((parama != null) && (parama.type == 1) && (parama.mXW != null))
    {
      if (bt.isNullOrNil(parama.mXW.cmD)) {
        break label282;
      }
      paramb.titleTv.setText(VE(parama.mXW.cmD));
      paramb.titleTv.setVisibility(0);
    }
    for (;;)
    {
      paramb.mYh.setVisibility(0);
      if (bt.isNullOrNil(parama.mXW.jPZ)) {
        break;
      }
      com.tencent.mm.modelappbrand.a.b.aDV().a(paramb.lZa, parama.mXW.jPZ, com.tencent.mm.modelappbrand.a.a.aDU(), com.tencent.mm.modelappbrand.a.g.hLC);
      return;
      label282:
      if (!bt.isNullOrNil(parama.mXW.nickname))
      {
        String str = VE(parama.mXW.nickname);
        paramb.titleTv.setText(str);
        paramb.titleTv.setVisibility(0);
      }
      else if (!bt.isNullOrNil(parama.mXW.username))
      {
        paramb.titleTv.setText(parama.mXW.username);
        paramb.titleTv.setVisibility(0);
      }
      else
      {
        ad.w("MicroMsg.BaseAppBrandRecentView", "[onBindCustomViewHolder] nickname is null! username:%s appId:%s", new Object[] { parama.mXW.username, parama.mXW.appId });
        paramb.titleTv.setText("");
        paramb.titleTv.setVisibility(4);
      }
    }
    paramb.lZa.setImageDrawable(com.tencent.mm.modelappbrand.a.a.aDU());
  }
  
  public void a(String paramString, m paramm)
  {
    ad.i("MicroMsg.BaseAppBrandRecentView", "[onNotifyChange] process:%s eventId:%s, mType: %s", new Object[] { ((h)com.tencent.mm.kernel.g.ajz().ajb()).toString(), Integer.valueOf(paramm.dtK), this.mZx });
    if ((paramm.dtK == 5) && (bFD()))
    {
      ad.i("MicroMsg.BaseAppBrandRecentView", "[onNotifyChange] Ignore!!!");
      return;
    }
    refresh();
  }
  
  public final boolean aj(int paramInt1, int paramInt2)
  {
    e locale = this.nnS;
    locale.O(locale.wR(locale.mOffsetX + paramInt1), false);
    return super.aj(paramInt1, paramInt2);
  }
  
  protected boolean bFD()
  {
    return false;
  }
  
  public void bI(List<a> paramList) {}
  
  public boolean canScrollHorizontally(int paramInt)
  {
    return true;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.ayf = paramMotionEvent.getRawX();
      this.ayg = paramMotionEvent.getRawY();
    }
    while ((paramMotionEvent.getAction() != 2) || (!this.nob))
    {
      if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)) {
        this.nob = false;
      }
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    return true;
  }
  
  public RecyclerView.a getAdapter()
  {
    return this.nnR;
  }
  
  protected int getCompletelyCountPerPage()
  {
    return 4;
  }
  
  public int getCount()
  {
    return this.nnP.size();
  }
  
  public int getCurrentPage()
  {
    if (this.nnS != null) {
      return this.nnS.nih;
    }
    return 0;
  }
  
  public int getCustomItemCount()
  {
    return 0;
  }
  
  public int getDataCount()
  {
    if (this.nnP != null) {
      return this.nnP.size();
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
    return this.nnU;
  }
  
  public AppBrandRecentView.b getOnItemClickListener()
  {
    return this.nnO;
  }
  
  public List<a> getPreviewItemList()
  {
    if (this.nnP == null) {
      this.nnP = new ArrayList();
    }
    return this.nnP;
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
    this.nnN = paramContext.getResources().getDimension(2131165258);
    paramContext = new LinearLayoutManager()
    {
      public final boolean ka()
      {
        return false;
      }
    };
    paramContext.setOrientation(0);
    setLayoutManager(paramContext);
    setHasFixedSize(true);
    paramContext = new a((byte)0);
    this.nnR = paramContext;
    setAdapter(paramContext);
    this.nnS = new e(getCustomItemCount());
    paramContext = this.nnS;
    Context localContext = getContext();
    int i = getCompletelyCountPerPage();
    paramContext.mContext = localContext;
    paramContext.noA = this;
    paramContext.noE = i;
    paramContext.noA.b(paramContext);
    paramContext.noA.a(paramContext);
    paramContext.noH = ((LinearLayoutManager)paramContext.noA.getLayoutManager());
    paramContext.atl = new e.1(paramContext, paramContext.noA.getContext());
    paramContext.noD = new e.2(paramContext, paramContext.noA.getContext());
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.aYS = getMeasuredWidth();
    ad.d("MicroMsg.BaseAppBrandRecentView", "alvinluo onMeasure mViewWidth %d", new Object[] { Integer.valueOf(this.aYS) });
  }
  
  public final void refresh()
  {
    if (this.nnX == null) {
      this.nnX = new ap("UpdateAppBrandList_" + this.mZx);
    }
    synchronized (this.nnV)
    {
      if (this.nnW)
      {
        ad.i("MicroMsg.BaseAppBrandRecentView", "alvinluo refresh is running and delay mType: %s", new Object[] { this.mZx });
        if (this.nnY.size() <= 0)
        {
          ad.i("MicroMsg.BaseAppBrandRecentView", "alvinluo refresh add updateTask");
          this.nnY.add(new c());
        }
        return;
      }
      this.nnW = true;
      this.nnX.postToWorker(new c());
    }
  }
  
  public final void release()
  {
    if (this.mZx == AppBrandRecentView.f.nmU) {
      if (com.tencent.mm.kernel.g.ab(ah.class) != null) {
        ((ah)com.tencent.mm.kernel.g.ab(ah.class)).remove(this);
      }
    }
    for (;;)
    {
      if (this.nnQ != null) {
        this.nnQ.cancel();
      }
      this.nnP.clear();
      if (this.nnX != null) {
        this.nnX.quit();
      }
      return;
      if ((this.mZx == AppBrandRecentView.f.nmT) && (com.tencent.mm.kernel.g.ab(ai.class) != null)) {
        ((ai)com.tencent.mm.kernel.g.ab(ai.class)).remove(this);
      }
    }
  }
  
  public void setDataQuery(AppBrandRecentView.c paramc)
  {
    this.nnZ = paramc;
  }
  
  public void setEnableDataCache(boolean paramBoolean)
  {
    this.nnT = paramBoolean;
  }
  
  public void setOnDataChangedListener(AppBrandRecentView.d paramd)
  {
    this.nnU = paramd;
  }
  
  public void setOnItemClickListener(AppBrandRecentView.b paramb)
  {
    this.nnO = paramb;
  }
  
  public void setOnScrollPageListener(e.a parama)
  {
    if (this.nnS != null) {
      this.nnS.noJ = parama;
    }
  }
  
  public void setType(AppBrandRecentView.f paramf)
  {
    this.mZx = paramf;
    if (this.mZx == AppBrandRecentView.f.nmU) {
      if (com.tencent.mm.kernel.g.ab(ah.class) != null) {
        ((ah)com.tencent.mm.kernel.g.ab(ah.class)).add(this);
      }
    }
    while ((this.mZx != AppBrandRecentView.f.nmT) || (com.tencent.mm.kernel.g.ab(ai.class) == null)) {
      return;
    }
    ((ai)com.tencent.mm.kernel.g.ab(ai.class)).add(this);
  }
  
  protected void wP(int paramInt)
  {
    if ((this.nnT) && (paramInt - 1 < this.mYL.size())) {
      this.mYL.remove(paramInt - 1);
    }
  }
  
  protected final class a
    extends RecyclerView.a<BaseAppBrandRecentView.b>
  {
    c.a nod;
    
    private a()
    {
      AppMethodBeat.i(49966);
      this.nod = new c.a();
      this.nod.idD = 2131690013;
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
    extends RecyclerView.w
  {
    public View auu;
    public ImageView lZa;
    public ImageView mYh;
    public TextView mYj;
    public ImageView mYl;
    public RelativeLayout noe;
    public TextView titleTv;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(49972);
      this.auu = paramView;
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(49970);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/recentview/BaseAppBrandRecentView$RecentViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          localObject = (a)paramAnonymousView.getTag();
          ((a)localObject).position = BaseAppBrandRecentView.b.this.lN();
          if (BaseAppBrandRecentView.this.getOnItemClickListener() != null) {
            BaseAppBrandRecentView.this.getOnItemClickListener().a(paramAnonymousView, (a)localObject, BaseAppBrandRecentView.c(BaseAppBrandRecentView.this), BaseAppBrandRecentView.d(BaseAppBrandRecentView.this));
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/recentview/BaseAppBrandRecentView$RecentViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(49970);
        }
      });
      paramView.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(49971);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/recentview/BaseAppBrandRecentView$RecentViewHolder$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          localObject = (a)paramAnonymousView.getTag();
          ((a)localObject).position = BaseAppBrandRecentView.b.this.lN();
          if (BaseAppBrandRecentView.this.getOnItemClickListener() != null) {
            BaseAppBrandRecentView.this.getOnItemClickListener().b(paramAnonymousView, (a)localObject, BaseAppBrandRecentView.c(BaseAppBrandRecentView.this), BaseAppBrandRecentView.d(BaseAppBrandRecentView.this));
          }
          BaseAppBrandRecentView.e(BaseAppBrandRecentView.this);
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/appbrand/widget/recentview/BaseAppBrandRecentView$RecentViewHolder$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(49971);
          return true;
        }
      });
      paramView.getLayoutParams().width = (BaseAppBrandRecentView.this.getResources().getDisplayMetrics().widthPixels / 4);
      this.lZa = ((ImageView)paramView.findViewById(2131300874));
      this.mYh = ((ImageView)paramView.findViewById(2131300884));
      this.noe = ((RelativeLayout)paramView.findViewById(2131300892));
      this.titleTv = ((TextView)paramView.findViewById(2131305902));
      this.mYj = ((TextView)paramView.findViewById(2131305706));
      this.mYl = ((ImageView)paramView.findViewById(2131300952));
      AppMethodBeat.o(49972);
    }
  }
  
  final class c
    extends com.tencent.e.i.b
  {
    List<a> mHf;
    List<a> noh;
    boolean noi;
    
    public c()
    {
      AppMethodBeat.i(49974);
      this.noi = true;
      this.noi = true;
      this.mHf = new ArrayList();
      this.noh = new ArrayList();
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
            ??? = BaseAppBrandRecentView.g(BaseAppBrandRecentView.this).wh(BaseAppBrandRecentView.this.getLoadCount());
          }
          this.mHf.clear();
          this.noh.clear();
          if (??? == null) {
            break;
          }
          if (BaseAppBrandRecentView.this.getSceneFactory() != null)
          {
            LocalUsageInfo localLocalUsageInfo1 = BaseAppBrandRecentView.this.getSceneFactory().buY();
            ??? = ((List)???).iterator();
            if (!((Iterator)???).hasNext()) {
              break;
            }
            LocalUsageInfo localLocalUsageInfo2 = (LocalUsageInfo)((Iterator)???).next();
            if ((localLocalUsageInfo1 != null) && (localLocalUsageInfo2.username.equals(localLocalUsageInfo1.username)) && (localLocalUsageInfo2.hQh == localLocalUsageInfo1.hQh)) {
              continue;
            }
            if (this.mHf.size() < BaseAppBrandRecentView.this.getShowCount()) {
              this.mHf.add(new a(localLocalUsageInfo2));
            }
            if (BaseAppBrandRecentView.h(BaseAppBrandRecentView.this)) {
              this.noh.add(new a(localLocalUsageInfo2));
            }
            ad.d("MicroMsg.BaseAppBrandRecentView", "alvinluo info %s, %s, %s, %s, %s, %d, mType: %s", new Object[] { localLocalUsageInfo2.username, localLocalUsageInfo2.nickname, localLocalUsageInfo2.cmD, localLocalUsageInfo2.jPZ, localLocalUsageInfo2.appId, Integer.valueOf(localLocalUsageInfo2.hQh), BaseAppBrandRecentView.this.mZx });
          }
        }
        Object localObject3 = null;
      }
      BaseAppBrandRecentView.this.bI(this.mHf);
      ad.i("MicroMsg.BaseAppBrandRecentView", "[UpdateAppBrandRecentDataTask] type:%s preview size:%s, data size: %d, mType: %s", new Object[] { BaseAppBrandRecentView.this.getType(), Integer.valueOf(BaseAppBrandRecentView.b(BaseAppBrandRecentView.this).size()), Integer.valueOf(BaseAppBrandRecentView.i(BaseAppBrandRecentView.this).size()), BaseAppBrandRecentView.this.mZx });
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(49973);
          BaseAppBrandRecentView.b(BaseAppBrandRecentView.this).clear();
          BaseAppBrandRecentView.i(BaseAppBrandRecentView.this).clear();
          BaseAppBrandRecentView.b(BaseAppBrandRecentView.this).addAll(BaseAppBrandRecentView.c.this.mHf);
          BaseAppBrandRecentView.i(BaseAppBrandRecentView.this).addAll(BaseAppBrandRecentView.c.this.noh);
          BaseAppBrandRecentView.c.this.mHf.clear();
          BaseAppBrandRecentView.c.this.noh.clear();
          if ((BaseAppBrandRecentView.this.getRefreshListener() != null) && (BaseAppBrandRecentView.c.this.noi)) {
            BaseAppBrandRecentView.this.getRefreshListener().uP(BaseAppBrandRecentView.b(BaseAppBrandRecentView.this).size());
          }
          if (BaseAppBrandRecentView.c.this.noi)
          {
            ad.i("MicroMsg.BaseAppBrandRecentView", "alvinluo refresh done dispatch diffResult, mType: %s", new Object[] { BaseAppBrandRecentView.this.mZx });
            ??? = AppBrandRecentView.f.nmT;
            BaseAppBrandRecentView.this.getAdapter().asY.notifyChanged();
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