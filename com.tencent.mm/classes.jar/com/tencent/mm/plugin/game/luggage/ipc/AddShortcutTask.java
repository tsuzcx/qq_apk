package com.tencent.mm.plugin.game.luggage.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.base.model.d;
import com.tencent.mm.plugin.webview.luggage.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public class AddShortcutTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<AddShortcutTask> CREATOR = new AddShortcutTask.2();
  public String appId;
  public Runnable gfD;
  public boolean success;
  public String username;
  
  public AddShortcutTask() {}
  
  private AddShortcutTask(Parcel paramParcel)
  {
    e(paramParcel);
  }
  
  public final void Zu()
  {
    if ((bk.bl(this.appId)) || (bk.bl(this.username)))
    {
      y.e("MicroMsg.AddShortcutTask", "appid or username is null");
      this.success = false;
      return;
    }
    d.a(ae.getContext(), this.username, this.appId, new AddShortcutTask.1(this));
  }
  
  public final void Zv()
  {
    if (this.gfD != null) {
      this.gfD.run();
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void e(Parcel paramParcel)
  {
    boolean bool = true;
    this.username = paramParcel.readString();
    this.appId = paramParcel.readString();
    if (paramParcel.readByte() == 1) {}
    for (;;)
    {
      this.success = bool;
      return;
      bool = false;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.appId);
    if (this.success) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.ipc.AddShortcutTask
 * JD-Core Version:    0.7.0.1
 */