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
import com.tencent.mm.aj.k.b;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bq;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.b;
import com.tencent.mm.plugin.fts.ui.b.a;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.fts.ui.o.d;
import com.tencent.mm.plugin.fts.ui.o.e;
import com.tencent.mm.plugin.fts.ui.o.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.bje;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca.b;

public class m
  extends com.tencent.mm.plugin.fts.a.d.a.a
{
  public int BPu;
  public CharSequence BPv;
  private b BPw;
  a BPx;
  public CharSequence kLX;
  public CharSequence mMY;
  public com.tencent.mm.plugin.fts.a.a.m olG;
  public String username;
  
  public m(int paramInt)
  {
    super(5, paramInt);
    AppMethodBeat.i(112100);
    this.BPw = new b();
    this.BPx = new a();
    AppMethodBeat.o(112100);
  }
  
  public void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112101);
    super.a(paramContext, parama, paramVarArgs);
    parama = (a)parama;
    this.username = this.olG.BHS;
    this.mMY = l.d(paramContext, d.azM(this.username), parama.iZH.getTextSize());
    if ((this.olG.BJh instanceof Integer)) {
      this.BPu = ((Integer)this.olG.BJh).intValue();
    }
    if (this.BPu > 1)
    {
      this.kLX = paramContext.getResources().getString(o.g.search_message_count, new Object[] { Integer.valueOf(this.BPu) });
      AppMethodBeat.o(112101);
      return;
    }
    String str;
    Object localObject1;
    Object localObject2;
    if (this.BPu == 1)
    {
      str = "";
      localObject1 = "";
      localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().Oq(this.olG.BIZ);
      parama = (a.a)localObject1;
      paramVarArgs = str;
    }
    switch (this.olG.BHR)
    {
    default: 
      paramVarArgs = str;
      parama = (a.a)localObject1;
    case 51: 
    case 41: 
      for (;;)
      {
        this.kLX = l.d(paramContext, Util.nullAs(parama, "").replace('\n', ' '), b.c.BLW);
        if (Util.isNullOrNil(paramVarArgs)) {
          break;
        }
        float f1 = b.a.BLO;
        float f2 = b.c.BLX.measureText(paramVarArgs.toString());
        this.kLX = com.tencent.mm.plugin.fts.a.f.a(e.a(this.kLX, this.BHY, f1 - f2, b.c.BLX)).BIp;
        this.kLX = TextUtils.concat(new CharSequence[] { paramVarArgs, this.kLX });
        this.BPv = com.tencent.mm.pluginsdk.j.f.d(paramContext, this.olG.timestamp, true);
        AppMethodBeat.o(112101);
        return;
        localObject1 = ((et)localObject2).field_content;
        parama = (a.a)localObject1;
        paramVarArgs = str;
        if (ab.PO(this.username))
        {
          parama = bq.RM((String)localObject1);
          paramVarArgs = str;
        }
      }
    case 42: 
      label353:
      parama = k.b.OQ(((et)localObject2).field_content);
      if (parama == null) {
        break;
      }
    }
    for (parama = parama.title;; parama = "")
    {
      paramVarArgs = paramContext.getString(o.g.fts_message_file_tag);
      break;
      paramVarArgs = k.b.OQ(((et)localObject2).field_content);
      parama = (a.a)localObject1;
      if (paramVarArgs != null) {
        parama = paramVarArgs.title;
      }
      paramVarArgs = paramContext.getString(o.g.fts_message_link_tag);
      break;
      paramVarArgs = k.b.OQ(((et)localObject2).field_content);
      parama = (a.a)localObject1;
      if (paramVarArgs != null) {
        parama = paramVarArgs.title;
      }
      paramVarArgs = paramContext.getString(o.g.fts_message_appbrand_tag);
      break;
      paramVarArgs = k.b.OQ(((et)localObject2).field_content);
      parama = (a.a)localObject1;
      if (paramVarArgs != null) {
        parama = paramVarArgs.description;
      }
      paramVarArgs = paramContext.getString(o.g.fts_message_note_tag);
      break;
      localObject2 = k.b.OQ(((et)localObject2).field_content);
      parama = (a.a)localObject1;
      paramVarArgs = str;
      if (localObject2 == null) {
        break;
      }
      paramVarArgs = ((k.b)localObject2).title + ": ";
      parama = ((k.b)localObject2).description;
      break;
      localObject2 = k.b.OQ(((et)localObject2).field_content);
      parama = (a.a)localObject1;
      paramVarArgs = str;
      if (localObject2 == null) {
        break;
      }
      parama = Util.nullAs(((k.b)localObject2).title, "") + ": " + Util.nullAs(((k.b)localObject2).description, "");
      paramVarArgs = str;
      break;
      parama = k.b.OQ(((et)localObject2).field_content);
      if (parama != null)
      {
        if (((et)localObject2).field_isSend == 1)
        {
          parama = Util.nullAs(parama.lnE, "") + ": " + Util.nullAs(parama.lnB, "");
          paramVarArgs = str;
          break;
        }
        parama = Util.nullAs(parama.lnE, "") + ": " + Util.nullAs(parama.lnA, "");
        paramVarArgs = str;
        break;
      }
      parama = "";
      paramVarArgs = str;
      break;
      paramVarArgs = ((et)localObject2).field_content;
      if (ab.Lj(this.username)) {
        paramVarArgs = bq.RM(paramVarArgs);
      }
      for (;;)
      {
        parama = paramVarArgs;
        if (!Util.isNullOrNil(paramVarArgs))
        {
          localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().aOV(paramVarArgs);
          parama = paramVarArgs;
          if (((ca.b)localObject1).hAq()) {
            parama = ((ca.b)localObject1).poiName;
          }
        }
        paramVarArgs = paramContext.getString(o.g.fts_message_location_tag);
        break;
        parama = k.b.OQ(((et)localObject2).field_content);
        if (parama != null)
        {
          parama = Util.nullAs(parama.getTitle(), "");
          paramVarArgs = str;
          break;
        }
        parama = "";
        paramVarArgs = str;
        break;
        parama = k.b.OQ(((et)localObject2).field_content);
        if (parama != null)
        {
          parama = ((com.tencent.mm.plugin.findersdk.a.f)parama.ar(com.tencent.mm.plugin.findersdk.a.f.class)).mbi;
          if (!Util.isNullOrNil(parama.nickname))
          {
            parama = paramContext.getString(o.g.fts_info_finder_desc, new Object[] { Util.nullAs(parama.nickname, "") });
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
        this.kLX = com.tencent.mm.plugin.fts.a.f.a(e.a(this.kLX, this.BHY, b.a.BLO, b.c.BLX)).BIp;
        break label353;
      }
    }
  }
  
  public com.tencent.mm.plugin.fts.a.d.a.a.b aEw()
  {
    return this.BPw;
  }
  
  public final int bOn()
  {
    return this.olG.BJj;
  }
  
  public int erf()
  {
    if (this.BPu < 2) {
      return 0;
    }
    return 1;
  }
  
  public final class a
    extends a.a
  {
    public ImageView iZG;
    public TextView iZH;
    public TextView jlh;
    public View olM;
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
      paramContext = LayoutInflater.from(paramContext).inflate(o.e.fts_message_item, paramViewGroup, false);
      paramViewGroup = (m.a)m.this.BPx;
      paramViewGroup.iZG = ((ImageView)paramContext.findViewById(o.d.avatar_iv));
      paramViewGroup.iZH = ((TextView)paramContext.findViewById(o.d.nickname_tv));
      paramViewGroup.jlh = ((TextView)paramContext.findViewById(o.d.msg_tv));
      paramViewGroup.timeTV = ((TextView)paramContext.findViewById(o.d.time_tv));
      paramViewGroup.olM = paramContext.findViewById(o.d.divider);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(112097);
      return paramContext;
    }
    
    public void a(Context paramContext, a.a parama, com.tencent.mm.plugin.fts.a.d.a.a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112098);
      parama1 = (m)parama1;
      parama = (m.a)parama;
      com.tencent.mm.plugin.fts.ui.n.q(parama.olM, m.this.BJG);
      com.tencent.mm.pluginsdk.ui.a.b.c(parama.iZG, parama1.username);
      com.tencent.mm.plugin.fts.ui.n.a(parama1.kLX, parama.jlh);
      com.tencent.mm.plugin.fts.ui.n.a(parama1.BPv, parama.timeTV);
      if (ab.PR(parama1.username))
      {
        com.tencent.mm.plugin.fts.ui.n.a(((com.tencent.mm.openim.a.a)h.ae(com.tencent.mm.openim.a.a.class)).a(paramContext, parama1.mMY), parama.iZH);
        AppMethodBeat.o(112098);
        return;
      }
      if (as.bvK(parama1.username))
      {
        h.aHH();
        paramContext = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(parama1.username);
        ((com.tencent.mm.openim.a.a)h.ae(com.tencent.mm.openim.a.a.class)).a(parama.iZH.getContext(), parama.iZH, parama1.mMY, paramContext.field_openImAppid, paramContext.field_descWordingId, (int)parama.iZH.getTextSize());
        AppMethodBeat.o(112098);
        return;
      }
      com.tencent.mm.plugin.fts.ui.n.a(parama1.mMY, parama.iZH);
      AppMethodBeat.o(112098);
    }
    
    public boolean a(Context paramContext, View paramView, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
    {
      AppMethodBeat.i(190580);
      boolean bool = ((com.tencent.mm.plugin.fts.a.n)h.ag(com.tencent.mm.plugin.fts.a.n.class)).getItemClickHandler(m.this.viewType).a(paramContext, paramView, paramVarArgs);
      AppMethodBeat.o(190580);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.m
 * JD-Core Version:    0.7.0.1
 */