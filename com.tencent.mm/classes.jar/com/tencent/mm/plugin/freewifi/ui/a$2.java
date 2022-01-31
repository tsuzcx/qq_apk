package com.tencent.mm.plugin.freewifi.ui;

import android.view.View;
import com.tencent.mm.R.h;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aq;

final class a$2
  implements Runnable
{
  a$2(a parama) {}
  
  public final void run()
  {
    View localView = a.b(this.kqX).findViewById(R.h.free_wifi_tip_view);
    if (aq.getNetType(ae.getContext()) != 0)
    {
      localView.setVisibility(8);
      return;
    }
    au.DS().O(new a.2.1(this, localView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.a.2
 * JD-Core Version:    0.7.0.1
 */