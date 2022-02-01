package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ScanSettingsCompat
  implements Parcelable
{
  public static final Parcelable.Creator<ScanSettingsCompat> CREATOR;
  final int oLk;
  private final int oLl;
  final long oLm;
  
  static
  {
    AppMethodBeat.i(144652);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(144652);
  }
  
  private ScanSettingsCompat(int paramInt, long paramLong)
  {
    this.oLk = paramInt;
    this.oLl = 1;
    this.oLm = paramLong;
  }
  
  private ScanSettingsCompat(Parcel paramParcel)
  {
    AppMethodBeat.i(144650);
    this.oLk = paramParcel.readInt();
    this.oLl = paramParcel.readInt();
    this.oLm = paramParcel.readLong();
    AppMethodBeat.o(144650);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(144651);
    paramParcel.writeInt(this.oLk);
    paramParcel.writeInt(this.oLl);
    paramParcel.writeLong(this.oLm);
    AppMethodBeat.o(144651);
  }
  
  public static final class a
  {
    private int oLk = 0;
    private final int oLl = 1;
    private long oLm = 0L;
    
    public final a Aj(int paramInt)
    {
      AppMethodBeat.i(144648);
      if ((paramInt < 0) || (paramInt > 2))
      {
        IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("invalid scan mode ".concat(String.valueOf(paramInt)));
        AppMethodBeat.o(144648);
        throw localIllegalArgumentException;
      }
      this.oLk = paramInt;
      AppMethodBeat.o(144648);
      return this;
    }
    
    public final ScanSettingsCompat bRg()
    {
      AppMethodBeat.i(144649);
      ScanSettingsCompat localScanSettingsCompat = new ScanSettingsCompat(this.oLk, this.oLm, (byte)0);
      AppMethodBeat.o(144649);
      return localScanSettingsCompat;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanSettingsCompat
 * JD-Core Version:    0.7.0.1
 */