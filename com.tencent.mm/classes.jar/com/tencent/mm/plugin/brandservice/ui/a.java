package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.c.b.e;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b.d.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.aag;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.ctj;
import com.tencent.mm.protocal.protobuf.pl;
import com.tencent.mm.protocal.protobuf.pn;
import com.tencent.mm.protocal.protobuf.pt;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import java.io.IOException;
import java.util.List;

public final class a
  extends com.tencent.mm.plugin.brandservice.ui.base.a
{
  private static b nvF;
  protected String iconUrl;
  protected CharSequence nickName;
  protected CharSequence nvG;
  protected CharSequence nvH;
  protected CharSequence nvI;
  protected boolean nvJ;
  protected boolean nvK;
  protected String username;
  
  public a(Object paramObject)
  {
    super(5, paramObject);
  }
  
  public final void a(Context paramContext, com.tencent.mm.ui.base.sortview.a.a parama, Object... paramVarArgs)
  {
    Object localObject = null;
    AppMethodBeat.i(5605);
    if (this.HGb)
    {
      AppMethodBeat.o(5605);
      return;
    }
    if ((paramContext == null) || (parama == null) || (this.data == null))
    {
      ac.e("MicroMsg.BizContactDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
      AppMethodBeat.o(5605);
      return;
    }
    if (!(parama instanceof a))
    {
      ac.e("MicroMsg.BizContactDataItem", "The DataItem is not a instance of BizContactViewHolder.");
      AppMethodBeat.o(5605);
      return;
    }
    if (!(this.data instanceof pt))
    {
      ac.e("MicroMsg.BizContactDataItem", "The ViewHolder is not a instance of BusinessResultItem.");
      AppMethodBeat.o(5605);
      return;
    }
    a locala = (a)parama;
    parama = (pt)this.data;
    if ((parama.Egr == null) || (parama.Egr.EfP == null))
    {
      ac.e("MicroMsg.BizContactDataItem", "The brItem.ContactItem or brItem.ContactItem.ContactItem is null.");
      AppMethodBeat.o(5605);
      return;
    }
    ctj localctj = parama.Egr.EfP;
    parama = parama.Egr.EfM;
    if ((paramVarArgs != null) && (paramVarArgs.length > 1) && ((paramVarArgs[1] instanceof List))) {
      this.nyi = ((List)paramVarArgs[1]);
    }
    this.username = localctj.EuE.FEm;
    this.iconUrl = localctj.Eog;
    if (parama == null) {
      parama = "";
    }
    for (;;)
    {
      this.nvH = parama;
      if (localctj.Fbd == null) {
        parama = null;
      }
      try
      {
        paramVarArgs = this.nyi;
        locala.fwp.getTextSize();
        this.nickName = com.tencent.mm.plugin.brandservice.b.d.b(paramContext, parama, paramVarArgs);
        paramVarArgs = localctj.EuE.FEm;
        aag localaag = localctj.FFh;
        if (localaag != null)
        {
          parama = new com.tencent.mm.api.c();
          parama.field_username = paramVarArgs;
          com.tencent.mm.plugin.brandservice.b.d.a(parama, localaag);
          paramVarArgs = localObject;
          if (parama != null)
          {
            paramVarArgs = localObject;
            if (parama.bV(false) != null) {
              paramVarArgs = parama.bV(false).Ji();
            }
          }
          if (paramVarArgs != null)
          {
            if ((parama.bV(false).Jl()) && (!bs.isNullOrNil(paramVarArgs.cGj)))
            {
              bool = true;
              this.nvK = bool;
              if (localctj.Feq == 0) {
                break label639;
              }
              bool = true;
              this.nvJ = bool;
            }
          }
          else
          {
            ac.v("MicroMsg.BizContactDataItem", "verifyFlag : %d", new Object[] { Integer.valueOf(localctj.Feq) });
            parama = localctj.iJY;
            if ((this.nyi.size() <= 0) || (parama == null) || (!parama.toLowerCase().equals(((String)this.nyi.get(0)).toLowerCase()))) {}
          }
        }
      }
      catch (Exception parama)
      {
        for (;;)
        {
          try
          {
            paramVarArgs = this.nyi;
            locala.nvP.getTextSize();
            this.nvI = com.tencent.mm.plugin.brandservice.b.d.b(paramContext, parama, paramVarArgs);
            this.nvI = TextUtils.concat(new CharSequence[] { paramContext.getResources().getString(2131762935), this.nvI });
            if ((this.nvI != null) && (this.nvI.length() != 0) && (this.nvH != null)) {
              if (this.nvH.length() != 0) {
                continue;
              }
            }
          }
          catch (Exception parama)
          {
            try
            {
              parama = localctj.iJW;
              paramVarArgs = this.nyi;
              locala.nvN.getTextSize();
              this.nvG = com.tencent.mm.plugin.brandservice.b.d.b(paramContext, parama, paramVarArgs);
              ac.d("MicroMsg.BizContactDataItem", "nickName : %s, followFriends : %s.", new Object[] { this.nickName, this.nvH });
              this.HGb = true;
              AppMethodBeat.o(5605);
              return;
              parama = parama.EfW;
              break;
              parama = localctj.Fbd.FEm;
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
              this.nvI = "";
            }
            catch (Exception paramContext)
            {
              this.nvG = "";
              continue;
            }
          }
          parama = null;
        }
      }
    }
  }
  
  public final com.tencent.mm.ui.base.sortview.a.b bJw()
  {
    AppMethodBeat.i(5603);
    if (nvF == null) {
      nvF = new b();
    }
    b localb = nvF;
    AppMethodBeat.o(5603);
    return localb;
  }
  
  public final com.tencent.mm.ui.base.sortview.a.a bJx()
  {
    AppMethodBeat.i(5604);
    a locala = new a();
    AppMethodBeat.o(5604);
    return locala;
  }
  
  public static final class a
    extends d.a
    implements com.tencent.mm.ui.base.sortview.a.a
  {
    public TextView fwp;
    public TextView nvL;
    public View nvM;
    public TextView nvN;
    public TextView nvO;
    public TextView nvP;
    View nvQ;
  }
  
  public static final class b
    extends com.tencent.mm.ui.base.sortview.a.b
  {
    public final void a(Context paramContext, com.tencent.mm.ui.base.sortview.a.a parama, com.tencent.mm.ui.base.sortview.a paramVarArgs)
    {
      int j = 8;
      AppMethodBeat.i(5601);
      if ((paramContext == null) || (parama == null) || (paramVarArgs == null) || (paramVarArgs.getData() == null))
      {
        ac.e("MicroMsg.BizContactDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
        AppMethodBeat.o(5601);
        return;
      }
      if (!(parama instanceof a.a))
      {
        ac.e("MicroMsg.BizContactDataItem", "The DataItem is not a instance of BizContactViewHolder.");
        AppMethodBeat.o(5601);
        return;
      }
      if (!(paramVarArgs instanceof a))
      {
        ac.e("MicroMsg.BizContactDataItem", "The ViewHolder is not a instance of BusinessResultItem.");
        AppMethodBeat.o(5601);
        return;
      }
      paramContext = (a.a)parama;
      parama = (a)paramVarArgs;
      paramContext.username = parama.username;
      paramContext.iconUrl = parama.iconUrl;
      com.tencent.mm.pluginsdk.ui.a.b.d(paramContext.fuY, parama.username);
      paramVarArgs = paramContext.nvM;
      int i;
      if (parama.nvJ)
      {
        i = 0;
        paramVarArgs.setVisibility(i);
        paramVarArgs = paramContext.nvQ;
        i = j;
        if (parama.nvK) {
          i = 0;
        }
        paramVarArgs.setVisibility(i);
        com.tencent.mm.plugin.brandservice.b.d.c(paramContext.fwp, parama.nickName);
        boolean bool1 = com.tencent.mm.plugin.brandservice.b.d.c(paramContext.nvP, parama.nvI);
        boolean bool2 = com.tencent.mm.plugin.brandservice.b.d.c(paramContext.nvO, parama.nvH);
        if (com.tencent.mm.plugin.brandservice.b.d.c(paramContext.nvN, parama.nvG))
        {
          if ((bool1) || (bool2)) {
            break label277;
          }
          paramContext.nvN.setMaxLines(2);
        }
      }
      for (;;)
      {
        ac.d("MicroMsg.BizContactDataItem", "fillingView , nickName : %s, followFriends : %s.", new Object[] { parama.nickName, parama.nvH });
        AppMethodBeat.o(5601);
        return;
        i = 8;
        break;
        label277:
        paramContext.nvN.setMaxLines(1);
      }
    }
    
    public final void a(View paramView, com.tencent.mm.ui.base.sortview.a.a parama)
    {
      AppMethodBeat.i(5602);
      if ((paramView != null) && (parama != null) && ((parama instanceof a.a)))
      {
        parama = (a.a)parama;
        parama.nvL = ((TextView)paramView.findViewById(2131298724));
        parama.nvQ = paramView.findViewById(2131297275);
        parama.fuY = ((ImageView)paramView.findViewById(2131296997));
        parama.fwp = ((TextView)paramView.findViewById(2131302864));
        parama.nvM = paramView.findViewById(2131306278);
        parama.nvO = ((TextView)paramView.findViewById(2131300189));
        parama.nvN = ((TextView)paramView.findViewById(2131301045));
        parama.nvP = ((TextView)paramView.findViewById(2131307114));
      }
      AppMethodBeat.o(5602);
    }
    
    public final boolean a(Context paramContext, com.tencent.mm.ui.base.sortview.a parama, Object... paramVarArgs)
    {
      AppMethodBeat.i(5599);
      if (!(parama instanceof a))
      {
        AppMethodBeat.o(5599);
        return false;
      }
      a locala = (a)parama;
      if (!(parama.getData() instanceof pt))
      {
        ac.e("MicroMsg.BizContactDataItem", "The DataItem is not a instance of BusinessResultItem.");
        AppMethodBeat.o(5599);
        return false;
      }
      Object localObject3 = (pt)parama.getData();
      if ((((pt)localObject3).Egr == null) || (((pt)localObject3).Egr.EfP == null))
      {
        ac.e("MicroMsg.BizContactDataItem", "The brItem.ContactItem or brItem.ContactItem.ContactItem is null.");
        AppMethodBeat.o(5599);
        return false;
      }
      Object localObject1 = null;
      String str = "";
      int i;
      if (paramVarArgs != null) {
        if ((paramVarArgs.length > 0) && ((paramVarArgs[0] instanceof c)))
        {
          localObject1 = (c)paramVarArgs[0];
          if ((paramVarArgs.length > 2) && ((paramVarArgs[2] instanceof Integer)))
          {
            i = ((Integer)paramVarArgs[2]).intValue();
            label154:
            if ((paramVarArgs.length > 3) && ((paramVarArgs[3] instanceof String)))
            {
              str = (String)paramVarArgs[3];
              paramVarArgs = (Object[])localObject1;
              localObject1 = str;
            }
          }
        }
      }
      for (;;)
      {
        Object localObject4 = ((pt)localObject3).Egr.thh;
        ctj localctj = ((pt)localObject3).Egr.EfP;
        if (localctj.Fbd != null)
        {
          localObject3 = localctj.Fbd.FEm;
          if (localctj.EuE == null) {
            break label269;
          }
        }
        label269:
        for (str = localctj.EuE.FEm;; str = null)
        {
          if (!bs.isNullOrNil(str)) {
            break label275;
          }
          ac.e("MicroMsg.BizContactDataItem", "onItemClick but username is null");
          AppMethodBeat.o(5599);
          return false;
          localObject3 = null;
          break;
        }
        label275:
        ad.aAy(str);
        if (!bs.isNullOrNil((String)localObject4))
        {
          i = 8;
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("rawUrl", (String)localObject4);
          ((Intent)localObject1).putExtra("useJs", true);
          ((Intent)localObject1).putExtra("vertical_scroll", true);
          com.tencent.mm.br.d.b(paramContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
        }
        for (;;)
        {
          paramContext = locala.bJN();
          if ((paramContext != null) && (paramVarArgs != null)) {
            paramContext.a(paramVarArgs, parama, i, str, locala.bJO(), locala.getPosition());
          }
          AppMethodBeat.o(5599);
          return true;
          ai localai = ((k)g.ab(k.class)).awB().aNt(str);
          localObject4 = new Intent();
          Bundle localBundle = new Bundle();
          localBundle.putString("Contact_Ext_Args_Search_Id", (String)localObject1);
          localBundle.putInt("Contact_Ext_Args_Index", locala.bJO());
          localBundle.putString("Contact_Ext_Args_Query_String", "");
          localBundle.putInt("Contact_Scene", i);
          ((Intent)localObject4).putExtra("Contact_Ext_Args", localBundle);
          ((Intent)localObject4).putExtra("Contact_User", str);
          ((Intent)localObject4).putExtra("Contact_Scene", i);
          if (!com.tencent.mm.n.b.ln(localai.field_type))
          {
            ((Intent)localObject4).putExtra("Contact_Alias", localctj.iJY);
            ((Intent)localObject4).putExtra("Contact_Nick", (String)localObject3);
            ((Intent)localObject4).putExtra("Contact_Signature", localctj.iJW);
            ((Intent)localObject4).putExtra("Contact_RegionCode", RegionCodeDecoder.aW(localctj.iKc, localctj.iJU, localctj.iJV));
            ((Intent)localObject4).putExtra("Contact_Sex", localctj.iJT);
            ((Intent)localObject4).putExtra("Contact_VUser_Info", localctj.Fer);
            ((Intent)localObject4).putExtra("Contact_VUser_Info_Flag", localctj.Feq);
            ((Intent)localObject4).putExtra("Contact_KWeibo_flag", localctj.Feu);
            ((Intent)localObject4).putExtra("Contact_KWeibo", localctj.Fes);
            ((Intent)localObject4).putExtra("Contact_KWeiboNick", localctj.Fet);
            if (localctj.FFh == null) {}
          }
          try
          {
            ((Intent)localObject4).putExtra("Contact_customInfo", localctj.FFh.toByteArray());
            com.tencent.mm.plugin.brandservice.b.iyx.c((Intent)localObject4, paramContext);
            i = 1;
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              ac.printErrStackTrace("MicroMsg.BizContactDataItem", localIOException, "", new Object[0]);
            }
          }
        }
        paramVarArgs = localIOException;
        Object localObject2 = str;
        continue;
        i = 0;
        break label154;
        localObject2 = null;
        break;
        i = 0;
        paramVarArgs = localObject2;
        localObject2 = str;
      }
    }
    
    public final View c(Context paramContext, View paramView)
    {
      AppMethodBeat.i(5600);
      View localView = paramView;
      if (paramView == null) {
        localView = View.inflate(paramContext, 2131495325, null);
      }
      AppMethodBeat.o(5600);
      return localView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.a
 * JD-Core Version:    0.7.0.1
 */