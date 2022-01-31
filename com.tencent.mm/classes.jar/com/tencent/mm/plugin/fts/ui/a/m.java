package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.ui.b.a;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi.b;

public class m
  extends a
{
  public CharSequence gpH;
  public CharSequence gpI;
  public l hrL;
  private m.b mZA;
  a mZB;
  public int mZy;
  public CharSequence mZz;
  public String username;
  
  public m(int paramInt)
  {
    super(6, paramInt);
    AppMethodBeat.i(62016);
    this.mZA = new m.b(this);
    this.mZB = new a();
    AppMethodBeat.o(62016);
  }
  
  public a.b Pr()
  {
    return this.mZA;
  }
  
  public void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(62017);
    super.a(paramContext, parama, paramVarArgs);
    parama = (a)parama;
    this.username = this.hrL.mRV;
    this.gpH = com.tencent.mm.pluginsdk.ui.d.j.d(paramContext, com.tencent.mm.plugin.fts.a.d.NA(this.username), parama.egr.getTextSize());
    if ((this.hrL.userData instanceof Integer)) {
      this.mZy = ((Integer)this.hrL.userData).intValue();
    }
    Object localObject1;
    label290:
    Object localObject2;
    if (this.mZy < 2)
    {
      localObject1 = "";
      parama = "";
      paramVarArgs = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().kB(this.hrL.mSZ);
      switch (this.hrL.mRU)
      {
      default: 
        paramVarArgs = (Object[])localObject1;
      case 41: 
        for (;;)
        {
          this.gpI = com.tencent.mm.pluginsdk.ui.d.j.d(paramContext, bo.bf(parama, "").replace('\n', ' '), b.c.mVX);
          if (bo.aa(paramVarArgs)) {
            break;
          }
          float f1 = b.a.mVP;
          float f2 = b.c.mVY.measureText(paramVarArgs.toString());
          this.gpI = f.a(com.tencent.mm.plugin.fts.a.a.d.a(this.gpI, this.mRX, f1 - f2, b.c.mVY)).mSp;
          this.gpI = TextUtils.concat(new CharSequence[] { paramVarArgs, this.gpI });
          this.mZz = com.tencent.mm.pluginsdk.f.h.c(paramContext, this.hrL.timestamp, true);
          AppMethodBeat.o(62017);
          return;
          localObject2 = paramVarArgs.field_content;
          parama = (a.a)localObject2;
          paramVarArgs = (Object[])localObject1;
          if (t.nI(this.username))
          {
            parama = bf.pv((String)localObject2);
            paramVarArgs = (Object[])localObject1;
          }
        }
      case 42: 
        parama = j.b.mY(paramVarArgs.field_content);
        if (parama == null) {
          break;
        }
      }
    }
    for (parama = parama.title;; parama = "")
    {
      paramVarArgs = paramContext.getString(2131300229);
      break;
      paramVarArgs = j.b.mY(paramVarArgs.field_content);
      if (paramVarArgs != null) {
        parama = paramVarArgs.title;
      }
      paramVarArgs = paramContext.getString(2131300230);
      break;
      paramVarArgs = j.b.mY(paramVarArgs.field_content);
      if (paramVarArgs != null) {
        parama = paramVarArgs.title;
      }
      paramVarArgs = paramContext.getString(2131300228);
      break;
      paramVarArgs = j.b.mY(paramVarArgs.field_content);
      if (paramVarArgs != null) {
        parama = paramVarArgs.description;
      }
      paramVarArgs = paramContext.getString(2131300232);
      break;
      localObject2 = j.b.mY(paramVarArgs.field_content);
      paramVarArgs = (Object[])localObject1;
      if (localObject2 == null) {
        break;
      }
      paramVarArgs = ((j.b)localObject2).title + ": ";
      parama = ((j.b)localObject2).description;
      break;
      localObject2 = j.b.mY(paramVarArgs.field_content);
      paramVarArgs = (Object[])localObject1;
      if (localObject2 == null) {
        break;
      }
      parama = bo.bf(((j.b)localObject2).title, "") + ": " + bo.bf(((j.b)localObject2).description, "");
      paramVarArgs = (Object[])localObject1;
      break;
      parama = j.b.mY(paramVarArgs.field_content);
      if (parama != null)
      {
        if (paramVarArgs.field_isSend == 1)
        {
          parama = bo.bf(parama.fie, "") + ": " + bo.bf(parama.fib, "");
          paramVarArgs = (Object[])localObject1;
          break;
        }
        parama = bo.bf(parama.fie, "") + ": " + bo.bf(parama.fia, "");
        paramVarArgs = (Object[])localObject1;
        break;
      }
      parama = "";
      paramVarArgs = (Object[])localObject1;
      break;
      paramVarArgs = paramVarArgs.field_content;
      if (t.lA(this.username)) {
        paramVarArgs = bf.pv(paramVarArgs);
      }
      for (;;)
      {
        parama = paramVarArgs;
        if (!bo.isNullOrNil(paramVarArgs))
        {
          localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().Tz(paramVarArgs);
          parama = paramVarArgs;
          if (((bi.b)localObject1).dyv()) {
            parama = ((bi.b)localObject1).eSM;
          }
        }
        paramVarArgs = paramContext.getString(2131300231);
        break;
        this.gpI = f.a(com.tencent.mm.plugin.fts.a.a.d.a(this.gpI, this.mRX, b.a.mVP, b.c.mVY)).mSp;
        break label290;
        this.gpI = paramContext.getResources().getString(2131303014, new Object[] { Integer.valueOf(this.mZy) });
        AppMethodBeat.o(62017);
        return;
      }
    }
  }
  
  public final int aAp()
  {
    return this.hrL.mTi;
  }
  
  public int bCj()
  {
    if (this.mZy < 2) {
      return 0;
    }
    return 1;
  }
  
  public final class a
    extends a.a
  {
    public ImageView egq;
    public TextView egr;
    public TextView ekg;
    public TextView ekh;
    public View hrR;
    
    public a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.m
 * JD-Core Version:    0.7.0.1
 */