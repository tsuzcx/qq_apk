package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashSet;
import java.util.Set;

public abstract class MainProcessTask
  implements Parcelable
{
  private static final Set<Object> hwB = new HashSet();
  Messenger hwC;
  protected String hwp = Process.myPid() + hashCode();
  
  public final void aBj()
  {
    hwB.add(this);
  }
  
  public final void aBk()
  {
    hwB.remove(this);
  }
  
  public final boolean aBp()
  {
    if (this.hwC == null) {
      return false;
    }
    Message localMessage = Message.obtain();
    localMessage.setData(AppBrandMainProcessService.a(this, false));
    try
    {
      this.hwC.send(localMessage);
      dY(true);
      return true;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.MainProcessTask", "callback failed, class[%s], e=%s", new Object[] { getClass().getName(), localException });
      dY(false);
    }
    return false;
  }
  
  public abstract void ata();
  
  public void atb() {}
  
  protected void dY(boolean paramBoolean) {}
  
  public int describeContents()
  {
    return 0;
  }
  
  public void f(Parcel paramParcel) {}
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
 * JD-Core Version:    0.7.0.1
 */