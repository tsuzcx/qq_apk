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
    paramString = paramString.gyb;
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
    Object gyb;
    String gye;
    
    static
    {
      AppMethodBeat.i(158809);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(158809);
    }
    
    private WrapperParcelable() {}
    
    public WrapperParcelable(String paramString, Object paramObject)
    {
      this.gye = paramString;
      this.gyb = paramObject;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(158808);
      paramParcel.writeString(this.gye);
      if (this.gyb != null)
      {
        a locala = c.bh(this.gyb);
        if (locala != null)
        {
          paramParcel.writeInt(1);
          paramParcel.writeString(locala.getClass().getName());
          locala.a(this.gyb, paramParcel);
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
  
  static final class b
    implements d, com.tencent.mm.ipcinvoker.e.a
  {
    d<XIPCInvoker.WrapperParcelable> gyc;
    com.tencent.mm.ipcinvoker.e.a gyd;
    
    b(d<XIPCInvoker.WrapperParcelable> paramd)
    {
      AppMethodBeat.i(158803);
      this.gyc = paramd;
      if ((paramd instanceof com.tencent.mm.ipcinvoker.e.a)) {
        this.gyd = ((com.tencent.mm.ipcinvoker.e.a)paramd);
      }
      AppMethodBeat.o(158803);
    }
    
    public final void a(com.tencent.mm.ipcinvoker.e.b paramb)
    {
      AppMethodBeat.i(158805);
      if (this.gyd == null)
      {
        AppMethodBeat.o(158805);
        return;
      }
      this.gyd.a(paramb);
      AppMethodBeat.o(158805);
    }
    
    public final void be(Object paramObject)
    {
      AppMethodBeat.i(158804);
      if (this.gyc != null) {
        this.gyc.be(new XIPCInvoker.WrapperParcelable(null, paramObject));
      }
      AppMethodBeat.o(158804);
    }
  }
  
  static class c
    implements k<XIPCInvoker.WrapperParcelable, XIPCInvoker.WrapperParcelable>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.extension.XIPCInvoker
 * JD-Core Version:    0.7.0.1
 */