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
import com.tencent.mm.f.a.hi;
import com.tencent.mm.f.a.hi.a;
import com.tencent.mm.f.a.hi.b;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.b;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.ui.s.c;
import com.tencent.mm.plugin.fav.ui.s.e;
import com.tencent.mm.plugin.fav.ui.s.f;
import com.tencent.mm.plugin.fav.ui.s.h;
import com.tencent.mm.plugin.fav.ui.s.i;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.ui.b.a;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.anr;
import com.tencent.mm.protocal.protobuf.ant;
import com.tencent.mm.protocal.protobuf.aob;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aoe;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMImageView;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a
  extends com.tencent.mm.plugin.fts.a.d.a.a
{
  private static final MMHandler handler;
  private static final String wPU;
  private static final Pattern wPV;
  public String nfY;
  public m olG;
  public boolean wPW;
  public CharSequence wPX;
  public CharSequence wPY;
  public CharSequence wPZ;
  public String wQa;
  public int wQb;
  private b wQc;
  a wQd;
  
  static
  {
    AppMethodBeat.i(107310);
    wPU = MMApplicationContext.getContext().getString(s.i.fts_message_location_tag);
    wPV = Pattern.compile("['\r\n' | '\n']+");
    handler = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(107310);
  }
  
  public a(int paramInt)
  {
    super(6, paramInt);
    AppMethodBeat.i(107305);
    this.wQc = new b();
    this.wQd = new a();
    AppMethodBeat.o(107305);
  }
  
  public static void a(TextView paramTextView1, TextView paramTextView2, CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    AppMethodBeat.i(107304);
    if (com.tencent.mm.plugin.fts.ui.n.a(paramCharSequence1, paramTextView1))
    {
      if (com.tencent.mm.plugin.fts.ui.n.a(paramCharSequence2, paramTextView2))
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
    if (com.tencent.mm.plugin.fts.ui.n.a(paramCharSequence2, paramTextView2)) {
      paramTextView2.setMaxLines(2);
    }
    AppMethodBeat.o(107304);
  }
  
  private static String b(Context paramContext, as paramas)
  {
    AppMethodBeat.i(107308);
    String str2 = paramas.field_conRemark;
    String str1 = str2;
    if (Util.isNullOrNil(str2)) {
      str1 = paramas.field_nickname;
    }
    paramas = str1;
    if (Util.isNullOrNil(str1)) {
      paramas = paramContext.getString(s.i.fts_header_chatroom);
    }
    AppMethodBeat.o(107308);
    return paramas;
  }
  
  private static String c(as paramas, boolean paramBoolean)
  {
    AppMethodBeat.i(107307);
    if ((paramBoolean) && (!Util.isNullOrNil(paramas.field_conRemark))) {}
    for (String str1 = paramas.field_conRemark;; str1 = paramas.field_nickname)
    {
      String str2 = str1;
      if (Util.isNullOrNil(str1)) {
        str2 = paramas.field_username;
      }
      AppMethodBeat.o(107307);
      return str2;
    }
  }
  
  private String dR(List<String> paramList)
  {
    AppMethodBeat.i(107309);
    StringBuffer localStringBuffer = new StringBuffer();
    String[] arrayOfString = this.BHY.BIy;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str1 = arrayOfString[i];
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        if (d.aHJ(str2).contains(str1))
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
    long l = this.olG.BIZ;
    parama = new hi();
    parama.fEb.type = 9;
    parama.fEb.fyE = l;
    EventCenter.instance.publish(parama);
    anr localanr = parama.fEc.fEn;
    Object localObject;
    float f;
    label286:
    label328:
    int i;
    if (localanr != null)
    {
      l = this.olG.BIZ;
      parama = new hi();
      parama.fEb.type = 11;
      parama.fEb.fyE = l;
      parama.fEb.handler = handler;
      EventCenter.instance.publish(parama);
      this.wQa = Util.nullAs(parama.fEc.thumbPath, "");
      this.nfY = Util.nullAs(parama.fEc.thumbUrl, "");
      localObject = this.olG;
      f = b.a.BLO * 2;
      paramVarArgs = localanr.fRz;
      parama = "";
      switch (localanr.type)
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
        parama = localanr.title;
        switch (((m)localObject).BHR)
        {
        default: 
          this.wPX = parama;
          paramVarArgs = this.olG;
          localObject = localanr.fRz;
          parama = "";
          switch (localanr.type)
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
            label451:
            switch (paramVarArgs.BHR)
            {
            default: 
              paramVarArgs = "";
              i = -1;
              label502:
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
    label649:
    label1546:
    for (parama = TextUtils.concat(new CharSequence[] { paramContext.getResources().getString(i), paramVarArgs });; parama = paramVarArgs)
    {
      this.wPY = parama;
      m localm = this.olG;
      paramVarArgs = localanr.fLi;
      parama = localanr.SAm;
      if (Util.isNullOrNil(paramVarArgs))
      {
        localObject = null;
        paramVarArgs = parama;
        parama = (com.tencent.mm.plugin.fts.a.d.a.a.a)localObject;
      }
      label1426:
      label1683:
      label1692:
      for (;;)
      {
        if (Util.isNullOrNil(paramVarArgs)) {}
        as localas;
        label1337:
        boolean bool3;
        for (paramContext = new SpannableString("");; paramContext = TextUtils.concat(new CharSequence[] { paramContext.getResources().getString(s.i.search_contact_favorite_status), parama }))
        {
          this.wPZ = paramContext;
          switch (localanr.type)
          {
          case 7: 
          default: 
            i = s.h.fts_default_img;
            this.wQb = i;
            AppMethodBeat.o(107306);
            return;
            parama = wPV.matcher(localanr.desc).replaceAll(" ");
            break label286;
            parama = paramContext.getResources().getString(s.i.search_favorite_img_tips);
            break label286;
            parama = localanr.fRz.Szp;
            if ((wPU.equals(parama.fPN)) || (Util.isNullOrNil(parama.fPN)))
            {
              parama = parama.label;
              break label286;
            }
            parama = parama.fPN;
            break label286;
            parama = paramContext.getResources().getString(s.i.search_favorite_video_tips);
            break label286;
            parama = paramContext.getResources().getString(s.i.search_favorite_voice_tips);
            break label286;
            if (paramVarArgs.Szt == null) {
              break label286;
            }
            parama = paramVarArgs.Szt.title;
            break label286;
            parama = new StringBuffer();
            paramVarArgs = paramVarArgs.syG.iterator();
            while (paramVarArgs.hasNext())
            {
              str = b.c((anm)paramVarArgs.next());
              if (!Util.isNullOrNil(str))
              {
                parama.append(str);
                parama.append(" ");
              }
            }
            paramVarArgs = wPV.matcher(parama.toString()).replaceAll(" ");
            parama = paramVarArgs;
            if (!Util.isNullOrNil(paramVarArgs)) {
              break label286;
            }
            parama = paramContext.getResources().getString(s.i.search_favorite_record_tips);
            break label286;
            paramVarArgs = localanr.title;
            parama = paramVarArgs;
            if (Util.isNullOrNil(localanr.desc)) {
              break label286;
            }
            parama = paramVarArgs + "-" + localanr.desc;
            break label286;
            parama = paramContext.getResources().getString(s.i.search_favorite_sight_tips);
            break label286;
            parama = com.tencent.mm.plugin.fts.a.f.a(e.a(parama, this.BHY, f, b.c.BLX)).BIp;
            break label328;
            if (Util.isNullOrNil(localanr.appId)) {
              break label451;
            }
            parama = am.a.lto.t(paramContext, localanr.appId);
            break label451;
            parama = localanr.title;
            break label451;
            parama = localanr.fRz.Szp;
            if ((wPU.equals(parama.fPN)) || (Util.isNullOrNil(parama.fPN)))
            {
              parama = parama.label;
              break label451;
            }
            parama = parama.fPN;
            break label451;
            if (((aoc)localObject).Szt == null) {
              break label451;
            }
            parama = ((aoc)localObject).Szt.desc;
            break label451;
            parama = "";
            break label451;
            i = s.i.search_favorite_img_orc_tips;
            paramVarArgs = com.tencent.mm.plugin.fts.a.f.a(e.a(parama, this.BHY)).BIp;
            break label502;
            i = s.i.search_favorite_label_tips;
            parama = dR(localanr.SAn);
            paramVarArgs = com.tencent.mm.plugin.fts.a.f.a(e.a(parama, this.BHY)).BIp;
            break label502;
            paramVarArgs = com.tencent.mm.plugin.fts.a.f.a(e.a(parama, this.BHY)).BIp;
            i = -1;
            break label502;
            localas = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(paramVarArgs);
            localas.setUsername(paramVarArgs);
            String str = null;
            localObject = str;
            if (ab.Lj(paramVarArgs))
            {
              localObject = str;
              if (!Util.isNullOrNil(parama))
              {
                localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(parama);
                ((as)localObject).setUsername(parama);
              }
            }
            switch (localm.BHR)
            {
            case 15: 
            case 19: 
            default: 
              bool2 = false;
              bool1 = false;
              i = 0;
              if (localObject == null) {
                break label1692;
              }
              parama = c((as)localObject, true) + "-" + b(paramContext, localas);
              bool3 = bool2;
              bool2 = bool1;
              bool1 = bool3;
              label1389:
              parama = l.d(paramContext, parama, com.tencent.mm.ci.a.aY(paramContext, s.c.HintTextSize));
              if (i == 0) {
                break label1865;
              }
              parama = com.tencent.mm.plugin.fts.a.f.a(e.a(parama, this.BHY, bool2, bool1)).BIp;
            }
            break;
          }
        }
        boolean bool2 = true;
        label1457:
        for (boolean bool1 = true;; bool1 = false)
        {
          if (localObject != null)
          {
            parama = c((as)localObject, false) + "-" + b(paramContext, localas);
            bool3 = bool1;
            i = 1;
            bool1 = bool2;
            bool2 = bool3;
            break label1389;
          }
          parama = c(localas, false);
          bool3 = bool1;
          i = 1;
          bool1 = bool2;
          bool2 = bool3;
          break label1389;
          bool1 = true;
          for (bool2 = true;; bool2 = false)
          {
            if (localObject != null) {
              parama = c((as)localObject, true) + "-" + b(paramContext, localas);
            }
            for (;;)
            {
              paramVarArgs = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(localanr.fuO);
              parama = parama + "-" + c(paramVarArgs, true);
              i = 1;
              break;
              if (ab.Lj(localas.field_username)) {
                parama = b(paramContext, localas);
              } else {
                parama = c(localas, true);
              }
            }
            bool2 = true;
            for (bool1 = true;; bool1 = false)
            {
              i = 1;
              break label1337;
              if (ab.Lj(localas.field_username))
              {
                parama = b(paramContext, localas);
                bool3 = bool1;
                bool1 = bool2;
                bool2 = bool3;
                break label1389;
              }
              parama = c(localas, true);
              bool3 = bool1;
              bool1 = bool2;
              bool2 = bool3;
              break label1389;
              if ((localanr.fRz.syG == null) || (localanr.fRz.syG.size() <= 0)) {
                break;
              }
              i = com.tencent.mm.pluginsdk.f.boX(((anm)localanr.fRz.syG.get(0)).Syc);
              break label649;
              i = s.h.app_attach_file_icon_webpage;
              break label649;
              i = s.h.app_attach_file_icon_voice;
              break label649;
              i = s.h.app_attach_file_icon_video;
              break label649;
              i = s.h.app_attach_file_icon_location;
              break label649;
              Log.i("MicroMsg.FTS.FTSFavoriteDataItem", "favExportInfo is null, id: " + this.olG.BIZ);
              AppMethodBeat.o(107306);
              return;
              label1865:
              break label1426;
              bool2 = false;
              break label1457;
              bool1 = false;
              break label1546;
              bool2 = false;
              break label1683;
              bool2 = false;
            }
            bool1 = false;
          }
          bool2 = false;
        }
      }
    }
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a.b aEw()
  {
    return this.wQc;
  }
  
  public final int bOn()
  {
    return this.olG.BJj;
  }
  
  public final class a
    extends com.tencent.mm.plugin.fts.a.d.a.a.a
  {
    public View mND;
    public TextView mNb;
    public MMImageView wQe;
    public TextView wQf;
    public TextView wQg;
    
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
      paramContext = LayoutInflater.from(paramContext).inflate(s.f.fts_favorite_item, paramViewGroup, false);
      paramViewGroup = (a.a)a.this.wQd;
      paramViewGroup.wQe = ((MMImageView)paramContext.findViewById(s.e.avatar_iv));
      paramViewGroup.mNb = ((TextView)paramContext.findViewById(s.e.title_tv));
      paramViewGroup.wQf = ((TextView)paramContext.findViewById(s.e.abstract_tv));
      paramViewGroup.wQg = ((TextView)paramContext.findViewById(s.e.status_tv));
      paramViewGroup.mND = paramContext.findViewById(s.e.divider);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(107301);
      return paramContext;
    }
    
    public final void a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a.a parama, com.tencent.mm.plugin.fts.a.d.a.a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(107302);
      parama = (a.a)parama;
      parama1 = (a)parama1;
      com.tencent.mm.plugin.fts.ui.n.a(paramContext, parama.wQe, parama1.nfY, parama1.wQa, parama1.wQb, parama.wQe.getMeasuredWidth(), parama.wQe.getMeasuredHeight());
      a.a(parama.mNb, parama.wQf, a.this.wPX, a.this.wPY);
      com.tencent.mm.plugin.fts.ui.n.a(a.this.wPZ, parama.wQg);
      if (a.this.wPW)
      {
        parama.mND.setVisibility(0);
        AppMethodBeat.o(107302);
        return;
      }
      parama.mND.setVisibility(8);
      AppMethodBeat.o(107302);
    }
    
    public final boolean a(Context paramContext, View paramView, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
    {
      AppMethodBeat.i(232494);
      paramView = (a)paramVarArgs;
      paramVarArgs = new hi();
      paramVarArgs.fEb.type = 10;
      paramVarArgs.fEb.fyE = paramView.olG.BIZ;
      paramVarArgs.fEb.context = paramContext;
      paramVarArgs.fEb.fEm = new aoe();
      if (a.this.pageType == 1) {}
      for (paramVarArgs.fEb.fEm.scene = 3;; paramVarArgs.fEb.fEm.scene = 4)
      {
        paramVarArgs.fEb.fEm.wGA = 3;
        paramVarArgs.fEb.fEm.index = a.this.BJI;
        EventCenter.instance.publish(paramVarArgs);
        AppMethodBeat.o(232494);
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.c.a
 * JD-Core Version:    0.7.0.1
 */