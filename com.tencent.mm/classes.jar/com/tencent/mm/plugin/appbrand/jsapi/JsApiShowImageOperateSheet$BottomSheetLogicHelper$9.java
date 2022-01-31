package com.tencent.mm.plugin.appbrand.jsapi;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.j;

final class JsApiShowImageOperateSheet$BottomSheetLogicHelper$9
  implements Runnable
{
  JsApiShowImageOperateSheet$BottomSheetLogicHelper$9(JsApiShowImageOperateSheet.BottomSheetLogicHelper paramBottomSheetLogicHelper, b paramb, Bitmap paramBitmap1, Bitmap paramBitmap2) {}
  
  public final void run()
  {
    AppMethodBeat.i(143260);
    String str1 = j.p(this.hAa.dQJ());
    String str2 = j.p(this.hAa.dQJ()) + "_full";
    ab.i("MicroMsg.JsApiShowImageOperateSheet", "processRecognizeQRCodeLogic capturePath:%s", new Object[] { str1 });
    JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeParam localIPCQRCodeRecognizeParam = new JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeParam();
    for (;;)
    {
      try
      {
        d.a(this.hAb, 100, Bitmap.CompressFormat.JPEG, str2, true);
        JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeParam.a(localIPCQRCodeRecognizeParam, str2);
        if ((this.hAc == null) || (this.hAc.isRecycled())) {
          continue;
        }
        d.a(this.hAc, 100, Bitmap.CompressFormat.JPEG, str1, true);
        JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeParam.a(localIPCQRCodeRecognizeParam, str1);
        JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeParam.b(localIPCQRCodeRecognizeParam, str2);
        if ((this.hAc != null) && (!this.hAc.isRecycled()))
        {
          ab.i("MicroMsg.JsApiShowImageOperateSheet", "bitmap recycle %s", new Object[] { this.hAc });
          this.hAc.recycle();
        }
        if ((this.hAb != null) && (!this.hAb.isRecycled())) {
          this.hAb.recycle();
        }
      }
      catch (Exception localException)
      {
        ab.w("MicroMsg.JsApiShowImageOperateSheet", "save temp bitmap to file failed, . exception : %s", new Object[] { localException });
        if ((this.hAc == null) || (this.hAc.isRecycled())) {
          continue;
        }
        ab.i("MicroMsg.JsApiShowImageOperateSheet", "bitmap recycle %s", new Object[] { this.hAc });
        this.hAc.recycle();
        if ((this.hAb == null) || (this.hAb.isRecycled())) {
          continue;
        }
        this.hAb.recycle();
        continue;
      }
      finally
      {
        if ((this.hAc == null) || (this.hAc.isRecycled())) {
          continue;
        }
        ab.i("MicroMsg.JsApiShowImageOperateSheet", "bitmap recycle %s", new Object[] { this.hAc });
        this.hAc.recycle();
        if ((this.hAb == null) || (this.hAb.isRecycled())) {
          continue;
        }
        this.hAb.recycle();
        AppMethodBeat.o(143260);
      }
      f.a("com.tencent.mm", localIPCQRCodeRecognizeParam, JsApiShowImageOperateSheet.BottomSheetLogicHelper.c.class, new c() {});
      AppMethodBeat.o(143260);
      return;
      JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeParam.b(localIPCQRCodeRecognizeParam, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet.BottomSheetLogicHelper.9
 * JD-Core Version:    0.7.0.1
 */