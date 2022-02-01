package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IResInfo;", "id", "", "name", "", "frameCount", "triggerAction", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$TriggerAction;", "resPath", "resPathMd5", "pos", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$Position;", "type", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$StickerBackType;", "(ILjava/lang/String;ILcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$TriggerAction;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$Position;Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$StickerBackType;)V", "getFrameCount", "()I", "getId", "getName", "()Ljava/lang/String;", "getPos", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$Position;", "getResPath", "getResPathMd5", "getTriggerAction", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$TriggerAction;", "getType", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$StickerBackType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "", "getIdentityDesc", "hashCode", "toString", "Position", "StickerBackType", "TriggerAction", "luggage-xweb-ext_release"})
public final class StickerItemInfo
  implements h
{
  public final StickerItemInfo.TriggerAction cHL;
  public final String cHM;
  private final String cHN;
  public final a cHO;
  public final StickerItemInfo.StickerBackType cHP;
  public final int frameCount;
  public final int id;
  public final String name;
  
  public StickerItemInfo(int paramInt1, String paramString1, int paramInt2, StickerItemInfo.TriggerAction paramTriggerAction, String paramString2, String paramString3, a parama, StickerItemInfo.StickerBackType paramStickerBackType)
  {
    AppMethodBeat.i(215982);
    this.id = paramInt1;
    this.name = paramString1;
    this.frameCount = paramInt2;
    this.cHL = paramTriggerAction;
    this.cHM = paramString2;
    this.cHN = paramString3;
    this.cHO = parama;
    this.cHP = paramStickerBackType;
    AppMethodBeat.o(215982);
  }
  
  public final String Qc()
  {
    AppMethodBeat.i(215981);
    String str = "StickerItemInfo(resPath='" + this.cHM + "', resPathMd5='" + this.cHN + "')";
    AppMethodBeat.o(215981);
    return str;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(215985);
    if (this != paramObject)
    {
      if ((paramObject instanceof StickerItemInfo))
      {
        paramObject = (StickerItemInfo)paramObject;
        if ((this.id != paramObject.id) || (!p.j(this.name, paramObject.name)) || (this.frameCount != paramObject.frameCount) || (!p.j(this.cHL, paramObject.cHL)) || (!p.j(this.cHM, paramObject.cHM)) || (!p.j(this.cHN, paramObject.cHN)) || (!p.j(this.cHO, paramObject.cHO)) || (!p.j(this.cHP, paramObject.cHP))) {}
      }
    }
    else
    {
      AppMethodBeat.o(215985);
      return true;
    }
    AppMethodBeat.o(215985);
    return false;
  }
  
  public final int hashCode()
  {
    int i1 = 0;
    AppMethodBeat.i(215984);
    int i2 = this.id;
    Object localObject = this.name;
    int i;
    int i3;
    int j;
    label54:
    int k;
    label71:
    int m;
    if (localObject != null)
    {
      i = localObject.hashCode();
      i3 = this.frameCount;
      localObject = this.cHL;
      if (localObject == null) {
        break label177;
      }
      j = localObject.hashCode();
      localObject = this.cHM;
      if (localObject == null) {
        break label182;
      }
      k = localObject.hashCode();
      localObject = this.cHN;
      if (localObject == null) {
        break label187;
      }
      m = localObject.hashCode();
      label89:
      localObject = this.cHO;
      if (localObject == null) {
        break label193;
      }
    }
    label177:
    label182:
    label187:
    label193:
    for (int n = localObject.hashCode();; n = 0)
    {
      localObject = this.cHP;
      if (localObject != null) {
        i1 = localObject.hashCode();
      }
      AppMethodBeat.o(215984);
      return (n + (m + (k + (j + ((i + i2 * 31) * 31 + i3) * 31) * 31) * 31) * 31) * 31 + i1;
      i = 0;
      break;
      j = 0;
      break label54;
      k = 0;
      break label71;
      m = 0;
      break label89;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(215983);
    String str = "StickerItemInfo(id=" + this.id + ", name=" + this.name + ", frameCount=" + this.frameCount + ", triggerAction=" + this.cHL + ", resPath=" + this.cHM + ", resPathMd5=" + this.cHN + ", pos=" + this.cHO + ", type=" + this.cHP + ")";
    AppMethodBeat.o(215983);
    return str;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$Position;", "", "x1", "", "y1", "x2", "y2", "(DDDD)V", "getX1", "()D", "getX2", "getY1", "getY2", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "luggage-xweb-ext_release"})
  public static final class a
  {
    public final double cHQ;
    public final double cHR;
    public final double cHS;
    public final double cHT;
    
    public a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
    {
      this.cHQ = paramDouble1;
      this.cHR = paramDouble2;
      this.cHS = paramDouble3;
      this.cHT = paramDouble4;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(215972);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((Double.compare(this.cHQ, paramObject.cHQ) != 0) || (Double.compare(this.cHR, paramObject.cHR) != 0) || (Double.compare(this.cHS, paramObject.cHS) != 0) || (Double.compare(this.cHT, paramObject.cHT) != 0)) {}
        }
      }
      else
      {
        AppMethodBeat.o(215972);
        return true;
      }
      AppMethodBeat.o(215972);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(215971);
      long l = Double.doubleToLongBits(this.cHQ);
      int i = (int)(l ^ l >>> 32);
      l = Double.doubleToLongBits(this.cHR);
      int j = (int)(l ^ l >>> 32);
      l = Double.doubleToLongBits(this.cHS);
      int k = (int)(l ^ l >>> 32);
      l = Double.doubleToLongBits(this.cHT);
      int m = (int)(l ^ l >>> 32);
      AppMethodBeat.o(215971);
      return ((i * 31 + j) * 31 + k) * 31 + m;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(215970);
      String str = "Position(x1=" + this.cHQ + ", y1=" + this.cHR + ", x2=" + this.cHS + ", y2=" + this.cHT + ")";
      AppMethodBeat.o(215970);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.StickerItemInfo
 * JD-Core Version:    0.7.0.1
 */