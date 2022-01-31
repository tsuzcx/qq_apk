package com.tencent.mm.plugin.fts.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
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
    AppMethodBeat.i(136723);
    Object localObject = b.Pl(this.path);
    this.mUJ.mUI.beginTransaction();
    this.mUJ.mUI.bW((List)localObject);
    this.mUJ.mUI.commit();
    this.mUJ.mUI.u(c.mQC);
    this.mUJ.ezf.a(131132, new b.a(this.mUJ, (byte)0));
    localObject = ((PluginFTS)g.G(PluginFTS.class)).getTopHitsLogic();
    int[] arrayOfInt = c.mQC;
    ((e)localObject).mVl.g(arrayOfInt, 1);
    AppMethodBeat.o(136723);
    return true;
  }
  
  public final String getName()
  {
    return "UpdateFeatureIndexTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.b.d
 * JD-Core Version:    0.7.0.1
 */