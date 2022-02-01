package com.tencent.mm.emoji.loader.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfig;", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "url", "", "path", "authKey", "fetcherType", "", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getAuthKey", "()Ljava/lang/String;", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "getFetcherType", "()I", "getPath", "getUrl", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "plugin-emojisdk_release"})
public final class e
{
  final EmojiInfo gjb;
  final String gjc;
  final int gjd;
  final String path;
  final String url;
  
  public e(EmojiInfo paramEmojiInfo, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(105431);
    this.gjb = paramEmojiInfo;
    this.url = paramString1;
    this.path = paramString2;
    this.gjc = paramString3;
    this.gjd = paramInt;
    AppMethodBeat.o(105431);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(105434);
    if (this != paramObject)
    {
      if ((paramObject instanceof e))
      {
        paramObject = (e)paramObject;
        if ((!p.i(this.gjb, paramObject.gjb)) || (!p.i(this.url, paramObject.url)) || (!p.i(this.path, paramObject.path)) || (!p.i(this.gjc, paramObject.gjc)) || (this.gjd != paramObject.gjd)) {}
      }
    }
    else
    {
      AppMethodBeat.o(105434);
      return true;
    }
    AppMethodBeat.o(105434);
    return false;
  }
  
  public final int hashCode()
  {
    int m = 0;
    AppMethodBeat.i(105433);
    Object localObject = this.gjb;
    int i;
    int j;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.url;
      if (localObject == null) {
        break label117;
      }
      j = localObject.hashCode();
      label42:
      localObject = this.path;
      if (localObject == null) {
        break label122;
      }
    }
    label117:
    label122:
    for (int k = localObject.hashCode();; k = 0)
    {
      localObject = this.gjc;
      if (localObject != null) {
        m = localObject.hashCode();
      }
      int n = this.gjd;
      AppMethodBeat.o(105433);
      return ((k + (j + i * 31) * 31) * 31 + m) * 31 + n;
      i = 0;
      break;
      j = 0;
      break label42;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(105432);
    String str = "EmojiFetcherConfig(emojiInfo=" + this.gjb + ", url=" + this.url + ", path=" + this.path + ", authKey=" + this.gjc + ", fetcherType=" + this.gjd + ")";
    AppMethodBeat.o(105432);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.c.e
 * JD-Core Version:    0.7.0.1
 */