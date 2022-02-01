package com.tencent.mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.EmotionBanner;
import com.tencent.mm.protocal.protobuf.EmotionBannerSet;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.ArrayList;
import java.util.List;

public final class f
{
  public EmotionBanner paA;
  public List<EmotionBanner> paB;
  public List<EmotionBannerSet> paC;
  public List<EmotionBannerSet> paD;
  public int pay;
  public List<com.tencent.mm.plugin.emoji.a.a.f> paz;
  
  public final void Bs(int paramInt)
  {
    this.pay += paramInt;
  }
  
  public final void cN(List<com.tencent.mm.plugin.emoji.a.a.f> paramList)
  {
    AppMethodBeat.i(108588);
    if (this.paz == null) {
      this.paz = new ArrayList();
    }
    for (;;)
    {
      this.paz.addAll(paramList);
      AppMethodBeat.o(108588);
      return;
      int i = this.paz.size() - 1;
      if ((i >= 0) && (i < this.paz.size()))
      {
        com.tencent.mm.plugin.emoji.a.a.f localf = (com.tencent.mm.plugin.emoji.a.a.f)this.paz.get(i);
        if ((localf != null) && (localf.oYl != null) && (!bs.isNullOrNil(localf.oYl.ProductID)) && (localf.oYl.ProductID.equals(EmojiGroupInfo.Jsp))) {
          this.paz.remove(localf);
        }
      }
    }
  }
  
  public final void ccg()
  {
    AppMethodBeat.i(108587);
    if (this.paD == null)
    {
      AppMethodBeat.o(108587);
      return;
    }
    if (this.paD.isEmpty())
    {
      AppMethodBeat.o(108587);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.paD);
    int i = localArrayList.size() - 1;
    while (i >= 0)
    {
      this.paz.add(0, new com.tencent.mm.plugin.emoji.a.a.f((EmotionBannerSet)localArrayList.get(i)));
      this.pay += 1;
      this.paD.remove(localArrayList.get(i));
      i -= 1;
    }
    AppMethodBeat.o(108587);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.f
 * JD-Core Version:    0.7.0.1
 */