package com.tencent.mm.live.core.view;

import android.content.Context;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.a.d;
import com.tencent.mm.live.core.a.e;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public final class b
  extends RelativeLayout
  implements View.OnClickListener
{
  private boolean mSJ;
  public WeakReference<b> mSv;
  private boolean mTi;
  public TXCloudVideoView mVideoView;
  TextureView mWV;
  private View.OnClickListener mWW;
  private GestureDetector mWX;
  private LinearLayout mWY;
  private Button mWZ;
  private Button mXa;
  private Button mXb;
  private FrameLayout mXc;
  private TextView mXd;
  private ImageView mXe;
  private ViewGroup mXf;
  private HashMap<Integer, Integer> mXg;
  boolean mXh;
  private boolean mXi;
  private boolean mXj;
  a mXk;
  private float mXl;
  private float mXm;
  
  public b(Context paramContext, boolean paramBoolean)
  {
    this(paramContext, paramBoolean, (byte)0);
  }
  
  private b(Context paramContext, boolean paramBoolean, byte paramByte)
  {
    super(paramContext, null);
    AppMethodBeat.i(247591);
    this.mXg = null;
    this.mXi = false;
    this.mSJ = true;
    this.mTi = true;
    this.mXj = false;
    this.mXk = null;
    this.mXl = 0.0F;
    this.mXm = 0.0F;
    this.mXj = paramBoolean;
    this.mXf = ((ViewGroup)LayoutInflater.from(getContext()).inflate(a.e.layout_trtc_func, this, true));
    if (this.mXj)
    {
      this.mVideoView = ((TXCloudVideoView)this.mXf.findViewById(a.d.live_tx_view));
      this.mVideoView.setVisibility(0);
    }
    for (;;)
    {
      this.mWY = ((LinearLayout)this.mXf.findViewById(a.d.trtc_ll_controller));
      this.mWZ = ((Button)this.mXf.findViewById(a.d.trtc_btn_mute_video));
      this.mWZ.setOnClickListener(this);
      this.mXa = ((Button)this.mXf.findViewById(a.d.trtc_btn_mute_audio));
      this.mXa.setOnClickListener(this);
      this.mXb = ((Button)this.mXf.findViewById(a.d.trtc_btn_fill));
      this.mXb.setOnClickListener(this);
      this.mXc = ((FrameLayout)this.mXf.findViewById(a.d.trtc_fl_no_video));
      this.mXd = ((TextView)this.mXf.findViewById(a.d.trtc_tv_content));
      this.mXe = ((ImageView)this.mXf.findViewById(a.d.trtc_iv_nos));
      ((ToggleButton)this.mXf.findViewById(a.d.mute_in_speaker)).setOnClickListener(this);
      this.mWX = new GestureDetector(getContext(), new b.1(this));
      setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(247522);
          switch (paramAnonymousMotionEvent.getActionMasked())
          {
          }
          for (;;)
          {
            paramAnonymousView = b.f(b.this);
            paramAnonymousMotionEvent = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, paramAnonymousMotionEvent.aYi(), "com/tencent/mm/live/core/view/TRTCVideoLayout$2", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
            boolean bool = com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousView.onTouchEvent((MotionEvent)paramAnonymousMotionEvent.sb(0)), "com/tencent/mm/live/core/view/TRTCVideoLayout$2", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(247522);
            return bool;
            b.a(b.this, paramAnonymousMotionEvent.getRawX());
            b.b(b.this, paramAnonymousMotionEvent.getRawY());
            continue;
            float f1 = paramAnonymousMotionEvent.getRawX();
            float f2 = b.c(b.this);
            float f3 = paramAnonymousMotionEvent.getRawY();
            float f4 = b.d(b.this);
            if ((b.b(b.this)) && (b.e(b.this) != null)) {
              b.e(b.this).onMove(f1 - f2, f3 - f4);
            }
          }
        }
      });
      this.mXg = new HashMap();
      AppMethodBeat.o(247591);
      return;
      this.mWV = ((TextureView)this.mXf.findViewById(a.d.live_camera_view));
      this.mWV.setVisibility(0);
    }
  }
  
  public final void Gh(String paramString)
  {
    AppMethodBeat.i(247654);
    if (this.mXd != null) {
      this.mXd.setText(paramString);
    }
    if (this.mXc != null) {
      this.mXc.setVisibility(8);
    }
    AppMethodBeat.o(247654);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(247680);
    this.mSv = new WeakReference(paramb);
    AppMethodBeat.o(247680);
  }
  
  public final void bhb()
  {
    AppMethodBeat.i(247645);
    if (this.mWY != null) {
      this.mWY.setVisibility(8);
    }
    AppMethodBeat.o(247645);
  }
  
  public final void onClick(View paramView)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    AppMethodBeat.i(247671);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/core/view/TRTCVideoLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
    if (this.mSv != null) {}
    for (localObject = (b)this.mSv.get(); localObject == null; localObject = null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/core/view/TRTCVideoLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(247671);
      return;
    }
    int i = paramView.getId();
    if (i == a.d.trtc_btn_fill) {
      if (!this.mXi)
      {
        bool1 = true;
        this.mXi = bool1;
        ((b)localObject).g(this);
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/core/view/TRTCVideoLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(247671);
      return;
      bool1 = false;
      break;
      if (i == a.d.trtc_btn_mute_audio)
      {
        if (!this.mSJ) {}
        for (;;)
        {
          this.mSJ = bool1;
          ((b)localObject).h(this);
          break;
          bool1 = false;
        }
      }
      if (i == a.d.trtc_btn_mute_video)
      {
        if (!this.mTi) {}
        for (bool1 = bool2;; bool1 = false)
        {
          this.mTi = bool1;
          ((b)localObject).i(this);
          break;
        }
      }
      if (i == a.d.mute_in_speaker)
      {
        ((ToggleButton)paramView).isChecked();
        ((b)localObject).j(this);
      }
    }
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mWW = paramOnClickListener;
  }
  
  public static abstract interface a
  {
    public abstract void onMove(float paramFloat1, float paramFloat2);
  }
  
  public static abstract interface b
  {
    public abstract void g(b paramb);
    
    public abstract void h(b paramb);
    
    public abstract void i(b paramb);
    
    public abstract void j(b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.live.core.view.b
 * JD-Core Version:    0.7.0.1
 */