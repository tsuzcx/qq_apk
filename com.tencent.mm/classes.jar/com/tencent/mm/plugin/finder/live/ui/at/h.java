package com.tencent.mm.plugin.finder.live.ui.at;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.ac.a.a.a;
import com.tencent.mm.plugin.ac.b.a;
import com.tencent.mm.plugin.mvvmlist.a.c;
import com.tencent.mm.sdk.coroutines.LifecycleScope;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.ISqlCondition;
import com.tencent.mm.sdk.storage.sql.SelectSql;
import com.tencent.mm.sdk.storage.sql.SelectSql.Builder;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlinx.coroutines.a.f;
import kotlinx.coroutines.a.q;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/ui/at/FinderLiveAtGroupDataSource;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/BaseDataSource;", "Lcom/tencent/mm/plugin/finder/ui/at/FinderAtSomeoneLiveItem;", "chatroom", "", "(Ljava/lang/String;)V", "getChatroom", "()Ljava/lang/String;", "chatroomMember", "Lcom/tencent/mm/storage/ChatRoomMember;", "getChatroomMember", "()Lcom/tencent/mm/storage/ChatRoomMember;", "setChatroomMember", "(Lcom/tencent/mm/storage/ChatRoomMember;)V", "dbProvider", "Lcom/tencent/mm/kernel/mvvm/MainDBProvider;", "getDbProvider", "()Lcom/tencent/mm/kernel/mvvm/MainDBProvider;", "dbProvider$delegate", "Lkotlin/Lazy;", "memberList", "", "getMemberList", "()Ljava/util/List;", "setMemberList", "(Ljava/util/List;)V", "getData", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataResponse;", "scope", "Lcom/tencent/mm/sdk/coroutines/LifecycleScope;", "request", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataRequest;", "getPriority", "", "onCreate", "", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends com.tencent.mm.plugin.mvvmlist.a.a<com.tencent.mm.plugin.finder.ui.at.g>
{
  public static final a akfw;
  private final j DHI;
  private aj HuK;
  private final String hCy;
  private List<String> hSb;
  
  static
  {
    AppMethodBeat.i(371276);
    akfw = new a((byte)0);
    AppMethodBeat.o(371276);
  }
  
  public h(String paramString)
  {
    AppMethodBeat.i(371274);
    this.hCy = paramString;
    this.DHI = kotlin.k.cm((kotlin.g.a.a)b.akfx);
    AppMethodBeat.o(371274);
  }
  
  public final kotlinx.coroutines.b.g<com.tencent.mm.plugin.mvvmlist.a.d<com.tencent.mm.plugin.finder.ui.at.g>> a(LifecycleScope paramLifecycleScope, c<com.tencent.mm.plugin.finder.ui.at.g> paramc)
  {
    AppMethodBeat.i(371283);
    s.u(paramLifecycleScope, "scope");
    s.u(paramc, "request");
    paramLifecycleScope = new com.tencent.mm.plugin.mvvmlist.a.d(paramc);
    q localq = new q();
    Object localObject = this.hSb;
    int j;
    int i;
    if ((localObject != null) && (paramc.offset < ((List)localObject).size()))
    {
      j = paramc.offset;
      if (((List)localObject).size() > paramc.offset + paramc.pageSize)
      {
        paramLifecycleScope.ABD = true;
        i = paramc.offset + paramc.pageSize;
        paramc = new ArrayList();
        if (j >= i) {}
      }
    }
    for (;;)
    {
      int k = j + 1;
      paramc.add(((List)localObject).get(j));
      if (k >= i)
      {
        localObject = com.tencent.mm.plugin.ac.b.MnM;
        paramc = ((Iterable)((com.tencent.mm.plugin.ac.a.a)b.a.q(com.tencent.mm.plugin.ac.a.a.class)).jh((List)paramc)).iterator();
        for (;;)
        {
          if (paramc.hasNext())
          {
            localObject = (au)paramc.next();
            if ((int)((com.tencent.mm.contact.d)localObject).maN != 0)
            {
              paramLifecycleScope.pUj.add(new com.tencent.mm.plugin.finder.ui.at.g(0, (au)localObject, 3));
              continue;
              i = ((List)localObject).size();
              break;
            }
          }
        }
        localq.offer(paramLifecycleScope);
        paramLifecycleScope = kotlinx.coroutines.b.k.a((f)localq);
        AppMethodBeat.o(371283);
        return paramLifecycleScope;
      }
      j = k;
    }
  }
  
  public final int getPriority()
  {
    return -1;
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(371279);
    this.HuK = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(this.hCy);
    List localList = v.Il(this.hCy);
    if (localList == null) {
      localList = null;
    }
    for (;;)
    {
      this.hSb = localList;
      AppMethodBeat.o(371279);
      return;
      localList.remove(z.bAM());
      Object localObject1 = az.TABLE.select(p.listOf(az.USERNAME)).log("FinderLiveAtGroupDataSource").where((ISqlCondition)az.USERNAME.inString(localList));
      Object localObject3 = com.tencent.mm.plugin.ac.a.a.MnU;
      localObject3 = ((SelectSql.Builder)localObject1).orderBy(a.a.gsC()).build();
      localObject1 = new ArrayList();
      Object localObject4 = ((com.tencent.mm.kernel.mvvm.b)this.DHI.getValue()).getDB();
      if (localObject4 != null)
      {
        localObject3 = ((ISQLiteDatabase)localObject4).rawQuery(((SelectSql)localObject3).getSql(), ((SelectSql)localObject3).getParams());
        if (localObject3 != null)
        {
          localObject3 = (Closeable)localObject3;
          try
          {
            localObject4 = (Cursor)localObject3;
            while (((Cursor)localObject4).moveToNext()) {
              ((ArrayList)localObject1).add(((Cursor)localObject4).getString(0));
            }
            localThrowable.clear();
          }
          finally
          {
            try
            {
              AppMethodBeat.o(371279);
              throw localThrowable;
            }
            finally
            {
              kotlin.f.b.a((Closeable)localObject3, localThrowable);
              AppMethodBeat.o(371279);
            }
            localObject4 = ah.aiuX;
            kotlin.f.b.a((Closeable)localObject3, null);
          }
        }
      }
      localThrowable.addAll((Collection)localObject2);
      ah localah = ah.aiuX;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/ui/at/FinderLiveAtGroupDataSource$Companion;", "", "()V", "AT_ALL_USERNAME", "", "TAG", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/kernel/mvvm/MainDBProvider;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<com.tencent.mm.kernel.mvvm.b>
  {
    public static final b akfx;
    
    static
    {
      AppMethodBeat.i(371287);
      akfx = new b();
      AppMethodBeat.o(371287);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.ui.at.h
 * JD-Core Version:    0.7.0.1
 */