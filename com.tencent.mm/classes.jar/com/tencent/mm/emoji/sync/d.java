package com.tencent.mm.emoji.sync;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.i;
import com.tencent.mm.loader.g.a.g;
import com.tencent.mm.protocal.protobuf.EmotionDetail;
import com.tencent.mm.protocal.protobuf.GetEmotionDetailResponse;
import com.tencent.mm.protocal.protobuf.PersonalDesigner;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.m;
import d.g.b.k;
import d.y;
import java.util.ArrayList;
import java.util.Iterator;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/sync/EmojiPackSyncManager;", "", "()V", "designerCallback", "com/tencent/mm/emoji/sync/EmojiPackSyncManager$designerCallback$1", "Lcom/tencent/mm/emoji/sync/EmojiPackSyncManager$designerCallback$1;", "designerQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/emoji/sync/EmojiDesignerTask;", "finishCount", "", "taskCount", "destroy", "", "start", "Companion", "plugin-emojisdk_release"})
public final class d
{
  private static final String TAG = "MicroMsg.EmojiPackSyncManager";
  private static d fVy;
  public static final d.a fVz;
  final com.tencent.mm.loader.g.d<b> fVu;
  private int fVv;
  private int fVw;
  final b fVx;
  
  static
  {
    AppMethodBeat.i(183985);
    fVz = new d.a((byte)0);
    TAG = "MicroMsg.EmojiPackSyncManager";
    AppMethodBeat.o(183985);
  }
  
  public d()
  {
    AppMethodBeat.i(183984);
    this.fVu = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(2147483647), new g(1, (byte)0), 1, "EmojiDesigner"));
    this.fVx = new b(this);
    this.fVu.a((com.tencent.mm.loader.g.f)this.fVx);
    AppMethodBeat.o(183984);
  }
  
  public final void start()
  {
    AppMethodBeat.i(183983);
    Object localObject = i.ach();
    k.g(localObject, "EmojiStorageCache.getInstance()");
    ArrayList localArrayList1 = ((i)localObject).acj();
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = localArrayList1.iterator();
    EmojiGroupInfo localEmojiGroupInfo;
    com.tencent.mm.storage.emotion.l locall;
    GetEmotionDetailResponse localGetEmotionDetailResponse;
    if (localIterator.hasNext())
    {
      localEmojiGroupInfo = (EmojiGroupInfo)localIterator.next();
      localObject = az.faZ();
      k.g(localObject, "EmojiStorageMgr.getInstance()");
      localObject = ((az)localObject).fbb();
      k.g(localEmojiGroupInfo, "groupInfo");
      locall = ((m)localObject).aPc(localEmojiGroupInfo.fdm());
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
          ac.i(TAG, "start: too many groups " + localArrayList1.size());
          this.fVv = localArrayList2.size();
          localObject = ((Iterable)localArrayList2).iterator();
          if (!((Iterator)localObject).hasNext()) {
            break label405;
          }
          i = ((Number)((Iterator)localObject).next()).intValue();
          ac.i(TAG, "checkStart: add task ".concat(String.valueOf(i)));
          this.fVu.b((com.tencent.mm.loader.g.c)new b(i));
          continue;
          label292:
          localObject = null;
        }
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace(TAG, (Throwable)localException, "", new Object[0]);
        continue;
        ac.i(TAG, "start: GetEmotionDetail " + localEmojiGroupInfo.fdm());
      }
      if (k.g(localEmojiGroupInfo.fdm(), String.valueOf(EmojiGroupInfo.Jsp))) {
        break;
      }
      String str = localEmojiGroupInfo.fdm();
      k.g(str, "groupInfo.productID");
      new com.tencent.mm.emoji.a.d(str).aBB().g((com.tencent.mm.vending.c.a)new c(localEmojiGroupInfo));
    }
    label405:
    AppMethodBeat.o(183983);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  public static final class a$a
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public a$a(String paramString, d.g.a.b paramb)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "uin", "", "invoke"})
  public static final class a$b
    extends d.g.b.l
    implements d.g.a.b<Integer, y>
  {
    public static final b fVD;
    
    static
    {
      AppMethodBeat.i(183978);
      fVD = new b();
      AppMethodBeat.o(183978);
    }
    
    a$b()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  public static final class a$c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public static final c fVE;
    
    static
    {
      AppMethodBeat.i(183980);
      fVE = new c();
      AppMethodBeat.o(183980);
    }
    
    a$c()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/emoji/sync/EmojiPackSyncManager$designerCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/emoji/sync/EmojiDesignerTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-emojisdk_release"})
  public static final class b
    implements com.tencent.mm.loader.g.f<b>
  {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "cgiBack", "Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetEmotionDetailResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    c(EmojiGroupInfo paramEmojiGroupInfo) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.sync.d
 * JD-Core Version:    0.7.0.1
 */