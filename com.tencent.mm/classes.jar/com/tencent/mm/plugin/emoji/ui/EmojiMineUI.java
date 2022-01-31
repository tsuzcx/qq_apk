package com.tencent.mm.plugin.emoji.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.a.c;
import com.tencent.mm.plugin.emoji.f.d;
import com.tencent.mm.plugin.emoji.f.e;
import com.tencent.mm.plugin.emoji.f.f;
import com.tencent.mm.plugin.emoji.f.h;
import com.tencent.mm.plugin.emoji.model.f;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.afi;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

public class EmojiMineUI
  extends BaseEmojiStoreUI
  implements View.OnClickListener
{
  private final String TAG = "MicroMsg.emoji.EmojiMineUI";
  private View jcC;
  private TextView jcD;
  private ViewGroup jdp;
  private ViewGroup jdq;
  private ViewGroup jdr;
  private ViewGroup jds;
  private TextView jdt;
  
  public final void a(String paramString, l paraml)
  {
    if ((paramString != null) && (paramString.equals("event_update_group")))
    {
      aIU();
      cD(131074, 50);
    }
  }
  
  protected final void a(boolean paramBoolean1, f paramf, boolean paramBoolean2, boolean paramBoolean3) {}
  
  protected final boolean aIA()
  {
    return false;
  }
  
  protected final boolean aIB()
  {
    return false;
  }
  
  protected final int aIE()
  {
    return 8;
  }
  
  protected final boolean aII()
  {
    boolean bool = true;
    if (this.iYq != null)
    {
      this.iYq.notifyDataSetChanged();
      this.jbG = true;
      this.hrf.setVisibility(8);
    }
    for (;;)
    {
      aIM();
      return bool;
      bool = false;
    }
  }
  
  protected final boolean aIK()
  {
    return true;
  }
  
  protected final boolean aIL()
  {
    return false;
  }
  
  public final void aIM()
  {
    if (this.jds != null)
    {
      if ((this.iYq != null) && (!this.iYq.isEmpty())) {
        this.jdt.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.jdt.setVisibility(8);
  }
  
  protected final int aIv()
  {
    return 24;
  }
  
  protected final int aIw()
  {
    return 7;
  }
  
  protected final com.tencent.mm.plugin.emoji.a.a.a aIx()
  {
    return new c(this.mController.uMN);
  }
  
  protected final void aIy()
  {
    this.jds = ((ViewGroup)View.inflate(this.mController.uMN, f.f.emoji_mine_header, null));
    this.jdt = ((TextView)this.jds.findViewById(f.e.title_add_from_store));
    this.jdt.setText(f.h.settings_emoji_use_tip);
    this.jdt.setVisibility(8);
    this.Nn.addHeaderView(this.jds, null, false);
    this.jdp = ((ViewGroup)View.inflate(this.mController.uMN, f.f.emoji_mine_footer, null));
    this.jdq = ((ViewGroup)this.jds.findViewById(f.e.mine_more_custom));
    ((TextView)this.jdq.findViewById(16908310)).setText(f.h.emoji_custom);
    this.jdr = ((ViewGroup)this.jdp.findViewById(f.e.mine_more_paid));
    ((TextView)this.jdr.findViewById(16908310)).setText(f.h.emoji_paid);
    this.jdr.findViewById(f.e.content).setBackgroundResource(f.d.comm_list_item_selector_no_divider);
    this.jdq.setOnClickListener(this);
    this.jdr.setOnClickListener(this);
    this.Nn.addFooterView(this.jdp, null, false);
  }
  
  protected final int ak(byte[] paramArrayOfByte)
  {
    return super.ak(paramArrayOfByte);
  }
  
  protected final void c(afi paramafi)
  {
    super.c(paramafi);
  }
  
  protected final int getLayoutId()
  {
    return f.f.emoji_store_mine;
  }
  
  public final void h(String paramString1, int paramInt1, int paramInt2, String paramString2) {}
  
  public final void i(Message paramMessage)
  {
    if ((paramMessage.what == 8001) && (this.jcC != null)) {
      this.jcC.setVisibility(8);
    }
    super.i(paramMessage);
  }
  
  protected final void initView()
  {
    setMMTitle(f.h.settings_emoji_mine);
    super.initView();
    this.jcC = findViewById(f.e.sync_view);
    this.jcD = ((TextView)this.jcC.findViewById(f.e.sync_status));
    this.jcD.setText(f.h.emoji_sync_syncing_in_wifi);
    if (i.aHQ().jan.jaD)
    {
      i.aHQ();
      if (BKGLoaderManager.aIq())
      {
        this.jcC.setVisibility(0);
        cD(8001, 3000);
      }
    }
    for (;;)
    {
      this.Nn.setOnScrollListener(null);
      return;
      this.jcC.setVisibility(8);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdq)
    {
      paramView = new Intent();
      paramView.setClass(this, EmojiCustomUI.class);
      startActivity(paramView);
    }
    while (paramView != this.jdr) {
      return;
    }
    paramView = new Intent();
    paramView.setClass(this, EmojiPaidUI.class);
    startActivity(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    long l = System.currentTimeMillis();
    super.onCreate(paramBundle);
    int i = getIntent().getIntExtra("10931", 0);
    h.nFQ.aC(10931, String.valueOf(i));
    y.i("MicroMsg.emoji.EmojiMineUI", "jacks statistics enter Emoji Setting UI:%d", new Object[] { Integer.valueOf(i) });
    setBackBtn(new EmojiMineUI.1(this));
    addTextOptionMenu(0, getString(f.h.emoji_sequence), new EmojiMineUI.2(this));
    if (!((Boolean)g.DP().Dz().get(ac.a.unZ, Boolean.valueOf(false))).booleanValue()) {
      com.tencent.mm.plugin.emoji.c.a.fa(true);
    }
    h.nFQ.a(406L, 3L, 1L, false);
    h.nFQ.a(406L, 5L, System.currentTimeMillis() - l, false);
    h.nFQ.f(12740, new Object[] { Integer.valueOf(4), "", "", "", Integer.valueOf(24), Integer.valueOf(24) });
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    super.onItemClick(paramAdapterView, paramView, paramInt - 1, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiMineUI
 * JD-Core Version:    0.7.0.1
 */