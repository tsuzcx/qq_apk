package com.tencent.mm.plugin.finder.storage.logic;

import android.content.ContentValues;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.iq;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.j;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.auq;
import com.tencent.mm.protocal.protobuf.awt;
import com.tencent.mm.protocal.protobuf.axa;
import com.tencent.mm.protocal.protobuf.bby;
import com.tencent.mm.protocal.protobuf.boi;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.protocal.protobuf.djq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/logic/FinderDraftStorageLogic;", "", "()V", "TAG", "", "createSvrDraftItem", "Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;", "finderObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "extractDraftToIntent", "", "draftItem", "intent", "Landroid/content/Intent;", "fixForPost", "getStorage", "Lcom/tencent/mm/plugin/finder/storage/logic/FinderDraftStorage;", "notifyDraftModify", "localId", "", "type", "", "updateOrCreateLocalDraft", "", "updatePostSvrDraft", "svrFinderObj", "updateSvrDrafts", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "svrFinderObjs", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c FNC;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(339632);
    FNC = new c();
    TAG = "Finder.FinderDraftStorageLogic";
    AppMethodBeat.o(339632);
  }
  
  public static void a(com.tencent.mm.plugin.finder.storage.i parami, Intent paramIntent)
  {
    Object localObject2 = null;
    AppMethodBeat.i(339615);
    s.u(parami, "draftItem");
    s.u(paramIntent, "intent");
    paramIntent.putExtra("KEY_FINDER_POST_DRAFT_LOCAL_ID", parami.field_localId);
    paramIntent.putExtra("KEY_FINDER_POST_DRAFT_SVR_ID", parami.field_objectId);
    Object localObject1;
    awt localawt;
    int i;
    switch (parami.eYK().getMediaType())
    {
    case 3: 
    default: 
      paramIntent.removeExtra("postType");
      localObject1 = FinderItem.Companion;
      paramIntent.putExtra("KEY_POST_DRAFT_FINDER_ITEM", FinderItem.a.r(parami.eYK()).toByteArray());
      paramIntent.putExtra("isLongVideoPost", parami.eYK().isLongVideo());
      localObject1 = parami.eYK().getFeedObject().objectDesc;
      if (localObject1 != null)
      {
        localObject1 = ((FinderObjectDesc)localObject1).client_draft_ext_info;
        if (localObject1 != null)
        {
          localawt = ((auq)localObject1).ZEY;
          if (localawt != null)
          {
            paramIntent.putExtra("saveActivity", true);
            if (localawt.ZHL != 0) {
              break;
            }
            i = 101;
            label171:
            paramIntent.putExtra("key_activity_type", i);
            if (localawt.ZHL != 0) {
              break label451;
            }
            localObject1 = z.bAW();
            label191:
            paramIntent.putExtra("key_user_name", (String)localObject1);
            localObject1 = localawt.contact;
            if (localObject1 != null) {
              break label487;
            }
            localObject1 = null;
            label211:
            paramIntent.putExtra("key_nick_name", (String)localObject1);
            paramIntent.putExtra("key_cover_url", localawt.coverImgUrl);
            paramIntent.putExtra("key_activity_display_mask", localawt.FOi);
            localObject1 = localawt.contact;
            if (localObject1 != null) {
              break label495;
            }
            localObject1 = "";
            label256:
            paramIntent.putExtra("key_avatar_url", (String)localObject1);
            paramIntent.putExtra("key_topic_id", localawt.ocD);
            paramIntent.putExtra("key_activity_name", localawt.eventName);
            paramIntent.putExtra("key_activity_desc", localawt.description);
            paramIntent.putExtra("key_activity_end_time", localawt.endTime);
            paramIntent.putExtra("key_activity_src_type", "key_scene_from_profile");
          }
        }
      }
      paramIntent.putExtra("saveDesc", parami.eYK().getDescription());
      localObject1 = parami.eYK().getFeedObject().objectDesc;
      if (localObject1 == null)
      {
        localObject1 = localObject2;
        label353:
        if (localObject1 != null) {
          break label523;
        }
        paramIntent.putExtra("saveLocation", false);
      }
      break;
    }
    for (;;)
    {
      parami = parami.eYK().getFeedObject().objectDesc;
      if (parami != null)
      {
        parami = parami.extReading;
        if (parami != null)
        {
          paramIntent.putExtra("saveExtendReadingLink", parami.link);
          paramIntent.putExtra("saveExtendReadingTitle", parami.title);
          paramIntent.putExtra("saveExtendReadingStyle", parami.style);
        }
      }
      AppMethodBeat.o(339615);
      return;
      paramIntent.putExtra("postType", parami.eYK().getMediaType());
      break;
      i = 102;
      break label171;
      label451:
      localObject1 = localawt.contact;
      if (localObject1 == null)
      {
        localObject1 = "";
        break label191;
      }
      String str = ((FinderContact)localObject1).username;
      localObject1 = str;
      if (str != null) {
        break label191;
      }
      localObject1 = "";
      break label191;
      label487:
      localObject1 = ((FinderContact)localObject1).nickname;
      break label211;
      label495:
      str = ((FinderContact)localObject1).headUrl;
      localObject1 = str;
      if (str != null) {
        break label256;
      }
      localObject1 = "";
      break label256;
      localObject1 = ((FinderObjectDesc)localObject1).location;
      break label353;
      label523:
      paramIntent.putExtra("saveLocation", true);
      localObject1 = parami.eYK().getFeedObject().objectDesc;
      if (localObject1 != null)
      {
        localObject1 = ((FinderObjectDesc)localObject1).location;
        if (localObject1 != null)
        {
          paramIntent.putExtra("get_poi_name", ((boi)localObject1).poiName);
          paramIntent.putExtra("get_city", ((boi)localObject1).city);
          paramIntent.putExtra("get_lat", ((boi)localObject1).latitude);
          paramIntent.putExtra("get_lng", ((boi)localObject1).longitude);
          paramIntent.putExtra("get_poi_address", ((boi)localObject1).ReU);
          paramIntent.putExtra("get_poi_classify_id", ((boi)localObject1).ZWG);
        }
      }
    }
  }
  
  public static void a(com.tencent.mm.plugin.finder.storage.i parami, FinderObject paramFinderObject)
  {
    AppMethodBeat.i(339536);
    s.u(parami, "draftItem");
    s.u(paramFinderObject, "svrFinderObj");
    Log.i(TAG, s.X("Finder.LogPost updatePostSvrDraft, ", parami.eYN()));
    b localb = faq();
    long l = parami.field_localId;
    Object localObject = localb.qm(l);
    if ((localObject != null) && (((com.tencent.mm.plugin.finder.storage.i)localObject).field_version > parami.field_version))
    {
      Log.i(TAG, "Finder.LogPost updatePostSvrDraft, just save id");
      parami.field_objectId = paramFinderObject.id;
      localb.a(l, parami);
      AppMethodBeat.o(339536);
      return;
    }
    if (localObject != null)
    {
      Log.i(TAG, "Finder.LogPost updatePostSvrDraft, overwrite");
      parami.field_localFlag = 4;
      parami.field_objectId = paramFinderObject.id;
      localObject = FinderItem.Companion;
      parami.o(FinderItem.a.a(paramFinderObject, null, parami.field_localId));
      h(parami);
      localb.a(parami.field_localId, parami);
      AppMethodBeat.o(339536);
      return;
    }
    Log.i(TAG, "Finder.LogPost updatePostSvrDraft, deleted");
    AppMethodBeat.o(339536);
  }
  
  public static void af(long paramLong, int paramInt)
  {
    AppMethodBeat.i(339624);
    iq localiq = new iq();
    localiq.hKd.localId = paramLong;
    localiq.hKd.hKe = paramInt;
    localiq.publish();
    AppMethodBeat.o(339624);
  }
  
  public static b faq()
  {
    AppMethodBeat.i(339501);
    b localb = ((PluginFinder)h.az(PluginFinder.class)).getDraftStorage();
    AppMethodBeat.o(339501);
    return localb;
  }
  
  public static boolean g(com.tencent.mm.plugin.finder.storage.i parami)
  {
    boolean bool2 = true;
    AppMethodBeat.i(339517);
    s.u(parami, "draftItem");
    Log.i(TAG, s.X("Finder.LogPost updateOrCreateLocalDraft, ", parami.eYN()));
    Object localObject2 = faq();
    if (parami.field_localId == 0L)
    {
      l = ((b)localObject2).f(parami);
      localObject1 = j.FKc;
      j.as(j.FKd, l);
      Log.i(TAG, s.X("Finder.LogPost updateOrCreateLocalDraft save all, ", parami.eYN()));
      AppMethodBeat.o(339517);
      return true;
    }
    long l = parami.field_localId;
    Object localObject1 = ((b)localObject2).qm(l);
    if ((localObject1 != null) && (((com.tencent.mm.plugin.finder.storage.i)localObject1).field_version <= parami.field_version))
    {
      ((b)localObject2).a(l, parami);
      Log.i(TAG, s.X("Finder.LogPost updateOrCreateLocalDraft save id, ", parami.eYN()));
      AppMethodBeat.o(339517);
      return true;
    }
    localObject2 = TAG;
    StringBuilder localStringBuilder = new StringBuilder("Finder.LogPost updateOrCreateLocalDraft cannot update, exist:");
    int i;
    if (localObject1 != null)
    {
      bool1 = true;
      localStringBuilder = localStringBuilder.append(bool1).append(", version:");
      if (localObject1 != null) {
        break label236;
      }
      i = 0;
      label199:
      if (i > parami.field_version) {
        break label245;
      }
    }
    label236:
    label245:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Log.i((String)localObject2, bool1);
      AppMethodBeat.o(339517);
      return false;
      bool1 = false;
      break;
      i = ((com.tencent.mm.plugin.finder.storage.i)localObject1).field_version;
      break label199;
    }
  }
  
  public static void h(com.tencent.mm.plugin.finder.storage.i parami)
  {
    AppMethodBeat.i(339581);
    s.u(parami, "draftItem");
    Object localObject1 = parami.eYK().getFeedObject().objectDesc;
    if (localObject1 == null) {
      localObject1 = null;
    }
    while ((localObject1 != null) && (((LinkedList)localObject1).size() > 0))
    {
      djq localdjq = new djq();
      Iterator localIterator = ((Iterable)com.tencent.mm.plugin.finder.storage.data.i.aY((LinkedList)localObject1)).iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          dji localdji = (dji)localIterator.next();
          Object localObject2 = localdji.coverUrl;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          String str = localdji.cover_url_token;
          localObject2 = str;
          if (str == null) {
            localObject2 = "";
          }
          localdji.aaPg = s.X((String)localObject1, localObject2);
          localObject2 = localdji.HaI;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localdji.aaPq = ((String)localObject1);
          localObject2 = localdji.url;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          str = localdji.url_token;
          localObject2 = str;
          if (str == null) {
            localObject2 = "";
          }
          localdji.aaPd = s.X((String)localObject1, localObject2);
          localObject2 = localdji.thumbUrl;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          str = localdji.thumb_url_token;
          localObject2 = str;
          if (str == null) {
            localObject2 = "";
          }
          localdji.aaPe = s.X((String)localObject1, localObject2);
          localObject2 = localdji.full_url;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localdji.aaPm = ((String)localObject1);
          localObject2 = localdji.aaPi;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          str = localdji.aaPj;
          localObject2 = str;
          if (str == null) {
            localObject2 = "";
          }
          localdji.aaPk = s.X((String)localObject1, localObject2);
          localdjq.aaPD.add(localdji);
          continue;
          localObject1 = ((FinderObjectDesc)localObject1).media;
          break;
        }
      }
      parami.eYK().field_mediaExtList = localdjq;
    }
    AppMethodBeat.o(339581);
  }
  
  public static ArrayList<com.tencent.mm.plugin.finder.storage.i> hC(List<? extends FinderObject> paramList)
  {
    AppMethodBeat.i(339562);
    s.u(paramList, "svrFinderObjs");
    b localb = faq();
    ArrayList localArrayList = new ArrayList();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      Object localObject1 = (FinderObject)paramList.next();
      com.tencent.mm.plugin.finder.storage.i locali = localb.qp(((FinderObject)localObject1).id);
      label94:
      Object localObject2;
      if (locali != null)
      {
        if (locali.field_markDeleted == 0)
        {
          int i;
          if ((locali.field_localFlag & 0x4) != 0)
          {
            i = 1;
            if (i == 0) {
              break label225;
            }
            localObject2 = FinderItem.Companion;
            locali.o(FinderItem.a.a((FinderObject)localObject1, null, locali.field_localId));
            h(locali);
            long l = ((FinderObject)localObject1).id;
            s.u(locali, "draftItem");
            locali.eYM();
            localObject1 = locali.convertTo();
            ((ContentValues)localObject1).remove("rowid");
            localb.db.update("FinderDraftItem", (ContentValues)localObject1, "objectId=?", new String[] { s.X("", Long.valueOf(l)) });
            Log.i(TAG, s.X("Finder.LogPost updateSvrDrafts, update, ", locali.eYN()));
          }
          for (;;)
          {
            localArrayList.add(locali);
            break;
            i = 0;
            break label94;
            label225:
            Log.i(TAG, s.X("Finder.LogPost updateSvrDrafts, drop, ", locali.eYN()));
          }
        }
      }
      else
      {
        s.u(localObject1, "finderObj");
        locali = new com.tencent.mm.plugin.finder.storage.i();
        locali.field_localFlag = 4;
        localObject2 = new bby();
        ((bby)localObject2).ABJ = ((FinderObject)localObject1);
        ah localah = ah.aiuX;
        locali.field_finderItem = ((bby)localObject2);
        locali.field_objectType = ((FinderObject)localObject1).objectType;
        locali.field_postIntent = "";
        locali.field_originMvInfo = null;
        locali.field_objectId = ((FinderObject)localObject1).id;
        locali.field_markDeleted = 0;
        locali.field_version = 0;
        h(locali);
        localb.f(locali);
        localArrayList.add(locali);
        Log.i(TAG, s.X("Finder.LogPost updateSvrDrafts, create, ", locali.eYN()));
      }
    }
    AppMethodBeat.o(339562);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.logic.c
 * JD-Core Version:    0.7.0.1
 */