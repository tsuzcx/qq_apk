package com.tencent.mm.bg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.b.h;
import com.tencent.mm.bb.t;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.v;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.aj;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public final class d
  implements com.tencent.mm.ak.f
{
  public static int chatType;
  private static final com.tencent.mm.b.f<Integer, a> fVO;
  private static d iqw;
  public boolean gnW = false;
  private int ilG = 3;
  
  static
  {
    AppMethodBeat.i(148389);
    fVO = new h(5);
    chatType = 0;
    AppMethodBeat.o(148389);
  }
  
  public static int Hc(String paramString)
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
    ae.d("upload", "type ".concat(String.valueOf(i)));
    AppMethodBeat.o(148383);
    return i;
  }
  
  public static d aLM()
  {
    AppMethodBeat.i(148384);
    if (iqw == null) {
      iqw = new d();
    }
    d locald = iqw;
    AppMethodBeat.o(148384);
    return locald;
  }
  
  public static void aLN()
  {
    AppMethodBeat.i(148387);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajR().ajA().set(16646145, Integer.valueOf(0));
    AppMethodBeat.o(148387);
  }
  
  public static void aLO()
  {
    AppMethodBeat.i(148388);
    com.tencent.mm.kernel.g.ajS();
    Integer localInteger2 = Integer.valueOf(bu.o((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(16646145, null)));
    Integer localInteger1 = localInteger2;
    if (localInteger2.intValue() < 0) {
      localInteger1 = Integer.valueOf(0);
    }
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajR().ajA().set(16646145, Integer.valueOf(localInteger1.intValue() + 1));
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
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(148386);
    if ((!(paramn instanceof com.tencent.mm.ak.p)) || (((com.tencent.mm.ak.p)paramn).aFc() != 9))
    {
      ae.d("upload", "another scene");
      AppMethodBeat.o(148386);
      return;
    }
    if (paramn.getType() == 159)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label91;
      }
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajR().ajA().set(81944, Long.valueOf(bu.aRi()));
    }
    for (;;)
    {
      release();
      AppMethodBeat.o(148386);
      return;
      label91:
      paramInt1 = this.ilG - 1;
      this.ilG = paramInt1;
      if (paramInt1 < 0)
      {
        com.tencent.mm.kernel.g.ajS();
        com.tencent.mm.kernel.g.ajR().ajA().set(81944, Long.valueOf((bu.fpO() - 86400000L + 3600000L) / 1000L));
        this.ilG = 3;
      }
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(148385);
    this.gnW = false;
    com.tencent.mm.kernel.g.ajj().b(159, this);
    AppMethodBeat.o(148385);
  }
  
  public static final class a
  {
    public int eQV;
    public int iqA;
    public int iqB;
    public int iqC;
    public int iqD;
    public int iqE;
    public int iqF;
    public int iqG;
    private Random iqH;
    public List<String> iqI;
    public String iqx;
    public int iqy;
    public int iqz;
    
    public a()
    {
      AppMethodBeat.i(148379);
      this.iqx = "BeiJing;GuangZhou;ShangHai;";
      this.eQV = 0;
      this.iqy = 0;
      this.iqz = 2;
      this.iqA = 2;
      this.iqB = 2;
      this.iqC = 10240;
      this.iqD = 10240000;
      this.iqE = 100;
      this.iqF = 100;
      this.iqG = 100;
      this.iqH = new Random();
      this.iqI = null;
      AppMethodBeat.o(148379);
    }
    
    private int aLR()
    {
      switch (d.chatType)
      {
      default: 
        return this.iqE;
      case 0: 
        return this.iqE;
      case 1: 
        return this.iqF;
      }
      return this.iqG;
    }
    
    public static a aLT()
    {
      AppMethodBeat.i(148382);
      ae.d("upload", "parseFromFile");
      Object localObject1 = t.aKs();
      localObject1 = com.tencent.mm.bb.p.aKp() + ((com.tencent.mm.bb.p)localObject1).dl(1, 9);
      int i = (int)o.aZR((String)localObject1);
      if (i == -1)
      {
        ae.e("upload", "read file failed " + i + (String)localObject1);
        AppMethodBeat.o(148382);
        return null;
      }
      Object localObject3 = o.bb((String)localObject1, 0, i);
      if (localObject3 == null)
      {
        ae.e("upload", "read file failed " + i + (String)localObject1);
        AppMethodBeat.o(148382);
        return null;
      }
      localObject1 = new String((byte[])localObject3);
      if (bu.isNullOrNil((String)localObject1))
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
        localObject3 = (a)d.aLP().get(Integer.valueOf(k));
        if (localObject3 != null)
        {
          AppMethodBeat.o(148382);
          return localObject3;
        }
        localObject3 = bx.M((String)localObject1, "Config");
        if (localObject3 == null)
        {
          ae.e("upload", "parse msg failed");
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
            ae.d("upload", "key ".concat(String.valueOf(localObject1)));
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
              locala.iqx = ((String)((Map)localObject3).get(localObject1));
              if ((locala.iqx == null) || (locala.iqx.length() <= 0)) {
                break label1473;
              }
              localObject1 = locala.iqx.split(";");
              locala.iqI = new ArrayList();
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
              locala.iqI.add(localObject1[j]);
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
              locala.eQV = bu.getInt((String)((Map)localObject3).get(localObject1), 0);
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
              locala.iqy = bu.getInt((String)((Map)localObject3).get(localObject1), 0);
            }
          }
        }
        catch (Exception localException)
        {
          ae.e("upload", "exception:%s", new Object[] { bu.o(localException) });
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
            locala.iqC = bu.getInt((String)((Map)localObject3).get(localObject2), 0);
            break;
          }
        }
        if (((String)localObject2).equals("maxsize"))
        {
          localStringBuilder = new StringBuilder(".Config.Item");
          if (i == 0) {}
          for (localObject2 = "";; localObject2 = Integer.valueOf(i))
          {
            locala.iqD = bu.getInt((String)((Map)localObject3).get(localObject2), 0);
            break;
          }
        }
        if (((String)localObject2).equals("daycount_single"))
        {
          localStringBuilder = new StringBuilder(".Config.Item");
          if (i == 0) {}
          for (localObject2 = "";; localObject2 = Integer.valueOf(i))
          {
            locala.iqE = bu.getInt((String)((Map)localObject3).get(localObject2), 0);
            break;
          }
        }
        if (((String)localObject2).equals("daycount_chatroom"))
        {
          localStringBuilder = new StringBuilder(".Config.Item");
          if (i == 0) {}
          for (localObject2 = "";; localObject2 = Integer.valueOf(i))
          {
            locala.iqF = bu.getInt((String)((Map)localObject3).get(localObject2), 0);
            break;
          }
        }
        if (((String)localObject2).equals("daycount_app"))
        {
          localStringBuilder = new StringBuilder(".Config.Item");
          if (i == 0) {}
          for (localObject2 = "";; localObject2 = Integer.valueOf(i))
          {
            locala.iqG = bu.getInt((String)((Map)localObject3).get(localObject2), 0);
            break;
          }
        }
        if (((String)localObject2).equals("rate_single"))
        {
          localStringBuilder = new StringBuilder(".Config.Item");
          if (i == 0) {}
          for (localObject2 = "";; localObject2 = Integer.valueOf(i))
          {
            locala.iqz = bu.getInt((String)((Map)localObject3).get(localObject2), 0);
            break;
          }
        }
        if (((String)localObject2).equals("rate_chatroom"))
        {
          localStringBuilder = new StringBuilder(".Config.Item");
          if (i == 0) {}
          for (localObject2 = "";; localObject2 = Integer.valueOf(i))
          {
            locala.iqA = bu.getInt((String)((Map)localObject3).get(localObject2), 0);
            break;
          }
        }
        if (((String)localObject2).equals("rate_app"))
        {
          localStringBuilder = new StringBuilder(".Config.Item");
          if (i == 0) {}
          for (localObject2 = "";; localObject2 = Integer.valueOf(i))
          {
            locala.iqB = bu.getInt((String)((Map)localObject3).get(localObject2), 0);
            break;
          }
          label1155:
          ae.d("upload", "sex " + locala.eQV);
          ae.d("upload", "rate_single " + locala.iqz);
          ae.d("upload", "rate_chatroom " + locala.iqA);
          ae.d("upload", "rate_app " + locala.iqB);
          ae.d("upload", "rate " + locala.iqy);
          ae.d("upload", "minsize " + locala.iqC);
          ae.d("upload", "maxsize " + locala.iqD);
          ae.d("upload", "daycount_single " + locala.iqE);
          ae.d("upload", "daycount_chatroom " + locala.iqF);
          ae.d("upload", "daycount_app " + locala.iqG);
          ae.d("upload", "region " + locala.iqx);
          d.aLP().q(Integer.valueOf(k), locala);
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
    
    public final boolean aLQ()
    {
      AppMethodBeat.i(148380);
      Object localObject2 = v.aBo();
      Object localObject1;
      int i;
      if ("  getRegionCode ".concat(String.valueOf(localObject2)) != null)
      {
        localObject1 = ((aw)localObject2).eRl;
        ae.d("upload", (String)localObject1);
        localObject1 = ((aw)localObject2).eRl;
        if ((localObject1 != null) && (((String)localObject1).length() > 0) && (this.iqI != null) && (this.iqI.size() > 0))
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
            localObject2 = this.iqI.iterator();
            for (;;)
            {
              if (((Iterator)localObject2).hasNext()) {
                if (((String)((Iterator)localObject2).next()).trim().toLowerCase().equals(localObject1[i].trim().toLowerCase()))
                {
                  ae.d("upload", "isInRegion");
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
    
    public final boolean aLS()
    {
      AppMethodBeat.i(148381);
      if (1 == com.tencent.mm.audio.b.g.A("EnableSpeexVoiceUpload", 0))
      {
        AppMethodBeat.o(148381);
        return true;
      }
      ae.d("upload", "type " + d.chatType);
      int j = aLR();
      int i = getRate();
      com.tencent.mm.kernel.g.ajS();
      Integer localInteger = Integer.valueOf(bu.o((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(16646145, null)));
      ae.d("upload", "daycount " + aLR() + "  count " + localInteger + " rate " + i);
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
      if (!az.isWifi(ak.getContext()))
      {
        AppMethodBeat.o(148381);
        return false;
      }
      com.tencent.mm.kernel.g.ajS();
      j = bu.a((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(12290, null), 0);
      boolean bool;
      if (this.eQV == 0) {
        bool = true;
      }
      for (;;)
      {
        ae.d("upload", "fitSex " + this.eQV + " " + bool + " " + this.eQV);
        if (bool) {
          break;
        }
        AppMethodBeat.o(148381);
        return false;
        if (this.eQV == j) {
          bool = true;
        } else {
          bool = false;
        }
      }
      if (!aLQ())
      {
        AppMethodBeat.o(148381);
        return false;
      }
      j = this.iqH.nextInt(i);
      ae.d("upload", "luck ".concat(String.valueOf(j)));
      if (j == i / 2)
      {
        AppMethodBeat.o(148381);
        return true;
      }
      AppMethodBeat.o(148381);
      return false;
    }
    
    public final int getRate()
    {
      switch (d.chatType)
      {
      default: 
        return this.iqz;
      case 0: 
        return this.iqz;
      case 1: 
        return this.iqA;
      }
      return this.iqB;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bg.d
 * JD-Core Version:    0.7.0.1
 */