package com.tencent.mm.plugin.flutter.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugin.a.n;
import io.flutter.plugin.platform.d;

public final class b
  extends d
{
  private io.flutter.plugin.a.c wJt;
  
  public b(io.flutter.plugin.a.c paramc)
  {
    super(n.SSp);
    this.wJt = paramc;
  }
  
  public final io.flutter.plugin.platform.c a(Context paramContext, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(240950);
    paramContext = new a(paramContext, this.wJt, paramInt, paramObject);
    AppMethodBeat.o(240950);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.d.b
 * JD-Core Version:    0.7.0.1
 */