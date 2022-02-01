package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.d;
import com.tencent.mm.protocal.protobuf.aii;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/storage/data/FansContactPage;", "Lcom/tencent/mm/platformtools/BaseProtoPage;", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", "filename", "", "(Ljava/lang/String;)V", "Companion", "plugin-finder_release"})
public final class a
  extends d<aii>
{
  private static final String TAG = "Finder.FansContactPage";
  public static final a qKk;
  
  static
  {
    AppMethodBeat.i(167044);
    qKk = new a((byte)0);
    TAG = "Finder.FansContactPage";
    AppMethodBeat.o(167044);
  }
  
  public a(String paramString)
  {
    AppMethodBeat.i(167043);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.plugin.finder.utils.i locali = com.tencent.mm.plugin.finder.utils.i.qTa;
    super.Bq(com.tencent.mm.plugin.finder.utils.i.Dh(3) + paramString);
    AppMethodBeat.o(167043);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/storage/data/FansContactPage$Companion;", "", "()V", "TAG", "", "clearAll", "", "plugin-finder_release"})
  public static final class a
  {
    public static void clearAll()
    {
      AppMethodBeat.i(167042);
      ad.i(a.access$getTAG$cp(), "clearAll");
      Object localObject = com.tencent.mm.plugin.finder.utils.i.qTa;
      localObject = com.tencent.mm.plugin.finder.utils.i.Dh(3);
      if (com.tencent.mm.vfs.i.eK((String)localObject)) {
        com.tencent.mm.vfs.i.cO((String)localObject, true);
      }
      AppMethodBeat.o(167042);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.a
 * JD-Core Version:    0.7.0.1
 */