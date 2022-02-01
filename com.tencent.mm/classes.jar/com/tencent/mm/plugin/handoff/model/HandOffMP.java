package com.tencent.mm.plugin.handoff.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import d.n.n;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/handoff/model/HandOffMP;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "icon", "", "title", "appID", "appEntryPage", "appUserName", "handOffType", "", "from", "to", "key", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getAppEntryPage", "()Ljava/lang/String;", "setAppEntryPage", "(Ljava/lang/String;)V", "getAppID", "setAppID", "getAppUserName", "setAppUserName", "getIcon", "setIcon", "getTitle", "setTitle", "body", "copy", "describeContents", "getDataType", "toString", "update", "", "newHandOff", "writeToParcel", "dest", "flags", "Companion", "api-handoff_release"})
public class HandOffMP
  extends HandOff
{
  public static final Parcelable.Creator<HandOffMP> CREATOR;
  public static final a uDU;
  String dDH;
  String dtE;
  String kuy;
  String title;
  public String uDT;
  
  static
  {
    AppMethodBeat.i(121729);
    uDU = new a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(121729);
  }
  
  public HandOffMP(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(121728);
    String str = paramParcel.readString();
    if (str == null) {
      p.gfZ();
    }
    this.dDH = str;
    str = paramParcel.readString();
    if (str == null) {
      p.gfZ();
    }
    this.title = str;
    str = paramParcel.readString();
    if (str == null) {
      p.gfZ();
    }
    this.kuy = str;
    str = paramParcel.readString();
    if (str == null) {
      p.gfZ();
    }
    this.uDT = str;
    paramParcel = paramParcel.readString();
    if (paramParcel == null) {
      p.gfZ();
    }
    this.dtE = paramParcel;
    AppMethodBeat.o(121728);
  }
  
  public HandOffMP(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6, String paramString7, String paramString8)
  {
    super(paramInt, paramString6, paramString7, paramString8);
    AppMethodBeat.i(121726);
    this.dDH = paramString1;
    this.title = paramString2;
    this.kuy = paramString3;
    this.uDT = paramString4;
    this.dtE = paramString5;
    AppMethodBeat.o(121726);
  }
  
  protected final String dbM()
  {
    AppMethodBeat.i(121722);
    String str = n.bdc("\n        <icon>" + a.dl(this.dDH) + "</icon>\n        <title>" + a.dl(this.title) + "</title>\n        <appid>" + a.dl(this.kuy) + "</appid>\n        <appentrypage>" + a.dl(this.uDT) + "</appentrypage>\n        <appusername>" + a.dl(this.dtE) + "</appusername>\n    ");
    AppMethodBeat.o(121722);
    return str;
  }
  
  public HandOff dbN()
  {
    AppMethodBeat.i(121724);
    Object localObject = new HandOffMP(this.dDH, this.title, this.kuy, this.uDT, this.dtE, this.uDJ, this.dET, this.hEw, this.key);
    ((HandOffMP)localObject).setId(this.id);
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
    p.h(paramHandOff, "newHandOff");
    super.j(paramHandOff);
    if ((paramHandOff instanceof HandOffMP))
    {
      this.dDH = ((HandOffMP)paramHandOff).dDH;
      this.title = ((HandOffMP)paramHandOff).title;
      this.kuy = ((HandOffMP)paramHandOff).kuy;
      this.uDT = ((HandOffMP)paramHandOff).uDT;
      this.dtE = ((HandOffMP)paramHandOff).dtE;
    }
    AppMethodBeat.o(121721);
  }
  
  public String toString()
  {
    AppMethodBeat.i(121725);
    String str = "HandOffMP(key='" + this.key + "', id='" + this.id + "', createTime='" + this.createTime + ", icon='" + this.dDH + "', title='" + this.title + "', appID='" + this.kuy + "', appEntryPage='" + this.uDT + "', appUserName='" + this.dtE + "')";
    AppMethodBeat.o(121725);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(121723);
    p.h(paramParcel, "dest");
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.dDH);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.kuy);
    paramParcel.writeString(this.uDT);
    paramParcel.writeString(this.dtE);
    AppMethodBeat.o(121723);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/handoff/model/HandOffMP$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/handoff/model/HandOffMP;", "api-handoff_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/handoff/model/HandOffMP$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/handoff/model/HandOffMP;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/handoff/model/HandOffMP;", "api-handoff_release"})
  public static final class b
    implements Parcelable.Creator<HandOffMP>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.model.HandOffMP
 * JD-Core Version:    0.7.0.1
 */