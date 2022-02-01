package com.tencent.mm.plugin.fav.model.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.jo;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.mvvm.IMvvmDBProvider;
import com.tencent.mm.storagebase.h;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/fav/model/storage/mvvm/FavDBProvider;", "Lcom/tencent/mm/sdk/storage/mvvm/IMvvmDBProvider;", "()V", "getDB", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "plugin-fav_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements IMvvmDBProvider
{
  public final ISQLiteDatabase getDB()
  {
    AppMethodBeat.i(274358);
    Object localObject = jo.aJS();
    s.s(localObject, "getInstance()");
    localObject = (h)localObject;
    if (((h)localObject).isOpen())
    {
      localObject = (ISQLiteDatabase)localObject;
      AppMethodBeat.o(274358);
      return localObject;
    }
    AppMethodBeat.o(274358);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.model.e.a.a
 * JD-Core Version:    0.7.0.1
 */