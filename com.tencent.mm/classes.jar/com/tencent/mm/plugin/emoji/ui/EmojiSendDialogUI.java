package com.tencent.mm.plugin.emoji.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.widget.b.c;
import java.util.Iterator;
import java.util.List;

public class EmojiSendDialogUI
  extends MMBaseActivity
  implements f
{
  private String emojiPath;
  private EmojiInfo evH;
  private boolean lmi = false;
  
  private void La(String paramString)
  {
    AppMethodBeat.i(53407);
    if (!isFinishing()) {
      com.tencent.mm.ui.base.h.b(this, paramString, "", true).setOnDismissListener(new EmojiSendDialogUI.1(this));
    }
    AppMethodBeat.o(53407);
  }
  
  private void bmD()
  {
    AppMethodBeat.i(53402);
    ab.i("MicroMsg.EmojiSendDialogUI", "select contact");
    Intent localIntent = new Intent();
    localIntent.putExtra("Select_Conv_Type", 3);
    localIntent.putExtra("select_is_ret", true);
    localIntent.putExtra("mutil_select_is_ret", true);
    localIntent.putExtra("Retr_Msg_Type", 5);
    if (this.lmi) {
      localIntent.putExtra("Retr_Msg_thumb_path", this.evH.field_md5);
    }
    for (;;)
    {
      localIntent.putExtra("emoji_activity_id", this.evH.field_activityid);
      localIntent.putExtra("MMActivity.OverrideEnterAnimation", 2131034181);
      com.tencent.mm.bq.d.b(this, ".ui.transmit.SelectConversationUI", localIntent, 1001);
      overridePendingTransition(2131034230, 2131034222);
      AppMethodBeat.o(53402);
      return;
      localIntent.putExtra("image_path", this.emojiPath);
    }
  }
  
  public void finish()
  {
    AppMethodBeat.i(53406);
    overridePendingTransition(-1, -1);
    super.finish();
    AppMethodBeat.o(53406);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(53405);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject;
    String str1;
    String str2;
    if (paramInt1 == 1001)
    {
      if (paramInt2 != -1) {
        break label256;
      }
      ab.i("MicroMsg.EmojiSendDialogUI", "select contact result");
      localObject = paramIntent.getStringExtra("Select_Conv_User");
      str1 = paramIntent.getStringExtra("custom_send_text");
      paramIntent = i.getEmojiStorageMgr().yNn.asP(this.evH.Al());
      if (paramIntent != null) {
        break label264;
      }
      str2 = EmojiLogic.M(com.tencent.mm.plugin.emoji.h.b.YP(), this.evH.field_groupId, this.evH.Al());
      if (!com.tencent.mm.vfs.e.cN(str2)) {
        break label264;
      }
      if (r.aoY(str2))
      {
        paramInt1 = EmojiInfo.yPo;
        paramIntent = this.evH;
        paramIntent.field_catalog = EmojiInfo.yPg;
        paramIntent.field_type = paramInt1;
        paramIntent.field_size = ((int)com.tencent.mm.vfs.e.avI(str2));
        paramIntent.field_temp = 1;
        paramIntent = i.getEmojiStorageMgr().yNn.H(paramIntent);
      }
    }
    label256:
    label264:
    for (;;)
    {
      localObject = bo.P(bo.bf((String)localObject, "").split(",")).iterator();
      for (;;)
      {
        if (((Iterator)localObject).hasNext())
        {
          str2 = (String)((Iterator)localObject).next();
          if (paramIntent != null)
          {
            i.blp().a(str2, paramIntent, null);
            if (!bo.isNullOrNil(str1))
            {
              com.tencent.mm.plugin.messenger.a.g.bPJ().fh(str1, str2);
              continue;
              paramInt1 = EmojiInfo.yPn;
              break;
            }
          }
        }
      }
      setResult(-1);
      for (;;)
      {
        finish();
        AppMethodBeat.o(53405);
        return;
        setResult(0);
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(53401);
    overridePendingTransition(-1, -1);
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setStatusBarColor(0);
    }
    com.tencent.mm.kernel.g.RK().eHt.a(423, this);
    this.evH = ((EmojiInfo)getIntent().getParcelableExtra("emoji_info"));
    paramBundle = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().Ku(this.evH.field_md5);
    if (paramBundle != null)
    {
      this.evH = paramBundle;
      this.lmi = true;
    }
    this.emojiPath = EmojiLogic.M(com.tencent.mm.plugin.emoji.h.b.YP(), this.evH.field_groupId, this.evH.Al());
    paramBundle = i.getEmojiStorageMgr().yNn.asP(this.evH.field_md5);
    if (((paramBundle != null) && (paramBundle.field_catalog == EmojiInfo.yPm)) || (bo.isNullOrNil(this.evH.field_groupId)) || (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Ky(this.evH.field_groupId))) {
      ab.i("MicroMsg.EmojiSendDialogUI", "no need exchange %s %s", new Object[] { this.evH.field_md5, this.evH.field_groupId });
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        bmD();
      }
      AppMethodBeat.o(53401);
      return;
      paramBundle = new com.tencent.mm.plugin.emoji.f.g(this.evH.field_groupId, (byte)0);
      com.tencent.mm.kernel.g.RK().eHt.a(paramBundle, 0);
      ab.i("MicroMsg.EmojiSendDialogUI", "do exchange %s %s", new Object[] { this.evH.field_md5, this.evH.field_groupId });
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(53404);
    super.onDestroy();
    com.tencent.mm.kernel.g.RK().eHt.b(423, this);
    AppMethodBeat.o(53404);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(53403);
    if (paramm.getType() == 423)
    {
      paramString = (com.tencent.mm.plugin.emoji.f.g)paramm;
      ab.i("MicroMsg.EmojiSendDialogUI", "exchange end %s", new Object[] { paramString.liu });
      if (bo.isNullOrNil(this.evH.field_groupId))
      {
        bmD();
        AppMethodBeat.o(53403);
        return;
      }
      if (this.evH.field_groupId.equalsIgnoreCase(paramString.liu))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          bmD();
          AppMethodBeat.o(53403);
          return;
        }
        if (paramInt2 == 4)
        {
          La(getString(2131299172));
          AppMethodBeat.o(53403);
          return;
        }
        La(getString(2131299171));
        AppMethodBeat.o(53403);
        return;
      }
      ab.i("MicroMsg.EmojiSendDialogUI", "no the same product ID");
    }
    AppMethodBeat.o(53403);
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