package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class MomentsTogetherTailActionStruct
  extends a
{
  private a iVe;
  private long iVf;
  private String iVg = "";
  private String iVh = "";
  private long ilj;
  
  public final String aIE()
  {
    AppMethodBeat.i(368371);
    Object localObject = new StringBuffer();
    if (this.iVe != null) {}
    for (int i = this.iVe.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.iVf);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ilj);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.iVg);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.iVh);
      localObject = ((StringBuffer)localObject).toString();
      aUm((String)localObject);
      AppMethodBeat.o(368371);
      return localObject;
    }
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368377);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.iVe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExpoCount:").append(this.iVf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickCount:").append(this.ilj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PublishId:").append(this.iVg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CCUserList:").append(this.iVh);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368377);
    return localObject;
  }
  
  public final int getId()
  {
    return 24784;
  }
  
  public final MomentsTogetherTailActionStruct setCCUserList(String paramString)
  {
    AppMethodBeat.i(368363);
    this.iVh = F("CCUserList", paramString, true);
    AppMethodBeat.o(368363);
    return this;
  }
  
  public final MomentsTogetherTailActionStruct setClickCount(long paramLong)
  {
    this.ilj = paramLong;
    return this;
  }
  
  public final MomentsTogetherTailActionStruct setExpoCount(long paramLong)
  {
    this.iVf = paramLong;
    return this;
  }
  
  public final MomentsTogetherTailActionStruct setPublishId(String paramString)
  {
    AppMethodBeat.i(368358);
    this.iVg = F("PublishId", paramString, true);
    AppMethodBeat.o(368358);
    return this;
  }
  
  public final MomentsTogetherTailActionStruct setScene(a parama)
  {
    this.iVe = parama;
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(368336);
      iVi = new a("timeline", 0, 1);
      iVj = new a("feed", 1, 2);
      iVk = new a[] { iVi, iVj };
      AppMethodBeat.o(368336);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.MomentsTogetherTailActionStruct
 * JD-Core Version:    0.7.0.1
 */