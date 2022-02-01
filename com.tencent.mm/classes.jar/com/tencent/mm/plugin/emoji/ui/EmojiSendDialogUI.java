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
import com.tencent.mm.pluginsdk.a.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.o;
import java.util.Iterator;
import java.util.List;

public class EmojiSendDialogUI
  extends MMBaseActivity
  implements com.tencent.mm.ak.f
{
  private String emojiPath;
  private EmojiInfo glt;
  private boolean pQe = false;
  
  private void acP(String paramString)
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
  
  private void cjt()
  {
    AppMethodBeat.i(108963);
    ae.i("MicroMsg.EmojiSendDialogUI", "select contact");
    Intent localIntent = new Intent();
    localIntent.putExtra("Select_Conv_Type", 3);
    localIntent.putExtra("select_is_ret", true);
    localIntent.putExtra("mutil_select_is_ret", true);
    localIntent.putExtra("Retr_Msg_Type", 5);
    if (this.pQe) {
      localIntent.putExtra("Retr_Msg_thumb_path", this.glt.field_md5);
    }
    for (;;)
    {
      localIntent.putExtra("emoji_activity_id", this.glt.field_activityid);
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
      ae.i("MicroMsg.EmojiSendDialogUI", "select contact result");
      localObject1 = paramIntent.getStringExtra("Select_Conv_User");
      str = paramIntent.getStringExtra("custom_send_text");
      paramIntent = k.getEmojiStorageMgr().JfU.aWl(this.glt.Lj());
      if (paramIntent != null) {
        break label269;
      }
      localObject2 = a.gsI;
      localObject2 = EmojiLogic.R(a.agD(), this.glt.field_groupId, this.glt.Lj());
      if (!o.fB((String)localObject2)) {
        break label269;
      }
      if (u.aRG((String)localObject2))
      {
        paramInt1 = EmojiInfo.OAc;
        paramIntent = this.glt;
        paramIntent.field_catalog = EmojiInfo.OzU;
        paramIntent.field_type = paramInt1;
        paramIntent.field_size = ((int)o.aZR((String)localObject2));
        paramIntent.field_temp = 1;
        paramIntent = k.getEmojiStorageMgr().JfU.I(paramIntent);
      }
    }
    label261:
    label269:
    for (;;)
    {
      localObject1 = bu.U(bu.bI((String)localObject1, "").split(",")).iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          if (paramIntent != null)
          {
            k.cig().a((String)localObject2, paramIntent, null);
            if (!bu.isNullOrNil(str))
            {
              com.tencent.mm.plugin.messenger.a.g.doC().hW(str, (String)localObject2);
              continue;
              paramInt1 = EmojiInfo.OAb;
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
    com.tencent.mm.kernel.g.ajQ().gDv.a(423, this);
    this.glt = ((EmojiInfo)getIntent().getParcelableExtra("emoji_info"));
    paramBundle = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().acj(this.glt.field_md5);
    if (paramBundle != null)
    {
      this.glt = paramBundle;
      this.pQe = true;
    }
    paramBundle = a.gsI;
    this.emojiPath = EmojiLogic.R(a.agD(), this.glt.field_groupId, this.glt.Lj());
    paramBundle = k.getEmojiStorageMgr().JfU.aWl(this.glt.field_md5);
    if (((paramBundle != null) && (paramBundle.field_catalog == EmojiInfo.OAa)) || (bu.isNullOrNil(this.glt.field_groupId)) || (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().acn(this.glt.field_groupId))) {
      ae.i("MicroMsg.EmojiSendDialogUI", "no need exchange %s %s", new Object[] { this.glt.field_md5, this.glt.field_groupId });
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        cjt();
      }
      AppMethodBeat.o(108962);
      return;
      paramBundle = new com.tencent.mm.plugin.emoji.f.g(this.glt.field_groupId, (byte)0);
      com.tencent.mm.kernel.g.ajQ().gDv.a(paramBundle, 0);
      ae.i("MicroMsg.EmojiSendDialogUI", "do exchange %s %s", new Object[] { this.glt.field_md5, this.glt.field_groupId });
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(108965);
    super.onDestroy();
    com.tencent.mm.kernel.g.ajQ().gDv.b(423, this);
    AppMethodBeat.o(108965);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(108964);
    if (paramn.getType() == 423)
    {
      paramString = (com.tencent.mm.plugin.emoji.f.g)paramn;
      ae.i("MicroMsg.EmojiSendDialogUI", "exchange end %s", new Object[] { paramString.pMk });
      if (bu.isNullOrNil(this.glt.field_groupId))
      {
        cjt();
        AppMethodBeat.o(108964);
        return;
      }
      if (this.glt.field_groupId.equalsIgnoreCase(paramString.pMk))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          cjt();
          AppMethodBeat.o(108964);
          return;
        }
        if (paramInt2 == 4)
        {
          acP(getString(2131758298));
          AppMethodBeat.o(108964);
          return;
        }
        acP(getString(2131758297));
        AppMethodBeat.o(108964);
        return;
      }
      ae.i("MicroMsg.EmojiSendDialogUI", "no the same product ID");
    }
    AppMethodBeat.o(108964);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiSendDialogUI
 * JD-Core Version:    0.7.0.1
 */