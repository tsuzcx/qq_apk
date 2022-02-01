package com.tencent.mm.emoji.sync;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.h;
import com.tencent.mm.loader.g.a.g;
import com.tencent.mm.protocal.protobuf.EmotionDetail;
import com.tencent.mm.protocal.protobuf.GetEmotionDetailResponse;
import com.tencent.mm.protocal.protobuf.PersonalDesigner;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import d.y;
import java.util.ArrayList;
import java.util.Iterator;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/sync/EmojiPackSyncManager;", "", "()V", "designerCallback", "com/tencent/mm/emoji/sync/EmojiPackSyncManager$designerCallback$1", "Lcom/tencent/mm/emoji/sync/EmojiPackSyncManager$designerCallback$1;", "designerQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/emoji/sync/EmojiDesignerTask;", "finishCount", "", "taskCount", "destroy", "", "start", "Companion", "plugin-emojisdk_release"})
public final class d
{
  private static final String TAG = "MicroMsg.EmojiPackSyncManager";
  private static d fRD;
  public static final a fRE;
  private int fRA;
  private int fRB;
  final b fRC;
  final com.tencent.mm.loader.g.d<b> fRz;
  
  static
  {
    AppMethodBeat.i(183985);
    fRE = new a((byte)0);
    TAG = "MicroMsg.EmojiPackSyncManager";
    AppMethodBeat.o(183985);
  }
  
  public d()
  {
    AppMethodBeat.i(183984);
    this.fRz = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(2147483647), new g(1, (byte)0), 1, "EmojiDesigner"));
    this.fRC = new b(this);
    this.fRz.a((com.tencent.mm.loader.g.f)this.fRC);
    AppMethodBeat.o(183984);
  }
  
  public final void start()
  {
    AppMethodBeat.i(183983);
    Object localObject1 = h.abj();
    d.g.b.k.g(localObject1, "EmojiStorageCache.getInstance()");
    localObject1 = ((h)localObject1).abl();
    ArrayList localArrayList = new ArrayList();
    d.g.b.k.g(localObject1, "groups");
    Iterator localIterator = ((Iterable)localObject1).iterator();
    int i;
    while (localIterator.hasNext())
    {
      EmojiGroupInfo localEmojiGroupInfo = (EmojiGroupInfo)localIterator.next();
      localObject1 = aw.eLx();
      d.g.b.k.g(localObject1, "EmojiStorageMgr.getInstance()");
      localObject1 = ((aw)localObject1).eLz();
      d.g.b.k.g(localEmojiGroupInfo, "groupInfo");
      com.tencent.mm.storage.emotion.k localk = ((com.tencent.mm.storage.emotion.l)localObject1).aJE(localEmojiGroupInfo.fZJ());
      GetEmotionDetailResponse localGetEmotionDetailResponse = new GetEmotionDetailResponse();
      if (localk != null)
      {
        localObject1 = localk.field_content;
        if (localObject1 == null) {}
      }
      try
      {
        localGetEmotionDetailResponse.parseFrom(localk.field_content);
        if ((localGetEmotionDetailResponse.EmotionDetail != null) && (localGetEmotionDetailResponse.EmotionDetail.PersonalDesigner != null))
        {
          i = localGetEmotionDetailResponse.EmotionDetail.PersonalDesigner.DesignerUin;
          if (localArrayList.contains(Integer.valueOf(i))) {
            continue;
          }
          localArrayList.add(Integer.valueOf(i));
          continue;
          localObject1 = null;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.printErrStackTrace(TAG, (Throwable)localException, "", new Object[0]);
        }
        ad.i(TAG, "start: GetEmotionDetail " + localEmojiGroupInfo.fZJ());
        localObject2 = localEmojiGroupInfo.fZJ();
        d.g.b.k.g(localObject2, "groupInfo.productID");
        new com.tencent.mm.emoji.a.c((String)localObject2).auK().g((com.tencent.mm.vending.c.a)new c(localEmojiGroupInfo));
      }
    }
    this.fRA = localArrayList.size();
    Object localObject2 = ((Iterable)localArrayList).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      i = ((Number)((Iterator)localObject2).next()).intValue();
      ad.i(TAG, "checkStart: add task ".concat(String.valueOf(i)));
      this.fRz.b((com.tencent.mm.loader.g.c)new b(i));
    }
    AppMethodBeat.o(183983);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/sync/EmojiPackSyncManager$Companion;", "", "()V", "TAG", "", "runningSyncTask", "Lcom/tencent/mm/emoji/sync/EmojiPackSyncManager;", "checkPack", "", "productId", "checkStart", "onDesignerEnd", "plugin-emojisdk_release"})
  public static final class a
  {
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    public static final class a
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      public a(String paramString, d.g.a.b paramb)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "uin", "", "invoke"})
    public static final class b
      extends d.g.b.l
      implements d.g.a.b<Integer, y>
    {
      public static final b fRI;
      
      static
      {
        AppMethodBeat.i(183978);
        fRI = new b();
        AppMethodBeat.o(183978);
      }
      
      b()
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    public static final class c
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      public static final c fRJ;
      
      static
      {
        AppMethodBeat.i(183980);
        fRJ = new c();
        AppMethodBeat.o(183980);
      }
      
      c()
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/emoji/sync/EmojiPackSyncManager$designerCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/emoji/sync/EmojiDesignerTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-emojisdk_release"})
  public static final class b
    implements com.tencent.mm.loader.g.f<b>
  {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "cgiBack", "Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetEmotionDetailResponse;", "kotlin.jvm.PlatformType", "call"})
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