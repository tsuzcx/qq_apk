package com.tencent.mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.EmotionBanner;
import com.tencent.mm.protocal.protobuf.EmotionBannerSet;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.ArrayList;
import java.util.List;

public final class f
{
  public int pEi;
  public List<com.tencent.mm.plugin.emoji.a.a.f> pEj;
  public EmotionBanner pEk;
  public List<EmotionBanner> pEl;
  public List<EmotionBannerSet> pEm;
  public List<EmotionBannerSet> pEn;
  
  public final void Ca(int paramInt)
  {
    this.pEi += paramInt;
  }
  
  public final void cO(List<com.tencent.mm.plugin.emoji.a.a.f> paramList)
  {
    AppMethodBeat.i(108588);
    if (this.pEj == null) {
      this.pEj = new ArrayList();
    }
    for (;;)
    {
      this.pEj.addAll(paramList);
      AppMethodBeat.o(108588);
      return;
      int i = this.pEj.size() - 1;
      if ((i >= 0) && (i < this.pEj.size()))
      {
        com.tencent.mm.plugin.emoji.a.a.f localf = (com.tencent.mm.plugin.emoji.a.a.f)this.pEj.get(i);
        if ((localf != null) && (localf.pBV != null) && (!bt.isNullOrNil(localf.pBV.ProductID)) && (localf.pBV.ProductID.equals(EmojiGroupInfo.OeK))) {
          this.pEj.remove(localf);
        }
      }
    }
  }
  
  public final void cgK()
  {
    AppMethodBeat.i(108587);
    if (this.pEn == null)
    {
      AppMethodBeat.o(108587);
      return;
    }
    if (this.pEn.isEmpty())
    {
      AppMethodBeat.o(108587);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.pEn);
    int i = localArrayList.size() - 1;
    while (i >= 0)
    {
      this.pEj.add(0, new com.tencent.mm.plugin.emoji.a.a.f((EmotionBannerSet)localArrayList.get(i)));
      this.pEi += 1;
      this.pEn.remove(localArrayList.get(i));
      i -= 1;
    }
    AppMethodBeat.o(108587);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.f
 * JD-Core Version:    0.7.0.1
 */