package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.annotation.Nullable;

public class StringResourceValueReader
{
  private final Resources zzvb;
  private final String zzvc;
  
  public StringResourceValueReader(Context paramContext)
  {
    AppMethodBeat.i(89721);
    Preconditions.checkNotNull(paramContext);
    this.zzvb = paramContext.getResources();
    this.zzvc = this.zzvb.getResourcePackageName(2131296294);
    AppMethodBeat.o(89721);
  }
  
  @Nullable
  public String getString(String paramString)
  {
    AppMethodBeat.i(89722);
    int i = this.zzvb.getIdentifier(paramString, "string", this.zzvc);
    if (i == 0)
    {
      AppMethodBeat.o(89722);
      return null;
    }
    paramString = this.zzvb.getString(i);
    AppMethodBeat.o(89722);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.StringResourceValueReader
 * JD-Core Version:    0.7.0.1
 */