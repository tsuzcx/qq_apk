package com.tencent.mm.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.i;
import com.tencent.mm.protocal.protobuf.PersonalDesigner;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.aw.a;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.a.v;
import d.g.b.k;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/model/panel/StoreItemGroup;", "Lcom/tencent/mm/emoji/model/panel/AbsPanelItemGroup;", "groupInfo", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;)V", "emojiList", "", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "kotlin.jvm.PlatformType", "hasNew", "", "getHasNew", "()Z", "setHasNew", "(Z)V", "reportCount", "", "getReportCount", "plugin-emojisdk_release"})
public final class ah
  extends a
{
  public boolean fRT;
  private final List<EmojiInfo> fRk;
  private int fRl;
  
  public ah(EmojiGroupInfo paramEmojiGroupInfo)
  {
    super(paramEmojiGroupInfo);
    AppMethodBeat.i(105587);
    Object localObject1 = i.ach().tf(paramEmojiGroupInfo.fdm());
    if (localObject1 != null) {}
    for (localObject1 = (List)localObject1;; localObject1 = (List)v.KTF)
    {
      this.fRk = ((List)localObject1);
      this.fRl = this.fRk.size();
      paramEmojiGroupInfo = i.ach().tg(paramEmojiGroupInfo.fdm());
      Object localObject2;
      if (paramEmojiGroupInfo != null)
      {
        this.fRi.fRS = paramEmojiGroupInfo;
        localObject1 = this.fRi;
        localObject2 = aw.a.GXG;
        ((q)localObject1).fRT = aw.a.YJ(paramEmojiGroupInfo.DesignerUin).faX();
        this.fRT = this.fRi.fRT;
      }
      this.fRj.add(this.fRi);
      paramEmojiGroupInfo = ((Iterable)this.fRk).iterator();
      while (paramEmojiGroupInfo.hasNext())
      {
        localObject1 = (EmojiInfo)paramEmojiGroupInfo.next();
        localObject2 = this.fRj;
        k.g(localObject1, "it");
        ((LinkedList)localObject2).add(new h((EmojiInfo)localObject1, 2));
      }
    }
    AppMethodBeat.o(105587);
  }
  
  public final int acI()
  {
    return this.fRl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.a.a.ah
 * JD-Core Version:    0.7.0.1
 */