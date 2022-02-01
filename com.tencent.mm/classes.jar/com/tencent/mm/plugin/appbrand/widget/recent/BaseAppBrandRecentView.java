package com.tencent.mm.plugin.appbrand.widget.recent;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.af;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.plugin.appbrand.ba.d;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class BaseAppBrandRecentView
  extends AppBrandRecentView
  implements MStorage.IOnStorageChange
{
  private Context mContext;
  protected int mViewWidth = 0;
  protected float uQa;
  private AppBrandRecentView.a uQb;
  private List<e> uQc = new ArrayList();
  private c uQd;
  private a uQe;
  n uQf = null;
  private boolean uQg = false;
  private List<e> uQh = new ArrayList();
  protected AppBrandRecentView.e uQi;
  private AppBrandRecentView.c uQj = null;
  private final Object uQk = new Object();
  private boolean uQl = false;
  private MMHandler uQm = null;
  private ConcurrentLinkedQueue<c> uQn = new ConcurrentLinkedQueue();
  private AppBrandRecentView.b uQo = new AppBrandRecentView.b()
  {
    public final List<LocalUsageInfo> EJ(int paramAnonymousInt)
    {
      AppMethodBeat.i(323998);
      List localList = ((ag)com.tencent.mm.kernel.h.ax(ag.class)).zu(paramAnonymousInt);
      AppMethodBeat.o(323998);
      return localList;
    }
  };
  private float uQp = 1.0F;
  private boolean uQq = false;
  private float wT;
  private float wU;
  
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
  
  private static String ahk(String paramString)
  {
    if (paramString != null) {
      try
      {
        if (com.tencent.mm.ui.tools.g.bCx(paramString) <= 11) {
          return paramString;
        }
        Object localObject = paramString.toCharArray();
        int m = localObject.length;
        int j = 0;
        int i = 0;
        int k = 0;
        while (j < m)
        {
          k += com.tencent.mm.ui.tools.g.bCx(String.valueOf(localObject[j]));
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
  
  public void a(b paramb, e parame, int paramInt)
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
    if (paramInt == this.uQe.getItemCount() - 1)
    {
      double d = j;
      i = (int)((1.0D - (Math.ceil(f) - f)) * d);
      Log.i("MicroMsg.BaseAppBrandRecentView", "alvinluo lastPosition %d set width %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    }
    paramb.caK.getLayoutParams().width = i;
    paramb.caK.setScaleX(1.0F);
    paramb.caK.setScaleY(1.0F);
    Log.d("MicroMsg.BaseAppBrandRecentView", "alvinluo onBindCustomViewHolder postion: %d, width: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    if ((parame != null) && (parame.type == 1) && (parame.uAl != null))
    {
      if (Util.isNullOrNil(parame.uAl.epy)) {
        break label282;
      }
      paramb.titleTv.setText(ahk(parame.uAl.epy));
      paramb.titleTv.setVisibility(0);
    }
    for (;;)
    {
      paramb.uAt.setVisibility(0);
      if (Util.isNullOrNil(parame.uAl.qQb)) {
        break;
      }
      com.tencent.mm.modelappbrand.a.b.bEY().a(paramb.ttT, parame.uAl.qQb, com.tencent.mm.modelappbrand.a.a.bEX(), com.tencent.mm.modelappbrand.a.g.org);
      return;
      label282:
      if (!Util.isNullOrNil(parame.uAl.nickname))
      {
        String str = ahk(parame.uAl.nickname);
        paramb.titleTv.setText(str);
        paramb.titleTv.setVisibility(0);
      }
      else if (!Util.isNullOrNil(parame.uAl.username))
      {
        paramb.titleTv.setText(parame.uAl.username);
        paramb.titleTv.setVisibility(0);
      }
      else
      {
        Log.w("MicroMsg.BaseAppBrandRecentView", "[onBindCustomViewHolder] nickname is null! username:%s appId:%s", new Object[] { parame.uAl.username, parame.uAl.appId });
        paramb.titleTv.setText("");
        paramb.titleTv.setVisibility(4);
      }
    }
    paramb.ttT.setImageDrawable(com.tencent.mm.modelappbrand.a.a.bEX());
  }
  
  public final void bDL()
  {
    if (this.uQm == null) {
      this.uQm = new MMHandler("UpdateAppBrandList_" + this.uQi);
    }
    synchronized (this.uQk)
    {
      if (this.uQl)
      {
        Log.i("MicroMsg.BaseAppBrandRecentView", "alvinluo refresh is running and delay mType: %s", new Object[] { this.uQi });
        if (this.uQn.size() <= 0)
        {
          Log.i("MicroMsg.BaseAppBrandRecentView", "alvinluo refresh add updateTask");
          this.uQn.add(new c());
        }
        return;
      }
      this.uQl = true;
      this.uQm.postToWorker(new c());
    }
  }
  
  public final boolean bs(int paramInt1, int paramInt2)
  {
    n localn = this.uQf;
    localn.am(localn.EK(localn.biT + paramInt1), false);
    return super.bs(paramInt1, paramInt2);
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    return true;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.wT = paramMotionEvent.getRawX();
      this.wU = paramMotionEvent.getRawY();
    }
    while ((paramMotionEvent.getAction() != 2) || (!this.uQq))
    {
      if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)) {
        this.uQq = false;
      }
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    return true;
  }
  
  public RecyclerView.a getAdapter()
  {
    return this.uQe;
  }
  
  protected int getCompletelyCountPerPage()
  {
    return 4;
  }
  
  public int getCount()
  {
    return this.uQc.size();
  }
  
  public int getCurrentPage()
  {
    if (this.uQf != null) {
      return this.uQf.uQL;
    }
    return 0;
  }
  
  public int getCustomItemCount()
  {
    return 0;
  }
  
  public int getDataCount()
  {
    if (this.uQc != null) {
      return this.uQc.size();
    }
    return 0;
  }
  
  public int getItemWidth()
  {
    return 0;
  }
  
  public abstract int getLayoutId();
  
  protected abstract int getLoadCount();
  
  protected AppBrandRecentView.c getOnDataChangedListener()
  {
    return this.uQj;
  }
  
  public AppBrandRecentView.a getOnItemClickListener()
  {
    return this.uQb;
  }
  
  public List<e> getPreviewItemList()
  {
    if (this.uQc == null) {
      this.uQc = new ArrayList();
    }
    return this.uQc;
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
    this.uQa = paramContext.getResources().getDimension(ba.d.DialogAvatarLinePadding);
    paramContext = new LinearLayoutManager()
    {
      public final boolean supportsPredictiveItemAnimations()
      {
        return false;
      }
    };
    paramContext.setOrientation(0);
    setLayoutManager(paramContext);
    setHasFixedSize(true);
    paramContext = new a((byte)0);
    this.uQe = paramContext;
    setAdapter(paramContext);
    this.uQf = new n(getCustomItemCount());
    paramContext = this.uQf;
    Context localContext = getContext();
    int i = getCompletelyCountPerPage();
    paramContext.mContext = localContext;
    paramContext.uQH = this;
    paramContext.uQM = i;
    paramContext.uQH.b(paramContext);
    paramContext.uQH.a(paramContext);
    paramContext.uQP = ((LinearLayoutManager)paramContext.uQH.getLayoutManager());
    paramContext.mSmoothScroller = new n.1(paramContext, paramContext.uQH.getContext());
    paramContext.uQK = new n.2(paramContext, paramContext.uQH.getContext());
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.mViewWidth = getMeasuredWidth();
    Log.d("MicroMsg.BaseAppBrandRecentView", "alvinluo onMeasure mViewWidth %d", new Object[] { Integer.valueOf(this.mViewWidth) });
  }
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    Log.i("MicroMsg.BaseAppBrandRecentView", "[onNotifyChange] process:%s eventId:%s, mType: %s", new Object[] { ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).toString(), Integer.valueOf(paramMStorageEventData.eventId), this.uQi });
    bDL();
  }
  
  public final void release()
  {
    if (this.uQi == AppBrandRecentView.e.uPT) {
      if (com.tencent.mm.kernel.h.ax(af.class) != null) {
        ((af)com.tencent.mm.kernel.h.ax(af.class)).remove(this);
      }
    }
    for (;;)
    {
      if (this.uQd != null) {
        this.uQd.cancel();
      }
      this.uQc.clear();
      if (this.uQm != null) {
        this.uQm.quit();
      }
      return;
      if ((this.uQi == AppBrandRecentView.e.uPS) && (com.tencent.mm.kernel.h.ax(ag.class) != null)) {
        ((ag)com.tencent.mm.kernel.h.ax(ag.class)).remove(this);
      }
    }
  }
  
  public void setDataQuery(AppBrandRecentView.b paramb)
  {
    this.uQo = paramb;
  }
  
  public void setEnableDataCache(boolean paramBoolean)
  {
    this.uQg = paramBoolean;
  }
  
  public void setOnDataChangedListener(AppBrandRecentView.c paramc)
  {
    this.uQj = paramc;
  }
  
  public void setOnItemClickListener(AppBrandRecentView.a parama)
  {
    this.uQb = parama;
  }
  
  public void setOnScrollPageListener(n.a parama)
  {
    if (this.uQf != null) {
      this.uQf.uQS = parama;
    }
  }
  
  public void setType(AppBrandRecentView.e parame)
  {
    this.uQi = parame;
    if (this.uQi == AppBrandRecentView.e.uPT) {
      if (com.tencent.mm.kernel.h.ax(af.class) != null) {
        ((af)com.tencent.mm.kernel.h.ax(af.class)).add(this);
      }
    }
    while ((this.uQi != AppBrandRecentView.e.uPS) || (com.tencent.mm.kernel.h.ax(ag.class) == null)) {
      return;
    }
    ((ag)com.tencent.mm.kernel.h.ax(ag.class)).add(this);
  }
  
  protected final class a
    extends RecyclerView.a<BaseAppBrandRecentView.b>
  {
    c.a uQs;
    
    private a()
    {
      AppMethodBeat.i(324064);
      this.uQs = new c.a();
      this.uQs.oKB = ba.h.default_avatar;
      AppMethodBeat.o(324064);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(324076);
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
          AppMethodBeat.o(324076);
          return i + j;
        }
      }
      i = j;
      if (j % k != 0) {
        i = j + (k - j % k);
      }
      AppMethodBeat.o(324076);
      return i;
    }
  }
  
  public final class b
    extends RecyclerView.v
  {
    public View caK;
    public TextView titleTv;
    public ImageView ttT;
    public ImageView uAt;
    public TextView uAv;
    public ImageView uAx;
    public RelativeLayout uQt;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(324062);
      this.caK = paramView;
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(324001);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/widget/recent/BaseAppBrandRecentView$RecentViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          localObject = (e)paramAnonymousView.getTag();
          ((e)localObject).position = BaseAppBrandRecentView.b.this.KJ();
          if (BaseAppBrandRecentView.this.getOnItemClickListener() != null) {
            BaseAppBrandRecentView.this.getOnItemClickListener().a(paramAnonymousView, (e)localObject, BaseAppBrandRecentView.c(BaseAppBrandRecentView.this), BaseAppBrandRecentView.d(BaseAppBrandRecentView.this));
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/recent/BaseAppBrandRecentView$RecentViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(324001);
        }
      });
      paramView.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(324003);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/widget/recent/BaseAppBrandRecentView$RecentViewHolder$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          localObject = (e)paramAnonymousView.getTag();
          ((e)localObject).position = BaseAppBrandRecentView.b.this.KJ();
          if (BaseAppBrandRecentView.this.getOnItemClickListener() != null) {
            BaseAppBrandRecentView.this.getOnItemClickListener().b(paramAnonymousView, (e)localObject, BaseAppBrandRecentView.c(BaseAppBrandRecentView.this), BaseAppBrandRecentView.d(BaseAppBrandRecentView.this));
          }
          BaseAppBrandRecentView.e(BaseAppBrandRecentView.this);
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/appbrand/widget/recent/BaseAppBrandRecentView$RecentViewHolder$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(324003);
          return true;
        }
      });
      paramView.getLayoutParams().width = (BaseAppBrandRecentView.this.getResources().getDisplayMetrics().widthPixels / 4);
      this.ttT = ((ImageView)paramView.findViewById(ba.f.icon));
      this.uAt = ((ImageView)paramView.findViewById(ba.f.icon_bg));
      this.uQt = ((RelativeLayout)paramView.findViewById(ba.f.icon_layout));
      this.titleTv = ((TextView)paramView.findViewById(ba.f.title));
      this.uAv = ((TextView)paramView.findViewById(ba.f.test_mask));
      this.uAx = ((ImageView)paramView.findViewById(ba.f.image_mask));
      AppMethodBeat.o(324062);
    }
  }
  
  final class c
    extends com.tencent.threadpool.i.b
  {
    private List<e> eXW;
    private List<e> uQw;
    boolean uQx;
    
    public c()
    {
      AppMethodBeat.i(324057);
      this.uQx = true;
      this.uQx = true;
      this.eXW = new ArrayList();
      this.uQw = new ArrayList();
      AppMethodBeat.o(324057);
    }
    
    public final String getKey()
    {
      return "MicroMsg.BaseAppBrandRecentView";
    }
    
    public final void run()
    {
      AppMethodBeat.i(324078);
      Object localObject3;
      synchronized (BaseAppBrandRecentView.f(BaseAppBrandRecentView.this))
      {
        BaseAppBrandRecentView.a(BaseAppBrandRecentView.this, true);
        ??? = null;
        if (BaseAppBrandRecentView.g(BaseAppBrandRecentView.this) != null) {
          ??? = BaseAppBrandRecentView.g(BaseAppBrandRecentView.this).EJ(BaseAppBrandRecentView.this.getLoadCount());
        }
        this.eXW.clear();
        this.uQw.clear();
        if (??? != null) {
          if (BaseAppBrandRecentView.this.getSceneFactory() != null)
          {
            LocalUsageInfo localLocalUsageInfo1 = BaseAppBrandRecentView.this.getSceneFactory().cFo();
            ??? = ((List)???).iterator();
            while (((Iterator)???).hasNext())
            {
              LocalUsageInfo localLocalUsageInfo2 = (LocalUsageInfo)((Iterator)???).next();
              if ((localLocalUsageInfo1 == null) || (!localLocalUsageInfo2.username.equals(localLocalUsageInfo1.username)) || (localLocalUsageInfo2.euz != localLocalUsageInfo1.euz))
              {
                if (this.eXW.size() < BaseAppBrandRecentView.this.getShowCount()) {
                  this.eXW.add(new e(localLocalUsageInfo2));
                }
                if (BaseAppBrandRecentView.h(BaseAppBrandRecentView.this)) {
                  this.uQw.add(new e(localLocalUsageInfo2));
                }
                Log.d("MicroMsg.BaseAppBrandRecentView", "alvinluo info %s, %s, %s, %s, %s, %d, mType: %s", new Object[] { localLocalUsageInfo2.username, localLocalUsageInfo2.nickname, localLocalUsageInfo2.epy, localLocalUsageInfo2.qQb, localLocalUsageInfo2.appId, Integer.valueOf(localLocalUsageInfo2.euz), BaseAppBrandRecentView.this.uQi });
              }
            }
          }
        }
      }
      Log.i("MicroMsg.BaseAppBrandRecentView", "[UpdateAppBrandRecentDataTask] type:%s preview size:%s, data size: %d, mType: %s", new Object[] { BaseAppBrandRecentView.this.getType(), Integer.valueOf(BaseAppBrandRecentView.b(BaseAppBrandRecentView.this).size()), Integer.valueOf(BaseAppBrandRecentView.i(BaseAppBrandRecentView.this).size()), BaseAppBrandRecentView.this.uQi });
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(324030);
          BaseAppBrandRecentView.b(BaseAppBrandRecentView.this).clear();
          BaseAppBrandRecentView.i(BaseAppBrandRecentView.this).clear();
          BaseAppBrandRecentView.b(BaseAppBrandRecentView.this).addAll(BaseAppBrandRecentView.c.a(BaseAppBrandRecentView.c.this));
          BaseAppBrandRecentView.i(BaseAppBrandRecentView.this).addAll(BaseAppBrandRecentView.c.b(BaseAppBrandRecentView.c.this));
          BaseAppBrandRecentView.c.a(BaseAppBrandRecentView.c.this).clear();
          BaseAppBrandRecentView.c.b(BaseAppBrandRecentView.c.this).clear();
          if ((BaseAppBrandRecentView.this.getRefreshListener() != null) && (BaseAppBrandRecentView.c.this.uQx))
          {
            ??? = BaseAppBrandRecentView.this.getRefreshListener();
            BaseAppBrandRecentView.b(BaseAppBrandRecentView.this).size();
            ((AppBrandRecentView.d)???).cFn();
          }
          if (BaseAppBrandRecentView.c.this.uQx)
          {
            Log.i("MicroMsg.BaseAppBrandRecentView", "alvinluo refresh done dispatch diffResult, mType: %s", new Object[] { BaseAppBrandRecentView.this.uQi });
            ??? = AppBrandRecentView.e.uPS;
            BaseAppBrandRecentView.this.getAdapter().bZE.notifyChanged();
          }
          synchronized (BaseAppBrandRecentView.f(BaseAppBrandRecentView.this))
          {
            BaseAppBrandRecentView.a(BaseAppBrandRecentView.this, false);
            BaseAppBrandRecentView.j(BaseAppBrandRecentView.this);
            AppMethodBeat.o(324030);
            return;
          }
        }
      });
      AppMethodBeat.o(324078);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recent.BaseAppBrandRecentView
 * JD-Core Version:    0.7.0.1
 */