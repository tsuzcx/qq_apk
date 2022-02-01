package com.tencent.mm.plugin.emojicapture.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bt;

public class EmojiCaptureReporter
  implements Parcelable
{
  public static final Parcelable.Creator<EmojiCaptureReporter> CREATOR;
  public int dataSize;
  public long dcg;
  public long gdo;
  public String gkl;
  public long gpU;
  public boolean gpW;
  public boolean hpc;
  public long pQc;
  public long pQd;
  public long pQe;
  public long pQf;
  public long pQg;
  public long pQh;
  public long pQi;
  public boolean pQj;
  public boolean pQk;
  public int pQl;
  public String pQm;
  public String pQn;
  public String pQo;
  public int pQp;
  public int pQq;
  public String pQr;
  public int pQs;
  public int pQt;
  public int scene;
  public int textColor;
  
  static
  {
    AppMethodBeat.i(104400);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(104400);
  }
  
  public EmojiCaptureReporter()
  {
    this.pQs = 2;
    this.pQt = 9;
  }
  
  public EmojiCaptureReporter(Parcel paramParcel)
  {
    AppMethodBeat.i(104399);
    this.pQs = 2;
    this.pQt = 9;
    this.gpU = paramParcel.readLong();
    this.pQc = paramParcel.readLong();
    this.pQd = paramParcel.readLong();
    this.pQe = paramParcel.readLong();
    this.pQf = paramParcel.readLong();
    this.pQg = paramParcel.readLong();
    this.pQh = paramParcel.readLong();
    this.gdo = paramParcel.readLong();
    this.pQi = paramParcel.readLong();
    this.dcg = paramParcel.readLong();
    this.textColor = paramParcel.readInt();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.pQj = bool1;
      if (paramParcel.readByte() == 0) {
        break label195;
      }
      bool1 = true;
      label133:
      this.pQk = bool1;
      this.pQl = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label200;
      }
    }
    label195:
    label200:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.gpW = bool1;
      this.dataSize = paramParcel.readInt();
      this.gkl = paramParcel.readString();
      this.pQm = paramParcel.readString();
      AppMethodBeat.o(104399);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label133;
    }
  }
  
  private void Ck(int paramInt)
  {
    AppMethodBeat.i(104391);
    g.yhR.f(15982, new Object[] { Integer.valueOf(paramInt), Long.valueOf(this.gpU), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.scene), this.pQo, Integer.valueOf(this.pQp), Integer.valueOf(0), Integer.valueOf(this.pQq), this.pQr, Integer.valueOf(this.pQs), Integer.valueOf(this.pQt) });
    AppMethodBeat.o(104391);
  }
  
  public static void Cl(int paramInt)
  {
    AppMethodBeat.i(221212);
    fn(paramInt, 1);
    AppMethodBeat.o(221212);
  }
  
  public static void a(int paramInt1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(104388);
    g.yhR.f(15982, new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Long.valueOf(0L), Long.valueOf(paramLong4), Long.valueOf(paramLong5), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    AppMethodBeat.o(104388);
  }
  
  public static void cje()
  {
    AppMethodBeat.i(104390);
    g.yhR.f(15982, new Object[] { Integer.valueOf(24), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0) });
    AppMethodBeat.o(104390);
  }
  
  public static void f(long paramLong, int paramInt1, int paramInt2)
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
      fn(7, 1);
      AppMethodBeat.o(104393);
      return;
      fn(6, 1);
      AppMethodBeat.o(104393);
      return;
      fn(28, 1);
      AppMethodBeat.o(104393);
      return;
      fn(22, 1);
      AppMethodBeat.o(104393);
      return;
      fn(24, 1);
      AppMethodBeat.o(104393);
      return;
      fn(25, 1);
      AppMethodBeat.o(104393);
      return;
      fn(26, 1);
      AppMethodBeat.o(104393);
      return;
      fn(27, 1);
      AppMethodBeat.o(104393);
      return;
      AppMethodBeat.o(104393);
      return;
      fn(8, 1);
    }
  }
  
  public static void f(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(104392);
    a(20, paramLong1, 0L, 0L, 0L, paramLong2, 0, 0, paramInt);
    AppMethodBeat.o(104392);
  }
  
  public static void fn(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(104396);
    g.yhR.n(852L, paramInt1, paramInt2);
    AppMethodBeat.o(104396);
  }
  
  public static void g(long paramLong, int paramInt1, int paramInt2)
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
      fn(21, 1);
      AppMethodBeat.o(104395);
      return;
      fn(29, 1);
      AppMethodBeat.o(104395);
      return;
      fn(30, 1);
      AppMethodBeat.o(104395);
      return;
      fn(5, 1);
    }
  }
  
  public static void g(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(104394);
    a(19, paramLong1, 0L, 0L, paramLong2, 0L, 0, 0, paramInt);
    fn(1, 1);
    AppMethodBeat.o(104394);
  }
  
  public final void bjO()
  {
    AppMethodBeat.i(104386);
    g.yhR.f(15982, new Object[] { Integer.valueOf(3), Long.valueOf(this.gpU), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.scene), this.pQo, Integer.valueOf(this.pQp), Integer.valueOf(0), Integer.valueOf(this.pQq), this.pQr, Integer.valueOf(this.pQs), Integer.valueOf(this.pQt) });
    AppMethodBeat.o(104386);
  }
  
  public final void cja()
  {
    AppMethodBeat.i(104384);
    Ck(25);
    AppMethodBeat.o(104384);
  }
  
  public final void cjb()
  {
    AppMethodBeat.i(104385);
    Ck(26);
    AppMethodBeat.o(104385);
  }
  
  public final void cjc()
  {
    int m = 1;
    int k = 0;
    AppMethodBeat.i(104387);
    if (!bt.isNullOrNil(this.gkl)) {
      this.gkl = this.gkl.replace(",", " ");
    }
    g localg = g.yhR;
    long l1 = this.gpU;
    long l2 = this.dcg;
    long l3 = this.gdo;
    long l4 = this.pQi;
    String str1 = this.gkl;
    String str2 = Integer.toHexString(this.textColor & 0xFFFFFF);
    int i;
    if (this.pQj)
    {
      i = 1;
      if (!this.pQk) {
        break label312;
      }
    }
    label312:
    for (int j = 1;; j = 0)
    {
      int n = this.pQl;
      if (this.gpW) {
        k = 1;
      }
      int i1 = this.dataSize;
      String str3 = this.pQm;
      if (this.hpc) {
        m = 2;
      }
      localg.f(15989, new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4), Integer.valueOf(0), Integer.valueOf(0), str1, str2, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(n), Integer.valueOf(k), Integer.valueOf(i1), str3, "", "", Integer.valueOf(m), this.pQn, this.pQo, this.pQr });
      AppMethodBeat.o(104387);
      return;
      i = 0;
      break;
    }
  }
  
  public final void cjd()
  {
    AppMethodBeat.i(104389);
    g.yhR.f(15982, new Object[] { Integer.valueOf(17), Long.valueOf(this.gpU), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(this.pQi), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.scene), this.pQo, Integer.valueOf(this.pQp), Integer.valueOf(0), Integer.valueOf(this.pQq), this.pQr, Integer.valueOf(this.pQs), Integer.valueOf(this.pQt) });
    AppMethodBeat.o(104389);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void fB(String paramString1, String paramString2)
  {
    AppMethodBeat.i(104383);
    g.yhR.f(15982, new Object[] { Integer.valueOf(27), Long.valueOf(this.gpU), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.scene), paramString1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), paramString2, Integer.valueOf(this.pQs) });
    AppMethodBeat.o(104383);
  }
  
  public final void h(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(104382);
    this.pQo = paramString1;
    this.pQr = paramString2;
    this.pQp = paramInt1;
    this.pQq = paramInt2;
    Ck(23);
    AppMethodBeat.o(104382);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    AppMethodBeat.i(104398);
    paramParcel.writeLong(this.gpU);
    paramParcel.writeLong(this.pQc);
    paramParcel.writeLong(this.pQd);
    paramParcel.writeLong(this.pQe);
    paramParcel.writeLong(this.pQf);
    paramParcel.writeLong(this.pQg);
    paramParcel.writeLong(this.pQh);
    paramParcel.writeLong(this.gdo);
    paramParcel.writeLong(this.pQi);
    paramParcel.writeLong(this.dcg);
    paramParcel.writeInt(this.textColor);
    if (this.pQj)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      if (!this.pQk) {
        break label182;
      }
      b1 = 1;
      label119:
      paramParcel.writeByte(b1);
      paramParcel.writeInt(this.pQl);
      if (!this.gpW) {
        break label187;
      }
    }
    label182:
    label187:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeInt(this.dataSize);
      paramParcel.writeString(this.gkl);
      paramParcel.writeString(this.pQm);
      AppMethodBeat.o(104398);
      return;
      b1 = 0;
      break;
      b1 = 0;
      break label119;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter
 * JD-Core Version:    0.7.0.1
 */