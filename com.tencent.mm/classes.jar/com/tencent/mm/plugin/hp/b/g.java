package com.tencent.mm.plugin.hp.b;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.protocal.c.blu;
import com.tencent.mm.protocal.c.bxr;
import com.tencent.mm.protocal.c.bxt;
import com.tencent.mm.protocal.c.bxv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;

public final class g
  implements com.tencent.mm.pluginsdk.cmd.a
{
  public final boolean a(Context paramContext, String[] paramArrayOfString)
  {
    if (paramArrayOfString.length < 2)
    {
      y.d("MicroMsg.Tinker.TinkerBootsCommand", "no args input.");
      return false;
    }
    paramContext = paramArrayOfString[1];
    int i;
    if (com.tencent.mm.sdk.a.b.cqk())
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
        y.d("MicroMsg.Tinker.TinkerBootsCommand", "%s is not a debugger command.", new Object[] { paramContext });
        i = -1;
        switch (paramContext.hashCode())
        {
        default: 
          switch (i)
          {
          default: 
            y.d("MicroMsg.Tinker.TinkerBootsCommand", "%s is not a release command.", new Object[] { paramContext });
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
                        if (paramContext.equals("process")) {
                          i = 6;
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
    y.d("MicroMsg.Tinker.TinkerBootsCommand", "command checkout update.");
    LinkedList localLinkedList = new LinkedList();
    String str = "";
    if (paramArrayOfString.length >= 3) {}
    for (paramContext = paramArrayOfString[2];; paramContext = "tinker_id_d1ddc930233f0ec33f573e365038b6d979b6ebde")
    {
      if (paramArrayOfString.length >= 4) {
        str = paramArrayOfString[3];
      }
      Object localObject;
      if (paramArrayOfString.length >= 5)
      {
        localObject = new bxr();
        ((bxr)localObject).key = "sdk";
        ((bxr)localObject).value = paramArrayOfString[4];
        localLinkedList.add(localObject);
      }
      for (;;)
      {
        paramArrayOfString = new StringBuilder();
        localObject = localLinkedList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          bxr localbxr = (bxr)((Iterator)localObject).next();
          paramArrayOfString.append(localbxr.key).append(":").append(localbxr.value).append("\n");
        }
        paramArrayOfString = new bxr();
        paramArrayOfString.key = "sdk";
        paramArrayOfString.value = String.valueOf(Build.VERSION.SDK_INT);
        localLinkedList.add(paramArrayOfString);
      }
      y.d("MicroMsg.Tinker.TinkerBootsCommand", "BaseID:%s PatchID:%s %s", new Object[] { paramContext, str, paramArrayOfString.toString() });
      paramContext = new com.tencent.mm.plugin.hp.c.a(paramContext, str, localLinkedList);
      au.Dk().a(paramContext, 0);
      return true;
      i.a(ae.getContext().getString(R.l.fmt_update), ae.getContext().getString(R.l.fmt_update), ae.getContext().getString(R.l.install_now), new g.1(this), ae.getContext().getString(R.l.update_cancel), null);
      return true;
      au.DS().O(new g.2(this, paramArrayOfString));
      return true;
      paramContext = new bxv();
      paramContext.tNR = 1000;
      paramContext.tNO = 2;
      paramContext.tNP = 2;
      paramContext.state = 2;
      paramContext.sNz = "android_tinker_id_123123131231231";
      paramArrayOfString = new blu();
      paramArrayOfString.sRE = "c3282ad2467fad9561227bc9b5b6712c";
      paramArrayOfString.ndo = 118617;
      paramArrayOfString.kSC = "http://dldir1.qq.com/weixin/checkresupdate/0x2605136d.3144f5.0x26051334.bf52fb_1510754399.apk";
      paramContext.tNO = 3;
      paramArrayOfString.sRE = "3ba62fdbd98df2bdf5da7d726010d867";
      paramArrayOfString.ndo = 33338711;
      paramArrayOfString.kSC = "http://dldir1.qq.com/weixin/checkresupdate/0x26051363.6cc887.0x26051087.a44d04_1510750804.apk";
      paramContext.tNQ = paramArrayOfString;
      new e(new com.tencent.mm.plugin.hp.d.b(paramContext)).gN(false);
      return true;
      if (paramArrayOfString.length >= 6) {
        bk.ZS(paramArrayOfString[5]);
      }
      return true;
      com.tencent.mm.plugin.hp.tinker.g.as(ae.getContext(), "");
      com.tencent.mm.plugin.hp.tinker.g.at(ae.getContext(), "");
      com.tencent.mm.plugin.hp.tinker.g.E(ae.getContext(), 0);
      com.tencent.mm.pluginsdk.f.i.clp();
      return true;
      paramContext = new bxv();
      paramContext.tNR = 1000;
      paramContext.tNO = 3;
      paramContext.tNP = 2;
      paramContext.state = 2;
      paramContext.sNz = "android_tinker_id_123123131231231";
      paramArrayOfString = new blu();
      paramArrayOfString.sRE = "3ba62fdbd98df2bdf5da7d726010d867";
      paramArrayOfString.ndo = 33338711;
      paramArrayOfString.kSC = "http://dldir1.qq.com/weixin/checkresupdate/0x26051363.6cc887.0x26051087.a44d04_1510750804.apk";
      paramContext.tNQ = paramArrayOfString;
      paramArrayOfString = new bxt();
      paramArrayOfString.key = "clientVersion";
      paramArrayOfString.value = "0x26060510";
      paramContext.tNS.add(paramArrayOfString);
      paramArrayOfString = new bxt();
      paramArrayOfString.key = "alphaTitle";
      paramArrayOfString.value = "叫你更新你就更新";
      paramContext.tNS.add(paramArrayOfString);
      paramArrayOfString = new bxt();
      paramArrayOfString.key = "alphaContent";
      paramArrayOfString.value = "这个包可以抢到的红包最大，抢红包速度最快。";
      paramContext.tNS.add(paramArrayOfString);
      paramArrayOfString = new bxt();
      paramArrayOfString.key = "alphaUrl";
      paramArrayOfString.value = "www.qq.com";
      paramContext.tNS.add(paramArrayOfString);
      new e(new com.tencent.mm.plugin.hp.d.b(paramContext)).gN(true);
      return true;
      if (!paramContext.equals("check")) {
        break;
      }
      i = 0;
      break;
      try
      {
        com.tinkerboots.sdk.a.cTY().oy(true);
        return true;
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.Tinker.TinkerBootsCommand", paramContext, "", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.b.g
 * JD-Core Version:    0.7.0.1
 */