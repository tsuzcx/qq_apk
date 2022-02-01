package com.tencent.mm.bg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.bb.p;
import com.tencent.mm.bb.t;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.ae;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public final class d$a
{
  public int exL;
  public String hUi;
  public int hUj;
  public int hUk;
  public int hUl;
  public int hUm;
  public int hUn;
  public int hUo;
  public int hUp;
  public int hUq;
  public int hUr;
  private Random hUs;
  public List<String> hUt;
  
  public d$a()
  {
    AppMethodBeat.i(148379);
    this.hUi = "BeiJing;GuangZhou;ShangHai;";
    this.exL = 0;
    this.hUj = 0;
    this.hUk = 2;
    this.hUl = 2;
    this.hUm = 2;
    this.hUn = 10240;
    this.hUo = 10240000;
    this.hUp = 100;
    this.hUq = 100;
    this.hUr = 100;
    this.hUs = new Random();
    this.hUt = null;
    AppMethodBeat.o(148379);
  }
  
  private int aIk()
  {
    switch (d.chatType)
    {
    default: 
      return this.hUp;
    case 0: 
      return this.hUp;
    case 1: 
      return this.hUq;
    }
    return this.hUr;
  }
  
  public static a aIm()
  {
    AppMethodBeat.i(148382);
    ac.d("upload", "parseFromFile");
    Object localObject1 = t.aGO();
    localObject1 = p.aGL() + ((p)localObject1).di(1, 9);
    int i = (int)i.aSp((String)localObject1);
    if (i == -1)
    {
      ac.e("upload", "read file failed " + i + (String)localObject1);
      AppMethodBeat.o(148382);
      return null;
    }
    Object localObject3 = i.aU((String)localObject1, 0, i);
    if (localObject3 == null)
    {
      ac.e("upload", "read file failed " + i + (String)localObject1);
      AppMethodBeat.o(148382);
      return null;
    }
    localObject1 = new String((byte[])localObject3);
    if (bs.isNullOrNil((String)localObject1))
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
      localObject3 = (a)d.aIh().get(Integer.valueOf(k));
      if (localObject3 != null)
      {
        AppMethodBeat.o(148382);
        return localObject3;
      }
      localObject3 = bv.L((String)localObject1, "Config");
      if (localObject3 == null)
      {
        ac.e("upload", "parse msg failed");
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
          ac.d("upload", "key ".concat(String.valueOf(localObject1)));
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
            locala.hUi = ((String)((Map)localObject3).get(localObject1));
            if ((locala.hUi == null) || (locala.hUi.length() <= 0)) {
              break label1473;
            }
            localObject1 = locala.hUi.split(";");
            locala.hUt = new ArrayList();
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
            locala.hUt.add(localObject1[j]);
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
            locala.exL = bs.getInt((String)((Map)localObject3).get(localObject1), 0);
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
            locala.hUj = bs.getInt((String)((Map)localObject3).get(localObject1), 0);
          }
        }
      }
      catch (Exception localException)
      {
        ac.e("upload", "exception:%s", new Object[] { bs.m(localException) });
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
          locala.hUn = bs.getInt((String)((Map)localObject3).get(localObject2), 0);
          break;
        }
      }
      if (((String)localObject2).equals("maxsize"))
      {
        localStringBuilder = new StringBuilder(".Config.Item");
        if (i == 0) {}
        for (localObject2 = "";; localObject2 = Integer.valueOf(i))
        {
          locala.hUo = bs.getInt((String)((Map)localObject3).get(localObject2), 0);
          break;
        }
      }
      if (((String)localObject2).equals("daycount_single"))
      {
        localStringBuilder = new StringBuilder(".Config.Item");
        if (i == 0) {}
        for (localObject2 = "";; localObject2 = Integer.valueOf(i))
        {
          locala.hUp = bs.getInt((String)((Map)localObject3).get(localObject2), 0);
          break;
        }
      }
      if (((String)localObject2).equals("daycount_chatroom"))
      {
        localStringBuilder = new StringBuilder(".Config.Item");
        if (i == 0) {}
        for (localObject2 = "";; localObject2 = Integer.valueOf(i))
        {
          locala.hUq = bs.getInt((String)((Map)localObject3).get(localObject2), 0);
          break;
        }
      }
      if (((String)localObject2).equals("daycount_app"))
      {
        localStringBuilder = new StringBuilder(".Config.Item");
        if (i == 0) {}
        for (localObject2 = "";; localObject2 = Integer.valueOf(i))
        {
          locala.hUr = bs.getInt((String)((Map)localObject3).get(localObject2), 0);
          break;
        }
      }
      if (((String)localObject2).equals("rate_single"))
      {
        localStringBuilder = new StringBuilder(".Config.Item");
        if (i == 0) {}
        for (localObject2 = "";; localObject2 = Integer.valueOf(i))
        {
          locala.hUk = bs.getInt((String)((Map)localObject3).get(localObject2), 0);
          break;
        }
      }
      if (((String)localObject2).equals("rate_chatroom"))
      {
        localStringBuilder = new StringBuilder(".Config.Item");
        if (i == 0) {}
        for (localObject2 = "";; localObject2 = Integer.valueOf(i))
        {
          locala.hUl = bs.getInt((String)((Map)localObject3).get(localObject2), 0);
          break;
        }
      }
      if (((String)localObject2).equals("rate_app"))
      {
        localStringBuilder = new StringBuilder(".Config.Item");
        if (i == 0) {}
        for (localObject2 = "";; localObject2 = Integer.valueOf(i))
        {
          locala.hUm = bs.getInt((String)((Map)localObject3).get(localObject2), 0);
          break;
        }
        label1155:
        ac.d("upload", "sex " + locala.exL);
        ac.d("upload", "rate_single " + locala.hUk);
        ac.d("upload", "rate_chatroom " + locala.hUl);
        ac.d("upload", "rate_app " + locala.hUm);
        ac.d("upload", "rate " + locala.hUj);
        ac.d("upload", "minsize " + locala.hUn);
        ac.d("upload", "maxsize " + locala.hUo);
        ac.d("upload", "daycount_single " + locala.hUp);
        ac.d("upload", "daycount_chatroom " + locala.hUq);
        ac.d("upload", "daycount_app " + locala.hUr);
        ac.d("upload", "region " + locala.hUi);
        d.aIh().o(Integer.valueOf(k), locala);
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
  
  public final boolean aIi()
  {
    AppMethodBeat.i(148380);
    Object localObject2 = u.ayc();
    Object localObject1;
    int i;
    if ("  getRegionCode ".concat(String.valueOf(localObject2)) != null)
    {
      localObject1 = ((av)localObject2).eyb;
      ac.d("upload", (String)localObject1);
      localObject1 = ((av)localObject2).eyb;
      if ((localObject1 != null) && (((String)localObject1).length() > 0) && (this.hUt != null) && (this.hUt.size() > 0))
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
          localObject2 = this.hUt.iterator();
          for (;;)
          {
            if (((Iterator)localObject2).hasNext()) {
              if (((String)((Iterator)localObject2).next()).trim().toLowerCase().equals(localObject1[i].trim().toLowerCase()))
              {
                ac.d("upload", "isInRegion");
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
  
  public final int aIj()
  {
    switch (d.chatType)
    {
    default: 
      return this.hUk;
    case 0: 
      return this.hUk;
    case 1: 
      return this.hUl;
    }
    return this.hUm;
  }
  
  public final boolean aIl()
  {
    AppMethodBeat.i(148381);
    if (1 == com.tencent.mm.audio.b.g.x("EnableSpeexVoiceUpload", 0))
    {
      AppMethodBeat.o(148381);
      return true;
    }
    ac.d("upload", "type " + d.chatType);
    int j = aIk();
    int i = aIj();
    com.tencent.mm.kernel.g.agS();
    Integer localInteger = Integer.valueOf(bs.m((Integer)com.tencent.mm.kernel.g.agR().agA().get(16646145, null)));
    ac.d("upload", "daycount " + aIk() + "  count " + localInteger + " rate " + i);
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
    if (!ax.isWifi(ai.getContext()))
    {
      AppMethodBeat.o(148381);
      return false;
    }
    com.tencent.mm.kernel.g.agS();
    j = bs.a((Integer)com.tencent.mm.kernel.g.agR().agA().get(12290, null), 0);
    boolean bool;
    if (this.exL == 0) {
      bool = true;
    }
    for (;;)
    {
      ac.d("upload", "fitSex " + this.exL + " " + bool + " " + this.exL);
      if (bool) {
        break;
      }
      AppMethodBeat.o(148381);
      return false;
      if (this.exL == j) {
        bool = true;
      } else {
        bool = false;
      }
    }
    if (!aIi())
    {
      AppMethodBeat.o(148381);
      return false;
    }
    j = this.hUs.nextInt(i);
    ac.d("upload", "luck ".concat(String.valueOf(j)));
    if (j == i / 2)
    {
      AppMethodBeat.o(148381);
      return true;
    }
    AppMethodBeat.o(148381);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bg.d.a
 * JD-Core Version:    0.7.0.1
 */