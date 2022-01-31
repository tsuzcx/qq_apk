package com.tencent.mm.plugin.base.stub;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;

public final class a
  extends d
{
  public a(Context paramContext, String paramString1, String paramString2, d.a parama)
  {
    super(paramContext, paramString1, paramString2, parama);
  }
  
  protected final void aVD()
  {
    AppMethodBeat.i(18110);
    h.a(this.context, 2131300438, 2131297087, false, new a.1(this));
    AppMethodBeat.o(18110);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.a
 * JD-Core Version:    0.7.0.1
 */