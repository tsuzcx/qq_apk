package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveProductRecordPlayWidget;", "Lcom/tencent/mm/plugin/appbrand/widget/IAppBrandExternalCoverWidget;", "()V", "rootLayout", "Landroid/view/View;", "createLayoutParams", "Landroid/widget/RelativeLayout$LayoutParams;", "createWidget", "context", "Landroid/content/Context;", "data", "", "viewId", "", "ClickTask", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  implements com.tencent.mm.plugin.appbrand.widget.j
{
  public static final g.b DOK;
  private static final String DOM;
  private static final String DON;
  private static final String DOO;
  private static final String DOP;
  private static final String TAG;
  private View DOL;
  
  static
  {
    AppMethodBeat.i(358100);
    DOK = new g.b((byte)0);
    DOM = "productId";
    DON = "replayId";
    DOO = "session";
    DOP = "jumpId";
    TAG = "FinderLiveProductRecordPlayWidget";
    AppMethodBeat.o(358100);
  }
  
  private static final void f(String paramString, View paramView)
  {
    AppMethodBeat.i(358068);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramString);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/FinderLiveProductRecordPlayWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramString, "$data");
    com.tencent.mm.ipcinvoker.j.a(MMApplicationContext.getMainProcessName(), (Parcelable)new IPCString(paramString), a.class, g..ExternalSyntheticLambda1.INSTANCE, null);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/FinderLiveProductRecordPlayWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(358068);
  }
  
  private static final void h(IPCVoid paramIPCVoid)
  {
    AppMethodBeat.i(358053);
    Log.i(TAG, "click onCallback");
    AppMethodBeat.o(358053);
  }
  
  public final View ah(Context paramContext, String paramString)
  {
    AppMethodBeat.i(358122);
    s.u(paramContext, "context");
    s.u(paramString, "data");
    paramContext = LayoutInflater.from(paramContext).inflate(p.f.Cfl, null);
    this.DOL = paramContext;
    paramContext.setOnClickListener(new g..ExternalSyntheticLambda0(paramString));
    paramString = this.DOL;
    s.checkNotNull(paramString);
    paramString.setScaleX(1.25F);
    paramString = this.DOL;
    s.checkNotNull(paramString);
    paramString.setScaleY(1.25F);
    s.s(paramContext, "rootLayout");
    AppMethodBeat.o(358122);
    return paramContext;
  }
  
  public final RelativeLayout.LayoutParams cON()
  {
    AppMethodBeat.i(358131);
    Object localObject1 = this.DOL;
    Object localObject2;
    label44:
    RelativeLayout.LayoutParams localLayoutParams;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = MMApplicationContext.getContext();
      }
      int i = com.tencent.mm.cd.a.fromDPToPix((Context)localObject2, 60);
      localObject1 = this.DOL;
      if (localObject1 != null) {
        break label164;
      }
      localObject1 = null;
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = MMApplicationContext.getContext();
      }
      localLayoutParams = new RelativeLayout.LayoutParams(i, com.tencent.mm.cd.a.fromDPToPix((Context)localObject2, 24));
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(10);
      localObject1 = this.DOL;
      if (localObject1 != null) {
        break label172;
      }
      localObject1 = null;
      label95:
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = MMApplicationContext.getContext();
      }
      localLayoutParams.topMargin = com.tencent.mm.cd.a.fromDPToPix((Context)localObject2, 12);
      localObject1 = this.DOL;
      if (localObject1 != null) {
        break label180;
      }
    }
    label164:
    label172:
    label180:
    for (localObject1 = null;; localObject1 = ((View)localObject1).getContext())
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = MMApplicationContext.getContext();
      }
      localLayoutParams.rightMargin = com.tencent.mm.cd.a.fromDPToPix((Context)localObject2, 12);
      AppMethodBeat.o(358131);
      return localLayoutParams;
      localObject1 = ((View)localObject1).getContext();
      break;
      localObject1 = ((View)localObject1).getContext();
      break label44;
      localObject1 = ((View)localObject1).getContext();
      break label95;
    }
  }
  
  public final int cOO()
  {
    return p.f.Cfl;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveProductRecordPlayWidget$ClickTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements d<IPCString, IPCVoid>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.g
 * JD-Core Version:    0.7.0.1
 */