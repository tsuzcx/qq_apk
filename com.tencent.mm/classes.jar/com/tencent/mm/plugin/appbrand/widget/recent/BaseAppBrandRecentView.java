package com.tencent.mm.plugin.appbrand.widget.recent;

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
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.d;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.plugin.appbrand.appusage.ah;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.ui.tools.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class BaseAppBrandRecentView
  extends AppBrandRecentView
  implements MStorage.IOnStorageChange
{
  protected int aYN = 0;
  private float ayd;
  private float aye;
  private Context mContext;
  protected float oCX;
  private AppBrandRecentView.b oCY;
  List<e> oCZ = new ArrayList();
  private c oDa;
  private a oDb;
  p oDc = null;
  boolean oDd = false;
  protected AppBrandRecentView.f oDe;
  private AppBrandRecentView.d oDf = null;
  private final Object oDg = new Object();
  private boolean oDh = false;
  private MMHandler oDi = null;
  private ConcurrentLinkedQueue<c> oDj = new ConcurrentLinkedQueue();
  private AppBrandRecentView.c oDk = new AppBrandRecentView.c()
  {
    public final List<LocalUsageInfo> AC(int paramAnonymousInt)
    {
      AppMethodBeat.i(227795);
      List localList = ((ah)com.tencent.mm.kernel.g.af(ah.class)).vW(paramAnonymousInt);
      AppMethodBeat.o(227795);
      return localList;
    }
  };
  private float oDl = 1.0F;
  private boolean oDm = false;
  List<e> opg = new ArrayList();
  
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
  
  private static String agj(String paramString)
  {
    if (paramString != null) {
      try
      {
        if (f.bnP(paramString) <= 11) {
          return paramString;
        }
        Object localObject = paramString.toCharArray();
        int m = localObject.length;
        int j = 0;
        int i = 0;
        int k = 0;
        while (j < m)
        {
          k += f.bnP(String.valueOf(localObject[j]));
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
  
  protected void AD(int paramInt)
  {
    if ((this.oDd) && (paramInt - 1 < this.opg.size())) {
      this.opg.remove(paramInt - 1);
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
    if (paramInt == this.oDb.getItemCount() - 1)
    {
      double d = j;
      i = (int)((1.0D - (Math.ceil(f) - f)) * d);
      Log.i("MicroMsg.BaseAppBrandRecentView", "alvinluo lastPosition %d set width %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    }
    paramb.aus.getLayoutParams().width = i;
    paramb.aus.setScaleX(1.0F);
    paramb.aus.setScaleY(1.0F);
    Log.d("MicroMsg.BaseAppBrandRecentView", "alvinluo onBindCustomViewHolder postion: %d, width: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    if ((parame != null) && (parame.type == 1) && (parame.ooj != null))
    {
      if (Util.isNullOrNil(parame.ooj.cyB)) {
        break label282;
      }
      paramb.titleTv.setText(agj(parame.ooj.cyB));
      paramb.titleTv.setVisibility(0);
    }
    for (;;)
    {
      paramb.ooB.setVisibility(0);
      if (Util.isNullOrNil(parame.ooj.kVZ)) {
        break;
      }
      com.tencent.mm.modelappbrand.a.b.aXY().a(paramb.nnL, parame.ooj.kVZ, com.tencent.mm.modelappbrand.a.a.aXX(), com.tencent.mm.modelappbrand.a.g.iJB);
      return;
      label282:
      if (!Util.isNullOrNil(parame.ooj.nickname))
      {
        String str = agj(parame.ooj.nickname);
        paramb.titleTv.setText(str);
        paramb.titleTv.setVisibility(0);
      }
      else if (!Util.isNullOrNil(parame.ooj.username))
      {
        paramb.titleTv.setText(parame.ooj.username);
        paramb.titleTv.setVisibility(0);
      }
      else
      {
        Log.w("MicroMsg.BaseAppBrandRecentView", "[onBindCustomViewHolder] nickname is null! username:%s appId:%s", new Object[] { parame.ooj.username, parame.ooj.appId });
        paramb.titleTv.setText("");
        paramb.titleTv.setVisibility(4);
      }
    }
    paramb.nnL.setImageDrawable(com.tencent.mm.modelappbrand.a.a.aXX());
  }
  
  public final boolean ak(int paramInt1, int paramInt2)
  {
    p localp = this.oDc;
    localp.W(localp.AE(localp.mOffsetX + paramInt1), false);
    return super.ak(paramInt1, paramInt2);
  }
  
  public void bX(List<e> paramList) {}
  
  public boolean canScrollHorizontally(int paramInt)
  {
    return true;
  }
  
  protected boolean ccX()
  {
    return false;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.ayd = paramMotionEvent.getRawX();
      this.aye = paramMotionEvent.getRawY();
    }
    while ((paramMotionEvent.getAction() != 2) || (!this.oDm))
    {
      if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)) {
        this.oDm = false;
      }
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    return true;
  }
  
  public RecyclerView.a getAdapter()
  {
    return this.oDb;
  }
  
  protected int getCompletelyCountPerPage()
  {
    return 4;
  }
  
  public int getCount()
  {
    return this.oCZ.size();
  }
  
  public int getCurrentPage()
  {
    if (this.oDc != null) {
      return this.oDc.owW;
    }
    return 0;
  }
  
  public int getCustomItemCount()
  {
    return 0;
  }
  
  public int getDataCount()
  {
    if (this.oCZ != null) {
      return this.oCZ.size();
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
    return this.oDf;
  }
  
  public AppBrandRecentView.b getOnItemClickListener()
  {
    return this.oCY;
  }
  
  public List<e> getPreviewItemList()
  {
    if (this.oCZ == null) {
      this.oCZ = new ArrayList();
    }
    return this.oCZ;
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
    this.oCX = paramContext.getResources().getDimension(2131165262);
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
    this.oDb = paramContext;
    setAdapter(paramContext);
    this.oDc = new p(getCustomItemCount());
    paramContext = this.oDc;
    Context localContext = getContext();
    int i = getCompletelyCountPerPage();
    paramContext.mContext = localContext;
    paramContext.oDO = this;
    paramContext.oDS = i;
    paramContext.oDO.b(paramContext);
    paramContext.oDO.a(paramContext);
    paramContext.oDV = ((LinearLayoutManager)paramContext.oDO.getLayoutManager());
    paramContext.mSmoothScroller = new p.1(paramContext, paramContext.oDO.getContext());
    paramContext.oDR = new p.2(paramContext, paramContext.oDO.getContext());
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.aYN = getMeasuredWidth();
    Log.d("MicroMsg.BaseAppBrandRecentView", "alvinluo onMeasure mViewWidth %d", new Object[] { Integer.valueOf(this.aYN) });
  }
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    Log.i("MicroMsg.BaseAppBrandRecentView", "[onNotifyChange] process:%s eventId:%s, mType: %s", new Object[] { ((h)com.tencent.mm.kernel.g.aAe().azG()).toString(), Integer.valueOf(paramMStorageEventData.eventId), this.oDe });
    if ((paramMStorageEventData.eventId == 5) && (ccX()))
    {
      Log.i("MicroMsg.BaseAppBrandRecentView", "[onNotifyChange] Ignore!!!");
      return;
    }
    refresh();
  }
  
  public final void refresh()
  {
    if (this.oDi == null) {
      this.oDi = new MMHandler("UpdateAppBrandList_" + this.oDe);
    }
    synchronized (this.oDg)
    {
      if (this.oDh)
      {
        Log.i("MicroMsg.BaseAppBrandRecentView", "alvinluo refresh is running and delay mType: %s", new Object[] { this.oDe });
        if (this.oDj.size() <= 0)
        {
          Log.i("MicroMsg.BaseAppBrandRecentView", "alvinluo refresh add updateTask");
          this.oDj.add(new c());
        }
        return;
      }
      this.oDh = true;
      this.oDi.postToWorker(new c());
    }
  }
  
  public final void release()
  {
    if (this.oDe == AppBrandRecentView.f.oBZ) {
      if (com.tencent.mm.kernel.g.af(ag.class) != null) {
        ((ag)com.tencent.mm.kernel.g.af(ag.class)).remove(this);
      }
    }
    for (;;)
    {
      if (this.oDa != null) {
        this.oDa.cancel();
      }
      this.oCZ.clear();
      if (this.oDi != null) {
        this.oDi.quit();
      }
      return;
      if ((this.oDe == AppBrandRecentView.f.oBY) && (com.tencent.mm.kernel.g.af(ah.class) != null)) {
        ((ah)com.tencent.mm.kernel.g.af(ah.class)).remove(this);
      }
    }
  }
  
  public void setDataQuery(AppBrandRecentView.c paramc)
  {
    this.oDk = paramc;
  }
  
  public void setEnableDataCache(boolean paramBoolean)
  {
    this.oDd = paramBoolean;
  }
  
  public void setOnDataChangedListener(AppBrandRecentView.d paramd)
  {
    this.oDf = paramd;
  }
  
  public void setOnItemClickListener(AppBrandRecentView.b paramb)
  {
    this.oCY = paramb;
  }
  
  public void setOnScrollPageListener(p.a parama)
  {
    if (this.oDc != null) {
      this.oDc.oDX = parama;
    }
  }
  
  public void setType(AppBrandRecentView.f paramf)
  {
    this.oDe = paramf;
    if (this.oDe == AppBrandRecentView.f.oBZ) {
      if (com.tencent.mm.kernel.g.af(ag.class) != null) {
        ((ag)com.tencent.mm.kernel.g.af(ag.class)).add(this);
      }
    }
    while ((this.oDe != AppBrandRecentView.f.oBY) || (com.tencent.mm.kernel.g.af(ah.class) == null)) {
      return;
    }
    ((ah)com.tencent.mm.kernel.g.af(ah.class)).add(this);
  }
  
  protected final class a
    extends RecyclerView.a<BaseAppBrandRecentView.b>
  {
    c.a oDo;
    
    private a()
    {
      AppMethodBeat.i(227796);
      this.oDo = new c.a();
      this.oDo.jbq = 2131690042;
      AppMethodBeat.o(227796);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(227797);
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
          AppMethodBeat.o(227797);
          return i + j;
        }
      }
      i = j;
      if (j % k != 0) {
        i = j + (k - j % k);
      }
      AppMethodBeat.o(227797);
      return i;
    }
  }
  
  public final class b
    extends RecyclerView.v
  {
    public View aus;
    public ImageView nnL;
    public RelativeLayout oDp;
    public ImageView ooB;
    public TextView ooD;
    public ImageView ooF;
    public TextView titleTv;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(227802);
      this.aus = paramView;
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(227800);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/recent/BaseAppBrandRecentView$RecentViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          localObject = (e)paramAnonymousView.getTag();
          ((e)localObject).position = BaseAppBrandRecentView.b.this.lR();
          if (BaseAppBrandRecentView.this.getOnItemClickListener() != null) {
            BaseAppBrandRecentView.this.getOnItemClickListener().a(paramAnonymousView, (e)localObject, BaseAppBrandRecentView.c(BaseAppBrandRecentView.this), BaseAppBrandRecentView.d(BaseAppBrandRecentView.this));
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/recent/BaseAppBrandRecentView$RecentViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(227800);
        }
      });
      paramView.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(227801);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/recent/BaseAppBrandRecentView$RecentViewHolder$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          localObject = (e)paramAnonymousView.getTag();
          ((e)localObject).position = BaseAppBrandRecentView.b.this.lR();
          if (BaseAppBrandRecentView.this.getOnItemClickListener() != null) {
            BaseAppBrandRecentView.this.getOnItemClickListener().b(paramAnonymousView, (e)localObject, BaseAppBrandRecentView.c(BaseAppBrandRecentView.this), BaseAppBrandRecentView.d(BaseAppBrandRecentView.this));
          }
          BaseAppBrandRecentView.e(BaseAppBrandRecentView.this);
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/appbrand/widget/recent/BaseAppBrandRecentView$RecentViewHolder$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(227801);
          return true;
        }
      });
      paramView.getLayoutParams().width = (BaseAppBrandRecentView.this.getResources().getDisplayMetrics().widthPixels / 4);
      this.nnL = ((ImageView)paramView.findViewById(2131302468));
      this.ooB = ((ImageView)paramView.findViewById(2131302483));
      this.oDp = ((RelativeLayout)paramView.findViewById(2131302498));
      this.titleTv = ((TextView)paramView.findViewById(2131309195));
      this.ooD = ((TextView)paramView.findViewById(2131308973));
      this.ooF = ((ImageView)paramView.findViewById(2131302585));
      AppMethodBeat.o(227802);
    }
  }
  
  final class c
    extends com.tencent.f.i.b
  {
    List<e> nZr;
    List<e> oDs;
    boolean oDt;
    
    public c()
    {
      AppMethodBeat.i(227804);
      this.oDt = true;
      this.oDt = true;
      this.nZr = new ArrayList();
      this.oDs = new ArrayList();
      AppMethodBeat.o(227804);
    }
    
    public final String getKey()
    {
      return "MicroMsg.BaseAppBrandRecentView";
    }
    
    public final void run()
    {
      AppMethodBeat.i(227805);
      for (;;)
      {
        synchronized (BaseAppBrandRecentView.f(BaseAppBrandRecentView.this))
        {
          BaseAppBrandRecentView.a(BaseAppBrandRecentView.this, true);
          ??? = null;
          if (BaseAppBrandRecentView.g(BaseAppBrandRecentView.this) != null) {
            ??? = BaseAppBrandRecentView.g(BaseAppBrandRecentView.this).AC(BaseAppBrandRecentView.this.getLoadCount());
          }
          this.nZr.clear();
          this.oDs.clear();
          if (??? == null) {
            break;
          }
          if (BaseAppBrandRecentView.this.getSceneFactory() != null)
          {
            LocalUsageInfo localLocalUsageInfo1 = BaseAppBrandRecentView.this.getSceneFactory().bRO();
            ??? = ((List)???).iterator();
            if (!((Iterator)???).hasNext()) {
              break;
            }
            LocalUsageInfo localLocalUsageInfo2 = (LocalUsageInfo)((Iterator)???).next();
            if ((localLocalUsageInfo1 != null) && (localLocalUsageInfo2.username.equals(localLocalUsageInfo1.username)) && (localLocalUsageInfo2.iOo == localLocalUsageInfo1.iOo)) {
              continue;
            }
            if (this.nZr.size() < BaseAppBrandRecentView.this.getShowCount()) {
              this.nZr.add(new e(localLocalUsageInfo2));
            }
            if (BaseAppBrandRecentView.h(BaseAppBrandRecentView.this)) {
              this.oDs.add(new e(localLocalUsageInfo2));
            }
            Log.d("MicroMsg.BaseAppBrandRecentView", "alvinluo info %s, %s, %s, %s, %s, %d, mType: %s", new Object[] { localLocalUsageInfo2.username, localLocalUsageInfo2.nickname, localLocalUsageInfo2.cyB, localLocalUsageInfo2.kVZ, localLocalUsageInfo2.appId, Integer.valueOf(localLocalUsageInfo2.iOo), BaseAppBrandRecentView.this.oDe });
          }
        }
        Object localObject3 = null;
      }
      BaseAppBrandRecentView.this.bX(this.nZr);
      Log.i("MicroMsg.BaseAppBrandRecentView", "[UpdateAppBrandRecentDataTask] type:%s preview size:%s, data size: %d, mType: %s", new Object[] { BaseAppBrandRecentView.this.getType(), Integer.valueOf(BaseAppBrandRecentView.b(BaseAppBrandRecentView.this).size()), Integer.valueOf(BaseAppBrandRecentView.i(BaseAppBrandRecentView.this).size()), BaseAppBrandRecentView.this.oDe });
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(227803);
          BaseAppBrandRecentView.b(BaseAppBrandRecentView.this).clear();
          BaseAppBrandRecentView.i(BaseAppBrandRecentView.this).clear();
          BaseAppBrandRecentView.b(BaseAppBrandRecentView.this).addAll(BaseAppBrandRecentView.c.this.nZr);
          BaseAppBrandRecentView.i(BaseAppBrandRecentView.this).addAll(BaseAppBrandRecentView.c.this.oDs);
          BaseAppBrandRecentView.c.this.nZr.clear();
          BaseAppBrandRecentView.c.this.oDs.clear();
          if ((BaseAppBrandRecentView.this.getRefreshListener() != null) && (BaseAppBrandRecentView.c.this.oDt)) {
            BaseAppBrandRecentView.this.getRefreshListener().yL(BaseAppBrandRecentView.b(BaseAppBrandRecentView.this).size());
          }
          if (BaseAppBrandRecentView.c.this.oDt)
          {
            Log.i("MicroMsg.BaseAppBrandRecentView", "alvinluo refresh done dispatch diffResult, mType: %s", new Object[] { BaseAppBrandRecentView.this.oDe });
            ??? = AppBrandRecentView.f.oBY;
            BaseAppBrandRecentView.this.getAdapter().atj.notifyChanged();
          }
          synchronized (BaseAppBrandRecentView.f(BaseAppBrandRecentView.this))
          {
            BaseAppBrandRecentView.a(BaseAppBrandRecentView.this, false);
            BaseAppBrandRecentView.j(BaseAppBrandRecentView.this);
            AppMethodBeat.o(227803);
            return;
          }
        }
      });
      AppMethodBeat.o(227805);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recent.BaseAppBrandRecentView
 * JD-Core Version:    0.7.0.1
 */