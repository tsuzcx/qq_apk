package com.tencent.mm.mj_template.album_template.single_template;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import androidx.lifecycle.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.mj_template.api.MJTemplateSession;
import com.tencent.mm.mj_template.api.MaasAlbumTemplateRequestParams;
import com.tencent.mm.mj_template.plugin.c.e;
import com.tencent.mm.mj_template.report.MaasPageFinderReporter;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.protocal.protobuf.fxr;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMComposeActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.l;
import com.tencent.mm.ui.widget.pulldown.c;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.ah;
import kotlin.g.b.ai;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k;

@com.tencent.mm.ui.base.a(3)
@c(0)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/album_template/single_template/MaasAlbumTemplatePreviewUI;", "Lcom/tencent/mm/ui/MMComposeActivity;", "()V", "mRequestParams", "Lcom/tencent/mm/mj_template/api/MaasAlbumTemplateRequestParams;", "getMRequestParams", "()Lcom/tencent/mm/mj_template/api/MaasAlbumTemplateRequestParams;", "mRequestParams$delegate", "Lkotlin/Lazy;", "sessionId", "", "getSessionId", "()Ljava/lang/String;", "sessionId$delegate", "sourceSns", "", "getSourceSns", "()Z", "sourceSns$delegate", "getForceOrientation", "", "getLayoutId", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setWindowStyle", "Companion", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MaasAlbumTemplatePreviewUI
  extends MMComposeActivity
{
  public static final MaasAlbumTemplatePreviewUI.a nXJ;
  private final kotlin.j nWJ;
  private final kotlin.j nWN;
  private final kotlin.j nXK;
  
  static
  {
    AppMethodBeat.i(240532);
    nXJ = new MaasAlbumTemplatePreviewUI.a((byte)0);
    AppMethodBeat.o(240532);
  }
  
  public MaasAlbumTemplatePreviewUI()
  {
    AppMethodBeat.i(240515);
    this.nXK = k.cm((kotlin.g.a.a)new d(this));
    this.nWN = k.cm((kotlin.g.a.a)c.nXM);
    this.nWJ = k.cm((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(240515);
  }
  
  private final boolean bxb()
  {
    AppMethodBeat.i(240521);
    boolean bool = ((Boolean)this.nXK.getValue()).booleanValue();
    AppMethodBeat.o(240521);
    return bool;
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getForceOrientation()
  {
    return 1;
  }
  
  public final int getLayoutId()
  {
    AppMethodBeat.i(240539);
    if (bxb())
    {
      i = c.e.ocU;
      AppMethodBeat.o(240539);
      return i;
    }
    int i = c.e.ocT;
    AppMethodBeat.o(240539);
    return i;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(240551);
    if (bxb())
    {
      localSet = ar.setOf(new Class[] { l.a(ai.cz(com.tencent.mm.mj_template.maas.c.a.class)), com.tencent.mm.mj_template.sns.b.a.class });
      AppMethodBeat.o(240551);
      return localSet;
    }
    Set localSet = ar.setOf(new Class[] { b.class, l.a(ai.cz(com.tencent.mm.mj_template.maas.c.a.class)) });
    AppMethodBeat.o(240551);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(240567);
    h.w((MMActivity)this);
    super.onCreate(paramBundle);
    if (!bxb())
    {
      paramBundle = getLifecycle();
      Object localObject1 = (String)this.nWN.getValue();
      Object localObject2 = getIntent();
      s.s(localObject2, "intent");
      localObject1 = new MaasPageFinderReporter((String)localObject1, 133, "shoot_same_video", (Intent)localObject2);
      localObject2 = ((MaasAlbumTemplateRequestParams)this.nWJ.getValue()).nZs.bxj().id;
      s.s(localObject2, "mRequestParams.mjTemplateSession.templateInfo.id");
      MaasPageFinderReporter.a((MaasPageFinderReporter)localObject1, (String)localObject2);
      localObject2 = ah.aiuX;
      paramBundle.addObserver((p)localObject1);
    }
    setSelfNavigationBarVisible(8);
    getWindow().addFlags(2097280);
    getWindow().setFlags(201327616, 201327616);
    com.tencent.mm.plugin.mmsight.d.ys(true);
    com.tencent.mm.ui.statusbar.d.mM((Context)this);
    getWindow().setFormat(-3);
    hideTitleView();
    setLightNavigationbarIcon();
    AppMethodBeat.o(240567);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/mj_template/api/MaasAlbumTemplateRequestParams;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<MaasAlbumTemplateRequestParams>
  {
    b(MaasAlbumTemplatePreviewUI paramMaasAlbumTemplatePreviewUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<String>
  {
    public static final c nXM;
    
    static
    {
      AppMethodBeat.i(240504);
      nXM = new c();
      AppMethodBeat.o(240504);
    }
    
    c()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<Boolean>
  {
    d(MaasAlbumTemplatePreviewUI paramMaasAlbumTemplatePreviewUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.album_template.single_template.MaasAlbumTemplatePreviewUI
 * JD-Core Version:    0.7.0.1
 */