package com.tencent.mm.plugin.appbrand.jsapi.video.danmu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Looper;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DanmuView
  extends View
{
  private HashMap<Integer, ArrayList<d>> gFA;
  public final Deque<d> gFB = new LinkedList();
  public List<d> gFC = new LinkedList();
  private int[] gFD;
  private volatile boolean gFE;
  private LinkedList<Long> gFF;
  private Paint gFG;
  private long gFH = 0L;
  private LinkedList<Float> gFI;
  private int gFs = 5;
  private int gFt = 500;
  private int gFu = 10;
  public float gFv = 0.0F;
  public float gFw = 0.6F;
  private boolean gFx = false;
  private boolean gFy = false;
  private c gFz;
  private final Context mContext;
  public volatile int status = 3;
  
  public DanmuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public DanmuView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
  }
  
  private void alb()
  {
    this.gFA = new HashMap(this.gFs);
    int i = 0;
    while (i < this.gFs)
    {
      ArrayList localArrayList = new ArrayList(this.gFu);
      this.gFA.put(Integer.valueOf(i), localArrayList);
      i += 1;
    }
    alc();
  }
  
  private void alc()
  {
    int j = 0;
    this.gFD = new int[this.gFs];
    float f1 = b.co(this.mContext);
    float f2 = getHeight();
    f2 = this.gFv * f2;
    int i = 0;
    while (i < this.gFs)
    {
      this.gFD[i] = ((int)((i + 1) * f1 + f2 - 3.0F * f1 / 4.0F));
      i += 1;
    }
    if (this.gFy)
    {
      this.gFI.clear();
      this.gFI.add(Float.valueOf(f2));
      i = j;
      while (i < this.gFs)
      {
        this.gFI.add(Float.valueOf((i + 1) * f1 + f2));
        i += 1;
      }
    }
  }
  
  private double alg()
  {
    long l = System.nanoTime();
    this.gFF.addLast(Long.valueOf(l));
    double d = (l - ((Long)this.gFF.getFirst()).longValue()) / 1000000000.0D;
    if (this.gFF.size() > 100) {
      this.gFF.removeFirst();
    }
    if (d > 0.0D) {
      return this.gFF.size() / d;
    }
    return 0.0D;
  }
  
  private int b(d paramd)
  {
    int i = 0;
    try
    {
      while (i < this.gFs)
      {
        int j = (i + 0) % this.gFs;
        ArrayList localArrayList = (ArrayList)this.gFA.get(Integer.valueOf(j));
        if (localArrayList.size() == 0) {
          return j;
        }
        if (localArrayList.size() <= this.gFu)
        {
          boolean bool = paramd.a((d)localArrayList.get(localArrayList.size() - 1));
          if (!bool) {
            return j;
          }
        }
        i += 1;
      }
      return -1;
    }
    catch (Exception paramd)
    {
      y.w("MicroMsg.DanmuView", "findVacant,Exception:" + paramd.getMessage());
    }
  }
  
  private static boolean isMainThread()
  {
    return Looper.getMainLooper().getThread() == Thread.currentThread();
  }
  
  public final void ald()
  {
    if (isMainThread())
    {
      this.gFE = true;
      return;
    }
    post(new DanmuView.1(this));
  }
  
  public final void ale()
  {
    if (isMainThread())
    {
      this.gFE = false;
      invalidate();
      return;
    }
    post(new DanmuView.2(this));
  }
  
  public final void alf()
  {
    if ((this.gFA != null) && (!this.gFA.isEmpty())) {
      this.gFA.clear();
    }
    synchronized (this.gFB)
    {
      if (!this.gFB.isEmpty()) {
        this.gFB.clear();
      }
      return;
    }
  }
  
  public float getYOffset()
  {
    return this.gFw - this.gFv;
  }
  
  public final void hide()
  {
    this.status = 4;
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.gFE)
    {
      y.i("MicroMsg.DanmuView", "inTransition");
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
        if (i >= this.gFA.size()) {
          break label142;
        }
        localObject1 = ((ArrayList)this.gFA.get(Integer.valueOf(i))).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label686;
        }
        ??? = (d)((Iterator)localObject1).next();
        if (((d)???).akY())
        {
          ((Iterator)localObject1).remove();
          continue;
        }
        ((d)???).b(paramCanvas, false);
      }
      catch (Exception paramCanvas)
      {
        y.w("MicroMsg.DanmuView", "STATUS_RUNNING onDraw e=%s", new Object[] { paramCanvas });
        invalidate();
        return;
      }
      continue;
      label142:
      if (System.currentTimeMillis() - this.gFH > this.gFt) {
        this.gFH = System.currentTimeMillis();
      }
      float f;
      synchronized (this.gFB)
      {
        if (this.gFB.size() > 0)
        {
          localObject1 = (d)this.gFB.getFirst();
          i = this.gFz.Ng();
          while ((localObject1 != null) && (((d)localObject1).lH(i)))
          {
            this.gFB.pollFirst();
            localObject1 = (d)this.gFB.getFirst();
          }
          if ((localObject1 != null) && (((d)localObject1).lG(i)))
          {
            i = b((d)localObject1);
            if (i >= 0)
            {
              ((d)localObject1).ca(paramCanvas.getWidth() - 2, this.gFD[i]);
              ((d)localObject1).b(paramCanvas, false);
              ((ArrayList)this.gFA.get(Integer.valueOf(i))).add(localObject1);
              this.gFB.pollFirst();
            }
          }
        }
        if ((this.gFx) && (this.gFF != null))
        {
          i = (int)alg();
          paramCanvas.drawText("FPS:" + i, 5.0F, 20.0F, this.gFG);
        }
        if ((!this.gFy) || (this.gFI == null)) {
          continue;
        }
        localObject1 = this.gFI.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          continue;
        }
        f = ((Float)((Iterator)localObject1).next()).floatValue();
        paramCanvas.drawLine(0.0F, f, getWidth(), f, this.gFG);
      }
      if (this.status != 2) {
        break;
      }
      try
      {
        paramCanvas.drawColor(0);
        i = 0;
        if (i < this.gFA.size())
        {
          localObject1 = ((ArrayList)this.gFA.get(Integer.valueOf(i))).iterator();
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
        y.w("MicroMsg.DanmuView", "STATUS_PAUSE onDraw e=%s", new Object[] { paramCanvas });
      }
      for (;;)
      {
        return;
        i += 1;
        break;
        if ((this.gFx) && (this.gFF != null))
        {
          i = (int)alg();
          paramCanvas.drawText("FPS:" + i, 5.0F, 20.0F, this.gFG);
        }
        if ((this.gFy) && (this.gFI != null))
        {
          localObject1 = this.gFI.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            f = ((Float)((Iterator)localObject1).next()).floatValue();
            paramCanvas.drawLine(0.0F, f, getWidth(), f, this.gFG);
          }
        }
      }
      label686:
      i += 1;
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    alc();
  }
  
  public final void pause()
  {
    this.status = 2;
    invalidate();
  }
  
  public final void prepare()
  {
    float f1 = this.gFv;
    float f2 = this.gFw;
    if (f1 >= f2) {
      throw new IllegalArgumentException("start_Y_offset must < end_Y_offset");
    }
    if ((f1 < 0.0F) || (f1 >= 1.0F) || (f2 < 0.0F) || (f2 > 1.0F)) {
      throw new IllegalArgumentException("start_Y_offset and end_Y_offset must between 0 and 1)");
    }
    setBackgroundColor(0);
    setDrawingCacheBackgroundColor(0);
    alb();
  }
  
  public void setDanmuViewCallBack(c paramc)
  {
    this.gFz = paramc;
  }
  
  public void setMaxRow(int paramInt)
  {
    this.gFs = paramInt;
    HashMap localHashMap;
    if (this.gFA != null)
    {
      localHashMap = this.gFA;
      paramInt = 0;
    }
    for (;;)
    {
      try
      {
        if (paramInt < this.gFA.size())
        {
          ArrayList localArrayList = (ArrayList)this.gFA.get(Integer.valueOf(paramInt));
          if (localArrayList != null) {
            localArrayList.clear();
          }
        }
        else
        {
          alb();
          return;
        }
      }
      finally {}
      paramInt += 1;
    }
  }
  
  public void setMaxRunningPerRow(int paramInt)
  {
    this.gFu = paramInt;
  }
  
  public void setPickItemInterval(int paramInt)
  {
    this.gFt = paramInt;
  }
  
  public void setShowFps(boolean paramBoolean)
  {
    this.gFx = paramBoolean;
    if ((paramBoolean) && ((this.gFG == null) || (this.gFF == null)))
    {
      this.gFG = new TextPaint(1);
      this.gFG.setColor(-256);
      this.gFG.setTextSize(20.0F);
      this.gFF = new LinkedList();
    }
  }
  
  public void setShowLines(boolean paramBoolean)
  {
    this.gFy = paramBoolean;
    if ((paramBoolean) && (this.gFI == null)) {
      this.gFI = new LinkedList();
    }
  }
  
  public final void show()
  {
    this.status = 1;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView
 * JD-Core Version:    0.7.0.1
 */