package com.tencent.mm.plugin.emojicapture.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bt;

public class EmojiCaptureReporter
  implements Parcelable
{
  public static final Parcelable.Creator<EmojiCaptureReporter> CREATOR;
  public long cTt;
  public long fGg;
  public String fNa;
  public long fSw;
  public boolean fSy;
  public boolean gwz;
  public long oJc;
  public long oJd;
  public long oJe;
  public long oJf;
  public long oJg;
  public long oJh;
  public long oJi;
  public boolean oJj;
  public boolean oJk;
  public int oJl;
  public int oJm;
  public String oJn;
  public String oJo;
  public String oJp;
  public int oJq;
  public int oJr;
  public String oJs;
  public int oJt;
  public int oJu;
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
    this.oJt = 2;
    this.oJu = 9;
  }
  
  public EmojiCaptureReporter(Parcel paramParcel)
  {
    AppMethodBeat.i(104399);
    this.oJt = 2;
    this.oJu = 9;
    this.fSw = paramParcel.readLong();
    this.oJc = paramParcel.readLong();
    this.oJd = paramParcel.readLong();
    this.oJe = paramParcel.readLong();
    this.oJf = paramParcel.readLong();
    this.oJg = paramParcel.readLong();
    this.oJh = paramParcel.readLong();
    this.fGg = paramParcel.readLong();
    this.oJi = paramParcel.readLong();
    this.cTt = paramParcel.readLong();
    this.textColor = paramParcel.readInt();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.oJj = bool1;
      if (paramParcel.readByte() == 0) {
        break label195;
      }
      bool1 = true;
      label133:
      this.oJk = bool1;
      this.oJl = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label200;
      }
    }
    label195:
    label200:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.fSy = bool1;
      this.oJm = paramParcel.readInt();
      this.fNa = paramParcel.readString();
      this.oJn = paramParcel.readString();
      AppMethodBeat.o(104399);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label133;
    }
  }
  
  private void AK(int paramInt)
  {
    AppMethodBeat.i(104391);
    h.vKh.f(15982, new Object[] { Integer.valueOf(paramInt), Long.valueOf(this.fSw), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.scene), this.oJp, Integer.valueOf(this.oJq), Integer.valueOf(0), Integer.valueOf(this.oJr), this.oJs, Integer.valueOf(this.oJt), Integer.valueOf(this.oJu) });
    AppMethodBeat.o(104391);
  }
  
  public static void AL(int paramInt)
  {
    AppMethodBeat.i(205914);
    fg(paramInt, 1);
    AppMethodBeat.o(205914);
  }
  
  public static void a(int paramInt1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(104388);
    h.vKh.f(15982, new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Long.valueOf(0L), Long.valueOf(paramLong4), Long.valueOf(paramLong5), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    AppMethodBeat.o(104388);
  }
  
  public static void bXo()
  {
    AppMethodBeat.i(104390);
    h.vKh.f(15982, new Object[] { Integer.valueOf(24), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0) });
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
      fg(7, 1);
      AppMethodBeat.o(104393);
      return;
      fg(6, 1);
      AppMethodBeat.o(104393);
      return;
      fg(28, 1);
      AppMethodBeat.o(104393);
      return;
      fg(22, 1);
      AppMethodBeat.o(104393);
      return;
      fg(24, 1);
      AppMethodBeat.o(104393);
      return;
      fg(25, 1);
      AppMethodBeat.o(104393);
      return;
      fg(26, 1);
      AppMethodBeat.o(104393);
      return;
      fg(27, 1);
      AppMethodBeat.o(104393);
      return;
      AppMethodBeat.o(104393);
      return;
      fg(8, 1);
    }
  }
  
  public static void f(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(104392);
    a(20, paramLong1, 0L, 0L, 0L, paramLong2, 0, 0, paramInt);
    AppMethodBeat.o(104392);
  }
  
  public static void fg(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(104396);
    h.vKh.m(852L, paramInt1, paramInt2);
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
      fg(21, 1);
      AppMethodBeat.o(104395);
      return;
      fg(29, 1);
      AppMethodBeat.o(104395);
      return;
      fg(30, 1);
      AppMethodBeat.o(104395);
      return;
      fg(5, 1);
    }
  }
  
  public static void g(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(104394);
    a(19, paramLong1, 0L, 0L, paramLong2, 0L, 0, 0, paramInt);
    fg(1, 1);
    AppMethodBeat.o(104394);
  }
  
  public final void aZs()
  {
    AppMethodBeat.i(104386);
    h.vKh.f(15982, new Object[] { Integer.valueOf(3), Long.valueOf(this.fSw), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.scene), this.oJp, Integer.valueOf(this.oJq), Integer.valueOf(0), Integer.valueOf(this.oJr), this.oJs, Integer.valueOf(this.oJt), Integer.valueOf(this.oJu) });
    AppMethodBeat.o(104386);
  }
  
  public final void bXk()
  {
    AppMethodBeat.i(104384);
    AK(25);
    AppMethodBeat.o(104384);
  }
  
  public final void bXl()
  {
    AppMethodBeat.i(104385);
    AK(26);
    AppMethodBeat.o(104385);
  }
  
  public final void bXm()
  {
    int m = 1;
    int k = 0;
    AppMethodBeat.i(104387);
    if (!bt.isNullOrNil(this.fNa)) {
      this.fNa = this.fNa.replace(",", " ");
    }
    h localh = h.vKh;
    long l1 = this.fSw;
    long l2 = this.cTt;
    long l3 = this.fGg;
    long l4 = this.oJi;
    String str1 = this.fNa;
    String str2 = Integer.toHexString(this.textColor & 0xFFFFFF);
    int i;
    if (this.oJj)
    {
      i = 1;
      if (!this.oJk) {
        break label312;
      }
    }
    label312:
    for (int j = 1;; j = 0)
    {
      int n = this.oJl;
      if (this.fSy) {
        k = 1;
      }
      int i1 = this.oJm;
      String str3 = this.oJn;
      if (this.gwz) {
        m = 2;
      }
      localh.f(15989, new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4), Integer.valueOf(0), Integer.valueOf(0), str1, str2, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(n), Integer.valueOf(k), Integer.valueOf(i1), str3, "", "", Integer.valueOf(m), this.oJo, this.oJp, this.oJs });
      AppMethodBeat.o(104387);
      return;
      i = 0;
      break;
    }
  }
  
  public final void bXn()
  {
    AppMethodBeat.i(104389);
    h.vKh.f(15982, new Object[] { Integer.valueOf(17), Long.valueOf(this.fSw), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(this.oJi), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.scene), this.oJp, Integer.valueOf(this.oJq), Integer.valueOf(0), Integer.valueOf(this.oJr), this.oJs, Integer.valueOf(this.oJt), Integer.valueOf(this.oJu) });
    AppMethodBeat.o(104389);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void fe(String paramString1, String paramString2)
  {
    AppMethodBeat.i(104383);
    h.vKh.f(15982, new Object[] { Integer.valueOf(27), Long.valueOf(this.fSw), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.scene), paramString1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), paramString2, Integer.valueOf(this.oJt) });
    AppMethodBeat.o(104383);
  }
  
  public final void h(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(104382);
    this.oJp = paramString1;
    this.oJs = paramString2;
    this.oJq = paramInt1;
    this.oJr = paramInt2;
    AK(23);
    AppMethodBeat.o(104382);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    AppMethodBeat.i(104398);
    paramParcel.writeLong(this.fSw);
    paramParcel.writeLong(this.oJc);
    paramParcel.writeLong(this.oJd);
    paramParcel.writeLong(this.oJe);
    paramParcel.writeLong(this.oJf);
    paramParcel.writeLong(this.oJg);
    paramParcel.writeLong(this.oJh);
    paramParcel.writeLong(this.fGg);
    paramParcel.writeLong(this.oJi);
    paramParcel.writeLong(this.cTt);
    paramParcel.writeInt(this.textColor);
    if (this.oJj)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      if (!this.oJk) {
        break label182;
      }
      b1 = 1;
      label119:
      paramParcel.writeByte(b1);
      paramParcel.writeInt(this.oJl);
      if (!this.fSy) {
        break label187;
      }
    }
    label182:
    label187:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeInt(this.oJm);
      paramParcel.writeString(this.fNa);
      paramParcel.writeString(this.oJn);
      AppMethodBeat.o(104398);
      return;
      b1 = 0;
      break;
      b1 = 0;
      break label119;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter
 * JD-Core Version:    0.7.0.1
 */