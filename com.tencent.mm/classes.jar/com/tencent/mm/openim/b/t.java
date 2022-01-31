package com.tencent.mm.openim.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.text.style.TextAppearanceSpan;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.cg.h;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.openim.e.d;
import com.tencent.mm.openim.e.f;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.protobuf.as;
import com.tencent.mm.protocal.protobuf.biy;
import com.tencent.mm.protocal.protobuf.biz;
import com.tencent.mm.protocal.protobuf.dt;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.EllipsizeTextView;
import com.tencent.mm.ui.base.EllipsizeTextView.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class t
  implements com.tencent.mm.openim.a.b
{
  private HashMap<String, t.b> gfW;
  private EllipsizeTextView.a gfX;
  private EllipsizeTextView.a gfY;
  
  public t()
  {
    AppMethodBeat.i(78894);
    this.gfW = new HashMap();
    this.gfX = new t.1(this);
    this.gfY = new t.2(this);
    com.tencent.mm.a.e.cQ(anP());
    com.tencent.mm.openim.e.c localc = new com.tencent.mm.openim.e.c();
    localc.field_appid = "3552365301";
    localc.field_language = aa.gP(ah.getContext());
    com.tencent.mm.kernel.g.RM();
    ((PluginOpenIM)com.tencent.mm.kernel.g.G(PluginOpenIM.class)).getAppIdInfoStg().get(localc, new String[] { "appid", "language" });
    if (localc.systemRowid == -1L)
    {
      wn("3552365301");
      AppMethodBeat.o(78894);
      return;
    }
    AppMethodBeat.o(78894);
  }
  
  private static String a(String paramString1, String paramString2, b.a parama, String paramString3)
  {
    AppMethodBeat.i(78906);
    com.tencent.mm.openim.e.a locala = new com.tencent.mm.openim.e.a();
    locala.field_acctTypeId = paramString1;
    locala.field_language = paramString3;
    com.tencent.mm.kernel.g.RM();
    ((PluginOpenIM)com.tencent.mm.kernel.g.G(PluginOpenIM.class)).getAccTypeInfoStg().get(locala, new String[] { "acctTypeId", "language" });
    if (locala.systemRowid == -1L)
    {
      AppMethodBeat.o(78906);
      return null;
    }
    if (parama == b.a.gfD)
    {
      paramString1 = locala.field_accTypeRec.wmC.iterator();
      while (paramString1.hasNext())
      {
        parama = (biz)paramString1.next();
        if (paramString2.equals(parama.key))
        {
          paramString1 = parama.cyA;
          AppMethodBeat.o(78906);
          return paramString1;
        }
      }
      AppMethodBeat.o(78906);
      return null;
    }
    paramString1 = locala.field_accTypeRec.ceF.iterator();
    while (paramString1.hasNext())
    {
      parama = (biy)paramString1.next();
      if (paramString2.equals(parama.key))
      {
        paramString1 = parama.url;
        AppMethodBeat.o(78906);
        return paramString1;
      }
    }
    AppMethodBeat.o(78906);
    return null;
  }
  
  public static String anP()
  {
    AppMethodBeat.i(78895);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.RM();
    localObject = com.tencent.mm.kernel.g.RL().eHR + "openim/";
    AppMethodBeat.o(78895);
    return localObject;
  }
  
  private String b(String paramString1, String paramString2, b.a parama, String paramString3)
  {
    AppMethodBeat.i(78908);
    com.tencent.mm.openim.e.c localc = new com.tencent.mm.openim.e.c();
    localc.field_appid = paramString1;
    localc.field_language = paramString3;
    com.tencent.mm.kernel.g.RM();
    ((PluginOpenIM)com.tencent.mm.kernel.g.G(PluginOpenIM.class)).getAppIdInfoStg().get(localc, new String[] { "appid", "language" });
    if (localc.systemRowid == -1L)
    {
      be(paramString1, paramString3);
      AppMethodBeat.o(78908);
      return null;
    }
    if (parama == b.a.gfD)
    {
      paramString1 = localc.field_appRec.wmC.iterator();
      while (paramString1.hasNext())
      {
        parama = (biz)paramString1.next();
        if (paramString2.equals(parama.key))
        {
          paramString1 = parama.cyA;
          AppMethodBeat.o(78908);
          return paramString1;
        }
      }
      AppMethodBeat.o(78908);
      return null;
    }
    paramString1 = localc.field_appRec.ceF.iterator();
    while (paramString1.hasNext())
    {
      parama = (biy)paramString1.next();
      if (paramString2.equals(parama.key))
      {
        paramString1 = parama.url;
        AppMethodBeat.o(78908);
        return paramString1;
      }
    }
    AppMethodBeat.o(78908);
    return null;
  }
  
  private void be(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78913);
    u(paramString1, paramString2, "");
    AppMethodBeat.o(78913);
  }
  
  private String v(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(78911);
    com.tencent.mm.openim.e.e locale = new com.tencent.mm.openim.e.e();
    locale.field_appid = paramString1;
    locale.field_language = paramString3;
    locale.field_wordingId = paramString2;
    com.tencent.mm.kernel.g.RM();
    ((PluginOpenIM)com.tencent.mm.kernel.g.G(PluginOpenIM.class)).getWordingInfoStg().get(locale, new String[] { "appid", "language", "wordingId" });
    if (locale.systemRowid == -1L)
    {
      u(paramString1, paramString3, paramString2);
      AppMethodBeat.o(78911);
      return null;
    }
    paramString1 = locale.field_wording;
    AppMethodBeat.o(78911);
    return paramString1;
  }
  
  private void wn(String paramString)
  {
    AppMethodBeat.i(78912);
    be(paramString, aa.gP(ah.getContext()));
    AppMethodBeat.o(78912);
  }
  
  public final CharSequence a(Context paramContext, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(78897);
    Object localObject = paramCharSequence;
    if (bo.aa(paramCharSequence)) {
      localObject = "";
    }
    paramCharSequence = new SpannableStringBuilder((CharSequence)localObject);
    paramCharSequence.append(" ");
    paramContext = paramContext.getResources().getDrawable(2131231831);
    paramContext.setBounds(0, 0, paramContext.getIntrinsicWidth(), paramContext.getIntrinsicHeight());
    paramCharSequence.setSpan(new ImageSpan(paramContext), ((CharSequence)localObject).length(), ((CharSequence)localObject).length() + 1, 33);
    AppMethodBeat.o(78897);
    return paramCharSequence;
  }
  
  public final CharSequence a(Context paramContext, String paramString1, String paramString2, float paramFloat)
  {
    AppMethodBeat.i(78901);
    paramString1 = wj(paramString1);
    if (paramString1 != null)
    {
      paramString2 = j.b(paramContext, "  ".concat(String.valueOf(paramString2)), paramFloat);
      int i = (int)(com.tencent.mm.cb.a.fromDPToPix(paramContext, 2) + paramFloat);
      paramContext = new ImageSpan(ah.getContext(), paramString1);
      paramContext.getDrawable().setBounds(0, 0, i, i);
      paramString2.setSpan(paramContext, 0, 1, 33);
      AppMethodBeat.o(78901);
      return paramString2;
    }
    AppMethodBeat.o(78901);
    return paramString2;
  }
  
  public final String a(String paramString1, String paramString2, b.a parama)
  {
    AppMethodBeat.i(78904);
    com.tencent.mm.openim.e.c localc = new com.tencent.mm.openim.e.c();
    localc.field_appid = paramString1;
    com.tencent.mm.kernel.g.RM();
    ((PluginOpenIM)com.tencent.mm.kernel.g.G(PluginOpenIM.class)).getAppIdInfoStg().get(localc, new String[] { "appid" });
    if (localc.systemRowid == -1L)
    {
      wn(paramString1);
      AppMethodBeat.o(78904);
      return null;
    }
    String str = a(localc.field_acctTypeId, paramString2, parama, aa.gP(ah.getContext()));
    paramString1 = str;
    if (str == null) {
      paramString1 = a(localc.field_acctTypeId, paramString2, parama, "en");
    }
    AppMethodBeat.o(78904);
    return paramString1;
  }
  
  public final void a(Context paramContext, TextView paramTextView, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(78900);
    if ((paramTextView instanceof EllipsizeTextView))
    {
      paramContext = (EllipsizeTextView)paramTextView;
      paramContext.setLayoutCallback(this.gfY);
      paramContext.a(paramCharSequence, " ", -1, (int)paramTextView.getTextSize());
      AppMethodBeat.o(78900);
      return;
    }
    paramTextView.setText(((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.openim.a.b.class)).a(paramContext, paramCharSequence));
    AppMethodBeat.o(78900);
  }
  
  public final void a(Context paramContext, TextView paramTextView, CharSequence paramCharSequence, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(78899);
    if ((paramTextView instanceof EllipsizeTextView))
    {
      EllipsizeTextView localEllipsizeTextView = (EllipsizeTextView)paramTextView;
      paramTextView = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.openim.a.b.class)).bd(paramString1, paramString2);
      if (!bo.isNullOrNil(paramTextView))
      {
        paramContext = paramTextView;
        if (!"3552365301".equals(paramString1)) {}
      }
      for (paramContext = " @".concat(String.valueOf(paramTextView));; paramContext = "")
      {
        localEllipsizeTextView.setLayoutCallback(this.gfX);
        localEllipsizeTextView.a(paramCharSequence, paramContext, 2131690334, paramInt);
        AppMethodBeat.o(78899);
        return;
      }
    }
    paramString2 = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.openim.a.b.class)).bd(paramString1, paramString2);
    if (!bo.isNullOrNil(paramString2)) {
      if (!"3552365301".equals(paramString1)) {
        break label252;
      }
    }
    label252:
    for (paramString1 = " @".concat(String.valueOf(paramString2));; paramString1 = paramString2)
    {
      paramString2 = j.b(paramContext, paramCharSequence, paramInt);
      paramCharSequence = new SpannableStringBuilder();
      paramCharSequence.append(paramString2);
      paramString2 = new SpannableString(paramString1);
      paramContext = com.tencent.mm.cb.a.l(paramContext, 2131690334);
      paramString2.setSpan(new TextAppearanceSpan(null, 0, paramInt, paramContext, paramContext), 0, paramString1.length(), 33);
      paramCharSequence.append(paramString2);
      for (paramContext = paramCharSequence;; paramContext = j.b(paramContext, paramCharSequence, paramInt))
      {
        paramTextView.setText(paramContext);
        AppMethodBeat.o(78899);
        return;
      }
    }
  }
  
  public final void anO()
  {
    AppMethodBeat.i(78910);
    ((PluginOpenIM)com.tencent.mm.kernel.g.G(PluginOpenIM.class)).getAppIdInfoStg().fnw.delete("OpenIMAppIdInfo", null, null);
    ((PluginOpenIM)com.tencent.mm.kernel.g.G(PluginOpenIM.class)).getAccTypeInfoStg().fnw.delete("OpenIMAccTypeInfo", null, null);
    ((PluginOpenIM)com.tencent.mm.kernel.g.G(PluginOpenIM.class)).getWordingInfoStg().fnw.delete("OpenIMWordingInfo", null, null);
    AppMethodBeat.o(78910);
  }
  
  public final String b(String paramString1, String paramString2, b.a parama)
  {
    AppMethodBeat.i(78905);
    String str2 = a(paramString1, paramString2, parama, aa.gP(ah.getContext()));
    String str1 = str2;
    if (str2 == null) {
      str1 = a(paramString1, paramString2, parama, "en");
    }
    AppMethodBeat.o(78905);
    return str1;
  }
  
  public final void bc(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78915);
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject = new com.tencent.mm.openim.e.c();
    ((com.tencent.mm.openim.e.c)localObject).field_appid = paramString1;
    ((com.tencent.mm.openim.e.c)localObject).field_language = aa.gP(ah.getContext());
    com.tencent.mm.kernel.g.RM();
    ((PluginOpenIM)com.tencent.mm.kernel.g.G(PluginOpenIM.class)).getAppIdInfoStg().get((com.tencent.mm.sdk.e.c)localObject, new String[] { "appid", "language" });
    localStringBuffer.append(String.format("openIMAppIdinfo.field_updateTime %s | ", new Object[] { Long.valueOf(((com.tencent.mm.openim.e.c)localObject).field_updateTime) }));
    if ((((com.tencent.mm.openim.e.c)localObject).systemRowid == -1L) || (bo.gz(((com.tencent.mm.openim.e.c)localObject).field_updateTime) > 172800L)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (!bo.isNullOrNil(paramString2))
        {
          localObject = new com.tencent.mm.openim.e.e();
          ((com.tencent.mm.openim.e.e)localObject).field_appid = paramString1;
          ((com.tencent.mm.openim.e.e)localObject).field_language = aa.gP(ah.getContext());
          ((com.tencent.mm.openim.e.e)localObject).field_wordingId = paramString2;
          com.tencent.mm.kernel.g.RM();
          ((PluginOpenIM)com.tencent.mm.kernel.g.G(PluginOpenIM.class)).getWordingInfoStg().get((com.tencent.mm.sdk.e.c)localObject, new String[] { "appid", "language", "wordingId" });
          if ((((com.tencent.mm.openim.e.e)localObject).systemRowid != -1L) && (bo.gz(((com.tencent.mm.openim.e.e)localObject).field_updateTime) <= 172800L)) {
            break label341;
          }
          bool1 = true;
        }
      }
      label341:
      for (;;)
      {
        localStringBuffer.append(String.format("wordingInfo.field_updateTime %s | ", new Object[] { Long.valueOf(((com.tencent.mm.openim.e.e)localObject).field_updateTime) }));
        bool2 = bool1;
        ab.i("MicroMsg.Openim.OpenImResourceMgr", "checkRecUpdate openimAppId %s wordingId %s needUpdate %s logBuffer: %s", new Object[] { paramString1, paramString2, Boolean.valueOf(bool2), localStringBuffer.toString() });
        if (bool2) {
          u(paramString1, aa.gP(ah.getContext()), paramString2);
        }
        AppMethodBeat.o(78915);
        return;
      }
    }
  }
  
  public final String bd(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78909);
    String str2 = v(paramString1, paramString2, aa.gP(ah.getContext()));
    String str1 = str2;
    if (str2 == null) {
      str1 = v(paramString1, paramString2, "en");
    }
    AppMethodBeat.o(78909);
    return str1;
  }
  
  public final String c(String paramString1, String paramString2, b.a parama)
  {
    AppMethodBeat.i(78907);
    String str2 = b(paramString1, paramString2, parama, aa.gP(ah.getContext()));
    String str1 = str2;
    if (str2 == null) {
      str1 = b(paramString1, paramString2, parama, "en");
    }
    AppMethodBeat.o(78907);
    return str1;
  }
  
  public final SpannableString e(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(78898);
    paramContext = j.b(paramContext, paramString, paramInt);
    AppMethodBeat.o(78898);
    return paramContext;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(78896);
    if (paramm.getType() != 453)
    {
      AppMethodBeat.o(78896);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(78896);
      return;
    }
    paramString = (i)paramm;
    paramm = (t.b)this.gfW.get(paramString.gfO + paramString.axa);
    if (!paramm.ggb.isEmpty())
    {
      while ((paramm.ggc.size() < 10) && (!paramm.ggb.isEmpty())) {
        paramm.ggc.add(paramm.ggb.removeFirst());
      }
      com.tencent.mm.kernel.g.RK().eHt.a(new i(paramString.gfO, paramString.axa, paramm.ggc), 0);
      AppMethodBeat.o(78896);
      return;
    }
    this.gfW.remove(paramString.gfO + paramString.axa);
    AppMethodBeat.o(78896);
  }
  
  public final void u(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(78914);
    ab.i("MicroMsg.Openim.OpenImResourceMgr", "try checkDoSceneGetRec openimAppId %s language %s wordingid %s", new Object[] { paramString1, paramString2, paramString3 });
    if (bo.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(78914);
      return;
    }
    if (!this.gfW.containsKey(paramString1 + paramString2))
    {
      t.b localb = new t.b(this, (byte)0);
      if (!bo.isNullOrNil(paramString3)) {
        localb.ggc.add(paramString3);
      }
      this.gfW.put(paramString1 + paramString2, localb);
      com.tencent.mm.kernel.g.RK().eHt.a(new i(paramString1, paramString2, localb.ggc), 0);
    }
    if (bo.isNullOrNil(paramString3))
    {
      AppMethodBeat.o(78914);
      return;
    }
    paramString1 = (t.b)this.gfW.get(paramString1 + paramString2);
    if ((paramString1.ggb.contains(paramString3)) || (paramString1.ggc.contains(paramString3)))
    {
      AppMethodBeat.o(78914);
      return;
    }
    paramString1.ggb.add(paramString3);
    AppMethodBeat.o(78914);
  }
  
  public final Bitmap wj(String paramString)
  {
    AppMethodBeat.i(78902);
    t.a locala = new t.a(this, (byte)0);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(78902);
      return null;
    }
    Object localObject = new c.a();
    ((c.a)localObject).eNM = true;
    ((c.a)localObject).eNO = (anP() + com.tencent.mm.a.g.w(paramString.getBytes()));
    localObject = ((c.a)localObject).ahY();
    o.ahG().a(paramString, null, (com.tencent.mm.at.a.a.c)localObject, new t.3(this, locala));
    paramString = locala.bitmap;
    AppMethodBeat.o(78902);
    return paramString;
  }
  
  public final int wk(String paramString)
  {
    AppMethodBeat.i(78903);
    com.tencent.mm.openim.e.c localc = new com.tencent.mm.openim.e.c();
    localc.field_appid = paramString;
    com.tencent.mm.kernel.g.RM();
    ((PluginOpenIM)com.tencent.mm.kernel.g.G(PluginOpenIM.class)).getAppIdInfoStg().get(localc, new String[] { "appid" });
    if (localc.systemRowid == -1L)
    {
      wn(paramString);
      AppMethodBeat.o(78903);
      return 0;
    }
    int i = localc.field_appRec.wpI;
    AppMethodBeat.o(78903);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.b.t
 * JD-Core Version:    0.7.0.1
 */