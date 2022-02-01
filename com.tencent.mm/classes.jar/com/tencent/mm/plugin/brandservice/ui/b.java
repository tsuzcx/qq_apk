package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.d;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.brandservice.b.e;
import com.tencent.mm.plugin.brandservice.b.e.a;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.aez;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.ecj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.sortview.a.a;
import java.io.IOException;

public final class b
  extends com.tencent.mm.plugin.brandservice.ui.base.a
{
  private static com.tencent.mm.ui.base.sortview.a.b swV;
  protected String iconUrl;
  CharSequence mMY;
  protected CharSequence swK;
  protected boolean swN;
  protected boolean swO;
  protected String swW;
  protected String username;
  
  public b(Object paramObject, String paramString)
  {
    super(6, paramObject);
    this.swW = paramString;
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(5612);
    if (this.Wta)
    {
      AppMethodBeat.o(5612);
      return;
    }
    if ((paramContext == null) || (parama == null) || (this.bnW == null))
    {
      Log.e("MicroMsg.BizRecommDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
      AppMethodBeat.o(5612);
      return;
    }
    if (!(parama instanceof a))
    {
      Log.e("MicroMsg.BizRecommDataItem", "The DataItem is not a instance of BizProductViewHolder.");
      AppMethodBeat.o(5612);
      return;
    }
    if (!(this.bnW instanceof ecj))
    {
      Log.e("MicroMsg.BizRecommDataItem", "The data is not a instance of SearchOrRecommendItem.");
      AppMethodBeat.o(5612);
      return;
    }
    a locala = (a)parama;
    paramVarArgs = (ecj)this.bnW;
    if (paramVarArgs.TtX != null) {
      parama = paramVarArgs.TtX.toString();
    }
    try
    {
      for (;;)
      {
        this.mMY = l.b(paramContext, parama, locala.iZH.getTextSize());
        this.iconUrl = paramVarArgs.SjJ;
        this.username = paramVarArgs.SrH.toString();
        AppMethodBeat.o(5612);
        return;
        parama = "";
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        this.mMY = "";
      }
    }
  }
  
  public final com.tencent.mm.ui.base.sortview.a.b czw()
  {
    AppMethodBeat.i(5610);
    if (swV == null) {
      swV = new com.tencent.mm.ui.base.sortview.a.b()
      {
        public final void a(Context paramAnonymousContext, a.a paramAnonymousa, com.tencent.mm.ui.base.sortview.a paramAnonymousVarArgs)
        {
          int j = 0;
          AppMethodBeat.i(5608);
          if ((paramAnonymousContext == null) || (paramAnonymousa == null) || (paramAnonymousVarArgs == null) || (paramAnonymousVarArgs.getData() == null))
          {
            Log.e("MicroMsg.BizRecommDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
            AppMethodBeat.o(5608);
            return;
          }
          if (!(paramAnonymousa instanceof b.a))
          {
            Log.e("MicroMsg.BizRecommDataItem", "The ViewHolder is not a instance of BizRecommViewHolder.");
            AppMethodBeat.o(5608);
            return;
          }
          if (!(paramAnonymousVarArgs.getData() instanceof ecj))
          {
            Log.e("MicroMsg.BizRecommDataItem", "The ViewHolder is not a instance of SearchOrRecommendItem.");
            AppMethodBeat.o(5608);
            return;
          }
          paramAnonymousContext = (b.a)paramAnonymousa;
          paramAnonymousa = (b)paramAnonymousVarArgs;
          paramAnonymousContext.username = paramAnonymousa.username;
          paramAnonymousContext.iconUrl = paramAnonymousa.iconUrl;
          com.tencent.mm.pluginsdk.ui.a.b.d(paramAnonymousContext.iZG, paramAnonymousa.username);
          paramAnonymousContext.iZH.setText(paramAnonymousa.mMY, TextView.BufferType.SPANNABLE);
          paramAnonymousVarArgs = paramAnonymousContext.swU;
          if (paramAnonymousa.swO)
          {
            i = 0;
            paramAnonymousVarArgs.setVisibility(i);
            paramAnonymousVarArgs = paramAnonymousContext.swQ;
            if (!paramAnonymousa.swN) {
              break label221;
            }
          }
          label221:
          for (int i = j;; i = 8)
          {
            paramAnonymousVarArgs.setVisibility(i);
            paramAnonymousContext.swR.setText(paramAnonymousa.swK, TextView.BufferType.SPANNABLE);
            e.c(paramAnonymousContext.swP, paramAnonymousa.swW);
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
            paramAnonymousa.iZG = ((ImageView)paramAnonymousView.findViewById(d.e.dsd));
            paramAnonymousa.iZH = ((TextView)paramAnonymousView.findViewById(d.e.dPq));
            paramAnonymousa.swP = ((TextView)paramAnonymousView.findViewById(d.e.dCx));
            paramAnonymousa.swU = paramAnonymousView.findViewById(d.e.dti);
            paramAnonymousa.swQ = paramAnonymousView.findViewById(d.e.dYC);
            paramAnonymousa.swR = ((TextView)paramAnonymousView.findViewById(d.e.dJj));
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
          ecj localecj = (ecj)paramAnonymousa.getData();
          String str2;
          if (localecj.TtX != null)
          {
            str2 = localecj.TtX.Ufy;
            if (localecj.SrH == null) {
              break label101;
            }
          }
          label101:
          for (String str1 = localecj.SrH.Ufy;; str1 = null)
          {
            if (!Util.isNullOrNil(str1)) {
              break label107;
            }
            Log.e("MicroMsg.BizRecommDataItem", "onItemClick but username is null");
            AppMethodBeat.o(5606);
            return false;
            str2 = null;
            break;
          }
          label107:
          as localas = ((n)h.ae(n.class)).bbL().RG(str1);
          Intent localIntent = new Intent();
          if (d.rk(localas.field_type))
          {
            localIntent.putExtra("Contact_User", str1);
            localIntent.putExtra("Contact_Scene", 55);
          }
          for (;;)
          {
            com.tencent.mm.plugin.brandservice.b.mIG.c(localIntent, paramAnonymousContext);
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
            paramAnonymousVarArgs = localb.czN();
            if ((paramAnonymousVarArgs != null) && (paramAnonymousContext != null)) {
              paramAnonymousVarArgs.a(paramAnonymousContext, paramAnonymousa, 1, str1, localb.czO(), localb.getPosition());
            }
            AppMethodBeat.o(5606);
            return true;
            localIntent.putExtra("Contact_User", str1);
            localIntent.putExtra("Contact_Alias", localecj.mVD);
            localIntent.putExtra("Contact_Nick", str2);
            localIntent.putExtra("Contact_Signature", localecj.mVB);
            localIntent.putExtra("Contact_RegionCode", RegionCodeDecoder.bl(localecj.mVH, localecj.mVz, localecj.mVA));
            localIntent.putExtra("Contact_Sex", localecj.mVy);
            localIntent.putExtra("Contact_VUser_Info", localecj.TxG);
            localIntent.putExtra("Contact_VUser_Info_Flag", localecj.TxF);
            localIntent.putExtra("Contact_KWeibo_flag", localecj.TxJ);
            localIntent.putExtra("Contact_KWeibo", localecj.TxH);
            localIntent.putExtra("Contact_KWeiboNick", localecj.TxI);
            localIntent.putExtra("Contact_Scene", 55);
            if (localecj.TxM != null) {
              try
              {
                localIntent.putExtra("Contact_customInfo", localecj.TxM.toByteArray());
              }
              catch (IOException localIOException)
              {
                Log.printErrStackTrace("MicroMsg.BizRecommDataItem", localIOException, "", new Object[0]);
              }
            }
          }
        }
        
        public final View c(Context paramAnonymousContext, View paramAnonymousView)
        {
          AppMethodBeat.i(5607);
          View localView = paramAnonymousView;
          if (paramAnonymousView == null) {
            localView = View.inflate(paramAnonymousContext, d.f.ekH, null);
          }
          AppMethodBeat.o(5607);
          return localView;
        }
      };
    }
    com.tencent.mm.ui.base.sortview.a.b localb = swV;
    AppMethodBeat.o(5610);
    return localb;
  }
  
  public final a.a czx()
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
    public TextView iZH;
    public TextView swP;
    public View swQ;
    public TextView swR;
    public View swU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.b
 * JD-Core Version:    0.7.0.1
 */