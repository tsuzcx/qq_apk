package com.tencent.mm.plugin.appbrand.jsapi.video.danmu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Looper;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.e.i.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DanmuView
  extends View
{
  private LinkedList<Float> cEt;
  private boolean krA;
  private boolean krB;
  private c krC;
  private HashMap<Integer, ArrayList<d>> krD;
  public final Deque<d> krE;
  public List<d> krF;
  private int[] krG;
  private volatile boolean krH;
  private LinkedList<Long> krI;
  private Paint krJ;
  private long krK;
  private int krv;
  private int krw;
  private int krx;
  private float kry;
  private float krz;
  private final Context mContext;
  private volatile int status;
  
  public DanmuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public DanmuView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(137862);
    this.krv = 5;
    this.krw = 500;
    this.krx = 10;
    this.kry = 0.0F;
    this.krz = 0.6F;
    this.krA = false;
    this.krB = false;
    this.krE = new LinkedList();
    this.krF = new LinkedList();
    this.status = 3;
    this.krK = 0L;
    this.mContext = paramContext;
    AppMethodBeat.o(137862);
  }
  
  private static void F(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(137863);
    IllegalArgumentException localIllegalArgumentException;
    if (paramFloat1 >= paramFloat2)
    {
      localIllegalArgumentException = new IllegalArgumentException("start_Y_offset must < end_Y_offset");
      AppMethodBeat.o(137863);
      throw localIllegalArgumentException;
    }
    if ((paramFloat1 < 0.0F) || (paramFloat1 >= 1.0F) || (paramFloat2 < 0.0F) || (paramFloat2 > 1.0F))
    {
      localIllegalArgumentException = new IllegalArgumentException("start_Y_offset and end_Y_offset must between 0 and 1)");
      AppMethodBeat.o(137863);
      throw localIllegalArgumentException;
    }
    AppMethodBeat.o(137863);
  }
  
  private int b(d paramd)
  {
    AppMethodBeat.i(137869);
    int i = 0;
    try
    {
      while (i < this.krv)
      {
        int j = (i + 0) % this.krv;
        ArrayList localArrayList = (ArrayList)this.krD.get(Integer.valueOf(j));
        int k = localArrayList.size();
        if (k == 0)
        {
          AppMethodBeat.o(137869);
          return j;
        }
        if (localArrayList.size() <= this.krx)
        {
          boolean bool = paramd.a((d)localArrayList.get(localArrayList.size() - 1));
          if (!bool)
          {
            AppMethodBeat.o(137869);
            return j;
          }
        }
        i += 1;
      }
      return -1;
    }
    catch (Exception paramd)
    {
      ad.w("MicroMsg.DanmuView", "findVacant,Exception:" + paramd.getMessage());
      AppMethodBeat.o(137869);
    }
  }
  
  private double bdB()
  {
    AppMethodBeat.i(137883);
    long l = System.nanoTime();
    this.krI.addLast(Long.valueOf(l));
    double d = (l - ((Long)this.krI.getFirst()).longValue()) / 1000000000.0D;
    if (this.krI.size() > 100) {
      this.krI.removeFirst();
    }
    if (d > 0.0D)
    {
      d = this.krI.size() / d;
      AppMethodBeat.o(137883);
      return d;
    }
    AppMethodBeat.o(137883);
    return 0.0D;
  }
  
  private void bdt()
  {
    AppMethodBeat.i(137865);
    bdu();
    bdv();
    AppMethodBeat.o(137865);
  }
  
  private void bdu()
  {
    AppMethodBeat.i(137866);
    this.krD = new HashMap(this.krv);
    int i = 0;
    while (i < this.krv)
    {
      ArrayList localArrayList = new ArrayList(this.krx);
      this.krD.put(Integer.valueOf(i), localArrayList);
      i += 1;
    }
    AppMethodBeat.o(137866);
  }
  
  private void bdv()
  {
    int j = 0;
    AppMethodBeat.i(137867);
    this.krG = new int[this.krv];
    float f1 = b.dq(this.mContext);
    float f2 = getHeight();
    f2 = this.kry * f2;
    int i = 0;
    while (i < this.krv)
    {
      this.krG[i] = ((int)((i + 1) * f1 + f2 - 3.0F * f1 / 4.0F));
      i += 1;
    }
    if (this.krB)
    {
      this.cEt.clear();
      this.cEt.add(Float.valueOf(f2));
      i = j;
      while (i < this.krv)
      {
        this.cEt.add(Float.valueOf((i + 1) * f1 + f2));
        i += 1;
      }
    }
    AppMethodBeat.o(137867);
  }
  
  private void bdy()
  {
    AppMethodBeat.i(137878);
    if ((this.krD != null) && (!this.krD.isEmpty())) {
      this.krD.clear();
    }
    AppMethodBeat.o(137878);
  }
  
  private void bdz()
  {
    AppMethodBeat.i(137879);
    synchronized (this.krE)
    {
      if (!this.krE.isEmpty()) {
        this.krE.clear();
      }
      AppMethodBeat.o(137879);
      return;
    }
  }
  
  private static boolean isMainThread()
  {
    AppMethodBeat.i(137884);
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      AppMethodBeat.o(137884);
      return true;
    }
    AppMethodBeat.o(137884);
    return false;
  }
  
  public final void bdA()
  {
    this.kry = 0.0F;
    this.krz = 0.8F;
  }
  
  public final void bdw()
  {
    AppMethodBeat.i(137871);
    if (isMainThread())
    {
      this.krH = true;
      AppMethodBeat.o(137871);
      return;
    }
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(137857);
        DanmuView.a(DanmuView.this, true);
        AppMethodBeat.o(137857);
      }
    });
    AppMethodBeat.o(137871);
  }
  
  public final void bdx()
  {
    AppMethodBeat.i(137872);
    if (isMainThread())
    {
      this.krH = false;
      invalidate();
      AppMethodBeat.o(137872);
      return;
    }
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(137858);
        DanmuView.a(DanmuView.this, false);
        DanmuView.this.invalidate();
        AppMethodBeat.o(137858);
      }
    });
    AppMethodBeat.o(137872);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(137876);
    this.status = 3;
    clearItems();
    this.krF.clear();
    invalidate();
    AppMethodBeat.o(137876);
  }
  
  public final void clearItems()
  {
    AppMethodBeat.i(137877);
    bdy();
    bdz();
    AppMethodBeat.o(137877);
  }
  
  public float getYOffset()
  {
    return this.krz - this.kry;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(137875);
    this.status = 4;
    invalidate();
    AppMethodBeat.o(137875);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(137868);
    super.onDraw(paramCanvas);
    if (this.krH)
    {
      ad.i("MicroMsg.DanmuView", "inTransition");
      AppMethodBeat.o(137868);
      return;
    }
    if (this.status == 1) {}
    for (;;)
    {
      int i;
      Object localObject1;
      try
      {
        paramCanvas.drawColor(0);
        i = 0;
        if (i >= this.krD.size()) {
          break label160;
        }
        localObject1 = ((ArrayList)this.krD.get(Integer.valueOf(i))).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label698;
        }
        ??? = (d)((Iterator)localObject1).next();
        if (((d)???).bdq())
        {
          ((Iterator)localObject1).remove();
          continue;
        }
        ((d)???).b(paramCanvas, false);
      }
      catch (Exception paramCanvas)
      {
        ad.w("MicroMsg.DanmuView", "STATUS_RUNNING onDraw e=%s", new Object[] { paramCanvas });
        invalidate();
        AppMethodBeat.o(137868);
        return;
      }
      continue;
      label160:
      if (System.currentTimeMillis() - this.krK > this.krw) {
        this.krK = System.currentTimeMillis();
      }
      float f;
      synchronized (this.krE)
      {
        if (this.krE.size() > 0)
        {
          localObject1 = (d)this.krE.getFirst();
          i = this.krC.awO();
          while ((localObject1 != null) && (((d)localObject1).si(i)))
          {
            this.krE.pollFirst();
            localObject1 = (d)this.krE.getFirst();
          }
          if ((localObject1 != null) && (((d)localObject1).sh(i)))
          {
            i = b((d)localObject1);
            if (i >= 0)
            {
              ((d)localObject1).dS(paramCanvas.getWidth() - 2, this.krG[i]);
              ((d)localObject1).b(paramCanvas, false);
              ((ArrayList)this.krD.get(Integer.valueOf(i))).add(localObject1);
              this.krE.pollFirst();
            }
          }
        }
        if ((this.krA) && (this.krI != null)) {
          paramCanvas.drawText("FPS:".concat(String.valueOf((int)bdB())), 5.0F, 20.0F, this.krJ);
        }
        if ((!this.krB) || (this.cEt == null)) {
          continue;
        }
        localObject1 = this.cEt.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          continue;
        }
        f = ((Float)((Iterator)localObject1).next()).floatValue();
        paramCanvas.drawLine(0.0F, f, getWidth(), f, this.krJ);
      }
      if (this.status == 2) {
        try
        {
          paramCanvas.drawColor(0);
          i = 0;
          if (i < this.krD.size())
          {
            localObject1 = ((ArrayList)this.krD.get(Integer.valueOf(i))).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              ((d)((Iterator)localObject1).next()).b(paramCanvas, true);
              continue;
              invalidate();
            }
          }
        }
        catch (Exception paramCanvas)
        {
          ad.w("MicroMsg.DanmuView", "STATUS_PAUSE onDraw e=%s", new Object[] { paramCanvas });
        }
      }
      for (;;)
      {
        AppMethodBeat.o(137868);
        return;
        i += 1;
        break;
        if ((this.krA) && (this.krI != null)) {
          paramCanvas.drawText("FPS:".concat(String.valueOf((int)bdB())), 5.0F, 20.0F, this.krJ);
        }
        if ((this.krB) && (this.cEt != null))
        {
          localObject1 = this.cEt.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            f = ((Float)((Iterator)localObject1).next()).floatValue();
            paramCanvas.drawLine(0.0F, f, getWidth(), f, this.krJ);
          }
        }
      }
      label698:
      i += 1;
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(137870);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    bdv();
    AppMethodBeat.o(137870);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(137874);
    this.status = 2;
    invalidate();
    AppMethodBeat.o(137874);
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(137864);
    F(this.kry, this.krz);
    setBackgroundColor(0);
    setDrawingCacheBackgroundColor(0);
    bdt();
    AppMethodBeat.o(137864);
  }
  
  public void setDanmuViewCallBack(c paramc)
  {
    this.krC = paramc;
  }
  
  public void setMaxRow(int paramInt)
  {
    AppMethodBeat.i(137880);
    this.krv = paramInt;
    HashMap localHashMap;
    if (this.krD != null)
    {
      localHashMap = this.krD;
      paramInt = 0;
    }
    for (;;)
    {
      try
      {
        if (paramInt < this.krD.size())
        {
          ArrayList localArrayList = (ArrayList)this.krD.get(Integer.valueOf(paramInt));
          if (localArrayList != null) {
            localArrayList.clear();
          }
        }
        else
        {
          bdt();
          AppMethodBeat.o(137880);
          return;
        }
      }
      finally
      {
        AppMethodBeat.o(137880);
      }
      paramInt += 1;
    }
  }
  
  public void setMaxRunningPerRow(int paramInt)
  {
    this.krx = paramInt;
  }
  
  public void setPickItemInterval(int paramInt)
  {
    this.krw = paramInt;
  }
  
  public void setShowFps(boolean paramBoolean)
  {
    AppMethodBeat.i(137881);
    this.krA = paramBoolean;
    if ((paramBoolean) && ((this.krJ == null) || (this.krI == null)))
    {
      this.krJ = new TextPaint(1);
      this.krJ.setColor(-256);
      this.krJ.setTextSize(20.0F);
      this.krI = new LinkedList();
    }
    AppMethodBeat.o(137881);
  }
  
  public void setShowLines(boolean paramBoolean)
  {
    AppMethodBeat.i(137882);
    this.krB = paramBoolean;
    if ((paramBoolean) && (this.cEt == null)) {
      this.cEt = new LinkedList();
    }
    AppMethodBeat.o(137882);
  }
  
  public final void show()
  {
    AppMethodBeat.i(137873);
    this.status = 1;
    invalidate();
    AppMethodBeat.o(137873);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView
 * JD-Core Version:    0.7.0.1
 */