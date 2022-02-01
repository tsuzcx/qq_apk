package com.tencent.mm.plugin.appbrand.jsapi.e;

import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.k;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.utils.x;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.xeffect.FaceTracker;
import com.tencent.mm.xeffect.XEffectLog;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.g.b.p;
import org.json.JSONObject;

final class b$1
  implements Runnable
{
  b$1(b paramb, a parama, s params, int paramInt, JSONObject paramJSONObject) {}
  
  public final void run()
  {
    AppMethodBeat.i(226763);
    Object localObject1 = new HashMap(1);
    if (this.lUb.lTN == null)
    {
      Log.e("MicroMsg.JsApiFaceDetect", "hy: not prepared effect!");
      ((HashMap)localObject1).put("errCode", Integer.valueOf(a.a(a.a.lTU)));
      this.lsQ.i(this.cvP, this.lUc.n("fail: not started yet", (Map)localObject1));
      AppMethodBeat.o(226763);
      return;
    }
    ByteBuffer localByteBuffer;
    int i;
    int j;
    a locala;
    HashMap localHashMap;
    if ((this.cvS.has("frameBuffer")) && (this.cvS.has("width")) && (this.cvS.has("height")))
    {
      localByteBuffer = (ByteBuffer)this.cvS.opt("frameBuffer");
      i = this.cvS.optInt("width");
      j = this.cvS.optInt("height");
      if ((localByteBuffer == null) || (i < 0) || (j < 0))
      {
        Log.e("MicroMsg.JsApiFaceDetect", "hy: invalid params when detect");
        ((HashMap)localObject1).put("errCode", Integer.valueOf(a.a(a.a.lTW)));
        this.lsQ.i(this.cvP, this.lUc.n("fail: not valid params when detect frame buffer", (Map)localObject1));
        AppMethodBeat.o(226763);
        return;
      }
      locala = this.lUb;
      localHashMap = new HashMap(1);
      if ((a.lTL == null) || (a.lTL.lTN == null))
      {
        localHashMap.put("errCode", Integer.valueOf(a.a(a.a.lTS)));
        if (localByteBuffer.isDirect())
        {
          localObject1 = (k)this.lsQ.getJsRuntime().R(k.class);
          if (localObject1 == null) {
            Log.w("MicroMsg.NativeBufferUtil", "hy: no buffer addon support");
          }
        }
        else
        {
          label303:
          if (!Objects.equals(localHashMap.get("errCode"), Integer.valueOf(a.a(a.a.lTR)))) {
            break label877;
          }
          this.lsQ.i(this.cvP, this.lUc.n("ok", localHashMap));
          AppMethodBeat.o(226763);
        }
      }
      else
      {
        if (localByteBuffer.isDirect()) {
          break label968;
        }
        localObject1 = x.q(localByteBuffer).order(ByteOrder.nativeOrder());
        ((ByteBuffer)localObject1).position(0);
      }
    }
    for (;;)
    {
      Object localObject2 = a.lTL.lTN;
      p.h(localObject1, "data");
      if (((FaceTracker)localObject2).Rxd != 0L)
      {
        i = ((FaceTracker)localObject2).nDetect(((FaceTracker)localObject2).Rxd, (Buffer)localObject1, i, j);
        label424:
        localObject2 = a.lTL.lTN;
        localObject1 = new RectF();
        localObject2 = ((FaceTracker)localObject2).nGetFaceRect(((FaceTracker)localObject2).Rxd);
        if (localObject2 != null) {
          break label655;
        }
      }
      for (;;)
      {
        if ((i != 0) || (((RectF)localObject1).isEmpty())) {
          break label724;
        }
        localHashMap.put("errCode", Integer.valueOf(a.a(a.a.lTR)));
        locala.aTD = ((RectF)localObject1).centerX();
        locala.aTE = ((RectF)localObject1).centerY();
        localHashMap.put("x", Float.valueOf(locala.aTD));
        localHashMap.put("y", Float.valueOf(locala.aTE));
        locala.lTP.put("originX", Float.valueOf(((RectF)localObject1).centerX() - ((RectF)localObject1).width() / 2.0F));
        locala.lTP.put("originY", Float.valueOf(((RectF)localObject1).centerY() - ((RectF)localObject1).height() / 2.0F));
        locala.lTP.put("width", Float.valueOf(((RectF)localObject1).width()));
        locala.lTP.put("height", Float.valueOf(((RectF)localObject1).height()));
        localHashMap.put("detectRect", locala.lTP);
        break;
        i = -1;
        break label424;
        label655:
        float f1 = localObject2[0];
        float f2 = localObject2[1];
        float f3 = localObject2[0];
        float f4 = localObject2[2];
        float f5 = localObject2[1];
        ((RectF)localObject1).set(f1, f2, f3 + f4, localObject2[3] + f5);
        XEffectLog.d("FaceTracker", "rect is ".concat(String.valueOf(localObject1)), new Object[0]);
      }
      label724:
      localHashMap.put("x", Float.valueOf(locala.aTD));
      localHashMap.put("y", Float.valueOf(locala.aTE));
      if (locala.lTP.isEmpty())
      {
        locala.lTP.put("originX", Float.valueOf(-1.0F));
        locala.lTP.put("originY", Float.valueOf(-1.0F));
        locala.lTP.put("width", Float.valueOf(0.0F));
        locala.lTP.put("height", Float.valueOf(0.0F));
      }
      localHashMap.put("detectRect", locala.lTP);
      localHashMap.put("errCode", Integer.valueOf(a.a(a.a.lTW)));
      break;
      ((k)localObject1).releaseDirectByteBuffer(localByteBuffer);
      break label303;
      label877:
      Log.w("MicroMsg.JsApiFaceDetect", "hy: face detect failed");
      this.lsQ.i(this.cvP, this.lUc.n("fail: face detect failed", localHashMap));
      AppMethodBeat.o(226763);
      return;
      Log.e("MicroMsg.JsApiFaceDetect", "hy: not given framebuffer");
      ((HashMap)localObject1).put("errCode", Integer.valueOf(a.a(a.a.lTW)));
      this.lsQ.i(this.cvP, this.lUc.n("fail: not given framebuffer or size", (Map)localObject1));
      AppMethodBeat.o(226763);
      return;
      label968:
      localObject1 = localByteBuffer;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.e.b.1
 * JD-Core Version:    0.7.0.1
 */