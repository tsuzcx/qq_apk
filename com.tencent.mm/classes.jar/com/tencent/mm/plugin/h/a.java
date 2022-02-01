package com.tencent.mm.plugin.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.v;
import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.y;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends y
  implements b
{
  private static a qEZ;
  
  private a()
  {
    super(v.class);
  }
  
  public static String aTf()
  {
    AppMethodBeat.i(151486);
    Object localObject = new StringBuilder();
    g.aAi();
    localObject = g.aAh().hqG + "package/";
    AppMethodBeat.o(151486);
    return localObject;
  }
  
  public static a cBk()
  {
    try
    {
      AppMethodBeat.i(151484);
      if (qEZ == null) {
        qEZ = new a();
      }
      a locala = qEZ;
      AppMethodBeat.o(151484);
      return locala;
    }
    finally {}
  }
  
  public final List<String> aAo()
  {
    AppMethodBeat.i(151485);
    LinkedList localLinkedList = new LinkedList();
    Collections.addAll(localLinkedList, new String[] { "package/" });
    AppMethodBeat.o(151485);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.h.a
 * JD-Core Version:    0.7.0.1
 */