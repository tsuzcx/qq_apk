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
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DanmuView
  extends View
{
  private LinkedList<Float> cNj;
  private int ltO;
  private int ltP;
  private int ltQ;
  private float ltR;
  private float ltS;
  private boolean ltT;
  private boolean ltU;
  private c ltV;
  private HashMap<Integer, ArrayList<d>> ltW;
  public final Deque<d> ltX;
  public List<d> ltY;
  private int[] ltZ;
  private volatile boolean lua;
  private LinkedList<Long> lub;
  private Paint luc;
  private long lud;
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
    this.ltO = 5;
    this.ltP = 500;
    this.ltQ = 10;
    this.ltR = 0.0F;
    this.ltS = 0.6F;
    this.ltT = false;
    this.ltU = false;
    this.ltX = new LinkedList();
    this.ltY = new LinkedList();
    this.status = 3;
    this.lud = 0L;
    this.mContext = paramContext;
    AppMethodBeat.o(137862);
  }
  
  private static void J(float paramFloat1, float paramFloat2)
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
      while (i < this.ltO)
      {
        int j = (i + 0) % this.ltO;
        ArrayList localArrayList = (ArrayList)this.ltW.get(Integer.valueOf(j));
        int k = localArrayList.size();
        if (k == 0)
        {
          AppMethodBeat.o(137869);
          return j;
        }
        if (localArrayList.size() <= this.ltQ)
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
      ae.w("MicroMsg.DanmuView", "findVacant,Exception:" + paramd.getMessage());
      AppMethodBeat.o(137869);
    }
  }
  
  private void boJ()
  {
    AppMethodBeat.i(137865);
    boK();
    boL();
    AppMethodBeat.o(137865);
  }
  
  private void boK()
  {
    AppMethodBeat.i(137866);
    this.ltW = new HashMap(this.ltO);
    int i = 0;
    while (i < this.ltO)
    {
      ArrayList localArrayList = new ArrayList(this.ltQ);
      this.ltW.put(Integer.valueOf(i), localArrayList);
      i += 1;
    }
    AppMethodBeat.o(137866);
  }
  
  private void boL()
  {
    int j = 0;
    AppMethodBeat.i(137867);
    this.ltZ = new int[this.ltO];
    float f1 = b.dB(this.mContext);
    float f2 = getHeight();
    f2 = this.ltR * f2;
    int i = 0;
    while (i < this.ltO)
    {
      this.ltZ[i] = ((int)((i + 1) * f1 + f2 - 3.0F * f1 / 4.0F));
      i += 1;
    }
    if (this.ltU)
    {
      this.cNj.clear();
      this.cNj.add(Float.valueOf(f2));
      i = j;
      while (i < this.ltO)
      {
        this.cNj.add(Float.valueOf((i + 1) * f1 + f2));
        i += 1;
      }
    }
    AppMethodBeat.o(137867);
  }
  
  private void boO()
  {
    AppMethodBeat.i(137878);
    if ((this.ltW != null) && (!this.ltW.isEmpty())) {
      this.ltW.clear();
    }
    AppMethodBeat.o(137878);
  }
  
  private void boP()
  {
    AppMethodBeat.i(137879);
    synchronized (this.ltX)
    {
      if (!this.ltX.isEmpty()) {
        this.ltX.clear();
      }
      AppMethodBeat.o(137879);
      return;
    }
  }
  
  private double boR()
  {
    AppMethodBeat.i(137883);
    long l = System.nanoTime();
    this.lub.addLast(Long.valueOf(l));
    double d = (l - ((Long)this.lub.getFirst()).longValue()) / 1000000000.0D;
    if (this.lub.size() > 100) {
      this.lub.removeFirst();
    }
    if (d > 0.0D)
    {
      d = this.lub.size() / d;
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
  
  public final void boM()
  {
    AppMethodBeat.i(137871);
    if (isMainThread())
    {
      this.lua = true;
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
  
  public final void boN()
  {
    AppMethodBeat.i(137872);
    if (isMainThread())
    {
      this.lua = false;
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
  
  public final void boQ()
  {
    this.ltR = 0.0F;
    this.ltS = 0.8F;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(137876);
    this.status = 3;
    clearItems();
    this.ltY.clear();
    invalidate();
    AppMethodBeat.o(137876);
  }
  
  public final void clearItems()
  {
    AppMethodBeat.i(137877);
    boO();
    boP();
    AppMethodBeat.o(137877);
  }
  
  public float getYOffset()
  {
    return this.ltS - this.ltR;
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
    if (this.lua)
    {
      ae.i("MicroMsg.DanmuView", "inTransition");
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
        if (i >= this.ltW.size()) {
          break label160;
        }
        localObject1 = ((ArrayList)this.ltW.get(Integer.valueOf(i))).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label698;
        }
        ??? = (d)((Iterator)localObject1).next();
        if (((d)???).boG())
        {
          ((Iterator)localObject1).remove();
          continue;
        }
        ((d)???).b(paramCanvas, false);
      }
      catch (Exception paramCanvas)
      {
        ae.w("MicroMsg.DanmuView", "STATUS_RUNNING onDraw e=%s", new Object[] { paramCanvas });
        invalidate();
        AppMethodBeat.o(137868);
        return;
      }
      continue;
      label160:
      if (System.currentTimeMillis() - this.lud > this.ltP) {
        this.lud = System.currentTimeMillis();
      }
      float f;
      synchronized (this.ltX)
      {
        if (this.ltX.size() > 0)
        {
          localObject1 = (d)this.ltX.getFirst();
          i = this.ltV.aHc();
          while ((localObject1 != null) && (((d)localObject1).tF(i)))
          {
            this.ltX.pollFirst();
            localObject1 = (d)this.ltX.getFirst();
          }
          if ((localObject1 != null) && (((d)localObject1).tE(i)))
          {
            i = b((d)localObject1);
            if (i >= 0)
            {
              ((d)localObject1).dV(paramCanvas.getWidth() - 2, this.ltZ[i]);
              ((d)localObject1).b(paramCanvas, false);
              ((ArrayList)this.ltW.get(Integer.valueOf(i))).add(localObject1);
              this.ltX.pollFirst();
            }
          }
        }
        if ((this.ltT) && (this.lub != null)) {
          paramCanvas.drawText("FPS:".concat(String.valueOf((int)boR())), 5.0F, 20.0F, this.luc);
        }
        if ((!this.ltU) || (this.cNj == null)) {
          continue;
        }
        localObject1 = this.cNj.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          continue;
        }
        f = ((Float)((Iterator)localObject1).next()).floatValue();
        paramCanvas.drawLine(0.0F, f, getWidth(), f, this.luc);
      }
      if (this.status == 2) {
        try
        {
          paramCanvas.drawColor(0);
          i = 0;
          if (i < this.ltW.size())
          {
            localObject1 = ((ArrayList)this.ltW.get(Integer.valueOf(i))).iterator();
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
          ae.w("MicroMsg.DanmuView", "STATUS_PAUSE onDraw e=%s", new Object[] { paramCanvas });
        }
      }
      for (;;)
      {
        AppMethodBeat.o(137868);
        return;
        i += 1;
        break;
        if ((this.ltT) && (this.lub != null)) {
          paramCanvas.drawText("FPS:".concat(String.valueOf((int)boR())), 5.0F, 20.0F, this.luc);
        }
        if ((this.ltU) && (this.cNj != null))
        {
          localObject1 = this.cNj.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            f = ((Float)((Iterator)localObject1).next()).floatValue();
            paramCanvas.drawLine(0.0F, f, getWidth(), f, this.luc);
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
    boL();
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
    J(this.ltR, this.ltS);
    setBackgroundColor(0);
    setDrawingCacheBackgroundColor(0);
    boJ();
    AppMethodBeat.o(137864);
  }
  
  public void setDanmuViewCallBack(c paramc)
  {
    this.ltV = paramc;
  }
  
  public void setMaxRow(int paramInt)
  {
    AppMethodBeat.i(137880);
    this.ltO = paramInt;
    HashMap localHashMap;
    if (this.ltW != null)
    {
      localHashMap = this.ltW;
      paramInt = 0;
    }
    for (;;)
    {
      try
      {
        if (paramInt < this.ltW.size())
        {
          ArrayList localArrayList = (ArrayList)this.ltW.get(Integer.valueOf(paramInt));
          if (localArrayList != null) {
            localArrayList.clear();
          }
        }
        else
        {
          boJ();
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
    this.ltQ = paramInt;
  }
  
  public void setPickItemInterval(int paramInt)
  {
    this.ltP = paramInt;
  }
  
  public void setShowFps(boolean paramBoolean)
  {
    AppMethodBeat.i(137881);
    this.ltT = paramBoolean;
    if ((paramBoolean) && ((this.luc == null) || (this.lub == null)))
    {
      this.luc = new TextPaint(1);
      this.luc.setColor(-256);
      this.luc.setTextSize(20.0F);
      this.lub = new LinkedList();
    }
    AppMethodBeat.o(137881);
  }
  
  public void setShowLines(boolean paramBoolean)
  {
    AppMethodBeat.i(137882);
    this.ltU = paramBoolean;
    if ((paramBoolean) && (this.cNj == null)) {
      this.cNj = new LinkedList();
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
  
  public final void tG(final int paramInt)
  {
    AppMethodBeat.i(211235);
    ae.i("MicroMsg.DanmuView", "seekToPlayTime playTime=%d", new Object[] { Integer.valueOf(paramInt) });
    boM();
    clearItems();
    prepare();
    com.tencent.e.h.MqF.aO(new com.tencent.e.i.h()
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
            if (locald.boH() < paramInt) {
              break;
            }
            ae.v("MicroMsg.DanmuView", "seekToPlayTime addBack i=%d showTime=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(locald.boH()) });
            DanmuView.b(DanmuView.this).addFirst(locald);
            i -= 1;
          }
          DanmuView.c(DanmuView.this);
          AppMethodBeat.o(137861);
          return;
        }
      }
    });
    AppMethodBeat.o(211235);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView
 * JD-Core Version:    0.7.0.1
 */