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
import com.tencent.mm.sdk.platformtools.ac;

public class VideoPlayerSeekBar
  extends AdVideoPlayerLoadingBar
  implements e.b
{
  protected boolean dhM;
  private PInt kVg;
  private int kVh;
  private int kVi;
  private int kVj;
  
  public VideoPlayerSeekBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(194611);
    this.kVg = new PInt();
    this.dhM = false;
    this.kVh = -1;
    this.kVi = -1;
    this.kVj = -1;
    AppMethodBeat.o(194611);
  }
  
  public VideoPlayerSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(194612);
    this.kVg = new PInt();
    this.dhM = false;
    this.kVh = -1;
    this.kVi = -1;
    this.kVj = -1;
    AppMethodBeat.o(194612);
  }
  
  public VideoPlayerSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(194613);
    this.kVg = new PInt();
    this.dhM = false;
    this.kVh = -1;
    this.kVi = -1;
    this.kVj = -1;
    AppMethodBeat.o(194613);
  }
  
  private int getBarPointPaddingLeft()
  {
    AppMethodBeat.i(194616);
    if (this.kVi == -1) {
      this.kVi = this.kUv.getPaddingLeft();
    }
    int i = this.kVi;
    AppMethodBeat.o(194616);
    return i;
  }
  
  private int getBarPointPaddingRight()
  {
    AppMethodBeat.i(194617);
    if (this.kVj == -1) {
      this.kVj = this.kUv.getPaddingRight();
    }
    int i = this.kVj;
    AppMethodBeat.o(194617);
    return i;
  }
  
  public void bkN()
  {
    AppMethodBeat.i(194621);
    if (this.kUz == 0)
    {
      AppMethodBeat.o(194621);
      return;
    }
    if (this.kwq)
    {
      AppMethodBeat.o(194621);
      return;
    }
    if (this.kUv == null)
    {
      AppMethodBeat.o(194621);
      return;
    }
    if (getBarLen() == 0)
    {
      AppMethodBeat.o(194621);
      return;
    }
    this.kUx.setText(sO(this.mPosition / 60) + ":" + sO(this.mPosition % 60));
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.kUv.getLayoutParams();
    int i = getBarLen();
    localLayoutParams.leftMargin = dY(this.mPosition, i);
    this.kUv.setLayoutParams(localLayoutParams);
    localLayoutParams = (FrameLayout.LayoutParams)this.kUt.getLayoutParams();
    localLayoutParams.width = ((int)(this.mPosition * 1.0D / this.kUz * i));
    this.kUt.setLayoutParams(localLayoutParams);
    requestLayout();
    AppMethodBeat.o(194621);
  }
  
  protected final int dY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194618);
    if (paramInt1 <= 0)
    {
      this.kUu.getLayoutParams();
      paramInt1 = 0;
    }
    for (;;)
    {
      AppMethodBeat.o(194618);
      return paramInt1;
      if (paramInt1 >= this.kUz) {
        paramInt1 = paramInt2 - (getBarPointWidth() - getBarPointPaddingLeft() - getBarPointPaddingRight()) / 2;
      } else {
        paramInt1 = (int)(paramInt1 * 1.0D / this.kUz * paramInt2);
      }
    }
  }
  
  public final void gL(boolean paramBoolean)
  {
    AppMethodBeat.i(194625);
    setIsPlay(paramBoolean);
    AppMethodBeat.o(194625);
  }
  
  protected int getBarPointWidth()
  {
    AppMethodBeat.i(194615);
    if (this.kVh == -1) {
      this.kVh = this.kUv.getWidth();
    }
    int i = this.kVh;
    AppMethodBeat.o(194615);
    return i;
  }
  
  protected int getLayoutId()
  {
    return 2131496137;
  }
  
  public ImageView getPlayBtn()
  {
    return this.kUw;
  }
  
  public TextView getPlaytimeTv()
  {
    return this.kUx;
  }
  
  protected void init()
  {
    AppMethodBeat.i(194614);
    this.contentView = View.inflate(getContext(), getLayoutId(), this);
    this.kUt = ((ImageView)this.contentView.findViewById(2131303302));
    this.kUu = ((ImageView)this.contentView.findViewById(2131303301));
    this.kUv = ((ImageView)this.contentView.findViewById(2131303305));
    this.kUw = ((ImageView)this.contentView.findViewById(2131303281));
    this.kUx = ((TextView)this.contentView.findViewById(2131303283));
    this.kUy = ((TextView)this.contentView.findViewById(2131303289));
    this.kUv.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(194610);
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          ac.i("MicroMsg.Video.VideoPlayerSeekBar", "ontouch down");
          VideoPlayerSeekBar.this.kwq = false;
          VideoPlayerSeekBar.this.kUC = paramAnonymousMotionEvent.getX();
          if (VideoPlayerSeekBar.this.kUs != null) {
            VideoPlayerSeekBar.this.kUs.anR();
          }
        }
        for (;;)
        {
          AppMethodBeat.o(194610);
          return true;
          int i;
          if (paramAnonymousMotionEvent.getAction() == 2)
          {
            float f = paramAnonymousMotionEvent.getX();
            paramAnonymousView = (FrameLayout.LayoutParams)VideoPlayerSeekBar.this.kUv.getLayoutParams();
            paramAnonymousMotionEvent = VideoPlayerSeekBar.this;
            i = paramAnonymousView.leftMargin;
            i = VideoPlayerSeekBar.a(paramAnonymousMotionEvent, (int)(f - VideoPlayerSeekBar.this.kUC) + i, VideoPlayerSeekBar.a(VideoPlayerSeekBar.this));
            paramAnonymousView.leftMargin = i;
            VideoPlayerSeekBar.this.kUv.setLayoutParams(paramAnonymousView);
            int j = VideoPlayerSeekBar.a(VideoPlayerSeekBar.this).value;
            if (VideoPlayerSeekBar.this.kUz > 0)
            {
              paramAnonymousView = (FrameLayout.LayoutParams)VideoPlayerSeekBar.this.kUt.getLayoutParams();
              paramAnonymousView.width = i;
              VideoPlayerSeekBar.this.kUt.setLayoutParams(paramAnonymousView);
            }
            VideoPlayerSeekBar.this.kUx.setText(VideoPlayerSeekBar.sO(j / 60) + ":" + VideoPlayerSeekBar.sO(j % 60));
            VideoPlayerSeekBar.this.kwq = true;
          }
          else
          {
            i = VideoPlayerSeekBar.this.mPosition;
            if (VideoPlayerSeekBar.this.kwq)
            {
              paramAnonymousView = VideoPlayerSeekBar.this;
              i = VideoPlayerSeekBar.a(VideoPlayerSeekBar.this).value;
              paramAnonymousView.mPosition = i;
            }
            if (VideoPlayerSeekBar.this.kUs != null)
            {
              ac.i("MicroMsg.Video.VideoPlayerSeekBar", "current time : ".concat(String.valueOf(i)));
              VideoPlayerSeekBar.this.kUs.nn(i);
            }
            VideoPlayerSeekBar.this.kwq = false;
          }
        }
      }
    });
    AppMethodBeat.o(194614);
  }
  
  public final void sQ(int paramInt)
  {
    AppMethodBeat.i(194624);
    seek(paramInt);
    AppMethodBeat.o(194624);
  }
  
  public void seek(int paramInt)
  {
    AppMethodBeat.i(194619);
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    paramInt = i;
    if (i >= this.kUz) {
      paramInt = this.kUz;
    }
    if (this.mPosition != paramInt)
    {
      this.mPosition = paramInt;
      bkN();
    }
    AppMethodBeat.o(194619);
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(194623);
    this.dhM = paramBoolean;
    super.setIsPlay(paramBoolean);
    AppMethodBeat.o(194623);
  }
  
  public void setPlayBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(194622);
    if (this.kUw != null) {
      this.kUw.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(194622);
  }
  
  public void setVideoTotalTime(int paramInt)
  {
    AppMethodBeat.i(194620);
    this.kUz = paramInt;
    this.mPosition = 0;
    this.kUy.setText(sO(this.kUz / 60) + ":" + sO(this.kUz % 60));
    bkN();
    AppMethodBeat.o(194620);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.VideoPlayerSeekBar
 * JD-Core Version:    0.7.0.1
 */