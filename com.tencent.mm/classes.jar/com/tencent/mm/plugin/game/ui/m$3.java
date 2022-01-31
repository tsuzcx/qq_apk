package com.tencent.mm.plugin.game.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.model.c;
import com.tencent.mm.plugin.game.model.j.a;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

final class m$3
  implements j.a
{
  m$3(m paramm) {}
  
  public final void f(int paramInt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(112060);
    if ((!paramBoolean) || (this.nAW.nAT == null) || (paramString == null))
    {
      AppMethodBeat.o(112060);
      return;
    }
    Object localObject;
    try
    {
      localObject = this.nAW.nAT.values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        k localk = (k)((Iterator)localObject).next();
        if ((localk != null) && (localk.nmJ != null) && ((localk.nmJ.field_appId.equals(paramString)) || (localk.nmJ.field_packageName.equals(paramString))))
        {
          localk.em(this.nAW.mContext);
          localk.bjZ();
        }
      }
      paramInt = 0;
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.GameListAdapter", paramString.getMessage());
      AppMethodBeat.o(112060);
      return;
    }
    while (paramInt < this.nAW.noR.size())
    {
      localObject = (c)this.nAW.noR.get(paramInt);
      if ((((c)localObject).type == 0) && ((((c)localObject).field_appId.equals(paramString)) || (((c)localObject).field_packageName.equals(paramString))) && (m.a(this.nAW) != null))
      {
        m.a(this.nAW).xe(paramInt);
        AppMethodBeat.o(112060);
        return;
      }
      paramInt += 1;
    }
    AppMethodBeat.o(112060);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.m.3
 * JD-Core Version:    0.7.0.1
 */