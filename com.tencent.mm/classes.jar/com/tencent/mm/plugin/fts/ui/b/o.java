package com.tencent.mm.plugin.fts.ui.b;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.br.c;
import com.tencent.mm.message.c.b;
import com.tencent.mm.message.c.b.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.s;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.ui.p.d;
import com.tencent.mm.plugin.fts.ui.p.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import java.util.Iterator;
import java.util.List;
import org.xwalk.core.Log;

public final class o
  extends com.tencent.mm.plugin.fts.a.d.a.a
{
  public CharSequence HBn;
  public a HBu;
  b HBv;
  public long msgId;
  public List<b.a> nVO;
  public CharSequence pJG;
  public com.tencent.mm.plugin.fts.a.a.o rpp;
  public CharSequence title;
  public String username;
  
  public o(int paramInt)
  {
    super(16, paramInt);
    AppMethodBeat.i(265725);
    this.HBu = new a(this.syO);
    this.HBv = new b();
    AppMethodBeat.o(265725);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(265731);
    super.a(paramContext, parama, paramVarArgs);
    paramVarArgs = (b)parama;
    parama = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(this.rpp.HtI);
    if (parama == null)
    {
      Log.w("MicroMsg.FTSServiceNotifyMsgContentDataItem", "msg info is null");
      AppMethodBeat.o(265731);
      return;
    }
    b localb = b.Ht(parama.field_content);
    this.msgId = parama.field_msgId;
    this.username = localb.iaa;
    if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.biz.a.a.class)).Hh(this.username))
    {
      parama = ((s)com.tencent.mm.kernel.h.ax(s.class)).Xy(this.username);
      if (parama == null) {
        parama = this.username;
      }
    }
    for (;;)
    {
      this.pJG = p.d(paramContext, parama, paramVarArgs.lBD.getTextSize());
      this.title = localb.title;
      this.HBn = com.tencent.mm.pluginsdk.platformtools.f.d(paramContext, this.rpp.timestamp, true);
      this.nVO = localb.nVO;
      AppMethodBeat.o(265731);
      return;
      parama = parama.field_nickname;
      continue;
      parama = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(this.username);
      if (parama == null) {
        parama = this.username;
      } else {
        parama = parama.aSV();
      }
    }
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a.b aXA()
  {
    return this.HBu;
  }
  
  public final int coC()
  {
    return this.rpp.HtS;
  }
  
  public final class a
    extends com.tencent.mm.plugin.fts.a.d.a.a.b
  {
    public int syO;
    
    public a(int paramInt)
    {
      super();
      this.syO = paramInt;
    }
    
    private static CharSequence a(TextView paramTextView, CharSequence paramCharSequence, j paramj)
    {
      AppMethodBeat.i(265736);
      paramCharSequence = g.a(paramCharSequence, paramj);
      paramCharSequence.dso = paramTextView.getPaint();
      paramTextView = com.tencent.mm.plugin.fts.a.f.a(paramCharSequence).HsX;
      AppMethodBeat.o(265736);
      return paramTextView;
    }
    
    public final View a(Context paramContext, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(265740);
      paramContext = LayoutInflater.from(paramContext).inflate(p.e.fts_servicenotify_msg_content_item, paramViewGroup, false);
      paramViewGroup = (o.b)o.this.HBv;
      paramViewGroup.HBx = ((ViewGroup)paramContext.findViewById(p.d.item_head_layout));
      paramViewGroup.lBC = ((ImageView)paramContext.findViewById(p.d.avatar_iv));
      paramViewGroup.lBD = ((TextView)paramContext.findViewById(p.d.nickname_tv));
      paramViewGroup.HBy = ((TextView)paramContext.findViewById(p.d.head_time_tv));
      paramViewGroup.HBz = paramContext.findViewById(p.d.item_head_divider);
      paramViewGroup.pJJ = ((TextView)paramContext.findViewById(p.d.title_tv));
      paramViewGroup.HBA = ((TextView)paramContext.findViewById(p.d.item_title_time_tv));
      paramViewGroup.HBB = ((LinearLayout)paramContext.findViewById(p.d.line_msg_container));
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(265740);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, com.tencent.mm.plugin.fts.a.d.a.a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(265751);
      Object localObject1 = (o)parama1;
      parama1 = (o.b)parama;
      if (this.syO == 3)
      {
        parama1.HBx.setVisibility(8);
        parama1.HBz.setVisibility(8);
        parama1.HBA.setVisibility(0);
        com.tencent.mm.plugin.fts.ui.o.a(((o)localObject1).HBn, parama1.HBA);
      }
      for (;;)
      {
        com.tencent.mm.plugin.fts.ui.o.a(a(parama1.pJJ, ((o)localObject1).title, o.this.FWt), parama1.pJJ);
        paramVarArgs = ((com.tencent.mm.plugin.fts.a.d.a.a)localObject1).FWt.Hte;
        if ((((o)localObject1).nVO != null) && (!((o)localObject1).nVO.isEmpty()) && (!Util.isNullOrNil(paramVarArgs))) {
          break;
        }
        parama1.HBB.removeAllViews();
        parama1.HBB.setVisibility(8);
        AppMethodBeat.o(265751);
        return;
        parama1.HBx.setVisibility(0);
        parama1.HBz.setVisibility(0);
        parama1.HBA.setVisibility(8);
        com.tencent.mm.pluginsdk.ui.a.b.h(parama1.lBC, ((o)localObject1).username);
        com.tencent.mm.plugin.fts.ui.o.a(((o)localObject1).pJG, parama1.lBD);
        com.tencent.mm.plugin.fts.ui.o.a(((o)localObject1).HBn, parama1.HBy);
      }
      parama = ((o)localObject1).nVO.iterator();
      int j = 0;
      Object localObject2;
      if (parama.hasNext())
      {
        localObject2 = ((b.a)parama.next()).nVP;
        int m;
        if (Util.isNullOrNil((String)localObject2)) {
          m = 0;
        }
        int k;
        do
        {
          j = Math.max((m + 1) / 2, j);
          break;
          k = 0;
          i = 0;
          m = i;
        } while (k >= ((String)localObject2).length());
        if (((String)localObject2).substring(k, k + 1).matches("[Α-￥]")) {
          i += 2;
        }
        for (;;)
        {
          k += 1;
          break;
          i += 1;
        }
      }
      j = Math.min(j, 8);
      localObject1 = ((o)localObject1).nVO.iterator();
      int i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (b.a)((Iterator)localObject1).next();
        if (Util.nullAsNil(((b.a)localObject2).nVQ).toLowerCase().contains(Util.nullAsNil(paramVarArgs).toLowerCase()))
        {
          if (i < parama1.HBB.getChildCount()) {
            parama = parama1.HBB.getChildAt(i);
          }
          for (;;)
          {
            TextView localTextView = (TextView)parama.findViewById(p.d.line_key_tv);
            parama = (TextView)parama.findViewById(p.d.line_value_tv);
            localTextView.setText(((b.a)localObject2).nVP);
            localTextView.setEms(j);
            parama.setText(a(parama, ((b.a)localObject2).nVQ, o.this.FWt));
            i += 1;
            break;
            parama = LayoutInflater.from(paramContext).inflate(p.e.fts_servicenotify_msg_content_line_item, null);
            parama1.HBB.addView(parama);
          }
        }
      }
      if (i < parama1.HBB.getChildCount())
      {
        paramContext = parama1.HBB;
        paramContext.removeViews(i, paramContext.getChildCount() - i);
      }
      parama1.HBB.setVisibility(0);
      AppMethodBeat.o(265751);
    }
    
    public final boolean a(Context paramContext, View paramView, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
    {
      AppMethodBeat.i(265760);
      paramView = (o)paramVarArgs;
      paramVarArgs = new Intent();
      paramVarArgs.putExtra("Chat_User", Util.nullAsNil("notifymessage"));
      paramVarArgs.putExtra("finish_direct", true);
      paramVarArgs.putExtra("from_service_notify_content_search", true);
      paramVarArgs.putExtra("need_hight_item", true);
      paramVarArgs.putExtra("chat_from_scene", 6);
      paramVarArgs.putExtra("msg_local_id", paramView.msgId);
      if (this.syO == 3) {
        paramVarArgs.putExtra("key_notify_message_real_username", paramView.username);
      }
      c.g(paramContext, ".ui.chatting.ChattingUI", paramVarArgs);
      AppMethodBeat.o(265760);
      return true;
    }
  }
  
  public final class b
    extends a.a
  {
    public TextView HBA;
    public LinearLayout HBB;
    public ViewGroup HBx;
    public TextView HBy;
    public View HBz;
    public ImageView lBC;
    public TextView lBD;
    public TextView pJJ;
    
    public b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.b.o
 * JD-Core Version:    0.7.0.1
 */