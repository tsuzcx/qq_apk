package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.c;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class m
  extends j
{
  public View ijv;
  public ImageView nCG;
  public ImageView nCH;
  public ImageView nCI;
  public View nCJ;
  public View nCK;
  public MMNeat7extView nCy;
  
  public final View a(Context paramContext, c paramc)
  {
    AppMethodBeat.i(6017);
    super.b(paramContext, paramc);
    if (this.nBh != null)
    {
      paramContext = this.nBh;
      AppMethodBeat.o(6017);
      return paramContext;
    }
    this.nBh = View.inflate(paramContext, 2131493209, null);
    bKj();
    this.nCG = ((ImageView)this.nBh.findViewById(2131303257));
    this.nCH = ((ImageView)this.nBh.findViewById(2131303258));
    this.nCI = ((ImageView)this.nBh.findViewById(2131298824));
    this.ijv = this.nBh.findViewById(2131306012);
    this.nCJ = this.nBh.findViewById(2131297218);
    this.nCK = this.nBh.findViewById(2131304856);
    this.nCy = ((MMNeat7extView)this.nBh.findViewById(2131305938));
    paramContext = this.nBh;
    AppMethodBeat.o(6017);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.m
 * JD-Core Version:    0.7.0.1
 */