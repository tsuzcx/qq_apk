package com.tencent.mm.plugin.emoji.e;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.m;
import com.tencent.mm.storage.emotion.n;
import java.util.HashMap;

public final class k$1
  implements Runnable
{
  public k$1(k paramk) {}
  
  public final void run()
  {
    AppMethodBeat.i(52976);
    if (this.lgG.lgB)
    {
      Object localObject1 = this.lgG;
      if (i.getEmojiStorageMgr().yNu != null) {
        ((k)localObject1).lgE = i.getEmojiStorageMgr().yNu.dzF();
      }
      k localk = this.lgG;
      Object localObject3 = null;
      localObject1 = null;
      try
      {
        Cursor localCursor = i.getEmojiStorageMgr().yNu.getAll();
        if (localCursor != null)
        {
          localObject1 = localCursor;
          localObject3 = localCursor;
          if (localCursor.moveToFirst())
          {
            boolean bool;
            do
            {
              localObject1 = localCursor;
              localObject3 = localCursor;
              m localm = new m();
              localObject1 = localCursor;
              localObject3 = localCursor;
              localm.convertFrom(localCursor);
              localObject1 = localCursor;
              localObject3 = localCursor;
              localk.lgF.put(localm.field_prodcutID, localm);
              localObject1 = localCursor;
              localObject3 = localCursor;
              bool = localCursor.moveToNext();
            } while (bool);
          }
        }
        return;
      }
      catch (Exception localException)
      {
        localObject3 = localObject1;
        ab.w("MicroMsg.emoji.EmojiRewardTipMgr", bo.l(localException));
        if (localObject1 != null)
        {
          ((Cursor)localObject1).close();
          AppMethodBeat.o(52976);
          return;
        }
      }
      finally
      {
        if (localObject3 != null) {
          localObject3.close();
        }
        AppMethodBeat.o(52976);
      }
    }
    AppMethodBeat.o(52976);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.k.1
 * JD-Core Version:    0.7.0.1
 */