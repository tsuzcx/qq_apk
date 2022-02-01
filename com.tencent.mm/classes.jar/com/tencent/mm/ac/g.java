package com.tencent.mm.ac;

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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ac.g
 * JD-Core Version:    0.7.0.1
 */