package com.tencent.mm.plugin.clean.c;

import com.tencent.mm.model.au;
import com.tencent.mm.plugin.clean.c.a.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.e;

final class c$b
  extends a
{
  private String filePath;
  private long fileSize;
  int iBJ = 0;
  
  public c$b(c paramc, String paramString)
  {
    super(paramc);
    this.filePath = paramString;
    this.fileSize = 0L;
  }
  
  private void deleteFile(String paramString)
  {
    b localb = new b(paramString);
    if (localb.isDirectory())
    {
      String[] arrayOfString = localb.list();
      if (arrayOfString != null)
      {
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str = arrayOfString[i];
          deleteFile(paramString + "/" + str);
          i += 1;
        }
      }
      y.v("MicroMsg.CleanController", "delete file rootFile: %s", new Object[] { paramString });
      localb.delete();
      return;
    }
    y.v("MicroMsg.CleanController", "delete file rootFile: %s", new Object[] { paramString });
    c.c(this.iBI, c.a(this.iBI) + localb.length());
    localb.delete();
  }
  
  private static boolean zq(String paramString)
  {
    return (paramString.length() > c.aDL()) && (paramString.substring(c.aDL()).indexOf("temp") == 0);
  }
  
  private void zr(String paramString)
  {
    int i = 0;
    this.iBJ += 1;
    if (paramString.endsWith("/sns"))
    {
      y.i("MicroMsg.CleanController", "Scan sns folder: rootPath=%s", new Object[] { paramString });
      zs(paramString);
    }
    for (;;)
    {
      return;
      if (paramString.endsWith("/music"))
      {
        y.i("MicroMsg.CleanController", "Scan music folder: rootPath=%s", new Object[] { paramString });
        zt(paramString);
        return;
      }
      Object localObject = new b(paramString);
      if (!((b)localObject).isDirectory()) {
        break;
      }
      localObject = ((b)localObject).list();
      if (localObject != null)
      {
        int j = localObject.length;
        while (i < j)
        {
          String str = localObject[i];
          zr(paramString + "/" + str);
          i += 1;
        }
      }
    }
    long l = e.aeQ(paramString);
    c.d(this.iBI, l);
    this.fileSize = (l + this.fileSize);
  }
  
  private void zs(String paramString)
  {
    int i = 0;
    Object localObject = new b(paramString);
    if (((b)localObject).isDirectory())
    {
      localObject = ((b)localObject).list();
      if (localObject != null)
      {
        int j = localObject.length;
        while (i < j)
        {
          String str = localObject[i];
          zs(paramString + "/" + str);
          i += 1;
        }
      }
    }
    else
    {
      if ((System.currentTimeMillis() - ((b)localObject).lastModified() <= c.aDM().longValue()) || (!c.k(this.iBI))) {
        break label133;
      }
      y.v("MicroMsg.CleanController", "Clean 7 days file in sns rootPath=%s", new Object[] { paramString });
      ((b)localObject).delete();
    }
    return;
    label133:
    long l = e.aeQ(paramString);
    c.d(this.iBI, l);
    this.fileSize = (l + this.fileSize);
  }
  
  private void zt(String paramString)
  {
    int i = 0;
    Object localObject = new b(paramString);
    if (((b)localObject).isDirectory())
    {
      localObject = ((b)localObject).list();
      if (localObject != null)
      {
        int j = localObject.length;
        while (i < j)
        {
          String str = localObject[i];
          zt(paramString + "/" + str);
          i += 1;
        }
      }
    }
    else
    {
      if ((System.currentTimeMillis() - ((b)localObject).lastModified() <= c.aDN().longValue()) || (!c.k(this.iBI))) {
        break label133;
      }
      y.v("MicroMsg.CleanController", "Clean 90 days file in music rootPath=%s", new Object[] { paramString });
      ((b)localObject).delete();
    }
    return;
    label133:
    long l = e.aeQ(paramString);
    c.d(this.iBI, l);
    this.fileSize = (l + this.fileSize);
  }
  
  public final String Sj()
  {
    return "filePath[" + this.filePath + "] scanCount[" + this.iBJ + "]" + super.Sj();
  }
  
  public final void execute()
  {
    Object localObject;
    if ((zq(this.filePath)) && (c.k(this.iBI)))
    {
      y.i("MicroMsg.CleanController", "Delete[%b] temp folder: %s ", new Object[] { Boolean.valueOf(c.k(this.iBI)), this.filePath });
      deleteFile(this.filePath);
      localObject = new b(this.filePath).cLq();
      if ((((b)localObject).list() == null) || (((b)localObject).list().length == 0)) {
        ((b)localObject).delete();
      }
      if (!c.a(this.iBI, this.filePath)) {
        break label410;
      }
      c.a(this.iBI, c.d(this.iBI) + this.fileSize);
      label128:
      if (!zq(this.filePath)) {
        break label452;
      }
      localObject = c.l(this.iBI);
      localObject[1] = ((int)(localObject[1] + this.fileSize));
    }
    for (;;)
    {
      if (this.filePath.endsWith("/image2"))
      {
        localObject = c.l(this.iBI);
        localObject[3] = ((int)(localObject[3] + this.fileSize));
      }
      if (this.filePath.endsWith("/image"))
      {
        localObject = c.l(this.iBI);
        localObject[4] = ((int)(localObject[4] + this.fileSize));
      }
      if (this.filePath.endsWith("/video"))
      {
        localObject = c.l(this.iBI);
        localObject[5] = ((int)(localObject[5] + this.fileSize));
      }
      if (this.filePath.endsWith("/voice2"))
      {
        localObject = c.l(this.iBI);
        localObject[6] = ((int)(localObject[6] + this.fileSize));
      }
      if (this.filePath.endsWith("/WeiXin"))
      {
        localObject = c.l(this.iBI);
        localObject[7] = ((int)(localObject[7] + this.fileSize));
      }
      if (this.filePath.endsWith("/WeChat"))
      {
        localObject = c.l(this.iBI);
        localObject[8] = ((int)(localObject[8] + this.fileSize));
      }
      if (this.filePath.endsWith("/xlog"))
      {
        localObject = c.l(this.iBI);
        localObject[9] = ((int)(localObject[9] + this.fileSize));
      }
      return;
      zr(this.filePath);
      break;
      label410:
      localObject = this.filePath;
      au.Hx();
      if (!((String)localObject).startsWith(com.tencent.mm.model.c.FU())) {
        break label128;
      }
      c.b(this.iBI, c.c(this.iBI) + this.fileSize);
      break label128;
      label452:
      localObject = this.filePath;
      au.Hx();
      if (((String)localObject).startsWith(com.tencent.mm.model.c.FU()))
      {
        localObject = c.l(this.iBI);
        localObject[0] = ((int)(localObject[0] + this.fileSize));
      }
      else
      {
        localObject = c.l(this.iBI);
        localObject[2] = ((int)(localObject[2] + this.fileSize));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.c.c.b
 * JD-Core Version:    0.7.0.1
 */