package com.tencent.mm.plugin.appbrand.launching.params;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.PersistableBundle;
import android.text.TextUtils;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandInitWindowConfig;
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.luggage.sdk.launching.b;
import com.tencent.luggage.sdk.launching.d;
import com.tencent.luggage.sdk.launching.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.appstorage.t;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandWeishiParams;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.c.i;

public final class LaunchParcel
  implements Parcelable
{
  public static final Parcelable.Creator<LaunchParcel> CREATOR;
  public String appId;
  public String eoP;
  public String eoR;
  public AppBrandLaunchReferrer eoV;
  public boolean epe;
  public boolean epf;
  public boolean epi;
  public AppBrandInitWindowConfig epj;
  public boolean epk;
  public e epm;
  public int euz;
  public String icX;
  public int launchMode;
  public String qAF;
  public int qAL;
  public AppBrandLaunchFromNotifyReferrer qAQ;
  public List<String> qAS;
  public HalfScreenConfig qAT;
  public String qAX;
  public String qBa;
  public PersistableBundle qYg;
  public String qYh;
  public String qYy;
  public ActivityStarterIpcDelegate sWl;
  public AppBrandStatObject siB;
  public LaunchParamsOptional tdW;
  public long tdX;
  public b<?> tdY;
  public b<?> tdZ;
  public b<Bundle> tea;
  public PersistableBundle teb;
  public Parcelable tec;
  public Parcelable ted;
  public int tee;
  public String username;
  public int version;
  
  static
  {
    AppMethodBeat.i(147326);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(147326);
  }
  
  public LaunchParcel()
  {
    AppMethodBeat.i(320974);
    this.qAL = -1;
    this.teb = null;
    this.icX = null;
    this.qAT = HalfScreenConfig.rad;
    this.epe = false;
    this.epf = false;
    this.epj = null;
    this.qAS = new ArrayList();
    this.epm = e.etI;
    this.tee = 0;
    this.qAX = "";
    this.qYy = "";
    this.qBa = "";
    AppMethodBeat.o(320974);
  }
  
  private LaunchParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(147323);
    this.qAL = -1;
    this.teb = null;
    this.icX = null;
    this.qAT = HalfScreenConfig.rad;
    this.epe = false;
    this.epf = false;
    this.epj = null;
    this.qAS = new ArrayList();
    this.epm = e.etI;
    this.tee = 0;
    this.qAX = "";
    this.qYy = "";
    this.qBa = "";
    this.username = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.version = paramParcel.readInt();
    this.euz = paramParcel.readInt();
    this.qAF = paramParcel.readString();
    this.eoR = paramParcel.readString();
    this.eoP = paramParcel.readString();
    this.siB = ((AppBrandStatObject)paramParcel.readParcelable(AppBrandStatObject.class.getClassLoader()));
    this.eoV = ((AppBrandLaunchReferrer)paramParcel.readParcelable(AppBrandLaunchReferrer.class.getClassLoader()));
    this.tdW = ((LaunchParamsOptional)paramParcel.readParcelable(LaunchParamsOptional.class.getClassLoader()));
    this.tdX = paramParcel.readLong();
    this.qYh = paramParcel.readString();
    this.qYg = paramParcel.readPersistableBundle(LaunchParcel.class.getClassLoader());
    this.sWl = ((ActivityStarterIpcDelegate)paramParcel.readParcelable(ActivityStarterIpcDelegate.class.getClassLoader()));
    this.tdY = d.c(paramParcel);
    this.tdZ = d.c(paramParcel);
    this.qAL = paramParcel.readInt();
    this.tea = d.c(paramParcel);
    this.teb = paramParcel.readPersistableBundle(LaunchParcel.class.getClassLoader());
    this.icX = paramParcel.readString();
    this.launchMode = paramParcel.readInt();
    this.qAQ = ((AppBrandLaunchFromNotifyReferrer)paramParcel.readParcelable(AppBrandLaunchFromNotifyReferrer.class.getClassLoader()));
    this.tec = paramParcel.readParcelable(LaunchParcel.class.getClassLoader());
    this.ted = paramParcel.readParcelable(LaunchParcel.class.getClassLoader());
    paramParcel.readStringList(this.qAS);
    this.qAT = ((HalfScreenConfig)paramParcel.readParcelable(HalfScreenConfig.class.getClassLoader()));
    this.epm = e.d(paramParcel);
    this.tee = paramParcel.readInt();
    this.qAX = paramParcel.readString();
    if (paramParcel.readByte() > 0)
    {
      bool1 = true;
      this.epe = bool1;
      if (paramParcel.readByte() <= 0) {
        break label490;
      }
      bool1 = true;
      label412:
      this.epf = bool1;
      this.epj = ((AppBrandInitWindowConfig)paramParcel.readParcelable(AppBrandInitWindowConfig.class.getClassLoader()));
      this.qYy = paramParcel.readString();
      this.qBa = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label495;
      }
      bool1 = true;
      label459:
      this.epk = bool1;
      if (paramParcel.readInt() != 1) {
        break label500;
      }
    }
    label490:
    label495:
    label500:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.epi = bool1;
      AppMethodBeat.o(147323);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label412;
      bool1 = false;
      break label459;
    }
  }
  
  public static String Wu(String paramString)
  {
    AppMethodBeat.i(370017);
    paramString = t.Wu(paramString);
    AppMethodBeat.o(370017);
    return paramString;
  }
  
  public static String adj(String paramString)
  {
    AppMethodBeat.i(320988);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(320988);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    String str1 = Wu(paramString);
    paramString = "";
    int i = str1.lastIndexOf("?");
    if (i != -1)
    {
      paramString = str1.substring(0, i);
      String str2 = str1.substring(i);
      str1 = paramString;
      paramString = str2;
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty(str1)) && (!str1.endsWith(".html"))) {
        localStringBuilder.append(str1).append(".html").append(paramString);
      }
      for (;;)
      {
        paramString = localStringBuilder.toString();
        AppMethodBeat.o(320988);
        return paramString;
        localStringBuilder.append(str1).append(paramString);
      }
    }
  }
  
  public final void cAN()
  {
    AppMethodBeat.i(321011);
    d.a(this.tdY);
    d.a(this.tdZ);
    d.a(this.tea);
    AppMethodBeat.o(321011);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void f(AppBrandInitConfigLU paramAppBrandInitConfigLU)
  {
    Object localObject2 = null;
    AppMethodBeat.i(147324);
    if (paramAppBrandInitConfigLU == null)
    {
      AppMethodBeat.o(147324);
      return;
    }
    if (TextUtils.isEmpty(paramAppBrandInitConfigLU.username)) {
      paramAppBrandInitConfigLU.username = this.username;
    }
    if ((this.tdW != null) && (this.tdW.eoW != null)) {
      paramAppBrandInitConfigLU.eoW.a(this.tdW.eoW);
    }
    paramAppBrandInitConfigLU.qAF = t.Wu(this.qAF);
    paramAppBrandInitConfigLU.eoR = i.bLh(this.eoR);
    paramAppBrandInitConfigLU.eoV.a(this.eoV);
    if (this.tdW == null)
    {
      localObject1 = null;
      paramAppBrandInitConfigLU.eoT = ((String)localObject1);
      if (this.tdW != null) {
        break label225;
      }
      localObject1 = null;
      label124:
      paramAppBrandInitConfigLU.eoU = ((String)localObject1);
      if (this.tdW != null) {
        break label236;
      }
    }
    label225:
    label236:
    for (Object localObject1 = localObject2;; localObject1 = this.tdW.eoY)
    {
      paramAppBrandInitConfigLU.eoY = ((String)localObject1);
      paramAppBrandInitConfigLU.startTime = this.tdX;
      paramAppBrandInitConfigLU.epg = this.tdY;
      paramAppBrandInitConfigLU.eph = this.tdZ;
      paramAppBrandInitConfigLU.epm = this.epm;
      paramAppBrandInitConfigLU.epe = this.epe;
      paramAppBrandInitConfigLU.epf = this.epf;
      paramAppBrandInitConfigLU.epj = this.epj;
      paramAppBrandInitConfigLU.ff(this.eoP);
      AppMethodBeat.o(147324);
      return;
      localObject1 = this.tdW.eoT;
      break;
      localObject1 = this.tdW.eoU;
      break label124;
    }
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(321015);
    try
    {
      cAN();
      return;
    }
    finally
    {
      super.finalize();
      AppMethodBeat.o(321015);
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(169496);
    StringBuilder localStringBuilder = new StringBuilder("LaunchParcel{username='").append(this.username).append('\'').append(", appId='").append(this.appId).append('\'').append(", version=").append(this.version).append(", versionType=").append(this.euz).append(", enterPath='").append(this.qAF).append('\'').append(", statObj=").append(this.siB).append(", referrer=").append(this.eoV).append(", startClickTimestamp=").append(this.tdX).append(", windowConfig=");
    if (this.epj == null) {}
    for (String str = "null";; str = this.epj.toString())
    {
      str = str + '}';
      AppMethodBeat.o(169496);
      return str;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(147322);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.version);
    paramParcel.writeInt(this.euz);
    paramParcel.writeString(this.qAF);
    paramParcel.writeString(this.eoR);
    paramParcel.writeString(this.eoP);
    paramParcel.writeParcelable(this.siB, paramInt);
    paramParcel.writeParcelable(this.eoV, paramInt);
    paramParcel.writeParcelable(this.tdW, paramInt);
    paramParcel.writeLong(this.tdX);
    paramParcel.writeString(this.qYh);
    paramParcel.writePersistableBundle(this.qYg);
    paramParcel.writeParcelable(this.sWl, paramInt);
    d.b(this.tdY, paramParcel);
    d.b(this.tdZ, paramParcel);
    paramParcel.writeInt(this.qAL);
    d.b(this.tea, paramParcel);
    paramParcel.writePersistableBundle(this.teb);
    paramParcel.writeString(this.icX);
    paramParcel.writeInt(this.launchMode);
    paramParcel.writeParcelable(this.qAQ, paramInt);
    paramParcel.writeParcelable(this.tec, paramInt);
    paramParcel.writeParcelable(this.ted, paramInt);
    paramParcel.writeStringList(this.qAS);
    paramParcel.writeParcelable(this.qAT, paramInt);
    e.a(this.epm, paramParcel);
    paramParcel.writeInt(this.tee);
    paramParcel.writeString(this.qAX);
    int i;
    if (this.epe)
    {
      i = 1;
      paramParcel.writeByte((byte)i);
      if (!this.epf) {
        break label345;
      }
      i = 1;
      label273:
      paramParcel.writeByte((byte)i);
      paramParcel.writeParcelable(this.epj, paramInt);
      paramParcel.writeString(this.qYy);
      paramParcel.writeString(this.qBa);
      if (!this.epk) {
        break label350;
      }
      paramInt = 1;
      label313:
      paramParcel.writeInt(paramInt);
      if (!this.epi) {
        break label355;
      }
    }
    label345:
    label350:
    label355:
    for (paramInt = j;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      AppMethodBeat.o(147322);
      return;
      i = 0;
      break;
      i = 0;
      break label273;
      paramInt = 0;
      break label313;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel
 * JD-Core Version:    0.7.0.1
 */