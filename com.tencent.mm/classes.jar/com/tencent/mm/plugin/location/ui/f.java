package com.tencent.mm.plugin.location.ui;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.k.d;
import com.tencent.mm.sdk.platformtools.ab;

public final class f
  implements c
{
  public boolean ctJ;
  public String eSM;
  private boolean isVisible;
  private String nZR;
  private double nZV;
  private double nZW;
  private String obY;
  private d ocA;
  private TextView ocB;
  private TextView ocC;
  public ImageButton ocD;
  private boolean ocy;
  private View ocz;
  
  public f(d paramd, Context paramContext)
  {
    AppMethodBeat.i(113459);
    this.ctJ = false;
    this.ocy = true;
    this.nZV = 1000000.0D;
    this.nZW = 1000000.0D;
    this.isVisible = true;
    this.obY = "";
    paramContext = ((Activity)paramContext).findViewById(2131826543);
    this.ocB = ((TextView)paramContext.findViewById(2131826544));
    this.ocC = ((TextView)paramContext.findViewById(2131826545));
    this.ocD = ((ImageButton)paramContext.findViewById(2131826546));
    this.ocA = paramd;
    this.ocz = paramContext;
    AppMethodBeat.o(113459);
  }
  
  public final String getPreText()
  {
    return this.obY;
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(113460);
    this.nZR = paramString;
    paramString = this.nZR;
    ab.d("NewItemOverlay", "popView " + this.ocz.getWidth() + " " + this.ocz.getHeight());
    if ((paramString != null) && (!paramString.equals(""))) {
      this.ocC.setText(paramString);
    }
    if ((this.eSM != null) && (!this.eSM.equals(""))) {
      this.ocB.setText(this.eSM);
    }
    for (;;)
    {
      if (this.ocy)
      {
        this.ocz.setVisibility(0);
        this.ocz.invalidate();
      }
      AppMethodBeat.o(113460);
      return;
      this.ocB.setText(2131301088);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.f
 * JD-Core Version:    0.7.0.1
 */