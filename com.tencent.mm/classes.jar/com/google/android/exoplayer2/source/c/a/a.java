package com.google.android.exoplayer2.source.c.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.UUID;

public final class a
{
  public final long aSz;
  public final int bjD;
  public final boolean bqS;
  public final int brn;
  public final a bro;
  public final b[] brp;
  public final long brq;
  public final int minorVersion;
  
  public a(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, int paramInt3, boolean paramBoolean, a parama, b[] paramArrayOfb)
  {
    AppMethodBeat.i(89984);
    this.bjD = paramInt1;
    this.minorVersion = paramInt2;
    this.brn = paramInt3;
    this.bqS = paramBoolean;
    this.bro = parama;
    this.brp = paramArrayOfb;
    if (paramLong3 == 0L)
    {
      paramLong3 = -9223372036854775807L;
      this.brq = paramLong3;
      if (paramLong2 != 0L) {
        break label97;
      }
    }
    label97:
    for (paramLong1 = -9223372036854775807L;; paramLong1 = x.b(paramLong2, 1000000L, paramLong1))
    {
      this.aSz = paramLong1;
      AppMethodBeat.o(89984);
      return;
      paramLong3 = x.b(paramLong3, 1000000L, paramLong1);
      break;
    }
  }
  
  public static final class a
  {
    public final byte[] data;
    public final UUID uuid;
    
    public a(UUID paramUUID, byte[] paramArrayOfByte)
    {
      this.uuid = paramUUID;
      this.data = paramArrayOfByte;
    }
  }
  
  public static final class b
  {
    public final String aSt;
    public final int aYQ;
    public final int aYR;
    public final long bdm;
    public final Format[] blC;
    public final int bmP;
    public final String bqj;
    public final String brr;
    public final String brs;
    public final List<Long> brt;
    public final long[] bru;
    private final long brv;
    public final int maxHeight;
    public final int maxWidth;
    public final String name;
    public final int type;
    
    public b(String paramString1, String paramString2, int paramInt1, String paramString3, long paramLong1, String paramString4, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString5, Format[] paramArrayOfFormat, List<Long> paramList, long paramLong2)
    {
      AppMethodBeat.i(89982);
      this.bqj = paramString1;
      this.brs = paramString2;
      this.type = paramInt1;
      this.brr = paramString3;
      this.bdm = paramLong1;
      this.name = paramString4;
      this.maxWidth = paramInt2;
      this.maxHeight = paramInt3;
      this.aYQ = paramInt4;
      this.aYR = paramInt5;
      this.aSt = paramString5;
      this.blC = paramArrayOfFormat;
      this.bmP = paramList.size();
      this.brt = paramList;
      this.brv = x.b(paramLong2, 1000000L, paramLong1);
      this.bru = x.a(paramList, paramLong1);
      AppMethodBeat.o(89982);
    }
    
    public final int J(long paramLong)
    {
      AppMethodBeat.i(89983);
      int i = x.a(this.bru, paramLong, true);
      AppMethodBeat.o(89983);
      return i;
    }
    
    public final long eQ(int paramInt)
    {
      if (paramInt == this.bmP - 1) {
        return this.brv;
      }
      return this.bru[(paramInt + 1)] - this.bru[paramInt];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.c.a.a
 * JD-Core Version:    0.7.0.1
 */