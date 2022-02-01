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
import com.tencent.mm.contact.d;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.brandservice.b;
import com.tencent.mm.plugin.brandservice.b.e;
import com.tencent.mm.plugin.brandservice.b.e.a;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.brandservice.d.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.afa;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.eck;
import com.tencent.mm.protocal.protobuf.rm;
import com.tencent.mm.protocal.protobuf.ro;
import com.tencent.mm.protocal.protobuf.ru;
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
  private static b swJ;
  protected String iconUrl;
  protected CharSequence nickName;
  protected CharSequence swK;
  protected CharSequence swL;
  protected CharSequence swM;
  protected boolean swN;
  protected boolean swO;
  protected String username;
  
  public a(Object paramObject)
  {
    super(5, paramObject);
  }
  
  public final void a(Context paramContext, com.tencent.mm.ui.base.sortview.a.a parama, Object... paramVarArgs)
  {
    Object localObject = null;
    AppMethodBeat.i(5605);
    if (this.Wta)
    {
      AppMethodBeat.o(5605);
      return;
    }
    if ((paramContext == null) || (parama == null) || (this.bnW == null))
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
    if (!(this.bnW instanceof ru))
    {
      Log.e("MicroMsg.BizContactDataItem", "The ViewHolder is not a instance of BusinessResultItem.");
      AppMethodBeat.o(5605);
      return;
    }
    a locala = (a)parama;
    parama = (ru)this.bnW;
    if ((parama.SaP == null) || (parama.SaP.San == null))
    {
      Log.e("MicroMsg.BizContactDataItem", "The brItem.ContactItem or brItem.ContactItem.ContactItem is null.");
      AppMethodBeat.o(5605);
      return;
    }
    eck localeck = parama.SaP.San;
    parama = parama.SaP.Sak;
    if ((paramVarArgs != null) && (paramVarArgs.length > 1) && ((paramVarArgs[1] instanceof List))) {
      this.szm = ((List)paramVarArgs[1]);
    }
    this.username = localeck.SrH.Ufy;
    this.iconUrl = localeck.SjJ;
    if (parama == null) {
      parama = "";
    }
    for (;;)
    {
      this.swL = parama;
      if (localeck.TtX == null) {
        parama = null;
      }
      try
      {
        paramVarArgs = this.szm;
        locala.jbe.getTextSize();
        this.nickName = e.b(paramContext, parama, paramVarArgs);
        paramVarArgs = localeck.SrH.Ufy;
        afa localafa = localeck.Uhb;
        if (localafa != null)
        {
          parama = new com.tencent.mm.api.c();
          parama.field_username = paramVarArgs;
          e.a(parama, localafa);
          paramVarArgs = localObject;
          if (parama != null)
          {
            paramVarArgs = localObject;
            if (parama.dc(false) != null) {
              paramVarArgs = parama.dc(false).Zs();
            }
          }
          if (paramVarArgs != null)
          {
            if ((parama.dc(false).Zu()) && (!Util.isNullOrNil(paramVarArgs.eZX)))
            {
              bool = true;
              this.swO = bool;
              if (localeck.TxF == 0) {
                break label640;
              }
              bool = true;
              this.swN = bool;
            }
          }
          else
          {
            Log.v("MicroMsg.BizContactDataItem", "verifyFlag : %d", new Object[] { Integer.valueOf(localeck.TxF) });
            parama = localeck.mVD;
            if ((this.szm.size() <= 0) || (parama == null) || (!parama.toLowerCase().equals(((String)this.szm.get(0)).toLowerCase()))) {}
          }
        }
      }
      catch (Exception parama)
      {
        for (;;)
        {
          try
          {
            paramVarArgs = this.szm;
            locala.swT.getTextSize();
            this.swM = e.b(paramContext, parama, paramVarArgs);
            this.swM = TextUtils.concat(new CharSequence[] { paramContext.getResources().getString(d.i.search_contact_tag_wxid), this.swM });
            if ((this.swM != null) && (this.swM.length() != 0) && (this.swL != null)) {
              if (this.swL.length() != 0) {
                continue;
              }
            }
          }
          catch (Exception parama)
          {
            try
            {
              parama = localeck.mVB;
              paramVarArgs = this.szm;
              locala.swR.getTextSize();
              this.swK = e.b(paramContext, parama, paramVarArgs);
              Log.d("MicroMsg.BizContactDataItem", "nickName : %s, followFriends : %s.", new Object[] { this.nickName, this.swL });
              this.Wta = true;
              AppMethodBeat.o(5605);
              return;
              parama = parama.Sau;
              break;
              parama = localeck.TtX.Ufy;
              continue;
              parama = parama;
              this.nickName = "";
              continue;
              boolean bool = false;
              continue;
              label640:
              bool = false;
              continue;
              parama = parama;
              this.swM = "";
            }
            catch (Exception paramContext)
            {
              this.swK = "";
              continue;
            }
          }
          parama = null;
        }
      }
    }
  }
  
  public final com.tencent.mm.ui.base.sortview.a.b czw()
  {
    AppMethodBeat.i(5603);
    if (swJ == null) {
      swJ = new b();
    }
    b localb = swJ;
    AppMethodBeat.o(5603);
    return localb;
  }
  
  public final com.tencent.mm.ui.base.sortview.a.a czx()
  {
    AppMethodBeat.i(5604);
    a locala = new a();
    AppMethodBeat.o(5604);
    return locala;
  }
  
  public static final class a
    extends e.a
    implements com.tencent.mm.ui.base.sortview.a.a
  {
    public TextView jbe;
    public TextView swP;
    public View swQ;
    public TextView swR;
    public TextView swS;
    public TextView swT;
    View swU;
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
      com.tencent.mm.pluginsdk.ui.a.b.d(paramContext.iZG, parama.username);
      paramVarArgs = paramContext.swQ;
      int i;
      if (parama.swN)
      {
        i = 0;
        paramVarArgs.setVisibility(i);
        paramVarArgs = paramContext.swU;
        i = j;
        if (parama.swO) {
          i = 0;
        }
        paramVarArgs.setVisibility(i);
        e.c(paramContext.jbe, parama.nickName);
        boolean bool1 = e.c(paramContext.swT, parama.swM);
        boolean bool2 = e.c(paramContext.swS, parama.swL);
        if (e.c(paramContext.swR, parama.swK))
        {
          if ((bool1) || (bool2)) {
            break label277;
          }
          paramContext.swR.setMaxLines(2);
        }
      }
      for (;;)
      {
        Log.d("MicroMsg.BizContactDataItem", "fillingView , nickName : %s, followFriends : %s.", new Object[] { parama.nickName, parama.swL });
        AppMethodBeat.o(5601);
        return;
        i = 8;
        break;
        label277:
        paramContext.swR.setMaxLines(1);
      }
    }
    
    public final void a(View paramView, com.tencent.mm.ui.base.sortview.a.a parama)
    {
      AppMethodBeat.i(5602);
      if ((paramView != null) && (parama != null) && ((parama instanceof a.a)))
      {
        parama = (a.a)parama;
        parama.swP = ((TextView)paramView.findViewById(d.e.dCx));
        parama.swU = paramView.findViewById(d.e.dti);
        parama.iZG = ((ImageView)paramView.findViewById(d.e.dsd));
        parama.jbe = ((TextView)paramView.findViewById(d.e.dPq));
        parama.swQ = paramView.findViewById(d.e.dYC);
        parama.swS = ((TextView)paramView.findViewById(d.e.srS));
        parama.swR = ((TextView)paramView.findViewById(d.e.dJj));
        parama.swT = ((TextView)paramView.findViewById(d.e.stD));
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
      if (!(parama.getData() instanceof ru))
      {
        Log.e("MicroMsg.BizContactDataItem", "The DataItem is not a instance of BusinessResultItem.");
        AppMethodBeat.o(5599);
        return false;
      }
      Object localObject3 = (ru)parama.getData();
      if ((((ru)localObject3).SaP == null) || (((ru)localObject3).SaP.San == null))
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
        Object localObject4 = ((ru)localObject3).SaP.CMD;
        eck localeck = ((ru)localObject3).SaP.San;
        if (localeck.TtX != null)
        {
          localObject3 = localeck.TtX.Ufy;
          if (localeck.SrH == null) {
            break label269;
          }
        }
        label269:
        for (str = localeck.SrH.Ufy;; str = null)
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
        am.biS(str);
        if (!Util.isNullOrNil((String)localObject4))
        {
          i = 8;
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("rawUrl", (String)localObject4);
          ((Intent)localObject1).putExtra("useJs", true);
          ((Intent)localObject1).putExtra("vertical_scroll", true);
          com.tencent.mm.by.c.b(paramContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
        }
        for (;;)
        {
          paramContext = locala.czN();
          if ((paramContext != null) && (paramVarArgs != null)) {
            paramContext.a(paramVarArgs, parama, i, str, locala.czO(), locala.getPosition());
          }
          AppMethodBeat.o(5599);
          return true;
          as localas = ((n)h.ae(n.class)).bbL().RG(str);
          localObject4 = new Intent();
          Bundle localBundle = new Bundle();
          localBundle.putString("Contact_Ext_Args_Search_Id", (String)localObject1);
          localBundle.putInt("Contact_Ext_Args_Index", locala.czO());
          localBundle.putString("Contact_Ext_Args_Query_String", "");
          localBundle.putInt("Contact_Scene", i);
          ((Intent)localObject4).putExtra("Contact_Ext_Args", localBundle);
          ((Intent)localObject4).putExtra("Contact_User", str);
          ((Intent)localObject4).putExtra("Contact_Scene", i);
          if (!d.rk(localas.field_type))
          {
            ((Intent)localObject4).putExtra("Contact_Alias", localeck.mVD);
            ((Intent)localObject4).putExtra("Contact_Nick", (String)localObject3);
            ((Intent)localObject4).putExtra("Contact_Signature", localeck.mVB);
            ((Intent)localObject4).putExtra("Contact_RegionCode", RegionCodeDecoder.bl(localeck.mVH, localeck.mVz, localeck.mVA));
            ((Intent)localObject4).putExtra("Contact_Sex", localeck.mVy);
            ((Intent)localObject4).putExtra("Contact_VUser_Info", localeck.TxG);
            ((Intent)localObject4).putExtra("Contact_VUser_Info_Flag", localeck.TxF);
            ((Intent)localObject4).putExtra("Contact_KWeibo_flag", localeck.TxJ);
            ((Intent)localObject4).putExtra("Contact_KWeibo", localeck.TxH);
            ((Intent)localObject4).putExtra("Contact_KWeiboNick", localeck.TxI);
            if (localeck.Uhb == null) {}
          }
          try
          {
            ((Intent)localObject4).putExtra("Contact_customInfo", localeck.Uhb.toByteArray());
            b.mIG.c((Intent)localObject4, paramContext);
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
        localView = View.inflate(paramContext, d.f.ekH, null);
      }
      AppMethodBeat.o(5600);
      return localView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.a
 * JD-Core Version:    0.7.0.1
 */