package com.tencent.mm.ag;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.a.f;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;
import junit.framework.Assert;

public final class i
  extends j
{
  public static final String[] dXp = { "CREATE TABLE IF NOT EXISTS img_flag ( username VARCHAR(40) PRIMARY KEY , imgflag int , lastupdatetime int , reserved1 text ,reserved2 text ,reserved3 int ,reserved4 int )", "CREATE INDEX IF NOT EXISTS img_flag_small_url_index ON img_flag ( reserved2 )" };
  com.tencent.mm.cf.h dXo;
  final f<String, h> ebW = new f(800);
  
  public i(com.tencent.mm.cf.h paramh)
  {
    this.dXo = paramh;
  }
  
  public final boolean Q(List<h> paramList)
  {
    if (paramList.size() == 0) {
      return false;
    }
    long l = this.dXo.eV(Thread.currentThread().getId());
    int i = 0;
    try
    {
      while (i < paramList.size())
      {
        a((h)paramList.get(i));
        i += 1;
      }
      bool = true;
    }
    catch (Exception paramList)
    {
      for (;;)
      {
        y.e("MicroMsg.ImgFlagStorage", paramList.getMessage());
        boolean bool = false;
      }
    }
    this.dXo.hI(l);
    return bool;
  }
  
  public final boolean a(h paramh)
  {
    y.i("MicroMsg.ImgFlagStorage", "new smallImageUrl = %s, bigImageUrl = %s", new Object[] { paramh.JY(), paramh.JX() });
    Object localObject = kp(paramh.getUsername());
    boolean bool2;
    if (localObject == null)
    {
      this.ebW.f(paramh.getUsername(), paramh);
      if ((paramh != null) && (paramh.getUsername() != null))
      {
        bool1 = true;
        Assert.assertTrue(bool1);
        paramh.ebR = ((int)(System.currentTimeMillis() / 1000L));
        paramh.JZ();
        paramh.bcw = -1;
        localObject = paramh.JW();
        if ((int)this.dXo.insert("img_flag", "username", (ContentValues)localObject) < 0) {
          break label143;
        }
      }
      label143:
      for (bool1 = true;; bool1 = false)
      {
        bool2 = bool1;
        if (bool1)
        {
          b(paramh.getUsername(), 2, paramh.getUsername());
          bool2 = bool1;
        }
        return bool2;
        bool1 = false;
        break;
      }
    }
    y.i("MicroMsg.ImgFlagStorage", "old, smallImageUrl = %s, bigImageUrl = %s", new Object[] { ((h)localObject).JY(), ((h)localObject).JX() });
    this.ebW.remove(paramh.getUsername());
    if ((paramh != null) && (paramh.getUsername() != null))
    {
      bool1 = true;
      label200:
      Assert.assertTrue(bool1);
      paramh.ebR = ((int)(System.currentTimeMillis() / 1000L));
      paramh.bcw |= 0x4;
      localObject = paramh.JW();
      if (this.dXo.update("img_flag", (ContentValues)localObject, "username=?", new String[] { paramh.getUsername() }) <= 0) {
        break label300;
      }
    }
    label300:
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      b(paramh.getUsername(), 3, paramh.getUsername());
      return bool1;
      bool1 = false;
      break label200;
    }
  }
  
  public final h kp(String paramString)
  {
    Object localObject = (h)this.ebW.get(paramString);
    if ((localObject != null) && (((h)localObject).getUsername().equals(paramString))) {
      return localObject;
    }
    localObject = "select img_flag.username,img_flag.imgflag,img_flag.lastupdatetime,img_flag.reserved1,img_flag.reserved2,img_flag.reserved3,img_flag.reserved4 from img_flag where img_flag.username=\"" + bk.pl(paramString) + "\"";
    Cursor localCursor = this.dXo.a((String)localObject, null, 2);
    if (localCursor == null) {
      return null;
    }
    if (localCursor.moveToFirst())
    {
      localObject = new h();
      ((h)localObject).d(localCursor);
    }
    for (;;)
    {
      localCursor.close();
      this.ebW.f(paramString, localObject);
      return localObject;
      localObject = null;
    }
  }
  
  public final void kq(String paramString)
  {
    if (bk.bl(paramString)) {
      return;
    }
    this.ebW.remove(paramString);
    this.dXo.delete("img_flag", "username=?", new String[] { paramString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ag.i
 * JD-Core Version:    0.7.0.1
 */