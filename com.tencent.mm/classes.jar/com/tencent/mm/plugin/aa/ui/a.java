package com.tencent.mm.plugin.aa.ui;

import android.view.View;
import com.tencent.mm.pluginsdk.ui.d.n;

public final class a
  extends n
{
  private a.a eXm;
  
  public a(a.a parama)
  {
    super(2, null);
    this.eXm = parama;
  }
  
  public final void onClick(View paramView)
  {
    if (this.eXm != null) {
      this.eXm.Vx();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.a
 * JD-Core Version:    0.7.0.1
 */