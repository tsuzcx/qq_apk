package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
  extends g
{
  private TextView nhk;
  
  public h(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(49894);
    setContentView(2131494896);
    this.nhk = ((TextView)getContentView().findViewById(2131302339));
    AppMethodBeat.o(49894);
  }
  
  public final void setMessage(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(49895);
    this.nhk.setText(paramCharSequence);
    AppMethodBeat.o(49895);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.h
 * JD-Core Version:    0.7.0.1
 */