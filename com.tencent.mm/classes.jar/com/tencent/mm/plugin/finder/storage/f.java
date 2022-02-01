package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.finder.spam.a;
import com.tencent.mm.protocal.protobuf.alk;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/FinderExptUtil;", "", "()V", "TAG", "", "fillExptFlag", "", "finderBaseReq", "Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;", "showFinderEntry", "", "EXPT_FLAG", "plugin-finder_release"})
public final class f
{
  public static final f sxF;
  
  static
  {
    AppMethodBeat.i(203656);
    sxF = new f();
    AppMethodBeat.o(203656);
  }
  
  public static void a(alk paramalk)
  {
    int i = 0;
    AppMethodBeat.i(203655);
    p.h(paramalk, "finderBaseReq");
    paramalk.Glk = 0;
    Object localObject = b.sxa;
    int j;
    if (((Number)b.cGL().value()).intValue() == 1)
    {
      j = paramalk.Glk;
      localObject = a.sxI;
      paramalk.Glk = (j | a.cIo());
    }
    boolean bool1;
    if (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qzG, 0) != 0)
    {
      bool1 = true;
      localObject = a.suA;
      j = a.ain("entrance");
      if (j == 2)
      {
        ad.i("Finder.ExptUtil", "showFinderEntry ".concat(String.valueOf(j)));
        bool1 = false;
      }
      localObject = b.sxa;
      if (b.cFI() == 0) {
        break label261;
      }
    }
    label261:
    for (boolean bool2 = true;; bool2 = false)
    {
      ad.i("Finder.ExptUtil", "showFinder %s %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((bool1) || (bool2)) {
        i = 1;
      }
      if (i != 0)
      {
        i = paramalk.Glk;
        localObject = a.sxI;
        paramalk.Glk = (i | a.cIp());
      }
      localObject = b.sxa;
      if (((Number)b.eQq().value()).intValue() == 1)
      {
        i = paramalk.Glk;
        localObject = a.sxI;
        paramalk.Glk = (i | a.eQr());
      }
      ad.i("Finder.ExptUtil", "[fillExptFlag] exptFlag=" + paramalk.Glk);
      AppMethodBeat.o(203655);
      return;
      bool1 = false;
      break;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/FinderExptUtil$EXPT_FLAG;", "", "()V", "FINDER_COMMENT_EXPOSE", "", "getFINDER_COMMENT_EXPOSE", "()I", "HAS_FINDER_ENTRANCE", "getHAS_FINDER_ENTRANCE", "REAL_NAME_LIKE", "getREAL_NAME_LIKE", "plugin-finder_release"})
  static final class a
  {
    private static final int Odh = 4;
    private static final int sxG = 1;
    private static final int sxH = 2;
    public static final a sxI;
    
    static
    {
      AppMethodBeat.i(203654);
      sxI = new a();
      sxG = 1;
      sxH = 2;
      Odh = 4;
      AppMethodBeat.o(203654);
    }
    
    public static int cIo()
    {
      return sxG;
    }
    
    public static int cIp()
    {
      return sxH;
    }
    
    public static int eQr()
    {
      return Odh;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.f
 * JD-Core Version:    0.7.0.1
 */