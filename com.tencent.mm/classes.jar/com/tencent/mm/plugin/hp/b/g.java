package com.tencent.mm.plugin.hp.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.boots.a.c;
import com.tencent.mm.plugin.hp.net.SimpleHttpLogic;
import com.tencent.mm.plugin.hp.net.SimpleHttpLogic.Request;
import com.tencent.mm.plugin.hp.net.SimpleHttpLogic.TaskCallback;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cgt;
import com.tencent.mm.protocal.protobuf.cgu;
import com.tencent.mm.protocal.protobuf.cgv;
import com.tencent.mm.protocal.protobuf.cgw;
import com.tencent.mm.protocal.protobuf.cgy;
import com.tencent.mm.protocal.protobuf.cvl;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g
  implements com.tencent.mm.pluginsdk.cmd.a
{
  private static void dcq()
  {
    AppMethodBeat.i(117440);
    Object localObject = ((c)com.tencent.mm.kernel.g.ab(c.class)).bMT();
    if (!((List)localObject).isEmpty())
    {
      ad.e("MicroMsg.Tinker.TinkerBootsCommand", "start day active keys");
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.plugin.boots.a.a locala = (com.tencent.mm.plugin.boots.a.a)((Iterator)localObject).next();
        ad.i("MicroMsg.Tinker.TinkerBootsCommand", "key:%s active:%d", new Object[] { Integer.toHexString(locala.field_key), Integer.valueOf(locala.field_dau) });
      }
    }
    AppMethodBeat.o(117440);
  }
  
  public static void dcr()
  {
    AppMethodBeat.i(218899);
    com.tencent.e.h.LTJ.aR(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(218898);
        SimpleHttpLogic.Request localRequest = new SimpleHttpLogic.Request();
        localRequest.cgi = "/cgi-bin/micromsg-bin/mmtlsprconfig";
        localRequest.host = "short.weixin.qq.com";
        cgu localcgu = new cgu();
        localcgu.Hak = "tinker_id_834582c31727099da72312e81eb61c550d05bdfa_arm64-v8a-Test";
        Object localObject = new cgt();
        ((cgt)localObject).key = "";
        ((cgt)localObject).value = "";
        localcgu.Hal.add(localObject);
        localcgu.wDT = "";
        localObject = new PByteArray();
        try
        {
          ad.i("simple", "pack result ".concat(String.valueOf(SimpleHttpLogic.packRequest(localcgu.toByteArray(), (PByteArray)localObject))));
        }
        catch (Exception localException1)
        {
          try
          {
            for (;;)
            {
              localRequest.body = ((PByteArray)localObject).value;
              SimpleHttpLogic.startRequest(localRequest, new a(), "101.227.131.113");
              AppMethodBeat.o(218898);
              return;
              localException1 = localException1;
              ad.e("simple", "pack failed " + localException1.getLocalizedMessage());
            }
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              ad.e("simple", localException2.getLocalizedMessage());
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
          AppMethodBeat.i(218897);
          ad.i("simple", "errorType: %d, errorCode:%d, result is %s , length %d ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramArrayOfByte, Integer.valueOf(paramArrayOfByte.length) });
          try
          {
            PByteArray localPByteArray = new PByteArray();
            boolean bool = SimpleHttpLogic.unpackResponse(paramArrayOfByte, localPByteArray);
            ad.e("simple", "unpack result ".concat(String.valueOf(bool)));
            if (bool)
            {
              paramArrayOfByte = new cgv();
              paramArrayOfByte.parseFrom(localPByteArray.value);
              if ((paramArrayOfByte.BaseResponse != null) && (paramArrayOfByte.Hak != null) && (paramArrayOfByte.wDT != null))
              {
                ad.e("simple", "response is " + paramArrayOfByte.BaseResponse.Ret + " error msg " + paramArrayOfByte.BaseResponse.ErrMsg);
                ad.e("simple", "response base id is " + paramArrayOfByte.Hak + " error msg " + paramArrayOfByte.wDT);
              }
            }
            AppMethodBeat.o(218897);
            return;
          }
          catch (Exception paramArrayOfByte)
          {
            ad.e("simple", "unpack failed. " + paramArrayOfByte.getLocalizedMessage());
            AppMethodBeat.o(218897);
          }
        }
      }
    });
    AppMethodBeat.o(218899);
  }
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(117439);
    if (paramArrayOfString.length < 2)
    {
      ad.d("MicroMsg.Tinker.TinkerBootsCommand", "no args input.");
      AppMethodBeat.o(117439);
      return false;
    }
    paramContext = paramArrayOfString[1];
    int i;
    if (com.tencent.mm.sdk.a.b.fjN()) {
      i = -1;
    }
    switch (paramContext.hashCode())
    {
    default: 
      switch (i)
      {
      default: 
        label116:
        ad.d("MicroMsg.Tinker.TinkerBootsCommand", "%s i not a debugger command.", new Object[] { paramContext });
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
        ad.d("MicroMsg.Tinker.TinkerBootsCommand", "%s is not a release command.", new Object[] { paramContext });
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
        ad.d("MicroMsg.Tinker.TinkerBootsCommand", "command checkout update.");
        new LinkedList();
        paramContext = com.tencent.mm.plugin.hp.net.e.dcs();
        paramArrayOfString = new StringBuilder();
        paramString = paramContext.iterator();
        while (paramString.hasNext())
        {
          cgt localcgt = (cgt)paramString.next();
          paramArrayOfString.append(localcgt.key).append(":").append(localcgt.value).append("\n");
        }
        ad.d("MicroMsg.Tinker.TinkerBootsCommand", "BaseID:%s PatchID:%s %s", new Object[] { "tinker_id_2468c5efe7670b901f7738f7a699d3843acc3651_arm64-v8a", "", paramArrayOfString.toString() });
        paramContext = new com.tencent.mm.plugin.hp.net.d("tinker_id_2468c5efe7670b901f7738f7a699d3843acc3651_arm64-v8a", "", paramContext);
        com.tencent.mm.kernel.g.aiU().a(paramContext, 0);
        AppMethodBeat.o(117439);
        return true;
        i.a(aj.getContext().getString(2131759571), aj.getContext().getString(2131759571), aj.getContext().getString(2131760343), new g.1(this), aj.getContext().getString(2131764569), null);
        AppMethodBeat.o(117439);
        return true;
        com.tencent.mm.kernel.g.ajF().ay(new g.2(this, paramArrayOfString));
        AppMethodBeat.o(117439);
        return true;
        paramContext = new cgy();
        paramContext.Haw = 1000;
        paramContext.Hat = 2;
        paramContext.Hau = 2;
        paramContext.state = 2;
        paramContext.wDT = "android_tinker_id_123123131231231";
        paramArrayOfString = new cvl();
        paramArrayOfString.MD5 = "c3282ad2467fad9561227bc9b5b6712c";
        paramArrayOfString.FileSize = 118617;
        paramArrayOfString.Url = "http://dldir1.qq.com/weixin/checkresupdate/0x2605136d.3144f5.0x26051334.bf52fb_1510754399.apk";
        paramContext.Hat = 3;
        paramArrayOfString.MD5 = "3ba62fdbd98df2bdf5da7d726010d867";
        paramArrayOfString.FileSize = 33338711;
        paramArrayOfString.Url = "http://dldir1.qq.com/weixin/checkresupdate/0x26051363.6cc887.0x26051087.a44d04_1510750804.apk";
        paramContext.Hav = paramArrayOfString;
        new e(new com.tencent.mm.plugin.hp.d.b(paramContext)).nx(false);
        AppMethodBeat.o(117439);
        return true;
        if (paramArrayOfString.length >= 6) {
          bt.aRf(paramArrayOfString[5]);
        }
        AppMethodBeat.o(117439);
        return true;
        com.tencent.mm.plugin.hp.tinker.h.aG(aj.getContext(), "");
        com.tencent.mm.plugin.hp.tinker.h.aJ(aj.getContext(), "");
        com.tencent.mm.plugin.hp.tinker.h.ac(aj.getContext(), 0);
        aj.getContext();
        com.tencent.mm.plugin.hp.d.d.dcO();
        AppMethodBeat.o(117439);
        return true;
        paramContext = new cgy();
        paramContext.Haw = 1000;
        paramContext.Hat = 3;
        paramContext.Hau = 2;
        paramContext.state = 2;
        paramContext.wDT = "android_tinker_id_123123131231231";
        paramArrayOfString = new cvl();
        paramArrayOfString.MD5 = "3ba62fdbd98df2bdf5da7d726010d867";
        paramArrayOfString.FileSize = 33338711;
        paramArrayOfString.Url = "http://dldir1.qq.com/weixin/checkresupdate/0x26051363.6cc887.0x26051087.a44d04_1510750804.apk";
        paramContext.Hav = paramArrayOfString;
        paramArrayOfString = new cgw();
        paramArrayOfString.key = "clientVersion";
        paramArrayOfString.value = "0x26060510";
        paramContext.Hax.add(paramArrayOfString);
        paramArrayOfString = new cgw();
        paramArrayOfString.key = "alphaTitle";
        paramArrayOfString.value = "叫你更新你就更新";
        paramContext.Hax.add(paramArrayOfString);
        paramArrayOfString = new cgw();
        paramArrayOfString.key = "alphaContent";
        paramArrayOfString.value = "这个包可以抢到的红包最大，抢红包速度最快。";
        paramContext.Hax.add(paramArrayOfString);
        paramArrayOfString = new cgw();
        paramArrayOfString.key = "alphaUrl";
        paramArrayOfString.value = "www.qq.com";
        paramContext.Hax.add(paramArrayOfString);
        new e(new com.tencent.mm.plugin.hp.d.b(paramContext)).nx(true);
        AppMethodBeat.o(117439);
        return true;
        dcq();
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
      com.tinkerboots.sdk.a.gdU().zV(true);
      AppMethodBeat.o(117439);
      return true;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.Tinker.TinkerBootsCommand", paramContext, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.b.g
 * JD-Core Version:    0.7.0.1
 */