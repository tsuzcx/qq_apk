package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.accessibility.o;
import com.tencent.mm.plugin.finder.post.g;
import com.tencent.mm.plugin.finder.profile.uic.FinderProfileTabUIC;
import com.tencent.mm.plugin.finder.profile.uic.e;
import com.tencent.mm.plugin.finder.profile.uic.f;
import com.tencent.mm.plugin.finder.profile.uic.n;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.findersdk.a.av;
import com.tencent.mm.plugin.findersdk.a.bh;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.component.l;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.a.ar;
import kotlin.g.b.ai;
import kotlin.g.b.s;
import kotlin.r;
import kotlin.v;
import org.apache.commons.c.i;

@com.tencent.mm.ui.base.a(32)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderProfileUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/plugin/finder/interfaces/IFinderProfileUI;", "()V", "getCommentScene", "", "getReportType", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "intent", "Landroid/content/Intent;", "onResume", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderProfileUI
  extends MMFinderUI
  implements com.tencent.mm.plugin.finder.interfaces.a
{
  public static final a Brn;
  
  static
  {
    AppMethodBeat.i(166213);
    Brn = new a((byte)0);
    AppMethodBeat.o(166213);
  }
  
  public FinderProfileUI()
  {
    AppMethodBeat.i(166212);
    AppMethodBeat.o(166212);
  }
  
  private static final Map a(FinderProfileUI paramFinderProfileUI, String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(364244);
    s.u(paramFinderProfileUI, "this$0");
    paramString = paramFinderProfileUI.getIntent();
    if (paramString == null)
    {
      paramString = null;
      paramString = String.valueOf(paramString);
      if (!i.hm(paramString)) {
        break label208;
      }
      paramString = com.tencent.mm.plugin.expt.hellhound.ext.b.d.d.zIX;
      paramString = com.tencent.mm.plugin.expt.hellhound.ext.b.d.d.dKW();
    }
    label208:
    for (;;)
    {
      String str = ((com.tencent.mm.plugin.expt.b.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN();
      Object localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
      r localr1 = v.Y("session_id", localObject1);
      str = com.tencent.mm.plugin.expt.hellhound.core.b.bys();
      localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
      r localr2 = v.Y("finder_context_id", localObject1);
      str = com.tencent.mm.plugin.expt.hellhound.core.b.dIX();
      localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
      localObject1 = v.Y("finder_tab_context_id", localObject1);
      paramString = v.Y("extra_info", paramString);
      paramFinderProfileUI = paramFinderProfileUI.getIntent();
      if (paramFinderProfileUI == null) {}
      for (paramFinderProfileUI = localObject2;; paramFinderProfileUI = paramFinderProfileUI.getStringExtra("key_enter_source_info"))
      {
        paramFinderProfileUI = ak.e(new r[] { localr1, localr2, localObject1, paramString, v.Y("enter_source_info", String.valueOf(paramFinderProfileUI)) });
        AppMethodBeat.o(364244);
        return paramFinderProfileUI;
        paramString = paramString.getStringExtra("key_extra_info");
        break;
      }
    }
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int edC()
  {
    return 3;
  }
  
  public final int getCommentScene()
  {
    int j = 0;
    AppMethodBeat.i(364278);
    String str = getIntent().getStringExtra("finder_username");
    boolean bool = getIntent().getBooleanExtra("KEY_FINDER_SELF_FLAG", false);
    int i = j;
    if (s.p(str, z.bAW()))
    {
      i = j;
      if (bool) {
        i = 1;
      }
    }
    if (i != 0)
    {
      AppMethodBeat.o(364278);
      return 33;
    }
    AppMethodBeat.o(364278);
    return 32;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(364267);
    Set localSet = ar.setOf(new Class[] { FinderProfileTabUIC.class, com.tencent.mm.plugin.finder.profile.uic.a.class, com.tencent.mm.plugin.finder.profile.uic.h.class, e.class, l.a(ai.cz(av.class)), f.class, com.tencent.mm.plugin.finder.viewmodel.component.d.class, g.class, com.tencent.mm.plugin.finder.viewmodel.teenmode.b.class, o.class, n.class });
    AppMethodBeat.o(364267);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(166193);
    super.onCreate(paramBundle);
    paramBundle = k.aeZF;
    ((bh)k.d((AppCompatActivity)this).cq(bh.class)).foj();
    ((com.tencent.mm.plugin.datareport.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.datareport.a.b.class)).a(this, com.tencent.mm.plugin.datareport.a.a.a.xgw);
    ((com.tencent.mm.plugin.datareport.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.datareport.a.b.class)).g(this, getClass().getSimpleName());
    ((com.tencent.mm.plugin.datareport.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.datareport.a.b.class)).eE(this);
    ((com.tencent.mm.plugin.datareport.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.datareport.a.b.class)).a(this, new FinderProfileUI..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(166193);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(166206);
    super.onDestroy();
    com.tencent.mm.media.camera.e.a locala = com.tencent.mm.media.camera.e.a.nvP;
    com.tencent.mm.media.camera.e.a.bop();
    AppMethodBeat.o(166206);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(364317);
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    AppMethodBeat.o(364317);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(166203);
    super.onResume();
    if (((com.tencent.mm.plugin.finder.publish.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.finder.publish.c.class)).publishPostApi().eKZ())
    {
      com.tencent.mm.media.camera.e.a locala = com.tencent.mm.media.camera.e.a.nvP;
      com.tencent.mm.media.camera.f.c.a(com.tencent.mm.media.camera.e.a.bon(), (com.tencent.mm.media.j.a)new com.tencent.mm.plugin.recordvideo.e.a());
    }
    AppMethodBeat.o(166203);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$Companion;", "", "()V", "MARK_READ_PAYLOAD", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI
 * JD-Core Version:    0.7.0.1
 */