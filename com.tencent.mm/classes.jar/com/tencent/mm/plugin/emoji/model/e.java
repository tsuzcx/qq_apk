package com.tencent.mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.protocal.protobuf.EmotionBanner;
import com.tencent.mm.protocal.protobuf.EmotionBannerSet;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.ArrayList;
import java.util.List;

public final class e
{
  public int lhk;
  public List<f> lhl;
  public EmotionBanner lhm;
  public List<EmotionBanner> lhn;
  public List<EmotionBannerSet> lho;
  public List<EmotionBannerSet> lhp;
  
  public final void bll()
  {
    AppMethodBeat.i(53047);
    if (this.lhp == null)
    {
      AppMethodBeat.o(53047);
      return;
    }
    if (this.lhp.isEmpty())
    {
      AppMethodBeat.o(53047);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.lhp);
    int i = localArrayList.size() - 1;
    while (i >= 0)
    {
      this.lhl.add(0, new f((EmotionBannerSet)localArrayList.get(i)));
      this.lhk += 1;
      this.lhp.remove(localArrayList.get(i));
      i -= 1;
    }
    AppMethodBeat.o(53047);
  }
  
  public final void bo(List<f> paramList)
  {
    AppMethodBeat.i(53048);
    if (this.lhl == null) {
      this.lhl = new ArrayList();
    }
    for (;;)
    {
      this.lhl.addAll(paramList);
      AppMethodBeat.o(53048);
      return;
      int i = this.lhl.size() - 1;
      if ((i >= 0) && (i < this.lhl.size()))
      {
        f localf = (f)this.lhl.get(i);
        if ((localf != null) && (localf.lfa != null) && (!bo.isNullOrNil(localf.lfa.ProductID)) && (localf.lfa.ProductID.equals(EmojiGroupInfo.yPd))) {
          this.lhl.remove(localf);
        }
      }
    }
  }
  
  public final void uq(int paramInt)
  {
    this.lhk += paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.e
 * JD-Core Version:    0.7.0.1
 */