package com.tencent.mm.bf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.ba.n;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public final class d$a
{
  public int dqC;
  public String fQZ;
  public int fRa;
  public int fRb;
  public int fRc;
  public int fRd;
  public int fRe;
  public int fRf;
  public int fRg;
  public int fRh;
  public int fRi;
  private Random fRj;
  public List<String> fRk;
  
  public d$a()
  {
    AppMethodBeat.i(116543);
    this.fQZ = "BeiJing;GuangZhou;ShangHai;";
    this.dqC = 0;
    this.fRa = 0;
    this.fRb = 2;
    this.fRc = 2;
    this.fRd = 2;
    this.fRe = 10240;
    this.fRf = 10240000;
    this.fRg = 100;
    this.fRh = 100;
    this.fRi = 100;
    this.fRj = new Random();
    this.fRk = null;
    AppMethodBeat.o(116543);
  }
  
  private int akp()
  {
    switch (d.chatType)
    {
    default: 
      return this.fRg;
    case 0: 
      return this.fRg;
    case 1: 
      return this.fRh;
    }
    return this.fRi;
  }
  
  public static a akr()
  {
    AppMethodBeat.i(116546);
    ab.d("upload", "parseFromFile");
    Object localObject1 = com.tencent.mm.ba.r.aiP();
    localObject1 = n.aiM() + ((n)localObject1).cB(1, 9);
    int i = (int)com.tencent.mm.vfs.e.avI((String)localObject1);
    if (i == -1)
    {
      ab.e("upload", "read file failed " + i + (String)localObject1);
      AppMethodBeat.o(116546);
      return null;
    }
    Object localObject3 = com.tencent.mm.vfs.e.i((String)localObject1, 0, i);
    if (localObject3 == null)
    {
      ab.e("upload", "read file failed " + i + (String)localObject1);
      AppMethodBeat.o(116546);
      return null;
    }
    localObject1 = new String((byte[])localObject3);
    if (bo.isNullOrNil((String)localObject1))
    {
      AppMethodBeat.o(116546);
      return null;
    }
    i = ((String)localObject1).indexOf('<');
    int k;
    if (i > 0)
    {
      localObject1 = ((String)localObject1).substring(i);
      k = ((String)localObject1).hashCode();
      localObject3 = (a)d.akm().get(Integer.valueOf(k));
      if (localObject3 != null)
      {
        AppMethodBeat.o(116546);
        return localObject3;
      }
      localObject3 = br.F((String)localObject1, "Config");
      if (localObject3 == null)
      {
        ab.e("upload", "parse msg failed");
        AppMethodBeat.o(116546);
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
          ab.d("upload", "key ".concat(String.valueOf(localObject1)));
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
            locala.fQZ = ((String)((Map)localObject3).get(localObject1));
            if ((locala.fQZ == null) || (locala.fQZ.length() <= 0)) {
              break label1473;
            }
            localObject1 = locala.fQZ.split(";");
            locala.fRk = new ArrayList();
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
            locala.fRk.add(localObject1[j]);
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
            locala.dqC = bo.getInt((String)((Map)localObject3).get(localObject1), 0);
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
            locala.fRa = bo.getInt((String)((Map)localObject3).get(localObject1), 0);
          }
        }
      }
      catch (Exception localException)
      {
        ab.e("upload", "exception:%s", new Object[] { bo.l(localException) });
        AppMethodBeat.o(116546);
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
          locala.fRe = bo.getInt((String)((Map)localObject3).get(localObject2), 0);
          break;
        }
      }
      if (((String)localObject2).equals("maxsize"))
      {
        localStringBuilder = new StringBuilder(".Config.Item");
        if (i == 0) {}
        for (localObject2 = "";; localObject2 = Integer.valueOf(i))
        {
          locala.fRf = bo.getInt((String)((Map)localObject3).get(localObject2), 0);
          break;
        }
      }
      if (((String)localObject2).equals("daycount_single"))
      {
        localStringBuilder = new StringBuilder(".Config.Item");
        if (i == 0) {}
        for (localObject2 = "";; localObject2 = Integer.valueOf(i))
        {
          locala.fRg = bo.getInt((String)((Map)localObject3).get(localObject2), 0);
          break;
        }
      }
      if (((String)localObject2).equals("daycount_chatroom"))
      {
        localStringBuilder = new StringBuilder(".Config.Item");
        if (i == 0) {}
        for (localObject2 = "";; localObject2 = Integer.valueOf(i))
        {
          locala.fRh = bo.getInt((String)((Map)localObject3).get(localObject2), 0);
          break;
        }
      }
      if (((String)localObject2).equals("daycount_app"))
      {
        localStringBuilder = new StringBuilder(".Config.Item");
        if (i == 0) {}
        for (localObject2 = "";; localObject2 = Integer.valueOf(i))
        {
          locala.fRi = bo.getInt((String)((Map)localObject3).get(localObject2), 0);
          break;
        }
      }
      if (((String)localObject2).equals("rate_single"))
      {
        localStringBuilder = new StringBuilder(".Config.Item");
        if (i == 0) {}
        for (localObject2 = "";; localObject2 = Integer.valueOf(i))
        {
          locala.fRb = bo.getInt((String)((Map)localObject3).get(localObject2), 0);
          break;
        }
      }
      if (((String)localObject2).equals("rate_chatroom"))
      {
        localStringBuilder = new StringBuilder(".Config.Item");
        if (i == 0) {}
        for (localObject2 = "";; localObject2 = Integer.valueOf(i))
        {
          locala.fRc = bo.getInt((String)((Map)localObject3).get(localObject2), 0);
          break;
        }
      }
      if (((String)localObject2).equals("rate_app"))
      {
        localStringBuilder = new StringBuilder(".Config.Item");
        if (i == 0) {}
        for (localObject2 = "";; localObject2 = Integer.valueOf(i))
        {
          locala.fRd = bo.getInt((String)((Map)localObject3).get(localObject2), 0);
          break;
        }
        label1155:
        ab.d("upload", "sex " + locala.dqC);
        ab.d("upload", "rate_single " + locala.fRb);
        ab.d("upload", "rate_chatroom " + locala.fRc);
        ab.d("upload", "rate_app " + locala.fRd);
        ab.d("upload", "rate " + locala.fRa);
        ab.d("upload", "minsize " + locala.fRe);
        ab.d("upload", "maxsize " + locala.fRf);
        ab.d("upload", "daycount_single " + locala.fRg);
        ab.d("upload", "daycount_chatroom " + locala.fRh);
        ab.d("upload", "daycount_app " + locala.fRi);
        ab.d("upload", "region " + locala.fQZ);
        d.akm().f(Integer.valueOf(k), locala);
        AppMethodBeat.o(116546);
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
  
  public final boolean akn()
  {
    AppMethodBeat.i(116544);
    Object localObject2 = com.tencent.mm.model.r.ZS();
    Object localObject1;
    int i;
    if ("  getRegionCode ".concat(String.valueOf(localObject2)) != null)
    {
      localObject1 = ((aq)localObject2).dqQ;
      ab.d("upload", (String)localObject1);
      localObject1 = ((aq)localObject2).dqQ;
      if ((localObject1 != null) && (((String)localObject1).length() > 0) && (this.fRk != null) && (this.fRk.size() > 0))
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
          localObject2 = this.fRk.iterator();
          for (;;)
          {
            if (((Iterator)localObject2).hasNext()) {
              if (((String)((Iterator)localObject2).next()).trim().toLowerCase().equals(localObject1[i].trim().toLowerCase()))
              {
                ab.d("upload", "isInRegion");
                AppMethodBeat.o(116544);
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
    AppMethodBeat.o(116544);
    return false;
  }
  
  public final int ako()
  {
    switch (d.chatType)
    {
    default: 
      return this.fRb;
    case 0: 
      return this.fRb;
    case 1: 
      return this.fRc;
    }
    return this.fRd;
  }
  
  public final boolean akq()
  {
    AppMethodBeat.i(116545);
    if (1 == com.tencent.mm.audio.b.g.x("EnableSpeexVoiceUpload", 0))
    {
      AppMethodBeat.o(116545);
      return true;
    }
    ab.d("upload", "type " + d.chatType);
    int j = akp();
    int i = ako();
    com.tencent.mm.kernel.g.RM();
    Integer localInteger = Integer.valueOf(bo.g((Integer)com.tencent.mm.kernel.g.RL().Ru().get(16646145, null)));
    ab.d("upload", "daycount " + akp() + "  count " + localInteger + " rate " + i);
    if (localInteger.intValue() > j)
    {
      AppMethodBeat.o(116545);
      return false;
    }
    if (i == 0)
    {
      AppMethodBeat.o(116545);
      return false;
    }
    if (!at.isWifi(ah.getContext()))
    {
      AppMethodBeat.o(116545);
      return false;
    }
    com.tencent.mm.kernel.g.RM();
    j = bo.a((Integer)com.tencent.mm.kernel.g.RL().Ru().get(12290, null), 0);
    boolean bool;
    if (this.dqC == 0) {
      bool = true;
    }
    for (;;)
    {
      ab.d("upload", "fitSex " + this.dqC + " " + bool + " " + this.dqC);
      if (bool) {
        break;
      }
      AppMethodBeat.o(116545);
      return false;
      if (this.dqC == j) {
        bool = true;
      } else {
        bool = false;
      }
    }
    if (!akn())
    {
      AppMethodBeat.o(116545);
      return false;
    }
    j = this.fRj.nextInt(i);
    ab.d("upload", "luck ".concat(String.valueOf(j)));
    if (j == i / 2)
    {
      AppMethodBeat.o(116545);
      return true;
    }
    AppMethodBeat.o(116545);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.bf.d.a
 * JD-Core Version:    0.7.0.1
 */