package com.tencent.mm.plugin.downloader_app.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader_app.d.a;
import com.tencent.mm.plugin.downloader_app.d.b;
import com.tencent.mm.plugin.downloader_app.d.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.LinkedList;

public final class j
{
  private static LinkedList<String> lbe;
  private static LinkedList<String> lbf;
  private static d.d lbg;
  
  static
  {
    AppMethodBeat.i(136159);
    lbe = new LinkedList();
    lbf = new LinkedList();
    AppMethodBeat.o(136159);
  }
  
  public static void JP(String paramString)
  {
    AppMethodBeat.i(136154);
    if (!contains(paramString))
    {
      lbe.addFirst(paramString);
      if (b.bjW() != null)
      {
        a locala = new a();
        locala.field_appId = paramString;
        locala.field_modifyTime = System.currentTimeMillis();
        b.bjW().insert(locala);
      }
    }
    AppMethodBeat.o(136154);
  }
  
  public static int Kc(String paramString)
  {
    AppMethodBeat.i(136152);
    if (lbf.contains(paramString))
    {
      i = k.lbh;
      AppMethodBeat.o(136152);
      return i;
    }
    int i = k.UN_INSTALLED;
    AppMethodBeat.o(136152);
    return i;
  }
  
  public static boolean bjD()
  {
    AppMethodBeat.i(136156);
    if (lbe.size() > 0)
    {
      AppMethodBeat.o(136156);
      return true;
    }
    AppMethodBeat.o(136156);
    return false;
  }
  
  public static void bjT()
  {
    Object localObject1 = null;
    AppMethodBeat.i(136148);
    if (b.bjW() == null)
    {
      if (localObject1 != null) {
        localObject1 = ((LinkedList)localObject1).iterator();
      }
    }
    else {
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label215;
        }
        Object localObject2 = (a)((Iterator)localObject1).next();
        ab.d("MicroMsg.TaskManager", "initFromDB, appId:%s, status:%d", new Object[] { ((a)localObject2).field_appId, Integer.valueOf(((a)localObject2).field_status) });
        if (((a)localObject2).field_status == k.lbh)
        {
          if (lbf.contains(((a)localObject2).field_appId)) {
            continue;
          }
          lbf.add(((a)localObject2).field_appId);
          continue;
          localObject2 = b.bjW().rawQuery(String.format("select * from %s order by %s desc", new Object[] { "DownloadTaskItem", "modifyTime" }), new String[0]);
          if (localObject2 == null) {
            break;
          }
          localObject1 = new LinkedList();
          while (((Cursor)localObject2).moveToNext())
          {
            a locala = new a();
            locala.convertFrom((Cursor)localObject2);
            ((LinkedList)localObject1).add(locala);
          }
          ((Cursor)localObject2).close();
          break;
        }
        if (!lbe.contains(((a)localObject2).field_appId)) {
          lbe.add(((a)localObject2).field_appId);
        }
      }
    }
    label215:
    if (lbg == null) {
      lbg = new j.1();
    }
    d.a(lbg);
    AppMethodBeat.o(136148);
  }
  
  public static LinkedList<String> bjU()
  {
    AppMethodBeat.i(136150);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll(lbe);
    localLinkedList.addAll(lbf);
    AppMethodBeat.o(136150);
    return localLinkedList;
  }
  
  public static LinkedList<String> bjV()
  {
    AppMethodBeat.i(136151);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll(lbe);
    AppMethodBeat.o(136151);
    return localLinkedList;
  }
  
  public static boolean contains(String paramString)
  {
    AppMethodBeat.i(136153);
    if ((lbf.contains(paramString)) || (lbe.contains(paramString)))
    {
      AppMethodBeat.o(136153);
      return true;
    }
    AppMethodBeat.o(136153);
    return false;
  }
  
  public static void lI(String paramString)
  {
    AppMethodBeat.i(136155);
    lbf.remove(paramString);
    lbe.remove(paramString);
    if (b.bjW() != null) {
      b.bjW().execSQL("DownloadTaskItem", String.format("delete from %s where %s=\"%s\"", new Object[] { "DownloadTaskItem", "appId", paramString }));
    }
    AppMethodBeat.o(136155);
  }
  
  public static void stop()
  {
    AppMethodBeat.i(136149);
    lbe.clear();
    lbf.clear();
    if (lbg != null) {
      d.b(lbg);
    }
    lbg = null;
    AppMethodBeat.o(136149);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.b.j
 * JD-Core Version:    0.7.0.1
 */