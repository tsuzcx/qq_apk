package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashSet;
import java.util.Set;

public abstract class MainProcessTask
  implements Parcelable
{
  private static final Set<Object> ktn = new HashSet();
  protected String iIu = Process.myPid() + hashCode();
  Messenger kto;
  
  public abstract void aOX();
  
  public void aOY() {}
  
  public final void aPa()
  {
    AppBrandMainProcessService.a(this);
  }
  
  public final boolean biG()
  {
    if (this.kto == null) {
      return false;
    }
    Message localMessage = Message.obtain();
    localMessage.setData(AppBrandMainProcessService.a(this, false));
    try
    {
      this.kto.send(localMessage);
      gj(true);
      return true;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.MainProcessTask", "callback failed, class[%s], e=%s", new Object[] { getClass().getName(), localException });
      gj(false);
    }
    return false;
  }
  
  public final void biw()
  {
    ktn.add(this);
  }
  
  public final void bix()
  {
    ktn.remove(this);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void e(Parcel paramParcel) {}
  
  protected void gj(boolean paramBoolean) {}
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
 * JD-Core Version:    0.7.0.1
 */