package com.tencent.mm.aj;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.storagebase.h;
import java.util.List;
import junit.framework.Assert;

public final class j
  extends MStorage
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS img_flag ( username VARCHAR(40) PRIMARY KEY , imgflag int , lastupdatetime int , reserved1 text ,reserved2 text ,reserved3 int ,reserved4 int )", "CREATE INDEX IF NOT EXISTS img_flag_small_url_index ON img_flag ( reserved2 )" };
  h iFy;
  final f<String, i> iLa;
  
  public j(h paramh)
  {
    AppMethodBeat.i(150287);
    this.iLa = new c(800);
    this.iFy = paramh;
    AppMethodBeat.o(150287);
  }
  
  private boolean c(i parami)
  {
    boolean bool2 = true;
    AppMethodBeat.i(150291);
    if ((parami != null) && (parami.getUsername() != null))
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      parami.iKV = ((int)(System.currentTimeMillis() / 1000L));
      parami.aYv();
      parami.cSx = -1;
      ContentValues localContentValues = parami.aYq();
      if ((int)this.iFy.insert("img_flag", "username", localContentValues) < 0) {
        break label99;
      }
    }
    label99:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      if (bool1) {
        doNotify(parami.getUsername(), 2, parami.getUsername());
      }
      AppMethodBeat.o(150291);
      return bool1;
      bool1 = false;
      break;
    }
  }
  
  private boolean d(i parami)
  {
    boolean bool2 = true;
    AppMethodBeat.i(150292);
    if ((parami != null) && (parami.getUsername() != null))
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      parami.iKV = ((int)(System.currentTimeMillis() / 1000L));
      parami.cSx |= 0x4;
      ContentValues localContentValues = parami.aYq();
      if (this.iFy.update("img_flag", localContentValues, "username=?", new String[] { parami.getUsername() }) <= 0) {
        break label123;
      }
    }
    label123:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      if (bool1) {
        doNotify(parami.getUsername(), 3, parami.getUsername());
      }
      AppMethodBeat.o(150292);
      return bool1;
      bool1 = false;
      break;
    }
  }
  
  public final i Mx(String paramString)
  {
    AppMethodBeat.i(150288);
    Object localObject = (i)this.iLa.aT(paramString);
    if ((localObject != null) && (((i)localObject).getUsername().equals(paramString)))
    {
      AppMethodBeat.o(150288);
      return localObject;
    }
    localObject = "select img_flag.username,img_flag.imgflag,img_flag.lastupdatetime,img_flag.reserved1,img_flag.reserved2,img_flag.reserved3,img_flag.reserved4 from img_flag where img_flag.username=\"" + Util.escapeSqlValue(paramString) + "\"";
    Cursor localCursor = this.iFy.rawQuery((String)localObject, null, 2);
    if (localCursor == null)
    {
      AppMethodBeat.o(150288);
      return null;
    }
    if (localCursor.moveToFirst())
    {
      localObject = new i();
      ((i)localObject).convertFrom(localCursor);
    }
    for (;;)
    {
      localCursor.close();
      this.iLa.x(paramString, localObject);
      AppMethodBeat.o(150288);
      return localObject;
      localObject = null;
    }
  }
  
  public final void My(String paramString)
  {
    AppMethodBeat.i(150293);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150293);
      return;
    }
    this.iLa.remove(paramString);
    this.iFy.delete("img_flag", "username=?", new String[] { String.valueOf(paramString) });
    AppMethodBeat.o(150293);
  }
  
  public final boolean av(List<i> paramList)
  {
    AppMethodBeat.i(150290);
    if (paramList.size() == 0)
    {
      AppMethodBeat.o(150290);
      return false;
    }
    long l = this.iFy.beginTransaction(Thread.currentThread().getId());
    int i = 0;
    try
    {
      while (i < paramList.size())
      {
        b((i)paramList.get(i));
        i += 1;
      }
      bool = true;
    }
    catch (Exception paramList)
    {
      for (;;)
      {
        Log.e("MicroMsg.ImgFlagStorage", paramList.getMessage());
        boolean bool = false;
      }
    }
    this.iFy.endTransaction(l);
    AppMethodBeat.o(150290);
    return bool;
  }
  
  public final boolean b(i parami)
  {
    AppMethodBeat.i(150289);
    Log.i("MicroMsg.ImgFlagStorage", "new smallImageUrl = %s, bigImageUrl = %s", new Object[] { parami.aYu(), parami.aYt() });
    i locali = Mx(parami.getUsername());
    if (locali == null)
    {
      this.iLa.x(parami.getUsername(), parami);
      bool = c(parami);
      AppMethodBeat.o(150289);
      return bool;
    }
    Log.i("MicroMsg.ImgFlagStorage", "old, smallImageUrl = %s, bigImageUrl = %s", new Object[] { locali.aYu(), locali.aYt() });
    this.iLa.remove(parami.getUsername());
    boolean bool = d(parami);
    AppMethodBeat.o(150289);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aj.j
 * JD-Core Version:    0.7.0.1
 */