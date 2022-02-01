package com.tencent.mm.modelavatar;

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

public final class k
  extends MStorage
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS img_flag ( username VARCHAR(40) PRIMARY KEY , imgflag int , lastupdatetime int , reserved1 text ,reserved2 text ,reserved3 int ,reserved4 int )", "CREATE INDEX IF NOT EXISTS img_flag_small_url_index ON img_flag ( reserved2 )" };
  h omV;
  final f<String, j> osQ;
  
  public k(h paramh)
  {
    AppMethodBeat.i(150287);
    this.osQ = new c(800);
    this.omV = paramh;
    AppMethodBeat.o(150287);
  }
  
  private boolean c(j paramj)
  {
    boolean bool2 = true;
    AppMethodBeat.i(150291);
    if ((paramj != null) && (paramj.getUsername() != null))
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      paramj.osL = ((int)(System.currentTimeMillis() / 1000L));
      paramj.bFy();
      paramj.eQp = -1;
      ContentValues localContentValues = paramj.bFv();
      if ((int)this.omV.insert("img_flag", "username", localContentValues) < 0) {
        break label99;
      }
    }
    label99:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      if (bool1) {
        doNotify(paramj.getUsername(), 2, paramj.getUsername());
      }
      AppMethodBeat.o(150291);
      return bool1;
      bool1 = false;
      break;
    }
  }
  
  private boolean d(j paramj)
  {
    boolean bool2 = true;
    AppMethodBeat.i(150292);
    if ((paramj != null) && (paramj.getUsername() != null))
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      paramj.osL = ((int)(System.currentTimeMillis() / 1000L));
      paramj.eQp |= 0x4;
      ContentValues localContentValues = paramj.bFv();
      if (this.omV.update("img_flag", localContentValues, "username=?", new String[] { paramj.getUsername() }) <= 0) {
        break label123;
      }
    }
    label123:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      if (bool1) {
        doNotify(paramj.getUsername(), 3, paramj.getUsername());
      }
      AppMethodBeat.o(150292);
      return bool1;
      bool1 = false;
      break;
    }
  }
  
  public final j LS(String paramString)
  {
    AppMethodBeat.i(150288);
    Object localObject = (j)this.osQ.ct(paramString);
    if ((localObject != null) && (((j)localObject).getUsername().equals(paramString)))
    {
      AppMethodBeat.o(150288);
      return localObject;
    }
    localObject = "select img_flag.username,img_flag.imgflag,img_flag.lastupdatetime,img_flag.reserved1,img_flag.reserved2,img_flag.reserved3,img_flag.reserved4 from img_flag where img_flag.username=\"" + Util.escapeSqlValue(paramString) + "\"";
    Cursor localCursor = this.omV.rawQuery((String)localObject, null, 2);
    if (localCursor == null)
    {
      AppMethodBeat.o(150288);
      return null;
    }
    if (localCursor.moveToFirst())
    {
      localObject = new j();
      ((j)localObject).convertFrom(localCursor);
    }
    for (;;)
    {
      localCursor.close();
      this.osQ.B(paramString, localObject);
      AppMethodBeat.o(150288);
      return localObject;
      localObject = null;
    }
  }
  
  public final void LT(String paramString)
  {
    AppMethodBeat.i(150293);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150293);
      return;
    }
    this.osQ.remove(paramString);
    this.omV.delete("img_flag", "username=?", new String[] { String.valueOf(paramString) });
    AppMethodBeat.o(150293);
  }
  
  public final boolean b(j paramj)
  {
    AppMethodBeat.i(150289);
    Log.i("MicroMsg.ImgFlagStorage", "new smallImageUrl = %s, bigImageUrl = %s", new Object[] { paramj.bFx(), paramj.bFw() });
    j localj = LS(paramj.getUsername());
    if (localj == null)
    {
      this.osQ.B(paramj.getUsername(), paramj);
      bool = c(paramj);
      AppMethodBeat.o(150289);
      return bool;
    }
    Log.i("MicroMsg.ImgFlagStorage", "old, smallImageUrl = %s, bigImageUrl = %s", new Object[] { localj.bFx(), localj.bFw() });
    this.osQ.remove(paramj.getUsername());
    boolean bool = d(paramj);
    AppMethodBeat.o(150289);
    return bool;
  }
  
  public final boolean bY(List<j> paramList)
  {
    AppMethodBeat.i(150290);
    if (paramList.size() == 0)
    {
      AppMethodBeat.o(150290);
      return false;
    }
    long l = this.omV.beginTransaction(Thread.currentThread().getId());
    int i = 0;
    try
    {
      while (i < paramList.size())
      {
        b((j)paramList.get(i));
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
    this.omV.endTransaction(l);
    AppMethodBeat.o(150290);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelavatar.k
 * JD-Core Version:    0.7.0.1
 */