package com.tencent.mm.plugin.fts.ui;

import android.os.Looper;
import android.view.View;
import com.tencent.mm.model.af;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.d.f;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.HashSet;
import java.util.LinkedList;

public final class g
  extends d
  implements e.b
{
  private ah kAl = new ah(Looper.getMainLooper());
  private f kBi;
  private boolean kBj;
  
  public g(e parame, String paramString, int paramInt)
  {
    super(parame);
    parame = parame.getContext();
    HashSet localHashSet = new HashSet();
    localHashSet.add(Integer.valueOf(160));
    parame = (f)((n)com.tencent.mm.kernel.g.t(n.class)).createFTSUIUnitList(localHashSet, parame, this, paramInt).get(0);
    parame.kwY = paramString;
    if (s.fn(paramString)) {
      parame.kBd = ((c)com.tencent.mm.kernel.g.r(c.class)).FF().in(paramString);
    }
    this.kBi = parame;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.e parame, String paramString)
  {
    setCount(parame.rx(0));
    notifyDataSetChanged();
    N(getCount(), true);
  }
  
  protected final boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    this.kBi.a(paramView, parama, paramBoolean);
    if ((parama.kyc) && (!this.kBj))
    {
      this.kBj = true;
      k.c(this.bVk, true, this.kBi.aVU(), -2);
    }
    return false;
  }
  
  protected final int aVE()
  {
    return this.kBi.aVU();
  }
  
  protected final void aVV()
  {
    this.kBj = false;
    this.kBi.a(this.bVk, this.kAl, new HashSet());
  }
  
  public final void finish()
  {
    super.finish();
    if (!this.kBj)
    {
      this.kBj = true;
      k.c(this.bVk, false, this.kBi.aVU(), -2);
    }
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a ry(int paramInt)
  {
    com.tencent.mm.plugin.fts.a.d.a.a locala = this.kBi.ry(paramInt);
    if (locala != null)
    {
      locala.kxV = paramInt;
      locala.pageType = 4;
    }
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.g
 * JD-Core Version:    0.7.0.1
 */