package com.tencent.mm.ipcinvoker.extension;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.e.b;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.m;

public final class XIPCInvoker
{
  public static <T extends m<InputType, ResultType>, InputType, ResultType> ResultType a(String paramString, InputType paramInputType, Class<T> paramClass)
  {
    AppMethodBeat.i(158811);
    paramString = (WrapperParcelable)j.a(paramString, new WrapperParcelable(paramClass.getName(), paramInputType), d.class);
    if (paramString == null)
    {
      com.tencent.mm.ipcinvoker.h.c.w("IPC.XIPCInvoker", "sync invoke error, wrapper parcelable data is null!", new Object[0]);
      AppMethodBeat.o(158811);
      return null;
    }
    paramString = paramString.jZm;
    AppMethodBeat.o(158811);
    return paramString;
  }
  
  public static <T extends d<InputType, ResultType>, InputType, ResultType> void a(String paramString, InputType paramInputType, Class<T> paramClass, f<ResultType> paramf)
  {
    AppMethodBeat.i(158810);
    int i = 0;
    try
    {
      boolean bool = com.tencent.mm.ipcinvoker.h.a.e(paramClass, com.tencent.mm.ipcinvoker.c.a.class);
      i = bool;
    }
    catch (Exception localException)
    {
      label20:
      break label20;
    }
    paramClass = new WrapperParcelable(paramClass.getName(), paramInputType);
    if (i != 0) {}
    for (paramInputType = b.class;; paramInputType = a.class)
    {
      j.a(paramString, paramClass, paramInputType, new f() {});
      AppMethodBeat.o(158810);
      return;
    }
  }
  
  static class WrapperParcelable
    implements Parcelable
  {
    public static final Parcelable.Creator<WrapperParcelable> CREATOR;
    Object jZm;
    String jZp;
    
    static
    {
      AppMethodBeat.i(158809);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(158809);
    }
    
    private WrapperParcelable() {}
    
    public WrapperParcelable(String paramString, Object paramObject)
    {
      this.jZp = paramString;
      this.jZm = paramObject;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(158808);
      paramParcel.writeString(this.jZp);
      if (this.jZm != null)
      {
        a locala = c.bq(this.jZm);
        if (locala != null)
        {
          paramParcel.writeInt(1);
          paramParcel.writeString(locala.getClass().getName());
          locala.a(this.jZm, paramParcel);
          AppMethodBeat.o(158808);
          return;
        }
      }
      paramParcel.writeInt(0);
      AppMethodBeat.o(158808);
    }
  }
  
  static class a
    implements d<XIPCInvoker.WrapperParcelable, XIPCInvoker.WrapperParcelable>
  {}
  
  @com.tencent.mm.ipcinvoker.c.a
  static class b
    extends XIPCInvoker.a
    implements com.tencent.mm.ipcinvoker.c<XIPCInvoker.WrapperParcelable, XIPCInvoker.WrapperParcelable>
  {
    private b()
    {
      super();
    }
  }
  
  static final class c
    implements com.tencent.mm.ipcinvoker.e.a, f
  {
    f<XIPCInvoker.WrapperParcelable> jZn;
    com.tencent.mm.ipcinvoker.e.a jZo;
    
    c(f<XIPCInvoker.WrapperParcelable> paramf)
    {
      AppMethodBeat.i(158803);
      this.jZn = paramf;
      if ((paramf instanceof com.tencent.mm.ipcinvoker.e.a)) {
        this.jZo = ((com.tencent.mm.ipcinvoker.e.a)paramf);
      }
      AppMethodBeat.o(158803);
    }
    
    public final void a(b paramb)
    {
      AppMethodBeat.i(158805);
      if (this.jZo == null)
      {
        AppMethodBeat.o(158805);
        return;
      }
      this.jZo.a(paramb);
      AppMethodBeat.o(158805);
    }
    
    public final void aH(Object paramObject)
    {
      AppMethodBeat.i(158804);
      if (this.jZn != null) {
        this.jZn.aH(new XIPCInvoker.WrapperParcelable(null, paramObject));
      }
      AppMethodBeat.o(158804);
    }
  }
  
  static class d
    implements m<XIPCInvoker.WrapperParcelable, XIPCInvoker.WrapperParcelable>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.extension.XIPCInvoker
 * JD-Core Version:    0.7.0.1
 */