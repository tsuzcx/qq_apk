package com.tencent.mm.emoji.loader.c;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiInfo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfig;", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "url", "", "path", "authKey", "fetcherType", "", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getAuthKey", "()Ljava/lang/String;", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "getFetcherType", "()I", "getPath", "getUrl", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "plugin-emojisdk_release"})
public final class d
{
  final EmojiInfo evH;
  final String evI;
  final int evJ;
  final String path;
  final String url;
  
  public d(EmojiInfo paramEmojiInfo, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(63181);
    this.evH = paramEmojiInfo;
    this.url = paramString1;
    this.path = paramString2;
    this.evI = paramString3;
    this.evJ = paramInt;
    AppMethodBeat.o(63181);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(63184);
    if (this != paramObject)
    {
      if (!(paramObject instanceof d)) {
        break label107;
      }
      paramObject = (d)paramObject;
      if ((!j.e(this.evH, paramObject.evH)) || (!j.e(this.url, paramObject.url)) || (!j.e(this.path, paramObject.path)) || (!j.e(this.evI, paramObject.evI))) {
        break label107;
      }
      if (this.evJ != paramObject.evJ) {
        break label102;
      }
    }
    label102:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(63184);
      return true;
    }
    label107:
    AppMethodBeat.o(63184);
    return false;
  }
  
  public final int hashCode()
  {
    int m = 0;
    AppMethodBeat.i(63183);
    Object localObject = this.evH;
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
      localObject = this.evI;
      if (localObject != null) {
        m = localObject.hashCode();
      }
      int n = this.evJ;
      AppMethodBeat.o(63183);
      return ((k + (j + i * 31) * 31) * 31 + m) * 31 + n;
      i = 0;
      break;
      j = 0;
      break label42;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(63182);
    String str = "EmojiFetcherConfig(emojiInfo=" + this.evH + ", url=" + this.url + ", path=" + this.path + ", authKey=" + this.evI + ", fetcherType=" + this.evJ + ")";
    AppMethodBeat.o(63182);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.c.d
 * JD-Core Version:    0.7.0.1
 */