package com.tencent.mm.emoji.b.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.c.h;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/loader/verify/EmojiVerifyFactory;", "", "()V", "createVerifyConfig", "Lcom/tencent/mm/emoji/loader/verify/EmojiVerifyConfig;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "verify", "", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c mhy;
  
  static
  {
    AppMethodBeat.i(105492);
    mhy = new c();
    AppMethodBeat.o(105492);
  }
  
  public static boolean j(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105491);
    s.u(paramEmojiInfo, "emojiInfo");
    a locala = new a();
    s.u(paramEmojiInfo, "emojiInfo");
    Object localObject1 = paramEmojiInfo.getMd5();
    String str2 = s.X(paramEmojiInfo.kMn(), "_temp");
    int i;
    boolean bool;
    if (h.h(paramEmojiInfo))
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
      String str1 = paramEmojiInfo.kMn();
      localObject3 = str1;
      if (str1 == null) {
        localObject3 = "";
      }
      bool = locala.a(new b(paramEmojiInfo, (String)localObject2, bool, (String)localObject1, (String)localObject3, str2, i));
      AppMethodBeat.o(105491);
      return bool;
      if (h.i(paramEmojiInfo))
      {
        i = 1;
        bool = true;
      }
      else if (h.g(paramEmojiInfo))
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
 * Qualified Name:     com.tencent.mm.emoji.b.f.c
 * JD-Core Version:    0.7.0.1
 */