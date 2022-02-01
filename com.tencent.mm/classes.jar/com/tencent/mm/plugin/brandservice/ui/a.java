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
import com.tencent.mm.bs.d;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b.e;
import com.tencent.mm.plugin.brandservice.b.e.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.coc;
import com.tencent.mm.protocal.protobuf.pe;
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.protocal.protobuf.pm;
import com.tencent.mm.protocal.protobuf.zi;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.bg;
import java.io.IOException;
import java.util.List;

public final class a
  extends com.tencent.mm.plugin.brandservice.ui.base.a
{
  private static b mTn;
  protected String iconUrl;
  protected CharSequence mTo;
  protected CharSequence mTp;
  protected CharSequence mTq;
  protected boolean mTr;
  protected boolean mTs;
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
    if (this.Ggl)
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
    if (!(this.data instanceof pm))
    {
      ad.e("MicroMsg.BizContactDataItem", "The ViewHolder is not a instance of BusinessResultItem.");
      AppMethodBeat.o(5605);
      return;
    }
    a locala = (a)parama;
    parama = (pm)this.data;
    if ((parama.CNP == null) || (parama.CNP.CNn == null))
    {
      ad.e("MicroMsg.BizContactDataItem", "The brItem.ContactItem or brItem.ContactItem.ContactItem is null.");
      AppMethodBeat.o(5605);
      return;
    }
    coc localcoc = parama.CNP.CNn;
    parama = parama.CNP.CNk;
    if ((paramVarArgs != null) && (paramVarArgs.length > 1) && ((paramVarArgs[1] instanceof List))) {
      this.mVI = ((List)paramVarArgs[1]);
    }
    this.username = localcoc.Dby.Ehn;
    this.iconUrl = localcoc.CVw;
    if (parama == null) {
      parama = "";
    }
    for (;;)
    {
      this.mTp = parama;
      if (localcoc.DFJ == null) {
        parama = null;
      }
      try
      {
        paramVarArgs = this.mVI;
        locala.fsI.getTextSize();
        this.nickName = e.b(paramContext, parama, paramVarArgs);
        paramVarArgs = localcoc.Dby.Ehn;
        zi localzi = localcoc.Eij;
        if (localzi != null)
        {
          parama = new com.tencent.mm.api.c();
          parama.field_username = paramVarArgs;
          e.a(parama, localzi);
          paramVarArgs = localObject;
          if (parama != null)
          {
            paramVarArgs = localObject;
            if (parama.bU(false) != null) {
              paramVarArgs = parama.bU(false).Jz();
            }
          }
          if (paramVarArgs != null)
          {
            if ((parama.bU(false).JC()) && (!bt.isNullOrNil(paramVarArgs.cJc)))
            {
              bool = true;
              this.mTs = bool;
              if (localcoc.DIV == 0) {
                break label639;
              }
              bool = true;
              this.mTr = bool;
            }
          }
          else
          {
            ad.v("MicroMsg.BizContactDataItem", "verifyFlag : %d", new Object[] { Integer.valueOf(localcoc.DIV) });
            parama = localcoc.ijR;
            if ((this.mVI.size() <= 0) || (parama == null) || (!parama.toLowerCase().equals(((String)this.mVI.get(0)).toLowerCase()))) {}
          }
        }
      }
      catch (Exception parama)
      {
        for (;;)
        {
          try
          {
            paramVarArgs = this.mVI;
            locala.mTx.getTextSize();
            this.mTq = e.b(paramContext, parama, paramVarArgs);
            this.mTq = TextUtils.concat(new CharSequence[] { paramContext.getResources().getString(2131762935), this.mTq });
            if ((this.mTq != null) && (this.mTq.length() != 0) && (this.mTp != null)) {
              if (this.mTp.length() != 0) {
                continue;
              }
            }
          }
          catch (Exception parama)
          {
            try
            {
              parama = localcoc.ijP;
              paramVarArgs = this.mVI;
              locala.mTv.getTextSize();
              this.mTo = e.b(paramContext, parama, paramVarArgs);
              ad.d("MicroMsg.BizContactDataItem", "nickName : %s, followFriends : %s.", new Object[] { this.nickName, this.mTp });
              this.Ggl = true;
              AppMethodBeat.o(5605);
              return;
              parama = parama.CNu;
              break;
              parama = localcoc.DFJ.Ehn;
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
              this.mTq = "";
            }
            catch (Exception paramContext)
            {
              this.mTo = "";
              continue;
            }
          }
          parama = null;
        }
      }
    }
  }
  
  public final com.tencent.mm.ui.base.sortview.a.b bCt()
  {
    AppMethodBeat.i(5603);
    if (mTn == null) {
      mTn = new b();
    }
    b localb = mTn;
    AppMethodBeat.o(5603);
    return localb;
  }
  
  public final com.tencent.mm.ui.base.sortview.a.a bCu()
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
    public TextView fsI;
    public TextView mTt;
    public View mTu;
    public TextView mTv;
    public TextView mTw;
    public TextView mTx;
    View mTy;
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
      com.tencent.mm.pluginsdk.ui.a.b.d(paramContext.frr, parama.username);
      paramVarArgs = paramContext.mTu;
      int i;
      if (parama.mTr)
      {
        i = 0;
        paramVarArgs.setVisibility(i);
        paramVarArgs = paramContext.mTy;
        i = j;
        if (parama.mTs) {
          i = 0;
        }
        paramVarArgs.setVisibility(i);
        e.c(paramContext.fsI, parama.nickName);
        boolean bool1 = e.c(paramContext.mTx, parama.mTq);
        boolean bool2 = e.c(paramContext.mTw, parama.mTp);
        if (e.c(paramContext.mTv, parama.mTo))
        {
          if ((bool1) || (bool2)) {
            break label277;
          }
          paramContext.mTv.setMaxLines(2);
        }
      }
      for (;;)
      {
        ad.d("MicroMsg.BizContactDataItem", "fillingView , nickName : %s, followFriends : %s.", new Object[] { parama.nickName, parama.mTp });
        AppMethodBeat.o(5601);
        return;
        i = 8;
        break;
        label277:
        paramContext.mTv.setMaxLines(1);
      }
    }
    
    public final void a(View paramView, com.tencent.mm.ui.base.sortview.a.a parama)
    {
      AppMethodBeat.i(5602);
      if ((paramView != null) && (parama != null) && ((parama instanceof a.a)))
      {
        parama = (a.a)parama;
        parama.mTt = ((TextView)paramView.findViewById(2131298724));
        parama.mTy = paramView.findViewById(2131297275);
        parama.frr = ((ImageView)paramView.findViewById(2131296997));
        parama.fsI = ((TextView)paramView.findViewById(2131302864));
        parama.mTu = paramView.findViewById(2131306278);
        parama.mTw = ((TextView)paramView.findViewById(2131300189));
        parama.mTv = ((TextView)paramView.findViewById(2131301045));
        parama.mTx = ((TextView)paramView.findViewById(2131307114));
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
      if (!(parama.getData() instanceof pm))
      {
        ad.e("MicroMsg.BizContactDataItem", "The DataItem is not a instance of BusinessResultItem.");
        AppMethodBeat.o(5599);
        return false;
      }
      Object localObject3 = (pm)parama.getData();
      if ((((pm)localObject3).CNP == null) || (((pm)localObject3).CNP.CNn == null))
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
        Object localObject4 = ((pm)localObject3).CNP.rZo;
        coc localcoc = ((pm)localObject3).CNP.CNn;
        if (localcoc.DFJ != null)
        {
          localObject3 = localcoc.DFJ.Ehn;
          if (localcoc.Dby == null) {
            break label269;
          }
        }
        label269:
        for (str = localcoc.Dby.Ehn;; str = null)
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
        com.tencent.mm.plugin.websearch.api.af.avh(str);
        if (!bt.isNullOrNil((String)localObject4))
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
          paramContext = locala.bCF();
          if ((paramContext != null) && (paramVarArgs != null)) {
            paramContext.a(paramVarArgs, parama, i, str, locala.bCG(), locala.getPosition());
          }
          AppMethodBeat.o(5599);
          return true;
          com.tencent.mm.storage.af localaf = ((k)g.ab(k.class)).apM().aHY(str);
          localObject4 = new Intent();
          Bundle localBundle = new Bundle();
          localBundle.putString("Contact_Ext_Args_Search_Id", (String)localObject1);
          localBundle.putInt("Contact_Ext_Args_Index", locala.bCG());
          localBundle.putString("Contact_Ext_Args_Query_String", "");
          localBundle.putInt("Contact_Scene", i);
          ((Intent)localObject4).putExtra("Contact_Ext_Args", localBundle);
          ((Intent)localObject4).putExtra("Contact_User", str);
          ((Intent)localObject4).putExtra("Contact_Scene", i);
          if (!com.tencent.mm.n.b.ls(localaf.field_type))
          {
            ((Intent)localObject4).putExtra("Contact_Alias", localcoc.ijR);
            ((Intent)localObject4).putExtra("Contact_Nick", (String)localObject3);
            ((Intent)localObject4).putExtra("Contact_Signature", localcoc.ijP);
            ((Intent)localObject4).putExtra("Contact_RegionCode", RegionCodeDecoder.aT(localcoc.ijV, localcoc.ijN, localcoc.ijO));
            ((Intent)localObject4).putExtra("Contact_Sex", localcoc.ijM);
            ((Intent)localObject4).putExtra("Contact_VUser_Info", localcoc.DIW);
            ((Intent)localObject4).putExtra("Contact_VUser_Info_Flag", localcoc.DIV);
            ((Intent)localObject4).putExtra("Contact_KWeibo_flag", localcoc.DIZ);
            ((Intent)localObject4).putExtra("Contact_KWeibo", localcoc.DIX);
            ((Intent)localObject4).putExtra("Contact_KWeiboNick", localcoc.DIY);
            if (localcoc.Eij == null) {}
          }
          try
          {
            ((Intent)localObject4).putExtra("Contact_customInfo", localcoc.Eij.toByteArray());
            com.tencent.mm.plugin.brandservice.b.hYt.c((Intent)localObject4, paramContext);
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