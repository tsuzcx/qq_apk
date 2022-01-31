package com.tencent.mm.plugin.account.bind.ui;

import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

final class d$1
  implements b.b
{
  d$1(d paramd) {}
  
  public final void c(int paramInt1, String paramString, int paramInt2)
  {
    y.i("MicroMsg.MobileFriendAdapter", "[cpan] postion:%d md5:%s status:%d", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2) });
    com.tencent.mm.plugin.account.friend.a.a locala = (com.tencent.mm.plugin.account.friend.a.a)this.fed.getItem(paramInt1);
    if (locala == null) {
      y.e("MicroMsg.MobileFriendAdapter", "[cpan] mobile Friend is null. mobile:%s", new Object[] { paramString });
    }
    do
    {
      return;
      y.d("MicroMsg.MobileFriendAdapter", "mobile friend:%s", new Object[] { locala.toString() });
    } while (locala.status != 1);
    paramString = new com.tencent.mm.pluginsdk.ui.applet.a(d.a(this.fed), new d.1.1(this));
    paramString.sbG = new d.1.2(this, locala);
    if ((d.c(this.fed) instanceof MobileFriendUI)) {
      ((MobileFriendUI)d.e(this.fed)).gJb = new d.1.3(this, locala);
    }
    paramString.fiE = locala.Wv();
    paramString.sbN = false;
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(Integer.valueOf(13));
    paramString.b(locala.getUsername(), localLinkedList, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.d.1
 * JD-Core Version:    0.7.0.1
 */