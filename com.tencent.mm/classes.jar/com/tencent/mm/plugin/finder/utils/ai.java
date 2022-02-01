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
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.loader.r;
import com.tencent.mm.plugin.finder.loader.t;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.loader.y;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.plugin.finder.view.o;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.CheckBoxPreference.a;
import com.tencent.mm.ui.base.preference.f;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/utils/FinderUIUtil;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderUIApi;", "()V", "TAG", "", "initWxProfileSettingPref", "", "context", "Landroid/content/Context;", "preferenceScreen", "", "profileSettingTag", "fromFinderSetting", "loadFeedToImageView", "", "feed", "imageView", "Landroid/widget/ImageView;", "plugin-finder_release"})
public final class ai
  implements com.tencent.mm.plugin.findersdk.a.af
{
  public static final ai AFJ;
  private static final String TAG = "Finder.FinderUIUtil";
  
  static
  {
    AppMethodBeat.i(282217);
    AFJ = new ai();
    TAG = "Finder.FinderUIUtil";
    AppMethodBeat.o(282217);
  }
  
  public static boolean a(Context paramContext, Object paramObject, final String paramString)
  {
    AppMethodBeat.i(282215);
    p.k(paramContext, "context");
    p.k(paramObject, "preferenceScreen");
    p.k(paramString, "profileSettingTag");
    if (!(paramObject instanceof f))
    {
      AppMethodBeat.o(282215);
      return false;
    }
    Object localObject = af.AFF;
    if (af.edP())
    {
      Log.i(TAG, "initWxProfileSettingPref");
      ((f)paramObject).dz(paramString, false);
      paramString = ((f)paramObject).byG(paramString);
      paramObject = paramString;
      if (!(paramString instanceof CheckBoxPreference)) {
        paramObject = null;
      }
      paramObject = (CheckBoxPreference)paramObject;
      if (paramObject != null)
      {
        paramObject.hKY();
        paramString = aj.AGc;
        paramObject.setChecked(aj.eed());
        paramString = new SpannableStringBuilder();
        paramString.append((CharSequence)paramContext.getString(b.j.finder_show_my_finder_setting_desc));
        localObject = com.tencent.mm.pluginsdk.ui.span.l.c(paramContext, (CharSequence)paramContext.getString(b.j.finder_show_my_finder_setting_desc_click));
        b localb = (b)new b(paramContext);
        String str = ((SpannableString)localObject).toString();
        p.j(str, "forwardStr.toString()");
        ((SpannableString)localObject).setSpan(new o(str, paramContext.getResources().getColor(b.c.Link), paramContext.getResources().getColor(b.c.Link_Alpha_0_6), false, false, localb), 0, ((SpannableString)localObject).length(), 17);
        paramString.append((CharSequence)localObject);
        paramObject.aF((CharSequence)paramString);
        paramObject.a((CheckBoxPreference.a)new a(paramObject, paramString));
        AppMethodBeat.o(282215);
        return true;
      }
    }
    else
    {
      ((f)paramObject).dz(paramString, true);
    }
    AppMethodBeat.o(282215);
    return false;
  }
  
  public final void a(Object paramObject, ImageView paramImageView)
  {
    AppMethodBeat.i(282216);
    if ((paramObject == null) || (paramImageView == null) || (!(paramObject instanceof FinderObject)))
    {
      AppMethodBeat.o(282216);
      return;
    }
    Object localObject1 = FinderItem.Companion;
    paramObject = FinderItem.a.b((FinderObject)paramObject, 1);
    if (paramObject.isLiveFeed()) {
      localObject1 = (csg)j.lo((List)paramObject.getLiveMediaList());
    }
    while (((csg)localObject1).mediaType == 4) {
      if (Util.isNullOrNil(((csg)localObject1).coverUrl))
      {
        paramObject = new r((csg)localObject1, u.Alz, null, null, 12);
        localObject1 = t.ztT;
        localObject1 = t.dJe();
        localObject2 = t.ztT;
        ((d)localObject1).a(paramObject, paramImageView, t.a(t.a.ztU));
        AppMethodBeat.o(282216);
        return;
        localObject1 = (csg)j.lo((List)paramObject.getMediaList());
      }
      else
      {
        paramObject = new y((csg)localObject1, u.Alz);
        localObject1 = t.ztT;
        localObject1 = t.dJe();
        localObject2 = t.ztT;
        ((d)localObject1).a(paramObject, paramImageView, t.a(t.a.ztU));
        AppMethodBeat.o(282216);
        return;
      }
    }
    if (((csg)localObject1).mediaType == 9)
    {
      localObject2 = ((csg)localObject1).coverUrl;
      paramObject = localObject2;
      if (localObject2 == null) {
        paramObject = "";
      }
      p.j(paramObject, "mediaObj.coverUrl ?: \"\"");
      localObject2 = paramObject;
      if (Util.isNullOrNil(paramObject)) {
        localObject2 = p.I(((csg)localObject1).thumbUrl, Util.nullAsNil(((csg)localObject1).thumb_url_token));
      }
      paramObject = t.ztT;
      paramObject = t.dJe();
      localObject1 = new com.tencent.mm.plugin.finder.loader.x((String)localObject2, u.Aly);
      localObject2 = t.ztT;
      paramObject.a(localObject1, paramImageView, t.a(t.a.ztU));
      AppMethodBeat.o(282216);
      return;
    }
    paramObject = t.ztT;
    paramObject = t.dJe();
    localObject1 = new r((csg)localObject1, u.Alz, null, null, 12);
    Object localObject2 = t.ztT;
    paramObject.a(localObject1, paramImageView, t.a(t.a.ztU));
    AppMethodBeat.o(282216);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "afterOnBind"})
  static final class a
    implements CheckBoxPreference.a
  {
    a(CheckBoxPreference paramCheckBoxPreference, SpannableStringBuilder paramSpannableStringBuilder) {}
    
    public final void edU()
    {
      AppMethodBeat.i(285383);
      Object localObject = aj.AGc;
      localObject = this.AFK.hKA();
      p.j(localObject, "pref.summaryTextView");
      aj.a((TextView)localObject, (Spannable)paramString);
      AppMethodBeat.o(285383);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class b
    extends q
    implements b<String, kotlin.x>
  {
    b(Context paramContext)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.ai
 * JD-Core Version:    0.7.0.1
 */