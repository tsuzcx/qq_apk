package com.tencent.mm.plugin.emoji.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.c;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cj.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager;
import com.tencent.mm.protocal.protobuf.ait;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.c;
import com.tencent.mm.storage.emotion.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public final class a
  implements cj.a
{
  private static void c(int paramInt, ArrayList<ait> paramArrayList)
  {
    AppMethodBeat.i(108730);
    paramArrayList = paramArrayList.iterator();
    if (paramArrayList.hasNext())
    {
      ait localait = (ait)paramArrayList.next();
      EmojiInfo localEmojiInfo = bj.gCJ().OpN.blk(localait.Md5);
      if (localEmojiInfo == null)
      {
        localEmojiInfo = new EmojiInfo();
        com.tencent.mm.plugin.emoji.h.b.a(localait, localEmojiInfo);
        if (paramInt == 1) {
          localEmojiInfo.field_groupId = "capture";
        }
        for (;;)
        {
          bj.gCJ().OpN.K(localEmojiInfo);
          break;
          localEmojiInfo.field_catalog = EmojiInfo.Uuv;
        }
      }
      if (paramInt == 1) {
        localEmojiInfo.field_groupId = "capture";
      }
      for (;;)
      {
        bj.gCJ().OpN.L(localEmojiInfo);
        break;
        localEmojiInfo.field_catalog = EmojiInfo.Uuv;
      }
    }
    AppMethodBeat.o(108730);
  }
  
  public final void a(h.a parama)
  {
    int i = 0;
    AppMethodBeat.i(108729);
    parama = parama.heO;
    if (parama.xKb == 10002)
    {
      parama = z.a(parama.KHn);
      if (Util.isNullOrNil(parama))
      {
        Log.w("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "msg content is null");
        AppMethodBeat.o(108729);
        return;
      }
      Object localObject2 = XmlParser.parseXml(parama, "sysmsg", null);
      if ((localObject2 != null) && (((Map)localObject2).size() > 0))
      {
        String str = (String)((Map)localObject2).get(".sysmsg.$type");
        if (Util.isNullOrNil(str))
        {
          Log.w("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "empty type");
          AppMethodBeat.o(108729);
          return;
        }
        Object localObject1 = Util.encodeHexString(com.tencent.mm.bw.b.cD(q.aoG().getBytes()).aiU(16).zy);
        if (str.equalsIgnoreCase("EmojiBackup"))
        {
          i = Util.safeParseInt((String)((Map)localObject2).get(".sysmsg.EmojiBackup.OpCode"));
          localObject2 = (String)((Map)localObject2).get(".sysmsg.EmojiBackup.DeviceID");
          Log.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "client devicesID:%s server devicesID:%s", new Object[] { localObject1, localObject2 });
          if ((!Util.isNullOrNil((String)localObject2)) && (((String)localObject2).equalsIgnoreCase((String)localObject1)))
          {
            Log.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "same devices operate ignore.");
            AppMethodBeat.o(108729);
            return;
          }
          localObject1 = b.amR(parama);
          if (i == 1)
          {
            if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0))
            {
              Log.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "xml syn list is null.");
              AppMethodBeat.o(108729);
              return;
            }
            Log.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "try to sync emoji from newxml. buckupList:%d", new Object[] { Integer.valueOf(((ArrayList)localObject1).size()) });
            c(0, (ArrayList)localObject1);
            AppMethodBeat.o(108729);
            return;
          }
          if (i == 2)
          {
            if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0))
            {
              Log.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "xml syn list is null.");
              AppMethodBeat.o(108729);
              return;
            }
            parama = new ArrayList();
            if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
            {
              localObject1 = ((ArrayList)localObject1).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject2 = (ait)((Iterator)localObject1).next();
                if (localObject2 != null) {
                  parama.add(((ait)localObject2).Md5);
                }
              }
            }
            k.getEmojiStorageMgr().OpN.iZ(parama);
            g.aAh().azQ().set(ar.a.NSH, Boolean.FALSE);
            AppMethodBeat.o(108729);
            return;
          }
          if (i == 3)
          {
            Log.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "set batch emoji download time to 0. ");
            g.aAh().azQ().set(ar.a.NSP, Boolean.TRUE);
          }
          AppMethodBeat.o(108729);
          return;
        }
        if (str.equalsIgnoreCase("EmotionBackup"))
        {
          int j = Util.getInt((String)((Map)localObject2).get(".sysmsg.EmotionBackup.OpCode"), 0);
          localObject2 = (String)((Map)localObject2).get(".sysmsg.EmotionBackup.DeviceID");
          if ((!Util.isNullOrNil((String)localObject2)) && (((String)localObject2).equalsIgnoreCase((String)localObject1)))
          {
            Log.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "same devices operate ignore.");
            AppMethodBeat.o(108729);
            return;
          }
          parama = b.amS(parama);
          if ((parama == null) || (parama.size() <= 0))
          {
            Log.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "xml syn list is null.");
            AppMethodBeat.o(108729);
            return;
          }
          if (j == 1)
          {
            Log.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "try to sync emoji from newxml. add buckupList:%d", new Object[] { Integer.valueOf(parama.size()) });
            localObject1 = new ArrayList();
            j = parama.size();
            while (i < j)
            {
              ((ArrayList)localObject1).add(new com.tencent.mm.plugin.emoji.sync.a.a((String)parama.get(i)));
              i += 1;
            }
            k.cGg().X((ArrayList)localObject1);
            k.cGg().rds.cGC();
            AppMethodBeat.o(108729);
            return;
          }
          if (j == 2)
          {
            Log.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "try to sync emoji from newxml. delete buckupList:%d", new Object[] { Integer.valueOf(parama.size()) });
            k.getEmojiStorageMgr().OpO.bj(parama);
          }
          AppMethodBeat.o(108729);
          return;
        }
        if (str.equalsIgnoreCase("SelfieEmojiBackup"))
        {
          str = (String)((Map)localObject2).get(".sysmsg.SelfieEmojiBackup.DeviceID");
          Log.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "back up capture client devicesID:%s server devicesID:%s", new Object[] { localObject1, str });
          if ((!Util.isNullOrNil(str)) && (str.equalsIgnoreCase((String)localObject1)))
          {
            Log.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "same devices operate ignore.");
            AppMethodBeat.o(108729);
            return;
          }
          i = Util.safeParseInt((String)((Map)localObject2).get(".sysmsg.SelfieEmojiBackup.OpCode"));
          localObject1 = b.amR(parama);
          if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0))
          {
            Log.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "back up capture: empty list opCode %s", new Object[] { Integer.valueOf(i) });
            AppMethodBeat.o(108729);
            return;
          }
          Log.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "back up capture: opCode %s, size %s", new Object[] { Integer.valueOf(i), Integer.valueOf(((ArrayList)localObject1).size()) });
          if (i == 1)
          {
            Log.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "back up capture: add capture %s", new Object[] { Integer.valueOf(((ArrayList)localObject1).size()) });
            c(1, (ArrayList)localObject1);
            AppMethodBeat.o(108729);
            return;
          }
          if (i == 2)
          {
            Log.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "back up capture: delete capture %s", new Object[] { Integer.valueOf(((ArrayList)localObject1).size()) });
            parama = new ArrayList();
            localObject1 = ((ArrayList)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (ait)((Iterator)localObject1).next();
              if (localObject2 != null) {
                parama.add(((ait)localObject2).Md5);
              }
            }
            k.getEmojiStorageMgr().OpN.ja(parama);
            g.aAh().azQ().set(ar.a.NSH, Boolean.FALSE);
            AppMethodBeat.o(108729);
            return;
          }
          if (i == 3)
          {
            Log.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "back up capture: move to top %s ", new Object[] { Integer.valueOf(((ArrayList)localObject1).size()) });
            g.aAh().azQ().set(ar.a.NSQ, Boolean.TRUE);
          }
          AppMethodBeat.o(108729);
          return;
        }
        Log.e("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "not emoji message type :".concat(String.valueOf(str)));
      }
      AppMethodBeat.o(108729);
      return;
    }
    Log.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "not new xml type:%d ", new Object[] { Integer.valueOf(parama.xKb) });
    AppMethodBeat.o(108729);
  }
  
  public final void a(h.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.g.a
 * JD-Core Version:    0.7.0.1
 */