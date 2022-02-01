package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.live.c.b.b;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.s.am;
import com.tencent.mm.plugin.finder.live.widget.o;
import com.tencent.mm.plugin.finder.live.widget.o.c;
import com.tencent.mm.plugin.finder.utils.aq;
import com.tencent.mm.protocal.protobuf.aze;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorExceptionPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "REQUEST_CODE_FACE_VERIFY", "", "TAG", "", "exceptionWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveExceptionWidget;", "initWidget", "", "anchorUserName", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "showAnchorForceQuit", "errorPage", "Lcom/tencent/mm/protocal/protobuf/FinderLiveErrorPage;", "errCode", "showCreateLiveDynamicErrPage", "showFaceVerify", "verifyUrl", "userName", "plugin-finder_release"})
public final class n
  extends d
{
  private final String TAG;
  private final com.tencent.mm.live.c.b kCL;
  private final int ymi;
  private o ymj;
  
  public n(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(283303);
    this.kCL = paramb;
    this.TAG = "Finder.LiveAnchorExceptionPlugin";
    this.ymi = 10000;
    AppMethodBeat.o(283303);
  }
  
  private final void aCl(String paramString)
  {
    AppMethodBeat.i(283298);
    if (this.ymj == null)
    {
      this.ymj = new o((View)this.kiF, paramString, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)getBuContext().business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).dGE());
      paramString = this.ymj;
      if (paramString != null)
      {
        paramString.zny = ((kotlin.g.a.b)new a(this));
        AppMethodBeat.o(283298);
        return;
      }
    }
    AppMethodBeat.o(283298);
  }
  
  public final void a(String paramString, aze paramaze, int paramInt)
  {
    AppMethodBeat.i(283301);
    p.k(paramString, "anchorUserName");
    Log.i(this.TAG, "showAnchorForceQuit anchorUserName:".concat(String.valueOf(paramString)));
    aCl(paramString);
    paramString = this.ymj;
    if (paramString != null)
    {
      o.c localc = o.znK;
      paramString.a(o.dIf(), paramaze, paramInt, (kotlin.g.a.b)new b(this));
      AppMethodBeat.o(283301);
      return;
    }
    AppMethodBeat.o(283301);
  }
  
  public final void a(final String paramString1, final String paramString2, aze paramaze)
  {
    AppMethodBeat.i(283299);
    Log.i(this.TAG, "showFaceVerify:".concat(String.valueOf(paramString1)));
    Object localObject = k.yBj;
    k.a(s.am.yJm, paramString2);
    aCl("");
    localObject = this.ymj;
    if (localObject != null)
    {
      o.c localc = o.znK;
      o.a((o)localObject, o.dIe(), paramaze, (kotlin.g.a.b)new d(this, paramString1, paramString2), 4);
      AppMethodBeat.o(283299);
      return;
    }
    AppMethodBeat.o(283299);
  }
  
  public final void b(String paramString, aze paramaze, int paramInt)
  {
    AppMethodBeat.i(283302);
    p.k(paramString, "anchorUserName");
    Log.i(this.TAG, "showCreateLiveDynamicErrPage anchorUserName:".concat(String.valueOf(paramString)));
    aCl(paramString);
    paramString = this.ymj;
    if (paramString != null)
    {
      o.c localc = o.znK;
      paramString.a(o.dIi(), paramaze, paramInt, (kotlin.g.a.b)new c(this));
      AppMethodBeat.o(283302);
      return;
    }
    AppMethodBeat.o(283302);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(283300);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == this.ymi)
    {
      Object localObject1 = this.ymj;
      if (localObject1 != null) {
        ((o)localObject1).hide();
      }
      if (paramIntent != null) {}
      for (localObject1 = paramIntent.getBundleExtra("result_data");; localObject1 = null)
      {
        if (paramIntent != null)
        {
          localObject2 = paramIntent.getStringExtra("srcUsername");
          paramIntent = (Intent)localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          paramIntent = "";
        }
        if ((paramInt2 != -1) || (localObject1 == null)) {
          break;
        }
        localObject2 = ((Bundle)localObject1).getString("go_next", "");
        Object localObject3 = ((Bundle)localObject1).getString("result_json");
        if (Util.isNullOrNil((String)localObject3)) {
          break;
        }
        paramInt1 = new i((String)localObject3).getInt("code");
        if ((!p.h(localObject2, "roomlive_verify")) || (paramInt1 != 0)) {
          break;
        }
        localObject1 = this.kCL;
        localObject2 = b.c.kzS;
        localObject3 = new Bundle();
        ((Bundle)localObject3).putBoolean("PARAM_FINDER_LIVE_POST_AFTER_FACE_VERIFY", true);
        ((com.tencent.mm.live.c.b)localObject1).statusChange((b.c)localObject2, (Bundle)localObject3);
        localObject1 = k.yBj;
        k.a(s.am.yJo, paramIntent);
        AppMethodBeat.o(283300);
        return;
      }
      Object localObject2 = k.yBj;
      k.a(s.am.yJp, paramIntent);
      b.b.a(this.kCL, b.c.kyS);
      paramIntent = aq.AIJ;
      paramIntent = aq.efL();
      localObject1 = String.valueOf(localObject1);
      getBuContext();
      aq.hw(paramIntent, (String)localObject1);
    }
    AppMethodBeat.o(283300);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "licenseUrl", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.b<String, x>
  {
    a(n paramn)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "ok", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.b<Boolean, x>
  {
    b(n paramn)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "ok", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.b<Boolean, x>
  {
    c(n paramn)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "verify", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.b<Boolean, x>
  {
    d(n paramn, String paramString1, String paramString2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.n
 * JD-Core Version:    0.7.0.1
 */