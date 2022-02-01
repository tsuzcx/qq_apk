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
  private static final int dgF;
  private static final int dgG;
  private final m dgH;
  private boolean dgI;
  private int dgJ;
  private int dgK;
  private String dgL;
  private float dgM;
  private int dgN;
  
  static
  {
    AppMethodBeat.i(92870);
    dgF = x.du("styl");
    dgG = x.du("tbox");
    AppMethodBeat.o(92870);
  }
  
  public a(List<byte[]> paramList)
  {
    super("Tx3gDecoder");
    AppMethodBeat.i(92865);
    this.dgH = new m();
    if ((paramList != null) && (paramList.size() == 1) && ((((byte[])paramList.get(0)).length == 48) || (((byte[])paramList.get(0)).length == 53)))
    {
      byte[] arrayOfByte = (byte[])paramList.get(0);
      this.dgJ = arrayOfByte[24];
      this.dgK = ((arrayOfByte[26] & 0xFF) << 24 | (arrayOfByte[27] & 0xFF) << 16 | (arrayOfByte[28] & 0xFF) << 8 | arrayOfByte[29] & 0xFF);
      if ("Serif".equals(new String(arrayOfByte, 43, arrayOfByte.length - 43)))
      {
        paramList = "serif";
        this.dgL = paramList;
        this.dgN = (arrayOfByte[25] * 20);
        if ((arrayOfByte[0] & 0x20) == 0) {
          break label271;
        }
      }
      label271:
      for (boolean bool = true;; bool = false)
      {
        this.dgI = bool;
        if (!this.dgI) {
          break label276;
        }
        int i = arrayOfByte[10];
        this.dgM = ((arrayOfByte[11] & 0xFF | (i & 0xFF) << 8) / this.dgN);
        this.dgM = x.l(this.dgM, 0.0F, 0.95F);
        AppMethodBeat.o(92865);
        return;
        paramList = "sans-serif";
        break;
      }
      label276:
      this.dgM = 0.85F;
      AppMethodBeat.o(92865);
      return;
    }
    this.dgJ = 0;
    this.dgK = -1;
    this.dgL = "sans-serif";
    this.dgI = false;
    this.dgM = 0.85F;
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
    this.dgH.n(paramArrayOfByte, paramInt);
    paramArrayOfByte = this.dgH;
    if (paramArrayOfByte.UF() >= 2)
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
      paramArrayOfByte = b.dgO;
      AppMethodBeat.o(92866);
      return paramArrayOfByte;
      paramBoolean = false;
      break;
      if (paramArrayOfByte.UF() >= 2)
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
    a(paramArrayOfByte, this.dgJ, 0, 0, paramArrayOfByte.length(), 16711680);
    b(paramArrayOfByte, this.dgK, -1, 0, paramArrayOfByte.length(), 16711680);
    Object localObject = this.dgL;
    paramInt = paramArrayOfByte.length();
    if (localObject != "sans-serif") {
      paramArrayOfByte.setSpan(new TypefaceSpan((String)localObject), 0, paramInt, 16711713);
    }
    float f = this.dgM;
    int j;
    if (this.dgH.UF() >= 8)
    {
      i = this.dgH.position;
      j = this.dgH.readInt();
      paramInt = this.dgH.readInt();
      if (paramInt == dgF)
      {
        if (this.dgH.UF() >= 2)
        {
          paramBoolean = true;
          assertTrue(paramBoolean);
          int k = this.dgH.readUnsignedShort();
          paramInt = 0;
          label308:
          if (paramInt >= k) {
            break label423;
          }
          localObject = this.dgH;
          if (((m)localObject).UF() < 12) {
            break label418;
          }
        }
        label418:
        for (paramBoolean = true;; paramBoolean = false)
        {
          assertTrue(paramBoolean);
          int m = ((m)localObject).readUnsignedShort();
          int n = ((m)localObject).readUnsignedShort();
          ((m)localObject).iH(2);
          int i1 = ((m)localObject).readUnsignedByte();
          ((m)localObject).iH(1);
          int i2 = ((m)localObject).readInt();
          a(paramArrayOfByte, i1, this.dgJ, m, n, 0);
          b(paramArrayOfByte, i2, this.dgK, m, n, 0);
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
      this.dgH.setPosition(i + j);
      break;
      if ((paramInt == dgG) && (this.dgI))
      {
        if (this.dgH.UF() >= 2) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          assertTrue(paramBoolean);
          f = x.l(this.dgH.readUnsignedShort() / this.dgN, 0.0F, 0.95F);
          break;
        }
        paramArrayOfByte = new b(new com.google.android.exoplayer2.f.a(paramArrayOfByte, null, f, 0, 0, 1.4E-45F, -2147483648, 1.4E-45F));
        AppMethodBeat.o(92866);
        return paramArrayOfByte;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.f.f.a
 * JD-Core Version:    0.7.0.1
 */