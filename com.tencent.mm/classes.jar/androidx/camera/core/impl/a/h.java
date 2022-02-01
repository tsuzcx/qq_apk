package androidx.camera.core.impl.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class h
  extends FilterOutputStream
{
  private static final byte[] OM;
  private final g OO;
  private final byte[] OP;
  private final ByteBuffer OQ;
  private int OS;
  private int OT;
  private int mState;
  
  static
  {
    AppMethodBeat.i(199018);
    OM = "".getBytes(f.Oj);
    AppMethodBeat.o(199018);
  }
  
  public h(OutputStream paramOutputStream, g paramg)
  {
    super(new BufferedOutputStream(paramOutputStream, 65536));
    AppMethodBeat.i(198983);
    this.OP = new byte[1];
    this.OQ = ByteBuffer.allocate(4);
    this.mState = 0;
    this.OO = paramg;
    AppMethodBeat.o(198983);
  }
  
  private int a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(198991);
    paramInt1 = Math.min(paramInt3, paramInt1 - this.OQ.position());
    this.OQ.put(paramArrayOfByte, paramInt2, paramInt1);
    AppMethodBeat.o(198991);
    return paramInt1;
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(199011);
    int[] arrayOfInt = new int[g.Ow.length];
    Object localObject1 = new int[g.Ow.length];
    Object localObject2 = g.Ou;
    int k = localObject2.length;
    int i = 0;
    while (i < k)
    {
      Object localObject3 = localObject2[i];
      j = 0;
      while (j < g.Ow.length)
      {
        this.OO.aZ(j).remove(localObject3.name);
        j += 1;
      }
      i += 1;
    }
    if (!this.OO.aZ(1).isEmpty()) {
      this.OO.aZ(0).put(g.Ou[1].name, f.a(0L, this.OO.NZ));
    }
    if (!this.OO.aZ(2).isEmpty()) {
      this.OO.aZ(0).put(g.Ou[2].name, f.a(0L, this.OO.NZ));
    }
    if (!this.OO.aZ(3).isEmpty()) {
      this.OO.aZ(1).put(g.Ou[3].name, f.a(0L, this.OO.NZ));
    }
    int j = 0;
    if (j < g.Ow.length)
    {
      localObject2 = this.OO.aZ(j).entrySet().iterator();
      i = 0;
      label275:
      if (((Iterator)localObject2).hasNext())
      {
        k = ((f)((Map.Entry)((Iterator)localObject2).next()).getValue()).size();
        if (k <= 4) {
          break label1050;
        }
        i = k + i;
      }
    }
    label1037:
    label1050:
    for (;;)
    {
      break label275;
      localObject1[j] += i;
      j += 1;
      break;
      j = 8;
      i = 0;
      while (i < g.Ow.length)
      {
        k = j;
        if (!this.OO.aZ(i).isEmpty())
        {
          arrayOfInt[i] = j;
          k = j + (this.OO.aZ(i).size() * 12 + 2 + 4 + localObject1[i]);
        }
        i += 1;
        j = k;
      }
      if (!this.OO.aZ(1).isEmpty()) {
        this.OO.aZ(0).put(g.Ou[1].name, f.a(arrayOfInt[1], this.OO.NZ));
      }
      if (!this.OO.aZ(2).isEmpty()) {
        this.OO.aZ(0).put(g.Ou[2].name, f.a(arrayOfInt[2], this.OO.NZ));
      }
      if (!this.OO.aZ(3).isEmpty()) {
        this.OO.aZ(1).put(g.Ou[3].name, f.a(arrayOfInt[3], this.OO.NZ));
      }
      parama.b((short)(j + 8));
      parama.write(OM);
      short s;
      if (this.OO.NZ == ByteOrder.BIG_ENDIAN)
      {
        s = 19789;
        parama.b(s);
        parama.NZ = this.OO.NZ;
        parama.b((short)42);
        parama.aX(8);
        i = 0;
      }
      for (;;)
      {
        if (i >= g.Ow.length) {
          break label1037;
        }
        if (!this.OO.aZ(i).isEmpty())
        {
          parama.b((short)this.OO.aZ(i).size());
          j = arrayOfInt[i];
          k = this.OO.aZ(i).size();
          localObject1 = this.OO.aZ(i).entrySet().iterator();
          j = j + 2 + k * 12 + 4;
          for (;;)
          {
            if (!((Iterator)localObject1).hasNext()) {
              break label946;
            }
            localObject2 = (Map.Entry)((Iterator)localObject1).next();
            int m = ((i)androidx.core.f.f.checkNotNull((i)((HashMap)g.a.OE.get(i)).get(((Map.Entry)localObject2).getKey()), "Tag not supported: " + (String)((Map.Entry)localObject2).getKey() + ". Tag needs to be ported from ExifInterface to ExifData.")).number;
            localObject2 = (f)((Map.Entry)localObject2).getValue();
            k = ((f)localObject2).size();
            parama.b((short)m);
            parama.b((short)((f)localObject2).format);
            parama.aX(((f)localObject2).On);
            if (k > 4)
            {
              parama.aX((int)j);
              j += k;
              continue;
              s = 18761;
              break;
            }
            parama.write(((f)localObject2).Op);
            if (k < 4) {
              while (k < 4)
              {
                parama.NY.write(0);
                k += 1;
              }
            }
          }
          label946:
          parama.aX(0);
          localObject1 = this.OO.aZ(i).entrySet().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (f)((Map.Entry)((Iterator)localObject1).next()).getValue();
            if (((f)localObject2).Op.length > 4) {
              parama.write(((f)localObject2).Op, 0, ((f)localObject2).Op.length);
            }
          }
        }
        i += 1;
      }
      parama.NZ = ByteOrder.BIG_ENDIAN;
      AppMethodBeat.o(199011);
      return;
    }
  }
  
  public final void write(int paramInt)
  {
    AppMethodBeat.i(199044);
    this.OP[0] = ((byte)(paramInt & 0xFF));
    write(this.OP);
    AppMethodBeat.o(199044);
  }
  
  public final void write(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(199051);
    write(paramArrayOfByte, 0, paramArrayOfByte.length);
    AppMethodBeat.o(199051);
  }
  
  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(199034);
    while (((this.OS > 0) || (this.OT > 0) || (this.mState != 2)) && (paramInt2 > 0))
    {
      int i = paramInt1;
      int j = paramInt2;
      if (this.OS > 0)
      {
        i = Math.min(paramInt2, this.OS);
        j = paramInt2 - i;
        this.OS -= i;
        i = paramInt1 + i;
      }
      paramInt1 = i;
      paramInt2 = j;
      if (this.OT > 0)
      {
        paramInt1 = Math.min(j, this.OT);
        this.out.write(paramArrayOfByte, i, paramInt1);
        paramInt2 = j - paramInt1;
        this.OT -= paramInt1;
        paramInt1 = i + paramInt1;
      }
      if (paramInt2 == 0)
      {
        AppMethodBeat.o(199034);
        return;
      }
      switch (this.mState)
      {
      default: 
        break;
      case 0: 
        i = a(2, paramArrayOfByte, paramInt1, paramInt2);
        paramInt1 += i;
        paramInt2 -= i;
        if (this.OQ.position() < 2)
        {
          AppMethodBeat.o(199034);
          return;
        }
        this.OQ.rewind();
        if (this.OQ.getShort() != -40)
        {
          paramArrayOfByte = new IOException("Not a valid jpeg image, cannot write exif");
          AppMethodBeat.o(199034);
          throw paramArrayOfByte;
        }
        this.out.write(this.OQ.array(), 0, 2);
        this.mState = 1;
        this.OQ.rewind();
        a locala = new a(this.out, ByteOrder.BIG_ENDIAN);
        locala.b((short)-31);
        a(locala);
        break;
      case 1: 
        j = a(4, paramArrayOfByte, paramInt1, paramInt2);
        i = paramInt1 + j;
        paramInt2 -= j;
        if ((this.OQ.position() == 2) && (this.OQ.getShort() == -39))
        {
          this.out.write(this.OQ.array(), 0, 2);
          this.OQ.rewind();
        }
        if (this.OQ.position() < 4)
        {
          AppMethodBeat.o(199034);
          return;
        }
        this.OQ.rewind();
        paramInt1 = this.OQ.getShort();
        if (paramInt1 == -31)
        {
          this.OS = ((this.OQ.getShort() & 0xFFFF) - 2);
          this.mState = 2;
        }
        for (;;)
        {
          this.OQ.rewind();
          paramInt1 = i;
          break;
          if ((paramInt1 >= -64) && (paramInt1 <= -49) && (paramInt1 != -60) && (paramInt1 != -56) && (paramInt1 != -52)) {}
          for (paramInt1 = 1;; paramInt1 = 0)
          {
            if (paramInt1 != 0) {
              break label527;
            }
            this.out.write(this.OQ.array(), 0, 4);
            this.OT = ((this.OQ.getShort() & 0xFFFF) - 2);
            break;
          }
          label527:
          this.out.write(this.OQ.array(), 0, 4);
          this.mState = 2;
        }
      }
    }
    if (paramInt2 > 0) {
      this.out.write(paramArrayOfByte, paramInt1, paramInt2);
    }
    AppMethodBeat.o(199034);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.camera.core.impl.a.h
 * JD-Core Version:    0.7.0.1
 */