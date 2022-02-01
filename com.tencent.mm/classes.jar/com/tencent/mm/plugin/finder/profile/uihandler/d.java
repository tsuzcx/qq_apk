package com.tencent.mm.plugin.finder.profile.uihandler;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/uihandler/TextStyleActionHandler;", "Lcom/tencent/mm/plugin/finder/profile/uihandler/UiStyleActionHandler;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "normalTextColor", "", "viewIds", "", "(Landroidx/appcompat/app/AppCompatActivity;ILjava/util/List;)V", "textColor", "getTextColor", "()I", "setTextColor", "(I)V", "handleViews", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends e
{
  public int textColor;
  
  public d(AppCompatActivity paramAppCompatActivity, int paramInt, List<Integer> paramList)
  {
    super(paramAppCompatActivity, paramList, null, 26);
    AppMethodBeat.i(348427);
    this.textColor = paramInt;
    AppMethodBeat.o(348427);
  }
  
  public final void eKx()
  {
    AppMethodBeat.i(348443);
    Iterator localIterator = ((Iterable)eKy()).iterator();
    label67:
    while (localIterator.hasNext())
    {
      Object localObject = (View)localIterator.next();
      if ((localObject instanceof TextView)) {}
      for (localObject = (TextView)localObject;; localObject = null)
      {
        if (localObject == null) {
          break label67;
        }
        ((TextView)localObject).setTextColor(this.textColor);
        break;
      }
    }
    AppMethodBeat.o(348443);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.uihandler.d
 * JD-Core Version:    0.7.0.1
 */