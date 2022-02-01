package com.tencent.mm.flutter;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import org.json.JSONObject;

public final class c
{
  public Runnable callback;
  public Context context;
  public String gtD;
  public String gtE;
  public Object gtF;
  public Object result;
  
  public final <T> T wM(String paramString)
  {
    AppMethodBeat.i(159065);
    if (this.gtF == null)
    {
      AppMethodBeat.o(159065);
      return null;
    }
    if ((this.gtF instanceof Map))
    {
      paramString = ((Map)this.gtF).get(paramString);
      AppMethodBeat.o(159065);
      return paramString;
    }
    if ((this.gtF instanceof JSONObject))
    {
      paramString = ((JSONObject)this.gtF).opt(paramString);
      AppMethodBeat.o(159065);
      return paramString;
    }
    paramString = new ClassCastException();
    AppMethodBeat.o(159065);
    throw paramString;
  }
  
  public final boolean wN(String paramString)
  {
    AppMethodBeat.i(159066);
    if (this.gtF == null)
    {
      AppMethodBeat.o(159066);
      return false;
    }
    boolean bool;
    if ((this.gtF instanceof Map))
    {
      bool = ((Map)this.gtF).containsKey(paramString);
      AppMethodBeat.o(159066);
      return bool;
    }
    if ((this.gtF instanceof JSONObject))
    {
      bool = ((JSONObject)this.gtF).has(paramString);
      AppMethodBeat.o(159066);
      return bool;
    }
    paramString = new ClassCastException();
    AppMethodBeat.o(159066);
    throw paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.flutter.c
 * JD-Core Version:    0.7.0.1
 */