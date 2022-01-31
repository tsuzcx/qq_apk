package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.as.o;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.f.e;
import com.tencent.mm.plugin.emoji.f.f;
import com.tencent.mm.plugin.emoji.f.h;
import com.tencent.mm.plugin.emoji.f.n;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.protocal.c.afg;
import com.tencent.mm.protocal.c.afk;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.l;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.MMLoadScrollView.a;

public class EmojiStoreV2RewardDetailUI
  extends MMActivity
  implements AbsListView.OnScrollListener, f
{
  private ListView Nn;
  private View VH;
  private String iZE;
  private String iZs;
  private boolean isLoading = false;
  private int jbn = -1;
  private afk jdM;
  private String jgY;
  private String jgZ;
  private ah jge = new EmojiStoreV2RewardDetailUI.1(this);
  private ImageView jha;
  private TextView jhb;
  private TextView jhc;
  private TextView jhd;
  private View jhe;
  private View jhf;
  private EmojiStoreV2RewardDetailUI.a jhg;
  private afg jhh;
  private byte[] jhi;
  private n jhj;
  private MMLoadScrollView.a jhk = new EmojiStoreV2RewardDetailUI.2(this);
  
  private void aJB()
  {
    this.jhj = new n(this.iZs, this.jhi);
    g.DO().dJT.a(this.jhj, 0);
  }
  
  private void fm(boolean paramBoolean)
  {
    if ((!this.isLoading) && (this.jbn != 0))
    {
      aJB();
      this.isLoading = true;
      if (paramBoolean) {
        this.jge.sendEmptyMessageDelayed(1002, 200L);
      }
    }
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return f.f.emoji_store_v2_reward_detail_ui;
  }
  
  protected final void initView()
  {
    setMMTitle(f.h.emoji_store_reward_detail);
    setBackBtn(new EmojiStoreV2RewardDetailUI.3(this));
    this.VH = com.tencent.mm.ui.y.gt(this.mController.uMN).inflate(f.f.emoji_store_v2_reward_header_bar, null);
    this.jha = ((ImageView)this.VH.findViewById(f.e.designer_icon));
    this.jhb = ((TextView)this.VH.findViewById(f.e.product_name));
    this.jhc = ((TextView)this.VH.findViewById(f.e.designer_name));
    this.jhd = ((TextView)this.VH.findViewById(f.e.reward_count));
    this.jhe = findViewById(f.e.root);
    this.Nn = ((ListView)findViewById(f.e.header_gridview));
    this.jhf = com.tencent.mm.ui.y.gt(this.mController.uMN).inflate(f.f.emoji_store_load_more, null);
    this.jhf.setVisibility(8);
    this.Nn.addHeaderView(this.VH);
    this.Nn.addFooterView(this.jhf);
    this.jhg = new EmojiStoreV2RewardDetailUI.a(this, this);
    this.Nn.setAdapter(this.jhg);
    this.Nn.setOnScrollListener(this);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.iZs = getIntent().getStringExtra("extra_id");
    this.iZE = getIntent().getStringExtra("extra_name");
    this.jgY = getIntent().getStringExtra("extra_iconurl");
    this.jgZ = getIntent().getStringExtra("name");
    initView();
    this.jdM = i.getEmojiStorageMgr().uBg.acJ(this.iZs);
    aJB();
    o.ON().a(this.jgY, this.jha, e.cJ(this.iZs, this.jgY));
    this.jhb.setText(this.iZE);
    this.jhc.setText(this.jgZ);
    if (this.jhh != null)
    {
      this.jhg.Q(this.jhh.tcX);
      this.jhg.jhm = true;
    }
    if (this.jdM != null) {
      this.jhd.setText(getString(f.h.emoji_store_reward_info, new Object[] { Integer.valueOf(this.jdM.tcW) }));
    }
    g.DO().dJT.a(299, this);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    g.DO().dJT.b(299, this);
    o.ON().bR(0);
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    int i = 1;
    this.isLoading = false;
    if (this.jhf != null)
    {
      this.jhf.setVisibility(8);
      this.jge.removeMessages(1002);
      this.jge.sendEmptyMessageDelayed(1001, 200L);
    }
    switch (paramm.getType())
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          paramString = (n)paramm;
          if ((paramInt1 != 0) && (paramInt1 != 4)) {
            break label307;
          }
          this.jhi = paramString.iZW;
          if (paramInt2 != 0) {
            break;
          }
          this.jbn = 0;
        } while (paramString.aIh() == null);
        this.jhg.Q(paramString.aIh().tcX);
        return;
        if (paramInt2 != 2) {
          break;
        }
        this.jbn = 2;
        if (paramString.aIh() != null) {
          this.jhg.Q(paramString.aIh().tcX);
        }
        paramInt1 = i;
        if (this.jhg != null)
        {
          paramInt1 = i;
          if (this.VH != null)
          {
            paramString = this.jhg;
            paramInt1 = paramString.jfV;
            paramInt2 = paramString.hrb + paramInt1;
            int j = this.VH.getHeight();
            int k = com.tencent.mm.cb.a.fk(this);
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "item:%d header:%d window:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(j), Integer.valueOf(k) });
            paramInt1 = i;
            if (k > paramInt2 * this.jhg.getCount() + j) {
              paramInt1 = 0;
            }
          }
        }
      } while (paramInt1 != 0);
      fm(false);
      return;
    } while (paramInt2 != 3);
    this.jbn = 1;
    this.jhi = null;
    this.jhg.jhm = true;
    fm(false);
    return;
    label307:
    com.tencent.mm.sdk.platformtools.y.w("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "unknow errType:%d", new Object[] { Integer.valueOf(paramInt1) });
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1))
    {
      if ((this.jbn == 0) || (this.isLoading)) {
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "No More List.");
      }
    }
    else {
      return;
    }
    fm(true);
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "[onScrollStateChanged] loadMoreData.");
    o.ON().bR(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardDetailUI
 * JD-Core Version:    0.7.0.1
 */