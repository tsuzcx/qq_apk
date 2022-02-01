package com.tencent.mm.plugin.handoff.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import d.n.n;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/handoff/model/HandOffURL;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "title", "", "url", "icon", "handOffType", "", "from", "to", "key", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getIcon", "()Ljava/lang/String;", "setIcon", "(Ljava/lang/String;)V", "getTitle", "setTitle", "getUrl", "setUrl", "body", "copy", "describeContents", "getDataType", "toString", "update", "", "newHandOff", "writeToParcel", "dest", "flags", "Companion", "api-handoff_release"})
public final class HandOffURL
  extends HandOff
{
  public static final Parcelable.Creator<HandOffURL> CREATOR;
  public static final a uDV;
  private String dDH;
  public String title;
  public String url;
  
  static
  {
    AppMethodBeat.i(121743);
    uDV = new a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(121743);
  }
  
  public HandOffURL(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(121742);
    String str = paramParcel.readString();
    if (str == null) {
      p.gfZ();
    }
    this.title = str;
    str = paramParcel.readString();
    if (str == null) {
      p.gfZ();
    }
    this.url = str;
    paramParcel = paramParcel.readString();
    if (paramParcel == null) {
      p.gfZ();
    }
    this.dDH = paramParcel;
    AppMethodBeat.o(121742);
  }
  
  public HandOffURL(String paramString1, String paramString2, String paramString3)
  {
    this(paramString1, paramString2, paramString3, 0, null, null, null, 120);
  }
  
  private HandOffURL(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, String paramString6)
  {
    super(paramInt, paramString4, paramString5, paramString6);
    AppMethodBeat.i(121740);
    this.title = paramString1;
    this.url = paramString2;
    this.dDH = paramString3;
    AppMethodBeat.o(121740);
  }
  
  protected final String dbM()
  {
    AppMethodBeat.i(121736);
    String str = n.bdc("\n        <title>" + a.dl(this.title) + "</title>\n        <url>" + a.dl(this.url) + "</url>\n        <icon>" + a.dl(this.dDH) + "</icon>\n    ");
    AppMethodBeat.o(121736);
    return str;
  }
  
  public final HandOff dbN()
  {
    AppMethodBeat.i(121738);
    Object localObject = new HandOffURL(this.title, this.url, this.dDH, this.uDJ, this.dET, this.hEw, this.key);
    ((HandOffURL)localObject).setId(this.id);
    localObject = (HandOff)localObject;
    AppMethodBeat.o(121738);
    return localObject;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final int getDataType()
  {
    return 2;
  }
  
  public final void j(HandOff paramHandOff)
  {
    AppMethodBeat.i(121735);
    p.h(paramHandOff, "newHandOff");
    super.j(paramHandOff);
    if ((paramHandOff instanceof HandOffURL))
    {
      this.title = ((HandOffURL)paramHandOff).title;
      this.url = ((HandOffURL)paramHandOff).url;
      this.dDH = ((HandOffURL)paramHandOff).dDH;
    }
    AppMethodBeat.o(121735);
  }
  
  public final void setIcon(String paramString)
  {
    AppMethodBeat.i(121734);
    p.h(paramString, "<set-?>");
    this.dDH = paramString;
    AppMethodBeat.o(121734);
  }
  
  public final void setTitle(String paramString)
  {
    AppMethodBeat.i(121732);
    p.h(paramString, "<set-?>");
    this.title = paramString;
    AppMethodBeat.o(121732);
  }
  
  public final void setUrl(String paramString)
  {
    AppMethodBeat.i(121733);
    p.h(paramString, "<set-?>");
    this.url = paramString;
    AppMethodBeat.o(121733);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(121739);
    String str = "HandOffURL(key='" + this.key + "', id='" + this.id + "', createTime='" + this.createTime + ", title='" + this.title + "', url='" + this.url + "', icon='" + this.dDH + "')";
    AppMethodBeat.o(121739);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(121737);
    p.h(paramParcel, "dest");
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.dDH);
    AppMethodBeat.o(121737);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/handoff/model/HandOffURL$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/handoff/model/HandOffURL;", "api-handoff_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/handoff/model/HandOffURL$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/handoff/model/HandOffURL;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/handoff/model/HandOffURL;", "api-handoff_release"})
  public static final class b
    implements Parcelable.Creator<HandOffURL>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.model.HandOffURL
 * JD-Core Version:    0.7.0.1
 */