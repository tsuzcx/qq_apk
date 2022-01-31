package com.tencent.mm.plugin.downloader_app.b;

import android.database.Cursor;
import com.tencent.mm.plugin.downloader_app.c.a;
import com.tencent.mm.plugin.downloader_app.c.b;
import com.tencent.mm.plugin.downloader_app.c.c;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;

public final class k
{
  private static LinkedList<String> iSu = new LinkedList();
  private static LinkedList<String> iSv = new LinkedList();
  private static d.d iSw;
  
  public static int Ae(String paramString)
  {
    if (iSv.contains(paramString)) {
      return l.iSx;
    }
    return l.UN_INSTALLED;
  }
  
  public static void Af(String paramString)
  {
    if (!contains(paramString))
    {
      iSu.addFirst(paramString);
      if (b.aGs() != null)
      {
        a locala = new a();
        locala.field_appId = paramString;
        locala.field_modifyTime = System.currentTimeMillis();
        b.aGs().b(locala);
      }
    }
  }
  
  public static boolean aGb()
  {
    return iSu.size() > 0;
  }
  
  public static void aGq()
  {
    Object localObject1 = null;
    if (b.aGs() == null)
    {
      if (localObject1 != null) {
        localObject1 = ((LinkedList)localObject1).iterator();
      }
    }
    else {
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label210;
        }
        Object localObject2 = (a)((Iterator)localObject1).next();
        y.d("MicroMsg.TaskManager", "initFromDB, appId:%s, status:%d", new Object[] { ((a)localObject2).field_appId, Integer.valueOf(((a)localObject2).field_status) });
        if (((a)localObject2).field_status == l.iSx)
        {
          if (iSv.contains(((a)localObject2).field_appId)) {
            continue;
          }
          iSv.add(((a)localObject2).field_appId);
          continue;
          localObject2 = b.aGs().rawQuery(String.format("select * from %s order by %s desc", new Object[] { "DownloadTaskItem", "modifyTime" }), new String[0]);
          if (localObject2 == null) {
            break;
          }
          localObject1 = new LinkedList();
          while (((Cursor)localObject2).moveToNext())
          {
            a locala = new a();
            locala.d((Cursor)localObject2);
            ((LinkedList)localObject1).add(locala);
          }
          ((Cursor)localObject2).close();
          break;
        }
        if (!iSu.contains(((a)localObject2).field_appId)) {
          iSu.add(((a)localObject2).field_appId);
        }
      }
    }
    label210:
    if (iSw == null) {
      iSw = new k.1();
    }
    d.a(iSw);
  }
  
  public static LinkedList<String> aGr()
  {
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll(iSu);
    localLinkedList.addAll(iSv);
    return localLinkedList;
  }
  
  public static void close()
  {
    
    if (b.aGs() != null) {
      b.aGs().gk("DownloadTaskItem", String.format("delete from %s", new Object[] { "DownloadTaskItem" }));
    }
  }
  
  public static boolean contains(String paramString)
  {
    return (iSv.contains(paramString)) || (iSu.contains(paramString));
  }
  
  public static void stop()
  {
    iSu.clear();
    iSv.clear();
    if (iSw != null) {
      d.b(iSw);
    }
    iSw = null;
  }
  
  public static void vo(String paramString)
  {
    iSv.remove(paramString);
    iSu.remove(paramString);
    if (b.aGs() != null) {
      b.aGs().gk("DownloadTaskItem", String.format("delete from %s where %s=\"%s\"", new Object[] { "DownloadTaskItem", "appId", paramString }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.b.k
 * JD-Core Version:    0.7.0.1
 */