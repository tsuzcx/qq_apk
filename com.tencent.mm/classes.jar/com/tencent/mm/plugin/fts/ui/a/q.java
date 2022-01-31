package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import com.tencent.mm.cf.h;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.c.a;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.ui.b.a;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.plugin.fts.ui.n.g;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.List;
import java.util.regex.Pattern;

public final class q
  extends a
{
  public ad dnp;
  public l fYx;
  public CharSequence ieA;
  public CharSequence ieB;
  public CharSequence kDP;
  private q.b kDQ = new q.b(this);
  q.a kDR = new q.a(this);
  public String username;
  
  public q(int paramInt)
  {
    super(2, paramInt);
  }
  
  public final a.b BD()
  {
    return this.kDQ;
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    this.username = this.fYx.kwg;
    this.dnp = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(this.username);
    Object localObject1 = paramContext.getResources();
    paramVarArgs = com.tencent.mm.plugin.fts.a.d.Cy(this.dnp.field_username);
    boolean bool2;
    int i;
    switch (this.fYx.kwf)
    {
    default: 
      bool2 = false;
      bool1 = false;
      i = 0;
      parama = null;
      if (i != 0)
      {
        this.ieA = com.tencent.mm.pluginsdk.ui.d.j.b(paramContext, paramVarArgs, b.c.kAd);
        this.ieA = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.d.a(this.ieA, this.kwi, bool1, bool2, b.a.kzX, b.c.kAe)).kwz;
        this.ieB = parama;
        return;
      }
      break;
    case 3: 
    case 7: 
      label139:
      label189:
      bool2 = true;
    }
    label198:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.ieB = this.dnp.field_nickname;
      i = 1;
      parama = null;
      break label139;
      Object localObject2 = g.DP().dKu.a("SELECT memberlist FROM chatroom WHERE chatroomname=?;", new String[] { this.dnp.field_username }, 2);
      if (((Cursor)localObject2).moveToFirst())
      {
        parama = ((Cursor)localObject2).getString(0);
        if (parama == null) {
          parama = null;
        }
      }
      for (;;)
      {
        ((Cursor)localObject2).close();
        if ((parama != null) && (parama.length > 0)) {
          this.kDP = ("(" + parama.length + ")");
        }
        if ((parama == null) || (this.fYx.kxr == null)) {
          break;
        }
        parama = m.a(paramContext, this.fYx.kxr, parama, this.kwi, b.c.kAg);
        parama = TextUtils.concat(new CharSequence[] { ((Resources)localObject1).getString(n.g.search_contact_tag_member), parama });
        bool2 = false;
        bool1 = false;
        i = 0;
        break label139;
        parama = c.a.kvj.split(parama);
        continue;
        this.ieA = com.tencent.mm.pluginsdk.ui.d.j.b(paramContext, paramVarArgs, b.c.kAd);
        paramContext = this.ieA;
        paramVarArgs = this.kDP;
        float f = b.a.kzX;
        localObject1 = b.c.kAe;
        localObject2 = TextUtils.TruncateAt.END;
        this.ieA = TextUtils.concat(new CharSequence[] { TextUtils.ellipsize(paramContext, (TextPaint)localObject1, f - ((TextPaint)localObject1).measureText(paramVarArgs.toString()), (TextUtils.TruncateAt)localObject2), paramVarArgs });
        break label189;
        parama = null;
      }
      bool2 = false;
      break label198;
      bool2 = false;
    }
  }
  
  public final int aVF()
  {
    if (this.fYx.kwf == 38)
    {
      List localList = this.fYx.kxr;
      if ((localList != null) && (localList.size() > 0)) {
        return ((com.tencent.mm.plugin.fts.a.a.f)localList.get(0)).kwf;
      }
    }
    return super.aVF();
  }
  
  public final boolean aVG()
  {
    return this.fYx.kxu;
  }
  
  protected final a.a afK()
  {
    return this.kDR;
  }
  
  public final int afM()
  {
    return this.fYx.kxt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.q
 * JD-Core Version:    0.7.0.1
 */