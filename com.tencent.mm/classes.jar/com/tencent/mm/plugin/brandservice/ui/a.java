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
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.plugin.brandservice.b.d.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.aer;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.dso;
import com.tencent.mm.protocal.protobuf.rt;
import com.tencent.mm.protocal.protobuf.rv;
import com.tencent.mm.protocal.protobuf.sb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import java.io.IOException;
import java.util.List;

public final class a
  extends com.tencent.mm.plugin.brandservice.ui.base.a
{
  private static b pnJ;
  protected String iconUrl;
  protected CharSequence nickName;
  protected CharSequence pnK;
  protected CharSequence pnL;
  protected CharSequence pnM;
  protected boolean pnN;
  protected boolean pnO;
  protected String username;
  
  public a(Object paramObject)
  {
    super(5, paramObject);
  }
  
  public final void a(Context paramContext, com.tencent.mm.ui.base.sortview.a.a parama, Object... paramVarArgs)
  {
    Object localObject = null;
    AppMethodBeat.i(5605);
    if (this.OZN)
    {
      AppMethodBeat.o(5605);
      return;
    }
    if ((paramContext == null) || (parama == null) || (this.data == null))
    {
      Log.e("MicroMsg.BizContactDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
      AppMethodBeat.o(5605);
      return;
    }
    if (!(parama instanceof a))
    {
      Log.e("MicroMsg.BizContactDataItem", "The DataItem is not a instance of BizContactViewHolder.");
      AppMethodBeat.o(5605);
      return;
    }
    if (!(this.data instanceof sb))
    {
      Log.e("MicroMsg.BizContactDataItem", "The ViewHolder is not a instance of BusinessResultItem.");
      AppMethodBeat.o(5605);
      return;
    }
    a locala = (a)parama;
    parama = (sb)this.data;
    if ((parama.KZG == null) || (parama.KZG.KZe == null))
    {
      Log.e("MicroMsg.BizContactDataItem", "The brItem.ContactItem or brItem.ContactItem.ContactItem is null.");
      AppMethodBeat.o(5605);
      return;
    }
    dso localdso = parama.KZG.KZe;
    parama = parama.KZG.KZb;
    if ((paramVarArgs != null) && (paramVarArgs.length > 1) && ((paramVarArgs[1] instanceof List))) {
      this.pqn = ((List)paramVarArgs[1]);
    }
    this.username = localdso.Lqk.MTo;
    this.iconUrl = localdso.Lis;
    if (parama == null) {
      parama = "";
    }
    for (;;)
    {
      this.pnL = parama;
      if (localdso.Mjj == null) {
        parama = null;
      }
      try
      {
        paramVarArgs = this.pqn;
        locala.gwR.getTextSize();
        this.nickName = d.c(paramContext, parama, paramVarArgs);
        paramVarArgs = localdso.Lqk.MTo;
        aer localaer = localdso.MUR;
        if (localaer != null)
        {
          parama = new com.tencent.mm.api.c();
          parama.field_username = paramVarArgs;
          d.a(parama, localaer);
          paramVarArgs = localObject;
          if (parama != null)
          {
            paramVarArgs = localObject;
            if (parama.cG(false) != null) {
              paramVarArgs = parama.cG(false).Va();
            }
          }
          if (paramVarArgs != null)
          {
            if ((parama.cG(false).Vc()) && (!Util.isNullOrNil(paramVarArgs.diq)))
            {
              bool = true;
              this.pnO = bool;
              if (localdso.MmK == 0) {
                break label639;
              }
              bool = true;
              this.pnN = bool;
            }
          }
          else
          {
            Log.v("MicroMsg.BizContactDataItem", "verifyFlag : %d", new Object[] { Integer.valueOf(localdso.MmK) });
            parama = localdso.ked;
            if ((this.pqn.size() <= 0) || (parama == null) || (!parama.toLowerCase().equals(((String)this.pqn.get(0)).toLowerCase()))) {}
          }
        }
      }
      catch (Exception parama)
      {
        for (;;)
        {
          try
          {
            paramVarArgs = this.pqn;
            locala.pnT.getTextSize();
            this.pnM = d.c(paramContext, parama, paramVarArgs);
            this.pnM = TextUtils.concat(new CharSequence[] { paramContext.getResources().getString(2131765071), this.pnM });
            if ((this.pnM != null) && (this.pnM.length() != 0) && (this.pnL != null)) {
              if (this.pnL.length() != 0) {
                continue;
              }
            }
          }
          catch (Exception parama)
          {
            try
            {
              parama = localdso.keb;
              paramVarArgs = this.pqn;
              locala.pnR.getTextSize();
              this.pnK = d.c(paramContext, parama, paramVarArgs);
              Log.d("MicroMsg.BizContactDataItem", "nickName : %s, followFriends : %s.", new Object[] { this.nickName, this.pnL });
              this.OZN = true;
              AppMethodBeat.o(5605);
              return;
              parama = parama.KZl;
              break;
              parama = localdso.Mjj.MTo;
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
              this.pnM = "";
            }
            catch (Exception paramContext)
            {
              this.pnK = "";
              continue;
            }
          }
          parama = null;
        }
      }
    }
  }
  
  public final com.tencent.mm.ui.base.sortview.a.b clS()
  {
    AppMethodBeat.i(5603);
    if (pnJ == null) {
      pnJ = new b();
    }
    b localb = pnJ;
    AppMethodBeat.o(5603);
    return localb;
  }
  
  public final com.tencent.mm.ui.base.sortview.a.a clT()
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
    public TextView gwR;
    public TextView pnP;
    public View pnQ;
    public TextView pnR;
    public TextView pnS;
    public TextView pnT;
    View pnU;
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
        Log.e("MicroMsg.BizContactDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
        AppMethodBeat.o(5601);
        return;
      }
      if (!(parama instanceof a.a))
      {
        Log.e("MicroMsg.BizContactDataItem", "The DataItem is not a instance of BizContactViewHolder.");
        AppMethodBeat.o(5601);
        return;
      }
      if (!(paramVarArgs instanceof a))
      {
        Log.e("MicroMsg.BizContactDataItem", "The ViewHolder is not a instance of BusinessResultItem.");
        AppMethodBeat.o(5601);
        return;
      }
      paramContext = (a.a)parama;
      parama = (a)paramVarArgs;
      paramContext.username = parama.username;
      paramContext.iconUrl = parama.iconUrl;
      com.tencent.mm.pluginsdk.ui.a.b.d(paramContext.gvv, parama.username);
      paramVarArgs = paramContext.pnQ;
      int i;
      if (parama.pnN)
      {
        i = 0;
        paramVarArgs.setVisibility(i);
        paramVarArgs = paramContext.pnU;
        i = j;
        if (parama.pnO) {
          i = 0;
        }
        paramVarArgs.setVisibility(i);
        d.c(paramContext.gwR, parama.nickName);
        boolean bool1 = d.c(paramContext.pnT, parama.pnM);
        boolean bool2 = d.c(paramContext.pnS, parama.pnL);
        if (d.c(paramContext.pnR, parama.pnK))
        {
          if ((bool1) || (bool2)) {
            break label277;
          }
          paramContext.pnR.setMaxLines(2);
        }
      }
      for (;;)
      {
        Log.d("MicroMsg.BizContactDataItem", "fillingView , nickName : %s, followFriends : %s.", new Object[] { parama.nickName, parama.pnL });
        AppMethodBeat.o(5601);
        return;
        i = 8;
        break;
        label277:
        paramContext.pnR.setMaxLines(1);
      }
    }
    
    public final void a(View paramView, com.tencent.mm.ui.base.sortview.a.a parama)
    {
      AppMethodBeat.i(5602);
      if ((paramView != null) && (parama != null) && ((parama instanceof a.a)))
      {
        parama = (a.a)parama;
        parama.pnP = ((TextView)paramView.findViewById(2131299162));
        parama.pnU = paramView.findViewById(2131297432);
        parama.gvv = ((ImageView)paramView.findViewById(2131297120));
        parama.gwR = ((TextView)paramView.findViewById(2131305437));
        parama.pnQ = paramView.findViewById(2131309689);
        parama.pnS = ((TextView)paramView.findViewById(2131301645));
        parama.pnR = ((TextView)paramView.findViewById(2131302698));
        parama.pnT = ((TextView)paramView.findViewById(2131310648));
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
      if (!(parama.getData() instanceof sb))
      {
        Log.e("MicroMsg.BizContactDataItem", "The DataItem is not a instance of BusinessResultItem.");
        AppMethodBeat.o(5599);
        return false;
      }
      Object localObject3 = (sb)parama.getData();
      if ((((sb)localObject3).KZG == null) || (((sb)localObject3).KZG.KZe == null))
      {
        Log.e("MicroMsg.BizContactDataItem", "The brItem.ContactItem or brItem.ContactItem.ContactItem is null.");
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
        Object localObject4 = ((sb)localObject3).KZG.xIy;
        dso localdso = ((sb)localObject3).KZG.KZe;
        if (localdso.Mjj != null)
        {
          localObject3 = localdso.Mjj.MTo;
          if (localdso.Lqk == null) {
            break label269;
          }
        }
        label269:
        for (str = localdso.Lqk.MTo;; str = null)
        {
          if (!Util.isNullOrNil(str)) {
            break label275;
          }
          Log.e("MicroMsg.BizContactDataItem", "onItemClick but username is null");
          AppMethodBeat.o(5599);
          return false;
          localObject3 = null;
          break;
        }
        label275:
        am.aXh(str);
        if (!Util.isNullOrNil((String)localObject4))
        {
          i = 8;
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("rawUrl", (String)localObject4);
          ((Intent)localObject1).putExtra("useJs", true);
          ((Intent)localObject1).putExtra("vertical_scroll", true);
          com.tencent.mm.br.c.b(paramContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
        }
        for (;;)
        {
          paramContext = locala.cmj();
          if ((paramContext != null) && (paramVarArgs != null)) {
            paramContext.a(paramVarArgs, parama, i, str, locala.cmk(), locala.getPosition());
          }
          AppMethodBeat.o(5599);
          return true;
          as localas = ((l)g.af(l.class)).aSN().Kn(str);
          localObject4 = new Intent();
          Bundle localBundle = new Bundle();
          localBundle.putString("Contact_Ext_Args_Search_Id", (String)localObject1);
          localBundle.putInt("Contact_Ext_Args_Index", locala.cmk());
          localBundle.putString("Contact_Ext_Args_Query_String", "");
          localBundle.putInt("Contact_Scene", i);
          ((Intent)localObject4).putExtra("Contact_Ext_Args", localBundle);
          ((Intent)localObject4).putExtra("Contact_User", str);
          ((Intent)localObject4).putExtra("Contact_Scene", i);
          if (!com.tencent.mm.contact.c.oR(localas.field_type))
          {
            ((Intent)localObject4).putExtra("Contact_Alias", localdso.ked);
            ((Intent)localObject4).putExtra("Contact_Nick", (String)localObject3);
            ((Intent)localObject4).putExtra("Contact_Signature", localdso.keb);
            ((Intent)localObject4).putExtra("Contact_RegionCode", RegionCodeDecoder.bq(localdso.keh, localdso.kdZ, localdso.kea));
            ((Intent)localObject4).putExtra("Contact_Sex", localdso.kdY);
            ((Intent)localObject4).putExtra("Contact_VUser_Info", localdso.MmL);
            ((Intent)localObject4).putExtra("Contact_VUser_Info_Flag", localdso.MmK);
            ((Intent)localObject4).putExtra("Contact_KWeibo_flag", localdso.MmO);
            ((Intent)localObject4).putExtra("Contact_KWeibo", localdso.MmM);
            ((Intent)localObject4).putExtra("Contact_KWeiboNick", localdso.MmN);
            if (localdso.MUR == null) {}
          }
          try
          {
            ((Intent)localObject4).putExtra("Contact_customInfo", localdso.MUR.toByteArray());
            b.jRt.c((Intent)localObject4, paramContext);
            i = 1;
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.BizContactDataItem", localIOException, "", new Object[0]);
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
        localView = View.inflate(paramContext, 2131496186, null);
      }
      AppMethodBeat.o(5600);
      return localView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.a
 * JD-Core Version:    0.7.0.1
 */