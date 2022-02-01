package com.tencent.mm.plugin.appbrand.jsapi.video.danmu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Looper;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.i.h;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DanmuView
  extends View
{
  private LinkedList<Float> fhz;
  private final Context mContext;
  private int sDQ;
  private int sDR;
  private int sDS;
  private float sDT;
  private float sDU;
  private boolean sDV;
  private boolean sDW;
  private c sDX;
  private HashMap<Integer, ArrayList<d>> sDY;
  public final Deque<d> sDZ;
  public List<d> sEa;
  private int[] sEb;
  private volatile boolean sEc;
  private LinkedList<Long> sEd;
  private Paint sEe;
  private long sEf;
  private volatile int status;
  
  public DanmuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public DanmuView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(137862);
    this.sDQ = 5;
    this.sDR = 500;
    this.sDS = 10;
    this.sDT = 0.0F;
    this.sDU = 0.6F;
    this.sDV = false;
    this.sDW = false;
    this.sDZ = new LinkedList();
    this.sEa = new LinkedList();
    this.status = 3;
    this.sEf = 0L;
    this.mContext = paramContext;
    AppMethodBeat.o(137862);
  }
  
  private static void as(float paramFloat1, float paramFloat2)
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
      while (i < this.sDQ)
      {
        int j = (i + 0) % this.sDQ;
        ArrayList localArrayList = (ArrayList)this.sDY.get(Integer.valueOf(j));
        int k = localArrayList.size();
        if (k == 0)
        {
          AppMethodBeat.o(137869);
          return j;
        }
        if (localArrayList.size() <= this.sDS)
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
      Log.w("MicroMsg.DanmuView", "findVacant,Exception:" + paramd.getMessage());
      AppMethodBeat.o(137869);
    }
  }
  
  private void cwj()
  {
    AppMethodBeat.i(137865);
    cwk();
    cwl();
    AppMethodBeat.o(137865);
  }
  
  private void cwk()
  {
    AppMethodBeat.i(137866);
    this.sDY = new HashMap(this.sDQ);
    int i = 0;
    while (i < this.sDQ)
    {
      ArrayList localArrayList = new ArrayList(this.sDS);
      this.sDY.put(Integer.valueOf(i), localArrayList);
      i += 1;
    }
    AppMethodBeat.o(137866);
  }
  
  private void cwl()
  {
    int j = 0;
    AppMethodBeat.i(137867);
    this.sEb = new int[this.sDQ];
    float f1 = b.eO(this.mContext);
    float f2 = getHeight();
    f2 = this.sDT * f2;
    int i = 0;
    while (i < this.sDQ)
    {
      this.sEb[i] = ((int)((i + 1) * f1 + f2 - 3.0F * f1 / 4.0F));
      i += 1;
    }
    if (this.sDW)
    {
      this.fhz.clear();
      this.fhz.add(Float.valueOf(f2));
      i = j;
      while (i < this.sDQ)
      {
        this.fhz.add(Float.valueOf((i + 1) * f1 + f2));
        i += 1;
      }
    }
    AppMethodBeat.o(137867);
  }
  
  private void cwo()
  {
    AppMethodBeat.i(137878);
    if ((this.sDY != null) && (!this.sDY.isEmpty())) {
      this.sDY.clear();
    }
    AppMethodBeat.o(137878);
  }
  
  private void cwp()
  {
    AppMethodBeat.i(137879);
    synchronized (this.sDZ)
    {
      if (!this.sDZ.isEmpty()) {
        this.sDZ.clear();
      }
      AppMethodBeat.o(137879);
      return;
    }
  }
  
  private double cwr()
  {
    AppMethodBeat.i(137883);
    long l = System.nanoTime();
    this.sEd.addLast(Long.valueOf(l));
    double d = (l - ((Long)this.sEd.getFirst()).longValue()) / 1000000000.0D;
    if (this.sEd.size() > 100) {
      this.sEd.removeFirst();
    }
    if (d > 0.0D)
    {
      d = this.sEd.size() / d;
      AppMethodBeat.o(137883);
      return d;
    }
    AppMethodBeat.o(137883);
    return 0.0D;
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
  
  public final void clear()
  {
    AppMethodBeat.i(137876);
    this.status = 3;
    clearItems();
    this.sEa.clear();
    invalidate();
    AppMethodBeat.o(137876);
  }
  
  public final void clearItems()
  {
    AppMethodBeat.i(137877);
    cwo();
    cwp();
    AppMethodBeat.o(137877);
  }
  
  public final void cwm()
  {
    AppMethodBeat.i(137871);
    if (isMainThread())
    {
      this.sEc = true;
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
  
  public final void cwn()
  {
    AppMethodBeat.i(137872);
    if (isMainThread())
    {
      this.sEc = false;
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
  
  public final void cwq()
  {
    this.sDT = 0.0F;
    this.sDU = 0.8F;
  }
  
  public float getYOffset()
  {
    return this.sDU - this.sDT;
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
    if (this.sEc)
    {
      Log.i("MicroMsg.DanmuView", "inTransition");
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
        if (i >= this.sDY.size()) {
          break label160;
        }
        localObject1 = ((ArrayList)this.sDY.get(Integer.valueOf(i))).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label698;
        }
        ??? = (d)((Iterator)localObject1).next();
        if (((d)???).cwg())
        {
          ((Iterator)localObject1).remove();
          continue;
        }
        ((d)???).c(paramCanvas, false);
      }
      catch (Exception paramCanvas)
      {
        Log.w("MicroMsg.DanmuView", "STATUS_RUNNING onDraw e=%s", new Object[] { paramCanvas });
        invalidate();
        AppMethodBeat.o(137868);
        return;
      }
      continue;
      label160:
      if (System.currentTimeMillis() - this.sEf > this.sDR) {
        this.sEf = System.currentTimeMillis();
      }
      float f;
      synchronized (this.sDZ)
      {
        if (this.sDZ.size() > 0)
        {
          localObject1 = (d)this.sDZ.getFirst();
          i = this.sDX.bIa();
          while ((localObject1 != null) && (((d)localObject1).Bp(i)))
          {
            this.sDZ.pollFirst();
            localObject1 = (d)this.sDZ.getFirst();
          }
          if ((localObject1 != null) && (((d)localObject1).Bo(i)))
          {
            i = b((d)localObject1);
            if (i >= 0)
            {
              ((d)localObject1).fz(paramCanvas.getWidth() - 2, this.sEb[i]);
              ((d)localObject1).c(paramCanvas, false);
              ((ArrayList)this.sDY.get(Integer.valueOf(i))).add(localObject1);
              this.sDZ.pollFirst();
            }
          }
        }
        if ((this.sDV) && (this.sEd != null)) {
          paramCanvas.drawText("FPS:".concat(String.valueOf((int)cwr())), 5.0F, 20.0F, this.sEe);
        }
        if ((!this.sDW) || (this.fhz == null)) {
          continue;
        }
        localObject1 = this.fhz.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          continue;
        }
        f = ((Float)((Iterator)localObject1).next()).floatValue();
        paramCanvas.drawLine(0.0F, f, getWidth(), f, this.sEe);
      }
      if (this.status == 2) {
        try
        {
          paramCanvas.drawColor(0);
          i = 0;
          if (i < this.sDY.size())
          {
            localObject1 = ((ArrayList)this.sDY.get(Integer.valueOf(i))).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              ((d)((Iterator)localObject1).next()).c(paramCanvas, true);
              continue;
              invalidate();
            }
          }
        }
        catch (Exception paramCanvas)
        {
          Log.w("MicroMsg.DanmuView", "STATUS_PAUSE onDraw e=%s", new Object[] { paramCanvas });
        }
      }
      for (;;)
      {
        AppMethodBeat.o(137868);
        return;
        i += 1;
        break;
        if ((this.sDV) && (this.sEd != null)) {
          paramCanvas.drawText("FPS:".concat(String.valueOf((int)cwr())), 5.0F, 20.0F, this.sEe);
        }
        if ((this.sDW) && (this.fhz != null))
        {
          localObject1 = this.fhz.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            f = ((Float)((Iterator)localObject1).next()).floatValue();
            paramCanvas.drawLine(0.0F, f, getWidth(), f, this.sEe);
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
    cwl();
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
    as(this.sDT, this.sDU);
    setBackgroundColor(0);
    setDrawingCacheBackgroundColor(0);
    cwj();
    AppMethodBeat.o(137864);
  }
  
  public void setDanmuViewCallBack(c paramc)
  {
    this.sDX = paramc;
  }
  
  public void setMaxRow(int paramInt)
  {
    AppMethodBeat.i(137880);
    this.sDQ = paramInt;
    HashMap localHashMap;
    if (this.sDY != null)
    {
      localHashMap = this.sDY;
      paramInt = 0;
    }
    for (;;)
    {
      try
      {
        if (paramInt < this.sDY.size())
        {
          ArrayList localArrayList = (ArrayList)this.sDY.get(Integer.valueOf(paramInt));
          if (localArrayList != null) {
            localArrayList.clear();
          }
        }
        else
        {
          cwj();
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
    this.sDS = paramInt;
  }
  
  public void setPickItemInterval(int paramInt)
  {
    this.sDR = paramInt;
  }
  
  public void setShowFps(boolean paramBoolean)
  {
    AppMethodBeat.i(137881);
    this.sDV = paramBoolean;
    if ((paramBoolean) && ((this.sEe == null) || (this.sEd == null)))
    {
      this.sEe = new TextPaint(1);
      this.sEe.setColor(-256);
      this.sEe.setTextSize(20.0F);
      this.sEd = new LinkedList();
    }
    AppMethodBeat.o(137881);
  }
  
  public void setShowLines(boolean paramBoolean)
  {
    AppMethodBeat.i(137882);
    this.sDW = paramBoolean;
    if ((paramBoolean) && (this.fhz == null)) {
      this.fhz = new LinkedList();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView
 * JD-Core Version:    0.7.0.1
 */