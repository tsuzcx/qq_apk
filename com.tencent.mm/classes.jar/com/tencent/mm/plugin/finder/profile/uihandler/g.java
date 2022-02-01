package com.tencent.mm.plugin.finder.profile.uihandler;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/uihandler/WeImageColorStyleActionHandler;", "Lcom/tencent/mm/plugin/finder/profile/uihandler/UiStyleActionHandler;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "normalTextColor", "", "viewIds", "", "name", "", "(Landroidx/appcompat/app/AppCompatActivity;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;)V", "iconColor", "getIconColor", "()Ljava/lang/Integer;", "setIconColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "handleViews", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends e
{
  public Integer Fgw;
  
  private g(AppCompatActivity paramAppCompatActivity, Integer paramInteger, List<Integer> paramList, String paramString)
  {
    super(paramAppCompatActivity, paramList, paramString, 10);
    AppMethodBeat.i(348437);
    this.Fgw = paramInteger;
    AppMethodBeat.o(348437);
  }
  
  public final void eKx()
  {
    AppMethodBeat.i(348455);
    Iterator localIterator = ((Iterable)eKy()).iterator();
    label138:
    label145:
    label150:
    label153:
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      Object localObject = this.Fgw;
      if (localObject == null)
      {
        localObject = null;
        label49:
        if (localObject != null) {
          break label138;
        }
        if (!(localView instanceof WeImageView)) {
          break label145;
        }
        localObject = (WeImageView)localView;
        label67:
        if (localObject != null) {
          ((WeImageView)localObject).setIconColor(0);
        }
        if (!(localView instanceof WeImageView)) {
          break label150;
        }
      }
      for (localObject = (WeImageView)localView;; localObject = null)
      {
        if (localObject == null) {
          break label153;
        }
        ((WeImageView)localObject).clearColorFilter();
        break;
        int i = ((Number)localObject).intValue();
        if ((localView instanceof WeImageView)) {}
        for (localObject = (WeImageView)localView;; localObject = null)
        {
          if (localObject != null) {
            ((WeImageView)localObject).setIconColor(i);
          }
          localObject = Integer.valueOf(i);
          break label49;
          break;
        }
        localObject = null;
        break label67;
      }
    }
    AppMethodBeat.o(348455);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.uihandler.g
 * JD-Core Version:    0.7.0.1
 */