package com.tencent.mm.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.i;
import com.tencent.mm.protocal.protobuf.PersonalDesigner;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.ba.a;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.a.v;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/model/panel/StoreItemGroup;", "Lcom/tencent/mm/emoji/model/panel/AbsPanelItemGroup;", "groupInfo", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;)V", "emojiList", "", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "kotlin.jvm.PlatformType", "hasNew", "", "getHasNew", "()Z", "setHasNew", "(Z)V", "reportCount", "", "getReportCount", "plugin-emojisdk_release"})
public final class al
  extends a
{
  private final List<EmojiInfo> gkK;
  private int gkL;
  public boolean glx;
  
  public al(EmojiGroupInfo paramEmojiGroupInfo)
  {
    super(paramEmojiGroupInfo);
    AppMethodBeat.i(105587);
    Object localObject1 = i.aeL().vU(paramEmojiGroupInfo.fxi());
    if (localObject1 != null) {}
    for (localObject1 = (List)localObject1;; localObject1 = (List)v.MKE)
    {
      this.gkK = ((List)localObject1);
      this.gkL = this.gkK.size();
      paramEmojiGroupInfo = i.aeL().vV(paramEmojiGroupInfo.fxi());
      Object localObject2;
      if (paramEmojiGroupInfo != null)
      {
        this.gkI.glw = paramEmojiGroupInfo;
        localObject1 = this.gkI;
        localObject2 = ba.a.IKU;
        ((u)localObject1).glx = ba.a.aaS(paramEmojiGroupInfo.DesignerUin).fra();
        this.glx = this.gkI.glx;
      }
      this.gkJ.add(this.gkI);
      paramEmojiGroupInfo = ((Iterable)this.gkK).iterator();
      while (paramEmojiGroupInfo.hasNext())
      {
        localObject1 = (EmojiInfo)paramEmojiGroupInfo.next();
        localObject2 = this.gkJ;
        p.g(localObject1, "it");
        ((LinkedList)localObject2).add(new h((EmojiInfo)localObject1, 2));
      }
    }
    AppMethodBeat.o(105587);
  }
  
  public final int afm()
  {
    return this.gkL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.a.a.al
 * JD-Core Version:    0.7.0.1
 */