package com.tencent.mm.plugin.choosemsgfile.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.av.d;
import com.tencent.mm.av.d.a;
import com.tencent.mm.av.e;
import com.tencent.mm.av.o;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.choosemsgfile.compat.b.a;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.vfs.i;

public final class f
  extends c
{
  private e ooE;
  private bo ooz;
  
  public f(com.tencent.mm.plugin.choosemsgfile.b.b.a parama, a parama1, com.tencent.mm.vending.e.b paramb)
  {
    super(parama, parama1, paramb);
  }
  
  private void VS(String paramString)
  {
    AppMethodBeat.i(123250);
    MsgFile localMsgFile = new MsgFile();
    localMsgFile.fileSize = ((int)i.aSp(paramString));
    localMsgFile.filePath = paramString;
    localMsgFile.fileName = this.ooE.hGM;
    localMsgFile.type = "image";
    localMsgFile.fBR = com.tencent.mm.plugin.choosemsgfile.b.d.c.VW(localMsgFile.fileName);
    localMsgFile.timeStamp = this.ooE.hGU;
    b(localMsgFile);
    AppMethodBeat.o(123250);
  }
  
  private void a(com.tencent.mm.plugin.choosemsgfile.b.b.b paramb)
  {
    AppMethodBeat.i(123249);
    MsgFile localMsgFile = new MsgFile();
    localMsgFile.fileSize = paramb.bUJ();
    localMsgFile.filePath = ((com.tencent.mm.choosemsgfile.compat.b)g.ab(com.tencent.mm.choosemsgfile.compat.b.class)).l(this.ooz);
    localMsgFile.fileName = (paramb.getFileName() + "." + localMsgFile.fBR);
    localMsgFile.type = "image";
    localMsgFile.fBR = paramb.bUI();
    localMsgFile.timeStamp = paramb.getTimeStamp();
    b(localMsgFile);
    AppMethodBeat.o(123249);
  }
  
  protected final boolean bUC()
  {
    AppMethodBeat.i(123247);
    if (this.ooz.getType() == 268435505)
    {
      if (i.eA(((com.tencent.mm.choosemsgfile.compat.b)g.ab(com.tencent.mm.choosemsgfile.compat.b.class)).l(this.ooz)))
      {
        if ((this.oos instanceof com.tencent.mm.plugin.choosemsgfile.b.b.b)) {
          a((com.tencent.mm.plugin.choosemsgfile.b.b.b)this.oos);
        }
        for (;;)
        {
          AppMethodBeat.o(123247);
          return true;
          ac.e("MicroMsg.MsgFileWorker_Image", "mMsgItem isn't AppMsgImageMsgItem, err");
          bUE();
        }
      }
    }
    else if (this.ooE.aEZ())
    {
      String str = ((com.tencent.mm.choosemsgfile.compat.b)g.ab(com.tencent.mm.choosemsgfile.compat.b.class)).a(this.ooz, this.ooE);
      if (!bs.isNullOrNil(str))
      {
        VS(str);
        AppMethodBeat.o(123247);
        return true;
      }
    }
    AppMethodBeat.o(123247);
    return false;
  }
  
  protected final void bpv()
  {
    AppMethodBeat.i(123248);
    if (this.ooz.getType() == 268435505)
    {
      ((com.tencent.mm.choosemsgfile.compat.b)g.ab(com.tencent.mm.choosemsgfile.compat.b.class)).a(this.ooz, new b.a()
      {
        public final void co(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(123242);
          f.this.eT(paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(123242);
        }
        
        public final void r(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(123241);
          ac.i("MicroMsg.MsgFileWorker_Image", "DownloadCallback errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          if (paramAnonymousInt == 0)
          {
            if ((f.this.oos instanceof com.tencent.mm.plugin.choosemsgfile.b.b.b))
            {
              ac.e("MicroMsg.MsgFileWorker_Image", "mMsgItem isn't AppMsgImageMsgItem, err");
              f.a(f.this, (com.tencent.mm.plugin.choosemsgfile.b.b.b)f.this.oos);
              AppMethodBeat.o(123241);
              return;
            }
            f.this.bUE();
            AppMethodBeat.o(123241);
            return;
          }
          ac.e("MicroMsg.MsgFileWorker_Image", "download fail");
          f.this.bUE();
          AppMethodBeat.o(123241);
        }
      });
      AppMethodBeat.o(123248);
      return;
    }
    ac.i("MicroMsg.MsgFileWorker_Image", "isOk:%b", new Object[] { Boolean.valueOf(o.aFy().a(this.ooE.dcd, this.ooz.field_msgId, 0, Long.valueOf(this.ooz.field_msgId), 2131231564, new d.a()
    {
      public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(123245);
        f.this.bUE();
        AppMethodBeat.o(123245);
      }
      
      public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject, int paramAnonymousInt3, int paramAnonymousInt4, n paramAnonymousn)
      {
        AppMethodBeat.i(123243);
        ac.d("MicroMsg.MsgFileWorker_Image", "[onImgTaskProgress] offset:%s totalLen:%s", new Object[] { Integer.valueOf(paramAnonymousInt3), Integer.valueOf(paramAnonymousInt4) });
        f.this.eT(paramAnonymousInt3, paramAnonymousInt4);
        AppMethodBeat.o(123243);
      }
      
      public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject, int paramAnonymousInt3, int paramAnonymousInt4, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(123244);
        ac.i("MicroMsg.MsgFileWorker_Image", "[onImgTaskEnd] imgLocalId:%s msgLocalId:%s err[%s:%s:%s]", new Object[] { Long.valueOf(paramAnonymousLong1), Long.valueOf(paramAnonymousLong2), Integer.valueOf(paramAnonymousInt3), Integer.valueOf(paramAnonymousInt4), paramAnonymousString });
        paramAnonymousObject = ((com.tencent.mm.choosemsgfile.compat.b)g.ab(com.tencent.mm.choosemsgfile.compat.b.class)).k(f.a(f.this));
        paramAnonymousObject = ((com.tencent.mm.choosemsgfile.compat.b)g.ab(com.tencent.mm.choosemsgfile.compat.b.class)).a(f.a(f.this), paramAnonymousObject);
        ac.i("MicroMsg.MsgFileWorker_Image", "imgPath:%s", new Object[] { paramAnonymousObject });
        if (!bs.isNullOrNil(paramAnonymousObject))
        {
          f.a(f.this, paramAnonymousObject);
          AppMethodBeat.o(123244);
          return;
        }
        f.this.bUE();
        AppMethodBeat.o(123244);
      }
    })) });
    AppMethodBeat.o(123248);
  }
  
  protected final boolean checkValid()
  {
    AppMethodBeat.i(123246);
    if ((this.oos == null) || (this.oos.ooz == null))
    {
      ac.e("MicroMsg.MsgFileWorker_Image", "mMsgInfo is null, return");
      bUE();
      AppMethodBeat.o(123246);
      return false;
    }
    this.ooz = this.oos.ooz;
    if (this.ooz.fbQ())
    {
      ac.e("MicroMsg.MsgFileWorker_Image", "mMsgInfo:%s is clean, return", new Object[] { this.ooz });
      AppMethodBeat.o(123246);
      return false;
    }
    if (!((com.tencent.mm.choosemsgfile.compat.b)g.ab(com.tencent.mm.choosemsgfile.compat.b.class)).j(this.ooz))
    {
      ac.e("MicroMsg.MsgFileWorker_Image", "mMsgInfo is not img msg, return");
      AppMethodBeat.o(123246);
      return false;
    }
    if (this.ooz.getType() == 268435505)
    {
      AppMethodBeat.o(123246);
      return true;
    }
    this.ooE = ((com.tencent.mm.choosemsgfile.compat.b)g.ab(com.tencent.mm.choosemsgfile.compat.b.class)).k(this.ooz);
    if (this.ooE == null)
    {
      ac.e("MicroMsg.MsgFileWorker_Image", "mImgInfo is null, return");
      AppMethodBeat.o(123246);
      return false;
    }
    AppMethodBeat.o(123246);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.a.f
 * JD-Core Version:    0.7.0.1
 */