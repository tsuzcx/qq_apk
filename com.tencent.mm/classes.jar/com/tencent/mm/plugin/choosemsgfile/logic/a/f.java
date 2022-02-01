package com.tencent.mm.plugin.choosemsgfile.logic.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.choosemsgfile.compat.b.a;
import com.tencent.mm.modelimage.f.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.choosemsgfile.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.vfs.y;

public final class f
  extends c
{
  private com.tencent.mm.modelimage.h wPD;
  private cc wPy;
  
  public f(com.tencent.mm.plugin.choosemsgfile.logic.b.a parama, a parama1, com.tencent.mm.vending.e.b paramb)
  {
    super(parama, parama1, paramb);
  }
  
  private void a(com.tencent.mm.plugin.choosemsgfile.logic.b.b paramb)
  {
    AppMethodBeat.i(123249);
    MsgFile localMsgFile = new MsgFile();
    localMsgFile.fileSize = paramb.dqt();
    localMsgFile.filePath = ((com.tencent.mm.choosemsgfile.compat.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.choosemsgfile.compat.b.class)).l(this.wPy);
    localMsgFile.fileName = (paramb.getFileName() + "." + localMsgFile.lPJ);
    localMsgFile.type = "image";
    localMsgFile.lPJ = paramb.getFileExt();
    localMsgFile.timeStamp = paramb.getTimeStamp();
    b(localMsgFile);
    AppMethodBeat.o(123249);
  }
  
  private void alR(String paramString)
  {
    AppMethodBeat.i(123250);
    MsgFile localMsgFile = new MsgFile();
    localMsgFile.fileSize = ((int)y.bEl(paramString));
    localMsgFile.filePath = paramString;
    localMsgFile.fileName = this.wPD.oGr;
    localMsgFile.type = "image";
    localMsgFile.lPJ = com.tencent.mm.plugin.choosemsgfile.logic.c.c.alV(localMsgFile.fileName);
    localMsgFile.timeStamp = this.wPD.createTime;
    b(localMsgFile);
    AppMethodBeat.o(123250);
  }
  
  protected final void cCw()
  {
    AppMethodBeat.i(123248);
    if (this.wPy.getType() == 268435505)
    {
      ((com.tencent.mm.choosemsgfile.compat.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.choosemsgfile.compat.b.class)).a(this.wPy, new b.a()
      {
        public final void dA(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(123242);
          f.this.gA(paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(123242);
        }
        
        public final void u(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(123241);
          Log.i("MicroMsg.MsgFileWorker_Image", "DownloadCallback errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          if (paramAnonymousInt == 0)
          {
            if ((f.this.wPs instanceof com.tencent.mm.plugin.choosemsgfile.logic.b.b))
            {
              Log.e("MicroMsg.MsgFileWorker_Image", "mMsgItem isn't AppMsgImageMsgItem, err");
              f.a(f.this, (com.tencent.mm.plugin.choosemsgfile.logic.b.b)f.this.wPs);
              AppMethodBeat.o(123241);
              return;
            }
            f.this.dqo();
            AppMethodBeat.o(123241);
            return;
          }
          Log.e("MicroMsg.MsgFileWorker_Image", "download fail");
          f.this.dqo();
          AppMethodBeat.o(123241);
        }
      });
      AppMethodBeat.o(123248);
      return;
    }
    Log.i("MicroMsg.MsgFileWorker_Image", "isOk:%b", new Object[] { Boolean.valueOf(r.bKb().a(this.wPD.localId, this.wPy.field_msgId, 0, Long.valueOf(this.wPy.field_msgId), a.d.chat_img_template, new f.a()
    {
      public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(123245);
        f.this.dqo();
        AppMethodBeat.o(123245);
      }
      
      public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject, int paramAnonymousInt3, int paramAnonymousInt4, p paramAnonymousp)
      {
        AppMethodBeat.i(123243);
        Log.d("MicroMsg.MsgFileWorker_Image", "[onImgTaskProgress] offset:%s totalLen:%s", new Object[] { Integer.valueOf(paramAnonymousInt3), Integer.valueOf(paramAnonymousInt4) });
        f.this.gA(paramAnonymousInt3, paramAnonymousInt4);
        AppMethodBeat.o(123243);
      }
      
      public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject, int paramAnonymousInt3, int paramAnonymousInt4, String paramAnonymousString, p paramAnonymousp)
      {
        AppMethodBeat.i(123244);
        Log.i("MicroMsg.MsgFileWorker_Image", "[onImgTaskEnd] imgLocalId:%s msgLocalId:%s err[%s:%s:%s]", new Object[] { Long.valueOf(paramAnonymousLong1), Long.valueOf(paramAnonymousLong2), Integer.valueOf(paramAnonymousInt3), Integer.valueOf(paramAnonymousInt4), paramAnonymousString });
        paramAnonymousObject = ((com.tencent.mm.choosemsgfile.compat.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.choosemsgfile.compat.b.class)).k(f.a(f.this));
        paramAnonymousObject = ((com.tencent.mm.choosemsgfile.compat.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.choosemsgfile.compat.b.class)).a(f.a(f.this), paramAnonymousObject);
        Log.i("MicroMsg.MsgFileWorker_Image", "imgPath:%s", new Object[] { paramAnonymousObject });
        if (!Util.isNullOrNil(paramAnonymousObject))
        {
          f.a(f.this, paramAnonymousObject);
          AppMethodBeat.o(123244);
          return;
        }
        f.this.dqo();
        AppMethodBeat.o(123244);
      }
    })) });
    AppMethodBeat.o(123248);
  }
  
  protected final boolean checkValid()
  {
    AppMethodBeat.i(123246);
    if ((this.wPs == null) || (this.wPs.wPy == null))
    {
      Log.e("MicroMsg.MsgFileWorker_Image", "mMsgInfo is null, return");
      dqo();
      AppMethodBeat.o(123246);
      return false;
    }
    this.wPy = this.wPs.wPy;
    if (this.wPy.isClean())
    {
      Log.e("MicroMsg.MsgFileWorker_Image", "mMsgInfo:%s is clean, return", new Object[] { this.wPy });
      AppMethodBeat.o(123246);
      return false;
    }
    if (!((com.tencent.mm.choosemsgfile.compat.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.choosemsgfile.compat.b.class)).j(this.wPy))
    {
      Log.e("MicroMsg.MsgFileWorker_Image", "mMsgInfo is not img msg, return");
      AppMethodBeat.o(123246);
      return false;
    }
    if (this.wPy.getType() == 268435505)
    {
      AppMethodBeat.o(123246);
      return true;
    }
    this.wPD = ((com.tencent.mm.choosemsgfile.compat.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.choosemsgfile.compat.b.class)).k(this.wPy);
    if (this.wPD == null)
    {
      Log.e("MicroMsg.MsgFileWorker_Image", "mImgInfo is null, return");
      AppMethodBeat.o(123246);
      return false;
    }
    AppMethodBeat.o(123246);
    return true;
  }
  
  protected final boolean dqm()
  {
    AppMethodBeat.i(123247);
    if (this.wPy.getType() == 268435505)
    {
      if (y.ZC(((com.tencent.mm.choosemsgfile.compat.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.choosemsgfile.compat.b.class)).l(this.wPy)))
      {
        if ((this.wPs instanceof com.tencent.mm.plugin.choosemsgfile.logic.b.b)) {
          a((com.tencent.mm.plugin.choosemsgfile.logic.b.b)this.wPs);
        }
        for (;;)
        {
          AppMethodBeat.o(123247);
          return true;
          Log.e("MicroMsg.MsgFileWorker_Image", "mMsgItem isn't AppMsgImageMsgItem, err");
          dqo();
        }
      }
    }
    else if (this.wPD.bJD())
    {
      String str = ((com.tencent.mm.choosemsgfile.compat.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.choosemsgfile.compat.b.class)).a(this.wPy, this.wPD);
      if (!Util.isNullOrNil(str))
      {
        alR(str);
        AppMethodBeat.o(123247);
        return true;
      }
    }
    AppMethodBeat.o(123247);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.logic.a.f
 * JD-Core Version:    0.7.0.1
 */