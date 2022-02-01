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
import com.tencent.mm.g.b.a.dm;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.c.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.ui.b.a;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import java.util.List;
import java.util.regex.Pattern;

public final class q
  extends com.tencent.mm.plugin.fts.a.d.a.a
{
  public am contact;
  public m kjY;
  public CharSequence nZV;
  public CharSequence tBR;
  public CharSequence tBS;
  private b tBT;
  a tBU;
  public String username;
  
  public q(int paramInt)
  {
    super(2, paramInt);
    AppMethodBeat.i(112116);
    this.tBT = new b();
    this.tBU = new a();
    AppMethodBeat.o(112116);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    int i = 1;
    AppMethodBeat.i(112117);
    super.a(paramContext, parama, paramVarArgs);
    this.username = this.kjY.tuh;
    this.contact = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(this.username);
    boolean bool1;
    boolean bool2;
    for (;;)
    {
      try
      {
        paramVarArgs = paramContext.getResources();
        this.tBR = k.d(paramContext, com.tencent.mm.plugin.fts.a.d.agg(this.contact.field_username), b.c.tyf);
        switch (this.kjY.tug)
        {
        case 3: 
          if (i != 0) {
            this.tBR = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.e.a(this.tBR, this.tun, bool1, bool2, b.a.txZ, b.c.tyg)).tuE;
          }
          this.nZV = paramContext;
          AppMethodBeat.o(112117);
          return;
        }
      }
      catch (Exception paramContext)
      {
        label203:
        boolean bool3;
        label214:
        ad.printErrStackTrace("MicroMsg.FTS.FTSWXChatroomDataItem", paramContext, "format text exception", new Object[0]);
        if (this.tBR != null) {
          continue;
        }
        this.tBR = com.tencent.mm.plugin.fts.a.d.agg(this.contact.field_username);
        AppMethodBeat.o(112117);
        return;
      }
      bool1 = true;
      bool3 = true;
      bool2 = bool1;
      bool1 = bool3;
      if (bt.isNullOrNil(this.contact.field_nickname)) {
        break label626;
      }
      paramContext = TextUtils.concat(new CharSequence[] { paramContext.getString(2131762933), k.c(paramContext, this.contact.adu()) });
    }
    for (;;)
    {
      if (bt.isNullOrNil(this.contact.field_conRemark))
      {
        paramContext = null;
        break;
      }
      paramContext = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.e.a(TextUtils.concat(new CharSequence[] { paramContext.getString(2131762933), k.c(paramContext, this.contact.adu()) }), this.tun, bool1, bool2, b.a.txZ, b.c.tyg)).tuE;
      i = 0;
      break;
      Object localObject = com.tencent.mm.kernel.g.ajC().gBq.a("SELECT memberlist FROM chatroom WHERE chatroomname=?;", new String[] { this.contact.field_username }, 2);
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
          this.tBS = ("(" + parama.length + ")");
        }
        if ((parama == null) || (this.kjY.tvv == null)) {
          break label661;
        }
        paramContext = n.a(paramContext, this.kjY.tvv, parama, this.tun, b.c.tyi);
        paramContext = TextUtils.concat(new CharSequence[] { paramVarArgs.getString(2131762928), paramContext });
        parama = this.tBR;
        paramVarArgs = this.tBS;
        float f = b.a.txZ;
        localObject = b.c.tyg;
        TextUtils.TruncateAt localTruncateAt = TextUtils.TruncateAt.END;
        this.tBR = TextUtils.concat(new CharSequence[] { TextUtils.ellipsize(parama, (TextPaint)localObject, f - ((TextPaint)localObject).measureText(paramVarArgs.toString()), localTruncateAt), paramVarArgs });
        bool2 = false;
        bool1 = false;
        i = 0;
        break;
        parama = c.a.tti.split(parama);
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
  
  public final com.tencent.mm.plugin.fts.a.d.a.a.b agC()
  {
    return this.tBT;
  }
  
  public final int bgW()
  {
    return this.kjY.tvx;
  }
  
  public final int cSW()
  {
    AppMethodBeat.i(112118);
    if (this.kjY.tug == 38)
    {
      List localList = this.kjY.tvv;
      if ((localList != null) && (localList.size() > 0))
      {
        i = ((com.tencent.mm.plugin.fts.a.a.g)localList.get(0)).tug;
        AppMethodBeat.o(112118);
        return i;
      }
    }
    int i = super.cSW();
    AppMethodBeat.o(112118);
    return i;
  }
  
  public final boolean cSX()
  {
    return this.kjY.tvy;
  }
  
  public final class a
    extends a.a
  {
    public ImageView fOf;
    public TextView iCV;
    public TextView iVq;
    public View kke;
    
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
      paramViewGroup = (q.a)q.this.tBU;
      paramViewGroup.fOf = ((ImageView)paramContext.findViewById(2131297008));
      paramViewGroup.iVq = ((TextView)paramContext.findViewById(2131305948));
      paramViewGroup.iCV = ((TextView)paramContext.findViewById(2131299008));
      paramViewGroup.kke = paramContext.findViewById(2131299154);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(112113);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, com.tencent.mm.plugin.fts.a.d.a.a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112114);
      parama = (q.a)parama;
      parama1 = (q)parama1;
      n.p(parama.kke, q.this.tvU);
      if ((parama1.username != null) && (parama1.username.length() > 0))
      {
        com.tencent.mm.pluginsdk.ui.a.b.c(parama.fOf, parama1.username);
        if (!w.zm(parama1.username)) {
          break label137;
        }
        n.a(((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).a(paramContext, parama1.tBR), parama.iVq);
      }
      for (;;)
      {
        parama.iVq.setMaxWidth(com.tencent.mm.cc.a.fromDPToPix(paramContext, 200));
        n.a(parama1.nZV, parama.iCV);
        AppMethodBeat.o(112114);
        return;
        parama.fOf.setImageResource(2131231875);
        break;
        label137:
        n.a(parama1.tBR, parama.iVq);
      }
    }
    
    public final boolean a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
    {
      AppMethodBeat.i(112115);
      paramVarArgs = (q)paramVarArgs;
      a(q.this.tun.tuL, paramVarArgs.kjY);
      Intent localIntent = new Intent().putExtra("Chat_User", paramVarArgs.username).putExtra("finish_direct", true);
      if (w.zl(paramVarArgs.username))
      {
        dm localdm = new dm();
        localdm.mS(paramVarArgs.username);
        localdm.dUW = 3L;
        localdm.aLk();
      }
      com.tencent.mm.bs.d.f(paramContext, ".ui.chatting.ChattingUI", localIntent);
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).cM(paramVarArgs.username, 2);
      AppMethodBeat.o(112115);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.q
 * JD-Core Version:    0.7.0.1
 */