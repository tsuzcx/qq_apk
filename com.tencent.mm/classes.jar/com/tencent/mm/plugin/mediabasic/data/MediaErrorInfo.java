package com.tencent.mm.plugin.mediabasic.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mediabasic/data/MediaErrorInfo;", "Landroid/os/Parcelable;", "status", "Lcom/tencent/mm/plugin/mediabasic/data/MediaStatusCode;", "errorCode", "", "errorMsg", "", "extra", "Landroid/os/Bundle;", "(Lcom/tencent/mm/plugin/mediabasic/data/MediaStatusCode;ILjava/lang/String;Landroid/os/Bundle;)V", "getErrorCode", "()I", "getErrorMsg", "()Ljava/lang/String;", "setErrorMsg", "(Ljava/lang/String;)V", "getExtra", "()Landroid/os/Bundle;", "setExtra", "(Landroid/os/Bundle;)V", "getStatus", "()Lcom/tencent/mm/plugin/mediabasic/data/MediaStatusCode;", "setStatus", "(Lcom/tencent/mm/plugin/mediabasic/data/MediaStatusCode;)V", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", "other", "", "hashCode", "ignore", "success", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "plugin-basic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MediaErrorInfo
  implements Parcelable
{
  public static final Parcelable.Creator<MediaErrorInfo> CREATOR;
  public static final a KOF;
  public d KOG;
  private final int errorCode;
  private String errorMsg;
  private Bundle oSS;
  
  static
  {
    AppMethodBeat.i(269625);
    KOF = new a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(269625);
  }
  
  public MediaErrorInfo(d paramd, int paramInt, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(269615);
    this.KOG = paramd;
    this.errorCode = paramInt;
    this.errorMsg = paramString;
    this.oSS = paramBundle;
    AppMethodBeat.o(269615);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(269646);
    if (this == paramObject)
    {
      AppMethodBeat.o(269646);
      return true;
    }
    if (!(paramObject instanceof MediaErrorInfo))
    {
      AppMethodBeat.o(269646);
      return false;
    }
    paramObject = (MediaErrorInfo)paramObject;
    if (this.KOG != paramObject.KOG)
    {
      AppMethodBeat.o(269646);
      return false;
    }
    if (this.errorCode != paramObject.errorCode)
    {
      AppMethodBeat.o(269646);
      return false;
    }
    if (!s.p(this.errorMsg, paramObject.errorMsg))
    {
      AppMethodBeat.o(269646);
      return false;
    }
    if (!s.p(this.oSS, paramObject.oSS))
    {
      AppMethodBeat.o(269646);
      return false;
    }
    AppMethodBeat.o(269646);
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(269637);
    int k = this.KOG.hashCode();
    int m = this.errorCode;
    int i;
    if (this.errorMsg == null)
    {
      i = 0;
      if (this.oSS != null) {
        break label71;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(269637);
      return (i + (k * 31 + m) * 31) * 31 + j;
      i = this.errorMsg.hashCode();
      break;
      label71:
      j = this.oSS.hashCode();
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(269629);
    String str = "MediaErrorInfo(status=" + this.KOG + ", errorCode=" + this.errorCode + ", errorMsg=" + this.errorMsg + ", extra=" + this.oSS + ')';
    AppMethodBeat.o(269629);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(269654);
    s.u(paramParcel, "out");
    paramParcel.writeString(this.KOG.name());
    paramParcel.writeInt(this.errorCode);
    paramParcel.writeString(this.errorMsg);
    paramParcel.writeBundle(this.oSS);
    AppMethodBeat.o(269654);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mediabasic/data/MediaErrorInfo$Companion;", "", "()V", "makeErrorInfo", "Lcom/tencent/mm/plugin/mediabasic/data/MediaErrorInfo;", "errorCode", "", "errorMsg", "", "makeIgnoreInfo", "plugin-basic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static MediaErrorInfo cn(int paramInt, String paramString)
    {
      AppMethodBeat.i(269644);
      if (paramInt == 0) {}
      for (d locald = d.KOQ;; locald = d.KOP)
      {
        paramString = new MediaErrorInfo(locald, paramInt, paramString, 8);
        AppMethodBeat.o(269644);
        return paramString;
      }
    }
    
    public static MediaErrorInfo gaF()
    {
      AppMethodBeat.i(269634);
      MediaErrorInfo localMediaErrorInfo = new MediaErrorInfo(d.KOR, 0, null, 12);
      AppMethodBeat.o(269634);
      return localMediaErrorInfo;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Parcelable.Creator<MediaErrorInfo>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mediabasic.data.MediaErrorInfo
 * JD-Core Version:    0.7.0.1
 */