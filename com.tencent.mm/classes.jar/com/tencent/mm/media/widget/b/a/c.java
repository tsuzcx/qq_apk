package com.tencent.mm.media.widget.b.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.hardcoder.HardCoderJNI.HCPerfManagerThread;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.hardcoder.WXHardCoderJNI.GetParametersCallback;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.a.q;
import d.g.b.k;
import d.y;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/widget/camera2/effect/WCCameraEffectUtil;", "", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getMContext", "()Landroid/content/Context;", "setMContext", "mHasInitHarderCodeClient", "", "mRequestTagValues", "Lorg/json/JSONArray;", "getMRequestTagValues", "()Lorg/json/JSONArray;", "setMRequestTagValues", "(Lorg/json/JSONArray;)V", "mResultTagValues", "getMResultTagValues", "setMResultTagValues", "mSessionTypeValues", "getMSessionTypeValues", "setMSessionTypeValues", "mSupportWCKeyRequests", "Ljava/util/ArrayList;", "Lcom/tencent/mm/media/widget/camera2/effect/request/WCCameraEffectRequestTag;", "Lkotlin/collections/ArrayList;", "getMSupportWCKeyRequests", "()Ljava/util/ArrayList;", "setMSupportWCKeyRequests", "(Ljava/util/ArrayList;)V", "mSupportWCKeyResults", "Lcom/tencent/mm/media/widget/camera2/effect/result/WCCameraEffectResultTag;", "getMSupportWCKeyResults", "setMSupportWCKeyResults", "mSupportWCKeySessionType", "Lcom/tencent/mm/media/widget/camera2/effect/sessionType/WCCameraEffectSessionType;", "getMSupportWCKeySessionType", "setMSupportWCKeySessionType", "getParameters", "", "tagValuesAvaliable", "Lkotlin/Function0;", "requestParameters", "mSupportWCKeyAvailable", "Lkotlin/Function3;", "plugin-mediaeditor_release"})
public final class c
{
  final String TAG;
  volatile boolean gZV;
  JSONArray gZW;
  JSONArray gZX;
  JSONArray gZY;
  ArrayList<com.tencent.mm.media.widget.b.a.a.a> gZZ;
  ArrayList<com.tencent.mm.media.widget.b.a.b.a> haa;
  ArrayList<com.tencent.mm.media.widget.b.a.c.a> hab;
  private Context mContext;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(94191);
    this.mContext = paramContext;
    this.TAG = "MicroMsg.WCCameraEffectUtil";
    this.gZZ = new ArrayList();
    this.haa = new ArrayList();
    this.hab = new ArrayList();
    AppMethodBeat.o(94191);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  public static final class a
    implements Runnable
  {
    public a(c paramc, d.g.a.a parama) {}
    
    public final void run()
    {
      boolean bool2 = true;
      AppMethodBeat.i(94189);
      HardCoderJNI.stopPerformance(0);
      Object localObject = HardCoderJNI.readServerAddr();
      if ((localObject != null) && (!k.g(localObject, "")))
      {
        bool1 = true;
        HardCoderJNI.setCheckEnv(bool1);
        int i = HardCoderJNI.initHardCoder((String)localObject, 0, ".hardcoder.client.sock", (HardCoderJNI.HCPerfManagerThread)c.a.b.haf, null);
        ac.i(this.hac.TAG, "Read remote persist.sys.hardcoder.name:" + (String)localObject + " initHardCoder:" + i);
        localObject = this.hac;
        if (i != 0) {
          break label149;
        }
      }
      label149:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        ((c)localObject).gZV = bool1;
        if (this.hac.gZV) {
          WXHardCoderJNI.getParameters(2, (WXHardCoderJNI.GetParametersCallback)new a(this), new String[0]);
        }
        AppMethodBeat.o(94189);
        return;
        bool1 = false;
        break;
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "type", "", "jsonParameters", "Lorg/json/JSONObject;", "kotlin.jvm.PlatformType", "onGetParameters"})
    static final class a
      implements WXHardCoderJNI.GetParametersCallback
    {
      a(c.a parama) {}
      
      public final void onGetParameters(int paramInt, JSONObject paramJSONObject)
      {
        AppMethodBeat.i(94186);
        if (paramInt == 2)
        {
          this.hae.hac.gZW = paramJSONObject.optJSONArray("CameraRequestTags");
          this.hae.hac.gZX = paramJSONObject.optJSONArray("CameraResultTags");
          this.hae.hac.gZY = paramJSONObject.optJSONArray("CaptureSessionType");
          this.hae.had.invoke();
        }
        AppMethodBeat.o(94186);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  public static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public b(c paramc, q paramq)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.a.c
 * JD-Core Version:    0.7.0.1
 */