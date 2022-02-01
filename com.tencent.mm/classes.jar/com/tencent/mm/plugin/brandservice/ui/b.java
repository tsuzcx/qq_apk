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
import com.tencent.mm.protocal.protobuf.aco;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.czm;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.base.sortview.a.a;
import java.io.IOException;

public final class b
  extends com.tencent.mm.plugin.brandservice.ui.base.a
{
  private static com.tencent.mm.ui.base.sortview.a.b ocY;
  CharSequence iYg;
  protected String iconUrl;
  protected CharSequence ocN;
  protected boolean ocQ;
  protected boolean ocR;
  protected String ocZ;
  protected String username;
  
  public b(Object paramObject, String paramString)
  {
    super(6, paramObject);
    this.ocZ = paramString;
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(5612);
    if (this.JOH)
    {
      AppMethodBeat.o(5612);
      return;
    }
    if ((paramContext == null) || (parama == null) || (this.data == null))
    {
      ae.e("MicroMsg.BizRecommDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
      AppMethodBeat.o(5612);
      return;
    }
    if (!(parama instanceof a))
    {
      ae.e("MicroMsg.BizRecommDataItem", "The DataItem is not a instance of BizProductViewHolder.");
      AppMethodBeat.o(5612);
      return;
    }
    if (!(this.data instanceof czm))
    {
      ae.e("MicroMsg.BizRecommDataItem", "The data is not a instance of SearchOrRecommendItem.");
      AppMethodBeat.o(5612);
      return;
    }
    a locala = (a)parama;
    paramVarArgs = (czm)this.data;
    if (paramVarArgs.Hed != null) {
      parama = paramVarArgs.Hed.toString();
    }
    try
    {
      for (;;)
      {
        this.iYg = k.b(paramContext, parama, locala.fQm.getTextSize());
        this.iconUrl = paramVarArgs.GnO;
        this.username = paramVarArgs.GuF.toString();
        AppMethodBeat.o(5612);
        return;
        parama = "";
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        this.iYg = "";
      }
    }
  }
  
  public final com.tencent.mm.ui.base.sortview.a.b bOM()
  {
    AppMethodBeat.i(5610);
    if (ocY == null) {
      ocY = new com.tencent.mm.ui.base.sortview.a.b()
      {
        public final void a(Context paramAnonymousContext, a.a paramAnonymousa, com.tencent.mm.ui.base.sortview.a paramAnonymousVarArgs)
        {
          int j = 0;
          AppMethodBeat.i(5608);
          if ((paramAnonymousContext == null) || (paramAnonymousa == null) || (paramAnonymousVarArgs == null) || (paramAnonymousVarArgs.getData() == null))
          {
            ae.e("MicroMsg.BizRecommDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
            AppMethodBeat.o(5608);
            return;
          }
          if (!(paramAnonymousa instanceof b.a))
          {
            ae.e("MicroMsg.BizRecommDataItem", "The ViewHolder is not a instance of BizRecommViewHolder.");
            AppMethodBeat.o(5608);
            return;
          }
          if (!(paramAnonymousVarArgs.getData() instanceof czm))
          {
            ae.e("MicroMsg.BizRecommDataItem", "The ViewHolder is not a instance of SearchOrRecommendItem.");
            AppMethodBeat.o(5608);
            return;
          }
          paramAnonymousContext = (b.a)paramAnonymousa;
          paramAnonymousa = (b)paramAnonymousVarArgs;
          paramAnonymousContext.username = paramAnonymousa.username;
          paramAnonymousContext.iconUrl = paramAnonymousa.iconUrl;
          com.tencent.mm.pluginsdk.ui.a.b.d(paramAnonymousContext.fQl, paramAnonymousa.username);
          paramAnonymousContext.fQm.setText(paramAnonymousa.iYg, TextView.BufferType.SPANNABLE);
          paramAnonymousVarArgs = paramAnonymousContext.ocX;
          if (paramAnonymousa.ocR)
          {
            i = 0;
            paramAnonymousVarArgs.setVisibility(i);
            paramAnonymousVarArgs = paramAnonymousContext.ocT;
            if (!paramAnonymousa.ocQ) {
              break label221;
            }
          }
          label221:
          for (int i = j;; i = 8)
          {
            paramAnonymousVarArgs.setVisibility(i);
            paramAnonymousContext.ocU.setText(paramAnonymousa.ocN, TextView.BufferType.SPANNABLE);
            d.c(paramAnonymousContext.ocS, paramAnonymousa.ocZ);
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
            paramAnonymousa.fQl = ((ImageView)paramAnonymousView.findViewById(2131296997));
            paramAnonymousa.fQm = ((TextView)paramAnonymousView.findViewById(2131302864));
            paramAnonymousa.ocS = ((TextView)paramAnonymousView.findViewById(2131298724));
            paramAnonymousa.ocX = paramAnonymousView.findViewById(2131297275);
            paramAnonymousa.ocT = paramAnonymousView.findViewById(2131306278);
            paramAnonymousa.ocU = ((TextView)paramAnonymousView.findViewById(2131301045));
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
          czm localczm = (czm)paramAnonymousa.getData();
          String str2;
          if (localczm.Hed != null)
          {
            str2 = localczm.Hed.HId;
            if (localczm.GuF == null) {
              break label101;
            }
          }
          label101:
          for (String str1 = localczm.GuF.HId;; str1 = null)
          {
            if (!bu.isNullOrNil(str1)) {
              break label107;
            }
            ae.e("MicroMsg.BizRecommDataItem", "onItemClick but username is null");
            AppMethodBeat.o(5606);
            return false;
            str2 = null;
            break;
          }
          label107:
          an localan = ((l)g.ab(l.class)).azF().BH(str1);
          Intent localIntent = new Intent();
          if (com.tencent.mm.contact.c.lO(localan.field_type))
          {
            localIntent.putExtra("Contact_User", str1);
            localIntent.putExtra("Contact_Scene", 55);
          }
          for (;;)
          {
            com.tencent.mm.plugin.brandservice.b.iUz.c(localIntent, paramAnonymousContext);
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
            paramAnonymousVarArgs = localb.bPd();
            if ((paramAnonymousVarArgs != null) && (paramAnonymousContext != null)) {
              paramAnonymousVarArgs.a(paramAnonymousContext, paramAnonymousa, 1, str1, localb.bPe(), localb.getPosition());
            }
            AppMethodBeat.o(5606);
            return true;
            localIntent.putExtra("Contact_User", str1);
            localIntent.putExtra("Contact_Alias", localczm.jga);
            localIntent.putExtra("Contact_Nick", str2);
            localIntent.putExtra("Contact_Signature", localczm.jfY);
            localIntent.putExtra("Contact_RegionCode", RegionCodeDecoder.bg(localczm.jge, localczm.jfW, localczm.jfX));
            localIntent.putExtra("Contact_Sex", localczm.jfV);
            localIntent.putExtra("Contact_VUser_Info", localczm.Hhv);
            localIntent.putExtra("Contact_VUser_Info_Flag", localczm.Hhu);
            localIntent.putExtra("Contact_KWeibo_flag", localczm.Hhy);
            localIntent.putExtra("Contact_KWeibo", localczm.Hhw);
            localIntent.putExtra("Contact_KWeiboNick", localczm.Hhx);
            localIntent.putExtra("Contact_Scene", 55);
            if (localczm.HhB != null) {
              try
              {
                localIntent.putExtra("Contact_customInfo", localczm.HhB.toByteArray());
              }
              catch (IOException localIOException)
              {
                ae.printErrStackTrace("MicroMsg.BizRecommDataItem", localIOException, "", new Object[0]);
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
    com.tencent.mm.ui.base.sortview.a.b localb = ocY;
    AppMethodBeat.o(5610);
    return localb;
  }
  
  public final a.a bON()
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
    public TextView fQm;
    public TextView ocS;
    public View ocT;
    public TextView ocU;
    public View ocX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.b
 * JD-Core Version:    0.7.0.1
 */