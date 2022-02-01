package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.choosemsgfile.compat.a.a;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.z.m.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.q;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class f$1
  implements a.a
{
  f$1(f paramf, h paramh, int paramInt) {}
  
  public final void a(int paramInt, String paramString, final ArrayList<MsgFile> paramArrayList)
  {
    AppMethodBeat.i(46491);
    ad.i("MicroMsg.JsApiChooseMessageFile", "resultCode:%d filePaths:%s", new Object[] { Integer.valueOf(paramInt), paramArrayList });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(46491);
      return;
      com.tencent.mm.plugin.appbrand.z.m.bBp().postToWorker(new Runnable()
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
                if ((bt.isNullOrNil(localMsgFile.filePath)) || (!com.tencent.mm.vfs.i.fv(localMsgFile.filePath))) {
                  break label408;
                }
                if ("image".equals(localMsgFile.type))
                {
                  int i = BackwardSupportUtil.ExifHelper.cY(localMsgFile.filePath);
                  if (i != 0)
                  {
                    localObject3 = f.1.this.kUg.Fg().Ml(localMsgFile.fileName);
                    boolean bool = "png".equals(localMsgFile.fVf);
                    String str = localMsgFile.filePath;
                    if (!bool) {
                      break label377;
                    }
                    localObject1 = Bitmap.CompressFormat.PNG;
                    bool = g.a(str, i, (Bitmap.CompressFormat)localObject1, 100, q.B(((e)localObject3).fOK()));
                    if (bool)
                    {
                      localMsgFile.filePath = q.B(((e)localObject3).fOK());
                      localMsgFile.fileSize = ((int)((e)localObject3).length());
                    }
                    ad.i("MicroMsg.JsApiChooseMessageFile", "isOk:%b degree:%d msgFile:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), localMsgFile });
                  }
                }
                localObject3 = new e(localMsgFile.filePath);
                Object localObject1 = new com.tencent.mm.plugin.appbrand.z.i();
                localObject3 = f.1.this.kUg.Fg().a((e)localObject3, localMsgFile.fVf, false, (com.tencent.mm.plugin.appbrand.z.i)localObject1);
                if (localObject3 != l.jMv) {
                  break label384;
                }
                localJSONObject.put("path", ((com.tencent.mm.plugin.appbrand.z.i)localObject1).value);
                localJSONObject.put("name", localMsgFile.fileName);
                localJSONObject.put("size", localMsgFile.fileSize);
                localJSONObject.put("type", localMsgFile.type);
                localJSONObject.put("time", localMsgFile.timeStamp);
                localJSONArray.put(localJSONObject);
              }
              catch (JSONException localJSONException1)
              {
                ad.printErrStackTrace("MicroMsg.JsApiChooseMessageFile", localJSONException1, "", new Object[0]);
              }
              break;
              label377:
              localObject2 = Bitmap.CompressFormat.JPEG;
            }
            label384:
            ad.e("MicroMsg.JsApiChooseMessageFile", "msgFile:%s result:%s", new Object[] { localMsgFile, localObject3 });
            continue;
            label408:
            ad.e("MicroMsg.JsApiChooseMessageFile", "msgFile:%s is not exist", new Object[] { localMsgFile.filePath });
          }
          Object localObject2 = new JSONObject();
          try
          {
            ((JSONObject)localObject2).put("errMsg", f.1.this.kUh.getName() + ":ok");
            ((JSONObject)localObject2).put("tempFiles", localJSONArray);
            ad.i("MicroMsg.JsApiChooseMessageFile", "chooseMessageFile:%s", new Object[] { ((JSONObject)localObject2).toString() });
            f.1.this.kUg.h(f.1.this.cjQ, ((JSONObject)localObject2).toString());
            AppMethodBeat.o(46490);
            return;
          }
          catch (JSONException localJSONException2)
          {
            for (;;)
            {
              ad.printErrStackTrace("MicroMsg.JsApiChooseMessageFile", localJSONException2, "", new Object[0]);
            }
          }
        }
      });
      AppMethodBeat.o(46491);
      return;
      if (bt.isNullOrNil(paramString))
      {
        this.kUg.h(this.cjQ, this.kUh.e("fail", null));
        AppMethodBeat.o(46491);
        return;
      }
      this.kUg.h(this.cjQ, this.kUh.e("fail:".concat(String.valueOf(paramString)), null));
      AppMethodBeat.o(46491);
      return;
      this.kUg.h(this.cjQ, this.kUh.e("fail:cancel", null));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.f.1
 * JD-Core Version:    0.7.0.1
 */