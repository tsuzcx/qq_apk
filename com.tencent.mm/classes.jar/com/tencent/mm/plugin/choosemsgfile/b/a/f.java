package com.tencent.mm.plugin.choosemsgfile.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.e;
import com.tencent.mm.ay.e.a;
import com.tencent.mm.ay.g;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.choosemsgfile.compat.b.a;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.choosemsgfile.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.u;

public final class f
  extends c
{
  private ca tMi;
  private g tMn;
  
  public f(com.tencent.mm.plugin.choosemsgfile.b.b.a parama, a parama1, com.tencent.mm.vending.e.b paramb)
  {
    super(parama, parama1, paramb);
  }
  
  private void a(com.tencent.mm.plugin.choosemsgfile.b.b.b paramb)
  {
    AppMethodBeat.i(123249);
    MsgFile localMsgFile = new MsgFile();
    localMsgFile.fileSize = paramb.cMO();
    localMsgFile.filePath = ((com.tencent.mm.choosemsgfile.compat.b)h.ae(com.tencent.mm.choosemsgfile.compat.b.class)).l(this.tMi);
    localMsgFile.fileName = (paramb.getFileName() + "." + localMsgFile.jmx);
    localMsgFile.type = "image";
    localMsgFile.jmx = paramb.getFileExt();
    localMsgFile.timeStamp = paramb.getTimeStamp();
    b(localMsgFile);
    AppMethodBeat.o(123249);
  }
  
  private void asm(String paramString)
  {
    AppMethodBeat.i(123250);
    MsgFile localMsgFile = new MsgFile();
    localMsgFile.fileSize = ((int)u.bBQ(paramString));
    localMsgFile.filePath = paramString;
    localMsgFile.fileName = this.tMn.lNH;
    localMsgFile.type = "image";
    localMsgFile.jmx = com.tencent.mm.plugin.choosemsgfile.b.d.c.asq(localMsgFile.fileName);
    localMsgFile.timeStamp = this.tMn.createTime;
    b(localMsgFile);
    AppMethodBeat.o(123250);
  }
  
  protected final boolean cMI()
  {
    AppMethodBeat.i(123247);
    if (this.tMi.getType() == 268435505)
    {
      if (u.agG(((com.tencent.mm.choosemsgfile.compat.b)h.ae(com.tencent.mm.choosemsgfile.compat.b.class)).l(this.tMi)))
      {
        if ((this.tMc instanceof com.tencent.mm.plugin.choosemsgfile.b.b.b)) {
          a((com.tencent.mm.plugin.choosemsgfile.b.b.b)this.tMc);
        }
        for (;;)
        {
          AppMethodBeat.o(123247);
          return true;
          Log.e("MicroMsg.MsgFileWorker_Image", "mMsgItem isn't AppMsgImageMsgItem, err");
          cMK();
        }
      }
    }
    else if (this.tMn.blJ())
    {
      String str = ((com.tencent.mm.choosemsgfile.compat.b)h.ae(com.tencent.mm.choosemsgfile.compat.b.class)).a(this.tMi, this.tMn);
      if (!Util.isNullOrNil(str))
      {
        asm(str);
        AppMethodBeat.o(123247);
        return true;
      }
    }
    AppMethodBeat.o(123247);
    return false;
  }
  
  protected final void ccd()
  {
    AppMethodBeat.i(123248);
    if (this.tMi.getType() == 268435505)
    {
      ((com.tencent.mm.choosemsgfile.compat.b)h.ae(com.tencent.mm.choosemsgfile.compat.b.class)).a(this.tMi, new b.a()
      {
        public final void cK(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(123242);
          f.this.fI(paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(123242);
        }
        
        public final void u(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(123241);
          Log.i("MicroMsg.MsgFileWorker_Image", "DownloadCallback errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          if (paramAnonymousInt == 0)
          {
            if ((f.this.tMc instanceof com.tencent.mm.plugin.choosemsgfile.b.b.b))
            {
              Log.e("MicroMsg.MsgFileWorker_Image", "mMsgItem isn't AppMsgImageMsgItem, err");
              f.a(f.this, (com.tencent.mm.plugin.choosemsgfile.b.b.b)f.this.tMc);
              AppMethodBeat.o(123241);
              return;
            }
            f.this.cMK();
            AppMethodBeat.o(123241);
            return;
          }
          Log.e("MicroMsg.MsgFileWorker_Image", "download fail");
          f.this.cMK();
          AppMethodBeat.o(123241);
        }
      });
      AppMethodBeat.o(123248);
      return;
    }
    Log.i("MicroMsg.MsgFileWorker_Image", "isOk:%b", new Object[] { Boolean.valueOf(com.tencent.mm.ay.q.bmi().a(this.tMn.localId, this.tMi.field_msgId, 0, Long.valueOf(this.tMi.field_msgId), a.d.chat_img_template, new e.a()
    {
      public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(123245);
        f.this.cMK();
        AppMethodBeat.o(123245);
      }
      
      public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject, int paramAnonymousInt3, int paramAnonymousInt4, com.tencent.mm.an.q paramAnonymousq)
      {
        AppMethodBeat.i(123243);
        Log.d("MicroMsg.MsgFileWorker_Image", "[onImgTaskProgress] offset:%s totalLen:%s", new Object[] { Integer.valueOf(paramAnonymousInt3), Integer.valueOf(paramAnonymousInt4) });
        f.this.fI(paramAnonymousInt3, paramAnonymousInt4);
        AppMethodBeat.o(123243);
      }
      
      public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject, int paramAnonymousInt3, int paramAnonymousInt4, String paramAnonymousString, com.tencent.mm.an.q paramAnonymousq)
      {
        AppMethodBeat.i(123244);
        Log.i("MicroMsg.MsgFileWorker_Image", "[onImgTaskEnd] imgLocalId:%s msgLocalId:%s err[%s:%s:%s]", new Object[] { Long.valueOf(paramAnonymousLong1), Long.valueOf(paramAnonymousLong2), Integer.valueOf(paramAnonymousInt3), Integer.valueOf(paramAnonymousInt4), paramAnonymousString });
        paramAnonymousObject = ((com.tencent.mm.choosemsgfile.compat.b)h.ae(com.tencent.mm.choosemsgfile.compat.b.class)).k(f.a(f.this));
        paramAnonymousObject = ((com.tencent.mm.choosemsgfile.compat.b)h.ae(com.tencent.mm.choosemsgfile.compat.b.class)).a(f.a(f.this), paramAnonymousObject);
        Log.i("MicroMsg.MsgFileWorker_Image", "imgPath:%s", new Object[] { paramAnonymousObject });
        if (!Util.isNullOrNil(paramAnonymousObject))
        {
          f.a(f.this, paramAnonymousObject);
          AppMethodBeat.o(123244);
          return;
        }
        f.this.cMK();
        AppMethodBeat.o(123244);
      }
    })) });
    AppMethodBeat.o(123248);
  }
  
  protected final boolean checkValid()
  {
    AppMethodBeat.i(123246);
    if ((this.tMc == null) || (this.tMc.tMi == null))
    {
      Log.e("MicroMsg.MsgFileWorker_Image", "mMsgInfo is null, return");
      cMK();
      AppMethodBeat.o(123246);
      return false;
    }
    this.tMi = this.tMc.tMi;
    if (this.tMi.Ic())
    {
      Log.e("MicroMsg.MsgFileWorker_Image", "mMsgInfo:%s is clean, return", new Object[] { this.tMi });
      AppMethodBeat.o(123246);
      return false;
    }
    if (!((com.tencent.mm.choosemsgfile.compat.b)h.ae(com.tencent.mm.choosemsgfile.compat.b.class)).j(this.tMi))
    {
      Log.e("MicroMsg.MsgFileWorker_Image", "mMsgInfo is not img msg, return");
      AppMethodBeat.o(123246);
      return false;
    }
    if (this.tMi.getType() == 268435505)
    {
      AppMethodBeat.o(123246);
      return true;
    }
    this.tMn = ((com.tencent.mm.choosemsgfile.compat.b)h.ae(com.tencent.mm.choosemsgfile.compat.b.class)).k(this.tMi);
    if (this.tMn == null)
    {
      Log.e("MicroMsg.MsgFileWorker_Image", "mImgInfo is null, return");
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