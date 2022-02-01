package com.tencent.mm.plugin.expt.hellhound.core.b.c;

import android.util.Pair;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a;
import com.tencent.mm.protocal.protobuf.fxz;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/HorizontalViewPagerCallback;", "", "()V", "mHorizontalListener", "com/tencent/mm/plugin/expt/hellhound/core/v2/view/HorizontalViewPagerCallback$mHorizontalListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/HorizontalViewPagerCallback$mHorizontalListener$1;", "mLastPosition", "", "mListener", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/IViewOpListener;", "mMethodMap", "", "", "", "Landroid/util/Pair;", "monitor", "", "listener", "monitor$plugin_expt_release", "unmonitor", "unmonitor$plugin_expt_release", "Companion", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b.a zCv;
  int mI;
  c zCo;
  final Map<String, List<Pair<String, String>>> zCw;
  final b zCx;
  
  static
  {
    AppMethodBeat.i(300077);
    zCv = new b.a((byte)0);
    AppMethodBeat.o(300077);
  }
  
  public b()
  {
    AppMethodBeat.i(300058);
    this.mI = -1;
    this.zCw = ((Map)new LinkedHashMap());
    this.zCx = new b(this);
    AppMethodBeat.o(300058);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/expt/hellhound/core/v2/view/HorizontalViewPagerCallback$mHorizontalListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.hellhoundlib.a.d
  {
    b(b paramb) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(300064);
      int i;
      if (paramObject != null)
      {
        paramString3 = this.zCy;
        if (((paramObject instanceof View)) && (paramArrayOfObject != null) && (paramArrayOfObject.length >= 2))
        {
          i = ((Integer)paramArrayOfObject[0]).intValue();
          ((Boolean)paramArrayOfObject[1]).booleanValue();
          if ((i <= 0) && (b.a(paramString3) == -1))
          {
            AppMethodBeat.o(300064);
            return;
          }
          b.a(paramString3, i);
          paramArrayOfObject = new fxz();
          paramArrayOfObject.id = s.X("Horizontal-Scroll-", Integer.valueOf(i));
          paramArrayOfObject.abVR = paramArrayOfObject.id;
          paramArrayOfObject.typeName = paramArrayOfObject.id;
          paramString2 = a.dIT().dIS();
          if (paramString2 != null) {
            break label249;
          }
          paramString2 = null;
          if (paramString2 != null) {
            break label271;
          }
        }
      }
      for (;;)
      {
        paramArrayOfObject.hJW = paramString1;
        paramArrayOfObject.abVS = paramObject.getClass().getName();
        paramArrayOfObject.eventId = d.zCK.value;
        paramArrayOfObject.cHb = ((View)paramObject).hashCode();
        paramArrayOfObject.LYA = ((View)paramObject).hashCode();
        paramArrayOfObject.timestamp = System.currentTimeMillis();
        paramArrayOfObject.type = 1;
        paramArrayOfObject.ZHp = i;
        paramString1 = b.b(paramString3);
        if (paramString1 != null) {
          paramString1.a((View)paramObject, paramArrayOfObject);
        }
        AppMethodBeat.o(300064);
        return;
        label249:
        paramString2 = paramString2.getClass();
        if (paramString2 == null)
        {
          paramString2 = null;
          break;
        }
        paramString2 = paramString2.getName();
        break;
        label271:
        paramString1 = paramString2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.c.b
 * JD-Core Version:    0.7.0.1
 */