package com.tencent.mm.plugin.account;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.d.d;
import com.tencent.mm.plugin.fts.a.i;
import com.tencent.mm.plugin.fts.a.k;
import com.tencent.mm.plugin.fts.a.n;

final class b$4
  extends com.tencent.mm.plugin.fts.a.a.a
{
  b$4(b paramb) {}
  
  public final boolean execute()
  {
    Object localObject = new com.tencent.mm.x.a();
    ((n)g.t(n.class)).registerIndexStorage((i)localObject);
    ((i)localObject).create();
    localObject = new com.tencent.mm.x.b();
    ((n)g.t(n.class)).registerNativeLogic(9, (k)localObject);
    ((k)localObject).create();
    localObject = new com.tencent.mm.x.a.a();
    ((n)g.t(n.class)).registerFTSUILogic((d)localObject);
    return true;
  }
  
  public final String getName()
  {
    return "InitFTSFriendPluginTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.b.4
 * JD-Core Version:    0.7.0.1
 */