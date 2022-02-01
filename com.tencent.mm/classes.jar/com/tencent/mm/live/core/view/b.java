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
import com.tencent.mm.ui.au;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public final class b
  extends RelativeLayout
  implements View.OnClickListener
{
  public WeakReference<b> hAW;
  private boolean hBi;
  private boolean hBz;
  SurfaceView hEY;
  private View.OnClickListener hEZ;
  private GestureDetector hFa;
  private LinearLayout hFb;
  private Button hFc;
  private Button hFd;
  private Button hFe;
  private FrameLayout hFf;
  private TextView hFg;
  private ImageView hFh;
  private ViewGroup hFi;
  private HashMap<Integer, Integer> hFj;
  boolean hFk;
  private boolean hFl;
  private boolean hFm;
  b.a hFn;
  private float hFo;
  private float hFp;
  TXCloudVideoView mVideoView;
  
  public b(Context paramContext, boolean paramBoolean)
  {
    this(paramContext, paramBoolean, (byte)0);
  }
  
  private b(Context paramContext, boolean paramBoolean, byte paramByte)
  {
    super(paramContext, null);
    AppMethodBeat.i(196332);
    this.hFj = null;
    this.hFl = false;
    this.hBi = true;
    this.hBz = true;
    this.hFm = false;
    this.hFn = null;
    this.hFo = 0.0F;
    this.hFp = 0.0F;
    this.hFm = paramBoolean;
    this.hFi = ((ViewGroup)LayoutInflater.from(getContext()).inflate(2131495200, this, true));
    if (this.hFm)
    {
      this.mVideoView = ((TXCloudVideoView)this.hFi.findViewById(2131303600));
      this.mVideoView.setVisibility(0);
    }
    for (;;)
    {
      this.hFb = ((LinearLayout)this.hFi.findViewById(2131309417));
      this.hFc = ((Button)this.hFi.findViewById(2131309414));
      this.hFc.setOnClickListener(this);
      this.hFd = ((Button)this.hFi.findViewById(2131309413));
      this.hFd.setOnClickListener(this);
      this.hFe = ((Button)this.hFi.findViewById(2131309412));
      this.hFe.setOnClickListener(this);
      this.hFf = ((FrameLayout)this.hFi.findViewById(2131309415));
      this.hFg = ((TextView)this.hFi.findViewById(2131309418));
      this.hFh = ((ImageView)this.hFi.findViewById(2131309416));
      ((ToggleButton)this.hFi.findViewById(2131305121)).setOnClickListener(this);
      this.hFa = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener()
      {
        public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(196330);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/core/view/TRTCVideoLayout$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
          boolean bool = super.onContextClick(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/live/core/view/TRTCVideoLayout$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(196330);
          return bool;
        }
        
        public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(196329);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/core/view/TRTCVideoLayout$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
          boolean bool = super.onDoubleTap(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/live/core/view/TRTCVideoLayout$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(196329);
          return bool;
        }
        
        public final boolean onDown(MotionEvent paramAnonymousMotionEvent)
        {
          return true;
        }
        
        public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(196328);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/core/view/TRTCVideoLayout$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.axR());
          super.onLongPress(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/core/view/TRTCVideoLayout$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
          AppMethodBeat.o(196328);
        }
        
        public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
        {
          AppMethodBeat.i(196327);
          if (!b.b(b.this))
          {
            AppMethodBeat.o(196327);
            return false;
          }
          if ((b.this.getLayoutParams() instanceof RelativeLayout.LayoutParams))
          {
            RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)b.this.getLayoutParams();
            int j = (int)(localLayoutParams.leftMargin + (paramAnonymousMotionEvent2.getX() - paramAnonymousMotionEvent1.getX()));
            int i = (int)(localLayoutParams.topMargin + (paramAnonymousMotionEvent2.getY() - paramAnonymousMotionEvent1.getY()));
            j = Math.max(Math.min(au.az(b.this.getContext()).x - b.this.getWidth(), j), 0);
            i = Math.max(Math.min(au.az(b.this.getContext()).y - b.this.getHeight(), i), 0);
            localLayoutParams.leftMargin = j;
            localLayoutParams.topMargin = i;
            b.this.setLayoutParams(localLayoutParams);
          }
          AppMethodBeat.o(196327);
          return true;
        }
        
        public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(196326);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/core/view/TRTCVideoLayout$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
          if (b.a(b.this) != null) {
            b.a(b.this).onClick(b.this);
          }
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/live/core/view/TRTCVideoLayout$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(196326);
          return true;
        }
      });
      setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(196331);
          switch (paramAnonymousMotionEvent.getActionMasked())
          {
          }
          for (;;)
          {
            paramAnonymousView = b.f(b.this);
            paramAnonymousMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousMotionEvent.axQ(), "com/tencent/mm/live/core/view/TRTCVideoLayout$2", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
            boolean bool = com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousView.onTouchEvent((MotionEvent)paramAnonymousMotionEvent.pG(0)), "com/tencent/mm/live/core/view/TRTCVideoLayout$2", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(196331);
            return bool;
            b.a(b.this, paramAnonymousMotionEvent.getRawX());
            b.b(b.this, paramAnonymousMotionEvent.getRawY());
            continue;
            float f1 = paramAnonymousMotionEvent.getRawX();
            float f2 = b.c(b.this);
            float f3 = paramAnonymousMotionEvent.getRawY();
            float f4 = b.d(b.this);
            if ((b.b(b.this)) && (b.e(b.this) != null)) {
              b.e(b.this).C(f1 - f2, f3 - f4);
            }
          }
        }
      });
      this.hFj = new HashMap();
      AppMethodBeat.o(196332);
      return;
      this.hEY = ((SurfaceView)this.hFi.findViewById(2131303358));
      this.hEY.setVisibility(0);
    }
  }
  
  public final void GF(String paramString)
  {
    AppMethodBeat.i(196334);
    if (this.hFg != null) {
      this.hFg.setText(paramString);
    }
    if (this.hFf != null) {
      this.hFf.setVisibility(8);
    }
    AppMethodBeat.o(196334);
  }
  
  public final SurfaceView getCameraView()
  {
    return this.hEY;
  }
  
  public final TXCloudVideoView getVideoView()
  {
    return this.mVideoView;
  }
  
  public final void onClick(View paramView)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    AppMethodBeat.i(196335);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/core/view/TRTCVideoLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
    if (this.hAW != null) {}
    for (localObject = (b)this.hAW.get(); localObject == null; localObject = null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/core/view/TRTCVideoLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(196335);
      return;
    }
    int i = paramView.getId();
    if (i == 2131309412) {
      if (!this.hFl)
      {
        bool1 = true;
        this.hFl = bool1;
        ((b)localObject).g(this);
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/core/view/TRTCVideoLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(196335);
      return;
      bool1 = false;
      break;
      if (i == 2131309413)
      {
        if (!this.hBi) {}
        for (;;)
        {
          this.hBi = bool1;
          ((b)localObject).h(this);
          break;
          bool1 = false;
        }
      }
      if (i == 2131309414)
      {
        if (!this.hBz) {}
        for (bool1 = bool2;; bool1 = false)
        {
          this.hBz = bool1;
          ((b)localObject).i(this);
          break;
        }
      }
      if (i == 2131305121)
      {
        ((ToggleButton)paramView).isChecked();
        ((b)localObject).j(this);
      }
    }
  }
  
  public final void setBottomControllerVisibility(int paramInt)
  {
    AppMethodBeat.i(196333);
    if (this.hFb != null) {
      this.hFb.setVisibility(8);
    }
    AppMethodBeat.o(196333);
  }
  
  public final void setGestureListener(b.a parama)
  {
    this.hFn = parama;
  }
  
  public final void setIVideoLayoutListener(b paramb)
  {
    AppMethodBeat.i(196336);
    this.hAW = new WeakReference(paramb);
    AppMethodBeat.o(196336);
  }
  
  public final void setMoveable(boolean paramBoolean)
  {
    this.hFk = paramBoolean;
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.hEZ = paramOnClickListener;
  }
  
  public static abstract interface b
  {
    public abstract void g(b paramb);
    
    public abstract void h(b paramb);
    
    public abstract void i(b paramb);
    
    public abstract void j(b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.core.view.b
 * JD-Core Version:    0.7.0.1
 */