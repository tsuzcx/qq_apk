package com.google.android.gms.common.data;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

final class zza
  extends DataHolder.Builder
{
  zza(String[] paramArrayOfString, String paramString)
  {
    super(paramArrayOfString, null, null);
  }
  
  public final DataHolder.Builder withRow(ContentValues paramContentValues)
  {
    AppMethodBeat.i(11690);
    paramContentValues = new UnsupportedOperationException("Cannot add data to empty builder");
    AppMethodBeat.o(11690);
    throw paramContentValues;
  }
  
  public final DataHolder.Builder withRow(HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(11689);
    paramHashMap = new UnsupportedOperationException("Cannot add data to empty builder");
    AppMethodBeat.o(11689);
    throw paramHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.common.data.zza
 * JD-Core Version:    0.7.0.1
 */