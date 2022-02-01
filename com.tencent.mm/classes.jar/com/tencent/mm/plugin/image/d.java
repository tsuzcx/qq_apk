package com.tencent.mm.plugin.image;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.b.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class d
  implements b, c
{
  private static d ynN;
  
  public static String aSY()
  {
    AppMethodBeat.i(151494);
    Object localObject = new StringBuilder();
    g.aAi();
    localObject = g.aAh().hqG + "image/";
    AppMethodBeat.o(151494);
    return localObject;
  }
  
  public static String aSZ()
  {
    AppMethodBeat.i(151495);
    Object localObject = new StringBuilder();
    g.aAi();
    localObject = g.aAh().hqG + "image2/";
    AppMethodBeat.o(151495);
    return localObject;
  }
  
  public static d dZE()
  {
    try
    {
      AppMethodBeat.i(151492);
      if (ynN == null) {
        ynN = new d();
      }
      d locald = ynN;
      AppMethodBeat.o(151492);
      return locald;
    }
    finally {}
  }
  
  public static String dZF()
  {
    AppMethodBeat.i(151496);
    AppMethodBeat.o(151496);
    return "wcf://bizimg/";
  }
  
  public final List<String> aAo()
  {
    AppMethodBeat.i(151493);
    LinkedList localLinkedList = new LinkedList();
    Collections.addAll(localLinkedList, new String[] { "image/", "image2/", "bizimg/", "webcanvascache/" });
    AppMethodBeat.o(151493);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.image.d
 * JD-Core Version:    0.7.0.1
 */