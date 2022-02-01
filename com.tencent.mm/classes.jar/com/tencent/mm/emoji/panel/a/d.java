package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.ac;
import com.tencent.mm.emoji.b.b.ai;
import com.tencent.mm.emoji.b.b.i;
import com.tencent.mm.emoji.b.b.i.a;
import com.tencent.mm.emoji.b.b.m;
import com.tencent.mm.emoji.b.b.u;
import com.tencent.mm.emoji.b.k;
import com.tencent.mm.emoji.c.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emojicapture.api.b;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.j;
import com.tencent.mm.protocal.protobuf.PersonalDesigner;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.EmojiInfo.b;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelClickListener;", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "scene", "", "(I)V", "emojiCallback", "Lcom/tencent/mm/pluginsdk/ui/chat/SmileyPanelCallback;", "getEmojiCallback", "()Lcom/tencent/mm/pluginsdk/ui/chat/SmileyPanelCallback;", "setEmojiCallback", "(Lcom/tencent/mm/pluginsdk/ui/chat/SmileyPanelCallback;)V", "getScene", "()I", "setScene", "talkerName", "", "getTalkerName", "()Ljava/lang/String;", "setTalkerName", "(Ljava/lang/String;)V", "textOperationListener", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "getTextOperationListener", "()Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "setTextOperationListener", "(Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;)V", "dealCaptureEmojiClick", "", "context", "Landroid/content/Context;", "emoji", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "onClick", "view", "Landroid/view/View;", "position", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "onLongClick", "startCustomManager", "uploadEmoji", "plugin-emojisdk_release"})
public class d
  implements n
{
  public j haC;
  public String haD;
  public ChatFooterPanel.a har;
  public int scene;
  
  public d(int paramInt)
  {
    this.scene = paramInt;
  }
  
  public void a(View paramView, Context paramContext, int paramInt)
  {
    AppMethodBeat.i(199965);
    kotlin.g.b.p.h(paramContext, "context");
    AppMethodBeat.o(199965);
  }
  
  public void a(View paramView, final Context paramContext, int paramInt, final ac paramac)
  {
    AppMethodBeat.i(199966);
    kotlin.g.b.p.h(paramContext, "context");
    Log.i(f.auD(), "onClick: " + paramInt + ", " + paramac);
    if (paramac == null)
    {
      AppMethodBeat.o(199966);
      return;
    }
    com.tencent.mm.emoji.c.h.awf().scene = this.scene;
    com.tencent.mm.emoji.c.c.awc().scene = this.scene;
    switch (paramac.type)
    {
    case 5: 
    default: 
      AppMethodBeat.o(199966);
      return;
    case 6: 
      paramac = ((com.tencent.mm.emoji.b.b.h)paramac).gWm;
      Log.i(f.auD(), "penn send capture emoji click emoji: %s status: %d.", new Object[] { paramac.getMd5(), Integer.valueOf(paramac.field_captureStatus) });
      paramView = paramac.hRH();
      if (paramView == null)
      {
        AppMethodBeat.o(199966);
        return;
      }
      switch (e.haE[paramView.ordinal()])
      {
      default: 
        AppMethodBeat.o(199966);
        return;
      case 1: 
        paramView = this.haC;
        if (paramView != null) {
          paramView.B(paramac);
        }
        Log.d(f.auD(), "onSendCustomEmoji emoji md5 is [%s].", new Object[] { paramac.getMd5() });
        AppMethodBeat.o(199966);
        return;
      case 2: 
      case 3: 
        com.tencent.mm.ui.base.h.cA(paramContext, paramContext.getString(2131758512));
        AppMethodBeat.o(199966);
        return;
      case 4: 
        paramView = new f.a(paramContext);
        paramView.bow(paramContext.getString(2131758507)).apa(2131758708).apb(paramContext.getResources().getColor(2131100996));
        paramView.c((f.c)new a(paramac)).show();
        AppMethodBeat.o(199966);
        return;
      }
      paramView = paramac.hRK();
      Log.d(f.auD(), "CaptureUploadErrCode: %d.", new Object[] { Integer.valueOf(paramView.ordinal()) });
      if (paramView == null) {}
      for (;;)
      {
        paramView = new f.a(paramContext);
        paramView.bow(paramContext.getString(2131758511)).apa(2131758509);
        paramView.c((f.c)new g(this, paramContext, paramac)).show();
        break;
        switch (e.$EnumSwitchMapping$0[paramView.ordinal()])
        {
        }
      }
      paramView = new f.a(paramContext);
      paramView.bow(paramContext.getString(2131758511)).apa(2131758509);
      paramView.c((f.c)new b(this, paramContext, paramac)).show();
      AppMethodBeat.o(199966);
      return;
      paramView = k.gXr;
      if (k.auQ())
      {
        paramView = new f.a(paramContext);
        paramView.bow(paramContext.getString(2131758707)).boA(paramContext.getString(2131758631));
        paramView.c((f.c)new d.c(paramContext)).show();
        AppMethodBeat.o(199966);
        return;
      }
      paramView = new f.a(paramContext);
      paramView.bow(paramContext.getString(2131758511)).apa(2131758509);
      paramView.c((f.c)new d(this, paramContext, paramac)).show();
      AppMethodBeat.o(199966);
      return;
      paramView = new f.a(paramContext);
      paramView.bow(paramContext.getString(2131758511)).apa(2131758509);
      paramView.c((f.c)new e(this, paramContext, paramac)).show();
      AppMethodBeat.o(199966);
      return;
      if (EmojiInfo.b.Osw == paramac.hRK())
      {
        paramView = paramContext.getString(2131758507);
        kotlin.g.b.p.g(paramView, "context.getString(R.stri…ailure_upload_local_file)");
      }
      for (;;)
      {
        f.a locala = new f.a(paramContext);
        locala.bow(paramView).apa(2131758708).apb(paramContext.getResources().getColor(2131100996));
        locala.c((f.c)new f(paramac)).show();
        AppMethodBeat.o(199966);
        return;
        if (EmojiInfo.b.Osx == paramac.hRK())
        {
          paramView = paramContext.getString(2131758533);
          kotlin.g.b.p.g(paramView, "context.getString(R.stri…ustom_gif_max_size_limit)");
        }
        else if (EmojiInfo.b.Osy == paramac.hRK())
        {
          paramView = paramContext.getString(2131758510);
          kotlin.g.b.p.g(paramView, "context.getString(R.stri…ture_failure_upload_spam)");
        }
        else
        {
          paramView = paramContext.getString(2131758508);
          kotlin.g.b.p.g(paramView, "context.getString(R.stri…ad_over_upload_max_count)");
        }
      }
    case 0: 
      paramView = (com.tencent.mm.emoji.b.b.h)paramac;
      paramContext = paramView.gWm;
      paramView = paramView.gWm;
      if (paramView.getGroup() == EmojiGroupInfo.Uun)
      {
        paramac = g.ah(com.tencent.mm.plugin.emoji.b.d.class);
        kotlin.g.b.p.g(paramac, "MMKernel.plugin(IPluginEmoji::class.java)");
        paramView = ((com.tencent.mm.plugin.emoji.b.d)paramac).getProvider().p(paramView);
        kotlin.g.b.p.g(paramView, "MMKernel.plugin(IPluginE…er.getRandomEmoji(toSend)");
      }
      break;
    }
    for (;;)
    {
      com.tencent.mm.emoji.c.h.awf().b(paramInt, paramContext.field_md5, paramContext.field_groupId, paramContext.field_designerID, paramContext.field_activityid);
      paramContext = this.haC;
      if (paramContext != null)
      {
        paramContext.B(paramView);
        AppMethodBeat.o(199966);
        return;
      }
      AppMethodBeat.o(199966);
      return;
      paramView = (ai)paramac;
      paramContext = g.ah(com.tencent.mm.plugin.emoji.b.d.class);
      kotlin.g.b.p.g(paramContext, "MMKernel.plugin(IPluginEmoji::class.java)");
      ((com.tencent.mm.plugin.emoji.b.d)paramContext).getProvider().amy(paramView.gZf.key);
      paramContext = com.tencent.mm.ce.e.gxR().bie(paramView.gZf.key);
      kotlin.g.b.p.g(paramContext, "MergerSmileyManager.getI…mileyItem.smileyInfo.key)");
      paramac = a.hbZ;
      a.ed(paramView.gZg);
      com.tencent.mm.emoji.c.c.awc().a(kotlin.n.n.j(paramContext, ",", " ", false), paramView.gZg, paramView.gZh);
      paramView = this.har;
      if (paramView != null)
      {
        paramView.append(paramContext);
        AppMethodBeat.o(199966);
        return;
      }
      AppMethodBeat.o(199966);
      return;
      paramView = (m)paramac;
      if (paramView.gYH == 0)
      {
        com.tencent.mm.plugin.report.service.h.CyF.a(11594, new Object[] { Integer.valueOf(1) });
        com.tencent.mm.br.c.b(paramContext, "emoji", ".ui.EmojiCustomUI", new Intent());
        AppMethodBeat.o(199966);
        return;
      }
      if (paramView.gYH == 1)
      {
        paramView = g.ah(com.tencent.mm.plugin.emoji.b.d.class);
        kotlin.g.b.p.g(paramView, "MMKernel.plugin(IPluginEmoji::class.java)");
        paramView = ((com.tencent.mm.plugin.emoji.b.d)paramView).getProvider();
        kotlin.g.b.p.g(paramView, "MMKernel.plugin(IPluginEmoji::class.java).provider");
        if (paramView.avf())
        {
          paramView = i.gYr;
          b.b(paramContext, i.a.ph(this.scene), this.haD);
        }
      }
      AppMethodBeat.o(199966);
      return;
      AppMethodBeat.o(199966);
      return;
      paramView = g.ah(com.tencent.mm.plugin.emoji.b.d.class);
      kotlin.g.b.p.g(paramView, "MMKernel.plugin(IPluginEmoji::class.java)");
      paramView = ((com.tencent.mm.plugin.emoji.b.d)paramView).getProvider();
      kotlin.g.b.p.g(paramView, "MMKernel.plugin(IPluginEmoji::class.java).provider");
      if (!paramView.avf()) {
        break;
      }
      paramView = i.gYr;
      b.b(paramContext, i.a.ph(this.scene), this.haD);
      AppMethodBeat.o(199966);
      return;
      paramView = com.tencent.mm.emoji.c.d.hcj;
      com.tencent.mm.emoji.c.d.pl(2);
      paramView = ((u)paramac).gYM;
      if (paramView == null) {
        break;
      }
      paramac = new Intent();
      paramac.putExtra("uin", paramView.DesignerUin);
      paramac.putExtra("name", paramView.Name);
      paramac.putExtra("headurl", paramView.HeadUrl);
      paramac.putExtra("extra_scence", 9);
      com.tencent.mm.br.c.b(paramContext, "emoji", ".ui.v2.EmojiStoreV2DesignerUI", paramac);
      break;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
  static final class a
    implements f.c
  {
    a(EmojiInfo paramEmojiInfo) {}
    
    public final void e(boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(105632);
      if ((paramBoolean) && (!Util.isNullOrNil(this.haF.getMd5())))
      {
        paramString = g.ah(com.tencent.mm.plugin.emoji.b.d.class);
        kotlin.g.b.p.g(paramString, "MMKernel.plugin(IPluginEmoji::class.java)");
        ((com.tencent.mm.plugin.emoji.b.d)paramString).getEmojiMgr().amB(this.haF.getMd5());
      }
      AppMethodBeat.o(105632);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
  static final class b
    implements f.c
  {
    b(d paramd, Context paramContext, EmojiInfo paramEmojiInfo) {}
    
    public final void e(boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(105633);
      if (paramBoolean) {
        d.m(paramac);
      }
      AppMethodBeat.o(105633);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
  static final class d
    implements f.c
  {
    d(d paramd, Context paramContext, EmojiInfo paramEmojiInfo) {}
    
    public final void e(boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(105635);
      if (paramBoolean) {
        d.m(paramac);
      }
      AppMethodBeat.o(105635);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
  static final class e
    implements f.c
  {
    e(d paramd, Context paramContext, EmojiInfo paramEmojiInfo) {}
    
    public final void e(boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(105636);
      if (paramBoolean) {
        d.m(paramac);
      }
      AppMethodBeat.o(105636);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
  static final class f
    implements f.c
  {
    f(EmojiInfo paramEmojiInfo) {}
    
    public final void e(boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(105637);
      if ((paramBoolean) && (!Util.isNullOrNil(this.haF.getMd5())))
      {
        paramString = g.ah(com.tencent.mm.plugin.emoji.b.d.class);
        kotlin.g.b.p.g(paramString, "MMKernel.plugin(IPluginEmoji::class.java)");
        ((com.tencent.mm.plugin.emoji.b.d)paramString).getEmojiMgr().amB(this.haF.getMd5());
      }
      AppMethodBeat.o(105637);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
  static final class g
    implements f.c
  {
    g(d paramd, Context paramContext, EmojiInfo paramEmojiInfo) {}
    
    public final void e(boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(161814);
      if (paramBoolean) {
        d.m(paramac);
      }
      AppMethodBeat.o(161814);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.d
 * JD-Core Version:    0.7.0.1
 */