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
  private static final Set<Object> jvo = new HashSet();
  protected String hLO = Process.myPid() + hashCode();
  Messenger jvp;
  
  public void aEA() {}
  
  public final void aEC()
  {
    AppBrandMainProcessService.a(this);
  }
  
  public abstract void aEz();
  
  public final void aXm()
  {
    jvo.add(this);
  }
  
  public final void aXn()
  {
    jvo.remove(this);
  }
  
  public final boolean aXw()
  {
    if (this.jvp == null) {
      return false;
    }
    Message localMessage = Message.obtain();
    localMessage.setData(AppBrandMainProcessService.a(this, false));
    try
    {
      this.jvp.send(localMessage);
      fK(true);
      return true;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.MainProcessTask", "callback failed, class[%s], e=%s", new Object[] { getClass().getName(), localException });
      fK(false);
    }
    return false;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void e(Parcel paramParcel) {}
  
  protected void fK(boolean paramBoolean) {}
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
 * JD-Core Version:    0.7.0.1
 */