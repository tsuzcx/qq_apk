package com.tencent.mm.plugin.location.ui;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.i;
import com.tencent.mm.plugin.q.d;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
  implements c
{
  private String Ejj;
  private double Ejn;
  private double Ejo;
  private boolean ElI;
  private View ElJ;
  private d ElK;
  private TextView ElL;
  private TextView ElM;
  public ImageButton ElN;
  private String Elp;
  public boolean fCB;
  private boolean isVisible;
  public String poiName;
  
  public e(d paramd, Context paramContext)
  {
    AppMethodBeat.i(55842);
    this.fCB = false;
    this.ElI = true;
    this.Ejn = 1000000.0D;
    this.Ejo = 1000000.0D;
    this.isVisible = true;
    this.Elp = "";
    paramContext = ((Activity)paramContext).findViewById(a.e.location_info_frame);
    this.ElL = ((TextView)paramContext.findViewById(a.e.location_info));
    this.ElM = ((TextView)paramContext.findViewById(a.e.location_info_detail));
    this.ElN = ((ImageButton)paramContext.findViewById(a.e.location_navigate_iv));
    this.ElK = paramd;
    this.ElJ = paramContext;
    AppMethodBeat.o(55842);
  }
  
  public final String getPreText()
  {
    return this.Elp;
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(55843);
    this.Ejj = paramString;
    paramString = this.Ejj;
    Log.d("NewItemOverlay", "popView " + this.ElJ.getWidth() + " " + this.ElJ.getHeight());
    if ((paramString != null) && (!paramString.equals(""))) {
      this.ElM.setText(paramString);
    }
    if ((this.poiName != null) && (!this.poiName.equals(""))) {
      this.ElL.setText(this.poiName);
    }
    for (;;)
    {
      if (this.ElI)
      {
        this.ElJ.setVisibility(0);
        this.ElJ.invalidate();
      }
      AppMethodBeat.o(55843);
      return;
      this.ElL.setText(a.i.location_conversation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.e
 * JD-Core Version:    0.7.0.1
 */