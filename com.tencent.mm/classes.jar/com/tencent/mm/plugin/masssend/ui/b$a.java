package com.tencent.mm.plugin.masssend.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.h;

final class b$a
  extends h
{
  String fileName;
  
  public b$a(b paramb, Context paramContext)
  {
    super(paramContext, false);
  }
  
  public final boolean Ez()
  {
    AppMethodBeat.i(22774);
    this.fileName = super.getFileName();
    boolean bool = super.Ez();
    super.reset();
    AppMethodBeat.o(22774);
    return bool;
  }
  
  public final String getFileName()
  {
    return this.fileName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.b.a
 * JD-Core Version:    0.7.0.1
 */