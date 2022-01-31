package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.protocal.c.mg;
import com.tencent.mm.protocal.c.ra;
import java.util.LinkedList;

public final class c
  extends a
{
  protected TextView izH;
  protected TextView izI;
  
  public c(Context paramContext)
  {
    super(paramContext);
  }
  
  protected final void aDk()
  {
    this.izI = ((TextView)aDj().findViewById(a.d.card_aux_title));
    this.izH = ((TextView)aDj().findViewById(a.d.card_sub_title));
  }
  
  protected final void aDl()
  {
    ra localra;
    if ((this.ikk.azx().sIq != null) && (this.ikk.azx().sIq.size() > 0))
    {
      localra = (ra)this.ikk.azx().sIq.get(0);
      if (this.izy != null) {
        this.izy.setText(localra.title);
      }
      if (this.izH != null)
      {
        if (TextUtils.isEmpty(localra.ilq)) {
          break label128;
        }
        this.izH.setText(localra.ilq);
      }
    }
    for (;;)
    {
      if (this.izI != null)
      {
        if (TextUtils.isEmpty(localra.ilr)) {
          break;
        }
        this.izI.setText(localra.ilr);
      }
      return;
      label128:
      this.izH.setVisibility(8);
    }
    this.izI.setVisibility(8);
  }
  
  public final void w(boolean paramBoolean1, boolean paramBoolean2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.c
 * JD-Core Version:    0.7.0.1
 */