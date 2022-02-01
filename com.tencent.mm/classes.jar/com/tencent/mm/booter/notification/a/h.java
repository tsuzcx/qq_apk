package com.tencent.mm.booter.notification.a;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ah.t;
import com.tencent.mm.al.a.d;
import com.tencent.mm.al.a.l;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.j;
import com.tencent.mm.am.a.a;
import com.tencent.mm.compatible.util.o;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.al;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.r;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.modelvideo.q;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.patmsg.PluginPatMsg;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.ary;
import com.tencent.mm.protocal.protobuf.arz;
import com.tencent.mm.protocal.protobuf.ciz;
import com.tencent.mm.protocal.protobuf.cja;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bv.a;
import com.tencent.mm.storage.bv.c;
import com.tencent.mm.storage.bv.d;
import com.tencent.mm.ui.chatting.viewitems.k.a;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.LinkedList;
import java.util.Locale;
import junit.framework.Assert;

public final class h
{
  private static WeakReference<TextPaint> fJJ;
  private static int fJK = 0;
  private static int fJL = 0;
  public String fJI = "";
  public String mDesc = "";
  public String mTitle = "";
  
  private static int F(String paramString, int paramInt)
  {
    AppMethodBeat.i(20088);
    while (paramInt < paramString.length())
    {
      if (paramString.charAt(paramInt) != '%')
      {
        AppMethodBeat.o(20088);
        return paramInt;
      }
      paramInt += 1;
    }
    paramInt = paramString.length();
    AppMethodBeat.o(20088);
    return paramInt;
  }
  
  private static int XK()
  {
    AppMethodBeat.i(169682);
    if (fJL > 0)
    {
      i = fJL;
      AppMethodBeat.o(169682);
      return i;
    }
    int i = BackwardSupportUtil.b.h(ak.getContext(), 14.0F);
    AppMethodBeat.o(169682);
    return i;
  }
  
  private static int XL()
  {
    AppMethodBeat.i(20087);
    if (fJK > 0)
    {
      i = fJK;
      AppMethodBeat.o(20087);
      return i;
    }
    int i = BackwardSupportUtil.b.h(ak.getContext(), 200.0F);
    AppMethodBeat.o(20087);
    return i;
  }
  
  private static CharSequence a(String paramString, TextPaint paramTextPaint)
  {
    AppMethodBeat.i(20086);
    paramString = TextUtils.ellipsize(com.tencent.mm.pluginsdk.ui.span.k.b(ak.getContext(), paramString, XK()), paramTextPaint, XL(), TextUtils.TruncateAt.END);
    AppMethodBeat.o(20086);
    return paramString;
  }
  
  public static String a(int paramInt1, String paramString1, String paramString2, int paramInt2, Context paramContext)
  {
    AppMethodBeat.i(20075);
    paramString1 = bu.nullAsNil(a(null, paramInt1, paramString1, paramString2, paramInt2, paramContext, new PString(), new PString(), new PInt(), false, false, "", 0));
    AppMethodBeat.o(20075);
    return paramString1;
  }
  
  private static String a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, PString paramPString1, PString paramPString2)
  {
    int j = 2131759556;
    AppMethodBeat.i(20077);
    String str3 = "";
    String str2;
    String str1;
    int i;
    if ((x.At(paramString1)) || (x.Av(paramString1)))
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
            if (!an.aUn(paramString1))
            {
              str2 = str3;
              str1 = paramString2;
              if (!an.aUp(paramString1)) {}
            }
            else
            {
              str2 = w.zP(paramString1);
              paramPString2.value = paramString1;
              str1 = paramString2.substring(i + 1);
            }
          }
        }
      }
      if (bu.nullAsNil(str2).length() > 0) {
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
      AppMethodBeat.o(20077);
      return paramContext;
      if (!an.aUn(paramString1))
      {
        str2 = str3;
        str1 = paramString2;
        if (!an.aUp(paramString1)) {
          break;
        }
      }
      w.zP(paramString1);
      paramPString2.value = paramString1;
      if (paramInt == 1)
      {
        paramContext = new StringBuilder().append(paramContext.getString(2131759556, new Object[] { "" }));
        if (paramString3 == null) {}
        for (;;)
        {
          paramPString1.value = paramString2;
          paramPString2.value = "";
          paramContext = paramPString1.value;
          AppMethodBeat.o(20077);
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
        AppMethodBeat.o(20077);
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
      i = 2131759556;
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
      AppMethodBeat.o(20077);
      return paramContext;
      i = 2131759566;
      break;
      label430:
      paramString1 = paramString3;
      break label352;
      label436:
      paramInt = 2131759566;
      break label381;
      label442:
      str1 = paramString3;
    }
  }
  
  public static String a(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(20092);
    if (paramBoolean)
    {
      String str = com.tencent.mm.ce.b.fqL().aTh(paramString);
      paramString = str;
      if (paramInt3 > 1) {
        paramString = paramContext.getResources().getQuantityString(2131623960, paramInt3, new Object[] { Integer.valueOf(paramInt3) }) + str;
      }
      AppMethodBeat.o(20092);
      return paramString;
    }
    paramContext = paramContext.getResources().getQuantityString(2131623961, paramInt1, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(20092);
    return paramContext;
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(20071);
    paramContext = a(0, paramString2, paramString1, paramInt, paramContext);
    paramContext = com.tencent.mm.pluginsdk.ui.span.k.aOF(com.tencent.mm.ce.b.fqL().aTh(paramContext));
    AppMethodBeat.o(20071);
    return paramContext;
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2, int paramInt, bv parambv)
  {
    AppMethodBeat.i(20073);
    if (TextUtils.isEmpty(paramString2)) {
      parambv = null;
    }
    for (;;)
    {
      paramString1 = parambv;
      if (bu.isNullOrNil(parambv))
      {
        if (!com.tencent.mm.n.f.wb(paramString2)) {
          break;
        }
        paramString1 = paramContext.getString(2131757293);
      }
      paramContext = com.tencent.mm.ce.b.fqL().aTh(paramString1);
      AppMethodBeat.o(20073);
      return paramContext;
      for (;;)
      {
        for (;;)
        {
          try
          {
            if (!b(paramString2, parambv)) {
              continue;
            }
            if (parambv == null) {
              continue;
            }
            localObject1 = ag.aGr().bd(parambv.field_bizChatId);
            if (((com.tencent.mm.al.a.c)localObject1).isGroup()) {
              if (bu.isNullOrNil(((com.tencent.mm.al.a.c)localObject1).field_chatName)) {
                localObject1 = ak.getContext().getString(2131762623);
              }
            }
          }
          catch (Throwable parambv)
          {
            boolean bool;
            an localan;
            Object localObject2;
            Object localObject1 = null;
            continue;
            localObject1 = null;
            continue;
            localObject1 = null;
            continue;
          }
          try
          {
            bool = TextUtils.isEmpty((CharSequence)localObject1);
            parambv = (bv)localObject1;
            if (!bool) {
              break;
            }
          }
          catch (Throwable parambv) {}
        }
        bc.aCg();
        localan = com.tencent.mm.model.c.azF().BH(paramString2);
        if (localan != null) {
          continue;
        }
        parambv = null;
        break;
        localObject1 = ((com.tencent.mm.al.a.c)localObject1).field_chatName;
        continue;
        parambv = ag.aGt().eP(parambv.field_bizChatUserId);
        if (parambv == null) {
          continue;
        }
        localObject1 = parambv.field_userName;
      }
      localObject2 = localObject1;
      if (paramInt == 318767153)
      {
        localObject2 = localObject1;
        if (!TextUtils.isEmpty(paramString1))
        {
          localObject2 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).aC(paramString1, paramString2);
          parambv = (bv)localObject2;
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            continue;
          }
        }
      }
      if (x.AU(paramString2))
      {
        parambv = localan.adF();
      }
      else
      {
        if (an.Ac(paramString2))
        {
          localObject1 = ak.getContext();
          if (localan != null) {
            if (RegionCodeDecoder.aVQ(localan.getCountryCode()))
            {
              paramString1 = localan.getCity();
              if (bu.isNullOrNil(paramString1)) {}
            }
          }
          for (;;)
          {
            parambv = paramContext.getString(2131756698, new Object[] { paramString1 }).trim();
            break;
            parambv = w.zR(localan.getProvince());
            paramString1 = parambv;
            if (bu.isNullOrNil(parambv))
            {
              RegionCodeDecoder.fwA();
              paramString1 = RegionCodeDecoder.getLocName(localan.getCountryCode());
              continue;
              parambv = w.zR(localan.getProvince());
              paramString1 = parambv;
              if (bu.isNullOrNil(parambv)) {
                paramString1 = ((Context)localObject1).getString(2131756727);
              }
            }
          }
        }
        if ((com.tencent.mm.n.f.wb(paramString2)) && (bu.isNullOrNil(localan.field_nickname)) && (bu.isNullOrNil(localan.field_conRemark)))
        {
          bc.aCg();
          paramString1 = com.tencent.mm.model.c.azP().zP(paramString2);
          parambv = (bv)localObject2;
          if (!bu.isNullOrNil(paramString1)) {
            parambv = paramString1;
          }
        }
        else
        {
          parambv = (bv)localObject2;
          if (localan.adG() != null)
          {
            parambv = (bv)localObject2;
            if (localan.adG().length() > 0) {
              parambv = localan.adG();
            }
          }
        }
      }
    }
    paramContext = paramContext.getString(2131760347);
    AppMethodBeat.o(20073);
    return paramContext;
  }
  
  private static String a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, Context paramContext, PString paramPString1, PString paramPString2, PInt paramPInt, boolean paramBoolean1, boolean paramBoolean2, String paramString4, int paramInt3)
  {
    AppMethodBeat.i(186342);
    if (paramContext != null)
    {
      bool = true;
      Assert.assertTrue("context is null", bool);
      if ((paramString2 == null) || (paramString2.length() <= 0)) {
        break label79;
      }
    }
    label79:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("username is null", bool);
      if ((paramBoolean1) || (!uS(paramString2))) {
        break label85;
      }
      paramString1 = paramContext.getString(2131763356);
      AppMethodBeat.o(186342);
      return paramString1;
      bool = false;
      break;
    }
    label85:
    if (x.Az(paramString2))
    {
      if (paramBoolean1)
      {
        AppMethodBeat.o(186342);
        return "";
      }
      paramString1 = bU(paramContext);
      AppMethodBeat.o(186342);
      return paramString1;
    }
    if ((paramString3 != null) && (paramBoolean1)) {
      paramString3 = uQ(paramString3);
    }
    for (int k = 1;; k = 0)
    {
      paramPString1.value = paramString3;
      int i;
      String str1;
      String str2;
      Object localObject3;
      if ((paramInt1 == 0) && ((x.wb(paramString2)) || (x.zV(paramString2))))
      {
        i = bl.BJ(paramString3);
        if (i > 0)
        {
          str1 = paramString3.substring(0, i).trim();
          str2 = w.getDisplayName(str1, paramString2);
          localObject3 = (paramString3 + " ").substring(i + 1);
        }
      }
      for (;;)
      {
        int j = 0;
        Object localObject1;
        if ((x.AN(paramString2)) || (x.AW(paramString2)))
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
        label3073:
        label9476:
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
          case 486539313: 
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
            label842:
            label851:
            label1384:
            do
            {
              paramString3 = "";
              localObject1 = null;
              i = 0;
              for (;;)
              {
                if (!x.Au(paramString2)) {
                  break label8866;
                }
                if (1 != paramInt1) {
                  break label8584;
                }
                if (bu.isNullOrNil(paramString3)) {
                  break label8535;
                }
                paramPString1.value = paramString3;
                AppMethodBeat.o(186342);
                return paramString3;
                i = j;
                if (x.AY(paramString2)) {
                  break label9530;
                }
                bc.aCg();
                localObject1 = com.tencent.mm.model.c.azL().aVa(paramString2);
                if ((localObject1 == null) || (!((au)localObject1).lS(2097152)))
                {
                  i = j;
                  if (!paramBoolean2) {
                    break label9530;
                  }
                }
                j = 1;
                i = j;
                if (paramString3 == null) {
                  break label9530;
                }
                int m = paramString3.indexOf(":");
                i = j;
                if (m == -1) {
                  break label9530;
                }
                paramPString2.value = paramString3.substring(0, m);
                paramString3 = paramString3.substring(m + 1);
                j = 1;
                break;
                localObject3 = paramContext.getString(2131755853);
                if (str1.length() > 0)
                {
                  paramString1 = str1 + ": ";
                  if (str1.length() <= 0) {
                    break label1067;
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
                  break label1031;
                }
                localObject3 = az.aVt(paramString3);
                localObject1 = ((az)localObject3).aNq() + ": ";
                if ((paramString1 != null) && (paramString1.length() == 32)) {}
                for (paramString3 = paramString1;; paramString3 = paramContext.getString(2131755722))
                {
                  paramPString1.value = "";
                  paramPString2.value = ((az)localObject3).aNq();
                  localObject3 = null;
                  i = 0;
                  paramString1 = (String)localObject1;
                  localObject1 = localObject3;
                  break;
                }
                paramString1 = a(paramContext, paramInt1, paramString2, paramString3, paramContext.getString(2131755853), paramPString1, paramPString2);
                paramString3 = "";
                localObject1 = null;
                i = 0;
                continue;
                paramString1 = a(paramContext, paramInt1, paramString2, paramString3, null, paramPString1, paramPString2);
                paramString3 = "";
                localObject1 = null;
                i = 0;
                continue;
                if ((an.aUn(paramString2)) || (an.aUp(paramString2)) || (x.At(paramString2)) || (x.Av(paramString2)))
                {
                  paramString1 = a(paramContext, paramInt1, paramString2, paramString3, paramContext.getString(2131755929), paramPString1, paramPString2);
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
                      if (!x.Au(paramString2))
                      {
                        if (!x.wb(paramString2)) {
                          break label1384;
                        }
                        paramString3 = new p(paramString3);
                        paramString1 = paramString3.aNq() + ": ";
                        paramPString1.value = "%s:";
                        paramPString2.value = paramString3.aNq();
                      }
                    }
                  }
                  for (;;)
                  {
                    paramString3 = paramContext.getString(2131755929);
                    localObject1 = null;
                    i = 0;
                    break;
                    paramString1 = "";
                  }
                  if ((an.aUn(paramString2)) || (an.aUp(paramString2)) || (x.At(paramString2)) || (x.Av(paramString2)))
                  {
                    paramString1 = a(paramContext, paramInt1, paramString2, paramString3, paramContext.getString(2131755926), paramPString1, paramPString2);
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
                        if (!x.Au(paramString2))
                        {
                          if (!x.wb(paramString2)) {
                            break label1550;
                          }
                          paramString3 = new q(paramString3);
                          paramString1 = paramString3.aNq() + ": ";
                          paramPString1.value = "%s:";
                          paramPString2.value = paramString3.aNq();
                        }
                      }
                    }
                    for (;;)
                    {
                      paramString3 = paramContext.getString(2131755926);
                      localObject1 = null;
                      i = 0;
                      break;
                      paramString1 = "";
                    }
                    paramString3 = paramContext.getString(2131755932);
                    localObject1 = null;
                    i = 0;
                    paramString1 = "";
                    continue;
                    paramString3 = paramContext.getString(2131755931);
                    localObject1 = null;
                    i = 0;
                    paramString1 = "";
                    continue;
                    if (paramString3.equals(bv.JgL))
                    {
                      paramString3 = paramContext.getString(2131755932);
                      localObject1 = null;
                      i = 0;
                      paramString1 = "";
                    }
                    else
                    {
                      paramString1 = paramString3;
                      if (!paramString3.equals(bv.JgK)) {
                        break label842;
                      }
                      paramString3 = paramContext.getString(2131755934);
                      localObject1 = null;
                      i = 0;
                      paramString1 = "";
                      continue;
                      paramString3 = paramContext.getString(2131755932);
                      localObject1 = null;
                      i = 0;
                      paramString1 = "";
                      continue;
                      paramString3 = paramContext.getString(2131755934);
                      localObject1 = null;
                      i = 0;
                      paramString1 = "";
                      continue;
                      paramString1 = paramString3;
                      if (paramString3 == null) {
                        break label842;
                      }
                      paramString1 = paramString3;
                      if (paramString3.length() <= 0) {
                        break label842;
                      }
                      localObject1 = bv.d.aVF(paramString3);
                      paramString1 = paramString3;
                      if (((bv.d)localObject1).fws() != null)
                      {
                        paramString1 = paramString3;
                        if (((bv.d)localObject1).fws().length() <= 0) {}
                      }
                      switch (((bv.d)localObject1).getScene())
                      {
                      case 19: 
                      case 20: 
                      case 21: 
                      default: 
                        paramString1 = paramContext.getString(2131759578, new Object[] { ((bv.d)localObject1).getDisplayName() });
                        paramPString1.value = paramString1;
                        paramString3 = "";
                        localObject1 = null;
                        i = 0;
                        break;
                      case 18: 
                        paramString1 = paramContext.getString(2131759559, new Object[] { ((bv.d)localObject1).getDisplayName() });
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
                        paramString1 = paramContext.getString(2131759569, new Object[] { ((bv.d)localObject1).getDisplayName() });
                        paramString3 = "";
                        localObject1 = null;
                        i = 0;
                        break;
                      case 25: 
                        paramString1 = paramContext.getString(2131759491, new Object[] { ((bv.d)localObject1).getDisplayName() });
                        paramPString1.value = paramString1;
                        paramString3 = "";
                        localObject1 = null;
                        i = 0;
                        continue;
                        paramString1 = paramString3;
                        if (paramString3 == null) {
                          break label842;
                        }
                        paramString1 = paramString3;
                        if (paramString3.length() <= 0) {
                          break label842;
                        }
                        localObject1 = bv.a.aVC(paramString3);
                        paramString1 = paramString3;
                        if (((bv.a)localObject1).fws() != null)
                        {
                          paramString1 = paramString3;
                          if (((bv.a)localObject1).fws().length() > 0)
                          {
                            paramString1 = paramContext.getString(2131759516, new Object[] { ((bv.a)localObject1).getDisplayName() });
                            paramPString1.value = paramString1;
                          }
                        }
                        paramString3 = "";
                        localObject1 = null;
                        i = 0;
                        continue;
                        paramString1 = paramString3;
                        if (bu.nullAsNil(paramString3).length() <= 0) {
                          break label842;
                        }
                        bc.aCg();
                        paramString1 = com.tencent.mm.model.c.azI().arn(paramString3);
                        paramString1 = paramContext.getString(2131759552, new Object[] { paramString1.getSender(), paramString1.getTitle() });
                        paramPString1.value = paramString1;
                        paramString3 = "";
                        localObject1 = null;
                        i = 0;
                        continue;
                        paramString1 = paramString3;
                        if (bu.nullAsNil(paramString3).length() <= 0) {
                          break label842;
                        }
                        if (x.wb(paramString2))
                        {
                          localObject1 = bl.BM(paramString3);
                          paramString1 = (String)localObject1;
                          if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
                        }
                        else
                        {
                          paramString1 = paramString2;
                        }
                        bc.aCg();
                        localObject3 = com.tencent.mm.model.c.azI().arp(paramString3);
                        bc.aCg();
                        localObject1 = com.tencent.mm.model.c.azF().BH(paramString1).adG();
                        paramString3 = (String)localObject1;
                        if (x.wb((String)localObject1)) {
                          paramString3 = r.ae(r.zD((String)localObject1));
                        }
                        if (paramInt1 == 1)
                        {
                          localObject1 = paramContext.getString(2131759492, new Object[] { paramString3, ((bv.a)localObject3).getDisplayName() });
                          paramPString1.value = paramContext.getString(2131759492, new Object[] { "%s", ((bv.a)localObject3).getDisplayName() });
                          paramPString2.value = paramString1;
                          paramString3 = "";
                          localObject3 = null;
                          i = 0;
                          paramString1 = (String)localObject1;
                          localObject1 = localObject3;
                        }
                        else
                        {
                          localObject1 = paramContext.getString(2131759493, new Object[] { paramString3, ((bv.a)localObject3).getDisplayName() });
                          paramPString1.value = paramContext.getString(2131759493, new Object[] { "%s", ((bv.a)localObject3).getDisplayName() });
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
            } while (bu.nullAsNil(paramString3).length() <= 0);
            label1031:
            label1067:
            if (x.wb(paramString2))
            {
              i = bl.BJ(paramString3);
              if (i != -1)
              {
                paramString1 = paramString3.substring(0, i).trim();
                label2416:
                bl.BN(paramString3);
              }
            }
            label1550:
            break;
          }
          label6407:
          label7305:
          for (;;)
          {
            if (paramInt1 == 1)
            {
              paramString1 = paramContext.getString(2131760712);
              paramPString1.value = paramString1;
              paramString3 = "";
              localObject1 = null;
              i = 0;
              break label851;
            }
            localObject1 = paramContext.getString(2131760712);
            paramPString1.value = paramContext.getString(2131760712);
            paramPString2.value = paramString1;
            paramString3 = "";
            localObject3 = null;
            i = 0;
            paramString1 = (String)localObject1;
            localObject1 = localObject3;
            break label851;
            paramString1 = k.b.zb(bu.aSA((String)localObject3));
            if (paramString1.hDb != 0) {
              if (paramString1.hDb == 1) {
                paramString1 = paramContext.getString(2131762868);
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
              if (paramString1.hDb == 2) {
                paramString1 = paramContext.getString(2131762870);
              } else if (paramString1.hDb == 3) {
                paramString1 = paramContext.getString(2131762869);
              } else {
                paramString1 = paramContext.getString(2131762871);
              }
            }
            localObject1 = bu.aSA((String)localObject3);
            paramString3 = "";
            paramString1 = "";
            localObject1 = k.b.zb((String)localObject1);
            if (localObject1 != null)
            {
              paramPString1.value = (paramContext.getString(2131762886) + bu.nullAsNil(((k.b)localObject1).title));
              paramString1 = paramPString1.value;
            }
            paramPString2.value = str1;
            localObject1 = null;
            i = 0;
            break label851;
            localObject1 = bu.aSA((String)localObject3);
            paramString3 = "";
            paramString1 = "";
            localObject1 = k.b.zb((String)localObject1);
            if (localObject1 != null)
            {
              if (paramInt1 != 1) {
                break label2815;
              }
              i = 1;
              label2731:
              switch (((k.b)localObject1).hDI)
              {
              default: 
                paramPString1.value = bu.nullAsNil(((k.b)localObject1).title);
              }
            }
            for (;;)
            {
              paramString1 = paramPString1.value;
              paramPString2.value = str1;
              localObject1 = null;
              i = 0;
              break;
              label2815:
              i = 0;
              break label2731;
              if (i != 0)
              {
                paramPString1.value = paramContext.getString(2131756072);
              }
              else
              {
                paramPString1.value = paramContext.getString(2131756075);
                continue;
                if (i != 0)
                {
                  paramPString1.value = paramContext.getString(2131756073);
                }
                else
                {
                  paramPString1.value = paramContext.getString(2131756070);
                  continue;
                  if (i != 0)
                  {
                    paramPString1.value = paramContext.getString(2131756074);
                  }
                  else
                  {
                    paramPString1.value = paramContext.getString(2131756071);
                    continue;
                    if (i != 0)
                    {
                      paramPString1.value = paramContext.getString(2131759746);
                    }
                    else
                    {
                      paramPString1.value = paramContext.getString(2131756070);
                      continue;
                      if (i != 0)
                      {
                        paramPString1.value = paramContext.getString(2131759745);
                      }
                      else
                      {
                        paramPString1.value = paramContext.getString(2131759745);
                        continue;
                        if (i != 0) {
                          paramPString1.value = paramContext.getString(2131759783);
                        } else {
                          paramPString1.value = paramContext.getString(2131759783);
                        }
                      }
                    }
                  }
                }
              }
            }
            paramString1 = bu.aSA((String)localObject3);
            localObject3 = "";
            paramString3 = "";
            paramString1 = k.b.zb(paramString1);
            if (paramString1 != null)
            {
              if (paramInt1 != 1) {
                break label3159;
              }
              i = 1;
              if (i == 0) {
                break label3165;
              }
              paramPString1.value = ("[" + paramString1.hEi + "]" + paramString1.hEf);
            }
            for (;;)
            {
              paramString3 = paramPString1.value;
              paramString1 = paramString3;
              if (x.AN(paramString2)) {
                break label9476;
              }
              paramString1 = paramString3;
              if (j != 0) {
                break label9476;
              }
              paramPString2.value = str1;
              localObject1 = null;
              i = 0;
              paramString1 = paramString3;
              paramString3 = (String)localObject3;
              break;
              label3159:
              i = 0;
              break label3073;
              label3165:
              if (!bu.isNullOrNil(str2)) {
                paramPString1.value = (bu.nullAsNil(str2) + ": [" + paramString1.hEi + "]" + paramString1.hEe);
              } else {
                paramPString1.value = ("[" + paramString1.hEi + "]" + paramString1.hEe);
              }
            }
            localObject1 = bu.aSA((String)localObject3);
            paramString3 = "";
            paramString1 = "";
            localObject1 = k.b.zb((String)localObject1);
            label3311:
            label3828:
            String str3;
            if (localObject1 != null)
            {
              paramString1 = (com.tencent.mm.ah.b)((k.b)localObject1).ao(com.tencent.mm.ah.b.class);
              if (paramInt1 == 1)
              {
                i = 1;
                if (i == 0) {
                  break label3368;
                }
              }
              label3368:
              for (paramPString1.value = paramContext.getString(2131760296, new Object[] { paramString1.hBA });; paramPString1.value = paramContext.getString(2131760296, new Object[] { paramString1.hBB }))
              {
                paramString1 = paramPString1.value;
                paramPString2.value = str1;
                localObject1 = null;
                i = 0;
                break;
                i = 0;
                break label3311;
              }
              paramString3 = bu.aSA((String)localObject3);
              paramString1 = "";
              paramString3 = k.b.zb(paramString3);
              if (paramString3 != null)
              {
                paramString1 = (k.a)paramString3.ao(k.a.class);
                if (paramString1.state != 1) {
                  break label3470;
                }
              }
              label3470:
              for (paramString1 = paramContext.getString(2131758136, new Object[] { paramString1.appName });; paramString1 = paramContext.getString(2131758154, new Object[] { paramString1.appName }))
              {
                paramPString1.value = paramString1;
                paramString3 = "";
                localObject1 = null;
                i = 0;
                break;
              }
              switch (k.b.zb(bu.aSA((String)localObject3)).hDb)
              {
              default: 
                paramString1 = paramContext.getString(2131755858);
                label3541:
                if (str1.length() <= 0) {
                  break;
                }
              }
              for (paramString3 = str1 + ": ";; paramString3 = "")
              {
                if ((!x.AN(paramString2)) && (j == 0)) {
                  paramPString2.value = str1;
                }
                paramPString1.value = "";
                localObject3 = paramString1;
                localObject1 = null;
                i = 0;
                paramString1 = paramString3;
                paramString3 = (String)localObject3;
                break;
                paramString1 = paramContext.getString(2131755859);
                break label3541;
                paramString1 = paramContext.getString(2131755861);
                break label3541;
              }
              paramString3 = k.b.zb(bu.aSA((String)localObject3));
              if (paramString3 == null)
              {
                ae.e("MicroMsg.Notification.Wording", "decode msg content failed");
                AppMethodBeat.o(186342);
                return "";
              }
              localObject3 = "";
              localObject1 = paramContext.getString(2131756943);
              if (str1.length() > 0)
              {
                paramString1 = str1 + ": " + (String)localObject1 + paramString3.title;
                label3731:
                if ((!x.AN(paramString2)) && (j == 0)) {
                  paramPString2.value = str1;
                }
                if (str1.length() <= 0) {
                  break label3828;
                }
              }
              for (paramString3 = "%s: " + (String)localObject1 + paramString3.title;; paramString3 = (String)localObject1 + paramString3.title)
              {
                paramPString1.value = paramString3;
                localObject1 = null;
                i = 0;
                paramString3 = (String)localObject3;
                break;
                paramString1 = (String)localObject1 + paramString3.title;
                break label3731;
              }
              paramString1 = k.b.zb(bu.aSA((String)localObject3));
              if (paramString1 == null)
              {
                ae.e("MicroMsg.Notification.Wording", "decode msg content failed");
                AppMethodBeat.o(186342);
                return "";
              }
              localObject3 = "";
              paramString3 = paramContext.getString(2131756943);
              if (paramInt1 == 1)
              {
                paramString3 = paramString3 + paramString1.hDW;
                if (str1.length() > 0) {}
                for (paramString1 = "%s: ".concat(String.valueOf(paramString3));; paramString1 = String.valueOf(paramString3))
                {
                  paramPString1.value = paramString1;
                  paramString1 = paramString3;
                  if (x.AN(paramString2)) {
                    break label9476;
                  }
                  paramString1 = paramString3;
                  if (j != 0) {
                    break label9476;
                  }
                  paramPString2.value = str1;
                  localObject1 = null;
                  i = 0;
                  paramString1 = paramString3;
                  paramString3 = (String)localObject3;
                  break;
                }
              }
              paramString3 = paramString3 + paramString1.hDV;
              if (str1.length() > 0) {}
              for (paramString1 = "%s: ".concat(String.valueOf(paramString3));; paramString1 = String.valueOf(paramString3))
              {
                paramPString1.value = paramString1;
                break;
              }
              paramString3 = k.b.zb(bu.aSA((String)localObject3));
              if (paramString3 == null)
              {
                ae.e("MicroMsg.Notification.Wording", "decode msg content failed");
                AppMethodBeat.o(186342);
                return "";
              }
              localObject3 = "";
              if (str1.length() > 0)
              {
                paramString1 = str1 + ": " + paramString3.title;
                label4125:
                if ((!x.AN(paramString2)) && (j == 0)) {
                  paramPString2.value = str1;
                }
                if (str1.length() <= 0) {
                  break label4199;
                }
              }
              label4199:
              for (paramString3 = "%s: " + paramString3.title;; paramString3 = paramString3.title)
              {
                paramPString1.value = paramString3;
                localObject1 = null;
                i = 0;
                paramString3 = (String)localObject3;
                break;
                paramString1 = paramString3.title;
                break label4125;
              }
              localObject3 = paramContext.getString(2131755278);
              if (str1.length() > 0)
              {
                paramString1 = str1 + ": ";
                label4247:
                if ((!x.AN(paramString2)) && (j == 0)) {
                  paramPString2.value = str1;
                }
                if (str1.length() <= 0) {
                  break label4302;
                }
              }
              label4302:
              for (paramString3 = "%s: ";; paramString3 = "")
              {
                paramPString1.value = paramString3;
                localObject1 = null;
                i = 0;
                paramString3 = (String)localObject3;
                break;
                paramString1 = "";
                break label4247;
              }
              paramString1 = k.b.zb(bu.aSA((String)localObject3));
              if (paramString1 == null)
              {
                ae.e("MicroMsg.Notification.Wording", "decode msg content failed");
                AppMethodBeat.o(186342);
                return "";
              }
              localObject3 = "";
              try
              {
                paramString1 = URLDecoder.decode(paramString1.content, "UTF-8");
                paramString3 = paramString1;
                paramString1 = com.tencent.mm.pluginsdk.ui.span.k.aOF(paramString1);
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  paramString1 = paramString3;
                  ae.printErrStackTrace("MicroMsg.Notification.Wording", localException, "", new Object[0]);
                  continue;
                  paramString3 = paramString1;
                }
              }
              if ((!x.AN(paramString2)) && (j == 0)) {
                paramPString2.value = str1;
              }
              if (str1.length() > 0)
              {
                paramString3 = "%s: ".concat(String.valueOf(paramString1));
                paramPString1.value = paramString3;
                localObject1 = null;
                i = 0;
                paramString3 = (String)localObject3;
                break label851;
              }
              str3 = "";
              paramString3 = k.b.zb(bu.aSA((String)localObject3));
              if (paramString3 == null)
              {
                ae.e("MicroMsg.Notification.Wording", "decode msg content failed");
                AppMethodBeat.o(186342);
                return "";
              }
              if ((!x.AN(paramString2)) && (j == 0)) {
                paramPString2.value = str1;
              }
              paramString1 = paramContext.getString(2131755775);
              paramString3 = (com.tencent.mm.plugin.i.a.b)paramString3.ao(com.tencent.mm.plugin.i.a.b.class);
              if ((paramString3 == null) || (bu.isNullOrNil(paramString3.cRE().nickname))) {
                break label9517;
              }
              paramString1 = paramString1 + paramContext.getString(2131759222, new Object[] { paramString3.cRE().nickname });
            }
            label4759:
            label5925:
            label9387:
            label9517:
            for (;;)
            {
              if (str1.length() > 0) {}
              Object localObject2;
              for (paramString3 = "%s: ".concat(String.valueOf(paramString1));; paramString3 = paramString1)
              {
                paramPString1.value = paramString3;
                localObject2 = null;
                i = 0;
                paramString3 = str3;
                break;
              }
              str3 = "";
              paramString3 = k.b.zb(bu.aSA((String)localObject3));
              if (paramString3 == null)
              {
                ae.e("MicroMsg.Notification.Wording", "decode msg content failed");
                AppMethodBeat.o(186342);
                return "";
              }
              if ((!x.AN(paramString2)) && (j == 0)) {
                paramPString2.value = str1;
              }
              paramString1 = paramContext.getString(2131755775);
              paramString3 = (com.tencent.mm.plugin.i.a.c)paramString3.ao(com.tencent.mm.plugin.i.a.c.class);
              if ((paramString3 != null) && (!bu.isNullOrNil(paramString3.cRF().dBe))) {
                if (paramString3.cRF().sXu == 1) {
                  paramString1 = paramString1 + ak.getContext().getString(2131759380, new Object[] { paramString3.cRF().dBe });
                }
              }
              for (;;)
              {
                if (str1.length() > 0) {}
                for (paramString3 = "%s: ".concat(String.valueOf(paramString1));; paramString3 = paramString1)
                {
                  paramPString1.value = paramString3;
                  localObject2 = null;
                  i = 0;
                  paramString3 = str3;
                  break;
                  paramString1 = paramString1 + paramString3.cRF().dBe;
                  break label4759;
                }
                str3 = "";
                paramString1 = k.b.zb(bu.aSA((String)localObject3));
                if (paramString1 == null)
                {
                  ae.e("MicroMsg.Notification.Wording", "decode msg content failed");
                  AppMethodBeat.o(186342);
                  return "";
                }
                paramString1 = (com.tencent.mm.plugin.i.a.a)paramString1.ao(com.tencent.mm.plugin.i.a.a.class);
                if ((paramString1 != null) && (!bu.isNullOrNil(paramString1.VK()))) {
                  if (paramInt1 == 1) {
                    paramString1 = paramContext.getString(2131759264, new Object[] { paramString1.VK() });
                  }
                }
                for (;;)
                {
                  label4914:
                  if (str1.length() > 0) {}
                  for (paramString3 = "%s: ".concat(String.valueOf(paramString1));; paramString3 = paramString1)
                  {
                    paramPString1.value = paramString3;
                    localObject2 = null;
                    i = 0;
                    paramString3 = str3;
                    break;
                    paramString3 = paramContext.getString(2131759265, new Object[] { paramString1.VK() });
                    paramString1 = paramString3;
                    if (x.AN(paramString2)) {
                      break label4914;
                    }
                    paramString1 = paramString3;
                    if (j != 0) {
                      break label4914;
                    }
                    paramPString2.value = str1;
                    paramString1 = paramString3;
                    break label4914;
                  }
                  paramString1 = paramContext.getString(2131755776) + paramContext.getString(2131759194);
                  paramPString1.value = paramString1;
                  paramString3 = "";
                  localObject2 = null;
                  i = 0;
                  break label851;
                  str3 = "";
                  paramString1 = k.b.zb(bu.aSA((String)localObject3));
                  if (paramString1 == null)
                  {
                    ae.e("MicroMsg.Notification.Wording", "decode msg content failed");
                    AppMethodBeat.o(186342);
                    return "";
                  }
                  paramString1 = (com.tencent.mm.plugin.game.luggage.e.a)paramString1.ao(com.tencent.mm.plugin.game.luggage.e.a.class);
                  if ((paramString1 != null) && (!bu.isNullOrNil(paramString1.bVF))) {
                    if (paramInt1 == 1) {
                      paramString1 = paramContext.getString(2131767063, new Object[] { paramString1.bVF });
                    }
                  }
                  for (;;)
                  {
                    for (;;)
                    {
                      if (str1.length() > 0) {}
                      for (paramString3 = "%s: ".concat(String.valueOf(paramString1));; paramString3 = paramString1)
                      {
                        paramPString1.value = paramString3;
                        localObject2 = null;
                        i = 0;
                        paramString3 = str3;
                        break;
                        paramString3 = paramContext.getString(2131767064, new Object[] { paramString1.bVF });
                        paramString1 = paramString3;
                        if (x.AN(paramString2)) {
                          break label5140;
                        }
                        paramString1 = paramString3;
                        if (j != 0) {
                          break label5140;
                        }
                        paramPString2.value = str1;
                        paramString1 = paramString3;
                        break label5140;
                      }
                      localObject3 = "";
                      paramString1 = ((com.tencent.mm.plugin.patmsg.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.patmsg.a.b.class)).avw(paramString3);
                      if (paramString1.vAC.size() <= 0) {
                        break label9488;
                      }
                      paramPString1.value = ((PluginPatMsg)com.tencent.mm.kernel.g.ad(PluginPatMsg.class)).parseDisplayTemplate(((cja)paramString1.vAC.getLast()).hGT, paramString2).result;
                      localObject2 = null;
                      i = 0;
                      paramString1 = paramString3;
                      paramString3 = (String)localObject3;
                      break label851;
                      paramString1 = k.b.zb(bu.aSA((String)localObject3));
                      if (paramString1 == null)
                      {
                        ae.e("MicroMsg.Notification.Wording", "decode msg content failed");
                        AppMethodBeat.o(186342);
                        return "";
                      }
                      paramString1 = paramContext.getString(2131756605) + paramString1.getTitle();
                      paramPString1.value = paramString1;
                      paramString3 = "";
                      localObject2 = null;
                      i = 0;
                      break label851;
                      paramString1 = bu.aSA((String)localObject3);
                      localObject2 = k.b.zb(paramString1);
                      if (localObject2 == null)
                      {
                        ae.e("MicroMsg.Notification.Wording", "decode msg content failed");
                        AppMethodBeat.o(186342);
                        return "";
                      }
                      switch (((k.b)localObject2).type)
                      {
                      default: 
                        paramString3 = paramContext.getString(2131755278);
                        localObject2 = null;
                        i = 0;
                        paramString1 = "";
                        break;
                      case 1: 
                      case 53: 
                      case 57: 
                        localObject3 = "";
                        if (str1.length() > 0)
                        {
                          paramString1 = str1 + ": " + ((k.b)localObject2).title;
                          if ((!x.AN(paramString2)) && (j == 0)) {
                            paramPString2.value = str1;
                          }
                          if (str1.length() <= 0) {
                            break label5775;
                          }
                        }
                        for (paramString3 = "%s: " + ((k.b)localObject2).title;; paramString3 = ((k.b)localObject2).title)
                        {
                          paramPString1.value = paramString3;
                          localObject2 = null;
                          i = 0;
                          paramString3 = (String)localObject3;
                          break;
                          paramString1 = ((k.b)localObject2).title;
                          break label5699;
                        }
                      case 2: 
                        localObject3 = paramContext.getString(2131755853);
                        if (str1.length() > 0)
                        {
                          paramString1 = str1 + ": ";
                          if ((!x.AN(paramString2)) && (j == 0)) {
                            paramPString2.value = str1;
                          }
                          if (str1.length() <= 0) {
                            break label5879;
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
                          break label5824;
                        }
                      case 3: 
                        localObject3 = paramContext.getString(2131755820);
                        if (str1.length() > 0)
                        {
                          paramString1 = str1 + ": ";
                          if ((!x.AN(paramString2)) && (j == 0)) {
                            paramPString2.value = str1;
                          }
                          if (str1.length() <= 0) {
                            break label5984;
                          }
                        }
                        for (paramString3 = "%s: ";; paramString3 = "")
                        {
                          paramPString1.value = paramString3;
                          localObject2 = ((k.b)localObject2).title;
                          i = 1;
                          paramString3 = (String)localObject3;
                          break;
                          paramString1 = "";
                          break label5925;
                        }
                      case 4: 
                        localObject3 = paramContext.getString(2131755926);
                        if (str1.length() > 0)
                        {
                          paramString1 = str1 + ": ";
                          if ((!x.AN(paramString2)) && (j == 0)) {
                            paramPString2.value = str1;
                          }
                          if (str1.length() <= 0) {
                            break label6089;
                          }
                        }
                        for (paramString3 = "%s: ";; paramString3 = "")
                        {
                          paramPString1.value = paramString3;
                          localObject2 = ((k.b)localObject2).title;
                          i = 1;
                          paramString3 = (String)localObject3;
                          break;
                          paramString1 = "";
                          break label6030;
                        }
                      case 6: 
                        localObject3 = paramContext.getString(2131755773);
                        if (str1.length() > 0)
                        {
                          paramString1 = str1 + ": ";
                          if ((!x.AN(paramString2)) && (j == 0)) {
                            paramPString2.value = str1;
                          }
                          if (str1.length() <= 0) {
                            break label6194;
                          }
                        }
                        for (paramString3 = "%s: ";; paramString3 = "")
                        {
                          paramPString1.value = paramString3;
                          localObject2 = ((k.b)localObject2).title;
                          i = 1;
                          paramString3 = (String)localObject3;
                          break;
                          paramString1 = "";
                          break label6135;
                        }
                      case 7: 
                        localObject3 = paramContext.getString(2131755278);
                        if (str1.length() > 0)
                        {
                          paramString1 = str1 + ": ";
                          if ((!x.AN(paramString2)) && (j == 0)) {
                            paramPString2.value = str1;
                          }
                          if (str1.length() <= 0) {
                            break label6295;
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
                          break label6240;
                        }
                      case 5: 
                        localObject3 = paramContext.getString(2131755920);
                        if (str1.length() > 0)
                        {
                          paramString1 = str1 + ": ";
                          if ((!x.AN(paramString2)) && (j == 0) && (!x.AW(paramString2))) {
                            paramPString2.value = str1;
                          }
                          if (str1.length() <= 0) {
                            break label6407;
                          }
                        }
                        for (paramString3 = "%s: ";; paramString3 = "")
                        {
                          paramPString1.value = paramString3;
                          localObject2 = ((k.b)localObject2).getTitle();
                          i = 1;
                          paramString3 = (String)localObject3;
                          break;
                          paramString1 = "";
                          break label6341;
                        }
                      case 46: 
                        paramString3 = paramContext.getString(2131755278);
                        localObject2 = null;
                        i = 0;
                        paramString1 = "";
                        break;
                      case 33: 
                      case 36: 
                        localObject3 = "";
                        paramString3 = paramContext.getString(2131755375);
                        if (str1.length() > 0)
                        {
                          paramString1 = str1 + ": " + paramString3 + ((k.b)localObject2).title;
                          if ((!x.AN(paramString2)) && (j == 0) && (!x.AW(paramString2))) {
                            paramPString2.value = str1;
                          }
                          if (str1.length() <= 0) {
                            break label6593;
                          }
                        }
                        for (paramString3 = "%s: " + paramString3 + ((k.b)localObject2).title;; paramString3 = paramString3 + ((k.b)localObject2).title)
                        {
                          paramPString1.value = paramString3;
                          localObject2 = null;
                          i = 0;
                          paramString3 = (String)localObject3;
                          break;
                          paramString1 = paramString3 + ((k.b)localObject2).title;
                          break label6489;
                        }
                      case 44: 
                        if (((k.b)localObject2).ex(false))
                        {
                          localObject3 = "";
                          paramString3 = ((k.b)localObject2).t(paramContext, true);
                          if (!bu.isNullOrNil(paramString3))
                          {
                            if (str1.length() > 0)
                            {
                              paramString1 = str1 + ": " + paramString3 + ((k.b)localObject2).title;
                              paramPString2.value = str1;
                              if (str1.length() <= 0) {
                                break label6775;
                              }
                            }
                            for (paramString3 = "%s: " + paramString3 + ((k.b)localObject2).title;; paramString3 = paramString3 + ((k.b)localObject2).title)
                            {
                              paramPString1.value = paramString3;
                              localObject2 = null;
                              i = 0;
                              paramString3 = (String)localObject3;
                              break;
                              paramString1 = paramString3 + ((k.b)localObject2).title;
                              break label6690;
                            }
                          }
                          paramString3 = paramContext.getString(2131755278);
                          localObject2 = null;
                          i = 0;
                          paramString1 = "";
                          break;
                        }
                        paramString3 = paramContext.getString(2131755278);
                        localObject2 = null;
                        i = 0;
                        paramString1 = "";
                        break;
                      case 8: 
                        paramString3 = paramContext.getString(2131755723);
                        if (str1.length() > 0) {}
                        for (paramString1 = str1 + ": ";; paramString1 = "")
                        {
                          if ((!x.AN(paramString2)) && (j == 0)) {
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
                        paramString3 = paramContext.getString(2131755724);
                        if (str1.length() > 0) {}
                        for (paramString1 = str1 + ": ";; paramString1 = "")
                        {
                          if ((!x.AN(paramString2)) && (j == 0)) {
                            paramPString2.value = str1;
                          }
                          paramPString1.value = "";
                          localObject2 = null;
                          i = 0;
                          break;
                        }
                      case 25: 
                        paramString3 = paramContext.getString(2131755710);
                        if (str1.length() > 0) {}
                        for (paramString1 = str1 + ": ";; paramString1 = "")
                        {
                          if ((!x.AN(paramString2)) && (j == 0)) {
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
                          paramString1 = str1 + ": " + ((k.b)localObject2).title;
                          if ((!x.AN(paramString2)) && (j == 0)) {
                            paramPString2.value = str1;
                          }
                          if (str1.length() <= 0) {
                            break label7201;
                          }
                        }
                        for (paramString3 = "%s: " + ((k.b)localObject2).title;; paramString3 = ((k.b)localObject2).title)
                        {
                          paramPString1.value = paramString3;
                          localObject2 = null;
                          i = 0;
                          paramString3 = (String)localObject3;
                          break;
                          paramString1 = ((k.b)localObject2).title;
                          break label7125;
                        }
                      case 19: 
                        localObject3 = paramContext.getString(2131755872);
                        if (str1.length() > 0)
                        {
                          paramString1 = str1 + ": ";
                          if ((!x.AN(paramString2)) && (j == 0)) {
                            paramPString2.value = str1;
                          }
                          if (str1.length() <= 0) {
                            break label7305;
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
                          break label7250;
                        }
                      case 24: 
                        paramString1 = "";
                        if (!bu.isNullOrNil(((k.b)localObject2).description))
                        {
                          i = ((k.b)localObject2).description.indexOf("\n");
                          paramString1 = ((k.b)localObject2).description;
                          if (i > 0) {
                            paramString1 = paramString1.substring(0, i);
                          }
                        }
                        else
                        {
                          localObject3 = paramContext.getString(2131759036) + paramString1;
                          if (str1.length() <= 0) {
                            break label7476;
                          }
                          paramString1 = str1 + ": ";
                          if ((!x.AN(paramString2)) && (j == 0)) {
                            paramPString2.value = str1;
                          }
                          if (str1.length() <= 0) {
                            break label7482;
                          }
                        }
                        for (paramString3 = "%s: ";; paramString3 = "")
                        {
                          paramPString1.value = paramString3;
                          localObject2 = null;
                          i = 0;
                          paramString3 = (String)localObject3;
                          break;
                          i = ((k.b)localObject2).description.length();
                          break label7349;
                          paramString1 = "";
                          break label7414;
                        }
                      case 16: 
                        localObject3 = "";
                        paramString3 = paramContext.getString(2131756943);
                        if (str1.length() > 0)
                        {
                          paramString1 = str1 + ": " + paramString3 + ((k.b)localObject2).title;
                          if ((!x.AN(paramString2)) && (j == 0)) {
                            paramPString2.value = str1;
                          }
                          if (str1.length() <= 0) {
                            break label7625;
                          }
                        }
                        for (paramString3 = "%s: ".concat(String.valueOf(paramString3));; paramString3 = String.valueOf(paramString3))
                        {
                          paramPString1.value = paramString3;
                          localObject2 = null;
                          i = 0;
                          paramString3 = (String)localObject3;
                          break;
                          paramString1 = paramString3 + ((k.b)localObject2).title;
                          break label7543;
                        }
                      case 34: 
                        localObject3 = "";
                        paramString1 = paramContext.getString(2131756943);
                        if (paramInt1 == 1)
                        {
                          paramString3 = paramString1 + ((k.b)localObject2).hDW;
                          if (str1.length() > 0) {}
                          for (paramString1 = "%s: ".concat(String.valueOf(paramString3));; paramString1 = String.valueOf(paramString3))
                          {
                            paramPString1.value = paramString1;
                            paramString1 = paramString3;
                            if (x.AN(paramString2)) {
                              break label9476;
                            }
                            paramString1 = paramString3;
                            if (j != 0) {
                              break label9476;
                            }
                            paramPString2.value = str1;
                            localObject2 = null;
                            i = 0;
                            paramString1 = paramString3;
                            paramString3 = (String)localObject3;
                            break;
                          }
                        }
                        paramString3 = paramString1 + ((k.b)localObject2).hDV;
                        if (str1.length() > 0) {}
                        for (paramString1 = "%s: ".concat(String.valueOf(paramString3));; paramString1 = String.valueOf(paramString3))
                        {
                          paramPString1.value = paramString1;
                          break;
                        }
                      case 40: 
                        if (t.zg(paramString1).hGb == 19)
                        {
                          localObject3 = paramContext.getString(2131755872);
                          localObject2 = null;
                          i = 0;
                          paramString1 = paramString3;
                          paramString3 = (String)localObject3;
                          break;
                        }
                        localObject3 = paramContext.getString(2131755278);
                        localObject2 = null;
                        i = 0;
                        paramString1 = paramString3;
                        paramString3 = (String)localObject3;
                        break;
                      case 68: 
                        label5699:
                        label5879:
                        label6135:
                        label7543:
                        localObject3 = "";
                        label5824:
                        label5984:
                        label6240:
                        label6775:
                        paramString3 = paramContext.getString(2131755278);
                        label6089:
                        label6489:
                        label7414:
                        if (str1.length() > 0)
                        {
                          paramString1 = str1 + ": " + paramString3 + ((k.b)localObject2).title;
                          if ((!x.AN(paramString2)) && (j == 0) && (!x.AW(paramString2))) {
                            paramPString2.value = str1;
                          }
                          if (str1.length() <= 0) {
                            break label8022;
                          }
                        }
                        label6194:
                        label6341:
                        label7125:
                        label7918:
                        for (paramString3 = "%s: " + paramString3 + ((k.b)localObject2).title;; paramString3 = paramString3 + ((k.b)localObject2).title)
                        {
                          paramPString1.value = paramString3;
                          localObject2 = null;
                          i = 0;
                          paramString3 = (String)localObject3;
                          break;
                          paramString1 = paramString3 + ((k.b)localObject2).title;
                          break label7918;
                        }
                        label6593:
                        label7250:
                        label8022:
                        paramString1 = paramString3;
                        label7349:
                        label7482:
                        label7625:
                        if (k != 0) {
                          paramString1 = uR(paramString3);
                        }
                        label7476:
                        paramString3 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).zf(paramString1);
                        paramString1 = paramString3;
                        if (k != 0) {
                          paramString1 = uQ(paramString3);
                        }
                        paramString1 = com.tencent.mm.pluginsdk.ui.span.k.aOF(paramString1);
                        paramPString1.value = paramString1;
                        paramString3 = "";
                        localObject2 = null;
                        i = 0;
                        break;
                        paramPString1.value = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).ze(paramString3);
                        paramString3 = paramPString1.value;
                        ae.i("MicroMsg.Notification.Wording", "[parseMsgContentToShow] type:%s suffix:%s", new Object[] { Integer.valueOf(318767153), paramString3 });
                        localObject2 = null;
                        i = 0;
                        paramString1 = "";
                        break;
                        paramString1 = com.tencent.mm.am.a.b(a.a.Fi(paramString3));
                        paramPString1.value = paramString1;
                        paramString3 = "";
                        localObject2 = null;
                        i = 0;
                        break;
                        paramString3 = "";
                        localObject2 = k.b.zb((String)localObject3);
                        paramString1 = paramString3;
                        if (localObject2 == null) {
                          break label842;
                        }
                        paramString1 = paramString3;
                        try
                        {
                          paramString3 = URLDecoder.decode(((k.b)localObject2).content, "UTF-8");
                          paramString1 = paramString3;
                          paramString3 = com.tencent.mm.pluginsdk.ui.span.k.aOF(paramString3);
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
                              paramString3 = paramString1;
                            }
                          }
                          paramString3 = paramString3;
                        }
                      }
                    }
                    ae.printErrStackTrace("MicroMsg.Notification.Wording", paramString3, "", new Object[0]);
                    paramString3 = "";
                    localObject2 = null;
                    i = 0;
                    break label851;
                    paramString1 = ((e)com.tencent.mm.kernel.g.ab(e.class)).aqB(paramString3);
                    if (paramString1 != null) {}
                    for (paramString3 = paramString1.toString();; paramString3 = "")
                    {
                      paramString1 = paramString3;
                      if (paramBoolean1)
                      {
                        paramString1 = paramString3;
                        if (x.wb(paramString2))
                        {
                          paramString1 = paramString3;
                          if (paramString3.endsWith(paramContext.getString(2131757098)))
                          {
                            ae.i("MicroMsg.Notification.Wording", "conv.getDigest() : %s", new Object[] { paramString3 });
                            paramString1 = paramString3.substring(0, paramString3.length() - paramContext.getString(2131757098).length());
                          }
                        }
                      }
                      paramPString1.value = paramString1;
                      paramString3 = "";
                      localObject2 = null;
                      i = 0;
                      break;
                    }
                    paramString3 = com.tencent.mm.ah.a.b.zk(paramString3).content;
                    paramString1 = paramString3;
                    if (bu.isNullOrNil(paramString3)) {
                      paramString1 = "";
                    }
                    paramPString1.value = paramString1;
                    paramString3 = "";
                    localObject2 = null;
                    i = 0;
                    break label851;
                    paramString1 = paramContext.getString(2131761793);
                    for (;;)
                    {
                      paramPString1.value = paramString1;
                      paramString3 = "";
                      localObject2 = null;
                      i = 0;
                      break;
                      paramString1 = com.tencent.mm.ah.a.a.zi(paramString3);
                      if ((bu.isNullOrNil(paramString1.nickname)) || (bu.isNullOrNil(paramString1.title))) {
                        paramString1 = "";
                      } else {
                        paramString1 = String.format(Locale.US, "%s: %s", new Object[] { paramString1.nickname, paramString1.title });
                      }
                    }
                    label8535:
                    paramString1 = paramString1.split("@bottle:");
                    if (paramString1.length > 1)
                    {
                      paramPString1.value = paramString1[1];
                      paramString1 = paramString1[1];
                      AppMethodBeat.o(186342);
                      return paramString1;
                    }
                    paramPString1.value = "";
                    AppMethodBeat.o(186342);
                    return null;
                    paramString2 = null;
                    paramPString2 = null;
                    paramContext = paramString1.split(":");
                    if ((paramContext == null) || (paramContext.length <= 0))
                    {
                      paramPString1.value = "";
                      AppMethodBeat.o(186342);
                      return null;
                    }
                    paramContext = paramContext[0];
                    if (!bu.isNullOrNil(paramContext))
                    {
                      bc.aCg();
                      paramPInt = com.tencent.mm.model.c.azF().BH(paramContext);
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
                    if (!bu.isNullOrNil(paramString3))
                    {
                      paramPString1.value = (paramString2 + ": " + paramString3);
                      paramString1 = paramString2 + ": " + paramString3;
                      AppMethodBeat.o(186342);
                      return paramString1;
                    }
                    paramString1 = paramString1.split("@bottle:");
                    if (paramString1.length > 1)
                    {
                      paramPString1.value = (paramString2 + ": " + paramString1[1]);
                      paramString1 = paramString2 + ": " + paramString1[1];
                      AppMethodBeat.o(186342);
                      return paramString1;
                    }
                    paramPString1.value = paramString2;
                    AppMethodBeat.o(186342);
                    return paramString2;
                    if (bu.isNullOrNil(paramString1)) {
                      paramPString1.value = "";
                    }
                    if (!bu.isNullOrNil(str1))
                    {
                      paramString2 = paramString1;
                      if (str2 != null)
                      {
                        paramString2 = paramString1;
                        if (str2.length() > 0) {
                          paramString2 = f(paramString1, str1, str2);
                        }
                      }
                      if (bu.isNullOrNil(paramPString2.value))
                      {
                        paramPString1.value = f(paramPString1.value, str1, "%s");
                        paramPString2.value = str1;
                      }
                      paramString1 = o.vR(paramString2);
                      paramPString1.value = o.vR(paramPString1.value);
                      paramString2 = paramString1 + paramString3;
                      paramPString1.value += paramString3;
                      if ((paramBoolean1) && (!a(paramInt2, paramPString1, paramString2))) {
                        a(paramInt2, paramPString1, paramPString2, paramPInt);
                      }
                      paramString1 = paramString2;
                      if (i != 0) {
                        paramString1 = paramString2.concat(" " + bu.nullAsNil((String)localObject2));
                      }
                      paramString1 = bu.nullAsNil(paramString1);
                      AppMethodBeat.o(186342);
                      return paramString1;
                    }
                    if ((x.AN(paramString2)) || (j != 0) || (x.AW(paramString2)))
                    {
                      str1 = paramString1;
                      if (paramString3 != null)
                      {
                        str1 = paramString1;
                        if (paramString3.length() > 0) {
                          str1 = paramString3;
                        }
                      }
                      if (bu.isNullOrNil(str1))
                      {
                        paramPString1.value = "";
                        paramPString2.value = "";
                        AppMethodBeat.o(186342);
                        return "";
                      }
                      if (paramInt1 == 0)
                      {
                        paramPString1.value = "%s:".concat(String.valueOf(str1));
                        if (!paramBoolean1) {
                          break label9387;
                        }
                        a(paramInt2, paramPString1, paramPString2, paramPInt);
                        paramString1 = str1;
                      }
                    }
                    for (;;)
                    {
                      paramString3 = paramString1;
                      if (i != 0)
                      {
                        paramString3 = paramString1;
                        if (localObject2 != null) {
                          paramString3 = paramString1.concat(" ".concat(String.valueOf(localObject2)));
                        }
                      }
                      paramString1 = paramString3;
                      if (k != 0) {
                        paramString1 = uR(paramString3);
                      }
                      if ((!bu.isNullOrNil(paramString4)) && (com.tencent.mm.al.g.En(paramString2)))
                      {
                        paramString2 = ag.aGo().Ey(paramString4);
                        if ((paramString2 != null) && (!bu.isNullOrNil(paramString2.field_openId)) && (!bu.isNullOrNil(paramString2.field_nickname)) && ((paramInt3 == 2) || (paramString2.field_kfType == 2)))
                        {
                          paramPString1.value = ("%s:" + paramPString1.value);
                          paramPString2.value = paramString2.field_nickname;
                        }
                      }
                      paramString1 = bu.nullAsNil(paramString1);
                      AppMethodBeat.o(186342);
                      return paramString1;
                      paramPString1.value = (paramContext.getString(2131755809) + ":" + str1);
                      break;
                      paramString1 = w.zP(paramPString2.value) + ":" + str1;
                      AppMethodBeat.o(186342);
                      return paramString1;
                      if ((paramString3 == null) || (paramString3.length() <= 0)) {
                        break label9471;
                      }
                      paramPString1.value = paramString3;
                      paramString1 = paramString3;
                      if (paramBoolean1)
                      {
                        a(paramInt2, paramPString1, paramPString2, paramPInt);
                        paramString1 = paramString3;
                      }
                    }
                    label9471:
                    paramString3 = "";
                    localObject2 = null;
                    i = 0;
                    break label851;
                    localObject2 = null;
                    i = 0;
                    paramString1 = paramString3;
                    paramString3 = (String)localObject3;
                    break label851;
                    paramString1 = "";
                  }
                  paramString1 = "";
                }
              }
            }
            label5140:
            label6295:
            label6690:
            paramString1 = paramString2;
            label5775:
            label7201:
            label8866:
            break label2416;
            label6030:
            label9488:
            paramString1 = paramString2;
          }
          label8584:
          label9530:
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
    AppMethodBeat.i(20085);
    if ((paramPString1.value.length() == 32) && ((paramInt == 47) || (paramInt == 1048625)))
    {
      AppMethodBeat.o(20085);
      return;
    }
    if (paramPString1.value.length() >= 150) {
      paramPString1.value = paramPString1.value.substring(0, F(paramPString1.value, 150));
    }
    TextPaint localTextPaint = getTextPaint();
    if ((paramPString1.value.replace("%%", "").contains("%s")) || (localTextPaint == null))
    {
      paramPInt.value = 0;
      AppMethodBeat.o(20085);
      return;
    }
    try
    {
      paramPString2 = String.format(paramPString1.value, new Object[] { paramPString2.value });
      paramPString1.value = a(paramPString2, localTextPaint).toString();
      paramPInt.value = 1;
      AppMethodBeat.o(20085);
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
  
  private static boolean a(int paramInt, PString paramPString, String paramString)
  {
    AppMethodBeat.i(20081);
    if ((paramPString.value.length() == 32) && ((paramInt == 47) || (paramInt == 1048625)))
    {
      paramPString.value = paramString;
      AppMethodBeat.o(20081);
      return true;
    }
    AppMethodBeat.o(20081);
    return false;
  }
  
  public static String b(bv parambv, PString paramPString1, PString paramPString2, PInt paramPInt, boolean paramBoolean)
  {
    AppMethodBeat.i(20074);
    String str;
    if (parambv.fvD())
    {
      str = parambv.fwq();
      if (!parambv.fta()) {
        break label90;
      }
    }
    for (parambv = com.tencent.mm.pluginsdk.ui.span.k.aOF(a(parambv.field_imgPath, parambv.field_isSend, parambv.field_talker, str, parambv.getType(), ak.getContext(), paramPString1, paramPString2, paramPInt, true, paramBoolean, parambv.fmv, parambv.fmB));; parambv = a(parambv.field_imgPath, parambv.field_isSend, parambv.field_talker, str, parambv.getType(), ak.getContext(), paramPString1, paramPString2, paramPInt, true, paramBoolean, parambv.fmv, parambv.fmB))
    {
      parambv = bu.nullAsNil(parambv);
      AppMethodBeat.o(20074);
      return parambv;
      str = parambv.field_content;
      break;
      label90:
      str = com.tencent.mm.pluginsdk.ui.span.k.aOF(str);
    }
  }
  
  public static void b(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(20090);
    if ((fJJ == null) || (fJJ.get() == null)) {
      fJJ = new WeakReference(paramTextPaint);
    }
    AppMethodBeat.o(20090);
  }
  
  public static boolean b(String paramString, bv parambv)
  {
    AppMethodBeat.i(20070);
    if ((parambv != null) && (parambv.field_bizChatId != -1L) && (com.tencent.mm.al.g.vz(paramString)))
    {
      AppMethodBeat.o(20070);
      return true;
    }
    AppMethodBeat.o(20070);
    return false;
  }
  
  private static String bU(Context paramContext)
  {
    AppMethodBeat.i(20078);
    boolean bool = v.aBb();
    bc.aCg();
    long l = bu.a((Long)com.tencent.mm.model.c.ajA().get(65793, null), 0L);
    if (!bool)
    {
      paramContext = paramContext.getString(2131763356);
      AppMethodBeat.o(20078);
      return paramContext;
    }
    if (l == 0L)
    {
      paramContext = paramContext.getString(2131759554);
      AppMethodBeat.o(20078);
      return paramContext;
    }
    if (bu.rZ(l) * 1000L > 1209600000L)
    {
      paramContext = paramContext.getString(2131759553, new Object[] { Long.valueOf(bu.rZ(l) * 1000L / 86400000L) });
      AppMethodBeat.o(20078);
      return paramContext;
    }
    AppMethodBeat.o(20078);
    return "";
  }
  
  public static String d(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(20091);
    paramString = com.tencent.mm.ce.b.fqL().aTh(paramString);
    if (paramBoolean)
    {
      AppMethodBeat.o(20091);
      return paramString;
    }
    paramContext = paramContext.getString(2131760347);
    AppMethodBeat.o(20091);
    return paramContext;
  }
  
  public static String e(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(20093);
    if (paramBoolean)
    {
      paramContext = com.tencent.mm.ce.b.fqL().aTh(paramString);
      AppMethodBeat.o(20093);
      return paramContext;
    }
    paramContext = paramContext.getString(2131761718);
    AppMethodBeat.o(20093);
    return paramContext;
  }
  
  public static String f(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(20072);
    if (x.wb(paramString1))
    {
      paramString2 = bl.BM(paramString2);
      if (paramString2 != null) {
        paramString2 = w.zP(paramString2.trim());
      }
    }
    while (paramString1.contains("@bottle"))
    {
      paramContext = paramContext.getResources().getQuantityString(2131623959, 1, new Object[] { Integer.valueOf(1) });
      AppMethodBeat.o(20072);
      return paramContext;
      paramString2 = w.zP(paramString1);
      continue;
      paramString2 = w.zP(paramString1);
    }
    String str = paramString2;
    if (bu.isNullOrNil(paramString2))
    {
      str = paramString2;
      if (x.wb(paramString1)) {
        str = paramContext.getString(2131757293);
      }
    }
    paramContext = com.tencent.mm.ce.b.fqL().aTh(str);
    AppMethodBeat.o(20072);
    return paramContext;
  }
  
  private static String f(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(20080);
    if ((bu.isNullOrNil(paramString1)) || (bu.isNullOrNil(paramString2)) || (bu.isNullOrNil(paramString3)))
    {
      AppMethodBeat.o(20080);
      return paramString1;
    }
    int i = paramString1.indexOf(paramString2);
    if (i < 0)
    {
      AppMethodBeat.o(20080);
      return paramString1;
    }
    paramString1 = paramString1.substring(0, i) + paramString3 + paramString1.substring(i + paramString2.length());
    AppMethodBeat.o(20080);
    return paramString1;
  }
  
  private static TextPaint getTextPaint()
  {
    AppMethodBeat.i(20089);
    if (fJJ == null)
    {
      AppMethodBeat.o(20089);
      return null;
    }
    TextPaint localTextPaint = (TextPaint)fJJ.get();
    AppMethodBeat.o(20089);
    return localTextPaint;
  }
  
  public static void la(int paramInt)
  {
    fJK = paramInt;
  }
  
  public static void lb(int paramInt)
  {
    fJL = paramInt;
  }
  
  private static String uQ(String paramString)
  {
    AppMethodBeat.i(20079);
    if (paramString != null)
    {
      paramString = paramString.replaceAll("%", "%%");
      AppMethodBeat.o(20079);
      return paramString;
    }
    AppMethodBeat.o(20079);
    return paramString;
  }
  
  private static String uR(String paramString)
  {
    AppMethodBeat.i(20082);
    if (paramString != null)
    {
      paramString = paramString.replaceAll("%%", "%");
      AppMethodBeat.o(20082);
      return paramString;
    }
    AppMethodBeat.o(20082);
    return paramString;
  }
  
  private static boolean uS(String paramString)
  {
    AppMethodBeat.i(20083);
    if ((x.At(paramString)) && (!v.aAY()))
    {
      AppMethodBeat.o(20083);
      return true;
    }
    if ((x.Av(paramString)) && (!v.aAP()))
    {
      AppMethodBeat.o(20083);
      return true;
    }
    if ((x.Az(paramString)) && (!v.aBb()))
    {
      AppMethodBeat.o(20083);
      return true;
    }
    AppMethodBeat.o(20083);
    return false;
  }
  
  public static String uT(String paramString)
  {
    AppMethodBeat.i(20084);
    if (paramString == null)
    {
      AppMethodBeat.o(20084);
      return "";
    }
    if (paramString.length() < 150)
    {
      AppMethodBeat.o(20084);
      return paramString;
    }
    paramString = paramString.substring(0, 150) + "...";
    AppMethodBeat.o(20084);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.booter.notification.a.h
 * JD-Core Version:    0.7.0.1
 */