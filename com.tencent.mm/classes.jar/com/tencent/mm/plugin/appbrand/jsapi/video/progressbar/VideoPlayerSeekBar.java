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
import com.tencent.luggage.b.d.a.c;
import com.tencent.luggage.b.d.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.d;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.Log;

public class VideoPlayerSeekBar
  extends AdVideoPlayerLoadingBar
  implements d.b
{
  protected boolean fEq;
  private PInt pCM;
  private int pCN;
  private int pCO;
  private int pCP;
  
  public VideoPlayerSeekBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(228160);
    this.pCM = new PInt();
    this.fEq = false;
    this.pCN = -1;
    this.pCO = -1;
    this.pCP = -1;
    AppMethodBeat.o(228160);
  }
  
  public VideoPlayerSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(228161);
    this.pCM = new PInt();
    this.fEq = false;
    this.pCN = -1;
    this.pCO = -1;
    this.pCP = -1;
    AppMethodBeat.o(228161);
  }
  
  public VideoPlayerSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(228163);
    this.pCM = new PInt();
    this.fEq = false;
    this.pCN = -1;
    this.pCO = -1;
    this.pCP = -1;
    AppMethodBeat.o(228163);
  }
  
  private int getBarPointPaddingLeft()
  {
    AppMethodBeat.i(228170);
    if (this.pCO == -1) {
      this.pCO = this.pCb.getPaddingLeft();
    }
    int i = this.pCO;
    AppMethodBeat.o(228170);
    return i;
  }
  
  private int getBarPointPaddingRight()
  {
    AppMethodBeat.i(228172);
    if (this.pCP == -1) {
      this.pCP = this.pCb.getPaddingRight();
    }
    int i = this.pCP;
    AppMethodBeat.o(228172);
    return i;
  }
  
  public final void AS(int paramInt)
  {
    AppMethodBeat.i(228187);
    seek(paramInt);
    AppMethodBeat.o(228187);
  }
  
  public void bWO()
  {
    AppMethodBeat.i(228181);
    if (this.pCf == 0)
    {
      AppMethodBeat.o(228181);
      return;
    }
    if (this.oZf)
    {
      AppMethodBeat.o(228181);
      return;
    }
    if (this.pCb == null)
    {
      AppMethodBeat.o(228181);
      return;
    }
    if (getBarLen() == 0)
    {
      AppMethodBeat.o(228181);
      return;
    }
    this.pCd.setText(AQ(this.mPosition / 60) + ":" + AQ(this.mPosition % 60));
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.pCb.getLayoutParams();
    int i = getBarLen();
    localLayoutParams.leftMargin = eL(this.mPosition, i);
    this.pCb.setLayoutParams(localLayoutParams);
    localLayoutParams = (FrameLayout.LayoutParams)this.pBZ.getLayoutParams();
    localLayoutParams.width = ((int)(this.mPosition * 1.0D / this.pCf * i));
    this.pBZ.setLayoutParams(localLayoutParams);
    requestLayout();
    AppMethodBeat.o(228181);
  }
  
  protected final int eL(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(228174);
    if (paramInt1 <= 0)
    {
      this.pCa.getLayoutParams();
      paramInt1 = 0;
    }
    for (;;)
    {
      AppMethodBeat.o(228174);
      return paramInt1;
      if (paramInt1 >= this.pCf) {
        paramInt1 = paramInt2 - (getBarPointWidth() - getBarPointPaddingLeft() - getBarPointPaddingRight()) / 2;
      } else {
        paramInt1 = (int)(paramInt1 * 1.0D / this.pCf * paramInt2);
      }
    }
  }
  
  protected int getBarPointWidth()
  {
    AppMethodBeat.i(228167);
    if (this.pCN == -1) {
      this.pCN = this.pCb.getWidth();
    }
    int i = this.pCN;
    AppMethodBeat.o(228167);
    return i;
  }
  
  protected int getLayoutId()
  {
    return a.d.app_brand_video_player_seek_bar;
  }
  
  public ImageView getPlayBtn()
  {
    return this.pCc;
  }
  
  public TextView getPlaytimeTv()
  {
    return this.pCd;
  }
  
  public void iF(boolean paramBoolean)
  {
    AppMethodBeat.i(228188);
    setIsPlay(paramBoolean);
    AppMethodBeat.o(228188);
  }
  
  protected void init()
  {
    AppMethodBeat.i(228165);
    this.contentView = View.inflate(getContext(), getLayoutId(), this);
    this.pBZ = ((ImageView)this.contentView.findViewById(a.c.player_progress_bar_front));
    this.pCa = ((ImageView)this.contentView.findViewById(a.c.player_progress_bar_background));
    this.pCb = ((ImageView)this.contentView.findViewById(a.c.player_progress_point));
    this.pCc = ((ImageView)this.contentView.findViewById(a.c.play_btn));
    this.pCd = ((TextView)this.contentView.findViewById(a.c.play_current_time_tv));
    this.pCe = ((TextView)this.contentView.findViewById(a.c.play_total_time_tv));
    this.pCb.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(230346);
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          Log.i("MicroMsg.Video.VideoPlayerSeekBar", "ontouch down");
          VideoPlayerSeekBar.this.oZf = false;
          VideoPlayerSeekBar.this.pCi = paramAnonymousMotionEvent.getX();
          if (VideoPlayerSeekBar.this.pBY != null) {
            VideoPlayerSeekBar.this.pBY.aRo();
          }
        }
        for (;;)
        {
          AppMethodBeat.o(230346);
          return true;
          int i;
          if (paramAnonymousMotionEvent.getAction() == 2)
          {
            float f = paramAnonymousMotionEvent.getX();
            paramAnonymousView = (FrameLayout.LayoutParams)VideoPlayerSeekBar.this.pCb.getLayoutParams();
            paramAnonymousMotionEvent = VideoPlayerSeekBar.this;
            i = paramAnonymousView.leftMargin;
            i = VideoPlayerSeekBar.a(paramAnonymousMotionEvent, (int)(f - VideoPlayerSeekBar.this.pCi) + i, VideoPlayerSeekBar.a(VideoPlayerSeekBar.this));
            paramAnonymousView.leftMargin = i;
            VideoPlayerSeekBar.this.pCb.setLayoutParams(paramAnonymousView);
            int j = VideoPlayerSeekBar.a(VideoPlayerSeekBar.this).value;
            if (VideoPlayerSeekBar.this.pCf > 0)
            {
              paramAnonymousView = (FrameLayout.LayoutParams)VideoPlayerSeekBar.this.pBZ.getLayoutParams();
              paramAnonymousView.width = i;
              VideoPlayerSeekBar.this.pBZ.setLayoutParams(paramAnonymousView);
            }
            VideoPlayerSeekBar.this.pCd.setText(VideoPlayerSeekBar.AQ(j / 60) + ":" + VideoPlayerSeekBar.AQ(j % 60));
            VideoPlayerSeekBar.this.oZf = true;
          }
          else
          {
            i = VideoPlayerSeekBar.this.mPosition;
            if (VideoPlayerSeekBar.this.oZf)
            {
              paramAnonymousView = VideoPlayerSeekBar.this;
              i = VideoPlayerSeekBar.a(VideoPlayerSeekBar.this).value;
              paramAnonymousView.mPosition = i;
            }
            if (VideoPlayerSeekBar.this.pBY != null)
            {
              Log.i("MicroMsg.Video.VideoPlayerSeekBar", "current time : ".concat(String.valueOf(i)));
              VideoPlayerSeekBar.this.pBY.tY(i);
            }
            VideoPlayerSeekBar.this.oZf = false;
          }
        }
      }
    });
    AppMethodBeat.o(228165);
  }
  
  public void seek(int paramInt)
  {
    AppMethodBeat.i(228177);
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    paramInt = i;
    if (i >= this.pCf) {
      paramInt = this.pCf;
    }
    if (this.mPosition != paramInt)
    {
      this.mPosition = paramInt;
      bWO();
    }
    AppMethodBeat.o(228177);
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(228185);
    this.fEq = paramBoolean;
    super.setIsPlay(paramBoolean);
    AppMethodBeat.o(228185);
  }
  
  public void setPlayBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(228182);
    if (this.pCc != null) {
      this.pCc.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(228182);
  }
  
  public void setVideoTotalTime(int paramInt)
  {
    AppMethodBeat.i(228179);
    this.pCf = paramInt;
    this.mPosition = 0;
    this.pCe.setText(AQ(this.pCf / 60) + ":" + AQ(this.pCf % 60));
    bWO();
    AppMethodBeat.o(228179);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.VideoPlayerSeekBar
 * JD-Core Version:    0.7.0.1
 */