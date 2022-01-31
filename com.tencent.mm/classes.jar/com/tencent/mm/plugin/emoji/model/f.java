package com.tencent.mm.plugin.emoji.model;

import com.tencent.mm.protocal.c.vc;
import com.tencent.mm.protocal.c.ve;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.ArrayList;
import java.util.List;

public final class f
{
  public int iYg;
  public List<com.tencent.mm.plugin.emoji.a.a.f> iYh;
  public vc iYi;
  public List<vc> iYj;
  public List<ve> iYk;
  public List<ve> iYl;
  
  public final void aHL()
  {
    if (this.iYl == null) {}
    for (;;)
    {
      return;
      if (!this.iYl.isEmpty())
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.addAll(this.iYl);
        int i = localArrayList.size() - 1;
        while (i >= 0)
        {
          this.iYh.add(0, new com.tencent.mm.plugin.emoji.a.a.f((ve)localArrayList.get(i)));
          this.iYg += 1;
          this.iYl.remove(localArrayList.get(i));
          i -= 1;
        }
      }
    }
  }
  
  public final void aZ(List<com.tencent.mm.plugin.emoji.a.a.f> paramList)
  {
    if (this.iYh == null) {
      this.iYh = new ArrayList();
    }
    for (;;)
    {
      this.iYh.addAll(paramList);
      return;
      int i = this.iYh.size() - 1;
      if ((i >= 0) && (i < this.iYh.size()))
      {
        com.tencent.mm.plugin.emoji.a.a.f localf = (com.tencent.mm.plugin.emoji.a.a.f)this.iYh.get(i);
        if ((localf != null) && (localf.iVU != null) && (!bk.bl(localf.iVU.syc)) && (localf.iVU.syc.equals(EmojiGroupInfo.uCQ))) {
          this.iYh.remove(localf);
        }
      }
    }
  }
  
  public final void pV(int paramInt)
  {
    this.iYg += paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.f
 * JD-Core Version:    0.7.0.1
 */