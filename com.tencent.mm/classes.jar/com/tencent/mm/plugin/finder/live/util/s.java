package com.tencent.mm.plugin.finder.live.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue;", "", "addAll", "", "collection", "", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftShowInfo;", "clear", "", "getNextGiftType", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftType;", "hasNext", "offer", "giftShowInfo", "peek", "peekByComboId", "comboId", "", "peekByTargetUserName", "targetUserName", "peekNonPrecious", "poll", "pollByComboId", "pollByTargetUserName", "pollNonPrecious", "registerObserver", "observer", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftAddingObserver;", "remove", "resetMsgIdList", "size", "", "unregisterObserver", "GiftAddingObserver", "GiftShowInfo", "GiftType", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface s
{
  public abstract void a(a parama);
  
  public abstract boolean addAll(Collection<s.b> paramCollection);
  
  public abstract s.b axN(String paramString);
  
  public abstract s.b axO(String paramString);
  
  public abstract s.b axQ(String paramString);
  
  public abstract void b(a parama);
  
  public abstract boolean b(s.b paramb);
  
  public abstract boolean c(s.b paramb);
  
  public abstract void clear();
  
  public abstract c euw();
  
  public abstract s.b eux();
  
  public abstract boolean hasNext();
  
  public abstract int size();
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftAddingObserver;", "", "onGiftAdding", "", "giftType", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftType;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(s.c paramc);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftType;", "", "(Ljava/lang/String;I)V", "SELF_PRECIOUS_GIFT_COMBO", "SELF_PRECIOUS_GIFT_SOLO", "SELF_NORMAL_GIFT_COMBO", "SELF_NORMAL_GIFT_SOLO", "PRECIOUS_GIFT_COMBO", "PRECIOUS_GIFT_SOLO", "NORMAL_GIFT_COMBO", "NORMAL_GIFT_SOLO", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum c
  {
    static
    {
      AppMethodBeat.i(351370);
      DJq = new c("SELF_PRECIOUS_GIFT_COMBO", 0);
      DJr = new c("SELF_PRECIOUS_GIFT_SOLO", 1);
      DJs = new c("SELF_NORMAL_GIFT_COMBO", 2);
      DJt = new c("SELF_NORMAL_GIFT_SOLO", 3);
      DJu = new c("PRECIOUS_GIFT_COMBO", 4);
      DJv = new c("PRECIOUS_GIFT_SOLO", 5);
      DJw = new c("NORMAL_GIFT_COMBO", 6);
      DJx = new c("NORMAL_GIFT_SOLO", 7);
      DJy = new c[] { DJq, DJr, DJs, DJt, DJu, DJv, DJw, DJx };
      AppMethodBeat.o(351370);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.util.s
 * JD-Core Version:    0.7.0.1
 */