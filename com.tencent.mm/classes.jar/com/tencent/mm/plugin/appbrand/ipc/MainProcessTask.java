package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashSet;
import java.util.Set;

public abstract class MainProcessTask
  implements Parcelable
{
  private static final Set<Object> jVK = new HashSet();
  protected String imk = Process.myPid() + hashCode();
  Messenger jVL;
  
  public abstract void aLq();
  
  public void aLr() {}
  
  public final void aLt()
  {
    AppBrandMainProcessService.a(this);
  }
  
  public final void bej()
  {
    jVK.add(this);
  }
  
  public final void bek()
  {
    jVK.remove(this);
  }
  
  public final boolean bet()
  {
    if (this.jVL == null) {
      return false;
    }
    Message localMessage = Message.obtain();
    localMessage.setData(AppBrandMainProcessService.a(this, false));
    try
    {
      this.jVL.send(localMessage);
      gg(true);
      return true;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.MainProcessTask", "callback failed, class[%s], e=%s", new Object[] { getClass().getName(), localException });
      gg(false);
    }
    return false;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void e(Parcel paramParcel) {}
  
  protected void gg(boolean paramBoolean) {}
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
 * JD-Core Version:    0.7.0.1
 */