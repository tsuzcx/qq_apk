package com.tencent.mm.plugin.finder.live.utils.fake;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/utils/fake/GiftType;", "", "id", "", "giftName", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getGiftName", "()Ljava/lang/String;", "getId", "LOVE", "CHEERS", "BARBECUE", "HEYTEA", "OX", "ROCKET", "STAR", "ISLAND", "HUGHUG", "BALLOON", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum e
{
  final String DKv;
  final String id;
  
  static
  {
    AppMethodBeat.i(351094);
    DKw = new e("LOVE", 0, "MMFinderLiveGift100001", "爱心");
    DKx = new e("CHEERS", 1, "MMFinderLiveGift100002", "干杯");
    DKy = new e("BARBECUE", 2, "MMFinderLiveGift100003", "撸串");
    DKz = new e("HEYTEA", 3, "MMFinderLiveGift100004", "奶茶");
    DKA = new e("OX", 4, "MMFinderLiveGift100013_special", "牛气冲天");
    DKB = new e("ROCKET", 5, "MMFinderLiveGift100006", "火箭");
    DKC = new e("STAR", 6, "MMFinderLiveGift100014_special", "摘星星");
    DKD = new e("ISLAND", 7, "MMFinderLiveGift100007", "桃花岛");
    DKE = new e("HUGHUG", 8, "MMFinderLiveGift100015", "抱抱");
    DKF = new e("BALLOON", 9, "MMFinderLiveGift100016", "告白气球");
    DKG = new e[] { DKw, DKx, DKy, DKz, DKA, DKB, DKC, DKD, DKE, DKF };
    AppMethodBeat.o(351094);
  }
  
  private e(String paramString1, String paramString2)
  {
    this.id = paramString1;
    this.DKv = paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.utils.fake.e
 * JD-Core Version:    0.7.0.1
 */