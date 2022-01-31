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
    AppMethodBeat.i(61198);
    paramContentValues = new UnsupportedOperationException("Cannot add data to empty builder");
    AppMethodBeat.o(61198);
    throw paramContentValues;
  }
  
  public final DataHolder.Builder withRow(HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(61197);
    paramHashMap = new UnsupportedOperationException("Cannot add data to empty builder");
    AppMethodBeat.o(61197);
    throw paramHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.common.data.zza
 * JD-Core Version:    0.7.0.1
 */