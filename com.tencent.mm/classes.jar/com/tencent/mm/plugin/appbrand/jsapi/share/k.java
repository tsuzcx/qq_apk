package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.app.Activity;
import android.content.Intent;
import com.tencent.luggage.h.f.c;
import com.tencent.luggage.sdk.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.utils.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity.a;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

public final class k
  extends d<com.tencent.mm.plugin.appbrand.jsapi.f>
{
  public static final int CTRL_INDEX = 801;
  public static final String NAME = "shareImageMessage";
  final int mrM;
  
  public k()
  {
    AppMethodBeat.i(180271);
    this.mrM = a.aK(this);
    AppMethodBeat.o(180271);
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.f paramf, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(180272);
    if (paramf == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiShareImageMessage", "invoke, env is null");
      AppMethodBeat.o(180272);
      return;
    }
    if (paramJSONObject == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiShareImageMessage", "invoke, data is null");
      paramf.i(paramInt, h("fail:data is null", null));
      AppMethodBeat.o(180272);
      return;
    }
    if (!paramJSONObject.has("imagePath"))
    {
      Log.w("MicroMsg.AppBrand.JsApiShareImageMessage", "invoke, data is null or can not find imagePath");
      paramf.i(paramInt, h("fail:imagePath is null", null));
      AppMethodBeat.o(180272);
      return;
    }
    String str = paramJSONObject.optString("imagePath");
    if (Util.isNullOrNil(str))
    {
      Log.w("MicroMsg.AppBrand.JsApiShareImageMessage", "invoke, imagePath is null");
      paramf.i(paramInt, h("fail:imagePath is null", null));
      AppMethodBeat.o(180272);
      return;
    }
    paramJSONObject = paramJSONObject.optString("quality", "compressed");
    label141:
    switch (paramJSONObject.hashCode())
    {
    default: 
      label172:
      i = -1;
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        paramJSONObject = "compressed";
        break label141;
        if (!paramJSONObject.equals("raw")) {
          break label172;
        }
        i = 0;
        continue;
        if (!paramJSONObject.equals("compressed")) {
          break label172;
        }
        i = 1;
      }
    }
    for (final int i = 1;; i = 0)
    {
      Log.i("MicroMsg.AppBrand.JsApiShareImageMessage", "invoke, imagePath: %s, compressType: %d", new Object[] { str, Integer.valueOf(i) });
      com.tencent.mm.plugin.appbrand.utils.c.a(paramf, str, null, new c.a()
      {
        public final void Wz(final String paramAnonymousString)
        {
          AppMethodBeat.i(180270);
          Log.i("MicroMsg.AppBrand.JsApiShareImageMessage", "invoke, localPath: ".concat(String.valueOf(paramAnonymousString)));
          if (Util.isNullOrNil(paramAnonymousString))
          {
            paramf.i(paramInt, k.this.h("fail:imagePath is illegal", null));
            AppMethodBeat.o(180270);
            return;
          }
          Object localObject = paramf.getContext();
          if ((localObject instanceof Activity))
          {
            localObject = (Activity)localObject;
            final MMActivity.a local1 = new MMActivity.a()
            {
              public final void d(int paramAnonymous2Int1, int paramAnonymous2Int2, Intent paramAnonymous2Intent)
              {
                AppMethodBeat.i(180267);
                if (paramAnonymous2Int1 != k.this.mrM)
                {
                  Log.i("MicroMsg.AppBrand.JsApiShareImageMessage", "invoke, requestCode: %d is not match", new Object[] { Integer.valueOf(paramAnonymous2Int1) });
                  AppMethodBeat.o(180267);
                  return;
                }
                if (paramAnonymous2Int2 != -1)
                {
                  Log.i("MicroMsg.AppBrand.JsApiShareImageMessage", "invoke, resultCode is not RESULT_OK: ".concat(String.valueOf(paramAnonymous2Int2)));
                  k.1.this.lDL.i(k.1.this.cvP, k.this.h("cancel", null));
                  AppMethodBeat.o(180267);
                  return;
                }
                if (paramAnonymous2Intent == null) {}
                for (paramAnonymous2Intent = null; (paramAnonymous2Intent == null) || (paramAnonymous2Intent.isEmpty()); paramAnonymous2Intent = paramAnonymous2Intent.getStringArrayListExtra("SendMsgUsernames"))
                {
                  Log.w("MicroMsg.AppBrand.JsApiShareImageMessage", "invoke, toUsers is empty");
                  k.1.this.lDL.i(k.1.this.cvP, k.this.h("fail:selected user is empty", null));
                  AppMethodBeat.o(180267);
                  return;
                }
                Log.i("MicroMsg.AppBrand.JsApiShareImageMessage", "invoke, toUser: " + Arrays.toString(paramAnonymous2Intent.toArray()));
                k.1.this.lDL.i(k.1.this.cvP, k.this.h("ok", null));
                AppMethodBeat.o(180267);
              }
            };
            paramf.P(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(180269);
                com.tencent.luggage.h.f.aK(this.val$activity).b(new f.c()
                {
                  public final boolean c(int paramAnonymous3Int1, int paramAnonymous3Int2, Intent paramAnonymous3Intent)
                  {
                    AppMethodBeat.i(180268);
                    if (k.this.mrM != paramAnonymous3Int1)
                    {
                      AppMethodBeat.o(180268);
                      return false;
                    }
                    k.1.2.this.mmh.d(paramAnonymous3Int1, paramAnonymous3Int2, paramAnonymous3Intent);
                    AppMethodBeat.o(180268);
                    return true;
                  }
                });
                Intent localIntent = new Intent();
                localIntent.putExtra("Retr_File_Name", paramAnonymousString);
                localIntent.putExtra("Retr_Compress_Type", k.1.this.iYM);
                localIntent.putExtra("Retr_Msg_Type", 0);
                com.tencent.mm.br.c.c(this.val$activity, ".ui.transmit.MsgRetransmitUI", localIntent, k.this.mrM);
                AppMethodBeat.o(180269);
              }
            });
            AppMethodBeat.o(180270);
            return;
          }
          Log.w("MicroMsg.AppBrand.JsApiShareImageMessage", "invoke, activity is null");
          paramf.i(paramInt, k.this.h("fail:activity is null", null));
          AppMethodBeat.o(180270);
        }
      });
      AppMethodBeat.o(180272);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.k
 * JD-Core Version:    0.7.0.1
 */