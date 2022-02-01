package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.finder.spam.a;
import com.tencent.mm.protocal.protobuf.alw;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/storage/FinderExptUtil;", "", "()V", "TAG", "", "fillExptFlag", "", "finderBaseReq", "Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;", "showFinderEntry", "", "EXPT_FLAG", "plugin-finder_release"})
public final class f
{
  public static final f sIv;
  
  static
  {
    AppMethodBeat.i(204222);
    sIv = new f();
    AppMethodBeat.o(204222);
  }
  
  public static void a(alw paramalw)
  {
    int i = 0;
    AppMethodBeat.i(204221);
    p.h(paramalw, "finderBaseReq");
    paramalw.GEm = 0;
    Object localObject = b.sHP;
    int j;
    if (((Number)b.cIJ().value()).intValue() == 1)
    {
      j = paramalw.GEm;
      localObject = a.sIA;
      paramalw.GEm = (j | a.cKR());
    }
    boolean bool1;
    if (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qGN, 0) != 0)
    {
      bool1 = true;
      localObject = a.sEK;
      j = a.ajk("entrance");
      if (j == 2)
      {
        ae.i("Finder.ExptUtil", "showFinderEntry ".concat(String.valueOf(j)));
        bool1 = false;
      }
      localObject = b.sHP;
      if (b.cHF() == 0) {
        break label301;
      }
    }
    label301:
    for (boolean bool2 = true;; bool2 = false)
    {
      ae.i("Finder.ExptUtil", "showFinder %s %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((bool1) || (bool2)) {
        i = 1;
      }
      if (i != 0)
      {
        i = paramalw.GEm;
        localObject = a.sIA;
        paramalw.GEm = (i | a.cKS());
      }
      localObject = b.sHP;
      if (((Number)b.cKD().value()).intValue() == 1)
      {
        i = paramalw.GEm;
        localObject = a.sIA;
        paramalw.GEm = (i | a.cKT());
      }
      localObject = b.sHP;
      if (((Number)b.cKK().value()).intValue() == 1)
      {
        i = paramalw.GEm;
        localObject = a.sIA;
        paramalw.GEm = (i | a.cKU());
      }
      ae.i("Finder.ExptUtil", "[fillExptFlag] exptFlag=" + paramalw.GEm);
      AppMethodBeat.o(204221);
      return;
      bool1 = false;
      break;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/storage/FinderExptUtil$EXPT_FLAG;", "", "()V", "FINDER_COMMENT_EXPOSE", "", "getFINDER_COMMENT_EXPOSE", "()I", "FriendCommentExpand", "getFriendCommentExpand", "HAS_FINDER_ENTRANCE", "getHAS_FINDER_ENTRANCE", "REAL_NAME_LIKE", "getREAL_NAME_LIKE", "plugin-finder_release"})
  static final class a
  {
    public static final a sIA;
    private static final int sIw = 1;
    private static final int sIx = 2;
    private static final int sIy = 4;
    private static final int sIz = 8;
    
    static
    {
      AppMethodBeat.i(204220);
      sIA = new a();
      sIw = 1;
      sIx = 2;
      sIy = 4;
      sIz = 8;
      AppMethodBeat.o(204220);
    }
    
    public static int cKR()
    {
      return sIw;
    }
    
    public static int cKS()
    {
      return sIx;
    }
    
    public static int cKT()
    {
      return sIy;
    }
    
    public static int cKU()
    {
      return sIz;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.f
 * JD-Core Version:    0.7.0.1
 */