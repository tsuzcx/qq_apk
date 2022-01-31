package com.tencent.mm.emoji.loader.f;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiInfo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/emoji/loader/verify/EmojiVerifyConfig;", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "verifyMd5", "", "needDecrypt", "", "aesKey", "path", "tempPath", "fetcherType", "", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getAesKey", "()Ljava/lang/String;", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "getFetcherType", "()I", "getNeedDecrypt", "()Z", "getPath", "getTempPath", "getVerifyMd5", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "plugin-emojisdk_release"})
public final class b
{
  final EmojiInfo evH;
  final int evJ;
  final String ewh;
  final boolean ewi;
  final String ewj;
  final String ewk;
  final String path;
  
  public b(EmojiInfo paramEmojiInfo, String paramString1, boolean paramBoolean, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    AppMethodBeat.i(63231);
    this.evH = paramEmojiInfo;
    this.ewh = paramString1;
    this.ewi = paramBoolean;
    this.ewj = paramString2;
    this.path = paramString3;
    this.ewk = paramString4;
    this.evJ = paramInt;
    AppMethodBeat.o(63231);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(63234);
    if (this != paramObject)
    {
      if (!(paramObject instanceof b)) {
        break label143;
      }
      paramObject = (b)paramObject;
      if ((!j.e(this.evH, paramObject.evH)) || (!j.e(this.ewh, paramObject.ewh))) {
        break label143;
      }
      if (this.ewi != paramObject.ewi) {
        break label133;
      }
      i = 1;
      if ((i == 0) || (!j.e(this.ewj, paramObject.ewj)) || (!j.e(this.path, paramObject.path)) || (!j.e(this.ewk, paramObject.ewk))) {
        break label143;
      }
      if (this.evJ != paramObject.evJ) {
        break label138;
      }
    }
    label133:
    label138:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label143;
      }
      AppMethodBeat.o(63234);
      return true;
      i = 0;
      break;
    }
    label143:
    AppMethodBeat.o(63234);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(63232);
    String str = "EmojiVerifyConfig(emojiInfo=" + this.evH + ", verifyMd5=" + this.ewh + ", needDecrypt=" + this.ewi + ", aesKey=" + this.ewj + ", path=" + this.path + ", tempPath=" + this.ewk + ", fetcherType=" + this.evJ + ")";
    AppMethodBeat.o(63232);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.f.b
 * JD-Core Version:    0.7.0.1
 */