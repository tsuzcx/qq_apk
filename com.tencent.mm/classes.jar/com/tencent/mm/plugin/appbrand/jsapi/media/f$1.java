package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.choosemsgfile.compat.a.a;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.ac.m.a;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class f$1
  implements a.a
{
  f$1(f paramf, j paramj, int paramInt) {}
  
  public final void a(int paramInt, String paramString, final ArrayList<MsgFile> paramArrayList)
  {
    AppMethodBeat.i(46491);
    Log.i("MicroMsg.JsApiChooseMessageFile", "resultCode:%d filePaths:%s", new Object[] { Integer.valueOf(paramInt), paramArrayList });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(46491);
      return;
      com.tencent.mm.plugin.appbrand.ac.m.clV().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(46490);
          JSONArray localJSONArray = new JSONArray();
          Iterator localIterator = paramArrayList.iterator();
          while (localIterator.hasNext())
          {
            MsgFile localMsgFile = (MsgFile)localIterator.next();
            Object localObject3;
            for (;;)
            {
              try
              {
                JSONObject localJSONObject = new JSONObject();
                if ((Util.isNullOrNil(localMsgFile.filePath)) || (!u.agG(localMsgFile.filePath))) {
                  break label417;
                }
                if ("image".equals(localMsgFile.type))
                {
                  int i = BackwardSupportUtil.ExifHelper.getExifOrientation(localMsgFile.filePath);
                  if (i != 0)
                  {
                    localObject3 = f.1.this.paP.getFileSystem().adN(localMsgFile.fileName);
                    if (localObject3 == null) {
                      break label383;
                    }
                    boolean bool = "png".equals(localMsgFile.jmx);
                    String str = localMsgFile.filePath;
                    if (!bool) {
                      break label376;
                    }
                    localObject1 = Bitmap.CompressFormat.PNG;
                    bool = BitmapUtil.rotate(str, i, (Bitmap.CompressFormat)localObject1, 100, ((q)localObject3).bOF());
                    if (bool)
                    {
                      localMsgFile.filePath = ((q)localObject3).bOF();
                      localMsgFile.fileSize = ((int)((q)localObject3).length());
                    }
                    Log.i("MicroMsg.JsApiChooseMessageFile", "isOk:%b degree:%d msgFile:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), localMsgFile });
                  }
                }
                localObject3 = new q(localMsgFile.filePath);
                Object localObject1 = new i();
                localObject3 = f.1.this.paP.getFileSystem().a((q)localObject3, localMsgFile.jmx, false, (i)localObject1);
                if (localObject3 != com.tencent.mm.plugin.appbrand.appstorage.m.nMR) {
                  break label393;
                }
                localJSONObject.put("path", ((i)localObject1).value);
                localJSONObject.put("name", localMsgFile.fileName);
                localJSONObject.put("size", localMsgFile.fileSize);
                localJSONObject.put("type", localMsgFile.type);
                localJSONObject.put("time", localMsgFile.timeStamp);
                localJSONArray.put(localJSONObject);
              }
              catch (JSONException localJSONException1)
              {
                Log.printErrStackTrace("MicroMsg.JsApiChooseMessageFile", localJSONException1, "", new Object[0]);
              }
              break;
              label376:
              localObject2 = Bitmap.CompressFormat.JPEG;
              continue;
              label383:
              Log.e("MicroMsg.JsApiChooseMessageFile", "allocTempFile failed");
            }
            label393:
            Log.e("MicroMsg.JsApiChooseMessageFile", "msgFile:%s result:%s", new Object[] { localMsgFile, localObject3 });
            continue;
            label417:
            Log.e("MicroMsg.JsApiChooseMessageFile", "msgFile:%s is not exist", new Object[] { localMsgFile.filePath });
          }
          Object localObject2 = new JSONObject();
          try
          {
            ((JSONObject)localObject2).put("errMsg", f.1.this.paQ.getName() + ":ok");
            ((JSONObject)localObject2).put("tempFiles", localJSONArray);
            Log.i("MicroMsg.JsApiChooseMessageFile", "chooseMessageFile:%s", new Object[] { ((JSONObject)localObject2).toString() });
            f.1.this.paP.j(f.1.this.cuf, ((JSONObject)localObject2).toString());
            AppMethodBeat.o(46490);
            return;
          }
          catch (JSONException localJSONException2)
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.JsApiChooseMessageFile", localJSONException2, "", new Object[0]);
            }
          }
        }
      });
      AppMethodBeat.o(46491);
      return;
      if (Util.isNullOrNil(paramString))
      {
        this.paP.j(this.cuf, this.paQ.h("fail", null));
        AppMethodBeat.o(46491);
        return;
      }
      this.paP.j(this.cuf, this.paQ.h("fail:".concat(String.valueOf(paramString)), null));
      AppMethodBeat.o(46491);
      return;
      this.paP.j(this.cuf, this.paQ.h("fail:cancel", null));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.f.1
 * JD-Core Version:    0.7.0.1
 */