package com.tencent.mm.plugin.emoji.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.k;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class a$1
  implements Runnable
{
  a$1(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(257456);
    Object localObject = k.aBH().aBL();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vDn, 20);
    Iterator localIterator = ((List)localObject).iterator();
    while (localIterator.hasNext())
    {
      EmojiGroupInfo localEmojiGroupInfo = (EmojiGroupInfo)localIterator.next();
      if ((localEmojiGroupInfo.field_sync != 2) && (!Util.isEqual(localEmojiGroupInfo.field_productID, String.valueOf(EmojiGroupInfo.YCu))))
      {
        if (Util.isEqual(localEmojiGroupInfo.field_productID, String.valueOf(EmojiGroupInfo.YCu))) {}
        for (localObject = new com.tencent.mm.plugin.emoji.h.a.b("com.tencent.xin.emoticon.tusiji");; localObject = new com.tencent.mm.plugin.emoji.h.a.a(localEmojiGroupInfo.field_productID))
        {
          if (localEmojiGroupInfo.field_idx >= i) {
            break label166;
          }
          localArrayList2.add(localObject);
          break;
        }
        label166:
        localArrayList1.add(localObject);
      }
    }
    this.uGz.uGy.cVm();
    this.uGz.uGy.di(localArrayList2);
    this.uGz.uGy.dh(localArrayList1);
    if (!this.uGz.uGy.uGJ) {
      this.uGz.uGy.cVn();
    }
    AppMethodBeat.o(257456);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.h.a.1
 * JD-Core Version:    0.7.0.1
 */