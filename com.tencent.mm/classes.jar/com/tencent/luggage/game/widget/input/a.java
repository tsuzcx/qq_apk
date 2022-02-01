package com.tencent.luggage.game.widget.input;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.plugin.appbrand.widget.input.w;
import com.tencent.mm.plugin.appbrand.widget.input.w.a;

public final class a
  extends w
{
  private static final int VIEW_ID = 2131296720;
  public a cbC;
  private WAGamePanelInputEditText cbD;
  private View.OnClickListener cbE;
  
  private a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(130711);
    vO(VIEW_ID);
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
    n localn = n.db(paramView);
    n.dd(paramView);
    Object localObject = w.di(paramView);
    if ((localObject != null) && ((((w)localObject).getParent() instanceof ViewGroup))) {
      ((ViewGroup)((w)localObject).getParent()).removeView((View)localObject);
    }
    localObject = co(paramView);
    if (localObject == null) {
      if ((paramView instanceof a))
      {
        paramView = (a)paramView;
        localn.dc(paramView);
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
  
  public final void Cr()
  {
    AppMethodBeat.i(130714);
    cp(this);
    AppMethodBeat.o(130714);
  }
  
  public final void Cs()
  {
    AppMethodBeat.i(130715);
    this.cbC.setIsHide(false);
    AppMethodBeat.o(130715);
  }
  
  public final void Ct()
  {
    int j = 0;
    AppMethodBeat.i(130716);
    View localView = this.cbC.getConfirmButton();
    if ((this.cbD.getInputType() & 0x20000) > 0)
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
    this.cbE = paramOnClickListener;
  }
  
  public final void show()
  {
    AppMethodBeat.i(130718);
    this.mFa = this.cbD;
    this.cbD.requestFocus();
    super.show();
    AppMethodBeat.o(130718);
  }
  
  public static final class a
    extends FrameLayout
    implements w.a
  {
    public View cbH;
    
    public a(Context paramContext)
    {
      super();
      AppMethodBeat.i(130708);
      LayoutInflater.from(paramContext).inflate(2131492998, this, true);
      ((Button)findViewById(2131300437)).setText(2131755966);
      AppMethodBeat.o(130708);
    }
    
    public final View getConfirmButton()
    {
      AppMethodBeat.i(130707);
      if (this.cbH == null) {
        this.cbH = findViewById(2131300437);
      }
      View localView = this.cbH;
      AppMethodBeat.o(130707);
      return localView;
    }
    
    public final void setIsHide(boolean paramBoolean)
    {
      AppMethodBeat.i(130709);
      if (paramBoolean) {}
      for (int i = 8;; i = 0)
      {
        setVisibility(i);
        AppMethodBeat.o(130709);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.game.widget.input.a
 * JD-Core Version:    0.7.0.1
 */