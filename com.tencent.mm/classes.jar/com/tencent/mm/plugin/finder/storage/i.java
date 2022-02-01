package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.finder.spam.a;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/FinderExptUtil;", "", "()V", "TAG", "", "fillExptFlag", "", "finderBaseReq", "Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;", "showFinderEntry", "", "EXPT_FLAG", "plugin-finder_release"})
public final class i
{
  public static final i vDq;
  
  static
  {
    AppMethodBeat.i(251723);
    vDq = new i();
    AppMethodBeat.o(251723);
  }
  
  public static void a(aov paramaov)
  {
    int i = 0;
    AppMethodBeat.i(251722);
    p.h(paramaov, "finderBaseReq");
    paramaov.LAS = 0;
    Object localObject = c.vCb;
    int j;
    if (((Number)c.dsp().value()).intValue() == 1)
    {
      j = paramaov.LAS;
      localObject = a.vDA;
      paramaov.LAS = (j | a.dxr());
    }
    boolean bool1;
    if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sai, 0) != 0)
    {
      bool1 = true;
      localObject = a.vwk;
      j = a.avn("entrance");
      if (j == 2)
      {
        Log.i("Finder.ExptUtil", "showFinderEntry ".concat(String.valueOf(j)));
        bool1 = false;
      }
      localObject = c.vCb;
      if (c.drq() == 0) {
        break label481;
      }
    }
    label481:
    for (boolean bool2 = true;; bool2 = false)
    {
      Log.i("Finder.ExptUtil", "showFinder %s %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((bool1) || (bool2)) {
        i = 1;
      }
      if (i != 0)
      {
        i = paramaov.LAS;
        localObject = a.vDA;
        paramaov.LAS = (i | a.dxs());
      }
      localObject = c.vCb;
      if (((Number)c.dux().value()).intValue() == 1)
      {
        i = paramaov.LAS;
        localObject = a.vDA;
        paramaov.LAS = (i | a.dxt());
      }
      localObject = c.vCb;
      if (((Number)c.duF().value()).intValue() == 1)
      {
        i = paramaov.LAS;
        localObject = a.vDA;
        paramaov.LAS = (i | a.dxu());
      }
      localObject = y.vXH;
      if (y.isAnyEnableFullScreenEnjoy())
      {
        i = paramaov.LAS;
        localObject = a.vDA;
        paramaov.LAS = (i | a.dxv());
      }
      localObject = c.vCb;
      if (((Number)c.dwu().value()).intValue() == 1)
      {
        i = paramaov.LAS;
        localObject = a.vDA;
        paramaov.LAS = (i | a.dxw());
      }
      localObject = c.vCb;
      if (((Number)c.dwt().value()).intValue() == 1)
      {
        i = paramaov.LAS;
        localObject = a.vDA;
        paramaov.LAS = (i | a.dxx());
      }
      localObject = c.vCb;
      if (((Number)c.dww().value()).intValue() == 1)
      {
        i = paramaov.LAS;
        localObject = a.vDA;
        paramaov.LAS = (i | a.dxy());
      }
      localObject = y.vXH;
      if (y.isAllEnableFullScreenEnjoy())
      {
        i = paramaov.LAS;
        localObject = a.vDA;
        paramaov.LAS = (i | a.dxz());
      }
      Log.i("Finder.ExptUtil", "[fillExptFlag] exptFlag=" + paramaov.LAS);
      AppMethodBeat.o(251722);
      return;
      bool1 = false;
      break;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/FinderExptUtil$EXPT_FLAG;", "", "()V", "FINDER_COMMENT_EXPOSE", "", "getFINDER_COMMENT_EXPOSE", "()I", "FriendCommentExpand", "getFriendCommentExpand", "HAS_FINDER_ENTRANCE", "getHAS_FINDER_ENTRANCE", "MMFinderBaseReqExptFlag_AllFullScreen", "getMMFinderBaseReqExptFlag_AllFullScreen", "MMFinderBaseReqExptFlag_FollowFullScreen", "getMMFinderBaseReqExptFlag_FollowFullScreen", "MMFinderBaseReqExptFlag_FriendFullScreen", "getMMFinderBaseReqExptFlag_FriendFullScreen", "MMFinderBaseReqExptFlag_IsFullScreen", "getMMFinderBaseReqExptFlag_IsFullScreen", "MMFinderBaseReqExptFlag_RelatedFullScreen", "getMMFinderBaseReqExptFlag_RelatedFullScreen", "REAL_NAME_LIKE", "getREAL_NAME_LIKE", "plugin-finder_release"})
  static final class a
  {
    public static final a vDA;
    private static final int vDr = 1;
    private static final int vDs = 2;
    private static final int vDt = 4;
    private static final int vDu = 8;
    private static final int vDv = 16;
    private static final int vDw = 32;
    private static final int vDx = 64;
    private static final int vDy = 128;
    private static final int vDz = 256;
    
    static
    {
      AppMethodBeat.i(251721);
      vDA = new a();
      vDr = 1;
      vDs = 2;
      vDt = 4;
      vDu = 8;
      vDv = 16;
      vDw = 32;
      vDx = 64;
      vDy = 128;
      vDz = 256;
      AppMethodBeat.o(251721);
    }
    
    public static int dxr()
    {
      return vDr;
    }
    
    public static int dxs()
    {
      return vDs;
    }
    
    public static int dxt()
    {
      return vDt;
    }
    
    public static int dxu()
    {
      return vDu;
    }
    
    public static int dxv()
    {
      return vDv;
    }
    
    public static int dxw()
    {
      return vDw;
    }
    
    public static int dxx()
    {
      return vDx;
    }
    
    public static int dxy()
    {
      return vDy;
    }
    
    public static int dxz()
    {
      return vDz;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.i
 * JD-Core Version:    0.7.0.1
 */