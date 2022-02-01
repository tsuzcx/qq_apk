package com.tencent.mm.console;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.eggspring.d.a;

final class b$7
  implements i
{
  b$7(Context paramContext) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(20119);
    if (2812 == paramq.getType())
    {
      g.azz().b(2812, this);
      paramString = (a)paramq;
      Toast.makeText(this.val$context, "errType:" + paramInt1 + ", errCode:" + paramInt2 + ", coupon ret_code:" + paramString.qVg + ", coupon ret_msg:" + paramString.qVh + ".", 1).show();
    }
    AppMethodBeat.o(20119);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.console.b.7
 * JD-Core Version:    0.7.0.1
 */