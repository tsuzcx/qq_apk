package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ScanSettingsCompat
  implements Parcelable
{
  public static final Parcelable.Creator<ScanSettingsCompat> CREATOR;
  final int rPd;
  private final int rPe;
  final long rPf;
  
  static
  {
    AppMethodBeat.i(144652);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(144652);
  }
  
  private ScanSettingsCompat(int paramInt, long paramLong)
  {
    this.rPd = paramInt;
    this.rPe = 1;
    this.rPf = paramLong;
  }
  
  private ScanSettingsCompat(Parcel paramParcel)
  {
    AppMethodBeat.i(144650);
    this.rPd = paramParcel.readInt();
    this.rPe = paramParcel.readInt();
    this.rPf = paramParcel.readLong();
    AppMethodBeat.o(144650);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(144651);
    paramParcel.writeInt(this.rPd);
    paramParcel.writeInt(this.rPe);
    paramParcel.writeLong(this.rPf);
    AppMethodBeat.o(144651);
  }
  
  public static final class a
  {
    private int rPd = 0;
    private final int rPe = 1;
    private long rPf = 0L;
    
    public final a AA(int paramInt)
    {
      AppMethodBeat.i(144648);
      if ((paramInt < 0) || (paramInt > 2))
      {
        IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("invalid scan mode ".concat(String.valueOf(paramInt)));
        AppMethodBeat.o(144648);
        throw localIllegalArgumentException;
      }
      this.rPd = paramInt;
      AppMethodBeat.o(144648);
      return this;
    }
    
    public final ScanSettingsCompat cro()
    {
      AppMethodBeat.i(144649);
      ScanSettingsCompat localScanSettingsCompat = new ScanSettingsCompat(this.rPd, this.rPf, (byte)0);
      AppMethodBeat.o(144649);
      return localScanSettingsCompat;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanSettingsCompat
 * JD-Core Version:    0.7.0.1
 */