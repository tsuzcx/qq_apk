package com.tencent.mm.plugin.appbrand.jsapi.video.danmu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Looper;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.e.i;
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
  private LinkedList<Float> dhK;
  private final Context mContext;
  private int pyL;
  private int pyM;
  private int pyN;
  private float pyO;
  private float pyP;
  private boolean pyQ;
  private boolean pyR;
  private c pyS;
  private HashMap<Integer, ArrayList<d>> pyT;
  public final Deque<d> pyU;
  public List<d> pyV;
  private int[] pyW;
  private volatile boolean pyX;
  private LinkedList<Long> pyY;
  private Paint pyZ;
  private long pza;
  private volatile int status;
  
  public DanmuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public DanmuView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(137862);
    this.pyL = 5;
    this.pyM = 500;
    this.pyN = 10;
    this.pyO = 0.0F;
    this.pyP = 0.6F;
    this.pyQ = false;
    this.pyR = false;
    this.pyU = new LinkedList();
    this.pyV = new LinkedList();
    this.status = 3;
    this.pza = 0L;
    this.mContext = paramContext;
    AppMethodBeat.o(137862);
  }
  
  private static void O(float paramFloat1, float paramFloat2)
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
      while (i < this.pyL)
      {
        int j = (i + 0) % this.pyL;
        ArrayList localArrayList = (ArrayList)this.pyT.get(Integer.valueOf(j));
        int k = localArrayList.size();
        if (k == 0)
        {
          AppMethodBeat.o(137869);
          return j;
        }
        if (localArrayList.size() <= this.pyN)
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
  
  private void bVX()
  {
    AppMethodBeat.i(137865);
    bVY();
    bVZ();
    AppMethodBeat.o(137865);
  }
  
  private void bVY()
  {
    AppMethodBeat.i(137866);
    this.pyT = new HashMap(this.pyL);
    int i = 0;
    while (i < this.pyL)
    {
      ArrayList localArrayList = new ArrayList(this.pyN);
      this.pyT.put(Integer.valueOf(i), localArrayList);
      i += 1;
    }
    AppMethodBeat.o(137866);
  }
  
  private void bVZ()
  {
    int j = 0;
    AppMethodBeat.i(137867);
    this.pyW = new int[this.pyL];
    float f1 = b.dU(this.mContext);
    float f2 = getHeight();
    f2 = this.pyO * f2;
    int i = 0;
    while (i < this.pyL)
    {
      this.pyW[i] = ((int)((i + 1) * f1 + f2 - 3.0F * f1 / 4.0F));
      i += 1;
    }
    if (this.pyR)
    {
      this.dhK.clear();
      this.dhK.add(Float.valueOf(f2));
      i = j;
      while (i < this.pyL)
      {
        this.dhK.add(Float.valueOf((i + 1) * f1 + f2));
        i += 1;
      }
    }
    AppMethodBeat.o(137867);
  }
  
  private void bWc()
  {
    AppMethodBeat.i(137878);
    if ((this.pyT != null) && (!this.pyT.isEmpty())) {
      this.pyT.clear();
    }
    AppMethodBeat.o(137878);
  }
  
  private void bWd()
  {
    AppMethodBeat.i(137879);
    synchronized (this.pyU)
    {
      if (!this.pyU.isEmpty()) {
        this.pyU.clear();
      }
      AppMethodBeat.o(137879);
      return;
    }
  }
  
  private double bWf()
  {
    AppMethodBeat.i(137883);
    long l = System.nanoTime();
    this.pyY.addLast(Long.valueOf(l));
    double d = (l - ((Long)this.pyY.getFirst()).longValue()) / 1000000000.0D;
    if (this.pyY.size() > 100) {
      this.pyY.removeFirst();
    }
    if (d > 0.0D)
    {
      d = this.pyY.size() / d;
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
  
  public final void Bb(final int paramInt)
  {
    AppMethodBeat.i(228871);
    Log.i("MicroMsg.DanmuView", "seekToPlayTime playTime=%d", new Object[] { Integer.valueOf(paramInt) });
    bWa();
    clearItems();
    prepare();
    com.tencent.e.h.ZvG.be(new com.tencent.e.i.h()
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
            if (locald.bVV() < paramInt) {
              break;
            }
            Log.v("MicroMsg.DanmuView", "seekToPlayTime addBack i=%d showTime=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(locald.bVV()) });
            DanmuView.b(DanmuView.this).addFirst(locald);
            i -= 1;
          }
          DanmuView.c(DanmuView.this);
          AppMethodBeat.o(137861);
          return;
        }
      }
    });
    AppMethodBeat.o(228871);
  }
  
  public final void bWa()
  {
    AppMethodBeat.i(137871);
    if (isMainThread())
    {
      this.pyX = true;
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
  
  public final void bWb()
  {
    AppMethodBeat.i(137872);
    if (isMainThread())
    {
      this.pyX = false;
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
  
  public final void bWe()
  {
    this.pyO = 0.0F;
    this.pyP = 0.8F;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(137876);
    this.status = 3;
    clearItems();
    this.pyV.clear();
    invalidate();
    AppMethodBeat.o(137876);
  }
  
  public final void clearItems()
  {
    AppMethodBeat.i(137877);
    bWc();
    bWd();
    AppMethodBeat.o(137877);
  }
  
  public float getYOffset()
  {
    return this.pyP - this.pyO;
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
    if (this.pyX)
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
        if (i >= this.pyT.size()) {
          break label160;
        }
        localObject1 = ((ArrayList)this.pyT.get(Integer.valueOf(i))).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label698;
        }
        ??? = (d)((Iterator)localObject1).next();
        if (((d)???).bVT())
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
      if (System.currentTimeMillis() - this.pza > this.pyM) {
        this.pza = System.currentTimeMillis();
      }
      float f;
      synchronized (this.pyU)
      {
        if (this.pyU.size() > 0)
        {
          localObject1 = (d)this.pyU.getFirst();
          i = this.pyS.bkj();
          while ((localObject1 != null) && (((d)localObject1).Ba(i)))
          {
            this.pyU.pollFirst();
            localObject1 = (d)this.pyU.getFirst();
          }
          if ((localObject1 != null) && (((d)localObject1).AZ(i)))
          {
            i = b((d)localObject1);
            if (i >= 0)
            {
              ((d)localObject1).eF(paramCanvas.getWidth() - 2, this.pyW[i]);
              ((d)localObject1).b(paramCanvas, false);
              ((ArrayList)this.pyT.get(Integer.valueOf(i))).add(localObject1);
              this.pyU.pollFirst();
            }
          }
        }
        if ((this.pyQ) && (this.pyY != null)) {
          paramCanvas.drawText("FPS:".concat(String.valueOf((int)bWf())), 5.0F, 20.0F, this.pyZ);
        }
        if ((!this.pyR) || (this.dhK == null)) {
          continue;
        }
        localObject1 = this.dhK.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          continue;
        }
        f = ((Float)((Iterator)localObject1).next()).floatValue();
        paramCanvas.drawLine(0.0F, f, getWidth(), f, this.pyZ);
      }
      if (this.status == 2) {
        try
        {
          paramCanvas.drawColor(0);
          i = 0;
          if (i < this.pyT.size())
          {
            localObject1 = ((ArrayList)this.pyT.get(Integer.valueOf(i))).iterator();
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
        if ((this.pyQ) && (this.pyY != null)) {
          paramCanvas.drawText("FPS:".concat(String.valueOf((int)bWf())), 5.0F, 20.0F, this.pyZ);
        }
        if ((this.pyR) && (this.dhK != null))
        {
          localObject1 = this.dhK.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            f = ((Float)((Iterator)localObject1).next()).floatValue();
            paramCanvas.drawLine(0.0F, f, getWidth(), f, this.pyZ);
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
    bVZ();
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
    O(this.pyO, this.pyP);
    setBackgroundColor(0);
    setDrawingCacheBackgroundColor(0);
    bVX();
    AppMethodBeat.o(137864);
  }
  
  public void setDanmuViewCallBack(c paramc)
  {
    this.pyS = paramc;
  }
  
  public void setMaxRow(int paramInt)
  {
    AppMethodBeat.i(137880);
    this.pyL = paramInt;
    HashMap localHashMap;
    if (this.pyT != null)
    {
      localHashMap = this.pyT;
      paramInt = 0;
    }
    for (;;)
    {
      try
      {
        if (paramInt < this.pyT.size())
        {
          ArrayList localArrayList = (ArrayList)this.pyT.get(Integer.valueOf(paramInt));
          if (localArrayList != null) {
            localArrayList.clear();
          }
        }
        else
        {
          bVX();
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
    this.pyN = paramInt;
  }
  
  public void setPickItemInterval(int paramInt)
  {
    this.pyM = paramInt;
  }
  
  public void setShowFps(boolean paramBoolean)
  {
    AppMethodBeat.i(137881);
    this.pyQ = paramBoolean;
    if ((paramBoolean) && ((this.pyZ == null) || (this.pyY == null)))
    {
      this.pyZ = new TextPaint(1);
      this.pyZ.setColor(-256);
      this.pyZ.setTextSize(20.0F);
      this.pyY = new LinkedList();
    }
    AppMethodBeat.o(137881);
  }
  
  public void setShowLines(boolean paramBoolean)
  {
    AppMethodBeat.i(137882);
    this.pyR = paramBoolean;
    if ((paramBoolean) && (this.dhK == null)) {
      this.dhK = new LinkedList();
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