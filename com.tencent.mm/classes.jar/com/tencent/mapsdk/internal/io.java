package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class io
  extends it
{
  int b;
  
  private io(ib paramib)
  {
    super(paramib);
  }
  
  private io(ib paramib, int paramInt)
  {
    super(paramib);
    AppMethodBeat.i(223170);
    if (this.k != null)
    {
      paramib = this.k[0];
      int i = paramib.a;
      this.l.remove(Integer.valueOf(i));
      this.l.put(Integer.valueOf(paramInt), paramib);
    }
    this.b = paramInt;
    AppMethodBeat.o(223170);
  }
  
  public static io a(ib paramib, int paramInt, double... paramVarArgs)
  {
    AppMethodBeat.i(223190);
    paramib = new io(paramib, paramInt);
    paramib.a(paramVarArgs);
    AppMethodBeat.o(223190);
    return paramib;
  }
  
  public static io a(ib paramib, is paramis, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(223198);
    paramib = new io(paramib, 1);
    paramib.a(paramArrayOfObject);
    paramib.a(paramis);
    AppMethodBeat.o(223198);
    return paramib;
  }
  
  public static io a(ib paramib, int... paramVarArgs)
  {
    AppMethodBeat.i(223180);
    paramib = new io(paramib, 0);
    paramib.a(paramVarArgs);
    AppMethodBeat.o(223180);
    return paramib;
  }
  
  private static io a(ib paramib, ip... paramVarArgs)
  {
    AppMethodBeat.i(223207);
    paramib = new io(paramib);
    paramib.a(paramVarArgs);
    AppMethodBeat.o(223207);
    return paramib;
  }
  
  private void a(int paramInt)
  {
    AppMethodBeat.i(223154);
    if (this.k != null)
    {
      ip localip = this.k[0];
      int i = localip.a;
      this.l.remove(Integer.valueOf(i));
      this.l.put(Integer.valueOf(paramInt), localip);
    }
    this.b = paramInt;
    AppMethodBeat.o(223154);
  }
  
  private io e(long paramLong)
  {
    AppMethodBeat.i(223215);
    super.b(paramLong);
    AppMethodBeat.o(223215);
    return this;
  }
  
  private int o()
  {
    return this.b;
  }
  
  private ib p()
  {
    return this.m;
  }
  
  private io q()
  {
    AppMethodBeat.i(223232);
    io localio = (io)super.h();
    AppMethodBeat.o(223232);
    return localio;
  }
  
  public final void a(double... paramVarArgs)
  {
    AppMethodBeat.i(223253);
    if ((this.k == null) || (this.k.length == 0))
    {
      a(new ip[] { ip.a(this.b, paramVarArgs) });
      AppMethodBeat.o(223253);
      return;
    }
    super.a(paramVarArgs);
    AppMethodBeat.o(223253);
  }
  
  public final void a(int... paramVarArgs)
  {
    AppMethodBeat.i(223243);
    if ((this.k == null) || (this.k.length == 0))
    {
      a(new ip[] { ip.a(this.b, paramVarArgs) });
      AppMethodBeat.o(223243);
      return;
    }
    super.a(paramVarArgs);
    AppMethodBeat.o(223243);
  }
  
  public final void a(Object... paramVarArgs)
  {
    AppMethodBeat.i(223265);
    if ((this.k == null) || (this.k.length == 0))
    {
      a(new ip[] { ip.a(this.b, paramVarArgs) });
      AppMethodBeat.o(223265);
      return;
    }
    super.a(paramVarArgs);
    AppMethodBeat.o(223265);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(223274);
    String str1 = "ObjectAnimator@" + Integer.toHexString(hashCode()) + ", target " + this.m;
    String str2 = str1;
    if (this.k != null)
    {
      int i = 0;
      for (;;)
      {
        str2 = str1;
        if (i >= this.k.length) {
          break;
        }
        str1 = str1 + "\n    " + this.k[i].toString();
        i += 1;
      }
    }
    AppMethodBeat.o(223274);
    return str2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.io
 * JD-Core Version:    0.7.0.1
 */