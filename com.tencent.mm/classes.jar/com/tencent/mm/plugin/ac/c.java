package com.tencent.mm.plugin.ac;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.mvvm.IMvvmDBProvider;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mvvmstorage/DBProviderBuilder;", "Lcom/tencent/mm/sdk/storage/mvvm/IMvvmDBProvider;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "getDB", "plugin-mvvmstorage_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements IMvvmDBProvider
{
  private final ISQLiteDatabase db;
  
  public c(ISQLiteDatabase paramISQLiteDatabase)
  {
    AppMethodBeat.i(262727);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(262727);
  }
  
  public final ISQLiteDatabase getDB()
  {
    AppMethodBeat.i(262731);
    if (this.db.isClose())
    {
      AppMethodBeat.o(262731);
      return null;
    }
    ISQLiteDatabase localISQLiteDatabase = this.db;
    AppMethodBeat.o(262731);
    return localISQLiteDatabase;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ac.c
 * JD-Core Version:    0.7.0.1
 */