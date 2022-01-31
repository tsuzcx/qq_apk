package com.tencent.mm.plugin.emojicapture.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class EmojiCaptureUploadManager$UploadTask
  implements Parcelable
{
  public static final Parcelable.Creator<UploadTask> CREATOR;
  public String lsX;
  public EmojiCaptureReporter lsY;
  
  static
  {
    AppMethodBeat.i(57467);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(57467);
  }
  
  public EmojiCaptureUploadManager$UploadTask(Parcel paramParcel)
  {
    AppMethodBeat.i(57465);
    this.lsX = paramParcel.readString();
    this.lsY = ((EmojiCaptureReporter)paramParcel.readParcelable(EmojiCaptureReporter.class.getClassLoader()));
    AppMethodBeat.o(57465);
  }
  
  public EmojiCaptureUploadManager$UploadTask(String paramString, EmojiCaptureReporter paramEmojiCaptureReporter)
  {
    this.lsX = paramString;
    this.lsY = paramEmojiCaptureReporter;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(57466);
    paramParcel.writeString(this.lsX);
    paramParcel.writeParcelable(this.lsY, paramInt);
    AppMethodBeat.o(57466);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.api.EmojiCaptureUploadManager.UploadTask
 * JD-Core Version:    0.7.0.1
 */