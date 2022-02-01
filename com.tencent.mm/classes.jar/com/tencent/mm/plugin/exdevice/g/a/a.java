package com.tencent.mm.plugin.exdevice.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.plugin.exdevice.g.b.a.c;
import com.tencent.mm.plugin.exdevice.g.b.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class a
{
  public static ArrayList<d> a(String paramString1, String paramString2, String paramString3, String paramString4, Map<String, String> paramMap, List<c> paramList)
  {
    AppMethodBeat.i(23497);
    Log.d("MicroMsg.ExdeviceMsgXmlParser", paramString3);
    if (Util.isNullOrNil(paramString3))
    {
      Log.e("MicroMsg.ExdeviceMsgXmlParser", "rank info is null or nil");
      AppMethodBeat.o(23497);
      return null;
    }
    paramString3 = k.b.aD(paramString3, paramString4);
    if (paramString3 != null)
    {
      paramString4 = paramString3.iwG;
      ArrayList localArrayList = new ArrayList();
      boolean bool;
      int i;
      Object localObject1;
      if (paramString4 == null)
      {
        bool = true;
        Log.d("MicroMsg.ExdeviceMsgXmlParser", "map is null :%s", new Object[] { Boolean.valueOf(bool) });
        if ((paramString4 == null) || (paramString4.isEmpty())) {
          break label711;
        }
        Log.d("MicroMsg.ExdeviceMsgXmlParser", "ap: map %s", new Object[] { paramString4.toString() });
        i = 0;
        localObject1 = new StringBuilder(".msg.appmsg.hardwareinfo.follows.follow");
        if (i != 0) {
          break label322;
        }
        paramString3 = "";
        label137:
        localObject1 = (String)paramString4.get(paramString3 + ".username");
        if (!Util.isNullOrNil((String)localObject1)) {
          break label331;
        }
        Log.i("MicroMsg.ExdeviceMsgXmlParser", "follow should break now : %d", new Object[] { Integer.valueOf(i) });
        i = 0;
        paramList = new StringBuilder(".msg.appmsg.hardwareinfo.rankview.rankinfolist.rankinfo");
        if (i != 0) {
          break label505;
        }
        paramString3 = "";
        label211:
        paramList = (String)paramString4.get(paramString3 + ".username");
        localObject1 = new StringBuilder(".msg.appmsg.hardwareinfo.rankview.rankinfolist.rankinfo");
        if (i != 0) {
          break label514;
        }
      }
      label322:
      label331:
      label350:
      Object localObject3;
      label514:
      for (paramString3 = "";; paramString3 = Integer.valueOf(i))
      {
        localObject1 = (String)paramString4.get(paramString3 + ".nickname");
        if (!Util.isNullOrNil(paramList)) {
          break label523;
        }
        Log.i("MicroMsg.ExdeviceMsgXmlParser", "should break now : %d", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(23497);
        return localArrayList;
        bool = false;
        break;
        paramString3 = Integer.valueOf(i);
        break label137;
        localObject2 = new StringBuilder(".msg.appmsg.hardwareinfo.follows.follow");
        if (i == 0)
        {
          paramString3 = "";
          localObject2 = (String)paramString4.get(paramString3 + ".nickname");
          localObject3 = new StringBuilder(".msg.appmsg.hardwareinfo.follows.follow");
          if (i != 0) {
            break label496;
          }
        }
        label496:
        for (paramString3 = "";; paramString3 = Integer.valueOf(i))
        {
          paramString3 = (String)paramString4.get(paramString3 + ".step");
          localObject3 = new c();
          ((c)localObject3).field_appusername = paramString2;
          ((c)localObject3).field_username = ((String)localObject1);
          ((c)localObject3).field_rankID = paramString1;
          ((c)localObject3).field_step = Util.getInt(paramString3, 0);
          paramList.add(localObject3);
          paramMap.put(localObject1, localObject2);
          i += 1;
          break;
          paramString3 = Integer.valueOf(i);
          break label350;
        }
        label505:
        paramString3 = Integer.valueOf(i);
        break label211;
      }
      label523:
      Object localObject2 = new StringBuilder(".msg.appmsg.hardwareinfo.rankview.rankinfolist.rankinfo");
      if (i == 0)
      {
        paramString3 = "";
        label542:
        localObject2 = (String)paramString4.get(paramString3 + ".rank.rankdisplay");
        localObject3 = new StringBuilder(".msg.appmsg.hardwareinfo.rankview.rankinfolist.rankinfo");
        if (i != 0) {
          break label702;
        }
      }
      label702:
      for (paramString3 = "";; paramString3 = Integer.valueOf(i))
      {
        int j = Util.getInt((String)paramString4.get(paramString3 + ".score.scoredisplay"), 0);
        paramString3 = new d();
        paramString3.field_appusername = paramString2;
        paramString3.field_rankID = paramString1;
        paramString3.field_username = paramList;
        paramString3.field_ranknum = Util.getInt((String)localObject2, 0);
        paramString3.field_score = j;
        paramString3.field_selfLikeState = 2;
        paramString3.field_likecount = 0;
        localArrayList.add(paramString3);
        paramMap.put(paramList, localObject1);
        i += 1;
        break;
        paramString3 = Integer.valueOf(i);
        break label542;
      }
    }
    label711:
    AppMethodBeat.o(23497);
    return null;
  }
  
  public static void b(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    int k = 0;
    AppMethodBeat.i(23498);
    Log.d("MicroMsg.ExdeviceMsgXmlParser", "ap: only nickname: %s", new Object[] { paramString1 });
    if (Util.isNullOrNil(paramString1))
    {
      Log.e("MicroMsg.ExdeviceMsgXmlParser", "rank info is null or nil");
      AppMethodBeat.o(23498);
      return;
    }
    paramString1 = k.b.aD(paramString1, paramString2);
    if (paramString1 != null)
    {
      paramString2 = paramString1.iwG;
      if ((paramString2 != null) && (!paramString2.isEmpty()))
      {
        int i = 0;
        Object localObject = new StringBuilder(".msg.appmsg.hardwareinfo.follows.follow");
        label93:
        int j;
        StringBuilder localStringBuilder;
        if (i == 0)
        {
          paramString1 = "";
          localObject = (String)paramString2.get(paramString1 + ".username");
          j = k;
          if (Util.isNullOrNil((String)localObject)) {
            break label203;
          }
          localStringBuilder = new StringBuilder(".msg.appmsg.hardwareinfo.follows.follow");
          if (i != 0) {
            break label195;
          }
        }
        label195:
        for (paramString1 = "";; paramString1 = Integer.valueOf(i))
        {
          paramMap.put(localObject, (String)paramString2.get(paramString1 + ".nickname"));
          i += 1;
          break;
          paramString1 = Integer.valueOf(i);
          break label93;
        }
        label203:
        localObject = new StringBuilder(".msg.appmsg.hardwareinfo.rankview.rankinfolist.rankinfo");
        if (j == 0)
        {
          paramString1 = "";
          label222:
          localObject = (String)paramString2.get(paramString1 + ".username");
          localStringBuilder = new StringBuilder(".msg.appmsg.hardwareinfo.rankview.rankinfolist.rankinfo");
          if (j != 0) {
            break label326;
          }
        }
        label326:
        for (paramString1 = "";; paramString1 = Integer.valueOf(j))
        {
          paramString1 = (String)paramString2.get(paramString1 + ".nickname");
          if (Util.isNullOrNil((String)localObject)) {
            break label335;
          }
          paramMap.put(localObject, paramString1);
          j += 1;
          break;
          paramString1 = Integer.valueOf(j);
          break label222;
        }
      }
    }
    label335:
    AppMethodBeat.o(23498);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.a.a
 * JD-Core Version:    0.7.0.1
 */