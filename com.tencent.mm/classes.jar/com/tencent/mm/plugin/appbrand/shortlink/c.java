package com.tencent.mm.plugin.appbrand.shortlink;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.g.a;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.ByteArrayOutputStream;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/shortlink/Task;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "Lcom/tencent/mm/plugin/appbrand/shortlink/UploadResult;", "()V", "invoke", "", "bundle", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-appbrand-integration_release"})
public final class c
  implements b<Bundle, UploadResult>
{
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/shortlink/Task$invoke$2", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "p2", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "p4", "", "decodePrepareResponse", "", "p0", "p1", "getCdnAuthInfo", "", "Ljava/io/ByteArrayOutputStream;", "plugin-appbrand-integration_release"})
  public static final class a
    implements g.a
  {
    a(com.tencent.mm.ipcinvoker.d paramd) {}
    
    public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, com.tencent.mm.i.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(229345);
      if (paramd == null)
      {
        paramString = this.kFf;
        if (paramString != null) {
          paramString.bn(new UploadResult());
        }
        AppMethodBeat.o(229345);
        return 0;
      }
      if (paramInt != 0)
      {
        paramString = this.kFf;
        if (paramString != null) {
          paramString.bn(new UploadResult());
        }
        Log.i("MicroMsg.WxaShortLinkRiskManager", "cdn upload failed, startRet : %d", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(229345);
        return 0;
      }
      if (paramd.field_retCode != 0)
      {
        Log.e("MicroMsg.WxaShortLinkRiskManager", "cdn upload failed, retCode:%d sceneResult[%s]", new Object[] { Integer.valueOf(paramd.field_retCode), paramd });
        paramString = this.kFf;
        if (paramString != null) {
          paramString.bn(new UploadResult());
        }
      }
      for (;;)
      {
        AppMethodBeat.o(229345);
        return 0;
        Log.i("MicroMsg.WxaShortLinkRiskManager", "cdn upload success, media id : %s  file url=%s   thumb url=%s", new Object[] { paramString, paramd.field_fileUrl, paramd.field_thumbUrl });
        paramString = this.kFf;
        if (paramString != null)
        {
          paramc = paramd.field_fileUrl;
          p.g(paramc, "sceneResult.field_fileUrl");
          paramString.bn(new UploadResult(true, paramc));
        }
      }
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
    
    public final byte[] f(String paramString, byte[] paramArrayOfByte)
    {
      return new byte[0];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.shortlink.c
 * JD-Core Version:    0.7.0.1
 */