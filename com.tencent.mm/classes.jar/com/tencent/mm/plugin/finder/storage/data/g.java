package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.d;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/data/FinderContactPage;", "Lcom/tencent/mm/platformtools/BaseProtoPage;", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "filename", "", "(Ljava/lang/String;)V", "Companion", "plugin-finder_release"})
public final class g
  extends d<FinderContact>
{
  private static final String TAG = "Finder.FinderContactPage";
  public static final a vGf;
  
  static
  {
    AppMethodBeat.i(167062);
    vGf = new a((byte)0);
    TAG = "Finder.FinderContactPage";
    AppMethodBeat.o(167062);
  }
  
  public g(String paramString)
  {
    AppMethodBeat.i(167061);
    StringBuilder localStringBuilder = new StringBuilder();
    y localy = y.vXH;
    super.Sg(y.LA(1) + paramString);
    AppMethodBeat.o(167061);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/data/FinderContactPage$Companion;", "", "()V", "TAG", "", "clearAll", "", "plugin-finder_release"})
  public static final class a
  {
    public static void clearAll()
    {
      AppMethodBeat.i(167060);
      Log.i(g.access$getTAG$cp(), "clearAll");
      Object localObject = y.vXH;
      localObject = y.LA(1);
      if (s.YS((String)localObject)) {
        s.dy((String)localObject, true);
      }
      AppMethodBeat.o(167060);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.g
 * JD-Core Version:    0.7.0.1
 */