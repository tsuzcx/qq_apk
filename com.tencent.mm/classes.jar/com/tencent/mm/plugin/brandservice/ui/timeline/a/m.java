package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.c;
import com.tencent.mm.storage.s;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class m
  extends j
{
  public View hIU;
  public MMNeat7extView naa;
  public ImageView nai;
  public ImageView naj;
  public ImageView nak;
  public View nal;
  public View nam;
  
  public final View a(Context paramContext, c paramc)
  {
    AppMethodBeat.i(6017);
    super.b(paramContext, paramc);
    if (this.mYI != null)
    {
      paramContext = this.mYI;
      AppMethodBeat.o(6017);
      return paramContext;
    }
    this.mYI = View.inflate(paramContext, 2131493209, null);
    bDa();
    this.nai = ((ImageView)this.mYI.findViewById(2131303257));
    this.naj = ((ImageView)this.mYI.findViewById(2131303258));
    this.nak = ((ImageView)this.mYI.findViewById(2131298824));
    this.hIU = this.mYI.findViewById(2131306012);
    this.nal = this.mYI.findViewById(2131297218);
    this.nam = this.mYI.findViewById(2131304856);
    this.naa = ((MMNeat7extView)this.mYI.findViewById(2131305938));
    paramContext = this.mYI;
    AppMethodBeat.o(6017);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.m
 * JD-Core Version:    0.7.0.1
 */