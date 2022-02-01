package com.tencent.mm.media.widget.b.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.hardcoder.HardCoderJNI.HCPerfManagerThread;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.hardcoder.WXHardCoderJNI.GetParametersCallback;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/media/widget/camera2/effect/WCCameraEffectUtil;", "", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getMContext", "()Landroid/content/Context;", "setMContext", "mHasInitHarderCodeClient", "", "mRequestTagValues", "Lorg/json/JSONArray;", "getMRequestTagValues", "()Lorg/json/JSONArray;", "setMRequestTagValues", "(Lorg/json/JSONArray;)V", "mResultTagValues", "getMResultTagValues", "setMResultTagValues", "mSessionTypeValues", "getMSessionTypeValues", "setMSessionTypeValues", "mSupportWCKeyRequests", "Ljava/util/ArrayList;", "Lcom/tencent/mm/media/widget/camera2/effect/request/WCCameraEffectRequestTag;", "Lkotlin/collections/ArrayList;", "getMSupportWCKeyRequests", "()Ljava/util/ArrayList;", "setMSupportWCKeyRequests", "(Ljava/util/ArrayList;)V", "mSupportWCKeyResults", "Lcom/tencent/mm/media/widget/camera2/effect/result/WCCameraEffectResultTag;", "getMSupportWCKeyResults", "setMSupportWCKeyResults", "mSupportWCKeySessionType", "Lcom/tencent/mm/media/widget/camera2/effect/sessionType/WCCameraEffectSessionType;", "getMSupportWCKeySessionType", "setMSupportWCKeySessionType", "getParameters", "", "tagValuesAvaliable", "Lkotlin/Function0;", "requestParameters", "mSupportWCKeyAvailable", "Lkotlin/Function3;", "plugin-mediaeditor_release"})
public final class c
{
  final String TAG;
  volatile boolean huP;
  JSONArray huQ;
  JSONArray huR;
  JSONArray huS;
  ArrayList<com.tencent.mm.media.widget.b.a.a.a> huT;
  ArrayList<com.tencent.mm.media.widget.b.a.b.a> huU;
  ArrayList<com.tencent.mm.media.widget.b.a.c.a> huV;
  private Context mContext;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(94191);
    this.mContext = paramContext;
    this.TAG = "MicroMsg.WCCameraEffectUtil";
    this.huT = new ArrayList();
    this.huU = new ArrayList();
    this.huV = new ArrayList();
    AppMethodBeat.o(94191);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
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
      if ((localObject != null) && (!p.i(localObject, "")))
      {
        bool1 = true;
        HardCoderJNI.setCheckEnv(bool1);
        int i = HardCoderJNI.initHardCoder((String)localObject, 0, ".hardcoder.client.sock", (HardCoderJNI.HCPerfManagerThread)b.huZ, null);
        ae.i(this.huW.TAG, "Read remote persist.sys.hardcoder.name:" + (String)localObject + " initHardCoder:" + i);
        localObject = this.huW;
        if (i != 0) {
          break label149;
        }
      }
      label149:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        ((c)localObject).huP = bool1;
        if (this.huW.huP) {
          WXHardCoderJNI.getParameters(2, (WXHardCoderJNI.GetParametersCallback)new a(this), new String[0]);
        }
        AppMethodBeat.o(94189);
        return;
        bool1 = false;
        break;
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "type", "", "jsonParameters", "Lorg/json/JSONObject;", "kotlin.jvm.PlatformType", "onGetParameters"})
    static final class a
      implements WXHardCoderJNI.GetParametersCallback
    {
      a(c.a parama) {}
      
      public final void onGetParameters(int paramInt, JSONObject paramJSONObject)
      {
        AppMethodBeat.i(94186);
        if (paramInt == 2)
        {
          this.huY.huW.huQ = paramJSONObject.optJSONArray("CameraRequestTags");
          this.huY.huW.huR = paramJSONObject.optJSONArray("CameraResultTags");
          this.huY.huW.huS = paramJSONObject.optJSONArray("CaptureSessionType");
          this.huY.huX.invoke();
        }
        AppMethodBeat.o(94186);
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Ljava/lang/Thread;", "r", "Ljava/lang/Runnable;", "kotlin.jvm.PlatformType", "name", "", "<anonymous parameter 2>", "", "newThread"})
    static final class b
      implements HardCoderJNI.HCPerfManagerThread
    {
      public static final b huZ;
      
      static
      {
        AppMethodBeat.i(94188);
        huZ = new b();
        AppMethodBeat.o(94188);
      }
      
      public final Thread newThread(Runnable paramRunnable, String paramString, int paramInt)
      {
        AppMethodBeat.i(94187);
        paramRunnable = new Thread(paramRunnable, paramString);
        AppMethodBeat.o(94187);
        return paramRunnable;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.a.c
 * JD-Core Version:    0.7.0.1
 */