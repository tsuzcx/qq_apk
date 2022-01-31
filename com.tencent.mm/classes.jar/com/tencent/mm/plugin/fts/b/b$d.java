package com.tencent.mm.plugin.fts.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.m;
import java.util.List;

final class b$d
  extends a
{
  private String path;
  
  public b$d(b paramb, String paramString)
  {
    this.path = paramString;
  }
  
  public final boolean execute()
  {
    Object localObject = b.Eb(this.path);
    this.kyU.kyT.beginTransaction();
    this.kyU.kyT.bB((List)localObject);
    this.kyU.kyT.commit();
    this.kyU.kyT.k(c.kuP);
    this.kyU.dBO.a(131132, new b.a(this.kyU, (byte)0));
    localObject = ((PluginFTS)g.t(PluginFTS.class)).getTopHitsLogic();
    int[] arrayOfInt = c.kuP;
    ((e)localObject).kzv.f(arrayOfInt, 1);
    return true;
  }
  
  public final String getName()
  {
    return "UpdateFeatureIndexTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.b.d
 * JD-Core Version:    0.7.0.1
 */