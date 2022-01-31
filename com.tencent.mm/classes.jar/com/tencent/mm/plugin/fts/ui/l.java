package com.tencent.mm.plugin.fts.ui;

import android.view.View;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.HashSet;

public final class l
  extends d
  implements e.b
{
  private ah gNQ = new ah();
  private boolean kBj;
  private com.tencent.mm.plugin.fts.ui.d.l kCo;
  
  public l(e parame, String paramString, int paramInt)
  {
    super(parame);
    this.kCo = new com.tencent.mm.plugin.fts.ui.d.l(parame.getContext(), this, paramInt);
    this.kCo.kwZ = paramString;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.e parame, String paramString)
  {
    setCount(parame.rx(0));
    notifyDataSetChanged();
    N(getCount(), true);
  }
  
  protected final boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    paramBoolean = this.kCo.a(paramView, parama, paramBoolean);
    if ((parama.kyc) && (!this.kBj))
    {
      this.kBj = true;
      k.c(this.bVk, true, this.kCo.aVU(), -2);
    }
    if (paramBoolean)
    {
      clearCache();
      setCount(this.kCo.rx(0));
      notifyDataSetChanged();
      N(getCount(), true);
    }
    return paramBoolean;
  }
  
  protected final int aVE()
  {
    return this.kCo.aVU();
  }
  
  protected final void aVV()
  {
    this.kBj = false;
    this.kCo.a(this.bVk, this.gNQ, new HashSet());
  }
  
  public final void finish()
  {
    super.finish();
    if (!this.kBj)
    {
      this.kBj = true;
      k.c(this.bVk, false, this.kCo.aVU(), -2);
    }
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a ry(int paramInt)
  {
    com.tencent.mm.plugin.fts.a.d.a.a locala = this.kCo.ry(paramInt);
    if (locala != null) {
      locala.pageType = 3;
    }
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.l
 * JD-Core Version:    0.7.0.1
 */