package com.tencent.mm.plugin.fts.ui.b;

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
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.br;
import com.tencent.mm.openim.api.e;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.b;
import com.tencent.mm.plugin.fts.ui.b.a;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.fts.ui.p.d;
import com.tencent.mm.plugin.fts.ui.p.e;
import com.tencent.mm.plugin.fts.ui.p.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc.c;

public class m
  extends a
{
  public int HBm;
  public CharSequence HBn;
  private b HBo;
  a HBp;
  public CharSequence nnT;
  public CharSequence pJG;
  public com.tencent.mm.plugin.fts.a.a.o rpp;
  public String username;
  
  public m(int paramInt)
  {
    super(5, paramInt);
    AppMethodBeat.i(112100);
    this.HBo = new b();
    this.HBp = new a();
    AppMethodBeat.o(112100);
  }
  
  public void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112101);
    super.a(paramContext, parama, paramVarArgs);
    parama = (a)parama;
    this.username = this.rpp.Hsz;
    this.pJG = p.d(paramContext, d.atS(this.username), parama.lBD.getTextSize());
    if ((this.rpp.HtQ instanceof Integer)) {
      this.HBm = ((Integer)this.rpp.HtQ).intValue();
    }
    if (this.HBm > 1)
    {
      this.nnT = paramContext.getResources().getString(p.g.search_message_count, new Object[] { Integer.valueOf(this.HBm) });
      AppMethodBeat.o(112101);
      return;
    }
    String str;
    Object localObject1;
    Object localObject2;
    if (this.HBm == 1)
    {
      str = "";
      localObject1 = "";
      localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().sl(this.rpp.HtI);
      parama = (a.a)localObject1;
      paramVarArgs = str;
    }
    switch (this.rpp.subtype)
    {
    default: 
      paramVarArgs = str;
      parama = (a.a)localObject1;
    case 51: 
    case 41: 
      for (;;)
      {
        this.nnT = p.d(paramContext, Util.nullAs(parama, "").replace('\n', ' '), b.c.HwS);
        if (Util.isNullOrNil(paramVarArgs)) {
          break;
        }
        float f1 = b.a.HwK;
        float f2 = b.c.HwT.measureText(paramVarArgs.toString());
        this.nnT = com.tencent.mm.plugin.fts.a.f.a(g.a(this.nnT, this.FWt, f1 - f2, b.c.HwT)).HsX;
        this.nnT = TextUtils.concat(new CharSequence[] { paramVarArgs, this.nnT });
        this.HBn = com.tencent.mm.pluginsdk.platformtools.f.d(paramContext, this.rpp.timestamp, true);
        AppMethodBeat.o(112101);
        return;
        localObject1 = ((fi)localObject2).field_content;
        parama = (a.a)localObject1;
        paramVarArgs = str;
        if (au.bwE(this.username))
        {
          parama = br.JK((String)localObject1);
          paramVarArgs = str;
        }
      }
    case 42: 
      label353:
      parama = k.b.Hf(((fi)localObject2).field_content);
      if (parama == null) {
        break;
      }
    }
    for (parama = parama.title;; parama = "")
    {
      paramVarArgs = paramContext.getString(p.g.fts_message_file_tag);
      break;
      paramVarArgs = k.b.Hf(((fi)localObject2).field_content);
      parama = (a.a)localObject1;
      if (paramVarArgs != null) {
        parama = paramVarArgs.title;
      }
      paramVarArgs = paramContext.getString(p.g.fts_message_link_tag);
      break;
      paramVarArgs = k.b.Hf(((fi)localObject2).field_content);
      parama = (a.a)localObject1;
      if (paramVarArgs != null) {
        parama = paramVarArgs.title;
      }
      paramVarArgs = paramContext.getString(p.g.fts_message_appbrand_tag);
      break;
      paramVarArgs = k.b.Hf(((fi)localObject2).field_content);
      parama = (a.a)localObject1;
      if (paramVarArgs != null) {
        parama = paramVarArgs.description;
      }
      paramVarArgs = paramContext.getString(p.g.fts_message_note_tag);
      break;
      localObject2 = k.b.Hf(((fi)localObject2).field_content);
      parama = (a.a)localObject1;
      paramVarArgs = str;
      if (localObject2 == null) {
        break;
      }
      paramVarArgs = ((k.b)localObject2).title + ": ";
      parama = ((k.b)localObject2).description;
      break;
      localObject2 = k.b.Hf(((fi)localObject2).field_content);
      parama = (a.a)localObject1;
      paramVarArgs = str;
      if (localObject2 == null) {
        break;
      }
      parama = Util.nullAs(((k.b)localObject2).title, "") + ": " + Util.nullAs(((k.b)localObject2).description, "");
      paramVarArgs = str;
      break;
      parama = k.b.Hf(((fi)localObject2).field_content);
      if (parama != null)
      {
        if (((fi)localObject2).field_isSend == 1)
        {
          parama = Util.nullAs(parama.nSI, "") + ": " + Util.nullAs(parama.nSF, "");
          paramVarArgs = str;
          break;
        }
        parama = Util.nullAs(parama.nSI, "") + ": " + Util.nullAs(parama.nSE, "");
        paramVarArgs = str;
        break;
      }
      parama = "";
      paramVarArgs = str;
      break;
      paramVarArgs = ((fi)localObject2).field_content;
      if (au.bwE(this.username)) {
        paramVarArgs = br.JK(paramVarArgs);
      }
      for (;;)
      {
        parama = paramVarArgs;
        if (!Util.isNullOrNil(paramVarArgs))
        {
          localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().aLV(paramVarArgs);
          parama = paramVarArgs;
          if (((cc.c)localObject1).jcw()) {
            parama = ((cc.c)localObject1).poiName;
          }
        }
        paramVarArgs = paramContext.getString(p.g.fts_message_location_tag);
        break;
        parama = k.b.Hf(((fi)localObject2).field_content);
        if (parama != null)
        {
          parama = Util.nullAs(parama.getTitle(), "");
          paramVarArgs = str;
          break;
        }
        parama = "";
        paramVarArgs = str;
        break;
        parama = k.b.Hf(((fi)localObject2).field_content);
        if (parama != null)
        {
          parama = (com.tencent.mm.plugin.findersdk.a.f)parama.aK(com.tencent.mm.plugin.findersdk.a.f.class);
          if (!Util.isNullOrNil(parama.getNickname()))
          {
            parama = paramContext.getString(p.g.fts_info_finder_desc, new Object[] { Util.nullAs(parama.getNickname(), "") });
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
        this.nnT = com.tencent.mm.plugin.fts.a.f.a(g.a(this.nnT, this.FWt, b.a.HwK, b.c.HwT)).HsX;
        break label353;
      }
    }
  }
  
  public com.tencent.mm.plugin.fts.a.d.a.a.b aXA()
  {
    return this.HBo;
  }
  
  public final int coC()
  {
    return this.rpp.HtS;
  }
  
  public int fxM()
  {
    if (this.HBm < 2) {
      return 0;
    }
    return 1;
  }
  
  public final class a
    extends a.a
  {
    public ImageView lBC;
    public TextView lBD;
    public TextView lNZ;
    public View rpv;
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
      paramContext = LayoutInflater.from(paramContext).inflate(p.e.fts_message_item, paramViewGroup, false);
      paramViewGroup = (m.a)m.this.HBp;
      paramViewGroup.lBC = ((ImageView)paramContext.findViewById(p.d.avatar_iv));
      paramViewGroup.lBD = ((TextView)paramContext.findViewById(p.d.nickname_tv));
      paramViewGroup.lNZ = ((TextView)paramContext.findViewById(p.d.msg_tv));
      paramViewGroup.timeTV = ((TextView)paramContext.findViewById(p.d.time_tv));
      paramViewGroup.rpv = paramContext.findViewById(p.d.divider);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(112097);
      return paramContext;
    }
    
    public void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112098);
      parama1 = (m)parama1;
      parama = (m.a)parama;
      com.tencent.mm.plugin.fts.ui.o.w(parama.rpv, m.this.Hup);
      com.tencent.mm.pluginsdk.ui.a.b.g(parama.lBC, parama1.username);
      com.tencent.mm.plugin.fts.ui.o.a(parama1.nnT, parama.lNZ);
      com.tencent.mm.plugin.fts.ui.o.a(parama1.HBn, parama.timeTV);
      if (ab.IG(parama1.username))
      {
        com.tencent.mm.plugin.fts.ui.o.a(((e)com.tencent.mm.kernel.h.ax(e.class)).a(paramContext, parama1.pJG), parama.lBD);
        AppMethodBeat.o(112098);
        return;
      }
      if (au.bwO(parama1.username))
      {
        com.tencent.mm.kernel.h.baF();
        paramContext = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(parama1.username);
        ((e)com.tencent.mm.kernel.h.ax(e.class)).a(parama.lBD.getContext(), parama.lBD, parama1.pJG, paramContext.field_openImAppid, paramContext.field_descWordingId, (int)parama.lBD.getTextSize());
        AppMethodBeat.o(112098);
        return;
      }
      com.tencent.mm.plugin.fts.ui.o.a(parama1.pJG, parama.lBD);
      AppMethodBeat.o(112098);
    }
    
    public boolean a(Context paramContext, View paramView, a paramVarArgs)
    {
      AppMethodBeat.i(265742);
      boolean bool = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).getItemClickHandler(m.this.viewType).a(paramContext, paramView, paramVarArgs);
      AppMethodBeat.o(265742);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.b.m
 * JD-Core Version:    0.7.0.1
 */