package com.tencent.mm.be;

import com.tencent.mm.ah.m;
import com.tencent.mm.ah.o;
import com.tencent.mm.ah.p;
import com.tencent.mm.az.n;
import com.tencent.mm.az.r;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public final class d
  implements com.tencent.mm.ah.f
{
  public static int chatType = 0;
  private static final com.tencent.mm.a.f<Integer, a> dss = new com.tencent.mm.a.f(5);
  private static d eBg;
  public boolean dZI = false;
  private int ewv = 3;
  
  public static d Rc()
  {
    if (eBg == null) {
      eBg = new d();
    }
    return eBg;
  }
  
  public static void Rd()
  {
    g.DQ();
    g.DP().Dz().o(16646145, Integer.valueOf(0));
  }
  
  public static void Re()
  {
    g.DQ();
    Integer localInteger2 = Integer.valueOf(bk.g((Integer)g.DP().Dz().get(16646145, null)));
    Integer localInteger1 = localInteger2;
    if (localInteger2.intValue() < 0) {
      localInteger1 = Integer.valueOf(0);
    }
    g.DQ();
    g.DP().Dz().o(16646145, Integer.valueOf(localInteger1.intValue() + 1));
  }
  
  public static String getPrefix()
  {
    switch (chatType)
    {
    default: 
      return "single_";
    case 0: 
      return "single_";
    case 1: 
      return "chatroom_";
    }
    return "app_";
  }
  
  public static int np(String paramString)
  {
    int i = 5;
    if ((paramString == null) || (paramString.length() == 0)) {
      return 5;
    }
    if ((!paramString.startsWith("single")) || (paramString.startsWith("chatroom"))) {
      i = 7;
    }
    if (paramString.startsWith("app")) {
      i = 8;
    }
    y.d("upload", "type " + i);
    return i;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((!(paramm instanceof o)) || (((o)paramm).KF() != 9)) {
      y.d("upload", "another scene");
    }
    while (paramm.getType() != 159) {
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      g.DQ();
      g.DP().Dz().o(81944, Long.valueOf(bk.UX()));
    }
    for (;;)
    {
      release();
      return;
      paramInt1 = this.ewv - 1;
      this.ewv = paramInt1;
      if (paramInt1 < 0)
      {
        g.DQ();
        g.DP().Dz().o(81944, Long.valueOf((bk.UY() - 86400000L + 3600000L) / 1000L));
        this.ewv = 3;
      }
    }
  }
  
  public final void release()
  {
    this.dZI = false;
    g.Dk().b(159, this);
  }
  
  public static final class a
  {
    public String eBh = "BeiJing;GuangZhou;ShangHai;";
    public int eBi = 0;
    public int eBj = 2;
    public int eBk = 2;
    public int eBl = 2;
    public int eBm = 10240;
    public int eBn = 10240000;
    public int eBo = 100;
    public int eBp = 100;
    public int eBq = 100;
    public Random eBr = new Random();
    public List<String> eBs = null;
    public int sex = 0;
    
    public static a Rj()
    {
      y.d("upload", "parseFromFile");
      Object localObject1 = r.PK();
      localObject1 = n.PH() + ((n)localObject1).br(1, 9);
      int i = (int)com.tencent.mm.vfs.e.aeQ((String)localObject1);
      if (i == -1)
      {
        y.e("upload", "read file failed " + i + (String)localObject1);
        localObject1 = null;
      }
      int k;
      a locala;
      do
      {
        return localObject1;
        localObject3 = com.tencent.mm.vfs.e.c((String)localObject1, 0, i);
        if (localObject3 == null)
        {
          y.e("upload", "read file failed " + i + (String)localObject1);
          return null;
        }
        localObject3 = new String((byte[])localObject3);
        if (bk.bl((String)localObject3)) {
          return null;
        }
        i = ((String)localObject3).indexOf('<');
        if (i <= 0) {
          break;
        }
        localObject3 = ((String)localObject3).substring(i);
        k = ((String)localObject3).hashCode();
        locala = (a)d.Rf().get(Integer.valueOf(k));
        localObject1 = locala;
      } while (locala != null);
      Object localObject3 = bn.s((String)localObject3, "Config");
      if (localObject3 == null)
      {
        y.e("upload", "parse msg failed");
        return null;
      }
      for (;;)
      {
        StringBuilder localStringBuilder;
        int j;
        try
        {
          locala = new a();
          i = 0;
          localStringBuilder = new StringBuilder(".Config.Item");
          if (i == 0)
          {
            localObject1 = "";
            localObject1 = (String)((Map)localObject3).get(localObject1 + ".$key");
            y.d("upload", "key " + (String)localObject1);
            if (localObject1 == null) {
              break label1129;
            }
            if (!((String)localObject1).equals("region")) {
              continue;
            }
            localStringBuilder = new StringBuilder(".Config.Item");
            if (i == 0)
            {
              localObject1 = "";
              locala.eBh = ((String)((Map)localObject3).get(localObject1));
              if ((locala.eBh == null) || (locala.eBh.length() <= 0)) {
                break label1434;
              }
              localObject1 = locala.eBh.split(";");
              locala.eBs = new ArrayList();
              if ((localObject1 == null) || (localObject1.length <= 0)) {
                break label1434;
              }
              j = 0;
              if (j >= localObject1.length) {
                break label1434;
              }
              if ((localObject1[j] == null) || (localObject1[j].length() <= 0)) {
                break label1427;
              }
              locala.eBs.add(localObject1[j]);
              break label1427;
            }
          }
          else
          {
            localObject1 = Integer.valueOf(i);
            continue;
          }
          localObject1 = Integer.valueOf(i);
          continue;
          if (((String)localObject1).equals("sex"))
          {
            localStringBuilder = new StringBuilder(".Config.Item");
            if (i == 0)
            {
              localObject1 = "";
              locala.sex = bk.getInt((String)((Map)localObject3).get(localObject1), 0);
            }
            else
            {
              localObject1 = Integer.valueOf(i);
              continue;
            }
          }
          else if (((String)localObject1).equals("rate"))
          {
            localStringBuilder = new StringBuilder(".Config.Item");
            if (i == 0)
            {
              localObject1 = "";
              locala.eBi = bk.getInt((String)((Map)localObject3).get(localObject1), 0);
            }
          }
        }
        catch (Exception localException)
        {
          y.e("upload", "exception:%s", new Object[] { bk.j(localException) });
          return null;
        }
        Object localObject2 = Integer.valueOf(i);
        continue;
        if (((String)localObject2).equals("minsize"))
        {
          localStringBuilder = new StringBuilder(".Config.Item");
          if (i == 0) {}
          for (localObject2 = "";; localObject2 = Integer.valueOf(i))
          {
            locala.eBm = bk.getInt((String)((Map)localObject3).get(localObject2), 0);
            break;
          }
        }
        if (((String)localObject2).equals("maxsize"))
        {
          localStringBuilder = new StringBuilder(".Config.Item");
          if (i == 0) {}
          for (localObject2 = "";; localObject2 = Integer.valueOf(i))
          {
            locala.eBn = bk.getInt((String)((Map)localObject3).get(localObject2), 0);
            break;
          }
        }
        if (((String)localObject2).equals("daycount_single"))
        {
          localStringBuilder = new StringBuilder(".Config.Item");
          if (i == 0) {}
          for (localObject2 = "";; localObject2 = Integer.valueOf(i))
          {
            locala.eBo = bk.getInt((String)((Map)localObject3).get(localObject2), 0);
            break;
          }
        }
        if (((String)localObject2).equals("daycount_chatroom"))
        {
          localStringBuilder = new StringBuilder(".Config.Item");
          if (i == 0) {}
          for (localObject2 = "";; localObject2 = Integer.valueOf(i))
          {
            locala.eBp = bk.getInt((String)((Map)localObject3).get(localObject2), 0);
            break;
          }
        }
        if (((String)localObject2).equals("daycount_app"))
        {
          localStringBuilder = new StringBuilder(".Config.Item");
          if (i == 0) {}
          for (localObject2 = "";; localObject2 = Integer.valueOf(i))
          {
            locala.eBq = bk.getInt((String)((Map)localObject3).get(localObject2), 0);
            break;
          }
        }
        if (((String)localObject2).equals("rate_single"))
        {
          localStringBuilder = new StringBuilder(".Config.Item");
          if (i == 0) {}
          for (localObject2 = "";; localObject2 = Integer.valueOf(i))
          {
            locala.eBj = bk.getInt((String)((Map)localObject3).get(localObject2), 0);
            break;
          }
        }
        if (((String)localObject2).equals("rate_chatroom"))
        {
          localStringBuilder = new StringBuilder(".Config.Item");
          if (i == 0) {}
          for (localObject2 = "";; localObject2 = Integer.valueOf(i))
          {
            locala.eBk = bk.getInt((String)((Map)localObject3).get(localObject2), 0);
            break;
          }
        }
        if (((String)localObject2).equals("rate_app"))
        {
          localStringBuilder = new StringBuilder(".Config.Item");
          if (i == 0) {}
          for (localObject2 = "";; localObject2 = Integer.valueOf(i))
          {
            locala.eBl = bk.getInt((String)((Map)localObject3).get(localObject2), 0);
            break;
          }
          label1129:
          y.d("upload", "sex " + locala.sex);
          y.d("upload", "rate_single " + locala.eBj);
          y.d("upload", "rate_chatroom " + locala.eBk);
          y.d("upload", "rate_app " + locala.eBl);
          y.d("upload", "rate " + locala.eBi);
          y.d("upload", "minsize " + locala.eBm);
          y.d("upload", "maxsize " + locala.eBn);
          y.d("upload", "daycount_single " + locala.eBo);
          y.d("upload", "daycount_chatroom " + locala.eBp);
          y.d("upload", "daycount_app " + locala.eBq);
          y.d("upload", "region " + locala.eBh);
          d.Rf().f(Integer.valueOf(k), locala);
          return locala;
          break;
          label1427:
          j += 1;
          continue;
        }
        label1434:
        i += 1;
      }
    }
    
    public final boolean Rg()
    {
      boolean bool2 = false;
      Object localObject2 = q.GQ();
      Object localObject1;
      boolean bool1;
      int i;
      if ("  getRegionCode " + localObject2 != null)
      {
        localObject1 = ((ao)localObject2).cCG;
        y.d("upload", (String)localObject1);
        localObject1 = ((ao)localObject2).cCG;
        bool1 = bool2;
        if (localObject1 != null)
        {
          bool1 = bool2;
          if (((String)localObject1).length() > 0)
          {
            bool1 = bool2;
            if (this.eBs != null)
            {
              bool1 = bool2;
              if (this.eBs.size() > 0)
              {
                localObject1 = ((String)localObject1).split("_");
                bool1 = bool2;
                if (localObject1 != null)
                {
                  bool1 = bool2;
                  if (localObject1.length > 0) {
                    i = 0;
                  }
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        bool1 = bool2;
        if (i < localObject1.length)
        {
          if ((localObject1[i] != null) && (localObject1[i].length() > 0))
          {
            localObject2 = this.eBs.iterator();
            do
            {
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
            } while (!((String)((Iterator)localObject2).next()).trim().toLowerCase().equals(localObject1[i].trim().toLowerCase()));
            y.d("upload", "isInRegion");
            bool1 = true;
          }
        }
        else
        {
          return bool1;
          localObject1 = "";
          break;
        }
        i += 1;
      }
    }
    
    public final int Rh()
    {
      switch (d.chatType)
      {
      default: 
        return this.eBj;
      case 0: 
        return this.eBj;
      case 1: 
        return this.eBk;
      }
      return this.eBl;
    }
    
    public final int Ri()
    {
      switch (d.chatType)
      {
      default: 
        return this.eBo;
      case 0: 
        return this.eBo;
      case 1: 
        return this.eBp;
      }
      return this.eBq;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.be.d
 * JD-Core Version:    0.7.0.1
 */