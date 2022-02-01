package com.tencent.mm.emoji.loader.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/loader/verify/EmojiVerifyConfig;", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "verifyMd5", "", "needDecrypt", "", "aesKey", "path", "tempPath", "fetcherType", "", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getAesKey", "()Ljava/lang/String;", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "getFetcherType", "()I", "getNeedDecrypt", "()Z", "getPath", "getTempPath", "getVerifyMd5", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "plugin-emojisdk_release"})
public final class b
{
  final String gjG;
  final boolean gjH;
  final String gjI;
  final String gjJ;
  final EmojiInfo gjb;
  final int gjd;
  final String path;
  
  public b(EmojiInfo paramEmojiInfo, String paramString1, boolean paramBoolean, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    AppMethodBeat.i(105487);
    this.gjb = paramEmojiInfo;
    this.gjG = paramString1;
    this.gjH = paramBoolean;
    this.gjI = paramString2;
    this.path = paramString3;
    this.gjJ = paramString4;
    this.gjd = paramInt;
    AppMethodBeat.o(105487);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(105490);
    if (this != paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((!p.i(this.gjb, paramObject.gjb)) || (!p.i(this.gjG, paramObject.gjG)) || (this.gjH != paramObject.gjH) || (!p.i(this.gjI, paramObject.gjI)) || (!p.i(this.path, paramObject.path)) || (!p.i(this.gjJ, paramObject.gjJ)) || (this.gjd != paramObject.gjd)) {}
      }
    }
    else
    {
      AppMethodBeat.o(105490);
      return true;
    }
    AppMethodBeat.o(105490);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(105488);
    String str = "EmojiVerifyConfig(emojiInfo=" + this.gjb + ", verifyMd5=" + this.gjG + ", needDecrypt=" + this.gjH + ", aesKey=" + this.gjI + ", path=" + this.path + ", tempPath=" + this.gjJ + ", fetcherType=" + this.gjd + ")";
    AppMethodBeat.o(105488);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.f.b
 * JD-Core Version:    0.7.0.1
 */