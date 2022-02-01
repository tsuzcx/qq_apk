package com.tencent.mm.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.contact.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.b.e;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;

public final class ak
{
  public static void T(au paramau)
  {
    AppMethodBeat.i(20319);
    au localau = paramau;
    if (paramau == null) {
      localau = new au();
    }
    if ((int)localau.maN == 0)
    {
      localau.setUsername("filehelper");
      if (((n)h.ax(n.class)).bzG().bxM(localau.field_username) != null) {
        break label95;
      }
      localau.aRL();
    }
    for (;;)
    {
      localau.pu(3);
      ((n)h.ax(n.class)).bzA().aA(localau);
      AppMethodBeat.o(20319);
      return;
      label95:
      localau.aRK();
    }
  }
  
  static void U(au paramau)
  {
    AppMethodBeat.i(20320);
    String str = paramau.field_username;
    Context localContext = MMApplicationContext.getContext();
    if (str.equals("qqsync"))
    {
      paramau.setNickname(localContext.getString(b.e.hardcode_plugin_qqsync_nick));
      paramau.AY(localContext.getString(b.e.hardcode_plugin_qqsync_pyinitial));
      paramau.AZ(localContext.getString(b.e.hardcode_plugin_qqsync_quanpin));
    }
    if (str.equals("floatbottle"))
    {
      paramau.setNickname(localContext.getString(b.e.hardcode_plugin_bottle_nick));
      paramau.AY(localContext.getString(b.e.hardcode_plugin_bottle_pyinitial));
      paramau.AZ(localContext.getString(b.e.hardcode_plugin_bottle_quanpin));
    }
    if (str.equals("shakeapp"))
    {
      paramau.setNickname(localContext.getString(b.e.hardcode_plugin_shake_nick));
      paramau.AY(localContext.getString(b.e.hardcode_plugin_shake_pyinitial));
      paramau.AZ(localContext.getString(b.e.hardcode_plugin_shake_quanpin));
    }
    if (str.equals("lbsapp"))
    {
      paramau.setNickname(localContext.getString(b.e.hardcode_plugin_lbs_nick));
      paramau.AY(localContext.getString(b.e.hardcode_plugin_lbs_pyinitial));
      paramau.AZ(localContext.getString(b.e.hardcode_plugin_lbs_quanpin));
    }
    if (str.equals("medianote"))
    {
      paramau.setNickname(localContext.getString(b.e.hardcode_plugin_medianote_nick));
      paramau.AY(localContext.getString(b.e.hardcode_plugin_medianote_pyinitial));
      paramau.AZ(localContext.getString(b.e.hardcode_plugin_medianote_quanpin));
    }
    if (str.equals("newsapp"))
    {
      paramau.setNickname(localContext.getString(b.e.hardcode_plugin_readerappnews_nick));
      paramau.AY(localContext.getString(b.e.hardcode_plugin_readerappnews_pyinitial));
      paramau.AZ(localContext.getString(b.e.hardcode_plugin_readerappnews_quanpin));
    }
    if (str.equals("facebookapp"))
    {
      paramau.setNickname(localContext.getString(b.e.hardcode_plugin_facebookapp_nick));
      paramau.AY(localContext.getString(b.e.hardcode_plugin_facebookapp_pyinitial));
      paramau.AZ(localContext.getString(b.e.hardcode_plugin_facebookapp_quanpin));
    }
    if (str.equals("qqfriend"))
    {
      paramau.setNickname(localContext.getString(b.e.hardcode_plugin_qqfriend_nick_title));
      paramau.AY(localContext.getString(b.e.hardcode_plugin_qqfriend_pyinitial));
      paramau.AZ(localContext.getString(b.e.hardcode_plugin_qqfriend_quanpin));
    }
    if (str.equals("masssendapp"))
    {
      paramau.setNickname(localContext.getString(b.e.hardcode_plugin_masssend_nick));
      paramau.AY(localContext.getString(b.e.hardcode_plugin_masssend_pyinitial));
      paramau.AZ(localContext.getString(b.e.hardcode_plugin_masssend_quanpin));
    }
    if (str.equals("feedsapp"))
    {
      paramau.setNickname(localContext.getString(b.e.hardcode_plugin_feedsapp_nick));
      paramau.AY(localContext.getString(b.e.hardcode_plugin_feedsapp_pyinitial));
      paramau.AZ(localContext.getString(b.e.hardcode_plugin_feedsapp_quanpin));
    }
    if (str.equals("fmessage"))
    {
      paramau.setNickname(localContext.getString(b.e.hardcode_plugin_fmessage_nick));
      paramau.AY(localContext.getString(b.e.hardcode_plugin_fmessage_pyinitial));
      paramau.AZ(localContext.getString(b.e.hardcode_plugin_fmessage_quanpin));
    }
    if (str.equals("voipapp"))
    {
      paramau.setNickname(localContext.getString(b.e.hardcode_plugin_voip_nick));
      paramau.AY(localContext.getString(b.e.hardcode_plugin_voip_pyinitial));
      paramau.AZ(localContext.getString(b.e.hardcode_plugin_voip_quanpin));
    }
    if (str.equals("officialaccounts"))
    {
      paramau.setNickname(localContext.getString(b.e.hardcode_plugin_official_accounts_nick));
      paramau.AY(localContext.getString(b.e.hardcode_plugin_official_accounts_pyinitial));
      paramau.AZ(localContext.getString(b.e.hardcode_plugin_official_accounts_quanpin));
    }
    if (str.equals("findersayhisessionholder"))
    {
      paramau.setNickname(localContext.getString(b.e.hardcode_plugin_official_finder_nick));
      paramau.AY(localContext.getString(b.e.hardcode_plugin_official_finder_pyinitial));
      paramau.AZ(localContext.getString(b.e.hardcode_plugin_official_finder_quanpin));
    }
    if (str.equals("helper_entry"))
    {
      paramau.setNickname(localContext.getString(b.e.hardcode_plugin_helper_entry_nick));
      paramau.AY(localContext.getString(b.e.hardcode_plugin_helper_entry_pyinitial));
      paramau.AZ(localContext.getString(b.e.hardcode_plugin_helper_entry_quanpin));
    }
    if (str.equals("cardpackage"))
    {
      paramau.setNickname(localContext.getString(b.e.hardcode_plugin_card_package_nick));
      paramau.AY(localContext.getString(b.e.hardcode_plugin_card_package_pyinitial));
      paramau.AZ(localContext.getString(b.e.hardcode_plugin_card_package_quanpin));
    }
    if (str.equals("voicevoipapp"))
    {
      paramau.setNickname(localContext.getString(b.e.hardcode_plugin_voipaudio_nick));
      paramau.AY(localContext.getString(b.e.hardcode_plugin_voipaudio_pyinitial));
      paramau.AZ(localContext.getString(b.e.hardcode_plugin_voipaudio_quanpin));
    }
    if (str.equals("voiceinputapp"))
    {
      paramau.setNickname(localContext.getString(b.e.hardcode_plugin_voiceinput_nick));
      paramau.AY(localContext.getString(b.e.hardcode_plugin_voiceinput_pyinitial));
      paramau.AZ(localContext.getString(b.e.hardcode_plugin_voiceinput_quanpin));
    }
    if (str.equals("qqmail"))
    {
      paramau.setNickname(localContext.getString(b.e.hardcode_plugin_qqmail_nick));
      paramau.AY(localContext.getString(b.e.hardcode_plugin_qqmail_pyinitial));
      paramau.AZ(localContext.getString(b.e.hardcode_plugin_qqmail_quanpin));
    }
    if (str.equals("linkedinplugin"))
    {
      paramau.setNickname(localContext.getString(b.e.hardcode_plugin_linkedin_nick));
      paramau.AY(localContext.getString(b.e.hardcode_plugin_linkedin_pyinitial));
      paramau.AZ(localContext.getString(b.e.hardcode_plugin_linkedin_quanpin));
    }
    if (str.equals("notifymessage"))
    {
      paramau.setNickname(localContext.getString(b.e.hardcode_plugin_notify_message_nick));
      paramau.AY(localContext.getString(b.e.hardcode_plugin_notify_message_pyinitial));
      paramau.AZ(localContext.getString(b.e.hardcode_plugin_notify_message_quanpin));
    }
    if (str.equals("appbrandcustomerservicemsg"))
    {
      paramau.setNickname(localContext.getString(b.e.hardcode_plugin_app_brand_customer_service_message_nick));
      paramau.AY(localContext.getString(b.e.hardcode_plugin_app_brand_customer_service_message_pyinitial));
      paramau.AZ(localContext.getString(b.e.hardcode_plugin_app_brand_customer_service_message_quanpin));
    }
    if (str.equals("conversationboxservice"))
    {
      paramau.setNickname(localContext.getString(b.e.hardcode_plugin_conv_box_message_nick));
      paramau.AY(localContext.getString(b.e.hardcode_plugin_conv_box_message_pyinitial));
      paramau.AZ(localContext.getString(b.e.hardcode_plugin_conv_box_message_quanpin));
    }
    if (str.equals("downloaderapp"))
    {
      paramau.setNickname(localContext.getString(b.e.hardcode_plugin_downloaderapp_nick));
      paramau.AY(localContext.getString(b.e.hardcode_plugin_downloaderapp_pyinitial));
      paramau.AZ(localContext.getString(b.e.hardcode_plugin_downloaderapp_quanpin));
    }
    if (str.equals("appbrand_notify_message"))
    {
      paramau.setNickname(localContext.getString(b.e.hardcode_plugin_app_brand_notify_message_nick));
      paramau.AY(localContext.getString(b.e.hardcode_plugin_app_brand_notify_message_pyinitial));
      paramau.AZ(localContext.getString(b.e.hardcode_plugin_app_brand_notify_message_quanpin));
    }
    if (str.equals("opencustomerservicemsg"))
    {
      paramau.setNickname(localContext.getString(b.e.hardcode_plugin_open_im_kefu_message_nick));
      paramau.AY(localContext.getString(b.e.hardcode_plugin_open_im_kefu_message_pyinitial));
      paramau.AZ(localContext.getString(b.e.hardcode_plugin_open_im_kefu_message_quanpin));
    }
    AppMethodBeat.o(20320);
  }
  
  static int a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    AppMethodBeat.i(20318);
    au localau = ((n)h.ax(n.class)).bzA().JE(paramString);
    if (localau == null) {
      localau = new au();
    }
    for (;;)
    {
      if ((int)localau.maN == 0)
      {
        localau.setUsername(paramString);
        localau.aRK();
        U(localau);
        if (paramBoolean2) {}
        for (int i = 4;; i = 3)
        {
          localau.pu(i);
          localau.aRZ();
          ((n)h.ax(n.class)).bzA().aB(localau);
          AppMethodBeat.o(20318);
          return 1;
        }
      }
      if (paramBoolean1)
      {
        localau.aRZ();
        ((n)h.ax(n.class)).bzA().d(paramString, localau);
        AppMethodBeat.o(20318);
        return 2;
      }
      AppMethodBeat.o(20318);
      return 3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.model.ak
 * JD-Core Version:    0.7.0.1
 */