package com.tencent.mm.plugin.appbrand.ui;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.type.IPCVoid;

public class AppBrandUIDeclarePromptIPC
  implements b<IPCDeclarePromptCallbackParam, IPCVoid>
{
  public static final class IPCDeclarePromptCallbackParam
    implements Parcelable
  {
    public static final Parcelable.Creator<IPCDeclarePromptCallbackParam> CREATOR;
    private boolean cancel;
    private int ePC;
    private String jDb;
    
    static
    {
      AppMethodBeat.i(188925);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(188925);
    }
    
    public IPCDeclarePromptCallbackParam(int paramInt, boolean paramBoolean, String paramString)
    {
      this.ePC = paramInt;
      this.cancel = paramBoolean;
      this.jDb = paramString;
    }
    
    protected IPCDeclarePromptCallbackParam(Parcel paramParcel)
    {
      AppMethodBeat.i(188923);
      this.ePC = paramParcel.readInt();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.cancel = bool;
        this.jDb = paramParcel.readString();
        AppMethodBeat.o(188923);
        return;
      }
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(188924);
      paramParcel.writeInt(this.ePC);
      if (this.cancel) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        paramParcel.writeString(this.jDb);
        AppMethodBeat.o(188924);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandUIDeclarePromptIPC
 * JD-Core Version:    0.7.0.1
 */