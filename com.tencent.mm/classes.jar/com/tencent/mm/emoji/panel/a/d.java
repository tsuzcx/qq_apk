package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.a.ac;
import com.tencent.mm.emoji.a.a.ai;
import com.tencent.mm.emoji.a.a.i;
import com.tencent.mm.emoji.a.a.i.a;
import com.tencent.mm.emoji.a.a.m;
import com.tencent.mm.emoji.a.a.u;
import com.tencent.mm.emoji.a.o;
import com.tencent.mm.emoji.b.c;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.protocal.protobuf.PersonalDesigner;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.EmojiInfo.b;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelClickListener;", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "scene", "", "(I)V", "emojiCallback", "Lcom/tencent/mm/pluginsdk/ui/chat/SmileyPanelCallback;", "getEmojiCallback", "()Lcom/tencent/mm/pluginsdk/ui/chat/SmileyPanelCallback;", "setEmojiCallback", "(Lcom/tencent/mm/pluginsdk/ui/chat/SmileyPanelCallback;)V", "getScene", "()I", "setScene", "talkerName", "", "getTalkerName", "()Ljava/lang/String;", "setTalkerName", "(Ljava/lang/String;)V", "textOperationListener", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "getTextOperationListener", "()Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "setTextOperationListener", "(Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;)V", "dealCaptureEmojiClick", "", "context", "Landroid/content/Context;", "emoji", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "onClick", "position", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "onLongClick", "view", "Landroid/view/View;", "startCustomManager", "uploadEmoji", "plugin-emojisdk_release"})
public class d
  implements n
{
  public ChatFooterPanel.a gnc;
  public com.tencent.mm.pluginsdk.ui.chat.j gnn;
  public String gno;
  public int scene;
  
  public d(int paramInt)
  {
    this.scene = paramInt;
  }
  
  public void a(final Context paramContext, int paramInt, ac paramac)
  {
    AppMethodBeat.i(105638);
    p.h(paramContext, "context");
    ad.i(f.aeD(), "onClick: " + paramInt + ", " + paramac);
    if (paramac == null)
    {
      AppMethodBeat.o(105638);
      return;
    }
    com.tencent.mm.emoji.b.f.agb().scene = this.scene;
    com.tencent.mm.emoji.b.b.afY().scene = this.scene;
    Object localObject;
    switch (paramac.type)
    {
    case 5: 
    default: 
      AppMethodBeat.o(105638);
      return;
    case 6: 
      localObject = ((com.tencent.mm.emoji.a.a.h)paramac).gjb;
      ad.i(f.aeD(), "penn send capture emoji click emoji: %s status: %d.", new Object[] { ((EmojiInfo)localObject).Lb(), Integer.valueOf(((EmojiInfo)localObject).field_captureStatus) });
      paramac = ((EmojiInfo)localObject).gzL();
      if (paramac == null)
      {
        AppMethodBeat.o(105638);
        return;
      }
      switch (e.gnp[paramac.ordinal()])
      {
      default: 
        AppMethodBeat.o(105638);
        return;
      case 1: 
        paramContext = this.gnn;
        if (paramContext != null) {
          paramContext.B((EmojiInfo)localObject);
        }
        ad.d(f.aeD(), "onSendCustomEmoji emoji md5 is [%s].", new Object[] { ((EmojiInfo)localObject).Lb() });
        AppMethodBeat.o(105638);
        return;
      case 2: 
      case 3: 
        com.tencent.mm.ui.base.h.ci(paramContext, paramContext.getString(2131758224));
        AppMethodBeat.o(105638);
        return;
      case 4: 
        paramac = new f.a(paramContext);
        paramac.aXO(paramContext.getString(2131758219)).afp(2131758414).afq(paramContext.getResources().getColor(2131100800));
        paramac.c((f.c)new a((EmojiInfo)localObject)).show();
        AppMethodBeat.o(105638);
        return;
      }
      paramac = ((EmojiInfo)localObject).gzO();
      ad.d(f.aeD(), "CaptureUploadErrCode: %d.", new Object[] { Integer.valueOf(paramac.ordinal()) });
      if (paramac == null) {}
      for (;;)
      {
        paramac = new f.a(paramContext);
        paramac.aXO(paramContext.getString(2131758223)).afp(2131758221);
        paramac.c((f.c)new g(this, paramContext, (EmojiInfo)localObject)).show();
        break;
        switch (e.cpQ[paramac.ordinal()])
        {
        }
      }
      paramac = new f.a(paramContext);
      paramac.aXO(paramContext.getString(2131758223)).afp(2131758221);
      paramac.c((f.c)new b(this, paramContext, (EmojiInfo)localObject)).show();
      AppMethodBeat.o(105638);
      return;
      paramac = com.tencent.mm.emoji.a.j.gkf;
      if (com.tencent.mm.emoji.a.j.aeO())
      {
        paramac = new f.a(paramContext);
        paramac.aXO(paramContext.getString(2131758413)).aXS(paramContext.getString(2131758337));
        paramac.c((f.c)new d.c(paramContext)).show();
        AppMethodBeat.o(105638);
        return;
      }
      paramac = new f.a(paramContext);
      paramac.aXO(paramContext.getString(2131758223)).afp(2131758221);
      paramac.c((f.c)new d(this, paramContext, (EmojiInfo)localObject)).show();
      AppMethodBeat.o(105638);
      return;
      paramac = new f.a(paramContext);
      paramac.aXO(paramContext.getString(2131758223)).afp(2131758221);
      paramac.c((f.c)new e(this, paramContext, (EmojiInfo)localObject)).show();
      AppMethodBeat.o(105638);
      return;
      if (EmojiInfo.b.INY == ((EmojiInfo)localObject).gzO())
      {
        paramac = paramContext.getString(2131758219);
        p.g(paramac, "context.getString(R.stri…ailure_upload_local_file)");
      }
      for (;;)
      {
        f.a locala = new f.a(paramContext);
        locala.aXO(paramac).afp(2131758414).afq(paramContext.getResources().getColor(2131100800));
        locala.c((f.c)new f((EmojiInfo)localObject)).show();
        AppMethodBeat.o(105638);
        return;
        if (EmojiInfo.b.INZ == ((EmojiInfo)localObject).gzO())
        {
          paramac = paramContext.getString(2131758245);
          p.g(paramac, "context.getString(R.stri…ustom_gif_max_size_limit)");
        }
        else if (EmojiInfo.b.IOa == ((EmojiInfo)localObject).gzO())
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
      paramContext = (com.tencent.mm.emoji.a.a.h)paramac;
      paramac = paramContext.gjb;
      paramContext = paramContext.gjb;
      if (paramContext.getGroup() == EmojiGroupInfo.OeL)
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
      com.tencent.mm.emoji.b.f.agb().b(paramInt, paramac.field_md5, paramac.field_groupId, paramac.field_designerID, paramac.field_activityid);
      paramac = this.gnn;
      if (paramac != null)
      {
        paramac.B(paramContext);
        AppMethodBeat.o(105638);
        return;
      }
      AppMethodBeat.o(105638);
      return;
      paramContext = (ai)paramac;
      paramac = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class);
      p.g(paramac, "MMKernel.plugin(IPluginEmoji::class.java)");
      ((com.tencent.mm.plugin.emoji.b.d)paramac).getProvider().abD(paramContext.glQ.key);
      paramac = com.tencent.mm.cf.e.fmZ().aRN(paramContext.glQ.key);
      p.g(paramac, "MergerSmileyManager.getI…mileyItem.smileyInfo.key)");
      com.tencent.mm.emoji.b.b.afY().a(d.n.n.h(paramac, ",", " ", false), paramContext.glR, paramContext.glS);
      paramContext = this.gnc;
      if (paramContext != null)
      {
        paramContext.append(paramac);
        AppMethodBeat.o(105638);
        return;
      }
      AppMethodBeat.o(105638);
      return;
      paramac = (m)paramac;
      if (paramac.glr == 0)
      {
        com.tencent.mm.plugin.report.service.g.yhR.f(11594, new Object[] { Integer.valueOf(1) });
        com.tencent.mm.bs.d.b(paramContext, "emoji", ".ui.EmojiCustomUI", new Intent());
        AppMethodBeat.o(105638);
        return;
      }
      if (paramac.glr == 1)
      {
        paramac = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class);
        p.g(paramac, "MMKernel.plugin(IPluginEmoji::class.java)");
        paramac = ((com.tencent.mm.plugin.emoji.b.d)paramac).getProvider();
        p.g(paramac, "MMKernel.plugin(IPluginEmoji::class.java).provider");
        if (paramac.afd())
        {
          paramac = i.glb;
          com.tencent.mm.plugin.emojicapture.api.b.b(paramContext, i.a.lX(this.scene), this.gno);
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
      if (!paramac.afd()) {
        break;
      }
      paramac = i.glb;
      com.tencent.mm.plugin.emojicapture.api.b.b(paramContext, i.a.lX(this.scene), this.gno);
      AppMethodBeat.o(105638);
      return;
      localObject = c.goE;
      c.ma(2);
      paramac = ((u)paramac).glw;
      if (paramac == null) {
        break;
      }
      localObject = new Intent();
      ((Intent)localObject).putExtra("uin", paramac.DesignerUin);
      ((Intent)localObject).putExtra("name", paramac.Name);
      ((Intent)localObject).putExtra("headurl", paramac.HeadUrl);
      ((Intent)localObject).putExtra("extra_scence", 9);
      com.tencent.mm.bs.d.b(paramContext, "emoji", ".ui.v2.EmojiStoreV2DesignerUI", (Intent)localObject);
      break;
    }
  }
  
  public final void a(View paramView, Context paramContext, int paramInt)
  {
    AppMethodBeat.i(218987);
    p.h(paramContext, "context");
    AppMethodBeat.o(218987);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
  static final class a
    implements f.c
  {
    a(EmojiInfo paramEmojiInfo) {}
    
    public final void d(boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(105632);
      if ((paramBoolean) && (!bt.isNullOrNil(this.gnq.Lb())))
      {
        paramString = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class);
        p.g(paramString, "MMKernel.plugin(IPluginEmoji::class.java)");
        ((com.tencent.mm.plugin.emoji.b.d)paramString).getEmojiMgr().abF(this.gnq.Lb());
      }
      AppMethodBeat.o(105632);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
  static final class b
    implements f.c
  {
    b(d paramd, Context paramContext, EmojiInfo paramEmojiInfo) {}
    
    public final void d(boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(105633);
      if (paramBoolean) {
        d.m(this.gnq);
      }
      AppMethodBeat.o(105633);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
  static final class d
    implements f.c
  {
    d(d paramd, Context paramContext, EmojiInfo paramEmojiInfo) {}
    
    public final void d(boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(105635);
      if (paramBoolean) {
        d.m(this.gnq);
      }
      AppMethodBeat.o(105635);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
  static final class e
    implements f.c
  {
    e(d paramd, Context paramContext, EmojiInfo paramEmojiInfo) {}
    
    public final void d(boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(105636);
      if (paramBoolean) {
        d.m(this.gnq);
      }
      AppMethodBeat.o(105636);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
  static final class f
    implements f.c
  {
    f(EmojiInfo paramEmojiInfo) {}
    
    public final void d(boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(105637);
      if ((paramBoolean) && (!bt.isNullOrNil(this.gnq.Lb())))
      {
        paramString = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class);
        p.g(paramString, "MMKernel.plugin(IPluginEmoji::class.java)");
        ((com.tencent.mm.plugin.emoji.b.d)paramString).getEmojiMgr().abF(this.gnq.Lb());
      }
      AppMethodBeat.o(105637);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
  static final class g
    implements f.c
  {
    g(d paramd, Context paramContext, EmojiInfo paramEmojiInfo) {}
    
    public final void d(boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(161814);
      if (paramBoolean) {
        d.m(this.gnq);
      }
      AppMethodBeat.o(161814);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.d
 * JD-Core Version:    0.7.0.1
 */