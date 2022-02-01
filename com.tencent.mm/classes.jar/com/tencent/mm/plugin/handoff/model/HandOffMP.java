package com.tencent.mm.plugin.handoff.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import d.n.n;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/handoff/model/HandOffMP;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "icon", "", "title", "appID", "appEntryPage", "appUserName", "handOffType", "", "from", "to", "key", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getAppEntryPage", "()Ljava/lang/String;", "setAppEntryPage", "(Ljava/lang/String;)V", "getAppID", "setAppID", "getAppUserName", "setAppUserName", "getIcon", "setIcon", "getTitle", "setTitle", "body", "copy", "describeContents", "getDataType", "toString", "update", "", "newHandOff", "writeToParcel", "dest", "flags", "Companion", "api-handoff_release"})
public class HandOffMP
  extends HandOff
{
  public static final Parcelable.Creator<HandOffMP> CREATOR;
  public static final a stv;
  String dkB;
  String dub;
  String jzF;
  public String stu;
  String title;
  
  static
  {
    AppMethodBeat.i(121729);
    stv = new a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(121729);
  }
  
  public HandOffMP(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(121728);
    String str = paramParcel.readString();
    if (str == null) {
      k.fvU();
    }
    this.dub = str;
    str = paramParcel.readString();
    if (str == null) {
      k.fvU();
    }
    this.title = str;
    str = paramParcel.readString();
    if (str == null) {
      k.fvU();
    }
    this.jzF = str;
    str = paramParcel.readString();
    if (str == null) {
      k.fvU();
    }
    this.stu = str;
    paramParcel = paramParcel.readString();
    if (paramParcel == null) {
      k.fvU();
    }
    this.dkB = paramParcel;
    AppMethodBeat.o(121728);
  }
  
  public HandOffMP(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6, String paramString7, String paramString8)
  {
    super(paramInt, paramString6, paramString7, paramString8);
    AppMethodBeat.i(121726);
    this.dub = paramString1;
    this.title = paramString2;
    this.jzF = paramString3;
    this.stu = paramString4;
    this.dkB = paramString5;
    AppMethodBeat.o(121726);
  }
  
  protected final String cFv()
  {
    AppMethodBeat.i(121722);
    String str = n.aRa("\n        <icon>" + a.dg(this.dub) + "</icon>\n        <title>" + a.dg(this.title) + "</title>\n        <appid>" + a.dg(this.jzF) + "</appid>\n        <appentrypage>" + a.dg(this.stu) + "</appentrypage>\n        <appusername>" + a.dg(this.dkB) + "</appusername>\n    ");
    AppMethodBeat.o(121722);
    return str;
  }
  
  public HandOff cFw()
  {
    AppMethodBeat.i(121724);
    Object localObject = new HandOffMP(this.dub, this.title, this.jzF, this.stu, this.dkB, this.stk, this.dvh, this.gLJ, this.key);
    ((HandOffMP)localObject).Zm(this.id);
    localObject = (HandOff)localObject;
    AppMethodBeat.o(121724);
    return localObject;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getDataType()
  {
    return 3;
  }
  
  public final void j(HandOff paramHandOff)
  {
    AppMethodBeat.i(121721);
    k.h(paramHandOff, "newHandOff");
    super.j(paramHandOff);
    if ((paramHandOff instanceof HandOffMP))
    {
      this.dub = ((HandOffMP)paramHandOff).dub;
      this.title = ((HandOffMP)paramHandOff).title;
      this.jzF = ((HandOffMP)paramHandOff).jzF;
      this.stu = ((HandOffMP)paramHandOff).stu;
      this.dkB = ((HandOffMP)paramHandOff).dkB;
    }
    AppMethodBeat.o(121721);
  }
  
  public String toString()
  {
    AppMethodBeat.i(121725);
    String str = "HandOffMP(key='" + this.key + "', id='" + this.id + "', createTime='" + this.createTime + ", icon='" + this.dub + "', title='" + this.title + "', appID='" + this.jzF + "', appEntryPage='" + this.stu + "', appUserName='" + this.dkB + "')";
    AppMethodBeat.o(121725);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(121723);
    k.h(paramParcel, "dest");
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.dub);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.jzF);
    paramParcel.writeString(this.stu);
    paramParcel.writeString(this.dkB);
    AppMethodBeat.o(121723);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/handoff/model/HandOffMP$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/handoff/model/HandOffMP;", "api-handoff_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/handoff/model/HandOffMP$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/handoff/model/HandOffMP;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/handoff/model/HandOffMP;", "api-handoff_release"})
  public static final class b
    implements Parcelable.Creator<HandOffMP>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.model.HandOffMP
 * JD-Core Version:    0.7.0.1
 */