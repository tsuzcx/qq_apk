package com.tencent.mm.plugin.appbrand.w.a;

import com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c.b;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.b.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.as;

public class c$a
  implements com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c
{
  private static a jyf;
  
  public static a aSB()
  {
    AppMethodBeat.i(143677);
    if (jyf == null) {}
    try
    {
      if (jyf == null) {
        jyf = new a();
      }
      a locala = jyf;
      AppMethodBeat.o(143677);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(143677);
    }
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.video.b.b g(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(143678);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if ((parama instanceof com.tencent.mm.plugin.appbrand.f.b))
    {
      parama = ((com.tencent.mm.plugin.appbrand.f.b)parama).hrA;
      localObject1 = localObject2;
      if (parama != null)
      {
        parama = parama.getAppId();
        boolean bool = a.aLz();
        ab.i("MicroMsg.SameLayer.AppBrandXWebVideoStrategy", "createMediaPlayer, enableWeishiVideoPreload:%s, appId:%s", new Object[] { Boolean.valueOf(bool), parama });
        localObject1 = localObject2;
        if (bool)
        {
          localObject1 = localObject2;
          if ("wxfe02ecfe70800f46".equalsIgnoreCase(parama))
          {
            ab.i("MicroMsg.SameLayer.AppBrandXWebVideoStrategy", "createMediaPlayer, weishi wxapp, use exo media player");
            com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c.a.xZ();
            localObject1 = new com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a.b();
          }
        }
      }
    }
    parama = (com.tencent.luggage.xweb_ext.extendplugin.a)localObject1;
    int i;
    if (localObject1 == null)
    {
      i = as.apq("xweb_abtest_command").decodeInt("xweb_video_player_command_value", -1);
      if (i < 0) {
        break label193;
      }
      ab.i("MicroMsg.SameLayer.AppBrandXWebVideoABTests", "openXWebVideoExoPlayer, command value:%s", new Object[] { Integer.valueOf(i) });
      if (i != 1) {
        break label188;
      }
      i = 1;
      if (i == 0) {
        break label224;
      }
      ab.i("MicroMsg.SameLayer.AppBrandXWebVideoStrategy", "createMediaPlayer, use exo media player");
      com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c.a.xZ();
    }
    for (parama = new com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a.b();; parama = new d())
    {
      AppMethodBeat.o(143678);
      return parama;
      label188:
      i = 0;
      break;
      label193:
      if (((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lUN, 0) == 1)
      {
        i = 1;
        break;
      }
      i = 0;
      break;
      label224:
      ab.i("MicroMsg.SameLayer.AppBrandXWebVideoStrategy", "createMediaPlayer, use system media player");
      c.b.ya();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.w.a.c.a
 * JD-Core Version:    0.7.0.1
 */