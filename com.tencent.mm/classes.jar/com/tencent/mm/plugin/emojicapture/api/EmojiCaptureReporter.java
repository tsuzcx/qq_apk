package com.tencent.mm.plugin.emojicapture.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Util;

public class EmojiCaptureReporter
  implements Parcelable
{
  public static final Parcelable.Creator<EmojiCaptureReporter> CREATOR;
  public int dataSize;
  public long hqS;
  public long lYJ;
  public long mnX;
  public boolean mnZ;
  public boolean nFR;
  public int scene;
  public int textColor;
  public long ygb;
  public long ygc;
  public long ygd;
  public long yge;
  public long ygf;
  public long ygg;
  public long ygh;
  public String ygi;
  public boolean ygj;
  public boolean ygk;
  public int ygl;
  public String ygm;
  public String ygn;
  public String ygo;
  public int ygp;
  public int ygq;
  public String ygr;
  public int ygs;
  public int ygt;
  
  static
  {
    AppMethodBeat.i(104400);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(104400);
  }
  
  public EmojiCaptureReporter()
  {
    this.ygs = 2;
    this.ygt = 9;
  }
  
  public EmojiCaptureReporter(Parcel paramParcel)
  {
    AppMethodBeat.i(104399);
    this.ygs = 2;
    this.ygt = 9;
    this.mnX = paramParcel.readLong();
    this.ygb = paramParcel.readLong();
    this.ygc = paramParcel.readLong();
    this.ygd = paramParcel.readLong();
    this.yge = paramParcel.readLong();
    this.ygf = paramParcel.readLong();
    this.ygg = paramParcel.readLong();
    this.lYJ = paramParcel.readLong();
    this.ygh = paramParcel.readLong();
    this.hqS = paramParcel.readLong();
    this.textColor = paramParcel.readInt();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.ygj = bool1;
      if (paramParcel.readByte() == 0) {
        break label195;
      }
      bool1 = true;
      label133:
      this.ygk = bool1;
      this.ygl = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label200;
      }
    }
    label195:
    label200:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.mnZ = bool1;
      this.dataSize = paramParcel.readInt();
      this.ygi = paramParcel.readString();
      this.ygm = paramParcel.readString();
      AppMethodBeat.o(104399);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label133;
    }
  }
  
  public static void KN(int paramInt)
  {
    AppMethodBeat.i(369744);
    gU(paramInt, 1);
    AppMethodBeat.o(369744);
  }
  
  public static void a(int paramInt1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(104388);
    h.OAn.b(15982, new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Long.valueOf(0L), Long.valueOf(paramLong4), Long.valueOf(paramLong5), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    AppMethodBeat.o(104388);
  }
  
  public static void dDw()
  {
    AppMethodBeat.i(104390);
    h.OAn.b(15982, new Object[] { Integer.valueOf(24), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0) });
    AppMethodBeat.o(104390);
  }
  
  public static void gU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(104396);
    h.OAn.p(852L, paramInt1, paramInt2);
    AppMethodBeat.o(104396);
  }
  
  public static void h(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(104393);
    a(22, paramLong, 0L, 0L, 0L, 0L, 0, paramInt1, paramInt2);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(104393);
      return;
      gU(7, 1);
      AppMethodBeat.o(104393);
      return;
      gU(6, 1);
      AppMethodBeat.o(104393);
      return;
      gU(28, 1);
      AppMethodBeat.o(104393);
      return;
      gU(22, 1);
      AppMethodBeat.o(104393);
      return;
      gU(24, 1);
      AppMethodBeat.o(104393);
      return;
      gU(25, 1);
      AppMethodBeat.o(104393);
      return;
      gU(26, 1);
      AppMethodBeat.o(104393);
      return;
      gU(27, 1);
      AppMethodBeat.o(104393);
      return;
      AppMethodBeat.o(104393);
      return;
      gU(8, 1);
    }
  }
  
  public static void i(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(104395);
    a(21, paramLong, 0L, 0L, 0L, 0L, paramInt1, 0, paramInt2);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(104395);
      return;
      gU(21, 1);
      AppMethodBeat.o(104395);
      return;
      gU(29, 1);
      AppMethodBeat.o(104395);
      return;
      gU(30, 1);
      AppMethodBeat.o(104395);
      return;
      gU(5, 1);
    }
  }
  
  public static void i(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(104392);
    a(20, paramLong1, 0L, 0L, 0L, paramLong2, 0, 0, paramInt);
    AppMethodBeat.o(104392);
  }
  
  public static void j(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(104394);
    a(19, paramLong1, 0L, 0L, paramLong2, 0L, 0, 0, paramInt);
    gU(1, 1);
    AppMethodBeat.o(104394);
  }
  
  public final void KM(int paramInt)
  {
    AppMethodBeat.i(104391);
    h.OAn.b(15982, new Object[] { Integer.valueOf(paramInt), Long.valueOf(this.mnX), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.scene), this.ygo, Integer.valueOf(this.ygp), Integer.valueOf(0), Integer.valueOf(this.ygq), this.ygr, Integer.valueOf(this.ygs), Integer.valueOf(this.ygt) });
    AppMethodBeat.o(104391);
  }
  
  public final void dDv()
  {
    int m = 1;
    int k = 0;
    AppMethodBeat.i(104387);
    if (!Util.isNullOrNil(this.ygi)) {
      this.ygi = this.ygi.replace(",", " ");
    }
    h localh = h.OAn;
    long l1 = this.mnX;
    long l2 = this.hqS;
    long l3 = this.lYJ;
    long l4 = this.ygh;
    String str1 = this.ygi;
    String str2 = Integer.toHexString(this.textColor & 0xFFFFFF);
    int i;
    if (this.ygj)
    {
      i = 1;
      if (!this.ygk) {
        break label312;
      }
    }
    label312:
    for (int j = 1;; j = 0)
    {
      int n = this.ygl;
      if (this.mnZ) {
        k = 1;
      }
      int i1 = this.dataSize;
      String str3 = this.ygm;
      if (this.nFR) {
        m = 2;
      }
      localh.b(15989, new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4), Integer.valueOf(0), Integer.valueOf(0), str1, str2, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(n), Integer.valueOf(k), Integer.valueOf(i1), str3, "", "", Integer.valueOf(m), this.ygn, this.ygo, this.ygr });
      AppMethodBeat.o(104387);
      return;
      i = 0;
      break;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void gQ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(104383);
    h.OAn.b(15982, new Object[] { Integer.valueOf(27), Long.valueOf(this.mnX), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.scene), paramString1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), paramString2, Integer.valueOf(this.ygs) });
    AppMethodBeat.o(104383);
  }
  
  public final void j(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(104382);
    this.ygo = paramString1;
    this.ygr = paramString2;
    this.ygp = paramInt1;
    this.ygq = paramInt2;
    KM(23);
    AppMethodBeat.o(104382);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    AppMethodBeat.i(104398);
    paramParcel.writeLong(this.mnX);
    paramParcel.writeLong(this.ygb);
    paramParcel.writeLong(this.ygc);
    paramParcel.writeLong(this.ygd);
    paramParcel.writeLong(this.yge);
    paramParcel.writeLong(this.ygf);
    paramParcel.writeLong(this.ygg);
    paramParcel.writeLong(this.lYJ);
    paramParcel.writeLong(this.ygh);
    paramParcel.writeLong(this.hqS);
    paramParcel.writeInt(this.textColor);
    if (this.ygj)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      if (!this.ygk) {
        break label182;
      }
      b1 = 1;
      label119:
      paramParcel.writeByte(b1);
      paramParcel.writeInt(this.ygl);
      if (!this.mnZ) {
        break label187;
      }
    }
    label182:
    label187:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeInt(this.dataSize);
      paramParcel.writeString(this.ygi);
      paramParcel.writeString(this.ygm);
      AppMethodBeat.o(104398);
      return;
      b1 = 0;
      break;
      b1 = 0;
      break label119;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter
 * JD-Core Version:    0.7.0.1
 */