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
  public int guR;
  public int guS;
  
  static
  {
    AppMethodBeat.i(194099);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(194099);
  }
  
  public ChatroomInfoUI$LocalHistoryInfo() {}
  
  protected ChatroomInfoUI$LocalHistoryInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(194098);
    this.fileid = paramParcel.readString();
    this.aeskey = paramParcel.readString();
    this.filemd5 = paramParcel.readString();
    this.guR = paramParcel.readInt();
    this.guS = paramParcel.readInt();
    AppMethodBeat.o(194098);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(194096);
    String str = "LocalHistoryInfo{fileid='" + this.fileid + '\'' + ", aeskey='" + this.aeskey + '\'' + ", filemd5='" + this.filemd5 + '\'' + ", filelength=" + this.guR + ", msgsount=" + this.guS + '}';
    AppMethodBeat.o(194096);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(194097);
    paramParcel.writeString(this.fileid);
    paramParcel.writeString(this.aeskey);
    paramParcel.writeString(this.filemd5);
    paramParcel.writeInt(this.guR);
    paramParcel.writeInt(this.guS);
    AppMethodBeat.o(194097);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ChatroomInfoUI.LocalHistoryInfo
 * JD-Core Version:    0.7.0.1
 */