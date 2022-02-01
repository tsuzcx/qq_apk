package com.tencent.mm.plugin.emojicapture.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bu;

public class EmojiCaptureReporter
  implements Parcelable
{
  public static final Parcelable.Creator<EmojiCaptureReporter> CREATOR;
  public int dataSize;
  public long ddi;
  public long gfw;
  public String gmF;
  public long gsp;
  public boolean gsr;
  public boolean hrQ;
  public long pWH;
  public long pWI;
  public long pWJ;
  public long pWK;
  public long pWL;
  public long pWM;
  public long pWN;
  public boolean pWO;
  public boolean pWP;
  public int pWQ;
  public String pWR;
  public String pWS;
  public String pWT;
  public int pWU;
  public int pWV;
  public String pWW;
  public int pWX;
  public int pWY;
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
    this.pWX = 2;
    this.pWY = 9;
  }
  
  public EmojiCaptureReporter(Parcel paramParcel)
  {
    AppMethodBeat.i(104399);
    this.pWX = 2;
    this.pWY = 9;
    this.gsp = paramParcel.readLong();
    this.pWH = paramParcel.readLong();
    this.pWI = paramParcel.readLong();
    this.pWJ = paramParcel.readLong();
    this.pWK = paramParcel.readLong();
    this.pWL = paramParcel.readLong();
    this.pWM = paramParcel.readLong();
    this.gfw = paramParcel.readLong();
    this.pWN = paramParcel.readLong();
    this.ddi = paramParcel.readLong();
    this.textColor = paramParcel.readInt();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.pWO = bool1;
      if (paramParcel.readByte() == 0) {
        break label195;
      }
      bool1 = true;
      label133:
      this.pWP = bool1;
      this.pWQ = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label200;
      }
    }
    label195:
    label200:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.gsr = bool1;
      this.dataSize = paramParcel.readInt();
      this.gmF = paramParcel.readString();
      this.pWR = paramParcel.readString();
      AppMethodBeat.o(104399);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label133;
    }
  }
  
  private void Cw(int paramInt)
  {
    AppMethodBeat.i(104391);
    g.yxI.f(15982, new Object[] { Integer.valueOf(paramInt), Long.valueOf(this.gsp), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.scene), this.pWT, Integer.valueOf(this.pWU), Integer.valueOf(0), Integer.valueOf(this.pWV), this.pWW, Integer.valueOf(this.pWX), Integer.valueOf(this.pWY) });
    AppMethodBeat.o(104391);
  }
  
  public static void Cx(int paramInt)
  {
    AppMethodBeat.i(224508);
    fo(paramInt, 1);
    AppMethodBeat.o(224508);
  }
  
  public static void a(int paramInt1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(104388);
    g.yxI.f(15982, new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Long.valueOf(0L), Long.valueOf(paramLong4), Long.valueOf(paramLong5), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    AppMethodBeat.o(104388);
  }
  
  public static void cku()
  {
    AppMethodBeat.i(104390);
    g.yxI.f(15982, new Object[] { Integer.valueOf(24), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0) });
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
      fo(7, 1);
      AppMethodBeat.o(104393);
      return;
      fo(6, 1);
      AppMethodBeat.o(104393);
      return;
      fo(28, 1);
      AppMethodBeat.o(104393);
      return;
      fo(22, 1);
      AppMethodBeat.o(104393);
      return;
      fo(24, 1);
      AppMethodBeat.o(104393);
      return;
      fo(25, 1);
      AppMethodBeat.o(104393);
      return;
      fo(26, 1);
      AppMethodBeat.o(104393);
      return;
      fo(27, 1);
      AppMethodBeat.o(104393);
      return;
      AppMethodBeat.o(104393);
      return;
      fo(8, 1);
    }
  }
  
  public static void f(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(104392);
    a(20, paramLong1, 0L, 0L, 0L, paramLong2, 0, 0, paramInt);
    AppMethodBeat.o(104392);
  }
  
  public static void fo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(104396);
    g.yxI.n(852L, paramInt1, paramInt2);
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
      fo(21, 1);
      AppMethodBeat.o(104395);
      return;
      fo(29, 1);
      AppMethodBeat.o(104395);
      return;
      fo(30, 1);
      AppMethodBeat.o(104395);
      return;
      fo(5, 1);
    }
  }
  
  public static void g(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(104394);
    a(19, paramLong1, 0L, 0L, paramLong2, 0L, 0, 0, paramInt);
    fo(1, 1);
    AppMethodBeat.o(104394);
  }
  
  public final void bkx()
  {
    AppMethodBeat.i(104386);
    g.yxI.f(15982, new Object[] { Integer.valueOf(3), Long.valueOf(this.gsp), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.scene), this.pWT, Integer.valueOf(this.pWU), Integer.valueOf(0), Integer.valueOf(this.pWV), this.pWW, Integer.valueOf(this.pWX), Integer.valueOf(this.pWY) });
    AppMethodBeat.o(104386);
  }
  
  public final void ckq()
  {
    AppMethodBeat.i(104384);
    Cw(25);
    AppMethodBeat.o(104384);
  }
  
  public final void ckr()
  {
    AppMethodBeat.i(104385);
    Cw(26);
    AppMethodBeat.o(104385);
  }
  
  public final void cks()
  {
    int m = 1;
    int k = 0;
    AppMethodBeat.i(104387);
    if (!bu.isNullOrNil(this.gmF)) {
      this.gmF = this.gmF.replace(",", " ");
    }
    g localg = g.yxI;
    long l1 = this.gsp;
    long l2 = this.ddi;
    long l3 = this.gfw;
    long l4 = this.pWN;
    String str1 = this.gmF;
    String str2 = Integer.toHexString(this.textColor & 0xFFFFFF);
    int i;
    if (this.pWO)
    {
      i = 1;
      if (!this.pWP) {
        break label312;
      }
    }
    label312:
    for (int j = 1;; j = 0)
    {
      int n = this.pWQ;
      if (this.gsr) {
        k = 1;
      }
      int i1 = this.dataSize;
      String str3 = this.pWR;
      if (this.hrQ) {
        m = 2;
      }
      localg.f(15989, new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4), Integer.valueOf(0), Integer.valueOf(0), str1, str2, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(n), Integer.valueOf(k), Integer.valueOf(i1), str3, "", "", Integer.valueOf(m), this.pWS, this.pWT, this.pWW });
      AppMethodBeat.o(104387);
      return;
      i = 0;
      break;
    }
  }
  
  public final void ckt()
  {
    AppMethodBeat.i(104389);
    g.yxI.f(15982, new Object[] { Integer.valueOf(17), Long.valueOf(this.gsp), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(this.pWN), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.scene), this.pWT, Integer.valueOf(this.pWU), Integer.valueOf(0), Integer.valueOf(this.pWV), this.pWW, Integer.valueOf(this.pWX), Integer.valueOf(this.pWY) });
    AppMethodBeat.o(104389);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void fF(String paramString1, String paramString2)
  {
    AppMethodBeat.i(104383);
    g.yxI.f(15982, new Object[] { Integer.valueOf(27), Long.valueOf(this.gsp), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.scene), paramString1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), paramString2, Integer.valueOf(this.pWX) });
    AppMethodBeat.o(104383);
  }
  
  public final void h(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(104382);
    this.pWT = paramString1;
    this.pWW = paramString2;
    this.pWU = paramInt1;
    this.pWV = paramInt2;
    Cw(23);
    AppMethodBeat.o(104382);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    AppMethodBeat.i(104398);
    paramParcel.writeLong(this.gsp);
    paramParcel.writeLong(this.pWH);
    paramParcel.writeLong(this.pWI);
    paramParcel.writeLong(this.pWJ);
    paramParcel.writeLong(this.pWK);
    paramParcel.writeLong(this.pWL);
    paramParcel.writeLong(this.pWM);
    paramParcel.writeLong(this.gfw);
    paramParcel.writeLong(this.pWN);
    paramParcel.writeLong(this.ddi);
    paramParcel.writeInt(this.textColor);
    if (this.pWO)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      if (!this.pWP) {
        break label182;
      }
      b1 = 1;
      label119:
      paramParcel.writeByte(b1);
      paramParcel.writeInt(this.pWQ);
      if (!this.gsr) {
        break label187;
      }
    }
    label182:
    label187:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeInt(this.dataSize);
      paramParcel.writeString(this.gmF);
      paramParcel.writeString(this.pWR);
      AppMethodBeat.o(104398);
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