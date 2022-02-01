package com.tencent.mm.plugin.location.ui;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.k.d;
import com.tencent.mm.sdk.platformtools.ad;

public final class e
  implements c
{
  public boolean diE;
  public String goQ;
  private boolean isVisible;
  private String sOr;
  private double sOv;
  private double sOw;
  private boolean sQR;
  private View sQS;
  private d sQT;
  private TextView sQU;
  private TextView sQV;
  public ImageButton sQW;
  private String sQy;
  
  public e(d paramd, Context paramContext)
  {
    AppMethodBeat.i(55842);
    this.diE = false;
    this.sQR = true;
    this.sOv = 1000000.0D;
    this.sOw = 1000000.0D;
    this.isVisible = true;
    this.sQy = "";
    paramContext = ((Activity)paramContext).findViewById(2131301527);
    this.sQU = ((TextView)paramContext.findViewById(2131301525));
    this.sQV = ((TextView)paramContext.findViewById(2131301526));
    this.sQW = ((ImageButton)paramContext.findViewById(2131301534));
    this.sQT = paramd;
    this.sQS = paramContext;
    AppMethodBeat.o(55842);
  }
  
  public final String getPreText()
  {
    return this.sQy;
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(55843);
    this.sOr = paramString;
    paramString = this.sOr;
    ad.d("NewItemOverlay", "popView " + this.sQS.getWidth() + " " + this.sQS.getHeight());
    if ((paramString != null) && (!paramString.equals(""))) {
      this.sQV.setText(paramString);
    }
    if ((this.goQ != null) && (!this.goQ.equals(""))) {
      this.sQU.setText(this.goQ);
    }
    for (;;)
    {
      if (this.sQR)
      {
        this.sQS.setVisibility(0);
        this.sQS.invalidate();
      }
      AppMethodBeat.o(55843);
      return;
      this.sQU.setText(2131760712);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.e
 * JD-Core Version:    0.7.0.1
 */