package com.tencent.mm.plugin.finder.live.storage;

import android.text.TextUtils;
import com.tencent.d.a.a.a.d.a.c;
import com.tencent.d.a.a.a.d.a.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.cr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/storage/FinderLiveDislikeBannerStorage;", "Lcom/tencent/plugin/finder/live/api/storage/ApiFinderLiveDislikeBannerStorage;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "dislikeList", "Ljava/util/ArrayList;", "", "isExistDislikeBannerId", "", "dislikeBannerId", "recordDislikeBanner", "", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends com.tencent.d.a.a.a.d.d
{
  private static final a DHv;
  private ArrayList<String> DHw;
  private final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(351368);
    DHv = new a((byte)0);
    AppMethodBeat.o(351368);
  }
  
  public d(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, c.access$getInfo$cp(), "FinderLiveDislikeBannerRecord", cr.INDEX_CREATE);
    AppMethodBeat.i(351360);
    this.db = paramISQLiteDatabase;
    this.DHw = new ArrayList();
    AppMethodBeat.o(351360);
  }
  
  public final void axG(String paramString)
  {
    AppMethodBeat.i(351383);
    s.u(paramString, "dislikeBannerId");
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      AppMethodBeat.o(351383);
      return;
    }
    try
    {
      c localc = new c();
      localc.field_dislikeBannerId = paramString;
      localc.field_timestamp = System.currentTimeMillis();
      ah localah = ah.aiuX;
      boolean bool = replace((IAutoDBItem)localc);
      Log.i("Finder.FinderLiveDislikeBannerStorage", "recordDislikeBanner dislikeBannerId:%s ret:%b", new Object[] { paramString, Boolean.valueOf(bool) });
      if ((bool) && (!this.DHw.contains(paramString))) {
        this.DHw.add(paramString);
      }
      paramString = ah.aiuX;
      return;
    }
    finally
    {
      AppMethodBeat.o(351383);
    }
  }
  
  public final boolean axH(String paramString)
  {
    AppMethodBeat.i(351393);
    s.u(paramString, "dislikeBannerId");
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      AppMethodBeat.o(351393);
      return false;
    }
    if (this.DHw.contains(paramString))
    {
      AppMethodBeat.o(351393);
      return true;
    }
    try
    {
      c localc = new c();
      localc.field_dislikeBannerId = paramString;
      paramString = ah.aiuX;
      boolean bool = get((IAutoDBItem)localc, new String[0]);
      return bool;
    }
    finally
    {
      AppMethodBeat.o(351393);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/storage/FinderLiveDislikeBannerStorage$Companion;", "", "()V", "TAG", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.storage.d
 * JD-Core Version:    0.7.0.1
 */