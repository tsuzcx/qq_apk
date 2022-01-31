package com.tencent.mm.plugin.fav.ui.b;

import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mm.h.a.gf;
import com.tencent.mm.h.a.gf.b;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.ac.a;
import com.tencent.mm.model.ac.b;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.ui.n.c;
import com.tencent.mm.plugin.fav.ui.n.h;
import com.tencent.mm.plugin.fav.ui.n.i;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.ui.b.a;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.pluginsdk.c;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.ya;
import com.tencent.mm.protocal.c.yc;
import com.tencent.mm.protocal.c.yi;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a
  extends com.tencent.mm.plugin.fts.a.d.a.a
{
  private static final ah handler = new ah(Looper.getMainLooper());
  private static final String kgO = ae.getContext().getString(n.i.fts_message_location_tag);
  private static final Pattern kgP = Pattern.compile("['\r\n' | '\n']+");
  public l fYx;
  public String foS;
  public CharSequence kgQ;
  public CharSequence kgR;
  public CharSequence kgS;
  public String kgT;
  public int kgU;
  private a.b kgV = new a.b(this);
  a.a kgW = new a.a(this);
  
  public a(int paramInt)
  {
    super(7, paramInt);
  }
  
  public static void a(TextView paramTextView1, TextView paramTextView2, CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    if (m.a(paramCharSequence1, paramTextView1)) {
      if (m.a(paramCharSequence2, paramTextView2))
      {
        paramTextView1.setMaxLines(1);
        paramTextView2.setMaxLines(1);
      }
    }
    while (!m.a(paramCharSequence2, paramTextView2))
    {
      return;
      paramTextView1.setMaxLines(2);
      return;
    }
    paramTextView2.setMaxLines(2);
  }
  
  private static String b(ad paramad, boolean paramBoolean)
  {
    if ((paramBoolean) && (!bk.bl(paramad.field_conRemark))) {}
    for (String str1 = paramad.field_conRemark;; str1 = paramad.field_nickname)
    {
      String str2 = str1;
      if (bk.bl(str1)) {
        str2 = paramad.field_username;
      }
      return str2;
    }
  }
  
  private String bu(List<String> paramList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    String[] arrayOfString = this.kwi.kwI;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str1 = arrayOfString[i];
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        if (com.tencent.mm.plugin.fts.a.d.DR(str2).contains(str1))
        {
          localStringBuffer.append(str2);
          localStringBuffer.append(",");
        }
      }
      i += 1;
    }
    localStringBuffer.trimToSize();
    if (localStringBuffer.length() == 0) {
      return "";
    }
    return localStringBuffer.substring(0, localStringBuffer.length() - 1);
  }
  
  private static String c(Context paramContext, ad paramad)
  {
    String str2 = paramad.field_conRemark;
    String str1 = str2;
    if (bk.bl(str2)) {
      str1 = paramad.field_nickname;
    }
    paramad = str1;
    if (bk.bl(str1)) {
      paramad = paramContext.getString(n.i.fts_header_chatroom);
    }
    return paramad;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a.b BD()
  {
    return this.kgV;
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a.a parama, Object... paramVarArgs)
  {
    Object localObject2 = null;
    long l = this.fYx.kxk;
    parama = new gf();
    parama.bNF.type = 9;
    parama.bNF.bIr = l;
    com.tencent.mm.sdk.b.a.udP.m(parama);
    ya localya = parama.bNG.bNR;
    l = this.fYx.kxk;
    parama = new gf();
    parama.bNF.type = 11;
    parama.bNF.bIr = l;
    parama.bNF.handler = handler;
    com.tencent.mm.sdk.b.a.udP.m(parama);
    this.kgT = bk.aM(parama.bNG.thumbPath, "");
    this.foS = bk.aM(parama.bNG.thumbUrl, "");
    Object localObject1 = this.fYx;
    float f = b.a.kzX * 2;
    paramVarArgs = localya.bWM;
    parama = "";
    label254:
    int i;
    switch (localya.type)
    {
    case 5: 
    case 8: 
    case 9: 
    case 12: 
    case 13: 
    case 15: 
    default: 
      parama = localya.title;
      switch (((l)localObject1).kwf)
      {
      default: 
        label296:
        this.kgQ = parama;
        paramVarArgs = this.fYx;
        localObject1 = localya.bWM;
        parama = "";
        switch (localya.type)
        {
        case 3: 
        case 4: 
        case 8: 
        case 9: 
        case 13: 
        default: 
          parama = "";
          label395:
          switch (paramVarArgs.kwf)
          {
          default: 
            localObject1 = "";
            i = -1;
            paramVarArgs = parama;
            parama = (com.tencent.mm.plugin.fts.a.d.a.a.a)localObject1;
            label452:
            if ((i != -1) && (!bk.bl(paramVarArgs))) {
              parama = TextUtils.concat(new CharSequence[] { paramContext.getResources().getString(i), parama });
            }
            break;
          }
          break;
        }
        break;
      }
      break;
    }
    for (;;)
    {
      this.kgR = parama;
      Object localObject3 = this.fYx;
      paramVarArgs = localya.bRO;
      parama = localya.sWM;
      if (bk.bl(paramVarArgs))
      {
        localObject1 = null;
        paramVarArgs = parama;
        parama = (com.tencent.mm.plugin.fts.a.d.a.a.a)localObject1;
      }
      for (;;)
      {
        if (bk.bl(paramVarArgs)) {}
        label597:
        ad localad;
        label1289:
        boolean bool3;
        label1341:
        label1378:
        for (paramContext = new SpannableString("");; paramContext = TextUtils.concat(new CharSequence[] { paramContext.getResources().getString(n.i.search_contact_favorite_status), parama }))
        {
          this.kgS = paramContext;
          switch (localya.type)
          {
          case 7: 
          default: 
            i = n.h.fts_default_img;
            this.kgU = i;
            return;
            parama = kgP.matcher(localya.desc).replaceAll(" ");
            break label254;
            parama = paramContext.getResources().getString(n.i.search_favorite_img_tips);
            break label254;
            parama = localya.bWM.sWf;
            if ((kgO.equals(parama.bVA)) || (bk.bl(parama.bVA)))
            {
              parama = parama.label;
              break label254;
            }
            parama = parama.bVA;
            break label254;
            parama = paramContext.getResources().getString(n.i.search_favorite_video_tips);
            break label254;
            parama = paramContext.getResources().getString(n.i.search_favorite_voice_tips);
            break label254;
            if (paramVarArgs.sWj == null) {
              break label254;
            }
            parama = paramVarArgs.sWj.title;
            break label254;
            parama = new StringBuffer();
            paramVarArgs = paramVarArgs.sXc.iterator();
            while (paramVarArgs.hasNext())
            {
              localObject3 = b.a((xv)paramVarArgs.next());
              if (!bk.bl((String)localObject3))
              {
                parama.append((String)localObject3);
                parama.append(" ");
              }
            }
            paramVarArgs = kgP.matcher(parama.toString()).replaceAll(" ");
            parama = paramVarArgs;
            if (!bk.bl(paramVarArgs)) {
              break label254;
            }
            parama = paramContext.getResources().getString(n.i.search_favorite_record_tips);
            break label254;
            paramVarArgs = localya.title;
            parama = paramVarArgs;
            if (bk.bl(localya.desc)) {
              break label254;
            }
            parama = paramVarArgs + "-" + localya.desc;
            break label254;
            parama = paramContext.getResources().getString(n.i.search_favorite_sight_tips);
            break label254;
            parama = f.a(com.tencent.mm.plugin.fts.a.a.d.a(parama, this.kwi, f, b.c.kAg)).kwz;
            break label296;
            if (bk.bl(localya.appId)) {
              break label395;
            }
            parama = ac.a.dVw.n(paramContext, localya.appId);
            break label395;
            parama = localya.title;
            break label395;
            parama = localya.bWM.sWf;
            if ((kgO.equals(parama.bVA)) || (bk.bl(parama.bVA)))
            {
              parama = parama.label;
              break label395;
            }
            parama = parama.bVA;
            break label395;
            if (((yj)localObject1).sWj == null) {
              break label395;
            }
            parama = ((yj)localObject1).sWj.desc;
            break label395;
            parama = "";
            break label395;
            i = n.i.search_favorite_img_orc_tips;
            localObject1 = f.a(com.tencent.mm.plugin.fts.a.a.d.a(parama, this.kwi)).kwz;
            paramVarArgs = parama;
            parama = (com.tencent.mm.plugin.fts.a.d.a.a.a)localObject1;
            break label452;
            i = n.i.search_favorite_label_tips;
            paramVarArgs = bu(localya.sWN);
            parama = f.a(com.tencent.mm.plugin.fts.a.a.d.a(paramVarArgs, this.kwi)).kwz;
            break label452;
            localObject1 = f.a(com.tencent.mm.plugin.fts.a.a.d.a(parama, this.kwi)).kwz;
            i = -1;
            paramVarArgs = parama;
            parama = (com.tencent.mm.plugin.fts.a.d.a.a.a)localObject1;
            break label452;
            localad = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(paramVarArgs);
            localad.setUsername(paramVarArgs);
            localObject1 = localObject2;
            if (s.fn(paramVarArgs))
            {
              localObject1 = localObject2;
              if (!bk.bl(parama))
              {
                localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(parama);
                ((ad)localObject1).setUsername(parama);
              }
            }
            switch (((l)localObject3).kwf)
            {
            case 15: 
            case 19: 
            default: 
              bool2 = false;
              bool1 = false;
              i = 0;
              if (localObject1 == null) {
                break label1652;
              }
              parama = b((ad)localObject1, true) + "-" + c(paramContext, localad);
              bool3 = bool2;
              bool2 = bool1;
              bool1 = bool3;
              parama = com.tencent.mm.pluginsdk.ui.d.j.b(paramContext, parama, com.tencent.mm.cb.a.aa(paramContext, n.c.HintTextSize));
              if (i == 0) {
                break label1790;
              }
              parama = f.a(com.tencent.mm.plugin.fts.a.a.d.a(parama, this.kwi, bool1, bool2)).kwz;
            }
            break;
          }
        }
        boolean bool1 = true;
        label1409:
        boolean bool2 = true;
        for (;;)
        {
          if (localObject1 != null)
          {
            parama = b((ad)localObject1, false) + "-" + c(paramContext, localad);
            bool3 = bool1;
            i = 1;
            bool1 = bool2;
            bool2 = bool3;
            break label1341;
          }
          parama = b(localad, false);
          bool3 = bool1;
          i = 1;
          bool1 = bool2;
          bool2 = bool3;
          break label1341;
          bool1 = true;
          label1498:
          bool3 = true;
          bool2 = bool1;
          bool1 = bool3;
          for (;;)
          {
            if (localObject1 != null) {
              parama = b((ad)localObject1, true) + "-" + c(paramContext, localad);
            }
            for (;;)
            {
              paramVarArgs = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(localya.bFn);
              parama = parama + "-" + b(paramVarArgs, true);
              i = 1;
              break;
              if (s.fn(localad.field_username)) {
                parama = c(paramContext, localad);
              } else {
                parama = b(localad, true);
              }
            }
            bool1 = true;
            label1643:
            bool2 = true;
            for (;;)
            {
              i = 1;
              break label1289;
              label1652:
              if (s.fn(localad.field_username))
              {
                parama = c(paramContext, localad);
                bool3 = bool1;
                bool1 = bool2;
                bool2 = bool3;
                break label1341;
              }
              parama = b(localad, true);
              bool3 = bool1;
              bool1 = bool2;
              bool2 = bool3;
              break label1341;
              if ((localya.bWM.sXc == null) || (localya.bWM.sXc.size() <= 0)) {
                break;
              }
              i = c.Vy(((xv)localya.bWM.sXc.get(0)).sUV);
              break label597;
              i = n.h.app_attach_file_icon_webpage;
              break label597;
              i = n.h.app_attach_file_icon_voice;
              break label597;
              i = n.h.app_attach_file_icon_video;
              break label597;
              i = n.h.app_attach_file_icon_location;
              break label597;
              label1790:
              break label1378;
              bool1 = false;
              break label1409;
              bool1 = false;
              break label1498;
              bool1 = false;
              break label1643;
              bool2 = false;
              bool1 = false;
            }
            bool1 = false;
            bool2 = false;
          }
          bool2 = false;
          bool1 = false;
        }
      }
    }
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a.a afK()
  {
    return this.kgW;
  }
  
  public final int afM()
  {
    return this.fYx.kxt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.b.a
 * JD-Core Version:    0.7.0.1
 */