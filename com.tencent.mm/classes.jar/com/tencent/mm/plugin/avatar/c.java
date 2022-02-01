package com.tencent.mm.plugin.avatar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.p;
import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends t
  implements b
{
  private static c mRQ;
  
  private c()
  {
    super(p.class);
  }
  
  public static c bCH()
  {
    try
    {
      AppMethodBeat.i(151426);
      if (mRQ == null) {
        mRQ = new c();
      }
      c localc = mRQ;
      AppMethodBeat.o(151426);
      return localc;
    }
    finally {}
  }
  
  public static String bCI()
  {
    AppMethodBeat.i(151428);
    String str = g.agR().cachePath + "avatar/";
    AppMethodBeat.o(151428);
    return str;
  }
  
  public final List<String> agY()
  {
    AppMethodBeat.i(151427);
    LinkedList localLinkedList = new LinkedList();
    Collections.addAll(localLinkedList, new String[] { "avatar/" });
    AppMethodBeat.o(151427);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.avatar.c
 * JD-Core Version:    0.7.0.1
 */