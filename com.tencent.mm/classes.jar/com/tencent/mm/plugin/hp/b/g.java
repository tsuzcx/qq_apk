package com.tencent.mm.plugin.hp.b;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.plugin.boots.a.c;
import com.tencent.mm.plugin.hp.d.d;
import com.tencent.mm.plugin.hp.tinker.h;
import com.tencent.mm.protocal.protobuf.bjt;
import com.tencent.mm.protocal.protobuf.bjw;
import com.tencent.mm.protocal.protobuf.bjy;
import com.tencent.mm.protocal.protobuf.bvg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g
  implements com.tencent.mm.pluginsdk.cmd.a
{
  private static void bIi()
  {
    AppMethodBeat.i(90612);
    Object localObject = ((c)com.tencent.mm.kernel.g.E(c.class)).aWg();
    if (!((List)localObject).isEmpty())
    {
      ab.e("MicroMsg.Tinker.TinkerBootsCommand", "start day active keys");
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.plugin.boots.a.a locala = (com.tencent.mm.plugin.boots.a.a)((Iterator)localObject).next();
        ab.i("MicroMsg.Tinker.TinkerBootsCommand", "key:%s active:%d", new Object[] { Integer.toHexString(locala.field_key), Integer.valueOf(locala.field_dau) });
      }
    }
    AppMethodBeat.o(90612);
  }
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(90611);
    if (paramArrayOfString.length < 2)
    {
      ab.d("MicroMsg.Tinker.TinkerBootsCommand", "no args input.");
      AppMethodBeat.o(90611);
      return false;
    }
    paramContext = paramArrayOfString[1];
    int i;
    if (com.tencent.mm.sdk.a.b.dsf())
    {
      i = -1;
      switch (paramContext.hashCode())
      {
      }
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        ab.d("MicroMsg.Tinker.TinkerBootsCommand", "%s is not a debugger command.", new Object[] { paramContext });
        i = -1;
        switch (paramContext.hashCode())
        {
        default: 
          switch (i)
          {
          default: 
            ab.d("MicroMsg.Tinker.TinkerBootsCommand", "%s is not a release command.", new Object[] { paramContext });
            AppMethodBeat.o(90611);
            return false;
            if (paramContext.equals("update"))
            {
              i = 0;
              continue;
              if (paramContext.equals("show"))
              {
                i = 1;
                continue;
                if (paramContext.equals("diff"))
                {
                  i = 2;
                  continue;
                  if (paramContext.equals("down"))
                  {
                    i = 3;
                    continue;
                    if (paramContext.equals("nd"))
                    {
                      i = 4;
                      continue;
                      if (paramContext.equals("clear"))
                      {
                        i = 5;
                        continue;
                        if (paramContext.equals("process"))
                        {
                          i = 6;
                          continue;
                          if (paramContext.equals("showall")) {
                            i = 7;
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
            break;
          }
          break;
        }
        break;
      }
    }
    ab.d("MicroMsg.Tinker.TinkerBootsCommand", "command checkout update.");
    LinkedList localLinkedList = new LinkedList();
    paramString = "";
    if (paramArrayOfString.length >= 3) {}
    for (paramContext = paramArrayOfString[2];; paramContext = "tinker_id_d1ddc930233f0ec33f573e365038b6d979b6ebde")
    {
      if (paramArrayOfString.length >= 4) {
        paramString = paramArrayOfString[3];
      }
      Object localObject;
      if (paramArrayOfString.length >= 5)
      {
        localObject = new bjt();
        ((bjt)localObject).key = "sdk";
        ((bjt)localObject).value = paramArrayOfString[4];
        localLinkedList.add(localObject);
      }
      for (;;)
      {
        paramArrayOfString = new StringBuilder();
        localObject = localLinkedList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          bjt localbjt = (bjt)((Iterator)localObject).next();
          paramArrayOfString.append(localbjt.key).append(":").append(localbjt.value).append("\n");
        }
        paramArrayOfString = new bjt();
        paramArrayOfString.key = "sdk";
        paramArrayOfString.value = String.valueOf(Build.VERSION.SDK_INT);
        localLinkedList.add(paramArrayOfString);
      }
      ab.d("MicroMsg.Tinker.TinkerBootsCommand", "BaseID:%s PatchID:%s %s", new Object[] { paramContext, paramString, paramArrayOfString.toString() });
      paramContext = new com.tencent.mm.plugin.hp.c.b(paramContext, paramString, localLinkedList);
      com.tencent.mm.kernel.g.Rc().a(paramContext, 0);
      AppMethodBeat.o(90611);
      return true;
      i.a(ah.getContext().getString(2131300104), ah.getContext().getString(2131300104), ah.getContext().getString(2131300742), new g.1(this), ah.getContext().getString(2131304423), null);
      AppMethodBeat.o(90611);
      return true;
      com.tencent.mm.kernel.g.RO().ac(new g.2(this, paramArrayOfString));
      AppMethodBeat.o(90611);
      return true;
      paramContext = new bjy();
      paramContext.xyt = 1000;
      paramContext.xyp = 2;
      paramContext.xyq = 2;
      paramContext.state = 2;
      paramContext.pqD = "android_tinker_id_123123131231231";
      paramArrayOfString = new bvg();
      paramArrayOfString.wQr = "c3282ad2467fad9561227bc9b5b6712c";
      paramArrayOfString.FileSize = 118617;
      paramArrayOfString.Url = "http://dldir1.qq.com/weixin/checkresupdate/0x2605136d.3144f5.0x26051334.bf52fb_1510754399.apk";
      paramContext.xyp = 3;
      paramArrayOfString.wQr = "3ba62fdbd98df2bdf5da7d726010d867";
      paramArrayOfString.FileSize = 33338711;
      paramArrayOfString.Url = "http://dldir1.qq.com/weixin/checkresupdate/0x26051363.6cc887.0x26051087.a44d04_1510750804.apk";
      paramContext.xyr = paramArrayOfString;
      new e(new com.tencent.mm.plugin.hp.d.b(paramContext)).iv(false);
      AppMethodBeat.o(90611);
      return true;
      if (paramArrayOfString.length >= 6) {
        bo.apW(paramArrayOfString[5]);
      }
      AppMethodBeat.o(90611);
      return true;
      h.aA(ah.getContext(), "");
      h.aB(ah.getContext(), "");
      h.Q(ah.getContext(), 0);
      ah.getContext();
      d.bIx();
      AppMethodBeat.o(90611);
      return true;
      paramContext = new bjy();
      paramContext.xyt = 1000;
      paramContext.xyp = 3;
      paramContext.xyq = 2;
      paramContext.state = 2;
      paramContext.pqD = "android_tinker_id_123123131231231";
      paramArrayOfString = new bvg();
      paramArrayOfString.wQr = "3ba62fdbd98df2bdf5da7d726010d867";
      paramArrayOfString.FileSize = 33338711;
      paramArrayOfString.Url = "http://dldir1.qq.com/weixin/checkresupdate/0x26051363.6cc887.0x26051087.a44d04_1510750804.apk";
      paramContext.xyr = paramArrayOfString;
      paramArrayOfString = new bjw();
      paramArrayOfString.key = "clientVersion";
      paramArrayOfString.value = "0x26060510";
      paramContext.xyu.add(paramArrayOfString);
      paramArrayOfString = new bjw();
      paramArrayOfString.key = "alphaTitle";
      paramArrayOfString.value = "叫你更新你就更新";
      paramContext.xyu.add(paramArrayOfString);
      paramArrayOfString = new bjw();
      paramArrayOfString.key = "alphaContent";
      paramArrayOfString.value = "这个包可以抢到的红包最大，抢红包速度最快。";
      paramContext.xyu.add(paramArrayOfString);
      paramArrayOfString = new bjw();
      paramArrayOfString.key = "alphaUrl";
      paramArrayOfString.value = "www.qq.com";
      paramContext.xyu.add(paramArrayOfString);
      new e(new com.tencent.mm.plugin.hp.d.b(paramContext)).iv(true);
      AppMethodBeat.o(90611);
      return true;
      bIi();
      AppMethodBeat.o(90611);
      return true;
      if (!paramContext.equals("check")) {
        break;
      }
      i = 0;
      break;
      try
      {
        com.tinkerboots.sdk.a.eaJ().sm(true);
        AppMethodBeat.o(90611);
        return true;
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.Tinker.TinkerBootsCommand", paramContext, "", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.b.g
 * JD-Core Version:    0.7.0.1
 */