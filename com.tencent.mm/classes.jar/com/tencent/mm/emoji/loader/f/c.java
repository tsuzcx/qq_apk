package com.tencent.mm.emoji.loader.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.loader.c.i;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/loader/verify/EmojiVerifyFactory;", "", "()V", "createVerifyConfig", "Lcom/tencent/mm/emoji/loader/verify/EmojiVerifyConfig;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "verify", "", "plugin-emojisdk_release"})
public final class c
{
  public static final c jHR;
  
  static
  {
    AppMethodBeat.i(105492);
    jHR = new c();
    AppMethodBeat.o(105492);
  }
  
  public static boolean k(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105491);
    p.k(paramEmojiInfo, "emojiInfo");
    a locala = new a();
    p.k(paramEmojiInfo, "emojiInfo");
    Object localObject1 = paramEmojiInfo.getMd5();
    String str2 = paramEmojiInfo.ifh() + "_temp";
    int i;
    boolean bool;
    if (i.i(paramEmojiInfo))
    {
      localObject1 = paramEmojiInfo.field_externMd5;
      i = 2;
      bool = true;
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "";
      }
      Object localObject3 = paramEmojiInfo.field_aeskey;
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = "";
      }
      String str1 = paramEmojiInfo.ifh();
      localObject3 = str1;
      if (str1 == null) {
        localObject3 = "";
      }
      bool = locala.a(new b(paramEmojiInfo, (String)localObject2, bool, (String)localObject1, (String)localObject3, str2, i));
      AppMethodBeat.o(105491);
      return bool;
      if (i.j(paramEmojiInfo))
      {
        i = 1;
        bool = true;
      }
      else if (i.h(paramEmojiInfo))
      {
        i = 3;
        bool = true;
      }
      else
      {
        i = 0;
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.f.c
 * JD-Core Version:    0.7.0.1
 */