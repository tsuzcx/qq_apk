package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.a.ae;
import com.tencent.mm.emoji.a.a.i.a;
import com.tencent.mm.emoji.a.a.m;
import com.tencent.mm.emoji.a.a.q;
import com.tencent.mm.emoji.a.a.y;
import com.tencent.mm.emoji.b.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.j;
import com.tencent.mm.protocal.protobuf.PersonalDesigner;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.EmojiInfo.b;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelClickListener;", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "scene", "", "(I)V", "emojiCallback", "Lcom/tencent/mm/pluginsdk/ui/chat/SmileyPanelCallback;", "getEmojiCallback", "()Lcom/tencent/mm/pluginsdk/ui/chat/SmileyPanelCallback;", "setEmojiCallback", "(Lcom/tencent/mm/pluginsdk/ui/chat/SmileyPanelCallback;)V", "getScene", "()I", "setScene", "talkerName", "", "getTalkerName", "()Ljava/lang/String;", "setTalkerName", "(Ljava/lang/String;)V", "textOperationListener", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "getTextOperationListener", "()Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "setTextOperationListener", "(Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;)V", "dealCaptureEmojiClick", "", "context", "Landroid/content/Context;", "emoji", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "onClick", "position", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "onLongClick", "view", "Landroid/view/View;", "startCustomManager", "uploadEmoji", "plugin-emojisdk_release"})
public class d
  implements n
{
  public ChatFooterPanel.a fPD;
  public j fPO;
  public String fPP;
  public int scene;
  
  public d(int paramInt)
  {
    this.scene = paramInt;
  }
  
  public void a(final Context paramContext, int paramInt, y paramy)
  {
    AppMethodBeat.i(105638);
    k.h(paramContext, "context");
    ad.i(f.abb(), "onClick: " + paramInt + ", " + paramy);
    if (paramy == null)
    {
      AppMethodBeat.o(105638);
      return;
    }
    com.tencent.mm.emoji.b.f.acp().scene = this.scene;
    com.tencent.mm.emoji.b.b.acm().scene = this.scene;
    Object localObject;
    switch (paramy.type)
    {
    case 5: 
    default: 
      AppMethodBeat.o(105638);
      return;
    case 6: 
      localObject = ((com.tencent.mm.emoji.a.a.h)paramy).fLP;
      ad.i(f.abb(), "penn send capture emoji click emoji: %s status: %d.", new Object[] { ((EmojiInfo)localObject).JS(), Integer.valueOf(((EmojiInfo)localObject).field_captureStatus) });
      paramy = ((EmojiInfo)localObject).fZV();
      if (paramy == null)
      {
        AppMethodBeat.o(105638);
        return;
      }
      switch (e.fPQ[paramy.ordinal()])
      {
      default: 
        AppMethodBeat.o(105638);
        return;
      case 1: 
        paramContext = this.fPO;
        if (paramContext != null) {
          paramContext.B((EmojiInfo)localObject);
        }
        ad.d(f.abb(), "onSendCustomEmoji emoji md5 is [%s].", new Object[] { ((EmojiInfo)localObject).JS() });
        AppMethodBeat.o(105638);
        return;
      case 2: 
      case 3: 
        com.tencent.mm.ui.base.h.cc(paramContext, paramContext.getString(2131758224));
        AppMethodBeat.o(105638);
        return;
      case 4: 
        paramy = new f.a(paramContext);
        paramy.aMo(paramContext.getString(2131758219)).aaF(2131758414).aaG(paramContext.getResources().getColor(2131100800));
        paramy.c((f.c)new d.a((EmojiInfo)localObject)).show();
        AppMethodBeat.o(105638);
        return;
      }
      paramy = ((EmojiInfo)localObject).fZY();
      ad.d(f.abb(), "CaptureUploadErrCode: %d.", new Object[] { Integer.valueOf(paramy.ordinal()) });
      if (paramy == null) {}
      for (;;)
      {
        paramy = new f.a(paramContext);
        paramy.aMo(paramContext.getString(2131758223)).aaF(2131758221);
        paramy.c((f.c)new g(this, paramContext, (EmojiInfo)localObject)).show();
        break;
        switch (e.ciE[paramy.ordinal()])
        {
        }
      }
      paramy = new f.a(paramContext);
      paramy.aMo(paramContext.getString(2131758223)).aaF(2131758221);
      paramy.c((f.c)new b(this, paramContext, (EmojiInfo)localObject)).show();
      AppMethodBeat.o(105638);
      return;
      paramy = com.tencent.mm.emoji.a.i.fMT;
      if (com.tencent.mm.emoji.a.i.abm())
      {
        paramy = new f.a(paramContext);
        paramy.aMo(paramContext.getString(2131758413)).aMs(paramContext.getString(2131758337));
        paramy.c((f.c)new d.c(paramContext)).show();
        AppMethodBeat.o(105638);
        return;
      }
      paramy = new f.a(paramContext);
      paramy.aMo(paramContext.getString(2131758223)).aaF(2131758221);
      paramy.c((f.c)new d(this, paramContext, (EmojiInfo)localObject)).show();
      AppMethodBeat.o(105638);
      return;
      paramy = new f.a(paramContext);
      paramy.aMo(paramContext.getString(2131758223)).aaF(2131758221);
      paramy.c((f.c)new e(this, paramContext, (EmojiInfo)localObject)).show();
      AppMethodBeat.o(105638);
      return;
      if (EmojiInfo.b.FBI == ((EmojiInfo)localObject).fZY())
      {
        paramy = paramContext.getString(2131758219);
        k.g(paramy, "context.getString(R.stri…ailure_upload_local_file)");
      }
      for (;;)
      {
        f.a locala = new f.a(paramContext);
        locala.aMo(paramy).aaF(2131758414).aaG(paramContext.getResources().getColor(2131100800));
        locala.c((f.c)new d.f((EmojiInfo)localObject)).show();
        AppMethodBeat.o(105638);
        return;
        if (EmojiInfo.b.FBJ == ((EmojiInfo)localObject).fZY())
        {
          paramy = paramContext.getString(2131758245);
          k.g(paramy, "context.getString(R.stri…ustom_gif_max_size_limit)");
        }
        else if (EmojiInfo.b.FBK == ((EmojiInfo)localObject).fZY())
        {
          paramy = paramContext.getString(2131758222);
          k.g(paramy, "context.getString(R.stri…ture_failure_upload_spam)");
        }
        else
        {
          paramy = paramContext.getString(2131758220);
          k.g(paramy, "context.getString(R.stri…ad_over_upload_max_count)");
        }
      }
    case 0: 
      paramContext = (com.tencent.mm.emoji.a.a.h)paramy;
      paramy = paramContext.fLP;
      paramContext = paramContext.fLP;
      if (paramContext.getGroup() == EmojiGroupInfo.LBO)
      {
        localObject = g.ad(com.tencent.mm.plugin.emoji.b.d.class);
        k.g(localObject, "MMKernel.plugin(IPluginEmoji::class.java)");
        paramContext = ((com.tencent.mm.plugin.emoji.b.d)localObject).getProvider().p(paramContext);
        k.g(paramContext, "MMKernel.plugin(IPluginE…er.getRandomEmoji(toSend)");
      }
      break;
    }
    for (;;)
    {
      com.tencent.mm.emoji.b.f.acp().b(paramInt, paramy.field_md5, paramy.field_groupId, paramy.field_designerID, paramy.field_activityid);
      paramy = this.fPO;
      if (paramy != null)
      {
        paramy.B(paramContext);
        AppMethodBeat.o(105638);
        return;
      }
      AppMethodBeat.o(105638);
      return;
      paramContext = (ae)paramy;
      paramy = g.ad(com.tencent.mm.plugin.emoji.b.d.class);
      k.g(paramy, "MMKernel.plugin(IPluginEmoji::class.java)");
      ((com.tencent.mm.plugin.emoji.b.d)paramy).getProvider().TL(paramContext.fOB.key);
      paramy = com.tencent.mm.cg.e.eHT().aGO(paramContext.fOB.key);
      k.g(paramy, "MergerSmileyManager.getI…mileyItem.smileyInfo.key)");
      com.tencent.mm.emoji.b.b.acm().a(d.n.n.h(paramy, ",", " ", false), paramContext.fOC, paramContext.fOD);
      paramContext = this.fPD;
      if (paramContext != null)
      {
        paramContext.append(paramy);
        AppMethodBeat.o(105638);
        return;
      }
      AppMethodBeat.o(105638);
      return;
      paramy = (m)paramy;
      if (paramy.fOf == 0)
      {
        com.tencent.mm.plugin.report.service.h.vKh.f(11594, new Object[] { Integer.valueOf(1) });
        com.tencent.mm.bs.d.b(paramContext, "emoji", ".ui.EmojiCustomUI", new Intent());
        AppMethodBeat.o(105638);
        return;
      }
      if (paramy.fOf == 1)
      {
        paramy = g.ad(com.tencent.mm.plugin.emoji.b.d.class);
        k.g(paramy, "MMKernel.plugin(IPluginEmoji::class.java)");
        paramy = ((com.tencent.mm.plugin.emoji.b.d)paramy).getProvider();
        k.g(paramy, "MMKernel.plugin(IPluginEmoji::class.java).provider");
        if (paramy.abA())
        {
          paramy = com.tencent.mm.emoji.a.a.i.fNQ;
          com.tencent.mm.plugin.emojicapture.api.b.b(paramContext, i.a.lC(this.scene), this.fPP);
        }
      }
      AppMethodBeat.o(105638);
      return;
      AppMethodBeat.o(105638);
      return;
      paramy = g.ad(com.tencent.mm.plugin.emoji.b.d.class);
      k.g(paramy, "MMKernel.plugin(IPluginEmoji::class.java)");
      paramy = ((com.tencent.mm.plugin.emoji.b.d)paramy).getProvider();
      k.g(paramy, "MMKernel.plugin(IPluginEmoji::class.java).provider");
      if (!paramy.abA()) {
        break;
      }
      paramy = com.tencent.mm.emoji.a.a.i.fNQ;
      com.tencent.mm.plugin.emojicapture.api.b.b(paramContext, i.a.lC(this.scene), this.fPP);
      AppMethodBeat.o(105638);
      return;
      localObject = c.fRg;
      c.lI(2);
      paramy = ((q)paramy).fOh;
      if (paramy == null) {
        break;
      }
      localObject = new Intent();
      ((Intent)localObject).putExtra("uin", paramy.DesignerUin);
      ((Intent)localObject).putExtra("name", paramy.Name);
      ((Intent)localObject).putExtra("headurl", paramy.HeadUrl);
      ((Intent)localObject).putExtra("extra_scence", 9);
      com.tencent.mm.bs.d.b(paramContext, "emoji", ".ui.v2.EmojiStoreV2DesignerUI", (Intent)localObject);
      break;
    }
  }
  
  public final void a(View paramView, Context paramContext, int paramInt)
  {
    AppMethodBeat.i(193411);
    k.h(paramContext, "context");
    AppMethodBeat.o(193411);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
  static final class b
    implements f.c
  {
    b(d paramd, Context paramContext, EmojiInfo paramEmojiInfo) {}
    
    public final void d(boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(105633);
      if (paramBoolean) {
        d.m(this.fPR);
      }
      AppMethodBeat.o(105633);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
  static final class d
    implements f.c
  {
    d(d paramd, Context paramContext, EmojiInfo paramEmojiInfo) {}
    
    public final void d(boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(105635);
      if (paramBoolean) {
        d.m(this.fPR);
      }
      AppMethodBeat.o(105635);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
  static final class e
    implements f.c
  {
    e(d paramd, Context paramContext, EmojiInfo paramEmojiInfo) {}
    
    public final void d(boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(105636);
      if (paramBoolean) {
        d.m(this.fPR);
      }
      AppMethodBeat.o(105636);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
  static final class g
    implements f.c
  {
    g(d paramd, Context paramContext, EmojiInfo paramEmojiInfo) {}
    
    public final void d(boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(161814);
      if (paramBoolean) {
        d.m(this.fPR);
      }
      AppMethodBeat.o(161814);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.d
 * JD-Core Version:    0.7.0.1
 */