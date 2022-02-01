package com.tencent.mm.plugin.finder.utils;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/utils/FinderRingToneUtil;", "", "()V", "shareToRingTone", "", "context", "Landroidx/appcompat/app/AppCompatActivity;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "plugin-finder_release"})
public final class aa
{
  public static final aa AEn;
  
  static
  {
    AppMethodBeat.i(282664);
    AEn = new aa();
    AppMethodBeat.o(282664);
  }
  
  public static void a(AppCompatActivity paramAppCompatActivity, BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(282663);
    p.k(paramAppCompatActivity, "context");
    p.k(paramBaseFinderFeed, "feed");
    AppMethodBeat.o(282663);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.aa
 * JD-Core Version:    0.7.0.1
 */