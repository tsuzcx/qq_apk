package com.tencent.mm.plugin.appbrand.jsapi.liteapp;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.y;

public final class JsApiPreloadLiteApp
  extends c<y>
{
  public static final int CTRL_INDEX = -2;
  private static final String NAME = "preloadLiteApp";
  
  static class PreloadLiteAppData
    implements Parcelable
  {
    public static final Parcelable.Creator<PreloadLiteAppData> CREATOR;
    String appId;
    String egj;
    Boolean saL;
    
    static
    {
      AppMethodBeat.i(326468);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(326468);
    }
    
    protected PreloadLiteAppData(Parcel paramParcel)
    {
      AppMethodBeat.i(326464);
      this.saL = Boolean.FALSE;
      this.appId = "";
      this.egj = "";
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.saL = Boolean.valueOf(bool);
        this.appId = paramParcel.readString();
        this.egj = paramParcel.readString();
        AppMethodBeat.o(326464);
        return;
      }
    }
    
    public PreloadLiteAppData(Boolean paramBoolean, String paramString1, String paramString2)
    {
      this.saL = Boolean.FALSE;
      this.appId = "";
      this.egj = "";
      this.saL = paramBoolean;
      this.appId = paramString1;
      this.egj = paramString2;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(326472);
      if (this.saL.booleanValue()) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        paramParcel.writeString(this.appId);
        paramParcel.writeString(this.egj);
        AppMethodBeat.o(326472);
        return;
      }
    }
  }
  
  static class a
    implements d<JsApiPreloadLiteApp.PreloadLiteAppData, IPCBoolean>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.liteapp.JsApiPreloadLiteApp
 * JD-Core Version:    0.7.0.1
 */