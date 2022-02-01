package com.tencent.mm.plugin.emojicapture.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bs;

public class EmojiCaptureReporter
  implements Parcelable
{
  public static final Parcelable.Creator<EmojiCaptureReporter> CREATOR;
  public long cQQ;
  public int dataSize;
  public long fJN;
  public String fQL;
  public long fWr;
  public boolean fWt;
  public boolean gWW;
  public long pmC;
  public long pmD;
  public long pmE;
  public long pmF;
  public long pmG;
  public long pmH;
  public long pmI;
  public boolean pmJ;
  public boolean pmK;
  public int pmL;
  public String pmM;
  public String pmN;
  public String pmO;
  public int pmP;
  public int pmQ;
  public String pmR;
  public int pmS;
  public int pmT;
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
    this.pmS = 2;
    this.pmT = 9;
  }
  
  public EmojiCaptureReporter(Parcel paramParcel)
  {
    AppMethodBeat.i(104399);
    this.pmS = 2;
    this.pmT = 9;
    this.fWr = paramParcel.readLong();
    this.pmC = paramParcel.readLong();
    this.pmD = paramParcel.readLong();
    this.pmE = paramParcel.readLong();
    this.pmF = paramParcel.readLong();
    this.pmG = paramParcel.readLong();
    this.pmH = paramParcel.readLong();
    this.fJN = paramParcel.readLong();
    this.pmI = paramParcel.readLong();
    this.cQQ = paramParcel.readLong();
    this.textColor = paramParcel.readInt();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.pmJ = bool1;
      if (paramParcel.readByte() == 0) {
        break label195;
      }
      bool1 = true;
      label133:
      this.pmK = bool1;
      this.pmL = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label200;
      }
    }
    label195:
    label200:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.fWt = bool1;
      this.dataSize = paramParcel.readInt();
      this.fQL = paramParcel.readString();
      this.pmM = paramParcel.readString();
      AppMethodBeat.o(104399);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label133;
    }
  }
  
  private void BC(int paramInt)
  {
    AppMethodBeat.i(104391);
    h.wUl.f(15982, new Object[] { Integer.valueOf(paramInt), Long.valueOf(this.fWr), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.scene), this.pmO, Integer.valueOf(this.pmP), Integer.valueOf(0), Integer.valueOf(this.pmQ), this.pmR, Integer.valueOf(this.pmS), Integer.valueOf(this.pmT) });
    AppMethodBeat.o(104391);
  }
  
  public static void BD(int paramInt)
  {
    AppMethodBeat.i(210479);
    fj(paramInt, 1);
    AppMethodBeat.o(210479);
  }
  
  public static void a(int paramInt1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(104388);
    h.wUl.f(15982, new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Long.valueOf(0L), Long.valueOf(paramLong4), Long.valueOf(paramLong5), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    AppMethodBeat.o(104388);
  }
  
  public static void ceB()
  {
    AppMethodBeat.i(104390);
    h.wUl.f(15982, new Object[] { Integer.valueOf(24), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0) });
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
      fj(7, 1);
      AppMethodBeat.o(104393);
      return;
      fj(6, 1);
      AppMethodBeat.o(104393);
      return;
      fj(28, 1);
      AppMethodBeat.o(104393);
      return;
      fj(22, 1);
      AppMethodBeat.o(104393);
      return;
      fj(24, 1);
      AppMethodBeat.o(104393);
      return;
      fj(25, 1);
      AppMethodBeat.o(104393);
      return;
      fj(26, 1);
      AppMethodBeat.o(104393);
      return;
      fj(27, 1);
      AppMethodBeat.o(104393);
      return;
      AppMethodBeat.o(104393);
      return;
      fj(8, 1);
    }
  }
  
  public static void f(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(104392);
    a(20, paramLong1, 0L, 0L, 0L, paramLong2, 0, 0, paramInt);
    AppMethodBeat.o(104392);
  }
  
  public static void fj(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(104396);
    h.wUl.n(852L, paramInt1, paramInt2);
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
      fj(21, 1);
      AppMethodBeat.o(104395);
      return;
      fj(29, 1);
      AppMethodBeat.o(104395);
      return;
      fj(30, 1);
      AppMethodBeat.o(104395);
      return;
      fj(5, 1);
    }
  }
  
  public static void g(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(104394);
    a(19, paramLong1, 0L, 0L, paramLong2, 0L, 0, 0, paramInt);
    fj(1, 1);
    AppMethodBeat.o(104394);
  }
  
  public final void bgk()
  {
    AppMethodBeat.i(104386);
    h.wUl.f(15982, new Object[] { Integer.valueOf(3), Long.valueOf(this.fWr), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.scene), this.pmO, Integer.valueOf(this.pmP), Integer.valueOf(0), Integer.valueOf(this.pmQ), this.pmR, Integer.valueOf(this.pmS), Integer.valueOf(this.pmT) });
    AppMethodBeat.o(104386);
  }
  
  public final void ceA()
  {
    AppMethodBeat.i(104389);
    h.wUl.f(15982, new Object[] { Integer.valueOf(17), Long.valueOf(this.fWr), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(this.pmI), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.scene), this.pmO, Integer.valueOf(this.pmP), Integer.valueOf(0), Integer.valueOf(this.pmQ), this.pmR, Integer.valueOf(this.pmS), Integer.valueOf(this.pmT) });
    AppMethodBeat.o(104389);
  }
  
  public final void cex()
  {
    AppMethodBeat.i(104384);
    BC(25);
    AppMethodBeat.o(104384);
  }
  
  public final void cey()
  {
    AppMethodBeat.i(104385);
    BC(26);
    AppMethodBeat.o(104385);
  }
  
  public final void cez()
  {
    int m = 1;
    int k = 0;
    AppMethodBeat.i(104387);
    if (!bs.isNullOrNil(this.fQL)) {
      this.fQL = this.fQL.replace(",", " ");
    }
    h localh = h.wUl;
    long l1 = this.fWr;
    long l2 = this.cQQ;
    long l3 = this.fJN;
    long l4 = this.pmI;
    String str1 = this.fQL;
    String str2 = Integer.toHexString(this.textColor & 0xFFFFFF);
    int i;
    if (this.pmJ)
    {
      i = 1;
      if (!this.pmK) {
        break label312;
      }
    }
    label312:
    for (int j = 1;; j = 0)
    {
      int n = this.pmL;
      if (this.fWt) {
        k = 1;
      }
      int i1 = this.dataSize;
      String str3 = this.pmM;
      if (this.gWW) {
        m = 2;
      }
      localh.f(15989, new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4), Integer.valueOf(0), Integer.valueOf(0), str1, str2, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(n), Integer.valueOf(k), Integer.valueOf(i1), str3, "", "", Integer.valueOf(m), this.pmN, this.pmO, this.pmR });
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
  
  public final void fr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(104383);
    h.wUl.f(15982, new Object[] { Integer.valueOf(27), Long.valueOf(this.fWr), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.scene), paramString1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), paramString2, Integer.valueOf(this.pmS) });
    AppMethodBeat.o(104383);
  }
  
  public final void h(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(104382);
    this.pmO = paramString1;
    this.pmR = paramString2;
    this.pmP = paramInt1;
    this.pmQ = paramInt2;
    BC(23);
    AppMethodBeat.o(104382);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    AppMethodBeat.i(104398);
    paramParcel.writeLong(this.fWr);
    paramParcel.writeLong(this.pmC);
    paramParcel.writeLong(this.pmD);
    paramParcel.writeLong(this.pmE);
    paramParcel.writeLong(this.pmF);
    paramParcel.writeLong(this.pmG);
    paramParcel.writeLong(this.pmH);
    paramParcel.writeLong(this.fJN);
    paramParcel.writeLong(this.pmI);
    paramParcel.writeLong(this.cQQ);
    paramParcel.writeInt(this.textColor);
    if (this.pmJ)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      if (!this.pmK) {
        break label182;
      }
      b1 = 1;
      label119:
      paramParcel.writeByte(b1);
      paramParcel.writeInt(this.pmL);
      if (!this.fWt) {
        break label187;
      }
    }
    label182:
    label187:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeInt(this.dataSize);
      paramParcel.writeString(this.fQL);
      paramParcel.writeString(this.pmM);
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