package com.tencent.mm.ipcinvoker.extension;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.k;

public final class XIPCInvoker
{
  public static <T extends k<InputType, ResultType>, InputType, ResultType> ResultType a(String paramString, InputType paramInputType, Class<T> paramClass)
  {
    AppMethodBeat.i(158811);
    paramString = (WrapperParcelable)h.a(paramString, new WrapperParcelable(paramClass.getName(), paramInputType), c.class);
    if (paramString == null)
    {
      com.tencent.mm.ipcinvoker.h.b.w("IPC.XIPCInvoker", "sync invoke error, wrapper parcelable data is null!", new Object[0]);
      AppMethodBeat.o(158811);
      return null;
    }
    paramString = paramString.fZL;
    AppMethodBeat.o(158811);
    return paramString;
  }
  
  public static <T extends com.tencent.mm.ipcinvoker.b<InputType, ResultType>, InputType, ResultType> void a(String paramString, InputType paramInputType, Class<T> paramClass, d<ResultType> paramd)
  {
    AppMethodBeat.i(158810);
    h.a(paramString, new WrapperParcelable(paramClass.getName(), paramInputType), a.class, new d() {});
    AppMethodBeat.o(158810);
  }
  
  static class WrapperParcelable
    implements Parcelable
  {
    public static final Parcelable.Creator<WrapperParcelable> CREATOR;
    Object fZL;
    String fZO;
    
    static
    {
      AppMethodBeat.i(158809);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(158809);
    }
    
    private WrapperParcelable() {}
    
    public WrapperParcelable(String paramString, Object paramObject)
    {
      this.fZO = paramString;
      this.fZL = paramObject;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(158808);
      paramParcel.writeString(this.fZO);
      if (this.fZL != null)
      {
        a locala = c.bi(this.fZL);
        if (locala != null)
        {
          paramParcel.writeInt(1);
          paramParcel.writeString(locala.getClass().getName());
          locala.a(this.fZL, paramParcel);
          AppMethodBeat.o(158808);
          return;
        }
      }
      paramParcel.writeInt(0);
      AppMethodBeat.o(158808);
    }
  }
  
  static class a
    implements com.tencent.mm.ipcinvoker.b<XIPCInvoker.WrapperParcelable, XIPCInvoker.WrapperParcelable>
  {}
  
  static class c
    implements k<XIPCInvoker.WrapperParcelable, XIPCInvoker.WrapperParcelable>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.extension.XIPCInvoker
 * JD-Core Version:    0.7.0.1
 */