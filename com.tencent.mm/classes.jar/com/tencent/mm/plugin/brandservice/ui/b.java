package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.plugin.brandservice.b.e;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.boe;
import com.tencent.mm.protocal.c.sg;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.sortview.a.a;
import java.io.IOException;

public final class b
  extends com.tencent.mm.plugin.brandservice.ui.base.a
{
  private static com.tencent.mm.ui.base.sortview.a.b icr;
  CharSequence eXK;
  protected CharSequence icg;
  protected boolean icj;
  protected boolean ick;
  protected String iconUrl;
  protected String ics;
  protected String username;
  
  public b(Object paramObject, String paramString)
  {
    super(6, paramObject);
    this.ics = paramString;
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    if (this.vdV) {
      return;
    }
    if ((paramContext == null) || (parama == null) || (this.data == null))
    {
      y.e("MicroMsg.BizRecommDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
      return;
    }
    if (!(parama instanceof b.a))
    {
      y.e("MicroMsg.BizRecommDataItem", "The DataItem is not a instance of BizProductViewHolder.");
      return;
    }
    if (!(this.data instanceof boe))
    {
      y.e("MicroMsg.BizRecommDataItem", "The data is not a instance of SearchOrRecommendItem.");
      return;
    }
    b.a locala = (b.a)parama;
    paramVarArgs = (boe)this.data;
    if (paramVarArgs.tmw != null) {
      parama = paramVarArgs.tmw.toString();
    }
    try
    {
      for (;;)
      {
        this.eXK = com.tencent.mm.pluginsdk.ui.d.j.a(paramContext, parama, locala.doV.getTextSize());
        this.iconUrl = paramVarArgs.sLE;
        this.username = paramVarArgs.sQs.toString();
        return;
        parama = "";
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        this.eXK = "";
      }
    }
  }
  
  public final com.tencent.mm.ui.base.sortview.a.b axw()
  {
    if (icr == null) {
      icr = new com.tencent.mm.ui.base.sortview.a.b()
      {
        public final void a(Context paramAnonymousContext, a.a paramAnonymousa, com.tencent.mm.ui.base.sortview.a paramAnonymousVarArgs)
        {
          int j = 0;
          if ((paramAnonymousContext == null) || (paramAnonymousa == null) || (paramAnonymousVarArgs == null) || (paramAnonymousVarArgs.data == null))
          {
            y.e("MicroMsg.BizRecommDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
            return;
          }
          if (!(paramAnonymousa instanceof b.a))
          {
            y.e("MicroMsg.BizRecommDataItem", "The ViewHolder is not a instance of BizRecommViewHolder.");
            return;
          }
          if (!(paramAnonymousVarArgs.data instanceof boe))
          {
            y.e("MicroMsg.BizRecommDataItem", "The ViewHolder is not a instance of SearchOrRecommendItem.");
            return;
          }
          paramAnonymousContext = (b.a)paramAnonymousa;
          paramAnonymousa = (b)paramAnonymousVarArgs;
          paramAnonymousContext.username = paramAnonymousa.username;
          paramAnonymousContext.iconUrl = paramAnonymousa.iconUrl;
          com.tencent.mm.pluginsdk.ui.a.b.n(paramAnonymousContext.doU, paramAnonymousa.username);
          paramAnonymousContext.doV.setText(paramAnonymousa.eXK, TextView.BufferType.SPANNABLE);
          paramAnonymousVarArgs = paramAnonymousContext.icq;
          if (paramAnonymousa.ick)
          {
            i = 0;
            paramAnonymousVarArgs.setVisibility(i);
            paramAnonymousVarArgs = paramAnonymousContext.icm;
            if (!paramAnonymousa.icj) {
              break label191;
            }
          }
          label191:
          for (int i = j;; i = 8)
          {
            paramAnonymousVarArgs.setVisibility(i);
            paramAnonymousContext.icn.setText(paramAnonymousa.icg, TextView.BufferType.SPANNABLE);
            com.tencent.mm.plugin.brandservice.b.a.b(paramAnonymousContext.icl, paramAnonymousa.ics);
            return;
            i = 8;
            break;
          }
        }
        
        public final void a(View paramAnonymousView, a.a paramAnonymousa)
        {
          if ((paramAnonymousView != null) && (paramAnonymousa != null) && ((paramAnonymousa instanceof b.a)))
          {
            paramAnonymousa = (b.a)paramAnonymousa;
            paramAnonymousa.doU = ((ImageView)paramAnonymousView.findViewById(b.d.avatarIV));
            paramAnonymousa.doV = ((TextView)paramAnonymousView.findViewById(b.d.nicknameTV));
            paramAnonymousa.icl = ((TextView)paramAnonymousView.findViewById(b.d.contactitem_catalog));
            paramAnonymousa.icq = paramAnonymousView.findViewById(b.d.bizTrademarkProtectionIV);
            paramAnonymousa.icm = paramAnonymousView.findViewById(b.d.verifyIV);
            paramAnonymousa.icn = ((TextView)paramAnonymousView.findViewById(b.d.introduceTV));
          }
        }
        
        public final boolean a(Context paramAnonymousContext, com.tencent.mm.ui.base.sortview.a paramAnonymousa, Object... paramAnonymousVarArgs)
        {
          boolean bool2 = true;
          boolean bool1;
          if (!(paramAnonymousa instanceof b))
          {
            bool1 = false;
            return bool1;
          }
          b localb = (b)paramAnonymousa;
          boe localboe = (boe)paramAnonymousa.data;
          String str2;
          if (localboe.tmw != null)
          {
            str2 = localboe.tmw.tFO;
            if (localboe.sQs == null) {
              break label90;
            }
          }
          label90:
          for (String str1 = localboe.sQs.tFO;; str1 = null)
          {
            if (!bk.bl(str1)) {
              break label96;
            }
            y.e("MicroMsg.BizRecommDataItem", "onItemClick but username is null");
            return false;
            str2 = null;
            break;
          }
          label96:
          ad localad = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(str1);
          Intent localIntent = new Intent();
          if (com.tencent.mm.n.a.gR(localad.field_type))
          {
            localIntent.putExtra("Contact_User", str1);
            localIntent.putExtra("Contact_Scene", 55);
            label158:
            com.tencent.mm.plugin.brandservice.a.eUR.d(localIntent, paramAnonymousContext);
            if ((paramAnonymousVarArgs == null) || (paramAnonymousVarArgs.length <= 0) || (!(paramAnonymousVarArgs[0] instanceof c))) {
              break label453;
            }
          }
          label453:
          for (paramAnonymousContext = (c)paramAnonymousVarArgs[0];; paramAnonymousContext = null)
          {
            for (;;)
            {
              paramAnonymousVarArgs = localb.axH();
              bool1 = bool2;
              if (paramAnonymousVarArgs == null) {
                break;
              }
              bool1 = bool2;
              if (paramAnonymousContext == null) {
                break;
              }
              paramAnonymousVarArgs.a(paramAnonymousContext, paramAnonymousa, 1, str1, localb.axI(), localb.getPosition());
              return true;
              localIntent.putExtra("Contact_User", str1);
              localIntent.putExtra("Contact_Alias", localboe.ffm);
              localIntent.putExtra("Contact_Nick", str2);
              localIntent.putExtra("Contact_Signature", localboe.ffk);
              localIntent.putExtra("Contact_RegionCode", RegionCodeDecoder.ao(localboe.ffq, localboe.ffi, localboe.ffj));
              localIntent.putExtra("Contact_Sex", localboe.ffh);
              localIntent.putExtra("Contact_VUser_Info", localboe.tph);
              localIntent.putExtra("Contact_VUser_Info_Flag", localboe.tpg);
              localIntent.putExtra("Contact_KWeibo_flag", localboe.tpk);
              localIntent.putExtra("Contact_KWeibo", localboe.tpi);
              localIntent.putExtra("Contact_KWeiboNick", localboe.tpj);
              localIntent.putExtra("Contact_Scene", 55);
              if (localboe.tpn == null) {
                break label158;
              }
              try
              {
                localIntent.putExtra("Contact_customInfo", localboe.tpn.toByteArray());
              }
              catch (IOException localIOException)
              {
                y.printErrStackTrace("MicroMsg.BizRecommDataItem", localIOException, "", new Object[0]);
              }
            }
            break label158;
          }
        }
        
        public final View b(Context paramAnonymousContext, View paramAnonymousView)
        {
          View localView = paramAnonymousView;
          if (paramAnonymousView == null) {
            localView = View.inflate(paramAnonymousContext, b.e.search_or_recommend_biz_item, null);
          }
          return localView;
        }
      };
    }
    return icr;
  }
  
  public final a.a axx()
  {
    return new b.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.b
 * JD-Core Version:    0.7.0.1
 */