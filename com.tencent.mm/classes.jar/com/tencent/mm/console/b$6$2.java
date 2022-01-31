package com.tencent.mm.console;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class b$6$2
  implements f
{
  b$6$2(b.6 param6) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(16085);
    ab.i("MicroMsg.CommandProcessor", "summercert testdefaultrsa  NetSceneGetCert onSceneEnd [%d, %d, %s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 4) && (paramInt2 == -102))
    {
      al.d(new b.6.2.1(this));
      AppMethodBeat.o(16085);
      return;
    }
    Toast.makeText(this.eue.val$context, "DefaultRSA check pass", 0).show();
    b.D(this.eue.val$context, "");
    AppMethodBeat.o(16085);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.console.b.6.2
 * JD-Core Version:    0.7.0.1
 */