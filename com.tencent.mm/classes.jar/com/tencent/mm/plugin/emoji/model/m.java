package com.tencent.mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.protocal.protobuf.anj;
import com.tencent.mm.protocal.protobuf.cjb;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.ArrayList;
import java.util.List;

public final class m
{
  public int xMT;
  public List<f> xMU;
  public anh xMV;
  public List<anh> xMW;
  public List<anj> xMX;
  public List<anj> xMY;
  
  public final void Kq(int paramInt)
  {
    this.xMT += paramInt;
  }
  
  public final void dzS()
  {
    AppMethodBeat.i(108587);
    if (this.xMY == null)
    {
      AppMethodBeat.o(108587);
      return;
    }
    if (this.xMY.isEmpty())
    {
      AppMethodBeat.o(108587);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.xMY);
    int i = localArrayList.size() - 1;
    while (i >= 0)
    {
      this.xMU.add(0, new f((anj)localArrayList.get(i)));
      this.xMT += 1;
      this.xMY.remove(localArrayList.get(i));
      i -= 1;
    }
    AppMethodBeat.o(108587);
  }
  
  public final void fb(List<f> paramList)
  {
    AppMethodBeat.i(108588);
    if (this.xMU == null) {
      this.xMU = new ArrayList();
    }
    for (;;)
    {
      this.xMU.addAll(paramList);
      AppMethodBeat.o(108588);
      return;
      int i = this.xMU.size() - 1;
      if ((i >= 0) && (i < this.xMU.size()))
      {
        f localf = (f)this.xMU.get(i);
        if ((localf != null) && (localf.xHE != null) && (!Util.isNullOrNil(localf.xHE.ProductID)) && (localf.xHE.ProductID.equals(EmojiGroupInfo.aklD))) {
          this.xMU.remove(localf);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.m
 * JD-Core Version:    0.7.0.1
 */