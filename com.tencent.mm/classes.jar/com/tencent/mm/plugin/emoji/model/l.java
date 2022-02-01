package com.tencent.mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.protocal.protobuf.aju;
import com.tencent.mm.protocal.protobuf.ajw;
import com.tencent.mm.protocal.protobuf.akh;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.ArrayList;
import java.util.List;

public final class l
{
  public List<ajw> uEA;
  public List<ajw> uEB;
  public int uEw;
  public List<f> uEx;
  public aju uEy;
  public List<aju> uEz;
  
  public final void JF(int paramInt)
  {
    this.uEw += paramInt;
  }
  
  public final void cUI()
  {
    AppMethodBeat.i(108587);
    if (this.uEB == null)
    {
      AppMethodBeat.o(108587);
      return;
    }
    if (this.uEB.isEmpty())
    {
      AppMethodBeat.o(108587);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.uEB);
    int i = localArrayList.size() - 1;
    while (i >= 0)
    {
      this.uEx.add(0, new f((ajw)localArrayList.get(i)));
      this.uEw += 1;
      this.uEB.remove(localArrayList.get(i));
      i -= 1;
    }
    AppMethodBeat.o(108587);
  }
  
  public final void df(List<f> paramList)
  {
    AppMethodBeat.i(108588);
    if (this.uEx == null) {
      this.uEx = new ArrayList();
    }
    for (;;)
    {
      this.uEx.addAll(paramList);
      AppMethodBeat.o(108588);
      return;
      int i = this.uEx.size() - 1;
      if ((i >= 0) && (i < this.uEx.size()))
      {
        f localf = (f)this.uEx.get(i);
        if ((localf != null) && (localf.uBa != null) && (!Util.isNullOrNil(localf.uBa.ProductID)) && (localf.uBa.ProductID.equals(EmojiGroupInfo.YCu))) {
          this.uEx.remove(localf);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.l
 * JD-Core Version:    0.7.0.1
 */