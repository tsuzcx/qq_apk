package com.tencent.mm.emoji.panel.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cl.f;
import com.tencent.mm.emoji.b.b.ae;
import com.tencent.mm.emoji.b.b.ak;
import com.tencent.mm.emoji.b.b.i;
import com.tencent.mm.emoji.b.b.i.a;
import com.tencent.mm.emoji.b.b.m;
import com.tencent.mm.emoji.b.b.w;
import com.tencent.mm.emoji.b.q;
import com.tencent.mm.emoji.c.a;
import com.tencent.mm.plugin.m.a.d;
import com.tencent.mm.plugin.m.a.j;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.j;
import com.tencent.mm.protocal.protobuf.dkv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.EmojiInfo.b;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import kotlin.n.n;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelClickListener;", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "scene", "", "(I)V", "emojiCallback", "Lcom/tencent/mm/pluginsdk/ui/chat/SmileyPanelCallback;", "getEmojiCallback", "()Lcom/tencent/mm/pluginsdk/ui/chat/SmileyPanelCallback;", "setEmojiCallback", "(Lcom/tencent/mm/pluginsdk/ui/chat/SmileyPanelCallback;)V", "getScene", "()I", "setScene", "talkerName", "", "getTalkerName", "()Ljava/lang/String;", "setTalkerName", "(Ljava/lang/String;)V", "textOperationListener", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "getTextOperationListener", "()Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "setTextOperationListener", "(Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;)V", "dealCaptureEmojiClick", "", "context", "Landroid/content/Context;", "emoji", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "onClick", "view", "Landroid/view/View;", "position", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "onLongClick", "startCustomManager", "uploadEmoji", "plugin-emojisdk_release"})
public class e
  implements p
{
  public j jLH;
  public String jLI;
  public ChatFooterPanel.a jLs;
  public int scene;
  
  public e(int paramInt)
  {
    this.scene = paramInt;
  }
  
  public void a(View paramView, Context paramContext, int paramInt)
  {
    AppMethodBeat.i(224766);
    kotlin.g.b.p.k(paramContext, "context");
    AppMethodBeat.o(224766);
  }
  
  public void a(View paramView, final Context paramContext, int paramInt, final ae paramae)
  {
    AppMethodBeat.i(224794);
    kotlin.g.b.p.k(paramContext, "context");
    Log.i(g.aBy(), "onClick: " + paramInt + ", " + paramae);
    if (paramae == null)
    {
      AppMethodBeat.o(224794);
      return;
    }
    com.tencent.mm.emoji.c.h.aDe().scene = this.scene;
    com.tencent.mm.emoji.c.c.aDb().scene = this.scene;
    Object localObject;
    switch (paramae.type)
    {
    case 5: 
    default: 
      AppMethodBeat.o(224794);
      return;
    case 6: 
      paramae = ((com.tencent.mm.emoji.b.b.h)paramae).jHh;
      Log.i(g.aBy(), "penn send capture emoji click emoji: %s status: %d.", new Object[] { paramae.getMd5(), Integer.valueOf(paramae.field_captureStatus) });
      paramView = paramae.hBB();
      if (paramView == null)
      {
        AppMethodBeat.o(224794);
        return;
      }
      switch (f.jLJ[paramView.ordinal()])
      {
      default: 
        AppMethodBeat.o(224794);
        return;
      case 1: 
        paramView = this.jLH;
        if (paramView != null) {
          paramView.o(paramae);
        }
        Log.d(g.aBy(), "onSendCustomEmoji emoji md5 is [%s].", new Object[] { paramae.getMd5() });
        AppMethodBeat.o(224794);
        return;
      case 2: 
      case 3: 
        com.tencent.mm.ui.base.h.cL(paramContext, paramContext.getString(a.j.emoji_capture_loading_click_tips));
        AppMethodBeat.o(224794);
        return;
      case 4: 
        paramView = new f.a(paramContext);
        paramView.bBl(paramContext.getString(a.j.emoji_capture_failure_upload_local_file)).ayp(a.j.emoji_user_delete).ayq(paramContext.getResources().getColor(a.d.red_text_color));
        paramView.c((f.c)new e.a(paramae)).show();
        AppMethodBeat.o(224794);
        return;
      }
      paramView = paramae.hBE();
      Log.d(g.aBy(), "CaptureUploadErrCode: %d.", new Object[] { Integer.valueOf(paramView.ordinal()) });
      if (paramView == null) {}
      for (;;)
      {
        paramView = new f.a(paramContext);
        paramView.bBl(paramContext.getString(a.j.emoji_capture_failure_upload_tips)).ayp(a.j.emoji_capture_failure_upload_reupload);
        paramView.c((f.c)new g(this, paramContext, paramae)).show();
        break;
        switch (f.$EnumSwitchMapping$0[paramView.ordinal()])
        {
        }
      }
      paramView = new f.a(paramContext);
      paramView.bBl(paramContext.getString(a.j.emoji_capture_failure_upload_tips)).ayp(a.j.emoji_capture_failure_upload_reupload);
      paramView.c((f.c)new b(this, paramContext, paramae)).show();
      AppMethodBeat.o(224794);
      return;
      paramView = com.tencent.mm.emoji.b.l.jIq;
      if (com.tencent.mm.emoji.b.l.aBM())
      {
        paramView = new f.a(paramContext);
        paramView.bBl(paramContext.getString(a.j.emoji_upper_limit_warning)).bBp(paramContext.getString(a.j.emoji_store_mgr_alert));
        paramView.c((f.c)new e.c(paramContext)).show();
        AppMethodBeat.o(224794);
        return;
      }
      paramView = new f.a(paramContext);
      paramView.bBl(paramContext.getString(a.j.emoji_capture_failure_upload_tips)).ayp(a.j.emoji_capture_failure_upload_reupload);
      paramView.c((f.c)new d(this, paramContext, paramae)).show();
      AppMethodBeat.o(224794);
      return;
      paramView = new f.a(paramContext);
      paramView.bBl(paramContext.getString(a.j.emoji_capture_failure_upload_tips)).ayp(a.j.emoji_capture_failure_upload_reupload);
      paramView.c((f.c)new e(this, paramContext, paramae)).show();
      AppMethodBeat.o(224794);
      return;
      if (EmojiInfo.b.VIv == paramae.hBE())
      {
        paramView = paramContext.getString(a.j.emoji_capture_failure_upload_local_file);
        kotlin.g.b.p.j(paramView, "context.getString(R.stri…ailure_upload_local_file)");
      }
      for (;;)
      {
        localObject = new f.a(paramContext);
        ((f.a)localObject).bBl(paramView).ayp(a.j.emoji_user_delete).ayq(paramContext.getResources().getColor(a.d.red_text_color));
        ((f.a)localObject).c((f.c)new e.f(paramae)).show();
        AppMethodBeat.o(224794);
        return;
        if (EmojiInfo.b.VIw == paramae.hBE())
        {
          paramView = paramContext.getString(a.j.emoji_custom_gif_max_size_limit);
          kotlin.g.b.p.j(paramView, "context.getString(R.stri…ustom_gif_max_size_limit)");
        }
        else if (EmojiInfo.b.VIx == paramae.hBE())
        {
          paramView = paramContext.getString(a.j.emoji_capture_failure_upload_spam);
          kotlin.g.b.p.j(paramView, "context.getString(R.stri…ture_failure_upload_spam)");
        }
        else
        {
          paramView = paramContext.getString(a.j.emoji_capture_failure_upload_over_upload_max_count);
          kotlin.g.b.p.j(paramView, "context.getString(R.stri…ad_over_upload_max_count)");
        }
      }
    case 0: 
      paramView = (com.tencent.mm.emoji.b.b.h)paramae;
      paramContext = paramView.jHh;
      paramView = paramView.jHh;
      if (com.tencent.mm.plugin.emoji.i.b.A(paramView))
      {
        paramae = com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class);
        kotlin.g.b.p.j(paramae, "MMKernel.plugin(IPluginEmoji::class.java)");
        paramView = ((com.tencent.mm.plugin.emoji.b.d)paramae).getProvider().p(paramView);
        kotlin.g.b.p.j(paramView, "MMKernel.plugin(IPluginE…er.getRandomEmoji(toSend)");
      }
      break;
    }
    for (;;)
    {
      com.tencent.mm.emoji.c.h.aDe().c(paramInt, paramContext.field_md5, paramContext.field_groupId, paramContext.field_designerID, paramContext.field_activityid);
      paramContext = this.jLH;
      if (paramContext != null)
      {
        paramContext.o(paramView);
        AppMethodBeat.o(224794);
        return;
      }
      AppMethodBeat.o(224794);
      return;
      paramView = (ak)paramae;
      paramContext = com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class);
      kotlin.g.b.p.j(paramContext, "MMKernel.plugin(IPluginEmoji::class.java)");
      ((com.tencent.mm.plugin.emoji.b.d)paramContext).getProvider().aur(paramView.jKg.key);
      paramContext = f.htQ().buw(paramView.jKg.key);
      kotlin.g.b.p.j(paramContext, "MergerSmileyManager.getI…mileyItem.smileyInfo.key)");
      paramae = a.jNj;
      a.eA(paramView.jKh);
      com.tencent.mm.emoji.c.c.aDb().b(n.l(paramContext, ",", " ", false), paramView.jKh, paramView.jKi);
      paramView = this.jLs;
      if (paramView != null)
      {
        paramView.append(paramContext);
        AppMethodBeat.o(224794);
        return;
      }
      AppMethodBeat.o(224794);
      return;
      paramView = (m)paramae;
      if (paramView.jJH == 0)
      {
        com.tencent.mm.plugin.report.service.h.IzE.a(11594, new Object[] { Integer.valueOf(1) });
        com.tencent.mm.by.c.b(paramContext, "emoji", ".ui.EmojiCustomUI", new Intent());
        AppMethodBeat.o(224794);
        return;
      }
      if (paramView.jJH == 1)
      {
        paramView = com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class);
        kotlin.g.b.p.j(paramView, "MMKernel.plugin(IPluginEmoji::class.java)");
        paramView = ((com.tencent.mm.plugin.emoji.b.d)paramView).getProvider();
        kotlin.g.b.p.j(paramView, "MMKernel.plugin(IPluginEmoji::class.java).provider");
        if (paramView.aCa())
        {
          paramView = i.jJr;
          com.tencent.mm.plugin.emojicapture.api.b.b(paramContext, i.a.rA(this.scene), this.jLI);
        }
      }
      AppMethodBeat.o(224794);
      return;
      AppMethodBeat.o(224794);
      return;
      paramView = com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class);
      kotlin.g.b.p.j(paramView, "MMKernel.plugin(IPluginEmoji::class.java)");
      paramView = ((com.tencent.mm.plugin.emoji.b.d)paramView).getProvider();
      kotlin.g.b.p.j(paramView, "MMKernel.plugin(IPluginEmoji::class.java).provider");
      if (!paramView.aCa()) {
        break;
      }
      paramView = i.jJr;
      com.tencent.mm.plugin.emojicapture.api.b.b(paramContext, i.a.rA(this.scene), this.jLI);
      AppMethodBeat.o(224794);
      return;
      paramView = com.tencent.mm.emoji.c.d.jNt;
      com.tencent.mm.emoji.c.d.rE(2);
      paramView = ((w)paramae).jJM;
      if (paramView == null) {
        break;
      }
      paramae = new Intent();
      paramae.putExtra("uin", paramView.TdG);
      paramae.putExtra("name", paramView.CMP);
      paramae.putExtra("headurl", paramView.SuR);
      paramae.putExtra("extra_scence", 9);
      paramView = AndroidContextUtil.castActivityOrNull(paramContext);
      if (paramView != null)
      {
        localObject = paramView.getLocalClassName();
        if ((localObject != null) && (n.g((CharSequence)localObject, (CharSequence)"AppBrandUI") == true)) {
          paramae.putExtra("from_appbrand_ui", true);
        }
      }
      if (paramView != null) {}
      for (paramView = (Context)paramView;; paramView = paramContext)
      {
        com.tencent.mm.by.c.b(paramView, "emoji", ".ui.v2.EmojiStoreV2DesignerUI", paramae);
        break;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
  static final class b
    implements f.c
  {
    b(e parame, Context paramContext, EmojiInfo paramEmojiInfo) {}
    
    public final void g(boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(105633);
      if (paramBoolean) {
        e.m(paramae);
      }
      AppMethodBeat.o(105633);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
  static final class d
    implements f.c
  {
    d(e parame, Context paramContext, EmojiInfo paramEmojiInfo) {}
    
    public final void g(boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(105635);
      if (paramBoolean) {
        e.m(paramae);
      }
      AppMethodBeat.o(105635);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
  static final class e
    implements f.c
  {
    e(e parame, Context paramContext, EmojiInfo paramEmojiInfo) {}
    
    public final void g(boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(105636);
      if (paramBoolean) {
        e.m(paramae);
      }
      AppMethodBeat.o(105636);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
  static final class g
    implements f.c
  {
    g(e parame, Context paramContext, EmojiInfo paramEmojiInfo) {}
    
    public final void g(boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(161814);
      if (paramBoolean) {
        e.m(paramae);
      }
      AppMethodBeat.o(161814);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.e
 * JD-Core Version:    0.7.0.1
 */