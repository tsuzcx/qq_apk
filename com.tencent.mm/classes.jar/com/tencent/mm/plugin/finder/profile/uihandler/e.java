package com.tencent.mm.plugin.finder.profile.uihandler;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.mm.ui.MMFragment;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/uihandler/UiStyleActionHandler;", "Lcom/tencent/mm/plugin/finder/profile/uihandler/IUiStyleActionHandler;", "Landroid/view/View;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "fragment", "Lcom/tencent/mm/ui/MMFragment;", "viewIds", "", "", "views", "name", "", "(Landroidx/appcompat/app/AppCompatActivity;Lcom/tencent/mm/ui/MMFragment;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "getActivity", "()Landroidx/appcompat/app/AppCompatActivity;", "getFragment", "()Lcom/tencent/mm/ui/MMFragment;", "handleViews", "", "getHandleViews", "()Ljava/util/List;", "getName", "()Ljava/lang/String;", "getViewIds", "getViews", "findViewById", "id", "key", "registerViews", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class e
  implements b<View>
{
  private final List<View> FaY;
  private final MMFragment Fgt;
  private final List<Integer> Fgu;
  private final List<View> Fgv;
  private final AppCompatActivity activity;
  private final String name;
  
  private e(AppCompatActivity paramAppCompatActivity, List<Integer> paramList, String paramString)
  {
    this.activity = paramAppCompatActivity;
    this.Fgt = null;
    this.Fgu = paramList;
    this.FaY = null;
    this.name = paramString;
    this.Fgv = ((List)new ArrayList());
    z(this.FaY, this.Fgu);
  }
  
  protected final List<View> eKy()
  {
    return this.Fgv;
  }
  
  protected final View findViewById(int paramInt)
  {
    Object localObject = this.Fgt;
    if (localObject != null)
    {
      localObject = ((MMFragment)localObject).findViewById(paramInt);
      s.s(localObject, "it.findViewById(id)");
      return localObject;
    }
    localObject = this.activity.findViewById(paramInt);
    s.s(localObject, "activity.findViewById(id)");
    return localObject;
  }
  
  protected final AppCompatActivity getActivity()
  {
    return this.activity;
  }
  
  public void z(List<? extends View> paramList, List<Integer> paramList1)
  {
    if (paramList != null) {
      this.Fgv.addAll((Collection)paramList);
    }
    if (paramList1 != null)
    {
      paramList = ((Iterable)paramList1).iterator();
      while (paramList.hasNext())
      {
        int i = ((Number)paramList.next()).intValue();
        this.Fgv.add(findViewById(i));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.uihandler.e
 * JD-Core Version:    0.7.0.1
 */