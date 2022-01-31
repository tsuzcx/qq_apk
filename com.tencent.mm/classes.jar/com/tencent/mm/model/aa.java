package com.tencent.mm.model;

import android.content.Context;
import com.tencent.mm.R.l;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.n.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;

public final class aa
{
  private c dVv;
  
  public aa(c paramc)
  {
    this.dVv = paramc;
  }
  
  static int a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    int i = 3;
    ad localad2 = c.Fw().abl(paramString);
    ad localad1 = localad2;
    if (localad2 == null) {
      localad1 = new ad();
    }
    if ((int)localad1.dBe == 0)
    {
      localad1.setUsername(paramString);
      localad1.AH();
      y(localad1);
      if (paramBoolean2) {
        i = 4;
      }
      localad1.fl(i);
      localad1.AQ();
      c.Fw().V(localad1);
      i = 1;
    }
    while (!paramBoolean1) {
      return i;
    }
    localad1.AQ();
    c.Fw().a(paramString, localad1);
    return 2;
  }
  
  public static void x(ad paramad)
  {
    ad localad = paramad;
    if (paramad == null) {
      localad = new ad();
    }
    if ((int)localad.dBe == 0)
    {
      localad.setUsername("filehelper");
      au.Hx();
      if (c.FB().abv(localad.field_username) != null) {
        break label71;
      }
      localad.AI();
    }
    for (;;)
    {
      localad.fl(3);
      au.Hx();
      c.Fw().U(localad);
      return;
      label71:
      localad.AH();
    }
  }
  
  static void y(ad paramad)
  {
    String str = paramad.field_username;
    Context localContext = ae.getContext();
    if (str.equals("qqsync"))
    {
      paramad.dk(localContext.getString(R.l.hardcode_plugin_qqsync_nick));
      paramad.dl(localContext.getString(R.l.hardcode_plugin_qqsync_pyinitial));
      paramad.dm(localContext.getString(R.l.hardcode_plugin_qqsync_quanpin));
    }
    if (str.equals("floatbottle"))
    {
      paramad.dk(localContext.getString(R.l.hardcode_plugin_bottle_nick));
      paramad.dl(localContext.getString(R.l.hardcode_plugin_bottle_pyinitial));
      paramad.dm(localContext.getString(R.l.hardcode_plugin_bottle_quanpin));
    }
    if (str.equals("shakeapp"))
    {
      paramad.dk(localContext.getString(R.l.hardcode_plugin_shake_nick));
      paramad.dl(localContext.getString(R.l.hardcode_plugin_shake_pyinitial));
      paramad.dm(localContext.getString(R.l.hardcode_plugin_shake_quanpin));
    }
    if (str.equals("lbsapp"))
    {
      paramad.dk(localContext.getString(R.l.hardcode_plugin_lbs_nick));
      paramad.dl(localContext.getString(R.l.hardcode_plugin_lbs_pyinitial));
      paramad.dm(localContext.getString(R.l.hardcode_plugin_lbs_quanpin));
    }
    if (str.equals("medianote"))
    {
      paramad.dk(localContext.getString(R.l.hardcode_plugin_medianote_nick));
      paramad.dl(localContext.getString(R.l.hardcode_plugin_medianote_pyinitial));
      paramad.dm(localContext.getString(R.l.hardcode_plugin_medianote_quanpin));
    }
    if (str.equals("newsapp"))
    {
      paramad.dk(localContext.getString(R.l.hardcode_plugin_readerappnews_nick));
      paramad.dl(localContext.getString(R.l.hardcode_plugin_readerappnews_pyinitial));
      paramad.dm(localContext.getString(R.l.hardcode_plugin_readerappnews_quanpin));
    }
    if (str.equals("facebookapp"))
    {
      paramad.dk(localContext.getString(R.l.hardcode_plugin_facebookapp_nick));
      paramad.dl(localContext.getString(R.l.hardcode_plugin_facebookapp_pyinitial));
      paramad.dm(localContext.getString(R.l.hardcode_plugin_facebookapp_quanpin));
    }
    if (str.equals("qqfriend"))
    {
      paramad.dk(localContext.getString(R.l.hardcode_plugin_qqfriend_nick));
      paramad.dl(localContext.getString(R.l.hardcode_plugin_qqfriend_pyinitial));
      paramad.dm(localContext.getString(R.l.hardcode_plugin_qqfriend_quanpin));
    }
    if (str.equals("masssendapp"))
    {
      paramad.dk(localContext.getString(R.l.hardcode_plugin_masssend_nick));
      paramad.dl(localContext.getString(R.l.hardcode_plugin_masssend_pyinitial));
      paramad.dm(localContext.getString(R.l.hardcode_plugin_masssend_quanpin));
    }
    if (str.equals("feedsapp"))
    {
      paramad.dk(localContext.getString(R.l.hardcode_plugin_feedsapp_nick));
      paramad.dl(localContext.getString(R.l.hardcode_plugin_feedsapp_pyinitial));
      paramad.dm(localContext.getString(R.l.hardcode_plugin_feedsapp_quanpin));
    }
    if (str.equals("fmessage"))
    {
      paramad.dk(localContext.getString(R.l.hardcode_plugin_fmessage_nick));
      paramad.dl(localContext.getString(R.l.hardcode_plugin_fmessage_pyinitial));
      paramad.dm(localContext.getString(R.l.hardcode_plugin_fmessage_quanpin));
    }
    if (str.equals("voipapp"))
    {
      paramad.dk(localContext.getString(R.l.hardcode_plugin_voip_nick));
      paramad.dl(localContext.getString(R.l.hardcode_plugin_voip_pyinitial));
      paramad.dm(localContext.getString(R.l.hardcode_plugin_voip_quanpin));
    }
    if (str.equals("officialaccounts"))
    {
      paramad.dk(localContext.getString(R.l.hardcode_plugin_official_accounts_nick));
      paramad.dl(localContext.getString(R.l.hardcode_plugin_official_accounts_pyinitial));
      paramad.dm(localContext.getString(R.l.hardcode_plugin_official_accounts_quanpin));
    }
    if (str.equals("helper_entry"))
    {
      paramad.dk(localContext.getString(R.l.hardcode_plugin_helper_entry_nick));
      paramad.dl(localContext.getString(R.l.hardcode_plugin_helper_entry_pyinitial));
      paramad.dm(localContext.getString(R.l.hardcode_plugin_helper_entry_quanpin));
    }
    if (str.equals("cardpackage"))
    {
      paramad.dk(localContext.getString(R.l.hardcode_plugin_card_package_nick));
      paramad.dl(localContext.getString(R.l.hardcode_plugin_card_package_pyinitial));
      paramad.dm(localContext.getString(R.l.hardcode_plugin_card_package_quanpin));
    }
    if (str.equals("voicevoipapp"))
    {
      paramad.dk(localContext.getString(R.l.hardcode_plugin_voipaudio_nick));
      paramad.dl(localContext.getString(R.l.hardcode_plugin_voipaudio_pyinitial));
      paramad.dm(localContext.getString(R.l.hardcode_plugin_voipaudio_quanpin));
    }
    if (str.equals("voiceinputapp"))
    {
      paramad.dk(localContext.getString(R.l.hardcode_plugin_voiceinput_nick));
      paramad.dl(localContext.getString(R.l.hardcode_plugin_voiceinput_pyinitial));
      paramad.dm(localContext.getString(R.l.hardcode_plugin_voiceinput_quanpin));
    }
    if (str.equals("qqmail"))
    {
      paramad.dk(localContext.getString(R.l.hardcode_plugin_qqmail_nick));
      paramad.dl(localContext.getString(R.l.hardcode_plugin_qqmail_pyinitial));
      paramad.dm(localContext.getString(R.l.hardcode_plugin_qqmail_quanpin));
    }
    if (str.equals("linkedinplugin"))
    {
      paramad.dk(localContext.getString(R.l.hardcode_plugin_linkedin_nick));
      paramad.dl(localContext.getString(R.l.hardcode_plugin_linkedin_pyinitial));
      paramad.dm(localContext.getString(R.l.hardcode_plugin_linkedin_quanpin));
    }
    if (str.equals("notifymessage"))
    {
      paramad.dk(localContext.getString(R.l.hardcode_plugin_notify_message_nick));
      paramad.dl(localContext.getString(R.l.hardcode_plugin_notify_message_pyinitial));
      paramad.dm(localContext.getString(R.l.hardcode_plugin_notify_message_quanpin));
    }
    if (str.equals("appbrandcustomerservicemsg"))
    {
      paramad.dk(localContext.getString(R.l.hardcode_plugin_app_brand_customer_service_message_nick));
      paramad.dl(localContext.getString(R.l.hardcode_plugin_app_brand_customer_service_message_pyinitial));
      paramad.dm(localContext.getString(R.l.hardcode_plugin_app_brand_customer_service_message_quanpin));
    }
    if (str.equals("downloaderapp"))
    {
      paramad.dk(localContext.getString(R.l.hardcode_plugin_downloaderapp_nick));
      paramad.dl(localContext.getString(R.l.hardcode_plugin_downloaderapp_pyinitial));
      paramad.dm(localContext.getString(R.l.hardcode_plugin_downloaderapp_quanpin));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.model.aa
 * JD-Core Version:    0.7.0.1
 */