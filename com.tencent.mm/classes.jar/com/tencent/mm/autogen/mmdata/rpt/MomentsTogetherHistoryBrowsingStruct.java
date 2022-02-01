package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class MomentsTogetherHistoryBrowsingStruct
  extends a
{
  private long iOd;
  private long iUQ;
  private int iUR;
  private long iUS;
  private long iUT;
  private long iUU;
  private long iUV;
  private long iUW;
  private long iUX;
  private String iUY = "";
  private MomentsTogetherHistoryBrowsingStruct.a iUZ;
  private String iVa = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368598);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iUQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iUR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iUS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iUT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iUU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iUV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iUW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iUX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iUY);
    ((StringBuffer)localObject).append(",");
    if (this.iUZ != null) {}
    for (int i = this.iUZ.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.iVa);
      localObject = ((StringBuffer)localObject).toString();
      aUm((String)localObject);
      AppMethodBeat.o(368598);
      return localObject;
    }
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368609);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("IfRedDot:").append(this.iUQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Source:").append(this.iOd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OwnerSetting:").append(this.iUR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WithFriendFeedCount:").append(this.iUS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WithFriendExtraFeedCount:").append(this.iUT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WithFriendFeedTime:").append(this.iUU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WithFriendGalleryCount:").append(this.iUV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WithFriendDetailCount:").append(this.iUW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WithFriendDetailTime:").append(this.iUX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WithFriendDetailAction:").append(this.iUY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsClickFriendList:").append(this.iUZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PageOwnerUsername:").append(this.iVa);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368609);
    return localObject;
  }
  
  public final int getId()
  {
    return 24777;
  }
  
  public final MomentsTogetherHistoryBrowsingStruct setIfRedDot(long paramLong)
  {
    this.iUQ = paramLong;
    return this;
  }
  
  public final MomentsTogetherHistoryBrowsingStruct setIsClickFriendList(MomentsTogetherHistoryBrowsingStruct.a parama)
  {
    this.iUZ = parama;
    return this;
  }
  
  public final MomentsTogetherHistoryBrowsingStruct setOwnerSetting(int paramInt)
  {
    this.iUR = paramInt;
    return this;
  }
  
  public final MomentsTogetherHistoryBrowsingStruct setPageOwnerUsername(String paramString)
  {
    AppMethodBeat.i(368587);
    this.iVa = F("PageOwnerUsername", paramString, true);
    AppMethodBeat.o(368587);
    return this;
  }
  
  public final MomentsTogetherHistoryBrowsingStruct setSource(long paramLong)
  {
    this.iOd = paramLong;
    return this;
  }
  
  public final MomentsTogetherHistoryBrowsingStruct setWithFriendDetailAction(String paramString)
  {
    AppMethodBeat.i(368577);
    this.iUY = F("WithFriendDetailAction", paramString, true);
    AppMethodBeat.o(368577);
    return this;
  }
  
  public final MomentsTogetherHistoryBrowsingStruct setWithFriendDetailCount(long paramLong)
  {
    this.iUW = paramLong;
    return this;
  }
  
  public final MomentsTogetherHistoryBrowsingStruct setWithFriendDetailTime(long paramLong)
  {
    this.iUX = paramLong;
    return this;
  }
  
  public final MomentsTogetherHistoryBrowsingStruct setWithFriendExtraFeedCount(long paramLong)
  {
    this.iUT = paramLong;
    return this;
  }
  
  public final MomentsTogetherHistoryBrowsingStruct setWithFriendFeedCount(long paramLong)
  {
    this.iUS = paramLong;
    return this;
  }
  
  public final MomentsTogetherHistoryBrowsingStruct setWithFriendFeedTime(long paramLong)
  {
    this.iUU = paramLong;
    return this;
  }
  
  public final MomentsTogetherHistoryBrowsingStruct setWithFriendGalleryCount(long paramLong)
  {
    this.iUV = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.MomentsTogetherHistoryBrowsingStruct
 * JD-Core Version:    0.7.0.1
 */