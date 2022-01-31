package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import a.f.b.y;
import a.l;
import a.l.m;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.text.ClipboardManager;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.s;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI;
import com.tencent.mm.protocal.protobuf.bca;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.Arrays;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
final class i$e
  implements n.d
{
  i$e(i parami) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(152977);
    this.kiJ.kiI = false;
    a.f.b.j.p(paramMenuItem, "menuItem");
    paramInt = paramMenuItem.getItemId();
    if (paramInt == this.kiJ.kiz)
    {
      paramMenuItem = c.khX;
      paramMenuItem = this.kiJ.aZT();
      if (paramMenuItem == null) {
        a.f.b.j.ebi();
      }
      c.a((Context)paramMenuItem, i.a(this.kiJ), i.b(this.kiJ));
      AppMethodBeat.o(152977);
      return;
    }
    if (paramInt == this.kiJ.kiA)
    {
      localObject2 = this.kiJ;
      ab.i(((i)localObject2).TAG, "doTimeline");
      paramMenuItem = ((i)localObject2).hkv;
      if (paramMenuItem == null) {
        a.f.b.j.ays("ui");
      }
      if (paramMenuItem.get() != null)
      {
        paramMenuItem = ((i)localObject2).hkv;
        if (paramMenuItem == null) {
          a.f.b.j.ays("ui");
        }
        paramMenuItem = (TmplShareWebViewToolUI)paramMenuItem.get();
        if (paramMenuItem == null) {
          break label209;
        }
      }
      label209:
      for (paramMenuItem = Boolean.valueOf(paramMenuItem.isFinishing());; paramMenuItem = null)
      {
        if (paramMenuItem == null) {
          a.f.b.j.ebi();
        }
        if (!paramMenuItem.booleanValue()) {
          break;
        }
        ab.i(((i)localObject2).TAG, "activity finished");
        AppMethodBeat.o(152977);
        return;
      }
      localObject3 = new Intent();
      paramMenuItem = ((i)localObject2).jXm;
      if (paramMenuItem == null) {
        a.f.b.j.ays("msgInfo");
      }
      int i = paramMenuItem.fjD.videoWidth;
      paramInt = i;
      if (i <= 0) {
        paramInt = 150;
      }
      ((Intent)localObject3).putExtra("Ksnsupload_width", paramInt);
      ((Intent)localObject3).putExtra("Ksnsupload_height", paramInt);
      paramMenuItem = ((i)localObject2).jXn;
      if (paramMenuItem == null) {
        a.f.b.j.ays("controller");
      }
      if (paramMenuItem.aZg())
      {
        paramMenuItem = ((i)localObject2).jXn;
        if (paramMenuItem == null) {
          a.f.b.j.ays("controller");
        }
        paramMenuItem = paramMenuItem.kfA;
        if (paramMenuItem != null)
        {
          paramMenuItem = paramMenuItem.title;
          ((Intent)localObject3).putExtra("Ksnsupload_title", paramMenuItem);
          paramMenuItem = ((i)localObject2).jXn;
          if (paramMenuItem == null) {
            a.f.b.j.ays("controller");
          }
          localObject4 = paramMenuItem.kfA;
          paramMenuItem = (MenuItem)localObject1;
          if (localObject4 != null) {
            paramMenuItem = ((bca)localObject4).fjJ;
          }
          ((Intent)localObject3).putExtra("Ksnsupload_imgurl", paramMenuItem);
          label378:
          paramMenuItem = ((i)localObject2).jXn;
          if (paramMenuItem == null) {
            a.f.b.j.ays("controller");
          }
          ((Intent)localObject3).putExtra("Ksnsupload_link", paramMenuItem.url);
          paramMenuItem = ((i)localObject2).jXm;
          if (paramMenuItem == null) {
            a.f.b.j.ays("msgInfo");
          }
          paramMenuItem = paramMenuItem.fjC;
          localObject1 = ((i)localObject2).jXm;
          if (localObject1 == null) {
            a.f.b.j.ays("msgInfo");
          }
          if (bo.isNullOrNil(((s)localObject1).cqX)) {
            break label796;
          }
          localObject1 = ((i)localObject2).jXm;
          if (localObject1 == null) {
            a.f.b.j.ays("msgInfo");
          }
          ((Intent)localObject3).putExtra("src_username", ((s)localObject1).cqX);
          localObject1 = ((i)localObject2).jXm;
          if (localObject1 == null) {
            a.f.b.j.ays("msgInfo");
          }
          ((Intent)localObject3).putExtra("src_displayname", ((s)localObject1).fjB);
        }
      }
      for (;;)
      {
        ((Intent)localObject3).putExtra("Ksnsupload_type", 1);
        localObject1 = ((i)localObject2).jXn;
        if (localObject1 == null) {
          a.f.b.j.ays("controller");
        }
        ((Intent)localObject3).putExtra("ShareUrlOriginal", ((com.tencent.mm.plugin.brandservice.ui.timeline.video.b)localObject1).url);
        ((Intent)localObject3).putExtra("KPublisherId", paramMenuItem);
        ((Intent)localObject3).putExtra("need_result", true);
        paramMenuItem = com.tencent.mm.model.v.oQ(paramMenuItem);
        ((Intent)localObject3).putExtra("reportSessionId", paramMenuItem);
        localObject1 = ((i)localObject2).hkv;
        if (localObject1 == null) {
          a.f.b.j.ays("ui");
        }
        localObject1 = ((WeakReference)localObject1).get();
        if (localObject1 == null) {
          a.f.b.j.ebi();
        }
        a.f.b.j.p(localObject1, "ui.get()!!");
        localObject1 = ((TmplShareWebViewToolUI)localObject1).getIntent();
        a.f.b.j.p(localObject1, "ui.get()!!.intent");
        ((Intent)localObject3).putExtra("BizVideoDetailUIExtras", ((Intent)localObject1).getExtras());
        localObject1 = b.khW;
        localObject1 = ((i)localObject2).jXm;
        if (localObject1 == null) {
          a.f.b.j.ays("msgInfo");
        }
        localObject4 = ((i)localObject2).jXn;
        if (localObject4 == null) {
          a.f.b.j.ays("controller");
        }
        a.f.b.j.p(paramMenuItem, "sessionId");
        b.a((s)localObject1, (com.tencent.mm.plugin.brandservice.ui.timeline.video.b)localObject4, paramMenuItem, (com.tencent.mm.ipcinvoker.c)new i.b((i)localObject2, (Intent)localObject3));
        AppMethodBeat.o(152977);
        return;
        paramMenuItem = null;
        break;
        paramMenuItem = ((i)localObject2).jXm;
        if (paramMenuItem == null) {
          a.f.b.j.ays("msgInfo");
        }
        ((Intent)localObject3).putExtra("Ksnsupload_title", paramMenuItem.fjD.title);
        paramMenuItem = ((i)localObject2).jXm;
        if (paramMenuItem == null) {
          a.f.b.j.ays("msgInfo");
        }
        ((Intent)localObject3).putExtra("Ksnsupload_imgurl", paramMenuItem.fjD.fjJ);
        break label378;
        label796:
        localObject1 = ((i)localObject2).jXm;
        if (localObject1 == null) {
          a.f.b.j.ays("msgInfo");
        }
        ((Intent)localObject3).putExtra("src_username", ((s)localObject1).HD());
        localObject1 = ((i)localObject2).jXm;
        if (localObject1 == null) {
          a.f.b.j.ays("msgInfo");
        }
        ((Intent)localObject3).putExtra("src_displayname", ((s)localObject1).fjB);
      }
    }
    if (paramInt == this.kiJ.kiB)
    {
      localObject1 = this.kiJ;
      paramMenuItem = a.khV;
      paramMenuItem = ((i)localObject1).jXm;
      if (paramMenuItem == null) {
        a.f.b.j.ays("msgInfo");
      }
      localObject2 = ((i)localObject1).jXn;
      if (localObject2 == null) {
        a.f.b.j.ays("controller");
      }
      a.a(paramMenuItem, (com.tencent.mm.plugin.brandservice.ui.timeline.video.b)localObject2);
      localObject2 = (Context)((i)localObject1).aZT();
      localObject4 = ((i)localObject1).aZT();
      paramMenuItem = (MenuItem)localObject3;
      if (localObject4 != null) {
        paramMenuItem = ((TmplShareWebViewToolUI)localObject4).getString(2131299764);
      }
      h.bL((Context)localObject2, paramMenuItem);
      paramMenuItem = ((i)localObject1).jXn;
      if (paramMenuItem == null) {
        a.f.b.j.ays("controller");
      }
      paramMenuItem.kfr.sK(24);
      AppMethodBeat.o(152977);
      return;
    }
    if (paramInt == this.kiJ.kiC)
    {
      com.tencent.mm.plugin.webview.f.c.a((Context)this.kiJ.aZT(), i.a(this.kiJ).fjD.title, (DialogInterface.OnClickListener)new i.e.1(this));
      AppMethodBeat.o(152977);
      return;
    }
    if (paramInt == this.kiJ.kiD)
    {
      paramMenuItem = this.kiJ.aZT();
      if (paramMenuItem != null)
      {
        paramMenuItem = paramMenuItem.uQS;
        if (paramMenuItem != null)
        {
          paramMenuItem.o(0, "", 0);
          AppMethodBeat.o(152977);
          return;
        }
      }
      AppMethodBeat.o(152977);
      return;
    }
    if (paramInt == this.kiJ.kiE)
    {
      localObject1 = this.kiJ;
      paramMenuItem = ((i)localObject1).jXn;
      if (paramMenuItem == null) {
        a.f.b.j.ays("controller");
      }
      if ((paramMenuItem.fgk & 0x1) != 0)
      {
        paramMenuItem = ((i)localObject1).TAG;
        localObject2 = new StringBuilder("not allow jump to profile ");
        localObject1 = ((i)localObject1).jXn;
        if (localObject1 == null) {
          a.f.b.j.ays("controller");
        }
        ab.w(paramMenuItem, ((com.tencent.mm.plugin.brandservice.ui.timeline.video.b)localObject1).fgk);
        AppMethodBeat.o(152977);
        return;
      }
      if (((i)localObject1).aZT() != null)
      {
        localObject2 = ((i)localObject1).aZT();
        paramMenuItem = (MenuItem)localObject4;
        if (localObject2 != null) {
          paramMenuItem = ((TmplShareWebViewToolUI)localObject2).vfS;
        }
        if (paramMenuItem != null) {}
      }
      else
      {
        AppMethodBeat.o(152977);
        return;
      }
      paramMenuItem = ((i)localObject1).aZT();
      if (paramMenuItem != null)
      {
        paramMenuItem = paramMenuItem.vfS;
        if (paramMenuItem != null) {
          paramMenuItem.dR("Contact_Scene", 153);
        }
      }
      paramMenuItem = ((i)localObject1).aZT();
      if (paramMenuItem != null)
      {
        localObject1 = ((i)localObject1).jXn;
        if (localObject1 == null) {
          a.f.b.j.ays("controller");
        }
        paramMenuItem.air(((com.tencent.mm.plugin.brandservice.ui.timeline.video.b)localObject1).HD());
        AppMethodBeat.o(152977);
        return;
      }
      AppMethodBeat.o(152977);
      return;
    }
    if (paramInt == this.kiJ.kiF)
    {
      localObject1 = this.kiJ;
      if (((i)localObject1).isFinished())
      {
        ab.e(((i)localObject1).TAG, "copyLink fail, is finish");
        AppMethodBeat.o(152977);
        return;
      }
      paramMenuItem = ((i)localObject1).aZT();
      if (paramMenuItem != null)
      {
        paramMenuItem = paramMenuItem.getApplication();
        if (paramMenuItem == null) {}
      }
      for (paramMenuItem = paramMenuItem.getSystemService("clipboard"); paramMenuItem == null; paramMenuItem = null)
      {
        paramMenuItem = new a.v("null cannot be cast to non-null type android.text.ClipboardManager");
        AppMethodBeat.o(152977);
        throw paramMenuItem;
      }
      paramMenuItem = (ClipboardManager)paramMenuItem;
      if (paramMenuItem != null) {
        for (;;)
        {
          try
          {
            localObject2 = ((i)localObject1).jXn;
            if (localObject2 == null) {
              a.f.b.j.ays("controller");
            }
            paramMenuItem.setText((CharSequence)((com.tencent.mm.plugin.brandservice.ui.timeline.video.b)localObject2).kfq);
            localObject2 = (Context)((i)localObject1).aZT();
            paramMenuItem = ((i)localObject1).aZT();
            if (paramMenuItem != null)
            {
              paramMenuItem = paramMenuItem.getString(2131306000);
              Toast.makeText((Context)localObject2, (CharSequence)paramMenuItem, 0).show();
              AppMethodBeat.o(152977);
              return;
            }
          }
          catch (Exception paramMenuItem)
          {
            ab.printErrStackTrace(((i)localObject1).TAG, (Throwable)paramMenuItem, "clip.setText error", new Object[0]);
            AppMethodBeat.o(152977);
            return;
          }
          paramMenuItem = null;
        }
      }
      ab.e(((i)localObject1).TAG, "clipboard manager is null");
      AppMethodBeat.o(152977);
      return;
    }
    if (paramInt == this.kiJ.kiG)
    {
      localObject3 = this.kiJ;
      paramMenuItem = ((i)localObject3).jXm;
      if (paramMenuItem == null) {
        a.f.b.j.ays("msgInfo");
      }
      localObject4 = paramMenuItem.fjD.url;
      if (bo.isNullOrNil((String)localObject4)) {
        break label1990;
      }
      paramMenuItem = Uri.parse((String)localObject4);
      a.f.b.j.p(paramMenuItem, "uri");
    }
    label1987:
    label1990:
    for (paramMenuItem = paramMenuItem.getHost();; paramMenuItem = null)
    {
      if (!bo.isNullOrNil(paramMenuItem))
      {
        if (paramMenuItem == null) {
          a.f.b.j.ebi();
        }
        if (!m.jw(paramMenuItem, "mp.weixin.qq.com")) {}
      }
      for (;;)
      {
        try
        {
          paramMenuItem = y.BNt;
          paramMenuItem = String.format("https://mp.weixin.qq.com/mp/infringement?url=%s#wechat_redirect", Arrays.copyOf(new Object[] { com.tencent.mm.compatible.util.q.encode((String)localObject4, "utf-8") }, 1));
          a.f.b.j.p(paramMenuItem, "java.lang.String.format(format, *args)");
          if (!bo.isNullOrNil(paramMenuItem)) {
            break label1987;
          }
          paramMenuItem = y.BNt;
          paramMenuItem = String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", Arrays.copyOf(new Object[] { Integer.valueOf(34) }, 1));
          a.f.b.j.p(paramMenuItem, "java.lang.String.format(format, *args)");
          localIntent = new Intent();
        }
        catch (UnsupportedEncodingException paramMenuItem)
        {
          Intent localIntent;
          ab.e(((i)localObject3).TAG, paramMenuItem.getMessage());
        }
        try
        {
          localObject1 = ((i)localObject3).aZT();
          if (localObject1 == null) {
            break label1909;
          }
          localObject1 = ((TmplShareWebViewToolUI)localObject1).getDir("expose", 0);
          if (localObject1 != null) {
            ((File)localObject1).mkdirs();
          }
          if (localObject1 != null) {
            localObject2 = ((File)localObject1).getAbsolutePath();
          }
          localObject1 = a.f.b.j.w((String)localObject2, "/screenshot.jpg");
          com.tencent.mm.sdk.platformtools.d.a(bc.au((Activity)((i)localObject3).aZT()), 75, Bitmap.CompressFormat.JPEG, (String)localObject1, true);
          localIntent.putExtra("k_webview_img", (String)localObject1);
        }
        catch (IOException localIOException)
        {
          ab.e(((i)localObject3).TAG, "[oneliang]save screen shot to file error, ex = " + localIOException.getMessage());
          continue;
        }
        localIntent.putExtra("rawUrl", paramMenuItem);
        localIntent.putExtra("k_expose_url", (String)localObject4);
        paramMenuItem = ((i)localObject3).jXn;
        if (paramMenuItem == null) {
          a.f.b.j.ays("controller");
        }
        localIntent.putExtra("k_expose_web_scene", paramMenuItem.scene);
        localIntent.putExtra("showShare", false);
        com.tencent.mm.bq.d.b((Context)((i)localObject3).aZT(), "webview", ".ui.tools.WebViewUI", localIntent);
        AppMethodBeat.o(152977);
        return;
        paramMenuItem = null;
        continue;
        label1909:
        localObject1 = null;
        continue;
        ab.w(this.kiJ.TAG, "wrong id: " + paramMenuItem.getItemId());
        AppMethodBeat.o(152977);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i.e
 * JD-Core Version:    0.7.0.1
 */