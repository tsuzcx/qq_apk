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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.protocal.protobuf.euz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import java.util.LinkedList;

@SuppressLint({"ViewConstructor"})
public final class w
  extends FrameLayout
{
  private m cBt;
  ViewGroup lja;
  RemoteDebugMoveView ljb;
  private LinkedList<String> ljc;
  private TextView ljd;
  private TextView lje;
  private TextView ljf;
  private TextView ljg;
  private TextView ljh;
  private TextView lji;
  private TextView ljj;
  private ImageView ljk;
  private ImageView ljl;
  private View ljm;
  boolean ljn;
  private a ljo;
  private d ljp;
  private View.OnClickListener mOnClickListener;
  
  public w(Context paramContext, m paramm, a parama)
  {
    super(paramContext);
    AppMethodBeat.i(147113);
    this.ljc = new LinkedList();
    this.ljn = false;
    this.mOnClickListener = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(147106);
        Object localObject = new b();
        ((b)localObject).bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/appbrand/debugger/RemoteDebugView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
        localObject = w.this;
        if (paramAnonymousView.getId() == 2131296909)
        {
          ((w)localObject).ljn = true;
          ((w)localObject).show();
          paramAnonymousView = ((w)localObject).ljb;
          paramAnonymousView.postDelayed(new RemoteDebugMoveView.3(paramAnonymousView), 50L);
        }
        for (;;)
        {
          a.a(this, "com/tencent/mm/plugin/appbrand/debugger/RemoteDebugView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(147106);
          return;
          if (paramAnonymousView.getId() == 2131296904)
          {
            ((w)localObject).ljn = false;
            ((w)localObject).show();
          }
          else if (paramAnonymousView.getId() == 2131296912)
          {
            ((w)localObject).bBd();
          }
        }
      }
    };
    this.cBt = paramm;
    this.ljo = parama;
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    setBackgroundColor(getContext().getResources().getColor(2131101287));
    setId(2131296783);
    AppMethodBeat.o(147113);
  }
  
  private boolean bBa()
  {
    AppMethodBeat.i(147118);
    if ((this.cBt.bAI()) || (this.cBt.isQuit()) || (this.cBt.bAJ()))
    {
      AppMethodBeat.o(147118);
      return true;
    }
    AppMethodBeat.o(147118);
    return false;
  }
  
  private void bBb()
  {
    AppMethodBeat.i(147119);
    this.ljb = ((RemoteDebugMoveView)LayoutInflater.from(getContext()).inflate(2131493089, null));
    this.lje = ((TextView)this.ljb.findViewById(2131296906));
    this.ljd = ((TextView)this.ljb.findViewById(2131296915));
    this.ljf = ((TextView)this.ljb.findViewById(2131296910));
    this.ljg = ((TextView)this.ljb.findViewById(2131296912));
    this.ljh = ((TextView)this.ljb.findViewById(2131296909));
    this.lji = ((TextView)this.ljb.findViewById(2131296904));
    this.ljj = ((TextView)this.ljb.findViewById(2131296908));
    this.ljl = ((ImageView)this.ljb.findViewById(2131296905));
    this.ljk = ((ImageView)this.ljb.findViewById(2131296913));
    this.ljm = this.ljb.findViewById(2131296907);
    show();
    bBc();
    AppMethodBeat.o(147119);
  }
  
  private void bBc()
  {
    AppMethodBeat.i(147120);
    this.ljh.setOnClickListener(this.mOnClickListener);
    this.lji.setOnClickListener(this.mOnClickListener);
    this.ljg.setOnClickListener(this.mOnClickListener);
    AppMethodBeat.o(147120);
  }
  
  public final void T(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(229886);
    this.lja = paramAppBrandRuntime.kAt;
    if ((getParent() instanceof ViewGroup)) {
      ((ViewGroup)getParent()).removeView(this);
    }
    paramAppBrandRuntime.ct(this);
    bBb();
    postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(147104);
        RemoteDebugMoveView localRemoteDebugMoveView = w.a(w.this);
        int i = w.this.getWidth();
        int j = w.this.getHeight();
        localRemoteDebugMoveView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        localRemoteDebugMoveView.hbc = i;
        localRemoteDebugMoveView.oh = j;
        localRemoteDebugMoveView.post(new RemoteDebugMoveView.1(localRemoteDebugMoveView));
        w.this.addView(w.a(w.this));
        AppMethodBeat.o(147104);
      }
    }, 100L);
    AppMethodBeat.o(229886);
  }
  
  public final void Ya(final String paramString)
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
        w.a(w.this, paramString);
        AppMethodBeat.o(147112);
      }
    });
    AppMethodBeat.o(147125);
  }
  
  public final void bAZ()
  {
    AppMethodBeat.i(147117);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(147105);
        if (w.b(w.this) == null)
        {
          Log.w("MicroMsg.RemoteDebugView", "showDebugView mContentView is null");
          AppMethodBeat.o(147105);
          return;
        }
        if (w.c(w.this))
        {
          w.this.setVisibility(0);
          if (w.b(w.this).indexOfChild(w.this) == -1) {
            w.b(w.this).addView(w.this);
          }
          w.b(w.this).bringChildToFront(w.this);
          w.this.setBackgroundColor(w.this.getContext().getResources().getColor(2131100584));
          AppMethodBeat.o(147105);
          return;
        }
        w.this.setBackgroundColor(w.this.getContext().getResources().getColor(2131101287));
        AppMethodBeat.o(147105);
      }
    });
    AppMethodBeat.o(147117);
  }
  
  final void bBd()
  {
    AppMethodBeat.i(147121);
    if ((this.ljp != null) && (this.ljp.isShowing()))
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
    this.ljp = new d.a(localContext).bon(localContext.getString(2131755679)).boo("").aoV(2131756920).c(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(147107);
        if (w.d(w.this) != null) {
          w.d(w.this).bAM();
        }
        AppMethodBeat.o(147107);
      }
    }).aoW(2131756918).hbn();
    this.ljp.show();
    AppMethodBeat.o(147121);
  }
  
  public final void bBe()
  {
    AppMethodBeat.i(147122);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(147108);
        if (w.e(w.this).bAI())
        {
          w.f(w.this).setImageResource(2131231049);
          w.g(w.this).setText(w.this.getContext().getString(2131755674));
        }
        for (;;)
        {
          w.h(w.this);
          AppMethodBeat.o(147108);
          return;
          if (w.e(w.this).isReady())
          {
            w.f(w.this).setImageResource(2131231049);
            w.g(w.this).setText(w.this.getContext().getString(2131755675));
          }
          else
          {
            w.f(w.this).setImageResource(2131231048);
            w.g(w.this).setText(w.this.getContext().getString(2131755673));
          }
        }
      }
    });
    AppMethodBeat.o(147122);
  }
  
  public final void bBf()
  {
    AppMethodBeat.i(147124);
    bAZ();
    bBe();
    AppMethodBeat.o(147124);
  }
  
  public final void bringToFront()
  {
    AppMethodBeat.i(147116);
    if (this.lja == null)
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
    if (bBa())
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
    if (this.ljn)
    {
      this.ljm.setVisibility(0);
      if (this.ljc.size() > 0)
      {
        this.ljj.setVisibility(0);
        this.ljh.setVisibility(8);
      }
    }
    for (;;)
    {
      invalidate();
      AppMethodBeat.o(147123);
      return;
      this.ljj.setVisibility(8);
      break;
      this.ljm.setVisibility(8);
      this.ljj.setVisibility(8);
      this.ljh.setVisibility(0);
    }
  }
  
  public static abstract interface a
  {
    public abstract void bAM();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.w
 * JD-Core Version:    0.7.0.1
 */