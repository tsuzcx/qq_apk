package com.tencent.mm.plugin.account.friend.ui;

import com.tencent.mm.a.o;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.plugin.account.friend.a.ap;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

final class e$1
  implements e.a
{
  e$1(e parame) {}
  
  public final void d(int paramInt1, String paramString, int paramInt2)
  {
    y.d("MicroMsg.QQFriendAdapter", "[cpan] postion:%d qq:%s status:%d", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2) });
    ao localao = (ao)this.fie.getItem(paramInt1);
    if (localao == null) {
      y.e("MicroMsg.QQFriendAdapter", "[cpan] qq friend is null. qq:%s", new Object[] { paramString });
    }
    do
    {
      return;
      if (bk.bl(localao.getUsername()))
      {
        y.e("MicroMsg.QQFriendAdapter", "[cpan] qq friend username is null. qq:%s", new Object[] { paramString });
        return;
      }
      y.d("MicroMsg.QQFriendAdapter", "qq friend:%s", new Object[] { localao.toString() });
      if (localao.fgX == 0)
      {
        paramInt1 = o.bS(localao.fgW);
        paramString = new g(e.a(this.fie), new e.1.1(this), (byte)0);
        paramString.g(new int[] { paramInt1 });
        paramString.fiE = localao.fgW;
        localao.ebQ = 1;
        ((ap)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(localao.fgW, localao);
        this.fie.yc();
        return;
      }
    } while (localao.fgX != 1);
    paramString = new com.tencent.mm.pluginsdk.ui.applet.a(e.a(this.fie), new e.1.2(this));
    paramString.fiE = localao.fgW;
    paramString.sbN = false;
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(Integer.valueOf(12));
    paramString.b(localao.getUsername(), localLinkedList, true);
    localao.ebQ = 1;
    ((ap)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(localao.fgW, localao);
    this.fie.yc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.e.1
 * JD-Core Version:    0.7.0.1
 */