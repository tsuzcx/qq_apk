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
    private int eRn;
    private String jFZ;
    
    static
    {
      AppMethodBeat.i(223158);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(223158);
    }
    
    public IPCDeclarePromptCallbackParam(int paramInt, boolean paramBoolean, String paramString)
    {
      this.eRn = paramInt;
      this.cancel = paramBoolean;
      this.jFZ = paramString;
    }
    
    protected IPCDeclarePromptCallbackParam(Parcel paramParcel)
    {
      AppMethodBeat.i(223156);
      this.eRn = paramParcel.readInt();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.cancel = bool;
        this.jFZ = paramParcel.readString();
        AppMethodBeat.o(223156);
        return;
      }
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(223157);
      paramParcel.writeInt(this.eRn);
      if (this.cancel) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        paramParcel.writeString(this.jFZ);
        AppMethodBeat.o(223157);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandUIDeclarePromptIPC
 * JD-Core Version:    0.7.0.1
 */