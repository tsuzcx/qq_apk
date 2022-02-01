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
    private int fuQ;
    private String kHR;
    
    static
    {
      AppMethodBeat.i(227703);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(227703);
    }
    
    public IPCDeclarePromptCallbackParam(int paramInt, boolean paramBoolean, String paramString)
    {
      this.fuQ = paramInt;
      this.cancel = paramBoolean;
      this.kHR = paramString;
    }
    
    protected IPCDeclarePromptCallbackParam(Parcel paramParcel)
    {
      AppMethodBeat.i(227701);
      this.fuQ = paramParcel.readInt();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.cancel = bool;
        this.kHR = paramParcel.readString();
        AppMethodBeat.o(227701);
        return;
      }
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(227702);
      paramParcel.writeInt(this.fuQ);
      if (this.cancel) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        paramParcel.writeString(this.kHR);
        AppMethodBeat.o(227702);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandUIDeclarePromptIPC
 * JD-Core Version:    0.7.0.1
 */