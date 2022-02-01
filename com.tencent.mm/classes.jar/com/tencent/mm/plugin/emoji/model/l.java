package com.tencent.mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.de;
import com.tencent.mm.g.a.xw;
import com.tencent.mm.kernel.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class l
{
  Set<String> oxW;
  Set<String> oxX;
  Set<String> oxY;
  com.tencent.mm.sdk.b.c oxZ;
  com.tencent.mm.sdk.b.c oya;
  
  public l()
  {
    AppMethodBeat.i(108657);
    this.oxZ = new com.tencent.mm.sdk.b.c() {};
    this.oya = new com.tencent.mm.sdk.b.c() {};
    a.ESL.c(this.oxZ);
    a.ESL.c(this.oya);
    this.oxW = Collections.synchronizedSet(new HashSet());
    this.oxX = Collections.synchronizedSet(new HashSet());
    this.oxY = Collections.synchronizedSet(new HashSet());
    AppMethodBeat.o(108657);
  }
  
  final void bVf()
  {
    AppMethodBeat.i(108658);
    for (;;)
    {
      if (this.oxX.isEmpty())
      {
        ad.i("MicroMsg.emoji.WearEmojiLogic", "no emoji need download");
        AppMethodBeat.o(108658);
        return;
      }
      if (!this.oxY.isEmpty())
      {
        ad.i("MicroMsg.emoji.WearEmojiLogic", "downloading emoji %s", new Object[] { this.oxY.toString() });
        AppMethodBeat.o(108658);
        return;
      }
      localObject = this.oxX.iterator();
      if (localObject == null) {
        break label198;
      }
      localObject = (String)((Iterator)localObject).next();
      this.oxX.remove(localObject);
      EmojiGroupInfo localEmojiGroupInfo = k.getEmojiStorageMgr().FyZ.cy((String)localObject, true);
      if ((localEmojiGroupInfo == null) || ((localEmojiGroupInfo.field_flag & 0x100) <= 0)) {
        break;
      }
      ad.i("MicroMsg.emoji.WearEmojiLogic", "emoji already exist %s", new Object[] { localObject });
    }
    ad.i("MicroMsg.emoji.WearEmojiLogic", "start to download emoji %s", new Object[] { localObject });
    this.oxY.add(localObject);
    Object localObject = new com.tencent.mm.plugin.emoji.f.g((String)localObject, "");
    com.tencent.mm.kernel.g.afA().gcy.a((n)localObject, 0);
    label198:
    AppMethodBeat.o(108658);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.l
 * JD-Core Version:    0.7.0.1
 */