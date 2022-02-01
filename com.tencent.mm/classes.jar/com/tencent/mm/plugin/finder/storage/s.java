package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.b;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.e;
import d.l;
import junit.framework.Assert;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/FinderMessageStorage;", "Lcom/tencent/mm/storage/AbstractMessageStorage;", "storage", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IMsgInfoStorage;", "(Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IMsgInfoStorage;)V", "recognizeTableByTalker", "", "talker", "Companion", "plugin-finder_release"})
public final class s
  extends e
{
  public static final a syS;
  
  static
  {
    AppMethodBeat.i(203716);
    syS = new a((byte)0);
    AppMethodBeat.o(203716);
  }
  
  public s(i parami)
  {
    super(parami);
    AppMethodBeat.i(203715);
    d(getDB(), "findermessage006");
    a(new i.b(512, "findermessage006", i.b.a(4000001L, 4500000L, 108000001L, 208000000L)));
    AppMethodBeat.o(203715);
  }
  
  public final String aiu(String paramString)
  {
    AppMethodBeat.i(203714);
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
      if (!am.ail(paramString)) {
        break label59;
      }
      AppMethodBeat.o(203714);
      return "findermessage006";
      i = 0;
      break;
    }
    label59:
    AppMethodBeat.o(203714);
    return null;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/FinderMessageStorage$Companion;", "", "()V", "TABLE_NAME", "", "TAG", "getSqlCreate", "", "table", "(Ljava/lang/String;)[Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.s
 * JD-Core Version:    0.7.0.1
 */