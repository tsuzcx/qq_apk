package com.tencent.mm.plugin.hp.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.boots.a.c;
import com.tencent.mm.plugin.hp.net.SimpleHttpLogic;
import com.tencent.mm.plugin.hp.net.SimpleHttpLogic.Request;
import com.tencent.mm.plugin.hp.net.SimpleHttpLogic.TaskCallback;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.ccc;
import com.tencent.mm.protocal.protobuf.ccd;
import com.tencent.mm.protocal.protobuf.cce;
import com.tencent.mm.protocal.protobuf.ccf;
import com.tencent.mm.protocal.protobuf.cch;
import com.tencent.mm.protocal.protobuf.cqg;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g
  implements com.tencent.mm.pluginsdk.cmd.a
{
  private static void cTj()
  {
    AppMethodBeat.i(117440);
    Object localObject = ((c)com.tencent.mm.kernel.g.ab(c.class)).bIG();
    if (!((List)localObject).isEmpty())
    {
      ac.e("MicroMsg.Tinker.TinkerBootsCommand", "start day active keys");
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.plugin.boots.a.a locala = (com.tencent.mm.plugin.boots.a.a)((Iterator)localObject).next();
        ac.i("MicroMsg.Tinker.TinkerBootsCommand", "key:%s active:%d", new Object[] { Integer.toHexString(locala.field_key), Integer.valueOf(locala.field_dau) });
      }
    }
    AppMethodBeat.o(117440);
  }
  
  public static void cTk()
  {
    AppMethodBeat.i(189687);
    com.tencent.e.h.JZN.aS(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(189686);
        SimpleHttpLogic.Request localRequest = new SimpleHttpLogic.Request();
        localRequest.cgi = "/cgi-bin/micromsg-bin/mmtlsprconfig";
        localRequest.host = "short.weixin.qq.com";
        ccd localccd = new ccd();
        localccd.FqA = "tinker_id_834582c31727099da72312e81eb61c550d05bdfa_arm64-v8a-Test";
        Object localObject = new ccc();
        ((ccc)localObject).key = "";
        ((ccc)localObject).value = "";
        localccd.FqB.add(localObject);
        localccd.vyz = "";
        localObject = new PByteArray();
        try
        {
          ac.i("simple", "pack result ".concat(String.valueOf(SimpleHttpLogic.packRequest(localccd.toByteArray(), (PByteArray)localObject))));
        }
        catch (Exception localException1)
        {
          try
          {
            for (;;)
            {
              localRequest.body = ((PByteArray)localObject).value;
              SimpleHttpLogic.startRequest(localRequest, new a(), "101.227.131.113");
              AppMethodBeat.o(189686);
              return;
              localException1 = localException1;
              ac.e("simple", "pack failed " + localException1.getLocalizedMessage());
            }
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              ac.e("simple", localException2.getLocalizedMessage());
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
          AppMethodBeat.i(189685);
          ac.i("simple", "errorType: %d, errorCode:%d, result is %s , length %d ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramArrayOfByte, Integer.valueOf(paramArrayOfByte.length) });
          try
          {
            PByteArray localPByteArray = new PByteArray();
            boolean bool = SimpleHttpLogic.unpackResponse(paramArrayOfByte, localPByteArray);
            ac.e("simple", "unpack result ".concat(String.valueOf(bool)));
            if (bool)
            {
              paramArrayOfByte = new cce();
              paramArrayOfByte.parseFrom(localPByteArray.value);
              if ((paramArrayOfByte.BaseResponse != null) && (paramArrayOfByte.FqA != null) && (paramArrayOfByte.vyz != null))
              {
                ac.e("simple", "response is " + paramArrayOfByte.BaseResponse.Ret + " error msg " + paramArrayOfByte.BaseResponse.ErrMsg);
                ac.e("simple", "response base id is " + paramArrayOfByte.FqA + " error msg " + paramArrayOfByte.vyz);
              }
            }
            AppMethodBeat.o(189685);
            return;
          }
          catch (Exception paramArrayOfByte)
          {
            ac.e("simple", "unpack failed. " + paramArrayOfByte.getLocalizedMessage());
            AppMethodBeat.o(189685);
          }
        }
      }
    });
    AppMethodBeat.o(189687);
  }
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(117439);
    if (paramArrayOfString.length < 2)
    {
      ac.d("MicroMsg.Tinker.TinkerBootsCommand", "no args input.");
      AppMethodBeat.o(117439);
      return false;
    }
    paramContext = paramArrayOfString[1];
    int i;
    if (com.tencent.mm.sdk.a.b.eUk()) {
      i = -1;
    }
    switch (paramContext.hashCode())
    {
    default: 
      switch (i)
      {
      default: 
        label116:
        ac.d("MicroMsg.Tinker.TinkerBootsCommand", "%s i not a debugger command.", new Object[] { paramContext });
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
        ac.d("MicroMsg.Tinker.TinkerBootsCommand", "%s is not a release command.", new Object[] { paramContext });
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
        ac.d("MicroMsg.Tinker.TinkerBootsCommand", "command checkout update.");
        new LinkedList();
        paramContext = com.tencent.mm.plugin.hp.net.e.cTl();
        paramArrayOfString = new StringBuilder();
        paramString = paramContext.iterator();
        while (paramString.hasNext())
        {
          ccc localccc = (ccc)paramString.next();
          paramArrayOfString.append(localccc.key).append(":").append(localccc.value).append("\n");
        }
        ac.d("MicroMsg.Tinker.TinkerBootsCommand", "BaseID:%s PatchID:%s %s", new Object[] { "tinker_id_2468c5efe7670b901f7738f7a699d3843acc3651_arm64-v8a", "", paramArrayOfString.toString() });
        paramContext = new com.tencent.mm.plugin.hp.net.d("tinker_id_2468c5efe7670b901f7738f7a699d3843acc3651_arm64-v8a", "", paramContext);
        com.tencent.mm.kernel.g.agi().a(paramContext, 0);
        AppMethodBeat.o(117439);
        return true;
        i.a(ai.getContext().getString(2131759571), ai.getContext().getString(2131759571), ai.getContext().getString(2131760343), new g.1(this), ai.getContext().getString(2131764569), null);
        AppMethodBeat.o(117439);
        return true;
        com.tencent.mm.kernel.g.agU().az(new g.2(this, paramArrayOfString));
        AppMethodBeat.o(117439);
        return true;
        paramContext = new cch();
        paramContext.FqM = 1000;
        paramContext.FqJ = 2;
        paramContext.FqK = 2;
        paramContext.state = 2;
        paramContext.vyz = "android_tinker_id_123123131231231";
        paramArrayOfString = new cqg();
        paramArrayOfString.MD5 = "c3282ad2467fad9561227bc9b5b6712c";
        paramArrayOfString.FileSize = 118617;
        paramArrayOfString.Url = "http://dldir1.qq.com/weixin/checkresupdate/0x2605136d.3144f5.0x26051334.bf52fb_1510754399.apk";
        paramContext.FqJ = 3;
        paramArrayOfString.MD5 = "3ba62fdbd98df2bdf5da7d726010d867";
        paramArrayOfString.FileSize = 33338711;
        paramArrayOfString.Url = "http://dldir1.qq.com/weixin/checkresupdate/0x26051363.6cc887.0x26051087.a44d04_1510750804.apk";
        paramContext.FqL = paramArrayOfString;
        new e(new com.tencent.mm.plugin.hp.c.b(paramContext)).nd(false);
        AppMethodBeat.o(117439);
        return true;
        if (paramArrayOfString.length >= 6) {
          bs.aLz(paramArrayOfString[5]);
        }
        AppMethodBeat.o(117439);
        return true;
        com.tencent.mm.plugin.hp.tinker.h.aD(ai.getContext(), "");
        com.tencent.mm.plugin.hp.tinker.h.aG(ai.getContext(), "");
        com.tencent.mm.plugin.hp.tinker.h.Z(ai.getContext(), 0);
        ai.getContext();
        com.tencent.mm.plugin.hp.c.d.cTC();
        AppMethodBeat.o(117439);
        return true;
        paramContext = new cch();
        paramContext.FqM = 1000;
        paramContext.FqJ = 3;
        paramContext.FqK = 2;
        paramContext.state = 2;
        paramContext.vyz = "android_tinker_id_123123131231231";
        paramArrayOfString = new cqg();
        paramArrayOfString.MD5 = "3ba62fdbd98df2bdf5da7d726010d867";
        paramArrayOfString.FileSize = 33338711;
        paramArrayOfString.Url = "http://dldir1.qq.com/weixin/checkresupdate/0x26051363.6cc887.0x26051087.a44d04_1510750804.apk";
        paramContext.FqL = paramArrayOfString;
        paramArrayOfString = new ccf();
        paramArrayOfString.key = "clientVersion";
        paramArrayOfString.value = "0x26060510";
        paramContext.FqN.add(paramArrayOfString);
        paramArrayOfString = new ccf();
        paramArrayOfString.key = "alphaTitle";
        paramArrayOfString.value = "叫你更新你就更新";
        paramContext.FqN.add(paramArrayOfString);
        paramArrayOfString = new ccf();
        paramArrayOfString.key = "alphaContent";
        paramArrayOfString.value = "这个包可以抢到的红包最大，抢红包速度最快。";
        paramContext.FqN.add(paramArrayOfString);
        paramArrayOfString = new ccf();
        paramArrayOfString.key = "alphaUrl";
        paramArrayOfString.value = "www.qq.com";
        paramContext.FqN.add(paramArrayOfString);
        new e(new com.tencent.mm.plugin.hp.c.b(paramContext)).nd(true);
        AppMethodBeat.o(117439);
        return true;
        cTj();
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
      com.tinkerboots.sdk.a.fMx().zh(true);
      AppMethodBeat.o(117439);
      return true;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.Tinker.TinkerBootsCommand", paramContext, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.b.g
 * JD-Core Version:    0.7.0.1
 */