package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.a.e;
import com.tencent.mm.sdk.d.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import org.json.JSONObject;

final class k$1
  extends c
{
  k$1(k paramk) {}
  
  public final void enter()
  {
    super.enter();
    y.i("MicroMsg.LibIncrementalTestCase[incremental]", "WriteMockLibInfo enter");
    Object localObject2 = ah.abU();
    if (bk.bl((String)localObject2))
    {
      k.a(this.fCg, "!!MockLibInfo Path Error!!");
      return;
    }
    try
    {
      Object localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("version", k.a(this.fCg));
      localObject2 = new File((String)localObject2);
      ((File)localObject2).delete();
      ((File)localObject2).createNewFile();
      localObject1 = ((JSONObject)localObject1).toString().getBytes("UTF-8");
      int i = e.b(((File)localObject2).getAbsolutePath(), (byte[])localObject1, localObject1.length);
      if (i != 0)
      {
        k.a(this.fCg, "MockLibInfo Write Error " + i);
        return;
      }
    }
    catch (Exception localException)
    {
      k.a(this.fCg, "MockLibInfo Write Exception " + localException.getMessage());
      return;
    }
    k.a(this.fCg, k.b(this.fCg));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.k.1
 * JD-Core Version:    0.7.0.1
 */