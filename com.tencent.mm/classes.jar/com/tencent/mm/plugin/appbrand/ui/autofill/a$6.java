package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.protocal.c.bsa;
import com.tencent.mm.protocal.c.ew;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

final class a$6
  implements View.OnClickListener
{
  a$6(a parama, bsa parambsa) {}
  
  public final void onClick(View paramView)
  {
    y.i("MicroMsg.AppBrandIDCardShowFrag", "urlJump click");
    if (a.a(this.heZ) != null) {
      a.a(this.heZ).ww(((ew)this.hfa.tIJ.get(0)).url);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.autofill.a.6
 * JD-Core Version:    0.7.0.1
 */