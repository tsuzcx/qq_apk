package com.tencent.mm.d.a;

import android.util.SparseArray;
import com.eclipsesource.v8.JavaCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Context;
import com.eclipsesource.v8.V8Function;
import com.eclipsesource.v8.V8Object;
import com.eclipsesource.v8.utils.V8ObjectUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

final class r$2
  implements JavaCallback
{
  r$2(r paramr, l paraml) {}
  
  public final Object invoke(V8Object paramV8Object, V8Array paramV8Array)
  {
    AppMethodBeat.i(113871);
    if ((paramV8Array.length() < 2) || (paramV8Array.getType(0) != 7))
    {
      ab.w("MicroMsg.J2V8.V8DirectApiTimer", "setInterval parameters invalid length:%d type[0]:%d", new Object[] { Integer.valueOf(paramV8Array.length()), Integer.valueOf(paramV8Array.getType(0)) });
      AppMethodBeat.o(113871);
      return null;
    }
    V8Function localV8Function = (V8Function)paramV8Array.getObject(0);
    int i;
    label126:
    l locall;
    if (paramV8Array.getType(1) == 1)
    {
      i = paramV8Array.getInteger(1);
      if (paramV8Array.length() <= 2) {
        break label294;
      }
      paramV8Object = V8ObjectUtils.toList(paramV8Array);
      paramV8Object = V8ObjectUtils.toV8Array(this.cbY.Cu(), paramV8Object.subList(2, paramV8Object.size() - 1));
      paramV8Array = this.cch;
      locall = this.cbY;
      paramV8Array.ccd += 1;
      if (!(locall.cbC instanceof b)) {
        break label310;
      }
    }
    label294:
    label310:
    for (paramV8Object = new r.c(paramV8Array, locall, paramV8Array.ccd, localV8Function, paramV8Object, true, i);; paramV8Object = new r.a(paramV8Array, locall, paramV8Array.ccd, localV8Function, paramV8Object, true, i))
    {
      paramV8Object.schedule();
      paramV8Array.cce.put(paramV8Array.ccd, paramV8Object);
      i = paramV8Array.ccd;
      AppMethodBeat.o(113871);
      return Integer.valueOf(i);
      if (paramV8Array.getType(1) == 2)
      {
        i = (int)paramV8Array.getDouble(1);
        break;
      }
      if (paramV8Array.getType(1) == 4)
      {
        int j = r.dP(paramV8Array.getString(1));
        i = j;
        if (j != -2147483648) {
          break;
        }
        AppMethodBeat.o(113871);
        return null;
      }
      ab.w("MicroMsg.J2V8.V8DirectApiTimer", "setInterval parameters[1] type:%d", new Object[] { Integer.valueOf(paramV8Array.getType(1)) });
      AppMethodBeat.o(113871);
      return null;
      paramV8Object = this.cbY.Cu().newV8Array();
      break label126;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.d.a.r.2
 * JD-Core Version:    0.7.0.1
 */