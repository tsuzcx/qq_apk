package com.tencent.mm.plugin.findersdk.a;

import com.tencent.mm.plugin.finder.storage.FeedData;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/api/IFinderLiveFeedDecorator;", "", "checkLinkMicMode", "", "videoW", "", "videoH", "handleSeiMessage", "seiData", "", "onVideoPlayBegin", "resetSeiData", "setFeedData", "feedData", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "setLinkMicCallback", "newCallback", "Lkotlin/Function1;", "", "", "Lkotlin/ParameterName;", "name", "micUserList", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface ao
{
  public abstract void a(FeedData paramFeedData);
  
  public abstract void aj(b<? super List<String>, ah> paramb);
  
  public abstract void bT(byte[] paramArrayOfByte);
  
  public abstract void eck();
  
  public abstract void ecl();
  
  public abstract void hu(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.a.ao
 * JD-Core Version:    0.7.0.1
 */