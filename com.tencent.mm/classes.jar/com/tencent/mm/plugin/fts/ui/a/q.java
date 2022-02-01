package com.tencent.mm.plugin.fts.ui.a;

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
import com.tencent.mm.by.c;
import com.tencent.mm.f.b.a.iv;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.c.a;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.ui.b.a;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.fts.ui.o.c;
import com.tencent.mm.plugin.fts.ui.o.d;
import com.tencent.mm.plugin.fts.ui.o.e;
import com.tencent.mm.plugin.fts.ui.o.g;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import java.util.List;
import java.util.regex.Pattern;

public final class q
  extends com.tencent.mm.plugin.fts.a.d.a.a
{
  public CharSequence BPG;
  public CharSequence BPH;
  private b BPI;
  a BPJ;
  public as contact;
  public m olG;
  public CharSequence szB;
  public String username;
  
  public q(int paramInt)
  {
    super(2, paramInt);
    AppMethodBeat.i(112116);
    this.BPI = new b();
    this.BPJ = new a();
    AppMethodBeat.o(112116);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    int i = 1;
    AppMethodBeat.i(112117);
    super.a(paramContext, parama, paramVarArgs);
    this.username = this.olG.BHS;
    this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(this.username);
    boolean bool1;
    boolean bool2;
    for (;;)
    {
      try
      {
        paramVarArgs = paramContext.getResources();
        this.BPG = l.d(paramContext, d.azM(this.contact.field_username), b.c.BLU);
        switch (this.olG.BHR)
        {
        case 3: 
          if (i != 0) {
            this.BPG = com.tencent.mm.plugin.fts.a.f.a(e.a(this.BPG, this.BHY, bool1, bool2, b.a.BLO, b.c.BLV)).BIp;
          }
          this.szB = paramContext;
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
        if (this.BPG != null) {
          continue;
        }
        this.BPG = d.azM(this.contact.field_username);
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
      paramContext = TextUtils.concat(new CharSequence[] { paramContext.getString(o.g.search_contact_tag_roomname), l.c(paramContext, this.contact.ayr()) });
    }
    for (;;)
    {
      if (Util.isNullOrNil(this.contact.field_conRemark))
      {
        paramContext = null;
        break;
      }
      paramContext = com.tencent.mm.plugin.fts.a.f.a(e.a(TextUtils.concat(new CharSequence[] { paramContext.getString(o.g.search_contact_tag_roomname), l.c(paramContext, this.contact.ayr()) }), this.BHY, bool1, bool2, b.a.BLO, b.c.BLV)).BIp;
      i = 0;
      break;
      Object localObject = com.tencent.mm.kernel.h.aHG().kcF.rawQuery("SELECT memberlist FROM chatroom WHERE chatroomname=?;", new String[] { this.contact.field_username }, 2);
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
          this.BPH = ("(" + parama.length + ")");
        }
        if ((parama == null) || (this.olG.BJg == null)) {
          break label664;
        }
        paramContext = com.tencent.mm.plugin.fts.ui.n.a(paramContext, this.olG.BJg, parama, this.BHY, b.c.BLX);
        paramContext = TextUtils.concat(new CharSequence[] { paramVarArgs.getString(o.g.search_contact_tag_member), paramContext });
        parama = this.BPG;
        paramVarArgs = this.BPH;
        float f = b.a.BLO;
        localObject = b.c.BLV;
        TextUtils.TruncateAt localTruncateAt = TextUtils.TruncateAt.END;
        this.BPG = TextUtils.concat(new CharSequence[] { TextUtils.ellipsize(parama, (TextPaint)localObject, f - ((TextPaint)localObject).measureText(paramVarArgs.toString()), localTruncateAt), paramVarArgs });
        bool2 = false;
        bool1 = false;
        i = 0;
        break;
        parama = c.a.BGU.split(parama);
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
  
  public final com.tencent.mm.plugin.fts.a.d.a.a.b aEw()
  {
    return this.BPI;
  }
  
  public final int bOn()
  {
    return this.olG.BJj;
  }
  
  public final int erd()
  {
    AppMethodBeat.i(112118);
    if (this.olG.BHR == 38)
    {
      List localList = this.olG.BJg;
      if ((localList != null) && (localList.size() > 0))
      {
        i = ((g)localList.get(0)).BHR;
        AppMethodBeat.o(112118);
        return i;
      }
    }
    int i = super.erd();
    AppMethodBeat.o(112118);
    return i;
  }
  
  public final boolean ere()
  {
    return this.olG.BJk;
  }
  
  public final class a
    extends a.a
  {
    public ImageView iZG;
    public TextView mNb;
    public TextView mrM;
    public View olM;
    
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
      paramContext = LayoutInflater.from(paramContext).inflate(o.e.fts_contact_item, paramViewGroup, false);
      paramViewGroup = (q.a)q.this.BPJ;
      paramViewGroup.iZG = ((ImageView)paramContext.findViewById(o.d.avatar_iv));
      paramViewGroup.mNb = ((TextView)paramContext.findViewById(o.d.title_tv));
      paramViewGroup.mrM = ((TextView)paramContext.findViewById(o.d.desc_tv));
      paramViewGroup.olM = paramContext.findViewById(o.d.divider);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(112113);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, com.tencent.mm.plugin.fts.a.d.a.a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112114);
      parama = (q.a)parama;
      parama1 = (q)parama1;
      com.tencent.mm.plugin.fts.ui.n.q(parama.olM, q.this.BJG);
      if ((parama1.username != null) && (parama1.username.length() > 0))
      {
        com.tencent.mm.pluginsdk.ui.a.b.c(parama.iZG, parama1.username);
        if (!ab.PR(parama1.username)) {
          break label138;
        }
        com.tencent.mm.plugin.fts.ui.n.a(((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.openim.a.a.class)).a(paramContext, parama1.BPG), parama.mNb);
      }
      for (;;)
      {
        parama.mNb.setMaxWidth(com.tencent.mm.ci.a.fromDPToPix(paramContext, 200));
        com.tencent.mm.plugin.fts.ui.n.a(parama1.szB, parama.mrM);
        AppMethodBeat.o(112114);
        return;
        parama.iZG.setImageResource(o.c.default_avatar);
        break;
        label138:
        com.tencent.mm.plugin.fts.ui.n.a(parama1.BPG, parama.mNb);
      }
    }
    
    public final boolean a(Context paramContext, View paramView, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
    {
      AppMethodBeat.i(194225);
      paramVarArgs = (q)paramVarArgs;
      a(q.this.BHY.BIw, paramVarArgs.olG);
      Intent localIntent = new Intent().putExtra("Chat_User", paramVarArgs.username).putExtra("finish_direct", true);
      localIntent.putExtra("chat_from_scene", 5);
      if (((as.bvK(paramVarArgs.username)) || (as.bvL(paramVarArgs.username))) && (!WeChatBrands.Business.Entries.ContactWeCom.checkAvailable(paramView.getContext())))
      {
        AppMethodBeat.o(194225);
        return true;
      }
      if (ab.PQ(paramVarArgs.username))
      {
        paramView = new iv();
        paramView.zR(paramVarArgs.username);
        paramView.gmT = 3L;
        paramView.bpa();
      }
      c.f(paramContext, ".ui.chatting.ChattingUI", localIntent);
      ((b)com.tencent.mm.kernel.h.ae(b.class)).dp(paramVarArgs.username, 2);
      AppMethodBeat.o(194225);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.q
 * JD-Core Version:    0.7.0.1
 */