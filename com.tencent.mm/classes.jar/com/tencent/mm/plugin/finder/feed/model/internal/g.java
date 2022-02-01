package com.tencent.mm.plugin.finder.feed.model.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "FEED_DEFAULT", "FEED_TIMELINE_ALL", "FEED_TIMELINE_FRIEND", "FEED_TIMELINE_LBS", "FEED_NEARBY_LIVE", "FEED_TIMELINE_FOLLOW", "FEED_TIMELINE_MACHINE", "FEED_PROFILE", "FEED_PROFILE_TIMELINE", "FEED_LIKED_TIMELINE", "FEED_RETRANSMIT_SOURCE", "FEED_TOPIC_TIMELINE", "FEED_FAV_LIST", "FEED_FOLDED_LIST", "FEED_FRIEND_LIKE_LIST", "SELF_FEED_PROFILE", "SELF_FEED_FULL_PROFILE", "SELF_FEED_AT_MANAGER", "FEED_REL_RECOMMEND", "FEED_AT_TIMELINE", "Companion", "plugin-finder-base_release"})
public enum g
{
  public static final a xKI;
  public final int value;
  
  static
  {
    AppMethodBeat.i(263819);
    g localg1 = new g("FEED_DEFAULT", 0, -1);
    xKn = localg1;
    g localg2 = new g("FEED_TIMELINE_ALL", 1, 0);
    xKo = localg2;
    g localg3 = new g("FEED_TIMELINE_FRIEND", 2, 1);
    xKp = localg3;
    g localg4 = new g("FEED_TIMELINE_LBS", 3, 2);
    xKq = localg4;
    g localg5 = new g("FEED_NEARBY_LIVE", 4, 1001);
    xKr = localg5;
    g localg6 = new g("FEED_TIMELINE_FOLLOW", 5, 3);
    xKs = localg6;
    g localg7 = new g("FEED_TIMELINE_MACHINE", 6, 4);
    xKt = localg7;
    g localg8 = new g("FEED_PROFILE", 7, 100);
    xKu = localg8;
    g localg9 = new g("FEED_PROFILE_TIMELINE", 8, 101);
    xKv = localg9;
    g localg10 = new g("FEED_LIKED_TIMELINE", 9, 102);
    xKw = localg10;
    g localg11 = new g("FEED_RETRANSMIT_SOURCE", 10, 103);
    xKx = localg11;
    g localg12 = new g("FEED_TOPIC_TIMELINE", 11, 104);
    xKy = localg12;
    g localg13 = new g("FEED_FAV_LIST", 12, 105);
    xKz = localg13;
    g localg14 = new g("FEED_FOLDED_LIST", 13, 106);
    xKA = localg14;
    g localg15 = new g("FEED_FRIEND_LIKE_LIST", 14, 107);
    xKB = localg15;
    g localg16 = new g("SELF_FEED_PROFILE", 15, 108);
    xKC = localg16;
    g localg17 = new g("SELF_FEED_FULL_PROFILE", 16, 109);
    xKD = localg17;
    g localg18 = new g("SELF_FEED_AT_MANAGER", 17, 200);
    xKE = localg18;
    g localg19 = new g("FEED_REL_RECOMMEND", 18, 17);
    xKF = localg19;
    g localg20 = new g("FEED_AT_TIMELINE", 19, 18);
    xKG = localg20;
    xKH = new g[] { localg1, localg2, localg3, localg4, localg5, localg6, localg7, localg8, localg9, localg10, localg11, localg12, localg13, localg14, localg15, localg16, localg17, localg18, localg19, localg20 };
    xKI = new a((byte)0);
    AppMethodBeat.o(263819);
  }
  
  private g(int paramInt)
  {
    this.value = paramInt;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene$Companion;", "", "()V", "get", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "value", "", "plugin-finder-base_release"})
  public static final class a
  {
    public static g MG(int paramInt)
    {
      if (paramInt == g.xKo.value) {
        return g.xKo;
      }
      if (paramInt == g.xKt.value) {
        return g.xKt;
      }
      if (paramInt == g.xKq.value) {
        return g.xKq;
      }
      if (paramInt == g.xKs.value) {
        return g.xKs;
      }
      if (paramInt == g.xKp.value) {
        return g.xKp;
      }
      if (paramInt == g.xKr.value) {
        return g.xKr;
      }
      if (paramInt == g.xKu.value) {
        return g.xKu;
      }
      if (paramInt == g.xKv.value) {
        return g.xKv;
      }
      if (paramInt == g.xKw.value) {
        return g.xKw;
      }
      if (paramInt == g.xKx.value) {
        return g.xKx;
      }
      if (paramInt == g.xKy.value) {
        return g.xKy;
      }
      if (paramInt == g.xKz.value) {
        return g.xKz;
      }
      if (paramInt == g.xKA.value) {
        return g.xKA;
      }
      if (paramInt == g.xKB.value) {
        return g.xKB;
      }
      if (paramInt == g.xKF.value) {
        return g.xKF;
      }
      if (paramInt == g.xKG.value) {
        return g.xKG;
      }
      return g.xKn;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.g
 * JD-Core Version:    0.7.0.1
 */