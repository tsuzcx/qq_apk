package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mm.ai.d;
import com.tencent.mm.ai.d.b;
import com.tencent.mm.ai.d.b.d;
import com.tencent.mm.plugin.brandservice.b.h;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.bof;
import com.tencent.mm.protocal.c.kp;
import com.tencent.mm.protocal.c.kr;
import com.tencent.mm.protocal.c.kw;
import com.tencent.mm.protocal.c.sh;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

public final class a
  extends com.tencent.mm.plugin.brandservice.ui.base.a
{
  private static a.b icf;
  protected CharSequence icg;
  protected CharSequence ich;
  protected CharSequence ici;
  protected boolean icj;
  protected boolean ick;
  protected String iconUrl;
  protected CharSequence nickName;
  protected String username;
  
  public a(Object paramObject)
  {
    super(5, paramObject);
  }
  
  public final void a(Context paramContext, com.tencent.mm.ui.base.sortview.a.a parama, Object... paramVarArgs)
  {
    Object localObject = null;
    if (this.vdV) {
      return;
    }
    if ((paramContext == null) || (parama == null) || (this.data == null))
    {
      y.e("MicroMsg.BizContactDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
      return;
    }
    if (!(parama instanceof a.a))
    {
      y.e("MicroMsg.BizContactDataItem", "The DataItem is not a instance of BizContactViewHolder.");
      return;
    }
    if (!(this.data instanceof kw))
    {
      y.e("MicroMsg.BizContactDataItem", "The ViewHolder is not a instance of BusinessResultItem.");
      return;
    }
    a.a locala = (a.a)parama;
    parama = (kw)this.data;
    if ((parama.sFU == null) || (parama.sFU.sFA == null))
    {
      y.e("MicroMsg.BizContactDataItem", "The brItem.ContactItem or brItem.ContactItem.ContactItem is null.");
      return;
    }
    bof localbof = parama.sFU.sFA;
    parama = parama.sFU.sFx;
    if ((paramVarArgs != null) && (paramVarArgs.length > 1) && ((paramVarArgs[1] instanceof List))) {
      this.iek = ((List)paramVarArgs[1]);
    }
    this.username = localbof.sQs.tFO;
    this.iconUrl = localbof.sLE;
    if (parama == null) {
      parama = "";
    }
    for (;;)
    {
      this.ich = parama;
      if (localbof.tmw == null) {
        parama = null;
      }
      try
      {
        paramVarArgs = this.iek;
        locala.drB.getTextSize();
        this.nickName = com.tencent.mm.plugin.brandservice.b.a.b(paramContext, parama, paramVarArgs);
        paramVarArgs = localbof.sQs.tFO;
        sh localsh = localbof.tGL;
        if (localsh != null)
        {
          parama = new d();
          parama.field_username = paramVarArgs;
          com.tencent.mm.plugin.brandservice.b.a.a(parama, localsh);
          paramVarArgs = localObject;
          if (parama != null)
          {
            paramVarArgs = localObject;
            if (parama.bS(false) != null) {
              paramVarArgs = parama.bS(false).LT();
            }
          }
          if (paramVarArgs != null)
          {
            if ((parama.bS(false).LV()) && (!bk.bl(paramVarArgs.efQ)))
            {
              bool = true;
              this.ick = bool;
              if (localbof.tpg == 0) {
                break label598;
              }
              bool = true;
              this.icj = bool;
            }
          }
          else
          {
            y.v("MicroMsg.BizContactDataItem", "verifyFlag : %d", new Object[] { Integer.valueOf(localbof.tpg) });
            parama = localbof.ffm;
            if ((this.iek.size() <= 0) || (parama == null) || (!parama.toLowerCase().equals(((String)this.iek.get(0)).toLowerCase()))) {}
          }
        }
      }
      catch (Exception parama)
      {
        for (;;)
        {
          try
          {
            paramVarArgs = this.iek;
            locala.icp.getTextSize();
            this.ici = com.tencent.mm.plugin.brandservice.b.a.b(paramContext, parama, paramVarArgs);
            this.ici = TextUtils.concat(new CharSequence[] { paramContext.getResources().getString(b.h.search_contact_tag_wxid), this.ici });
            if ((this.ici != null) && (this.ici.length() != 0) && (this.ich != null)) {
              if (this.ich.length() != 0) {
                continue;
              }
            }
          }
          catch (Exception parama)
          {
            try
            {
              parama = localbof.ffk;
              paramVarArgs = this.iek;
              locala.icn.getTextSize();
              this.icg = com.tencent.mm.plugin.brandservice.b.a.b(paramContext, parama, paramVarArgs);
              y.d("MicroMsg.BizContactDataItem", "nickName : %s, followFriends : %s.", new Object[] { this.nickName, this.ich });
              this.vdV = true;
              return;
              parama = parama.sFG;
              break;
              parama = localbof.tmw.tFO;
              continue;
              parama = parama;
              this.nickName = "";
              continue;
              boolean bool = false;
              continue;
              label598:
              bool = false;
              continue;
              parama = parama;
              this.ici = "";
            }
            catch (Exception paramContext)
            {
              this.icg = "";
              continue;
            }
          }
          parama = null;
        }
      }
    }
  }
  
  public final com.tencent.mm.ui.base.sortview.a.b axw()
  {
    if (icf == null) {
      icf = new a.b();
    }
    return icf;
  }
  
  public final com.tencent.mm.ui.base.sortview.a.a axx()
  {
    return new a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.a
 * JD-Core Version:    0.7.0.1
 */