package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public class k
  extends a
{
  public String kDu;
  private k.b kDv = new k.b(this);
  private k.a kDw = new k.a(this);
  
  public k(int paramInt)
  {
    super(0, paramInt);
  }
  
  public a.b BD()
  {
    return this.kDv;
  }
  
  public void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    this.kDu = bk.aM(m.rF(this.kxU), "");
    y.i("MicroMsg.FTS.FTSHeaderDataItem", "fillingDataItem: header=%s", new Object[] { this.kDu });
  }
  
  protected a.a afK()
  {
    return this.kDw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.k
 * JD-Core Version:    0.7.0.1
 */