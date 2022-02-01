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
  private LinkedList<Float> cMA;
  public final Deque<d> lpA;
  public List<d> lpB;
  private int[] lpC;
  private volatile boolean lpD;
  private LinkedList<Long> lpE;
  private Paint lpF;
  private long lpG;
  private int lpr;
  private int lps;
  private int lpt;
  private float lpu;
  private float lpv;
  private boolean lpw;
  private boolean lpx;
  private c lpy;
  private HashMap<Integer, ArrayList<d>> lpz;
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
    this.lpr = 5;
    this.lps = 500;
    this.lpt = 10;
    this.lpu = 0.0F;
    this.lpv = 0.6F;
    this.lpw = false;
    this.lpx = false;
    this.lpA = new LinkedList();
    this.lpB = new LinkedList();
    this.status = 3;
    this.lpG = 0L;
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
      while (i < this.lpr)
      {
        int j = (i + 0) % this.lpr;
        ArrayList localArrayList = (ArrayList)this.lpz.get(Integer.valueOf(j));
        int k = localArrayList.size();
        if (k == 0)
        {
          AppMethodBeat.o(137869);
          return j;
        }
        if (localArrayList.size() <= this.lpt)
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
  
  private void bnZ()
  {
    AppMethodBeat.i(137865);
    boa();
    bob();
    AppMethodBeat.o(137865);
  }
  
  private void boa()
  {
    AppMethodBeat.i(137866);
    this.lpz = new HashMap(this.lpr);
    int i = 0;
    while (i < this.lpr)
    {
      ArrayList localArrayList = new ArrayList(this.lpt);
      this.lpz.put(Integer.valueOf(i), localArrayList);
      i += 1;
    }
    AppMethodBeat.o(137866);
  }
  
  private void bob()
  {
    int j = 0;
    AppMethodBeat.i(137867);
    this.lpC = new int[this.lpr];
    float f1 = b.dx(this.mContext);
    float f2 = getHeight();
    f2 = this.lpu * f2;
    int i = 0;
    while (i < this.lpr)
    {
      this.lpC[i] = ((int)((i + 1) * f1 + f2 - 3.0F * f1 / 4.0F));
      i += 1;
    }
    if (this.lpx)
    {
      this.cMA.clear();
      this.cMA.add(Float.valueOf(f2));
      i = j;
      while (i < this.lpr)
      {
        this.cMA.add(Float.valueOf((i + 1) * f1 + f2));
        i += 1;
      }
    }
    AppMethodBeat.o(137867);
  }
  
  private void boe()
  {
    AppMethodBeat.i(137878);
    if ((this.lpz != null) && (!this.lpz.isEmpty())) {
      this.lpz.clear();
    }
    AppMethodBeat.o(137878);
  }
  
  private void bof()
  {
    AppMethodBeat.i(137879);
    synchronized (this.lpA)
    {
      if (!this.lpA.isEmpty()) {
        this.lpA.clear();
      }
      AppMethodBeat.o(137879);
      return;
    }
  }
  
  private double boh()
  {
    AppMethodBeat.i(137883);
    long l = System.nanoTime();
    this.lpE.addLast(Long.valueOf(l));
    double d = (l - ((Long)this.lpE.getFirst()).longValue()) / 1000000000.0D;
    if (this.lpE.size() > 100) {
      this.lpE.removeFirst();
    }
    if (d > 0.0D)
    {
      d = this.lpE.size() / d;
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
  
  public final void boc()
  {
    AppMethodBeat.i(137871);
    if (isMainThread())
    {
      this.lpD = true;
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
  
  public final void bod()
  {
    AppMethodBeat.i(137872);
    if (isMainThread())
    {
      this.lpD = false;
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
  
  public final void bog()
  {
    this.lpu = 0.0F;
    this.lpv = 0.8F;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(137876);
    this.status = 3;
    clearItems();
    this.lpB.clear();
    invalidate();
    AppMethodBeat.o(137876);
  }
  
  public final void clearItems()
  {
    AppMethodBeat.i(137877);
    boe();
    bof();
    AppMethodBeat.o(137877);
  }
  
  public float getYOffset()
  {
    return this.lpv - this.lpu;
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
    if (this.lpD)
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
        if (i >= this.lpz.size()) {
          break label160;
        }
        localObject1 = ((ArrayList)this.lpz.get(Integer.valueOf(i))).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label698;
        }
        ??? = (d)((Iterator)localObject1).next();
        if (((d)???).bnW())
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
      if (System.currentTimeMillis() - this.lpG > this.lps) {
        this.lpG = System.currentTimeMillis();
      }
      float f;
      synchronized (this.lpA)
      {
        if (this.lpA.size() > 0)
        {
          localObject1 = (d)this.lpA.getFirst();
          i = this.lpy.aGL();
          while ((localObject1 != null) && (((d)localObject1).tB(i)))
          {
            this.lpA.pollFirst();
            localObject1 = (d)this.lpA.getFirst();
          }
          if ((localObject1 != null) && (((d)localObject1).tA(i)))
          {
            i = b((d)localObject1);
            if (i >= 0)
            {
              ((d)localObject1).dV(paramCanvas.getWidth() - 2, this.lpC[i]);
              ((d)localObject1).b(paramCanvas, false);
              ((ArrayList)this.lpz.get(Integer.valueOf(i))).add(localObject1);
              this.lpA.pollFirst();
            }
          }
        }
        if ((this.lpw) && (this.lpE != null)) {
          paramCanvas.drawText("FPS:".concat(String.valueOf((int)boh())), 5.0F, 20.0F, this.lpF);
        }
        if ((!this.lpx) || (this.cMA == null)) {
          continue;
        }
        localObject1 = this.cMA.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          continue;
        }
        f = ((Float)((Iterator)localObject1).next()).floatValue();
        paramCanvas.drawLine(0.0F, f, getWidth(), f, this.lpF);
      }
      if (this.status == 2) {
        try
        {
          paramCanvas.drawColor(0);
          i = 0;
          if (i < this.lpz.size())
          {
            localObject1 = ((ArrayList)this.lpz.get(Integer.valueOf(i))).iterator();
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
        if ((this.lpw) && (this.lpE != null)) {
          paramCanvas.drawText("FPS:".concat(String.valueOf((int)boh())), 5.0F, 20.0F, this.lpF);
        }
        if ((this.lpx) && (this.cMA != null))
        {
          localObject1 = this.cMA.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            f = ((Float)((Iterator)localObject1).next()).floatValue();
            paramCanvas.drawLine(0.0F, f, getWidth(), f, this.lpF);
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
    bob();
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
    J(this.lpu, this.lpv);
    setBackgroundColor(0);
    setDrawingCacheBackgroundColor(0);
    bnZ();
    AppMethodBeat.o(137864);
  }
  
  public void setDanmuViewCallBack(c paramc)
  {
    this.lpy = paramc;
  }
  
  public void setMaxRow(int paramInt)
  {
    AppMethodBeat.i(137880);
    this.lpr = paramInt;
    HashMap localHashMap;
    if (this.lpz != null)
    {
      localHashMap = this.lpz;
      paramInt = 0;
    }
    for (;;)
    {
      try
      {
        if (paramInt < this.lpz.size())
        {
          ArrayList localArrayList = (ArrayList)this.lpz.get(Integer.valueOf(paramInt));
          if (localArrayList != null) {
            localArrayList.clear();
          }
        }
        else
        {
          bnZ();
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
    this.lpt = paramInt;
  }
  
  public void setPickItemInterval(int paramInt)
  {
    this.lps = paramInt;
  }
  
  public void setShowFps(boolean paramBoolean)
  {
    AppMethodBeat.i(137881);
    this.lpw = paramBoolean;
    if ((paramBoolean) && ((this.lpF == null) || (this.lpE == null)))
    {
      this.lpF = new TextPaint(1);
      this.lpF.setColor(-256);
      this.lpF.setTextSize(20.0F);
      this.lpE = new LinkedList();
    }
    AppMethodBeat.o(137881);
  }
  
  public void setShowLines(boolean paramBoolean)
  {
    AppMethodBeat.i(137882);
    this.lpx = paramBoolean;
    if ((paramBoolean) && (this.cMA == null)) {
      this.cMA = new LinkedList();
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