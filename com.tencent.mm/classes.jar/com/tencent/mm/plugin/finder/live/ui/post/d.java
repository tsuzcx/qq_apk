package com.tencent.mm.plugin.finder.live.ui.post;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.b;
import com.tencent.mm.plugin.b.a;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.aq;
import com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI;
import com.tencent.mm.plugin.finder.ui.FinderSelfUI;
import com.tencent.mm.protocal.protobuf.ble;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.component.UIComponent;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/ui/post/PostPreCheckUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "isNetSceneFailed", "", "isNetScenePending", "loadingDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "notNeedToRequest", "", "Ljava/lang/Class;", "Landroid/app/Activity;", "onPrePareEnd", "Lkotlin/Function0;", "", "prepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "preCheck", "whenPreCheckReConnect", "backFromVerify", "plugin-finder_release"})
public final class d
  extends UIComponent
  implements i
{
  private s loadingDialog;
  private ble wZz;
  private boolean yPp;
  private boolean yPq;
  private a<x> yPr;
  private List<? extends Class<? extends Activity>> yPs;
  
  public d(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(268320);
    this.yPs = j.listOf(new Class[] { FinderTopicFeedUI.class, FinderSelfUI.class, FinderProfileUI.class });
    AppMethodBeat.o(268320);
  }
  
  public final boolean a(a<x> parama1, final a<x> parama2)
  {
    AppMethodBeat.i(268317);
    p.k(parama1, "whenPreCheckReConnect");
    this.yPr = parama1;
    parama1 = this.wZz;
    if (parama1 != null)
    {
      com.tencent.mm.plugin.finder.utils.w localw = com.tencent.mm.plugin.finder.utils.w.ADZ;
      if (!com.tencent.mm.plugin.finder.utils.w.a((Activity)getActivity(), parama1, (a)new a(this, parama2))) {
        Log.i("SimpleUIComponent", "preCheck interrupt");
      }
    }
    for (;;)
    {
      AppMethodBeat.o(268317);
      return false;
      AppMethodBeat.o(268317);
      return true;
      parama1 = (d)this;
      Log.i("SimpleUIComponent", "prepareResp null,isNetSceneFailed:" + parama1.yPq + " , isNetScenePending:" + parama1.yPp);
      if (parama1.yPq) {
        com.tencent.mm.ui.base.w.makeText((Context)parama1.getActivity(), b.j.finder_cgi_failed, 0).show();
      } else if (parama1.yPp) {
        parama1.loadingDialog = s.a((Context)parama1.getActivity(), (CharSequence)parama1.getString(b.j.app_waiting), true, 3, null);
      }
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(268314);
    super.onCreate(paramBundle);
    h.aGY().a(3761, (i)this);
    AppMethodBeat.o(268314);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(268315);
    super.onDestroy();
    h.aGY().b(3761, (i)this);
    AppMethodBeat.o(268315);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(268316);
    super.onResume();
    if (this.wZz == null)
    {
      this.yPp = true;
      if (!this.yPs.contains(getActivity().getClass())) {
        b.a.a((b)h.ae(b.class), 8);
      }
    }
    AppMethodBeat.o(268316);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(268319);
    Log.i("SimpleUIComponent", "errType:" + paramInt1 + " , errCode:" + paramInt2);
    this.yPp = false;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramq instanceof aq)) {
        this.wZz = ((aq)paramq).dnR();
      }
      paramString = this.loadingDialog;
      if ((paramString != null) && (paramString.isShowing() == true))
      {
        Log.i("SimpleUIComponent", "loadingDialog is showing");
        paramString = this.yPr;
        if (paramString != null) {
          paramString.invoke();
        }
      }
    }
    for (boolean bool = false;; bool = true)
    {
      this.yPq = bool;
      paramString = this.loadingDialog;
      if (paramString == null) {
        break;
      }
      if (paramString.isShowing() != true) {
        break label186;
      }
      paramString = this.loadingDialog;
      if (paramString == null) {
        break label186;
      }
      paramString.dismiss();
      AppMethodBeat.o(268319);
      return;
      com.tencent.mm.ui.base.w.makeText((Context)getActivity(), b.j.finder_cgi_failed, 0).show();
    }
    AppMethodBeat.o(268319);
    return;
    label186:
    AppMethodBeat.o(268319);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/live/ui/post/PostPreCheckUIC$preCheck$1$1"})
  static final class a
    extends kotlin.g.b.q
    implements a<x>
  {
    a(d paramd, a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.ui.post.d
 * JD-Core Version:    0.7.0.1
 */