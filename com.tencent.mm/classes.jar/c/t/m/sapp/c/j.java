package c.t.m.sapp.c;

import com.tencent.map.geolocation.sapp.internal.LocationLogCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class j
{
  public static String a = "TencentLocTag";
  public static LocationLogCallback b;
  
  public static void a(int paramInt, String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(222984);
    LocationLogCallback localLocationLogCallback = b;
    if (localLocationLogCallback != null) {
      localLocationLogCallback.onLog(paramInt, "TencentLocationComp_sapp", paramString, paramThrowable);
    }
    AppMethodBeat.o(222984);
  }
  
  public static void a(LocationLogCallback paramLocationLogCallback)
  {
    b = paramLocationLogCallback;
  }
  
  public static void a(String paramString)
  {
    AppMethodBeat.i(222985);
    a(4, paramString, null);
    AppMethodBeat.o(222985);
  }
  
  public static void a(String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(222986);
    a(6, paramString, paramThrowable);
    AppMethodBeat.o(222986);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     c.t.m.sapp.c.j
 * JD-Core Version:    0.7.0.1
 */