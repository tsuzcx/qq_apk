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
import com.tencent.mm.protocal.protobuf.dzb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.a.d.a;
import java.util.LinkedList;

@SuppressLint({"ViewConstructor"})
public final class w
  extends FrameLayout
{
  private m coY;
  ViewGroup kca;
  RemoteDebugMoveView kcb;
  private LinkedList<String> kcc;
  private TextView kcd;
  private TextView kce;
  private TextView kcf;
  private TextView kcg;
  private TextView kch;
  private TextView kci;
  private TextView kcj;
  private ImageView kck;
  private ImageView kcl;
  private View kcm;
  boolean kcn;
  private a kco;
  private com.tencent.mm.ui.widget.a.d kcp;
  private View.OnClickListener mOnClickListener;
  
  public w(Context paramContext, m paramm, a parama)
  {
    super(paramContext);
    AppMethodBeat.i(147113);
    this.kcc = new LinkedList();
    this.kcn = false;
    this.mOnClickListener = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(147106);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/appbrand/debugger/RemoteDebugView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
        localObject = w.this;
        if (paramAnonymousView.getId() == 2131296825)
        {
          ((w)localObject).kcn = true;
          ((w)localObject).show();
          paramAnonymousView = ((w)localObject).kcb;
          paramAnonymousView.postDelayed(new RemoteDebugMoveView.3(paramAnonymousView), 50L);
        }
        for (;;)
        {
          a.a(this, "com/tencent/mm/plugin/appbrand/debugger/RemoteDebugView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(147106);
          return;
          if (paramAnonymousView.getId() == 2131296820)
          {
            ((w)localObject).kcn = false;
            ((w)localObject).show();
          }
          else if (paramAnonymousView.getId() == 2131296828)
          {
            ((w)localObject).bfc();
          }
        }
      }
    };
    this.coY = paramm;
    this.kco = parama;
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    setBackgroundColor(getContext().getResources().getColor(2131101053));
    setId(2131296693);
    AppMethodBeat.o(147113);
  }
  
  private boolean beZ()
  {
    AppMethodBeat.i(147118);
    if ((this.coY.beH()) || (this.coY.isQuit()) || (this.coY.beI()))
    {
      AppMethodBeat.o(147118);
      return true;
    }
    AppMethodBeat.o(147118);
    return false;
  }
  
  private void bfa()
  {
    AppMethodBeat.i(147119);
    this.kcb = ((RemoteDebugMoveView)LayoutInflater.from(getContext()).inflate(2131493050, null));
    this.kce = ((TextView)this.kcb.findViewById(2131296822));
    this.kcd = ((TextView)this.kcb.findViewById(2131296831));
    this.kcf = ((TextView)this.kcb.findViewById(2131296826));
    this.kcg = ((TextView)this.kcb.findViewById(2131296828));
    this.kch = ((TextView)this.kcb.findViewById(2131296825));
    this.kci = ((TextView)this.kcb.findViewById(2131296820));
    this.kcj = ((TextView)this.kcb.findViewById(2131296824));
    this.kcl = ((ImageView)this.kcb.findViewById(2131296821));
    this.kck = ((ImageView)this.kcb.findViewById(2131296829));
    this.kcm = this.kcb.findViewById(2131296823);
    show();
    bfb();
    AppMethodBeat.o(147119);
  }
  
  private void bfb()
  {
    AppMethodBeat.i(147120);
    this.kch.setOnClickListener(this.mOnClickListener);
    this.kci.setOnClickListener(this.mOnClickListener);
    this.kcg.setOnClickListener(this.mOnClickListener);
    AppMethodBeat.o(147120);
  }
  
  public final void Oi(final String paramString)
  {
    AppMethodBeat.i(147125);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(147125);
      return;
    }
    aq.f(new Runnable()
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
  
  public final void beY()
  {
    AppMethodBeat.i(147117);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(147105);
        if (w.b(w.this) == null)
        {
          ad.w("MicroMsg.RemoteDebugView", "showDebugView mContentView is null");
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
  
  final void bfc()
  {
    AppMethodBeat.i(147121);
    if ((this.kcp != null) && (this.kcp.isShowing()))
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
    this.kcp = new d.a(localContext).aXF(localContext.getString(2131755632)).aXG("").afl(2131756757).c(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(147107);
        if (w.d(w.this) != null) {
          w.d(w.this).beL();
        }
        AppMethodBeat.o(147107);
      }
    }).afm(2131756755).fMb();
    this.kcp.show();
    AppMethodBeat.o(147121);
  }
  
  public final void bfd()
  {
    AppMethodBeat.i(147122);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(147108);
        if (w.e(w.this).beH())
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
  
  public final void bfe()
  {
    AppMethodBeat.i(147124);
    beY();
    bfd();
    AppMethodBeat.o(147124);
  }
  
  public final void bringToFront()
  {
    AppMethodBeat.i(147116);
    if (this.kca == null)
    {
      ad.w("MicroMsg.RemoteDebugView", "bringToFront mContentView is null");
      AppMethodBeat.o(147116);
      return;
    }
    this.kca.bringChildToFront(this);
    AppMethodBeat.o(147116);
  }
  
  public final void c(com.tencent.mm.plugin.appbrand.widget.d paramd)
  {
    AppMethodBeat.i(192208);
    this.kca = paramd;
    int i = 0;
    while (i < this.kca.getChildCount())
    {
      paramd = this.kca.getChildAt(i);
      if ((paramd instanceof w)) {
        this.kca.removeView(paramd);
      }
      i += 1;
    }
    this.kca.addView(this);
    this.kca.bringChildToFront(this);
    bfa();
    postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(147104);
        RemoteDebugMoveView localRemoteDebugMoveView = w.a(w.this);
        int i = w.this.getWidth();
        int j = w.this.getHeight();
        localRemoteDebugMoveView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        localRemoteDebugMoveView.gnN = i;
        localRemoteDebugMoveView.of = j;
        localRemoteDebugMoveView.post(new RemoteDebugMoveView.1(localRemoteDebugMoveView));
        w.this.addView(w.a(w.this));
        AppMethodBeat.o(147104);
      }
    }, 100L);
    AppMethodBeat.o(192208);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(147114);
    if (beZ())
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
    if (this.kcn)
    {
      this.kcm.setVisibility(0);
      if (this.kcc.size() > 0)
      {
        this.kcj.setVisibility(0);
        this.kch.setVisibility(8);
      }
    }
    for (;;)
    {
      invalidate();
      AppMethodBeat.o(147123);
      return;
      this.kcj.setVisibility(8);
      break;
      this.kcm.setVisibility(8);
      this.kcj.setVisibility(8);
      this.kch.setVisibility(0);
    }
  }
  
  public static abstract interface a
  {
    public abstract void beL();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.w
 * JD-Core Version:    0.7.0.1
 */