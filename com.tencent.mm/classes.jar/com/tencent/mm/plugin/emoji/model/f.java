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
  public int owY;
  public List<com.tencent.mm.plugin.emoji.a.a.f> owZ;
  public EmotionBanner oxa;
  public List<EmotionBanner> oxb;
  public List<EmotionBannerSet> oxc;
  public List<EmotionBannerSet> oxd;
  
  public final void AA(int paramInt)
  {
    this.owY += paramInt;
  }
  
  public final void bUT()
  {
    AppMethodBeat.i(108587);
    if (this.oxd == null)
    {
      AppMethodBeat.o(108587);
      return;
    }
    if (this.oxd.isEmpty())
    {
      AppMethodBeat.o(108587);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.oxd);
    int i = localArrayList.size() - 1;
    while (i >= 0)
    {
      this.owZ.add(0, new com.tencent.mm.plugin.emoji.a.a.f((EmotionBannerSet)localArrayList.get(i)));
      this.owY += 1;
      this.oxd.remove(localArrayList.get(i));
      i -= 1;
    }
    AppMethodBeat.o(108587);
  }
  
  public final void cL(List<com.tencent.mm.plugin.emoji.a.a.f> paramList)
  {
    AppMethodBeat.i(108588);
    if (this.owZ == null) {
      this.owZ = new ArrayList();
    }
    for (;;)
    {
      this.owZ.addAll(paramList);
      AppMethodBeat.o(108588);
      return;
      int i = this.owZ.size() - 1;
      if ((i >= 0) && (i < this.owZ.size()))
      {
        com.tencent.mm.plugin.emoji.a.a.f localf = (com.tencent.mm.plugin.emoji.a.a.f)this.owZ.get(i);
        if ((localf != null) && (localf.ouL != null) && (!bt.isNullOrNil(localf.ouL.ProductID)) && (localf.ouL.ProductID.equals(EmojiGroupInfo.LBN))) {
          this.owZ.remove(localf);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.f
 * JD-Core Version:    0.7.0.1
 */