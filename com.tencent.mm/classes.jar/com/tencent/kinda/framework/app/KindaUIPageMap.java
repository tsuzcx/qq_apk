package com.tencent.kinda.framework.app;

import com.tencent.kinda.gen.IUIPage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class KindaUIPageMap
{
  private static ConcurrentHashMap<String, KindaUIPageMap.Value> data;
  
  static
  {
    AppMethodBeat.i(144421);
    data = new ConcurrentHashMap();
    AppMethodBeat.o(144421);
  }
  
  public static KindaUIPageMap.Value getAndRemove(String paramString)
  {
    AppMethodBeat.i(144420);
    KindaUIPageMap.Value localValue = null;
    if (data.containsKey(paramString))
    {
      localValue = (KindaUIPageMap.Value)data.get(paramString);
      data.remove(paramString);
    }
    AppMethodBeat.o(144420);
    return localValue;
  }
  
  public static String getUUID()
  {
    AppMethodBeat.i(144418);
    String str = UUID.randomUUID().toString();
    AppMethodBeat.o(144418);
    return str;
  }
  
  public static String put(IUIPage paramIUIPage)
  {
    AppMethodBeat.i(144419);
    String str = getUUID();
    KindaUIPageMap.Value localValue = new KindaUIPageMap.Value();
    localValue.uiPage = paramIUIPage;
    data.put(str, localValue);
    AppMethodBeat.o(144419);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KindaUIPageMap
 * JD-Core Version:    0.7.0.1
 */