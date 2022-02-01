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
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DanmuView
  extends View
{
  private LinkedList<Float> cBB;
  private int kSO;
  private int kSP;
  private int kSQ;
  private float kSR;
  private float kSS;
  private boolean kST;
  private boolean kSU;
  private c kSV;
  private HashMap<Integer, ArrayList<d>> kSW;
  public final Deque<d> kSX;
  public List<d> kSY;
  private int[] kSZ;
  private volatile boolean kTa;
  private LinkedList<Long> kTb;
  private Paint kTc;
  private long kTd;
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
    this.kSO = 5;
    this.kSP = 500;
    this.kSQ = 10;
    this.kSR = 0.0F;
    this.kSS = 0.6F;
    this.kST = false;
    this.kSU = false;
    this.kSX = new LinkedList();
    this.kSY = new LinkedList();
    this.status = 3;
    this.kTd = 0L;
    this.mContext = paramContext;
    AppMethodBeat.o(137862);
  }
  
  private static void I(float paramFloat1, float paramFloat2)
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
      while (i < this.kSO)
      {
        int j = (i + 0) % this.kSO;
        ArrayList localArrayList = (ArrayList)this.kSW.get(Integer.valueOf(j));
        int k = localArrayList.size();
        if (k == 0)
        {
          AppMethodBeat.o(137869);
          return j;
        }
        if (localArrayList.size() <= this.kSQ)
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
      ac.w("MicroMsg.DanmuView", "findVacant,Exception:" + paramd.getMessage());
      AppMethodBeat.o(137869);
    }
  }
  
  private void bko()
  {
    AppMethodBeat.i(137865);
    bkp();
    bkq();
    AppMethodBeat.o(137865);
  }
  
  private void bkp()
  {
    AppMethodBeat.i(137866);
    this.kSW = new HashMap(this.kSO);
    int i = 0;
    while (i < this.kSO)
    {
      ArrayList localArrayList = new ArrayList(this.kSQ);
      this.kSW.put(Integer.valueOf(i), localArrayList);
      i += 1;
    }
    AppMethodBeat.o(137866);
  }
  
  private void bkq()
  {
    int j = 0;
    AppMethodBeat.i(137867);
    this.kSZ = new int[this.kSO];
    float f1 = b.dz(this.mContext);
    float f2 = getHeight();
    f2 = this.kSR * f2;
    int i = 0;
    while (i < this.kSO)
    {
      this.kSZ[i] = ((int)((i + 1) * f1 + f2 - 3.0F * f1 / 4.0F));
      i += 1;
    }
    if (this.kSU)
    {
      this.cBB.clear();
      this.cBB.add(Float.valueOf(f2));
      i = j;
      while (i < this.kSO)
      {
        this.cBB.add(Float.valueOf((i + 1) * f1 + f2));
        i += 1;
      }
    }
    AppMethodBeat.o(137867);
  }
  
  private void bkt()
  {
    AppMethodBeat.i(137878);
    if ((this.kSW != null) && (!this.kSW.isEmpty())) {
      this.kSW.clear();
    }
    AppMethodBeat.o(137878);
  }
  
  private void bku()
  {
    AppMethodBeat.i(137879);
    synchronized (this.kSX)
    {
      if (!this.kSX.isEmpty()) {
        this.kSX.clear();
      }
      AppMethodBeat.o(137879);
      return;
    }
  }
  
  private double bkw()
  {
    AppMethodBeat.i(137883);
    long l = System.nanoTime();
    this.kTb.addLast(Long.valueOf(l));
    double d = (l - ((Long)this.kTb.getFirst()).longValue()) / 1000000000.0D;
    if (this.kTb.size() > 100) {
      this.kTb.removeFirst();
    }
    if (d > 0.0D)
    {
      d = this.kTb.size() / d;
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
  
  public final void bkr()
  {
    AppMethodBeat.i(137871);
    if (isMainThread())
    {
      this.kTa = true;
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
  
  public final void bks()
  {
    AppMethodBeat.i(137872);
    if (isMainThread())
    {
      this.kTa = false;
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
  
  public final void bkv()
  {
    this.kSR = 0.0F;
    this.kSS = 0.8F;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(137876);
    this.status = 3;
    clearItems();
    this.kSY.clear();
    invalidate();
    AppMethodBeat.o(137876);
  }
  
  public final void clearItems()
  {
    AppMethodBeat.i(137877);
    bkt();
    bku();
    AppMethodBeat.o(137877);
  }
  
  public float getYOffset()
  {
    return this.kSS - this.kSR;
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
    if (this.kTa)
    {
      ac.i("MicroMsg.DanmuView", "inTransition");
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
        if (i >= this.kSW.size()) {
          break label160;
        }
        localObject1 = ((ArrayList)this.kSW.get(Integer.valueOf(i))).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label698;
        }
        ??? = (d)((Iterator)localObject1).next();
        if (((d)???).bkl())
        {
          ((Iterator)localObject1).remove();
          continue;
        }
        ((d)???).b(paramCanvas, false);
      }
      catch (Exception paramCanvas)
      {
        ac.w("MicroMsg.DanmuView", "STATUS_RUNNING onDraw e=%s", new Object[] { paramCanvas });
        invalidate();
        AppMethodBeat.o(137868);
        return;
      }
      continue;
      label160:
      if (System.currentTimeMillis() - this.kTd > this.kSP) {
        this.kTd = System.currentTimeMillis();
      }
      float f;
      synchronized (this.kSX)
      {
        if (this.kSX.size() > 0)
        {
          localObject1 = (d)this.kSX.getFirst();
          i = this.kSV.aDG();
          while ((localObject1 != null) && (((d)localObject1).sY(i)))
          {
            this.kSX.pollFirst();
            localObject1 = (d)this.kSX.getFirst();
          }
          if ((localObject1 != null) && (((d)localObject1).sX(i)))
          {
            i = b((d)localObject1);
            if (i >= 0)
            {
              ((d)localObject1).dT(paramCanvas.getWidth() - 2, this.kSZ[i]);
              ((d)localObject1).b(paramCanvas, false);
              ((ArrayList)this.kSW.get(Integer.valueOf(i))).add(localObject1);
              this.kSX.pollFirst();
            }
          }
        }
        if ((this.kST) && (this.kTb != null)) {
          paramCanvas.drawText("FPS:".concat(String.valueOf((int)bkw())), 5.0F, 20.0F, this.kTc);
        }
        if ((!this.kSU) || (this.cBB == null)) {
          continue;
        }
        localObject1 = this.cBB.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          continue;
        }
        f = ((Float)((Iterator)localObject1).next()).floatValue();
        paramCanvas.drawLine(0.0F, f, getWidth(), f, this.kTc);
      }
      if (this.status == 2) {
        try
        {
          paramCanvas.drawColor(0);
          i = 0;
          if (i < this.kSW.size())
          {
            localObject1 = ((ArrayList)this.kSW.get(Integer.valueOf(i))).iterator();
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
          ac.w("MicroMsg.DanmuView", "STATUS_PAUSE onDraw e=%s", new Object[] { paramCanvas });
        }
      }
      for (;;)
      {
        AppMethodBeat.o(137868);
        return;
        i += 1;
        break;
        if ((this.kST) && (this.kTb != null)) {
          paramCanvas.drawText("FPS:".concat(String.valueOf((int)bkw())), 5.0F, 20.0F, this.kTc);
        }
        if ((this.kSU) && (this.cBB != null))
        {
          localObject1 = this.cBB.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            f = ((Float)((Iterator)localObject1).next()).floatValue();
            paramCanvas.drawLine(0.0F, f, getWidth(), f, this.kTc);
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
    bkq();
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
    I(this.kSR, this.kSS);
    setBackgroundColor(0);
    setDrawingCacheBackgroundColor(0);
    bko();
    AppMethodBeat.o(137864);
  }
  
  public void setDanmuViewCallBack(c paramc)
  {
    this.kSV = paramc;
  }
  
  public void setMaxRow(int paramInt)
  {
    AppMethodBeat.i(137880);
    this.kSO = paramInt;
    HashMap localHashMap;
    if (this.kSW != null)
    {
      localHashMap = this.kSW;
      paramInt = 0;
    }
    for (;;)
    {
      try
      {
        if (paramInt < this.kSW.size())
        {
          ArrayList localArrayList = (ArrayList)this.kSW.get(Integer.valueOf(paramInt));
          if (localArrayList != null) {
            localArrayList.clear();
          }
        }
        else
        {
          bko();
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
    this.kSQ = paramInt;
  }
  
  public void setPickItemInterval(int paramInt)
  {
    this.kSP = paramInt;
  }
  
  public void setShowFps(boolean paramBoolean)
  {
    AppMethodBeat.i(137881);
    this.kST = paramBoolean;
    if ((paramBoolean) && ((this.kTc == null) || (this.kTb == null)))
    {
      this.kTc = new TextPaint(1);
      this.kTc.setColor(-256);
      this.kTc.setTextSize(20.0F);
      this.kTb = new LinkedList();
    }
    AppMethodBeat.o(137881);
  }
  
  public void setShowLines(boolean paramBoolean)
  {
    AppMethodBeat.i(137882);
    this.kSU = paramBoolean;
    if ((paramBoolean) && (this.cBB == null)) {
      this.cBB = new LinkedList();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView
 * JD-Core Version:    0.7.0.1
 */