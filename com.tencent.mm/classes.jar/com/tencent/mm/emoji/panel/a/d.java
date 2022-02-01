package com.tencent.mm.emoji.panel.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.c.b.ae;
import com.tencent.mm.emoji.c.b.ak;
import com.tencent.mm.emoji.c.b.i;
import com.tencent.mm.emoji.c.b.i.a;
import com.tencent.mm.emoji.c.b.w;
import com.tencent.mm.emoji.c.q;
import com.tencent.mm.emoji.d.a;
import com.tencent.mm.plugin.emojicapture.api.b;
import com.tencent.mm.plugin.m.a.d;
import com.tencent.mm.plugin.m.a.j;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.j;
import com.tencent.mm.protocal.protobuf.gok;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.smiley.o;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.EmojiInfo.a;
import com.tencent.mm.storage.emotion.EmojiInfo.b;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.a.g.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelClickListener;", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "scene", "", "(I)V", "emojiCallback", "Lcom/tencent/mm/pluginsdk/ui/chat/SmileyPanelCallback;", "getEmojiCallback", "()Lcom/tencent/mm/pluginsdk/ui/chat/SmileyPanelCallback;", "setEmojiCallback", "(Lcom/tencent/mm/pluginsdk/ui/chat/SmileyPanelCallback;)V", "getScene", "()I", "setScene", "talkerName", "", "getTalkerName", "()Ljava/lang/String;", "setTalkerName", "(Ljava/lang/String;)V", "textOperationListener", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "getTextOperationListener", "()Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "setTextOperationListener", "(Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;)V", "dealCaptureEmojiClick", "", "context", "Landroid/content/Context;", "emoji", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "onClick", "view", "Landroid/view/View;", "position", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "onLongClick", "startCustomManager", "uploadEmoji", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public class d
  implements n
{
  public ChatFooterPanel.a mkD;
  public j mkP;
  public String mkQ;
  public int scene;
  
  public d(int paramInt)
  {
    this.scene = paramInt;
  }
  
  private static final void a(d paramd, Context paramContext, EmojiInfo paramEmojiInfo, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(242471);
    s.u(paramd, "this$0");
    s.u(paramContext, "$context");
    s.u(paramEmojiInfo, "$emoji");
    if (paramBoolean) {
      l(paramEmojiInfo);
    }
    AppMethodBeat.o(242471);
  }
  
  private static final void a(EmojiInfo paramEmojiInfo, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(242470);
    s.u(paramEmojiInfo, "$emoji");
    if ((paramBoolean) && (!Util.isNullOrNil(paramEmojiInfo.getMd5()))) {
      ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aov(paramEmojiInfo.getMd5());
    }
    AppMethodBeat.o(242470);
  }
  
  private static final void b(d paramd, Context paramContext, EmojiInfo paramEmojiInfo, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(242481);
    s.u(paramd, "this$0");
    s.u(paramContext, "$context");
    s.u(paramEmojiInfo, "$emoji");
    if (paramBoolean) {
      l(paramEmojiInfo);
    }
    AppMethodBeat.o(242481);
  }
  
  private static final void b(EmojiInfo paramEmojiInfo, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(242484);
    s.u(paramEmojiInfo, "$emoji");
    if ((paramBoolean) && (!Util.isNullOrNil(paramEmojiInfo.getMd5()))) {
      ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aov(paramEmojiInfo.getMd5());
    }
    AppMethodBeat.o(242484);
  }
  
  private static final void c(Context paramContext, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(242477);
    s.u(paramContext, "$context");
    if (paramBoolean)
    {
      paramString = new Intent();
      paramString.putExtra("key_emoji_panel_type", 1);
      com.tencent.mm.br.c.b(paramContext, "emoji", ".ui.EmojiCustomUI", paramString);
    }
    AppMethodBeat.o(242477);
  }
  
  private static final void c(d paramd, Context paramContext, EmojiInfo paramEmojiInfo, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(242482);
    s.u(paramd, "this$0");
    s.u(paramContext, "$context");
    s.u(paramEmojiInfo, "$emoji");
    if (paramBoolean) {
      l(paramEmojiInfo);
    }
    AppMethodBeat.o(242482);
  }
  
  private static final void d(d paramd, Context paramContext, EmojiInfo paramEmojiInfo, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(242489);
    s.u(paramd, "this$0");
    s.u(paramContext, "$context");
    s.u(paramEmojiInfo, "$emoji");
    if (paramBoolean) {
      l(paramEmojiInfo);
    }
    AppMethodBeat.o(242489);
  }
  
  private static void l(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(242465);
    EmojiInfo.a locala = paramEmojiInfo.kMj();
    paramEmojiInfo.a(EmojiInfo.a.admh);
    ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().updateEmojiInfo(paramEmojiInfo);
    paramEmojiInfo.a(locala);
    ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getProvider().aow(paramEmojiInfo.field_md5);
    AppMethodBeat.o(242465);
  }
  
  public void a(View paramView, Context paramContext, int paramInt)
  {
    AppMethodBeat.i(242513);
    s.u(paramContext, "context");
    AppMethodBeat.o(242513);
  }
  
  public void a(View paramView, Context paramContext, int paramInt, ae paramae)
  {
    AppMethodBeat.i(242522);
    s.u(paramContext, "context");
    Log.i(e.aUw(), "onClick: " + paramInt + ", " + paramae);
    if (paramae == null)
    {
      AppMethodBeat.o(242522);
      return;
    }
    com.tencent.mm.emoji.d.h.aWe().scene = this.scene;
    com.tencent.mm.emoji.d.c.aWb().scene = this.scene;
    label244:
    Object localObject;
    switch (paramae.type)
    {
    case 5: 
    default: 
      AppMethodBeat.o(242522);
      return;
    case 6: 
      if (paramae == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.emoji.model.panel.EmojiItem");
        AppMethodBeat.o(242522);
        throw paramView;
      }
      paramae = ((com.tencent.mm.emoji.c.b.h)paramae).mgK;
      Log.i(e.aUw(), "penn send capture emoji click emoji: %s status: %d.", new Object[] { paramae.getMd5(), Integer.valueOf(paramae.field_captureStatus) });
      paramView = paramae.kMj();
      if (paramView == null) {}
      for (paramInt = -1;; paramInt = a.$EnumSwitchMapping$0[paramView.ordinal()]) {
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(242522);
          return;
        }
      }
      paramView = this.mkP;
      if (paramView != null) {
        paramView.o(paramae);
      }
      Log.d(e.aUw(), "onSendCustomEmoji emoji md5 is [%s].", new Object[] { paramae.getMd5() });
      AppMethodBeat.o(242522);
      return;
      k.cZ(paramContext, paramContext.getString(a.j.emoji_capture_loading_click_tips));
      AppMethodBeat.o(242522);
      return;
      paramView = new g.a(paramContext);
      paramView.bDE(paramContext.getString(a.j.emoji_capture_failure_upload_local_file)).aEX(a.j.emoji_user_delete).aEY(paramContext.getResources().getColor(a.d.red_text_color));
      paramView.c(new d..ExternalSyntheticLambda6(paramae)).show();
      AppMethodBeat.o(242522);
      return;
      paramView = paramae.kMl();
      Log.d(e.aUw(), "CaptureUploadErrCode: %d.", new Object[] { Integer.valueOf(paramView.ordinal()) });
      if (paramView == null) {}
      for (paramInt = -1;; paramInt = a.avl[paramView.ordinal()]) {
        switch (paramInt)
        {
        default: 
          paramView = new g.a(paramContext);
          paramView.bDE(paramContext.getString(a.j.emoji_capture_failure_upload_tips)).aEX(a.j.emoji_capture_failure_upload_reupload);
          paramView.c(new d..ExternalSyntheticLambda4(this, paramContext, paramae)).show();
          break label244;
        }
      }
      paramView = new g.a(paramContext);
      paramView.bDE(paramContext.getString(a.j.emoji_capture_failure_upload_tips)).aEX(a.j.emoji_capture_failure_upload_reupload);
      paramView.c(new d..ExternalSyntheticLambda2(this, paramContext, paramae)).show();
      AppMethodBeat.o(242522);
      return;
      paramView = com.tencent.mm.emoji.c.m.mhY;
      if (com.tencent.mm.emoji.c.m.aUK())
      {
        paramView = new g.a(paramContext);
        paramView.bDE(paramContext.getString(a.j.emoji_upper_limit_warning)).bDI(paramContext.getString(a.j.emoji_store_mgr_alert));
        paramView.c(new d..ExternalSyntheticLambda0(paramContext)).show();
        AppMethodBeat.o(242522);
        return;
      }
      paramView = new g.a(paramContext);
      paramView.bDE(paramContext.getString(a.j.emoji_capture_failure_upload_tips)).aEX(a.j.emoji_capture_failure_upload_reupload);
      paramView.c(new d..ExternalSyntheticLambda3(this, paramContext, paramae)).show();
      AppMethodBeat.o(242522);
      return;
      paramView = new g.a(paramContext);
      paramView.bDE(paramContext.getString(a.j.emoji_capture_failure_upload_tips)).aEX(a.j.emoji_capture_failure_upload_reupload);
      paramView.c(new d..ExternalSyntheticLambda1(this, paramContext, paramae)).show();
      AppMethodBeat.o(242522);
      return;
      if (EmojiInfo.b.admr == paramae.kMl())
      {
        paramView = paramContext.getString(a.j.emoji_capture_failure_upload_local_file);
        s.s(paramView, "context.getString(R.stri…ailure_upload_local_file)");
      }
      for (;;)
      {
        localObject = new g.a(paramContext);
        ((g.a)localObject).bDE(paramView).aEX(a.j.emoji_user_delete).aEY(paramContext.getResources().getColor(a.d.red_text_color));
        ((g.a)localObject).c(new d..ExternalSyntheticLambda5(paramae)).show();
        AppMethodBeat.o(242522);
        return;
        if (EmojiInfo.b.adms == paramae.kMl())
        {
          paramView = paramContext.getString(a.j.emoji_custom_gif_max_size_limit);
          s.s(paramView, "context.getString(R.stri…ustom_gif_max_size_limit)");
        }
        else if (EmojiInfo.b.admt == paramae.kMl())
        {
          paramView = paramContext.getString(a.j.emoji_capture_failure_upload_spam);
          s.s(paramView, "context.getString(R.stri…ture_failure_upload_spam)");
        }
        else
        {
          paramView = paramContext.getString(a.j.emoji_capture_failure_upload_over_upload_max_count);
          s.s(paramView, "context.getString(R.stri…ad_over_upload_max_count)");
        }
      }
    case 0: 
      if (paramae == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.emoji.model.panel.EmojiItem");
        AppMethodBeat.o(242522);
        throw paramView;
      }
      paramView = (com.tencent.mm.emoji.c.b.h)paramae;
      paramContext = paramView.mgK;
      paramView = paramView.mgK;
      if (com.tencent.mm.plugin.emoji.g.d.A(paramView))
      {
        paramView = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getProvider().p(paramView);
        s.s(paramView, "plugin(IPluginEmoji::cla…er.getRandomEmoji(toSend)");
      }
      break;
    }
    for (;;)
    {
      paramae = com.tencent.mm.emoji.d.h.aWe();
      localObject = paramContext.field_md5;
      String str1 = paramContext.field_groupId;
      String str2 = paramContext.field_designerID;
      paramContext = paramContext.field_activityid;
      long l1 = System.currentTimeMillis();
      long l2 = paramae.mmo;
      com.tencent.mm.plugin.report.service.h.OAn.b(16029, new Object[] { localObject, str1, str2, paramContext, Integer.valueOf(paramae.scene), Long.valueOf(l1 - l2), Integer.valueOf(paramae.mmp), Integer.valueOf(paramae.mmy), Integer.valueOf(paramae.mmz), Integer.valueOf(0), Integer.valueOf(paramInt), Integer.valueOf(paramae.mmA), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramae.mmq), paramae.extraInfo, Long.valueOf(l1), Long.valueOf(paramae.mmo) });
      paramae.mmp += 1;
      paramContext = this.mkP;
      if (paramContext == null) {
        break;
      }
      paramContext.o(paramView);
      AppMethodBeat.o(242522);
      return;
      if (paramae == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.emoji.model.panel.SmileyItem");
        AppMethodBeat.o(242522);
        throw paramView;
      }
      paramContext = (ak)paramae;
      ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getProvider().aos(paramContext.mjw.key);
      paramView = o.iVl().buD(paramContext.mjw.key);
      s.s(paramView, "getInstance().getText(smileyItem.smileyInfo.key)");
      paramae = a.mmh;
      a.fl(paramContext.mjx);
      paramae = com.tencent.mm.emoji.d.c.aWb();
      localObject = kotlin.n.n.bV(paramView, ",", " ");
      boolean bool = paramContext.mjx;
      int j = paramContext.mjy;
      l1 = System.currentTimeMillis();
      l2 = paramae.mmo;
      paramContext = com.tencent.mm.plugin.report.service.h.OAn;
      int k = paramae.scene;
      if (bool)
      {
        paramInt = 1;
        label1382:
        if (!paramae.mjA) {
          break label1552;
        }
      }
      label1552:
      for (int i = 1;; i = 0)
      {
        paramContext.b(13470, new Object[] { localObject, Integer.valueOf(k), Integer.valueOf(paramInt), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramae.mmq), Integer.valueOf(paramae.mmp), Long.valueOf(l1 - l2), Long.valueOf(l1), Long.valueOf(paramae.mmo) });
        paramae.mmp += 1;
        paramContext = this.mkD;
        if (paramContext == null) {
          break;
        }
        paramContext.append(paramView);
        AppMethodBeat.o(242522);
        return;
        paramInt = 0;
        break label1382;
      }
      if (paramae == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.emoji.model.panel.EntranceItem");
        AppMethodBeat.o(242522);
        throw paramView;
      }
      paramView = (com.tencent.mm.emoji.c.b.m)paramae;
      if (paramView.miZ == 0)
      {
        com.tencent.mm.plugin.report.service.h.OAn.b(11594, new Object[] { Integer.valueOf(1) });
        com.tencent.mm.br.c.b(paramContext, "emoji", ".ui.EmojiCustomUI", new Intent());
        AppMethodBeat.o(242522);
        return;
      }
      if ((paramView.miZ != 1) || (!((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getProvider().aUX())) {
        break;
      }
      paramView = i.mix;
      b.d(paramContext, i.a.rC(this.scene), this.mkQ);
      AppMethodBeat.o(242522);
      return;
      AppMethodBeat.o(242522);
      return;
      if (!((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getProvider().aUX()) {
        break;
      }
      paramView = i.mix;
      b.d(paramContext, i.a.rC(this.scene), this.mkQ);
      AppMethodBeat.o(242522);
      return;
      if (((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu())
      {
        ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).kg(paramContext);
        AppMethodBeat.o(242522);
        return;
      }
      paramView = com.tencent.mm.emoji.d.d.mmr;
      com.tencent.mm.emoji.d.d.rG(2);
      if (paramae == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.emoji.model.panel.GroupTitleItem");
        AppMethodBeat.o(242522);
        throw paramView;
      }
      paramae = ((w)paramae).mje;
      if (paramae == null) {
        break;
      }
      paramView = new Intent();
      paramView.putExtra("uin", paramae.ZtX);
      paramView.putExtra("name", paramae.IGU);
      paramView.putExtra("headurl", paramae.ZuK);
      paramView.putExtra("extra_scence", 9);
      paramae = AndroidContextUtil.castActivityOrNull(paramContext);
      if (paramae != null)
      {
        localObject = paramae.getLocalClassName();
        if ((localObject != null) && (kotlin.n.n.i((CharSequence)localObject, (CharSequence)"AppBrandUI") == true))
        {
          paramInt = 1;
          label1925:
          if (paramInt != 0) {
            paramView.putExtra("from_appbrand_ui", true);
          }
          if (paramae != null) {
            break label1961;
          }
        }
      }
      for (;;)
      {
        com.tencent.mm.br.c.b(paramContext, "emoji", ".ui.v2.EmojiStoreV2DesignerUI", paramView);
        break;
        paramInt = 0;
        break label1925;
        label1961:
        paramContext = (Context)paramae;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.d
 * JD-Core Version:    0.7.0.1
 */