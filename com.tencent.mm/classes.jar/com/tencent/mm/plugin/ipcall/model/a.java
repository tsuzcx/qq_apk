package com.tencent.mm.plugin.ipcall.model;

import android.database.Cursor;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.model.h.b;
import com.tencent.mm.plugin.ipcall.model.h.c;
import com.tencent.mm.plugin.ipcall.model.h.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a
{
  private static a JFK = null;
  public ArrayList<a> JFJ;
  private long endTime;
  MMHandler handler;
  private boolean isLoading;
  private long startTime;
  
  private a()
  {
    AppMethodBeat.i(25329);
    this.isLoading = false;
    this.JFJ = new ArrayList();
    this.startTime = -1L;
    this.endTime = -1L;
    this.handler = new MMHandler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(25328);
        long l1 = System.currentTimeMillis();
        Object localObject1 = h.fRw();
        Object localObject2 = (ArrayList)paramAnonymousMessage.obj;
        if ((localObject2 != null) && (((List)localObject2).size() > 0))
        {
          long l2 = ((d)localObject1).beginTransaction(Thread.currentThread().getId());
          Log.i("MicroMsg.IPCallAddressStorage", "getContactIdMap start");
          Object localObject3 = ((d)localObject1).db.query("IPCallAddressItem", new String[] { "contactId" }, null, null, null, null, null, 2);
          paramAnonymousMessage = new HashMap();
          if ((localObject3 != null) && (((Cursor)localObject3).moveToFirst())) {
            do
            {
              String str = ((Cursor)localObject3).getString(0);
              if (!paramAnonymousMessage.containsKey(str)) {
                paramAnonymousMessage.put(str, Boolean.TRUE);
              }
            } while (((Cursor)localObject3).moveToNext());
          }
          if (localObject3 != null) {
            ((Cursor)localObject3).close();
          }
          Log.i("MicroMsg.IPCallAddressStorage", "getContactIdMap end");
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (c)((Iterator)localObject2).next();
            if (!paramAnonymousMessage.containsKey(((c)localObject3).field_contactId)) {
              ((d)localObject1).insert((IAutoDBItem)localObject3);
            }
          }
          ((d)localObject1).sc(l2);
        }
        Log.d("MicroMsg.IPCallAddressBookLoader", "batchInsert, used %dms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
        a.a(a.this, System.currentTimeMillis());
        Log.d("MicroMsg.IPCallAddressBookLoader", "loadAllAddressItem, used: %dms", new Object[] { Long.valueOf(a.a(a.this) - a.b(a.this)) });
        a.c(a.this);
        a.a(a.this, -1L);
        a.d(a.this);
        paramAnonymousMessage = a.this.JFJ.iterator();
        while (paramAnonymousMessage.hasNext())
        {
          localObject1 = (a.a)paramAnonymousMessage.next();
          if (localObject1 != null) {
            ((a.a)localObject1).dVo();
          }
        }
        a.this.JFJ.clear();
        AppMethodBeat.o(25328);
      }
    };
    AppMethodBeat.o(25329);
  }
  
  public static a fRa()
  {
    AppMethodBeat.i(25330);
    if (JFK == null) {
      JFK = new a();
    }
    a locala = JFK;
    AppMethodBeat.o(25330);
    return locala;
  }
  
  public final void a(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(25331);
    if (parama != null) {
      this.JFJ.add(parama);
    }
    if (this.isLoading)
    {
      Log.d("MicroMsg.IPCallAddressBookLoader", "loadAllAddressItem, isLoading is true, ignore");
      AppMethodBeat.o(25331);
      return;
    }
    this.startTime = System.currentTimeMillis();
    if ((b.fRU().size() == 0) || (!paramBoolean))
    {
      Log.d("MicroMsg.IPCallAddressBookLoader", "loadFromSystemAddressBook");
      long l = System.currentTimeMillis();
      new b();
      parama = b.fRT();
      Log.d("MicroMsg.IPCallAddressBookLoader", "getAllAddressItemFromSystemPhoneBook, used %dms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      Message localMessage = this.handler.obtainMessage();
      localMessage.obj = parama;
      this.handler.sendMessage(localMessage);
      this.isLoading = true;
      AppMethodBeat.o(25331);
      return;
    }
    AppMethodBeat.o(25331);
  }
  
  public static abstract interface a
  {
    public abstract void dVo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.a
 * JD-Core Version:    0.7.0.1
 */