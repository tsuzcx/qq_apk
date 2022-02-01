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
import com.tencent.mm.protocal.protobuf.eas;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import java.util.LinkedList;

@SuppressLint({"ViewConstructor"})
public final class w
  extends FrameLayout
{
  private m cpc;
  private TextView kfA;
  private ImageView kfB;
  private ImageView kfC;
  private View kfD;
  boolean kfE;
  private a kfF;
  private d kfG;
  ViewGroup kfr;
  RemoteDebugMoveView kfs;
  private LinkedList<String> kft;
  private TextView kfu;
  private TextView kfv;
  private TextView kfw;
  private TextView kfx;
  private TextView kfy;
  private TextView kfz;
  private View.OnClickListener mOnClickListener;
  
  public w(Context paramContext, m paramm, a parama)
  {
    super(paramContext);
    AppMethodBeat.i(147113);
    this.kft = new LinkedList();
    this.kfE = false;
    this.mOnClickListener = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(147106);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/appbrand/debugger/RemoteDebugView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
        localObject = w.this;
        if (paramAnonymousView.getId() == 2131296825)
        {
          ((w)localObject).kfE = true;
          ((w)localObject).show();
          paramAnonymousView = ((w)localObject).kfs;
          paramAnonymousView.postDelayed(new RemoteDebugMoveView.3(paramAnonymousView), 50L);
        }
        for (;;)
        {
          a.a(this, "com/tencent/mm/plugin/appbrand/debugger/RemoteDebugView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(147106);
          return;
          if (paramAnonymousView.getId() == 2131296820)
          {
            ((w)localObject).kfE = false;
            ((w)localObject).show();
          }
          else if (paramAnonymousView.getId() == 2131296828)
          {
            ((w)localObject).bfK();
          }
        }
      }
    };
    this.cpc = paramm;
    this.kfF = parama;
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    setBackgroundColor(getContext().getResources().getColor(2131101053));
    setId(2131296693);
    AppMethodBeat.o(147113);
  }
  
  private boolean bfH()
  {
    AppMethodBeat.i(147118);
    if ((this.cpc.bfp()) || (this.cpc.isQuit()) || (this.cpc.bfq()))
    {
      AppMethodBeat.o(147118);
      return true;
    }
    AppMethodBeat.o(147118);
    return false;
  }
  
  private void bfI()
  {
    AppMethodBeat.i(147119);
    this.kfs = ((RemoteDebugMoveView)LayoutInflater.from(getContext()).inflate(2131493050, null));
    this.kfv = ((TextView)this.kfs.findViewById(2131296822));
    this.kfu = ((TextView)this.kfs.findViewById(2131296831));
    this.kfw = ((TextView)this.kfs.findViewById(2131296826));
    this.kfx = ((TextView)this.kfs.findViewById(2131296828));
    this.kfy = ((TextView)this.kfs.findViewById(2131296825));
    this.kfz = ((TextView)this.kfs.findViewById(2131296820));
    this.kfA = ((TextView)this.kfs.findViewById(2131296824));
    this.kfC = ((ImageView)this.kfs.findViewById(2131296821));
    this.kfB = ((ImageView)this.kfs.findViewById(2131296829));
    this.kfD = this.kfs.findViewById(2131296823);
    show();
    bfJ();
    AppMethodBeat.o(147119);
  }
  
  private void bfJ()
  {
    AppMethodBeat.i(147120);
    this.kfy.setOnClickListener(this.mOnClickListener);
    this.kfz.setOnClickListener(this.mOnClickListener);
    this.kfx.setOnClickListener(this.mOnClickListener);
    AppMethodBeat.o(147120);
  }
  
  public final void OP(final String paramString)
  {
    AppMethodBeat.i(147125);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(147125);
      return;
    }
    ar.f(new Runnable()
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
  
  public final void S(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(220780);
    this.kfr = paramAppBrandRuntime.jzF;
    if ((getParent() instanceof ViewGroup)) {
      ((ViewGroup)getParent()).removeView(this);
    }
    paramAppBrandRuntime.cC(this);
    bfI();
    postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(147104);
        RemoteDebugMoveView localRemoteDebugMoveView = w.a(w.this);
        int i = w.this.getWidth();
        int j = w.this.getHeight();
        localRemoteDebugMoveView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        localRemoteDebugMoveView.gqj = i;
        localRemoteDebugMoveView.of = j;
        localRemoteDebugMoveView.post(new RemoteDebugMoveView.1(localRemoteDebugMoveView));
        w.this.addView(w.a(w.this));
        AppMethodBeat.o(147104);
      }
    }, 100L);
    AppMethodBeat.o(220780);
  }
  
  public final void bfG()
  {
    AppMethodBeat.i(147117);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(147105);
        if (w.b(w.this) == null)
        {
          ae.w("MicroMsg.RemoteDebugView", "showDebugView mContentView is null");
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
          w.this.setBackgroundColor(w.this.getContext().getResources().getColor(2131100482));
          AppMethodBeat.o(147105);
          return;
        }
        w.this.setBackgroundColor(w.this.getContext().getResources().getColor(2131101053));
        AppMethodBeat.o(147105);
      }
    });
    AppMethodBeat.o(147117);
  }
  
  final void bfK()
  {
    AppMethodBeat.i(147121);
    if ((this.kfG != null) && (this.kfG.isShowing()))
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
    this.kfG = new d.a(localContext).aZh(localContext.getString(2131755632)).aZi("").afU(2131756757).c(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(147107);
        if (w.d(w.this) != null) {
          w.d(w.this).bft();
        }
        AppMethodBeat.o(147107);
      }
    }).afV(2131756755).fQv();
    this.kfG.show();
    AppMethodBeat.o(147121);
  }
  
  public final void bfL()
  {
    AppMethodBeat.i(147122);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(147108);
        if (w.e(w.this).bfp())
        {
          w.f(w.this).setImageResource(2131231017);
          w.g(w.this).setText(w.this.getContext().getString(2131755627));
        }
        for (;;)
        {
          w.h(w.this);
          AppMethodBeat.o(147108);
          return;
          if (w.e(w.this).isReady())
          {
            w.f(w.this).setImageResource(2131231017);
            w.g(w.this).setText(w.this.getContext().getString(2131755628));
          }
          else
          {
            w.f(w.this).setImageResource(2131231016);
            w.g(w.this).setText(w.this.getContext().getString(2131755626));
          }
        }
      }
    });
    AppMethodBeat.o(147122);
  }
  
  public final void bfM()
  {
    AppMethodBeat.i(147124);
    bfG();
    bfL();
    AppMethodBeat.o(147124);
  }
  
  public final void bringToFront()
  {
    AppMethodBeat.i(147116);
    if (this.kfr == null)
    {
      ae.w("MicroMsg.RemoteDebugView", "bringToFront mContentView is null");
      AppMethodBeat.o(147116);
      return;
    }
    AppMethodBeat.o(147116);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(147114);
    if (bfH())
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
    if (this.kfE)
    {
      this.kfD.setVisibility(0);
      if (this.kft.size() > 0)
      {
        this.kfA.setVisibility(0);
        this.kfy.setVisibility(8);
      }
    }
    for (;;)
    {
      invalidate();
      AppMethodBeat.o(147123);
      return;
      this.kfA.setVisibility(8);
      break;
      this.kfD.setVisibility(8);
      this.kfA.setVisibility(8);
      this.kfy.setVisibility(0);
    }
  }
  
  public static abstract interface a
  {
    public abstract void bft();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.w
 * JD-Core Version:    0.7.0.1
 */