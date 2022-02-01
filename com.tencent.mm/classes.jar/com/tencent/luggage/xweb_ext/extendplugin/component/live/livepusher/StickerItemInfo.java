package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import androidx.compose.a.a.q..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IResInfo;", "id", "", "name", "", "frameCount", "triggerAction", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$TriggerAction;", "resPath", "resPathMd5", "pos", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$Position;", "type", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$StickerBackType;", "(ILjava/lang/String;ILcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$TriggerAction;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$Position;Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$StickerBackType;)V", "getFrameCount", "()I", "getId", "getName", "()Ljava/lang/String;", "getPos", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$Position;", "getResPath", "getResPathMd5", "getTriggerAction", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$TriggerAction;", "getType", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$StickerBackType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "", "getIdentityDesc", "hashCode", "toString", "Position", "StickerBackType", "TriggerAction", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class StickerItemInfo
  implements i
{
  public final TriggerAction eBW;
  public final String eBX;
  private final String eBY;
  public final a eBZ;
  public final StickerBackType eCa;
  public final int frameCount;
  public final int id;
  public final String name;
  
  public StickerItemInfo(int paramInt1, String paramString1, int paramInt2, TriggerAction paramTriggerAction, String paramString2, String paramString3, a parama, StickerBackType paramStickerBackType)
  {
    AppMethodBeat.i(220748);
    this.id = paramInt1;
    this.name = paramString1;
    this.frameCount = paramInt2;
    this.eBW = paramTriggerAction;
    this.eBX = paramString2;
    this.eBY = paramString3;
    this.eBZ = parama;
    this.eCa = paramStickerBackType;
    AppMethodBeat.o(220748);
  }
  
  public final String aui()
  {
    AppMethodBeat.i(220756);
    String str = "StickerItemInfo(resPath='" + this.eBX + "', resPathMd5='" + this.eBY + "')";
    AppMethodBeat.o(220756);
    return str;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(220773);
    if (this == paramObject)
    {
      AppMethodBeat.o(220773);
      return true;
    }
    if (!(paramObject instanceof StickerItemInfo))
    {
      AppMethodBeat.o(220773);
      return false;
    }
    paramObject = (StickerItemInfo)paramObject;
    if (this.id != paramObject.id)
    {
      AppMethodBeat.o(220773);
      return false;
    }
    if (!s.p(this.name, paramObject.name))
    {
      AppMethodBeat.o(220773);
      return false;
    }
    if (this.frameCount != paramObject.frameCount)
    {
      AppMethodBeat.o(220773);
      return false;
    }
    if (this.eBW != paramObject.eBW)
    {
      AppMethodBeat.o(220773);
      return false;
    }
    if (!s.p(this.eBX, paramObject.eBX))
    {
      AppMethodBeat.o(220773);
      return false;
    }
    if (!s.p(this.eBY, paramObject.eBY))
    {
      AppMethodBeat.o(220773);
      return false;
    }
    if (!s.p(this.eBZ, paramObject.eBZ))
    {
      AppMethodBeat.o(220773);
      return false;
    }
    if (this.eCa != paramObject.eCa)
    {
      AppMethodBeat.o(220773);
      return false;
    }
    AppMethodBeat.o(220773);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(220769);
    int j = this.id;
    int k = this.name.hashCode();
    int m = this.frameCount;
    int n = this.eBW.hashCode();
    int i1 = this.eBX.hashCode();
    int i2 = this.eBY.hashCode();
    if (this.eBZ == null) {}
    for (int i = 0;; i = this.eBZ.hashCode())
    {
      int i3 = this.eCa.hashCode();
      AppMethodBeat.o(220769);
      return (i + (((((j * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31) * 31 + i3;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(220761);
    String str = "StickerItemInfo(id=" + this.id + ", name=" + this.name + ", frameCount=" + this.frameCount + ", triggerAction=" + this.eBW + ", resPath=" + this.eBX + ", resPathMd5=" + this.eBY + ", pos=" + this.eBZ + ", type=" + this.eCa + ')';
    AppMethodBeat.o(220761);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$StickerBackType;", "", "jsonVal", "", "(Ljava/lang/String;II)V", "getJsonVal", "()I", "BACKGROUND", "HUMAN_REGION", "Companion", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum StickerBackType
  {
    public static final a Companion;
    private final int jsonVal;
    
    static
    {
      AppMethodBeat.i(220770);
      BACKGROUND = new StickerBackType("BACKGROUND", 0, 0);
      HUMAN_REGION = new StickerBackType("HUMAN_REGION", 1, 1);
      $VALUES = $values();
      Companion = new a((byte)0);
      AppMethodBeat.o(220770);
    }
    
    private StickerBackType(int paramInt)
    {
      this.jsonVal = paramInt;
    }
    
    public static final StickerBackType from(int paramInt)
    {
      AppMethodBeat.i(220762);
      StickerBackType localStickerBackType = a.from(paramInt);
      AppMethodBeat.o(220762);
      return localStickerBackType;
    }
    
    public final int getJsonVal()
    {
      return this.jsonVal;
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$StickerBackType$Companion;", "", "()V", "from", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$StickerBackType;", "typeInt", "", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
    {
      public static StickerItemInfo.StickerBackType from(int paramInt)
      {
        AppMethodBeat.i(220720);
        StickerItemInfo.StickerBackType[] arrayOfStickerBackType = StickerItemInfo.StickerBackType.values();
        int k = arrayOfStickerBackType.length;
        int i = 0;
        while (i < k)
        {
          StickerItemInfo.StickerBackType localStickerBackType = arrayOfStickerBackType[i];
          if (paramInt == localStickerBackType.getJsonVal()) {}
          for (int j = 1; j != 0; j = 0)
          {
            AppMethodBeat.o(220720);
            return localStickerBackType;
          }
          i += 1;
        }
        AppMethodBeat.o(220720);
        return null;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$TriggerAction;", "", "jsonVal", "", "(Ljava/lang/String;II)V", "getJsonVal", "()I", "DEFAULT_ACTION_LOOP", "FACE_ACTION_MOUTH_OPEN", "FACE_ACTION_MOUTH_KISS", "FACE_ACTION_LEFT_EYE_BLINK", "FACE_ACTION_RIGHT_EYE_BLINK", "FACE_ACTION_EYE_BLINK", "FACE_ACTION_EYEBROW_UP", "FACE_ACTION_HEAD_SHAKE", "FACE_ACTION_HEAD_NOD", "HAND_ACTION_HEART", "HAND_ACTION_PAPER", "HAND_ACTION_SCISSOR", "HAND_ACTION_FIST", "HAND_ACTION_ONE", "HAND_ACTION_LOVE", "HAND_ACTION_LIKE", "HAND_ACTION_OK", "HAND_ACTION_ROCK", "HAND_ACTION_SIX", "HAND_ACTION_EIGHT", "HAND_ACTION_LIFT", "HAND_ACTION_GOOD_FORTUNE", "Companion", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum TriggerAction
  {
    public static final a Companion;
    private final int jsonVal;
    
    static
    {
      AppMethodBeat.i(220786);
      DEFAULT_ACTION_LOOP = new TriggerAction("DEFAULT_ACTION_LOOP", 0, -1);
      FACE_ACTION_MOUTH_OPEN = new TriggerAction("FACE_ACTION_MOUTH_OPEN", 1, 10);
      FACE_ACTION_MOUTH_KISS = new TriggerAction("FACE_ACTION_MOUTH_KISS", 2, 11);
      FACE_ACTION_LEFT_EYE_BLINK = new TriggerAction("FACE_ACTION_LEFT_EYE_BLINK", 3, 12);
      FACE_ACTION_RIGHT_EYE_BLINK = new TriggerAction("FACE_ACTION_RIGHT_EYE_BLINK", 4, 13);
      FACE_ACTION_EYE_BLINK = new TriggerAction("FACE_ACTION_EYE_BLINK", 5, 14);
      FACE_ACTION_EYEBROW_UP = new TriggerAction("FACE_ACTION_EYEBROW_UP", 6, 15);
      FACE_ACTION_HEAD_SHAKE = new TriggerAction("FACE_ACTION_HEAD_SHAKE", 7, 16);
      FACE_ACTION_HEAD_NOD = new TriggerAction("FACE_ACTION_HEAD_NOD", 8, 17);
      HAND_ACTION_HEART = new TriggerAction("HAND_ACTION_HEART", 9, 100);
      HAND_ACTION_PAPER = new TriggerAction("HAND_ACTION_PAPER", 10, 101);
      HAND_ACTION_SCISSOR = new TriggerAction("HAND_ACTION_SCISSOR", 11, 102);
      HAND_ACTION_FIST = new TriggerAction("HAND_ACTION_FIST", 12, 103);
      HAND_ACTION_ONE = new TriggerAction("HAND_ACTION_ONE", 13, 104);
      HAND_ACTION_LOVE = new TriggerAction("HAND_ACTION_LOVE", 14, 105);
      HAND_ACTION_LIKE = new TriggerAction("HAND_ACTION_LIKE", 15, 106);
      HAND_ACTION_OK = new TriggerAction("HAND_ACTION_OK", 16, 107);
      HAND_ACTION_ROCK = new TriggerAction("HAND_ACTION_ROCK", 17, 108);
      HAND_ACTION_SIX = new TriggerAction("HAND_ACTION_SIX", 18, 109);
      HAND_ACTION_EIGHT = new TriggerAction("HAND_ACTION_EIGHT", 19, 110);
      HAND_ACTION_LIFT = new TriggerAction("HAND_ACTION_LIFT", 20, 111);
      HAND_ACTION_GOOD_FORTUNE = new TriggerAction("HAND_ACTION_GOOD_FORTUNE", 21, 112);
      $VALUES = $values();
      Companion = new a((byte)0);
      AppMethodBeat.o(220786);
    }
    
    private TriggerAction(int paramInt)
    {
      this.jsonVal = paramInt;
    }
    
    public static final TriggerAction from(int paramInt)
    {
      AppMethodBeat.i(220781);
      TriggerAction localTriggerAction = a.from(paramInt);
      AppMethodBeat.o(220781);
      return localTriggerAction;
    }
    
    public final int getJsonVal()
    {
      return this.jsonVal;
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$TriggerAction$Companion;", "", "()V", "from", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$TriggerAction;", "actionInt", "", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
    {
      public static StickerItemInfo.TriggerAction from(int paramInt)
      {
        AppMethodBeat.i(220782);
        StickerItemInfo.TriggerAction[] arrayOfTriggerAction = StickerItemInfo.TriggerAction.values();
        int k = arrayOfTriggerAction.length;
        int i = 0;
        while (i < k)
        {
          StickerItemInfo.TriggerAction localTriggerAction = arrayOfTriggerAction[i];
          if (paramInt == localTriggerAction.getJsonVal()) {}
          for (int j = 1; j != 0; j = 0)
          {
            AppMethodBeat.o(220782);
            return localTriggerAction;
          }
          i += 1;
        }
        AppMethodBeat.o(220782);
        return null;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$Position;", "", "x1", "", "y1", "x2", "y2", "(DDDD)V", "getX1", "()D", "getX2", "getY1", "getY2", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public final double eCb;
    public final double eCc;
    public final double eCd;
    public final double eCe;
    
    public a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
    {
      this.eCb = paramDouble1;
      this.eCc = paramDouble2;
      this.eCd = paramDouble3;
      this.eCe = paramDouble4;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(220766);
      if (this == paramObject)
      {
        AppMethodBeat.o(220766);
        return true;
      }
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(220766);
        return false;
      }
      paramObject = (a)paramObject;
      if (!s.p(Double.valueOf(this.eCb), Double.valueOf(paramObject.eCb)))
      {
        AppMethodBeat.o(220766);
        return false;
      }
      if (!s.p(Double.valueOf(this.eCc), Double.valueOf(paramObject.eCc)))
      {
        AppMethodBeat.o(220766);
        return false;
      }
      if (!s.p(Double.valueOf(this.eCd), Double.valueOf(paramObject.eCd)))
      {
        AppMethodBeat.o(220766);
        return false;
      }
      if (!s.p(Double.valueOf(this.eCe), Double.valueOf(paramObject.eCe)))
      {
        AppMethodBeat.o(220766);
        return false;
      }
      AppMethodBeat.o(220766);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(220759);
      int i = q..ExternalSyntheticBackport0.m(this.eCb);
      int j = q..ExternalSyntheticBackport0.m(this.eCc);
      int k = q..ExternalSyntheticBackport0.m(this.eCd);
      int m = q..ExternalSyntheticBackport0.m(this.eCe);
      AppMethodBeat.o(220759);
      return ((i * 31 + j) * 31 + k) * 31 + m;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(220752);
      String str = "Position(x1=" + this.eCb + ", y1=" + this.eCc + ", x2=" + this.eCd + ", y2=" + this.eCe + ')';
      AppMethodBeat.o(220752);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.StickerItemInfo
 * JD-Core Version:    0.7.0.1
 */