package com.tencent.mm.flutter;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import org.json.JSONObject;

public final class c
{
  public Runnable callback;
  public Context context;
  public String fXH;
  public String fXI;
  public Object fXJ;
  public Object result;
  
  public final <T> T tn(String paramString)
  {
    AppMethodBeat.i(159065);
    if (this.fXJ == null)
    {
      AppMethodBeat.o(159065);
      return null;
    }
    if ((this.fXJ instanceof Map))
    {
      paramString = ((Map)this.fXJ).get(paramString);
      AppMethodBeat.o(159065);
      return paramString;
    }
    if ((this.fXJ instanceof JSONObject))
    {
      paramString = ((JSONObject)this.fXJ).opt(paramString);
      AppMethodBeat.o(159065);
      return paramString;
    }
    paramString = new ClassCastException();
    AppMethodBeat.o(159065);
    throw paramString;
  }
  
  public final boolean to(String paramString)
  {
    AppMethodBeat.i(159066);
    if (this.fXJ == null)
    {
      AppMethodBeat.o(159066);
      return false;
    }
    boolean bool;
    if ((this.fXJ instanceof Map))
    {
      bool = ((Map)this.fXJ).containsKey(paramString);
      AppMethodBeat.o(159066);
      return bool;
    }
    if ((this.fXJ instanceof JSONObject))
    {
      bool = ((JSONObject)this.fXJ).has(paramString);
      AppMethodBeat.o(159066);
      return bool;
    }
    paramString = new ClassCastException();
    AppMethodBeat.o(159066);
    throw paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.flutter.c
 * JD-Core Version:    0.7.0.1
 */