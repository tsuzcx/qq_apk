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
import com.tencent.mm.g.a.gx;
import com.tencent.mm.g.a.gx.a;
import com.tencent.mm.g.a.gx.b;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ai.a;
import com.tencent.mm.model.ai.b;
import com.tencent.mm.model.x;
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
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.akc;
import com.tencent.mm.protocal.protobuf.ake;
import com.tencent.mm.protocal.protobuf.akm;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.akp;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMImageView;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a
  extends com.tencent.mm.plugin.fts.a.d.a.a
{
  private static final aq handler;
  private static final String rJS;
  private static final Pattern rJT;
  public String jpU;
  public m kno;
  public boolean rJU;
  public CharSequence rJV;
  public CharSequence rJW;
  public CharSequence rJX;
  public String rJY;
  public int rJZ;
  private b rKa;
  a rKb;
  
  static
  {
    AppMethodBeat.i(107310);
    rJS = ak.getContext().getString(2131759711);
    rJT = Pattern.compile("['\r\n' | '\n']+");
    handler = new aq(Looper.getMainLooper());
    AppMethodBeat.o(107310);
  }
  
  public a(int paramInt)
  {
    super(6, paramInt);
    AppMethodBeat.i(107305);
    this.rKa = new b();
    this.rKb = new a();
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
  
  private static String b(Context paramContext, an paraman)
  {
    AppMethodBeat.i(107308);
    String str2 = paraman.field_conRemark;
    String str1 = str2;
    if (bu.isNullOrNil(str2)) {
      str1 = paraman.field_nickname;
    }
    paraman = str1;
    if (bu.isNullOrNil(str1)) {
      paraman = paramContext.getString(2131759681);
    }
    AppMethodBeat.o(107308);
    return paraman;
  }
  
  private static String c(an paraman, boolean paramBoolean)
  {
    AppMethodBeat.i(107307);
    if ((paramBoolean) && (!bu.isNullOrNil(paraman.field_conRemark))) {}
    for (String str1 = paraman.field_conRemark;; str1 = paraman.field_nickname)
    {
      String str2 = str1;
      if (bu.isNullOrNil(str1)) {
        str2 = paraman.field_username;
      }
      AppMethodBeat.o(107307);
      return str2;
    }
  }
  
  private String dx(List<String> paramList)
  {
    AppMethodBeat.i(107309);
    StringBuffer localStringBuffer = new StringBuffer();
    String[] arrayOfString = this.tFe.tFE;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str1 = arrayOfString[i];
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        if (d.alm(str2).contains(str1))
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
    long l = this.kno.tGf;
    parama = new gx();
    parama.dub.type = 9;
    parama.dub.doH = l;
    com.tencent.mm.sdk.b.a.IvT.l(parama);
    akc localakc = parama.duc.dun;
    Object localObject;
    float f;
    label266:
    label308:
    int i;
    if (localakc != null)
    {
      l = this.kno.tGf;
      parama = new gx();
      parama.dub.type = 11;
      parama.dub.doH = l;
      parama.dub.handler = handler;
      com.tencent.mm.sdk.b.a.IvT.l(parama);
      this.rJY = bu.bI(parama.duc.thumbPath, "");
      this.jpU = bu.bI(parama.duc.thumbUrl, "");
      localObject = this.kno;
      f = b.a.tIQ * 2;
      paramVarArgs = localakc.dFV;
      parama = "";
      switch (localakc.type)
      {
      case 5: 
      case 8: 
      case 9: 
      case 12: 
      case 13: 
      case 15: 
      default: 
        parama = localakc.title;
        switch (((m)localObject).tEX)
        {
        default: 
          this.rJV = parama;
          paramVarArgs = this.kno;
          localObject = localakc.dFV;
          parama = "";
          switch (localakc.type)
          {
          case 3: 
          case 4: 
          case 8: 
          case 9: 
          case 13: 
          default: 
            parama = "";
            label407:
            switch (paramVarArgs.tEX)
            {
            default: 
              paramVarArgs = "";
              i = -1;
              label458:
              if ((i == -1) || (bu.isNullOrNil(parama))) {}
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
      this.rJW = parama;
      m localm = this.kno;
      paramVarArgs = localakc.dzZ;
      parama = localakc.GBP;
      if (bu.isNullOrNil(paramVarArgs))
      {
        localObject = null;
        paramVarArgs = parama;
        parama = (com.tencent.mm.plugin.fts.a.d.a.a.a)localObject;
      }
      for (;;)
      {
        if (bu.isNullOrNil(paramVarArgs)) {}
        label605:
        an localan;
        label1293:
        boolean bool3;
        label1345:
        label1382:
        for (paramContext = new SpannableString("");; paramContext = TextUtils.concat(new CharSequence[] { paramContext.getResources().getString(2131762917), parama }))
        {
          this.rJX = paramContext;
          switch (localakc.type)
          {
          case 7: 
          default: 
            i = 2131690253;
            this.rJZ = i;
            AppMethodBeat.o(107306);
            return;
            parama = rJT.matcher(localakc.desc).replaceAll(" ");
            break label266;
            parama = paramContext.getResources().getString(2131762946);
            break label266;
            parama = localakc.dFV.GBd;
            if ((rJS.equals(parama.dEv)) || (bu.isNullOrNil(parama.dEv)))
            {
              parama = parama.label;
              break label266;
            }
            parama = parama.dEv;
            break label266;
            parama = paramContext.getResources().getString(2131762950);
            break label266;
            parama = paramContext.getResources().getString(2131762951);
            break label266;
            if (paramVarArgs.GBh == null) {
              break label266;
            }
            parama = paramVarArgs.GBh.title;
            break label266;
            parama = new StringBuffer();
            paramVarArgs = paramVarArgs.oeJ.iterator();
            while (paramVarArgs.hasNext())
            {
              str = b.c((ajx)paramVarArgs.next());
              if (!bu.isNullOrNil(str))
              {
                parama.append(str);
                parama.append(" ");
              }
            }
            paramVarArgs = rJT.matcher(parama.toString()).replaceAll(" ");
            parama = paramVarArgs;
            if (!bu.isNullOrNil(paramVarArgs)) {
              break label266;
            }
            parama = paramContext.getResources().getString(2131762948);
            break label266;
            paramVarArgs = localakc.title;
            parama = paramVarArgs;
            if (bu.isNullOrNil(localakc.desc)) {
              break label266;
            }
            parama = paramVarArgs + "-" + localakc.desc;
            break label266;
            parama = paramContext.getResources().getString(2131762949);
            break label266;
            parama = com.tencent.mm.plugin.fts.a.f.a(e.a(parama, this.tFe, f, b.c.tIZ)).tFv;
            break label308;
            if (bu.isNullOrNil(localakc.appId)) {
              break label407;
            }
            parama = ai.a.hIE.r(paramContext, localakc.appId);
            break label407;
            parama = localakc.title;
            break label407;
            parama = localakc.dFV.GBd;
            if ((rJS.equals(parama.dEv)) || (bu.isNullOrNil(parama.dEv)))
            {
              parama = parama.label;
              break label407;
            }
            parama = parama.dEv;
            break label407;
            if (((akn)localObject).GBh == null) {
              break label407;
            }
            parama = ((akn)localObject).GBh.desc;
            break label407;
            parama = "";
            break label407;
            i = 2131762945;
            paramVarArgs = com.tencent.mm.plugin.fts.a.f.a(e.a(parama, this.tFe)).tFv;
            break label458;
            i = 2131762947;
            parama = dx(localakc.GBQ);
            paramVarArgs = com.tencent.mm.plugin.fts.a.f.a(e.a(parama, this.tFe)).tFv;
            break label458;
            paramVarArgs = com.tencent.mm.plugin.fts.a.f.a(e.a(parama, this.tFe)).tFv;
            i = -1;
            break label458;
            localan = ((l)g.ab(l.class)).azF().BH(paramVarArgs);
            localan.setUsername(paramVarArgs);
            String str = null;
            localObject = str;
            if (x.wb(paramVarArgs))
            {
              localObject = str;
              if (!bu.isNullOrNil(parama))
              {
                localObject = ((l)g.ab(l.class)).azF().BH(parama);
                ((an)localObject).setUsername(parama);
              }
            }
            switch (localm.tEX)
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
              parama = c((an)localObject, true) + "-" + b(paramContext, localan);
              bool3 = bool2;
              bool2 = bool1;
              bool1 = bool3;
              parama = k.b(paramContext, parama, com.tencent.mm.cb.a.ax(paramContext, 2131165466));
              if (i == 0) {
                break label1821;
              }
              parama = com.tencent.mm.plugin.fts.a.f.a(e.a(parama, this.tFe, bool2, bool1)).tFv;
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
            parama = c((an)localObject, false) + "-" + b(paramContext, localan);
            bool3 = bool1;
            i = 1;
            bool1 = bool2;
            bool2 = bool3;
            break label1345;
          }
          parama = c(localan, false);
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
              parama = c((an)localObject, true) + "-" + b(paramContext, localan);
            }
            for (;;)
            {
              paramVarArgs = ((l)g.ab(l.class)).azF().BH(localakc.dkZ);
              parama = parama + "-" + c(paramVarArgs, true);
              i = 1;
              break;
              if (x.wb(localan.field_username)) {
                parama = b(paramContext, localan);
              } else {
                parama = c(localan, true);
              }
            }
            bool2 = true;
            label1639:
            for (bool1 = true;; bool1 = false)
            {
              i = 1;
              break label1293;
              label1648:
              if (x.wb(localan.field_username))
              {
                parama = b(paramContext, localan);
                bool3 = bool1;
                bool1 = bool2;
                bool2 = bool3;
                break label1345;
              }
              parama = c(localan, true);
              bool3 = bool1;
              bool1 = bool2;
              bool2 = bool3;
              break label1345;
              if ((localakc.dFV.oeJ == null) || (localakc.dFV.oeJ.size() <= 0)) {
                break;
              }
              i = com.tencent.mm.pluginsdk.f.aME(((ajx)localakc.dFV.oeJ.get(0)).GzP);
              break label605;
              i = 2131689584;
              break label605;
              i = 2131689583;
              break label605;
              i = 2131689581;
              break label605;
              i = 2131689562;
              break label605;
              ae.i("MicroMsg.FTS.FTSFavoriteDataItem", "favExportInfo is null, id: " + this.kno.tGf);
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
  
  public final com.tencent.mm.plugin.fts.a.d.a.a.b agQ()
  {
    return this.rKa;
  }
  
  public final int bhE()
  {
    return this.kno.tGo;
  }
  
  public final class a
    extends com.tencent.mm.plugin.fts.a.d.a.a.a
  {
    public View iYM;
    public TextView iYj;
    public MMImageView rKc;
    public TextView rKd;
    public TextView rKe;
    
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
      paramViewGroup = (a.a)a.this.rKb;
      paramViewGroup.rKc = ((MMImageView)paramContext.findViewById(2131297008));
      paramViewGroup.iYj = ((TextView)paramContext.findViewById(2131305948));
      paramViewGroup.rKd = ((TextView)paramContext.findViewById(2131296310));
      paramViewGroup.rKe = ((TextView)paramContext.findViewById(2131305208));
      paramViewGroup.iYM = paramContext.findViewById(2131299154);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(107301);
      return paramContext;
    }
    
    public final void a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a.a parama, com.tencent.mm.plugin.fts.a.d.a.a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(107302);
      parama = (a.a)parama;
      parama1 = (a)parama1;
      n.a(paramContext, parama.rKc, parama1.jpU, parama1.rJY, parama1.rJZ, parama.rKc.getMeasuredWidth(), parama.rKc.getMeasuredHeight());
      a.a(parama.iYj, parama.rKd, a.this.rJV, a.this.rJW);
      n.a(a.this.rJX, parama.rKe);
      if (a.this.rJU)
      {
        parama.iYM.setVisibility(0);
        AppMethodBeat.o(107302);
        return;
      }
      parama.iYM.setVisibility(8);
      AppMethodBeat.o(107302);
    }
    
    public final boolean a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
    {
      AppMethodBeat.i(107303);
      paramVarArgs = (a)paramVarArgs;
      gx localgx = new gx();
      localgx.dub.type = 10;
      localgx.dub.doH = paramVarArgs.kno.tGf;
      localgx.dub.context = paramContext;
      localgx.dub.dum = new akp();
      if (a.this.pageType == 1) {}
      for (localgx.dub.dum.scene = 3;; localgx.dub.dum.scene = 4)
      {
        localgx.dub.dum.otZ = 3;
        localgx.dub.dum.index = a.this.tGN;
        com.tencent.mm.sdk.b.a.IvT.l(localgx);
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