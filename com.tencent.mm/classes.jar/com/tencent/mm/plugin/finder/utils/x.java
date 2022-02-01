package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.content.res.Resources;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.loader.k;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.i.a.ae;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.CheckBoxPreference.a;
import com.tencent.mm.ui.base.preference.f;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.b;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/utils/FinderUIUtil;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderUIApi;", "()V", "TAG", "", "initWxProfileSettingPref", "", "context", "Landroid/content/Context;", "preferenceScreen", "", "profileSettingTag", "fromFinderSetting", "loadFeedToImageView", "", "feed", "imageView", "Landroid/widget/ImageView;", "plugin-finder_release"})
public final class x
  implements ae
{
  private static final String TAG = "Finder.FinderUIUtil";
  public static final x vXq;
  
  static
  {
    AppMethodBeat.i(253559);
    vXq = new x();
    TAG = "Finder.FinderUIUtil";
    AppMethodBeat.o(253559);
  }
  
  public static boolean a(Context paramContext, Object paramObject, final String paramString)
  {
    AppMethodBeat.i(253557);
    kotlin.g.b.p.h(paramContext, "context");
    kotlin.g.b.p.h(paramObject, "preferenceScreen");
    kotlin.g.b.p.h(paramString, "profileSettingTag");
    if (!(paramObject instanceof f))
    {
      AppMethodBeat.o(253557);
      return false;
    }
    Object localObject = v.vXn;
    if (v.dCt())
    {
      Log.i(TAG, "initWxProfileSettingPref");
      ((f)paramObject).jdMethod_do(paramString, false);
      paramString = ((f)paramObject).bmg(paramString);
      paramObject = paramString;
      if (!(paramString instanceof CheckBoxPreference)) {
        paramObject = null;
      }
      paramObject = (CheckBoxPreference)paramObject;
      if (paramObject != null)
      {
        paramObject.gLR();
        paramString = y.vXH;
        paramObject.setChecked(y.dCG());
        paramString = new SpannableStringBuilder();
        paramString.append((CharSequence)paramContext.getString(2131760582));
        localObject = com.tencent.mm.pluginsdk.ui.span.l.c(paramContext, (CharSequence)paramContext.getString(2131760583));
        String str = ((SpannableString)localObject).toString();
        kotlin.g.b.p.g(str, "forwardStr.toString()");
        ((SpannableString)localObject).setSpan(new com.tencent.mm.plugin.finder.view.l(str, paramContext.getResources().getColor(2131099783), paramContext.getResources().getColor(2131099790), (b)new a(paramContext)), 0, ((SpannableString)localObject).length(), 17);
        paramString.append((CharSequence)localObject);
        paramObject.setSummary((CharSequence)paramString);
        paramObject.a((CheckBoxPreference.a)new b(paramObject, paramString));
        AppMethodBeat.o(253557);
        return true;
      }
    }
    else
    {
      ((f)paramObject).jdMethod_do(paramString, true);
    }
    AppMethodBeat.o(253557);
    return false;
  }
  
  public final void a(Object paramObject, ImageView paramImageView)
  {
    AppMethodBeat.i(253558);
    if ((paramObject == null) || (paramImageView == null) || (!(paramObject instanceof FinderObject)))
    {
      AppMethodBeat.o(253558);
      return;
    }
    Object localObject1 = FinderItem.Companion;
    paramObject = FinderItem.a.a((FinderObject)paramObject, 1);
    if (paramObject.isLiveFeed()) {
      localObject1 = (cjl)j.ks((List)paramObject.getLiveMediaList());
    }
    while (((cjl)localObject1).mediaType == 4) {
      if (Util.isNullOrNil(((cjl)localObject1).coverUrl))
      {
        paramObject = new k((cjl)localObject1, com.tencent.mm.plugin.finder.storage.x.vEo, null, null, 12);
        localObject1 = m.uJa;
        localObject1 = m.djY();
        localObject2 = m.uJa;
        ((d)localObject1).a(paramObject, paramImageView, m.a(m.a.uJb));
        AppMethodBeat.o(253558);
        return;
        localObject1 = (cjl)j.ks((List)paramObject.getMediaList());
      }
      else
      {
        paramObject = new com.tencent.mm.plugin.finder.loader.q((cjl)localObject1, com.tencent.mm.plugin.finder.storage.x.vEo);
        localObject1 = m.uJa;
        localObject1 = m.djY();
        localObject2 = m.uJa;
        ((d)localObject1).a(paramObject, paramImageView, m.a(m.a.uJb));
        AppMethodBeat.o(253558);
        return;
      }
    }
    if (((cjl)localObject1).mediaType == 9)
    {
      localObject2 = ((cjl)localObject1).coverUrl;
      paramObject = localObject2;
      if (localObject2 == null) {
        paramObject = "";
      }
      kotlin.g.b.p.g(paramObject, "mediaObj.coverUrl ?: \"\"");
      localObject2 = paramObject;
      if (Util.isNullOrNil(paramObject)) {
        localObject2 = kotlin.g.b.p.I(((cjl)localObject1).thumbUrl, Util.nullAsNil(((cjl)localObject1).thumb_url_token));
      }
      paramObject = m.uJa;
      paramObject = m.djY();
      localObject1 = new com.tencent.mm.plugin.finder.loader.p((String)localObject2, com.tencent.mm.plugin.finder.storage.x.vEn);
      localObject2 = m.uJa;
      paramObject.a(localObject1, paramImageView, m.a(m.a.uJb));
      AppMethodBeat.o(253558);
      return;
    }
    paramObject = m.uJa;
    paramObject = m.djY();
    localObject1 = new k((cjl)localObject1, com.tencent.mm.plugin.finder.storage.x.vEo, null, null, 12);
    Object localObject2 = m.uJa;
    paramObject.a(localObject1, paramImageView, m.a(m.a.uJb));
    AppMethodBeat.o(253558);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke"})
  static final class a
    extends kotlin.g.b.q
    implements b<String, kotlin.x>
  {
    a(Context paramContext)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "afterOnBind"})
  static final class b
    implements CheckBoxPreference.a
  {
    b(CheckBoxPreference paramCheckBoxPreference, SpannableStringBuilder paramSpannableStringBuilder) {}
    
    public final void dCy()
    {
      AppMethodBeat.i(253556);
      Object localObject = y.vXH;
      localObject = this.vXs.gLy();
      kotlin.g.b.p.g(localObject, "pref.summaryTextView");
      y.a((TextView)localObject, (Spannable)paramString);
      AppMethodBeat.o(253556);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.x
 * JD-Core Version:    0.7.0.1
 */