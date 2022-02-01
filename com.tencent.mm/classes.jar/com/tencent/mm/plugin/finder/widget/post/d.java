package com.tencent.mm.plugin.finder.widget.post;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.k.i;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.feed.ui.FinderEmojiSelectUI;
import com.tencent.mm.plugin.finder.publish.l.b;
import com.tencent.mm.plugin.finder.publish.l.i;
import com.tencent.mm.plugin.finder.report.bb;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.protocal.protobuf.brx;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/widget/post/PostExtendLinkUtils;", "", "()V", "MENU_ID_DELETE", "", "MENU_ID_DELETE_LINK", "MENU_ID_PREVIEW_LINK", "gotoDesignerEmojiListUI", "", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "contact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "gotoTencentSelectUI", "isEmojiEnabled", "", "showBottomSheet", "doPreview", "Lkotlin/Function0;", "doDelete", "showDelBottomSheet", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d Haf;
  
  static
  {
    AppMethodBeat.i(330794);
    Haf = new d();
    AppMethodBeat.o(330794);
  }
  
  public static void a(AppCompatActivity paramAppCompatActivity, m paramm)
  {
    AppMethodBeat.i(330754);
    kotlin.g.b.s.u(paramAppCompatActivity, "activity");
    Intent localIntent = new Intent((Context)paramAppCompatActivity, FinderEmojiSelectUI.class);
    if (paramm == null) {}
    for (paramm = null;; paramm = paramm.field_username)
    {
      Object localObject = paramm;
      if (paramm == null) {
        localObject = z.bAW();
      }
      localIntent.putExtra("finder_username", (String)localObject);
      paramAppCompatActivity.startActivityForResult(localIntent, 20004);
      paramm = k.aeZF;
      paramAppCompatActivity = ((as)k.d(paramAppCompatActivity).q(as.class)).fou();
      paramAppCompatActivity.AJo = 74;
      paramm = bb.FuK;
      bb.a(paramAppCompatActivity, "button_post_choose_emoji", 1);
      AppMethodBeat.o(330754);
      return;
    }
  }
  
  private static final void a(AppCompatActivity paramAppCompatActivity, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(330776);
    kotlin.g.b.s.u(paramAppCompatActivity, "$activity");
    if (params.jmw())
    {
      params.a(1, paramAppCompatActivity.getResources().getColor(l.b.black_color), (CharSequence)paramAppCompatActivity.getResources().getString(l.i.finder_preview_link));
      params.a(2, -65536, (CharSequence)paramAppCompatActivity.getResources().getString(l.i.finder_delete_link));
    }
    AppMethodBeat.o(330776);
  }
  
  public static void a(AppCompatActivity paramAppCompatActivity, a<ah> parama1, a<ah> parama2)
  {
    AppMethodBeat.i(330741);
    kotlin.g.b.s.u(paramAppCompatActivity, "activity");
    kotlin.g.b.s.u(parama1, "doPreview");
    kotlin.g.b.s.u(parama2, "doDelete");
    com.tencent.mm.ui.widget.a.f localf = new com.tencent.mm.ui.widget.a.f((Context)paramAppCompatActivity, 1, true);
    localf.Vtg = new d..ExternalSyntheticLambda0(paramAppCompatActivity);
    localf.GAC = new d..ExternalSyntheticLambda1(parama1, parama2);
    localf.dDn();
    AppMethodBeat.o(330741);
  }
  
  private static final void a(a parama1, a parama2, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(330784);
    kotlin.g.b.s.u(parama1, "$doPreview");
    kotlin.g.b.s.u(parama2, "$doDelete");
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(330784);
      return;
      parama1.invoke();
      AppMethodBeat.o(330784);
      return;
      parama2.invoke();
    }
  }
  
  public static void b(AppCompatActivity paramAppCompatActivity)
  {
    AppMethodBeat.i(330768);
    kotlin.g.b.s.u(paramAppCompatActivity, "activity");
    String str = i.aRC().getValue("FinderTencentVideoChooseLink");
    if (Util.isNullOrNil(str)) {
      str = "https://m.v.qq.com/video/selection/index.html";
    }
    label129:
    label396:
    for (;;)
    {
      Object localObject = k.aeZF;
      brx localbrx = ((com.tencent.mm.plugin.finder.post.f)k.d(paramAppCompatActivity).q(com.tencent.mm.plugin.finder.post.f.class)).eHl().GZV;
      char c = '?';
      int i;
      if ((localbrx != null) && (localbrx.businessType == 1))
      {
        i = 1;
        if (i == 0) {
          break label422;
        }
        str = kotlin.g.b.s.X(str, "?".concat(String.valueOf("businessType=" + localbrx + "?.businessType")));
        c = '&';
      }
      label153:
      label411:
      label416:
      label419:
      label422:
      for (;;)
      {
        if (localbrx == null)
        {
          localObject = null;
          localObject = (CharSequence)localObject;
          if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
            break label396;
          }
          i = 1;
          if (i != 0) {
            break label419;
          }
          localObject = "cid=" + localbrx + "?.cid";
          str = kotlin.g.b.s.X(str, String.valueOf(c) + (String)localObject);
          c = '&';
        }
        for (;;)
        {
          if (localbrx == null)
          {
            localObject = null;
            label221:
            localObject = (CharSequence)localObject;
            if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
              break label411;
            }
            i = 1;
            label245:
            if (i != 0) {
              break label416;
            }
            localObject = "lid=" + localbrx + "?.lid";
            str = kotlin.g.b.s.X(str, String.valueOf(c) + (String)localObject);
            c = '&';
          }
          for (;;)
          {
            localObject = MD5Util.getMD5String(str);
            str = str + c + "callBackKey=" + localObject;
            localObject = new Intent();
            ((Intent)localObject).putExtra("rawUrl", str);
            com.tencent.mm.br.c.b((Context)paramAppCompatActivity, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
            AppMethodBeat.o(330768);
            return;
            i = 0;
            break;
            localObject = localbrx.Rfi;
            break label129;
            i = 0;
            break label153;
            localObject = localbrx.ZZV;
            break label221;
            i = 0;
            break label245;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.post.d
 * JD-Core Version:    0.7.0.1
 */