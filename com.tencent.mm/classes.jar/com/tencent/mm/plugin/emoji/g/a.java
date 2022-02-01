package com.tencent.mm.plugin.emoji.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.c;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager;
import com.tencent.mm.protocal.protobuf.ads;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.c;
import com.tencent.mm.storage.emotion.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public final class a
  implements cc.a
{
  private static void c(int paramInt, ArrayList<ads> paramArrayList)
  {
    AppMethodBeat.i(108730);
    paramArrayList = paramArrayList.iterator();
    if (paramArrayList.hasNext())
    {
      ads localads = (ads)paramArrayList.next();
      EmojiInfo localEmojiInfo = az.faZ().GXZ.aOT(localads.Md5);
      if (localEmojiInfo == null)
      {
        localEmojiInfo = new EmojiInfo();
        com.tencent.mm.plugin.emoji.h.b.a(localads, localEmojiInfo);
        if (paramInt == 1) {
          localEmojiInfo.field_groupId = "capture";
        }
        for (;;)
        {
          az.faZ().GXZ.K(localEmojiInfo);
          break;
          localEmojiInfo.field_catalog = EmojiInfo.Jsy;
        }
      }
      if (paramInt == 1) {
        localEmojiInfo.field_groupId = "capture";
      }
      for (;;)
      {
        az.faZ().GXZ.L(localEmojiInfo);
        break;
        localEmojiInfo.field_catalog = EmojiInfo.Jsy;
      }
    }
    AppMethodBeat.o(108730);
  }
  
  public final void a(f.a parama)
  {
    int i = 0;
    AppMethodBeat.i(108729);
    parama = parama.fXi;
    if (parama.tit == 10002)
    {
      parama = z.a(parama.DPV);
      if (bs.isNullOrNil(parama))
      {
        ac.w("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "msg content is null");
        AppMethodBeat.o(108729);
        return;
      }
      Object localObject2 = bv.L(parama, "sysmsg");
      if ((localObject2 != null) && (((Map)localObject2).size() > 0))
      {
        String str = (String)((Map)localObject2).get(".sysmsg.$type");
        if (bs.isNullOrNil(str))
        {
          ac.w("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "empty type");
          AppMethodBeat.o(108729);
          return;
        }
        Object localObject1 = bs.cx(com.tencent.mm.bw.b.cc(q.XX().getBytes()).XD(16).xy);
        if (str.equalsIgnoreCase("EmojiBackup"))
        {
          i = bs.aLy((String)((Map)localObject2).get(".sysmsg.EmojiBackup.OpCode"));
          localObject2 = (String)((Map)localObject2).get(".sysmsg.EmojiBackup.DeviceID");
          ac.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "client devicesID:%s server devicesID:%s", new Object[] { localObject1, localObject2 });
          if ((!bs.isNullOrNil((String)localObject2)) && (((String)localObject2).equalsIgnoreCase((String)localObject1)))
          {
            ac.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "same devices operate ignore.");
            AppMethodBeat.o(108729);
            return;
          }
          localObject1 = b.Yn(parama);
          if (i == 1)
          {
            if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0))
            {
              ac.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "xml syn list is null.");
              AppMethodBeat.o(108729);
              return;
            }
            ac.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "try to sync emoji from newxml. buckupList:%d", new Object[] { Integer.valueOf(((ArrayList)localObject1).size()) });
            c(0, (ArrayList)localObject1);
            AppMethodBeat.o(108729);
            return;
          }
          if (i == 2)
          {
            if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0))
            {
              ac.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "xml syn list is null.");
              AppMethodBeat.o(108729);
              return;
            }
            parama = new ArrayList();
            if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
            {
              localObject1 = ((ArrayList)localObject1).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject2 = (ads)((Iterator)localObject1).next();
                if (localObject2 != null) {
                  parama.add(((ads)localObject2).Md5);
                }
              }
            }
            k.getEmojiStorageMgr().GXZ.hz(parama);
            g.agR().agA().set(ah.a.GDU, Boolean.FALSE);
            AppMethodBeat.o(108729);
            return;
          }
          if (i == 3)
          {
            ac.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "set batch emoji download time to 0. ");
            g.agR().agA().set(ah.a.GEc, Boolean.TRUE);
          }
          AppMethodBeat.o(108729);
          return;
        }
        if (str.equalsIgnoreCase("EmotionBackup"))
        {
          int j = bs.getInt((String)((Map)localObject2).get(".sysmsg.EmotionBackup.OpCode"), 0);
          localObject2 = (String)((Map)localObject2).get(".sysmsg.EmotionBackup.DeviceID");
          if ((!bs.isNullOrNil((String)localObject2)) && (((String)localObject2).equalsIgnoreCase((String)localObject1)))
          {
            ac.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "same devices operate ignore.");
            AppMethodBeat.o(108729);
            return;
          }
          parama = b.Yo(parama);
          if ((parama == null) || (parama.size() <= 0))
          {
            ac.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "xml syn list is null.");
            AppMethodBeat.o(108729);
            return;
          }
          if (j == 1)
          {
            ac.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "try to sync emoji from newxml. add buckupList:%d", new Object[] { Integer.valueOf(parama.size()) });
            localObject1 = new ArrayList();
            j = parama.size();
            while (i < j)
            {
              ((ArrayList)localObject1).add(new com.tencent.mm.plugin.emoji.sync.a.b((String)parama.get(i)));
              i += 1;
            }
            k.ccn().Q((ArrayList)localObject1);
            k.ccn().pcK.ccK();
            AppMethodBeat.o(108729);
            return;
          }
          if (j == 2)
          {
            ac.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "try to sync emoji from newxml. delete buckupList:%d", new Object[] { Integer.valueOf(parama.size()) });
            k.getEmojiStorageMgr().GYa.aT(parama);
          }
          AppMethodBeat.o(108729);
          return;
        }
        if (str.equalsIgnoreCase("SelfieEmojiBackup"))
        {
          str = (String)((Map)localObject2).get(".sysmsg.SelfieEmojiBackup.DeviceID");
          ac.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "back up capture client devicesID:%s server devicesID:%s", new Object[] { localObject1, str });
          if ((!bs.isNullOrNil(str)) && (str.equalsIgnoreCase((String)localObject1)))
          {
            ac.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "same devices operate ignore.");
            AppMethodBeat.o(108729);
            return;
          }
          i = bs.aLy((String)((Map)localObject2).get(".sysmsg.SelfieEmojiBackup.OpCode"));
          localObject1 = b.Yn(parama);
          if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0))
          {
            ac.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "back up capture: empty list opCode %s", new Object[] { Integer.valueOf(i) });
            AppMethodBeat.o(108729);
            return;
          }
          ac.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "back up capture: opCode %s, size %s", new Object[] { Integer.valueOf(i), Integer.valueOf(((ArrayList)localObject1).size()) });
          if (i == 1)
          {
            ac.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "back up capture: add capture %s", new Object[] { Integer.valueOf(((ArrayList)localObject1).size()) });
            c(1, (ArrayList)localObject1);
            AppMethodBeat.o(108729);
            return;
          }
          if (i == 2)
          {
            ac.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "back up capture: delete capture %s", new Object[] { Integer.valueOf(((ArrayList)localObject1).size()) });
            parama = new ArrayList();
            localObject1 = ((ArrayList)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (ads)((Iterator)localObject1).next();
              if (localObject2 != null) {
                parama.add(((ads)localObject2).Md5);
              }
            }
            k.getEmojiStorageMgr().GXZ.hA(parama);
            g.agR().agA().set(ah.a.GDU, Boolean.FALSE);
            AppMethodBeat.o(108729);
            return;
          }
          if (i == 3)
          {
            ac.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "back up capture: move to top %s ", new Object[] { Integer.valueOf(((ArrayList)localObject1).size()) });
            g.agR().agA().set(ah.a.GEd, Boolean.TRUE);
          }
          AppMethodBeat.o(108729);
          return;
        }
        ac.e("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "not emoji message type :".concat(String.valueOf(str)));
      }
      AppMethodBeat.o(108729);
      return;
    }
    ac.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "not new xml type:%d ", new Object[] { Integer.valueOf(parama.tit) });
    AppMethodBeat.o(108729);
  }
  
  public final void a(f.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.g.a
 * JD-Core Version:    0.7.0.1
 */