package com.tencent.mm.emoji.loader.f;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.loader.c.h;
import com.tencent.mm.storage.emotion.EmojiInfo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/emoji/loader/verify/EmojiVerifyFactory;", "", "()V", "createVerifyConfig", "Lcom/tencent/mm/emoji/loader/verify/EmojiVerifyConfig;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "verify", "", "plugin-emojisdk_release"})
public final class c
{
  public static final c ewl;
  
  static
  {
    AppMethodBeat.i(63236);
    ewl = new c();
    AppMethodBeat.o(63236);
  }
  
  public static boolean i(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(63235);
    j.q(paramEmojiInfo, "emojiInfo");
    a locala = new a();
    j.q(paramEmojiInfo, "emojiInfo");
    Object localObject1 = paramEmojiInfo.Al();
    String str2 = paramEmojiInfo.dQB() + "_temp";
    int i;
    boolean bool;
    if (h.f(paramEmojiInfo))
    {
      i = 3;
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
      String str1 = paramEmojiInfo.dQB();
      localObject3 = str1;
      if (str1 == null) {
        localObject3 = "";
      }
      bool = locala.a(new b(paramEmojiInfo, (String)localObject2, bool, (String)localObject1, (String)localObject3, str2, i));
      AppMethodBeat.o(63235);
      return bool;
      if (h.g(paramEmojiInfo))
      {
        localObject1 = paramEmojiInfo.field_externMd5;
        i = 2;
        bool = true;
      }
      else if (h.h(paramEmojiInfo))
      {
        i = 1;
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