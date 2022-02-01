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
import com.tencent.mm.g.b.a.ct;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.fts.a.c.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.ui.b.a;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import java.util.List;
import java.util.regex.Pattern;

public final class q
  extends com.tencent.mm.plugin.fts.a.d.a.a
{
  public ai contact;
  public com.tencent.mm.plugin.fts.a.a.m jPN;
  public CharSequence nyx;
  public CharSequence sEZ;
  public CharSequence sFa;
  private b sFb;
  a sFc;
  public String username;
  
  public q(int paramInt)
  {
    super(2, paramInt);
    AppMethodBeat.i(112116);
    this.sFb = new b();
    this.sFc = new a();
    AppMethodBeat.o(112116);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    int i = 1;
    AppMethodBeat.i(112117);
    super.a(paramContext, parama, paramVarArgs);
    this.username = this.jPN.sxG;
    this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(this.username);
    boolean bool1;
    boolean bool2;
    for (;;)
    {
      try
      {
        paramVarArgs = paramContext.getResources();
        this.sEZ = com.tencent.mm.pluginsdk.ui.span.k.d(paramContext, com.tencent.mm.plugin.fts.a.d.acr(this.contact.field_username), b.c.sBE);
        switch (this.jPN.sxF)
        {
        case 3: 
          if (i != 0) {
            this.sEZ = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.e.a(this.sEZ, this.sxM, bool1, bool2, b.a.sBy, b.c.sBF)).syd;
          }
          this.nyx = paramContext;
          AppMethodBeat.o(112117);
          return;
        }
      }
      catch (Exception paramContext)
      {
        label203:
        boolean bool3;
        label214:
        ac.printErrStackTrace("MicroMsg.FTS.FTSWXChatroomDataItem", paramContext, "format text exception", new Object[0]);
        if (this.sEZ != null) {
          continue;
        }
        this.sEZ = com.tencent.mm.plugin.fts.a.d.acr(this.contact.field_username);
        AppMethodBeat.o(112117);
        return;
      }
      bool1 = true;
      bool3 = true;
      bool2 = bool1;
      bool1 = bool3;
      if (bs.isNullOrNil(this.contact.field_nickname)) {
        break label626;
      }
      paramContext = TextUtils.concat(new CharSequence[] { paramContext.getString(2131762933), com.tencent.mm.pluginsdk.ui.span.k.c(paramContext, this.contact.aaR()) });
    }
    for (;;)
    {
      if (bs.isNullOrNil(this.contact.field_conRemark))
      {
        paramContext = null;
        break;
      }
      paramContext = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.e.a(TextUtils.concat(new CharSequence[] { paramContext.getString(2131762933), com.tencent.mm.pluginsdk.ui.span.k.c(paramContext, this.contact.aaR()) }), this.sxM, bool1, bool2, b.a.sBy, b.c.sBF)).syd;
      i = 0;
      break;
      Object localObject = com.tencent.mm.kernel.g.agR().ghG.a("SELECT memberlist FROM chatroom WHERE chatroomname=?;", new String[] { this.contact.field_username }, 2);
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
          this.sFa = ("(" + parama.length + ")");
        }
        if ((parama == null) || (this.jPN.syU == null)) {
          break label661;
        }
        paramContext = com.tencent.mm.plugin.fts.ui.m.a(paramContext, this.jPN.syU, parama, this.sxM, b.c.sBH);
        paramContext = TextUtils.concat(new CharSequence[] { paramVarArgs.getString(2131762928), paramContext });
        parama = this.sEZ;
        paramVarArgs = this.sFa;
        float f = b.a.sBy;
        localObject = b.c.sBF;
        TextUtils.TruncateAt localTruncateAt = TextUtils.TruncateAt.END;
        this.sEZ = TextUtils.concat(new CharSequence[] { TextUtils.ellipsize(parama, (TextPaint)localObject, f - ((TextPaint)localObject).measureText(paramVarArgs.toString()), localTruncateAt), paramVarArgs });
        bool2 = false;
        bool1 = false;
        i = 0;
        break;
        parama = c.a.swH.split(parama);
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
  
  public final com.tencent.mm.plugin.fts.a.d.a.a.b adW()
  {
    return this.sFb;
  }
  
  public final int bds()
  {
    return this.jPN.syW;
  }
  
  public final int cKH()
  {
    AppMethodBeat.i(112118);
    if (this.jPN.sxF == 38)
    {
      List localList = this.jPN.syU;
      if ((localList != null) && (localList.size() > 0))
      {
        i = ((com.tencent.mm.plugin.fts.a.a.g)localList.get(0)).sxF;
        AppMethodBeat.o(112118);
        return i;
      }
    }
    int i = super.cKH();
    AppMethodBeat.o(112118);
    return i;
  }
  
  public final boolean cKI()
  {
    return this.jPN.syX;
  }
  
  public final class a
    extends a.a
  {
    public ImageView fuY;
    public TextView iCg;
    public TextView ijE;
    public View jPT;
    
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
      paramViewGroup = (q.a)q.this.sFc;
      paramViewGroup.fuY = ((ImageView)paramContext.findViewById(2131297008));
      paramViewGroup.iCg = ((TextView)paramContext.findViewById(2131305948));
      paramViewGroup.ijE = ((TextView)paramContext.findViewById(2131299008));
      paramViewGroup.jPT = paramContext.findViewById(2131299154);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(112113);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, com.tencent.mm.plugin.fts.a.d.a.a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112114);
      parama = (q.a)parama;
      parama1 = (q)parama1;
      com.tencent.mm.plugin.fts.ui.m.p(parama.jPT, q.this.szt);
      if ((parama1.username != null) && (parama1.username.length() > 0))
      {
        com.tencent.mm.pluginsdk.ui.a.b.c(parama.fuY, parama1.username);
        if (!w.wr(parama1.username)) {
          break label137;
        }
        com.tencent.mm.plugin.fts.ui.m.a(((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).a(paramContext, parama1.sEZ), parama.iCg);
      }
      for (;;)
      {
        parama.iCg.setMaxWidth(com.tencent.mm.cc.a.fromDPToPix(paramContext, 200));
        com.tencent.mm.plugin.fts.ui.m.a(parama1.nyx, parama.ijE);
        AppMethodBeat.o(112114);
        return;
        parama.fuY.setImageResource(2131231875);
        break;
        label137:
        com.tencent.mm.plugin.fts.ui.m.a(parama1.sEZ, parama.iCg);
      }
    }
    
    public final boolean a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
    {
      AppMethodBeat.i(112115);
      paramVarArgs = (q)paramVarArgs;
      a(q.this.sxM.syk, paramVarArgs.jPN);
      Intent localIntent = new Intent().putExtra("Chat_User", paramVarArgs.username).putExtra("finish_direct", true);
      if (w.wq(paramVarArgs.username))
      {
        ct localct = new ct();
        localct.kP(paramVarArgs.username);
        localct.dHR = 3L;
        localct.aHZ();
      }
      com.tencent.mm.br.d.e(paramContext, ".ui.chatting.ChattingUI", localIntent);
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).cJ(paramVarArgs.username, 2);
      AppMethodBeat.o(112115);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.q
 * JD-Core Version:    0.7.0.1
 */