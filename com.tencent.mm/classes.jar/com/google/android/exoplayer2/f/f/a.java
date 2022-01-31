package com.google.android.exoplayer2.f.f;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.f.d;
import com.google.android.exoplayer2.f.f;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.t;
import java.nio.charset.Charset;
import java.util.List;

public final class a
  extends com.google.android.exoplayer2.f.b
{
  private static final int aPu = t.aG("styl");
  private static final int aPv = t.aG("tbox");
  private String aPA;
  private float aPB;
  private int aPC;
  private final j aPw = new j();
  private boolean aPx;
  private int aPy;
  private int aPz;
  
  public a(List<byte[]> paramList)
  {
    super("Tx3gDecoder");
    if ((paramList != null) && (paramList.size() == 1) && ((((byte[])paramList.get(0)).length == 48) || (((byte[])paramList.get(0)).length == 53)))
    {
      byte[] arrayOfByte = (byte[])paramList.get(0);
      this.aPy = arrayOfByte[24];
      this.aPz = ((arrayOfByte[26] & 0xFF) << 24 | (arrayOfByte[27] & 0xFF) << 16 | (arrayOfByte[28] & 0xFF) << 8 | arrayOfByte[29] & 0xFF);
      if ("Serif".equals(new String(arrayOfByte, 43, arrayOfByte.length - 43)))
      {
        paramList = "serif";
        this.aPA = paramList;
        this.aPC = (arrayOfByte[25] * 20);
        if ((arrayOfByte[0] & 0x20) == 0) {
          break label261;
        }
      }
      label261:
      for (boolean bool = true;; bool = false)
      {
        this.aPx = bool;
        if (!this.aPx) {
          break label266;
        }
        int i = arrayOfByte[10];
        this.aPB = ((arrayOfByte[11] & 0xFF | (i & 0xFF) << 8) / this.aPC);
        this.aPB = t.h(this.aPB, 0.0F, 0.95F);
        return;
        paramList = "sans-serif";
        break;
      }
      label266:
      this.aPB = 0.85F;
      return;
    }
    this.aPy = 0;
    this.aPz = -1;
    this.aPA = "sans-serif";
    this.aPx = false;
    this.aPB = 0.85F;
  }
  
  private static void a(SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int i = 1;
    int j;
    if (paramInt1 != paramInt2)
    {
      j = paramInt5 | 0x21;
      if ((paramInt1 & 0x1) == 0) {
        break label118;
      }
      paramInt2 = 1;
      if ((paramInt1 & 0x2) == 0) {
        break label123;
      }
      paramInt5 = 1;
      label32:
      if (paramInt2 == 0) {
        break label149;
      }
      if (paramInt5 == 0) {
        break label129;
      }
      paramSpannableStringBuilder.setSpan(new StyleSpan(3), paramInt3, paramInt4, j);
      label58:
      if ((paramInt1 & 0x4) == 0) {
        break label174;
      }
    }
    label129:
    label149:
    label174:
    for (paramInt1 = i;; paramInt1 = 0)
    {
      if (paramInt1 != 0) {
        paramSpannableStringBuilder.setSpan(new UnderlineSpan(), paramInt3, paramInt4, j);
      }
      if ((paramInt1 == 0) && (paramInt2 == 0) && (paramInt5 == 0)) {
        paramSpannableStringBuilder.setSpan(new StyleSpan(0), paramInt3, paramInt4, j);
      }
      return;
      label118:
      paramInt2 = 0;
      break;
      label123:
      paramInt5 = 0;
      break label32;
      paramSpannableStringBuilder.setSpan(new StyleSpan(1), paramInt3, paramInt4, j);
      break label58;
      if (paramInt5 == 0) {
        break label58;
      }
      paramSpannableStringBuilder.setSpan(new StyleSpan(2), paramInt3, paramInt4, j);
      break label58;
    }
  }
  
  private static void assertTrue(boolean paramBoolean)
  {
    if (!paramBoolean) {
      throw new f("Unexpected subtitle format.");
    }
  }
  
  private static void b(SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramInt1 != paramInt2) {
      paramSpannableStringBuilder.setSpan(new ForegroundColorSpan((paramInt1 & 0xFF) << 24 | paramInt1 >>> 8), paramInt3, paramInt4, paramInt5 | 0x21);
    }
  }
  
  protected final d b(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    this.aPw.m(paramArrayOfByte, paramInt);
    paramArrayOfByte = this.aPw;
    if (paramArrayOfByte.oe() >= 2)
    {
      paramBoolean = true;
      assertTrue(paramBoolean);
      paramInt = paramArrayOfByte.readUnsignedShort();
      if (paramInt != 0) {
        break label56;
      }
      paramArrayOfByte = "";
    }
    label56:
    int i;
    for (;;)
    {
      if (!paramArrayOfByte.isEmpty()) {
        break label141;
      }
      return b.aPD;
      paramBoolean = false;
      break;
      if (paramArrayOfByte.oe() >= 2)
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
    label141:
    paramArrayOfByte = new SpannableStringBuilder(paramArrayOfByte);
    a(paramArrayOfByte, this.aPy, 0, 0, paramArrayOfByte.length(), 16711680);
    b(paramArrayOfByte, this.aPz, -1, 0, paramArrayOfByte.length(), 16711680);
    Object localObject = this.aPA;
    paramInt = paramArrayOfByte.length();
    if (localObject != "sans-serif") {
      paramArrayOfByte.setSpan(new TypefaceSpan((String)localObject), 0, paramInt, 16711713);
    }
    float f = this.aPB;
    int j;
    if (this.aPw.oe() >= 8)
    {
      i = this.aPw.position;
      j = this.aPw.readInt();
      paramInt = this.aPw.readInt();
      if (paramInt == aPu)
      {
        if (this.aPw.oe() >= 2)
        {
          paramBoolean = true;
          assertTrue(paramBoolean);
          int k = this.aPw.readUnsignedShort();
          paramInt = 0;
          label296:
          if (paramInt >= k) {
            break label411;
          }
          localObject = this.aPw;
          if (((j)localObject).oe() < 12) {
            break label406;
          }
        }
        label406:
        for (paramBoolean = true;; paramBoolean = false)
        {
          assertTrue(paramBoolean);
          int m = ((j)localObject).readUnsignedShort();
          int n = ((j)localObject).readUnsignedShort();
          ((j)localObject).dB(2);
          int i1 = ((j)localObject).readUnsignedByte();
          ((j)localObject).dB(1);
          int i2 = ((j)localObject).readInt();
          a(paramArrayOfByte, i1, this.aPy, m, n, 0);
          b(paramArrayOfByte, i2, this.aPz, m, n, 0);
          paramInt += 1;
          break label296;
          paramBoolean = false;
          break;
        }
      }
    }
    for (;;)
    {
      label411:
      this.aPw.setPosition(i + j);
      break;
      if ((paramInt == aPv) && (this.aPx))
      {
        if (this.aPw.oe() >= 2) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          assertTrue(paramBoolean);
          f = t.h(this.aPw.readUnsignedShort() / this.aPC, 0.0F, 0.95F);
          break;
        }
        return new b(new com.google.android.exoplayer2.f.a(paramArrayOfByte, null, f, 0, 0, 1.4E-45F, -2147483648, 1.4E-45F));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.f.f.a
 * JD-Core Version:    0.7.0.1
 */