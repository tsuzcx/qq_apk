package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.finder.utils.ak;
import com.tencent.mm.protocal.protobuf.aqe;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/FinderExptUtil;", "", "()V", "TAG", "", "fillExptFlag", "", "finderBaseReq", "Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;", "showFinderEntry", "", "EXPT_FLAG", "plugin-finder-base_release"})
public final class j
{
  public static final j AkL;
  
  static
  {
    AppMethodBeat.i(263343);
    AkL = new j();
    AppMethodBeat.o(263343);
  }
  
  public static void a(aqe paramaqe)
  {
    int i = 0;
    AppMethodBeat.i(263341);
    p.k(paramaqe, "finderBaseReq");
    paramaqe.SDt = 0;
    Object localObject = d.AjH;
    int j;
    if (((Number)d.dTE().aSr()).intValue() == 1)
    {
      j = paramaqe.SDt;
      localObject = a.AkW;
      paramaqe.SDt = (j | a.dYq());
    }
    boolean bool1;
    if (((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vHv, 0) != 0)
    {
      bool1 = true;
      localObject = com.tencent.mm.plugin.findersdk.c.a.Bwg;
      j = com.tencent.mm.plugin.findersdk.c.a.aGQ("entrance");
      if (j == 2)
      {
        Log.i("Finder.ExptUtil", "showFinderEntry ".concat(String.valueOf(j)));
        bool1 = false;
      }
      localObject = d.AjH;
      if (d.dSF() == 0) {
        break label541;
      }
    }
    label541:
    for (boolean bool2 = true;; bool2 = false)
    {
      Log.i("Finder.ExptUtil", "showFinder %s %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((bool1) || (bool2)) {
        i = 1;
      }
      if (i != 0)
      {
        i = paramaqe.SDt;
        localObject = a.AkW;
        paramaqe.SDt = (i | a.dYr());
      }
      localObject = d.AjH;
      if (((Number)d.dVF().aSr()).intValue() == 1)
      {
        i = paramaqe.SDt;
        localObject = a.AkW;
        paramaqe.SDt = (i | a.dYs());
      }
      localObject = d.AjH;
      if (((Number)d.dVM().aSr()).intValue() == 1)
      {
        i = paramaqe.SDt;
        localObject = a.AkW;
        paramaqe.SDt = (i | a.dYt());
      }
      localObject = ak.AGL;
      if (ak.isAnyEnableFullScreenEnjoy())
      {
        i = paramaqe.SDt;
        localObject = a.AkW;
        paramaqe.SDt = (i | a.dYu());
      }
      localObject = d.AjH;
      if (((Number)d.dWF().aSr()).intValue() == 1)
      {
        i = paramaqe.SDt;
        localObject = a.AkW;
        paramaqe.SDt = (i | a.dYv());
      }
      localObject = d.AjH;
      if (((Number)d.dWE().aSr()).intValue() == 1)
      {
        i = paramaqe.SDt;
        localObject = a.AkW;
        paramaqe.SDt = (i | a.dYw());
      }
      localObject = d.AjH;
      if (((Number)d.dWH().aSr()).intValue() == 1)
      {
        i = paramaqe.SDt;
        localObject = a.AkW;
        paramaqe.SDt = (i | a.dYx());
      }
      localObject = ak.AGL;
      if (ak.isAllEnableFullScreenEnjoy())
      {
        i = paramaqe.SDt;
        localObject = a.AkW;
        paramaqe.SDt = (i | a.dYy());
      }
      localObject = com.tencent.mm.plugin.finder.nearby.abtest.a.zDp;
      if (com.tencent.mm.plugin.finder.nearby.abtest.a.dLo())
      {
        i = paramaqe.SDt;
        localObject = a.AkW;
        paramaqe.SDt = (i | a.dYz());
      }
      localObject = com.tencent.mm.plugin.finder.nearby.abtest.a.zDp;
      if (com.tencent.mm.plugin.finder.nearby.abtest.a.cFx())
      {
        i = paramaqe.SDt;
        localObject = a.AkW;
        paramaqe.SDt = (i | a.etH());
      }
      Log.i("Finder.ExptUtil", "[fillExptFlag] exptFlag=" + paramaqe.SDt);
      AppMethodBeat.o(263341);
      return;
      bool1 = false;
      break;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/FinderExptUtil$EXPT_FLAG;", "", "()V", "FINDER_COMMENT_EXPOSE", "", "getFINDER_COMMENT_EXPOSE", "()I", "FriendCommentExpand", "getFriendCommentExpand", "HAS_FINDER_ENTRANCE", "getHAS_FINDER_ENTRANCE", "MMFinderBaseReqExptFlag_AllFullScreen", "getMMFinderBaseReqExptFlag_AllFullScreen", "MMFinderBaseReqExptFlag_FollowFullScreen", "getMMFinderBaseReqExptFlag_FollowFullScreen", "MMFinderBaseReqExptFlag_FriendFullScreen", "getMMFinderBaseReqExptFlag_FriendFullScreen", "MMFinderBaseReqExptFlag_IsFullScreen", "getMMFinderBaseReqExptFlag_IsFullScreen", "MMFinderBaseReqExptFlag_NewLiveEntrance", "getMMFinderBaseReqExptFlag_NewLiveEntrance", "MMFinderBaseReqExptFlag_NewLiveEntrance_On_TopStory", "getMMFinderBaseReqExptFlag_NewLiveEntrance_On_TopStory", "MMFinderBaseReqExptFlag_RelatedFullScreen", "getMMFinderBaseReqExptFlag_RelatedFullScreen", "REAL_NAME_LIKE", "getREAL_NAME_LIKE", "plugin-finder-base_release"})
  static final class a
  {
    private static final int AkM = 1;
    private static final int AkN = 2;
    private static final int AkO = 4;
    private static final int AkP = 8;
    private static final int AkQ = 16;
    private static final int AkR = 32;
    private static final int AkS = 64;
    private static final int AkT = 128;
    private static final int AkU = 256;
    private static final int AkV = 512;
    public static final a AkW;
    private static final int KIb = 1024;
    
    static
    {
      AppMethodBeat.i(261913);
      AkW = new a();
      AkM = 1;
      AkN = 2;
      AkO = 4;
      AkP = 8;
      AkQ = 16;
      AkR = 32;
      AkS = 64;
      AkT = 128;
      AkU = 256;
      AkV = 512;
      KIb = 1024;
      AppMethodBeat.o(261913);
    }
    
    public static int dYq()
    {
      return AkM;
    }
    
    public static int dYr()
    {
      return AkN;
    }
    
    public static int dYs()
    {
      return AkO;
    }
    
    public static int dYt()
    {
      return AkP;
    }
    
    public static int dYu()
    {
      return AkQ;
    }
    
    public static int dYv()
    {
      return AkR;
    }
    
    public static int dYw()
    {
      return AkS;
    }
    
    public static int dYx()
    {
      return AkT;
    }
    
    public static int dYy()
    {
      return AkU;
    }
    
    public static int dYz()
    {
      return AkV;
    }
    
    public static int etH()
    {
      return KIb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.j
 * JD-Core Version:    0.7.0.1
 */