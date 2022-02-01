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
import com.tencent.mm.g.a.gs;
import com.tencent.mm.g.a.gs.a;
import com.tencent.mm.g.a.gs.b;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ag.a;
import com.tencent.mm.model.ag.b;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.ui.b.a;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.agd;
import com.tencent.mm.protocal.protobuf.agf;
import com.tencent.mm.protocal.protobuf.agn;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.agq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
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
  private static final String qjf;
  private static final Pattern qjg;
  public String itN;
  public com.tencent.mm.plugin.fts.a.a.m jpy;
  public boolean qjh;
  public CharSequence qji;
  public CharSequence qjj;
  public CharSequence qjk;
  public String qjl;
  public int qjm;
  private b qjn;
  a qjo;
  
  static
  {
    AppMethodBeat.i(107310);
    qjf = aj.getContext().getString(2131759711);
    qjg = Pattern.compile("['\r\n' | '\n']+");
    handler = new ap(Looper.getMainLooper());
    AppMethodBeat.o(107310);
  }
  
  public a(int paramInt)
  {
    super(6, paramInt);
    AppMethodBeat.i(107305);
    this.qjn = new b();
    this.qjo = new a();
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
  
  private static String b(Context paramContext, af paramaf)
  {
    AppMethodBeat.i(107308);
    String str2 = paramaf.field_conRemark;
    String str1 = str2;
    if (bt.isNullOrNil(str2)) {
      str1 = paramaf.field_nickname;
    }
    paramaf = str1;
    if (bt.isNullOrNil(str1)) {
      paramaf = paramContext.getString(2131759681);
    }
    AppMethodBeat.o(107308);
    return paramaf;
  }
  
  private static String b(af paramaf, boolean paramBoolean)
  {
    AppMethodBeat.i(107307);
    if ((paramBoolean) && (!bt.isNullOrNil(paramaf.field_conRemark))) {}
    for (String str1 = paramaf.field_conRemark;; str1 = paramaf.field_nickname)
    {
      String str2 = str1;
      if (bt.isNullOrNil(str1)) {
        str2 = paramaf.field_username;
      }
      AppMethodBeat.o(107307);
      return str2;
    }
  }
  
  private String dq(List<String> paramList)
  {
    AppMethodBeat.i(107309);
    StringBuffer localStringBuffer = new StringBuffer();
    String[] arrayOfString = this.roS.rps;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str1 = arrayOfString[i];
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        if (d.aaY(str2).contains(str1))
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
    long l = this.jpy.rpT;
    parama = new gs();
    parama.dkc.type = 9;
    parama.dkc.deL = l;
    com.tencent.mm.sdk.b.a.ESL.l(parama);
    agd localagd = parama.dkd.dko;
    Object localObject;
    float f;
    label266:
    label308:
    int i;
    if (localagd != null)
    {
      l = this.jpy.rpT;
      parama = new gs();
      parama.dkc.type = 11;
      parama.dkc.deL = l;
      parama.dkc.handler = handler;
      com.tencent.mm.sdk.b.a.ESL.l(parama);
      this.qjl = bt.by(parama.dkd.thumbPath, "");
      this.itN = bt.by(parama.dkd.thumbUrl, "");
      localObject = this.jpy;
      f = b.a.rsE * 2;
      paramVarArgs = localagd.dve;
      parama = "";
      switch (localagd.type)
      {
      case 5: 
      case 8: 
      case 9: 
      case 12: 
      case 13: 
      case 15: 
      default: 
        parama = localagd.title;
        switch (((com.tencent.mm.plugin.fts.a.a.m)localObject).roM)
        {
        default: 
          this.qji = parama;
          paramVarArgs = this.jpy;
          localObject = localagd.dve;
          parama = "";
          switch (localagd.type)
          {
          case 3: 
          case 4: 
          case 8: 
          case 9: 
          case 13: 
          default: 
            parama = "";
            label407:
            switch (paramVarArgs.roM)
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
      this.qjj = parama;
      com.tencent.mm.plugin.fts.a.a.m localm = this.jpy;
      paramVarArgs = localagd.dpv;
      parama = localagd.Dio;
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
        af localaf;
        label1293:
        boolean bool3;
        label1345:
        label1382:
        for (paramContext = new SpannableString("");; paramContext = TextUtils.concat(new CharSequence[] { paramContext.getResources().getString(2131762917), parama }))
        {
          this.qjk = paramContext;
          switch (localagd.type)
          {
          case 7: 
          default: 
            i = 2131690253;
            this.qjm = i;
            AppMethodBeat.o(107306);
            return;
            parama = qjg.matcher(localagd.desc).replaceAll(" ");
            break label266;
            parama = paramContext.getResources().getString(2131762946);
            break label266;
            parama = localagd.dve.DhC;
            if ((qjf.equals(parama.dtN)) || (bt.isNullOrNil(parama.dtN)))
            {
              parama = parama.label;
              break label266;
            }
            parama = parama.dtN;
            break label266;
            parama = paramContext.getResources().getString(2131762950);
            break label266;
            parama = paramContext.getResources().getString(2131762951);
            break label266;
            if (paramVarArgs.DhG == null) {
              break label266;
            }
            parama = paramVarArgs.DhG.title;
            break label266;
            parama = new StringBuffer();
            paramVarArgs = paramVarArgs.mVb.iterator();
            while (paramVarArgs.hasNext())
            {
              str = b.c((afy)paramVarArgs.next());
              if (!bt.isNullOrNil(str))
              {
                parama.append(str);
                parama.append(" ");
              }
            }
            paramVarArgs = qjg.matcher(parama.toString()).replaceAll(" ");
            parama = paramVarArgs;
            if (!bt.isNullOrNil(paramVarArgs)) {
              break label266;
            }
            parama = paramContext.getResources().getString(2131762948);
            break label266;
            paramVarArgs = localagd.title;
            parama = paramVarArgs;
            if (bt.isNullOrNil(localagd.desc)) {
              break label266;
            }
            parama = paramVarArgs + "-" + localagd.desc;
            break label266;
            parama = paramContext.getResources().getString(2131762949);
            break label266;
            parama = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.e.a(parama, this.roS, f, b.c.rsN)).rpj;
            break label308;
            if (bt.isNullOrNil(localagd.appId)) {
              break label407;
            }
            parama = ag.a.gMU.s(paramContext, localagd.appId);
            break label407;
            parama = localagd.title;
            break label407;
            parama = localagd.dve.DhC;
            if ((qjf.equals(parama.dtN)) || (bt.isNullOrNil(parama.dtN)))
            {
              parama = parama.label;
              break label407;
            }
            parama = parama.dtN;
            break label407;
            if (((ago)localObject).DhG == null) {
              break label407;
            }
            parama = ((ago)localObject).DhG.desc;
            break label407;
            parama = "";
            break label407;
            i = 2131762945;
            paramVarArgs = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.e.a(parama, this.roS)).rpj;
            break label458;
            i = 2131762947;
            parama = dq(localagd.Dip);
            paramVarArgs = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.e.a(parama, this.roS)).rpj;
            break label458;
            paramVarArgs = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.e.a(parama, this.roS)).rpj;
            i = -1;
            break label458;
            localaf = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(paramVarArgs);
            localaf.setUsername(paramVarArgs);
            String str = null;
            localObject = str;
            if (w.pF(paramVarArgs))
            {
              localObject = str;
              if (!bt.isNullOrNil(parama))
              {
                localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(parama);
                ((af)localObject).setUsername(parama);
              }
            }
            switch (localm.roM)
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
              parama = b((af)localObject, true) + "-" + b(paramContext, localaf);
              bool3 = bool2;
              bool2 = bool1;
              bool1 = bool3;
              parama = com.tencent.mm.pluginsdk.ui.span.k.b(paramContext, parama, com.tencent.mm.cd.a.ao(paramContext, 2131165466));
              if (i == 0) {
                break label1821;
              }
              parama = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.e.a(parama, this.roS, bool2, bool1)).rpj;
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
            parama = b((af)localObject, false) + "-" + b(paramContext, localaf);
            bool3 = bool1;
            i = 1;
            bool1 = bool2;
            bool2 = bool3;
            break label1345;
          }
          parama = b(localaf, false);
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
              parama = b((af)localObject, true) + "-" + b(paramContext, localaf);
            }
            for (;;)
            {
              paramVarArgs = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(localagd.dbj);
              parama = parama + "-" + b(paramVarArgs, true);
              i = 1;
              break;
              if (w.pF(localaf.field_username)) {
                parama = b(paramContext, localaf);
              } else {
                parama = b(localaf, true);
              }
            }
            bool2 = true;
            label1639:
            for (bool1 = true;; bool1 = false)
            {
              i = 1;
              break label1293;
              label1648:
              if (w.pF(localaf.field_username))
              {
                parama = b(paramContext, localaf);
                bool3 = bool1;
                bool1 = bool2;
                bool2 = bool3;
                break label1345;
              }
              parama = b(localaf, true);
              bool3 = bool1;
              bool1 = bool2;
              bool2 = bool3;
              break label1345;
              if ((localagd.dve.mVb == null) || (localagd.dve.mVb.size() <= 0)) {
                break;
              }
              i = com.tencent.mm.pluginsdk.e.aAq(((afy)localagd.dve.mVb.get(0)).Dgo);
              break label605;
              i = 2131689584;
              break label605;
              i = 2131689583;
              break label605;
              i = 2131689581;
              break label605;
              i = 2131689562;
              break label605;
              ad.i("MicroMsg.FTS.FTSFavoriteDataItem", "favExportInfo is null, id: " + this.jpy.rpT);
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
  
  public final int aWu()
  {
    return this.jpy.rqc;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a.b acQ()
  {
    return this.qjn;
  }
  
  public final class a
    extends com.tencent.mm.plugin.fts.a.d.a.a.a
  {
    public View icB;
    public TextView ica;
    public MMImageView qjp;
    public TextView qjq;
    public TextView qjr;
    
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
      paramViewGroup = (a.a)a.this.qjo;
      paramViewGroup.qjp = ((MMImageView)paramContext.findViewById(2131297008));
      paramViewGroup.ica = ((TextView)paramContext.findViewById(2131305948));
      paramViewGroup.qjq = ((TextView)paramContext.findViewById(2131296310));
      paramViewGroup.qjr = ((TextView)paramContext.findViewById(2131305208));
      paramViewGroup.icB = paramContext.findViewById(2131299154);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(107301);
      return paramContext;
    }
    
    public final void a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a.a parama, com.tencent.mm.plugin.fts.a.d.a.a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(107302);
      parama = (a.a)parama;
      parama1 = (a)parama1;
      com.tencent.mm.plugin.fts.ui.m.a(paramContext, parama.qjp, parama1.itN, parama1.qjl, parama1.qjm, parama.qjp.getMeasuredWidth(), parama.qjp.getMeasuredHeight());
      a.a(parama.ica, parama.qjq, a.this.qji, a.this.qjj);
      com.tencent.mm.plugin.fts.ui.m.a(a.this.qjk, parama.qjr);
      if (a.this.qjh)
      {
        parama.icB.setVisibility(0);
        AppMethodBeat.o(107302);
        return;
      }
      parama.icB.setVisibility(8);
      AppMethodBeat.o(107302);
    }
    
    public final boolean a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
    {
      AppMethodBeat.i(107303);
      paramVarArgs = (a)paramVarArgs;
      gs localgs = new gs();
      localgs.dkc.type = 10;
      localgs.dkc.deL = paramVarArgs.jpy.rpT;
      localgs.dkc.context = paramContext;
      localgs.dkc.dkn = new agq();
      if (a.this.pageType == 1) {}
      for (localgs.dkc.dkn.scene = 3;; localgs.dkc.dkn.scene = 4)
      {
        localgs.dkc.dkn.niJ = 3;
        localgs.dkc.dkn.index = a.this.rqB;
        com.tencent.mm.sdk.b.a.ESL.l(localgs);
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