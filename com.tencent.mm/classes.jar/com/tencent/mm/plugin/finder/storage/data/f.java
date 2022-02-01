package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.d;
import com.tencent.mm.plugin.finder.utils.n;
import com.tencent.mm.protocal.protobuf.FinderContact;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/storage/data/FinderContactPage;", "Lcom/tencent/mm/platformtools/BaseProtoPage;", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "filename", "", "(Ljava/lang/String;)V", "Companion", "plugin-finder_release"})
public final class f
  extends d<FinderContact>
{
  private static final String TAG = "Finder.FinderContactPage";
  public static final f.a rEK;
  
  static
  {
    AppMethodBeat.i(167062);
    rEK = new f.a((byte)0);
    TAG = "Finder.FinderContactPage";
    AppMethodBeat.o(167062);
  }
  
  public f(String paramString)
  {
    AppMethodBeat.i(167061);
    StringBuilder localStringBuilder = new StringBuilder();
    n localn = n.rPN;
    super.Fu(n.EA(1) + paramString);
    AppMethodBeat.o(167061);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.f
 * JD-Core Version:    0.7.0.1
 */