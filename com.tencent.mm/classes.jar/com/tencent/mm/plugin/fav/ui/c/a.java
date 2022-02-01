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
import com.tencent.mm.g.a.gt;
import com.tencent.mm.g.a.gt.a;
import com.tencent.mm.g.a.gt.b;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ag.a;
import com.tencent.mm.model.ag.b;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.ui.b.a;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.ahc;
import com.tencent.mm.protocal.protobuf.ahe;
import com.tencent.mm.protocal.protobuf.ahm;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.ahp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.MMImageView;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a
  extends com.tencent.mm.plugin.fts.a.d.a.a
{
  private static final ao handler;
  private static final String qRH;
  private static final Pattern qRI;
  public String iTS;
  public com.tencent.mm.plugin.fts.a.a.m jPN;
  public boolean qRJ;
  public CharSequence qRK;
  public CharSequence qRL;
  public CharSequence qRM;
  public String qRN;
  public int qRO;
  private b qRP;
  a qRQ;
  
  static
  {
    AppMethodBeat.i(107310);
    qRH = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131759711);
    qRI = Pattern.compile("['\r\n' | '\n']+");
    handler = new ao(Looper.getMainLooper());
    AppMethodBeat.o(107310);
  }
  
  public a(int paramInt)
  {
    super(6, paramInt);
    AppMethodBeat.i(107305);
    this.qRP = new b();
    this.qRQ = new a();
    AppMethodBeat.o(107305);
  }
  
  public static void a(TextView paramTextView1, TextView paramTextView2, CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    AppMethodBeat.i(107304);
    if (com.tencent.mm.plugin.fts.ui.m.a(paramCharSequence1, paramTextView1))
    {
      if (com.tencent.mm.plugin.fts.ui.m.a(paramCharSequence2, paramTextView2))
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
    if (com.tencent.mm.plugin.fts.ui.m.a(paramCharSequence2, paramTextView2)) {
      paramTextView2.setMaxLines(2);
    }
    AppMethodBeat.o(107304);
  }
  
  private static String b(Context paramContext, com.tencent.mm.storage.ai paramai)
  {
    AppMethodBeat.i(107308);
    String str2 = paramai.field_conRemark;
    String str1 = str2;
    if (bs.isNullOrNil(str2)) {
      str1 = paramai.field_nickname;
    }
    paramai = str1;
    if (bs.isNullOrNil(str1)) {
      paramai = paramContext.getString(2131759681);
    }
    AppMethodBeat.o(107308);
    return paramai;
  }
  
  private static String b(com.tencent.mm.storage.ai paramai, boolean paramBoolean)
  {
    AppMethodBeat.i(107307);
    if ((paramBoolean) && (!bs.isNullOrNil(paramai.field_conRemark))) {}
    for (String str1 = paramai.field_conRemark;; str1 = paramai.field_nickname)
    {
      String str2 = str1;
      if (bs.isNullOrNil(str1)) {
        str2 = paramai.field_username;
      }
      AppMethodBeat.o(107307);
      return str2;
    }
  }
  
  private String ds(List<String> paramList)
  {
    AppMethodBeat.i(107309);
    StringBuffer localStringBuffer = new StringBuffer();
    String[] arrayOfString = this.sxM.sym;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str1 = arrayOfString[i];
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        if (d.afQ(str2).contains(str1))
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
    long l = this.jPN.syN;
    parama = new gt();
    parama.dhx.type = 9;
    parama.dhx.dcg = l;
    com.tencent.mm.sdk.b.a.GpY.l(parama);
    ahc localahc = parama.dhy.dhJ;
    Object localObject;
    float f;
    label266:
    label308:
    int i;
    if (localahc != null)
    {
      l = this.jPN.syN;
      parama = new gt();
      parama.dhx.type = 11;
      parama.dhx.dcg = l;
      parama.dhx.handler = handler;
      com.tencent.mm.sdk.b.a.GpY.l(parama);
      this.qRN = bs.bG(parama.dhy.thumbPath, "");
      this.iTS = bs.bG(parama.dhy.thumbUrl, "");
      localObject = this.jPN;
      f = b.a.sBy * 2;
      paramVarArgs = localahc.dsQ;
      parama = "";
      switch (localahc.type)
      {
      case 5: 
      case 8: 
      case 9: 
      case 12: 
      case 13: 
      case 15: 
      default: 
        parama = localahc.title;
        switch (((com.tencent.mm.plugin.fts.a.a.m)localObject).sxF)
        {
        default: 
          this.qRK = parama;
          paramVarArgs = this.jPN;
          localObject = localahc.dsQ;
          parama = "";
          switch (localahc.type)
          {
          case 3: 
          case 4: 
          case 8: 
          case 9: 
          case 13: 
          default: 
            parama = "";
            label407:
            switch (paramVarArgs.sxF)
            {
            default: 
              paramVarArgs = "";
              i = -1;
              label458:
              if ((i == -1) || (bs.isNullOrNil(parama))) {}
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
      this.qRL = parama;
      com.tencent.mm.plugin.fts.a.a.m localm = this.jPN;
      paramVarArgs = localahc.dng;
      parama = localahc.EBu;
      if (bs.isNullOrNil(paramVarArgs))
      {
        localObject = null;
        paramVarArgs = parama;
        parama = (com.tencent.mm.plugin.fts.a.d.a.a.a)localObject;
      }
      for (;;)
      {
        if (bs.isNullOrNil(paramVarArgs)) {}
        label605:
        com.tencent.mm.storage.ai localai;
        label1293:
        boolean bool3;
        label1345:
        label1382:
        for (paramContext = new SpannableString("");; paramContext = TextUtils.concat(new CharSequence[] { paramContext.getResources().getString(2131762917), parama }))
        {
          this.qRM = paramContext;
          switch (localahc.type)
          {
          case 7: 
          default: 
            i = 2131690253;
            this.qRO = i;
            AppMethodBeat.o(107306);
            return;
            parama = qRI.matcher(localahc.desc).replaceAll(" ");
            break label266;
            parama = paramContext.getResources().getString(2131762946);
            break label266;
            parama = localahc.dsQ.EAI;
            if ((qRH.equals(parama.dry)) || (bs.isNullOrNil(parama.dry)))
            {
              parama = parama.label;
              break label266;
            }
            parama = parama.dry;
            break label266;
            parama = paramContext.getResources().getString(2131762950);
            break label266;
            parama = paramContext.getResources().getString(2131762951);
            break label266;
            if (paramVarArgs.EAM == null) {
              break label266;
            }
            parama = paramVarArgs.EAM.title;
            break label266;
            parama = new StringBuffer();
            paramVarArgs = paramVarArgs.nxC.iterator();
            while (paramVarArgs.hasNext())
            {
              str = b.c((agx)paramVarArgs.next());
              if (!bs.isNullOrNil(str))
              {
                parama.append(str);
                parama.append(" ");
              }
            }
            paramVarArgs = qRI.matcher(parama.toString()).replaceAll(" ");
            parama = paramVarArgs;
            if (!bs.isNullOrNil(paramVarArgs)) {
              break label266;
            }
            parama = paramContext.getResources().getString(2131762948);
            break label266;
            paramVarArgs = localahc.title;
            parama = paramVarArgs;
            if (bs.isNullOrNil(localahc.desc)) {
              break label266;
            }
            parama = paramVarArgs + "-" + localahc.desc;
            break label266;
            parama = paramContext.getResources().getString(2131762949);
            break label266;
            parama = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.e.a(parama, this.sxM, f, b.c.sBH)).syd;
            break label308;
            if (bs.isNullOrNil(localahc.appId)) {
              break label407;
            }
            parama = ag.a.hnu.s(paramContext, localahc.appId);
            break label407;
            parama = localahc.title;
            break label407;
            parama = localahc.dsQ.EAI;
            if ((qRH.equals(parama.dry)) || (bs.isNullOrNil(parama.dry)))
            {
              parama = parama.label;
              break label407;
            }
            parama = parama.dry;
            break label407;
            if (((ahn)localObject).EAM == null) {
              break label407;
            }
            parama = ((ahn)localObject).EAM.desc;
            break label407;
            parama = "";
            break label407;
            i = 2131762945;
            paramVarArgs = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.e.a(parama, this.sxM)).syd;
            break label458;
            i = 2131762947;
            parama = ds(localahc.EBv);
            paramVarArgs = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.e.a(parama, this.sxM)).syd;
            break label458;
            paramVarArgs = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.e.a(parama, this.sxM)).syd;
            i = -1;
            break label458;
            localai = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramVarArgs);
            localai.setUsername(paramVarArgs);
            String str = null;
            localObject = str;
            if (w.sQ(paramVarArgs))
            {
              localObject = str;
              if (!bs.isNullOrNil(parama))
              {
                localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(parama);
                ((com.tencent.mm.storage.ai)localObject).setUsername(parama);
              }
            }
            switch (localm.sxF)
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
              parama = b((com.tencent.mm.storage.ai)localObject, true) + "-" + b(paramContext, localai);
              bool3 = bool2;
              bool2 = bool1;
              bool1 = bool3;
              parama = com.tencent.mm.pluginsdk.ui.span.k.b(paramContext, parama, com.tencent.mm.cc.a.au(paramContext, 2131165466));
              if (i == 0) {
                break label1821;
              }
              parama = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.e.a(parama, this.sxM, bool2, bool1)).syd;
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
            parama = b((com.tencent.mm.storage.ai)localObject, false) + "-" + b(paramContext, localai);
            bool3 = bool1;
            i = 1;
            bool1 = bool2;
            bool2 = bool3;
            break label1345;
          }
          parama = b(localai, false);
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
              parama = b((com.tencent.mm.storage.ai)localObject, true) + "-" + b(paramContext, localai);
            }
            for (;;)
            {
              paramVarArgs = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(localahc.cYF);
              parama = parama + "-" + b(paramVarArgs, true);
              i = 1;
              break;
              if (w.sQ(localai.field_username)) {
                parama = b(paramContext, localai);
              } else {
                parama = b(localai, true);
              }
            }
            bool2 = true;
            label1639:
            for (bool1 = true;; bool1 = false)
            {
              i = 1;
              break label1293;
              label1648:
              if (w.sQ(localai.field_username))
              {
                parama = b(paramContext, localai);
                bool3 = bool1;
                bool1 = bool2;
                bool2 = bool3;
                break label1345;
              }
              parama = b(localai, true);
              bool3 = bool1;
              bool1 = bool2;
              bool2 = bool3;
              break label1345;
              if ((localahc.dsQ.nxC == null) || (localahc.dsQ.nxC.size() <= 0)) {
                break;
              }
              i = com.tencent.mm.pluginsdk.e.aFI(((agx)localahc.dsQ.nxC.get(0)).Ezu);
              break label605;
              i = 2131689584;
              break label605;
              i = 2131689583;
              break label605;
              i = 2131689581;
              break label605;
              i = 2131689562;
              break label605;
              ac.i("MicroMsg.FTS.FTSFavoriteDataItem", "favExportInfo is null, id: " + this.jPN.syN);
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
  
  public final com.tencent.mm.plugin.fts.a.d.a.a.b adW()
  {
    return this.qRP;
  }
  
  public final int bds()
  {
    return this.jPN.syW;
  }
  
  public final class a
    extends com.tencent.mm.plugin.fts.a.d.a.a.a
  {
    public View iCJ;
    public TextView iCg;
    public MMImageView qRR;
    public TextView qRS;
    public TextView qRT;
    
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
      paramViewGroup = (a.a)a.this.qRQ;
      paramViewGroup.qRR = ((MMImageView)paramContext.findViewById(2131297008));
      paramViewGroup.iCg = ((TextView)paramContext.findViewById(2131305948));
      paramViewGroup.qRS = ((TextView)paramContext.findViewById(2131296310));
      paramViewGroup.qRT = ((TextView)paramContext.findViewById(2131305208));
      paramViewGroup.iCJ = paramContext.findViewById(2131299154);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(107301);
      return paramContext;
    }
    
    public final void a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a.a parama, com.tencent.mm.plugin.fts.a.d.a.a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(107302);
      parama = (a.a)parama;
      parama1 = (a)parama1;
      com.tencent.mm.plugin.fts.ui.m.a(paramContext, parama.qRR, parama1.iTS, parama1.qRN, parama1.qRO, parama.qRR.getMeasuredWidth(), parama.qRR.getMeasuredHeight());
      a.a(parama.iCg, parama.qRS, a.this.qRK, a.this.qRL);
      com.tencent.mm.plugin.fts.ui.m.a(a.this.qRM, parama.qRT);
      if (a.this.qRJ)
      {
        parama.iCJ.setVisibility(0);
        AppMethodBeat.o(107302);
        return;
      }
      parama.iCJ.setVisibility(8);
      AppMethodBeat.o(107302);
    }
    
    public final boolean a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
    {
      AppMethodBeat.i(107303);
      paramVarArgs = (a)paramVarArgs;
      gt localgt = new gt();
      localgt.dhx.type = 10;
      localgt.dhx.dcg = paramVarArgs.jPN.syN;
      localgt.dhx.context = paramContext;
      localgt.dhx.dhI = new ahp();
      if (a.this.pageType == 1) {}
      for (localgt.dhx.dhI.scene = 3;; localgt.dhx.dhI.scene = 4)
      {
        localgt.dhx.dhI.nLC = 3;
        localgt.dhx.dhI.index = a.this.szv;
        com.tencent.mm.sdk.b.a.GpY.l(localgt);
        AppMethodBeat.o(107303);
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.c.a
 * JD-Core Version:    0.7.0.1
 */