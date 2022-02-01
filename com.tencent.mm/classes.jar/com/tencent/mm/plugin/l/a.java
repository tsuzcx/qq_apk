package com.tencent.mm.plugin.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.be.w;
import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.y;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends y
  implements b
{
  private static a uea;
  
  private a()
  {
    super(w.class);
  }
  
  public static String bcd()
  {
    AppMethodBeat.i(151486);
    Object localObject = new StringBuilder();
    h.aHH();
    localObject = h.aHG().kcB + "package/";
    AppMethodBeat.o(151486);
    return localObject;
  }
  
  public static a cPO()
  {
    try
    {
      AppMethodBeat.i(151484);
      if (uea == null) {
        uea = new a();
      }
      a locala = uea;
      AppMethodBeat.o(151484);
      return locala;
    }
    finally {}
  }
  
  public final List<String> aHP()
  {
    AppMethodBeat.i(151485);
    LinkedList localLinkedList = new LinkedList();
    Collections.addAll(localLinkedList, new String[] { "package/" });
    AppMethodBeat.o(151485);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.l.a
 * JD-Core Version:    0.7.0.1
 */