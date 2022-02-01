package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ScanSettingsCompat
  implements Parcelable
{
  public static final Parcelable.Creator<ScanSettingsCompat> CREATOR;
  final int kGV;
  private final int kGW;
  final long kGX;
  
  static
  {
    AppMethodBeat.i(144652);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(144652);
  }
  
  private ScanSettingsCompat(int paramInt, long paramLong)
  {
    this.kGV = paramInt;
    this.kGW = 1;
    this.kGX = paramLong;
  }
  
  private ScanSettingsCompat(Parcel paramParcel)
  {
    AppMethodBeat.i(144650);
    this.kGV = paramParcel.readInt();
    this.kGW = paramParcel.readInt();
    this.kGX = paramParcel.readLong();
    AppMethodBeat.o(144650);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(144651);
    paramParcel.writeInt(this.kGV);
    paramParcel.writeInt(this.kGW);
    paramParcel.writeLong(this.kGX);
    AppMethodBeat.o(144651);
  }
  
  public static final class a
  {
    private int kGV = 0;
    private final int kGW = 1;
    private long kGX = 0L;
    
    public final ScanSettingsCompat bjt()
    {
      AppMethodBeat.i(144649);
      ScanSettingsCompat localScanSettingsCompat = new ScanSettingsCompat(this.kGV, this.kGX, (byte)0);
      AppMethodBeat.o(144649);
      return localScanSettingsCompat;
    }
    
    public final a sU(int paramInt)
    {
      AppMethodBeat.i(144648);
      if ((paramInt < 0) || (paramInt > 2))
      {
        IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("invalid scan mode ".concat(String.valueOf(paramInt)));
        AppMethodBeat.o(144648);
        throw localIllegalArgumentException;
      }
      this.kGV = paramInt;
      AppMethodBeat.o(144648);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanSettingsCompat
 * JD-Core Version:    0.7.0.1
 */