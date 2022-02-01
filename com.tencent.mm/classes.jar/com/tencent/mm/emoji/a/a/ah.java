package com.tencent.mm.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.PersonalDesigner;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.a.v;
import d.g.b.k;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/model/panel/StoreItemGroup;", "Lcom/tencent/mm/emoji/model/panel/AbsPanelItemGroup;", "groupInfo", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;)V", "emojiList", "", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "kotlin.jvm.PlatformType", "hasNew", "", "getHasNew", "()Z", "setHasNew", "(Z)V", "reportCount", "", "getReportCount", "plugin-emojisdk_release"})
public final class ah
  extends a
{
  private int fNA;
  private final List<EmojiInfo> fNz;
  public boolean fOi;
  
  public ah(EmojiGroupInfo paramEmojiGroupInfo)
  {
    super(paramEmojiGroupInfo);
    AppMethodBeat.i(105587);
    Object localObject1 = com.tencent.mm.emoji.a.h.abj().pU(paramEmojiGroupInfo.fZJ());
    if (localObject1 != null) {}
    for (localObject1 = (List)localObject1;; localObject1 = (List)v.Jgl)
    {
      this.fNz = ((List)localObject1);
      this.fNA = this.fNz.size();
      paramEmojiGroupInfo = com.tencent.mm.emoji.a.h.abj().pV(paramEmojiGroupInfo.fZJ());
      Object localObject2;
      if (paramEmojiGroupInfo != null)
      {
        this.fNx.fOh = paramEmojiGroupInfo;
        localObject1 = this.fNx;
        localObject2 = at.a.FyF;
        ((q)localObject1).fOi = at.a.Wz(paramEmojiGroupInfo.DesignerUin).eLv();
        this.fOi = this.fNx.fOi;
      }
      this.fNy.add(this.fNx);
      paramEmojiGroupInfo = ((Iterable)this.fNz).iterator();
      while (paramEmojiGroupInfo.hasNext())
      {
        localObject1 = (EmojiInfo)paramEmojiGroupInfo.next();
        localObject2 = this.fNy;
        k.g(localObject1, "it");
        ((LinkedList)localObject2).add(new h((EmojiInfo)localObject1, 2));
      }
    }
    AppMethodBeat.o(105587);
  }
  
  public final int abI()
  {
    return this.fNA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.a.a.ah
 * JD-Core Version:    0.7.0.1
 */