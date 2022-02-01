package androidx.compose.ui.platform;

import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import android.view.View;
import androidx.compose.runtime.e.f;
import androidx.compose.runtime.e.h;
import androidx.compose.ui.g.a;
import androidx.savedstate.b.b;
import androidx.savedstate.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"AcceptableClasses", "", "Ljava/lang/Class;", "", "[Ljava/lang/Class;", "DisposableSaveableStateRegistry", "Landroidx/compose/ui/platform/DisposableSaveableStateRegistry;", "view", "Landroid/view/View;", "owner", "Landroidx/savedstate/SavedStateRegistryOwner;", "id", "", "savedStateRegistryOwner", "canBeSavedToBundle", "", "value", "toBundle", "Landroid/os/Bundle;", "", "", "toMap", "ui_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class x
{
  private static final Class<? extends Object>[] aUd = { Serializable.class, Parcelable.class, String.class, SparseArray.class, Binder.class, Size.class, SizeF.class };
  
  public static final w a(View paramView, d paramd)
  {
    AppMethodBeat.i(206782);
    s.u(paramView, "view");
    s.u(paramd, "owner");
    paramView = paramView.getParent();
    if (paramView == null)
    {
      paramView = new NullPointerException("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(206782);
      throw paramView;
    }
    View localView = (View)paramView;
    paramView = localView.getTag(g.a.compose_view_saveable_id_tag);
    if ((paramView instanceof String))
    {
      paramView = (String)paramView;
      if (paramView != null) {
        break label98;
      }
      paramView = String.valueOf(localView.getId());
    }
    label98:
    for (;;)
    {
      paramView = a(paramView, paramd);
      AppMethodBeat.o(206782);
      return paramView;
      paramView = null;
      break;
    }
  }
  
  private static w a(String paramString, final d paramd)
  {
    AppMethodBeat.i(206793);
    s.u(paramString, "id");
    s.u(paramd, "savedStateRegistryOwner");
    final String str = f.class.getSimpleName() + ':' + paramString;
    paramd = paramd.getSavedStateRegistry();
    s.s(paramd, "savedStateRegistryOwner.savedStateRegistry");
    paramString = paramd.aR(str);
    if (paramString == null) {}
    for (paramString = null;; paramString = j(paramString))
    {
      paramString = h.a(paramString, (kotlin.g.a.b)c.aUh);
      try
      {
        paramd.a(str, (b.b)new b(paramString));
        bool = true;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;)
        {
          boolean bool = false;
        }
      }
      paramString = new w(paramString, (a)new a(bool, paramd, str));
      AppMethodBeat.o(206793);
      return paramString;
    }
  }
  
  private static final Map<String, List<Object>> j(Bundle paramBundle)
  {
    AppMethodBeat.i(206804);
    Map localMap = (Map)new LinkedHashMap();
    Object localObject = paramBundle.keySet();
    s.s(localObject, "this.keySet()");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      ArrayList localArrayList = paramBundle.getParcelableArrayList(str);
      if (localArrayList == null)
      {
        paramBundle = new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<kotlin.Any?>{ kotlin.collections.TypeAliasesKt.ArrayList<kotlin.Any?> }");
        AppMethodBeat.o(206804);
        throw paramBundle;
      }
      s.s(str, "key");
      localMap.put(str, localArrayList);
    }
    AppMethodBeat.o(206804);
    return localMap;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<ah>
  {
    a(boolean paramBoolean, androidx.savedstate.b paramb, String paramString)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/os/Bundle;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    implements b.b
  {
    b(f paramf) {}
    
    public final Bundle saveState()
    {
      AppMethodBeat.i(206528);
      Bundle localBundle = x.d(this.aUg.rc());
      AppMethodBeat.o(206528);
      return localBundle;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<Object, Boolean>
  {
    public static final c aUh;
    
    static
    {
      AppMethodBeat.i(206529);
      aUh = new c();
      AppMethodBeat.o(206529);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.platform.x
 * JD-Core Version:    0.7.0.1
 */