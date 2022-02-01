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
    private int hDp;
    private String nBK;
    
    static
    {
      AppMethodBeat.i(282515);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(282515);
    }
    
    public IPCDeclarePromptCallbackParam(int paramInt, boolean paramBoolean, String paramString)
    {
      this.hDp = paramInt;
      this.cancel = paramBoolean;
      this.nBK = paramString;
    }
    
    protected IPCDeclarePromptCallbackParam(Parcel paramParcel)
    {
      AppMethodBeat.i(282511);
      this.hDp = paramParcel.readInt();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.cancel = bool;
        this.nBK = paramParcel.readString();
        AppMethodBeat.o(282511);
        return;
      }
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(282513);
      paramParcel.writeInt(this.hDp);
      if (this.cancel) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        paramParcel.writeString(this.nBK);
        AppMethodBeat.o(282513);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandUIDeclarePromptIPC
 * JD-Core Version:    0.7.0.1
 */