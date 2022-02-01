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
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b;
import com.tencent.mm.plugin.brandservice.b.d.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.websearch.api.ah;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.acp;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.czn;
import com.tencent.mm.protocal.protobuf.qs;
import com.tencent.mm.protocal.protobuf.qu;
import com.tencent.mm.protocal.protobuf.ra;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import java.io.IOException;
import java.util.List;

public final class a
  extends com.tencent.mm.plugin.brandservice.ui.base.a
{
  private static b ocM;
  protected String iconUrl;
  protected CharSequence nickName;
  protected CharSequence ocN;
  protected CharSequence ocO;
  protected CharSequence ocP;
  protected boolean ocQ;
  protected boolean ocR;
  protected String username;
  
  public a(Object paramObject)
  {
    super(5, paramObject);
  }
  
  public final void a(Context paramContext, com.tencent.mm.ui.base.sortview.a.a parama, Object... paramVarArgs)
  {
    Object localObject = null;
    AppMethodBeat.i(5605);
    if (this.JOH)
    {
      AppMethodBeat.o(5605);
      return;
    }
    if ((paramContext == null) || (parama == null) || (this.data == null))
    {
      ae.e("MicroMsg.BizContactDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
      AppMethodBeat.o(5605);
      return;
    }
    if (!(parama instanceof a))
    {
      ae.e("MicroMsg.BizContactDataItem", "The DataItem is not a instance of BizContactViewHolder.");
      AppMethodBeat.o(5605);
      return;
    }
    if (!(this.data instanceof ra))
    {
      ae.e("MicroMsg.BizContactDataItem", "The ViewHolder is not a instance of BusinessResultItem.");
      AppMethodBeat.o(5605);
      return;
    }
    a locala = (a)parama;
    parama = (ra)this.data;
    if ((parama.Gfp == null) || (parama.Gfp.GeN == null))
    {
      ae.e("MicroMsg.BizContactDataItem", "The brItem.ContactItem or brItem.ContactItem.ContactItem is null.");
      AppMethodBeat.o(5605);
      return;
    }
    czn localczn = parama.Gfp.GeN;
    parama = parama.Gfp.GeK;
    if ((paramVarArgs != null) && (paramVarArgs.length > 1) && ((paramVarArgs[1] instanceof List))) {
      this.ofq = ((List)paramVarArgs[1]);
    }
    this.username = localczn.GuF.HId;
    this.iconUrl = localczn.GnO;
    if (parama == null) {
      parama = "";
    }
    for (;;)
    {
      this.ocO = parama;
      if (localczn.Hed == null) {
        parama = null;
      }
      try
      {
        paramVarArgs = this.ofq;
        locala.fRI.getTextSize();
        this.nickName = com.tencent.mm.plugin.brandservice.b.d.c(paramContext, parama, paramVarArgs);
        paramVarArgs = localczn.GuF.HId;
        acp localacp = localczn.HJi;
        if (localacp != null)
        {
          parama = new com.tencent.mm.api.c();
          parama.field_username = paramVarArgs;
          com.tencent.mm.plugin.brandservice.b.d.a(parama, localacp);
          paramVarArgs = localObject;
          if (parama != null)
          {
            paramVarArgs = localObject;
            if (parama.bX(false) != null) {
              paramVarArgs = parama.bX(false).KQ();
            }
          }
          if (paramVarArgs != null)
          {
            if ((parama.bX(false).KS()) && (!bu.isNullOrNil(paramVarArgs.cRX)))
            {
              bool = true;
              this.ocR = bool;
              if (localczn.Hhu == 0) {
                break label639;
              }
              bool = true;
              this.ocQ = bool;
            }
          }
          else
          {
            ae.v("MicroMsg.BizContactDataItem", "verifyFlag : %d", new Object[] { Integer.valueOf(localczn.Hhu) });
            parama = localczn.jga;
            if ((this.ofq.size() <= 0) || (parama == null) || (!parama.toLowerCase().equals(((String)this.ofq.get(0)).toLowerCase()))) {}
          }
        }
      }
      catch (Exception parama)
      {
        for (;;)
        {
          try
          {
            paramVarArgs = this.ofq;
            locala.ocW.getTextSize();
            this.ocP = com.tencent.mm.plugin.brandservice.b.d.c(paramContext, parama, paramVarArgs);
            this.ocP = TextUtils.concat(new CharSequence[] { paramContext.getResources().getString(2131762935), this.ocP });
            if ((this.ocP != null) && (this.ocP.length() != 0) && (this.ocO != null)) {
              if (this.ocO.length() != 0) {
                continue;
              }
            }
          }
          catch (Exception parama)
          {
            try
            {
              parama = localczn.jfY;
              paramVarArgs = this.ofq;
              locala.ocU.getTextSize();
              this.ocN = com.tencent.mm.plugin.brandservice.b.d.c(paramContext, parama, paramVarArgs);
              ae.d("MicroMsg.BizContactDataItem", "nickName : %s, followFriends : %s.", new Object[] { this.nickName, this.ocO });
              this.JOH = true;
              AppMethodBeat.o(5605);
              return;
              parama = parama.GeU;
              break;
              parama = localczn.Hed.HId;
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
              this.ocP = "";
            }
            catch (Exception paramContext)
            {
              this.ocN = "";
              continue;
            }
          }
          parama = null;
        }
      }
    }
  }
  
  public final com.tencent.mm.ui.base.sortview.a.b bOM()
  {
    AppMethodBeat.i(5603);
    if (ocM == null) {
      ocM = new b();
    }
    b localb = ocM;
    AppMethodBeat.o(5603);
    return localb;
  }
  
  public final com.tencent.mm.ui.base.sortview.a.a bON()
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
    public TextView fRI;
    public TextView ocS;
    public View ocT;
    public TextView ocU;
    public TextView ocV;
    public TextView ocW;
    View ocX;
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
        ae.e("MicroMsg.BizContactDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
        AppMethodBeat.o(5601);
        return;
      }
      if (!(parama instanceof a.a))
      {
        ae.e("MicroMsg.BizContactDataItem", "The DataItem is not a instance of BizContactViewHolder.");
        AppMethodBeat.o(5601);
        return;
      }
      if (!(paramVarArgs instanceof a))
      {
        ae.e("MicroMsg.BizContactDataItem", "The ViewHolder is not a instance of BusinessResultItem.");
        AppMethodBeat.o(5601);
        return;
      }
      paramContext = (a.a)parama;
      parama = (a)paramVarArgs;
      paramContext.username = parama.username;
      paramContext.iconUrl = parama.iconUrl;
      com.tencent.mm.pluginsdk.ui.a.b.d(paramContext.fQl, parama.username);
      paramVarArgs = paramContext.ocT;
      int i;
      if (parama.ocQ)
      {
        i = 0;
        paramVarArgs.setVisibility(i);
        paramVarArgs = paramContext.ocX;
        i = j;
        if (parama.ocR) {
          i = 0;
        }
        paramVarArgs.setVisibility(i);
        com.tencent.mm.plugin.brandservice.b.d.c(paramContext.fRI, parama.nickName);
        boolean bool1 = com.tencent.mm.plugin.brandservice.b.d.c(paramContext.ocW, parama.ocP);
        boolean bool2 = com.tencent.mm.plugin.brandservice.b.d.c(paramContext.ocV, parama.ocO);
        if (com.tencent.mm.plugin.brandservice.b.d.c(paramContext.ocU, parama.ocN))
        {
          if ((bool1) || (bool2)) {
            break label277;
          }
          paramContext.ocU.setMaxLines(2);
        }
      }
      for (;;)
      {
        ae.d("MicroMsg.BizContactDataItem", "fillingView , nickName : %s, followFriends : %s.", new Object[] { parama.nickName, parama.ocO });
        AppMethodBeat.o(5601);
        return;
        i = 8;
        break;
        label277:
        paramContext.ocU.setMaxLines(1);
      }
    }
    
    public final void a(View paramView, com.tencent.mm.ui.base.sortview.a.a parama)
    {
      AppMethodBeat.i(5602);
      if ((paramView != null) && (parama != null) && ((parama instanceof a.a)))
      {
        parama = (a.a)parama;
        parama.ocS = ((TextView)paramView.findViewById(2131298724));
        parama.ocX = paramView.findViewById(2131297275);
        parama.fQl = ((ImageView)paramView.findViewById(2131296997));
        parama.fRI = ((TextView)paramView.findViewById(2131302864));
        parama.ocT = paramView.findViewById(2131306278);
        parama.ocV = ((TextView)paramView.findViewById(2131300189));
        parama.ocU = ((TextView)paramView.findViewById(2131301045));
        parama.ocW = ((TextView)paramView.findViewById(2131307114));
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
      if (!(parama.getData() instanceof ra))
      {
        ae.e("MicroMsg.BizContactDataItem", "The DataItem is not a instance of BusinessResultItem.");
        AppMethodBeat.o(5599);
        return false;
      }
      Object localObject3 = (ra)parama.getData();
      if ((((ra)localObject3).Gfp == null) || (((ra)localObject3).Gfp.GeN == null))
      {
        ae.e("MicroMsg.BizContactDataItem", "The brItem.ContactItem or brItem.ContactItem.ContactItem is null.");
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
        Object localObject4 = ((ra)localObject3).Gfp.uqf;
        czn localczn = ((ra)localObject3).Gfp.GeN;
        if (localczn.Hed != null)
        {
          localObject3 = localczn.Hed.HId;
          if (localczn.GuF == null) {
            break label269;
          }
        }
        label269:
        for (str = localczn.GuF.HId;; str = null)
        {
          if (!bu.isNullOrNil(str)) {
            break label275;
          }
          ae.e("MicroMsg.BizContactDataItem", "onItemClick but username is null");
          AppMethodBeat.o(5599);
          return false;
          localObject3 = null;
          break;
        }
        label275:
        ah.aHm(str);
        if (!bu.isNullOrNil((String)localObject4))
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
          paramContext = locala.bPd();
          if ((paramContext != null) && (paramVarArgs != null)) {
            paramContext.a(paramVarArgs, parama, i, str, locala.bPe(), locala.getPosition());
          }
          AppMethodBeat.o(5599);
          return true;
          an localan = ((l)g.ab(l.class)).azF().BH(str);
          localObject4 = new Intent();
          Bundle localBundle = new Bundle();
          localBundle.putString("Contact_Ext_Args_Search_Id", (String)localObject1);
          localBundle.putInt("Contact_Ext_Args_Index", locala.bPe());
          localBundle.putString("Contact_Ext_Args_Query_String", "");
          localBundle.putInt("Contact_Scene", i);
          ((Intent)localObject4).putExtra("Contact_Ext_Args", localBundle);
          ((Intent)localObject4).putExtra("Contact_User", str);
          ((Intent)localObject4).putExtra("Contact_Scene", i);
          if (!com.tencent.mm.contact.c.lO(localan.field_type))
          {
            ((Intent)localObject4).putExtra("Contact_Alias", localczn.jga);
            ((Intent)localObject4).putExtra("Contact_Nick", (String)localObject3);
            ((Intent)localObject4).putExtra("Contact_Signature", localczn.jfY);
            ((Intent)localObject4).putExtra("Contact_RegionCode", RegionCodeDecoder.bg(localczn.jge, localczn.jfW, localczn.jfX));
            ((Intent)localObject4).putExtra("Contact_Sex", localczn.jfV);
            ((Intent)localObject4).putExtra("Contact_VUser_Info", localczn.Hhv);
            ((Intent)localObject4).putExtra("Contact_VUser_Info_Flag", localczn.Hhu);
            ((Intent)localObject4).putExtra("Contact_KWeibo_flag", localczn.Hhy);
            ((Intent)localObject4).putExtra("Contact_KWeibo", localczn.Hhw);
            ((Intent)localObject4).putExtra("Contact_KWeiboNick", localczn.Hhx);
            if (localczn.HJi == null) {}
          }
          try
          {
            ((Intent)localObject4).putExtra("Contact_customInfo", localczn.HJi.toByteArray());
            b.iUz.c((Intent)localObject4, paramContext);
            i = 1;
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              ae.printErrStackTrace("MicroMsg.BizContactDataItem", localIOException, "", new Object[0]);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.a
 * JD-Core Version:    0.7.0.1
 */