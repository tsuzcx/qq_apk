package com.tencent.mm.plugin.appbrand.headless;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.page.ca;
import com.tencent.mm.plugin.appbrand.page.ca.a;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.page.x;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/headless/HeadlessPageView;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "page", "Lcom/tencent/mm/plugin/appbrand/headless/HeadlessPage;", "(Lcom/tencent/mm/plugin/appbrand/headless/HeadlessPage;)V", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends ah
{
  public c(b paramb)
  {
    super(d.class);
    AppMethodBeat.i(317551);
    ca localca2 = paramb.getPageContainer().getDecorWidgetFactory();
    ca localca1 = localca2;
    if (localca2 == null) {
      localca1 = (ca)new ca.a();
    }
    this.tvz = localca1;
    super.t((u)paramb);
    AppMethodBeat.o(317551);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.headless.c
 * JD-Core Version:    0.7.0.1
 */