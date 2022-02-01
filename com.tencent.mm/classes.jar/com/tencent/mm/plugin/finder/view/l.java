package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderShareProductWxaCoverWidget;", "Lcom/tencent/mm/plugin/appbrand/widget/IAppBrandExternalCoverWidget;", "()V", "data", "", "feedId", "nonceId", "rootLayout", "Landroid/view/View;", "createLayoutParams", "Landroid/widget/RelativeLayout$LayoutParams;", "createWidget", "context", "Landroid/content/Context;", "viewId", "", "ClickTask", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  implements com.tencent.mm.plugin.appbrand.widget.j
{
  public static final l.b GCc;
  private static final String TAG;
  private View DOL;
  private String data = "";
  private String feedId = "";
  private String nonceId = "";
  
  static
  {
    AppMethodBeat.i(344312);
    GCc = new l.b((byte)0);
    TAG = "Finder.FinderShareProductWxaCoverWidget";
    AppMethodBeat.o(344312);
  }
  
  private static final void a(l paraml, String paramString, View paramView)
  {
    AppMethodBeat.i(344299);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paraml);
    localb.cH(paramString);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderShareProductWxaCoverWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paraml, "this$0");
    s.u(paramString, "$data");
    Log.i(TAG, s.X("onClick data:", paraml.data));
    com.tencent.mm.ipcinvoker.j.a(MMApplicationContext.getMainProcessName(), (Parcelable)new IPCString(paramString), a.class, (f)new c(), null);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/FinderShareProductWxaCoverWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(344299);
  }
  
  public final View ah(Context paramContext, String paramString)
  {
    AppMethodBeat.i(344329);
    s.u(paramContext, "context");
    s.u(paramString, "data");
    paramContext = LayoutInflater.from(paramContext).inflate(e.f.finder_share_product_wxa_cover_layout, null);
    this.data = paramString;
    try
    {
      Log.i(TAG, s.X("createWidget data:", paramString));
      Object localObject1 = new JSONObject(paramString);
      String str = ((JSONObject)localObject1).getString("feedId");
      s.s(str, "dataJson.getString(\"feedId\")");
      this.feedId = str;
      localObject1 = ((JSONObject)localObject1).getString("nonceId");
      s.s(localObject1, "dataJson.getString(\"nonceId\")");
      this.nonceId = ((String)localObject1);
      label94:
      paramContext.setOnClickListener(new l..ExternalSyntheticLambda0(this, paramString));
      this.DOL = paramContext;
      s.s(paramContext, "rootLayout");
      AppMethodBeat.o(344329);
      return paramContext;
    }
    finally
    {
      break label94;
    }
  }
  
  public final RelativeLayout.LayoutParams cON()
  {
    AppMethodBeat.i(344336);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(10);
    Object localObject1 = this.DOL;
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = ((View)localObject1).getContext())
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = MMApplicationContext.getContext();
      }
      localLayoutParams.topMargin = com.tencent.mm.cd.a.fromDPToPix((Context)localObject2, 12);
      AppMethodBeat.o(344336);
      return localLayoutParams;
    }
  }
  
  public final int cOO()
  {
    return e.e.finder_share_product_wxa_cover_layout;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderShareProductWxaCoverWidget$ClickTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements d<IPCString, IPCVoid>
  {
    private static final void e(Void paramVoid)
    {
      AppMethodBeat.i(345043);
      Log.i(l.access$getTAG$cp(), "openLive succ");
      AppMethodBeat.o(345043);
    }
    
    private static final void t(Integer paramInteger)
    {
      AppMethodBeat.i(345036);
      Log.i(l.access$getTAG$cp(), s.X("openLive failed, errCode: ", paramInteger));
      AppMethodBeat.o(345036);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/FinderShareProductWxaCoverWidget$createWidget$1$1", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "onCallback", "", "data", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements f<IPCVoid>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.l
 * JD-Core Version:    0.7.0.1
 */