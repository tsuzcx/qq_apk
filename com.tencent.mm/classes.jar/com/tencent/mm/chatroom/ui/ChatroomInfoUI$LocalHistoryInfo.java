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
  public String fileid;
  public String filemd5;
  public int iZc;
  public int iZd;
  
  static
  {
    AppMethodBeat.i(187430);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(187430);
  }
  
  public ChatroomInfoUI$LocalHistoryInfo() {}
  
  protected ChatroomInfoUI$LocalHistoryInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(187428);
    this.fileid = paramParcel.readString();
    this.aeskey = paramParcel.readString();
    this.filemd5 = paramParcel.readString();
    this.iZc = paramParcel.readInt();
    this.iZd = paramParcel.readInt();
    AppMethodBeat.o(187428);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(187415);
    String str = "LocalHistoryInfo{fileid='" + this.fileid + '\'' + ", aeskey='" + this.aeskey + '\'' + ", filemd5='" + this.filemd5 + '\'' + ", filelength=" + this.iZc + ", msgsount=" + this.iZd + '}';
    AppMethodBeat.o(187415);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(187423);
    paramParcel.writeString(this.fileid);
    paramParcel.writeString(this.aeskey);
    paramParcel.writeString(this.filemd5);
    paramParcel.writeInt(this.iZc);
    paramParcel.writeInt(this.iZd);
    AppMethodBeat.o(187423);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ChatroomInfoUI.LocalHistoryInfo
 * JD-Core Version:    0.7.0.1
 */