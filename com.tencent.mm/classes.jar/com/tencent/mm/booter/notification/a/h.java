package com.tencent.mm.booter.notification.a;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import com.tencent.mm.R.j;
import com.tencent.mm.R.l;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.ae.k;
import com.tencent.mm.aj.a.a;
import com.tencent.mm.compatible.util.o;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.ap;
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
  private static WeakReference<TextPaint> dkx;
  private static int dky = 0;
  private static int dkz = 0;
  public String dkv = "";
  public String dkw = "";
  public String mTitle = "";
  
  public static String a(int paramInt1, String paramString1, String paramString2, int paramInt2, Context paramContext)
  {
    return bk.pm(a(null, paramInt1, paramString1, paramString2, paramInt2, paramContext, new PString(), new PString(), new PInt(), false, false));
  }
  
  private static String a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, PString paramPString1, PString paramPString2)
  {
    String str3 = "";
    String str2;
    String str1;
    int i;
    if ((s.hq(paramString1)) || (s.hs(paramString1)))
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
            if (!ad.aaR(paramString1))
            {
              str2 = str3;
              str1 = paramString2;
              if (!ad.aaT(paramString1)) {}
            }
            else
            {
              str2 = r.gV(paramString1);
              paramPString2.value = paramString1;
              str1 = paramString2.substring(i + 1);
            }
          }
        }
      }
      if (bk.pm(str2).length() > 0) {
        break label283;
      }
      if (paramString3 != null) {
        break label276;
      }
    }
    for (;;)
    {
      paramPString1.value = str1;
      return paramPString1.value;
      if (!ad.aaR(paramString1))
      {
        str2 = str3;
        str1 = paramString2;
        if (!ad.aaT(paramString1)) {
          break;
        }
      }
      r.gV(paramString1);
      paramPString2.value = paramString1;
      if (paramInt == 1)
      {
        paramContext = new StringBuilder().append(paramContext.getString(R.l.fmt_response_to, new Object[] { "" }));
        if (paramString3 == null) {}
        for (;;)
        {
          paramPString1.value = paramString2;
          paramPString2.value = "";
          return paramPString1.value;
          paramString2 = paramString3;
        }
      }
      if (paramString3 == null) {}
      for (;;)
      {
        paramPString1.value = paramString2;
        paramPString2.value = "";
        return paramPString1.value;
        paramString2 = paramString3;
      }
      label276:
      str1 = paramString3;
    }
    label283:
    paramString1 = new StringBuilder();
    if (paramInt == 1)
    {
      i = R.l.fmt_response_to;
      paramString2 = paramString1.append(paramContext.getString(i));
      if (paramString3 != null) {
        break label392;
      }
      paramString1 = str1;
      label320:
      paramPString1.value = paramString1;
      paramString1 = new StringBuilder();
      if (paramInt != 1) {
        break label398;
      }
      paramInt = R.l.fmt_response_to;
      label350:
      paramContext = paramString1.append(paramContext.getString(paramInt, new Object[] { str2 }));
      if (paramString3 != null) {
        break label405;
      }
    }
    for (;;)
    {
      return str1;
      i = R.l.fmt_send_from;
      break;
      label392:
      paramString1 = paramString3;
      break label320;
      label398:
      paramInt = R.l.fmt_send_from;
      break label350;
      label405:
      str1 = paramString3;
    }
  }
  
  public static String a(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      String str = com.tencent.mm.cd.b.csC().aat(paramString);
      paramString = str;
      if (paramInt3 > 1) {
        paramString = paramContext.getResources().getQuantityString(R.j.notification_fmt_multi_msg_and_one_talker_pre, paramInt3, new Object[] { Integer.valueOf(paramInt3) }) + str;
      }
      return paramString;
    }
    return paramContext.getResources().getQuantityString(R.j.notification_fmt_multi_msg_and_talker, paramInt1, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    paramContext = a(0, paramString2, paramString1, paramInt, paramContext);
    return j.WQ(com.tencent.mm.cd.b.csC().aat(paramContext));
  }
  
  private static String a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, Context paramContext, PString paramPString1, PString paramPString2, PInt paramPInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool;
    label29:
    int i;
    if (paramContext != null)
    {
      bool = true;
      Assert.assertTrue("context is null", bool);
      if ((paramString2 == null) || (paramString2.length() <= 0)) {
        break label77;
      }
      bool = true;
      Assert.assertTrue("username is null", bool);
      if (paramBoolean1) {
        break label144;
      }
      if ((!s.hq(paramString2)) || (com.tencent.mm.model.q.GB())) {
        break label83;
      }
      i = 1;
    }
    for (;;)
    {
      if (i == 0) {
        break label144;
      }
      return paramContext.getString(R.l.settings_plugins_disable);
      bool = false;
      break;
      label77:
      bool = false;
      break label29;
      label83:
      if (s.hs(paramString2))
      {
        if ((com.tencent.mm.model.q.Gn() & 0x40) != 0) {}
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label119;
          }
          i = 1;
          break;
        }
      }
      label119:
      if ((s.hw(paramString2)) && (!com.tencent.mm.model.q.GE())) {
        i = 1;
      } else {
        i = 0;
      }
    }
    label144:
    if (s.hw(paramString2))
    {
      if (paramBoolean1) {
        return "";
      }
      paramBoolean1 = com.tencent.mm.model.q.GE();
      au.Hx();
      long l = bk.a((Long)c.Dz().get(65793, null), 0L);
      if (!paramBoolean1) {
        return paramContext.getString(R.l.settings_plugins_disable);
      }
      if (l == 0L) {
        return paramContext.getString(R.l.fmt_qqsynchelper_brief_new);
      }
      if (bk.cn(l) * 1000L > 1209600000L) {
        return paramContext.getString(R.l.fmt_qqsynchelper_brief_alert, new Object[] { Long.valueOf(bk.cn(l) * 1000L / 86400000L) });
      }
      return "";
    }
    if ((paramString3 != null) && (paramBoolean1)) {
      paramString3 = eF(paramString3);
    }
    for (int k = 1;; k = 0)
    {
      paramPString1.value = paramString3;
      String str1;
      String str2;
      Object localObject2;
      if ((paramInt1 == 0) && ((s.fn(paramString2)) || (s.hb(paramString2))))
      {
        i = com.tencent.mm.model.bd.iH(paramString3);
        if (i > 0)
        {
          str1 = paramString3.substring(0, i).trim();
          str2 = r.getDisplayName(str1, paramString2);
          localObject2 = (paramString3 + " ").substring(i + 1);
        }
      }
      for (;;)
      {
        i = 0;
        Object localObject1;
        int j;
        if ((s.hK(paramString2)) || (s.hT(paramString2)))
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
            label862:
            label871:
            label1018:
            do
            {
              paramString3 = "";
              localObject1 = null;
              i = 0;
              for (;;)
              {
                if (!s.hr(paramString2)) {
                  break label6956;
                }
                if (1 != paramInt1) {
                  break label6702;
                }
                if (bk.bl(paramString3)) {
                  break label6667;
                }
                paramPString1.value = paramString3;
                return paramString3;
                au.Hx();
                localObject1 = c.FB().abv(paramString2);
                if (((localObject1 == null) || (!((ak)localObject1).gV(2097152))) && (!paramBoolean2)) {
                  break label7527;
                }
                i = 1;
                j = paramString3.indexOf(":");
                if (j == -1) {
                  break label7527;
                }
                paramPString2.value = paramString3.substring(0, j);
                paramString3 = paramString3.substring(j + 1);
                j = 1;
                break;
                localObject2 = paramContext.getString(R.l.app_pic);
                if (str1.length() > 0)
                {
                  paramString1 = str1 + ": ";
                  if (str1.length() <= 0) {
                    break label1054;
                  }
                }
                for (paramString3 = "%s: ";; paramString3 = "")
                {
                  paramPString1.value = paramString3;
                  localObject1 = null;
                  i = 0;
                  paramString3 = (String)localObject2;
                  break;
                  paramString1 = "";
                  break label1018;
                }
                localObject2 = ap.abP(paramString3);
                localObject1 = ((ap)localObject2).eHA + ": ";
                if ((paramString1 != null) && (paramString1.length() == 32)) {}
                for (paramString3 = paramString1;; paramString3 = paramContext.getString(R.l.app_emoji))
                {
                  paramPString1.value = "";
                  paramPString2.value = ((ap)localObject2).eHA;
                  localObject2 = null;
                  i = 0;
                  paramString1 = (String)localObject1;
                  localObject1 = localObject2;
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
                if ((ad.aaR(paramString2)) || (ad.aaT(paramString2)) || (s.hq(paramString2)) || (s.hs(paramString2)))
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
                      if (!s.hr(paramString2))
                      {
                        if (!s.fn(paramString2)) {
                          break label1371;
                        }
                        paramString3 = new n(paramString3);
                        paramString1 = paramString3.eHA + ": ";
                        paramPString1.value = "%s:";
                        paramPString2.value = paramString3.eHA;
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
                  if ((ad.aaR(paramString2)) || (ad.aaT(paramString2)) || (s.hq(paramString2)) || (s.hs(paramString2)))
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
                        if (!s.hr(paramString2))
                        {
                          if (!s.fn(paramString2)) {
                            break label1537;
                          }
                          paramString3 = new com.tencent.mm.modelvideo.q(paramString3);
                          paramString1 = paramString3.eHA + ": ";
                          paramPString1.value = "%s:";
                          paramPString2.value = paramString3.eHA;
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
                    if (paramString3.equals(bi.uBQ))
                    {
                      paramString3 = paramContext.getString(R.l.app_voip);
                      localObject1 = null;
                      i = 0;
                      paramString1 = "";
                    }
                    else
                    {
                      paramString1 = paramString3;
                      if (!paramString3.equals(bi.uBP)) {
                        break label862;
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
                        break label862;
                      }
                      paramString1 = paramString3;
                      if (paramString3.length() <= 0) {
                        break label862;
                      }
                      localObject1 = bi.d.acc(paramString3);
                      paramString1 = paramString3;
                      if (((bi.d)localObject1).pyp != null)
                      {
                        paramString1 = paramString3;
                        if (((bi.d)localObject1).pyp.length() <= 0) {}
                      }
                      switch (((bi.d)localObject1).scene)
                      {
                      case 19: 
                      case 20: 
                      case 21: 
                      default: 
                        paramString1 = paramContext.getString(R.l.fmt_want_to_be_your_friend, new Object[] { ((bi.d)localObject1).getDisplayName() });
                        paramPString1.value = paramString1;
                        paramString3 = "";
                        localObject1 = null;
                        i = 0;
                        break;
                      case 18: 
                        paramString1 = paramContext.getString(R.l.fmt_say_hello_to_you, new Object[] { ((bi.d)localObject1).getDisplayName() });
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
                        paramString1 = paramContext.getString(R.l.fmt_shake_say_hello_to_you, new Object[] { ((bi.d)localObject1).getDisplayName() });
                        paramString3 = "";
                        localObject1 = null;
                        i = 0;
                        break;
                      case 25: 
                        paramString1 = paramContext.getString(R.l.fmt_bottle_say_hello_to_you, new Object[] { ((bi.d)localObject1).getDisplayName() });
                        paramPString1.value = paramString1;
                        paramString3 = "";
                        localObject1 = null;
                        i = 0;
                        continue;
                        paramString1 = paramString3;
                        if (paramString3 == null) {
                          break label862;
                        }
                        paramString1 = paramString3;
                        if (paramString3.length() <= 0) {
                          break label862;
                        }
                        localObject1 = bi.a.abZ(paramString3);
                        paramString1 = paramString3;
                        if (((bi.a)localObject1).pyp != null)
                        {
                          paramString1 = paramString3;
                          if (((bi.a)localObject1).pyp.length() > 0)
                          {
                            paramString1 = paramContext.getString(R.l.fmt_just_reg_micromsg, new Object[] { ((bi.a)localObject1).getDisplayName() });
                            paramPString1.value = paramString1;
                          }
                        }
                        paramString3 = "";
                        localObject1 = null;
                        i = 0;
                        continue;
                        paramString1 = paramString3;
                        if (bk.pm(paramString3).length() <= 0) {
                          break label862;
                        }
                        au.Hx();
                        paramString1 = c.Fy().HL(paramString3);
                        paramString1 = paramContext.getString(R.l.fmt_qqmailhelper_brief, new Object[] { paramString1.eyU, paramString1.title });
                        paramPString1.value = paramString1;
                        paramString3 = "";
                        localObject1 = null;
                        i = 0;
                        continue;
                        paramString1 = paramString3;
                        if (bk.pm(paramString3).length() <= 0) {
                          break label862;
                        }
                        if (s.fn(paramString2))
                        {
                          localObject1 = com.tencent.mm.model.bd.iI(paramString3);
                          paramString1 = (String)localObject1;
                          if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
                        }
                        else
                        {
                          paramString1 = paramString2;
                        }
                        au.Hx();
                        localObject2 = c.Fy().HN(paramString3);
                        au.Hx();
                        localObject1 = c.Fw().abl(paramString1).Bq();
                        paramString3 = (String)localObject1;
                        if (s.fn((String)localObject1)) {
                          paramString3 = m.J(m.gN((String)localObject1));
                        }
                        if (paramInt1 == 1)
                        {
                          localObject1 = paramContext.getString(R.l.fmt_card_from, new Object[] { paramString3, ((bi.a)localObject2).getDisplayName() });
                          paramPString1.value = paramContext.getString(R.l.fmt_card_from, new Object[] { "%s", ((bi.a)localObject2).getDisplayName() });
                          paramPString2.value = paramString1;
                          paramString3 = "";
                          localObject2 = null;
                          i = 0;
                          paramString1 = (String)localObject1;
                          localObject1 = localObject2;
                        }
                        else
                        {
                          localObject1 = paramContext.getString(R.l.fmt_card_to, new Object[] { paramString3, ((bi.a)localObject2).getDisplayName() });
                          paramPString1.value = paramContext.getString(R.l.fmt_card_to, new Object[] { "%s", ((bi.a)localObject2).getDisplayName() });
                          paramPString2.value = paramString1;
                          paramString3 = "";
                          localObject2 = null;
                          i = 0;
                          paramString1 = (String)localObject1;
                          localObject1 = localObject2;
                        }
                        break;
                      }
                    }
                  }
                }
              }
              paramString1 = paramString3;
            } while (bk.pm(paramString3).length() <= 0);
            label1054:
            label1371:
            if (s.fn(paramString2))
            {
              i = com.tencent.mm.model.bd.iH(paramString3);
              if (i != -1)
              {
                paramString1 = paramString3.substring(0, i).trim();
                label2404:
                com.tencent.mm.model.bd.iJ(paramString3);
              }
            }
            label1537:
            break;
          }
          for (;;)
          {
            for (;;)
            {
              if (paramInt1 == 1)
              {
                paramString1 = paramContext.getString(R.l.location_conversation);
                paramPString1.value = paramString1;
                paramString3 = "";
                localObject1 = null;
                i = 0;
                break label871;
              }
              localObject1 = paramContext.getString(R.l.location_conversation);
              paramPString1.value = paramContext.getString(R.l.location_conversation);
              paramPString2.value = paramString1;
              paramString3 = "";
              localObject2 = null;
              i = 0;
              paramString1 = (String)localObject1;
              localObject1 = localObject2;
              break label871;
              paramString1 = g.a.gp(bk.ZQ((String)localObject2));
              if (paramString1.dQY != 0) {
                if (paramString1.dQY == 1) {
                  paramString1 = paramContext.getString(R.l.scan_product_type_conversation_book);
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
                if (paramString1.dQY == 2) {
                  paramString1 = paramContext.getString(R.l.scan_product_type_conversation_movie);
                } else if (paramString1.dQY == 3) {
                  paramString1 = paramContext.getString(R.l.scan_product_type_conversation_cd);
                } else {
                  paramString1 = paramContext.getString(R.l.scan_product_type_conversation_unknown);
                }
              }
              localObject1 = bk.ZQ((String)localObject2);
              paramString3 = "";
              paramString1 = "";
              localObject1 = g.a.gp((String)localObject1);
              if (localObject1 != null)
              {
                paramPString1.value = (paramContext.getString(R.l.scan_type_conversation_tv) + bk.pm(((g.a)localObject1).title));
                paramString1 = paramPString1.value;
              }
              paramPString2.value = str1;
              localObject1 = null;
              i = 0;
              break label871;
              localObject1 = bk.ZQ((String)localObject2);
              paramString3 = "";
              paramString1 = "";
              localObject1 = g.a.gp((String)localObject1);
              if (localObject1 != null)
              {
                if (paramInt1 != 1) {
                  break label2791;
                }
                i = 1;
                label2719:
                switch (((g.a)localObject1).dRE)
                {
                case 2: 
                default: 
                  paramPString1.value = bk.pm(((g.a)localObject1).title);
                }
              }
              for (;;)
              {
                paramString1 = paramPString1.value;
                paramPString2.value = str1;
                localObject1 = null;
                i = 0;
                break;
                label2791:
                i = 0;
                break label2719;
                if (i != 0)
                {
                  paramPString1.value = paramContext.getString(R.l.appmsg_remittance_digest_payer_wait);
                }
                else
                {
                  paramPString1.value = paramContext.getString(R.l.appmsg_remittance_digest_receiver_wait);
                  continue;
                  if (i != 0)
                  {
                    paramPString1.value = paramContext.getString(R.l.appmsg_remittance_digest_receiver_collected);
                  }
                  else
                  {
                    paramPString1.value = paramContext.getString(R.l.appmsg_remittance_digest_payer_collected);
                    continue;
                    if (i != 0) {
                      paramPString1.value = paramContext.getString(R.l.appmsg_remittance_digest_receiver_refused);
                    } else {
                      paramPString1.value = paramContext.getString(R.l.appmsg_remittance_digest_payer_refused);
                    }
                  }
                }
              }
              paramString3 = bk.ZQ((String)localObject2);
              localObject2 = "";
              paramString1 = "";
              paramString3 = g.a.gp(paramString3);
              if (paramString3 != null)
              {
                if (paramInt1 != 1) {
                  break label3022;
                }
                i = 1;
                label2938:
                if (i == 0) {
                  break label3028;
                }
                paramPString1.value = ("[" + paramString3.dSf + "]" + paramString3.dSc);
              }
              for (;;)
              {
                paramString1 = paramPString1.value;
                paramString3 = paramString1;
                if (s.hK(paramString2)) {
                  break label7499;
                }
                paramString3 = paramString1;
                if (j != 0) {
                  break label7499;
                }
                paramPString2.value = str1;
                localObject1 = null;
                i = 0;
                paramString3 = (String)localObject2;
                break;
                label3022:
                i = 0;
                break label2938;
                label3028:
                if (!bk.bl(str2)) {
                  paramPString1.value = (bk.pm(str2) + ": [" + paramString3.dSf + "]" + paramString3.dSb);
                } else {
                  paramPString1.value = ("[" + paramString3.dSf + "]" + paramString3.dSb);
                }
              }
              paramString1 = bk.ZQ((String)localObject2);
              localObject2 = "";
              paramString3 = "";
              paramString1 = g.a.gp(paramString1);
              if (paramString1 == null) {
                break label7499;
              }
              paramString1 = (com.tencent.mm.ae.b)paramString1.A(com.tencent.mm.ae.b.class);
              if (paramInt1 == 1)
              {
                i = 1;
                label3170:
                if (i == 0) {
                  break label3230;
                }
              }
              label3230:
              for (paramPString1.value = paramContext.getString(R.l.honey_pay_prefix, new Object[] { paramString1.dQf });; paramPString1.value = paramContext.getString(R.l.honey_pay_prefix, new Object[] { paramString1.dQg }))
              {
                paramString1 = paramPString1.value;
                paramPString2.value = str1;
                localObject1 = null;
                i = 0;
                paramString3 = (String)localObject2;
                break;
                i = 0;
                break label3170;
              }
              paramString3 = bk.ZQ((String)localObject2);
              paramString1 = "";
              paramString3 = g.a.gp(paramString3);
              if (paramString3 != null)
              {
                paramString1 = (j.a)paramString3.A(j.a.class);
                if (paramString1.state != 1) {
                  break label3332;
                }
              }
              label3332:
              for (paramString1 = paramContext.getString(R.l.downloaderapp_download_game_success_tips, new Object[] { paramString1.appName });; paramString1 = paramContext.getString(R.l.downloaderapp_welcome_short))
              {
                paramPString1.value = paramString1;
                paramString3 = "";
                localObject1 = null;
                i = 0;
                break;
              }
              switch (g.a.gp(bk.ZQ((String)localObject2)).dQY)
              {
              default: 
                paramString1 = paramContext.getString(R.l.app_product);
                label3389:
                if (str1.length() <= 0) {
                  break;
                }
              }
              for (paramString3 = str1 + ": ";; paramString3 = "")
              {
                if ((!s.hK(paramString2)) && (j == 0)) {
                  paramPString2.value = str1;
                }
                paramPString1.value = "";
                localObject2 = paramString1;
                localObject1 = null;
                i = 0;
                paramString1 = paramString3;
                paramString3 = (String)localObject2;
                break;
                paramString1 = paramContext.getString(R.l.app_product_card);
                break label3389;
                paramString1 = paramContext.getString(R.l.app_product_ticket);
                break label3389;
              }
              paramString3 = g.a.gp(bk.ZQ((String)localObject2));
              if (paramString3 == null)
              {
                y.e("MicroMsg.Notification.Wording", "decode msg content failed");
                return "";
              }
              localObject2 = "";
              localObject1 = paramContext.getString(R.l.card_msg_item_digest);
              if (str1.length() > 0)
              {
                paramString1 = str1 + ": " + (String)localObject1 + paramString3.title;
                label3573:
                if ((!s.hK(paramString2)) && (j == 0)) {
                  paramPString2.value = str1;
                }
                if (str1.length() <= 0) {
                  break label3670;
                }
              }
              label3670:
              for (paramString3 = "%s: " + (String)localObject1 + paramString3.title;; paramString3 = (String)localObject1 + paramString3.title)
              {
                paramPString1.value = paramString3;
                localObject1 = null;
                i = 0;
                paramString3 = (String)localObject2;
                break;
                paramString1 = (String)localObject1 + paramString3.title;
                break label3573;
              }
              paramString1 = g.a.gp(bk.ZQ((String)localObject2));
              if (paramString1 == null)
              {
                y.e("MicroMsg.Notification.Wording", "decode msg content failed");
                return "";
              }
              localObject2 = "";
              paramString3 = paramContext.getString(R.l.card_msg_item_digest);
              if (paramInt1 == 1)
              {
                paramString1 = paramString3 + paramString1.dRS;
                if (str1.length() > 0) {}
                for (paramString3 = "%s: " + paramString1;; paramString3 = paramString1)
                {
                  paramPString1.value = paramString3;
                  paramString3 = paramString1;
                  if (s.hK(paramString2)) {
                    break label7481;
                  }
                  paramString3 = paramString1;
                  if (j != 0) {
                    break label7481;
                  }
                  paramPString2.value = str1;
                  localObject1 = null;
                  i = 0;
                  paramString3 = (String)localObject2;
                  break;
                }
              }
              paramString1 = paramString3 + paramString1.dRR;
              if (str1.length() > 0) {}
              for (paramString3 = "%s: " + paramString1;; paramString3 = paramString1)
              {
                paramPString1.value = paramString3;
                break;
              }
              paramString3 = g.a.gp(bk.ZQ((String)localObject2));
              if (paramString3 == null)
              {
                y.e("MicroMsg.Notification.Wording", "decode msg content failed");
                return "";
              }
              localObject2 = "";
              if (str1.length() > 0)
              {
                paramString1 = str1 + ": " + paramString3.title;
                label3961:
                if ((!s.hK(paramString2)) && (j == 0)) {
                  paramPString2.value = str1;
                }
                if (str1.length() <= 0) {
                  break label4035;
                }
              }
              label4035:
              for (paramString3 = "%s: " + paramString3.title;; paramString3 = paramString3.title)
              {
                paramPString1.value = paramString3;
                localObject1 = null;
                i = 0;
                paramString3 = (String)localObject2;
                break;
                paramString1 = paramString3.title;
                break label3961;
              }
              localObject2 = paramContext.getString(R.l.app_app);
              if (str1.length() > 0)
              {
                paramString1 = str1 + ": ";
                label4083:
                if ((!s.hK(paramString2)) && (j == 0)) {
                  paramPString2.value = str1;
                }
                if (str1.length() <= 0) {
                  break label4138;
                }
              }
              label4138:
              for (paramString3 = "%s: ";; paramString3 = "")
              {
                paramPString1.value = paramString3;
                localObject1 = null;
                i = 0;
                paramString3 = (String)localObject2;
                break;
                paramString1 = "";
                break label4083;
              }
              paramString1 = bk.ZQ((String)localObject2);
              g.a locala = g.a.gp(paramString1);
              if (locala == null)
              {
                y.e("MicroMsg.Notification.Wording", "decode msg content failed");
                return "";
              }
              switch (locala.type)
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
              default: 
                paramString3 = paramContext.getString(R.l.app_app);
                localObject1 = null;
                i = 0;
                paramString1 = "";
                break;
              case 1: 
                localObject2 = "";
                if (str1.length() > 0)
                {
                  paramString1 = str1 + ": " + locala.title;
                  if ((!s.hK(paramString2)) && (j == 0)) {
                    paramPString2.value = str1;
                  }
                  if (str1.length() <= 0) {
                    break label4491;
                  }
                }
                for (paramString3 = "%s: " + locala.title;; paramString3 = locala.title)
                {
                  paramPString1.value = paramString3;
                  localObject1 = null;
                  i = 0;
                  paramString3 = (String)localObject2;
                  break;
                  paramString1 = locala.title;
                  break label4415;
                }
              case 2: 
                localObject2 = paramContext.getString(R.l.app_pic);
                if (str1.length() > 0)
                {
                  paramString1 = str1 + ": ";
                  if ((!s.hK(paramString2)) && (j == 0)) {
                    paramPString2.value = str1;
                  }
                  if (str1.length() <= 0) {
                    break label4595;
                  }
                }
                for (paramString3 = "%s: ";; paramString3 = "")
                {
                  paramPString1.value = paramString3;
                  localObject1 = null;
                  i = 0;
                  paramString3 = (String)localObject2;
                  break;
                  paramString1 = "";
                  break label4540;
                }
              case 3: 
                localObject2 = paramContext.getString(R.l.app_music);
                if (str1.length() > 0)
                {
                  paramString1 = str1 + ": ";
                  if ((!s.hK(paramString2)) && (j == 0)) {
                    paramPString2.value = str1;
                  }
                  if (str1.length() <= 0) {
                    break label4700;
                  }
                }
                for (paramString3 = "%s: ";; paramString3 = "")
                {
                  paramPString1.value = paramString3;
                  localObject1 = locala.title;
                  i = 1;
                  paramString3 = (String)localObject2;
                  break;
                  paramString1 = "";
                  break label4641;
                }
              case 4: 
                localObject2 = paramContext.getString(R.l.app_video);
                if (str1.length() > 0)
                {
                  paramString1 = str1 + ": ";
                  if ((!s.hK(paramString2)) && (j == 0)) {
                    paramPString2.value = str1;
                  }
                  if (str1.length() <= 0) {
                    break label4805;
                  }
                }
                for (paramString3 = "%s: ";; paramString3 = "")
                {
                  paramPString1.value = paramString3;
                  localObject1 = locala.title;
                  i = 1;
                  paramString3 = (String)localObject2;
                  break;
                  paramString1 = "";
                  break label4746;
                }
              case 6: 
                localObject2 = paramContext.getString(R.l.app_file);
                if (str1.length() > 0)
                {
                  paramString1 = str1 + ": ";
                  if ((!s.hK(paramString2)) && (j == 0)) {
                    paramPString2.value = str1;
                  }
                  if (str1.length() <= 0) {
                    break label4910;
                  }
                }
                for (paramString3 = "%s: ";; paramString3 = "")
                {
                  paramPString1.value = paramString3;
                  localObject1 = locala.title;
                  i = 1;
                  paramString3 = (String)localObject2;
                  break;
                  paramString1 = "";
                  break label4851;
                }
              case 7: 
                localObject2 = paramContext.getString(R.l.app_app);
                if (str1.length() > 0)
                {
                  paramString1 = str1 + ": ";
                  if ((!s.hK(paramString2)) && (j == 0)) {
                    paramPString2.value = str1;
                  }
                  if (str1.length() <= 0) {
                    break label5011;
                  }
                }
                for (paramString3 = "%s: ";; paramString3 = "")
                {
                  paramPString1.value = paramString3;
                  localObject1 = null;
                  i = 0;
                  paramString3 = (String)localObject2;
                  break;
                  paramString1 = "";
                  break label4956;
                }
              case 5: 
                localObject2 = paramContext.getString(R.l.app_url);
                if (str1.length() > 0)
                {
                  paramString1 = str1 + ": ";
                  if ((!s.hK(paramString2)) && (j == 0) && (!s.hT(paramString2))) {
                    paramPString2.value = str1;
                  }
                  if (str1.length() <= 0) {
                    break label5123;
                  }
                }
                for (paramString3 = "%s: ";; paramString3 = "")
                {
                  paramPString1.value = paramString3;
                  localObject1 = locala.getTitle();
                  i = 1;
                  paramString3 = (String)localObject2;
                  break;
                  paramString1 = "";
                  break label5057;
                }
              case 33: 
              case 36: 
                localObject2 = "";
                paramString3 = paramContext.getString(R.l.app_brand_default_name_with_brackets);
                if (str1.length() > 0)
                {
                  paramString1 = str1 + ": " + paramString3 + locala.title;
                  if ((!s.hK(paramString2)) && (j == 0) && (!s.hT(paramString2))) {
                    paramPString2.value = str1;
                  }
                  if (str1.length() <= 0) {
                    break label5288;
                  }
                }
                for (paramString3 = "%s: " + paramString3 + locala.title;; paramString3 = paramString3 + locala.title)
                {
                  paramPString1.value = paramString3;
                  localObject1 = null;
                  i = 0;
                  paramString3 = (String)localObject2;
                  break;
                  paramString1 = paramString3 + locala.title;
                  break label5184;
                }
              case 8: 
                paramString3 = paramContext.getString(R.l.app_emoji2);
                if (str1.length() > 0) {}
                for (paramString1 = str1 + ": ";; paramString1 = "")
                {
                  if ((!s.hK(paramString2)) && (j == 0)) {
                    paramPString2.value = str1;
                  }
                  paramPString1.value = "";
                  localObject1 = null;
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
                  if ((!s.hK(paramString2)) && (j == 0)) {
                    paramPString2.value = str1;
                  }
                  paramPString1.value = "";
                  localObject1 = null;
                  i = 0;
                  break;
                }
              case 25: 
                paramString3 = paramContext.getString(R.l.app_designer_share);
                if (str1.length() > 0) {}
                for (paramString1 = str1 + ": ";; paramString1 = "")
                {
                  if ((!s.hK(paramString2)) && (j == 0)) {
                    paramPString2.value = str1;
                  }
                  paramPString1.value = "";
                  localObject1 = null;
                  i = 0;
                  break;
                }
              case 17: 
                localObject2 = "";
                if (str1.length() > 0)
                {
                  paramString1 = str1 + ": " + locala.title;
                  if ((!s.hK(paramString2)) && (j == 0)) {
                    paramPString2.value = str1;
                  }
                  if (str1.length() <= 0) {
                    break label5672;
                  }
                }
                for (paramString3 = "%s: " + locala.title;; paramString3 = locala.title)
                {
                  paramPString1.value = paramString3;
                  localObject1 = null;
                  i = 0;
                  paramString3 = (String)localObject2;
                  break;
                  paramString1 = locala.title;
                  break label5596;
                }
              case 19: 
                localObject2 = paramContext.getString(R.l.app_record);
                if (str1.length() > 0)
                {
                  paramString1 = str1 + ": ";
                  if ((!s.hK(paramString2)) && (j == 0)) {
                    paramPString2.value = str1;
                  }
                  if (str1.length() <= 0) {
                    break label5776;
                  }
                }
                for (paramString3 = "%s: ";; paramString3 = "")
                {
                  paramPString1.value = paramString3;
                  localObject1 = null;
                  i = 0;
                  paramString3 = (String)localObject2;
                  break;
                  paramString1 = "";
                  break label5721;
                }
              case 24: 
                paramString1 = "";
                if (!bk.bl(locala.description))
                {
                  i = locala.description.indexOf("\n");
                  paramString1 = locala.description;
                  if (i > 0) {
                    paramString1 = paramString1.substring(0, i);
                  }
                }
                else
                {
                  localObject2 = paramContext.getString(R.l.favorite_wenote_msg) + paramString1;
                  if (str1.length() <= 0) {
                    break label5947;
                  }
                  paramString1 = str1 + ": ";
                  if ((!s.hK(paramString2)) && (j == 0)) {
                    paramPString2.value = str1;
                  }
                  if (str1.length() <= 0) {
                    break label5953;
                  }
                }
                for (paramString3 = "%s: ";; paramString3 = "")
                {
                  paramPString1.value = paramString3;
                  localObject1 = null;
                  i = 0;
                  paramString3 = (String)localObject2;
                  break;
                  i = locala.description.length();
                  break label5820;
                  paramString1 = "";
                  break label5885;
                }
              case 16: 
                localObject2 = "";
                localObject1 = paramContext.getString(R.l.card_msg_item_digest);
                if (str1.length() > 0) {}
                for (paramString1 = str1 + ": " + (String)localObject1 + locala.title;; paramString1 = (String)localObject1 + locala.title)
                {
                  if ((!s.hK(paramString2)) && (j == 0)) {
                    paramPString2.value = str1;
                  }
                  paramString3 = (String)localObject1;
                  if (str1.length() > 0) {
                    paramString3 = "%s: " + (String)localObject1;
                  }
                  paramPString1.value = paramString3;
                  localObject1 = null;
                  i = 0;
                  paramString3 = (String)localObject2;
                  break;
                }
              case 34: 
                localObject2 = "";
                paramString1 = paramContext.getString(R.l.card_msg_item_digest);
                if (paramInt1 == 1)
                {
                  paramString1 = paramString1 + locala.dRS;
                  if (str1.length() > 0) {}
                  for (paramString3 = "%s: " + paramString1;; paramString3 = paramString1)
                  {
                    paramPString1.value = paramString3;
                    paramString3 = paramString1;
                    if (s.hK(paramString2)) {
                      break label7481;
                    }
                    paramString3 = paramString1;
                    if (j != 0) {
                      break label7481;
                    }
                    paramPString2.value = str1;
                    localObject1 = null;
                    i = 0;
                    paramString3 = (String)localObject2;
                    break;
                  }
                }
                paramString1 = paramString1 + locala.dRR;
                if (str1.length() > 0) {}
                for (paramString3 = "%s: " + paramString1;; paramString3 = paramString1)
                {
                  paramPString1.value = paramString3;
                  break;
                }
              case 40: 
                label4415:
                label4595:
                label4851:
                label5885:
                if (k.gv(paramString1).dTA == 19)
                {
                  localObject2 = paramContext.getString(R.l.app_record);
                  localObject1 = null;
                  i = 0;
                  paramString1 = paramString3;
                  paramString3 = (String)localObject2;
                  break;
                }
                label4491:
                label4540:
                label4700:
                label4956:
                label5596:
                localObject2 = paramContext.getString(R.l.app_app);
                label4641:
                label4805:
                label5721:
                localObject1 = null;
                label4746:
                label4910:
                label5057:
                i = 0;
                label5011:
                label5184:
                label5953:
                paramString1 = paramString3;
                label5123:
                label5288:
                label5820:
                paramString3 = (String)localObject2;
                label5672:
                label5947:
                break;
                label5776:
                paramString1 = paramString3;
                if (k != 0) {
                  paramString1 = eG(paramString3);
                }
                paramString3 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.biz.a.a.class)).gt(paramString1);
                paramString1 = paramString3;
                if (k != 0) {
                  paramString1 = eF(paramString3);
                }
                paramPString1.value = paramString1;
                paramString3 = "";
                localObject1 = null;
                i = 0;
                break;
                paramPString1.value = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.biz.a.a.class)).gs(paramString3);
                paramString3 = paramPString1.value;
                y.i("MicroMsg.Notification.Wording", "[parseMsgContentToShow] type:%s suffix:%s", new Object[] { Integer.valueOf(318767153), paramString3 });
                localObject1 = null;
                i = 0;
                paramString1 = "";
                break;
                paramString1 = com.tencent.mm.aj.a.b(a.a.lC(paramString3));
                paramPString1.value = paramString1;
                paramString3 = "";
                localObject1 = null;
                i = 0;
                break;
                paramString3 = "";
                localObject1 = g.a.gp((String)localObject2);
                paramString1 = paramString3;
                if (localObject1 == null) {
                  break label862;
                }
                paramString1 = paramString3;
                try
                {
                  paramString3 = URLDecoder.decode(((g.a)localObject1).content, "UTF-8");
                  paramString1 = paramString3;
                  paramString3 = j.WQ(paramString3);
                  paramString1 = paramString3;
                }
                catch (Exception paramString3)
                {
                  try
                  {
                    paramPString1.value = paramString1;
                    paramString3 = "";
                    localObject1 = null;
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
            y.printErrStackTrace("MicroMsg.Notification.Wording", paramString3, "", new Object[0]);
            paramString3 = "";
            localObject1 = null;
            i = 0;
            break label871;
            paramString1 = ((e)com.tencent.mm.kernel.g.r(e.class)).Hd(paramString3);
            if (paramString1 != null) {}
            for (paramString1 = paramString1.toString();; paramString1 = "")
            {
              paramPString1.value = paramString1;
              paramString3 = "";
              localObject1 = null;
              i = 0;
              break;
            }
            paramString3 = com.tencent.mm.ae.a.a.gw(paramString3).content;
            paramString1 = paramString3;
            if (bk.bl(paramString3)) {
              paramString1 = "";
            }
            paramPString1.value = paramString1;
            paramString3 = "";
            localObject1 = null;
            i = 0;
            break label871;
            label6667:
            paramString1 = paramString1.split("@bottle:");
            if (paramString1.length > 1)
            {
              paramPString1.value = paramString1[1];
              return paramString1[1];
            }
            paramPString1.value = "";
            return null;
            label6702:
            paramString2 = null;
            paramPString2 = null;
            paramContext = paramString1.split(":");
            if ((paramContext == null) || (paramContext.length <= 0))
            {
              paramPString1.value = "";
              return null;
            }
            paramContext = paramContext[0];
            if (!bk.bl(paramContext))
            {
              au.Hx();
              paramPInt = c.Fw().abl(paramContext);
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
            if (!bk.bl(paramString3))
            {
              paramPString1.value = (paramString2 + ": " + paramString3);
              return paramString2 + ": " + paramString3;
            }
            paramString1 = paramString1.split("@bottle:");
            if (paramString1.length > 1)
            {
              paramPString1.value = (paramString2 + ": " + paramString1[1]);
              return paramString2 + ": " + paramString1[1];
            }
            paramPString1.value = paramString2;
            return paramString2;
            label6956:
            if (bk.bl(paramString1)) {
              paramPString1.value = "";
            }
            if (!bk.bl(str1))
            {
              paramString2 = paramString1;
              if (str2 != null)
              {
                paramString2 = paramString1;
                if (str2.length() > 0) {
                  paramString2 = g(paramString1, str1, str2);
                }
              }
              if (bk.bl(paramPString2.value))
              {
                paramPString1.value = g(paramPString1.value, str1, "%s");
                paramPString2.value = str1;
              }
              paramString1 = o.ff(paramString2);
              paramPString1.value = o.ff(paramPString1.value);
              paramString2 = paramString1 + paramString3;
              paramPString1.value += paramString3;
              if (paramBoolean1)
              {
                if ((paramPString1.value.length() != 32) || ((paramInt2 != 47) && (paramInt2 != 1048625))) {
                  break label7198;
                }
                paramPString1.value = paramString2;
              }
              label7198:
              for (paramInt1 = 1;; paramInt1 = 0)
              {
                if (paramInt1 == 0) {
                  a(paramInt2, paramPString1, paramPString2, paramPInt);
                }
                paramString1 = paramString2;
                if (i != 0) {
                  paramString1 = paramString2.concat(" " + bk.pm((String)localObject1));
                }
                return bk.pm(paramString1);
              }
            }
            if ((s.hK(paramString2)) || (j != 0) || (s.hT(paramString2)))
            {
              paramString2 = paramString1;
              if (paramString3 != null)
              {
                paramString2 = paramString1;
                if (paramString3.length() > 0) {
                  paramString2 = paramString3;
                }
              }
              if (bk.bl(paramString2))
              {
                paramPString1.value = "";
                paramPString2.value = "";
                return "";
              }
              if (paramInt1 == 0)
              {
                paramPString1.value = ("%s:" + paramString2);
                if (!paramBoolean1) {
                  break label7399;
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
                if (localObject1 != null) {
                  paramString2 = paramString1.concat(" " + (String)localObject1);
                }
              }
              paramString1 = paramString2;
              if (k != 0) {
                paramString1 = eG(paramString2);
              }
              return bk.pm(paramString1);
              paramPString1.value = (paramContext.getString(R.l.app_me) + ":" + paramString2);
              break;
              label7399:
              return r.gV(paramPString2.value) + ":" + paramString2;
              if ((paramString3 == null) || (paramString3.length() <= 0)) {
                break label7476;
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
            label7476:
            label7481:
            localObject2 = "";
            localObject1 = null;
            i = 0;
            paramString1 = paramString3;
            paramString3 = (String)localObject2;
            break label871;
            label7499:
            localObject2 = "";
            localObject1 = null;
            i = 0;
            paramString1 = paramString3;
            paramString3 = (String)localObject2;
            break label871;
            paramString1 = paramString2;
            break label2404;
            paramString1 = paramString2;
          }
          label7527:
          j = i;
        }
        localObject2 = paramString3;
        str2 = "";
        str1 = "";
      }
    }
  }
  
  private static void a(int paramInt, PString paramPString1, PString paramPString2, PInt paramPInt)
  {
    int i = 150;
    if ((paramPString1.value.length() == 32) && ((paramInt == 47) || (paramInt == 1048625))) {
      return;
    }
    String str;
    if (paramPString1.value.length() >= 150)
    {
      localObject = paramPString1.value;
      str = paramPString1.value;
      paramInt = i;
      if (paramInt >= str.length()) {
        break label138;
      }
      if (str.charAt(paramInt) != '%') {
        label79:
        paramPString1.value = ((String)localObject).substring(0, paramInt);
      }
    }
    else
    {
      if (dkx != null) {
        break label147;
      }
    }
    label138:
    label147:
    for (Object localObject = null;; localObject = (TextPaint)dkx.get())
    {
      if ((!paramPString1.value.replace("%%", "").contains("%s")) && (localObject != null)) {
        break label161;
      }
      paramPInt.value = 0;
      return;
      paramInt += 1;
      break;
      paramInt = str.length();
      break label79;
    }
    try
    {
      label161:
      paramPString2 = String.format(paramPString1.value, new Object[] { paramPString2.value });
      if (dky > 0)
      {
        paramInt = dky;
        paramPString1.value = TextUtils.ellipsize(paramPString2, (TextPaint)localObject, paramInt, TextUtils.TruncateAt.END).toString();
        paramPInt.value = 1;
        return;
      }
    }
    catch (Exception paramPString2)
    {
      for (;;)
      {
        paramPString2 = paramPString1.value;
        continue;
        paramInt = BackwardSupportUtil.b.b(ae.getContext(), 200.0F);
      }
    }
  }
  
  public static void a(TextPaint paramTextPaint)
  {
    if ((dkx == null) || (dkx.get() == null)) {
      dkx = new WeakReference(paramTextPaint);
    }
  }
  
  public static String b(ad paramad)
  {
    Object localObject2 = ae.getContext();
    Object localObject1;
    if (paramad == null) {
      localObject1 = ((Context)localObject2).getString(R.l.bottle_unknowed_city);
    }
    do
    {
      do
      {
        do
        {
          return localObject1;
          if (!RegionCodeDecoder.acl(paramad.getCountryCode())) {
            break;
          }
          localObject2 = paramad.getCity();
          localObject1 = localObject2;
        } while (!bk.bl((String)localObject2));
        localObject2 = r.gX(paramad.getProvince());
        localObject1 = localObject2;
      } while (!bk.bl((String)localObject2));
      RegionCodeDecoder.cvV();
      return RegionCodeDecoder.getLocName(paramad.getCountryCode());
      paramad = r.gX(paramad.getProvince());
      localObject1 = paramad;
    } while (!bk.bl(paramad));
    return ((Context)localObject2).getString(R.l.bottle_unknowed_city);
  }
  
  public static String b(bi parambi, PString paramPString1, PString paramPString2, PInt paramPInt, boolean paramBoolean)
  {
    if (parambi.cvm()) {}
    for (String str = parambi.cvK();; str = parambi.field_content)
    {
      str = j.WQ(str);
      return bk.pm(a(parambi.field_imgPath, parambi.field_isSend, parambi.field_talker, str, parambi.getType(), ae.getContext(), paramPString1, paramPString2, paramPInt, true, paramBoolean));
    }
  }
  
  public static String c(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramString = com.tencent.mm.cd.b.csC().aat(paramString);
    if (paramBoolean) {
      return paramString;
    }
    return paramContext.getString(R.l.intro_title);
  }
  
  public static String d(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      return com.tencent.mm.cd.b.csC().aat(paramString);
    }
    return paramContext.getString(R.l.notification_sample_ticker);
  }
  
  private static String eF(String paramString)
  {
    String str = paramString;
    if (paramString != null) {
      str = paramString.replaceAll("%", "%%");
    }
    return str;
  }
  
  private static String eG(String paramString)
  {
    String str = paramString;
    if (paramString != null) {
      str = paramString.replaceAll("%%", "%");
    }
    return str;
  }
  
  public static String eH(String paramString)
  {
    String str;
    if (paramString == null) {
      str = "";
    }
    do
    {
      return str;
      str = paramString;
    } while (paramString.length() < 150);
    return paramString.substring(0, 150) + "...";
  }
  
  public static String g(Context paramContext, String paramString1, String paramString2)
  {
    if (s.fn(paramString1))
    {
      paramString2 = com.tencent.mm.model.bd.iI(paramString2);
      if (paramString2 != null) {
        paramString2 = r.gV(paramString2.trim());
      }
    }
    while (paramString1.contains("@bottle"))
    {
      return paramContext.getResources().getQuantityString(R.j.notification_fmt_multi_bottle, 1, new Object[] { Integer.valueOf(1) });
      paramString2 = r.gV(paramString1);
      continue;
      paramString2 = r.gV(paramString1);
    }
    String str = paramString2;
    if (bk.bl(paramString2))
    {
      str = paramString2;
      if (s.fn(paramString1)) {
        str = paramContext.getString(R.l.chatting_roominfo_noname);
      }
    }
    return com.tencent.mm.cd.b.csC().aat(str);
  }
  
  private static String g(String paramString1, String paramString2, String paramString3)
  {
    if ((bk.bl(paramString1)) || (bk.bl(paramString2)) || (bk.bl(paramString3))) {}
    int i;
    do
    {
      return paramString1;
      i = paramString1.indexOf(paramString2);
    } while (i < 0);
    return paramString1.substring(0, i) + paramString3 + paramString1.substring(i + paramString2.length());
  }
  
  public static void gc(int paramInt)
  {
    dky = paramInt;
  }
  
  public static void gd(int paramInt)
  {
    dkz = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.booter.notification.a.h
 * JD-Core Version:    0.7.0.1
 */