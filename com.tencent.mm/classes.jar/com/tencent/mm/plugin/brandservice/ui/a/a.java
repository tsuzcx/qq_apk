package com.tencent.mm.plugin.brandservice.ui.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.api.i;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.brandservice.b.b;
import com.tencent.mm.plugin.brandservice.b.h;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.Iterator;
import java.util.List;

public final class a
  extends com.tencent.mm.plugin.fts.a.d.a.a
{
  public ad dnp;
  public l fYx;
  public String iconUrl;
  public CharSequence ieA;
  public CharSequence ieB;
  private a.b ieC = new a.b(this);
  a ieD = new a();
  public String username;
  
  public a(int paramInt)
  {
    super(4, paramInt);
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a.b BD()
  {
    return this.ieC;
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a.a parama, Object... paramVarArgs)
  {
    this.username = this.fYx.kwg;
    this.dnp = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(this.username);
    Object localObject = com.tencent.mm.ai.f.kX(this.username);
    label54:
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
      str = r.gV(this.username);
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
      if ((localObject != null) && (!((com.tencent.mm.ai.d)localObject).LE())) {
        break label324;
      }
    }
    label324:
    for (int i = 1;; i = 0) {
      switch (this.fYx.kwf)
      {
      default: 
        bool1 = bool5;
        bool2 = bool6;
        if (k == 0) {
          break label555;
        }
        this.ieA = com.tencent.mm.pluginsdk.ui.d.j.b(paramContext, str, com.tencent.mm.cb.a.aa(paramContext, b.b.NormalTextSize));
        this.ieA = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.d.a(this.ieA, this.kwi, bool1, bool2)).kwz;
        label240:
        if ((j != 0) && (i != 0))
        {
          this.ieB = com.tencent.mm.pluginsdk.ui.d.j.b(paramContext, paramVarArgs, com.tencent.mm.cb.a.aa(paramContext, b.b.NormalTextSize));
          this.ieB = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.d.a(this.ieB, this.kwi, bool1, bool2)).kwz;
          this.ieB = TextUtils.concat(new CharSequence[] { parama, this.ieB });
        }
        return;
        parama = ((com.tencent.mm.ai.d)localObject).field_brandIconURL;
        break label54;
      }
    }
    boolean bool2 = true;
    label333:
    for (boolean bool1 = true;; bool1 = bool4)
    {
      k = 1;
      break;
      j = 1;
      paramVarArgs = this.dnp.vk();
      parama = paramVarArgs;
      if (bk.bl(paramVarArgs)) {
        parama = this.dnp.field_username;
      }
      localObject = paramContext.getString(b.h.search_contact_tag_wxid);
      paramVarArgs = parama;
      bool2 = bool6;
      bool1 = bool5;
      parama = (com.tencent.mm.plugin.fts.a.d.a.a.a)localObject;
      break;
      bool1 = true;
      bool3 = true;
      bool2 = bool1;
      localObject = ((i)g.r(i.class)).cb(this.username).iterator();
      while (((Iterator)localObject).hasNext())
      {
        this.ieB = com.tencent.mm.pluginsdk.ui.d.j.b(paramContext, (String)((Iterator)localObject).next(), com.tencent.mm.cb.a.aa(paramContext, b.b.NormalTextSize));
        e locale = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.d.a(this.ieB, this.kwi, bool3, bool2));
        if (locale.aYY == 0) {
          this.ieB = locale.kwz;
        }
      }
      this.ieB = TextUtils.concat(new CharSequence[] { this.ieB, paramContext.getString(b.h.search_biz_tran_info) + str });
      bool1 = bool3;
      break;
      this.ieA = com.tencent.mm.pluginsdk.ui.d.j.b(paramContext, str, com.tencent.mm.cb.a.aa(paramContext, b.b.NormalTextSize));
      break label240;
      bool2 = false;
      break label333;
      bool2 = false;
    }
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a.a afK()
  {
    return this.ieD;
  }
  
  public final String afL()
  {
    if (this.ieA != null) {
      return this.ieA.toString();
    }
    return "";
  }
  
  public final int afM()
  {
    return this.fYx.kxt;
  }
  
  public final class a
    extends com.tencent.mm.plugin.fts.a.d.a.a.a
  {
    public View contentView;
    public ImageView doU;
    public TextView eXO;
    public TextView eXP;
    
    public a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.a.a
 * JD-Core Version:    0.7.0.1
 */