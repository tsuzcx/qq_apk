package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.v;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import com.tencent.mm.cb.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.af;
import com.tencent.mm.plugin.appbrand.appusage.af.a;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.mm.plugin.appbrand.widget.header.a.a;
import com.tencent.mm.plugin.appbrand.y.e;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.List;

public class AppBrandDesktopView
  extends DragRecyclerView
  implements a.a, j.a
{
  private RecyclerView.a Sw;
  private int ahA = 0;
  private int aqF = 0;
  private RecyclerView.m doG = new AppBrandDesktopView.6(this);
  private float gFU = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  private ArrayList<AppBrandDesktopView.a> hka = new ArrayList();
  private AppBrandDesktopDragView.a hpO = new AppBrandDesktopDragView.a()
  {
    public final void arn()
    {
      AppBrandDesktopView.a(AppBrandDesktopView.this);
      AppBrandDesktopView.b(AppBrandDesktopView.this);
    }
    
    public final void bb(Object paramAnonymousObject)
    {
      if (paramAnonymousObject == null) {}
      while ((!(paramAnonymousObject instanceof AppBrandDesktopView.a)) || (((AppBrandDesktopView.a)paramAnonymousObject).hqw == null)) {
        return;
      }
      AppBrandDesktopView.a(AppBrandDesktopView.this);
      AppBrandDesktopView.b(AppBrandDesktopView.this);
    }
    
    public final void bc(Object paramAnonymousObject)
    {
      if (paramAnonymousObject == null) {}
      do
      {
        do
        {
          return;
        } while (!(paramAnonymousObject instanceof AppBrandDesktopView.a));
        paramAnonymousObject = (AppBrandDesktopView.a)paramAnonymousObject;
      } while ((paramAnonymousObject.type != 1) || (paramAnonymousObject.hqw == null));
      ((af)g.r(af.class)).ar(paramAnonymousObject.hqw.username, paramAnonymousObject.hqw.fJy);
      AppBrandDesktopView.b(AppBrandDesktopView.this);
    }
    
    public final void bd(Object paramAnonymousObject)
    {
      if (paramAnonymousObject == null) {
        return;
      }
      paramAnonymousObject = (AppBrandDesktopView.a)paramAnonymousObject;
      y.d("MicroMsg.MyAppBrandHeader", "alvinluo AppBrandDesktopView removeUsage username: %s, versionType: %d", new Object[] { paramAnonymousObject.hqw.username, Integer.valueOf(paramAnonymousObject.hqw.fJy) });
      ((ag)g.r(ag.class)).as(paramAnonymousObject.hqw.username, paramAnonymousObject.hqw.fJy);
      AppBrandDesktopView.b(AppBrandDesktopView.this);
    }
  };
  private HeaderContainer hph;
  private ArrayList<AppBrandDesktopView.a> hqc = new ArrayList();
  private int hqd = 0;
  private boolean hqe = false;
  private boolean hqf = false;
  private AppBrandDesktopView.h hqg = null;
  private boolean hqh = false;
  private AppBrandDesktopDragView hqi;
  private int hqj = 0;
  private Handler hqk = new Handler();
  private int hql = a.fromDPToPix(ae.getContext(), 88);
  private MotionEvent hqm;
  private float hqn = 0.0F;
  private boolean hqo = false;
  private boolean hqp = false;
  private boolean hqq = false;
  private boolean hqr = false;
  private View hqs;
  private ValueAnimator.AnimatorUpdateListener hqt = new AppBrandDesktopView.1(this);
  private int hqu = 0;
  private ValueAnimator kA;
  private Context mContext;
  
  public AppBrandDesktopView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public AppBrandDesktopView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public AppBrandDesktopView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void apd()
  {
    y.d("MicroMsg.MyAppBrandHeader", "alvinluo resetSearchView");
    this.ahA = 1;
    int i = this.hqg.gY();
    int j = this.hqg.ha();
    if (i > 0) {
      bE(1);
    }
    for (;;)
    {
      if ((aro()) && (!this.hqr)) {
        setPadding(getPaddingLeft(), -this.hql, getPaddingRight(), getPaddingBottom());
      }
      return;
      if (j > 0)
      {
        scrollBy(0, getChildAt(1 - i).getTop());
      }
      else
      {
        bE(1);
        this.hqh = true;
      }
    }
  }
  
  private boolean aro()
  {
    boolean bool = true;
    if (this.hqg != null)
    {
      y.i("MicroMsg.MyAppBrandHeader", "alvinluo checkFullScreen %d, %d", new Object[] { Integer.valueOf(this.hqg.hb()), Integer.valueOf(this.hka.size()) });
      if ((this.hqg.hb() != this.hka.size() - 1) || (this.hqg.gY() != 0)) {}
    }
    for (this.hqp = bool;; this.hqp = false)
    {
      return this.hqp;
      bool = false;
      break;
    }
  }
  
  private void arp()
  {
    int j = 0;
    long l = System.currentTimeMillis();
    this.hka.clear();
    this.hqc.clear();
    this.hqu = 0;
    this.hka.add(new AppBrandDesktopView.a(6));
    Object localObject = ((ag)g.r(ag.class)).kz(2147483647);
    List localList = ((af)g.r(af.class)).a(2147483647, af.a.fJT);
    if ((localObject == null) || (((List)localObject).size() == 0))
    {
      this.hqe = false;
      this.hqd = 2;
      if ((localList != null) && (localList.size() != 0)) {
        break label178;
      }
    }
    label178:
    for (this.hqf = false;; this.hqf = true)
    {
      if ((this.hqe) || (this.hqf)) {
        break label186;
      }
      this.hqr = true;
      this.hka.add(new AppBrandDesktopView.a(9));
      return;
      this.hqe = true;
      this.hqd = 4;
      break;
    }
    label186:
    this.hqr = false;
    if (localObject != null)
    {
      AppBrandDesktopView.a locala = new AppBrandDesktopView.a(10);
      this.hka.add(locala);
      this.hka.add(new AppBrandDesktopView.a(2));
      i = 0;
      while ((i < ((List)localObject).size()) && (i < 3))
      {
        locala = new AppBrandDesktopView.a(2);
        locala.hqw = ((LocalUsageInfo)((List)localObject).get(i));
        this.hqc.add(locala);
        i += 1;
      }
      localObject = new AppBrandDesktopView.a(5);
      this.hqc.add(localObject);
    }
    if (localList != null)
    {
      y.i("MicroMsg.MyAppBrandHeader", "alvinluo makeData myList: %d", new Object[] { Integer.valueOf(localList.size()) });
      localObject = new AppBrandDesktopView.a(11);
      this.hka.add(localObject);
      i = 0;
      while ((i < 10) && (i < localList.size()))
      {
        localObject = new AppBrandDesktopView.a(1);
        ((AppBrandDesktopView.a)localObject).hqw = ((LocalUsageInfo)localList.get(i));
        this.hka.add(localObject);
        i += 1;
      }
    }
    y.d("MicroMsg.MyAppBrandHeader", "alvinluo checkEmptyNum currentEmptyNum: %d, myAppBrandNum: %d, toAddEmptyNum: %d", new Object[] { Integer.valueOf(this.hqu), Integer.valueOf(this.hka.size() - 4), Integer.valueOf(1) });
    int i = j;
    while (i <= 0)
    {
      this.hka.add(new AppBrandDesktopView.a(7));
      i += 1;
    }
    this.hqu = 1;
    getAdapter().agL.notifyChanged();
    this.hka.add(new AppBrandDesktopView.a(8));
    this.hka.add(new AppBrandDesktopView.a(3));
    if (this.hqi != null)
    {
      this.hqi.setCopyList(this.hqc);
      this.hqi.setList(this.hka);
    }
    y.d("MicroMsg.MyAppBrandHeader", "[makeData] cost:" + (System.currentTimeMillis() - l));
    getAdapter().agL.notifyChanged();
  }
  
  public static boolean arq()
  {
    return true;
  }
  
  private void init(Context paramContext)
  {
    y.i("MicroMsg.MyAppBrandHeader", "alvinluo AppBrandDesktopView init mDataList: %d, recentData: %d", new Object[] { Integer.valueOf(this.hka.size()), Integer.valueOf(this.hqc.size()) });
    this.mContext = paramContext;
    Object localObject = (WindowManager)paramContext.getSystemService("window");
    int i;
    if (localObject != null)
    {
      localObject = ((WindowManager)localObject).getDefaultDisplay();
      if (localObject != null)
      {
        Point localPoint = new Point();
        ((Display)localObject).getSize(localPoint);
        i = localPoint.x;
        this.aqF = i;
        if (this.aqF <= 0) {
          break label351;
        }
        i = a.aa(paramContext, y.e.app_brand_desktop_view_left_right_padding);
        int j = a.aa(paramContext, y.e.app_brand_desktop_view_item_width);
        this.hqj = ((this.aqF - i * 2 - j * 4) / 6);
        if (this.hqj < 0) {
          this.hqj = 0;
        }
        y.i("MicroMsg.MyAppBrandHeader", "alvinluo init viewWidth: %d, mGridItemPaddding: %d, leftRight: %d, item: %d", new Object[] { Integer.valueOf(this.aqF), Integer.valueOf(this.hqj), Integer.valueOf(i), Integer.valueOf(j) });
      }
    }
    for (;;)
    {
      setNestedScrollingEnabled(true);
      this.hqg = new AppBrandDesktopView.h(this);
      this.hqg.adw = new AppBrandDesktopView.4(this);
      setLayoutManager(this.hqg);
      setOverScrollMode(2);
      a(this.doG);
      this.Sw = new AppBrandDesktopView.c(this, (byte)0);
      setAdapter(this.Sw);
      arp();
      ((ag)g.r(ag.class)).c(this);
      ((af)g.r(af.class)).c(this);
      ai.l(new AppBrandDesktopView.5(this), 200L);
      y.i("MicroMsg.MyAppBrandHeader", "alvinluo searchView height: %d", new Object[] { Integer.valueOf(this.hql) });
      return;
      i = 0;
      break;
      label351:
      this.hqj = a.aa(paramContext, y.e.SmallPadding);
    }
  }
  
  private void mD(int paramInt)
  {
    y.d("MicroMsg.MyAppBrandHeader", "alvinluo reorderCollection");
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.hka.size())
    {
      AppBrandDesktopView.a locala = (AppBrandDesktopView.a)this.hka.get(i);
      if ((locala.type == 1) && (locala.hqw != null))
      {
        y.d("MicroMsg.MyAppBrandHeader", "alvinluo collectionList %d, %s", new Object[] { Integer.valueOf(i), locala.hqw.nickname });
        localArrayList.add(locala.hqw);
      }
      i += 1;
    }
    ((af)g.r(af.class)).d(localArrayList, paramInt);
  }
  
  private void mE(int paramInt)
  {
    y.i("MicroMsg.MyAppBrandHeader", "alvinluo moveToPadding startPadding: %d, targetPadding: %d, isFullScreen: %b", new Object[] { Integer.valueOf(getPaddingTop()), Integer.valueOf(paramInt), Boolean.valueOf(this.hqp) });
    if (this.hqp)
    {
      if (this.kA == null) {
        this.kA = new ValueAnimator();
      }
      this.kA.removeAllUpdateListeners();
      this.kA.removeAllListeners();
      this.kA.cancel();
      this.kA.setIntValues(new int[] { getPaddingTop(), paramInt });
      this.kA.setDuration(100L);
      this.kA.addUpdateListener(this.hqt);
      this.kA.setInterpolator(new LinearInterpolator());
      this.kA.start();
      if (paramInt != -this.hql) {
        break label164;
      }
      this.hqo = true;
    }
    label164:
    while (paramInt != 0) {
      return;
    }
    this.hqo = false;
  }
  
  public final void a(String paramString, l paraml)
  {
    y.d("MicroMsg.MyAppBrandHeader", "[onNotifyChange] eventId:" + paraml.gbI);
    if (isShown())
    {
      y.w("MicroMsg.MyAppBrandHeader", "[onNotifyChange] pass eventId:" + paraml.gbI);
      return;
    }
    arp();
  }
  
  public final void arr()
  {
    y.i("MicroMsg.MyAppBrandHeader", "[onOpenHeader]");
  }
  
  public final void ars()
  {
    y.i("MicroMsg.MyAppBrandHeader", "[onCloseHeader]");
    apd();
    mD(1);
  }
  
  public final void art()
  {
    ars();
  }
  
  public final void aru()
  {
    y.i("MicroMsg.MyAppBrandHeader", "[onOpenHeader]");
  }
  
  protected void attachViewToParent(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.attachViewToParent(paramView, paramInt, paramLayoutParams);
    this.hqi = ((AppBrandDesktopDragView)getRootView().findViewById(y.g.drag_feature_view));
    this.hqi.setRecyclerView(this);
    this.hqi.setCopyList(this.hqc);
    this.hqi.setList(this.hka);
    this.hqi.setHeaderContainer(this.hph);
    this.hqi.setCollectionCallback(this.hpO);
    this.hqY = this.hqi;
  }
  
  public int getLeftRightMargin()
  {
    int j = a.aa(getContext(), y.e.app_brand_desktop_view_left_right_padding) - this.hqj;
    int i = j;
    if (j < 0) {
      i = 0;
    }
    return i;
  }
  
  public RecyclerView getRecyclerView()
  {
    return this;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.aqF = View.MeasureSpec.getSize(paramInt1);
    y.i("MicroMsg.MyAppBrandHeader", "alvinluo onMeasure width: %d", new Object[] { Integer.valueOf(this.aqF) });
  }
  
  protected void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    y.i("MicroMsg.MyAppBrandHeader", "alvinluo onTouchEvent: %d", new Object[] { Integer.valueOf(paramMotionEvent.getAction()) });
    if ((getPaddingTop() != 0) || ((getPaddingTop() == 0) && (aro()))) {}
    for (int i = 1; i == 0; i = 0)
    {
      y.i("MicroMsg.MyAppBrandHeader", "alvinluo not need to handle onTouchEvent");
      if (paramMotionEvent.getAction() == 1) {
        this.hqq = true;
      }
      return super.onTouchEvent(paramMotionEvent);
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      this.hqm = MotionEvent.obtainNoHistory(paramMotionEvent);
      continue;
      if (this.hqm == null) {
        this.hqm = MotionEvent.obtainNoHistory(paramMotionEvent);
      }
      for (;;)
      {
        this.hqm = MotionEvent.obtainNoHistory(paramMotionEvent);
        break;
        float f1 = paramMotionEvent.getRawX();
        float f3 = this.hqm.getRawX();
        float f2 = paramMotionEvent.getRawY() - this.hqm.getRawY();
        y.d("MicroMsg.MyAppBrandHeader", "alvinluo onTouchMove diffX: %f, diffY: %f, mTotalMoveOffset: %f", new Object[] { Float.valueOf(f1 - f3), Float.valueOf(f2), Float.valueOf(this.hqn) });
        this.hqn += f2;
        f1 = f2;
        if (f2 > 0.0F) {
          f1 = f2 * 0.6F;
        }
        y.i("MicroMsg.MyAppBrandHeader", "alvinluo moveByOffset offsetY: %f, originPaddingTop: %d, isFullScreen: %b", new Object[] { Float.valueOf(f1), Integer.valueOf(getPaddingTop()), Boolean.valueOf(this.hqp) });
        if (this.hqp)
        {
          int j = (int)(f1 + getPaddingTop());
          i = j;
          if (j > 0) {
            i = 0;
          }
          j = i;
          if (i < -this.hql) {
            j = -this.hql;
          }
          y.i("MicroMsg.MyAppBrandHeader", "alvinluo moveByOffset newPaddingTop: %d", new Object[] { Integer.valueOf(j) });
          setPadding(getPaddingLeft(), j, getPaddingRight(), getPaddingBottom());
        }
      }
      this.hqn = (paramMotionEvent.getRawY() - this.hqm.getRawY() + this.hqn);
      y.i("MicroMsg.MyAppBrandHeader", "alvinluo onTouchUp mTotalMoveOffset: %f", new Object[] { Float.valueOf(this.hqn) });
      if (Math.abs(this.hqn) >= this.gFU) {
        break;
      }
      y.i("MicroMsg.MyAppBrandHeader", "alvinluo onTouchUp ignore");
      this.hqm = null;
    }
    if (this.hqn > 0.0F)
    {
      if (this.hqn >= this.hql * 0.3F) {
        break label571;
      }
      if (this.hqo) {
        mE(-this.hql);
      }
    }
    for (;;)
    {
      this.hqn = 0.0F;
      break;
      mE(0);
      continue;
      if (this.hqn < 0.0F) {
        if (Math.abs(this.hqn) >= this.hql * 0.3F) {
          mE(-this.hql);
        } else if (this.hqo) {
          mE(-this.hql);
        } else {
          label571:
          mE(0);
        }
      }
    }
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    y.d("MicroMsg.MyAppBrandHeader", "[onVisibilityChanged] visibility:" + paramInt);
    if ((paramInt == 8) || (paramInt == 4)) {
      postDelayed(new Runnable()
      {
        public final void run()
        {
          AppBrandDesktopView.c(AppBrandDesktopView.this);
        }
      }, 1000L);
    }
  }
  
  public void setHeaderContainer(HeaderContainer paramHeaderContainer)
  {
    this.hph = paramHeaderContainer;
  }
  
  public final class d
    extends RecyclerView.v
  {
    public d(View paramView)
    {
      super();
      int i = AppBrandDesktopView.this.getResources().getDisplayMetrics().widthPixels / 4;
      this$1 = new RecyclerView.LayoutParams(-1, -2);
      AppBrandDesktopView.this.setMargins(AppBrandDesktopView.this.leftMargin + AppBrandDesktopView.h(AppBrandDesktopView.this), AppBrandDesktopView.this.topMargin - i, AppBrandDesktopView.this.rightMargin + AppBrandDesktopView.h(AppBrandDesktopView.this), AppBrandDesktopView.this.bottomMargin);
      this.aie.setLayoutParams(AppBrandDesktopView.this);
    }
  }
  
  public final class e
    extends RecyclerView.v
  {
    protected MMEditText hqy;
    
    public e(View paramView)
    {
      super();
      this.hqy = ((MMEditText)paramView.findViewById(y.g.app_brand_desktop_search_edit_text));
      if (this.hqy != null)
      {
        this.hqy.setFocusable(false);
        this.hqy.setOnClickListener(new AppBrandDesktopView.e.1(this, AppBrandDesktopView.this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView
 * JD-Core Version:    0.7.0.1
 */