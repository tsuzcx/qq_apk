package com.tencent.mm.plugin.choosemsgfile.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.e;
import com.tencent.mm.av.e.a;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.choosemsgfile.compat.b.a;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.s;

public final class f
  extends c
{
  private com.tencent.mm.av.g qnA;
  private ca qnv;
  
  public f(com.tencent.mm.plugin.choosemsgfile.b.b.a parama, a parama1, com.tencent.mm.vending.e.b paramb)
  {
    super(parama, parama1, paramb);
  }
  
  private void a(com.tencent.mm.plugin.choosemsgfile.b.b.b paramb)
  {
    AppMethodBeat.i(123249);
    MsgFile localMsgFile = new MsgFile();
    localMsgFile.fileSize = paramb.cyt();
    localMsgFile.filePath = ((com.tencent.mm.choosemsgfile.compat.b)com.tencent.mm.kernel.g.af(com.tencent.mm.choosemsgfile.compat.b.class)).l(this.qnv);
    localMsgFile.fileName = (paramb.getFileName() + "." + localMsgFile.gCr);
    localMsgFile.type = "image";
    localMsgFile.gCr = paramb.getFileExt();
    localMsgFile.timeStamp = paramb.getTimeStamp();
    b(localMsgFile);
    AppMethodBeat.o(123249);
  }
  
  private void aky(String paramString)
  {
    AppMethodBeat.i(123250);
    MsgFile localMsgFile = new MsgFile();
    localMsgFile.fileSize = ((int)s.boW(paramString));
    localMsgFile.filePath = paramString;
    localMsgFile.fileName = this.qnA.iXm;
    localMsgFile.type = "image";
    localMsgFile.gCr = com.tencent.mm.plugin.choosemsgfile.b.d.c.akC(localMsgFile.fileName);
    localMsgFile.timeStamp = this.qnA.iXu;
    b(localMsgFile);
    AppMethodBeat.o(123250);
  }
  
  protected final void bPM()
  {
    AppMethodBeat.i(123248);
    if (this.qnv.getType() == 268435505)
    {
      ((com.tencent.mm.choosemsgfile.compat.b)com.tencent.mm.kernel.g.af(com.tencent.mm.choosemsgfile.compat.b.class)).a(this.qnv, new b.a()
      {
        public final void cs(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(123242);
          f.this.fl(paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(123242);
        }
        
        public final void t(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(123241);
          Log.i("MicroMsg.MsgFileWorker_Image", "DownloadCallback errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          if (paramAnonymousInt == 0)
          {
            if ((f.this.qno instanceof com.tencent.mm.plugin.choosemsgfile.b.b.b))
            {
              Log.e("MicroMsg.MsgFileWorker_Image", "mMsgItem isn't AppMsgImageMsgItem, err");
              f.a(f.this, (com.tencent.mm.plugin.choosemsgfile.b.b.b)f.this.qno);
              AppMethodBeat.o(123241);
              return;
            }
            f.this.cyp();
            AppMethodBeat.o(123241);
            return;
          }
          Log.e("MicroMsg.MsgFileWorker_Image", "download fail");
          f.this.cyp();
          AppMethodBeat.o(123241);
        }
      });
      AppMethodBeat.o(123248);
      return;
    }
    Log.i("MicroMsg.MsgFileWorker_Image", "isOk:%b", new Object[] { Boolean.valueOf(com.tencent.mm.av.q.bcS().a(this.qnA.localId, this.qnv.field_msgId, 0, Long.valueOf(this.qnv.field_msgId), 2131231628, new e.a()
    {
      public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(123245);
        f.this.cyp();
        AppMethodBeat.o(123245);
      }
      
      public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject, int paramAnonymousInt3, int paramAnonymousInt4, com.tencent.mm.ak.q paramAnonymousq)
      {
        AppMethodBeat.i(123243);
        Log.d("MicroMsg.MsgFileWorker_Image", "[onImgTaskProgress] offset:%s totalLen:%s", new Object[] { Integer.valueOf(paramAnonymousInt3), Integer.valueOf(paramAnonymousInt4) });
        f.this.fl(paramAnonymousInt3, paramAnonymousInt4);
        AppMethodBeat.o(123243);
      }
      
      public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject, int paramAnonymousInt3, int paramAnonymousInt4, String paramAnonymousString, com.tencent.mm.ak.q paramAnonymousq)
      {
        AppMethodBeat.i(123244);
        Log.i("MicroMsg.MsgFileWorker_Image", "[onImgTaskEnd] imgLocalId:%s msgLocalId:%s err[%s:%s:%s]", new Object[] { Long.valueOf(paramAnonymousLong1), Long.valueOf(paramAnonymousLong2), Integer.valueOf(paramAnonymousInt3), Integer.valueOf(paramAnonymousInt4), paramAnonymousString });
        paramAnonymousObject = ((com.tencent.mm.choosemsgfile.compat.b)com.tencent.mm.kernel.g.af(com.tencent.mm.choosemsgfile.compat.b.class)).k(f.a(f.this));
        paramAnonymousObject = ((com.tencent.mm.choosemsgfile.compat.b)com.tencent.mm.kernel.g.af(com.tencent.mm.choosemsgfile.compat.b.class)).a(f.a(f.this), paramAnonymousObject);
        Log.i("MicroMsg.MsgFileWorker_Image", "imgPath:%s", new Object[] { paramAnonymousObject });
        if (!Util.isNullOrNil(paramAnonymousObject))
        {
          f.a(f.this, paramAnonymousObject);
          AppMethodBeat.o(123244);
          return;
        }
        f.this.cyp();
        AppMethodBeat.o(123244);
      }
    })) });
    AppMethodBeat.o(123248);
  }
  
  protected final boolean checkValid()
  {
    AppMethodBeat.i(123246);
    if ((this.qno == null) || (this.qno.qnv == null))
    {
      Log.e("MicroMsg.MsgFileWorker_Image", "mMsgInfo is null, return");
      cyp();
      AppMethodBeat.o(123246);
      return false;
    }
    this.qnv = this.qno.qnv;
    if (this.qnv.gDB())
    {
      Log.e("MicroMsg.MsgFileWorker_Image", "mMsgInfo:%s is clean, return", new Object[] { this.qnv });
      AppMethodBeat.o(123246);
      return false;
    }
    if (!((com.tencent.mm.choosemsgfile.compat.b)com.tencent.mm.kernel.g.af(com.tencent.mm.choosemsgfile.compat.b.class)).j(this.qnv))
    {
      Log.e("MicroMsg.MsgFileWorker_Image", "mMsgInfo is not img msg, return");
      AppMethodBeat.o(123246);
      return false;
    }
    if (this.qnv.getType() == 268435505)
    {
      AppMethodBeat.o(123246);
      return true;
    }
    this.qnA = ((com.tencent.mm.choosemsgfile.compat.b)com.tencent.mm.kernel.g.af(com.tencent.mm.choosemsgfile.compat.b.class)).k(this.qnv);
    if (this.qnA == null)
    {
      Log.e("MicroMsg.MsgFileWorker_Image", "mImgInfo is null, return");
      AppMethodBeat.o(123246);
      return false;
    }
    AppMethodBeat.o(123246);
    return true;
  }
  
  protected final boolean cyn()
  {
    AppMethodBeat.i(123247);
    if (this.qnv.getType() == 268435505)
    {
      if (s.YS(((com.tencent.mm.choosemsgfile.compat.b)com.tencent.mm.kernel.g.af(com.tencent.mm.choosemsgfile.compat.b.class)).l(this.qnv)))
      {
        if ((this.qno instanceof com.tencent.mm.plugin.choosemsgfile.b.b.b)) {
          a((com.tencent.mm.plugin.choosemsgfile.b.b.b)this.qno);
        }
        for (;;)
        {
          AppMethodBeat.o(123247);
          return true;
          Log.e("MicroMsg.MsgFileWorker_Image", "mMsgItem isn't AppMsgImageMsgItem, err");
          cyp();
        }
      }
    }
    else if (this.qnA.bcu())
    {
      String str = ((com.tencent.mm.choosemsgfile.compat.b)com.tencent.mm.kernel.g.af(com.tencent.mm.choosemsgfile.compat.b.class)).a(this.qnv, this.qnA);
      if (!Util.isNullOrNil(str))
      {
        aky(str);
        AppMethodBeat.o(123247);
        return true;
      }
    }
    AppMethodBeat.o(123247);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.a.f
 * JD-Core Version:    0.7.0.1
 */