package com.tencent.mm.plugin.finder.live;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
final class PluginFinderLive$l
  extends u
  implements a<ah>
{
  PluginFinderLive$l(String paramString1, long paramLong, String paramString2, Context paramContext, Intent paramIntent, PluginFinderLive paramPluginFinderLive, Long paramLong1, String paramString3, String paramString4, String paramString5)
  {
    super(0);
  }
  
  private static final void a(final String paramString1, final Context paramContext, Intent paramIntent, final PluginFinderLive paramPluginFinderLive, final long paramLong, Long paramLong1, final String paramString2, final String paramString3, final String paramString4, final String paramString5, final FinderObject paramFinderObject, boolean paramBoolean)
  {
    AppMethodBeat.i(350952);
    if (paramFinderObject == null)
    {
      Log.e("Plugin.FinderLive", "enterFinderProfileUI requestFinderObject null");
      if (paramBoolean)
      {
        d.uiThread((a)new PluginFinderLive.l.a(paramContext));
        AppMethodBeat.o(350952);
      }
    }
    else
    {
      b.aqZ(paramString1);
      d.uiThread((a)new b(paramIntent, paramFinderObject, paramPluginFinderLive, paramContext, paramLong, paramLong1, paramString2, paramString3, paramString1, paramString4, paramString5));
    }
    AppMethodBeat.o(350952);
  }
  
  private static final void a(String paramString1, Context paramContext, Intent paramIntent, PluginFinderLive paramPluginFinderLive, long paramLong, Long paramLong1, String paramString2, String paramString3, String paramString4, String paramString5, Object paramObject, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(350963);
    s.u(paramString1, "$contextId");
    s.u(paramPluginFinderLive, "this$0");
    s.u(paramString2, "$nonceId");
    if ((paramObject instanceof FinderObject)) {}
    for (paramObject = (FinderObject)paramObject;; paramObject = null)
    {
      a(paramString1, paramContext, paramIntent, paramPluginFinderLive, paramLong, paramLong1, paramString2, paramString3, paramString4, paramString5, paramObject, true);
      AppMethodBeat.o(350963);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<ah>
  {
    b(Intent paramIntent, FinderObject paramFinderObject, PluginFinderLive paramPluginFinderLive, Context paramContext, long paramLong, Long paramLong1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.PluginFinderLive.l
 * JD-Core Version:    0.7.0.1
 */