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
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.plugin.appbrand.appusage.ah;
import com.tencent.mm.plugin.appbrand.au.d;
import com.tencent.mm.plugin.appbrand.au.f;
import com.tencent.mm.plugin.appbrand.au.h;
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
  protected int aIj = 0;
  private Context mContext;
  protected float rEO;
  private AppBrandRecentView.a rEP;
  private List<e> rEQ = new ArrayList();
  private c rER;
  private a rES;
  n rET = null;
  private boolean rEU = false;
  private List<e> rEV = new ArrayList();
  protected AppBrandRecentView.e rEW;
  private AppBrandRecentView.c rEX = null;
  private final Object rEY = new Object();
  private boolean rEZ = false;
  private MMHandler rFa = null;
  private ConcurrentLinkedQueue<c> rFb = new ConcurrentLinkedQueue();
  private AppBrandRecentView.b rFc = new AppBrandRecentView.b()
  {
    public final List<LocalUsageInfo> Ej(int paramAnonymousInt)
    {
      AppMethodBeat.i(279165);
      List localList = ((ah)com.tencent.mm.kernel.h.ae(ah.class)).zh(paramAnonymousInt);
      AppMethodBeat.o(279165);
      return localList;
    }
  };
  private float rFd = 1.0F;
  private boolean rFe = false;
  private float vX;
  private float vY;
  
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
  
  private static String anM(String paramString)
  {
    if (paramString != null) {
      try
      {
        if (com.tencent.mm.ui.tools.g.bAB(paramString) <= 11) {
          return paramString;
        }
        Object localObject = paramString.toCharArray();
        int m = localObject.length;
        int j = 0;
        int i = 0;
        int k = 0;
        while (j < m)
        {
          k += com.tencent.mm.ui.tools.g.bAB(String.valueOf(localObject[j]));
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
    if (paramInt == this.rES.getItemCount() - 1)
    {
      double d = j;
      i = (int)((1.0D - (Math.ceil(f) - f)) * d);
      Log.i("MicroMsg.BaseAppBrandRecentView", "alvinluo lastPosition %d set width %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    }
    paramb.amk.getLayoutParams().width = i;
    paramb.amk.setScaleX(1.0F);
    paramb.amk.setScaleY(1.0F);
    Log.d("MicroMsg.BaseAppBrandRecentView", "alvinluo onBindCustomViewHolder postion: %d, width: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    if ((parame != null) && (parame.type == 1) && (parame.rqa != null))
    {
      if (Util.isNullOrNil(parame.rqa.cxg)) {
        break label282;
      }
      paramb.titleTv.setText(anM(parame.rqa.cxg));
      paramb.titleTv.setVisibility(0);
    }
    for (;;)
    {
      paramb.rqi.setVisibility(0);
      if (Util.isNullOrNil(parame.rqa.nQm)) {
        break;
      }
      com.tencent.mm.modelappbrand.a.b.bhh().a(paramb.qps, parame.rqa.nQm, com.tencent.mm.modelappbrand.a.a.bhg(), com.tencent.mm.modelappbrand.a.g.lzF);
      return;
      label282:
      if (!Util.isNullOrNil(parame.rqa.nickname))
      {
        String str = anM(parame.rqa.nickname);
        paramb.titleTv.setText(str);
        paramb.titleTv.setVisibility(0);
      }
      else if (!Util.isNullOrNil(parame.rqa.username))
      {
        paramb.titleTv.setText(parame.rqa.username);
        paramb.titleTv.setVisibility(0);
      }
      else
      {
        Log.w("MicroMsg.BaseAppBrandRecentView", "[onBindCustomViewHolder] nickname is null! username:%s appId:%s", new Object[] { parame.rqa.username, parame.rqa.appId });
        paramb.titleTv.setText("");
        paramb.titleTv.setVisibility(4);
      }
    }
    paramb.qps.setImageDrawable(com.tencent.mm.modelappbrand.a.a.bhg());
  }
  
  public final boolean ay(int paramInt1, int paramInt2)
  {
    n localn = this.rET;
    localn.W(localn.Ek(localn.CL + paramInt1), false);
    return super.ay(paramInt1, paramInt2);
  }
  
  public final void bfU()
  {
    if (this.rFa == null) {
      this.rFa = new MMHandler("UpdateAppBrandList_" + this.rEW);
    }
    synchronized (this.rEY)
    {
      if (this.rEZ)
      {
        Log.i("MicroMsg.BaseAppBrandRecentView", "alvinluo refresh is running and delay mType: %s", new Object[] { this.rEW });
        if (this.rFb.size() <= 0)
        {
          Log.i("MicroMsg.BaseAppBrandRecentView", "alvinluo refresh add updateTask");
          this.rFb.add(new c());
        }
        return;
      }
      this.rEZ = true;
      this.rFa.postToWorker(new c());
    }
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    return true;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.vX = paramMotionEvent.getRawX();
      this.vY = paramMotionEvent.getRawY();
    }
    while ((paramMotionEvent.getAction() != 2) || (!this.rFe))
    {
      if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)) {
        this.rFe = false;
      }
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    return true;
  }
  
  public RecyclerView.a getAdapter()
  {
    return this.rES;
  }
  
  protected int getCompletelyCountPerPage()
  {
    return 4;
  }
  
  public int getCount()
  {
    return this.rEQ.size();
  }
  
  public int getCurrentPage()
  {
    if (this.rET != null) {
      return this.rET.rFz;
    }
    return 0;
  }
  
  public int getCustomItemCount()
  {
    return 0;
  }
  
  public int getDataCount()
  {
    if (this.rEQ != null) {
      return this.rEQ.size();
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
    return this.rEX;
  }
  
  public AppBrandRecentView.a getOnItemClickListener()
  {
    return this.rEP;
  }
  
  public List<e> getPreviewItemList()
  {
    if (this.rEQ == null) {
      this.rEQ = new ArrayList();
    }
    return this.rEQ;
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
    this.rEO = paramContext.getResources().getDimension(au.d.DialogAvatarLinePadding);
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
    this.rES = paramContext;
    setAdapter(paramContext);
    this.rET = new n(getCustomItemCount());
    paramContext = this.rET;
    Context localContext = getContext();
    int i = getCompletelyCountPerPage();
    paramContext.mContext = localContext;
    paramContext.rFv = this;
    paramContext.rFA = i;
    paramContext.rFv.b(paramContext);
    paramContext.rFv.a(paramContext);
    paramContext.rFD = ((LinearLayoutManager)paramContext.rFv.getLayoutManager());
    paramContext.mSmoothScroller = new n.1(paramContext, paramContext.rFv.getContext());
    paramContext.rFy = new n.2(paramContext, paramContext.rFv.getContext());
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.aIj = getMeasuredWidth();
    Log.d("MicroMsg.BaseAppBrandRecentView", "alvinluo onMeasure mViewWidth %d", new Object[] { Integer.valueOf(this.aIj) });
  }
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    Log.i("MicroMsg.BaseAppBrandRecentView", "[onNotifyChange] process:%s eventId:%s, mType: %s", new Object[] { ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).toString(), Integer.valueOf(paramMStorageEventData.eventId), this.rEW });
    bfU();
  }
  
  public final void release()
  {
    if (this.rEW == AppBrandRecentView.e.rEH) {
      if (com.tencent.mm.kernel.h.ae(ag.class) != null) {
        ((ag)com.tencent.mm.kernel.h.ae(ag.class)).remove(this);
      }
    }
    for (;;)
    {
      if (this.rER != null) {
        this.rER.cancel();
      }
      this.rEQ.clear();
      if (this.rFa != null) {
        this.rFa.quit();
      }
      return;
      if ((this.rEW == AppBrandRecentView.e.rEG) && (com.tencent.mm.kernel.h.ae(ah.class) != null)) {
        ((ah)com.tencent.mm.kernel.h.ae(ah.class)).remove(this);
      }
    }
  }
  
  public void setDataQuery(AppBrandRecentView.b paramb)
  {
    this.rFc = paramb;
  }
  
  public void setEnableDataCache(boolean paramBoolean)
  {
    this.rEU = paramBoolean;
  }
  
  public void setOnDataChangedListener(AppBrandRecentView.c paramc)
  {
    this.rEX = paramc;
  }
  
  public void setOnItemClickListener(AppBrandRecentView.a parama)
  {
    this.rEP = parama;
  }
  
  public void setOnScrollPageListener(n.a parama)
  {
    if (this.rET != null) {
      this.rET.rFG = parama;
    }
  }
  
  public void setType(AppBrandRecentView.e parame)
  {
    this.rEW = parame;
    if (this.rEW == AppBrandRecentView.e.rEH) {
      if (com.tencent.mm.kernel.h.ae(ag.class) != null) {
        ((ag)com.tencent.mm.kernel.h.ae(ag.class)).add(this);
      }
    }
    while ((this.rEW != AppBrandRecentView.e.rEG) || (com.tencent.mm.kernel.h.ae(ah.class) == null)) {
      return;
    }
    ((ah)com.tencent.mm.kernel.h.ae(ah.class)).add(this);
  }
  
  protected final class a
    extends RecyclerView.a<BaseAppBrandRecentView.b>
  {
    c.a rFg;
    
    private a()
    {
      AppMethodBeat.i(261134);
      this.rFg = new c.a();
      this.rFg.lRP = au.h.default_avatar;
      AppMethodBeat.o(261134);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(261140);
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
          AppMethodBeat.o(261140);
          return i + j;
        }
      }
      i = j;
      if (j % k != 0) {
        i = j + (k - j % k);
      }
      AppMethodBeat.o(261140);
      return i;
    }
  }
  
  public final class b
    extends RecyclerView.v
  {
    public View amk;
    public ImageView qps;
    public RelativeLayout rFh;
    public ImageView rqi;
    public TextView rqk;
    public ImageView rqm;
    public TextView titleTv;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(276406);
      this.amk = paramView;
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(266609);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/widget/recent/BaseAppBrandRecentView$RecentViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          localObject = (e)paramAnonymousView.getTag();
          ((e)localObject).position = BaseAppBrandRecentView.b.this.md();
          if (BaseAppBrandRecentView.this.getOnItemClickListener() != null) {
            BaseAppBrandRecentView.this.getOnItemClickListener().a(paramAnonymousView, (e)localObject, BaseAppBrandRecentView.c(BaseAppBrandRecentView.this), BaseAppBrandRecentView.d(BaseAppBrandRecentView.this));
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/recent/BaseAppBrandRecentView$RecentViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(266609);
        }
      });
      paramView.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(280740);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/widget/recent/BaseAppBrandRecentView$RecentViewHolder$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          localObject = (e)paramAnonymousView.getTag();
          ((e)localObject).position = BaseAppBrandRecentView.b.this.md();
          if (BaseAppBrandRecentView.this.getOnItemClickListener() != null) {
            BaseAppBrandRecentView.this.getOnItemClickListener().b(paramAnonymousView, (e)localObject, BaseAppBrandRecentView.c(BaseAppBrandRecentView.this), BaseAppBrandRecentView.d(BaseAppBrandRecentView.this));
          }
          BaseAppBrandRecentView.e(BaseAppBrandRecentView.this);
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/appbrand/widget/recent/BaseAppBrandRecentView$RecentViewHolder$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(280740);
          return true;
        }
      });
      paramView.getLayoutParams().width = (BaseAppBrandRecentView.this.getResources().getDisplayMetrics().widthPixels / 4);
      this.qps = ((ImageView)paramView.findViewById(au.f.icon));
      this.rqi = ((ImageView)paramView.findViewById(au.f.icon_bg));
      this.rFh = ((RelativeLayout)paramView.findViewById(au.f.icon_layout));
      this.titleTv = ((TextView)paramView.findViewById(au.f.title));
      this.rqk = ((TextView)paramView.findViewById(au.f.test_mask));
      this.rqm = ((ImageView)paramView.findViewById(au.f.image_mask));
      AppMethodBeat.o(276406);
    }
  }
  
  final class c
    extends com.tencent.e.i.b
  {
    List<e> rFk;
    boolean rFl;
    List<e> rbc;
    
    public c()
    {
      AppMethodBeat.i(274649);
      this.rFl = true;
      this.rFl = true;
      this.rbc = new ArrayList();
      this.rFk = new ArrayList();
      AppMethodBeat.o(274649);
    }
    
    public final String getKey()
    {
      return "MicroMsg.BaseAppBrandRecentView";
    }
    
    public final void run()
    {
      AppMethodBeat.i(274652);
      Object localObject3;
      synchronized (BaseAppBrandRecentView.f(BaseAppBrandRecentView.this))
      {
        BaseAppBrandRecentView.a(BaseAppBrandRecentView.this, true);
        ??? = null;
        if (BaseAppBrandRecentView.g(BaseAppBrandRecentView.this) != null) {
          ??? = BaseAppBrandRecentView.g(BaseAppBrandRecentView.this).Ej(BaseAppBrandRecentView.this.getLoadCount());
        }
        this.rbc.clear();
        this.rFk.clear();
        if (??? != null) {
          if (BaseAppBrandRecentView.this.getSceneFactory() != null)
          {
            LocalUsageInfo localLocalUsageInfo1 = BaseAppBrandRecentView.this.getSceneFactory().ceL();
            ??? = ((List)???).iterator();
            while (((Iterator)???).hasNext())
            {
              LocalUsageInfo localLocalUsageInfo2 = (LocalUsageInfo)((Iterator)???).next();
              if ((localLocalUsageInfo1 == null) || (!localLocalUsageInfo2.username.equals(localLocalUsageInfo1.username)) || (localLocalUsageInfo2.cBU != localLocalUsageInfo1.cBU))
              {
                if (this.rbc.size() < BaseAppBrandRecentView.this.getShowCount()) {
                  this.rbc.add(new e(localLocalUsageInfo2));
                }
                if (BaseAppBrandRecentView.h(BaseAppBrandRecentView.this)) {
                  this.rFk.add(new e(localLocalUsageInfo2));
                }
                Log.d("MicroMsg.BaseAppBrandRecentView", "alvinluo info %s, %s, %s, %s, %s, %d, mType: %s", new Object[] { localLocalUsageInfo2.username, localLocalUsageInfo2.nickname, localLocalUsageInfo2.cxg, localLocalUsageInfo2.nQm, localLocalUsageInfo2.appId, Integer.valueOf(localLocalUsageInfo2.cBU), BaseAppBrandRecentView.this.rEW });
              }
            }
          }
        }
      }
      Log.i("MicroMsg.BaseAppBrandRecentView", "[UpdateAppBrandRecentDataTask] type:%s preview size:%s, data size: %d, mType: %s", new Object[] { BaseAppBrandRecentView.this.getType(), Integer.valueOf(BaseAppBrandRecentView.b(BaseAppBrandRecentView.this).size()), Integer.valueOf(BaseAppBrandRecentView.i(BaseAppBrandRecentView.this).size()), BaseAppBrandRecentView.this.rEW });
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(248511);
          BaseAppBrandRecentView.b(BaseAppBrandRecentView.this).clear();
          BaseAppBrandRecentView.i(BaseAppBrandRecentView.this).clear();
          BaseAppBrandRecentView.b(BaseAppBrandRecentView.this).addAll(BaseAppBrandRecentView.c.this.rbc);
          BaseAppBrandRecentView.i(BaseAppBrandRecentView.this).addAll(BaseAppBrandRecentView.c.this.rFk);
          BaseAppBrandRecentView.c.this.rbc.clear();
          BaseAppBrandRecentView.c.this.rFk.clear();
          if ((BaseAppBrandRecentView.this.getRefreshListener() != null) && (BaseAppBrandRecentView.c.this.rFl))
          {
            ??? = BaseAppBrandRecentView.this.getRefreshListener();
            BaseAppBrandRecentView.b(BaseAppBrandRecentView.this).size();
            ((AppBrandRecentView.d)???).ceK();
          }
          if (BaseAppBrandRecentView.c.this.rFl)
          {
            Log.i("MicroMsg.BaseAppBrandRecentView", "alvinluo refresh done dispatch diffResult, mType: %s", new Object[] { BaseAppBrandRecentView.this.rEW });
            ??? = AppBrandRecentView.e.rEG;
            BaseAppBrandRecentView.this.getAdapter().alc.notifyChanged();
          }
          synchronized (BaseAppBrandRecentView.f(BaseAppBrandRecentView.this))
          {
            BaseAppBrandRecentView.a(BaseAppBrandRecentView.this, false);
            BaseAppBrandRecentView.j(BaseAppBrandRecentView.this);
            AppMethodBeat.o(248511);
            return;
          }
        }
      });
      AppMethodBeat.o(274652);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recent.BaseAppBrandRecentView
 * JD-Core Version:    0.7.0.1
 */