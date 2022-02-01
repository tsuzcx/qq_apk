package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.d;
import com.tencent.mm.plugin.finder.utils.p;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.o;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/storage/data/FinderContactPage;", "Lcom/tencent/mm/platformtools/BaseProtoPage;", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "filename", "", "(Ljava/lang/String;)V", "Companion", "plugin-finder_release"})
public final class f
  extends d<FinderContact>
{
  private static final String TAG = "Finder.FinderContactPage";
  public static final a sKL;
  
  static
  {
    AppMethodBeat.i(167062);
    sKL = new a((byte)0);
    TAG = "Finder.FinderContactPage";
    AppMethodBeat.o(167062);
  }
  
  public f(String paramString)
  {
    AppMethodBeat.i(167061);
    StringBuilder localStringBuilder = new StringBuilder();
    p localp = p.sXz;
    super.Jj(p.Gi(1) + paramString);
    AppMethodBeat.o(167061);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/storage/data/FinderContactPage$Companion;", "", "()V", "TAG", "", "clearAll", "", "plugin-finder_release"})
  public static final class a
  {
    public static void clearAll()
    {
      AppMethodBeat.i(167060);
      ae.i(f.access$getTAG$cp(), "clearAll");
      Object localObject = p.sXz;
      localObject = p.Gi(1);
      if (o.fB((String)localObject)) {
        o.dd((String)localObject, true);
      }
      AppMethodBeat.o(167060);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.f
 * JD-Core Version:    0.7.0.1
 */