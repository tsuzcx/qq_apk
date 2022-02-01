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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.d;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ad;

public class VideoPlayerSeekBar
  extends AdVideoPlayerLoadingBar
  implements e.b
{
  protected boolean dtk;
  private PInt lse;
  private int lsg;
  private int lsh;
  private int lsi;
  
  public VideoPlayerSeekBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(206423);
    this.lse = new PInt();
    this.dtk = false;
    this.lsg = -1;
    this.lsh = -1;
    this.lsi = -1;
    AppMethodBeat.o(206423);
  }
  
  public VideoPlayerSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(206424);
    this.lse = new PInt();
    this.dtk = false;
    this.lsg = -1;
    this.lsh = -1;
    this.lsi = -1;
    AppMethodBeat.o(206424);
  }
  
  public VideoPlayerSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(206425);
    this.lse = new PInt();
    this.dtk = false;
    this.lsg = -1;
    this.lsh = -1;
    this.lsi = -1;
    AppMethodBeat.o(206425);
  }
  
  private int getBarPointPaddingLeft()
  {
    AppMethodBeat.i(206428);
    if (this.lsh == -1) {
      this.lsh = this.lrt.getPaddingLeft();
    }
    int i = this.lsh;
    AppMethodBeat.o(206428);
    return i;
  }
  
  private int getBarPointPaddingRight()
  {
    AppMethodBeat.i(206429);
    if (this.lsi == -1) {
      this.lsi = this.lrt.getPaddingRight();
    }
    int i = this.lsi;
    AppMethodBeat.o(206429);
    return i;
  }
  
  public void boy()
  {
    AppMethodBeat.i(206433);
    if (this.lrx == 0)
    {
      AppMethodBeat.o(206433);
      return;
    }
    if (this.kSw)
    {
      AppMethodBeat.o(206433);
      return;
    }
    if (this.lrt == null)
    {
      AppMethodBeat.o(206433);
      return;
    }
    if (getBarLen() == 0)
    {
      AppMethodBeat.o(206433);
      return;
    }
    this.lrv.setText(tr(this.mPosition / 60) + ":" + tr(this.mPosition % 60));
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.lrt.getLayoutParams();
    int i = getBarLen();
    localLayoutParams.leftMargin = ea(this.mPosition, i);
    this.lrt.setLayoutParams(localLayoutParams);
    localLayoutParams = (FrameLayout.LayoutParams)this.lrr.getLayoutParams();
    localLayoutParams.width = ((int)(this.mPosition * 1.0D / this.lrx * i));
    this.lrr.setLayoutParams(localLayoutParams);
    requestLayout();
    AppMethodBeat.o(206433);
  }
  
  protected final int ea(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(206430);
    if (paramInt1 <= 0)
    {
      this.lrs.getLayoutParams();
      paramInt1 = 0;
    }
    for (;;)
    {
      AppMethodBeat.o(206430);
      return paramInt1;
      if (paramInt1 >= this.lrx) {
        paramInt1 = paramInt2 - (getBarPointWidth() - getBarPointPaddingLeft() - getBarPointPaddingRight()) / 2;
      } else {
        paramInt1 = (int)(paramInt1 * 1.0D / this.lrx * paramInt2);
      }
    }
  }
  
  public final void gS(boolean paramBoolean)
  {
    AppMethodBeat.i(206437);
    setIsPlay(paramBoolean);
    AppMethodBeat.o(206437);
  }
  
  protected int getBarPointWidth()
  {
    AppMethodBeat.i(206427);
    if (this.lsg == -1) {
      this.lsg = this.lrt.getWidth();
    }
    int i = this.lsg;
    AppMethodBeat.o(206427);
    return i;
  }
  
  protected int getLayoutId()
  {
    return 2131496137;
  }
  
  public ImageView getPlayBtn()
  {
    return this.lru;
  }
  
  public TextView getPlaytimeTv()
  {
    return this.lrv;
  }
  
  protected void init()
  {
    AppMethodBeat.i(206426);
    this.contentView = View.inflate(getContext(), getLayoutId(), this);
    this.lrr = ((ImageView)this.contentView.findViewById(2131303302));
    this.lrs = ((ImageView)this.contentView.findViewById(2131303301));
    this.lrt = ((ImageView)this.contentView.findViewById(2131303305));
    this.lru = ((ImageView)this.contentView.findViewById(2131303281));
    this.lrv = ((TextView)this.contentView.findViewById(2131303283));
    this.lrw = ((TextView)this.contentView.findViewById(2131303289));
    this.lrt.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(206422);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        a.b("com/tencent/mm/plugin/appbrand/jsapi/video/progressbar/VideoPlayerSeekBar$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          ad.i("MicroMsg.Video.VideoPlayerSeekBar", "ontouch down");
          VideoPlayerSeekBar.this.kSw = false;
          VideoPlayerSeekBar.this.lrA = paramAnonymousMotionEvent.getX();
          if (VideoPlayerSeekBar.this.lrq != null) {
            VideoPlayerSeekBar.this.lrq.aqD();
          }
        }
        for (;;)
        {
          a.a(true, this, "com/tencent/mm/plugin/appbrand/jsapi/video/progressbar/VideoPlayerSeekBar$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(206422);
          return true;
          int i;
          if (paramAnonymousMotionEvent.getAction() == 2)
          {
            float f = paramAnonymousMotionEvent.getX();
            paramAnonymousView = (FrameLayout.LayoutParams)VideoPlayerSeekBar.this.lrt.getLayoutParams();
            paramAnonymousMotionEvent = VideoPlayerSeekBar.this;
            i = paramAnonymousView.leftMargin;
            i = VideoPlayerSeekBar.a(paramAnonymousMotionEvent, (int)(f - VideoPlayerSeekBar.this.lrA) + i, VideoPlayerSeekBar.a(VideoPlayerSeekBar.this));
            paramAnonymousView.leftMargin = i;
            VideoPlayerSeekBar.this.lrt.setLayoutParams(paramAnonymousView);
            int j = VideoPlayerSeekBar.a(VideoPlayerSeekBar.this).value;
            if (VideoPlayerSeekBar.this.lrx > 0)
            {
              paramAnonymousView = (FrameLayout.LayoutParams)VideoPlayerSeekBar.this.lrr.getLayoutParams();
              paramAnonymousView.width = i;
              VideoPlayerSeekBar.this.lrr.setLayoutParams(paramAnonymousView);
            }
            VideoPlayerSeekBar.this.lrv.setText(VideoPlayerSeekBar.tr(j / 60) + ":" + VideoPlayerSeekBar.tr(j % 60));
            VideoPlayerSeekBar.this.kSw = true;
          }
          else
          {
            i = VideoPlayerSeekBar.this.mPosition;
            if (VideoPlayerSeekBar.this.kSw)
            {
              paramAnonymousView = VideoPlayerSeekBar.this;
              i = VideoPlayerSeekBar.a(VideoPlayerSeekBar.this).value;
              paramAnonymousView.mPosition = i;
            }
            if (VideoPlayerSeekBar.this.lrq != null)
            {
              ad.i("MicroMsg.Video.VideoPlayerSeekBar", "current time : ".concat(String.valueOf(i)));
              VideoPlayerSeekBar.this.lrq.nM(i);
            }
            VideoPlayerSeekBar.this.kSw = false;
          }
        }
      }
    });
    AppMethodBeat.o(206426);
  }
  
  public void seek(int paramInt)
  {
    AppMethodBeat.i(206431);
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    paramInt = i;
    if (i >= this.lrx) {
      paramInt = this.lrx;
    }
    if (this.mPosition != paramInt)
    {
      this.mPosition = paramInt;
      boy();
    }
    AppMethodBeat.o(206431);
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(206435);
    this.dtk = paramBoolean;
    super.setIsPlay(paramBoolean);
    AppMethodBeat.o(206435);
  }
  
  public void setPlayBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(206434);
    if (this.lru != null) {
      this.lru.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(206434);
  }
  
  public void setVideoTotalTime(int paramInt)
  {
    AppMethodBeat.i(206432);
    this.lrx = paramInt;
    this.mPosition = 0;
    this.lrw.setText(tr(this.lrx / 60) + ":" + tr(this.lrx % 60));
    boy();
    AppMethodBeat.o(206432);
  }
  
  public final void tt(int paramInt)
  {
    AppMethodBeat.i(206436);
    seek(paramInt);
    AppMethodBeat.o(206436);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.VideoPlayerSeekBar
 * JD-Core Version:    0.7.0.1
 */