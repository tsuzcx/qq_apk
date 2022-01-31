package com.tencent.mm.plugin.appbrand.report.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ja;
import com.tencent.mm.g.a.ja.b;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appcache.r;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.regex.Pattern;

public final class kv_14609
  implements Parcelable
{
  public static final Parcelable.Creator<kv_14609> CREATOR;
  public final String appId;
  private int csV;
  public int cvs;
  public String gVh;
  public final int gVy;
  public long iHO;
  public final boolean iHP;
  public boolean iHQ;
  public boolean iHR;
  public int iHS;
  public int iHT;
  public long iHU;
  private long iHV;
  public long iHW;
  public long iHX;
  public String ikX;
  public final int ilI;
  
  static
  {
    AppMethodBeat.i(132659);
    CREATOR = new kv_14609.1();
    AppMethodBeat.o(132659);
  }
  
  protected kv_14609(Parcel paramParcel)
  {
    AppMethodBeat.i(132658);
    this.appId = paramParcel.readString();
    this.gVh = paramParcel.readString();
    this.gVy = paramParcel.readInt();
    this.ilI = paramParcel.readInt();
    this.iHO = paramParcel.readLong();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.iHP = bool1;
      if (paramParcel.readByte() == 0) {
        break label176;
      }
      bool1 = true;
      label74:
      this.iHQ = bool1;
      if (paramParcel.readByte() == 0) {
        break label181;
      }
    }
    label176:
    label181:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.iHR = bool1;
      this.iHS = paramParcel.readInt();
      this.iHT = paramParcel.readInt();
      this.csV = paramParcel.readInt();
      this.iHU = paramParcel.readLong();
      this.iHV = paramParcel.readLong();
      this.ikX = paramParcel.readString();
      this.iHW = paramParcel.readLong();
      this.iHX = paramParcel.readLong();
      this.cvs = paramParcel.readInt();
      AppMethodBeat.o(132658);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label74;
    }
  }
  
  public kv_14609(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(132653);
    ab.i("MicroMsg.AppBrand.Report.kv_14609", "appid:%s,oldVersion:%s,targetVersion:%s", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ("@LibraryAppId".equals(paramString))
    {
      this.appId = "publiclib";
      this.gVh = null;
      this.iHP = r.avw();
      this.gVy = paramInt1;
      this.ilI = paramInt2;
      AppMethodBeat.o(132653);
      return;
    }
    if (paramString.contains("$"))
    {
      paramString = paramString.split(Pattern.quote("$"));
      this.appId = paramString[0];
      if (paramString != null) {}
      switch (paramString.length)
      {
      default: 
        label136:
        ab.i("MicroMsg.AppBrand.Report.kv_14609", "getModuleName modulename:%s,appid:%s,pkgtype:%s", new Object[] { this.gVh, this.appId, Integer.valueOf(this.cvs) });
      }
    }
    for (;;)
    {
      this.iHP = r.avv();
      break;
      paramString = paramString[1];
      if (!bo.isNullOrNil(paramString))
      {
        if (paramString.equals("__WITHOUT_CODELIB__"))
        {
          this.cvs = 12;
          this.gVh = null;
          break label136;
        }
        if (paramString.equals("__CODELIB__"))
        {
          this.cvs = 14;
          this.gVh = null;
          break label136;
        }
        this.gVh = paramString;
        break label136;
        this.gVh = paramString[1];
        if ((bo.isNullOrNil(paramString[2])) || (!paramString[2].equals("__WITHOUT_CODELIB__"))) {
          break label136;
        }
        this.cvs = 13;
        break label136;
        this.appId = paramString;
        this.gVh = null;
      }
    }
  }
  
  public final void IE()
  {
    int k = 1;
    AppMethodBeat.i(132656);
    if (((h)g.RI().Rj()).SD())
    {
      localObject = new ja();
      ((ja)localObject).cyv.cyx = this;
      a.ymk.l((b)localObject);
      if (((ja)localObject).cyw.cyy)
      {
        ab.d("MicroMsg.AppBrand.Report.kv_14609", "report in mm process, publish event");
        AppMethodBeat.o(132656);
        return;
      }
    }
    ab.i("MicroMsg.AppBrand.Report.kv_14609", "report %s", new Object[] { toString() });
    Object localObject = com.tencent.mm.plugin.report.e.qrI;
    String str1 = this.appId;
    String str2 = com.tencent.mm.plugin.appbrand.report.e.cZ(ah.getContext());
    int m = this.gVy;
    int n = this.ilI;
    long l = this.iHO;
    int i;
    int j;
    if (this.iHP)
    {
      i = 1;
      if (!this.iHQ) {
        break label346;
      }
      j = 1;
      label146:
      if (!this.iHR) {
        break label351;
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.report.e)localObject).e(14609, new Object[] { str1, Integer.valueOf(1), str2, Integer.valueOf(m), Integer.valueOf(n), Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(this.iHS), Integer.valueOf(this.iHT), Integer.valueOf(this.csV), this.gVh, Long.valueOf(this.iHU), Long.valueOf(this.iHV), this.ikX, Long.valueOf(this.iHW), Long.valueOf(this.iHX), Integer.valueOf(this.cvs) });
      AppMethodBeat.o(132656);
      return;
      i = 0;
      break;
      label346:
      j = 0;
      break label146;
      label351:
      k = 0;
    }
  }
  
  public final void aLr()
  {
    AppMethodBeat.i(132654);
    long l = bo.aoy();
    this.iHV = l;
    this.iHO = (l - this.iHU);
    AppMethodBeat.o(132654);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void py(int paramInt)
  {
    if (!this.iHP) {
      return;
    }
    this.csV = paramInt;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(132655);
    String str = "kv_14609{appId='" + this.appId + '\'' + ", oldVersion=" + this.gVy + ", targetVersion=" + this.ilI + ", spendTime=" + this.iHO + ", canUsePatchUpdate=" + this.iHP + ", isUpdateComplete=" + this.iHQ + ", isUpdateCompleteWithPatch=" + this.iHR + ", fullPkgSize=" + this.iHS + ", patchSize=" + this.iHT + ", errcode=" + this.csV + ", pkgType=" + this.cvs + '}';
    AppMethodBeat.o(132655);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    AppMethodBeat.i(132657);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.gVh);
    paramParcel.writeInt(this.gVy);
    paramParcel.writeInt(this.ilI);
    paramParcel.writeLong(this.iHO);
    if (this.iHP)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      if (!this.iHQ) {
        break label176;
      }
      b1 = 1;
      label72:
      paramParcel.writeByte(b1);
      if (!this.iHR) {
        break label181;
      }
    }
    label176:
    label181:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeInt(this.iHS);
      paramParcel.writeInt(this.iHT);
      paramParcel.writeInt(this.csV);
      paramParcel.writeLong(this.iHU);
      paramParcel.writeLong(this.iHV);
      paramParcel.writeString(this.ikX);
      paramParcel.writeLong(this.iHW);
      paramParcel.writeLong(this.iHX);
      paramParcel.writeInt(this.cvs);
      AppMethodBeat.o(132657);
      return;
      b1 = 0;
      break;
      b1 = 0;
      break label72;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.kv_14609
 * JD-Core Version:    0.7.0.1
 */