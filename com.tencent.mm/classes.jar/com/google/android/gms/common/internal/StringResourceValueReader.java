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
    AppMethodBeat.i(4743);
    Preconditions.checkNotNull(paramContext);
    this.zzvb = paramContext.getResources();
    this.zzvc = this.zzvb.getResourcePackageName(2131757764);
    AppMethodBeat.o(4743);
  }
  
  @Nullable
  public String getString(String paramString)
  {
    AppMethodBeat.i(4744);
    int i = this.zzvb.getIdentifier(paramString, "string", this.zzvc);
    if (i == 0)
    {
      AppMethodBeat.o(4744);
      return null;
    }
    paramString = this.zzvb.getString(i);
    AppMethodBeat.o(4744);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.common.internal.StringResourceValueReader
 * JD-Core Version:    0.7.0.1
 */