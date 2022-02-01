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
import com.tencent.mm.br.c;
import com.tencent.mm.g.b.a.gq;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.c.a;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.ui.b.a;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.fts.ui.n;
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
  public as contact;
  public m lqW;
  public CharSequence pqC;
  public String username;
  public CharSequence xdI;
  public CharSequence xdJ;
  private b xdK;
  a xdL;
  
  public q(int paramInt)
  {
    super(2, paramInt);
    AppMethodBeat.i(112116);
    this.xdK = new b();
    this.xdL = new a();
    AppMethodBeat.o(112116);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    int i = 1;
    AppMethodBeat.i(112117);
    super.a(paramContext, parama, paramVarArgs);
    this.username = this.lqW.wVX;
    this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(this.username);
    boolean bool1;
    boolean bool2;
    for (;;)
    {
      try
      {
        paramVarArgs = paramContext.getResources();
        this.xdI = com.tencent.mm.pluginsdk.ui.span.l.d(paramContext, d.arL(this.contact.field_username), b.c.wZV);
        switch (this.lqW.wVW)
        {
        case 3: 
          if (i != 0) {
            this.xdI = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.e.a(this.xdI, this.wWd, bool1, bool2, b.a.wZP, b.c.wZW)).wWu;
          }
          this.pqC = paramContext;
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
        if (this.xdI != null) {
          continue;
        }
        this.xdI = d.arL(this.contact.field_username);
        AppMethodBeat.o(112117);
        return;
      }
      bool1 = true;
      bool3 = true;
      bool2 = bool1;
      bool1 = bool3;
      if (Util.isNullOrNil(this.contact.field_nickname)) {
        break label626;
      }
      paramContext = TextUtils.concat(new CharSequence[] { paramContext.getString(2131765069), com.tencent.mm.pluginsdk.ui.span.l.c(paramContext, this.contact.arI()) });
    }
    for (;;)
    {
      if (Util.isNullOrNil(this.contact.field_conRemark))
      {
        paramContext = null;
        break;
      }
      paramContext = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.e.a(TextUtils.concat(new CharSequence[] { paramContext.getString(2131765069), com.tencent.mm.pluginsdk.ui.span.l.c(paramContext, this.contact.arI()) }), this.wWd, bool1, bool2, b.a.wZP, b.c.wZW)).wWu;
      i = 0;
      break;
      Object localObject = com.tencent.mm.kernel.g.aAh().hqK.rawQuery("SELECT memberlist FROM chatroom WHERE chatroomname=?;", new String[] { this.contact.field_username }, 2);
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
          this.xdJ = ("(" + parama.length + ")");
        }
        if ((parama == null) || (this.lqW.wXl == null)) {
          break label661;
        }
        paramContext = n.a(paramContext, this.lqW.wXl, parama, this.wWd, b.c.wZY);
        paramContext = TextUtils.concat(new CharSequence[] { paramVarArgs.getString(2131765064), paramContext });
        parama = this.xdI;
        paramVarArgs = this.xdJ;
        float f = b.a.wZP;
        localObject = b.c.wZW;
        TextUtils.TruncateAt localTruncateAt = TextUtils.TruncateAt.END;
        this.xdI = TextUtils.concat(new CharSequence[] { TextUtils.ellipsize(parama, (TextPaint)localObject, f - ((TextPaint)localObject).measureText(paramVarArgs.toString()), localTruncateAt), paramVarArgs });
        bool2 = false;
        bool1 = false;
        i = 0;
        break;
        parama = c.a.wUY.split(parama);
        continue;
        parama = null;
      }
      label626:
      paramContext = null;
      break;
      bool1 = false;
      break label203;
      bool1 = false;
      break label678;
      bool2 = false;
      bool1 = false;
      continue;
      bool2 = false;
      bool1 = false;
      break label214;
      label661:
      bool2 = false;
      bool1 = false;
      i = 0;
      paramContext = null;
      break;
      bool1 = true;
      label678:
      bool2 = bool1;
      bool1 = true;
    }
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a.b axc()
  {
    return this.xdK;
  }
  
  public final int bCS()
  {
    return this.lqW.wXn;
  }
  
  public final int dOK()
  {
    AppMethodBeat.i(112118);
    if (this.lqW.wVW == 38)
    {
      List localList = this.lqW.wXl;
      if ((localList != null) && (localList.size() > 0))
      {
        i = ((com.tencent.mm.plugin.fts.a.a.g)localList.get(0)).wVW;
        AppMethodBeat.o(112118);
        return i;
      }
    }
    int i = super.dOK();
    AppMethodBeat.o(112118);
    return i;
  }
  
  public final boolean dOL()
  {
    return this.lqW.wXo;
  }
  
  public final class a
    extends a.a
  {
    public ImageView gvv;
    public TextView jBR;
    public TextView jVO;
    public View lrc;
    
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
      paramContext = LayoutInflater.from(paramContext).inflate(2131494744, paramViewGroup, false);
      paramViewGroup = (q.a)q.this.xdL;
      paramViewGroup.gvv = ((ImageView)paramContext.findViewById(2131297134));
      paramViewGroup.jVO = ((TextView)paramContext.findViewById(2131309249));
      paramViewGroup.jBR = ((TextView)paramContext.findViewById(2131299510));
      paramViewGroup.lrc = paramContext.findViewById(2131299682);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(112113);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, com.tencent.mm.plugin.fts.a.d.a.a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112114);
      parama = (q.a)parama;
      parama1 = (q)parama1;
      n.q(parama.lrc, q.this.wXK);
      if ((parama1.username != null) && (parama1.username.length() > 0))
      {
        com.tencent.mm.pluginsdk.ui.a.b.c(parama.gvv, parama1.username);
        if (!ab.Iz(parama1.username)) {
          break label137;
        }
        n.a(((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.openim.a.a.class)).a(paramContext, parama1.xdI), parama.jVO);
      }
      for (;;)
      {
        parama.jVO.setMaxWidth(com.tencent.mm.cb.a.fromDPToPix(paramContext, 200));
        n.a(parama1.pqC, parama.jBR);
        AppMethodBeat.o(112114);
        return;
        parama.gvv.setImageResource(2131231957);
        break;
        label137:
        n.a(parama1.xdI, parama.jVO);
      }
    }
    
    public final boolean a(Context paramContext, View paramView, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
    {
      AppMethodBeat.i(235405);
      paramVarArgs = (q)paramVarArgs;
      a(q.this.wWd.wWB, paramVarArgs.lqW);
      Intent localIntent = new Intent().putExtra("Chat_User", paramVarArgs.username).putExtra("finish_direct", true);
      localIntent.putExtra("chat_from_scene", 5);
      if (((as.bjp(paramVarArgs.username)) || (as.bjq(paramVarArgs.username))) && (!WeChatBrands.Business.Entries.ContactWeCom.checkAvailable(paramView.getContext())))
      {
        AppMethodBeat.o(235405);
        return true;
      }
      if (ab.Iy(paramVarArgs.username))
      {
        paramView = new gq();
        paramView.us(paramVarArgs.username);
        paramView.erw = 3L;
        paramView.bfK();
      }
      c.f(paramContext, ".ui.chatting.ChattingUI", localIntent);
      ((b)com.tencent.mm.kernel.g.af(b.class)).cV(paramVarArgs.username, 2);
      AppMethodBeat.o(235405);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.q
 * JD-Core Version:    0.7.0.1
 */