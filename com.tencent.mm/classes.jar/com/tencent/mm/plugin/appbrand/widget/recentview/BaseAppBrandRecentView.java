package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.content.Context;
import android.content.res.Resources;
import android.os.HandlerThread;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.af;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class BaseAppBrandRecentView
  extends AppBrandRecentView
  implements k.a
{
  private float anT;
  private float anU;
  protected int asY = 0;
  List<a> jfV = new ArrayList();
  protected AppBrandRecentView.f jhO;
  protected float jve;
  private AppBrandRecentView.b jvf;
  public List<a> jvg = new ArrayList();
  private BaseAppBrandRecentView.d jvh;
  private BaseAppBrandRecentView.a jvi;
  public e jvj = null;
  boolean jvk = false;
  private AppBrandRecentView.d jvl = null;
  private final Object jvm = new Object();
  private boolean jvn = false;
  private al jvo = null;
  private ConcurrentLinkedQueue<BaseAppBrandRecentView.d> jvp = new ConcurrentLinkedQueue();
  private AppBrandRecentView.c jvq = new BaseAppBrandRecentView.1(this);
  private float jvr = 1.0F;
  private boolean jvs = false;
  private Context mContext;
  
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
  
  private static String Gb(String paramString)
  {
    if (paramString != null) {
      try
      {
        if (com.tencent.mm.ui.tools.f.auQ(paramString) <= 11) {
          return paramString;
        }
        Object localObject = paramString.toCharArray();
        int m = localObject.length;
        int j = 0;
        int i = 0;
        int k = 0;
        while (j < m)
        {
          k += com.tencent.mm.ui.tools.f.auQ(String.valueOf(localObject[j]));
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
  
  public void a(BaseAppBrandRecentView.c paramc, a parama, int paramInt)
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
    if (paramInt == this.jvi.getItemCount() - 1)
    {
      double d = j;
      i = (int)((1.0D - (Math.ceil(f) - f)) * d);
      ab.i("MicroMsg.BaseAppBrandRecentView", "alvinluo lastPosition %d set width %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    }
    paramc.aku.getLayoutParams().width = i;
    paramc.aku.setScaleX(1.0F);
    paramc.aku.setScaleY(1.0F);
    ab.d("MicroMsg.BaseAppBrandRecentView", "alvinluo onBindCustomViewHolder postion: %d, width: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    if ((parama != null) && (parama.type == 1) && (parama.jfk != null))
    {
      if (bo.isNullOrNil(parama.jfk.bDi)) {
        break label282;
      }
      paramc.titleTv.setText(Gb(parama.jfk.bDi));
      paramc.titleTv.setVisibility(0);
    }
    for (;;)
    {
      paramc.jfs.setVisibility(0);
      if (bo.isNullOrNil(parama.jfk.hcN)) {
        break;
      }
      b.acD().a(paramc.ivs, parama.jfk.hcN, com.tencent.mm.modelappbrand.a.a.acC(), com.tencent.mm.modelappbrand.a.f.fqU);
      return;
      label282:
      if (!bo.isNullOrNil(parama.jfk.nickname))
      {
        String str = Gb(parama.jfk.nickname);
        paramc.titleTv.setText(str);
        paramc.titleTv.setVisibility(0);
      }
      else if (!bo.isNullOrNil(parama.jfk.username))
      {
        paramc.titleTv.setText(parama.jfk.username);
        paramc.titleTv.setVisibility(0);
      }
      else
      {
        ab.w("MicroMsg.BaseAppBrandRecentView", "[onBindCustomViewHolder] nickname is null! username:%s appId:%s", new Object[] { parama.jfk.username, parama.jfk.appId });
        paramc.titleTv.setText("");
        paramc.titleTv.setVisibility(4);
      }
    }
    paramc.ivs.setImageDrawable(com.tencent.mm.modelappbrand.a.a.acC());
  }
  
  public void a(String paramString, m paramm)
  {
    ab.i("MicroMsg.BaseAppBrandRecentView", "[onNotifyChange] process:%s eventId:%s, mType: %s", new Object[] { ((h)g.RI().Rj()).toString(), Integer.valueOf(paramm.htj), this.jhO });
    if ((paramm.htj == 5) && (aSi()))
    {
      ab.i("MicroMsg.BaseAppBrandRecentView", "[onNotifyChange] Ignore!!!");
      return;
    }
    refresh();
  }
  
  public void aO(List<a> paramList) {}
  
  protected boolean aSi()
  {
    return false;
  }
  
  public final boolean ag(int paramInt1, int paramInt2)
  {
    e locale = this.jvj;
    locale.N(locale.qR(locale.mOffsetX + paramInt1), false);
    return super.ag(paramInt1, paramInt2);
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    return true;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.anT = paramMotionEvent.getRawX();
      this.anU = paramMotionEvent.getRawY();
    }
    while ((paramMotionEvent.getAction() != 2) || (!this.jvs))
    {
      if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)) {
        this.jvs = false;
      }
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    return true;
  }
  
  public RecyclerView.a getAdapter()
  {
    return this.jvi;
  }
  
  protected int getCompletelyCountPerPage()
  {
    return 4;
  }
  
  public int getCount()
  {
    return this.jvg.size();
  }
  
  public int getCurrentPage()
  {
    if (this.jvj != null) {
      return this.jvj.jpR;
    }
    return 0;
  }
  
  public int getCustomItemCount()
  {
    return 0;
  }
  
  public int getDataCount()
  {
    if (this.jvg != null) {
      return this.jvg.size();
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
    return this.jvl;
  }
  
  public AppBrandRecentView.b getOnItemClickListener()
  {
    return this.jvf;
  }
  
  public List<a> getPreviewItemList()
  {
    if (this.jvg == null) {
      this.jvg = new ArrayList();
    }
    return this.jvg;
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
    this.jve = paramContext.getResources().getDimension(2131427565);
    paramContext = new BaseAppBrandRecentView.2(this);
    paramContext.setOrientation(0);
    setLayoutManager(paramContext);
    setHasFixedSize(true);
    paramContext = new BaseAppBrandRecentView.a(this, (byte)0);
    this.jvi = paramContext;
    setAdapter(paramContext);
    this.jvj = new e(getCustomItemCount());
    paramContext = this.jvj;
    Context localContext = getContext();
    int i = getCompletelyCountPerPage();
    paramContext.mContext = localContext;
    paramContext.jvQ = this;
    paramContext.jvU = i;
    paramContext.jvQ.b(paramContext);
    paramContext.jvQ.a(paramContext);
    paramContext.jvX = ((LinearLayoutManager)paramContext.jvQ.getLayoutManager());
    paramContext.ajo = new e.1(paramContext, paramContext.jvQ.getContext());
    paramContext.jvT = new e.2(paramContext, paramContext.jvQ.getContext());
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.asY = getMeasuredWidth();
    ab.d("MicroMsg.BaseAppBrandRecentView", "alvinluo onMeasure mViewWidth %d", new Object[] { Integer.valueOf(this.asY) });
  }
  
  protected void qP(int paramInt)
  {
    if ((this.jvk) && (paramInt - 1 < this.jfV.size())) {
      this.jfV.remove(paramInt - 1);
    }
  }
  
  public final void refresh()
  {
    if (this.jvo == null) {
      this.jvo = new al("UpdateAppBrandList_" + this.jhO);
    }
    synchronized (this.jvm)
    {
      if (this.jvn)
      {
        ab.i("MicroMsg.BaseAppBrandRecentView", "alvinluo refresh is running and delay mType: %s", new Object[] { this.jhO });
        if (this.jvp.size() <= 0)
        {
          ab.i("MicroMsg.BaseAppBrandRecentView", "alvinluo refresh add updateTask");
          this.jvp.add(new BaseAppBrandRecentView.d(this));
        }
        return;
      }
      this.jvn = true;
      this.jvo.ac(new BaseAppBrandRecentView.d(this));
    }
  }
  
  public final void release()
  {
    if (this.jhO == AppBrandRecentView.f.jur) {
      if (g.E(af.class) != null) {
        ((af)g.E(af.class)).remove(this);
      }
    }
    for (;;)
    {
      if (this.jvh != null) {
        com.tencent.mm.sdk.g.d.ysm.remove(this.jvh);
      }
      this.jvg.clear();
      if (this.jvo != null) {
        this.jvo.oNc.quit();
      }
      return;
      if ((this.jhO == AppBrandRecentView.f.juq) && (g.E(ag.class) != null)) {
        ((ag)g.E(ag.class)).remove(this);
      }
    }
  }
  
  public void setDataQuery(AppBrandRecentView.c paramc)
  {
    this.jvq = paramc;
  }
  
  public void setEnableDataCache(boolean paramBoolean)
  {
    this.jvk = paramBoolean;
  }
  
  public void setOnDataChangedListener(AppBrandRecentView.d paramd)
  {
    this.jvl = paramd;
  }
  
  public void setOnItemClickListener(AppBrandRecentView.b paramb)
  {
    this.jvf = paramb;
  }
  
  public void setOnScrollPageListener(e.a parama)
  {
    if (this.jvj != null) {
      this.jvj.jvZ = parama;
    }
  }
  
  public void setType(AppBrandRecentView.f paramf)
  {
    this.jhO = paramf;
    if (this.jhO == AppBrandRecentView.f.jur) {
      if (g.E(af.class) != null) {
        ((af)g.E(af.class)).add(this);
      }
    }
    while ((this.jhO != AppBrandRecentView.f.juq) || (g.E(ag.class) == null)) {
      return;
    }
    ((ag)g.E(ag.class)).add(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView
 * JD-Core Version:    0.7.0.1
 */