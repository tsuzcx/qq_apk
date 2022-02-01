package com.tencent.mm.plugin.finder.feed.model.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "FEED_DEFAULT", "FEED_TIMELINE_ALL", "FEED_TIMELINE_FRIEND", "FEED_TIMELINE_LBS", "FEED_TIMELINE_FOLLOW", "FEED_TIMELINE_MACHINE", "FEED_PROFILE", "FEED_PROFILE_TIMELINE", "FEED_LIKED_TIMELINE", "FEED_RETRANSMIT_SOURCE", "FEED_TOPIC_TIMELINE", "FEED_FAV_LIST", "FEED_FOLDED_LIST", "FEED_FRIEND_LIKE_LIST", "FEED_REL_RECOMMEND", "FEED_AT_TIMELINE", "Companion", "plugin-finder_release"})
public enum b
{
  public static final a KQP;
  public final int value;
  
  static
  {
    AppMethodBeat.i(198349);
    b localb1 = new b("FEED_DEFAULT", 0, -1);
    KQy = localb1;
    b localb2 = new b("FEED_TIMELINE_ALL", 1, 0);
    KQz = localb2;
    b localb3 = new b("FEED_TIMELINE_FRIEND", 2, 1);
    KQA = localb3;
    b localb4 = new b("FEED_TIMELINE_LBS", 3, 2);
    KQB = localb4;
    b localb5 = new b("FEED_TIMELINE_FOLLOW", 4, 3);
    KQC = localb5;
    b localb6 = new b("FEED_TIMELINE_MACHINE", 5, 4);
    KQD = localb6;
    b localb7 = new b("FEED_PROFILE", 6, 100);
    KQE = localb7;
    b localb8 = new b("FEED_PROFILE_TIMELINE", 7, 101);
    KQF = localb8;
    b localb9 = new b("FEED_LIKED_TIMELINE", 8, 102);
    KQG = localb9;
    b localb10 = new b("FEED_RETRANSMIT_SOURCE", 9, 103);
    KQH = localb10;
    b localb11 = new b("FEED_TOPIC_TIMELINE", 10, 104);
    KQI = localb11;
    b localb12 = new b("FEED_FAV_LIST", 11, 105);
    KQJ = localb12;
    b localb13 = new b("FEED_FOLDED_LIST", 12, 106);
    KQK = localb13;
    b localb14 = new b("FEED_FRIEND_LIKE_LIST", 13, 107);
    KQL = localb14;
    b localb15 = new b("FEED_REL_RECOMMEND", 14, 17);
    KQM = localb15;
    b localb16 = new b("FEED_AT_TIMELINE", 15, 18);
    KQN = localb16;
    KQO = new b[] { localb1, localb2, localb3, localb4, localb5, localb6, localb7, localb8, localb9, localb10, localb11, localb12, localb13, localb14, localb15, localb16 };
    KQP = new a((byte)0);
    AppMethodBeat.o(198349);
  }
  
  private b(int paramInt)
  {
    this.value = paramInt;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene$Companion;", "", "()V", "get", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "value", "", "plugin-finder_release"})
  public static final class a
  {
    public static b ahj(int paramInt)
    {
      if (paramInt == b.KQz.value) {
        return b.KQz;
      }
      if (paramInt == b.KQD.value) {
        return b.KQD;
      }
      if (paramInt == b.KQB.value) {
        return b.KQB;
      }
      if (paramInt == b.KQC.value) {
        return b.KQC;
      }
      if (paramInt == b.KQA.value) {
        return b.KQA;
      }
      if (paramInt == b.KQE.value) {
        return b.KQE;
      }
      if (paramInt == b.KQF.value) {
        return b.KQF;
      }
      if (paramInt == b.KQG.value) {
        return b.KQG;
      }
      if (paramInt == b.KQH.value) {
        return b.KQH;
      }
      if (paramInt == b.KQI.value) {
        return b.KQI;
      }
      if (paramInt == b.KQJ.value) {
        return b.KQJ;
      }
      if (paramInt == b.KQK.value) {
        return b.KQK;
      }
      if (paramInt == b.KQL.value) {
        return b.KQL;
      }
      if (paramInt == b.KQM.value) {
        return b.KQM;
      }
      if (paramInt == b.KQN.value) {
        return b.KQN;
      }
      return b.KQy;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.b
 * JD-Core Version:    0.7.0.1
 */