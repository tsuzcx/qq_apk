package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.ui.b.a;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.ary;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv.b;

public class m
  extends com.tencent.mm.plugin.fts.a.d.a.a
{
  public CharSequence heE;
  public CharSequence iYg;
  public com.tencent.mm.plugin.fts.a.a.m kno;
  public int tMw;
  public CharSequence tMx;
  private b tMy;
  a tMz;
  public String username;
  
  public m(int paramInt)
  {
    super(5, paramInt);
    AppMethodBeat.i(112100);
    this.tMy = new b();
    this.tMz = new a();
    AppMethodBeat.o(112100);
  }
  
  public void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112101);
    super.a(paramContext, parama, paramVarArgs);
    parama = (a)parama;
    this.username = this.kno.tEY;
    this.iYg = k.d(paramContext, d.ahd(this.username), parama.fQm.getTextSize());
    if ((this.kno.userData instanceof Integer)) {
      this.tMw = ((Integer)this.kno.userData).intValue();
    }
    if (this.tMw > 1)
    {
      this.heE = paramContext.getResources().getString(2131762956, new Object[] { Integer.valueOf(this.tMw) });
      AppMethodBeat.o(112101);
      return;
    }
    String str;
    Object localObject1;
    Object localObject2;
    if (this.tMw == 1)
    {
      str = "";
      localObject1 = "";
      localObject2 = ((l)g.ab(l.class)).doJ().ys(this.kno.tGf);
      parama = (a.a)localObject1;
      paramVarArgs = str;
    }
    switch (this.kno.tEX)
    {
    default: 
      paramVarArgs = str;
      parama = (a.a)localObject1;
    case 51: 
    case 41: 
      for (;;)
      {
        this.heE = k.d(paramContext, bu.bI(parama, "").replace('\n', ' '), b.c.tIY);
        if (bu.ah(paramVarArgs)) {
          break;
        }
        float f1 = b.a.tIQ;
        float f2 = b.c.tIZ.measureText(paramVarArgs.toString());
        this.heE = com.tencent.mm.plugin.fts.a.f.a(e.a(this.heE, this.tFe, f1 - f2, b.c.tIZ)).tFv;
        this.heE = TextUtils.concat(new CharSequence[] { paramVarArgs, this.heE });
        this.tMx = com.tencent.mm.pluginsdk.i.i.c(paramContext, this.kno.timestamp, true);
        AppMethodBeat.o(112101);
        return;
        localObject1 = ((ei)localObject2).field_content;
        parama = (a.a)localObject1;
        paramVarArgs = str;
        if (x.zT(this.username))
        {
          parama = bl.BN((String)localObject1);
          paramVarArgs = str;
        }
      }
    case 42: 
      label353:
      parama = k.b.zb(((ei)localObject2).field_content);
      if (parama == null) {
        break;
      }
    }
    for (parama = parama.title;; parama = "")
    {
      paramVarArgs = paramContext.getString(2131759709);
      break;
      paramVarArgs = k.b.zb(((ei)localObject2).field_content);
      parama = (a.a)localObject1;
      if (paramVarArgs != null) {
        parama = paramVarArgs.title;
      }
      paramVarArgs = paramContext.getString(2131759710);
      break;
      paramVarArgs = k.b.zb(((ei)localObject2).field_content);
      parama = (a.a)localObject1;
      if (paramVarArgs != null) {
        parama = paramVarArgs.title;
      }
      paramVarArgs = paramContext.getString(2131759708);
      break;
      paramVarArgs = k.b.zb(((ei)localObject2).field_content);
      parama = (a.a)localObject1;
      if (paramVarArgs != null) {
        parama = paramVarArgs.description;
      }
      paramVarArgs = paramContext.getString(2131759712);
      break;
      localObject2 = k.b.zb(((ei)localObject2).field_content);
      parama = (a.a)localObject1;
      paramVarArgs = str;
      if (localObject2 == null) {
        break;
      }
      paramVarArgs = ((k.b)localObject2).title + ": ";
      parama = ((k.b)localObject2).description;
      break;
      localObject2 = k.b.zb(((ei)localObject2).field_content);
      parama = (a.a)localObject1;
      paramVarArgs = str;
      if (localObject2 == null) {
        break;
      }
      parama = bu.bI(((k.b)localObject2).title, "") + ": " + bu.bI(((k.b)localObject2).description, "");
      paramVarArgs = str;
      break;
      parama = k.b.zb(((ei)localObject2).field_content);
      if (parama != null)
      {
        if (((ei)localObject2).field_isSend == 1)
        {
          parama = bu.bI(parama.hEi, "") + ": " + bu.bI(parama.hEf, "");
          paramVarArgs = str;
          break;
        }
        parama = bu.bI(parama.hEi, "") + ": " + bu.bI(parama.hEe, "");
        paramVarArgs = str;
        break;
      }
      parama = "";
      paramVarArgs = str;
      break;
      paramVarArgs = ((ei)localObject2).field_content;
      if (x.wb(this.username)) {
        paramVarArgs = bl.BN(paramVarArgs);
      }
      for (;;)
      {
        parama = paramVarArgs;
        if (!bu.isNullOrNil(paramVarArgs))
        {
          localObject1 = ((l)g.ab(l.class)).doJ().arq(paramVarArgs);
          parama = paramVarArgs;
          if (((bv.b)localObject1).fwu()) {
            parama = ((bv.b)localObject1).jGd;
          }
        }
        paramVarArgs = paramContext.getString(2131759711);
        break;
        parama = k.b.zb(((ei)localObject2).field_content);
        if (parama != null)
        {
          parama = bu.bI(parama.getTitle(), "");
          paramVarArgs = str;
          break;
        }
        parama = "";
        paramVarArgs = str;
        break;
        parama = k.b.zb(((ei)localObject2).field_content);
        paramVarArgs = ((com.tencent.mm.plugin.i.a.b)parama.ao(com.tencent.mm.plugin.i.a.b.class)).ipW;
        if (parama != null)
        {
          if (!bu.isNullOrNil(paramVarArgs.nickname))
          {
            parama = paramContext.getString(2131759701, new Object[] { bu.bI(paramVarArgs.nickname, "") });
            paramVarArgs = str;
            break;
          }
          parama = "";
          paramVarArgs = str;
          break;
        }
        parama = "";
        paramVarArgs = str;
        break;
        this.heE = com.tencent.mm.plugin.fts.a.f.a(e.a(this.heE, this.tFe, b.a.tIQ, b.c.tIZ)).tFv;
        break label353;
      }
    }
  }
  
  public com.tencent.mm.plugin.fts.a.d.a.a.b agQ()
  {
    return this.tMy;
  }
  
  public final int bhE()
  {
    return this.kno.tGo;
  }
  
  public int cVD()
  {
    if (this.tMw < 2) {
      return 0;
    }
    return 1;
  }
  
  public final class a
    extends a.a
  {
    public ImageView fQl;
    public TextView fQm;
    public TextView fVU;
    public TextView fVV;
    public View knu;
    
    public a()
    {
      super();
    }
  }
  
  public class b
    extends com.tencent.mm.plugin.fts.a.d.a.a.b
  {
    public b()
    {
      super();
    }
    
    public View a(Context paramContext, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(112097);
      paramContext = LayoutInflater.from(paramContext).inflate(2131494215, paramViewGroup, false);
      paramViewGroup = (m.a)m.this.tMz;
      paramViewGroup.fQl = ((ImageView)paramContext.findViewById(2131297008));
      paramViewGroup.fQm = ((TextView)paramContext.findViewById(2131302867));
      paramViewGroup.fVU = ((TextView)paramContext.findViewById(2131302555));
      paramViewGroup.fVV = ((TextView)paramContext.findViewById(2131305822));
      paramViewGroup.knu = paramContext.findViewById(2131299154);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(112097);
      return paramContext;
    }
    
    public void a(Context paramContext, a.a parama, com.tencent.mm.plugin.fts.a.d.a.a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112098);
      parama1 = (m)parama1;
      parama = (m.a)parama;
      com.tencent.mm.plugin.fts.ui.n.p(parama.knu, m.this.tGL);
      com.tencent.mm.pluginsdk.ui.a.b.c(parama.fQl, parama1.username);
      com.tencent.mm.plugin.fts.ui.n.a(parama1.heE, parama.fVU);
      com.tencent.mm.plugin.fts.ui.n.a(parama1.tMx, parama.fVV);
      if (x.zW(parama1.username))
      {
        com.tencent.mm.plugin.fts.ui.n.a(((com.tencent.mm.openim.a.a)g.ab(com.tencent.mm.openim.a.a.class)).a(paramContext, parama1.iYg), parama.fQm);
        AppMethodBeat.o(112098);
        return;
      }
      if (an.aUq(parama1.username))
      {
        g.ajS();
        paramContext = ((l)g.ab(l.class)).azF().BH(parama1.username);
        ((com.tencent.mm.openim.a.a)g.ab(com.tencent.mm.openim.a.a.class)).a(parama.fQm.getContext(), parama.fQm, parama1.iYg, paramContext.field_openImAppid, paramContext.field_descWordingId, (int)parama.fQm.getTextSize());
        AppMethodBeat.o(112098);
        return;
      }
      com.tencent.mm.plugin.fts.ui.n.a(parama1.iYg, parama.fQm);
      AppMethodBeat.o(112098);
    }
    
    public boolean a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
    {
      AppMethodBeat.i(112099);
      boolean bool = ((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).getItemClickHandler(m.this.oOD).a(paramContext, paramVarArgs);
      AppMethodBeat.o(112099);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.m
 * JD-Core Version:    0.7.0.1
 */