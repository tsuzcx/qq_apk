package com.tencent.mm.plugin.finder.live.utils.fake;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/utils/fake/GiftType;", "", "id", "", "giftName", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getGiftName", "()Ljava/lang/String;", "getId", "LOVE", "CHEERS", "BARBECUE", "HEYTEA", "OX", "ROCKET", "STAR", "ISLAND", "plugin-finder_release"})
public enum e
{
  final String id;
  final String ySp;
  
  static
  {
    AppMethodBeat.i(271010);
    e locale1 = new e("LOVE", 0, "MMFinderLiveGift100001", "爱心");
    ySg = locale1;
    e locale2 = new e("CHEERS", 1, "MMFinderLiveGift100002", "干杯");
    ySh = locale2;
    e locale3 = new e("BARBECUE", 2, "MMFinderLiveGift100003", "撸串");
    ySi = locale3;
    e locale4 = new e("HEYTEA", 3, "MMFinderLiveGift100004", "奶茶");
    ySj = locale4;
    e locale5 = new e("OX", 4, "MMFinderLiveGift100013_special", "牛气冲天");
    ySk = locale5;
    e locale6 = new e("ROCKET", 5, "MMFinderLiveGift100006", "火箭");
    ySl = locale6;
    e locale7 = new e("STAR", 6, "MMFinderLiveGift100014_special", "摘星星");
    ySm = locale7;
    e locale8 = new e("ISLAND", 7, "MMFinderLiveGift100007", "桃花岛");
    ySn = locale8;
    ySo = new e[] { locale1, locale2, locale3, locale4, locale5, locale6, locale7, locale8 };
    AppMethodBeat.o(271010);
  }
  
  private e(String paramString1, String paramString2)
  {
    this.id = paramString1;
    this.ySp = paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.utils.fake.e
 * JD-Core Version:    0.7.0.1
 */