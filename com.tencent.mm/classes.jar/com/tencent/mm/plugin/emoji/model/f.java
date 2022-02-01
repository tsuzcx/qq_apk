package com.tencent.mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.EmotionBanner;
import com.tencent.mm.protocal.protobuf.EmotionBannerSet;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.ArrayList;
import java.util.List;

public final class f
{
  public int pKM;
  public List<com.tencent.mm.plugin.emoji.a.a.f> pKN;
  public EmotionBanner pKO;
  public List<EmotionBanner> pKP;
  public List<EmotionBannerSet> pKQ;
  public List<EmotionBannerSet> pKR;
  
  public final void Cm(int paramInt)
  {
    this.pKM += paramInt;
  }
  
  public final void cR(List<com.tencent.mm.plugin.emoji.a.a.f> paramList)
  {
    AppMethodBeat.i(108588);
    if (this.pKN == null) {
      this.pKN = new ArrayList();
    }
    for (;;)
    {
      this.pKN.addAll(paramList);
      AppMethodBeat.o(108588);
      return;
      int i = this.pKN.size() - 1;
      if ((i >= 0) && (i < this.pKN.size()))
      {
        com.tencent.mm.plugin.emoji.a.a.f localf = (com.tencent.mm.plugin.emoji.a.a.f)this.pKN.get(i);
        if ((localf != null) && (localf.pIz != null) && (!bu.isNullOrNil(localf.pIz.ProductID)) && (localf.pIz.ProductID.equals(EmojiGroupInfo.OzR))) {
          this.pKN.remove(localf);
        }
      }
    }
  }
  
  public final void cia()
  {
    AppMethodBeat.i(108587);
    if (this.pKR == null)
    {
      AppMethodBeat.o(108587);
      return;
    }
    if (this.pKR.isEmpty())
    {
      AppMethodBeat.o(108587);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.pKR);
    int i = localArrayList.size() - 1;
    while (i >= 0)
    {
      this.pKN.add(0, new com.tencent.mm.plugin.emoji.a.a.f((EmotionBannerSet)localArrayList.get(i)));
      this.pKM += 1;
      this.pKR.remove(localArrayList.get(i));
      i -= 1;
    }
    AppMethodBeat.o(108587);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.f
 * JD-Core Version:    0.7.0.1
 */