package com.tencent.mm.plugin.emoji.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.plugin.emoji.i.a;
import com.tencent.mm.plugin.emoji.i.h;
import com.tencent.mm.plugin.emoji.i.b;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.p;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.pluginsdk.b.e;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.vfs.u;
import java.util.Iterator;
import java.util.List;

public class EmojiSendDialogUI
  extends MMBaseActivity
  implements i
{
  private String emojiPath;
  private EmojiInfo jHh;
  private boolean uKm = false;
  
  private void auQ(String paramString)
  {
    AppMethodBeat.i(108968);
    if (!isFinishing()) {
      com.tencent.mm.ui.base.h.c(this, paramString, "", true).setOnDismissListener(new DialogInterface.OnDismissListener()
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
  
  private void cWb()
  {
    AppMethodBeat.i(108963);
    Log.i("MicroMsg.EmojiSendDialogUI", "select contact");
    Intent localIntent = new Intent();
    localIntent.putExtra("Select_Conv_Type", 3);
    localIntent.putExtra("select_is_ret", true);
    localIntent.putExtra("mutil_select_is_ret", true);
    localIntent.putExtra("Retr_Msg_Type", 5);
    if (this.uKm) {
      localIntent.putExtra("Retr_Msg_thumb_path", this.jHh.field_md5);
    }
    for (;;)
    {
      localIntent.putExtra("emoji_activity_id", this.jHh.field_activityid);
      localIntent.putExtra("MMActivity.OverrideEnterAnimation", i.a.fast_faded_in);
      com.tencent.mm.by.c.d(this, ".ui.transmit.SelectConversationUI", localIntent, 1001);
      overridePendingTransition(i.a.push_up_in, i.a.pop_out);
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
    Object localObject;
    String str1;
    String str2;
    if (paramInt1 == 1001)
    {
      if (paramInt2 != -1) {
        break label256;
      }
      Log.i("MicroMsg.EmojiSendDialogUI", "select contact result");
      localObject = paramIntent.getStringExtra("Select_Conv_User");
      str1 = paramIntent.getStringExtra("custom_send_text");
      paramIntent = p.getEmojiStorageMgr().VFH.bxK(this.jHh.getMd5());
      if (paramIntent != null) {
        break label264;
      }
      str2 = EmojiLogic.T(b.bcb(), this.jHh.field_groupId, this.jHh.getMd5());
      if (!u.agG(str2)) {
        break label264;
      }
      if (ImgUtil.isGif(str2))
      {
        paramInt1 = EmojiInfo.YCF;
        paramIntent = this.jHh;
        paramIntent.field_catalog = EmojiInfo.YCx;
        paramIntent.field_type = paramInt1;
        paramIntent.field_size = ((int)u.bBQ(str2));
        paramIntent.field_temp = 1;
        paramIntent = p.getEmojiStorageMgr().VFH.K(paramIntent);
      }
    }
    label256:
    label264:
    for (;;)
    {
      localObject = Util.stringsToList(Util.nullAs((String)localObject, "").split(",")).iterator();
      for (;;)
      {
        if (((Iterator)localObject).hasNext())
        {
          str2 = (String)((Iterator)localObject).next();
          if (paramIntent != null)
          {
            p.cUO().a(str2, paramIntent, null);
            if (!Util.isNullOrNil(str1))
            {
              g.eRW().iQ(str1, str2);
              continue;
              paramInt1 = EmojiInfo.YCE;
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
    com.tencent.mm.kernel.h.aHF().kcd.a(423, this);
    this.jHh = ((EmojiInfo)getIntent().getParcelableExtra("emoji_info"));
    paramBundle = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().aue(this.jHh.field_md5);
    if (paramBundle != null)
    {
      this.jHh = paramBundle;
      this.uKm = true;
    }
    this.emojiPath = EmojiLogic.T(b.bcb(), this.jHh.field_groupId, this.jHh.getMd5());
    paramBundle = p.getEmojiStorageMgr().VFH.bxK(this.jHh.field_md5);
    if (((paramBundle != null) && (paramBundle.field_catalog == EmojiInfo.YCD)) || (Util.isNullOrNil(this.jHh.field_groupId)) || (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aui(this.jHh.field_groupId))) {
      Log.i("MicroMsg.EmojiSendDialogUI", "no need exchange %s %s", new Object[] { this.jHh.field_md5, this.jHh.field_groupId });
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        cWb();
      }
      AppMethodBeat.o(108962);
      return;
      paramBundle = new com.tencent.mm.plugin.emoji.f.h(this.jHh.field_groupId, (byte)0);
      com.tencent.mm.kernel.h.aHF().kcd.a(paramBundle, 0);
      Log.i("MicroMsg.EmojiSendDialogUI", "do exchange %s %s", new Object[] { this.jHh.field_md5, this.jHh.field_groupId });
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(108965);
    super.onDestroy();
    com.tencent.mm.kernel.h.aHF().kcd.b(423, this);
    AppMethodBeat.o(108965);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(108964);
    if (paramq.getType() == 423)
    {
      paramString = (com.tencent.mm.plugin.emoji.f.h)paramq;
      Log.i("MicroMsg.EmojiSendDialogUI", "exchange end %s", new Object[] { paramString.uFI });
      if (Util.isNullOrNil(this.jHh.field_groupId))
      {
        cWb();
        AppMethodBeat.o(108964);
        return;
      }
      if (this.jHh.field_groupId.equalsIgnoreCase(paramString.uFI))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          cWb();
          AppMethodBeat.o(108964);
          return;
        }
        if (paramInt2 == 4)
        {
          auQ(getString(i.h.emoji_send_need_exchange));
          AppMethodBeat.o(108964);
          return;
        }
        auQ(getString(i.h.emoji_send_exchange_fail));
        AppMethodBeat.o(108964);
        return;
      }
      Log.i("MicroMsg.EmojiSendDialogUI", "no the same product ID");
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