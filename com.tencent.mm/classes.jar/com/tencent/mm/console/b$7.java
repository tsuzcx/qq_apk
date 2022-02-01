package com.tencent.mm.console;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.eggspring.c.a;

final class b$7
  implements f
{
  b$7(Context paramContext) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(20119);
    if (2812 == paramn.getType())
    {
      g.ajj().b(2812, this);
      paramString = (a)paramn;
      Toast.makeText(this.val$context, "errType:" + paramInt1 + ", errCode:" + paramInt2 + ", coupon ret_code:" + paramString.pFO + ", coupon ret_msg:" + paramString.pFP + ".", 1).show();
    }
    AppMethodBeat.o(20119);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.console.b.7
 * JD-Core Version:    0.7.0.1
 */