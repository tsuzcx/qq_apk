package com.tencent.mm.plugin.lite.a.b.a;

import com.tencent.liteapp.jsapi.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public class g
{
  public static g JZT;
  a JZU;
  HashMap<Integer, b> JZV;
  public f JZW;
  
  private g()
  {
    AppMethodBeat.i(271556);
    this.JZU = new a();
    this.JZV = new HashMap();
    this.JZW = new f();
    AppMethodBeat.o(271556);
  }
  
  public static g fTY()
  {
    AppMethodBeat.i(271566);
    if (JZT == null) {}
    try
    {
      JZT = new g();
      g localg = JZT;
      AppMethodBeat.o(271566);
      return localg;
    }
    finally
    {
      AppMethodBeat.o(271566);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.a.b.a.g
 * JD-Core Version:    0.7.0.1
 */