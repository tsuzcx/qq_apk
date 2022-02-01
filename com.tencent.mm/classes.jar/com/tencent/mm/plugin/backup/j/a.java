package com.tencent.mm.plugin.backup.j;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.c;
import com.tencent.mm.by.c;
import com.tencent.mm.f.a.ad;
import com.tencent.mm.f.a.ah;
import com.tencent.mm.f.a.ni;
import com.tencent.mm.f.a.nj;
import com.tencent.mm.f.a.nj.a;
import com.tencent.mm.model.be;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.ck;
import com.tencent.mm.model.ck.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.z.f;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Map;

public class a
  implements be
{
  private static a rWT;
  private IListener rWU;
  private IListener rWV;
  private IListener rWW;
  private IListener rWX;
  private ck.a rWY;
  private ck.a rWZ;
  private IListener rXa;
  
  public a()
  {
    AppMethodBeat.i(22155);
    this.rWU = new IListener() {};
    this.rWV = new IListener() {};
    this.rWW = new IListener() {};
    this.rWX = new IListener() {};
    this.rWY = new ck.a()
    {
      public final void a(h.a paramAnonymousa)
      {
        AppMethodBeat.i(22147);
        Log.i("MicroMsg.BackupCore.BackupToPc", "sysMsgListener onreceive sysmsg");
        h.IzE.idkeyStat(400L, 0L, 1L, false);
        String str = (String)XmlParser.parseXml(z.a(paramAnonymousa.jQG.RIF), "sysmsg", null).get(".sysmsg.MMBakChatNotify.url");
        if (Util.isNullOrNil(str))
        {
          Log.e("MicroMsg.BackupCore.BackupToPc", "MMBakChatNotify url is null");
          AppMethodBeat.o(22147);
          return;
        }
        paramAnonymousa = new Intent().setClassName(MMApplicationContext.getContext(), "com.tencent.mm.plugin.backup.backuppcmodel.BackupPcService");
        Intent localIntent = Util.createExplicitFromImplicitIntent(MMApplicationContext.getContext(), paramAnonymousa);
        if (localIntent != null) {
          paramAnonymousa = localIntent;
        }
        for (;;)
        {
          c.startService(paramAnonymousa.putExtra("url", str).putExtra("isFromWifi", true));
          AppMethodBeat.o(22147);
          return;
        }
      }
      
      public final void a(h.c paramAnonymousc) {}
    };
    this.rWZ = new ck.a()
    {
      public final void a(final h.a paramAnonymousa)
      {
        AppMethodBeat.i(22149);
        Log.i("MicroMsg.BackupCore.MsgSynchronize", "appMsgListener onreceive appmsg");
        final String str1 = z.a(paramAnonymousa.jQG.RIF);
        paramAnonymousa = XmlParser.parseXml(str1, "appmsg", null);
        Log.d("MicroMsg.BackupCore.MsgSynchronize", "BackupCore msgcontent:%s", new Object[] { str1 });
        if (((String)paramAnonymousa.get(".appmsg.action")).equals("phone"))
        {
          Log.i("MicroMsg.BackupCore.MsgSynchronize", "this appmsg is from phone, ignore.");
          AppMethodBeat.o(22149);
          return;
        }
        str1 = (String)paramAnonymousa.get(".appmsg.messageaction");
        final String str2 = (String)paramAnonymousa.get(".appmsg.extinfo");
        paramAnonymousa = ((String)paramAnonymousa.get(".appmsg.appattach.aeskey")).getBytes();
        bh.aHJ().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(22148);
            Log.i("MicroMsg.BackupCore.MsgSynchronize", "start MsgSynchronizeServer");
            f.uv(false).d(str1, str2, paramAnonymousa);
            AppMethodBeat.o(22148);
          }
        });
        AppMethodBeat.o(22149);
      }
      
      public final void a(h.c paramAnonymousc) {}
    };
    this.rXa = new a.7(this);
    Log.i("MicroMsg.BackupCore", "BackupCore init");
    AppMethodBeat.o(22155);
  }
  
  public static void reset()
  {
    AppMethodBeat.i(22156);
    if (d.csg())
    {
      AppMethodBeat.o(22156);
      return;
    }
    rWT = null;
    com.tencent.mm.plugin.backup.b.a.crT();
    d.csh();
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
    b localb = b.cuQ();
    Log.i("MicroMsg.BackupEventListener", "init addListener");
    localb.rXh = new b.1(localb);
    EventCenter.instance.addListener(localb.rXh);
    localb.rXi = new b.2(localb);
    EventCenter.instance.addListener(localb.rXi);
    localb.rXj = new b.3(localb);
    EventCenter.instance.addListener(localb.rXj);
    bh.getSysCmdMsgExtension().a("MMBakChatNotify", this.rWY, true);
    bh.getSysCmdMsgExtension().a("ChatSync", this.rWZ, true);
    EventCenter.instance.add(this.rWU);
    EventCenter.instance.add(this.rWV);
    EventCenter.instance.add(this.rWW);
    EventCenter.instance.add(this.rWX);
    EventCenter.instance.add(this.rXa);
    AppMethodBeat.o(22157);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(22158);
    b localb = b.cuQ();
    EventCenter.instance.removeListener(localb.rXh);
    EventCenter.instance.removeListener(localb.rXi);
    EventCenter.instance.removeListener(localb.rXj);
    bh.getSysCmdMsgExtension().b("MMBakChatNotify", this.rWY, true);
    bh.getSysCmdMsgExtension().b("ChatSync", this.rWZ, true);
    EventCenter.instance.removeListener(this.rWU);
    EventCenter.instance.removeListener(this.rWV);
    EventCenter.instance.removeListener(this.rWW);
    EventCenter.instance.removeListener(this.rWX);
    EventCenter.instance.removeListener(this.rXa);
    AppMethodBeat.o(22158);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.j.a
 * JD-Core Version:    0.7.0.1
 */