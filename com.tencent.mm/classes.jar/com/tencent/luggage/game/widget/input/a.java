package com.tencent.luggage.game.widget.input;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.plugin.appbrand.widget.input.w;

public final class a
  extends w
{
  private static final int VIEW_ID = 2131820555;
  public a.a bCC;
  private WAGamePanelInputEditText bCD;
  private View.OnClickListener bCE;
  
  private a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(140559);
    qv(VIEW_ID);
    AppMethodBeat.o(140559);
  }
  
  public static a cf(View paramView)
  {
    AppMethodBeat.i(140560);
    paramView = (a)paramView.getRootView().findViewById(VIEW_ID);
    AppMethodBeat.o(140560);
    return paramView;
  }
  
  public static a cg(View paramView)
  {
    AppMethodBeat.i(140561);
    n localn = n.cJ(paramView);
    n.cL(paramView);
    Object localObject = w.cQ(paramView);
    if ((localObject != null) && ((((w)localObject).getParent() instanceof ViewGroup))) {
      ((ViewGroup)((w)localObject).getParent()).removeView((View)localObject);
    }
    localObject = cf(paramView);
    if (localObject == null) {
      if ((paramView instanceof a))
      {
        paramView = (a)paramView;
        localn.cK(paramView);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(140561);
      return paramView;
      paramView = new a(paramView.getContext());
      break;
      paramView = (View)localObject;
    }
  }
  
  public final WAGamePanelInputEditText getAttachedEditText()
  {
    AppMethodBeat.i(140564);
    WAGamePanelInputEditText localWAGamePanelInputEditText = (WAGamePanelInputEditText)super.getAttachedEditText();
    AppMethodBeat.o(140564);
    return localWAGamePanelInputEditText;
  }
  
  public final void setOnConfirmClickListener(View.OnClickListener paramOnClickListener)
  {
    this.bCE = paramOnClickListener;
  }
  
  public final void show()
  {
    AppMethodBeat.i(140565);
    this.jnn = this.bCD;
    this.bCD.requestFocus();
    super.show();
    AppMethodBeat.o(140565);
  }
  
  public final void vO()
  {
    AppMethodBeat.i(156306);
    cg(this);
    AppMethodBeat.o(156306);
  }
  
  public final void vP()
  {
    AppMethodBeat.i(140562);
    this.bCC.setIsHide(false);
    AppMethodBeat.o(140562);
  }
  
  public final void vQ()
  {
    int j = 0;
    AppMethodBeat.i(140563);
    View localView = this.bCC.getConfirmButton();
    if ((this.bCD.getInputType() & 0x20000) > 0)
    {
      i = 1;
      if (i == 0) {
        break label52;
      }
    }
    label52:
    for (int i = j;; i = 8)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(140563);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.game.widget.input.a
 * JD-Core Version:    0.7.0.1
 */