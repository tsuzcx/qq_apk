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
import android.widget.FrameLayout;
import android.widget.ImageView;
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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.tools.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class BaseAppBrandRecentView
  extends AppBrandRecentView
  implements k.a
{
  protected int aOy = 0;
  private float awo;
  private float awp;
  private Context mContext;
  private boolean mNA = false;
  private ao mNB = null;
  private ConcurrentLinkedQueue<c> mNC = new ConcurrentLinkedQueue();
  private AppBrandRecentView.c mND = new AppBrandRecentView.c()
  {
    public final List<LocalUsageInfo> vB(int paramAnonymousInt)
    {
      AppMethodBeat.i(49965);
      List localList = ((ai)com.tencent.mm.kernel.g.ab(ai.class)).ry(paramAnonymousInt);
      AppMethodBeat.o(49965);
      return localList;
    }
  };
  private float mNE = 1.0F;
  private boolean mNF = false;
  protected float mNr;
  private AppBrandRecentView.b mNs;
  public List<a> mNt = new ArrayList();
  private c mNu;
  private a mNv;
  public e mNw = null;
  boolean mNx = false;
  private AppBrandRecentView.d mNy = null;
  private final Object mNz = new Object();
  protected AppBrandRecentView.f myP;
  List<a> myd = new ArrayList();
  
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
  
  private static String Sh(String paramString)
  {
    if (paramString != null) {
      try
      {
        if (f.aRl(paramString) <= 11) {
          return paramString;
        }
        Object localObject = paramString.toCharArray();
        int m = localObject.length;
        int j = 0;
        int i = 0;
        int k = 0;
        while (j < m)
        {
          k += f.aRl(String.valueOf(localObject[j]));
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
    if (paramInt == this.mNv.getItemCount() - 1)
    {
      double d = j;
      i = (int)((1.0D - (Math.ceil(f) - f)) * d);
      ac.i("MicroMsg.BaseAppBrandRecentView", "alvinluo lastPosition %d set width %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    }
    paramb.asD.getLayoutParams().width = i;
    paramb.asD.setScaleX(1.0F);
    paramb.asD.setScaleY(1.0F);
    ac.d("MicroMsg.BaseAppBrandRecentView", "alvinluo onBindCustomViewHolder postion: %d, width: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    if ((parama != null) && (parama.type == 1) && (parama.mxs != null))
    {
      if (bs.isNullOrNil(parama.mxs.ccm)) {
        break label282;
      }
      paramb.titleTv.setText(Sh(parama.mxs.ccm));
      paramb.titleTv.setVisibility(0);
    }
    for (;;)
    {
      paramb.mxA.setVisibility(0);
      if (bs.isNullOrNil(parama.mxs.jwf)) {
        break;
      }
      com.tencent.mm.modelappbrand.a.b.aAS().a(paramb.lzC, parama.mxs.jwf, com.tencent.mm.modelappbrand.a.a.aAR(), com.tencent.mm.modelappbrand.a.g.htk);
      return;
      label282:
      if (!bs.isNullOrNil(parama.mxs.nickname))
      {
        String str = Sh(parama.mxs.nickname);
        paramb.titleTv.setText(str);
        paramb.titleTv.setVisibility(0);
      }
      else if (!bs.isNullOrNil(parama.mxs.username))
      {
        paramb.titleTv.setText(parama.mxs.username);
        paramb.titleTv.setVisibility(0);
      }
      else
      {
        ac.w("MicroMsg.BaseAppBrandRecentView", "[onBindCustomViewHolder] nickname is null! username:%s appId:%s", new Object[] { parama.mxs.username, parama.mxs.appId });
        paramb.titleTv.setText("");
        paramb.titleTv.setVisibility(4);
      }
    }
    paramb.lzC.setImageDrawable(com.tencent.mm.modelappbrand.a.a.aAR());
  }
  
  public void a(String paramString, m paramm)
  {
    ac.i("MicroMsg.BaseAppBrandRecentView", "[onNotifyChange] process:%s eventId:%s, mType: %s", new Object[] { ((h)com.tencent.mm.kernel.g.agO().agp()).toString(), Integer.valueOf(paramm.jRj), this.myP });
    if ((paramm.jRj == 5) && (bBB()))
    {
      ac.i("MicroMsg.BaseAppBrandRecentView", "[onNotifyChange] Ignore!!!");
      return;
    }
    refresh();
  }
  
  public final boolean ai(int paramInt1, int paramInt2)
  {
    e locale = this.mNw;
    locale.O(locale.wm(locale.mOffsetX + paramInt1), false);
    return super.ai(paramInt1, paramInt2);
  }
  
  protected boolean bBB()
  {
    return false;
  }
  
  public void bH(List<a> paramList) {}
  
  public boolean canScrollHorizontally(int paramInt)
  {
    return true;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.awo = paramMotionEvent.getRawX();
      this.awp = paramMotionEvent.getRawY();
    }
    while ((paramMotionEvent.getAction() != 2) || (!this.mNF))
    {
      if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)) {
        this.mNF = false;
      }
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    return true;
  }
  
  public RecyclerView.a getAdapter()
  {
    return this.mNv;
  }
  
  protected int getCompletelyCountPerPage()
  {
    return 4;
  }
  
  public int getCount()
  {
    return this.mNt.size();
  }
  
  public int getCurrentPage()
  {
    if (this.mNw != null) {
      return this.mNw.mHJ;
    }
    return 0;
  }
  
  public int getCustomItemCount()
  {
    return 0;
  }
  
  public int getDataCount()
  {
    if (this.mNt != null) {
      return this.mNt.size();
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
    return this.mNy;
  }
  
  public AppBrandRecentView.b getOnItemClickListener()
  {
    return this.mNs;
  }
  
  public List<a> getPreviewItemList()
  {
    if (this.mNt == null) {
      this.mNt = new ArrayList();
    }
    return this.mNt;
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
    this.mNr = paramContext.getResources().getDimension(2131165258);
    paramContext = new LinearLayoutManager()
    {
      public final boolean jK()
      {
        return false;
      }
    };
    paramContext.setOrientation(0);
    setLayoutManager(paramContext);
    setHasFixedSize(true);
    paramContext = new a((byte)0);
    this.mNv = paramContext;
    setAdapter(paramContext);
    this.mNw = new e(getCustomItemCount());
    paramContext = this.mNw;
    Context localContext = getContext();
    int i = getCompletelyCountPerPage();
    paramContext.mContext = localContext;
    paramContext.mOd = this;
    paramContext.mOh = i;
    paramContext.mOd.b(paramContext);
    paramContext.mOd.a(paramContext);
    paramContext.mOk = ((LinearLayoutManager)paramContext.mOd.getLayoutManager());
    paramContext.aru = new e.1(paramContext, paramContext.mOd.getContext());
    paramContext.mOg = new e.2(paramContext, paramContext.mOd.getContext());
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.aOy = getMeasuredWidth();
    ac.d("MicroMsg.BaseAppBrandRecentView", "alvinluo onMeasure mViewWidth %d", new Object[] { Integer.valueOf(this.aOy) });
  }
  
  public final void refresh()
  {
    if (this.mNB == null) {
      this.mNB = new ao("UpdateAppBrandList_" + this.myP);
    }
    synchronized (this.mNz)
    {
      if (this.mNA)
      {
        ac.i("MicroMsg.BaseAppBrandRecentView", "alvinluo refresh is running and delay mType: %s", new Object[] { this.myP });
        if (this.mNC.size() <= 0)
        {
          ac.i("MicroMsg.BaseAppBrandRecentView", "alvinluo refresh add updateTask");
          this.mNC.add(new c());
        }
        return;
      }
      this.mNA = true;
      this.mNB.postToWorker(new c());
    }
  }
  
  public final void release()
  {
    if (this.myP == AppBrandRecentView.f.mMy) {
      if (com.tencent.mm.kernel.g.ab(ah.class) != null) {
        ((ah)com.tencent.mm.kernel.g.ab(ah.class)).remove(this);
      }
    }
    for (;;)
    {
      if (this.mNu != null) {
        this.mNu.cancel();
      }
      this.mNt.clear();
      if (this.mNB != null) {
        this.mNB.quit();
      }
      return;
      if ((this.myP == AppBrandRecentView.f.mMx) && (com.tencent.mm.kernel.g.ab(ai.class) != null)) {
        ((ai)com.tencent.mm.kernel.g.ab(ai.class)).remove(this);
      }
    }
  }
  
  public void setDataQuery(AppBrandRecentView.c paramc)
  {
    this.mND = paramc;
  }
  
  public void setEnableDataCache(boolean paramBoolean)
  {
    this.mNx = paramBoolean;
  }
  
  public void setOnDataChangedListener(AppBrandRecentView.d paramd)
  {
    this.mNy = paramd;
  }
  
  public void setOnItemClickListener(AppBrandRecentView.b paramb)
  {
    this.mNs = paramb;
  }
  
  public void setOnScrollPageListener(e.a parama)
  {
    if (this.mNw != null) {
      this.mNw.mOm = parama;
    }
  }
  
  public void setType(AppBrandRecentView.f paramf)
  {
    this.myP = paramf;
    if (this.myP == AppBrandRecentView.f.mMy) {
      if (com.tencent.mm.kernel.g.ab(ah.class) != null) {
        ((ah)com.tencent.mm.kernel.g.ab(ah.class)).add(this);
      }
    }
    while ((this.myP != AppBrandRecentView.f.mMx) || (com.tencent.mm.kernel.g.ab(ai.class) == null)) {
      return;
    }
    ((ai)com.tencent.mm.kernel.g.ab(ai.class)).add(this);
  }
  
  protected void wk(int paramInt)
  {
    if ((this.mNx) && (paramInt - 1 < this.myd.size())) {
      this.myd.remove(paramInt - 1);
    }
  }
  
  protected final class a
    extends RecyclerView.a<BaseAppBrandRecentView.b>
  {
    c.a mNH;
    
    private a()
    {
      AppMethodBeat.i(49966);
      this.mNH = new c.a();
      this.mNH.hKI = 2131690013;
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
    public View asD;
    public ImageView lzC;
    public ImageView mxA;
    public FrameLayout mxB;
    public TextView mxC;
    public TextView titleTv;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(49972);
      this.asD = paramView;
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(49970);
          a locala = (a)paramAnonymousView.getTag();
          locala.position = BaseAppBrandRecentView.b.this.lv();
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
          locala.position = BaseAppBrandRecentView.b.this.lv();
          if (BaseAppBrandRecentView.this.getOnItemClickListener() != null) {
            BaseAppBrandRecentView.this.getOnItemClickListener().b(paramAnonymousView, locala, BaseAppBrandRecentView.c(BaseAppBrandRecentView.this), BaseAppBrandRecentView.d(BaseAppBrandRecentView.this));
          }
          BaseAppBrandRecentView.e(BaseAppBrandRecentView.this);
          AppMethodBeat.o(49971);
          return true;
        }
      });
      paramView.getLayoutParams().width = (BaseAppBrandRecentView.this.getResources().getDisplayMetrics().widthPixels / 4);
      this.lzC = ((ImageView)paramView.findViewById(2131300874));
      this.mxA = ((ImageView)paramView.findViewById(2131300884));
      this.mxB = ((FrameLayout)paramView.findViewById(2131300892));
      this.titleTv = ((TextView)paramView.findViewById(2131305902));
      this.mxC = ((TextView)paramView.findViewById(2131305706));
      AppMethodBeat.o(49972);
    }
  }
  
  final class c
    extends com.tencent.e.i.b
  {
    List<a> mNK;
    boolean mNL;
    List<a> mgF;
    
    public c()
    {
      AppMethodBeat.i(49974);
      this.mNL = true;
      this.mNL = true;
      this.mgF = new ArrayList();
      this.mNK = new ArrayList();
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
            ??? = BaseAppBrandRecentView.g(BaseAppBrandRecentView.this).vB(BaseAppBrandRecentView.this.getLoadCount());
          }
          this.mgF.clear();
          this.mNK.clear();
          if (??? == null) {
            break;
          }
          if (BaseAppBrandRecentView.this.getSceneFactory() != null)
          {
            LocalUsageInfo localLocalUsageInfo1 = BaseAppBrandRecentView.this.getSceneFactory().bqX();
            ??? = ((List)???).iterator();
            if (!((Iterator)???).hasNext()) {
              break;
            }
            LocalUsageInfo localLocalUsageInfo2 = (LocalUsageInfo)((Iterator)???).next();
            if ((localLocalUsageInfo1 != null) && (localLocalUsageInfo2.username.equals(localLocalUsageInfo1.username)) && (localLocalUsageInfo2.hxM == localLocalUsageInfo1.hxM)) {
              continue;
            }
            if (this.mgF.size() < BaseAppBrandRecentView.this.getShowCount()) {
              this.mgF.add(new a(localLocalUsageInfo2));
            }
            if (BaseAppBrandRecentView.h(BaseAppBrandRecentView.this)) {
              this.mNK.add(new a(localLocalUsageInfo2));
            }
            ac.d("MicroMsg.BaseAppBrandRecentView", "alvinluo info %s, %s, %s, %s, %s, %d, mType: %s", new Object[] { localLocalUsageInfo2.username, localLocalUsageInfo2.nickname, localLocalUsageInfo2.ccm, localLocalUsageInfo2.jwf, localLocalUsageInfo2.appId, Integer.valueOf(localLocalUsageInfo2.hxM), BaseAppBrandRecentView.this.myP });
          }
        }
        Object localObject3 = null;
      }
      BaseAppBrandRecentView.this.bH(this.mgF);
      ac.i("MicroMsg.BaseAppBrandRecentView", "[UpdateAppBrandRecentDataTask] type:%s preview size:%s, data size: %d, mType: %s", new Object[] { BaseAppBrandRecentView.this.getType(), Integer.valueOf(BaseAppBrandRecentView.b(BaseAppBrandRecentView.this).size()), Integer.valueOf(BaseAppBrandRecentView.i(BaseAppBrandRecentView.this).size()), BaseAppBrandRecentView.this.myP });
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(49973);
          BaseAppBrandRecentView.b(BaseAppBrandRecentView.this).clear();
          BaseAppBrandRecentView.i(BaseAppBrandRecentView.this).clear();
          BaseAppBrandRecentView.b(BaseAppBrandRecentView.this).addAll(BaseAppBrandRecentView.c.this.mgF);
          BaseAppBrandRecentView.i(BaseAppBrandRecentView.this).addAll(BaseAppBrandRecentView.c.this.mNK);
          BaseAppBrandRecentView.c.this.mgF.clear();
          BaseAppBrandRecentView.c.this.mNK.clear();
          if ((BaseAppBrandRecentView.this.getRefreshListener() != null) && (BaseAppBrandRecentView.c.this.mNL)) {
            BaseAppBrandRecentView.this.getRefreshListener().ul(BaseAppBrandRecentView.b(BaseAppBrandRecentView.this).size());
          }
          if (BaseAppBrandRecentView.c.this.mNL)
          {
            ac.i("MicroMsg.BaseAppBrandRecentView", "alvinluo refresh done dispatch diffResult, mType: %s", new Object[] { BaseAppBrandRecentView.this.myP });
            ??? = AppBrandRecentView.f.mMx;
            BaseAppBrandRecentView.this.getAdapter().arg.notifyChanged();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView
 * JD-Core Version:    0.7.0.1
 */