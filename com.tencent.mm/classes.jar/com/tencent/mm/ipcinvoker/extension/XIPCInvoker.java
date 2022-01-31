package com.tencent.mm.ipcinvoker.extension;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.h.b;
import com.tencent.mm.ipcinvoker.i;

public final class XIPCInvoker
{
  public static <T extends i<InputType, ResultType>, InputType, ResultType> ResultType a(String paramString, InputType paramInputType, Class<T> paramClass)
  {
    paramString = (WrapperParcelable)f.a(paramString, new WrapperParcelable(paramClass.getName(), paramInputType), XIPCInvoker.c.class);
    if (paramString == null)
    {
      b.w("IPC.XIPCInvoker", "sync invoke error, wrapper parcelable data is null!", new Object[0]);
      return null;
    }
    return paramString.dHf;
  }
  
  public static <T extends com.tencent.mm.ipcinvoker.a<InputType, ResultType>, InputType, ResultType> void a(String paramString, InputType paramInputType, Class<T> paramClass, com.tencent.mm.ipcinvoker.c<ResultType> paramc)
  {
    f.a(paramString, new WrapperParcelable(paramClass.getName(), paramInputType), XIPCInvoker.a.class, new XIPCInvoker.1(paramc));
  }
  
  private static class WrapperParcelable
    implements Parcelable
  {
    public static final Parcelable.Creator<WrapperParcelable> CREATOR = new XIPCInvoker.WrapperParcelable.1();
    Object dHf;
    String dHi;
    
    private WrapperParcelable() {}
    
    public WrapperParcelable(String paramString, Object paramObject)
    {
      this.dHi = paramString;
      this.dHf = paramObject;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.dHi);
      if (this.dHf != null)
      {
        a locala = c.Y(this.dHf);
        if (locala != null)
        {
          paramParcel.writeInt(1);
          paramParcel.writeString(locala.getClass().getName());
          locala.a(this.dHf, paramParcel);
          return;
        }
      }
      paramParcel.writeInt(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.extension.XIPCInvoker
 * JD-Core Version:    0.7.0.1
 */