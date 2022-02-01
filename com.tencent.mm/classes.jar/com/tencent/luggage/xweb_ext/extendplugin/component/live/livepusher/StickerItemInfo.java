package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IResInfo;", "id", "", "name", "", "frameCount", "triggerAction", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$TriggerAction;", "resPath", "resPathMd5", "pos", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$Position;", "type", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$StickerBackType;", "(ILjava/lang/String;ILcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$TriggerAction;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$Position;Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$StickerBackType;)V", "getFrameCount", "()I", "getId", "getName", "()Ljava/lang/String;", "getPos", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$Position;", "getResPath", "getResPathMd5", "getTriggerAction", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$TriggerAction;", "getType", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$StickerBackType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "", "getIdentityDesc", "hashCode", "toString", "Position", "StickerBackType", "TriggerAction", "luggage-xweb-ext_release"})
public final class StickerItemInfo
  implements h
{
  public final StickerItemInfo.TriggerAction cIq;
  public final String cIr;
  private final String cIs;
  public final a cIt;
  public final StickerItemInfo.StickerBackType cIu;
  public final int frameCount;
  public final int id;
  public final String name;
  
  public StickerItemInfo(int paramInt1, String paramString1, int paramInt2, StickerItemInfo.TriggerAction paramTriggerAction, String paramString2, String paramString3, a parama, StickerItemInfo.StickerBackType paramStickerBackType)
  {
    AppMethodBeat.i(223748);
    this.id = paramInt1;
    this.name = paramString1;
    this.frameCount = paramInt2;
    this.cIq = paramTriggerAction;
    this.cIr = paramString2;
    this.cIs = paramString3;
    this.cIt = parama;
    this.cIu = paramStickerBackType;
    AppMethodBeat.o(223748);
  }
  
  public final String TD()
  {
    AppMethodBeat.i(223739);
    String str = "StickerItemInfo(resPath='" + this.cIr + "', resPathMd5='" + this.cIs + "')";
    AppMethodBeat.o(223739);
    return str;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(223796);
    if (this != paramObject)
    {
      if ((paramObject instanceof StickerItemInfo))
      {
        paramObject = (StickerItemInfo)paramObject;
        if ((this.id != paramObject.id) || (!p.h(this.name, paramObject.name)) || (this.frameCount != paramObject.frameCount) || (!p.h(this.cIq, paramObject.cIq)) || (!p.h(this.cIr, paramObject.cIr)) || (!p.h(this.cIs, paramObject.cIs)) || (!p.h(this.cIt, paramObject.cIt)) || (!p.h(this.cIu, paramObject.cIu))) {}
      }
    }
    else
    {
      AppMethodBeat.o(223796);
      return true;
    }
    AppMethodBeat.o(223796);
    return false;
  }
  
  public final int hashCode()
  {
    int i1 = 0;
    AppMethodBeat.i(223785);
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
      localObject = this.cIq;
      if (localObject == null) {
        break label177;
      }
      j = localObject.hashCode();
      localObject = this.cIr;
      if (localObject == null) {
        break label182;
      }
      k = localObject.hashCode();
      localObject = this.cIs;
      if (localObject == null) {
        break label187;
      }
      m = localObject.hashCode();
      label89:
      localObject = this.cIt;
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
      localObject = this.cIu;
      if (localObject != null) {
        i1 = localObject.hashCode();
      }
      AppMethodBeat.o(223785);
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
    AppMethodBeat.i(223758);
    String str = "StickerItemInfo(id=" + this.id + ", name=" + this.name + ", frameCount=" + this.frameCount + ", triggerAction=" + this.cIq + ", resPath=" + this.cIr + ", resPathMd5=" + this.cIs + ", pos=" + this.cIt + ", type=" + this.cIu + ")";
    AppMethodBeat.o(223758);
    return str;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$Position;", "", "x1", "", "y1", "x2", "y2", "(DDDD)V", "getX1", "()D", "getX2", "getY1", "getY2", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "luggage-xweb-ext_release"})
  public static final class a
  {
    public final double cIv;
    public final double cIw;
    public final double cIx;
    public final double cIy;
    
    public a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
    {
      this.cIv = paramDouble1;
      this.cIw = paramDouble2;
      this.cIx = paramDouble3;
      this.cIy = paramDouble4;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(222832);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((Double.compare(this.cIv, paramObject.cIv) != 0) || (Double.compare(this.cIw, paramObject.cIw) != 0) || (Double.compare(this.cIx, paramObject.cIx) != 0) || (Double.compare(this.cIy, paramObject.cIy) != 0)) {}
        }
      }
      else
      {
        AppMethodBeat.o(222832);
        return true;
      }
      AppMethodBeat.o(222832);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(222829);
      long l = Double.doubleToLongBits(this.cIv);
      int i = (int)(l ^ l >>> 32);
      l = Double.doubleToLongBits(this.cIw);
      int j = (int)(l ^ l >>> 32);
      l = Double.doubleToLongBits(this.cIx);
      int k = (int)(l ^ l >>> 32);
      l = Double.doubleToLongBits(this.cIy);
      int m = (int)(l ^ l >>> 32);
      AppMethodBeat.o(222829);
      return ((i * 31 + j) * 31 + k) * 31 + m;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(222825);
      String str = "Position(x1=" + this.cIv + ", y1=" + this.cIw + ", x2=" + this.cIx + ", y2=" + this.cIy + ")";
      AppMethodBeat.o(222825);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.StickerItemInfo
 * JD-Core Version:    0.7.0.1
 */