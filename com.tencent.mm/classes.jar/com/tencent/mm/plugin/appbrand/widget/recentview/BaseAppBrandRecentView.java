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
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.d;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.ah;
import com.tencent.mm.plugin.appbrand.appusage.ai;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
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
  List<a> ndS = new ArrayList();
  protected AppBrandRecentView.f neF;
  protected float nsX;
  private AppBrandRecentView.b nsY;
  public List<a> nsZ = new ArrayList();
  private c nta;
  private a ntb;
  public e ntc = null;
  boolean ntd = false;
  private AppBrandRecentView.d nte = null;
  private final Object ntf = new Object();
  private boolean ntg = false;
  private aq nth = null;
  private ConcurrentLinkedQueue<c> nti = new ConcurrentLinkedQueue();
  private AppBrandRecentView.c ntj = new AppBrandRecentView.c()
  {
    public final List<LocalUsageInfo> wm(int paramAnonymousInt)
    {
      AppMethodBeat.i(49965);
      List localList = ((ai)com.tencent.mm.kernel.g.ab(ai.class)).sb(paramAnonymousInt);
      AppMethodBeat.o(49965);
      return localList;
    }
  };
  private float ntk = 1.0F;
  private boolean ntl = false;
  
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
  
  private static String Wq(String paramString)
  {
    if (paramString != null) {
      try
      {
        if (f.aYK(paramString) <= 11) {
          return paramString;
        }
        Object localObject = paramString.toCharArray();
        int m = localObject.length;
        int j = 0;
        int i = 0;
        int k = 0;
        while (j < m)
        {
          k += f.aYK(String.valueOf(localObject[j]));
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
    if (paramInt == this.ntb.getItemCount() - 1)
    {
      double d = j;
      i = (int)((1.0D - (Math.ceil(f) - f)) * d);
      ae.i("MicroMsg.BaseAppBrandRecentView", "alvinluo lastPosition %d set width %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    }
    paramb.auu.getLayoutParams().width = i;
    paramb.auu.setScaleX(1.0F);
    paramb.auu.setScaleY(1.0F);
    ae.d("MicroMsg.BaseAppBrandRecentView", "alvinluo onBindCustomViewHolder postion: %d, width: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    if ((parama != null) && (parama.type == 1) && (parama.ndd != null))
    {
      if (bu.isNullOrNil(parama.ndd.cmF)) {
        break label282;
      }
      paramb.titleTv.setText(Wq(parama.ndd.cmF));
      paramb.titleTv.setVisibility(0);
    }
    for (;;)
    {
      paramb.ndo.setVisibility(0);
      if (bu.isNullOrNil(parama.ndd.jTr)) {
        break;
      }
      com.tencent.mm.modelappbrand.a.b.aEl().a(paramb.mdt, parama.ndd.jTr, com.tencent.mm.modelappbrand.a.a.aEk(), com.tencent.mm.modelappbrand.a.g.hOv);
      return;
      label282:
      if (!bu.isNullOrNil(parama.ndd.nickname))
      {
        String str = Wq(parama.ndd.nickname);
        paramb.titleTv.setText(str);
        paramb.titleTv.setVisibility(0);
      }
      else if (!bu.isNullOrNil(parama.ndd.username))
      {
        paramb.titleTv.setText(parama.ndd.username);
        paramb.titleTv.setVisibility(0);
      }
      else
      {
        ae.w("MicroMsg.BaseAppBrandRecentView", "[onBindCustomViewHolder] nickname is null! username:%s appId:%s", new Object[] { parama.ndd.username, parama.ndd.appId });
        paramb.titleTv.setText("");
        paramb.titleTv.setVisibility(4);
      }
    }
    paramb.mdt.setImageDrawable(com.tencent.mm.modelappbrand.a.a.aEk());
  }
  
  public void a(String paramString, m paramm)
  {
    ae.i("MicroMsg.BaseAppBrandRecentView", "[onNotifyChange] process:%s eventId:%s, mType: %s", new Object[] { ((h)com.tencent.mm.kernel.g.ajO().ajq()).toString(), Integer.valueOf(paramm.duP), this.neF });
    if ((paramm.duP == 5) && (bGy()))
    {
      ae.i("MicroMsg.BaseAppBrandRecentView", "[onNotifyChange] Ignore!!!");
      return;
    }
    refresh();
  }
  
  public final boolean aj(int paramInt1, int paramInt2)
  {
    e locale = this.ntc;
    locale.P(locale.wW(locale.mOffsetX + paramInt1), false);
    return super.aj(paramInt1, paramInt2);
  }
  
  protected boolean bGy()
  {
    return false;
  }
  
  public void bK(List<a> paramList) {}
  
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
    while ((paramMotionEvent.getAction() != 2) || (!this.ntl))
    {
      if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)) {
        this.ntl = false;
      }
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    return true;
  }
  
  public RecyclerView.a getAdapter()
  {
    return this.ntb;
  }
  
  protected int getCompletelyCountPerPage()
  {
    return 4;
  }
  
  public int getCount()
  {
    return this.nsZ.size();
  }
  
  public int getCurrentPage()
  {
    if (this.ntc != null) {
      return this.ntc.nnp;
    }
    return 0;
  }
  
  public int getCustomItemCount()
  {
    return 0;
  }
  
  public int getDataCount()
  {
    if (this.nsZ != null) {
      return this.nsZ.size();
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
    return this.nte;
  }
  
  public AppBrandRecentView.b getOnItemClickListener()
  {
    return this.nsY;
  }
  
  public List<a> getPreviewItemList()
  {
    if (this.nsZ == null) {
      this.nsZ = new ArrayList();
    }
    return this.nsZ;
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
    this.nsX = paramContext.getResources().getDimension(2131165258);
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
    this.ntb = paramContext;
    setAdapter(paramContext);
    this.ntc = new e(getCustomItemCount());
    paramContext = this.ntc;
    Context localContext = getContext();
    int i = getCompletelyCountPerPage();
    paramContext.mContext = localContext;
    paramContext.ntK = this;
    paramContext.ntO = i;
    paramContext.ntK.b(paramContext);
    paramContext.ntK.a(paramContext);
    paramContext.ntR = ((LinearLayoutManager)paramContext.ntK.getLayoutManager());
    paramContext.atl = new e.1(paramContext, paramContext.ntK.getContext());
    paramContext.ntN = new e.2(paramContext, paramContext.ntK.getContext());
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.aYS = getMeasuredWidth();
    ae.d("MicroMsg.BaseAppBrandRecentView", "alvinluo onMeasure mViewWidth %d", new Object[] { Integer.valueOf(this.aYS) });
  }
  
  public final void refresh()
  {
    if (this.nth == null) {
      this.nth = new aq("UpdateAppBrandList_" + this.neF);
    }
    synchronized (this.ntf)
    {
      if (this.ntg)
      {
        ae.i("MicroMsg.BaseAppBrandRecentView", "alvinluo refresh is running and delay mType: %s", new Object[] { this.neF });
        if (this.nti.size() <= 0)
        {
          ae.i("MicroMsg.BaseAppBrandRecentView", "alvinluo refresh add updateTask");
          this.nti.add(new c());
        }
        return;
      }
      this.ntg = true;
      this.nth.postToWorker(new c());
    }
  }
  
  public final void release()
  {
    if (this.neF == AppBrandRecentView.f.nse) {
      if (com.tencent.mm.kernel.g.ab(ah.class) != null) {
        ((ah)com.tencent.mm.kernel.g.ab(ah.class)).remove(this);
      }
    }
    for (;;)
    {
      if (this.nta != null) {
        this.nta.cancel();
      }
      this.nsZ.clear();
      if (this.nth != null) {
        this.nth.quit();
      }
      return;
      if ((this.neF == AppBrandRecentView.f.nsd) && (com.tencent.mm.kernel.g.ab(ai.class) != null)) {
        ((ai)com.tencent.mm.kernel.g.ab(ai.class)).remove(this);
      }
    }
  }
  
  public void setDataQuery(AppBrandRecentView.c paramc)
  {
    this.ntj = paramc;
  }
  
  public void setEnableDataCache(boolean paramBoolean)
  {
    this.ntd = paramBoolean;
  }
  
  public void setOnDataChangedListener(AppBrandRecentView.d paramd)
  {
    this.nte = paramd;
  }
  
  public void setOnItemClickListener(AppBrandRecentView.b paramb)
  {
    this.nsY = paramb;
  }
  
  public void setOnScrollPageListener(e.a parama)
  {
    if (this.ntc != null) {
      this.ntc.ntT = parama;
    }
  }
  
  public void setType(AppBrandRecentView.f paramf)
  {
    this.neF = paramf;
    if (this.neF == AppBrandRecentView.f.nse) {
      if (com.tencent.mm.kernel.g.ab(ah.class) != null) {
        ((ah)com.tencent.mm.kernel.g.ab(ah.class)).add(this);
      }
    }
    while ((this.neF != AppBrandRecentView.f.nsd) || (com.tencent.mm.kernel.g.ab(ai.class) == null)) {
      return;
    }
    ((ai)com.tencent.mm.kernel.g.ab(ai.class)).add(this);
  }
  
  protected void wU(int paramInt)
  {
    if ((this.ntd) && (paramInt - 1 < this.ndS.size())) {
      this.ndS.remove(paramInt - 1);
    }
  }
  
  protected final class a
    extends RecyclerView.a<BaseAppBrandRecentView.b>
  {
    c.a ntn;
    
    private a()
    {
      AppMethodBeat.i(49966);
      this.ntn = new c.a();
      this.ntn.igv = 2131690013;
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
    public ImageView mdt;
    public ImageView ndo;
    public TextView ndq;
    public ImageView nds;
    public RelativeLayout nto;
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
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/recentview/BaseAppBrandRecentView$RecentViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
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
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/recentview/BaseAppBrandRecentView$RecentViewHolder$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
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
      this.mdt = ((ImageView)paramView.findViewById(2131300874));
      this.ndo = ((ImageView)paramView.findViewById(2131300884));
      this.nto = ((RelativeLayout)paramView.findViewById(2131300892));
      this.titleTv = ((TextView)paramView.findViewById(2131305902));
      this.ndq = ((TextView)paramView.findViewById(2131305706));
      this.nds = ((ImageView)paramView.findViewById(2131300952));
      AppMethodBeat.o(49972);
    }
  }
  
  final class c
    extends com.tencent.e.i.b
  {
    List<a> mMj;
    List<a> ntr;
    boolean nts;
    
    public c()
    {
      AppMethodBeat.i(49974);
      this.nts = true;
      this.nts = true;
      this.mMj = new ArrayList();
      this.ntr = new ArrayList();
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
            ??? = BaseAppBrandRecentView.g(BaseAppBrandRecentView.this).wm(BaseAppBrandRecentView.this.getLoadCount());
          }
          this.mMj.clear();
          this.ntr.clear();
          if (??? == null) {
            break;
          }
          if (BaseAppBrandRecentView.this.getSceneFactory() != null)
          {
            LocalUsageInfo localLocalUsageInfo1 = BaseAppBrandRecentView.this.getSceneFactory().bvJ();
            ??? = ((List)???).iterator();
            if (!((Iterator)???).hasNext()) {
              break;
            }
            LocalUsageInfo localLocalUsageInfo2 = (LocalUsageInfo)((Iterator)???).next();
            if ((localLocalUsageInfo1 != null) && (localLocalUsageInfo2.username.equals(localLocalUsageInfo1.username)) && (localLocalUsageInfo2.hSZ == localLocalUsageInfo1.hSZ)) {
              continue;
            }
            if (this.mMj.size() < BaseAppBrandRecentView.this.getShowCount()) {
              this.mMj.add(new a(localLocalUsageInfo2));
            }
            if (BaseAppBrandRecentView.h(BaseAppBrandRecentView.this)) {
              this.ntr.add(new a(localLocalUsageInfo2));
            }
            ae.d("MicroMsg.BaseAppBrandRecentView", "alvinluo info %s, %s, %s, %s, %s, %d, mType: %s", new Object[] { localLocalUsageInfo2.username, localLocalUsageInfo2.nickname, localLocalUsageInfo2.cmF, localLocalUsageInfo2.jTr, localLocalUsageInfo2.appId, Integer.valueOf(localLocalUsageInfo2.hSZ), BaseAppBrandRecentView.this.neF });
          }
        }
        Object localObject3 = null;
      }
      BaseAppBrandRecentView.this.bK(this.mMj);
      ae.i("MicroMsg.BaseAppBrandRecentView", "[UpdateAppBrandRecentDataTask] type:%s preview size:%s, data size: %d, mType: %s", new Object[] { BaseAppBrandRecentView.this.getType(), Integer.valueOf(BaseAppBrandRecentView.b(BaseAppBrandRecentView.this).size()), Integer.valueOf(BaseAppBrandRecentView.i(BaseAppBrandRecentView.this).size()), BaseAppBrandRecentView.this.neF });
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(49973);
          BaseAppBrandRecentView.b(BaseAppBrandRecentView.this).clear();
          BaseAppBrandRecentView.i(BaseAppBrandRecentView.this).clear();
          BaseAppBrandRecentView.b(BaseAppBrandRecentView.this).addAll(BaseAppBrandRecentView.c.this.mMj);
          BaseAppBrandRecentView.i(BaseAppBrandRecentView.this).addAll(BaseAppBrandRecentView.c.this.ntr);
          BaseAppBrandRecentView.c.this.mMj.clear();
          BaseAppBrandRecentView.c.this.ntr.clear();
          if ((BaseAppBrandRecentView.this.getRefreshListener() != null) && (BaseAppBrandRecentView.c.this.nts)) {
            BaseAppBrandRecentView.this.getRefreshListener().uT(BaseAppBrandRecentView.b(BaseAppBrandRecentView.this).size());
          }
          if (BaseAppBrandRecentView.c.this.nts)
          {
            ae.i("MicroMsg.BaseAppBrandRecentView", "alvinluo refresh done dispatch diffResult, mType: %s", new Object[] { BaseAppBrandRecentView.this.neF });
            ??? = AppBrandRecentView.f.nsd;
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