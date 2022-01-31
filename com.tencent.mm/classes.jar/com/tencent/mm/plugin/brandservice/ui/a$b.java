package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.br.d;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.plugin.brandservice.b.e;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.bof;
import com.tencent.mm.protocal.c.kp;
import com.tencent.mm.protocal.c.kw;
import com.tencent.mm.protocal.c.sh;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.io.IOException;

public final class a$b
  extends com.tencent.mm.ui.base.sortview.a.b
{
  public final void a(Context paramContext, com.tencent.mm.ui.base.sortview.a.a parama, com.tencent.mm.ui.base.sortview.a paramVarArgs)
  {
    int j = 8;
    if ((paramContext == null) || (parama == null) || (paramVarArgs == null) || (paramVarArgs.data == null))
    {
      y.e("MicroMsg.BizContactDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
      return;
    }
    if (!(parama instanceof a.a))
    {
      y.e("MicroMsg.BizContactDataItem", "The DataItem is not a instance of BizContactViewHolder.");
      return;
    }
    if (!(paramVarArgs instanceof a))
    {
      y.e("MicroMsg.BizContactDataItem", "The ViewHolder is not a instance of BusinessResultItem.");
      return;
    }
    paramContext = (a.a)parama;
    parama = (a)paramVarArgs;
    paramContext.username = parama.username;
    paramContext.iconUrl = parama.iconUrl;
    com.tencent.mm.pluginsdk.ui.a.b.n(paramContext.doU, parama.username);
    paramVarArgs = paramContext.icm;
    int i;
    if (parama.icj)
    {
      i = 0;
      paramVarArgs.setVisibility(i);
      paramVarArgs = paramContext.icq;
      i = j;
      if (parama.ick) {
        i = 0;
      }
      paramVarArgs.setVisibility(i);
      com.tencent.mm.plugin.brandservice.b.a.b(paramContext.drB, parama.nickName);
      boolean bool1 = com.tencent.mm.plugin.brandservice.b.a.b(paramContext.icp, parama.ici);
      boolean bool2 = com.tencent.mm.plugin.brandservice.b.a.b(paramContext.ico, parama.ich);
      if (com.tencent.mm.plugin.brandservice.b.a.b(paramContext.icn, parama.icg))
      {
        if ((bool1) || (bool2)) {
          break label247;
        }
        paramContext.icn.setMaxLines(2);
      }
    }
    for (;;)
    {
      y.d("MicroMsg.BizContactDataItem", "fillingView , nickName : %s, followFriends : %s.", new Object[] { parama.nickName, parama.ich });
      return;
      i = 8;
      break;
      label247:
      paramContext.icn.setMaxLines(1);
    }
  }
  
  public final void a(View paramView, com.tencent.mm.ui.base.sortview.a.a parama)
  {
    if ((paramView != null) && (parama != null) && ((parama instanceof a.a)))
    {
      parama = (a.a)parama;
      parama.icl = ((TextView)paramView.findViewById(b.d.contactitem_catalog));
      parama.icq = paramView.findViewById(b.d.bizTrademarkProtectionIV);
      parama.doU = ((ImageView)paramView.findViewById(b.d.avatarIV));
      parama.drB = ((TextView)paramView.findViewById(b.d.nicknameTV));
      parama.icm = paramView.findViewById(b.d.verifyIV);
      parama.ico = ((TextView)paramView.findViewById(b.d.followFriendTV));
      parama.icn = ((TextView)paramView.findViewById(b.d.introduceTV));
      parama.icp = ((TextView)paramView.findViewById(b.d.wxidTV));
    }
  }
  
  public final boolean a(Context paramContext, com.tencent.mm.ui.base.sortview.a parama, Object... paramVarArgs)
  {
    if (!(parama instanceof a)) {
      return false;
    }
    a locala = (a)parama;
    if (!(parama.data instanceof kw))
    {
      y.e("MicroMsg.BizContactDataItem", "The DataItem is not a instance of BusinessResultItem.");
      return false;
    }
    Object localObject3 = (kw)parama.data;
    if ((((kw)localObject3).sFU == null) || (((kw)localObject3).sFU.sFA == null))
    {
      y.e("MicroMsg.BizContactDataItem", "The brItem.ContactItem or brItem.ContactItem.ContactItem is null.");
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
          label130:
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
      Object localObject4 = ((kw)localObject3).sFU.kRP;
      bof localbof = ((kw)localObject3).sFU.sFA;
      if (localbof.tmw != null)
      {
        localObject3 = localbof.tmw.tFO;
        if (localbof.sQs == null) {
          break label239;
        }
      }
      label239:
      for (str = localbof.sQs.tFO;; str = null)
      {
        if (!bk.bl(str)) {
          break label245;
        }
        y.e("MicroMsg.BizContactDataItem", "onItemClick but username is null");
        return false;
        localObject3 = null;
        break;
      }
      label245:
      ai.Rx(str);
      if (!bk.bl((String)localObject4))
      {
        i = 8;
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("rawUrl", (String)localObject4);
        ((Intent)localObject1).putExtra("useJs", true);
        ((Intent)localObject1).putExtra("vertical_scroll", true);
        d.b(paramContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
      }
      for (;;)
      {
        paramContext = locala.axH();
        if ((paramContext != null) && (paramVarArgs != null)) {
          paramContext.a(paramVarArgs, parama, i, str, locala.axI(), locala.getPosition());
        }
        return true;
        ad localad = ((j)g.r(j.class)).Fw().abl(str);
        localObject4 = new Intent();
        Bundle localBundle = new Bundle();
        localBundle.putString("Contact_Ext_Args_Search_Id", (String)localObject1);
        localBundle.putInt("Contact_Ext_Args_Index", locala.axI());
        localBundle.putString("Contact_Ext_Args_Query_String", "");
        localBundle.putInt("Contact_Scene", i);
        ((Intent)localObject4).putExtra("Contact_Ext_Args", localBundle);
        ((Intent)localObject4).putExtra("Contact_User", str);
        ((Intent)localObject4).putExtra("Contact_Scene", i);
        if (!com.tencent.mm.n.a.gR(localad.field_type))
        {
          ((Intent)localObject4).putExtra("Contact_Alias", localbof.ffm);
          ((Intent)localObject4).putExtra("Contact_Nick", (String)localObject3);
          ((Intent)localObject4).putExtra("Contact_Signature", localbof.ffk);
          ((Intent)localObject4).putExtra("Contact_RegionCode", RegionCodeDecoder.ao(localbof.ffq, localbof.ffi, localbof.ffj));
          ((Intent)localObject4).putExtra("Contact_Sex", localbof.ffh);
          ((Intent)localObject4).putExtra("Contact_VUser_Info", localbof.tph);
          ((Intent)localObject4).putExtra("Contact_VUser_Info_Flag", localbof.tpg);
          ((Intent)localObject4).putExtra("Contact_KWeibo_flag", localbof.tpk);
          ((Intent)localObject4).putExtra("Contact_KWeibo", localbof.tpi);
          ((Intent)localObject4).putExtra("Contact_KWeiboNick", localbof.tpj);
          if (localbof.tGL == null) {}
        }
        try
        {
          ((Intent)localObject4).putExtra("Contact_customInfo", localbof.tGL.toByteArray());
          com.tencent.mm.plugin.brandservice.a.eUR.d((Intent)localObject4, paramContext);
          i = 1;
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            y.printErrStackTrace("MicroMsg.BizContactDataItem", localIOException, "", new Object[0]);
          }
        }
      }
      paramVarArgs = localIOException;
      Object localObject2 = str;
      continue;
      i = 0;
      break label130;
      localObject2 = null;
      break;
      i = 0;
      paramVarArgs = localObject2;
      localObject2 = str;
    }
  }
  
  public final View b(Context paramContext, View paramView)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = View.inflate(paramContext, b.e.search_or_recommend_biz_item, null);
    }
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.a.b
 * JD-Core Version:    0.7.0.1
 */