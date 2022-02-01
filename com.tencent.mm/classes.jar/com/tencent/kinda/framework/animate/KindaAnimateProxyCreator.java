package com.tencent.kinda.framework.animate;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.HashMap;

@Deprecated
public class KindaAnimateProxyCreator
{
  private static HashMap<Integer, WeakReference<Object>> cache;
  
  static
  {
    AppMethodBeat.i(18301);
    cache = new HashMap();
    AppMethodBeat.o(18301);
  }
  
  public static Object checkCreateAnimateViewProxy(Object paramObject)
  {
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.framework.animate.KindaAnimateProxyCreator
 * JD-Core Version:    0.7.0.1
 */