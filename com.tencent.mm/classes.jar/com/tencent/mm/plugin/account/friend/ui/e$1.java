package com.tencent.mm.plugin.account.friend.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.plugin.account.friend.a.ap;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

final class e$1
  implements e.a
{
  e$1(e parame) {}
  
  public final void d(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(108589);
    ab.d("MicroMsg.QQFriendAdapter", "[cpan] postion:%d qq:%s status:%d", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2) });
    ao localao = (ao)this.gzL.getItem(paramInt1);
    if (localao == null)
    {
      ab.e("MicroMsg.QQFriendAdapter", "[cpan] qq friend is null. qq:%s", new Object[] { paramString });
      AppMethodBeat.o(108589);
      return;
    }
    if (bo.isNullOrNil(localao.getUsername()))
    {
      ab.e("MicroMsg.QQFriendAdapter", "[cpan] qq friend username is null. qq:%s", new Object[] { paramString });
      AppMethodBeat.o(108589);
      return;
    }
    ab.d("MicroMsg.QQFriendAdapter", "qq friend:%s", new Object[] { localao.toString() });
    if (localao.gyF == 0)
    {
      paramInt1 = p.cU(localao.gyE);
      paramString = new g(e.a(this.gzL), new e.1.1(this), (byte)0);
      paramString.o(new int[] { paramInt1 });
      paramString.gAl = localao.gyE;
      localao.fsi = 1;
      ((ap)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(localao.gyE, localao);
      this.gzL.Ku();
      AppMethodBeat.o(108589);
      return;
    }
    if (localao.gyF == 1)
    {
      paramString = new com.tencent.mm.pluginsdk.ui.applet.a(e.a(this.gzL), new e.1.2(this));
      paramString.gAl = localao.gyE;
      paramString.vST = false;
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(Integer.valueOf(12));
      paramString.b(localao.getUsername(), localLinkedList, true);
      localao.fsi = 1;
      ((ap)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(localao.gyE, localao);
      this.gzL.Ku();
    }
    AppMethodBeat.o(108589);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.e.1
 * JD-Core Version:    0.7.0.1
 */