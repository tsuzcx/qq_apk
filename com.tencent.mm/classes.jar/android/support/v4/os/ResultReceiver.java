package android.support.v4.os;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public class ResultReceiver
  implements Parcelable
{
  public static final Parcelable.Creator<ResultReceiver> CREATOR = new ResultReceiver.1();
  final boolean CU = false;
  b CV;
  final Handler mHandler = null;
  
  ResultReceiver(Parcel paramParcel)
  {
    this.CV = b.a.d(paramParcel.readStrongBinder());
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void onReceiveResult(int paramInt, Bundle paramBundle) {}
  
  public final void send(int paramInt, Bundle paramBundle)
  {
    if (this.CU) {
      if (this.mHandler != null) {
        this.mHandler.post(new ResultReceiver.b(this, paramInt, paramBundle));
      }
    }
    while (this.CV == null)
    {
      return;
      onReceiveResult(paramInt, paramBundle);
      return;
    }
    try
    {
      this.CV.send(paramInt, paramBundle);
      return;
    }
    catch (RemoteException paramBundle) {}
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    try
    {
      if (this.CV == null) {
        this.CV = new a();
      }
      paramParcel.writeStrongBinder(this.CV.asBinder());
      return;
    }
    finally {}
  }
  
  final class a
    extends b.a
  {
    a() {}
    
    public final void send(int paramInt, Bundle paramBundle)
    {
      if (ResultReceiver.this.mHandler != null)
      {
        ResultReceiver.this.mHandler.post(new ResultReceiver.b(ResultReceiver.this, paramInt, paramBundle));
        return;
      }
      ResultReceiver.this.onReceiveResult(paramInt, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v4.os.ResultReceiver
 * JD-Core Version:    0.7.0.1
 */