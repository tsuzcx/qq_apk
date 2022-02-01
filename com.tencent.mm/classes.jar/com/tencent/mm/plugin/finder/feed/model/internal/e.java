package com.tencent.mm.plugin.finder.feed.model.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "FEED_DEFAULT", "FEED_TIMELINE_ALL", "FEED_TIMELINE_FRIEND", "FEED_TIMELINE_LBS", "FEED_TIMELINE_FOLLOW", "FEED_TIMELINE_MACHINE", "FEED_PROFILE", "FEED_PROFILE_TIMELINE", "FEED_LIKED_TIMELINE", "FEED_RETRANSMIT_SOURCE", "FEED_TOPIC_TIMELINE", "FEED_FAV_LIST", "FEED_FOLDED_LIST", "FEED_FRIEND_LIKE_LIST", "FEED_REL_RECOMMEND", "FEED_AT_TIMELINE", "Companion", "plugin-finder_release"})
public enum e
{
  public static final a scW;
  public final int value;
  
  static
  {
    AppMethodBeat.i(202581);
    e locale1 = new e("FEED_DEFAULT", 0, -1);
    scF = locale1;
    e locale2 = new e("FEED_TIMELINE_ALL", 1, 0);
    scG = locale2;
    e locale3 = new e("FEED_TIMELINE_FRIEND", 2, 1);
    scH = locale3;
    e locale4 = new e("FEED_TIMELINE_LBS", 3, 2);
    scI = locale4;
    e locale5 = new e("FEED_TIMELINE_FOLLOW", 4, 3);
    scJ = locale5;
    e locale6 = new e("FEED_TIMELINE_MACHINE", 5, 4);
    scK = locale6;
    e locale7 = new e("FEED_PROFILE", 6, 100);
    scL = locale7;
    e locale8 = new e("FEED_PROFILE_TIMELINE", 7, 101);
    scM = locale8;
    e locale9 = new e("FEED_LIKED_TIMELINE", 8, 102);
    scN = locale9;
    e locale10 = new e("FEED_RETRANSMIT_SOURCE", 9, 103);
    scO = locale10;
    e locale11 = new e("FEED_TOPIC_TIMELINE", 10, 104);
    scP = locale11;
    e locale12 = new e("FEED_FAV_LIST", 11, 105);
    scQ = locale12;
    e locale13 = new e("FEED_FOLDED_LIST", 12, 106);
    scR = locale13;
    e locale14 = new e("FEED_FRIEND_LIKE_LIST", 13, 107);
    scS = locale14;
    e locale15 = new e("FEED_REL_RECOMMEND", 14, 17);
    scT = locale15;
    e locale16 = new e("FEED_AT_TIMELINE", 15, 18);
    scU = locale16;
    scV = new e[] { locale1, locale2, locale3, locale4, locale5, locale6, locale7, locale8, locale9, locale10, locale11, locale12, locale13, locale14, locale15, locale16 };
    scW = new a((byte)0);
    AppMethodBeat.o(202581);
  }
  
  private e(int paramInt)
  {
    this.value = paramInt;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene$Companion;", "", "()V", "get", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "value", "", "plugin-finder_release"})
  public static final class a
  {
    public static e ED(int paramInt)
    {
      if (paramInt == e.scG.value) {
        return e.scG;
      }
      if (paramInt == e.scK.value) {
        return e.scK;
      }
      if (paramInt == e.scI.value) {
        return e.scI;
      }
      if (paramInt == e.scJ.value) {
        return e.scJ;
      }
      if (paramInt == e.scH.value) {
        return e.scH;
      }
      if (paramInt == e.scL.value) {
        return e.scL;
      }
      if (paramInt == e.scM.value) {
        return e.scM;
      }
      if (paramInt == e.scN.value) {
        return e.scN;
      }
      if (paramInt == e.scO.value) {
        return e.scO;
      }
      if (paramInt == e.scP.value) {
        return e.scP;
      }
      if (paramInt == e.scQ.value) {
        return e.scQ;
      }
      if (paramInt == e.scR.value) {
        return e.scR;
      }
      if (paramInt == e.scS.value) {
        return e.scS;
      }
      if (paramInt == e.scT.value) {
        return e.scT;
      }
      if (paramInt == e.scU.value) {
        return e.scU;
      }
      return e.scF;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.e
 * JD-Core Version:    0.7.0.1
 */