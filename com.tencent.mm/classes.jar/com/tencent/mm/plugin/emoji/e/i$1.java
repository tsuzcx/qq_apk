package com.tencent.mm.plugin.emoji.e;

import android.database.Cursor;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.m;
import com.tencent.mm.storage.emotion.n;
import java.util.HashMap;

public final class i$1
  implements Runnable
{
  public i$1(i parami) {}
  
  public final void run()
  {
    Object localObject1;
    i locali;
    Object localObject3;
    if (this.iXt.iXo)
    {
      localObject1 = this.iXt;
      if (com.tencent.mm.plugin.emoji.model.i.getEmojiStorageMgr().uBi != null) {
        ((i)localObject1).iXr = com.tencent.mm.plugin.emoji.model.i.getEmojiStorageMgr().uBi.cwU();
      }
      locali = this.iXt;
      localObject3 = null;
      localObject1 = null;
    }
    try
    {
      Cursor localCursor = com.tencent.mm.plugin.emoji.model.i.getEmojiStorageMgr().uBi.aAn();
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
            localm.d(localCursor);
            localObject1 = localCursor;
            localObject3 = localCursor;
            locali.iXs.put(localm.field_prodcutID, localm);
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
      do
      {
        localObject3 = localObject1;
        y.w("MicroMsg.emoji.EmojiRewardTipMgr", bk.j(localException));
      } while (localObject1 == null);
      ((Cursor)localObject1).close();
      return;
    }
    finally
    {
      if (localObject3 != null) {
        localObject3.close();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.i.1
 * JD-Core Version:    0.7.0.1
 */