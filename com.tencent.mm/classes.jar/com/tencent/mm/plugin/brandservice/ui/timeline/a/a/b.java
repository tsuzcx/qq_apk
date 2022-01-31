package com.tencent.mm.plugin.brandservice.ui.timeline.a.a;

import com.tencent.mm.plugin.brandservice.c;
import com.tencent.mm.protocal.c.do;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class b
  implements e
{
  private ab<String, a> iil = new ab(20);
  
  public final void a(String paramString, do paramdo)
  {
    y.i("MicroMsg.Preload.BizAppMsgContextCache", "save url:%s", new Object[] { paramString });
    if (paramdo == null)
    {
      y.e("MicroMsg.Preload.BizAppMsgContextCache", "save fail, appMsgContext is null");
      return;
    }
    this.iil.remove(paramString);
    d locald = c.axo();
    if (locald != null)
    {
      String str1 = paramdo.kVs;
      boolean bool1 = paramdo.sxa;
      int i = paramdo.swX;
      String str2 = paramdo.swY;
      int j = paramdo.swZ;
      paramdo = new a();
      paramdo.field_appMsgContextId = paramString.hashCode();
      boolean bool2 = locald.b(paramdo, new String[0]);
      paramdo.field_url = paramString;
      if ((!bool1) && (!bk.bl(str1)))
      {
        paramdo.field_content = str1;
        paramdo.field_lastModifyTime = j;
      }
      long l = System.currentTimeMillis();
      paramdo.field_invalidTime = (i * 1000 + l);
      paramdo.field_forceUrl = str2;
      y.v("MicroMsg.Preload.BizAppMsgContextStorage", "[insertOrUpdate]bizAppMsgContext:%s", new Object[] { paramdo });
      if (bool2)
      {
        locald.c(paramdo, new String[0]);
        return;
      }
      locald.b(paramdo);
      return;
    }
    y.e("MicroMsg.Preload.BizAppMsgContextCache", "bizAppMsgContextStorage is null, why?");
  }
  
  public final boolean bk(String paramString, int paramInt)
  {
    a locala2 = (a)this.iil.get(paramString);
    a locala1 = locala2;
    if (locala2 == null)
    {
      d locald = c.axo();
      locala1 = locala2;
      if (locald != null) {
        locala1 = locald.xU(paramString);
      }
    }
    if (locala1 == null) {
      return false;
    }
    if (locala1.field_invalidTime < System.currentTimeMillis()) {
      return false;
    }
    return (locala1.field_tmplVersion == 0) || (locala1.field_tmplVersion >= paramInt);
  }
  
  public final a xU(String paramString)
  {
    y.i("MicroMsg.Preload.BizAppMsgContextCache", "get url:%s", new Object[] { paramString });
    a locala2 = (a)this.iil.get(paramString);
    a locala1 = locala2;
    if (locala2 == null)
    {
      d locald = c.axo();
      locala1 = locala2;
      if (locald != null) {
        locala1 = locald.xU(paramString);
      }
    }
    if (locala1 != null)
    {
      y.v("MicroMsg.Preload.BizAppMsgContextCache", "appMsgContext:%s", new Object[] { locala1 });
      this.iil.put(paramString, locala1);
      return locala1;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.a.b
 * JD-Core Version:    0.7.0.1
 */