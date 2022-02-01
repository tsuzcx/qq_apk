package com.tencent.mm.emoji.sync;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.f.a.a;
import com.tencent.mm.loader.f.a.g;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.protocal.protobuf.goe;
import com.tencent.mm.protocal.protobuf.gok;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.m;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/sync/EmojiPackSyncManager;", "", "()V", "designerCallback", "com/tencent/mm/emoji/sync/EmojiPackSyncManager$designerCallback$1", "Lcom/tencent/mm/emoji/sync/EmojiPackSyncManager$designerCallback$1;", "designerQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/emoji/sync/EmojiDesignerTask;", "finishCount", "", "taskCount", "destroy", "", "start", "Companion", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  private static final String TAG;
  public static final e.a mmI;
  private static e mmN;
  final com.tencent.mm.loader.f.d<c> mmJ;
  private int mmK;
  private int mmL;
  final b mmM;
  
  static
  {
    AppMethodBeat.i(183985);
    mmI = new e.a((byte)0);
    TAG = "MicroMsg.EmojiPackSyncManager";
    AppMethodBeat.o(183985);
  }
  
  public e()
  {
    AppMethodBeat.i(183984);
    this.mmJ = new com.tencent.mm.loader.f.d((com.tencent.mm.loader.f.a.d)new com.tencent.mm.loader.f.a.f((com.tencent.mm.loader.f.a.c)new a(2147483647), new g(1, (byte)0), 1, "EmojiDesigner"));
    this.mmM = new b(this);
    this.mmJ.a((com.tencent.mm.loader.f.e)this.mmM);
    AppMethodBeat.o(183984);
  }
  
  private static final ah a(EmojiGroupInfo paramEmojiGroupInfo, b.a parama)
  {
    AppMethodBeat.i(242566);
    int i = parama.errType;
    int j = parama.errCode;
    Log.i(TAG, "CgiGetEmotionDetail end: " + i + ", " + j);
    parama = (goe)parama.ott;
    if ((i == 0) && (j == 0)) {
      ((com.tencent.mm.plugin.emoji.c.d)h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiStorageMgr().adjz.a(paramEmojiGroupInfo.field_productID, parama, LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()));
    }
    paramEmojiGroupInfo = ah.aiuX;
    AppMethodBeat.o(242566);
    return paramEmojiGroupInfo;
  }
  
  public final void start()
  {
    AppMethodBeat.i(183983);
    ArrayList localArrayList1 = com.tencent.mm.emoji.c.l.aUF().aUH();
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = localArrayList1.iterator();
    EmojiGroupInfo localEmojiGroupInfo;
    com.tencent.mm.storage.emotion.l locall;
    goe localgoe;
    Object localObject;
    if (localIterator.hasNext())
    {
      localEmojiGroupInfo = (EmojiGroupInfo)localIterator.next();
      locall = bl.jba().adjz.bzj(localEmojiGroupInfo.field_productID);
      localgoe = new goe();
      if (locall != null) {
        break label257;
      }
      localObject = null;
      if (localObject == null) {}
    }
    for (;;)
    {
      try
      {
        localgoe.parseFrom(locall.field_content);
        if ((localgoe.akkU != null) && (localgoe.akkU.akks != null))
        {
          int i = localgoe.akkU.akks.ZtX;
          if (!localArrayList2.contains(Integer.valueOf(i))) {
            localArrayList2.add(Integer.valueOf(i));
          }
          if (localArrayList2.size() < 50) {
            break;
          }
          Log.i(TAG, s.X("start: too many groups ", Integer.valueOf(localArrayList1.size())));
          this.mmK = localArrayList2.size();
          localObject = ((Iterable)localArrayList2).iterator();
          if (!((Iterator)localObject).hasNext()) {
            break label361;
          }
          i = ((Number)((Iterator)localObject).next()).intValue();
          Log.i(TAG, s.X("checkStart: add task ", Integer.valueOf(i)));
          this.mmJ.c((com.tencent.mm.loader.f.c)new c(i));
          continue;
          label257:
          localObject = locall.field_content;
        }
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace(TAG, (Throwable)localException, "", new Object[0]);
        continue;
        Log.i(TAG, s.X("start: GetEmotionDetail ", localEmojiGroupInfo.field_productID));
      }
      if (s.p(localEmojiGroupInfo.field_productID, String.valueOf(EmojiGroupInfo.aklD))) {
        break;
      }
      String str = localEmojiGroupInfo.field_productID;
      s.s(str, "groupInfo.productID");
      new com.tencent.mm.emoji.c.d(str).bFJ().g(new e..ExternalSyntheticLambda0(localEmojiGroupInfo));
    }
    label361:
    AppMethodBeat.o(183983);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "uin", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class a$b
    extends u
    implements b<Integer, ah>
  {
    public static final b mmQ;
    
    static
    {
      AppMethodBeat.i(183978);
      mmQ = new b();
      AppMethodBeat.o(183978);
    }
    
    a$b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/emoji/sync/EmojiPackSyncManager$designerCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/emoji/sync/EmojiDesignerTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.loader.f.e<c>
  {
    b(e parame) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.sync.e
 * JD-Core Version:    0.7.0.1
 */