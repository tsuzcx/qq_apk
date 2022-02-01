package com.tencent.mm.mj_template.sns;

import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.mj_template.plugin.c.e;
import com.tencent.mm.plugin.comm.b.e;
import com.tencent.mm.plugin.comm.b.e.a;
import com.tencent.mm.ui.MMComposeActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.l;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.g.b.ai;

@com.tencent.mm.ui.base.a(3)
@com.tencent.mm.ui.widget.pulldown.c(0)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/sns/SnsTemplateUI;", "Lcom/tencent/mm/ui/MMComposeActivity;", "()V", "getForceOrientation", "", "getLayoutId", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "setWindowStyle", "Companion", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class SnsTemplateUI
  extends MMComposeActivity
{
  public static final SnsTemplateUI.a odO;
  
  static
  {
    AppMethodBeat.i(240152);
    odO = new SnsTemplateUI.a((byte)0);
    AppMethodBeat.o(240152);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getForceOrientation()
  {
    return 1;
  }
  
  public final int getLayoutId()
  {
    return c.e.ocU;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(240174);
    Set localSet = ar.setOf(new Class[] { l.a(ai.cz(com.tencent.mm.mj_template.maas.c.a.class)), com.tencent.mm.mj_template.sns.b.a.class });
    AppMethodBeat.o(240174);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(240186);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    setSelfNavigationBarVisible(8);
    getWindow().addFlags(2097280);
    getWindow().setFlags(201327616, 201327616);
    com.tencent.mm.plugin.mmsight.d.ys(true);
    com.tencent.mm.ui.statusbar.d.mM((Context)this);
    getWindow().setFormat(-3);
    setLightNavigationbarIcon();
    e.xfd.a("SnsPublishProcess", "egsessionCnt", Integer.valueOf(1), com.tencent.mm.plugin.comm.b.c.xeT);
    AppMethodBeat.o(240186);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(240205);
    super.onDestroy();
    e.xfd.a("SnsPublishProcess", "egEditTime", Long.valueOf(getActivityBrowseTimeMs()), com.tencent.mm.plugin.comm.b.c.xeT);
    AppMethodBeat.o(240205);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.sns.SnsTemplateUI
 * JD-Core Version:    0.7.0.1
 */