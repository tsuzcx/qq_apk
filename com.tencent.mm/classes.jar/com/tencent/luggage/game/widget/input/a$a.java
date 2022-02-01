package com.tencent.luggage.game.widget.input;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.input.w.a;
import com.tencent.mm.sdk.platformtools.ad;

public final class a$a
  extends FrameLayout
  implements w.a
{
  public View clY;
  
  public a$a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(130708);
    LayoutInflater.from(paramContext).inflate(2131492998, this, true);
    ((Button)findViewById(2131300437)).setText(2131755966);
    AppMethodBeat.o(130708);
  }
  
  public final View getConfirmButton()
  {
    AppMethodBeat.i(130707);
    if (this.clY == null) {
      this.clY = findViewById(2131300437);
    }
    View localView = this.clY;
    AppMethodBeat.o(130707);
    return localView;
  }
  
  public final void setEditBarMargins(int paramInt)
  {
    AppMethodBeat.i(221361);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.clY.getLayoutParams();
    ad.i("MicroMsg.WAGameInputPanel", "EditBar setmConfirmButtonPadding tolerate(%d),rightMargin(%d).", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(localLayoutParams.rightMargin) });
    localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin, localLayoutParams.rightMargin + paramInt, localLayoutParams.bottomMargin);
    this.clY.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(221361);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.game.widget.input.a.a
 * JD-Core Version:    0.7.0.1
 */