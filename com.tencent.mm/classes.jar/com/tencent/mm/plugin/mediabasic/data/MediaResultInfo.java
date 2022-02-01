package com.tencent.mm.plugin.mediabasic.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mediabasic/data/MediaResultInfo;", "Landroid/os/Parcelable;", "result", "", "mediaList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/mediabasic/data/MediaSingleInfo;", "Lkotlin/collections/ArrayList;", "extra", "Landroid/os/Bundle;", "(ZLjava/util/ArrayList;Landroid/os/Bundle;)V", "getExtra", "()Landroid/os/Bundle;", "setExtra", "(Landroid/os/Bundle;)V", "getMediaList", "()Ljava/util/ArrayList;", "setMediaList", "(Ljava/util/ArrayList;)V", "getResult", "()Z", "setResult", "(Z)V", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "other", "", "hashCode", "isVideoData", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "plugin-basic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MediaResultInfo
  implements Parcelable
{
  public static final Parcelable.Creator<MediaResultInfo> CREATOR;
  public static final a KOL;
  private Bundle oSS;
  public ArrayList<MediaSingleInfo> ofu;
  public boolean result;
  
  static
  {
    AppMethodBeat.i(269613);
    KOL = new a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(269613);
  }
  
  public MediaResultInfo(boolean paramBoolean, ArrayList<MediaSingleInfo> paramArrayList, Bundle paramBundle)
  {
    AppMethodBeat.i(269609);
    this.result = paramBoolean;
    this.ofu = paramArrayList;
    this.oSS = paramBundle;
    AppMethodBeat.o(269609);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(269626);
    if (this == paramObject)
    {
      AppMethodBeat.o(269626);
      return true;
    }
    if (!(paramObject instanceof MediaResultInfo))
    {
      AppMethodBeat.o(269626);
      return false;
    }
    paramObject = (MediaResultInfo)paramObject;
    if (this.result != paramObject.result)
    {
      AppMethodBeat.o(269626);
      return false;
    }
    if (!s.p(this.ofu, paramObject.ofu))
    {
      AppMethodBeat.o(269626);
      return false;
    }
    if (!s.p(this.oSS, paramObject.oSS))
    {
      AppMethodBeat.o(269626);
      return false;
    }
    AppMethodBeat.o(269626);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(269616);
    String str = "MediaResultInfo(result=" + this.result + ", mediaList=" + this.ofu + ", extra=" + this.oSS + ')';
    AppMethodBeat.o(269616);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(269639);
    s.u(paramParcel, "out");
    if (this.result) {}
    for (int i = 1;; i = 0)
    {
      paramParcel.writeInt(i);
      Object localObject = this.ofu;
      paramParcel.writeInt(((ArrayList)localObject).size());
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((MediaSingleInfo)((Iterator)localObject).next()).writeToParcel(paramParcel, paramInt);
      }
    }
    paramParcel.writeBundle(this.oSS);
    AppMethodBeat.o(269639);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mediabasic/data/MediaResultInfo$Companion;", "", "()V", "getFailResultInfo", "Lcom/tencent/mm/plugin/mediabasic/data/MediaResultInfo;", "plugin-basic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static MediaResultInfo gaG()
    {
      AppMethodBeat.i(269608);
      MediaResultInfo localMediaResultInfo = new MediaResultInfo(false, new ArrayList());
      AppMethodBeat.o(269608);
      return localMediaResultInfo;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Parcelable.Creator<MediaResultInfo>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mediabasic.data.MediaResultInfo
 * JD-Core Version:    0.7.0.1
 */