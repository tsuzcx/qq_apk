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
  private static d tGM;
  
  public static String awL()
  {
    AppMethodBeat.i(151494);
    Object localObject = new StringBuilder();
    g.agS();
    localObject = g.agR().ghC + "image/";
    AppMethodBeat.o(151494);
    return localObject;
  }
  
  public static String awM()
  {
    AppMethodBeat.i(151495);
    Object localObject = new StringBuilder();
    g.agS();
    localObject = g.agR().ghC + "image2/";
    AppMethodBeat.o(151495);
    return localObject;
  }
  
  public static d cTG()
  {
    try
    {
      AppMethodBeat.i(151492);
      if (tGM == null) {
        tGM = new d();
      }
      d locald = tGM;
      AppMethodBeat.o(151492);
      return locald;
    }
    finally {}
  }
  
  public static String cTH()
  {
    AppMethodBeat.i(151496);
    AppMethodBeat.o(151496);
    return "wcf://bizimg/";
  }
  
  public final List<String> agY()
  {
    AppMethodBeat.i(151493);
    LinkedList localLinkedList = new LinkedList();
    Collections.addAll(localLinkedList, new String[] { "image/", "image2/", "bizimg/" });
    AppMethodBeat.o(151493);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.image.d
 * JD-Core Version:    0.7.0.1
 */