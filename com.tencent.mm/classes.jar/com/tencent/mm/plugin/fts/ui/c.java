package com.tencent.mm.plugin.fts.ui;

import android.os.Looper;
import android.view.View;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.HashSet;

public final class c
  extends d
  implements e.b
{
  private com.tencent.mm.plugin.fts.ui.d.a kAj = new com.tencent.mm.plugin.fts.ui.d.a(parame.getContext(), this, 0);
  protected boolean kAk;
  private ah kAl = new ah(Looper.getMainLooper());
  
  public c(e parame)
  {
    super(parame);
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.e parame, String paramString)
  {
    int i = this.kAj.rx(0);
    setCount(i);
    notifyDataSetChanged();
    N(i, true);
  }
  
  protected final boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    return false;
  }
  
  protected final int aVE()
  {
    return this.kAj.aVU();
  }
  
  protected final void aVV()
  {
    this.kAk = false;
    this.kAj.a(this.bVk, this.kAl, new HashSet());
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a ry(int paramInt)
  {
    return this.kAj.ry(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.c
 * JD-Core Version:    0.7.0.1
 */