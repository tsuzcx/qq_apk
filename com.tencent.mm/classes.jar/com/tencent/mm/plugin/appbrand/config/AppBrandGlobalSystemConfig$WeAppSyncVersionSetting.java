package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.LongSparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.List;

public final class AppBrandGlobalSystemConfig$WeAppSyncVersionSetting
  implements Parcelable
{
  public static final Parcelable.Creator<WeAppSyncVersionSetting> CREATOR;
  public long nXS;
  public long nXT;
  public int nXU;
  public int nXV;
  public LongSparseArray<List<String>> nXW;
  
  static
  {
    AppMethodBeat.i(146980);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(146980);
  }
  
  AppBrandGlobalSystemConfig$WeAppSyncVersionSetting()
  {
    this.nXS = 21600L;
    this.nXT = 604800L;
    this.nXU = 1000;
    this.nXV = 100;
  }
  
  AppBrandGlobalSystemConfig$WeAppSyncVersionSetting(Parcel paramParcel)
  {
    AppMethodBeat.i(146979);
    this.nXS = 21600L;
    this.nXT = 604800L;
    this.nXU = 1000;
    this.nXV = 100;
    this.nXS = paramParcel.readLong();
    this.nXT = paramParcel.readLong();
    this.nXU = paramParcel.readInt();
    this.nXV = paramParcel.readInt();
    int j = paramParcel.readInt();
    if (j > 0)
    {
      this.nXW = new LongSparseArray(j);
      int i = 0;
      while (i < j)
      {
        long l = paramParcel.readLong();
        LinkedList localLinkedList = new LinkedList();
        paramParcel.readStringList(localLinkedList);
        this.nXW.put(l, localLinkedList);
        i += 1;
      }
    }
    AppMethodBeat.o(146979);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(146978);
    paramParcel.writeLong(this.nXS);
    paramParcel.writeLong(this.nXT);
    paramParcel.writeInt(this.nXU);
    paramParcel.writeInt(this.nXV);
    if ((this.nXW == null) || (this.nXW.size() == 0))
    {
      paramParcel.writeInt(-1);
      AppMethodBeat.o(146978);
      return;
    }
    paramParcel.writeInt(this.nXW.size());
    paramInt = 0;
    while (paramInt < this.nXW.size())
    {
      paramParcel.writeLong(this.nXW.keyAt(paramInt));
      paramParcel.writeStringList((List)this.nXW.valueAt(paramInt));
      paramInt += 1;
    }
    AppMethodBeat.o(146978);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig.WeAppSyncVersionSetting
 * JD-Core Version:    0.7.0.1
 */