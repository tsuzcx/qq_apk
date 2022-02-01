package com.tencent.mm.plugin.finder.profile.uihandler;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/uihandler/WeImageSrcStyleActionHandler;", "Lcom/tencent/mm/plugin/finder/profile/uihandler/UiStyleActionHandler;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "weImageDatas", "", "Lkotlin/Pair;", "", "name", "", "(Landroidx/appcompat/app/AppCompatActivity;Ljava/util/List;Ljava/lang/String;)V", "handleViews", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends e
{
  private final List<r<Integer, Integer>> Fgx;
  
  private h(AppCompatActivity paramAppCompatActivity, List<r<Integer, Integer>> paramList, String paramString)
  {
    super(paramAppCompatActivity, null, paramString, 10);
    AppMethodBeat.i(348438);
    this.Fgx = paramList;
    AppMethodBeat.o(348438);
  }
  
  public final void eKx()
  {
    AppMethodBeat.i(348451);
    Iterator localIterator = this.Fgx.iterator();
    label85:
    while (localIterator.hasNext())
    {
      r localr = (r)localIterator.next();
      Object localObject = findViewById(((Number)localr.bsC).intValue());
      if ((localObject instanceof WeImageView)) {}
      for (localObject = (WeImageView)localObject;; localObject = null)
      {
        if (localObject == null) {
          break label85;
        }
        ((WeImageView)localObject).setImageResource(((Number)localr.bsD).intValue());
        break;
      }
    }
    AppMethodBeat.o(348451);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.uihandler.h
 * JD-Core Version:    0.7.0.1
 */