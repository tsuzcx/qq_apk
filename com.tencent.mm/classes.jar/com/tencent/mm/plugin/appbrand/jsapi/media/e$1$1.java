package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class e$1$1
  implements Runnable
{
  e$1$1(e.1 param1, ArrayList paramArrayList) {}
  
  public final void run()
  {
    AppMethodBeat.i(131214);
    JSONArray localJSONArray = new JSONArray();
    Object localObject1 = this.hRl.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      MsgFile localMsgFile = (MsgFile)((Iterator)localObject1).next();
      Object localObject2;
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if ((bo.isNullOrNil(localMsgFile.filePath)) || (!com.tencent.mm.vfs.e.cN(localMsgFile.filePath))) {
          break label237;
        }
        localObject2 = new File(localMsgFile.filePath);
        com.tencent.mm.plugin.appbrand.s.j localj = new com.tencent.mm.plugin.appbrand.s.j();
        localObject2 = this.hRm.hKB.wX().a((File)localObject2, localMsgFile.elt, false, localj);
        if (localObject2 != com.tencent.mm.plugin.appbrand.appstorage.j.gZA) {
          break label214;
        }
        localJSONObject.put("path", localj.value);
        localJSONObject.put("name", localMsgFile.fileName);
        localJSONObject.put("size", localMsgFile.fileSize);
        localJSONObject.put("type", localMsgFile.type);
        localJSONObject.put("time", localMsgFile.timeStamp);
        localJSONArray.put(localJSONObject);
      }
      catch (JSONException localJSONException2)
      {
        d.printErrStackTrace("MicroMsg.JsApiChooseMessageFile", localJSONException2, "", new Object[0]);
      }
      continue;
      label214:
      d.e("MicroMsg.JsApiChooseMessageFile", "msgFile:%s result:%s", new Object[] { localJSONException2, localObject2 });
      continue;
      label237:
      d.e("MicroMsg.JsApiChooseMessageFile", "msgFile:%s is not exist", new Object[] { localJSONException2.filePath });
    }
    localObject1 = new JSONObject();
    try
    {
      ((JSONObject)localObject1).put("errMsg", this.hRm.hRk.getName() + ":ok");
      ((JSONObject)localObject1).put("tempFiles", localJSONArray);
      d.i("MicroMsg.JsApiChooseMessageFile", "chooseMessageFile:%s", new Object[] { ((JSONObject)localObject1).toString() });
      this.hRm.hKB.h(this.hRm.bAX, ((JSONObject)localObject1).toString());
      AppMethodBeat.o(131214);
      return;
    }
    catch (JSONException localJSONException1)
    {
      for (;;)
      {
        d.printErrStackTrace("MicroMsg.JsApiChooseMessageFile", localJSONException1, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.e.1.1
 * JD-Core Version:    0.7.0.1
 */