package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.extension.reddot.p;
import com.tencent.mm.plugin.finder.viewmodel.d;
import com.tencent.mm.plugin.finder.viewmodel.d.a;
import com.tencent.mm.plugin.finder.viewmodel.d.d;
import com.tencent.mm.plugin.findersdk.a.bl;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.protocal.protobuf.bcd;
import com.tencent.mm.protocal.protobuf.btx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderRedDotUIJumpUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "enterCtrlInfo", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "getEnterCtrlInfo", "()Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "enterCtrlInfo$delegate", "Lkotlin/Lazy;", "enterCtrlInfoExt", "Lcom/tencent/mm/protocal/protobuf/FinderRedDotExtInfo;", "getEnterCtrlInfoExt", "()Lcom/tencent/mm/protocal/protobuf/FinderRedDotExtInfo;", "setEnterCtrlInfoExt", "(Lcom/tencent/mm/protocal/protobuf/FinderRedDotExtInfo;)V", "homeTabStateVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "getHomeTabStateVM", "()Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "setHomeTabStateVM", "(Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;)V", "getEnterPath", "", "isIgnore", "", "markHardRefresh", "", "onCreateBefore", "savedInstanceState", "Landroid/os/Bundle;", "printJumpConfig", "config", "Lcom/tencent/mm/protocal/protobuf/FinderJumpConfig;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public class ar
  extends UIComponent
{
  public static final a GSL;
  private btx GSM;
  private final j GSN;
  private d GSO;
  
  static
  {
    AppMethodBeat.i(338081);
    GSL = new a((byte)0);
    AppMethodBeat.o(338081);
  }
  
  public ar(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(338066);
    this.GSN = kotlin.k.cm((kotlin.g.a.a)new b(this));
    paramAppCompatActivity = com.tencent.mm.ui.component.k.aeZF;
    paramAppCompatActivity = com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(d.class);
    s.s(paramAppCompatActivity, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    this.GSO = ((d)paramAppCompatActivity);
    AppMethodBeat.o(338066);
  }
  
  public ar(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(338076);
    this.GSN = kotlin.k.cm((kotlin.g.a.a)new b(this));
    paramFragment = com.tencent.mm.ui.component.k.aeZF;
    paramFragment = com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(d.class);
    s.s(paramFragment, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    this.GSO = ((d)paramFragment);
    AppMethodBeat.o(338076);
  }
  
  public String eDX()
  {
    return "FinderEntrance";
  }
  
  public void eDY()
  {
    AppMethodBeat.i(338137);
    int i = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().dZq();
    Log.i("Finder.RedDotUIJumpUIC", s.X("[markHardRefresh] aliveType=", Integer.valueOf(i)));
    this.GSO.UV(i).a(d.d.GKM);
    AppMethodBeat.o(338137);
  }
  
  public boolean eDZ()
  {
    AppMethodBeat.i(338125);
    boolean bool = ((cn)h.az(cn.class)).getRedDotManager().dZs();
    Log.i("Finder.RedDotUIJumpUIC", s.X("[isIgnore] isEnableShowEntranceRedDot=", Boolean.valueOf(bool)));
    if (!bool)
    {
      AppMethodBeat.o(338125);
      return true;
    }
    AppMethodBeat.o(338125);
    return false;
  }
  
  public final d eHM()
  {
    return this.GSO;
  }
  
  public final btx fon()
  {
    return this.GSM;
  }
  
  public void onCreateBefore(Bundle paramBundle)
  {
    Object localObject1 = null;
    int j = 1;
    int k = 1;
    AppMethodBeat.i(338112);
    super.onCreate(paramBundle);
    paramBundle = (p)this.GSN.getValue();
    boolean bool;
    label62:
    Object localObject2;
    if (paramBundle == null)
    {
      paramBundle = null;
      this.GSM = paramBundle;
      paramBundle = new StringBuilder("enterCtrlInfoExt=");
      if (this.GSM == null) {
        break label152;
      }
      bool = true;
      localObject2 = paramBundle.append(bool).append(" enter_action=");
      paramBundle = this.GSM;
      if (paramBundle != null) {
        break label158;
      }
      paramBundle = null;
      label86:
      localObject2 = ((StringBuilder)localObject2).append(paramBundle).append(" jump_config=");
      paramBundle = this.GSM;
      if (paramBundle != null) {
        break label169;
      }
      paramBundle = null;
      label110:
      if (paramBundle != null) {
        break label177;
      }
    }
    label152:
    label158:
    label169:
    label177:
    for (paramBundle = "";; paramBundle = "miniapp_path=" + paramBundle.YBQ + ", miniapp_scene=" + paramBundle.YBS + ", miniapp_username=" + paramBundle.YBP + "web_url=" + paramBundle.xmo)
    {
      Log.i("Finder.RedDotUIJumpUIC", paramBundle);
      if (!eDZ()) {
        break label240;
      }
      AppMethodBeat.o(338112);
      return;
      paramBundle = paramBundle.ASz;
      break;
      bool = false;
      break label62;
      paramBundle = Integer.valueOf(paramBundle.aabL);
      break label86;
      paramBundle = paramBundle.aabP;
      break label110;
    }
    label240:
    paramBundle = this.GSM;
    bcd localbcd;
    if (paramBundle != null)
    {
      localbcd = paramBundle.aabP;
      if (localbcd != null)
      {
        paramBundle = this.GSM;
        if ((paramBundle != null) && (paramBundle.aabL == 6))
        {
          i = 1;
          if (i == 0) {
            break label358;
          }
          paramBundle = localbcd.xmo;
          if (paramBundle == null) {
            break label474;
          }
          if (((CharSequence)paramBundle).length() <= 0) {
            break label348;
          }
          i = k;
          label309:
          if (i == 0) {
            break label353;
          }
        }
        for (;;)
        {
          if (paramBundle == null) {
            break label474;
          }
          eDY();
          localObject1 = com.tencent.mm.plugin.finder.utils.a.GfO;
          com.tencent.mm.plugin.finder.utils.a.aJ((Context)getActivity(), paramBundle);
          AppMethodBeat.o(338112);
          return;
          i = 0;
          break;
          label348:
          i = 0;
          break label309;
          label353:
          paramBundle = null;
        }
        label358:
        paramBundle = this.GSM;
        if ((paramBundle == null) || (paramBundle.aabL != 7)) {
          break label480;
        }
        i = 1;
        if (i != 0)
        {
          localObject2 = localbcd.YBP;
          if (localObject2 != null) {
            if (((CharSequence)localObject2).length() <= 0) {
              break label485;
            }
          }
        }
      }
    }
    label474:
    label480:
    label485:
    for (int i = j;; i = 0)
    {
      paramBundle = (Bundle)localObject1;
      if (i != 0) {
        paramBundle = (Bundle)localObject2;
      }
      if (paramBundle != null)
      {
        eDY();
        localObject1 = com.tencent.mm.plugin.finder.utils.a.GfO;
        Context localContext = (Context)getActivity();
        localObject2 = localbcd.YBQ;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        com.tencent.mm.plugin.finder.utils.a.c(localContext, paramBundle, (String)localObject1, localbcd.YBS);
      }
      AppMethodBeat.o(338112);
      return;
      i = 0;
      break;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderRedDotUIJumpUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<p>
  {
    b(ar paramar)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.ar
 * JD-Core Version:    0.7.0.1
 */