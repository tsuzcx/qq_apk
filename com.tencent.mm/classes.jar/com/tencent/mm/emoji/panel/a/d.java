package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.a.ae;
import com.tencent.mm.emoji.a.a.i;
import com.tencent.mm.emoji.a.a.i.a;
import com.tencent.mm.emoji.a.a.m;
import com.tencent.mm.emoji.a.a.q;
import com.tencent.mm.emoji.a.a.y;
import com.tencent.mm.emoji.a.o;
import com.tencent.mm.emoji.b.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.protocal.protobuf.PersonalDesigner;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.EmojiInfo.b;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelClickListener;", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "scene", "", "(I)V", "emojiCallback", "Lcom/tencent/mm/pluginsdk/ui/chat/SmileyPanelCallback;", "getEmojiCallback", "()Lcom/tencent/mm/pluginsdk/ui/chat/SmileyPanelCallback;", "setEmojiCallback", "(Lcom/tencent/mm/pluginsdk/ui/chat/SmileyPanelCallback;)V", "getScene", "()I", "setScene", "talkerName", "", "getTalkerName", "()Ljava/lang/String;", "setTalkerName", "(Ljava/lang/String;)V", "textOperationListener", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "getTextOperationListener", "()Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "setTextOperationListener", "(Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;)V", "dealCaptureEmojiClick", "", "context", "Landroid/content/Context;", "emoji", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "onClick", "position", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "onLongClick", "view", "Landroid/view/View;", "startCustomManager", "uploadEmoji", "plugin-emojisdk_release"})
public class d
  implements n
{
  public com.tencent.mm.pluginsdk.ui.chat.j fTJ;
  public String fTK;
  public ChatFooterPanel.a fTy;
  public int scene;
  
  public d(int paramInt)
  {
    this.scene = paramInt;
  }
  
  public void a(final Context paramContext, int paramInt, y paramy)
  {
    AppMethodBeat.i(105638);
    k.h(paramContext, "context");
    ac.i(f.abZ(), "onClick: " + paramInt + ", " + paramy);
    if (paramy == null)
    {
      AppMethodBeat.o(105638);
      return;
    }
    com.tencent.mm.emoji.b.f.adv().scene = this.scene;
    com.tencent.mm.emoji.b.b.ads().scene = this.scene;
    Object localObject;
    switch (paramy.type)
    {
    case 5: 
    default: 
      AppMethodBeat.o(105638);
      return;
    case 6: 
      localObject = ((com.tencent.mm.emoji.a.a.h)paramy).fPB;
      ac.i(f.abZ(), "penn send capture emoji click emoji: %s status: %d.", new Object[] { ((EmojiInfo)localObject).JC(), Integer.valueOf(((EmojiInfo)localObject).field_captureStatus) });
      paramy = ((EmojiInfo)localObject).fFY();
      if (paramy == null)
      {
        AppMethodBeat.o(105638);
        return;
      }
      switch (e.fTL[paramy.ordinal()])
      {
      default: 
        AppMethodBeat.o(105638);
        return;
      case 1: 
        paramContext = this.fTJ;
        if (paramContext != null) {
          paramContext.B((EmojiInfo)localObject);
        }
        ac.d(f.abZ(), "onSendCustomEmoji emoji md5 is [%s].", new Object[] { ((EmojiInfo)localObject).JC() });
        AppMethodBeat.o(105638);
        return;
      case 2: 
      case 3: 
        com.tencent.mm.ui.base.h.cd(paramContext, paramContext.getString(2131758224));
        AppMethodBeat.o(105638);
        return;
      case 4: 
        paramy = new f.a(paramContext);
        paramy.aRQ(paramContext.getString(2131758219)).acQ(2131758414).acR(paramContext.getResources().getColor(2131100800));
        paramy.c((f.c)new a((EmojiInfo)localObject)).show();
        AppMethodBeat.o(105638);
        return;
      }
      paramy = ((EmojiInfo)localObject).fGs();
      ac.d(f.abZ(), "CaptureUploadErrCode: %d.", new Object[] { Integer.valueOf(paramy.ordinal()) });
      if (paramy == null) {}
      for (;;)
      {
        paramy = new f.a(paramContext);
        paramy.aRQ(paramContext.getString(2131758223)).acQ(2131758221);
        paramy.c((f.c)new g(this, paramContext, (EmojiInfo)localObject)).show();
        break;
        switch (e.cfA[paramy.ordinal()])
        {
        }
      }
      paramy = new f.a(paramContext);
      paramy.aRQ(paramContext.getString(2131758223)).acQ(2131758221);
      paramy.c((f.c)new b(this, paramContext, (EmojiInfo)localObject)).show();
      AppMethodBeat.o(105638);
      return;
      paramy = com.tencent.mm.emoji.a.j.fQF;
      if (com.tencent.mm.emoji.a.j.ack())
      {
        paramy = new f.a(paramContext);
        paramy.aRQ(paramContext.getString(2131758413)).aRU(paramContext.getString(2131758337));
        paramy.c((f.c)new d.c(paramContext)).show();
        AppMethodBeat.o(105638);
        return;
      }
      paramy = new f.a(paramContext);
      paramy.aRQ(paramContext.getString(2131758223)).acQ(2131758221);
      paramy.c((f.c)new d(this, paramContext, (EmojiInfo)localObject)).show();
      AppMethodBeat.o(105638);
      return;
      paramy = new f.a(paramContext);
      paramy.aRQ(paramContext.getString(2131758223)).acQ(2131758221);
      paramy.c((f.c)new e(this, paramContext, (EmojiInfo)localObject)).show();
      AppMethodBeat.o(105638);
      return;
      if (EmojiInfo.b.HaI == ((EmojiInfo)localObject).fGs())
      {
        paramy = paramContext.getString(2131758219);
        k.g(paramy, "context.getString(R.stri…ailure_upload_local_file)");
      }
      for (;;)
      {
        f.a locala = new f.a(paramContext);
        locala.aRQ(paramy).acQ(2131758414).acR(paramContext.getResources().getColor(2131100800));
        locala.c((f.c)new f((EmojiInfo)localObject)).show();
        AppMethodBeat.o(105638);
        return;
        if (EmojiInfo.b.HaJ == ((EmojiInfo)localObject).fGs())
        {
          paramy = paramContext.getString(2131758245);
          k.g(paramy, "context.getString(R.stri…ustom_gif_max_size_limit)");
        }
        else if (EmojiInfo.b.HaK == ((EmojiInfo)localObject).fGs())
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
      paramy = paramContext.fPB;
      paramContext = paramContext.fPB;
      if (paramContext.getGroup() == EmojiGroupInfo.Jsq)
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
      com.tencent.mm.emoji.b.f.adv().b(paramInt, paramy.field_md5, paramy.field_groupId, paramy.field_designerID, paramy.field_activityid);
      paramy = this.fTJ;
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
      ((com.tencent.mm.plugin.emoji.b.d)paramy).getProvider().XX(paramContext.fSm.key);
      paramy = com.tencent.mm.cf.e.eXp().aMg(paramContext.fSm.key);
      k.g(paramy, "MergerSmileyManager.getI…mileyItem.smileyInfo.key)");
      com.tencent.mm.emoji.b.b.ads().a(d.n.n.h(paramy, ",", " ", false), paramContext.fSn, paramContext.fSo);
      paramContext = this.fTy;
      if (paramContext != null)
      {
        paramContext.append(paramy);
        AppMethodBeat.o(105638);
        return;
      }
      AppMethodBeat.o(105638);
      return;
      paramy = (m)paramy;
      if (paramy.fRQ == 0)
      {
        com.tencent.mm.plugin.report.service.h.wUl.f(11594, new Object[] { Integer.valueOf(1) });
        com.tencent.mm.br.d.b(paramContext, "emoji", ".ui.EmojiCustomUI", new Intent());
        AppMethodBeat.o(105638);
        return;
      }
      if (paramy.fRQ == 1)
      {
        paramy = g.ad(com.tencent.mm.plugin.emoji.b.d.class);
        k.g(paramy, "MMKernel.plugin(IPluginEmoji::class.java)");
        paramy = ((com.tencent.mm.plugin.emoji.b.d)paramy).getProvider();
        k.g(paramy, "MMKernel.plugin(IPluginEmoji::class.java).provider");
        if (paramy.acz())
        {
          paramy = i.fRB;
          com.tencent.mm.plugin.emojicapture.api.b.b(paramContext, i.a.ly(this.scene), this.fTK);
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
      if (!paramy.acz()) {
        break;
      }
      paramy = i.fRB;
      com.tencent.mm.plugin.emojicapture.api.b.b(paramContext, i.a.ly(this.scene), this.fTK);
      AppMethodBeat.o(105638);
      return;
      localObject = c.fVb;
      c.lA(2);
      paramy = ((q)paramy).fRS;
      if (paramy == null) {
        break;
      }
      localObject = new Intent();
      ((Intent)localObject).putExtra("uin", paramy.DesignerUin);
      ((Intent)localObject).putExtra("name", paramy.Name);
      ((Intent)localObject).putExtra("headurl", paramy.HeadUrl);
      ((Intent)localObject).putExtra("extra_scence", 9);
      com.tencent.mm.br.d.b(paramContext, "emoji", ".ui.v2.EmojiStoreV2DesignerUI", (Intent)localObject);
      break;
    }
  }
  
  public final void a(View paramView, Context paramContext, int paramInt)
  {
    AppMethodBeat.i(209862);
    k.h(paramContext, "context");
    AppMethodBeat.o(209862);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
  static final class a
    implements f.c
  {
    a(EmojiInfo paramEmojiInfo) {}
    
    public final void d(boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(105632);
      if ((paramBoolean) && (!bs.isNullOrNil(this.fTM.JC())))
      {
        paramString = g.ad(com.tencent.mm.plugin.emoji.b.d.class);
        k.g(paramString, "MMKernel.plugin(IPluginEmoji::class.java)");
        ((com.tencent.mm.plugin.emoji.b.d)paramString).getEmojiMgr().XZ(this.fTM.JC());
      }
      AppMethodBeat.o(105632);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
  static final class b
    implements f.c
  {
    b(d paramd, Context paramContext, EmojiInfo paramEmojiInfo) {}
    
    public final void d(boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(105633);
      if (paramBoolean) {
        d.m(this.fTM);
      }
      AppMethodBeat.o(105633);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
  static final class d
    implements f.c
  {
    d(d paramd, Context paramContext, EmojiInfo paramEmojiInfo) {}
    
    public final void d(boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(105635);
      if (paramBoolean) {
        d.m(this.fTM);
      }
      AppMethodBeat.o(105635);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
  static final class e
    implements f.c
  {
    e(d paramd, Context paramContext, EmojiInfo paramEmojiInfo) {}
    
    public final void d(boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(105636);
      if (paramBoolean) {
        d.m(this.fTM);
      }
      AppMethodBeat.o(105636);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
  static final class f
    implements f.c
  {
    f(EmojiInfo paramEmojiInfo) {}
    
    public final void d(boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(105637);
      if ((paramBoolean) && (!bs.isNullOrNil(this.fTM.JC())))
      {
        paramString = g.ad(com.tencent.mm.plugin.emoji.b.d.class);
        k.g(paramString, "MMKernel.plugin(IPluginEmoji::class.java)");
        ((com.tencent.mm.plugin.emoji.b.d)paramString).getEmojiMgr().XZ(this.fTM.JC());
      }
      AppMethodBeat.o(105637);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
  static final class g
    implements f.c
  {
    g(d paramd, Context paramContext, EmojiInfo paramEmojiInfo) {}
    
    public final void d(boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(161814);
      if (paramBoolean) {
        d.m(this.fTM);
      }
      AppMethodBeat.o(161814);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.d
 * JD-Core Version:    0.7.0.1
 */