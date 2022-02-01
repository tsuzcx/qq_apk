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
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
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
import com.tencent.mm.protocal.protobuf.anx;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bo.b;

public class m
  extends a
{
  public CharSequence gIg;
  public CharSequence iCd;
  public com.tencent.mm.plugin.fts.a.a.m jPN;
  public int sEN;
  public CharSequence sEO;
  private b sEP;
  a sEQ;
  public String username;
  
  public m(int paramInt)
  {
    super(5, paramInt);
    AppMethodBeat.i(112100);
    this.sEP = new b();
    this.sEQ = new a();
    AppMethodBeat.o(112100);
  }
  
  public void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112101);
    super.a(paramContext, parama, paramVarArgs);
    parama = (a)parama;
    this.username = this.jPN.sxG;
    this.iCd = com.tencent.mm.pluginsdk.ui.span.k.d(paramContext, d.acr(this.username), parama.fuZ.getTextSize());
    if ((this.jPN.userData instanceof Integer)) {
      this.sEN = ((Integer)this.jPN.userData).intValue();
    }
    String str;
    Object localObject1;
    Object localObject2;
    if (this.sEN < 2)
    {
      str = "";
      localObject1 = "";
      localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().vP(this.jPN.syN);
      parama = (a.a)localObject1;
      paramVarArgs = str;
      switch (this.jPN.sxF)
      {
      default: 
        paramVarArgs = str;
        parama = (a.a)localObject1;
      case 51: 
      case 41: 
        for (;;)
        {
          this.gIg = com.tencent.mm.pluginsdk.ui.span.k.d(paramContext, bs.bG(parama, "").replace('\n', ' '), b.c.sBG);
          if (bs.aj(paramVarArgs)) {
            break;
          }
          float f1 = b.a.sBy;
          float f2 = b.c.sBH.measureText(paramVarArgs.toString());
          this.gIg = com.tencent.mm.plugin.fts.a.f.a(e.a(this.gIg, this.sxM, f1 - f2, b.c.sBH)).syd;
          this.gIg = TextUtils.concat(new CharSequence[] { paramVarArgs, this.gIg });
          this.sEO = com.tencent.mm.pluginsdk.g.h.c(paramContext, this.jPN.timestamp, true);
          AppMethodBeat.o(112101);
          return;
          localObject1 = ((dy)localObject2).field_content;
          parama = (a.a)localObject1;
          paramVarArgs = str;
          if (w.wo(this.username))
          {
            parama = bi.ym((String)localObject1);
            paramVarArgs = str;
          }
        }
      case 42: 
        label313:
        parama = k.b.vA(((dy)localObject2).field_content);
        if (parama == null) {
          break;
        }
      }
    }
    for (parama = parama.title;; parama = "")
    {
      paramVarArgs = paramContext.getString(2131759709);
      break;
      paramVarArgs = k.b.vA(((dy)localObject2).field_content);
      parama = (a.a)localObject1;
      if (paramVarArgs != null) {
        parama = paramVarArgs.title;
      }
      paramVarArgs = paramContext.getString(2131759710);
      break;
      paramVarArgs = k.b.vA(((dy)localObject2).field_content);
      parama = (a.a)localObject1;
      if (paramVarArgs != null) {
        parama = paramVarArgs.title;
      }
      paramVarArgs = paramContext.getString(2131759708);
      break;
      paramVarArgs = k.b.vA(((dy)localObject2).field_content);
      parama = (a.a)localObject1;
      if (paramVarArgs != null) {
        parama = paramVarArgs.description;
      }
      paramVarArgs = paramContext.getString(2131759712);
      break;
      localObject2 = k.b.vA(((dy)localObject2).field_content);
      parama = (a.a)localObject1;
      paramVarArgs = str;
      if (localObject2 == null) {
        break;
      }
      paramVarArgs = ((k.b)localObject2).title + ": ";
      parama = ((k.b)localObject2).description;
      break;
      localObject2 = k.b.vA(((dy)localObject2).field_content);
      parama = (a.a)localObject1;
      paramVarArgs = str;
      if (localObject2 == null) {
        break;
      }
      parama = bs.bG(((k.b)localObject2).title, "") + ": " + bs.bG(((k.b)localObject2).description, "");
      paramVarArgs = str;
      break;
      parama = k.b.vA(((dy)localObject2).field_content);
      if (parama != null)
      {
        if (((dy)localObject2).field_isSend == 1)
        {
          parama = bs.bG(parama.hjl, "") + ": " + bs.bG(parama.hji, "");
          paramVarArgs = str;
          break;
        }
        parama = bs.bG(parama.hjl, "") + ": " + bs.bG(parama.hjh, "");
        paramVarArgs = str;
        break;
      }
      parama = "";
      paramVarArgs = str;
      break;
      paramVarArgs = ((dy)localObject2).field_content;
      if (w.sQ(this.username)) {
        paramVarArgs = bi.ym(paramVarArgs);
      }
      for (;;)
      {
        parama = paramVarArgs;
        if (!bs.isNullOrNil(paramVarArgs))
        {
          localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().alx(paramVarArgs);
          parama = paramVarArgs;
          if (((bo.b)localObject1).fcm()) {
            parama = ((bo.b)localObject1).gPy;
          }
        }
        paramVarArgs = paramContext.getString(2131759711);
        break;
        parama = k.b.vA(((dy)localObject2).field_content);
        if (parama != null)
        {
          parama = bs.bG(parama.getTitle(), "");
          paramVarArgs = str;
          break;
        }
        parama = "";
        paramVarArgs = str;
        break;
        parama = k.b.vA(((dy)localObject2).field_content);
        paramVarArgs = ((com.tencent.mm.plugin.i.a.b)parama.ao(com.tencent.mm.plugin.i.a.b.class)).hTI;
        if (parama != null)
        {
          if (!bs.isNullOrNil(paramVarArgs.nickname))
          {
            parama = paramContext.getString(2131759701, new Object[] { bs.bG(paramVarArgs.nickname, "") });
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
        this.gIg = com.tencent.mm.plugin.fts.a.f.a(e.a(this.gIg, this.sxM, b.a.sBy, b.c.sBH)).syd;
        break label313;
        this.gIg = paramContext.getResources().getString(2131762956, new Object[] { Integer.valueOf(this.sEN) });
        AppMethodBeat.o(112101);
        return;
      }
    }
  }
  
  public com.tencent.mm.plugin.fts.a.d.a.a.b adW()
  {
    return this.sEP;
  }
  
  public final int bds()
  {
    return this.jPN.syW;
  }
  
  public int cKJ()
  {
    if (this.sEN < 2) {
      return 0;
    }
    return 1;
  }
  
  public final class a
    extends a.a
  {
    public TextView fAy;
    public TextView fAz;
    public ImageView fuY;
    public TextView fuZ;
    public View jPT;
    
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
      paramViewGroup = (m.a)m.this.sEQ;
      paramViewGroup.fuY = ((ImageView)paramContext.findViewById(2131297008));
      paramViewGroup.fuZ = ((TextView)paramContext.findViewById(2131302867));
      paramViewGroup.fAy = ((TextView)paramContext.findViewById(2131302555));
      paramViewGroup.fAz = ((TextView)paramContext.findViewById(2131305822));
      paramViewGroup.jPT = paramContext.findViewById(2131299154);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(112097);
      return paramContext;
    }
    
    public void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112098);
      parama1 = (m)parama1;
      parama = (m.a)parama;
      com.tencent.mm.plugin.fts.ui.m.p(parama.jPT, m.this.szt);
      com.tencent.mm.pluginsdk.ui.a.b.c(parama.fuY, parama1.username);
      com.tencent.mm.plugin.fts.ui.m.a(parama1.gIg, parama.fAy);
      com.tencent.mm.plugin.fts.ui.m.a(parama1.sEO, parama.fAz);
      if (w.wr(parama1.username))
      {
        com.tencent.mm.plugin.fts.ui.m.a(((com.tencent.mm.openim.a.b)g.ab(com.tencent.mm.openim.a.b.class)).a(paramContext, parama1.iCd), parama.fuZ);
        AppMethodBeat.o(112098);
        return;
      }
      if (ai.aNc(parama1.username))
      {
        g.agS();
        paramContext = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(parama1.username);
        ((com.tencent.mm.openim.a.b)g.ab(com.tencent.mm.openim.a.b.class)).a(parama.fuZ.getContext(), parama.fuZ, parama1.iCd, paramContext.field_openImAppid, paramContext.field_descWordingId, (int)parama.fuZ.getTextSize());
        AppMethodBeat.o(112098);
        return;
      }
      com.tencent.mm.plugin.fts.ui.m.a(parama1.iCd, parama.fuZ);
      AppMethodBeat.o(112098);
    }
    
    public boolean a(Context paramContext, a paramVarArgs)
    {
      AppMethodBeat.i(112099);
      boolean bool = ((n)g.ad(n.class)).getItemClickHandler(m.this.oeH).a(paramContext, paramVarArgs);
      AppMethodBeat.o(112099);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.m
 * JD-Core Version:    0.7.0.1
 */