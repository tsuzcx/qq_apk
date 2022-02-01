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
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.openim.a.a.a;
import com.tencent.mm.openim.e.d;
import com.tencent.mm.openim.e.e;
import com.tencent.mm.openim.e.f;
import com.tencent.mm.pluginsdk.ui.span.MMTextAppearanceSpan;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.bb;
import com.tencent.mm.protocal.protobuf.cwr;
import com.tencent.mm.protocal.protobuf.cws;
import com.tencent.mm.protocal.protobuf.ez;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.ui.base.EllipsizeTextView;
import com.tencent.mm.ui.base.EllipsizeTextView.a;
import com.tencent.mm.vfs.s;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class t
  implements com.tencent.mm.openim.a.a
{
  private HashMap<String, b> jHk;
  private EllipsizeTextView.a jHl;
  private EllipsizeTextView.a jHm;
  
  public t()
  {
    AppMethodBeat.i(151238);
    this.jHk = new HashMap();
    this.jHl = new EllipsizeTextView.a()
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
          SpannableString localSpannableString = l.c(paramAnonymousTextView.getContext(), paramAnonymousCharSequence + " " + paramAnonymousString);
          paramAnonymousTextView = com.tencent.mm.cb.a.m(paramAnonymousTextView.getContext(), paramAnonymousInt1);
          localSpannableString.setSpan(new TextAppearanceSpan(null, 0, paramAnonymousInt2, paramAnonymousTextView, paramAnonymousTextView), paramAnonymousCharSequence.length() + 1, paramAnonymousCharSequence.length() + 1 + paramAnonymousString.length(), 33);
          AppMethodBeat.o(151234);
          return localSpannableString;
          paramAnonymousCharSequence = TextUtils.ellipsize(paramAnonymousCharSequence, paramAnonymousTextView.getPaint(), i - f, TextUtils.TruncateAt.END);
        }
      }
    };
    this.jHm = new EllipsizeTextView.a()
    {
      public final CharSequence a(TextView paramAnonymousTextView, CharSequence paramAnonymousCharSequence, String paramAnonymousString, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(151235);
        paramAnonymousString = paramAnonymousTextView.getContext().getResources().getDrawable(2131691298);
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
    s.boN("wcf://openim/");
    com.tencent.mm.openim.e.c localc = new com.tencent.mm.openim.e.c();
    localc.field_appid = "3552365301";
    localc.field_language = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
    com.tencent.mm.kernel.g.aAi();
    ((PluginOpenIM)com.tencent.mm.kernel.g.ah(PluginOpenIM.class)).getAppIdInfoStg().get(localc, new String[] { "appid", "language" });
    if (localc.systemRowid == -1L)
    {
      Sc("3552365301");
      AppMethodBeat.o(151238);
      return;
    }
    AppMethodBeat.o(151238);
  }
  
  private void Sc(String paramString)
  {
    AppMethodBeat.i(151256);
    bO(paramString, LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()));
    AppMethodBeat.o(151256);
  }
  
  private static String a(String paramString1, String paramString2, a.a parama, String paramString3)
  {
    AppMethodBeat.i(151249);
    com.tencent.mm.openim.e.a locala = new com.tencent.mm.openim.e.a();
    locala.field_acctTypeId = paramString1;
    locala.field_language = paramString3;
    com.tencent.mm.kernel.g.aAi();
    ((PluginOpenIM)com.tencent.mm.kernel.g.ah(PluginOpenIM.class)).getAccTypeInfoStg().get(locala, new String[] { "acctTypeId", "language" });
    if (locala.systemRowid == -1L)
    {
      AppMethodBeat.o(151249);
      return null;
    }
    if (parama == a.a.jGS)
    {
      paramString1 = locala.field_accTypeRec.KEp.iterator();
      while (paramString1.hasNext())
      {
        parama = (cws)paramString1.next();
        if (paramString2.equals(parama.key))
        {
          paramString1 = parama.dQx;
          AppMethodBeat.o(151249);
          return paramString1;
        }
      }
      AppMethodBeat.o(151249);
      return null;
    }
    paramString1 = locala.field_accTypeRec.duo.iterator();
    while (paramString1.hasNext())
    {
      parama = (cwr)paramString1.next();
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
    com.tencent.mm.kernel.g.aAi();
    ((PluginOpenIM)com.tencent.mm.kernel.g.ah(PluginOpenIM.class)).getAppIdInfoStg().get(localc, new String[] { "appid", "language" });
    if (localc.systemRowid == -1L)
    {
      bO(paramString1, paramString3);
      AppMethodBeat.o(151251);
      return null;
    }
    if (parama == a.a.jGS)
    {
      paramString1 = localc.field_appRec.KEp.iterator();
      while (paramString1.hasNext())
      {
        parama = (cws)paramString1.next();
        if (paramString2.equals(parama.key))
        {
          paramString1 = parama.dQx;
          AppMethodBeat.o(151251);
          return paramString1;
        }
      }
      AppMethodBeat.o(151251);
      return null;
    }
    paramString1 = localc.field_appRec.duo.iterator();
    while (paramString1.hasNext())
    {
      parama = (cwr)paramString1.next();
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
  
  private void bO(String paramString1, String paramString2)
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
    com.tencent.mm.kernel.g.aAi();
    ((PluginOpenIM)com.tencent.mm.kernel.g.ah(PluginOpenIM.class)).getWordingInfoStg().get(locale, new String[] { "appid", "language", "wordingId" });
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
  
  public final Bitmap RY(String paramString)
  {
    AppMethodBeat.i(151245);
    final a locala = new a((byte)0);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(151245);
      return null;
    }
    Object localObject = new c.a();
    ((c.a)localObject).jbf = true;
    ((c.a)localObject).fullPath = ("wcf://openim/" + com.tencent.mm.b.g.getMessageDigest(paramString.getBytes()));
    localObject = ((c.a)localObject).bdv();
    com.tencent.mm.av.q.bcV().a(paramString, null, (com.tencent.mm.av.a.a.c)localObject, new com.tencent.mm.av.a.c.h()
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
  
  public final int RZ(String paramString)
  {
    AppMethodBeat.i(151246);
    com.tencent.mm.openim.e.c localc = new com.tencent.mm.openim.e.c();
    localc.field_appid = paramString;
    com.tencent.mm.kernel.g.aAi();
    ((PluginOpenIM)com.tencent.mm.kernel.g.ah(PluginOpenIM.class)).getAppIdInfoStg().get(localc, new String[] { "appid" });
    if (localc.systemRowid == -1L)
    {
      Sc(paramString);
      AppMethodBeat.o(151246);
      return 0;
    }
    int i = localc.field_appRec.KIp;
    AppMethodBeat.o(151246);
    return i;
  }
  
  public final CharSequence a(Context paramContext, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(151240);
    Object localObject = paramCharSequence;
    if (Util.isNullOrNil(paramCharSequence)) {
      localObject = "";
    }
    paramCharSequence = new SpannableStringBuilder((CharSequence)localObject);
    paramCharSequence.append(" ");
    paramContext = paramContext.getResources().getDrawable(2131691298);
    paramContext.setBounds(0, 0, paramContext.getIntrinsicWidth(), paramContext.getIntrinsicHeight());
    paramCharSequence.setSpan(new ImageSpan(paramContext), ((CharSequence)localObject).length(), ((CharSequence)localObject).length() + 1, 33);
    AppMethodBeat.o(151240);
    return paramCharSequence;
  }
  
  public final CharSequence a(Context paramContext, String paramString1, String paramString2, float paramFloat)
  {
    AppMethodBeat.i(151244);
    paramString1 = RY(paramString1);
    if (paramString1 != null)
    {
      paramString2 = l.b(paramContext, "  ".concat(String.valueOf(paramString2)), paramFloat);
      int i = (int)(com.tencent.mm.cb.a.fromDPToPix(paramContext, 2) + paramFloat);
      paramContext = new ImageSpan(MMApplicationContext.getContext(), paramString1);
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
    com.tencent.mm.kernel.g.aAi();
    ((PluginOpenIM)com.tencent.mm.kernel.g.ah(PluginOpenIM.class)).getAppIdInfoStg().get(localc, new String[] { "appid" });
    if (localc.systemRowid == -1L)
    {
      Sc(paramString1);
      AppMethodBeat.o(151247);
      return null;
    }
    String str = a(localc.field_acctTypeId, paramString2, parama, LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()));
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
      paramContext.setLayoutCallback(this.jHm);
      paramContext.a(paramCharSequence, " ", -1, (int)paramTextView.getTextSize());
      AppMethodBeat.o(151243);
      return;
    }
    paramTextView.setText(((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.openim.a.a.class)).a(paramContext, paramCharSequence));
    AppMethodBeat.o(151243);
  }
  
  public final void a(Context paramContext, TextView paramTextView, CharSequence paramCharSequence, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(151242);
    if ((paramTextView instanceof EllipsizeTextView))
    {
      EllipsizeTextView localEllipsizeTextView = (EllipsizeTextView)paramTextView;
      paramTextView = ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.openim.a.a.class)).bN(paramString1, paramString2);
      if (!Util.isNullOrNil(paramTextView))
      {
        paramContext = paramTextView;
        if (!"3552365301".equals(paramString1)) {}
      }
      for (paramContext = " @".concat(String.valueOf(paramTextView));; paramContext = "")
      {
        localEllipsizeTextView.setLayoutCallback(this.jHl);
        localEllipsizeTextView.a(paramCharSequence, paramContext, 2131100917, paramInt);
        AppMethodBeat.o(151242);
        return;
      }
    }
    paramString2 = ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.openim.a.a.class)).bN(paramString1, paramString2);
    if (!Util.isNullOrNil(paramString2)) {
      if (!"3552365301".equals(paramString1)) {
        break label252;
      }
    }
    label252:
    for (paramString1 = " @".concat(String.valueOf(paramString2));; paramString1 = paramString2)
    {
      paramString2 = l.e(paramContext, paramCharSequence, paramInt);
      paramCharSequence = new SpannableStringBuilder();
      paramCharSequence.append(paramString2);
      paramString2 = new SpannableString(paramString1);
      paramContext = com.tencent.mm.cb.a.m(paramContext, 2131100917);
      paramString2.setSpan(new TextAppearanceSpan(null, 0, paramInt, paramContext, paramContext), 0, paramString1.length(), 33);
      paramCharSequence.append(paramString2);
      for (paramContext = paramCharSequence;; paramContext = l.e(paramContext, paramCharSequence, paramInt))
      {
        paramTextView.setText(paramContext);
        AppMethodBeat.o(151242);
        return;
      }
    }
  }
  
  public final String b(String paramString1, String paramString2, a.a parama)
  {
    AppMethodBeat.i(151248);
    String str2 = a(paramString1, paramString2, parama, LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()));
    String str1 = str2;
    if (str2 == null) {
      str1 = a(paramString1, paramString2, parama, "en");
    }
    AppMethodBeat.o(151248);
    return str1;
  }
  
  public final void bM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(151259);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(151259);
      return;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject = new com.tencent.mm.openim.e.c();
    ((com.tencent.mm.openim.e.c)localObject).field_appid = paramString1;
    ((com.tencent.mm.openim.e.c)localObject).field_language = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
    com.tencent.mm.kernel.g.aAi();
    ((PluginOpenIM)com.tencent.mm.kernel.g.ah(PluginOpenIM.class)).getAppIdInfoStg().get((IAutoDBItem)localObject, new String[] { "appid", "language" });
    localStringBuffer.append(String.format("openIMAppIdinfo.field_updateTime %s | ", new Object[] { Long.valueOf(((com.tencent.mm.openim.e.c)localObject).field_updateTime) }));
    if ((((com.tencent.mm.openim.e.c)localObject).systemRowid == -1L) || (Util.secondsToNow(((com.tencent.mm.openim.e.c)localObject).field_updateTime) > 172800L)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (!Util.isNullOrNil(paramString2))
        {
          localObject = new e();
          ((e)localObject).field_appid = paramString1;
          ((e)localObject).field_language = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
          ((e)localObject).field_wordingId = paramString2;
          com.tencent.mm.kernel.g.aAi();
          ((PluginOpenIM)com.tencent.mm.kernel.g.ah(PluginOpenIM.class)).getWordingInfoStg().get((IAutoDBItem)localObject, new String[] { "appid", "language", "wordingId" });
          if ((((e)localObject).systemRowid != -1L) && (Util.secondsToNow(((e)localObject).field_updateTime) <= 172800L)) {
            break label355;
          }
          bool1 = true;
        }
      }
      label355:
      for (;;)
      {
        localStringBuffer.append(String.format("wordingInfo.field_updateTime %s | ", new Object[] { Long.valueOf(((e)localObject).field_updateTime) }));
        bool2 = bool1;
        Log.i("MicroMsg.Openim.OpenImResourceMgr", "checkRecUpdate openimAppId %s wordingId %s needUpdate %s logBuffer: %s", new Object[] { paramString1, paramString2, Boolean.valueOf(bool2), localStringBuffer.toString() });
        if (bool2) {
          s(paramString1, LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()), paramString2);
        }
        AppMethodBeat.o(151259);
        return;
      }
    }
  }
  
  public final String bN(String paramString1, String paramString2)
  {
    AppMethodBeat.i(151252);
    String str2 = t(paramString1, paramString2, LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()));
    String str1 = str2;
    if (str2 == null) {
      str1 = t(paramString1, paramString2, "en");
    }
    AppMethodBeat.o(151252);
    return str1;
  }
  
  public final void bkB()
  {
    AppMethodBeat.i(151253);
    ((PluginOpenIM)com.tencent.mm.kernel.g.ah(PluginOpenIM.class)).getAppIdInfoStg().iFy.delete("OpenIMAppIdInfo", null, null);
    ((PluginOpenIM)com.tencent.mm.kernel.g.ah(PluginOpenIM.class)).getAccTypeInfoStg().iFy.delete("OpenIMAccTypeInfo", null, null);
    ((PluginOpenIM)com.tencent.mm.kernel.g.ah(PluginOpenIM.class)).getWordingInfoStg().iFy.delete("OpenIMWordingInfo", null, null);
    AppMethodBeat.o(151253);
  }
  
  public final String c(String paramString1, String paramString2, a.a parama)
  {
    AppMethodBeat.i(151250);
    String str2 = b(paramString1, paramString2, parama, LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()));
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
    paramContext = l.e(paramContext, paramString, paramInt);
    AppMethodBeat.o(151241);
    return paramContext;
  }
  
  public final TextAppearanceSpan f(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(151254);
    MMTextAppearanceSpan localMMTextAppearanceSpan = null;
    if ("3552365301".equals(paramString))
    {
      paramContext = com.tencent.mm.cb.a.m(paramContext, 2131099665);
      localMMTextAppearanceSpan = new MMTextAppearanceSpan(paramInt, paramContext, paramContext);
    }
    AppMethodBeat.o(151254);
    return localMMTextAppearanceSpan;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(151239);
    if (paramq.getType() != 453)
    {
      AppMethodBeat.o(151239);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(151239);
      return;
    }
    paramString = (i)paramq;
    paramq = (b)this.jHk.get(paramString.jHc + paramString.language);
    if (paramq != null)
    {
      if (!paramq.jHp.isEmpty())
      {
        while ((paramq.jHq.size() < 10) && (!paramq.jHp.isEmpty())) {
          paramq.jHq.add(paramq.jHp.removeFirst());
        }
        com.tencent.mm.kernel.g.aAg().hqi.a(new i(paramString.jHc, paramString.language, paramq.jHq), 0);
        AppMethodBeat.o(151239);
        return;
      }
      this.jHk.remove(paramString.jHc + paramString.language);
    }
    AppMethodBeat.o(151239);
  }
  
  public final void s(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(151258);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(151258);
      return;
    }
    Log.i("MicroMsg.Openim.OpenImResourceMgr", "try checkDoSceneGetRec openimAppId %s language %s wordingid %s", new Object[] { paramString1, paramString2, paramString3 });
    if (!this.jHk.containsKey(paramString1 + paramString2))
    {
      b localb = new b((byte)0);
      if (!Util.isNullOrNil(paramString3)) {
        localb.jHq.add(paramString3);
      }
      this.jHk.put(paramString1 + paramString2, localb);
      com.tencent.mm.kernel.g.aAg().hqi.a(new i(paramString1, paramString2, localb.jHq), 0);
    }
    if (Util.isNullOrNil(paramString3))
    {
      AppMethodBeat.o(151258);
      return;
    }
    paramString1 = (b)this.jHk.get(paramString1 + paramString2);
    if ((paramString1.jHp.contains(paramString3)) || (paramString1.jHq.contains(paramString3)))
    {
      AppMethodBeat.o(151258);
      return;
    }
    paramString1.jHp.add(paramString3);
    AppMethodBeat.o(151258);
  }
  
  final class a
  {
    Bitmap bitmap;
    
    private a() {}
  }
  
  final class b
  {
    LinkedList<String> jHp;
    LinkedList<String> jHq;
    
    private b()
    {
      AppMethodBeat.i(151237);
      this.jHp = new LinkedList();
      this.jHq = new LinkedList();
      AppMethodBeat.o(151237);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.b.t
 * JD-Core Version:    0.7.0.1
 */