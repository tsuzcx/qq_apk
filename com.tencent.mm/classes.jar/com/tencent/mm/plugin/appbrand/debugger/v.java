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
import com.tencent.mm.protocal.protobuf.dth;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import java.util.LinkedList;

@SuppressLint({"ViewConstructor"})
public final class v
  extends FrameLayout
{
  private l ceH;
  ViewGroup jHO;
  RemoteDebugMoveView jHP;
  private LinkedList<String> jHQ;
  private TextView jHR;
  private TextView jHS;
  private TextView jHT;
  private TextView jHU;
  private TextView jHV;
  private TextView jHW;
  private TextView jHX;
  private ImageView jHY;
  private ImageView jHZ;
  private View jIa;
  boolean jIb;
  private a jIc;
  private d jId;
  private View.OnClickListener mOnClickListener;
  
  public v(Context paramContext, l paraml, a parama)
  {
    super(paramContext);
    AppMethodBeat.i(147113);
    this.jHQ = new LinkedList();
    this.jIb = false;
    this.mOnClickListener = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(147106);
        v localv = v.this;
        if (paramAnonymousView.getId() == 2131296825)
        {
          localv.jIb = true;
          localv.show();
          paramAnonymousView = localv.jHP;
          paramAnonymousView.postDelayed(new RemoteDebugMoveView.3(paramAnonymousView), 50L);
          AppMethodBeat.o(147106);
          return;
        }
        if (paramAnonymousView.getId() == 2131296820)
        {
          localv.jIb = false;
          localv.show();
          AppMethodBeat.o(147106);
          return;
        }
        if (paramAnonymousView.getId() == 2131296828) {
          localv.bby();
        }
        AppMethodBeat.o(147106);
      }
    };
    this.ceH = paraml;
    this.jIc = parama;
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    setBackgroundColor(getContext().getResources().getColor(2131101053));
    setId(2131296693);
    AppMethodBeat.o(147113);
  }
  
  private boolean bbv()
  {
    AppMethodBeat.i(147118);
    if ((this.ceH.bbd()) || (this.ceH.isQuit()) || (this.ceH.bbe()))
    {
      AppMethodBeat.o(147118);
      return true;
    }
    AppMethodBeat.o(147118);
    return false;
  }
  
  private void bbw()
  {
    AppMethodBeat.i(147119);
    this.jHP = ((RemoteDebugMoveView)LayoutInflater.from(getContext()).inflate(2131493050, null));
    this.jHS = ((TextView)this.jHP.findViewById(2131296822));
    this.jHR = ((TextView)this.jHP.findViewById(2131296831));
    this.jHT = ((TextView)this.jHP.findViewById(2131296826));
    this.jHU = ((TextView)this.jHP.findViewById(2131296828));
    this.jHV = ((TextView)this.jHP.findViewById(2131296825));
    this.jHW = ((TextView)this.jHP.findViewById(2131296820));
    this.jHX = ((TextView)this.jHP.findViewById(2131296824));
    this.jHZ = ((ImageView)this.jHP.findViewById(2131296821));
    this.jHY = ((ImageView)this.jHP.findViewById(2131296829));
    this.jIa = this.jHP.findViewById(2131296823);
    show();
    bbx();
    AppMethodBeat.o(147119);
  }
  
  private void bbx()
  {
    AppMethodBeat.i(147120);
    this.jHV.setOnClickListener(this.mOnClickListener);
    this.jHW.setOnClickListener(this.mOnClickListener);
    this.jHU.setOnClickListener(this.mOnClickListener);
    AppMethodBeat.o(147120);
  }
  
  public final void KO(final String paramString)
  {
    AppMethodBeat.i(147125);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(147125);
      return;
    }
    ap.f(new Runnable()
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
  
  public final void bbA()
  {
    AppMethodBeat.i(147124);
    bbu();
    bbz();
    AppMethodBeat.o(147124);
  }
  
  public final void bbu()
  {
    AppMethodBeat.i(147117);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(147105);
        if (v.b(v.this) == null)
        {
          ac.w("MicroMsg.RemoteDebugView", "showDebugView mContentView is null");
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
  
  final void bby()
  {
    AppMethodBeat.i(147121);
    if ((this.jId != null) && (this.jId.isShowing()))
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
    this.jId = new d.a(localContext).aRH(localContext.getString(2131755632)).aRI("").acM(2131756757).b(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(147107);
        if (v.d(v.this) != null) {
          v.d(v.this).bbh();
        }
        AppMethodBeat.o(147107);
      }
    }).acN(2131756755).fvp();
    this.jId.show();
    AppMethodBeat.o(147121);
  }
  
  public final void bbz()
  {
    AppMethodBeat.i(147122);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(147108);
        if (v.e(v.this).bbd())
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
  
  public final void bringToFront()
  {
    AppMethodBeat.i(147116);
    if (this.jHO == null)
    {
      ac.w("MicroMsg.RemoteDebugView", "bringToFront mContentView is null");
      AppMethodBeat.o(147116);
      return;
    }
    this.jHO.bringChildToFront(this);
    AppMethodBeat.o(147116);
  }
  
  public final void h(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(147115);
    this.jHO = ((ViewGroup)paramViewGroup.getParent());
    int i = 0;
    while (i < this.jHO.getChildCount())
    {
      paramViewGroup = this.jHO.getChildAt(i);
      if ((paramViewGroup instanceof v)) {
        this.jHO.removeView(paramViewGroup);
      }
      i += 1;
    }
    this.jHO.addView(this);
    this.jHO.bringChildToFront(this);
    bbw();
    postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(147104);
        RemoteDebugMoveView localRemoteDebugMoveView = v.a(v.this);
        int i = v.this.getWidth();
        int j = v.this.getHeight();
        localRemoteDebugMoveView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        localRemoteDebugMoveView.fUl = i;
        localRemoteDebugMoveView.mm = j;
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
    if (bbv())
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
    if (this.jIb)
    {
      this.jIa.setVisibility(0);
      if (this.jHQ.size() > 0)
      {
        this.jHX.setVisibility(0);
        this.jHV.setVisibility(8);
      }
    }
    for (;;)
    {
      invalidate();
      AppMethodBeat.o(147123);
      return;
      this.jHX.setVisibility(8);
      break;
      this.jIa.setVisibility(8);
      this.jHX.setVisibility(8);
      this.jHV.setVisibility(0);
    }
  }
  
  public static abstract interface a
  {
    public abstract void bbh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.v
 * JD-Core Version:    0.7.0.1
 */