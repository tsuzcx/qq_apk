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
import com.tencent.mm.g.a.gw;
import com.tencent.mm.g.a.gw.a;
import com.tencent.mm.g.a.gw.b;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ah.a;
import com.tencent.mm.model.ah.b;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.ui.b.a;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.ajs;
import com.tencent.mm.protocal.protobuf.aju;
import com.tencent.mm.protocal.protobuf.akc;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.akf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.MMImageView;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a
  extends com.tencent.mm.plugin.fts.a.d.a.a
{
  private static final ap handler;
  private static final String rBH;
  private static final Pattern rBI;
  public String jna;
  public m kjY;
  public boolean rBJ;
  public CharSequence rBK;
  public CharSequence rBL;
  public CharSequence rBM;
  public String rBN;
  public int rBO;
  private b rBP;
  a rBQ;
  
  static
  {
    AppMethodBeat.i(107310);
    rBH = aj.getContext().getString(2131759711);
    rBI = Pattern.compile("['\r\n' | '\n']+");
    handler = new ap(Looper.getMainLooper());
    AppMethodBeat.o(107310);
  }
  
  public a(int paramInt)
  {
    super(6, paramInt);
    AppMethodBeat.i(107305);
    this.rBP = new b();
    this.rBQ = new a();
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
  
  private static String b(Context paramContext, am paramam)
  {
    AppMethodBeat.i(107308);
    String str2 = paramam.field_conRemark;
    String str1 = str2;
    if (bt.isNullOrNil(str2)) {
      str1 = paramam.field_nickname;
    }
    paramam = str1;
    if (bt.isNullOrNil(str1)) {
      paramam = paramContext.getString(2131759681);
    }
    AppMethodBeat.o(107308);
    return paramam;
  }
  
  private static String c(am paramam, boolean paramBoolean)
  {
    AppMethodBeat.i(107307);
    if ((paramBoolean) && (!bt.isNullOrNil(paramam.field_conRemark))) {}
    for (String str1 = paramam.field_conRemark;; str1 = paramam.field_nickname)
    {
      String str2 = str1;
      if (bt.isNullOrNil(str1)) {
        str2 = paramam.field_username;
      }
      AppMethodBeat.o(107307);
      return str2;
    }
  }
  
  private String du(List<String> paramList)
  {
    AppMethodBeat.i(107309);
    StringBuffer localStringBuffer = new StringBuffer();
    String[] arrayOfString = this.tun.tuN;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str1 = arrayOfString[i];
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        if (d.ako(str2).contains(str1))
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
    long l = this.kjY.tvo;
    parama = new gw();
    parama.dsV.type = 9;
    parama.dsV.dnC = l;
    com.tencent.mm.sdk.b.a.IbL.l(parama);
    ajs localajs = parama.dsW.dth;
    Object localObject;
    float f;
    label266:
    label308:
    int i;
    if (localajs != null)
    {
      l = this.kjY.tvo;
      parama = new gw();
      parama.dsV.type = 11;
      parama.dsV.dnC = l;
      parama.dsV.handler = handler;
      com.tencent.mm.sdk.b.a.IbL.l(parama);
      this.rBN = bt.bI(parama.dsW.thumbPath, "");
      this.jna = bt.bI(parama.dsW.thumbUrl, "");
      localObject = this.kjY;
      f = b.a.txZ * 2;
      paramVarArgs = localajs.dEQ;
      parama = "";
      switch (localajs.type)
      {
      case 5: 
      case 8: 
      case 9: 
      case 12: 
      case 13: 
      case 15: 
      default: 
        parama = localajs.title;
        switch (((m)localObject).tug)
        {
        default: 
          this.rBK = parama;
          paramVarArgs = this.kjY;
          localObject = localajs.dEQ;
          parama = "";
          switch (localajs.type)
          {
          case 3: 
          case 4: 
          case 8: 
          case 9: 
          case 13: 
          default: 
            parama = "";
            label407:
            switch (paramVarArgs.tug)
            {
            default: 
              paramVarArgs = "";
              i = -1;
              label458:
              if ((i == -1) || (bt.isNullOrNil(parama))) {}
              break;
            }
            break;
          }
          break;
        }
        break;
      }
    }
    for (parama = TextUtils.concat(new CharSequence[] { paramContext.getResources().getString(i), paramVarArgs });; parama = paramVarArgs)
    {
      this.rBL = parama;
      m localm = this.kjY;
      paramVarArgs = localajs.dyU;
      parama = localajs.Gjg;
      if (bt.isNullOrNil(paramVarArgs))
      {
        localObject = null;
        paramVarArgs = parama;
        parama = (com.tencent.mm.plugin.fts.a.d.a.a.a)localObject;
      }
      for (;;)
      {
        if (bt.isNullOrNil(paramVarArgs)) {}
        label605:
        am localam;
        label1293:
        boolean bool3;
        label1345:
        label1382:
        for (paramContext = new SpannableString("");; paramContext = TextUtils.concat(new CharSequence[] { paramContext.getResources().getString(2131762917), parama }))
        {
          this.rBM = paramContext;
          switch (localajs.type)
          {
          case 7: 
          default: 
            i = 2131690253;
            this.rBO = i;
            AppMethodBeat.o(107306);
            return;
            parama = rBI.matcher(localajs.desc).replaceAll(" ");
            break label266;
            parama = paramContext.getResources().getString(2131762946);
            break label266;
            parama = localajs.dEQ.Giu;
            if ((rBH.equals(parama.dDq)) || (bt.isNullOrNil(parama.dDq)))
            {
              parama = parama.label;
              break label266;
            }
            parama = parama.dDq;
            break label266;
            parama = paramContext.getResources().getString(2131762950);
            break label266;
            parama = paramContext.getResources().getString(2131762951);
            break label266;
            if (paramVarArgs.Giy == null) {
              break label266;
            }
            parama = paramVarArgs.Giy.title;
            break label266;
            parama = new StringBuffer();
            paramVarArgs = paramVarArgs.nZa.iterator();
            while (paramVarArgs.hasNext())
            {
              str = b.c((ajn)paramVarArgs.next());
              if (!bt.isNullOrNil(str))
              {
                parama.append(str);
                parama.append(" ");
              }
            }
            paramVarArgs = rBI.matcher(parama.toString()).replaceAll(" ");
            parama = paramVarArgs;
            if (!bt.isNullOrNil(paramVarArgs)) {
              break label266;
            }
            parama = paramContext.getResources().getString(2131762948);
            break label266;
            paramVarArgs = localajs.title;
            parama = paramVarArgs;
            if (bt.isNullOrNil(localajs.desc)) {
              break label266;
            }
            parama = paramVarArgs + "-" + localajs.desc;
            break label266;
            parama = paramContext.getResources().getString(2131762949);
            break label266;
            parama = com.tencent.mm.plugin.fts.a.f.a(e.a(parama, this.tun, f, b.c.tyi)).tuE;
            break label308;
            if (bt.isNullOrNil(localajs.appId)) {
              break label407;
            }
            parama = ah.a.hFM.r(paramContext, localajs.appId);
            break label407;
            parama = localajs.title;
            break label407;
            parama = localajs.dEQ.Giu;
            if ((rBH.equals(parama.dDq)) || (bt.isNullOrNil(parama.dDq)))
            {
              parama = parama.label;
              break label407;
            }
            parama = parama.dDq;
            break label407;
            if (((akd)localObject).Giy == null) {
              break label407;
            }
            parama = ((akd)localObject).Giy.desc;
            break label407;
            parama = "";
            break label407;
            i = 2131762945;
            paramVarArgs = com.tencent.mm.plugin.fts.a.f.a(e.a(parama, this.tun)).tuE;
            break label458;
            i = 2131762947;
            parama = du(localajs.Gjh);
            paramVarArgs = com.tencent.mm.plugin.fts.a.f.a(e.a(parama, this.tun)).tuE;
            break label458;
            paramVarArgs = com.tencent.mm.plugin.fts.a.f.a(e.a(parama, this.tun)).tuE;
            i = -1;
            break label458;
            localam = ((l)g.ab(l.class)).azp().Bf(paramVarArgs);
            localam.setUsername(paramVarArgs);
            String str = null;
            localObject = str;
            if (w.vF(paramVarArgs))
            {
              localObject = str;
              if (!bt.isNullOrNil(parama))
              {
                localObject = ((l)g.ab(l.class)).azp().Bf(parama);
                ((am)localObject).setUsername(parama);
              }
            }
            switch (localm.tug)
            {
            case 15: 
            case 19: 
            default: 
              bool2 = false;
              bool1 = false;
              i = 0;
              if (localObject == null) {
                break label1648;
              }
              parama = c((am)localObject, true) + "-" + b(paramContext, localam);
              bool3 = bool2;
              bool2 = bool1;
              bool1 = bool3;
              parama = k.b(paramContext, parama, com.tencent.mm.cc.a.ax(paramContext, 2131165466));
              if (i == 0) {
                break label1821;
              }
              parama = com.tencent.mm.plugin.fts.a.f.a(e.a(parama, this.tun, bool2, bool1)).tuE;
            }
            break;
          }
        }
        boolean bool2 = true;
        label1413:
        for (boolean bool1 = true;; bool1 = false)
        {
          if (localObject != null)
          {
            parama = c((am)localObject, false) + "-" + b(paramContext, localam);
            bool3 = bool1;
            i = 1;
            bool1 = bool2;
            bool2 = bool3;
            break label1345;
          }
          parama = c(localam, false);
          bool3 = bool1;
          i = 1;
          bool1 = bool2;
          bool2 = bool3;
          break label1345;
          bool1 = true;
          label1502:
          for (bool2 = true;; bool2 = false)
          {
            if (localObject != null) {
              parama = c((am)localObject, true) + "-" + b(paramContext, localam);
            }
            for (;;)
            {
              paramVarArgs = ((l)g.ab(l.class)).azp().Bf(localajs.djX);
              parama = parama + "-" + c(paramVarArgs, true);
              i = 1;
              break;
              if (w.vF(localam.field_username)) {
                parama = b(paramContext, localam);
              } else {
                parama = c(localam, true);
              }
            }
            bool2 = true;
            label1639:
            for (bool1 = true;; bool1 = false)
            {
              i = 1;
              break label1293;
              label1648:
              if (w.vF(localam.field_username))
              {
                parama = b(paramContext, localam);
                bool3 = bool1;
                bool1 = bool2;
                bool2 = bool3;
                break label1345;
              }
              parama = c(localam, true);
              bool3 = bool1;
              bool1 = bool2;
              bool2 = bool3;
              break label1345;
              if ((localajs.dEQ.nZa == null) || (localajs.dEQ.nZa.size() <= 0)) {
                break;
              }
              i = com.tencent.mm.pluginsdk.f.aLi(((ajn)localajs.dEQ.nZa.get(0)).Ghg);
              break label605;
              i = 2131689584;
              break label605;
              i = 2131689583;
              break label605;
              i = 2131689581;
              break label605;
              i = 2131689562;
              break label605;
              ad.i("MicroMsg.FTS.FTSFavoriteDataItem", "favExportInfo is null, id: " + this.kjY.tvo);
              AppMethodBeat.o(107306);
              return;
              break label1382;
              bool2 = false;
              break label1413;
              bool1 = false;
              break label1502;
              bool2 = false;
              break label1639;
              bool2 = false;
            }
            bool1 = false;
          }
          label1821:
          bool2 = false;
        }
      }
    }
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a.b agC()
  {
    return this.rBP;
  }
  
  public final int bgW()
  {
    return this.kjY.tvx;
  }
  
  public final class a
    extends com.tencent.mm.plugin.fts.a.d.a.a.a
  {
    public View iVT;
    public TextView iVq;
    public MMImageView rBR;
    public TextView rBS;
    public TextView rBT;
    
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
      paramContext = LayoutInflater.from(paramContext).inflate(2131494200, paramViewGroup, false);
      paramViewGroup = (a.a)a.this.rBQ;
      paramViewGroup.rBR = ((MMImageView)paramContext.findViewById(2131297008));
      paramViewGroup.iVq = ((TextView)paramContext.findViewById(2131305948));
      paramViewGroup.rBS = ((TextView)paramContext.findViewById(2131296310));
      paramViewGroup.rBT = ((TextView)paramContext.findViewById(2131305208));
      paramViewGroup.iVT = paramContext.findViewById(2131299154);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(107301);
      return paramContext;
    }
    
    public final void a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a.a parama, com.tencent.mm.plugin.fts.a.d.a.a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(107302);
      parama = (a.a)parama;
      parama1 = (a)parama1;
      n.a(paramContext, parama.rBR, parama1.jna, parama1.rBN, parama1.rBO, parama.rBR.getMeasuredWidth(), parama.rBR.getMeasuredHeight());
      a.a(parama.iVq, parama.rBS, a.this.rBK, a.this.rBL);
      n.a(a.this.rBM, parama.rBT);
      if (a.this.rBJ)
      {
        parama.iVT.setVisibility(0);
        AppMethodBeat.o(107302);
        return;
      }
      parama.iVT.setVisibility(8);
      AppMethodBeat.o(107302);
    }
    
    public final boolean a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
    {
      AppMethodBeat.i(107303);
      paramVarArgs = (a)paramVarArgs;
      gw localgw = new gw();
      localgw.dsV.type = 10;
      localgw.dsV.dnC = paramVarArgs.kjY.tvo;
      localgw.dsV.context = paramContext;
      localgw.dsV.dtg = new akf();
      if (a.this.pageType == 1) {}
      for (localgw.dsV.dtg.scene = 3;; localgw.dsV.dtg.scene = 4)
      {
        localgw.dsV.dtg.ooi = 3;
        localgw.dsV.dtg.index = a.this.tvW;
        com.tencent.mm.sdk.b.a.IbL.l(localgw);
        AppMethodBeat.o(107303);
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.c.a
 * JD-Core Version:    0.7.0.1
 */