package com.tencent.mm.plugin.appbrand.debugger;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.luggage.m.a.a;
import com.tencent.luggage.m.a.c;
import com.tencent.luggage.m.a.d;
import com.tencent.luggage.m.a.e;
import com.tencent.luggage.m.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.protocal.protobuf.gbw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a;
import java.util.LinkedList;

public final class y
  extends FrameLayout
{
  private o esY;
  ViewGroup ewc;
  private View.OnClickListener mOnClickListener;
  RemoteDebugMoveView reD;
  private LinkedList<String> reE;
  private TextView reF;
  private TextView reG;
  private TextView reH;
  private TextView reI;
  private TextView reJ;
  private TextView reK;
  private TextView reL;
  private ImageView reM;
  private ImageView reN;
  private View reO;
  boolean reP;
  private a reQ;
  private e reR;
  
  public y(Context paramContext, o paramo, a parama)
  {
    super(paramContext);
    AppMethodBeat.i(147113);
    this.reE = new LinkedList();
    this.reP = false;
    this.mOnClickListener = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(147106);
        Object localObject = new b();
        ((b)localObject).cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/appbrand/debugger/RemoteDebugView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
        localObject = y.this;
        if (paramAnonymousView.getId() == a.d.app_brand_remote_debug_expand_tv)
        {
          ((y)localObject).reP = true;
          ((y)localObject).show();
          paramAnonymousView = ((y)localObject).reD;
          paramAnonymousView.postDelayed(new RemoteDebugMoveView.3(paramAnonymousView), 50L);
        }
        for (;;)
        {
          a.a(this, "com/tencent/mm/plugin/appbrand/debugger/RemoteDebugView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(147106);
          return;
          if (paramAnonymousView.getId() == a.d.app_brand_remote_debug_collapse_tv)
          {
            ((y)localObject).reP = false;
            ((y)localObject).show();
          }
          else if (paramAnonymousView.getId() == a.d.app_brand_remote_debug_quit_tv)
          {
            ((y)localObject).clY();
          }
        }
      }
    };
    this.esY = paramo;
    this.reQ = parama;
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    setBackgroundColor(getContext().getResources().getColor(a.a.transparent));
    setId(a.d.app_brand_debug_view);
    AppMethodBeat.o(147113);
  }
  
  private boolean clV()
  {
    AppMethodBeat.i(147118);
    if ((this.esY.clD()) || (this.esY.isQuit()) || (this.esY.clE()))
    {
      AppMethodBeat.o(147118);
      return true;
    }
    AppMethodBeat.o(147118);
    return false;
  }
  
  private void clW()
  {
    AppMethodBeat.i(147119);
    this.reD = ((RemoteDebugMoveView)LayoutInflater.from(getContext()).inflate(a.e.app_brand_remote_debug_move_view, null));
    this.reG = ((TextView)this.reD.findViewById(a.d.app_brand_remote_debug_connect_tv));
    this.reF = ((TextView)this.reD.findViewById(a.d.app_brand_remote_debug_server_tv));
    this.reH = ((TextView)this.reD.findViewById(a.d.app_brand_remote_debug_info_tv));
    this.reI = ((TextView)this.reD.findViewById(a.d.app_brand_remote_debug_quit_tv));
    this.reJ = ((TextView)this.reD.findViewById(a.d.app_brand_remote_debug_expand_tv));
    this.reK = ((TextView)this.reD.findViewById(a.d.app_brand_remote_debug_collapse_tv));
    this.reL = ((TextView)this.reD.findViewById(a.d.app_brand_remote_debug_error_tv));
    this.reN = ((ImageView)this.reD.findViewById(a.d.app_brand_remote_debug_connect_dot));
    this.reM = ((ImageView)this.reD.findViewById(a.d.app_brand_remote_debug_server_dot));
    this.reO = this.reD.findViewById(a.d.app_brand_remote_debug_detail_layout);
    show();
    clX();
    AppMethodBeat.o(147119);
  }
  
  private void clX()
  {
    AppMethodBeat.i(147120);
    this.reJ.setOnClickListener(this.mOnClickListener);
    this.reK.setOnClickListener(this.mOnClickListener);
    this.reI.setOnClickListener(this.mOnClickListener);
    AppMethodBeat.o(147120);
  }
  
  public final void Yn(final String paramString)
  {
    AppMethodBeat.i(147125);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(147125);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(147112);
        y.a(y.this, paramString);
        AppMethodBeat.o(147112);
      }
    });
    AppMethodBeat.o(147125);
  }
  
  public final void aEj()
  {
    AppMethodBeat.i(319755);
    cma();
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(147109);
        y.i(y.this);
        AppMethodBeat.o(147109);
      }
    });
    AppMethodBeat.o(319755);
  }
  
  public final void aa(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(319729);
    this.ewc = paramAppBrandRuntime.qsk;
    if ((getParent() instanceof ViewGroup)) {
      ((ViewGroup)getParent()).removeView(this);
    }
    paramAppBrandRuntime.dt(this);
    clW();
    postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(147104);
        RemoteDebugMoveView localRemoteDebugMoveView = y.a(y.this);
        int i = y.this.getWidth();
        int j = y.this.getHeight();
        localRemoteDebugMoveView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        localRemoteDebugMoveView.aMZ = i;
        localRemoteDebugMoveView.dqH = j;
        localRemoteDebugMoveView.post(new RemoteDebugMoveView.1(localRemoteDebugMoveView));
        y.this.addView(y.a(y.this));
        AppMethodBeat.o(147104);
      }
    }, 100L);
    AppMethodBeat.o(319729);
  }
  
  public final void bringToFront()
  {
    AppMethodBeat.i(147116);
    if (this.ewc == null)
    {
      Log.w("MicroMsg.RemoteDebugView", "bringToFront mContentView is null");
      AppMethodBeat.o(147116);
      return;
    }
    AppMethodBeat.o(147116);
  }
  
  public final void clU()
  {
    AppMethodBeat.i(147117);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(147105);
        if (y.b(y.this) == null)
        {
          Log.w("MicroMsg.RemoteDebugView", "showDebugView mContentView is null");
          AppMethodBeat.o(147105);
          return;
        }
        if (y.c(y.this))
        {
          y.this.setVisibility(0);
          if (y.b(y.this).indexOfChild(y.this) == -1) {
            y.b(y.this).addView(y.this);
          }
          y.b(y.this).bringChildToFront(y.this);
          y.this.setBackgroundColor(y.this.getContext().getResources().getColor(a.a.half_alpha_black));
          AppMethodBeat.o(147105);
          return;
        }
        y.this.setBackgroundColor(y.this.getContext().getResources().getColor(a.a.transparent));
        AppMethodBeat.o(147105);
      }
    });
    AppMethodBeat.o(147117);
  }
  
  final void clY()
  {
    AppMethodBeat.i(147121);
    if ((this.reR != null) && (this.reR.isShowing()))
    {
      AppMethodBeat.o(147121);
      return;
    }
    Context localContext = getContext();
    if (((localContext instanceof Activity)) && (((Activity)localContext).isFinishing()))
    {
      AppMethodBeat.o(147121);
      return;
    }
    this.reR = new e.a(localContext).bDv(localContext.getString(a.g.app_brand_remote_debug_quit_confirm)).bDw("").aER(a.g.button_ok).c(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(147107);
        if (y.d(y.this) != null) {
          y.d(y.this).clH();
        }
        AppMethodBeat.o(147107);
      }
    }).aES(a.g.button_cancel).jHH();
    this.reR.show();
    AppMethodBeat.o(147121);
  }
  
  public final void clZ()
  {
    AppMethodBeat.i(147122);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(147108);
        if (y.e(y.this).clD())
        {
          y.f(y.this).setImageResource(a.c.app_brand_remote_debug_normal_dot);
          y.g(y.this).setText(y.this.getContext().getString(a.g.app_brand_remote_debug_connect_hit_break_point));
        }
        for (;;)
        {
          y.h(y.this);
          AppMethodBeat.o(147108);
          return;
          if (y.e(y.this).isReady())
          {
            y.f(y.this).setImageResource(a.c.app_brand_remote_debug_normal_dot);
            y.g(y.this).setText(y.this.getContext().getString(a.g.app_brand_remote_debug_connect_normal));
          }
          else
          {
            y.f(y.this).setImageResource(a.c.app_brand_remote_debug_abnormal_dot);
            y.g(y.this).setText(y.this.getContext().getString(a.g.app_brand_remote_debug_connect_abnormal));
          }
        }
      }
    });
    AppMethodBeat.o(147122);
  }
  
  public final void cma()
  {
    AppMethodBeat.i(147124);
    clU();
    clZ();
    AppMethodBeat.o(147124);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(147114);
    if (clV())
    {
      AppMethodBeat.o(147114);
      return true;
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(147114);
    return bool;
  }
  
  public final void show()
  {
    AppMethodBeat.i(147123);
    if (this.reP)
    {
      this.reO.setVisibility(0);
      if (this.reE.size() > 0)
      {
        this.reL.setVisibility(0);
        this.reJ.setVisibility(8);
      }
    }
    for (;;)
    {
      invalidate();
      AppMethodBeat.o(147123);
      return;
      this.reL.setVisibility(8);
      break;
      this.reO.setVisibility(8);
      this.reL.setVisibility(8);
      this.reJ.setVisibility(0);
    }
  }
  
  public static abstract interface a
  {
    public abstract void clH();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.y
 * JD-Core Version:    0.7.0.1
 */