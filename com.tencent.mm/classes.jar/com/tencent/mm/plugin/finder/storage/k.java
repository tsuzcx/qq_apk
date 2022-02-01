package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.findersdk.storage.config.base.b;
import com.tencent.mm.protocal.protobuf.atz;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FinderExptUtil;", "", "()V", "TAG", "", "fillExptFlag", "", "finderBaseReq", "Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;", "EXPT_FLAG", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
{
  public static final k FKi;
  
  static
  {
    AppMethodBeat.i(339235);
    FKi = new k();
    AppMethodBeat.o(339235);
  }
  
  public static void a(atz paramatz)
  {
    AppMethodBeat.i(339225);
    s.u(paramatz, "finderBaseReq");
    paramatz.ZEr = 0;
    Object localObject = d.FAy;
    if (((Number)d.eRV().bmg()).intValue() == 1)
    {
      i = paramatz.ZEr;
      localObject = a.FKj;
      paramatz.ZEr = (i | a.eYS());
    }
    localObject = com.tencent.mm.plugin.finder.permission.a.ESS;
    if (com.tencent.mm.plugin.finder.permission.a.eGX())
    {
      i = paramatz.ZEr;
      localObject = a.FKj;
      paramatz.ZEr = (i | a.eYT());
    }
    localObject = d.FAy;
    if (((Number)d.eUg().bmg()).intValue() == 1)
    {
      i = paramatz.ZEr;
      localObject = a.FKj;
      paramatz.ZEr = (i | a.eYU());
    }
    localObject = d.FAy;
    if (((Number)d.eUo().bmg()).intValue() == 1)
    {
      i = paramatz.ZEr;
      localObject = a.FKj;
      paramatz.ZEr = (i | a.eYV());
    }
    int i = paramatz.ZEr;
    localObject = a.FKj;
    int j = a.eYW();
    localObject = a.FKj;
    int k = a.eYX();
    localObject = a.FKj;
    int m = a.eYY();
    localObject = a.FKj;
    int n = a.eYZ();
    localObject = a.FKj;
    paramatz.ZEr = (i | j | k | m | n | a.eZa());
    localObject = com.tencent.mm.plugin.finder.nearby.abtest.a.EHr;
    if (com.tencent.mm.plugin.finder.nearby.abtest.a.eEi())
    {
      i = paramatz.ZEr;
      localObject = a.FKj;
      paramatz.ZEr = (i | a.eZb());
    }
    localObject = com.tencent.mm.plugin.finder.nearby.abtest.a.EHr;
    if (com.tencent.mm.plugin.finder.nearby.abtest.a.eEl())
    {
      i = paramatz.ZEr;
      localObject = a.FKj;
      paramatz.ZEr = (i | a.eZc());
    }
    localObject = d.FAy;
    if (((Number)d.eXJ().bmg()).intValue() == 1)
    {
      i = paramatz.ZEr;
      localObject = a.FKj;
      paramatz.ZEr = (i | a.eZd());
    }
    i = paramatz.ZEr;
    localObject = a.FKj;
    paramatz.ZEr = (i | a.eZf());
    localObject = d.FAy;
    if (((Number)d.eYE().bmg()).intValue() == 1) {
      paramatz.ZEr |= 0x4000;
    }
    Log.i("Finder.ExptUtil", s.X("[fillExptFlag] exptFlag=", Integer.valueOf(paramatz.ZEr)));
    AppMethodBeat.o(339225);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FinderExptUtil$EXPT_FLAG;", "", "()V", "FINDER_COMMENT_EXPOSE", "", "getFINDER_COMMENT_EXPOSE", "()I", "FriendCommentExpand", "getFriendCommentExpand", "HAS_FINDER_ENTRANCE", "getHAS_FINDER_ENTRANCE", "MMFinderBaseReqExptFlag_AllFullScreen", "getMMFinderBaseReqExptFlag_AllFullScreen", "MMFinderBaseReqExptFlag_FoldFriendTab", "getMMFinderBaseReqExptFlag_FoldFriendTab", "MMFinderBaseReqExptFlag_FollowFullScreen", "getMMFinderBaseReqExptFlag_FollowFullScreen", "MMFinderBaseReqExptFlag_FriendFullScreen", "getMMFinderBaseReqExptFlag_FriendFullScreen", "MMFinderBaseReqExptFlag_FriendReddotJumpMachine", "getMMFinderBaseReqExptFlag_FriendReddotJumpMachine", "MMFinderBaseReqExptFlag_IsFullScreen", "getMMFinderBaseReqExptFlag_IsFullScreen", "MMFinderBaseReqExptFlag_MachineShowSquare", "getMMFinderBaseReqExptFlag_MachineShowSquare", "MMFinderBaseReqExptFlag_NewLiveEntrance", "getMMFinderBaseReqExptFlag_NewLiveEntrance", "MMFinderBaseReqExptFlag_NewLiveEntrance_On_TopStory", "getMMFinderBaseReqExptFlag_NewLiveEntrance_On_TopStory", "MMFinderBaseReqExptFlag_OutlineInteractionIcon", "MMFinderBaseReqExptFlag_RelatedFullScreen", "getMMFinderBaseReqExptFlag_RelatedFullScreen", "MMFinderBaseReqExptFlag_ShowStarButton", "getMMFinderBaseReqExptFlag_ShowStarButton", "REAL_NAME_LIKE", "getREAL_NAME_LIKE", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static final a FKj;
    private static final int FKk;
    private static final int FKl;
    private static final int FKm;
    private static final int FKn;
    private static final int FKo;
    private static final int FKp;
    private static final int FKq;
    private static final int FKr;
    private static final int FKs;
    private static final int FKt;
    private static final int FKu;
    private static final int FKv;
    private static final int FKw;
    private static final int FKx;
    private static final int FKy;
    
    static
    {
      AppMethodBeat.i(339167);
      FKj = new a();
      FKk = 1;
      FKl = 2;
      FKm = 4;
      FKn = 8;
      FKo = 16;
      FKp = 32;
      FKq = 64;
      FKr = 128;
      FKs = 256;
      FKt = 512;
      FKu = 1024;
      FKv = 2048;
      FKw = 4096;
      FKx = 8192;
      FKy = 32768;
      AppMethodBeat.o(339167);
    }
    
    public static int eYS()
    {
      return FKk;
    }
    
    public static int eYT()
    {
      return FKl;
    }
    
    public static int eYU()
    {
      return FKm;
    }
    
    public static int eYV()
    {
      return FKn;
    }
    
    public static int eYW()
    {
      return FKo;
    }
    
    public static int eYX()
    {
      return FKp;
    }
    
    public static int eYY()
    {
      return FKq;
    }
    
    public static int eYZ()
    {
      return FKr;
    }
    
    public static int eZa()
    {
      return FKs;
    }
    
    public static int eZb()
    {
      return FKt;
    }
    
    public static int eZc()
    {
      return FKu;
    }
    
    public static int eZd()
    {
      return FKv;
    }
    
    public static int eZe()
    {
      return FKx;
    }
    
    public static int eZf()
    {
      return FKy;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.k
 * JD-Core Version:    0.7.0.1
 */