package com.tencent.mm.booter.notification.a;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.j;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.aj.t;
import com.tencent.mm.ao.a.k;
import com.tencent.mm.ao.af;
import com.tencent.mm.ap.a.a;
import com.tencent.mm.compatible.util.o;
import com.tencent.mm.f.a.abn;
import com.tencent.mm.f.a.abn.b;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.plugin.patmsg.PluginPatMsg;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.apn;
import com.tencent.mm.protocal.protobuf.bcp;
import com.tencent.mm.protocal.protobuf.bja;
import com.tencent.mm.protocal.protobuf.bje;
import com.tencent.mm.protocal.protobuf.bjf;
import com.tencent.mm.protocal.protobuf.bjg;
import com.tencent.mm.protocal.protobuf.cwx;
import com.tencent.mm.protocal.protobuf.dit;
import com.tencent.mm.protocal.protobuf.diu;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.ca.a;
import com.tencent.mm.storage.ca.c;
import com.tencent.mm.storage.ca.d;
import com.tencent.mm.ui.chatting.viewitems.l.a;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import junit.framework.Assert;

public final class h
{
  private static WeakReference<TextPaint> iTh;
  private static int iTi = 0;
  private static int iTj = 0;
  public String iTg = "";
  public String mDesc = "";
  public String mTitle = "";
  
  private static String JX(String paramString)
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
  
  private static String JY(String paramString)
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
  
  private static boolean JZ(String paramString)
  {
    AppMethodBeat.i(20083);
    if ((ab.Qr(paramString)) && (!z.bdx()))
    {
      AppMethodBeat.o(20083);
      return true;
    }
    if ((ab.Qt(paramString)) && (!z.bdo()))
    {
      AppMethodBeat.o(20083);
      return true;
    }
    if ((ab.Qx(paramString)) && (!z.bdA()))
    {
      AppMethodBeat.o(20083);
      return true;
    }
    AppMethodBeat.o(20083);
    return false;
  }
  
  public static String Ka(String paramString)
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
  
  private static int Y(String paramString, int paramInt)
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
  
  private static CharSequence a(String paramString, TextPaint paramTextPaint)
  {
    AppMethodBeat.i(20086);
    paramString = TextUtils.ellipsize(com.tencent.mm.pluginsdk.ui.span.l.d(MMApplicationContext.getContext(), paramString, arv()), paramTextPaint, arw(), TextUtils.TruncateAt.END);
    AppMethodBeat.o(20086);
    return paramString;
  }
  
  public static String a(int paramInt1, String paramString1, String paramString2, int paramInt2, Context paramContext)
  {
    AppMethodBeat.i(20075);
    paramString1 = Util.nullAsNil(a(null, paramInt1, paramString1, paramString2, paramInt2, paramContext, new PString(), new PString(), new PInt(), false, false, "", 0));
    AppMethodBeat.o(20075);
    return paramString1;
  }
  
  private static String a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, PString paramPString1, PString paramPString2)
  {
    AppMethodBeat.i(20077);
    String str3 = "";
    String str2;
    String str1;
    int i;
    if ((ab.Qr(paramString1)) || (ab.Qt(paramString1)))
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
            if (!as.bvH(paramString1))
            {
              str2 = str3;
              str1 = paramString2;
              if (!as.bvJ(paramString1)) {}
            }
            else
            {
              str2 = aa.PJ(paramString1);
              paramPString2.value = paramString1;
              str1 = paramString2.substring(i + 1);
            }
          }
        }
      }
      if (Util.nullAsNil(str2).length() > 0) {
        break label313;
      }
      if (paramString3 != null) {
        break label306;
      }
    }
    for (;;)
    {
      paramPString1.value = str1;
      paramContext = paramPString1.value;
      AppMethodBeat.o(20077);
      return paramContext;
      if (!as.bvH(paramString1))
      {
        str2 = str3;
        str1 = paramString2;
        if (!as.bvJ(paramString1)) {
          break;
        }
      }
      aa.PJ(paramString1);
      paramPString2.value = paramString1;
      if (paramInt == 1)
      {
        paramContext = new StringBuilder().append(paramContext.getString(R.l.eFK, new Object[] { "" }));
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
      label306:
      str1 = paramString3;
    }
    label313:
    paramString1 = new StringBuilder();
    if (paramInt == 1)
    {
      i = R.l.eFK;
      paramString2 = paramString1.append(paramContext.getString(i));
      if (paramString3 != null) {
        break label430;
      }
      paramString1 = str1;
      label350:
      paramPString1.value = paramString1;
      paramString1 = new StringBuilder();
      if (paramInt != 1) {
        break label436;
      }
      paramInt = R.l.eFK;
      label380:
      paramContext = paramString1.append(paramContext.getString(paramInt, new Object[] { str2 }));
      if (paramString3 != null) {
        break label443;
      }
    }
    for (;;)
    {
      paramContext = str1;
      AppMethodBeat.o(20077);
      return paramContext;
      i = R.l.eFP;
      break;
      label430:
      paramString1 = paramString3;
      break label350;
      label436:
      paramInt = R.l.eFP;
      break label380;
      label443:
      str1 = paramString3;
    }
  }
  
  public static String a(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(20092);
    if (paramBoolean)
    {
      String str = com.tencent.mm.cl.b.htF().buu(paramString);
      paramString = str;
      if (paramInt3 > 1) {
        paramString = paramContext.getResources().getQuantityString(R.j.emn, paramInt3, new Object[] { Integer.valueOf(paramInt3) }) + str;
      }
      AppMethodBeat.o(20092);
      return paramString;
    }
    paramContext = paramContext.getResources().getQuantityString(R.j.emo, paramInt1, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(20092);
    return paramContext;
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(20071);
    paramContext = a(0, paramString2, paramString1, paramInt, paramContext);
    paramContext = com.tencent.mm.pluginsdk.ui.span.l.brD(com.tencent.mm.cl.b.htF().buu(paramContext));
    AppMethodBeat.o(20071);
    return paramContext;
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2, int paramInt, ca paramca)
  {
    AppMethodBeat.i(20073);
    if (TextUtils.isEmpty(paramString2)) {
      paramca = null;
    }
    for (;;)
    {
      paramString1 = paramca;
      if (Util.isNullOrNil(paramca))
      {
        if (!com.tencent.mm.n.g.Lj(paramString2)) {
          break;
        }
        paramString1 = paramContext.getString(R.l.ewS);
      }
      paramContext = com.tencent.mm.cl.b.htF().buu(paramString1);
      AppMethodBeat.o(20073);
      return paramContext;
      for (;;)
      {
        for (;;)
        {
          try
          {
            if (!b(paramString2, paramca)) {
              continue;
            }
            if (paramca == null) {
              continue;
            }
            localObject1 = af.bjx().bF(paramca.field_bizChatId);
            if (((com.tencent.mm.ao.a.c)localObject1).bjM()) {
              if (Util.isNullOrNil(((com.tencent.mm.ao.a.c)localObject1).field_chatName)) {
                localObject1 = MMApplicationContext.getContext().getString(R.l.eRh);
              }
            }
          }
          catch (Throwable paramca)
          {
            boolean bool;
            as localas;
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
            paramca = (ca)localObject1;
            if (!bool) {
              break;
            }
          }
          catch (Throwable paramca) {}
        }
        bh.beI();
        localas = com.tencent.mm.model.c.bbL().RG(paramString2);
        if (localas != null) {
          continue;
        }
        paramca = null;
        break;
        localObject1 = ((com.tencent.mm.ao.a.c)localObject1).field_chatName;
        continue;
        paramca = af.bjz().gm(paramca.field_bizChatUserId);
        if (paramca == null) {
          continue;
        }
        localObject1 = paramca.field_userName;
      }
      localObject2 = localObject1;
      if (paramInt == 318767153)
      {
        localObject2 = localObject1;
        if (!TextUtils.isEmpty(paramString1))
        {
          localObject2 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.biz.a.a.class)).aH(paramString1, paramString2);
          paramca = (ca)localObject2;
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            continue;
          }
        }
      }
      if (ab.QS(paramString2))
      {
        paramca = localas.ayr();
      }
      else
      {
        if (as.PY(paramString2))
        {
          paramInt = R.l.etp;
          localObject1 = MMApplicationContext.getContext();
          if (localas != null) {
            if (RegionCodeDecoder.bxn(localas.getCountryCode()))
            {
              paramString1 = localas.getCity();
              if (Util.isNullOrNil(paramString1)) {}
            }
          }
          for (;;)
          {
            paramca = paramContext.getString(paramInt, new Object[] { paramString1 }).trim();
            break;
            paramca = aa.PL(localas.getProvince());
            paramString1 = paramca;
            if (Util.isNullOrNil(paramca))
            {
              RegionCodeDecoder.hAC();
              paramString1 = RegionCodeDecoder.getLocName(localas.getCountryCode());
              continue;
              paramca = aa.PL(localas.getProvince());
              paramString1 = paramca;
              if (Util.isNullOrNil(paramca)) {
                paramString1 = ((Context)localObject1).getString(R.l.etv);
              }
            }
          }
        }
        if ((com.tencent.mm.n.g.Lj(paramString2)) && (Util.isNullOrNil(localas.field_nickname)) && (Util.isNullOrNil(localas.field_conRemark)))
        {
          bh.beI();
          paramString1 = com.tencent.mm.model.c.bbV().PJ(paramString2);
          paramca = (ca)localObject2;
          if (!Util.isNullOrNil(paramString1)) {
            paramca = paramString1;
          }
        }
        else
        {
          paramca = (ca)localObject2;
          if (localas.ays() != null)
          {
            paramca = (ca)localObject2;
            if (localas.ays().length() > 0) {
              paramca = localas.ays();
            }
          }
        }
      }
    }
    paramContext = paramContext.getString(R.l.intro_title);
    AppMethodBeat.o(20073);
    return paramContext;
  }
  
  private static String a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, Context paramContext, PString paramPString1, PString paramPString2, PInt paramPInt, boolean paramBoolean1, boolean paramBoolean2, String paramString4, int paramInt3)
  {
    AppMethodBeat.i(227604);
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
      if ((paramBoolean1) || (!JZ(paramString2))) {
        break label85;
      }
      paramString1 = paramContext.getString(R.l.settings_plugins_disable);
      AppMethodBeat.o(227604);
      return paramString1;
      bool = false;
      break;
    }
    label85:
    if (ab.Qx(paramString2))
    {
      if (paramBoolean1)
      {
        AppMethodBeat.o(227604);
        return "";
      }
      paramString1 = cl(paramContext);
      AppMethodBeat.o(227604);
      return paramString1;
    }
    if ((paramString3 != null) && (paramBoolean1)) {
      paramString3 = JX(paramString3);
    }
    label5634:
    label6534:
    label11145:
    for (int k = 1;; k = 0)
    {
      paramPString1.value = paramString3;
      int i;
      String str1;
      String str2;
      Object localObject3;
      if ((paramInt1 == 0) && ((ab.Lj(paramString2)) || (ab.PQ(paramString2))))
      {
        i = bq.RI(paramString3);
        if (i > 0)
        {
          str1 = paramString3.substring(0, i).trim();
          str2 = aa.aL(str1, paramString2);
          localObject3 = (paramString3 + " ").substring(i + 1);
        }
      }
      label3980:
      label12044:
      for (;;)
      {
        int j = 0;
        Object localObject1;
        if ((ab.QL(paramString2)) || (ab.QU(paramString2)))
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
        label5263:
        label7831:
        label8218:
        label9626:
        for (;;)
        {
          label954:
          label963:
          int m;
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
            label1143:
            label1662:
            do
            {
              paramString3 = "";
              localObject1 = null;
              i = 0;
              for (;;)
              {
                if (!ab.Qs(paramString2)) {
                  break label11427;
                }
                if (1 != paramInt1) {
                  break label11145;
                }
                if (Util.isNullOrNil(paramString3)) {
                  break label11096;
                }
                paramPString1.value = paramString3;
                AppMethodBeat.o(227604);
                return paramString3;
                i = j;
                if (ab.QW(paramString2)) {
                  break label12114;
                }
                bh.beI();
                localObject1 = com.tencent.mm.model.c.bbR().bwx(paramString2);
                if ((localObject1 == null) || (!((az)localObject1).rp(2097152)))
                {
                  i = j;
                  if (!paramBoolean2) {
                    break label12114;
                  }
                }
                j = 1;
                i = j;
                if (paramString3 == null) {
                  break label12114;
                }
                m = paramString3.indexOf(":");
                i = j;
                if (m == -1) {
                  break label12114;
                }
                paramPString2.value = paramString3.substring(0, m);
                paramString3 = paramString3.substring(m + 1);
                j = 1;
                break;
                localObject3 = paramContext.getString(R.l.app_pic);
                if (str1.length() > 0)
                {
                  paramString1 = str1 + ": ";
                  if (str1.length() <= 0) {
                    break label1179;
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
                  break label1143;
                }
                localObject3 = be.bwQ(paramString3);
                localObject1 = ((be)localObject3).bqK() + ": ";
                if ((paramString1 != null) && (paramString1.length() == 32)) {}
                for (paramString3 = paramString1;; paramString3 = paramContext.getString(R.l.app_emoji))
                {
                  paramPString1.value = "";
                  paramPString2.value = ((be)localObject3).bqK();
                  localObject3 = null;
                  i = 0;
                  paramString1 = (String)localObject1;
                  localObject1 = localObject3;
                  break;
                }
                paramString1 = a(paramContext, paramInt1, paramString2, paramString3, paramContext.getString(R.l.app_pic), paramPString1, paramPString2);
                paramString3 = "";
                localObject1 = null;
                i = 0;
                continue;
                paramString1 = a(paramContext, paramInt1, paramString2, paramString3, null, paramPString1, paramPString2);
                paramString3 = "";
                localObject1 = null;
                i = 0;
                continue;
                if ((as.bvH(paramString2)) || (as.bvJ(paramString2)) || (ab.Qr(paramString2)) || (ab.Qt(paramString2)))
                {
                  paramString1 = a(paramContext, paramInt1, paramString2, paramString3, paramContext.getString(R.l.app_voice), paramPString1, paramPString2);
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
                      if (!ab.Qs(paramString2))
                      {
                        if (!ab.Lj(paramString2)) {
                          break label1496;
                        }
                        paramString3 = new p(paramString3);
                        paramString1 = paramString3.bqK() + ": ";
                        paramPString1.value = "%s:";
                        paramPString2.value = paramString3.bqK();
                      }
                    }
                  }
                  for (;;)
                  {
                    paramString3 = paramContext.getString(R.l.app_voice);
                    localObject1 = null;
                    i = 0;
                    break;
                    paramString1 = "";
                  }
                  if ((as.bvH(paramString2)) || (as.bvJ(paramString2)) || (ab.Qr(paramString2)) || (ab.Qt(paramString2)))
                  {
                    paramString1 = a(paramContext, paramInt1, paramString2, paramString3, paramContext.getString(R.l.app_video), paramPString1, paramPString2);
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
                        if (!ab.Qs(paramString2))
                        {
                          if (!ab.Lj(paramString2)) {
                            break label1662;
                          }
                          paramString3 = new u(paramString3);
                          paramString1 = paramString3.bqK() + ": ";
                          paramPString1.value = "%s:";
                          paramPString2.value = paramString3.bqK();
                        }
                      }
                    }
                    for (;;)
                    {
                      paramString3 = paramContext.getString(R.l.app_video);
                      localObject1 = null;
                      i = 0;
                      break;
                      paramString1 = "";
                    }
                    paramString3 = paramContext.getString(R.l.app_voip);
                    localObject1 = null;
                    i = 0;
                    paramString1 = "";
                    continue;
                    paramString3 = paramContext.getString(R.l.app_voice_remind);
                    localObject1 = null;
                    i = 0;
                    paramString1 = "";
                    continue;
                    if (paramString3.equals(ca.VGy))
                    {
                      paramString3 = paramContext.getString(R.l.app_voip);
                      localObject1 = null;
                      i = 0;
                      paramString1 = "";
                    }
                    else
                    {
                      paramString1 = paramString3;
                      if (!paramString3.equals(ca.VGx)) {
                        break label954;
                      }
                      paramString3 = paramContext.getString(R.l.app_voip_voice);
                      localObject1 = null;
                      i = 0;
                      paramString1 = "";
                      continue;
                      paramString3 = paramContext.getString(R.l.app_voip);
                      localObject1 = null;
                      i = 0;
                      paramString1 = "";
                      continue;
                      paramString3 = paramContext.getString(R.l.app_voip_voice);
                      localObject1 = null;
                      i = 0;
                      paramString1 = "";
                      continue;
                      paramString1 = paramString3;
                      if (paramString3 == null) {
                        break label954;
                      }
                      paramString1 = paramString3;
                      if (paramString3.length() <= 0) {
                        break label954;
                      }
                      localObject1 = ca.d.bxc(paramString3);
                      paramString1 = paramString3;
                      if (((ca.d)localObject1).hAo() != null)
                      {
                        paramString1 = paramString3;
                        if (((ca.d)localObject1).hAo().length() <= 0) {}
                      }
                      switch (((ca.d)localObject1).getScene())
                      {
                      case 19: 
                      case 20: 
                      case 21: 
                      default: 
                        paramString1 = paramContext.getString(R.l.eFS, new Object[] { ((ca.d)localObject1).getDisplayName() });
                        paramPString1.value = paramString1;
                        paramString3 = "";
                        localObject1 = null;
                        i = 0;
                        break;
                      case 18: 
                        paramString1 = paramContext.getString(R.l.eFN, new Object[] { ((ca.d)localObject1).getDisplayName() });
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
                        paramString1 = paramContext.getString(R.l.eFQ, new Object[] { ((ca.d)localObject1).getDisplayName() });
                        paramString3 = "";
                        localObject1 = null;
                        i = 0;
                        break;
                      case 25: 
                        paramString1 = paramContext.getString(R.l.eFs, new Object[] { ((ca.d)localObject1).getDisplayName() });
                        paramPString1.value = paramString1;
                        paramString3 = "";
                        localObject1 = null;
                        i = 0;
                        continue;
                        paramString1 = paramString3;
                        if (paramString3 == null) {
                          break label954;
                        }
                        paramString1 = paramString3;
                        if (paramString3.length() <= 0) {
                          break label954;
                        }
                        localObject1 = ca.a.bwZ(paramString3);
                        paramString1 = paramString3;
                        if (((ca.a)localObject1).hAo() != null)
                        {
                          paramString1 = paramString3;
                          if (((ca.a)localObject1).hAo().length() > 0)
                          {
                            paramString1 = paramContext.getString(R.l.eFD, new Object[] { ((ca.a)localObject1).getDisplayName() });
                            paramPString1.value = paramString1;
                          }
                        }
                        paramString3 = "";
                        localObject1 = null;
                        i = 0;
                        continue;
                        paramString1 = paramString3;
                        if (Util.nullAsNil(paramString3).length() <= 0) {
                          break label954;
                        }
                        bh.beI();
                        paramString1 = com.tencent.mm.model.c.bbO().aOS(paramString3);
                        paramString1 = paramContext.getString(R.l.eFH, new Object[] { paramString1.getSender(), paramString1.getTitle() });
                        paramPString1.value = paramString1;
                        paramString3 = "";
                        localObject1 = null;
                        i = 0;
                        continue;
                        paramString1 = paramString3;
                        if (Util.nullAsNil(paramString3).length() <= 0) {
                          break label954;
                        }
                        if (ab.Lj(paramString2))
                        {
                          localObject1 = bq.RL(paramString3);
                          paramString1 = (String)localObject1;
                          if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
                        }
                        else
                        {
                          paramString1 = paramString2;
                        }
                        bh.beI();
                        localObject3 = com.tencent.mm.model.c.bbO().aOU(paramString3);
                        bh.beI();
                        localObject1 = com.tencent.mm.model.c.bbL().RG(paramString1).ays();
                        paramString3 = (String)localObject1;
                        if (ab.Lj((String)localObject1)) {
                          paramString3 = v.al(v.Pv((String)localObject1));
                        }
                        if (paramInt1 == 1)
                        {
                          localObject1 = paramContext.getString(R.l.eFt, new Object[] { paramString3, ((ca.a)localObject3).getDisplayName() });
                          paramPString1.value = paramContext.getString(R.l.eFt, new Object[] { "%s", ((ca.a)localObject3).getDisplayName() });
                          paramPString2.value = paramString1;
                          paramString3 = "";
                          localObject3 = null;
                          i = 0;
                          paramString1 = (String)localObject1;
                          localObject1 = localObject3;
                        }
                        else
                        {
                          localObject1 = paramContext.getString(R.l.eFu, new Object[] { paramString3, ((ca.a)localObject3).getDisplayName() });
                          paramPString1.value = paramContext.getString(R.l.eFu, new Object[] { "%s", ((ca.a)localObject3).getDisplayName() });
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
            } while (Util.nullAsNil(paramString3).length() <= 0);
            label1179:
            label1496:
            if (ab.Lj(paramString2))
            {
              i = bq.RI(paramString3);
              if (i != -1)
              {
                paramString1 = paramString3.substring(0, i).trim();
                label2528:
                bq.RM(paramString3);
              }
            }
            break;
          }
          label4892:
          label11427:
          for (;;)
          {
            if (paramInt1 == 1)
            {
              paramString1 = paramContext.getString(R.l.location_conversation);
              paramPString1.value = paramString1;
              paramString3 = "";
              localObject1 = null;
              i = 0;
              break label963;
            }
            localObject1 = paramContext.getString(R.l.location_conversation);
            paramPString1.value = paramContext.getString(R.l.location_conversation);
            paramPString2.value = paramString1;
            paramString3 = "";
            localObject3 = null;
            i = 0;
            paramString1 = (String)localObject1;
            localObject1 = localObject3;
            break label963;
            paramString1 = k.b.OQ(Util.processXml((String)localObject3));
            if (paramString1.lmv != 0) {
              if (paramString1.lmv == 1) {
                paramString1 = paramContext.getString(R.l.eRB);
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
              if (paramString1.lmv == 2) {
                paramString1 = paramContext.getString(R.l.eRD);
              } else if (paramString1.lmv == 3) {
                paramString1 = paramContext.getString(R.l.eRC);
              } else {
                paramString1 = paramContext.getString(R.l.eRE);
              }
            }
            localObject1 = Util.processXml((String)localObject3);
            paramString3 = "";
            paramString1 = "";
            localObject1 = k.b.OQ((String)localObject1);
            if (localObject1 != null)
            {
              paramPString1.value = (paramContext.getString(R.l.eRH) + Util.nullAsNil(((k.b)localObject1).title));
              paramString1 = paramPString1.value;
            }
            paramPString2.value = str1;
            localObject1 = null;
            i = 0;
            break label963;
            localObject1 = Util.processXml((String)localObject3);
            paramString3 = "";
            paramString1 = "";
            localObject1 = k.b.OQ((String)localObject1);
            label2871:
            int n;
            label2888:
            int i1;
            if (localObject1 != null)
            {
              paramString1 = new abn();
              paramString1.gbr.fJG = ((k.b)localObject1).lnf;
              EventCenter.instance.publish(paramString1);
              if (paramInt1 != 1) {
                break label3035;
              }
              m = 1;
              if ((!ab.Lj(paramString2)) && (!ab.PQ(paramString2))) {
                break label3041;
              }
              n = 1;
              localObject3 = ((com.tencent.mm.aj.j)((k.b)localObject1).ar(com.tencent.mm.aj.j.class)).llO;
              i1 = 1;
              if ((((k.b)localObject1).lnc != 1) && (((k.b)localObject1).lnc != 7)) {
                break label3047;
              }
              i = 1;
              label2929:
              int i2 = paramString1.gbs.status;
              i1 = i2;
              if (i2 <= 0) {
                i1 = ((k.b)localObject1).lnc;
              }
              switch (i1)
              {
              default: 
                paramPString1.value = Util.nullAsNil(((k.b)localObject1).title);
              }
            }
            for (;;)
            {
              paramString1 = paramPString1.value;
              paramPString2.value = str1;
              localObject1 = null;
              i = 0;
              break;
              label3035:
              m = 0;
              break label2871;
              label3041:
              n = 0;
              break label2888;
              label3047:
              if ((n != 0) && ((str1.equals(localObject3)) || ((m != 0) && (z.bcZ().equals(localObject3)))))
              {
                i = 0;
                break label2929;
              }
              i = i1;
              if (n != 0) {
                break label2929;
              }
              i = i1;
              if (!paramString2.equals(localObject3)) {
                break label2929;
              }
              i = 0;
              break label2929;
              if (n != 0)
              {
                if (paramInt1 == 1) {
                  paramPString1.value = paramContext.getString(R.l.epb);
                }
                for (;;)
                {
                  paramPString2.value = str2;
                  break;
                  if (z.bcZ().equals(localObject3)) {
                    paramPString1.value = String.format("%s: %s", new Object[] { str2, paramContext.getString(R.l.epc) });
                  } else {
                    paramPString1.value = String.format("%s: %s", new Object[] { str2, paramContext.getString(R.l.eoY) });
                  }
                }
              }
              if (m != 0)
              {
                paramPString1.value = paramContext.getString(R.l.epb);
              }
              else
              {
                paramPString1.value = paramContext.getString(R.l.epc);
                continue;
                if (n != 0)
                {
                  if (i != 0) {
                    if ((paramInt1 == 0) && (!Util.isNullOrNil(str2))) {
                      paramPString1.value = String.format("%s: %s", new Object[] { str2, paramContext.getString(R.l.eoZ) });
                    }
                  }
                  for (;;)
                  {
                    paramPString2.value = str2;
                    break;
                    paramPString1.value = paramContext.getString(R.l.eoZ);
                    continue;
                    if ((paramInt1 == 0) && (!Util.isNullOrNil(str2))) {
                      paramPString1.value = String.format("%s: %s", new Object[] { str2, paramContext.getString(R.l.eoV) });
                    } else {
                      paramPString1.value = paramContext.getString(R.l.eoV);
                    }
                  }
                }
                if (i != 0)
                {
                  paramPString1.value = paramContext.getString(R.l.eoZ);
                }
                else
                {
                  paramPString1.value = paramContext.getString(R.l.eoV);
                  continue;
                  if (n != 0)
                  {
                    if ((paramInt1 == 0) && (!Util.isNullOrNil(str2))) {}
                    for (paramPString1.value = String.format("%s: %s", new Object[] { str2, paramContext.getString(R.l.epd) });; paramPString1.value = paramContext.getString(R.l.epa))
                    {
                      paramPString2.value = str2;
                      break;
                    }
                  }
                  if (m != 0)
                  {
                    paramPString1.value = paramContext.getString(R.l.epa);
                  }
                  else
                  {
                    paramPString1.value = paramContext.getString(R.l.epd);
                    continue;
                    if (n != 0)
                    {
                      if (i != 0) {
                        if ((paramInt1 == 0) && (!Util.isNullOrNil(str2))) {
                          paramPString1.value = String.format("%s: %s", new Object[] { str2, paramContext.getString(R.l.eoX) });
                        }
                      }
                      for (;;)
                      {
                        paramPString2.value = str2;
                        break;
                        paramPString1.value = paramContext.getString(R.l.eoX);
                        continue;
                        if ((paramInt1 == 0) && (!Util.isNullOrNil(str2))) {
                          paramPString1.value = String.format("%s: %s", new Object[] { str2, paramContext.getString(R.l.eoW) });
                        } else {
                          paramPString1.value = paramContext.getString(R.l.eoW);
                        }
                      }
                    }
                    if (i != 0)
                    {
                      paramPString1.value = paramContext.getString(R.l.eoX);
                    }
                    else
                    {
                      paramPString1.value = paramContext.getString(R.l.eoW);
                      continue;
                      if (n != 0)
                      {
                        if ((paramInt1 == 0) && (!Util.isNullOrNil(str2))) {}
                        for (paramPString1.value = String.format("%s: %s", new Object[] { str2, paramContext.getString(R.l.eoU) });; paramPString1.value = paramContext.getString(R.l.eoU))
                        {
                          paramPString2.value = str2;
                          break;
                        }
                      }
                      if (m != 0)
                      {
                        paramPString1.value = paramContext.getString(R.l.epf);
                      }
                      else
                      {
                        paramPString1.value = paramContext.getString(R.l.epf);
                        continue;
                        if (n != 0)
                        {
                          if ((paramInt1 == 0) && (!Util.isNullOrNil(str2))) {}
                          for (paramPString1.value = String.format("%s: %s", new Object[] { str2, paramContext.getString(R.l.epe) });; paramPString1.value = paramContext.getString(R.l.epe))
                          {
                            paramPString2.value = str2;
                            break;
                          }
                        }
                        if (m != 0) {
                          paramPString1.value = paramContext.getString(R.l.epg);
                        } else {
                          paramPString1.value = paramContext.getString(R.l.epg);
                        }
                      }
                    }
                  }
                }
              }
            }
            paramString1 = Util.processXml((String)localObject3);
            localObject3 = "";
            paramString3 = "";
            paramString1 = k.b.OQ(paramString1);
            if (paramString1 != null)
            {
              if (paramInt1 != 1) {
                break label4066;
              }
              i = 1;
              if (i == 0) {
                break label4072;
              }
              paramPString1.value = ("[" + paramString1.lnE + "]" + paramString1.lnB);
            }
            for (;;)
            {
              paramString3 = paramPString1.value;
              paramString1 = paramString3;
              if (ab.QL(paramString2)) {
                break label12044;
              }
              paramString1 = paramString3;
              if (j != 0) {
                break label12044;
              }
              paramPString2.value = str1;
              localObject1 = null;
              i = 0;
              paramString1 = paramString3;
              paramString3 = (String)localObject3;
              break;
              label4066:
              i = 0;
              break label3980;
              label4072:
              if (!Util.isNullOrNil(str2)) {
                paramPString1.value = (Util.nullAsNil(str2) + ": [" + paramString1.lnE + "]" + paramString1.lnA);
              } else {
                paramPString1.value = ("[" + paramString1.lnE + "]" + paramString1.lnA);
              }
            }
            localObject1 = Util.processXml((String)localObject3);
            paramString3 = "";
            paramString1 = "";
            localObject1 = k.b.OQ((String)localObject1);
            label4218:
            label4347:
            label4605:
            String str3;
            if (localObject1 != null)
            {
              paramString1 = (com.tencent.mm.aj.b)((k.b)localObject1).ar(com.tencent.mm.aj.b.class);
              if (paramInt1 == 1)
              {
                i = 1;
                if (i == 0) {
                  break label4275;
                }
              }
              label4275:
              for (paramPString1.value = paramContext.getString(R.l.eHU, new Object[] { paramString1.lkP });; paramPString1.value = paramContext.getString(R.l.eHU, new Object[] { paramString1.lkQ }))
              {
                paramString1 = paramPString1.value;
                paramPString2.value = str1;
                localObject1 = null;
                i = 0;
                break;
                i = 0;
                break label4218;
              }
              localObject1 = Util.processXml((String)localObject3);
              paramString3 = "";
              paramString1 = "";
              localObject1 = k.b.OQ((String)localObject1);
              if (localObject1 != null)
              {
                paramString1 = (com.tencent.mm.aj.b)((k.b)localObject1).ar(com.tencent.mm.aj.b.class);
                if (paramInt1 == 1)
                {
                  i = 1;
                  if (i == 0) {
                    break label4419;
                  }
                }
                label4419:
                for (paramPString1.value = ("[" + paramString1.lkN + "]" + ((k.b)localObject1).description);; paramPString1.value = ("[" + paramString1.lkO + "]" + ((k.b)localObject1).description))
                {
                  paramString1 = paramPString1.value;
                  paramPString2.value = str1;
                  localObject1 = null;
                  i = 0;
                  break;
                  i = 0;
                  break label4347;
                }
                paramString3 = Util.processXml((String)localObject3);
                paramString1 = "";
                paramString3 = k.b.OQ(paramString3);
                if (paramString3 != null)
                {
                  paramString1 = (l.a)paramString3.ar(l.a.class);
                  if (paramString1.state != 1) {
                    break label4536;
                  }
                }
                label4536:
                for (paramString1 = paramContext.getString(R.l.eBN, new Object[] { paramString1.appName });; paramString1 = paramContext.getString(R.l.eBT, new Object[] { paramString1.appName }))
                {
                  paramPString1.value = paramString1;
                  paramString3 = "";
                  localObject1 = null;
                  i = 0;
                  break;
                }
                switch (k.b.OQ(Util.processXml((String)localObject3)).lmv)
                {
                default: 
                  paramString1 = paramContext.getString(R.l.app_product);
                  if (str1.length() <= 0) {
                    break;
                  }
                }
                for (paramString3 = str1 + ": ";; paramString3 = "")
                {
                  if ((!ab.QL(paramString2)) && (j == 0)) {
                    paramPString2.value = str1;
                  }
                  paramPString1.value = "";
                  localObject3 = paramString1;
                  localObject1 = null;
                  i = 0;
                  paramString1 = paramString3;
                  paramString3 = (String)localObject3;
                  break;
                  paramString1 = paramContext.getString(R.l.app_product_card);
                  break label4605;
                  paramString1 = paramContext.getString(R.l.app_product_ticket);
                  break label4605;
                }
                paramString3 = k.b.OQ(Util.processXml((String)localObject3));
                if (paramString3 == null)
                {
                  Log.e("MicroMsg.Notification.Wording", "decode msg content failed");
                  AppMethodBeat.o(227604);
                  return "";
                }
                localObject3 = "";
                localObject1 = paramContext.getString(R.l.card_msg_item_digest);
                if (str1.length() > 0)
                {
                  paramString1 = str1 + ": " + (String)localObject1 + paramString3.title;
                  label4795:
                  if ((!ab.QL(paramString2)) && (j == 0)) {
                    paramPString2.value = str1;
                  }
                  if (str1.length() <= 0) {
                    break label4892;
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
                  break label4795;
                }
                paramString1 = k.b.OQ(Util.processXml((String)localObject3));
                if (paramString1 == null)
                {
                  Log.e("MicroMsg.Notification.Wording", "decode msg content failed");
                  AppMethodBeat.o(227604);
                  return "";
                }
                localObject3 = "";
                paramString3 = paramContext.getString(R.l.card_msg_item_digest);
                if (paramInt1 == 1)
                {
                  paramString3 = paramString3 + paramString1.lnr;
                  if (str1.length() > 0) {}
                  for (paramString1 = "%s: ".concat(String.valueOf(paramString3));; paramString1 = String.valueOf(paramString3))
                  {
                    paramPString1.value = paramString1;
                    paramString1 = paramString3;
                    if (ab.QL(paramString2)) {
                      break label12044;
                    }
                    paramString1 = paramString3;
                    if (j != 0) {
                      break label12044;
                    }
                    paramPString2.value = str1;
                    localObject1 = null;
                    i = 0;
                    paramString1 = paramString3;
                    paramString3 = (String)localObject3;
                    break;
                  }
                }
                paramString3 = paramString3 + paramString1.lnq;
                if (str1.length() > 0) {}
                for (paramString1 = "%s: ".concat(String.valueOf(paramString3));; paramString1 = String.valueOf(paramString3))
                {
                  paramPString1.value = paramString1;
                  break;
                }
                paramString3 = k.b.OQ(Util.processXml((String)localObject3));
                if (paramString3 == null)
                {
                  Log.e("MicroMsg.Notification.Wording", "decode msg content failed");
                  AppMethodBeat.o(227604);
                  return "";
                }
                localObject3 = "";
                if (str1.length() > 0)
                {
                  paramString1 = str1 + ": " + paramString3.title;
                  label5189:
                  if ((!ab.QL(paramString2)) && (j == 0)) {
                    paramPString2.value = str1;
                  }
                  if (str1.length() <= 0) {
                    break label5263;
                  }
                }
                for (paramString3 = "%s: " + paramString3.title;; paramString3 = paramString3.title)
                {
                  paramPString1.value = paramString3;
                  localObject1 = null;
                  i = 0;
                  paramString3 = (String)localObject3;
                  break;
                  paramString1 = paramString3.title;
                  break label5189;
                }
                localObject3 = paramContext.getString(R.l.app_app);
                if (str1.length() > 0)
                {
                  paramString1 = str1 + ": ";
                  label5311:
                  if ((!ab.QL(paramString2)) && (j == 0)) {
                    paramPString2.value = str1;
                  }
                  if (str1.length() <= 0) {
                    break label5366;
                  }
                }
                label5366:
                for (paramString3 = "%s: ";; paramString3 = "")
                {
                  paramPString1.value = paramString3;
                  localObject1 = null;
                  i = 0;
                  paramString3 = (String)localObject3;
                  break;
                  paramString1 = "";
                  break label5311;
                }
                paramString1 = k.b.OQ(Util.processXml((String)localObject3));
                if (paramString1 == null)
                {
                  Log.e("MicroMsg.Notification.Wording", "decode msg content failed");
                  AppMethodBeat.o(227604);
                  return "";
                }
                localObject3 = "";
                try
                {
                  paramString1 = URLDecoder.decode(paramString1.content, "UTF-8");
                  paramString3 = paramString1;
                  paramString1 = com.tencent.mm.pluginsdk.ui.span.l.brD(paramString1);
                }
                catch (Exception localException)
                {
                  for (;;)
                  {
                    paramString1 = paramString3;
                    Log.printErrStackTrace("MicroMsg.Notification.Wording", localException, "", new Object[0]);
                    continue;
                    paramString3 = paramString1;
                  }
                }
                if ((!ab.QL(paramString2)) && (j == 0)) {
                  paramPString2.value = str1;
                }
                if (str1.length() > 0)
                {
                  paramString3 = "%s: ".concat(String.valueOf(paramString1));
                  paramPString1.value = paramString3;
                  localObject1 = null;
                  i = 0;
                  paramString3 = (String)localObject3;
                  break label963;
                }
                str3 = "";
                paramString1 = k.b.OQ(Util.processXml((String)localObject3));
                if (paramString1 == null)
                {
                  Log.e("MicroMsg.Notification.Wording", "decode msg content failed");
                  AppMethodBeat.o(227604);
                  return "";
                }
                if ((!ab.QL(paramString2)) && (j == 0)) {
                  paramPString2.value = str1;
                }
                paramString3 = paramContext.getString(R.l.app_finder);
                paramString1 = (com.tencent.mm.plugin.findersdk.a.f)paramString1.ar(com.tencent.mm.plugin.findersdk.a.f.class);
                if ((paramString1 == null) || (Util.isNullOrNil(paramString1.enh().nickname))) {
                  break label12099;
                }
                if (Util.isNullOrNil(paramString1.enh().desc)) {
                  paramString1 = paramContext.getString(R.l.finder_feed_of_user, new Object[] { paramString1.enh().nickname });
                }
              }
            }
            label7354:
            label7880:
            label8008:
            for (paramString1 = paramString3 + paramString1;; paramString1 = paramString3)
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
                paramString1 = paramString1.enh().desc;
                break label5634;
              }
              str3 = "";
              paramString1 = k.b.OQ(Util.processXml((String)localObject3));
              if (paramString1 == null)
              {
                Log.e("MicroMsg.Notification.Wording", "decode msg content failed");
                AppMethodBeat.o(227604);
                return "";
              }
              if ((!ab.QL(paramString2)) && (j == 0)) {
                paramPString2.value = str1;
              }
              paramString3 = paramContext.getString(R.l.app_finder);
              paramString1 = (com.tencent.mm.plugin.findersdk.a.i)paramString1.ar(com.tencent.mm.plugin.findersdk.a.i.class);
              if ((paramString1 != null) && (!Util.isNullOrNil(paramString1.enj().nickname))) {
                if (Util.isNullOrNil(paramString1.enj().desc)) {
                  paramString1 = paramContext.getString(R.l.finder_feed_of_user, new Object[] { paramString1.enj().nickname });
                }
              }
              label5833:
              for (paramString1 = paramString3 + paramString1;; paramString1 = paramString3)
              {
                if (str1.length() > 0) {}
                for (paramString3 = "%s: ".concat(String.valueOf(paramString1));; paramString3 = paramString1)
                {
                  paramPString1.value = paramString3;
                  localObject2 = null;
                  i = 0;
                  paramString3 = str3;
                  break;
                  paramString1 = paramString1.enj().desc;
                  break label5833;
                }
                str3 = "";
                paramString3 = k.b.OQ(Util.processXml((String)localObject3));
                if (paramString3 == null)
                {
                  Log.e("MicroMsg.Notification.Wording", "decode msg content failed");
                  AppMethodBeat.o(227604);
                  return "";
                }
                if ((!ab.QL(paramString2)) && (j == 0)) {
                  paramPString2.value = str1;
                }
                paramString1 = paramContext.getString(R.l.app_finder);
                paramString3 = (com.tencent.mm.plugin.findersdk.a.b)paramString3.ar(com.tencent.mm.plugin.findersdk.a.b.class);
                if ((paramString3 != null) && (!Util.isNullOrNil(paramString3.ene().nickName))) {
                  paramString1 = paramString1 + paramContext.getString(R.l.finder_live_feed_of_user, new Object[] { paramString3.ene().nickName });
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
                  }
                  str3 = "";
                  paramString3 = k.b.OQ(Util.processXml((String)localObject3));
                  if (paramString3 == null)
                  {
                    Log.e("MicroMsg.Notification.Wording", "decode msg content failed");
                    AppMethodBeat.o(227604);
                    return "";
                  }
                  if ((!ab.QL(paramString2)) && (j == 0)) {
                    paramPString2.value = str1;
                  }
                  paramString1 = paramContext.getString(R.l.app_finder);
                  paramString3 = (com.tencent.mm.plugin.findersdk.a.h)paramString3.ar(com.tencent.mm.plugin.findersdk.a.h.class);
                  if ((paramString3 != null) && (!Util.isNullOrNil(paramString3.enf().topic))) {
                    if (paramString3.enf().wXA == 1) {
                      paramString1 = paramString1 + MMApplicationContext.getContext().getString(R.l.finder_topic_card_prefix, new Object[] { paramString3.enf().topic });
                    }
                  }
                  for (;;)
                  {
                    label6221:
                    if (str1.length() > 0) {}
                    for (paramString3 = "%s: ".concat(String.valueOf(paramString1));; paramString3 = paramString1)
                    {
                      paramPString1.value = paramString3;
                      localObject2 = null;
                      i = 0;
                      paramString3 = str3;
                      break;
                      paramString1 = paramString1 + paramString3.enf().topic;
                      break label6221;
                    }
                    str3 = "";
                    paramString3 = k.b.OQ(Util.processXml((String)localObject3));
                    if (paramString3 == null)
                    {
                      Log.e("MicroMsg.Notification.Wording", "decode msg content failed");
                      AppMethodBeat.o(227604);
                      return "";
                    }
                    if ((!ab.QL(paramString2)) && (j == 0)) {
                      paramPString2.value = str1;
                    }
                    paramString1 = paramContext.getString(R.l.app_finder);
                    paramString3 = (com.tencent.mm.plugin.findersdk.a.d)paramString3.ar(com.tencent.mm.plugin.findersdk.a.d.class);
                    if ((paramString3 != null) && (!Util.isNullOrNil(paramString3.eng().title))) {
                      paramString1 = paramString1 + paramString3.eng().title;
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
                      }
                      str3 = "";
                      paramString1 = k.b.OQ(Util.processXml((String)localObject3));
                      if (paramString1 == null)
                      {
                        Log.e("MicroMsg.Notification.Wording", "decode msg content failed");
                        AppMethodBeat.o(227604);
                        return "";
                      }
                      paramString1 = (com.tencent.mm.plugin.findersdk.a.e)paramString1.ar(com.tencent.mm.plugin.findersdk.a.e.class);
                      if ((paramString1 != null) && (!Util.isNullOrNil(paramString1.getNickname()))) {
                        if (paramInt1 == 1) {
                          paramString1 = paramContext.getString(R.l.finder_msg_name_card_by_me, new Object[] { paramString1.getNickname() });
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
                          paramString3 = paramContext.getString(R.l.finder_msg_name_card_by_other, new Object[] { paramString1.getNickname() });
                          paramString1 = paramString3;
                          if (ab.QL(paramString2)) {
                            break label6534;
                          }
                          paramString1 = paramString3;
                          if (j != 0) {
                            break label6534;
                          }
                          paramPString2.value = str1;
                          paramString1 = paramString3;
                          break label6534;
                        }
                        paramString1 = paramContext.getString(R.l.app_finder_endorsement) + paramContext.getString(R.l.finder_endorsement_desc);
                        paramPString1.value = paramString1;
                        paramString3 = "";
                        localObject2 = null;
                        i = 0;
                        break label963;
                        paramString1 = paramContext.getString(R.l.app_finder_endorsement) + paramContext.getString(R.l.finder_endorsement_desc);
                        paramPString1.value = paramString1;
                        paramString3 = "";
                        localObject2 = null;
                        i = 0;
                        break label963;
                        str3 = "";
                        paramString1 = k.b.OQ(Util.processXml((String)localObject3));
                        if (paramString1 == null)
                        {
                          Log.e("MicroMsg.Notification.Wording", "decode msg content failed");
                          AppMethodBeat.o(227604);
                          return "";
                        }
                        paramString1 = (com.tencent.mm.plugin.game.luggage.f.a)paramString1.ar(com.tencent.mm.plugin.game.luggage.f.a.class);
                        if ((paramString1 != null) && (!Util.isNullOrNil(paramString1.nickName))) {
                          if (paramInt1 == 1) {
                            paramString1 = paramContext.getString(R.l.eGd, new Object[] { paramString1.nickName });
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
                            paramString3 = paramContext.getString(R.l.eGe, new Object[] { paramString1.nickName });
                            paramString1 = paramString3;
                            if (ab.QL(paramString2)) {
                              break label6811;
                            }
                            paramString1 = paramString3;
                            if (j != 0) {
                              break label6811;
                            }
                            paramPString2.value = str1;
                            paramString1 = paramString3;
                            break label6811;
                          }
                          localObject3 = "";
                          paramString1 = ((com.tencent.mm.plugin.patmsg.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.patmsg.a.b.class)).aUf(paramString3);
                          if (paramString1.Ezu.size() > 0)
                          {
                            paramPString1.value = ((PluginPatMsg)com.tencent.mm.kernel.h.ag(PluginPatMsg.class)).parseDisplayTemplate(((diu)paramString1.Ezu.getLast()).lqH, paramString2).result;
                            localObject2 = null;
                            i = 0;
                            paramString1 = paramString3;
                            paramString3 = (String)localObject3;
                            break label963;
                            paramString1 = k.b.OQ(Util.processXml((String)localObject3));
                            if (paramString1 == null)
                            {
                              Log.e("MicroMsg.Notification.Wording", "decode msg content failed");
                              AppMethodBeat.o(227604);
                              return "";
                            }
                            paramString1 = paramContext.getString(R.l.app_live) + paramString1.getTitle();
                            paramPString1.value = paramString1;
                            paramString3 = "";
                            localObject2 = null;
                            i = 0;
                            break label963;
                            str3 = "";
                            paramString3 = k.b.OQ(Util.processXml((String)localObject3));
                            if (paramString3 == null)
                            {
                              Log.e("MicroMsg.Notification.Wording", "decode msg content failed");
                              AppMethodBeat.o(227604);
                              return "";
                            }
                            if ((!ab.QL(paramString2)) && (j == 0)) {
                              paramPString2.value = str1;
                            }
                            paramString1 = paramContext.getString(R.l.app_finder_live);
                            paramString3 = (com.tencent.mm.plugin.findersdk.a.b)paramString3.ar(com.tencent.mm.plugin.findersdk.a.b.class);
                            if ((paramString3 != null) && (!Util.isNullOrNil(paramString3.ene().nickName))) {
                              paramString1 = paramString1 + paramContext.getString(R.l.finder_live_invite_feed_of_user, new Object[] { paramString3.ene().nickName });
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
                                }
                                str3 = "";
                                paramString1 = k.b.OQ(Util.processXml((String)localObject3));
                                if (paramString1 == null)
                                {
                                  Log.e("MicroMsg.Notification.Wording", "decode msg content failed");
                                  AppMethodBeat.o(227604);
                                  return "";
                                }
                                if ((!ab.QL(paramString2)) && (j == 0)) {
                                  paramPString2.value = str1;
                                }
                                paramString1 = (com.tencent.mm.plugin.findersdk.a.g)paramString1.ar(com.tencent.mm.plugin.findersdk.a.g.class);
                                if ((paramString1 != null) && (!Util.isNullOrNil(paramString1.eni().poiName)))
                                {
                                  paramString1 = "" + MMApplicationContext.getContext().getString(R.l.finder_poi_share_notification, new Object[] { paramString1.eni().poiName });
                                  if (str1.length() <= 0) {
                                    break label7421;
                                  }
                                }
                                label7421:
                                for (paramString3 = "%s: ".concat(String.valueOf(paramString1));; paramString3 = paramString1)
                                {
                                  paramPString1.value = paramString3;
                                  localObject2 = null;
                                  i = 0;
                                  paramString3 = str3;
                                  break;
                                  paramString1 = "" + paramContext.getString(R.l.finder_poi_share_notification_fallback);
                                  break label7354;
                                }
                                paramString1 = Util.processXml((String)localObject3);
                                localObject2 = k.b.OQ(paramString1);
                                if (localObject2 == null)
                                {
                                  Log.e("MicroMsg.Notification.Wording", "decode msg content failed");
                                  AppMethodBeat.o(227604);
                                  return "";
                                }
                                switch (((k.b)localObject2).type)
                                {
                                default: 
                                  paramString3 = paramContext.getString(R.l.app_app);
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
                                    if ((!ab.QL(paramString2)) && (j == 0)) {
                                      paramPString2.value = str1;
                                    }
                                    if (str1.length() <= 0) {
                                      break label7831;
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
                                    break label7755;
                                  }
                                case 2: 
                                  localObject3 = paramContext.getString(R.l.app_pic);
                                  if (str1.length() > 0)
                                  {
                                    paramString1 = str1 + ": ";
                                    if ((!ab.QL(paramString2)) && (j == 0)) {
                                      paramPString2.value = str1;
                                    }
                                    if (str1.length() <= 0) {
                                      break label7935;
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
                                    break label7880;
                                  }
                                case 3: 
                                case 76: 
                                  localObject3 = paramContext.getString(R.l.app_music) + " " + ((k.b)localObject2).title;
                                  if (str1.length() > 0)
                                  {
                                    paramString1 = str1 + ": ";
                                    if ((!ab.QL(paramString2)) && (j == 0)) {
                                      paramPString2.value = str1;
                                    }
                                    if (str1.length() <= 0) {
                                      break label8067;
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
                                    break label8008;
                                  }
                                case 4: 
                                  localObject3 = paramContext.getString(R.l.app_video);
                                  if (str1.length() > 0)
                                  {
                                    paramString1 = str1 + ": ";
                                    if ((!ab.QL(paramString2)) && (j == 0)) {
                                      paramPString2.value = str1;
                                    }
                                    if (str1.length() <= 0) {
                                      break label8172;
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
                                    break label8113;
                                  }
                                case 6: 
                                case 74: 
                                  localObject3 = paramContext.getString(R.l.app_file);
                                  if (str1.length() > 0)
                                  {
                                    paramString1 = str1 + ": ";
                                    if ((!ab.QL(paramString2)) && (j == 0)) {
                                      paramPString2.value = str1;
                                    }
                                    if (str1.length() <= 0) {
                                      break label8277;
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
                                    break label8218;
                                  }
                                case 7: 
                                  localObject3 = paramContext.getString(R.l.app_app);
                                  if (str1.length() > 0)
                                  {
                                    paramString1 = str1 + ": ";
                                    if ((!ab.QL(paramString2)) && (j == 0)) {
                                      paramPString2.value = str1;
                                    }
                                    if (str1.length() <= 0) {
                                      break label8378;
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
                                    break label8323;
                                  }
                                case 5: 
                                  localObject3 = paramContext.getString(R.l.app_url);
                                  if (str1.length() > 0)
                                  {
                                    paramString1 = str1 + ": ";
                                    if ((!ab.QL(paramString2)) && (j == 0) && (!ab.QU(paramString2))) {
                                      paramPString2.value = str1;
                                    }
                                    if (str1.length() <= 0) {
                                      break label8490;
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
                                    break label8424;
                                  }
                                case 46: 
                                  paramString3 = paramContext.getString(R.l.app_app);
                                  localObject2 = null;
                                  i = 0;
                                  paramString1 = "";
                                  break;
                                case 33: 
                                case 36: 
                                  localObject3 = "";
                                  paramString3 = paramContext.getString(R.l.app_brand_default_name_with_brackets);
                                  if (str1.length() > 0)
                                  {
                                    paramString1 = str1 + ": " + paramString3 + ((k.b)localObject2).title;
                                    if ((!ab.QL(paramString2)) && (j == 0) && (!ab.QU(paramString2))) {
                                      paramPString2.value = str1;
                                    }
                                    if (str1.length() <= 0) {
                                      break label8676;
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
                                    break label8572;
                                  }
                                case 44: 
                                  if (((k.b)localObject2).fX(false))
                                  {
                                    localObject3 = "";
                                    paramString3 = ((k.b)localObject2).z(paramContext, true);
                                    if (!Util.isNullOrNil(paramString3))
                                    {
                                      if (str1.length() > 0)
                                      {
                                        paramString1 = str1 + ": " + paramString3 + ((k.b)localObject2).title;
                                        paramPString2.value = str1;
                                        if (str1.length() <= 0) {
                                          break label8858;
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
                                        break label8773;
                                      }
                                    }
                                    paramString3 = paramContext.getString(R.l.app_app);
                                    localObject2 = null;
                                    i = 0;
                                    paramString1 = "";
                                    break;
                                  }
                                  paramString3 = paramContext.getString(R.l.app_app);
                                  localObject2 = null;
                                  i = 0;
                                  paramString1 = "";
                                  break;
                                case 8: 
                                  paramString3 = paramContext.getString(R.l.app_emoji2);
                                  if (str1.length() > 0) {}
                                  for (paramString1 = str1 + ": ";; paramString1 = "")
                                  {
                                    if ((!ab.QL(paramString2)) && (j == 0)) {
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
                                  paramString3 = paramContext.getString(R.l.app_emoji_share);
                                  if (str1.length() > 0) {}
                                  for (paramString1 = str1 + ": ";; paramString1 = "")
                                  {
                                    if ((!ab.QL(paramString2)) && (j == 0)) {
                                      paramPString2.value = str1;
                                    }
                                    paramPString1.value = "";
                                    localObject2 = null;
                                    i = 0;
                                    break;
                                  }
                                case 25: 
                                  paramString3 = paramContext.getString(R.l.app_designer_share);
                                  if (str1.length() > 0) {}
                                  for (paramString1 = str1 + ": ";; paramString1 = "")
                                  {
                                    if ((!ab.QL(paramString2)) && (j == 0)) {
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
                                    if ((!ab.QL(paramString2)) && (j == 0)) {
                                      paramPString2.value = str1;
                                    }
                                    if (str1.length() <= 0) {
                                      break label9284;
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
                                    break label9208;
                                  }
                                case 19: 
                                  localObject3 = paramContext.getString(R.l.app_record);
                                  if (str1.length() > 0)
                                  {
                                    paramString1 = str1 + ": ";
                                    if ((!ab.QL(paramString2)) && (j == 0)) {
                                      paramPString2.value = str1;
                                    }
                                    if (str1.length() <= 0) {
                                      break label9388;
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
                                    break label9333;
                                  }
                                case 24: 
                                  paramString1 = "";
                                  if (!Util.isNullOrNil(((k.b)localObject2).description))
                                  {
                                    i = ((k.b)localObject2).description.indexOf("\n");
                                    paramString1 = ((k.b)localObject2).description;
                                    if (i > 0) {
                                      paramString1 = paramString1.substring(0, i);
                                    }
                                  }
                                  else
                                  {
                                    localObject3 = paramContext.getString(R.l.favorite_wenote_msg) + paramString1;
                                    if (str1.length() <= 0) {
                                      break label9559;
                                    }
                                    paramString1 = str1 + ": ";
                                    if ((!ab.QL(paramString2)) && (j == 0)) {
                                      paramPString2.value = str1;
                                    }
                                    if (str1.length() <= 0) {
                                      break label9565;
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
                                    break label9432;
                                    paramString1 = "";
                                    break label9497;
                                  }
                                case 16: 
                                  localObject3 = "";
                                  paramString3 = paramContext.getString(R.l.card_msg_item_digest);
                                  if (str1.length() > 0)
                                  {
                                    paramString1 = str1 + ": " + paramString3 + ((k.b)localObject2).title;
                                    if ((!ab.QL(paramString2)) && (j == 0)) {
                                      paramPString2.value = str1;
                                    }
                                    if (str1.length() <= 0) {
                                      break label9708;
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
                                    break label9626;
                                  }
                                case 34: 
                                  localObject3 = "";
                                  paramString1 = paramContext.getString(R.l.card_msg_item_digest);
                                  if (paramInt1 == 1)
                                  {
                                    paramString3 = paramString1 + ((k.b)localObject2).lnr;
                                    if (str1.length() > 0) {}
                                    for (paramString1 = "%s: ".concat(String.valueOf(paramString3));; paramString1 = String.valueOf(paramString3))
                                    {
                                      paramPString1.value = paramString1;
                                      paramString1 = paramString3;
                                      if (ab.QL(paramString2)) {
                                        break label12044;
                                      }
                                      paramString1 = paramString3;
                                      if (j != 0) {
                                        break label12044;
                                      }
                                      paramPString2.value = str1;
                                      localObject2 = null;
                                      i = 0;
                                      paramString1 = paramString3;
                                      paramString3 = (String)localObject3;
                                      break;
                                    }
                                  }
                                  paramString3 = paramString1 + ((k.b)localObject2).lnq;
                                  if (str1.length() > 0) {}
                                  for (paramString1 = "%s: ".concat(String.valueOf(paramString3));; paramString1 = String.valueOf(paramString3))
                                  {
                                    paramPString1.value = paramString1;
                                    break;
                                  }
                                case 40: 
                                  if (t.OV(paramString1).lpH == 19)
                                  {
                                    localObject3 = paramContext.getString(R.l.app_record);
                                    localObject2 = null;
                                    i = 0;
                                    paramString1 = paramString3;
                                    paramString3 = (String)localObject3;
                                    break;
                                  }
                                  localObject3 = paramContext.getString(R.l.app_app);
                                  localObject2 = null;
                                  i = 0;
                                  paramString1 = paramString3;
                                  paramString3 = (String)localObject3;
                                  break;
                                case 68: 
                                  label7755:
                                  label7935:
                                  localObject3 = "";
                                  label8172:
                                  label8572:
                                  paramString3 = paramContext.getString(R.l.app_app);
                                  label8277:
                                  label8424:
                                  label9208:
                                  if (str1.length() > 0)
                                  {
                                    paramString1 = str1 + ": " + paramString3 + ((k.b)localObject2).title;
                                    if ((!ab.QL(paramString2)) && (j == 0) && (!ab.QU(paramString2))) {
                                      paramPString2.value = str1;
                                    }
                                    if (str1.length() <= 0) {
                                      break label10105;
                                    }
                                  }
                                  label8676:
                                  label9333:
                                  label10105:
                                  for (paramString3 = "%s: " + paramString3 + ((k.b)localObject2).title;; paramString3 = paramString3 + ((k.b)localObject2).title)
                                  {
                                    paramPString1.value = paramString3;
                                    localObject2 = null;
                                    i = 0;
                                    paramString3 = (String)localObject3;
                                    break;
                                    paramString1 = paramString3 + ((k.b)localObject2).title;
                                    break label10001;
                                  }
                                  label9432:
                                  label9565:
                                  label9708:
                                  paramString1 = paramString3;
                                  label9559:
                                  if (k != 0) {
                                    paramString1 = JY(paramString3);
                                  }
                                  paramString3 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.biz.a.a.class)).OU(paramString1);
                                  paramString1 = paramString3;
                                  if (k != 0) {
                                    paramString1 = JX(paramString3);
                                  }
                                  paramString1 = com.tencent.mm.pluginsdk.ui.span.l.brD(paramString1);
                                  paramPString1.value = paramString1;
                                  paramString3 = "";
                                  localObject2 = null;
                                  i = 0;
                                  break;
                                  paramPString1.value = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.biz.a.a.class)).OT(paramString3);
                                  paramString3 = paramPString1.value;
                                  Log.i("MicroMsg.Notification.Wording", "[parseMsgContentToShow] type:%s suffix:%s", new Object[] { Integer.valueOf(318767153), paramString3 });
                                  localObject2 = null;
                                  i = 0;
                                  paramString1 = "";
                                  break;
                                  paramString1 = com.tencent.mm.ap.a.b(a.a.Vp(paramString3));
                                  paramPString1.value = paramString1;
                                  paramString3 = "";
                                  localObject2 = null;
                                  i = 0;
                                  break;
                                  paramString3 = "";
                                  localObject2 = k.b.OQ((String)localObject3);
                                  paramString1 = paramString3;
                                  if (localObject2 == null) {
                                    break label954;
                                  }
                                  paramString1 = paramString3;
                                  try
                                  {
                                    paramString3 = URLDecoder.decode(((k.b)localObject2).content, "UTF-8");
                                    paramString1 = paramString3;
                                    paramString3 = com.tencent.mm.pluginsdk.ui.span.l.brD(paramString3);
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
                                        continue;
                                      }
                                    }
                                    paramString3 = paramString3;
                                  }
                                }
                              }
                              Log.printErrStackTrace("MicroMsg.Notification.Wording", paramString3, "", new Object[0]);
                              paramString3 = "";
                              localObject2 = null;
                              i = 0;
                              break label963;
                              paramString1 = ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.a.e.class)).aOg(paramString3);
                              if (paramString1 != null) {}
                              for (paramString3 = paramString1.toString();; paramString3 = "")
                              {
                                paramString1 = paramString3;
                                if (paramBoolean1)
                                {
                                  paramString1 = paramString3;
                                  if (ab.Lj(paramString2))
                                  {
                                    paramString1 = paramString3;
                                    if (paramString3.endsWith(paramContext.getString(R.l.eum)))
                                    {
                                      Log.i("MicroMsg.Notification.Wording", "conv.getDigest() : %s", new Object[] { paramString3 });
                                      paramString1 = paramString3.substring(0, paramString3.length() - paramContext.getString(R.l.eum).length());
                                    }
                                  }
                                }
                                paramPString1.value = paramString1;
                                paramString3 = "";
                                localObject2 = null;
                                i = 0;
                                break;
                              }
                              paramString3 = com.tencent.mm.aj.b.c.Pb(paramString3).content;
                              paramString1 = paramString3;
                              if (Util.isNullOrNil(paramString3)) {
                                paramString1 = "";
                              }
                              paramPString1.value = paramString1;
                              paramString3 = "";
                              localObject2 = null;
                              i = 0;
                              break label963;
                              paramString1 = paramContext.getString(R.l.eOI);
                              paramPString1.value = paramString1;
                              paramString3 = "";
                              localObject2 = null;
                              i = 0;
                              break label963;
                              paramString1 = com.tencent.mm.aj.b.a.OY(paramString3);
                              if ((Util.isNullOrNil(paramString1.nickname)) || (Util.isNullOrNil(paramString1.title))) {}
                              for (paramString1 = "";; paramString1 = String.format(Locale.US, "%s: %s", new Object[] { paramString1.nickname, paramString1.title }))
                              {
                                paramPString1.value = paramString1;
                                paramString3 = "";
                                localObject2 = null;
                                i = 0;
                                break;
                              }
                              str3 = "";
                              paramString3 = k.b.OQ(Util.processXml((String)localObject3));
                              if (paramString3 == null)
                              {
                                Log.e("MicroMsg.Notification.Wording", "decode msg content failed");
                                AppMethodBeat.o(227604);
                                return "";
                              }
                              if ((!ab.QL(paramString2)) && (j == 0)) {
                                paramPString2.value = str1;
                              }
                              paramString1 = paramContext.getString(R.l.app_finder);
                              paramString3 = (com.tencent.mm.plugin.findersdk.a.h)paramString3.ar(com.tencent.mm.plugin.findersdk.a.h.class);
                              if ((paramString3 != null) && (!Util.isNullOrNil(paramString3.enf().topic)))
                              {
                                if (paramString3.enf().wXA == 1)
                                {
                                  paramString1 = paramString1 + MMApplicationContext.getContext().getString(R.l.finder_topic_card_prefix, new Object[] { paramString3.enf().topic });
                                  if (str1.length() <= 0) {
                                    break label10841;
                                  }
                                }
                                label10841:
                                for (paramString3 = "%s: ".concat(String.valueOf(paramString1));; paramString3 = paramString1)
                                {
                                  paramPString1.value = paramString3;
                                  localObject2 = null;
                                  i = 0;
                                  paramString3 = str3;
                                  break;
                                  paramString1 = paramString1 + paramString3.enf().topic;
                                  break label10776;
                                }
                                str3 = "";
                                paramString3 = k.b.OQ(Util.processXml((String)localObject3));
                                if (paramString3 == null)
                                {
                                  Log.e("MicroMsg.Notification.Wording", "decode MM_DATA_APPMSG_FINDER_AGGREATE_ACTIVITY msg content failed");
                                  AppMethodBeat.o(227604);
                                  return "";
                                }
                                if ((!ab.QL(paramString2)) && (j == 0)) {
                                  paramPString2.value = str1;
                                }
                                paramString1 = paramContext.getString(R.l.app_finder);
                                paramString3 = (com.tencent.mm.plugin.findersdk.a.c)paramString3.ar(com.tencent.mm.plugin.findersdk.a.c.class);
                                if ((paramString3 != null) && (!Util.isNullOrNil(paramString3.enf().topic)) && (paramString3.enf().wXA == 7) && (paramString3.enf().STw != null))
                                {
                                  paramString1 = paramString1 + MMApplicationContext.getContext().getString(R.l.finder_activity_share_conversation_wording, new Object[] { paramString3.enf().STw.SCS, paramString3.enf().STw.SCR });
                                  if (str1.length() > 0) {}
                                  for (paramString3 = "%s: ".concat(String.valueOf(paramString1));; paramString3 = paramString1)
                                  {
                                    paramPString1.value = paramString3;
                                    localObject2 = null;
                                    i = 0;
                                    paramString3 = str3;
                                    break;
                                  }
                                  paramString1 = Util.nullAsNil((String)XmlParser.parseXml((String)localObject3, "msg", null).get(".msg.appmsg.extinfo.notifymsg.preview.content"));
                                  paramPString1.value = paramString1;
                                  AppMethodBeat.o(227604);
                                  return paramString1;
                                  label11096:
                                  paramString1 = paramString1.split("@bottle:");
                                  if (paramString1.length > 1)
                                  {
                                    paramPString1.value = paramString1[1];
                                    paramString1 = paramString1[1];
                                    AppMethodBeat.o(227604);
                                    return paramString1;
                                  }
                                  paramPString1.value = "";
                                  AppMethodBeat.o(227604);
                                  return null;
                                  paramString2 = null;
                                  paramPString2 = null;
                                  paramContext = paramString1.split(":");
                                  if ((paramContext == null) || (paramContext.length <= 0))
                                  {
                                    paramPString1.value = "";
                                    AppMethodBeat.o(227604);
                                    return null;
                                  }
                                  paramContext = paramContext[0];
                                  if (!Util.isNullOrNil(paramContext))
                                  {
                                    bh.beI();
                                    paramPInt = com.tencent.mm.model.c.bbL().RG(paramContext);
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
                                  if (!Util.isNullOrNil(paramString3))
                                  {
                                    paramPString1.value = (paramString2 + ": " + paramString3);
                                    paramString1 = paramString2 + ": " + paramString3;
                                    AppMethodBeat.o(227604);
                                    return paramString1;
                                  }
                                  paramString1 = paramString1.split("@bottle:");
                                  if (paramString1.length > 1)
                                  {
                                    paramPString1.value = (paramString2 + ": " + paramString1[1]);
                                    paramString1 = paramString2 + ": " + paramString1[1];
                                    AppMethodBeat.o(227604);
                                    return paramString1;
                                  }
                                  paramPString1.value = paramString2;
                                  AppMethodBeat.o(227604);
                                  return paramString2;
                                  if (Util.isNullOrNil(paramString1)) {
                                    paramPString1.value = "";
                                  }
                                  if (!Util.isNullOrNil(str1))
                                  {
                                    paramString2 = paramString1;
                                    if (str2 != null)
                                    {
                                      paramString2 = paramString1;
                                      if (str2.length() > 0) {
                                        paramString2 = f(paramString1, str1, str2);
                                      }
                                    }
                                    if (Util.isNullOrNil(paramPString2.value))
                                    {
                                      paramPString1.value = f(paramPString1.value, str1, "%s");
                                      paramPString2.value = str1;
                                    }
                                    paramString1 = o.La(paramString2);
                                    paramPString1.value = o.La(paramPString1.value);
                                    paramString2 = paramString1 + paramString3;
                                    paramPString1.value += paramString3;
                                    if ((paramBoolean1) && (!a(paramInt2, paramPString1, paramString2, paramString3))) {
                                      a(paramInt2, paramPString1, paramPString2, paramPInt);
                                    }
                                    paramString1 = paramString2;
                                    if (i != 0) {
                                      paramString1 = paramString2.concat(" " + Util.nullAsNil((String)localObject2));
                                    }
                                    paramString1 = Util.nullAsNil(paramString1);
                                    AppMethodBeat.o(227604);
                                    return paramString1;
                                  }
                                  if ((ab.QL(paramString2)) || (j != 0) || (ab.QU(paramString2)))
                                  {
                                    str1 = paramString1;
                                    if (paramString3 != null)
                                    {
                                      str1 = paramString1;
                                      if (paramString3.length() > 0) {
                                        str1 = paramString3;
                                      }
                                    }
                                    if (Util.isNullOrNil(str1))
                                    {
                                      paramPString1.value = "";
                                      paramPString2.value = "";
                                      AppMethodBeat.o(227604);
                                      return "";
                                    }
                                    if (paramInt1 == 0)
                                    {
                                      paramPString1.value = "%s:".concat(String.valueOf(str1));
                                      if (!paramBoolean1) {
                                        break label11949;
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
                                      paramString1 = JY(paramString3);
                                    }
                                    if ((!Util.isNullOrNil(paramString4)) && (com.tencent.mm.ao.g.Ux(paramString2)))
                                    {
                                      paramString2 = af.bju().UI(paramString4);
                                      if ((paramString2 != null) && (!Util.isNullOrNil(paramString2.field_openId)) && (!Util.isNullOrNil(paramString2.field_nickname)) && ((paramInt3 == 2) || (paramString2.field_kfType == 2)))
                                      {
                                        paramPString1.value = ("%s:" + paramPString1.value);
                                        paramPString2.value = paramString2.field_nickname;
                                      }
                                    }
                                    paramString1 = Util.nullAsNil(paramString1);
                                    AppMethodBeat.o(227604);
                                    return paramString1;
                                    paramPString1.value = (paramContext.getString(R.l.app_me) + ":" + str1);
                                    break;
                                    paramString1 = aa.PJ(paramPString2.value) + ":" + str1;
                                    AppMethodBeat.o(227604);
                                    return paramString1;
                                    if ((paramString3 == null) || (paramString3.length() <= 0)) {
                                      break label12033;
                                    }
                                    paramPString1.value = paramString3;
                                    paramString1 = paramString3;
                                    if (paramBoolean1)
                                    {
                                      a(paramInt2, paramPString1, paramPString2, paramPInt);
                                      paramString1 = paramString3;
                                    }
                                  }
                                }
                              }
                              paramString3 = "";
                              localObject2 = null;
                              i = 0;
                              break label963;
                            }
                          }
                          localObject2 = null;
                          i = 0;
                          paramString1 = paramString3;
                          paramString3 = (String)localObject3;
                          break label963;
                          paramString1 = "";
                        }
                        paramString1 = "";
                      }
                    }
                  }
                }
              }
            }
            label8113:
            label8378:
            label8773:
            paramString1 = paramString2;
            label8490:
            label9284:
            break label2528;
            label9388:
            label11949:
            label12099:
            paramString1 = paramString2;
          }
          label6811:
          label12114:
          j = i;
        }
        label8858:
        localObject3 = paramString3;
        label9497:
        str2 = "";
        label10001:
        label10776:
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
      paramPString1.value = paramPString1.value.substring(0, Y(paramPString1.value, 150));
    }
    TextPaint localTextPaint = arx();
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
  
  private static boolean a(int paramInt, PString paramPString, String paramString1, String paramString2)
  {
    AppMethodBeat.i(227618);
    if (((paramPString.value.length() == 32) || (Util.isEqual(paramPString.value, paramString2))) && ((paramInt == 47) || (paramInt == 1048625)))
    {
      paramPString.value = paramString1;
      AppMethodBeat.o(227618);
      return true;
    }
    AppMethodBeat.o(227618);
    return false;
  }
  
  private static int arv()
  {
    AppMethodBeat.i(169682);
    if (iTj > 0)
    {
      i = iTj;
      AppMethodBeat.o(169682);
      return i;
    }
    int i = BackwardSupportUtil.BitmapFactory.fromDPToPix(MMApplicationContext.getContext(), 14.0F);
    AppMethodBeat.o(169682);
    return i;
  }
  
  private static int arw()
  {
    AppMethodBeat.i(20087);
    if (iTi > 0)
    {
      i = iTi;
      AppMethodBeat.o(20087);
      return i;
    }
    int i = BackwardSupportUtil.BitmapFactory.fromDPToPix(MMApplicationContext.getContext(), 200.0F);
    AppMethodBeat.o(20087);
    return i;
  }
  
  private static TextPaint arx()
  {
    AppMethodBeat.i(20089);
    if (iTh == null)
    {
      AppMethodBeat.o(20089);
      return null;
    }
    TextPaint localTextPaint = (TextPaint)iTh.get();
    AppMethodBeat.o(20089);
    return localTextPaint;
  }
  
  public static String b(ca paramca, PString paramPString1, PString paramPString2, PInt paramPInt, boolean paramBoolean)
  {
    AppMethodBeat.i(20074);
    String str;
    if (paramca.hzx())
    {
      str = paramca.hAm();
      if (!paramca.hwA()) {
        break label90;
      }
    }
    for (paramca = com.tencent.mm.pluginsdk.ui.span.l.brD(a(paramca.field_imgPath, paramca.field_isSend, paramca.field_talker, str, paramca.getType(), MMApplicationContext.getContext(), paramPString1, paramPString2, paramPInt, true, paramBoolean, paramca.ilp, paramca.ilv));; paramca = a(paramca.field_imgPath, paramca.field_isSend, paramca.field_talker, str, paramca.getType(), MMApplicationContext.getContext(), paramPString1, paramPString2, paramPInt, true, paramBoolean, paramca.ilp, paramca.ilv))
    {
      paramca = Util.nullAsNil(paramca);
      AppMethodBeat.o(20074);
      return paramca;
      str = paramca.field_content;
      break;
      label90:
      str = com.tencent.mm.pluginsdk.ui.span.l.brD(str);
    }
  }
  
  public static void b(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(20090);
    if ((iTh == null) || (iTh.get() == null)) {
      iTh = new WeakReference(paramTextPaint);
    }
    AppMethodBeat.o(20090);
  }
  
  public static boolean b(String paramString, ca paramca)
  {
    AppMethodBeat.i(20070);
    if ((paramca != null) && (paramca.field_bizChatId != -1L) && (com.tencent.mm.ao.g.KI(paramString)))
    {
      AppMethodBeat.o(20070);
      return true;
    }
    AppMethodBeat.o(20070);
    return false;
  }
  
  private static String cl(Context paramContext)
  {
    AppMethodBeat.i(20078);
    boolean bool = z.bdA();
    bh.beI();
    long l = Util.nullAs((Long)com.tencent.mm.model.c.aHp().b(65793, null), 0L);
    if (!bool)
    {
      paramContext = paramContext.getString(R.l.settings_plugins_disable);
      AppMethodBeat.o(20078);
      return paramContext;
    }
    if (l == 0L)
    {
      paramContext = paramContext.getString(R.l.eFJ);
      AppMethodBeat.o(20078);
      return paramContext;
    }
    if (Util.secondsToNow(l) * 1000L > 1209600000L)
    {
      paramContext = paramContext.getString(R.l.eFI, new Object[] { Long.valueOf(Util.secondsToNow(l) * 1000L / 86400000L) });
      AppMethodBeat.o(20078);
      return paramContext;
    }
    AppMethodBeat.o(20078);
    return "";
  }
  
  public static String d(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(20091);
    paramString = com.tencent.mm.cl.b.htF().buu(paramString);
    if (paramBoolean)
    {
      AppMethodBeat.o(20091);
      return paramString;
    }
    paramContext = paramContext.getString(R.l.intro_title);
    AppMethodBeat.o(20091);
    return paramContext;
  }
  
  public static String e(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(20093);
    if (paramBoolean)
    {
      paramContext = com.tencent.mm.cl.b.htF().buu(paramString);
      AppMethodBeat.o(20093);
      return paramContext;
    }
    paramContext = paramContext.getString(R.l.eNG);
    AppMethodBeat.o(20093);
    return paramContext;
  }
  
  public static String f(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(20072);
    if (ab.Lj(paramString1))
    {
      paramString2 = bq.RL(paramString2);
      if (paramString2 != null) {
        paramString2 = aa.PJ(paramString2.trim());
      }
    }
    while (paramString1.contains("@bottle"))
    {
      paramContext = paramContext.getResources().getQuantityString(R.j.emm, 1, new Object[] { Integer.valueOf(1) });
      AppMethodBeat.o(20072);
      return paramContext;
      paramString2 = aa.PJ(paramString1);
      continue;
      paramString2 = aa.PJ(paramString1);
    }
    String str = paramString2;
    if (Util.isNullOrNil(paramString2))
    {
      str = paramString2;
      if (ab.Lj(paramString1)) {
        str = paramContext.getString(R.l.ewS);
      }
    }
    paramContext = com.tencent.mm.cl.b.htF().buu(str);
    AppMethodBeat.o(20072);
    return paramContext;
  }
  
  private static String f(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(20080);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)) || (Util.isNullOrNil(paramString3)))
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
  
  public static void qr(int paramInt)
  {
    iTi = paramInt;
  }
  
  public static void qs(int paramInt)
  {
    iTj = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.booter.notification.a.h
 * JD-Core Version:    0.7.0.1
 */