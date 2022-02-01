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
  protected boolean hJg;
  private PInt sHY;
  private int sHZ;
  private int sIa;
  private int sIb;
  
  public VideoPlayerSeekBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(328250);
    this.sHY = new PInt();
    this.hJg = false;
    this.sHZ = -1;
    this.sIa = -1;
    this.sIb = -1;
    AppMethodBeat.o(328250);
  }
  
  public VideoPlayerSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(328254);
    this.sHY = new PInt();
    this.hJg = false;
    this.sHZ = -1;
    this.sIa = -1;
    this.sIb = -1;
    AppMethodBeat.o(328254);
  }
  
  public VideoPlayerSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(328260);
    this.sHY = new PInt();
    this.hJg = false;
    this.sHZ = -1;
    this.sIa = -1;
    this.sIb = -1;
    AppMethodBeat.o(328260);
  }
  
  private int getBarPointPaddingLeft()
  {
    AppMethodBeat.i(328264);
    if (this.sIa == -1) {
      this.sIa = this.sHo.getPaddingLeft();
    }
    int i = this.sIa;
    AppMethodBeat.o(328264);
    return i;
  }
  
  private int getBarPointPaddingRight()
  {
    AppMethodBeat.i(328268);
    if (this.sIb == -1) {
      this.sIb = this.sHo.getPaddingRight();
    }
    int i = this.sIb;
    AppMethodBeat.o(328268);
    return i;
  }
  
  public final void Bh(int paramInt)
  {
    AppMethodBeat.i(328372);
    seek(paramInt);
    AppMethodBeat.o(328372);
  }
  
  public void cxb()
  {
    AppMethodBeat.i(328353);
    if (this.cqW == 0)
    {
      AppMethodBeat.o(328353);
      return;
    }
    if (this.seH)
    {
      AppMethodBeat.o(328353);
      return;
    }
    if (this.sHo == null)
    {
      AppMethodBeat.o(328353);
      return;
    }
    if (getBarLen() == 0)
    {
      AppMethodBeat.o(328353);
      return;
    }
    this.sHq.setText(Bf(this.mPosition / 60) + ":" + Bf(this.mPosition % 60));
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.sHo.getLayoutParams();
    int i = getBarLen();
    localLayoutParams.leftMargin = fF(this.mPosition, i);
    this.sHo.setLayoutParams(localLayoutParams);
    localLayoutParams = (FrameLayout.LayoutParams)this.sHm.getLayoutParams();
    localLayoutParams.width = ((int)(this.mPosition * 1.0D / this.cqW * i));
    this.sHm.setLayoutParams(localLayoutParams);
    requestLayout();
    AppMethodBeat.o(328353);
  }
  
  protected final int fF(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(328300);
    if (paramInt1 <= 0)
    {
      this.sHn.getLayoutParams();
      paramInt1 = 0;
    }
    for (;;)
    {
      AppMethodBeat.o(328300);
      return paramInt1;
      if (paramInt1 >= this.cqW) {
        paramInt1 = paramInt2 - (getBarPointWidth() - getBarPointPaddingLeft() - getBarPointPaddingRight()) / 2;
      } else {
        paramInt1 = (int)(paramInt1 * 1.0D / this.cqW * paramInt2);
      }
    }
  }
  
  protected int getBarPointWidth()
  {
    AppMethodBeat.i(328291);
    if (this.sHZ == -1) {
      this.sHZ = this.sHo.getWidth();
    }
    int i = this.sHZ;
    AppMethodBeat.o(328291);
    return i;
  }
  
  protected int getLayoutId()
  {
    return a.d.app_brand_video_player_seek_bar;
  }
  
  public ImageView getPlayBtn()
  {
    return this.sHp;
  }
  
  public TextView getPlaytimeTv()
  {
    return this.sHq;
  }
  
  protected void init()
  {
    AppMethodBeat.i(328282);
    this.contentView = View.inflate(getContext(), getLayoutId(), this);
    this.sHm = ((ImageView)this.contentView.findViewById(a.c.player_progress_bar_front));
    this.sHn = ((ImageView)this.contentView.findViewById(a.c.player_progress_bar_background));
    this.sHo = ((ImageView)this.contentView.findViewById(a.c.player_progress_point));
    this.sHp = ((ImageView)this.contentView.findViewById(a.c.play_btn));
    this.sHq = ((TextView)this.contentView.findViewById(a.c.play_current_time_tv));
    this.sHr = ((TextView)this.contentView.findViewById(a.c.play_total_time_tv));
    this.sHo.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(328241);
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          Log.i("MicroMsg.Video.VideoPlayerSeekBar", "ontouch down");
          VideoPlayerSeekBar.this.seH = false;
          VideoPlayerSeekBar.this.sHu = paramAnonymousMotionEvent.getX();
          if (VideoPlayerSeekBar.this.sHl != null) {
            VideoPlayerSeekBar.this.sHl.blc();
          }
        }
        for (;;)
        {
          AppMethodBeat.o(328241);
          return true;
          int i;
          if (paramAnonymousMotionEvent.getAction() == 2)
          {
            float f = paramAnonymousMotionEvent.getX();
            paramAnonymousView = (FrameLayout.LayoutParams)VideoPlayerSeekBar.this.sHo.getLayoutParams();
            paramAnonymousMotionEvent = VideoPlayerSeekBar.this;
            i = paramAnonymousView.leftMargin;
            i = VideoPlayerSeekBar.a(paramAnonymousMotionEvent, (int)(f - VideoPlayerSeekBar.this.sHu) + i, VideoPlayerSeekBar.a(VideoPlayerSeekBar.this));
            paramAnonymousView.leftMargin = i;
            VideoPlayerSeekBar.this.sHo.setLayoutParams(paramAnonymousView);
            int j = VideoPlayerSeekBar.a(VideoPlayerSeekBar.this).value;
            if (VideoPlayerSeekBar.this.cqW > 0)
            {
              paramAnonymousView = (FrameLayout.LayoutParams)VideoPlayerSeekBar.this.sHm.getLayoutParams();
              paramAnonymousView.width = i;
              VideoPlayerSeekBar.this.sHm.setLayoutParams(paramAnonymousView);
            }
            VideoPlayerSeekBar.this.sHq.setText(VideoPlayerSeekBar.Bf(j / 60) + ":" + VideoPlayerSeekBar.Bf(j % 60));
            VideoPlayerSeekBar.this.seH = true;
          }
          else
          {
            i = VideoPlayerSeekBar.this.mPosition;
            if (VideoPlayerSeekBar.this.seH)
            {
              paramAnonymousView = VideoPlayerSeekBar.this;
              i = VideoPlayerSeekBar.a(VideoPlayerSeekBar.this).value;
              paramAnonymousView.mPosition = i;
            }
            if (VideoPlayerSeekBar.this.sHl != null)
            {
              Log.i("MicroMsg.Video.VideoPlayerSeekBar", "current time : ".concat(String.valueOf(i)));
              VideoPlayerSeekBar.this.sHl.tS(i);
            }
            VideoPlayerSeekBar.this.seH = false;
          }
        }
      }
    });
    AppMethodBeat.o(328282);
  }
  
  public void jJ(boolean paramBoolean)
  {
    AppMethodBeat.i(328380);
    setIsPlay(paramBoolean);
    AppMethodBeat.o(328380);
  }
  
  public void seek(int paramInt)
  {
    AppMethodBeat.i(328330);
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    paramInt = i;
    if (i >= this.cqW) {
      paramInt = this.cqW;
    }
    if (this.mPosition != paramInt)
    {
      this.mPosition = paramInt;
      cxb();
    }
    AppMethodBeat.o(328330);
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(328368);
    this.hJg = paramBoolean;
    super.setIsPlay(paramBoolean);
    AppMethodBeat.o(328368);
  }
  
  public void setPlayBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(328361);
    if (this.sHp != null) {
      this.sHp.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(328361);
  }
  
  public void setVideoTotalTime(int paramInt)
  {
    AppMethodBeat.i(328338);
    this.cqW = paramInt;
    this.mPosition = 0;
    this.sHr.setText(Bf(this.cqW / 60) + ":" + Bf(this.cqW % 60));
    cxb();
    AppMethodBeat.o(328338);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.VideoPlayerSeekBar
 * JD-Core Version:    0.7.0.1
 */