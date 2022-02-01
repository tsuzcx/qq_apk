package com.tencent.mm.accessibility.base;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"canDelegate", "", "Landroid/view/View;", "canDelegateOnInflate", "isList", "postIfNeed", "", "invoke", "Lkotlin/Function0;", "putData", "T", "", "", "outsideInt", "insideInt", "data", "(Ljava/util/Map;IILjava/lang/Object;)V", "visitChild", "visitor", "Lkotlin/Function1;", "plugin-autoaccessibility_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class MapExpandKt
{
  public static final boolean canDelegate(View paramView)
  {
    AppMethodBeat.i(234410);
    s.u(paramView, "<this>");
    if (!isList(paramView))
    {
      AppMethodBeat.o(234410);
      return true;
    }
    AppMethodBeat.o(234410);
    return false;
  }
  
  public static final boolean canDelegateOnInflate(View paramView)
  {
    AppMethodBeat.i(234405);
    s.u(paramView, "<this>");
    if (!isList(paramView))
    {
      paramView = paramView.getParent();
      if ((paramView instanceof ViewGroup))
      {
        paramView = (ViewGroup)paramView;
        if ((paramView == null) || (isList((View)paramView) != true)) {
          break label68;
        }
      }
      label68:
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label73;
        }
        AppMethodBeat.o(234405);
        return true;
        paramView = null;
        break;
      }
    }
    label73:
    AppMethodBeat.o(234405);
    return false;
  }
  
  public static final boolean isList(View paramView)
  {
    AppMethodBeat.i(234399);
    s.u(paramView, "<this>");
    if (((paramView instanceof ListView)) || ((paramView instanceof RecyclerView)))
    {
      AppMethodBeat.o(234399);
      return true;
    }
    AppMethodBeat.o(234399);
    return false;
  }
  
  public static final void postIfNeed(View paramView, a<ah> parama)
  {
    AppMethodBeat.i(234393);
    s.u(paramView, "<this>");
    s.u(parama, "invoke");
    if ((paramView.getWidth() == 0) && (paramView.getHeight() == 0))
    {
      paramView.post(new MapExpandKt..ExternalSyntheticLambda0(parama));
      AppMethodBeat.o(234393);
      return;
    }
    parama.invoke();
    AppMethodBeat.o(234393);
  }
  
  private static final void postIfNeed$lambda-0(a parama)
  {
    AppMethodBeat.i(234417);
    s.u(parama, "$invoke");
    parama.invoke();
    AppMethodBeat.o(234417);
  }
  
  public static final <T> void putData(Map<Integer, Map<Integer, T>> paramMap, int paramInt1, int paramInt2, T paramT)
  {
    AppMethodBeat.i(234380);
    s.u(paramMap, "<this>");
    if (paramMap.get(Integer.valueOf(paramInt1)) == null) {
      paramMap.put(Integer.valueOf(paramInt1), (Map)new LinkedHashMap());
    }
    paramMap = paramMap.get(Integer.valueOf(paramInt1));
    s.checkNotNull(paramMap);
    ((Map)paramMap).put(Integer.valueOf(paramInt2), paramT);
    AppMethodBeat.o(234380);
  }
  
  public static final void visitChild(View paramView, b<? super View, ah> paramb)
  {
    AppMethodBeat.i(234388);
    s.u(paramView, "<this>");
    s.u(paramb, "visitor");
    paramb.invoke(paramView);
    int i;
    int k;
    if ((paramView instanceof ViewGroup))
    {
      i = 0;
      k = ((ViewGroup)paramView).getChildCount();
      if (k <= 0) {}
    }
    for (;;)
    {
      int j = i + 1;
      View localView = ((ViewGroup)paramView).getChildAt(i);
      if (localView != null) {
        visitChild(localView, paramb);
      }
      if (j >= k)
      {
        AppMethodBeat.o(234388);
        return;
      }
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.accessibility.base.MapExpandKt
 * JD-Core Version:    0.7.0.1
 */