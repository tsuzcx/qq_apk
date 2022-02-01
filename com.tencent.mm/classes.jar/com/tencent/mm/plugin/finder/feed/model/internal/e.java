package com.tencent.mm.plugin.finder.feed.model.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "FEED_DEFAULT", "FEED_TIMELINE_ALL", "FEED_TIMELINE_FRIEND", "FEED_TIMELINE_LBS", "FEED_NEARBY_LIVE", "FEED_TIMELINE_FOLLOW", "FEED_TIMELINE_MACHINE", "FEED_PROFILE", "FEED_PROFILE_TIMELINE", "FEED_LIKED_TIMELINE", "FEED_RETRANSMIT_SOURCE", "FEED_TOPIC_TIMELINE", "FEED_FAV_LIST", "FEED_FOLDED_LIST", "FEED_FRIEND_LIKE_LIST", "FEED_REL_RECOMMEND", "FEED_AT_TIMELINE", "Companion", "plugin-finder_release"})
public enum e
{
  public static final a tYB;
  public final int value;
  
  static
  {
    AppMethodBeat.i(245022);
    e locale1 = new e("FEED_DEFAULT", 0, -1);
    tYj = locale1;
    e locale2 = new e("FEED_TIMELINE_ALL", 1, 0);
    tYk = locale2;
    e locale3 = new e("FEED_TIMELINE_FRIEND", 2, 1);
    tYl = locale3;
    e locale4 = new e("FEED_TIMELINE_LBS", 3, 2);
    tYm = locale4;
    e locale5 = new e("FEED_NEARBY_LIVE", 4, 1001);
    tYn = locale5;
    e locale6 = new e("FEED_TIMELINE_FOLLOW", 5, 3);
    tYo = locale6;
    e locale7 = new e("FEED_TIMELINE_MACHINE", 6, 4);
    tYp = locale7;
    e locale8 = new e("FEED_PROFILE", 7, 100);
    tYq = locale8;
    e locale9 = new e("FEED_PROFILE_TIMELINE", 8, 101);
    tYr = locale9;
    e locale10 = new e("FEED_LIKED_TIMELINE", 9, 102);
    tYs = locale10;
    e locale11 = new e("FEED_RETRANSMIT_SOURCE", 10, 103);
    tYt = locale11;
    e locale12 = new e("FEED_TOPIC_TIMELINE", 11, 104);
    tYu = locale12;
    e locale13 = new e("FEED_FAV_LIST", 12, 105);
    tYv = locale13;
    e locale14 = new e("FEED_FOLDED_LIST", 13, 106);
    tYw = locale14;
    e locale15 = new e("FEED_FRIEND_LIKE_LIST", 14, 107);
    tYx = locale15;
    e locale16 = new e("FEED_REL_RECOMMEND", 15, 17);
    tYy = locale16;
    e locale17 = new e("FEED_AT_TIMELINE", 16, 18);
    tYz = locale17;
    tYA = new e[] { locale1, locale2, locale3, locale4, locale5, locale6, locale7, locale8, locale9, locale10, locale11, locale12, locale13, locale14, locale15, locale16, locale17 };
    tYB = new a((byte)0);
    AppMethodBeat.o(245022);
  }
  
  private e(int paramInt)
  {
    this.value = paramInt;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene$Companion;", "", "()V", "get", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "value", "", "plugin-finder_release"})
  public static final class a
  {
    public static e IO(int paramInt)
    {
      if (paramInt == e.tYk.value) {
        return e.tYk;
      }
      if (paramInt == e.tYp.value) {
        return e.tYp;
      }
      if (paramInt == e.tYm.value) {
        return e.tYm;
      }
      if (paramInt == e.tYo.value) {
        return e.tYo;
      }
      if (paramInt == e.tYl.value) {
        return e.tYl;
      }
      if (paramInt == e.tYn.value) {
        return e.tYn;
      }
      if (paramInt == e.tYq.value) {
        return e.tYq;
      }
      if (paramInt == e.tYr.value) {
        return e.tYr;
      }
      if (paramInt == e.tYs.value) {
        return e.tYs;
      }
      if (paramInt == e.tYt.value) {
        return e.tYt;
      }
      if (paramInt == e.tYu.value) {
        return e.tYu;
      }
      if (paramInt == e.tYv.value) {
        return e.tYv;
      }
      if (paramInt == e.tYw.value) {
        return e.tYw;
      }
      if (paramInt == e.tYx.value) {
        return e.tYx;
      }
      if (paramInt == e.tYy.value) {
        return e.tYy;
      }
      if (paramInt == e.tYz.value) {
        return e.tYz;
      }
      return e.tYj;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.e
 * JD-Core Version:    0.7.0.1
 */