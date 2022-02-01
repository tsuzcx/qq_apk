package com.tencent.mm.plugin.appbrand.jsapi.d;

import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.k;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.utils.x;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.xeffect.FaceTracker;
import com.tencent.mm.xeffect.XEffectLog;
import d.g.b.p;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.json.JSONObject;

final class b$1
  implements Runnable
{
  b$1(b paramb, a parama, r paramr, int paramInt, JSONObject paramJSONObject) {}
  
  public final void run()
  {
    AppMethodBeat.i(222459);
    Object localObject1 = new HashMap(1);
    if (this.kPd.kOP == null)
    {
      ae.e("MicroMsg.JsApiFaceDetect", "hy: not prepared effect!");
      ((HashMap)localObject1).put("errCode", Integer.valueOf(a.a(a.a.kOW)));
      this.kph.h(this.cjS, this.kPe.n("fail: not started yet", (Map)localObject1));
      AppMethodBeat.o(222459);
      return;
    }
    ByteBuffer localByteBuffer;
    int i;
    int j;
    a locala;
    HashMap localHashMap;
    if ((this.cjV.has("frameBuffer")) && (this.cjV.has("width")) && (this.cjV.has("height")))
    {
      localByteBuffer = (ByteBuffer)this.cjV.opt("frameBuffer");
      i = this.cjV.optInt("width");
      j = this.cjV.optInt("height");
      if ((localByteBuffer == null) || (i < 0) || (j < 0))
      {
        ae.e("MicroMsg.JsApiFaceDetect", "hy: invalid params when detect");
        ((HashMap)localObject1).put("errCode", Integer.valueOf(a.a(a.a.kOY)));
        this.kph.h(this.cjS, this.kPe.n("fail: not valid params when detect frame buffer", (Map)localObject1));
        AppMethodBeat.o(222459);
        return;
      }
      locala = this.kPd;
      localHashMap = new HashMap(1);
      if ((a.kON == null) || (a.kON.kOP == null))
      {
        localHashMap.put("errCode", Integer.valueOf(a.a(a.a.kOU)));
        if (localByteBuffer.isDirect())
        {
          localObject1 = (k)this.kph.aYB().P(k.class);
          if (localObject1 == null) {
            ae.w("MicroMsg.NativeBufferUtil", "hy: no buffer addon support");
          }
        }
        else
        {
          label303:
          if (!Objects.equals(localHashMap.get("errCode"), Integer.valueOf(a.a(a.a.kOT)))) {
            break label877;
          }
          this.kph.h(this.cjS, this.kPe.n("ok", localHashMap));
          AppMethodBeat.o(222459);
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
      Object localObject2 = a.kON.kOP;
      p.h(localObject1, "data");
      if (((FaceTracker)localObject2).LYd != 0L)
      {
        i = ((FaceTracker)localObject2).nDetect(((FaceTracker)localObject2).LYd, (Buffer)localObject1, i, j);
        label424:
        localObject2 = a.kON.kOP;
        localObject1 = new RectF();
        localObject2 = ((FaceTracker)localObject2).nGetFaceRect(((FaceTracker)localObject2).LYd);
        if (localObject2 != null) {
          break label655;
        }
      }
      for (;;)
      {
        if ((i != 0) || (((RectF)localObject1).isEmpty())) {
          break label724;
        }
        localHashMap.put("errCode", Integer.valueOf(a.a(a.a.kOT)));
        locala.aTL = ((RectF)localObject1).centerX();
        locala.aTM = ((RectF)localObject1).centerY();
        localHashMap.put("x", Float.valueOf(locala.aTL));
        localHashMap.put("y", Float.valueOf(locala.aTM));
        locala.kOR.put("originX", Float.valueOf(((RectF)localObject1).centerX() - ((RectF)localObject1).width() / 2.0F));
        locala.kOR.put("originY", Float.valueOf(((RectF)localObject1).centerY() - ((RectF)localObject1).height() / 2.0F));
        locala.kOR.put("width", Float.valueOf(((RectF)localObject1).width()));
        locala.kOR.put("height", Float.valueOf(((RectF)localObject1).height()));
        localHashMap.put("detectRect", locala.kOR);
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
      localHashMap.put("x", Float.valueOf(locala.aTL));
      localHashMap.put("y", Float.valueOf(locala.aTM));
      if (locala.kOR.isEmpty())
      {
        locala.kOR.put("originX", Float.valueOf(-1.0F));
        locala.kOR.put("originY", Float.valueOf(-1.0F));
        locala.kOR.put("width", Float.valueOf(0.0F));
        locala.kOR.put("height", Float.valueOf(0.0F));
      }
      localHashMap.put("detectRect", locala.kOR);
      localHashMap.put("errCode", Integer.valueOf(a.a(a.a.kOY)));
      break;
      ((k)localObject1).releaseDirectByteBuffer(localByteBuffer);
      break label303;
      label877:
      ae.w("MicroMsg.JsApiFaceDetect", "hy: face detect failed");
      this.kph.h(this.cjS, this.kPe.n("fail: face detect failed", localHashMap));
      AppMethodBeat.o(222459);
      return;
      ae.e("MicroMsg.JsApiFaceDetect", "hy: not given framebuffer");
      ((HashMap)localObject1).put("errCode", Integer.valueOf(a.a(a.a.kOY)));
      this.kph.h(this.cjS, this.kPe.n("fail: not given framebuffer or size", (Map)localObject1));
      AppMethodBeat.o(222459);
      return;
      label968:
      localObject1 = localByteBuffer;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.d.b.1
 * JD-Core Version:    0.7.0.1
 */