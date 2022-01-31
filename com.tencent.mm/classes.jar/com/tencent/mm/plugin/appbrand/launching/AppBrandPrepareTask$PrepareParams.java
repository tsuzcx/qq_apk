package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import java.util.Locale;

final class AppBrandPrepareTask$PrepareParams
  implements Parcelable
{
  public static final Parcelable.Creator<PrepareParams> CREATOR;
  private boolean bAa;
  private int gst;
  private int ikh;
  private String iki;
  private String ikj;
  private int ikk;
  private AppBrandLaunchReferrer ikl;
  private String ikm;
  private int ikn;
  private WxaAttributes.WxaVersionInfo iko;
  private boolean ikp;
  private QualitySession ikq;
  private String mAppId;
  
  static
  {
    AppMethodBeat.i(131753);
    CREATOR = new AppBrandPrepareTask.PrepareParams.1();
    AppMethodBeat.o(131753);
  }
  
  AppBrandPrepareTask$PrepareParams() {}
  
  AppBrandPrepareTask$PrepareParams(Parcel paramParcel)
  {
    AppMethodBeat.i(131752);
    this.ikh = paramParcel.readInt();
    this.gst = paramParcel.readInt();
    this.iki = paramParcel.readString();
    this.mAppId = paramParcel.readString();
    this.ikj = paramParcel.readString();
    this.ikk = paramParcel.readInt();
    this.ikl = ((AppBrandLaunchReferrer)paramParcel.readParcelable(AppBrandLaunchReferrer.class.getClassLoader()));
    this.ikm = paramParcel.readString();
    this.ikn = paramParcel.readInt();
    this.iko = ((WxaAttributes.WxaVersionInfo)paramParcel.readParcelable(WxaAttributes.WxaVersionInfo.class.getClassLoader()));
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.bAa = bool1;
      if (paramParcel.readInt() <= 0) {
        break label163;
      }
    }
    label163:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.ikp = bool1;
      this.ikq = ((QualitySession)paramParcel.readParcelable(QualitySession.class.getClassLoader()));
      AppMethodBeat.o(131752);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toShortString()
  {
    AppMethodBeat.i(131750);
    String str = String.format(Locale.US, "[%s|%d]", new Object[] { this.mAppId, Integer.valueOf(this.ikk) });
    AppMethodBeat.o(131750);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(131751);
    paramParcel.writeInt(this.ikh);
    paramParcel.writeInt(this.gst);
    paramParcel.writeString(this.iki);
    paramParcel.writeString(this.mAppId);
    paramParcel.writeString(this.ikj);
    paramParcel.writeInt(this.ikk);
    paramParcel.writeParcelable(this.ikl, paramInt);
    paramParcel.writeString(this.ikm);
    paramParcel.writeInt(this.ikn);
    paramParcel.writeParcelable(this.iko, paramInt);
    if (this.bAa)
    {
      i = 1;
      paramParcel.writeInt(i);
      if (!this.ikp) {
        break label139;
      }
    }
    label139:
    for (int i = j;; i = 0)
    {
      paramParcel.writeInt(i);
      paramParcel.writeParcelable(this.ikq, paramInt);
      AppMethodBeat.o(131751);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.PrepareParams
 * JD-Core Version:    0.7.0.1
 */