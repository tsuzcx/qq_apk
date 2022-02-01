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
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.contact.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.brandservice.b;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.brandservice.d.i;
import com.tencent.mm.plugin.brandservice.model.e;
import com.tencent.mm.plugin.brandservice.model.e.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.websearch.api.an;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.ahm;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.ewb;
import com.tencent.mm.protocal.protobuf.sx;
import com.tencent.mm.protocal.protobuf.sz;
import com.tencent.mm.protocal.protobuf.tf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import java.io.IOException;
import java.util.List;

public final class a
  extends com.tencent.mm.plugin.brandservice.ui.base.a
{
  private static b vCq;
  protected String iconUrl;
  protected CharSequence nickName;
  protected String username;
  protected CharSequence vCr;
  protected CharSequence vCs;
  protected CharSequence vCt;
  protected boolean vCu;
  protected boolean vCv;
  
  public a(Object paramObject)
  {
    super(5, paramObject);
  }
  
  public final void a(Context paramContext, com.tencent.mm.ui.base.sortview.a.a parama, Object... paramVarArgs)
  {
    Object localObject = null;
    AppMethodBeat.i(5605);
    if (this.aeau)
    {
      AppMethodBeat.o(5605);
      return;
    }
    if ((paramContext == null) || (parama == null) || (this.cpt == null))
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
    if (!(this.cpt instanceof tf))
    {
      Log.e("MicroMsg.BizContactDataItem", "The ViewHolder is not a instance of BusinessResultItem.");
      AppMethodBeat.o(5605);
      return;
    }
    a locala = (a)parama;
    parama = (tf)this.cpt;
    if ((parama.YYO == null) || (parama.YYO.YYm == null))
    {
      Log.e("MicroMsg.BizContactDataItem", "The brItem.ContactItem or brItem.ContactItem.ContactItem is null.");
      AppMethodBeat.o(5605);
      return;
    }
    ewb localewb = parama.YYO.YYm;
    parama = parama.YYO.YYj;
    if ((paramVarArgs != null) && (paramVarArgs.length > 1) && ((paramVarArgs[1] instanceof List))) {
      this.vER = ((List)paramVarArgs[1]);
    }
    this.username = localewb.ZqL.abwM;
    this.iconUrl = localewb.ZhP;
    if (parama == null) {
      parama = "";
    }
    for (;;)
    {
      this.vCs = parama;
      if (localewb.aaIz == null) {
        parama = null;
      }
      try
      {
        paramVarArgs = this.vER;
        locala.lDe.getTextSize();
        this.nickName = e.b(paramContext, parama, paramVarArgs);
        paramVarArgs = localewb.ZqL.abwM;
        ahm localahm = localewb.abyE;
        if (localahm != null)
        {
          parama = new com.tencent.mm.api.c();
          parama.field_username = paramVarArgs;
          e.a(parama, localahm);
          paramVarArgs = localObject;
          if (parama != null)
          {
            paramVarArgs = localObject;
            if (parama.dO(false) != null) {
              paramVarArgs = parama.dO(false).aBk();
            }
          }
          if (paramVarArgs != null)
          {
            if ((parama.dO(false).aBm()) && (!Util.isNullOrNil(paramVarArgs.hdy)))
            {
              bool = true;
              this.vCv = bool;
              if (localewb.aaMm == 0) {
                break label640;
              }
              bool = true;
              this.vCu = bool;
            }
          }
          else
          {
            Log.v("MicroMsg.BizContactDataItem", "verifyFlag : %d", new Object[] { Integer.valueOf(localewb.aaMm) });
            parama = localewb.pSk;
            if ((this.vER.size() <= 0) || (parama == null) || (!parama.toLowerCase().equals(((String)this.vER.get(0)).toLowerCase()))) {}
          }
        }
      }
      catch (Exception parama)
      {
        for (;;)
        {
          try
          {
            paramVarArgs = this.vER;
            locala.vCA.getTextSize();
            this.vCt = e.b(paramContext, parama, paramVarArgs);
            this.vCt = TextUtils.concat(new CharSequence[] { paramContext.getResources().getString(d.i.search_contact_tag_wxid), this.vCt });
            if ((this.vCt != null) && (this.vCt.length() != 0) && (this.vCs != null)) {
              if (this.vCs.length() != 0) {
                continue;
              }
            }
          }
          catch (Exception parama)
          {
            try
            {
              parama = localewb.pSi;
              paramVarArgs = this.vER;
              locala.vCy.getTextSize();
              this.vCr = e.b(paramContext, parama, paramVarArgs);
              Log.d("MicroMsg.BizContactDataItem", "nickName : %s, followFriends : %s.", new Object[] { this.nickName, this.vCs });
              this.aeau = true;
              AppMethodBeat.o(5605);
              return;
              parama = parama.YYt;
              break;
              parama = localewb.aaIz.abwM;
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
              this.vCt = "";
            }
            catch (Exception paramContext)
            {
              this.vCr = "";
              continue;
            }
          }
          parama = null;
        }
      }
    }
  }
  
  public final com.tencent.mm.ui.base.sortview.a.b dco()
  {
    AppMethodBeat.i(5603);
    if (vCq == null) {
      vCq = new b();
    }
    b localb = vCq;
    AppMethodBeat.o(5603);
    return localb;
  }
  
  public final com.tencent.mm.ui.base.sortview.a.a dcp()
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
    public TextView lDe;
    public TextView vCA;
    View vCB;
    public TextView vCw;
    public View vCx;
    public TextView vCy;
    public TextView vCz;
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
      com.tencent.mm.pluginsdk.ui.a.b.h(paramContext.lBC, parama.username);
      paramVarArgs = paramContext.vCx;
      int i;
      if (parama.vCu)
      {
        i = 0;
        paramVarArgs.setVisibility(i);
        paramVarArgs = paramContext.vCB;
        i = j;
        if (parama.vCv) {
          i = 0;
        }
        paramVarArgs.setVisibility(i);
        e.c(paramContext.lDe, parama.nickName);
        boolean bool1 = e.c(paramContext.vCA, parama.vCt);
        boolean bool2 = e.c(paramContext.vCz, parama.vCs);
        if (e.c(paramContext.vCy, parama.vCr))
        {
          if ((bool1) || (bool2)) {
            break label277;
          }
          paramContext.vCy.setMaxLines(2);
        }
      }
      for (;;)
      {
        Log.d("MicroMsg.BizContactDataItem", "fillingView , nickName : %s, followFriends : %s.", new Object[] { parama.nickName, parama.vCs });
        AppMethodBeat.o(5601);
        return;
        i = 8;
        break;
        label277:
        paramContext.vCy.setMaxLines(1);
      }
    }
    
    public final void a(View paramView, com.tencent.mm.ui.base.sortview.a.a parama)
    {
      AppMethodBeat.i(5602);
      if ((paramView != null) && (parama != null) && ((parama instanceof a.a)))
      {
        parama = (a.a)parama;
        parama.vCw = ((TextView)paramView.findViewById(d.e.contactitem_catalog));
        parama.vCB = paramView.findViewById(d.e.bizTrademarkProtectionIV);
        parama.lBC = ((ImageView)paramView.findViewById(d.e.avatarIV));
        parama.lDe = ((TextView)paramView.findViewById(d.e.nicknameTV));
        parama.vCx = paramView.findViewById(d.e.verifyIV);
        parama.vCz = ((TextView)paramView.findViewById(d.e.followFriendTV));
        parama.vCy = ((TextView)paramView.findViewById(d.e.introduceTV));
        parama.vCA = ((TextView)paramView.findViewById(d.e.wxidTV));
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
      if (!(parama.getData() instanceof tf))
      {
        Log.e("MicroMsg.BizContactDataItem", "The DataItem is not a instance of BusinessResultItem.");
        AppMethodBeat.o(5599);
        return false;
      }
      Object localObject3 = (tf)parama.getData();
      if ((((tf)localObject3).YYO == null) || (((tf)localObject3).YYO.YYm == null))
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
        Object localObject4 = ((tf)localObject3).YYO.IGI;
        ewb localewb = ((tf)localObject3).YYO.YYm;
        if (localewb.aaIz != null)
        {
          localObject3 = localewb.aaIz.abwM;
          if (localewb.ZqL == null) {
            break label269;
          }
        }
        label269:
        for (str = localewb.ZqL.abwM;; str = null)
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
        an.biA(str);
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
          paramContext = locala.dcF();
          if ((paramContext != null) && (paramVarArgs != null)) {
            paramContext.a(paramVarArgs, parama, i, str, locala.dcG(), locala.getPosition());
          }
          AppMethodBeat.o(5599);
          return true;
          au localau = ((n)h.ax(n.class)).bzA().JE(str);
          localObject4 = new Intent();
          Bundle localBundle = new Bundle();
          localBundle.putString("Contact_Ext_Args_Search_Id", (String)localObject1);
          localBundle.putInt("Contact_Ext_Args_Index", locala.dcG());
          localBundle.putString("Contact_Ext_Args_Query_String", "");
          localBundle.putInt("Contact_Scene", i);
          ((Intent)localObject4).putExtra("Contact_Ext_Args", localBundle);
          ((Intent)localObject4).putExtra("Contact_User", str);
          ((Intent)localObject4).putExtra("Contact_Scene", i);
          if (!d.rs(localau.field_type))
          {
            ((Intent)localObject4).putExtra("Contact_Alias", localewb.pSk);
            ((Intent)localObject4).putExtra("Contact_Nick", (String)localObject3);
            ((Intent)localObject4).putExtra("Contact_Signature", localewb.pSi);
            ((Intent)localObject4).putExtra("Contact_RegionCode", RegionCodeDecoder.bI(localewb.pSo, localewb.pSg, localewb.pSh));
            ((Intent)localObject4).putExtra("Contact_Sex", localewb.pSf);
            ((Intent)localObject4).putExtra("Contact_VUser_Info", localewb.aaMn);
            ((Intent)localObject4).putExtra("Contact_VUser_Info_Flag", localewb.aaMm);
            ((Intent)localObject4).putExtra("Contact_KWeibo_flag", localewb.aaMq);
            ((Intent)localObject4).putExtra("Contact_KWeibo", localewb.aaMo);
            ((Intent)localObject4).putExtra("Contact_KWeiboNick", localewb.aaMp);
            if (localewb.abyE == null) {}
          }
          try
          {
            ((Intent)localObject4).putExtra("Contact_customInfo", localewb.abyE.toByteArray());
            b.pFn.c((Intent)localObject4, paramContext);
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
        localView = View.inflate(paramContext, d.f.search_or_recommend_biz_item, null);
      }
      AppMethodBeat.o(5600);
      return localView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.a
 * JD-Core Version:    0.7.0.1
 */