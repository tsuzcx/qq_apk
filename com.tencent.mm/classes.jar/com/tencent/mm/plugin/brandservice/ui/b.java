package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.plugin.brandservice.b.d.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.aaf;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.cti;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.base.sortview.a.a;
import java.io.IOException;

public final class b
  extends com.tencent.mm.plugin.brandservice.ui.base.a
{
  private static com.tencent.mm.ui.base.sortview.a.b nvR;
  CharSequence iCd;
  protected String iconUrl;
  protected CharSequence nvG;
  protected boolean nvJ;
  protected boolean nvK;
  protected String nvS;
  protected String username;
  
  public b(Object paramObject, String paramString)
  {
    super(6, paramObject);
    this.nvS = paramString;
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(5612);
    if (this.HGb)
    {
      AppMethodBeat.o(5612);
      return;
    }
    if ((paramContext == null) || (parama == null) || (this.data == null))
    {
      ac.e("MicroMsg.BizRecommDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
      AppMethodBeat.o(5612);
      return;
    }
    if (!(parama instanceof a))
    {
      ac.e("MicroMsg.BizRecommDataItem", "The DataItem is not a instance of BizProductViewHolder.");
      AppMethodBeat.o(5612);
      return;
    }
    if (!(this.data instanceof cti))
    {
      ac.e("MicroMsg.BizRecommDataItem", "The data is not a instance of SearchOrRecommendItem.");
      AppMethodBeat.o(5612);
      return;
    }
    a locala = (a)parama;
    paramVarArgs = (cti)this.data;
    if (paramVarArgs.Fbd != null) {
      parama = paramVarArgs.Fbd.toString();
    }
    try
    {
      for (;;)
      {
        this.iCd = com.tencent.mm.pluginsdk.ui.span.k.b(paramContext, parama, locala.fuZ.getTextSize());
        this.iconUrl = paramVarArgs.Eog;
        this.username = paramVarArgs.EuE.toString();
        AppMethodBeat.o(5612);
        return;
        parama = "";
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        this.iCd = "";
      }
    }
  }
  
  public final com.tencent.mm.ui.base.sortview.a.b bJw()
  {
    AppMethodBeat.i(5610);
    if (nvR == null) {
      nvR = new com.tencent.mm.ui.base.sortview.a.b()
      {
        public final void a(Context paramAnonymousContext, a.a paramAnonymousa, com.tencent.mm.ui.base.sortview.a paramAnonymousVarArgs)
        {
          int j = 0;
          AppMethodBeat.i(5608);
          if ((paramAnonymousContext == null) || (paramAnonymousa == null) || (paramAnonymousVarArgs == null) || (paramAnonymousVarArgs.getData() == null))
          {
            ac.e("MicroMsg.BizRecommDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
            AppMethodBeat.o(5608);
            return;
          }
          if (!(paramAnonymousa instanceof b.a))
          {
            ac.e("MicroMsg.BizRecommDataItem", "The ViewHolder is not a instance of BizRecommViewHolder.");
            AppMethodBeat.o(5608);
            return;
          }
          if (!(paramAnonymousVarArgs.getData() instanceof cti))
          {
            ac.e("MicroMsg.BizRecommDataItem", "The ViewHolder is not a instance of SearchOrRecommendItem.");
            AppMethodBeat.o(5608);
            return;
          }
          paramAnonymousContext = (b.a)paramAnonymousa;
          paramAnonymousa = (b)paramAnonymousVarArgs;
          paramAnonymousContext.username = paramAnonymousa.username;
          paramAnonymousContext.iconUrl = paramAnonymousa.iconUrl;
          com.tencent.mm.pluginsdk.ui.a.b.d(paramAnonymousContext.fuY, paramAnonymousa.username);
          paramAnonymousContext.fuZ.setText(paramAnonymousa.iCd, TextView.BufferType.SPANNABLE);
          paramAnonymousVarArgs = paramAnonymousContext.nvQ;
          if (paramAnonymousa.nvK)
          {
            i = 0;
            paramAnonymousVarArgs.setVisibility(i);
            paramAnonymousVarArgs = paramAnonymousContext.nvM;
            if (!paramAnonymousa.nvJ) {
              break label221;
            }
          }
          label221:
          for (int i = j;; i = 8)
          {
            paramAnonymousVarArgs.setVisibility(i);
            paramAnonymousContext.nvN.setText(paramAnonymousa.nvG, TextView.BufferType.SPANNABLE);
            d.c(paramAnonymousContext.nvL, paramAnonymousa.nvS);
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
            paramAnonymousa.fuY = ((ImageView)paramAnonymousView.findViewById(2131296997));
            paramAnonymousa.fuZ = ((TextView)paramAnonymousView.findViewById(2131302864));
            paramAnonymousa.nvL = ((TextView)paramAnonymousView.findViewById(2131298724));
            paramAnonymousa.nvQ = paramAnonymousView.findViewById(2131297275);
            paramAnonymousa.nvM = paramAnonymousView.findViewById(2131306278);
            paramAnonymousa.nvN = ((TextView)paramAnonymousView.findViewById(2131301045));
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
          cti localcti = (cti)paramAnonymousa.getData();
          String str2;
          if (localcti.Fbd != null)
          {
            str2 = localcti.Fbd.FEm;
            if (localcti.EuE == null) {
              break label101;
            }
          }
          label101:
          for (String str1 = localcti.EuE.FEm;; str1 = null)
          {
            if (!bs.isNullOrNil(str1)) {
              break label107;
            }
            ac.e("MicroMsg.BizRecommDataItem", "onItemClick but username is null");
            AppMethodBeat.o(5606);
            return false;
            str2 = null;
            break;
          }
          label107:
          ai localai = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(str1);
          Intent localIntent = new Intent();
          if (com.tencent.mm.n.b.ln(localai.field_type))
          {
            localIntent.putExtra("Contact_User", str1);
            localIntent.putExtra("Contact_Scene", 55);
          }
          for (;;)
          {
            com.tencent.mm.plugin.brandservice.b.iyx.c(localIntent, paramAnonymousContext);
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
            paramAnonymousVarArgs = localb.bJN();
            if ((paramAnonymousVarArgs != null) && (paramAnonymousContext != null)) {
              paramAnonymousVarArgs.a(paramAnonymousContext, paramAnonymousa, 1, str1, localb.bJO(), localb.getPosition());
            }
            AppMethodBeat.o(5606);
            return true;
            localIntent.putExtra("Contact_User", str1);
            localIntent.putExtra("Contact_Alias", localcti.iJY);
            localIntent.putExtra("Contact_Nick", str2);
            localIntent.putExtra("Contact_Signature", localcti.iJW);
            localIntent.putExtra("Contact_RegionCode", RegionCodeDecoder.aW(localcti.iKc, localcti.iJU, localcti.iJV));
            localIntent.putExtra("Contact_Sex", localcti.iJT);
            localIntent.putExtra("Contact_VUser_Info", localcti.Fer);
            localIntent.putExtra("Contact_VUser_Info_Flag", localcti.Feq);
            localIntent.putExtra("Contact_KWeibo_flag", localcti.Feu);
            localIntent.putExtra("Contact_KWeibo", localcti.Fes);
            localIntent.putExtra("Contact_KWeiboNick", localcti.Fet);
            localIntent.putExtra("Contact_Scene", 55);
            if (localcti.Fex != null) {
              try
              {
                localIntent.putExtra("Contact_customInfo", localcti.Fex.toByteArray());
              }
              catch (IOException localIOException)
              {
                ac.printErrStackTrace("MicroMsg.BizRecommDataItem", localIOException, "", new Object[0]);
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
    com.tencent.mm.ui.base.sortview.a.b localb = nvR;
    AppMethodBeat.o(5610);
    return localb;
  }
  
  public final a.a bJx()
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
    public TextView fuZ;
    public TextView nvL;
    public View nvM;
    public TextView nvN;
    public View nvQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.b
 * JD-Core Version:    0.7.0.1
 */