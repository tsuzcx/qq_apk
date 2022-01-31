package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.os.Bundle;
import com.tencent.mm.protocal.c.bna;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import java.util.LinkedList;

final class JsApiOperateWXData$OperateWXDataTask$1
  implements JsApiOperateWXData.OperateWXDataTask.a
{
  JsApiOperateWXData$OperateWXDataTask$1(JsApiOperateWXData.OperateWXDataTask paramOperateWXDataTask) {}
  
  public final void a(LinkedList<bna> paramLinkedList, String paramString1, String paramString2)
  {
    y.d("MicroMsg.JsApiOperateWXData", "onConfirm !");
    this.gka.gjO = paramLinkedList.size();
    int i = 0;
    while (i < this.gka.gjO)
    {
      bna localbna = (bna)paramLinkedList.get(i);
      try
      {
        this.gka.gjP.putByteArray(String.valueOf(i), localbna.toByteArray());
        i += 1;
      }
      catch (IOException paramLinkedList)
      {
        y.e("MicroMsg.JsApiOperateWXData", "IOException %s", new Object[] { paramLinkedList.getMessage() });
        y.printErrStackTrace("MicroMsg.JsApiOperateWXData", paramLinkedList, "", new Object[0]);
        this.gka.gjM = "fail";
        JsApiOperateWXData.OperateWXDataTask.c(this.gka);
        return;
      }
    }
    this.gka.mAppName = paramString1;
    this.gka.fXS = paramString2;
    this.gka.gjM = "needConfirm";
    JsApiOperateWXData.OperateWXDataTask.d(this.gka);
  }
  
  public final void fM(String paramString)
  {
    y.e("MicroMsg.JsApiOperateWXData", "onFailure !");
    this.gka.gjM = ("fail:" + paramString);
    JsApiOperateWXData.OperateWXDataTask.b(this.gka);
  }
  
  public final void onSuccess(String paramString)
  {
    y.d("MicroMsg.JsApiOperateWXData", "onSuccess !");
    this.gka.gjY = paramString;
    this.gka.gjM = "ok";
    JsApiOperateWXData.OperateWXDataTask.a(this.gka);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData.OperateWXDataTask.1
 * JD-Core Version:    0.7.0.1
 */