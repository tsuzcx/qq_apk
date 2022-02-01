package com.tencent.mm.emoji.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.emoji.b.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/egg/EmojiEggUtil;", "", "()V", "Companion", "plugin-emojisdk_release"})
public final class f
{
  private static final String TAG = "MicroMsg.EmojiEggUtil";
  private static final String dFG = "emoji-anim.xml";
  private static final String gVw;
  private static long gVx;
  private static b gVy;
  public static final a gVz;
  
  static
  {
    AppMethodBeat.i(199897);
    gVz = new a((byte)0);
    TAG = "MicroMsg.EmojiEggUtil";
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.emoji.e.a locala = com.tencent.mm.emoji.e.a.hdT;
    gVw = com.tencent.mm.emoji.e.a.awv() + "panel/";
    dFG = "emoji-anim.xml";
    gVy = new b();
    a.auy();
    AppMethodBeat.o(199897);
  }
  
  public static final String r(ca paramca)
  {
    AppMethodBeat.i(199898);
    paramca = a.r(paramca);
    AppMethodBeat.o(199898);
    return paramca;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/egg/EmojiEggUtil$Companion;", "", "()V", "TAG", "", "animConfig", "Lcom/tencent/mm/emoji/egg/EmojiAnimConfig;", "getAnimConfig", "()Lcom/tencent/mm/emoji/egg/EmojiAnimConfig;", "setAnimConfig", "(Lcom/tencent/mm/emoji/egg/EmojiAnimConfig;)V", "assetDir", "configName", "lastCheckTick", "", "localDir", "versionName", "checkAnimUpdate", "", "getAnimItem", "Lcom/tencent/mm/emoji/egg/EmojiAnimConfig$EmojiAnimItem;", "key", "getMsgContent", "msgInfo", "Lcom/tencent/mm/storage/MsgInfo;", "initAnimConfig", "plugin-emojisdk_release"})
  public static final class a
  {
    public static void auy()
    {
      AppMethodBeat.i(199895);
      int i = com.tencent.mm.emoji.e.b.EY(f.auv() + "config.conf");
      int j = com.tencent.mm.emoji.e.b.EY("assets:///panel/config.conf");
      Object localObject1 = f.auv() + f.auw();
      Object localObject2 = "assets:///panel/" + f.auw();
      if ((i > 0) && (i >= j) && (s.YS((String)localObject1)))
      {
        localObject2 = com.tencent.mm.emoji.b.a.gWU;
        a.a.a((String)localObject1, (com.tencent.mm.emoji.b.a)f.auu());
      }
      for (;;)
      {
        Log.i(f.access$getTAG$cp(), "initAnimConfig: version:" + i + ", " + j + "; content " + f.auu().gUV.size());
        AppMethodBeat.o(199895);
        return;
        localObject1 = com.tencent.mm.emoji.b.a.gWU;
        a.a.a((String)localObject2, (com.tencent.mm.emoji.b.a)f.auu());
      }
    }
    
    public static void auz()
    {
      AppMethodBeat.i(199896);
      if (!MMApplicationContext.isMainProcess())
      {
        AppMethodBeat.o(199896);
        return;
      }
      if (!g.aAc())
      {
        AppMethodBeat.o(199896);
        return;
      }
      if (Util.ticksToNow(f.aux()) > 1800000L)
      {
        f.zi(Util.currentTicks());
        com.tencent.mm.pluginsdk.j.a.a.b.gnC().g(37, 7, -1, false);
        com.tencent.mm.pluginsdk.j.a.a.b.gnC();
        com.tencent.mm.pluginsdk.j.a.a.b.ahP(37);
        Log.i(f.access$getTAG$cp(), "checkAnimUpdate: " + f.auu().gUV.size() + ", " + f.aux());
      }
      AppMethodBeat.o(199896);
    }
    
    public static String r(ca paramca)
    {
      AppMethodBeat.i(199894);
      p.h(paramca, "msgInfo");
      Object localObject2 = paramca.getContent();
      Object localObject1 = localObject2;
      if (ab.Eq(paramca.ajO())) {
        localObject1 = bp.Kq((String)localObject2);
      }
      if (!paramca.gDx())
      {
        localObject2 = localObject1;
        if (!paramca.gDy()) {}
      }
      else
      {
        paramca = k.b.aD((String)localObject1, paramca.ajQ());
        if (paramca == null) {
          break label74;
        }
      }
      label74:
      for (localObject2 = paramca.title;; localObject2 = null)
      {
        AppMethodBeat.o(199894);
        return localObject2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.a.f
 * JD-Core Version:    0.7.0.1
 */