package com.tencent.mm.plugin.emoji.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.emoji.d.a;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.messenger.a.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.i;
import java.util.Iterator;
import java.util.List;

public class EmojiSendDialogUI
  extends MMBaseActivity
  implements com.tencent.mm.al.g
{
  private String emojiPath;
  private EmojiInfo fLP;
  private boolean oCx = false;
  
  private void Ug(String paramString)
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
  
  private void bWn()
  {
    AppMethodBeat.i(108963);
    ad.i("MicroMsg.EmojiSendDialogUI", "select contact");
    Intent localIntent = new Intent();
    localIntent.putExtra("Select_Conv_Type", 3);
    localIntent.putExtra("select_is_ret", true);
    localIntent.putExtra("mutil_select_is_ret", true);
    localIntent.putExtra("Retr_Msg_Type", 5);
    if (this.oCx) {
      localIntent.putExtra("Retr_Msg_thumb_path", this.fLP.field_md5);
    }
    for (;;)
    {
      localIntent.putExtra("emoji_activity_id", this.fLP.field_activityid);
      localIntent.putExtra("MMActivity.OverrideEnterAnimation", 2130772047);
      com.tencent.mm.bs.d.c(this, ".ui.transmit.SelectConversationUI", localIntent, 1001);
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
      ad.i("MicroMsg.EmojiSendDialogUI", "select contact result");
      localObject1 = paramIntent.getStringExtra("Select_Conv_User");
      str = paramIntent.getStringExtra("custom_send_text");
      paramIntent = k.getEmojiStorageMgr().FyY.aJx(this.fLP.JS());
      if (paramIntent != null) {
        break label269;
      }
      localObject2 = a.fSR;
      localObject2 = EmojiLogic.P(a.acD(), this.fLP.field_groupId, this.fLP.JS());
      if (!i.eK((String)localObject2)) {
        break label269;
      }
      if (t.aFm((String)localObject2))
      {
        paramInt1 = EmojiInfo.LBY;
        paramIntent = this.fLP;
        paramIntent.field_catalog = EmojiInfo.LBQ;
        paramIntent.field_type = paramInt1;
        paramIntent.field_size = ((int)i.aMN((String)localObject2));
        paramIntent.field_temp = 1;
        paramIntent = k.getEmojiStorageMgr().FyY.J(paramIntent);
      }
    }
    label261:
    label269:
    for (;;)
    {
      localObject1 = bt.S(bt.by((String)localObject1, "").split(",")).iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          if (paramIntent != null)
          {
            k.bUZ().a((String)localObject2, paramIntent, null);
            if (!bt.isNullOrNil(str))
            {
              j.cOB().hm(str, (String)localObject2);
              continue;
              paramInt1 = EmojiInfo.LBX;
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
    com.tencent.mm.kernel.g.afA().gcy.a(423, this);
    this.fLP = ((EmojiInfo)getIntent().getParcelableExtra("emoji_info"));
    paramBundle = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().TA(this.fLP.field_md5);
    if (paramBundle != null)
    {
      this.fLP = paramBundle;
      this.oCx = true;
    }
    paramBundle = a.fSR;
    this.emojiPath = EmojiLogic.P(a.acD(), this.fLP.field_groupId, this.fLP.JS());
    paramBundle = k.getEmojiStorageMgr().FyY.aJx(this.fLP.field_md5);
    if (((paramBundle != null) && (paramBundle.field_catalog == EmojiInfo.LBW)) || (bt.isNullOrNil(this.fLP.field_groupId)) || (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().TE(this.fLP.field_groupId))) {
      ad.i("MicroMsg.EmojiSendDialogUI", "no need exchange %s %s", new Object[] { this.fLP.field_md5, this.fLP.field_groupId });
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        bWn();
      }
      AppMethodBeat.o(108962);
      return;
      paramBundle = new com.tencent.mm.plugin.emoji.f.g(this.fLP.field_groupId, (byte)0);
      com.tencent.mm.kernel.g.afA().gcy.a(paramBundle, 0);
      ad.i("MicroMsg.EmojiSendDialogUI", "do exchange %s %s", new Object[] { this.fLP.field_md5, this.fLP.field_groupId });
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(108965);
    super.onDestroy();
    com.tencent.mm.kernel.g.afA().gcy.b(423, this);
    AppMethodBeat.o(108965);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(108964);
    if (paramn.getType() == 423)
    {
      paramString = (com.tencent.mm.plugin.emoji.f.g)paramn;
      ad.i("MicroMsg.EmojiSendDialogUI", "exchange end %s", new Object[] { paramString.oyw });
      if (bt.isNullOrNil(this.fLP.field_groupId))
      {
        bWn();
        AppMethodBeat.o(108964);
        return;
      }
      if (this.fLP.field_groupId.equalsIgnoreCase(paramString.oyw))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          bWn();
          AppMethodBeat.o(108964);
          return;
        }
        if (paramInt2 == 4)
        {
          Ug(getString(2131758298));
          AppMethodBeat.o(108964);
          return;
        }
        Ug(getString(2131758297));
        AppMethodBeat.o(108964);
        return;
      }
      ad.i("MicroMsg.EmojiSendDialogUI", "no the same product ID");
    }
    AppMethodBeat.o(108964);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiSendDialogUI
 * JD-Core Version:    0.7.0.1
 */