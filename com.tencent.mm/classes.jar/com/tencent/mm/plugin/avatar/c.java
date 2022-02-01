package com.tencent.mm.plugin.avatar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.y;
import com.tencent.mm.modelavatar.q;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends y
  implements b
{
  private static c uVM;
  
  private c()
  {
    super(q.class);
  }
  
  public static c cUB()
  {
    try
    {
      AppMethodBeat.i(151426);
      if (uVM == null) {
        uVM = new c();
      }
      c localc = uVM;
      AppMethodBeat.o(151426);
      return localc;
    }
    finally {}
  }
  
  public static String cUC()
  {
    AppMethodBeat.i(151428);
    String str = h.baE().cachePath + "avatar/";
    AppMethodBeat.o(151428);
    return str;
  }
  
  public final List<String> baM()
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