package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.bya;
import com.tencent.mm.protocal.protobuf.nb;
import com.tencent.mm.protocal.protobuf.ni;
import com.tencent.mm.protocal.protobuf.wd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
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
    AppMethodBeat.i(13863);
    if ((paramContext == null) || (parama == null) || (paramVarArgs == null) || (paramVarArgs.getData() == null))
    {
      ab.e("MicroMsg.BizContactDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
      AppMethodBeat.o(13863);
      return;
    }
    if (!(parama instanceof a.a))
    {
      ab.e("MicroMsg.BizContactDataItem", "The DataItem is not a instance of BizContactViewHolder.");
      AppMethodBeat.o(13863);
      return;
    }
    if (!(paramVarArgs instanceof a))
    {
      ab.e("MicroMsg.BizContactDataItem", "The ViewHolder is not a instance of BusinessResultItem.");
      AppMethodBeat.o(13863);
      return;
    }
    paramContext = (a.a)parama;
    parama = (a)paramVarArgs;
    paramContext.username = parama.username;
    paramContext.iconUrl = parama.iconUrl;
    com.tencent.mm.pluginsdk.ui.a.b.s(paramContext.egq, parama.username);
    paramVarArgs = paramContext.jTc;
    int i;
    if (parama.jSZ)
    {
      i = 0;
      paramVarArgs.setVisibility(i);
      paramVarArgs = paramContext.jTg;
      i = j;
      if (parama.jTa) {
        i = 0;
      }
      paramVarArgs.setVisibility(i);
      com.tencent.mm.plugin.brandservice.b.a.b(paramContext.ejj, parama.nickName);
      boolean bool1 = com.tencent.mm.plugin.brandservice.b.a.b(paramContext.jTf, parama.jSY);
      boolean bool2 = com.tencent.mm.plugin.brandservice.b.a.b(paramContext.jTe, parama.jSX);
      if (com.tencent.mm.plugin.brandservice.b.a.b(paramContext.jTd, parama.jSW))
      {
        if ((bool1) || (bool2)) {
          break label277;
        }
        paramContext.jTd.setMaxLines(2);
      }
    }
    for (;;)
    {
      ab.d("MicroMsg.BizContactDataItem", "fillingView , nickName : %s, followFriends : %s.", new Object[] { parama.nickName, parama.jSX });
      AppMethodBeat.o(13863);
      return;
      i = 8;
      break;
      label277:
      paramContext.jTd.setMaxLines(1);
    }
  }
  
  public final void a(View paramView, com.tencent.mm.ui.base.sortview.a.a parama)
  {
    AppMethodBeat.i(13864);
    if ((paramView != null) && (parama != null) && ((parama instanceof a.a)))
    {
      parama = (a.a)parama;
      parama.jTb = ((TextView)paramView.findViewById(2131821089));
      parama.jTg = paramView.findViewById(2131824396);
      parama.egq = ((ImageView)paramView.findViewById(2131823768));
      parama.ejj = ((TextView)paramView.findViewById(2131824394));
      parama.jTc = paramView.findViewById(2131824397);
      parama.jTe = ((TextView)paramView.findViewById(2131824401));
      parama.jTd = ((TextView)paramView.findViewById(2131824399));
      parama.jTf = ((TextView)paramView.findViewById(2131824398));
    }
    AppMethodBeat.o(13864);
  }
  
  public final boolean a(Context paramContext, com.tencent.mm.ui.base.sortview.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(13861);
    if (!(parama instanceof a))
    {
      AppMethodBeat.o(13861);
      return false;
    }
    a locala = (a)parama;
    if (!(parama.getData() instanceof ni))
    {
      ab.e("MicroMsg.BizContactDataItem", "The DataItem is not a instance of BusinessResultItem.");
      AppMethodBeat.o(13861);
      return false;
    }
    Object localObject3 = (ni)parama.getData();
    if ((((ni)localObject3).wCo == null) || (((ni)localObject3).wCo.wBU == null))
    {
      ab.e("MicroMsg.BizContactDataItem", "The brItem.ContactItem or brItem.ContactItem.ContactItem is null.");
      AppMethodBeat.o(13861);
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
      Object localObject4 = ((ni)localObject3).wCo.npR;
      bya localbya = ((ni)localObject3).wCo.wBU;
      if (localbya.xmi != null)
      {
        localObject3 = localbya.xmi.xJE;
        if (localbya.wOT == null) {
          break label269;
        }
      }
      label269:
      for (str = localbya.wOT.xJE;; str = null)
      {
        if (!bo.isNullOrNil(str)) {
          break label275;
        }
        ab.e("MicroMsg.BizContactDataItem", "onItemClick but username is null");
        AppMethodBeat.o(13861);
        return false;
        localObject3 = null;
        break;
      }
      label275:
      ai.agy(str);
      if (!bo.isNullOrNil((String)localObject4))
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
        paramContext = locala.aWE();
        if ((paramContext != null) && (paramVarArgs != null)) {
          paramContext.a(paramVarArgs, parama, i, str, locala.aWF(), locala.getPosition());
        }
        AppMethodBeat.o(13861);
        return true;
        ad localad = ((j)g.E(j.class)).YA().arw(str);
        localObject4 = new Intent();
        Bundle localBundle = new Bundle();
        localBundle.putString("Contact_Ext_Args_Search_Id", (String)localObject1);
        localBundle.putInt("Contact_Ext_Args_Index", locala.aWF());
        localBundle.putString("Contact_Ext_Args_Query_String", "");
        localBundle.putInt("Contact_Scene", i);
        ((Intent)localObject4).putExtra("Contact_Ext_Args", localBundle);
        ((Intent)localObject4).putExtra("Contact_User", str);
        ((Intent)localObject4).putExtra("Contact_Scene", i);
        if (!com.tencent.mm.n.a.je(localad.field_type))
        {
          ((Intent)localObject4).putExtra("Contact_Alias", localbya.gwU);
          ((Intent)localObject4).putExtra("Contact_Nick", (String)localObject3);
          ((Intent)localObject4).putExtra("Contact_Signature", localbya.gwS);
          ((Intent)localObject4).putExtra("Contact_RegionCode", RegionCodeDecoder.aF(localbya.gwY, localbya.gwQ, localbya.gwR));
          ((Intent)localObject4).putExtra("Contact_Sex", localbya.gwP);
          ((Intent)localObject4).putExtra("Contact_VUser_Info", localbya.xpf);
          ((Intent)localObject4).putExtra("Contact_VUser_Info_Flag", localbya.xpe);
          ((Intent)localObject4).putExtra("Contact_KWeibo_flag", localbya.xpi);
          ((Intent)localObject4).putExtra("Contact_KWeibo", localbya.xpg);
          ((Intent)localObject4).putExtra("Contact_KWeiboNick", localbya.xph);
          if (localbya.xKz == null) {}
        }
        try
        {
          ((Intent)localObject4).putExtra("Contact_customInfo", localbya.xKz.toByteArray());
          b.gmO.c((Intent)localObject4, paramContext);
          i = 1;
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            ab.printErrStackTrace("MicroMsg.BizContactDataItem", localIOException, "", new Object[0]);
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
    AppMethodBeat.i(13862);
    View localView = paramView;
    if (paramView == null) {
      localView = View.inflate(paramContext, 2130970630, null);
    }
    AppMethodBeat.o(13862);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.a.b
 * JD-Core Version:    0.7.0.1
 */