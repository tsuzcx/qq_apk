package com.tencent.mm.plugin.image;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.b.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class d
  implements b, c
{
  private static d JFe;
  
  public static String bzL()
  {
    AppMethodBeat.i(151494);
    Object localObject = new StringBuilder();
    h.baF();
    localObject = h.baE().mCJ + "image/";
    AppMethodBeat.o(151494);
    return localObject;
  }
  
  public static String bzM()
  {
    AppMethodBeat.i(151495);
    Object localObject = new StringBuilder();
    h.baF();
    localObject = h.baE().mCJ + "image2/";
    AppMethodBeat.o(151495);
    return localObject;
  }
  
  public static d fQC()
  {
    try
    {
      AppMethodBeat.i(151492);
      if (JFe == null) {
        JFe = new d();
      }
      d locald = JFe;
      AppMethodBeat.o(151492);
      return locald;
    }
    finally {}
  }
  
  public static String fQD()
  {
    AppMethodBeat.i(151496);
    AppMethodBeat.o(151496);
    return "wcf://bizimg/";
  }
  
  public final List<String> baM()
  {
    AppMethodBeat.i(151493);
    LinkedList localLinkedList = new LinkedList();
    Collections.addAll(localLinkedList, new String[] { "image/", "image2/", "bizimg/", "webcanvascache/" });
    AppMethodBeat.o(151493);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.image.d
 * JD-Core Version:    0.7.0.1
 */