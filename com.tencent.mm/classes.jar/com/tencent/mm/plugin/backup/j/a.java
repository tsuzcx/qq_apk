package com.tencent.mm.plugin.backup.j;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ac;
import com.tencent.mm.g.a.lj;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.az;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class a
  implements aw
{
  private static a mCg;
  private com.tencent.mm.sdk.b.c mCh;
  private com.tencent.mm.sdk.b.c mCi;
  private com.tencent.mm.sdk.b.c mCj;
  private com.tencent.mm.sdk.b.c mCk;
  private cc.a mCl;
  private cc.a mCm;
  private com.tencent.mm.sdk.b.c mCn;
  
  public a()
  {
    AppMethodBeat.i(22155);
    this.mCh = new a.1(this);
    this.mCi = new a.2(this);
    this.mCj = new com.tencent.mm.sdk.b.c() {};
    this.mCk = new a.4(this);
    this.mCl = new a.5(this);
    this.mCm = new a.6(this);
    this.mCn = new com.tencent.mm.sdk.b.c() {};
    ad.i("MicroMsg.BackupCore", "BackupCore init");
    AppMethodBeat.o(22155);
  }
  
  public static void reset()
  {
    AppMethodBeat.i(22156);
    if (d.bwa())
    {
      AppMethodBeat.o(22156);
      return;
    }
    mCg = null;
    com.tencent.mm.plugin.backup.b.a.bvN();
    d.bwb();
    AppMethodBeat.o(22156);
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(22157);
    b localb = b.byI();
    ad.i("MicroMsg.BackupEventListener", "init addListener");
    localb.mCu = new b.1(localb);
    com.tencent.mm.sdk.b.a.ESL.c(localb.mCu);
    localb.mCv = new b.2(localb);
    com.tencent.mm.sdk.b.a.ESL.c(localb.mCv);
    localb.mCw = new b.3(localb);
    com.tencent.mm.sdk.b.a.ESL.c(localb.mCw);
    az.getSysCmdMsgExtension().a("MMBakChatNotify", this.mCl, true);
    az.getSysCmdMsgExtension().a("ChatSync", this.mCm, true);
    com.tencent.mm.sdk.b.a.ESL.b(this.mCh);
    com.tencent.mm.sdk.b.a.ESL.b(this.mCi);
    com.tencent.mm.sdk.b.a.ESL.b(this.mCj);
    com.tencent.mm.sdk.b.a.ESL.b(this.mCk);
    com.tencent.mm.sdk.b.a.ESL.b(this.mCn);
    AppMethodBeat.o(22157);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(22158);
    b localb = b.byI();
    com.tencent.mm.sdk.b.a.ESL.d(localb.mCu);
    com.tencent.mm.sdk.b.a.ESL.d(localb.mCv);
    com.tencent.mm.sdk.b.a.ESL.d(localb.mCw);
    az.getSysCmdMsgExtension().b("MMBakChatNotify", this.mCl, true);
    az.getSysCmdMsgExtension().b("ChatSync", this.mCm, true);
    com.tencent.mm.sdk.b.a.ESL.d(this.mCh);
    com.tencent.mm.sdk.b.a.ESL.d(this.mCi);
    com.tencent.mm.sdk.b.a.ESL.d(this.mCj);
    com.tencent.mm.sdk.b.a.ESL.d(this.mCk);
    com.tencent.mm.sdk.b.a.ESL.d(this.mCn);
    AppMethodBeat.o(22158);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.j.a
 * JD-Core Version:    0.7.0.1
 */