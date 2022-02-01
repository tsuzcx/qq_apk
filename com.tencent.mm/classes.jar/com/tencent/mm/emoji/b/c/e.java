package com.tencent.mm.emoji.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfig;", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "url", "", "path", "authKey", "fetcherType", "", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getAuthKey", "()Ljava/lang/String;", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "getFetcherType", "()I", "getPath", "getUrl", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  final String authKey;
  final EmojiInfo mgK;
  final int mgL;
  final String path;
  final String url;
  
  public e(EmojiInfo paramEmojiInfo, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(105431);
    this.mgK = paramEmojiInfo;
    this.url = paramString1;
    this.path = paramString2;
    this.authKey = paramString3;
    this.mgL = paramInt;
    AppMethodBeat.o(105431);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(105434);
    if (this == paramObject)
    {
      AppMethodBeat.o(105434);
      return true;
    }
    if (!(paramObject instanceof e))
    {
      AppMethodBeat.o(105434);
      return false;
    }
    paramObject = (e)paramObject;
    if (!s.p(this.mgK, paramObject.mgK))
    {
      AppMethodBeat.o(105434);
      return false;
    }
    if (!s.p(this.url, paramObject.url))
    {
      AppMethodBeat.o(105434);
      return false;
    }
    if (!s.p(this.path, paramObject.path))
    {
      AppMethodBeat.o(105434);
      return false;
    }
    if (!s.p(this.authKey, paramObject.authKey))
    {
      AppMethodBeat.o(105434);
      return false;
    }
    if (this.mgL != paramObject.mgL)
    {
      AppMethodBeat.o(105434);
      return false;
    }
    AppMethodBeat.o(105434);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(105433);
    int i = this.mgK.hashCode();
    int j = this.url.hashCode();
    int k = this.path.hashCode();
    int m = this.authKey.hashCode();
    int n = this.mgL;
    AppMethodBeat.o(105433);
    return (((i * 31 + j) * 31 + k) * 31 + m) * 31 + n;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(105432);
    String str = "EmojiFetcherConfig(emojiInfo=" + this.mgK + ", url=" + this.url + ", path=" + this.path + ", authKey=" + this.authKey + ", fetcherType=" + this.mgL + ')';
    AppMethodBeat.o(105432);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.b.c.e
 * JD-Core Version:    0.7.0.1
 */