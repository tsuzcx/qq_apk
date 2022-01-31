package com.tencent.mm.plugin.emojicapture.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bo;

public class EmojiCaptureReporter
  implements Parcelable
{
  public static final Parcelable.Creator<EmojiCaptureReporter> CREATOR;
  public long cew;
  public boolean eZK;
  public long esf;
  public String ewF;
  public long eyh;
  public boolean eyj;
  public long lsJ;
  public long lsK;
  public long lsL;
  public long lsM;
  public long lsN;
  public long lsO;
  public long lsP;
  public boolean lsQ;
  public boolean lsR;
  public int lsS;
  public int lsT;
  public String lsU;
  public String lsV;
  public String lsW;
  public int scene;
  public int textColor;
  
  static
  {
    AppMethodBeat.i(57463);
    CREATOR = new EmojiCaptureReporter.1();
    AppMethodBeat.o(57463);
  }
  
  public EmojiCaptureReporter() {}
  
  public EmojiCaptureReporter(Parcel paramParcel)
  {
    AppMethodBeat.i(57462);
    this.eyh = paramParcel.readLong();
    this.lsJ = paramParcel.readLong();
    this.lsK = paramParcel.readLong();
    this.lsL = paramParcel.readLong();
    this.lsM = paramParcel.readLong();
    this.lsN = paramParcel.readLong();
    this.lsO = paramParcel.readLong();
    this.esf = paramParcel.readLong();
    this.lsP = paramParcel.readLong();
    this.cew = paramParcel.readLong();
    this.textColor = paramParcel.readInt();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.lsQ = bool1;
      if (paramParcel.readByte() == 0) {
        break label184;
      }
      bool1 = true;
      label122:
      this.lsR = bool1;
      this.lsS = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label189;
      }
    }
    label184:
    label189:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.eyj = bool1;
      this.lsT = paramParcel.readInt();
      this.ewF = paramParcel.readString();
      this.lsU = paramParcel.readString();
      AppMethodBeat.o(57462);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label122;
    }
  }
  
  public static void a(int paramInt1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(57452);
    h.qsU.e(15982, new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Long.valueOf(paramLong4), Long.valueOf(paramLong5), Long.valueOf(paramLong6), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    AppMethodBeat.o(57452);
  }
  
  public static void b(long paramLong, String paramString, int paramInt)
  {
    AppMethodBeat.i(57454);
    h.qsU.e(15982, new Object[] { Integer.valueOf(23), Long.valueOf(paramLong), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), paramString, Integer.valueOf(paramInt), Integer.valueOf(0) });
    AppMethodBeat.o(57454);
  }
  
  public static void bnz()
  {
    AppMethodBeat.i(57453);
    h.qsU.e(15982, new Object[] { Integer.valueOf(24), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0) });
    AppMethodBeat.o(57453);
  }
  
  public static void d(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(57455);
    a(20, paramLong1, 0L, 0L, 0L, 0L, paramLong2, 0, 0, paramInt);
    AppMethodBeat.o(57455);
  }
  
  public static void e(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(57457);
    a(19, paramLong1, 0L, 0L, 0L, paramLong2, 0L, 0, 0, paramInt);
    ed(1, 1);
    AppMethodBeat.o(57457);
  }
  
  public static void ed(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(57459);
    h.qsU.j(852L, paramInt1, paramInt2);
    AppMethodBeat.o(57459);
  }
  
  public static void f(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(57456);
    a(22, paramLong, 0L, 0L, 0L, 0L, 0L, 0, paramInt1, paramInt2);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(57456);
      return;
      ed(7, 1);
      AppMethodBeat.o(57456);
      return;
      ed(6, 1);
      AppMethodBeat.o(57456);
      return;
      ed(28, 1);
      AppMethodBeat.o(57456);
      return;
      ed(22, 1);
      AppMethodBeat.o(57456);
      return;
      ed(24, 1);
      AppMethodBeat.o(57456);
      return;
      ed(25, 1);
      AppMethodBeat.o(57456);
      return;
      ed(26, 1);
      AppMethodBeat.o(57456);
      return;
      ed(27, 1);
      AppMethodBeat.o(57456);
      return;
      AppMethodBeat.o(57456);
      return;
      ed(8, 1);
    }
  }
  
  public static void g(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(57458);
    a(21, paramLong, 0L, 0L, 0L, 0L, 0L, paramInt1, 0, paramInt2);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(57458);
      return;
      ed(21, 1);
      AppMethodBeat.o(57458);
      return;
      ed(29, 1);
      AppMethodBeat.o(57458);
      return;
      ed(30, 1);
      AppMethodBeat.o(57458);
      return;
      ed(5, 1);
    }
  }
  
  public static void uB(int paramInt)
  {
    AppMethodBeat.i(156850);
    ed(paramInt, 1);
    AppMethodBeat.o(156850);
  }
  
  public final void bny()
  {
    int m = 1;
    int k = 0;
    AppMethodBeat.i(57451);
    if (!bo.isNullOrNil(this.ewF)) {
      this.ewF = this.ewF.replace(",", " ");
    }
    h localh = h.qsU;
    long l1 = this.eyh;
    long l2 = this.cew;
    long l3 = this.esf;
    long l4 = this.lsP;
    String str1 = this.ewF;
    String str2 = Integer.toHexString(this.textColor & 0xFFFFFF);
    int i;
    if (this.lsQ)
    {
      i = 1;
      if (!this.lsR) {
        break label304;
      }
    }
    label304:
    for (int j = 1;; j = 0)
    {
      int n = this.lsS;
      if (this.eyj) {
        k = 1;
      }
      int i1 = this.lsT;
      String str3 = this.lsU;
      if (this.eZK) {
        m = 2;
      }
      localh.e(15989, new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4), Integer.valueOf(0), Integer.valueOf(0), str1, str2, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(n), Integer.valueOf(k), Integer.valueOf(i1), str3, "", "", Integer.valueOf(m), this.lsV, this.lsW });
      AppMethodBeat.o(57451);
      return;
      i = 0;
      break;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    AppMethodBeat.i(57461);
    paramParcel.writeLong(this.eyh);
    paramParcel.writeLong(this.lsJ);
    paramParcel.writeLong(this.lsK);
    paramParcel.writeLong(this.lsL);
    paramParcel.writeLong(this.lsM);
    paramParcel.writeLong(this.lsN);
    paramParcel.writeLong(this.lsO);
    paramParcel.writeLong(this.esf);
    paramParcel.writeLong(this.lsP);
    paramParcel.writeLong(this.cew);
    paramParcel.writeInt(this.textColor);
    if (this.lsQ)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      if (!this.lsR) {
        break label182;
      }
      b1 = 1;
      label119:
      paramParcel.writeByte(b1);
      paramParcel.writeInt(this.lsS);
      if (!this.eyj) {
        break label187;
      }
    }
    label182:
    label187:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeInt(this.lsT);
      paramParcel.writeString(this.ewF);
      paramParcel.writeString(this.lsU);
      AppMethodBeat.o(57461);
      return;
      b1 = 0;
      break;
      b1 = 0;
      break label119;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter
 * JD-Core Version:    0.7.0.1
 */