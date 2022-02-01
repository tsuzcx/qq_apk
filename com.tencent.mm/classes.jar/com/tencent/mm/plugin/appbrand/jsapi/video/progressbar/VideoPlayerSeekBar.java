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
import com.tencent.mm.sdk.platformtools.ae;

public class VideoPlayerSeekBar
  extends AdVideoPlayerLoadingBar
  implements e.b
{
  protected boolean duq;
  private PInt lwE;
  private int lwF;
  private int lwG;
  private int lwH;
  
  public VideoPlayerSeekBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(211453);
    this.lwE = new PInt();
    this.duq = false;
    this.lwF = -1;
    this.lwG = -1;
    this.lwH = -1;
    AppMethodBeat.o(211453);
  }
  
  public VideoPlayerSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(211454);
    this.lwE = new PInt();
    this.duq = false;
    this.lwF = -1;
    this.lwG = -1;
    this.lwH = -1;
    AppMethodBeat.o(211454);
  }
  
  public VideoPlayerSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(211455);
    this.lwE = new PInt();
    this.duq = false;
    this.lwF = -1;
    this.lwG = -1;
    this.lwH = -1;
    AppMethodBeat.o(211455);
  }
  
  private int getBarPointPaddingLeft()
  {
    AppMethodBeat.i(211458);
    if (this.lwG == -1) {
      this.lwG = this.lvT.getPaddingLeft();
    }
    int i = this.lwG;
    AppMethodBeat.o(211458);
    return i;
  }
  
  private int getBarPointPaddingRight()
  {
    AppMethodBeat.i(211459);
    if (this.lwH == -1) {
      this.lwH = this.lvT.getPaddingRight();
    }
    int i = this.lwH;
    AppMethodBeat.o(211459);
    return i;
  }
  
  public void bpi()
  {
    AppMethodBeat.i(211463);
    if (this.lvX == 0)
    {
      AppMethodBeat.o(211463);
      return;
    }
    if (this.kWf)
    {
      AppMethodBeat.o(211463);
      return;
    }
    if (this.lvT == null)
    {
      AppMethodBeat.o(211463);
      return;
    }
    if (getBarLen() == 0)
    {
      AppMethodBeat.o(211463);
      return;
    }
    this.lvV.setText(tv(this.mPosition / 60) + ":" + tv(this.mPosition % 60));
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.lvT.getLayoutParams();
    int i = getBarLen();
    localLayoutParams.leftMargin = ea(this.mPosition, i);
    this.lvT.setLayoutParams(localLayoutParams);
    localLayoutParams = (FrameLayout.LayoutParams)this.lvR.getLayoutParams();
    localLayoutParams.width = ((int)(this.mPosition * 1.0D / this.lvX * i));
    this.lvR.setLayoutParams(localLayoutParams);
    requestLayout();
    AppMethodBeat.o(211463);
  }
  
  protected final int ea(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(211460);
    if (paramInt1 <= 0)
    {
      this.lvS.getLayoutParams();
      paramInt1 = 0;
    }
    for (;;)
    {
      AppMethodBeat.o(211460);
      return paramInt1;
      if (paramInt1 >= this.lvX) {
        paramInt1 = paramInt2 - (getBarPointWidth() - getBarPointPaddingLeft() - getBarPointPaddingRight()) / 2;
      } else {
        paramInt1 = (int)(paramInt1 * 1.0D / this.lvX * paramInt2);
      }
    }
  }
  
  public void gS(boolean paramBoolean)
  {
    AppMethodBeat.i(211467);
    setIsPlay(paramBoolean);
    AppMethodBeat.o(211467);
  }
  
  protected int getBarPointWidth()
  {
    AppMethodBeat.i(211457);
    if (this.lwF == -1) {
      this.lwF = this.lvT.getWidth();
    }
    int i = this.lwF;
    AppMethodBeat.o(211457);
    return i;
  }
  
  protected int getLayoutId()
  {
    return 2131496137;
  }
  
  public ImageView getPlayBtn()
  {
    return this.lvU;
  }
  
  public TextView getPlaytimeTv()
  {
    return this.lvV;
  }
  
  protected void init()
  {
    AppMethodBeat.i(211456);
    this.contentView = View.inflate(getContext(), getLayoutId(), this);
    this.lvR = ((ImageView)this.contentView.findViewById(2131303302));
    this.lvS = ((ImageView)this.contentView.findViewById(2131303301));
    this.lvT = ((ImageView)this.contentView.findViewById(2131303305));
    this.lvU = ((ImageView)this.contentView.findViewById(2131303281));
    this.lvV = ((TextView)this.contentView.findViewById(2131303283));
    this.lvW = ((TextView)this.contentView.findViewById(2131303289));
    this.lvT.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(211452);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        a.b("com/tencent/mm/plugin/appbrand/jsapi/video/progressbar/VideoPlayerSeekBar$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          ae.i("MicroMsg.Video.VideoPlayerSeekBar", "ontouch down");
          VideoPlayerSeekBar.this.kWf = false;
          VideoPlayerSeekBar.this.lwa = paramAnonymousMotionEvent.getX();
          if (VideoPlayerSeekBar.this.lvQ != null) {
            VideoPlayerSeekBar.this.lvQ.aqS();
          }
        }
        for (;;)
        {
          a.a(true, this, "com/tencent/mm/plugin/appbrand/jsapi/video/progressbar/VideoPlayerSeekBar$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(211452);
          return true;
          int i;
          if (paramAnonymousMotionEvent.getAction() == 2)
          {
            float f = paramAnonymousMotionEvent.getX();
            paramAnonymousView = (FrameLayout.LayoutParams)VideoPlayerSeekBar.this.lvT.getLayoutParams();
            paramAnonymousMotionEvent = VideoPlayerSeekBar.this;
            i = paramAnonymousView.leftMargin;
            i = VideoPlayerSeekBar.a(paramAnonymousMotionEvent, (int)(f - VideoPlayerSeekBar.this.lwa) + i, VideoPlayerSeekBar.a(VideoPlayerSeekBar.this));
            paramAnonymousView.leftMargin = i;
            VideoPlayerSeekBar.this.lvT.setLayoutParams(paramAnonymousView);
            int j = VideoPlayerSeekBar.a(VideoPlayerSeekBar.this).value;
            if (VideoPlayerSeekBar.this.lvX > 0)
            {
              paramAnonymousView = (FrameLayout.LayoutParams)VideoPlayerSeekBar.this.lvR.getLayoutParams();
              paramAnonymousView.width = i;
              VideoPlayerSeekBar.this.lvR.setLayoutParams(paramAnonymousView);
            }
            VideoPlayerSeekBar.this.lvV.setText(VideoPlayerSeekBar.tv(j / 60) + ":" + VideoPlayerSeekBar.tv(j % 60));
            VideoPlayerSeekBar.this.kWf = true;
          }
          else
          {
            i = VideoPlayerSeekBar.this.mPosition;
            if (VideoPlayerSeekBar.this.kWf)
            {
              paramAnonymousView = VideoPlayerSeekBar.this;
              i = VideoPlayerSeekBar.a(VideoPlayerSeekBar.this).value;
              paramAnonymousView.mPosition = i;
            }
            if (VideoPlayerSeekBar.this.lvQ != null)
            {
              ae.i("MicroMsg.Video.VideoPlayerSeekBar", "current time : ".concat(String.valueOf(i)));
              VideoPlayerSeekBar.this.lvQ.nP(i);
            }
            VideoPlayerSeekBar.this.kWf = false;
          }
        }
      }
    });
    AppMethodBeat.o(211456);
  }
  
  public void seek(int paramInt)
  {
    AppMethodBeat.i(211461);
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    paramInt = i;
    if (i >= this.lvX) {
      paramInt = this.lvX;
    }
    if (this.mPosition != paramInt)
    {
      this.mPosition = paramInt;
      bpi();
    }
    AppMethodBeat.o(211461);
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(211465);
    this.duq = paramBoolean;
    super.setIsPlay(paramBoolean);
    AppMethodBeat.o(211465);
  }
  
  public void setPlayBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(211464);
    if (this.lvU != null) {
      this.lvU.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(211464);
  }
  
  public void setVideoTotalTime(int paramInt)
  {
    AppMethodBeat.i(211462);
    this.lvX = paramInt;
    this.mPosition = 0;
    this.lvW.setText(tv(this.lvX / 60) + ":" + tv(this.lvX % 60));
    bpi();
    AppMethodBeat.o(211462);
  }
  
  public final void tx(int paramInt)
  {
    AppMethodBeat.i(211466);
    seek(paramInt);
    AppMethodBeat.o(211466);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.VideoPlayerSeekBar
 * JD-Core Version:    0.7.0.1
 */