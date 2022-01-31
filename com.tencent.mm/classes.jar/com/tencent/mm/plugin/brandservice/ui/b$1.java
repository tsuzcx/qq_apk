package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.bxz;
import com.tencent.mm.protocal.protobuf.wc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.sortview.a.a;
import java.io.IOException;

final class b$1
  extends com.tencent.mm.ui.base.sortview.a.b
{
  b$1(b paramb) {}
  
  public final void a(Context paramContext, a.a parama, com.tencent.mm.ui.base.sortview.a paramVarArgs)
  {
    int j = 0;
    AppMethodBeat.i(13870);
    if ((paramContext == null) || (parama == null) || (paramVarArgs == null) || (paramVarArgs.getData() == null))
    {
      ab.e("MicroMsg.BizRecommDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
      AppMethodBeat.o(13870);
      return;
    }
    if (!(parama instanceof b.a))
    {
      ab.e("MicroMsg.BizRecommDataItem", "The ViewHolder is not a instance of BizRecommViewHolder.");
      AppMethodBeat.o(13870);
      return;
    }
    if (!(paramVarArgs.getData() instanceof bxz))
    {
      ab.e("MicroMsg.BizRecommDataItem", "The ViewHolder is not a instance of SearchOrRecommendItem.");
      AppMethodBeat.o(13870);
      return;
    }
    paramContext = (b.a)parama;
    parama = (b)paramVarArgs;
    paramContext.username = parama.username;
    paramContext.iconUrl = parama.iconUrl;
    com.tencent.mm.pluginsdk.ui.a.b.s(paramContext.egq, parama.username);
    paramContext.egr.setText(parama.gpH, TextView.BufferType.SPANNABLE);
    paramVarArgs = paramContext.jTg;
    if (parama.jTa)
    {
      i = 0;
      paramVarArgs.setVisibility(i);
      paramVarArgs = paramContext.jTc;
      if (!parama.jSZ) {
        break label221;
      }
    }
    label221:
    for (int i = j;; i = 8)
    {
      paramVarArgs.setVisibility(i);
      paramContext.jTd.setText(parama.jSW, TextView.BufferType.SPANNABLE);
      com.tencent.mm.plugin.brandservice.b.a.b(paramContext.jTb, parama.jTi);
      AppMethodBeat.o(13870);
      return;
      i = 8;
      break;
    }
  }
  
  public final void a(View paramView, a.a parama)
  {
    AppMethodBeat.i(13871);
    if ((paramView != null) && (parama != null) && ((parama instanceof b.a)))
    {
      parama = (b.a)parama;
      parama.egq = ((ImageView)paramView.findViewById(2131823768));
      parama.egr = ((TextView)paramView.findViewById(2131824394));
      parama.jTb = ((TextView)paramView.findViewById(2131821089));
      parama.jTg = paramView.findViewById(2131824396);
      parama.jTc = paramView.findViewById(2131824397);
      parama.jTd = ((TextView)paramView.findViewById(2131824399));
    }
    AppMethodBeat.o(13871);
  }
  
  public final boolean a(Context paramContext, com.tencent.mm.ui.base.sortview.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(13868);
    if (!(parama instanceof b))
    {
      AppMethodBeat.o(13868);
      return false;
    }
    b localb = (b)parama;
    bxz localbxz = (bxz)parama.getData();
    String str2;
    if (localbxz.xmi != null)
    {
      str2 = localbxz.xmi.xJE;
      if (localbxz.wOT == null) {
        break label101;
      }
    }
    label101:
    for (String str1 = localbxz.wOT.xJE;; str1 = null)
    {
      if (!bo.isNullOrNil(str1)) {
        break label107;
      }
      ab.e("MicroMsg.BizRecommDataItem", "onItemClick but username is null");
      AppMethodBeat.o(13868);
      return false;
      str2 = null;
      break;
    }
    label107:
    ad localad = ((j)g.E(j.class)).YA().arw(str1);
    Intent localIntent = new Intent();
    if (com.tencent.mm.n.a.je(localad.field_type))
    {
      localIntent.putExtra("Contact_User", str1);
      localIntent.putExtra("Contact_Scene", 55);
    }
    for (;;)
    {
      com.tencent.mm.plugin.brandservice.b.gmO.c(localIntent, paramContext);
      str2 = null;
      paramContext = str2;
      if (paramVarArgs != null)
      {
        paramContext = str2;
        if (paramVarArgs.length > 0)
        {
          paramContext = str2;
          if ((paramVarArgs[0] instanceof c)) {
            paramContext = (c)paramVarArgs[0];
          }
        }
      }
      paramVarArgs = localb.aWE();
      if ((paramVarArgs != null) && (paramContext != null)) {
        paramVarArgs.a(paramContext, parama, 1, str1, localb.aWF(), localb.getPosition());
      }
      AppMethodBeat.o(13868);
      return true;
      localIntent.putExtra("Contact_User", str1);
      localIntent.putExtra("Contact_Alias", localbxz.gwU);
      localIntent.putExtra("Contact_Nick", str2);
      localIntent.putExtra("Contact_Signature", localbxz.gwS);
      localIntent.putExtra("Contact_RegionCode", RegionCodeDecoder.aF(localbxz.gwY, localbxz.gwQ, localbxz.gwR));
      localIntent.putExtra("Contact_Sex", localbxz.gwP);
      localIntent.putExtra("Contact_VUser_Info", localbxz.xpf);
      localIntent.putExtra("Contact_VUser_Info_Flag", localbxz.xpe);
      localIntent.putExtra("Contact_KWeibo_flag", localbxz.xpi);
      localIntent.putExtra("Contact_KWeibo", localbxz.xpg);
      localIntent.putExtra("Contact_KWeiboNick", localbxz.xph);
      localIntent.putExtra("Contact_Scene", 55);
      if (localbxz.xpl != null) {
        try
        {
          localIntent.putExtra("Contact_customInfo", localbxz.xpl.toByteArray());
        }
        catch (IOException localIOException)
        {
          ab.printErrStackTrace("MicroMsg.BizRecommDataItem", localIOException, "", new Object[0]);
        }
      }
    }
  }
  
  public final View c(Context paramContext, View paramView)
  {
    AppMethodBeat.i(13869);
    View localView = paramView;
    if (paramView == null) {
      localView = View.inflate(paramContext, 2130970630, null);
    }
    AppMethodBeat.o(13869);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.b.1
 * JD-Core Version:    0.7.0.1
 */