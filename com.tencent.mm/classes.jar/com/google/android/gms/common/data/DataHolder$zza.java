package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;
import java.util.HashMap;

final class DataHolder$zza
  implements Comparator<HashMap<String, Object>>
{
  private final String zznz;
  
  DataHolder$zza(String paramString)
  {
    AppMethodBeat.i(11578);
    this.zznz = ((String)Preconditions.checkNotNull(paramString));
    AppMethodBeat.o(11578);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.common.data.DataHolder.zza
 * JD-Core Version:    0.7.0.1
 */