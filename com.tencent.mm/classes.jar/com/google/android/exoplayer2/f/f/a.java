package com.google.android.exoplayer2.f.f;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.f.d;
import com.google.android.exoplayer2.f.f;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.charset.Charset;
import java.util.List;

public final class a
  extends com.google.android.exoplayer2.f.b
{
  private static final int bsQ;
  private static final int bsR;
  private final m bsS;
  private boolean bsT;
  private int bsU;
  private int bsV;
  private String bsW;
  private float bsX;
  private int bsY;
  
  static
  {
    AppMethodBeat.i(92870);
    bsQ = x.aQ("styl");
    bsR = x.aQ("tbox");
    AppMethodBeat.o(92870);
  }
  
  public a(List<byte[]> paramList)
  {
    super("Tx3gDecoder");
    AppMethodBeat.i(92865);
    this.bsS = new m();
    if ((paramList != null) && (paramList.size() == 1) && ((((byte[])paramList.get(0)).length == 48) || (((byte[])paramList.get(0)).length == 53)))
    {
      byte[] arrayOfByte = (byte[])paramList.get(0);
      this.bsU = arrayOfByte[24];
      this.bsV = ((arrayOfByte[26] & 0xFF) << 24 | (arrayOfByte[27] & 0xFF) << 16 | (arrayOfByte[28] & 0xFF) << 8 | arrayOfByte[29] & 0xFF);
      if ("Serif".equals(new String(arrayOfByte, 43, arrayOfByte.length - 43)))
      {
        paramList = "serif";
        this.bsW = paramList;
        this.bsY = (arrayOfByte[25] * 20);
        if ((arrayOfByte[0] & 0x20) == 0) {
          break label271;
        }
      }
      label271:
      for (boolean bool = true;; bool = false)
      {
        this.bsT = bool;
        if (!this.bsT) {
          break label276;
        }
        int i = arrayOfByte[10];
        this.bsX = ((arrayOfByte[11] & 0xFF | (i & 0xFF) << 8) / this.bsY);
        this.bsX = x.i(this.bsX, 0.0F, 0.95F);
        AppMethodBeat.o(92865);
        return;
        paramList = "sans-serif";
        break;
      }
      label276:
      this.bsX = 0.85F;
      AppMethodBeat.o(92865);
      return;
    }
    this.bsU = 0;
    this.bsV = -1;
    this.bsW = "sans-serif";
    this.bsT = false;
    this.bsX = 0.85F;
    AppMethodBeat.o(92865);
  }
  
  private static void a(SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int i = 1;
    AppMethodBeat.i(92867);
    int j;
    if (paramInt1 != paramInt2)
    {
      j = paramInt5 | 0x21;
      if ((paramInt1 & 0x1) == 0) {
        break label128;
      }
      paramInt2 = 1;
      if ((paramInt1 & 0x2) == 0) {
        break label133;
      }
      paramInt5 = 1;
      label37:
      if (paramInt2 == 0) {
        break label159;
      }
      if (paramInt5 == 0) {
        break label139;
      }
      paramSpannableStringBuilder.setSpan(new StyleSpan(3), paramInt3, paramInt4, j);
      label63:
      if ((paramInt1 & 0x4) == 0) {
        break label184;
      }
    }
    label128:
    label133:
    label139:
    label159:
    label184:
    for (paramInt1 = i;; paramInt1 = 0)
    {
      if (paramInt1 != 0) {
        paramSpannableStringBuilder.setSpan(new UnderlineSpan(), paramInt3, paramInt4, j);
      }
      if ((paramInt1 == 0) && (paramInt2 == 0) && (paramInt5 == 0)) {
        paramSpannableStringBuilder.setSpan(new StyleSpan(0), paramInt3, paramInt4, j);
      }
      AppMethodBeat.o(92867);
      return;
      paramInt2 = 0;
      break;
      paramInt5 = 0;
      break label37;
      paramSpannableStringBuilder.setSpan(new StyleSpan(1), paramInt3, paramInt4, j);
      break label63;
      if (paramInt5 == 0) {
        break label63;
      }
      paramSpannableStringBuilder.setSpan(new StyleSpan(2), paramInt3, paramInt4, j);
      break label63;
    }
  }
  
  private static void assertTrue(boolean paramBoolean)
  {
    AppMethodBeat.i(92869);
    if (!paramBoolean)
    {
      f localf = new f("Unexpected subtitle format.");
      AppMethodBeat.o(92869);
      throw localf;
    }
    AppMethodBeat.o(92869);
  }
  
  private static void b(SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(92868);
    if (paramInt1 != paramInt2) {
      paramSpannableStringBuilder.setSpan(new ForegroundColorSpan((paramInt1 & 0xFF) << 24 | paramInt1 >>> 8), paramInt3, paramInt4, paramInt5 | 0x21);
    }
    AppMethodBeat.o(92868);
  }
  
  public final d b(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(92866);
    this.bsS.n(paramArrayOfByte, paramInt);
    paramArrayOfByte = this.bsS;
    if (paramArrayOfByte.vy() >= 2)
    {
      paramBoolean = true;
      assertTrue(paramBoolean);
      paramInt = paramArrayOfByte.readUnsignedShort();
      if (paramInt != 0) {
        break label68;
      }
      paramArrayOfByte = "";
    }
    label68:
    int i;
    for (;;)
    {
      if (!paramArrayOfByte.isEmpty()) {
        break label153;
      }
      paramArrayOfByte = b.bsZ;
      AppMethodBeat.o(92866);
      return paramArrayOfByte;
      paramBoolean = false;
      break;
      if (paramArrayOfByte.vy() >= 2)
      {
        i = (char)((paramArrayOfByte.data[paramArrayOfByte.position] & 0xFF) << 8 | paramArrayOfByte.data[(paramArrayOfByte.position + 1)] & 0xFF);
        if ((i == 65279) || (i == 65534))
        {
          paramArrayOfByte = paramArrayOfByte.a(paramInt, Charset.forName("UTF-16"));
          continue;
        }
      }
      paramArrayOfByte = paramArrayOfByte.a(paramInt, Charset.forName("UTF-8"));
    }
    label153:
    paramArrayOfByte = new SpannableStringBuilder(paramArrayOfByte);
    a(paramArrayOfByte, this.bsU, 0, 0, paramArrayOfByte.length(), 16711680);
    b(paramArrayOfByte, this.bsV, -1, 0, paramArrayOfByte.length(), 16711680);
    Object localObject = this.bsW;
    paramInt = paramArrayOfByte.length();
    if (localObject != "sans-serif") {
      paramArrayOfByte.setSpan(new TypefaceSpan((String)localObject), 0, paramInt, 16711713);
    }
    float f = this.bsX;
    int j;
    if (this.bsS.vy() >= 8)
    {
      i = this.bsS.position;
      j = this.bsS.readInt();
      paramInt = this.bsS.readInt();
      if (paramInt == bsQ)
      {
        if (this.bsS.vy() >= 2)
        {
          paramBoolean = true;
          assertTrue(paramBoolean);
          int k = this.bsS.readUnsignedShort();
          paramInt = 0;
          label308:
          if (paramInt >= k) {
            break label423;
          }
          localObject = this.bsS;
          if (((m)localObject).vy() < 12) {
            break label418;
          }
        }
        label418:
        for (paramBoolean = true;; paramBoolean = false)
        {
          assertTrue(paramBoolean);
          int m = ((m)localObject).readUnsignedShort();
          int n = ((m)localObject).readUnsignedShort();
          ((m)localObject).eX(2);
          int i1 = ((m)localObject).readUnsignedByte();
          ((m)localObject).eX(1);
          int i2 = ((m)localObject).readInt();
          a(paramArrayOfByte, i1, this.bsU, m, n, 0);
          b(paramArrayOfByte, i2, this.bsV, m, n, 0);
          paramInt += 1;
          break label308;
          paramBoolean = false;
          break;
        }
      }
    }
    for (;;)
    {
      label423:
      this.bsS.setPosition(i + j);
      break;
      if ((paramInt == bsR) && (this.bsT))
      {
        if (this.bsS.vy() >= 2) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          assertTrue(paramBoolean);
          f = x.i(this.bsS.readUnsignedShort() / this.bsY, 0.0F, 0.95F);
          break;
        }
        paramArrayOfByte = new b(new com.google.android.exoplayer2.f.a(paramArrayOfByte, null, f, 0, 0, 1.4E-45F, -2147483648, 1.4E-45F));
        AppMethodBeat.o(92866);
        return paramArrayOfByte;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.f.f.a
 * JD-Core Version:    0.7.0.1
 */