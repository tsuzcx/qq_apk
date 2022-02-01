package com.tencent.mm.emoji.sync;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.j;
import com.tencent.mm.loader.g.a.g;
import com.tencent.mm.protocal.protobuf.EmotionDetail;
import com.tencent.mm.protocal.protobuf.GetEmotionDetailResponse;
import com.tencent.mm.protocal.protobuf.PersonalDesigner;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.m;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/sync/EmojiPackSyncManager;", "", "()V", "designerCallback", "com/tencent/mm/emoji/sync/EmojiPackSyncManager$designerCallback$1", "Lcom/tencent/mm/emoji/sync/EmojiPackSyncManager$designerCallback$1;", "designerQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/emoji/sync/EmojiDesignerTask;", "finishCount", "", "taskCount", "destroy", "", "start", "Companion", "plugin-emojisdk_release"})
public final class d
{
  private static final String TAG = "MicroMsg.EmojiPackSyncManager";
  private static d hcH;
  public static final a hcI;
  final com.tencent.mm.loader.g.d<b> hcD;
  private int hcE;
  private int hcF;
  final b hcG;
  
  static
  {
    AppMethodBeat.i(183985);
    hcI = new a((byte)0);
    TAG = "MicroMsg.EmojiPackSyncManager";
    AppMethodBeat.o(183985);
  }
  
  public d()
  {
    AppMethodBeat.i(183984);
    this.hcD = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(2147483647), new g(1, (byte)0), 1, "EmojiDesigner"));
    this.hcG = new b(this);
    this.hcD.a((com.tencent.mm.loader.g.f)this.hcG);
    AppMethodBeat.o(183984);
  }
  
  public final void start()
  {
    AppMethodBeat.i(183983);
    Object localObject = j.auL();
    p.g(localObject, "EmojiStorageCache.getInstance()");
    ArrayList localArrayList1 = ((j)localObject).auP();
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = localArrayList1.iterator();
    EmojiGroupInfo localEmojiGroupInfo;
    com.tencent.mm.storage.emotion.l locall;
    GetEmotionDetailResponse localGetEmotionDetailResponse;
    if (localIterator.hasNext())
    {
      localEmojiGroupInfo = (EmojiGroupInfo)localIterator.next();
      localObject = bj.gCJ();
      p.g(localObject, "EmojiStorageMgr.getInstance()");
      localObject = ((bj)localObject).gCL();
      p.g(localEmojiGroupInfo, "groupInfo");
      locall = ((m)localObject).blt(localEmojiGroupInfo.hRu());
      localGetEmotionDetailResponse = new GetEmotionDetailResponse();
      if (locall == null) {
        break label292;
      }
      localObject = locall.field_content;
      if (localObject == null) {}
    }
    for (;;)
    {
      try
      {
        localGetEmotionDetailResponse.parseFrom(locall.field_content);
        if ((localGetEmotionDetailResponse.EmotionDetail != null) && (localGetEmotionDetailResponse.EmotionDetail.PersonalDesigner != null))
        {
          int i = localGetEmotionDetailResponse.EmotionDetail.PersonalDesigner.DesignerUin;
          if (!localArrayList2.contains(Integer.valueOf(i))) {
            localArrayList2.add(Integer.valueOf(i));
          }
          if (localArrayList2.size() < 50) {
            break;
          }
          Log.i(TAG, "start: too many groups " + localArrayList1.size());
          this.hcE = localArrayList2.size();
          localObject = ((Iterable)localArrayList2).iterator();
          if (!((Iterator)localObject).hasNext()) {
            break label405;
          }
          i = ((Number)((Iterator)localObject).next()).intValue();
          Log.i(TAG, "checkStart: add task ".concat(String.valueOf(i)));
          this.hcD.c((com.tencent.mm.loader.g.c)new b(i));
          continue;
          label292:
          localObject = null;
        }
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace(TAG, (Throwable)localException, "", new Object[0]);
        continue;
        Log.i(TAG, "start: GetEmotionDetail " + localEmojiGroupInfo.hRu());
      }
      if (p.j(localEmojiGroupInfo.hRu(), String.valueOf(EmojiGroupInfo.Uum))) {
        break;
      }
      String str = localEmojiGroupInfo.hRu();
      p.g(str, "groupInfo.productID");
      new com.tencent.mm.emoji.b.d(str).aYI().g((com.tencent.mm.vending.c.a)new c(localEmojiGroupInfo));
    }
    label405:
    AppMethodBeat.o(183983);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/sync/EmojiPackSyncManager$Companion;", "", "()V", "TAG", "", "runningSyncTask", "Lcom/tencent/mm/emoji/sync/EmojiPackSyncManager;", "checkPack", "", "productId", "checkStart", "onDesignerEnd", "plugin-emojisdk_release"})
  public static final class a
  {
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    public static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      public a(String paramString, kotlin.g.a.b paramb)
      {
        super();
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "uin", "", "invoke"})
    public static final class b
      extends q
      implements kotlin.g.a.b<Integer, x>
    {
      public static final b hcM;
      
      static
      {
        AppMethodBeat.i(183978);
        hcM = new b();
        AppMethodBeat.o(183978);
      }
      
      b()
      {
        super();
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    public static final class c
      extends q
      implements kotlin.g.a.a<x>
    {
      public static final c hcN;
      
      static
      {
        AppMethodBeat.i(183980);
        hcN = new c();
        AppMethodBeat.o(183980);
      }
      
      c()
      {
        super();
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/emoji/sync/EmojiPackSyncManager$designerCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/emoji/sync/EmojiDesignerTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-emojisdk_release"})
  public static final class b
    implements com.tencent.mm.loader.g.f<b>
  {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetEmotionDetailResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    c(EmojiGroupInfo paramEmojiGroupInfo) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.sync.d
 * JD-Core Version:    0.7.0.1
 */