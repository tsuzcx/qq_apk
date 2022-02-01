package com.tencent.mm.emoji.loader.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfig;", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "url", "", "path", "authKey", "fetcherType", "", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getAuthKey", "()Ljava/lang/String;", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "getFetcherType", "()I", "getPath", "getUrl", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "plugin-emojisdk_release"})
public final class e
{
  final EmojiInfo glt;
  final String glu;
  final int glv;
  final String path;
  final String url;
  
  public e(EmojiInfo paramEmojiInfo, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(105431);
    this.glt = paramEmojiInfo;
    this.url = paramString1;
    this.path = paramString2;
    this.glu = paramString3;
    this.glv = paramInt;
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
        if ((!p.i(this.glt, paramObject.glt)) || (!p.i(this.url, paramObject.url)) || (!p.i(this.path, paramObject.path)) || (!p.i(this.glu, paramObject.glu)) || (this.glv != paramObject.glv)) {}
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
    Object localObject = this.glt;
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
      localObject = this.glu;
      if (localObject != null) {
        m = localObject.hashCode();
      }
      int n = this.glv;
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
    String str = "EmojiFetcherConfig(emojiInfo=" + this.glt + ", url=" + this.url + ", path=" + this.path + ", authKey=" + this.glu + ", fetcherType=" + this.glv + ")";
    AppMethodBeat.o(105432);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.c.e
 * JD-Core Version:    0.7.0.1
 */