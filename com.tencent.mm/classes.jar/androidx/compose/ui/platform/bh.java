package androidx.compose.ui.platform;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import androidx.compose.runtime.d;
import androidx.compose.runtime.h;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.o;
import androidx.compose.ui.g.a;
import androidx.compose.ui.i.ag;
import androidx.compose.ui.i.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"DefaultLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "TAG", "", "createSubcomposition", "Landroidx/compose/runtime/Composition;", "container", "Landroidx/compose/ui/node/LayoutNode;", "parent", "Landroidx/compose/runtime/CompositionContext;", "doSetContent", "owner", "Landroidx/compose/ui/platform/AndroidComposeView;", "content", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/platform/AndroidComposeView;Landroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function2;)Landroidx/compose/runtime/Composition;", "enableDebugInspectorInfo", "inspectionWanted", "", "setContent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;Landroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function2;)Landroidx/compose/runtime/Composition;", "ui_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class bh
{
  private static final String TAG;
  private static final ViewGroup.LayoutParams aWe;
  
  static
  {
    AppMethodBeat.i(206832);
    TAG = "Wrapper";
    aWe = new ViewGroup.LayoutParams(-2, -2);
    AppMethodBeat.o(206832);
  }
  
  public static final k a(ViewGroup paramViewGroup, l paraml, m<? super h, ? super Integer, ah> paramm)
  {
    AppMethodBeat.i(206820);
    s.u(paramViewGroup, "<this>");
    s.u(paraml, "parent");
    s.u(paramm, "content");
    Object localObject1 = z.aUi;
    z.zf();
    if (paramViewGroup.getChildCount() > 0)
    {
      localObject1 = paramViewGroup.getChildAt(0);
      if ((localObject1 instanceof AndroidComposeView)) {
        localObject1 = (AndroidComposeView)localObject1;
      }
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject1 = paramViewGroup.getContext();
        s.s(localObject1, "context");
        localObject2 = new AndroidComposeView((Context)localObject1);
        paramViewGroup.addView(((AndroidComposeView)localObject2).getView(), aWe);
      }
      int i;
      if (Build.VERSION.SDK_INT >= 29) {
        if (!bg.aWd.B((View)localObject2).isEmpty())
        {
          i = 1;
          label134:
          if (i == 0) {
            break label306;
          }
          i = 1;
          label140:
          if (i != 0)
          {
            ((AndroidComposeView)localObject2).setTag(g.a.inspection_slot_table_set, Collections.newSetFromMap((Map)new WeakHashMap()));
            if (ab.zi()) {}
          }
        }
      }
      try
      {
        paramViewGroup = Class.forName("androidx.compose.ui.platform.ab").getDeclaredField("aUn");
        paramViewGroup.setAccessible(true);
        paramViewGroup.setBoolean(null, true);
        label193:
        localObject1 = o.a((d)new ag(((AndroidComposeView)localObject2).getRoot()), paraml);
        paramViewGroup = ((AndroidComposeView)localObject2).getView().getTag(g.a.wrapped_composition_tag);
        if ((paramViewGroup instanceof WrappedComposition)) {}
        for (paramViewGroup = (WrappedComposition)paramViewGroup;; paramViewGroup = null)
        {
          paraml = paramViewGroup;
          if (paramViewGroup == null)
          {
            paraml = new WrappedComposition((AndroidComposeView)localObject2, (k)localObject1);
            ((AndroidComposeView)localObject2).getView().setTag(g.a.wrapped_composition_tag, paraml);
          }
          paraml.setContent(paramm);
          paramViewGroup = (k)paraml;
          AppMethodBeat.o(206820);
          return paramViewGroup;
          localObject1 = null;
          break;
          paramViewGroup.removeAllViews();
          localObject1 = null;
          break;
          i = 0;
          break label134;
          label306:
          i = 0;
          break label140;
        }
      }
      catch (Exception paramViewGroup)
      {
        break label193;
      }
    }
  }
  
  public static final k a(f paramf, l paraml)
  {
    AppMethodBeat.i(206803);
    s.u(paramf, "container");
    s.u(paraml, "parent");
    paramf = o.a((d)new ag(paramf), paraml);
    AppMethodBeat.o(206803);
    return paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.platform.bh
 * JD-Core Version:    0.7.0.1
 */