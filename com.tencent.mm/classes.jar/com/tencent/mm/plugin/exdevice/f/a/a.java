package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.mm.ae.g.a;
import com.tencent.mm.plugin.exdevice.f.b.a.c;
import com.tencent.mm.plugin.exdevice.f.b.a.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class a
{
  public static ArrayList<d> a(String paramString1, String paramString2, String paramString3, String paramString4, Map<String, String> paramMap, List<c> paramList)
  {
    y.d("MicroMsg.ExdeviceMsgXmlParser", paramString3);
    if (bk.bl(paramString3))
    {
      y.e("MicroMsg.ExdeviceMsgXmlParser", "rank info is null or nil");
      return null;
    }
    paramString3 = g.a.M(paramString3, paramString4);
    if (paramString3 != null)
    {
      paramString4 = paramString3.dQt;
      ArrayList localArrayList = new ArrayList();
      boolean bool;
      int i;
      Object localObject1;
      if (paramString4 == null)
      {
        bool = true;
        y.d("MicroMsg.ExdeviceMsgXmlParser", "map is null :%s", new Object[] { Boolean.valueOf(bool) });
        if ((paramString4 == null) || (paramString4.isEmpty())) {
          break label693;
        }
        y.d("MicroMsg.ExdeviceMsgXmlParser", "ap: map %s", new Object[] { paramString4.toString() });
        i = 0;
        localObject1 = new StringBuilder(".msg.appmsg.hardwareinfo.follows.follow");
        if (i != 0) {
          break label304;
        }
        paramString3 = "";
        label125:
        localObject1 = (String)paramString4.get(paramString3 + ".username");
        if (!bk.bl((String)localObject1)) {
          break label313;
        }
        y.i("MicroMsg.ExdeviceMsgXmlParser", "follow should break now : %d", new Object[] { Integer.valueOf(i) });
        i = 0;
        paramList = new StringBuilder(".msg.appmsg.hardwareinfo.rankview.rankinfolist.rankinfo");
        if (i != 0) {
          break label487;
        }
        paramString3 = "";
        label199:
        paramList = (String)paramString4.get(paramString3 + ".username");
        localObject1 = new StringBuilder(".msg.appmsg.hardwareinfo.rankview.rankinfolist.rankinfo");
        if (i != 0) {
          break label496;
        }
      }
      label304:
      label313:
      label332:
      Object localObject3;
      label478:
      label487:
      label496:
      for (paramString3 = "";; paramString3 = Integer.valueOf(i))
      {
        localObject1 = (String)paramString4.get(paramString3 + ".nickname");
        if (!bk.bl(paramList)) {
          break label505;
        }
        y.i("MicroMsg.ExdeviceMsgXmlParser", "should break now : %d", new Object[] { Integer.valueOf(i) });
        return localArrayList;
        bool = false;
        break;
        paramString3 = Integer.valueOf(i);
        break label125;
        localObject2 = new StringBuilder(".msg.appmsg.hardwareinfo.follows.follow");
        if (i == 0)
        {
          paramString3 = "";
          localObject2 = (String)paramString4.get(paramString3 + ".nickname");
          localObject3 = new StringBuilder(".msg.appmsg.hardwareinfo.follows.follow");
          if (i != 0) {
            break label478;
          }
        }
        for (paramString3 = "";; paramString3 = Integer.valueOf(i))
        {
          paramString3 = (String)paramString4.get(paramString3 + ".step");
          localObject3 = new c();
          ((c)localObject3).field_appusername = paramString2;
          ((c)localObject3).field_username = ((String)localObject1);
          ((c)localObject3).field_rankID = paramString1;
          ((c)localObject3).field_step = bk.getInt(paramString3, 0);
          paramList.add(localObject3);
          paramMap.put(localObject1, localObject2);
          i += 1;
          break;
          paramString3 = Integer.valueOf(i);
          break label332;
        }
        paramString3 = Integer.valueOf(i);
        break label199;
      }
      label505:
      Object localObject2 = new StringBuilder(".msg.appmsg.hardwareinfo.rankview.rankinfolist.rankinfo");
      if (i == 0)
      {
        paramString3 = "";
        label524:
        localObject2 = (String)paramString4.get(paramString3 + ".rank.rankdisplay");
        localObject3 = new StringBuilder(".msg.appmsg.hardwareinfo.rankview.rankinfolist.rankinfo");
        if (i != 0) {
          break label684;
        }
      }
      label684:
      for (paramString3 = "";; paramString3 = Integer.valueOf(i))
      {
        int j = bk.getInt((String)paramString4.get(paramString3 + ".score.scoredisplay"), 0);
        paramString3 = new d();
        paramString3.field_appusername = paramString2;
        paramString3.field_rankID = paramString1;
        paramString3.field_username = paramList;
        paramString3.field_ranknum = bk.getInt((String)localObject2, 0);
        paramString3.field_score = j;
        paramString3.field_selfLikeState = 2;
        paramString3.field_likecount = 0;
        localArrayList.add(paramString3);
        paramMap.put(paramList, localObject1);
        i += 1;
        break;
        paramString3 = Integer.valueOf(i);
        break label524;
      }
    }
    label693:
    return null;
  }
  
  public static void a(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    int k = 0;
    y.d("MicroMsg.ExdeviceMsgXmlParser", "ap: only nickname: %s", new Object[] { paramString1 });
    if (bk.bl(paramString1)) {
      y.e("MicroMsg.ExdeviceMsgXmlParser", "rank info is null or nil");
    }
    do
    {
      do
      {
        return;
        paramString1 = g.a.M(paramString1, paramString2);
      } while (paramString1 == null);
      paramString2 = paramString1.dQt;
    } while ((paramString2 == null) || (paramString2.isEmpty()));
    int i = 0;
    Object localObject = new StringBuilder(".msg.appmsg.hardwareinfo.follows.follow");
    label81:
    int j;
    StringBuilder localStringBuilder;
    if (i == 0)
    {
      paramString1 = "";
      localObject = (String)paramString2.get(paramString1 + ".username");
      j = k;
      if (bk.bl((String)localObject)) {
        break label191;
      }
      localStringBuilder = new StringBuilder(".msg.appmsg.hardwareinfo.follows.follow");
      if (i != 0) {
        break label183;
      }
    }
    label183:
    for (paramString1 = "";; paramString1 = Integer.valueOf(i))
    {
      paramMap.put(localObject, (String)paramString2.get(paramString1 + ".nickname"));
      i += 1;
      break;
      paramString1 = Integer.valueOf(i);
      break label81;
    }
    label191:
    localObject = new StringBuilder(".msg.appmsg.hardwareinfo.rankview.rankinfolist.rankinfo");
    if (j == 0)
    {
      paramString1 = "";
      label210:
      localObject = (String)paramString2.get(paramString1 + ".username");
      localStringBuilder = new StringBuilder(".msg.appmsg.hardwareinfo.rankview.rankinfolist.rankinfo");
      if (j != 0) {
        break label314;
      }
    }
    label314:
    for (paramString1 = "";; paramString1 = Integer.valueOf(j))
    {
      paramString1 = (String)paramString2.get(paramString1 + ".nickname");
      if (bk.bl((String)localObject)) {
        break;
      }
      paramMap.put(localObject, paramString1);
      j += 1;
      break label191;
      paramString1 = Integer.valueOf(j);
      break label210;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.a.a
 * JD-Core Version:    0.7.0.1
 */