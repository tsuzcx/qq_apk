package com.tencent.kinda.framework.app;

import com.tencent.kinda.gen.IUIPage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class KindaUIPageMap
{
  private static ConcurrentHashMap<String, Value> data;
  
  static
  {
    AppMethodBeat.i(18528);
    data = new ConcurrentHashMap();
    AppMethodBeat.o(18528);
  }
  
  public static Value getAndRemove(String paramString)
  {
    AppMethodBeat.i(18527);
    Value localValue = null;
    if (data.containsKey(paramString))
    {
      localValue = (Value)data.get(paramString);
      data.remove(paramString);
    }
    AppMethodBeat.o(18527);
    return localValue;
  }
  
  public static String getUUID()
  {
    AppMethodBeat.i(18525);
    String str = UUID.randomUUID().toString();
    AppMethodBeat.o(18525);
    return str;
  }
  
  public static String put(IUIPage paramIUIPage)
  {
    AppMethodBeat.i(18526);
    String str = getUUID();
    Value localValue = new Value();
    localValue.uiPage = paramIUIPage;
    data.put(str, localValue);
    AppMethodBeat.o(18526);
    return str;
  }
  
  public static class Value
  {
    public IUIPage uiPage;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KindaUIPageMap
 * JD-Core Version:    0.7.0.1
 */