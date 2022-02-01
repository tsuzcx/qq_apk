package com.tencent.mm.plugin.hp.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.plugin.boots.a.c;
import com.tencent.mm.plugin.hp.d.b;
import com.tencent.mm.plugin.hp.net.SimpleHttpLogic;
import com.tencent.mm.plugin.hp.net.SimpleHttpLogic.Request;
import com.tencent.mm.plugin.hp.net.SimpleHttpLogic.TaskCallback;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cxu;
import com.tencent.mm.protocal.protobuf.cxv;
import com.tencent.mm.protocal.protobuf.cxw;
import com.tencent.mm.protocal.protobuf.cxx;
import com.tencent.mm.protocal.protobuf.cxz;
import com.tencent.mm.protocal.protobuf.doy;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g
  implements com.tencent.mm.pluginsdk.cmd.a
{
  private static void dZc()
  {
    AppMethodBeat.i(117440);
    Object localObject = ((c)com.tencent.mm.kernel.g.af(c.class)).ckR();
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
  
  public static void dZd()
  {
    AppMethodBeat.i(196774);
    com.tencent.f.h.RTc.aX(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(196773);
        SimpleHttpLogic.Request localRequest = new SimpleHttpLogic.Request();
        localRequest.cgi = "/cgi-bin/micromsg-bin/mmtlsprconfig";
        localRequest.host = "short.weixin.qq.com";
        cxv localcxv = new cxv();
        localcxv.MCI = "tinker_id_834582c31727099da72312e81eb61c550d05bdfa_arm64-v8a-Test";
        Object localObject = new cxu();
        ((cxu)localObject).key = "";
        ((cxu)localObject).value = "";
        localcxv.MCJ.add(localObject);
        localcxv.APx = "";
        localObject = new PByteArray();
        try
        {
          Log.i("simple", "pack result ".concat(String.valueOf(SimpleHttpLogic.packRequest(localcxv.toByteArray(), (PByteArray)localObject))));
        }
        catch (Exception localException1)
        {
          try
          {
            for (;;)
            {
              localRequest.body = ((PByteArray)localObject).value;
              SimpleHttpLogic.startRequest(localRequest, new a(), "101.227.131.113");
              AppMethodBeat.o(196773);
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
          AppMethodBeat.i(196772);
          Log.i("simple", "errorType: %d, errorCode:%d, result is %s , length %d ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramArrayOfByte, Integer.valueOf(paramArrayOfByte.length) });
          try
          {
            PByteArray localPByteArray = new PByteArray();
            boolean bool = SimpleHttpLogic.unpackResponse(paramArrayOfByte, localPByteArray);
            Log.e("simple", "unpack result ".concat(String.valueOf(bool)));
            if (bool)
            {
              paramArrayOfByte = new cxw();
              paramArrayOfByte.parseFrom(localPByteArray.value);
              if ((paramArrayOfByte.BaseResponse != null) && (paramArrayOfByte.MCI != null) && (paramArrayOfByte.APx != null))
              {
                Log.e("simple", "response is " + paramArrayOfByte.BaseResponse.Ret + " error msg " + paramArrayOfByte.BaseResponse.ErrMsg);
                Log.e("simple", "response base id is " + paramArrayOfByte.MCI + " error msg " + paramArrayOfByte.APx);
              }
            }
            AppMethodBeat.o(196772);
            return;
          }
          catch (Exception paramArrayOfByte)
          {
            Log.e("simple", "unpack failed. " + paramArrayOfByte.getLocalizedMessage());
            AppMethodBeat.o(196772);
          }
        }
      }
    });
    AppMethodBeat.o(196774);
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
        paramContext = com.tencent.mm.plugin.hp.net.e.dZe();
        paramArrayOfString = new StringBuilder();
        paramString = paramContext.iterator();
        while (paramString.hasNext())
        {
          cxu localcxu = (cxu)paramString.next();
          paramArrayOfString.append(localcxu.key).append(":").append(localcxu.value).append("\n");
        }
        Log.d("MicroMsg.Tinker.TinkerBootsCommand", "BaseID:%s PatchID:%s %s", new Object[] { "tinker_id_2468c5efe7670b901f7738f7a699d3843acc3651_arm64-v8a", "", paramArrayOfString.toString() });
        paramContext = new com.tencent.mm.plugin.hp.net.d("tinker_id_2468c5efe7670b901f7738f7a699d3843acc3651_arm64-v8a", "", paramContext);
        com.tencent.mm.kernel.g.azz().a(paramContext, 0);
        AppMethodBeat.o(117439);
        return true;
        i.a(MMApplicationContext.getContext().getString(2131760888), MMApplicationContext.getContext().getString(2131760888), MMApplicationContext.getContext().getString(2131761788), new g.1(this), MMApplicationContext.getContext().getString(2131766915), null);
        AppMethodBeat.o(117439);
        return true;
        com.tencent.mm.kernel.g.aAk().postToWorker(new g.2(this, paramArrayOfString));
        AppMethodBeat.o(117439);
        return true;
        paramContext = new cxz();
        paramContext.MCU = 1000;
        paramContext.MCR = 2;
        paramContext.MCS = 2;
        paramContext.state = 2;
        paramContext.APx = "android_tinker_id_123123131231231";
        paramArrayOfString = new doy();
        paramArrayOfString.MD5 = "c3282ad2467fad9561227bc9b5b6712c";
        paramArrayOfString.FileSize = 118617;
        paramArrayOfString.Url = ("http://" + WeChatHosts.domainString(2131761706) + "/weixin/checkresupdate/0x2605136d.3144f5.0x26051334.bf52fb_1510754399.apk");
        paramContext.MCR = 3;
        paramArrayOfString.MD5 = "3ba62fdbd98df2bdf5da7d726010d867";
        paramArrayOfString.FileSize = 33338711;
        paramArrayOfString.Url = ("http://" + WeChatHosts.domainString(2131761706) + "/weixin/checkresupdate/0x26051363.6cc887.0x26051087.a44d04_1510750804.apk");
        paramContext.MCT = paramArrayOfString;
        new e(new b(paramContext)).qk(false);
        AppMethodBeat.o(117439);
        return true;
        if (paramArrayOfString.length >= 6) {
          Util.safeParseLong(paramArrayOfString[5]);
        }
        AppMethodBeat.o(117439);
        return true;
        com.tencent.mm.plugin.hp.tinker.h.aV(MMApplicationContext.getContext(), "");
        com.tencent.mm.plugin.hp.tinker.h.aY(MMApplicationContext.getContext(), "");
        com.tencent.mm.plugin.hp.tinker.h.aj(MMApplicationContext.getContext(), 0);
        MMApplicationContext.getContext();
        com.tencent.mm.plugin.hp.d.d.dZA();
        AppMethodBeat.o(117439);
        return true;
        paramContext = new cxz();
        paramContext.MCU = 1000;
        paramContext.MCR = 3;
        paramContext.MCS = 2;
        paramContext.state = 2;
        paramContext.APx = "android_tinker_id_123123131231231";
        paramArrayOfString = new doy();
        paramArrayOfString.MD5 = "3ba62fdbd98df2bdf5da7d726010d867";
        paramArrayOfString.FileSize = 33338711;
        paramArrayOfString.Url = ("http://" + WeChatHosts.domainString(2131761706) + "/weixin/checkresupdate/0x26051363.6cc887.0x26051087.a44d04_1510750804.apk");
        paramContext.MCT = paramArrayOfString;
        paramArrayOfString = new cxx();
        paramArrayOfString.key = "clientVersion";
        paramArrayOfString.value = "0x26060510";
        paramContext.MCV.add(paramArrayOfString);
        paramArrayOfString = new cxx();
        paramArrayOfString.key = "alphaTitle";
        paramArrayOfString.value = "叫你更新你就更新";
        paramContext.MCV.add(paramArrayOfString);
        paramArrayOfString = new cxx();
        paramArrayOfString.key = "alphaContent";
        paramArrayOfString.value = "这个包可以抢到的红包最大，抢红包速度最快。";
        paramContext.MCV.add(paramArrayOfString);
        paramArrayOfString = new cxx();
        paramArrayOfString.key = "alphaUrl";
        paramArrayOfString.value = "www.qq.com";
        paramContext.MCV.add(paramArrayOfString);
        new e(new b(paramContext)).qk(true);
        AppMethodBeat.o(117439);
        return true;
        dZc();
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
      com.tinkerboots.sdk.a.hvX().Ey(true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.b.g
 * JD-Core Version:    0.7.0.1
 */