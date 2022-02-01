package com.tencent.mm.plugin.location.ui;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.k.d;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
  implements c
{
  public boolean dJM;
  private boolean isVisible;
  public String kHV;
  private String yFq;
  private double yFu;
  private double yFv;
  private boolean yHP;
  private View yHQ;
  private d yHR;
  private TextView yHS;
  private TextView yHT;
  public ImageButton yHU;
  private String yHw;
  
  public e(d paramd, Context paramContext)
  {
    AppMethodBeat.i(55842);
    this.dJM = false;
    this.yHP = true;
    this.yFu = 1000000.0D;
    this.yFv = 1000000.0D;
    this.isVisible = true;
    this.yHw = "";
    paramContext = ((Activity)paramContext).findViewById(2131303733);
    this.yHS = ((TextView)paramContext.findViewById(2131303731));
    this.yHT = ((TextView)paramContext.findViewById(2131303732));
    this.yHU = ((ImageButton)paramContext.findViewById(2131303741));
    this.yHR = paramd;
    this.yHQ = paramContext;
    AppMethodBeat.o(55842);
  }
  
  public final String getPreText()
  {
    return this.yHw;
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(55843);
    this.yFq = paramString;
    paramString = this.yFq;
    Log.d("NewItemOverlay", "popView " + this.yHQ.getWidth() + " " + this.yHQ.getHeight());
    if ((paramString != null) && (!paramString.equals(""))) {
      this.yHT.setText(paramString);
    }
    if ((this.kHV != null) && (!this.kHV.equals(""))) {
      this.yHS.setText(this.kHV);
    }
    for (;;)
    {
      if (this.yHP)
      {
        this.yHQ.setVisibility(0);
        this.yHQ.invalidate();
      }
      AppMethodBeat.o(55843);
      return;
      this.yHS.setText(2131762450);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.e
 * JD-Core Version:    0.7.0.1
 */