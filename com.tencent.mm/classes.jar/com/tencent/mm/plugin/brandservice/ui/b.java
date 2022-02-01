package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b.e;
import com.tencent.mm.plugin.brandservice.b.e.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.cob;
import com.tencent.mm.protocal.protobuf.zh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.base.sortview.a.a;
import java.io.IOException;

public final class b
  extends com.tencent.mm.plugin.brandservice.ui.base.a
{
  private static com.tencent.mm.ui.base.sortview.a.b mTz;
  CharSequence ibW;
  protected String iconUrl;
  protected String mTA;
  protected CharSequence mTo;
  protected boolean mTr;
  protected boolean mTs;
  protected String username;
  
  public b(Object paramObject, String paramString)
  {
    super(6, paramObject);
    this.mTA = paramString;
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(5612);
    if (this.Ggl)
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
    if (!(this.data instanceof cob))
    {
      ad.e("MicroMsg.BizRecommDataItem", "The data is not a instance of SearchOrRecommendItem.");
      AppMethodBeat.o(5612);
      return;
    }
    a locala = (a)parama;
    paramVarArgs = (cob)this.data;
    if (paramVarArgs.DFJ != null) {
      parama = paramVarArgs.DFJ.toString();
    }
    try
    {
      for (;;)
      {
        this.ibW = com.tencent.mm.pluginsdk.ui.span.k.b(paramContext, parama, locala.frs.getTextSize());
        this.iconUrl = paramVarArgs.CVw;
        this.username = paramVarArgs.Dby.toString();
        AppMethodBeat.o(5612);
        return;
        parama = "";
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        this.ibW = "";
      }
    }
  }
  
  public final com.tencent.mm.ui.base.sortview.a.b bCt()
  {
    AppMethodBeat.i(5610);
    if (mTz == null) {
      mTz = new com.tencent.mm.ui.base.sortview.a.b()
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
          if (!(paramAnonymousVarArgs.getData() instanceof cob))
          {
            ad.e("MicroMsg.BizRecommDataItem", "The ViewHolder is not a instance of SearchOrRecommendItem.");
            AppMethodBeat.o(5608);
            return;
          }
          paramAnonymousContext = (b.a)paramAnonymousa;
          paramAnonymousa = (b)paramAnonymousVarArgs;
          paramAnonymousContext.username = paramAnonymousa.username;
          paramAnonymousContext.iconUrl = paramAnonymousa.iconUrl;
          com.tencent.mm.pluginsdk.ui.a.b.d(paramAnonymousContext.frr, paramAnonymousa.username);
          paramAnonymousContext.frs.setText(paramAnonymousa.ibW, TextView.BufferType.SPANNABLE);
          paramAnonymousVarArgs = paramAnonymousContext.mTy;
          if (paramAnonymousa.mTs)
          {
            i = 0;
            paramAnonymousVarArgs.setVisibility(i);
            paramAnonymousVarArgs = paramAnonymousContext.mTu;
            if (!paramAnonymousa.mTr) {
              break label221;
            }
          }
          label221:
          for (int i = j;; i = 8)
          {
            paramAnonymousVarArgs.setVisibility(i);
            paramAnonymousContext.mTv.setText(paramAnonymousa.mTo, TextView.BufferType.SPANNABLE);
            e.c(paramAnonymousContext.mTt, paramAnonymousa.mTA);
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
            paramAnonymousa.frr = ((ImageView)paramAnonymousView.findViewById(2131296997));
            paramAnonymousa.frs = ((TextView)paramAnonymousView.findViewById(2131302864));
            paramAnonymousa.mTt = ((TextView)paramAnonymousView.findViewById(2131298724));
            paramAnonymousa.mTy = paramAnonymousView.findViewById(2131297275);
            paramAnonymousa.mTu = paramAnonymousView.findViewById(2131306278);
            paramAnonymousa.mTv = ((TextView)paramAnonymousView.findViewById(2131301045));
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
          cob localcob = (cob)paramAnonymousa.getData();
          String str2;
          if (localcob.DFJ != null)
          {
            str2 = localcob.DFJ.Ehn;
            if (localcob.Dby == null) {
              break label101;
            }
          }
          label101:
          for (String str1 = localcob.Dby.Ehn;; str1 = null)
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
          af localaf = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(str1);
          Intent localIntent = new Intent();
          if (com.tencent.mm.n.b.ls(localaf.field_type))
          {
            localIntent.putExtra("Contact_User", str1);
            localIntent.putExtra("Contact_Scene", 55);
          }
          for (;;)
          {
            com.tencent.mm.plugin.brandservice.b.hYt.c(localIntent, paramAnonymousContext);
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
            paramAnonymousVarArgs = localb.bCF();
            if ((paramAnonymousVarArgs != null) && (paramAnonymousContext != null)) {
              paramAnonymousVarArgs.a(paramAnonymousContext, paramAnonymousa, 1, str1, localb.bCG(), localb.getPosition());
            }
            AppMethodBeat.o(5606);
            return true;
            localIntent.putExtra("Contact_User", str1);
            localIntent.putExtra("Contact_Alias", localcob.ijR);
            localIntent.putExtra("Contact_Nick", str2);
            localIntent.putExtra("Contact_Signature", localcob.ijP);
            localIntent.putExtra("Contact_RegionCode", RegionCodeDecoder.aT(localcob.ijV, localcob.ijN, localcob.ijO));
            localIntent.putExtra("Contact_Sex", localcob.ijM);
            localIntent.putExtra("Contact_VUser_Info", localcob.DIW);
            localIntent.putExtra("Contact_VUser_Info_Flag", localcob.DIV);
            localIntent.putExtra("Contact_KWeibo_flag", localcob.DIZ);
            localIntent.putExtra("Contact_KWeibo", localcob.DIX);
            localIntent.putExtra("Contact_KWeiboNick", localcob.DIY);
            localIntent.putExtra("Contact_Scene", 55);
            if (localcob.DJc != null) {
              try
              {
                localIntent.putExtra("Contact_customInfo", localcob.DJc.toByteArray());
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
    com.tencent.mm.ui.base.sortview.a.b localb = mTz;
    AppMethodBeat.o(5610);
    return localb;
  }
  
  public final a.a bCu()
  {
    AppMethodBeat.i(5611);
    a locala = new a();
    AppMethodBeat.o(5611);
    return locala;
  }
  
  public static final class a
    extends e.a
    implements a.a
  {
    public TextView frs;
    public TextView mTt;
    public View mTu;
    public TextView mTv;
    public View mTy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.b
 * JD-Core Version:    0.7.0.1
 */