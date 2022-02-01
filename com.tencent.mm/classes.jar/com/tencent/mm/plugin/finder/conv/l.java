package com.tencent.mm.plugin.finder.conv;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.ad;
import com.tencent.mm.plugin.finder.storage.aw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.io.Closeable;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.f.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/conv/FinderNewXmlDataLogic;", "", "()V", "TAG", "", "TYPE_GLOBAL_PUSH", "", "clearAll", "", "type", "clearBeforeTime", "timestamp", "", "insertNewXmlData", "data", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderNewXmlData;", "queryAll", "", "removeById", "localId", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
{
  public static final l AGV;
  
  static
  {
    AppMethodBeat.i(336051);
    AGV = new l();
    AppMethodBeat.o(336051);
  }
  
  public static boolean a(aw paramaw)
  {
    AppMethodBeat.i(336041);
    s.u(paramaw, "data");
    boolean bool = ((PluginFinder)h.az(PluginFinder.class)).getNewXmlStorage().insert((IAutoDBItem)paramaw);
    Log.i("Finder.NewXmlDataLogic", "insertNewXmlData data: " + paramaw + ", success: " + bool);
    AppMethodBeat.o(336041);
    return bool;
  }
  
  public static boolean avk(String paramString)
  {
    AppMethodBeat.i(336024);
    s.u(paramString, "localId");
    ad localad = ((PluginFinder)h.az(PluginFinder.class)).getNewXmlStorage();
    paramString = "DELETE FROM " + localad.getTableName() + " WHERE localId = " + paramString;
    boolean bool = localad.execSQL(localad.getTableName(), paramString);
    Log.i("Finder.NewXmlDataLogic", "removeById sql: " + paramString + ", success: " + bool);
    AppMethodBeat.o(336024);
    return bool;
  }
  
  public static List<aw> dXc()
  {
    AppMethodBeat.i(336010);
    Object localObject1 = ((PluginFinder)h.az(PluginFinder.class)).getNewXmlStorage();
    String str = "SELECT * FROM " + ((ad)localObject1).getTableName() + " WHERE type = 1 ORDER BY createTime ASC";
    Object localObject2 = ((ad)localObject1).rawQuery(str, new String[0]);
    if (localObject2 == null) {
      localObject1 = null;
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new LinkedList();
      }
      Log.i("Finder.NewXmlDataLogic", "queryAll sql: " + str + ", size: " + ((LinkedList)localObject2).size());
      localObject1 = (List)localObject2;
      AppMethodBeat.o(336010);
      return localObject1;
      localObject1 = new LinkedList();
      localObject2 = (Closeable)localObject2;
      try
      {
        Object localObject4 = (Cursor)localObject2;
        while (((Cursor)localObject4).moveToNext())
        {
          IAutoDBItem localIAutoDBItem = (IAutoDBItem)aw.class.newInstance();
          localIAutoDBItem.convertFrom((Cursor)localObject4);
          ((LinkedList)localObject1).add(localIAutoDBItem);
        }
      }
      finally
      {
        try
        {
          AppMethodBeat.o(336010);
          throw localThrowable;
        }
        finally
        {
          b.a((Closeable)localObject2, localThrowable);
          AppMethodBeat.o(336010);
        }
        localObject4 = ah.aiuX;
        b.a((Closeable)localObject2, null);
      }
    }
  }
  
  public static boolean dXd()
  {
    AppMethodBeat.i(336032);
    ad localad = ((PluginFinder)h.az(PluginFinder.class)).getNewXmlStorage();
    String str = "DELETE FROM " + localad.getTableName() + " WHERE type = 1";
    boolean bool = localad.execSQL(localad.getTableName(), str);
    Log.i("Finder.NewXmlDataLogic", "clearAll sql: " + str + ", success: " + bool);
    AppMethodBeat.o(336032);
    return bool;
  }
  
  public static boolean mT(long paramLong)
  {
    AppMethodBeat.i(336017);
    ad localad = ((PluginFinder)h.az(PluginFinder.class)).getNewXmlStorage();
    String str = "DELETE FROM " + localad.getTableName() + " WHERE type = 1 AND createTime < " + paramLong;
    boolean bool = localad.execSQL(localad.getTableName(), str);
    Log.i("Finder.NewXmlDataLogic", "clearBeforeTime sql: " + str + ", success: " + bool);
    AppMethodBeat.o(336017);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.conv.l
 * JD-Core Version:    0.7.0.1
 */