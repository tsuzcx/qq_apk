package com.tencent.mm.live.core.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.e.c;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/core/render/BeautyConfig;", "", "configMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "(Ljava/util/HashMap;)V", "getConfigMap", "()Ljava/util/HashMap;", "eyeBright", "getEyeBright", "()I", "setEyeBright", "(I)V", "eyeMorph", "getEyeMorph", "setEyeMorph", "faceMorph", "getFaceMorph", "setFaceMorph", "rosy", "getRosy", "setRosy", "skinBright", "getSkinBright", "setSkinBright", "skinSmooth", "getSkinSmooth", "setSkinSmooth", "component1", "copy", "enable", "", "enableBright", "enableRosy", "enableShape", "enableSkin", "equals", "other", "hashCode", "toString", "", "plugin-core_release"})
public final class a
{
  private int hDb;
  private int hDc;
  private int hDd;
  private int hDe;
  private int hDf;
  private int hDg;
  public final HashMap<Integer, Integer> hDh;
  
  private a(HashMap<Integer, Integer> paramHashMap)
  {
    AppMethodBeat.i(196607);
    this.hDh = paramHashMap;
    this.hDb = -1;
    this.hDc = -1;
    this.hDd = -1;
    this.hDe = -1;
    this.hDf = -1;
    this.hDg = -1;
    AppMethodBeat.o(196607);
  }
  
  public final int aEl()
  {
    AppMethodBeat.i(196597);
    Object localObject = this.hDh;
    e.c localc = e.c.hxm;
    localObject = (Integer)((HashMap)localObject).get(Integer.valueOf(e.c.aCh()));
    if (localObject != null)
    {
      int i = ((Integer)localObject).intValue();
      AppMethodBeat.o(196597);
      return i;
    }
    AppMethodBeat.o(196597);
    return -1;
  }
  
  public final int aEm()
  {
    AppMethodBeat.i(196598);
    Object localObject = this.hDh;
    e.c localc = e.c.hxm;
    localObject = (Integer)((HashMap)localObject).get(Integer.valueOf(e.c.aCl()));
    if (localObject != null)
    {
      int i = ((Integer)localObject).intValue();
      AppMethodBeat.o(196598);
      return i;
    }
    AppMethodBeat.o(196598);
    return -1;
  }
  
  public final int aEn()
  {
    AppMethodBeat.i(196599);
    Object localObject = this.hDh;
    e.c localc = e.c.hxm;
    localObject = (Integer)((HashMap)localObject).get(Integer.valueOf(e.c.aCi()));
    if (localObject != null)
    {
      int i = ((Integer)localObject).intValue();
      AppMethodBeat.o(196599);
      return i;
    }
    AppMethodBeat.o(196599);
    return -1;
  }
  
  public final int aEo()
  {
    AppMethodBeat.i(196600);
    Object localObject = this.hDh;
    e.c localc = e.c.hxm;
    localObject = (Integer)((HashMap)localObject).get(Integer.valueOf(e.c.aCj()));
    if (localObject != null)
    {
      int i = ((Integer)localObject).intValue();
      AppMethodBeat.o(196600);
      return i;
    }
    AppMethodBeat.o(196600);
    return -1;
  }
  
  public final int aEp()
  {
    AppMethodBeat.i(196601);
    Object localObject = this.hDh;
    e.c localc = e.c.hxm;
    localObject = (Integer)((HashMap)localObject).get(Integer.valueOf(e.c.aCm()));
    if (localObject != null)
    {
      int i = ((Integer)localObject).intValue();
      AppMethodBeat.o(196601);
      return i;
    }
    AppMethodBeat.o(196601);
    return -1;
  }
  
  public final int aEq()
  {
    AppMethodBeat.i(196602);
    Object localObject = this.hDh;
    e.c localc = e.c.hxm;
    localObject = (Integer)((HashMap)localObject).get(Integer.valueOf(e.c.aCk()));
    if (localObject != null)
    {
      int i = ((Integer)localObject).intValue();
      AppMethodBeat.o(196602);
      return i;
    }
    AppMethodBeat.o(196602);
    return -1;
  }
  
  public final boolean aEr()
  {
    AppMethodBeat.i(196603);
    if (aEl() >= 0)
    {
      AppMethodBeat.o(196603);
      return true;
    }
    AppMethodBeat.o(196603);
    return false;
  }
  
  public final boolean aEs()
  {
    AppMethodBeat.i(196604);
    if ((aEm() >= 0) || (aEn() >= 0))
    {
      AppMethodBeat.o(196604);
      return true;
    }
    AppMethodBeat.o(196604);
    return false;
  }
  
  public final boolean aEt()
  {
    AppMethodBeat.i(196605);
    if ((aEo() >= 0) || (aEp() >= 0))
    {
      AppMethodBeat.o(196605);
      return true;
    }
    AppMethodBeat.o(196605);
    return false;
  }
  
  public final boolean aEu()
  {
    AppMethodBeat.i(196606);
    if (aEq() >= 0)
    {
      AppMethodBeat.o(196606);
      return true;
    }
    AppMethodBeat.o(196606);
    return false;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(196611);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if (!p.j(this.hDh, paramObject.hDh)) {}
      }
    }
    else
    {
      AppMethodBeat.o(196611);
      return true;
    }
    AppMethodBeat.o(196611);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(196610);
    HashMap localHashMap = this.hDh;
    if (localHashMap != null)
    {
      int i = localHashMap.hashCode();
      AppMethodBeat.o(196610);
      return i;
    }
    AppMethodBeat.o(196610);
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(196609);
    String str = "BeautyConfig(configMap=" + this.hDh + ")";
    AppMethodBeat.o(196609);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.core.b.a
 * JD-Core Version:    0.7.0.1
 */