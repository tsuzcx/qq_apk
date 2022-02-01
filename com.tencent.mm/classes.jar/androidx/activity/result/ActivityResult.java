package androidx.activity.result;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ActivityResult
  implements Parcelable
{
  public static final Parcelable.Creator<ActivityResult> CREATOR;
  final Intent eP;
  final int mResultCode;
  
  static
  {
    AppMethodBeat.i(199230);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(199230);
  }
  
  public ActivityResult(int paramInt, Intent paramIntent)
  {
    this.mResultCode = paramInt;
    this.eP = paramIntent;
  }
  
  ActivityResult(Parcel paramParcel)
  {
    AppMethodBeat.i(199226);
    this.mResultCode = paramParcel.readInt();
    if (paramParcel.readInt() == 0) {}
    for (paramParcel = null;; paramParcel = (Intent)Intent.CREATOR.createFromParcel(paramParcel))
    {
      this.eP = paramParcel;
      AppMethodBeat.o(199226);
      return;
    }
  }
  
  public final Intent bm()
  {
    return this.eP;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final int getResultCode()
  {
    return this.mResultCode;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(199248);
    StringBuilder localStringBuilder = new StringBuilder("ActivityResult{resultCode=");
    int i = this.mResultCode;
    String str;
    switch (i)
    {
    default: 
      str = String.valueOf(i);
    }
    for (;;)
    {
      str = str + ", data=" + this.eP + '}';
      AppMethodBeat.o(199248);
      return str;
      str = "RESULT_OK";
      continue;
      str = "RESULT_CANCELED";
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(199254);
    paramParcel.writeInt(this.mResultCode);
    if (this.eP == null) {}
    for (int i = 0;; i = 1)
    {
      paramParcel.writeInt(i);
      if (this.eP != null) {
        this.eP.writeToParcel(paramParcel, paramInt);
      }
      AppMethodBeat.o(199254);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.activity.result.ActivityResult
 * JD-Core Version:    0.7.0.1
 */