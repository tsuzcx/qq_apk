package com.tencent.mm.openim.model;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.text.style.TextAppearanceSpan;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.b.g;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.openim.api.e;
import com.tencent.mm.openim.api.e.a;
import com.tencent.mm.openim.e.d;
import com.tencent.mm.openim.e.k;
import com.tencent.mm.plugin.comm.c.b;
import com.tencent.mm.plugin.comm.c.g;
import com.tencent.mm.pluginsdk.ui.span.MMTextAppearanceSpan;
import com.tencent.mm.protocal.protobuf.bb;
import com.tencent.mm.protocal.protobuf.dyi;
import com.tencent.mm.protocal.protobuf.dyj;
import com.tencent.mm.protocal.protobuf.fq;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.ui.base.EllipsizeTextView;
import com.tencent.mm.ui.base.EllipsizeTextView.a;
import com.tencent.mm.vfs.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class ab
  implements e
{
  private HashMap<String, b> ptf;
  private EllipsizeTextView.a ptg;
  private EllipsizeTextView.a pth;
  
  public ab()
  {
    AppMethodBeat.i(151238);
    this.ptf = new HashMap();
    this.ptg = new ab.1(this);
    this.pth = new ab.2(this);
    y.bDX("wcf://openim/");
    com.tencent.mm.openim.e.c localc = new com.tencent.mm.openim.e.c();
    localc.field_appid = "3552365301";
    localc.field_language = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
    localc.field_subType = 0;
    com.tencent.mm.kernel.h.baF();
    ((PluginOpenIM)com.tencent.mm.kernel.h.az(PluginOpenIM.class)).getAppIdInfoStg().get(localc, new String[] { "appid", "language", "subType" });
    if (localc.systemRowid == -1L)
    {
      RT("3552365301");
      AppMethodBeat.o(151238);
      return;
    }
    AppMethodBeat.o(151238);
  }
  
  private void RT(String paramString)
  {
    AppMethodBeat.i(151256);
    y(paramString, LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()), "");
    AppMethodBeat.o(151256);
  }
  
  private static String a(String paramString1, String paramString2, e.a parama, String paramString3)
  {
    AppMethodBeat.i(151249);
    com.tencent.mm.openim.e.a locala = new com.tencent.mm.openim.e.a();
    locala.field_acctTypeId = paramString1;
    locala.field_language = paramString3;
    com.tencent.mm.kernel.h.baF();
    ((PluginOpenIM)com.tencent.mm.kernel.h.az(PluginOpenIM.class)).getAccTypeInfoStg().get(locala, new String[] { "acctTypeId", "language" });
    if (locala.systemRowid == -1L)
    {
      AppMethodBeat.o(151249);
      return null;
    }
    if (parama == e.a.prb)
    {
      paramString1 = locala.field_accTypeRec.YCk.iterator();
      while (paramString1.hasNext())
      {
        parama = (dyj)paramString1.next();
        if (paramString2.equals(parama.key))
        {
          paramString1 = parama.wording;
          AppMethodBeat.o(151249);
          return paramString1;
        }
      }
      AppMethodBeat.o(151249);
      return null;
    }
    paramString1 = locala.field_accTypeRec.hrh.iterator();
    while (paramString1.hasNext())
    {
      parama = (dyi)paramString1.next();
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
  
  private String a(String paramString1, String paramString2, e.a parama, String paramString3, int paramInt)
  {
    AppMethodBeat.i(235833);
    com.tencent.mm.openim.e.c localc = new com.tencent.mm.openim.e.c();
    localc.field_appid = paramString1;
    localc.field_language = paramString3;
    localc.field_subType = paramInt;
    com.tencent.mm.kernel.h.baF();
    ((PluginOpenIM)com.tencent.mm.kernel.h.az(PluginOpenIM.class)).getAppIdInfoStg().get(localc, new String[] { "appid", "language", "subType" });
    if (localc.systemRowid == -1L)
    {
      b(paramString1, paramString3, "", paramInt);
      AppMethodBeat.o(235833);
      return null;
    }
    if (parama == e.a.prb)
    {
      paramString1 = localc.field_appRec.YCk.iterator();
      while (paramString1.hasNext())
      {
        parama = (dyj)paramString1.next();
        if (paramString2.equals(parama.key))
        {
          paramString1 = parama.wording;
          AppMethodBeat.o(235833);
          return paramString1;
        }
      }
      AppMethodBeat.o(235833);
      return null;
    }
    paramString1 = localc.field_appRec.hrh.iterator();
    while (paramString1.hasNext())
    {
      parama = (dyi)paramString1.next();
      if (paramString2.equals(parama.key))
      {
        paramString1 = parama.url;
        AppMethodBeat.o(235833);
        return paramString1;
      }
    }
    AppMethodBeat.o(235833);
    return null;
  }
  
  private void b(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(235847);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(235847);
      return;
    }
    Log.i("MicroMsg.Openim.OpenImResourceMgr", "try checkDoSceneGetRec openimAppId %s language %s wordingid %s, subType: %s", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt) });
    if (!this.ptf.containsKey(paramString1 + paramString2 + paramInt))
    {
      b localb = new b((byte)0);
      if (!Util.isNullOrNil(paramString3)) {
        localb.ptl.add(paramString3);
      }
      this.ptf.put(paramString1 + paramString2 + paramInt, localb);
      com.tencent.mm.kernel.h.baD().mCm.a(new l(paramString1, paramString2, localb.ptl, paramInt), 0);
    }
    if (Util.isNullOrNil(paramString3))
    {
      AppMethodBeat.o(235847);
      return;
    }
    paramString1 = (b)this.ptf.get(paramString1 + paramString2 + paramInt);
    if ((paramString1.ptk.contains(paramString3)) || (paramString1.ptl.contains(paramString3)))
    {
      AppMethodBeat.o(235847);
      return;
    }
    paramString1.ptk.add(paramString3);
    AppMethodBeat.o(235847);
  }
  
  private String z(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(151255);
    k localk = new k();
    localk.field_appid = paramString1;
    localk.field_language = paramString3;
    localk.field_wordingId = paramString2;
    com.tencent.mm.kernel.h.baF();
    ((PluginOpenIM)com.tencent.mm.kernel.h.az(PluginOpenIM.class)).getWordingInfoStg().get(localk, new String[] { "appid", "language", "wordingId" });
    if (localk.systemRowid == -1L)
    {
      y(paramString1, paramString3, paramString2);
      AppMethodBeat.o(151255);
      return null;
    }
    paramString1 = localk.field_wording;
    AppMethodBeat.o(151255);
    return paramString1;
  }
  
  public final Bitmap RG(String paramString)
  {
    AppMethodBeat.i(151245);
    final a locala = new a((byte)0);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(151245);
      return null;
    }
    Object localObject = new c.a();
    ((c.a)localObject).oKp = true;
    ((c.a)localObject).fullPath = ("wcf://openim/" + g.getMessageDigest(paramString.getBytes()));
    localObject = ((c.a)localObject).bKx();
    r.bKe().a(paramString, null, (com.tencent.mm.modelimage.loader.a.c)localObject, new com.tencent.mm.modelimage.loader.b.h()
    {
      public final Bitmap a(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.modelimage.loader.c.b paramAnonymousb)
      {
        return null;
      }
      
      public final void b(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.modelimage.loader.c.b paramAnonymousb)
      {
        AppMethodBeat.i(151236);
        if ((paramAnonymousb.status == 0) && (paramAnonymousb.bitmap != null) && (!paramAnonymousb.bitmap.isRecycled())) {
          locala.bitmap = paramAnonymousb.bitmap;
        }
        AppMethodBeat.o(151236);
      }
      
      public final void c(String paramAnonymousString, View paramAnonymousView) {}
    });
    paramString = locala.bitmap;
    AppMethodBeat.o(151245);
    return paramString;
  }
  
  public final TextAppearanceSpan a(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(235896);
    MMTextAppearanceSpan localMMTextAppearanceSpan = null;
    if ("3552365301".equals(paramString))
    {
      paramContext = com.tencent.mm.cd.a.l(paramContext, paramInt2);
      localMMTextAppearanceSpan = new MMTextAppearanceSpan(paramInt1, paramContext, paramContext);
    }
    AppMethodBeat.o(235896);
    return localMMTextAppearanceSpan;
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
    paramContext = paramContext.getResources().getDrawable(c.g.open_im_main_logo);
    paramContext.setBounds(0, 0, paramContext.getIntrinsicWidth(), paramContext.getIntrinsicHeight());
    paramCharSequence.setSpan(new ImageSpan(paramContext), ((CharSequence)localObject).length(), ((CharSequence)localObject).length() + 1, 33);
    AppMethodBeat.o(151240);
    return paramCharSequence;
  }
  
  public final CharSequence a(Context paramContext, String paramString1, String paramString2, float paramFloat)
  {
    AppMethodBeat.i(151244);
    paramString1 = RG(paramString1);
    if (paramString1 != null)
    {
      paramString2 = com.tencent.mm.pluginsdk.ui.span.p.b(paramContext, "  ".concat(String.valueOf(paramString2)), paramFloat);
      int i = (int)(com.tencent.mm.cd.a.fromDPToPix(paramContext, 2) + paramFloat);
      paramContext = new ImageSpan(MMApplicationContext.getContext(), paramString1);
      paramContext.getDrawable().setBounds(0, 0, i, i);
      paramString2.setSpan(paramContext, 0, 1, 33);
      AppMethodBeat.o(151244);
      return paramString2;
    }
    AppMethodBeat.o(151244);
    return paramString2;
  }
  
  public final String a(String paramString1, String paramString2, e.a parama)
  {
    AppMethodBeat.i(151247);
    com.tencent.mm.openim.e.c localc = new com.tencent.mm.openim.e.c();
    localc.field_appid = paramString1;
    localc.field_subType = 0;
    com.tencent.mm.kernel.h.baF();
    ((PluginOpenIM)com.tencent.mm.kernel.h.az(PluginOpenIM.class)).getAppIdInfoStg().get(localc, new String[] { "appid", "subType" });
    if (localc.systemRowid == -1L)
    {
      RT(paramString1);
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
  
  public final String a(String paramString1, String paramString2, e.a parama, int paramInt)
  {
    AppMethodBeat.i(235890);
    String str2 = a(paramString1, paramString2, parama, LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()), paramInt);
    String str1 = str2;
    if (str2 == null) {
      str1 = a(paramString1, paramString2, parama, "en", paramInt);
    }
    AppMethodBeat.o(235890);
    return str1;
  }
  
  public final void a(Context paramContext, TextView paramTextView, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(151243);
    if ((paramTextView instanceof EllipsizeTextView))
    {
      paramContext = (EllipsizeTextView)paramTextView;
      paramContext.setLayoutCallback(this.pth);
      paramContext.a(paramCharSequence, " ", -1, (int)paramTextView.getTextSize());
      AppMethodBeat.o(151243);
      return;
    }
    paramTextView.setText(((e)com.tencent.mm.kernel.h.ax(e.class)).a(paramContext, paramCharSequence));
    AppMethodBeat.o(151243);
  }
  
  public final void a(Context paramContext, TextView paramTextView, CharSequence paramCharSequence, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(151242);
    if ((paramTextView instanceof EllipsizeTextView))
    {
      EllipsizeTextView localEllipsizeTextView = (EllipsizeTextView)paramTextView;
      paramTextView = ((e)com.tencent.mm.kernel.h.ax(e.class)).cc(paramString1, paramString2);
      if (!Util.isNullOrNil(paramTextView))
      {
        paramContext = paramTextView;
        if (!"3552365301".equals(paramString1)) {}
      }
      for (paramContext = " @".concat(String.valueOf(paramTextView));; paramContext = "")
      {
        localEllipsizeTextView.setLayoutCallback(this.ptg);
        localEllipsizeTextView.a(paramCharSequence, paramContext, c.b.open_im_display_name_color, paramInt);
        AppMethodBeat.o(151242);
        return;
      }
    }
    paramString2 = ((e)com.tencent.mm.kernel.h.ax(e.class)).cc(paramString1, paramString2);
    if (!Util.isNullOrNil(paramString2)) {
      if (!"3552365301".equals(paramString1)) {
        break label252;
      }
    }
    label252:
    for (paramString1 = " @".concat(String.valueOf(paramString2));; paramString1 = paramString2)
    {
      paramString2 = com.tencent.mm.pluginsdk.ui.span.p.d(paramContext, paramCharSequence, paramInt);
      paramCharSequence = new SpannableStringBuilder();
      paramCharSequence.append(paramString2);
      paramString2 = new SpannableString(paramString1);
      paramContext = com.tencent.mm.cd.a.l(paramContext, c.b.open_im_display_name_color);
      paramString2.setSpan(new TextAppearanceSpan(null, 0, paramInt, paramContext, paramContext), 0, paramString1.length(), 33);
      paramCharSequence.append(paramString2);
      for (paramContext = paramCharSequence;; paramContext = com.tencent.mm.pluginsdk.ui.span.p.d(paramContext, paramCharSequence, paramInt))
      {
        paramTextView.setText(paramContext);
        AppMethodBeat.o(151242);
        return;
      }
    }
  }
  
  public final String b(String paramString1, String paramString2, e.a parama)
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
  
  public final void bRZ()
  {
    AppMethodBeat.i(151253);
    ((PluginOpenIM)com.tencent.mm.kernel.h.az(PluginOpenIM.class)).getAppIdInfoStg().omV.delete("OpenIMAppIdInfo", null, null);
    ((PluginOpenIM)com.tencent.mm.kernel.h.az(PluginOpenIM.class)).getAccTypeInfoStg().omV.delete("OpenIMAccTypeInfo", null, null);
    ((PluginOpenIM)com.tencent.mm.kernel.h.az(PluginOpenIM.class)).getWordingInfoStg().omV.delete("OpenIMWordingInfo", null, null);
    AppMethodBeat.o(151253);
  }
  
  public final int bl(String paramString, int paramInt)
  {
    AppMethodBeat.i(235881);
    com.tencent.mm.openim.e.c localc = new com.tencent.mm.openim.e.c();
    localc.field_appid = paramString;
    localc.field_subType = paramInt;
    com.tencent.mm.kernel.h.baF();
    ((PluginOpenIM)com.tencent.mm.kernel.h.az(PluginOpenIM.class)).getAppIdInfoStg().get(localc, new String[] { "appid", "subType" });
    if (localc.systemRowid == -1L)
    {
      b(paramString, LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()), "", paramInt);
      AppMethodBeat.o(235881);
      return 0;
    }
    paramInt = localc.field_appRec.YHa;
    AppMethodBeat.o(235881);
    return paramInt;
  }
  
  public final void cb(String paramString1, String paramString2)
  {
    AppMethodBeat.i(151259);
    u(paramString1, paramString2, 0);
    AppMethodBeat.o(151259);
  }
  
  public final String cc(String paramString1, String paramString2)
  {
    AppMethodBeat.i(151252);
    String str2 = z(paramString1, paramString2, LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()));
    String str1 = str2;
    if (str2 == null) {
      str1 = z(paramString1, paramString2, "en");
    }
    AppMethodBeat.o(151252);
    return str1;
  }
  
  public final SpannableString e(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(151241);
    paramContext = com.tencent.mm.pluginsdk.ui.span.p.d(paramContext, paramString, paramInt);
    AppMethodBeat.o(151241);
    return paramContext;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(151239);
    if (paramp.getType() != 453)
    {
      AppMethodBeat.o(151239);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(151239);
      return;
    }
    paramString = (l)paramp;
    paramp = (b)this.ptf.get(paramString.psy + paramString.language + paramString.subType);
    if (paramp != null)
    {
      if (!paramp.ptk.isEmpty())
      {
        while ((paramp.ptl.size() < 10) && (!paramp.ptk.isEmpty())) {
          paramp.ptl.add((String)paramp.ptk.removeFirst());
        }
        com.tencent.mm.kernel.h.baD().mCm.a(new l(paramString.psy, paramString.language, paramp.ptl, paramString.subType), 0);
        AppMethodBeat.o(151239);
        return;
      }
      this.ptf.remove(paramString.psy + paramString.language + paramString.subType);
    }
    AppMethodBeat.o(151239);
  }
  
  public final void u(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(235917);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(235917);
      return;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    boolean bool1 = false;
    Object localObject = new com.tencent.mm.openim.e.c();
    ((com.tencent.mm.openim.e.c)localObject).field_appid = paramString1;
    ((com.tencent.mm.openim.e.c)localObject).field_language = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
    ((com.tencent.mm.openim.e.c)localObject).field_subType = paramInt;
    com.tencent.mm.kernel.h.baF();
    ((PluginOpenIM)com.tencent.mm.kernel.h.az(PluginOpenIM.class)).getAppIdInfoStg().get((IAutoDBItem)localObject, new String[] { "appid", "language", "subType" });
    localStringBuffer.append(String.format("openIMAppIdinfo.field_updateTime %s | ", new Object[] { Long.valueOf(((com.tencent.mm.openim.e.c)localObject).field_updateTime) }));
    if ((((com.tencent.mm.openim.e.c)localObject).systemRowid == -1L) || (Util.secondsToNow(((com.tencent.mm.openim.e.c)localObject).field_updateTime) > 172800L)) {
      bool1 = true;
    }
    boolean bool2 = bool1;
    if (!bool1)
    {
      bool2 = bool1;
      if (!Util.isNullOrNil(paramString2))
      {
        localObject = new k();
        ((k)localObject).field_appid = paramString1;
        ((k)localObject).field_language = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
        ((k)localObject).field_wordingId = paramString2;
        com.tencent.mm.kernel.h.baF();
        ((PluginOpenIM)com.tencent.mm.kernel.h.az(PluginOpenIM.class)).getWordingInfoStg().get((IAutoDBItem)localObject, new String[] { "appid", "language", "wordingId" });
        if ((((k)localObject).systemRowid != -1L) && (Util.secondsToNow(((k)localObject).field_updateTime) <= 172800L)) {
          break label383;
        }
        bool1 = true;
      }
    }
    label383:
    for (;;)
    {
      localStringBuffer.append(String.format("wordingInfo.field_updateTime %s | ", new Object[] { Long.valueOf(((k)localObject).field_updateTime) }));
      bool2 = bool1;
      Log.i("MicroMsg.Openim.OpenImResourceMgr", "checkRecUpdate openimAppId %s wordingId %s needUpdate %s subType: %s, logBuffer: %s", new Object[] { paramString1, paramString2, Boolean.valueOf(bool2), Integer.valueOf(paramInt), localStringBuffer.toString() });
      if (bool2) {
        b(paramString1, LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()), paramString2, paramInt);
      }
      AppMethodBeat.o(235917);
      return;
    }
  }
  
  public final void y(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(151258);
    b(paramString1, paramString2, paramString3, 0);
    AppMethodBeat.o(151258);
  }
  
  final class a
  {
    Bitmap bitmap;
    
    private a() {}
  }
  
  final class b
  {
    LinkedList<String> ptk;
    LinkedList<String> ptl;
    
    private b()
    {
      AppMethodBeat.i(151237);
      this.ptk = new LinkedList();
      this.ptl = new LinkedList();
      AppMethodBeat.o(151237);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.model.ab
 * JD-Core Version:    0.7.0.1
 */