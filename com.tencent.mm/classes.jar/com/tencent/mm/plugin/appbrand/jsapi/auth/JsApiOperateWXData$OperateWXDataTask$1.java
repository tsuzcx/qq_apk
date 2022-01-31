package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.protocal.protobuf.bwv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;
import org.apache.commons.b.g;

final class JsApiOperateWXData$OperateWXDataTask$1
  implements JsApiOperateWXData.OperateWXDataTask.a
{
  JsApiOperateWXData$OperateWXDataTask$1(JsApiOperateWXData.OperateWXDataTask paramOperateWXDataTask) {}
  
  public final void a(LinkedList<bwv> paramLinkedList, String paramString1, String paramString2)
  {
    AppMethodBeat.i(130878);
    ab.d("MicroMsg.AppBrand.JsApiOperateWXData", "onConfirm !");
    this.hDY.hDH = paramLinkedList.size();
    int i = 0;
    while (i < this.hDY.hDH)
    {
      bwv localbwv = (bwv)paramLinkedList.get(i);
      try
      {
        this.hDY.hDX.put(String.valueOf(i), localbwv.toByteArray());
        i += 1;
      }
      catch (IOException paramLinkedList)
      {
        ab.e("MicroMsg.AppBrand.JsApiOperateWXData", "IOException %s", new Object[] { paramLinkedList.getMessage() });
        ab.printErrStackTrace("MicroMsg.AppBrand.JsApiOperateWXData", paramLinkedList, "", new Object[0]);
        this.hDY.hDz = "fail";
        JsApiOperateWXData.OperateWXDataTask.d(this.hDY);
        AppMethodBeat.o(130878);
        return;
      }
    }
    this.hDY.mAppName = paramString1;
    this.hDY.hDB = paramString2;
    this.hDY.hDz = "needConfirm";
    if ((paramLinkedList.size() > 0) && ("scope.userInfo".equals(((bwv)paramLinkedList.get(0)).wAh)))
    {
      this.hDY.hDG = r.Zp();
      paramString1 = new StringBuilder("userNickName=");
      if (this.hDY.hDG == null) {}
      for (paramLinkedList = "";; paramLinkedList = this.hDY.hDG)
      {
        ab.i("MicroMsg.AppBrand.JsApiOperateWXData", paramLinkedList);
        paramLinkedList = r.Zn();
        paramString1 = e.hDq;
        e.a.a(paramLinkedList, new JsApiOperateWXData.OperateWXDataTask.1.1(this));
        AppMethodBeat.o(130878);
        return;
      }
    }
    JsApiOperateWXData.OperateWXDataTask.f(this.hDY);
    AppMethodBeat.o(130878);
  }
  
  public final void bU(String paramString)
  {
    AppMethodBeat.i(130877);
    ab.e("MicroMsg.AppBrand.JsApiOperateWXData", "onFailure !");
    this.hDY.hDz = "fail:".concat(String.valueOf(paramString));
    JsApiOperateWXData.OperateWXDataTask.c(this.hDY);
    AppMethodBeat.o(130877);
  }
  
  public final void onSuccess(String paramString)
  {
    AppMethodBeat.i(130876);
    ab.d("MicroMsg.AppBrand.JsApiOperateWXData", "onSuccess !");
    try
    {
      this.hDY.hDV = g.b(new String[] { this.hDY.appId, JsApiOperateWXData.OperateWXDataTask.a(this.hDY), this.hDY.hry, bo.yB() }, "$");
      JsApiOperateWXData.OperateWXDataTask.aBZ().putString(this.hDY.hDV, paramString).commit();
      if (TextUtils.isEmpty(JsApiOperateWXData.OperateWXDataTask.aBZ().getString(this.hDY.hDV, null)))
      {
        IOException localIOException = new IOException("write data failed");
        AppMethodBeat.o(130876);
        throw localIOException;
      }
    }
    catch (Throwable localThrowable)
    {
      ab.e("MicroMsg.AppBrand.JsApiOperateWXData", "runInMainProcess::onSuccess, write to XProcessStore failed, appId[%s], callbackId[%d] e=%s", new Object[] { this.hDY.appId, Integer.valueOf(this.hDY.hry), localThrowable });
      this.hDY.hDV = null;
      JsApiOperateWXData.hz(1L);
      if (TextUtils.isEmpty(this.hDY.hDV)) {
        this.hDY.hDU = paramString;
      }
      for (;;)
      {
        this.hDY.hDz = "ok";
        JsApiOperateWXData.OperateWXDataTask.b(this.hDY);
        AppMethodBeat.o(130876);
        return;
        JsApiOperateWXData.hz(0L);
        if (TextUtils.isEmpty(this.hDY.hDV)) {
          this.hDY.hDU = paramString;
        }
      }
    }
    finally
    {
      if (TextUtils.isEmpty(this.hDY.hDV)) {
        this.hDY.hDU = paramString;
      }
      AppMethodBeat.o(130876);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData.OperateWXDataTask.1
 * JD-Core Version:    0.7.0.1
 */