package com.tencent.mm.plugin.location.ui;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.k.d;
import com.tencent.mm.sdk.platformtools.ae;

public final class e
  implements c
{
  public boolean dsB;
  private boolean isVisible;
  public String jGd;
  private double vlC;
  private double vlD;
  private String vly;
  private String vnF;
  private boolean vnY;
  private View vnZ;
  private d voa;
  private TextView vob;
  private TextView voc;
  public ImageButton vod;
  
  public e(d paramd, Context paramContext)
  {
    AppMethodBeat.i(55842);
    this.dsB = false;
    this.vnY = true;
    this.vlC = 1000000.0D;
    this.vlD = 1000000.0D;
    this.isVisible = true;
    this.vnF = "";
    paramContext = ((Activity)paramContext).findViewById(2131301527);
    this.vob = ((TextView)paramContext.findViewById(2131301525));
    this.voc = ((TextView)paramContext.findViewById(2131301526));
    this.vod = ((ImageButton)paramContext.findViewById(2131301534));
    this.voa = paramd;
    this.vnZ = paramContext;
    AppMethodBeat.o(55842);
  }
  
  public final String getPreText()
  {
    return this.vnF;
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(55843);
    this.vly = paramString;
    paramString = this.vly;
    ae.d("NewItemOverlay", "popView " + this.vnZ.getWidth() + " " + this.vnZ.getHeight());
    if ((paramString != null) && (!paramString.equals(""))) {
      this.voc.setText(paramString);
    }
    if ((this.jGd != null) && (!this.jGd.equals(""))) {
      this.vob.setText(this.jGd);
    }
    for (;;)
    {
      if (this.vnY)
      {
        this.vnZ.setVisibility(0);
        this.vnZ.invalidate();
      }
      AppMethodBeat.o(55843);
      return;
      this.vob.setText(2131760712);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.e
 * JD-Core Version:    0.7.0.1
 */