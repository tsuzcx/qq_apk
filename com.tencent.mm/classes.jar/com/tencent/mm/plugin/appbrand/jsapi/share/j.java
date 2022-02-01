package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.l.e;
import com.tencent.luggage.l.e.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.utils.at;
import com.tencent.mm.plugin.appbrand.utils.w;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.widget.snackbar.b;
import com.tencent.mm.vfs.y;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

public final class j
  extends com.tencent.mm.plugin.appbrand.jsapi.c<f>
{
  public static final int CTRL_INDEX = 801;
  public static final String NAME = "shareImageMessage";
  final int suH;
  
  public j()
  {
    AppMethodBeat.i(180271);
    this.suH = com.tencent.luggage.sdk.h.a.ce(this);
    AppMethodBeat.o(180271);
  }
  
  public final void a(final f paramf, JSONObject paramJSONObject, final int paramInt)
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
      paramf.callback(paramInt, ZP("fail:data is null"));
      AppMethodBeat.o(180272);
      return;
    }
    if (!paramJSONObject.has("imagePath"))
    {
      Log.w("MicroMsg.AppBrand.JsApiShareImageMessage", "invoke, data is null or can not find imagePath");
      paramf.callback(paramInt, ZP("fail:imagePath is null"));
      AppMethodBeat.o(180272);
      return;
    }
    String str = paramJSONObject.optString("imagePath");
    if (Util.isNullOrNil(str))
    {
      Log.w("MicroMsg.AppBrand.JsApiShareImageMessage", "invoke, imagePath is null");
      paramf.callback(paramInt, ZP("fail:imagePath is null"));
      AppMethodBeat.o(180272);
      return;
    }
    paramJSONObject = paramJSONObject.optString("quality", "compressed");
    label138:
    switch (paramJSONObject.hashCode())
    {
    default: 
      label168:
      i = -1;
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        paramJSONObject = "compressed";
        break label138;
        if (!paramJSONObject.equals("raw")) {
          break label168;
        }
        i = 0;
        continue;
        if (!paramJSONObject.equals("compressed")) {
          break label168;
        }
        i = 1;
      }
    }
    for (final int i = 1;; i = 0)
    {
      Log.i("MicroMsg.AppBrand.JsApiShareImageMessage", "invoke, imagePath: %s, compressType: %d", new Object[] { str, Integer.valueOf(i) });
      at.a(paramf, str, new w()
      {
        public final void aA(final String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(326421);
          Log.i("MicroMsg.AppBrand.JsApiShareImageMessage", "invoke, localPath: ".concat(String.valueOf(paramAnonymousString)));
          if (Util.isNullOrNil(paramAnonymousString))
          {
            paramf.callback(paramInt, j.this.ZP("fail:imagePath is illegal"));
            AppMethodBeat.o(326421);
            return;
          }
          if (!ImgUtil.isImgFile(paramAnonymousString))
          {
            Log.w("MicroMsg.AppBrand.JsApiShareImageMessage", "invoke, %s is not image", new Object[] { paramAnonymousString });
            y.deleteFile(paramAnonymousString);
            paramf.callback(paramInt, j.this.ZP("fail:imagePath is illegal"));
            AppMethodBeat.o(326421);
            return;
          }
          Object localObject = paramf.getContext();
          if ((localObject instanceof Activity))
          {
            localObject = (Activity)localObject;
            if (ImgUtil.isGif(paramAnonymousString))
            {
              Log.i("MicroMsg.AppBrand.JsApiShareImageMessage", "invoke, gif");
              com.tencent.mm.plugin.appbrand.ipc.a.a((Context)localObject, new ShareGifToConversationRequest(paramAnonymousString), new AppBrandProxyUIProcessTask.b() {});
              AppMethodBeat.o(326421);
            }
          }
          else
          {
            Log.w("MicroMsg.AppBrand.JsApiShareImageMessage", "invoke, activity is null");
            paramf.callback(paramInt, j.this.ZP("fail:activity is null"));
            AppMethodBeat.o(326421);
            return;
          }
          final MMActivity.a local2 = new MMActivity.a()
          {
            public final void mmOnActivityResult(int paramAnonymous2Int1, int paramAnonymous2Int2, Intent paramAnonymous2Intent)
            {
              AppMethodBeat.i(326359);
              if (paramAnonymous2Int1 != j.this.suH)
              {
                Log.i("MicroMsg.AppBrand.JsApiShareImageMessage", "invoke, requestCode: %d is not match", new Object[] { Integer.valueOf(paramAnonymous2Int1) });
                AppMethodBeat.o(326359);
                return;
              }
              if (paramAnonymous2Int2 != -1)
              {
                Log.i("MicroMsg.AppBrand.JsApiShareImageMessage", "invoke, resultCode is not RESULT_OK: ".concat(String.valueOf(paramAnonymous2Int2)));
                j.1.this.rDf.callback(j.1.this.elZ, j.this.ZP("cancel"));
                AppMethodBeat.o(326359);
                return;
              }
              if (paramAnonymous2Intent == null) {}
              for (paramAnonymous2Intent = null; (paramAnonymous2Intent == null) || (paramAnonymous2Intent.isEmpty()); paramAnonymous2Intent = paramAnonymous2Intent.getStringArrayListExtra("SendMsgUsernames"))
              {
                Log.w("MicroMsg.AppBrand.JsApiShareImageMessage", "invoke, toUsers is empty");
                j.1.this.rDf.callback(j.1.this.elZ, j.this.ZP("fail:selected user is empty"));
                AppMethodBeat.o(326359);
                return;
              }
              b.u(this.val$activity, this.val$activity.getString(ba.i.has_send));
              Log.i("MicroMsg.AppBrand.JsApiShareImageMessage", "invoke, toUser: " + Arrays.toString(paramAnonymous2Intent.toArray()));
              j.1.this.rDf.callback(j.1.this.elZ, j.this.ZP("ok"));
              AppMethodBeat.o(326359);
            }
          };
          paramf.V(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(326363);
              e.bt(this.val$activity).b(new e.c()
              {
                public final boolean onResult(int paramAnonymous3Int1, int paramAnonymous3Int2, Intent paramAnonymous3Intent)
                {
                  AppMethodBeat.i(326395);
                  if (j.this.suH != paramAnonymous3Int1)
                  {
                    AppMethodBeat.o(326395);
                    return false;
                  }
                  j.1.3.this.spn.mmOnActivityResult(paramAnonymous3Int1, paramAnonymous3Int2, paramAnonymous3Intent);
                  AppMethodBeat.o(326395);
                  return true;
                }
              });
              Intent localIntent = new Intent();
              localIntent.putExtra("Retr_File_Name", paramAnonymousString);
              localIntent.putExtra("Retr_Compress_Type", j.1.this.oHQ);
              localIntent.putExtra("Retr_Msg_Type", 0);
              localIntent.putExtra("Retr_show_success_tips", false);
              com.tencent.mm.br.c.d(this.val$activity, ".ui.transmit.MsgRetransmitUI", localIntent, j.this.suH);
              AppMethodBeat.o(326363);
            }
          });
          AppMethodBeat.o(326421);
        }
      });
      AppMethodBeat.o(180272);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.j
 * JD-Core Version:    0.7.0.1
 */