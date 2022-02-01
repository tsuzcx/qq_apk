package com.tencent.mm.plugin.avatar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.p;
import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.y;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends y
  implements b
{
  private static c oII;
  
  private c()
  {
    super(p.class);
  }
  
  public static c ceE()
  {
    try
    {
      AppMethodBeat.i(151426);
      if (oII == null) {
        oII = new c();
      }
      c localc = oII;
      AppMethodBeat.o(151426);
      return localc;
    }
    finally {}
  }
  
  public static String ceF()
  {
    AppMethodBeat.i(151428);
    String str = g.aAh().cachePath + "avatar/";
    AppMethodBeat.o(151428);
    return str;
  }
  
  public final List<String> aAo()
  {
    AppMethodBeat.i(151427);
    LinkedList localLinkedList = new LinkedList();
    Collections.addAll(localLinkedList, new String[] { "avatar/" });
    AppMethodBeat.o(151427);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.avatar.c
 * JD-Core Version:    0.7.0.1
 */