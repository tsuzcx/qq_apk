package com.tencent.mm.openim.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fx;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.bx;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.f.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/openim/contact/OpenIMKefuContactStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/openim/contact/OpenIMKefuContact;", "storage", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "contactStorage", "Lcom/tencent/mm/storage/IContactStorage;", "clearContactInDB", "", "doNotify", "event", "", "contact", "getContact", "username", "", "getContactByUrl", "kfUrl", "insertContact", "", "replaceContactInDB", "", "updateContact", "Companion", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends MAutoStorage<c>
{
  private static final String[] SQL_CREATE;
  public static final h.a psa;
  final ISQLiteDatabase psb;
  private final bx psc;
  
  static
  {
    AppMethodBeat.i(236057);
    psa = new h.a((byte)0);
    c.a locala = c.prK;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(c.access$getInfo$cp(), "OpenIMKefuContact") };
    AppMethodBeat.o(236057);
  }
  
  public h(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, c.access$getInfo$cp(), "OpenIMKefuContact", fx.INDEX_CREATE);
    AppMethodBeat.i(236048);
    this.psb = paramISQLiteDatabase;
    paramISQLiteDatabase = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA();
    s.s(paramISQLiteDatabase, "service(IMessengerStorage::class.java).contactStg");
    this.psc = paramISQLiteDatabase;
    AppMethodBeat.o(236048);
  }
  
  public static final String[] bSc()
  {
    return SQL_CREATE;
  }
  
  public final c RL(String paramString)
  {
    int i = 1;
    AppMethodBeat.i(236065);
    s.u(paramString, "username");
    paramString = s.X("SELECT *, rowid FROM OpenIMKefuContact WHERE username = ", com.tencent.mm.storagebase.h.EQ(paramString));
    localCloseable = (Closeable)this.psb.rawQuery(paramString, null, 2);
    for (;;)
    {
      try
      {
        localObject1 = (Cursor)localCloseable;
        if ((localObject1 == null) || (((Cursor)localObject1).moveToFirst() != true)) {
          continue;
        }
        if (i == 0) {
          continue;
        }
        paramString = new c();
        paramString.convertFrom((Cursor)localObject1);
        paramString.maN = paramString.systemRowid;
        paramString.clZ = true;
      }
      finally
      {
        try
        {
          Object localObject1;
          AppMethodBeat.o(236065);
          throw paramString;
        }
        finally
        {
          b.a(localCloseable, paramString);
          AppMethodBeat.o(236065);
        }
        paramString = null;
        continue;
      }
      localObject1 = ah.aiuX;
      b.a(localCloseable, null);
      AppMethodBeat.o(236065);
      return paramString;
      i = 0;
    }
  }
  
  public final c RP(String paramString)
  {
    int i = 1;
    AppMethodBeat.i(236071);
    s.u(paramString, "kfUrl");
    paramString = s.X("SELECT *, rowid FROM OpenIMKefuContact WHERE kfUrl = ", com.tencent.mm.storagebase.h.EQ(paramString));
    localCloseable = (Closeable)this.psb.rawQuery(paramString, null, 2);
    for (;;)
    {
      try
      {
        localObject1 = (Cursor)localCloseable;
        if ((localObject1 == null) || (((Cursor)localObject1).moveToFirst() != true)) {
          continue;
        }
        if (i == 0) {
          continue;
        }
        paramString = new c();
        paramString.convertFrom((Cursor)localObject1);
        paramString.maN = paramString.systemRowid;
        paramString.clZ = true;
      }
      finally
      {
        try
        {
          Object localObject1;
          AppMethodBeat.o(236071);
          throw paramString;
        }
        finally
        {
          b.a(localCloseable, paramString);
          AppMethodBeat.o(236071);
        }
        paramString = null;
        continue;
      }
      localObject1 = ah.aiuX;
      b.a(localCloseable, null);
      AppMethodBeat.o(236071);
      return paramString;
      i = 0;
    }
  }
  
  final void a(int paramInt, c paramc)
  {
    AppMethodBeat.i(236075);
    if ((this.psc instanceof MStorageEx))
    {
      bx localbx = this.psc;
      localbx.doNotify(paramInt, (MStorageEx)localbx, paramc.field_username);
    }
    doNotify("", paramInt, paramc.field_username);
    AppMethodBeat.o(236075);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.a.h
 * JD-Core Version:    0.7.0.1
 */