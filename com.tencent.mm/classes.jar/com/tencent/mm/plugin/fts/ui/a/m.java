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
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.ui.b.a;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.arj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bu.b;

public class m
  extends a
{
  public CharSequence hbQ;
  public CharSequence iVn;
  public com.tencent.mm.plugin.fts.a.a.m kjY;
  public int tBF;
  public CharSequence tBG;
  private b tBH;
  a tBI;
  public String username;
  
  public m(int paramInt)
  {
    super(5, paramInt);
    AppMethodBeat.i(112100);
    this.tBH = new b();
    this.tBI = new a();
    AppMethodBeat.o(112100);
  }
  
  public void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112101);
    super.a(paramContext, parama, paramVarArgs);
    parama = (a)parama;
    this.username = this.kjY.tuh;
    this.iVn = k.d(paramContext, d.agg(this.username), parama.fOg.getTextSize());
    if ((this.kjY.userData instanceof Integer)) {
      this.tBF = ((Integer)this.kjY.userData).intValue();
    }
    if (this.tBF > 1)
    {
      this.hbQ = paramContext.getResources().getString(2131762956, new Object[] { Integer.valueOf(this.tBF) });
      AppMethodBeat.o(112101);
      return;
    }
    String str;
    Object localObject1;
    Object localObject2;
    if (this.tBF == 1)
    {
      str = "";
      localObject1 = "";
      localObject2 = ((l)g.ab(l.class)).dlK().xY(this.kjY.tvo);
      parama = (a.a)localObject1;
      paramVarArgs = str;
    }
    switch (this.kjY.tug)
    {
    default: 
      paramVarArgs = str;
      parama = (a.a)localObject1;
    case 51: 
    case 41: 
      for (;;)
      {
        this.hbQ = k.d(paramContext, bt.bI(parama, "").replace('\n', ' '), b.c.tyh);
        if (bt.ai(paramVarArgs)) {
          break;
        }
        float f1 = b.a.txZ;
        float f2 = b.c.tyi.measureText(paramVarArgs.toString());
        this.hbQ = com.tencent.mm.plugin.fts.a.f.a(e.a(this.hbQ, this.tun, f1 - f2, b.c.tyi)).tuE;
        this.hbQ = TextUtils.concat(new CharSequence[] { paramVarArgs, this.hbQ });
        this.tBG = com.tencent.mm.pluginsdk.i.i.c(paramContext, this.kjY.timestamp, true);
        AppMethodBeat.o(112101);
        return;
        localObject1 = ((ei)localObject2).field_content;
        parama = (a.a)localObject1;
        paramVarArgs = str;
        if (w.zj(this.username))
        {
          parama = bj.Bl((String)localObject1);
          paramVarArgs = str;
        }
      }
    case 42: 
      label353:
      parama = k.b.yr(((ei)localObject2).field_content);
      if (parama == null) {
        break;
      }
    }
    for (parama = parama.title;; parama = "")
    {
      paramVarArgs = paramContext.getString(2131759709);
      break;
      paramVarArgs = k.b.yr(((ei)localObject2).field_content);
      parama = (a.a)localObject1;
      if (paramVarArgs != null) {
        parama = paramVarArgs.title;
      }
      paramVarArgs = paramContext.getString(2131759710);
      break;
      paramVarArgs = k.b.yr(((ei)localObject2).field_content);
      parama = (a.a)localObject1;
      if (paramVarArgs != null) {
        parama = paramVarArgs.title;
      }
      paramVarArgs = paramContext.getString(2131759708);
      break;
      paramVarArgs = k.b.yr(((ei)localObject2).field_content);
      parama = (a.a)localObject1;
      if (paramVarArgs != null) {
        parama = paramVarArgs.description;
      }
      paramVarArgs = paramContext.getString(2131759712);
      break;
      localObject2 = k.b.yr(((ei)localObject2).field_content);
      parama = (a.a)localObject1;
      paramVarArgs = str;
      if (localObject2 == null) {
        break;
      }
      paramVarArgs = ((k.b)localObject2).title + ": ";
      parama = ((k.b)localObject2).description;
      break;
      localObject2 = k.b.yr(((ei)localObject2).field_content);
      parama = (a.a)localObject1;
      paramVarArgs = str;
      if (localObject2 == null) {
        break;
      }
      parama = bt.bI(((k.b)localObject2).title, "") + ": " + bt.bI(((k.b)localObject2).description, "");
      paramVarArgs = str;
      break;
      parama = k.b.yr(((ei)localObject2).field_content);
      if (parama != null)
      {
        if (((ei)localObject2).field_isSend == 1)
        {
          parama = bt.bI(parama.hBu, "") + ": " + bt.bI(parama.hBr, "");
          paramVarArgs = str;
          break;
        }
        parama = bt.bI(parama.hBu, "") + ": " + bt.bI(parama.hBq, "");
        paramVarArgs = str;
        break;
      }
      parama = "";
      paramVarArgs = str;
      break;
      paramVarArgs = ((ei)localObject2).field_content;
      if (w.vF(this.username)) {
        paramVarArgs = bj.Bl(paramVarArgs);
      }
      for (;;)
      {
        parama = paramVarArgs;
        if (!bt.isNullOrNil(paramVarArgs))
        {
          localObject1 = ((l)g.ab(l.class)).dlK().aql(paramVarArgs);
          parama = paramVarArgs;
          if (((bu.b)localObject1).fst()) {
            parama = ((bu.b)localObject1).jDf;
          }
        }
        paramVarArgs = paramContext.getString(2131759711);
        break;
        parama = k.b.yr(((ei)localObject2).field_content);
        if (parama != null)
        {
          parama = bt.bI(parama.getTitle(), "");
          paramVarArgs = str;
          break;
        }
        parama = "";
        paramVarArgs = str;
        break;
        parama = k.b.yr(((ei)localObject2).field_content);
        paramVarArgs = ((com.tencent.mm.plugin.i.a.b)parama.ao(com.tencent.mm.plugin.i.a.b.class)).inc;
        if (parama != null)
        {
          if (!bt.isNullOrNil(paramVarArgs.nickname))
          {
            parama = paramContext.getString(2131759701, new Object[] { bt.bI(paramVarArgs.nickname, "") });
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
        this.hbQ = com.tencent.mm.plugin.fts.a.f.a(e.a(this.hbQ, this.tun, b.a.txZ, b.c.tyi)).tuE;
        break label353;
      }
    }
  }
  
  public com.tencent.mm.plugin.fts.a.d.a.a.b agC()
  {
    return this.tBH;
  }
  
  public final int bgW()
  {
    return this.kjY.tvx;
  }
  
  public int cSY()
  {
    if (this.tBF < 2) {
      return 0;
    }
    return 1;
  }
  
  public final class a
    extends a.a
  {
    public ImageView fOf;
    public TextView fOg;
    public TextView fTO;
    public TextView fTP;
    public View kke;
    
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
      paramViewGroup = (m.a)m.this.tBI;
      paramViewGroup.fOf = ((ImageView)paramContext.findViewById(2131297008));
      paramViewGroup.fOg = ((TextView)paramContext.findViewById(2131302867));
      paramViewGroup.fTO = ((TextView)paramContext.findViewById(2131302555));
      paramViewGroup.fTP = ((TextView)paramContext.findViewById(2131305822));
      paramViewGroup.kke = paramContext.findViewById(2131299154);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(112097);
      return paramContext;
    }
    
    public void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112098);
      parama1 = (m)parama1;
      parama = (m.a)parama;
      com.tencent.mm.plugin.fts.ui.n.p(parama.kke, m.this.tvU);
      com.tencent.mm.pluginsdk.ui.a.b.c(parama.fOf, parama1.username);
      com.tencent.mm.plugin.fts.ui.n.a(parama1.hbQ, parama.fTO);
      com.tencent.mm.plugin.fts.ui.n.a(parama1.tBG, parama.fTP);
      if (w.zm(parama1.username))
      {
        com.tencent.mm.plugin.fts.ui.n.a(((com.tencent.mm.openim.a.b)g.ab(com.tencent.mm.openim.a.b.class)).a(paramContext, parama1.iVn), parama.fOg);
        AppMethodBeat.o(112098);
        return;
      }
      if (am.aSQ(parama1.username))
      {
        g.ajD();
        paramContext = ((l)g.ab(l.class)).azp().Bf(parama1.username);
        ((com.tencent.mm.openim.a.b)g.ab(com.tencent.mm.openim.a.b.class)).a(parama.fOg.getContext(), parama.fOg, parama1.iVn, paramContext.field_openImAppid, paramContext.field_descWordingId, (int)parama.fOg.getTextSize());
        AppMethodBeat.o(112098);
        return;
      }
      com.tencent.mm.plugin.fts.ui.n.a(parama1.iVn, parama.fOg);
      AppMethodBeat.o(112098);
    }
    
    public boolean a(Context paramContext, a paramVarArgs)
    {
      AppMethodBeat.i(112099);
      boolean bool = ((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).getItemClickHandler(m.this.oIb).a(paramContext, paramVarArgs);
      AppMethodBeat.o(112099);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.m
 * JD-Core Version:    0.7.0.1
 */