package com.tencent.mm.plugin.handoff.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/handoff/model/HandOffMG;", "Lcom/tencent/mm/plugin/handoff/model/HandOffMP;", "icon", "", "title", "appID", "appEntryPage", "appUserName", "handOffType", "", "from", "to", "key", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "copy", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "getDataType", "Companion", "api-handoff_release"})
public final class HandOffMG
  extends HandOffMP
{
  public static final Parcelable.Creator<HandOffMG> CREATOR;
  public static final a tBj;
  
  static
  {
    AppMethodBeat.i(121718);
    tBj = new a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(121718);
  }
  
  public HandOffMG(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(121717);
    AppMethodBeat.o(121717);
  }
  
  private HandOffMG(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6, String paramString7, String paramString8)
  {
    super(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt, paramString6, paramString7, paramString8);
    AppMethodBeat.i(121715);
    AppMethodBeat.o(121715);
  }
  
  public final HandOff cSG()
  {
    AppMethodBeat.i(121714);
    Object localObject = new HandOffMG(this.drM, this.title, this.kac, this.tBk, this.dia, this.tBa, this.dsT, this.hmj, this.key);
    ((HandOffMG)localObject).adU(this.id);
    localObject = (HandOff)localObject;
    AppMethodBeat.o(121714);
    return localObject;
  }
  
  public final int getDataType()
  {
    return 4;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/handoff/model/HandOffMG$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/handoff/model/HandOffMG;", "api-handoff_release"})
  public static final class a {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/handoff/model/HandOffMG$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/handoff/model/HandOffMG;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/handoff/model/HandOffMG;", "api-handoff_release"})
  public static final class b
    implements Parcelable.Creator<HandOffMG>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.model.HandOffMG
 * JD-Core Version:    0.7.0.1
 */