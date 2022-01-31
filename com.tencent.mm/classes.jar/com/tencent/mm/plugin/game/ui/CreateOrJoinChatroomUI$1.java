package com.tencent.mm.plugin.game.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w.a;
import com.tencent.mm.plugin.game.d.aa;
import com.tencent.mm.sdk.platformtools.ab;

final class CreateOrJoinChatroomUI$1
  implements w.a
{
  CreateOrJoinChatroomUI$1(CreateOrJoinChatroomUI paramCreateOrJoinChatroomUI) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    AppMethodBeat.i(111702);
    paramb = (aa)paramb.fsW.fta;
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ab.e("MicroMsg.CreateOrJoinChatroomUI", "CGI return is not OK. (%d, %d)(%s)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if (paramInt1 == 4) {
        CreateOrJoinChatroomUI.a(this.nva, paramb.lGK);
      }
      for (;;)
      {
        CreateOrJoinChatroomUI.a(this.nva);
        this.nva.finish();
        AppMethodBeat.o(111702);
        return 0;
        CreateOrJoinChatroomUI.a(this.nva, -1);
      }
    }
    paramString = paramb.nre;
    ab.i("MicroMsg.CreateOrJoinChatroomUI", "Create Url: %s", new Object[] { paramString });
    CreateOrJoinChatroomUI.a(this.nva);
    CreateOrJoinChatroomUI.a(this.nva, paramString);
    AppMethodBeat.o(111702);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.CreateOrJoinChatroomUI.1
 * JD-Core Version:    0.7.0.1
 */