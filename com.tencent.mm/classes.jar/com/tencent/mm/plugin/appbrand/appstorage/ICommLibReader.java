package com.tencent.mm.plugin.appbrand.appstorage;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.luggage.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.o;
import com.tencent.mm.sdk.platformtools.ad;

public abstract interface ICommLibReader
  extends Parcelable, b, o, Comparable<ICommLibReader>
{
  public abstract String Le(String paramString);
  
  public static final class b
  {
    public static void a(ICommLibReader paramICommLibReader, Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(178572);
      if (paramICommLibReader == null)
      {
        paramParcel.writeString(null);
        AppMethodBeat.o(178572);
        return;
      }
      paramParcel.writeString(paramICommLibReader.getClass().getName());
      paramParcel.writeParcelable(paramICommLibReader, paramInt);
      AppMethodBeat.o(178572);
    }
    
    public static ICommLibReader g(Parcel paramParcel)
    {
      AppMethodBeat.i(178573);
      String str = paramParcel.readString();
      if (TextUtils.isEmpty(str))
      {
        AppMethodBeat.o(178573);
        return null;
      }
      try
      {
        paramParcel = (ICommLibReader)paramParcel.readParcelable(Class.forName(str).getClassLoader());
        AppMethodBeat.o(178573);
        return paramParcel;
      }
      catch (Exception paramParcel)
      {
        ad.e("Luggage.WXA.ICommLibReader.ParcelHelper", "readFromParcel e=%s", new Object[] { paramParcel });
        AppMethodBeat.o(178573);
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader
 * JD-Core Version:    0.7.0.1
 */