package com.tencent.mm.plugin.expt.hellhound.ext.b.b;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.d;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerCallback$RecycylerScrollListener;", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "()V", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
final class k$a
  implements d
{
  public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
  
  public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(300573);
    if ((paramString1 != null) && (n.U(paramString1, "com/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback$initView$", false)))
    {
      AppMethodBeat.o(300573);
      return;
    }
    if ((s.p("onScrollStateChanged", paramString2)) && (s.p("(Landroidx/recyclerview/widget/RecyclerView;I)V", paramString3)))
    {
      if (paramArrayOfObject != null)
      {
        if (paramArrayOfObject.length >= 2)
        {
          paramString1 = paramArrayOfObject[0];
          if ((paramString1 instanceof RecyclerView)) {
            k.zHQ.onScrollStateChanged((RecyclerView)paramString1, ((Integer)paramArrayOfObject[1]).intValue());
          }
        }
        AppMethodBeat.o(300573);
      }
    }
    else if ((s.p("onScrolled", paramString2)) && (s.p("(Landroidx/recyclerview/widget/RecyclerView;II)V", paramString3)) && (paramArrayOfObject != null) && (paramArrayOfObject.length >= 3))
    {
      paramString2 = paramArrayOfObject[0];
      if ((paramString2 instanceof RecyclerView))
      {
        paramString1 = k.zHQ;
        paramString2 = (RecyclerView)paramString2;
        ((Integer)paramArrayOfObject[1]).intValue();
        paramString1.d(paramString2, ((Integer)paramArrayOfObject[2]).intValue());
      }
    }
    AppMethodBeat.o(300573);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.b.b.k.a
 * JD-Core Version:    0.7.0.1
 */