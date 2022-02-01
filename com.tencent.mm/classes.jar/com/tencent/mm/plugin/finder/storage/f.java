package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aht;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/storage/FinderExptUtil;", "", "()V", "fillExptFlag", "", "finderBaseReq", "Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;", "EXPT_FLAG", "plugin-finder_release"})
public final class f
{
  public static final f KWr;
  
  static
  {
    AppMethodBeat.i(198972);
    KWr = new f();
    AppMethodBeat.o(198972);
  }
  
  public static void a(aht paramaht)
  {
    AppMethodBeat.i(198971);
    k.h(paramaht, "finderBaseReq");
    paramaht.Lxk = 0;
    Object localObject = b.qJA;
    if (b.fUr())
    {
      int i = paramaht.Lxk;
      localObject = f.a.KWt;
      paramaht.Lxk = (i | f.a.fUP());
    }
    AppMethodBeat.o(198971);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.f
 * JD-Core Version:    0.7.0.1
 */