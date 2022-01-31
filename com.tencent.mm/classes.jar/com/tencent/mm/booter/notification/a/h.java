package com.tencent.mm.booter.notification.a;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.ak.a.a;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.c;
import com.tencent.mm.model.n;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.modelvideo.q;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bi.a;
import com.tencent.mm.storage.bi.c;
import com.tencent.mm.storage.bi.d;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.chatting.viewitems.j.a;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import junit.framework.Assert;

public final class h
{
  private static WeakReference<TextPaint> ebR;
  private static int ebS = 0;
  private static int ebT = 0;
  public String ebQ = "";
  public String mDesc = "";
  public String mTitle = "";
  
  private static int C(String paramString, int paramInt)
  {
    AppMethodBeat.i(16054);
    while (paramInt < paramString.length())
    {
      if (paramString.charAt(paramInt) != '%')
      {
        AppMethodBeat.o(16054);
        return paramInt;
      }
      paramInt += 1;
    }
    paramInt = paramString.length();
    AppMethodBeat.o(16054);
    return paramInt;
  }
  
  private static int IZ()
  {
    AppMethodBeat.i(16053);
    if (ebS > 0)
    {
      i = ebS;
      AppMethodBeat.o(16053);
      return i;
    }
    int i = BackwardSupportUtil.b.b(ah.getContext(), 200.0F);
    AppMethodBeat.o(16053);
    return i;
  }
  
  private static CharSequence a(String paramString, TextPaint paramTextPaint)
  {
    AppMethodBeat.i(16052);
    paramString = TextUtils.ellipsize(paramString, paramTextPaint, IZ(), TextUtils.TruncateAt.END);
    AppMethodBeat.o(16052);
    return paramString;
  }
  
  public static String a(int paramInt1, String paramString1, String paramString2, int paramInt2, Context paramContext)
  {
    AppMethodBeat.i(16042);
    paramString1 = bo.nullAsNil(a(null, paramInt1, paramString1, paramString2, paramInt2, paramContext, new PString(), new PString(), new PInt(), false, false));
    AppMethodBeat.o(16042);
    return paramString1;
  }
  
  private static String a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, PString paramPString1, PString paramPString2)
  {
    int j = 2131300089;
    AppMethodBeat.i(16044);
    String str3 = "";
    String str2;
    String str1;
    int i;
    if ((t.nZ(paramString1)) || (t.ob(paramString1)))
    {
      str2 = str3;
      str1 = paramString2;
      if (paramString2 != null)
      {
        i = paramString2.indexOf(":");
        str2 = str3;
        str1 = paramString2;
        if (i >= 0)
        {
          str2 = str3;
          str1 = paramString2;
          if (i < paramString2.length())
          {
            paramString1 = paramString2.substring(0, i);
            if (!ad.arc(paramString1))
            {
              str2 = str3;
              str1 = paramString2;
              if (!ad.are(paramString1)) {}
            }
            else
            {
              str2 = s.nE(paramString1);
              paramPString2.value = paramString1;
              str1 = paramString2.substring(i + 1);
            }
          }
        }
      }
      if (bo.nullAsNil(str2).length() > 0) {
        break label316;
      }
      if (paramString3 != null) {
        break label309;
      }
    }
    for (;;)
    {
      paramPString1.value = str1;
      paramContext = paramPString1.value;
      AppMethodBeat.o(16044);
      return paramContext;
      if (!ad.arc(paramString1))
      {
        str2 = str3;
        str1 = paramString2;
        if (!ad.are(paramString1)) {
          break;
        }
      }
      s.nE(paramString1);
      paramPString2.value = paramString1;
      if (paramInt == 1)
      {
        paramContext = new StringBuilder().append(paramContext.getString(2131300089, new Object[] { "" }));
        if (paramString3 == null) {}
        for (;;)
        {
          paramPString1.value = paramString2;
          paramPString2.value = "";
          paramContext = paramPString1.value;
          AppMethodBeat.o(16044);
          return paramContext;
          paramString2 = paramString3;
        }
      }
      if (paramString3 == null) {}
      for (;;)
      {
        paramPString1.value = paramString2;
        paramPString2.value = "";
        paramContext = paramPString1.value;
        AppMethodBeat.o(16044);
        return paramContext;
        paramString2 = paramString3;
      }
      label309:
      str1 = paramString3;
    }
    label316:
    paramString1 = new StringBuilder();
    if (paramInt == 1)
    {
      i = 2131300089;
      paramString2 = paramString1.append(paramContext.getString(i));
      if (paramString3 != null) {
        break label430;
      }
      paramString1 = str1;
      label352:
      paramPString1.value = paramString1;
      paramString1 = new StringBuilder();
      if (paramInt != 1) {
        break label436;
      }
      paramInt = j;
      label381:
      paramContext = paramString1.append(paramContext.getString(paramInt, new Object[] { str2 }));
      if (paramString3 != null) {
        break label442;
      }
    }
    for (;;)
    {
      paramContext = str1;
      AppMethodBeat.o(16044);
      return paramContext;
      i = 2131300099;
      break;
      label430:
      paramString1 = paramString3;
      break label352;
      label436:
      paramInt = 2131300099;
      break label381;
      label442:
      str1 = paramString3;
    }
  }
  
  public static String a(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(16058);
    if (paramBoolean)
    {
      String str = com.tencent.mm.cd.b.duW().aqC(paramString);
      paramString = str;
      if (paramInt3 > 1) {
        paramString = paramContext.getResources().getQuantityString(2131361814, paramInt3, new Object[] { Integer.valueOf(paramInt3) }) + str;
      }
      AppMethodBeat.o(16058);
      return paramString;
    }
    paramContext = paramContext.getResources().getQuantityString(2131361815, paramInt1, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(16058);
    return paramContext;
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(16038);
    paramContext = a(0, paramString2, paramString1, paramInt, paramContext);
    paramContext = j.amy(com.tencent.mm.cd.b.duW().aqC(paramContext));
    AppMethodBeat.o(16038);
    return paramContext;
  }
  
  private static String a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, Context paramContext, PString paramPString1, PString paramPString2, PInt paramPInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(16043);
    if (paramContext != null)
    {
      bool = true;
      Assert.assertTrue("context is null", bool);
      if ((paramString2 == null) || (paramString2.length() <= 0)) {
        break label76;
      }
    }
    label76:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("username is null", bool);
      if ((paramBoolean1) || (!kM(paramString2))) {
        break label82;
      }
      paramString1 = paramContext.getString(2131303374);
      AppMethodBeat.o(16043);
      return paramString1;
      bool = false;
      break;
    }
    label82:
    if (t.of(paramString2))
    {
      if (paramBoolean1)
      {
        AppMethodBeat.o(16043);
        return "";
      }
      paramString1 = bC(paramContext);
      AppMethodBeat.o(16043);
      return paramString1;
    }
    if ((paramString3 != null) && (paramBoolean1)) {
      paramString3 = kK(paramString3);
    }
    for (int k = 1;; k = 0)
    {
      paramPString1.value = paramString3;
      int i;
      String str1;
      String str2;
      Object localObject3;
      if ((paramInt1 == 0) && ((t.lA(paramString2)) || (t.nK(paramString2))))
      {
        i = bf.pq(paramString3);
        if (i > 0)
        {
          str1 = paramString3.substring(0, i).trim();
          str2 = s.getDisplayName(str1, paramString2);
          localObject3 = (paramString3 + " ").substring(i + 1);
        }
      }
      for (;;)
      {
        i = 0;
        Object localObject1;
        int j;
        if ((t.ot(paramString2)) || (t.oC(paramString2)))
        {
          i = paramString3.indexOf(":");
          localObject1 = paramString3;
          if (i != -1)
          {
            paramPString2.value = paramString3.substring(0, i);
            localObject1 = paramString3.substring(i + 1);
          }
          j = 0;
          paramString3 = (String)localObject1;
        }
        for (;;)
        {
          switch (paramInt2)
          {
          default: 
            paramString1 = paramString3;
          case 3: 
          case 23: 
          case 33: 
          case 47: 
          case 1048625: 
          case 13: 
          case 39: 
          case 11: 
          case 36: 
          case 34: 
          case 43: 
          case 62: 
          case 12299999: 
          case -1879048191: 
          case -1879048190: 
          case -1879048189: 
          case 50: 
          case 53: 
          case 52: 
          case -1879048188: 
          case 37: 
          case 40: 
          case 35: 
          case 42: 
          case 66: 
          case 48: 
            label742:
            label751:
            label1269:
            do
            {
              paramString3 = "";
              localObject1 = null;
              i = 0;
              for (;;)
              {
                if (!t.oa(paramString2)) {
                  break label7418;
                }
                if (1 != paramInt1) {
                  break label7136;
                }
                if (bo.isNullOrNil(paramString3)) {
                  break label7087;
                }
                paramPString1.value = paramString3;
                AppMethodBeat.o(16043);
                return paramString3;
                aw.aaz();
                localObject1 = c.YF().arH(paramString2);
                if (((localObject1 == null) || (!((ak)localObject1).ji(2097152))) && (!paramBoolean2)) {
                  break label7945;
                }
                j = 1;
                i = j;
                if (paramString3 == null) {
                  break label7945;
                }
                int m = paramString3.indexOf(":");
                i = j;
                if (m == -1) {
                  break label7945;
                }
                paramPString2.value = paramString3.substring(0, m);
                paramString3 = paramString3.substring(m + 1);
                j = 1;
                break;
                localObject3 = paramContext.getString(2131297036);
                if (str1.length() > 0)
                {
                  paramString1 = str1 + ": ";
                  if (str1.length() <= 0) {
                    break label952;
                  }
                }
                for (paramString3 = "%s: ";; paramString3 = "")
                {
                  paramPString1.value = paramString3;
                  localObject1 = null;
                  i = 0;
                  paramString3 = (String)localObject3;
                  break;
                  paramString1 = "";
                  break label916;
                }
                localObject3 = ap.arZ(paramString3);
                localObject1 = ((ap)localObject3).alM() + ": ";
                if ((paramString1 != null) && (paramString1.length() == 32)) {}
                for (paramString3 = paramString1;; paramString3 = paramContext.getString(2131296915))
                {
                  paramPString1.value = "";
                  paramPString2.value = ((ap)localObject3).alM();
                  localObject3 = null;
                  i = 0;
                  paramString1 = (String)localObject1;
                  localObject1 = localObject3;
                  break;
                }
                paramString1 = a(paramContext, paramInt1, paramString2, paramString3, paramContext.getString(2131297036), paramPString1, paramPString2);
                paramString3 = "";
                localObject1 = null;
                i = 0;
                continue;
                paramString1 = a(paramContext, paramInt1, paramString2, paramString3, null, paramPString1, paramPString2);
                paramString3 = "";
                localObject1 = null;
                i = 0;
                continue;
                if ((ad.arc(paramString2)) || (ad.are(paramString2)) || (t.nZ(paramString2)) || (t.ob(paramString2)))
                {
                  paramString1 = a(paramContext, paramInt1, paramString2, paramString3, paramContext.getString(2131297105), paramPString1, paramPString2);
                  paramString3 = "";
                  localObject1 = null;
                  i = 0;
                }
                else
                {
                  paramString1 = paramString3;
                  if (paramString3 != null)
                  {
                    paramString1 = paramString3;
                    if (paramString3.length() > 0)
                    {
                      paramString1 = paramString3;
                      if (!t.oa(paramString2))
                      {
                        if (!t.lA(paramString2)) {
                          break label1269;
                        }
                        paramString3 = new p(paramString3);
                        paramString1 = paramString3.alM() + ": ";
                        paramPString1.value = "%s:";
                        paramPString2.value = paramString3.alM();
                      }
                    }
                  }
                  for (;;)
                  {
                    paramString3 = paramContext.getString(2131297105);
                    localObject1 = null;
                    i = 0;
                    break;
                    paramString1 = "";
                  }
                  if ((ad.arc(paramString2)) || (ad.are(paramString2)) || (t.nZ(paramString2)) || (t.ob(paramString2)))
                  {
                    paramString1 = a(paramContext, paramInt1, paramString2, paramString3, paramContext.getString(2131297102), paramPString1, paramPString2);
                    paramString3 = "";
                    localObject1 = null;
                    i = 0;
                  }
                  else
                  {
                    paramString1 = paramString3;
                    if (paramString3 != null)
                    {
                      paramString1 = paramString3;
                      if (paramString3.length() > 0)
                      {
                        paramString1 = paramString3;
                        if (!t.oa(paramString2))
                        {
                          if (!t.lA(paramString2)) {
                            break label1435;
                          }
                          paramString3 = new q(paramString3);
                          paramString1 = paramString3.alM() + ": ";
                          paramPString1.value = "%s:";
                          paramPString2.value = paramString3.alM();
                        }
                      }
                    }
                    for (;;)
                    {
                      paramString3 = paramContext.getString(2131297102);
                      localObject1 = null;
                      i = 0;
                      break;
                      paramString1 = "";
                    }
                    paramString3 = paramContext.getString(2131297108);
                    localObject1 = null;
                    i = 0;
                    paramString1 = "";
                    continue;
                    paramString3 = paramContext.getString(2131297107);
                    localObject1 = null;
                    i = 0;
                    paramString1 = "";
                    continue;
                    if (paramString3.equals(bi.yOc))
                    {
                      paramString3 = paramContext.getString(2131297108);
                      localObject1 = null;
                      i = 0;
                      paramString1 = "";
                    }
                    else
                    {
                      paramString1 = paramString3;
                      if (!paramString3.equals(bi.yOb)) {
                        break label742;
                      }
                      paramString3 = paramContext.getString(2131297110);
                      localObject1 = null;
                      i = 0;
                      paramString1 = "";
                      continue;
                      paramString3 = paramContext.getString(2131297108);
                      localObject1 = null;
                      i = 0;
                      paramString1 = "";
                      continue;
                      paramString3 = paramContext.getString(2131297110);
                      localObject1 = null;
                      i = 0;
                      paramString1 = "";
                      continue;
                      paramString1 = paramString3;
                      if (paramString3 == null) {
                        break label742;
                      }
                      paramString1 = paramString3;
                      if (paramString3.length() <= 0) {
                        break label742;
                      }
                      localObject1 = bi.d.asm(paramString3);
                      paramString1 = paramString3;
                      if (((bi.d)localObject1).dyt() != null)
                      {
                        paramString1 = paramString3;
                        if (((bi.d)localObject1).dyt().length() <= 0) {}
                      }
                      switch (((bi.d)localObject1).getScene())
                      {
                      case 19: 
                      case 20: 
                      case 21: 
                      default: 
                        paramString1 = paramContext.getString(2131300111, new Object[] { ((bi.d)localObject1).getDisplayName() });
                        paramPString1.value = paramString1;
                        paramString3 = "";
                        localObject1 = null;
                        i = 0;
                        break;
                      case 18: 
                        paramString1 = paramContext.getString(2131300092, new Object[] { ((bi.d)localObject1).getDisplayName() });
                        paramString3 = "";
                        localObject1 = null;
                        i = 0;
                        break;
                      case 22: 
                      case 23: 
                      case 24: 
                      case 26: 
                      case 27: 
                      case 28: 
                      case 29: 
                        paramString1 = paramContext.getString(2131300102, new Object[] { ((bi.d)localObject1).getDisplayName() });
                        paramString3 = "";
                        localObject1 = null;
                        i = 0;
                        break;
                      case 25: 
                        paramString1 = paramContext.getString(2131300024, new Object[] { ((bi.d)localObject1).getDisplayName() });
                        paramPString1.value = paramString1;
                        paramString3 = "";
                        localObject1 = null;
                        i = 0;
                        continue;
                        paramString1 = paramString3;
                        if (paramString3 == null) {
                          break label742;
                        }
                        paramString1 = paramString3;
                        if (paramString3.length() <= 0) {
                          break label742;
                        }
                        localObject1 = bi.a.asj(paramString3);
                        paramString1 = paramString3;
                        if (((bi.a)localObject1).dyt() != null)
                        {
                          paramString1 = paramString3;
                          if (((bi.a)localObject1).dyt().length() > 0)
                          {
                            paramString1 = paramContext.getString(2131300049, new Object[] { ((bi.a)localObject1).getDisplayName() });
                            paramPString1.value = paramString1;
                          }
                        }
                        paramString3 = "";
                        localObject1 = null;
                        i = 0;
                        continue;
                        paramString1 = paramString3;
                        if (bo.nullAsNil(paramString3).length() <= 0) {
                          break label742;
                        }
                        aw.aaz();
                        paramString1 = c.YC().Tw(paramString3);
                        paramString1 = paramContext.getString(2131300085, new Object[] { paramString1.getSender(), paramString1.getTitle() });
                        paramPString1.value = paramString1;
                        paramString3 = "";
                        localObject1 = null;
                        i = 0;
                        continue;
                        paramString1 = paramString3;
                        if (bo.nullAsNil(paramString3).length() <= 0) {
                          break label742;
                        }
                        if (t.lA(paramString2))
                        {
                          localObject1 = bf.pu(paramString3);
                          paramString1 = (String)localObject1;
                          if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
                        }
                        else
                        {
                          paramString1 = paramString2;
                        }
                        aw.aaz();
                        localObject3 = c.YC().Ty(paramString3);
                        aw.aaz();
                        localObject1 = c.YA().arw(paramString1).Of();
                        paramString3 = (String)localObject1;
                        if (t.lA((String)localObject1)) {
                          paramString3 = n.Q(n.nw((String)localObject1));
                        }
                        if (paramInt1 == 1)
                        {
                          localObject1 = paramContext.getString(2131300025, new Object[] { paramString3, ((bi.a)localObject3).getDisplayName() });
                          paramPString1.value = paramContext.getString(2131300025, new Object[] { "%s", ((bi.a)localObject3).getDisplayName() });
                          paramPString2.value = paramString1;
                          paramString3 = "";
                          localObject3 = null;
                          i = 0;
                          paramString1 = (String)localObject1;
                          localObject1 = localObject3;
                        }
                        else
                        {
                          localObject1 = paramContext.getString(2131300026, new Object[] { paramString3, ((bi.a)localObject3).getDisplayName() });
                          paramPString1.value = paramContext.getString(2131300026, new Object[] { "%s", ((bi.a)localObject3).getDisplayName() });
                          paramPString2.value = paramString1;
                          paramString3 = "";
                          localObject3 = null;
                          i = 0;
                          paramString1 = (String)localObject1;
                          localObject1 = localObject3;
                        }
                        break;
                      }
                    }
                  }
                }
              }
              paramString1 = paramString3;
            } while (bo.nullAsNil(paramString3).length() <= 0);
            label916:
            label952:
            if (t.lA(paramString2))
            {
              i = bf.pq(paramString3);
              if (i != -1)
              {
                paramString1 = paramString3.substring(0, i).trim();
                label2300:
                bf.pv(paramString3);
              }
            }
            label1435:
            break;
          }
          for (;;)
          {
            for (;;)
            {
              if (paramInt1 == 1)
              {
                paramString1 = paramContext.getString(2131301088);
                paramPString1.value = paramString1;
                paramString3 = "";
                localObject1 = null;
                i = 0;
                break label751;
              }
              localObject1 = paramContext.getString(2131301088);
              paramPString1.value = paramContext.getString(2131301088);
              paramPString2.value = paramString1;
              paramString3 = "";
              localObject3 = null;
              i = 0;
              paramString1 = (String)localObject1;
              localObject1 = localObject3;
              break label751;
              paramString1 = j.b.mY(bo.apU((String)localObject3));
              if (paramString1.fgX != 0) {
                if (paramString1.fgX == 1) {
                  paramString1 = paramContext.getString(2131302934);
                }
              }
              for (;;)
              {
                paramPString2.value = str1;
                paramPString1.value = "";
                paramString3 = paramString1;
                localObject1 = null;
                i = 0;
                paramString1 = "";
                break;
                if (paramString1.fgX == 2) {
                  paramString1 = paramContext.getString(2131302936);
                } else if (paramString1.fgX == 3) {
                  paramString1 = paramContext.getString(2131302935);
                } else {
                  paramString1 = paramContext.getString(2131302937);
                }
              }
              localObject1 = bo.apU((String)localObject3);
              paramString3 = "";
              paramString1 = "";
              localObject1 = j.b.mY((String)localObject1);
              if (localObject1 != null)
              {
                paramPString1.value = (paramContext.getString(2131302950) + bo.nullAsNil(((j.b)localObject1).title));
                paramString1 = paramPString1.value;
              }
              paramPString2.value = str1;
              localObject1 = null;
              i = 0;
              break label751;
              localObject1 = bo.apU((String)localObject3);
              paramString3 = "";
              paramString1 = "";
              localObject1 = j.b.mY((String)localObject1);
              if (localObject1 != null)
              {
                if (paramInt1 != 1) {
                  break label2687;
                }
                i = 1;
                label2615:
                switch (((j.b)localObject1).fhD)
                {
                case 2: 
                default: 
                  paramPString1.value = bo.nullAsNil(((j.b)localObject1).title);
                }
              }
              for (;;)
              {
                paramString1 = paramPString1.value;
                paramPString2.value = str1;
                localObject1 = null;
                i = 0;
                break;
                label2687:
                i = 0;
                break label2615;
                if (i != 0)
                {
                  paramPString1.value = paramContext.getString(2131297205);
                }
                else
                {
                  paramPString1.value = paramContext.getString(2131297208);
                  continue;
                  if (i != 0)
                  {
                    paramPString1.value = paramContext.getString(2131297206);
                  }
                  else
                  {
                    paramPString1.value = paramContext.getString(2131297203);
                    continue;
                    if (i != 0) {
                      paramPString1.value = paramContext.getString(2131297207);
                    } else {
                      paramPString1.value = paramContext.getString(2131297204);
                    }
                  }
                }
              }
              paramString1 = bo.apU((String)localObject3);
              localObject3 = "";
              paramString3 = "";
              paramString1 = j.b.mY(paramString1);
              if (paramString1 != null)
              {
                if (paramInt1 != 1) {
                  break label2920;
                }
                i = 1;
                label2834:
                if (i == 0) {
                  break label2926;
                }
                paramPString1.value = ("[" + paramString1.fie + "]" + paramString1.fib);
              }
              for (;;)
              {
                paramString3 = paramPString1.value;
                paramString1 = paramString3;
                if (t.ot(paramString2)) {
                  break label7923;
                }
                paramString1 = paramString3;
                if (j != 0) {
                  break label7923;
                }
                paramPString2.value = str1;
                localObject1 = null;
                i = 0;
                paramString1 = paramString3;
                paramString3 = (String)localObject3;
                break;
                label2920:
                i = 0;
                break label2834;
                label2926:
                if (!bo.isNullOrNil(str2)) {
                  paramPString1.value = (bo.nullAsNil(str2) + ": [" + paramString1.fie + "]" + paramString1.fia);
                } else {
                  paramPString1.value = ("[" + paramString1.fie + "]" + paramString1.fia);
                }
              }
              localObject1 = bo.apU((String)localObject3);
              paramString3 = "";
              paramString1 = "";
              localObject1 = j.b.mY((String)localObject1);
              if (localObject1 == null) {
                break label7923;
              }
              paramString1 = (com.tencent.mm.af.b)((j.b)localObject1).R(com.tencent.mm.af.b.class);
              if (paramInt1 == 1)
              {
                i = 1;
                label3072:
                if (i == 0) {
                  break label3129;
                }
              }
              label3129:
              for (paramPString1.value = paramContext.getString(2131300699, new Object[] { paramString1.ffN });; paramPString1.value = paramContext.getString(2131300699, new Object[] { paramString1.ffO }))
              {
                paramString1 = paramPString1.value;
                paramPString2.value = str1;
                localObject1 = null;
                i = 0;
                break;
                i = 0;
                break label3072;
              }
              paramString3 = bo.apU((String)localObject3);
              paramString1 = "";
              paramString3 = j.b.mY(paramString3);
              if (paramString3 != null)
              {
                paramString1 = (j.a)paramString3.R(j.a.class);
                if (paramString1.state != 1) {
                  break label3231;
                }
              }
              label3231:
              for (paramString1 = paramContext.getString(2131299033, new Object[] { paramString1.appName });; paramString1 = paramContext.getString(2131299051, new Object[] { paramString1.appName }))
              {
                paramPString1.value = paramString1;
                paramString3 = "";
                localObject1 = null;
                i = 0;
                break;
              }
              switch (j.b.mY(bo.apU((String)localObject3)).fgX)
              {
              default: 
                paramString1 = paramContext.getString(2131297041);
                label3301:
                if (str1.length() <= 0) {
                  break;
                }
              }
              for (paramString3 = str1 + ": ";; paramString3 = "")
              {
                if ((!t.ot(paramString2)) && (j == 0)) {
                  paramPString2.value = str1;
                }
                paramPString1.value = "";
                localObject3 = paramString1;
                localObject1 = null;
                i = 0;
                paramString1 = paramString3;
                paramString3 = (String)localObject3;
                break;
                paramString1 = paramContext.getString(2131297042);
                break label3301;
                paramString1 = paramContext.getString(2131297044);
                break label3301;
              }
              paramString3 = j.b.mY(bo.apU((String)localObject3));
              if (paramString3 == null)
              {
                ab.e("MicroMsg.Notification.Wording", "decode msg content failed");
                AppMethodBeat.o(16043);
                return "";
              }
              localObject3 = "";
              localObject1 = paramContext.getString(2131298001);
              if (str1.length() > 0)
              {
                paramString1 = str1 + ": " + (String)localObject1 + paramString3.title;
                label3491:
                if ((!t.ot(paramString2)) && (j == 0)) {
                  paramPString2.value = str1;
                }
                if (str1.length() <= 0) {
                  break label3588;
                }
              }
              label3588:
              for (paramString3 = "%s: " + (String)localObject1 + paramString3.title;; paramString3 = (String)localObject1 + paramString3.title)
              {
                paramPString1.value = paramString3;
                localObject1 = null;
                i = 0;
                paramString3 = (String)localObject3;
                break;
                paramString1 = (String)localObject1 + paramString3.title;
                break label3491;
              }
              paramString1 = j.b.mY(bo.apU((String)localObject3));
              if (paramString1 == null)
              {
                ab.e("MicroMsg.Notification.Wording", "decode msg content failed");
                AppMethodBeat.o(16043);
                return "";
              }
              localObject3 = "";
              paramString3 = paramContext.getString(2131298001);
              if (paramInt1 == 1)
              {
                paramString3 = paramString3 + paramString1.fhR;
                if (str1.length() > 0) {}
                for (paramString1 = "%s: ".concat(String.valueOf(paramString3));; paramString1 = String.valueOf(paramString3))
                {
                  paramPString1.value = paramString1;
                  paramString1 = paramString3;
                  if (t.ot(paramString2)) {
                    break label7923;
                  }
                  paramString1 = paramString3;
                  if (j != 0) {
                    break label7923;
                  }
                  paramPString2.value = str1;
                  localObject1 = null;
                  i = 0;
                  paramString1 = paramString3;
                  paramString3 = (String)localObject3;
                  break;
                }
              }
              paramString3 = paramString3 + paramString1.fhQ;
              if (str1.length() > 0) {}
              for (paramString1 = "%s: ".concat(String.valueOf(paramString3));; paramString1 = String.valueOf(paramString3))
              {
                paramPString1.value = paramString1;
                break;
              }
              paramString3 = j.b.mY(bo.apU((String)localObject3));
              if (paramString3 == null)
              {
                ab.e("MicroMsg.Notification.Wording", "decode msg content failed");
                AppMethodBeat.o(16043);
                return "";
              }
              localObject3 = "";
              if (str1.length() > 0)
              {
                paramString1 = str1 + ": " + paramString3.title;
                label3885:
                if ((!t.ot(paramString2)) && (j == 0)) {
                  paramPString2.value = str1;
                }
                if (str1.length() <= 0) {
                  break label3959;
                }
              }
              label3959:
              for (paramString3 = "%s: " + paramString3.title;; paramString3 = paramString3.title)
              {
                paramPString1.value = paramString3;
                localObject1 = null;
                i = 0;
                paramString3 = (String)localObject3;
                break;
                paramString1 = paramString3.title;
                break label3885;
              }
              localObject3 = paramContext.getString(2131296543);
              if (str1.length() > 0)
              {
                paramString1 = str1 + ": ";
                label4007:
                if ((!t.ot(paramString2)) && (j == 0)) {
                  paramPString2.value = str1;
                }
                if (str1.length() <= 0) {
                  break label4062;
                }
              }
              label4062:
              for (paramString3 = "%s: ";; paramString3 = "")
              {
                paramPString1.value = paramString3;
                localObject1 = null;
                i = 0;
                paramString3 = (String)localObject3;
                break;
                paramString1 = "";
                break label4007;
              }
              paramString1 = j.b.mY(bo.apU((String)localObject3));
              if (paramString1 == null)
              {
                ab.e("MicroMsg.Notification.Wording", "decode msg content failed");
                AppMethodBeat.o(16043);
                return "";
              }
              localObject3 = "";
              try
              {
                paramString1 = URLDecoder.decode(paramString1.content, "UTF-8");
                paramString3 = paramString1;
                paramString1 = j.amy(paramString1);
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  paramString1 = paramString3;
                  ab.printErrStackTrace("MicroMsg.Notification.Wording", localException, "", new Object[0]);
                  continue;
                  paramString3 = paramString1;
                }
              }
              if ((!t.ot(paramString2)) && (j == 0)) {
                paramPString2.value = str1;
              }
              if (str1.length() > 0)
              {
                paramString3 = "%s: ".concat(String.valueOf(paramString1));
                paramPString1.value = paramString3;
                localObject1 = null;
                i = 0;
                paramString3 = (String)localObject3;
                break label751;
              }
              paramString1 = bo.apU((String)localObject3);
              localObject2 = j.b.mY(paramString1);
              if (localObject2 == null)
              {
                ab.e("MicroMsg.Notification.Wording", "decode msg content failed");
                AppMethodBeat.o(16043);
                return "";
              }
              switch (((j.b)localObject2).type)
              {
              case 9: 
              case 10: 
              case 11: 
              case 12: 
              case 13: 
              case 14: 
              case 18: 
              case 20: 
              case 21: 
              case 22: 
              case 23: 
              case 28: 
              case 29: 
              case 30: 
              case 31: 
              case 32: 
              case 35: 
              case 37: 
              case 38: 
              case 39: 
              case 41: 
              case 42: 
              case 43: 
              case 45: 
              default: 
                paramString3 = paramContext.getString(2131296543);
                localObject2 = null;
                i = 0;
                paramString1 = "";
                break;
              case 1: 
                localObject3 = "";
                if (str1.length() > 0)
                {
                  paramString1 = str1 + ": " + ((j.b)localObject2).title;
                  if ((!t.ot(paramString2)) && (j == 0)) {
                    paramPString2.value = str1;
                  }
                  if (str1.length() <= 0) {
                    break label4579;
                  }
                }
                for (paramString3 = "%s: " + ((j.b)localObject2).title;; paramString3 = ((j.b)localObject2).title)
                {
                  paramPString1.value = paramString3;
                  localObject2 = null;
                  i = 0;
                  paramString3 = (String)localObject3;
                  break;
                  paramString1 = ((j.b)localObject2).title;
                  break label4503;
                }
              case 2: 
                localObject3 = paramContext.getString(2131297036);
                if (str1.length() > 0)
                {
                  paramString1 = str1 + ": ";
                  if ((!t.ot(paramString2)) && (j == 0)) {
                    paramPString2.value = str1;
                  }
                  if (str1.length() <= 0) {
                    break label4683;
                  }
                }
                for (paramString3 = "%s: ";; paramString3 = "")
                {
                  paramPString1.value = paramString3;
                  localObject2 = null;
                  i = 0;
                  paramString3 = (String)localObject3;
                  break;
                  paramString1 = "";
                  break label4628;
                }
              case 3: 
                localObject3 = paramContext.getString(2131297003);
                if (str1.length() > 0)
                {
                  paramString1 = str1 + ": ";
                  if ((!t.ot(paramString2)) && (j == 0)) {
                    paramPString2.value = str1;
                  }
                  if (str1.length() <= 0) {
                    break label4788;
                  }
                }
                for (paramString3 = "%s: ";; paramString3 = "")
                {
                  paramPString1.value = paramString3;
                  localObject2 = ((j.b)localObject2).title;
                  i = 1;
                  paramString3 = (String)localObject3;
                  break;
                  paramString1 = "";
                  break label4729;
                }
              case 4: 
                localObject3 = paramContext.getString(2131297102);
                if (str1.length() > 0)
                {
                  paramString1 = str1 + ": ";
                  if ((!t.ot(paramString2)) && (j == 0)) {
                    paramPString2.value = str1;
                  }
                  if (str1.length() <= 0) {
                    break label4893;
                  }
                }
                for (paramString3 = "%s: ";; paramString3 = "")
                {
                  paramPString1.value = paramString3;
                  localObject2 = ((j.b)localObject2).title;
                  i = 1;
                  paramString3 = (String)localObject3;
                  break;
                  paramString1 = "";
                  break label4834;
                }
              case 6: 
                localObject3 = paramContext.getString(2131296962);
                if (str1.length() > 0)
                {
                  paramString1 = str1 + ": ";
                  if ((!t.ot(paramString2)) && (j == 0)) {
                    paramPString2.value = str1;
                  }
                  if (str1.length() <= 0) {
                    break label4998;
                  }
                }
                for (paramString3 = "%s: ";; paramString3 = "")
                {
                  paramPString1.value = paramString3;
                  localObject2 = ((j.b)localObject2).title;
                  i = 1;
                  paramString3 = (String)localObject3;
                  break;
                  paramString1 = "";
                  break label4939;
                }
              case 7: 
                localObject3 = paramContext.getString(2131296543);
                if (str1.length() > 0)
                {
                  paramString1 = str1 + ": ";
                  if ((!t.ot(paramString2)) && (j == 0)) {
                    paramPString2.value = str1;
                  }
                  if (str1.length() <= 0) {
                    break label5099;
                  }
                }
                for (paramString3 = "%s: ";; paramString3 = "")
                {
                  paramPString1.value = paramString3;
                  localObject2 = null;
                  i = 0;
                  paramString3 = (String)localObject3;
                  break;
                  paramString1 = "";
                  break label5044;
                }
              case 5: 
                localObject3 = paramContext.getString(2131297097);
                if (str1.length() > 0)
                {
                  paramString1 = str1 + ": ";
                  if ((!t.ot(paramString2)) && (j == 0) && (!t.oC(paramString2))) {
                    paramPString2.value = str1;
                  }
                  if (str1.length() <= 0) {
                    break label5211;
                  }
                }
                for (paramString3 = "%s: ";; paramString3 = "")
                {
                  paramPString1.value = paramString3;
                  localObject2 = ((j.b)localObject2).getTitle();
                  i = 1;
                  paramString3 = (String)localObject3;
                  break;
                  paramString1 = "";
                  break label5145;
                }
              case 46: 
                paramString3 = paramContext.getString(2131296543);
                localObject2 = null;
                i = 0;
                paramString1 = "";
                break;
              case 33: 
              case 36: 
                localObject3 = "";
                paramString3 = paramContext.getString(2131296607);
                if (str1.length() > 0)
                {
                  paramString1 = str1 + ": " + paramString3 + ((j.b)localObject2).title;
                  if ((!t.ot(paramString2)) && (j == 0) && (!t.oC(paramString2))) {
                    paramPString2.value = str1;
                  }
                  if (str1.length() <= 0) {
                    break label5397;
                  }
                }
                for (paramString3 = "%s: " + paramString3 + ((j.b)localObject2).title;; paramString3 = paramString3 + ((j.b)localObject2).title)
                {
                  paramPString1.value = paramString3;
                  localObject2 = null;
                  i = 0;
                  paramString3 = (String)localObject3;
                  break;
                  paramString1 = paramString3 + ((j.b)localObject2).title;
                  break label5293;
                }
              case 44: 
                if (((j.b)localObject2).cH(false))
                {
                  localObject3 = "";
                  paramString3 = ((j.b)localObject2).q(paramContext, true);
                  if (!bo.isNullOrNil(paramString3))
                  {
                    if (str1.length() > 0)
                    {
                      paramString1 = str1 + ": " + paramString3 + ((j.b)localObject2).title;
                      paramPString2.value = str1;
                      if (str1.length() <= 0) {
                        break label5579;
                      }
                    }
                    for (paramString3 = "%s: " + paramString3 + ((j.b)localObject2).title;; paramString3 = paramString3 + ((j.b)localObject2).title)
                    {
                      paramPString1.value = paramString3;
                      localObject2 = null;
                      i = 0;
                      paramString3 = (String)localObject3;
                      break;
                      paramString1 = paramString3 + ((j.b)localObject2).title;
                      break label5494;
                    }
                  }
                  paramString3 = paramContext.getString(2131296543);
                  localObject2 = null;
                  i = 0;
                  paramString1 = "";
                  break;
                }
                paramString3 = paramContext.getString(2131296543);
                localObject2 = null;
                i = 0;
                paramString1 = "";
                break;
              case 8: 
                paramString3 = paramContext.getString(2131296916);
                if (str1.length() > 0) {}
                for (paramString1 = str1 + ": ";; paramString1 = "")
                {
                  if ((!t.ot(paramString2)) && (j == 0)) {
                    paramPString2.value = str1;
                  }
                  paramPString1.value = "";
                  localObject2 = null;
                  i = 0;
                  break;
                }
              case 15: 
              case 26: 
              case 27: 
                paramString3 = paramContext.getString(2131296917);
                if (str1.length() > 0) {}
                for (paramString1 = str1 + ": ";; paramString1 = "")
                {
                  if ((!t.ot(paramString2)) && (j == 0)) {
                    paramPString2.value = str1;
                  }
                  paramPString1.value = "";
                  localObject2 = null;
                  i = 0;
                  break;
                }
              case 25: 
                paramString3 = paramContext.getString(2131296903);
                if (str1.length() > 0) {}
                for (paramString1 = str1 + ": ";; paramString1 = "")
                {
                  if ((!t.ot(paramString2)) && (j == 0)) {
                    paramPString2.value = str1;
                  }
                  paramPString1.value = "";
                  localObject2 = null;
                  i = 0;
                  break;
                }
              case 17: 
                localObject3 = "";
                if (str1.length() > 0)
                {
                  paramString1 = str1 + ": " + ((j.b)localObject2).title;
                  if ((!t.ot(paramString2)) && (j == 0)) {
                    paramPString2.value = str1;
                  }
                  if (str1.length() <= 0) {
                    break label6005;
                  }
                }
                for (paramString3 = "%s: " + ((j.b)localObject2).title;; paramString3 = ((j.b)localObject2).title)
                {
                  paramPString1.value = paramString3;
                  localObject2 = null;
                  i = 0;
                  paramString3 = (String)localObject3;
                  break;
                  paramString1 = ((j.b)localObject2).title;
                  break label5929;
                }
              case 19: 
                localObject3 = paramContext.getString(2131297055);
                if (str1.length() > 0)
                {
                  paramString1 = str1 + ": ";
                  if ((!t.ot(paramString2)) && (j == 0)) {
                    paramPString2.value = str1;
                  }
                  if (str1.length() <= 0) {
                    break label6109;
                  }
                }
                for (paramString3 = "%s: ";; paramString3 = "")
                {
                  paramPString1.value = paramString3;
                  localObject2 = null;
                  i = 0;
                  paramString3 = (String)localObject3;
                  break;
                  paramString1 = "";
                  break label6054;
                }
              case 24: 
                paramString1 = "";
                if (!bo.isNullOrNil(((j.b)localObject2).description))
                {
                  i = ((j.b)localObject2).description.indexOf("\n");
                  paramString1 = ((j.b)localObject2).description;
                  if (i > 0) {
                    paramString1 = paramString1.substring(0, i);
                  }
                }
                else
                {
                  localObject3 = paramContext.getString(2131299859) + paramString1;
                  if (str1.length() <= 0) {
                    break label6280;
                  }
                  paramString1 = str1 + ": ";
                  if ((!t.ot(paramString2)) && (j == 0)) {
                    paramPString2.value = str1;
                  }
                  if (str1.length() <= 0) {
                    break label6286;
                  }
                }
                for (paramString3 = "%s: ";; paramString3 = "")
                {
                  paramPString1.value = paramString3;
                  localObject2 = null;
                  i = 0;
                  paramString3 = (String)localObject3;
                  break;
                  i = ((j.b)localObject2).description.length();
                  break label6153;
                  paramString1 = "";
                  break label6218;
                }
              case 16: 
                localObject3 = "";
                paramString3 = paramContext.getString(2131298001);
                if (str1.length() > 0)
                {
                  paramString1 = str1 + ": " + paramString3 + ((j.b)localObject2).title;
                  if ((!t.ot(paramString2)) && (j == 0)) {
                    paramPString2.value = str1;
                  }
                  if (str1.length() <= 0) {
                    break label6429;
                  }
                }
                for (paramString3 = "%s: ".concat(String.valueOf(paramString3));; paramString3 = String.valueOf(paramString3))
                {
                  paramPString1.value = paramString3;
                  localObject2 = null;
                  i = 0;
                  paramString3 = (String)localObject3;
                  break;
                  paramString1 = paramString3 + ((j.b)localObject2).title;
                  break label6347;
                }
              case 34: 
                localObject3 = "";
                paramString1 = paramContext.getString(2131298001);
                if (paramInt1 == 1)
                {
                  paramString3 = paramString1 + ((j.b)localObject2).fhR;
                  if (str1.length() > 0) {}
                  for (paramString1 = "%s: ".concat(String.valueOf(paramString3));; paramString1 = String.valueOf(paramString3))
                  {
                    paramPString1.value = paramString1;
                    paramString1 = paramString3;
                    if (t.ot(paramString2)) {
                      break label7923;
                    }
                    paramString1 = paramString3;
                    if (j != 0) {
                      break label7923;
                    }
                    paramPString2.value = str1;
                    localObject2 = null;
                    i = 0;
                    paramString1 = paramString3;
                    paramString3 = (String)localObject3;
                    break;
                  }
                }
                paramString3 = paramString1 + ((j.b)localObject2).fhQ;
                if (str1.length() > 0) {}
                for (paramString1 = "%s: ".concat(String.valueOf(paramString3));; paramString1 = String.valueOf(paramString3))
                {
                  paramPString1.value = paramString1;
                  break;
                }
              case 40: 
                label4503:
                label4579:
                label4729:
                if (com.tencent.mm.af.o.nd(paramString1).fjG == 19)
                {
                  localObject3 = paramContext.getString(2131297055);
                  localObject2 = null;
                  i = 0;
                  paramString1 = paramString3;
                  paramString3 = (String)localObject3;
                  break;
                }
                label4628:
                label4683:
                label4834:
                label5099:
                label5494:
                localObject3 = paramContext.getString(2131296543);
                label4788:
                label4939:
                label5211:
                label6005:
                localObject2 = null;
                label4893:
                label5044:
                label5579:
                label6109:
                i = 0;
                label4998:
                label5145:
                label5293:
                label6218:
                label6347:
                paramString1 = paramString3;
                label5397:
                label5929:
                paramString3 = (String)localObject3;
                label6054:
                break;
                label6153:
                label6286:
                label6429:
                paramString1 = paramString3;
                label6280:
                if (k != 0) {
                  paramString1 = kL(paramString3);
                }
                paramString3 = ((com.tencent.mm.plugin.biz.a.a)g.E(com.tencent.mm.plugin.biz.a.a.class)).nc(paramString1);
                paramString1 = paramString3;
                if (k != 0) {
                  paramString1 = kK(paramString3);
                }
                paramPString1.value = paramString1;
                paramString3 = "";
                localObject2 = null;
                i = 0;
                break;
                paramPString1.value = ((com.tencent.mm.plugin.biz.a.a)g.E(com.tencent.mm.plugin.biz.a.a.class)).nb(paramString3);
                paramString3 = paramPString1.value;
                ab.i("MicroMsg.Notification.Wording", "[parseMsgContentToShow] type:%s suffix:%s", new Object[] { Integer.valueOf(318767153), paramString3 });
                localObject2 = null;
                i = 0;
                paramString1 = "";
                break;
                paramString1 = com.tencent.mm.ak.a.b(a.a.sz(paramString3));
                paramPString1.value = paramString1;
                paramString3 = "";
                localObject2 = null;
                i = 0;
                break;
                paramString3 = "";
                localObject2 = j.b.mY((String)localObject3);
                paramString1 = paramString3;
                if (localObject2 == null) {
                  break label742;
                }
                paramString1 = paramString3;
                try
                {
                  paramString3 = URLDecoder.decode(((j.b)localObject2).content, "UTF-8");
                  paramString1 = paramString3;
                  paramString3 = j.amy(paramString3);
                  paramString1 = paramString3;
                }
                catch (Exception paramString3)
                {
                  try
                  {
                    paramPString1.value = paramString1;
                    paramString3 = "";
                    localObject2 = null;
                    i = 0;
                  }
                  catch (Exception paramString3)
                  {
                    for (;;)
                    {
                      continue;
                      paramString2 = paramString1;
                    }
                  }
                  paramString3 = paramString3;
                }
              }
            }
            ab.printErrStackTrace("MicroMsg.Notification.Wording", paramString3, "", new Object[0]);
            paramString3 = "";
            Object localObject2 = null;
            i = 0;
            break label751;
            paramString1 = ((e)g.E(e.class)).SO(paramString3);
            if (paramString1 != null) {}
            for (paramString3 = paramString1.toString();; paramString3 = "")
            {
              paramString1 = paramString3;
              if (paramBoolean1)
              {
                paramString1 = paramString3;
                if (t.lA(paramString2))
                {
                  paramString1 = paramString3;
                  if (paramString3.endsWith(paramContext.getString(2131298132)))
                  {
                    ab.i("MicroMsg.Notification.Wording", "conv.getDigest() : %s", new Object[] { paramString3 });
                    paramString1 = paramString3.substring(0, paramString3.length() - paramContext.getString(2131298132).length());
                  }
                }
              }
              paramPString1.value = paramString1;
              paramString3 = "";
              localObject2 = null;
              i = 0;
              break;
            }
            paramString3 = com.tencent.mm.af.a.a.ne(paramString3).content;
            paramString1 = paramString3;
            if (bo.isNullOrNil(paramString3)) {
              paramString1 = "";
            }
            paramPString1.value = paramString1;
            paramString3 = "";
            localObject2 = null;
            i = 0;
            break label751;
            paramString1 = paramContext.getString(2131302009);
            paramPString1.value = paramString1;
            paramString3 = "";
            localObject2 = null;
            i = 0;
            break label751;
            label7087:
            paramString1 = paramString1.split("@bottle:");
            if (paramString1.length > 1)
            {
              paramPString1.value = paramString1[1];
              paramString1 = paramString1[1];
              AppMethodBeat.o(16043);
              return paramString1;
            }
            paramPString1.value = "";
            AppMethodBeat.o(16043);
            return null;
            label7136:
            paramString2 = null;
            paramPString2 = null;
            paramContext = paramString1.split(":");
            if ((paramContext == null) || (paramContext.length <= 0))
            {
              paramPString1.value = "";
              AppMethodBeat.o(16043);
              return null;
            }
            paramContext = paramContext[0];
            if (!bo.isNullOrNil(paramContext))
            {
              aw.aaz();
              paramPInt = c.YA().arw(paramContext);
              paramContext = paramPString2;
              if (paramPInt != null)
              {
                paramContext = paramPString2;
                if (paramPInt.getCity() != null) {
                  paramContext = paramPInt.getCity();
                }
              }
              if (paramContext != null)
              {
                paramString2 = paramContext;
                if (paramContext.length() > 0) {}
              }
              else
              {
                paramString2 = paramPInt.getProvince();
              }
            }
            if (!bo.isNullOrNil(paramString3))
            {
              paramPString1.value = (paramString2 + ": " + paramString3);
              paramString1 = paramString2 + ": " + paramString3;
              AppMethodBeat.o(16043);
              return paramString1;
            }
            paramString1 = paramString1.split("@bottle:");
            if (paramString1.length > 1)
            {
              paramPString1.value = (paramString2 + ": " + paramString1[1]);
              paramString1 = paramString2 + ": " + paramString1[1];
              AppMethodBeat.o(16043);
              return paramString1;
            }
            paramPString1.value = paramString2;
            AppMethodBeat.o(16043);
            return paramString2;
            label7418:
            if (bo.isNullOrNil(paramString1)) {
              paramPString1.value = "";
            }
            if (!bo.isNullOrNil(str1))
            {
              paramString2 = paramString1;
              if (str2 != null)
              {
                paramString2 = paramString1;
                if (str2.length() > 0) {
                  paramString2 = i(paramString1, str1, str2);
                }
              }
              if (bo.isNullOrNil(paramPString2.value))
              {
                paramPString1.value = i(paramPString1.value, str1, "%s");
                paramPString2.value = str1;
              }
              paramString1 = com.tencent.mm.compatible.util.o.lr(paramString2);
              paramPString1.value = com.tencent.mm.compatible.util.o.lr(paramPString1.value);
              paramString2 = paramString1 + paramString3;
              paramPString1.value += paramString3;
              if ((paramBoolean1) && (!a(paramInt2, paramPString1, paramString2))) {
                a(paramInt2, paramPString1, paramPString2, paramPInt);
              }
              paramString1 = paramString2;
              if (i != 0) {
                paramString1 = paramString2.concat(" " + bo.nullAsNil((String)localObject2));
              }
              paramString1 = bo.nullAsNil(paramString1);
              AppMethodBeat.o(16043);
              return paramString1;
            }
            if ((t.ot(paramString2)) || (j != 0) || (t.oC(paramString2)))
            {
              paramString2 = paramString1;
              if (paramString3 != null)
              {
                paramString2 = paramString1;
                if (paramString3.length() > 0) {
                  paramString2 = paramString3;
                }
              }
              if (bo.isNullOrNil(paramString2))
              {
                paramPString1.value = "";
                paramPString2.value = "";
                AppMethodBeat.o(16043);
                return "";
              }
              if (paramInt1 == 0)
              {
                paramPString1.value = "%s:".concat(String.valueOf(paramString2));
                if (!paramBoolean1) {
                  break label7833;
                }
                a(paramInt2, paramPString1, paramPString2, paramPInt);
                paramString1 = paramString2;
              }
            }
            for (;;)
            {
              paramString2 = paramString1;
              if (i != 0)
              {
                paramString2 = paramString1;
                if (localObject2 != null) {
                  paramString2 = paramString1.concat(" ".concat(String.valueOf(localObject2)));
                }
              }
              paramString1 = paramString2;
              if (k != 0) {
                paramString1 = kL(paramString2);
              }
              paramString1 = bo.nullAsNil(paramString1);
              AppMethodBeat.o(16043);
              return paramString1;
              paramPString1.value = (paramContext.getString(2131296992) + ":" + paramString2);
              break;
              label7833:
              paramString1 = s.nE(paramPString2.value) + ":" + paramString2;
              AppMethodBeat.o(16043);
              return paramString1;
              if ((paramString3 == null) || (paramString3.length() <= 0)) {
                break label7918;
              }
              paramPString1.value = paramString3;
              paramString2 = paramString3;
              paramString1 = paramString2;
              if (paramBoolean1)
              {
                a(paramInt2, paramPString1, paramPString2, paramPInt);
                paramString1 = paramString2;
              }
            }
            label7918:
            label7923:
            paramString3 = "";
            localObject2 = null;
            i = 0;
            break label751;
            paramString1 = paramString2;
            break label2300;
            paramString1 = paramString2;
          }
          label7945:
          j = i;
        }
        localObject3 = paramString3;
        str2 = "";
        str1 = "";
      }
    }
  }
  
  private static void a(int paramInt, PString paramPString1, PString paramPString2, PInt paramPInt)
  {
    AppMethodBeat.i(16051);
    if ((paramPString1.value.length() == 32) && ((paramInt == 47) || (paramInt == 1048625)))
    {
      AppMethodBeat.o(16051);
      return;
    }
    if (paramPString1.value.length() >= 150) {
      paramPString1.value = paramPString1.value.substring(0, C(paramPString1.value, 150));
    }
    TextPaint localTextPaint = getTextPaint();
    if ((paramPString1.value.replace("%%", "").contains("%s")) || (localTextPaint == null))
    {
      paramPInt.value = 0;
      AppMethodBeat.o(16051);
      return;
    }
    try
    {
      paramPString2 = String.format(paramPString1.value, new Object[] { paramPString2.value });
      paramPString1.value = a(paramPString2, localTextPaint).toString();
      paramPInt.value = 1;
      AppMethodBeat.o(16051);
      return;
    }
    catch (Exception paramPString2)
    {
      for (;;)
      {
        paramPString2 = paramPString1.value;
      }
    }
  }
  
  public static void a(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(16056);
    if ((ebR == null) || (ebR.get() == null)) {
      ebR = new WeakReference(paramTextPaint);
    }
    AppMethodBeat.o(16056);
  }
  
  private static boolean a(int paramInt, PString paramPString, String paramString)
  {
    AppMethodBeat.i(16048);
    if ((paramPString.value.length() == 32) && ((paramInt == 47) || (paramInt == 1048625)))
    {
      paramPString.value = paramString;
      AppMethodBeat.o(16048);
      return true;
    }
    AppMethodBeat.o(16048);
    return false;
  }
  
  public static String b(ad paramad)
  {
    AppMethodBeat.i(16040);
    Object localObject = ah.getContext();
    if (paramad == null)
    {
      paramad = ((Context)localObject).getString(2131297803);
      AppMethodBeat.o(16040);
      return paramad;
    }
    if (RegionCodeDecoder.asx(paramad.getCountryCode()))
    {
      localObject = paramad.getCity();
      if (!bo.isNullOrNil((String)localObject))
      {
        AppMethodBeat.o(16040);
        return localObject;
      }
      localObject = s.nG(paramad.getProvince());
      if (!bo.isNullOrNil((String)localObject))
      {
        AppMethodBeat.o(16040);
        return localObject;
      }
      RegionCodeDecoder.dyE();
      paramad = RegionCodeDecoder.getLocName(paramad.getCountryCode());
      AppMethodBeat.o(16040);
      return paramad;
    }
    paramad = s.nG(paramad.getProvince());
    if (!bo.isNullOrNil(paramad))
    {
      AppMethodBeat.o(16040);
      return paramad;
    }
    paramad = ((Context)localObject).getString(2131297803);
    AppMethodBeat.o(16040);
    return paramad;
  }
  
  public static String b(bi parambi, PString paramPString1, PString paramPString2, PInt paramPInt, boolean paramBoolean)
  {
    AppMethodBeat.i(16041);
    if (parambi.dxQ()) {}
    for (String str = parambi.dyr();; str = parambi.field_content)
    {
      str = j.amy(str);
      parambi = bo.nullAsNil(a(parambi.field_imgPath, parambi.field_isSend, parambi.field_talker, str, parambi.getType(), ah.getContext(), paramPString1, paramPString2, paramPInt, true, paramBoolean));
      AppMethodBeat.o(16041);
      return parambi;
    }
  }
  
  private static String bC(Context paramContext)
  {
    AppMethodBeat.i(16045);
    boolean bool = r.ZJ();
    aw.aaz();
    long l = bo.a((Long)c.Ru().get(65793, null), 0L);
    if (!bool)
    {
      paramContext = paramContext.getString(2131303374);
      AppMethodBeat.o(16045);
      return paramContext;
    }
    if (l == 0L)
    {
      paramContext = paramContext.getString(2131300087);
      AppMethodBeat.o(16045);
      return paramContext;
    }
    if (bo.gz(l) * 1000L > 1209600000L)
    {
      paramContext = paramContext.getString(2131300086, new Object[] { Long.valueOf(bo.gz(l) * 1000L / 86400000L) });
      AppMethodBeat.o(16045);
      return paramContext;
    }
    AppMethodBeat.o(16045);
    return "";
  }
  
  public static String d(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(16057);
    paramString = com.tencent.mm.cd.b.duW().aqC(paramString);
    if (paramBoolean)
    {
      AppMethodBeat.o(16057);
      return paramString;
    }
    paramContext = paramContext.getString(2131300746);
    AppMethodBeat.o(16057);
    return paramContext;
  }
  
  public static String e(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(16059);
    if (paramBoolean)
    {
      paramContext = com.tencent.mm.cd.b.duW().aqC(paramString);
      AppMethodBeat.o(16059);
      return paramContext;
    }
    paramContext = paramContext.getString(2131301956);
    AppMethodBeat.o(16059);
    return paramContext;
  }
  
  public static String g(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(16039);
    if (t.lA(paramString1))
    {
      paramString2 = bf.pu(paramString2);
      if (paramString2 != null) {
        paramString2 = s.nE(paramString2.trim());
      }
    }
    while (paramString1.contains("@bottle"))
    {
      paramContext = paramContext.getResources().getQuantityString(2131361813, 1, new Object[] { Integer.valueOf(1) });
      AppMethodBeat.o(16039);
      return paramContext;
      paramString2 = s.nE(paramString1);
      continue;
      paramString2 = s.nE(paramString1);
    }
    String str = paramString2;
    if (bo.isNullOrNil(paramString2))
    {
      str = paramString2;
      if (t.lA(paramString1)) {
        str = paramContext.getString(2131298302);
      }
    }
    paramContext = com.tencent.mm.cd.b.duW().aqC(str);
    AppMethodBeat.o(16039);
    return paramContext;
  }
  
  private static TextPaint getTextPaint()
  {
    AppMethodBeat.i(16055);
    if (ebR == null)
    {
      AppMethodBeat.o(16055);
      return null;
    }
    TextPaint localTextPaint = (TextPaint)ebR.get();
    AppMethodBeat.o(16055);
    return localTextPaint;
  }
  
  private static String i(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(16047);
    if ((bo.isNullOrNil(paramString1)) || (bo.isNullOrNil(paramString2)) || (bo.isNullOrNil(paramString3)))
    {
      AppMethodBeat.o(16047);
      return paramString1;
    }
    int i = paramString1.indexOf(paramString2);
    if (i < 0)
    {
      AppMethodBeat.o(16047);
      return paramString1;
    }
    paramString1 = paramString1.substring(0, i) + paramString3 + paramString1.substring(i + paramString2.length());
    AppMethodBeat.o(16047);
    return paramString1;
  }
  
  public static void is(int paramInt)
  {
    ebS = paramInt;
  }
  
  public static void it(int paramInt)
  {
    ebT = paramInt;
  }
  
  private static String kK(String paramString)
  {
    AppMethodBeat.i(16046);
    if (paramString != null)
    {
      paramString = paramString.replaceAll("%", "%%");
      AppMethodBeat.o(16046);
      return paramString;
    }
    AppMethodBeat.o(16046);
    return paramString;
  }
  
  private static String kL(String paramString)
  {
    AppMethodBeat.i(16049);
    if (paramString != null)
    {
      paramString = paramString.replaceAll("%%", "%");
      AppMethodBeat.o(16049);
      return paramString;
    }
    AppMethodBeat.o(16049);
    return paramString;
  }
  
  private static boolean kM(String paramString)
  {
    AppMethodBeat.i(153481);
    if ((t.nZ(paramString)) && (!r.ZG()))
    {
      AppMethodBeat.o(153481);
      return true;
    }
    if ((t.ob(paramString)) && (!r.Zz()))
    {
      AppMethodBeat.o(153481);
      return true;
    }
    if ((t.of(paramString)) && (!r.ZJ()))
    {
      AppMethodBeat.o(153481);
      return true;
    }
    AppMethodBeat.o(153481);
    return false;
  }
  
  public static String kN(String paramString)
  {
    AppMethodBeat.i(16050);
    if (paramString == null)
    {
      AppMethodBeat.o(16050);
      return "";
    }
    if (paramString.length() < 150)
    {
      AppMethodBeat.o(16050);
      return paramString;
    }
    paramString = paramString.substring(0, 150) + "...";
    AppMethodBeat.o(16050);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.booter.notification.a.h
 * JD-Core Version:    0.7.0.1
 */