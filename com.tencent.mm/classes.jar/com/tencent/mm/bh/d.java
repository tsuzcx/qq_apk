package com.tencent.mm.bh;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.b.f;
import com.tencent.mm.b.h;
import com.tencent.mm.bc.t;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ab;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public final class d
  implements com.tencent.mm.al.g
{
  public static int chatType;
  private static final f<Integer, a> fwL;
  private static d htF;
  public boolean fOm = false;
  private int hoX = 3;
  
  static
  {
    AppMethodBeat.i(148389);
    fwL = new h(5);
    chatType = 0;
    AppMethodBeat.o(148389);
  }
  
  public static d aBo()
  {
    AppMethodBeat.i(148384);
    if (htF == null) {
      htF = new d();
    }
    d locald = htF;
    AppMethodBeat.o(148384);
    return locald;
  }
  
  public static void aBp()
  {
    AppMethodBeat.i(148387);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afB().afk().set(16646145, Integer.valueOf(0));
    AppMethodBeat.o(148387);
  }
  
  public static void aBq()
  {
    AppMethodBeat.i(148388);
    com.tencent.mm.kernel.g.afC();
    Integer localInteger2 = Integer.valueOf(bt.l((Integer)com.tencent.mm.kernel.g.afB().afk().get(16646145, null)));
    Integer localInteger1 = localInteger2;
    if (localInteger2.intValue() < 0) {
      localInteger1 = Integer.valueOf(0);
    }
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afB().afk().set(16646145, Integer.valueOf(localInteger1.intValue() + 1));
    AppMethodBeat.o(148388);
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
  
  public static int zq(String paramString)
  {
    int i = 5;
    AppMethodBeat.i(148383);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(148383);
      return 5;
    }
    if ((!paramString.startsWith("single")) || (paramString.startsWith("chatroom"))) {
      i = 7;
    }
    if (paramString.startsWith("app")) {
      i = 8;
    }
    ad.d("upload", "type ".concat(String.valueOf(i)));
    AppMethodBeat.o(148383);
    return i;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(148386);
    if ((!(paramn instanceof com.tencent.mm.al.p)) || (((com.tencent.mm.al.p)paramn).auQ() != 9))
    {
      ad.d("upload", "another scene");
      AppMethodBeat.o(148386);
      return;
    }
    if (paramn.getType() == 159)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label91;
      }
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afB().afk().set(81944, Long.valueOf(bt.aGK()));
    }
    for (;;)
    {
      release();
      AppMethodBeat.o(148386);
      return;
      label91:
      paramInt1 = this.hoX - 1;
      this.hoX = paramInt1;
      if (paramInt1 < 0)
      {
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afB().afk().set(81944, Long.valueOf((bt.eGO() - 86400000L + 3600000L) / 1000L));
        this.hoX = 3;
      }
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(148385);
    this.fOm = false;
    com.tencent.mm.kernel.g.aeS().b(159, this);
    AppMethodBeat.o(148385);
  }
  
  public static final class a
  {
    public int evp;
    public String htG;
    public int htH;
    public int htI;
    public int htJ;
    public int htK;
    public int htL;
    public int htM;
    public int htN;
    public int htO;
    public int htP;
    private Random htQ;
    public List<String> htR;
    
    public a()
    {
      AppMethodBeat.i(148379);
      this.htG = "BeiJing;GuangZhou;ShangHai;";
      this.evp = 0;
      this.htH = 0;
      this.htI = 2;
      this.htJ = 2;
      this.htK = 2;
      this.htL = 10240;
      this.htM = 10240000;
      this.htN = 100;
      this.htO = 100;
      this.htP = 100;
      this.htQ = new Random();
      this.htR = null;
      AppMethodBeat.o(148379);
    }
    
    private int aBu()
    {
      switch (d.chatType)
      {
      default: 
        return this.htN;
      case 0: 
        return this.htN;
      case 1: 
        return this.htO;
      }
      return this.htP;
    }
    
    public static a aBw()
    {
      AppMethodBeat.i(148382);
      ad.d("upload", "parseFromFile");
      Object localObject1 = t.azY();
      localObject1 = com.tencent.mm.bc.p.azV() + ((com.tencent.mm.bc.p)localObject1).di(1, 9);
      int i = (int)i.aMN((String)localObject1);
      if (i == -1)
      {
        ad.e("upload", "read file failed " + i + (String)localObject1);
        AppMethodBeat.o(148382);
        return null;
      }
      Object localObject3 = i.aR((String)localObject1, 0, i);
      if (localObject3 == null)
      {
        ad.e("upload", "read file failed " + i + (String)localObject1);
        AppMethodBeat.o(148382);
        return null;
      }
      localObject1 = new String((byte[])localObject3);
      if (bt.isNullOrNil((String)localObject1))
      {
        AppMethodBeat.o(148382);
        return null;
      }
      i = ((String)localObject1).indexOf('<');
      int k;
      if (i > 0)
      {
        localObject1 = ((String)localObject1).substring(i);
        k = ((String)localObject1).hashCode();
        localObject3 = (a)d.aBr().get(Integer.valueOf(k));
        if (localObject3 != null)
        {
          AppMethodBeat.o(148382);
          return localObject3;
        }
        localObject3 = bw.K((String)localObject1, "Config");
        if (localObject3 == null)
        {
          ad.e("upload", "parse msg failed");
          AppMethodBeat.o(148382);
          return null;
        }
      }
      for (;;)
      {
        a locala;
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
            ad.d("upload", "key ".concat(String.valueOf(localObject1)));
            if (localObject1 == null) {
              break label1155;
            }
            if (!((String)localObject1).equals("region")) {
              continue;
            }
            localStringBuilder = new StringBuilder(".Config.Item");
            if (i == 0)
            {
              localObject1 = "";
              locala.htG = ((String)((Map)localObject3).get(localObject1));
              if ((locala.htG == null) || (locala.htG.length() <= 0)) {
                break label1473;
              }
              localObject1 = locala.htG.split(";");
              locala.htR = new ArrayList();
              if ((localObject1 == null) || (localObject1.length <= 0)) {
                break label1473;
              }
              j = 0;
              if (j >= localObject1.length) {
                break label1473;
              }
              if ((localObject1[j] == null) || (localObject1[j].length() <= 0)) {
                break label1466;
              }
              locala.htR.add(localObject1[j]);
              break label1466;
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
              locala.evp = bt.getInt((String)((Map)localObject3).get(localObject1), 0);
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
              locala.htH = bt.getInt((String)((Map)localObject3).get(localObject1), 0);
            }
          }
        }
        catch (Exception localException)
        {
          ad.e("upload", "exception:%s", new Object[] { bt.m(localException) });
          AppMethodBeat.o(148382);
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
            locala.htL = bt.getInt((String)((Map)localObject3).get(localObject2), 0);
            break;
          }
        }
        if (((String)localObject2).equals("maxsize"))
        {
          localStringBuilder = new StringBuilder(".Config.Item");
          if (i == 0) {}
          for (localObject2 = "";; localObject2 = Integer.valueOf(i))
          {
            locala.htM = bt.getInt((String)((Map)localObject3).get(localObject2), 0);
            break;
          }
        }
        if (((String)localObject2).equals("daycount_single"))
        {
          localStringBuilder = new StringBuilder(".Config.Item");
          if (i == 0) {}
          for (localObject2 = "";; localObject2 = Integer.valueOf(i))
          {
            locala.htN = bt.getInt((String)((Map)localObject3).get(localObject2), 0);
            break;
          }
        }
        if (((String)localObject2).equals("daycount_chatroom"))
        {
          localStringBuilder = new StringBuilder(".Config.Item");
          if (i == 0) {}
          for (localObject2 = "";; localObject2 = Integer.valueOf(i))
          {
            locala.htO = bt.getInt((String)((Map)localObject3).get(localObject2), 0);
            break;
          }
        }
        if (((String)localObject2).equals("daycount_app"))
        {
          localStringBuilder = new StringBuilder(".Config.Item");
          if (i == 0) {}
          for (localObject2 = "";; localObject2 = Integer.valueOf(i))
          {
            locala.htP = bt.getInt((String)((Map)localObject3).get(localObject2), 0);
            break;
          }
        }
        if (((String)localObject2).equals("rate_single"))
        {
          localStringBuilder = new StringBuilder(".Config.Item");
          if (i == 0) {}
          for (localObject2 = "";; localObject2 = Integer.valueOf(i))
          {
            locala.htI = bt.getInt((String)((Map)localObject3).get(localObject2), 0);
            break;
          }
        }
        if (((String)localObject2).equals("rate_chatroom"))
        {
          localStringBuilder = new StringBuilder(".Config.Item");
          if (i == 0) {}
          for (localObject2 = "";; localObject2 = Integer.valueOf(i))
          {
            locala.htJ = bt.getInt((String)((Map)localObject3).get(localObject2), 0);
            break;
          }
        }
        if (((String)localObject2).equals("rate_app"))
        {
          localStringBuilder = new StringBuilder(".Config.Item");
          if (i == 0) {}
          for (localObject2 = "";; localObject2 = Integer.valueOf(i))
          {
            locala.htK = bt.getInt((String)((Map)localObject3).get(localObject2), 0);
            break;
          }
          label1155:
          ad.d("upload", "sex " + locala.evp);
          ad.d("upload", "rate_single " + locala.htI);
          ad.d("upload", "rate_chatroom " + locala.htJ);
          ad.d("upload", "rate_app " + locala.htK);
          ad.d("upload", "rate " + locala.htH);
          ad.d("upload", "minsize " + locala.htL);
          ad.d("upload", "maxsize " + locala.htM);
          ad.d("upload", "daycount_single " + locala.htN);
          ad.d("upload", "daycount_chatroom " + locala.htO);
          ad.d("upload", "daycount_app " + locala.htP);
          ad.d("upload", "region " + locala.htG);
          d.aBr().o(Integer.valueOf(k), locala);
          AppMethodBeat.o(148382);
          return locala;
          break;
          label1466:
          j += 1;
          continue;
        }
        label1473:
        i += 1;
      }
    }
    
    public final boolean aBs()
    {
      AppMethodBeat.i(148380);
      Object localObject2 = u.arm();
      Object localObject1;
      int i;
      if ("  getRegionCode ".concat(String.valueOf(localObject2)) != null)
      {
        localObject1 = ((au)localObject2).evF;
        ad.d("upload", (String)localObject1);
        localObject1 = ((au)localObject2).evF;
        if ((localObject1 != null) && (((String)localObject1).length() > 0) && (this.htR != null) && (this.htR.size() > 0))
        {
          localObject1 = ((String)localObject1).split("_");
          if ((localObject1 != null) && (localObject1.length > 0)) {
            i = 0;
          }
        }
      }
      else
      {
        for (;;)
        {
          if (i >= localObject1.length) {
            break label187;
          }
          if ((localObject1[i] != null) && (localObject1[i].length() > 0))
          {
            localObject2 = this.htR.iterator();
            for (;;)
            {
              if (((Iterator)localObject2).hasNext()) {
                if (((String)((Iterator)localObject2).next()).trim().toLowerCase().equals(localObject1[i].trim().toLowerCase()))
                {
                  ad.d("upload", "isInRegion");
                  AppMethodBeat.o(148380);
                  return true;
                  localObject1 = "";
                  break;
                }
              }
            }
          }
          i += 1;
        }
      }
      label187:
      AppMethodBeat.o(148380);
      return false;
    }
    
    public final int aBt()
    {
      switch (d.chatType)
      {
      default: 
        return this.htI;
      case 0: 
        return this.htI;
      case 1: 
        return this.htJ;
      }
      return this.htK;
    }
    
    public final boolean aBv()
    {
      AppMethodBeat.i(148381);
      if (1 == com.tencent.mm.audio.b.g.x("EnableSpeexVoiceUpload", 0))
      {
        AppMethodBeat.o(148381);
        return true;
      }
      ad.d("upload", "type " + d.chatType);
      int j = aBu();
      int i = aBt();
      com.tencent.mm.kernel.g.afC();
      Integer localInteger = Integer.valueOf(bt.l((Integer)com.tencent.mm.kernel.g.afB().afk().get(16646145, null)));
      ad.d("upload", "daycount " + aBu() + "  count " + localInteger + " rate " + i);
      if (localInteger.intValue() > j)
      {
        AppMethodBeat.o(148381);
        return false;
      }
      if (i == 0)
      {
        AppMethodBeat.o(148381);
        return false;
      }
      if (!ay.isWifi(aj.getContext()))
      {
        AppMethodBeat.o(148381);
        return false;
      }
      com.tencent.mm.kernel.g.afC();
      j = bt.a((Integer)com.tencent.mm.kernel.g.afB().afk().get(12290, null), 0);
      boolean bool;
      if (this.evp == 0) {
        bool = true;
      }
      for (;;)
      {
        ad.d("upload", "fitSex " + this.evp + " " + bool + " " + this.evp);
        if (bool) {
          break;
        }
        AppMethodBeat.o(148381);
        return false;
        if (this.evp == j) {
          bool = true;
        } else {
          bool = false;
        }
      }
      if (!aBs())
      {
        AppMethodBeat.o(148381);
        return false;
      }
      j = this.htQ.nextInt(i);
      ad.d("upload", "luck ".concat(String.valueOf(j)));
      if (j == i / 2)
      {
        AppMethodBeat.o(148381);
        return true;
      }
      AppMethodBeat.o(148381);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.bh.d
 * JD-Core Version:    0.7.0.1
 */