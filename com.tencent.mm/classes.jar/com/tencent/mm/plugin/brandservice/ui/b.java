package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.contact.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.brandservice.model.e;
import com.tencent.mm.plugin.brandservice.model.e.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.ahl;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.ewa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.base.sortview.a.a;
import java.io.IOException;

public final class b
  extends com.tencent.mm.plugin.brandservice.ui.base.a
{
  private static com.tencent.mm.ui.base.sortview.a.b vCC;
  protected String iconUrl;
  CharSequence pJG;
  protected String username;
  protected String vCD;
  protected CharSequence vCr;
  protected boolean vCu;
  protected boolean vCv;
  
  public b(Object paramObject, String paramString)
  {
    super(6, paramObject);
    this.vCD = paramString;
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(5612);
    if (this.aeau)
    {
      AppMethodBeat.o(5612);
      return;
    }
    if ((paramContext == null) || (parama == null) || (this.cpt == null))
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
    if (!(this.cpt instanceof ewa))
    {
      Log.e("MicroMsg.BizRecommDataItem", "The data is not a instance of SearchOrRecommendItem.");
      AppMethodBeat.o(5612);
      return;
    }
    a locala = (a)parama;
    paramVarArgs = (ewa)this.cpt;
    if (paramVarArgs.aaIz != null) {
      parama = paramVarArgs.aaIz.toString();
    }
    try
    {
      for (;;)
      {
        this.pJG = p.b(paramContext, parama, locala.lBD.getTextSize());
        this.iconUrl = paramVarArgs.ZhP;
        this.username = paramVarArgs.ZqL.toString();
        AppMethodBeat.o(5612);
        return;
        parama = "";
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        this.pJG = "";
      }
    }
  }
  
  public final com.tencent.mm.ui.base.sortview.a.b dco()
  {
    AppMethodBeat.i(5610);
    if (vCC == null) {
      vCC = new com.tencent.mm.ui.base.sortview.a.b()
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
          if (!(paramAnonymousVarArgs.getData() instanceof ewa))
          {
            Log.e("MicroMsg.BizRecommDataItem", "The ViewHolder is not a instance of SearchOrRecommendItem.");
            AppMethodBeat.o(5608);
            return;
          }
          paramAnonymousContext = (b.a)paramAnonymousa;
          paramAnonymousa = (b)paramAnonymousVarArgs;
          paramAnonymousContext.username = paramAnonymousa.username;
          paramAnonymousContext.iconUrl = paramAnonymousa.iconUrl;
          com.tencent.mm.pluginsdk.ui.a.b.h(paramAnonymousContext.lBC, paramAnonymousa.username);
          paramAnonymousContext.lBD.setText(paramAnonymousa.pJG, TextView.BufferType.SPANNABLE);
          paramAnonymousVarArgs = paramAnonymousContext.vCB;
          if (paramAnonymousa.vCv)
          {
            i = 0;
            paramAnonymousVarArgs.setVisibility(i);
            paramAnonymousVarArgs = paramAnonymousContext.vCx;
            if (!paramAnonymousa.vCu) {
              break label221;
            }
          }
          label221:
          for (int i = j;; i = 8)
          {
            paramAnonymousVarArgs.setVisibility(i);
            paramAnonymousContext.vCy.setText(paramAnonymousa.vCr, TextView.BufferType.SPANNABLE);
            e.c(paramAnonymousContext.vCw, paramAnonymousa.vCD);
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
            paramAnonymousa.lBC = ((ImageView)paramAnonymousView.findViewById(d.e.avatarIV));
            paramAnonymousa.lBD = ((TextView)paramAnonymousView.findViewById(d.e.nicknameTV));
            paramAnonymousa.vCw = ((TextView)paramAnonymousView.findViewById(d.e.contactitem_catalog));
            paramAnonymousa.vCB = paramAnonymousView.findViewById(d.e.bizTrademarkProtectionIV);
            paramAnonymousa.vCx = paramAnonymousView.findViewById(d.e.verifyIV);
            paramAnonymousa.vCy = ((TextView)paramAnonymousView.findViewById(d.e.introduceTV));
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
          ewa localewa = (ewa)paramAnonymousa.getData();
          String str2;
          if (localewa.aaIz != null)
          {
            str2 = localewa.aaIz.abwM;
            if (localewa.ZqL == null) {
              break label101;
            }
          }
          label101:
          for (String str1 = localewa.ZqL.abwM;; str1 = null)
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
          au localau = ((n)h.ax(n.class)).bzA().JE(str1);
          Intent localIntent = new Intent();
          if (d.rs(localau.field_type))
          {
            localIntent.putExtra("Contact_User", str1);
            localIntent.putExtra("Contact_Scene", 55);
          }
          for (;;)
          {
            com.tencent.mm.plugin.brandservice.b.pFn.c(localIntent, paramAnonymousContext);
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
            paramAnonymousVarArgs = localb.dcF();
            if ((paramAnonymousVarArgs != null) && (paramAnonymousContext != null)) {
              paramAnonymousVarArgs.a(paramAnonymousContext, paramAnonymousa, 1, str1, localb.dcG(), localb.getPosition());
            }
            AppMethodBeat.o(5606);
            return true;
            localIntent.putExtra("Contact_User", str1);
            localIntent.putExtra("Contact_Alias", localewa.pSk);
            localIntent.putExtra("Contact_Nick", str2);
            localIntent.putExtra("Contact_Signature", localewa.pSi);
            localIntent.putExtra("Contact_RegionCode", RegionCodeDecoder.bI(localewa.pSo, localewa.pSg, localewa.pSh));
            localIntent.putExtra("Contact_Sex", localewa.pSf);
            localIntent.putExtra("Contact_VUser_Info", localewa.aaMn);
            localIntent.putExtra("Contact_VUser_Info_Flag", localewa.aaMm);
            localIntent.putExtra("Contact_KWeibo_flag", localewa.aaMq);
            localIntent.putExtra("Contact_KWeibo", localewa.aaMo);
            localIntent.putExtra("Contact_KWeiboNick", localewa.aaMp);
            localIntent.putExtra("Contact_Scene", 55);
            if (localewa.aaMt != null) {
              try
              {
                localIntent.putExtra("Contact_customInfo", localewa.aaMt.toByteArray());
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
            localView = View.inflate(paramAnonymousContext, d.f.search_or_recommend_biz_item, null);
          }
          AppMethodBeat.o(5607);
          return localView;
        }
      };
    }
    com.tencent.mm.ui.base.sortview.a.b localb = vCC;
    AppMethodBeat.o(5610);
    return localb;
  }
  
  public final a.a dcp()
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
    public TextView lBD;
    public View vCB;
    public TextView vCw;
    public View vCx;
    public TextView vCy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.b
 * JD-Core Version:    0.7.0.1
 */