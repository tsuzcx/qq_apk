package com.tencent.mm.plugin.finder.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.autogen.a.ir;
import com.tencent.mm.cp.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.k;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.asp;
import com.tencent.mm.protocal.protobuf.bby;
import com.tencent.mm.protocal.protobuf.dje;
import com.tencent.mm.protocal.protobuf.djj;
import com.tencent.mm.protocal.protobuf.dtf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FinderDraftLogic;", "", "()V", "DRAFT_OP_ADD", "", "getDRAFT_OP_ADD", "()I", "DRAFT_OP_DEL", "getDRAFT_OP_DEL", "DRAFT_OP_GET", "getDRAFT_OP_GET", "setDRAFT_OP_GET", "(I)V", "DRAFT_OP_MOD", "getDRAFT_OP_MOD", "DRAFT_OP_PAUSE_POST", "getDRAFT_OP_PAUSE_POST", "TAG", "", "deleteDraft", "Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;", "localId", "", "deleteLocalDraft", "deleteSvrDraft", "objectId", "getAllDrafts", "", "getLastDraft", "songName", "singer", "getStageId", "draftItem", "insertNewDraft", "mvData", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "isLocalSenderFeedExists", "", "notifyAddDraft", "", "notifyDeleteDraft", "notifyDraftEvent", "opCode", "notifyGetDraft", "notifyModDraft", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
{
  public static final j FKc;
  public static final int FKd;
  private static final int FKe;
  private static int FKf;
  public static final int FKg;
  private static final int FKh;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(339276);
    FKc = new j();
    TAG = "Finder.FinderDraftLogic";
    FKd = 100;
    FKe = 110;
    FKf = 111;
    FKg = 112;
    FKh = 120;
    AppMethodBeat.o(339276);
  }
  
  private static final kotlin.ah a(i parami, long paramLong, b.a parama)
  {
    AppMethodBeat.i(339270);
    ((PluginFinder)h.az(PluginFinder.class)).getDraftStorage().qq(parami.field_objectId);
    qb(paramLong);
    parami = kotlin.ah.aiuX;
    AppMethodBeat.o(339270);
    return parami;
  }
  
  private static final kotlin.ah a(i parami, b.a parama)
  {
    AppMethodBeat.i(339272);
    ((PluginFinder)h.az(PluginFinder.class)).getDraftStorage().qq(parami.field_objectId);
    qb(parami.field_localId);
    parami = kotlin.ah.aiuX;
    AppMethodBeat.o(339272);
    return parami;
  }
  
  public static void as(int paramInt, long paramLong)
  {
    AppMethodBeat.i(339265);
    ir localir = new ir();
    localir.hKf.hHC = paramInt;
    localir.hKf.localId = paramLong;
    localir.publish();
    AppMethodBeat.o(339265);
  }
  
  public static String e(i parami)
  {
    AppMethodBeat.i(339236);
    s.u(parami, "draftItem");
    parami = s.X("draft_", Long.valueOf(parami.field_localId));
    AppMethodBeat.o(339236);
    return parami;
  }
  
  public static int eYO()
  {
    return FKd;
  }
  
  public static int eYP()
  {
    return FKe;
  }
  
  public static int eYQ()
  {
    return FKg;
  }
  
  public static List<i> eYR()
  {
    AppMethodBeat.i(339258);
    Object localObject2 = ((PluginFinder)h.az(PluginFinder.class)).getDraftStorage();
    Object localObject1 = new ArrayList();
    Object localObject3 = "SELECT * FROM FinderDraftItem  WHERE " + ((com.tencent.mm.plugin.finder.storage.logic.b)localObject2).FNz + " ORDER BY " + ((com.tencent.mm.plugin.finder.storage.logic.b)localObject2).ptT + ".localId DESC";
    localObject2 = ((com.tencent.mm.plugin.finder.storage.logic.b)localObject2).db.rawQuery((String)localObject3, null, 2);
    while (((Cursor)localObject2).moveToNext())
    {
      localObject3 = new i();
      ((i)localObject3).convertFrom((Cursor)localObject2);
      ((ArrayList)localObject1).add(localObject3);
    }
    ((Cursor)localObject2).close();
    localObject1 = (List)localObject1;
    AppMethodBeat.o(339258);
    return localObject1;
  }
  
  public static boolean pX(long paramLong)
  {
    AppMethodBeat.i(339241);
    if (((PluginFinder)h.az(PluginFinder.class)).getDraftStorage().qm(paramLong) != null)
    {
      AppMethodBeat.o(339241);
      return true;
    }
    AppMethodBeat.o(339241);
    return false;
  }
  
  public static i pZ(long paramLong)
  {
    AppMethodBeat.i(339246);
    i locali = ((PluginFinder)h.az(PluginFinder.class)).getDraftStorage().qp(paramLong);
    if (locali != null)
    {
      Log.i(TAG, "deleteSvrDraft localId:" + locali.field_localId + ", objectId:" + locali.field_objectId);
      com.tencent.mm.plugin.finder.storage.logic.b.a(((PluginFinder)h.az(PluginFinder.class)).getDraftStorage(), locali.field_localId);
      new k(locali.field_objectId).bFJ().g(new j..ExternalSyntheticLambda0(locali));
    }
    AppMethodBeat.o(339246);
    return locali;
  }
  
  private static i qa(long paramLong)
  {
    AppMethodBeat.i(339252);
    Log.i(TAG, s.X("deleteLocalDraft localId:", Long.valueOf(paramLong)));
    i locali = ((PluginFinder)h.az(PluginFinder.class)).getDraftStorage().qn(paramLong);
    com.tencent.mm.plugin.finder.storage.logic.b.a(((PluginFinder)h.az(PluginFinder.class)).getDraftStorage(), paramLong);
    qb(paramLong);
    AppMethodBeat.o(339252);
    return locali;
  }
  
  private static void qb(long paramLong)
  {
    AppMethodBeat.i(339261);
    as(FKe, paramLong);
    com.tencent.mm.plugin.finder.storage.logic.c localc = com.tencent.mm.plugin.finder.storage.logic.c.FNC;
    com.tencent.mm.plugin.finder.storage.logic.c.af(paramLong, 2);
    AppMethodBeat.o(339261);
  }
  
  public final i a(dtf paramdtf)
  {
    AppMethodBeat.i(339310);
    s.u(paramdtf, "mvData");
    i locali;
    long l;
    if (paramdtf.localId > 0L)
    {
      locali = qa(paramdtf.localId);
      if (locali == null) {
        l = 0L;
      }
    }
    for (;;)
    {
      Log.i(TAG, s.X("saveDraftItem :", Long.valueOf(paramdtf.localId)));
      locali = new i();
      locali.field_objectId = l;
      locali.field_createTime = cn.getSyncServerTimeSecond();
      locali.field_localFlag = 1;
      Object localObject1 = new bby();
      ((bby)localObject1).ABJ = paramdtf.aaYK;
      Object localObject2 = ((bby)localObject1).ABJ;
      if (localObject2 != null) {
        ((FinderObject)localObject2).id = 0L;
      }
      localObject2 = ((bby)localObject1).ABJ;
      if (localObject2 != null) {
        ((FinderObject)localObject2).createtime = cn.getSyncServerTimeSecond();
      }
      localObject2 = ((bby)localObject1).ABJ;
      if (localObject2 != null)
      {
        localObject2 = ((FinderObject)localObject2).objectDesc;
        if (localObject2 != null)
        {
          localObject2 = ((FinderObjectDesc)localObject2).media;
          if (localObject2 != null) {
            ((LinkedList)localObject2).clear();
          }
        }
      }
      localObject2 = (CharSequence)paramdtf.aaYL;
      if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0))
      {
        i = 1;
        label209:
        if (i == 0)
        {
          localObject2 = new FinderMedia();
          ((FinderMedia)localObject2).url = paramdtf.aaYL;
          ((FinderMedia)localObject2).thumbUrl = paramdtf.aaYL;
          ((FinderMedia)localObject2).mediaType = 2;
          Log.i(TAG, "saveDraftItem :" + ((FinderMedia)localObject2).url + " thumbUrl:" + ((FinderMedia)localObject2).thumbUrl);
          localObject3 = ((bby)localObject1).ABJ;
          if (localObject3 != null)
          {
            localObject3 = ((FinderObject)localObject3).objectDesc;
            if (localObject3 != null)
            {
              localObject3 = ((FinderObjectDesc)localObject3).media;
              if (localObject3 != null) {
                ((LinkedList)localObject3).add(localObject2);
              }
            }
          }
        }
        ((bby)localObject1).ZMH = new asp();
        localObject2 = paramdtf.ZJp;
        localObject3 = (Collection)localObject2;
        if ((localObject3 != null) && (!((Collection)localObject3).isEmpty())) {
          break label517;
        }
      }
      label517:
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label522;
        }
        localObject3 = ((bby)localObject1).ZMH;
        if (localObject3 != null) {
          ((asp)localObject3).ZCU = new dje();
        }
        if (localObject2 == null) {
          break label522;
        }
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject4 = (FinderObject)((Iterator)localObject2).next();
          localObject3 = new bby();
          ((bby)localObject3).ABJ = ((FinderObject)localObject4);
          localObject4 = ((bby)localObject1).ZMH;
          if (localObject4 != null)
          {
            localObject4 = ((asp)localObject4).ZCU;
            if (localObject4 != null)
            {
              localObject4 = ((dje)localObject4).aaOX;
              if (localObject4 != null) {
                ((LinkedList)localObject4).add(localObject3);
              }
            }
          }
        }
        l = locali.field_objectId;
        break;
        i = 0;
        break label209;
      }
      label522:
      localObject2 = kotlin.ah.aiuX;
      locali.field_finderItem = ((bby)localObject1);
      localObject1 = locali.eYK();
      localObject2 = ah.FMh;
      localObject2 = ah.eZB();
      ((djj)localObject2).aaPx = cn.bDu();
      Object localObject3 = kotlin.ah.aiuX;
      ((FinderItem)localObject1).setPostInfo((djj)localObject2);
      locali.field_originMvInfo = paramdtf.aaYM;
      locali.field_objectType = 2;
      paramdtf = paramdtf.aaYL;
      if ((paramdtf != null) && (n.U(paramdtf, "http", false) == true)) {}
      for (i = 1;; i = 0)
      {
        if (i != 0)
        {
          paramdtf = com.tencent.mm.plugin.finder.storage.logic.c.FNC;
          com.tencent.mm.plugin.finder.storage.logic.c.h(locali);
        }
        l = ((PluginFinder)h.az(PluginFinder.class)).getDraftStorage().f(locali);
        as(FKd, l);
        ((com.tencent.mm.plugin.finder.publish.c)h.az(com.tencent.mm.plugin.finder.publish.c.class)).finderPostManager().eKX();
        AppMethodBeat.o(339310);
        return locali;
      }
      l = 0L;
    }
  }
  
  public final i pY(long paramLong)
  {
    AppMethodBeat.i(339294);
    i locali = qa(paramLong);
    if ((locali != null) && (locali.field_objectId != 0L))
    {
      Log.i(TAG, "deleteRemoteDraft localId:" + paramLong + ", objectId:" + locali.field_objectId);
      new k(locali.field_objectId).bFJ().g(new j..ExternalSyntheticLambda1(locali, paramLong));
    }
    AppMethodBeat.o(339294);
    return locali;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.j
 * JD-Core Version:    0.7.0.1
 */