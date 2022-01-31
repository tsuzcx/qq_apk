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
  private static final int aWO;
  private static final int aWP;
  private final m aWQ;
  private boolean aWR;
  private int aWS;
  private int aWT;
  private String aWU;
  private float aWV;
  private int aWW;
  
  static
  {
    AppMethodBeat.i(95702);
    aWO = x.aS("styl");
    aWP = x.aS("tbox");
    AppMethodBeat.o(95702);
  }
  
  public a(List<byte[]> paramList)
  {
    super("Tx3gDecoder");
    AppMethodBeat.i(95697);
    this.aWQ = new m();
    if ((paramList != null) && (paramList.size() == 1) && ((((byte[])paramList.get(0)).length == 48) || (((byte[])paramList.get(0)).length == 53)))
    {
      byte[] arrayOfByte = (byte[])paramList.get(0);
      this.aWS = arrayOfByte[24];
      this.aWT = ((arrayOfByte[26] & 0xFF) << 24 | (arrayOfByte[27] & 0xFF) << 16 | (arrayOfByte[28] & 0xFF) << 8 | arrayOfByte[29] & 0xFF);
      if ("Serif".equals(new String(arrayOfByte, 43, arrayOfByte.length - 43)))
      {
        paramList = "serif";
        this.aWU = paramList;
        this.aWW = (arrayOfByte[25] * 20);
        if ((arrayOfByte[0] & 0x20) == 0) {
          break label271;
        }
      }
      label271:
      for (boolean bool = true;; bool = false)
      {
        this.aWR = bool;
        if (!this.aWR) {
          break label276;
        }
        int i = arrayOfByte[10];
        this.aWV = ((arrayOfByte[11] & 0xFF | (i & 0xFF) << 8) / this.aWW);
        this.aWV = x.h(this.aWV, 0.0F, 0.95F);
        AppMethodBeat.o(95697);
        return;
        paramList = "sans-serif";
        break;
      }
      label276:
      this.aWV = 0.85F;
      AppMethodBeat.o(95697);
      return;
    }
    this.aWS = 0;
    this.aWT = -1;
    this.aWU = "sans-serif";
    this.aWR = false;
    this.aWV = 0.85F;
    AppMethodBeat.o(95697);
  }
  
  private static void a(SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int i = 1;
    AppMethodBeat.i(95699);
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
      AppMethodBeat.o(95699);
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
    AppMethodBeat.i(95701);
    if (!paramBoolean)
    {
      f localf = new f("Unexpected subtitle format.");
      AppMethodBeat.o(95701);
      throw localf;
    }
    AppMethodBeat.o(95701);
  }
  
  private static void b(SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(95700);
    if (paramInt1 != paramInt2) {
      paramSpannableStringBuilder.setSpan(new ForegroundColorSpan((paramInt1 & 0xFF) << 24 | paramInt1 >>> 8), paramInt3, paramInt4, paramInt5 | 0x21);
    }
    AppMethodBeat.o(95700);
  }
  
  public final d c(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(95698);
    this.aWQ.l(paramArrayOfByte, paramInt);
    paramArrayOfByte = this.aWQ;
    if (paramArrayOfByte.qM() >= 2)
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
      paramArrayOfByte = b.aWX;
      AppMethodBeat.o(95698);
      return paramArrayOfByte;
      paramBoolean = false;
      break;
      if (paramArrayOfByte.qM() >= 2)
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
    a(paramArrayOfByte, this.aWS, 0, 0, paramArrayOfByte.length(), 16711680);
    b(paramArrayOfByte, this.aWT, -1, 0, paramArrayOfByte.length(), 16711680);
    Object localObject = this.aWU;
    paramInt = paramArrayOfByte.length();
    if (localObject != "sans-serif") {
      paramArrayOfByte.setSpan(new TypefaceSpan((String)localObject), 0, paramInt, 16711713);
    }
    float f = this.aWV;
    int j;
    if (this.aWQ.qM() >= 8)
    {
      i = this.aWQ.position;
      j = this.aWQ.readInt();
      paramInt = this.aWQ.readInt();
      if (paramInt == aWO)
      {
        if (this.aWQ.qM() >= 2)
        {
          paramBoolean = true;
          assertTrue(paramBoolean);
          int k = this.aWQ.readUnsignedShort();
          paramInt = 0;
          label308:
          if (paramInt >= k) {
            break label423;
          }
          localObject = this.aWQ;
          if (((m)localObject).qM() < 12) {
            break label418;
          }
        }
        label418:
        for (paramBoolean = true;; paramBoolean = false)
        {
          assertTrue(paramBoolean);
          int m = ((m)localObject).readUnsignedShort();
          int n = ((m)localObject).readUnsignedShort();
          ((m)localObject).en(2);
          int i1 = ((m)localObject).readUnsignedByte();
          ((m)localObject).en(1);
          int i2 = ((m)localObject).readInt();
          a(paramArrayOfByte, i1, this.aWS, m, n, 0);
          b(paramArrayOfByte, i2, this.aWT, m, n, 0);
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
      this.aWQ.setPosition(i + j);
      break;
      if ((paramInt == aWP) && (this.aWR))
      {
        if (this.aWQ.qM() >= 2) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          assertTrue(paramBoolean);
          f = x.h(this.aWQ.readUnsignedShort() / this.aWW, 0.0F, 0.95F);
          break;
        }
        paramArrayOfByte = new b(new com.google.android.exoplayer2.f.a(paramArrayOfByte, null, f, 0, 0, 1.4E-45F, -2147483648, 1.4E-45F));
        AppMethodBeat.o(95698);
        return paramArrayOfByte;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.f.f.a
 * JD-Core Version:    0.7.0.1
 */