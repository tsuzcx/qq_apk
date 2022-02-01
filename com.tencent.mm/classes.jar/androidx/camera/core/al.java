package androidx.camera.core;

import android.os.Build.VERSION;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class al
{
  private static int Il = 3;
  
  public static boolean N(String paramString)
  {
    AppMethodBeat.i(198245);
    boolean bool = h(V(paramString), 3);
    AppMethodBeat.o(198245);
    return bool;
  }
  
  public static void O(String paramString)
  {
    AppMethodBeat.i(198250);
    h(V(paramString), 3);
    AppMethodBeat.o(198250);
  }
  
  public static void P(String paramString)
  {
    AppMethodBeat.i(198255);
    h(V(paramString), 3);
    AppMethodBeat.o(198255);
  }
  
  public static void Q(String paramString)
  {
    AppMethodBeat.i(198260);
    h(V(paramString), 4);
    AppMethodBeat.o(198260);
  }
  
  public static void R(String paramString)
  {
    AppMethodBeat.i(198263);
    h(V(paramString), 5);
    AppMethodBeat.o(198263);
  }
  
  public static void S(String paramString)
  {
    AppMethodBeat.i(198268);
    h(V(paramString), 5);
    AppMethodBeat.o(198268);
  }
  
  public static void T(String paramString)
  {
    AppMethodBeat.i(198271);
    h(V(paramString), 6);
    AppMethodBeat.o(198271);
  }
  
  public static void U(String paramString)
  {
    AppMethodBeat.i(198274);
    h(V(paramString), 6);
    AppMethodBeat.o(198274);
  }
  
  private static String V(String paramString)
  {
    AppMethodBeat.i(198276);
    if ((Build.VERSION.SDK_INT < 24) && (23 < paramString.length()))
    {
      paramString = paramString.substring(0, 23);
      AppMethodBeat.o(198276);
      return paramString;
    }
    AppMethodBeat.o(198276);
    return paramString;
  }
  
  static void aT(int paramInt)
  {
    Il = paramInt;
  }
  
  private static boolean h(String paramString, int paramInt)
  {
    AppMethodBeat.i(198237);
    if ((Il <= paramInt) || (Log.isLoggable(paramString, paramInt)))
    {
      AppMethodBeat.o(198237);
      return true;
    }
    AppMethodBeat.o(198237);
    return false;
  }
  
  static void jg()
  {
    Il = 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.camera.core.al
 * JD-Core Version:    0.7.0.1
 */