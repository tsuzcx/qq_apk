package com.tencent.mm.plugin.finder.feed.model.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "FEED_DEFAULT", "FEED_TIMELINE_ALL", "FEED_TIMELINE_FRIEND", "FEED_TIMELINE_LBS", "FEED_TIMELINE_FOLLOW", "FEED_TIMELINE_MACHINE", "FEED_PROFILE", "FEED_PROFILE_TIMELINE", "FEED_LIKED_TIMELINE", "FEED_RETRANSMIT_SOURCE", "FEED_TOPIC_TIMELINE", "FEED_FAV_LIST", "FEED_FOLDED_LIST", "FEED_FRIEND_LIKE_LIST", "FEED_REL_RECOMMEND", "FEED_AT_TIMELINE", "Companion", "plugin-finder_release"})
public enum c
{
  public static final a roo;
  public final int value;
  
  static
  {
    AppMethodBeat.i(202261);
    c localc1 = new c("FEED_DEFAULT", 0, -1);
    rnX = localc1;
    c localc2 = new c("FEED_TIMELINE_ALL", 1, 0);
    rnY = localc2;
    c localc3 = new c("FEED_TIMELINE_FRIEND", 2, 1);
    rnZ = localc3;
    c localc4 = new c("FEED_TIMELINE_LBS", 3, 2);
    roa = localc4;
    c localc5 = new c("FEED_TIMELINE_FOLLOW", 4, 3);
    rob = localc5;
    c localc6 = new c("FEED_TIMELINE_MACHINE", 5, 4);
    roc = localc6;
    c localc7 = new c("FEED_PROFILE", 6, 100);
    rod = localc7;
    c localc8 = new c("FEED_PROFILE_TIMELINE", 7, 101);
    roe = localc8;
    c localc9 = new c("FEED_LIKED_TIMELINE", 8, 102);
    rof = localc9;
    c localc10 = new c("FEED_RETRANSMIT_SOURCE", 9, 103);
    rog = localc10;
    c localc11 = new c("FEED_TOPIC_TIMELINE", 10, 104);
    roh = localc11;
    c localc12 = new c("FEED_FAV_LIST", 11, 105);
    roi = localc12;
    c localc13 = new c("FEED_FOLDED_LIST", 12, 106);
    roj = localc13;
    c localc14 = new c("FEED_FRIEND_LIKE_LIST", 13, 107);
    rok = localc14;
    c localc15 = new c("FEED_REL_RECOMMEND", 14, 17);
    rol = localc15;
    c localc16 = new c("FEED_AT_TIMELINE", 15, 18);
    rom = localc16;
    ron = new c[] { localc1, localc2, localc3, localc4, localc5, localc6, localc7, localc8, localc9, localc10, localc11, localc12, localc13, localc14, localc15, localc16 };
    roo = new a((byte)0);
    AppMethodBeat.o(202261);
  }
  
  private c(int paramInt)
  {
    this.value = paramInt;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene$Companion;", "", "()V", "get", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "value", "", "plugin-finder_release"})
  public static final class a
  {
    public static c DJ(int paramInt)
    {
      if (paramInt == c.rnY.value) {
        return c.rnY;
      }
      if (paramInt == c.roc.value) {
        return c.roc;
      }
      if (paramInt == c.roa.value) {
        return c.roa;
      }
      if (paramInt == c.rob.value) {
        return c.rob;
      }
      if (paramInt == c.rnZ.value) {
        return c.rnZ;
      }
      if (paramInt == c.rod.value) {
        return c.rod;
      }
      if (paramInt == c.roe.value) {
        return c.roe;
      }
      if (paramInt == c.rof.value) {
        return c.rof;
      }
      if (paramInt == c.rog.value) {
        return c.rog;
      }
      if (paramInt == c.roh.value) {
        return c.roh;
      }
      if (paramInt == c.roi.value) {
        return c.roi;
      }
      if (paramInt == c.roj.value) {
        return c.roj;
      }
      if (paramInt == c.rok.value) {
        return c.rok;
      }
      if (paramInt == c.rol.value) {
        return c.rol;
      }
      if (paramInt == c.rom.value) {
        return c.rom;
      }
      return c.rnX;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.c
 * JD-Core Version:    0.7.0.1
 */