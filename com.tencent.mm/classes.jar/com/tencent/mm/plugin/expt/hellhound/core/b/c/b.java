package com.tencent.mm.plugin.expt.hellhound.core.b.c;

import android.util.Pair;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a;
import com.tencent.mm.protocal.protobuf.fbo;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/HorizontalViewPagerCallback;", "", "()V", "mHorizontalListener", "com/tencent/mm/plugin/expt/hellhound/core/v2/view/HorizontalViewPagerCallback$mHorizontalListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/HorizontalViewPagerCallback$mHorizontalListener$1;", "mLastPosition", "", "mListener", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/IViewOpListener;", "mMethodMap", "", "", "", "Landroid/util/Pair;", "monitor", "", "listener", "monitor$plugin_expt_release", "unmonitor", "unmonitor$plugin_expt_release", "Companion", "plugin-expt_release"})
public final class b
{
  public static final b.a wgv;
  int lL;
  c wgl;
  final Map<String, List<Pair<String, String>>> wgt;
  final b wgu;
  
  static
  {
    AppMethodBeat.i(253367);
    wgv = new b.a((byte)0);
    AppMethodBeat.o(253367);
  }
  
  public b()
  {
    AppMethodBeat.i(253366);
    this.lL = -1;
    this.wgt = ((Map)new LinkedHashMap());
    this.wgu = new b(this);
    AppMethodBeat.o(253366);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/expt/hellhound/core/v2/view/HorizontalViewPagerCallback$mHorizontalListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class b
    implements com.tencent.mm.hellhoundlib.a.d
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
    
    public final void b(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(252344);
      int i;
      if ((paramObject != null) && ((paramObject instanceof View)) && (paramArrayOfObject != null) && (paramArrayOfObject.length >= 2))
      {
        paramString2 = paramArrayOfObject[0];
        if (paramString2 == null)
        {
          paramString1 = new t("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(252344);
          throw paramString1;
        }
        i = ((Integer)paramString2).intValue();
        paramString2 = paramArrayOfObject[1];
        if (paramString2 == null)
        {
          paramString1 = new t("null cannot be cast to non-null type kotlin.Boolean");
          AppMethodBeat.o(252344);
          throw paramString1;
        }
        ((Boolean)paramString2).booleanValue();
        if ((i <= 0) && (b.a(this.wgw) == -1))
        {
          AppMethodBeat.o(252344);
          return;
        }
        b.a(this.wgw, i);
        paramString3 = new fbo();
        paramString3.id = "Horizontal-Scroll-".concat(String.valueOf(i));
        paramString3.UBI = paramString3.id;
        paramString3.typeName = paramString3.id;
        paramString2 = a.dcp();
        p.j(paramString2, "HellhoundMonitor.getInstance()");
        paramString2 = paramString2.dco();
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
        paramString3.fFe = paramString1;
        paramString3.UBJ = ((View)paramObject).getClass().getName();
        paramString3.eventId = d.wgI.value;
        paramString3.aNf = paramObject.hashCode();
        paramString3.GcW = paramObject.hashCode();
        paramString3.timestamp = System.currentTimeMillis();
        paramString3.type = 1;
        paramString3.SFr = i;
        paramString1 = b.b(this.wgw);
        if (paramString1 != null)
        {
          paramString1.a((View)paramObject, paramString3);
          AppMethodBeat.o(252344);
          return;
          paramString2 = null;
          break;
        }
        AppMethodBeat.o(252344);
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