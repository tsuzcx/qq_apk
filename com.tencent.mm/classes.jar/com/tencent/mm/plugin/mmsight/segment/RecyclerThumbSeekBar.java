package com.tencent.mm.plugin.mmsight.segment;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.HandlerThread;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.v;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.cb.a;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.u.a.c;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;

public class RecyclerThumbSeekBar
  extends RelativeLayout
  implements c
{
  private int dQP;
  private int dQQ;
  private int eAx = -1;
  private RecyclerView heQ;
  private VideoTransPara mgW;
  private int mlY;
  private c.a mlZ;
  private c.b mma;
  private RecyclerThumbSeekBar.c mmb;
  private o mmc;
  private int mmd;
  private d.a mme = new d.a(new RecyclerThumbSeekBar.1(this));
  private Runnable mmf = new RecyclerThumbSeekBar.2(this);
  private RecyclerView.m mmg = new RecyclerThumbSeekBar.5(this);
  private o.a mmh = new RecyclerThumbSeekBar.6(this);
  private String path;
  
  public RecyclerThumbSeekBar(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public RecyclerThumbSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public RecyclerThumbSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private float S(int paramInt, boolean paramBoolean)
  {
    if ((this.mmb == null) || (this.heQ == null)) {}
    View localView;
    int i;
    int j;
    do
    {
      return 0.0F;
      localView = this.heQ.y(paramInt, 0.0F);
      if (localView == null)
      {
        y.w("RecyclerThumbSeekBar", "getPositionInTotalRange x[%d] isEnd[%b], view is null.", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
        return 0.0F;
      }
      i = RecyclerView.bg(localView);
      j = this.mmb.getItemCount();
    } while (i <= 1);
    if (i >= j - 1) {
      return 1.0F;
    }
    return (i - 1 + (paramInt - localView.getLeft()) / localView.getWidth()) / (j - 2);
  }
  
  private void bjV()
  {
    ai.d(new RecyclerThumbSeekBar.4(this));
  }
  
  private void init()
  {
    this.heQ = new RecyclerView(getContext());
    getContext();
    Object localObject = new LinearLayoutManager(0);
    this.heQ.setLayoutManager((RecyclerView.i)localObject);
    this.heQ.setHasFixedSize(true);
    int i = a.aa(getContext(), a.c.video_segment_seekbar_recycler_view_height);
    this.mmd = a.aa(getContext(), a.c.video_segment_seekbar_padding);
    localObject = new RelativeLayout.LayoutParams(-1, i);
    addView(this.heQ, (ViewGroup.LayoutParams)localObject);
    this.mmc = new o(getContext());
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    addView(this.mmc, (ViewGroup.LayoutParams)localObject);
    this.mmc.setOnSliderTouchListener(this.mmh);
    this.heQ.a(this.mmg);
  }
  
  private void setViewWidth(int paramInt)
  {
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    localLayoutParams.width = paramInt;
    setLayoutParams(localLayoutParams);
  }
  
  public final void Ip(String paramString)
  {
    if ((bk.bl(paramString)) || (!e.bK(paramString)))
    {
      bjV();
      return;
    }
    this.path = paramString;
    post(this.mmf);
  }
  
  public final float bjK()
  {
    if (this.mmc == null) {
      return 0.0F;
    }
    float f = S(this.mmc.getLeftSliderBound(), false);
    y.d("RecyclerThumbSeekBar", "computeStartPercent x : [%d] ret[%f] seekLoopStartTime[%d] durationMs[%d]", new Object[] { Integer.valueOf(this.mmc.getLeftSliderBound()), Float.valueOf(f), Integer.valueOf(Math.round(this.eAx * f)), Integer.valueOf(this.eAx) });
    return f;
  }
  
  public final float bjL()
  {
    if (this.mmc == null) {
      return 0.0F;
    }
    float f = S(this.mmc.getRightSliderBound(), true);
    y.d("RecyclerThumbSeekBar", "computeEndPercent x : [%d] ret[%f] seekLoopEndTime[%d]", new Object[] { Integer.valueOf(this.mmc.getRightSliderBound()), Float.valueOf(f), Integer.valueOf(Math.round(this.eAx * f)) });
    return f;
  }
  
  public int getDurationMs()
  {
    return this.eAx;
  }
  
  public final void hv(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mmc.mmw = true;
      return;
    }
    this.mmc.mmw = false;
  }
  
  public final void release()
  {
    this.eAx = -1;
    this.path = null;
    Object localObject1;
    if (this.mme != null)
    {
      localObject1 = this.mme;
      if (((d.a)localObject1).mlt != null)
      {
        ((d.a)localObject1).kmn.lock();
        if (((d.a)localObject1).mlt != null) {
          break label138;
        }
        ((d.a)localObject1).kmn.unlock();
      }
    }
    for (;;)
    {
      if ((this.mmb == null) || (this.mmb.mmm == null)) {
        break label258;
      }
      localObject1 = this.mmb.mmm;
      if ((((RecyclerThumbSeekBar.d)localObject1).mmr != null) && (((RecyclerThumbSeekBar.d)localObject1).mmr.length != 0))
      {
        int i = 0;
        for (;;)
        {
          if (i < ((RecyclerThumbSeekBar.d)localObject1).mmr.length)
          {
            if (localObject1.mmr[i] != null)
            {
              localObject1.mmr[i].quit();
              ((RecyclerThumbSeekBar.d)localObject1).mmr[i] = null;
            }
            i += 1;
            continue;
            try
            {
              label138:
              Iterator localIterator = ((d.a)localObject1).mlt.iterator();
              while (localIterator.hasNext()) {
                ((d)localIterator.next()).release();
              }
            }
            catch (Exception localException)
            {
              y.printErrStackTrace("FetcherPool", localException, "destroy fetcher %s", new Object[] { localException.getMessage() });
              ((d.a)localObject1).mlt = null;
              ((d.a)localObject1).kmn.unlock();
              break;
              ((d.a)localObject1).mlt = null;
              ((d.a)localObject1).kmn.unlock();
              break;
            }
            finally
            {
              ((d.a)localObject1).mlt = null;
              ((d.a)localObject1).kmn.unlock();
            }
          }
        }
      }
    }
    this.mmb.mmm = null;
    this.mmb = null;
    label258:
    if (this.mmc != null)
    {
      localObject1 = this.mmc;
      if ((((o)localObject1).mmP != null) && (((o)localObject1).mmQ != null))
      {
        ((o)localObject1).mmz.setBounds(((o)localObject1).mmP);
        ((o)localObject1).mmA.setBounds(((o)localObject1).mmQ);
        ((o)localObject1).mmE = -1.0F;
        ((o)localObject1).postInvalidate();
      }
    }
  }
  
  public void setCurrentCursorPosition(float paramFloat)
  {
    float f2 = 0.0F;
    o localo = this.mmc;
    float f1 = f2;
    if (this.mmb != null)
    {
      if (this.heQ != null) {
        break label33;
      }
      f1 = f2;
    }
    for (;;)
    {
      localo.setCursorPos(f1);
      return;
      label33:
      paramFloat = this.mmb.getItemCount() * paramFloat;
      int i = (int)Math.floor(paramFloat);
      float f3 = i;
      Object localObject = this.heQ.bK(i + 1);
      f1 = f2;
      if (localObject != null)
      {
        localObject = ((RecyclerView.v)localObject).aie;
        f1 = ((View)localObject).getLeft();
        f1 = (((View)localObject).getWidth() * (paramFloat - f3) + f1) / getWidth();
      }
    }
  }
  
  public void setOnPreparedListener(c.a parama)
  {
    this.mlZ = parama;
  }
  
  public void setThumbBarSeekListener(c.b paramb)
  {
    this.mma = paramb;
  }
  
  public void setVideoTransPara(VideoTransPara paramVideoTransPara)
  {
    this.mgW = paramVideoTransPara;
  }
  
  private final class e
    extends RecyclerView.v
  {
    ImageView bNu;
    
    e(View paramView, int paramInt)
    {
      super();
      if (paramInt == 0) {
        this.bNu = ((ImageView)((LinearLayout)paramView).getChildAt(0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar
 * JD-Core Version:    0.7.0.1
 */