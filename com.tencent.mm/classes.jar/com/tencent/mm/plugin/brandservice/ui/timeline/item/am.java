package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.b.d;

public final class am
  extends a
{
  public ProgressBar progressBar;
  public View puO;
  public LinearLayout pyc;
  public TextView pyd;
  public TextView pye;
  public LinearLayout pyf;
  public TextView pyg;
  
  public final View cU(Context paramContext)
  {
    AppMethodBeat.i(194973);
    if (this.puO != null)
    {
      paramContext = this.puO;
      AppMethodBeat.o(194973);
      return paramContext;
    }
    this.puO = View.inflate(paramContext, 2131493263, null);
    this.pyc = ((LinearLayout)this.puO.findViewById(2131297537));
    this.pyd = ((TextView)this.puO.findViewById(2131297578));
    this.pyf = ((LinearLayout)this.puO.findViewById(2131297572));
    this.pyg = ((TextView)this.puO.findViewById(2131297573));
    this.progressBar = ((ProgressBar)this.puO.findViewById(2131297576));
    this.pye = ((TextView)this.puO.findViewById(2131297577));
    paramContext = d.pMy;
    d.i(this.pyd);
    paramContext = d.pMy;
    d.i(this.pye);
    paramContext = this.puO;
    AppMethodBeat.o(194973);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.am
 * JD-Core Version:    0.7.0.1
 */