package com.tencent.mm.plugin.appbrand.widget.b;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.protocal.c.bna;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.LinkedList;

final class c$1
  implements View.OnClickListener
{
  c$1(c paramc, LinkedList paramLinkedList, c.a parama, b paramb) {}
  
  public final void onClick(View paramView)
  {
    paramView = new ArrayList();
    int i = 0;
    while (i < this.fXW.size())
    {
      if ((((bna)this.fXW.get(i)).tGf == 2) || (((bna)this.fXW.get(i)).tGf == 3)) {
        paramView.add(((bna)this.fXW.get(i)).sEi);
      }
      i += 1;
    }
    y.i("MicroMsg.AppBrandAuthorizeDialog", "stev acceptButton click!");
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("key_scope", paramView);
    this.hsr.e(1, localBundle);
    this.hss.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.b.c.1
 * JD-Core Version:    0.7.0.1
 */