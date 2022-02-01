package com.tencent.mm.emoji.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.i;
import com.tencent.mm.protocal.protobuf.PersonalDesigner;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bb.a;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.a.v;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/model/panel/StoreItemGroup;", "Lcom/tencent/mm/emoji/model/panel/AbsPanelItemGroup;", "groupInfo", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;)V", "emojiList", "", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "kotlin.jvm.PlatformType", "hasNew", "", "getHasNew", "()Z", "setHasNew", "(Z)V", "reportCount", "", "getReportCount", "plugin-emojisdk_release"})
public final class al
  extends a
{
  public boolean gnS;
  private final List<EmojiInfo> gnf;
  private int gng;
  
  public al(EmojiGroupInfo paramEmojiGroupInfo)
  {
    super(paramEmojiGroupInfo);
    AppMethodBeat.i(105587);
    Object localObject1 = i.aeX().wB(paramEmojiGroupInfo.fxk());
    if (localObject1 != null) {}
    for (localObject1 = (List)localObject1;; localObject1 = (List)v.NhH)
    {
      this.gnf = ((List)localObject1);
      this.gng = this.gnf.size();
      paramEmojiGroupInfo = i.aeX().wC(paramEmojiGroupInfo.fxk());
      Object localObject2;
      if (paramEmojiGroupInfo != null)
      {
        this.gnd.gnR = paramEmojiGroupInfo;
        localObject1 = this.gnd;
        localObject2 = bb.a.JfB;
        ((u)localObject1).gnS = bb.a.abA(paramEmojiGroupInfo.DesignerUin).fva();
        this.gnS = this.gnd.gnS;
      }
      this.gne.add(this.gnd);
      paramEmojiGroupInfo = ((Iterable)this.gnf).iterator();
      while (paramEmojiGroupInfo.hasNext())
      {
        localObject1 = (EmojiInfo)paramEmojiGroupInfo.next();
        localObject2 = this.gne;
        p.g(localObject1, "it");
        ((LinkedList)localObject2).add(new h((EmojiInfo)localObject1, 2));
      }
    }
    AppMethodBeat.o(105587);
  }
  
  public final int afA()
  {
    return this.gng;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.a.b.al
 * JD-Core Version:    0.7.0.1
 */