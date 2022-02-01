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
import com.tencent.mm.g.b.a.do;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.c.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.ui.b.a;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import java.util.List;
import java.util.regex.Pattern;

public final class q
  extends com.tencent.mm.plugin.fts.a.d.a.a
{
  public an contact;
  public m kno;
  public CharSequence ofF;
  public CharSequence tMI;
  public CharSequence tMJ;
  private b tMK;
  a tML;
  public String username;
  
  public q(int paramInt)
  {
    super(2, paramInt);
    AppMethodBeat.i(112116);
    this.tMK = new b();
    this.tML = new a();
    AppMethodBeat.o(112116);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    int i = 1;
    AppMethodBeat.i(112117);
    super.a(paramContext, parama, paramVarArgs);
    this.username = this.kno.tEY;
    this.contact = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(this.username);
    boolean bool1;
    boolean bool2;
    for (;;)
    {
      try
      {
        paramVarArgs = paramContext.getResources();
        this.tMI = k.d(paramContext, com.tencent.mm.plugin.fts.a.d.ahd(this.contact.field_username), b.c.tIW);
        switch (this.kno.tEX)
        {
        case 3: 
          if (i != 0) {
            this.tMI = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.e.a(this.tMI, this.tFe, bool1, bool2, b.a.tIQ, b.c.tIX)).tFv;
          }
          this.ofF = paramContext;
          AppMethodBeat.o(112117);
          return;
        }
      }
      catch (Exception paramContext)
      {
        label203:
        boolean bool3;
        label214:
        ae.printErrStackTrace("MicroMsg.FTS.FTSWXChatroomDataItem", paramContext, "format text exception", new Object[0]);
        if (this.tMI != null) {
          continue;
        }
        this.tMI = com.tencent.mm.plugin.fts.a.d.ahd(this.contact.field_username);
        AppMethodBeat.o(112117);
        return;
      }
      bool1 = true;
      bool3 = true;
      bool2 = bool1;
      bool1 = bool3;
      if (bu.isNullOrNil(this.contact.field_nickname)) {
        break label626;
      }
      paramContext = TextUtils.concat(new CharSequence[] { paramContext.getString(2131762933), k.c(paramContext, this.contact.adF()) });
    }
    for (;;)
    {
      if (bu.isNullOrNil(this.contact.field_conRemark))
      {
        paramContext = null;
        break;
      }
      paramContext = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.e.a(TextUtils.concat(new CharSequence[] { paramContext.getString(2131762933), k.c(paramContext, this.contact.adF()) }), this.tFe, bool1, bool2, b.a.tIQ, b.c.tIX)).tFv;
      i = 0;
      break;
      Object localObject = com.tencent.mm.kernel.g.ajR().gDX.a("SELECT memberlist FROM chatroom WHERE chatroomname=?;", new String[] { this.contact.field_username }, 2);
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
          this.tMJ = ("(" + parama.length + ")");
        }
        if ((parama == null) || (this.kno.tGm == null)) {
          break label661;
        }
        paramContext = n.a(paramContext, this.kno.tGm, parama, this.tFe, b.c.tIZ);
        paramContext = TextUtils.concat(new CharSequence[] { paramVarArgs.getString(2131762928), paramContext });
        parama = this.tMI;
        paramVarArgs = this.tMJ;
        float f = b.a.tIQ;
        localObject = b.c.tIX;
        TextUtils.TruncateAt localTruncateAt = TextUtils.TruncateAt.END;
        this.tMI = TextUtils.concat(new CharSequence[] { TextUtils.ellipsize(parama, (TextPaint)localObject, f - ((TextPaint)localObject).measureText(paramVarArgs.toString()), localTruncateAt), paramVarArgs });
        bool2 = false;
        bool1 = false;
        i = 0;
        break;
        parama = c.a.tDZ.split(parama);
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
  
  public final com.tencent.mm.plugin.fts.a.d.a.a.b agQ()
  {
    return this.tMK;
  }
  
  public final int bhE()
  {
    return this.kno.tGo;
  }
  
  public final int cVB()
  {
    AppMethodBeat.i(112118);
    if (this.kno.tEX == 38)
    {
      List localList = this.kno.tGm;
      if ((localList != null) && (localList.size() > 0))
      {
        i = ((com.tencent.mm.plugin.fts.a.a.g)localList.get(0)).tEX;
        AppMethodBeat.o(112118);
        return i;
      }
    }
    int i = super.cVB();
    AppMethodBeat.o(112118);
    return i;
  }
  
  public final boolean cVC()
  {
    return this.kno.tGp;
  }
  
  public final class a
    extends a.a
  {
    public ImageView fQl;
    public TextView iFO;
    public TextView iYj;
    public View knu;
    
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
      paramContext = LayoutInflater.from(paramContext).inflate(2131494192, paramViewGroup, false);
      paramViewGroup = (q.a)q.this.tML;
      paramViewGroup.fQl = ((ImageView)paramContext.findViewById(2131297008));
      paramViewGroup.iYj = ((TextView)paramContext.findViewById(2131305948));
      paramViewGroup.iFO = ((TextView)paramContext.findViewById(2131299008));
      paramViewGroup.knu = paramContext.findViewById(2131299154);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(112113);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, com.tencent.mm.plugin.fts.a.d.a.a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112114);
      parama = (q.a)parama;
      parama1 = (q)parama1;
      n.p(parama.knu, q.this.tGL);
      if ((parama1.username != null) && (parama1.username.length() > 0))
      {
        com.tencent.mm.pluginsdk.ui.a.b.c(parama.fQl, parama1.username);
        if (!x.zW(parama1.username)) {
          break label137;
        }
        n.a(((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.a.class)).a(paramContext, parama1.tMI), parama.iYj);
      }
      for (;;)
      {
        parama.iYj.setMaxWidth(com.tencent.mm.cb.a.fromDPToPix(paramContext, 200));
        n.a(parama1.ofF, parama.iFO);
        AppMethodBeat.o(112114);
        return;
        parama.fQl.setImageResource(2131231875);
        break;
        label137:
        n.a(parama1.tMI, parama.iYj);
      }
    }
    
    public final boolean a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
    {
      AppMethodBeat.i(112115);
      paramVarArgs = (q)paramVarArgs;
      a(q.this.tFe.tFC, paramVarArgs.kno);
      Intent localIntent = new Intent().putExtra("Chat_User", paramVarArgs.username).putExtra("finish_direct", true);
      if (x.zV(paramVarArgs.username))
      {
        do localdo = new do();
        localdo.nl(paramVarArgs.username);
        localdo.dWm = 3L;
        localdo.aLH();
      }
      com.tencent.mm.br.d.f(paramContext, ".ui.chatting.ChattingUI", localIntent);
      ((b)com.tencent.mm.kernel.g.ab(b.class)).cQ(paramVarArgs.username, 2);
      AppMethodBeat.o(112115);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.q
 * JD-Core Version:    0.7.0.1
 */