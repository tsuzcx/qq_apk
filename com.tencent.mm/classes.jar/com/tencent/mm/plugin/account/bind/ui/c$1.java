package com.tencent.mm.plugin.account.bind.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

final class c$1
  implements b.b
{
  c$1(c paramc) {}
  
  public final void c(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(13697);
    ab.d("MicroMsg.MobileFriendAdapter", "[cpan] postion:%d md5:%s status:%d", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2) });
    com.tencent.mm.plugin.account.friend.a.a locala = (com.tencent.mm.plugin.account.friend.a.a)this.gvE.getItem(paramInt1);
    if (locala == null)
    {
      ab.e("MicroMsg.MobileFriendAdapter", "[cpan] mobile Friend is null. mobile:%s", new Object[] { paramString });
      AppMethodBeat.o(13697);
      return;
    }
    ab.d("MicroMsg.MobileFriendAdapter", "mobile friend:%s", new Object[] { locala.toString() });
    if (locala.status == 1)
    {
      paramString = new com.tencent.mm.pluginsdk.ui.applet.a(c.a(this.gvE), new c.1.1(this));
      paramString.vSN = new c.1.2(this, locala);
      if ((c.c(this.gvE) instanceof MobileFriendUI)) {
        ((MobileFriendUI)c.e(this.gvE)).mmSetOnActivityResultCallback(new c.1.3(this, locala));
      }
      paramString.gAl = locala.Al();
      paramString.vST = false;
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(Integer.valueOf(13));
      paramString.b(locala.getUsername(), localLinkedList, false);
    }
    AppMethodBeat.o(13697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.c.1
 * JD-Core Version:    0.7.0.1
 */