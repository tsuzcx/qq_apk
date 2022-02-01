package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.b;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

final class c$3
  implements b
{
  c$3(c paramc) {}
  
  public final List<String> agY()
  {
    AppMethodBeat.i(20243);
    LinkedList localLinkedList = new LinkedList();
    Collections.addAll(localLinkedList, new String[] { "image/shakeTranImg/", "emoji/", "mailapp/", "favoffline/", "voice2/", "video/", "attachment/" });
    AppMethodBeat.o(20243);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.c.3
 * JD-Core Version:    0.7.0.1
 */