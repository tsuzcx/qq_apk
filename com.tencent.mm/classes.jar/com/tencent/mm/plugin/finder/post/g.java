package com.tencent.mm.plugin.finder.post;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.bl;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI;
import com.tencent.mm.plugin.finder.ui.FinderSelfUI;
import com.tencent.mm.plugin.finder.utils.ad;
import com.tencent.mm.plugin.h.a;
import com.tencent.mm.protocal.protobuf.bys;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.component.UIComponent;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.q;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/post/PostPreCheckUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "isNetSceneFailed", "", "isNetScenePending", "loadingDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "notNeedToRequest", "", "Ljava/lang/Class;", "Landroid/app/Activity;", "onPrePareEnd", "Lkotlin/Function0;", "", "onSceneEndCallbacks", "Ljava/util/Vector;", "Lkotlin/Function3;", "", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "prepareResp", "addOnSceneEndCallback", "callback", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "preCheck", "whenPreCheckReConnect", "backFromVerify", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends UIComponent
  implements com.tencent.mm.am.h
{
  private bys AwM;
  private boolean ETS;
  private boolean ETT;
  private kotlin.g.a.a<ah> ETU;
  private List<? extends Class<? extends Activity>> ETV;
  private final Vector<q<Integer, Integer, bys, ah>> ETW;
  private w loadingDialog;
  
  public g(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(349409);
    this.ETV = kotlin.a.p.listOf(new Class[] { FinderTopicFeedUI.class, FinderSelfUI.class, FinderProfileUI.class });
    this.ETW = new Vector();
    AppMethodBeat.o(349409);
  }
  
  public final boolean a(kotlin.g.a.a<ah> parama1, final kotlin.g.a.a<ah> parama2)
  {
    AppMethodBeat.i(349459);
    kotlin.g.b.s.u(parama1, "whenPreCheckReConnect");
    this.ETU = parama1;
    parama1 = this.AwM;
    if (parama1 == null)
    {
      parama1 = null;
      if (parama1 != null) {
        break label193;
      }
      parama1 = (g)this;
      Log.i("SimpleUIComponent", "prepareResp null,isNetSceneFailed:" + parama1.ETT + " , isNetScenePending:" + parama1.ETS);
      if (!parama1.ETT) {
        break label156;
      }
      aa.makeText((Context)parama1.getActivity(), e.h.finder_cgi_failed, 0).show();
    }
    for (;;)
    {
      AppMethodBeat.o(349459);
      return false;
      ad localad = ad.Ghf;
      if (!ad.a((Activity)getActivity(), parama1, (kotlin.g.a.a)new a(this, parama2))) {
        Log.i("SimpleUIComponent", "preCheck interrupt");
      }
      for (bool = false;; bool = true)
      {
        parama1 = Boolean.valueOf(bool);
        break;
      }
      label156:
      if (parama1.ETS) {
        parama1.loadingDialog = w.a((Context)parama1.getActivity(), (CharSequence)parama1.getString(e.h.app_waiting), true, 3, null);
      }
    }
    label193:
    boolean bool = parama1.booleanValue();
    AppMethodBeat.o(349459);
    return bool;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(349432);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.h.aZW().a(3761, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(349432);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(349437);
    super.onDestroy();
    com.tencent.mm.kernel.h.aZW().b(3761, (com.tencent.mm.am.h)this);
    this.ETW.clear();
    AppMethodBeat.o(349437);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(349446);
    super.onResume();
    if (this.AwM == null)
    {
      this.ETS = true;
      if (!this.ETV.contains(getActivity().getClass()))
      {
        com.tencent.mm.kernel.c.a locala = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
        kotlin.g.b.s.s(locala, "service(IFinderCommonService::class.java)");
        h.a.a((com.tencent.mm.plugin.h)locala, 8);
      }
    }
    AppMethodBeat.o(349446);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    int j = 1;
    AppMethodBeat.i(349466);
    Log.i("SimpleUIComponent", "errType:" + paramInt1 + " , errCode:" + paramInt2);
    this.ETS = false;
    int i;
    boolean bool;
    label128:
    label155:
    label187:
    q localq;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramp instanceof bl)) {
        this.AwM = ((bl)paramp).dVy();
      }
      paramString = this.loadingDialog;
      if ((paramString != null) && (paramString.isShowing() == true))
      {
        i = 1;
        if (i != 0)
        {
          Log.i("SimpleUIComponent", "loadingDialog is showing");
          paramString = this.ETU;
          if (paramString != null) {
            paramString.invoke();
          }
        }
        bool = false;
        this.ETT = bool;
        paramString = this.loadingDialog;
        if ((paramString == null) || (paramString.isShowing() != true)) {
          break label267;
        }
        i = j;
        if (i != 0)
        {
          paramString = this.loadingDialog;
          if (paramString != null) {
            paramString.dismiss();
          }
        }
        paramp = ((Iterable)this.ETW).iterator();
        if (!paramp.hasNext()) {
          break label281;
        }
        localq = (q)paramp.next();
        if (!this.ETT) {
          break label273;
        }
      }
    }
    label267:
    label273:
    for (paramString = null;; paramString = this.AwM)
    {
      localq.invoke(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString);
      break label187;
      i = 0;
      break;
      aa.makeText((Context)getActivity(), e.h.finder_cgi_failed, 0).show();
      bool = true;
      break label128;
      i = 0;
      break label155;
    }
    label281:
    AppMethodBeat.o(349466);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(g paramg, kotlin.g.a.a<ah> parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.post.g
 * JD-Core Version:    0.7.0.1
 */