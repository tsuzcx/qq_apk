package com.tencent.mm.plugin.appbrand.jsapi.auth;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.d;
import com.tencent.mm.ah.e;
import com.tencent.mm.ah.e.c;
import com.tencent.mm.ah.o;
import com.tencent.mm.plugin.appbrand.widget.b.i;
import com.tencent.mm.plugin.appbrand.widget.b.i.b;
import com.tencent.mm.plugin.appbrand.widget.b.i.c;
import java.util.ArrayList;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeHelper$Companion;", "", "()V", "SCOPE_USER_INFO", "", "TAG", "getHeadIconPath", "", "username", "callback", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeHelper$GetHeadIconPathCallback;", "setUserInfoListData", "context", "Landroid/content/Context;", "bitmap", "Landroid/graphics/Bitmap;", "userNickName", "scope", "dialog", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog;", "plugin-appbrand-integration_release"})
public final class e$a
{
  public static void a(Context paramContext, Bitmap paramBitmap, String paramString1, String paramString2, i parami)
  {
    AppMethodBeat.i(134659);
    j.q(paramContext, "context");
    j.q(parami, "dialog");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new i.b(paramString1, paramContext.getResources().getString(2131297119), paramString2, paramBitmap, (byte)0));
    paramContext = (List)localArrayList;
    if (!paramContext.isEmpty())
    {
      parami.jjJ = new i.c(paramContext);
      parami.iQe.setAdapter((RecyclerView.a)parami.jjJ);
      parami.jjE.setVisibility(0);
      parami.iCq.setVisibility(8);
      parami.jjH.setVisibility(8);
      parami.jjF.setVisibility(8);
    }
    AppMethodBeat.o(134659);
  }
  
  public static void a(String paramString, e.b paramb)
  {
    AppMethodBeat.i(134658);
    j.q(paramString, "username");
    o.acQ();
    if (d.qZ(paramString))
    {
      o.acQ();
      localObject = d.D(paramString, false);
      paramString = (String)localObject;
      if (localObject == null) {
        paramString = "";
      }
      paramb.BR(paramString);
      AppMethodBeat.o(134658);
      return;
    }
    Object localObject = new e();
    ((e)localObject).a(paramString, (e.c)new e.a.a((e)localObject, paramb, paramString));
    AppMethodBeat.o(134658);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.e.a
 * JD-Core Version:    0.7.0.1
 */