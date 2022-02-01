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
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.fts.a.c.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.ui.b.a;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import java.util.List;
import java.util.regex.Pattern;

public final class q
  extends com.tencent.mm.plugin.fts.a.d.a.a
{
  public af contact;
  public com.tencent.mm.plugin.fts.a.a.m jpy;
  public CharSequence mVY;
  public CharSequence rwh;
  public CharSequence rwi;
  private b rwj;
  a rwk;
  public String username;
  
  public q(int paramInt)
  {
    super(2, paramInt);
    AppMethodBeat.i(112116);
    this.rwj = new b();
    this.rwk = new a();
    AppMethodBeat.o(112116);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    int i = 1;
    AppMethodBeat.i(112117);
    super.a(paramContext, parama, paramVarArgs);
    this.username = this.jpy.roN;
    this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(this.username);
    boolean bool1;
    boolean bool2;
    for (;;)
    {
      try
      {
        paramVarArgs = paramContext.getResources();
        this.rwh = com.tencent.mm.pluginsdk.ui.span.k.d(paramContext, com.tencent.mm.plugin.fts.a.d.XV(this.contact.field_username), b.c.rsK);
        switch (this.jpy.roM)
        {
        case 3: 
          if (i != 0) {
            this.rwh = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.e.a(this.rwh, this.roS, bool1, bool2, b.a.rsE, b.c.rsL)).rpj;
          }
          this.mVY = paramContext;
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
        if (this.rwh != null) {
          continue;
        }
        this.rwh = com.tencent.mm.plugin.fts.a.d.XV(this.contact.field_username);
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
      paramContext = TextUtils.concat(new CharSequence[] { paramContext.getString(2131762933), com.tencent.mm.pluginsdk.ui.span.k.c(paramContext, this.contact.ZW()) });
    }
    for (;;)
    {
      if (bt.isNullOrNil(this.contact.field_conRemark))
      {
        paramContext = null;
        break;
      }
      paramContext = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.e.a(TextUtils.concat(new CharSequence[] { paramContext.getString(2131762933), com.tencent.mm.pluginsdk.ui.span.k.c(paramContext, this.contact.ZW()) }), this.roS, bool1, bool2, b.a.rsE, b.c.rsL)).rpj;
      i = 0;
      break;
      Object localObject = com.tencent.mm.kernel.g.afB().gda.a("SELECT memberlist FROM chatroom WHERE chatroomname=?;", new String[] { this.contact.field_username }, 2);
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
          this.rwi = ("(" + parama.length + ")");
        }
        if ((parama == null) || (this.jpy.rqa == null)) {
          break label661;
        }
        paramContext = com.tencent.mm.plugin.fts.ui.m.a(paramContext, this.jpy.rqa, parama, this.roS, b.c.rsN);
        paramContext = TextUtils.concat(new CharSequence[] { paramVarArgs.getString(2131762928), paramContext });
        parama = this.rwh;
        paramVarArgs = this.rwi;
        float f = b.a.rsE;
        localObject = b.c.rsL;
        TextUtils.TruncateAt localTruncateAt = TextUtils.TruncateAt.END;
        this.rwh = TextUtils.concat(new CharSequence[] { TextUtils.ellipsize(parama, (TextPaint)localObject, f - ((TextPaint)localObject).measureText(paramVarArgs.toString()), localTruncateAt), paramVarArgs });
        bool2 = false;
        bool1 = false;
        i = 0;
        break;
        parama = c.a.rnN.split(parama);
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
  
  public final int aWu()
  {
    return this.jpy.rqc;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a.b acQ()
  {
    return this.rwj;
  }
  
  public final int cxv()
  {
    AppMethodBeat.i(112118);
    if (this.jpy.roM == 38)
    {
      List localList = this.jpy.rqa;
      if ((localList != null) && (localList.size() > 0))
      {
        i = ((com.tencent.mm.plugin.fts.a.a.g)localList.get(0)).roM;
        AppMethodBeat.o(112118);
        return i;
      }
    }
    int i = super.cxv();
    AppMethodBeat.o(112118);
    return i;
  }
  
  public final boolean cxw()
  {
    return this.jpy.rqd;
  }
  
  public final class a
    extends a.a
  {
    public ImageView frr;
    public TextView hJe;
    public TextView ica;
    public View jpE;
    
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
      paramViewGroup = (q.a)q.this.rwk;
      paramViewGroup.frr = ((ImageView)paramContext.findViewById(2131297008));
      paramViewGroup.ica = ((TextView)paramContext.findViewById(2131305948));
      paramViewGroup.hJe = ((TextView)paramContext.findViewById(2131299008));
      paramViewGroup.jpE = paramContext.findViewById(2131299154);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(112113);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, com.tencent.mm.plugin.fts.a.d.a.a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112114);
      parama = (q.a)parama;
      parama1 = (q)parama1;
      com.tencent.mm.plugin.fts.ui.m.p(parama.jpE, q.this.rqz);
      if ((parama1.username != null) && (parama1.username.length() > 0))
      {
        com.tencent.mm.pluginsdk.ui.a.b.c(parama.frr, parama1.username);
        if (!w.so(parama1.username)) {
          break label137;
        }
        com.tencent.mm.plugin.fts.ui.m.a(((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).a(paramContext, parama1.rwh), parama.ica);
      }
      for (;;)
      {
        parama.ica.setMaxWidth(com.tencent.mm.cd.a.fromDPToPix(paramContext, 200));
        com.tencent.mm.plugin.fts.ui.m.a(parama1.mVY, parama.hJe);
        AppMethodBeat.o(112114);
        return;
        parama.frr.setImageResource(2131231875);
        break;
        label137:
        com.tencent.mm.plugin.fts.ui.m.a(parama1.rwh, parama.ica);
      }
    }
    
    public final boolean a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
    {
      AppMethodBeat.i(112115);
      paramVarArgs = (q)paramVarArgs;
      a(q.this.roS.rpq, paramVarArgs.jpy);
      Intent localIntent = new Intent().putExtra("Chat_User", paramVarArgs.username).putExtra("finish_direct", true);
      if (w.sn(paramVarArgs.username))
      {
        com.tencent.mm.g.b.a.bg localbg = new com.tencent.mm.g.b.a.bg();
        localbg.hZ(paramVarArgs.username);
        localbg.dKc = 3L;
        localbg.aBj();
      }
      com.tencent.mm.bs.d.e(paramContext, ".ui.chatting.ChattingUI", localIntent);
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).cE(paramVarArgs.username, 2);
      AppMethodBeat.o(112115);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.q
 * JD-Core Version:    0.7.0.1
 */