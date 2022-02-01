package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.c;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class z
  extends j
{
  public View hIU;
  public ImageView mZQ;
  public View naN;
  public MMNeat7extView naa;
  public View nal;
  public View nam;
  public TextView nbm;
  public ImageView nbo;
  public ImageView nbp;
  public MMNeat7extView nbq;
  
  public final View a(Context paramContext, c paramc)
  {
    AppMethodBeat.i(6071);
    super.b(paramContext, paramc);
    if (this.mYI != null)
    {
      paramContext = this.mYI;
      AppMethodBeat.o(6071);
      return paramContext;
    }
    this.mYI = View.inflate(paramContext, 2131493231, null);
    bDa();
    this.naa = ((MMNeat7extView)this.mYI.findViewById(2131305948));
    this.nbm = ((TextView)this.mYI.findViewById(2131303288));
    this.mZQ = ((ImageView)this.mYI.findViewById(2131297219));
    this.naN = this.mYI.findViewById(2131298114);
    this.hIU = this.mYI.findViewById(2131306012);
    this.nbq = ((MMNeat7extView)this.mYI.findViewById(2131305938));
    this.nal = this.mYI.findViewById(2131297350);
    this.nam = this.mYI.findViewById(2131304857);
    this.nbo = ((ImageView)this.mYI.findViewById(2131303284));
    this.nbp = ((ImageView)this.mYI.findViewById(2131298824));
    paramContext = this.mYI;
    AppMethodBeat.o(6071);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.z
 * JD-Core Version:    0.7.0.1
 */