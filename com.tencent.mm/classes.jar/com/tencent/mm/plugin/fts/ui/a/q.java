package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.c.a;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.ui.b.a;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.List;
import java.util.regex.Pattern;

public final class q
  extends a
{
  public ad contact;
  public l hrL;
  public CharSequence jVn;
  public CharSequence jVo;
  public CharSequence mZL;
  private q.b mZM;
  q.a mZN;
  public String username;
  
  public q(int paramInt)
  {
    super(2, paramInt);
    AppMethodBeat.i(62032);
    this.mZM = new q.b(this);
    this.mZN = new q.a(this);
    AppMethodBeat.o(62032);
  }
  
  public final a.b Pr()
  {
    return this.mZM;
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    int i = 1;
    AppMethodBeat.i(62033);
    super.a(paramContext, parama, paramVarArgs);
    this.username = this.hrL.mRV;
    this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(this.username);
    for (;;)
    {
      try
      {
        Object localObject1 = paramContext.getResources();
        paramVarArgs = com.tencent.mm.plugin.fts.a.d.NA(this.contact.field_username);
        switch (this.hrL.mRU)
        {
        case 3: 
          if (i != 0)
          {
            this.jVn = com.tencent.mm.pluginsdk.ui.d.j.d(paramContext, paramVarArgs, b.c.mVV);
            this.jVn = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.d.a(this.jVn, this.mRX, bool1, bool2, b.a.mVP, b.c.mVW)).mSp;
            this.jVo = parama;
            AppMethodBeat.o(62033);
            return;
          }
        case 7: 
          bool1 = true;
          boolean bool3 = true;
          bool2 = bool1;
          bool1 = bool3;
          this.jVo = this.contact.field_nickname;
          parama = null;
          break;
        case 38: 
          Object localObject2 = g.RL().eHS.a("SELECT memberlist FROM chatroom WHERE chatroomname=?;", new String[] { this.contact.field_username }, 2);
          if (((Cursor)localObject2).moveToFirst())
          {
            parama = ((Cursor)localObject2).getString(0);
            if (parama == null)
            {
              parama = null;
              ((Cursor)localObject2).close();
              if ((parama != null) && (parama.length > 0)) {
                this.mZL = ("(" + parama.length + ")");
              }
              if ((parama == null) || (this.hrL.mTg == null)) {
                break label539;
              }
              parama = m.a(paramContext, this.hrL.mTg, parama, this.mRX, b.c.mVY);
              parama = TextUtils.concat(new CharSequence[] { ((Resources)localObject1).getString(2131302990), parama });
              bool2 = false;
              bool1 = false;
              i = 0;
              continue;
            }
            parama = c.a.mQW.split(parama);
            continue;
            this.jVn = com.tencent.mm.pluginsdk.ui.d.j.d(paramContext, paramVarArgs, b.c.mVV);
            paramContext = this.jVn;
            paramVarArgs = this.mZL;
            float f = b.a.mVP;
            localObject1 = b.c.mVW;
            localObject2 = TextUtils.TruncateAt.END;
            this.jVn = TextUtils.concat(new CharSequence[] { TextUtils.ellipsize(paramContext, (TextPaint)localObject1, f - ((TextPaint)localObject1).measureText(paramVarArgs.toString()), (TextUtils.TruncateAt)localObject2), paramVarArgs });
            continue;
          }
          parama = null;
        }
      }
      catch (Exception paramContext)
      {
        if (this.jVn == null) {
          this.jVn = com.tencent.mm.plugin.fts.a.d.NA(this.contact.field_username);
        }
        AppMethodBeat.o(62033);
        return;
      }
      continue;
      boolean bool1 = false;
      continue;
      boolean bool2 = false;
      bool1 = false;
      continue;
      label539:
      bool2 = false;
      bool1 = false;
      i = 0;
      parama = null;
    }
  }
  
  public final int aAp()
  {
    return this.hrL.mTi;
  }
  
  public final int bCh()
  {
    AppMethodBeat.i(62034);
    if (this.hrL.mRU == 38)
    {
      List localList = this.hrL.mTg;
      if ((localList != null) && (localList.size() > 0))
      {
        i = ((com.tencent.mm.plugin.fts.a.a.f)localList.get(0)).mRU;
        AppMethodBeat.o(62034);
        return i;
      }
    }
    int i = super.bCh();
    AppMethodBeat.o(62034);
    return i;
  }
  
  public final boolean bCi()
  {
    return this.hrL.mTj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.q
 * JD-Core Version:    0.7.0.1
 */