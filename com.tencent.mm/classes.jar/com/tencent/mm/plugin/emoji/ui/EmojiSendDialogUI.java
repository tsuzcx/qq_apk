package com.tencent.mm.plugin.emoji.ui;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.f.b.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.s;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.vfs.y;
import java.util.Iterator;
import java.util.List;

public class EmojiSendDialogUI
  extends MMBaseActivity
{
  private String emojiPath;
  private EmojiInfo mgK;
  private String token;
  private boolean xSH = false;
  
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
      paramIntent = s.getEmojiStorageMgr().adju.bza(this.mgK.getMd5());
      if (paramIntent != null) {
        break label264;
      }
      str2 = EmojiLogic.W(com.tencent.mm.plugin.emoji.g.d.bzQ(), this.mgK.field_groupId, this.mgK.getMd5());
      if (!y.ZC(str2)) {
        break label264;
      }
      if (ImgUtil.isGif(str2))
      {
        paramInt1 = EmojiInfo.aklO;
        paramIntent = this.mgK;
        paramIntent.field_catalog = EmojiInfo.aklG;
        paramIntent.field_type = paramInt1;
        paramIntent.field_size = ((int)y.bEl(str2));
        paramIntent.field_temp = 1;
        paramIntent = s.getEmojiStorageMgr().adju.K(paramIntent);
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
            s.dAl().a(str2, paramIntent, null);
            if (!Util.isNullOrNil(str1))
            {
              g.gaI().ke(str1, str2);
              continue;
              paramInt1 = EmojiInfo.aklN;
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
    this.mgK = ((EmojiInfo)getIntent().getParcelableExtra("emoji_info"));
    this.token = getIntent().getStringExtra("ad_uxInfo");
    paramBundle = ((com.tencent.mm.plugin.emoji.c.d)h.az(com.tencent.mm.plugin.emoji.c.d.class)).getProvider().aof(this.mgK.field_md5);
    if (paramBundle != null)
    {
      this.mgK = paramBundle;
      this.xSH = true;
    }
    this.emojiPath = EmojiLogic.W(com.tencent.mm.plugin.emoji.g.d.bzQ(), this.mgK.field_groupId, this.mgK.getMd5());
    new com.tencent.mm.emoji.f.e(this, this.mgK, this.token, new b.a()
    {
      public final void onResult(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(270324);
        if (paramAnonymousBoolean)
        {
          EmojiSendDialogUI.a(EmojiSendDialogUI.this);
          AppMethodBeat.o(270324);
          return;
        }
        EmojiSendDialogUI.this.setResult(0);
        EmojiSendDialogUI.this.finish();
        AppMethodBeat.o(270324);
      }
    });
    AppMethodBeat.o(108962);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(108965);
    super.onDestroy();
    AppMethodBeat.o(108965);
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