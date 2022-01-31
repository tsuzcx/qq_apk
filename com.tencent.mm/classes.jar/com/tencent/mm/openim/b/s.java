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
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.as.o;
import com.tencent.mm.cf.h;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.openim.d.d;
import com.tencent.mm.openim.d.f;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.plugin.comm.a.g;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.as;
import com.tencent.mm.protocal.c.bbx;
import com.tencent.mm.protocal.c.bby;
import com.tencent.mm.protocal.c.dj;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.EllipsizeTextView;
import com.tencent.mm.ui.base.EllipsizeTextView.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class s
  implements com.tencent.mm.openim.a.b
{
  private HashMap<String, s.b> eQb = new HashMap();
  private EllipsizeTextView.a eQc = new s.1(this);
  private EllipsizeTextView.a eQd = new s.2(this);
  
  public s()
  {
    com.tencent.mm.a.e.bN(UE());
    com.tencent.mm.openim.d.c localc = new com.tencent.mm.openim.d.c();
    localc.field_appid = "3552365301";
    localc.field_language = x.fB(ae.getContext());
    com.tencent.mm.kernel.g.DQ();
    ((PluginOpenIM)com.tencent.mm.kernel.g.t(PluginOpenIM.class)).getAppIdInfoStg().b(localc, new String[] { "appid", "language" });
    if (localc.ujK == -1L) {
      oV("3552365301");
    }
  }
  
  private static String UE()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.DQ();
    return com.tencent.mm.kernel.g.DP().dKt + "openim/";
  }
  
  private static String a(String paramString1, String paramString2, b.a parama, String paramString3)
  {
    com.tencent.mm.openim.d.a locala = new com.tencent.mm.openim.d.a();
    locala.field_acctTypeId = paramString1;
    locala.field_language = paramString3;
    com.tencent.mm.kernel.g.DQ();
    ((PluginOpenIM)com.tencent.mm.kernel.g.t(PluginOpenIM.class)).getAccTypeInfoStg().b(locala, new String[] { "acctTypeId", "language" });
    if (locala.ujK == -1L) {
      return null;
    }
    if (parama == b.a.ePI)
    {
      paramString1 = locala.field_accTypeRec.stY.iterator();
      while (paramString1.hasNext())
      {
        parama = (bby)paramString1.next();
        if (paramString2.equals(parama.key)) {
          return parama.bQZ;
        }
      }
      return null;
    }
    paramString1 = locala.field_accTypeRec.stZ.iterator();
    while (paramString1.hasNext())
    {
      parama = (bbx)paramString1.next();
      if (paramString2.equals(parama.key)) {
        return parama.url;
      }
    }
    return null;
  }
  
  private void aL(String paramString1, String paramString2)
  {
    r(paramString1, paramString2, "");
  }
  
  private String b(String paramString1, String paramString2, b.a parama, String paramString3)
  {
    com.tencent.mm.openim.d.c localc = new com.tencent.mm.openim.d.c();
    localc.field_appid = paramString1;
    localc.field_language = paramString3;
    com.tencent.mm.kernel.g.DQ();
    ((PluginOpenIM)com.tencent.mm.kernel.g.t(PluginOpenIM.class)).getAppIdInfoStg().b(localc, new String[] { "appid", "language" });
    if (localc.ujK == -1L)
    {
      aL(paramString1, paramString3);
      return null;
    }
    if (parama == b.a.ePI)
    {
      paramString1 = localc.field_appRec.stY.iterator();
      while (paramString1.hasNext())
      {
        parama = (bby)paramString1.next();
        if (paramString2.equals(parama.key)) {
          return parama.bQZ;
        }
      }
      return null;
    }
    paramString1 = localc.field_appRec.stZ.iterator();
    while (paramString1.hasNext())
    {
      parama = (bbx)paramString1.next();
      if (paramString2.equals(parama.key)) {
        return parama.url;
      }
    }
    return null;
  }
  
  private void oV(String paramString)
  {
    aL(paramString, x.fB(ae.getContext()));
  }
  
  private String s(String paramString1, String paramString2, String paramString3)
  {
    com.tencent.mm.openim.d.e locale = new com.tencent.mm.openim.d.e();
    locale.field_appid = paramString1;
    locale.field_language = paramString3;
    locale.field_wordingId = paramString2;
    com.tencent.mm.kernel.g.DQ();
    ((PluginOpenIM)com.tencent.mm.kernel.g.t(PluginOpenIM.class)).getWordingInfoStg().b(locale, new String[] { "appid", "language", "wordingId" });
    if (locale.ujK == -1L)
    {
      r(paramString1, paramString3, paramString2);
      return null;
    }
    return locale.field_wording;
  }
  
  public final void UD()
  {
    ((PluginOpenIM)com.tencent.mm.kernel.g.t(PluginOpenIM.class)).getAppIdInfoStg().dXo.delete("OpenIMAppIdInfo", null, null);
    ((PluginOpenIM)com.tencent.mm.kernel.g.t(PluginOpenIM.class)).getAccTypeInfoStg().dXo.delete("OpenIMAccTypeInfo", null, null);
    ((PluginOpenIM)com.tencent.mm.kernel.g.t(PluginOpenIM.class)).getWordingInfoStg().dXo.delete("OpenIMWordingInfo", null, null);
  }
  
  public final CharSequence a(Context paramContext, CharSequence paramCharSequence)
  {
    Object localObject = paramCharSequence;
    if (bk.L(paramCharSequence)) {
      localObject = "";
    }
    paramCharSequence = new SpannableStringBuilder((CharSequence)localObject);
    paramCharSequence.append(" ");
    paramContext = paramContext.getResources().getDrawable(a.g.open_im_main_logo);
    paramContext.setBounds(0, 0, paramContext.getIntrinsicWidth(), paramContext.getIntrinsicHeight());
    paramCharSequence.setSpan(new ImageSpan(paramContext), ((CharSequence)localObject).length(), ((CharSequence)localObject).length() + 1, 33);
    return paramCharSequence;
  }
  
  public final CharSequence a(Context paramContext, String paramString1, String paramString2, float paramFloat)
  {
    Bitmap localBitmap = oR(paramString1);
    paramString1 = paramString2;
    if (localBitmap != null)
    {
      paramString1 = j.a(paramContext, "  " + paramString2, paramFloat);
      int i = (int)(com.tencent.mm.cb.a.fromDPToPix(paramContext, 2) + paramFloat);
      paramContext = new ImageSpan(ae.getContext(), localBitmap);
      paramContext.getDrawable().setBounds(0, 0, i, i);
      paramString1.setSpan(paramContext, 0, 1, 33);
    }
    return paramString1;
  }
  
  public final String a(String paramString1, String paramString2, b.a parama)
  {
    com.tencent.mm.openim.d.c localc = new com.tencent.mm.openim.d.c();
    localc.field_appid = paramString1;
    com.tencent.mm.kernel.g.DQ();
    ((PluginOpenIM)com.tencent.mm.kernel.g.t(PluginOpenIM.class)).getAppIdInfoStg().b(localc, new String[] { "appid" });
    if (localc.ujK == -1L)
    {
      oV(paramString1);
      paramString1 = null;
    }
    String str;
    do
    {
      return paramString1;
      str = a(localc.field_acctTypeId, paramString2, parama, x.fB(ae.getContext()));
      paramString1 = str;
    } while (str != null);
    return a(localc.field_acctTypeId, paramString2, parama, "en");
  }
  
  public final void a(Context paramContext, TextView paramTextView, CharSequence paramCharSequence)
  {
    if ((paramTextView instanceof EllipsizeTextView))
    {
      paramContext = (EllipsizeTextView)paramTextView;
      paramContext.setLayoutCallback(this.eQd);
      paramContext.a(paramCharSequence, " ", -1, (int)paramTextView.getTextSize());
      return;
    }
    paramTextView.setText(((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.r(com.tencent.mm.openim.a.b.class)).a(paramContext, paramCharSequence));
  }
  
  public final void a(Context paramContext, TextView paramTextView, CharSequence paramCharSequence, String paramString1, String paramString2, int paramInt)
  {
    if ((paramTextView instanceof EllipsizeTextView))
    {
      EllipsizeTextView localEllipsizeTextView = (EllipsizeTextView)paramTextView;
      paramTextView = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.r(com.tencent.mm.openim.a.b.class)).aK(paramString1, paramString2);
      if (!bk.bl(paramTextView))
      {
        paramContext = paramTextView;
        if (!"3552365301".equals(paramString1)) {}
      }
      for (paramContext = " @" + paramTextView;; paramContext = "")
      {
        localEllipsizeTextView.setLayoutCallback(this.eQc);
        localEllipsizeTextView.a(paramCharSequence, paramContext, a.b.open_im_display_name_color, paramInt);
        return;
      }
    }
    paramString2 = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.r(com.tencent.mm.openim.a.b.class)).aK(paramString1, paramString2);
    if (!bk.bl(paramString2)) {
      if (!"3552365301".equals(paramString1)) {
        break label248;
      }
    }
    label248:
    for (paramString1 = " @" + paramString2;; paramString1 = paramString2)
    {
      paramString2 = j.b(paramContext, paramCharSequence, paramInt);
      paramCharSequence = new SpannableStringBuilder();
      paramCharSequence.append(paramString2);
      paramString2 = new SpannableString(paramString1);
      paramContext = com.tencent.mm.cb.a.h(paramContext, a.b.open_im_display_name_color);
      paramString2.setSpan(new TextAppearanceSpan(null, 0, paramInt, paramContext, paramContext), 0, paramString1.length(), 33);
      paramCharSequence.append(paramString2);
      for (paramContext = paramCharSequence;; paramContext = j.b(paramContext, paramCharSequence, paramInt))
      {
        paramTextView.setText(paramContext);
        return;
      }
    }
  }
  
  public final void aJ(String paramString1, String paramString2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject = new com.tencent.mm.openim.d.c();
    ((com.tencent.mm.openim.d.c)localObject).field_appid = paramString1;
    ((com.tencent.mm.openim.d.c)localObject).field_language = x.fB(ae.getContext());
    com.tencent.mm.kernel.g.DQ();
    ((PluginOpenIM)com.tencent.mm.kernel.g.t(PluginOpenIM.class)).getAppIdInfoStg().b((com.tencent.mm.sdk.e.c)localObject, new String[] { "appid", "language" });
    localStringBuffer.append(String.format("openIMAppIdinfo.field_updateTime %s | ", new Object[] { Long.valueOf(((com.tencent.mm.openim.d.c)localObject).field_updateTime) }));
    if ((((com.tencent.mm.openim.d.c)localObject).ujK == -1L) || (bk.cn(((com.tencent.mm.openim.d.c)localObject).field_updateTime) > 172800L)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (!bk.bl(paramString2))
        {
          localObject = new com.tencent.mm.openim.d.e();
          ((com.tencent.mm.openim.d.e)localObject).field_appid = paramString1;
          ((com.tencent.mm.openim.d.e)localObject).field_language = x.fB(ae.getContext());
          ((com.tencent.mm.openim.d.e)localObject).field_wordingId = paramString2;
          com.tencent.mm.kernel.g.DQ();
          ((PluginOpenIM)com.tencent.mm.kernel.g.t(PluginOpenIM.class)).getWordingInfoStg().b((com.tencent.mm.sdk.e.c)localObject, new String[] { "appid", "language", "wordingId" });
          if ((((com.tencent.mm.openim.d.e)localObject).ujK != -1L) && (bk.cn(((com.tencent.mm.openim.d.e)localObject).field_updateTime) <= 172800L)) {
            break label329;
          }
          bool1 = true;
        }
      }
      label329:
      for (;;)
      {
        localStringBuffer.append(String.format("wordingInfo.field_updateTime %s | ", new Object[] { Long.valueOf(((com.tencent.mm.openim.d.e)localObject).field_updateTime) }));
        bool2 = bool1;
        y.i("MicroMsg.Openim.OpenImResourceMgr", "checkRecUpdate openimAppId %s wordingId %s needUpdate %s logBuffer: %s", new Object[] { paramString1, paramString2, Boolean.valueOf(bool2), localStringBuffer.toString() });
        if (bool2) {
          r(paramString1, x.fB(ae.getContext()), paramString2);
        }
        return;
      }
    }
  }
  
  public final String aK(String paramString1, String paramString2)
  {
    String str2 = s(paramString1, paramString2, x.fB(ae.getContext()));
    String str1 = str2;
    if (str2 == null) {
      str1 = s(paramString1, paramString2, "en");
    }
    return str1;
  }
  
  public final String b(String paramString1, String paramString2, b.a parama)
  {
    String str2 = a(paramString1, paramString2, parama, x.fB(ae.getContext()));
    String str1 = str2;
    if (str2 == null) {
      str1 = a(paramString1, paramString2, parama, "en");
    }
    return str1;
  }
  
  public final String c(String paramString1, String paramString2, b.a parama)
  {
    String str2 = b(paramString1, paramString2, parama, x.fB(ae.getContext()));
    String str1 = str2;
    if (str2 == null) {
      str1 = b(paramString1, paramString2, parama, "en");
    }
    return str1;
  }
  
  public final SpannableString d(Context paramContext, String paramString, int paramInt)
  {
    return j.b(paramContext, paramString, paramInt);
  }
  
  public final Bitmap oR(String paramString)
  {
    s.a locala = new s.a(this, (byte)0);
    if (bk.bl(paramString)) {
      return null;
    }
    Object localObject = new c.a();
    ((c.a)localObject).erf = true;
    ((c.a)localObject).erh = (UE() + com.tencent.mm.a.g.o(paramString.getBytes()));
    localObject = ((c.a)localObject).OV();
    o.ON().a(paramString, null, (com.tencent.mm.as.a.a.c)localObject, new s.3(this, locala));
    return locala.bitmap;
  }
  
  public final int oS(String paramString)
  {
    com.tencent.mm.openim.d.c localc = new com.tencent.mm.openim.d.c();
    localc.field_appid = paramString;
    com.tencent.mm.kernel.g.DQ();
    ((PluginOpenIM)com.tencent.mm.kernel.g.t(PluginOpenIM.class)).getAppIdInfoStg().b(localc, new String[] { "appid" });
    if (localc.ujK == -1L)
    {
      oV(paramString);
      return 0;
    }
    return localc.field_appRec.swG;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (paramm.getType() != 453) {}
    while ((paramInt1 != 0) || (paramInt2 != 0)) {
      return;
    }
    paramString = (i)paramm;
    paramm = (s.b)this.eQb.get(paramString.ePT + paramString.auI);
    if (!paramm.eQg.isEmpty())
    {
      while ((paramm.eQh.size() < 10) && (!paramm.eQg.isEmpty())) {
        paramm.eQh.add(paramm.eQg.removeFirst());
      }
      com.tencent.mm.kernel.g.DO().dJT.a(new i(paramString.ePT, paramString.auI, paramm.eQh), 0);
      return;
    }
    this.eQb.remove(paramString.ePT + paramString.auI);
  }
  
  public final void r(String paramString1, String paramString2, String paramString3)
  {
    y.i("MicroMsg.Openim.OpenImResourceMgr", "try checkDoSceneGetRec openimAppId %s language %s wordingid %s", new Object[] { paramString1, paramString2, paramString3 });
    if (bk.bl(paramString1)) {}
    do
    {
      do
      {
        return;
        if (!this.eQb.containsKey(paramString1 + paramString2))
        {
          s.b localb = new s.b(this, (byte)0);
          if (!bk.bl(paramString3)) {
            localb.eQh.add(paramString3);
          }
          this.eQb.put(paramString1 + paramString2, localb);
          com.tencent.mm.kernel.g.DO().dJT.a(new i(paramString1, paramString2, localb.eQh), 0);
        }
      } while (bk.bl(paramString3));
      paramString1 = (s.b)this.eQb.get(paramString1 + paramString2);
    } while ((paramString1.eQg.contains(paramString3)) || (paramString1.eQh.contains(paramString3)));
    paramString1.eQg.add(paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.openim.b.s
 * JD-Core Version:    0.7.0.1
 */