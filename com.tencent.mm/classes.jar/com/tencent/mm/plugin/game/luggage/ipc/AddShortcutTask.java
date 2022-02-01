package com.tencent.mm.plugin.game.luggage.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.webview.model.e;
import com.tencent.mm.plugin.webview.model.e.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;

public class AddShortcutTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<AddShortcutTask> CREATOR;
  public String appId;
  public Runnable jWP;
  public boolean success;
  public String username;
  
  static
  {
    AppMethodBeat.i(83039);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(83039);
  }
  
  public AddShortcutTask() {}
  
  private AddShortcutTask(Parcel paramParcel)
  {
    AppMethodBeat.i(83037);
    e(paramParcel);
    AppMethodBeat.o(83037);
  }
  
  public final void aLq()
  {
    AppMethodBeat.i(83033);
    if ((bs.isNullOrNil(this.appId)) || (bs.isNullOrNil(this.username)))
    {
      ac.e("MicroMsg.AddShortcutTask", "appid or username is null");
      this.success = false;
      AppMethodBeat.o(83033);
      return;
    }
    e.a(ai.getContext(), this.username, this.appId, new e.a()
    {
      public final void mF(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(83031);
        AddShortcutTask.this.success = paramAnonymousBoolean;
        AddShortcutTask.a(AddShortcutTask.this);
        AppMethodBeat.o(83031);
      }
    });
    AppMethodBeat.o(83033);
  }
  
  public final void aLr()
  {
    AppMethodBeat.i(83034);
    if (this.jWP != null) {
      this.jWP.run();
    }
    AppMethodBeat.o(83034);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void e(Parcel paramParcel)
  {
    boolean bool = true;
    AppMethodBeat.i(83035);
    this.username = paramParcel.readString();
    this.appId = paramParcel.readString();
    if (paramParcel.readByte() == 1) {}
    for (;;)
    {
      this.success = bool;
      AppMethodBeat.o(83035);
      return;
      bool = false;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(83036);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.appId);
    if (this.success) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      AppMethodBeat.o(83036);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.ipc.AddShortcutTask
 * JD-Core Version:    0.7.0.1
 */