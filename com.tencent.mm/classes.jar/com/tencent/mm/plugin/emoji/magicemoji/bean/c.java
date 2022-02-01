package com.tencent.mm.plugin.emoji.magicemoji.bean;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/magicemoji/bean/MagicEmojiPkgInfo;", "", "appId", "", "version", "", "(Ljava/lang/String;I)V", "getAppId", "()Ljava/lang/String;", "getVersion", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "plugin-magic-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public final String appId;
  public final int version;
  
  public c(String paramString, int paramInt)
  {
    AppMethodBeat.i(269942);
    this.appId = paramString;
    this.version = paramInt;
    AppMethodBeat.o(269942);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(269952);
    if (this == paramObject)
    {
      AppMethodBeat.o(269952);
      return true;
    }
    if (!(paramObject instanceof c))
    {
      AppMethodBeat.o(269952);
      return false;
    }
    paramObject = (c)paramObject;
    if (!s.p(this.appId, paramObject.appId))
    {
      AppMethodBeat.o(269952);
      return false;
    }
    if (this.version != paramObject.version)
    {
      AppMethodBeat.o(269952);
      return false;
    }
    AppMethodBeat.o(269952);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(269949);
    int i = this.appId.hashCode();
    int j = this.version;
    AppMethodBeat.o(269949);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(269945);
    String str = "MagicEmojiPkgInfo(appId=" + this.appId + ", version=" + this.version + ')';
    AppMethodBeat.o(269945);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.magicemoji.bean.c
 * JD-Core Version:    0.7.0.1
 */