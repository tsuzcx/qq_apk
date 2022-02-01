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
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.o;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.openim.e.d;
import com.tencent.mm.openim.e.e;
import com.tencent.mm.openim.e.f;
import com.tencent.mm.pluginsdk.ui.span.MMTextAppearanceSpan;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.av;
import com.tencent.mm.protocal.protobuf.bwh;
import com.tencent.mm.protocal.protobuf.bwi;
import com.tencent.mm.protocal.protobuf.eg;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.EllipsizeTextView;
import com.tencent.mm.ui.base.EllipsizeTextView.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class t
  implements com.tencent.mm.openim.a.b
{
  private HashMap<String, b> hNS;
  private EllipsizeTextView.a hNT;
  private EllipsizeTextView.a hNU;
  
  public t()
  {
    AppMethodBeat.i(151238);
    this.hNS = new HashMap();
    this.hNT = new EllipsizeTextView.a()
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
          paramAnonymousTextView = com.tencent.mm.cd.a.m(paramAnonymousTextView.getContext(), paramAnonymousInt1);
          localSpannableString.setSpan(new TextAppearanceSpan(null, 0, paramAnonymousInt2, paramAnonymousTextView, paramAnonymousTextView), paramAnonymousCharSequence.length() + 1, paramAnonymousCharSequence.length() + 1 + paramAnonymousString.length(), 33);
          AppMethodBeat.o(151234);
          return localSpannableString;
          paramAnonymousCharSequence = TextUtils.ellipsize(paramAnonymousCharSequence, paramAnonymousTextView.getPaint(), i - f, TextUtils.TruncateAt.END);
        }
      }
    };
    this.hNU = new EllipsizeTextView.a()
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
    com.tencent.mm.vfs.i.aMF("wcf://openim/");
    com.tencent.mm.openim.e.c localc = new com.tencent.mm.openim.e.c();
    localc.field_appid = "3552365301";
    localc.field_language = ac.ir(aj.getContext());
    com.tencent.mm.kernel.g.afC();
    ((PluginOpenIM)com.tencent.mm.kernel.g.ad(PluginOpenIM.class)).getAppIdInfoStg().get(localc, new String[] { "appid", "language" });
    if (localc.systemRowid == -1L)
    {
      Bl("3552365301");
      AppMethodBeat.o(151238);
      return;
    }
    AppMethodBeat.o(151238);
  }
  
  private void Bl(String paramString)
  {
    AppMethodBeat.i(151256);
    bu(paramString, ac.ir(aj.getContext()));
    AppMethodBeat.o(151256);
  }
  
  private static String a(String paramString1, String paramString2, b.a parama, String paramString3)
  {
    AppMethodBeat.i(151249);
    com.tencent.mm.openim.e.a locala = new com.tencent.mm.openim.e.a();
    locala.field_acctTypeId = paramString1;
    locala.field_language = paramString3;
    com.tencent.mm.kernel.g.afC();
    ((PluginOpenIM)com.tencent.mm.kernel.g.ad(PluginOpenIM.class)).getAccTypeInfoStg().get(locala, new String[] { "acctTypeId", "language" });
    if (locala.systemRowid == -1L)
    {
      AppMethodBeat.o(151249);
      return null;
    }
    if (parama == b.a.hNA)
    {
      paramString1 = locala.field_accTypeRec.CuR.iterator();
      while (paramString1.hasNext())
      {
        parama = (bwi)paramString1.next();
        if (paramString2.equals(parama.key))
        {
          paramString1 = parama.doh;
          AppMethodBeat.o(151249);
          return paramString1;
        }
      }
      AppMethodBeat.o(151249);
      return null;
    }
    paramString1 = locala.field_accTypeRec.cTE.iterator();
    while (paramString1.hasNext())
    {
      parama = (bwh)paramString1.next();
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
  
  private String b(String paramString1, String paramString2, b.a parama, String paramString3)
  {
    AppMethodBeat.i(151251);
    com.tencent.mm.openim.e.c localc = new com.tencent.mm.openim.e.c();
    localc.field_appid = paramString1;
    localc.field_language = paramString3;
    com.tencent.mm.kernel.g.afC();
    ((PluginOpenIM)com.tencent.mm.kernel.g.ad(PluginOpenIM.class)).getAppIdInfoStg().get(localc, new String[] { "appid", "language" });
    if (localc.systemRowid == -1L)
    {
      bu(paramString1, paramString3);
      AppMethodBeat.o(151251);
      return null;
    }
    if (parama == b.a.hNA)
    {
      paramString1 = localc.field_appRec.CuR.iterator();
      while (paramString1.hasNext())
      {
        parama = (bwi)paramString1.next();
        if (paramString2.equals(parama.key))
        {
          paramString1 = parama.doh;
          AppMethodBeat.o(151251);
          return paramString1;
        }
      }
      AppMethodBeat.o(151251);
      return null;
    }
    paramString1 = localc.field_appRec.cTE.iterator();
    while (paramString1.hasNext())
    {
      parama = (bwh)paramString1.next();
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
  
  private void bu(String paramString1, String paramString2)
  {
    AppMethodBeat.i(151257);
    t(paramString1, paramString2, "");
    AppMethodBeat.o(151257);
  }
  
  private String u(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(151255);
    e locale = new e();
    locale.field_appid = paramString1;
    locale.field_language = paramString3;
    locale.field_wordingId = paramString2;
    com.tencent.mm.kernel.g.afC();
    ((PluginOpenIM)com.tencent.mm.kernel.g.ad(PluginOpenIM.class)).getWordingInfoStg().get(locale, new String[] { "appid", "language", "wordingId" });
    if (locale.systemRowid == -1L)
    {
      t(paramString1, paramString3, paramString2);
      AppMethodBeat.o(151255);
      return null;
    }
    paramString1 = locale.field_wording;
    AppMethodBeat.o(151255);
    return paramString1;
  }
  
  public final Bitmap Bh(String paramString)
  {
    AppMethodBeat.i(151245);
    final a locala = new a((byte)0);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(151245);
      return null;
    }
    Object localObject = new c.a();
    ((c.a)localObject).hjU = true;
    ((c.a)localObject).gjt = ("wcf://openim/" + com.tencent.mm.b.g.getMessageDigest(paramString.getBytes()));
    localObject = ((c.a)localObject).azc();
    o.ayJ().a(paramString, null, (com.tencent.mm.aw.a.a.c)localObject, new com.tencent.mm.aw.a.c.h()
    {
      public final Bitmap a(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.aw.a.d.b paramAnonymousb)
      {
        return null;
      }
      
      public final void b(String paramAnonymousString, View paramAnonymousView) {}
      
      public final void b(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.aw.a.d.b paramAnonymousb)
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
  
  public final int Bi(String paramString)
  {
    AppMethodBeat.i(151246);
    com.tencent.mm.openim.e.c localc = new com.tencent.mm.openim.e.c();
    localc.field_appid = paramString;
    com.tencent.mm.kernel.g.afC();
    ((PluginOpenIM)com.tencent.mm.kernel.g.ad(PluginOpenIM.class)).getAppIdInfoStg().get(localc, new String[] { "appid" });
    if (localc.systemRowid == -1L)
    {
      Bl(paramString);
      AppMethodBeat.o(151246);
      return 0;
    }
    int i = localc.field_appRec.Cyv;
    AppMethodBeat.o(151246);
    return i;
  }
  
  public final CharSequence a(Context paramContext, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(151240);
    Object localObject = paramCharSequence;
    if (bt.ai(paramCharSequence)) {
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
    paramString1 = Bh(paramString1);
    if (paramString1 != null)
    {
      paramString2 = k.b(paramContext, "  ".concat(String.valueOf(paramString2)), paramFloat);
      int i = (int)(com.tencent.mm.cd.a.fromDPToPix(paramContext, 2) + paramFloat);
      paramContext = new ImageSpan(aj.getContext(), paramString1);
      paramContext.getDrawable().setBounds(0, 0, i, i);
      paramString2.setSpan(paramContext, 0, 1, 33);
      AppMethodBeat.o(151244);
      return paramString2;
    }
    AppMethodBeat.o(151244);
    return paramString2;
  }
  
  public final String a(String paramString1, String paramString2, b.a parama)
  {
    AppMethodBeat.i(151247);
    com.tencent.mm.openim.e.c localc = new com.tencent.mm.openim.e.c();
    localc.field_appid = paramString1;
    com.tencent.mm.kernel.g.afC();
    ((PluginOpenIM)com.tencent.mm.kernel.g.ad(PluginOpenIM.class)).getAppIdInfoStg().get(localc, new String[] { "appid" });
    if (localc.systemRowid == -1L)
    {
      Bl(paramString1);
      AppMethodBeat.o(151247);
      return null;
    }
    String str = a(localc.field_acctTypeId, paramString2, parama, ac.ir(aj.getContext()));
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
      paramContext.setLayoutCallback(this.hNU);
      paramContext.a(paramCharSequence, " ", -1, (int)paramTextView.getTextSize());
      AppMethodBeat.o(151243);
      return;
    }
    paramTextView.setText(((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).a(paramContext, paramCharSequence));
    AppMethodBeat.o(151243);
  }
  
  public final void a(Context paramContext, TextView paramTextView, CharSequence paramCharSequence, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(151242);
    if ((paramTextView instanceof EllipsizeTextView))
    {
      EllipsizeTextView localEllipsizeTextView = (EllipsizeTextView)paramTextView;
      paramTextView = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).bt(paramString1, paramString2);
      if (!bt.isNullOrNil(paramTextView))
      {
        paramContext = paramTextView;
        if (!"3552365301".equals(paramString1)) {}
      }
      for (paramContext = " @".concat(String.valueOf(paramTextView));; paramContext = "")
      {
        localEllipsizeTextView.setLayoutCallback(this.hNT);
        localEllipsizeTextView.a(paramCharSequence, paramContext, 2131100723, paramInt);
        AppMethodBeat.o(151242);
        return;
      }
    }
    paramString2 = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).bt(paramString1, paramString2);
    if (!bt.isNullOrNil(paramString2)) {
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
      paramContext = com.tencent.mm.cd.a.m(paramContext, 2131100723);
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
  
  public final void aFw()
  {
    AppMethodBeat.i(151253);
    ((PluginOpenIM)com.tencent.mm.kernel.g.ad(PluginOpenIM.class)).getAppIdInfoStg().gPa.delete("OpenIMAppIdInfo", null, null);
    ((PluginOpenIM)com.tencent.mm.kernel.g.ad(PluginOpenIM.class)).getAccTypeInfoStg().gPa.delete("OpenIMAccTypeInfo", null, null);
    ((PluginOpenIM)com.tencent.mm.kernel.g.ad(PluginOpenIM.class)).getWordingInfoStg().gPa.delete("OpenIMWordingInfo", null, null);
    AppMethodBeat.o(151253);
  }
  
  public final String b(String paramString1, String paramString2, b.a parama)
  {
    AppMethodBeat.i(151248);
    String str2 = a(paramString1, paramString2, parama, ac.ir(aj.getContext()));
    String str1 = str2;
    if (str2 == null) {
      str1 = a(paramString1, paramString2, parama, "en");
    }
    AppMethodBeat.o(151248);
    return str1;
  }
  
  public final void bs(String paramString1, String paramString2)
  {
    AppMethodBeat.i(151259);
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject = new com.tencent.mm.openim.e.c();
    ((com.tencent.mm.openim.e.c)localObject).field_appid = paramString1;
    ((com.tencent.mm.openim.e.c)localObject).field_language = ac.ir(aj.getContext());
    com.tencent.mm.kernel.g.afC();
    ((PluginOpenIM)com.tencent.mm.kernel.g.ad(PluginOpenIM.class)).getAppIdInfoStg().get((com.tencent.mm.sdk.e.c)localObject, new String[] { "appid", "language" });
    localStringBuffer.append(String.format("openIMAppIdinfo.field_updateTime %s | ", new Object[] { Long.valueOf(((com.tencent.mm.openim.e.c)localObject).field_updateTime) }));
    if ((((com.tencent.mm.openim.e.c)localObject).systemRowid == -1L) || (bt.lZ(((com.tencent.mm.openim.e.c)localObject).field_updateTime) > 172800L)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (!bt.isNullOrNil(paramString2))
        {
          localObject = new e();
          ((e)localObject).field_appid = paramString1;
          ((e)localObject).field_language = ac.ir(aj.getContext());
          ((e)localObject).field_wordingId = paramString2;
          com.tencent.mm.kernel.g.afC();
          ((PluginOpenIM)com.tencent.mm.kernel.g.ad(PluginOpenIM.class)).getWordingInfoStg().get((com.tencent.mm.sdk.e.c)localObject, new String[] { "appid", "language", "wordingId" });
          if ((((e)localObject).systemRowid != -1L) && (bt.lZ(((e)localObject).field_updateTime) <= 172800L)) {
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
        ad.i("MicroMsg.Openim.OpenImResourceMgr", "checkRecUpdate openimAppId %s wordingId %s needUpdate %s logBuffer: %s", new Object[] { paramString1, paramString2, Boolean.valueOf(bool2), localStringBuffer.toString() });
        if (bool2) {
          t(paramString1, ac.ir(aj.getContext()), paramString2);
        }
        AppMethodBeat.o(151259);
        return;
      }
    }
  }
  
  public final String bt(String paramString1, String paramString2)
  {
    AppMethodBeat.i(151252);
    String str2 = u(paramString1, paramString2, ac.ir(aj.getContext()));
    String str1 = str2;
    if (str2 == null) {
      str1 = u(paramString1, paramString2, "en");
    }
    AppMethodBeat.o(151252);
    return str1;
  }
  
  public final String c(String paramString1, String paramString2, b.a parama)
  {
    AppMethodBeat.i(151250);
    String str2 = b(paramString1, paramString2, parama, ac.ir(aj.getContext()));
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
      paramContext = com.tencent.mm.cd.a.m(paramContext, 2131099662);
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
    paramn = (b)this.hNS.get(paramString.hNK + paramString.aSt);
    if (paramn != null)
    {
      if (!paramn.hNX.isEmpty())
      {
        while ((paramn.hNY.size() < 10) && (!paramn.hNX.isEmpty())) {
          paramn.hNY.add(paramn.hNX.removeFirst());
        }
        com.tencent.mm.kernel.g.afA().gcy.a(new i(paramString.hNK, paramString.aSt, paramn.hNY), 0);
        AppMethodBeat.o(151239);
        return;
      }
      this.hNS.remove(paramString.hNK + paramString.aSt);
    }
    AppMethodBeat.o(151239);
  }
  
  public final void t(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(151258);
    ad.i("MicroMsg.Openim.OpenImResourceMgr", "try checkDoSceneGetRec openimAppId %s language %s wordingid %s", new Object[] { paramString1, paramString2, paramString3 });
    if (bt.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(151258);
      return;
    }
    if (!this.hNS.containsKey(paramString1 + paramString2))
    {
      b localb = new b((byte)0);
      if (!bt.isNullOrNil(paramString3)) {
        localb.hNY.add(paramString3);
      }
      this.hNS.put(paramString1 + paramString2, localb);
      com.tencent.mm.kernel.g.afA().gcy.a(new i(paramString1, paramString2, localb.hNY), 0);
    }
    if (bt.isNullOrNil(paramString3))
    {
      AppMethodBeat.o(151258);
      return;
    }
    paramString1 = (b)this.hNS.get(paramString1 + paramString2);
    if ((paramString1.hNX.contains(paramString3)) || (paramString1.hNY.contains(paramString3)))
    {
      AppMethodBeat.o(151258);
      return;
    }
    paramString1.hNX.add(paramString3);
    AppMethodBeat.o(151258);
  }
  
  final class a
  {
    Bitmap bitmap;
    
    private a() {}
  }
  
  final class b
  {
    LinkedList<String> hNX;
    LinkedList<String> hNY;
    
    private b()
    {
      AppMethodBeat.i(151237);
      this.hNX = new LinkedList();
      this.hNY = new LinkedList();
      AppMethodBeat.o(151237);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.b.t
 * JD-Core Version:    0.7.0.1
 */