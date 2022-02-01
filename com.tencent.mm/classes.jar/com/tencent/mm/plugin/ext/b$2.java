package com.tencent.mm.plugin.ext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;

final class b$2
  implements MStorageEx.IOnStorageChange
{
  b$2(b paramb) {}
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(24335);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      Log.d("MicroMsg.SubCoreExt", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramMStorageEx, paramObject });
      AppMethodBeat.o(24335);
      return;
    }
    if (!bg.aAc())
    {
      Log.i("MicroMsg.SubCoreExt", "onNotifyChange acc not ready");
      AppMethodBeat.o(24335);
      return;
    }
    bg.aVF();
    if (paramMStorageEx == c.aSN()) {
      b.d(this.sMt);
    }
    AppMethodBeat.o(24335);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.b.2
 * JD-Core Version:    0.7.0.1
 */