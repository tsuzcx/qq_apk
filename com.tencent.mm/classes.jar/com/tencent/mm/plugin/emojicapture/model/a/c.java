package com.tencent.mm.plugin.emojicapture.model.a;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.LinkedList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerMgr;", "", "()V", "TAG", "", "callbacks", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerMgr$StickerResCallback;", "Lkotlin/collections/HashSet;", "emptySticker", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerInfo;", "getEmptySticker", "()Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerInfo;", "orderIndex", "", "requestSticker", "Ljava/util/LinkedList;", "scene", "stickerConfig", "Lcom/tencent/mm/plugin/emojicapture/model/xml/EmoticonLensConfig;", "stickerList", "addCallback", "", "callback", "checkResUpdate", "subType", "destroy", "init", "onResUpdate", "parseFile", "removeCallback", "StickerResCallback", "plugin-emojicapture_release"})
public final class c
{
  private static final String TAG = "MicroMsg.EmojiStickerMgr";
  private static final b ltL;
  private static final LinkedList<b> ltM;
  private static com.tencent.mm.plugin.emojicapture.model.c.a ltN;
  private static final HashSet<c.a> ltO;
  private static final LinkedList<Integer> ltP;
  public static final c ltQ;
  private static int scene;
  
  static
  {
    AppMethodBeat.i(2645);
    ltQ = new c();
    TAG = "MicroMsg.EmojiStickerMgr";
    ltL = new b();
    ltM = new LinkedList();
    ltN = new com.tencent.mm.plugin.emojicapture.model.c.a();
    ltO = new HashSet();
    ltP = new LinkedList();
    AppMethodBeat.o(2645);
  }
  
  public static void a(c.a parama)
  {
    AppMethodBeat.i(2643);
    j.q(parama, "callback");
    ltO.add(parama);
    parama.S(ltM);
    parama.boB();
    AppMethodBeat.o(2643);
  }
  
  public static b bov()
  {
    return ltL;
  }
  
  public static void destroy()
  {
    AppMethodBeat.i(2642);
    ltM.clear();
    ltO.clear();
    ltP.clear();
    AppMethodBeat.o(2642);
  }
  
  public static void init(int paramInt)
  {
    AppMethodBeat.i(2641);
    scene = paramInt;
    e locale = e.luf;
    e.boF();
    AppMethodBeat.o(2641);
  }
  
  public static void uG(int paramInt)
  {
    AppMethodBeat.i(2644);
    com.tencent.mm.ab.b.a("EmojiStickerMgr_onResUpdate", (a.f.a.a)new c.b(paramInt));
    AppMethodBeat.o(2644);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.a.c
 * JD-Core Version:    0.7.0.1
 */