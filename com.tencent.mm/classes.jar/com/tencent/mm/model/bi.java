package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import org.json.JSONObject;

public final class bi
{
  public final Object arguments;
  public final String method;
  
  static
  {
    AppMethodBeat.i(241955);
    if (!bi.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(241955);
      return;
    }
  }
  
  public bi(String paramString, Object paramObject)
  {
    this.method = paramString;
    this.arguments = paramObject;
  }
  
  public final <T> T argument(String paramString)
  {
    AppMethodBeat.i(241957);
    if (this.arguments == null)
    {
      AppMethodBeat.o(241957);
      return null;
    }
    if ((this.arguments instanceof Map))
    {
      paramString = ((Map)this.arguments).get(paramString);
      AppMethodBeat.o(241957);
      return paramString;
    }
    if ((this.arguments instanceof JSONObject))
    {
      paramString = ((JSONObject)this.arguments).opt(paramString);
      AppMethodBeat.o(241957);
      return paramString;
    }
    paramString = new ClassCastException();
    AppMethodBeat.o(241957);
    throw paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.model.bi
 * JD-Core Version:    0.7.0.1
 */