package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aiu;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/storage/FinderExptUtil;", "", "()V", "fillExptFlag", "", "finderBaseReq", "Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;", "EXPT_FLAG", "plugin-finder_release"})
public final class d
{
  public static final d rDa;
  
  static
  {
    AppMethodBeat.i(202935);
    rDa = new d();
    AppMethodBeat.o(202935);
  }
  
  public static void a(aiu paramaiu)
  {
    AppMethodBeat.i(202934);
    k.h(paramaiu, "finderBaseReq");
    paramaiu.EDA = 0;
    Object localObject = b.rCU;
    if (b.czO())
    {
      int i = paramaiu.EDA;
      localObject = a.rDc;
      paramaiu.EDA = (i | a.cAu());
    }
    AppMethodBeat.o(202934);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/storage/FinderExptUtil$EXPT_FLAG;", "", "()V", "REAL_NAME_LIKE", "", "getREAL_NAME_LIKE", "()I", "plugin-finder_release"})
  static final class a
  {
    private static final int rDb = 1;
    public static final a rDc;
    
    static
    {
      AppMethodBeat.i(202933);
      rDc = new a();
      rDb = 1;
      AppMethodBeat.o(202933);
    }
    
    public static int cAu()
    {
      return rDb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.d
 * JD-Core Version:    0.7.0.1
 */