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
  public long dtZ;
  public long gLd;
  public String gXx;
  public boolean hdB;
  public long hdz;
  public boolean ilM;
  public long rnG;
  public long rnH;
  public long rnI;
  public long rnJ;
  public long rnK;
  public long rnL;
  public long rnM;
  public boolean rnN;
  public boolean rnO;
  public int rnP;
  public String rnQ;
  public String rnR;
  public String rnS;
  public int rnT;
  public int rnU;
  public String rnV;
  public int rnW;
  public int rnX;
  public int scene;
  public int textColor;
  
  static
  {
    AppMethodBeat.i(104400);
    CREATOR = new EmojiCaptureReporter.1();
    AppMethodBeat.o(104400);
  }
  
  public EmojiCaptureReporter()
  {
    this.rnW = 2;
    this.rnX = 9;
  }
  
  public EmojiCaptureReporter(Parcel paramParcel)
  {
    AppMethodBeat.i(104399);
    this.rnW = 2;
    this.rnX = 9;
    this.hdz = paramParcel.readLong();
    this.rnG = paramParcel.readLong();
    this.rnH = paramParcel.readLong();
    this.rnI = paramParcel.readLong();
    this.rnJ = paramParcel.readLong();
    this.rnK = paramParcel.readLong();
    this.rnL = paramParcel.readLong();
    this.gLd = paramParcel.readLong();
    this.rnM = paramParcel.readLong();
    this.dtZ = paramParcel.readLong();
    this.textColor = paramParcel.readInt();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.rnN = bool1;
      if (paramParcel.readByte() == 0) {
        break label195;
      }
      bool1 = true;
      label133:
      this.rnO = bool1;
      this.rnP = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label200;
      }
    }
    label195:
    label200:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.hdB = bool1;
      this.dataSize = paramParcel.readInt();
      this.gXx = paramParcel.readString();
      this.rnQ = paramParcel.readString();
      AppMethodBeat.o(104399);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label133;
    }
  }
  
  private void Gh(int paramInt)
  {
    AppMethodBeat.i(104391);
    h.CyF.a(15982, new Object[] { Integer.valueOf(paramInt), Long.valueOf(this.hdz), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.scene), this.rnS, Integer.valueOf(this.rnT), Integer.valueOf(0), Integer.valueOf(this.rnU), this.rnV, Integer.valueOf(this.rnW), Integer.valueOf(this.rnX) });
    AppMethodBeat.o(104391);
  }
  
  public static void Gi(int paramInt)
  {
    AppMethodBeat.i(258691);
    fE(paramInt, 1);
    AppMethodBeat.o(258691);
  }
  
  public static void a(int paramInt1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(104388);
    h.CyF.a(15982, new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Long.valueOf(0L), Long.valueOf(paramLong4), Long.valueOf(paramLong5), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    AppMethodBeat.o(104388);
  }
  
  public static void cIw()
  {
    AppMethodBeat.i(104390);
    h.CyF.a(15982, new Object[] { Integer.valueOf(24), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0) });
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
      fE(7, 1);
      AppMethodBeat.o(104393);
      return;
      fE(6, 1);
      AppMethodBeat.o(104393);
      return;
      fE(28, 1);
      AppMethodBeat.o(104393);
      return;
      fE(22, 1);
      AppMethodBeat.o(104393);
      return;
      fE(24, 1);
      AppMethodBeat.o(104393);
      return;
      fE(25, 1);
      AppMethodBeat.o(104393);
      return;
      fE(26, 1);
      AppMethodBeat.o(104393);
      return;
      fE(27, 1);
      AppMethodBeat.o(104393);
      return;
      AppMethodBeat.o(104393);
      return;
      fE(8, 1);
    }
  }
  
  public static void f(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(104392);
    a(20, paramLong1, 0L, 0L, 0L, paramLong2, 0, 0, paramInt);
    AppMethodBeat.o(104392);
  }
  
  public static void fE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(104396);
    h.CyF.n(852L, paramInt1, paramInt2);
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
      fE(21, 1);
      AppMethodBeat.o(104395);
      return;
      fE(29, 1);
      AppMethodBeat.o(104395);
      return;
      fE(30, 1);
      AppMethodBeat.o(104395);
      return;
      fE(5, 1);
    }
  }
  
  public static void g(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(104394);
    a(19, paramLong1, 0L, 0L, paramLong2, 0L, 0, 0, paramInt);
    fE(1, 1);
    AppMethodBeat.o(104394);
  }
  
  public final void bFT()
  {
    AppMethodBeat.i(104386);
    h.CyF.a(15982, new Object[] { Integer.valueOf(3), Long.valueOf(this.hdz), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.scene), this.rnS, Integer.valueOf(this.rnT), Integer.valueOf(0), Integer.valueOf(this.rnU), this.rnV, Integer.valueOf(this.rnW), Integer.valueOf(this.rnX) });
    AppMethodBeat.o(104386);
  }
  
  public final void cIs()
  {
    AppMethodBeat.i(104384);
    Gh(25);
    AppMethodBeat.o(104384);
  }
  
  public final void cIt()
  {
    AppMethodBeat.i(104385);
    Gh(26);
    AppMethodBeat.o(104385);
  }
  
  public final void cIu()
  {
    int m = 1;
    int k = 0;
    AppMethodBeat.i(104387);
    if (!Util.isNullOrNil(this.gXx)) {
      this.gXx = this.gXx.replace(",", " ");
    }
    h localh = h.CyF;
    long l1 = this.hdz;
    long l2 = this.dtZ;
    long l3 = this.gLd;
    long l4 = this.rnM;
    String str1 = this.gXx;
    String str2 = Integer.toHexString(this.textColor & 0xFFFFFF);
    int i;
    if (this.rnN)
    {
      i = 1;
      if (!this.rnO) {
        break label312;
      }
    }
    label312:
    for (int j = 1;; j = 0)
    {
      int n = this.rnP;
      if (this.hdB) {
        k = 1;
      }
      int i1 = this.dataSize;
      String str3 = this.rnQ;
      if (this.ilM) {
        m = 2;
      }
      localh.a(15989, new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4), Integer.valueOf(0), Integer.valueOf(0), str1, str2, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(n), Integer.valueOf(k), Integer.valueOf(i1), str3, "", "", Integer.valueOf(m), this.rnR, this.rnS, this.rnV });
      AppMethodBeat.o(104387);
      return;
      i = 0;
      break;
    }
  }
  
  public final void cIv()
  {
    AppMethodBeat.i(104389);
    h.CyF.a(15982, new Object[] { Integer.valueOf(17), Long.valueOf(this.hdz), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(this.rnM), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.scene), this.rnS, Integer.valueOf(this.rnT), Integer.valueOf(0), Integer.valueOf(this.rnU), this.rnV, Integer.valueOf(this.rnW), Integer.valueOf(this.rnX) });
    AppMethodBeat.o(104389);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void fY(String paramString1, String paramString2)
  {
    AppMethodBeat.i(104383);
    h.CyF.a(15982, new Object[] { Integer.valueOf(27), Long.valueOf(this.hdz), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.scene), paramString1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), paramString2, Integer.valueOf(this.rnW) });
    AppMethodBeat.o(104383);
  }
  
  public final void h(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(104382);
    this.rnS = paramString1;
    this.rnV = paramString2;
    this.rnT = paramInt1;
    this.rnU = paramInt2;
    Gh(23);
    AppMethodBeat.o(104382);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    AppMethodBeat.i(104398);
    paramParcel.writeLong(this.hdz);
    paramParcel.writeLong(this.rnG);
    paramParcel.writeLong(this.rnH);
    paramParcel.writeLong(this.rnI);
    paramParcel.writeLong(this.rnJ);
    paramParcel.writeLong(this.rnK);
    paramParcel.writeLong(this.rnL);
    paramParcel.writeLong(this.gLd);
    paramParcel.writeLong(this.rnM);
    paramParcel.writeLong(this.dtZ);
    paramParcel.writeInt(this.textColor);
    if (this.rnN)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      if (!this.rnO) {
        break label182;
      }
      b1 = 1;
      label119:
      paramParcel.writeByte(b1);
      paramParcel.writeInt(this.rnP);
      if (!this.hdB) {
        break label187;
      }
    }
    label182:
    label187:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeInt(this.dataSize);
      paramParcel.writeString(this.gXx);
      paramParcel.writeString(this.rnQ);
      AppMethodBeat.o(104398);
      return;
      b1 = 0;
      break;
      b1 = 0;
      break label119;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter
 * JD-Core Version:    0.7.0.1
 */