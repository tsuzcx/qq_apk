package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class zzd<T extends SafeParcelable>
  extends AbstractDataBuffer<T>
{
  private static final String[] zzaDN = { "data" };
  private final Parcelable.Creator<T> zzaDO;
  
  public zzd(DataHolder paramDataHolder, Parcelable.Creator<T> paramCreator)
  {
    super(paramDataHolder);
    this.zzaDO = paramCreator;
  }
  
  public static <T extends SafeParcelable> void zza(DataHolder.zza paramzza, T paramT)
  {
    Parcel localParcel = Parcel.obtain();
    paramT.writeToParcel(localParcel, 0);
    paramT = new ContentValues();
    paramT.put("data", localParcel.marshall());
    paramzza.zza(paramT);
    localParcel.recycle();
  }
  
  public static DataHolder.zza zzxj()
  {
    return DataHolder.zzc(zzaDN);
  }
  
  public T zzcH(int paramInt)
  {
    Object localObject = this.zzaBi.zzg("data", paramInt, this.zzaBi.zzcI(paramInt));
    Parcel localParcel = Parcel.obtain();
    localParcel.unmarshall((byte[])localObject, 0, localObject.length);
    localParcel.setDataPosition(0);
    localObject = (SafeParcelable)this.zzaDO.createFromParcel(localParcel);
    localParcel.recycle();
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.data.zzd
 * JD-Core Version:    0.7.0.1
 */