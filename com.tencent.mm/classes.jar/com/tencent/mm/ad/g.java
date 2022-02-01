package com.tencent.mm.ad;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONException;

public final class g
  extends JSONException
{
  public g(String paramString)
  {
    super(paramString);
  }
  
  public g(Throwable paramThrowable)
  {
    super(Log.getStackTraceString(paramThrowable));
    AppMethodBeat.i(158564);
    AppMethodBeat.o(158564);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ad.g
 * JD-Core Version:    0.7.0.1
 */