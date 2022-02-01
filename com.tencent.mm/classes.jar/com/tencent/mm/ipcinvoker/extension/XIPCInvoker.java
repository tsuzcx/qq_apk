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
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

public final class XIPCInvoker
{
  private static final Map<f<?>, WeakReference<f<?>>> mzm;
  
  static
  {
    AppMethodBeat.i(235696);
    mzm = new WeakHashMap();
    AppMethodBeat.o(235696);
  }
  
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
    paramString = paramString.mzk;
    AppMethodBeat.o(158811);
    return paramString;
  }
  
  public static void a(f<?> paramf)
  {
    AppMethodBeat.i(235695);
    if (paramf == null)
    {
      AppMethodBeat.o(235695);
      return;
    }
    synchronized (mzm)
    {
      Object localObject = (WeakReference)mzm.remove(paramf);
      if (localObject == null)
      {
        localObject = null;
        if (localObject != null) {
          j.a((f)localObject);
        }
        j.a(paramf);
        AppMethodBeat.o(235695);
        return;
      }
      localObject = (f)((WeakReference)localObject).get();
    }
  }
  
  public static <T extends d<InputType, ResultType>, InputType, ResultType> void a(String paramString, InputType paramInputType, Class<T> paramClass, final f<ResultType> paramf)
  {
    boolean bool2 = false;
    AppMethodBeat.i(158810);
    try
    {
      bool1 = com.tencent.mm.ipcinvoker.h.a.e(paramClass, com.tencent.mm.ipcinvoker.c.a.class);
      if (!bool1)
      {
        bool1 = bool2;
        if (paramf != null) {}
      }
      else
      {
        bool1 = true;
      }
      WrapperParcelable localWrapperParcelable = new WrapperParcelable(paramClass.getName(), paramInputType);
      if (bool1)
      {
        paramInputType = b.class;
        if (paramf != null) {
          break label89;
        }
        paramClass = null;
        j.a(paramString, localWrapperParcelable, paramInputType, paramClass);
        AppMethodBeat.o(158810);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        boolean bool1 = false;
        continue;
        paramInputType = a.class;
        continue;
        label89:
        paramClass = new f() {};
      }
    }
  }
  
  public static class WrapperParcelable
    implements Parcelable
  {
    public static final Parcelable.Creator<WrapperParcelable> CREATOR;
    Object mzk;
    public String mzq;
    
    static
    {
      AppMethodBeat.i(158809);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(158809);
    }
    
    private WrapperParcelable() {}
    
    public WrapperParcelable(String paramString, Object paramObject)
    {
      this.mzq = paramString;
      this.mzk = paramObject;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(158808);
      paramParcel.writeString(this.mzq);
      if (this.mzk != null)
      {
        a locala = c.cK(this.mzk);
        if (locala != null)
        {
          paramParcel.writeInt(1);
          paramParcel.writeString(locala.getClass().getName());
          locala.a(this.mzk, paramParcel);
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
    f<XIPCInvoker.WrapperParcelable> mzo;
    com.tencent.mm.ipcinvoker.e.a mzp;
    
    c(f<XIPCInvoker.WrapperParcelable> paramf)
    {
      AppMethodBeat.i(158803);
      this.mzo = paramf;
      if ((paramf instanceof com.tencent.mm.ipcinvoker.e.a)) {
        this.mzp = ((com.tencent.mm.ipcinvoker.e.a)paramf);
      }
      AppMethodBeat.o(158803);
    }
    
    public final void a(b paramb)
    {
      AppMethodBeat.i(158805);
      if (this.mzp == null)
      {
        AppMethodBeat.o(158805);
        return;
      }
      this.mzp.a(paramb);
      AppMethodBeat.o(158805);
    }
    
    public final void onCallback(Object paramObject)
    {
      AppMethodBeat.i(158804);
      if (this.mzo != null) {
        this.mzo.onCallback(new XIPCInvoker.WrapperParcelable(null, paramObject));
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