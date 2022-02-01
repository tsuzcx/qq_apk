package com.tencent.mm.plugin.emoji.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.emoji.d.a;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.messenger.a.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.i;
import java.util.Iterator;
import java.util.List;

public class EmojiSendDialogUI
  extends MMBaseActivity
  implements com.tencent.mm.ak.g
{
  private String emojiPath;
  private EmojiInfo fPB;
  private boolean pfX = false;
  
  private void Ys(String paramString)
  {
    AppMethodBeat.i(108968);
    if (!isFinishing()) {
      h.c(this, paramString, "", true).setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(108961);
          EmojiSendDialogUI.this.setResult(0);
          EmojiSendDialogUI.this.finish();
          AppMethodBeat.o(108961);
        }
      });
    }
    AppMethodBeat.o(108968);
  }
  
  private void cdA()
  {
    AppMethodBeat.i(108963);
    ac.i("MicroMsg.EmojiSendDialogUI", "select contact");
    Intent localIntent = new Intent();
    localIntent.putExtra("Select_Conv_Type", 3);
    localIntent.putExtra("select_is_ret", true);
    localIntent.putExtra("mutil_select_is_ret", true);
    localIntent.putExtra("Retr_Msg_Type", 5);
    if (this.pfX) {
      localIntent.putExtra("Retr_Msg_thumb_path", this.fPB.field_md5);
    }
    for (;;)
    {
      localIntent.putExtra("emoji_activity_id", this.fPB.field_activityid);
      localIntent.putExtra("MMActivity.OverrideEnterAnimation", 2130772047);
      com.tencent.mm.br.d.c(this, ".ui.transmit.SelectConversationUI", localIntent, 1001);
      overridePendingTransition(2130772108, 2130772100);
      AppMethodBeat.o(108963);
      return;
      localIntent.putExtra("image_path", this.emojiPath);
    }
  }
  
  public void finish()
  {
    AppMethodBeat.i(108967);
    overridePendingTransition(-1, -1);
    super.finish();
    AppMethodBeat.o(108967);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(108966);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject1;
    String str;
    Object localObject2;
    if (paramInt1 == 1001)
    {
      if (paramInt2 != -1) {
        break label261;
      }
      ac.i("MicroMsg.EmojiSendDialogUI", "select contact result");
      localObject1 = paramIntent.getStringExtra("Select_Conv_User");
      str = paramIntent.getStringExtra("custom_send_text");
      paramIntent = k.getEmojiStorageMgr().GXZ.aOT(this.fPB.JC());
      if (paramIntent != null) {
        break label269;
      }
      localObject2 = a.fWM;
      localObject2 = EmojiLogic.P(a.adJ(), this.fPB.field_groupId, this.fPB.JC());
      if (!i.eA((String)localObject2)) {
        break label269;
      }
      if (s.aKD((String)localObject2))
      {
        paramInt1 = EmojiInfo.KfZ;
        paramIntent = this.fPB;
        paramIntent.field_catalog = EmojiInfo.Jss;
        paramIntent.field_type = paramInt1;
        paramIntent.field_size = ((int)i.aSp((String)localObject2));
        paramIntent.field_temp = 1;
        paramIntent = k.getEmojiStorageMgr().GXZ.J(paramIntent);
      }
    }
    label261:
    label269:
    for (;;)
    {
      localObject1 = bs.S(bs.bG((String)localObject1, "").split(",")).iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          if (paramIntent != null)
          {
            k.ccm().a((String)localObject2, paramIntent, null);
            if (!bs.isNullOrNil(str))
            {
              j.dck().hF(str, (String)localObject2);
              continue;
              paramInt1 = EmojiInfo.KfY;
              break;
            }
          }
        }
      }
      setResult(-1);
      for (;;)
      {
        finish();
        AppMethodBeat.o(108966);
        return;
        setResult(0);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(108962);
    overridePendingTransition(-1, -1);
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setStatusBarColor(0);
    }
    com.tencent.mm.kernel.g.agQ().ghe.a(423, this);
    this.fPB = ((EmojiInfo)getIntent().getParcelableExtra("emoji_info"));
    paramBundle = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().XM(this.fPB.field_md5);
    if (paramBundle != null)
    {
      this.fPB = paramBundle;
      this.pfX = true;
    }
    paramBundle = a.fWM;
    this.emojiPath = EmojiLogic.P(a.adJ(), this.fPB.field_groupId, this.fPB.JC());
    paramBundle = k.getEmojiStorageMgr().GXZ.aOT(this.fPB.field_md5);
    if (((paramBundle != null) && (paramBundle.field_catalog == EmojiInfo.Jsy)) || (bs.isNullOrNil(this.fPB.field_groupId)) || (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().XQ(this.fPB.field_groupId))) {
      ac.i("MicroMsg.EmojiSendDialogUI", "no need exchange %s %s", new Object[] { this.fPB.field_md5, this.fPB.field_groupId });
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        cdA();
      }
      AppMethodBeat.o(108962);
      return;
      paramBundle = new com.tencent.mm.plugin.emoji.f.g(this.fPB.field_groupId, (byte)0);
      com.tencent.mm.kernel.g.agQ().ghe.a(paramBundle, 0);
      ac.i("MicroMsg.EmojiSendDialogUI", "do exchange %s %s", new Object[] { this.fPB.field_md5, this.fPB.field_groupId });
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(108965);
    super.onDestroy();
    com.tencent.mm.kernel.g.agQ().ghe.b(423, this);
    AppMethodBeat.o(108965);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(108964);
    if (paramn.getType() == 423)
    {
      paramString = (com.tencent.mm.plugin.emoji.f.g)paramn;
      ac.i("MicroMsg.EmojiSendDialogUI", "exchange end %s", new Object[] { paramString.pbW });
      if (bs.isNullOrNil(this.fPB.field_groupId))
      {
        cdA();
        AppMethodBeat.o(108964);
        return;
      }
      if (this.fPB.field_groupId.equalsIgnoreCase(paramString.pbW))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          cdA();
          AppMethodBeat.o(108964);
          return;
        }
        if (paramInt2 == 4)
        {
          Ys(getString(2131758298));
          AppMethodBeat.o(108964);
          return;
        }
        Ys(getString(2131758297));
        AppMethodBeat.o(108964);
        return;
      }
      ac.i("MicroMsg.EmojiSendDialogUI", "no the same product ID");
    }
    AppMethodBeat.o(108964);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiSendDialogUI
 * JD-Core Version:    0.7.0.1
 */