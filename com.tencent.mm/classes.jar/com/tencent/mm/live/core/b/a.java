package com.tencent.mm.live.core.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/core/render/BeautyConfig;", "", "configMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "(Ljava/util/HashMap;)V", "cheekBone", "getCheekBone", "()I", "getConfigMap", "()Ljava/util/HashMap;", "eyeBright", "getEyeBright", "eyeMorph", "getEyeMorph", "eyePouch", "getEyePouch", "faceMorph", "getFaceMorph", "jawBone", "getJawBone", "rosy", "getRosy", "sharpen", "getSharpen", "skinBright", "getSkinBright", "skinSmooth", "getSkinSmooth", "smallHead", "getSmallHead", "smileFolds", "getSmileFolds", "teethBright", "getTeethBright", "wingOfNose", "getWingOfNose", "component1", "copy", "enable", "", "enableBright", "enableRosy", "enableShape", "enableSkin", "equals", "other", "hashCode", "toString", "", "plugin-core_release"})
public final class a
{
  public final HashMap<Integer, Integer> kra;
  
  private a(HashMap<Integer, Integer> paramHashMap)
  {
    AppMethodBeat.i(199216);
    this.kra = paramHashMap;
    AppMethodBeat.o(199216);
  }
  
  public final int aMA()
  {
    AppMethodBeat.i(199196);
    Integer localInteger = (Integer)this.kra.get(Integer.valueOf(8));
    if (localInteger != null)
    {
      int i = localInteger.intValue();
      AppMethodBeat.o(199196);
      return i;
    }
    AppMethodBeat.o(199196);
    return -1;
  }
  
  public final int aMB()
  {
    AppMethodBeat.i(199198);
    Integer localInteger = (Integer)this.kra.get(Integer.valueOf(9));
    if (localInteger != null)
    {
      int i = localInteger.intValue();
      AppMethodBeat.o(199198);
      return i;
    }
    AppMethodBeat.o(199198);
    return -1;
  }
  
  public final int aMC()
  {
    AppMethodBeat.i(199200);
    Integer localInteger = (Integer)this.kra.get(Integer.valueOf(10));
    if (localInteger != null)
    {
      int i = localInteger.intValue();
      AppMethodBeat.o(199200);
      return i;
    }
    AppMethodBeat.o(199200);
    return -1;
  }
  
  public final int aMD()
  {
    AppMethodBeat.i(199201);
    Integer localInteger = (Integer)this.kra.get(Integer.valueOf(11));
    if (localInteger != null)
    {
      int i = localInteger.intValue();
      AppMethodBeat.o(199201);
      return i;
    }
    AppMethodBeat.o(199201);
    return -1;
  }
  
  public final int aME()
  {
    AppMethodBeat.i(199202);
    Integer localInteger = (Integer)this.kra.get(Integer.valueOf(12));
    if (localInteger != null)
    {
      int i = localInteger.intValue();
      AppMethodBeat.o(199202);
      return i;
    }
    AppMethodBeat.o(199202);
    return -1;
  }
  
  public final int aMF()
  {
    AppMethodBeat.i(199203);
    Integer localInteger = (Integer)this.kra.get(Integer.valueOf(13));
    if (localInteger != null)
    {
      int i = localInteger.intValue();
      AppMethodBeat.o(199203);
      return i;
    }
    AppMethodBeat.o(199203);
    return -1;
  }
  
  public final boolean aMG()
  {
    AppMethodBeat.i(199204);
    if (aMs() >= 0)
    {
      AppMethodBeat.o(199204);
      return true;
    }
    AppMethodBeat.o(199204);
    return false;
  }
  
  public final boolean aMH()
  {
    AppMethodBeat.i(199205);
    if ((aMt() >= 0) || (aMu() >= 0))
    {
      AppMethodBeat.o(199205);
      return true;
    }
    AppMethodBeat.o(199205);
    return false;
  }
  
  public final boolean aMI()
  {
    AppMethodBeat.i(199206);
    if ((aMv() >= 0) || (aMw() >= 0))
    {
      AppMethodBeat.o(199206);
      return true;
    }
    AppMethodBeat.o(199206);
    return false;
  }
  
  public final boolean aMJ()
  {
    AppMethodBeat.i(199208);
    if (aMx() >= 0)
    {
      AppMethodBeat.o(199208);
      return true;
    }
    AppMethodBeat.o(199208);
    return false;
  }
  
  public final int aMs()
  {
    AppMethodBeat.i(199181);
    Integer localInteger = (Integer)this.kra.get(Integer.valueOf(0));
    if (localInteger != null)
    {
      int i = localInteger.intValue();
      AppMethodBeat.o(199181);
      return i;
    }
    AppMethodBeat.o(199181);
    return -1;
  }
  
  public final int aMt()
  {
    AppMethodBeat.i(199182);
    Integer localInteger = (Integer)this.kra.get(Integer.valueOf(4));
    if (localInteger != null)
    {
      int i = localInteger.intValue();
      AppMethodBeat.o(199182);
      return i;
    }
    AppMethodBeat.o(199182);
    return -1;
  }
  
  public final int aMu()
  {
    AppMethodBeat.i(199183);
    Integer localInteger = (Integer)this.kra.get(Integer.valueOf(1));
    if (localInteger != null)
    {
      int i = localInteger.intValue();
      AppMethodBeat.o(199183);
      return i;
    }
    AppMethodBeat.o(199183);
    return -1;
  }
  
  public final int aMv()
  {
    AppMethodBeat.i(199185);
    Integer localInteger = (Integer)this.kra.get(Integer.valueOf(2));
    if (localInteger != null)
    {
      int i = localInteger.intValue();
      AppMethodBeat.o(199185);
      return i;
    }
    AppMethodBeat.o(199185);
    return -1;
  }
  
  public final int aMw()
  {
    AppMethodBeat.i(199187);
    Integer localInteger = (Integer)this.kra.get(Integer.valueOf(5));
    if (localInteger != null)
    {
      int i = localInteger.intValue();
      AppMethodBeat.o(199187);
      return i;
    }
    AppMethodBeat.o(199187);
    return -1;
  }
  
  public final int aMx()
  {
    AppMethodBeat.i(199190);
    Integer localInteger = (Integer)this.kra.get(Integer.valueOf(3));
    if (localInteger != null)
    {
      int i = localInteger.intValue();
      AppMethodBeat.o(199190);
      return i;
    }
    AppMethodBeat.o(199190);
    return -1;
  }
  
  public final int aMy()
  {
    AppMethodBeat.i(199191);
    Integer localInteger = (Integer)this.kra.get(Integer.valueOf(6));
    if (localInteger != null)
    {
      int i = localInteger.intValue();
      AppMethodBeat.o(199191);
      return i;
    }
    AppMethodBeat.o(199191);
    return -1;
  }
  
  public final int aMz()
  {
    AppMethodBeat.i(199195);
    Integer localInteger = (Integer)this.kra.get(Integer.valueOf(7));
    if (localInteger != null)
    {
      int i = localInteger.intValue();
      AppMethodBeat.o(199195);
      return i;
    }
    AppMethodBeat.o(199195);
    return -1;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(199221);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if (!p.h(this.kra, paramObject.kra)) {}
      }
    }
    else
    {
      AppMethodBeat.o(199221);
      return true;
    }
    AppMethodBeat.o(199221);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(199219);
    HashMap localHashMap = this.kra;
    if (localHashMap != null)
    {
      int i = localHashMap.hashCode();
      AppMethodBeat.o(199219);
      return i;
    }
    AppMethodBeat.o(199219);
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(199214);
    String str = "BeautyConfig(skinSmooth=" + aMs() + ", eyeMorph=" + aMt() + ", faceMorph=" + aMu() + ", skinBright=" + aMv() + ", eyeBright=" + aMw() + ", rosy=" + aMx() + ", eyePouch=" + aMy() + ", smileFolds=" + aMz() + ", sharpen=" + aMA() + ", teethBright=" + aMB() + ", smallHead=" + aMC() + ", cheekBone=" + aMD() + ", jawBone=" + aME() + ", wingOfNose=" + aMF() + ')';
    AppMethodBeat.o(199214);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.b.a
 * JD-Core Version:    0.7.0.1
 */