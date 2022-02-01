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
  public long fmH;
  public String jIv;
  public long jPf;
  public boolean jPh;
  public long jvs;
  public boolean laM;
  public int scene;
  public int textColor;
  public int uTA;
  public int uTB;
  public String uTC;
  public int uTD;
  public int uTE;
  public long uTn;
  public long uTo;
  public long uTp;
  public long uTq;
  public long uTr;
  public long uTs;
  public long uTt;
  public boolean uTu;
  public boolean uTv;
  public int uTw;
  public String uTx;
  public String uTy;
  public String uTz;
  
  static
  {
    AppMethodBeat.i(104400);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(104400);
  }
  
  public EmojiCaptureReporter()
  {
    this.uTD = 2;
    this.uTE = 9;
  }
  
  public EmojiCaptureReporter(Parcel paramParcel)
  {
    AppMethodBeat.i(104399);
    this.uTD = 2;
    this.uTE = 9;
    this.jPf = paramParcel.readLong();
    this.uTn = paramParcel.readLong();
    this.uTo = paramParcel.readLong();
    this.uTp = paramParcel.readLong();
    this.uTq = paramParcel.readLong();
    this.uTr = paramParcel.readLong();
    this.uTs = paramParcel.readLong();
    this.jvs = paramParcel.readLong();
    this.uTt = paramParcel.readLong();
    this.fmH = paramParcel.readLong();
    this.textColor = paramParcel.readInt();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.uTu = bool1;
      if (paramParcel.readByte() == 0) {
        break label195;
      }
      bool1 = true;
      label133:
      this.uTv = bool1;
      this.uTw = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label200;
      }
    }
    label195:
    label200:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jPh = bool1;
      this.dataSize = paramParcel.readInt();
      this.jIv = paramParcel.readString();
      this.uTx = paramParcel.readString();
      AppMethodBeat.o(104399);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label133;
    }
  }
  
  private void JO(int paramInt)
  {
    AppMethodBeat.i(104391);
    h.IzE.a(15982, new Object[] { Integer.valueOf(paramInt), Long.valueOf(this.jPf), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.scene), this.uTz, Integer.valueOf(this.uTA), Integer.valueOf(0), Integer.valueOf(this.uTB), this.uTC, Integer.valueOf(this.uTD), Integer.valueOf(this.uTE) });
    AppMethodBeat.o(104391);
  }
  
  public static void JP(int paramInt)
  {
    AppMethodBeat.i(293065);
    gb(paramInt, 1);
    AppMethodBeat.o(293065);
  }
  
  public static void a(int paramInt1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(104388);
    h.IzE.a(15982, new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Long.valueOf(0L), Long.valueOf(paramLong4), Long.valueOf(paramLong5), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    AppMethodBeat.o(104388);
  }
  
  public static void cXf()
  {
    AppMethodBeat.i(104390);
    h.IzE.a(15982, new Object[] { Integer.valueOf(24), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0) });
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
      gb(7, 1);
      AppMethodBeat.o(104393);
      return;
      gb(6, 1);
      AppMethodBeat.o(104393);
      return;
      gb(28, 1);
      AppMethodBeat.o(104393);
      return;
      gb(22, 1);
      AppMethodBeat.o(104393);
      return;
      gb(24, 1);
      AppMethodBeat.o(104393);
      return;
      gb(25, 1);
      AppMethodBeat.o(104393);
      return;
      gb(26, 1);
      AppMethodBeat.o(104393);
      return;
      gb(27, 1);
      AppMethodBeat.o(104393);
      return;
      AppMethodBeat.o(104393);
      return;
      gb(8, 1);
    }
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
      gb(21, 1);
      AppMethodBeat.o(104395);
      return;
      gb(29, 1);
      AppMethodBeat.o(104395);
      return;
      gb(30, 1);
      AppMethodBeat.o(104395);
      return;
      gb(5, 1);
    }
  }
  
  public static void g(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(104392);
    a(20, paramLong1, 0L, 0L, 0L, paramLong2, 0, 0, paramInt);
    AppMethodBeat.o(104392);
  }
  
  public static void gb(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(104396);
    h.IzE.p(852L, paramInt1, paramInt2);
    AppMethodBeat.o(104396);
  }
  
  public static void h(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(104394);
    a(19, paramLong1, 0L, 0L, paramLong2, 0L, 0, 0, paramInt);
    gb(1, 1);
    AppMethodBeat.o(104394);
  }
  
  public final void bRC()
  {
    AppMethodBeat.i(104386);
    h.IzE.a(15982, new Object[] { Integer.valueOf(3), Long.valueOf(this.jPf), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.scene), this.uTz, Integer.valueOf(this.uTA), Integer.valueOf(0), Integer.valueOf(this.uTB), this.uTC, Integer.valueOf(this.uTD), Integer.valueOf(this.uTE) });
    AppMethodBeat.o(104386);
  }
  
  public final void cXb()
  {
    AppMethodBeat.i(104384);
    JO(25);
    AppMethodBeat.o(104384);
  }
  
  public final void cXc()
  {
    AppMethodBeat.i(104385);
    JO(26);
    AppMethodBeat.o(104385);
  }
  
  public final void cXd()
  {
    int m = 1;
    int k = 0;
    AppMethodBeat.i(104387);
    if (!Util.isNullOrNil(this.jIv)) {
      this.jIv = this.jIv.replace(",", " ");
    }
    h localh = h.IzE;
    long l1 = this.jPf;
    long l2 = this.fmH;
    long l3 = this.jvs;
    long l4 = this.uTt;
    String str1 = this.jIv;
    String str2 = Integer.toHexString(this.textColor & 0xFFFFFF);
    int i;
    if (this.uTu)
    {
      i = 1;
      if (!this.uTv) {
        break label312;
      }
    }
    label312:
    for (int j = 1;; j = 0)
    {
      int n = this.uTw;
      if (this.jPh) {
        k = 1;
      }
      int i1 = this.dataSize;
      String str3 = this.uTx;
      if (this.laM) {
        m = 2;
      }
      localh.a(15989, new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4), Integer.valueOf(0), Integer.valueOf(0), str1, str2, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(n), Integer.valueOf(k), Integer.valueOf(i1), str3, "", "", Integer.valueOf(m), this.uTy, this.uTz, this.uTC });
      AppMethodBeat.o(104387);
      return;
      i = 0;
      break;
    }
  }
  
  public final void cXe()
  {
    AppMethodBeat.i(104389);
    h.IzE.a(15982, new Object[] { Integer.valueOf(17), Long.valueOf(this.jPf), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(this.uTt), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.scene), this.uTz, Integer.valueOf(this.uTA), Integer.valueOf(0), Integer.valueOf(this.uTB), this.uTC, Integer.valueOf(this.uTD), Integer.valueOf(this.uTE) });
    AppMethodBeat.o(104389);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void gl(String paramString1, String paramString2)
  {
    AppMethodBeat.i(104383);
    h.IzE.a(15982, new Object[] { Integer.valueOf(27), Long.valueOf(this.jPf), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.scene), paramString1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), paramString2, Integer.valueOf(this.uTD) });
    AppMethodBeat.o(104383);
  }
  
  public final void h(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(104382);
    this.uTz = paramString1;
    this.uTC = paramString2;
    this.uTA = paramInt1;
    this.uTB = paramInt2;
    JO(23);
    AppMethodBeat.o(104382);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    AppMethodBeat.i(104398);
    paramParcel.writeLong(this.jPf);
    paramParcel.writeLong(this.uTn);
    paramParcel.writeLong(this.uTo);
    paramParcel.writeLong(this.uTp);
    paramParcel.writeLong(this.uTq);
    paramParcel.writeLong(this.uTr);
    paramParcel.writeLong(this.uTs);
    paramParcel.writeLong(this.jvs);
    paramParcel.writeLong(this.uTt);
    paramParcel.writeLong(this.fmH);
    paramParcel.writeInt(this.textColor);
    if (this.uTu)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      if (!this.uTv) {
        break label182;
      }
      b1 = 1;
      label119:
      paramParcel.writeByte(b1);
      paramParcel.writeInt(this.uTw);
      if (!this.jPh) {
        break label187;
      }
    }
    label182:
    label187:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeInt(this.dataSize);
      paramParcel.writeString(this.jIv);
      paramParcel.writeString(this.uTx);
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