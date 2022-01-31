package com.tencent.mm.plugin.appbrand.jsapi.video.danmu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Looper;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DanmuView
  extends View
{
  private LinkedList<Float> bTb;
  private float ieA;
  private boolean ieB;
  private boolean ieC;
  private c ieD;
  private HashMap<Integer, ArrayList<d>> ieE;
  public final Deque<d> ieF;
  public List<d> ieG;
  private int[] ieH;
  private volatile boolean ieI;
  private LinkedList<Long> ieJ;
  private Paint ieK;
  private long ieL;
  private int iew;
  private int iex;
  private int iey;
  private float iez;
  private final Context mContext;
  private volatile int status;
  
  public DanmuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public DanmuView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(126604);
    this.iew = 5;
    this.iex = 500;
    this.iey = 10;
    this.iez = 0.0F;
    this.ieA = 0.6F;
    this.ieB = false;
    this.ieC = false;
    this.ieF = new LinkedList();
    this.ieG = new LinkedList();
    this.status = 3;
    this.ieL = 0L;
    this.mContext = paramContext;
    AppMethodBeat.o(126604);
  }
  
  private static void P(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(126605);
    IllegalArgumentException localIllegalArgumentException;
    if (paramFloat1 >= paramFloat2)
    {
      localIllegalArgumentException = new IllegalArgumentException("start_Y_offset must < end_Y_offset");
      AppMethodBeat.o(126605);
      throw localIllegalArgumentException;
    }
    if ((paramFloat1 < 0.0F) || (paramFloat1 >= 1.0F) || (paramFloat2 < 0.0F) || (paramFloat2 > 1.0F))
    {
      localIllegalArgumentException = new IllegalArgumentException("start_Y_offset and end_Y_offset must between 0 and 1)");
      AppMethodBeat.o(126605);
      throw localIllegalArgumentException;
    }
    AppMethodBeat.o(126605);
  }
  
  private void aFM()
  {
    AppMethodBeat.i(126607);
    aFN();
    aFO();
    AppMethodBeat.o(126607);
  }
  
  private void aFN()
  {
    AppMethodBeat.i(126608);
    this.ieE = new HashMap(this.iew);
    int i = 0;
    while (i < this.iew)
    {
      ArrayList localArrayList = new ArrayList(this.iey);
      this.ieE.put(Integer.valueOf(i), localArrayList);
      i += 1;
    }
    AppMethodBeat.o(126608);
  }
  
  private void aFO()
  {
    int j = 0;
    AppMethodBeat.i(126609);
    this.ieH = new int[this.iew];
    float f1 = b.cQ(this.mContext);
    float f2 = getHeight();
    f2 = this.iez * f2;
    int i = 0;
    while (i < this.iew)
    {
      this.ieH[i] = ((int)((i + 1) * f1 + f2 - 3.0F * f1 / 4.0F));
      i += 1;
    }
    if (this.ieC)
    {
      this.bTb.clear();
      this.bTb.add(Float.valueOf(f2));
      i = j;
      while (i < this.iew)
      {
        this.bTb.add(Float.valueOf((i + 1) * f1 + f2));
        i += 1;
      }
    }
    AppMethodBeat.o(126609);
  }
  
  private void aFS()
  {
    AppMethodBeat.i(126620);
    if ((this.ieE != null) && (!this.ieE.isEmpty())) {
      this.ieE.clear();
    }
    AppMethodBeat.o(126620);
  }
  
  private void aFT()
  {
    AppMethodBeat.i(126621);
    synchronized (this.ieF)
    {
      if (!this.ieF.isEmpty()) {
        this.ieF.clear();
      }
      AppMethodBeat.o(126621);
      return;
    }
  }
  
  private double aFV()
  {
    AppMethodBeat.i(126625);
    long l = System.nanoTime();
    this.ieJ.addLast(Long.valueOf(l));
    double d = (l - ((Long)this.ieJ.getFirst()).longValue()) / 1000000000.0D;
    if (this.ieJ.size() > 100) {
      this.ieJ.removeFirst();
    }
    if (d > 0.0D)
    {
      d = this.ieJ.size() / d;
      AppMethodBeat.o(126625);
      return d;
    }
    AppMethodBeat.o(126625);
    return 0.0D;
  }
  
  private int b(d paramd)
  {
    AppMethodBeat.i(126611);
    int i = 0;
    try
    {
      while (i < this.iew)
      {
        int j = (i + 0) % this.iew;
        ArrayList localArrayList = (ArrayList)this.ieE.get(Integer.valueOf(j));
        int k = localArrayList.size();
        if (k == 0)
        {
          AppMethodBeat.o(126611);
          return j;
        }
        if (localArrayList.size() <= this.iey)
        {
          boolean bool = paramd.a((d)localArrayList.get(localArrayList.size() - 1));
          if (!bool)
          {
            AppMethodBeat.o(126611);
            return j;
          }
        }
        i += 1;
      }
      return -1;
    }
    catch (Exception paramd)
    {
      ab.w("MicroMsg.DanmuView", "findVacant,Exception:" + paramd.getMessage());
      AppMethodBeat.o(126611);
    }
  }
  
  private static boolean isMainThread()
  {
    AppMethodBeat.i(126626);
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      AppMethodBeat.o(126626);
      return true;
    }
    AppMethodBeat.o(126626);
    return false;
  }
  
  public final void aFP()
  {
    AppMethodBeat.i(126613);
    if (isMainThread())
    {
      this.ieI = true;
      AppMethodBeat.o(126613);
      return;
    }
    post(new DanmuView.1(this));
    AppMethodBeat.o(126613);
  }
  
  public final void aFQ()
  {
    AppMethodBeat.i(126614);
    if (isMainThread())
    {
      this.ieI = false;
      invalidate();
      AppMethodBeat.o(126614);
      return;
    }
    post(new DanmuView.2(this));
    AppMethodBeat.o(126614);
  }
  
  public final void aFR()
  {
    AppMethodBeat.i(126619);
    aFS();
    aFT();
    AppMethodBeat.o(126619);
  }
  
  public final void aFU()
  {
    this.iez = 0.0F;
    this.ieA = 0.8F;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(126618);
    this.status = 3;
    aFR();
    this.ieG.clear();
    invalidate();
    AppMethodBeat.o(126618);
  }
  
  public float getYOffset()
  {
    return this.ieA - this.iez;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(126617);
    this.status = 4;
    invalidate();
    AppMethodBeat.o(126617);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(126610);
    super.onDraw(paramCanvas);
    if (this.ieI)
    {
      ab.i("MicroMsg.DanmuView", "inTransition");
      AppMethodBeat.o(126610);
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
        if (i >= this.ieE.size()) {
          break label160;
        }
        localObject1 = ((ArrayList)this.ieE.get(Integer.valueOf(i))).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label698;
        }
        ??? = (d)((Iterator)localObject1).next();
        if (((d)???).aFJ())
        {
          ((Iterator)localObject1).remove();
          continue;
        }
        ((d)???).b(paramCanvas, false);
      }
      catch (Exception paramCanvas)
      {
        ab.w("MicroMsg.DanmuView", "STATUS_RUNNING onDraw e=%s", new Object[] { paramCanvas });
        invalidate();
        AppMethodBeat.o(126610);
        return;
      }
      continue;
      label160:
      if (System.currentTimeMillis() - this.ieL > this.iex) {
        this.ieL = System.currentTimeMillis();
      }
      float f;
      synchronized (this.ieF)
      {
        if (this.ieF.size() > 0)
        {
          localObject1 = (d)this.ieF.getFirst();
          i = this.ieD.afR();
          while ((localObject1 != null) && (((d)localObject1).op(i)))
          {
            this.ieF.pollFirst();
            localObject1 = (d)this.ieF.getFirst();
          }
          if ((localObject1 != null) && (((d)localObject1).oo(i)))
          {
            i = b((d)localObject1);
            if (i >= 0)
            {
              ((d)localObject1).dl(paramCanvas.getWidth() - 2, this.ieH[i]);
              ((d)localObject1).b(paramCanvas, false);
              ((ArrayList)this.ieE.get(Integer.valueOf(i))).add(localObject1);
              this.ieF.pollFirst();
            }
          }
        }
        if ((this.ieB) && (this.ieJ != null)) {
          paramCanvas.drawText("FPS:".concat(String.valueOf((int)aFV())), 5.0F, 20.0F, this.ieK);
        }
        if ((!this.ieC) || (this.bTb == null)) {
          continue;
        }
        localObject1 = this.bTb.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          continue;
        }
        f = ((Float)((Iterator)localObject1).next()).floatValue();
        paramCanvas.drawLine(0.0F, f, getWidth(), f, this.ieK);
      }
      if (this.status == 2) {
        try
        {
          paramCanvas.drawColor(0);
          i = 0;
          if (i < this.ieE.size())
          {
            localObject1 = ((ArrayList)this.ieE.get(Integer.valueOf(i))).iterator();
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
          ab.w("MicroMsg.DanmuView", "STATUS_PAUSE onDraw e=%s", new Object[] { paramCanvas });
        }
      }
      for (;;)
      {
        AppMethodBeat.o(126610);
        return;
        i += 1;
        break;
        if ((this.ieB) && (this.ieJ != null)) {
          paramCanvas.drawText("FPS:".concat(String.valueOf((int)aFV())), 5.0F, 20.0F, this.ieK);
        }
        if ((this.ieC) && (this.bTb != null))
        {
          localObject1 = this.bTb.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            f = ((Float)((Iterator)localObject1).next()).floatValue();
            paramCanvas.drawLine(0.0F, f, getWidth(), f, this.ieK);
          }
        }
      }
      label698:
      i += 1;
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(126612);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    aFO();
    AppMethodBeat.o(126612);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(126616);
    this.status = 2;
    invalidate();
    AppMethodBeat.o(126616);
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(126606);
    P(this.iez, this.ieA);
    setBackgroundColor(0);
    setDrawingCacheBackgroundColor(0);
    aFM();
    AppMethodBeat.o(126606);
  }
  
  public void setDanmuViewCallBack(c paramc)
  {
    this.ieD = paramc;
  }
  
  public void setMaxRow(int paramInt)
  {
    AppMethodBeat.i(126622);
    this.iew = paramInt;
    HashMap localHashMap;
    if (this.ieE != null)
    {
      localHashMap = this.ieE;
      paramInt = 0;
    }
    for (;;)
    {
      try
      {
        if (paramInt < this.ieE.size())
        {
          ArrayList localArrayList = (ArrayList)this.ieE.get(Integer.valueOf(paramInt));
          if (localArrayList != null) {
            localArrayList.clear();
          }
        }
        else
        {
          aFM();
          AppMethodBeat.o(126622);
          return;
        }
      }
      finally
      {
        AppMethodBeat.o(126622);
      }
      paramInt += 1;
    }
  }
  
  public void setMaxRunningPerRow(int paramInt)
  {
    this.iey = paramInt;
  }
  
  public void setPickItemInterval(int paramInt)
  {
    this.iex = paramInt;
  }
  
  public void setShowFps(boolean paramBoolean)
  {
    AppMethodBeat.i(126623);
    this.ieB = paramBoolean;
    if ((paramBoolean) && ((this.ieK == null) || (this.ieJ == null)))
    {
      this.ieK = new TextPaint(1);
      this.ieK.setColor(-256);
      this.ieK.setTextSize(20.0F);
      this.ieJ = new LinkedList();
    }
    AppMethodBeat.o(126623);
  }
  
  public void setShowLines(boolean paramBoolean)
  {
    AppMethodBeat.i(126624);
    this.ieC = paramBoolean;
    if ((paramBoolean) && (this.bTb == null)) {
      this.bTb = new LinkedList();
    }
    AppMethodBeat.o(126624);
  }
  
  public final void show()
  {
    AppMethodBeat.i(126615);
    this.status = 1;
    invalidate();
    AppMethodBeat.o(126615);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView
 * JD-Core Version:    0.7.0.1
 */