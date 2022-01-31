package com.tencent.mm.ah;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;
import junit.framework.Assert;

public final class i
  extends k
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS img_flag ( username VARCHAR(40) PRIMARY KEY , imgflag int , lastupdatetime int , reserved1 text ,reserved2 text ,reserved3 int ,reserved4 int )", "CREATE INDEX IF NOT EXISTS img_flag_small_url_index ON img_flag ( reserved2 )" };
  com.tencent.mm.cg.h fnw;
  final f<String, h> fso;
  
  public i(com.tencent.mm.cg.h paramh)
  {
    AppMethodBeat.i(77923);
    this.fso = new c(800);
    this.fnw = paramh;
    AppMethodBeat.o(77923);
  }
  
  private boolean c(h paramh)
  {
    boolean bool2 = true;
    AppMethodBeat.i(77927);
    if ((paramh != null) && (paramh.getUsername() != null))
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      paramh.fsj = ((int)(System.currentTimeMillis() / 1000L));
      paramh.acZ();
      paramh.bsY = -1;
      ContentValues localContentValues = paramh.acW();
      if ((int)this.fnw.a("img_flag", "username", localContentValues) < 0) {
        break label99;
      }
    }
    label99:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      if (bool1) {
        doNotify(paramh.getUsername(), 2, paramh.getUsername());
      }
      AppMethodBeat.o(77927);
      return bool1;
      bool1 = false;
      break;
    }
  }
  
  private boolean d(h paramh)
  {
    boolean bool2 = true;
    AppMethodBeat.i(77928);
    if ((paramh != null) && (paramh.getUsername() != null))
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      paramh.fsj = ((int)(System.currentTimeMillis() / 1000L));
      paramh.bsY |= 0x4;
      ContentValues localContentValues = paramh.acW();
      if (this.fnw.update("img_flag", localContentValues, "username=?", new String[] { paramh.getUsername() }) <= 0) {
        break label123;
      }
    }
    label123:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      if (bool1) {
        doNotify(paramh.getUsername(), 3, paramh.getUsername());
      }
      AppMethodBeat.o(77928);
      return bool1;
      bool1 = false;
      break;
    }
  }
  
  public final boolean X(List<h> paramList)
  {
    AppMethodBeat.i(77926);
    if (paramList.size() == 0)
    {
      AppMethodBeat.o(77926);
      return false;
    }
    long l = this.fnw.kr(Thread.currentThread().getId());
    int i = 0;
    try
    {
      while (i < paramList.size())
      {
        b((h)paramList.get(i));
        i += 1;
      }
      bool = true;
    }
    catch (Exception paramList)
    {
      for (;;)
      {
        ab.e("MicroMsg.ImgFlagStorage", paramList.getMessage());
        boolean bool = false;
      }
    }
    this.fnw.nY(l);
    AppMethodBeat.o(77926);
    return bool;
  }
  
  public final boolean b(h paramh)
  {
    AppMethodBeat.i(77925);
    ab.i("MicroMsg.ImgFlagStorage", "new smallImageUrl = %s, bigImageUrl = %s", new Object[] { paramh.acY(), paramh.acX() });
    h localh = rj(paramh.getUsername());
    if (localh == null)
    {
      this.fso.f(paramh.getUsername(), paramh);
      bool = c(paramh);
      AppMethodBeat.o(77925);
      return bool;
    }
    ab.i("MicroMsg.ImgFlagStorage", "old, smallImageUrl = %s, bigImageUrl = %s", new Object[] { localh.acY(), localh.acX() });
    this.fso.remove(paramh.getUsername());
    boolean bool = d(paramh);
    AppMethodBeat.o(77925);
    return bool;
  }
  
  public final h rj(String paramString)
  {
    AppMethodBeat.i(77924);
    Object localObject = (h)this.fso.Y(paramString);
    if ((localObject != null) && (((h)localObject).getUsername().equals(paramString)))
    {
      AppMethodBeat.o(77924);
      return localObject;
    }
    localObject = "select img_flag.username,img_flag.imgflag,img_flag.lastupdatetime,img_flag.reserved1,img_flag.reserved2,img_flag.reserved3,img_flag.reserved4 from img_flag where img_flag.username=\"" + bo.wC(paramString) + "\"";
    Cursor localCursor = this.fnw.a((String)localObject, null, 2);
    if (localCursor == null)
    {
      AppMethodBeat.o(77924);
      return null;
    }
    if (localCursor.moveToFirst())
    {
      localObject = new h();
      ((h)localObject).convertFrom(localCursor);
    }
    for (;;)
    {
      localCursor.close();
      this.fso.f(paramString, localObject);
      AppMethodBeat.o(77924);
      return localObject;
      localObject = null;
    }
  }
  
  public final void rk(String paramString)
  {
    AppMethodBeat.i(77929);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(77929);
      return;
    }
    this.fso.remove(paramString);
    this.fnw.delete("img_flag", "username=?", new String[] { String.valueOf(paramString) });
    AppMethodBeat.o(77929);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ah.i
 * JD-Core Version:    0.7.0.1
 */