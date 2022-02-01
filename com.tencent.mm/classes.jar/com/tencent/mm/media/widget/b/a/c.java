package com.tencent.mm.media.widget.b.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.q;
import kotlin.g.b.s;
import kotlin.g.b.u;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/widget/camera2/effect/WCCameraEffectUtil;", "", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getMContext", "()Landroid/content/Context;", "setMContext", "mHasInitHarderCodeClient", "", "mRequestTagValues", "Lorg/json/JSONArray;", "getMRequestTagValues", "()Lorg/json/JSONArray;", "setMRequestTagValues", "(Lorg/json/JSONArray;)V", "mResultTagValues", "getMResultTagValues", "setMResultTagValues", "mSessionTypeValues", "getMSessionTypeValues", "setMSessionTypeValues", "mSupportWCKeyRequests", "Ljava/util/ArrayList;", "Lcom/tencent/mm/media/widget/camera2/effect/request/WCCameraEffectRequestTag;", "Lkotlin/collections/ArrayList;", "getMSupportWCKeyRequests", "()Ljava/util/ArrayList;", "setMSupportWCKeyRequests", "(Ljava/util/ArrayList;)V", "mSupportWCKeyResults", "Lcom/tencent/mm/media/widget/camera2/effect/result/WCCameraEffectResultTag;", "getMSupportWCKeyResults", "setMSupportWCKeyResults", "mSupportWCKeySessionType", "Lcom/tencent/mm/media/widget/camera2/effect/sessionType/WCCameraEffectSessionType;", "getMSupportWCKeySessionType", "setMSupportWCKeySessionType", "getParameters", "", "tagValuesAvaliable", "Lkotlin/Function0;", "requestParameters", "mSupportWCKeyAvailable", "Lkotlin/Function3;", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  final String TAG;
  private Context mContext;
  private volatile boolean nIi;
  JSONArray nIj;
  JSONArray nIk;
  JSONArray nIl;
  ArrayList<com.tencent.mm.media.widget.b.a.a.a> nIm;
  ArrayList<com.tencent.mm.media.widget.b.a.b.a> nIn;
  ArrayList<com.tencent.mm.media.widget.b.a.c.a> nIo;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(94191);
    this.mContext = paramContext;
    this.TAG = "MicroMsg.WCCameraEffectUtil";
    this.nIm = new ArrayList();
    this.nIn = new ArrayList();
    this.nIo = new ArrayList();
    AppMethodBeat.o(94191);
  }
  
  private static final Thread a(Runnable paramRunnable, String paramString, int paramInt)
  {
    AppMethodBeat.i(237571);
    paramRunnable = new Thread(paramRunnable, paramString);
    AppMethodBeat.o(237571);
    return paramRunnable;
  }
  
  private static final void a(c paramc, kotlin.g.a.a parama)
  {
    boolean bool2 = true;
    AppMethodBeat.i(237580);
    s.u(paramc, "this$0");
    s.u(parama, "$tagValuesAvaliable");
    HardCoderJNI.stopPerformance(0);
    String str = HardCoderJNI.readServerAddr();
    if ((str != null) && (!s.p(str, "")))
    {
      bool1 = true;
      HardCoderJNI.setCheckEnv(bool1);
      int i = HardCoderJNI.initHardCoder(str, 0, ".hardcoder.client.sock", c..ExternalSyntheticLambda0.INSTANCE, null);
      Log.i(paramc.TAG, "Read remote persist.sys.hardcoder.name:" + str + " initHardCoder:" + i);
      if (i != 0) {
        break label145;
      }
    }
    label145:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramc.nIi = bool1;
      if (paramc.nIi) {
        WXHardCoderJNI.getParameters(2, new c..ExternalSyntheticLambda1(paramc, parama), new String[0]);
      }
      AppMethodBeat.o(237580);
      return;
      bool1 = false;
      break;
    }
  }
  
  private static final void a(c paramc, kotlin.g.a.a parama, int paramInt, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(237575);
    s.u(paramc, "this$0");
    s.u(parama, "$tagValuesAvaliable");
    if (paramInt == 2)
    {
      paramc.nIj = paramJSONObject.optJSONArray("CameraRequestTags");
      paramc.nIk = paramJSONObject.optJSONArray("CameraResultTags");
      paramc.nIl = paramJSONObject.optJSONArray("CaptureSessionType");
      parama.invoke();
    }
    AppMethodBeat.o(237575);
  }
  
  public final void aa(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(237591);
    new Thread(new c..ExternalSyntheticLambda2(this, parama)).start();
    AppMethodBeat.o(237591);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    public a(c paramc, q<? super ArrayList<com.tencent.mm.media.widget.b.a.a.a>, ? super ArrayList<com.tencent.mm.media.widget.b.a.b.a>, ? super ArrayList<com.tencent.mm.media.widget.b.a.c.a>, ah> paramq)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.a.c
 * JD-Core Version:    0.7.0.1
 */