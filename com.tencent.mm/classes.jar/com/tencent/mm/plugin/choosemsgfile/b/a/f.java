package com.tencent.mm.plugin.choosemsgfile.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.av.e;
import com.tencent.mm.av.e.a;
import com.tencent.mm.av.q;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.choosemsgfile.compat.b.a;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.vfs.o;

public final class f
  extends c
{
  private com.tencent.mm.av.g oYB;
  private bv oYw;
  
  public f(com.tencent.mm.plugin.choosemsgfile.b.b.a parama, a parama1, com.tencent.mm.vending.e.b paramb)
  {
    super(parama, parama1, paramb);
  }
  
  private void a(com.tencent.mm.plugin.choosemsgfile.b.b.b paramb)
  {
    AppMethodBeat.i(123249);
    MsgFile localMsgFile = new MsgFile();
    localMsgFile.fileSize = paramb.caD();
    localMsgFile.filePath = ((com.tencent.mm.choosemsgfile.compat.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.choosemsgfile.compat.b.class)).l(this.oYw);
    localMsgFile.fileName = (paramb.getFileName() + "." + localMsgFile.fXl);
    localMsgFile.type = "image";
    localMsgFile.fXl = paramb.caC();
    localMsgFile.timeStamp = paramb.getTimeStamp();
    b(localMsgFile);
    AppMethodBeat.o(123249);
  }
  
  private void aas(String paramString)
  {
    AppMethodBeat.i(123250);
    MsgFile localMsgFile = new MsgFile();
    localMsgFile.fileSize = ((int)o.aZR(paramString));
    localMsgFile.filePath = paramString;
    localMsgFile.fileName = this.oYB.ico;
    localMsgFile.type = "image";
    localMsgFile.fXl = com.tencent.mm.plugin.choosemsgfile.b.d.c.aaw(localMsgFile.fileName);
    localMsgFile.timeStamp = this.oYB.icw;
    b(localMsgFile);
    AppMethodBeat.o(123250);
  }
  
  protected final void buf()
  {
    AppMethodBeat.i(123248);
    if (this.oYw.getType() == 268435505)
    {
      ((com.tencent.mm.choosemsgfile.compat.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.choosemsgfile.compat.b.class)).a(this.oYw, new b.a()
      {
        public final void cq(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(123242);
          f.this.eY(paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(123242);
        }
        
        public final void r(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(123241);
          ae.i("MicroMsg.MsgFileWorker_Image", "DownloadCallback errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          if (paramAnonymousInt == 0)
          {
            if ((f.this.oYp instanceof com.tencent.mm.plugin.choosemsgfile.b.b.b))
            {
              ae.e("MicroMsg.MsgFileWorker_Image", "mMsgItem isn't AppMsgImageMsgItem, err");
              f.a(f.this, (com.tencent.mm.plugin.choosemsgfile.b.b.b)f.this.oYp);
              AppMethodBeat.o(123241);
              return;
            }
            f.this.cay();
            AppMethodBeat.o(123241);
            return;
          }
          ae.e("MicroMsg.MsgFileWorker_Image", "download fail");
          f.this.cay();
          AppMethodBeat.o(123241);
        }
      });
      AppMethodBeat.o(123248);
      return;
    }
    ae.i("MicroMsg.MsgFileWorker_Image", "isOk:%b", new Object[] { Boolean.valueOf(q.aIY().a(this.oYB.doE, this.oYw.field_msgId, 0, Long.valueOf(this.oYw.field_msgId), 2131231564, new e.a()
    {
      public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(123245);
        f.this.cay();
        AppMethodBeat.o(123245);
      }
      
      public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject, int paramAnonymousInt3, int paramAnonymousInt4, n paramAnonymousn)
      {
        AppMethodBeat.i(123243);
        ae.d("MicroMsg.MsgFileWorker_Image", "[onImgTaskProgress] offset:%s totalLen:%s", new Object[] { Integer.valueOf(paramAnonymousInt3), Integer.valueOf(paramAnonymousInt4) });
        f.this.eY(paramAnonymousInt3, paramAnonymousInt4);
        AppMethodBeat.o(123243);
      }
      
      public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject, int paramAnonymousInt3, int paramAnonymousInt4, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(123244);
        ae.i("MicroMsg.MsgFileWorker_Image", "[onImgTaskEnd] imgLocalId:%s msgLocalId:%s err[%s:%s:%s]", new Object[] { Long.valueOf(paramAnonymousLong1), Long.valueOf(paramAnonymousLong2), Integer.valueOf(paramAnonymousInt3), Integer.valueOf(paramAnonymousInt4), paramAnonymousString });
        paramAnonymousObject = ((com.tencent.mm.choosemsgfile.compat.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.choosemsgfile.compat.b.class)).k(f.a(f.this));
        paramAnonymousObject = ((com.tencent.mm.choosemsgfile.compat.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.choosemsgfile.compat.b.class)).a(f.a(f.this), paramAnonymousObject);
        ae.i("MicroMsg.MsgFileWorker_Image", "imgPath:%s", new Object[] { paramAnonymousObject });
        if (!bu.isNullOrNil(paramAnonymousObject))
        {
          f.a(f.this, paramAnonymousObject);
          AppMethodBeat.o(123244);
          return;
        }
        f.this.cay();
        AppMethodBeat.o(123244);
      }
    })) });
    AppMethodBeat.o(123248);
  }
  
  protected final boolean caw()
  {
    AppMethodBeat.i(123247);
    if (this.oYw.getType() == 268435505)
    {
      if (o.fB(((com.tencent.mm.choosemsgfile.compat.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.choosemsgfile.compat.b.class)).l(this.oYw)))
      {
        if ((this.oYp instanceof com.tencent.mm.plugin.choosemsgfile.b.b.b)) {
          a((com.tencent.mm.plugin.choosemsgfile.b.b.b)this.oYp);
        }
        for (;;)
        {
          AppMethodBeat.o(123247);
          return true;
          ae.e("MicroMsg.MsgFileWorker_Image", "mMsgItem isn't AppMsgImageMsgItem, err");
          cay();
        }
      }
    }
    else if (this.oYB.aIA())
    {
      String str = ((com.tencent.mm.choosemsgfile.compat.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.choosemsgfile.compat.b.class)).a(this.oYw, this.oYB);
      if (!bu.isNullOrNil(str))
      {
        aas(str);
        AppMethodBeat.o(123247);
        return true;
      }
    }
    AppMethodBeat.o(123247);
    return false;
  }
  
  protected final boolean checkValid()
  {
    AppMethodBeat.i(123246);
    if ((this.oYp == null) || (this.oYp.oYw == null))
    {
      ae.e("MicroMsg.MsgFileWorker_Image", "mMsgInfo is null, return");
      cay();
      AppMethodBeat.o(123246);
      return false;
    }
    this.oYw = this.oYp.oYw;
    if (this.oYw.fvU())
    {
      ae.e("MicroMsg.MsgFileWorker_Image", "mMsgInfo:%s is clean, return", new Object[] { this.oYw });
      AppMethodBeat.o(123246);
      return false;
    }
    if (!((com.tencent.mm.choosemsgfile.compat.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.choosemsgfile.compat.b.class)).j(this.oYw))
    {
      ae.e("MicroMsg.MsgFileWorker_Image", "mMsgInfo is not img msg, return");
      AppMethodBeat.o(123246);
      return false;
    }
    if (this.oYw.getType() == 268435505)
    {
      AppMethodBeat.o(123246);
      return true;
    }
    this.oYB = ((com.tencent.mm.choosemsgfile.compat.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.choosemsgfile.compat.b.class)).k(this.oYw);
    if (this.oYB == null)
    {
      ae.e("MicroMsg.MsgFileWorker_Image", "mImgInfo is null, return");
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