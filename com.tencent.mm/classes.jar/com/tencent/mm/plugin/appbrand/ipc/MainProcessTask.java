package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashSet;
import java.util.Set;

public abstract class MainProcessTask
  implements Parcelable
{
  private static final Set<Object> kpY = new HashSet();
  protected String iFB = Process.myPid() + hashCode();
  Messenger kpZ;
  
  public abstract void aOA();
  
  public void aOB() {}
  
  public final void aOD()
  {
    AppBrandMainProcessService.a(this);
  }
  
  public final void bhN()
  {
    kpY.add(this);
  }
  
  public final void bhO()
  {
    kpY.remove(this);
  }
  
  public final boolean bhX()
  {
    if (this.kpZ == null) {
      return false;
    }
    Message localMessage = Message.obtain();
    localMessage.setData(AppBrandMainProcessService.a(this, false));
    try
    {
      this.kpZ.send(localMessage);
      gl(true);
      return true;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.MainProcessTask", "callback failed, class[%s], e=%s", new Object[] { getClass().getName(), localException });
      gl(false);
    }
    return false;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void e(Parcel paramParcel) {}
  
  protected void gl(boolean paramBoolean) {}
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
 * JD-Core Version:    0.7.0.1
 */