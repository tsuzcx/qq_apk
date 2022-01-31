package com.tencent.mm.plugin.account.friend.a;

import com.tencent.mm.protocal.c.auc;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.applet.b.b;

final class i$2
  implements b.b
{
  i$2(i parami) {}
  
  public final int WL()
  {
    return this.ffI.getCount();
  }
  
  public final String jX(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.ffI.getCount())) {
      y.e("MicroMsg.FriendAdapter", "pos is invalid");
    }
    auc localauc;
    do
    {
      return null;
      localauc = this.ffI.jW(paramInt);
    } while (localauc == null);
    return localauc.hPY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.i.2
 * JD-Core Version:    0.7.0.1
 */