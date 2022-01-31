package com.tencent.luggage.game.widget.input;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.input.w.a;

public final class a$a
  extends FrameLayout
  implements w.a
{
  public View bCH;
  
  public a$a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(140557);
    LayoutInflater.from(paramContext).inflate(2130968685, this, true);
    ((Button)findViewById(2131821215)).setText(2131297136);
    AppMethodBeat.o(140557);
  }
  
  public final View getConfirmButton()
  {
    AppMethodBeat.i(140556);
    if (this.bCH == null) {
      this.bCH = findViewById(2131821215);
    }
    View localView = this.bCH;
    AppMethodBeat.o(140556);
    return localView;
  }
  
  public final void setIsHide(boolean paramBoolean)
  {
    AppMethodBeat.i(140558);
    if (paramBoolean) {}
    for (int i = 8;; i = 0)
    {
      setVisibility(i);
      AppMethodBeat.o(140558);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.game.widget.input.a.a
 * JD-Core Version:    0.7.0.1
 */