package com.tencent.mm.plugin.emoji.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.br.c;
import com.tencent.mm.emoji.e.a;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.pluginsdk.a.e;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.vfs.s;
import java.util.Iterator;
import java.util.List;

public class EmojiSendDialogUI
  extends MMBaseActivity
  implements i
{
  private String emojiPath;
  private EmojiInfo gWm;
  private boolean rhd = false;
  
  private void amW(String paramString)
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
  
  private void cHu()
  {
    AppMethodBeat.i(108963);
    Log.i("MicroMsg.EmojiSendDialogUI", "select contact");
    Intent localIntent = new Intent();
    localIntent.putExtra("Select_Conv_Type", 3);
    localIntent.putExtra("select_is_ret", true);
    localIntent.putExtra("mutil_select_is_ret", true);
    localIntent.putExtra("Retr_Msg_Type", 5);
    if (this.rhd) {
      localIntent.putExtra("Retr_Msg_thumb_path", this.gWm.field_md5);
    }
    for (;;)
    {
      localIntent.putExtra("emoji_activity_id", this.gWm.field_activityid);
      localIntent.putExtra("MMActivity.OverrideEnterAnimation", 2130772059);
      c.c(this, ".ui.transmit.SelectConversationUI", localIntent, 1001);
      overridePendingTransition(2130772132, 2130772124);
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
      Log.i("MicroMsg.EmojiSendDialogUI", "select contact result");
      localObject1 = paramIntent.getStringExtra("Select_Conv_User");
      str = paramIntent.getStringExtra("custom_send_text");
      paramIntent = k.getEmojiStorageMgr().OpN.blk(this.gWm.getMd5());
      if (paramIntent != null) {
        break label269;
      }
      localObject2 = a.hdT;
      localObject2 = EmojiLogic.W(a.awt(), this.gWm.field_groupId, this.gWm.getMd5());
      if (!s.YS((String)localObject2)) {
        break label269;
      }
      if (ImgUtil.isGif((String)localObject2))
      {
        paramInt1 = EmojiInfo.Uux;
        paramIntent = this.gWm;
        paramIntent.field_catalog = EmojiInfo.Uup;
        paramIntent.field_type = paramInt1;
        paramIntent.field_size = ((int)s.boW((String)localObject2));
        paramIntent.field_temp = 1;
        paramIntent = k.getEmojiStorageMgr().OpN.J(paramIntent);
      }
    }
    label261:
    label269:
    for (;;)
    {
      localObject1 = Util.stringsToList(Util.nullAs((String)localObject1, "").split(",")).iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          if (paramIntent != null)
          {
            k.cGf().a((String)localObject2, paramIntent, null);
            if (!Util.isNullOrNil(str))
            {
              com.tencent.mm.plugin.messenger.a.g.eir().iF(str, (String)localObject2);
              continue;
              paramInt1 = EmojiInfo.Uuw;
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
    com.tencent.mm.kernel.g.aAg().hqi.a(423, this);
    this.gWm = ((EmojiInfo)getIntent().getParcelableExtra("emoji_info"));
    paramBundle = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().amm(this.gWm.field_md5);
    if (paramBundle != null)
    {
      this.gWm = paramBundle;
      this.rhd = true;
    }
    paramBundle = a.hdT;
    this.emojiPath = EmojiLogic.W(a.awt(), this.gWm.field_groupId, this.gWm.getMd5());
    paramBundle = k.getEmojiStorageMgr().OpN.blk(this.gWm.field_md5);
    if (((paramBundle != null) && (paramBundle.field_catalog == EmojiInfo.Uuv)) || (Util.isNullOrNil(this.gWm.field_groupId)) || (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().amq(this.gWm.field_groupId))) {
      Log.i("MicroMsg.EmojiSendDialogUI", "no need exchange %s %s", new Object[] { this.gWm.field_md5, this.gWm.field_groupId });
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        cHu();
      }
      AppMethodBeat.o(108962);
      return;
      paramBundle = new com.tencent.mm.plugin.emoji.f.h(this.gWm.field_groupId, (byte)0);
      com.tencent.mm.kernel.g.aAg().hqi.a(paramBundle, 0);
      Log.i("MicroMsg.EmojiSendDialogUI", "do exchange %s %s", new Object[] { this.gWm.field_md5, this.gWm.field_groupId });
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(108965);
    super.onDestroy();
    com.tencent.mm.kernel.g.aAg().hqi.b(423, this);
    AppMethodBeat.o(108965);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(108964);
    if (paramq.getType() == 423)
    {
      paramString = (com.tencent.mm.plugin.emoji.f.h)paramq;
      Log.i("MicroMsg.EmojiSendDialogUI", "exchange end %s", new Object[] { paramString.rcD });
      if (Util.isNullOrNil(this.gWm.field_groupId))
      {
        cHu();
        AppMethodBeat.o(108964);
        return;
      }
      if (this.gWm.field_groupId.equalsIgnoreCase(paramString.rcD))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          cHu();
          AppMethodBeat.o(108964);
          return;
        }
        if (paramInt2 == 4)
        {
          amW(getString(2131758591));
          AppMethodBeat.o(108964);
          return;
        }
        amW(getString(2131758589));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiSendDialogUI
 * JD-Core Version:    0.7.0.1
 */