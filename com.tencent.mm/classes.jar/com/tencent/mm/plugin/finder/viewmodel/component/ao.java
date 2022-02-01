package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.autogen.mmdata.rpt.ff;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.findersdk.a.bh;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderPageExposeUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderPageExposeUIC;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "activityForceReport", "", "commentScene", "", "getCommentScene", "()I", "commentScene$delegate", "Lkotlin/Lazy;", "finderUsername", "", "getFinderUsername", "()Ljava/lang/String;", "finderUsername$delegate", "kvJson", "Lcom/tencent/mm/json/JSONObject;", "getKvJson", "()Lcom/tencent/mm/json/JSONObject;", "kvJson$delegate", "visibleTimestamp", "", "addKv", "", "key", "value", "onPause", "onResume", "onUserVisibleFocused", "onUserVisibleUnFocused", "report21874", "isExit", "setForceReport", "forceReport", "shouldReportByFragment", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ao
  extends UIComponent
  implements bh
{
  public static final a GSy;
  private final j GSA;
  private long GSB;
  private final j GSC;
  private boolean GSD;
  private final j GSz;
  
  static
  {
    AppMethodBeat.i(338285);
    GSy = new a((byte)0);
    AppMethodBeat.o(338285);
  }
  
  public ao(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(338156);
    this.GSz = k.cm((kotlin.g.a.a)new d(this));
    this.GSA = k.cm((kotlin.g.a.a)new c(this));
    this.GSC = k.cm((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(338156);
  }
  
  public ao(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(338173);
    this.GSz = k.cm((kotlin.g.a.a)new d(this));
    this.GSA = k.cm((kotlin.g.a.a)new c(this));
    this.GSC = k.cm((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(338173);
  }
  
  private final i foh()
  {
    AppMethodBeat.i(338191);
    i locali = (i)this.GSz.getValue();
    AppMethodBeat.o(338191);
    return locali;
  }
  
  private final String foi()
  {
    AppMethodBeat.i(338209);
    String str = (String)this.GSA.getValue();
    AppMethodBeat.o(338209);
    return str;
  }
  
  private final boolean fok()
  {
    AppMethodBeat.i(338273);
    if (isBelongFragment())
    {
      AppMethodBeat.o(338273);
      return false;
    }
    Object localObject = getContext();
    int i;
    if ((localObject instanceof MMFinderUI))
    {
      localObject = (MMFinderUI)localObject;
      if (localObject == null) {
        break label131;
      }
      if (this.GSD) {
        break label121;
      }
      i = 1;
      label49:
      if (i == 0) {
        break label126;
      }
    }
    for (;;)
    {
      if (localObject == null) {
        break label131;
      }
      localObject = ((MMFinderUI)localObject).fcj();
      if (localObject == null) {
        break label131;
      }
      localObject = ((Iterable)localObject).iterator();
      UIComponent localUIComponent;
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localUIComponent = (UIComponent)((Iterator)localObject).next();
      } while ((!(localUIComponent instanceof FinderHomeUIC)) && (!(localUIComponent instanceof FinderTabUIC)));
      AppMethodBeat.o(338273);
      return true;
      localObject = null;
      break;
      label121:
      i = 0;
      break label49;
      label126:
      localObject = null;
    }
    label131:
    AppMethodBeat.o(338273);
    return false;
  }
  
  private final void gP(boolean paramBoolean)
  {
    int j = 0;
    long l2 = 0L;
    Object localObject3 = null;
    AppMethodBeat.i(338253);
    boolean bool = fok();
    Log.i("FinderPageExposeUIC", "report21874: isExit = " + paramBoolean + ", commentScene = " + getCommentScene() + ", visibleTimestamp = " + this.GSB + ", isContainFragment = " + bool + " udf_kv:" + foh());
    if ((getCommentScene() == 0) || (bool))
    {
      AppMethodBeat.o(338253);
      return;
    }
    if (((paramBoolean) && (this.GSB <= 0L)) || ((!paramBoolean) && (this.GSB > 0L)))
    {
      AppMethodBeat.o(338253);
      return;
    }
    Object localObject1 = as.GSQ;
    localObject1 = as.a.hu((Context)getContext());
    Object localObject2;
    label178:
    label194:
    label211:
    int i;
    if (localObject1 == null)
    {
      localObject1 = null;
      ff localff = new ff();
      if (localObject1 != null) {
        break label421;
      }
      localObject2 = null;
      localff.pF((String)localObject2);
      if (localObject1 != null) {
        break label431;
      }
      localObject2 = null;
      localff.pG((String)localObject2);
      if (localObject1 != null) {
        break label441;
      }
      localObject2 = localObject3;
      localff.pL((String)localObject2);
      localff.pH(String.valueOf(getCommentScene()));
      if (localObject1 != null) {
        break label451;
      }
      i = 0;
      label239:
      localff.pM(String.valueOf(i));
      i = j;
      if (paramBoolean) {
        i = 1;
      }
      localff.iGK = i;
      localff.pI(String.valueOf(cn.bDw()));
      localff.pJ(foi());
      if (!paramBoolean) {
        break label460;
      }
      l1 = cn.bDw() - this.GSB;
      label299:
      localff.iGM = l1;
      if (foh().length() <= 0) {
        break label466;
      }
      localObject2 = foh().toString();
      s.s(localObject2, "kvJson.toString()");
      localObject2 = n.bV((String)localObject2, ",", ";");
      label346:
      localff.pK((String)localObject2);
      if (localObject1 != null) {
        break label474;
      }
      localObject1 = "";
      label364:
      localff.pN((String)localObject1);
      localff.bMH();
      localObject1 = z.FrZ;
      z.a((com.tencent.mm.plugin.report.a)localff);
      if (!paramBoolean) {
        break label498;
      }
    }
    label421:
    label431:
    label441:
    label451:
    label460:
    label466:
    label474:
    label498:
    for (long l1 = l2;; l1 = cn.bDw())
    {
      this.GSB = l1;
      AppMethodBeat.o(338253);
      return;
      localObject1 = ((as)localObject1).fou();
      break;
      localObject2 = ((bui)localObject1).sessionId;
      break label178;
      localObject2 = ((bui)localObject1).zIO;
      break label194;
      localObject2 = ((bui)localObject1).zIB;
      break label211;
      i = ((bui)localObject1).hLK;
      break label239;
      l1 = 0L;
      break label299;
      localObject2 = "";
      break label346;
      localObject2 = ((bui)localObject1).DUN;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label364;
      }
      localObject1 = "";
      break label364;
    }
  }
  
  private final int getCommentScene()
  {
    AppMethodBeat.i(338225);
    int i = ((Number)this.GSC.getValue()).intValue();
    AppMethodBeat.o(338225);
    return i;
  }
  
  public final void foj()
  {
    this.GSD = true;
  }
  
  public final void iv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(338356);
    s.u(paramString1, "key");
    s.u(paramString2, "value");
    foh().m(paramString1, paramString2);
    AppMethodBeat.o(338356);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(338343);
    super.onPause();
    if ((isBelongFragment()) && (isUserVisibleFocused())) {
      gP(true);
    }
    AppMethodBeat.o(338343);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(338308);
    super.onResume();
    if ((isBelongFragment()) && (isUserVisibleFocused())) {
      gP(false);
    }
    AppMethodBeat.o(338308);
  }
  
  public final void onUserVisibleFocused()
  {
    AppMethodBeat.i(338318);
    super.onUserVisibleFocused();
    gP(false);
    AppMethodBeat.o(338318);
  }
  
  public final void onUserVisibleUnFocused()
  {
    AppMethodBeat.i(338329);
    super.onUserVisibleUnFocused();
    gP(true);
    AppMethodBeat.o(338329);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderPageExposeUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<Integer>
  {
    b(ao paramao)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<String>
  {
    c(ao paramao)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/json/JSONObject;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<i>
  {
    d(ao paramao)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.ao
 * JD-Core Version:    0.7.0.1
 */