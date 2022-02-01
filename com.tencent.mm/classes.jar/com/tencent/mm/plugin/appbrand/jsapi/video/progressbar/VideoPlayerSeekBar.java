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
import com.tencent.mm.sdk.platformtools.Log;

public class VideoPlayerSeekBar
  extends AdVideoPlayerLoadingBar
  implements e.b
{
  protected boolean dLB;
  private PInt mDA;
  private int mDC;
  private int mDD;
  private int mDE;
  
  public VideoPlayerSeekBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(235130);
    this.mDA = new PInt();
    this.dLB = false;
    this.mDC = -1;
    this.mDD = -1;
    this.mDE = -1;
    AppMethodBeat.o(235130);
  }
  
  public VideoPlayerSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(235131);
    this.mDA = new PInt();
    this.dLB = false;
    this.mDC = -1;
    this.mDD = -1;
    this.mDE = -1;
    AppMethodBeat.o(235131);
  }
  
  public VideoPlayerSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(235132);
    this.mDA = new PInt();
    this.dLB = false;
    this.mDC = -1;
    this.mDD = -1;
    this.mDE = -1;
    AppMethodBeat.o(235132);
  }
  
  private int getBarPointPaddingLeft()
  {
    AppMethodBeat.i(235135);
    if (this.mDD == -1) {
      this.mDD = this.mCO.getPaddingLeft();
    }
    int i = this.mDD;
    AppMethodBeat.o(235135);
    return i;
  }
  
  private int getBarPointPaddingRight()
  {
    AppMethodBeat.i(235136);
    if (this.mDE == -1) {
      this.mDE = this.mCO.getPaddingRight();
    }
    int i = this.mDE;
    AppMethodBeat.o(235136);
    return i;
  }
  
  public void bKO()
  {
    AppMethodBeat.i(235140);
    if (this.mCS == 0)
    {
      AppMethodBeat.o(235140);
      return;
    }
    if (this.mbo)
    {
      AppMethodBeat.o(235140);
      return;
    }
    if (this.mCO == null)
    {
      AppMethodBeat.o(235140);
      return;
    }
    if (getBarLen() == 0)
    {
      AppMethodBeat.o(235140);
      return;
    }
    this.mCQ.setText(xt(this.mPosition / 60) + ":" + xt(this.mPosition % 60));
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.mCO.getLayoutParams();
    int i = getBarLen();
    localLayoutParams.leftMargin = en(this.mPosition, i);
    this.mCO.setLayoutParams(localLayoutParams);
    localLayoutParams = (FrameLayout.LayoutParams)this.mCM.getLayoutParams();
    localLayoutParams.width = ((int)(this.mPosition * 1.0D / this.mCS * i));
    this.mCM.setLayoutParams(localLayoutParams);
    requestLayout();
    AppMethodBeat.o(235140);
  }
  
  protected final int en(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(235137);
    if (paramInt1 <= 0)
    {
      this.mCN.getLayoutParams();
      paramInt1 = 0;
    }
    for (;;)
    {
      AppMethodBeat.o(235137);
      return paramInt1;
      if (paramInt1 >= this.mCS) {
        paramInt1 = paramInt2 - (getBarPointWidth() - getBarPointPaddingLeft() - getBarPointPaddingRight()) / 2;
      } else {
        paramInt1 = (int)(paramInt1 * 1.0D / this.mCS * paramInt2);
      }
    }
  }
  
  protected int getBarPointWidth()
  {
    AppMethodBeat.i(235134);
    if (this.mDC == -1) {
      this.mDC = this.mCO.getWidth();
    }
    int i = this.mDC;
    AppMethodBeat.o(235134);
    return i;
  }
  
  protected int getLayoutId()
  {
    return 2131493114;
  }
  
  public ImageView getPlayBtn()
  {
    return this.mCP;
  }
  
  public TextView getPlaytimeTv()
  {
    return this.mCQ;
  }
  
  public void hP(boolean paramBoolean)
  {
    AppMethodBeat.i(235144);
    setIsPlay(paramBoolean);
    AppMethodBeat.o(235144);
  }
  
  protected void init()
  {
    AppMethodBeat.i(235133);
    this.contentView = View.inflate(getContext(), getLayoutId(), this);
    this.mCM = ((ImageView)this.contentView.findViewById(2131305975));
    this.mCN = ((ImageView)this.contentView.findViewById(2131305974));
    this.mCO = ((ImageView)this.contentView.findViewById(2131305978));
    this.mCP = ((ImageView)this.contentView.findViewById(2131305954));
    this.mCQ = ((TextView)this.contentView.findViewById(2131305956));
    this.mCR = ((TextView)this.contentView.findViewById(2131305962));
    this.mCO.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(235129);
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          Log.i("MicroMsg.Video.VideoPlayerSeekBar", "ontouch down");
          VideoPlayerSeekBar.this.mbo = false;
          VideoPlayerSeekBar.this.mCV = paramAnonymousMotionEvent.getX();
          if (VideoPlayerSeekBar.this.mCL != null) {
            VideoPlayerSeekBar.this.mCL.aJq();
          }
        }
        for (;;)
        {
          AppMethodBeat.o(235129);
          return true;
          int i;
          if (paramAnonymousMotionEvent.getAction() == 2)
          {
            float f = paramAnonymousMotionEvent.getX();
            paramAnonymousView = (FrameLayout.LayoutParams)VideoPlayerSeekBar.this.mCO.getLayoutParams();
            paramAnonymousMotionEvent = VideoPlayerSeekBar.this;
            i = paramAnonymousView.leftMargin;
            i = VideoPlayerSeekBar.a(paramAnonymousMotionEvent, (int)(f - VideoPlayerSeekBar.this.mCV) + i, VideoPlayerSeekBar.a(VideoPlayerSeekBar.this));
            paramAnonymousView.leftMargin = i;
            VideoPlayerSeekBar.this.mCO.setLayoutParams(paramAnonymousView);
            int j = VideoPlayerSeekBar.a(VideoPlayerSeekBar.this).value;
            if (VideoPlayerSeekBar.this.mCS > 0)
            {
              paramAnonymousView = (FrameLayout.LayoutParams)VideoPlayerSeekBar.this.mCM.getLayoutParams();
              paramAnonymousView.width = i;
              VideoPlayerSeekBar.this.mCM.setLayoutParams(paramAnonymousView);
            }
            VideoPlayerSeekBar.this.mCQ.setText(VideoPlayerSeekBar.xt(j / 60) + ":" + VideoPlayerSeekBar.xt(j % 60));
            VideoPlayerSeekBar.this.mbo = true;
          }
          else
          {
            i = VideoPlayerSeekBar.this.mPosition;
            if (VideoPlayerSeekBar.this.mbo)
            {
              paramAnonymousView = VideoPlayerSeekBar.this;
              i = VideoPlayerSeekBar.a(VideoPlayerSeekBar.this).value;
              paramAnonymousView.mPosition = i;
            }
            if (VideoPlayerSeekBar.this.mCL != null)
            {
              Log.i("MicroMsg.Video.VideoPlayerSeekBar", "current time : ".concat(String.valueOf(i)));
              VideoPlayerSeekBar.this.mCL.rk(i);
            }
            VideoPlayerSeekBar.this.mbo = false;
          }
        }
      }
    });
    AppMethodBeat.o(235133);
  }
  
  public void seek(int paramInt)
  {
    AppMethodBeat.i(235138);
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    paramInt = i;
    if (i >= this.mCS) {
      paramInt = this.mCS;
    }
    if (this.mPosition != paramInt)
    {
      this.mPosition = paramInt;
      bKO();
    }
    AppMethodBeat.o(235138);
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(235142);
    this.dLB = paramBoolean;
    super.setIsPlay(paramBoolean);
    AppMethodBeat.o(235142);
  }
  
  public void setPlayBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(235141);
    if (this.mCP != null) {
      this.mCP.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(235141);
  }
  
  public void setVideoTotalTime(int paramInt)
  {
    AppMethodBeat.i(235139);
    this.mCS = paramInt;
    this.mPosition = 0;
    this.mCR.setText(xt(this.mCS / 60) + ":" + xt(this.mCS % 60));
    bKO();
    AppMethodBeat.o(235139);
  }
  
  public final void xv(int paramInt)
  {
    AppMethodBeat.i(235143);
    seek(paramInt);
    AppMethodBeat.o(235143);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.VideoPlayerSeekBar
 * JD-Core Version:    0.7.0.1
 */