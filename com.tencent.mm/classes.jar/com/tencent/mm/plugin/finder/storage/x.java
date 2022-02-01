package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.b;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.e;
import junit.framework.Assert;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FinderMessageStorage;", "Lcom/tencent/mm/storage/AbstractMessageStorage;", "storage", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IMsgInfoStorage;", "(Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IMsgInfoStorage;)V", "recognizeTableByTalker", "", "talker", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class x
  extends e
{
  public static final x.a FLI;
  
  static
  {
    AppMethodBeat.i(339222);
    FLI = new x.a((byte)0);
    AppMethodBeat.o(339222);
  }
  
  public x(i parami)
  {
    super(parami);
    AppMethodBeat.i(339218);
    e(getDB(), "findermessage006");
    a(new i.b(512, "findermessage006", i.b.d(4000001L, 4500000L, 108000001L, 208000000L)));
    AppMethodBeat.o(339218);
  }
  
  public final String aAD(String paramString)
  {
    AppMethodBeat.i(339230);
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
      if (!au.aAy(paramString)) {
        break label59;
      }
      AppMethodBeat.o(339230);
      return "findermessage006";
      i = 0;
      break;
    }
    label59:
    AppMethodBeat.o(339230);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.x
 * JD-Core Version:    0.7.0.1
 */