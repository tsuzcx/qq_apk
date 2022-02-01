package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.viewmodel.b;
import com.tencent.mm.plugin.finder.viewmodel.b.a;
import com.tencent.mm.plugin.finder.viewmodel.b.e;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.findersdk.a.z;
import com.tencent.mm.protocal.protobuf.awm;
import com.tencent.mm.protocal.protobuf.bhx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g.a;
import kotlin.g.b.p;
import kotlin.g.b.q;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderRedDotUIJumpUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "enterCtrlInfo", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "getEnterCtrlInfo", "()Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "enterCtrlInfo$delegate", "Lkotlin/Lazy;", "enterCtrlInfoExt", "Lcom/tencent/mm/protocal/protobuf/FinderRedDotExtInfo;", "getEnterCtrlInfoExt", "()Lcom/tencent/mm/protocal/protobuf/FinderRedDotExtInfo;", "setEnterCtrlInfoExt", "(Lcom/tencent/mm/protocal/protobuf/FinderRedDotExtInfo;)V", "homeTabStateVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "getHomeTabStateVM", "()Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "setHomeTabStateVM", "(Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;)V", "getEnterPath", "", "isIgnore", "", "markHardRefresh", "", "onCreateBefore", "savedInstanceState", "Landroid/os/Bundle;", "printJumpConfig", "config", "Lcom/tencent/mm/protocal/protobuf/FinderJumpConfig;", "Companion", "plugin-finder_release"})
public class ai
  extends UIComponent
{
  public static final a BmM;
  private bhx BmJ;
  private final kotlin.f BmK;
  private b BmL;
  
  static
  {
    AppMethodBeat.i(272843);
    BmM = new a((byte)0);
    AppMethodBeat.o(272843);
  }
  
  public ai(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(272841);
    this.BmK = kotlin.g.ar((kotlin.g.a.a)new b(this));
    paramAppCompatActivity = com.tencent.mm.ui.component.g.Xox;
    paramAppCompatActivity = com.tencent.mm.ui.component.g.bD(PluginFinder.class).i(b.class);
    p.j(paramAppCompatActivity, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    this.BmL = ((b)paramAppCompatActivity);
    AppMethodBeat.o(272841);
  }
  
  public ai(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(272842);
    this.BmK = kotlin.g.ar((kotlin.g.a.a)new b(this));
    paramFragment = com.tencent.mm.ui.component.g.Xox;
    paramFragment = com.tencent.mm.ui.component.g.bD(PluginFinder.class).i(b.class);
    p.j(paramFragment, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    this.BmL = ((b)paramFragment);
    AppMethodBeat.o(272842);
  }
  
  public String dLg()
  {
    return "FinderEntrance";
  }
  
  public void dLh()
  {
    AppMethodBeat.i(272840);
    com.tencent.mm.kernel.b.a locala = h.ag(PluginFinder.class);
    p.j(locala, "MMKernel.plugin(PluginFinder::class.java)");
    int i = ((PluginFinder)locala).getRedDotManager().dqG();
    Log.i("Finder.RedDotUIJumpUIC", "[markHardRefresh] aliveType=".concat(String.valueOf(i)));
    this.BmL.RI(i).a(b.e.BgO);
    AppMethodBeat.o(272840);
  }
  
  public boolean dLi()
  {
    AppMethodBeat.i(272839);
    Object localObject = h.ag(ak.class);
    p.j(localObject, "MMKernel.plugin(IPluginFinder::class.java)");
    localObject = ((ak)localObject).getRedDotManager();
    p.j(localObject, "MMKernel.plugin(IPluginF…class.java).redDotManager");
    boolean bool = ((z)localObject).dqI();
    Log.i("Finder.RedDotUIJumpUIC", "[isIgnore] isEnableShowEntranceRedDot=".concat(String.valueOf(bool)));
    if (!bool)
    {
      AppMethodBeat.o(272839);
      return true;
    }
    AppMethodBeat.o(272839);
    return false;
  }
  
  public final b dMI()
  {
    return this.BmL;
  }
  
  public final bhx ekS()
  {
    return this.BmJ;
  }
  
  public void onCreateBefore(Bundle paramBundle)
  {
    int j = 1;
    int i = 1;
    Object localObject1 = null;
    AppMethodBeat.i(272837);
    super.onCreate(paramBundle);
    paramBundle = (com.tencent.mm.plugin.finder.extension.reddot.l)this.BmK.getValue();
    boolean bool;
    label64:
    Object localObject2;
    if (paramBundle != null)
    {
      paramBundle = paramBundle.xuM;
      this.BmJ = paramBundle;
      paramBundle = new StringBuilder("enterCtrlInfoExt=");
      if (this.BmJ == null) {
        break label167;
      }
      bool = true;
      localObject2 = paramBundle.append(bool).append(" enter_action=");
      paramBundle = this.BmJ;
      if (paramBundle == null) {
        break label173;
      }
      paramBundle = Integer.valueOf(paramBundle.SSw);
      label94:
      localObject2 = ((StringBuilder)localObject2).append(paramBundle).append(' ').append("jump_config=");
      paramBundle = this.BmJ;
      if (paramBundle == null) {
        break label178;
      }
      paramBundle = paramBundle.SSA;
      label127:
      if (paramBundle != null) {
        break label183;
      }
    }
    label167:
    label173:
    label178:
    label183:
    for (paramBundle = "";; paramBundle = "miniapp_path=" + paramBundle.RFo + ", miniapp_scene=" + paramBundle.RFq + ", miniapp_username=" + paramBundle.RFn + "web_url=" + paramBundle.ugh)
    {
      Log.i("Finder.RedDotUIJumpUIC", paramBundle);
      if (!dLi()) {
        break label246;
      }
      AppMethodBeat.o(272837);
      return;
      paramBundle = null;
      break;
      bool = false;
      break label64;
      paramBundle = null;
      break label94;
      paramBundle = null;
      break label127;
    }
    label246:
    paramBundle = this.BmJ;
    if (paramBundle != null)
    {
      awm localawm = paramBundle.SSA;
      if (localawm != null)
      {
        paramBundle = this.BmJ;
        if ((paramBundle != null) && (paramBundle.SSw == 6))
        {
          paramBundle = localawm.ugh;
          if (paramBundle != null)
          {
            p.j(paramBundle, "it");
            if (((CharSequence)paramBundle).length() > 0) {
              if (i == 0) {
                break label363;
              }
            }
            for (;;)
            {
              if (paramBundle == null) {
                break label368;
              }
              dLh();
              localObject1 = com.tencent.mm.plugin.finder.utils.a.ACH;
              localObject1 = (Context)getActivity();
              p.j(paramBundle, "url");
              com.tencent.mm.plugin.finder.utils.a.aH((Context)localObject1, paramBundle);
              AppMethodBeat.o(272837);
              return;
              i = 0;
              break;
              label363:
              paramBundle = null;
            }
          }
          label368:
          AppMethodBeat.o(272837);
          return;
        }
        paramBundle = this.BmJ;
        if (paramBundle != null)
        {
          if (paramBundle.SSw != 7) {
            break label517;
          }
          localObject2 = localawm.RFn;
          if (localObject2 == null) {
            break label517;
          }
          p.j(localObject2, "it");
          if (((CharSequence)localObject2).length() <= 0) {
            break label512;
          }
        }
        label512:
        for (i = j;; i = 0)
        {
          paramBundle = (Bundle)localObject1;
          if (i != 0) {
            paramBundle = (Bundle)localObject2;
          }
          if (paramBundle == null) {
            break;
          }
          dLh();
          localObject1 = com.tencent.mm.plugin.finder.utils.a.ACH;
          Context localContext = (Context)getActivity();
          p.j(paramBundle, "appId");
          localObject2 = localawm.RFo;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          com.tencent.mm.plugin.finder.utils.a.b(localContext, paramBundle, (String)localObject1, localawm.RFq);
          AppMethodBeat.o(272837);
          return;
          AppMethodBeat.o(272837);
          return;
        }
        label517:
        AppMethodBeat.o(272837);
        return;
      }
    }
    AppMethodBeat.o(272837);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderRedDotUIJumpUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.extension.reddot.l>
  {
    b(ai paramai)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.ai
 * JD-Core Version:    0.7.0.1
 */