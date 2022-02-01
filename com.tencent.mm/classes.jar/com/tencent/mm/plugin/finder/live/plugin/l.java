package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.app.f;
import com.tencent.mm.live.b.b.b;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.live.report.j;
import com.tencent.mm.plugin.finder.live.report.q.ax;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.widget.w;
import com.tencent.mm.plugin.finder.live.widget.w.a;
import com.tencent.mm.plugin.finder.utils.bc;
import com.tencent.mm.protocal.protobuf.bgq;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorExceptionPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "REQUEST_CODE_FACE_VERIFY", "", "TAG", "", "exceptionWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveExceptionWidget;", "realnameNotifyListener", "Lcom/tencent/mm/sdk/event/IListener;", "afterVerify", "", "resultCode", "initWidget", "anchorUserName", "onActivityResult", "requestCode", "data", "Landroid/content/Intent;", "showAnchorForceQuit", "errorPage", "Lcom/tencent/mm/protocal/protobuf/FinderLiveErrorPage;", "errCode", "showCreateLiveDynamicErrPage", "showFaceVerify", "verifyUrl", "userName", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  extends b
{
  private final int CUF;
  private w CUG;
  private final IListener<?> CUH;
  private final String TAG;
  private final com.tencent.mm.live.b.b nfT;
  
  public l(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(354597);
    this.nfT = paramb;
    this.TAG = "Finder.LiveAnchorExceptionPlugin";
    this.CUF = 10000;
    this.CUH = ((IListener)new FinderLiveAnchorExceptionPlugin.realnameNotifyListener.1(this, f.hfK));
    AppMethodBeat.o(354597);
  }
  
  private final void awP(String paramString)
  {
    AppMethodBeat.i(354607);
    if (this.CUG == null)
    {
      this.CUG = new w((View)this.mJe, paramString, ((e)getBuContext().business(e.class)).eyo());
      paramString = this.CUG;
      if (paramString != null) {
        paramString.EoC = ((kotlin.g.a.b)new a(this));
      }
    }
    AppMethodBeat.o(354607);
  }
  
  public final void a(String paramString, bgq parambgq, int paramInt)
  {
    AppMethodBeat.i(354673);
    s.u(paramString, "anchorUserName");
    Log.i(this.TAG, s.X("showAnchorForceQuit anchorUserName:", paramString));
    awP(paramString);
    paramString = this.CUG;
    if (paramString != null)
    {
      w.a locala = w.EoA;
      paramString.a(w.eAC(), parambgq, paramInt, (kotlin.g.a.b)new b(this));
    }
    AppMethodBeat.o(354673);
  }
  
  public final void a(String paramString1, final String paramString2, bgq parambgq)
  {
    AppMethodBeat.i(354648);
    Log.i(this.TAG, s.X("showFaceVerify:", paramString1));
    paramString1 = j.Dob;
    j.a(q.ax.DAe, paramString2);
    awP("");
    paramString1 = this.CUG;
    if (paramString1 != null)
    {
      w.a locala = w.EoA;
      w.a(paramString1, w.eAB(), parambgq, (kotlin.g.a.b)new d(this, paramString2), 4);
    }
    AppMethodBeat.o(354648);
  }
  
  public final void b(String paramString, bgq parambgq, int paramInt)
  {
    AppMethodBeat.i(354682);
    s.u(paramString, "anchorUserName");
    Log.i(this.TAG, s.X("showCreateLiveDynamicErrPage anchorUserName:", paramString));
    awP(paramString);
    paramString = this.CUG;
    if (paramString != null)
    {
      w.a locala = w.EoA;
      paramString.a(w.eAF(), parambgq, paramInt, (kotlin.g.a.b)new c(this));
    }
    AppMethodBeat.o(354682);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(354664);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == this.CUF)
    {
      Object localObject1 = this.CUG;
      if (localObject1 != null) {
        ((w)localObject1).hide();
      }
      if (paramIntent == null)
      {
        localObject1 = null;
        if (paramIntent != null) {
          break label197;
        }
        paramIntent = "";
      }
      for (;;)
      {
        if ((paramInt2 != -1) || (localObject1 == null)) {
          break label220;
        }
        localObject2 = ((Bundle)localObject1).getString("go_next", "");
        Object localObject3 = ((Bundle)localObject1).getString("result_json");
        if (Util.isNullOrNil((String)localObject3)) {
          break label220;
        }
        paramInt1 = new i((String)localObject3).getInt("code");
        if ((!s.p(localObject2, "roomlive_verify")) || (paramInt1 != 0)) {
          break label220;
        }
        localObject1 = this.nfT;
        localObject2 = b.c.ndi;
        localObject3 = new Bundle();
        ((Bundle)localObject3).putBoolean("PARAM_FINDER_LIVE_POST_AFTER_FACE_VERIFY", true);
        ah localah = ah.aiuX;
        ((com.tencent.mm.live.b.b)localObject1).statusChange((b.c)localObject2, (Bundle)localObject3);
        localObject1 = j.Dob;
        j.a(q.ax.DAg, paramIntent);
        AppMethodBeat.o(354664);
        return;
        localObject1 = paramIntent.getBundleExtra("result_data");
        break;
        label197:
        localObject2 = paramIntent.getStringExtra("srcUsername");
        paramIntent = (Intent)localObject2;
        if (localObject2 == null) {
          paramIntent = "";
        }
      }
      label220:
      Object localObject2 = j.Dob;
      j.a(q.ax.DAh, paramIntent);
      b.b.a(this.nfT, b.c.nch);
      paramIntent = bc.GkH;
      paramIntent = bc.fhI();
      localObject1 = String.valueOf(localObject1);
      getBuContext();
      bc.it(paramIntent, (String)localObject1);
    }
    AppMethodBeat.o(354664);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "licenseUrl", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.b<String, ah>
  {
    a(l paraml)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "ok", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    b(l paraml)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "ok", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    c(l paraml)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "verify", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    d(l paraml, String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.l
 * JD-Core Version:    0.7.0.1
 */