package com.tencent.mm.mj_template.album_template.multi_template;

import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.mj_template.album_template.multi_template.a.d.b;
import com.tencent.mm.mj_template.plugin.c.e;
import com.tencent.mm.mj_template.report.MaasPageFinderReporter;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMComposeActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.component.l;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.g.b.ai;
import kotlin.g.b.s;
import kotlin.g.b.u;

@com.tencent.mm.ui.base.a(3)
@com.tencent.mm.ui.widget.pulldown.c(0)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/album_template/multi_template/MaasAlbumMultiTemplatePreviewUI;", "Lcom/tencent/mm/ui/MMComposeActivity;", "()V", "reporter", "Lcom/tencent/mm/mj_template/report/MaasPageFinderReporter;", "getReporter", "()Lcom/tencent/mm/mj_template/report/MaasPageFinderReporter;", "reporter$delegate", "Lkotlin/Lazy;", "sessionId", "", "getSessionId", "()Ljava/lang/String;", "sessionId$delegate", "finish", "", "getForceOrientation", "", "getLayoutId", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "initReporter", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setWindowStyle", "Companion", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MaasAlbumMultiTemplatePreviewUI
  extends MMComposeActivity
{
  public static final MaasAlbumMultiTemplatePreviewUI.a nWM;
  private final kotlin.j nWN;
  private final kotlin.j nWO;
  
  static
  {
    AppMethodBeat.i(240649);
    nWM = new MaasAlbumMultiTemplatePreviewUI.a((byte)0);
    AppMethodBeat.o(240649);
  }
  
  public MaasAlbumMultiTemplatePreviewUI()
  {
    AppMethodBeat.i(240626);
    this.nWN = kotlin.k.cm((kotlin.g.a.a)MaasAlbumMultiTemplatePreviewUI.d.nWQ);
    this.nWO = kotlin.k.cm((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(240626);
  }
  
  private final MaasPageFinderReporter bwV()
  {
    AppMethodBeat.i(240633);
    MaasPageFinderReporter localMaasPageFinderReporter = (MaasPageFinderReporter)this.nWO.getValue();
    AppMethodBeat.o(240633);
    return localMaasPageFinderReporter;
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final void finish()
  {
    AppMethodBeat.i(240673);
    super.finish();
    overridePendingTransition(0, 0);
    AppMethodBeat.o(240673);
  }
  
  public final int getForceOrientation()
  {
    return 1;
  }
  
  public final int getLayoutId()
  {
    return c.e.ocT;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(240668);
    Set localSet = ar.setOf(new Class[] { a.class, l.a(ai.cz(com.tencent.mm.mj_template.maas.c.a.class)) });
    AppMethodBeat.o(240668);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(240664);
    h.w((MMActivity)this);
    super.onCreate(paramBundle);
    getLifecycle().addObserver((p)bwV());
    setSelfNavigationBarVisible(8);
    getWindow().addFlags(2097280);
    getWindow().setFlags(201327616, 201327616);
    com.tencent.mm.plugin.mmsight.d.ys(true);
    com.tencent.mm.ui.statusbar.d.mM((Context)this);
    getWindow().setFormat(-3);
    hideTitleView();
    setLightNavigationbarIcon();
    paramBundle = com.tencent.mm.ui.component.k.aeZF;
    paramBundle = (a)com.tencent.mm.ui.component.k.d((AppCompatActivity)this).cp(a.class);
    if (paramBundle != null)
    {
      d.b localb = (d.b)new b(this);
      s.u(localb, "reporter");
      paramBundle.nWi.nXt = localb;
    }
    AppMethodBeat.o(240664);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/mj_template/album_template/multi_template/MaasAlbumMultiTemplatePreviewUI$initReporter$1", "Lcom/tencent/mm/mj_template/album_template/multi_template/widget/TemplateListState$IReporter;", "onTemplateExposed", "", "templateId", "", "onTemplateSelected", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements d.b
  {
    b(MaasAlbumMultiTemplatePreviewUI paramMaasAlbumMultiTemplatePreviewUI) {}
    
    public final void HA(String paramString)
    {
      AppMethodBeat.i(240650);
      s.u(paramString, "templateId");
      MaasAlbumMultiTemplatePreviewUI.a(this.nWP).HN(paramString);
      AppMethodBeat.o(240650);
    }
    
    public final void HB(String paramString)
    {
      AppMethodBeat.i(240658);
      s.u(paramString, "templateId");
      MaasAlbumMultiTemplatePreviewUI.a(this.nWP).HO(paramString);
      AppMethodBeat.o(240658);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/mj_template/report/MaasPageFinderReporter;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<MaasPageFinderReporter>
  {
    c(MaasAlbumMultiTemplatePreviewUI paramMaasAlbumMultiTemplatePreviewUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.album_template.multi_template.MaasAlbumMultiTemplatePreviewUI
 * JD-Core Version:    0.7.0.1
 */