package com.tencent.mm.plugin.backup.j;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.c;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.ac;
import com.tencent.mm.g.a.ag;
import com.tencent.mm.g.a.mr;
import com.tencent.mm.g.a.ms;
import com.tencent.mm.g.a.ms.a;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.cj.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.plugin.q.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.de;
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
  implements bd
{
  private static a oUU;
  private IListener oUV;
  private IListener oUW;
  private IListener oUX;
  private IListener oUY;
  private cj.a oUZ;
  private cj.a oVa;
  private IListener oVb;
  
  public a()
  {
    AppMethodBeat.i(22155);
    this.oUV = new IListener() {};
    this.oUW = new IListener() {};
    this.oUX = new IListener() {};
    this.oUY = new IListener() {};
    this.oUZ = new cj.a()
    {
      public final void a(h.a paramAnonymousa)
      {
        AppMethodBeat.i(22147);
        Log.i("MicroMsg.BackupCore.BackupToPc", "sysMsgListener onreceive sysmsg");
        h.CyF.idkeyStat(400L, 0L, 1L, false);
        String str = (String)XmlParser.parseXml(z.a(paramAnonymousa.heO.KHn), "sysmsg", null).get(".sysmsg.MMBakChatNotify.url");
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
    this.oVa = new cj.a()
    {
      public final void a(final h.a paramAnonymousa)
      {
        AppMethodBeat.i(22149);
        Log.i("MicroMsg.BackupCore.MsgSynchronize", "appMsgListener onreceive appmsg");
        final String str1 = z.a(paramAnonymousa.heO.KHn);
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
        bg.aAk().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(22148);
            Log.i("MicroMsg.BackupCore.MsgSynchronize", "start MsgSynchronizeServer");
            f.rr(false).d(str1, str2, paramAnonymousa);
            AppMethodBeat.o(22148);
          }
        });
        AppMethodBeat.o(22149);
      }
      
      public final void a(h.c paramAnonymousc) {}
    };
    this.oVb = new a.7(this);
    Log.i("MicroMsg.BackupCore", "BackupCore init");
    AppMethodBeat.o(22155);
  }
  
  public static void reset()
  {
    AppMethodBeat.i(22156);
    if (d.ceT())
    {
      AppMethodBeat.o(22156);
      return;
    }
    oUU = null;
    com.tencent.mm.plugin.backup.b.a.ceG();
    d.ceU();
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
    b localb = b.chF();
    Log.i("MicroMsg.BackupEventListener", "init addListener");
    localb.oVi = new b.1(localb);
    EventCenter.instance.addListener(localb.oVi);
    localb.oVj = new b.2(localb);
    EventCenter.instance.addListener(localb.oVj);
    localb.oVk = new b.3(localb);
    EventCenter.instance.addListener(localb.oVk);
    bg.getSysCmdMsgExtension().a("MMBakChatNotify", this.oUZ, true);
    bg.getSysCmdMsgExtension().a("ChatSync", this.oVa, true);
    EventCenter.instance.add(this.oUV);
    EventCenter.instance.add(this.oUW);
    EventCenter.instance.add(this.oUX);
    EventCenter.instance.add(this.oUY);
    EventCenter.instance.add(this.oVb);
    AppMethodBeat.o(22157);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(22158);
    b localb = b.chF();
    EventCenter.instance.removeListener(localb.oVi);
    EventCenter.instance.removeListener(localb.oVj);
    EventCenter.instance.removeListener(localb.oVk);
    bg.getSysCmdMsgExtension().b("MMBakChatNotify", this.oUZ, true);
    bg.getSysCmdMsgExtension().b("ChatSync", this.oVa, true);
    EventCenter.instance.removeListener(this.oUV);
    EventCenter.instance.removeListener(this.oUW);
    EventCenter.instance.removeListener(this.oUX);
    EventCenter.instance.removeListener(this.oUY);
    EventCenter.instance.removeListener(this.oVb);
    AppMethodBeat.o(22158);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.j.a
 * JD-Core Version:    0.7.0.1
 */