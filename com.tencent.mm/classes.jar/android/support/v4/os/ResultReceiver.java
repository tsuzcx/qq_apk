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
  public static final Parcelable.Creator<ResultReceiver> CREATOR = new Parcelable.Creator() {};
  final boolean Np = false;
  a Nq;
  final Handler mHandler = null;
  
  ResultReceiver(Parcel paramParcel)
  {
    this.Nq = a.a.e(paramParcel.readStrongBinder());
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle) {}
  
  public final void send(int paramInt, Bundle paramBundle)
  {
    if (this.Np) {
      if (this.mHandler != null) {
        this.mHandler.post(new b(paramInt, paramBundle));
      }
    }
    while (this.Nq == null)
    {
      return;
      onReceiveResult(paramInt, paramBundle);
      return;
    }
    try
    {
      this.Nq.send(paramInt, paramBundle);
      return;
    }
    catch (RemoteException paramBundle) {}
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    try
    {
      if (this.Nq == null) {
        this.Nq = new a();
      }
      paramParcel.writeStrongBinder(this.Nq.asBinder());
      return;
    }
    finally {}
  }
  
  final class a
    extends a.a
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
  
  final class b
    implements Runnable
  {
    final Bundle Ns;
    final int mResultCode;
    
    b(int paramInt, Bundle paramBundle)
    {
      this.mResultCode = paramInt;
      this.Ns = paramBundle;
    }
    
    public final void run()
    {
      ResultReceiver.this.onReceiveResult(this.mResultCode, this.Ns);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v4.os.ResultReceiver
 * JD-Core Version:    0.7.0.1
 */