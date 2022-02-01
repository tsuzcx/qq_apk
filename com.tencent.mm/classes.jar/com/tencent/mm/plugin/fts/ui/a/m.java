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
import com.tencent.mm.ag.k.b;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.b;
import com.tencent.mm.plugin.fts.ui.b.a;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.protocal.protobuf.bcj;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca.b;

public class m
  extends com.tencent.mm.plugin.fts.a.d.a.a
{
  public CharSequence hXr;
  public CharSequence jVL;
  public com.tencent.mm.plugin.fts.a.a.m lqW;
  public String username;
  public int xdw;
  public CharSequence xdx;
  private b xdy;
  a xdz;
  
  public m(int paramInt)
  {
    super(5, paramInt);
    AppMethodBeat.i(112100);
    this.xdy = new b();
    this.xdz = new a();
    AppMethodBeat.o(112100);
  }
  
  public void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112101);
    super.a(paramContext, parama, paramVarArgs);
    parama = (a)parama;
    this.username = this.lqW.wVX;
    this.jVL = com.tencent.mm.pluginsdk.ui.span.l.d(paramContext, d.arL(this.username), parama.gvw.getTextSize());
    if ((this.lqW.userData instanceof Integer)) {
      this.xdw = ((Integer)this.lqW.userData).intValue();
    }
    if (this.xdw > 1)
    {
      this.hXr = paramContext.getResources().getString(2131765092, new Object[] { Integer.valueOf(this.xdw) });
      AppMethodBeat.o(112101);
      return;
    }
    String str;
    Object localObject1;
    Object localObject2;
    if (this.xdw == 1)
    {
      str = "";
      localObject1 = "";
      localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().Hb(this.lqW.wXe);
      parama = (a.a)localObject1;
      paramVarArgs = str;
    }
    switch (this.lqW.wVW)
    {
    default: 
      paramVarArgs = str;
      parama = (a.a)localObject1;
    case 51: 
    case 41: 
      for (;;)
      {
        this.hXr = com.tencent.mm.pluginsdk.ui.span.l.d(paramContext, Util.nullAs(parama, "").replace('\n', ' '), b.c.wZX);
        if (Util.isNullOrNil(paramVarArgs)) {
          break;
        }
        float f1 = b.a.wZP;
        float f2 = b.c.wZY.measureText(paramVarArgs.toString());
        this.hXr = com.tencent.mm.plugin.fts.a.f.a(e.a(this.hXr, this.wWd, f1 - f2, b.c.wZY)).wWu;
        this.hXr = TextUtils.concat(new CharSequence[] { paramVarArgs, this.hXr });
        this.xdx = com.tencent.mm.pluginsdk.i.f.c(paramContext, this.lqW.timestamp, true);
        AppMethodBeat.o(112101);
        return;
        localObject1 = ((eo)localObject2).field_content;
        parama = (a.a)localObject1;
        paramVarArgs = str;
        if (ab.Iw(this.username))
        {
          parama = bp.Kt((String)localObject1);
          paramVarArgs = str;
        }
      }
    case 42: 
      label353:
      parama = k.b.HD(((eo)localObject2).field_content);
      if (parama == null) {
        break;
      }
    }
    for (parama = parama.title;; parama = "")
    {
      paramVarArgs = paramContext.getString(2131761030);
      break;
      paramVarArgs = k.b.HD(((eo)localObject2).field_content);
      parama = (a.a)localObject1;
      if (paramVarArgs != null) {
        parama = paramVarArgs.title;
      }
      paramVarArgs = paramContext.getString(2131761031);
      break;
      paramVarArgs = k.b.HD(((eo)localObject2).field_content);
      parama = (a.a)localObject1;
      if (paramVarArgs != null) {
        parama = paramVarArgs.title;
      }
      paramVarArgs = paramContext.getString(2131761029);
      break;
      paramVarArgs = k.b.HD(((eo)localObject2).field_content);
      parama = (a.a)localObject1;
      if (paramVarArgs != null) {
        parama = paramVarArgs.description;
      }
      paramVarArgs = paramContext.getString(2131761033);
      break;
      localObject2 = k.b.HD(((eo)localObject2).field_content);
      parama = (a.a)localObject1;
      paramVarArgs = str;
      if (localObject2 == null) {
        break;
      }
      paramVarArgs = ((k.b)localObject2).title + ": ";
      parama = ((k.b)localObject2).description;
      break;
      localObject2 = k.b.HD(((eo)localObject2).field_content);
      parama = (a.a)localObject1;
      paramVarArgs = str;
      if (localObject2 == null) {
        break;
      }
      parama = Util.nullAs(((k.b)localObject2).title, "") + ": " + Util.nullAs(((k.b)localObject2).description, "");
      paramVarArgs = str;
      break;
      parama = k.b.HD(((eo)localObject2).field_content);
      if (parama != null)
      {
        if (((eo)localObject2).field_isSend == 1)
        {
          parama = Util.nullAs(parama.iyo, "") + ": " + Util.nullAs(parama.iyl, "");
          paramVarArgs = str;
          break;
        }
        parama = Util.nullAs(parama.iyo, "") + ": " + Util.nullAs(parama.iyk, "");
        paramVarArgs = str;
        break;
      }
      parama = "";
      paramVarArgs = str;
      break;
      paramVarArgs = ((eo)localObject2).field_content;
      if (ab.Eq(this.username)) {
        paramVarArgs = bp.Kt(paramVarArgs);
      }
      for (;;)
      {
        parama = paramVarArgs;
        if (!Util.isNullOrNil(paramVarArgs))
        {
          localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aEL(paramVarArgs);
          parama = paramVarArgs;
          if (((ca.b)localObject1).gEa()) {
            parama = ((ca.b)localObject1).kHV;
          }
        }
        paramVarArgs = paramContext.getString(2131761032);
        break;
        parama = k.b.HD(((eo)localObject2).field_content);
        if (parama != null)
        {
          parama = Util.nullAs(parama.getTitle(), "");
          paramVarArgs = str;
          break;
        }
        parama = "";
        paramVarArgs = str;
        break;
        parama = k.b.HD(((eo)localObject2).field_content);
        if (parama != null)
        {
          parama = ((com.tencent.mm.plugin.i.a.f)parama.as(com.tencent.mm.plugin.i.a.f.class)).jlg;
          if (!Util.isNullOrNil(parama.nickname))
          {
            parama = paramContext.getString(2131761022, new Object[] { Util.nullAs(parama.nickname, "") });
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
        this.hXr = com.tencent.mm.plugin.fts.a.f.a(e.a(this.hXr, this.wWd, b.a.wZP, b.c.wZY)).wWu;
        break label353;
      }
    }
  }
  
  public com.tencent.mm.plugin.fts.a.d.a.a.b axc()
  {
    return this.xdy;
  }
  
  public final int bCS()
  {
    return this.lqW.wXn;
  }
  
  public int dOM()
  {
    if (this.xdw < 2) {
      return 0;
    }
    return 1;
  }
  
  public final class a
    extends a.a
  {
    public TextView gBb;
    public ImageView gvv;
    public TextView gvw;
    public View lrc;
    public TextView timeTV;
    
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
      paramContext = LayoutInflater.from(paramContext).inflate(2131494770, paramViewGroup, false);
      paramViewGroup = (m.a)m.this.xdz;
      paramViewGroup.gvv = ((ImageView)paramContext.findViewById(2131297134));
      paramViewGroup.gvw = ((TextView)paramContext.findViewById(2131305440));
      paramViewGroup.gBb = ((TextView)paramContext.findViewById(2131304987));
      paramViewGroup.timeTV = ((TextView)paramContext.findViewById(2131309101));
      paramViewGroup.lrc = paramContext.findViewById(2131299682);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(112097);
      return paramContext;
    }
    
    public void a(Context paramContext, a.a parama, com.tencent.mm.plugin.fts.a.d.a.a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112098);
      parama1 = (m)parama1;
      parama = (m.a)parama;
      com.tencent.mm.plugin.fts.ui.n.q(parama.lrc, m.this.wXK);
      com.tencent.mm.pluginsdk.ui.a.b.c(parama.gvv, parama1.username);
      com.tencent.mm.plugin.fts.ui.n.a(parama1.hXr, parama.gBb);
      com.tencent.mm.plugin.fts.ui.n.a(parama1.xdx, parama.timeTV);
      if (ab.Iz(parama1.username))
      {
        com.tencent.mm.plugin.fts.ui.n.a(((com.tencent.mm.openim.a.a)g.af(com.tencent.mm.openim.a.a.class)).a(paramContext, parama1.jVL), parama.gvw);
        AppMethodBeat.o(112098);
        return;
      }
      if (as.bjp(parama1.username))
      {
        g.aAi();
        paramContext = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(parama1.username);
        ((com.tencent.mm.openim.a.a)g.af(com.tencent.mm.openim.a.a.class)).a(parama.gvw.getContext(), parama.gvw, parama1.jVL, paramContext.field_openImAppid, paramContext.field_descWordingId, (int)parama.gvw.getTextSize());
        AppMethodBeat.o(112098);
        return;
      }
      com.tencent.mm.plugin.fts.ui.n.a(parama1.jVL, parama.gvw);
      AppMethodBeat.o(112098);
    }
    
    public boolean a(Context paramContext, View paramView, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
    {
      AppMethodBeat.i(235402);
      boolean bool = ((com.tencent.mm.plugin.fts.a.n)g.ah(com.tencent.mm.plugin.fts.a.n.class)).getItemClickHandler(m.this.qcr).a(paramContext, paramView, paramVarArgs);
      AppMethodBeat.o(235402);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.m
 * JD-Core Version:    0.7.0.1
 */