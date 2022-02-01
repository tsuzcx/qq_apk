package com.tencent.mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.dj;
import com.tencent.mm.g.a.zh;
import com.tencent.mm.kernel.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class l
{
  Set<String> pLK;
  Set<String> pLL;
  Set<String> pLM;
  com.tencent.mm.sdk.b.c pLN;
  com.tencent.mm.sdk.b.c pLO;
  
  public l()
  {
    AppMethodBeat.i(108657);
    this.pLN = new com.tencent.mm.sdk.b.c() {};
    this.pLO = new com.tencent.mm.sdk.b.c() {};
    a.IvT.c(this.pLN);
    a.IvT.c(this.pLO);
    this.pLK = Collections.synchronizedSet(new HashSet());
    this.pLL = Collections.synchronizedSet(new HashSet());
    this.pLM = Collections.synchronizedSet(new HashSet());
    AppMethodBeat.o(108657);
  }
  
  final void cim()
  {
    AppMethodBeat.i(108658);
    for (;;)
    {
      if (this.pLL.isEmpty())
      {
        ae.i("MicroMsg.emoji.WearEmojiLogic", "no emoji need download");
        AppMethodBeat.o(108658);
        return;
      }
      if (!this.pLM.isEmpty())
      {
        ae.i("MicroMsg.emoji.WearEmojiLogic", "downloading emoji %s", new Object[] { this.pLM.toString() });
        AppMethodBeat.o(108658);
        return;
      }
      localObject = this.pLL.iterator();
      if (localObject == null) {
        break label198;
      }
      localObject = (String)((Iterator)localObject).next();
      this.pLL.remove(localObject);
      EmojiGroupInfo localEmojiGroupInfo = k.getEmojiStorageMgr().JfV.cN((String)localObject, true);
      if ((localEmojiGroupInfo == null) || ((localEmojiGroupInfo.field_flag & 0x100) <= 0)) {
        break;
      }
      ae.i("MicroMsg.emoji.WearEmojiLogic", "emoji already exist %s", new Object[] { localObject });
    }
    ae.i("MicroMsg.emoji.WearEmojiLogic", "start to download emoji %s", new Object[] { localObject });
    this.pLM.add(localObject);
    Object localObject = new com.tencent.mm.plugin.emoji.f.g((String)localObject, "");
    com.tencent.mm.kernel.g.ajQ().gDv.a((n)localObject, 0);
    label198:
    AppMethodBeat.o(108658);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.l
 * JD-Core Version:    0.7.0.1
 */