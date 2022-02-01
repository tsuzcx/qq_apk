package com.tencent.mm.plugin.fts.logic;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.aw;
import com.tencent.mm.b.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.ISqlCondition;
import com.tencent.mm.sdk.storage.sql.SelectSql;
import com.tencent.mm.sdk.storage.sql.SelectSql.Builder;
import com.tencent.mm.sdk.storage.sql.SingleCondition;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import com.tencent.mm.storage.aj;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.am;
import kotlin.g.b.s;
import kotlin.n.d;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/fts/logic/FTS5SearchChatroomMemberLogic;", "Lcom/tencent/mm/plugin/fts/api/BaseFTS5SearchLogic;", "()V", "BUILD_CHATROOM_MEMBER_INDEX_TASK_PRIORITY", "", "cacheMemberListMd5Map", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "ftsStorage", "Lcom/tencent/mm/plugin/fts/storage/FTS5ChatroomMemberStorage;", "ftsTaskDaemon", "Lcom/tencent/mm/plugin/fts/api/IFTSTaskDaemon;", "onChatroomChangedListener", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "buildChatroomMember", "chatRoomMemberObj", "Lcom/tencent/mm/plugin/fts/logic/FTS5SearchChatroomMemberLogic$ChatroomMemberObj;", "getName", "onCreate", "", "onDestroy", "search", "Lcom/tencent/mm/plugin/fts/api/model/BaseFTSTask;", "request", "Lcom/tencent/mm/plugin/fts/api/model/FTSRequest;", "BuildChatroomMemberIndexTask", "BuildSingleChatroomMemberTask", "ChatroomMemberObj", "Companion", "SearchCommonChatroomTask", "SearchCommonChatroomUserTask", "plugin-fts_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.plugin.fts.a.b
{
  public static final a.d HuA;
  private com.tencent.mm.plugin.fts.b.a HuB;
  private final int HuC;
  private final HashSet<String> HuD;
  private final MStorage.IOnStorageChange HuE;
  private com.tencent.mm.plugin.fts.a.m msU;
  
  static
  {
    AppMethodBeat.i(265493);
    HuA = new a.d((byte)0);
    AppMethodBeat.o(265493);
  }
  
  public a()
  {
    AppMethodBeat.i(265487);
    this.HuC = 131093;
    this.HuD = new HashSet();
    this.HuE = new a..ExternalSyntheticLambda0(this);
    AppMethodBeat.o(265487);
  }
  
  private static final void a(a parama, String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(265488);
    s.u(parama, "this$0");
    if (s.p(paramString, "*"))
    {
      AppMethodBeat.o(265488);
      return;
    }
    paramString = paramMStorageEventData.obj;
    int i;
    if ((paramString instanceof aj))
    {
      paramString = (aj)paramString;
      if (paramString == null) {
        break label188;
      }
      paramMStorageEventData = (CharSequence)paramString.field_memberlist;
      if ((paramMStorageEventData != null) && (!kotlin.n.n.bp(paramMStorageEventData))) {
        break label166;
      }
      i = 1;
      label68:
      if (i != 0) {
        break label171;
      }
      i = 1;
      label74:
      if (i == 0) {
        break label176;
      }
    }
    for (;;)
    {
      if (paramString != null)
      {
        paramMStorageEventData = paramString.field_memberlist;
        s.s(paramMStorageEventData, "it.field_memberlist");
        paramMStorageEventData = paramMStorageEventData.getBytes(d.UTF_8);
        s.s(paramMStorageEventData, "(this as java.lang.String).getBytes(charset)");
        paramMStorageEventData = g.getMessageDigest(paramMStorageEventData);
        if (parama.HuD.add(paramMStorageEventData))
        {
          paramMStorageEventData = parama.msU;
          if (paramMStorageEventData == null) {
            break label188;
          }
          paramMStorageEventData.a(parama.HuC, (c)new b(paramString));
          AppMethodBeat.o(265488);
          return;
          paramString = null;
          break;
          label166:
          i = 0;
          break label68;
          label171:
          i = 0;
          break label74;
          label176:
          paramString = null;
          continue;
        }
        Log.i("MicroMsg.FTS.FTS5SearchChatroomMemberLogic", "ignore chatroom change");
      }
    }
    label188:
    AppMethodBeat.o(265488);
  }
  
  public final c a(l paraml)
  {
    AppMethodBeat.i(265502);
    com.tencent.mm.plugin.fts.a.m localm = this.msU;
    if ((paraml != null) && (localm != null))
    {
      switch (paraml.qRb)
      {
      default: 
        paraml = super.a(paraml);
        s.s(paraml, "{\n                    su…equest)\n                }");
        AppMethodBeat.o(265502);
        return paraml;
      case 8: 
        paraml = localm.a(-65536, (c)new e(paraml));
        s.s(paraml, "{\n                    da…quest))\n                }");
        AppMethodBeat.o(265502);
        return paraml;
      }
      paraml = localm.a(-65536, (c)new f(paraml));
      s.s(paraml, "{\n                    da…quest))\n                }");
      AppMethodBeat.o(265502);
      return paraml;
    }
    paraml = super.a(paraml);
    s.s(paraml, "super.search(request)");
    AppMethodBeat.o(265502);
    return paraml;
  }
  
  public final boolean aXx()
  {
    AppMethodBeat.i(265507);
    ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().remove(this.HuE);
    this.HuB = null;
    this.msU = null;
    AppMethodBeat.o(265507);
    return true;
  }
  
  public final String getName()
  {
    return "FTS5SearchChatroomMemberLogic";
  }
  
  public final boolean onCreate()
  {
    AppMethodBeat.i(265498);
    if (!((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).isFTSContextReady())
    {
      Log.i("MicroMsg.FTS.FTS5SearchChatroomMemberLogic", "Create Fail!");
      AppMethodBeat.o(265498);
      return false;
    }
    Log.i("MicroMsg.FTS.FTS5SearchChatroomMemberLogic", "Create Success!");
    this.msU = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).getFTSTaskDaemon();
    Object localObject = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(5);
    if ((localObject instanceof com.tencent.mm.plugin.fts.b.a)) {}
    for (localObject = (com.tencent.mm.plugin.fts.b.a)localObject;; localObject = null)
    {
      this.HuB = ((com.tencent.mm.plugin.fts.b.a)localObject);
      ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().add(this.HuE);
      localObject = this.msU;
      if (localObject != null) {
        ((com.tencent.mm.plugin.fts.a.m)localObject).a(this.HuC, (c)new a());
      }
      AppMethodBeat.o(265498);
      return true;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/fts/logic/FTS5SearchChatroomMemberLogic$BuildChatroomMemberIndexTask;", "Lcom/tencent/mm/plugin/fts/api/model/BaseFTSTask;", "(Lcom/tencent/mm/plugin/fts/logic/FTS5SearchChatroomMemberLogic;)V", "buildChatroomCount", "", "buildChatroomSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "newChatroomCount", "offset", "removeChatroomCount", "execute", "", "extraInfo", "getName", "plugin-fts_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends c
  {
    private HashSet<String> HuF;
    private int HuG;
    private int HuH;
    private int HuI;
    private int offset;
    
    public a()
    {
      AppMethodBeat.i(265506);
      AppMethodBeat.o(265506);
    }
    
    public final boolean aXz()
    {
      AppMethodBeat.i(265524);
      Object localObject1;
      Object localObject4;
      int i;
      if (this.HuF == null)
      {
        this.HuF = new HashSet();
        localObject1 = com.tencent.mm.plugin.fts.a.a.a.TABLE.select(kotlin.a.p.listOf(com.tencent.mm.plugin.fts.a.a.a.Hsr)).log("MicroMsg.FTS.FTS5SearchChatroomMemberLogic").build();
        Object localObject3 = a.a(this.HuJ);
        if (localObject3 != null)
        {
          localObject3 = ((com.tencent.mm.plugin.fts.a.a)localObject3).HqR;
          if (localObject3 != null)
          {
            localObject1 = ((com.tencent.mm.plugin.fts.a.h)localObject3).rawQuery(((SelectSql)localObject1).toSql(), ((SelectSql)localObject1).getParams());
            if (localObject1 != null)
            {
              localObject1 = (Closeable)localObject1;
              try
              {
                localObject3 = (Cursor)localObject1;
                while (((Cursor)localObject3).moveToNext())
                {
                  HashSet localHashSet = this.HuF;
                  if (localHashSet != null) {
                    localHashSet.add(((Cursor)localObject3).getString(0));
                  }
                }
                localObject1 = this.HuF;
              }
              finally
              {
                try
                {
                  AppMethodBeat.o(265524);
                  throw localThrowable2;
                }
                finally
                {
                  kotlin.f.b.a((Closeable)localObject1, localThrowable2);
                  AppMethodBeat.o(265524);
                }
                localObject4 = ah.aiuX;
                kotlin.f.b.a((Closeable)localObject1, null);
              }
            }
          }
        }
        if (localObject1 == null)
        {
          i = 0;
          this.HuG = i;
        }
      }
      else
      {
        aEp("getBuildChatroomSet");
      }
      Object localObject9;
      Object localObject8;
      label502:
      Object localObject6;
      label649:
      for (;;)
      {
        if (Thread.interrupted())
        {
          localObject1 = new InterruptedException();
          AppMethodBeat.o(265524);
          throw ((Throwable)localObject1);
          i = ((HashSet)localObject1).size();
          break;
        }
        localObject1 = aw.TABLE.select(kotlin.a.p.listOf(new Column[] { aw.jWQ, aw.jWS })).log("MicroMsg.FTS.FTS5SearchChatroomMemberLogic").limit(50, this.offset).orderBy(kotlin.a.p.listOf(aw.ROWID.orderInc())).build();
        localObject9 = new ArrayList(50);
        localObject4 = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).getFTSMainDB();
        Closeable localCloseable;
        if (localObject4 != null)
        {
          localObject1 = ((com.tencent.mm.plugin.fts.a.j)localObject4).rawQuery(((SelectSql)localObject1).toSql(), ((SelectSql)localObject1).getParams());
          if (localObject1 != null)
          {
            localCloseable = (Closeable)localObject1;
            for (;;)
            {
              try
              {
                localCursor = (Cursor)localCloseable;
                if (!localCursor.moveToNext()) {
                  continue;
                }
                localObject1 = localCursor.getString(0);
                if (localObject1 != null) {
                  continue;
                }
                localObject1 = "";
              }
              finally
              {
                try
                {
                  Cursor localCursor;
                  AppMethodBeat.o(265524);
                  throw localThrowable1;
                }
                finally
                {
                  kotlin.f.b.a(localCloseable, localThrowable1);
                  AppMethodBeat.o(265524);
                }
                continue;
                localObject2 = ah.aiuX;
                kotlin.f.b.a(localCloseable, null);
              }
              localObject8 = localCursor.getString(1);
              localObject4 = localObject8;
              if (localObject8 == null) {
                localObject4 = "";
              }
              ((ArrayList)localObject9).add(new a.c((String)localObject1, (String)localObject4));
            }
          }
        }
        if (((ArrayList)localObject9).isEmpty()) {
          break label651;
        }
        this.offset += 50;
        localObject2 = a.a(this.HuJ);
        if ((localObject2 != null) && (((com.tencent.mm.plugin.fts.b.a)localObject2).inTransaction() == true))
        {
          i = 1;
          if (i == 0)
          {
            localObject2 = a.a(this.HuJ);
            if (localObject2 != null) {
              ((com.tencent.mm.plugin.fts.b.a)localObject2).beginTransaction();
            }
          }
          localObject2 = ((ArrayList)localObject9).iterator();
          s.s(localObject2, "resultList.iterator()");
        }
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label601;
          }
          localObject6 = ((Iterator)localObject2).next();
          s.s(localObject6, "resultIterator.next()");
          localObject6 = (a.c)localObject6;
          localObject8 = this.HuF;
          if ((localObject8 != null) && (((HashSet)localObject8).remove(((a.c)localObject6).username) == true)) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label579;
            }
            ((Iterator)localObject2).remove();
            break label502;
            i = 0;
            break;
          }
          label579:
          this.HuH += 1;
          a.a(this.HuJ, (a.c)localObject6);
        }
        label601:
        localObject2 = a.a(this.HuJ);
        if ((localObject2 != null) && (((com.tencent.mm.plugin.fts.b.a)localObject2).inTransaction() == true)) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label649;
          }
          localObject2 = a.a(this.HuJ);
          if (localObject2 == null) {
            break;
          }
          ((com.tencent.mm.plugin.fts.b.a)localObject2).commit();
          break;
        }
      }
      label651:
      aEp("buildChatroomMemberIndex");
      Object localObject2 = this.HuF;
      if (localObject2 != null)
      {
        if (!((Collection)localObject2).isEmpty())
        {
          i = 1;
          if (i == 0) {
            break label771;
          }
        }
        for (;;)
        {
          if (localObject2 == null) {
            break label776;
          }
          localObject6 = (Iterable)localObject2;
          localObject2 = this.HuJ;
          localObject6 = ((Iterable)localObject6).iterator();
          while (((Iterator)localObject6).hasNext())
          {
            localObject8 = (String)((Iterator)localObject6).next();
            this.HuI += 1;
            localObject9 = a.a((a)localObject2);
            if (localObject9 != null) {
              ((com.tencent.mm.plugin.fts.b.a)localObject9).b(new int[] { 2097168 }, (String)localObject8);
            }
          }
          i = 0;
          break;
          label771:
          localObject2 = null;
        }
      }
      label776:
      aEp("deleteUnuseChatroom");
      AppMethodBeat.o(265524);
      return true;
    }
    
    public final String coz()
    {
      AppMethodBeat.i(265514);
      Object localObject = am.aixg;
      localObject = String.format("{build: " + this.HuG + " new: " + this.HuH + ", remove: " + this.HuI, Arrays.copyOf(new Object[0], 0));
      s.s(localObject, "java.lang.String.format(format, *args)");
      AppMethodBeat.o(265514);
      return localObject;
    }
    
    public final String getName()
    {
      return "BuildChatroomMemberIndexTask";
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/fts/logic/FTS5SearchChatroomMemberLogic$BuildSingleChatroomMemberTask;", "Lcom/tencent/mm/plugin/fts/api/model/BaseFTSTask;", "chatroomMember", "Lcom/tencent/mm/storage/ChatRoomMember;", "(Lcom/tencent/mm/plugin/fts/logic/FTS5SearchChatroomMemberLogic;Lcom/tencent/mm/storage/ChatRoomMember;)V", "getChatroomMember", "()Lcom/tencent/mm/storage/ChatRoomMember;", "execute", "", "extraInfo", "", "getName", "plugin-fts_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends c
  {
    private final aj HuK;
    
    public b()
    {
      AppMethodBeat.i(265504);
      this.HuK = localObject;
      AppMethodBeat.o(265504);
    }
    
    public final boolean aXz()
    {
      AppMethodBeat.i(265511);
      Log.i("MicroMsg.FTS.FTS5SearchChatroomMemberLogic", s.X("buildChatroomMember ", this.HuK.field_chatroomname));
      Object localObject = a.a(a.this);
      if (localObject != null)
      {
        str1 = this.HuK.field_chatroomname;
        ((com.tencent.mm.plugin.fts.b.a)localObject).b(new int[] { 2097168 }, str1);
      }
      localObject = a.this;
      String str1 = this.HuK.field_chatroomname;
      s.s(str1, "chatroomMember.field_chatroomname");
      String str2 = this.HuK.field_memberlist;
      s.s(str2, "chatroomMember.field_memberlist");
      a.a((a)localObject, new a.c(str1, str2));
      AppMethodBeat.o(265511);
      return true;
    }
    
    public final String coz()
    {
      AppMethodBeat.i(265519);
      String str = s.X("usename: ", this.HuK.field_chatroomname);
      AppMethodBeat.o(265519);
      return str;
    }
    
    public final String getName()
    {
      return "BuildSingleChatroomMemberTask";
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/fts/logic/FTS5SearchChatroomMemberLogic$SearchCommonChatroomTask;", "Lcom/tencent/mm/plugin/fts/api/model/FTSQueryTask;", "ftsRequest", "Lcom/tencent/mm/plugin/fts/api/model/FTSRequest;", "(Lcom/tencent/mm/plugin/fts/logic/FTS5SearchChatroomMemberLogic;Lcom/tencent/mm/plugin/fts/api/model/FTSRequest;)V", "execSearch", "", "ftsResult", "Lcom/tencent/mm/plugin/fts/api/model/FTSResult;", "getName", "", "plugin-fts_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class e
    extends k
  {
    public e()
    {
      super();
      AppMethodBeat.i(265508);
      AppMethodBeat.o(265508);
    }
    
    public final void a(com.tencent.mm.plugin.fts.a.a.m paramm)
    {
      AppMethodBeat.i(265517);
      l locall = this.Htr;
      Object localObject2 = a.this;
      if ((paramm != null) && (locall != null))
      {
        Object localObject3 = com.tencent.mm.plugin.fts.a.a.j.hR(locall.HtD);
        int i = locall.HtD.size();
        paramm.FWt = ((com.tencent.mm.plugin.fts.a.a.j)localObject3);
        localObject2 = a.a((a)localObject2);
        if (localObject2 != null)
        {
          s.s(localObject3, "ftsQuery");
          s.u(localObject3, "ftsQuery");
          localObject3 = ((com.tencent.mm.plugin.fts.a.a.j)localObject3).fxx();
          Object localObject4 = am.aixg;
          localObject3 = String.format("SELECT aux_index FROM " + ((com.tencent.mm.plugin.fts.b.a)localObject2).fxo() + " NOT INDEXED JOIN " + ((com.tencent.mm.plugin.fts.b.a)localObject2).fxn() + " ON (" + ((com.tencent.mm.plugin.fts.b.a)localObject2).fxn() + ".docid = " + ((com.tencent.mm.plugin.fts.b.a)localObject2).fxo() + ".rowid) WHERE " + ((com.tencent.mm.plugin.fts.b.a)localObject2).fxo() + " MATCH '" + localObject3 + "' AND entity_id = " + (i + 1) + " ORDER BY timestamp DESC;", Arrays.copyOf(new Object[0], 0));
          s.s(localObject3, "java.lang.String.format(format, *args)");
          localObject2 = ((com.tencent.mm.plugin.fts.a.a)localObject2).HqR.rawQuery((String)localObject3, null);
          s.s(localObject2, "indexDB.rawQuery(sql, null)");
          if (localObject2 != null)
          {
            localObject2 = (Closeable)localObject2;
            try
            {
              localObject3 = (Cursor)localObject2;
              do
              {
                if (!((Cursor)localObject3).moveToNext()) {
                  break;
                }
                localObject4 = new com.tencent.mm.plugin.fts.a.a.p();
                ((com.tencent.mm.plugin.fts.a.a.p)localObject4).Hsz = ((Cursor)localObject3).getString(0);
                paramm.HtF.add(localObject4);
              } while (paramm.HtF.size() < locall.Htz);
              paramm = ah.aiuX;
              kotlin.f.b.a((Closeable)localObject2, null);
              AppMethodBeat.o(265517);
              return;
            }
            finally
            {
              try
              {
                AppMethodBeat.o(265517);
                throw paramm;
              }
              finally
              {
                kotlin.f.b.a((Closeable)localObject2, paramm);
                AppMethodBeat.o(265517);
              }
            }
          }
        }
      }
      AppMethodBeat.o(265517);
    }
    
    public final String getName()
    {
      return "SearchCommonChatroomTask";
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/fts/logic/FTS5SearchChatroomMemberLogic$SearchCommonChatroomUserTask;", "Lcom/tencent/mm/plugin/fts/api/model/FTSQueryTask;", "ftsRequest", "Lcom/tencent/mm/plugin/fts/api/model/FTSRequest;", "(Lcom/tencent/mm/plugin/fts/logic/FTS5SearchChatroomMemberLogic;Lcom/tencent/mm/plugin/fts/api/model/FTSRequest;)V", "execSearch", "", "ftsResult", "Lcom/tencent/mm/plugin/fts/api/model/FTSResult;", "getName", "", "plugin-fts_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class f
    extends k
  {
    public f()
    {
      super();
      AppMethodBeat.i(265516);
      AppMethodBeat.o(265516);
    }
    
    public final void a(com.tencent.mm.plugin.fts.a.a.m paramm)
    {
      AppMethodBeat.i(265526);
      l locall = this.Htr;
      a locala = a.this;
      if ((paramm != null) && (locall != null))
      {
        Object localObject5 = com.tencent.mm.plugin.fts.a.a.j.hR(locall.HtD);
        paramm.FWt = ((com.tencent.mm.plugin.fts.a.a.j)localObject5);
        Object localObject3 = new HashSet();
        Object localObject4 = a.a(locala);
        Object localObject6;
        if (localObject4 != null)
        {
          s.s(localObject5, "ftsQuery");
          s.u(localObject5, "ftsQuery");
          localObject5 = ((com.tencent.mm.plugin.fts.a.a.j)localObject5).fxx();
          localObject6 = am.aixg;
          localObject5 = String.format("SELECT content FROM " + ((com.tencent.mm.plugin.fts.b.a)localObject4).fxo() + " NOT INDEXED JOIN " + ((com.tencent.mm.plugin.fts.b.a)localObject4).fxn() + " ON (" + ((com.tencent.mm.plugin.fts.b.a)localObject4).fxn() + ".docid = " + ((com.tencent.mm.plugin.fts.b.a)localObject4).fxo() + ".rowid) WHERE " + ((com.tencent.mm.plugin.fts.b.a)localObject4).fxo() + " MATCH '" + localObject5 + "' AND entity_id <= 50 ORDER BY timestamp DESC LIMIT 10;", Arrays.copyOf(new Object[0], 0));
          s.s(localObject5, "java.lang.String.format(format, *args)");
          localObject4 = ((com.tencent.mm.plugin.fts.a.a)localObject4).HqR.rawQuery((String)localObject5, null);
          s.s(localObject4, "indexDB.rawQuery(sql, null)");
          if (localObject4 != null) {
            localObject4 = (Closeable)localObject4;
          }
        }
        try
        {
          localObject5 = (Cursor)localObject4;
          int j;
          int i;
          while (((Cursor)localObject5).moveToNext())
          {
            localObject6 = ((Cursor)localObject5).getString(0);
            localObject6 = c.a.HrA.split((CharSequence)localObject6);
            s.s(localObject6, "SPLIT_FIRST_CONTENT_PATTERN.split(content)");
            localObject6 = (Object[])localObject6;
            j = localObject6.length;
            i = 0;
            while (i < j)
            {
              ((HashSet)localObject3).add((String)localObject6[i]);
              i += 1;
            }
          }
          localObject5 = ah.aiuX;
          kotlin.f.b.a((Closeable)localObject4, null);
          aEp("queryCommonChatroom");
          localObject4 = (Iterable)localObject3;
          localObject3 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject4, 10));
          localObject4 = ((Iterable)localObject4).iterator();
          while (((Iterator)localObject4).hasNext()) {
            ((Collection)localObject3).add((String)((Iterator)localObject4).next());
          }
          int k;
          AppMethodBeat.o(265526);
        }
        finally
        {
          try
          {
            AppMethodBeat.o(265526);
            throw paramm;
          }
          finally
          {
            kotlin.f.b.a((Closeable)localObject4, paramm);
            AppMethodBeat.o(265526);
          }
          localObject3 = (List)localObject3;
          j = 0;
          for (;;)
          {
            localObject5 = (Iterable)localObject3;
            localObject4 = (Collection)new ArrayList();
            localObject5 = ((Iterable)localObject5).iterator();
            k = 0;
            if (((Iterator)localObject5).hasNext())
            {
              localObject6 = ((Iterator)localObject5).next();
              if (k < 0) {
                kotlin.a.p.kkW();
              }
              if (j <= k) {
                if (k <= j + 100) {
                  i = 1;
                }
              }
              for (;;)
              {
                if (i != 0) {
                  ((Collection)localObject4).add(localObject6);
                }
                k += 1;
                break;
                i = 0;
                continue;
                i = 0;
              }
            }
            localObject4 = (List)localObject4;
            if (!((List)localObject4).isEmpty())
            {
              localObject4 = com.tencent.mm.plugin.fts.a.a.b.Hsr.inString((List)localObject4).and((ISqlCondition)com.tencent.mm.plugin.fts.a.a.b.SUBTYPE.equal("5")).and((ISqlCondition)com.tencent.mm.plugin.fts.a.a.b.TYPE.equal("131072"));
              localObject4 = com.tencent.mm.plugin.fts.a.a.b.TABLE.select(kotlin.a.p.listOf(com.tencent.mm.plugin.fts.a.a.b.Hsr)).where((ISqlCondition)localObject4).orderBy(kotlin.a.p.listOf(com.tencent.mm.plugin.fts.a.a.b.kkd.orderDesc())).build();
              localObject5 = a.a(locala);
              if (localObject5 != null)
              {
                localObject5 = ((com.tencent.mm.plugin.fts.a.a)localObject5).HqR;
                if (localObject5 != null)
                {
                  localObject4 = ((com.tencent.mm.plugin.fts.a.h)localObject5).rawQuery(((SelectSql)localObject4).toSql(), ((SelectSql)localObject4).getParams());
                  if (localObject4 != null) {
                    localObject4 = (Closeable)localObject4;
                  }
                }
              }
              try
              {
                localObject5 = (Cursor)localObject4;
                do
                {
                  do
                  {
                    if (!((Cursor)localObject5).moveToNext()) {
                      break;
                    }
                    localObject6 = ((Cursor)localObject5).getString(0);
                  } while ((localObject1.HtD.contains(localObject6)) || (s.p(localObject6, z.bAM())));
                  localObject6 = new com.tencent.mm.plugin.fts.a.a.p();
                  ((com.tencent.mm.plugin.fts.a.a.p)localObject6).Hsz = ((Cursor)localObject5).getString(0);
                  paramm.HtF.add(localObject6);
                } while (paramm.HtF.size() < localObject1.Htz);
                localObject5 = ah.aiuX;
                kotlin.f.b.a((Closeable)localObject4, null);
                if (paramm.HtF.size() < localObject1.Htz) {
                  j += 100;
                }
              }
              finally
              {
                try
                {
                  AppMethodBeat.o(265526);
                  throw paramm;
                }
                finally
                {
                  kotlin.f.b.a((Closeable)localObject4, paramm);
                  AppMethodBeat.o(265526);
                }
              }
            }
          }
          aEp("queryRelatedUser");
        }
      }
    }
    
    public final String getName()
    {
      return "SearchCommonChatroomUserTask";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.logic.a
 * JD-Core Version:    0.7.0.1
 */