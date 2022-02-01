package com.tencent.mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.protocal.protobuf.EmotionBanner;
import com.tencent.mm.protocal.protobuf.EmotionBannerSet;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.ArrayList;
import java.util.List;

public final class g
{
  public int rbs;
  public List<f> rbt;
  public EmotionBanner rbu;
  public List<EmotionBanner> rbv;
  public List<EmotionBannerSet> rbw;
  public List<EmotionBannerSet> rbx;
  
  public final void FX(int paramInt)
  {
    this.rbs += paramInt;
  }
  
  public final void cFZ()
  {
    AppMethodBeat.i(108587);
    if (this.rbx == null)
    {
      AppMethodBeat.o(108587);
      return;
    }
    if (this.rbx.isEmpty())
    {
      AppMethodBeat.o(108587);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.rbx);
    int i = localArrayList.size() - 1;
    while (i >= 0)
    {
      this.rbt.add(0, new f((EmotionBannerSet)localArrayList.get(i)));
      this.rbs += 1;
      this.rbx.remove(localArrayList.get(i));
      i -= 1;
    }
    AppMethodBeat.o(108587);
  }
  
  public final void dg(List<f> paramList)
  {
    AppMethodBeat.i(108588);
    if (this.rbt == null) {
      this.rbt = new ArrayList();
    }
    for (;;)
    {
      this.rbt.addAll(paramList);
      AppMethodBeat.o(108588);
      return;
      int i = this.rbt.size() - 1;
      if ((i >= 0) && (i < this.rbt.size()))
      {
        f localf = (f)this.rbt.get(i);
        if ((localf != null) && (localf.qYl != null) && (!Util.isNullOrNil(localf.qYl.ProductID)) && (localf.qYl.ProductID.equals(EmojiGroupInfo.Uum))) {
          this.rbt.remove(localf);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.g
 * JD-Core Version:    0.7.0.1
 */