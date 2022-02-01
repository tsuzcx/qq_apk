package com.tencent.mm.plugin.emoji.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.a;
import com.tencent.mm.al.f.c;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager;
import com.tencent.mm.protocal.protobuf.act;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.c;
import com.tencent.mm.storage.emotion.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public final class a
  implements cc.a
{
  private static void c(int paramInt, ArrayList<act> paramArrayList)
  {
    AppMethodBeat.i(108730);
    paramArrayList = paramArrayList.iterator();
    if (paramArrayList.hasNext())
    {
      act localact = (act)paramArrayList.next();
      EmojiInfo localEmojiInfo = aw.eLx().FyY.aJx(localact.Md5);
      if (localEmojiInfo == null)
      {
        localEmojiInfo = new EmojiInfo();
        com.tencent.mm.plugin.emoji.h.b.a(localact, localEmojiInfo);
        if (paramInt == 1) {
          localEmojiInfo.field_groupId = "capture";
        }
        for (;;)
        {
          aw.eLx().FyY.K(localEmojiInfo);
          break;
          localEmojiInfo.field_catalog = EmojiInfo.LBW;
        }
      }
      if (paramInt == 1) {
        localEmojiInfo.field_groupId = "capture";
      }
      for (;;)
      {
        aw.eLx().FyY.L(localEmojiInfo);
        break;
        localEmojiInfo.field_catalog = EmojiInfo.LBW;
      }
    }
    AppMethodBeat.o(108730);
  }
  
  public final void a(f.a parama)
  {
    int i = 0;
    AppMethodBeat.i(108729);
    parama = parama.fTo;
    if (parama.saz == 10002)
    {
      parama = z.a(parama.Cxz);
      if (bt.isNullOrNil(parama))
      {
        ad.w("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "msg content is null");
        AppMethodBeat.o(108729);
        return;
      }
      Object localObject2 = bw.K(parama, "sysmsg");
      if ((localObject2 != null) && (((Map)localObject2).size() > 0))
      {
        String str = (String)((Map)localObject2).get(".sysmsg.$type");
        if (bt.isNullOrNil(str))
        {
          ad.w("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "empty type");
          AppMethodBeat.o(108729);
          return;
        }
        Object localObject1 = bt.cy(com.tencent.mm.bx.b.cd(q.Xa().getBytes()).Vu(16).wA);
        if (str.equalsIgnoreCase("EmojiBackup"))
        {
          i = bt.aGh((String)((Map)localObject2).get(".sysmsg.EmojiBackup.OpCode"));
          localObject2 = (String)((Map)localObject2).get(".sysmsg.EmojiBackup.DeviceID");
          ad.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "client devicesID:%s server devicesID:%s", new Object[] { localObject1, localObject2 });
          if ((!bt.isNullOrNil((String)localObject2)) && (((String)localObject2).equalsIgnoreCase((String)localObject1)))
          {
            ad.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "same devices operate ignore.");
            AppMethodBeat.o(108729);
            return;
          }
          localObject1 = b.Ub(parama);
          if (i == 1)
          {
            if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0))
            {
              ad.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "xml syn list is null.");
              AppMethodBeat.o(108729);
              return;
            }
            ad.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "try to sync emoji from newxml. buckupList:%d", new Object[] { Integer.valueOf(((ArrayList)localObject1).size()) });
            c(0, (ArrayList)localObject1);
            AppMethodBeat.o(108729);
            return;
          }
          if (i == 2)
          {
            if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0))
            {
              ad.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "xml syn list is null.");
              AppMethodBeat.o(108729);
              return;
            }
            parama = new ArrayList();
            if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
            {
              localObject1 = ((ArrayList)localObject1).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject2 = (act)((Iterator)localObject1).next();
                if (localObject2 != null) {
                  parama.add(((act)localObject2).Md5);
                }
              }
            }
            k.getEmojiStorageMgr().FyY.hm(parama);
            g.afB().afk().set(ae.a.Fgg, Boolean.FALSE);
            AppMethodBeat.o(108729);
            return;
          }
          if (i == 3)
          {
            ad.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "set batch emoji download time to 0. ");
            g.afB().afk().set(ae.a.Fgo, Boolean.TRUE);
          }
          AppMethodBeat.o(108729);
          return;
        }
        if (str.equalsIgnoreCase("EmotionBackup"))
        {
          int j = bt.getInt((String)((Map)localObject2).get(".sysmsg.EmotionBackup.OpCode"), 0);
          localObject2 = (String)((Map)localObject2).get(".sysmsg.EmotionBackup.DeviceID");
          if ((!bt.isNullOrNil((String)localObject2)) && (((String)localObject2).equalsIgnoreCase((String)localObject1)))
          {
            ad.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "same devices operate ignore.");
            AppMethodBeat.o(108729);
            return;
          }
          parama = b.Uc(parama);
          if ((parama == null) || (parama.size() <= 0))
          {
            ad.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "xml syn list is null.");
            AppMethodBeat.o(108729);
            return;
          }
          if (j == 1)
          {
            ad.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "try to sync emoji from newxml. add buckupList:%d", new Object[] { Integer.valueOf(parama.size()) });
            localObject1 = new ArrayList();
            j = parama.size();
            while (i < j)
            {
              ((ArrayList)localObject1).add(new com.tencent.mm.plugin.emoji.sync.a.b((String)parama.get(i)));
              i += 1;
            }
            k.bVa().L((ArrayList)localObject1);
            k.bVa().ozk.bVx();
            AppMethodBeat.o(108729);
            return;
          }
          if (j == 2)
          {
            ad.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "try to sync emoji from newxml. delete buckupList:%d", new Object[] { Integer.valueOf(parama.size()) });
            k.getEmojiStorageMgr().FyZ.aH(parama);
          }
          AppMethodBeat.o(108729);
          return;
        }
        if (str.equalsIgnoreCase("SelfieEmojiBackup"))
        {
          str = (String)((Map)localObject2).get(".sysmsg.SelfieEmojiBackup.DeviceID");
          ad.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "back up capture client devicesID:%s server devicesID:%s", new Object[] { localObject1, str });
          if ((!bt.isNullOrNil(str)) && (str.equalsIgnoreCase((String)localObject1)))
          {
            ad.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "same devices operate ignore.");
            AppMethodBeat.o(108729);
            return;
          }
          i = bt.aGh((String)((Map)localObject2).get(".sysmsg.SelfieEmojiBackup.OpCode"));
          localObject1 = b.Ub(parama);
          if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0))
          {
            ad.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "back up capture: empty list opCode %s", new Object[] { Integer.valueOf(i) });
            AppMethodBeat.o(108729);
            return;
          }
          ad.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "back up capture: opCode %s, size %s", new Object[] { Integer.valueOf(i), Integer.valueOf(((ArrayList)localObject1).size()) });
          if (i == 1)
          {
            ad.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "back up capture: add capture %s", new Object[] { Integer.valueOf(((ArrayList)localObject1).size()) });
            c(1, (ArrayList)localObject1);
            AppMethodBeat.o(108729);
            return;
          }
          if (i == 2)
          {
            ad.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "back up capture: delete capture %s", new Object[] { Integer.valueOf(((ArrayList)localObject1).size()) });
            parama = new ArrayList();
            localObject1 = ((ArrayList)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (act)((Iterator)localObject1).next();
              if (localObject2 != null) {
                parama.add(((act)localObject2).Md5);
              }
            }
            k.getEmojiStorageMgr().FyY.hn(parama);
            g.afB().afk().set(ae.a.Fgg, Boolean.FALSE);
            AppMethodBeat.o(108729);
            return;
          }
          if (i == 3)
          {
            ad.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "back up capture: move to top %s ", new Object[] { Integer.valueOf(((ArrayList)localObject1).size()) });
            g.afB().afk().set(ae.a.Fgp, Boolean.TRUE);
          }
          AppMethodBeat.o(108729);
          return;
        }
        ad.e("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "not emoji message type :".concat(String.valueOf(str)));
      }
      AppMethodBeat.o(108729);
      return;
    }
    ad.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "not new xml type:%d ", new Object[] { Integer.valueOf(parama.saz) });
    AppMethodBeat.o(108729);
  }
  
  public final void a(f.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.g.a
 * JD-Core Version:    0.7.0.1
 */