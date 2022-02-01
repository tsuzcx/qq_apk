package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.live.c.a;
import com.tencent.mm.live.c.b.b;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.plugin.finder.live.widget.f;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s.ad;
import com.tencent.mm.plugin.finder.utils.ae;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorExceptionPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "REQUEST_CODE_FACE_VERIFY", "", "TAG", "", "exceptionWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveExceptionWidget;", "initWidget", "", "anchorUserName", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "showAnchorForceQuit", "showCreateLiveDynamicErrPage", "errorPage", "Lcom/tencent/mm/protocal/protobuf/FinderLiveErrorPage;", "errCode", "showFaceVerify", "verifyUrl", "userName", "plugin-finder_release"})
public final class n
  extends d
{
  public final String TAG;
  final com.tencent.mm.live.c.b hOp;
  final int umR;
  public f umS;
  
  public n(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(246458);
    this.hOp = paramb;
    this.TAG = "Finder.LiveAnchorExceptionPlugin";
    this.umR = 10000;
    AppMethodBeat.o(246458);
  }
  
  public final void atI(String paramString)
  {
    AppMethodBeat.i(246456);
    if (this.umS == null)
    {
      this.umS = new f((View)this.hwr, paramString, getLiveData().uEu);
      paramString = this.umS;
      if (paramString != null)
      {
        paramString.uGl = ((kotlin.g.a.b)new a(this));
        AppMethodBeat.o(246456);
        return;
      }
    }
    AppMethodBeat.o(246456);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(246457);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == this.umR)
    {
      Object localObject1 = this.umS;
      if (localObject1 != null) {
        ((f)localObject1).hide();
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
        if ((!p.j(localObject2, "roomlive_verify")) || (paramInt1 != 0)) {
          break;
        }
        localObject1 = this.hOp;
        localObject2 = b.c.hMx;
        localObject3 = new Bundle();
        ((Bundle)localObject3).putBoolean("PARAM_FINDER_LIVE_POST_AFTER_FACE_VERIFY", true);
        ((com.tencent.mm.live.c.b)localObject1).statusChange((b.c)localObject2, (Bundle)localObject3);
        localObject1 = k.vkd;
        k.a(s.ad.vqg, paramIntent);
        AppMethodBeat.o(246457);
        return;
      }
      Object localObject2 = k.vkd;
      k.a(s.ad.vqh, paramIntent);
      b.b.a(this.hOp, b.c.hLy);
      paramIntent = ae.vZW;
      ae.a(ae.dEc(), paramInt2, 0, String.valueOf(localObject1), getLiveData());
    }
    AppMethodBeat.o(246457);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "licenseUrl", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.b<String, x>
  {
    a(n paramn)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "ok", "", "invoke"})
  public static final class b
    extends q
    implements kotlin.g.a.b<Boolean, x>
  {
    public b(n paramn)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "ok", "", "invoke"})
  public static final class c
    extends q
    implements kotlin.g.a.b<Boolean, x>
  {
    public c(n paramn)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "verify", "", "invoke"})
  public static final class d
    extends q
    implements kotlin.g.a.b<Boolean, x>
  {
    public d(n paramn, String paramString1, String paramString2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.n
 * JD-Core Version:    0.7.0.1
 */