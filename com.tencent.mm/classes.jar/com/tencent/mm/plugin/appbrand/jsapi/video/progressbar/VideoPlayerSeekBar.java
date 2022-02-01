package com.tencent.mm.plugin.appbrand.jsapi.video.progressbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.d;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ad;

public class VideoPlayerSeekBar
  extends AdVideoPlayerLoadingBar
  implements e.b
{
  protected boolean dkr;
  private PInt ktR;
  private int ktS;
  private int ktT;
  private int ktU;
  
  public VideoPlayerSeekBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(194266);
    this.ktR = new PInt();
    this.dkr = false;
    this.ktS = -1;
    this.ktT = -1;
    this.ktU = -1;
    AppMethodBeat.o(194266);
  }
  
  public VideoPlayerSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(194267);
    this.ktR = new PInt();
    this.dkr = false;
    this.ktS = -1;
    this.ktT = -1;
    this.ktU = -1;
    AppMethodBeat.o(194267);
  }
  
  public VideoPlayerSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(194268);
    this.ktR = new PInt();
    this.dkr = false;
    this.ktS = -1;
    this.ktT = -1;
    this.ktU = -1;
    AppMethodBeat.o(194268);
  }
  
  private int getBarPointPaddingLeft()
  {
    AppMethodBeat.i(194271);
    if (this.ktT == -1) {
      this.ktT = this.ktg.getPaddingLeft();
    }
    int i = this.ktT;
    AppMethodBeat.o(194271);
    return i;
  }
  
  private int getBarPointPaddingRight()
  {
    AppMethodBeat.i(194272);
    if (this.ktU == -1) {
      this.ktU = this.ktg.getPaddingRight();
    }
    int i = this.ktU;
    AppMethodBeat.o(194272);
    return i;
  }
  
  public void bdT()
  {
    AppMethodBeat.i(194276);
    if (this.ktk == 0)
    {
      AppMethodBeat.o(194276);
      return;
    }
    if (this.jVE)
    {
      AppMethodBeat.o(194276);
      return;
    }
    if (this.ktg == null)
    {
      AppMethodBeat.o(194276);
      return;
    }
    if (getBarLen() == 0)
    {
      AppMethodBeat.o(194276);
      return;
    }
    this.kti.setText(rX(this.mPosition / 60) + ":" + rX(this.mPosition % 60));
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.ktg.getLayoutParams();
    int i = getBarLen();
    localLayoutParams.leftMargin = dX(this.mPosition, i);
    this.ktg.setLayoutParams(localLayoutParams);
    localLayoutParams = (FrameLayout.LayoutParams)this.kte.getLayoutParams();
    localLayoutParams.width = ((int)(this.mPosition * 1.0D / this.ktk * i));
    this.kte.setLayoutParams(localLayoutParams);
    requestLayout();
    AppMethodBeat.o(194276);
  }
  
  protected final int dX(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194273);
    if (paramInt1 <= 0)
    {
      this.ktf.getLayoutParams();
      paramInt1 = 0;
    }
    for (;;)
    {
      AppMethodBeat.o(194273);
      return paramInt1;
      if (paramInt1 >= this.ktk) {
        paramInt1 = paramInt2 - (getBarPointWidth() - getBarPointPaddingLeft() - getBarPointPaddingRight()) / 2;
      } else {
        paramInt1 = (int)(paramInt1 * 1.0D / this.ktk * paramInt2);
      }
    }
  }
  
  protected int getBarPointWidth()
  {
    AppMethodBeat.i(194270);
    if (this.ktS == -1) {
      this.ktS = this.ktg.getWidth();
    }
    int i = this.ktS;
    AppMethodBeat.o(194270);
    return i;
  }
  
  protected int getLayoutId()
  {
    return 2131496137;
  }
  
  public ImageView getPlayBtn()
  {
    return this.kth;
  }
  
  public TextView getPlaytimeTv()
  {
    return this.kti;
  }
  
  public final void gp(boolean paramBoolean)
  {
    AppMethodBeat.i(194280);
    setIsPlay(paramBoolean);
    AppMethodBeat.o(194280);
  }
  
  protected void init()
  {
    AppMethodBeat.i(194269);
    this.contentView = View.inflate(getContext(), getLayoutId(), this);
    this.kte = ((ImageView)this.contentView.findViewById(2131303302));
    this.ktf = ((ImageView)this.contentView.findViewById(2131303301));
    this.ktg = ((ImageView)this.contentView.findViewById(2131303305));
    this.kth = ((ImageView)this.contentView.findViewById(2131303281));
    this.kti = ((TextView)this.contentView.findViewById(2131303283));
    this.ktj = ((TextView)this.contentView.findViewById(2131303289));
    this.ktg.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(194265);
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          ad.i("MicroMsg.Video.VideoPlayerSeekBar", "ontouch down");
          VideoPlayerSeekBar.this.jVE = false;
          VideoPlayerSeekBar.this.ktn = paramAnonymousMotionEvent.getX();
          if (VideoPlayerSeekBar.this.ktd != null) {
            VideoPlayerSeekBar.this.ktd.bcv();
          }
        }
        for (;;)
        {
          AppMethodBeat.o(194265);
          return true;
          int i;
          if (paramAnonymousMotionEvent.getAction() == 2)
          {
            float f = paramAnonymousMotionEvent.getX();
            paramAnonymousView = (FrameLayout.LayoutParams)VideoPlayerSeekBar.this.ktg.getLayoutParams();
            paramAnonymousMotionEvent = VideoPlayerSeekBar.this;
            i = paramAnonymousView.leftMargin;
            i = VideoPlayerSeekBar.a(paramAnonymousMotionEvent, (int)(f - VideoPlayerSeekBar.this.ktn) + i, VideoPlayerSeekBar.a(VideoPlayerSeekBar.this));
            paramAnonymousView.leftMargin = i;
            VideoPlayerSeekBar.this.ktg.setLayoutParams(paramAnonymousView);
            int j = VideoPlayerSeekBar.a(VideoPlayerSeekBar.this).value;
            if (VideoPlayerSeekBar.this.ktk > 0)
            {
              paramAnonymousView = (FrameLayout.LayoutParams)VideoPlayerSeekBar.this.kte.getLayoutParams();
              paramAnonymousView.width = i;
              VideoPlayerSeekBar.this.kte.setLayoutParams(paramAnonymousView);
            }
            VideoPlayerSeekBar.this.kti.setText(VideoPlayerSeekBar.rX(j / 60) + ":" + VideoPlayerSeekBar.rX(j % 60));
            VideoPlayerSeekBar.this.jVE = true;
          }
          else
          {
            i = VideoPlayerSeekBar.this.mPosition;
            if (VideoPlayerSeekBar.this.jVE)
            {
              paramAnonymousView = VideoPlayerSeekBar.this;
              i = VideoPlayerSeekBar.a(VideoPlayerSeekBar.this).value;
              paramAnonymousView.mPosition = i;
            }
            if (VideoPlayerSeekBar.this.ktd != null)
            {
              ad.i("MicroMsg.Video.VideoPlayerSeekBar", "current time : ".concat(String.valueOf(i)));
              VideoPlayerSeekBar.this.ktd.rZ(i);
            }
            VideoPlayerSeekBar.this.jVE = false;
          }
        }
      }
    });
    AppMethodBeat.o(194269);
  }
  
  public final void sa(int paramInt)
  {
    AppMethodBeat.i(194279);
    seek(paramInt);
    AppMethodBeat.o(194279);
  }
  
  public void seek(int paramInt)
  {
    AppMethodBeat.i(194274);
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    paramInt = i;
    if (i >= this.ktk) {
      paramInt = this.ktk;
    }
    if (this.mPosition != paramInt)
    {
      this.mPosition = paramInt;
      bdT();
    }
    AppMethodBeat.o(194274);
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(194278);
    this.dkr = paramBoolean;
    super.setIsPlay(paramBoolean);
    AppMethodBeat.o(194278);
  }
  
  public void setPlayBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(194277);
    if (this.kth != null) {
      this.kth.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(194277);
  }
  
  public void setVideoTotalTime(int paramInt)
  {
    AppMethodBeat.i(194275);
    this.ktk = paramInt;
    this.mPosition = 0;
    this.ktj.setText(rX(this.ktk / 60) + ":" + rX(this.ktk % 60));
    bdT();
    AppMethodBeat.o(194275);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.VideoPlayerSeekBar
 * JD-Core Version:    0.7.0.1
 */