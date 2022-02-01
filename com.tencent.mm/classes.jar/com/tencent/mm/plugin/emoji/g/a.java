package com.tencent.mm.plugin.emoji.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.c;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cd.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager;
import com.tencent.mm.protocal.protobuf.agb;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.c;
import com.tencent.mm.storage.emotion.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public final class a
  implements cd.a
{
  private static void c(int paramInt, ArrayList<agb> paramArrayList)
  {
    AppMethodBeat.i(108730);
    paramArrayList = paramArrayList.iterator();
    if (paramArrayList.hasNext())
    {
      agb localagb = (agb)paramArrayList.next();
      EmojiInfo localEmojiInfo = bd.frc().ILn.aUK(localagb.Md5);
      if (localEmojiInfo == null)
      {
        localEmojiInfo = new EmojiInfo();
        com.tencent.mm.plugin.emoji.h.b.a(localagb, localEmojiInfo);
        if (paramInt == 1) {
          localEmojiInfo.field_groupId = "capture";
        }
        for (;;)
        {
          bd.frc().ILn.J(localEmojiInfo);
          break;
          localEmojiInfo.field_catalog = EmojiInfo.OeT;
        }
      }
      if (paramInt == 1) {
        localEmojiInfo.field_groupId = "capture";
      }
      for (;;)
      {
        bd.frc().ILn.K(localEmojiInfo);
        break;
        localEmojiInfo.field_catalog = EmojiInfo.OeT;
      }
    }
    AppMethodBeat.o(108730);
  }
  
  public final void a(e.a parama)
  {
    int i = 0;
    AppMethodBeat.i(108729);
    parama = parama.gqE;
    if (parama.ugm == 10002)
    {
      parama = z.a(parama.Fvk);
      if (bt.isNullOrNil(parama))
      {
        ad.w("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "msg content is null");
        AppMethodBeat.o(108729);
        return;
      }
      Object localObject2 = bw.M(parama, "sysmsg");
      if ((localObject2 != null) && (((Map)localObject2).size() > 0))
      {
        String str = (String)((Map)localObject2).get(".sysmsg.$type");
        if (bt.isNullOrNil(str))
        {
          ad.w("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "empty type");
          AppMethodBeat.o(108729);
          return;
        }
        Object localObject1 = bt.cE(com.tencent.mm.bx.b.cj(q.aay().getBytes()).Zz(16).zr);
        if (str.equalsIgnoreCase("EmojiBackup"))
        {
          i = bt.aRe((String)((Map)localObject2).get(".sysmsg.EmojiBackup.OpCode"));
          localObject2 = (String)((Map)localObject2).get(".sysmsg.EmojiBackup.DeviceID");
          ad.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "client devicesID:%s server devicesID:%s", new Object[] { localObject1, localObject2 });
          if ((!bt.isNullOrNil((String)localObject2)) && (((String)localObject2).equalsIgnoreCase((String)localObject1)))
          {
            ad.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "same devices operate ignore.");
            AppMethodBeat.o(108729);
            return;
          }
          localObject1 = b.abT(parama);
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
                localObject2 = (agb)((Iterator)localObject1).next();
                if (localObject2 != null) {
                  parama.add(((agb)localObject2).Md5);
                }
              }
            }
            k.getEmojiStorageMgr().ILn.hL(parama);
            g.ajC().ajl().set(al.a.Iqn, Boolean.FALSE);
            AppMethodBeat.o(108729);
            return;
          }
          if (i == 3)
          {
            ad.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "set batch emoji download time to 0. ");
            g.ajC().ajl().set(al.a.Iqv, Boolean.TRUE);
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
          parama = b.abU(parama);
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
              ((ArrayList)localObject1).add(new com.tencent.mm.plugin.emoji.sync.a.a((String)parama.get(i)));
              i += 1;
            }
            k.cgR().Q((ArrayList)localObject1);
            k.cgR().pGu.cho();
            AppMethodBeat.o(108729);
            return;
          }
          if (j == 2)
          {
            ad.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "try to sync emoji from newxml. delete buckupList:%d", new Object[] { Integer.valueOf(parama.size()) });
            k.getEmojiStorageMgr().ILo.aQ(parama);
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
          i = bt.aRe((String)((Map)localObject2).get(".sysmsg.SelfieEmojiBackup.OpCode"));
          localObject1 = b.abT(parama);
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
              localObject2 = (agb)((Iterator)localObject1).next();
              if (localObject2 != null) {
                parama.add(((agb)localObject2).Md5);
              }
            }
            k.getEmojiStorageMgr().ILn.hM(parama);
            g.ajC().ajl().set(al.a.Iqn, Boolean.FALSE);
            AppMethodBeat.o(108729);
            return;
          }
          if (i == 3)
          {
            ad.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "back up capture: move to top %s ", new Object[] { Integer.valueOf(((ArrayList)localObject1).size()) });
            g.ajC().ajl().set(al.a.Iqw, Boolean.TRUE);
          }
          AppMethodBeat.o(108729);
          return;
        }
        ad.e("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "not emoji message type :".concat(String.valueOf(str)));
      }
      AppMethodBeat.o(108729);
      return;
    }
    ad.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "not new xml type:%d ", new Object[] { Integer.valueOf(parama.ugm) });
    AppMethodBeat.o(108729);
  }
  
  public final void a(e.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.g.a
 * JD-Core Version:    0.7.0.1
 */