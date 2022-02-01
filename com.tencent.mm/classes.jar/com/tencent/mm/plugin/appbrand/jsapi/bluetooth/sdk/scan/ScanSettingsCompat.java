package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ScanSettingsCompat
  implements Parcelable
{
  public static final Parcelable.Creator<ScanSettingsCompat> CREATOR;
  final int klV;
  private final int klW;
  final long klX;
  
  static
  {
    AppMethodBeat.i(144652);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(144652);
  }
  
  private ScanSettingsCompat(int paramInt, long paramLong)
  {
    this.klV = paramInt;
    this.klW = 1;
    this.klX = paramLong;
  }
  
  private ScanSettingsCompat(Parcel paramParcel)
  {
    AppMethodBeat.i(144650);
    this.klV = paramParcel.readInt();
    this.klW = paramParcel.readInt();
    this.klX = paramParcel.readLong();
    AppMethodBeat.o(144650);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(144651);
    paramParcel.writeInt(this.klV);
    paramParcel.writeInt(this.klW);
    paramParcel.writeLong(this.klX);
    AppMethodBeat.o(144651);
  }
  
  public static final class a
  {
    private int klV = 0;
    private final int klW = 1;
    private long klX = 0L;
    
    public final ScanSettingsCompat bfP()
    {
      AppMethodBeat.i(144649);
      ScanSettingsCompat localScanSettingsCompat = new ScanSettingsCompat(this.klV, this.klX, (byte)0);
      AppMethodBeat.o(144649);
      return localScanSettingsCompat;
    }
    
    public final a ss(int paramInt)
    {
      AppMethodBeat.i(144648);
      if ((paramInt < 0) || (paramInt > 2))
      {
        IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("invalid scan mode ".concat(String.valueOf(paramInt)));
        AppMethodBeat.o(144648);
        throw localIllegalArgumentException;
      }
      this.klV = paramInt;
      AppMethodBeat.o(144648);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanSettingsCompat
 * JD-Core Version:    0.7.0.1
 */