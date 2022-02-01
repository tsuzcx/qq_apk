package com.tencent.mm.plugin.location.ui;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.k.d;
import com.tencent.mm.sdk.platformtools.ac;

public final class e
  implements c
{
  public boolean dfZ;
  public String gPy;
  private boolean isVisible;
  private String tWE;
  private double tWI;
  private double tWJ;
  private String tYL;
  private boolean tZe;
  private View tZf;
  private d tZg;
  private TextView tZh;
  private TextView tZi;
  public ImageButton tZj;
  
  public e(d paramd, Context paramContext)
  {
    AppMethodBeat.i(55842);
    this.dfZ = false;
    this.tZe = true;
    this.tWI = 1000000.0D;
    this.tWJ = 1000000.0D;
    this.isVisible = true;
    this.tYL = "";
    paramContext = ((Activity)paramContext).findViewById(2131301527);
    this.tZh = ((TextView)paramContext.findViewById(2131301525));
    this.tZi = ((TextView)paramContext.findViewById(2131301526));
    this.tZj = ((ImageButton)paramContext.findViewById(2131301534));
    this.tZg = paramd;
    this.tZf = paramContext;
    AppMethodBeat.o(55842);
  }
  
  public final String getPreText()
  {
    return this.tYL;
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(55843);
    this.tWE = paramString;
    paramString = this.tWE;
    ac.d("NewItemOverlay", "popView " + this.tZf.getWidth() + " " + this.tZf.getHeight());
    if ((paramString != null) && (!paramString.equals(""))) {
      this.tZi.setText(paramString);
    }
    if ((this.gPy != null) && (!this.gPy.equals(""))) {
      this.tZh.setText(this.gPy);
    }
    for (;;)
    {
      if (this.tZe)
      {
        this.tZf.setVisibility(0);
        this.tZf.invalidate();
      }
      AppMethodBeat.o(55843);
      return;
      this.tZh.setText(2131760712);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.e
 * JD-Core Version:    0.7.0.1
 */