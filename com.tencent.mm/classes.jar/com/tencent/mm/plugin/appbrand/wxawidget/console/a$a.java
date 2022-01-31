package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$a
  extends RecyclerView.v
{
  TextView gMp;
  TextView jxr;
  
  public a$a(View paramView, int paramInt)
  {
    super(paramView);
    AppMethodBeat.i(11125);
    this.jxr = ((TextView)paramView.findViewById(2131823021));
    this.gMp = ((TextView)paramView.findViewById(2131823022));
    switch (paramInt)
    {
    default: 
      this.jxr.setText("L");
      this.gMp.setTextColor(-7829368);
      AppMethodBeat.o(11125);
      return;
    case 1: 
      this.jxr.setText("L");
      this.gMp.setTextColor(-7829368);
      AppMethodBeat.o(11125);
      return;
    case 2: 
      this.jxr.setText("I");
      this.gMp.setTextColor(-16777216);
      AppMethodBeat.o(11125);
      return;
    case 3: 
      this.jxr.setText("W");
      this.gMp.setTextColor(Color.rgb(0, 0, 204));
      AppMethodBeat.o(11125);
      return;
    }
    this.jxr.setText("E");
    this.gMp.setTextColor(-65536);
    AppMethodBeat.o(11125);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.a.a
 * JD-Core Version:    0.7.0.1
 */