package com.tencent.mm.plugin.mmsight.segment;

import android.content.Context;
import android.os.HandlerThread;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.v;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;

public class RecyclerThumbSeekBar
  extends RelativeLayout
  implements c
{
  private int fQq;
  private int fgQ;
  private int fgR;
  private RecyclerView iQe;
  private VideoTransPara oHk;
  private int oLf;
  private c.a oLg;
  private c.b oLh;
  private RecyclerThumbSeekBar.c oLi;
  private n oLj;
  private int oLk;
  private d.a oLl;
  private Runnable oLm;
  private RecyclerView.m oLn;
  private n.a oLo;
  private String path;
  
  public RecyclerThumbSeekBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(54996);
    this.fQq = -1;
    this.oLl = new d.a(4, new RecyclerThumbSeekBar.1(this));
    this.oLm = new RecyclerThumbSeekBar.2(this);
    this.oLn = new RecyclerThumbSeekBar.5(this);
    this.oLo = new RecyclerThumbSeekBar.6(this);
    init();
    AppMethodBeat.o(54996);
  }
  
  public RecyclerThumbSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(54997);
    this.fQq = -1;
    this.oLl = new d.a(4, new RecyclerThumbSeekBar.1(this));
    this.oLm = new RecyclerThumbSeekBar.2(this);
    this.oLn = new RecyclerThumbSeekBar.5(this);
    this.oLo = new RecyclerThumbSeekBar.6(this);
    init();
    AppMethodBeat.o(54997);
  }
  
  public RecyclerThumbSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(54998);
    this.fQq = -1;
    this.oLl = new d.a(4, new RecyclerThumbSeekBar.1(this));
    this.oLm = new RecyclerThumbSeekBar.2(this);
    this.oLn = new RecyclerThumbSeekBar.5(this);
    this.oLo = new RecyclerThumbSeekBar.6(this);
    init();
    AppMethodBeat.o(54998);
  }
  
  private float aa(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(55007);
    if ((this.oLi == null) || (this.iQe == null))
    {
      AppMethodBeat.o(55007);
      return 0.0F;
    }
    View localView = this.iQe.x(paramInt, 0.0F);
    if (localView == null)
    {
      ab.w("RecyclerThumbSeekBar", "getPositionInTotalRange x[%d] isEnd[%b], view is null.", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(55007);
      return 0.0F;
    }
    int i = RecyclerView.bq(localView);
    int j = this.oLi.getItemCount();
    if (i <= 1)
    {
      AppMethodBeat.o(55007);
      return 0.0F;
    }
    if (i >= j - 1)
    {
      AppMethodBeat.o(55007);
      return 1.0F;
    }
    float f = (i - 1 + (paramInt - localView.getLeft()) / localView.getWidth()) / (j - 2);
    AppMethodBeat.o(55007);
    return f;
  }
  
  private void bRI()
  {
    AppMethodBeat.i(55003);
    al.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(54980);
        if (RecyclerThumbSeekBar.o(RecyclerThumbSeekBar.this) != null) {
          RecyclerThumbSeekBar.o(RecyclerThumbSeekBar.this).jp(true);
        }
        AppMethodBeat.o(54980);
      }
    });
    AppMethodBeat.o(55003);
  }
  
  private void init()
  {
    AppMethodBeat.i(54999);
    this.iQe = new RecyclerView(getContext());
    getContext();
    Object localObject = new LinearLayoutManager(0);
    this.iQe.setLayoutManager((RecyclerView.i)localObject);
    this.iQe.setHasFixedSize(true);
    int i = a.ao(getContext(), 2131428781);
    this.oLk = a.ao(getContext(), 2131428780);
    localObject = new RelativeLayout.LayoutParams(-1, i);
    addView(this.iQe, (ViewGroup.LayoutParams)localObject);
    this.oLj = new n(getContext());
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    addView(this.oLj, (ViewGroup.LayoutParams)localObject);
    this.oLj.setOnSliderTouchListener(this.oLo);
    this.iQe.a(this.oLn);
    AppMethodBeat.o(54999);
  }
  
  private void setViewWidth(int paramInt)
  {
    AppMethodBeat.i(55002);
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    localLayoutParams.width = paramInt;
    setLayoutParams(localLayoutParams);
    AppMethodBeat.o(55002);
  }
  
  public final void Ub(String paramString)
  {
    AppMethodBeat.i(55001);
    if ((bo.isNullOrNil(paramString)) || (!e.cN(paramString)))
    {
      bRI();
      AppMethodBeat.o(55001);
      return;
    }
    this.path = paramString;
    post(this.oLm);
    AppMethodBeat.o(55001);
  }
  
  public final float bRy()
  {
    AppMethodBeat.i(55005);
    if (this.oLj == null)
    {
      AppMethodBeat.o(55005);
      return 0.0F;
    }
    float f = aa(this.oLj.getLeftSliderBound(), false);
    ab.d("RecyclerThumbSeekBar", "computeStartPercent x : [%d] ret[%f] seekLoopStartTime[%d] durationMs[%d]", new Object[] { Integer.valueOf(this.oLj.getLeftSliderBound()), Float.valueOf(f), Integer.valueOf(Math.round(this.fQq * f)), Integer.valueOf(this.fQq) });
    AppMethodBeat.o(55005);
    return f;
  }
  
  public final float bRz()
  {
    AppMethodBeat.i(55006);
    if (this.oLj == null)
    {
      AppMethodBeat.o(55006);
      return 0.0F;
    }
    float f = aa(this.oLj.getRightSliderBound(), true);
    ab.d("RecyclerThumbSeekBar", "computeEndPercent x : [%d] ret[%f] seekLoopEndTime[%d]", new Object[] { Integer.valueOf(this.oLj.getRightSliderBound()), Float.valueOf(f), Integer.valueOf(Math.round(this.fQq * f)) });
    AppMethodBeat.o(55006);
    return f;
  }
  
  public int getDurationMs()
  {
    return this.fQq;
  }
  
  public final void jo(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.oLj.oLE = true;
      return;
    }
    this.oLj.oLE = false;
  }
  
  public final void release()
  {
    AppMethodBeat.i(55004);
    this.fQq = -1;
    this.path = null;
    if (this.oLl != null) {
      this.oLl.destroy();
    }
    if ((this.oLi != null) && (this.oLi.oLu != null))
    {
      RecyclerThumbSeekBar.d locald = this.oLi.oLu;
      if ((locald.oLz != null) && (locald.oLz.length != 0))
      {
        int i = 0;
        while (i < locald.oLz.length)
        {
          if (locald.oLz[i] != null)
          {
            locald.oLz[i].quit();
            locald.oLz[i] = null;
          }
          i += 1;
        }
      }
      this.oLi.oLu = null;
      this.oLi = null;
    }
    if (this.oLj != null) {
      this.oLj.reset();
    }
    AppMethodBeat.o(55004);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(140575);
    if (this.oLj != null) {
      this.oLj.reset();
    }
    AppMethodBeat.o(140575);
  }
  
  public void setCurrentCursorPosition(float paramFloat)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(55000);
    n localn = this.oLj;
    float f1 = f2;
    if (this.oLi != null)
    {
      if (this.iQe != null) {
        break label45;
      }
      f1 = f2;
    }
    for (;;)
    {
      localn.setCursorPos(f1);
      AppMethodBeat.o(55000);
      return;
      label45:
      paramFloat = this.oLi.getItemCount() * paramFloat;
      int i = (int)Math.floor(paramFloat);
      float f3 = i;
      Object localObject = this.iQe.bQ(i + 1);
      f1 = f2;
      if (localObject != null)
      {
        localObject = ((RecyclerView.v)localObject).aku;
        f1 = ((View)localObject).getLeft();
        f1 = (((View)localObject).getWidth() * (paramFloat - f3) + f1) / getWidth();
      }
    }
  }
  
  public void setOnPreparedListener(c.a parama)
  {
    this.oLg = parama;
  }
  
  public void setThumbBarSeekListener(c.b paramb)
  {
    this.oLh = paramb;
  }
  
  public void setVideoTransPara(VideoTransPara paramVideoTransPara)
  {
    this.oHk = paramVideoTransPara;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar
 * JD-Core Version:    0.7.0.1
 */