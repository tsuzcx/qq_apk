package com.tencent.mm.openim.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.ImageSpan;
import android.text.style.TextAppearanceSpan;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.openim.a.a.a;
import com.tencent.mm.openim.e.d;
import com.tencent.mm.openim.e.e;
import com.tencent.mm.openim.e.f;
import com.tencent.mm.pluginsdk.ui.span.MMTextAppearanceSpan;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.ax;
import com.tencent.mm.protocal.protobuf.cgk;
import com.tencent.mm.protocal.protobuf.cgl;
import com.tencent.mm.protocal.protobuf.em;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.EllipsizeTextView;
import com.tencent.mm.ui.base.EllipsizeTextView.a;
import com.tencent.mm.vfs.o;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class t
  implements com.tencent.mm.openim.a.a
{
  private HashMap<String, b> iKE;
  private EllipsizeTextView.a iKF;
  private EllipsizeTextView.a iKG;
  
  public t()
  {
    AppMethodBeat.i(151238);
    this.iKE = new HashMap();
    this.iKF = new EllipsizeTextView.a()
    {
      public final CharSequence a(TextView paramAnonymousTextView, CharSequence paramAnonymousCharSequence, String paramAnonymousString, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(151234);
        float f = paramAnonymousTextView.getPaint().measureText(" ".concat(String.valueOf(paramAnonymousString)));
        int i = paramAnonymousTextView.getMeasuredWidth() - paramAnonymousTextView.getCompoundPaddingRight() - paramAnonymousTextView.getCompoundPaddingLeft();
        if (f >= i * 0.6D)
        {
          paramAnonymousCharSequence = TextUtils.ellipsize(paramAnonymousCharSequence, paramAnonymousTextView.getPaint(), (float)(i * 0.4D), TextUtils.TruncateAt.END);
          f = paramAnonymousTextView.getPaint().measureText(paramAnonymousCharSequence.toString());
          paramAnonymousString = TextUtils.ellipsize(paramAnonymousString, paramAnonymousTextView.getPaint(), i - f - 20.0F, TextUtils.TruncateAt.END);
        }
        for (;;)
        {
          SpannableString localSpannableString = k.c(paramAnonymousTextView.getContext(), paramAnonymousCharSequence + " " + paramAnonymousString);
          paramAnonymousTextView = com.tencent.mm.cb.a.m(paramAnonymousTextView.getContext(), paramAnonymousInt1);
          localSpannableString.setSpan(new TextAppearanceSpan(null, 0, paramAnonymousInt2, paramAnonymousTextView, paramAnonymousTextView), paramAnonymousCharSequence.length() + 1, paramAnonymousCharSequence.length() + 1 + paramAnonymousString.length(), 33);
          AppMethodBeat.o(151234);
          return localSpannableString;
          paramAnonymousCharSequence = TextUtils.ellipsize(paramAnonymousCharSequence, paramAnonymousTextView.getPaint(), i - f, TextUtils.TruncateAt.END);
        }
      }
    };
    this.iKG = new EllipsizeTextView.a()
    {
      public final CharSequence a(TextView paramAnonymousTextView, CharSequence paramAnonymousCharSequence, String paramAnonymousString, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(151235);
        paramAnonymousString = paramAnonymousTextView.getContext().getResources().getDrawable(2131691000);
        paramAnonymousString.setBounds(0, 0, paramAnonymousString.getIntrinsicWidth(), paramAnonymousString.getIntrinsicHeight());
        float f1 = paramAnonymousString.getIntrinsicWidth();
        float f2 = paramAnonymousTextView.getPaint().measureText(" ");
        paramAnonymousTextView = TextUtils.ellipsize(paramAnonymousCharSequence, paramAnonymousTextView.getPaint(), paramAnonymousTextView.getMeasuredWidth() - paramAnonymousTextView.getCompoundPaddingRight() - paramAnonymousTextView.getCompoundPaddingLeft() - (f1 + f2), TextUtils.TruncateAt.END);
        paramAnonymousCharSequence = new SpannableStringBuilder(paramAnonymousTextView);
        paramAnonymousCharSequence.append(" ");
        paramAnonymousCharSequence.setSpan(new ImageSpan(paramAnonymousString), paramAnonymousTextView.length(), paramAnonymousTextView.length() + 1, 33);
        AppMethodBeat.o(151235);
        return paramAnonymousCharSequence;
      }
    };
    o.aZI("wcf://openim/");
    com.tencent.mm.openim.e.c localc = new com.tencent.mm.openim.e.c();
    localc.field_appid = "3552365301";
    localc.field_language = ad.iR(ak.getContext());
    com.tencent.mm.kernel.g.ajS();
    ((PluginOpenIM)com.tencent.mm.kernel.g.ad(PluginOpenIM.class)).getAppIdInfoStg().get(localc, new String[] { "appid", "language" });
    if (localc.systemRowid == -1L)
    {
      Jf("3552365301");
      AppMethodBeat.o(151238);
      return;
    }
    AppMethodBeat.o(151238);
  }
  
  private void Jf(String paramString)
  {
    AppMethodBeat.i(151256);
    bD(paramString, ad.iR(ak.getContext()));
    AppMethodBeat.o(151256);
  }
  
  private static String a(String paramString1, String paramString2, a.a parama, String paramString3)
  {
    AppMethodBeat.i(151249);
    com.tencent.mm.openim.e.a locala = new com.tencent.mm.openim.e.a();
    locala.field_acctTypeId = paramString1;
    locala.field_language = paramString3;
    com.tencent.mm.kernel.g.ajS();
    ((PluginOpenIM)com.tencent.mm.kernel.g.ad(PluginOpenIM.class)).getAccTypeInfoStg().get(locala, new String[] { "acctTypeId", "language" });
    if (locala.systemRowid == -1L)
    {
      AppMethodBeat.o(151249);
      return null;
    }
    if (parama == a.a.iKm)
    {
      paramString1 = locala.field_accTypeRec.FKP.iterator();
      while (paramString1.hasNext())
      {
        parama = (cgl)paramString1.next();
        if (paramString2.equals(parama.key))
        {
          paramString1 = parama.dyI;
          AppMethodBeat.o(151249);
          return paramString1;
        }
      }
      AppMethodBeat.o(151249);
      return null;
    }
    paramString1 = locala.field_accTypeRec.ddt.iterator();
    while (paramString1.hasNext())
    {
      parama = (cgk)paramString1.next();
      if (paramString2.equals(parama.key))
      {
        paramString1 = parama.url;
        AppMethodBeat.o(151249);
        return paramString1;
      }
    }
    AppMethodBeat.o(151249);
    return null;
  }
  
  private String b(String paramString1, String paramString2, a.a parama, String paramString3)
  {
    AppMethodBeat.i(151251);
    com.tencent.mm.openim.e.c localc = new com.tencent.mm.openim.e.c();
    localc.field_appid = paramString1;
    localc.field_language = paramString3;
    com.tencent.mm.kernel.g.ajS();
    ((PluginOpenIM)com.tencent.mm.kernel.g.ad(PluginOpenIM.class)).getAppIdInfoStg().get(localc, new String[] { "appid", "language" });
    if (localc.systemRowid == -1L)
    {
      bD(paramString1, paramString3);
      AppMethodBeat.o(151251);
      return null;
    }
    if (parama == a.a.iKm)
    {
      paramString1 = localc.field_appRec.FKP.iterator();
      while (paramString1.hasNext())
      {
        parama = (cgl)paramString1.next();
        if (paramString2.equals(parama.key))
        {
          paramString1 = parama.dyI;
          AppMethodBeat.o(151251);
          return paramString1;
        }
      }
      AppMethodBeat.o(151251);
      return null;
    }
    paramString1 = localc.field_appRec.ddt.iterator();
    while (paramString1.hasNext())
    {
      parama = (cgk)paramString1.next();
      if (paramString2.equals(parama.key))
      {
        paramString1 = parama.url;
        AppMethodBeat.o(151251);
        return paramString1;
      }
    }
    AppMethodBeat.o(151251);
    return null;
  }
  
  private void bD(String paramString1, String paramString2)
  {
    AppMethodBeat.i(151257);
    s(paramString1, paramString2, "");
    AppMethodBeat.o(151257);
  }
  
  private String t(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(151255);
    e locale = new e();
    locale.field_appid = paramString1;
    locale.field_language = paramString3;
    locale.field_wordingId = paramString2;
    com.tencent.mm.kernel.g.ajS();
    ((PluginOpenIM)com.tencent.mm.kernel.g.ad(PluginOpenIM.class)).getWordingInfoStg().get(locale, new String[] { "appid", "language", "wordingId" });
    if (locale.systemRowid == -1L)
    {
      s(paramString1, paramString3, paramString2);
      AppMethodBeat.o(151255);
      return null;
    }
    paramString1 = locale.field_wording;
    AppMethodBeat.o(151255);
    return paramString1;
  }
  
  public final Bitmap Jb(String paramString)
  {
    AppMethodBeat.i(151245);
    final a locala = new a((byte)0);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(151245);
      return null;
    }
    Object localObject = new c.a();
    ((c.a)localObject).igk = true;
    ((c.a)localObject).hgD = ("wcf://openim/" + com.tencent.mm.b.g.getMessageDigest(paramString.getBytes()));
    localObject = ((c.a)localObject).aJu();
    com.tencent.mm.av.q.aJb().a(paramString, null, (com.tencent.mm.av.a.a.c)localObject, new com.tencent.mm.av.a.c.h()
    {
      public final Bitmap a(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.av.a.d.b paramAnonymousb)
      {
        return null;
      }
      
      public final void b(String paramAnonymousString, View paramAnonymousView) {}
      
      public final void b(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.av.a.d.b paramAnonymousb)
      {
        AppMethodBeat.i(151236);
        if ((paramAnonymousb.status == 0) && (paramAnonymousb.bitmap != null) && (!paramAnonymousb.bitmap.isRecycled())) {
          locala.bitmap = paramAnonymousb.bitmap;
        }
        AppMethodBeat.o(151236);
      }
    });
    paramString = locala.bitmap;
    AppMethodBeat.o(151245);
    return paramString;
  }
  
  public final int Jc(String paramString)
  {
    AppMethodBeat.i(151246);
    com.tencent.mm.openim.e.c localc = new com.tencent.mm.openim.e.c();
    localc.field_appid = paramString;
    com.tencent.mm.kernel.g.ajS();
    ((PluginOpenIM)com.tencent.mm.kernel.g.ad(PluginOpenIM.class)).getAppIdInfoStg().get(localc, new String[] { "appid" });
    if (localc.systemRowid == -1L)
    {
      Jf(paramString);
      AppMethodBeat.o(151246);
      return 0;
    }
    int i = localc.field_appRec.FOH;
    AppMethodBeat.o(151246);
    return i;
  }
  
  public final CharSequence a(Context paramContext, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(151240);
    Object localObject = paramCharSequence;
    if (bu.ah(paramCharSequence)) {
      localObject = "";
    }
    paramCharSequence = new SpannableStringBuilder((CharSequence)localObject);
    paramCharSequence.append(" ");
    paramContext = paramContext.getResources().getDrawable(2131691000);
    paramContext.setBounds(0, 0, paramContext.getIntrinsicWidth(), paramContext.getIntrinsicHeight());
    paramCharSequence.setSpan(new ImageSpan(paramContext), ((CharSequence)localObject).length(), ((CharSequence)localObject).length() + 1, 33);
    AppMethodBeat.o(151240);
    return paramCharSequence;
  }
  
  public final CharSequence a(Context paramContext, String paramString1, String paramString2, float paramFloat)
  {
    AppMethodBeat.i(151244);
    paramString1 = Jb(paramString1);
    if (paramString1 != null)
    {
      paramString2 = k.b(paramContext, "  ".concat(String.valueOf(paramString2)), paramFloat);
      int i = (int)(com.tencent.mm.cb.a.fromDPToPix(paramContext, 2) + paramFloat);
      paramContext = new ImageSpan(ak.getContext(), paramString1);
      paramContext.getDrawable().setBounds(0, 0, i, i);
      paramString2.setSpan(paramContext, 0, 1, 33);
      AppMethodBeat.o(151244);
      return paramString2;
    }
    AppMethodBeat.o(151244);
    return paramString2;
  }
  
  public final String a(String paramString1, String paramString2, a.a parama)
  {
    AppMethodBeat.i(151247);
    com.tencent.mm.openim.e.c localc = new com.tencent.mm.openim.e.c();
    localc.field_appid = paramString1;
    com.tencent.mm.kernel.g.ajS();
    ((PluginOpenIM)com.tencent.mm.kernel.g.ad(PluginOpenIM.class)).getAppIdInfoStg().get(localc, new String[] { "appid" });
    if (localc.systemRowid == -1L)
    {
      Jf(paramString1);
      AppMethodBeat.o(151247);
      return null;
    }
    String str = a(localc.field_acctTypeId, paramString2, parama, ad.iR(ak.getContext()));
    paramString1 = str;
    if (str == null) {
      paramString1 = a(localc.field_acctTypeId, paramString2, parama, "en");
    }
    AppMethodBeat.o(151247);
    return paramString1;
  }
  
  public final void a(Context paramContext, TextView paramTextView, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(151243);
    if ((paramTextView instanceof EllipsizeTextView))
    {
      paramContext = (EllipsizeTextView)paramTextView;
      paramContext.setLayoutCallback(this.iKG);
      paramContext.a(paramCharSequence, " ", -1, (int)paramTextView.getTextSize());
      AppMethodBeat.o(151243);
      return;
    }
    paramTextView.setText(((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.a.class)).a(paramContext, paramCharSequence));
    AppMethodBeat.o(151243);
  }
  
  public final void a(Context paramContext, TextView paramTextView, CharSequence paramCharSequence, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(151242);
    if ((paramTextView instanceof EllipsizeTextView))
    {
      EllipsizeTextView localEllipsizeTextView = (EllipsizeTextView)paramTextView;
      paramTextView = ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.a.class)).bC(paramString1, paramString2);
      if (!bu.isNullOrNil(paramTextView))
      {
        paramContext = paramTextView;
        if (!"3552365301".equals(paramString1)) {}
      }
      for (paramContext = " @".concat(String.valueOf(paramTextView));; paramContext = "")
      {
        localEllipsizeTextView.setLayoutCallback(this.iKF);
        localEllipsizeTextView.a(paramCharSequence, paramContext, 2131100723, paramInt);
        AppMethodBeat.o(151242);
        return;
      }
    }
    paramString2 = ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.a.class)).bC(paramString1, paramString2);
    if (!bu.isNullOrNil(paramString2)) {
      if (!"3552365301".equals(paramString1)) {
        break label252;
      }
    }
    label252:
    for (paramString1 = " @".concat(String.valueOf(paramString2));; paramString1 = paramString2)
    {
      paramString2 = k.b(paramContext, paramCharSequence, paramInt);
      paramCharSequence = new SpannableStringBuilder();
      paramCharSequence.append(paramString2);
      paramString2 = new SpannableString(paramString1);
      paramContext = com.tencent.mm.cb.a.m(paramContext, 2131100723);
      paramString2.setSpan(new TextAppearanceSpan(null, 0, paramInt, paramContext, paramContext), 0, paramString1.length(), 33);
      paramCharSequence.append(paramString2);
      for (paramContext = paramCharSequence;; paramContext = k.b(paramContext, paramCharSequence, paramInt))
      {
        paramTextView.setText(paramContext);
        AppMethodBeat.o(151242);
        return;
      }
    }
  }
  
  public final void aPZ()
  {
    AppMethodBeat.i(151253);
    ((PluginOpenIM)com.tencent.mm.kernel.g.ad(PluginOpenIM.class)).getAppIdInfoStg().hKK.delete("OpenIMAppIdInfo", null, null);
    ((PluginOpenIM)com.tencent.mm.kernel.g.ad(PluginOpenIM.class)).getAccTypeInfoStg().hKK.delete("OpenIMAccTypeInfo", null, null);
    ((PluginOpenIM)com.tencent.mm.kernel.g.ad(PluginOpenIM.class)).getWordingInfoStg().hKK.delete("OpenIMWordingInfo", null, null);
    AppMethodBeat.o(151253);
  }
  
  public final String b(String paramString1, String paramString2, a.a parama)
  {
    AppMethodBeat.i(151248);
    String str2 = a(paramString1, paramString2, parama, ad.iR(ak.getContext()));
    String str1 = str2;
    if (str2 == null) {
      str1 = a(paramString1, paramString2, parama, "en");
    }
    AppMethodBeat.o(151248);
    return str1;
  }
  
  public final void bB(String paramString1, String paramString2)
  {
    AppMethodBeat.i(151259);
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject = new com.tencent.mm.openim.e.c();
    ((com.tencent.mm.openim.e.c)localObject).field_appid = paramString1;
    ((com.tencent.mm.openim.e.c)localObject).field_language = ad.iR(ak.getContext());
    com.tencent.mm.kernel.g.ajS();
    ((PluginOpenIM)com.tencent.mm.kernel.g.ad(PluginOpenIM.class)).getAppIdInfoStg().get((com.tencent.mm.sdk.e.c)localObject, new String[] { "appid", "language" });
    localStringBuffer.append(String.format("openIMAppIdinfo.field_updateTime %s | ", new Object[] { Long.valueOf(((com.tencent.mm.openim.e.c)localObject).field_updateTime) }));
    if ((((com.tencent.mm.openim.e.c)localObject).systemRowid == -1L) || (bu.rZ(((com.tencent.mm.openim.e.c)localObject).field_updateTime) > 172800L)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (!bu.isNullOrNil(paramString2))
        {
          localObject = new e();
          ((e)localObject).field_appid = paramString1;
          ((e)localObject).field_language = ad.iR(ak.getContext());
          ((e)localObject).field_wordingId = paramString2;
          com.tencent.mm.kernel.g.ajS();
          ((PluginOpenIM)com.tencent.mm.kernel.g.ad(PluginOpenIM.class)).getWordingInfoStg().get((com.tencent.mm.sdk.e.c)localObject, new String[] { "appid", "language", "wordingId" });
          if ((((e)localObject).systemRowid != -1L) && (bu.rZ(((e)localObject).field_updateTime) <= 172800L)) {
            break label341;
          }
          bool1 = true;
        }
      }
      label341:
      for (;;)
      {
        localStringBuffer.append(String.format("wordingInfo.field_updateTime %s | ", new Object[] { Long.valueOf(((e)localObject).field_updateTime) }));
        bool2 = bool1;
        ae.i("MicroMsg.Openim.OpenImResourceMgr", "checkRecUpdate openimAppId %s wordingId %s needUpdate %s logBuffer: %s", new Object[] { paramString1, paramString2, Boolean.valueOf(bool2), localStringBuffer.toString() });
        if (bool2) {
          s(paramString1, ad.iR(ak.getContext()), paramString2);
        }
        AppMethodBeat.o(151259);
        return;
      }
    }
  }
  
  public final String bC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(151252);
    String str2 = t(paramString1, paramString2, ad.iR(ak.getContext()));
    String str1 = str2;
    if (str2 == null) {
      str1 = t(paramString1, paramString2, "en");
    }
    AppMethodBeat.o(151252);
    return str1;
  }
  
  public final String c(String paramString1, String paramString2, a.a parama)
  {
    AppMethodBeat.i(151250);
    String str2 = b(paramString1, paramString2, parama, ad.iR(ak.getContext()));
    String str1 = str2;
    if (str2 == null) {
      str1 = b(paramString1, paramString2, parama, "en");
    }
    AppMethodBeat.o(151250);
    return str1;
  }
  
  public final SpannableString e(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(151241);
    paramContext = k.b(paramContext, paramString, paramInt);
    AppMethodBeat.o(151241);
    return paramContext;
  }
  
  public final TextAppearanceSpan f(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(151254);
    MMTextAppearanceSpan localMMTextAppearanceSpan = null;
    if ("3552365301".equals(paramString))
    {
      paramContext = com.tencent.mm.cb.a.m(paramContext, 2131099662);
      localMMTextAppearanceSpan = new MMTextAppearanceSpan(paramInt, paramContext, paramContext);
    }
    AppMethodBeat.o(151254);
    return localMMTextAppearanceSpan;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(151239);
    if (paramn.getType() != 453)
    {
      AppMethodBeat.o(151239);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(151239);
      return;
    }
    paramString = (i)paramn;
    paramn = (b)this.iKE.get(paramString.iKw + paramString.language);
    if (paramn != null)
    {
      if (!paramn.iKJ.isEmpty())
      {
        while ((paramn.iKK.size() < 10) && (!paramn.iKJ.isEmpty())) {
          paramn.iKK.add(paramn.iKJ.removeFirst());
        }
        com.tencent.mm.kernel.g.ajQ().gDv.a(new i(paramString.iKw, paramString.language, paramn.iKK), 0);
        AppMethodBeat.o(151239);
        return;
      }
      this.iKE.remove(paramString.iKw + paramString.language);
    }
    AppMethodBeat.o(151239);
  }
  
  public final void s(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(151258);
    if (bu.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(151258);
      return;
    }
    ae.i("MicroMsg.Openim.OpenImResourceMgr", "try checkDoSceneGetRec openimAppId %s language %s wordingid %s", new Object[] { paramString1, paramString2, paramString3 });
    if (!this.iKE.containsKey(paramString1 + paramString2))
    {
      b localb = new b((byte)0);
      if (!bu.isNullOrNil(paramString3)) {
        localb.iKK.add(paramString3);
      }
      this.iKE.put(paramString1 + paramString2, localb);
      com.tencent.mm.kernel.g.ajQ().gDv.a(new i(paramString1, paramString2, localb.iKK), 0);
    }
    if (bu.isNullOrNil(paramString3))
    {
      AppMethodBeat.o(151258);
      return;
    }
    paramString1 = (b)this.iKE.get(paramString1 + paramString2);
    if ((paramString1.iKJ.contains(paramString3)) || (paramString1.iKK.contains(paramString3)))
    {
      AppMethodBeat.o(151258);
      return;
    }
    paramString1.iKJ.add(paramString3);
    AppMethodBeat.o(151258);
  }
  
  final class a
  {
    Bitmap bitmap;
    
    private a() {}
  }
  
  final class b
  {
    LinkedList<String> iKJ;
    LinkedList<String> iKK;
    
    private b()
    {
      AppMethodBeat.i(151237);
      this.iKJ = new LinkedList();
      this.iKK = new LinkedList();
      AppMethodBeat.o(151237);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.b.t
 * JD-Core Version:    0.7.0.1
 */