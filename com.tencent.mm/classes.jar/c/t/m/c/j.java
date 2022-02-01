package c.t.m.c;

import com.tencent.map.geolocation.internal.LocationLogCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class j
{
  public static LocationLogCallback a;
  
  public static void a(int paramInt, String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(39936);
    LocationLogCallback localLocationLogCallback = a;
    if (localLocationLogCallback != null) {
      localLocationLogCallback.onLog(paramInt, "TencentLocationComp", paramString, paramThrowable);
    }
    AppMethodBeat.o(39936);
  }
  
  public static void a(LocationLogCallback paramLocationLogCallback)
  {
    a = paramLocationLogCallback;
  }
  
  public static void a(String paramString)
  {
    AppMethodBeat.i(39937);
    a(4, paramString, null);
    AppMethodBeat.o(39937);
  }
  
  public static void a(String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(39938);
    a(6, paramString, paramThrowable);
    AppMethodBeat.o(39938);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     c.t.m.c.j
 * JD-Core Version:    0.7.0.1
 */