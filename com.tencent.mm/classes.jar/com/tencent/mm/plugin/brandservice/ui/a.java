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
import com.tencent.mm.plugin.brandservice.b.d.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.websearch.api.ah;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.acg;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.cyt;
import com.tencent.mm.protocal.protobuf.qq;
import com.tencent.mm.protocal.protobuf.qs;
import com.tencent.mm.protocal.protobuf.qy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import java.io.IOException;
import java.util.List;

public final class a
  extends com.tencent.mm.plugin.brandservice.ui.base.a
{
  private static b nXd;
  protected String iconUrl;
  protected CharSequence nXe;
  protected CharSequence nXf;
  protected CharSequence nXg;
  protected boolean nXh;
  protected boolean nXi;
  protected CharSequence nickName;
  protected String username;
  
  public a(Object paramObject)
  {
    super(5, paramObject);
  }
  
  public final void a(Context paramContext, com.tencent.mm.ui.base.sortview.a.a parama, Object... paramVarArgs)
  {
    Object localObject = null;
    AppMethodBeat.i(5605);
    if (this.JtS)
    {
      AppMethodBeat.o(5605);
      return;
    }
    if ((paramContext == null) || (parama == null) || (this.data == null))
    {
      ad.e("MicroMsg.BizContactDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
      AppMethodBeat.o(5605);
      return;
    }
    if (!(parama instanceof a))
    {
      ad.e("MicroMsg.BizContactDataItem", "The DataItem is not a instance of BizContactViewHolder.");
      AppMethodBeat.o(5605);
      return;
    }
    if (!(this.data instanceof qy))
    {
      ad.e("MicroMsg.BizContactDataItem", "The ViewHolder is not a instance of BusinessResultItem.");
      AppMethodBeat.o(5605);
      return;
    }
    a locala = (a)parama;
    parama = (qy)this.data;
    if ((parama.FMQ == null) || (parama.FMQ.FMo == null))
    {
      ad.e("MicroMsg.BizContactDataItem", "The brItem.ContactItem or brItem.ContactItem.ContactItem is null.");
      AppMethodBeat.o(5605);
      return;
    }
    cyt localcyt = parama.FMQ.FMo;
    parama = parama.FMQ.FMl;
    if ((paramVarArgs != null) && (paramVarArgs.length > 1) && ((paramVarArgs[1] instanceof List))) {
      this.nZG = ((List)paramVarArgs[1]);
    }
    this.username = localcyt.GbY.HoB;
    this.iconUrl = localcyt.FVp;
    if (parama == null) {
      parama = "";
    }
    for (;;)
    {
      this.nXf = parama;
      if (localcyt.GKC == null) {
        parama = null;
      }
      try
      {
        paramVarArgs = this.nZG;
        locala.fPC.getTextSize();
        this.nickName = com.tencent.mm.plugin.brandservice.b.d.b(paramContext, parama, paramVarArgs);
        paramVarArgs = localcyt.GbY.HoB;
        acg localacg = localcyt.HpG;
        if (localacg != null)
        {
          parama = new com.tencent.mm.api.c();
          parama.field_username = paramVarArgs;
          com.tencent.mm.plugin.brandservice.b.d.a(parama, localacg);
          paramVarArgs = localObject;
          if (parama != null)
          {
            paramVarArgs = localObject;
            if (parama.bX(false) != null) {
              paramVarArgs = parama.bX(false).KI();
            }
          }
          if (paramVarArgs != null)
          {
            if ((parama.bX(false).KK()) && (!bt.isNullOrNil(paramVarArgs.cRn)))
            {
              bool = true;
              this.nXi = bool;
              if (localcyt.GNU == 0) {
                break label639;
              }
              bool = true;
              this.nXh = bool;
            }
          }
          else
          {
            ad.v("MicroMsg.BizContactDataItem", "verifyFlag : %d", new Object[] { Integer.valueOf(localcyt.GNU) });
            parama = localcyt.jdh;
            if ((this.nZG.size() <= 0) || (parama == null) || (!parama.toLowerCase().equals(((String)this.nZG.get(0)).toLowerCase()))) {}
          }
        }
      }
      catch (Exception parama)
      {
        for (;;)
        {
          try
          {
            paramVarArgs = this.nZG;
            locala.nXn.getTextSize();
            this.nXg = com.tencent.mm.plugin.brandservice.b.d.b(paramContext, parama, paramVarArgs);
            this.nXg = TextUtils.concat(new CharSequence[] { paramContext.getResources().getString(2131762935), this.nXg });
            if ((this.nXg != null) && (this.nXg.length() != 0) && (this.nXf != null)) {
              if (this.nXf.length() != 0) {
                continue;
              }
            }
          }
          catch (Exception parama)
          {
            try
            {
              parama = localcyt.jdf;
              paramVarArgs = this.nZG;
              locala.nXl.getTextSize();
              this.nXe = com.tencent.mm.plugin.brandservice.b.d.b(paramContext, parama, paramVarArgs);
              ad.d("MicroMsg.BizContactDataItem", "nickName : %s, followFriends : %s.", new Object[] { this.nickName, this.nXf });
              this.JtS = true;
              AppMethodBeat.o(5605);
              return;
              parama = parama.FMv;
              break;
              parama = localcyt.GKC.HoB;
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
              this.nXg = "";
            }
            catch (Exception paramContext)
            {
              this.nXe = "";
              continue;
            }
          }
          parama = null;
        }
      }
    }
  }
  
  public final com.tencent.mm.ui.base.sortview.a.b bNP()
  {
    AppMethodBeat.i(5603);
    if (nXd == null) {
      nXd = new b();
    }
    b localb = nXd;
    AppMethodBeat.o(5603);
    return localb;
  }
  
  public final com.tencent.mm.ui.base.sortview.a.a bNQ()
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
    public TextView fPC;
    public TextView nXj;
    public View nXk;
    public TextView nXl;
    public TextView nXm;
    public TextView nXn;
    View nXo;
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
        ad.e("MicroMsg.BizContactDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
        AppMethodBeat.o(5601);
        return;
      }
      if (!(parama instanceof a.a))
      {
        ad.e("MicroMsg.BizContactDataItem", "The DataItem is not a instance of BizContactViewHolder.");
        AppMethodBeat.o(5601);
        return;
      }
      if (!(paramVarArgs instanceof a))
      {
        ad.e("MicroMsg.BizContactDataItem", "The ViewHolder is not a instance of BusinessResultItem.");
        AppMethodBeat.o(5601);
        return;
      }
      paramContext = (a.a)parama;
      parama = (a)paramVarArgs;
      paramContext.username = parama.username;
      paramContext.iconUrl = parama.iconUrl;
      com.tencent.mm.pluginsdk.ui.a.b.d(paramContext.fOf, parama.username);
      paramVarArgs = paramContext.nXk;
      int i;
      if (parama.nXh)
      {
        i = 0;
        paramVarArgs.setVisibility(i);
        paramVarArgs = paramContext.nXo;
        i = j;
        if (parama.nXi) {
          i = 0;
        }
        paramVarArgs.setVisibility(i);
        com.tencent.mm.plugin.brandservice.b.d.c(paramContext.fPC, parama.nickName);
        boolean bool1 = com.tencent.mm.plugin.brandservice.b.d.c(paramContext.nXn, parama.nXg);
        boolean bool2 = com.tencent.mm.plugin.brandservice.b.d.c(paramContext.nXm, parama.nXf);
        if (com.tencent.mm.plugin.brandservice.b.d.c(paramContext.nXl, parama.nXe))
        {
          if ((bool1) || (bool2)) {
            break label277;
          }
          paramContext.nXl.setMaxLines(2);
        }
      }
      for (;;)
      {
        ad.d("MicroMsg.BizContactDataItem", "fillingView , nickName : %s, followFriends : %s.", new Object[] { parama.nickName, parama.nXf });
        AppMethodBeat.o(5601);
        return;
        i = 8;
        break;
        label277:
        paramContext.nXl.setMaxLines(1);
      }
    }
    
    public final void a(View paramView, com.tencent.mm.ui.base.sortview.a.a parama)
    {
      AppMethodBeat.i(5602);
      if ((paramView != null) && (parama != null) && ((parama instanceof a.a)))
      {
        parama = (a.a)parama;
        parama.nXj = ((TextView)paramView.findViewById(2131298724));
        parama.nXo = paramView.findViewById(2131297275);
        parama.fOf = ((ImageView)paramView.findViewById(2131296997));
        parama.fPC = ((TextView)paramView.findViewById(2131302864));
        parama.nXk = paramView.findViewById(2131306278);
        parama.nXm = ((TextView)paramView.findViewById(2131300189));
        parama.nXl = ((TextView)paramView.findViewById(2131301045));
        parama.nXn = ((TextView)paramView.findViewById(2131307114));
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
      if (!(parama.getData() instanceof qy))
      {
        ad.e("MicroMsg.BizContactDataItem", "The DataItem is not a instance of BusinessResultItem.");
        AppMethodBeat.o(5599);
        return false;
      }
      Object localObject3 = (qy)parama.getData();
      if ((((qy)localObject3).FMQ == null) || (((qy)localObject3).FMQ.FMo == null))
      {
        ad.e("MicroMsg.BizContactDataItem", "The brItem.ContactItem or brItem.ContactItem.ContactItem is null.");
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
        Object localObject4 = ((qy)localObject3).FMQ.ueY;
        cyt localcyt = ((qy)localObject3).FMQ.FMo;
        if (localcyt.GKC != null)
        {
          localObject3 = localcyt.GKC.HoB;
          if (localcyt.GbY == null) {
            break label269;
          }
        }
        label269:
        for (str = localcyt.GbY.HoB;; str = null)
        {
          if (!bt.isNullOrNil(str)) {
            break label275;
          }
          ad.e("MicroMsg.BizContactDataItem", "onItemClick but username is null");
          AppMethodBeat.o(5599);
          return false;
          localObject3 = null;
          break;
        }
        label275:
        ah.aFS(str);
        if (!bt.isNullOrNil((String)localObject4))
        {
          i = 8;
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("rawUrl", (String)localObject4);
          ((Intent)localObject1).putExtra("useJs", true);
          ((Intent)localObject1).putExtra("vertical_scroll", true);
          com.tencent.mm.bs.d.b(paramContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
        }
        for (;;)
        {
          paramContext = locala.bOg();
          if ((paramContext != null) && (paramVarArgs != null)) {
            paramContext.a(paramVarArgs, parama, i, str, locala.bOh(), locala.getPosition());
          }
          AppMethodBeat.o(5599);
          return true;
          am localam = ((l)g.ab(l.class)).azp().Bf(str);
          localObject4 = new Intent();
          Bundle localBundle = new Bundle();
          localBundle.putString("Contact_Ext_Args_Search_Id", (String)localObject1);
          localBundle.putInt("Contact_Ext_Args_Index", locala.bOh());
          localBundle.putString("Contact_Ext_Args_Query_String", "");
          localBundle.putInt("Contact_Scene", i);
          ((Intent)localObject4).putExtra("Contact_Ext_Args", localBundle);
          ((Intent)localObject4).putExtra("Contact_User", str);
          ((Intent)localObject4).putExtra("Contact_Scene", i);
          if (!com.tencent.mm.o.b.lM(localam.field_type))
          {
            ((Intent)localObject4).putExtra("Contact_Alias", localcyt.jdh);
            ((Intent)localObject4).putExtra("Contact_Nick", (String)localObject3);
            ((Intent)localObject4).putExtra("Contact_Signature", localcyt.jdf);
            ((Intent)localObject4).putExtra("Contact_RegionCode", RegionCodeDecoder.bf(localcyt.jdl, localcyt.jdd, localcyt.jde));
            ((Intent)localObject4).putExtra("Contact_Sex", localcyt.jdc);
            ((Intent)localObject4).putExtra("Contact_VUser_Info", localcyt.GNV);
            ((Intent)localObject4).putExtra("Contact_VUser_Info_Flag", localcyt.GNU);
            ((Intent)localObject4).putExtra("Contact_KWeibo_flag", localcyt.GNY);
            ((Intent)localObject4).putExtra("Contact_KWeibo", localcyt.GNW);
            ((Intent)localObject4).putExtra("Contact_KWeiboNick", localcyt.GNX);
            if (localcyt.HpG == null) {}
          }
          try
          {
            ((Intent)localObject4).putExtra("Contact_customInfo", localcyt.HpG.toByteArray());
            com.tencent.mm.plugin.brandservice.b.iRG.c((Intent)localObject4, paramContext);
            i = 1;
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              ad.printErrStackTrace("MicroMsg.BizContactDataItem", localIOException, "", new Object[0]);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.a
 * JD-Core Version:    0.7.0.1
 */