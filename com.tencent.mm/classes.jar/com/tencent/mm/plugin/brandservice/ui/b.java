package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.plugin.brandservice.b.d.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.aeq;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.dsn;
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
  private static com.tencent.mm.ui.base.sortview.a.b pnV;
  protected String iconUrl;
  CharSequence jVL;
  protected CharSequence pnK;
  protected boolean pnN;
  protected boolean pnO;
  protected String pnW;
  protected String username;
  
  public b(Object paramObject, String paramString)
  {
    super(6, paramObject);
    this.pnW = paramString;
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(5612);
    if (this.OZN)
    {
      AppMethodBeat.o(5612);
      return;
    }
    if ((paramContext == null) || (parama == null) || (this.data == null))
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
    if (!(this.data instanceof dsn))
    {
      Log.e("MicroMsg.BizRecommDataItem", "The data is not a instance of SearchOrRecommendItem.");
      AppMethodBeat.o(5612);
      return;
    }
    a locala = (a)parama;
    paramVarArgs = (dsn)this.data;
    if (paramVarArgs.Mjj != null) {
      parama = paramVarArgs.Mjj.toString();
    }
    try
    {
      for (;;)
      {
        this.jVL = com.tencent.mm.pluginsdk.ui.span.l.b(paramContext, parama, locala.gvw.getTextSize());
        this.iconUrl = paramVarArgs.Lis;
        this.username = paramVarArgs.Lqk.toString();
        AppMethodBeat.o(5612);
        return;
        parama = "";
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        this.jVL = "";
      }
    }
  }
  
  public final com.tencent.mm.ui.base.sortview.a.b clS()
  {
    AppMethodBeat.i(5610);
    if (pnV == null) {
      pnV = new com.tencent.mm.ui.base.sortview.a.b()
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
          if (!(paramAnonymousVarArgs.getData() instanceof dsn))
          {
            Log.e("MicroMsg.BizRecommDataItem", "The ViewHolder is not a instance of SearchOrRecommendItem.");
            AppMethodBeat.o(5608);
            return;
          }
          paramAnonymousContext = (b.a)paramAnonymousa;
          paramAnonymousa = (b)paramAnonymousVarArgs;
          paramAnonymousContext.username = paramAnonymousa.username;
          paramAnonymousContext.iconUrl = paramAnonymousa.iconUrl;
          com.tencent.mm.pluginsdk.ui.a.b.d(paramAnonymousContext.gvv, paramAnonymousa.username);
          paramAnonymousContext.gvw.setText(paramAnonymousa.jVL, TextView.BufferType.SPANNABLE);
          paramAnonymousVarArgs = paramAnonymousContext.pnU;
          if (paramAnonymousa.pnO)
          {
            i = 0;
            paramAnonymousVarArgs.setVisibility(i);
            paramAnonymousVarArgs = paramAnonymousContext.pnQ;
            if (!paramAnonymousa.pnN) {
              break label221;
            }
          }
          label221:
          for (int i = j;; i = 8)
          {
            paramAnonymousVarArgs.setVisibility(i);
            paramAnonymousContext.pnR.setText(paramAnonymousa.pnK, TextView.BufferType.SPANNABLE);
            d.c(paramAnonymousContext.pnP, paramAnonymousa.pnW);
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
            paramAnonymousa.gvv = ((ImageView)paramAnonymousView.findViewById(2131297120));
            paramAnonymousa.gvw = ((TextView)paramAnonymousView.findViewById(2131305437));
            paramAnonymousa.pnP = ((TextView)paramAnonymousView.findViewById(2131299162));
            paramAnonymousa.pnU = paramAnonymousView.findViewById(2131297432);
            paramAnonymousa.pnQ = paramAnonymousView.findViewById(2131309689);
            paramAnonymousa.pnR = ((TextView)paramAnonymousView.findViewById(2131302698));
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
          dsn localdsn = (dsn)paramAnonymousa.getData();
          String str2;
          if (localdsn.Mjj != null)
          {
            str2 = localdsn.Mjj.MTo;
            if (localdsn.Lqk == null) {
              break label101;
            }
          }
          label101:
          for (String str1 = localdsn.Lqk.MTo;; str1 = null)
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
          as localas = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(str1);
          Intent localIntent = new Intent();
          if (com.tencent.mm.contact.c.oR(localas.field_type))
          {
            localIntent.putExtra("Contact_User", str1);
            localIntent.putExtra("Contact_Scene", 55);
          }
          for (;;)
          {
            com.tencent.mm.plugin.brandservice.b.jRt.c(localIntent, paramAnonymousContext);
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
            paramAnonymousVarArgs = localb.cmj();
            if ((paramAnonymousVarArgs != null) && (paramAnonymousContext != null)) {
              paramAnonymousVarArgs.a(paramAnonymousContext, paramAnonymousa, 1, str1, localb.cmk(), localb.getPosition());
            }
            AppMethodBeat.o(5606);
            return true;
            localIntent.putExtra("Contact_User", str1);
            localIntent.putExtra("Contact_Alias", localdsn.ked);
            localIntent.putExtra("Contact_Nick", str2);
            localIntent.putExtra("Contact_Signature", localdsn.keb);
            localIntent.putExtra("Contact_RegionCode", RegionCodeDecoder.bq(localdsn.keh, localdsn.kdZ, localdsn.kea));
            localIntent.putExtra("Contact_Sex", localdsn.kdY);
            localIntent.putExtra("Contact_VUser_Info", localdsn.MmL);
            localIntent.putExtra("Contact_VUser_Info_Flag", localdsn.MmK);
            localIntent.putExtra("Contact_KWeibo_flag", localdsn.MmO);
            localIntent.putExtra("Contact_KWeibo", localdsn.MmM);
            localIntent.putExtra("Contact_KWeiboNick", localdsn.MmN);
            localIntent.putExtra("Contact_Scene", 55);
            if (localdsn.MmR != null) {
              try
              {
                localIntent.putExtra("Contact_customInfo", localdsn.MmR.toByteArray());
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
            localView = View.inflate(paramAnonymousContext, 2131496186, null);
          }
          AppMethodBeat.o(5607);
          return localView;
        }
      };
    }
    com.tencent.mm.ui.base.sortview.a.b localb = pnV;
    AppMethodBeat.o(5610);
    return localb;
  }
  
  public final a.a clT()
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
    public TextView gvw;
    public TextView pnP;
    public View pnQ;
    public TextView pnR;
    public View pnU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.b
 * JD-Core Version:    0.7.0.1
 */