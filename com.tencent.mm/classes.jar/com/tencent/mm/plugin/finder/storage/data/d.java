package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/storage/data/FinderContactPage;", "Lcom/tencent/mm/platformtools/BaseProtoPage;", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "filename", "", "(Ljava/lang/String;)V", "Companion", "plugin-finder_release"})
public final class d
  extends com.tencent.mm.platformtools.d<FinderContact>
{
  private static final String TAG = "Finder.FinderContactPage";
  public static final a qKq;
  
  static
  {
    AppMethodBeat.i(167062);
    qKq = new a((byte)0);
    TAG = "Finder.FinderContactPage";
    AppMethodBeat.o(167062);
  }
  
  public d(String paramString)
  {
    AppMethodBeat.i(167061);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.plugin.finder.utils.i locali = com.tencent.mm.plugin.finder.utils.i.qTa;
    super.Bq(com.tencent.mm.plugin.finder.utils.i.Dh(1) + paramString);
    AppMethodBeat.o(167061);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/storage/data/FinderContactPage$Companion;", "", "()V", "TAG", "", "clearAll", "", "plugin-finder_release"})
  public static final class a
  {
    public static void clearAll()
    {
      AppMethodBeat.i(167060);
      ad.i(d.access$getTAG$cp(), "clearAll");
      Object localObject = com.tencent.mm.plugin.finder.utils.i.qTa;
      localObject = com.tencent.mm.plugin.finder.utils.i.Dh(1);
      if (com.tencent.mm.vfs.i.eK((String)localObject)) {
        com.tencent.mm.vfs.i.cO((String)localObject, true);
      }
      AppMethodBeat.o(167060);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.d
 * JD-Core Version:    0.7.0.1
 */