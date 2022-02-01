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
import com.tencent.mm.ui.ap;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.lang.ref.WeakReference;
import java.util.HashMap;

final class b
  extends RelativeLayout
  implements View.OnClickListener
{
  private boolean gpG;
  public WeakReference<b> gph;
  private boolean gps;
  private TextView gsA;
  private ImageView gsB;
  private ViewGroup gsC;
  private HashMap<Integer, Integer> gsD;
  boolean gsE;
  private boolean gsF;
  private boolean gsG;
  b.a gsH;
  private float gsI;
  private float gsJ;
  SurfaceView gss;
  private View.OnClickListener gst;
  private GestureDetector gsu;
  private LinearLayout gsv;
  private Button gsw;
  private Button gsx;
  private Button gsy;
  private FrameLayout gsz;
  TXCloudVideoView mVideoView;
  
  public b(Context paramContext, boolean paramBoolean)
  {
    this(paramContext, paramBoolean, (byte)0);
  }
  
  private b(Context paramContext, boolean paramBoolean, byte paramByte)
  {
    super(paramContext, null);
    AppMethodBeat.i(209086);
    this.gsD = null;
    this.gsF = false;
    this.gps = true;
    this.gpG = true;
    this.gsG = false;
    this.gsH = null;
    this.gsI = 0.0F;
    this.gsJ = 0.0F;
    this.gsG = paramBoolean;
    this.gsC = ((ViewGroup)LayoutInflater.from(getContext()).inflate(2131496279, this, true));
    if (this.gsG)
    {
      this.mVideoView = ((TXCloudVideoView)this.gsC.findViewById(2131307812));
      this.mVideoView.setVisibility(0);
    }
    for (;;)
    {
      this.gsv = ((LinearLayout)this.gsC.findViewById(2131308050));
      this.gsw = ((Button)this.gsC.findViewById(2131308047));
      this.gsw.setOnClickListener(this);
      this.gsx = ((Button)this.gsC.findViewById(2131308046));
      this.gsx.setOnClickListener(this);
      this.gsy = ((Button)this.gsC.findViewById(2131308045));
      this.gsy.setOnClickListener(this);
      this.gsz = ((FrameLayout)this.gsC.findViewById(2131308048));
      this.gsA = ((TextView)this.gsC.findViewById(2131308051));
      this.gsB = ((ImageView)this.gsC.findViewById(2131308049));
      ((ToggleButton)this.gsC.findViewById(2131307882)).setOnClickListener(this);
      this.gsu = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener()
      {
        public final boolean onDown(MotionEvent paramAnonymousMotionEvent)
        {
          return true;
        }
        
        public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
        {
          AppMethodBeat.i(209084);
          if (!b.b(b.this))
          {
            AppMethodBeat.o(209084);
            return false;
          }
          if ((b.this.getLayoutParams() instanceof RelativeLayout.LayoutParams))
          {
            RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)b.this.getLayoutParams();
            int j = (int)(localLayoutParams.leftMargin + (paramAnonymousMotionEvent2.getX() - paramAnonymousMotionEvent1.getX()));
            int i = (int)(localLayoutParams.topMargin + (paramAnonymousMotionEvent2.getY() - paramAnonymousMotionEvent1.getY()));
            j = Math.max(Math.min(ap.cl(b.this.getContext()).x - b.this.getWidth(), j), 0);
            i = Math.max(Math.min(ap.cl(b.this.getContext()).y - b.this.getHeight(), i), 0);
            localLayoutParams.leftMargin = j;
            localLayoutParams.topMargin = i;
            b.this.setLayoutParams(localLayoutParams);
          }
          AppMethodBeat.o(209084);
          return true;
        }
        
        public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(209083);
          if (b.a(b.this) != null) {
            b.a(b.this).onClick(b.this);
          }
          AppMethodBeat.o(209083);
          return true;
        }
      });
      setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(209085);
          switch (paramAnonymousMotionEvent.getActionMasked())
          {
          }
          for (;;)
          {
            boolean bool = b.f(b.this).onTouchEvent(paramAnonymousMotionEvent);
            AppMethodBeat.o(209085);
            return bool;
            b.a(b.this, paramAnonymousMotionEvent.getRawX());
            b.b(b.this, paramAnonymousMotionEvent.getRawY());
            continue;
            float f1 = paramAnonymousMotionEvent.getRawX();
            float f2 = b.c(b.this);
            float f3 = paramAnonymousMotionEvent.getRawY();
            float f4 = b.d(b.this);
            if ((b.b(b.this)) && (b.e(b.this) != null)) {
              b.e(b.this).y(f1 - f2, f3 - f4);
            }
          }
        }
      });
      this.gsD = new HashMap();
      AppMethodBeat.o(209086);
      return;
      this.gss = ((SurfaceView)this.gsC.findViewById(2131307597));
      this.gss.setVisibility(0);
    }
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(209090);
    this.gph = new WeakReference(paramb);
    AppMethodBeat.o(209090);
  }
  
  public final void ajX()
  {
    AppMethodBeat.i(209087);
    if (this.gsv != null) {
      this.gsv.setVisibility(8);
    }
    AppMethodBeat.o(209087);
  }
  
  public final void onClick(View paramView)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    AppMethodBeat.i(209089);
    if (this.gph != null) {}
    for (b localb = (b)this.gph.get(); localb == null; localb = null)
    {
      AppMethodBeat.o(209089);
      return;
    }
    int i = paramView.getId();
    if (i == 2131308045)
    {
      if (!this.gsF) {}
      for (bool1 = true;; bool1 = false)
      {
        this.gsF = bool1;
        localb.g(this);
        AppMethodBeat.o(209089);
        return;
      }
    }
    if (i == 2131308046)
    {
      if (!this.gps) {}
      for (;;)
      {
        this.gps = bool1;
        localb.h(this);
        AppMethodBeat.o(209089);
        return;
        bool1 = false;
      }
    }
    if (i == 2131308047)
    {
      if (!this.gpG) {}
      for (bool1 = bool2;; bool1 = false)
      {
        this.gpG = bool1;
        localb.i(this);
        AppMethodBeat.o(209089);
        return;
      }
    }
    if (i == 2131307882)
    {
      ((ToggleButton)paramView).isChecked();
      localb.j(this);
    }
    AppMethodBeat.o(209089);
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.gst = paramOnClickListener;
  }
  
  public final void uK(String paramString)
  {
    AppMethodBeat.i(209088);
    if (this.gsA != null) {
      this.gsA.setText(paramString);
    }
    if (this.gsz != null) {
      this.gsz.setVisibility(8);
    }
    AppMethodBeat.o(209088);
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