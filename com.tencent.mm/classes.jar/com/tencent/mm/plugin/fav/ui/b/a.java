package com.tencent.mm.plugin.fav.ui.b;

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
import com.tencent.mm.g.a.hb;
import com.tencent.mm.g.a.hb.a;
import com.tencent.mm.g.a.hb.b;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.b;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.ui.b.a;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amq;
import com.tencent.mm.protocal.protobuf.ams;
import com.tencent.mm.protocal.protobuf.ana;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.and;
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
  private static final String tjD;
  private static final Pattern tjE;
  public String kog;
  public m lqW;
  public boolean tjF;
  public CharSequence tjG;
  public CharSequence tjH;
  public CharSequence tjI;
  public String tjJ;
  public int tjK;
  private b tjL;
  a tjM;
  
  static
  {
    AppMethodBeat.i(107310);
    tjD = MMApplicationContext.getContext().getString(2131761032);
    tjE = Pattern.compile("['\r\n' | '\n']+");
    handler = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(107310);
  }
  
  public a(int paramInt)
  {
    super(6, paramInt);
    AppMethodBeat.i(107305);
    this.tjL = new b();
    this.tjM = new a();
    AppMethodBeat.o(107305);
  }
  
  public static void a(TextView paramTextView1, TextView paramTextView2, CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    AppMethodBeat.i(107304);
    if (n.a(paramCharSequence1, paramTextView1))
    {
      if (n.a(paramCharSequence2, paramTextView2))
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
    if (n.a(paramCharSequence2, paramTextView2)) {
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
      paramas = paramContext.getString(2131761002);
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
  
  private String dL(List<String> paramList)
  {
    AppMethodBeat.i(107309);
    StringBuffer localStringBuffer = new StringBuffer();
    String[] arrayOfString = this.wWd.wWD;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str1 = arrayOfString[i];
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        if (d.ayq(str2).contains(str1))
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
    long l = this.lqW.wXe;
    parama = new hb();
    parama.dLm.type = 9;
    parama.dLm.dFW = l;
    EventCenter.instance.publish(parama);
    amq localamq = parama.dLn.dLy;
    Object localObject;
    float f;
    label286:
    label328:
    int i;
    if (localamq != null)
    {
      l = this.lqW.wXe;
      parama = new hb();
      parama.dLm.type = 11;
      parama.dLm.dFW = l;
      parama.dLm.handler = handler;
      EventCenter.instance.publish(parama);
      this.tjJ = Util.nullAs(parama.dLn.thumbPath, "");
      this.kog = Util.nullAs(parama.dLn.thumbUrl, "");
      localObject = this.lqW;
      f = b.a.wZP * 2;
      paramVarArgs = localamq.dXI;
      parama = "";
      switch (localamq.type)
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
        parama = localamq.title;
        switch (((m)localObject).wVW)
        {
        default: 
          this.tjG = parama;
          paramVarArgs = this.lqW;
          localObject = localamq.dXI;
          parama = "";
          switch (localamq.type)
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
            switch (paramVarArgs.wVW)
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
      this.tjH = parama;
      m localm = this.lqW;
      paramVarArgs = localamq.dRL;
      parama = localamq.LxL;
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
        for (paramContext = new SpannableString("");; paramContext = TextUtils.concat(new CharSequence[] { paramContext.getResources().getString(2131765053), parama }))
        {
          this.tjI = paramContext;
          switch (localamq.type)
          {
          case 7: 
          default: 
            i = 2131690349;
            this.tjK = i;
            AppMethodBeat.o(107306);
            return;
            parama = tjE.matcher(localamq.desc).replaceAll(" ");
            break label286;
            parama = paramContext.getResources().getString(2131765082);
            break label286;
            parama = localamq.dXI.LwQ;
            if ((tjD.equals(parama.dWi)) || (Util.isNullOrNil(parama.dWi)))
            {
              parama = parama.label;
              break label286;
            }
            parama = parama.dWi;
            break label286;
            parama = paramContext.getResources().getString(2131765086);
            break label286;
            parama = paramContext.getResources().getString(2131765087);
            break label286;
            if (paramVarArgs.LwU == null) {
              break label286;
            }
            parama = paramVarArgs.LwU.title;
            break label286;
            parama = new StringBuffer();
            paramVarArgs = paramVarArgs.ppH.iterator();
            while (paramVarArgs.hasNext())
            {
              str = b.c((aml)paramVarArgs.next());
              if (!Util.isNullOrNil(str))
              {
                parama.append(str);
                parama.append(" ");
              }
            }
            paramVarArgs = tjE.matcher(parama.toString()).replaceAll(" ");
            parama = paramVarArgs;
            if (!Util.isNullOrNil(paramVarArgs)) {
              break label286;
            }
            parama = paramContext.getResources().getString(2131765084);
            break label286;
            paramVarArgs = localamq.title;
            parama = paramVarArgs;
            if (Util.isNullOrNil(localamq.desc)) {
              break label286;
            }
            parama = paramVarArgs + "-" + localamq.desc;
            break label286;
            parama = paramContext.getResources().getString(2131765085);
            break label286;
            parama = com.tencent.mm.plugin.fts.a.f.a(e.a(parama, this.wWd, f, b.c.wZY)).wWu;
            break label328;
            if (Util.isNullOrNil(localamq.appId)) {
              break label451;
            }
            parama = am.a.iDo.r(paramContext, localamq.appId);
            break label451;
            parama = localamq.title;
            break label451;
            parama = localamq.dXI.LwQ;
            if ((tjD.equals(parama.dWi)) || (Util.isNullOrNil(parama.dWi)))
            {
              parama = parama.label;
              break label451;
            }
            parama = parama.dWi;
            break label451;
            if (((anb)localObject).LwU == null) {
              break label451;
            }
            parama = ((anb)localObject).LwU.desc;
            break label451;
            parama = "";
            break label451;
            i = 2131765081;
            paramVarArgs = com.tencent.mm.plugin.fts.a.f.a(e.a(parama, this.wWd)).wWu;
            break label502;
            i = 2131765083;
            parama = dL(localamq.LxM);
            paramVarArgs = com.tencent.mm.plugin.fts.a.f.a(e.a(parama, this.wWd)).wWu;
            break label502;
            paramVarArgs = com.tencent.mm.plugin.fts.a.f.a(e.a(parama, this.wWd)).wWu;
            i = -1;
            break label502;
            localas = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramVarArgs);
            localas.setUsername(paramVarArgs);
            String str = null;
            localObject = str;
            if (ab.Eq(paramVarArgs))
            {
              localObject = str;
              if (!Util.isNullOrNil(parama))
              {
                localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(parama);
                ((as)localObject).setUsername(parama);
              }
            }
            switch (localm.wVW)
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
              parama = com.tencent.mm.pluginsdk.ui.span.l.e(paramContext, parama, com.tencent.mm.cb.a.aG(paramContext, 2131165482));
              if (i == 0) {
                break label1865;
              }
              parama = com.tencent.mm.plugin.fts.a.f.a(e.a(parama, this.wWd, bool2, bool1)).wWu;
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
              paramVarArgs = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(localamq.dCl);
              parama = parama + "-" + c(paramVarArgs, true);
              i = 1;
              break;
              if (ab.Eq(localas.field_username)) {
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
              if (ab.Eq(localas.field_username))
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
              if ((localamq.dXI.ppH == null) || (localamq.dXI.ppH.size() <= 0)) {
                break;
              }
              i = com.tencent.mm.pluginsdk.f.bcX(((aml)localamq.dXI.ppH.get(0)).LvC);
              break label649;
              i = 2131689587;
              break label649;
              i = 2131689586;
              break label649;
              i = 2131689584;
              break label649;
              i = 2131689565;
              break label649;
              Log.i("MicroMsg.FTS.FTSFavoriteDataItem", "favExportInfo is null, id: " + this.lqW.wXe);
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
  
  public final com.tencent.mm.plugin.fts.a.d.a.a.b axc()
  {
    return this.tjL;
  }
  
  public final int bCS()
  {
    return this.lqW.wXn;
  }
  
  public final class a
    extends com.tencent.mm.plugin.fts.a.d.a.a.a
  {
    public TextView jVO;
    public View jWr;
    public MMImageView tjN;
    public TextView tjO;
    public TextView tjP;
    
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
      paramContext = LayoutInflater.from(paramContext).inflate(2131494753, paramViewGroup, false);
      paramViewGroup = (a.a)a.this.tjM;
      paramViewGroup.tjN = ((MMImageView)paramContext.findViewById(2131297134));
      paramViewGroup.jVO = ((TextView)paramContext.findViewById(2131309249));
      paramViewGroup.tjO = ((TextView)paramContext.findViewById(2131296323));
      paramViewGroup.tjP = ((TextView)paramContext.findViewById(2131308405));
      paramViewGroup.jWr = paramContext.findViewById(2131299682);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(107301);
      return paramContext;
    }
    
    public final void a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a.a parama, com.tencent.mm.plugin.fts.a.d.a.a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(107302);
      parama = (a.a)parama;
      parama1 = (a)parama1;
      n.a(paramContext, parama.tjN, parama1.kog, parama1.tjJ, parama1.tjK, parama.tjN.getMeasuredWidth(), parama.tjN.getMeasuredHeight());
      a.a(parama.jVO, parama.tjO, a.this.tjG, a.this.tjH);
      n.a(a.this.tjI, parama.tjP);
      if (a.this.tjF)
      {
        parama.jWr.setVisibility(0);
        AppMethodBeat.o(107302);
        return;
      }
      parama.jWr.setVisibility(8);
      AppMethodBeat.o(107302);
    }
    
    public final boolean a(Context paramContext, View paramView, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
    {
      AppMethodBeat.i(235340);
      paramView = (a)paramVarArgs;
      paramVarArgs = new hb();
      paramVarArgs.dLm.type = 10;
      paramVarArgs.dLm.dFW = paramView.lqW.wXe;
      paramVarArgs.dLm.context = paramContext;
      paramVarArgs.dLm.dLx = new and();
      if (a.this.pageType == 1) {}
      for (paramVarArgs.dLm.dLx.scene = 3;; paramVarArgs.dLm.dLx.scene = 4)
      {
        paramVarArgs.dLm.dLx.pHw = 3;
        paramVarArgs.dLm.dLx.index = a.this.wXM;
        EventCenter.instance.publish(paramVarArgs);
        AppMethodBeat.o(235340);
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.b.a
 * JD-Core Version:    0.7.0.1
 */