package com.tencent.mm.plugin.finder.profile;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.util.AttributeSet;
import android.widget.EditText;
import androidx.lifecycle.j;
import androidx.lifecycle.j.a;
import androidx.lifecycle.p;
import androidx.lifecycle.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI;
import com.tencent.mm.plugin.finder.utils.ai;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ao.a;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSSearchView;
import com.tencent.mm.view.drawer.RecyclerViewDrawer;
import com.tencent.mm.view.drawer.RecyclerViewDrawerSquares.c;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/FinderProfilePoiDrawer;", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawer;", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares$OnOpenDrawerListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "poiListView", "Lcom/tencent/mm/plugin/finder/profile/FinderProfilePoiListView;", "getPoiListView", "()Lcom/tencent/mm/plugin/finder/profile/FinderProfilePoiListView;", "setPoiListView", "(Lcom/tencent/mm/plugin/finder/profile/FinderProfilePoiListView;)V", "onDrawerOpen", "", "isOpen", "", "isBegin", "setTopPadding", "size", "Builder", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderProfilePoiDrawer
  extends RecyclerViewDrawer
  implements RecyclerViewDrawerSquares.c
{
  public static final a Fac;
  private d Fad;
  
  static
  {
    AppMethodBeat.i(348380);
    Fac = new a((byte)0);
    AppMethodBeat.o(348380);
  }
  
  public FinderProfilePoiDrawer(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(348357);
    AppMethodBeat.o(348357);
  }
  
  public FinderProfilePoiDrawer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(348363);
    AppMethodBeat.o(348363);
  }
  
  public FinderProfilePoiDrawer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(348371);
    AppMethodBeat.o(348371);
  }
  
  public final void ak(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(348408);
    super.ak(paramBoolean1, paramBoolean2);
    if (!paramBoolean1)
    {
      Object localObject = this.Fad;
      if (localObject != null)
      {
        localObject = ((d)localObject).Bny;
        if (localObject != null)
        {
          localObject = ((FTSSearchView)localObject).getFtsEditText();
          if (localObject != null)
          {
            localObject = ((FTSEditTextView)localObject).getEditText();
            if (localObject != null)
            {
              localObject = ((EditText)localObject).getText();
              if (localObject != null) {
                ((Editable)localObject).clear();
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(348408);
  }
  
  public final d getPoiListView()
  {
    return this.Fad;
  }
  
  public final void setPoiListView(d paramd)
  {
    this.Fad = paramd;
  }
  
  public final void setTopPadding(int paramInt)
  {
    AppMethodBeat.i(348399);
    Object localObject = ai.Ghs;
    localObject = getContext();
    s.s(localObject, "context");
    s.u(localObject, "context");
    s.u(localObject, "context");
    paramInt = ai.aD((Context)localObject, paramInt) + ((Context)localObject).getResources().getDimensionPixelSize(e.c.Edge_10A) * paramInt;
    int j = ao.mX((Context)localObject).height;
    int i = (int)(j * 0.75F);
    if (paramInt >= i) {
      paramInt = i;
    }
    for (;;)
    {
      setTopOffset(j - paramInt);
      setPadding(0, getTopOffset(), 0, 0);
      AppMethodBeat.o(348399);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/FinderProfilePoiDrawer$Companion;", "", "()V", "TAG", "", "createDrawerToAttachWindow", "Lcom/tencent/mm/plugin/finder/profile/FinderProfilePoiDrawer;", "context", "Landroid/content/Context;", "window", "Landroid/view/Window;", "poiListView", "Lcom/tencent/mm/plugin/finder/profile/FinderProfilePoiListView;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.FinderProfilePoiDrawer
 * JD-Core Version:    0.7.0.1
 */