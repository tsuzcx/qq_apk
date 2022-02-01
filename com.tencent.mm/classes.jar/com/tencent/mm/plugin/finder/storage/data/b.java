package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.d;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.protocal.protobuf.axc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/data/FansContactPage;", "Lcom/tencent/mm/platformtools/BaseProtoPage;", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", "filename", "", "(Ljava/lang/String;)V", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends d<axc>
{
  public static final a FMJ;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(167044);
    FMJ = new a((byte)0);
    TAG = "Finder.FansContactPage";
    AppMethodBeat.o(167044);
  }
  
  public b(String paramString)
  {
    AppMethodBeat.i(167043);
    av localav = av.GiL;
    super.RY(s.X(av.Ub(3), paramString));
    AppMethodBeat.o(167043);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/data/FansContactPage$Companion;", "", "()V", "TAG", "", "clearAll", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void clearAll()
    {
      AppMethodBeat.i(167042);
      Log.i(b.access$getTAG$cp(), "clearAll");
      Object localObject = av.GiL;
      localObject = av.Ub(3);
      if (y.ZC((String)localObject)) {
        y.ew((String)localObject, true);
      }
      AppMethodBeat.o(167042);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.b
 * JD-Core Version:    0.7.0.1
 */