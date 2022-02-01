package com.tencent.mm.flutter;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import org.json.JSONObject;

public final class c
{
  public Runnable callback;
  public Context context;
  public String grd;
  public String gre;
  public Object grf;
  public Object result;
  
  public final <T> T wd(String paramString)
  {
    AppMethodBeat.i(159065);
    if (this.grf == null)
    {
      AppMethodBeat.o(159065);
      return null;
    }
    if ((this.grf instanceof Map))
    {
      paramString = ((Map)this.grf).get(paramString);
      AppMethodBeat.o(159065);
      return paramString;
    }
    if ((this.grf instanceof JSONObject))
    {
      paramString = ((JSONObject)this.grf).opt(paramString);
      AppMethodBeat.o(159065);
      return paramString;
    }
    paramString = new ClassCastException();
    AppMethodBeat.o(159065);
    throw paramString;
  }
  
  public final boolean we(String paramString)
  {
    AppMethodBeat.i(159066);
    if (this.grf == null)
    {
      AppMethodBeat.o(159066);
      return false;
    }
    boolean bool;
    if ((this.grf instanceof Map))
    {
      bool = ((Map)this.grf).containsKey(paramString);
      AppMethodBeat.o(159066);
      return bool;
    }
    if ((this.grf instanceof JSONObject))
    {
      bool = ((JSONObject)this.grf).has(paramString);
      AppMethodBeat.o(159066);
      return bool;
    }
    paramString = new ClassCastException();
    AppMethodBeat.o(159066);
    throw paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.flutter.c
 * JD-Core Version:    0.7.0.1
 */