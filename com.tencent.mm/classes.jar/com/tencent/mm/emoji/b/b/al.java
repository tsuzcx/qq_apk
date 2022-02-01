package com.tencent.mm.emoji.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.j;
import com.tencent.mm.protocal.protobuf.PersonalDesigner;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bg.a;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.v;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/model/panel/StoreItemGroup;", "Lcom/tencent/mm/emoji/model/panel/AbsPanelItemGroup;", "groupInfo", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "empty", "", "(Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;Z)V", "emojiList", "", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "hasNew", "getHasNew", "()Z", "setHasNew", "(Z)V", "reportCount", "", "getReportCount", "plugin-emojisdk_release"})
public final class al
  extends a
{
  private final List<EmojiInfo> gXX;
  private int gXY;
  public boolean gYN;
  
  public al(EmojiGroupInfo paramEmojiGroupInfo, boolean paramBoolean)
  {
    super(paramEmojiGroupInfo);
    AppMethodBeat.i(199929);
    Object localObject;
    if (paramBoolean) {
      localObject = (List)v.SXr;
    }
    for (;;)
    {
      this.gXX = ((List)localObject);
      this.gXY = this.gXX.size();
      paramEmojiGroupInfo = j.auL().ER(paramEmojiGroupInfo.hRu());
      if (paramEmojiGroupInfo != null)
      {
        this.gXV.gYM = paramEmojiGroupInfo;
        localObject = this.gXV;
        bg.a locala = bg.a.Opu;
        ((u)localObject).gYN = bg.a.aki(paramEmojiGroupInfo.DesignerUin).gCH();
        this.gYN = this.gXV.gYN;
      }
      this.gXW.add(this.gXV);
      paramEmojiGroupInfo = ((Iterable)this.gXX).iterator();
      while (paramEmojiGroupInfo.hasNext())
      {
        localObject = (EmojiInfo)paramEmojiGroupInfo.next();
        this.gXW.add(new h((EmojiInfo)localObject, 2));
      }
      localObject = j.auL().EQ(paramEmojiGroupInfo.hRu());
      if (localObject != null) {
        localObject = (List)localObject;
      } else {
        localObject = (List)v.SXr;
      }
    }
    AppMethodBeat.o(199929);
  }
  
  public final int avo()
  {
    return this.gXY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.b.b.al
 * JD-Core Version:    0.7.0.1
 */