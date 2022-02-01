package com.tencent.mm.console;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Debug;
import android.os.Debug.MemoryInfo;
import android.os.Looper;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.a;
import com.tencent.mm.app.WorkerProfile;
import com.tencent.mm.compatible.deviceinfo.ag;
import com.tencent.mm.g.a.bj;
import com.tencent.mm.g.a.bs;
import com.tencent.mm.g.a.bu;
import com.tencent.mm.g.a.cp;
import com.tencent.mm.g.a.cu;
import com.tencent.mm.g.a.cv;
import com.tencent.mm.g.a.cw;
import com.tencent.mm.g.a.cx;
import com.tencent.mm.g.a.hp;
import com.tencent.mm.g.a.hw;
import com.tencent.mm.g.a.ot;
import com.tencent.mm.g.a.td;
import com.tencent.mm.g.a.tg;
import com.tencent.mm.g.a.tr;
import com.tencent.mm.g.a.tx;
import com.tencent.mm.g.a.yc;
import com.tencent.mm.g.a.yh;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.bn.a;
import com.tencent.mm.model.c.a.a;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.u;
import com.tencent.mm.modelmulti.r;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.modelstat.WatchDogPushReceiver;
import com.tencent.mm.platformtools.SpellMap;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.eggspring.ui.SpringCardActivity;
import com.tencent.mm.pluginsdk.g.e.a;
import com.tencent.mm.pluginsdk.n.a;
import com.tencent.mm.pluginsdk.n.b;
import com.tencent.mm.pluginsdk.n.d;
import com.tencent.mm.protocal.protobuf.bsd;
import com.tencent.mm.protocal.protobuf.bse;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bi.a;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.o;
import com.tencent.mm.storage.y;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.ChattingUIFragment;
import com.tencent.mm.ui.chatting.c.as;
import com.tencent.mm.ui.chatting.p;
import com.tencent.xweb.WebView;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import junit.framework.Assert;

public final class b
{
  private static final HashSet<String> fHr;
  
  static
  {
    AppMethodBeat.i(20139);
    com.tencent.mm.console.a.e.init();
    com.tencent.mm.console.a.i.init();
    com.tencent.mm.console.a.j.init();
    com.tencent.mm.console.a.f.init();
    com.tencent.mm.console.a.g.init();
    com.tencent.mm.console.a.c.init();
    com.tencent.mm.console.a.d.init();
    com.tencent.mm.console.a.m.init();
    com.tencent.mm.console.a.h.init();
    com.tencent.mm.console.a.k.init();
    com.tencent.mm.console.a.n.init();
    com.tencent.mm.console.a.l.init();
    try
    {
      Class.forName("com.tencent.mm.console.a.b.a");
      com.tencent.mm.pluginsdk.cmd.b.a(new com.tencent.mm.console.a.a.a(), new String[] { "//fsd" });
      com.tencent.mm.pluginsdk.cmd.b.a(new com.tencent.mm.console.a.a.b(), new String[] { "//hcsetting" });
      com.tencent.mm.pluginsdk.cmd.b.a(new com.tencent.mm.console.a.a(), new String[] { "//clearrecent" });
      com.tencent.mm.console.a.b.init();
      com.tencent.mm.sdcard_migrate.c.init();
      HashSet localHashSet = new HashSet();
      fHr = localHashSet;
      localHashSet.add("//uplog");
      fHr.add("//pullxlog");
      fHr.add("//upcrash");
      fHr.add("//getfpkey");
      fHr.add("//voipdebug");
      fHr.add("//setkey");
      fHr.add("//wxcamera");
      fHr.add("//deletetbs");
      fHr.add("//setNfcOpenUrl");
      AppMethodBeat.o(20139);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.CommandProcessor", localThrowable, "", new Object[0]);
      }
    }
  }
  
  private static boolean C(Context paramContext, String paramString)
  {
    AppMethodBeat.i(20134);
    StringBuffer localStringBuffer = new StringBuffer();
    if (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil(paramString)) {
      localStringBuffer.append(paramString + "\n\n");
    }
    localStringBuffer.append("Default RSA Info:\n");
    localStringBuffer.append("ClientVersion: " + com.tencent.mm.sdk.platformtools.h.glW + "\n");
    localStringBuffer.append("BASE_RSA_PUBLIC_VERSION = 195\n");
    localStringBuffer.append("BASE_RSA_PUBLIC_KEYN = ADF1E9141970B0BB3393C9A7936FD2DF26935F9D74C185D4CDCE4B849CF94AD80D80FA8DD63CF6830E8618BB1AFCE9D8EDE39D946C9A8DF01085E89F398BC36859298FFEB97E271D725B880972712164FE0CD0995ED289A430511B95F16E9740DFDE308A5A7820567909ECCF9E4BD3633AA08496E5B21053BE070DD8B7A9C66B9E28B0F3540CEEC73BC8B40593E4F23F4AF0F9B5B86E1FAF64BA1ABFF83CC78E9ECBED5C8B2DBF1A6C7D9B863C5516DD7E866373F2973A41123D61986732A228F5B4BC96093AE2774CB2E26AA722CC1B9FCE38BB2CB6C9BE63ABC054BA59A451589E3BA3846A0DBE6BA1F0EA90EC960DDF15CD1BD3A73967D3E0816D48E9F159 len(512)\n");
    localStringBuffer.append("BASE_RSA_PUBLIC_KEYE = 010001\n\n");
    localStringBuffer.append("REQ_RSA_PUBLIC_VERSION = 196\n");
    localStringBuffer.append("REQ_RSA_PUBLIC_KEYN = A34137EBF9C9D29B41F54660D0A6C0B9C8C0BFC7F819A1B4E3FEC98978D2703FB9C73E4DBF951E72367C758901D9A9151841C7A3A7C7A80EB86B97B217DB914F6DC9CF58779AF61A2F5BD67AFC258DAF3344DAD934FC4B4AC86599EC13C4A1E264C1A763D571963428A01E344EE2D37588ACFE607880299CE1A558DCE3BDB9A63DAEA5CD661BC1EC287A5142B7DDFCACBB32B62D132EF146FFB92745050E74CB2BD24C3169B760EDED34D4BBFFF6302368DFD51BC80B87328D1C68C34F948A198409E354C230D57E8AC9A14791945280D8D25D748978797B0F0B84AB861F0AF517105527CA3D21B7897798FF1C56BB91DD2BFBC7B1ED24F457BA932A7358CA0B len(512)\n");
    localStringBuffer.append("REQ_RSA_PUBLIC_KEYE = 010001\n");
    ad.i("MicroMsg.CommandProcessor", "summercert dumpdefaultrsa " + localStringBuffer.toString());
    if (!com.tencent.mm.sdk.a.b.eEQ())
    {
      AppMethodBeat.o(20134);
      return false;
    }
    paramString = new TextView(paramContext);
    paramString.setText(localStringBuffer.toString());
    paramString.setGravity(19);
    paramString.setTextSize(1, 10.0F);
    paramString.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    paramString.setTextColor(ao.aD(paramContext, 2130968584));
    paramString.setTypeface(Typeface.MONOSPACE);
    int i = paramContext.getResources().getDimensionPixelSize(2131165575);
    paramString.setPadding(i, i, i, i);
    paramString.setMovementMethod(ScrollingMovementMethod.getInstance());
    com.tencent.mm.ui.base.h.a(paramContext, null, paramString, null);
    if (com.tencent.mm.protocal.ac.eCc()) {
      Toast.makeText(paramContext, "dump file:" + com.tencent.mm.loader.j.b.aih() + "DefaultRSA.java", 1).show();
    }
    AppMethodBeat.o(20134);
    return true;
  }
  
  public static boolean h(final Context paramContext, final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(20133);
    if (!paramString1.startsWith("//"))
    {
      AppMethodBeat.o(20133);
      return false;
    }
    if ((1 < ad.getLogLevel()) && (!pK(paramString1)))
    {
      ad.i("MicroMsg.CommandProcessor", "summer processed log level[%s], need open debug ret false", new Object[] { Integer.valueOf(ad.getLogLevel()) });
      AppMethodBeat.o(20133);
      return false;
    }
    if (com.tencent.mm.pluginsdk.cmd.b.J(paramContext, paramString1, paramString2))
    {
      AppMethodBeat.o(20133);
      return true;
    }
    if (paramString1.startsWith("//clearWXSNSDB"))
    {
      paramContext = new td();
      com.tencent.mm.sdk.b.a.ESL.l(paramContext);
      AppMethodBeat.o(20133);
      return true;
    }
    if (paramString1.startsWith("//verifytokenerror"))
    {
      com.tencent.mm.platformtools.ab.hWz = true;
      AppMethodBeat.o(20133);
      return true;
    }
    if (paramString1.startsWith("//testcrash"))
    {
      paramContext = new IllegalArgumentException("test exception.");
      AppMethodBeat.o(20133);
      throw paramContext;
    }
    if (paramString1.startsWith("//nativeLibraries"))
    {
      com.tencent.mm.sdk.b.eEM();
      AppMethodBeat.o(20133);
      return true;
    }
    if (paramString1.startsWith("//testLqt"))
    {
      paramContext = paramString1.split(" ");
      if (paramContext.length == 2) {
        if (com.tencent.mm.sdk.platformtools.bt.getInt(paramContext[1], 0) != 1) {
          break label238;
        }
      }
      label238:
      for (com.tencent.mm.platformtools.ab.hWE = true;; com.tencent.mm.platformtools.ab.hWE = false)
      {
        AppMethodBeat.o(20133);
        return true;
      }
    }
    if (paramString1.startsWith("//resetbackupdata"))
    {
      az.arV();
      com.tencent.mm.model.c.afk().set(ae.a.FmV, Boolean.FALSE);
      az.arV();
      com.tencent.mm.model.c.afk().set(ae.a.FmW, Boolean.FALSE);
      az.arV();
      com.tencent.mm.model.c.afk().set(ae.a.FmX, Boolean.FALSE);
      az.arV();
      com.tencent.mm.model.c.afk().set(ae.a.FmY, Boolean.FALSE);
      az.arV();
      com.tencent.mm.model.c.afk().set(ae.a.FmZ, Boolean.FALSE);
      az.arV();
      com.tencent.mm.model.c.afk().set(ae.a.Fna, Boolean.FALSE);
      az.arV().aqq().cWA();
      az.arV().aqr().cWA();
      az.arV().aqp().cWA();
      Toast.makeText(com.tencent.mm.sdk.platformtools.aj.getContext(), "backup data has been reset!", 1).show();
      AppMethodBeat.o(20133);
      return true;
    }
    if (paramString1.startsWith("//backuptest"))
    {
      paramContext = new com.tencent.mm.g.a.ac();
      paramContext.dbU.dbV = 1;
      com.tencent.mm.sdk.b.a.ESL.l(paramContext);
      AppMethodBeat.o(20133);
      return true;
    }
    if (paramString1.startsWith("//startmerge"))
    {
      paramContext = new com.tencent.mm.g.a.ac();
      paramContext.dbU.dbV = 2;
      com.tencent.mm.sdk.b.a.ESL.l(paramContext);
      AppMethodBeat.o(20133);
      return true;
    }
    if (paramString1.startsWith("//deletemerge"))
    {
      paramContext = new com.tencent.mm.g.a.ac();
      paramContext.dbU.dbV = 3;
      com.tencent.mm.sdk.b.a.ESL.l(paramContext);
      AppMethodBeat.o(20133);
      return true;
    }
    if (paramString1.startsWith("//resetliveverify"))
    {
      ax.aFD("tag_live_core").putBoolean("anchor_verify", false);
      AppMethodBeat.o(20133);
      return true;
    }
    if (paramString1.startsWith("//open livefaceverify"))
    {
      ax.aFD("tag_live_core").putBoolean("test_mmkv_live_face_verify", true);
      AppMethodBeat.o(20133);
      return true;
    }
    if (paramString1.startsWith("//close livefaceverify"))
    {
      ax.aFD("tag_live_core").putBoolean("test_mmkv_live_face_verify", false);
      AppMethodBeat.o(20133);
      return true;
    }
    if (paramString1.startsWith("//skip livemobileverify"))
    {
      ax.aFD("tag_live_core").putBoolean("test_mmkv_live_skip_mobile_verify", true);
      AppMethodBeat.o(20133);
      return true;
    }
    if (paramString1.startsWith("//reset livemobileverify"))
    {
      ax.aFD("tag_live_core").putBoolean("test_mmkv_live_skip_mobile_verify", false);
      AppMethodBeat.o(20133);
      return true;
    }
    if (paramString1.startsWith("//delete livetipsbar"))
    {
      ((com.tencent.mm.live.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.live.a.class)).getLiveTipsBarStorage().cWA();
      AppMethodBeat.o(20133);
      return true;
    }
    if (paramString1.startsWith("//add livetipsbar"))
    {
      paramContext = new com.tencent.mm.live.b.c.a();
      paramContext.field_hostRoomId = ChattingUIFragment.FeN;
      paramString1 = new Random();
      paramContext.field_liveId = paramString1.nextInt();
      paramContext.field_liveName = Integer.toString(paramString1.nextInt(23546));
      paramContext.field_thumbUrl = "";
      paramContext.field_anchorUsername = u.aqG();
      paramContext.field_isSender = false;
      paramContext.field_timeStamp = System.currentTimeMillis();
      ((com.tencent.mm.live.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.live.a.class)).getLiveTipsBarStorage().a(paramContext);
      AppMethodBeat.o(20133);
      return true;
    }
    if (paramString1.startsWith("//threadpool replace"))
    {
      if (paramString1.startsWith("//threadpool replace false")) {
        com.tencent.mm.sdk.platformtools.aj.eFE().edit().putBoolean("REPLACE_WORKER_BOOLEAN", false).commit();
      }
      for (;;)
      {
        AppMethodBeat.o(20133);
        return true;
        if (paramString1.startsWith("//threadpool replace true")) {
          com.tencent.mm.sdk.platformtools.aj.eFE().edit().putBoolean("REPLACE_WORKER_BOOLEAN", true).commit();
        }
      }
    }
    if (paramString1.equalsIgnoreCase("//ftsmsbiz"))
    {
      paramString2 = com.tencent.mm.plugin.websearch.api.af.eib();
      paramString1 = new StringBuilder();
      paramString2 = paramString2.mAL.iterator();
      while (paramString2.hasNext())
      {
        localObject1 = (bsd)paramString2.next();
        paramString1.append(String.format("%s | %.2f | %s", new Object[] { com.tencent.mm.model.v.sh(((bsd)localObject1).Username), Double.valueOf(((bsd)localObject1).DPA), com.tencent.mm.pluginsdk.g.h.formatTime("yyyy-MM-dd HH:mm", ((bsd)localObject1).DPB / 1000L) }));
        paramString1.append("\n");
      }
      paramString2 = new TextView(paramContext);
      paramString2.setText(paramString1.toString());
      paramString2.setGravity(19);
      paramString2.setTextSize(1, 10.0F);
      paramString2.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
      paramString2.setTextColor(ao.aD(paramContext, 2130968584));
      paramString2.setTypeface(Typeface.MONOSPACE);
      i = paramContext.getResources().getDimensionPixelSize(2131165480);
      paramString2.setPadding(i, i, i, i);
      com.tencent.mm.ui.base.h.a(paramContext, null, paramString2, null);
      AppMethodBeat.o(20133);
      return true;
    }
    if (paramString1.startsWith("//cleanww"))
    {
      ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).aFw();
      AppMethodBeat.o(20133);
      return true;
    }
    if (com.tencent.mm.sdk.a.b.eEQ())
    {
      if (paramString1.startsWith("//launchapp clear"))
      {
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.FnL, "");
        AppMethodBeat.o(20133);
        return true;
      }
      if (paramString1.startsWith("//setsupportwxcode"))
      {
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fpa, Boolean.TRUE);
        AppMethodBeat.o(20133);
        return true;
      }
      if (paramString1.startsWith("//setnotsupportwxcode"))
      {
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fpa, Boolean.FALSE);
        AppMethodBeat.o(20133);
        return true;
      }
      if (paramString1.startsWith("//resetsupportwxcode"))
      {
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fpa, null);
        AppMethodBeat.o(20133);
        return true;
      }
    }
    if (paramString1.startsWith("//testsightwidget"))
    {
      paramString1 = new Intent();
      paramString1.putExtra("KSightPath", "/mnt/sdcard/tencent/tempvideo4.mp4");
      paramString1.putExtra("KSightThumbPath", "");
      paramString1.putExtra("sight_md5", com.tencent.mm.vfs.i.aEN("/mnt/sdcard/tencent/tempvideo4.mp4"));
      paramString1.putExtra("KSnsPostManu", true);
      paramString1.putExtra("KTouchCameraTime", com.tencent.mm.sdk.platformtools.bt.aGK());
      paramString1.putExtra("Ksnsupload_type", 14);
      com.tencent.mm.bs.d.b(paramContext, "sns", ".ui.SnsUploadUI", paramString1);
      AppMethodBeat.o(20133);
      return true;
    }
    if (paramString1.startsWith("//openremitbank"))
    {
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.FrG, Integer.valueOf(1));
      AppMethodBeat.o(20133);
      return true;
    }
    if (paramString1.startsWith("//chatroomdebug "))
    {
      if (paramString1.substring(paramString1.indexOf(" ") + 1).equalsIgnoreCase("true")) {
        ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).setDebugMode(true);
      }
      for (;;)
      {
        AppMethodBeat.o(20133);
        return true;
        ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).setDebugMode(false);
      }
    }
    if (paramString1.startsWith("//angerbag"))
    {
      if (((String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Ftt, "0")).equals("0")) {}
      for (paramContext = "1";; paramContext = "0")
      {
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.Ftt, paramContext);
        AppMethodBeat.o(20133);
        return true;
      }
    }
    if (paramString1.startsWith("//clearbag"))
    {
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fts, "");
      AppMethodBeat.o(20133);
      return true;
    }
    if (paramString1.startsWith("//closeremitbank"))
    {
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.FrG, Integer.valueOf(0));
      AppMethodBeat.o(20133);
      return true;
    }
    if (paramString1.startsWith("//ftstemplatetest"))
    {
      paramString2 = new com.tencent.mm.g.a.bk();
      paramString2.ddG.ddH = 27;
      paramString2.ddG.ddH = 1;
      paramString2.ddG.filePath = "/sdcard/fts_template.zip";
      com.tencent.mm.sdk.b.a.ESL.l(paramString2);
    }
    if (paramString1.startsWith("//sightforward"))
    {
      paramString1 = new Intent();
      paramString1.setClassName(paramContext, "com.tencent.mm.ui.transmit.SightForwardUI");
      paramString1 = new com.tencent.mm.hellhoundlib.b.a().bd(paramString1);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString1.adn(), "com/tencent/mm/console/CommandProcessor", "processed", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString1.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/console/CommandProcessor", "processed", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(20133);
      return true;
    }
    if (paramString1.startsWith("//remit"))
    {
      com.tencent.mm.bs.d.b(paramContext, "remittance", ".ui.RemittanceBusiUI", new Intent());
      AppMethodBeat.o(20133);
      return true;
    }
    if (paramString1.startsWith("//fixtools"))
    {
      paramString1 = new Intent();
      paramString1.setClassName(paramContext, "com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUI");
      paramString1.putExtra("entry_fix_tools", 2);
      paramString1 = new com.tencent.mm.hellhoundlib.b.a().bd(paramString1);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString1.adn(), "com/tencent/mm/console/CommandProcessor", "processed", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString1.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/console/CommandProcessor", "processed", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(20133);
      return true;
    }
    if (paramString1.startsWith("//uplog"))
    {
      paramString1 = new Intent();
      paramString1.setClassName(paramContext, "com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUplogUI");
      paramString1.putExtra("entry_fix_tools_uplog", 5);
      MMWizardActivity.V(paramContext, paramString1);
      AppMethodBeat.o(20133);
      return true;
    }
    if (paramString1.startsWith("//pullxlog"))
    {
      ad.moveLogsFromCacheDirToLogDir();
      Toast.makeText(paramContext, "move success", 0).show();
      AppMethodBeat.o(20133);
      return true;
    }
    if (paramString1.startsWith("//upcrash"))
    {
      paramContext = "weixin";
      if (az.afw()) {
        paramContext = u.aqG();
      }
      paramString2 = paramString1.split(" ");
      j = 0;
      i = 0;
      paramString1 = paramContext;
      if (paramString2 != null)
      {
        if (paramString2.length > 1) {
          i = com.tencent.mm.sdk.platformtools.bt.getInt(paramString2[1], 0);
        }
        paramString1 = paramContext;
        j = i;
        if (paramString2.length > 2)
        {
          paramString1 = paramString2[2];
          j = i;
        }
      }
      az.aeS().b(new bn(new bn.a()
      {
        public final void a(com.tencent.mm.network.e paramAnonymouse)
        {
          AppMethodBeat.i(20104);
          az.aeS().a(3, this.fHs, j, az.afw());
          AppMethodBeat.o(20104);
        }
      }));
      AppMethodBeat.o(20133);
      return true;
    }
    if (paramString1.startsWith("//fixError0831"))
    {
      ad.i("MicroMsg.CommandProcessor", "fixError0831");
      com.tencent.mm.sdk.b.a.ESL.l(new bs());
      AppMethodBeat.o(20133);
      return true;
    }
    if (paramString1.startsWith("//resetbankremit"))
    {
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.FrH, Integer.valueOf(0));
      AppMethodBeat.o(20133);
      return true;
    }
    if (paramString1.startsWith("//busiluck "))
    {
      paramString1 = "weixin://openNativeUrl/weixinHB/startreceivebizhbrequest?sendid=".concat(String.valueOf(paramString1.replace("//busiluck ", "")));
      paramString2 = new Intent();
      paramString2.putExtra("key_way", 5);
      paramString2.putExtra("key_native_url", paramString1);
      com.tencent.mm.bs.d.b(paramContext, "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", paramString2);
      AppMethodBeat.o(20133);
      return true;
    }
    if (paramString1.startsWith("//testsoter"))
    {
      paramString1 = new Intent();
      paramString1.setClassName(com.tencent.mm.sdk.platformtools.aj.getPackageName(), "com.tencent.mm.plugin.soter.ui.SoterTestUI");
      paramString1 = new com.tencent.mm.hellhoundlib.b.a().bd(paramString1);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString1.adn(), "com/tencent/mm/console/CommandProcessor", "processed", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString1.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/console/CommandProcessor", "processed", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(20133);
      return true;
    }
    if (paramString1.startsWith("//facevideo"))
    {
      paramContext = paramString1.split(" ");
      if (paramContext.length == 3)
      {
        com.tencent.mm.model.ay.gNa.aD("imgType", paramContext[1]);
        com.tencent.mm.model.ay.gNa.aD("depth", paramContext[2]);
      }
      AppMethodBeat.o(20133);
      return true;
    }
    if (paramString1.startsWith("//alpha"))
    {
      paramContext = paramString1.split(" ");
      if (paramContext.length == 2) {
        com.tencent.mm.model.ay.gNa.aD("alpha_duration", paramContext[1]);
      }
      AppMethodBeat.o(20133);
      return true;
    }
    if (paramString1.startsWith("//forceNotifyError"))
    {
      paramContext = paramString1.split(" ");
      if (paramContext.length == 2) {
        ((com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.forcenotify.a.b.class)).ly(paramContext[1].equalsIgnoreCase("true"));
      }
      AppMethodBeat.o(20133);
      return true;
    }
    if (paramString1.startsWith("//rectwidth"))
    {
      paramContext = paramString1.split(" ");
      if (paramContext.length == 2) {
        com.tencent.mm.model.ay.gNa.aD("rect_width", paramContext[1]);
      }
      AppMethodBeat.o(20133);
      return true;
    }
    if (paramString1.startsWith("//clearnewtips"))
    {
      com.tencent.mm.plugin.newtips.a.cWu().cWA();
      AppMethodBeat.o(20133);
      return true;
    }
    if (paramString1.startsWith("//clearfavoffline"))
    {
      com.tencent.mm.plugin.fav.offline.a.a.IN();
      AppMethodBeat.o(20133);
      return true;
    }
    if (paramString1.startsWith("//newyearsw "))
    {
      az.arV();
      i = ((Integer)com.tencent.mm.model.c.afk().get(ae.a.FgG, Integer.valueOf(0))).intValue();
      az.arV();
      com.tencent.mm.model.c.afk().set(ae.a.FgG, Integer.valueOf(i ^ 0x1));
      AppMethodBeat.o(20133);
      return true;
    }
    if (paramString1.startsWith("//commitxlog"))
    {
      az.aeS().a(1, "", 0, false);
      ad.eFw();
      AppMethodBeat.o(20133);
      return true;
    }
    if (paramString1.startsWith("//open neattextview"))
    {
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.FrL, Boolean.TRUE);
      AppMethodBeat.o(20133);
      return true;
    }
    if (paramString1.startsWith("//close neattextview"))
    {
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.FrL, Boolean.FALSE);
      AppMethodBeat.o(20133);
      return true;
    }
    if (paramString1.startsWith("//unprint specialtext"))
    {
      com.tencent.mm.ui.widget.MMNeat7extView.HzC = false;
      AppMethodBeat.o(20133);
      return true;
    }
    if (paramString1.startsWith("//print specialtext"))
    {
      com.tencent.mm.ui.widget.MMNeat7extView.HzC = true;
      AppMethodBeat.o(20133);
      return true;
    }
    if (paramString1.startsWith("//netstatus"))
    {
      paramString1 = com.tencent.mm.sdk.platformtools.ay.iv(com.tencent.mm.sdk.platformtools.aj.getContext());
      com.tencent.mm.ui.base.h.d(paramContext, paramString1, "netstatus", paramContext.getString(2131764863), paramContext.getString(2131757558), new b.9(paramContext, paramString1), null);
      AppMethodBeat.o(20133);
      return true;
    }
    if (paramString1.startsWith("//scaninterval "))
    {
      paramString2 = paramString1.split(" ");
      l1 = -1L;
    }
    try
    {
      l2 = com.tencent.mm.sdk.platformtools.bt.getLong(paramString2[1], -1L);
      l1 = l2;
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        long l2;
        continue;
        paramString1 = null;
        continue;
        Object localObject2 = null;
        paramString2 = paramString1;
        paramString1 = (String)localObject2;
        continue;
        paramString1 = null;
        continue;
        paramString1 = null;
        localObject1 = null;
        continue;
        paramString2 = "disable";
      }
    }
    if (l1 > 0L)
    {
      az.arV();
      com.tencent.mm.model.c.afk().set(ae.a.FmO, Long.valueOf(l1));
      ad.i("MicroMsg.CommandProcessor", "summerclean reset scaninterval[%d]", new Object[] { Long.valueOf(l1) });
      AppMethodBeat.o(20133);
      return true;
    }
    if (paramString1.startsWith("//scanwait "))
    {
      paramString2 = paramString1.split(" ");
      l1 = -1L;
    }
    try
    {
      l2 = com.tencent.mm.sdk.platformtools.bt.getLong(paramString2[1], -1L);
      l1 = l2;
    }
    catch (Exception paramString2)
    {
      label3041:
      boolean bool1;
      boolean bool3;
      boolean bool2;
      boolean bool4;
      break label3041;
    }
    if (l1 > 0L)
    {
      az.arV();
      com.tencent.mm.model.c.afk().set(ae.a.FmP, Long.valueOf(l1));
      ad.i("MicroMsg.CommandProcessor", "summerclean reset scanwait[%d]", new Object[] { Long.valueOf(l1) });
      AppMethodBeat.o(20133);
      return true;
    }
    if (paramString1.equalsIgnoreCase("//delayquery"))
    {
      if (!com.tencent.mm.platformtools.ab.hWC) {}
      for (bool1 = true;; bool1 = false)
      {
        com.tencent.mm.platformtools.ab.hWC = bool1;
        AppMethodBeat.o(20133);
        return true;
      }
    }
    if (paramString1.startsWith("//newinit -hard"))
    {
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afB().afk().set(15, Integer.valueOf(0));
      AppMethodBeat.o(20133);
      return true;
    }
    if (paramString1.startsWith("//websearch-widget-draw "))
    {
      paramContext = paramString1.split("\\s+");
      if (paramContext.length == 2) {
        ((com.tencent.mm.plugin.websearch.api.j)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.websearch.api.j.class)).RV(com.tencent.mm.sdk.platformtools.bt.aGh(paramContext[1].trim()));
      }
      AppMethodBeat.o(20133);
      return true;
    }
    if (paramString1.equalsIgnoreCase("//swipe"))
    {
      paramContext = com.tencent.mm.sdk.platformtools.aj.eFE();
      bool1 = paramContext.getBoolean("settings_support_swipe", true);
      paramContext = paramContext.edit();
      if (!bool1) {}
      for (bool1 = true;; bool1 = false)
      {
        paramContext.putBoolean("settings_support_swipe", bool1).commit();
        AppMethodBeat.o(20133);
        return true;
      }
    }
    if (paramString1.equalsIgnoreCase("//multiwebview"))
    {
      paramContext = LauncherUI.getInstance().getSharedPreferences(com.tencent.mm.sdk.platformtools.aj.eFD(), 0);
      bool1 = paramContext.getBoolean("settings_multi_webview", false);
      if (bool1)
      {
        paramContext = paramContext.edit();
        if (bool1) {
          break label3374;
        }
      }
      label3374:
      for (bool1 = true;; bool1 = false)
      {
        paramContext.putBoolean("settings_multi_webview", bool1).commit();
        AppMethodBeat.o(20133);
        return true;
      }
    }
    if (paramString1.equalsIgnoreCase("//sightinfo"))
    {
      az.arV();
      bool1 = ((Boolean)com.tencent.mm.model.c.afk().get(344065, Boolean.FALSE)).booleanValue();
      az.arV();
      paramContext = com.tencent.mm.model.c.afk();
      if (!bool1) {}
      for (bool1 = true;; bool1 = false)
      {
        paramContext.set(344065, Boolean.valueOf(bool1));
        az.arV();
        com.tencent.mm.model.c.afk().eKy();
        AppMethodBeat.o(20133);
        return true;
      }
    }
    if (paramString1.startsWith("//sighttest"))
    {
      i = com.tencent.mm.sdk.platformtools.bt.aGh(paramString1.replace("//sighttest ", ""));
      az.arV();
      com.tencent.mm.model.c.afk().set(344066, Integer.valueOf(i));
      az.arV();
      com.tencent.mm.model.c.afk().eKy();
      AppMethodBeat.o(20133);
      return true;
    }
    if (paramString1.startsWith("//wxcamera"))
    {
      i = com.tencent.mm.sdk.platformtools.bt.aGh(paramString1.replace("//wxcamera ", ""));
      ad.i("MicroMsg.CommandProcessor", "set param %d", new Object[] { Integer.valueOf(i) });
      az.arV();
      com.tencent.mm.model.c.afk().set(ae.a.Fmv, Integer.valueOf(i));
      AppMethodBeat.o(20133);
      return true;
    }
    if (paramString1.startsWith("//printcrash"))
    {
      paramString1 = paramString1.replace("//printcrash ", "");
      paramString2 = new TextView(paramContext);
      paramString2.setText(lm(com.tencent.mm.sdk.platformtools.bt.getInt(paramString1, 0)));
      paramString2.setGravity(19);
      paramString2.setTextSize(1, 8.0F);
      paramString2.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
      paramString2.setTextColor(ao.aD(paramContext, 2130968584));
      paramString2.setTypeface(Typeface.MONOSPACE);
      i = paramContext.getResources().getDimensionPixelSize(2131165575);
      paramString2.setPadding(i, i, i, i);
      paramString2.setMovementMethod(ScrollingMovementMethod.getInstance());
      com.tencent.mm.ui.base.h.a(paramContext, null, paramString2, null);
      AppMethodBeat.o(20133);
      return true;
    }
    if (paramString1.startsWith("//printleak"))
    {
      paramString1 = new TextView(paramContext);
      paramString1.setText(com.tencent.mm.compatible.b.g.Wn());
      paramString1.setGravity(19);
      paramString1.setTextSize(1, 8.0F);
      paramString1.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
      paramString1.setTextColor(ao.aD(paramContext, 2130968584));
      paramString1.setTypeface(Typeface.MONOSPACE);
      i = paramContext.getResources().getDimensionPixelSize(2131165575);
      paramString1.setPadding(i, i, i, i);
      paramString1.setMovementMethod(ScrollingMovementMethod.getInstance());
      com.tencent.mm.ui.base.h.a(paramContext, null, paramString1, null);
      AppMethodBeat.o(20133);
      return true;
    }
    if (paramString1.startsWith("//resetmapcnt"))
    {
      az.arV();
      com.tencent.mm.model.c.afk().set(ae.a.Fpb, Integer.valueOf(0));
      AppMethodBeat.o(20133);
      return true;
    }
    if (paramString1.equals("//testrsa"))
    {
      com.tencent.mm.protocal.ac.af("010001", "E338E5DAD46B331E3071FAFD4C0F84C7C7965DBBE64C6F8CC0F7CF04DC640C1F84A2014431A48D65F2B2F172BA9BE6F5A049BF52C78C14B0965E20F0D80D85A9180EBABB913D49821D28BFD9601DF52A4F3230AECAD96D23415F5E94D51A87CAA7630C5F3CB70345BAF572A4F61A134A2265AFD8FADDFE0222BD9ABF7DBEB7444D031454E8F21820BBC725E6857F765660E987FADEBCF6B3A15355C4CD3752A7B544D1D7E037AF4F9725BE37681A84C9E1DC431B3065294EAD53E913BAF16D46714B013EA077191E6CA08ABA6D70E9CA792D898D692E3168D6341369976657CD5E1504B9E2458F107225176734D11621AD36D7FFA26C573D6612455B09105C41", 106);
      AppMethodBeat.o(20133);
      return true;
    }
    if (paramString1.equals("//testrsabad"))
    {
      com.tencent.mm.protocal.ac.af("010001", "F338E5DAD46B331E3071FAFD4C0F84C7C7965DBBE64C6F8CC0F7CF04DC640C1F84A2014431A48D65F2B2F172BA9BE6F5A049BF52C78C14B0965E20F0D80D85A9180EBABB913D49821D28BFD9601DF52A4F3230AECAD96D23415F5E94D51A87CAA7630C5F3CB70345BAF572A4F61A134A2265AFD8FADDFE0222BD9ABF7DBEB7444D031454E8F21820BBC725E6857F765660E987FADEBCF6B3A15355C4CD3752A7B544D1D7E037AF4F9725BE37681A84C9E1DC431B3065294EAD53E913BAF16D46714B013EA077191E6CA08ABA6D70E9CA792D898D692E3168D6341369976657CD5E1504B9E2458F107225176734D11621AD36D7FFA26C573D6612455B09105C41", 106);
      AppMethodBeat.o(20133);
      return true;
    }
    if (paramString1.equals("//walletofflinetest"))
    {
      az.arV();
      com.tencent.mm.model.c.afk().set(ae.a.FlY, Boolean.FALSE);
      AppMethodBeat.o(20133);
      return false;
    }
    if (paramString1.startsWith("//makemsgdata "))
    {
      i = com.tencent.mm.sdk.platformtools.bt.getInt(paramString1.split(" ")[1], 0);
      az.arV();
      com.tencent.mm.model.c.apO().aC(ChattingUIFragment.FeN, i);
      AppMethodBeat.o(20133);
      return true;
    }
    if (paramString1.startsWith("//pullappservice"))
    {
      com.tencent.mm.pluginsdk.model.app.aq.evU().hf(com.tencent.mm.sdk.platformtools.aj.getContext());
      AppMethodBeat.o(20133);
      return true;
    }
    if (paramString1.startsWith("//boundaryconfig"))
    {
      ad.i("MicroMsg.CommandProcessor", "boundaryconfig SessionTextMsg:%d", new Object[] { Integer.valueOf(com.tencent.mm.sdk.platformtools.bt.getInt(com.tencent.mm.m.g.Zd().getValue("InputLimitSessionTextMsg"), 0)) });
      ad.i("MicroMsg.CommandProcessor", "boundaryconfig SNSObjectText:%d", new Object[] { Integer.valueOf(com.tencent.mm.sdk.platformtools.bt.getInt(com.tencent.mm.m.g.Zd().getValue("InputLimitSNSObjectText"), 0)) });
      ad.i("MicroMsg.CommandProcessor", "boundaryconfig SnsCommentMaxSize:%d", new Object[] { Integer.valueOf(com.tencent.mm.sdk.platformtools.bt.getInt(com.tencent.mm.m.g.Zd().getValue("SnsCommentMaxSize"), 0)) });
      ad.i("MicroMsg.CommandProcessor", "boundaryconfig FavText:%d", new Object[] { Integer.valueOf(com.tencent.mm.sdk.platformtools.bt.getInt(com.tencent.mm.m.g.Zd().getValue("InputLimitFavText"), 0)) });
      ad.i("MicroMsg.CommandProcessor", "boundaryconfig EmotionBufSize:%d", new Object[] { Integer.valueOf(com.tencent.mm.sdk.platformtools.bt.getInt(com.tencent.mm.m.g.Zd().getValue("InputLimitSendEmotionBufSize"), 0)) });
      ad.i("MicroMsg.CommandProcessor", "boundaryconfig EmotionWidth:%d", new Object[] { Integer.valueOf(com.tencent.mm.sdk.platformtools.bt.getInt(com.tencent.mm.m.g.Zd().getValue("InputLimitSendEmotionWidth"), 0)) });
      ad.i("MicroMsg.CommandProcessor", "boundaryconfig FavImageSize:%d", new Object[] { Integer.valueOf(com.tencent.mm.sdk.platformtools.bt.getInt(com.tencent.mm.m.g.Zd().getValue("InputLimitFavImageSize"), 0)) });
      ad.i("MicroMsg.CommandProcessor", "boundaryconfig FavVoiceLength:%d", new Object[] { Integer.valueOf(com.tencent.mm.sdk.platformtools.bt.getInt(com.tencent.mm.m.g.Zd().getValue("InputLimitFavVoiceLength"), 0)) });
      ad.i("MicroMsg.CommandProcessor", "boundaryconfig ShortVideoAutoDownloadBufSize:%d", new Object[] { Integer.valueOf(com.tencent.mm.sdk.platformtools.bt.getInt(com.tencent.mm.m.g.Zd().getValue("InputLimitSessionShortVideoBufSize"), 0)) });
      ad.i("MicroMsg.CommandProcessor", "boundaryconfig VideoSize:%d", new Object[] { Integer.valueOf(com.tencent.mm.sdk.platformtools.bt.getInt(com.tencent.mm.m.g.Zd().getValue("InputLimitVideoSize"), 0)) });
      ad.i("MicroMsg.CommandProcessor", "boundaryconfig FileSize:%d", new Object[] { Integer.valueOf(com.tencent.mm.sdk.platformtools.bt.getInt(com.tencent.mm.m.g.Zd().getValue("InputLimitFileSize"), 0)) });
      AppMethodBeat.o(20133);
      return true;
    }
    if (paramString1.startsWith("//cleanapk"))
    {
      com.tencent.mm.plugin.clean.c.d.bNV();
      AppMethodBeat.o(20133);
      return true;
    }
    if (paramString1.startsWith("//whatsnew"))
    {
      MMAppMgr.aY((Activity)paramContext);
      AppMethodBeat.o(20133);
      return true;
    }
    if (paramString1.startsWith("//profile "))
    {
      az.arV();
      paramString1 = com.tencent.mm.model.c.apM().aHY(paramString1.replace("//profile ", "").trim());
      if ((paramString1 != null) && (paramString1.ZV() != 0))
      {
        paramString2 = new Intent();
        paramString2.putExtra("Contact_User", paramString1.getUsername());
        com.tencent.mm.bs.d.b(paramContext, "profile", ".ui.ContactInfoUI", paramString2);
      }
      AppMethodBeat.o(20133);
      return true;
    }
    if (paramString1.startsWith("//minigameupdate"))
    {
      az.arV();
      com.tencent.mm.model.c.afk().set(ae.a.Fgf, Long.valueOf(0L));
      AppMethodBeat.o(20133);
      return true;
    }
    if (com.tencent.mm.sdk.a.b.eEQ())
    {
      if (paramString1.startsWith("//cs"))
      {
        paramContext = new Intent();
        paramContext.putExtra("voipCSBizId", "gh_b35727b00b78");
        paramContext.putExtra("voipCSAppId", "wx6e7147e8d764e85d");
        com.tencent.mm.bs.d.b(com.tencent.mm.sdk.platformtools.aj.getContext(), "voip_cs", ".ui.VoipCSMainUI", paramContext);
        AppMethodBeat.o(20133);
        return true;
      }
      if (paramString1.startsWith("//acs"))
      {
        paramContext = new Intent();
        paramContext.putExtra("voipCSBizId", "gh_e8b085bb67e0");
        paramContext.putExtra("voipCSAppId", "wx1224160e0adcefd6");
        com.tencent.mm.bs.d.b(com.tencent.mm.sdk.platformtools.aj.getContext(), "voip_cs", ".ui.VoipCSMainUI", paramContext);
        AppMethodBeat.o(20133);
        return true;
      }
      if (paramString1.startsWith("//wifiset"))
      {
        paramContext = new Intent();
        paramContext.putExtra("free_wifi_ssid", "Xiaomi_WENDY");
        paramContext.putExtra("free_wifi_passowrd", "WX12345789");
        com.tencent.mm.bs.d.b(com.tencent.mm.sdk.platformtools.aj.getContext(), "freewifi", ".ui.FreeWifiCopyPwdUI", paramContext);
        AppMethodBeat.o(20133);
        return true;
      }
      if (paramString1.startsWith("//bcs"))
      {
        paramContext = new Intent();
        paramContext.putExtra("voipCSBizId", "gh_e8b085bb67e0");
        paramContext.putExtra("voipCSAppId", "wx1224160e0adcefd6");
        paramContext.putExtra("voipCSAllowBackCamera", "1");
        paramContext.putExtra("voipCSShowOther", "1");
        paramContext.putExtra("voipCSAvatarUrl", "https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=28737416,3249768666&fm=58");
        paramContext.putExtra("voipCSContext", "test");
        com.tencent.mm.bs.d.b(com.tencent.mm.sdk.platformtools.aj.getContext(), "voip_cs", ".ui.VoipCSMainUI", paramContext);
        AppMethodBeat.o(20133);
        return true;
      }
    }
    if (paramString1.startsWith("//getfpkey"))
    {
      paramString1 = com.tencent.mm.storage.bt.eMY();
      com.tencent.mm.ui.base.h.d(paramContext, paramString1, "Fingerprint Key", paramContext.getString(2131764863), paramContext.getString(2131757558), new b.10(paramContext, paramString1), null);
      AppMethodBeat.o(20133);
      return true;
    }
    if (paramString1.startsWith("//commitwd"))
    {
      WatchDogPushReceiver.aBR();
      AppMethodBeat.o(20133);
      return true;
    }
    if (paramString1.startsWith("//setsnstestenv"))
    {
      localObject2 = paramString1.split(" +");
      paramString2 = null;
      if (localObject2.length <= 1) {
        break label19948;
      }
      localObject1 = localObject2[1];
      if ((!com.tencent.mm.sdk.platformtools.v.isIPv4Address((String)localObject1)) && (!com.tencent.mm.sdk.platformtools.v.isIPv6Address((String)localObject1))) {
        break label19948;
      }
      if (localObject2.length <= 2) {
        break label19943;
      }
      paramString1 = localObject2[2];
      if ((!com.tencent.mm.sdk.platformtools.v.isIPv4Address(paramString1)) && (!com.tencent.mm.sdk.platformtools.v.isIPv6Address(paramString1))) {
        break label19943;
      }
      if (localObject2.length > 3)
      {
        localObject2 = localObject2[3];
        paramString2 = paramString1;
        paramString1 = (String)localObject2;
        if (localObject1 != null) {}
        for (bool1 = true;; bool1 = false)
        {
          com.tencent.mm.platformtools.ab.hVV = bool1;
          com.tencent.mm.platformtools.ab.hVM = (String)localObject1;
          com.tencent.mm.platformtools.ab.hWt = paramString2;
          com.tencent.mm.platformtools.ab.hWu = paramString1;
          com.tencent.mm.ao.f.awI().nN(5);
          Toast.makeText(paramContext, String.format("%s %s %s", new Object[] { com.tencent.mm.platformtools.ab.hVM, com.tencent.mm.platformtools.ab.hWt, com.tencent.mm.platformtools.ab.hWu }), 1).show();
          AppMethodBeat.o(20133);
          return true;
        }
      }
    }
    else
    {
      if (paramString1.startsWith("//snsvcodec"))
      {
        paramContext = paramString1.split(" +");
        if (paramContext.length > 1)
        {
          paramContext = paramContext[1];
          if ("on".equalsIgnoreCase(paramContext))
          {
            ln(1);
            ad.i("MicroMsg.CommandProcessor", "snsvcodec val: 1");
          }
        }
        for (;;)
        {
          AppMethodBeat.o(20133);
          return true;
          if ("off".equalsIgnoreCase(paramContext))
          {
            ln(0);
            ad.i("MicroMsg.CommandProcessor", "snsvcodec val: 0");
            continue;
            ln(-1);
            ad.i("MicroMsg.CommandProcessor", "snsvcodec val: -1");
          }
        }
      }
      if (paramString1.startsWith("//snswxpc"))
      {
        paramContext = paramString1.split(" +");
        if (paramContext.length > 1)
        {
          paramContext = paramContext[1];
          if ("on".equalsIgnoreCase(paramContext))
          {
            lo(1);
            ad.i("MicroMsg.CommandProcessor", "snswxpc val: 1");
          }
        }
        for (;;)
        {
          AppMethodBeat.o(20133);
          return true;
          if ("off".equalsIgnoreCase(paramContext))
          {
            lo(0);
            ad.i("MicroMsg.CommandProcessor", "snswxpc val: 0");
            continue;
            lo(-1);
            ad.i("MicroMsg.CommandProcessor", "snswxpc val: -1");
          }
        }
      }
      if (paramString1.startsWith("//mmdumpsys"))
      {
        com.tencent.e.h.Iye.aP(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(20124);
            new av(new b.11.1(this), true).av(10000L, 10000L);
            AppMethodBeat.o(20124);
          }
        });
        AppMethodBeat.o(20133);
        return true;
      }
      if (paramString1.startsWith("//remittance reset"))
      {
        az.arV();
        com.tencent.mm.model.c.afk().set(327729, "0");
        AppMethodBeat.o(20133);
        return true;
      }
      if (paramString1.startsWith("//wv "))
      {
        paramString1 = paramString1.replace("//wv ", "");
        paramString2 = new Intent();
        paramString2.putExtra("rawUrl", paramString1);
        com.tencent.mm.bs.d.b(paramContext, "webview", ".ui.tools.WebViewUI", paramString2);
        AppMethodBeat.o(20133);
        return true;
      }
      if (paramString1.startsWith("//wvjsapi "))
      {
        paramString1 = paramString1.replace("//wvjsapi ", "");
        paramString2 = new Intent();
        paramString2.putExtra("rawUrl", paramString1);
        com.tencent.mm.bs.d.b(paramContext, "webview", ".ui.tools.WebViewTestUI", paramString2);
        AppMethodBeat.o(20133);
        return true;
      }
      if (paramString1.startsWith("//setibeacontabuinopen"))
      {
        if (az.afw())
        {
          az.arV();
          com.tencent.mm.model.c.afk().set(ae.a.FjE, Integer.valueOf(1));
          AppMethodBeat.o(20133);
          return true;
        }
        AppMethodBeat.o(20133);
        return false;
      }
      if (paramString1.startsWith("//setibeacontabuinclose"))
      {
        if (az.afw())
        {
          az.arV();
          com.tencent.mm.model.c.afk().set(ae.a.FjE, Integer.valueOf(0));
          AppMethodBeat.o(20133);
          return true;
        }
        AppMethodBeat.o(20133);
        return false;
      }
      if (paramString1.startsWith("//setibeaconpushopen"))
      {
        if (az.afw())
        {
          az.arV();
          com.tencent.mm.model.c.afk().set(ae.a.Fjz, Boolean.TRUE);
          AppMethodBeat.o(20133);
          return true;
        }
        AppMethodBeat.o(20133);
        return false;
      }
      if (paramString1.startsWith("//setibeaconpushclose"))
      {
        if (az.afw())
        {
          az.arV();
          com.tencent.mm.model.c.afk().set(ae.a.Fjz, Boolean.FALSE);
          AppMethodBeat.o(20133);
          return true;
        }
        AppMethodBeat.o(20133);
        return false;
      }
      if (paramString1.startsWith("//ibeacon"))
      {
        bool1 = false;
        bool3 = false;
        if (Build.VERSION.SDK_INT >= 18) {
          bool1 = true;
        }
        paramString1 = BluetoothAdapter.getDefaultAdapter();
        bool2 = bool3;
        if (paramString1 != null)
        {
          bool2 = bool3;
          if (paramString1.getState() == 12) {
            bool2 = true;
          }
        }
        bool4 = paramContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
        if ((bool1) && (bool2) && (bool4)) {}
        for (bool3 = true;; bool3 = false)
        {
          paramString1 = "isNowSupportedIbeacon:" + bool3 + "\n\nisSystemSupported:" + bool1 + "\nisBlueStateOn:" + bool2 + "\nisSupportedBLE:" + bool4 + "\nSDK:" + Build.VERSION.SDK_INT + "\nModel:" + Build.BRAND + "-" + Build.MODEL + "\noperatingSystemInfo:" + Build.VERSION.RELEASE;
          com.tencent.mm.ui.base.h.d(paramContext, paramString1, "TestResult", paramContext.getString(2131757150), paramContext.getString(2131757558), new b.12(paramContext, paramString1), null);
          AppMethodBeat.o(20133);
          return true;
        }
      }
      if (paramString1.startsWith("//gettbs"))
      {
        bool1 = com.tencent.mm.compatible.deviceinfo.ae.fFz.fFM;
        paramString1 = paramContext.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
        paramString2 = paramString1.getString("tbs_download", null);
        localObject1 = paramString1.getString("tbs_webview_disable", null);
        bool2 = paramString1.getBoolean("x5_jscore_enabled", false);
        i = WebView.getInstalledTbsCoreVersion(paramContext);
        j = WebView.getTbsSDKVersion(paramContext);
        Toast.makeText(paramContext, String.format("forceSys:%b\ntbs_download:%s\ntbs_disable:%s\ntbs_disable_min_sdk_version:%s\ntbs_disable_max_sdk_version:%s\ntbsCoreVersion:%d\ntbsSdkVersion:%d\nx5JsCoreEnabled:%b", new Object[] { Boolean.valueOf(bool1), paramString2, localObject1, paramString1.getString("tbs_webview_min_sdk_version", null), paramString1.getString("tbs_webview_max_sdk_version", null), Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool2) }), 1).show();
        AppMethodBeat.o(20133);
        return true;
      }
      if (paramString1.startsWith("//deletetbs"))
      {
        paramString1 = new Intent();
        paramString1.setComponent(new ComponentName(com.tencent.mm.sdk.platformtools.aj.getPackageName(), "com.tencent.mm.booter.MMReceivers$SandBoxProcessReceiver"));
        paramContext.sendBroadcast(paramString1);
        paramContext = paramContext.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit();
        paramContext.putLong("last_check_ts", 0L);
        paramContext.apply();
        az.arV();
        com.tencent.mm.model.c.afk().set(ae.a.FkD, Boolean.FALSE);
        AppMethodBeat.o(20133);
        return true;
      }
      if (paramString1.startsWith("//tbsDisableOverScroll"))
      {
        paramString2 = paramContext.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit();
        try
        {
          paramContext = paramString1.substring(paramString1.indexOf(":") + 1);
          paramString2.putBoolean("tbs_disable_over_scroll", Boolean.parseBoolean(paramContext));
          paramString2.apply();
          AppMethodBeat.o(20133);
          return true;
        }
        catch (IndexOutOfBoundsException paramContext)
        {
          for (;;)
          {
            paramContext = "";
          }
        }
      }
      if (paramString1.startsWith("//enabletbs"))
      {
        paramString2 = paramContext.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit();
        paramString1 = paramString1.replace("//enabletbs ", "");
        if ("1".equals(paramString1)) {}
        for (paramContext = "0";; paramContext = "1")
        {
          paramString2.putString("tbs_webview_disable", paramContext);
          if ("0".equals(paramString1))
          {
            paramString2.putString("tbs_webview_min_sdk_version", "0");
            paramString2.putString("tbs_webview_max_sdk_version", "0");
          }
          paramString2.apply();
          AppMethodBeat.o(20133);
          return true;
        }
      }
      if (paramString1.startsWith("//wvsha1"))
      {
        paramString2 = paramContext.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit();
        try
        {
          paramContext = paramString1.substring(paramString1.indexOf(":") + 1);
          paramString2.putBoolean("wvsha1", Boolean.parseBoolean(paramContext));
          paramString2.apply();
          AppMethodBeat.o(20133);
          return true;
        }
        catch (IndexOutOfBoundsException paramContext)
        {
          for (;;)
          {
            paramContext = "";
          }
        }
      }
      if (paramString1.startsWith("//channelId")) {
        com.tencent.mm.ui.base.h.R(paramContext, com.tencent.mm.sdk.platformtools.i.cJR, "channelId");
      }
      if (paramString1.startsWith("//traceroute"))
      {
        com.tencent.mm.bs.d.O(paramContext, "traceroute", ".ui.NetworkDiagnoseIntroUI");
        AppMethodBeat.o(20133);
        return true;
      }
      if (paramString1.startsWith("//testoom"))
      {
        i = 0;
        while (i < 20)
        {
          Bitmap.createBitmap(1024, 1920, Bitmap.Config.ARGB_8888);
          i += 1;
        }
        if (com.tencent.mm.compatible.util.d.lf(23))
        {
          Debug.getMemoryInfo(new Debug.MemoryInfo());
          ad.i("MicroMsg.CommandProcessor", "testoom %s", new Object[] { Long.valueOf(Runtime.getRuntime().totalMemory()), Long.valueOf(Runtime.getRuntime().freeMemory()) });
        }
        AppMethodBeat.o(20133);
        return true;
      }
      if (paramString1.startsWith("//qzone "))
      {
        paramString2 = paramString1.replace("//qzone ", "");
        new com.tencent.mm.pluginsdk.ui.applet.ac(paramContext).aCb(paramString2);
      }
      if (paramString1.startsWith("//dumpcrash"))
      {
        com.tencent.mm.vfs.i.lE(com.tencent.mm.loader.j.b.ahZ() + "crash/", com.tencent.mm.loader.j.b.aii());
        AppMethodBeat.o(20133);
        return true;
      }
      if (paramString1.startsWith("//dumpanr"))
      {
        com.tencent.mm.vfs.i.lE("/data/anr/", com.tencent.mm.loader.j.b.aii());
        AppMethodBeat.o(20133);
        return true;
      }
      if (paramString1.startsWith("//testanr"))
      {
        com.tencent.mm.model.bi.asf();
        AppMethodBeat.o(20133);
        return true;
      }
      if (paramString1.startsWith("//opensnsadRightbar"))
      {
        com.tencent.mm.platformtools.ab.hVL = true;
        AppMethodBeat.o(20133);
        return true;
      }
      if (paramString1.startsWith("//setlocation "))
      {
        paramContext = paramString1.split(" ");
        if ((paramContext != null) && (com.tencent.mm.sdk.a.b.eEQ()))
        {
          com.tencent.mm.platformtools.ab.hVb = true;
          if (paramContext.length > 0) {
            com.tencent.mm.platformtools.ab.lat = com.tencent.mm.sdk.platformtools.bt.getDouble(paramContext[1], 0.0D);
          }
          if (paramContext.length > 1) {
            com.tencent.mm.platformtools.ab.lng = com.tencent.mm.sdk.platformtools.bt.getDouble(paramContext[2], 0.0D);
          }
          AppMethodBeat.o(20133);
          return true;
        }
        AppMethodBeat.o(20133);
        return false;
      }
      if (paramString1.startsWith("//switchsdcard"))
      {
        paramString1 = com.tencent.mm.sdk.platformtools.bi.eGt();
        j = paramString1.size();
        ad.i("MicroMsg.CommandProcessor", "switchsdcard sdcard size = ".concat(String.valueOf(j)));
        if ((j > 0) && (paramString1.get(0) != null) && (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil(((bi.a)paramString1.get(0)).EWM)))
        {
          i = 0;
          while (i < j)
          {
            ad.i("MicroMsg.CommandProcessor", "switchsdcard list i = " + i + " StatMountParse: " + paramString1.get(i));
            i += 1;
          }
        }
        i = 0;
        for (;;)
        {
          if (i >= j) {
            break label19927;
          }
          if (!((bi.a)paramString1.get(i)).EWM.equals(com.tencent.mm.loader.j.b.aib()))
          {
            paramString1 = ((bi.a)paramString1.get(i)).EWM;
            paramString2 = (Activity)paramContext;
            ad.i("MicroMsg.CommandProcessor", "switchsdcard newSdcard: ".concat(String.valueOf(paramString1)));
            if (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil(paramString1)) {
              break;
            }
            com.tencent.mm.ui.base.h.cd(paramContext, paramContext.getString(2131764337));
            AppMethodBeat.o(20133);
            return true;
          }
          i += 1;
        }
        com.tencent.mm.ui.base.h.d(paramContext, paramContext.getString(2131764338), "", paramContext.getString(2131755835), paramContext.getString(2131755691), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(20126);
            paramAnonymousDialogInterface = new com.tencent.mm.storage.aa(com.tencent.mm.storage.ae.FfH + "SdcardInfo.cfg");
            paramAnonymousDialogInterface.set(1, this.fHH);
            ad.i("MicroMsg.CommandProcessor", "switchsdcard reset to sdcard root: " + paramAnonymousDialogInterface.get(1));
            an.aFy("welcome_page_show");
            com.tencent.mm.kernel.l.o(paramContext, true);
            paramAnonymousDialogInterface = new com.tencent.mm.g.a.aa();
            paramAnonymousDialogInterface.dbS.dbT = false;
            com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousDialogInterface);
            WorkerProfile.Lt().cNr.Lo();
            az.getNotification().TU();
            com.tencent.mm.cr.d.aNr("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
            if (com.tencent.mm.pluginsdk.g.e.BRG != null) {
              com.tencent.mm.pluginsdk.g.e.BRG.bw(paramString2);
            }
            paramString2.finish();
            AppMethodBeat.o(20126);
          }
        }, null);
        AppMethodBeat.o(20133);
        return true;
      }
      if (paramString1.startsWith("//getip"))
      {
        az.aeS().b(new bn(new bn.a()
        {
          public final void a(com.tencent.mm.network.e paramAnonymouse)
          {
            AppMethodBeat.i(20127);
            if (paramAnonymouse == null)
            {
              AppMethodBeat.o(20127);
              return;
            }
            String[] arrayOfString = paramAnonymouse.getIPsString(true);
            int i = 0;
            while (i < arrayOfString.length)
            {
              ad.d("MicroMsg.CommandProcessor", "dkip long:%d  %s", new Object[] { Integer.valueOf(i), arrayOfString[i] });
              ad.d("MicroMsg.CommandProcessor", "dkip long:%d %s", new Object[] { Integer.valueOf(i), com.tencent.mm.network.a.c.Bd(arrayOfString[i]).toString() });
              i += 1;
            }
            paramAnonymouse = paramAnonymouse.getIPsString(false);
            i = 0;
            while (i < paramAnonymouse.length)
            {
              ad.d("MicroMsg.CommandProcessor", "dkip short:%d %s", new Object[] { Integer.valueOf(i), paramAnonymouse[i] });
              ad.d("MicroMsg.CommandProcessor", "dkip long:%d %s", new Object[] { Integer.valueOf(i), com.tencent.mm.network.a.c.Bd(paramAnonymouse[i]).toString() });
              i += 1;
            }
            AppMethodBeat.o(20127);
          }
        }));
        AppMethodBeat.o(20133);
        return true;
      }
      if (paramString1.startsWith("//localjsapi"))
      {
        paramString1 = "file://" + com.tencent.mm.loader.j.b.aih() + "test_jsapi.html";
        ad.v("MicroMsg.CommandProcessor", "alvinluo path: %s", new Object[] { paramString1 });
        paramString2 = new Intent();
        paramString2.putExtra("rawUrl", paramString1);
        com.tencent.mm.bs.d.b(paramContext, "webview", ".ui.tools.WebViewUI", paramString2);
        AppMethodBeat.o(20133);
        return true;
      }
      if (paramString1.startsWith("//getlocalkey"))
      {
        paramString1 = com.tencent.mm.storage.bt.eMX();
        com.tencent.mm.ui.base.h.d(paramContext, paramString1, "Fingerprint Key", paramContext.getString(2131764863), paramContext.getString(2131757558), new b.15(paramContext, paramString1), null);
        AppMethodBeat.o(20133);
        return true;
      }
      if (paramString1.startsWith("//getdevid"))
      {
        paramString1 = com.tencent.mm.compatible.deviceinfo.q.Xa();
        com.tencent.mm.ui.base.h.d(paramContext, paramString1, "devid", paramContext.getString(2131757150), paramContext.getString(2131757558), new b.16(paramContext, paramString1), null);
        AppMethodBeat.o(20133);
        return true;
      }
      if (paramString1.startsWith("//testhtml"))
      {
        paramString1 = new Intent();
        paramString1.putExtra("rawUrl", "file:///android_asset/jsapi/reader_test1.html");
        com.tencent.mm.bs.d.b(paramContext, "webview", ".ui.tools.WebViewUI", paramString1);
        AppMethodBeat.o(20133);
        return true;
      }
      if (paramString1.startsWith("//testlocalhtml "))
      {
        paramString1 = paramString1.replace("//testlocalhtml ", "");
        paramString2 = new Intent();
        paramString2.putExtra("rawUrl", "file://".concat(String.valueOf(paramString1)));
        paramString2.putExtra("neverGetA8Key", true);
        com.tencent.mm.bs.d.b(paramContext, "webview", ".ui.tools.WebViewUI", paramString2);
        AppMethodBeat.o(20133);
        return true;
      }
      if (paramString1.startsWith("//setkey"))
      {
        if (com.tencent.mm.storage.bt.aJi(paramString1.replace("//setkey", ""))) {
          Toast.makeText(paramContext, 2131764814, 0).show();
        }
        AppMethodBeat.o(20133);
        return true;
      }
      if (paramString1.startsWith("//tinker"))
      {
        ad.d("shortlink", "tinker update");
        com.tencent.mm.plugin.hp.b.g.cGa();
        AppMethodBeat.o(20133);
        return true;
      }
      if (paramString1.startsWith("//checkspell"))
      {
        paramString1 = paramString1.replace("//checkspell ", "");
        if (com.tencent.mm.sdk.platformtools.bt.isNullOrNil(paramString1))
        {
          AppMethodBeat.o(20133);
          return true;
        }
        paramString2 = new StringBuilder();
        i = 0;
        while (i < paramString1.length())
        {
          paramString2.append("[" + paramString1.charAt(i) + ":" + SpellMap.v(paramString1.charAt(i)) + "]");
          i += 1;
        }
        com.tencent.mm.ui.base.h.R(paramContext, paramString2.toString(), "Check Spell");
        AppMethodBeat.o(20133);
        return true;
      }
      if (paramString1.startsWith("//gallery "))
      {
        paramString1 = paramString1.replace("//gallery ", "");
        if (com.tencent.mm.sdk.platformtools.bt.isNullOrNil(paramString1))
        {
          AppMethodBeat.o(20133);
          return true;
        }
        paramContext.getSharedPreferences(com.tencent.mm.sdk.platformtools.aj.eFD(), 0).edit().putString("gallery", paramString1).commit();
        AppMethodBeat.o(20133);
        return true;
      }
      if (paramString1.startsWith("//svgtag"))
      {
        paramContext = paramString1.replace("//svgtag ", "");
        if (paramContext.equals("on")) {
          com.tencent.mm.ce.e.uz(true);
        }
        for (;;)
        {
          AppMethodBeat.o(20133);
          return true;
          if (paramContext.equals("off")) {
            com.tencent.mm.ce.e.uz(false);
          }
        }
      }
      if (paramString1.startsWith("//svgcode")) {}
      try
      {
        paramContext = paramString1.replace("//svgcode ", "");
        if (!paramContext.equals("on")) {
          paramContext.equals("off");
        }
        paramContext = Class.forName("com.tencent.mm.BuildConfig");
        paramString1 = paramContext.getDeclaredField("SVGCode");
        paramString1.setAccessible(true);
        bool1 = paramString1.getBoolean(paramContext);
      }
      catch (ClassNotFoundException paramContext)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.CommandProcessor", paramContext, "", new Object[0]);
          bool1 = false;
        }
      }
      catch (NoSuchFieldException paramContext)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.CommandProcessor", paramContext, "", new Object[0]);
          bool1 = false;
        }
      }
      catch (IllegalAccessException paramContext)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.CommandProcessor", paramContext, "", new Object[0]);
          bool1 = false;
        }
      }
      catch (IllegalArgumentException paramContext)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.CommandProcessor", paramContext, "", new Object[0]);
          bool1 = false;
        }
        if (!paramString1.startsWith("//testMbanner")) {
          break label8076;
        }
        try
        {
          paramContext = paramString1.replace("//testMbanner ", "").split(",");
          if (paramContext.length < 2) {
            break label8068;
          }
          com.tencent.mm.model.bh.asb().a(new com.tencent.mm.model.bg(Integer.valueOf(paramContext[0]).intValue(), Integer.valueOf(paramContext[1]).intValue(), null));
          AppMethodBeat.o(20133);
          return true;
          if (!paramString1.startsWith("//testrsa")) {
            break label8097;
          }
          com.tencent.mm.protocal.ac.af("010001", "E338E5DAD46B331E3071FAFD4C0F84C7C7965DBBE64C6F8CC0F7CF04DC640C1F84A2014431A48D65F2B2F172BA9BE6F5A049BF52C78C14B0965E20F0D80D85A9180EBABB913D49821D28BFD9601DF52A4F3230AECAD96D23415F5E94D51A87CAA7630C5F3CB70345BAF572A4F61A134A2265AFD8FADDFE0222BD9ABF7DBEB7444D031454E8F21820BBC725E6857F765660E987FADEBCF6B3A15355C4CD3752A7B544D1D7E037AF4F9725BE37681A84C9E1DC431B3065294EAD53E913BAF16D46714B013EA077191E6CA08ABA6D70E9CA792D898D692E3168D6341369976657CD5E1504B9E2458F107225176734D11621AD36D7FFA26C573D6612455B09105C41", 106);
          if (!paramString1.startsWith("//recomT")) {
            break label8137;
          }
          try
          {
            paramContext = paramString1.replace("//recomT ", "");
            az.arV().aqk().a(paramContext, true, null);
            AppMethodBeat.o(20133);
            return true;
            if (!paramString1.startsWith("//recomF")) {
              break label8177;
            }
            try
            {
              paramContext = paramString1.replace("//recomF ", "");
              az.arV().aqk().a(paramContext, false, null);
              AppMethodBeat.o(20133);
              return true;
              if (!paramString1.startsWith("//resetwxpayagree")) {
                break label8214;
              }
              com.tencent.mm.kernel.g.afC();
              com.tencent.mm.kernel.g.afB().afk().set(ae.a.FsX, Boolean.FALSE);
              AppMethodBeat.o(20133);
              return true;
              if (!paramString1.startsWith("//ffmpeg")) {
                break label8353;
              }
              try
              {
                i = paramString1.indexOf("-r ");
                j = paramString1.indexOf("-b ");
                paramContext = paramString1.substring(i + 3, j);
                paramString1 = paramString1.substring(j + 3);
                float f = com.tencent.mm.sdk.platformtools.bt.getFloat(paramContext.trim(), 0.0F);
                i = com.tencent.mm.sdk.platformtools.bt.getInt(paramString1.trim(), 0);
                com.tencent.mm.plugin.sight.base.c.wrb = i;
                com.tencent.mm.plugin.sight.base.c.wrc = f;
                Toast.makeText(com.tencent.mm.sdk.platformtools.aj.getContext(), "set C2C video encode frame rate " + f + " bitrate " + i, 0).show();
                AppMethodBeat.o(20133);
                return true;
              }
              catch (Exception paramContext)
              {
                for (;;)
                {
                  Toast.makeText(com.tencent.mm.sdk.platformtools.aj.getContext(), "set C2C video frame rate fail, please ensure your command.", 1).show();
                }
              }
              if (!paramString1.startsWith("//onlinevideo")) {
                break label8460;
              }
              for (;;)
              {
                try
                {
                  i = com.tencent.mm.sdk.platformtools.bt.getInt(paramString1.replace("//onlinevideo ", ""), 0);
                  az.arV();
                  com.tencent.mm.model.c.afk().set(ae.a.FlX, Integer.valueOf(i));
                  if (i <= 0) {
                    continue;
                  }
                  paramContext = "online video";
                  Toast.makeText(com.tencent.mm.sdk.platformtools.aj.getContext(), paramContext, 0).show();
                }
                catch (Exception paramContext)
                {
                  ad.printErrStackTrace("MicroMsg.CommandProcessor", paramContext, "", new Object[0]);
                  Toast.makeText(com.tencent.mm.sdk.platformtools.aj.getContext(), "set online video fail, please ensure your command.", 1).show();
                  continue;
                }
                AppMethodBeat.o(20133);
                return true;
                paramContext = "offline video";
              }
              if (!paramString1.startsWith("//hevcinfo")) {
                break label8526;
              }
              paramContext = com.tencent.mm.plugin.o.f.cPn();
              paramString1 = ChattingUIFragment.FeN;
              paramString2 = new bl();
              paramString2.nY(paramString1);
              paramString2.jV(2);
              paramString2.setType(1);
              paramString2.kY(System.currentTimeMillis());
              paramString2.setContent(paramContext);
              com.tencent.mm.model.bi.u(paramString2);
              AppMethodBeat.o(20133);
              return true;
              if (!paramString1.startsWith("//presns")) {
                break label8576;
              }
              com.tencent.e.h.Iye.q(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(20105);
                  com.tencent.mm.sdk.b.a.ESL.l(new tr());
                  AppMethodBeat.o(20105);
                }
              }, 3000L);
              Toast.makeText(com.tencent.mm.sdk.platformtools.aj.getContext(), "preload sns", 0).show();
              AppMethodBeat.o(20133);
              return true;
              if (!paramString1.startsWith("//calcwxdata")) {
                break label8624;
              }
              az.arV();
              com.tencent.mm.model.c.afk().set(ae.a.Fpi, Long.valueOf(0L));
              Toast.makeText(com.tencent.mm.sdk.platformtools.aj.getContext(), "calc wx data success", 0).show();
              AppMethodBeat.o(20133);
              return true;
              if (!paramString1.startsWith("//checkspace")) {
                break label8732;
              }
              try
              {
                i = com.tencent.mm.sdk.platformtools.bt.getInt(paramString1.replace("//checkspace ", ""), 0);
                paramContext = new bj();
                paramContext.ddE.ddF = i;
                com.tencent.mm.sdk.b.a.ESL.l(paramContext);
                Toast.makeText(com.tencent.mm.sdk.platformtools.aj.getContext(), "check space code ".concat(String.valueOf(i)), 0).show();
                AppMethodBeat.o(20133);
                return true;
              }
              catch (Exception paramContext)
              {
                for (;;)
                {
                  ad.printErrStackTrace("MicroMsg.CommandProcessor", paramContext, "", new Object[0]);
                  Toast.makeText(com.tencent.mm.sdk.platformtools.aj.getContext(), "check space code fail, please ensure your command.", 1).show();
                }
              }
              if ((!paramString1.startsWith("//showkv")) || (!com.tencent.mm.sdk.a.b.eEQ())) {
                break label8816;
              }
              try
              {
                paramString2 = new Intent();
                paramString2.addFlags(268435456);
                paramString2.addFlags(524288);
                ((com.tencent.mm.plugin.kitchen.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.kitchen.a.a.class)).H(paramContext, paramString2);
                AppMethodBeat.o(20133);
                return true;
              }
              catch (Exception paramString2)
              {
                ad.e("MicroMsg.CommandProcessor", "showkv error [%s]", new Object[] { paramString2.toString() });
              }
              if ((!paramString1.startsWith("//showexpt")) || (!com.tencent.mm.sdk.a.b.eEQ())) {
                break label8862;
              }
              ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).r(paramContext, new Intent());
              AppMethodBeat.o(20133);
              return true;
              if ((!paramString1.startsWith("//resetvfs")) || (!com.tencent.mm.sdk.a.b.eEQ())) {
                break label8943;
              }
              ax.aFC("VFSStrategy").encode("VFSSwitch", false);
              ax.aFC("extmig_status_memo_storage").clear().commit();
              ax.aFC("extmig_switch_storage").clear().commit();
              Toast.makeText(com.tencent.mm.sdk.platformtools.aj.getContext(), "vfsSwitch close", 1).show();
              AppMethodBeat.o(20133);
              return true;
              if ((!paramString1.startsWith("//openvfs")) || (!com.tencent.mm.sdk.a.b.eEQ())) {
                break label9008;
              }
              ax.aFC("VFSStrategy").encode("VFSSwitch", true);
              ax.aFC("extmig_switch_storage").encode("is_routine_enabled", true);
              Toast.makeText(com.tencent.mm.sdk.platformtools.aj.getContext(), "vfsSwitch open", 1).show();
              AppMethodBeat.o(20133);
              return true;
              if ((!paramString1.startsWith("//showroomexpt")) || (!com.tencent.mm.sdk.a.b.eEQ())) {
                break label9054;
              }
              ((com.tencent.mm.plugin.expt.roomexpt.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.roomexpt.d.class)).s(paramContext, new Intent());
              AppMethodBeat.o(20133);
              return true;
              if (!paramString1.startsWith("//upfacemodel")) {
                break label9088;
              }
              az.aeS().b(new com.tencent.mm.pluginsdk.h.a.a.m(42));
              AppMethodBeat.o(20133);
              return true;
              if (!paramString1.startsWith("//facett")) {
                break label9122;
              }
              az.arV();
              com.tencent.mm.model.c.afk().set(ae.a.FnO, Boolean.FALSE);
              AppMethodBeat.o(20133);
              return true;
              if (!paramString1.startsWith("//startstory")) {
                break label9144;
              }
              com.tencent.mm.platformtools.ab.hWH = true;
              AppMethodBeat.o(20133);
              return true;
              if (!paramString1.startsWith("//axauth")) {
                break label9181;
              }
              com.tencent.mm.kernel.g.afA().aeS().aeW().avg().ave();
              AppMethodBeat.o(20133);
              return true;
              if (!paramString1.startsWith("//timeout")) {
                break label9244;
              }
              paramContext = paramString1.replace("//timeout ", "");
              ad.i("MicroMsg.CommandProcessor", "set session timeouot cgi %s", new Object[] { paramContext });
              com.tencent.mm.network.t.hKT = paramContext;
              com.tencent.mm.kernel.g.afA().aeS().aeW().wo(paramContext);
              AppMethodBeat.o(20133);
              return true;
              if (!paramString1.startsWith("//switchpaytype")) {
                break label9332;
              }
              paramContext = paramString1.split(" ");
              if ((paramContext == null) || (paramContext.length < 2)) {
                break label9324;
              }
              try
              {
                i = com.tencent.mm.sdk.platformtools.bt.getInt(paramContext[1], 0);
                az.arV();
                com.tencent.mm.model.c.afk().set(339975, Integer.valueOf(i));
                AppMethodBeat.o(20133);
                return true;
              }
              catch (Exception paramContext)
              {
                ad.e("MicroMsg.CommandProcessor", "hy: switch wallet type error");
                AppMethodBeat.o(20133);
                return false;
              }
              AppMethodBeat.o(20133);
              return false;
              if (!paramString1.startsWith("//setNfcOpenUrl ")) {
                break label9402;
              }
              paramString1 = paramString1.replace("//setNfcOpenUrl ", "");
              paramString2 = com.tencent.mm.sdk.platformtools.aj.eFF().edit();
              paramContext = paramString1;
              if (!paramString1.equalsIgnoreCase("null")) {
                break label9376;
              }
              paramContext = "";
              paramString2.putString("nfc_open_url", paramContext);
              paramString2.commit();
              AppMethodBeat.o(20133);
              return true;
              if (!paramString1.startsWith("//setMBV8Debug ")) {
                break label9481;
              }
              paramContext = paramString1.replace("//setMBV8Debug ", "");
              paramString1 = com.tencent.mm.sdk.platformtools.aj.eFF().edit();
              if (!paramContext.equalsIgnoreCase("true")) {
                break label9467;
              }
              paramString1.putBoolean("appbrandgame_open_v8debug", true);
              for (;;)
              {
                paramString1.commit();
                AppMethodBeat.o(20133);
                return true;
                paramString1.putBoolean("appbrandgame_open_v8debug", false);
              }
              if (!paramString1.startsWith("//setWcwss ")) {
                break label9551;
              }
              paramString1 = paramString1.replace("//setWcwss ", "");
              paramString2 = com.tencent.mm.sdk.platformtools.aj.eFF().edit();
              paramContext = paramString1;
              if (!paramString1.equalsIgnoreCase("null")) {
                break label9525;
              }
              paramContext = "";
              paramString2.putString("appbrandgame_open_wcwss", paramContext);
              paramString2.commit();
              AppMethodBeat.o(20133);
              return true;
              if (!paramString1.startsWith("//setNativeWss ")) {
                break label9621;
              }
              paramString1 = paramString1.replace("//setNativeWss ", "");
              paramString2 = com.tencent.mm.sdk.platformtools.aj.eFF().edit();
              paramContext = paramString1;
              if (!paramString1.equalsIgnoreCase("null")) {
                break label9595;
              }
              paramContext = "";
              paramString2.putString("appbrandgame_open_nativewss", paramContext);
              paramString2.commit();
              AppMethodBeat.o(20133);
              return true;
              if (!paramString1.startsWith("//setCdnRequest ")) {
                break label9691;
              }
              paramString1 = paramString1.replace("//setCdnRequest ", "");
              paramString2 = com.tencent.mm.sdk.platformtools.aj.eFF().edit();
              paramContext = paramString1;
              if (!paramString1.equalsIgnoreCase("null")) {
                break label9665;
              }
              paramContext = "";
              paramString2.putString("appbrandgame_open_cdnrequest", paramContext);
              paramString2.commit();
              AppMethodBeat.o(20133);
              return true;
              if (!paramString1.startsWith("//setCronetDownload ")) {
                break label9761;
              }
              paramString1 = paramString1.replace("//setCronetDownload ", "");
              paramString2 = com.tencent.mm.sdk.platformtools.aj.eFF().edit();
              paramContext = paramString1;
              if (!paramString1.equalsIgnoreCase("null")) {
                break label9735;
              }
              paramContext = "";
              paramString2.putString("appbrandgame_open_cronetdownload", paramContext);
              paramString2.commit();
              AppMethodBeat.o(20133);
              return true;
              if (!paramString1.startsWith("//setNativeLibuv ")) {
                break label9831;
              }
              paramString1 = paramString1.replace("//setNativeLibuv ", "");
              paramString2 = com.tencent.mm.sdk.platformtools.aj.eFF().edit();
              paramContext = paramString1;
              if (!paramString1.equalsIgnoreCase("null")) {
                break label9805;
              }
              paramContext = "";
              paramString2.putString("appbrandgame_open_nativelibuv", paramContext);
              paramString2.commit();
              AppMethodBeat.o(20133);
              return true;
              if (!paramString1.startsWith("//reportfailip ")) {
                break label9880;
              }
              paramContext = paramString1.replace("//reportfailip ", "");
              com.tencent.mm.kernel.g.afA().aeS().aeW().reportV6Status(paramContext.equals("1"));
              AppMethodBeat.o(20133);
              return true;
              if (!paramString1.startsWith("//forcev6 ")) {
                break label9929;
              }
              paramContext = paramString1.replace("//forcev6 ", "");
              com.tencent.mm.kernel.g.afA().aeS().aeW().forceUseV6(paramContext.equals("1"));
              AppMethodBeat.o(20133);
              return true;
              if (!paramString1.startsWith("//active ")) {
                break label9978;
              }
              paramContext = paramString1.replace("//active ", "");
              com.tencent.mm.kernel.g.afA().aeS().aeW().switchProcessActiveState(paramContext.equals("1"));
              AppMethodBeat.o(20133);
              return true;
              if (!paramString1.startsWith("//gamecb ")) {
                break label10105;
              }
              paramContext = paramString1.replace("//gamecb ", "").trim();
              paramString1 = com.tencent.mm.sdk.platformtools.aj.eFF().edit();
              i = com.tencent.mm.sdk.platformtools.bt.aGh(paramContext);
              paramString1.putInt("appbrandgame_use_commandbuffer", i);
              paramString2 = com.tencent.mm.sdk.platformtools.aj.getContext();
              localObject1 = new StringBuilder("小游戏 CommandBuffer ");
              if (i != 0) {
                break label10085;
              }
              paramContext = "关闭";
              for (;;)
              {
                Toast.makeText(paramString2, paramContext, 1).show();
                paramString1.commit();
                AppMethodBeat.o(20133);
                return true;
                if (i == -1) {
                  paramContext = "默认";
                } else {
                  paramContext = "开启";
                }
              }
              if (!paramString1.startsWith("//gamecp ")) {
                break label10283;
              }
              paramContext = paramString1.replace("//gamecp ", "").trim();
              paramString1 = com.tencent.mm.sdk.platformtools.aj.eFF().edit();
              int k = com.tencent.mm.sdk.platformtools.bt.aGh(paramContext);
              paramString1.putInt("appbrandgame_cmd_pool_type", k);
              if (k >= -1) {
                break label10242;
              }
              i = 1;
              if (k <= 2) {
                break label10248;
              }
              j = 1;
              if ((j | i) == 0) {
                break label10184;
              }
              k = -1;
              paramString2 = com.tencent.mm.sdk.platformtools.aj.getContext();
              localObject1 = new StringBuilder("小游戏 cmd pool ");
              if (k != -1) {
                break label10254;
              }
              for (paramContext = "default";; paramContext = new String[] { "readwritequeue", "swapqueue", "cmdqueue" }[k])
              {
                Toast.makeText(paramString2, paramContext, 1).show();
                paramString1.commit();
                AppMethodBeat.o(20133);
                return true;
                i = 0;
                break;
                j = 0;
                break label10173;
              }
              if (!paramString1.startsWith("//setAppBrandActionBar ")) {
                break label10362;
              }
              paramContext = paramString1.replace("//setAppBrandActionBar ", "");
              paramString1 = com.tencent.mm.sdk.platformtools.aj.eFF().edit();
              if (!paramContext.equalsIgnoreCase("new")) {
                break label10348;
              }
              paramString1.putBoolean("appbrand_new_actionbar", true);
              for (;;)
              {
                paramString1.commit();
                AppMethodBeat.o(20133);
                return true;
                paramString1.putBoolean("appbrand_new_actionbar", false);
              }
              if (!paramString1.startsWith("//snskvtest ")) {
                break label10424;
              }
              paramContext = paramString1.replace("//snskvtest", "").trim();
              if (!paramContext.equals("0")) {
                break label10407;
              }
              com.tencent.mm.platformtools.ab.hWj = false;
              for (;;)
              {
                AppMethodBeat.o(20133);
                return true;
                if (paramContext.equals("1")) {
                  com.tencent.mm.platformtools.ab.hWj = true;
                }
              }
              if (!paramString1.startsWith("//emoji ")) {
                break label10472;
              }
              paramContext = paramString1.replace("//emoji ", "");
              ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().TK(paramContext);
              AppMethodBeat.o(20133);
              return true;
              if (!paramString1.startsWith("//share ")) {
                break label10525;
              }
              i = Integer.valueOf(paramString1.replace("//share ", "")).intValue();
              az.arV();
              com.tencent.mm.model.c.afk().set(229635, Integer.valueOf(i));
              AppMethodBeat.o(20133);
              return true;
              if (!paramString1.startsWith("//dumpappinfoblob ")) {
                break label10609;
              }
              paramString1 = paramString1.replace("//dumpappinfoblob ", "");
              paramString1 = com.tencent.mm.pluginsdk.model.app.ap.cZQ().aAS(paramString1);
              com.tencent.mm.ui.base.h.R(paramContext, paramString1.Sp() + "\n" + paramString1.Sq() + "\n" + paramString1.Sr(), "");
              AppMethodBeat.o(20133);
              return true;
              if (!paramString1.startsWith("//googleauth ")) {
                break label10723;
              }
              paramString1 = paramString1.replace("//googleauth ", "");
              if (TextUtils.isEmpty(paramString1)) {
                break label10674;
              }
              if (!"webview".equals(paramString1)) {
                break label10682;
              }
              paramContext.getSharedPreferences(com.tencent.mm.sdk.platformtools.aj.eFD(), 0).edit().putBoolean("googleauth", true).commit();
              for (;;)
              {
                AppMethodBeat.o(20133);
                return true;
                if ("local".equals(paramString1)) {
                  paramContext.getSharedPreferences(com.tencent.mm.sdk.platformtools.aj.eFD(), 0).edit().putBoolean("googleauth", false).commit();
                }
              }
              if (!paramString1.startsWith("//clrgamecache")) {
                break label10756;
              }
              paramString1 = com.tencent.mm.plugin.game.api.b.a.cBi();
              if (paramString1 == null) {
                break label10748;
              }
              paramString1.eU(paramContext);
              AppMethodBeat.o(20133);
              return true;
              if (!paramString1.startsWith("//clearwepkg")) {
                break label10837;
              }
              paramContext = new yh();
              paramContext.dEN.dbV = 6;
              paramString1 = paramString1.replace("//clearwepkg ", "").trim();
              if ((com.tencent.mm.sdk.platformtools.bt.isNullOrNil(paramString1)) || (paramString1.equals("//clearwepkg"))) {
                break label10821;
              }
              paramContext.dEN.dEO = paramString1;
              com.tencent.mm.sdk.b.a.ESL.l(paramContext);
              AppMethodBeat.o(20133);
              return true;
              if (!paramString1.startsWith("//disableWePkg")) {
                break label10880;
              }
              paramContext = new yh();
              paramContext.dEN.dbV = 7;
              com.tencent.mm.sdk.b.a.ESL.l(paramContext);
              AppMethodBeat.o(20133);
              return true;
              if (!paramString1.startsWith("//gameBgMix ")) {
                break label10924;
              }
              paramContext = paramString1.replace("//gameBgMix ", "").trim();
              com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fqd, paramContext);
              AppMethodBeat.o(20133);
              return true;
              if (!paramString1.startsWith("//updateGameConfig")) {
                break label10966;
              }
              paramContext = new hp();
              paramContext.dll.BX = 5;
              com.tencent.mm.sdk.b.a.ESL.l(paramContext);
              AppMethodBeat.o(20133);
              return true;
              if (!paramString1.startsWith("//clrgsd")) {
                break label11046;
              }
              paramContext = new hw();
              paramContext.dlC.dbV = 3;
              paramString1 = paramString1.replace("//clrgsd ", "").trim();
              if ((com.tencent.mm.sdk.platformtools.bt.isNullOrNil(paramString1)) || (paramString1.equals("//clrgsd"))) {
                break label11030;
              }
              paramContext.dlC.dlB = paramString1;
              com.tencent.mm.sdk.b.a.ESL.l(paramContext);
              AppMethodBeat.o(20133);
              return true;
              if (!paramString1.startsWith("//delDownload")) {
                break label11126;
              }
              paramContext = new hw();
              paramContext.dlC.dbV = 4;
              paramString1 = paramString1.replace("//delDownload ", "").trim();
              if ((com.tencent.mm.sdk.platformtools.bt.isNullOrNil(paramString1)) || (paramString1.equals("//delDownload"))) {
                break label11118;
              }
              paramContext.dlC.dlB = paramString1;
              com.tencent.mm.sdk.b.a.ESL.l(paramContext);
              AppMethodBeat.o(20133);
              return true;
              if (!paramString1.startsWith("//googlemap")) {
                break label11148;
              }
              com.tencent.mm.platformtools.ab.hVK = true;
              AppMethodBeat.o(20133);
              return true;
              if (!paramString1.startsWith("//sosomap")) {
                break label11170;
              }
              com.tencent.mm.platformtools.ab.hVK = false;
              AppMethodBeat.o(20133);
              return true;
              if (!paramString1.startsWith("//opentrace")) {
                break label11202;
              }
              new com.tencent.mm.ui.applet.d();
              com.tencent.mm.ui.applet.d.jE(com.tencent.mm.sdk.platformtools.aj.getContext());
              AppMethodBeat.o(20133);
              return true;
              if (!paramString1.startsWith("//updateConversation")) {
                break label11306;
              }
              ad.i("MicroMsg.CommandProcessor", "update all conversation start");
              az.arV();
              paramContext = com.tencent.mm.model.c.apR().eLk().iterator();
              while (paramContext.hasNext())
              {
                paramString1 = (String)paramContext.next();
                az.arV();
                paramString1 = com.tencent.mm.model.c.apO().hn(paramString1, " and not ( type = 10000 and isSend != 2 ) ");
                az.arV();
                com.tencent.mm.model.c.apR().aH(paramString1);
              }
              ad.i("MicroMsg.CommandProcessor", "update all conversation end");
              AppMethodBeat.o(20133);
              return true;
              if (!paramString1.startsWith("//setshakecarddata")) {
                break label11332;
              }
              n.a.euP().doX();
              AppMethodBeat.o(20133);
              return true;
              if (!paramString1.startsWith("//clearshakecarddata")) {
                break label11358;
              }
              n.a.euP().doY();
              AppMethodBeat.o(20133);
              return true;
              if (!paramString1.startsWith("//pageSize")) {
                break label11416;
              }
              paramContext = com.tencent.mm.sdk.platformtools.aj.getContext();
              paramString1 = new StringBuilder("pageSize is ");
              az.arV();
              Toast.makeText(paramContext, com.tencent.mm.model.c.afg().getPageSize(), 1).show();
              AppMethodBeat.o(20133);
              return true;
              if (!paramString1.startsWith("//resetDBStatus")) {
                break label11594;
              }
              az.arV();
              paramContext = new com.tencent.mm.vfs.e(com.tencent.mm.model.c.afi());
              try
              {
                paramString1 = new StringBuilder();
                az.arV();
                paramString1 = com.tencent.mm.model.c.aff() + paramContext.getName().replace(".db", ".db.backup");
                com.tencent.mm.vfs.i.lC(paramString1, paramContext.getPath());
                ad.i("MicroMsg.CommandProcessor", "backupPath db path is %s", new Object[] { paramString1 });
                paramString1 = paramContext.getAbsolutePath() + "err" + System.currentTimeMillis();
                com.tencent.mm.vfs.i.lD(paramContext.getPath(), paramString1);
                Toast.makeText(com.tencent.mm.sdk.platformtools.aj.getContext(), "db状态已重置,请重启微信", 1).show();
                AppMethodBeat.o(20133);
                return true;
              }
              catch (Exception paramContext)
              {
                for (;;)
                {
                  ad.w("MicroMsg.CommandProcessor", "delete failed: " + paramContext.getMessage());
                }
              }
              if (!paramString1.startsWith("//makesnsdata ")) {
                break label11638;
              }
              i = com.tencent.mm.sdk.platformtools.bt.getInt(paramString1.replace("//makesnsdata ", ""), 0);
              n.d.euQ().sp(i);
              AppMethodBeat.o(20133);
              return true;
              if (!paramString1.startsWith("//setsnsupload ")) {
                break label11672;
              }
              com.tencent.mm.platformtools.ab.hVU = com.tencent.mm.sdk.platformtools.bt.getInt(paramString1.replace("//setsnsupload ", ""), 0);
              AppMethodBeat.o(20133);
              return true;
              if (!paramString1.startsWith("//logsnstable")) {
                break label11706;
              }
              paramContext = new cw();
              com.tencent.mm.sdk.b.a.ESL.l(paramContext);
              AppMethodBeat.o(20133);
              return true;
              if (!paramString1.startsWith("//resetsnstip")) {
                break label11741;
              }
              az.arV();
              com.tencent.mm.model.c.afk().set(327776, Integer.valueOf(0));
              AppMethodBeat.o(20133);
              return true;
              if (!paramString1.startsWith("//checkcount")) {
                break label11830;
              }
              az.arV();
              i = com.tencent.mm.model.c.apO().uh(ChattingUIFragment.FeN);
              az.arV();
              j = com.tencent.mm.model.c.apO().agE(ChattingUIFragment.FeN);
              Toast.makeText(paramContext, "current count :" + i + " countAuto :" + j, 1).show();
              AppMethodBeat.o(20133);
              return true;
              if (!paramString1.startsWith("//changeframe ")) {
                break label11894;
              }
              paramContext = paramString1.replace("//changeframe ", "");
              com.tencent.mm.sdk.platformtools.aj.getContext().getSharedPreferences("preferences_animation", 0).edit().putFloat("frameInterval", Float.valueOf(paramContext).floatValue()).commit();
              AppMethodBeat.o(20133);
              return true;
              if (!paramString1.startsWith("//opendumpview")) {
                break label11926;
              }
              new com.tencent.mm.ui.applet.c();
              com.tencent.mm.ui.applet.c.jD(com.tencent.mm.sdk.platformtools.aj.getContext());
              AppMethodBeat.o(20133);
              return true;
              if (!paramString1.startsWith("//dumpmemory")) {
                break label11953;
              }
              System.gc();
              System.gc();
              com.tencent.mm.ck.b.eOK();
              AppMethodBeat.o(20133);
              return true;
              if (!paramString1.startsWith("//dumpsnsfile")) {
                break label11987;
              }
              paramContext = new tg();
              com.tencent.mm.sdk.b.a.ESL.l(paramContext);
              AppMethodBeat.o(20133);
              return true;
              if (!paramString1.startsWith("//coverage")) {
                break label12018;
              }
              com.tencent.mm.plugin.report.b.f.amv(paramString1.trim().substring(10));
              AppMethodBeat.o(20133);
              return true;
              if (!paramString1.startsWith("//testverifypsw ")) {
                break label12105;
              }
              paramContext = paramString1.replace("//testverifypsw ", "").trim();
              if (!paramContext.equals("0")) {
                break label12088;
              }
              com.tencent.mm.platformtools.ab.hWl = false;
              for (;;)
              {
                ad.d("MicroMsg.CommandProcessor", "summerdktext testverifypsw msg[%s], testVerifyPsw[%b]", new Object[] { paramString1, Boolean.valueOf(com.tencent.mm.platformtools.ab.hWl) });
                AppMethodBeat.o(20133);
                return true;
                if (paramContext.equals("1")) {
                  com.tencent.mm.platformtools.ab.hWl = true;
                }
              }
              if (!paramString1.startsWith("//pickpoi")) {
                break label12152;
              }
              paramString1 = new Intent();
              paramString1.putExtra("map_view_type", 8);
              com.tencent.mm.bs.d.b(paramContext, "location", ".ui.RedirectUI", paramString1);
              AppMethodBeat.o(20133);
              return true;
              if (!paramString1.startsWith("//configlist")) {
                break label12445;
              }
              if (!paramString1.matches("^//configlist set ([\\S]*)=([\\S]*)$")) {
                break label12248;
              }
              paramString1 = com.tencent.mm.platformtools.ae.bz(paramString1, "^//configlist set ([\\S]*)=([\\S]*)$");
              if ((paramString1 == null) || (paramString1.size() != 2)) {
                break label12240;
              }
              paramContext = (String)paramString1.get(0);
              paramString1 = (String)paramString1.get(1);
              com.tencent.mm.m.g.Zd().put(paramContext, paramString1);
              paramContext = new cx();
              com.tencent.mm.sdk.b.a.ESL.l(paramContext);
              for (;;)
              {
                AppMethodBeat.o(20133);
                return true;
                if (paramString1.matches("^//configlist get ([\\S]*)$"))
                {
                  paramString1 = com.tencent.mm.platformtools.ae.bz(paramString1, "^//configlist get ([\\S]*)$");
                  if ((paramString1 != null) && (paramString1.size() == 1))
                  {
                    paramString1 = (String)paramString1.get(0);
                    paramString2 = com.tencent.mm.m.g.Zd().getValue(paramString1);
                    Toast.makeText(paramContext, paramString1 + "=" + paramString2, 0).show();
                  }
                }
                else
                {
                  az.arV();
                  paramString1 = (String)com.tencent.mm.model.c.afk().get(278530, "");
                  az.arV();
                  paramString2 = (String)com.tencent.mm.model.c.afk().get(278529, "");
                  localObject1 = com.tencent.mm.loader.j.b.aih() + "dynacfg.xml";
                  com.tencent.mm.sdk.platformtools.bt.t((String)localObject1, (paramString1 + paramString2).getBytes());
                  Toast.makeText(paramContext, "output dynacfg xml to ".concat(String.valueOf(localObject1)), 0).show();
                }
              }
              if (!paramString1.startsWith("//security")) {
                break label12485;
              }
              try
              {
                paramContext = paramString1.replace("//security ", "");
                az.arV().aql().a(paramContext, true, null);
                AppMethodBeat.o(20133);
                return true;
                if (!paramString1.startsWith("//updatepackage")) {
                  break label12535;
                }
                try
                {
                  paramContext = new com.tencent.mm.bc.l(com.tencent.mm.sdk.platformtools.bt.getInt(paramString1.replace("//updatepackage ", "").trim(), 0));
                  az.aeS().b(paramContext);
                  AppMethodBeat.o(20133);
                  return true;
                  if (!paramString1.startsWith("//copypackage")) {
                    break label12660;
                  }
                  ad.i("MicroMsg.CommandProcessor", "summercmd copypackage msg:%s", new Object[] { paramString1 });
                  paramString1 = com.tencent.mm.sdk.platformtools.bi.eGt();
                  i = paramString1.size();
                  ad.i("MicroMsg.CommandProcessor", "summercmd copypackage size:%d", new Object[] { Integer.valueOf(i) });
                  if (i >= 2) {
                    break label12617;
                  }
                  com.tencent.mm.ui.base.h.cd(paramContext, paramContext.getString(2131757947));
                  for (;;)
                  {
                    AppMethodBeat.o(20133);
                    return true;
                    com.tencent.mm.ui.base.h.d(paramContext, paramContext.getString(2131757949), "", paramContext.getString(2131755835), paramContext.getString(2131755691), new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                      {
                        AppMethodBeat.i(20109);
                        com.tencent.e.h.Iye.aP(new com.tencent.e.i.h()
                        {
                          public final String getKey()
                          {
                            return "copypackage";
                          }
                          
                          public final void run()
                          {
                            AppMethodBeat.i(20108);
                            try
                            {
                              String str1 = com.tencent.mm.loader.j.b.aib();
                              az.arV();
                              String str2 = com.tencent.mm.model.c.aqd();
                              az.arV();
                              Object localObject = com.tencent.mm.model.c.apI();
                              String str3 = str2.substring(str1.length());
                              ad.i("MicroMsg.CommandProcessor", "summercmd copypackage size:%d, root:%s, pkgFullPath:%s, sysPath:%s, pkgPath:%s", new Object[] { Integer.valueOf(b.3.this.fHu), str1, str2, localObject, str3 });
                              int i = 0;
                              while (i < b.3.this.fHu)
                              {
                                localObject = ((bi.a)b.3.this.val$list.get(i)).EWM;
                                if ((!com.tencent.mm.sdk.platformtools.bt.isNullOrNil((String)localObject)) && (!str1.contains((CharSequence)localObject)))
                                {
                                  localObject = new com.tencent.mm.vfs.e((String)localObject + str3);
                                  if ((((com.tencent.mm.vfs.e)localObject).exists()) && (((com.tencent.mm.vfs.e)localObject).isDirectory()))
                                  {
                                    boolean bool = com.tencent.mm.vfs.i.lE(com.tencent.mm.vfs.q.B(((com.tencent.mm.vfs.e)localObject).fhU()), str2);
                                    ad.i("MicroMsg.CommandProcessor", "summercmd copypackage done pkgFullPath:%s, old:%s, ret:%b", new Object[] { str2, com.tencent.mm.vfs.q.B(((com.tencent.mm.vfs.e)localObject).fhU()), Boolean.valueOf(bool) });
                                    if (bool)
                                    {
                                      new com.tencent.mm.sdk.platformtools.ap(Looper.getMainLooper()).post(new Runnable()
                                      {
                                        public final void run()
                                        {
                                          AppMethodBeat.i(20106);
                                          com.tencent.mm.ui.base.h.cf(b.3.this.val$context, b.3.this.val$context.getString(2131757948));
                                          AppMethodBeat.o(20106);
                                        }
                                      });
                                      AppMethodBeat.o(20108);
                                      return;
                                    }
                                  }
                                }
                                i += 1;
                              }
                              new com.tencent.mm.sdk.platformtools.ap(Looper.getMainLooper()).post(new Runnable()
                              {
                                public final void run()
                                {
                                  AppMethodBeat.i(20107);
                                  com.tencent.mm.ui.base.h.cf(b.3.this.val$context, b.3.this.val$context.getString(2131757947));
                                  AppMethodBeat.o(20107);
                                }
                              });
                              AppMethodBeat.o(20108);
                              return;
                            }
                            catch (Exception localException)
                            {
                              ad.w("MicroMsg.CommandProcessor", "summercmd copypackage e:%s", new Object[] { localException.getMessage() });
                              AppMethodBeat.o(20108);
                            }
                          }
                        });
                        AppMethodBeat.o(20109);
                      }
                    }, null);
                  }
                  if (!paramString1.startsWith("//copy -n ")) {
                    break label12786;
                  }
                  ad.i("MicroMsg.CommandProcessor", "summercmd copy -n msg:%s ", new Object[] { paramString1 });
                  paramString2 = com.tencent.mm.sdk.platformtools.bi.eGt();
                  i = paramString2.size();
                  ad.i("MicroMsg.CommandProcessor", "summercmd copy -n size:%d", new Object[] { Integer.valueOf(i) });
                  if (i >= 2) {
                    break label12742;
                  }
                  com.tencent.mm.ui.base.h.cd(paramContext, paramContext.getString(2131757947));
                  for (;;)
                  {
                    AppMethodBeat.o(20133);
                    return true;
                    com.tencent.mm.ui.base.h.d(paramContext, paramContext.getString(2131757949), "", paramContext.getString(2131755835), paramContext.getString(2131755691), new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                      {
                        AppMethodBeat.i(20113);
                        com.tencent.e.h.Iye.aP(new Runnable()
                        {
                          public final void run()
                          {
                            AppMethodBeat.i(20112);
                            try
                            {
                              Object localObject1 = b.4.this.val$msg.substring(10);
                              String str1 = com.tencent.mm.loader.j.b.aib();
                              az.arV();
                              Object localObject2 = com.tencent.mm.model.c.getAccPath();
                              String str2 = (String)localObject2 + (String)localObject1;
                              String str3 = str2.substring(str1.length());
                              ad.i("MicroMsg.CommandProcessor", "summercmd copy -n subDir:%s, root:%s, accPath:%s destPath:%s, subPath:%s", new Object[] { localObject1, str1, localObject2, str2, str3 });
                              int i = 0;
                              while (i < b.4.this.fHu)
                              {
                                localObject1 = ((bi.a)b.4.this.val$list.get(i)).EWM;
                                if ((!com.tencent.mm.sdk.platformtools.bt.isNullOrNil((String)localObject1)) && (!str1.contains((CharSequence)localObject1)))
                                {
                                  localObject1 = new com.tencent.mm.vfs.e((String)localObject1 + str3);
                                  if ((((com.tencent.mm.vfs.e)localObject1).exists()) && (((com.tencent.mm.vfs.e)localObject1).isDirectory()))
                                  {
                                    localObject2 = new com.tencent.mm.vfs.e(str2);
                                    if (!((com.tencent.mm.vfs.e)localObject2).exists()) {
                                      ((com.tencent.mm.vfs.e)localObject2).mkdirs();
                                    }
                                    boolean bool = com.tencent.mm.vfs.i.lE(com.tencent.mm.vfs.q.B(((com.tencent.mm.vfs.e)localObject1).fhU()), com.tencent.mm.vfs.q.B(((com.tencent.mm.vfs.e)localObject2).fhU()));
                                    ad.i("MicroMsg.CommandProcessor", "summercmd copy -n done new:%s, old:%s, ret:%b", new Object[] { com.tencent.mm.vfs.q.B(((com.tencent.mm.vfs.e)localObject2).fhU()), com.tencent.mm.vfs.q.B(((com.tencent.mm.vfs.e)localObject1).fhU()), Boolean.valueOf(bool) });
                                    if (bool)
                                    {
                                      new com.tencent.mm.sdk.platformtools.ap(Looper.getMainLooper()).post(new Runnable()
                                      {
                                        public final void run()
                                        {
                                          AppMethodBeat.i(20110);
                                          com.tencent.mm.ui.base.h.cf(b.4.this.val$context, b.4.this.val$context.getString(2131757948));
                                          AppMethodBeat.o(20110);
                                        }
                                      });
                                      AppMethodBeat.o(20112);
                                      return;
                                    }
                                  }
                                }
                                i += 1;
                              }
                              new com.tencent.mm.sdk.platformtools.ap(Looper.getMainLooper()).post(new Runnable()
                              {
                                public final void run()
                                {
                                  AppMethodBeat.i(20111);
                                  com.tencent.mm.ui.base.h.cf(b.4.this.val$context, b.4.this.val$context.getString(2131757947));
                                  AppMethodBeat.o(20111);
                                }
                              });
                              AppMethodBeat.o(20112);
                              return;
                            }
                            catch (Exception localException)
                            {
                              ad.w("MicroMsg.CommandProcessor", "summercmd copy -n e:%s", new Object[] { localException.getMessage() });
                              AppMethodBeat.o(20112);
                            }
                          }
                        });
                        AppMethodBeat.o(20113);
                      }
                    }, null);
                  }
                  if (!paramString1.startsWith("//deletepackage")) {
                    break label12842;
                  }
                  try
                  {
                    paramContext = paramString1.replace("//deletepackage ", "");
                    paramString1 = new cp();
                    paramString1.deO.deP = com.tencent.mm.sdk.platformtools.bt.getInt(paramContext, 0);
                    com.tencent.mm.sdk.b.a.ESL.l(paramString1);
                    AppMethodBeat.o(20133);
                    return true;
                    if (!paramString1.startsWith("//audiowritetofile")) {
                      break label12867;
                    }
                    com.tencent.mm.compatible.deviceinfo.ae.fFx.fzR = true;
                    AppMethodBeat.o(20133);
                    return true;
                    if (!paramString1.startsWith("//bankcard")) {
                      break label12942;
                    }
                    paramString1 = new Intent();
                    paramString1.putExtra("BaseScanUI_select_scan_mode", 7);
                    paramString1.putExtra("bank_card_owner", "test");
                    if ((com.tencent.mm.plugin.voip.f.cd(paramContext)) || (com.tencent.mm.bi.e.cc(paramContext))) {
                      break label12934;
                    }
                    com.tencent.mm.bs.d.b((Activity)paramContext, "scanner", ".ui.ScanCardUI", paramString1);
                    AppMethodBeat.o(20133);
                    return true;
                    if (!paramString1.startsWith("//banner")) {
                      break label13019;
                    }
                    paramString2 = bw.K("<sysmsg type=\"banner\"><mainframebanner type=\"11\"><showtype>1</showtype></mainframebanner></sysmsg>", "sysmsg");
                    ad.d("MicroMsg.CommandProcessor", "type:%s showType:%s data:%s", new Object[] { (String)paramString2.get(".sysmsg.mainframebanner.$type"), (String)paramString2.get(".sysmsg.mainframebanner.showtype"), (String)paramString2.get(".sysmsg.mainframebanner.data") });
                    if (!paramString1.startsWith("//gamemsg")) {
                      break label13061;
                    }
                    paramContext = new ot();
                    paramContext.dua.content = paramString1;
                    com.tencent.mm.sdk.b.a.ESL.l(paramContext);
                    AppMethodBeat.o(20133);
                    return true;
                    if (!paramString1.startsWith("//shortcut#")) {
                      break label13103;
                    }
                    paramContext = new yc();
                    paramContext.dEr.dEs = paramString1;
                    com.tencent.mm.sdk.b.a.ESL.l(paramContext);
                    AppMethodBeat.o(20133);
                    return true;
                    if (!paramString1.startsWith("//gallerytype")) {
                      break label13141;
                    }
                    if (p.Gnh) {
                      break label13135;
                    }
                    for (bool1 = true;; bool1 = false)
                    {
                      p.Gnh = bool1;
                      AppMethodBeat.o(20133);
                      return true;
                    }
                    paramContext.getString(2131764953);
                    if (!paramString1.startsWith("//fullexit")) {
                      break label13196;
                    }
                    an.aFy("show_whatsnew");
                    com.tencent.mm.kernel.l.o(paramContext, true);
                    MMAppMgr.bw(paramContext);
                    az.hold();
                    com.tencent.mm.kernel.g.afC().qU("");
                    MMAppMgr.aVJ();
                    AppMethodBeat.o(20133);
                    return true;
                    if (!paramString1.startsWith("//cleardldb")) {
                      break label13225;
                    }
                    az.arV();
                    com.tencent.mm.model.c.apS().bQG();
                    AppMethodBeat.o(20133);
                    return true;
                    if (!paramString1.startsWith("//setcardlayouttestdata")) {
                      break label13267;
                    }
                    paramContext = paramString1.replace("//setcardlayouttestdata ", "");
                    az.arV();
                    com.tencent.mm.model.c.afk().set(ae.a.Fhm, paramContext);
                    AppMethodBeat.o(20133);
                    return true;
                    if (!paramString1.startsWith("//delchatroomsysmsg")) {
                      break label13394;
                    }
                    paramString1 = paramString1.replace("//delchatroomsysmsg ", "");
                    i = paramString1.indexOf(" ");
                    paramContext = paramString1.substring(0, i);
                    paramString1 = paramString1.substring(i);
                    if (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil(paramContext)) {
                      break label13326;
                    }
                    AppMethodBeat.o(20133);
                    return false;
                    if (!paramString1.startsWith("<")) {
                      break label13386;
                    }
                    paramString2 = new bl();
                    paramString2.kY(System.currentTimeMillis());
                    paramString2.setType(10002);
                    paramString2.setContent(paramString1);
                    paramString2.jV(0);
                    paramString2.nY(paramContext);
                    com.tencent.mm.model.bi.u(paramString2);
                    AppMethodBeat.o(20133);
                    return true;
                    AppMethodBeat.o(20133);
                    return false;
                    if (!paramString1.startsWith("//resetcrseq")) {
                      break label13716;
                    }
                    paramString2 = paramString1.split(" ");
                    try
                    {
                      l1 = com.tencent.mm.sdk.platformtools.bt.getLong(paramString2[1], -1L);
                      l2 = com.tencent.mm.sdk.platformtools.bt.getLong(paramString2[2], -1L);
                      long l3 = com.tencent.mm.sdk.platformtools.bt.getLong(paramString2[3], -1L);
                      i = com.tencent.mm.sdk.platformtools.bt.getInt(paramString2[4], -1);
                      if (l1 > 0L)
                      {
                        paramString2 = l1 + "@chatroom";
                        az.arV();
                        paramString2 = com.tencent.mm.model.c.apR().aIn(paramString2);
                        if (paramString2 != null)
                        {
                          ad.i("MicroMsg.CommandProcessor", "summerbadcr resetcrseq [%s] before [%d, %d, %d] [%d, %d, %d]", new Object[] { paramString2.getUsername(), Long.valueOf(paramString2.SE()), Long.valueOf(paramString2.SC()), Integer.valueOf(paramString2.SD()), Long.valueOf(l2), Long.valueOf(l3), Integer.valueOf(i) });
                          if (l2 > -1L) {
                            paramString2.kV(l2);
                          }
                          if (l3 > -1L) {
                            paramString2.kU(l3);
                          }
                          if (i >= 0) {
                            paramString2.ka(i);
                          }
                          az.arV();
                          i = com.tencent.mm.model.c.apR().a(paramString2, paramString2.getUsername(), false);
                          ad.i("MicroMsg.CommandProcessor", "summerbadcr resetcrseq [%s] done [%d, %d, %d] ret:%d", new Object[] { paramString2.getUsername(), Long.valueOf(paramString2.SE()), Long.valueOf(paramString2.SC()), Integer.valueOf(paramString2.SD()), Integer.valueOf(i) });
                          AppMethodBeat.o(20133);
                          return true;
                        }
                      }
                    }
                    catch (Exception paramString2)
                    {
                      ad.printErrStackTrace("MicroMsg.CommandProcessor", paramString2, "summerbadcr resetcrseq", new Object[0]);
                    }
                    if (!paramString1.startsWith("//printchatroominfo")) {
                      break label13814;
                    }
                    paramContext = ChattingUIFragment.FeN;
                    if (com.tencent.mm.model.w.pF(paramContext)) {
                      break label13745;
                    }
                    AppMethodBeat.o(20133);
                    return false;
                    az.arV();
                    paramString2 = com.tencent.mm.model.c.apV().tH(paramContext);
                    if (paramString2 != null) {
                      break label13787;
                    }
                    ad.e("MicroMsg.CommandProcessor", "summercrinfo chatroomId[%s], member is null", new Object[] { paramContext });
                    AppMethodBeat.o(20133);
                    return false;
                    com.tencent.e.h.Iye.aP(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(20114);
                        i = this.fHz.eKo();
                        j = this.fHz.field_chatroomdataflag;
                        int k = this.fHz.eKq();
                        Object localObject1 = this.fHz;
                        if (((com.tencent.mm.storage.w)localObject1).b(((com.tencent.mm.storage.w)localObject1).Ffi)) {
                          ((com.tencent.mm.storage.w)localObject1).eKn();
                        }
                        int m = ((com.tencent.mm.storage.w)localObject1).Ffi.status;
                        int n = this.fHz.eKr();
                        localObject1 = this.fHz;
                        if (((com.tencent.mm.storage.w)localObject1).b(((com.tencent.mm.storage.w)localObject1).Ffi)) {
                          ((com.tencent.mm.storage.w)localObject1).eKn();
                        }
                        Object localObject3 = ((com.tencent.mm.storage.w)localObject1).Ffi.fym;
                        localObject1 = this.fHz.awt();
                        az.arV();
                        Object localObject2 = com.tencent.mm.model.c.apO().hn(paramContext, " and msgSeq != 0 and flag & 2 != 0");
                        boolean bool;
                        if ((localObject2 != null) && (((du)localObject2).field_msgId > 0L))
                        {
                          bool = true;
                          az.arV();
                          int i1 = com.tencent.mm.model.c.apO().agE(paramContext);
                          ad.i("MicroMsg.CommandProcessor", "summercrinfo chatroomId[%s], version[%d], flag[%d], type[%d], status[%d], get[%b], msgCount[%d], maxCount[%d], upgrader[%s], membersize[%d]", new Object[] { paramContext, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Boolean.valueOf(bool), Integer.valueOf(i1), Integer.valueOf(n), localObject3, Integer.valueOf(((List)localObject1).size()) });
                          localObject2 = new StringBuilder();
                          ((StringBuilder)localObject2).append("---chatroominfo---\nid:").append(paramContext).append("\nver:").append(i).append("\nflag:").append(j).append("\ntype:").append(k).append("\nstatus:").append(m).append("\nget:").append(bool).append("\nmsgCount:").append(i1).append("\nmaxCount:").append(n).append("\nupgrader:").append((String)localObject3).append("\nmembersize:").append(((List)localObject1).size()).append("\nisSilence:").append(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOD().afZ(paramContext)).append("\nsillenceBlock:").append(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOD().agc(paramContext).toString());
                          localObject3 = paramString1.split(" ");
                          i = -1;
                        }
                        try
                        {
                          j = com.tencent.mm.sdk.platformtools.bt.getInt(localObject3[1], 0);
                          i = j;
                        }
                        catch (Exception localException)
                        {
                          for (;;)
                          {
                            continue;
                            i = j;
                          }
                        }
                        if (i != -1) {}
                        for (;;)
                        {
                          j = i;
                          if (i > ((List)localObject1).size()) {
                            j = ((List)localObject1).size();
                          }
                          if (j <= 10) {
                            break label635;
                          }
                          i = 10;
                          if (i > 0) {
                            ((StringBuilder)localObject2).append("\nmember:");
                          }
                          j = 0;
                          while (j < i)
                          {
                            ((StringBuilder)localObject2).append("\n").append((String)((List)localObject1).get(j));
                            j += 1;
                          }
                          bool = false;
                          break;
                          i = ((List)localObject1).size();
                        }
                        localObject1 = new bl();
                        ((bl)localObject1).nY(paramContext);
                        ((bl)localObject1).jV(2);
                        ((bl)localObject1).setType(1);
                        ((bl)localObject1).kY(System.currentTimeMillis());
                        ((bl)localObject1).setContent(((StringBuilder)localObject2).toString());
                        com.tencent.mm.model.bi.u((bl)localObject1);
                        AppMethodBeat.o(20114);
                      }
                    });
                    AppMethodBeat.o(20133);
                    return true;
                    if (!paramString1.startsWith("//clean chatroomblock")) {
                      break label14033;
                    }
                    paramString2 = ChattingUIFragment.FeN;
                    paramContext = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOD();
                    if (!paramString1.equals("//clean chatroomblock hard")) {
                      break label13891;
                    }
                    l1 = paramContext.afT(paramString2);
                    Toast.makeText(com.tencent.mm.sdk.platformtools.aj.getContext(), "clean block hard! ret:".concat(String.valueOf(l1)), 1).show();
                    AppMethodBeat.o(20133);
                    return true;
                    if (!paramString1.equals("//clean chatroomblock all")) {
                      break label13938;
                    }
                    bool1 = paramContext.cOL();
                    Toast.makeText(com.tencent.mm.sdk.platformtools.aj.getContext(), "delete table! ret:".concat(String.valueOf(bool1)), 1).show();
                    AppMethodBeat.o(20133);
                    return true;
                    paramString1 = paramContext.agb(paramString2);
                    paramString1.field_lastLocalSeq = paramString1.field_lastPushSeq;
                    paramString1.field_lastLocalCreateTime = paramString1.field_lastPushCreateTime;
                    if (paramString1.field_seqBlockInfo == null) {
                      break label13979;
                    }
                    paramString1.field_seqBlockInfo.fyv.clear();
                    l1 = paramContext.b(paramString1);
                    ad.i("MicroMsg.CommandProcessor", "[chatroomblock] ret:".concat(String.valueOf(l1)));
                    Toast.makeText(com.tencent.mm.sdk.platformtools.aj.getContext(), "clean chatroomblock! ret:".concat(String.valueOf(l1)), 1).show();
                    AppMethodBeat.o(20133);
                    return true;
                    if (!paramString1.equals("//testupdate")) {
                      break label14130;
                    }
                    paramString1 = "";
                    try
                    {
                      paramContext = com.tencent.mm.sdk.platformtools.bt.convertStreamToString(paramContext.getAssets().open("aplha_update_info.xml"));
                      az.arV();
                      com.tencent.mm.model.c.afk().set(352273, paramContext);
                      az.arV();
                      com.tencent.mm.model.c.afk().set(352274, Long.valueOf(System.currentTimeMillis()));
                      new com.tencent.mm.pluginsdk.model.app.b(paramContext).evB();
                      AppMethodBeat.o(20133);
                      return true;
                    }
                    catch (IOException paramContext)
                    {
                      for (;;)
                      {
                        ad.printErrStackTrace("MicroMsg.CommandProcessor", paramContext, "", new Object[0]);
                        paramContext = paramString1;
                      }
                    }
                    if ((!paramString1.equals("//checkUpdate0")) && (!paramString1.equals("//checkUpdate1"))) {
                      break label14177;
                    }
                    com.tencent.mm.plugin.q.d.cRq().no(paramString1.equals("//checkUpdate1"));
                    com.tencent.mm.plugin.q.d.tMw = true;
                    AppMethodBeat.o(20133);
                    return true;
                    if (!paramString1.equals("//debugsnstimelinestat")) {
                      break label14244;
                    }
                    if (com.tencent.mm.platformtools.ab.hWe) {
                      break label14238;
                    }
                    for (bool1 = true;; bool1 = false)
                    {
                      com.tencent.mm.platformtools.ab.hWe = bool1;
                      Toast.makeText(com.tencent.mm.sdk.platformtools.aj.getContext(), "debugSnsTimelineStat: " + com.tencent.mm.platformtools.ab.hWe, 0).show();
                      AppMethodBeat.o(20133);
                      return true;
                    }
                    if ((!paramString1.startsWith("//abtestmsg")) || (!com.tencent.mm.sdk.a.b.eEQ())) {
                      break label14303;
                    }
                    paramContext = com.tencent.mm.model.c.a.uL(paramString1.replace("//abtestmsg", ""));
                    com.tencent.mm.model.c.d.aty().y(paramContext.gQr, 0);
                    com.tencent.mm.model.c.d.atz().y(paramContext.gQs, 1);
                    AppMethodBeat.o(20133);
                    return true;
                    if (!paramString1.startsWith("//triggergetabtest")) {
                      break label14338;
                    }
                    az.arV();
                    com.tencent.mm.model.c.afk().set(ae.a.Fid, Long.valueOf(1L));
                    AppMethodBeat.o(20133);
                    return true;
                    if (!paramString1.startsWith("//vad")) {
                      break label14591;
                    }
                    paramString2 = com.tencent.mm.sdk.platformtools.aj.eFE();
                    if (paramString2 != null) {
                      break label14364;
                    }
                    AppMethodBeat.o(20133);
                    return false;
                    if (!paramString1.startsWith("//vad get")) {
                      break label14395;
                    }
                    com.tencent.mm.ui.base.h.R(paramContext, com.tencent.mm.modelvoiceaddr.a.c.aDY(), "VAD PARAMS").show();
                    AppMethodBeat.o(20133);
                    return true;
                    paramContext = paramString2.edit();
                    if (!paramString1.startsWith("//vad sd")) {
                      break label14437;
                    }
                    paramContext.putInt("s_delay_time", Integer.valueOf(paramString1.substring(9).trim()).intValue());
                    if (!paramString1.startsWith("//vad st")) {
                      break label14472;
                    }
                    paramContext.putInt("sil_time", Integer.valueOf(paramString1.substring(9).trim()).intValue());
                    if (!paramString1.startsWith("//vad snr")) {
                      break label14507;
                    }
                    paramContext.putFloat("s_n_ration", Float.valueOf(paramString1.substring(10).trim()).floatValue());
                    if (!paramString1.startsWith("//vad sw")) {
                      break label14542;
                    }
                    paramContext.putInt("s_window", Integer.valueOf(paramString1.substring(9).trim()).intValue());
                    if (!paramString1.startsWith("//vad sl")) {
                      break label14577;
                    }
                    paramContext.putInt("s_length", Integer.valueOf(paramString1.substring(9).trim()).intValue());
                    paramContext.apply();
                    AppMethodBeat.o(20133);
                    return true;
                    if (!paramString1.startsWith("//dumpabtestrecords")) {
                      break label14754;
                    }
                    if (2 >= ad.getLogLevel()) {
                      break label14616;
                    }
                    AppMethodBeat.o(20133);
                    return false;
                    if (!paramString1.contains("info")) {
                      break label14744;
                    }
                    for (paramString1 = com.tencent.mm.model.c.d.atz().eJx();; paramString1 = com.tencent.mm.model.c.d.aty().eJx())
                    {
                      paramString2 = new TextView(paramContext);
                      paramString2.setText(paramString1);
                      paramString2.setGravity(8388627);
                      paramString2.setTextSize(1, 10.0F);
                      paramString2.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                      paramString2.setTextColor(ao.aD(paramContext, 2130968584));
                      paramString2.setTypeface(Typeface.MONOSPACE);
                      paramString2.setMovementMethod(new ScrollingMovementMethod());
                      i = paramContext.getResources().getDimensionPixelSize(2131165480);
                      paramString2.setPadding(i, i, i, i);
                      com.tencent.mm.ui.base.h.a(paramContext, null, paramString2, null);
                      AppMethodBeat.o(20133);
                      return true;
                    }
                    if (!paramString1.startsWith("//triggerWebViewCookiesCleanup")) {
                      break label14789;
                    }
                    az.arV();
                    com.tencent.mm.model.c.afk().set(ae.a.Fjr, Long.valueOf(0L));
                    AppMethodBeat.o(20133);
                    return true;
                    if (!paramString1.startsWith("//cleanwebcache")) {
                      break label14823;
                    }
                    paramContext = new bu();
                    com.tencent.mm.sdk.b.a.ESL.l(paramContext);
                    AppMethodBeat.o(20133);
                    return true;
                    if (!paramString1.startsWith("//triggerWebViewCacheCleanup")) {
                      break label14847;
                    }
                    com.tencent.mm.cr.d.aNr("com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
                    AppMethodBeat.o(20133);
                    return true;
                    if (!paramString1.startsWith("//dumpsnsabtest")) {
                      break label14881;
                    }
                    paramContext = new cu();
                    com.tencent.mm.sdk.b.a.ESL.l(paramContext);
                    AppMethodBeat.o(20133);
                    return true;
                    if (!paramString1.startsWith("//dumpsilkvoicefile")) {
                      break label14903;
                    }
                    com.tencent.mm.platformtools.ab.hWi = true;
                    AppMethodBeat.o(20133);
                    return true;
                    if (!paramString1.startsWith("//fucktit")) {
                      break label14937;
                    }
                    az.arV();
                    com.tencent.mm.model.c.afk().set(ae.a.Fjd, Boolean.TRUE);
                    AppMethodBeat.o(20133);
                    return true;
                    if (!paramString1.startsWith("//clog ")) {
                      break label14988;
                    }
                    paramContext = paramString1.substring(7);
                    com.tencent.mm.plugin.report.service.h.vKh.iq(paramContext, "test cLog " + System.currentTimeMillis());
                    AppMethodBeat.o(20133);
                    return true;
                    if ((!paramString1.startsWith("//testformsg")) || (!com.tencent.mm.sdk.a.b.eEQ())) {
                      break label15119;
                    }
                    paramContext = paramString1.substring(12).trim();
                    ad.i("MicroMsg.CommandProcessor", "MMCore.getSysCmdMsgExtension() " + az.getSysCmdMsgExtension());
                    paramString1 = new cs();
                    paramString1.Cxz = z.BE(paramContext);
                    paramString1.Cxx = z.BE("weixin");
                    paramString1.Cxy = z.BE(u.aqG());
                    paramString1.CxB = z.BF("test");
                    paramString1.saz = 10002;
                    paramContext = new f.a(paramString1, false, false, false);
                    az.getSysCmdMsgExtension().b(paramContext);
                    AppMethodBeat.o(20133);
                    return true;
                    if (!paramString1.startsWith("//canwebviewcachedownload")) {
                      break label15183;
                    }
                    if (com.tencent.mm.sdk.platformtools.bt.getInt(com.tencent.mm.sdk.platformtools.bt.nullAsNil(paramString1.substring(25)).trim(), 1) <= 0) {
                      break label15177;
                    }
                    for (bool1 = true;; bool1 = false)
                    {
                      az.arV();
                      com.tencent.mm.model.c.afk().set(ae.a.FjO, Boolean.valueOf(bool1));
                      AppMethodBeat.o(20133);
                      return true;
                    }
                    if (!paramString1.startsWith("//canwebviewcacheprepushdownload")) {
                      break label15247;
                    }
                    if (com.tencent.mm.sdk.platformtools.bt.getInt(com.tencent.mm.sdk.platformtools.bt.nullAsNil(paramString1.substring(32)).trim(), 1) <= 0) {
                      break label15241;
                    }
                    for (bool1 = true;; bool1 = false)
                    {
                      az.arV();
                      com.tencent.mm.model.c.afk().set(ae.a.FjP, Boolean.valueOf(bool1));
                      AppMethodBeat.o(20133);
                      return true;
                    }
                    if (!paramString1.startsWith("//resetsnslukcy")) {
                      break label15331;
                    }
                    az.arV();
                    com.tencent.mm.model.c.afk().set(ae.a.Fkf, Boolean.FALSE);
                    az.arV();
                    com.tencent.mm.model.c.afk().set(ae.a.Fkg, Integer.valueOf(0));
                    az.arV();
                    com.tencent.mm.model.c.afk().set(ae.a.Fkh, Integer.valueOf(0));
                    paramContext = new tx();
                    com.tencent.mm.sdk.b.a.ESL.l(paramContext);
                    AppMethodBeat.o(20133);
                    return true;
                    if (!paramString1.startsWith("//enablempsp")) {
                      break label15364;
                    }
                    aw.a.uT(false);
                    Toast.makeText(paramContext, "设置成功，请重启微信！", 0).show();
                    AppMethodBeat.o(20133);
                    return true;
                    if (!paramString1.startsWith("//disablempsp")) {
                      break label15397;
                    }
                    aw.a.uT(true);
                    Toast.makeText(paramContext, "设置成功，请重启微信！", 0).show();
                    AppMethodBeat.o(20133);
                    return true;
                    if (!paramString1.startsWith("//soterpay")) {
                      break label15425;
                    }
                    com.tencent.mm.bs.d.O(paramContext, "fingerprint", ".ui.SoterPayTestUI");
                    AppMethodBeat.o(20133);
                    return true;
                    if (!paramString1.startsWith(paramContext.getString(2131764850))) {
                      break label15508;
                    }
                    if (paramString1.split(" ").length != 1) {
                      break label15494;
                    }
                    if (com.tencent.mm.platformtools.ab.hWp) {
                      break label15502;
                    }
                    for (bool1 = true;; bool1 = false)
                    {
                      com.tencent.mm.platformtools.ab.hWp = bool1;
                      Toast.makeText(com.tencent.mm.sdk.platformtools.aj.getContext(), String.format("showVoipDebugLog:%b", new Object[] { Boolean.valueOf(com.tencent.mm.platformtools.ab.hWp) }), 0).show();
                      AppMethodBeat.o(20133);
                      return true;
                    }
                    if (!paramString1.startsWith("//cameraeffectdebug")) {
                      break label15575;
                    }
                    if (com.tencent.mm.platformtools.ab.hWs) {
                      break label15569;
                    }
                    for (bool1 = true;; bool1 = false)
                    {
                      com.tencent.mm.platformtools.ab.hWs = bool1;
                      Toast.makeText(com.tencent.mm.sdk.platformtools.aj.getContext(), String.format("showCameraEffectDebugLog:%b", new Object[] { Boolean.valueOf(com.tencent.mm.platformtools.ab.hWs) }), 0).show();
                      AppMethodBeat.o(20133);
                      return true;
                    }
                    if (!paramString1.startsWith("//getdltaskinfo")) {
                      break label15741;
                    }
                    paramContext = paramString1.replace("//getdltaskinfo ", "");
                    for (;;)
                    {
                      try
                      {
                        paramString1 = com.tencent.mm.plugin.downloader.model.d.oq(com.tencent.mm.sdk.platformtools.bt.getLong(paramContext, 0L));
                        if (paramString1 == null) {
                          continue;
                        }
                        ad.i("getdltaskinfo", "%d, %s, %s, %s", new Object[] { Long.valueOf(paramString1.field_downloadId), paramString1.field_downloadUrl, paramString1.field_filePath, paramString1.field_md5 });
                      }
                      catch (Exception paramString1)
                      {
                        paramContext = com.tencent.mm.plugin.downloader.model.d.Sn(paramContext);
                        if (paramContext == null) {
                          continue;
                        }
                        ad.i("getdltaskinfo", "%d, %s, %s, %s", new Object[] { Long.valueOf(paramContext.field_downloadId), paramContext.field_downloadUrl, paramContext.field_filePath, paramContext.field_md5 });
                        continue;
                        ad.i("getdltaskinfo", "infoURL null");
                        continue;
                      }
                      AppMethodBeat.o(20133);
                      return true;
                      ad.i("getdltaskinfo", "infoID null");
                    }
                    if (!paramString1.startsWith("//testscan ")) {
                      break label15828;
                    }
                    paramContext = paramString1.split(" ");
                    com.tencent.mm.platformtools.ab.hWo = com.tencent.mm.sdk.platformtools.bt.getFloat(paramContext[1], 0.0F);
                    com.tencent.mm.platformtools.ab.hWn = com.tencent.mm.sdk.platformtools.bt.getFloat(paramContext[2], 0.0F);
                    Toast.makeText(com.tencent.mm.sdk.platformtools.aj.getContext(), "mode auto:" + com.tencent.mm.platformtools.ab.hWo + ",mode continuous:" + com.tencent.mm.platformtools.ab.hWn, 1).show();
                    AppMethodBeat.o(20133);
                    return true;
                    if (!paramString1.startsWith("//switchrecordmode")) {
                      break label15932;
                    }
                    paramContext = com.tencent.mm.sdk.platformtools.aj.eFE();
                    bool2 = paramContext.getBoolean("settings_voicerecorder_mode", false);
                    if (bool2) {
                      break label15910;
                    }
                    bool1 = true;
                    paramContext.edit().putBoolean("settings_voicerecorder_mode", bool1).commit();
                    if (!bool2) {
                      break label15916;
                    }
                    Toast.makeText(com.tencent.mm.sdk.platformtools.aj.getContext(), "Turn off silk record", 1).show();
                    for (;;)
                    {
                      AppMethodBeat.o(20133);
                      return true;
                      bool1 = false;
                      break;
                      Toast.makeText(com.tencent.mm.sdk.platformtools.aj.getContext(), "Turn on silk record", 1).show();
                    }
                    if (!paramString1.startsWith("//indoorsensorconfig ")) {
                      break label15966;
                    }
                    com.tencent.mm.modelstat.e.aBE().zt(paramString1.replace("//indoorsensorconfig ", ""));
                    AppMethodBeat.o(20133);
                    return true;
                    if (!paramString1.startsWith("//testindoorsensor ")) {
                      break label16035;
                    }
                    paramContext = paramString1.replace("//testindoorsensor ", "").split(",");
                    com.tencent.mm.modelstat.e.aBE().a(12345, false, paramContext[0].equals("1"), com.tencent.mm.sdk.platformtools.bt.getFloat(paramContext[1], 0.0F), com.tencent.mm.sdk.platformtools.bt.getFloat(paramContext[2], 0.0F), 12);
                    AppMethodBeat.o(20133);
                    return true;
                    if (!paramString1.startsWith("//facedebug")) {
                      break label16053;
                    }
                    AppMethodBeat.o(20133);
                    return true;
                    if (!paramString1.startsWith("//rstfacett")) {
                      break label16071;
                    }
                    AppMethodBeat.o(20133);
                    return true;
                    if (!paramString1.startsWith("//switchjsc")) {
                      break label16205;
                    }
                    paramContext = paramString1.replace("//switchjsc ", "");
                    paramString1 = com.tencent.mm.sdk.platformtools.aj.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
                    if (!"clear".equals(paramContext)) {
                      break label16139;
                    }
                    paramString1.edit().remove("switch_x5_jscore").apply();
                    for (;;)
                    {
                      AppMethodBeat.o(20133);
                      return true;
                      if ("true".equals(paramContext)) {
                        paramString1.edit().putBoolean("switch_x5_jscore", true).apply();
                      } else if ("false".equals(paramContext)) {
                        paramString1.edit().putBoolean("switch_x5_jscore", false).apply();
                      }
                    }
                    if (!paramString1.startsWith("//rfcdn")) {
                      break label16255;
                    }
                    try
                    {
                      com.tencent.mm.ao.f.awM().keep_OnRequestDoGetCdnDnsInfo(888);
                      AppMethodBeat.o(20133);
                      return true;
                    }
                    catch (Exception paramContext)
                    {
                      for (;;)
                      {
                        ad.e("MicroMsg.CommandProcessor", "rfcdn :%s", new Object[] { com.tencent.mm.sdk.platformtools.bt.m(paramContext) });
                      }
                    }
                    if (!paramString1.startsWith("//testcrscroll ")) {
                      break label16322;
                    }
                    paramString2 = paramString1.split(" ");
                    if ((paramString2 == null) || (paramString2.length <= 1)) {
                      break label16322;
                    }
                    as.Gyj = com.tencent.mm.sdk.platformtools.bt.getInt(paramString2[1], 0);
                    ad.i("MicroMsg.CommandProcessor", "summerbadcr testscroll new BADCR_SCROLL_DELAY[%d]", new Object[] { Integer.valueOf(as.Gyj) });
                    AppMethodBeat.o(20133);
                    return true;
                    if (!paramString1.startsWith("//switchx5jscore")) {
                      break label16393;
                    }
                    paramContext = com.tencent.mm.sdk.platformtools.aj.eFE();
                    bool1 = paramContext.getBoolean("switch_x5_jscore", true);
                    paramContext = paramContext.edit();
                    if (bool1) {
                      break label16387;
                    }
                    for (bool1 = true;; bool1 = false)
                    {
                      paramContext.putBoolean("switch_x5_jscore", bool1).apply();
                      AppMethodBeat.o(20133);
                      return true;
                    }
                    if (!paramString1.startsWith("//removeaudioplayer")) {
                      break label16465;
                    }
                    paramContext = paramString1.split(" ");
                    if (paramContext.length < 2) {
                      break label16457;
                    }
                    i = com.tencent.mm.sdk.platformtools.bt.getInt(paramContext[1], 3);
                    if ((i < 2) || (i > 9)) {
                      break label16457;
                    }
                    az.arV();
                    com.tencent.mm.model.c.afk().set(ae.a.Fot, Integer.valueOf(i));
                    AppMethodBeat.o(20133);
                    return true;
                    if (!paramString1.startsWith("//showaudiotoast")) {
                      break label16543;
                    }
                    paramContext = paramString1.split(" ");
                    if (paramContext.length < 2) {
                      break label16529;
                    }
                    i = com.tencent.mm.sdk.platformtools.bt.getInt(paramContext[1], 0);
                    az.arV();
                    paramContext = com.tencent.mm.model.c.afk();
                    paramString1 = ae.a.Fou;
                    if (i != 1) {
                      break label16537;
                    }
                    for (bool1 = true;; bool1 = false)
                    {
                      paramContext.set(paramString1, Boolean.valueOf(bool1));
                      AppMethodBeat.o(20133);
                      return true;
                    }
                    if (!paramString1.startsWith("//openmixaudio")) {
                      break label16621;
                    }
                    paramContext = paramString1.split(" ");
                    if (paramContext.length < 2) {
                      break label16607;
                    }
                    i = com.tencent.mm.sdk.platformtools.bt.getInt(paramContext[1], 0);
                    az.arV();
                    paramContext = com.tencent.mm.model.c.afk();
                    paramString1 = ae.a.Fov;
                    if (i != 1) {
                      break label16615;
                    }
                    for (bool1 = true;; bool1 = false)
                    {
                      paramContext.set(paramString1, Boolean.valueOf(bool1));
                      AppMethodBeat.o(20133);
                      return true;
                    }
                    if (!paramString1.startsWith("//switchmusicplayer")) {
                      break label16999;
                    }
                    ad.i("MicroMsg.CommandProcessor", "msg:%s", new Object[] { paramString1 });
                    paramContext = paramString1.split(" ");
                    if (paramContext.length <= 2) {
                      break label16750;
                    }
                    if (com.tencent.mm.sdk.platformtools.bt.getInt(paramContext[1], 0) != 0) {
                      break label16758;
                    }
                    i = 0;
                    int m = com.tencent.mm.sdk.platformtools.bt.getInt(paramContext[2], -1);
                    az.arV();
                    k = ((Integer)com.tencent.mm.model.c.afk().get(ae.a.For, Integer.valueOf(0))).intValue();
                    j = 1;
                    if (m != -1) {
                      break label16770;
                    }
                    if (i == 0) {
                      break label16764;
                    }
                    i = 255;
                    for (;;)
                    {
                      if (j != 0)
                      {
                        az.arV();
                        com.tencent.mm.model.c.afk().set(ae.a.For, Integer.valueOf(i));
                      }
                      AppMethodBeat.o(20133);
                      return true;
                      i = 1;
                      break;
                      i = 0;
                      continue;
                      if (m == 0)
                      {
                        if (i != 0) {
                          i = k | 0x1;
                        } else {
                          i = k & 0xFFFFFFFE;
                        }
                      }
                      else if (m == 1)
                      {
                        if (i != 0) {
                          i = k | 0x2;
                        } else {
                          i = k & 0xFFFFFFFD;
                        }
                      }
                      else if (m == 4)
                      {
                        if (i != 0) {
                          i = k | 0x4;
                        } else {
                          i = k & 0xFFFFFFFB;
                        }
                      }
                      else if (m == 6)
                      {
                        if (i != 0) {
                          i = k | 0x10;
                        } else {
                          i = k & 0xFFFFFFEF;
                        }
                      }
                      else if (m == 7)
                      {
                        if (i != 0) {
                          i = k | 0x20;
                        } else {
                          i = k & 0xFFFFFFDF;
                        }
                      }
                      else if (m == 8)
                      {
                        if (i != 0) {
                          i = k | 0x40;
                        } else {
                          i = k & 0xFFFFFFBF;
                        }
                      }
                      else if (m == 9)
                      {
                        if (i != 0) {
                          i = k | 0x80;
                        } else {
                          i = k & 0xFFFFFF7F;
                        }
                      }
                      else
                      {
                        j = 0;
                        i = k;
                      }
                    }
                    if (!paramString1.startsWith("//testdefaultrsa")) {
                      break label17122;
                    }
                    ad.i("MicroMsg.CommandProcessor", "summercert testdefaultrsa");
                    paramString1 = paramString1.split(" ");
                    if ((paramString1 == null) || (paramString1.length <= 1)) {
                      break label17076;
                    }
                    for (bool1 = true;; bool1 = false)
                    {
                      com.tencent.mm.protocal.ac.af("", "", 0);
                      paramString1 = com.tencent.mm.kernel.g.afA().aeS().aeW();
                      if (paramString1 != null) {
                        break;
                      }
                      ad.w("MicroMsg.CommandProcessor", "summercert testdefaultrsa push not alive");
                      AppMethodBeat.o(20133);
                      return false;
                    }
                    new s("", "", "", 0).aAI().doScene(paramString1, new com.tencent.mm.al.g()
                    {
                      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
                      {
                        AppMethodBeat.i(20118);
                        ad.i("MicroMsg.CommandProcessor", "summercert testdefaultrsa NetSceneManualAuth onSceneEnd [%d, %d, %s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
                        if ((paramAnonymousInt1 == 4) && (paramAnonymousInt2 != -102) && (!this.fHB))
                        {
                          com.tencent.mm.sdk.platformtools.aq.f(new Runnable()
                          {
                            public final void run()
                            {
                              AppMethodBeat.i(20115);
                              b.D(b.6.this.val$context, "RSA(req) fatal err, must recheck!!!");
                              AppMethodBeat.o(20115);
                            }
                          });
                          AppMethodBeat.o(20118);
                          return;
                        }
                        new com.tencent.mm.modelsimple.l().doScene(com.tencent.mm.kernel.g.afA().gcy.gVH, new com.tencent.mm.al.g()
                        {
                          public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, com.tencent.mm.al.n paramAnonymous2n)
                          {
                            AppMethodBeat.i(20117);
                            ad.i("MicroMsg.CommandProcessor", "summercert testdefaultrsa  NetSceneGetCert onSceneEnd [%d, %d, %s]", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String });
                            if ((paramAnonymous2Int1 == 4) && (paramAnonymous2Int2 == -102))
                            {
                              com.tencent.mm.sdk.platformtools.aq.f(new Runnable()
                              {
                                public final void run()
                                {
                                  AppMethodBeat.i(20116);
                                  b.D(b.6.this.val$context, "RSA(base) fatal err, must recheck!!!");
                                  AppMethodBeat.o(20116);
                                }
                              });
                              AppMethodBeat.o(20117);
                              return;
                            }
                            Toast.makeText(b.6.this.val$context, "DefaultRSA check pass", 0).show();
                            b.D(b.6.this.val$context, "");
                            AppMethodBeat.o(20117);
                          }
                        });
                        AppMethodBeat.o(20118);
                      }
                    });
                    AppMethodBeat.o(20133);
                    return true;
                    if (!paramString1.startsWith("//dumpdefaultrsa")) {
                      break label17149;
                    }
                    bool1 = C(paramContext, "");
                    AppMethodBeat.o(20133);
                    return bool1;
                    if (!paramString1.startsWith("//hardwareinfo")) {
                      break label17182;
                    }
                    ((com.tencent.mm.plugin.hardwareopt.a.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.hardwareopt.a.a.a.class)).me(true);
                    AppMethodBeat.o(20133);
                    return true;
                    if (!paramString1.startsWith("//showStringName")) {
                      break label17254;
                    }
                    paramContext = com.tencent.mm.sdk.platformtools.aj.eFE();
                    bool1 = paramContext.getBoolean("ShowStringName", false);
                    paramContext = paramContext.edit();
                    if (bool1) {
                      break label17248;
                    }
                    for (bool1 = true;; bool1 = false)
                    {
                      paramContext.putBoolean("ShowStringName", bool1).commit();
                      AppMethodBeat.o(20133);
                      return true;
                    }
                    if (!paramString1.startsWith("//mmphotoedit")) {
                      break label17289;
                    }
                    com.tencent.mm.bs.d.b(paramContext, "mmsight", ".ui.TestVideoEditUI", new Intent());
                    AppMethodBeat.o(20133);
                    return true;
                    if (!paramString1.startsWith("//msgDelay")) {
                      break label17311;
                    }
                    com.tencent.mm.ui.conversation.a.n.jX(paramContext);
                    AppMethodBeat.o(20133);
                    return true;
                    if (!paramString1.startsWith("//cpDelayedMsg")) {
                      break label17333;
                    }
                    com.tencent.mm.ui.conversation.a.n.jY(paramContext);
                    AppMethodBeat.o(20133);
                    return true;
                    if (!paramString1.startsWith("//testhce")) {
                      break label17361;
                    }
                    com.tencent.mm.bs.d.O(paramContext, "nfc", ".ui.HceTestUI");
                    AppMethodBeat.o(20133);
                    return true;
                    if (!paramString1.startsWith("//debugbigimg")) {
                      break label17452;
                    }
                    paramContext = paramString1.split(" ");
                    if (paramContext.length != 2) {
                      break label17419;
                    }
                    if (!paramContext[1].equals("1")) {
                      break label17427;
                    }
                    com.tencent.mm.sdk.platformtools.aj.eFE().edit().putBoolean("debug_big_img", true).apply();
                    for (;;)
                    {
                      AppMethodBeat.o(20133);
                      return true;
                      com.tencent.mm.sdk.platformtools.aj.eFE().edit().putBoolean("debug_big_img", false).apply();
                    }
                    if (!paramString1.startsWith("//testservice ")) {
                      break label17534;
                    }
                    paramString1 = paramString1.replace("//testservice ", "");
                    paramContext = paramContext.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit();
                    if ((paramString1 == null) || (!paramString1.equals("1"))) {
                      break label17528;
                    }
                    for (bool1 = true;; bool1 = false)
                    {
                      paramContext.putBoolean("forceTrigger", bool1).commit();
                      AppMethodBeat.o(20133);
                      return true;
                    }
                    if (!paramString1.startsWith("//openDetect")) {
                      break label17583;
                    }
                    com.tencent.mm.sdk.platformtools.aj.getContext().getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.g.XN()).edit().putBoolean("msg_delay_close_detect", false).apply();
                    AppMethodBeat.o(20133);
                    return true;
                    if (!paramString1.startsWith("//closeDetect")) {
                      break label17632;
                    }
                    com.tencent.mm.sdk.platformtools.aj.getContext().getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.g.XN()).edit().putBoolean("msg_delay_close_detect", true).apply();
                    AppMethodBeat.o(20133);
                    return true;
                    if (!paramString1.startsWith("//snsimage")) {
                      break label17729;
                    }
                    for (;;)
                    {
                      try
                      {
                        i = com.tencent.mm.sdk.platformtools.bt.getInt(paramString1.replace("//snsimage ", ""), 0);
                        com.tencent.mm.ao.f.awL().nM(i);
                        if (i <= 0) {
                          continue;
                        }
                        paramContext = "tcp sns image download";
                        Toast.makeText(com.tencent.mm.sdk.platformtools.aj.getContext(), paramContext, 0).show();
                      }
                      catch (Exception paramContext)
                      {
                        ad.printErrStackTrace("MicroMsg.CommandProcessor", paramContext, "", new Object[0]);
                        Toast.makeText(com.tencent.mm.sdk.platformtools.aj.getContext(), "set snsimage fail, please ensure your command.", 1).show();
                        continue;
                      }
                      AppMethodBeat.o(20133);
                      return true;
                      paramContext = "http sns image download";
                    }
                    if (!paramString1.startsWith("//resetWeishi")) {
                      break label17763;
                    }
                    com.tencent.mm.kernel.g.afB().afk().set(ae.a.FtM, Integer.valueOf(0));
                    AppMethodBeat.o(20133);
                    return true;
                    if (!paramString1.startsWith("//clearWxWebCacheAndCookie")) {
                      break label17813;
                    }
                    paramContext = new Intent();
                    paramContext.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
                    paramContext.putExtra("tools_clean_webview_cache_ignore_cookie", true);
                    com.tencent.mm.cr.d.bs(paramContext);
                    AppMethodBeat.o(20133);
                    return true;
                    if (!paramString1.startsWith("//destroyPreloadGameWebCore")) {
                      break label17834;
                    }
                    com.tencent.mm.plugin.game.luggage.f.destroy();
                    AppMethodBeat.o(20133);
                    return true;
                    if (!paramString1.startsWith("//ecdhml ")) {
                      break label18164;
                    }
                    for (;;)
                    {
                      try
                      {
                        i = com.tencent.mm.sdk.platformtools.bt.getInt(paramString1.replace("//ecdhml ", ""), 0);
                        if ((i > 0) && (i < 5))
                        {
                          paramString2 = com.tencent.mm.sdk.platformtools.aj.getContext().getSharedPreferences("auth_info_key_prefs", com.tencent.mm.compatible.util.g.XN());
                          if (i < 3)
                          {
                            localObject1 = paramString2.edit();
                            if (i == 1)
                            {
                              bool1 = true;
                              ((SharedPreferences.Editor)localObject1).putBoolean("auth_info_prefs_use_new_ecdh", bool1).commit();
                              bool1 = paramString2.getBoolean("auth_info_prefs_use_new_ecdh", true);
                              localObject1 = new StringBuilder("reset ecdh mode ");
                              if (com.tencent.mm.protocal.f.CpT)
                              {
                                paramString2 = "enable";
                                localObject1 = ((StringBuilder)localObject1).append(paramString2).append(" to ");
                                if (!bool1) {
                                  break label19956;
                                }
                                paramString2 = "enable";
                                t.makeText(paramContext, paramString2, 0).show();
                                ad.i("MicroMsg.CommandProcessor", "summerauths reset ecdh ".concat(String.valueOf(bool1)));
                                AppMethodBeat.o(20133);
                                return true;
                              }
                            }
                            else
                            {
                              bool1 = false;
                              continue;
                            }
                            paramString2 = "disable";
                            continue;
                          }
                          localObject1 = paramString2.edit();
                          if (i != 3) {
                            break label18222;
                          }
                          bool1 = true;
                          ((SharedPreferences.Editor)localObject1).putBoolean("auth_info_prefs_use_net_ml_cert", bool1).commit();
                          bool1 = paramString2.getBoolean("auth_info_prefs_use_new_ecdh", false);
                          localObject1 = new StringBuilder("reset ecdh ml mode ");
                          if (!com.tencent.mm.protocal.f.CpU) {
                            break label18228;
                          }
                          paramString2 = "enable";
                          localObject1 = ((StringBuilder)localObject1).append(paramString2).append(" to ");
                          if (!bool1) {
                            break label18235;
                          }
                          paramString2 = "enable";
                          t.makeText(paramContext, paramString2, 0).show();
                          ad.i("MicroMsg.CommandProcessor", "summerauths reset ecdh ml".concat(String.valueOf(bool1)));
                          continue;
                        }
                        if (!paramString1.startsWith("//storyPostThreshold ")) {
                          break label18258;
                        }
                      }
                      catch (Exception paramString2) {}
                      paramContext = paramString1.substring(21);
                      i = 0;
                      try
                      {
                        j = Integer.valueOf(paramContext).intValue();
                        i = j;
                      }
                      catch (NumberFormatException paramContext)
                      {
                        for (;;)
                        {
                          ad.l("MicroMsg.CommandProcessor", "NumberFormatException", new Object[0]);
                        }
                      }
                      com.tencent.mm.kernel.g.afB().afk().set(ae.a.FuM, Integer.valueOf(i));
                      AppMethodBeat.o(20133);
                      return true;
                      bool1 = false;
                      continue;
                      paramString2 = "disable";
                      continue;
                      paramString2 = "disable";
                    }
                    if (!paramString1.startsWith("//hbemojisw")) {
                      break label18321;
                    }
                    az.arV();
                    i = ((Integer)com.tencent.mm.model.c.afk().get(ae.a.Fvf, Integer.valueOf(0))).intValue();
                    az.arV();
                    com.tencent.mm.model.c.afk().set(ae.a.Fvf, Integer.valueOf(i ^ 0x1));
                    AppMethodBeat.o(20133);
                    return true;
                    if (!paramString1.startsWith("//addbywework")) {
                      break label18384;
                    }
                    az.arV();
                    i = ((Integer)com.tencent.mm.model.c.afk().get(ae.a.FgI, Integer.valueOf(0))).intValue();
                    az.arV();
                    com.tencent.mm.model.c.afk().set(ae.a.FgI, Integer.valueOf(i ^ 0x1));
                    AppMethodBeat.o(20133);
                    return true;
                    if (!paramString1.startsWith("//enableDyBg ")) {
                      break label18475;
                    }
                    paramContext = paramString1.split(" ");
                    if (paramContext.length != 2) {
                      break label18442;
                    }
                    if (!paramContext[1].equals("1")) {
                      break label18450;
                    }
                    com.tencent.mm.sdk.platformtools.aj.eFE().edit().putBoolean("enable_dynamic_background_for_test", true).apply();
                    for (;;)
                    {
                      AppMethodBeat.o(20133);
                      return true;
                      com.tencent.mm.sdk.platformtools.aj.eFE().edit().putBoolean("enable_dynamic_background_for_test", false).apply();
                    }
                    if (!paramString1.startsWith("//setbgfps ")) {
                      break label18553;
                    }
                    paramContext = paramString1.split(" ");
                    if (paramContext.length != 2) {
                      break label18545;
                    }
                    i = Integer.valueOf(paramContext[1]).intValue();
                    if ((i <= 0) || (i > 50)) {
                      break label18545;
                    }
                    com.tencent.mm.sdk.platformtools.aj.eFE().edit().putInt("dynamic_bg_fps", i).apply();
                    AppMethodBeat.o(20133);
                    return true;
                    if (!paramString1.equalsIgnoreCase("//luckyBag")) {
                      break label18655;
                    }
                    paramString1 = new Intent(paramContext, SpringCardActivity.class);
                    paramString1 = new com.tencent.mm.hellhoundlib.b.a().bd(paramString1);
                    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString1.adn(), "com/tencent/mm/console/CommandProcessor", "processed", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    paramContext.startActivity((Intent)paramString1.lS(0));
                    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/console/CommandProcessor", "processed", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(20133);
                    return true;
                    if (!paramString1.equalsIgnoreCase("//weChatCouponTest")) {
                      break label18719;
                    }
                    com.tencent.mm.kernel.g.aeS().a(2812, new b.7(paramContext));
                    paramContext = new com.tencent.mm.plugin.eggspring.c.a(new com.tencent.mm.bx.b("2970ab7af847a6f4df4cc859d1b9713ef3834fe2cedc52624957de63ea3f6e8e6d02ae00148de17691af0b721bbd1abc4efdb29074030220142ed6a027e0ae8970881aa5fb0045845c23c04184829f96b5cca9ad420081d7e4a9fb9afdef515b50611066d1c969b0b71f3db61da723483880fceca2f7fb9482c57b963c05c67bde9860f5fec35f50a9990cc144b9a7455f73aa7234c3a8a57793c6c7ee7a74a9a74426ab3488d42031c3e3caebeb984f7bdb00850f3a4288ca3cbd5a457f843cda1cb8b335f9baac584afc35e9de62830add14bdf3711c7bbc46bc81cc9f1e3d4c79b76661aecc300024052d01846db357d8f6f98ea0452adcaa2b6a737812ffd70c86f8f3798724ffe3f43e5a753783c3ef0d79aa0378885c4f24b6572e596d".getBytes()));
                    com.tencent.mm.kernel.g.aeS().b(paramContext);
                    AppMethodBeat.o(20133);
                    return true;
                    if (!paramString1.startsWith("//transVoice")) {
                      break label18793;
                    }
                    paramContext = paramString1.split(" ");
                    if (2 != paramContext.length) {
                      break label18759;
                    }
                    if (!"1".equals(paramContext[1])) {
                      break label18767;
                    }
                    com.tencent.mm.plugin.transvoice.ui.b.yYw = 1;
                    for (;;)
                    {
                      AppMethodBeat.o(20133);
                      return true;
                      if ("0".equals(paramContext[1])) {
                        com.tencent.mm.plugin.transvoice.ui.b.yYw = 0;
                      } else {
                        com.tencent.mm.plugin.transvoice.ui.b.yYw = -1;
                      }
                    }
                    if (!paramString1.startsWith("//voice2TxtBlur")) {
                      break label18879;
                    }
                    paramContext = paramString1.split(" ");
                    if (2 != paramContext.length) {
                      break label18837;
                    }
                    if (!"1".equals(paramContext[1])) {
                      break label18845;
                    }
                    paramContext = com.tencent.mm.plugin.transvoice.b.yVU;
                    com.tencent.mm.plugin.transvoice.b.a.PB(1);
                    for (;;)
                    {
                      AppMethodBeat.o(20133);
                      return true;
                      if ("0".equals(paramContext[1]))
                      {
                        paramContext = com.tencent.mm.plugin.transvoice.b.yVU;
                        com.tencent.mm.plugin.transvoice.b.a.PB(0);
                      }
                      else
                      {
                        paramContext = com.tencent.mm.plugin.transvoice.b.yVU;
                        com.tencent.mm.plugin.transvoice.b.a.PB(-1);
                      }
                    }
                    if (!paramString1.startsWith("//scanSample")) {
                      break label18908;
                    }
                    com.tencent.mm.bs.d.b(paramContext, "scanner", ".ui.ScanSampleActivity", null);
                    AppMethodBeat.o(20133);
                    return true;
                    if (!paramString1.startsWith("//setcdnip")) {
                      break label19001;
                    }
                    paramString1 = paramString1.split(" ");
                    com.tencent.mm.platformtools.ab.hVV = false;
                    if (paramString1.length < 2) {
                      break label18987;
                    }
                    com.tencent.mm.platformtools.ab.hVV = true;
                    com.tencent.mm.platformtools.ab.hWa = paramString1[1];
                    Toast.makeText(paramContext, "set cdn debugip " + com.tencent.mm.platformtools.ab.hWa + " ok.", 0).show();
                    for (;;)
                    {
                      AppMethodBeat.o(20133);
                      return true;
                      Toast.makeText(paramContext, "clean cdn debugip ok.", 0).show();
                    }
                    if (!paramString1.startsWith("//snsvideoredirect")) {
                      break label19077;
                    }
                    paramString1 = paramString1.split(" ");
                    com.tencent.mm.platformtools.ab.hVV = false;
                    if (paramString1.length < 2) {
                      break label19062;
                    }
                    com.tencent.mm.platformtools.ab.hVV = true;
                    com.tencent.mm.platformtools.ab.hWb = com.tencent.mm.sdk.platformtools.bt.getInt(paramString1[1], 0);
                    if (com.tencent.mm.platformtools.ab.hWb == 0) {
                      break label19070;
                    }
                    for (paramString1 = "enable sns video redirect";; paramString1 = "disable sns video redirect")
                    {
                      Toast.makeText(paramContext, paramString1, 0).show();
                      AppMethodBeat.o(20133);
                      return true;
                    }
                    if (!paramString1.startsWith("//cdnnodebug")) {
                      break label19099;
                    }
                    com.tencent.mm.platformtools.ab.hVV = false;
                    AppMethodBeat.o(20133);
                    return true;
                    if (!paramString1.startsWith("//setLaunchRecovery")) {
                      break label19129;
                    }
                    ad.e("MicroMsg.CommandProcessor", "#setLaunchRecovery, set crash to launch recovery");
                    com.tencent.mm.modelrecovery.a.cA(paramContext);
                    AppMethodBeat.o(20133);
                    return true;
                    if (!paramString1.startsWith("//weseeSwitch")) {
                      break label19187;
                    }
                    paramString2 = paramString1.split(" ");
                    if (2 != paramString2.length) {
                      break label19187;
                    }
                    if (!"1".equals(paramString2[1])) {
                      break label19384;
                    }
                    com.tencent.mm.sdk.platformtools.aj.eFE().edit().putBoolean("wesee_switch", true).apply();
                    for (;;)
                    {
                      i = pI(paramString1);
                      ad.d("MicroMsg.CommandProcessor", "processed : in ret:[%d]", new Object[] { Integer.valueOf(i) });
                      switch (i)
                      {
                      default: 
                        AppMethodBeat.o(20133);
                        return false;
                        com.tencent.mm.sdk.platformtools.aj.eFE().edit().putBoolean("wesee_switch", false).apply();
                      }
                    }
                    AppMethodBeat.o(20133);
                    return false;
                    Assert.assertTrue("test errlog", false);
                    AppMethodBeat.o(20133);
                    return true;
                    az.arV().aqj();
                    AppMethodBeat.o(20133);
                    return true;
                    if (!com.tencent.mm.storage.bt.aJi(pJ(paramString1))) {
                      break label19467;
                    }
                    Toast.makeText(paramContext, 2131764814, 0).show();
                    AppMethodBeat.o(20133);
                    return true;
                    paramContext = pJ(paramString1);
                    az.arV();
                    com.tencent.mm.model.c.afk().set(8195, paramContext);
                    AppMethodBeat.o(20133);
                    return true;
                    com.tencent.mm.sdk.platformtools.i.cJT = Integer.valueOf(pJ(paramString1)).intValue();
                    AppMethodBeat.o(20133);
                    return true;
                    paramString1 = new StringBuilder().append(com.tencent.mm.compatible.deviceinfo.q.cG(true));
                    az.arV();
                    com.tencent.mm.ui.base.h.R(paramContext, com.tencent.mm.b.g.getMessageDigest(com.tencent.mm.model.c.getUin().getBytes()), "md5");
                    AppMethodBeat.o(20133);
                    return true;
                    paramContext = pJ(paramString1);
                    ar.a.arF().aB(paramContext, "");
                    AppMethodBeat.o(20133);
                    return true;
                    az.aeS().b(new bn(new bn.a()
                    {
                      public final void a(com.tencent.mm.network.e paramAnonymouse)
                      {
                        AppMethodBeat.i(20120);
                        if (paramAnonymouse == null)
                        {
                          AppMethodBeat.o(20120);
                          return;
                        }
                        paramAnonymouse = paramAnonymouse.avg();
                        az.arV();
                        int i = com.tencent.mm.model.c.getUin();
                        paramAnonymouse.a(new byte[0], new byte[0], new byte[0], i);
                        AppMethodBeat.o(20120);
                      }
                    }));
                    AppMethodBeat.o(20133);
                    return true;
                    paramContext = pJ(paramString1);
                    com.tencent.mm.pluginsdk.model.app.ap.cZP().aAR(paramContext);
                    AppMethodBeat.o(20133);
                    return true;
                    paramContext = pJ(paramString1);
                    az.arV();
                    paramContext = com.tencent.mm.model.c.apM().aHY(paramContext);
                    if ((paramContext != null) && (paramContext.ZV() != 0)) {
                      break label19685;
                    }
                    AppMethodBeat.o(20133);
                    return false;
                    paramContext.Zk();
                    com.tencent.mm.model.w.z(paramContext);
                    AppMethodBeat.o(20133);
                    return true;
                    AppMethodBeat.o(20133);
                    return true;
                    com.tencent.mm.model.bk.un(pJ(paramString1));
                    AppMethodBeat.o(20133);
                    return true;
                    paramContext = paramString1.split(" ");
                    if ((paramContext == null) || (paramContext.length != 3)) {
                      break label19759;
                    }
                    r.df(com.tencent.mm.sdk.platformtools.bt.getInt(paramContext[1], 0), com.tencent.mm.sdk.platformtools.bt.getInt(paramContext[2], 0));
                    AppMethodBeat.o(20133);
                    return true;
                    paramContext = new cv();
                    com.tencent.mm.sdk.b.a.ESL.l(paramContext);
                    AppMethodBeat.o(20133);
                    return true;
                    com.tencent.mm.vfs.i.aMF("/sdcard/tencent/MicroMsg/back");
                    az.arV();
                    com.tencent.mm.vfs.i.lE(com.tencent.mm.model.c.aff(), "/sdcard/tencent/MicroMsg/back");
                    AppMethodBeat.o(20133);
                    return true;
                    AppMethodBeat.o(20133);
                    return true;
                    try
                    {
                      paramContext = paramString1.split(" ");
                      if ((paramContext != null) && (paramContext.length > 1))
                      {
                        paramContext = bw.K(paramContext[0], "sysmsg");
                        az.arV().aqm().t(paramContext);
                      }
                    }
                    catch (Exception paramContext)
                    {
                      for (;;)
                      {
                        ad.printErrStackTrace("MicroMsg.CommandProcessor", paramContext, "hy: error occured in commandProcessor", new Object[0]);
                      }
                    }
                    AppMethodBeat.o(20133);
                    return true;
                  }
                  catch (Exception paramContext)
                  {
                    break label12834;
                  }
                }
                catch (Exception paramContext)
                {
                  break label12527;
                }
              }
              catch (Exception paramContext)
              {
                break label12477;
              }
            }
            catch (Exception paramContext)
            {
              break label8169;
            }
          }
          catch (Exception paramContext)
          {
            break label8129;
          }
        }
        catch (Exception paramContext)
        {
          break label8068;
        }
      }
      catch (Exception paramContext)
      {
        break label7919;
      }
      Toast.makeText(com.tencent.mm.sdk.platformtools.aj.getContext(), "Using SVG Code : " + bool1 + " " + com.tencent.mm.svg.b.b.eOw(), 1).show();
      label7919:
      AppMethodBeat.o(20133);
      return true;
    }
  }
  
  /* Error */
  private static StringBuilder lm(int paramInt)
  {
    // Byte code:
    //   0: sipush 20135
    //   3: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 3880	java/util/Date
    //   9: dup
    //   10: invokestatic 3883	com/tencent/mm/sdk/platformtools/bt:eGO	()J
    //   13: iload_0
    //   14: i2l
    //   15: ldc2_w 3884
    //   18: lmul
    //   19: lsub
    //   20: invokespecial 3887	java/util/Date:<init>	(J)V
    //   23: astore_1
    //   24: new 3889	java/text/SimpleDateFormat
    //   27: dup
    //   28: ldc_w 3891
    //   31: invokestatic 3897	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   34: invokespecial 3900	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   37: astore_2
    //   38: new 186	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   45: invokestatic 1797	com/tencent/mm/loader/j/b:aii	()Ljava/lang/String;
    //   48: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: ldc_w 3902
    //   54: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: aload_2
    //   58: aload_1
    //   59: invokevirtual 3905	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   62: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: ldc_w 3907
    //   68: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: astore_1
    //   75: new 186	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   82: astore 4
    //   84: aload_1
    //   85: invokestatic 3910	com/tencent/mm/vfs/i:eK	(Ljava/lang/String;)Z
    //   88: ifeq +42 -> 130
    //   91: new 186	java/lang/StringBuilder
    //   94: dup
    //   95: new 186	java/lang/StringBuilder
    //   98: dup
    //   99: ldc_w 3912
    //   102: invokespecial 207	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   105: iload_0
    //   106: invokevirtual 1604	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   109: ldc_w 3914
    //   112: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokespecial 207	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   121: astore_1
    //   122: sipush 20135
    //   125: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: aload_1
    //   129: areturn
    //   130: new 3916	java/io/BufferedReader
    //   133: dup
    //   134: new 3918	com/tencent/mm/vfs/k
    //   137: dup
    //   138: aload_1
    //   139: invokespecial 3919	com/tencent/mm/vfs/k:<init>	(Ljava/lang/String;)V
    //   142: invokespecial 3922	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   145: astore_2
    //   146: aload_2
    //   147: astore_1
    //   148: aload_2
    //   149: invokevirtual 3925	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   152: invokestatic 184	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   155: ifeq +54 -> 209
    //   158: aload_2
    //   159: astore_1
    //   160: aload_2
    //   161: invokevirtual 3928	java/io/BufferedReader:close	()V
    //   164: aload_2
    //   165: astore_1
    //   166: new 186	java/lang/StringBuilder
    //   169: dup
    //   170: new 186	java/lang/StringBuilder
    //   173: dup
    //   174: ldc_w 3930
    //   177: invokespecial 207	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   180: iload_0
    //   181: invokevirtual 1604	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   184: ldc_w 3932
    //   187: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokespecial 207	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   196: astore_3
    //   197: aload_2
    //   198: invokevirtual 3928	java/io/BufferedReader:close	()V
    //   201: sipush 20135
    //   204: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   207: aload_3
    //   208: areturn
    //   209: aload_2
    //   210: astore_1
    //   211: aload_2
    //   212: invokevirtual 3925	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   215: astore_3
    //   216: aload_3
    //   217: ifnull +85 -> 302
    //   220: aload_2
    //   221: astore_1
    //   222: aload 4
    //   224: new 108	java/lang/String
    //   227: dup
    //   228: aload_3
    //   229: ldc_w 3934
    //   232: invokevirtual 431	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   235: iconst_1
    //   236: aaload
    //   237: iconst_0
    //   238: invokestatic 3940	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   241: invokespecial 3941	java/lang/String:<init>	([B)V
    //   244: ldc_w 3943
    //   247: invokevirtual 431	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   250: iconst_1
    //   251: aaload
    //   252: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: pop
    //   256: aload_2
    //   257: astore_1
    //   258: aload 4
    //   260: ldc_w 3945
    //   263: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: pop
    //   267: goto -58 -> 209
    //   270: astore_3
    //   271: aload_2
    //   272: astore_1
    //   273: ldc 164
    //   275: aload_3
    //   276: ldc 166
    //   278: iconst_0
    //   279: anewarray 4	java/lang/Object
    //   282: invokestatic 172	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   285: aload_2
    //   286: ifnull +7 -> 293
    //   289: aload_2
    //   290: invokevirtual 3928	java/io/BufferedReader:close	()V
    //   293: sipush 20135
    //   296: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   299: aload 4
    //   301: areturn
    //   302: aload_2
    //   303: invokevirtual 3928	java/io/BufferedReader:close	()V
    //   306: goto -13 -> 293
    //   309: astore_1
    //   310: goto -17 -> 293
    //   313: astore_2
    //   314: aconst_null
    //   315: astore_1
    //   316: aload_1
    //   317: ifnull +7 -> 324
    //   320: aload_1
    //   321: invokevirtual 3928	java/io/BufferedReader:close	()V
    //   324: sipush 20135
    //   327: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   330: aload_2
    //   331: athrow
    //   332: astore_1
    //   333: goto -132 -> 201
    //   336: astore_1
    //   337: goto -44 -> 293
    //   340: astore_1
    //   341: goto -17 -> 324
    //   344: astore_2
    //   345: goto -29 -> 316
    //   348: astore_3
    //   349: aconst_null
    //   350: astore_2
    //   351: goto -80 -> 271
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	354	0	paramInt	int
    //   23	250	1	localObject1	Object
    //   309	1	1	localException1	Exception
    //   315	6	1	localObject2	Object
    //   332	1	1	localException2	Exception
    //   336	1	1	localException3	Exception
    //   340	1	1	localException4	Exception
    //   37	266	2	localObject3	Object
    //   313	18	2	localObject4	Object
    //   344	1	2	localObject5	Object
    //   350	1	2	localObject6	Object
    //   196	33	3	localObject7	Object
    //   270	6	3	localException5	Exception
    //   348	1	3	localException6	Exception
    //   82	218	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   148	158	270	java/lang/Exception
    //   160	164	270	java/lang/Exception
    //   166	197	270	java/lang/Exception
    //   211	216	270	java/lang/Exception
    //   222	256	270	java/lang/Exception
    //   258	267	270	java/lang/Exception
    //   302	306	309	java/lang/Exception
    //   130	146	313	finally
    //   197	201	332	java/lang/Exception
    //   289	293	336	java/lang/Exception
    //   320	324	340	java/lang/Exception
    //   148	158	344	finally
    //   160	164	344	finally
    //   166	197	344	finally
    //   211	216	344	finally
    //   222	256	344	finally
    //   258	267	344	finally
    //   273	285	344	finally
    //   130	146	348	java/lang/Exception
  }
  
  private static void ln(int paramInt)
  {
    AppMethodBeat.i(20136);
    Object localObject = aw.s(com.tencent.mm.sdk.platformtools.aj.getContext(), "sp_sns_dynswitch_stg", 4);
    switch (paramInt)
    {
    default: 
      localObject = new IllegalArgumentException("Bad op parameter: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(20136);
      throw ((Throwable)localObject);
    case -1: 
      ((SharedPreferences)localObject).edit().remove("st_sw_use_vcodec_img").commit();
      AppMethodBeat.o(20136);
      return;
    case 0: 
      ((SharedPreferences)localObject).edit().putBoolean("st_sw_use_vcodec_img", false).commit();
      AppMethodBeat.o(20136);
      return;
    }
    ((SharedPreferences)localObject).edit().putBoolean("st_sw_use_vcodec_img", true).commit();
    AppMethodBeat.o(20136);
  }
  
  private static void lo(int paramInt)
  {
    AppMethodBeat.i(20137);
    Object localObject = aw.s(com.tencent.mm.sdk.platformtools.aj.getContext(), "sp_sns_dynswitch_stg", 4);
    switch (paramInt)
    {
    default: 
      localObject = new IllegalArgumentException("Bad op parameter: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(20137);
      throw ((Throwable)localObject);
    case -1: 
      ((SharedPreferences)localObject).edit().remove("st_sw_use_wxpc_img").commit();
      AppMethodBeat.o(20137);
      return;
    case 0: 
      ((SharedPreferences)localObject).edit().putBoolean("st_sw_use_wxpc_img", false).commit();
      AppMethodBeat.o(20137);
      return;
    }
    ((SharedPreferences)localObject).edit().putBoolean("st_sw_use_wxpc_img", true).commit();
    AppMethodBeat.o(20137);
  }
  
  private static int pI(String paramString)
  {
    AppMethodBeat.i(20130);
    if ((!paramString.startsWith("//")) || (paramString.length() <= 2))
    {
      AppMethodBeat.o(20130);
      return 0;
    }
    int j = paramString.indexOf(" ");
    int i = j;
    if (j == -1) {
      i = paramString.length();
    }
    try
    {
      i = com.tencent.mm.sdk.platformtools.bt.getInt(paramString.substring(2, i), 0);
      j = com.tencent.mm.protocal.d.CpK % 256;
      if ((j == 0) || (i < j) || (i % j != 0))
      {
        AppMethodBeat.o(20130);
        return 0;
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(20130);
      return 0;
    }
    i /= j;
    AppMethodBeat.o(20130);
    return i;
  }
  
  private static String pJ(String paramString)
  {
    AppMethodBeat.i(20131);
    int i = paramString.indexOf(" ");
    if (i < 0)
    {
      AppMethodBeat.o(20131);
      return "";
    }
    paramString = paramString.substring(i).trim();
    AppMethodBeat.o(20131);
    return paramString;
  }
  
  private static boolean pK(String paramString)
  {
    AppMethodBeat.i(20132);
    Iterator localIterator = fHr.iterator();
    while (localIterator.hasNext()) {
      if (paramString.startsWith((String)localIterator.next()))
      {
        AppMethodBeat.o(20132);
        return true;
      }
    }
    AppMethodBeat.o(20132);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.console.b
 * JD-Core Version:    0.7.0.1
 */