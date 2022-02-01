package com.tencent.mm.emoji.sync;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/sync/EmojiSyncLoaderIPC$EmojiSyncData;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "isLoadEnd", "", "()Z", "setLoadEnd", "(Z)V", "panelType", "", "getPanelType", "()I", "setPanelType", "(I)V", "syncCount", "getSyncCount", "setSyncCount", "targetSyncCount", "getTargetSyncCount", "setTargetSyncCount", "waitingIndex", "getWaitingIndex", "setWaitingIndex", "describeContents", "writeToParcel", "", "flags", "CREATOR", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class EmojiSyncLoaderIPC$EmojiSyncData
  implements Parcelable
{
  public static final a CREATOR;
  int mjd;
  int mna;
  int mnb;
  int mnd;
  boolean mne;
  
  static
  {
    AppMethodBeat.i(242581);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(242581);
  }
  
  public EmojiSyncLoaderIPC$EmojiSyncData() {}
  
  public EmojiSyncLoaderIPC$EmojiSyncData(Parcel paramParcel)
  {
    this();
    AppMethodBeat.i(242576);
    this.mjd = paramParcel.readInt();
    this.mna = paramParcel.readInt();
    this.mnb = paramParcel.readInt();
    this.mnd = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.mne = bool;
      AppMethodBeat.o(242576);
      return;
    }
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(242583);
    s.u(paramParcel, "parcel");
    paramParcel.writeInt(this.mjd);
    paramParcel.writeInt(this.mna);
    paramParcel.writeInt(this.mnb);
    paramParcel.writeInt(this.mnd);
    if (this.mne) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      AppMethodBeat.o(242583);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/sync/EmojiSyncLoaderIPC$EmojiSyncData$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/emoji/sync/EmojiSyncLoaderIPC$EmojiSyncData;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/emoji/sync/EmojiSyncLoaderIPC$EmojiSyncData;", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<EmojiSyncLoaderIPC.EmojiSyncData>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.sync.EmojiSyncLoaderIPC.EmojiSyncData
 * JD-Core Version:    0.7.0.1
 */