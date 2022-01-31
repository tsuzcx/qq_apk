package a.j.b.a.c.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public final class f
{
  private int Crm;
  private final byte[] buffer;
  private final int limit;
  private final OutputStream output;
  private int position;
  
  private f(OutputStream paramOutputStream, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(121450);
    this.Crm = 0;
    this.output = paramOutputStream;
    this.buffer = paramArrayOfByte;
    this.position = 0;
    this.limit = paramArrayOfByte.length;
    AppMethodBeat.o(121450);
  }
  
  public static int VJ(int paramInt)
  {
    return paramInt << 1 ^ paramInt >> 31;
  }
  
  public static int a(m paramm)
  {
    AppMethodBeat.i(121476);
    int i = paramm.sy();
    int j = eY(i);
    AppMethodBeat.o(121476);
    return i + j;
  }
  
  private void a(d paramd, int paramInt)
  {
    AppMethodBeat.i(121484);
    if (this.limit - this.position >= paramInt)
    {
      paramd.h(this.buffer, 0, this.position, paramInt);
      this.position += paramInt;
    }
    for (;;)
    {
      this.Crm += paramInt;
      AppMethodBeat.o(121484);
      return;
      int i = this.limit - this.position;
      paramd.h(this.buffer, 0, this.position, i);
      int j = i + 0;
      paramInt -= i;
      this.position = this.limit;
      this.Crm = (i + this.Crm);
      emA();
      if (paramInt <= this.limit)
      {
        paramd.h(this.buffer, j, 0, paramInt);
        this.position = paramInt;
      }
      else
      {
        paramd.a(this.output, j, paramInt);
      }
    }
  }
  
  public static int ap(long paramLong)
  {
    if ((0xFFFFFF80 & paramLong) == 0L) {
      return 1;
    }
    if ((0xFFFFC000 & paramLong) == 0L) {
      return 2;
    }
    if ((0xFFE00000 & paramLong) == 0L) {
      return 3;
    }
    if ((0xF0000000 & paramLong) == 0L) {
      return 4;
    }
    if ((0x0 & paramLong) == 0L) {
      return 5;
    }
    if ((0x0 & paramLong) == 0L) {
      return 6;
    }
    if ((0x0 & paramLong) == 0L) {
      return 7;
    }
    if ((0x0 & paramLong) == 0L) {
      return 8;
    }
    if ((0x0 & paramLong) == 0L) {
      return 9;
    }
    return 10;
  }
  
  public static int b(int paramInt, d paramd)
  {
    AppMethodBeat.i(121470);
    paramInt = eW(paramInt);
    int i = c(paramd);
    AppMethodBeat.o(121470);
    return paramInt + i;
  }
  
  public static int bf(String paramString)
  {
    AppMethodBeat.i(121474);
    try
    {
      paramString = paramString.getBytes("UTF-8");
      int i = eY(paramString.length);
      int j = paramString.length;
      AppMethodBeat.o(121474);
      return j + i;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString = new RuntimeException("UTF-8 not supported.", paramString);
      AppMethodBeat.o(121474);
      throw paramString;
    }
  }
  
  public static int bl(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(121468);
    paramInt1 = eW(paramInt1);
    paramInt2 = eU(paramInt2);
    AppMethodBeat.o(121468);
    return paramInt1 + paramInt2;
  }
  
  public static int c(int paramInt, q paramq)
  {
    AppMethodBeat.i(121469);
    paramInt = eW(paramInt);
    int i = c(paramq);
    AppMethodBeat.o(121469);
    return paramInt + i;
  }
  
  public static int c(d paramd)
  {
    AppMethodBeat.i(121477);
    int i = eY(paramd.size());
    int j = paramd.size();
    AppMethodBeat.o(121477);
    return i + j;
  }
  
  public static int c(q paramq)
  {
    AppMethodBeat.i(121475);
    int i = paramq.sy();
    int j = eY(i);
    AppMethodBeat.o(121475);
    return i + j;
  }
  
  public static int cD(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(121478);
    int i = eY(paramArrayOfByte.length);
    int j = paramArrayOfByte.length;
    AppMethodBeat.o(121478);
    return i + j;
  }
  
  private void d(byte paramByte)
  {
    AppMethodBeat.i(121481);
    if (this.position == this.limit) {
      emA();
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.position;
    this.position = (i + 1);
    arrayOfByte[i] = paramByte;
    this.Crm += 1;
    AppMethodBeat.o(121481);
  }
  
  public static f e(OutputStream paramOutputStream, int paramInt)
  {
    AppMethodBeat.i(121451);
    paramOutputStream = new f(paramOutputStream, new byte[paramInt]);
    AppMethodBeat.o(121451);
    return paramOutputStream;
  }
  
  public static int eU(int paramInt)
  {
    AppMethodBeat.i(121473);
    if (paramInt >= 0)
    {
      paramInt = eY(paramInt);
      AppMethodBeat.o(121473);
      return paramInt;
    }
    AppMethodBeat.o(121473);
    return 10;
  }
  
  public static int eW(int paramInt)
  {
    AppMethodBeat.i(121486);
    paramInt = eY(z.bo(paramInt, 0));
    AppMethodBeat.o(121486);
    return paramInt;
  }
  
  public static int eY(int paramInt)
  {
    if ((paramInt & 0xFFFFFF80) == 0) {
      return 1;
    }
    if ((paramInt & 0xFFFFC000) == 0) {
      return 2;
    }
    if ((0xFFE00000 & paramInt) == 0) {
      return 3;
    }
    if ((0xF0000000 & paramInt) == 0) {
      return 4;
    }
    return 5;
  }
  
  private void emA()
  {
    AppMethodBeat.i(121479);
    if (this.output == null)
    {
      f.a locala = new f.a();
      AppMethodBeat.o(121479);
      throw locala;
    }
    this.output.write(this.buffer, 0, this.position);
    this.position = 0;
    AppMethodBeat.o(121479);
  }
  
  public static int iH(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(121471);
    paramInt1 = eW(paramInt1);
    paramInt2 = eU(paramInt2);
    AppMethodBeat.o(121471);
    return paramInt1 + paramInt2;
  }
  
  private void n(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(121483);
    if (this.limit - this.position >= paramInt)
    {
      System.arraycopy(paramArrayOfByte, 0, this.buffer, this.position, paramInt);
      this.position += paramInt;
    }
    for (;;)
    {
      this.Crm += paramInt;
      AppMethodBeat.o(121483);
      return;
      int i = this.limit - this.position;
      System.arraycopy(paramArrayOfByte, 0, this.buffer, this.position, i);
      int j = i + 0;
      paramInt -= i;
      this.position = this.limit;
      this.Crm = (i + this.Crm);
      emA();
      if (paramInt <= this.limit)
      {
        System.arraycopy(paramArrayOfByte, j, this.buffer, 0, paramInt);
        this.position = paramInt;
      }
      else
      {
        this.output.write(paramArrayOfByte, j, paramInt);
      }
    }
  }
  
  public static int pr(long paramLong)
  {
    AppMethodBeat.i(121472);
    int i = eW(2);
    int j = ap(pt(paramLong));
    AppMethodBeat.o(121472);
    return i + j;
  }
  
  public static long pt(long paramLong)
  {
    return paramLong << 1 ^ paramLong >> 63;
  }
  
  public final void J(double paramDouble)
  {
    AppMethodBeat.i(121458);
    ps(Double.doubleToRawLongBits(paramDouble));
    AppMethodBeat.o(121458);
  }
  
  public final void VG(int paramInt)
  {
    AppMethodBeat.i(121460);
    if (paramInt >= 0)
    {
      eX(paramInt);
      AppMethodBeat.o(121460);
      return;
    }
    ao(paramInt);
    AppMethodBeat.o(121460);
  }
  
  public final void VH(int paramInt)
  {
    AppMethodBeat.i(121466);
    eX(VJ(paramInt));
    AppMethodBeat.o(121466);
  }
  
  public final void VI(int paramInt)
  {
    AppMethodBeat.i(121489);
    d((byte)(paramInt & 0xFF));
    d((byte)(paramInt >> 8 & 0xFF));
    d((byte)(paramInt >> 16 & 0xFF));
    d((byte)(paramInt >> 24 & 0xFF));
    AppMethodBeat.o(121489);
  }
  
  public final void a(int paramInt, d paramd)
  {
    AppMethodBeat.i(121455);
    bn(paramInt, 2);
    b(paramd);
    AppMethodBeat.o(121455);
  }
  
  public final void a(int paramInt, q paramq)
  {
    AppMethodBeat.i(121454);
    bn(paramInt, 2);
    b(paramq);
    AppMethodBeat.o(121454);
  }
  
  public final void ao(long paramLong)
  {
    AppMethodBeat.i(121488);
    for (;;)
    {
      if ((0xFFFFFF80 & paramLong) == 0L)
      {
        d((byte)(int)paramLong);
        AppMethodBeat.o(121488);
        return;
      }
      d((byte)((int)paramLong & 0x7F | 0x80));
      paramLong >>>= 7;
    }
  }
  
  public final void ayZ(String paramString)
  {
    AppMethodBeat.i(121462);
    paramString = paramString.getBytes("UTF-8");
    eX(paramString.length);
    n(paramString, paramString.length);
    AppMethodBeat.o(121462);
  }
  
  public final void b(int paramInt, q paramq)
  {
    AppMethodBeat.i(121457);
    bn(1, 3);
    bn(2, 0);
    eX(paramInt);
    a(3, paramq);
    bn(1, 4);
    AppMethodBeat.o(121457);
  }
  
  public final void b(d paramd)
  {
    AppMethodBeat.i(121464);
    eX(paramd.size());
    d(paramd);
    AppMethodBeat.o(121464);
  }
  
  public final void b(q paramq)
  {
    AppMethodBeat.i(121463);
    eX(paramq.sy());
    paramq.a(this);
    AppMethodBeat.o(121463);
  }
  
  public final void bH(float paramFloat)
  {
    AppMethodBeat.i(121459);
    VI(Float.floatToRawIntBits(paramFloat));
    AppMethodBeat.o(121459);
  }
  
  public final void bj(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(121452);
    bn(paramInt1, 0);
    VG(paramInt2);
    AppMethodBeat.o(121452);
  }
  
  public final void bn(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(121485);
    eX(z.bo(paramInt1, paramInt2));
    AppMethodBeat.o(121485);
  }
  
  public final void cC(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(121465);
    eX(paramArrayOfByte.length);
    n(paramArrayOfByte, paramArrayOfByte.length);
    AppMethodBeat.o(121465);
  }
  
  public final void d(d paramd)
  {
    AppMethodBeat.i(121482);
    a(paramd, paramd.size());
    AppMethodBeat.o(121482);
  }
  
  public final void eX(int paramInt)
  {
    AppMethodBeat.i(121487);
    for (;;)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        d((byte)paramInt);
        AppMethodBeat.o(121487);
        return;
      }
      d((byte)(paramInt & 0x7F | 0x80));
      paramInt >>>= 7;
    }
  }
  
  public final void flush()
  {
    AppMethodBeat.i(121480);
    if (this.output != null) {
      emA();
    }
    AppMethodBeat.o(121480);
  }
  
  public final void iG(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(121456);
    bn(paramInt1, 0);
    VG(paramInt2);
    AppMethodBeat.o(121456);
  }
  
  public final void pq(long paramLong)
  {
    AppMethodBeat.i(121467);
    ao(pt(paramLong));
    AppMethodBeat.o(121467);
  }
  
  public final void ps(long paramLong)
  {
    AppMethodBeat.i(121490);
    d((byte)((int)paramLong & 0xFF));
    d((byte)((int)(paramLong >> 8) & 0xFF));
    d((byte)((int)(paramLong >> 16) & 0xFF));
    d((byte)((int)(paramLong >> 24) & 0xFF));
    d((byte)((int)(paramLong >> 32) & 0xFF));
    d((byte)((int)(paramLong >> 40) & 0xFF));
    d((byte)((int)(paramLong >> 48) & 0xFF));
    d((byte)((int)(paramLong >> 56) & 0xFF));
    AppMethodBeat.o(121490);
  }
  
  public final void sw(boolean paramBoolean)
  {
    AppMethodBeat.i(121453);
    bn(3, 0);
    sx(paramBoolean);
    AppMethodBeat.o(121453);
  }
  
  public final void sx(boolean paramBoolean)
  {
    AppMethodBeat.i(121461);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      d((byte)i);
      AppMethodBeat.o(121461);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j.b.a.c.g.f
 * JD-Core Version:    0.7.0.1
 */