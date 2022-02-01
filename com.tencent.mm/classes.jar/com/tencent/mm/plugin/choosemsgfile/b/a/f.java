package com.tencent.mm.plugin.choosemsgfile.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.aw.e;
import com.tencent.mm.aw.e.a;
import com.tencent.mm.aw.q;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.choosemsgfile.compat.b.a;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.vfs.i;

public final class f
  extends c
{
  private bu oRU;
  private com.tencent.mm.aw.g oRZ;
  
  public f(com.tencent.mm.plugin.choosemsgfile.b.b.a parama, a parama1, com.tencent.mm.vending.e.b paramb)
  {
    super(parama, parama1, paramb);
  }
  
  private void ZB(String paramString)
  {
    AppMethodBeat.i(123250);
    MsgFile localMsgFile = new MsgFile();
    localMsgFile.fileSize = ((int)i.aYo(paramString));
    localMsgFile.filePath = paramString;
    localMsgFile.fileName = this.oRZ.hZw;
    localMsgFile.type = "image";
    localMsgFile.fVf = com.tencent.mm.plugin.choosemsgfile.b.d.c.ZF(localMsgFile.fileName);
    localMsgFile.timeStamp = this.oRZ.hZE;
    b(localMsgFile);
    AppMethodBeat.o(123250);
  }
  
  private void a(com.tencent.mm.plugin.choosemsgfile.b.b.b paramb)
  {
    AppMethodBeat.i(123249);
    MsgFile localMsgFile = new MsgFile();
    localMsgFile.fileSize = paramb.bZo();
    localMsgFile.filePath = ((com.tencent.mm.choosemsgfile.compat.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.choosemsgfile.compat.b.class)).l(this.oRU);
    localMsgFile.fileName = (paramb.getFileName() + "." + localMsgFile.fVf);
    localMsgFile.type = "image";
    localMsgFile.fVf = paramb.bZn();
    localMsgFile.timeStamp = paramb.getTimeStamp();
    b(localMsgFile);
    AppMethodBeat.o(123249);
  }
  
  protected final boolean bZh()
  {
    AppMethodBeat.i(123247);
    if (this.oRU.getType() == 268435505)
    {
      if (i.fv(((com.tencent.mm.choosemsgfile.compat.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.choosemsgfile.compat.b.class)).l(this.oRU)))
      {
        if ((this.oRN instanceof com.tencent.mm.plugin.choosemsgfile.b.b.b)) {
          a((com.tencent.mm.plugin.choosemsgfile.b.b.b)this.oRN);
        }
        for (;;)
        {
          AppMethodBeat.o(123247);
          return true;
          ad.e("MicroMsg.MsgFileWorker_Image", "mMsgItem isn't AppMsgImageMsgItem, err");
          bZj();
        }
      }
    }
    else if (this.oRZ.aIi())
    {
      String str = ((com.tencent.mm.choosemsgfile.compat.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.choosemsgfile.compat.b.class)).a(this.oRU, this.oRZ);
      if (!bt.isNullOrNil(str))
      {
        ZB(str);
        AppMethodBeat.o(123247);
        return true;
      }
    }
    AppMethodBeat.o(123247);
    return false;
  }
  
  protected final void btu()
  {
    AppMethodBeat.i(123248);
    if (this.oRU.getType() == 268435505)
    {
      ((com.tencent.mm.choosemsgfile.compat.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.choosemsgfile.compat.b.class)).a(this.oRU, new b.a()
      {
        public final void cq(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(123242);
          f.this.eX(paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(123242);
        }
        
        public final void r(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(123241);
          ad.i("MicroMsg.MsgFileWorker_Image", "DownloadCallback errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          if (paramAnonymousInt == 0)
          {
            if ((f.this.oRN instanceof com.tencent.mm.plugin.choosemsgfile.b.b.b))
            {
              ad.e("MicroMsg.MsgFileWorker_Image", "mMsgItem isn't AppMsgImageMsgItem, err");
              f.a(f.this, (com.tencent.mm.plugin.choosemsgfile.b.b.b)f.this.oRN);
              AppMethodBeat.o(123241);
              return;
            }
            f.this.bZj();
            AppMethodBeat.o(123241);
            return;
          }
          ad.e("MicroMsg.MsgFileWorker_Image", "download fail");
          f.this.bZj();
          AppMethodBeat.o(123241);
        }
      });
      AppMethodBeat.o(123248);
      return;
    }
    ad.i("MicroMsg.MsgFileWorker_Image", "isOk:%b", new Object[] { Boolean.valueOf(q.aIG().a(this.oRZ.dnz, this.oRU.field_msgId, 0, Long.valueOf(this.oRU.field_msgId), 2131231564, new e.a()
    {
      public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(123245);
        f.this.bZj();
        AppMethodBeat.o(123245);
      }
      
      public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject, int paramAnonymousInt3, int paramAnonymousInt4, n paramAnonymousn)
      {
        AppMethodBeat.i(123243);
        ad.d("MicroMsg.MsgFileWorker_Image", "[onImgTaskProgress] offset:%s totalLen:%s", new Object[] { Integer.valueOf(paramAnonymousInt3), Integer.valueOf(paramAnonymousInt4) });
        f.this.eX(paramAnonymousInt3, paramAnonymousInt4);
        AppMethodBeat.o(123243);
      }
      
      public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject, int paramAnonymousInt3, int paramAnonymousInt4, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(123244);
        ad.i("MicroMsg.MsgFileWorker_Image", "[onImgTaskEnd] imgLocalId:%s msgLocalId:%s err[%s:%s:%s]", new Object[] { Long.valueOf(paramAnonymousLong1), Long.valueOf(paramAnonymousLong2), Integer.valueOf(paramAnonymousInt3), Integer.valueOf(paramAnonymousInt4), paramAnonymousString });
        paramAnonymousObject = ((com.tencent.mm.choosemsgfile.compat.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.choosemsgfile.compat.b.class)).k(f.a(f.this));
        paramAnonymousObject = ((com.tencent.mm.choosemsgfile.compat.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.choosemsgfile.compat.b.class)).a(f.a(f.this), paramAnonymousObject);
        ad.i("MicroMsg.MsgFileWorker_Image", "imgPath:%s", new Object[] { paramAnonymousObject });
        if (!bt.isNullOrNil(paramAnonymousObject))
        {
          f.a(f.this, paramAnonymousObject);
          AppMethodBeat.o(123244);
          return;
        }
        f.this.bZj();
        AppMethodBeat.o(123244);
      }
    })) });
    AppMethodBeat.o(123248);
  }
  
  protected final boolean checkValid()
  {
    AppMethodBeat.i(123246);
    if ((this.oRN == null) || (this.oRN.oRU == null))
    {
      ad.e("MicroMsg.MsgFileWorker_Image", "mMsgInfo is null, return");
      bZj();
      AppMethodBeat.o(123246);
      return false;
    }
    this.oRU = this.oRN.oRU;
    if (this.oRU.frT())
    {
      ad.e("MicroMsg.MsgFileWorker_Image", "mMsgInfo:%s is clean, return", new Object[] { this.oRU });
      AppMethodBeat.o(123246);
      return false;
    }
    if (!((com.tencent.mm.choosemsgfile.compat.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.choosemsgfile.compat.b.class)).j(this.oRU))
    {
      ad.e("MicroMsg.MsgFileWorker_Image", "mMsgInfo is not img msg, return");
      AppMethodBeat.o(123246);
      return false;
    }
    if (this.oRU.getType() == 268435505)
    {
      AppMethodBeat.o(123246);
      return true;
    }
    this.oRZ = ((com.tencent.mm.choosemsgfile.compat.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.choosemsgfile.compat.b.class)).k(this.oRU);
    if (this.oRZ == null)
    {
      ad.e("MicroMsg.MsgFileWorker_Image", "mImgInfo is null, return");
      AppMethodBeat.o(123246);
      return false;
    }
    AppMethodBeat.o(123246);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.a.f
 * JD-Core Version:    0.7.0.1
 */