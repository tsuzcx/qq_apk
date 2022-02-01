package androidx.compose.ui.g.c;

import androidx.compose.ui.d.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/input/pointer/PointerInputEventData;", "", "id", "Landroidx/compose/ui/input/pointer/PointerId;", "uptime", "", "positionOnScreen", "Landroidx/compose/ui/geometry/Offset;", "position", "down", "", "type", "Landroidx/compose/ui/input/pointer/PointerType;", "(JJJJZILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDown", "()Z", "getId-J3iCeTQ", "()J", "J", "getPosition-F1C5BW0", "getPositionOnScreen-F1C5BW0", "getType-T8wyACA", "()I", "I", "getUptime", "component1", "component1-J3iCeTQ", "component2", "component3", "component3-F1C5BW0", "component4", "component4-F1C5BW0", "component5", "component6", "component6-T8wyACA", "copy", "copy-1boDhkU", "(JJJJZI)Landroidx/compose/ui/input/pointer/PointerInputEventData;", "equals", "other", "hashCode", "", "toString", "", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p
{
  final long aLt;
  final long aLu;
  final boolean aLv;
  final long id;
  final long position;
  final int type;
  
  private p(long paramLong1, long paramLong2, long paramLong3, long paramLong4, boolean paramBoolean, int paramInt)
  {
    this.id = paramLong1;
    this.aLt = paramLong2;
    this.aLu = paramLong3;
    this.position = paramLong4;
    this.aLv = paramBoolean;
    this.type = paramInt;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(205853);
    if (this == paramObject)
    {
      AppMethodBeat.o(205853);
      return true;
    }
    if (!(paramObject instanceof p))
    {
      AppMethodBeat.o(205853);
      return false;
    }
    paramObject = (p)paramObject;
    if (!l.e(this.id, paramObject.id))
    {
      AppMethodBeat.o(205853);
      return false;
    }
    if (this.aLt != paramObject.aLt)
    {
      AppMethodBeat.o(205853);
      return false;
    }
    if (!e.e(this.aLu, paramObject.aLu))
    {
      AppMethodBeat.o(205853);
      return false;
    }
    if (!e.e(this.position, paramObject.position))
    {
      AppMethodBeat.o(205853);
      return false;
    }
    if (this.aLv != paramObject.aLv)
    {
      AppMethodBeat.o(205853);
      return false;
    }
    if (!y.C(this.type, paramObject.type))
    {
      AppMethodBeat.o(205853);
      return false;
    }
    AppMethodBeat.o(205853);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(205841);
    String str = "PointerInputEventData(id=" + l.H(this.id) + ", uptime=" + this.aLt + ", positionOnScreen=" + e.H(this.aLu) + ", position=" + e.H(this.position) + ", down=" + this.aLv + ", type=" + y.cJ(this.type) + ')';
    AppMethodBeat.o(205841);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.g.c.p
 * JD-Core Version:    0.7.0.1
 */