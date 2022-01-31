package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.k.a;
import com.tencent.mm.plugin.game.model.l;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

final class m$3
  implements k.a
{
  m$3(m paramm) {}
  
  public final void f(int paramInt, String paramString, boolean paramBoolean)
  {
    if ((!paramBoolean) || (this.ldb.lcY == null) || (paramString == null)) {}
    for (;;)
    {
      return;
      Object localObject;
      try
      {
        localObject = this.ldb.lcY.values().iterator();
        while (((Iterator)localObject).hasNext())
        {
          l locall = (l)((Iterator)localObject).next();
          if ((locall != null) && (locall.kOM != null) && ((locall.kOM.field_appId.equals(paramString)) || (locall.kOM.field_packageName.equals(paramString))))
          {
            locall.dz(this.ldb.mContext);
            locall.aGu();
          }
        }
        paramInt = 0;
      }
      catch (Exception paramString)
      {
        y.e("MicroMsg.GameListAdapter", paramString.getMessage());
        return;
      }
      while (paramInt < this.ldb.kQN.size())
      {
        localObject = (d)this.ldb.kQN.get(paramInt);
        if ((((d)localObject).type == 0) && ((((d)localObject).field_appId.equals(paramString)) || (((d)localObject).field_packageName.equals(paramString))) && (m.a(this.ldb) != null))
        {
          m.a(this.ldb).sf(paramInt);
          return;
        }
        paramInt += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.m.3
 * JD-Core Version:    0.7.0.1
 */