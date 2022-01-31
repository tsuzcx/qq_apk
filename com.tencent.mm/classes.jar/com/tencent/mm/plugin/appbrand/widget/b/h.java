package com.tencent.mm.plugin.appbrand.widget.b;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
  extends g
{
  private TextView jjC;
  
  public h(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(143668);
    setContentView(2130970266);
    this.jjC = ((TextView)getContentView().findViewById(2131821848));
    AppMethodBeat.o(143668);
  }
  
  public final void setMessage(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(143669);
    this.jjC.setText(paramCharSequence);
    AppMethodBeat.o(143669);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.b.h
 * JD-Core Version:    0.7.0.1
 */