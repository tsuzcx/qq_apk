package com.tencent.mm.plugin.appbrand.report.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.h.a.it;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appcache.l;
import com.tencent.mm.plugin.appbrand.report.c;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.regex.Pattern;

public final class kv_14609
  implements Parcelable
{
  public static final Parcelable.Creator<kv_14609> CREATOR = new kv_14609.1();
  public final String appId;
  private int bLB;
  public final String fCQ;
  public final int fDk;
  public final int gKH;
  public String gKi;
  public boolean gZA;
  public boolean gZB;
  public int gZC;
  public int gZD;
  public long gZE;
  private long gZF;
  private long gZy;
  public final boolean gZz;
  
  protected kv_14609(Parcel paramParcel)
  {
    this.appId = paramParcel.readString();
    this.fCQ = paramParcel.readString();
    this.fDk = paramParcel.readInt();
    this.gKH = paramParcel.readInt();
    this.gZy = paramParcel.readLong();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.gZz = bool1;
      if (paramParcel.readByte() == 0) {
        break label142;
      }
      bool1 = true;
      label69:
      this.gZA = bool1;
      if (paramParcel.readByte() == 0) {
        break label147;
      }
    }
    label142:
    label147:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.gZB = bool1;
      this.gZC = paramParcel.readInt();
      this.gZD = paramParcel.readInt();
      this.bLB = paramParcel.readInt();
      this.gZE = paramParcel.readLong();
      this.gZF = paramParcel.readLong();
      this.gKi = paramParcel.readString();
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label69;
    }
  }
  
  public kv_14609(String paramString, int paramInt1, int paramInt2)
  {
    if ("@LibraryAppId".equals(paramString))
    {
      this.appId = "publiclib";
      this.fCQ = null;
      this.gZz = l.abG();
      this.fDk = paramInt1;
      this.gKH = paramInt2;
      return;
    }
    if (paramString.contains("$"))
    {
      paramString = paramString.split(Pattern.quote("$"));
      this.appId = paramString[0];
    }
    for (this.fCQ = paramString[1];; this.fCQ = null)
    {
      this.gZz = l.abF();
      break;
      this.appId = paramString;
    }
  }
  
  public final void aot()
  {
    long l = bk.UY();
    this.gZF = l;
    this.gZy = (l - this.gZE);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void mn(int paramInt)
  {
    if (!this.gZz) {
      return;
    }
    this.bLB = paramInt;
  }
  
  public final String toString()
  {
    return "kv_14609{appId='" + this.appId + '\'' + ", oldVersion=" + this.fDk + ", targetVersion=" + this.gKH + ", spendTime=" + this.gZy + ", canUsePatchUpdate=" + this.gZz + ", isUpdateComplete=" + this.gZA + ", isUpdateCompleteWithPatch=" + this.gZB + ", fullPkgSize=" + this.gZC + ", patchSize=" + this.gZD + ", errcode=" + this.bLB + '}';
  }
  
  public final void wn()
  {
    int k = 1;
    if (((h)g.DM().Dr()).Ex())
    {
      localObject = new it();
      ((it)localObject).bQW.bQX = this;
      a.udP.m((b)localObject);
      y.d("MicroMsg.AppBrand.Report.kv_14609", "report in mm process, publish event");
      return;
    }
    y.i("MicroMsg.AppBrand.Report.kv_14609", "report %s", new Object[] { toString() });
    Object localObject = f.nEG;
    String str1 = this.appId;
    String str2 = c.cv(ae.getContext());
    int m = this.fDk;
    int n = this.gKH;
    long l = this.gZy;
    int i;
    int j;
    if (this.gZz)
    {
      i = 1;
      if (!this.gZA) {
        break label287;
      }
      j = 1;
      label125:
      if (!this.gZB) {
        break label292;
      }
    }
    for (;;)
    {
      ((f)localObject).f(14609, new Object[] { str1, Integer.valueOf(1), str2, Integer.valueOf(m), Integer.valueOf(n), Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(this.gZC), Integer.valueOf(this.gZD), Integer.valueOf(this.bLB), this.fCQ, Long.valueOf(this.gZE), Long.valueOf(this.gZF), this.gKi });
      return;
      i = 0;
      break;
      label287:
      j = 0;
      break label125;
      label292:
      k = 0;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.fCQ);
    paramParcel.writeInt(this.fDk);
    paramParcel.writeInt(this.gKH);
    paramParcel.writeLong(this.gZy);
    if (this.gZz)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      if (!this.gZA) {
        break label140;
      }
      b1 = 1;
      label66:
      paramParcel.writeByte(b1);
      if (!this.gZB) {
        break label145;
      }
    }
    label140:
    label145:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeInt(this.gZC);
      paramParcel.writeInt(this.gZD);
      paramParcel.writeInt(this.bLB);
      paramParcel.writeLong(this.gZE);
      paramParcel.writeLong(this.gZF);
      paramParcel.writeString(this.gKi);
      return;
      b1 = 0;
      break;
      b1 = 0;
      break label66;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.kv_14609
 * JD-Core Version:    0.7.0.1
 */