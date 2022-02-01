package com.tencent.mm.live.core.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/render/BeautyConfig;", "", "configMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "(Ljava/util/HashMap;)V", "bigEye", "getBigEye", "()I", "boySlim", "getBoySlim", "cheekBone", "getCheekBone", "chin", "getChin", "getConfigMap", "()Ljava/util/HashMap;", "contour", "getContour", "eyeBright", "getEyeBright", "eyeMorph", "getEyeMorph", "eyePouch", "getEyePouch", "faceMorph", "getFaceMorph", "girlSlim", "getGirlSlim", "hairLine", "getHairLine", "isNewSmoothFace", "", "()Z", "setNewSmoothFace", "(Z)V", "jawBone", "getJawBone", "mouthMorph", "getMouthMorph", "rosy", "getRosy", "sharpen", "getSharpen", "skinBright", "getSkinBright", "skinSmooth", "getSkinSmooth", "smallHead", "getSmallHead", "smileFolds", "getSmileFolds", "teethBright", "getTeethBright", "wingOfNose", "getWingOfNose", "zhaiLian", "getZhaiLian", "component1", "copy", "enable", "enableBright", "enableRosy", "enableShape", "enableSkin", "equals", "other", "hashCode", "toString", "", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public final HashMap<Integer, Integer> mUV;
  public boolean mUW;
  
  private a(HashMap<Integer, Integer> paramHashMap)
  {
    AppMethodBeat.i(247711);
    this.mUV = paramHashMap;
    this.mUW = true;
    AppMethodBeat.o(247711);
  }
  
  public final int bfU()
  {
    AppMethodBeat.i(247727);
    Integer localInteger = (Integer)this.mUV.get(Integer.valueOf(0));
    if (localInteger == null)
    {
      AppMethodBeat.o(247727);
      return -1;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(247727);
    return i;
  }
  
  public final int bfV()
  {
    AppMethodBeat.i(247735);
    Integer localInteger = (Integer)this.mUV.get(Integer.valueOf(4));
    if (localInteger == null)
    {
      AppMethodBeat.o(247735);
      return -1;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(247735);
    return i;
  }
  
  public final int bfW()
  {
    AppMethodBeat.i(247741);
    Integer localInteger = (Integer)this.mUV.get(Integer.valueOf(1));
    if (localInteger == null)
    {
      AppMethodBeat.o(247741);
      return -1;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(247741);
    return i;
  }
  
  public final int bfX()
  {
    AppMethodBeat.i(247748);
    Integer localInteger = (Integer)this.mUV.get(Integer.valueOf(2));
    if (localInteger == null)
    {
      AppMethodBeat.o(247748);
      return -1;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(247748);
    return i;
  }
  
  public final int bfY()
  {
    AppMethodBeat.i(247755);
    Integer localInteger = (Integer)this.mUV.get(Integer.valueOf(5));
    if (localInteger == null)
    {
      AppMethodBeat.o(247755);
      return -1;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(247755);
    return i;
  }
  
  public final int bfZ()
  {
    AppMethodBeat.i(247760);
    Integer localInteger = (Integer)this.mUV.get(Integer.valueOf(3));
    if (localInteger == null)
    {
      AppMethodBeat.o(247760);
      return -1;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(247760);
    return i;
  }
  
  public final int bga()
  {
    AppMethodBeat.i(247769);
    Integer localInteger = (Integer)this.mUV.get(Integer.valueOf(6));
    if (localInteger == null)
    {
      AppMethodBeat.o(247769);
      return -1;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(247769);
    return i;
  }
  
  public final int bgb()
  {
    AppMethodBeat.i(247776);
    Integer localInteger = (Integer)this.mUV.get(Integer.valueOf(7));
    if (localInteger == null)
    {
      AppMethodBeat.o(247776);
      return -1;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(247776);
    return i;
  }
  
  public final int bgc()
  {
    AppMethodBeat.i(247780);
    Integer localInteger = (Integer)this.mUV.get(Integer.valueOf(8));
    if (localInteger == null)
    {
      AppMethodBeat.o(247780);
      return -1;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(247780);
    return i;
  }
  
  public final int bgd()
  {
    AppMethodBeat.i(247788);
    Integer localInteger = (Integer)this.mUV.get(Integer.valueOf(9));
    if (localInteger == null)
    {
      AppMethodBeat.o(247788);
      return -1;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(247788);
    return i;
  }
  
  public final int bge()
  {
    AppMethodBeat.i(247791);
    Integer localInteger = (Integer)this.mUV.get(Integer.valueOf(10));
    if (localInteger == null)
    {
      AppMethodBeat.o(247791);
      return -1;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(247791);
    return i;
  }
  
  public final int bgf()
  {
    AppMethodBeat.i(247797);
    Integer localInteger = (Integer)this.mUV.get(Integer.valueOf(11));
    if (localInteger == null)
    {
      AppMethodBeat.o(247797);
      return -1;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(247797);
    return i;
  }
  
  public final int bgg()
  {
    AppMethodBeat.i(247801);
    Integer localInteger = (Integer)this.mUV.get(Integer.valueOf(12));
    if (localInteger == null)
    {
      AppMethodBeat.o(247801);
      return -1;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(247801);
    return i;
  }
  
  public final int bgh()
  {
    AppMethodBeat.i(247809);
    Integer localInteger = (Integer)this.mUV.get(Integer.valueOf(13));
    if (localInteger == null)
    {
      AppMethodBeat.o(247809);
      return -1;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(247809);
    return i;
  }
  
  public final int bgi()
  {
    AppMethodBeat.i(247815);
    Integer localInteger = (Integer)this.mUV.get(Integer.valueOf(14));
    if (localInteger == null)
    {
      AppMethodBeat.o(247815);
      return -1;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(247815);
    return i;
  }
  
  public final int bgj()
  {
    AppMethodBeat.i(247821);
    Integer localInteger = (Integer)this.mUV.get(Integer.valueOf(15));
    if (localInteger == null)
    {
      AppMethodBeat.o(247821);
      return -1;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(247821);
    return i;
  }
  
  public final int bgk()
  {
    AppMethodBeat.i(247827);
    Integer localInteger = (Integer)this.mUV.get(Integer.valueOf(16));
    if (localInteger == null)
    {
      AppMethodBeat.o(247827);
      return -1;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(247827);
    return i;
  }
  
  public final int bgl()
  {
    AppMethodBeat.i(247835);
    Integer localInteger = (Integer)this.mUV.get(Integer.valueOf(17));
    if (localInteger == null)
    {
      AppMethodBeat.o(247835);
      return -1;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(247835);
    return i;
  }
  
  public final int bgm()
  {
    AppMethodBeat.i(247842);
    Integer localInteger = (Integer)this.mUV.get(Integer.valueOf(18));
    if (localInteger == null)
    {
      AppMethodBeat.o(247842);
      return -1;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(247842);
    return i;
  }
  
  public final int bgn()
  {
    AppMethodBeat.i(247848);
    Integer localInteger = (Integer)this.mUV.get(Integer.valueOf(19));
    if (localInteger == null)
    {
      AppMethodBeat.o(247848);
      return -1;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(247848);
    return i;
  }
  
  public final int bgo()
  {
    AppMethodBeat.i(247854);
    Integer localInteger = (Integer)this.mUV.get(Integer.valueOf(20));
    if (localInteger == null)
    {
      AppMethodBeat.o(247854);
      return -1;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(247854);
    return i;
  }
  
  public final int bgp()
  {
    AppMethodBeat.i(247860);
    Integer localInteger = (Integer)this.mUV.get(Integer.valueOf(21));
    if (localInteger == null)
    {
      AppMethodBeat.o(247860);
      return -1;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(247860);
    return i;
  }
  
  public final boolean bgq()
  {
    AppMethodBeat.i(247865);
    if (bfU() >= 0)
    {
      AppMethodBeat.o(247865);
      return true;
    }
    AppMethodBeat.o(247865);
    return false;
  }
  
  public final boolean bgr()
  {
    AppMethodBeat.i(247873);
    if ((bfV() >= 0) || (bfW() >= 0))
    {
      AppMethodBeat.o(247873);
      return true;
    }
    AppMethodBeat.o(247873);
    return false;
  }
  
  public final boolean bgs()
  {
    AppMethodBeat.i(247876);
    if ((bfX() >= 0) || (bfY() >= 0))
    {
      AppMethodBeat.o(247876);
      return true;
    }
    AppMethodBeat.o(247876);
    return false;
  }
  
  public final boolean bgt()
  {
    AppMethodBeat.i(247882);
    if (bfZ() >= 0)
    {
      AppMethodBeat.o(247882);
      return true;
    }
    AppMethodBeat.o(247882);
    return false;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(247902);
    if (this == paramObject)
    {
      AppMethodBeat.o(247902);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(247902);
      return false;
    }
    paramObject = (a)paramObject;
    if (!s.p(this.mUV, paramObject.mUV))
    {
      AppMethodBeat.o(247902);
      return false;
    }
    AppMethodBeat.o(247902);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(247894);
    int i = this.mUV.hashCode();
    AppMethodBeat.o(247894);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(247888);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("BeautyConfig(isNewSmoothFace=").append(this.mUW).append(", skinSmooth=").append(bfU()).append(", eyeMorph=").append(bfV()).append(", faceMorph=").append(bfW()).append(", skinBright=").append(bfX()).append(", eyeBright=").append(bfY()).append(", rosy=").append(bfZ()).append(", eyePouch=").append(bga()).append(", smileFolds=").append(bgb()).append(", sharpen=").append(bgc()).append(", teethBright=").append(bgd()).append(", smallHead=");
    ((StringBuilder)localObject).append(bge()).append(", cheekBone=").append(bgf()).append(", jawBone=").append(bgg()).append(", wingOfNose=").append(bgh()).append(", bigEye=").append(bgi()).append(", chin=").append(bgj()).append(", mouthMorph=").append(bgk()).append(", hairLine=").append(bgl()).append(", boySlim=").append(bgm()).append(", girlSlim=").append(bgn()).append(", zhaiLian=").append(bgo()).append(", contour=").append(bgp());
    ((StringBuilder)localObject).append(')');
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(247888);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.live.core.b.a
 * JD-Core Version:    0.7.0.1
 */