package com.tencent.mm.live.core.view;

import android.content.Context;
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
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.lang.ref.WeakReference;
import java.util.HashMap;

final class b
  extends RelativeLayout
  implements View.OnClickListener
{
  TXCloudVideoView mVideoView;
  private TextView nzC;
  private View.OnClickListener pgj;
  public WeakReference<b> qED;
  private boolean qGf;
  private boolean qGy;
  private Button qUA;
  private Button qUB;
  private Button qUC;
  private FrameLayout qUD;
  private ImageView qUE;
  private ViewGroup qUF;
  private HashMap<Integer, Integer> qUG;
  boolean qUH;
  private boolean qUI;
  private boolean qUJ;
  a qUK;
  private float qUL;
  private float qUM;
  SurfaceView qUx;
  private GestureDetector qUy;
  private LinearLayout qUz;
  
  public b(Context paramContext, boolean paramBoolean)
  {
    this(paramContext, paramBoolean, (byte)0);
  }
  
  private b(Context paramContext, boolean paramBoolean, byte paramByte)
  {
    super(paramContext, null);
    AppMethodBeat.i(205553);
    this.qUG = null;
    this.qUI = false;
    this.qGf = true;
    this.qGy = true;
    this.qUJ = false;
    this.qUK = null;
    this.qUL = 0.0F;
    this.qUM = 0.0F;
    this.qUJ = paramBoolean;
    this.qUF = ((ViewGroup)LayoutInflater.from(getContext()).inflate(2131496272, this, true));
    if (this.qUJ)
    {
      this.mVideoView = ((TXCloudVideoView)this.qUF.findViewById(2131307731));
      this.mVideoView.setVisibility(0);
    }
    for (;;)
    {
      this.qUz = ((LinearLayout)this.qUF.findViewById(2131307908));
      this.qUA = ((Button)this.qUF.findViewById(2131307905));
      this.qUA.setOnClickListener(this);
      this.qUB = ((Button)this.qUF.findViewById(2131307904));
      this.qUB.setOnClickListener(this);
      this.qUC = ((Button)this.qUF.findViewById(2131307903));
      this.qUC.setOnClickListener(this);
      this.qUD = ((FrameLayout)this.qUF.findViewById(2131307906));
      this.nzC = ((TextView)this.qUF.findViewById(2131307909));
      this.qUE = ((ImageView)this.qUF.findViewById(2131307907));
      ((ToggleButton)this.qUF.findViewById(2131307791)).setOnClickListener(this);
      this.qUy = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener()
      {
        public final boolean onDown(MotionEvent paramAnonymousMotionEvent)
        {
          return true;
        }
        
        public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
        {
          AppMethodBeat.i(205551);
          if (!b.b(b.this))
          {
            AppMethodBeat.o(205551);
            return false;
          }
          if ((b.this.getLayoutParams() instanceof RelativeLayout.LayoutParams))
          {
            RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)b.this.getLayoutParams();
            int i = (int)(localLayoutParams.leftMargin + (paramAnonymousMotionEvent2.getX() - paramAnonymousMotionEvent1.getX()));
            int j = (int)(localLayoutParams.topMargin + (paramAnonymousMotionEvent2.getY() - paramAnonymousMotionEvent1.getY()));
            localLayoutParams.leftMargin = i;
            localLayoutParams.topMargin = j;
            b.this.setLayoutParams(localLayoutParams);
          }
          AppMethodBeat.o(205551);
          return true;
        }
        
        public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(205550);
          if (b.a(b.this) != null) {
            b.a(b.this).onClick(b.this);
          }
          AppMethodBeat.o(205550);
          return true;
        }
      });
      setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(205552);
          switch (paramAnonymousMotionEvent.getActionMasked())
          {
          }
          for (;;)
          {
            boolean bool = b.f(b.this).onTouchEvent(paramAnonymousMotionEvent);
            AppMethodBeat.o(205552);
            return bool;
            b.a(b.this, paramAnonymousMotionEvent.getRawX());
            b.b(b.this, paramAnonymousMotionEvent.getRawY());
            continue;
            float f1 = paramAnonymousMotionEvent.getRawX();
            float f2 = b.c(b.this);
            float f3 = paramAnonymousMotionEvent.getRawY();
            float f4 = b.d(b.this);
            if ((b.b(b.this)) && (b.e(b.this) != null)) {
              b.e(b.this).ap(f1 - f2, f3 - f4);
            }
          }
        }
      });
      this.qUG = new HashMap();
      AppMethodBeat.o(205553);
      return;
      this.qUx = ((SurfaceView)this.qUF.findViewById(2131307516));
      this.qUx.setVisibility(0);
    }
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(205557);
    this.qED = new WeakReference(paramb);
    AppMethodBeat.o(205557);
  }
  
  public final void aUg(String paramString)
  {
    AppMethodBeat.i(205555);
    if (this.nzC != null) {
      this.nzC.setText(paramString);
    }
    if (this.qUD != null) {
      this.qUD.setVisibility(8);
    }
    AppMethodBeat.o(205555);
  }
  
  public final void dRc()
  {
    AppMethodBeat.i(205554);
    if (this.qUz != null) {
      this.qUz.setVisibility(8);
    }
    AppMethodBeat.o(205554);
  }
  
  public final void onClick(View paramView)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    AppMethodBeat.i(205556);
    if (this.qED != null) {}
    for (b localb = (b)this.qED.get(); localb == null; localb = null)
    {
      AppMethodBeat.o(205556);
      return;
    }
    int i = paramView.getId();
    if (i == 2131307903)
    {
      if (!this.qUI) {}
      for (bool1 = true;; bool1 = false)
      {
        this.qUI = bool1;
        localb.g(this);
        AppMethodBeat.o(205556);
        return;
      }
    }
    if (i == 2131307904)
    {
      if (!this.qGf) {}
      for (;;)
      {
        this.qGf = bool1;
        localb.h(this);
        AppMethodBeat.o(205556);
        return;
        bool1 = false;
      }
    }
    if (i == 2131307905)
    {
      if (!this.qGy) {}
      for (bool1 = bool2;; bool1 = false)
      {
        this.qGy = bool1;
        localb.i(this);
        AppMethodBeat.o(205556);
        return;
      }
    }
    if (i == 2131307791)
    {
      ((ToggleButton)paramView).isChecked();
      localb.j(this);
    }
    AppMethodBeat.o(205556);
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.pgj = paramOnClickListener;
  }
  
  public static abstract interface a
  {
    public abstract void ap(float paramFloat1, float paramFloat2);
  }
  
  public static abstract interface b
  {
    public abstract void g(b paramb);
    
    public abstract void h(b paramb);
    
    public abstract void i(b paramb);
    
    public abstract void j(b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.core.view.b
 * JD-Core Version:    0.7.0.1
 */