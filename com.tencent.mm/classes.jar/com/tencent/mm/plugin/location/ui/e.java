package com.tencent.mm.plugin.location.ui;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.i;
import com.tencent.mm.plugin.p.d;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
  implements c
{
  private String KbS;
  private double KbW;
  private double KbX;
  private String KdY;
  private boolean Ker;
  private View Kes;
  private d Ket;
  private TextView Keu;
  private TextView Kev;
  public ImageButton Kew;
  public boolean hHq;
  private boolean isVisible;
  public String poiName;
  
  public e(d paramd, Context paramContext)
  {
    AppMethodBeat.i(55842);
    this.hHq = false;
    this.Ker = true;
    this.KbW = 1000000.0D;
    this.KbX = 1000000.0D;
    this.isVisible = true;
    this.KdY = "";
    paramContext = ((Activity)paramContext).findViewById(a.e.location_info_frame);
    this.Keu = ((TextView)paramContext.findViewById(a.e.location_info));
    this.Kev = ((TextView)paramContext.findViewById(a.e.location_info_detail));
    this.Kew = ((ImageButton)paramContext.findViewById(a.e.location_navigate_iv));
    this.Ket = paramd;
    this.Kes = paramContext;
    AppMethodBeat.o(55842);
  }
  
  public final String getPreText()
  {
    return this.KdY;
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(55843);
    this.KbS = paramString;
    paramString = this.KbS;
    Log.d("NewItemOverlay", "popView " + this.Kes.getWidth() + " " + this.Kes.getHeight());
    if ((paramString != null) && (!paramString.equals(""))) {
      this.Kev.setText(paramString);
    }
    if ((this.poiName != null) && (!this.poiName.equals(""))) {
      this.Keu.setText(this.poiName);
    }
    for (;;)
    {
      if (this.Ker)
      {
        this.Kes.setVisibility(0);
        this.Kes.invalidate();
      }
      AppMethodBeat.o(55843);
      return;
      this.Keu.setText(a.i.location_conversation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.e
 * JD-Core Version:    0.7.0.1
 */