package com.tencent.mm.plugin.handoff.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/handoff/model/HandOffMG;", "Lcom/tencent/mm/plugin/handoff/model/HandOffMP;", "icon", "", "title", "appID", "appEntryPage", "appUserName", "handOffType", "", "from", "to", "key", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "()V", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "copy", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "getDataType", "Companion", "api-handoff_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class HandOffMG
  extends HandOffMP
{
  public static final Parcelable.Creator<HandOffMG> CREATOR;
  public static final HandOffMG.a Companion;
  
  static
  {
    AppMethodBeat.i(121718);
    Companion = new HandOffMG.a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(121718);
  }
  
  public HandOffMG()
  {
    this("", "", "", "", "", 0, null, null, null, 480, null);
  }
  
  public HandOffMG(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(121717);
    AppMethodBeat.o(121717);
  }
  
  public HandOffMG(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this(paramString1, paramString2, paramString3, paramString4, paramString5, 0, null, null, null, 480, null);
    AppMethodBeat.i(121716);
    AppMethodBeat.o(121716);
  }
  
  public HandOffMG(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    this(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt, null, null, null, 448, null);
    AppMethodBeat.i(266044);
    AppMethodBeat.o(266044);
  }
  
  public HandOffMG(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6)
  {
    this(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt, paramString6, null, null, 384, null);
    AppMethodBeat.i(266038);
    AppMethodBeat.o(266038);
  }
  
  public HandOffMG(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6, String paramString7)
  {
    this(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt, paramString6, paramString7, null, 256, null);
    AppMethodBeat.i(266032);
    AppMethodBeat.o(266032);
  }
  
  public HandOffMG(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6, String paramString7, String paramString8)
  {
    super(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt, paramString6, paramString7, paramString8);
    AppMethodBeat.i(121715);
    AppMethodBeat.o(121715);
  }
  
  public final HandOff copy()
  {
    AppMethodBeat.i(121714);
    Object localObject = new HandOffMG(getIcon(), getTitle(), getAppID(), getAppEntryPage(), getAppUserName(), getHandOffType(), getFrom(), getTo(), getKey());
    ((HandOffMG)localObject).setId(getId());
    localObject = (HandOff)localObject;
    AppMethodBeat.o(121714);
    return localObject;
  }
  
  public final int getDataType()
  {
    return 4;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/handoff/model/HandOffMG$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/handoff/model/HandOffMG;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/handoff/model/HandOffMG;", "api-handoff_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Parcelable.Creator<HandOffMG>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.model.HandOffMG
 * JD-Core Version:    0.7.0.1
 */