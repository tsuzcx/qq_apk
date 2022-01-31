package com.tencent.mm.plugin.brandservice.ui.a;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.Iterator;
import java.util.List;

public final class a
  extends com.tencent.mm.plugin.fts.a.d.a.a
{
  public ad contact;
  public l hrL;
  public String iconUrl;
  public CharSequence jVn;
  public CharSequence jVo;
  private a.b jVp;
  a.a jVq;
  public String username;
  
  public a(int paramInt)
  {
    super(4, paramInt);
    AppMethodBeat.i(14084);
    this.jVp = new a.b(this);
    this.jVq = new a.a(this);
    AppMethodBeat.o(14084);
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a.b Pr()
  {
    return this.jVp;
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(14085);
    super.a(paramContext, parama, paramVarArgs);
    this.username = this.hrL.mRV;
    this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(this.username);
    Object localObject = com.tencent.mm.aj.f.rS(this.username);
    label67:
    String str;
    int k;
    int j;
    boolean bool4;
    boolean bool3;
    boolean bool5;
    boolean bool6;
    if (localObject == null)
    {
      parama = "";
      this.iconUrl = parama;
      str = s.nE(this.username);
      paramVarArgs = null;
      parama = null;
      k = 0;
      j = 0;
      bool4 = false;
      bool3 = false;
      bool5 = false;
      bool1 = false;
      bool2 = false;
      bool6 = false;
      if ((localObject != null) && (!((com.tencent.mm.aj.d)localObject).aem())) {
        break label344;
      }
    }
    label344:
    for (int i = 1;; i = 0) {
      switch (this.hrL.mRU)
      {
      default: 
        bool1 = bool5;
        bool2 = bool6;
        if (k == 0) {
          break label572;
        }
        this.jVn = com.tencent.mm.pluginsdk.ui.d.j.d(paramContext, str, com.tencent.mm.cb.a.ao(paramContext, 2131427809));
        this.jVn = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.d.a(this.jVn, this.mRX, bool1, bool2)).mSp;
        label255:
        if ((j != 0) && (i != 0))
        {
          this.jVo = com.tencent.mm.pluginsdk.ui.d.j.d(paramContext, paramVarArgs, com.tencent.mm.cb.a.ao(paramContext, 2131427809));
          this.jVo = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.d.a(this.jVo, this.mRX, bool1, bool2)).mSp;
          this.jVo = TextUtils.concat(new CharSequence[] { parama, this.jVo });
        }
        AppMethodBeat.o(14085);
        return;
        parama = ((com.tencent.mm.aj.d)localObject).field_brandIconURL;
        break label67;
      }
    }
    boolean bool2 = true;
    label353:
    for (boolean bool1 = true;; bool1 = bool4)
    {
      k = 1;
      break;
      j = 1;
      paramVarArgs = this.contact.Hq();
      parama = paramVarArgs;
      if (bo.isNullOrNil(paramVarArgs)) {
        parama = this.contact.field_username;
      }
      localObject = paramContext.getString(2131302996);
      paramVarArgs = parama;
      bool2 = bool6;
      bool1 = bool5;
      parama = (com.tencent.mm.plugin.fts.a.d.a.a.a)localObject;
      break;
      bool1 = true;
      bool3 = true;
      bool2 = bool1;
      localObject = ((com.tencent.mm.api.j)g.E(com.tencent.mm.api.j.class)).dl(this.username).iterator();
      while (((Iterator)localObject).hasNext())
      {
        this.jVo = com.tencent.mm.pluginsdk.ui.d.j.d(paramContext, (String)((Iterator)localObject).next(), com.tencent.mm.cb.a.ao(paramContext, 2131427809));
        e locale = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.d.a(this.jVo, this.mRX, bool3, bool2));
        if (locale.bpE == 0) {
          this.jVo = locale.mSp;
        }
      }
      this.jVo = TextUtils.concat(new CharSequence[] { this.jVo, paramContext.getString(2131302964) + str });
      bool1 = bool3;
      break;
      this.jVn = com.tencent.mm.pluginsdk.ui.d.j.d(paramContext, str, com.tencent.mm.cb.a.ao(paramContext, 2131427809));
      break label255;
      bool2 = false;
      break label353;
      bool2 = false;
    }
  }
  
  public final String aAo()
  {
    AppMethodBeat.i(14086);
    if (this.jVn != null)
    {
      String str = this.jVn.toString();
      AppMethodBeat.o(14086);
      return str;
    }
    AppMethodBeat.o(14086);
    return "";
  }
  
  public final int aAp()
  {
    return this.hrL.mTi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.a.a
 * JD-Core Version:    0.7.0.1
 */