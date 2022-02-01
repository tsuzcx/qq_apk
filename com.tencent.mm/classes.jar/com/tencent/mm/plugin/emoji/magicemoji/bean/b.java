package com.tencent.mm.plugin.emoji.magicemoji.bean;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/magicemoji/bean/MagicEmojiEggMeta;", "", "eggKey", "", "eggId", "sceneId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEggId", "()Ljava/lang/String;", "getEggKey", "getSceneId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "plugin-magic-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final a xHZ;
  private static final b xId;
  public final String xIa;
  public final String xIb;
  public final String xIc;
  
  static
  {
    AppMethodBeat.i(269950);
    xHZ = new a((byte)0);
    xId = new b("", "", "");
    AppMethodBeat.o(269950);
  }
  
  public b(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(269943);
    this.xIa = paramString1;
    this.xIb = paramString2;
    this.xIc = paramString3;
    AppMethodBeat.o(269943);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(269963);
    if (this == paramObject)
    {
      AppMethodBeat.o(269963);
      return true;
    }
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(269963);
      return false;
    }
    paramObject = (b)paramObject;
    if (!s.p(this.xIa, paramObject.xIa))
    {
      AppMethodBeat.o(269963);
      return false;
    }
    if (!s.p(this.xIb, paramObject.xIb))
    {
      AppMethodBeat.o(269963);
      return false;
    }
    if (!s.p(this.xIc, paramObject.xIc))
    {
      AppMethodBeat.o(269963);
      return false;
    }
    AppMethodBeat.o(269963);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(269958);
    int i = this.xIa.hashCode();
    int j = this.xIb.hashCode();
    int k = this.xIc.hashCode();
    AppMethodBeat.o(269958);
    return (i * 31 + j) * 31 + k;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(269954);
    String str = "MagicEmojiEggMeta(eggKey=" + this.xIa + ", eggId=" + this.xIb + ", sceneId=" + this.xIc + ')';
    AppMethodBeat.o(269954);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/magicemoji/bean/MagicEmojiEggMeta$Companion;", "", "()V", "NONE", "Lcom/tencent/mm/plugin/emoji/magicemoji/bean/MagicEmojiEggMeta;", "getNONE", "()Lcom/tencent/mm/plugin/emoji/magicemoji/bean/MagicEmojiEggMeta;", "plugin-magic-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.magicemoji.bean.b
 * JD-Core Version:    0.7.0.1
 */