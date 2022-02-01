package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.content.res.Resources;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.loader.n;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.loader.t;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.finder.view.q;
import com.tencent.mm.plugin.findersdk.a.bz;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/FinderUIUtil;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderUIApi;", "()V", "TAG", "", "initWxProfileSettingPref", "", "context", "Landroid/content/Context;", "preferenceScreen", "", "profileSettingTag", "fromFinderSetting", "loadFeedToImageView", "", "feed", "imageView", "Landroid/widget/ImageView;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class au
  implements bz
{
  public static final au GiJ;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(332959);
    GiJ = new au();
    TAG = "Finder.FinderUIUtil";
    AppMethodBeat.o(332959);
  }
  
  private static final void a(CheckBoxPreference paramCheckBoxPreference, SpannableStringBuilder paramSpannableStringBuilder, View paramView)
  {
    AppMethodBeat.i(332951);
    kotlin.g.b.s.u(paramSpannableStringBuilder, "$sb");
    paramView = av.GiL;
    paramCheckBoxPreference = paramCheckBoxPreference.adXP;
    kotlin.g.b.s.s(paramCheckBoxPreference, "pref.summaryTextView");
    av.a(paramCheckBoxPreference, (Spannable)paramSpannableStringBuilder);
    AppMethodBeat.o(332951);
  }
  
  public static boolean a(Context paramContext, Object paramObject, String paramString)
  {
    AppMethodBeat.i(332944);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramObject, "preferenceScreen");
    kotlin.g.b.s.u(paramString, "profileSettingTag");
    if (!(paramObject instanceof f))
    {
      AppMethodBeat.o(332944);
      return false;
    }
    Object localObject = aq.Giv;
    if (aq.ffG())
    {
      Log.i(TAG, "initWxProfileSettingPref");
      ((f)paramObject).eh(paramString, false);
      paramObject = ((f)paramObject).bAi(paramString);
      if ((paramObject instanceof CheckBoxPreference)) {}
      for (paramObject = (CheckBoxPreference)paramObject; paramObject != null; paramObject = null)
      {
        paramObject.adZV = false;
        paramString = av.GiL;
        paramObject.setChecked(av.ffW());
        paramString = new SpannableStringBuilder();
        paramString.append((CharSequence)paramContext.getString(e.h.finder_show_my_finder_setting_desc));
        localObject = com.tencent.mm.pluginsdk.ui.span.p.d(paramContext, (CharSequence)paramContext.getString(e.h.finder_show_my_finder_setting_desc_click), 0.0F);
        b localb = (b)new a(paramContext);
        String str = ((SpannableString)localObject).toString();
        kotlin.g.b.s.s(str, "forwardStr.toString()");
        ((SpannableString)localObject).setSpan(new q(str, paramContext.getResources().getColor(e.b.Link), paramContext.getResources().getColor(e.b.Link_Alpha_0_6), false, localb), 0, ((SpannableString)localObject).length(), 17);
        paramString.append((CharSequence)localObject);
        paramObject.aS((CharSequence)paramString);
        paramObject.adXQ = new au..ExternalSyntheticLambda0(paramObject, paramString);
        AppMethodBeat.o(332944);
        return true;
      }
    }
    ((f)paramObject).eh(paramString, true);
    AppMethodBeat.o(332944);
    return false;
  }
  
  public final void a(Object paramObject, ImageView paramImageView)
  {
    AppMethodBeat.i(332977);
    if ((paramObject == null) || (paramImageView == null) || (!(paramObject instanceof FinderObject)))
    {
      AppMethodBeat.o(332977);
      return;
    }
    Object localObject1 = FinderItem.Companion;
    paramObject = FinderItem.a.e((FinderObject)paramObject, 1);
    if (paramObject.isLiveFeed()) {}
    for (localObject1 = (dji)kotlin.a.p.oL((List)paramObject.getLiveMediaList()); localObject1 == null; localObject1 = (dji)kotlin.a.p.oL((List)paramObject.getMediaList()))
    {
      AppMethodBeat.o(332977);
      return;
    }
    if (((dji)localObject1).mediaType == 4)
    {
      if (Util.isNullOrNil(((dji)localObject1).coverUrl))
      {
        paramObject = new n((dji)localObject1, v.FKZ, null, null, 12);
        localObject1 = com.tencent.mm.plugin.finder.loader.p.ExI;
        localObject1 = com.tencent.mm.plugin.finder.loader.p.eCl();
        localObject2 = com.tencent.mm.plugin.finder.loader.p.ExI;
        ((d)localObject1).a(paramObject, paramImageView, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExJ));
        AppMethodBeat.o(332977);
        return;
      }
      paramObject = new t((dji)localObject1, v.FKZ);
      localObject1 = com.tencent.mm.plugin.finder.loader.p.ExI;
      localObject1 = com.tencent.mm.plugin.finder.loader.p.eCl();
      localObject2 = com.tencent.mm.plugin.finder.loader.p.ExI;
      ((d)localObject1).a(paramObject, paramImageView, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExJ));
      AppMethodBeat.o(332977);
      return;
    }
    if (((dji)localObject1).mediaType == 9)
    {
      localObject2 = ((dji)localObject1).coverUrl;
      paramObject = localObject2;
      if (localObject2 == null) {
        paramObject = "";
      }
      localObject2 = paramObject;
      if (Util.isNullOrNil(paramObject)) {
        localObject2 = kotlin.g.b.s.X(((dji)localObject1).thumbUrl, Util.nullAsNil(((dji)localObject1).thumb_url_token));
      }
      paramObject = com.tencent.mm.plugin.finder.loader.p.ExI;
      paramObject = com.tencent.mm.plugin.finder.loader.p.eCl();
      localObject1 = new com.tencent.mm.plugin.finder.loader.s((String)localObject2, v.FKY);
      localObject2 = com.tencent.mm.plugin.finder.loader.p.ExI;
      paramObject.a(localObject1, paramImageView, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExJ));
      AppMethodBeat.o(332977);
      return;
    }
    paramObject = com.tencent.mm.plugin.finder.loader.p.ExI;
    paramObject = com.tencent.mm.plugin.finder.loader.p.eCl();
    localObject1 = new n((dji)localObject1, v.FKZ, null, null, 12);
    Object localObject2 = com.tencent.mm.plugin.finder.loader.p.ExI;
    paramObject.a(localObject1, paramImageView, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExJ));
    AppMethodBeat.o(332977);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<String, ah>
  {
    a(Context paramContext)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.au
 * JD-Core Version:    0.7.0.1
 */