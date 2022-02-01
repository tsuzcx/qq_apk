package com.tencent.mm.plugin.hp.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.plugin.boots.a.c;
import com.tencent.mm.plugin.boots.b.a;
import com.tencent.mm.plugin.hp.b.b;
import com.tencent.mm.plugin.hp.net.SimpleHttpLogic;
import com.tencent.mm.plugin.hp.net.SimpleHttpLogic.Request;
import com.tencent.mm.plugin.hp.net.SimpleHttpLogic.TaskCallback;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.dzo;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.protocal.protobuf.dzq;
import com.tencent.mm.protocal.protobuf.dzr;
import com.tencent.mm.protocal.protobuf.dzt;
import com.tencent.mm.protocal.protobuf.ery;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.threadpool.i;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class f
  implements com.tencent.mm.pluginsdk.cmd.a
{
  private static void fPS()
  {
    AppMethodBeat.i(117440);
    Object localObject = ((c)com.tencent.mm.kernel.h.ax(c.class)).dbd();
    if (!((List)localObject).isEmpty())
    {
      Log.e("MicroMsg.Tinker.TinkerBootsCommand", "start day active keys");
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.plugin.boots.a.a locala = (com.tencent.mm.plugin.boots.a.a)((Iterator)localObject).next();
        Log.i("MicroMsg.Tinker.TinkerBootsCommand", "key:%s active:%d", new Object[] { Integer.toHexString(locala.field_key), Integer.valueOf(locala.field_dau) });
      }
    }
    AppMethodBeat.o(117440);
  }
  
  public static void fPT()
  {
    AppMethodBeat.i(261858);
    com.tencent.threadpool.h.ahAA.bm(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(261853);
        SimpleHttpLogic.Request localRequest = new SimpleHttpLogic.Request();
        localRequest.cgi = "/cgi-bin/micromsg-bin/mmtlsprconfig";
        localRequest.host = "short.weixin.qq.com";
        dzp localdzp = new dzp();
        localdzp.abeK = "tinker_id_834582c31727099da72312e81eb61c550d05bdfa_arm64-v8a-Test";
        Object localObject = new dzo();
        ((dzo)localObject).key = "";
        ((dzo)localObject).value = "";
        localdzp.abeL.add(localObject);
        localdzp.ycW = "";
        localObject = new PByteArray();
        try
        {
          Log.i("simple", "pack result ".concat(String.valueOf(SimpleHttpLogic.packRequest(localdzp.toByteArray(), (PByteArray)localObject))));
        }
        catch (Exception localException1)
        {
          try
          {
            for (;;)
            {
              localRequest.body = ((PByteArray)localObject).value;
              SimpleHttpLogic.startRequest(localRequest, new a(), "101.227.131.113");
              AppMethodBeat.o(261853);
              return;
              localException1 = localException1;
              Log.e("simple", "pack failed " + localException1.getLocalizedMessage());
            }
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              Log.e("simple", localException2.getLocalizedMessage());
            }
          }
        }
      }
      
      final class a
        implements SimpleHttpLogic.TaskCallback
      {
        a() {}
        
        public final void onCompleted(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
        {
          AppMethodBeat.i(261860);
          Log.i("simple", "errorType: %d, errorCode:%d, result is %s , length %d ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramArrayOfByte, Integer.valueOf(paramArrayOfByte.length) });
          try
          {
            PByteArray localPByteArray = new PByteArray();
            boolean bool = SimpleHttpLogic.unpackResponse(paramArrayOfByte, localPByteArray);
            Log.e("simple", "unpack result ".concat(String.valueOf(bool)));
            if (bool)
            {
              paramArrayOfByte = new dzq();
              paramArrayOfByte.parseFrom(localPByteArray.value);
              if ((paramArrayOfByte.BaseResponse != null) && (paramArrayOfByte.abeK != null) && (paramArrayOfByte.ycW != null))
              {
                Log.e("simple", "response is " + paramArrayOfByte.BaseResponse.Idd + " error msg " + paramArrayOfByte.BaseResponse.akjO);
                Log.e("simple", "response base id is " + paramArrayOfByte.abeK + " error msg " + paramArrayOfByte.ycW);
              }
            }
            AppMethodBeat.o(261860);
            return;
          }
          catch (Exception paramArrayOfByte)
          {
            Log.e("simple", "unpack failed. " + paramArrayOfByte.getLocalizedMessage());
            AppMethodBeat.o(261860);
          }
        }
      }
    });
    AppMethodBeat.o(261858);
  }
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(117439);
    if (paramArrayOfString.length < 2)
    {
      Log.d("MicroMsg.Tinker.TinkerBootsCommand", "no args input.");
      AppMethodBeat.o(117439);
      return false;
    }
    paramContext = paramArrayOfString[1];
    int i;
    if (CrashReportFactory.hasDebuger()) {
      i = -1;
    }
    switch (paramContext.hashCode())
    {
    default: 
      switch (i)
      {
      default: 
        label116:
        Log.d("MicroMsg.Tinker.TinkerBootsCommand", "%s i not a debugger command.", new Object[] { paramContext });
        i = -1;
        switch (paramContext.hashCode())
        {
        }
        break;
      }
      break;
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        Log.d("MicroMsg.Tinker.TinkerBootsCommand", "%s is not a release command.", new Object[] { paramContext });
        AppMethodBeat.o(117439);
        return false;
        if (!paramContext.equals("update")) {
          break label116;
        }
        i = 0;
        break label116;
        if (!paramContext.equals("show")) {
          break label116;
        }
        i = 1;
        break label116;
        if (!paramContext.equals("diff")) {
          break label116;
        }
        i = 2;
        break label116;
        if (!paramContext.equals("down")) {
          break label116;
        }
        i = 3;
        break label116;
        if (!paramContext.equals("nd")) {
          break label116;
        }
        i = 4;
        break label116;
        if (!paramContext.equals("clear")) {
          break label116;
        }
        i = 5;
        break label116;
        if (!paramContext.equals("process")) {
          break label116;
        }
        i = 6;
        break label116;
        if (!paramContext.equals("showall")) {
          break label116;
        }
        i = 7;
        break label116;
        Log.d("MicroMsg.Tinker.TinkerBootsCommand", "command checkout update.");
        new LinkedList();
        paramContext = com.tencent.mm.plugin.hp.net.e.fPU();
        paramArrayOfString = new StringBuilder();
        paramString = paramContext.iterator();
        while (paramString.hasNext())
        {
          dzo localdzo = (dzo)paramString.next();
          paramArrayOfString.append(localdzo.key).append(":").append(localdzo.value).append("\n");
        }
        Log.d("MicroMsg.Tinker.TinkerBootsCommand", "BaseID:%s PatchID:%s %s", new Object[] { "tinker_id_2468c5efe7670b901f7738f7a699d3843acc3651_arm64-v8a", "", paramArrayOfString.toString() });
        paramContext = new com.tencent.mm.plugin.hp.net.d("tinker_id_2468c5efe7670b901f7738f7a699d3843acc3651_arm64-v8a", "", paramContext);
        com.tencent.mm.kernel.h.aZW().a(paramContext, 0);
        AppMethodBeat.o(117439);
        return true;
        h.a(MMApplicationContext.getContext().getString(b.a.fmt_update), MMApplicationContext.getContext().getString(b.a.fmt_update), MMApplicationContext.getContext().getString(b.a.install_now), new f.1(this), MMApplicationContext.getContext().getString(b.a.update_cancel), null);
        AppMethodBeat.o(117439);
        return true;
        com.tencent.mm.kernel.h.baH().postToWorker(new f.2(this, paramArrayOfString));
        AppMethodBeat.o(117439);
        return true;
        paramContext = new dzt();
        paramContext.abeW = 1000;
        paramContext.abeT = 2;
        paramContext.abeU = 2;
        paramContext.state = 2;
        paramContext.ycW = "android_tinker_id_123123131231231";
        paramArrayOfString = new ery();
        paramArrayOfString.MD5 = "c3282ad2467fad9561227bc9b5b6712c";
        paramArrayOfString.Nju = 118617;
        paramArrayOfString.Url = ("http://" + WeChatHosts.domainString(b.a.host_dldir1_qq_com) + "/weixin/checkresupdate/0x2605136d.3144f5.0x26051334.bf52fb_1510754399.apk");
        paramContext.abeT = 3;
        paramArrayOfString.MD5 = "3ba62fdbd98df2bdf5da7d726010d867";
        paramArrayOfString.Nju = 33338711;
        paramArrayOfString.Url = ("http://" + WeChatHosts.domainString(b.a.host_dldir1_qq_com) + "/weixin/checkresupdate/0x26051363.6cc887.0x26051087.a44d04_1510750804.apk");
        paramContext.abeV = paramArrayOfString;
        new e(new b(paramContext)).xx(false);
        AppMethodBeat.o(117439);
        return true;
        if (paramArrayOfString.length >= 6) {
          Util.safeParseLong(paramArrayOfString[5]);
        }
        AppMethodBeat.o(117439);
        return true;
        com.tencent.mm.plugin.hp.tinker.h.bj(MMApplicationContext.getContext(), "");
        com.tencent.mm.plugin.hp.tinker.h.bm(MMApplicationContext.getContext(), "");
        com.tencent.mm.plugin.hp.tinker.h.aN(MMApplicationContext.getContext(), 0);
        MMApplicationContext.getContext();
        com.tencent.mm.plugin.hp.b.d.fQt();
        AppMethodBeat.o(117439);
        return true;
        paramContext = new dzt();
        paramContext.abeW = 1000;
        paramContext.abeT = 3;
        paramContext.abeU = 2;
        paramContext.state = 2;
        paramContext.ycW = "android_tinker_id_123123131231231";
        paramArrayOfString = new ery();
        paramArrayOfString.MD5 = "3ba62fdbd98df2bdf5da7d726010d867";
        paramArrayOfString.Nju = 33338711;
        paramArrayOfString.Url = ("http://" + WeChatHosts.domainString(b.a.host_dldir1_qq_com) + "/weixin/checkresupdate/0x26051363.6cc887.0x26051087.a44d04_1510750804.apk");
        paramContext.abeV = paramArrayOfString;
        paramArrayOfString = new dzr();
        paramArrayOfString.key = "clientVersion";
        paramArrayOfString.value = "0x26060510";
        paramContext.abeX.add(paramArrayOfString);
        paramArrayOfString = new dzr();
        paramArrayOfString.key = "alphaTitle";
        paramArrayOfString.value = "叫你更新你就更新";
        paramContext.abeX.add(paramArrayOfString);
        paramArrayOfString = new dzr();
        paramArrayOfString.key = "alphaContent";
        paramArrayOfString.value = "这个包可以抢到的红包最大，抢红包速度最快。";
        paramContext.abeX.add(paramArrayOfString);
        paramArrayOfString = new dzr();
        paramArrayOfString.key = "alphaUrl";
        paramArrayOfString.value = "www.qq.com";
        paramContext.abeX.add(paramArrayOfString);
        new e(new b(paramContext)).xx(true);
        AppMethodBeat.o(117439);
        return true;
        fPS();
        AppMethodBeat.o(117439);
        return true;
        if (paramContext.equals("check")) {
          i = 0;
        }
        break;
      }
    }
    try
    {
      com.tinkerboots.sdk.a.kkr().Pi(true);
      AppMethodBeat.o(117439);
      return true;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.Tinker.TinkerBootsCommand", paramContext, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.model.f
 * JD-Core Version:    0.7.0.1
 */