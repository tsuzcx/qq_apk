package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import a.f.b.j;
import a.l;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.s;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/AppMsgDataParcelable;", "Landroid/os/Parcelable;", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "appendText", "", "getAppendText$plugin_brandservice_release", "()Ljava/lang/String;", "setAppendText$plugin_brandservice_release", "(Ljava/lang/String;)V", "isMaliciousTitle", "", "isMaliciousTitle$plugin_brandservice_release", "()I", "setMaliciousTitle$plugin_brandservice_release", "(I)V", "maliciousCover", "getMaliciousCover$plugin_brandservice_release", "setMaliciousCover$plugin_brandservice_release", "maliciousDesc", "getMaliciousDesc$plugin_brandservice_release", "setMaliciousDesc$plugin_brandservice_release", "maliciousTitle", "getMaliciousTitle$plugin_brandservice_release", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "getMsgInfo$plugin_brandservice_release", "()Lcom/tencent/mm/message/MPMsgInfo;", "setMsgInfo$plugin_brandservice_release", "(Lcom/tencent/mm/message/MPMsgInfo;)V", "msgInfoLength", "getMsgInfoLength$plugin_brandservice_release", "setMsgInfoLength$plugin_brandservice_release", "sessionId", "getSessionId$plugin_brandservice_release", "setSessionId$plugin_brandservice_release", "toUser", "getToUser$plugin_brandservice_release", "setToUser$plugin_brandservice_release", "url", "getUrl$plugin_brandservice_release", "setUrl$plugin_brandservice_release", "describeContents", "readParcel", "", "writeToParcel", "dest", "flags", "CREATOR", "plugin-brandservice_release"})
public final class AppMsgDataParcelable
  implements Parcelable
{
  public static final AppMsgDataParcelable.a CREATOR;
  String cpW;
  String hZN;
  s jXm;
  private int khQ;
  int khR;
  String khS;
  String khT;
  String khU;
  String toUser;
  String url;
  
  static
  {
    AppMethodBeat.i(152946);
    CREATOR = new AppMsgDataParcelable.a((byte)0);
    AppMethodBeat.o(152946);
  }
  
  public AppMsgDataParcelable() {}
  
  public AppMsgDataParcelable(Parcel paramParcel)
  {
    AppMethodBeat.i(152945);
    j.q(paramParcel, "parcel");
    this.toUser = paramParcel.readString();
    this.url = paramParcel.readString();
    this.hZN = paramParcel.readString();
    this.khQ = paramParcel.readInt();
    if (this.khQ > 0)
    {
      byte[] arrayOfByte = new byte[this.khQ];
      paramParcel.readByteArray(arrayOfByte);
      s locals = new s();
      locals.parseFrom(arrayOfByte);
      this.jXm = locals;
    }
    this.khR = paramParcel.readInt();
    this.khS = paramParcel.readString();
    this.khT = paramParcel.readString();
    this.khU = paramParcel.readString();
    this.cpW = paramParcel.readString();
    AppMethodBeat.o(152945);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(152944);
    j.q(paramParcel, "dest");
    paramParcel.writeString(this.toUser);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.hZN);
    Object localObject = this.jXm;
    if (localObject != null)
    {
      localObject = ((s)localObject).toByteArray();
      if (localObject == null) {
        break label161;
      }
      if (localObject.length != 0) {
        break label151;
      }
      paramInt = 1;
      label68:
      if (paramInt != 0) {
        break label156;
      }
      paramInt = i;
      label74:
      if (paramInt == 0) {
        break label161;
      }
      this.khQ = localObject.length;
      paramParcel.writeInt(this.khQ);
      paramParcel.writeByteArray((byte[])localObject);
    }
    for (;;)
    {
      paramParcel.writeInt(this.khR);
      paramParcel.writeString(this.khS);
      paramParcel.writeString(this.khT);
      paramParcel.writeString(this.khU);
      paramParcel.writeString(this.cpW);
      AppMethodBeat.o(152944);
      return;
      localObject = null;
      break;
      label151:
      paramInt = 0;
      break label68;
      label156:
      paramInt = 0;
      break label74;
      label161:
      paramParcel.writeInt(this.khQ);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.AppMsgDataParcelable
 * JD-Core Version:    0.7.0.1
 */