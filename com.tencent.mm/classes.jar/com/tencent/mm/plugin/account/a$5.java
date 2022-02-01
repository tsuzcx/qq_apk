package com.tencent.mm.plugin.account;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.d.d;
import com.tencent.mm.plugin.fts.a.i;
import com.tencent.mm.plugin.fts.a.k;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.x.b;

final class a$5
  extends com.tencent.mm.plugin.fts.a.a.a
{
  a$5(a parama) {}
  
  public final boolean execute()
  {
    AppMethodBeat.i(184136);
    Object localObject = new com.tencent.mm.x.a();
    ((n)g.ad(n.class)).registerIndexStorage((i)localObject);
    ((i)localObject).create();
    localObject = new b();
    ((n)g.ad(n.class)).registerNativeLogic(9, (k)localObject);
    ((k)localObject).create();
    localObject = new com.tencent.mm.x.a.a();
    ((n)g.ad(n.class)).registerFTSUILogic((d)localObject);
    AppMethodBeat.o(184136);
    return true;
  }
  
  public final String getName()
  {
    return "InitFTSFriendPluginTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.a.5
 * JD-Core Version:    0.7.0.1
 */