package com.tencent.mm.plugin.finder.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hu;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.logic.b;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.anv;
import com.tencent.mm.protocal.protobuf.aud;
import com.tencent.mm.protocal.protobuf.cjh;
import com.tencent.mm.protocal.protobuf.csp;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/FinderDraftLogic;", "", "()V", "DRAFT_OP_ADD", "", "getDRAFT_OP_ADD", "()I", "setDRAFT_OP_ADD", "(I)V", "DRAFT_OP_DEL", "getDRAFT_OP_DEL", "setDRAFT_OP_DEL", "TAG", "", "deleteDraft", "", "localId", "", "getAllDrafts", "", "Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;", "isLocalSenderFeedExists", "", "notifyDeleteDraft", "notifyDraftEvent", "opCode", "notifySaveDraft", "replace", "draftItem", "saveDraftItem", "mvData", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "plugin-finder_release"})
public final class h
{
  private static final String TAG = "Finder.FinderDraftLogic";
  public static int vDn;
  private static int vDo;
  public static final h vDp;
  
  static
  {
    AppMethodBeat.i(251720);
    vDp = new h();
    TAG = "Finder.FinderDraftLogic";
    vDn = 100;
    vDo = 110;
    AppMethodBeat.o(251720);
  }
  
  public static void Fx(long paramLong)
  {
    AppMethodBeat.i(251716);
    Log.i(TAG, "deleteDraft localId:".concat(String.valueOf(paramLong)));
    b.a(((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getDraftStorage(), paramLong);
    aj(vDo, paramLong);
    AppMethodBeat.o(251716);
  }
  
  public static void aj(int paramInt, long paramLong)
  {
    AppMethodBeat.i(251719);
    hu localhu = new hu();
    localhu.dMq.dJY = paramInt;
    localhu.dMq.localId = paramLong;
    EventCenter.instance.publish((IEvent)localhu);
    AppMethodBeat.o(251719);
  }
  
  public static int dxo()
  {
    return vDn;
  }
  
  public static int dxp()
  {
    return vDo;
  }
  
  public static List<g> dxq()
  {
    AppMethodBeat.i(251718);
    Object localObject2 = ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getDraftStorage();
    Object localObject1 = new ArrayList();
    Object localObject3 = "SELECT * FROM FinderDraftItem  WHERE " + ((b)localObject2).vGK + " ORDER BY " + ((b)localObject2).TABLE + ".localId DESC";
    localObject2 = ((b)localObject2).db.rawQuery((String)localObject3, null, 2);
    while (((Cursor)localObject2).moveToNext())
    {
      localObject3 = new g();
      ((g)localObject3).convertFrom((Cursor)localObject2);
      ((ArrayList)localObject1).add(localObject3);
    }
    ((Cursor)localObject2).close();
    localObject1 = (List)localObject1;
    AppMethodBeat.o(251718);
    return localObject1;
  }
  
  public final g a(csp paramcsp)
  {
    AppMethodBeat.i(251717);
    p.h(paramcsp, "mvData");
    if (paramcsp.localId > 0L) {
      Fx(paramcsp.localId);
    }
    g localg = new g();
    localg.field_createTime = cl.aWB();
    localg.field_localFlag = 1;
    aud localaud = new aud();
    localaud.tuO = paramcsp.MxE;
    Object localObject1 = localaud.tuO;
    if (localObject1 != null)
    {
      localObject1 = ((FinderObject)localObject1).objectDesc;
      if (localObject1 != null)
      {
        localObject1 = ((FinderObjectDesc)localObject1).media;
        if (localObject1 != null) {
          ((LinkedList)localObject1).clear();
        }
      }
    }
    localObject1 = (CharSequence)paramcsp.MxF;
    Object localObject2;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
    {
      i = 1;
      if (i == 0)
      {
        localObject1 = new FinderMedia();
        ((FinderMedia)localObject1).url = paramcsp.MxF;
        ((FinderMedia)localObject1).thumbUrl = paramcsp.MxF;
        ((FinderMedia)localObject1).mediaType = 2;
        localObject2 = localaud.tuO;
        if (localObject2 != null)
        {
          localObject2 = ((FinderObject)localObject2).objectDesc;
          if (localObject2 != null)
          {
            localObject2 = ((FinderObjectDesc)localObject2).media;
            if (localObject2 != null) {
              ((LinkedList)localObject2).add(localObject1);
            }
          }
        }
      }
      localaud.LEP = new anv();
      localObject1 = (Collection)paramcsp.LDi;
      if ((localObject1 != null) && (!((Collection)localObject1).isEmpty())) {
        break label395;
      }
    }
    label395:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label400;
      }
      localObject1 = localaud.LEP;
      if (localObject1 != null) {
        ((anv)localObject1).LzB = new cjh();
      }
      localObject1 = paramcsp.LDi;
      if (localObject1 == null) {
        break label400;
      }
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject3 = (FinderObject)((Iterator)localObject1).next();
        localObject2 = new aud();
        ((aud)localObject2).tuO = ((FinderObject)localObject3);
        localObject3 = localaud.LEP;
        if (localObject3 != null)
        {
          localObject3 = ((anv)localObject3).LzB;
          if (localObject3 != null)
          {
            localObject3 = ((cjh)localObject3).MoH;
            if (localObject3 != null) {
              ((LinkedList)localObject3).add(localObject2);
            }
          }
        }
      }
      i = 0;
      break;
    }
    label400:
    localg.field_finderItem = localaud;
    localg.field_originMvInfo = paramcsp.MxG;
    localg.field_objectType = 2;
    long l = ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getDraftStorage().b(localg);
    aj(vDn, l);
    AppMethodBeat.o(251717);
    return localg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.h
 * JD-Core Version:    0.7.0.1
 */