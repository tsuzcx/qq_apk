package com.tencent.mm.plugin.finder.live.olympic.data;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/olympic/data/OlympicDeliveyData;", "", "shareName", "", "shareHeadUrl", "deliverNumber", "", "finderName", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getDeliverNumber", "()J", "setDeliverNumber", "(J)V", "getFinderName", "()Ljava/lang/String;", "setFinderName", "(Ljava/lang/String;)V", "getShareHeadUrl", "setShareHeadUrl", "getShareName", "setShareName", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "isValid", "toString", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a CRu;
  public String CRv;
  private long CRw;
  public String CRx;
  public String eoT;
  
  static
  {
    AppMethodBeat.i(360818);
    CRu = new a((byte)0);
    AppMethodBeat.o(360818);
  }
  
  public a(String paramString1, String paramString2, long paramLong, String paramString3)
  {
    this.eoT = paramString1;
    this.CRv = paramString2;
    this.CRw = paramLong;
    this.CRx = paramString3;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(360838);
    if (this == paramObject)
    {
      AppMethodBeat.o(360838);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(360838);
      return false;
    }
    paramObject = (a)paramObject;
    if (!s.p(this.eoT, paramObject.eoT))
    {
      AppMethodBeat.o(360838);
      return false;
    }
    if (!s.p(this.CRv, paramObject.CRv))
    {
      AppMethodBeat.o(360838);
      return false;
    }
    if (this.CRw != paramObject.CRw)
    {
      AppMethodBeat.o(360838);
      return false;
    }
    if (!s.p(this.CRx, paramObject.CRx))
    {
      AppMethodBeat.o(360838);
      return false;
    }
    AppMethodBeat.o(360838);
    return true;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(360830);
    int i;
    int j;
    label25:
    int m;
    if (this.eoT == null)
    {
      i = 0;
      if (this.CRv != null) {
        break label75;
      }
      j = 0;
      m = q.a..ExternalSyntheticBackport0.m(this.CRw);
      if (this.CRx != null) {
        break label86;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(360830);
      return ((j + i * 31) * 31 + m) * 31 + k;
      i = this.eoT.hashCode();
      break;
      label75:
      j = this.CRv.hashCode();
      break label25;
      label86:
      k = this.CRx.hashCode();
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(360824);
    String str = "OlympicDeliveyData(shareName=" + this.eoT + ", shareHeadUrl=" + this.CRv + ", deliverNumber=" + this.CRw + ", finderName=" + this.CRx + ')';
    AppMethodBeat.o(360824);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/olympic/data/OlympicDeliveyData$Companion;", "", "()V", "convertOlympicDeliveyData", "Lcom/tencent/mm/plugin/finder/live/olympic/data/OlympicDeliveyData;", "data", "Lcom/tencent/mm/protocal/protobuf/FinderOlympicLiveFireAuthorInfo;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.olympic.data.a
 * JD-Core Version:    0.7.0.1
 */