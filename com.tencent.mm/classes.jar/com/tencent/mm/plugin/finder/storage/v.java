package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.b;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.e;
import junit.framework.Assert;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/FinderMessageStorage;", "Lcom/tencent/mm/storage/AbstractMessageStorage;", "storage", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IMsgInfoStorage;", "(Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IMsgInfoStorage;)V", "recognizeTableByTalker", "", "talker", "Companion", "plugin-finder_release"})
public final class v
  extends e
{
  public static final v.a AlS;
  
  static
  {
    AppMethodBeat.i(287358);
    AlS = new v.a((byte)0);
    AppMethodBeat.o(287358);
  }
  
  public v(i parami)
  {
    super(parami);
    AppMethodBeat.i(287357);
    e(getDB(), "findermessage006");
    a(new i.b(512, "findermessage006", i.b.b(4000001L, 4500000L, 108000001L, 208000000L)));
    AppMethodBeat.o(287357);
  }
  
  public final String aEK(String paramString)
  {
    AppMethodBeat.i(287355);
    int i;
    if (paramString != null) {
      if (((CharSequence)paramString).length() > 0)
      {
        i = 1;
        if (i != 1) {
          break label54;
        }
      }
    }
    label54:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (!as.aEF(paramString)) {
        break label59;
      }
      AppMethodBeat.o(287355);
      return "findermessage006";
      i = 0;
      break;
    }
    label59:
    AppMethodBeat.o(287355);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.v
 * JD-Core Version:    0.7.0.1
 */