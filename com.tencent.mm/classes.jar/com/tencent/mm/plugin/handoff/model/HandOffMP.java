package com.tencent.mm.plugin.handoff.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.protocal.protobuf.cru;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.o;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/handoff/model/HandOffMP;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "icon", "", "title", "appID", "appEntryPage", "appUserName", "handOffType", "", "from", "to", "key", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "()V", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getAppEntryPage", "()Ljava/lang/String;", "setAppEntryPage", "(Ljava/lang/String;)V", "getAppID", "setAppID", "getAppUserName", "setAppUserName", "getIcon", "setIcon", "getTitle", "setTitle", "body", "copy", "describeContents", "doCreateBallInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "doCreateMultiTaskInfo", "Lkotlin/Pair;", "Lcom/tencent/mm/protocal/protobuf/MultiTaskShowData;", "", "getDataType", "toString", "update", "", "newHandOff", "writeToParcel", "dest", "flags", "Companion", "api-handoff_release"})
@Keep
public class HandOffMP
  extends HandOff
{
  public static final Parcelable.Creator<HandOffMP> CREATOR;
  public static final HandOffMP.a Companion;
  private String appEntryPage;
  private String appID;
  private String appUserName;
  private String icon;
  private String title;
  
  static
  {
    AppMethodBeat.i(121729);
    Companion = new HandOffMP.a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(121729);
  }
  
  public HandOffMP()
  {
    this("", "", "", "", "", 0, null, null, null, 480, null);
  }
  
  public HandOffMP(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(121728);
    String str = paramParcel.readString();
    if (str == null) {
      p.hyc();
    }
    this.icon = str;
    str = paramParcel.readString();
    if (str == null) {
      p.hyc();
    }
    this.title = str;
    str = paramParcel.readString();
    if (str == null) {
      p.hyc();
    }
    this.appID = str;
    str = paramParcel.readString();
    if (str == null) {
      p.hyc();
    }
    this.appEntryPage = str;
    paramParcel = paramParcel.readString();
    if (paramParcel == null) {
      p.hyc();
    }
    this.appUserName = paramParcel;
    AppMethodBeat.o(121728);
  }
  
  public HandOffMP(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this(paramString1, paramString2, paramString3, paramString4, paramString5, 0, null, null, null, 480, null);
  }
  
  public HandOffMP(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    this(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt, null, null, null, 448, null);
    AppMethodBeat.i(121727);
    AppMethodBeat.o(121727);
  }
  
  public HandOffMP(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6)
  {
    this(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt, paramString6, null, null, 384, null);
  }
  
  public HandOffMP(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6, String paramString7)
  {
    this(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt, paramString6, paramString7, null, 256, null);
  }
  
  public HandOffMP(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6, String paramString7, String paramString8)
  {
    super(paramInt, paramString6, paramString7, paramString8, null, 0L, 48, null);
    AppMethodBeat.i(121726);
    this.icon = paramString1;
    this.title = paramString2;
    this.appID = paramString3;
    this.appEntryPage = paramString4;
    this.appUserName = paramString5;
    AppMethodBeat.o(121726);
  }
  
  protected String body()
  {
    AppMethodBeat.i(121722);
    String str = n.buv("\n        <icon>" + a.du(this.icon) + "</icon>\n        <title>" + a.du(this.title) + "</title>\n        <appid>" + a.du(this.appID) + "</appid>\n        <appentrypage>" + a.du(this.appEntryPage) + "</appentrypage>\n        <appusername>" + a.du(this.appUserName) + "</appusername>\n    ");
    AppMethodBeat.o(121722);
    return str;
  }
  
  public HandOff copy()
  {
    AppMethodBeat.i(121724);
    Object localObject = new HandOffMP(this.icon, this.title, this.appID, this.appEntryPage, this.appUserName, getHandOffType(), getFrom(), getTo(), getKey());
    ((HandOffMP)localObject).setId(getId());
    localObject = (HandOff)localObject;
    AppMethodBeat.o(121724);
    return localObject;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  protected BallInfo doCreateBallInfo()
  {
    return null;
  }
  
  protected o<cru, byte[]> doCreateMultiTaskInfo()
  {
    return null;
  }
  
  public final String getAppEntryPage()
  {
    return this.appEntryPage;
  }
  
  public final String getAppID()
  {
    return this.appID;
  }
  
  public final String getAppUserName()
  {
    return this.appUserName;
  }
  
  public int getDataType()
  {
    return 3;
  }
  
  public final String getIcon()
  {
    return this.icon;
  }
  
  public final String getTitle()
  {
    return this.title;
  }
  
  public final void setAppEntryPage(String paramString)
  {
    AppMethodBeat.i(238057);
    p.h(paramString, "<set-?>");
    this.appEntryPage = paramString;
    AppMethodBeat.o(238057);
  }
  
  public final void setAppID(String paramString)
  {
    AppMethodBeat.i(238056);
    p.h(paramString, "<set-?>");
    this.appID = paramString;
    AppMethodBeat.o(238056);
  }
  
  public final void setAppUserName(String paramString)
  {
    AppMethodBeat.i(238058);
    p.h(paramString, "<set-?>");
    this.appUserName = paramString;
    AppMethodBeat.o(238058);
  }
  
  public final void setIcon(String paramString)
  {
    AppMethodBeat.i(238054);
    p.h(paramString, "<set-?>");
    this.icon = paramString;
    AppMethodBeat.o(238054);
  }
  
  public final void setTitle(String paramString)
  {
    AppMethodBeat.i(238055);
    p.h(paramString, "<set-?>");
    this.title = paramString;
    AppMethodBeat.o(238055);
  }
  
  public String toString()
  {
    AppMethodBeat.i(121725);
    String str = "HandOffMP(key='" + getKey() + "', id='" + getId() + "', createTime='" + getCreateTime() + ", icon='" + this.icon + "', title='" + this.title + "', appID='" + this.appID + "', appEntryPage='" + this.appEntryPage + "', appUserName='" + this.appUserName + "')";
    AppMethodBeat.o(121725);
    return str;
  }
  
  public void update(HandOff paramHandOff)
  {
    AppMethodBeat.i(121721);
    p.h(paramHandOff, "newHandOff");
    super.update(paramHandOff);
    if ((paramHandOff instanceof HandOffMP))
    {
      this.icon = ((HandOffMP)paramHandOff).icon;
      this.title = ((HandOffMP)paramHandOff).title;
      this.appID = ((HandOffMP)paramHandOff).appID;
      this.appEntryPage = ((HandOffMP)paramHandOff).appEntryPage;
      this.appUserName = ((HandOffMP)paramHandOff).appUserName;
    }
    AppMethodBeat.o(121721);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(121723);
    p.h(paramParcel, "dest");
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.icon);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.appID);
    paramParcel.writeString(this.appEntryPage);
    paramParcel.writeString(this.appUserName);
    AppMethodBeat.o(121723);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/handoff/model/HandOffMP$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/handoff/model/HandOffMP;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/handoff/model/HandOffMP;", "api-handoff_release"})
  public static final class b
    implements Parcelable.Creator<HandOffMP>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.model.HandOffMP
 * JD-Core Version:    0.7.0.1
 */