package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.b.ac;
import com.tencent.mm.emoji.a.b.ai;
import com.tencent.mm.emoji.a.b.i;
import com.tencent.mm.emoji.a.b.i.a;
import com.tencent.mm.emoji.a.b.m;
import com.tencent.mm.emoji.a.b.u;
import com.tencent.mm.emoji.a.o;
import com.tencent.mm.emoji.b.c;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.protocal.protobuf.PersonalDesigner;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.EmojiInfo.b;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelClickListener;", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "scene", "", "(I)V", "emojiCallback", "Lcom/tencent/mm/pluginsdk/ui/chat/SmileyPanelCallback;", "getEmojiCallback", "()Lcom/tencent/mm/pluginsdk/ui/chat/SmileyPanelCallback;", "setEmojiCallback", "(Lcom/tencent/mm/pluginsdk/ui/chat/SmileyPanelCallback;)V", "getScene", "()I", "setScene", "talkerName", "", "getTalkerName", "()Ljava/lang/String;", "setTalkerName", "(Ljava/lang/String;)V", "textOperationListener", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "getTextOperationListener", "()Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "setTextOperationListener", "(Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;)V", "dealCaptureEmojiClick", "", "context", "Landroid/content/Context;", "emoji", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "onClick", "position", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "onLongClick", "view", "Landroid/view/View;", "startCustomManager", "uploadEmoji", "plugin-emojisdk_release"})
public class d
  implements n
{
  public com.tencent.mm.pluginsdk.ui.chat.j gpJ;
  public String gpK;
  public ChatFooterPanel.a gpy;
  public int scene;
  
  public d(int paramInt)
  {
    this.scene = paramInt;
  }
  
  public void a(final Context paramContext, int paramInt, ac paramac)
  {
    AppMethodBeat.i(105638);
    p.h(paramContext, "context");
    ae.i(f.aeP(), "onClick: " + paramInt + ", " + paramac);
    if (paramac == null)
    {
      AppMethodBeat.o(105638);
      return;
    }
    com.tencent.mm.emoji.b.f.agp().scene = this.scene;
    com.tencent.mm.emoji.b.b.agm().scene = this.scene;
    Object localObject;
    switch (paramac.type)
    {
    case 5: 
    default: 
      AppMethodBeat.o(105638);
      return;
    case 6: 
      localObject = ((com.tencent.mm.emoji.a.b.h)paramac).glt;
      ae.i(f.aeP(), "penn send capture emoji click emoji: %s status: %d.", new Object[] { ((EmojiInfo)localObject).Lj(), Integer.valueOf(((EmojiInfo)localObject).field_captureStatus) });
      paramac = ((EmojiInfo)localObject).fxx();
      if (paramac == null)
      {
        AppMethodBeat.o(105638);
        return;
      }
      switch (e.gpL[paramac.ordinal()])
      {
      default: 
        AppMethodBeat.o(105638);
        return;
      case 1: 
        paramContext = this.gpJ;
        if (paramContext != null) {
          paramContext.A((EmojiInfo)localObject);
        }
        ae.d(f.aeP(), "onSendCustomEmoji emoji md5 is [%s].", new Object[] { ((EmojiInfo)localObject).Lj() });
        AppMethodBeat.o(105638);
        return;
      case 2: 
      case 3: 
        com.tencent.mm.ui.base.h.cj(paramContext, paramContext.getString(2131758224));
        AppMethodBeat.o(105638);
        return;
      case 4: 
        paramac = new f.a(paramContext);
        paramac.aZq(paramContext.getString(2131758219)).afY(2131758414).afZ(paramContext.getResources().getColor(2131100800));
        paramac.c((f.c)new d.a((EmojiInfo)localObject)).show();
        AppMethodBeat.o(105638);
        return;
      }
      paramac = ((EmojiInfo)localObject).fRh();
      ae.d(f.aeP(), "CaptureUploadErrCode: %d.", new Object[] { Integer.valueOf(paramac.ordinal()) });
      if (paramac == null) {}
      for (;;)
      {
        paramac = new f.a(paramContext);
        paramac.aZq(paramContext.getString(2131758223)).afY(2131758221);
        paramac.c((f.c)new g(this, paramContext, (EmojiInfo)localObject)).show();
        break;
        switch (e.cqt[paramac.ordinal()])
        {
        }
      }
      paramac = new f.a(paramContext);
      paramac.aZq(paramContext.getString(2131758223)).afY(2131758221);
      paramac.c((f.c)new b(this, paramContext, (EmojiInfo)localObject)).show();
      AppMethodBeat.o(105638);
      return;
      paramac = com.tencent.mm.emoji.a.j.gmz;
      if (com.tencent.mm.emoji.a.j.afc())
      {
        paramac = new f.a(paramContext);
        paramac.aZq(paramContext.getString(2131758413)).aZu(paramContext.getString(2131758337));
        paramac.c((f.c)new d.c(paramContext)).show();
        AppMethodBeat.o(105638);
        return;
      }
      paramac = new f.a(paramContext);
      paramac.aZq(paramContext.getString(2131758223)).afY(2131758221);
      paramac.c((f.c)new d(this, paramContext, (EmojiInfo)localObject)).show();
      AppMethodBeat.o(105638);
      return;
      paramac = new f.a(paramContext);
      paramac.aZq(paramContext.getString(2131758223)).afY(2131758221);
      paramac.c((f.c)new e(this, paramContext, (EmojiInfo)localObject)).show();
      AppMethodBeat.o(105638);
      return;
      if (EmojiInfo.b.JiE == ((EmojiInfo)localObject).fRh())
      {
        paramac = paramContext.getString(2131758219);
        p.g(paramac, "context.getString(R.stri…ailure_upload_local_file)");
      }
      for (;;)
      {
        f.a locala = new f.a(paramContext);
        locala.aZq(paramac).afY(2131758414).afZ(paramContext.getResources().getColor(2131100800));
        locala.c((f.c)new d.f((EmojiInfo)localObject)).show();
        AppMethodBeat.o(105638);
        return;
        if (EmojiInfo.b.JiF == ((EmojiInfo)localObject).fRh())
        {
          paramac = paramContext.getString(2131758245);
          p.g(paramac, "context.getString(R.stri…ustom_gif_max_size_limit)");
        }
        else if (EmojiInfo.b.JiG == ((EmojiInfo)localObject).fRh())
        {
          paramac = paramContext.getString(2131758222);
          p.g(paramac, "context.getString(R.stri…ture_failure_upload_spam)");
        }
        else
        {
          paramac = paramContext.getString(2131758220);
          p.g(paramac, "context.getString(R.stri…ad_over_upload_max_count)");
        }
      }
    case 0: 
      paramContext = (com.tencent.mm.emoji.a.b.h)paramac;
      paramac = paramContext.glt;
      paramContext = paramContext.glt;
      if (paramContext.getGroup() == EmojiGroupInfo.OzS)
      {
        localObject = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class);
        p.g(localObject, "MMKernel.plugin(IPluginEmoji::class.java)");
        paramContext = ((com.tencent.mm.plugin.emoji.b.d)localObject).getProvider().p(paramContext);
        p.g(paramContext, "MMKernel.plugin(IPluginE…er.getRandomEmoji(toSend)");
      }
      break;
    }
    for (;;)
    {
      com.tencent.mm.emoji.b.f.agp().b(paramInt, paramac.field_md5, paramac.field_groupId, paramac.field_designerID, paramac.field_activityid);
      paramac = this.gpJ;
      if (paramac != null)
      {
        paramac.A(paramContext);
        AppMethodBeat.o(105638);
        return;
      }
      AppMethodBeat.o(105638);
      return;
      paramContext = (ai)paramac;
      paramac = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class);
      p.g(paramac, "MMKernel.plugin(IPluginEmoji::class.java)");
      ((com.tencent.mm.plugin.emoji.b.d)paramac).getProvider().acu(paramContext.gol.key);
      paramac = com.tencent.mm.ce.e.fqT().aTk(paramContext.gol.key);
      p.g(paramac, "MergerSmileyManager.getI…mileyItem.smileyInfo.key)");
      com.tencent.mm.emoji.b.b.agm().a(d.n.n.h(paramac, ",", " ", false), paramContext.gom, paramContext.gon);
      paramContext = this.gpy;
      if (paramContext != null)
      {
        paramContext.append(paramac);
        AppMethodBeat.o(105638);
        return;
      }
      AppMethodBeat.o(105638);
      return;
      paramac = (m)paramac;
      if (paramac.gnM == 0)
      {
        com.tencent.mm.plugin.report.service.g.yxI.f(11594, new Object[] { Integer.valueOf(1) });
        com.tencent.mm.br.d.b(paramContext, "emoji", ".ui.EmojiCustomUI", new Intent());
        AppMethodBeat.o(105638);
        return;
      }
      if (paramac.gnM == 1)
      {
        paramac = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class);
        p.g(paramac, "MMKernel.plugin(IPluginEmoji::class.java)");
        paramac = ((com.tencent.mm.plugin.emoji.b.d)paramac).getProvider();
        p.g(paramac, "MMKernel.plugin(IPluginEmoji::class.java).provider");
        if (paramac.afr())
        {
          paramac = i.gnw;
          com.tencent.mm.plugin.emojicapture.api.b.b(paramContext, i.a.lZ(this.scene), this.gpK);
        }
      }
      AppMethodBeat.o(105638);
      return;
      AppMethodBeat.o(105638);
      return;
      paramac = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class);
      p.g(paramac, "MMKernel.plugin(IPluginEmoji::class.java)");
      paramac = ((com.tencent.mm.plugin.emoji.b.d)paramac).getProvider();
      p.g(paramac, "MMKernel.plugin(IPluginEmoji::class.java).provider");
      if (!paramac.afr()) {
        break;
      }
      paramac = i.gnw;
      com.tencent.mm.plugin.emojicapture.api.b.b(paramContext, i.a.lZ(this.scene), this.gpK);
      AppMethodBeat.o(105638);
      return;
      localObject = c.gqZ;
      c.md(2);
      paramac = ((u)paramac).gnR;
      if (paramac == null) {
        break;
      }
      localObject = new Intent();
      ((Intent)localObject).putExtra("uin", paramac.DesignerUin);
      ((Intent)localObject).putExtra("name", paramac.Name);
      ((Intent)localObject).putExtra("headurl", paramac.HeadUrl);
      ((Intent)localObject).putExtra("extra_scence", 9);
      com.tencent.mm.br.d.b(paramContext, "emoji", ".ui.v2.EmojiStoreV2DesignerUI", (Intent)localObject);
      break;
    }
  }
  
  public final void a(View paramView, Context paramContext, int paramInt)
  {
    AppMethodBeat.i(188601);
    p.h(paramContext, "context");
    AppMethodBeat.o(188601);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
  static final class b
    implements f.c
  {
    b(d paramd, Context paramContext, EmojiInfo paramEmojiInfo) {}
    
    public final void d(boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(105633);
      if (paramBoolean) {
        d.m(this.gpM);
      }
      AppMethodBeat.o(105633);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
  static final class d
    implements f.c
  {
    d(d paramd, Context paramContext, EmojiInfo paramEmojiInfo) {}
    
    public final void d(boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(105635);
      if (paramBoolean) {
        d.m(this.gpM);
      }
      AppMethodBeat.o(105635);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
  static final class e
    implements f.c
  {
    e(d paramd, Context paramContext, EmojiInfo paramEmojiInfo) {}
    
    public final void d(boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(105636);
      if (paramBoolean) {
        d.m(this.gpM);
      }
      AppMethodBeat.o(105636);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
  static final class g
    implements f.c
  {
    g(d paramd, Context paramContext, EmojiInfo paramEmojiInfo) {}
    
    public final void d(boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(161814);
      if (paramBoolean) {
        d.m(this.gpM);
      }
      AppMethodBeat.o(161814);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.d
 * JD-Core Version:    0.7.0.1
 */