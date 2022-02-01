package com.tencent.luggage.game.widget.input;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.plugin.appbrand.widget.input.w;
import com.tencent.mm.plugin.appbrand.widget.input.w.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends w
{
  private static final int VIEW_ID = 2131296802;
  public a cxQ;
  public WAGamePanelInputEditText cxR;
  private View.OnClickListener cxS;
  
  private a(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(130711);
    Ag(VIEW_ID);
    AppMethodBeat.o(130711);
  }
  
  public static a cd(View paramView)
  {
    AppMethodBeat.i(130712);
    paramView = (a)paramView.getRootView().findViewById(VIEW_ID);
    AppMethodBeat.o(130712);
    return paramView;
  }
  
  public static a ce(View paramView)
  {
    AppMethodBeat.i(130713);
    n localn = n.cW(paramView);
    n.cY(paramView);
    Object localObject = w.dc(paramView);
    if ((localObject != null) && ((((w)localObject).getParent() instanceof ViewGroup))) {
      ((ViewGroup)((w)localObject).getParent()).removeView((View)localObject);
    }
    localObject = cd(paramView);
    if (localObject == null) {
      if ((paramView instanceof a))
      {
        paramView = (a)paramView;
        localn.cX(paramView);
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
  
  public final void Np()
  {
    AppMethodBeat.i(130714);
    ce(this);
    AppMethodBeat.o(130714);
  }
  
  public final void Nq()
  {
    AppMethodBeat.i(130715);
    this.cxQ.setIsHide(false);
    AppMethodBeat.o(130715);
  }
  
  public final void Nr()
  {
    int j = 0;
    AppMethodBeat.i(130716);
    View localView = this.cxQ.getConfirmButton();
    if ((this.cxR.getInputType() & 0x20000) > 0)
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
    this.cxS = paramOnClickListener;
  }
  
  public final void show()
  {
    AppMethodBeat.i(130718);
    this.oum = this.cxR;
    this.cxR.requestFocus();
    super.show();
    AppMethodBeat.o(130718);
  }
  
  public static final class a
    extends FrameLayout
    implements w.a
  {
    public View cxV;
    
    public a(Context paramContext)
    {
      super();
      AppMethodBeat.i(130708);
      LayoutInflater.from(paramContext).inflate(2131493036, this, true);
      ((Button)findViewById(2131301960)).setText(2131756072);
      AppMethodBeat.o(130708);
    }
    
    public final View getConfirmButton()
    {
      AppMethodBeat.i(130707);
      if (this.cxV == null) {
        this.cxV = findViewById(2131301960);
      }
      View localView = this.cxV;
      AppMethodBeat.o(130707);
      return localView;
    }
    
    public final void setEditBarMargins(int paramInt)
    {
      AppMethodBeat.i(258492);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.cxV.getLayoutParams();
      Log.i("MicroMsg.WAGameInputPanel", "EditBar setmConfirmButtonPadding tolerate(%d),rightMargin(%d).", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(localLayoutParams.rightMargin) });
      localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin, localLayoutParams.rightMargin + paramInt, localLayoutParams.bottomMargin);
      this.cxV.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(258492);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.luggage.game.widget.input.a
 * JD-Core Version:    0.7.0.1
 */