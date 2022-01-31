package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.ui.b.a;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.fts.ui.n.g;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.bi.b;

public class m
  extends a
{
  public CharSequence eXK;
  public CharSequence eXL;
  public l fYx;
  public int kDC;
  public CharSequence kDD;
  private m.b kDE = new m.b(this);
  m.a kDF = new m.a(this);
  public String username;
  
  public m(int paramInt)
  {
    super(6, paramInt);
  }
  
  public a.b BD()
  {
    return this.kDE;
  }
  
  public void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    parama = (m.a)parama;
    this.username = this.fYx.kwg;
    this.eXK = com.tencent.mm.pluginsdk.ui.d.j.b(paramContext, com.tencent.mm.plugin.fts.a.d.Cy(this.username), parama.doV.getTextSize());
    if ((this.fYx.userData instanceof Integer)) {
      this.kDC = ((Integer)this.fYx.userData).intValue();
    }
    String str;
    label278:
    Object localObject;
    if (this.kDC < 2)
    {
      str = "";
      parama = "";
      paramVarArgs = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().fd(this.fYx.kxk);
      switch (this.fYx.kwf)
      {
      default: 
        paramVarArgs = str;
      case 41: 
        for (;;)
        {
          this.eXL = com.tencent.mm.pluginsdk.ui.d.j.b(paramContext, bk.aM(parama, "").replace('\n', ' '), b.c.kAf);
          if (bk.L(paramVarArgs)) {
            break;
          }
          float f1 = b.a.kzX;
          float f2 = b.c.kAg.measureText(paramVarArgs.toString());
          this.eXL = f.a(com.tencent.mm.plugin.fts.a.a.d.a(this.eXL, this.kwi, f1 - f2, b.c.kAg)).kwz;
          this.eXL = TextUtils.concat(new CharSequence[] { paramVarArgs, this.eXL });
          this.kDD = h.c(paramContext, this.fYx.timestamp, true);
          return;
          localObject = paramVarArgs.field_content;
          parama = (a.a)localObject;
          paramVarArgs = str;
          if (s.gZ(this.username))
          {
            parama = bd.iJ((String)localObject);
            paramVarArgs = str;
          }
        }
      case 42: 
        parama = g.a.gp(paramVarArgs.field_content);
        if (parama == null) {
          break;
        }
      }
    }
    for (parama = parama.title;; parama = "")
    {
      paramVarArgs = paramContext.getString(n.g.fts_message_file_tag);
      break;
      paramVarArgs = g.a.gp(paramVarArgs.field_content);
      if (paramVarArgs != null) {
        parama = paramVarArgs.title;
      }
      paramVarArgs = paramContext.getString(n.g.fts_message_link_tag);
      break;
      paramVarArgs = g.a.gp(paramVarArgs.field_content);
      if (paramVarArgs != null) {
        parama = paramVarArgs.title;
      }
      paramVarArgs = paramContext.getString(n.g.fts_message_appbrand_tag);
      break;
      paramVarArgs = g.a.gp(paramVarArgs.field_content);
      if (paramVarArgs != null) {
        parama = paramVarArgs.description;
      }
      paramVarArgs = paramContext.getString(n.g.fts_message_note_tag);
      break;
      localObject = g.a.gp(paramVarArgs.field_content);
      paramVarArgs = str;
      if (localObject == null) {
        break;
      }
      paramVarArgs = ((g.a)localObject).title + ": ";
      parama = ((g.a)localObject).description;
      break;
      localObject = g.a.gp(paramVarArgs.field_content);
      paramVarArgs = str;
      if (localObject == null) {
        break;
      }
      parama = bk.aM(((g.a)localObject).title, "") + ": " + bk.aM(((g.a)localObject).description, "");
      paramVarArgs = str;
      break;
      parama = g.a.gp(paramVarArgs.field_content);
      if (paramVarArgs.field_isSend == 1)
      {
        parama = bk.aM(parama.dSf, "") + ": " + bk.aM(parama.dSc, "");
        paramVarArgs = str;
        break;
      }
      parama = bk.aM(parama.dSf, "") + ": " + bk.aM(parama.dSb, "");
      paramVarArgs = str;
      break;
      parama = paramVarArgs.field_content;
      if (s.fn(this.username)) {
        parama = bd.iJ(parama);
      }
      for (;;)
      {
        paramVarArgs = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().HO(parama);
        if (paramVarArgs.cvN()) {
          parama = paramVarArgs.lFn;
        }
        paramVarArgs = paramContext.getString(n.g.fts_message_location_tag);
        break;
        this.eXL = f.a(com.tencent.mm.plugin.fts.a.a.d.a(this.eXL, this.kwi, b.a.kzX, b.c.kAg)).kwz;
        break label278;
        this.eXL = paramContext.getResources().getString(n.g.search_message_count, new Object[] { Integer.valueOf(this.kDC) });
        return;
      }
    }
  }
  
  public int aVH()
  {
    if (this.kDC < 2) {
      return 0;
    }
    return 1;
  }
  
  protected final a.a afK()
  {
    return this.kDF;
  }
  
  public final int afM()
  {
    return this.fYx.kxt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.m
 * JD-Core Version:    0.7.0.1
 */