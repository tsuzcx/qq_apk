package com.tencent.mm.live.core.view;

import android.content.Context;
import android.graphics.Point;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.a.d;
import com.tencent.mm.live.core.a.e;
import com.tencent.mm.ui.ax;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public final class b
  extends RelativeLayout
  implements View.OnClickListener
{
  public WeakReference<b> koF;
  private boolean koV;
  private boolean kpr;
  SurfaceView ktd;
  private View.OnClickListener kte;
  private GestureDetector ktf;
  private LinearLayout ktg;
  private Button kth;
  private Button kti;
  private Button ktj;
  private FrameLayout ktk;
  private TextView ktl;
  private ImageView ktm;
  private ViewGroup ktn;
  private HashMap<Integer, Integer> kto;
  boolean ktp;
  private boolean ktq;
  private boolean ktr;
  b.a kts;
  private float ktt;
  private float ktu;
  TXCloudVideoView mVideoView;
  
  public b(Context paramContext, boolean paramBoolean)
  {
    this(paramContext, paramBoolean, (byte)0);
  }
  
  private b(Context paramContext, boolean paramBoolean, byte paramByte)
  {
    super(paramContext, null);
    AppMethodBeat.i(200409);
    this.kto = null;
    this.ktq = false;
    this.koV = true;
    this.kpr = true;
    this.ktr = false;
    this.kts = null;
    this.ktt = 0.0F;
    this.ktu = 0.0F;
    this.ktr = paramBoolean;
    this.ktn = ((ViewGroup)LayoutInflater.from(getContext()).inflate(a.e.layout_trtc_func, this, true));
    if (this.ktr)
    {
      this.mVideoView = ((TXCloudVideoView)this.ktn.findViewById(a.d.live_tx_view));
      this.mVideoView.setVisibility(0);
    }
    for (;;)
    {
      this.ktg = ((LinearLayout)this.ktn.findViewById(a.d.trtc_ll_controller));
      this.kth = ((Button)this.ktn.findViewById(a.d.trtc_btn_mute_video));
      this.kth.setOnClickListener(this);
      this.kti = ((Button)this.ktn.findViewById(a.d.trtc_btn_mute_audio));
      this.kti.setOnClickListener(this);
      this.ktj = ((Button)this.ktn.findViewById(a.d.trtc_btn_fill));
      this.ktj.setOnClickListener(this);
      this.ktk = ((FrameLayout)this.ktn.findViewById(a.d.trtc_fl_no_video));
      this.ktl = ((TextView)this.ktn.findViewById(a.d.trtc_tv_content));
      this.ktm = ((ImageView)this.ktn.findViewById(a.d.trtc_iv_nos));
      ((ToggleButton)this.ktn.findViewById(a.d.mute_in_speaker)).setOnClickListener(this);
      this.ktf = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener()
      {
        public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(198050);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/core/view/TRTCVideoLayout$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
          boolean bool = super.onContextClick(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/live/core/view/TRTCVideoLayout$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(198050);
          return bool;
        }
        
        public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(198046);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/core/view/TRTCVideoLayout$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
          boolean bool = super.onDoubleTap(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/live/core/view/TRTCVideoLayout$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(198046);
          return bool;
        }
        
        public final boolean onDown(MotionEvent paramAnonymousMotionEvent)
        {
          return true;
        }
        
        public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(198042);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/core/view/TRTCVideoLayout$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aFi());
          super.onLongPress(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/core/view/TRTCVideoLayout$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
          AppMethodBeat.o(198042);
        }
        
        public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
        {
          AppMethodBeat.i(198040);
          if (!b.b(b.this))
          {
            AppMethodBeat.o(198040);
            return false;
          }
          if ((b.this.getLayoutParams() instanceof RelativeLayout.LayoutParams))
          {
            RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)b.this.getLayoutParams();
            int j = (int)(localLayoutParams.leftMargin + (paramAnonymousMotionEvent2.getX() - paramAnonymousMotionEvent1.getX()));
            int i = (int)(localLayoutParams.topMargin + (paramAnonymousMotionEvent2.getY() - paramAnonymousMotionEvent1.getY()));
            j = Math.max(Math.min(ax.au(b.this.getContext()).x - b.this.getWidth(), j), 0);
            i = Math.max(Math.min(ax.au(b.this.getContext()).y - b.this.getHeight(), i), 0);
            localLayoutParams.leftMargin = j;
            localLayoutParams.topMargin = i;
            b.this.setLayoutParams(localLayoutParams);
          }
          AppMethodBeat.o(198040);
          return true;
        }
        
        public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(198031);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/core/view/TRTCVideoLayout$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
          if (b.a(b.this) != null) {
            b.a(b.this).onClick(b.this);
          }
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/live/core/view/TRTCVideoLayout$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(198031);
          return true;
        }
      });
      setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(199077);
          switch (paramAnonymousMotionEvent.getActionMasked())
          {
          }
          for (;;)
          {
            paramAnonymousView = b.f(b.this);
            paramAnonymousMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, paramAnonymousMotionEvent.aFh(), "com/tencent/mm/live/core/view/TRTCVideoLayout$2", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
            boolean bool = com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousView.onTouchEvent((MotionEvent)paramAnonymousMotionEvent.sf(0)), "com/tencent/mm/live/core/view/TRTCVideoLayout$2", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(199077);
            return bool;
            b.a(b.this, paramAnonymousMotionEvent.getRawX());
            b.b(b.this, paramAnonymousMotionEvent.getRawY());
            continue;
            float f1 = paramAnonymousMotionEvent.getRawX();
            float f2 = b.c(b.this);
            float f3 = paramAnonymousMotionEvent.getRawY();
            float f4 = b.d(b.this);
            if ((b.b(b.this)) && (b.e(b.this) != null)) {
              b.e(b.this).E(f1 - f2, f3 - f4);
            }
          }
        }
      });
      this.kto = new HashMap();
      AppMethodBeat.o(200409);
      return;
      this.ktd = ((SurfaceView)this.ktn.findViewById(a.d.live_camera_view));
      this.ktd.setVisibility(0);
    }
  }
  
  public final void NT(String paramString)
  {
    AppMethodBeat.i(200412);
    if (this.ktl != null) {
      this.ktl.setText(paramString);
    }
    if (this.ktk != null) {
      this.ktk.setVisibility(8);
    }
    AppMethodBeat.o(200412);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(200420);
    this.koF = new WeakReference(paramb);
    AppMethodBeat.o(200420);
  }
  
  public final void aNo()
  {
    AppMethodBeat.i(200411);
    if (this.ktg != null) {
      this.ktg.setVisibility(8);
    }
    AppMethodBeat.o(200411);
  }
  
  public final void onClick(View paramView)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    AppMethodBeat.i(200419);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/core/view/TRTCVideoLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
    if (this.koF != null) {}
    for (localObject = (b)this.koF.get(); localObject == null; localObject = null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/core/view/TRTCVideoLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(200419);
      return;
    }
    int i = paramView.getId();
    if (i == a.d.trtc_btn_fill) {
      if (!this.ktq)
      {
        bool1 = true;
        this.ktq = bool1;
        ((b)localObject).g(this);
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/core/view/TRTCVideoLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(200419);
      return;
      bool1 = false;
      break;
      if (i == a.d.trtc_btn_mute_audio)
      {
        if (!this.koV) {}
        for (;;)
        {
          this.koV = bool1;
          ((b)localObject).h(this);
          break;
          bool1 = false;
        }
      }
      if (i == a.d.trtc_btn_mute_video)
      {
        if (!this.kpr) {}
        for (bool1 = bool2;; bool1 = false)
        {
          this.kpr = bool1;
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
    this.kte = paramOnClickListener;
  }
  
  public static abstract interface b
  {
    public abstract void g(b paramb);
    
    public abstract void h(b paramb);
    
    public abstract void i(b paramb);
    
    public abstract void j(b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.view.b
 * JD-Core Version:    0.7.0.1
 */