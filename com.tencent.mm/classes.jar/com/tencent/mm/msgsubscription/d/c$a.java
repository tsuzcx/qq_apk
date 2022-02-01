package com.tencent.mm.msgsubscription.d;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgStorageManager$ParcelUtil;", "", "()V", "marshall", "", "parcelable", "Landroid/os/Parcelable;", "unmarshall", "Landroid/os/Parcel;", "data", "T", "creator", "Landroid/os/Parcelable$Creator;", "(Ljava/lang/String;Landroid/os/Parcelable$Creator;)Ljava/lang/Object;", "plugin-comm_release"})
public final class c$a
{
  public static final a jAG;
  
  static
  {
    AppMethodBeat.i(223344);
    jAG = new a();
    AppMethodBeat.o(223344);
  }
  
  public static Parcel RB(String paramString)
  {
    AppMethodBeat.i(223343);
    p.h(paramString, "data");
    paramString = Base64.decode(paramString, 0);
    Parcel localParcel = Parcel.obtain();
    p.g(localParcel, "Parcel.obtain()");
    localParcel.unmarshall(paramString, 0, paramString.length);
    localParcel.setDataPosition(0);
    AppMethodBeat.o(223343);
    return localParcel;
  }
  
  public static String e(Parcelable paramParcelable)
  {
    AppMethodBeat.i(223342);
    p.h(paramParcelable, "parcelable");
    Parcel localParcel = Parcel.obtain();
    p.g(localParcel, "Parcel.obtain()");
    paramParcelable.writeToParcel(localParcel, 0);
    paramParcelable = localParcel.marshall();
    localParcel.recycle();
    paramParcelable = Base64.encodeToString(paramParcelable, 0);
    p.g(paramParcelable, "Base64.encodeToString(bytes, Base64.DEFAULT)");
    AppMethodBeat.o(223342);
    return paramParcelable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.d.c.a
 * JD-Core Version:    0.7.0.1
 */