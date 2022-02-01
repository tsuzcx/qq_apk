package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.protocal.protobuf.aoe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.List;

final class ab$3
  implements com.tencent.mm.plugin.multitask.c.a
{
  ab$3(ab paramab) {}
  
  public final void bC(List<MultiTaskInfo> paramList)
  {
    AppMethodBeat.i(226770);
    paramList = paramList.iterator();
    for (;;)
    {
      if (paramList.hasNext())
      {
        MultiTaskInfo localMultiTaskInfo = (MultiTaskInfo)paramList.next();
        if ((localMultiTaskInfo == null) || (localMultiTaskInfo.field_type != 4) || (localMultiTaskInfo.field_data == null)) {
          continue;
        }
        aoe localaoe = new aoe();
        try
        {
          localaoe.parseFrom(localMultiTaskInfo.field_data);
          if ((Util.nullAsNil(localaoe.appId).equals(ab.d(this.lVq))) && (ab.a(this.lVq) != null)) {
            ab.a(this.lVq).acQ(MMApplicationContext.getProcessName());
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            Log.e("MicroMsg.AppBrand.JsApiOpenDocument", "handleMultiTaskInfoClicked", new Object[] { localThrowable });
          }
        }
      }
    }
    AppMethodBeat.o(226770);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.ab.3
 * JD-Core Version:    0.7.0.1
 */