package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.sdk.d.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import org.json.JSONObject;

final class q$1
  extends c
{
  q$1(q paramq) {}
  
  public final void enter()
  {
    AppMethodBeat.i(129350);
    super.enter();
    ab.i("MicroMsg.LibIncrementalTestCase[incremental]", "WriteMockLibInfo enter");
    Object localObject2 = an.avL();
    if (bo.isNullOrNil((String)localObject2))
    {
      q.a(this.gUt, "!!MockLibInfo Path Error!!");
      AppMethodBeat.o(129350);
      return;
    }
    try
    {
      Object localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("version", q.a(this.gUt));
      localObject2 = new File((String)localObject2);
      ((File)localObject2).delete();
      ((File)localObject2).createNewFile();
      localObject1 = ((JSONObject)localObject1).toString().getBytes("UTF-8");
      int i = e.b(((File)localObject2).getAbsolutePath(), (byte[])localObject1, localObject1.length);
      if (i != 0)
      {
        q.a(this.gUt, "MockLibInfo Write Error ".concat(String.valueOf(i)));
        AppMethodBeat.o(129350);
        return;
      }
    }
    catch (Exception localException)
    {
      q.a(this.gUt, "MockLibInfo Write Exception " + localException.getMessage());
      AppMethodBeat.o(129350);
      return;
    }
    q.a(this.gUt, q.b(this.gUt));
    AppMethodBeat.o(129350);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.q.1
 * JD-Core Version:    0.7.0.1
 */