package com.tencent.mm.plugin.fav.ui.c;

import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ht;
import com.tencent.mm.autogen.a.ht.a;
import com.tencent.mm.autogen.a.ht.b;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.b;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.ui.q.c;
import com.tencent.mm.plugin.fav.ui.q.e;
import com.tencent.mm.plugin.fav.ui.q.f;
import com.tencent.mm.plugin.fav.ui.q.h;
import com.tencent.mm.plugin.fav.ui.q.i;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.ui.b.a;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.ark;
import com.tencent.mm.protocal.protobuf.arm;
import com.tencent.mm.protocal.protobuf.aru;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.arx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMImageView;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a
  extends com.tencent.mm.plugin.fts.a.d.a.a
{
  private static final String Amw;
  private static final Pattern Amx;
  private static final MMHandler handler;
  public CharSequence AmA;
  public CharSequence AmB;
  public String AmC;
  public int AmD;
  private b AmE;
  a AmF;
  public boolean Amy;
  public CharSequence Amz;
  public String nVM;
  public com.tencent.mm.plugin.fts.a.a.o rpp;
  
  static
  {
    AppMethodBeat.i(107310);
    Amw = MMApplicationContext.getContext().getString(q.i.fts_message_location_tag);
    Amx = Pattern.compile("['\r\n' | '\n']+");
    handler = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(107310);
  }
  
  public a(int paramInt)
  {
    super(6, paramInt);
    AppMethodBeat.i(107305);
    this.AmE = new b();
    this.AmF = new a();
    AppMethodBeat.o(107305);
  }
  
  public static void a(TextView paramTextView1, TextView paramTextView2, CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    AppMethodBeat.i(107304);
    if (com.tencent.mm.plugin.fts.ui.o.a(paramCharSequence1, paramTextView1))
    {
      if (com.tencent.mm.plugin.fts.ui.o.a(paramCharSequence2, paramTextView2))
      {
        paramTextView1.setMaxLines(1);
        paramTextView2.setMaxLines(1);
        AppMethodBeat.o(107304);
        return;
      }
      paramTextView1.setMaxLines(2);
      AppMethodBeat.o(107304);
      return;
    }
    if (com.tencent.mm.plugin.fts.ui.o.a(paramCharSequence2, paramTextView2)) {
      paramTextView2.setMaxLines(2);
    }
    AppMethodBeat.o(107304);
  }
  
  private static String b(Context paramContext, au paramau)
  {
    AppMethodBeat.i(107308);
    String str2 = paramau.field_conRemark;
    String str1 = str2;
    if (Util.isNullOrNil(str2)) {
      str1 = paramau.field_nickname;
    }
    paramau = str1;
    if (Util.isNullOrNil(str1)) {
      paramau = paramContext.getString(q.i.fts_header_chatroom);
    }
    AppMethodBeat.o(107308);
    return paramau;
  }
  
  private static String c(au paramau, boolean paramBoolean)
  {
    AppMethodBeat.i(107307);
    if ((paramBoolean) && (!Util.isNullOrNil(paramau.field_conRemark))) {}
    for (String str1 = paramau.field_conRemark;; str1 = paramau.field_nickname)
    {
      String str2 = str1;
      if (Util.isNullOrNil(str1)) {
        str2 = paramau.field_username;
      }
      AppMethodBeat.o(107307);
      return str2;
    }
  }
  
  private String fM(List<String> paramList)
  {
    AppMethodBeat.i(107309);
    StringBuffer localStringBuffer = new StringBuffer();
    String[] arrayOfString = this.FWt.Htg;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str1 = arrayOfString[i];
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        if (d.aEh(str2).contains(str1))
        {
          localStringBuffer.append(str2);
          localStringBuffer.append(",");
        }
      }
      i += 1;
    }
    localStringBuffer.trimToSize();
    if (localStringBuffer.length() == 0)
    {
      AppMethodBeat.o(107309);
      return "";
    }
    paramList = localStringBuffer.substring(0, localStringBuffer.length() - 1);
    AppMethodBeat.o(107309);
    return paramList;
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(107306);
    super.a(paramContext, parama, paramVarArgs);
    long l = this.rpp.HtI;
    parama = new ht();
    parama.hIR.type = 9;
    parama.hIR.hDn = l;
    parama.publish();
    ark localark = parama.hIS.hJd;
    Object localObject;
    float f;
    label282:
    label324:
    int i;
    if (localark != null)
    {
      l = this.rpp.HtI;
      parama = new ht();
      parama.hIR.type = 11;
      parama.hIR.hDn = l;
      parama.hIR.handler = handler;
      parama.publish();
      this.AmC = Util.nullAs(parama.hIS.thumbPath, "");
      this.nVM = Util.nullAs(parama.hIS.thumbUrl, "");
      localObject = this.rpp;
      f = b.a.HwK * 2;
      paramVarArgs = localark.hXw;
      parama = "";
      switch (localark.type)
      {
      case 5: 
      case 8: 
      case 9: 
      case 12: 
      case 13: 
      case 15: 
      case 17: 
      case 18: 
      case 19: 
      case 20: 
      default: 
        parama = localark.title;
        switch (((com.tencent.mm.plugin.fts.a.a.o)localObject).subtype)
        {
        default: 
          this.Amz = parama;
          paramVarArgs = this.rpp;
          localObject = localark.hXw;
          parama = "";
          switch (localark.type)
          {
          case 3: 
          case 4: 
          case 8: 
          case 9: 
          case 13: 
          case 16: 
          case 17: 
          case 18: 
          case 19: 
          case 20: 
          default: 
            parama = "";
            label447:
            switch (paramVarArgs.subtype)
            {
            default: 
              paramVarArgs = "";
              i = -1;
              label498:
              if ((i == -1) || (Util.isNullOrNil(parama))) {}
              break;
            }
            break;
          }
          break;
        }
        break;
      }
    }
    label645:
    label1542:
    for (parama = TextUtils.concat(new CharSequence[] { paramContext.getResources().getString(i), paramVarArgs });; parama = paramVarArgs)
    {
      this.AmA = parama;
      com.tencent.mm.plugin.fts.a.a.o localo = this.rpp;
      paramVarArgs = localark.hQQ;
      parama = localark.ZBe;
      if (Util.isNullOrNil(paramVarArgs))
      {
        localObject = null;
        paramVarArgs = parama;
        parama = (com.tencent.mm.plugin.fts.a.d.a.a.a)localObject;
      }
      label1422:
      label1679:
      label1688:
      for (;;)
      {
        if (Util.isNullOrNil(paramVarArgs)) {}
        au localau;
        label1333:
        boolean bool3;
        for (paramContext = new SpannableString("");; paramContext = TextUtils.concat(new CharSequence[] { paramContext.getResources().getString(q.i.search_contact_favorite_status), parama }))
        {
          this.AmB = paramContext;
          switch (localark.type)
          {
          case 7: 
          default: 
            i = q.h.fts_default_img;
            this.AmD = i;
            AppMethodBeat.o(107306);
            return;
            parama = Amx.matcher(localark.desc).replaceAll(" ");
            break label282;
            parama = paramContext.getResources().getString(q.i.search_favorite_img_tips);
            break label282;
            parama = localark.hXw.ZAh;
            if ((Amw.equals(parama.hVI)) || (Util.isNullOrNil(parama.hVI)))
            {
              parama = parama.label;
              break label282;
            }
            parama = parama.hVI;
            break label282;
            parama = paramContext.getResources().getString(q.i.search_favorite_video_tips);
            break label282;
            parama = paramContext.getResources().getString(q.i.search_favorite_voice_tips);
            break label282;
            if (paramVarArgs.ZAl == null) {
              break label282;
            }
            parama = paramVarArgs.ZAl.title;
            break label282;
            parama = new StringBuffer();
            paramVarArgs = paramVarArgs.vEn.iterator();
            while (paramVarArgs.hasNext())
            {
              str = b.c((arf)paramVarArgs.next());
              if (!Util.isNullOrNil(str))
              {
                parama.append(str);
                parama.append(" ");
              }
            }
            paramVarArgs = Amx.matcher(parama.toString()).replaceAll(" ");
            parama = paramVarArgs;
            if (!Util.isNullOrNil(paramVarArgs)) {
              break label282;
            }
            parama = paramContext.getResources().getString(q.i.search_favorite_record_tips);
            break label282;
            paramVarArgs = localark.title;
            parama = paramVarArgs;
            if (Util.isNullOrNil(localark.desc)) {
              break label282;
            }
            parama = paramVarArgs + "-" + localark.desc;
            break label282;
            parama = paramContext.getResources().getString(q.i.search_favorite_sight_tips);
            break label282;
            parama = com.tencent.mm.plugin.fts.a.f.a(g.a(parama, this.FWt, f, b.c.HwT)).HsX;
            break label324;
            if (Util.isNullOrNil(localark.appId)) {
              break label447;
            }
            parama = am.a.okN.x(paramContext, localark.appId);
            break label447;
            parama = localark.title;
            break label447;
            parama = localark.hXw.ZAh;
            if ((Amw.equals(parama.hVI)) || (Util.isNullOrNil(parama.hVI)))
            {
              parama = parama.label;
              break label447;
            }
            parama = parama.hVI;
            break label447;
            if (((arv)localObject).ZAl == null) {
              break label447;
            }
            parama = ((arv)localObject).ZAl.desc;
            break label447;
            parama = "";
            break label447;
            i = q.i.search_favorite_img_orc_tips;
            paramVarArgs = com.tencent.mm.plugin.fts.a.f.a(g.a(parama, this.FWt)).HsX;
            break label498;
            i = q.i.search_favorite_label_tips;
            parama = fM(localark.ZBf);
            paramVarArgs = com.tencent.mm.plugin.fts.a.f.a(g.a(parama, this.FWt)).HsX;
            break label498;
            paramVarArgs = com.tencent.mm.plugin.fts.a.f.a(g.a(parama, this.FWt)).HsX;
            i = -1;
            break label498;
            localau = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramVarArgs);
            localau.setUsername(paramVarArgs);
            String str = null;
            localObject = str;
            if (au.bwE(paramVarArgs))
            {
              localObject = str;
              if (!Util.isNullOrNil(parama))
              {
                localObject = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(parama);
                ((au)localObject).setUsername(parama);
              }
            }
            switch (localo.subtype)
            {
            case 15: 
            case 19: 
            default: 
              bool2 = false;
              bool1 = false;
              i = 0;
              if (localObject == null) {
                break label1688;
              }
              parama = c((au)localObject, true) + "-" + b(paramContext, localau);
              bool3 = bool2;
              bool2 = bool1;
              bool1 = bool3;
              label1385:
              parama = p.d(paramContext, parama, com.tencent.mm.cd.a.br(paramContext, q.c.HintTextSize));
              if (i == 0) {
                break label1861;
              }
              parama = com.tencent.mm.plugin.fts.a.f.a(g.a(parama, this.FWt, bool2, bool1)).HsX;
            }
            break;
          }
        }
        boolean bool2 = true;
        label1453:
        for (boolean bool1 = true;; bool1 = false)
        {
          if (localObject != null)
          {
            parama = c((au)localObject, false) + "-" + b(paramContext, localau);
            bool3 = bool1;
            i = 1;
            bool1 = bool2;
            bool2 = bool3;
            break label1385;
          }
          parama = c(localau, false);
          bool3 = bool1;
          i = 1;
          bool1 = bool2;
          bool2 = bool3;
          break label1385;
          bool1 = true;
          for (bool2 = true;; bool2 = false)
          {
            if (localObject != null) {
              parama = c((au)localObject, true) + "-" + b(paramContext, localau);
            }
            for (;;)
            {
              paramVarArgs = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(localark.hzi);
              parama = parama + "-" + c(paramVarArgs, true);
              i = 1;
              break;
              if (au.bwE(localau.field_username)) {
                parama = b(paramContext, localau);
              } else {
                parama = c(localau, true);
              }
            }
            bool2 = true;
            for (bool1 = true;; bool1 = false)
            {
              i = 1;
              break label1333;
              if (au.bwE(localau.field_username))
              {
                parama = b(paramContext, localau);
                bool3 = bool1;
                bool1 = bool2;
                bool2 = bool3;
                break label1385;
              }
              parama = c(localau, true);
              bool3 = bool1;
              bool1 = bool2;
              bool2 = bool3;
              break label1385;
              if ((localark.hXw.vEn == null) || (localark.hXw.vEn.size() <= 0)) {
                break;
              }
              i = com.tencent.mm.pluginsdk.f.boR(((arf)localark.hXw.vEn.get(0)).ZyU);
              break label645;
              i = q.h.app_attach_file_icon_webpage;
              break label645;
              i = q.h.app_attach_file_icon_voice;
              break label645;
              i = q.h.app_attach_file_icon_video;
              break label645;
              i = q.h.app_attach_file_icon_location;
              break label645;
              Log.i("MicroMsg.FTS.FTSFavoriteDataItem", "favExportInfo is null, id: " + this.rpp.HtI);
              AppMethodBeat.o(107306);
              return;
              label1861:
              break label1422;
              bool2 = false;
              break label1453;
              bool1 = false;
              break label1542;
              bool2 = false;
              break label1679;
              bool2 = false;
            }
            bool1 = false;
          }
          bool2 = false;
        }
      }
    }
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a.b aXA()
  {
    return this.AmE;
  }
  
  public final int coC()
  {
    return this.rpp.HtS;
  }
  
  public final class a
    extends com.tencent.mm.plugin.fts.a.d.a.a.a
  {
    public MMImageView AmG;
    public TextView AmH;
    public TextView AmI;
    public TextView pJJ;
    public View pKl;
    
    public a()
    {
      super();
    }
  }
  
  public final class b
    extends com.tencent.mm.plugin.fts.a.d.a.a.b
  {
    public b()
    {
      super();
    }
    
    public final View a(Context paramContext, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(107301);
      paramContext = LayoutInflater.from(paramContext).inflate(q.f.fts_favorite_item, paramViewGroup, false);
      paramViewGroup = (a.a)a.this.AmF;
      paramViewGroup.AmG = ((MMImageView)paramContext.findViewById(q.e.avatar_iv));
      paramViewGroup.pJJ = ((TextView)paramContext.findViewById(q.e.title_tv));
      paramViewGroup.AmH = ((TextView)paramContext.findViewById(q.e.abstract_tv));
      paramViewGroup.AmI = ((TextView)paramContext.findViewById(q.e.status_tv));
      paramViewGroup.pKl = paramContext.findViewById(q.e.divider);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(107301);
      return paramContext;
    }
    
    public final void a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a.a parama, com.tencent.mm.plugin.fts.a.d.a.a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(107302);
      parama = (a.a)parama;
      parama1 = (a)parama1;
      com.tencent.mm.plugin.fts.ui.o.a(paramContext, parama.AmG, parama1.nVM, parama1.AmC, parama1.AmD, false, parama.AmG.getMeasuredWidth(), parama.AmG.getMeasuredHeight());
      a.a(parama.pJJ, parama.AmH, a.this.Amz, a.this.AmA);
      com.tencent.mm.plugin.fts.ui.o.a(a.this.AmB, parama.AmI);
      if (a.this.Amy)
      {
        parama.pKl.setVisibility(0);
        AppMethodBeat.o(107302);
        return;
      }
      parama.pKl.setVisibility(8);
      AppMethodBeat.o(107302);
    }
    
    public final boolean a(Context paramContext, View paramView, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
    {
      AppMethodBeat.i(274470);
      paramView = (a)paramVarArgs;
      paramVarArgs = new ht();
      paramVarArgs.hIR.type = 10;
      paramVarArgs.hIR.hDn = paramView.rpp.HtI;
      paramVarArgs.hIR.context = paramContext;
      paramVarArgs.hIR.hJc = new arx();
      if (a.this.pageType == 1) {}
      for (paramVarArgs.hIR.hJc.scene = 3;; paramVarArgs.hIR.hJc.scene = 4)
      {
        paramVarArgs.hIR.hJc.AcJ = 3;
        paramVarArgs.hIR.hJc.index = a.this.Hur;
        paramVarArgs.publish();
        AppMethodBeat.o(274470);
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.c.a
 * JD-Core Version:    0.7.0.1
 */