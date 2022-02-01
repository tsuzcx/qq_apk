package com.tencent.mm.plugin.appbrand.jsapi.liteapp;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.plugin.lite.api.c.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class JsApiOpenLiteApp
  extends c<y>
{
  public static final int CTRL_INDEX = -2;
  private static final String NAME = "openLiteApp";
  
  static class OpenLiteAppData
    implements Parcelable
  {
    public static final Parcelable.Creator<OpenLiteAppData> CREATOR;
    Bundle bundle;
    Boolean saG;
    Boolean saH;
    
    static
    {
      AppMethodBeat.i(326478);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(326478);
    }
    
    public OpenLiteAppData(Bundle paramBundle, Boolean paramBoolean1, Boolean paramBoolean2)
    {
      this.bundle = paramBundle;
      this.saG = paramBoolean1;
      this.saH = paramBoolean2;
    }
    
    protected OpenLiteAppData(Parcel paramParcel)
    {
      AppMethodBeat.i(326477);
      this.bundle = paramParcel.readBundle();
      if (paramParcel.readByte() != 0)
      {
        bool1 = true;
        this.saG = Boolean.valueOf(bool1);
        if (paramParcel.readByte() == 0) {
          break label64;
        }
      }
      label64:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.saH = Boolean.valueOf(bool1);
        AppMethodBeat.o(326477);
        return;
        bool1 = false;
        break;
      }
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = 1;
      AppMethodBeat.i(326479);
      paramParcel.writeBundle(this.bundle);
      if (this.saG.booleanValue())
      {
        paramInt = 1;
        paramParcel.writeByte((byte)paramInt);
        if (!this.saH.booleanValue()) {
          break label62;
        }
      }
      label62:
      for (paramInt = i;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        AppMethodBeat.o(326479);
        return;
        paramInt = 0;
        break;
      }
    }
  }
  
  static class a
    implements d<JsApiOpenLiteApp.OpenLiteAppData, IPCBoolean>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.liteapp.JsApiOpenLiteApp
 * JD-Core Version:    0.7.0.1
 */