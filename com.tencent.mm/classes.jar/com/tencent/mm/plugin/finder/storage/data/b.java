package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.d;
import com.tencent.mm.plugin.finder.utils.p;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.o;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/storage/data/FansContactPage;", "Lcom/tencent/mm/platformtools/BaseProtoPage;", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", "filename", "", "(Ljava/lang/String;)V", "Companion", "plugin-finder_release"})
public final class b
  extends d<anb>
{
  private static final String TAG = "Finder.FansContactPage";
  public static final a sKy;
  
  static
  {
    AppMethodBeat.i(167044);
    sKy = new a((byte)0);
    TAG = "Finder.FansContactPage";
    AppMethodBeat.o(167044);
  }
  
  public b(String paramString)
  {
    AppMethodBeat.i(167043);
    StringBuilder localStringBuilder = new StringBuilder();
    p localp = p.sXz;
    super.Jj(p.Gi(3) + paramString);
    AppMethodBeat.o(167043);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/storage/data/FansContactPage$Companion;", "", "()V", "TAG", "", "clearAll", "", "plugin-finder_release"})
  public static final class a
  {
    public static void clearAll()
    {
      AppMethodBeat.i(167042);
      ae.i(b.access$getTAG$cp(), "clearAll");
      Object localObject = p.sXz;
      localObject = p.Gi(3);
      if (o.fB((String)localObject)) {
        o.dd((String)localObject, true);
      }
      AppMethodBeat.o(167042);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.b
 * JD-Core Version:    0.7.0.1
 */