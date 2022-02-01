package com.tencent.mm.plugin.appbrand.ui;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCVoid;

public class AppBrandUIDeclarePromptIPC
  implements d<IPCDeclarePromptCallbackParam, IPCVoid>
{
  public static final class IPCDeclarePromptCallbackParam
    implements Parcelable
  {
    public static final Parcelable.Creator<IPCDeclarePromptCallbackParam> CREATOR;
    private boolean cancel;
    private int hyY;
    private String qBb;
    
    static
    {
      AppMethodBeat.i(322398);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(322398);
    }
    
    public IPCDeclarePromptCallbackParam(int paramInt, boolean paramBoolean, String paramString)
    {
      this.hyY = paramInt;
      this.cancel = paramBoolean;
      this.qBb = paramString;
    }
    
    protected IPCDeclarePromptCallbackParam(Parcel paramParcel)
    {
      AppMethodBeat.i(322378);
      this.hyY = paramParcel.readInt();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.cancel = bool;
        this.qBb = paramParcel.readString();
        AppMethodBeat.o(322378);
        return;
      }
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(322407);
      paramParcel.writeInt(this.hyY);
      if (this.cancel) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        paramParcel.writeString(this.qBb);
        AppMethodBeat.o(322407);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandUIDeclarePromptIPC
 * JD-Core Version:    0.7.0.1
 */