package com.tencent.mm.plugin.fts.ui;

import android.view.View;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.ui.d.g;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.HashSet;

public final class h
  extends d
  implements e.b
{
  private ah gNQ = new ah();
  private boolean kBj;
  private g kBm;
  
  public h(e parame, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    super(parame);
    this.kBm = new g(parame.getContext(), this, paramInt1);
    this.kBm.kwZ = paramString2;
    this.kBm.talker = paramString1;
    this.kBm.kwY = paramString3;
    this.kBm.showType = paramInt2;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.e parame, String paramString)
  {
    setCount(parame.rx(0));
    notifyDataSetChanged();
    N(getCount(), true);
  }
  
  protected final boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    paramBoolean = this.kBm.a(paramView, parama, paramBoolean);
    if ((parama.kyc) && (!this.kBj))
    {
      this.kBj = true;
      k.c(this.bVk, true, this.kBm.aVU(), -2);
    }
    if (paramBoolean)
    {
      clearCache();
      setCount(this.kBm.rx(0));
      notifyDataSetChanged();
      N(getCount(), true);
    }
    return paramBoolean;
  }
  
  protected final int aVE()
  {
    return this.kBm.aVU();
  }
  
  protected final void aVV()
  {
    this.kBj = false;
    this.kBm.a(this.bVk, this.gNQ, new HashSet());
  }
  
  public final void finish()
  {
    super.finish();
    if (!this.kBj)
    {
      this.kBj = true;
      k.c(this.bVk, false, this.kBm.aVU(), -2);
    }
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a ry(int paramInt)
  {
    com.tencent.mm.plugin.fts.a.d.a.a locala = this.kBm.ry(paramInt);
    if (locala != null) {
      locala.pageType = 5;
    }
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.h
 * JD-Core Version:    0.7.0.1
 */