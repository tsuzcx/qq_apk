package com.tencent.mm.emoji.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.k;
import com.tencent.mm.protocal.protobuf.dkv;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bg.a;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/model/panel/StoreItemGroup;", "Lcom/tencent/mm/emoji/model/panel/AbsPanelItemGroup;", "groupInfo", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "empty", "", "(Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;Z)V", "emojiList", "", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "hasNew", "getHasNew", "()Z", "setHasNew", "(Z)V", "isDownloaded", "reportCount", "", "getDataCount", "plugin-emojisdk_release"})
public final class an
  extends a
{
  private final List<EmojiInfo> jIX;
  private int jIY;
  public boolean jJN;
  
  public an(EmojiGroupInfo paramEmojiGroupInfo, boolean paramBoolean)
  {
    super(paramEmojiGroupInfo);
    AppMethodBeat.i(223405);
    if (!aCE())
    {
      this.jIX = ((List)kotlin.a.v.aaAd);
      this.jIW.add(new v(paramEmojiGroupInfo));
      AppMethodBeat.o(223405);
      return;
    }
    if (paramBoolean)
    {
      this.jIX = ((List)kotlin.a.v.aaAd);
      this.jIY = this.jIX.size();
      paramEmojiGroupInfo = ((Iterable)this.jIX).iterator();
      while (paramEmojiGroupInfo.hasNext())
      {
        localObject = (EmojiInfo)paramEmojiGroupInfo.next();
        this.jIW.add(new h((EmojiInfo)localObject, 2));
      }
    }
    Object localObject = k.aBH().LJ(paramEmojiGroupInfo.hBl());
    if (localObject != null) {}
    for (localObject = (List)localObject;; localObject = (List)kotlin.a.v.aaAd)
    {
      this.jIX = ((List)localObject);
      paramEmojiGroupInfo = k.aBH().LK(paramEmojiGroupInfo.hBl());
      if (paramEmojiGroupInfo != null)
      {
        aCh().jJM = paramEmojiGroupInfo;
        localObject = aCh();
        bg.a locala = bg.a.VFn;
        ((w)localObject).jJN = bg.a.asF(paramEmojiGroupInfo.TdG).hyT();
        this.jJN = aCh().jJN;
      }
      this.jIW.add(aCh());
      break;
    }
    AppMethodBeat.o(223405);
  }
  
  public final boolean aCE()
  {
    AppMethodBeat.i(223394);
    if ((aCh().jGw.field_sync == 2) || (Util.isEqual(aCh().jGw.field_productID, String.valueOf(EmojiGroupInfo.YCu))))
    {
      AppMethodBeat.o(223394);
      return true;
    }
    AppMethodBeat.o(223394);
    return false;
  }
  
  public final int getDataCount()
  {
    return this.jIY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.b.b.an
 * JD-Core Version:    0.7.0.1
 */