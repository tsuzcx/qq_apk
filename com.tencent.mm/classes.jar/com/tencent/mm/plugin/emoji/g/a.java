package com.tencent.mm.plugin.emoji.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.protocal.protobuf.zg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.d;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public final class a
  implements bz.a
{
  private static void c(int paramInt, ArrayList<zg> paramArrayList)
  {
    AppMethodBeat.i(53157);
    paramArrayList = paramArrayList.iterator();
    if (paramArrayList.hasNext())
    {
      zg localzg = (zg)paramArrayList.next();
      EmojiInfo localEmojiInfo = at.dxt().yNn.asP(localzg.Md5);
      if (localEmojiInfo == null)
      {
        localEmojiInfo = new EmojiInfo();
        com.tencent.mm.plugin.emoji.h.b.a(localzg, localEmojiInfo);
        if (paramInt == 1) {
          localEmojiInfo.field_groupId = "capture";
        }
        for (;;)
        {
          at.dxt().yNn.I(localEmojiInfo);
          break;
          localEmojiInfo.field_catalog = EmojiInfo.yPm;
        }
      }
      if (paramInt == 1) {
        localEmojiInfo.field_groupId = "capture";
      }
      for (;;)
      {
        at.dxt().yNn.J(localEmojiInfo);
        break;
        localEmojiInfo.field_catalog = EmojiInfo.yPm;
      }
    }
    AppMethodBeat.o(53157);
  }
  
  public final void a(e.a parama)
  {
    int i = 0;
    AppMethodBeat.i(53156);
    parama = parama.eyJ;
    if (parama.nqW == 10002)
    {
      parama = aa.a(parama.woR);
      if (bo.isNullOrNil(parama))
      {
        ab.w("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "msg content is null");
        AppMethodBeat.o(53156);
        return;
      }
      Object localObject2 = br.F(parama, "sysmsg");
      if ((localObject2 != null) && (((Map)localObject2).size() > 0))
      {
        String str = (String)((Map)localObject2).get(".sysmsg.$type");
        if (bo.isNullOrNil(str))
        {
          ab.w("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "empty type");
          AppMethodBeat.o(53156);
          return;
        }
        Object localObject1 = bo.cg(com.tencent.mm.bv.b.bL(q.LK().getBytes()).Mz(16).pW);
        if (str.equalsIgnoreCase("EmojiBackup"))
        {
          i = bo.apV((String)((Map)localObject2).get(".sysmsg.EmojiBackup.OpCode"));
          localObject2 = (String)((Map)localObject2).get(".sysmsg.EmojiBackup.DeviceID");
          ab.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "client devicesID:%s server devicesID:%s", new Object[] { localObject1, localObject2 });
          if ((!bo.isNullOrNil((String)localObject2)) && (((String)localObject2).equalsIgnoreCase((String)localObject1)))
          {
            ab.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "same devices operate ignore.");
            AppMethodBeat.o(53156);
            return;
          }
          localObject1 = b.KU(parama);
          if (i == 1)
          {
            if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0))
            {
              ab.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "xml syn list is null.");
              AppMethodBeat.o(53156);
              return;
            }
            ab.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "try to sync emoji from newxml. buckupList:%d", new Object[] { Integer.valueOf(((ArrayList)localObject1).size()) });
            c(0, (ArrayList)localObject1);
            AppMethodBeat.o(53156);
            return;
          }
          if (i == 2)
          {
            if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0))
            {
              ab.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "xml syn list is null.");
              AppMethodBeat.o(53156);
              return;
            }
            parama = new ArrayList();
            if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
            {
              localObject1 = ((ArrayList)localObject1).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject2 = (zg)((Iterator)localObject1).next();
                if (localObject2 != null) {
                  parama.add(((zg)localObject2).Md5);
                }
              }
            }
            i.getEmojiStorageMgr().yNn.eR(parama);
            g.RL().Ru().set(ac.a.yxM, Boolean.FALSE);
            AppMethodBeat.o(53156);
            return;
          }
          if (i == 3)
          {
            ab.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "set batch emoji download time to 0. ");
            g.RL().Ru().set(ac.a.yxU, Boolean.TRUE);
          }
          AppMethodBeat.o(53156);
          return;
        }
        if (str.equalsIgnoreCase("EmotionBackup"))
        {
          int j = Integer.valueOf((String)((Map)localObject2).get(".sysmsg.EmotionBackup.OpCode")).intValue();
          localObject2 = (String)((Map)localObject2).get(".sysmsg.EmotionBackup.DeviceID");
          if ((!bo.isNullOrNil((String)localObject2)) && (((String)localObject2).equalsIgnoreCase((String)localObject1)))
          {
            ab.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "same devices operate ignore.");
            AppMethodBeat.o(53156);
            return;
          }
          parama = b.KV(parama);
          if ((parama == null) || (parama.size() <= 0))
          {
            ab.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "xml syn list is null.");
            AppMethodBeat.o(53156);
            return;
          }
          if (j == 1)
          {
            ab.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "try to sync emoji from newxml. add buckupList:%d", new Object[] { Integer.valueOf(parama.size()) });
            localObject1 = new ArrayList();
            j = parama.size();
            while (i < j)
            {
              ((ArrayList)localObject1).add(new com.tencent.mm.plugin.emoji.sync.a.b((String)parama.get(i)));
              i += 1;
            }
            i.blq().z((ArrayList)localObject1);
            i.blq().lje.blM();
            AppMethodBeat.o(53156);
            return;
          }
          if (j == 2)
          {
            ab.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "try to sync emoji from newxml. delete buckupList:%d", new Object[] { Integer.valueOf(parama.size()) });
            i.getEmojiStorageMgr().yNo.ak(parama);
          }
          AppMethodBeat.o(53156);
          return;
        }
        if (str.equalsIgnoreCase("SelfieEmojiBackup"))
        {
          str = (String)((Map)localObject2).get(".sysmsg.SelfieEmojiBackup.DeviceID");
          ab.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "back up capture client devicesID:%s server devicesID:%s", new Object[] { localObject1, str });
          if ((!bo.isNullOrNil(str)) && (str.equalsIgnoreCase((String)localObject1)))
          {
            ab.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "same devices operate ignore.");
            AppMethodBeat.o(53156);
            return;
          }
          i = bo.apV((String)((Map)localObject2).get(".sysmsg.SelfieEmojiBackup.OpCode"));
          localObject1 = b.KU(parama);
          if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0))
          {
            ab.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "back up capture: empty list opCode %s", new Object[] { Integer.valueOf(i) });
            AppMethodBeat.o(53156);
            return;
          }
          ab.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "back up capture: opCode %s, size %s", new Object[] { Integer.valueOf(i), Integer.valueOf(((ArrayList)localObject1).size()) });
          if (i == 1)
          {
            ab.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "back up capture: add capture %s", new Object[] { Integer.valueOf(((ArrayList)localObject1).size()) });
            c(1, (ArrayList)localObject1);
            AppMethodBeat.o(53156);
            return;
          }
          if (i == 2)
          {
            ab.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "back up capture: delete capture %s", new Object[] { Integer.valueOf(((ArrayList)localObject1).size()) });
            parama = new ArrayList();
            localObject1 = ((ArrayList)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (zg)((Iterator)localObject1).next();
              if (localObject2 != null) {
                parama.add(((zg)localObject2).Md5);
              }
            }
            i.getEmojiStorageMgr().yNn.eS(parama);
            g.RL().Ru().set(ac.a.yxM, Boolean.FALSE);
            AppMethodBeat.o(53156);
            return;
          }
          if (i == 3)
          {
            ab.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "back up capture: move to top %s ", new Object[] { Integer.valueOf(((ArrayList)localObject1).size()) });
            g.RL().Ru().set(ac.a.yxV, Boolean.TRUE);
          }
          AppMethodBeat.o(53156);
          return;
        }
        ab.e("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "not emoji message type :".concat(String.valueOf(str)));
      }
      AppMethodBeat.o(53156);
      return;
    }
    ab.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "not new xml type:%d ", new Object[] { Integer.valueOf(parama.nqW) });
    AppMethodBeat.o(53156);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.g.a
 * JD-Core Version:    0.7.0.1
 */