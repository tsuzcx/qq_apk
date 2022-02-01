package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.plugin.brandservice.b.d.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.acf;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.cys;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.base.sortview.a.a;
import java.io.IOException;

public final class b
  extends com.tencent.mm.plugin.brandservice.ui.base.a
{
  private static com.tencent.mm.ui.base.sortview.a.b nXp;
  CharSequence iVn;
  protected String iconUrl;
  protected CharSequence nXe;
  protected boolean nXh;
  protected boolean nXi;
  protected String nXq;
  protected String username;
  
  public b(Object paramObject, String paramString)
  {
    super(6, paramObject);
    this.nXq = paramString;
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(5612);
    if (this.JtS)
    {
      AppMethodBeat.o(5612);
      return;
    }
    if ((paramContext == null) || (parama == null) || (this.data == null))
    {
      ad.e("MicroMsg.BizRecommDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
      AppMethodBeat.o(5612);
      return;
    }
    if (!(parama instanceof a))
    {
      ad.e("MicroMsg.BizRecommDataItem", "The DataItem is not a instance of BizProductViewHolder.");
      AppMethodBeat.o(5612);
      return;
    }
    if (!(this.data instanceof cys))
    {
      ad.e("MicroMsg.BizRecommDataItem", "The data is not a instance of SearchOrRecommendItem.");
      AppMethodBeat.o(5612);
      return;
    }
    a locala = (a)parama;
    paramVarArgs = (cys)this.data;
    if (paramVarArgs.GKC != null) {
      parama = paramVarArgs.GKC.toString();
    }
    try
    {
      for (;;)
      {
        this.iVn = k.b(paramContext, parama, locala.fOg.getTextSize());
        this.iconUrl = paramVarArgs.FVp;
        this.username = paramVarArgs.GbY.toString();
        AppMethodBeat.o(5612);
        return;
        parama = "";
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        this.iVn = "";
      }
    }
  }
  
  public final com.tencent.mm.ui.base.sortview.a.b bNP()
  {
    AppMethodBeat.i(5610);
    if (nXp == null) {
      nXp = new com.tencent.mm.ui.base.sortview.a.b()
      {
        public final void a(Context paramAnonymousContext, a.a paramAnonymousa, com.tencent.mm.ui.base.sortview.a paramAnonymousVarArgs)
        {
          int j = 0;
          AppMethodBeat.i(5608);
          if ((paramAnonymousContext == null) || (paramAnonymousa == null) || (paramAnonymousVarArgs == null) || (paramAnonymousVarArgs.getData() == null))
          {
            ad.e("MicroMsg.BizRecommDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
            AppMethodBeat.o(5608);
            return;
          }
          if (!(paramAnonymousa instanceof b.a))
          {
            ad.e("MicroMsg.BizRecommDataItem", "The ViewHolder is not a instance of BizRecommViewHolder.");
            AppMethodBeat.o(5608);
            return;
          }
          if (!(paramAnonymousVarArgs.getData() instanceof cys))
          {
            ad.e("MicroMsg.BizRecommDataItem", "The ViewHolder is not a instance of SearchOrRecommendItem.");
            AppMethodBeat.o(5608);
            return;
          }
          paramAnonymousContext = (b.a)paramAnonymousa;
          paramAnonymousa = (b)paramAnonymousVarArgs;
          paramAnonymousContext.username = paramAnonymousa.username;
          paramAnonymousContext.iconUrl = paramAnonymousa.iconUrl;
          com.tencent.mm.pluginsdk.ui.a.b.d(paramAnonymousContext.fOf, paramAnonymousa.username);
          paramAnonymousContext.fOg.setText(paramAnonymousa.iVn, TextView.BufferType.SPANNABLE);
          paramAnonymousVarArgs = paramAnonymousContext.nXo;
          if (paramAnonymousa.nXi)
          {
            i = 0;
            paramAnonymousVarArgs.setVisibility(i);
            paramAnonymousVarArgs = paramAnonymousContext.nXk;
            if (!paramAnonymousa.nXh) {
              break label221;
            }
          }
          label221:
          for (int i = j;; i = 8)
          {
            paramAnonymousVarArgs.setVisibility(i);
            paramAnonymousContext.nXl.setText(paramAnonymousa.nXe, TextView.BufferType.SPANNABLE);
            d.c(paramAnonymousContext.nXj, paramAnonymousa.nXq);
            AppMethodBeat.o(5608);
            return;
            i = 8;
            break;
          }
        }
        
        public final void a(View paramAnonymousView, a.a paramAnonymousa)
        {
          AppMethodBeat.i(5609);
          if ((paramAnonymousView != null) && (paramAnonymousa != null) && ((paramAnonymousa instanceof b.a)))
          {
            paramAnonymousa = (b.a)paramAnonymousa;
            paramAnonymousa.fOf = ((ImageView)paramAnonymousView.findViewById(2131296997));
            paramAnonymousa.fOg = ((TextView)paramAnonymousView.findViewById(2131302864));
            paramAnonymousa.nXj = ((TextView)paramAnonymousView.findViewById(2131298724));
            paramAnonymousa.nXo = paramAnonymousView.findViewById(2131297275);
            paramAnonymousa.nXk = paramAnonymousView.findViewById(2131306278);
            paramAnonymousa.nXl = ((TextView)paramAnonymousView.findViewById(2131301045));
          }
          AppMethodBeat.o(5609);
        }
        
        public final boolean a(Context paramAnonymousContext, com.tencent.mm.ui.base.sortview.a paramAnonymousa, Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(5606);
          if (!(paramAnonymousa instanceof b))
          {
            AppMethodBeat.o(5606);
            return false;
          }
          b localb = (b)paramAnonymousa;
          cys localcys = (cys)paramAnonymousa.getData();
          String str2;
          if (localcys.GKC != null)
          {
            str2 = localcys.GKC.HoB;
            if (localcys.GbY == null) {
              break label101;
            }
          }
          label101:
          for (String str1 = localcys.GbY.HoB;; str1 = null)
          {
            if (!bt.isNullOrNil(str1)) {
              break label107;
            }
            ad.e("MicroMsg.BizRecommDataItem", "onItemClick but username is null");
            AppMethodBeat.o(5606);
            return false;
            str2 = null;
            break;
          }
          label107:
          am localam = ((l)g.ab(l.class)).azp().Bf(str1);
          Intent localIntent = new Intent();
          if (com.tencent.mm.o.b.lM(localam.field_type))
          {
            localIntent.putExtra("Contact_User", str1);
            localIntent.putExtra("Contact_Scene", 55);
          }
          for (;;)
          {
            com.tencent.mm.plugin.brandservice.b.iRG.c(localIntent, paramAnonymousContext);
            str2 = null;
            paramAnonymousContext = str2;
            if (paramAnonymousVarArgs != null)
            {
              paramAnonymousContext = str2;
              if (paramAnonymousVarArgs.length > 0)
              {
                paramAnonymousContext = str2;
                if ((paramAnonymousVarArgs[0] instanceof c)) {
                  paramAnonymousContext = (c)paramAnonymousVarArgs[0];
                }
              }
            }
            paramAnonymousVarArgs = localb.bOg();
            if ((paramAnonymousVarArgs != null) && (paramAnonymousContext != null)) {
              paramAnonymousVarArgs.a(paramAnonymousContext, paramAnonymousa, 1, str1, localb.bOh(), localb.getPosition());
            }
            AppMethodBeat.o(5606);
            return true;
            localIntent.putExtra("Contact_User", str1);
            localIntent.putExtra("Contact_Alias", localcys.jdh);
            localIntent.putExtra("Contact_Nick", str2);
            localIntent.putExtra("Contact_Signature", localcys.jdf);
            localIntent.putExtra("Contact_RegionCode", RegionCodeDecoder.bf(localcys.jdl, localcys.jdd, localcys.jde));
            localIntent.putExtra("Contact_Sex", localcys.jdc);
            localIntent.putExtra("Contact_VUser_Info", localcys.GNV);
            localIntent.putExtra("Contact_VUser_Info_Flag", localcys.GNU);
            localIntent.putExtra("Contact_KWeibo_flag", localcys.GNY);
            localIntent.putExtra("Contact_KWeibo", localcys.GNW);
            localIntent.putExtra("Contact_KWeiboNick", localcys.GNX);
            localIntent.putExtra("Contact_Scene", 55);
            if (localcys.GOb != null) {
              try
              {
                localIntent.putExtra("Contact_customInfo", localcys.GOb.toByteArray());
              }
              catch (IOException localIOException)
              {
                ad.printErrStackTrace("MicroMsg.BizRecommDataItem", localIOException, "", new Object[0]);
              }
            }
          }
        }
        
        public final View c(Context paramAnonymousContext, View paramAnonymousView)
        {
          AppMethodBeat.i(5607);
          View localView = paramAnonymousView;
          if (paramAnonymousView == null) {
            localView = View.inflate(paramAnonymousContext, 2131495325, null);
          }
          AppMethodBeat.o(5607);
          return localView;
        }
      };
    }
    com.tencent.mm.ui.base.sortview.a.b localb = nXp;
    AppMethodBeat.o(5610);
    return localb;
  }
  
  public final a.a bNQ()
  {
    AppMethodBeat.i(5611);
    a locala = new a();
    AppMethodBeat.o(5611);
    return locala;
  }
  
  public static final class a
    extends d.a
    implements a.a
  {
    public TextView fOg;
    public TextView nXj;
    public View nXk;
    public TextView nXl;
    public View nXo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.b
 * JD-Core Version:    0.7.0.1
 */