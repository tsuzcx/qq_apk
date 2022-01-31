package com.tencent.mm.modelsimple;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.h.a.a;
import com.tencent.mm.model.au;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aev;
import com.tencent.mm.protocal.c.aew;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

public final class k
  extends m
  implements com.tencent.mm.network.k
{
  private static Map<String, Long> ezf = new HashMap();
  private static Map<String, String> ezg;
  private boolean bPo = false;
  private final b dWV;
  private f dmL;
  private c<a> ezh;
  
  public k(int paramInt, boolean paramBoolean)
  {
    b.a locala = new b.a();
    locala.ecH = new aev();
    locala.ecI = new aew();
    locala.uri = "/cgi-bin/micromsg-bin/getdisasterinfo";
    locala.ecG = 775;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dWV = locala.Kt();
    this.dWV.ccs = 1;
    ((aev)this.dWV.ecE.ecN).bPn = paramInt;
    this.bPo = paramBoolean;
    Qp();
    y.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo noticeid[%d], manualauthSucc[%b], stack[%s]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.bPo), bk.csb() });
  }
  
  private void M(String paramString, boolean paramBoolean)
  {
    au.DS().O(new k.1(this, paramString, paramBoolean));
  }
  
  private void Qp()
  {
    for (;;)
    {
      int i;
      Object localObject4;
      try
      {
        if (ezg != null) {
          break label363;
        }
        y.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz loadNoticeContentMap noticeContentMap");
        ezg = new HashMap();
        SharedPreferences localSharedPreferences = ae.getContext().getSharedPreferences("disaster_pref", 4);
        Object localObject1 = localSharedPreferences.getString("disaster_new_noticeid_list_key", "");
        if (bk.bl((String)localObject1)) {
          break label346;
        }
        String[] arrayOfString1 = ((String)localObject1).split(";");
        if ((arrayOfString1 == null) || (arrayOfString1.length <= 0)) {
          break label346;
        }
        String str1 = "";
        SharedPreferences.Editor localEditor = localSharedPreferences.edit();
        int j = arrayOfString1.length;
        i = 0;
        if (i < j)
        {
          String[] arrayOfString2 = arrayOfString1[i].split(",");
          localObject1 = str1;
          localObject4 = str1;
          try
          {
            if (bk.getLong(arrayOfString2[0], 0L) <= 0L) {
              break label366;
            }
            localObject1 = str1;
            if (bk.cn(bk.getLong(arrayOfString2[1], 0L)) < 86400L)
            {
              localObject1 = str1;
              String str2 = localSharedPreferences.getString(arrayOfString2[0], "");
              localObject1 = str1;
              localObject4 = str1;
              if (!bk.bl(str2))
              {
                localObject1 = str1;
                localObject4 = str1 + arrayOfString2[0] + "," + arrayOfString2[1] + ";";
                localObject1 = localObject4;
                ezg.put(arrayOfString2[0], str2);
              }
            }
            else
            {
              localObject1 = str1;
              localEditor.remove(arrayOfString2[0]).commit();
              localObject4 = str1;
            }
          }
          catch (Exception localException)
          {
            y.e("MicroMsg.NetSceneGetDisasterInfo", "summerdiz loadNoticeContentMap noticeContentMap error:%s", new Object[] { localException.getMessage() });
            localObject4 = localObject1;
          }
        }
        localEditor.putString("disaster_new_noticeid_list_key", localException).commit();
      }
      finally {}
      y.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz loadNoticeContentMap noticeContentMap newNoticeIdList[%s], noticeidTickMap[%s]", new Object[] { localException, ezf });
      label346:
      y.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz loadNoticeContentMap noticeContentMap done noticeContentMap[%s]", new Object[] { ezg });
      label363:
      return;
      label366:
      i += 1;
      Object localObject3 = localObject4;
    }
  }
  
  public final int a(e parame, f paramf)
  {
    aev localaev = (aev)this.dWV.ecE.ecN;
    long l = bk.a((Long)ezf.get(localaev.bPn), 0L);
    y.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo doScene noticeid[%d], tick[%d], noticeidTickMap[%s]", new Object[] { Integer.valueOf(localaev.bPn), Long.valueOf(l), ezf });
    if ((l != 0L) && (bk.cp(l) < 1800000L))
    {
      y.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo doScene disasterTick within half an hour, drop it [%s]", new Object[] { Integer.valueOf(localaev.bPn) });
      return -1;
    }
    String str = bk.aM((String)ezg.get(localaev.bPn), "");
    if (!bk.bl(str))
    {
      y.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo doScene found cache[%d, %s]", new Object[] { Integer.valueOf(localaev.bPn), str });
      M(str, false);
      return -1;
    }
    this.dmL = paramf;
    return a(parame, this.dWV, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo onGYNetEnd netId[%d], errType[%d], errCode[%d], errMsg[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      M(((aew)this.dWV.ecF.ecN).content, true);
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 775;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelsimple.k
 * JD-Core Version:    0.7.0.1
 */