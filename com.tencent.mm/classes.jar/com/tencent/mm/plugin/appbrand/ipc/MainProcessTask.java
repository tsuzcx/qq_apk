package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import java.util.Set;

public abstract class MainProcessTask
  implements Parcelable
{
  private static final Set<Object> lwZ = new HashSet();
  public String jEY = Process.myPid() + hashCode();
  Messenger lxa;
  
  public final void bDJ()
  {
    lwZ.add(this);
    AppBrandMainProcessService.c(this);
  }
  
  public final void bDK()
  {
    lwZ.remove(this);
  }
  
  public final boolean bDU()
  {
    if (this.lxa == null) {
      return false;
    }
    Message localMessage = Message.obtain();
    localMessage.setData(AppBrandMainProcessService.a(this, false));
    try
    {
      this.lxa.send(localMessage);
      hg(true);
      return true;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.MainProcessTask", "callback failed, class[%s], e=%s", new Object[] { getClass().getName(), localException });
      hg(false);
    }
    return false;
  }
  
  public abstract void bjj();
  
  public void bjk() {}
  
  public final String bjl()
  {
    return this.jEY;
  }
  
  public final void bjm()
  {
    AppBrandMainProcessService.a(this);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void f(Parcel paramParcel) {}
  
  protected void hg(boolean paramBoolean) {}
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
 * JD-Core Version:    0.7.0.1
 */