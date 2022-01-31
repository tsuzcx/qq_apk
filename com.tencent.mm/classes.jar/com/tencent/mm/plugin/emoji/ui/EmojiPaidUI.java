package com.tencent.mm.plugin.emoji.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.emoji.a.a.a;
import com.tencent.mm.plugin.emoji.a.d;
import com.tencent.mm.plugin.emoji.f.d;
import com.tencent.mm.plugin.emoji.f.h;
import com.tencent.mm.plugin.emoji.model.f;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.util.ArrayList;

public class EmojiPaidUI
  extends BaseEmojiStoreUI
{
  private com.tencent.mm.plugin.emoji.f.h[] jdv;
  
  protected final void a(com.tencent.mm.plugin.emoji.f.h paramh) {}
  
  public final void a(String paramString, l paraml)
  {
    if ((paramString != null) && (paramString.equals("event_update_group")))
    {
      aIU();
      cD(131074, 50);
    }
  }
  
  protected final void a(boolean paramBoolean1, f paramf, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramf != null) && (paramBoolean1) && (this.iYq != null)) {
      this.iYq.b(paramf);
    }
    if ((this.iYq == null) || (paramf == null) || (paramf.iYg <= 0))
    {
      this.hrf.setVisibility(0);
      this.jbl.setText(f.h.emoji_no_play_history);
      this.Nn.setVisibility(8);
      return;
    }
    this.hrf.setVisibility(8);
    this.Nn.setVisibility(0);
  }
  
  protected final boolean aIB()
  {
    return false;
  }
  
  protected final int aIE()
  {
    return 2;
  }
  
  protected final int aIv()
  {
    return 10;
  }
  
  protected final int aIw()
  {
    return 6;
  }
  
  protected final a aIx()
  {
    return new d(this.mController.uMN);
  }
  
  protected final void aIz() {}
  
  protected final int ak(byte[] paramArrayOfByte)
  {
    return super.ak(paramArrayOfByte);
  }
  
  protected final void initView()
  {
    setMMTitle(f.h.emoji_paid);
    if (q.Gv()) {
      addIconOptionMenu(0, f.d.mm_title_btn_menu, new EmojiPaidUI.1(this));
    }
    super.initView();
    this.hrf.setVisibility(8);
    this.Nn.setVisibility(8);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    y.i("MicroMsg.emoji.EmojiPaidUI", "onActivityResult . requestCode:" + paramInt1 + "  resultCode:" + paramInt2);
    aIJ();
    String str = "";
    if (paramIntent != null)
    {
      paramInt1 = paramIntent.getIntExtra("key_err_code", 0);
      y.w("MicroMsg.emoji.EmojiPaidUI", "errCode:" + paramInt1);
      str = paramIntent.getStringExtra("key_err_msg");
      y.w("MicroMsg.emoji.EmojiPaidUI", "errMsg:" + str);
    }
    for (;;)
    {
      if (paramInt2 == -1)
      {
        if ((paramIntent != null) && (paramInt1 == 0))
        {
          paramIntent = paramIntent.getStringArrayListExtra("key_response_product_ids");
          if ((paramIntent != null) && (paramIntent.size() > 0))
          {
            this.jbp = null;
            this.jbn = -1;
            x(false, false);
            g.DP().Dz().o(208900, Boolean.valueOf(true));
            Toast.makeText(this, f.h.emoji_restore_success, 0).show();
            return;
          }
          Toast.makeText(this, str, 0).show();
          return;
        }
        Toast.makeText(this, str, 0).show();
        return;
      }
      Toast.makeText(this, f.h.emoji_restore_failed, 0).show();
      return;
      paramInt1 = 0;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.report.service.h.nFQ.f(12740, new Object[] { Integer.valueOf(4), "", "", "", Integer.valueOf(10), Integer.valueOf(10) });
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if ((this.jdv != null) && (this.jdv.length > 0))
    {
      int i = 0;
      while (i < this.jdv.length)
      {
        g.DO().dJT.c(this.jdv[i]);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiPaidUI
 * JD-Core Version:    0.7.0.1
 */