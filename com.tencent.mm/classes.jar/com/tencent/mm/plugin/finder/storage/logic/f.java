package com.tencent.mm.plugin.finder.storage.logic;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.cz;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.model.a;
import com.tencent.mm.plugin.finder.model.bb;
import com.tencent.mm.plugin.finder.model.bc;
import com.tencent.mm.plugin.finder.model.bd;
import com.tencent.mm.plugin.finder.model.be;
import com.tencent.mm.plugin.finder.model.bf;
import com.tencent.mm.plugin.finder.model.bg;
import com.tencent.mm.plugin.finder.model.bh;
import com.tencent.mm.plugin.finder.model.bi;
import com.tencent.mm.plugin.finder.model.bk;
import com.tencent.mm.plugin.finder.storage.av;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.io.Closeable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.f.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/logic/FinderMentionLogic;", "", "()V", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final a FNJ;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(167113);
    FNJ = new a((byte)0);
    TAG = "Finder.FinderMentionLogic";
    AppMethodBeat.o(167113);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/logic/FinderMentionLogic$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "deleteMention", "", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "scene", "", "getAfterTimeLimit", "", "mentionId", "", "limit", "types", "", "getBeforeTimeLimit", "getByMentionIdCreateTime", "mentionCreateTime", "getDbSelect", "getLocalFlag", "insertMention", "mentionList", "removePrivateMention", "", "clientMsgId", "transformFinderMentionToCovertData", "Lcom/tencent/mm/plugin/finder/model/BaseFinderMsg;", "transformMentionToLocal", "Lcom/tencent/mm/protocal/protobuf/FinderMention;", "updateMentionExtFlag", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static int L(List<av> paramList, int paramInt)
    {
      AppMethodBeat.i(339523);
      s.u(paramList, "mentionList");
      Iterator localIterator = ((Iterable)paramList).iterator();
      int i = 0;
      av localav;
      if (localIterator.hasNext())
      {
        paramList = (av)localIterator.next();
        Object localObject = f.FNJ;
        s.u(paramList, "mention");
        localObject = ((PluginFinder)h.az(PluginFinder.class)).getMentionStorage(Tz(paramInt));
        localav = t(paramList.field_id, paramList.field_createTime, paramInt);
        if (localav != null) {
          ((MAutoStorage)localObject).delete(localav.systemRowid);
        }
        boolean bool = ((MAutoStorage)localObject).insert((IAutoDBItem)paramList);
        localObject = f.access$getTAG$cp();
        StringBuilder localStringBuilder = new StringBuilder("replace mention success ").append(paramList.field_id).append(", ");
        if (localav == null)
        {
          paramList = "null";
          label149:
          Log.i((String)localObject, paramList + ", " + bool);
          if (!bool) {
            break label217;
          }
          i += 1;
        }
      }
      label217:
      for (;;)
      {
        break;
        paramList = Long.valueOf(localav.systemRowid);
        break label149;
        Log.i(f.access$getTAG$cp(), s.X("insert mention ", Integer.valueOf(i)));
        AppMethodBeat.o(339523);
        return i;
      }
    }
    
    private static String Ty(int paramInt)
    {
      AppMethodBeat.i(339569);
      if (Tz(paramInt) == 1) {}
      for (String str = cz.ktN;; str = cz.ktM)
      {
        str = s.X("SELECT rowid, * FROM ", str);
        AppMethodBeat.o(339569);
        return str;
      }
    }
    
    public static int Tz(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return 0;
      case 2: 
        return 1;
      }
      return 2;
    }
    
    public static List<av> a(long paramLong, int paramInt1, int[] paramArrayOfInt, int paramInt2)
    {
      AppMethodBeat.i(167110);
      s.u(paramArrayOfInt, "types");
      Object localObject3 = ((PluginFinder)h.az(PluginFinder.class)).getMentionStorage(Tz(paramInt2));
      int k = h.baE().ban().getInt(at.a.adda, 0);
      int i;
      label104:
      Object localObject1;
      if (paramArrayOfInt.length == 0)
      {
        i = 1;
        if (i == 0) {
          break label170;
        }
        paramArrayOfInt = Ty(paramInt2) + " WHERE id < " + paramLong + "  AND flag = 0  AND userVersion = " + k + " ORDER BY createTime DESC,id DESC LIMIT " + paramInt1;
        Log.i(f.access$getTAG$cp(), s.X("get mention sql ", paramArrayOfInt));
        localObject1 = ((MAutoStorage)localObject3).rawQuery(paramArrayOfInt, new String[0]);
        if (localObject1 != null) {
          break label314;
        }
        paramArrayOfInt = null;
        label135:
        if (paramArrayOfInt != null) {
          break label426;
        }
      }
      for (;;)
      {
        label170:
        Object localObject2;
        try
        {
          paramArrayOfInt = (List)new LinkedList();
          return paramArrayOfInt;
        }
        finally
        {
          int m;
          int j;
          int n;
          ((Cursor)localObject1).close();
          AppMethodBeat.o(167110);
        }
        i = 0;
        break;
        localObject1 = "(";
        m = paramArrayOfInt.length;
        j = 0;
        i = 0;
        if (j < m)
        {
          n = paramArrayOfInt[j];
          localObject2 = localObject1;
          if (i > 0) {
            localObject2 = s.X((String)localObject1, ",");
          }
          localObject1 = s.X((String)localObject2, Integer.valueOf(n));
          j += 1;
          i += 1;
        }
        else
        {
          paramArrayOfInt = s.X((String)localObject1, ")");
          paramArrayOfInt = Ty(paramInt2) + " WHERE id < " + paramLong + "  AND flag = 0  AND type IN " + paramArrayOfInt + " AND userVersion = " + k + " ORDER BY createTime DESC,id DESC LIMIT " + paramInt1;
          break label104;
          label314:
          paramArrayOfInt = new LinkedList();
          localObject2 = (Closeable)localObject1;
          try
          {
            localObject3 = (Cursor)localObject2;
            if (((Cursor)localObject3).moveToNext())
            {
              IAutoDBItem localIAutoDBItem = (IAutoDBItem)av.class.newInstance();
              localIAutoDBItem.convertFrom((Cursor)localObject3);
              paramArrayOfInt.add(localIAutoDBItem);
              continue;
              paramArrayOfInt = finally;
            }
          }
          finally
          {
            try
            {
              AppMethodBeat.o(167110);
              throw paramArrayOfInt;
            }
            finally
            {
              b.a((Closeable)localObject2, paramArrayOfInt);
              AppMethodBeat.o(167110);
            }
          }
          ah localah = ah.aiuX;
          b.a((Closeable)localObject2, null);
          break label135;
          label426:
          paramArrayOfInt = (List)paramArrayOfInt;
        }
      }
    }
    
    public static boolean a(av paramav, int paramInt)
    {
      AppMethodBeat.i(339534);
      s.u(paramav, "mention");
      MAutoStorage localMAutoStorage = ((PluginFinder)h.az(PluginFinder.class)).getMentionStorage(Tz(paramInt));
      if (Tz(paramInt) == 1) {}
      for (String str1 = cz.ktN;; str1 = cz.ktM)
      {
        String str2 = "UPDATE " + str1 + " SET extFlag=" + paramav.field_extFlag + " WHERE id=" + paramav.field_id;
        boolean bool = localMAutoStorage.execSQL(str1, str2);
        Log.i(f.access$getTAG$cp(), "updateMentionExtFlag sql:" + str2 + ", flag:" + paramav.field_extFlag);
        AppMethodBeat.o(339534);
        return bool;
      }
    }
    
    public static boolean b(av paramav, int paramInt)
    {
      AppMethodBeat.i(339544);
      s.u(paramav, "mention");
      MAutoStorage localMAutoStorage = ((PluginFinder)h.az(PluginFinder.class)).getMentionStorage(Tz(paramInt));
      if (Tz(paramInt) == 1) {}
      for (String str1 = cz.ktN;; str1 = cz.ktM)
      {
        String str2 = "DELETE FROM " + str1 + " WHERE id=" + paramav.field_id;
        boolean bool = localMAutoStorage.execSQL(str1, str2);
        Log.i(f.access$getTAG$cp(), "updateMentionExtFlag sql:" + str2 + ", flag:" + paramav.field_extFlag + " succ:" + bool);
        AppMethodBeat.o(339544);
        return bool;
      }
    }
    
    public static a c(av paramav)
    {
      AppMethodBeat.i(339563);
      s.u(paramav, "mention");
      switch (paramav.field_type)
      {
      case 6: 
      case 9: 
      default: 
        AppMethodBeat.o(339563);
        return null;
      case 4: 
        paramav = (a)new bk(paramav);
        AppMethodBeat.o(339563);
        return paramav;
      case 2: 
        paramav = (a)new bh(paramav);
        AppMethodBeat.o(339563);
        return paramav;
      case 3: 
        paramav = (a)new bb(paramav);
        AppMethodBeat.o(339563);
        return paramav;
      case 5: 
        paramav = (a)new bi(paramav);
        AppMethodBeat.o(339563);
        return paramav;
      case 1: 
        paramav = (a)new bc(paramav);
        AppMethodBeat.o(339563);
        return paramav;
      case 7: 
        paramav = (a)new bg(paramav);
        AppMethodBeat.o(339563);
        return paramav;
      case 8: 
        paramav = (a)new bf(paramav);
        AppMethodBeat.o(339563);
        return paramav;
      case 10: 
        paramav = (a)new bd(paramav);
        AppMethodBeat.o(339563);
        return paramav;
      }
      paramav = (a)new be(paramav);
      AppMethodBeat.o(339563);
      return paramav;
    }
    
    public static av t(long paramLong, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(339553);
      Log.i(f.access$getTAG$cp(), "getMention by id " + paramLong + " mentionCreateTime " + paramInt1);
      Object localObject1 = ((PluginFinder)h.az(PluginFinder.class)).getMentionStorage(Tz(paramInt2));
      Object localObject2 = Ty(paramInt2) + " WHERE id = " + paramLong + " AND createTime = " + paramInt1;
      Log.d(f.access$getTAG$cp(), s.X("get mention sql ", localObject2));
      localObject2 = ((MAutoStorage)localObject1).rawQuery((String)localObject2, new String[0]);
      if (localObject2 != null) {
        localObject1 = (Closeable)localObject2;
      }
      try
      {
        if (((Cursor)localObject2).moveToNext())
        {
          av localav = new av();
          localav.convertFrom((Cursor)localObject2);
          b.a((Closeable)localObject1, null);
          AppMethodBeat.o(339553);
          return localav;
        }
        localObject2 = ah.aiuX;
        b.a((Closeable)localObject1, null);
        AppMethodBeat.o(339553);
        return null;
      }
      finally
      {
        try
        {
          AppMethodBeat.o(339553);
          throw localThrowable;
        }
        finally
        {
          b.a((Closeable)localObject1, localThrowable);
          AppMethodBeat.o(339553);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.logic.f
 * JD-Core Version:    0.7.0.1
 */