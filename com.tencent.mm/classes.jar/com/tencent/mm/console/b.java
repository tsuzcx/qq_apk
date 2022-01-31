package com.tencent.mm.console;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.ComponentName;
import android.content.Context;
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
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.g.a.bg;
import com.tencent.mm.g.a.bn;
import com.tencent.mm.g.a.bp;
import com.tencent.mm.g.a.cj;
import com.tencent.mm.g.a.co;
import com.tencent.mm.g.a.cp;
import com.tencent.mm.g.a.cq;
import com.tencent.mm.g.a.cr;
import com.tencent.mm.g.a.gv;
import com.tencent.mm.g.a.hc;
import com.tencent.mm.g.a.ng;
import com.tencent.mm.g.a.rj;
import com.tencent.mm.g.a.rm;
import com.tencent.mm.g.a.sd;
import com.tencent.mm.g.a.wd;
import com.tencent.mm.g.a.wi;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.model.av;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.r;
import com.tencent.mm.modelstat.WatchDogPushReceiver;
import com.tencent.mm.platformtools.SpellMap;
import com.tencent.mm.plugin.game.api.b.a;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.p.a;
import com.tencent.mm.pluginsdk.p.b;
import com.tencent.mm.pluginsdk.p.d;
import com.tencent.mm.protocal.protobuf.bfh;
import com.tencent.mm.protocal.protobuf.bfi;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.ar.a;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bd.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bs;
import com.tencent.mm.storage.w;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.chatting.ChattingUIFragment;
import com.tencent.xweb.WebView;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public final class b
{
  private static final HashSet<String> etS;
  
  static
  {
    boolean bool = true;
    AppMethodBeat.i(16106);
    com.tencent.mm.console.a.d.init();
    com.tencent.mm.console.a.i.init();
    com.tencent.mm.console.a.j.init();
    com.tencent.mm.console.a.g.init();
    com.tencent.mm.console.a.e.init();
    com.tencent.mm.console.a.f.init();
    com.tencent.mm.console.a.b.init();
    com.tencent.mm.console.a.c.init();
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
      HashSet localHashSet = new HashSet();
      etS = localHashSet;
      localHashSet.add("//uplog");
      etS.add("//pullxlog");
      etS.add("//upcrash");
      etS.add("//getfpkey");
      etS.add("//voipdebug");
      etS.add("//setkey");
      etS.add("//wxcamera");
      etS.add("//deletetbs");
      etS.add("//setNfcOpenUrl");
      if (etS.size() == 9)
      {
        Assert.assertTrue(bool);
        AppMethodBeat.o(16106);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.CommandProcessor", localThrowable, "", new Object[0]);
        continue;
        bool = false;
      }
    }
  }
  
  private static boolean C(Context paramContext, String paramString)
  {
    AppMethodBeat.i(16101);
    StringBuffer localStringBuffer = new StringBuffer();
    if (!bo.isNullOrNil(paramString)) {
      localStringBuffer.append(paramString + "\n\n");
    }
    localStringBuffer.append("Default RSA Info:\n");
    localStringBuffer.append("ClientVersion: " + com.tencent.mm.sdk.platformtools.f.CLIENT_VERSION + "\n");
    localStringBuffer.append("BASE_RSA_PUBLIC_VERSION = 183\n");
    localStringBuffer.append("BASE_RSA_PUBLIC_KEYN = AF64B69AA6F14D838E22F72BBAD6DCDBDC7B2262617C553968EFC0CF2E73FD1714597F9E6BDF1661113B2DC82FDB77286E35822A187380640F5C107DF86CF35FFA3811BDD7012C4C41F5803F644DEE7CF3F037F0BE239A2FBE99F4E002C636759B65BDE41ECF15E594CE28793623FEE039B0E6D3C14131B8AE7BE8C01DF4D03D31C6DCDC228A9A35F74FF4DBB51F8A4E57490965D1074871CE3DB450966A444CF1BE85005D5089752C13D074DAE0172E2BAD3717357A6B49E7A156A6A4EDCFB1BA70C6073431AD0BE0FBBC3C53DCF746663733298385EB5105CA17796A62DAF110380061B1ECF21E686F7467D4327EE6393D2F666C973EA4651AEC32FEC52885 len(512)\n");
    localStringBuffer.append("BASE_RSA_PUBLIC_KEYE = 010001\n\n");
    localStringBuffer.append("REQ_RSA_PUBLIC_VERSION = 184\n");
    localStringBuffer.append("REQ_RSA_PUBLIC_KEYN = BB5FB9017F1CA20257A0384C7C87F568F618FA2697A7C12821FCEC3C97BA2509576944A67D4B4FA5A4B9FB4DB9DDB687FE3354B607E1FD0DE58E39F05B772F5E4976A6E83F6BE1DDD5F0D02A237B6CF5DD957B76EF9BF29B523EFA1041A87D3469590F473C9EC4B448034A3EC0C4B221B960F346FDCDA3BBF3CD984FBBDE97FAFE26FC317E4ACC653688F407E5BE93D41DE8981C113069A21329119F65578E0614957AFE0E0CF52A4A38A85CFD163424945C28CD181A3BEB198DF54303ED070C90419F1C31703C93448F1B381623EE6AED759A21865B5F612EBC9FD367AC4AD781D0E99DD4D7E68664989AF71E9A9342A38277018AA8672A465C8225CACD2CB9 len(512)\n");
    localStringBuffer.append("REQ_RSA_PUBLIC_KEYE = 010001\n");
    ab.i("MicroMsg.CommandProcessor", "summercert dumpdefaultrsa " + localStringBuffer.toString());
    if (!com.tencent.mm.sdk.a.b.dsf())
    {
      AppMethodBeat.o(16101);
      return false;
    }
    paramString = new TextView(paramContext);
    paramString.setText(localStringBuffer.toString());
    paramString.setGravity(19);
    paramString.setTextSize(1, 10.0F);
    paramString.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    paramString.setTextColor(-16711936);
    paramString.setTypeface(Typeface.MONOSPACE);
    int i = paramContext.getResources().getDimensionPixelSize(2131427861);
    paramString.setPadding(i, i, i, i);
    paramString.setMovementMethod(ScrollingMovementMethod.getInstance());
    com.tencent.mm.ui.base.h.a(paramContext, null, paramString, null);
    if (com.tencent.mm.protocal.aa.dqI()) {
      Toast.makeText(paramContext, "dump file:" + com.tencent.mm.compatible.util.e.eQz + "DefaultRSA.java", 1).show();
    }
    AppMethodBeat.o(16101);
    return true;
  }
  
  public static boolean i(final Context paramContext, final String paramString1, String paramString2)
  {
    AppMethodBeat.i(16100);
    if (!paramString1.startsWith("//"))
    {
      AppMethodBeat.o(16100);
      return false;
    }
    if ((1 < ab.getLogLevel()) && (!lF(paramString1)))
    {
      ab.i("MicroMsg.CommandProcessor", "summer processed log level[%s], need open debug ret false", new Object[] { Integer.valueOf(ab.getLogLevel()) });
      AppMethodBeat.o(16100);
      return false;
    }
    if (com.tencent.mm.pluginsdk.cmd.b.B(paramContext, paramString1, paramString2))
    {
      AppMethodBeat.o(16100);
      return true;
    }
    if (paramString1.startsWith("//clearWXSNSDB"))
    {
      paramContext = new rj();
      com.tencent.mm.sdk.b.a.ymk.l(paramContext);
      AppMethodBeat.o(16100);
      return true;
    }
    if (paramString1.startsWith("//verifytokenerror"))
    {
      com.tencent.mm.platformtools.ae.glC = true;
      AppMethodBeat.o(16100);
      return true;
    }
    if (paramString1.startsWith("//nativeLibraries"))
    {
      com.tencent.mm.sdk.c.dsb();
      AppMethodBeat.o(16100);
      return true;
    }
    if (paramString1.startsWith("//testLqt"))
    {
      paramContext = paramString1.split(" ");
      if (paramContext.length == 2) {
        if (bo.getInt(paramContext[1], 0) != 1) {
          break label209;
        }
      }
      label209:
      for (com.tencent.mm.platformtools.ae.glH = true;; com.tencent.mm.platformtools.ae.glH = false)
      {
        AppMethodBeat.o(16100);
        return true;
      }
    }
    if (paramString1.startsWith("//resetbackupdata"))
    {
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(ac.a.yEp, Boolean.FALSE);
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(ac.a.yEq, Boolean.FALSE);
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(ac.a.yEr, Boolean.FALSE);
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(ac.a.yEs, Boolean.FALSE);
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(ac.a.yEt, Boolean.FALSE);
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(ac.a.yEu, Boolean.FALSE);
      aw.aaz().Ze().dvQ();
      aw.aaz().Zf().dvQ();
      aw.aaz().Zd().dvQ();
      Toast.makeText(com.tencent.mm.sdk.platformtools.ah.getContext(), "backup data has been reset!", 1).show();
      AppMethodBeat.o(16100);
      return true;
    }
    if (paramString1.startsWith("//threadpool replace"))
    {
      if (paramString1.startsWith("//threadpool replace false")) {
        com.tencent.mm.sdk.platformtools.ah.dsQ().edit().putBoolean("REPLACE_WORKER_BOOLEAN", false).commit();
      }
      for (;;)
      {
        AppMethodBeat.o(16100);
        return true;
        if (paramString1.startsWith("//threadpool replace true")) {
          com.tencent.mm.sdk.platformtools.ah.dsQ().edit().putBoolean("REPLACE_WORKER_BOOLEAN", true).commit();
        }
      }
    }
    if (paramString1.equalsIgnoreCase("//ftsmsbiz"))
    {
      paramString2 = ai.cZA();
      paramString1 = new StringBuilder();
      paramString2 = paramString2.jJv.iterator();
      while (paramString2.hasNext())
      {
        localObject1 = (bfh)paramString2.next();
        paramString1.append(String.format("%s | %.2f | %s", new Object[] { com.tencent.mm.model.s.nE(((bfh)localObject1).Username), Double.valueOf(((bfh)localObject1).xuw), com.tencent.mm.pluginsdk.f.h.formatTime("yyyy-MM-dd HH:mm", ((bfh)localObject1).xux / 1000L) }));
        paramString1.append("\n");
      }
      paramString2 = new TextView(paramContext);
      paramString2.setText(paramString1.toString());
      paramString2.setGravity(19);
      paramString2.setTextSize(1, 10.0F);
      paramString2.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
      paramString2.setTextColor(-16711936);
      paramString2.setTypeface(Typeface.MONOSPACE);
      i = paramContext.getResources().getDimensionPixelSize(2131427772);
      paramString2.setPadding(i, i, i, i);
      com.tencent.mm.ui.base.h.a(paramContext, null, paramString2, null);
      AppMethodBeat.o(16100);
      return true;
    }
    if (paramString1.startsWith("//cleanww"))
    {
      ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.openim.a.b.class)).anO();
      AppMethodBeat.o(16100);
      return true;
    }
    if (com.tencent.mm.sdk.a.b.dsf())
    {
      if (paramString1.startsWith("//launchapp clear"))
      {
        com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yFc, "");
        AppMethodBeat.o(16100);
        return true;
      }
      if (paramString1.startsWith("//setsupportwxcode"))
      {
        com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yGr, Boolean.TRUE);
        AppMethodBeat.o(16100);
        return true;
      }
      if (paramString1.startsWith("//setnotsupportwxcode"))
      {
        com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yGr, Boolean.FALSE);
        AppMethodBeat.o(16100);
        return true;
      }
      if (paramString1.startsWith("//resetsupportwxcode"))
      {
        com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yGr, null);
        AppMethodBeat.o(16100);
        return true;
      }
    }
    if (paramString1.startsWith("//testsightwidget"))
    {
      paramString1 = new Intent();
      paramString1.putExtra("KSightPath", "/mnt/sdcard/tencent/tempvideo4.mp4");
      paramString1.putExtra("KSightThumbPath", "");
      paramString1.putExtra("sight_md5", com.tencent.mm.vfs.e.avP("/mnt/sdcard/tencent/tempvideo4.mp4"));
      paramString1.putExtra("KSnsPostManu", true);
      paramString1.putExtra("KTouchCameraTime", bo.aox());
      paramString1.putExtra("Ksnsupload_type", 14);
      com.tencent.mm.bq.d.b(paramContext, "sns", ".ui.SnsUploadUI", paramString1);
      AppMethodBeat.o(16100);
      return true;
    }
    if (paramString1.startsWith("//openremitbank"))
    {
      com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yIJ, Integer.valueOf(1));
      AppMethodBeat.o(16100);
      return true;
    }
    if (paramString1.startsWith("//chatroomdebug "))
    {
      if (paramString1.substring(paramString1.indexOf(" ") + 1).equalsIgnoreCase("true")) {
        ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.chatroom.a.c.class)).ge(true);
      }
      for (;;)
      {
        AppMethodBeat.o(16100);
        return true;
        ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.chatroom.a.c.class)).ge(false);
      }
    }
    if (paramString1.startsWith("//angerbag"))
    {
      if (((String)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yKi, "0")).equals("0")) {}
      for (paramContext = "1";; paramContext = "0")
      {
        com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yKi, paramContext);
        AppMethodBeat.o(16100);
        return true;
      }
    }
    if (paramString1.startsWith("//clearbag"))
    {
      com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yKh, "");
      AppMethodBeat.o(16100);
      return true;
    }
    if (paramString1.startsWith("//closeremitbank"))
    {
      com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yIJ, Integer.valueOf(0));
      AppMethodBeat.o(16100);
      return true;
    }
    if (paramString1.startsWith("//ftstemplatetest"))
    {
      paramString2 = new bg();
      paramString2.coI.coJ = 27;
      paramString2.coI.coJ = 1;
      paramString2.coI.filePath = "/sdcard/fts_template.zip";
      com.tencent.mm.sdk.b.a.ymk.l(paramString2);
    }
    if (paramString1.startsWith("//sightforward"))
    {
      paramString1 = new Intent();
      paramString1.setClassName(paramContext, "com.tencent.mm.ui.transmit.SightForwardUI");
      paramContext.startActivity(paramString1);
      AppMethodBeat.o(16100);
      return true;
    }
    if (paramString1.startsWith("//remit"))
    {
      com.tencent.mm.bq.d.b(paramContext, "remittance", ".ui.RemittanceBusiUI", new Intent());
      AppMethodBeat.o(16100);
      return true;
    }
    if (paramString1.startsWith("//fixtools"))
    {
      paramString1 = new Intent();
      paramString1.setClassName(paramContext, "com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUI");
      paramString1.putExtra("entry_fix_tools", 2);
      paramContext.startActivity(paramString1);
      AppMethodBeat.o(16100);
      return true;
    }
    if (paramString1.startsWith("//uplog"))
    {
      paramString1 = new Intent();
      paramString1.setClassName(paramContext, "com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUplogUI");
      paramString1.putExtra("entry_fix_tools_uplog", 5);
      MMWizardActivity.J(paramContext, paramString1);
      AppMethodBeat.o(16100);
      return true;
    }
    if (paramString1.startsWith("//pullxlog"))
    {
      ab.moveLogsFromCacheDirToLogDir();
      Toast.makeText(paramContext, "move success", 0).show();
      AppMethodBeat.o(16100);
      return true;
    }
    if (paramString1.startsWith("//upcrash"))
    {
      paramContext = "weixin";
      if (aw.RG()) {
        paramContext = r.Zn();
      }
      paramString2 = paramString1.split(" ");
      j = 0;
      i = 0;
      paramString1 = paramContext;
      if (paramString2 != null)
      {
        if (paramString2.length > 1) {
          i = bo.getInt(paramString2[1], 0);
        }
        paramString1 = paramContext;
        j = i;
        if (paramString2.length > 2)
        {
          paramString1 = paramString2[2];
          j = i;
        }
      }
      aw.Rc().b(new bk(new b.1(paramString1, j)));
      AppMethodBeat.o(16100);
      return true;
    }
    if (paramString1.startsWith("//fixError0831"))
    {
      ab.i("MicroMsg.CommandProcessor", "fixError0831");
      com.tencent.mm.sdk.b.a.ymk.l(new bn());
      AppMethodBeat.o(16100);
      return true;
    }
    if (paramString1.startsWith("//resetbankremit"))
    {
      com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yIK, Integer.valueOf(0));
      AppMethodBeat.o(16100);
      return true;
    }
    if (paramString1.startsWith("//busiluck "))
    {
      paramString1 = "weixin://openNativeUrl/weixinHB/startreceivebizhbrequest?sendid=".concat(String.valueOf(paramString1.replace("//busiluck ", "")));
      paramString2 = new Intent();
      paramString2.putExtra("key_way", 5);
      paramString2.putExtra("key_native_url", paramString1);
      com.tencent.mm.bq.d.b(paramContext, "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", paramString2);
      AppMethodBeat.o(16100);
      return true;
    }
    if (paramString1.startsWith("//testsoter"))
    {
      paramString1 = new Intent();
      paramString1.setClassName(com.tencent.mm.sdk.platformtools.ah.getPackageName(), "com.tencent.mm.plugin.soter.ui.SoterTestUI");
      paramContext.startActivity(paramString1);
      AppMethodBeat.o(16100);
      return true;
    }
    if (paramString1.startsWith("//facevideo"))
    {
      paramContext = paramString1.split(" ");
      if (paramContext.length == 3)
      {
        av.flM.ao("imgType", paramContext[1]);
        av.flM.ao("depth", paramContext[2]);
      }
      AppMethodBeat.o(16100);
      return true;
    }
    if (paramString1.startsWith("//alpha"))
    {
      paramContext = paramString1.split(" ");
      if (paramContext.length == 2) {
        av.flM.ao("alpha_duration", paramContext[1]);
      }
      AppMethodBeat.o(16100);
      return true;
    }
    if (paramString1.startsWith("//forceNotifyError"))
    {
      paramContext = paramString1.split(" ");
      if (paramContext.length == 2) {
        ((com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.forcenotify.a.b.class)).hO(paramContext[1].equalsIgnoreCase("true"));
      }
      AppMethodBeat.o(16100);
      return true;
    }
    if (paramString1.startsWith("//rectwidth"))
    {
      paramContext = paramString1.split(" ");
      if (paramContext.length == 2) {
        av.flM.ao("rect_width", paramContext[1]);
      }
      AppMethodBeat.o(16100);
      return true;
    }
    if (paramString1.startsWith("//newyearsw "))
    {
      aw.aaz();
      i = ((Integer)com.tencent.mm.model.c.Ru().get(ac.a.yym, Integer.valueOf(0))).intValue();
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(ac.a.yym, Integer.valueOf(i ^ 0x1));
      AppMethodBeat.o(16100);
      return true;
    }
    if (paramString1.startsWith("//commitxlog"))
    {
      aw.Rc().a(1, "", 0, false);
      ab.dsI();
      AppMethodBeat.o(16100);
      return true;
    }
    if (paramString1.startsWith("//open neattextview"))
    {
      com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yIO, Boolean.TRUE);
      AppMethodBeat.o(16100);
      return true;
    }
    if (paramString1.startsWith("//close neattextview"))
    {
      com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yIO, Boolean.FALSE);
      AppMethodBeat.o(16100);
      return true;
    }
    if (paramString1.startsWith("//unprint specialtext"))
    {
      com.tencent.mm.ui.widget.MMNeat7extView.ACX = false;
      AppMethodBeat.o(16100);
      return true;
    }
    if (paramString1.startsWith("//print specialtext"))
    {
      com.tencent.mm.ui.widget.MMNeat7extView.ACX = true;
      AppMethodBeat.o(16100);
      return true;
    }
    if (paramString1.startsWith("//netstatus"))
    {
      paramString1 = at.gT(com.tencent.mm.sdk.platformtools.ah.getContext());
      com.tencent.mm.ui.base.h.d(paramContext, paramString1, "netstatus", paramContext.getString(2131304687), paramContext.getString(2131298499), new b.8(paramContext, paramString1), null);
      AppMethodBeat.o(16100);
      return true;
    }
    if (paramString1.startsWith("//scaninterval "))
    {
      paramString2 = paramString1.split(" ");
      l1 = -1L;
    }
    try
    {
      l2 = bo.getLong(paramString2[1], -1L);
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
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(ac.a.yEi, Long.valueOf(l1));
      ab.i("MicroMsg.CommandProcessor", "summerclean reset scaninterval[%d]", new Object[] { Long.valueOf(l1) });
      AppMethodBeat.o(16100);
      return true;
    }
    if (paramString1.startsWith("//scanwait "))
    {
      paramString2 = paramString1.split(" ");
      l1 = -1L;
    }
    try
    {
      l2 = bo.getLong(paramString2[1], -1L);
      l1 = l2;
    }
    catch (Exception paramString2)
    {
      label2330:
      boolean bool1;
      label2567:
      label2642:
      label2813:
      boolean bool3;
      boolean bool2;
      boolean bool4;
      break label2330;
    }
    if (l1 > 0L)
    {
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(ac.a.yEj, Long.valueOf(l1));
      ab.i("MicroMsg.CommandProcessor", "summerclean reset scanwait[%d]", new Object[] { Long.valueOf(l1) });
      AppMethodBeat.o(16100);
      return true;
    }
    if (paramString1.equalsIgnoreCase("//delayquery"))
    {
      if (!com.tencent.mm.platformtools.ae.glF) {}
      for (bool1 = true;; bool1 = false)
      {
        com.tencent.mm.platformtools.ae.glF = bool1;
        AppMethodBeat.o(16100);
        return true;
      }
    }
    if (paramString1.startsWith("//newinit -hard"))
    {
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RL().Ru().set(15, Integer.valueOf(0));
      AppMethodBeat.o(16100);
      return true;
    }
    if (paramString1.startsWith("//websearch-widget-draw "))
    {
      paramContext = paramString1.split("\\s+");
      if (paramContext.length == 2) {
        ((com.tencent.mm.plugin.websearch.api.n)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.websearch.api.n.class)).IW(bo.apV(paramContext[1].trim()));
      }
      AppMethodBeat.o(16100);
      return true;
    }
    if (paramString1.startsWith("//opensearchpreload "))
    {
      paramContext = paramString1.split("\\s+");
      if (paramContext.length == 2)
      {
        if (!"1".equals(paramContext[1].trim())) {
          break label2567;
        }
        com.tencent.mm.plugin.websearch.api.aj.cZB().oh(true);
      }
      for (;;)
      {
        AppMethodBeat.o(16100);
        return true;
        if ("0".equals(paramContext[1].trim())) {
          com.tencent.mm.plugin.websearch.api.aj.cZB().oh(false);
        }
      }
    }
    if (paramString1.startsWith("//closesearchhtmlpreload "))
    {
      paramContext = paramString1.split("\\s+");
      if (paramContext.length == 2)
      {
        if (!"1".equals(paramContext[1].trim())) {
          break label2642;
        }
        com.tencent.mm.plugin.websearch.api.aa.cZn();
      }
      for (;;)
      {
        AppMethodBeat.o(16100);
        return true;
        if ("0".equals(paramContext[1].trim())) {
          com.tencent.mm.plugin.websearch.api.aa.cZn();
        }
      }
    }
    if (paramString1.equalsIgnoreCase("//swipe"))
    {
      paramContext = com.tencent.mm.sdk.platformtools.ah.dsQ();
      bool1 = paramContext.getBoolean("settings_support_swipe", true);
      paramContext = paramContext.edit();
      if (!bool1) {}
      for (bool1 = true;; bool1 = false)
      {
        paramContext.putBoolean("settings_support_swipe", bool1).commit();
        AppMethodBeat.o(16100);
        return true;
      }
    }
    if (paramString1.equalsIgnoreCase("//multiwebview"))
    {
      paramContext = LauncherUI.getInstance().getSharedPreferences(com.tencent.mm.sdk.platformtools.ah.dsP(), 0);
      bool1 = paramContext.getBoolean("settings_multi_webview", false);
      if (bool1)
      {
        paramContext = paramContext.edit();
        if (bool1) {
          break label2813;
        }
      }
      for (bool1 = true;; bool1 = false)
      {
        paramContext.putBoolean("settings_multi_webview", bool1).commit();
        AppMethodBeat.o(16100);
        return true;
      }
    }
    if (paramString1.equalsIgnoreCase("//sightinfo"))
    {
      aw.aaz();
      bool1 = ((Boolean)com.tencent.mm.model.c.Ru().get(344065, Boolean.FALSE)).booleanValue();
      aw.aaz();
      paramContext = com.tencent.mm.model.c.Ru();
      if (!bool1) {}
      for (bool1 = true;; bool1 = false)
      {
        paramContext.set(344065, Boolean.valueOf(bool1));
        aw.aaz();
        com.tencent.mm.model.c.Ru().dww();
        AppMethodBeat.o(16100);
        return true;
      }
    }
    if (paramString1.startsWith("//sighttest"))
    {
      i = bo.apV(paramString1.replace("//sighttest ", ""));
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(344066, Integer.valueOf(i));
      aw.aaz();
      com.tencent.mm.model.c.Ru().dww();
      AppMethodBeat.o(16100);
      return true;
    }
    if (paramString1.startsWith("//wxcamera"))
    {
      i = bo.apV(paramString1.replace("//wxcamera ", ""));
      ab.i("MicroMsg.CommandProcessor", "set param %d", new Object[] { Integer.valueOf(i) });
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(ac.a.yDV, Integer.valueOf(i));
      AppMethodBeat.o(16100);
      return true;
    }
    if (paramString1.startsWith("//printcrash"))
    {
      paramString1 = paramString1.replace("//printcrash ", "");
      paramString2 = new TextView(paramContext);
      paramString2.setText(iY(bo.getInt(paramString1, 0)));
      paramString2.setGravity(19);
      paramString2.setTextSize(1, 8.0F);
      paramString2.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
      paramString2.setTextColor(-16711936);
      paramString2.setTypeface(Typeface.MONOSPACE);
      i = paramContext.getResources().getDimensionPixelSize(2131427861);
      paramString2.setPadding(i, i, i, i);
      paramString2.setMovementMethod(ScrollingMovementMethod.getInstance());
      com.tencent.mm.ui.base.h.a(paramContext, null, paramString2, null);
      AppMethodBeat.o(16100);
      return true;
    }
    if (paramString1.startsWith("//printleak"))
    {
      paramString1 = new TextView(paramContext);
      paramString1.setText(com.tencent.mm.compatible.b.g.KW());
      paramString1.setGravity(19);
      paramString1.setTextSize(1, 8.0F);
      paramString1.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
      paramString1.setTextColor(-16711936);
      paramString1.setTypeface(Typeface.MONOSPACE);
      i = paramContext.getResources().getDimensionPixelSize(2131427861);
      paramString1.setPadding(i, i, i, i);
      paramString1.setMovementMethod(ScrollingMovementMethod.getInstance());
      com.tencent.mm.ui.base.h.a(paramContext, null, paramString1, null);
      AppMethodBeat.o(16100);
      return true;
    }
    if (paramString1.startsWith("//resetmapcnt"))
    {
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(ac.a.yGs, Integer.valueOf(0));
      AppMethodBeat.o(16100);
      return true;
    }
    if (paramString1.equals("//testrsa"))
    {
      com.tencent.mm.protocal.aa.T("010001", "E338E5DAD46B331E3071FAFD4C0F84C7C7965DBBE64C6F8CC0F7CF04DC640C1F84A2014431A48D65F2B2F172BA9BE6F5A049BF52C78C14B0965E20F0D80D85A9180EBABB913D49821D28BFD9601DF52A4F3230AECAD96D23415F5E94D51A87CAA7630C5F3CB70345BAF572A4F61A134A2265AFD8FADDFE0222BD9ABF7DBEB7444D031454E8F21820BBC725E6857F765660E987FADEBCF6B3A15355C4CD3752A7B544D1D7E037AF4F9725BE37681A84C9E1DC431B3065294EAD53E913BAF16D46714B013EA077191E6CA08ABA6D70E9CA792D898D692E3168D6341369976657CD5E1504B9E2458F107225176734D11621AD36D7FFA26C573D6612455B09105C41", 106);
      AppMethodBeat.o(16100);
      return true;
    }
    if (paramString1.equals("//testrsabad"))
    {
      com.tencent.mm.protocal.aa.T("010001", "F338E5DAD46B331E3071FAFD4C0F84C7C7965DBBE64C6F8CC0F7CF04DC640C1F84A2014431A48D65F2B2F172BA9BE6F5A049BF52C78C14B0965E20F0D80D85A9180EBABB913D49821D28BFD9601DF52A4F3230AECAD96D23415F5E94D51A87CAA7630C5F3CB70345BAF572A4F61A134A2265AFD8FADDFE0222BD9ABF7DBEB7444D031454E8F21820BBC725E6857F765660E987FADEBCF6B3A15355C4CD3752A7B544D1D7E037AF4F9725BE37681A84C9E1DC431B3065294EAD53E913BAF16D46714B013EA077191E6CA08ABA6D70E9CA792D898D692E3168D6341369976657CD5E1504B9E2458F107225176734D11621AD36D7FFA26C573D6612455B09105C41", 106);
      AppMethodBeat.o(16100);
      return true;
    }
    if (paramString1.equals("//walletofflinetest"))
    {
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(ac.a.yDA, Boolean.FALSE);
      AppMethodBeat.o(16100);
      return false;
    }
    if (paramString1.startsWith("//makemsgdata "))
    {
      i = bo.getInt(paramString1.split(" ")[1], 0);
      aw.aaz();
      com.tencent.mm.model.c.YC().af(ChattingUIFragment.ywS, i);
      AppMethodBeat.o(16100);
      return true;
    }
    if (paramString1.startsWith("//pullappservice"))
    {
      am.dlO().fT(com.tencent.mm.sdk.platformtools.ah.getContext());
      AppMethodBeat.o(16100);
      return true;
    }
    if (paramString1.startsWith("//boundaryconfig"))
    {
      ab.i("MicroMsg.CommandProcessor", "boundaryconfig SessionTextMsg:%d", new Object[] { Integer.valueOf(bo.getInt(com.tencent.mm.m.g.Nq().getValue("InputLimitSessionTextMsg"), 0)) });
      ab.i("MicroMsg.CommandProcessor", "boundaryconfig SNSObjectText:%d", new Object[] { Integer.valueOf(bo.getInt(com.tencent.mm.m.g.Nq().getValue("InputLimitSNSObjectText"), 0)) });
      ab.i("MicroMsg.CommandProcessor", "boundaryconfig SnsCommentMaxSize:%d", new Object[] { Integer.valueOf(bo.getInt(com.tencent.mm.m.g.Nq().getValue("SnsCommentMaxSize"), 0)) });
      ab.i("MicroMsg.CommandProcessor", "boundaryconfig FavText:%d", new Object[] { Integer.valueOf(bo.getInt(com.tencent.mm.m.g.Nq().getValue("InputLimitFavText"), 0)) });
      ab.i("MicroMsg.CommandProcessor", "boundaryconfig EmotionBufSize:%d", new Object[] { Integer.valueOf(bo.getInt(com.tencent.mm.m.g.Nq().getValue("InputLimitSendEmotionBufSize"), 0)) });
      ab.i("MicroMsg.CommandProcessor", "boundaryconfig EmotionWidth:%d", new Object[] { Integer.valueOf(bo.getInt(com.tencent.mm.m.g.Nq().getValue("InputLimitSendEmotionWidth"), 0)) });
      ab.i("MicroMsg.CommandProcessor", "boundaryconfig FavImageSize:%d", new Object[] { Integer.valueOf(bo.getInt(com.tencent.mm.m.g.Nq().getValue("InputLimitFavImageSize"), 0)) });
      ab.i("MicroMsg.CommandProcessor", "boundaryconfig FavVoiceLength:%d", new Object[] { Integer.valueOf(bo.getInt(com.tencent.mm.m.g.Nq().getValue("InputLimitFavVoiceLength"), 0)) });
      ab.i("MicroMsg.CommandProcessor", "boundaryconfig ShortVideoAutoDownloadBufSize:%d", new Object[] { Integer.valueOf(bo.getInt(com.tencent.mm.m.g.Nq().getValue("InputLimitSessionShortVideoBufSize"), 0)) });
      ab.i("MicroMsg.CommandProcessor", "boundaryconfig VideoSize:%d", new Object[] { Integer.valueOf(bo.getInt(com.tencent.mm.m.g.Nq().getValue("InputLimitVideoSize"), 0)) });
      ab.i("MicroMsg.CommandProcessor", "boundaryconfig FileSize:%d", new Object[] { Integer.valueOf(bo.getInt(com.tencent.mm.m.g.Nq().getValue("InputLimitFileSize"), 0)) });
      AppMethodBeat.o(16100);
      return true;
    }
    if (paramString1.startsWith("//cleanapk"))
    {
      com.tencent.mm.plugin.clean.c.j.bhc();
      AppMethodBeat.o(16100);
      return true;
    }
    if (paramString1.startsWith("//whatsnew"))
    {
      MMAppMgr.ay((Activity)paramContext);
      AppMethodBeat.o(16100);
      return true;
    }
    if (paramString1.startsWith("//profile "))
    {
      aw.aaz();
      paramString1 = com.tencent.mm.model.c.YA().arw(paramString1.replace("//profile ", "").trim());
      if ((paramString1 != null) && (paramString1.Od() != 0))
      {
        paramString2 = new Intent();
        paramString2.putExtra("Contact_User", paramString1.getUsername());
        com.tencent.mm.bq.d.b(paramContext, "profile", ".ui.ContactInfoUI", paramString2);
      }
      AppMethodBeat.o(16100);
      return true;
    }
    if (paramString1.startsWith("//minigameupdate"))
    {
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(ac.a.yxL, Long.valueOf(0L));
      AppMethodBeat.o(16100);
      return true;
    }
    if (com.tencent.mm.sdk.a.b.dsf())
    {
      if (paramString1.startsWith("//cs"))
      {
        paramContext = new Intent();
        paramContext.putExtra("voipCSBizId", "gh_b35727b00b78");
        paramContext.putExtra("voipCSAppId", "wx6e7147e8d764e85d");
        com.tencent.mm.bq.d.b(com.tencent.mm.sdk.platformtools.ah.getContext(), "voip_cs", ".ui.VoipCSMainUI", paramContext);
        AppMethodBeat.o(16100);
        return true;
      }
      if (paramString1.startsWith("//acs"))
      {
        paramContext = new Intent();
        paramContext.putExtra("voipCSBizId", "gh_e8b085bb67e0");
        paramContext.putExtra("voipCSAppId", "wx1224160e0adcefd6");
        com.tencent.mm.bq.d.b(com.tencent.mm.sdk.platformtools.ah.getContext(), "voip_cs", ".ui.VoipCSMainUI", paramContext);
        AppMethodBeat.o(16100);
        return true;
      }
      if (paramString1.startsWith("//wifiset"))
      {
        paramContext = new Intent();
        paramContext.putExtra("free_wifi_ssid", "Xiaomi_WENDY");
        paramContext.putExtra("free_wifi_passowrd", "WX12345789");
        com.tencent.mm.bq.d.b(com.tencent.mm.sdk.platformtools.ah.getContext(), "freewifi", ".ui.FreeWifiCopyPwdUI", paramContext);
        AppMethodBeat.o(16100);
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
        com.tencent.mm.bq.d.b(com.tencent.mm.sdk.platformtools.ah.getContext(), "voip_cs", ".ui.VoipCSMainUI", paramContext);
        AppMethodBeat.o(16100);
        return true;
      }
    }
    if (paramString1.startsWith("//getfpkey"))
    {
      paramString1 = bs.dyO();
      com.tencent.mm.ui.base.h.d(paramContext, paramString1, "Fingerprint Key", paramContext.getString(2131304687), paramContext.getString(2131298499), new b.9(paramContext, paramString1), null);
      AppMethodBeat.o(16100);
      return true;
    }
    if (paramString1.startsWith("//commitwd"))
    {
      WatchDogPushReceiver.akM();
      AppMethodBeat.o(16100);
      return true;
    }
    if (paramString1.startsWith("//setsnstestenv"))
    {
      localObject2 = paramString1.split(" +");
      paramString2 = null;
      if (localObject2.length <= 1) {
        break label17995;
      }
      localObject1 = localObject2[1];
      if ((!com.tencent.mm.sdk.platformtools.t.isIPv4Address((String)localObject1)) && (!com.tencent.mm.sdk.platformtools.t.isIPv6Address((String)localObject1))) {
        break label17995;
      }
      if (localObject2.length <= 2) {
        break label17990;
      }
      paramString1 = localObject2[2];
      if ((!com.tencent.mm.sdk.platformtools.t.isIPv4Address(paramString1)) && (!com.tencent.mm.sdk.platformtools.t.isIPv6Address(paramString1))) {
        break label17990;
      }
      if (localObject2.length > 3)
      {
        localObject2 = localObject2[3];
        paramString2 = paramString1;
        paramString1 = (String)localObject2;
        if (localObject1 != null) {}
        for (bool1 = true;; bool1 = false)
        {
          com.tencent.mm.platformtools.ae.gld = bool1;
          com.tencent.mm.platformtools.ae.gkU = (String)localObject1;
          com.tencent.mm.platformtools.ae.glw = paramString2;
          com.tencent.mm.platformtools.ae.glx = paramString1;
          com.tencent.mm.al.f.afL().le(5);
          Toast.makeText(paramContext, String.format("%s %s %s", new Object[] { com.tencent.mm.platformtools.ae.gkU, com.tencent.mm.platformtools.ae.glw, com.tencent.mm.platformtools.ae.glx }), 1).show();
          AppMethodBeat.o(16100);
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
            iZ(1);
            ab.i("MicroMsg.CommandProcessor", "snsvcodec val: 1");
          }
        }
        for (;;)
        {
          AppMethodBeat.o(16100);
          return true;
          if ("off".equalsIgnoreCase(paramContext))
          {
            iZ(0);
            ab.i("MicroMsg.CommandProcessor", "snsvcodec val: 0");
            continue;
            iZ(-1);
            ab.i("MicroMsg.CommandProcessor", "snsvcodec val: -1");
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
            ja(1);
            ab.i("MicroMsg.CommandProcessor", "snswxpc val: 1");
          }
        }
        for (;;)
        {
          AppMethodBeat.o(16100);
          return true;
          if ("off".equalsIgnoreCase(paramContext))
          {
            ja(0);
            ab.i("MicroMsg.CommandProcessor", "snswxpc val: 0");
            continue;
            ja(-1);
            ab.i("MicroMsg.CommandProcessor", "snswxpc val: -1");
          }
        }
      }
      if (paramString1.startsWith("//mmdumpsys"))
      {
        com.tencent.mm.sdk.g.d.ysm.execute(new b.10());
        AppMethodBeat.o(16100);
        return true;
      }
      if (paramString1.startsWith("//remittance reset"))
      {
        aw.aaz();
        com.tencent.mm.model.c.Ru().set(327729, "0");
        AppMethodBeat.o(16100);
        return true;
      }
      if (paramString1.startsWith("//wv "))
      {
        paramString1 = paramString1.replace("//wv ", "");
        paramString2 = new Intent();
        paramString2.putExtra("rawUrl", paramString1);
        com.tencent.mm.bq.d.b(paramContext, "webview", ".ui.tools.WebViewUI", paramString2);
        AppMethodBeat.o(16100);
        return true;
      }
      if (paramString1.startsWith("//wvjsapi "))
      {
        paramString1 = paramString1.replace("//wvjsapi ", "");
        paramString2 = new Intent();
        paramString2.putExtra("rawUrl", paramString1);
        com.tencent.mm.bq.d.b(paramContext, "webview", ".ui.tools.WebViewTestUI", paramString2);
        AppMethodBeat.o(16100);
        return true;
      }
      if (paramString1.startsWith("//setibeacontabuinopen"))
      {
        if (aw.RG())
        {
          aw.aaz();
          com.tencent.mm.model.c.Ru().set(ac.a.yBi, Integer.valueOf(1));
          AppMethodBeat.o(16100);
          return true;
        }
        AppMethodBeat.o(16100);
        return false;
      }
      if (paramString1.startsWith("//setibeacontabuinclose"))
      {
        if (aw.RG())
        {
          aw.aaz();
          com.tencent.mm.model.c.Ru().set(ac.a.yBi, Integer.valueOf(0));
          AppMethodBeat.o(16100);
          return true;
        }
        AppMethodBeat.o(16100);
        return false;
      }
      if (paramString1.startsWith("//setibeaconpushopen"))
      {
        if (aw.RG())
        {
          aw.aaz();
          com.tencent.mm.model.c.Ru().set(ac.a.yBd, Boolean.TRUE);
          AppMethodBeat.o(16100);
          return true;
        }
        AppMethodBeat.o(16100);
        return false;
      }
      if (paramString1.startsWith("//setibeaconpushclose"))
      {
        if (aw.RG())
        {
          aw.aaz();
          com.tencent.mm.model.c.Ru().set(ac.a.yBd, Boolean.FALSE);
          AppMethodBeat.o(16100);
          return true;
        }
        AppMethodBeat.o(16100);
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
          com.tencent.mm.ui.base.h.d(paramContext, paramString1, "TestResult", paramContext.getString(2131298161), paramContext.getString(2131298499), new b.11(paramContext, paramString1), null);
          AppMethodBeat.o(16100);
          return true;
        }
      }
      if (paramString1.startsWith("//gettbs"))
      {
        bool1 = ac.erx.erK;
        paramString1 = paramContext.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
        paramString2 = paramString1.getString("tbs_download", null);
        localObject1 = paramString1.getString("tbs_webview_disable", null);
        bool2 = paramString1.getBoolean("x5_jscore_enabled", false);
        i = WebView.getInstalledTbsCoreVersion(paramContext);
        j = WebView.getTbsSDKVersion(paramContext);
        Toast.makeText(paramContext, String.format("forceSys:%b\ntbs_download:%s\ntbs_disable:%s\ntbs_disable_min_sdk_version:%s\ntbs_disable_max_sdk_version:%s\ntbsCoreVersion:%d\ntbsSdkVersion:%d\nx5JsCoreEnabled:%b", new Object[] { Boolean.valueOf(bool1), paramString2, localObject1, paramString1.getString("tbs_webview_min_sdk_version", null), paramString1.getString("tbs_webview_max_sdk_version", null), Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool2) }), 1).show();
        AppMethodBeat.o(16100);
        return true;
      }
      if (paramString1.startsWith("//deletetbs"))
      {
        paramString1 = new Intent();
        paramString1.setComponent(new ComponentName(com.tencent.mm.sdk.platformtools.ah.getPackageName(), "com.tencent.mm.booter.MMReceivers$SandBoxProcessReceiver"));
        paramContext.sendBroadcast(paramString1);
        paramContext = paramContext.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit();
        paramContext.putLong("last_check_ts", 0L);
        paramContext.apply();
        aw.aaz();
        com.tencent.mm.model.c.Ru().set(ac.a.yCh, Boolean.FALSE);
        AppMethodBeat.o(16100);
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
          AppMethodBeat.o(16100);
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
          AppMethodBeat.o(16100);
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
          AppMethodBeat.o(16100);
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
        com.tencent.mm.ui.base.h.J(paramContext, com.tencent.mm.sdk.platformtools.g.bWu, "channelId");
      }
      if (paramString1.startsWith("//traceroute"))
      {
        com.tencent.mm.bq.d.H(paramContext, "traceroute", ".ui.NetworkDiagnoseIntroUI");
        AppMethodBeat.o(16100);
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
        if (com.tencent.mm.compatible.util.d.fv(23))
        {
          Debug.getMemoryInfo(new Debug.MemoryInfo());
          ab.i("MicroMsg.CommandProcessor", "testoom %s", new Object[] { Long.valueOf(Runtime.getRuntime().totalMemory()), Long.valueOf(Runtime.getRuntime().freeMemory()) });
        }
        AppMethodBeat.o(16100);
        return true;
      }
      if (paramString1.startsWith("//qzone "))
      {
        paramString2 = paramString1.replace("//qzone ", "");
        new com.tencent.mm.pluginsdk.ui.applet.u(paramContext).amq(paramString2);
      }
      if (paramString1.startsWith("//dumpcrash"))
      {
        com.tencent.mm.vfs.e.iF(com.tencent.mm.compatible.util.e.eQv + "crash/", com.tencent.mm.compatible.util.e.eQA);
        AppMethodBeat.o(16100);
        return true;
      }
      if (paramString1.startsWith("//dumpanr"))
      {
        com.tencent.mm.vfs.e.iF("/data/anr/", com.tencent.mm.compatible.util.e.eQA);
        AppMethodBeat.o(16100);
        return true;
      }
      if (paramString1.startsWith("//testanr"))
      {
        com.tencent.mm.model.bf.aaL();
        AppMethodBeat.o(16100);
        return true;
      }
      if (paramString1.startsWith("//opensnsadRightbar"))
      {
        com.tencent.mm.platformtools.ae.gkT = true;
        AppMethodBeat.o(16100);
        return true;
      }
      if (paramString1.startsWith("//setlocation "))
      {
        paramContext = paramString1.split(" ");
        if ((paramContext != null) && (com.tencent.mm.sdk.a.b.dsf()))
        {
          com.tencent.mm.platformtools.ae.gkj = true;
          if (paramContext.length > 0) {
            com.tencent.mm.platformtools.ae.lat = bo.getDouble(paramContext[1], 0.0D);
          }
          if (paramContext.length > 1) {
            com.tencent.mm.platformtools.ae.lng = bo.getDouble(paramContext[2], 0.0D);
          }
          AppMethodBeat.o(16100);
          return true;
        }
        AppMethodBeat.o(16100);
        return false;
      }
      if (paramString1.startsWith("//switchsdcard"))
      {
        paramString1 = com.tencent.mm.sdk.platformtools.bd.dtF();
        j = paramString1.size();
        ab.i("MicroMsg.CommandProcessor", "switchsdcard sdcard size = ".concat(String.valueOf(j)));
        if ((j > 0) && (paramString1.get(0) != null) && (!bo.isNullOrNil(((bd.a)paramString1.get(0)).yqc)))
        {
          i = 0;
          while (i < j)
          {
            ab.i("MicroMsg.CommandProcessor", "switchsdcard list i = " + i + " StatMountParse: " + paramString1.get(i));
            i += 1;
          }
        }
        i = 0;
        for (;;)
        {
          if (i >= j) {
            break label17974;
          }
          if (!((bd.a)paramString1.get(i)).yqc.equals(com.tencent.mm.compatible.util.e.eQx))
          {
            paramString1 = ((bd.a)paramString1.get(i)).yqc;
            paramString2 = (Activity)paramContext;
            ab.i("MicroMsg.CommandProcessor", "switchsdcard newSdcard: ".concat(String.valueOf(paramString1)));
            if (!bo.isNullOrNil(paramString1)) {
              break;
            }
            com.tencent.mm.ui.base.h.bM(paramContext, paramContext.getString(2131304219));
            AppMethodBeat.o(16100);
            return true;
          }
          i += 1;
        }
        com.tencent.mm.ui.base.h.d(paramContext, paramContext.getString(2131304220), "", paramContext.getString(2131297018), paramContext.getString(2131296888), new b.12(paramString1, paramContext, paramString2), null);
        AppMethodBeat.o(16100);
        return true;
      }
      if (paramString1.startsWith("//getip"))
      {
        aw.Rc().b(new bk(new b.13()));
        AppMethodBeat.o(16100);
        return true;
      }
      if (paramString1.startsWith("//localjsapi"))
      {
        paramString1 = "file://" + com.tencent.mm.compatible.util.e.eQz + "test_jsapi.html";
        ab.v("MicroMsg.CommandProcessor", "alvinluo path: %s", new Object[] { paramString1 });
        paramString2 = new Intent();
        paramString2.putExtra("rawUrl", paramString1);
        com.tencent.mm.bq.d.b(paramContext, "webview", ".ui.tools.WebViewUI", paramString2);
        AppMethodBeat.o(16100);
        return true;
      }
      if (paramString1.startsWith("//getlocalkey"))
      {
        paramString1 = bs.dyN();
        com.tencent.mm.ui.base.h.d(paramContext, paramString1, "Fingerprint Key", paramContext.getString(2131304687), paramContext.getString(2131298499), new b.14(paramContext, paramString1), null);
        AppMethodBeat.o(16100);
        return true;
      }
      if (paramString1.startsWith("//getdevid"))
      {
        paramString1 = com.tencent.mm.compatible.e.q.LK();
        com.tencent.mm.ui.base.h.d(paramContext, paramString1, "devid", paramContext.getString(2131298161), paramContext.getString(2131298499), new b.15(paramContext, paramString1), null);
        AppMethodBeat.o(16100);
        return true;
      }
      if (paramString1.startsWith("//testhtml"))
      {
        paramString1 = new Intent();
        paramString1.putExtra("rawUrl", "file:///android_asset/jsapi/reader_test1.html");
        com.tencent.mm.bq.d.b(paramContext, "webview", ".ui.tools.WebViewUI", paramString1);
        AppMethodBeat.o(16100);
        return true;
      }
      if (paramString1.startsWith("//testlocalhtml "))
      {
        paramString1 = paramString1.replace("//testlocalhtml ", "");
        paramString2 = new Intent();
        paramString2.putExtra("rawUrl", "file://".concat(String.valueOf(paramString1)));
        paramString2.putExtra("neverGetA8Key", true);
        com.tencent.mm.bq.d.b(paramContext, "webview", ".ui.tools.WebViewUI", paramString2);
        AppMethodBeat.o(16100);
        return true;
      }
      if (paramString1.startsWith("//setkey"))
      {
        if (bs.asD(paramString1.replace("//setkey", ""))) {
          Toast.makeText(paramContext, 2131304638, 0).show();
        }
        AppMethodBeat.o(16100);
        return true;
      }
      if (paramString1.startsWith("//checkspell"))
      {
        paramString1 = paramString1.replace("//checkspell ", "");
        if (bo.isNullOrNil(paramString1))
        {
          AppMethodBeat.o(16100);
          return true;
        }
        paramString2 = new StringBuilder();
        i = 0;
        while (i < paramString1.length())
        {
          paramString2.append("[" + paramString1.charAt(i) + ":" + SpellMap.u(paramString1.charAt(i)) + "]");
          i += 1;
        }
        com.tencent.mm.ui.base.h.J(paramContext, paramString2.toString(), "Check Spell");
        AppMethodBeat.o(16100);
        return true;
      }
      if (paramString1.startsWith("//gallery "))
      {
        paramString1 = paramString1.replace("//gallery ", "");
        if (bo.isNullOrNil(paramString1))
        {
          AppMethodBeat.o(16100);
          return true;
        }
        paramContext.getSharedPreferences(com.tencent.mm.sdk.platformtools.ah.dsP(), 0).edit().putString("gallery", paramString1).commit();
        AppMethodBeat.o(16100);
        return true;
      }
      if (paramString1.startsWith("//svgtag"))
      {
        paramContext = paramString1.replace("//svgtag ", "");
        if (paramContext.equals("on")) {
          com.tencent.mm.cc.d.pA(true);
        }
        for (;;)
        {
          AppMethodBeat.o(16100);
          return true;
          if (paramContext.equals("off")) {
            com.tencent.mm.cc.d.pA(false);
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
          ab.printErrStackTrace("MicroMsg.CommandProcessor", paramContext, "", new Object[0]);
          bool1 = false;
        }
      }
      catch (NoSuchFieldException paramContext)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.CommandProcessor", paramContext, "", new Object[0]);
          bool1 = false;
        }
      }
      catch (IllegalAccessException paramContext)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.CommandProcessor", paramContext, "", new Object[0]);
          bool1 = false;
        }
      }
      catch (IllegalArgumentException paramContext)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.CommandProcessor", paramContext, "", new Object[0]);
          bool1 = false;
        }
        if (!paramString1.startsWith("//testMbanner")) {
          break label7474;
        }
        try
        {
          paramContext = paramString1.replace("//testMbanner ", "").split(",");
          if (paramContext.length < 2) {
            break label7466;
          }
          com.tencent.mm.model.be.aaG().a(new com.tencent.mm.model.bd(Integer.valueOf(paramContext[0]).intValue(), Integer.valueOf(paramContext[1]).intValue(), null));
          AppMethodBeat.o(16100);
          return true;
          if (!paramString1.startsWith("//testrsa")) {
            break label7495;
          }
          com.tencent.mm.protocal.aa.T("010001", "E338E5DAD46B331E3071FAFD4C0F84C7C7965DBBE64C6F8CC0F7CF04DC640C1F84A2014431A48D65F2B2F172BA9BE6F5A049BF52C78C14B0965E20F0D80D85A9180EBABB913D49821D28BFD9601DF52A4F3230AECAD96D23415F5E94D51A87CAA7630C5F3CB70345BAF572A4F61A134A2265AFD8FADDFE0222BD9ABF7DBEB7444D031454E8F21820BBC725E6857F765660E987FADEBCF6B3A15355C4CD3752A7B544D1D7E037AF4F9725BE37681A84C9E1DC431B3065294EAD53E913BAF16D46714B013EA077191E6CA08ABA6D70E9CA792D898D692E3168D6341369976657CD5E1504B9E2458F107225176734D11621AD36D7FFA26C573D6612455B09105C41", 106);
          if (!paramString1.startsWith("//recomT")) {
            break label7535;
          }
          try
          {
            paramContext = paramString1.replace("//recomT ", "");
            aw.aaz().YY().a(paramContext, true, null);
            AppMethodBeat.o(16100);
            return true;
            if (!paramString1.startsWith("//recomF")) {
              break label7575;
            }
            try
            {
              paramContext = paramString1.replace("//recomF ", "");
              aw.aaz().YY().a(paramContext, false, null);
              AppMethodBeat.o(16100);
              return true;
              if (!paramString1.startsWith("//resetwxpayagree")) {
                break label7612;
              }
              com.tencent.mm.kernel.g.RM();
              com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yJM, Boolean.FALSE);
              AppMethodBeat.o(16100);
              return true;
              if (!paramString1.startsWith("//ffmpeg")) {
                break label7751;
              }
              try
              {
                i = paramString1.indexOf("-r ");
                j = paramString1.indexOf("-b ");
                paramContext = paramString1.substring(i + 3, j);
                paramString1 = paramString1.substring(j + 3);
                float f = bo.getFloat(paramContext.trim(), 0.0F);
                i = bo.getInt(paramString1.trim(), 0);
                com.tencent.mm.plugin.sight.base.b.qSq = i;
                com.tencent.mm.plugin.sight.base.b.qSr = f;
                Toast.makeText(com.tencent.mm.sdk.platformtools.ah.getContext(), "set C2C video encode frame rate " + f + " bitrate " + i, 0).show();
                AppMethodBeat.o(16100);
                return true;
              }
              catch (Exception paramContext)
              {
                for (;;)
                {
                  Toast.makeText(com.tencent.mm.sdk.platformtools.ah.getContext(), "set C2C video frame rate fail, please ensure your command.", 1).show();
                }
              }
              if (!paramString1.startsWith("//onlinevideo")) {
                break label7858;
              }
              for (;;)
              {
                try
                {
                  i = bo.getInt(paramString1.replace("//onlinevideo ", ""), 0);
                  aw.aaz();
                  com.tencent.mm.model.c.Ru().set(ac.a.yDz, Integer.valueOf(i));
                  if (i <= 0) {
                    continue;
                  }
                  paramContext = "online video";
                  Toast.makeText(com.tencent.mm.sdk.platformtools.ah.getContext(), paramContext, 0).show();
                }
                catch (Exception paramContext)
                {
                  ab.printErrStackTrace("MicroMsg.CommandProcessor", paramContext, "", new Object[0]);
                  Toast.makeText(com.tencent.mm.sdk.platformtools.ah.getContext(), "set online video fail, please ensure your command.", 1).show();
                  continue;
                }
                AppMethodBeat.o(16100);
                return true;
                paramContext = "offline video";
              }
              if (!paramString1.startsWith("//hevcinfo")) {
                break label7924;
              }
              paramContext = com.tencent.mm.plugin.n.e.bQs();
              paramString1 = ChattingUIFragment.ywS;
              paramString2 = new bi();
              paramString2.kj(paramString1);
              paramString2.hL(2);
              paramString2.setType(1);
              paramString2.fQ(System.currentTimeMillis());
              paramString2.setContent(paramContext);
              com.tencent.mm.model.bf.l(paramString2);
              AppMethodBeat.o(16100);
              return true;
              if (!paramString1.startsWith("//presns")) {
                break label7973;
              }
              com.tencent.mm.sdk.g.d.ysm.r(new b.2(), 3000L);
              Toast.makeText(com.tencent.mm.sdk.platformtools.ah.getContext(), "preload sns", 0).show();
              AppMethodBeat.o(16100);
              return true;
              if (!paramString1.startsWith("//calcwxdata")) {
                break label8021;
              }
              aw.aaz();
              com.tencent.mm.model.c.Ru().set(ac.a.yGz, Long.valueOf(0L));
              Toast.makeText(com.tencent.mm.sdk.platformtools.ah.getContext(), "calc wx data success", 0).show();
              AppMethodBeat.o(16100);
              return true;
              if (!paramString1.startsWith("//checkspace")) {
                break label8129;
              }
              try
              {
                i = bo.getInt(paramString1.replace("//checkspace ", ""), 0);
                paramContext = new com.tencent.mm.g.a.bf();
                paramContext.coG.coH = i;
                com.tencent.mm.sdk.b.a.ymk.l(paramContext);
                Toast.makeText(com.tencent.mm.sdk.platformtools.ah.getContext(), "check space code ".concat(String.valueOf(i)), 0).show();
                AppMethodBeat.o(16100);
                return true;
              }
              catch (Exception paramContext)
              {
                for (;;)
                {
                  ab.printErrStackTrace("MicroMsg.CommandProcessor", paramContext, "", new Object[0]);
                  Toast.makeText(com.tencent.mm.sdk.platformtools.ah.getContext(), "check space code fail, please ensure your command.", 1).show();
                }
              }
              if ((!paramString1.startsWith("//showkv")) || (!com.tencent.mm.sdk.a.b.dsf())) {
                break label8213;
              }
              try
              {
                paramString2 = new Intent();
                paramString2.addFlags(134217728);
                paramString2.addFlags(524288);
                ((com.tencent.mm.plugin.kitchen.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.kitchen.a.a.class)).u(paramContext, paramString2);
                AppMethodBeat.o(16100);
                return true;
              }
              catch (Exception paramString2)
              {
                ab.e("MicroMsg.CommandProcessor", "showkv error [%s]", new Object[] { paramString2.toString() });
              }
              if ((!paramString1.startsWith("//showexpt")) || (!com.tencent.mm.sdk.a.b.dsf())) {
                break label8259;
              }
              ((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).r(paramContext, new Intent());
              AppMethodBeat.o(16100);
              return true;
              if ((!paramString1.startsWith("//showroomexpt")) || (!com.tencent.mm.sdk.a.b.dsf())) {
                break label8305;
              }
              ((com.tencent.mm.plugin.expt.roomexpt.d)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.roomexpt.d.class)).t(paramContext, new Intent());
              AppMethodBeat.o(16100);
              return true;
              if (!paramString1.startsWith("//upfacemodel")) {
                break label8339;
              }
              aw.Rc().b(new com.tencent.mm.pluginsdk.g.a.a.m(42));
              AppMethodBeat.o(16100);
              return true;
              if (!paramString1.startsWith("//facett")) {
                break label8373;
              }
              aw.aaz();
              com.tencent.mm.model.c.Ru().set(ac.a.yFf, Boolean.FALSE);
              AppMethodBeat.o(16100);
              return true;
              if (!paramString1.startsWith("//startstory")) {
                break label8395;
              }
              com.tencent.mm.platformtools.ae.glK = true;
              AppMethodBeat.o(16100);
              return true;
              if (!paramString1.startsWith("//switchpaytype")) {
                break label8483;
              }
              paramContext = paramString1.split(" ");
              if ((paramContext == null) || (paramContext.length < 2)) {
                break label8475;
              }
              try
              {
                i = bo.getInt(paramContext[1], 0);
                aw.aaz();
                com.tencent.mm.model.c.Ru().set(339975, Integer.valueOf(i));
                AppMethodBeat.o(16100);
                return true;
              }
              catch (Exception paramContext)
              {
                ab.e("MicroMsg.CommandProcessor", "hy: switch wallet type error");
                AppMethodBeat.o(16100);
                return false;
              }
              AppMethodBeat.o(16100);
              return false;
              if (!paramString1.startsWith("//setNfcOpenUrl ")) {
                break label8553;
              }
              paramString1 = paramString1.replace("//setNfcOpenUrl ", "");
              paramString2 = com.tencent.mm.sdk.platformtools.ah.dsR().edit();
              paramContext = paramString1;
              if (!paramString1.equalsIgnoreCase("null")) {
                break label8527;
              }
              paramContext = "";
              paramString2.putString("nfc_open_url", paramContext);
              paramString2.commit();
              AppMethodBeat.o(16100);
              return true;
              if (!paramString1.startsWith("//setMBV8Debug ")) {
                break label8632;
              }
              paramContext = paramString1.replace("//setMBV8Debug ", "");
              paramString1 = com.tencent.mm.sdk.platformtools.ah.dsR().edit();
              if (!paramContext.equalsIgnoreCase("true")) {
                break label8618;
              }
              paramString1.putBoolean("appbrandgame_open_v8debug", true);
              for (;;)
              {
                paramString1.commit();
                AppMethodBeat.o(16100);
                return true;
                paramString1.putBoolean("appbrandgame_open_v8debug", false);
              }
              if (!paramString1.startsWith("//setWcwss ")) {
                break label8702;
              }
              paramString1 = paramString1.replace("//setWcwss ", "");
              paramString2 = com.tencent.mm.sdk.platformtools.ah.dsR().edit();
              paramContext = paramString1;
              if (!paramString1.equalsIgnoreCase("null")) {
                break label8676;
              }
              paramContext = "";
              paramString2.putString("appbrandgame_open_wcwss", paramContext);
              paramString2.commit();
              AppMethodBeat.o(16100);
              return true;
              if (!paramString1.startsWith("//gamecb ")) {
                break label8829;
              }
              paramContext = paramString1.replace("//gamecb ", "").trim();
              paramString1 = com.tencent.mm.sdk.platformtools.ah.dsR().edit();
              i = bo.apV(paramContext);
              paramString1.putInt("appbrandgame_use_commandbuffer", i);
              paramString2 = com.tencent.mm.sdk.platformtools.ah.getContext();
              localObject1 = new StringBuilder("小游戏 CommandBuffer ");
              if (i != 0) {
                break label8809;
              }
              paramContext = "关闭";
              for (;;)
              {
                Toast.makeText(paramString2, paramContext, 1).show();
                paramString1.commit();
                AppMethodBeat.o(16100);
                return true;
                if (i == -1) {
                  paramContext = "默认";
                } else {
                  paramContext = "开启";
                }
              }
              if (!paramString1.startsWith("//setAppBrandActionBar ")) {
                break label8908;
              }
              paramContext = paramString1.replace("//setAppBrandActionBar ", "");
              paramString1 = com.tencent.mm.sdk.platformtools.ah.dsR().edit();
              if (!paramContext.equalsIgnoreCase("new")) {
                break label8894;
              }
              paramString1.putBoolean("appbrand_new_actionbar", true);
              for (;;)
              {
                paramString1.commit();
                AppMethodBeat.o(16100);
                return true;
                paramString1.putBoolean("appbrand_new_actionbar", false);
              }
              if (!paramString1.startsWith("//snskvtest ")) {
                break label8970;
              }
              paramContext = paramString1.replace("//snskvtest", "").trim();
              if (!paramContext.equals("0")) {
                break label8953;
              }
              com.tencent.mm.platformtools.ae.glp = false;
              for (;;)
              {
                AppMethodBeat.o(16100);
                return true;
                if (paramContext.equals("1")) {
                  com.tencent.mm.platformtools.ae.glp = true;
                }
              }
              if (!paramString1.startsWith("//emoji ")) {
                break label9018;
              }
              paramContext = paramString1.replace("//emoji ", "");
              ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().KE(paramContext);
              AppMethodBeat.o(16100);
              return true;
              if (!paramString1.startsWith("//share ")) {
                break label9071;
              }
              i = Integer.valueOf(paramString1.replace("//share ", "")).intValue();
              aw.aaz();
              com.tencent.mm.model.c.Ru().set(229635, Integer.valueOf(i));
              AppMethodBeat.o(16100);
              return true;
              if (!paramString1.startsWith("//dumpappinfoblob ")) {
                break label9155;
              }
              paramString1 = paramString1.replace("//dumpappinfoblob ", "");
              paramString1 = com.tencent.mm.pluginsdk.model.app.al.cac().als(paramString1);
              com.tencent.mm.ui.base.h.J(paramContext, paramString1.Hn() + "\n" + paramString1.Ho() + "\n" + paramString1.Hp(), "");
              AppMethodBeat.o(16100);
              return true;
              if (!paramString1.startsWith("//googleauth ")) {
                break label9269;
              }
              paramString1 = paramString1.replace("//googleauth ", "");
              if (TextUtils.isEmpty(paramString1)) {
                break label9220;
              }
              if (!"webview".equals(paramString1)) {
                break label9228;
              }
              paramContext.getSharedPreferences(com.tencent.mm.sdk.platformtools.ah.dsP(), 0).edit().putBoolean("googleauth", true).commit();
              for (;;)
              {
                AppMethodBeat.o(16100);
                return true;
                if ("local".equals(paramString1)) {
                  paramContext.getSharedPreferences(com.tencent.mm.sdk.platformtools.ah.dsP(), 0).edit().putBoolean("googleauth", false).commit();
                }
              }
              if (!paramString1.startsWith("//clrgamecache")) {
                break label9302;
              }
              paramString1 = b.a.bEX();
              if (paramString1 == null) {
                break label9294;
              }
              paramString1.dZ(paramContext);
              AppMethodBeat.o(16100);
              return true;
              if (!paramString1.startsWith("//clearwepkg")) {
                break label9383;
              }
              paramContext = new wi();
              paramContext.cNO.coO = 6;
              paramString1 = paramString1.replace("//clearwepkg ", "").trim();
              if ((bo.isNullOrNil(paramString1)) || (paramString1.equals("//clearwepkg"))) {
                break label9367;
              }
              paramContext.cNO.cNP = paramString1;
              com.tencent.mm.sdk.b.a.ymk.l(paramContext);
              AppMethodBeat.o(16100);
              return true;
              if (!paramString1.startsWith("//disableWePkg")) {
                break label9426;
              }
              paramContext = new wi();
              paramContext.cNO.coO = 7;
              com.tencent.mm.sdk.b.a.ymk.l(paramContext);
              AppMethodBeat.o(16100);
              return true;
              if (!paramString1.startsWith("//updateGameConfig")) {
                break label9468;
              }
              paramContext = new gv();
              paramContext.cvM.vA = 5;
              com.tencent.mm.sdk.b.a.ymk.l(paramContext);
              AppMethodBeat.o(16100);
              return true;
              if (!paramString1.startsWith("//clrgsd")) {
                break label9548;
              }
              paramContext = new hc();
              paramContext.cwd.coO = 3;
              paramString1 = paramString1.replace("//clrgsd ", "").trim();
              if ((bo.isNullOrNil(paramString1)) || (paramString1.equals("//clrgsd"))) {
                break label9532;
              }
              paramContext.cwd.cwc = paramString1;
              com.tencent.mm.sdk.b.a.ymk.l(paramContext);
              AppMethodBeat.o(16100);
              return true;
              if (!paramString1.startsWith("//delDownload")) {
                break label9628;
              }
              paramContext = new hc();
              paramContext.cwd.coO = 4;
              paramString1 = paramString1.replace("//delDownload ", "").trim();
              if ((bo.isNullOrNil(paramString1)) || (paramString1.equals("//delDownload"))) {
                break label9620;
              }
              paramContext.cwd.cwc = paramString1;
              com.tencent.mm.sdk.b.a.ymk.l(paramContext);
              AppMethodBeat.o(16100);
              return true;
              if (!paramString1.startsWith("//googlemap")) {
                break label9650;
              }
              com.tencent.mm.platformtools.ae.gkS = true;
              AppMethodBeat.o(16100);
              return true;
              if (!paramString1.startsWith("//sosomap")) {
                break label9672;
              }
              com.tencent.mm.platformtools.ae.gkS = false;
              AppMethodBeat.o(16100);
              return true;
              if (!paramString1.startsWith("//opentrace")) {
                break label9704;
              }
              new com.tencent.mm.ui.applet.d();
              com.tencent.mm.ui.applet.d.ic(com.tencent.mm.sdk.platformtools.ah.getContext());
              AppMethodBeat.o(16100);
              return true;
              if (!paramString1.startsWith("//updateConversation")) {
                break label9808;
              }
              ab.i("MicroMsg.CommandProcessor", "update all conversation start");
              aw.aaz();
              paramContext = com.tencent.mm.model.c.YF().dxi().iterator();
              while (paramContext.hasNext())
              {
                paramString1 = (String)paramContext.next();
                aw.aaz();
                paramString1 = com.tencent.mm.model.c.YC().fi(paramString1, " and not ( type = 10000 and isSend != 2 ) ");
                aw.aaz();
                com.tencent.mm.model.c.YF().ar(paramString1);
              }
              ab.i("MicroMsg.CommandProcessor", "update all conversation end");
              AppMethodBeat.o(16100);
              return true;
              if (!paramString1.startsWith("//setshakecarddata")) {
                break label9834;
              }
              p.a.dkR().clj();
              AppMethodBeat.o(16100);
              return true;
              if (!paramString1.startsWith("//clearshakecarddata")) {
                break label9860;
              }
              p.a.dkR().clk();
              AppMethodBeat.o(16100);
              return true;
              if (!paramString1.startsWith("//pageSize")) {
                break label9918;
              }
              paramContext = com.tencent.mm.sdk.platformtools.ah.getContext();
              paramString1 = new StringBuilder("pageSize is ");
              aw.aaz();
              Toast.makeText(paramContext, com.tencent.mm.model.c.Rq().getPageSize(), 1).show();
              AppMethodBeat.o(16100);
              return true;
              if (!paramString1.startsWith("//resetDBStatus")) {
                break label10096;
              }
              aw.aaz();
              paramContext = new com.tencent.mm.vfs.b(com.tencent.mm.model.c.Rs());
              try
              {
                paramString1 = new StringBuilder();
                aw.aaz();
                paramString1 = com.tencent.mm.model.c.Rp() + paramContext.getName().replace(".db", ".db.backup");
                com.tencent.mm.vfs.e.C(paramString1, paramContext.getPath());
                ab.i("MicroMsg.CommandProcessor", "backupPath db path is %s", new Object[] { paramString1 });
                paramString1 = paramContext.getAbsolutePath() + "err" + System.currentTimeMillis();
                com.tencent.mm.vfs.e.aT(paramContext.getPath(), paramString1);
                Toast.makeText(com.tencent.mm.sdk.platformtools.ah.getContext(), "db状态已重置,请重启微信", 1).show();
                AppMethodBeat.o(16100);
                return true;
              }
              catch (Exception paramContext)
              {
                for (;;)
                {
                  ab.w("MicroMsg.CommandProcessor", "delete failed: " + paramContext.getMessage());
                }
              }
              if (!paramString1.startsWith("//makesnsdata ")) {
                break label10140;
              }
              i = bo.getInt(paramString1.replace("//makesnsdata ", ""), 0);
              p.d.dkS().lm(i);
              AppMethodBeat.o(16100);
              return true;
              if (!paramString1.startsWith("//setsnsupload ")) {
                break label10174;
              }
              com.tencent.mm.platformtools.ae.glc = bo.getInt(paramString1.replace("//setsnsupload ", ""), 0);
              AppMethodBeat.o(16100);
              return true;
              if (!paramString1.startsWith("//logsnstable")) {
                break label10208;
              }
              paramContext = new cq();
              com.tencent.mm.sdk.b.a.ymk.l(paramContext);
              AppMethodBeat.o(16100);
              return true;
              if (!paramString1.startsWith("//resetsnstip")) {
                break label10243;
              }
              aw.aaz();
              com.tencent.mm.model.c.Ru().set(327776, Integer.valueOf(0));
              AppMethodBeat.o(16100);
              return true;
              if (!paramString1.startsWith("//checkcount")) {
                break label10332;
              }
              aw.aaz();
              i = com.tencent.mm.model.c.YC().pw(ChattingUIFragment.ywS);
              aw.aaz();
              j = com.tencent.mm.model.c.YC().TA(ChattingUIFragment.ywS);
              Toast.makeText(paramContext, "current count :" + i + " countAuto :" + j, 1).show();
              AppMethodBeat.o(16100);
              return true;
              if (!paramString1.startsWith("//changeframe ")) {
                break label10396;
              }
              paramContext = paramString1.replace("//changeframe ", "");
              com.tencent.mm.sdk.platformtools.ah.getContext().getSharedPreferences("preferences_animation", 0).edit().putFloat("frameInterval", Float.valueOf(paramContext).floatValue()).commit();
              AppMethodBeat.o(16100);
              return true;
              if (!paramString1.startsWith("//opendumpview")) {
                break label10428;
              }
              new com.tencent.mm.ui.applet.c();
              com.tencent.mm.ui.applet.c.ib(com.tencent.mm.sdk.platformtools.ah.getContext());
              AppMethodBeat.o(16100);
              return true;
              if (!paramString1.startsWith("//dumpmemory")) {
                break label10455;
              }
              System.gc();
              System.gc();
              com.tencent.mm.ci.b.dAr();
              AppMethodBeat.o(16100);
              return true;
              if (!paramString1.startsWith("//dumpsnsfile")) {
                break label10489;
              }
              paramContext = new rm();
              com.tencent.mm.sdk.b.a.ymk.l(paramContext);
              AppMethodBeat.o(16100);
              return true;
              if (!paramString1.startsWith("//coverage")) {
                break label10520;
              }
              com.tencent.mm.plugin.report.b.f.Ys(paramString1.trim().substring(10));
              AppMethodBeat.o(16100);
              return true;
              if (!paramString1.startsWith("//dumpthreadpool")) {
                break label10547;
              }
              com.tencent.mm.sdk.g.d.ysm.dut();
              AppMethodBeat.o(16100);
              return true;
              if (!paramString1.startsWith("//testverifypsw ")) {
                break label10634;
              }
              paramContext = paramString1.replace("//testverifypsw ", "").trim();
              if (!paramContext.equals("0")) {
                break label10617;
              }
              com.tencent.mm.platformtools.ae.glr = false;
              for (;;)
              {
                ab.d("MicroMsg.CommandProcessor", "summerdktext testverifypsw msg[%s], testVerifyPsw[%b]", new Object[] { paramString1, Boolean.valueOf(com.tencent.mm.platformtools.ae.glr) });
                AppMethodBeat.o(16100);
                return true;
                if (paramContext.equals("1")) {
                  com.tencent.mm.platformtools.ae.glr = true;
                }
              }
              if (!paramString1.startsWith("//pickpoi")) {
                break label10681;
              }
              paramString1 = new Intent();
              paramString1.putExtra("map_view_type", 8);
              com.tencent.mm.bq.d.b(paramContext, "location", ".ui.RedirectUI", paramString1);
              AppMethodBeat.o(16100);
              return true;
              if (!paramString1.startsWith("//configlist")) {
                break label10974;
              }
              if (!paramString1.matches("^//configlist set ([\\S]*)=([\\S]*)$")) {
                break label10777;
              }
              paramString1 = com.tencent.mm.platformtools.ah.bg(paramString1, "^//configlist set ([\\S]*)=([\\S]*)$");
              if ((paramString1 == null) || (paramString1.size() != 2)) {
                break label10769;
              }
              paramContext = (String)paramString1.get(0);
              paramString1 = (String)paramString1.get(1);
              com.tencent.mm.m.g.Nq().put(paramContext, paramString1);
              paramContext = new cr();
              com.tencent.mm.sdk.b.a.ymk.l(paramContext);
              for (;;)
              {
                AppMethodBeat.o(16100);
                return true;
                if (paramString1.matches("^//configlist get ([\\S]*)$"))
                {
                  paramString1 = com.tencent.mm.platformtools.ah.bg(paramString1, "^//configlist get ([\\S]*)$");
                  if ((paramString1 != null) && (paramString1.size() == 1))
                  {
                    paramString1 = (String)paramString1.get(0);
                    paramString2 = com.tencent.mm.m.g.Nq().getValue(paramString1);
                    Toast.makeText(paramContext, paramString1 + "=" + paramString2, 0).show();
                  }
                }
                else
                {
                  aw.aaz();
                  paramString1 = (String)com.tencent.mm.model.c.Ru().get(278530, "");
                  aw.aaz();
                  paramString2 = (String)com.tencent.mm.model.c.Ru().get(278529, "");
                  localObject1 = com.tencent.mm.compatible.util.e.eQz + "dynacfg.xml";
                  bo.z((String)localObject1, (paramString1 + paramString2).getBytes());
                  Toast.makeText(paramContext, "output dynacfg xml to ".concat(String.valueOf(localObject1)), 0).show();
                }
              }
              if (!paramString1.startsWith("//security")) {
                break label11014;
              }
              try
              {
                paramContext = paramString1.replace("//security ", "");
                aw.aaz().YZ().a(paramContext, true, null);
                AppMethodBeat.o(16100);
                return true;
                if (!paramString1.startsWith("//updatepackage")) {
                  break label11064;
                }
                try
                {
                  paramContext = new com.tencent.mm.ba.k(bo.getInt(paramString1.replace("//updatepackage ", "").trim(), 0));
                  aw.Rc().b(paramContext);
                  AppMethodBeat.o(16100);
                  return true;
                  if (!paramString1.startsWith("//copypackage")) {
                    break label11189;
                  }
                  ab.i("MicroMsg.CommandProcessor", "summercmd copypackage msg:%s", new Object[] { paramString1 });
                  paramString1 = com.tencent.mm.sdk.platformtools.bd.dtF();
                  i = paramString1.size();
                  ab.i("MicroMsg.CommandProcessor", "summercmd copypackage size:%d", new Object[] { Integer.valueOf(i) });
                  if (i >= 2) {
                    break label11146;
                  }
                  com.tencent.mm.ui.base.h.bM(paramContext, paramContext.getString(2131298868));
                  for (;;)
                  {
                    AppMethodBeat.o(16100);
                    return true;
                    com.tencent.mm.ui.base.h.d(paramContext, paramContext.getString(2131298870), "", paramContext.getString(2131297018), paramContext.getString(2131296888), new b.3(i, paramString1, paramContext), null);
                  }
                  if (!paramString1.startsWith("//copy -n ")) {
                    break label11315;
                  }
                  ab.i("MicroMsg.CommandProcessor", "summercmd copy -n msg:%s ", new Object[] { paramString1 });
                  paramString2 = com.tencent.mm.sdk.platformtools.bd.dtF();
                  i = paramString2.size();
                  ab.i("MicroMsg.CommandProcessor", "summercmd copy -n size:%d", new Object[] { Integer.valueOf(i) });
                  if (i >= 2) {
                    break label11271;
                  }
                  com.tencent.mm.ui.base.h.bM(paramContext, paramContext.getString(2131298868));
                  for (;;)
                  {
                    AppMethodBeat.o(16100);
                    return true;
                    com.tencent.mm.ui.base.h.d(paramContext, paramContext.getString(2131298870), "", paramContext.getString(2131297018), paramContext.getString(2131296888), new b.4(paramString1, i, paramString2, paramContext), null);
                  }
                  if (!paramString1.startsWith("//deletepackage")) {
                    break label11371;
                  }
                  try
                  {
                    paramContext = paramString1.replace("//deletepackage ", "");
                    paramString1 = new cj();
                    paramString1.cpP.cpQ = bo.getInt(paramContext, 0);
                    com.tencent.mm.sdk.b.a.ymk.l(paramString1);
                    AppMethodBeat.o(16100);
                    return true;
                    if (!paramString1.startsWith("//audiowritetofile")) {
                      break label11396;
                    }
                    ac.erv.enj = true;
                    AppMethodBeat.o(16100);
                    return true;
                    if (!paramString1.startsWith("//bankcard")) {
                      break label11471;
                    }
                    paramString1 = new Intent();
                    paramString1.putExtra("BaseScanUI_select_scan_mode", 7);
                    paramString1.putExtra("bank_card_owner", "test");
                    if ((com.tencent.mm.plugin.voip.e.bN(paramContext)) || (com.tencent.mm.bg.e.bM(paramContext))) {
                      break label11463;
                    }
                    com.tencent.mm.bq.d.b((Activity)paramContext, "scanner", ".ui.BaseScanUI", paramString1);
                    AppMethodBeat.o(16100);
                    return true;
                    if (!paramString1.startsWith("//banner")) {
                      break label11548;
                    }
                    paramString2 = br.F("<sysmsg type=\"banner\"><mainframebanner type=\"11\"><showtype>1</showtype></mainframebanner></sysmsg>", "sysmsg");
                    ab.d("MicroMsg.CommandProcessor", "type:%s showType:%s data:%s", new Object[] { (String)paramString2.get(".sysmsg.mainframebanner.$type"), (String)paramString2.get(".sysmsg.mainframebanner.showtype"), (String)paramString2.get(".sysmsg.mainframebanner.data") });
                    if (!paramString1.startsWith("//gamemsg")) {
                      break label11590;
                    }
                    paramContext = new ng();
                    paramContext.cDy.content = paramString1;
                    com.tencent.mm.sdk.b.a.ymk.l(paramContext);
                    AppMethodBeat.o(16100);
                    return true;
                    if (!paramString1.startsWith("//shortcut#")) {
                      break label11632;
                    }
                    paramContext = new wd();
                    paramContext.cNt.cNu = paramString1;
                    com.tencent.mm.sdk.b.a.ymk.l(paramContext);
                    AppMethodBeat.o(16100);
                    return true;
                    if (!paramString1.startsWith("//gallerytype")) {
                      break label11670;
                    }
                    if (com.tencent.mm.ui.chatting.p.zyH) {
                      break label11664;
                    }
                    for (bool1 = true;; bool1 = false)
                    {
                      com.tencent.mm.ui.chatting.p.zyH = bool1;
                      AppMethodBeat.o(16100);
                      return true;
                    }
                    paramContext.getString(2131304770);
                    if (!paramString1.startsWith("//fullexit")) {
                      break label11725;
                    }
                    com.tencent.mm.sdk.platformtools.aj.apl("show_whatsnew");
                    com.tencent.mm.kernel.l.n(paramContext, true);
                    MMAppMgr.bi(paramContext);
                    aw.hold();
                    com.tencent.mm.kernel.g.RM().mD("");
                    MMAppMgr.aAc();
                    AppMethodBeat.o(16100);
                    return true;
                    if (!paramString1.startsWith("//cleardldb")) {
                      break label11754;
                    }
                    aw.aaz();
                    com.tencent.mm.model.c.YG().bjz();
                    AppMethodBeat.o(16100);
                    return true;
                    if (!paramString1.startsWith("//setcardlayouttestdata")) {
                      break label11796;
                    }
                    paramContext = paramString1.replace("//setcardlayouttestdata ", "");
                    aw.aaz();
                    com.tencent.mm.model.c.Ru().set(ac.a.yyR, paramContext);
                    AppMethodBeat.o(16100);
                    return true;
                    if (!paramString1.startsWith("//delchatroomsysmsg")) {
                      break label11923;
                    }
                    paramString1 = paramString1.replace("//delchatroomsysmsg ", "");
                    i = paramString1.indexOf(" ");
                    paramContext = paramString1.substring(0, i);
                    paramString1 = paramString1.substring(i);
                    if (!bo.isNullOrNil(paramContext)) {
                      break label11855;
                    }
                    AppMethodBeat.o(16100);
                    return false;
                    if (!paramString1.startsWith("<")) {
                      break label11915;
                    }
                    paramString2 = new bi();
                    paramString2.fQ(System.currentTimeMillis());
                    paramString2.setType(10002);
                    paramString2.setContent(paramString1);
                    paramString2.hL(0);
                    paramString2.kj(paramContext);
                    com.tencent.mm.model.bf.l(paramString2);
                    AppMethodBeat.o(16100);
                    return true;
                    AppMethodBeat.o(16100);
                    return false;
                    if (!paramString1.startsWith("//resetcrseq")) {
                      break label12245;
                    }
                    paramString2 = paramString1.split(" ");
                    try
                    {
                      l1 = bo.getLong(paramString2[1], -1L);
                      l2 = bo.getLong(paramString2[2], -1L);
                      long l3 = bo.getLong(paramString2[3], -1L);
                      i = bo.getInt(paramString2[4], -1);
                      if (l1 > 0L)
                      {
                        paramString2 = l1 + "@chatroom";
                        aw.aaz();
                        paramString2 = com.tencent.mm.model.c.YF().arH(paramString2);
                        if (paramString2 != null)
                        {
                          ab.i("MicroMsg.CommandProcessor", "summerbadcr resetcrseq [%s] before [%d, %d, %d] [%d, %d, %d]", new Object[] { paramString2.getUsername(), Long.valueOf(paramString2.Hy()), Long.valueOf(paramString2.Hw()), Integer.valueOf(paramString2.Hx()), Long.valueOf(l2), Long.valueOf(l3), Integer.valueOf(i) });
                          if (l2 > -1L) {
                            paramString2.fN(l2);
                          }
                          if (l3 > -1L) {
                            paramString2.fM(l3);
                          }
                          if (i >= 0) {
                            paramString2.hQ(i);
                          }
                          aw.aaz();
                          i = com.tencent.mm.model.c.YF().a(paramString2, paramString2.getUsername(), false);
                          ab.i("MicroMsg.CommandProcessor", "summerbadcr resetcrseq [%s] done [%d, %d, %d] ret:%d", new Object[] { paramString2.getUsername(), Long.valueOf(paramString2.Hy()), Long.valueOf(paramString2.Hw()), Integer.valueOf(paramString2.Hx()), Integer.valueOf(i) });
                          AppMethodBeat.o(16100);
                          return true;
                        }
                      }
                    }
                    catch (Exception paramString2)
                    {
                      ab.printErrStackTrace("MicroMsg.CommandProcessor", paramString2, "summerbadcr resetcrseq", new Object[0]);
                    }
                    if (!paramString1.startsWith("//printchatroominfo")) {
                      break label12342;
                    }
                    paramContext = ChattingUIFragment.ywS;
                    if (com.tencent.mm.model.t.lA(paramContext)) {
                      break label12274;
                    }
                    AppMethodBeat.o(16100);
                    return false;
                    aw.aaz();
                    paramString2 = com.tencent.mm.model.c.YJ().oU(paramContext);
                    if (paramString2 != null) {
                      break label12316;
                    }
                    ab.e("MicroMsg.CommandProcessor", "summercrinfo chatroomId[%s], member is null", new Object[] { paramContext });
                    AppMethodBeat.o(16100);
                    return false;
                    com.tencent.mm.sdk.g.d.ysm.execute(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(16082);
                        i = this.eub.dwo();
                        j = this.eub.field_chatroomdataflag;
                        int k = this.eub.dwq();
                        Object localObject1 = this.eub;
                        if (((com.tencent.mm.storage.u)localObject1).b(((com.tencent.mm.storage.u)localObject1).ywY)) {
                          ((com.tencent.mm.storage.u)localObject1).dwn();
                        }
                        int m = ((com.tencent.mm.storage.u)localObject1).ywY.status;
                        int n = this.eub.dwr();
                        localObject1 = this.eub;
                        if (((com.tencent.mm.storage.u)localObject1).b(((com.tencent.mm.storage.u)localObject1).ywY)) {
                          ((com.tencent.mm.storage.u)localObject1).dwn();
                        }
                        Object localObject3 = ((com.tencent.mm.storage.u)localObject1).ywY.elv;
                        localObject1 = this.eub.afx();
                        aw.aaz();
                        Object localObject2 = com.tencent.mm.model.c.YC().fi(paramContext, " and msgSeq != 0 and flag & 2 != 0");
                        boolean bool;
                        if ((localObject2 != null) && (((dd)localObject2).field_msgId > 0L))
                        {
                          bool = true;
                          aw.aaz();
                          int i1 = com.tencent.mm.model.c.YC().TA(paramContext);
                          ab.i("MicroMsg.CommandProcessor", "summercrinfo chatroomId[%s], version[%d], flag[%d], type[%d], status[%d], get[%b], msgCount[%d], maxCount[%d], upgrader[%s], membersize[%d]", new Object[] { paramContext, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Boolean.valueOf(bool), Integer.valueOf(i1), Integer.valueOf(n), localObject3, Integer.valueOf(((List)localObject1).size()) });
                          localObject2 = new StringBuilder();
                          ((StringBuilder)localObject2).append("---chatroominfo---\nid:").append(paramContext).append("\nver:").append(i).append("\nflag:").append(j).append("\ntype:").append(k).append("\nstatus:").append(m).append("\nget:").append(bool).append("\nmsgCount:").append(i1).append("\nmaxCount:").append(n).append("\nupgrader:").append((String)localObject3).append("\nmembersize:").append(((List)localObject1).size()).append("\nisSilence:").append(((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPL().SW(paramContext)).append("\nsillenceBlock:").append(((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPL().SZ(paramContext).toString());
                          localObject3 = paramString1.split(" ");
                          i = -1;
                        }
                        try
                        {
                          j = bo.getInt(localObject3[1], 0);
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
                        localObject1 = new bi();
                        ((bi)localObject1).kj(paramContext);
                        ((bi)localObject1).hL(2);
                        ((bi)localObject1).setType(1);
                        ((bi)localObject1).fQ(System.currentTimeMillis());
                        ((bi)localObject1).setContent(((StringBuilder)localObject2).toString());
                        com.tencent.mm.model.bf.l((bi)localObject1);
                        AppMethodBeat.o(16082);
                      }
                    });
                    AppMethodBeat.o(16100);
                    return true;
                    if (!paramString1.startsWith("//clean chatroomblock")) {
                      break label12561;
                    }
                    paramString2 = ChattingUIFragment.ywS;
                    paramContext = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPL();
                    if (!paramString1.equals("//clean chatroomblock hard")) {
                      break label12419;
                    }
                    l1 = paramContext.SQ(paramString2);
                    Toast.makeText(com.tencent.mm.sdk.platformtools.ah.getContext(), "clean block hard! ret:".concat(String.valueOf(l1)), 1).show();
                    AppMethodBeat.o(16100);
                    return true;
                    if (!paramString1.equals("//clean chatroomblock all")) {
                      break label12466;
                    }
                    bool1 = paramContext.bPT();
                    Toast.makeText(com.tencent.mm.sdk.platformtools.ah.getContext(), "delete table! ret:".concat(String.valueOf(bool1)), 1).show();
                    AppMethodBeat.o(16100);
                    return true;
                    paramString1 = paramContext.SY(paramString2);
                    paramString1.field_lastLocalSeq = paramString1.field_lastPushSeq;
                    paramString1.field_lastLocalCreateTime = paramString1.field_lastPushCreateTime;
                    if (paramString1.field_seqBlockInfo == null) {
                      break label12507;
                    }
                    paramString1.field_seqBlockInfo.elE.clear();
                    l1 = paramContext.b(paramString1);
                    ab.i("MicroMsg.CommandProcessor", "[chatroomblock] ret:".concat(String.valueOf(l1)));
                    Toast.makeText(com.tencent.mm.sdk.platformtools.ah.getContext(), "clean chatroomblock! ret:".concat(String.valueOf(l1)), 1).show();
                    AppMethodBeat.o(16100);
                    return true;
                    if (!paramString1.equals("//testupdate")) {
                      break label12658;
                    }
                    paramString1 = "";
                    try
                    {
                      paramContext = bo.convertStreamToString(paramContext.getAssets().open("aplha_update_info.xml"));
                      aw.aaz();
                      com.tencent.mm.model.c.Ru().set(352273, paramContext);
                      aw.aaz();
                      com.tencent.mm.model.c.Ru().set(352274, Long.valueOf(System.currentTimeMillis()));
                      new com.tencent.mm.pluginsdk.model.app.a(paramContext).dlu();
                      AppMethodBeat.o(16100);
                      return true;
                    }
                    catch (IOException paramContext)
                    {
                      for (;;)
                      {
                        ab.printErrStackTrace("MicroMsg.CommandProcessor", paramContext, "", new Object[0]);
                        paramContext = paramString1;
                      }
                    }
                    if ((!paramString1.equals("//checkUpdate0")) && (!paramString1.equals("//checkUpdate1"))) {
                      break label12705;
                    }
                    com.tencent.mm.plugin.p.d.bSu().ju(paramString1.equals("//checkUpdate1"));
                    com.tencent.mm.plugin.p.d.oRx = true;
                    AppMethodBeat.o(16100);
                    return true;
                    if (!paramString1.equals("//debugsnstimelinestat")) {
                      break label12772;
                    }
                    if (com.tencent.mm.platformtools.ae.glk) {
                      break label12766;
                    }
                    for (bool1 = true;; bool1 = false)
                    {
                      com.tencent.mm.platformtools.ae.glk = bool1;
                      Toast.makeText(com.tencent.mm.sdk.platformtools.ah.getContext(), "debugSnsTimelineStat: " + com.tencent.mm.platformtools.ae.glk, 0).show();
                      AppMethodBeat.o(16100);
                      return true;
                    }
                    if ((!paramString1.startsWith("//abtestmsg")) || (!com.tencent.mm.sdk.a.b.dsf())) {
                      break label12831;
                    }
                    paramContext = com.tencent.mm.model.c.a.pX(paramString1.replace("//abtestmsg", ""));
                    com.tencent.mm.model.c.c.abU().r(paramContext.items, 0);
                    com.tencent.mm.model.c.c.abV().r(paramContext.foQ, 1);
                    AppMethodBeat.o(16100);
                    return true;
                    if (!paramString1.startsWith("//triggergetabtest")) {
                      break label12866;
                    }
                    aw.aaz();
                    com.tencent.mm.model.c.Ru().set(ac.a.yzI, Long.valueOf(1L));
                    AppMethodBeat.o(16100);
                    return true;
                    if (!paramString1.startsWith("//vad")) {
                      break label13119;
                    }
                    paramString2 = com.tencent.mm.sdk.platformtools.ah.dsQ();
                    if (paramString2 != null) {
                      break label12892;
                    }
                    AppMethodBeat.o(16100);
                    return false;
                    if (!paramString1.startsWith("//vad get")) {
                      break label12923;
                    }
                    com.tencent.mm.ui.base.h.J(paramContext, com.tencent.mm.modelvoiceaddr.a.c.amS(), "VAD PARAMS").show();
                    AppMethodBeat.o(16100);
                    return true;
                    paramContext = paramString2.edit();
                    if (!paramString1.startsWith("//vad sd")) {
                      break label12965;
                    }
                    paramContext.putInt("s_delay_time", Integer.valueOf(paramString1.substring(9).trim()).intValue());
                    if (!paramString1.startsWith("//vad st")) {
                      break label13000;
                    }
                    paramContext.putInt("sil_time", Integer.valueOf(paramString1.substring(9).trim()).intValue());
                    if (!paramString1.startsWith("//vad snr")) {
                      break label13035;
                    }
                    paramContext.putFloat("s_n_ration", Float.valueOf(paramString1.substring(10).trim()).floatValue());
                    if (!paramString1.startsWith("//vad sw")) {
                      break label13070;
                    }
                    paramContext.putInt("s_window", Integer.valueOf(paramString1.substring(9).trim()).intValue());
                    if (!paramString1.startsWith("//vad sl")) {
                      break label13105;
                    }
                    paramContext.putInt("s_length", Integer.valueOf(paramString1.substring(9).trim()).intValue());
                    paramContext.apply();
                    AppMethodBeat.o(16100);
                    return true;
                    if (!paramString1.startsWith("//dumpabtestrecords")) {
                      break label13278;
                    }
                    if (2 >= ab.getLogLevel()) {
                      break label13144;
                    }
                    AppMethodBeat.o(16100);
                    return false;
                    if (!paramString1.contains("info")) {
                      break label13268;
                    }
                    for (paramString1 = com.tencent.mm.model.c.c.abV().dvM();; paramString1 = com.tencent.mm.model.c.c.abU().dvM())
                    {
                      paramString2 = new TextView(paramContext);
                      paramString2.setText(paramString1);
                      paramString2.setGravity(8388627);
                      paramString2.setTextSize(1, 10.0F);
                      paramString2.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                      paramString2.setTextColor(-16744704);
                      paramString2.setTypeface(Typeface.MONOSPACE);
                      paramString2.setMovementMethod(new ScrollingMovementMethod());
                      i = paramContext.getResources().getDimensionPixelSize(2131427772);
                      paramString2.setPadding(i, i, i, i);
                      com.tencent.mm.ui.base.h.a(paramContext, null, paramString2, null);
                      AppMethodBeat.o(16100);
                      return true;
                    }
                    if (!paramString1.startsWith("//triggerWebViewCookiesCleanup")) {
                      break label13313;
                    }
                    aw.aaz();
                    com.tencent.mm.model.c.Ru().set(ac.a.yAV, Long.valueOf(0L));
                    AppMethodBeat.o(16100);
                    return true;
                    if (!paramString1.startsWith("//cleanwebcache")) {
                      break label13347;
                    }
                    paramContext = new bp();
                    com.tencent.mm.sdk.b.a.ymk.l(paramContext);
                    AppMethodBeat.o(16100);
                    return true;
                    if (!paramString1.startsWith("//triggerWebViewCacheCleanup")) {
                      break label13371;
                    }
                    com.tencent.mm.cn.d.awm("com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
                    AppMethodBeat.o(16100);
                    return true;
                    if (!paramString1.startsWith("//dumpsnsabtest")) {
                      break label13405;
                    }
                    paramContext = new co();
                    com.tencent.mm.sdk.b.a.ymk.l(paramContext);
                    AppMethodBeat.o(16100);
                    return true;
                    if (!paramString1.startsWith("//dumpsilkvoicefile")) {
                      break label13427;
                    }
                    com.tencent.mm.platformtools.ae.glo = true;
                    AppMethodBeat.o(16100);
                    return true;
                    if (!paramString1.startsWith("//fucktit")) {
                      break label13461;
                    }
                    aw.aaz();
                    com.tencent.mm.model.c.Ru().set(ac.a.yAH, Boolean.TRUE);
                    AppMethodBeat.o(16100);
                    return true;
                    if (!paramString1.startsWith("//clog ")) {
                      break label13512;
                    }
                    paramContext = paramString1.substring(7);
                    com.tencent.mm.plugin.report.service.h.qsU.ga(paramContext, "test cLog " + System.currentTimeMillis());
                    AppMethodBeat.o(16100);
                    return true;
                    if ((!paramString1.startsWith("//testformsg")) || (!com.tencent.mm.sdk.a.b.dsf())) {
                      break label13643;
                    }
                    paramContext = paramString1.substring(12).trim();
                    ab.i("MicroMsg.CommandProcessor", "MMCore.getSysCmdMsgExtension() " + aw.getSysCmdMsgExtension());
                    paramString1 = new cm();
                    paramString1.woR = com.tencent.mm.platformtools.aa.wA(paramContext);
                    paramString1.woP = com.tencent.mm.platformtools.aa.wA("weixin");
                    paramString1.woQ = com.tencent.mm.platformtools.aa.wA(r.Zn());
                    paramString1.woT = com.tencent.mm.platformtools.aa.wB("test");
                    paramString1.nqW = 10002;
                    paramContext = new e.a(paramString1, false, false, false);
                    aw.getSysCmdMsgExtension().b(paramContext);
                    AppMethodBeat.o(16100);
                    return true;
                    if (!paramString1.startsWith("//canwebviewcachedownload")) {
                      break label13707;
                    }
                    if (bo.getInt(bo.nullAsNil(paramString1.substring(25)).trim(), 1) <= 0) {
                      break label13701;
                    }
                    for (bool1 = true;; bool1 = false)
                    {
                      aw.aaz();
                      com.tencent.mm.model.c.Ru().set(ac.a.yBs, Boolean.valueOf(bool1));
                      AppMethodBeat.o(16100);
                      return true;
                    }
                    if (!paramString1.startsWith("//canwebviewcacheprepushdownload")) {
                      break label13771;
                    }
                    if (bo.getInt(bo.nullAsNil(paramString1.substring(32)).trim(), 1) <= 0) {
                      break label13765;
                    }
                    for (bool1 = true;; bool1 = false)
                    {
                      aw.aaz();
                      com.tencent.mm.model.c.Ru().set(ac.a.yBt, Boolean.valueOf(bool1));
                      AppMethodBeat.o(16100);
                      return true;
                    }
                    if (!paramString1.startsWith("//resetsnslukcy")) {
                      break label13855;
                    }
                    aw.aaz();
                    com.tencent.mm.model.c.Ru().set(ac.a.yBJ, Boolean.FALSE);
                    aw.aaz();
                    com.tencent.mm.model.c.Ru().set(ac.a.yBK, Integer.valueOf(0));
                    aw.aaz();
                    com.tencent.mm.model.c.Ru().set(ac.a.yBL, Integer.valueOf(0));
                    paramContext = new sd();
                    com.tencent.mm.sdk.b.a.ymk.l(paramContext);
                    AppMethodBeat.o(16100);
                    return true;
                    if (!paramString1.startsWith("//enablempsp")) {
                      break label13888;
                    }
                    ar.a.pJ(false);
                    Toast.makeText(paramContext, "设置成功，请重启微信！", 0).show();
                    AppMethodBeat.o(16100);
                    return true;
                    if (!paramString1.startsWith("//disablempsp")) {
                      break label13921;
                    }
                    ar.a.pJ(true);
                    Toast.makeText(paramContext, "设置成功，请重启微信！", 0).show();
                    AppMethodBeat.o(16100);
                    return true;
                    if (!paramString1.startsWith("//soterpay")) {
                      break label13949;
                    }
                    com.tencent.mm.bq.d.H(paramContext, "fingerprint", ".ui.SoterPayTestUI");
                    AppMethodBeat.o(16100);
                    return true;
                    if (!paramString1.startsWith(paramContext.getString(2131304674))) {
                      break label14020;
                    }
                    if (com.tencent.mm.platformtools.ae.glv) {
                      break label14014;
                    }
                    for (bool1 = true;; bool1 = false)
                    {
                      com.tencent.mm.platformtools.ae.glv = bool1;
                      Toast.makeText(com.tencent.mm.sdk.platformtools.ah.getContext(), String.format("showVoipDebugLog:%b", new Object[] { Boolean.valueOf(com.tencent.mm.platformtools.ae.glv) }), 0).show();
                      AppMethodBeat.o(16100);
                      return true;
                    }
                    if (!paramString1.startsWith("//getdltaskinfo")) {
                      break label14186;
                    }
                    paramContext = paramString1.replace("//getdltaskinfo ", "");
                    for (;;)
                    {
                      try
                      {
                        paramString1 = com.tencent.mm.plugin.downloader.model.d.iJ(bo.getLong(paramContext, 0L));
                        if (paramString1 == null) {
                          continue;
                        }
                        ab.i("getdltaskinfo", "%d, %s, %s, %s", new Object[] { Long.valueOf(paramString1.field_downloadId), paramString1.field_downloadUrl, paramString1.field_filePath, paramString1.field_md5 });
                      }
                      catch (Exception paramString1)
                      {
                        paramContext = com.tencent.mm.plugin.downloader.model.d.JG(paramContext);
                        if (paramContext == null) {
                          continue;
                        }
                        ab.i("getdltaskinfo", "%d, %s, %s, %s", new Object[] { Long.valueOf(paramContext.field_downloadId), paramContext.field_downloadUrl, paramContext.field_filePath, paramContext.field_md5 });
                        continue;
                        ab.i("getdltaskinfo", "infoURL null");
                        continue;
                      }
                      AppMethodBeat.o(16100);
                      return true;
                      ab.i("getdltaskinfo", "infoID null");
                    }
                    if (!paramString1.startsWith("//testscan ")) {
                      break label14273;
                    }
                    paramContext = paramString1.split(" ");
                    com.tencent.mm.platformtools.ae.glu = bo.getFloat(paramContext[1], 0.0F);
                    com.tencent.mm.platformtools.ae.glt = bo.getFloat(paramContext[2], 0.0F);
                    Toast.makeText(com.tencent.mm.sdk.platformtools.ah.getContext(), "mode auto:" + com.tencent.mm.platformtools.ae.glu + ",mode continuous:" + com.tencent.mm.platformtools.ae.glt, 1).show();
                    AppMethodBeat.o(16100);
                    return true;
                    if (!paramString1.startsWith("//switchrecordmode")) {
                      break label14377;
                    }
                    paramContext = com.tencent.mm.sdk.platformtools.ah.dsQ();
                    bool2 = paramContext.getBoolean("settings_voicerecorder_mode", false);
                    if (bool2) {
                      break label14355;
                    }
                    bool1 = true;
                    paramContext.edit().putBoolean("settings_voicerecorder_mode", bool1).commit();
                    if (!bool2) {
                      break label14361;
                    }
                    Toast.makeText(com.tencent.mm.sdk.platformtools.ah.getContext(), "Turn off silk record", 1).show();
                    for (;;)
                    {
                      AppMethodBeat.o(16100);
                      return true;
                      bool1 = false;
                      break;
                      Toast.makeText(com.tencent.mm.sdk.platformtools.ah.getContext(), "Turn on silk record", 1).show();
                    }
                    if (!paramString1.startsWith("//indoorsensorconfig ")) {
                      break label14411;
                    }
                    com.tencent.mm.modelstat.e.akz().uG(paramString1.replace("//indoorsensorconfig ", ""));
                    AppMethodBeat.o(16100);
                    return true;
                    if (!paramString1.startsWith("//testindoorsensor ")) {
                      break label14480;
                    }
                    paramContext = paramString1.replace("//testindoorsensor ", "").split(",");
                    com.tencent.mm.modelstat.e.akz().a(12345, false, paramContext[0].equals("1"), bo.getFloat(paramContext[1], 0.0F), bo.getFloat(paramContext[2], 0.0F), 12);
                    AppMethodBeat.o(16100);
                    return true;
                    if (!paramString1.startsWith("//facedebug")) {
                      break label14498;
                    }
                    AppMethodBeat.o(16100);
                    return true;
                    if (!paramString1.startsWith("//rstfacett")) {
                      break label14516;
                    }
                    AppMethodBeat.o(16100);
                    return true;
                    if (!paramString1.startsWith("//switchjsc")) {
                      break label14650;
                    }
                    paramContext = paramString1.replace("//switchjsc ", "");
                    paramString1 = com.tencent.mm.sdk.platformtools.ah.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
                    if (!"clear".equals(paramContext)) {
                      break label14584;
                    }
                    paramString1.edit().remove("switch_x5_jscore").apply();
                    for (;;)
                    {
                      AppMethodBeat.o(16100);
                      return true;
                      if ("true".equals(paramContext)) {
                        paramString1.edit().putBoolean("switch_x5_jscore", true).apply();
                      } else if ("false".equals(paramContext)) {
                        paramString1.edit().putBoolean("switch_x5_jscore", false).apply();
                      }
                    }
                    if (!paramString1.startsWith("//rfcdn")) {
                      break label14700;
                    }
                    try
                    {
                      com.tencent.mm.al.f.afP().keep_OnRequestDoGetCdnDnsInfo(888);
                      AppMethodBeat.o(16100);
                      return true;
                    }
                    catch (Exception paramContext)
                    {
                      for (;;)
                      {
                        ab.e("MicroMsg.CommandProcessor", "rfcdn :%s", new Object[] { bo.l(paramContext) });
                      }
                    }
                    if (!paramString1.startsWith("//testcrscroll ")) {
                      break label14767;
                    }
                    paramString2 = paramString1.split(" ");
                    if ((paramString2 == null) || (paramString2.length <= 1)) {
                      break label14767;
                    }
                    com.tencent.mm.ui.chatting.c.ak.zIb = bo.getInt(paramString2[1], 0);
                    ab.i("MicroMsg.CommandProcessor", "summerbadcr testscroll new BADCR_SCROLL_DELAY[%d]", new Object[] { Integer.valueOf(com.tencent.mm.ui.chatting.c.ak.zIb) });
                    AppMethodBeat.o(16100);
                    return true;
                    if (!paramString1.startsWith("//switchx5jscore")) {
                      break label14838;
                    }
                    paramContext = com.tencent.mm.sdk.platformtools.ah.dsQ();
                    bool1 = paramContext.getBoolean("switch_x5_jscore", true);
                    paramContext = paramContext.edit();
                    if (bool1) {
                      break label14832;
                    }
                    for (bool1 = true;; bool1 = false)
                    {
                      paramContext.putBoolean("switch_x5_jscore", bool1).apply();
                      AppMethodBeat.o(16100);
                      return true;
                    }
                    if (!paramString1.startsWith("//removeaudioplayer")) {
                      break label14910;
                    }
                    paramContext = paramString1.split(" ");
                    if (paramContext.length < 2) {
                      break label14902;
                    }
                    i = bo.getInt(paramContext[1], 3);
                    if ((i < 2) || (i > 9)) {
                      break label14902;
                    }
                    aw.aaz();
                    com.tencent.mm.model.c.Ru().set(ac.a.yFK, Integer.valueOf(i));
                    AppMethodBeat.o(16100);
                    return true;
                    if (!paramString1.startsWith("//showaudiotoast")) {
                      break label14988;
                    }
                    paramContext = paramString1.split(" ");
                    if (paramContext.length < 2) {
                      break label14974;
                    }
                    i = bo.getInt(paramContext[1], 0);
                    aw.aaz();
                    paramContext = com.tencent.mm.model.c.Ru();
                    paramString1 = ac.a.yFL;
                    if (i != 1) {
                      break label14982;
                    }
                    for (bool1 = true;; bool1 = false)
                    {
                      paramContext.set(paramString1, Boolean.valueOf(bool1));
                      AppMethodBeat.o(16100);
                      return true;
                    }
                    if (!paramString1.startsWith("//openmixaudio")) {
                      break label15066;
                    }
                    paramContext = paramString1.split(" ");
                    if (paramContext.length < 2) {
                      break label15052;
                    }
                    i = bo.getInt(paramContext[1], 0);
                    aw.aaz();
                    paramContext = com.tencent.mm.model.c.Ru();
                    paramString1 = ac.a.yFM;
                    if (i != 1) {
                      break label15060;
                    }
                    for (bool1 = true;; bool1 = false)
                    {
                      paramContext.set(paramString1, Boolean.valueOf(bool1));
                      AppMethodBeat.o(16100);
                      return true;
                    }
                    if (!paramString1.startsWith("//switchmusicplayer")) {
                      break label15444;
                    }
                    ab.i("MicroMsg.CommandProcessor", "msg:%s", new Object[] { paramString1 });
                    paramContext = paramString1.split(" ");
                    if (paramContext.length <= 2) {
                      break label15195;
                    }
                    if (bo.getInt(paramContext[1], 0) != 0) {
                      break label15203;
                    }
                    i = 0;
                    int m = bo.getInt(paramContext[2], -1);
                    aw.aaz();
                    int k = ((Integer)com.tencent.mm.model.c.Ru().get(ac.a.yFI, Integer.valueOf(0))).intValue();
                    j = 1;
                    if (m != -1) {
                      break label15215;
                    }
                    if (i == 0) {
                      break label15209;
                    }
                    i = 255;
                    for (;;)
                    {
                      if (j != 0)
                      {
                        aw.aaz();
                        com.tencent.mm.model.c.Ru().set(ac.a.yFI, Integer.valueOf(i));
                      }
                      AppMethodBeat.o(16100);
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
                      break label15567;
                    }
                    ab.i("MicroMsg.CommandProcessor", "summercert testdefaultrsa");
                    paramString1 = paramString1.split(" ");
                    if ((paramString1 == null) || (paramString1.length <= 1)) {
                      break label15521;
                    }
                    for (bool1 = true;; bool1 = false)
                    {
                      com.tencent.mm.protocal.aa.T("", "", 0);
                      paramString1 = com.tencent.mm.kernel.g.RK().Rc().Rg();
                      if (paramString1 != null) {
                        break;
                      }
                      ab.w("MicroMsg.CommandProcessor", "summercert testdefaultrsa push not alive");
                      AppMethodBeat.o(16100);
                      return false;
                    }
                    new com.tencent.mm.modelsimple.s("", "", "", 0).ajE().doScene(paramString1, new com.tencent.mm.ai.f()
                    {
                      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ai.m paramAnonymousm)
                      {
                        AppMethodBeat.i(16086);
                        ab.i("MicroMsg.CommandProcessor", "summercert testdefaultrsa NetSceneManualAuth onSceneEnd [%d, %d, %s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
                        if ((paramAnonymousInt1 == 4) && (paramAnonymousInt2 != -102) && (!this.eud))
                        {
                          com.tencent.mm.sdk.platformtools.al.d(new Runnable()
                          {
                            public final void run()
                            {
                              AppMethodBeat.i(16083);
                              b.D(b.6.this.val$context, "RSA(req) fatal err, must recheck!!!");
                              AppMethodBeat.o(16083);
                            }
                          });
                          AppMethodBeat.o(16086);
                          return;
                        }
                        new com.tencent.mm.modelsimple.k().doScene(com.tencent.mm.kernel.g.RK().eHt.ftA, new b.6.2(this));
                        AppMethodBeat.o(16086);
                      }
                    });
                    AppMethodBeat.o(16100);
                    return true;
                    if (!paramString1.startsWith("//dumpdefaultrsa")) {
                      break label15594;
                    }
                    bool1 = C(paramContext, "");
                    AppMethodBeat.o(16100);
                    return bool1;
                    if (!paramString1.startsWith("//hardwareinfo")) {
                      break label15627;
                    }
                    ((com.tencent.mm.plugin.hardwareopt.a.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.hardwareopt.a.a.a.class)).ip(true);
                    AppMethodBeat.o(16100);
                    return true;
                    if (!paramString1.startsWith("//showStringName")) {
                      break label15699;
                    }
                    paramContext = com.tencent.mm.sdk.platformtools.ah.dsQ();
                    bool1 = paramContext.getBoolean("ShowStringName", false);
                    paramContext = paramContext.edit();
                    if (bool1) {
                      break label15693;
                    }
                    for (bool1 = true;; bool1 = false)
                    {
                      paramContext.putBoolean("ShowStringName", bool1).commit();
                      AppMethodBeat.o(16100);
                      return true;
                    }
                    if (!paramString1.startsWith("//mmphotoedit")) {
                      break label15734;
                    }
                    com.tencent.mm.bq.d.b(paramContext, "mmsight", ".ui.TestVideoEditUI", new Intent());
                    AppMethodBeat.o(16100);
                    return true;
                    if (!paramString1.startsWith("//msgDelay")) {
                      break label15756;
                    }
                    com.tencent.mm.ui.conversation.a.n.iv(paramContext);
                    AppMethodBeat.o(16100);
                    return true;
                    if (!paramString1.startsWith("//cpDelayedMsg")) {
                      break label15778;
                    }
                    com.tencent.mm.ui.conversation.a.n.iw(paramContext);
                    AppMethodBeat.o(16100);
                    return true;
                    if (!paramString1.startsWith("//testhce")) {
                      break label15806;
                    }
                    com.tencent.mm.bq.d.H(paramContext, "nfc", ".ui.HceTestUI");
                    AppMethodBeat.o(16100);
                    return true;
                    if (!paramString1.startsWith("//debugbigimg")) {
                      break label15897;
                    }
                    paramContext = paramString1.split(" ");
                    if (paramContext.length != 2) {
                      break label15864;
                    }
                    if (!paramContext[1].equals("1")) {
                      break label15872;
                    }
                    com.tencent.mm.sdk.platformtools.ah.dsQ().edit().putBoolean("debug_big_img", true).apply();
                    for (;;)
                    {
                      AppMethodBeat.o(16100);
                      return true;
                      com.tencent.mm.sdk.platformtools.ah.dsQ().edit().putBoolean("debug_big_img", false).apply();
                    }
                    if (!paramString1.startsWith("//testservice ")) {
                      break label15979;
                    }
                    paramString1 = paramString1.replace("//testservice ", "");
                    paramContext = paramContext.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit();
                    if ((paramString1 == null) || (!paramString1.equals("1"))) {
                      break label15973;
                    }
                    for (bool1 = true;; bool1 = false)
                    {
                      paramContext.putBoolean("forceTrigger", bool1).commit();
                      AppMethodBeat.o(16100);
                      return true;
                    }
                    if (!paramString1.startsWith("//openDetect")) {
                      break label16028;
                    }
                    com.tencent.mm.sdk.platformtools.ah.getContext().getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.h.Mp()).edit().putBoolean("msg_delay_close_detect", false).apply();
                    AppMethodBeat.o(16100);
                    return true;
                    if (!paramString1.startsWith("//closeDetect")) {
                      break label16077;
                    }
                    com.tencent.mm.sdk.platformtools.ah.getContext().getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.h.Mp()).edit().putBoolean("msg_delay_close_detect", true).apply();
                    AppMethodBeat.o(16100);
                    return true;
                    if (!paramString1.startsWith("//snsimage")) {
                      break label16174;
                    }
                    for (;;)
                    {
                      try
                      {
                        i = bo.getInt(paramString1.replace("//snsimage ", ""), 0);
                        com.tencent.mm.al.f.afO().ld(i);
                        if (i <= 0) {
                          continue;
                        }
                        paramContext = "tcp sns image download";
                        Toast.makeText(com.tencent.mm.sdk.platformtools.ah.getContext(), paramContext, 0).show();
                      }
                      catch (Exception paramContext)
                      {
                        ab.printErrStackTrace("MicroMsg.CommandProcessor", paramContext, "", new Object[0]);
                        Toast.makeText(com.tencent.mm.sdk.platformtools.ah.getContext(), "set snsimage fail, please ensure your command.", 1).show();
                        continue;
                      }
                      AppMethodBeat.o(16100);
                      return true;
                      paramContext = "http sns image download";
                    }
                    if (!paramString1.startsWith("//groupdownload")) {
                      break label16269;
                    }
                    for (;;)
                    {
                      try
                      {
                        i = bo.getInt(paramString1.replace("//groupdownload ", ""), 0);
                        com.tencent.mm.plugin.sns.ui.aq.rTt = i;
                        if (1 != i) {
                          continue;
                        }
                        paramContext = "enable";
                        Toast.makeText(com.tencent.mm.sdk.platformtools.ah.getContext(), paramContext, 0).show();
                      }
                      catch (Exception paramContext)
                      {
                        ab.printErrStackTrace("MicroMsg.CommandProcessor", paramContext, "", new Object[0]);
                        Toast.makeText(com.tencent.mm.sdk.platformtools.ah.getContext(), "set groupdownload fail, please ensure your command.", 1).show();
                        continue;
                      }
                      AppMethodBeat.o(16100);
                      return true;
                      paramContext = "disable";
                    }
                    if (!paramString1.startsWith("//resetWeishi")) {
                      break label16303;
                    }
                    com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yKA, Integer.valueOf(0));
                    AppMethodBeat.o(16100);
                    return true;
                    if (!paramString1.startsWith("//clearWxWebCacheAndCookie")) {
                      break label16353;
                    }
                    paramContext = new Intent();
                    paramContext.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
                    paramContext.putExtra("tools_clean_webview_cache_ignore_cookie", true);
                    com.tencent.mm.cn.d.aX(paramContext);
                    AppMethodBeat.o(16100);
                    return true;
                    if (!paramString1.startsWith("//destroyPreloadGameWebCore")) {
                      break label16374;
                    }
                    com.tencent.mm.plugin.game.luggage.d.destroy();
                    AppMethodBeat.o(16100);
                    return true;
                    if (!paramString1.startsWith("//ecdhml ")) {
                      break label16704;
                    }
                    for (;;)
                    {
                      try
                      {
                        i = bo.getInt(paramString1.replace("//ecdhml ", ""), 0);
                        if ((i > 0) && (i < 5))
                        {
                          paramString2 = com.tencent.mm.sdk.platformtools.ah.getContext().getSharedPreferences("auth_info_key_prefs", com.tencent.mm.compatible.util.h.Mp());
                          if (i < 3)
                          {
                            localObject1 = paramString2.edit();
                            if (i == 1)
                            {
                              bool1 = true;
                              ((SharedPreferences.Editor)localObject1).putBoolean("auth_info_prefs_use_new_ecdh", bool1).commit();
                              bool1 = paramString2.getBoolean("auth_info_prefs_use_new_ecdh", true);
                              localObject1 = new StringBuilder("reset ecdh mode ");
                              if (com.tencent.mm.protocal.f.whQ)
                              {
                                paramString2 = "enable";
                                localObject1 = ((StringBuilder)localObject1).append(paramString2).append(" to ");
                                if (!bool1) {
                                  break label18003;
                                }
                                paramString2 = "enable";
                                com.tencent.mm.ui.base.t.makeText(paramContext, paramString2, 0).show();
                                ab.i("MicroMsg.CommandProcessor", "summerauths reset ecdh ".concat(String.valueOf(bool1)));
                                AppMethodBeat.o(16100);
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
                            break label16762;
                          }
                          bool1 = true;
                          ((SharedPreferences.Editor)localObject1).putBoolean("auth_info_prefs_use_net_ml_cert", bool1).commit();
                          bool1 = paramString2.getBoolean("auth_info_prefs_use_new_ecdh", false);
                          localObject1 = new StringBuilder("reset ecdh ml mode ");
                          if (!com.tencent.mm.protocal.f.whR) {
                            break label16768;
                          }
                          paramString2 = "enable";
                          localObject1 = ((StringBuilder)localObject1).append(paramString2).append(" to ");
                          if (!bool1) {
                            break label16775;
                          }
                          paramString2 = "enable";
                          com.tencent.mm.ui.base.t.makeText(paramContext, paramString2, 0).show();
                          ab.i("MicroMsg.CommandProcessor", "summerauths reset ecdh ml".concat(String.valueOf(bool1)));
                          continue;
                        }
                        if (!paramString1.startsWith("//storyPostThreshold ")) {
                          break label16798;
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
                          ab.a("MicroMsg.CommandProcessor", "NumberFormatException", new Object[0]);
                        }
                      }
                      com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yLr, Integer.valueOf(i));
                      AppMethodBeat.o(16100);
                      return true;
                      bool1 = false;
                      continue;
                      paramString2 = "disable";
                      continue;
                      paramString2 = "disable";
                    }
                    if (!paramString1.startsWith("//hbemojisw")) {
                      break label16861;
                    }
                    aw.aaz();
                    i = ((Integer)com.tencent.mm.model.c.Ru().get(ac.a.yLJ, Integer.valueOf(0))).intValue();
                    aw.aaz();
                    com.tencent.mm.model.c.Ru().set(ac.a.yLJ, Integer.valueOf(i ^ 0x1));
                    AppMethodBeat.o(16100);
                    return true;
                    if (!paramString1.startsWith("//addbywework")) {
                      break label16924;
                    }
                    aw.aaz();
                    i = ((Integer)com.tencent.mm.model.c.Ru().get(ac.a.yyn, Integer.valueOf(0))).intValue();
                    aw.aaz();
                    com.tencent.mm.model.c.Ru().set(ac.a.yyn, Integer.valueOf(i ^ 0x1));
                    AppMethodBeat.o(16100);
                    return true;
                    if (!paramString1.startsWith("//enableDyBg ")) {
                      break label17015;
                    }
                    paramContext = paramString1.split(" ");
                    if (paramContext.length != 2) {
                      break label16982;
                    }
                    if (!paramContext[1].equals("1")) {
                      break label16990;
                    }
                    com.tencent.mm.sdk.platformtools.ah.dsQ().edit().putBoolean("enable_dynamic_background_for_test", true).apply();
                    for (;;)
                    {
                      AppMethodBeat.o(16100);
                      return true;
                      com.tencent.mm.sdk.platformtools.ah.dsQ().edit().putBoolean("enable_dynamic_background_for_test", false).apply();
                    }
                    if (!paramString1.startsWith("//setbgfps ")) {
                      break label17093;
                    }
                    paramContext = paramString1.split(" ");
                    if (paramContext.length != 2) {
                      break label17085;
                    }
                    i = Integer.valueOf(paramContext[1]).intValue();
                    if ((i <= 0) || (i > 50)) {
                      break label17085;
                    }
                    com.tencent.mm.sdk.platformtools.ah.dsQ().edit().putInt("dynamic_bg_fps", i).apply();
                    AppMethodBeat.o(16100);
                    return true;
                    if (!paramString1.startsWith("//transVoice")) {
                      break label17167;
                    }
                    paramContext = paramString1.split(" ");
                    if (2 != paramContext.length) {
                      break label17133;
                    }
                    if (!"1".equals(paramContext[1])) {
                      break label17141;
                    }
                    com.tencent.mm.plugin.transvoice.ui.b.tqA = 1;
                    for (;;)
                    {
                      AppMethodBeat.o(16100);
                      return true;
                      if ("0".equals(paramContext[1])) {
                        com.tencent.mm.plugin.transvoice.ui.b.tqA = 0;
                      } else {
                        com.tencent.mm.plugin.transvoice.ui.b.tqA = -1;
                      }
                    }
                    if (!paramString1.startsWith("//voice2TxtBlur")) {
                      break label17253;
                    }
                    paramContext = paramString1.split(" ");
                    if (2 != paramContext.length) {
                      break label17211;
                    }
                    if (!"1".equals(paramContext[1])) {
                      break label17219;
                    }
                    paramContext = com.tencent.mm.plugin.transvoice.a.tpe;
                    com.tencent.mm.plugin.transvoice.a.a.GU(1);
                    for (;;)
                    {
                      AppMethodBeat.o(16100);
                      return true;
                      if ("0".equals(paramContext[1]))
                      {
                        paramContext = com.tencent.mm.plugin.transvoice.a.tpe;
                        com.tencent.mm.plugin.transvoice.a.a.GU(0);
                      }
                      else
                      {
                        paramContext = com.tencent.mm.plugin.transvoice.a.tpe;
                        com.tencent.mm.plugin.transvoice.a.a.GU(-1);
                      }
                    }
                    i = lD(paramString1);
                    ab.d("MicroMsg.CommandProcessor", "processed : in ret:[%d]", new Object[] { Integer.valueOf(i) });
                    switch (i)
                    {
                    default: 
                      AppMethodBeat.o(16100);
                      return false;
                    case 0: 
                      AppMethodBeat.o(16100);
                      return false;
                    case 568: 
                      Assert.assertTrue("test errlog", false);
                      AppMethodBeat.o(16100);
                      return true;
                    case 569: 
                      aw.aaz().YX();
                      AppMethodBeat.o(16100);
                      return true;
                    case 570: 
                      if (bs.asD(lE(paramString1))) {
                        Toast.makeText(paramContext, 2131304638, 0).show();
                      }
                      AppMethodBeat.o(16100);
                      return true;
                    case 571: 
                      paramContext = lE(paramString1);
                      aw.aaz();
                      com.tencent.mm.model.c.Ru().set(8195, paramContext);
                      AppMethodBeat.o(16100);
                      return true;
                    case 572: 
                      com.tencent.mm.sdk.platformtools.g.bWw = Integer.valueOf(lE(paramString1)).intValue();
                      AppMethodBeat.o(16100);
                      return true;
                    case 574: 
                      paramString1 = new StringBuilder().append(com.tencent.mm.compatible.e.q.bP(true));
                      aw.aaz();
                      com.tencent.mm.ui.base.h.J(paramContext, com.tencent.mm.a.g.w(com.tencent.mm.model.c.getUin().getBytes()), "md5");
                      AppMethodBeat.o(16100);
                      return true;
                    case 579: 
                      paramContext = lE(paramString1);
                      ao.a.aaj().am(paramContext, "");
                      AppMethodBeat.o(16100);
                      return true;
                    case 580: 
                      aw.Rc().b(new bk(new b.7()));
                      AppMethodBeat.o(16100);
                      return true;
                    case 581: 
                      paramContext = lE(paramString1);
                      com.tencent.mm.pluginsdk.model.app.al.cab().alr(paramContext);
                      AppMethodBeat.o(16100);
                      return true;
                    case 582: 
                      paramContext = lE(paramString1);
                      aw.aaz();
                      paramContext = com.tencent.mm.model.c.YA().arw(paramContext);
                      if ((paramContext == null) || (paramContext.Od() == 0))
                      {
                        AppMethodBeat.o(16100);
                        return false;
                      }
                      paramContext.Nx();
                      com.tencent.mm.model.t.u(paramContext);
                      AppMethodBeat.o(16100);
                      return true;
                    case 583: 
                      aw.aaz();
                      AppMethodBeat.o(16100);
                      return true;
                    case 584: 
                    case 585: 
                      bh.pC(lE(paramString1));
                      AppMethodBeat.o(16100);
                      return true;
                    case 586: 
                      paramContext = paramString1.split(" ");
                      if ((paramContext != null) && (paramContext.length == 3)) {
                        com.tencent.mm.modelmulti.q.cy(bo.getInt(paramContext[1], 0), bo.getInt(paramContext[2], 0));
                      }
                      AppMethodBeat.o(16100);
                      return true;
                    case 587: 
                      paramContext = new cp();
                      com.tencent.mm.sdk.b.a.ymk.l(paramContext);
                      AppMethodBeat.o(16100);
                      return true;
                    case 588: 
                      com.tencent.mm.vfs.e.um("/sdcard/tencent/MicroMsg/back");
                      aw.aaz();
                      com.tencent.mm.vfs.e.iF(com.tencent.mm.model.c.Rp(), "/sdcard/tencent/MicroMsg/back");
                      AppMethodBeat.o(16100);
                      return true;
                    case 590: 
                      AppMethodBeat.o(16100);
                      return true;
                    }
                    try
                    {
                      paramContext = paramString1.split(" ");
                      if ((paramContext != null) && (paramContext.length > 1))
                      {
                        paramContext = br.F(paramContext[0], "sysmsg");
                        aw.aaz().Za().o(paramContext);
                      }
                    }
                    catch (Exception paramContext)
                    {
                      for (;;)
                      {
                        ab.printErrStackTrace("MicroMsg.CommandProcessor", paramContext, "hy: error occured in commandProcessor", new Object[0]);
                      }
                    }
                    AppMethodBeat.o(16100);
                    return true;
                  }
                  catch (Exception paramContext)
                  {
                    break label11363;
                  }
                }
                catch (Exception paramContext)
                {
                  break label11056;
                }
              }
              catch (Exception paramContext)
              {
                break label11006;
              }
            }
            catch (Exception paramContext)
            {
              break label7567;
            }
          }
          catch (Exception paramContext)
          {
            break label7527;
          }
        }
        catch (Exception paramContext)
        {
          break label7466;
        }
      }
      catch (Exception paramContext)
      {
        break label7317;
      }
      Toast.makeText(com.tencent.mm.sdk.platformtools.ah.getContext(), "Using SVG Code : " + bool1 + " " + com.tencent.mm.svg.b.b.dAk(), 1).show();
      label7317:
      AppMethodBeat.o(16100);
      return true;
    }
  }
  
  /* Error */
  private static StringBuilder iY(int paramInt)
  {
    // Byte code:
    //   0: sipush 16102
    //   3: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 3550	java/util/Date
    //   9: dup
    //   10: invokestatic 3553	com/tencent/mm/sdk/platformtools/bo:aoy	()J
    //   13: iload_0
    //   14: i2l
    //   15: ldc2_w 3554
    //   18: lmul
    //   19: lsub
    //   20: invokespecial 3557	java/util/Date:<init>	(J)V
    //   23: astore_1
    //   24: new 3559	java/text/SimpleDateFormat
    //   27: dup
    //   28: ldc_w 3561
    //   31: invokestatic 3567	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   34: invokespecial 3570	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   37: astore_2
    //   38: new 161	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   45: getstatic 1628	com/tencent/mm/compatible/util/e:eQA	Ljava/lang/String;
    //   48: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: ldc_w 3572
    //   54: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: aload_2
    //   58: aload_1
    //   59: invokevirtual 3575	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   62: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: ldc_w 3577
    //   68: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: astore_1
    //   75: new 161	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   82: astore 4
    //   84: aload_1
    //   85: invokestatic 3580	com/tencent/mm/vfs/e:cN	(Ljava/lang/String;)Z
    //   88: ifeq +42 -> 130
    //   91: new 161	java/lang/StringBuilder
    //   94: dup
    //   95: new 161	java/lang/StringBuilder
    //   98: dup
    //   99: ldc_w 3582
    //   102: invokespecial 182	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   105: iload_0
    //   106: invokevirtual 1436	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   109: ldc_w 3584
    //   112: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokespecial 182	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   121: astore_1
    //   122: sipush 16102
    //   125: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: aload_1
    //   129: areturn
    //   130: new 3586	java/io/BufferedReader
    //   133: dup
    //   134: new 3588	com/tencent/mm/vfs/g
    //   137: dup
    //   138: aload_1
    //   139: invokespecial 3589	com/tencent/mm/vfs/g:<init>	(Ljava/lang/String;)V
    //   142: invokespecial 3592	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   145: astore_2
    //   146: aload_2
    //   147: astore_1
    //   148: aload_2
    //   149: invokevirtual 3595	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   152: invokestatic 159	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   155: ifeq +54 -> 209
    //   158: aload_2
    //   159: astore_1
    //   160: aload_2
    //   161: invokevirtual 3598	java/io/BufferedReader:close	()V
    //   164: aload_2
    //   165: astore_1
    //   166: new 161	java/lang/StringBuilder
    //   169: dup
    //   170: new 161	java/lang/StringBuilder
    //   173: dup
    //   174: ldc_w 3600
    //   177: invokespecial 182	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   180: iload_0
    //   181: invokevirtual 1436	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   184: ldc_w 3602
    //   187: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokespecial 182	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   196: astore_3
    //   197: aload_2
    //   198: invokevirtual 3598	java/io/BufferedReader:close	()V
    //   201: sipush 16102
    //   204: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   207: aload_3
    //   208: areturn
    //   209: aload_2
    //   210: astore_1
    //   211: aload_2
    //   212: invokevirtual 3595	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   215: astore_3
    //   216: aload_3
    //   217: ifnull +85 -> 302
    //   220: aload_2
    //   221: astore_1
    //   222: aload 4
    //   224: new 79	java/lang/String
    //   227: dup
    //   228: aload_3
    //   229: ldc_w 3604
    //   232: invokevirtual 393	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   235: iconst_1
    //   236: aaload
    //   237: iconst_0
    //   238: invokestatic 3610	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   241: invokespecial 3613	java/lang/String:<init>	([B)V
    //   244: ldc_w 3615
    //   247: invokevirtual 393	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   250: iconst_1
    //   251: aaload
    //   252: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: pop
    //   256: aload_2
    //   257: astore_1
    //   258: aload 4
    //   260: ldc_w 3617
    //   263: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: pop
    //   267: goto -58 -> 209
    //   270: astore_3
    //   271: aload_2
    //   272: astore_1
    //   273: ldc 139
    //   275: aload_3
    //   276: ldc 141
    //   278: iconst_0
    //   279: anewarray 4	java/lang/Object
    //   282: invokestatic 147	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   285: aload_2
    //   286: ifnull +7 -> 293
    //   289: aload_2
    //   290: invokevirtual 3598	java/io/BufferedReader:close	()V
    //   293: sipush 16102
    //   296: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   299: aload 4
    //   301: areturn
    //   302: aload_2
    //   303: invokevirtual 3598	java/io/BufferedReader:close	()V
    //   306: goto -13 -> 293
    //   309: astore_1
    //   310: goto -17 -> 293
    //   313: astore_2
    //   314: aconst_null
    //   315: astore_1
    //   316: aload_1
    //   317: ifnull +7 -> 324
    //   320: aload_1
    //   321: invokevirtual 3598	java/io/BufferedReader:close	()V
    //   324: sipush 16102
    //   327: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  private static void iZ(int paramInt)
  {
    AppMethodBeat.i(16103);
    Object localObject = ar.r(com.tencent.mm.sdk.platformtools.ah.getContext(), "sp_sns_dynswitch_stg", 4);
    switch (paramInt)
    {
    default: 
      localObject = new IllegalArgumentException("Bad op parameter: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(16103);
      throw ((Throwable)localObject);
    case -1: 
      ((SharedPreferences)localObject).edit().remove("st_sw_use_vcodec_img").commit();
      AppMethodBeat.o(16103);
      return;
    case 0: 
      ((SharedPreferences)localObject).edit().putBoolean("st_sw_use_vcodec_img", false).commit();
      AppMethodBeat.o(16103);
      return;
    }
    ((SharedPreferences)localObject).edit().putBoolean("st_sw_use_vcodec_img", true).commit();
    AppMethodBeat.o(16103);
  }
  
  private static void ja(int paramInt)
  {
    AppMethodBeat.i(16104);
    Object localObject = ar.r(com.tencent.mm.sdk.platformtools.ah.getContext(), "sp_sns_dynswitch_stg", 4);
    switch (paramInt)
    {
    default: 
      localObject = new IllegalArgumentException("Bad op parameter: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(16104);
      throw ((Throwable)localObject);
    case -1: 
      ((SharedPreferences)localObject).edit().remove("st_sw_use_wxpc_img").commit();
      AppMethodBeat.o(16104);
      return;
    case 0: 
      ((SharedPreferences)localObject).edit().putBoolean("st_sw_use_wxpc_img", false).commit();
      AppMethodBeat.o(16104);
      return;
    }
    ((SharedPreferences)localObject).edit().putBoolean("st_sw_use_wxpc_img", true).commit();
    AppMethodBeat.o(16104);
  }
  
  private static int lD(String paramString)
  {
    AppMethodBeat.i(16097);
    if ((!paramString.startsWith("//")) || (paramString.length() <= 2))
    {
      AppMethodBeat.o(16097);
      return 0;
    }
    int j = paramString.indexOf(" ");
    int i = j;
    if (j == -1) {
      i = paramString.length();
    }
    try
    {
      i = bo.getInt(paramString.substring(2, i), 0);
      j = com.tencent.mm.protocal.d.whH % 256;
      if ((j == 0) || (i < j) || (i % j != 0))
      {
        AppMethodBeat.o(16097);
        return 0;
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(16097);
      return 0;
    }
    i /= j;
    AppMethodBeat.o(16097);
    return i;
  }
  
  private static String lE(String paramString)
  {
    AppMethodBeat.i(16098);
    int i = paramString.indexOf(" ");
    if (i < 0)
    {
      AppMethodBeat.o(16098);
      return "";
    }
    paramString = paramString.substring(i).trim();
    AppMethodBeat.o(16098);
    return paramString;
  }
  
  private static boolean lF(String paramString)
  {
    AppMethodBeat.i(16099);
    Iterator localIterator = etS.iterator();
    while (localIterator.hasNext()) {
      if (paramString.startsWith((String)localIterator.next()))
      {
        AppMethodBeat.o(16099);
        return true;
      }
    }
    AppMethodBeat.o(16099);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.console.b
 * JD-Core Version:    0.7.0.1
 */