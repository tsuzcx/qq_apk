package com.tencent.mm.plugin.fav;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.b.a.b;
import com.tencent.mm.plugin.fts.a.i;
import com.tencent.mm.plugin.fts.a.k;
import com.tencent.mm.plugin.fts.a.n;

final class PluginFav$1
  extends com.tencent.mm.plugin.fts.a.a.a
{
  PluginFav$1(PluginFav paramPluginFav) {}
  
  public final boolean execute()
  {
    Object localObject = new com.tencent.mm.plugin.fav.b.a.a();
    ((n)g.t(n.class)).registerIndexStorage((i)localObject);
    ((i)localObject).create();
    localObject = new b();
    ((n)g.t(n.class)).registerNativeLogic(6, (k)localObject);
    ((k)localObject).create();
    return true;
  }
  
  public final String getName()
  {
    return "InitFTSFavPluginTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.PluginFav.1
 * JD-Core Version:    0.7.0.1
 */