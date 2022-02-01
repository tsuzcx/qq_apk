package com.tencent.mm.plugin.finder.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.ie;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.logic.b;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.aow;
import com.tencent.mm.protocal.protobuf.awh;
import com.tencent.mm.protocal.protobuf.csc;
import com.tencent.mm.protocal.protobuf.dbo;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/FinderDraftLogic;", "", "()V", "DRAFT_OP_ADD", "", "getDRAFT_OP_ADD", "()I", "setDRAFT_OP_ADD", "(I)V", "DRAFT_OP_DEL", "getDRAFT_OP_DEL", "setDRAFT_OP_DEL", "DRAFT_OP_GET", "getDRAFT_OP_GET", "setDRAFT_OP_GET", "TAG", "", "deleteDraft", "", "localId", "", "getAllDrafts", "", "Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;", "getLastDraft", "songName", "singer", "isLocalSenderFeedExists", "", "notifyDeleteDraft", "notifyDraftEvent", "opCode", "notifyGetDraft", "notifySaveDraft", "replace", "draftItem", "saveDraftItem", "mvData", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "plugin-finder_release"})
public final class i
{
  public static int AkH = 0;
  private static int AkI = 0;
  private static int AkJ = 0;
  public static final i AkK;
  private static final String TAG = "Finder.FinderDraftLogic";
  
  static
  {
    AppMethodBeat.i(283800);
    AkK = new i();
    TAG = "Finder.FinderDraftLogic";
    AkH = 100;
    AkI = 110;
    AkJ = 111;
    AppMethodBeat.o(283800);
  }
  
  public static void MG(long paramLong)
  {
    AppMethodBeat.i(283796);
    Log.i(TAG, "deleteDraft localId:".concat(String.valueOf(paramLong)));
    b.a(((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getDraftStorage(), paramLong);
    am(AkI, paramLong);
    AppMethodBeat.o(283796);
  }
  
  public static void am(int paramInt, long paramLong)
  {
    AppMethodBeat.i(283799);
    ie localie = new ie();
    localie.fFk.fCN = paramInt;
    localie.fFk.localId = paramLong;
    EventCenter.instance.publish((IEvent)localie);
    AppMethodBeat.o(283799);
  }
  
  public static int dYn()
  {
    return AkH;
  }
  
  public static int dYo()
  {
    return AkI;
  }
  
  public static List<h> dYp()
  {
    AppMethodBeat.i(283798);
    Object localObject2 = ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getDraftStorage();
    Object localObject1 = new ArrayList();
    Object localObject3 = "SELECT * FROM FinderDraftItem  WHERE " + ((b)localObject2).AnI + " ORDER BY " + ((b)localObject2).Alf + ".localId DESC";
    localObject2 = ((b)localObject2).db.rawQuery((String)localObject3, null, 2);
    while (((Cursor)localObject2).moveToNext())
    {
      localObject3 = new h();
      ((h)localObject3).convertFrom((Cursor)localObject2);
      ((ArrayList)localObject1).add(localObject3);
    }
    ((Cursor)localObject2).close();
    localObject1 = (List)localObject1;
    AppMethodBeat.o(283798);
    return localObject1;
  }
  
  public final h a(dbo paramdbo)
  {
    AppMethodBeat.i(283797);
    p.k(paramdbo, "mvData");
    if (paramdbo.localId > 0L) {
      MG(paramdbo.localId);
    }
    Log.i(TAG, "saveDraftItem :" + paramdbo.localId);
    h localh = new h();
    localh.field_createTime = cm.bfF();
    localh.field_localFlag = 1;
    awh localawh = new awh();
    localawh.xcx = paramdbo.TIV;
    Object localObject1 = localawh.xcx;
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
    localObject1 = (CharSequence)paramdbo.TIW;
    Object localObject2;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
    {
      i = 1;
      if (i == 0)
      {
        localObject1 = new FinderMedia();
        ((FinderMedia)localObject1).url = paramdbo.TIW;
        ((FinderMedia)localObject1).thumbUrl = paramdbo.TIW;
        ((FinderMedia)localObject1).mediaType = 2;
        Log.i(TAG, "saveDraftItem :" + ((FinderMedia)localObject1).url + " thumbUrl:" + ((FinderMedia)localObject1).thumbUrl);
        localObject2 = localawh.xcx;
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
      localawh.SIK = new aow();
      localObject1 = paramdbo.SGC;
      localObject2 = (Collection)localObject1;
      if ((localObject2 != null) && (!((Collection)localObject2).isEmpty())) {
        break label458;
      }
    }
    label458:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label463;
      }
      localObject2 = localawh.SIK;
      if (localObject2 != null) {
        ((aow)localObject2).SCc = new csc();
      }
      if (localObject1 == null) {
        break label463;
      }
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject3 = (FinderObject)((Iterator)localObject1).next();
        localObject2 = new awh();
        ((awh)localObject2).xcx = ((FinderObject)localObject3);
        localObject3 = localawh.SIK;
        if (localObject3 != null)
        {
          localObject3 = ((aow)localObject3).SCc;
          if (localObject3 != null)
          {
            localObject3 = ((csc)localObject3).TzN;
            if (localObject3 != null) {
              ((LinkedList)localObject3).add(localObject2);
            }
          }
        }
      }
      i = 0;
      break;
    }
    label463:
    localh.field_finderItem = localawh;
    localh.field_originMvInfo = paramdbo.TIX;
    localh.field_objectType = 2;
    long l = ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getDraftStorage().b(localh);
    am(AkH, l);
    AppMethodBeat.o(283797);
    return localh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.i
 * JD-Core Version:    0.7.0.1
 */