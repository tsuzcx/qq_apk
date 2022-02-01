package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.x;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/AppMsgDataParcelable;", "Landroid/os/Parcelable;", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "appendText", "", "getAppendText$plugin_brandservice_release", "()Ljava/lang/String;", "setAppendText$plugin_brandservice_release", "(Ljava/lang/String;)V", "isMaliciousTitle", "", "isMaliciousTitle$plugin_brandservice_release", "()I", "setMaliciousTitle$plugin_brandservice_release", "(I)V", "maliciousCover", "getMaliciousCover$plugin_brandservice_release", "setMaliciousCover$plugin_brandservice_release", "maliciousDesc", "getMaliciousDesc$plugin_brandservice_release", "setMaliciousDesc$plugin_brandservice_release", "maliciousTitle", "getMaliciousTitle$plugin_brandservice_release", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "getMsgInfo$plugin_brandservice_release", "()Lcom/tencent/mm/message/MPMsgInfo;", "setMsgInfo$plugin_brandservice_release", "(Lcom/tencent/mm/message/MPMsgInfo;)V", "msgInfoLength", "getMsgInfoLength$plugin_brandservice_release", "setMsgInfoLength$plugin_brandservice_release", "sessionId", "getSessionId$plugin_brandservice_release", "setSessionId$plugin_brandservice_release", "toUser", "getToUser$plugin_brandservice_release", "setToUser$plugin_brandservice_release", "url", "getUrl$plugin_brandservice_release", "setUrl$plugin_brandservice_release", "describeContents", "readParcel", "", "writeToParcel", "dest", "flags", "CREATOR", "plugin-brandservice_release"})
public final class AppMsgDataParcelable
  implements Parcelable
{
  public static final a CREATOR;
  String lmh;
  x otY;
  private int owA;
  int owB;
  String owC;
  String owD;
  String owE;
  String sessionId;
  String toUser;
  String url;
  
  static
  {
    AppMethodBeat.i(7278);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(7278);
  }
  
  public AppMsgDataParcelable() {}
  
  public AppMsgDataParcelable(Parcel paramParcel)
  {
    AppMethodBeat.i(7277);
    p.h(paramParcel, "parcel");
    this.toUser = paramParcel.readString();
    this.url = paramParcel.readString();
    this.lmh = paramParcel.readString();
    this.owA = paramParcel.readInt();
    if (this.owA > 0)
    {
      byte[] arrayOfByte = new byte[this.owA];
      paramParcel.readByteArray(arrayOfByte);
      x localx = new x();
      localx.parseFrom(arrayOfByte);
      this.otY = localx;
    }
    this.owB = paramParcel.readInt();
    this.owC = paramParcel.readString();
    this.owD = paramParcel.readString();
    this.owE = paramParcel.readString();
    this.sessionId = paramParcel.readString();
    AppMethodBeat.o(7277);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(7276);
    p.h(paramParcel, "dest");
    paramParcel.writeString(this.toUser);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.lmh);
    Object localObject = this.otY;
    if (localObject != null)
    {
      localObject = ((x)localObject).toByteArray();
      if (localObject == null) {
        break label163;
      }
      if (localObject.length != 0) {
        break label153;
      }
      paramInt = 1;
      label69:
      if (paramInt != 0) {
        break label158;
      }
      paramInt = i;
      label75:
      if (paramInt == 0) {
        break label163;
      }
      this.owA = localObject.length;
      paramParcel.writeInt(this.owA);
      paramParcel.writeByteArray((byte[])localObject);
    }
    for (;;)
    {
      paramParcel.writeInt(this.owB);
      paramParcel.writeString(this.owC);
      paramParcel.writeString(this.owD);
      paramParcel.writeString(this.owE);
      paramParcel.writeString(this.sessionId);
      AppMethodBeat.o(7276);
      return;
      localObject = null;
      break;
      label153:
      paramInt = 0;
      break label69;
      label158:
      paramInt = 0;
      break label75;
      label163:
      paramParcel.writeInt(this.owA);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/AppMsgDataParcelable$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/AppMsgDataParcelable;", "()V", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/AppMsgDataParcelable;", "plugin-brandservice_release"})
  public static final class a
    implements Parcelable.Creator<AppMsgDataParcelable>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.AppMsgDataParcelable
 * JD-Core Version:    0.7.0.1
 */