package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.util.Base64;
import com.tencent.luggage.g.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nw;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.t.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.h;
import java.util.HashSet;
import java.util.Set;

final class JsApiShowImageOperateSheet$BottomSheetLogicHelper
{
  private static Set<Integer> hzN;
  private static Set<Integer> hzO;
  private JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult hzP;
  private com.tencent.mm.ui.widget.b.d hzQ;
  private final z hzR;
  private final String hzS;
  private final String hzT;
  private final Rect hzU;
  
  static
  {
    AppMethodBeat.i(130619);
    HashSet localHashSet = new HashSet();
    hzN = localHashSet;
    localHashSet.add(Integer.valueOf(3));
    localHashSet = new HashSet();
    hzO = localHashSet;
    localHashSet.add(Integer.valueOf(22));
    AppMethodBeat.o(130619);
  }
  
  public JsApiShowImageOperateSheet$BottomSheetLogicHelper(z paramz, String paramString1, String paramString2, Rect paramRect)
  {
    this.hzR = paramz;
    this.hzS = paramString1;
    this.hzT = paramString2;
    this.hzU = paramRect;
  }
  
  private void a(b.a parama)
  {
    AppMethodBeat.i(130612);
    if (!bo.isNullOrNil(this.hzT))
    {
      Object localObject = this.hzR.wX().zh("showSheet_base64_" + System.currentTimeMillis());
      if (localObject == null)
      {
        ab.e("MicroMsg.JsApiShowImageOperateSheet", "loadImage failed for allocTempFile");
        AppMethodBeat.o(130612);
        return;
      }
      localObject = com.tencent.mm.vfs.j.p(((com.tencent.mm.vfs.b)localObject).dQJ());
      byte[] arrayOfByte = Base64.decode(this.hzT, 0);
      com.tencent.mm.a.e.b((String)localObject, arrayOfByte, arrayOfByte.length);
      parama.BO((String)localObject);
      AppMethodBeat.o(130612);
      return;
    }
    com.tencent.mm.plugin.appbrand.t.b.a(this.hzR, this.hzS, null, parama);
    AppMethodBeat.o(130612);
  }
  
  public final void aBC()
  {
    AppMethodBeat.i(130611);
    boolean bool = f.av(this.hzR.getContext());
    JsApiShowImageOperateSheet.BottomSheetLogicHelper.1 local1 = new JsApiShowImageOperateSheet.BottomSheetLogicHelper.1(this);
    if (bool) {}
    for (int i = 100;; i = 0)
    {
      al.p(local1, i);
      AppMethodBeat.o(130611);
      return;
    }
  }
  
  static final class c
    implements com.tencent.mm.ipcinvoker.a<JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeParam, JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult>
  {
    private boolean hAh = false;
    
    private void a(JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeParam paramIPCQRCodeRecognizeParam, c<JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult> paramc, boolean paramBoolean)
    {
      AppMethodBeat.i(130595);
      if (paramBoolean) {}
      for (String str = JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeParam.a(paramIPCQRCodeRecognizeParam);; str = JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeParam.b(paramIPCQRCodeRecognizeParam))
      {
        ab.i("MicroMsg.JsApiShowImageOperateSheet", "doRecognizeLogic mIsBakPathUsed:%b useBak:%b path:%s", new Object[] { Boolean.valueOf(this.hAh), Boolean.valueOf(paramBoolean), str });
        this.hAh = paramBoolean;
        if (!bo.isNullOrNil(str)) {
          break;
        }
        AppMethodBeat.o(130595);
        return;
      }
      com.tencent.mm.plugin.appbrand.s.j localj2 = new com.tencent.mm.plugin.appbrand.s.j();
      com.tencent.mm.plugin.appbrand.s.j localj1 = new com.tencent.mm.plugin.appbrand.s.j();
      JsApiShowImageOperateSheet.BottomSheetLogicHelper.c.1 local1 = new JsApiShowImageOperateSheet.BottomSheetLogicHelper.c.1(this, localj2, localj1, str, paramc);
      localj2.value = local1;
      paramIPCQRCodeRecognizeParam = new JsApiShowImageOperateSheet.BottomSheetLogicHelper.c.2(this, localj2, localj1, str, paramIPCQRCodeRecognizeParam, paramc);
      localj1.value = paramIPCQRCodeRecognizeParam;
      com.tencent.mm.sdk.b.a.ymk.c(local1);
      com.tencent.mm.sdk.b.a.ymk.c(paramIPCQRCodeRecognizeParam);
      paramIPCQRCodeRecognizeParam = new nw();
      paramIPCQRCodeRecognizeParam.cEv.filePath = str;
      paramIPCQRCodeRecognizeParam.cEv.cEw = JsApiShowImageOperateSheet.BottomSheetLogicHelper.aBE();
      com.tencent.mm.sdk.b.a.ymk.l(paramIPCQRCodeRecognizeParam);
      AppMethodBeat.o(130595);
    }
  }
  
  static final class d
    extends AppBrandProxyUIProcessTask
  {
    public final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
    {
      AppMethodBeat.i(130610);
      if (!(paramProcessRequest instanceof JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCSendToFriendEmojiRequest))
      {
        ab.e("MicroMsg.JsApiShowImageOperateSheet", "IPCSendToFriendEmojiRequest request instance not valid");
        AppMethodBeat.o(130610);
        return;
      }
      Object localObject = JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCSendToFriendEmojiRequest.a((JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCSendToFriendEmojiRequest)paramProcessRequest);
      paramProcessRequest = com.tencent.mm.vfs.e.avP((String)localObject);
      paramProcessRequest = ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Kt(paramProcessRequest);
      if (paramProcessRequest == null)
      {
        paramProcessRequest = ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr();
        ah.getContext();
        paramProcessRequest = paramProcessRequest.Kv((String)localObject);
        paramProcessRequest = ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Kt(paramProcessRequest);
      }
      for (;;)
      {
        long l;
        if (paramProcessRequest == null)
        {
          l = 0L;
          if (paramProcessRequest != null) {
            break label232;
          }
          label121:
          BitmapFactory.Options localOptions = new BitmapFactory.Options();
          localOptions.inJustDecodeBounds = true;
          if (((com.tencent.mm.sdk.platformtools.d.decodeFile((String)localObject, localOptions) == null) || (localOptions.outHeight <= com.tencent.mm.m.b.MV())) && (localOptions.outWidth <= com.tencent.mm.m.b.MV())) {
            break label306;
          }
        }
        label306:
        for (int i = 1;; i = 0)
        {
          if ((l > com.tencent.mm.m.b.MW()) || (i != 0))
          {
            h.a(aBf(), ah.getResources().getString(2131299130), "", ah.getResources().getString(2131300718), null);
            a(null);
            AppMethodBeat.o(130610);
            return;
            l = com.tencent.mm.vfs.e.avI(paramProcessRequest.dQB());
            break;
            label232:
            localObject = paramProcessRequest.dQB();
            break label121;
          }
          localObject = new Intent();
          if (paramProcessRequest == null) {}
          for (paramProcessRequest = "";; paramProcessRequest = paramProcessRequest.Al())
          {
            ((Intent)localObject).putExtra("Retr_File_Name", paramProcessRequest);
            ((Intent)localObject).putExtra("Retr_Msg_Type", 5);
            ((Intent)localObject).putExtra("Retr_MsgImgScene", 1);
            com.tencent.mm.bq.d.f(aBf(), ".ui.transmit.MsgRetransmitUI", (Intent)localObject);
            break;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet.BottomSheetLogicHelper
 * JD-Core Version:    0.7.0.1
 */