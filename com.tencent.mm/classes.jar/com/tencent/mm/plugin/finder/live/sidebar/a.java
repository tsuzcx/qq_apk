package com.tencent.mm.plugin.finder.live.sidebar;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bfn;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/sidebar/FinderBannerUtil;", "", "()V", "TAG", "", "parseBannerExtInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBannerExtInfo;", "bannerExtInfo", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a DGm;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(352031);
    DGm = new a();
    TAG = "Finder.FinderBannerUtil";
    AppMethodBeat.o(352031);
  }
  
  public static bfn axE(String paramString)
  {
    AppMethodBeat.i(352023);
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      Log.e(TAG, "parseBannerExtInfo bannerExtInfo is empty");
      AppMethodBeat.o(352023);
      return null;
    }
    try
    {
      Object localObject = new JSONObject(paramString);
      String str1 = ((JSONObject)localObject).optString("id");
      int i = ((JSONObject)localObject).optInt("need_preload", 0);
      if (TextUtils.isEmpty((CharSequence)str1))
      {
        AppMethodBeat.o(352023);
        return null;
      }
      int j = ((JSONObject)localObject).optInt("background_source", 0);
      String str2 = ((JSONObject)localObject).optString("background_color", "");
      int k = ((JSONObject)localObject).optInt("activity_id", 0);
      localObject = new bfn();
      ((bfn)localObject).id = str1;
      ((bfn)localObject).ZPu = i;
      ((bfn)localObject).ZPv = j;
      ((bfn)localObject).background_color = str2;
      ((bfn)localObject).ZPw = k;
      Log.i(TAG, s.X("parseBannerExtInfo ", paramString));
      AppMethodBeat.o(352023);
      return localObject;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace(TAG, (Throwable)paramString, "parseBannerExtInfo", new Object[0]);
      AppMethodBeat.o(352023);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.sidebar.a
 * JD-Core Version:    0.7.0.1
 */