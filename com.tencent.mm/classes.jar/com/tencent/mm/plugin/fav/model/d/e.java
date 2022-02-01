package com.tencent.mm.plugin.fav.model.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.ab;
import com.tencent.mm.protocal.protobuf.emv;
import com.tencent.mm.protocal.protobuf.emw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/fav/model/service/FavRecentlyUsedService;", "Lcom/tencent/mm/plugin/fav/api/IFavRecentlyUsedService;", "()V", "KEY_PREF", "", "MAX_RECENT_SIZE", "", "TAG", "mlist", "Lcom/tencent/mm/protocal/protobuf/RecentFavList;", "storage", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getStorage", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "storage$delegate", "Lkotlin/Lazy;", "delete", "", "id", "", "(Ljava/lang/Long;)V", "getCurKey", "getIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getRecentFavList", "record", "saveRecentFavList", "plugin-fav_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements ab
{
  public static final e AeM;
  private static final String AeN;
  private static emw AeO;
  private static final j sZg;
  
  static
  {
    AppMethodBeat.i(274366);
    AeM = new e();
    sZg = k.cm((kotlin.g.a.a)a.AeP);
    AeN = "recentIds";
    AppMethodBeat.o(274366);
  }
  
  private static MultiProcessMMKV dRj()
  {
    AppMethodBeat.i(274362);
    Object localObject = sZg.getValue();
    s.s(localObject, "<get-storage>(...)");
    localObject = (MultiProcessMMKV)localObject;
    AppMethodBeat.o(274362);
    return localObject;
  }
  
  private static String dRk()
  {
    AppMethodBeat.i(274363);
    String str = s.X(AeN, com.tencent.mm.plugin.auth.a.a.cUx());
    AppMethodBeat.o(274363);
    return str;
  }
  
  private static void dRl()
  {
    AppMethodBeat.i(274364);
    emw localemw = AeO;
    if (localemw != null) {
      dRj().encode(dRk(), localemw.toByteArray());
    }
    AppMethodBeat.o(274364);
  }
  
  private static emw dRm()
  {
    AppMethodBeat.i(274365);
    emw localemw = AeO;
    if (localemw != null)
    {
      AppMethodBeat.o(274365);
      return localemw;
    }
    localemw = new emw();
    byte[] arrayOfByte = dRj().decodeBytes(dRk());
    if (arrayOfByte != null) {
      localemw.parseFrom(arrayOfByte);
    }
    AeO = localemw;
    AppMethodBeat.o(274365);
    return localemw;
  }
  
  public final void d(Long paramLong)
  {
    AppMethodBeat.i(274367);
    emw localemw = dRm();
    Object localObject = localemw.lPK;
    s.s(localObject, "list.list");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      emv localemv = (emv)((Iterator)localObject).next();
      long l = localemv.id;
      if ((paramLong != null) && (l == paramLong.longValue()))
      {
        localemw.lPK.remove(localemv);
        dRl();
        Log.d("MicroMsg.Fav.FavRecentlyUsedService", s.X("delete() called id:", paramLong));
        AppMethodBeat.o(274367);
        return;
      }
    }
    AppMethodBeat.o(274367);
  }
  
  public final ArrayList<Long> dQQ()
  {
    AppMethodBeat.i(274368);
    Object localObject = dRm();
    ArrayList localArrayList = new ArrayList();
    localObject = ((emw)localObject).lPK;
    s.s(localObject, "list.list");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(0, Long.valueOf(((emv)((Iterator)localObject).next()).id));
    }
    Log.d("MicroMsg.Fav.FavRecentlyUsedService", s.X("getIds() called ", localArrayList));
    AppMethodBeat.o(274368);
    return localArrayList;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<MultiProcessMMKV>
  {
    public static final a AeP;
    
    static
    {
      AppMethodBeat.i(274360);
      AeP = new a();
      AppMethodBeat.o(274360);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.model.d.e
 * JD-Core Version:    0.7.0.1
 */