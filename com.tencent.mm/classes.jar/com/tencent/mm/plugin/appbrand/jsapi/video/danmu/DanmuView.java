package com.tencent.mm.plugin.appbrand.jsapi.video.danmu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Looper;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DanmuView
  extends View
{
  private LinkedList<Float> ddH;
  public List<d> mAA;
  private int[] mAB;
  private volatile boolean mAC;
  private LinkedList<Long> mAD;
  private Paint mAE;
  private long mAF;
  private int mAq;
  private int mAr;
  private int mAs;
  private float mAt;
  private float mAu;
  private boolean mAv;
  private boolean mAw;
  private c mAx;
  private HashMap<Integer, ArrayList<d>> mAy;
  public final Deque<d> mAz;
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
    this.mAq = 5;
    this.mAr = 500;
    this.mAs = 10;
    this.mAt = 0.0F;
    this.mAu = 0.6F;
    this.mAv = false;
    this.mAw = false;
    this.mAz = new LinkedList();
    this.mAA = new LinkedList();
    this.status = 3;
    this.mAF = 0L;
    this.mContext = paramContext;
    AppMethodBeat.o(137862);
  }
  
  private static void N(float paramFloat1, float paramFloat2)
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
      while (i < this.mAq)
      {
        int j = (i + 0) % this.mAq;
        ArrayList localArrayList = (ArrayList)this.mAy.get(Integer.valueOf(j));
        int k = localArrayList.size();
        if (k == 0)
        {
          AppMethodBeat.o(137869);
          return j;
        }
        if (localArrayList.size() <= this.mAs)
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
  
  private void bKm()
  {
    AppMethodBeat.i(137865);
    bKn();
    bKo();
    AppMethodBeat.o(137865);
  }
  
  private void bKn()
  {
    AppMethodBeat.i(137866);
    this.mAy = new HashMap(this.mAq);
    int i = 0;
    while (i < this.mAq)
    {
      ArrayList localArrayList = new ArrayList(this.mAs);
      this.mAy.put(Integer.valueOf(i), localArrayList);
      i += 1;
    }
    AppMethodBeat.o(137866);
  }
  
  private void bKo()
  {
    int j = 0;
    AppMethodBeat.i(137867);
    this.mAB = new int[this.mAq];
    float f1 = b.dW(this.mContext);
    float f2 = getHeight();
    f2 = this.mAt * f2;
    int i = 0;
    while (i < this.mAq)
    {
      this.mAB[i] = ((int)((i + 1) * f1 + f2 - 3.0F * f1 / 4.0F));
      i += 1;
    }
    if (this.mAw)
    {
      this.ddH.clear();
      this.ddH.add(Float.valueOf(f2));
      i = j;
      while (i < this.mAq)
      {
        this.ddH.add(Float.valueOf((i + 1) * f1 + f2));
        i += 1;
      }
    }
    AppMethodBeat.o(137867);
  }
  
  private void bKr()
  {
    AppMethodBeat.i(137878);
    if ((this.mAy != null) && (!this.mAy.isEmpty())) {
      this.mAy.clear();
    }
    AppMethodBeat.o(137878);
  }
  
  private void bKs()
  {
    AppMethodBeat.i(137879);
    synchronized (this.mAz)
    {
      if (!this.mAz.isEmpty()) {
        this.mAz.clear();
      }
      AppMethodBeat.o(137879);
      return;
    }
  }
  
  private double bKu()
  {
    AppMethodBeat.i(137883);
    long l = System.nanoTime();
    this.mAD.addLast(Long.valueOf(l));
    double d = (l - ((Long)this.mAD.getFirst()).longValue()) / 1000000000.0D;
    if (this.mAD.size() > 100) {
      this.mAD.removeFirst();
    }
    if (d > 0.0D)
    {
      d = this.mAD.size() / d;
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
  
  public final void bKp()
  {
    AppMethodBeat.i(137871);
    if (isMainThread())
    {
      this.mAC = true;
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
  
  public final void bKq()
  {
    AppMethodBeat.i(137872);
    if (isMainThread())
    {
      this.mAC = false;
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
  
  public final void bKt()
  {
    this.mAt = 0.0F;
    this.mAu = 0.8F;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(137876);
    this.status = 3;
    clearItems();
    this.mAA.clear();
    invalidate();
    AppMethodBeat.o(137876);
  }
  
  public final void clearItems()
  {
    AppMethodBeat.i(137877);
    bKr();
    bKs();
    AppMethodBeat.o(137877);
  }
  
  public float getYOffset()
  {
    return this.mAu - this.mAt;
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
    if (this.mAC)
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
        if (i >= this.mAy.size()) {
          break label160;
        }
        localObject1 = ((ArrayList)this.mAy.get(Integer.valueOf(i))).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label698;
        }
        ??? = (d)((Iterator)localObject1).next();
        if (((d)???).bKj())
        {
          ((Iterator)localObject1).remove();
          continue;
        }
        ((d)???).b(paramCanvas, false);
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
      if (System.currentTimeMillis() - this.mAF > this.mAr) {
        this.mAF = System.currentTimeMillis();
      }
      float f;
      synchronized (this.mAz)
      {
        if (this.mAz.size() > 0)
        {
          localObject1 = (d)this.mAz.getFirst();
          i = this.mAx.baT();
          while ((localObject1 != null) && (((d)localObject1).xD(i)))
          {
            this.mAz.pollFirst();
            localObject1 = (d)this.mAz.getFirst();
          }
          if ((localObject1 != null) && (((d)localObject1).xC(i)))
          {
            i = b((d)localObject1);
            if (i >= 0)
            {
              ((d)localObject1).eh(paramCanvas.getWidth() - 2, this.mAB[i]);
              ((d)localObject1).b(paramCanvas, false);
              ((ArrayList)this.mAy.get(Integer.valueOf(i))).add(localObject1);
              this.mAz.pollFirst();
            }
          }
        }
        if ((this.mAv) && (this.mAD != null)) {
          paramCanvas.drawText("FPS:".concat(String.valueOf((int)bKu())), 5.0F, 20.0F, this.mAE);
        }
        if ((!this.mAw) || (this.ddH == null)) {
          continue;
        }
        localObject1 = this.ddH.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          continue;
        }
        f = ((Float)((Iterator)localObject1).next()).floatValue();
        paramCanvas.drawLine(0.0F, f, getWidth(), f, this.mAE);
      }
      if (this.status == 2) {
        try
        {
          paramCanvas.drawColor(0);
          i = 0;
          if (i < this.mAy.size())
          {
            localObject1 = ((ArrayList)this.mAy.get(Integer.valueOf(i))).iterator();
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
          Log.w("MicroMsg.DanmuView", "STATUS_PAUSE onDraw e=%s", new Object[] { paramCanvas });
        }
      }
      for (;;)
      {
        AppMethodBeat.o(137868);
        return;
        i += 1;
        break;
        if ((this.mAv) && (this.mAD != null)) {
          paramCanvas.drawText("FPS:".concat(String.valueOf((int)bKu())), 5.0F, 20.0F, this.mAE);
        }
        if ((this.mAw) && (this.ddH != null))
        {
          localObject1 = this.ddH.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            f = ((Float)((Iterator)localObject1).next()).floatValue();
            paramCanvas.drawLine(0.0F, f, getWidth(), f, this.mAE);
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
    bKo();
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
    N(this.mAt, this.mAu);
    setBackgroundColor(0);
    setDrawingCacheBackgroundColor(0);
    bKm();
    AppMethodBeat.o(137864);
  }
  
  public void setDanmuViewCallBack(c paramc)
  {
    this.mAx = paramc;
  }
  
  public void setMaxRow(int paramInt)
  {
    AppMethodBeat.i(137880);
    this.mAq = paramInt;
    HashMap localHashMap;
    if (this.mAy != null)
    {
      localHashMap = this.mAy;
      paramInt = 0;
    }
    for (;;)
    {
      try
      {
        if (paramInt < this.mAy.size())
        {
          ArrayList localArrayList = (ArrayList)this.mAy.get(Integer.valueOf(paramInt));
          if (localArrayList != null) {
            localArrayList.clear();
          }
        }
        else
        {
          bKm();
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
    this.mAs = paramInt;
  }
  
  public void setPickItemInterval(int paramInt)
  {
    this.mAr = paramInt;
  }
  
  public void setShowFps(boolean paramBoolean)
  {
    AppMethodBeat.i(137881);
    this.mAv = paramBoolean;
    if ((paramBoolean) && ((this.mAE == null) || (this.mAD == null)))
    {
      this.mAE = new TextPaint(1);
      this.mAE.setColor(-256);
      this.mAE.setTextSize(20.0F);
      this.mAD = new LinkedList();
    }
    AppMethodBeat.o(137881);
  }
  
  public void setShowLines(boolean paramBoolean)
  {
    AppMethodBeat.i(137882);
    this.mAw = paramBoolean;
    if ((paramBoolean) && (this.ddH == null)) {
      this.ddH = new LinkedList();
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
  
  public final void xE(final int paramInt)
  {
    AppMethodBeat.i(234904);
    Log.i("MicroMsg.DanmuView", "seekToPlayTime playTime=%d", new Object[] { Integer.valueOf(paramInt) });
    bKp();
    clearItems();
    prepare();
    com.tencent.f.h.RTc.aX(new com.tencent.f.i.h()
    {
      public final String getKey()
      {
        return "DanmuView-seekToPlayTime";
      }
      
      public final void run()
      {
        AppMethodBeat.i(137861);
        synchronized (DanmuView.b(DanmuView.this))
        {
          int i = DanmuView.a(DanmuView.this).size() - 1;
          while (i >= 0)
          {
            d locald = (d)DanmuView.a(DanmuView.this).get(i);
            if (locald.bKk() < paramInt) {
              break;
            }
            Log.v("MicroMsg.DanmuView", "seekToPlayTime addBack i=%d showTime=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(locald.bKk()) });
            DanmuView.b(DanmuView.this).addFirst(locald);
            i -= 1;
          }
          DanmuView.c(DanmuView.this);
          AppMethodBeat.o(137861);
          return;
        }
      }
    });
    AppMethodBeat.o(234904);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView
 * JD-Core Version:    0.7.0.1
 */