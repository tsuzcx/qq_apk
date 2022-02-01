package com.tencent.mm.plugin.finder.feed.model.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "FEED_DEFAULT", "FEED_TIMELINE_ALL", "FEED_TIMELINE_FRIEND", "FEED_TIMELINE_LBS", "FEED_TIMELINE_FOLLOW", "FEED_TIMELINE_MACHINE", "FEED_PROFILE", "FEED_PROFILE_TIMELINE", "FEED_LIKED_TIMELINE", "FEED_RETRANSMIT_SOURCE", "FEED_TOPIC_TIMELINE", "FEED_FAV_LIST", "FEED_FOLDED_LIST", "FEED_FRIEND_LIKE_LIST", "FEED_REL_RECOMMEND", "FEED_AT_TIMELINE", "Companion", "plugin-finder_release"})
public enum e
{
  public static final a slN;
  public final int value;
  
  static
  {
    AppMethodBeat.i(203057);
    e locale1 = new e("FEED_DEFAULT", 0, -1);
    slw = locale1;
    e locale2 = new e("FEED_TIMELINE_ALL", 1, 0);
    slx = locale2;
    e locale3 = new e("FEED_TIMELINE_FRIEND", 2, 1);
    sly = locale3;
    e locale4 = new e("FEED_TIMELINE_LBS", 3, 2);
    slz = locale4;
    e locale5 = new e("FEED_TIMELINE_FOLLOW", 4, 3);
    slA = locale5;
    e locale6 = new e("FEED_TIMELINE_MACHINE", 5, 4);
    slB = locale6;
    e locale7 = new e("FEED_PROFILE", 6, 100);
    slC = locale7;
    e locale8 = new e("FEED_PROFILE_TIMELINE", 7, 101);
    slD = locale8;
    e locale9 = new e("FEED_LIKED_TIMELINE", 8, 102);
    slE = locale9;
    e locale10 = new e("FEED_RETRANSMIT_SOURCE", 9, 103);
    slF = locale10;
    e locale11 = new e("FEED_TOPIC_TIMELINE", 10, 104);
    slG = locale11;
    e locale12 = new e("FEED_FAV_LIST", 11, 105);
    slH = locale12;
    e locale13 = new e("FEED_FOLDED_LIST", 12, 106);
    slI = locale13;
    e locale14 = new e("FEED_FRIEND_LIKE_LIST", 13, 107);
    slJ = locale14;
    e locale15 = new e("FEED_REL_RECOMMEND", 14, 17);
    slK = locale15;
    e locale16 = new e("FEED_AT_TIMELINE", 15, 18);
    slL = locale16;
    slM = new e[] { locale1, locale2, locale3, locale4, locale5, locale6, locale7, locale8, locale9, locale10, locale11, locale12, locale13, locale14, locale15, locale16 };
    slN = new a((byte)0);
    AppMethodBeat.o(203057);
  }
  
  private e(int paramInt)
  {
    this.value = paramInt;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene$Companion;", "", "()V", "get", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "value", "", "plugin-finder_release"})
  public static final class a
  {
    public static e EQ(int paramInt)
    {
      if (paramInt == e.slx.value) {
        return e.slx;
      }
      if (paramInt == e.slB.value) {
        return e.slB;
      }
      if (paramInt == e.slz.value) {
        return e.slz;
      }
      if (paramInt == e.slA.value) {
        return e.slA;
      }
      if (paramInt == e.sly.value) {
        return e.sly;
      }
      if (paramInt == e.slC.value) {
        return e.slC;
      }
      if (paramInt == e.slD.value) {
        return e.slD;
      }
      if (paramInt == e.slE.value) {
        return e.slE;
      }
      if (paramInt == e.slF.value) {
        return e.slF;
      }
      if (paramInt == e.slG.value) {
        return e.slG;
      }
      if (paramInt == e.slH.value) {
        return e.slH;
      }
      if (paramInt == e.slI.value) {
        return e.slI;
      }
      if (paramInt == e.slJ.value) {
        return e.slJ;
      }
      if (paramInt == e.slK.value) {
        return e.slK;
      }
      if (paramInt == e.slL.value) {
        return e.slL;
      }
      return e.slw;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.e
 * JD-Core Version:    0.7.0.1
 */