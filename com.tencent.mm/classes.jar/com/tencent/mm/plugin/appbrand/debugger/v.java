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
import com.tencent.mm.protocal.protobuf.dnq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import java.util.LinkedList;

@SuppressLint({"ViewConstructor"})
public final class v
  extends FrameLayout
{
  private l chM;
  RemoteDebugMoveView jhA;
  private LinkedList<String> jhB;
  private TextView jhC;
  private TextView jhD;
  private TextView jhE;
  private TextView jhF;
  private TextView jhG;
  private TextView jhH;
  private TextView jhI;
  private ImageView jhJ;
  private ImageView jhK;
  private View jhL;
  boolean jhM;
  private a jhN;
  private d jhO;
  ViewGroup jhz;
  private View.OnClickListener mOnClickListener;
  
  public v(Context paramContext, l paraml, a parama)
  {
    super(paramContext);
    AppMethodBeat.i(147113);
    this.jhB = new LinkedList();
    this.jhM = false;
    this.mOnClickListener = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(147106);
        v localv = v.this;
        if (paramAnonymousView.getId() == 2131296825)
        {
          localv.jhM = true;
          localv.show();
          paramAnonymousView = localv.jhA;
          paramAnonymousView.postDelayed(new RemoteDebugMoveView.3(paramAnonymousView), 50L);
          AppMethodBeat.o(147106);
          return;
        }
        if (paramAnonymousView.getId() == 2131296820)
        {
          localv.jhM = false;
          localv.show();
          AppMethodBeat.o(147106);
          return;
        }
        if (paramAnonymousView.getId() == 2131296828) {
          localv.aUA();
        }
        AppMethodBeat.o(147106);
      }
    };
    this.chM = paraml;
    this.jhN = parama;
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    setBackgroundColor(getContext().getResources().getColor(2131101053));
    setId(2131296693);
    AppMethodBeat.o(147113);
  }
  
  private boolean aUx()
  {
    AppMethodBeat.i(147118);
    if ((this.chM.aUf()) || (this.chM.isQuit()) || (this.chM.aUg()))
    {
      AppMethodBeat.o(147118);
      return true;
    }
    AppMethodBeat.o(147118);
    return false;
  }
  
  private void aUy()
  {
    AppMethodBeat.i(147119);
    this.jhA = ((RemoteDebugMoveView)LayoutInflater.from(getContext()).inflate(2131493050, null));
    this.jhD = ((TextView)this.jhA.findViewById(2131296822));
    this.jhC = ((TextView)this.jhA.findViewById(2131296831));
    this.jhE = ((TextView)this.jhA.findViewById(2131296826));
    this.jhF = ((TextView)this.jhA.findViewById(2131296828));
    this.jhG = ((TextView)this.jhA.findViewById(2131296825));
    this.jhH = ((TextView)this.jhA.findViewById(2131296820));
    this.jhI = ((TextView)this.jhA.findViewById(2131296824));
    this.jhK = ((ImageView)this.jhA.findViewById(2131296821));
    this.jhJ = ((ImageView)this.jhA.findViewById(2131296829));
    this.jhL = this.jhA.findViewById(2131296823);
    show();
    aUz();
    AppMethodBeat.o(147119);
  }
  
  private void aUz()
  {
    AppMethodBeat.i(147120);
    this.jhG.setOnClickListener(this.mOnClickListener);
    this.jhH.setOnClickListener(this.mOnClickListener);
    this.jhF.setOnClickListener(this.mOnClickListener);
    AppMethodBeat.o(147120);
  }
  
  public final void GK(final String paramString)
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
        v.a(v.this, paramString);
        AppMethodBeat.o(147112);
      }
    });
    AppMethodBeat.o(147125);
  }
  
  final void aUA()
  {
    AppMethodBeat.i(147121);
    if ((this.jhO != null) && (this.jhO.isShowing()))
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
    this.jhO = new d.a(localContext).aMf(localContext.getString(2131755632)).aMg("").aaB(2131756757).b(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(147107);
        if (v.d(v.this) != null) {
          v.d(v.this).aUj();
        }
        AppMethodBeat.o(147107);
      }
    }).aaC(2131756755).fft();
    this.jhO.show();
    AppMethodBeat.o(147121);
  }
  
  public final void aUB()
  {
    AppMethodBeat.i(147122);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(147108);
        if (v.e(v.this).aUf())
        {
          v.f(v.this).setImageResource(2131231017);
          v.g(v.this).setText(v.this.getContext().getString(2131755627));
        }
        for (;;)
        {
          v.h(v.this);
          AppMethodBeat.o(147108);
          return;
          if (v.e(v.this).isReady())
          {
            v.f(v.this).setImageResource(2131231017);
            v.g(v.this).setText(v.this.getContext().getString(2131755628));
          }
          else
          {
            v.f(v.this).setImageResource(2131231016);
            v.g(v.this).setText(v.this.getContext().getString(2131755626));
          }
        }
      }
    });
    AppMethodBeat.o(147122);
  }
  
  public final void aUC()
  {
    AppMethodBeat.i(147124);
    aUw();
    aUB();
    AppMethodBeat.o(147124);
  }
  
  public final void aUw()
  {
    AppMethodBeat.i(147117);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(147105);
        if (v.b(v.this) == null)
        {
          ad.w("MicroMsg.RemoteDebugView", "showDebugView mContentView is null");
          AppMethodBeat.o(147105);
          return;
        }
        if (v.c(v.this))
        {
          v.this.setVisibility(0);
          if (v.b(v.this).indexOfChild(v.this) == -1) {
            v.b(v.this).addView(v.this);
          }
          v.b(v.this).bringChildToFront(v.this);
          v.this.setBackgroundColor(v.this.getContext().getResources().getColor(2131100482));
          AppMethodBeat.o(147105);
          return;
        }
        v.this.setBackgroundColor(v.this.getContext().getResources().getColor(2131101053));
        AppMethodBeat.o(147105);
      }
    });
    AppMethodBeat.o(147117);
  }
  
  public final void bringToFront()
  {
    AppMethodBeat.i(147116);
    if (this.jhz == null)
    {
      ad.w("MicroMsg.RemoteDebugView", "bringToFront mContentView is null");
      AppMethodBeat.o(147116);
      return;
    }
    this.jhz.bringChildToFront(this);
    AppMethodBeat.o(147116);
  }
  
  public final void h(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(147115);
    this.jhz = ((ViewGroup)paramViewGroup.getParent());
    int i = 0;
    while (i < this.jhz.getChildCount())
    {
      paramViewGroup = this.jhz.getChildAt(i);
      if ((paramViewGroup instanceof v)) {
        this.jhz.removeView(paramViewGroup);
      }
      i += 1;
    }
    this.jhz.addView(this);
    this.jhz.bringChildToFront(this);
    aUy();
    postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(147104);
        RemoteDebugMoveView localRemoteDebugMoveView = v.a(v.this);
        int i = v.this.getWidth();
        int j = v.this.getHeight();
        localRemoteDebugMoveView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        localRemoteDebugMoveView.fQq = i;
        localRemoteDebugMoveView.ln = j;
        localRemoteDebugMoveView.post(new RemoteDebugMoveView.1(localRemoteDebugMoveView));
        v.this.addView(v.a(v.this));
        AppMethodBeat.o(147104);
      }
    }, 100L);
    AppMethodBeat.o(147115);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(147114);
    if (aUx())
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
    if (this.jhM)
    {
      this.jhL.setVisibility(0);
      if (this.jhB.size() > 0)
      {
        this.jhI.setVisibility(0);
        this.jhG.setVisibility(8);
      }
    }
    for (;;)
    {
      invalidate();
      AppMethodBeat.o(147123);
      return;
      this.jhI.setVisibility(8);
      break;
      this.jhL.setVisibility(8);
      this.jhI.setVisibility(8);
      this.jhG.setVisibility(0);
    }
  }
  
  public static abstract interface a
  {
    public abstract void aUj();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.v
 * JD-Core Version:    0.7.0.1
 */