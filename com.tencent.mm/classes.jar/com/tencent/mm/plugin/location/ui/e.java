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
  public boolean drv;
  private boolean isVisible;
  public String jDf;
  private String uZn;
  private double uZr;
  private double uZs;
  private boolean vbN;
  private View vbO;
  private d vbP;
  private TextView vbQ;
  private TextView vbR;
  public ImageButton vbS;
  private String vbu;
  
  public e(d paramd, Context paramContext)
  {
    AppMethodBeat.i(55842);
    this.drv = false;
    this.vbN = true;
    this.uZr = 1000000.0D;
    this.uZs = 1000000.0D;
    this.isVisible = true;
    this.vbu = "";
    paramContext = ((Activity)paramContext).findViewById(2131301527);
    this.vbQ = ((TextView)paramContext.findViewById(2131301525));
    this.vbR = ((TextView)paramContext.findViewById(2131301526));
    this.vbS = ((ImageButton)paramContext.findViewById(2131301534));
    this.vbP = paramd;
    this.vbO = paramContext;
    AppMethodBeat.o(55842);
  }
  
  public final String getPreText()
  {
    return this.vbu;
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(55843);
    this.uZn = paramString;
    paramString = this.uZn;
    ad.d("NewItemOverlay", "popView " + this.vbO.getWidth() + " " + this.vbO.getHeight());
    if ((paramString != null) && (!paramString.equals(""))) {
      this.vbR.setText(paramString);
    }
    if ((this.jDf != null) && (!this.jDf.equals(""))) {
      this.vbQ.setText(this.jDf);
    }
    for (;;)
    {
      if (this.vbN)
      {
        this.vbO.setVisibility(0);
        this.vbO.invalidate();
      }
      AppMethodBeat.o(55843);
      return;
      this.vbQ.setText(2131760712);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.e
 * JD-Core Version:    0.7.0.1
 */