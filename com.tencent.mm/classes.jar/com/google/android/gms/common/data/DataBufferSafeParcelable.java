package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class DataBufferSafeParcelable<T extends SafeParcelable>
  extends AbstractDataBuffer<T>
{
  public static final String DATA_FIELD = "data";
  private static final String[] zznk = { "data" };
  private final Parcelable.Creator<T> zznl;
  
  public DataBufferSafeParcelable(DataHolder paramDataHolder, Parcelable.Creator<T> paramCreator)
  {
    super(paramDataHolder);
    this.zznl = paramCreator;
  }
  
  public static <T extends SafeParcelable> void addValue(DataHolder.Builder paramBuilder, T paramT)
  {
    AppMethodBeat.i(11558);
    Parcel localParcel = Parcel.obtain();
    paramT.writeToParcel(localParcel, 0);
    paramT = new ContentValues();
    paramT.put("data", localParcel.marshall());
    paramBuilder.withRow(paramT);
    localParcel.recycle();
    AppMethodBeat.o(11558);
  }
  
  public static DataHolder.Builder buildDataHolder()
  {
    AppMethodBeat.i(11557);
    DataHolder.Builder localBuilder = DataHolder.builder(zznk);
    AppMethodBeat.o(11557);
    return localBuilder;
  }
  
  public T get(int paramInt)
  {
    AppMethodBeat.i(11559);
    Object localObject = this.mDataHolder.getByteArray("data", paramInt, this.mDataHolder.getWindowIndex(paramInt));
    Parcel localParcel = Parcel.obtain();
    localParcel.unmarshall((byte[])localObject, 0, localObject.length);
    localParcel.setDataPosition(0);
    localObject = (SafeParcelable)this.zznl.createFromParcel(localParcel);
    localParcel.recycle();
    AppMethodBeat.o(11559);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.data.DataBufferSafeParcelable
 * JD-Core Version:    0.7.0.1
 */