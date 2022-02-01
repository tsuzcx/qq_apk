package com.tencent.mm.plugin.account;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.d.d;
import com.tencent.mm.plugin.fts.a.i;
import com.tencent.mm.plugin.fts.a.k;
import com.tencent.mm.plugin.fts.a.n;

final class b$3
  extends c
{
  b$3(b paramb) {}
  
  public final boolean aXz()
  {
    AppMethodBeat.i(184136);
    Object localObject = new com.tencent.mm.x.a();
    ((n)h.az(n.class)).registerIndexStorage((i)localObject);
    ((i)localObject).create();
    localObject = new com.tencent.mm.x.b();
    ((n)h.az(n.class)).registerNativeLogic(9, (k)localObject);
    ((k)localObject).create();
    localObject = new com.tencent.mm.x.a.a();
    ((n)h.az(n.class)).registerFTSUILogic((d)localObject);
    AppMethodBeat.o(184136);
    return true;
  }
  
  public final String getName()
  {
    return "InitFTSFriendPluginTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.b.3
 * JD-Core Version:    0.7.0.1
 */