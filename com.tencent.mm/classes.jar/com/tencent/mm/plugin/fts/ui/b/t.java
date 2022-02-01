package com.tencent.mm.plugin.fts.ui.b;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.mmdata.rpt.lf;
import com.tencent.mm.model.ab;
import com.tencent.mm.openim.api.e;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.c.a;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.ui.b.a;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.fts.ui.p.c;
import com.tencent.mm.plugin.fts.ui.p.d;
import com.tencent.mm.plugin.fts.ui.p.e;
import com.tencent.mm.plugin.fts.ui.p.g;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import java.util.List;
import java.util.regex.Pattern;

public final class t
  extends com.tencent.mm.plugin.fts.a.d.a.a
{
  public CharSequence HBO;
  public CharSequence HBP;
  private b HBQ;
  a HBR;
  public au contact;
  public com.tencent.mm.plugin.fts.a.a.o rpp;
  public String username;
  public CharSequence vFg;
  
  public t(int paramInt)
  {
    super(2, paramInt);
    AppMethodBeat.i(112116);
    this.HBQ = new b();
    this.HBR = new a();
    AppMethodBeat.o(112116);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    int i = 1;
    AppMethodBeat.i(112117);
    super.a(paramContext, parama, paramVarArgs);
    this.username = this.rpp.Hsz;
    this.contact = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(this.username);
    boolean bool1;
    boolean bool2;
    for (;;)
    {
      try
      {
        paramVarArgs = paramContext.getResources();
        this.HBO = p.d(paramContext, d.atS(this.contact.field_username), b.c.HwQ);
        switch (this.rpp.subtype)
        {
        case 3: 
          if (i != 0) {
            this.HBO = com.tencent.mm.plugin.fts.a.f.a(g.a(this.HBO, this.FWt, bool1, bool2, b.a.HwK, b.c.HwR)).HsX;
          }
          this.vFg = paramContext;
          AppMethodBeat.o(112117);
          return;
        }
      }
      catch (Exception paramContext)
      {
        label203:
        boolean bool3;
        label214:
        Log.printErrStackTrace("MicroMsg.FTS.FTSWXChatroomDataItem", paramContext, "format text exception", new Object[0]);
        if (this.HBO != null) {
          continue;
        }
        this.HBO = d.atS(this.contact.field_username);
        AppMethodBeat.o(112117);
        return;
      }
      bool1 = true;
      bool3 = true;
      bool2 = bool1;
      bool1 = bool3;
      if (Util.isNullOrNil(this.contact.field_nickname)) {
        break label629;
      }
      paramContext = TextUtils.concat(new CharSequence[] { paramContext.getString(p.g.search_contact_tag_roomname), p.b(paramContext, this.contact.aSU()) });
    }
    for (;;)
    {
      if (Util.isNullOrNil(this.contact.field_conRemark))
      {
        paramContext = null;
        break;
      }
      paramContext = com.tencent.mm.plugin.fts.a.f.a(g.a(TextUtils.concat(new CharSequence[] { paramContext.getString(p.g.search_contact_tag_roomname), p.b(paramContext, this.contact.aSU()) }), this.FWt, bool1, bool2, b.a.HwK, b.c.HwR)).HsX;
      i = 0;
      break;
      Object localObject = com.tencent.mm.kernel.h.baE().mCN.rawQuery("SELECT memberlist FROM chatroom WHERE chatroomname=?;", new String[] { this.contact.field_username }, 2);
      if (((Cursor)localObject).moveToFirst())
      {
        parama = ((Cursor)localObject).getString(0);
        if (parama == null) {
          parama = null;
        }
      }
      for (;;)
      {
        ((Cursor)localObject).close();
        if ((parama != null) && (parama.length > 0)) {
          this.HBP = ("(" + parama.length + ")");
        }
        if ((parama == null) || (this.rpp.HtP == null)) {
          break label664;
        }
        paramContext = com.tencent.mm.plugin.fts.ui.o.a(paramContext, this.rpp.HtP, parama, this.FWt, b.c.HwT);
        paramContext = TextUtils.concat(new CharSequence[] { paramVarArgs.getString(p.g.search_contact_tag_member), paramContext });
        parama = this.HBO;
        paramVarArgs = this.HBP;
        float f = b.a.HwK;
        localObject = b.c.HwR;
        TextUtils.TruncateAt localTruncateAt = TextUtils.TruncateAt.END;
        this.HBO = TextUtils.concat(new CharSequence[] { TextUtils.ellipsize(parama, (TextPaint)localObject, f - ((TextPaint)localObject).measureText(paramVarArgs.toString()), localTruncateAt), paramVarArgs });
        bool2 = false;
        bool1 = false;
        i = 0;
        break;
        parama = c.a.Hry.split(parama);
        continue;
        parama = null;
      }
      label629:
      paramContext = null;
      break;
      bool1 = false;
      break label203;
      bool1 = false;
      break label681;
      bool2 = false;
      bool1 = false;
      continue;
      bool2 = false;
      bool1 = false;
      break label214;
      label664:
      bool2 = false;
      bool1 = false;
      i = 0;
      paramContext = null;
      break;
      bool1 = true;
      label681:
      bool2 = bool1;
      bool1 = true;
    }
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a.b aXA()
  {
    return this.HBQ;
  }
  
  public final int coC()
  {
    return this.rpp.HtS;
  }
  
  public final int fxK()
  {
    AppMethodBeat.i(112118);
    if (this.rpp.subtype == 38)
    {
      List localList = this.rpp.HtP;
      if ((localList != null) && (localList.size() > 0))
      {
        i = ((i)localList.get(0)).subtype;
        AppMethodBeat.o(112118);
        return i;
      }
    }
    int i = super.fxK();
    AppMethodBeat.o(112118);
    return i;
  }
  
  public final boolean fxL()
  {
    return this.rpp.HtT;
  }
  
  public final class a
    extends a.a
  {
    public ImageView lBC;
    public TextView pJJ;
    public TextView plr;
    public View rpv;
    
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
      AppMethodBeat.i(112113);
      paramContext = LayoutInflater.from(paramContext).inflate(p.e.fts_contact_item, paramViewGroup, false);
      paramViewGroup = (t.a)t.this.HBR;
      paramViewGroup.lBC = ((ImageView)paramContext.findViewById(p.d.avatar_iv));
      paramViewGroup.pJJ = ((TextView)paramContext.findViewById(p.d.title_tv));
      paramViewGroup.plr = ((TextView)paramContext.findViewById(p.d.desc_tv));
      paramViewGroup.rpv = paramContext.findViewById(p.d.divider);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(112113);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, com.tencent.mm.plugin.fts.a.d.a.a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112114);
      parama = (t.a)parama;
      parama1 = (t)parama1;
      com.tencent.mm.plugin.fts.ui.o.w(parama.rpv, t.this.Hup);
      if ((parama1.username != null) && (parama1.username.length() > 0))
      {
        com.tencent.mm.pluginsdk.ui.a.b.g(parama.lBC, parama1.username);
        if (!ab.IG(parama1.username)) {
          break label138;
        }
        com.tencent.mm.plugin.fts.ui.o.a(((e)com.tencent.mm.kernel.h.ax(e.class)).a(paramContext, parama1.HBO), parama.pJJ);
      }
      for (;;)
      {
        parama.pJJ.setMaxWidth(com.tencent.mm.cd.a.fromDPToPix(paramContext, 200));
        com.tencent.mm.plugin.fts.ui.o.a(parama1.vFg, parama.plr);
        AppMethodBeat.o(112114);
        return;
        parama.lBC.setImageResource(p.c.default_avatar);
        break;
        label138:
        com.tencent.mm.plugin.fts.ui.o.a(parama1.HBO, parama.pJJ);
      }
    }
    
    public final boolean a(Context paramContext, View paramView, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
    {
      AppMethodBeat.i(265722);
      paramVarArgs = (t)paramVarArgs;
      a(t.this.FWt.Hte, paramVarArgs.rpp);
      Intent localIntent = new Intent().putExtra("Chat_User", paramVarArgs.username).putExtra("finish_direct", true);
      localIntent.putExtra("chat_from_scene", 5);
      if (((au.bwO(paramVarArgs.username)) || (au.bwP(paramVarArgs.username))) && (!WeChatBrands.Business.Entries.ContactWeCom.checkAvailable(paramView.getContext())))
      {
        AppMethodBeat.o(265722);
        return true;
      }
      if (au.bwF(paramVarArgs.username))
      {
        paramView = new lf();
        paramView.uc(paramVarArgs.username);
        paramView.iuA = 3L;
        paramView.bMH();
      }
      com.tencent.mm.br.c.g(paramContext, ".ui.chatting.ChattingUI", localIntent);
      ((com.tencent.mm.plugin.comm.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.comm.a.c.class)).dQ(paramVarArgs.username, 2);
      AppMethodBeat.o(265722);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.b.t
 * JD-Core Version:    0.7.0.1
 */