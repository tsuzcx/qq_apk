package com.tencent.mm.platformtools;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Vector;

public final class x
{
  private static Vector<WeakReference<x.a>> gjA;
  private static LinkedList<x.a> gjB;
  
  static
  {
    AppMethodBeat.i(79041);
    gjA = new Vector();
    gjB = new LinkedList();
    AppMethodBeat.o(79041);
  }
  
  public static Bitmap a(v paramv)
  {
    AppMethodBeat.i(79034);
    if (!b(paramv))
    {
      AppMethodBeat.o(79034);
      return null;
    }
    if (!g.RL().Rx())
    {
      paramv = paramv.aos();
      AppMethodBeat.o(79034);
      return paramv;
    }
    if (paramv.aor())
    {
      paramv = x.b.a(x.b.gjC, paramv);
      AppMethodBeat.o(79034);
      return paramv;
    }
    paramv = x.b.b(x.b.gjC, paramv);
    AppMethodBeat.o(79034);
    return paramv;
  }
  
  public static boolean a(x.a parama)
  {
    AppMethodBeat.i(79031);
    boolean bool = gjA.add(new WeakReference(parama));
    AppMethodBeat.o(79031);
    return bool;
  }
  
  private static boolean b(v paramv)
  {
    AppMethodBeat.i(79038);
    if ((paramv == null) || (bo.isNullOrNil(paramv.aoo())))
    {
      AppMethodBeat.o(79038);
      return false;
    }
    AppMethodBeat.o(79038);
    return true;
  }
  
  public static boolean b(x.a parama)
  {
    AppMethodBeat.i(79032);
    gjB.remove(parama);
    boolean bool = gjB.add(parama);
    AppMethodBeat.o(79032);
    return bool;
  }
  
  public static boolean c(x.a parama)
  {
    AppMethodBeat.i(79033);
    boolean bool = gjB.remove(parama);
    AppMethodBeat.o(79033);
    return bool;
  }
  
  public static Bitmap wx(String paramString)
  {
    AppMethodBeat.i(79035);
    paramString = x.b.wx(paramString);
    AppMethodBeat.o(79035);
    return paramString;
  }
  
  public static Bitmap wy(String paramString)
  {
    AppMethodBeat.i(79037);
    paramString = x.b.wy(paramString);
    AppMethodBeat.o(79037);
    return paramString;
  }
  
  public static Bitmap y(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(79036);
    paramString = x.b.y(paramString, paramInt1, paramInt2);
    AppMethodBeat.o(79036);
    return paramString;
  }
  
  static final class b$c
  {
    boolean gjL;
    int gjM;
    int gjN;
    
    public final String toString()
    {
      AppMethodBeat.i(79015);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fail[").append(this.gjL).append("],");
      ((StringBuilder)localObject).append("tryTimes[").append(this.gjM).append("],");
      ((StringBuilder)localObject).append("lastTS[").append(this.gjN).append("]");
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(79015);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.platformtools.x
 * JD-Core Version:    0.7.0.1
 */