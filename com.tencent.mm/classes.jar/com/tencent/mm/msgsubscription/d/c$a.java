package com.tencent.mm.msgsubscription.d;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgStorageManager$ParcelUtil;", "", "()V", "marshall", "", "parcelable", "Landroid/os/Parcelable;", "unmarshall", "Landroid/os/Parcel;", "data", "T", "creator", "Landroid/os/Parcelable$Creator;", "(Ljava/lang/String;Landroid/os/Parcelable$Creator;)Ljava/lang/Object;", "plugin-comm_release"})
public final class c$a
{
  public static final a mqo;
  
  static
  {
    AppMethodBeat.i(216469);
    mqo = new a();
    AppMethodBeat.o(216469);
  }
  
  public static Parcel Za(String paramString)
  {
    AppMethodBeat.i(216466);
    p.k(paramString, "data");
    paramString = Base64.decode(paramString, 0);
    Parcel localParcel = Parcel.obtain();
    p.j(localParcel, "Parcel.obtain()");
    localParcel.unmarshall(paramString, 0, paramString.length);
    localParcel.setDataPosition(0);
    AppMethodBeat.o(216466);
    return localParcel;
  }
  
  public static String d(Parcelable paramParcelable)
  {
    AppMethodBeat.i(216464);
    p.k(paramParcelable, "parcelable");
    Parcel localParcel = Parcel.obtain();
    p.j(localParcel, "Parcel.obtain()");
    paramParcelable.writeToParcel(localParcel, 0);
    paramParcelable = localParcel.marshall();
    localParcel.recycle();
    paramParcelable = Base64.encodeToString(paramParcelable, 0);
    p.j(paramParcelable, "Base64.encodeToString(bytes, Base64.DEFAULT)");
    AppMethodBeat.o(216464);
    return paramParcelable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.d.c.a
 * JD-Core Version:    0.7.0.1
 */