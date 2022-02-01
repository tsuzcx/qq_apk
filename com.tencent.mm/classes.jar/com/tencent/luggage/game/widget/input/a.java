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
  private static final int VIEW_ID = 2131296720;
  public a.a clV;
  public WAGamePanelInputEditText clW;
  private View.OnClickListener clX;
  
  private a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(130711);
    wy(VIEW_ID);
    AppMethodBeat.o(130711);
  }
  
  public static a co(View paramView)
  {
    AppMethodBeat.i(130712);
    paramView = (a)paramView.getRootView().findViewById(VIEW_ID);
    AppMethodBeat.o(130712);
    return paramView;
  }
  
  public static a cp(View paramView)
  {
    AppMethodBeat.i(130713);
    n localn = n.dd(paramView);
    n.df(paramView);
    Object localObject = w.dk(paramView);
    if ((localObject != null) && ((((w)localObject).getParent() instanceof ViewGroup))) {
      ((ViewGroup)((w)localObject).getParent()).removeView((View)localObject);
    }
    localObject = co(paramView);
    if (localObject == null) {
      if ((paramView instanceof a))
      {
        paramView = (a)paramView;
        localn.de(paramView);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(130713);
      return paramView;
      paramView = new a(paramView.getContext());
      break;
      paramView = (View)localObject;
    }
  }
  
  public final void DT()
  {
    AppMethodBeat.i(130714);
    cp(this);
    AppMethodBeat.o(130714);
  }
  
  public final void DU()
  {
    AppMethodBeat.i(130715);
    this.clV.setIsHide(false);
    AppMethodBeat.o(130715);
  }
  
  public final void DV()
  {
    int j = 0;
    AppMethodBeat.i(130716);
    View localView = this.clV.getConfirmButton();
    if ((this.clW.getInputType() & 0x20000) > 0)
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
      AppMethodBeat.o(130716);
      return;
      i = 0;
      break;
    }
  }
  
  public final WAGamePanelInputEditText getAttachedEditText()
  {
    AppMethodBeat.i(130717);
    WAGamePanelInputEditText localWAGamePanelInputEditText = (WAGamePanelInputEditText)super.getAttachedEditText();
    AppMethodBeat.o(130717);
    return localWAGamePanelInputEditText;
  }
  
  public final void setOnConfirmClickListener(View.OnClickListener paramOnClickListener)
  {
    this.clX = paramOnClickListener;
  }
  
  public final void show()
  {
    AppMethodBeat.i(130718);
    this.nkH = this.clW;
    this.clW.requestFocus();
    super.show();
    AppMethodBeat.o(130718);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.game.widget.input.a
 * JD-Core Version:    0.7.0.1
 */