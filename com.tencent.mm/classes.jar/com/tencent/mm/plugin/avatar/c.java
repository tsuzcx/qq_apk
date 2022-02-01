package com.tencent.mm.plugin.avatar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.q;
import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.y;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends y
  implements b
{
  private static c rKy;
  
  private c()
  {
    super(q.class);
  }
  
  public static c crR()
  {
    try
    {
      AppMethodBeat.i(151426);
      if (rKy == null) {
        rKy = new c();
      }
      c localc = rKy;
      AppMethodBeat.o(151426);
      return localc;
    }
    finally {}
  }
  
  public static String crS()
  {
    AppMethodBeat.i(151428);
    String str = h.aHG().cachePath + "avatar/";
    AppMethodBeat.o(151428);
    return str;
  }
  
  public final List<String> aHP()
  {
    AppMethodBeat.i(151427);
    LinkedList localLinkedList = new LinkedList();
    Collections.addAll(localLinkedList, new String[] { "avatar/" });
    AppMethodBeat.o(151427);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.avatar.c
 * JD-Core Version:    0.7.0.1
 */