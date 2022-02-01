package com.tencent.mm.plugin.finder.feed.model.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "FEED_DEFAULT", "FEED_TIMELINE_ALL", "FEED_TIMELINE_FRIEND", "FEED_TIMELINE_LBS", "FEED_NEARBY_LIVE", "FEED_TIMELINE_FOLLOW", "FEED_TIMELINE_MACHINE", "FEED_PROFILE", "FEED_PROFILE_TIMELINE", "FEED_LIKED_TIMELINE", "FEED_RETRANSMIT_SOURCE", "FEED_TOPIC_TIMELINE", "FEED_FAV_LIST", "FEED_FOLDED_LIST", "FEED_FRIEND_LIKE_LIST", "SELF_FEED_PROFILE", "SELF_FEED_FULL_PROFILE", "SELF_FEED_AT_MANAGER", "FEED_REL_RECOMMEND", "FEED_AT_TIMELINE", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum g
{
  public static final a Bkb;
  public final int value;
  
  static
  {
    AppMethodBeat.i(366607);
    Bkc = new g("FEED_DEFAULT", 0, -1);
    Bkd = new g("FEED_TIMELINE_ALL", 1, 0);
    Bke = new g("FEED_TIMELINE_FRIEND", 2, 1);
    Bkf = new g("FEED_TIMELINE_LBS", 3, 2);
    Bkg = new g("FEED_NEARBY_LIVE", 4, 1001);
    Bkh = new g("FEED_TIMELINE_FOLLOW", 5, 3);
    Bki = new g("FEED_TIMELINE_MACHINE", 6, 4);
    Bkj = new g("FEED_PROFILE", 7, 100);
    Bkk = new g("FEED_PROFILE_TIMELINE", 8, 101);
    Bkl = new g("FEED_LIKED_TIMELINE", 9, 102);
    Bkm = new g("FEED_RETRANSMIT_SOURCE", 10, 103);
    Bkn = new g("FEED_TOPIC_TIMELINE", 11, 104);
    Bko = new g("FEED_FAV_LIST", 12, 105);
    Bkp = new g("FEED_FOLDED_LIST", 13, 106);
    Bkq = new g("FEED_FRIEND_LIKE_LIST", 14, 107);
    Bkr = new g("SELF_FEED_PROFILE", 15, 108);
    Bks = new g("SELF_FEED_FULL_PROFILE", 16, 109);
    Bkt = new g("SELF_FEED_AT_MANAGER", 17, 200);
    Bku = new g("FEED_REL_RECOMMEND", 18, 17);
    Bkv = new g("FEED_AT_TIMELINE", 19, 18);
    Bkw = new g[] { Bkc, Bkd, Bke, Bkf, Bkg, Bkh, Bki, Bkj, Bkk, Bkl, Bkm, Bkn, Bko, Bkp, Bkq, Bkr, Bks, Bkt, Bku, Bkv };
    Bkb = new a((byte)0);
    AppMethodBeat.o(366607);
  }
  
  private g(int paramInt)
  {
    this.value = paramInt;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene$Companion;", "", "()V", "get", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "value", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static g Od(int paramInt)
    {
      if (paramInt == g.Bkd.value) {
        return g.Bkd;
      }
      if (paramInt == g.Bki.value) {
        return g.Bki;
      }
      if (paramInt == g.Bkf.value) {
        return g.Bkf;
      }
      if (paramInt == g.Bkh.value) {
        return g.Bkh;
      }
      if (paramInt == g.Bke.value) {
        return g.Bke;
      }
      if (paramInt == g.Bkg.value) {
        return g.Bkg;
      }
      if (paramInt == g.Bkj.value) {
        return g.Bkj;
      }
      if (paramInt == g.Bkk.value) {
        return g.Bkk;
      }
      if (paramInt == g.Bkl.value) {
        return g.Bkl;
      }
      if (paramInt == g.Bkm.value) {
        return g.Bkm;
      }
      if (paramInt == g.Bkn.value) {
        return g.Bkn;
      }
      if (paramInt == g.Bko.value) {
        return g.Bko;
      }
      if (paramInt == g.Bkp.value) {
        return g.Bkp;
      }
      if (paramInt == g.Bkq.value) {
        return g.Bkq;
      }
      if (paramInt == g.Bku.value) {
        return g.Bku;
      }
      if (paramInt == g.Bkv.value) {
        return g.Bkv;
      }
      return g.Bkc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.g
 * JD-Core Version:    0.7.0.1
 */