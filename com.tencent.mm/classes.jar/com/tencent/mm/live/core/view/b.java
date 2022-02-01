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
  private boolean gLK;
  private boolean gLZ;
  public WeakReference<b> gLy;
  SurfaceView gOM;
  private View.OnClickListener gON;
  private GestureDetector gOO;
  private LinearLayout gOP;
  private Button gOQ;
  private Button gOR;
  private Button gOS;
  private FrameLayout gOT;
  private TextView gOU;
  private ImageView gOV;
  private ViewGroup gOW;
  private HashMap<Integer, Integer> gOX;
  boolean gOY;
  private boolean gOZ;
  private boolean gPa;
  b.a gPb;
  private float gPc;
  private float gPd;
  TXCloudVideoView mVideoView;
  
  public b(Context paramContext, boolean paramBoolean)
  {
    this(paramContext, paramBoolean, (byte)0);
  }
  
  private b(Context paramContext, boolean paramBoolean, byte paramByte)
  {
    super(paramContext, null);
    AppMethodBeat.i(197142);
    this.gOX = null;
    this.gOZ = false;
    this.gLK = true;
    this.gLZ = true;
    this.gPa = false;
    this.gPb = null;
    this.gPc = 0.0F;
    this.gPd = 0.0F;
    this.gPa = paramBoolean;
    this.gOW = ((ViewGroup)LayoutInflater.from(getContext()).inflate(2131496279, this, true));
    if (this.gPa)
    {
      this.mVideoView = ((TXCloudVideoView)this.gOW.findViewById(2131307812));
      this.mVideoView.setVisibility(0);
    }
    for (;;)
    {
      this.gOP = ((LinearLayout)this.gOW.findViewById(2131308050));
      this.gOQ = ((Button)this.gOW.findViewById(2131308047));
      this.gOQ.setOnClickListener(this);
      this.gOR = ((Button)this.gOW.findViewById(2131308046));
      this.gOR.setOnClickListener(this);
      this.gOS = ((Button)this.gOW.findViewById(2131308045));
      this.gOS.setOnClickListener(this);
      this.gOT = ((FrameLayout)this.gOW.findViewById(2131308048));
      this.gOU = ((TextView)this.gOW.findViewById(2131308051));
      this.gOV = ((ImageView)this.gOW.findViewById(2131308049));
      ((ToggleButton)this.gOW.findViewById(2131307882)).setOnClickListener(this);
      this.gOO = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener()
      {
        public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(197140);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/core/view/TRTCVideoLayout$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
          boolean bool = super.onContextClick(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/live/core/view/TRTCVideoLayout$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(197140);
          return bool;
        }
        
        public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(197139);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/core/view/TRTCVideoLayout$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
          boolean bool = super.onDoubleTap(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/live/core/view/TRTCVideoLayout$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(197139);
          return bool;
        }
        
        public final boolean onDown(MotionEvent paramAnonymousMotionEvent)
        {
          return true;
        }
        
        public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(197138);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/core/view/TRTCVideoLayout$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahF());
          super.onLongPress(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/core/view/TRTCVideoLayout$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
          AppMethodBeat.o(197138);
        }
        
        public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
        {
          AppMethodBeat.i(197137);
          if (!b.b(b.this))
          {
            AppMethodBeat.o(197137);
            return false;
          }
          if ((b.this.getLayoutParams() instanceof RelativeLayout.LayoutParams))
          {
            RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)b.this.getLayoutParams();
            int j = (int)(localLayoutParams.leftMargin + (paramAnonymousMotionEvent2.getX() - paramAnonymousMotionEvent1.getX()));
            int i = (int)(localLayoutParams.topMargin + (paramAnonymousMotionEvent2.getY() - paramAnonymousMotionEvent1.getY()));
            j = Math.max(Math.min(ar.ck(b.this.getContext()).x - b.this.getWidth(), j), 0);
            i = Math.max(Math.min(ar.ck(b.this.getContext()).y - b.this.getHeight(), i), 0);
            localLayoutParams.leftMargin = j;
            localLayoutParams.topMargin = i;
            b.this.setLayoutParams(localLayoutParams);
          }
          AppMethodBeat.o(197137);
          return true;
        }
        
        public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(197136);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/core/view/TRTCVideoLayout$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
          if (b.a(b.this) != null) {
            b.a(b.this).onClick(b.this);
          }
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/live/core/view/TRTCVideoLayout$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(197136);
          return true;
        }
      });
      setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(197141);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/core/view/TRTCVideoLayout$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
          switch (paramAnonymousMotionEvent.getActionMasked())
          {
          }
          for (;;)
          {
            paramAnonymousView = b.f(b.this);
            paramAnonymousMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousMotionEvent.ahE(), "com/tencent/mm/live/core/view/TRTCVideoLayout$2", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
            boolean bool = com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousView.onTouchEvent((MotionEvent)paramAnonymousMotionEvent.mt(0)), "com/tencent/mm/live/core/view/TRTCVideoLayout$2", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
            com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/live/core/view/TRTCVideoLayout$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(197141);
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
      this.gOX = new HashMap();
      AppMethodBeat.o(197142);
      return;
      this.gOM = ((SurfaceView)this.gOW.findViewById(2131307597));
      this.gOM.setVisibility(0);
    }
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(197146);
    this.gLy = new WeakReference(paramb);
    AppMethodBeat.o(197146);
  }
  
  public final void amY()
  {
    AppMethodBeat.i(197143);
    if (this.gOP != null) {
      this.gOP.setVisibility(8);
    }
    AppMethodBeat.o(197143);
  }
  
  public final void onClick(View paramView)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    AppMethodBeat.i(197145);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/core/view/TRTCVideoLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
    if (this.gLy != null) {}
    for (localObject = (b)this.gLy.get(); localObject == null; localObject = null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/core/view/TRTCVideoLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(197145);
      return;
    }
    int i = paramView.getId();
    if (i == 2131308045) {
      if (!this.gOZ)
      {
        bool1 = true;
        this.gOZ = bool1;
        ((b)localObject).g(this);
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/core/view/TRTCVideoLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(197145);
      return;
      bool1 = false;
      break;
      if (i == 2131308046)
      {
        if (!this.gLK) {}
        for (;;)
        {
          this.gLK = bool1;
          ((b)localObject).h(this);
          break;
          bool1 = false;
        }
      }
      if (i == 2131308047)
      {
        if (!this.gLZ) {}
        for (bool1 = bool2;; bool1 = false)
        {
          this.gLZ = bool1;
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
    this.gON = paramOnClickListener;
  }
  
  public final void yk(String paramString)
  {
    AppMethodBeat.i(197144);
    if (this.gOU != null) {
      this.gOU.setText(paramString);
    }
    if (this.gOT != null) {
      this.gOT.setVisibility(8);
    }
    AppMethodBeat.o(197144);
  }
  
  public static abstract interface b
  {
    public abstract void g(b paramb);
    
    public abstract void h(b paramb);
    
    public abstract void i(b paramb);
    
    public abstract void j(b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.core.view.b
 * JD-Core Version:    0.7.0.1
 */