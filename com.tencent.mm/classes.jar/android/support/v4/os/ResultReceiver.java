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
  final boolean eh;
  a ei;
  protected final Handler mHandler;
  
  public ResultReceiver(Handler paramHandler)
  {
    this.eh = true;
    this.mHandler = paramHandler;
  }
  
  ResultReceiver(Parcel paramParcel)
  {
    this.eh = false;
    this.mHandler = null;
    this.ei = a.a.e(paramParcel.readStrongBinder());
  }
  
  public final void c(int paramInt, Bundle paramBundle)
  {
    if (this.eh) {
      if (this.mHandler != null) {
        this.mHandler.post(new b(paramInt, paramBundle));
      }
    }
    while (this.ei == null)
    {
      return;
      onReceiveResult(paramInt, paramBundle);
      return;
    }
    try
    {
      this.ei.c(paramInt, paramBundle);
      return;
    }
    catch (RemoteException paramBundle) {}
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle) {}
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    try
    {
      if (this.ei == null) {
        this.ei = new a();
      }
      paramParcel.writeStrongBinder(this.ei.asBinder());
      return;
    }
    finally {}
  }
  
  final class a
    extends a.a
  {
    a() {}
    
    public final void c(int paramInt, Bundle paramBundle)
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
    final Bundle ek;
    final int mResultCode;
    
    b(int paramInt, Bundle paramBundle)
    {
      this.mResultCode = paramInt;
      this.ek = paramBundle;
    }
    
    public final void run()
    {
      ResultReceiver.this.onReceiveResult(this.mResultCode, this.ek);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.os.ResultReceiver
 * JD-Core Version:    0.7.0.1
 */