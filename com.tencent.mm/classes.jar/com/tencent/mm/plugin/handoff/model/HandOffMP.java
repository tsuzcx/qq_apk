package com.tencent.mm.plugin.handoff.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import d.n.n;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/handoff/model/HandOffMP;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "icon", "", "title", "appID", "appEntryPage", "appUserName", "handOffType", "", "from", "to", "key", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getAppEntryPage", "()Ljava/lang/String;", "setAppEntryPage", "(Ljava/lang/String;)V", "getAppID", "setAppID", "getAppUserName", "setAppUserName", "getIcon", "setIcon", "getTitle", "setTitle", "body", "copy", "describeContents", "getDataType", "toString", "update", "", "newHandOff", "writeToParcel", "dest", "flags", "Companion", "api-handoff_release"})
public class HandOffMP
  extends HandOff
{
  public static final Parcelable.Creator<HandOffMP> CREATOR;
  public static final a uPz;
  String dEM;
  String duJ;
  String kxO;
  String title;
  String uPy;
  
  static
  {
    AppMethodBeat.i(121729);
    uPz = new a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(121729);
  }
  
  public HandOffMP(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(121728);
    String str = paramParcel.readString();
    if (str == null) {
      p.gkB();
    }
    this.dEM = str;
    str = paramParcel.readString();
    if (str == null) {
      p.gkB();
    }
    this.title = str;
    str = paramParcel.readString();
    if (str == null) {
      p.gkB();
    }
    this.kxO = str;
    str = paramParcel.readString();
    if (str == null) {
      p.gkB();
    }
    this.uPy = str;
    paramParcel = paramParcel.readString();
    if (paramParcel == null) {
      p.gkB();
    }
    this.duJ = paramParcel;
    AppMethodBeat.o(121728);
  }
  
  public HandOffMP(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6, String paramString7, String paramString8)
  {
    super(paramInt, paramString6, paramString7, paramString8);
    AppMethodBeat.i(121726);
    this.dEM = paramString1;
    this.title = paramString2;
    this.kxO = paramString3;
    this.uPy = paramString4;
    this.duJ = paramString5;
    AppMethodBeat.o(121726);
  }
  
  public final void aoi(String paramString)
  {
    AppMethodBeat.i(208175);
    p.h(paramString, "<set-?>");
    this.uPy = paramString;
    AppMethodBeat.o(208175);
  }
  
  protected final String deD()
  {
    AppMethodBeat.i(121722);
    String str = n.beG("\n        <icon>" + a.dm(this.dEM) + "</icon>\n        <title>" + a.dm(this.title) + "</title>\n        <appid>" + a.dm(this.kxO) + "</appid>\n        <appentrypage>" + a.dm(this.uPy) + "</appentrypage>\n        <appusername>" + a.dm(this.duJ) + "</appusername>\n    ");
    AppMethodBeat.o(121722);
    return str;
  }
  
  public HandOff deE()
  {
    AppMethodBeat.i(121724);
    Object localObject = new HandOffMP(this.dEM, this.title, this.kxO, this.uPy, this.duJ, this.uPo, this.dFY, this.hHo, this.key);
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
  
  public final void k(HandOff paramHandOff)
  {
    AppMethodBeat.i(121721);
    p.h(paramHandOff, "newHandOff");
    super.k(paramHandOff);
    if ((paramHandOff instanceof HandOffMP))
    {
      this.dEM = ((HandOffMP)paramHandOff).dEM;
      this.title = ((HandOffMP)paramHandOff).title;
      this.kxO = ((HandOffMP)paramHandOff).kxO;
      this.uPy = ((HandOffMP)paramHandOff).uPy;
      this.duJ = ((HandOffMP)paramHandOff).duJ;
    }
    AppMethodBeat.o(121721);
  }
  
  public String toString()
  {
    AppMethodBeat.i(121725);
    String str = "HandOffMP(key='" + this.key + "', id='" + this.id + "', createTime='" + this.createTime + ", icon='" + this.dEM + "', title='" + this.title + "', appID='" + this.kxO + "', appEntryPage='" + this.uPy + "', appUserName='" + this.duJ + "')";
    AppMethodBeat.o(121725);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(121723);
    p.h(paramParcel, "dest");
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.dEM);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.kxO);
    paramParcel.writeString(this.uPy);
    paramParcel.writeString(this.duJ);
    AppMethodBeat.o(121723);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/handoff/model/HandOffMP$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/handoff/model/HandOffMP;", "api-handoff_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/handoff/model/HandOffMP$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/handoff/model/HandOffMP;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/handoff/model/HandOffMP;", "api-handoff_release"})
  public static final class b
    implements Parcelable.Creator<HandOffMP>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.model.HandOffMP
 * JD-Core Version:    0.7.0.1
 */