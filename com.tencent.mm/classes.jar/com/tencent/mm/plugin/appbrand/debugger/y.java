package com.tencent.mm.plugin.appbrand.debugger;

import android.annotation.SuppressLint;
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
import com.tencent.luggage.l.a.a;
import com.tencent.luggage.l.a.c;
import com.tencent.luggage.l.a.d;
import com.tencent.luggage.l.a.e;
import com.tencent.luggage.l.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.protocal.protobuf.ffk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import java.util.LinkedList;

@SuppressLint({"ViewConstructor"})
public final class y
  extends FrameLayout
{
  private o cAD;
  private View.OnClickListener mOnClickListener;
  ViewGroup odJ;
  RemoteDebugMoveView odK;
  private LinkedList<String> odL;
  private TextView odM;
  private TextView odN;
  private TextView odO;
  private TextView odP;
  private TextView odQ;
  private TextView odR;
  private TextView odS;
  private ImageView odT;
  private ImageView odU;
  private View odV;
  boolean odW;
  private a odX;
  private d odY;
  
  public y(Context paramContext, o paramo, a parama)
  {
    super(paramContext);
    AppMethodBeat.i(147113);
    this.odL = new LinkedList();
    this.odW = false;
    this.mOnClickListener = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(147106);
        Object localObject = new b();
        ((b)localObject).bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/appbrand/debugger/RemoteDebugView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
        localObject = y.this;
        if (paramAnonymousView.getId() == a.d.app_brand_remote_debug_expand_tv)
        {
          ((y)localObject).odW = true;
          ((y)localObject).show();
          paramAnonymousView = ((y)localObject).odK;
          paramAnonymousView.postDelayed(new RemoteDebugMoveView.3(paramAnonymousView), 50L);
        }
        for (;;)
        {
          a.a(this, "com/tencent/mm/plugin/appbrand/debugger/RemoteDebugView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(147106);
          return;
          if (paramAnonymousView.getId() == a.d.app_brand_remote_debug_collapse_tv)
          {
            ((y)localObject).odW = false;
            ((y)localObject).show();
          }
          else if (paramAnonymousView.getId() == a.d.app_brand_remote_debug_quit_tv)
          {
            ((y)localObject).bMy();
          }
        }
      }
    };
    this.cAD = paramo;
    this.odX = parama;
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    setBackgroundColor(getContext().getResources().getColor(a.a.transparent));
    setId(a.d.app_brand_debug_view);
    AppMethodBeat.o(147113);
  }
  
  private boolean bMv()
  {
    AppMethodBeat.i(147118);
    if ((this.cAD.bMd()) || (this.cAD.isQuit()) || (this.cAD.bMe()))
    {
      AppMethodBeat.o(147118);
      return true;
    }
    AppMethodBeat.o(147118);
    return false;
  }
  
  private void bMw()
  {
    AppMethodBeat.i(147119);
    this.odK = ((RemoteDebugMoveView)LayoutInflater.from(getContext()).inflate(a.e.app_brand_remote_debug_move_view, null));
    this.odN = ((TextView)this.odK.findViewById(a.d.app_brand_remote_debug_connect_tv));
    this.odM = ((TextView)this.odK.findViewById(a.d.app_brand_remote_debug_server_tv));
    this.odO = ((TextView)this.odK.findViewById(a.d.app_brand_remote_debug_info_tv));
    this.odP = ((TextView)this.odK.findViewById(a.d.app_brand_remote_debug_quit_tv));
    this.odQ = ((TextView)this.odK.findViewById(a.d.app_brand_remote_debug_expand_tv));
    this.odR = ((TextView)this.odK.findViewById(a.d.app_brand_remote_debug_collapse_tv));
    this.odS = ((TextView)this.odK.findViewById(a.d.app_brand_remote_debug_error_tv));
    this.odU = ((ImageView)this.odK.findViewById(a.d.app_brand_remote_debug_connect_dot));
    this.odT = ((ImageView)this.odK.findViewById(a.d.app_brand_remote_debug_server_dot));
    this.odV = this.odK.findViewById(a.d.app_brand_remote_debug_detail_layout);
    show();
    bMx();
    AppMethodBeat.o(147119);
  }
  
  private void bMx()
  {
    AppMethodBeat.i(147120);
    this.odQ.setOnClickListener(this.mOnClickListener);
    this.odR.setOnClickListener(this.mOnClickListener);
    this.odP.setOnClickListener(this.mOnClickListener);
    AppMethodBeat.o(147120);
  }
  
  public final void U(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(242912);
    this.odJ = paramAppBrandRuntime.ntC;
    if ((getParent() instanceof ViewGroup)) {
      ((ViewGroup)getParent()).removeView(this);
    }
    paramAppBrandRuntime.cM(this);
    bMw();
    postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(147104);
        RemoteDebugMoveView localRemoteDebugMoveView = y.a(y.this);
        int i = y.this.getWidth();
        int j = y.this.getHeight();
        localRemoteDebugMoveView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        localRemoteDebugMoveView.jMo = i;
        localRemoteDebugMoveView.bxE = j;
        localRemoteDebugMoveView.post(new RemoteDebugMoveView.1(localRemoteDebugMoveView));
        y.this.addView(y.a(y.this));
        AppMethodBeat.o(147104);
      }
    }, 100L);
    AppMethodBeat.o(242912);
  }
  
  public final void afO(final String paramString)
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
  
  public final void bMA()
  {
    AppMethodBeat.i(147124);
    bMu();
    bMz();
    AppMethodBeat.o(147124);
  }
  
  public final void bMu()
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
  
  final void bMy()
  {
    AppMethodBeat.i(147121);
    if ((this.odY != null) && (this.odY.isShowing()))
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
    this.odY = new d.a(localContext).bBc(localContext.getString(a.g.app_brand_remote_debug_quit_confirm)).bBd("").ayj(a.g.button_ok).c(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(147107);
        if (y.d(y.this) != null) {
          y.d(y.this).bMh();
        }
        AppMethodBeat.o(147107);
      }
    }).ayk(a.g.button_cancel).icu();
    this.odY.show();
    AppMethodBeat.o(147121);
  }
  
  public final void bMz()
  {
    AppMethodBeat.i(147122);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(147108);
        if (y.e(y.this).bMd())
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
  
  public final void bringToFront()
  {
    AppMethodBeat.i(147116);
    if (this.odJ == null)
    {
      Log.w("MicroMsg.RemoteDebugView", "bringToFront mContentView is null");
      AppMethodBeat.o(147116);
      return;
    }
    AppMethodBeat.o(147116);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(147114);
    if (bMv())
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
    if (this.odW)
    {
      this.odV.setVisibility(0);
      if (this.odL.size() > 0)
      {
        this.odS.setVisibility(0);
        this.odQ.setVisibility(8);
      }
    }
    for (;;)
    {
      invalidate();
      AppMethodBeat.o(147123);
      return;
      this.odS.setVisibility(8);
      break;
      this.odV.setVisibility(8);
      this.odS.setVisibility(8);
      this.odQ.setVisibility(0);
    }
  }
  
  public static abstract interface a
  {
    public abstract void bMh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.y
 * JD-Core Version:    0.7.0.1
 */