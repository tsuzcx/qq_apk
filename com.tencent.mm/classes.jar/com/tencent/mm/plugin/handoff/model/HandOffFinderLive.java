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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/handoff/model/HandOffFinderLive;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "title", "", "icon", "objectId", "nonceId", "liveId", "handOffType", "", "from", "to", "key", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getIcon", "()Ljava/lang/String;", "setIcon", "(Ljava/lang/String;)V", "getLiveId", "setLiveId", "getNonceId", "setNonceId", "getObjectId", "setObjectId", "getTitle", "setTitle", "body", "copy", "describeContents", "doCreateBallInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "doCreateMultiTaskInfo", "Lkotlin/Pair;", "Lcom/tencent/mm/protocal/protobuf/MultiTaskShowData;", "", "equals", "", "other", "", "getDataType", "hashCode", "toString", "update", "newHandOff", "writeToParcel", "", "dest", "flags", "Companion", "api-handoff_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class HandOffFinderLive
  extends HandOff
{
  public static final Parcelable.Creator<HandOffFinderLive> CREATOR;
  public static final HandOffFinderLive.a Companion;
  private String icon;
  private String liveId;
  private String nonceId;
  private String objectId;
  private String title;
  
  static
  {
    AppMethodBeat.i(266049);
    Companion = new HandOffFinderLive.a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(266049);
  }
  
  public HandOffFinderLive(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(266018);
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
    this.objectId = str;
    str = paramParcel.readString();
    s.checkNotNull(str);
    s.s(str, "source.readString()!!");
    this.nonceId = str;
    paramParcel = paramParcel.readString();
    s.checkNotNull(paramParcel);
    s.s(paramParcel, "source.readString()!!");
    this.liveId = paramParcel;
    AppMethodBeat.o(266018);
  }
  
  public HandOffFinderLive(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this(paramString1, paramString2, paramString3, paramString4, paramString5, 0, null, null, null, 480, null);
    AppMethodBeat.i(266042);
    AppMethodBeat.o(266042);
  }
  
  public HandOffFinderLive(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    this(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt, null, null, null, 448, null);
    AppMethodBeat.i(266035);
    AppMethodBeat.o(266035);
  }
  
  public HandOffFinderLive(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6)
  {
    this(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt, paramString6, null, null, 384, null);
    AppMethodBeat.i(266030);
    AppMethodBeat.o(266030);
  }
  
  public HandOffFinderLive(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6, String paramString7)
  {
    this(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt, paramString6, paramString7, null, 256, null);
    AppMethodBeat.i(266026);
    AppMethodBeat.o(266026);
  }
  
  public HandOffFinderLive(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6, String paramString7, String paramString8)
  {
    super(paramInt, paramString6, paramString7, paramString8, null, 0L, 48, null);
    AppMethodBeat.i(266005);
    this.title = paramString1;
    this.icon = paramString2;
    this.objectId = paramString3;
    this.nonceId = paramString4;
    this.liveId = paramString5;
    AppMethodBeat.o(266005);
  }
  
  protected final String body()
  {
    AppMethodBeat.i(266129);
    String str = n.bJB("\n        <icon>" + a.fP(this.icon) + "</icon>\n        <title>" + a.fP(this.title) + "</title>\n        <feedObjectId>" + a.fP(this.objectId) + "</feedObjectId>\n        <feedNonceId>" + a.fP(this.nonceId) + "</feedNonceId>\n        <feedLiveId>" + a.fP(this.liveId) + "</feedLiveId>\n    ");
    AppMethodBeat.o(266129);
    return str;
  }
  
  public final HandOff copy()
  {
    AppMethodBeat.i(266153);
    Object localObject = new HandOffFinderLive(this.title, this.icon, this.objectId, this.nonceId, this.liveId, getHandOffType(), getFrom(), getTo(), getKey());
    ((HandOffFinderLive)localObject).setId(getId());
    localObject = (HandOff)localObject;
    AppMethodBeat.o(266153);
    return localObject;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  protected final BallInfo doCreateBallInfo()
  {
    return null;
  }
  
  protected final r<drz, byte[]> doCreateMultiTaskInfo()
  {
    return null;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(266177);
    if (this == paramObject)
    {
      AppMethodBeat.o(266177);
      return true;
    }
    if (!(paramObject instanceof HandOffFinderLive))
    {
      AppMethodBeat.o(266177);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(266177);
      return false;
    }
    if (!s.p(this.icon, ((HandOffFinderLive)paramObject).icon))
    {
      AppMethodBeat.o(266177);
      return false;
    }
    if (!s.p(this.title, ((HandOffFinderLive)paramObject).title))
    {
      AppMethodBeat.o(266177);
      return false;
    }
    if (!s.p(this.objectId, ((HandOffFinderLive)paramObject).objectId))
    {
      AppMethodBeat.o(266177);
      return false;
    }
    if (!s.p(this.nonceId, ((HandOffFinderLive)paramObject).nonceId))
    {
      AppMethodBeat.o(266177);
      return false;
    }
    if (!s.p(this.liveId, ((HandOffFinderLive)paramObject).liveId))
    {
      AppMethodBeat.o(266177);
      return false;
    }
    AppMethodBeat.o(266177);
    return true;
  }
  
  public final int getDataType()
  {
    return 6;
  }
  
  public final String getIcon()
  {
    return this.icon;
  }
  
  public final String getLiveId()
  {
    return this.liveId;
  }
  
  public final String getNonceId()
  {
    return this.nonceId;
  }
  
  public final String getObjectId()
  {
    return this.objectId;
  }
  
  public final String getTitle()
  {
    return this.title;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(266182);
    int i = super.hashCode();
    int j = this.icon.hashCode();
    int k = this.title.hashCode();
    int m = this.objectId.hashCode();
    int n = this.nonceId.hashCode();
    int i1 = this.liveId.hashCode();
    AppMethodBeat.o(266182);
    return ((((i * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1;
  }
  
  public final void setIcon(String paramString)
  {
    AppMethodBeat.i(266059);
    s.u(paramString, "<set-?>");
    this.icon = paramString;
    AppMethodBeat.o(266059);
  }
  
  public final void setLiveId(String paramString)
  {
    AppMethodBeat.i(266101);
    s.u(paramString, "<set-?>");
    this.liveId = paramString;
    AppMethodBeat.o(266101);
  }
  
  public final void setNonceId(String paramString)
  {
    AppMethodBeat.i(266092);
    s.u(paramString, "<set-?>");
    this.nonceId = paramString;
    AppMethodBeat.o(266092);
  }
  
  public final void setObjectId(String paramString)
  {
    AppMethodBeat.i(266081);
    s.u(paramString, "<set-?>");
    this.objectId = paramString;
    AppMethodBeat.o(266081);
  }
  
  public final void setTitle(String paramString)
  {
    AppMethodBeat.i(266068);
    s.u(paramString, "<set-?>");
    this.title = paramString;
    AppMethodBeat.o(266068);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(266170);
    String str = "HandOffFinderLive(key='" + getKey() + "', id='" + getId() + "', createTime='" + getCreateTime() + ", title='" + this.title + "', objId='" + this.objectId + "', icon='" + this.icon + ", nonceId=" + this.nonceId + ", liveId=" + this.liveId + "')";
    AppMethodBeat.o(266170);
    return str;
  }
  
  public final boolean update(HandOff paramHandOff)
  {
    AppMethodBeat.i(266117);
    s.u(paramHandOff, "newHandOff");
    boolean bool2 = super.update(paramHandOff);
    boolean bool1 = bool2;
    if ((paramHandOff instanceof HandOffFinderLive))
    {
      bool1 = bool2;
      if (!s.p(paramHandOff, this))
      {
        this.title = ((HandOffFinderLive)paramHandOff).title;
        this.icon = ((HandOffFinderLive)paramHandOff).icon;
        this.objectId = ((HandOffFinderLive)paramHandOff).objectId;
        this.nonceId = ((HandOffFinderLive)paramHandOff).nonceId;
        this.liveId = ((HandOffFinderLive)paramHandOff).liveId;
        bool1 = true;
      }
    }
    AppMethodBeat.o(266117);
    return bool1;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(266142);
    s.u(paramParcel, "dest");
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(getIcon());
    paramParcel.writeString(getTitle());
    paramParcel.writeString(getObjectId());
    paramParcel.writeString(getNonceId());
    paramParcel.writeString(getLiveId());
    AppMethodBeat.o(266142);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/handoff/model/HandOffFinderLive$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/handoff/model/HandOffFinderLive;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/handoff/model/HandOffFinderLive;", "api-handoff_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Parcelable.Creator<HandOffFinderLive>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.model.HandOffFinderLive
 * JD-Core Version:    0.7.0.1
 */