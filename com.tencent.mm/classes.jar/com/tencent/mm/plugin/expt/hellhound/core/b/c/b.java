package com.tencent.mm.plugin.expt.hellhound.core.b.c;

import android.util.Pair;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a;
import com.tencent.mm.protocal.protobuf.dwc;
import d.g.b.p;
import d.l;
import d.v;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/HorizontalViewPagerCallback;", "", "()V", "mHorizontalListener", "com/tencent/mm/plugin/expt/hellhound/core/v2/view/HorizontalViewPagerCallback$mHorizontalListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/HorizontalViewPagerCallback$mHorizontalListener$1;", "mLastPosition", "", "mListener", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/IViewOpListener;", "mMethodMap", "", "", "", "Landroid/util/Pair;", "monitor", "", "listener", "monitor$plugin_expt_release", "unmonitor", "unmonitor$plugin_expt_release", "Companion", "plugin-expt_release"})
public final class b
{
  public static final b.a qSm;
  int afo;
  c qSc;
  final Map<String, List<Pair<String, String>>> qSk;
  final b qSl;
  
  static
  {
    AppMethodBeat.i(210643);
    qSm = new b.a((byte)0);
    AppMethodBeat.o(210643);
  }
  
  public b()
  {
    AppMethodBeat.i(210642);
    this.afo = -1;
    this.qSk = ((Map)new LinkedHashMap());
    this.qSl = new b(this);
    AppMethodBeat.o(210642);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/expt/hellhound/core/v2/view/HorizontalViewPagerCallback$mHorizontalListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class b
    implements com.tencent.mm.hellhoundlib.a.c
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(210641);
      int i;
      if ((paramObject != null) && ((paramObject instanceof View)) && (paramArrayOfObject != null) && (paramArrayOfObject.length >= 2))
      {
        paramString2 = paramArrayOfObject[0];
        if (paramString2 == null)
        {
          paramString1 = new v("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(210641);
          throw paramString1;
        }
        i = ((Integer)paramString2).intValue();
        paramString2 = paramArrayOfObject[1];
        if (paramString2 == null)
        {
          paramString1 = new v("null cannot be cast to non-null type kotlin.Boolean");
          AppMethodBeat.o(210641);
          throw paramString1;
        }
        ((Boolean)paramString2).booleanValue();
        if ((i <= 0) && (b.a(this.qSn) == -1))
        {
          AppMethodBeat.o(210641);
          return;
        }
        b.a(this.qSn, i);
        paramString3 = new dwc();
        paramString3.id = "Horizontal-Scroll-".concat(String.valueOf(i));
        paramString3.HIB = paramString3.id;
        paramString3.typeName = paramString3.id;
        paramString2 = a.cnB();
        p.g(paramString2, "HellhoundMonitor.getInstance()");
        paramString2 = paramString2.cnA();
        if (paramString2 != null)
        {
          paramString2 = paramString2.getClass();
          if (paramString2 != null)
          {
            paramString2 = paramString2.getName();
            if (paramString2 != null) {
              break label312;
            }
          }
        }
      }
      for (;;)
      {
        paramString3.dtL = paramString1;
        paramString3.HIC = ((View)paramObject).getClass().getName();
        paramString3.dtK = d.qSz.value;
        paramString3.aHQ = paramObject.hashCode();
        paramString3.HID = paramObject.hashCode();
        paramString3.timestamp = System.currentTimeMillis();
        paramString3.type = 1;
        paramString3.GlW = i;
        paramString1 = b.b(this.qSn);
        if (paramString1 != null)
        {
          paramString1.a((View)paramObject, paramString3);
          AppMethodBeat.o(210641);
          return;
          paramString2 = null;
          break;
        }
        AppMethodBeat.o(210641);
        return;
        label312:
        paramString1 = paramString2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.c.b
 * JD-Core Version:    0.7.0.1
 */