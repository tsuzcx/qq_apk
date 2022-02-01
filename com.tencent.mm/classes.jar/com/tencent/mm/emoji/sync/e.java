package com.tencent.mm.emoji.sync;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.k;
import com.tencent.mm.loader.g.a.g;
import com.tencent.mm.protocal.protobuf.akb;
import com.tencent.mm.protocal.protobuf.bud;
import com.tencent.mm.protocal.protobuf.dkv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.m;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/sync/EmojiPackSyncManager;", "", "()V", "designerCallback", "com/tencent/mm/emoji/sync/EmojiPackSyncManager$designerCallback$1", "Lcom/tencent/mm/emoji/sync/EmojiPackSyncManager$designerCallback$1;", "designerQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/emoji/sync/EmojiDesignerTask;", "finishCount", "", "taskCount", "destroy", "", "start", "Companion", "plugin-emojisdk_release"})
public final class e
{
  private static final String TAG = "MicroMsg.EmojiPackSyncManager";
  private static e jNP;
  public static final e.a jNQ;
  final com.tencent.mm.loader.g.d<c> jNL;
  private int jNM;
  private int jNN;
  final b jNO;
  
  static
  {
    AppMethodBeat.i(183985);
    jNQ = new e.a((byte)0);
    TAG = "MicroMsg.EmojiPackSyncManager";
    AppMethodBeat.o(183985);
  }
  
  public e()
  {
    AppMethodBeat.i(183984);
    this.jNL = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(2147483647), new g(1, (byte)0), 1, "EmojiDesigner"));
    this.jNO = new b(this);
    this.jNL.a((com.tencent.mm.loader.g.f)this.jNO);
    AppMethodBeat.o(183984);
  }
  
  public final void start()
  {
    AppMethodBeat.i(183983);
    Object localObject = k.aBH();
    p.j(localObject, "EmojiStorageCache.getInstance()");
    ArrayList localArrayList1 = ((k)localObject).aBL();
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = localArrayList1.iterator();
    EmojiGroupInfo localEmojiGroupInfo;
    com.tencent.mm.storage.emotion.l locall;
    bud localbud;
    if (localIterator.hasNext())
    {
      localEmojiGroupInfo = (EmojiGroupInfo)localIterator.next();
      localObject = bj.hyV();
      p.j(localObject, "EmojiStorageMgr.getInstance()");
      localObject = ((bj)localObject).hyY();
      p.j(localEmojiGroupInfo, "groupInfo");
      locall = ((m)localObject).bxT(localEmojiGroupInfo.hBl());
      localbud = new bud();
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
        localbud.parseFrom(locall.field_content);
        if ((localbud.VHU != null) && (localbud.VHU.VHL != null))
        {
          int i = localbud.VHU.VHL.TdG;
          if (!localArrayList2.contains(Integer.valueOf(i))) {
            localArrayList2.add(Integer.valueOf(i));
          }
          if (localArrayList2.size() < 50) {
            break;
          }
          Log.i(TAG, "start: too many groups " + localArrayList1.size());
          this.jNM = localArrayList2.size();
          localObject = ((Iterable)localArrayList2).iterator();
          if (!((Iterator)localObject).hasNext()) {
            break label405;
          }
          i = ((Number)((Iterator)localObject).next()).intValue();
          Log.i(TAG, "checkStart: add task ".concat(String.valueOf(i)));
          this.jNL.b((com.tencent.mm.loader.g.c)new c(i));
          continue;
          label292:
          localObject = null;
        }
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace(TAG, (Throwable)localException, "", new Object[0]);
        continue;
        Log.i(TAG, "start: GetEmotionDetail " + localEmojiGroupInfo.hBl());
      }
      if (p.h(localEmojiGroupInfo.hBl(), String.valueOf(EmojiGroupInfo.YCu))) {
        break;
      }
      String str = localEmojiGroupInfo.hBl();
      p.j(str, "groupInfo.productID");
      new com.tencent.mm.emoji.b.d(str).bhW().g((com.tencent.mm.vending.c.a)new c(localEmojiGroupInfo));
    }
    label405:
    AppMethodBeat.o(183983);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  public static final class a$a
    extends q
    implements kotlin.g.a.a<x>
  {
    public a$a(String paramString, b paramb)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "uin", "", "invoke"})
  public static final class a$b
    extends q
    implements b<Integer, x>
  {
    public static final b jNU;
    
    static
    {
      AppMethodBeat.i(183978);
      jNU = new b();
      AppMethodBeat.o(183978);
    }
    
    a$b()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  public static final class a$c
    extends q
    implements kotlin.g.a.a<x>
  {
    public static final c jNV;
    
    static
    {
      AppMethodBeat.i(183980);
      jNV = new c();
      AppMethodBeat.o(183980);
    }
    
    a$c()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/emoji/sync/EmojiPackSyncManager$designerCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/emoji/sync/EmojiDesignerTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-emojisdk_release"})
  public static final class b
    implements com.tencent.mm.loader.g.f<c>
  {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetEmotionDetailResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    c(EmojiGroupInfo paramEmojiGroupInfo) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.sync.e
 * JD-Core Version:    0.7.0.1
 */