package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class al
  extends v
{
  public View iCM;
  public MMNeat7extView ocA;
  public ImageView oeW;
  public View ofK;
  public View ofj;
  public View ofk;
  public TextView ogg;
  public ImageView ogi;
  public ImageView ogj;
  public MMNeat7extView ogk;
  
  public final View a(Context paramContext, b paramb)
  {
    AppMethodBeat.i(6071);
    super.b(paramContext, paramb);
    if (this.odh != null)
    {
      paramContext = this.odh;
      AppMethodBeat.o(6071);
      return paramContext;
    }
    this.odh = View.inflate(paramContext, 2131493231, null);
    bOL();
    this.ocA = ((MMNeat7extView)this.odh.findViewById(2131305948));
    this.ogg = ((TextView)this.odh.findViewById(2131303288));
    this.oeW = ((ImageView)this.odh.findViewById(2131297219));
    this.ofK = this.odh.findViewById(2131298114);
    this.iCM = this.odh.findViewById(2131306012);
    this.ogk = ((MMNeat7extView)this.odh.findViewById(2131305938));
    this.ofj = this.odh.findViewById(2131297350);
    this.ofk = this.odh.findViewById(2131304857);
    this.ogi = ((ImageView)this.odh.findViewById(2131303284));
    this.ogj = ((ImageView)this.odh.findViewById(2131298824));
    paramContext = this.odh;
    AppMethodBeat.o(6071);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.al
 * JD-Core Version:    0.7.0.1
 */