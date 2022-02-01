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
  private static d szc;
  
  public static String apW()
  {
    AppMethodBeat.i(151494);
    Object localObject = new StringBuilder();
    g.afC();
    localObject = g.afB().gcW + "image/";
    AppMethodBeat.o(151494);
    return localObject;
  }
  
  public static String apX()
  {
    AppMethodBeat.i(151495);
    Object localObject = new StringBuilder();
    g.afC();
    localObject = g.afB().gcW + "image2/";
    AppMethodBeat.o(151495);
    return localObject;
  }
  
  public static d cGw()
  {
    try
    {
      AppMethodBeat.i(151492);
      if (szc == null) {
        szc = new d();
      }
      d locald = szc;
      AppMethodBeat.o(151492);
      return locald;
    }
    finally {}
  }
  
  public static String cGx()
  {
    AppMethodBeat.i(151496);
    AppMethodBeat.o(151496);
    return "wcf://bizimg/";
  }
  
  public final List<String> afI()
  {
    AppMethodBeat.i(151493);
    LinkedList localLinkedList = new LinkedList();
    Collections.addAll(localLinkedList, new String[] { "image/", "image2/", "bizimg/" });
    AppMethodBeat.o(151493);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.image.d
 * JD-Core Version:    0.7.0.1
 */