package com.tencent.mm.plugin.appbrand.debugger;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.b.c;
import com.tencent.mm.ui.widget.b.c.a;
import java.util.LinkedList;

@SuppressLint({"ViewConstructor"})
public final class u
  extends FrameLayout
{
  private l bER;
  private TextView hmA;
  private TextView hmB;
  private TextView hmC;
  private TextView hmD;
  private TextView hmE;
  private TextView hmF;
  private ImageView hmG;
  private ImageView hmH;
  private View hmI;
  boolean hmJ;
  private u.a hmK;
  private c hmL;
  ViewGroup hmw;
  RemoteDebugMoveView hmx;
  private LinkedList<String> hmy;
  private TextView hmz;
  private View.OnClickListener mOnClickListener;
  
  public u(Context paramContext, l paraml, u.a parama)
  {
    super(paramContext);
    AppMethodBeat.i(101925);
    this.hmy = new LinkedList();
    this.hmJ = false;
    this.mOnClickListener = new u.3(this);
    this.bER = paraml;
    this.hmK = parama;
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    setBackgroundColor(getContext().getResources().getColor(2131690605));
    setId(2131820551);
    AppMethodBeat.o(101925);
  }
  
  private boolean azq()
  {
    AppMethodBeat.i(101929);
    if ((this.bER.ayX()) || (this.bER.ayY()) || (this.bER.ayZ()))
    {
      AppMethodBeat.o(101929);
      return true;
    }
    AppMethodBeat.o(101929);
    return false;
  }
  
  private void azr()
  {
    AppMethodBeat.i(140827);
    this.hmx = ((RemoteDebugMoveView)LayoutInflater.from(getContext()).inflate(2130968731, null));
    this.hmA = ((TextView)this.hmx.findViewById(2131821375));
    this.hmz = ((TextView)this.hmx.findViewById(2131821380));
    this.hmB = ((TextView)this.hmx.findViewById(2131821381));
    this.hmC = ((TextView)this.hmx.findViewById(2131821384));
    this.hmD = ((TextView)this.hmx.findViewById(2131821376));
    this.hmE = ((TextView)this.hmx.findViewById(2131821385));
    this.hmF = ((TextView)this.hmx.findViewById(2131821382));
    this.hmH = ((ImageView)this.hmx.findViewById(2131821374));
    this.hmG = ((ImageView)this.hmx.findViewById(2131821379));
    this.hmI = this.hmx.findViewById(2131821377);
    show();
    azs();
    AppMethodBeat.o(140827);
  }
  
  private void azs()
  {
    AppMethodBeat.i(140828);
    this.hmD.setOnClickListener(this.mOnClickListener);
    this.hmE.setOnClickListener(this.mOnClickListener);
    this.hmC.setOnClickListener(this.mOnClickListener);
    AppMethodBeat.o(140828);
  }
  
  public final void AT(String paramString)
  {
    AppMethodBeat.i(101934);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(101934);
      return;
    }
    al.d(new u.9(this, paramString));
    AppMethodBeat.o(101934);
  }
  
  public final void azp()
  {
    AppMethodBeat.i(101928);
    al.d(new u.2(this));
    AppMethodBeat.o(101928);
  }
  
  final void azt()
  {
    AppMethodBeat.i(101930);
    if ((this.hmL != null) && (this.hmL.isShowing()))
    {
      AppMethodBeat.o(101930);
      return;
    }
    Context localContext = getContext();
    if (((localContext instanceof Activity)) && (((Activity)localContext).isFinishing()))
    {
      AppMethodBeat.o(101930);
      return;
    }
    this.hmL = new c.a(localContext).avm(localContext.getString(2131296832)).avn("").Ri(2131297828).a(new u.4(this)).Rj(2131297827).aLZ();
    this.hmL.show();
    AppMethodBeat.o(101930);
  }
  
  public final void azu()
  {
    AppMethodBeat.i(101931);
    al.d(new u.5(this));
    AppMethodBeat.o(101931);
  }
  
  public final void azv()
  {
    AppMethodBeat.i(101933);
    azp();
    azu();
    AppMethodBeat.o(101933);
  }
  
  public final void bringToFront()
  {
    AppMethodBeat.i(101927);
    if (this.hmw == null)
    {
      ab.w("MicroMsg.RemoteDebugView", "bringToFront mContentView is null");
      AppMethodBeat.o(101927);
      return;
    }
    this.hmw.bringChildToFront(this);
    AppMethodBeat.o(101927);
  }
  
  public final void g(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(140826);
    this.hmw = ((ViewGroup)paramViewGroup.getParent());
    int i = 0;
    while (i < this.hmw.getChildCount())
    {
      paramViewGroup = this.hmw.getChildAt(i);
      if ((paramViewGroup instanceof u)) {
        this.hmw.removeView(paramViewGroup);
      }
      i += 1;
    }
    this.hmw.addView(this);
    this.hmw.bringChildToFront(this);
    azr();
    postDelayed(new u.1(this), 100L);
    AppMethodBeat.o(140826);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(101926);
    if (azq())
    {
      AppMethodBeat.o(101926);
      return true;
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(101926);
    return bool;
  }
  
  public final void show()
  {
    AppMethodBeat.i(101932);
    if (this.hmJ)
    {
      this.hmI.setVisibility(0);
      if (this.hmy.size() > 0)
      {
        this.hmF.setVisibility(0);
        this.hmD.setVisibility(8);
      }
    }
    for (;;)
    {
      invalidate();
      AppMethodBeat.o(101932);
      return;
      this.hmF.setVisibility(8);
      break;
      this.hmI.setVisibility(8);
      this.hmF.setVisibility(8);
      this.hmD.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.u
 * JD-Core Version:    0.7.0.1
 */