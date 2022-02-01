package com.tencent.mm.chatroom.ui;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ChatroomInfoUI$LocalHistoryInfo
  implements Parcelable
{
  public static final Parcelable.Creator<LocalHistoryInfo> CREATOR;
  public String aeskey;
  public int fPH;
  public int fPI;
  public String fileid;
  public String filemd5;
  
  static
  {
    AppMethodBeat.i(217185);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(217185);
  }
  
  public ChatroomInfoUI$LocalHistoryInfo() {}
  
  protected ChatroomInfoUI$LocalHistoryInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(217184);
    this.fileid = paramParcel.readString();
    this.aeskey = paramParcel.readString();
    this.filemd5 = paramParcel.readString();
    this.fPH = paramParcel.readInt();
    this.fPI = paramParcel.readInt();
    AppMethodBeat.o(217184);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(217182);
    String str = "LocalHistoryInfo{fileid='" + this.fileid + '\'' + ", aeskey='" + this.aeskey + '\'' + ", filemd5='" + this.filemd5 + '\'' + ", filelength=" + this.fPH + ", msgsount=" + this.fPI + '}';
    AppMethodBeat.o(217182);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(217183);
    paramParcel.writeString(this.fileid);
    paramParcel.writeString(this.aeskey);
    paramParcel.writeString(this.filemd5);
    paramParcel.writeInt(this.fPH);
    paramParcel.writeInt(this.fPI);
    AppMethodBeat.o(217183);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ChatroomInfoUI.LocalHistoryInfo
 * JD-Core Version:    0.7.0.1
 */