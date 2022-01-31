package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.content.Context;
import android.content.res.Resources;
import android.os.HandlerThread;
import android.support.v7.g.c;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.af;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.plugin.appbrand.y.e;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class BaseAppBrandRecentView
  extends AppBrandRecentView
  implements j.a
{
  private float alB;
  private float alC;
  protected int aqF = 0;
  protected float hCC;
  private AppBrandRecentView.b hCD;
  public List<a> hCE = new ArrayList();
  private BaseAppBrandRecentView.d hCF;
  private BaseAppBrandRecentView.a hCG;
  public e hCH = null;
  boolean hCI = false;
  private AppBrandRecentView.d hCJ = null;
  private final Object hCK = new Object();
  private boolean hCL = false;
  private ai hCM = null;
  private ConcurrentLinkedQueue<BaseAppBrandRecentView.d> hCN = new ConcurrentLinkedQueue();
  private AppBrandRecentView.c hCO = new AppBrandRecentView.c()
  {
    public final List<LocalUsageInfo> mG(int paramAnonymousInt)
    {
      return ((ag)g.r(ag.class)).kz(paramAnonymousInt);
    }
  };
  private float hCP = 1.0F;
  private boolean hCQ = false;
  List<a> heL = new ArrayList();
  protected AppBrandRecentView.f hrp;
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
  
  private static String xl(String paramString)
  {
    if (paramString != null) {
      try
      {
        if (com.tencent.mm.ui.tools.f.aek(paramString) <= 11) {
          return paramString;
        }
        Object localObject = paramString.toCharArray();
        int m = localObject.length;
        int j = 0;
        int i = 0;
        int k = 0;
        while (j < m)
        {
          k += com.tencent.mm.ui.tools.f.aek(String.valueOf(localObject[j]));
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
    if (paramInt == this.hCG.getItemCount() - 1)
    {
      double d = j;
      i = (int)((1.0D - (Math.ceil(f) - f)) * d);
      y.i("MicroMsg.BaseAppBrandRecentView", "alvinluo lastPosition %d set width %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    }
    paramc.aie.getLayoutParams().width = i;
    paramc.aie.setScaleX(1.0F);
    paramc.aie.setScaleY(1.0F);
    y.d("MicroMsg.BaseAppBrandRecentView", "alvinluo onBindCustomViewHolder postion: %d, width: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    if ((parama != null) && (parama.type == 1) && (parama.hqw != null))
    {
      if (bk.bl(parama.hqw.fJX)) {
        break label282;
      }
      paramc.eXr.setText(xl(parama.hqw.fJX));
      paramc.eXr.setVisibility(0);
    }
    for (;;)
    {
      paramc.hqB.setVisibility(0);
      if (bk.bl(parama.hqw.fJY)) {
        break;
      }
      b.JD().a(paramc.gSx, parama.hqw.fJY, com.tencent.mm.modelappbrand.a.a.JC(), com.tencent.mm.modelappbrand.a.f.eaL);
      return;
      label282:
      if (!bk.bl(parama.hqw.nickname))
      {
        String str = xl(parama.hqw.nickname);
        paramc.eXr.setText(str);
        paramc.eXr.setVisibility(0);
      }
      else if (!bk.bl(parama.hqw.username))
      {
        paramc.eXr.setText(parama.hqw.username);
        paramc.eXr.setVisibility(0);
      }
      else
      {
        y.w("MicroMsg.BaseAppBrandRecentView", "[onBindCustomViewHolder] nickname is null! username:%s appId:%s", new Object[] { parama.hqw.username, parama.hqw.appId });
        paramc.eXr.setText("");
        paramc.eXr.setVisibility(4);
      }
    }
    paramc.gSx.setImageDrawable(com.tencent.mm.modelappbrand.a.a.JC());
  }
  
  public void a(String paramString, l paraml)
  {
    y.i("MicroMsg.BaseAppBrandRecentView", "[onNotifyChange] process:%s eventId:%s, mType: %s", new Object[] { ((h)g.DM().Dr()).toString(), Integer.valueOf(paraml.gbI), this.hrp });
    if ((paraml.gbI == 5) && (asZ()))
    {
      y.i("MicroMsg.BaseAppBrandRecentView", "[onNotifyChange] Ignore!!!");
      return;
    }
    refresh();
  }
  
  public void aE(List<a> paramList) {}
  
  public final boolean ac(int paramInt1, int paramInt2)
  {
    e locale = this.hCH;
    locale.I(locale.nk(locale.mOffsetX + paramInt1), false);
    return super.ac(paramInt1, paramInt2);
  }
  
  protected boolean asZ()
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
      this.alB = paramMotionEvent.getRawX();
      this.alC = paramMotionEvent.getRawY();
    }
    while ((paramMotionEvent.getAction() != 2) || (!this.hCQ))
    {
      if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)) {
        this.hCQ = false;
      }
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    return true;
  }
  
  public RecyclerView.a getAdapter()
  {
    return this.hCG;
  }
  
  protected int getCompletelyCountPerPage()
  {
    return 4;
  }
  
  public int getCount()
  {
    return this.hCE.size();
  }
  
  public int getCurrentPage()
  {
    if (this.hCH != null) {
      return this.hCH.hxH;
    }
    return 0;
  }
  
  public int getCustomItemCount()
  {
    return 0;
  }
  
  public int getDataCount()
  {
    if (this.hCE != null) {
      return this.hCE.size();
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
    return this.hCJ;
  }
  
  public AppBrandRecentView.b getOnItemClickListener()
  {
    return this.hCD;
  }
  
  public List<a> getPreviewItemList()
  {
    if (this.hCE == null) {
      this.hCE = new ArrayList();
    }
    return this.hCE;
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
    this.hCC = paramContext.getResources().getDimension(y.e.DialogAvatarLinePadding);
    paramContext = new BaseAppBrandRecentView.2(this);
    paramContext.setOrientation(0);
    setLayoutManager(paramContext);
    setHasFixedSize(true);
    paramContext = new BaseAppBrandRecentView.a(this, (byte)0);
    this.hCG = paramContext;
    setAdapter(paramContext);
    this.hCH = new e(getCustomItemCount());
    paramContext = this.hCH;
    Context localContext = getContext();
    int i = getCompletelyCountPerPage();
    paramContext.mContext = localContext;
    paramContext.hDp = this;
    paramContext.hDt = i;
    paramContext.hDp.b(paramContext);
    paramContext.hDp.a(paramContext);
    paramContext.hDw = ((LinearLayoutManager)paramContext.hDp.getLayoutManager());
    paramContext.agY = new e.1(paramContext, paramContext.hDp.getContext());
    paramContext.hDs = new e.2(paramContext, paramContext.hDp.getContext());
  }
  
  protected void ni(int paramInt)
  {
    if ((this.hCI) && (paramInt - 1 < this.heL.size())) {
      this.heL.remove(paramInt - 1);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.aqF = getMeasuredWidth();
    y.d("MicroMsg.BaseAppBrandRecentView", "alvinluo onMeasure mViewWidth %d", new Object[] { Integer.valueOf(this.aqF) });
  }
  
  public final void refresh()
  {
    if (this.hCM == null) {
      this.hCM = new ai("UpdateAppBrandList_" + this.hrp);
    }
    synchronized (this.hCK)
    {
      if (this.hCL)
      {
        y.i("MicroMsg.BaseAppBrandRecentView", "alvinluo refresh is running and delay mType: %s", new Object[] { this.hrp });
        if (this.hCN.size() <= 0)
        {
          y.i("MicroMsg.BaseAppBrandRecentView", "alvinluo refresh add updateTask");
          this.hCN.add(new BaseAppBrandRecentView.d(this));
        }
        return;
      }
      this.hCL = true;
      this.hCM.O(new BaseAppBrandRecentView.d(this));
    }
  }
  
  public final void release()
  {
    if (this.hrp == AppBrandRecentView.f.hBY) {
      if (g.r(af.class) != null) {
        ((af)g.r(af.class)).d(this);
      }
    }
    for (;;)
    {
      if (this.hCF != null) {
        com.tencent.mm.sdk.f.e.remove(this.hCF);
      }
      this.hCE.clear();
      if (this.hCM != null) {
        this.hCM.mnU.quit();
      }
      return;
      if ((this.hrp == AppBrandRecentView.f.hBX) && (g.r(ag.class) != null)) {
        ((ag)g.r(ag.class)).d(this);
      }
    }
  }
  
  public void setDataQuery(AppBrandRecentView.c paramc)
  {
    this.hCO = paramc;
  }
  
  public void setEnableDataCache(boolean paramBoolean)
  {
    this.hCI = paramBoolean;
  }
  
  public void setOnDataChangedListener(AppBrandRecentView.d paramd)
  {
    this.hCJ = paramd;
  }
  
  public void setOnItemClickListener(AppBrandRecentView.b paramb)
  {
    this.hCD = paramb;
  }
  
  public void setOnScrollPageListener(e.a parama)
  {
    if (this.hCH != null) {
      this.hCH.hDy = parama;
    }
  }
  
  public void setType(AppBrandRecentView.f paramf)
  {
    this.hrp = paramf;
    if (this.hrp == AppBrandRecentView.f.hBY) {
      if (g.r(af.class) != null) {
        ((af)g.r(af.class)).c(this);
      }
    }
    while ((this.hrp != AppBrandRecentView.f.hBX) || (g.r(ag.class) == null)) {
      return;
    }
    ((ag)g.r(ag.class)).c(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView
 * JD-Core Version:    0.7.0.1
 */