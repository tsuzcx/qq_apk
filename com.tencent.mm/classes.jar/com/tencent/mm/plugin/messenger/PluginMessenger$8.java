package com.tencent.mm.plugin.messenger;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.view.View;
import com.tencent.d.a.a.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.findersdk.a.ca;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.messenger.a.e.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

final class PluginMessenger$8
  implements e.b
{
  PluginMessenger$8(PluginMessenger paramPluginMessenger) {}
  
  public final Boolean aB(Map<String, String> paramMap)
  {
    AppMethodBeat.i(288562);
    boolean bool = paramMap.containsKey(".sysmsg.sysmsgtemplate.content_template.link_list.link.redpacketinfo");
    AppMethodBeat.o(288562);
    return Boolean.valueOf(bool);
  }
  
  public final CharSequence o(final Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(288571);
    long l1 = d.FK(Util.nullAsNil((String)paramMap.get(".sysmsg.sysmsgtemplate.content_template.link_list.link.redpacketinfo." + "objectid")));
    long l2 = d.FK(Util.nullAsNil((String)paramMap.get(".sysmsg.sysmsgtemplate.content_template.link_list.link.redpacketinfo." + "liveid")));
    final String str1 = Util.nullAsNil((String)paramMap.get(".sysmsg.sysmsgtemplate.content_template.link_list.link.redpacketinfo." + "objectnonceid"));
    String str3 = Util.nullAsNil((String)paramMap.get(".sysmsg.sysmsgtemplate.content_template.link_list.link.redpacketinfo." + "findernickname"));
    paramMap = Util.nullAsNil((String)paramMap.get(".sysmsg.sysmsgtemplate.content_template.link_list.link.redpacketinfo." + "redpacketsendid"));
    String str2 = MMApplicationContext.getContext().getResources().getString(b.e.finder_live_red_packet_name);
    str3 = MMApplicationContext.getContext().getResources().getString(b.e.finder_live_red_packet_tips, new Object[] { str3, str2 });
    int i = str3.indexOf(str2);
    if ((i != -1) && (str2.length() + i <= str3.length()))
    {
      paramString = p.b(MMApplicationContext.getContext(), str3);
      int j = MMApplicationContext.getContext().getResources().getIdentifier("systemmessages_hongbaoicon", "drawable", MMApplicationContext.getContext().getPackageName());
      Object localObject = MMApplicationContext.getContext().getDrawable(j);
      if (localObject != null)
      {
        j = MMApplicationContext.getContext().getResources().getDimensionPixelOffset(b.a.RedPacketWidth);
        ((Drawable)localObject).setBounds(0, 0, j, j);
        localObject = new com.tencent.mm.ui.widget.a((Drawable)localObject, 1);
        j = str3.indexOf(' ');
        if ((j >= 0) && (j < str3.length() - 1)) {
          paramString.setSpan(localObject, j, j + 1, 18);
        }
      }
      paramString.setSpan(new com.tencent.mm.plugin.messenger.a.a(Long.valueOf(l1))
      {
        public final void onClickImp(View paramAnonymousView)
        {
          AppMethodBeat.i(288513);
          ((cn)h.az(cn.class)).report21053OnClick(this.KPt.longValue(), this.KPu.longValue(), "", -1, -1, -1L, "temp_17", -1, -1, "", "", System.currentTimeMillis(), -1);
          ((b)h.az(b.class)).enterFinderLiveVisitorUI(null, MMApplicationContext.getContext(), this.KPt.longValue(), this.KPu, "", str1, "", "", "", paramMap, 0, "", 1, ((cn)h.az(cn.class)).getFinderUtilApi().fgH());
          AppMethodBeat.o(288513);
        }
      }, i, str2.length() + i, 33);
      AppMethodBeat.o(288571);
      return paramString;
    }
    AppMethodBeat.o(288571);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.PluginMessenger.8
 * JD-Core Version:    0.7.0.1
 */