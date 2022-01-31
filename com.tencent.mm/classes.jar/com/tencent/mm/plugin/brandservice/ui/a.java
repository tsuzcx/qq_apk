package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.d;
import com.tencent.mm.aj.d.b;
import com.tencent.mm.aj.d.b.d;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.bya;
import com.tencent.mm.protocal.protobuf.nb;
import com.tencent.mm.protocal.protobuf.nd;
import com.tencent.mm.protocal.protobuf.ni;
import com.tencent.mm.protocal.protobuf.wd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

public final class a
  extends com.tencent.mm.plugin.brandservice.ui.base.a
{
  private static a.b jSV;
  protected String iconUrl;
  protected CharSequence jSW;
  protected CharSequence jSX;
  protected CharSequence jSY;
  protected boolean jSZ;
  protected boolean jTa;
  protected CharSequence nickName;
  protected String username;
  
  public a(Object paramObject)
  {
    super(5, paramObject);
  }
  
  public final void a(Context paramContext, com.tencent.mm.ui.base.sortview.a.a parama, Object... paramVarArgs)
  {
    Object localObject = null;
    AppMethodBeat.i(13867);
    if (this.zsv)
    {
      AppMethodBeat.o(13867);
      return;
    }
    if ((paramContext == null) || (parama == null) || (this.data == null))
    {
      ab.e("MicroMsg.BizContactDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
      AppMethodBeat.o(13867);
      return;
    }
    if (!(parama instanceof a.a))
    {
      ab.e("MicroMsg.BizContactDataItem", "The DataItem is not a instance of BizContactViewHolder.");
      AppMethodBeat.o(13867);
      return;
    }
    if (!(this.data instanceof ni))
    {
      ab.e("MicroMsg.BizContactDataItem", "The ViewHolder is not a instance of BusinessResultItem.");
      AppMethodBeat.o(13867);
      return;
    }
    a.a locala = (a.a)parama;
    parama = (ni)this.data;
    if ((parama.wCo == null) || (parama.wCo.wBU == null))
    {
      ab.e("MicroMsg.BizContactDataItem", "The brItem.ContactItem or brItem.ContactItem.ContactItem is null.");
      AppMethodBeat.o(13867);
      return;
    }
    bya localbya = parama.wCo.wBU;
    parama = parama.wCo.wBR;
    if ((paramVarArgs != null) && (paramVarArgs.length > 1) && ((paramVarArgs[1] instanceof List))) {
      this.jUY = ((List)paramVarArgs[1]);
    }
    this.username = localbya.wOT.xJE;
    this.iconUrl = localbya.wJr;
    if (parama == null) {
      parama = "";
    }
    for (;;)
    {
      this.jSX = parama;
      if (localbya.xmi == null) {
        parama = null;
      }
      try
      {
        paramVarArgs = this.jUY;
        locala.ejj.getTextSize();
        this.nickName = com.tencent.mm.plugin.brandservice.b.a.b(paramContext, parama, paramVarArgs);
        paramVarArgs = localbya.wOT.xJE;
        wd localwd = localbya.xKz;
        if (localwd != null)
        {
          parama = new d();
          parama.field_username = paramVarArgs;
          com.tencent.mm.plugin.brandservice.b.a.a(parama, localwd);
          paramVarArgs = localObject;
          if (parama != null)
          {
            paramVarArgs = localObject;
            if (parama.cU(false) != null) {
              paramVarArgs = parama.cU(false).aeB();
            }
          }
          if (paramVarArgs != null)
          {
            if ((parama.cU(false).aeD()) && (!bo.isNullOrNil(paramVarArgs.fvS)))
            {
              bool = true;
              this.jTa = bool;
              if (localbya.xpe == 0) {
                break label639;
              }
              bool = true;
              this.jSZ = bool;
            }
          }
          else
          {
            ab.v("MicroMsg.BizContactDataItem", "verifyFlag : %d", new Object[] { Integer.valueOf(localbya.xpe) });
            parama = localbya.gwU;
            if ((this.jUY.size() <= 0) || (parama == null) || (!parama.toLowerCase().equals(((String)this.jUY.get(0)).toLowerCase()))) {}
          }
        }
      }
      catch (Exception parama)
      {
        for (;;)
        {
          try
          {
            paramVarArgs = this.jUY;
            locala.jTf.getTextSize();
            this.jSY = com.tencent.mm.plugin.brandservice.b.a.b(paramContext, parama, paramVarArgs);
            this.jSY = TextUtils.concat(new CharSequence[] { paramContext.getResources().getString(2131302996), this.jSY });
            if ((this.jSY != null) && (this.jSY.length() != 0) && (this.jSX != null)) {
              if (this.jSX.length() != 0) {
                continue;
              }
            }
          }
          catch (Exception parama)
          {
            try
            {
              parama = localbya.gwS;
              paramVarArgs = this.jUY;
              locala.jTd.getTextSize();
              this.jSW = com.tencent.mm.plugin.brandservice.b.a.b(paramContext, parama, paramVarArgs);
              ab.d("MicroMsg.BizContactDataItem", "nickName : %s, followFriends : %s.", new Object[] { this.nickName, this.jSX });
              this.zsv = true;
              AppMethodBeat.o(13867);
              return;
              parama = parama.wCa;
              break;
              parama = localbya.xmi.xJE;
              continue;
              parama = parama;
              this.nickName = "";
              continue;
              boolean bool = false;
              continue;
              label639:
              bool = false;
              continue;
              parama = parama;
              this.jSY = "";
            }
            catch (Exception paramContext)
            {
              this.jSW = "";
              continue;
            }
          }
          parama = null;
        }
      }
    }
  }
  
  public final com.tencent.mm.ui.base.sortview.a.b aWu()
  {
    AppMethodBeat.i(13865);
    if (jSV == null) {
      jSV = new a.b();
    }
    a.b localb = jSV;
    AppMethodBeat.o(13865);
    return localb;
  }
  
  public final com.tencent.mm.ui.base.sortview.a.a aWv()
  {
    AppMethodBeat.i(13866);
    a.a locala = new a.a();
    AppMethodBeat.o(13866);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.a
 * JD-Core Version:    0.7.0.1
 */