package com.tencent.mm.kernel.mvvm;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.mvvm.IMvvmDBProvider;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/kernel/mvvm/MainDBProvider;", "Lcom/tencent/mm/sdk/storage/mvvm/IMvvmDBProvider;", "()V", "getDB", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "mmkernel_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements IMvvmDBProvider
{
  public final ISQLiteDatabase getDB()
  {
    AppMethodBeat.i(235274);
    Object localObject = com.tencent.mm.kernel.h.baE().mCN;
    if (((com.tencent.mm.storagebase.h)localObject).isOpen())
    {
      localObject = (ISQLiteDatabase)localObject;
      AppMethodBeat.o(235274);
      return localObject;
    }
    AppMethodBeat.o(235274);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.kernel.mvvm.b
 * JD-Core Version:    0.7.0.1
 */