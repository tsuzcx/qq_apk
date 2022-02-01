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
import com.tencent.mm.ui.ar;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.lang.ref.WeakReference;
import java.util.HashMap;

final class b
  extends RelativeLayout
  implements View.OnClickListener
{
  public WeakReference<b> gIP;
  private boolean gJb;
  private boolean gJq;
  SurfaceView gMd;
  private View.OnClickListener gMe;
  private GestureDetector gMf;
  private LinearLayout gMg;
  private Button gMh;
  private Button gMi;
  private Button gMj;
  private FrameLayout gMk;
  private TextView gMl;
  private ImageView gMm;
  private ViewGroup gMn;
  private HashMap<Integer, Integer> gMo;
  boolean gMp;
  private boolean gMq;
  private boolean gMr;
  b.a gMs;
  private float gMt;
  private float gMu;
  TXCloudVideoView mVideoView;
  
  public b(Context paramContext, boolean paramBoolean)
  {
    this(paramContext, paramBoolean, (byte)0);
  }
  
  private b(Context paramContext, boolean paramBoolean, byte paramByte)
  {
    super(paramContext, null);
    AppMethodBeat.i(216743);
    this.gMo = null;
    this.gMq = false;
    this.gJb = true;
    this.gJq = true;
    this.gMr = false;
    this.gMs = null;
    this.gMt = 0.0F;
    this.gMu = 0.0F;
    this.gMr = paramBoolean;
    this.gMn = ((ViewGroup)LayoutInflater.from(getContext()).inflate(2131496279, this, true));
    if (this.gMr)
    {
      this.mVideoView = ((TXCloudVideoView)this.gMn.findViewById(2131307812));
      this.mVideoView.setVisibility(0);
    }
    for (;;)
    {
      this.gMg = ((LinearLayout)this.gMn.findViewById(2131308050));
      this.gMh = ((Button)this.gMn.findViewById(2131308047));
      this.gMh.setOnClickListener(this);
      this.gMi = ((Button)this.gMn.findViewById(2131308046));
      this.gMi.setOnClickListener(this);
      this.gMj = ((Button)this.gMn.findViewById(2131308045));
      this.gMj.setOnClickListener(this);
      this.gMk = ((FrameLayout)this.gMn.findViewById(2131308048));
      this.gMl = ((TextView)this.gMn.findViewById(2131308051));
      this.gMm = ((ImageView)this.gMn.findViewById(2131308049));
      ((ToggleButton)this.gMn.findViewById(2131307882)).setOnClickListener(this);
      this.gMf = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener()
      {
        public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(216741);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/core/view/TRTCVideoLayout$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
          boolean bool = super.onContextClick(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/live/core/view/TRTCVideoLayout$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(216741);
          return bool;
        }
        
        public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(216740);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/core/view/TRTCVideoLayout$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
          boolean bool = super.onDoubleTap(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/live/core/view/TRTCVideoLayout$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(216740);
          return bool;
        }
        
        public final boolean onDown(MotionEvent paramAnonymousMotionEvent)
        {
          return true;
        }
        
        public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(216739);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/core/view/TRTCVideoLayout$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahq());
          super.onLongPress(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/core/view/TRTCVideoLayout$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
          AppMethodBeat.o(216739);
        }
        
        public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
        {
          AppMethodBeat.i(216738);
          if (!b.b(b.this))
          {
            AppMethodBeat.o(216738);
            return false;
          }
          if ((b.this.getLayoutParams() instanceof RelativeLayout.LayoutParams))
          {
            RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)b.this.getLayoutParams();
            int j = (int)(localLayoutParams.leftMargin + (paramAnonymousMotionEvent2.getX() - paramAnonymousMotionEvent1.getX()));
            int i = (int)(localLayoutParams.topMargin + (paramAnonymousMotionEvent2.getY() - paramAnonymousMotionEvent1.getY()));
            j = Math.max(Math.min(ar.ci(b.this.getContext()).x - b.this.getWidth(), j), 0);
            i = Math.max(Math.min(ar.ci(b.this.getContext()).y - b.this.getHeight(), i), 0);
            localLayoutParams.leftMargin = j;
            localLayoutParams.topMargin = i;
            b.this.setLayoutParams(localLayoutParams);
          }
          AppMethodBeat.o(216738);
          return true;
        }
        
        public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(216737);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/core/view/TRTCVideoLayout$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
          if (b.a(b.this) != null) {
            b.a(b.this).onClick(b.this);
          }
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/live/core/view/TRTCVideoLayout$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(216737);
          return true;
        }
      });
      setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(216742);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/core/view/TRTCVideoLayout$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
          switch (paramAnonymousMotionEvent.getActionMasked())
          {
          }
          for (;;)
          {
            paramAnonymousView = b.f(b.this);
            paramAnonymousMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousMotionEvent.ahp(), "com/tencent/mm/live/core/view/TRTCVideoLayout$2", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
            boolean bool = com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousView.onTouchEvent((MotionEvent)paramAnonymousMotionEvent.mq(0)), "com/tencent/mm/live/core/view/TRTCVideoLayout$2", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
            com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/live/core/view/TRTCVideoLayout$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(216742);
            return bool;
            b.a(b.this, paramAnonymousMotionEvent.getRawX());
            b.b(b.this, paramAnonymousMotionEvent.getRawY());
            continue;
            float f1 = paramAnonymousMotionEvent.getRawX();
            float f2 = b.c(b.this);
            float f3 = paramAnonymousMotionEvent.getRawY();
            float f4 = b.d(b.this);
            if ((b.b(b.this)) && (b.e(b.this) != null)) {
              b.e(b.this).A(f1 - f2, f3 - f4);
            }
          }
        }
      });
      this.gMo = new HashMap();
      AppMethodBeat.o(216743);
      return;
      this.gMd = ((SurfaceView)this.gMn.findViewById(2131307597));
      this.gMd.setVisibility(0);
    }
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(216747);
    this.gIP = new WeakReference(paramb);
    AppMethodBeat.o(216747);
  }
  
  public final void amJ()
  {
    AppMethodBeat.i(216744);
    if (this.gMg != null) {
      this.gMg.setVisibility(8);
    }
    AppMethodBeat.o(216744);
  }
  
  public final void onClick(View paramView)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    AppMethodBeat.i(216746);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/core/view/TRTCVideoLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
    if (this.gIP != null) {}
    for (localObject = (b)this.gIP.get(); localObject == null; localObject = null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/core/view/TRTCVideoLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(216746);
      return;
    }
    int i = paramView.getId();
    if (i == 2131308045) {
      if (!this.gMq)
      {
        bool1 = true;
        this.gMq = bool1;
        ((b)localObject).g(this);
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/core/view/TRTCVideoLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(216746);
      return;
      bool1 = false;
      break;
      if (i == 2131308046)
      {
        if (!this.gJb) {}
        for (;;)
        {
          this.gJb = bool1;
          ((b)localObject).h(this);
          break;
          bool1 = false;
        }
      }
      if (i == 2131308047)
      {
        if (!this.gJq) {}
        for (bool1 = bool2;; bool1 = false)
        {
          this.gJq = bool1;
          ((b)localObject).i(this);
          break;
        }
      }
      if (i == 2131307882)
      {
        ((ToggleButton)paramView).isChecked();
        ((b)localObject).j(this);
      }
    }
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.gMe = paramOnClickListener;
  }
  
  public final void xB(String paramString)
  {
    AppMethodBeat.i(216745);
    if (this.gMl != null) {
      this.gMl.setText(paramString);
    }
    if (this.gMk != null) {
      this.gMk.setVisibility(8);
    }
    AppMethodBeat.o(216745);
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