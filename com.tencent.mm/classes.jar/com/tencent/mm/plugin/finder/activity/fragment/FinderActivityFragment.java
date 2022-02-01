package com.tencent.mm.plugin.finder.activity.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.activity.uic.FinderActivityContentUIC;
import com.tencent.mm.plugin.finder.activity.uic.h;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderTabUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/activity/fragment/FinderActivityFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "()V", "customTopicId", "", "getCustomTopicId", "()J", "setCustomTopicId", "(J)V", "hashTagName", "", "getHashTagName", "()Ljava/lang/String;", "setHashTagName", "(Ljava/lang/String;)V", "getCommentScene", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onUserVisibleFocused", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderActivityFragment
  extends FinderHomeTabFragment
{
  public long AtC;
  public String AtD = "";
  
  public final int getCommentScene()
  {
    return 59;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(347942);
    Set localSet = ar.setOf(new Class[] { as.class, FinderActivityContentUIC.class });
    AppMethodBeat.o(347942);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(347950);
    super.onCreate(paramBundle);
    AppMethodBeat.o(347950);
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(347961);
    s.u(paramLayoutInflater, "inflater");
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramViewGroup = getActivity();
    int i;
    if (paramViewGroup != null)
    {
      paramBundle = k.aeZF;
      paramBundle = (h)k.nq((Context)paramViewGroup).q(h.class);
      paramViewGroup = (FinderHomeTabFragment)this;
      paramBundle = (Iterable)paramBundle.getFragments();
      i = 0;
      paramBundle = paramBundle.iterator();
      if (!paramBundle.hasNext()) {
        break label176;
      }
      Object localObject = paramBundle.next();
      if (i < 0) {
        p.kkW();
      }
      if (!s.p((FinderHomeTabFragment)localObject, paramViewGroup)) {
        break label167;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.UIComponentFragment", s.X("index : ", Integer.valueOf(i)));
      if (i == 0)
      {
        paramViewGroup = k.aeZF;
        paramViewGroup = ((as)k.y((Fragment)this).q(as.class)).GTe;
        if (paramViewGroup != null) {
          paramViewGroup.visible = true;
        }
      }
      AppMethodBeat.o(347961);
      return paramLayoutInflater;
      label167:
      i += 1;
      break;
      label176:
      i = -1;
    }
  }
  
  public final void onUserVisibleFocused()
  {
    AppMethodBeat.i(347965);
    super.onUserVisibleFocused();
    AppMethodBeat.o(347965);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.activity.fragment.FinderActivityFragment
 * JD-Core Version:    0.7.0.1
 */