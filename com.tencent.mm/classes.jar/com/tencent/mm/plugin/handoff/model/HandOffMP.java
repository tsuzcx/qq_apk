package com.tencent.mm.plugin.handoff.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.protocal.protobuf.drz;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/handoff/model/HandOffMP;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "icon", "", "title", "appID", "appEntryPage", "appUserName", "handOffType", "", "from", "to", "key", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "()V", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getAppEntryPage", "()Ljava/lang/String;", "setAppEntryPage", "(Ljava/lang/String;)V", "getAppID", "setAppID", "getAppUserName", "setAppUserName", "getIcon", "setIcon", "getTitle", "setTitle", "body", "copy", "describeContents", "doCreateBallInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "doCreateMultiTaskInfo", "Lkotlin/Pair;", "Lcom/tencent/mm/protocal/protobuf/MultiTaskShowData;", "", "equals", "", "other", "", "getDataType", "hashCode", "toString", "update", "newHandOff", "writeToParcel", "", "dest", "flags", "Companion", "api-handoff_release"}, k=1, mv={1, 5, 1}, xi=48)
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
    s.checkNotNull(str);
    s.s(str, "source.readString()!!");
    this.icon = str;
    str = paramParcel.readString();
    s.checkNotNull(str);
    s.s(str, "source.readString()!!");
    this.title = str;
    str = paramParcel.readString();
    s.checkNotNull(str);
    s.s(str, "source.readString()!!");
    this.appID = str;
    str = paramParcel.readString();
    s.checkNotNull(str);
    s.s(str, "source.readString()!!");
    this.appEntryPage = str;
    paramParcel = paramParcel.readString();
    s.checkNotNull(paramParcel);
    s.s(paramParcel, "source.readString()!!");
    this.appUserName = paramParcel;
    AppMethodBeat.o(121728);
  }
  
  public HandOffMP(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this(paramString1, paramString2, paramString3, paramString4, paramString5, 0, null, null, null, 480, null);
    AppMethodBeat.i(266061);
    AppMethodBeat.o(266061);
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
    AppMethodBeat.i(266048);
    AppMethodBeat.o(266048);
  }
  
  public HandOffMP(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6, String paramString7)
  {
    this(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt, paramString6, paramString7, null, 256, null);
    AppMethodBeat.i(266040);
    AppMethodBeat.o(266040);
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
    String str = n.bJB("\n        <icon>" + a.fP(this.icon) + "</icon>\n        <title>" + a.fP(this.title) + "</title>\n        <appid>" + a.fP(this.appID) + "</appid>\n        <appentrypage>" + a.fP(this.appEntryPage) + "</appentrypage>\n        <appusername>" + a.fP(this.appUserName) + "</appusername>\n    ");
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
  
  protected r<drz, byte[]> doCreateMultiTaskInfo()
  {
    return null;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(266189);
    if (this == paramObject)
    {
      AppMethodBeat.o(266189);
      return true;
    }
    if (!(paramObject instanceof HandOffMP))
    {
      AppMethodBeat.o(266189);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(266189);
      return false;
    }
    if (!s.p(this.icon, ((HandOffMP)paramObject).icon))
    {
      AppMethodBeat.o(266189);
      return false;
    }
    if (!s.p(this.title, ((HandOffMP)paramObject).title))
    {
      AppMethodBeat.o(266189);
      return false;
    }
    if (!s.p(this.appID, ((HandOffMP)paramObject).appID))
    {
      AppMethodBeat.o(266189);
      return false;
    }
    if (!s.p(this.appEntryPage, ((HandOffMP)paramObject).appEntryPage))
    {
      AppMethodBeat.o(266189);
      return false;
    }
    if (!s.p(this.appUserName, ((HandOffMP)paramObject).appUserName))
    {
      AppMethodBeat.o(266189);
      return false;
    }
    AppMethodBeat.o(266189);
    return true;
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
  
  public int hashCode()
  {
    AppMethodBeat.i(266192);
    int i = this.icon.hashCode();
    int j = this.title.hashCode();
    int k = this.appID.hashCode();
    int m = this.appEntryPage.hashCode();
    int n = this.appUserName.hashCode();
    AppMethodBeat.o(266192);
    return (((i * 31 + j) * 31 + k) * 31 + m) * 31 + n;
  }
  
  public final void setAppEntryPage(String paramString)
  {
    AppMethodBeat.i(266111);
    s.u(paramString, "<set-?>");
    this.appEntryPage = paramString;
    AppMethodBeat.o(266111);
  }
  
  public final void setAppID(String paramString)
  {
    AppMethodBeat.i(266096);
    s.u(paramString, "<set-?>");
    this.appID = paramString;
    AppMethodBeat.o(266096);
  }
  
  public final void setAppUserName(String paramString)
  {
    AppMethodBeat.i(266123);
    s.u(paramString, "<set-?>");
    this.appUserName = paramString;
    AppMethodBeat.o(266123);
  }
  
  public final void setIcon(String paramString)
  {
    AppMethodBeat.i(266073);
    s.u(paramString, "<set-?>");
    this.icon = paramString;
    AppMethodBeat.o(266073);
  }
  
  public final void setTitle(String paramString)
  {
    AppMethodBeat.i(266085);
    s.u(paramString, "<set-?>");
    this.title = paramString;
    AppMethodBeat.o(266085);
  }
  
  public String toString()
  {
    AppMethodBeat.i(121725);
    String str = "HandOffMP(key='" + getKey() + "', id='" + getId() + "', createTime='" + getCreateTime() + ", icon='" + this.icon + "', title='" + this.title + "', appID='" + this.appID + "', appEntryPage='" + this.appEntryPage + "', appUserName='" + this.appUserName + "')";
    AppMethodBeat.o(121725);
    return str;
  }
  
  public boolean update(HandOff paramHandOff)
  {
    AppMethodBeat.i(266136);
    s.u(paramHandOff, "newHandOff");
    boolean bool2 = super.update(paramHandOff);
    boolean bool1 = bool2;
    if ((paramHandOff instanceof HandOffMP))
    {
      bool1 = bool2;
      if (!s.p(paramHandOff, this))
      {
        this.icon = ((HandOffMP)paramHandOff).icon;
        this.title = ((HandOffMP)paramHandOff).title;
        this.appID = ((HandOffMP)paramHandOff).appID;
        this.appEntryPage = ((HandOffMP)paramHandOff).appEntryPage;
        this.appUserName = ((HandOffMP)paramHandOff).appUserName;
        bool1 = true;
      }
    }
    AppMethodBeat.o(266136);
    return bool1;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(121723);
    s.u(paramParcel, "dest");
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(getIcon());
    paramParcel.writeString(getTitle());
    paramParcel.writeString(getAppID());
    paramParcel.writeString(getAppEntryPage());
    paramParcel.writeString(getAppUserName());
    AppMethodBeat.o(121723);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/handoff/model/HandOffMP$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/handoff/model/HandOffMP;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/handoff/model/HandOffMP;", "api-handoff_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Parcelable.Creator<HandOffMP>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.model.HandOffMP
 * JD-Core Version:    0.7.0.1
 */