package com.tencent.mm.plugin.emoji.model;

import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.f.h;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class j
{
  Set<String> iYP;
  Set<String> iYQ;
  Set<String> iYR;
  c iYS = new j.1(this);
  c iYT = new j.2(this);
  
  public j()
  {
    com.tencent.mm.sdk.b.a.udP.c(this.iYS);
    com.tencent.mm.sdk.b.a.udP.c(this.iYT);
    this.iYP = Collections.synchronizedSet(new HashSet());
    this.iYQ = Collections.synchronizedSet(new HashSet());
    this.iYR = Collections.synchronizedSet(new HashSet());
  }
  
  final void aHW()
  {
    for (;;)
    {
      if (this.iYQ.isEmpty()) {
        y.i("MicroMsg.emoji.WearEmojiLogic", "no emoji need download");
      }
      do
      {
        return;
        if (!this.iYR.isEmpty())
        {
          y.i("MicroMsg.emoji.WearEmojiLogic", "downloading emoji %s", new Object[] { this.iYR.toString() });
          return;
        }
        localObject = this.iYQ.iterator();
      } while (localObject == null);
      localObject = (String)((Iterator)localObject).next();
      this.iYQ.remove(localObject);
      EmojiGroupInfo localEmojiGroupInfo = i.getEmojiStorageMgr().uBc.bE((String)localObject, true);
      if ((localEmojiGroupInfo == null) || ((localEmojiGroupInfo.field_flag & 0x100) <= 0)) {
        break;
      }
      y.i("MicroMsg.emoji.WearEmojiLogic", "emoji already exist %s", new Object[] { localObject });
    }
    y.i("MicroMsg.emoji.WearEmojiLogic", "start to download emoji %s", new Object[] { localObject });
    this.iYR.add(localObject);
    Object localObject = new h((String)localObject, "");
    g.DO().dJT.a((m)localObject, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.j
 * JD-Core Version:    0.7.0.1
 */