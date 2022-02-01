package com.tencent.mm.media.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/codec/MediaCodecAACCodec$EncoderData;", "", "data", "", "pts", "", "isEnd", "", "([BJZ)V", "getData", "()[B", "()Z", "getPts", "()J", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$a
{
  final byte[] data;
  final boolean nxG;
  final long pts;
  
  public a$a(byte[] paramArrayOfByte, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(93468);
    this.data = paramArrayOfByte;
    this.pts = paramLong;
    this.nxG = paramBoolean;
    AppMethodBeat.o(93468);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(93471);
    if (this == paramObject)
    {
      AppMethodBeat.o(93471);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(93471);
      return false;
    }
    paramObject = (a)paramObject;
    if (!s.p(this.data, paramObject.data))
    {
      AppMethodBeat.o(93471);
      return false;
    }
    if (this.pts != paramObject.pts)
    {
      AppMethodBeat.o(93471);
      return false;
    }
    if (this.nxG != paramObject.nxG)
    {
      AppMethodBeat.o(93471);
      return false;
    }
    AppMethodBeat.o(93471);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(93469);
    String str = "EncoderData(data=" + Arrays.toString(this.data) + ", pts=" + this.pts + ", isEnd=" + this.nxG + ')';
    AppMethodBeat.o(93469);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.media.a.a.a
 * JD-Core Version:    0.7.0.1
 */