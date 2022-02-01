package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.PersistableBundle;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.web_renderingcache.WebRenderingCacheDirectoryDescriptor;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;

public class AppBrandInitConfigWC
  extends AppBrandInitConfigLU
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandInitConfigWC> CREATOR;
  public String jDA;
  public PersistableBundle jDB;
  public String jDC;
  public String jDD;
  public String jDE;
  public boolean jDF;
  public WebRenderingCacheDirectoryDescriptor jDG;
  public volatile QualitySession jDH;
  public transient int jDI;
  public boolean jDJ;
  public int jDK;
  public String jDL;
  public boolean jDy;
  public long jDz;
  public String jjp;
  public String jjq;
  public AppBrandLaunchFromNotifyReferrer jjr;
  public int launchMode;
  
  static
  {
    AppMethodBeat.i(44843);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(44843);
  }
  
  public AppBrandInitConfigWC()
  {
    AppMethodBeat.i(44834);
    this.jDB = new PersistableBundle();
    this.jDF = false;
    AppMethodBeat.o(44834);
  }
  
  protected AppBrandInitConfigWC(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(44839);
    this.jDB = new PersistableBundle();
    this.jDF = false;
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.jDy = bool1;
      if (paramParcel.readByte() == 0) {
        break label222;
      }
      bool1 = true;
      label51:
      this.jDJ = bool1;
      this.jDK = paramParcel.readInt();
      this.jDz = paramParcel.readLong();
      this.jDA = paramParcel.readString();
      this.jDH = ((QualitySession)paramParcel.readParcelable(QualitySession.class.getClassLoader()));
      this.jDC = paramParcel.readString();
      this.jDB = paramParcel.readPersistableBundle(AppBrandInitConfigWC.class.getClassLoader());
      this.jDD = paramParcel.readString();
      if (paramParcel.readByte() <= 0) {
        break label227;
      }
    }
    label222:
    label227:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jDF = bool1;
      this.jDE = paramParcel.readString();
      this.jDG = ((WebRenderingCacheDirectoryDescriptor)paramParcel.readParcelable(WebRenderingCacheDirectoryDescriptor.class.getClassLoader()));
      this.jjp = paramParcel.readString();
      this.launchMode = paramParcel.readInt();
      this.jjq = paramParcel.readString();
      this.jjr = ((AppBrandLaunchFromNotifyReferrer)paramParcel.readParcelable(AppBrandLaunchFromNotifyReferrer.class.getClassLoader()));
      this.jDL = paramParcel.readString();
      AppMethodBeat.o(44839);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label51;
    }
  }
  
  private AppBrandInitConfigWC bax()
  {
    AppMethodBeat.i(44836);
    Parcel localParcel = bau();
    AppBrandInitConfigWC localAppBrandInitConfigWC = new AppBrandInitConfigWC(localParcel);
    localParcel.recycle();
    AppMethodBeat.o(44836);
    return localAppBrandInitConfigWC;
  }
  
  public final boolean CC()
  {
    return this.cca == 4;
  }
  
  public final Parcel bau()
  {
    AppMethodBeat.i(44837);
    Parcel localParcel = Parcel.obtain();
    localParcel.setDataPosition(0);
    writeToParcel(localParcel, 0);
    localParcel.setDataPosition(0);
    AppMethodBeat.o(44837);
    return localParcel;
  }
  
  public String toString()
  {
    AppMethodBeat.i(44835);
    String str = "AppBrandInitConfigWC {visitingSessionId='" + this.cbY + '\'' + ", username='" + this.username + '\'' + ", appId='" + this.appId + '\'' + ", brandName='" + this.ddh + '\'' + ", debugType=" + this.joY + ", uin=" + this.uin + ", isPluginApp=" + this.jDy + ", isAdContact=" + this.jDJ + ", performanceValue=" + this.jDK + ", orientation='" + this.jBP + '\'' + ", enterPath='" + this.jjf + '\'' + ", shareName='" + this.ccc + '\'' + ", shareKey='" + this.ccd + '\'' + ", startTime=" + this.startTime + ", attrsFromCgi=" + this.cck + ", referrer=" + this.cce + ", extInfo=" + this.extInfo + ", appVersion=" + this.aBM + ", launchMode=" + this.launchMode + "， triggerServiceName" + this.jDE + '}';
    AppMethodBeat.o(44835);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(44838);
    super.writeToParcel(paramParcel, paramInt);
    byte b;
    if (this.jDy)
    {
      b = 1;
      paramParcel.writeByte(b);
      if (!this.jDJ) {
        break label184;
      }
      b = 1;
      label38:
      paramParcel.writeByte(b);
      paramParcel.writeInt(this.jDK);
      paramParcel.writeLong(this.jDz);
      paramParcel.writeString(this.jDA);
      paramParcel.writeParcelable(this.jDH, paramInt);
      paramParcel.writeString(this.jDC);
      paramParcel.writePersistableBundle(this.jDB);
      paramParcel.writeString(this.jDD);
      if (!this.jDF) {
        break label189;
      }
    }
    for (;;)
    {
      paramParcel.writeByte((byte)i);
      paramParcel.writeString(this.jDE);
      paramParcel.writeParcelable(this.jDG, paramInt);
      paramParcel.writeString(this.jjp);
      paramParcel.writeInt(this.launchMode);
      paramParcel.writeString(this.jjq);
      paramParcel.writeParcelable(this.jjr, paramInt);
      paramParcel.writeString(this.jDL);
      AppMethodBeat.o(44838);
      return;
      b = 0;
      break;
      label184:
      b = 0;
      break label38;
      label189:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC
 * JD-Core Version:    0.7.0.1
 */