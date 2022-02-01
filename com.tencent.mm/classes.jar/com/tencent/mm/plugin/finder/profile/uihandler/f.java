package com.tencent.mm.plugin.finder.profile.uihandler;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/uihandler/ViewBgStyleActionHandler;", "Lcom/tencent/mm/plugin/finder/profile/uihandler/UiStyleActionHandler;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "viewBgColor", "", "viewIds", "", "(Landroidx/appcompat/app/AppCompatActivity;ILjava/util/List;)V", "bgColor", "handleViews", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends e
{
  private int bgColor;
  
  public f(AppCompatActivity paramAppCompatActivity, int paramInt, List<Integer> paramList)
  {
    super(paramAppCompatActivity, paramList, null, 26);
    AppMethodBeat.i(348429);
    this.bgColor = paramInt;
    AppMethodBeat.o(348429);
  }
  
  public final void eKx()
  {
    AppMethodBeat.i(348439);
    Iterator localIterator = ((Iterable)eKy()).iterator();
    while (localIterator.hasNext()) {
      ((View)localIterator.next()).setBackgroundColor(this.bgColor);
    }
    AppMethodBeat.o(348439);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.uihandler.f
 * JD-Core Version:    0.7.0.1
 */