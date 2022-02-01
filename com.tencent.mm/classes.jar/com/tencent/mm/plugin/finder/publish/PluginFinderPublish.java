package com.tencent.mm.plugin.finder.publish;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.plugin.finder.report.v;
import com.tencent.mm.plugin.vlog.model.m;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/publish/PluginFinderPublish;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "Lcom/tencent/mm/plugin/finder/publish/IPluginFinderPublish;", "()V", "TAG", "", "execute", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "finderPostFileManager", "Lcom/tencent/mm/plugin/finder/publish/IFinderPostFileManager;", "finderPostManager", "Lcom/tencent/mm/plugin/finder/publish/IFinderPostManager;", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "publishPostApi", "Lcom/tencent/mm/plugin/finder/publish/IPublishPostApi;", "publishRouterApi", "Lcom/tencent/mm/plugin/finder/publish/IPublishRouterApi;", "publishStatApi", "Lcom/tencent/mm/plugin/finder/publish/IPublishStatApi;", "publishVlogApi", "Lcom/tencent/mm/plugin/finder/publish/IPublishVlogApi;", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PluginFinderPublish
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.c, c
{
  private final String TAG = "Finder.PluginFinderPublish";
  
  public final void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public final a finderPostFileManager()
  {
    return (a)com.tencent.mm.plugin.finder.upload.f.GbE;
  }
  
  public final b finderPostManager()
  {
    AppMethodBeat.i(330580);
    Object localObject = com.tencent.mm.plugin.finder.upload.g.GbJ;
    localObject = (b)com.tencent.mm.plugin.finder.upload.g.fdW();
    AppMethodBeat.o(330580);
    return localObject;
  }
  
  public final void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(330616);
    paramc = com.tencent.mm.plugin.finder.upload.g.GbJ;
    paramc = com.tencent.mm.plugin.finder.upload.g.fdW();
    paramc.nry.a((com.tencent.mm.loader.f.e)paramc.GbQ);
    paramc.GbK.a((com.tencent.mm.loader.f.e)paramc.GbR);
    paramc = com.tencent.mm.plugin.finder.upload.g.GbJ;
    paramc = com.tencent.mm.plugin.finder.upload.g.fdW();
    Object localObject = v.FrN;
    paramc.a(v.eMU());
    paramc = com.tencent.mm.plugin.finder.upload.g.GbJ;
    paramc = com.tencent.mm.plugin.finder.upload.g.fdW();
    localObject = com.tencent.mm.plugin.finder.report.h.Fop;
    paramc.a(com.tencent.mm.plugin.finder.report.h.eMo());
    paramc = m.TYW;
    m.setup();
    AppMethodBeat.o(330616);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(330624);
    Object localObject1 = com.tencent.mm.plugin.finder.upload.g.GbJ;
    localObject1 = com.tencent.mm.plugin.finder.upload.g.fdW();
    ((com.tencent.mm.plugin.finder.upload.g)localObject1).nry.b((com.tencent.mm.loader.f.e)((com.tencent.mm.plugin.finder.upload.g)localObject1).GbQ);
    ((com.tencent.mm.plugin.finder.upload.g)localObject1).GbK.b((com.tencent.mm.loader.f.e)((com.tencent.mm.plugin.finder.upload.g)localObject1).GbR);
    localObject1 = com.tencent.mm.plugin.finder.upload.g.GbJ;
    localObject1 = com.tencent.mm.plugin.finder.upload.g.fdW();
    Object localObject2 = v.FrN;
    ((com.tencent.mm.plugin.finder.upload.g)localObject1).b(v.eMU());
    localObject1 = com.tencent.mm.plugin.finder.upload.g.GbJ;
    localObject1 = com.tencent.mm.plugin.finder.upload.g.fdW();
    localObject2 = com.tencent.mm.plugin.finder.report.h.Fop;
    ((com.tencent.mm.plugin.finder.upload.g)localObject1).b(com.tencent.mm.plugin.finder.report.h.eMo());
    localObject1 = m.TYW;
    m.destroy();
    AppMethodBeat.o(330624);
  }
  
  public final d publishPostApi()
  {
    return (d)h.FhQ;
  }
  
  public final e publishRouterApi()
  {
    return (e)i.FhR;
  }
  
  public final f publishStatApi()
  {
    return (f)j.FhS;
  }
  
  public final g publishVlogApi()
  {
    return (g)k.FhT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.publish.PluginFinderPublish
 * JD-Core Version:    0.7.0.1
 */