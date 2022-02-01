package com.tencent.mm.plugin.gamelive.event;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelive/event/GameLiveAppbrandEventService$LiveTopicPayload;", "Landroid/os/Parcelable;", "topic", "", "ret", "", "errMsg", "(Ljava/lang/String;ZLjava/lang/String;)V", "getErrMsg", "()Ljava/lang/String;", "setErrMsg", "(Ljava/lang/String;)V", "getRet", "()Z", "setRet", "(Z)V", "getTopic", "setTopic", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-gamelive_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class GameLiveAppbrandEventService$LiveTopicPayload
  implements Parcelable
{
  public static final Parcelable.Creator<LiveTopicPayload> CREATOR;
  public String errMsg;
  public boolean hCQ;
  public String topic;
  
  static
  {
    AppMethodBeat.i(277376);
    CREATOR = (Parcelable.Creator)new a();
    AppMethodBeat.o(277376);
  }
  
  public GameLiveAppbrandEventService$LiveTopicPayload(String paramString1, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(277371);
    this.topic = paramString1;
    this.hCQ = paramBoolean;
    this.errMsg = paramString2;
    AppMethodBeat.o(277371);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(277397);
    if (this == paramObject)
    {
      AppMethodBeat.o(277397);
      return true;
    }
    if (!(paramObject instanceof LiveTopicPayload))
    {
      AppMethodBeat.o(277397);
      return false;
    }
    paramObject = (LiveTopicPayload)paramObject;
    if (!s.p(this.topic, paramObject.topic))
    {
      AppMethodBeat.o(277397);
      return false;
    }
    if (this.hCQ != paramObject.hCQ)
    {
      AppMethodBeat.o(277397);
      return false;
    }
    if (!s.p(this.errMsg, paramObject.errMsg))
    {
      AppMethodBeat.o(277397);
      return false;
    }
    AppMethodBeat.o(277397);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(277381);
    String str = "LiveTopicPayload(topic=" + this.topic + ", ret=" + this.hCQ + ", errMsg=" + this.errMsg + ')';
    AppMethodBeat.o(277381);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(277410);
    s.u(paramParcel, "out");
    paramParcel.writeString(this.topic);
    if (this.hCQ) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.errMsg);
      AppMethodBeat.o(277410);
      return;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<GameLiveAppbrandEventService.LiveTopicPayload>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelive.event.GameLiveAppbrandEventService.LiveTopicPayload
 * JD-Core Version:    0.7.0.1
 */