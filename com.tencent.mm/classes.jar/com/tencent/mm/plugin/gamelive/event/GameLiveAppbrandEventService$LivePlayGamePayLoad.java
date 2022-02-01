package com.tencent.mm.plugin.gamelive.event;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelive/event/GameLiveAppbrandEventService$LivePlayGamePayLoad;", "Landroid/os/Parcelable;", "join_team_mode", "", "title", "", "teamup_desc", "member_desc", "teamup_extra_data", "appid", "versionType", "path", "sourceId", "type", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;II)V", "getAppid", "()Ljava/lang/String;", "setAppid", "(Ljava/lang/String;)V", "getJoin_team_mode", "()I", "setJoin_team_mode", "(I)V", "getMember_desc", "setMember_desc", "getPath", "setPath", "getSourceId", "setSourceId", "getTeamup_desc", "setTeamup_desc", "getTeamup_extra_data", "setTeamup_extra_data", "getTitle", "setTitle", "getType", "setType", "getVersionType", "setVersionType", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-gamelive_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class GameLiveAppbrandEventService$LivePlayGamePayLoad
  implements Parcelable
{
  public static final Parcelable.Creator<LivePlayGamePayLoad> CREATOR;
  public int Jfv;
  public String Jfw;
  public String Jfx;
  public String Jfy;
  public int Jfz;
  public String appid;
  public int euz;
  public String path;
  public String title;
  public int type;
  
  static
  {
    AppMethodBeat.i(277430);
    CREATOR = (Parcelable.Creator)new a();
    AppMethodBeat.o(277430);
  }
  
  public GameLiveAppbrandEventService$LivePlayGamePayLoad(byte paramByte)
  {
    this();
  }
  
  public GameLiveAppbrandEventService$LivePlayGamePayLoad(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, int paramInt3, int paramInt4)
  {
    this.Jfv = paramInt1;
    this.title = paramString1;
    this.Jfw = paramString2;
    this.Jfx = paramString3;
    this.Jfy = paramString4;
    this.appid = paramString5;
    this.euz = paramInt2;
    this.path = paramString6;
    this.Jfz = paramInt3;
    this.type = paramInt4;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(277455);
    if (this == paramObject)
    {
      AppMethodBeat.o(277455);
      return true;
    }
    if (!(paramObject instanceof LivePlayGamePayLoad))
    {
      AppMethodBeat.o(277455);
      return false;
    }
    paramObject = (LivePlayGamePayLoad)paramObject;
    if (this.Jfv != paramObject.Jfv)
    {
      AppMethodBeat.o(277455);
      return false;
    }
    if (!s.p(this.title, paramObject.title))
    {
      AppMethodBeat.o(277455);
      return false;
    }
    if (!s.p(this.Jfw, paramObject.Jfw))
    {
      AppMethodBeat.o(277455);
      return false;
    }
    if (!s.p(this.Jfx, paramObject.Jfx))
    {
      AppMethodBeat.o(277455);
      return false;
    }
    if (!s.p(this.Jfy, paramObject.Jfy))
    {
      AppMethodBeat.o(277455);
      return false;
    }
    if (!s.p(this.appid, paramObject.appid))
    {
      AppMethodBeat.o(277455);
      return false;
    }
    if (this.euz != paramObject.euz)
    {
      AppMethodBeat.o(277455);
      return false;
    }
    if (!s.p(this.path, paramObject.path))
    {
      AppMethodBeat.o(277455);
      return false;
    }
    if (this.Jfz != paramObject.Jfz)
    {
      AppMethodBeat.o(277455);
      return false;
    }
    if (this.type != paramObject.type)
    {
      AppMethodBeat.o(277455);
      return false;
    }
    AppMethodBeat.o(277455);
    return true;
  }
  
  public final int hashCode()
  {
    int i1 = 0;
    AppMethodBeat.i(277445);
    int i2 = this.Jfv;
    int i;
    int j;
    label32:
    int k;
    label41:
    int m;
    label51:
    int n;
    label61:
    int i3;
    if (this.title == null)
    {
      i = 0;
      if (this.Jfw != null) {
        break label156;
      }
      j = 0;
      if (this.Jfx != null) {
        break label167;
      }
      k = 0;
      if (this.Jfy != null) {
        break label178;
      }
      m = 0;
      if (this.appid != null) {
        break label190;
      }
      n = 0;
      i3 = this.euz;
      if (this.path != null) {
        break label202;
      }
    }
    for (;;)
    {
      int i4 = this.Jfz;
      int i5 = this.type;
      AppMethodBeat.o(277445);
      return ((((n + (m + (k + (j + (i + i2 * 31) * 31) * 31) * 31) * 31) * 31 + i3) * 31 + i1) * 31 + i4) * 31 + i5;
      i = this.title.hashCode();
      break;
      label156:
      j = this.Jfw.hashCode();
      break label32;
      label167:
      k = this.Jfx.hashCode();
      break label41;
      label178:
      m = this.Jfy.hashCode();
      break label51;
      label190:
      n = this.appid.hashCode();
      break label61;
      label202:
      i1 = this.path.hashCode();
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(277434);
    String str = "LivePlayGamePayLoad(join_team_mode=" + this.Jfv + ", title=" + this.title + ", teamup_desc=" + this.Jfw + ", member_desc=" + this.Jfx + ", teamup_extra_data=" + this.Jfy + ", appid=" + this.appid + ", versionType=" + this.euz + ", path=" + this.path + ", sourceId=" + this.Jfz + ", type=" + this.type + ')';
    AppMethodBeat.o(277434);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(277469);
    s.u(paramParcel, "out");
    paramParcel.writeInt(this.Jfv);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.Jfw);
    paramParcel.writeString(this.Jfx);
    paramParcel.writeString(this.Jfy);
    paramParcel.writeString(this.appid);
    paramParcel.writeInt(this.euz);
    paramParcel.writeString(this.path);
    paramParcel.writeInt(this.Jfz);
    paramParcel.writeInt(this.type);
    AppMethodBeat.o(277469);
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<GameLiveAppbrandEventService.LivePlayGamePayLoad>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelive.event.GameLiveAppbrandEventService.LivePlayGamePayLoad
 * JD-Core Version:    0.7.0.1
 */