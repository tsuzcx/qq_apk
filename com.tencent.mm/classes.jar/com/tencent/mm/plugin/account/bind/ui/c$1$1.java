package com.tencent.mm.plugin.account.bind.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bv;
import com.tencent.mm.plugin.account.friend.a.b;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.sdk.platformtools.ab;

final class c$1$1
  implements a.a
{
  c$1$1(c.1 param1) {}
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(13694);
    ab.i("MicroMsg.MobileFriendAdapter", "cpan ok:%b hasSendVerify:%b  username:%s gitemId:%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), paramString1, paramString2 });
    com.tencent.mm.plugin.account.friend.a.a locala = ((b)((com.tencent.mm.plugin.account.a.a.a)g.G(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).xa(paramString2);
    if (locala != null)
    {
      if (paramBoolean1)
      {
        locala.username = paramString1;
        locala.status = 2;
        locala.fsi = 2;
        ab.d("MicroMsg.MobileFriendAdapter", "f :%s", new Object[] { locala.toString() });
        ((b)((com.tencent.mm.plugin.account.a.a.a)g.G(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).a(paramString2, locala);
        this.gvF.gvE.Ku();
        bv.abc().c(26, new Object[0]);
        AppMethodBeat.o(13694);
      }
    }
    else {
      ab.w("MicroMsg.MobileFriendAdapter", "cpan qq friend is null. qq:%s", new Object[] { paramString2 });
    }
    AppMethodBeat.o(13694);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.c.1.1
 * JD-Core Version:    0.7.0.1
 */