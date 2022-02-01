package com.tencent.mm.emoji.b.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/loader/verify/EmojiVerifyConfig;", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "verifyMd5", "", "needDecrypt", "", "aesKey", "path", "tempPath", "fetcherType", "", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getAesKey", "()Ljava/lang/String;", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "getFetcherType", "()I", "getNeedDecrypt", "()Z", "getPath", "getTempPath", "getVerifyMd5", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  final String aesKey;
  final EmojiInfo mgK;
  final int mgL;
  final String mhv;
  final boolean mhw;
  final String mhx;
  final String path;
  
  public b(EmojiInfo paramEmojiInfo, String paramString1, boolean paramBoolean, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    AppMethodBeat.i(105487);
    this.mgK = paramEmojiInfo;
    this.mhv = paramString1;
    this.mhw = paramBoolean;
    this.aesKey = paramString2;
    this.path = paramString3;
    this.mhx = paramString4;
    this.mgL = paramInt;
    AppMethodBeat.o(105487);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(105490);
    if (this == paramObject)
    {
      AppMethodBeat.o(105490);
      return true;
    }
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(105490);
      return false;
    }
    paramObject = (b)paramObject;
    if (!s.p(this.mgK, paramObject.mgK))
    {
      AppMethodBeat.o(105490);
      return false;
    }
    if (!s.p(this.mhv, paramObject.mhv))
    {
      AppMethodBeat.o(105490);
      return false;
    }
    if (this.mhw != paramObject.mhw)
    {
      AppMethodBeat.o(105490);
      return false;
    }
    if (!s.p(this.aesKey, paramObject.aesKey))
    {
      AppMethodBeat.o(105490);
      return false;
    }
    if (!s.p(this.path, paramObject.path))
    {
      AppMethodBeat.o(105490);
      return false;
    }
    if (!s.p(this.mhx, paramObject.mhx))
    {
      AppMethodBeat.o(105490);
      return false;
    }
    if (this.mgL != paramObject.mgL)
    {
      AppMethodBeat.o(105490);
      return false;
    }
    AppMethodBeat.o(105490);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(105488);
    String str = "EmojiVerifyConfig(emojiInfo=" + this.mgK + ", verifyMd5=" + this.mhv + ", needDecrypt=" + this.mhw + ", aesKey=" + this.aesKey + ", path=" + this.path + ", tempPath=" + this.mhx + ", fetcherType=" + this.mgL + ')';
    AppMethodBeat.o(105488);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.b.f.b
 * JD-Core Version:    0.7.0.1
 */