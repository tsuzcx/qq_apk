package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.k.f;
import com.tencent.luggage.k.f.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.jsapi.dd;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.utils.e.a;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.widget.snackbar.b;
import com.tencent.mm.vfs.u;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

public final class k
  extends com.tencent.mm.plugin.appbrand.jsapi.c<e>
{
  public static final int CTRL_INDEX = 801;
  public static final String NAME = "shareImageMessage";
  final int ppU;
  
  public k()
  {
    AppMethodBeat.i(180271);
    this.ppU = com.tencent.luggage.sdk.h.a.aI(this);
    AppMethodBeat.o(180271);
  }
  
  public final void a(final e parame, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(180272);
    if (parame == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiShareImageMessage", "invoke, env is null");
      AppMethodBeat.o(180272);
      return;
    }
    if (paramJSONObject == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiShareImageMessage", "invoke, data is null");
      parame.j(paramInt, h("fail:data is null", null));
      AppMethodBeat.o(180272);
      return;
    }
    if (!paramJSONObject.has("imagePath"))
    {
      Log.w("MicroMsg.AppBrand.JsApiShareImageMessage", "invoke, data is null or can not find imagePath");
      parame.j(paramInt, h("fail:imagePath is null", null));
      AppMethodBeat.o(180272);
      return;
    }
    String str = paramJSONObject.optString("imagePath");
    if (Util.isNullOrNil(str))
    {
      Log.w("MicroMsg.AppBrand.JsApiShareImageMessage", "invoke, imagePath is null");
      parame.j(paramInt, h("fail:imagePath is null", null));
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
      dd.a(parame, str, new e.a()
      {
        public final void dR(final String paramAnonymousString)
        {
          AppMethodBeat.i(180270);
          Log.i("MicroMsg.AppBrand.JsApiShareImageMessage", "invoke, localPath: ".concat(String.valueOf(paramAnonymousString)));
          if (Util.isNullOrNil(paramAnonymousString))
          {
            parame.j(paramInt, k.this.h("fail:imagePath is illegal", null));
            AppMethodBeat.o(180270);
            return;
          }
          if (!ImgUtil.isImgFile(paramAnonymousString))
          {
            Log.w("MicroMsg.AppBrand.JsApiShareImageMessage", "invoke, %s is not image", new Object[] { paramAnonymousString });
            u.deleteFile(paramAnonymousString);
            parame.j(paramInt, k.this.h("fail:imagePath is illegal", null));
            AppMethodBeat.o(180270);
            return;
          }
          Object localObject = parame.getContext();
          if ((localObject instanceof Activity))
          {
            localObject = (Activity)localObject;
            if (ImgUtil.isGif(paramAnonymousString))
            {
              Log.i("MicroMsg.AppBrand.JsApiShareImageMessage", "invoke, gif");
              com.tencent.mm.plugin.appbrand.ipc.a.a((Context)localObject, new ShareGifToConversationRequest(paramAnonymousString), new AppBrandProxyUIProcessTask.b() {});
              AppMethodBeat.o(180270);
            }
          }
          else
          {
            Log.w("MicroMsg.AppBrand.JsApiShareImageMessage", "invoke, activity is null");
            parame.j(paramInt, k.this.h("fail:activity is null", null));
            AppMethodBeat.o(180270);
            return;
          }
          final MMActivity.a local2 = new MMActivity.a()
          {
            public final void d(int paramAnonymous2Int1, int paramAnonymous2Int2, Intent paramAnonymous2Intent)
            {
              AppMethodBeat.i(275286);
              if (paramAnonymous2Int1 != k.this.ppU)
              {
                Log.i("MicroMsg.AppBrand.JsApiShareImageMessage", "invoke, requestCode: %d is not match", new Object[] { Integer.valueOf(paramAnonymous2Int1) });
                AppMethodBeat.o(275286);
                return;
              }
              if (paramAnonymous2Int2 != -1)
              {
                Log.i("MicroMsg.AppBrand.JsApiShareImageMessage", "invoke, resultCode is not RESULT_OK: ".concat(String.valueOf(paramAnonymous2Int2)));
                k.1.this.ozm.j(k.1.this.cuf, k.this.h("cancel", null));
                AppMethodBeat.o(275286);
                return;
              }
              if (paramAnonymous2Intent == null) {}
              for (paramAnonymous2Intent = null; (paramAnonymous2Intent == null) || (paramAnonymous2Intent.isEmpty()); paramAnonymous2Intent = paramAnonymous2Intent.getStringArrayListExtra("SendMsgUsernames"))
              {
                Log.w("MicroMsg.AppBrand.JsApiShareImageMessage", "invoke, toUsers is empty");
                k.1.this.ozm.j(k.1.this.cuf, k.this.h("fail:selected user is empty", null));
                AppMethodBeat.o(275286);
                return;
              }
              b.r(this.val$activity, this.val$activity.getString(au.i.has_send));
              Log.i("MicroMsg.AppBrand.JsApiShareImageMessage", "invoke, toUser: " + Arrays.toString(paramAnonymous2Intent.toArray()));
              k.1.this.ozm.j(k.1.this.cuf, k.this.h("ok", null));
              AppMethodBeat.o(275286);
            }
          };
          parame.P(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(270506);
              f.aI(this.val$activity).b(new f.c()
              {
                public final boolean c(int paramAnonymous3Int1, int paramAnonymous3Int2, Intent paramAnonymous3Intent)
                {
                  AppMethodBeat.i(274204);
                  if (k.this.ppU != paramAnonymous3Int1)
                  {
                    AppMethodBeat.o(274204);
                    return false;
                  }
                  k.1.3.this.pkm.d(paramAnonymous3Int1, paramAnonymous3Int2, paramAnonymous3Intent);
                  AppMethodBeat.o(274204);
                  return true;
                }
              });
              Intent localIntent = new Intent();
              localIntent.putExtra("Retr_File_Name", paramAnonymousString);
              localIntent.putExtra("Retr_Compress_Type", k.1.this.lPg);
              localIntent.putExtra("Retr_Msg_Type", 0);
              localIntent.putExtra("Retr_show_success_tips", false);
              com.tencent.mm.by.c.d(this.val$activity, ".ui.transmit.MsgRetransmitUI", localIntent, k.this.ppU);
              AppMethodBeat.o(270506);
            }
          });
          AppMethodBeat.o(180270);
        }
      });
      AppMethodBeat.o(180272);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.k
 * JD-Core Version:    0.7.0.1
 */