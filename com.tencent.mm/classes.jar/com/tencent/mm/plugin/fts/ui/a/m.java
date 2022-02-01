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
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.b.a;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bl.b;

public class m
  extends a
{
  public CharSequence ibW;
  public CharSequence ibX;
  public com.tencent.mm.plugin.fts.a.a.m jpy;
  public int rvV;
  public CharSequence rvW;
  private b rvX;
  a rvY;
  public String username;
  
  public m(int paramInt)
  {
    super(5, paramInt);
    AppMethodBeat.i(112100);
    this.rvX = new b();
    this.rvY = new a();
    AppMethodBeat.o(112100);
  }
  
  public void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112101);
    super.a(paramContext, parama, paramVarArgs);
    parama = (a)parama;
    this.username = this.jpy.roN;
    this.ibW = com.tencent.mm.pluginsdk.ui.span.k.d(paramContext, d.XV(this.username), parama.frs.getTextSize());
    if ((this.jpy.userData instanceof Integer)) {
      this.rvV = ((Integer)this.jpy.userData).intValue();
    }
    String str;
    Object localObject1;
    Object localObject2;
    if (this.rvV < 2)
    {
      str = "";
      localObject1 = "";
      localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().rm(this.jpy.rpT);
      parama = (a.a)localObject1;
      paramVarArgs = str;
      switch (this.jpy.roM)
      {
      default: 
        paramVarArgs = str;
        parama = (a.a)localObject1;
      case 51: 
      case 41: 
        for (;;)
        {
          this.ibX = com.tencent.mm.pluginsdk.ui.span.k.d(paramContext, bt.by(parama, "").replace('\n', ' '), b.c.rsM);
          if (bt.ai(paramVarArgs)) {
            break;
          }
          float f1 = b.a.rsE;
          float f2 = b.c.rsN.measureText(paramVarArgs.toString());
          this.ibX = com.tencent.mm.plugin.fts.a.f.a(e.a(this.ibX, this.roS, f1 - f2, b.c.rsN)).rpj;
          this.ibX = TextUtils.concat(new CharSequence[] { paramVarArgs, this.ibX });
          this.rvW = com.tencent.mm.pluginsdk.g.h.c(paramContext, this.jpy.timestamp, true);
          AppMethodBeat.o(112101);
          return;
          localObject1 = ((du)localObject2).field_content;
          parama = (a.a)localObject1;
          paramVarArgs = str;
          if (w.sl(this.username))
          {
            parama = bi.ug((String)localObject1);
            paramVarArgs = str;
          }
        }
      case 42: 
        label313:
        parama = k.b.rx(((du)localObject2).field_content);
        if (parama == null) {
          break;
        }
      }
    }
    for (parama = parama.title;; parama = "")
    {
      paramVarArgs = paramContext.getString(2131759709);
      break;
      paramVarArgs = k.b.rx(((du)localObject2).field_content);
      parama = (a.a)localObject1;
      if (paramVarArgs != null) {
        parama = paramVarArgs.title;
      }
      paramVarArgs = paramContext.getString(2131759710);
      break;
      paramVarArgs = k.b.rx(((du)localObject2).field_content);
      parama = (a.a)localObject1;
      if (paramVarArgs != null) {
        parama = paramVarArgs.title;
      }
      paramVarArgs = paramContext.getString(2131759708);
      break;
      paramVarArgs = k.b.rx(((du)localObject2).field_content);
      parama = (a.a)localObject1;
      if (paramVarArgs != null) {
        parama = paramVarArgs.description;
      }
      paramVarArgs = paramContext.getString(2131759712);
      break;
      localObject2 = k.b.rx(((du)localObject2).field_content);
      parama = (a.a)localObject1;
      paramVarArgs = str;
      if (localObject2 == null) {
        break;
      }
      paramVarArgs = ((k.b)localObject2).title + ": ";
      parama = ((k.b)localObject2).description;
      break;
      localObject2 = k.b.rx(((du)localObject2).field_content);
      parama = (a.a)localObject1;
      paramVarArgs = str;
      if (localObject2 == null) {
        break;
      }
      parama = bt.by(((k.b)localObject2).title, "") + ": " + bt.by(((k.b)localObject2).description, "");
      paramVarArgs = str;
      break;
      parama = k.b.rx(((du)localObject2).field_content);
      if (parama != null)
      {
        if (((du)localObject2).field_isSend == 1)
        {
          parama = bt.by(parama.gIL, "") + ": " + bt.by(parama.gII, "");
          paramVarArgs = str;
          break;
        }
        parama = bt.by(parama.gIL, "") + ": " + bt.by(parama.gIH, "");
        paramVarArgs = str;
        break;
      }
      parama = "";
      paramVarArgs = str;
      break;
      paramVarArgs = ((du)localObject2).field_content;
      if (w.pF(this.username)) {
        paramVarArgs = bi.ug(paramVarArgs);
      }
      for (;;)
      {
        parama = paramVarArgs;
        if (!bt.isNullOrNil(paramVarArgs))
        {
          localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().agD(paramVarArgs);
          parama = paramVarArgs;
          if (((bl.b)localObject1).eMH()) {
            parama = ((bl.b)localObject1).goQ;
          }
        }
        paramVarArgs = paramContext.getString(2131759711);
        break;
        parama = k.b.rx(((du)localObject2).field_content);
        if (parama != null)
        {
          parama = bt.by(parama.getTitle(), "");
          paramVarArgs = str;
          break;
        }
        parama = "";
        paramVarArgs = str;
        break;
        parama = k.b.rx(((du)localObject2).field_content);
        paramVarArgs = ((com.tencent.mm.plugin.i.a.b)parama.ao(com.tencent.mm.plugin.i.a.b.class)).htg;
        if (parama != null)
        {
          if (!bt.isNullOrNil(paramVarArgs.nickname))
          {
            parama = paramContext.getString(2131759701, new Object[] { bt.by(paramVarArgs.nickname, "") });
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
        this.ibX = com.tencent.mm.plugin.fts.a.f.a(e.a(this.ibX, this.roS, b.a.rsE, b.c.rsN)).rpj;
        break label313;
        this.ibX = paramContext.getResources().getString(2131762956, new Object[] { Integer.valueOf(this.rvV) });
        AppMethodBeat.o(112101);
        return;
      }
    }
  }
  
  public final int aWu()
  {
    return this.jpy.rqc;
  }
  
  public com.tencent.mm.plugin.fts.a.d.a.a.b acQ()
  {
    return this.rvX;
  }
  
  public int cxx()
  {
    if (this.rvV < 2) {
      return 0;
    }
    return 1;
  }
  
  public final class a
    extends a.a
  {
    public ImageView frr;
    public TextView frs;
    public TextView fwR;
    public TextView fwS;
    public View jpE;
    
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
      paramViewGroup = (m.a)m.this.rvY;
      paramViewGroup.frr = ((ImageView)paramContext.findViewById(2131297008));
      paramViewGroup.frs = ((TextView)paramContext.findViewById(2131302867));
      paramViewGroup.fwR = ((TextView)paramContext.findViewById(2131302555));
      paramViewGroup.fwS = ((TextView)paramContext.findViewById(2131305822));
      paramViewGroup.jpE = paramContext.findViewById(2131299154);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(112097);
      return paramContext;
    }
    
    public void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112098);
      parama1 = (m)parama1;
      parama = (m.a)parama;
      com.tencent.mm.plugin.fts.ui.m.p(parama.jpE, m.this.rqz);
      com.tencent.mm.pluginsdk.ui.a.b.c(parama.frr, parama1.username);
      com.tencent.mm.plugin.fts.ui.m.a(parama1.ibX, parama.fwR);
      com.tencent.mm.plugin.fts.ui.m.a(parama1.rvW, parama.fwS);
      if (w.so(parama1.username))
      {
        com.tencent.mm.plugin.fts.ui.m.a(((com.tencent.mm.openim.a.b)g.ab(com.tencent.mm.openim.a.b.class)).a(paramContext, parama1.ibW), parama.frs);
        AppMethodBeat.o(112098);
        return;
      }
      if (af.aHH(parama1.username))
      {
        g.afC();
        paramContext = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(parama1.username);
        ((com.tencent.mm.openim.a.b)g.ab(com.tencent.mm.openim.a.b.class)).a(parama.frs.getContext(), parama.frs, parama1.ibW, paramContext.field_openImAppid, paramContext.field_descWordingId, (int)parama.frs.getTextSize());
        AppMethodBeat.o(112098);
        return;
      }
      com.tencent.mm.plugin.fts.ui.m.a(parama1.ibW, parama.frs);
      AppMethodBeat.o(112098);
    }
    
    public boolean a(Context paramContext, a paramVarArgs)
    {
      AppMethodBeat.i(112099);
      boolean bool = ((n)g.ad(n.class)).getItemClickHandler(m.this.nBH).a(paramContext, paramVarArgs);
      AppMethodBeat.o(112099);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.m
 * JD-Core Version:    0.7.0.1
 */