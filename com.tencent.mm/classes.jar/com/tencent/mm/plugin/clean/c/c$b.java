package com.tencent.mm.plugin.clean.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.clean.c.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.e;

final class c$b
  extends a
{
  private String filePath;
  private long fileSize;
  int kGQ = 0;
  
  public c$b(c paramc, String paramString)
  {
    super(paramc);
    this.filePath = paramString;
    this.fileSize = 0L;
  }
  
  private void Jg(String paramString)
  {
    AppMethodBeat.i(18674);
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
          Jg(paramString + "/" + str);
          i += 1;
        }
      }
      ab.v("MicroMsg.CleanController", "delete file rootFile: %s", new Object[] { paramString });
      localb.delete();
      AppMethodBeat.o(18674);
      return;
    }
    ab.v("MicroMsg.CleanController", "delete file rootFile: %s", new Object[] { paramString });
    c.c(this.kGP, c.a(this.kGP) + localb.length());
    localb.delete();
    AppMethodBeat.o(18674);
  }
  
  private static boolean Jh(String paramString)
  {
    AppMethodBeat.i(18675);
    if ((paramString.length() > c.access$1600()) && (paramString.substring(c.access$1600()).indexOf("temp") == 0))
    {
      AppMethodBeat.o(18675);
      return true;
    }
    AppMethodBeat.o(18675);
    return false;
  }
  
  private void Ji(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(18676);
    this.kGQ += 1;
    if (paramString.endsWith("/sns"))
    {
      ab.i("MicroMsg.CleanController", "Scan sns folder: rootPath=%s", new Object[] { paramString });
      Jj(paramString);
      AppMethodBeat.o(18676);
      return;
    }
    if (paramString.endsWith("/music"))
    {
      ab.i("MicroMsg.CleanController", "Scan music folder: rootPath=%s", new Object[] { paramString });
      Jk(paramString);
      AppMethodBeat.o(18676);
      return;
    }
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
          Ji(paramString + "/" + str);
          i += 1;
        }
      }
      AppMethodBeat.o(18676);
      return;
    }
    long l = e.avI(paramString);
    c.d(this.kGP, l);
    this.fileSize = (l + this.fileSize);
    AppMethodBeat.o(18676);
  }
  
  private void Jj(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(18677);
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
          Jj(paramString + "/" + str);
          i += 1;
        }
      }
      AppMethodBeat.o(18677);
      return;
    }
    if ((System.currentTimeMillis() - ((b)localObject).lastModified() > c.bgM().longValue()) && (c.k(this.kGP)))
    {
      ab.v("MicroMsg.CleanController", "Clean 7 days file in sns rootPath=%s", new Object[] { paramString });
      ((b)localObject).delete();
      AppMethodBeat.o(18677);
      return;
    }
    long l = e.avI(paramString);
    c.d(this.kGP, l);
    this.fileSize = (l + this.fileSize);
    AppMethodBeat.o(18677);
  }
  
  private void Jk(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(18678);
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
          Jk(paramString + "/" + str);
          i += 1;
        }
      }
      AppMethodBeat.o(18678);
      return;
    }
    if ((System.currentTimeMillis() - ((b)localObject).lastModified() > c.bgN().longValue()) && (c.k(this.kGP)))
    {
      ab.v("MicroMsg.CleanController", "Clean 90 days file in music rootPath=%s", new Object[] { paramString });
      ((b)localObject).delete();
      AppMethodBeat.o(18678);
      return;
    }
    long l = e.avI(paramString);
    c.d(this.kGP, l);
    this.fileSize = (l + this.fileSize);
    AppMethodBeat.o(18678);
  }
  
  public final String alu()
  {
    AppMethodBeat.i(18672);
    String str = "filePath[" + this.filePath + "] scanCount[" + this.kGQ + "]" + super.alu();
    AppMethodBeat.o(18672);
    return str;
  }
  
  public final void execute()
  {
    AppMethodBeat.i(18673);
    Object localObject;
    if ((Jh(this.filePath)) && (c.k(this.kGP)))
    {
      ab.i("MicroMsg.CleanController", "Delete[%b] temp folder: %s ", new Object[] { Boolean.valueOf(c.k(this.kGP)), this.filePath });
      Jg(this.filePath);
      localObject = new b(this.filePath).dQI();
      if ((((b)localObject).list() == null) || (((b)localObject).list().length == 0)) {
        ((b)localObject).delete();
      }
      if (!c.a(this.kGP, this.filePath)) {
        break label422;
      }
      c.a(this.kGP, c.d(this.kGP) + this.fileSize);
      label134:
      if (!Jh(this.filePath)) {
        break label464;
      }
      localObject = c.l(this.kGP);
      localObject[1] = ((int)(localObject[1] + this.fileSize));
    }
    for (;;)
    {
      if (this.filePath.endsWith("/image2"))
      {
        localObject = c.l(this.kGP);
        localObject[3] = ((int)(localObject[3] + this.fileSize));
      }
      if (this.filePath.endsWith("/image"))
      {
        localObject = c.l(this.kGP);
        localObject[4] = ((int)(localObject[4] + this.fileSize));
      }
      if (this.filePath.endsWith("/video"))
      {
        localObject = c.l(this.kGP);
        localObject[5] = ((int)(localObject[5] + this.fileSize));
      }
      if (this.filePath.endsWith("/voice2"))
      {
        localObject = c.l(this.kGP);
        localObject[6] = ((int)(localObject[6] + this.fileSize));
      }
      if (this.filePath.endsWith("/WeiXin"))
      {
        localObject = c.l(this.kGP);
        localObject[7] = ((int)(localObject[7] + this.fileSize));
      }
      if (this.filePath.endsWith("/WeChat"))
      {
        localObject = c.l(this.kGP);
        localObject[8] = ((int)(localObject[8] + this.fileSize));
      }
      if (this.filePath.endsWith("/xlog"))
      {
        localObject = c.l(this.kGP);
        localObject[9] = ((int)(localObject[9] + this.fileSize));
      }
      AppMethodBeat.o(18673);
      return;
      Ji(this.filePath);
      break;
      label422:
      localObject = this.filePath;
      aw.aaz();
      if (!((String)localObject).startsWith(com.tencent.mm.model.c.getAccPath())) {
        break label134;
      }
      c.b(this.kGP, c.c(this.kGP) + this.fileSize);
      break label134;
      label464:
      localObject = this.filePath;
      aw.aaz();
      if (((String)localObject).startsWith(com.tencent.mm.model.c.getAccPath()))
      {
        localObject = c.l(this.kGP);
        localObject[0] = ((int)(localObject[0] + this.fileSize));
      }
      else
      {
        localObject = c.l(this.kGP);
        localObject[2] = ((int)(localObject[2] + this.fileSize));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.c.c.b
 * JD-Core Version:    0.7.0.1
 */