package com.tencent.mm.media.d;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/encoder/MediaCodecAACEncoderAsync$EncoderData;", "", "pcmData", "", "pts", "", "isLast", "", "([BJZ)V", "()Z", "setLast", "(Z)V", "getPcmData", "()[B", "setPcmData", "([B)V", "getPts", "()J", "setPts", "(J)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "plugin-mediaeditor_release"})
public final class d$b
{
  byte[] cem;
  boolean eUx;
  long pts;
  
  public d$b(byte[] paramArrayOfByte, long paramLong, boolean paramBoolean)
  {
    this.cem = paramArrayOfByte;
    this.pts = paramLong;
    this.eUx = paramBoolean;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(12937);
    if (this != paramObject)
    {
      if (!(paramObject instanceof b)) {
        break label90;
      }
      paramObject = (b)paramObject;
      if (!j.e(this.cem, paramObject.cem)) {
        break label90;
      }
      if (this.pts != paramObject.pts) {
        break label80;
      }
      i = 1;
      if (i == 0) {
        break label90;
      }
      if (this.eUx != paramObject.eUx) {
        break label85;
      }
    }
    label80:
    label85:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label90;
      }
      AppMethodBeat.o(12937);
      return true;
      i = 0;
      break;
    }
    label90:
    AppMethodBeat.o(12937);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(12935);
    String str = "EncoderData(pcmData=" + Arrays.toString(this.cem) + ", pts=" + this.pts + ", isLast=" + this.eUx + ")";
    AppMethodBeat.o(12935);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.d.d.b
 * JD-Core Version:    0.7.0.1
 */